package com.zgh.Dao;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class DBConnect {
	String url="jdbc:mysql://localhost:3306/javaweb";
	String user="root";
	String password="Win@root";
	public java.sql.Connection conn=null;				//连接对象
	public PreparedStatement st=null;					//语句对象
	
	public DBConnect(String sql){
		try {
			Class.forName("com.mysql.jdbc.Driver");		//加载驱动
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(url,user,password);		//建立数据库连接
			st=conn.prepareStatement(sql);				//准备执行语句对象
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void Close(){
		try {
			this.st.close();							//关闭语句对象	
			this.conn.close();							//关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	}
