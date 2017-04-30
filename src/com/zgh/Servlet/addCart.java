package com.zgh.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zgh.Bean.*;
import com.zgh.Dao.*;

/**
 * Servlet implementation class addCart
 */
@WebServlet("/addCart")
public class addCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCart() {
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
		
		String buycount=request.getParameter("buycount");
		int count=Integer.parseInt(buycount);
		
		out.println(count);
		//从request作用于中获取book实体
		BookBean book=(BookBean) request.getAttribute("book");
		String isbn=book.getIsbn();
		UserBean user=(UserBean) request.getAttribute("user");
		String id=user.getId();
		
		out.println(isbn);
		out.println(id);
		
		CartDao cartdao=new CartDao();
		boolean rs=cartdao.addCart(id, isbn, count);
		if(rs){
			ArrayList<CartBean> cartlist=cartdao.selectCart(user.getId());
			request.getSession().setAttribute("cartlist", cartlist);
			response.sendRedirect("Cart.jsp");
		}
		else
			response.sendRedirect("DisplayOneBook.jsp");
	}

}
