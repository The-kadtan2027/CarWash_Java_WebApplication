<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login page</title>

    <link rel="stylesheet" href="style.css">
</head>

<body>
	<%
		String msg = (String)request.getAttribute("msg");
		String uname = (String)request.getAttribute("username");
	%>
    <div class="wrapper">
        <h1>User Login</h1>
        <form action="userlogin" method="post">
            <div class="uname">
                <input type="text" placeholder="Username" required="required" autocomplete="off" name="uname" value="<%= uname == null ? "": uname %>" id="uname">
            </div>
            <div class="pword">
                <input type="password" placeholder="Password" required="required" name="pword" id="pword">
                <!-- <label for="show">
                    <input type="checkbox" name="show" id="show"> Show Password
                </label> -->
            </div>
            <div class="btn">

                <button name="btn" value="signin">SignIn</button>
                <button name="btn" value="signup">SignUp</button>
            </div>
            <a href="AdminLogin.jsp">Login as Admin</a>
        </form>

    </div>
    <div>
		<%
			if(msg != null){
				%>
				<p style="color: red;"><%=msg %></p>
				<%
			}
			
		%>
    </div>
</body>

</html>