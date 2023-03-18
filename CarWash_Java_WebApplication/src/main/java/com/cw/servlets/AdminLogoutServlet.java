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

@SuppressWarnings("serial")
@WebServlet("/adminlogout")
public class AdminLogoutServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		
		HttpSession hs = req.getSession(false);
		
		
		if(hs == null) {
			req.setAttribute("msg", "Session Expired...");
			req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
		}else {
			AdminBean adminBean = (AdminBean)hs.getAttribute("admin");
			if(adminBean != null) {
					hs.invalidate();
			}else {
				req.setAttribute("msg", "Session Expired...");
			}
			req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
		}
		
		
	}
}
