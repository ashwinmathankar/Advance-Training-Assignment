package com.bookstore.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class user {
	
	String first_name;
	String address;
	String email;
	String user_name;
	String password;
	Date reg_date;
	
	public user() {
	}
	public user(String first_name, String address, String email, String user_name, String password, Date reg_date) {
		this.first_name = first_name;
		this.address = address;
		this.email = email;
		this.user_name = user_name;
		this.password = password;
		this.reg_date = reg_date;
	}
	
	public user(String first_name, String address, String email, String user_name, String password) {
		super();
		this.first_name = first_name;
		this.address = address;
		this.email = email;
		this.user_name = user_name;
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUname() {
		return user_name;
	}
	public void setUname(String user_name) {
		this.user_name = user_name;
	}
	public String getPass() {
		return password;
	}
	public void setPass(String password) {
		this.password = password;
	}
	public Date getRegdate() {
		return reg_date;
	}
	public void setRegdate(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", address=" + address + ", email=" + email + ", user_name=" + user_name
				+ ", password=" + password + ", reg_date=" + reg_date + "]";
	}
	public void setRegdate(Timestamp timestamp) {
		// TODO Auto-generated method stub
		
	}

}
