<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg=(String)request.getAttribute("msg");
    String emsg=(String)request.getAttribute("emsg");
    %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookies</title>
</head>
<body>
<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: red"><%=msg%></h1>
	<%
	}
	%>
	
	<%
	if (emsg != null && !emsg.isEmpty()) {
	%>
	<h1 style="color: red"><%=emsg%></h1>
	<%
	}
	%>
	
	

<a href="./createCookies">create Cookies</a>
<a href="./showCookies">show Cookies</a>
</body>
</html>