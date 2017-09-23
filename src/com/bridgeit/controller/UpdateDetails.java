package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeit.dao.UserDao;
import com.bridgeit.model.Account;

/**
 * Servlet implementation class UpdateDetails
 */
public class UpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("pname");
		String accountNo = request.getParameter("accountNo"); // ...prblm

		String bankName = request.getParameter("bankName");
		String city = request.getParameter("city");
		String currentid = request.getParameter("id");

		if (currentid.equals("0")) {
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("name");

			UserDao userdao = new UserDao();
			int user_id = userdao.userid(userName);

			Account account = new Account();
			account.setName(name);
			account.setBankNmae(bankName);
			account.setAccountNo(Integer.parseInt(accountNo));
			account.setCity(city);
			account.setUser_id(user_id);

			userdao.addDetails(account);
			// response.sendRedirect("Home");
		}

		else {
			UserDao userdao = new UserDao();
			int pid = Integer.parseInt(currentid);
			userdao.update(pid, name, Integer.parseInt(accountNo), bankName, city);
		}
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
