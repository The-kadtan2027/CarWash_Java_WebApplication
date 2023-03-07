<%@page import="com.cw.servlets.AddPlaceServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList"
    import="com.cw.dao.PlaceDAO"
    import="com.cw.dto.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Bookings</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="admin-panel">
	<%
		ArrayList<PlaceBean> places = new PlaceDAO().getPlaces();
	%>
	<div class="wrapper nav">

        <div>
            <a href="addplace.html">Add Places</a>
        </div>
        <div>
            <a href="addservice.html">Add Services</a>
        </div>
        <div>
            <a style="background-color: #0E8388" href="ViewBookings.jsp">View All Bookings</a>

        </div>
        <div>
            <a href="acceptbooking">Accept/Reject Bookings</a>

        </div>
        <div>
            <a href="adminlogout">Logout</a>

        </div>
      </div>
	<div class="wrapper booking-view">
		<form class="form-container" action="view" method="post">
			<div>
				<label>Select Place</label>
				<select id="places" name="place">
					<option>Select Place</option>
					<%
						if(places != null){
						for(PlaceBean pb : places){
							%>
							<option value="<%= pb.place() %>"><%= pb.place() %></option>
							<%
						}};
					%>
					
				</select>
			</div>
			
			<div>
				<label>Date: </label>
				<input type="date" name="date" required>
				
			</div>
			<button>View Bookings</button>
		</form>
	</div>
	
	<%
		ArrayList<BookingsBean> list = (ArrayList<BookingsBean>)request.getAttribute("bookings");
	
		if(list != null ){
				%>
		<div class="wrapper-booings">
			<table>
				<tr><th>Booking Id</th><th>Customer Name</th>
					<th>Username</th><th>Services</th><th>Place</th>
					<th>Model Name</th><th>Vehicle No.</th><th>Date</th><th>Status</th></tr>
				<%
				for(BookingsBean bb : list){
					%>
						<tr><td><%=bb.bId()%></td>
							<td><%=bb.name()%></td>
							<td><%=bb.username()%></td>
							<td><%=bb.service()%></td>
							<td><%=bb.place()%></td>
							<td><%=bb.carName()%></td>
							<td><%=bb.carRegNo()%></td>
							<td><%=bb.date()%></td>
							<td><%=bb.status()%></td>
						</tr>
					
					<%
				}
				%>
				
			</table>
		</div>
				<%
			}
		%>
	
	
	
</body>
</html>