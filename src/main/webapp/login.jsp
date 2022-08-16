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

<%String message = (String)request.getAttribute("errorMsg"); %>
<%if(message!=null){ %>

	<h3 style="color:red;"><%=message %></h3>

<%} %>

<form action="LoginServlet" method="post">
	<table>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email" required/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" required/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"/></td>
			<td><input type="reset"/></td>
		</tr>
	</table>
	<br/><br/>
	<a href="adduser.jsp">Click Here to Register</a>
</form>
</div>
</body>
</html>