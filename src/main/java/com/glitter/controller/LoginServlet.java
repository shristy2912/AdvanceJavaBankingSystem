package com.glitter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glitter.dao.UserDao;
import com.glitter.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	User u = new User();
	UserDao ud = new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("index.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		u = ud.userLogin(email,password);
		
		if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
			session.setAttribute("user", u);
			resp.sendRedirect("index.jsp");
	}
		else {
			req.setAttribute("errorMsg", 
					"Email and Password Does Not Match!");
			req.getRequestDispatcher("login.jsp").include(req, resp);
		}
	}
}