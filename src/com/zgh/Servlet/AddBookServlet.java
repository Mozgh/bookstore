package com.zgh.Servlet;

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
		File f=new File("/bookstore/Image/"+name+".jpg");
		if(p!=null)
			out.println(p.getName());
		String path=this.getServletContext().getRealPath("/");
		
		String h=p.getHeader("content-disposition");
		String fname=h.substring(h.lastIndexOf("\\")+1,h.length()-1);
		p.write(path+"\\"+fname);	
		out.println(image);
		out.println(f.getName());
	}

}
