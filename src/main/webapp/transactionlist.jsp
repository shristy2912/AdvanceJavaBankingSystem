<%@page import="com.glitter.model.Deposit"%>
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

<jsp:include page="sidebar.jsp"></jsp:include>
<div id="main">

<%List<Deposit> incList = (List<Deposit>)
		session.getAttribute("incList"); 
%>
	<table cellpadding="10">
		<tr>
			<th>Deposit</th>
			<th>Withdraw</th>
			<th>Current Balance</th>
			<th>Account No</th>
		</tr>
		<% for(Deposit i : incList) {%>
		<tr>
			<td><%=i.getDeposit() %></td>
			<td><%=i.getWithdraw() %></td>
			<td><%=i.getCurrbalance() %></td>
			<td><%=i.getAccountno() %></td>
		</tr>		
		<% } %>
	</table>
	
</div>
</body>
</html>