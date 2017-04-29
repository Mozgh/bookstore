package com.zgh.Dao;

import java.sql.*;
import java.util.ArrayList;

import com.zgh.Bean.*;
public class BookDao{
	private String sql=null;
	private ResultSet result=null;
	public String getSql()	{return this.sql;}
	public ResultSet getResult()	{return this.result;}
	//查询结果填入BookBean实例中
	public BookBean setBook(ResultSet rst){
		BookBean book=new BookBean();
		try {
			book.setIsbn(result.getString("isbn"));
			book.setName(result.getString("name"));
			book.setIntro(result.getString("intro"));
			book.setPrice(result.getDouble("price"));
			book.setCount(result.getInt("count"));
			book.setImage(result.getString("image"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	//添加新商品到数据库中
	public boolean addBook(BookBean book){
		boolean rs=false;
		int row=0;
		sql="insert into book values(?,?,?,?,?,?)";
		DBConnect db=new DBConnect(sql);
		try {
			db.st.setString(1, book.getIsbn());
			db.st.setString(2, book.getName());
			db.st.setString(3, book.getIntro());
			db.st.setDouble(4, book.getPrice());
			db.st.setInt(5, book.getCount());
			db.st.setString(6, book.getImage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			row=db.st.executeUpdate();
			if(row!=0)
				rs=true;
			db.Close();
		} catch (SQLException e) {
			db.Close();
			e.printStackTrace();
		}
		return rs;
	}
	//根据isbn查询图书
	public BookBean selectBook(String isbn){
		BookBean book=new BookBean();
		this.sql="select * from book where isbn=?";
		DBConnect db=new DBConnect(sql);
		try {
			db.st.setString(1,isbn);
			result=db.st.executeQuery();
			while(result.next()){
				book=setBook(result);
			}
			db.Close();
		} catch (SQLException e) {
			db.Close();
			e.printStackTrace();
		}
		return book;
	}
	//查询全部图书
	public ArrayList<BookBean> selectBook(){
		ArrayList<BookBean> books=new ArrayList<BookBean>();
		this.sql="select * from book";
		DBConnect db=new DBConnect(sql);
		try {
			result=db.st.executeQuery();
			while(result.next()){
				BookBean book=new BookBean();
				book=setBook(result);
				books.add(book);
			}
			db.Close();
		} catch (SQLException e) {
			db.Close();
			e.printStackTrace();
		}
		return books;
	}
	//修改图书数量
	public boolean updateBook(String isbn,int count){
		boolean rs=false;
		int row=0;
		this.sql="update book set count=? where isbn=?";
		DBConnect db=new DBConnect(sql);
		try {
			db.st.setInt(1, count);
			db.st.setString(2, isbn);
			row=db.st.executeUpdate();
			if(row!=0)
			{
				rs=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.Close();
		return rs;
	}
	//删除图书
	public boolean deleteBook(String isbn){
		boolean rs=false;
		int row=0;
		this.sql="delete from book where isbn=?";
		DBConnect db=new DBConnect(sql);
		try {
			db.st.setString(1, isbn);
			row=db.st.executeUpdate();
			if(row!=0)
			{
				rs=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.Close();
		return rs;
	}
}
