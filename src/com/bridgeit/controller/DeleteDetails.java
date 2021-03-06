package com.bridgeit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.dao.UserDao;

/**
 * Servlet implementation class DeletDetails
 */
public class DeleteDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			              throws ServletException, IOException {

                          response.setContentType("text/html");
       
                          int id = Integer.parseInt(request.getParameter("id"));
                          UserDao.delete(id);
	}

}
