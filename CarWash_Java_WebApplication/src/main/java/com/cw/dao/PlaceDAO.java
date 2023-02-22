package com.cw.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cw.database.OpenConnection;
import com.cw.dto.PlaceBean;

public class PlaceDAO {

	public int addPlace(PlaceBean pb) {
		int k=0;
		
		try {
			PreparedStatement ps = OpenConnection.con.prepareStatement
									("INSERT INTO places values(?)");
			ps.setString(1, pb.place());
			
			k = ps.executeUpdate();
		}
		catch(SQLException se) {se.printStackTrace();}
		
		return k;
	}
}
