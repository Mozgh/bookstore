package com.zgh.Dao;

import java.sql.*;
import com.zgh.Bean.*;
import com.zgh.Dao.*;
public class UserDao {
	private String sql=null;
	private ResultSet result=null;
	public String getSql(){return this.sql;}
	public ResultSet getResult()	{return this.result;}
	//添加用户信息到数据库中
	public boolean addUser(UserBean user){
		sql="insert into user values(?,?,?,?)";
		DBConnect db=new DBConnect(sql);
		try {
			db.st.setString(1, user.getId());
			db.st.setString(2, user.getName());
			db.st.setString(3, user.getGender());
			db.st.setString(2, user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			db.st.executeUpdate();
			db.Close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			db.Close();
			return false;
		}
	}
	//通过用户ID查询用户信息
	@SuppressWarnings("null")
	public UserBean selectUser(String id){
		UserBean user=new UserBean();
		this.sql="select * from user where id=?";
		DBConnect db=new DBConnect(sql);
		try {
			if(db!=null)
			{
				db.st.setString(1, "0001");
				result=db.st.executeQuery();
				while(result!=null&&result.next()){
					user.setId(result.getString("id"));
					user.setName(result.getString("name"));
					user.setGender(result.getString("gender"));
					user.setPassword(result.getString("password"));
				}
			}
			db.Close();
		} catch (SQLException e) {
			db.Close();
			return null;
		}
		return user;
	}
	
}
