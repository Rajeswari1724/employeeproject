<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String err = (String) request.getAttribute("err");
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
</body>
</html>