<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
    <%	int id=(int)request.getAttribute("eid");
    	String msg=(String)request.getAttribute("msg");
    	String errmsg=(String)request.getAttribute("errmsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="blue"><%= msg%></h1>
	<%
	}
	%>
	
	<%
	
	if (errmsg != null && !errmsg.isEmpty()) {
	%>
	<h1 style="red"><%=errmsg%></h1>
	<%
	}
	%>
<form action="./update" method="post">
<label> update employee details </label>
<label>id:<%= id %></label>
<input hidden="true" type="text" name="id" value="<%= id%>"><br>
<label>enter the new name:</label>
<input type="text" name="name" required="required"><br>
<label>enter the new dob:</label>
<input type="date" name="dob" required="required"><br>
<label>enter the new password:</label>
<input type="password" name="pwd"><br>

<br>
<input type="submit" value="update">

</form>
</body>
</html>