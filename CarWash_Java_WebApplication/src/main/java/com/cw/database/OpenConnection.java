package com.cw.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnection {
	
	public static Connection con = null;
	
	private OpenConnection() {}
	
	static {
		try {
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","c##carwash","carwash");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
