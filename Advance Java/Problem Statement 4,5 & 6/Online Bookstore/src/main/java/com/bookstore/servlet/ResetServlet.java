package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.userDao;
import com.bookstore.db.jdbcconnection;
import com.bookstore.entity.user;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ResetServlet
 */
@WebServlet("/ResetServlet")
public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetServlet() {
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
		PrintWriter out=response.getWriter();
		String email = request.getParameter("email");
		String user_name = request.getParameter("uname");
		
		userDao dao= new userDao(jdbcconnection.getConnection());
		
		user u = dao.resetPassword(email, user_name);
		
		if(u==null) {
			
			out.println("Invalid Details!!.. Try again");
			
			
			
			response.sendRedirect("ResetPassword.jsp");
			
			
		}
		else {
			//  success
			
			response.sendRedirect("SetPassword.jsp");
			
		}
		
		
		
		
	}
}
