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

import com.cw.dao.PlaceDAO;
import com.cw.dto.AdminBean;
import com.cw.dto.PlaceBean;


@SuppressWarnings("serial")
@WebServlet("/addplace")
public class AddPlaceServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		HttpSession hs = req.getSession(false);
		AdminBean ab = (AdminBean) hs.getAttribute("admin");
		
		if(ab == null) {
				
				req.setAttribute("msg", "Session Expired");
				req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
				
			
		}else {
			
			PlaceBean pb = new PlaceBean(req.getParameter("place"));
			
			int in = new PlaceDAO().addPlace(pb);
			
			if(in>0) {
				req.setAttribute("msg", "Place Added");
				req.getRequestDispatcher("AddPlaces.jsp").forward(req, res);
				
			}
			else {
				req.setAttribute("msg", "Something went wrong...");
				req.getRequestDispatcher("AddPlaces.jsp").forward(req, res);
				
			}
		}
		
	}
}
