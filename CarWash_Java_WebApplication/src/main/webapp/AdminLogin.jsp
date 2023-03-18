<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Admin Login Page</title>
	<link rel="stylesheet" href="style.css">
</head>

<body>
	<div class="wrapper">
		<h1>Admin Login</h1>
		<form action="adminlogin" method="post">
			<div class="uname">
				<input type="text" placeholder="Username" name="uname" id="uname">
			</div>
			<div class="pword">
				<input type="password" placeholder="Password" name="pword" id="pword">

			</div>

			<button>Login</button>
		</form>

	</div>
	
	<div>
		<%
			String msg = (String)request.getAttribute("msg");
			if(msg != null){
				%>
				<h1><%= msg %></h1>
				<%
			}
		
		%>
	</div>
</body>

</html>