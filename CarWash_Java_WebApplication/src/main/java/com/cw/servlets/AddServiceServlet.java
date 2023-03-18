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

import com.cw.dao.ServiceDAO;
import com.cw.dto.AdminBean;
import com.cw.dto.ServiceBean;

@SuppressWarnings("serial")
@WebServlet("/addservice")
public class AddServiceServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		HttpSession hs = req.getSession(false);
		AdminBean ab = (AdminBean)hs.getAttribute("admin");
		
		if(ab == null) {
			req.setAttribute("msg", "login first");
			req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
			
		}
		else {
			ServiceBean sb = new ServiceBean(req.getParameter("sname"), Float.parseFloat(req.getParameter("cost")));
			
			int in = new ServiceDAO().addService(sb);
			
			if(in>0) {
				req.setAttribute("success", "Place Added");
				req.getRequestDispatcher("AddServices.jsp").forward(req, res);
				
			}
			else {
				req.setAttribute("msg", "Something went Wrong....!");
				req.getRequestDispatcher("AddServices.jsp").forward(req, res);
				
			}
		}
		
	}
}
