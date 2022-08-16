<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Glitter IE App</title>
</head>
<body>

<div id="main">

<%String message = (String)request.getAttribute("errorMsg"); %>
<%String err = (String)request.getAttribute("errormsg");%>

<%if(message!=null){ %>

	<h3 style="color:red;"><%=message %></h3>
	
<%} %>
<%if(err!=null){ %>

	<h3 style="color:red;"><%=err%></h3>
	
<%} %>





<form action="UserServlet" method="post">
<input type='hidden' name='action' value='adduser'/>
	<table>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" required/></td>
		</tr>
		<tr>
			<td>Surname</td>
			<td><input type="text" name="surname" required/></td>
		</tr>
		<tr>
			<td>Mobile no</td>
			<td><input type="number" name="mobileno" required/></td>
		</tr>
		<tr>
			<td>DOB</td>
			<td><input type="date" name="dob" required/></td>
		</tr>
		<tr>
			<td>Enter Amount(it should be atleast 5000)</td>
			<td><input type="number" name="amount" required/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email" required/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="passwd1" required/></td>
		</tr>
		<tr>
			<td>Confirm-Password</td>
			<td><input type="password" name="passwd2" required/></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Register"/></td>
			<td><input type="reset"/></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>