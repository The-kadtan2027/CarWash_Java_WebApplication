package com.cw.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.cw.database.OpenConnection;
import com.cw.dto.AdminBean;

public class AdminBeanDAO {
	
	public AdminBean login(HttpServletRequest req) {
		
		AdminBean ab = null;
		
		try {
			PreparedStatement ps = OpenConnection.con.prepareStatement
									("SELECT * FROM admin where username=? and password=?");
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ab = new AdminBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		}
		catch(SQLException se) {se.printStackTrace();}
		
		return ab;
	}
}
