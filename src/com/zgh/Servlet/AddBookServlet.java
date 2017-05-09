package com.zgh.Servlet;

import com.zgh.Dao.*;
import com.zgh.Bean.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBook")
@MultipartConfig(location="E:\\study\\Java Web\\bookstore\\WebContent\\Image\\")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AddBook.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String isbn=request.getParameter("bookisbn");
		String name=request.getParameter("bookname");
		String intro=request.getParameter("bookintro");
		double price=Double.parseDouble(request.getParameter("bookprice"));
		int count=Integer.parseInt(request.getParameter("bookcount"));
		Part p=request.getPart("bookimage");
		String image="/Image/"+name+".jpg";
		if(p!=null)
			out.println(p.getName());
		//path为存储的图像的绝对路径
		String path="E:\\study\\Java Web\\bookstore\\WebContent\\Image\\"+name+".jpg";
		out.println(path);
		File f=new File(path);
		p.write(path);
		out.println("OK");
		BookDao bookdao=new BookDao();
		BookBean book=new BookBean(isbn,name,intro,price,count);
		bookdao.addBook(book);
		out.println("add success!");
		response.sendRedirect("/bookstore/Management.jsp");
	}

}
