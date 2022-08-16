package com.flyaway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.URegistration.dao.AdminLogindao;
import com.URegistration.dao.Logindao;


/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static boolean isLoggedIn =false;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		PrintWriter out = response.getWriter();
		
		//out.println(email+" "+pass);
		
		
		AdminLogindao logindao = new AdminLogindao();
		
		
		
		
		if(logindao.check(email,pass)){
			
//			HttpSession session = request.getSession();
	//		
	//	session.setAttribute("username", uname);
	//		out.println("User Logged In Successfully");
			
			   isLoggedIn = true;
	            out.println("You have LoggedIn");
	            response.sendRedirect("AdminDashboard.jsp");
			
		}
		else{
			    isLoggedIn = false;
	            out.println("Login Failed : Incorrect email or Password");
	            
	            

		}
		 
		 
		
		
	}
	

	}


