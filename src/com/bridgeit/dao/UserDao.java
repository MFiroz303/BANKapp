package com.bridgeit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgeit.model.Account;
import com.bridgeit.model.User;

public class UserDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp?user=root&password=root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(User user) {
		int result = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("insert into user(full_name,password,email,phone_no) values (?,?,?,?)");
			pstmt.setString(1, user.getFullName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(4, user.getphoneNo());

			result = pstmt.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	public String ValidateLogin(String email, String password) {

		{
			// boolean status=false;
			try {
				// loading drivers for mysql
				Connection con = UserDao.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from user where email=? and password=?");
				pstmt.setString(1, email);
				pstmt.setString(2, password);

				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					return rs.getString("full_name");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "false";
		}
	}

	public void addDetails(Account account) {
		Connection con=null;
		try {
			con = UserDao.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"insert into AccountDetails(name,account_number,bank_name,city,user_id) values (?,?,?,?,?)");
			pstmt.setString(1, account.getName());
			pstmt.setInt(2, account.getAccountNo());
			pstmt.setString(3, account.getBankNmae());
			pstmt.setString(4, account.getCity());
			pstmt.setInt(5, account.getUser_id());
			 pstmt.executeUpdate();

			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public JSONArray display(String city,int id) {
		Connection con =null;
		try {
			con= UserDao.getConnection();
			JSONArray jarray = new JSONArray();

			PreparedStatement pstmt = con.prepareStatement("select * from AccountDetails where city=? and user_id=?");
			pstmt.setString(1, city);
			pstmt.setInt(2, id);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				JSONObject jobject = new JSONObject();
				jobject.put("id", resultSet.getInt("id"));
				jobject.put("name", resultSet.getString("name"));
				jobject.put("account_number", resultSet.getInt("account_number"));
				jobject.put("bank_name", resultSet.getString("bank_name"));
				jobject.put("city", resultSet.getString("city"));
				jarray.add(jobject);

			}
			//System.out.println(jarray.toJSONString());
			return jarray;

		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}

	public void update(int id, String name, int accountNo, String bankName,String city) {
		
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"update AccountDetails set name=?, account_number=? ,bank_name=?, city=? where id=?");
			pstmt.setInt(5, id);
			pstmt.setString(1, name);
			pstmt.setInt(2, accountNo);
			pstmt.setString(3, bankName);
			pstmt.setString(4, city);
			
			
			 pstmt.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void delete(int id) {
	
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from AccountDetails where id=?");

			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public JSONObject inbox(int id) {
		Connection con = null;
		try {
			con = UserDao.getConnection();
			JSONObject jObject = new JSONObject();
			PreparedStatement pstmt = con.prepareStatement("select * from AccountDetails where id=?");
			pstmt.setInt(1, id);

			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				jObject.put("id", resultSet.getInt("id"));
				jObject.put("name", resultSet.getString("name"));
				jObject.put("account_number", resultSet.getInt("account_number"));
				jObject.put("bank_name", resultSet.getString("bank_name"));
				jObject.put("city", resultSet.getString("city"));

			}
			return jObject;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return null;
	}

	public  int userid(String userName) {
		Connection con=null;
		try {
			 con = UserDao.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select id from user where full_name=?");

			pstmt.setString(1, userName);
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			while(rs.next()){
			return rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return 0;
	}


}
