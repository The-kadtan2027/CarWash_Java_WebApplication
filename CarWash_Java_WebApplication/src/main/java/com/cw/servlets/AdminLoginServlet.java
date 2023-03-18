package com.cw.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cw.dao.AdminBeanDAO;
import com.cw.dto.AdminBean;

@SuppressWarnings("serial")
@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		
		AdminBean ab = new AdminBeanDAO().login(req);
		
		if(ab == null) {
			req.setAttribute("msg", "Invalid UserName of Password");
			RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.jsp");
			
			rd.forward(req, res);
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("admin", ab);
			req.getRequestDispatcher("/AdminPanel.jsp").forward(req, res);
		}
		
		
	}
	
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		
		req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
			
		
		
	}
	
}
