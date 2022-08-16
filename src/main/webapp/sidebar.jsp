<%@page import="com.glitter.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/main.css" rel="stylesheet"/>
</head>
<body>

<%User user = (User)session.getAttribute("user"); %>

<div id="sidebar">

<h4><a href="index.jsp">Home</a></h4>

<%if(user!=null){ %>

	<h4><a href="deposit.jsp">Money Deposit</a></h4>
	<h4><a href="withdraw.jsp">Money Withdraw</a></h4>
	<h4><a href="TransactionServlet">Transaction List</a></h4>
	<h4><a href="LoginServlet">Logout</a></h4>
	<h4><a href="updateuser.jsp">Edit Profile</a></h4>	

<%} %>

<%if(user==null){ %>

	<h4><a href="adduser.jsp">Register</a></h4>
	<h4><a href="login.jsp">Login</a></h4>

<%} %>

<h4><a href="">About Us</a></h4>
	
</div>
</body>
</html>