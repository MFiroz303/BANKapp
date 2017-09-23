package com.bridgeit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


	Connection connection=null;
	public DBConnection()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Getting connected");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp?user=root&password=root"); 
			//System.out.println("connected");
			
	
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		
	}
	public	Connection getconnection()
	{
		return connection; 
	}
	
}