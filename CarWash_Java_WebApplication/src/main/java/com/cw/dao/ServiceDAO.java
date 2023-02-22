package com.cw.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cw.database.OpenConnection;
import com.cw.dto.ServiceBean;

public class ServiceDAO {
	
	public int addService(ServiceBean sb) {
		
		int k =0;
		try {
			
			PreparedStatement ps = OpenConnection.con.prepareStatement
									("INSERT INTO services values(?,?)");
			ps.setString(1, sb.serviceName());
			ps.setFloat(2, sb.serviceCost());
			
			k = ps.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		return k;
	}
}
