package com.cw.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cw.database.OpenConnection;
import com.cw.dto.ServiceBean;

public class ServiceDAO {
	
	public ArrayList<ServiceBean> getServices(){
		ArrayList<ServiceBean> list = new ArrayList<>();
		
		try {
			PreparedStatement ps = OpenConnection.con.prepareStatement("select * from services");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new ServiceBean(rs.getString(1), rs.getFloat(2)));
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return list;
	}
	
	
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
