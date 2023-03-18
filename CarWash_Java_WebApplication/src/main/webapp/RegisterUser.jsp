<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
<link
	rel="stylesheet"
	href="style.css"
>
</head>
<body>
<%
	String uname = (String)request.getAttribute("uname");
	String isMail = (String)request.getAttribute("msg1");
	String isPhone = (String)request.getAttribute("msg2");
	String fname = (String)request.getAttribute("fname");
	String lname = (String)request.getAttribute("lname");
	String add = (String)request.getAttribute("add");
	String phone = (String)request.getAttribute("phone");
	String mail = (String)request.getAttribute("mail");
	

%>
	<div class="wrapper">

		<h1>User Registration</h1>
		<form action="registeruser" method="post">
			<div>
				<input placeholder="First Name"type="text" autocomplete="off" value="<%= fname == null ? "" : fname %>" name="fname"required/>

			</div>
			<div>
				<input placeholder="Last Name"type="text" autocomplete="off" value="<%= lname ==null ? "" : lname %>"  name="lname" />

			</div>
			<div>
				<input
					placeholder="Phone Number"type="tel" autocomplete="off" value="<%= phone == null ? "" : phone %>"  name="phone"required/>

			</div>
			<%
				if(isPhone != null){
					%>
					<p style="color:red;"><%=isPhone %></p>
					
					<%
				}
			%>
			<div>
				<input	placeholder="Email"	type="email" value="<%= mail == null ? "" : mail %>" 	name="mailid"	required/>

			</div>
			<%
				if(isMail != null){
					%>
					<p style="color:red;"><%=isMail %></p>
					
					<%
				}
			%>
			<div>
				<textarea
					placeholder="Address"
					rows="4"
					cols="30"
					name="address"
				><%= add == null ? "" : add %> </textarea>

			</div>
			<div>
				<input	placeholder="Username"	type="text"name="username"	required	value="<%=uname ==null ? "" : uname %>"/>
			</div>
			<div>
				<input placeholder="Password"	type="password"	name="password"	required/>
			</div>
			<button>Register</button>
		</form>
	</div>

</body>
</html>