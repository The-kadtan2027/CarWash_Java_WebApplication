<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.cw.dao.*"
    import="com.cw.dto.*"
    import="java.util.ArrayList"
   	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View user bookings</title>
<link rel="stylesheet" type="text/css" href="style-users.css">
</head>
<body>
	<%
		UserBean user = (UserBean)session.getAttribute("user");
		ArrayList<BookingsBean> bookings = null;
		if(user == null){
			request.setAttribute("msg", "Something went wrong...");
			request.getRequestDispatcher("LoginUser.jsp").forward(request, response);
			
		}else{
			
				bookings = new BookingsDAO().getUserBookings(user.username());
		}
		
	%>

	<div class="user-nav">
        <h3>Hi, <%= user.firstName() %></h3>
        <a class="btn" href="book-slot-view">Home</a>
        <a class="btn" href="user-logout">Logout</a>
    </div>
	
	<div class="wrapper">
		
		<table>
			<thead>
			
				<tr>	
					<th>BookingId</th>
					<th>Services</th>
					<th>Place</th>
					<th>Date</th>
					<th>Model</th>
					<th>Booking Status</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>
			<%
				
			for(BookingsBean booking : bookings){
				%>
				<tr>
					<td><%=booking.bId() %></td>
					<td><%= booking.service() %></td>
					<td><%= booking.place() %></td>
					<td><%= booking.date() %></td>
					<td><%= booking.carName() %></td>
					<td><%= booking.status() %></td>
					<td><%= booking.amount() %></td>
				</tr>
					<%
			}
			
			%>
			</tbody>
		</table>
		
	</div>
	

</body>
</html>