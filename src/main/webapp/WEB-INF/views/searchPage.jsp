<%@page import="com.te.employeeproject.bean.Employeedb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("msg");
Employeedb employeedb = (Employeedb) request.getAttribute("data");
%>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style=""><%=msg%></h1>
	<%
	}
	%>
	
	<%if(employeedb!=null) {%>
	<h4> Name:<%=employeedb.getName() %> </h4>
	<h4> Id:<%=employeedb.getId() %> </h4>
	<h4> Dob:<%=employeedb.getBirthdate()%> </h4>
	<%} %>
	<form action="./search" method="get">
		<label>Enter the employee id to search the details</label> <input
			type="text" name="id"> <br> <input type="submit"
			value="submit">
	</form>
</body>
</html>