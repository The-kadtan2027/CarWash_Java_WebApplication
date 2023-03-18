package com.cw.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cw.dto.UserBean;


@WebServlet("/viewUserBookings")
public class ViewUserBookingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		if(session == null) {
//			res.sendRedirect("LoginUser.jsp");
			req.setAttribute("msg", "Session Expired.......");
			req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
			
		}else {
			UserBean user = (UserBean)session.getAttribute("user");
			if(user != null) {
				req.getRequestDispatcher("User-all-bookings.jsp").forward(req, res);
			}
		}
	}
	
}
