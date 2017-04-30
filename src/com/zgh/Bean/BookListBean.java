package com.zgh.Bean;

import java.util.ArrayList;

import com.zgh.Dao.*;
public class BookListBean {
	private ArrayList<BookBean> booklist;
	private int listsize;
	
	public BookListBean(){
		BookDao bookdao=new BookDao();
		booklist=bookdao.selectBook();
		listsize=booklist.size();
	}
	
	public void setBooklist(){
		BookDao bookdao=new BookDao();
		this.booklist=bookdao.selectBook();
	}
	public void setListsize(){
		this.listsize=booklist.size();
	}
	public ArrayList<BookBean> getBooklist(){return this.booklist;}
	public int getListsize(){return this.listsize;}
}
