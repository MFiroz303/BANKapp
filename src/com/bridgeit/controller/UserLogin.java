package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeit.dao.UserDao;

/**
 * Servlet implementation class UserLogin
 */
// @WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
      
		
		UserDao userDao = new UserDao();
		String name=userDao.ValidateLogin(email, password);
		
		System.out.println(name);

		if (name!="false") {
		//	out.print("<p>Login successfully!</p>");
			
			// RequestDispatcher rs =
			// request.getRequestDispatcher("NewFile2.jsp");
			// rd.forward(request, response);
			
		//	if (name != null) {
				HttpSession session = request.getSession();	
			    session.setAttribute("name",name);
				//request.getRequestDispatcher("Home.jsp").include(request, response);
			//	out.print("Hello, " + name + " Welcome to Profile");
			   // RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
			   // dispatcher.forward(request, response);
			    response.sendRedirect("homepage");
			

		} else {
			out.println(
					"<p>Username or Password incorrect<p>");
			//request.getRequestDispatcher("Login.jsp").include(request, response);
			response.sendRedirect("loginpage");
		}
		out.close();
	}
}
