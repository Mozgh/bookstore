package com.zgh.Dao;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class DBConnect {
	String url="jdbc:mysql://localhost:3306/javaweb";
	String user="root";
	String password="Win@root";
	public java.sql.Connection conn=null;				//���Ӷ���
	public PreparedStatement st=null;					//������
	
	public DBConnect(String sql){
		try {
			Class.forName("com.mysql.jdbc.Driver");		//��������
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(url,user,password);		//�������ݿ�����
			st=conn.prepareStatement(sql);				//׼��ִ��������
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void Close(){
		try {
			this.st.close();							//�ر�������	
			this.conn.close();							//�ر�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	}
