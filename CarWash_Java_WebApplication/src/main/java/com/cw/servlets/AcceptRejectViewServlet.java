package com.cw.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cw.dao.BookingsDAO;
import com.cw.dto.AdminBean;
import com.cw.dto.BookingsBean;


@SuppressWarnings("serial")
@WebServlet("/acceptbooking")
public class AcceptRejectViewServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		
		HttpSession hs = req.getSession(false);
		AdminBean admin = (AdminBean)hs.getAttribute("admin");
		if(admin == null) {
			req.setAttribute("msg", "Your Session Has Been Expired....!");
			req.getRequestDispatcher("/AdminLogin.jsp").forward(req, res);
		}else {
			ArrayList<BookingsBean> bookingsList = new BookingsDAO().getPendingBookings();
			req.setAttribute("bookings", bookingsList);
			req.getRequestDispatcher("/Accept.jsp").forward(req, res);
		}
		
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		
		HttpSession hs = req.getSession(false);
		AdminBean admin = (AdminBean)hs.getAttribute("admin");
		if(admin == null) {
			req.setAttribute("msg", "Your Session Has Been Expired....!");
			req.getRequestDispatcher("/AdminLogin.jsp").forward(req, res);
		}else {
			req.removeAttribute("bookings");
			ArrayList<BookingsBean> bookingsList = new BookingsDAO().getPendingBookings();
			req.setAttribute("bookings", bookingsList);
			req.getRequestDispatcher("/Accept.jsp").forward(req, res);
		}
		
	}
}
