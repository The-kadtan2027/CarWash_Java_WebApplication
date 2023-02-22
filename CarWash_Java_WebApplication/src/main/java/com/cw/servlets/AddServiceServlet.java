package com.cw.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cw.dao.ServiceDAO;
import com.cw.dto.ServiceBean;

@SuppressWarnings("serial")
@WebServlet("/addservice")
public class AddServiceServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		ServiceBean sb = new ServiceBean(req.getParameter("sname"), Float.parseFloat(req.getParameter("cost")));
		
		int in = new ServiceDAO().addService(sb);
		
		if(in>0) {
			RequestDispatcher rd = req.getRequestDispatcher("/addservice.html");
			pw.println("<h3>new Service added</he>");
			rd.include(req, res);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("/addservice.html");
			pw.println("<h3>Service Not added....!</he>");
			rd.include(req, res);
		}
	}
}
