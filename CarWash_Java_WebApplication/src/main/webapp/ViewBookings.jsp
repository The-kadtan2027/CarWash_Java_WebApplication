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
            <a href="addplaceview">Add Places</a>
        </div>
        <div>
            <a href="addservicesview">Add Services</a>
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
					<option value="all">All</option>
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
			
			<div >
				<label>Date: </label>
				<input style="width: 70px; height: 40px" type="date" name="date" required>
				
			</div>
			<button>View Bookings</button>
		</form>
	</div>
	
	<%
		ArrayList<BookingsBean> list = (ArrayList<BookingsBean>)request.getAttribute("bookings");
	
		if(list != null ){
	%>
		<div class="table">
			<table cellpadding="0" cellspacing="0" border="0" bgcolor="#eeeeee" align="left" valign="center" width="100%">
				<thead>
					<tr>
						<th data-label="Id">Booking Id</th>
						<th data-label="Name">Name</th>
						<th data-label="Services">Services</th>
						<th data-label="Place">Place</th>
						<th data-label="Model">Model Name</th>
						<th data-label="VehicleNo">Vehicle No.</th>
						<th data-label="date">Date</th>
						<th data-label="status">Status</th>
						<th data-label="payment">Payment</th>
					</tr>
				</thead>
				<tbody>
				<%
				for(BookingsBean bb : list){
					%>
						<tr><td data-label="Id" ><%=bb.bId()%></td>
							<td data-label="Name"><%=bb.name()%></td>
							<td data-label="Services"><%=bb.service()%></td>
							<td data-label="Place"><%=bb.place()%></td>
							<td data-label="Model"><%=bb.carName()%></td>
							<td data-label="VehicleNo"> <%=bb.carRegNo()%></td>
							<td data-label="date"><%=bb.date()%></td>
							<td data-label="status"><%=bb.status()%></td>
							<td data-label="payment"><%=bb.amount() %></td>
						</tr>
					
					<%
				}
				%>
				</tbody>
			</table>
		</div>
				<%
			}
		%>
</body>
</html>