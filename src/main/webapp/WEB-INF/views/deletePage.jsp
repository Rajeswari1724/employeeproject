<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg=(String)request.getAttribute("msg");
    	String err=(String)request.getAttribute("errmsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(msg!=null && !msg.isEmpty()){ %>
<h1><%=msg %></h1>
<%} %>

<%if(err!=null && !err.isEmpty()){ %>
<h1><%= err %></h1>
<%} %>

<form action="./delete" method="get">
<label>Enter the id to delete the employee details</label>
	<input type="text"name="id"><br>
	<input type="submit" value="submit">
</form>
</body>
</html>