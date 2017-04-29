package com.zgh.Dao;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {
	DataSource dataSource;
	
	public BaseDao(){
		try {
			Context context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/bookstoreDB");
		} catch (NamingException e) {
			System.out.println("Exception:"+e);
		}
	}
	
	//返回一个连接对象
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
}
