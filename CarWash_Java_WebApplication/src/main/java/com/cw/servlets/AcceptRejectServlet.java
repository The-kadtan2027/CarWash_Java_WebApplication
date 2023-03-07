package com.cw.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cw.dao.BookingsDAO;
import com.cw.dto.BookingsBean;

@SuppressWarnings("serial")
@WebServlet("/acceptreject")
public class AcceptRejectServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String btn = req.getParameter("btn");
		System.out.println(btn);
		int k = new BookingsDAO().acceptReject(req);

		ArrayList<BookingsBean> bookingsList = new BookingsDAO().getPendingBookings();
		req.setAttribute("bookings", bookingsList);
		req.getRequestDispatcher("/Accept.jsp").forward(req, res);
		
	}
}
