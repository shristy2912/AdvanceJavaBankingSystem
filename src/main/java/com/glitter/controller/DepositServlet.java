package com.glitter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glitter.dao.DepositDao;
import com.glitter.model.Deposit;
import com.glitter.model.User;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	Deposit inc = new Deposit();
	DepositDao incd = new DepositDao();
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		User user = (User)session.getAttribute("user");		
		
		double deposit = Double.parseDouble(request.getParameter("depositamount"));
		double amount=Double.parseDouble(request.getParameter("useramount"));
		int accountno = Integer.parseInt(request.getParameter("accountno"));
		double withdraw = 0;
		double currbalance = deposit+amount;
		
		
		if(action!=null && action.equals("deposit")) {
			inc.setDeposit(deposit);
			inc.setWithdraw(withdraw);
			inc.setCurrbalance(currbalance);
			inc.setAccountno(accountno);
		
			boolean b = new DepositDao().addDeposit(inc);
			if(b) {
				user.setAmount(currbalance);
				session.setAttribute("user",user);
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("deposit.jsp");
			}
		}
		
		}
	}