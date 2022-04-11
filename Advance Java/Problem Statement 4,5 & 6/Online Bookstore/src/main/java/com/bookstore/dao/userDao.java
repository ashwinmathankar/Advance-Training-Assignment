package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.entity.Books;
import com.bookstore.entity.Order;
import com.bookstore.entity.user;

public class userDao {
	
	private Connection con;

	public userDao(Connection con) {
		this.con = con;
	}
//	method to insert in database
	public boolean saveUser(user user) {
		boolean f=false;

		try {
			String query="insert into Users(first_name,address,email,user_name,password)values (?,?,?,?,?)";
			PreparedStatement pstmt	=this.con.prepareStatement(query);
			
			pstmt.setString(1,user.getFirst_name());
			pstmt.setString(2,user.getAddress());
			pstmt.setString(3,user.getEmail());
			pstmt.setString(4,user.getUname());
			pstmt.setString(5,user.getPass());
			
			pstmt.executeUpdate();
			f=true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}
	public user getUserByUnameAndPassword(String user_name, String password) 
	{
		user user = null;
		try 
		{
			String query="select * from user where user_name=? and password=?";
			
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, user_name);
			psmt.setString(2, password);
			
			ResultSet set=psmt.executeQuery();
			
			if(set.next()) 
			{
				user = new user();
				//data from db
				user.setFirst_name(set.getString("fname"));
				//set to user object
				user.setEmail(set.getString("address"));
				user.setEmail(set.getString("email"));
				user.setUname(user_name);
				user.setPass(set.getString("password"));
				user.setRegdate(set.getDate("reg_date"));
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return user;
	}
	
	public user resetPassword(String email, String user_name) {
		user user=null;
		try {
			String query="select * from users where email=? and user_name=?";
			
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, email);
			psmt.setString(2, user_name);
			
			ResultSet set=psmt.executeQuery();
			
			if(set.next()) {
				user = new user();
				//data from db
				user.setFirst_name(set.getString("first_name"));
				//set to user object
				user.setEmail(set.getString("address"));
				user.setEmail(set.getString("email"));
				user.setUname(user_name);
				user.setPass(set.getString("password"));
				user.setRegdate(set.getTimestamp("reg_date"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public int setPassword(String password) throws SQLException {
			
			try {
			String query="update users set password=? where user_name=?";
			user user=new user();
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, password);
			psmt.setString(2,(user.getUname()));
			
			return psmt.executeUpdate();
			}
			catch(Exception e) {
				e.getMessage();
			}
			return 0;
	}
	
	public boolean order(Order order) {
		boolean f=false;

		try {
			String query="insert into orders(address,mobileno,name,Quantity)values (?,?,?,?)";
			PreparedStatement pstmt	=this.con.prepareStatement(query);
			pstmt.setString(1,order.getAddress());
			pstmt.setInt(2,order.getMobileno());
			pstmt.setString(3,order.getName());
			pstmt.setInt(4,order.getQuantity());
			
			pstmt.executeUpdate();
			f=true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public Books getBookDetailsById(String Book_id) throws SQLException {
			
			Books book=null;
			
			String query="Select * from books where book_id=?";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1,Book_id);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()){
				book=new Books();
				book.setBook_id(rs.getString(1));
				book.setBook_name(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getDouble(4));
				
			}
			
			return book;
			
		}

}
