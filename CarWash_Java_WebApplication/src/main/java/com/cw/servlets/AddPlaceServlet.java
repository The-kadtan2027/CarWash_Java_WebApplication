package com.cw.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cw.dao.PlaceDAO;
import com.cw.dto.PlaceBean;


@SuppressWarnings("serial")
@WebServlet("/addplace")
public class AddPlaceServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		PlaceBean pb = new PlaceBean(req.getParameter("place"));
		
		int in = new PlaceDAO().addPlace(pb);
		
		if(in>0) {
			RequestDispatcher rd = req.getRequestDispatcher("/addplace.html");
			pw.println("<h3>new Place added</he>");
			rd.include(req, res);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("/addplace.html");
			pw.println("<h3 style='color:red;'>Failed to add Place</he>");
			rd.include(req, res);
		}
		
	}
}
