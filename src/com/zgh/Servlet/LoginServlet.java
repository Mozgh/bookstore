package com.zgh.Servlet;

import com.zgh.Bean.*;
import com.zgh.Dao.*;

import sun.misc.UUDecoder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		out.println(id);
		out.println(password);
		
		UserDao u=new UserDao();
		UserBean user=new UserBean();
		user=u.selectUser(id);
		out.println(user.getId());
		out.println(user.getPassword());
//		out.println(user.getName());
//		out.println(user.getGender());
		
		if(user.getPassword().equals(password)){
			request.getSession().setAttribute("user", user);
//			ArrayList<BookBean> books=new ArrayList<BookBean>();
//			BookDao bookdao=new BookDao();
//			books=bookdao.selectBook();
//			request.getSession().setAttribute("books", books);
			RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");
			rd.forward(request, response);
		}
	}
}
