package com.zgh.Bean;

import java.util.ArrayList;
import com.zgh.Dao.BookDao;;

public class CartBean {
	private String userid;
	private String bookisbn;
	private BookBean book;
	private int count;
	private double cost;
	
	public CartBean(){};
	public CartBean(String id,String isbn,int count,double cost){
		this.userid=id;
		this.bookisbn=isbn;
		this.count=count;
		this.cost=cost;
	}
	
	public void setUserid(String id){
		this.userid=id;
	}
	public void setBookisbn(String isbn){
		this.bookisbn=isbn;
	}
	public void setBook(String isbn){
		BookDao bookdao=new BookDao();
		this.book=bookdao.selectBook(isbn);
	}
	public void setBook(BookBean book){
		this.book=book;
	}
	public void setCount(int count){
		this.count=count;
	}
	public void setCost(double cost){
		this.cost=cost;
	}
	
	public String getUserid()		{return this.userid;}
	public String getBookisbn()		{return this.bookisbn;}
	public BookBean getBook()			{return this.book;}
	public int getCount()			{return this.count;}
	public double getCost()			{return this.cost;}
	
}
