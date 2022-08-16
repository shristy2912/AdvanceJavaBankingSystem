<%@page import="com.glitter.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%User user = (User)session.getAttribute("user");%>

<jsp:include page="sidebar.jsp"></jsp:include>
<div id="main">

	<form action="UserServlet" method="post">
		<input type='hidden' name='action' value='updateuser'/>
			<table>
				<tr>
					<td>Account No</td>
					<td><input type="number" name="accountno" value="<%=user.getAccountno()%>" readonly="readonly"></td>
				</tr>

				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="<%=user.getName()%>" required="required"></td>
				</tr>

				<tr>
					<td>Surname</td>
					<td><input type="text" name="surname" value="<%=user.getSurname()%>" required="required"></td>
				</tr>

				<tr>
					<td>Mobile No</td>
					<td><input type="number" name="mobile" value="<%=user.getMobile()%>" required="required"></td>
				</tr>

				<tr>
					<td>DOB</td>
					<td><input type="date" name="dob" value="<%=user.getDOB()%>" required="required"></td>
				</tr>
				<tr>
					<td>Amount</td>
				    <td><input type="number" name="amount" value="<%=user.getAmount()%>" readonly="readonly"></td>
				</tr>
                 <tr>
					<td>Email</td>
					<td><input type="email" name="email" value="<%=user.getEmail()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" value="<%=user.getPassword()%>" readonly="readonly"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Save"></td>
					<td><input type="reset" value="Reset"></td>
				</tr>
			</table>

		</form>
	</div>

</body>
</html>