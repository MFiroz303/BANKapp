package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.dao.UserDao;
import com.bridgeit.model.Account;


/**
 * Servlet implementation class AccountDetails
 */
//@WebServlet("/AccountDetails")
public class AccountDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			              throws ServletException, IOException {
		
		     response.setContentType("text/html");
		     PrintWriter out = response.getWriter();
		     
		     String name=request.getParameter("uname");  
		     int accountNo=Integer.parseInt(request.getParameter("accountNo"));
		     String bankName=request.getParameter("bankName");  
		     String city=request.getParameter("city"); 
		  //   int userid=Integer.parseInt(request.getParameter("user_id"));
		     
		     Account account=new Account();  
		     account.setName(name);  
		     account.setBankNmae(bankName);  
		     account.setAccountNo(accountNo);  
		     account.setCity(city);
		     
		     UserDao userdao=new UserDao();
		     userdao.addDetails(account); 
	       //  user1.addDetails(account);  
		    // if(result>0){    
	        out.print("details inserted");
		         response.sendRedirect("Home.jsp");
		         
		      out.close();  
		// }  
	}

	}

//}
