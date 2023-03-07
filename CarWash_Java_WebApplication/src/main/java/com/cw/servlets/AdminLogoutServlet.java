package com.cw.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cw.dto.AdminBean;

@WebServlet("/adminlogout")
public class AdminLogoutServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		HttpSession hs = req.getSession(false);
		AdminBean adminBean = (AdminBean)hs.getAttribute("admin");
		
//		pw.println("<html><body align='center'><h1>Logout Successfull...</h1></body></html>");
		hs.invalidate();
		req.getRequestDispatcher("/adminlogin.html").include(req, res);
	}
	

}
