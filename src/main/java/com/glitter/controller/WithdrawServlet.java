package com.glitter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glitter.dao.WithdrawDao;
import com.glitter.model.MinimumBalanceException;
import com.glitter.model.User;
import com.glitter.model.Withdraw;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	Withdraw with = new Withdraw();
	WithdrawDao withd = new WithdrawDao();
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		User user = (User)session.getAttribute("user");		
		
		double withdraw = Double.parseDouble(request.getParameter("withdrawamount"));
		double amount=Double.parseDouble(request.getParameter("useramount"));
		int accountno = Integer.parseInt(request.getParameter("accountno"));
		double deposit = 0;
		double currbalance = amount-withdraw;
		
		try{
			if(currbalance<5000) {
				throw new MinimumBalanceException("");
			}
			
				with.setDeposit(deposit);
				with.setWithdraw(withdraw);
				with.setCurrbalnce(currbalance);
				with.setAccountno(accountno);
			
				boolean b = new WithdrawDao().addWithdraw(with);
				if(b) {
					user.setAmount(currbalance);
					session.setAttribute("user",user);
					response.sendRedirect("index.jsp");
				}
				else {
					response.sendRedirect("withdraw.jsp");
				}
			}
		
			   catch(MinimumBalanceException e){
				request.setAttribute("errormsg","Amount should be 5000 or greater than 5000");
				request.getRequestDispatcher("withdraw.jsp").include(request, response);
				}
		
			}
		}	
		
	


		
		
		
	
	