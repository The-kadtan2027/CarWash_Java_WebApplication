package com.cw.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cw.dao.UserBeanDAO;
import com.cw.dto.UserBean;

@SuppressWarnings("serial")
@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		String btn = req.getParameter("btn");
		
		if(btn.equals("signup")) {
			RequestDispatcher rd = req.getRequestDispatcher("/registeruser.html");
			rd.forward(req, res);
		}
		else if(btn.equals("signin")) {
			UserBean userBean = new UserBeanDAO().login(req);
			
			if(userBean != null) {
				HttpSession hs = req.getSession(true);
				hs.setAttribute("user", userBean);
				RequestDispatcher rd = req.getRequestDispatcher("/BookSlot.jsp");
				rd.forward(req, res);
			}else {
				
				req.getRequestDispatcher("/Error.jsp").forward(req, res);
			}
			
		}
				
	}
}
