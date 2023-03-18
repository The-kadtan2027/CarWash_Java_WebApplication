package com.cw.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cw.dto.AdminBean;

@WebServlet("/addservicesview")
public class AddServicesView extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		AdminBean admin = (AdminBean)session.getAttribute("admin");
		
		if(admin != null) {
			
			req.getRequestDispatcher("AddServices.jsp").forward(req, res);
		}else {
			req.setAttribute("msg", "Session Expired...");
			req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
		}
	}
}
