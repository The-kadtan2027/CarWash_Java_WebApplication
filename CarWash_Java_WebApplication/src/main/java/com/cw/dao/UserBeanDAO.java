package com.cw.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.cw.database.OpenConnection;
import com.cw.dto.UserBean;

public class UserBeanDAO {
	
	public boolean isRegistered(String username) {
		boolean f = false;
		try {
			
			PreparedStatement ps = OpenConnection.con.prepareStatement("Select mailId from users where username=?");
			
			ps.setString(1, username);
			
			if(ps.executeUpdate()>0) {
				f = true;
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return f;
		
	}
	
	public boolean isExitstMailId(String mailId) {
		boolean f = false;
		try {
			
			PreparedStatement ps = OpenConnection.con.prepareStatement("Select username from users where mailid=?");
			
			ps.setString(1, mailId);
			
			if(ps.executeUpdate()>0) {
				f = true;
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return f;
	}
	public boolean isExitstPhone(String phone) {
		boolean f = false;
		try {
			
			PreparedStatement ps = OpenConnection.con.prepareStatement("Select username from users where phone=?");
			
			ps.setString(1, phone);
			
			if(ps.executeUpdate()>0) {
				f = true;
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return f;
	}
	
	public int register(UserBean ub) {
		int n = 0;
		try {
			
			PreparedStatement ps = OpenConnection.con.prepareStatement("INSERT INTO users values(?,?,?,?,?,?,?)");
			
			ps.setString(1, ub.firstName());
			ps.setString(2, ub.lastName());
			ps.setString(3, ub.phone());
			ps.setString(4, ub.mailId());
			ps.setString(5, ub.address());
			ps.setString(6, ub.username());
			ps.setString(7, ub.password());
			
			n = ps.executeUpdate();
		
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		
		return n;
	
		
		
	}
	
	
	

	public UserBean login(HttpServletRequest req) {
		UserBean ub = null;
		String username = req.getParameter("uname");
		String password = req.getParameter("pword");
		
		try {
			PreparedStatement ps = OpenConnection.con.prepareStatement("Select * from users where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ub = new UserBean(rs.getString(1), rs.getString(2), rs.getString(3),
									rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return ub;
	}
	
	
}
