package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Timestamp;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.*;

import com.bookstore.dao.userDao;
import com.bookstore.entity.*;
import com.bookstore.db.*;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		
			String first_name = request.getParameter("fname");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String user_name = request.getParameter("user_name");
			String password = request.getParameter("password");
//			user object save all data to user object
			
			user user=new user(first_name, address,  email,  user_name,  password);
//			user dao object
			userDao dao = new userDao(jdbcconnection.getConnection());
			if(dao.saveUser(user)) 
			{
				out.println("Register");
				response.sendRedirect("Login.jsp");

				
			}
			else {
				out.println("Registratin failed!!");
			}
		}

}
