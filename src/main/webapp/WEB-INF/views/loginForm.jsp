<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String lmsg = (String) request.getAttribute("errmsg");
String msg=(String)request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if (lmsg != null && !lmsg.isEmpty()) {
	%>
	<h1 style="color: red"><%=lmsg%></h1>
	<%
	}
	%>
	
	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: red"><%=msg%></h1>
	<%
	}
	%>
	<fieldset>
		<legend>Login Page</legend>
		<form action="./loginForm" , method="post">
			<label>Enter the Employee ID</label> <input type="text" name="id">
			<br> <label>Enter the Employee Password</label> <input
				type="password" name="pwd"> <br> <input type="submit"
				value="submit">

		</form>
	</fieldset>
</body>
</html>