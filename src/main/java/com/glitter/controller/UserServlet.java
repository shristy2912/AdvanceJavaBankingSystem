package com.glitter.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.glitter.dao.UserDao;
import com.glitter.model.MinimumBalanceException;
import com.glitter.model.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		if(action!=null && action.equals("adduser")) {
		try{
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String mobile = request.getParameter("mobileno");
			String DOB = request.getParameter("dob");
			
			String email = request.getParameter("email");
			String password1 = request.getParameter("passwd1");
			String password2 = request.getParameter("passwd2");
			double amount=Double.parseDouble(request.getParameter("amount"));
			
				if(amount<5000) {
					throw new MinimumBalanceException("");
				}
				
				if(email!=null && password1.equals(password2)) {
					//insert the user details in the database
					boolean b = new UserDao().addUser(email, password1,amount,name,surname,mobile,DOB);
					
					if(b) {
						response.sendRedirect("index.jsp");
					}
					
					else {
						request.setAttribute("errorMsg", 
								"User Already Exists!");
						request.getRequestDispatcher("adduser.jsp").include(request, response);
					}
				}
				else {
					//display the error message
					request.setAttribute("errorMsg", 
							"Password and Confirm Password Does Not Match!");
					request.getRequestDispatcher("adduser.jsp").include(request, response);
				}

			}
			catch(MinimumBalanceException e){
				request.setAttribute("errormsg","Amount should be 5000 or greater than 5000");
				request.getRequestDispatcher("adduser.jsp").include(request, response);
				}
		}
		
		else if(action!=null && action.equals("updateuser")) {
			HttpSession session = request.getSession();
			int accountno=Integer.parseInt(request.getParameter("accountno"));
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String mobile = request.getParameter("mobile");
			String DOB = request.getParameter("dob");
			double amount=Double.parseDouble(request.getParameter("amount"));
			String email = request.getParameter("email");
			String password = request.getParameter("password");
		
			
			User user = new User();
			user.setAccountno(accountno);
			user.setName(name);
			user.setSurname(surname);
			user.setMobile(mobile);
			user.setDOB(DOB);
			user.setAmount(amount);
			user.setEmail(email);
			
			user.setPassword(password);
			
			boolean b = new UserDao().updateUser(user);
			
			if(b) {
				session.setAttribute("user",user);
				response.sendRedirect("index.jsp");
			}
		}
			}
	
}