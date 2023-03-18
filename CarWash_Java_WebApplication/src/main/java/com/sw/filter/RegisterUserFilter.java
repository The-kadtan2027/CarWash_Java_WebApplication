package com.sw.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.cw.dao.UserBeanDAO;

@WebFilter("/registeruser")
public class RegisterUserFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		String mailid = req.getParameter("mailid");
		String phone = req.getParameter("phone");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String add = req.getParameter("address");
		String uname = req.getParameter("userename");
		
		
		UserBeanDAO userDao = new UserBeanDAO();
		
		if(userDao.isRegistered(uname)) {
			req.setAttribute("username", uname);
			req.getRequestDispatcher("LoginUser.jsp");
			}
		 
		
		if(userDao.isExitstPhone(phone)) {
			req.setAttribute("fname", fname);
			req.setAttribute("lname", lname);
			req.setAttribute("add", add);
			req.setAttribute("uname", uname);
			req.setAttribute("mail", mailid);
			req.setAttribute("phone", phone);
			req.setAttribute("msg2", "Already Registered Mobile Number..");
			
			req.getRequestDispatcher("RegisterUser.jsp").forward(req, res);
		}
		else if(userDao.isExitstMailId(mailid)) {
			req.setAttribute("fname", fname);
			req.setAttribute("lname", lname);
			req.setAttribute("phone", phone);
			req.setAttribute("add", add);
			req.setAttribute("uname", uname);
			req.setAttribute("mail", mailid);
			
			req.setAttribute("msg1", "Already Registered.. Mail Id");
			req.getRequestDispatcher("RegisterUser.jsp").forward(req, res);
		
	
		}else {
			chain.doFilter(req, res);
		}
		

	}

}
