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
import com.glitter.dao.WithdrawDao;
import com.glitter.model.Deposit;
import com.glitter.model.User;
import com.glitter.model.Withdraw;

@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Deposit inc = new Deposit();
	DepositDao incd = new DepositDao();
	Withdraw with = new Withdraw();
	WithdrawDao withd = new WithdrawDao();
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		User user = (User) session.getAttribute("user");
		
		
			List<Deposit> incList = incd.getDepositList(user.getAccountno());
			session.setAttribute("incList", incList);
			resp.sendRedirect("transactionlist.jsp");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
