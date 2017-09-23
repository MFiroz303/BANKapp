package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.dao.UserDao;
import com.bridgeit.model.User;

/**
 * Servlet implementation class Rgeistration
 */

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	response.setContentType("text/html");  
    PrintWriter out=response.getWriter();  
 
    String fullName=request.getParameter("fullName");  
    String password=request.getParameter("password");  
    String email=request.getParameter("email");
    int phoneNo=Integer.parseInt(request.getParameter("phoneNo"));
    
    User user=new User();  
    user.setFullName(fullName);  
    user.setPassword(password);  
    user.setEmail(email);  
    user.setPhoneNo(phoneNo);  
      
    int result=UserDao.save(user);  
    if(result>0){  
        out.print("<p> Account created successfully!</p>");  
       request.getRequestDispatcher("homepage").include(request, response);   
        response.sendRedirect("loginpage");
        
    }else{  
        out.println("<p>Sorry! unable to save record</p>"); 
        request.getRequestDispatcher("registration").include(request, response);  
    }  
      
    out.close();  
}  

}  