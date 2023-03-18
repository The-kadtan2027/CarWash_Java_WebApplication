package com.cw.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cw.dao.UserBeanDAO;
import com.cw.dto.UserBean;

@SuppressWarnings("serial")
@WebServlet("/registeruser")
public class RegisterUserServlet extends HttpServlet {

	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String add = req.getParameter("address");
		String phone = req.getParameter("phone");
		String mail = req.getParameter("mailid");
		String uname = req.getParameter("username");
		String pword = req.getParameter("password");
		
		UserBean ub = new UserBean(fname, lname, phone, mail, add, uname, pword);
		
		int n = new UserBeanDAO().register(ub);
		
		PrintWriter pw = res.getWriter();
		
		if(n>0) {
			req.setAttribute("username", uname);
			req.getRequestDispatcher("/LoginUser.jsp").forward(req, res);
			
		}else {
			req.setAttribute("msg", "something Went Wrong");
			req.getRequestDispatcher("/RegisterUser.jsp").forward(req, res);
			
		}
		
	}
}
