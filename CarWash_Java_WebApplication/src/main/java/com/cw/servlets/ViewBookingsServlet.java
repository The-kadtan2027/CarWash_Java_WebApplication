package com.cw.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cw.dao.BookingsDAO;
import com.cw.dao.PlaceDAO;
import com.cw.dto.AdminBean;
import com.cw.dto.BookingsBean;
import com.cw.dto.PlaceBean;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewBookingsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		HttpSession hs = req.getSession(false);
		
		if(hs != null) {
			
			AdminBean ab = (AdminBean) hs.getAttribute("admin");
			if(ab == null) {
				
				req.setAttribute("msg", "Your Session is Expired..");
				req.getRequestDispatcher("/AdminLogin.jsp").forward(req, res);
				
			}else {
				
				ArrayList<BookingsBean> list = new BookingsDAO().getAllBookings(req);
				ArrayList<PlaceBean> places = new PlaceDAO().getPlaces();
				req.setAttribute("places", places);
				req.setAttribute("bookings", list);
				req.getRequestDispatcher("/ViewBookings.jsp").forward(req, res);
				
			}
		}else {
			req.setAttribute("msg", "Your Session is Expired..");
			req.getRequestDispatcher("/AdminLogin.jsp").forward(req, res);
		}
	}
}
