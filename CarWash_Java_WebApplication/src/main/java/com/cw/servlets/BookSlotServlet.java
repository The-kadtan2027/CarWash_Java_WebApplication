package com.cw.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

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
@WebServlet("/bookslot")
public class BookSlotServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		UserBean ub = (UserBean)session.getAttribute("user");
//		session.removeAttribute("payment");
		if(ub == null) {
			req.setAttribute("msg", "Your session is Expired...!");
			req.getRequestDispatcher("/LoginUser.jsp").forward(req, res);
		}else {
			String inputCaptcha = req.getParameter("captcha");
			
			StringBuffer services = new StringBuffer();
			
			String[] service = req.getParameterValues("services");
			float amount =0;
			for(String s: service) {
				if(!s.equals("null")) {
						services.append(s.split(",")[0]);
						amount += (float) Float.parseFloat(s.split(",")[1]);
				}
			}
			
			String captcha = req.getParameter("generatedCaption");
			System.out.println(inputCaptcha +"  "+ captcha);
			String bookingId = idGenerator();
			String modelName = req.getParameter("modelname");
			String vehicalNo = req.getParameter("vNumber");
			String place = req.getParameter("place");
			
			String date = req.getParameter("date");
			String status = "Pending";
			String name = ub.firstName()+" "+ub.lastName();
			String username = ub.username();
			BookingsBean bb = new BookingsBean(bookingId,name,username,services.toString(),status,place,date,modelName,vehicalNo,amount);
//			
//			String id = new BookingsDAO().bookSlot(bb);
			
			
			if(inputCaptcha.equals(captcha)) {
				
				session.setAttribute("payment", bb);
				
				req.getRequestDispatcher("PaymentWay.jsp").forward(req, res);
			}else {
				req.setAttribute("msg", "Invalid Captcha code...");
				req.getRequestDispatcher("BookSlot.jsp").forward(req, res);
			}
			

		}
	}
	
	private String idGenerator() {
		StringBuilder sb = new StringBuilder();
		
		Random rd = new Random();
		while(sb.length()<4) {
			char ch = (char) rd.nextInt(48, 90);
			if((ch >= '0' && ch<='9')|| ch >='A' && ch<='Z' ) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
