package com.zgh.Servlet;

import com.zgh.Bean.*;
import com.zgh.Dao.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookisbn=request.getParameter("bookisbn");
		request.setAttribute("bookisbn", bookisbn);
		BookDao bookdao=new BookDao();
		BookBean book=bookdao.selectBook(bookisbn);
		request.setAttribute("book", book);
		RequestDispatcher rd=request.getRequestDispatcher("/UpdateBook.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String newintro=request.getParameter("newintro");
		String newprice=request.getParameter("newprice");
		String newcount=request.getParameter("newcount");
		String bookisbn=request.getParameter("bookisbn");
		BookDao bookdao=new BookDao();
		BookBean book=bookdao.selectBook(bookisbn);
		int count=book.getCount();
		double price=book.getPrice();
		boolean result=false;
		if(newcount!=""){
			count=Integer.parseInt(newcount);
		}
		if(newprice!=""){
			price=Double.parseDouble(newprice);
		}
		if(newintro=="")
			newintro=book.getIntro();
		
		result=bookdao.updateBook(bookisbn, count, price, newintro);
		if(result)
			response.sendRedirect("/bookstore/Management.jsp");
		else
			response.sendRedirect("/bookstore/UpdateBook.jsp");
	}

}
