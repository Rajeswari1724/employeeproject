<%@page import="java.io.PrintWriter"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.te.employeeproject.bean.Employeedb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
List<Employeedb> employeedb = (List<Employeedb>) request.getAttribute("data");
//Employeedb employeedb=(Employeedb)request.getAttribute("msg");
String err = (String) request.getAttribute("errmsg");
String msg = (String) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	if (err != null && !err.isEmpty()) {
	%>
	<h1 style="color: red"><%=err%></h1>
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

	<%
	for(Employeedb employeedb2 : employeedb){
	%>
	<h1>
		name:<%=employeedb2.getName()%></h1>
	<h1>
		id:<%=employeedb2.getId()%></h1>
	<h1>
		dob:<%=employeedb2.getBirthdate()%></h1>
	<%
	}
	%>
</body>
</html>