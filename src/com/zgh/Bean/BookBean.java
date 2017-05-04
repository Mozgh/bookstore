package com.zgh.Bean;

public class BookBean {
	private String image_url="Image/";
	private String isbn;
	private String name;
	private String intro;
	private double price;
	private int count;
	private String image;
	
	public BookBean(){}
	public BookBean(String is,String n,String in,double p,int c){
		this.isbn=is;
		this.name=n;
		this.intro=in;
		this.price=p;
		this.count=c;
		this.image=image_url+n+".jpg";
	}
	
	public void setIsbn(String isbn){
		this.isbn=isbn;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setIntro(String intro){
		this.intro=intro;
	}
	public void setPrice(double price){
		this.price=price;
	}
	public void setCount(int count){
		this.count=count;
	}
	public void setImage(String url){
		this.image=url;
	}
	
	public String getIsbn()		{return isbn;}
	public String getName()		{return name;}
	public String getIntro()	{return intro;}
	public double getPrice()	{return price;}
	public int getCount()		{return count;}
	public String getImage()	{return image;}
}
