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
		
		//get PrintWriter object
		PrintWriter pw = res.getWriter();
		
		//set MIME type
		res.setContentType("text/html");
		
		AdminBean ab = new AdminBeanDAO().login(req);
		
		if(ab == null) {
			RequestDispatcher rd = req.getRequestDispatcher("/adminlogin.html");
			pw.println("<h3 style='color:red'>invalid username or password</h3>");
			rd.include(req, res);
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("admin", ab);
			RequestDispatcher rd = req.getRequestDispatcher("/adminpanel.html");
			rd.include(req, res);
			
		}
		
		
	}
}
