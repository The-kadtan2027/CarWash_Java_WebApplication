package com.cw.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cw.database.OpenConnection;
import com.cw.dto.PlaceBean;

public class PlaceDAO {
	
	public ArrayList<PlaceBean> getPlaces() {
		ArrayList<PlaceBean> list = new ArrayList<>();

		try {
			PreparedStatement ps = OpenConnection.con.prepareStatement
									("SELECT * from places");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new PlaceBean(rs.getString(1)));
			}
		}
		catch(SQLException se) {se.printStackTrace();}
		
		return list;
	}

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
