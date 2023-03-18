<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Service</title>
    <link rel="stylesheet" href="style.css">

</head>

<body class="admin-panel">
	<%
		String msg = (String)request.getAttribute("msg");
		String added = (String)request.getAttribute("success");
	%>
    <div class="wrapper nav">

        <div>
            <a href="addplaceview">Add Places</a>
        </div>
        <div>
            <a style="background-color: #0E8388" href="addservicesview">Add Services</a>
        </div>
        <div>
            <a href="ViewBookings.jsp">View All Bookings</a>

        </div>
        <div>
            <a href="acceptbooking">Accept/Reject Bookings</a>

        </div>
        <div>
            <a href="adminlogout">Logout</a>

        </div>
      </div>
        <div class="wrapper">
            <form action="addservice" method="post">
                <div>
                    <input placeholder="Service" type="text" name="sname" id="service">
                </div>
                <div>
                    <input placeholder="Cost of Service" type="text" name="cost" id="cost">
                </div>
                <button>Add Service</button>
            </form>
            <%
        		if(added != null){
        			%>
        			<p><%= added %></p>
        			
        			<% 
        		}
        		
        	%>
        </div>
        <div>
        	<%
        		if(msg != null){
        			%>
        			<p style="color: red;"><%= msg %></p>
        			
        			<% 
        		}
        		
        	%>
        </div>
</body>

</html>