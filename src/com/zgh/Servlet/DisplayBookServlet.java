package com.zgh.Servlet;

import com.zgh.Dao.*;
import com.zgh.Bean.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayBookServlet
 */
@WebServlet("/displayBook")
public class DisplayBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		String bookisbn=request.getParameter("isbn");
		out.println(bookisbn);
		BookDao bookdao=new BookDao();
		BookBean bookbean=new BookBean();
		bookbean=bookdao.selectBook(bookisbn);
		
//		out.println(bookbean.getName());
//		out.println(bookbean.getCount());
//		out.println(bookbean.getIntro());
//		out.println(bookbean.getPrice());
//		out.println(bookbean.getImage());
		
		request.getSession().setAttribute("book", bookbean);
		
		response.sendRedirect("DisplayOneBook.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
