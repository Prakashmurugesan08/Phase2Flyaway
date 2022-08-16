package com.flyaway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.URegistration.dao.ChangePasswordAdmindao;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ChangePasswordAdmindao cdao = new ChangePasswordAdmindao();
	       
	       
	       PrintWriter out = response.getWriter();
	       
	       
	       String pass = request.getParameter("passwordEntered");
	       
	       
	       if (!AdminLogin.isLoggedIn){
	            out.println("You must login first");
	        }
	        else if (pass.equals("")){
	            out.println("Password can't be empty");
	        }
	        else if (AdminLogin.isLoggedIn && !pass.equals("")){
	             if(cdao.check(pass)){
	            	 out.println("Password changed. New Password is "+pass);
	            	 response.setContentType("text/html");
	            	 out.println();
	            	 
	            	 out.println("<a href=\"AdminLogin.jsp\">Admin Login</a>");
	             }
	            
	        }
	        else {
	            out.println("Sorry, Something went wrong");
	        }
	
	
	
      }
	}


