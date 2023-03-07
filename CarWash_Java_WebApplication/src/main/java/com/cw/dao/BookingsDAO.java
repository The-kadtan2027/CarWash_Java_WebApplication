package com.cw.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.cw.database.OpenConnection;
import com.cw.dto.BookingsBean;

public class BookingsDAO {
	
	public int acceptReject(HttpServletRequest req) {
		String bookingId = req.getParameter("bid");
		String update = "";
		if(req.getParameter("status").equals("Accept")) {
			update = "Accepted";
		}else {
			update = "Rejected";
		}
		int n = 0;
		try {
			PreparedStatement ps = OpenConnection.con.prepareStatement("update bookings set status=? where bookingid=?");
			ps.setString(1, update);
			ps.setString(2, bookingId);
			
			n = ps.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return n;
	}
	
	public ArrayList<BookingsBean> getPendingBookings(){
		
		ArrayList<BookingsBean> bookings = new ArrayList<>();
		
		try {
			PreparedStatement ps = OpenConnection.con.prepareStatement("SELECT * FROM bookings where status='Pending'");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				bookings.add(new BookingsBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return bookings;
	}
	
	public String bookSlot(BookingsBean bb) {
		String name = null;
		try {
			PreparedStatement ps = OpenConnection.con.prepareStatement
					("INSERT INTO bookings values(? || digit.nextval,?,?,?,?,?,?,?,?)");
			ps.setString(1, bb.bId());
			ps.setString(2, bb.name());
			ps.setString(3, bb.username());
			ps.setString(4, bb.service());
			ps.setString(5, bb.status());
			ps.setString(6, bb.place());
			ps.setDate(7, Date.valueOf(bb.date()));
			ps.setString(8, bb.carName());
			ps.setString(9, bb.carRegNo());
			
			if(ps.executeUpdate()>0) {
				name = bb.name();
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		return name;
	}

	public ArrayList<BookingsBean> getAllBookings(HttpServletRequest req){
		
		ArrayList<BookingsBean> list = new ArrayList<>();
		
		
		
		  try {
		  
		  PreparedStatement ps = OpenConnection.con.prepareStatement
		  ("SELECT * FROM bookings where place=? and date_of_booking=?");
		  ps.setString(1,req.getParameter("place"));
		  ps.setDate(2,Date.valueOf(req.getParameter("date")));
		  ResultSet rs = ps.executeQuery();
		  
		  while(rs.next()) { list.add(new BookingsBean(rs.getString(1),
						  rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						  rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9))); 
		  	}
		  
		  }catch(SQLException se) { se.printStackTrace(); }
		 		
		return list;
	}
}
