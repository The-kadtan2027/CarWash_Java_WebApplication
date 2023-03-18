package com.cw.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cw.dto.UserBean;

@SuppressWarnings("serial")
@WebServlet("/user-logout")
public class UserLogoutSerlvet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession hs = req.getSession(false);
		
		if(hs != null) {
			
			UserBean ub = (UserBean)hs.getAttribute("user");
			
			if(ub == null) {
				req.setAttribute("msg", "Your Session is Expired...");
				req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
			}else {
				hs.invalidate();
				
				req.getRequestDispatcher("LoginUser.jsp").forward(req, res);;
			}
		}else {
			req.setAttribute("msg", "Your Session is Expired...");
			req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
		}
	}
}
