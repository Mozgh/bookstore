package com.zgh.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
@WebFilter(
		filterName="AuthorityFilter",
		urlPatterns={"/*"},
		initParams={
				@WebInitParam(name="encoding",value="UTF-8"),
				@WebInitParam(name="loginPage",value="Login.jsp"),
				@WebInitParam(name="homePage",value="Home.jsp"),
				@WebInitParam(name="loginServlet",value="LoginServlet")
		})
public class AuthorityFilter implements Filter {
	private FilterConfig config;
	
    public AuthorityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		config=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String encoding=config.getInitParameter("encoding");
		String loginPage=config.getInitParameter("loginPage");
		String homePage=config.getInitParameter("homePage");
		String loginServlet=config.getInitParameter("loginServlet");
		
		request.setCharacterEncoding(encoding);
		HttpServletRequest hrequest=(HttpServletRequest)request;
		HttpSession session=hrequest.getSession(true);
		String requestPath=hrequest.getServletPath();
		
		if(session.getAttribute("user")==null&&(!requestPath.endsWith(loginPage))
				&&(!requestPath.endsWith(homePage))
				&&(!requestPath.endsWith(loginServlet))
				){
			request.getRequestDispatcher(loginPage).forward(request, response);
			return;
		}
//		else{
			chain.doFilter(request, response);
//		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		config=fConfig;
	}

}
