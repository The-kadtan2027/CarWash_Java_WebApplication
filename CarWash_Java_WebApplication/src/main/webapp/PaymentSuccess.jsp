<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Successfull</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
	String name = (String)request.getAttribute("name");
	String amount = (String)request.getAttribute("amount");
%>
	<div>
	<div class="success-page">
	   <img  src="http://share.ashiknesin.com/green-checkmark.png" class="center" alt="" />
		  <h2>Payment Successful !</h2>
		  <p>HI, <%= name %> We are delighted to inform you that we received your payment of Rs.<%=amount %> </p>
		  <!-- <a href="#" class="btn-view-orders">View Orders</a> -->
		  <a href="paymentsuccess">Book Another </a>
		</div>
	</div>
</body>
</html>