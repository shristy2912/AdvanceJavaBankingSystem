<%@page import="com.glitter.dao.UserDao"%>
<%@page import="com.glitter.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Glitter IE App</title>
</head>
<body>

<%User user = (User)session.getAttribute("user"); %>

<jsp:include page="sidebar.jsp"></jsp:include>
<div id="main">

<%List<User> ul = new UserDao().getUserList(); %>
<%String err = (String)request.getAttribute("errormsg");%>
<%if(err!=null){ %>

	<h3 style="color:red;"><%=err%></h3>
	
<%} %>

<form action="WithdrawServlet" method="post">
<input type="hidden" name="action" value="withdraw">
	<table>
		<tr>
			<td>Enter the amount you want to withdraw</td>
			<td><input type="number" name="withdrawamount" required/></td>
		</tr>
		<tr>
			<td>Accountno</td>
			<td>
			<input name="accountno" type="text" value="<%=user.getAccountno() %>" readonly>
			</td> 
		</tr>
		<tr>
			<td>Deposited Money</td>
			<td>
		    <input type="number" name="useramount" value="<%= user.getAmount()%>" readonly/>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"/></td>
			<td><input type="reset"/></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>