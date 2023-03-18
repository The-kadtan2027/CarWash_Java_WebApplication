package com.cw.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cw.dto.UserBean;


@SuppressWarnings("serial")
@WebServlet("/paymentsuccess")
public class PaymentSuccess extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		UserBean user = (UserBean)session.getAttribute("user");
		if(user != null && session != null) {
			res.sendRedirect("BookSlot.jsp");
		}else {
			
			res.sendRedirect("LoginUser.jsp");
		}
	}
}
