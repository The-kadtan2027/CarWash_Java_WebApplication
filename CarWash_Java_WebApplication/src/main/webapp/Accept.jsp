<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList"
    import="com.cw.dto.BookingsBean"
    import="com.cw.dao.BookingsDAO"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accept and Reject Bookings</title>
	<link rel="stylesheet" href="style.css">
</head>
<body class="admin-panel">
	<%
		ArrayList<BookingsBean> bookings = new BookingsDAO().getPendingBookings();
	%>
	<div class="wrapper nav">

        <div>
            <a  href="addplaceview">Add Places</a>
        </div>
        <div>
            <a href="addservicesview">Add Services</a>
        </div>
        <div>
            <a href="ViewBookings.jsp">View All Bookings</a>

        </div>
        <div>
            <a style="background-color: #0E8388" href="acceptbooking">Accept/Reject Bookings</a>

        </div>
        <div>
            <a href="adminlogout">Logout</a>

        </div>
      </div>
      
      <div class="bookings">
      	<%
      		if(bookings != null){
      			for(BookingsBean bb : bookings){
      			%>
      				<div class="wrapper booking">
      					<form action="acceptreject" method="post">
      						<div >
      							<input type="text" readonly="readonly" name="bid" value="<%=bb.bId() %>">
      							<input type="text" readonly="readonly" name="name" value="<%=bb.name() %>">
      							<input type="text" readonly="readonly" name="cModel" value="<%=bb.carName()%>">
      							<input type="text" readonly="readonly" name="service" value="<%=bb.service()%>">
      							<input type="text" readonly="readonly" name="status" value="<%=bb.status()%>">
      							
      							<input type="submit" name="btn" value="Accept">
      							<input type="submit" name="btn" value="Reject">
      			
      						</div>
      					</form>
      				</div>
      			<%
      			}
      		}
      	%>
      		
      	
      </div>
	
</body>
</html>