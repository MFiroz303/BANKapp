package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;

import com.bridgeit.dao.UserDao;

/**
 * Servlet implementation class CityDetails
 */
public class CityDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			              throws ServletException, IOException {
						
					//	  System.out.println("Inside the details page");	
		                  response.setContentType("text/html");
		                  PrintWriter out=response.getWriter();
		                  
		                  HttpSession session = request.getSession();
		                  String city=request.getParameter("city");
		                  String name=(String) session.getAttribute("name");
		                   UserDao userdao=new UserDao();
		                   int value= userdao.userid(name);
		             //   int userid=Integer.parseInt(request.getParameter("user_id"));
		                
		                  
		                
		                  JSONArray result=userdao.display(city,value);
		          	             out.print(result.toJSONString());
		          		         out.close();  
		          		 }  

}
