package com.zgh.Bean;

public class UserBean {
	private String id;
	private String name;
	private String password;
	private String gender;
	
	public UserBean(){};
	UserBean(String i,String n,String p,String g){
		this.id=i;this.name=n;this.password=p;this.gender=g;
	}
	
	public void setId(String id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public String getId(){return this.id;}
	public String getName(){return this.name;}
	public String getPassword(){return this.password;}
	public String getGender(){return this.gender;}
}
