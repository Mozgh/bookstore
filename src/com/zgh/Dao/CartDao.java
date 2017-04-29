package com.zgh.Dao;

import com.zgh.Bean.*;
import java.sql.*;
import java.util.ArrayList;
public class CartDao {
	private String sql=null;
	private ResultSet result=null;
	public String getSql()	{return this.sql;}
	public ResultSet getResult()	{return this.result;}
	
	//����ѯ���resultset����cartʵ��
	public CartBean setCart(ResultSet rst){
		CartBean cart=new CartBean();
		BookDao bookdao=new BookDao();
		try {
			cart.setBookisbn(rst.getString("bookisbn"));
			cart.setUserid(rst.getString("userid"));
			cart.setBook(bookdao.selectBook(rst.getString("bookisbn")));
			cart.setCount(rst.getInt("count"));
			cart.setCost(rst.getDouble("bookisbn"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cart;
	}
	//��ӵ����ﳵ
	public boolean addCart(String userid,String isbn, int count){
		boolean rs=false;
		int row=0;
		ResultSet rst=null;
		CartBean cart=new CartBean();
		BookDao bookdao=new BookDao();						//�½�bookdaoʵ��
		BookBean bookbean=bookdao.selectBook(isbn);			//�½�bookbeanʵ������ѯ�����е�isbn������book bean
		int count_have=bookbean.getCount();					//ͼ����
		if(count>count_have){
			return rs;										//��Ҫ���빺�ﳵ����Ŀ���ڿ�棬���빺�ﳵʧ�ܣ�����false
		}
		else {
			count_have=count_have-count;
			bookbean.setCount(count_have);					//����ͼ���棬����д��bookbean��
			bookdao.updateBook(isbn, count_have);			//�޸�ͼ����
			row=1;											//book���޸ĳɹ�
		}
		DBConnect db=null;
		sql="select * from cart where bookisbn=? and userid=?";
		db=new DBConnect(sql);
		try {
			db.st.setString(1, isbn);
			db.st.setString(2, userid);
			rst=db.st.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if(rst.next()){
				int old_count_int=0;
				double new_cost=0;
				
				try {
						old_count_int = rst.getInt("count");
						new_cost=Double.valueOf(rst.getDouble("cost"))+count*bookbean.getPrice();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(old_count_int!=0){
					int new_count=old_count_int+count;
					try {
						sql="update cart set count=?,cost=? where (userid=? and bookisbn=?)";
						db=new DBConnect(sql);
						db.st.setInt(1, new_count);
						db.st.setDouble(2, new_cost);
						db.st.setString(3, userid);
						db.st.setString(4, isbn);
						row=db.st.executeUpdate();
						if(row!=0)
						{
							rs=true;
							db.Close();
							return rs;
						}
						else return rs;
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}	
				}	
			}
			else{
				sql="insert into cart values(?,?,?,?)";
				db=new DBConnect(sql);
				try {
					db.st.setString(1,userid);
					db.st.setString(2, isbn);
					db.st.setInt(3, count);
					db.st.setDouble(4, bookbean.getPrice()*count);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					row=db.st.executeUpdate();
					if(row!=0){
						rs=true;
					}
					db.Close();
				} catch (SQLException e) {
					e.printStackTrace();
					db.Close();
				}
				return rs;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//��ѯ���ﳵ����
	public ArrayList<CartBean> selectCart(){
		ArrayList<CartBean> cartbooks=new ArrayList<CartBean>();
		sql="select * from cart";
		DBConnect db=new DBConnect(sql);
		try {
			result=db.st.executeQuery();
			while(result.next()){
				CartBean cart=new CartBean();
				cart=setCart(result);
				cartbooks.add(cart);
			}
			db.Close();
		} catch (SQLException e) {
			db.Close();
			e.printStackTrace();
		}
		return cartbooks;
	}
}
