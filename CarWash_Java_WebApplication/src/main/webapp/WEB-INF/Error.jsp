<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Erro</title>
</head>
<body>
	<%
		String msg = (String)request.getAttribute("msg");
	%>
	<h1><%=msg %></h1>
</body>
</html>