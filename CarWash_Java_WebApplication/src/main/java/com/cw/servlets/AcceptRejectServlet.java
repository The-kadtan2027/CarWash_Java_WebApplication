package com.cw.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cw.dao.BookingsDAO;
import com.cw.dto.BookingsBean;

@SuppressWarnings("serial")
@WebServlet("/acceptreject")
public class AcceptRejectServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String btn = req.getParameter("btn");
		
		int k = new BookingsDAO().acceptReject(req);
		if(k>0) {
			req.getRequestDispatcher("/Accept.jsp").forward(req, res);
		}else {
			System.out.println("something got stuck");
		}
		
	}
}
