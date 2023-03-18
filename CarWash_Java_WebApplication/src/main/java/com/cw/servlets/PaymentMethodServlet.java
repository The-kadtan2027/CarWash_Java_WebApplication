package com.cw.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cw.dao.BookingsDAO;
import com.cw.dto.BookingsBean;
import com.cw.dto.UserBean;

@SuppressWarnings("serial")
@WebServlet("/payment")
public class PaymentMethodServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String amount = req.getParameter("amount");
		
		HttpSession userSession = req.getSession(false);
		
		if(userSession != null) {
			
			UserBean ub = (UserBean)userSession.getAttribute("user");
			
			BookingsBean bb = (BookingsBean)userSession.getAttribute("payment");
			
			
			if(ub != null && bb != null) {
				new BookingsDAO().bookSlot(bb);
				
				userSession.removeAttribute("payment");
				req.setAttribute("name", name);
				req.setAttribute("amount", amount);
				req.getRequestDispatcher("/PaymentSuccess.jsp").forward(req, res);
			}
			else {
				req.setAttribute("msg", "Session Expired...");
				req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
			}
		}else {
			req.setAttribute("msg", "Session Expired...");
			req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
		}
		
		
		
	}
}
