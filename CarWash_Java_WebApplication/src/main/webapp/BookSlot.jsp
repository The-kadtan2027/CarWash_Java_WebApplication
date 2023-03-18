<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="com.cw.dto.*"
    import="com.cw.dao.*"
    import="java.util.ArrayList"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Slot</title>

	<link rel="stylesheet" href="style-users.css">
	
</head>
<body>
	<%
		UserBean ub = (UserBean)session.getAttribute("user");
		ArrayList<PlaceBean> list = new PlaceDAO().getPlaces();
		ArrayList<ServiceBean> services = new ServiceDAO().getServices();
		String captcha = new BookingsDAO().idGenerator();
		
	%>
	<div class="user-nav">
        <h3><%=ub.firstName() %></h3>
        <a href="viewUserBookings" class="btn">View Bookings</a>
        <a href="user-logout" class="btn">Logout</a>
    </div>
	<div class="wrapper form_container">
		<h1>Hi, <%= ub.firstName() %></h1>
		<p>Make an Appointment</p>
		<form action="bookslot" method="post" class="bookslot" >
			<div class="form_details">
			
				<div><input type="text" placeholder="Model Name" name="modelname" class="input_box"/></div>
				<div><input type="text" placeholder="Vehical Number" name="vNumber" class="input_box" /></div>
				<div class="select">
					<label>Select Place</label>
					
					<div>
						<select id="places" name="place">
							<option>Select Place</option>
							<%
								for(PlaceBean pb : list){
									%>
									<option value="<%= pb.place() %>"><%= pb.place() %></option>
									<%
								};
							%>
							
						</select>
					</div>
				</div>
				<div>
					  <p>Select what services you want</p>
					  <div id="checkboxes">
					  
					  <%
					  		for(ServiceBean sb : services){%>
					  		 	<div class="service">
					  		 	<label>
					  		 	
								    <input type="checkbox" name="services" value="<%= sb.serviceName()+","+sb.serviceCost()%>" />
								    <%= sb.serviceName() +" - Rs."+ sb.serviceCost()%></label>
								    
								 </div>
					  		 <%
					  		 }
					  %>
					</div>
				</div>
				<div class="date">
					<label>Select Booking Date:</label>
					<input width="80px" type="date" name="date" />
				</div>
				
				<div class="captcha">
					<span>Captcha:  </span>
					<span class="code"><%= captcha %></span>
					<label>Enter Captcha:</label>
					<input type="text" name="captcha" >
					<input type="hidden" value="<%= captcha %>" name="generatedCaption" >
				</div>
				<button class="btn">Book</button>
				
			</div>
			
		</form>
		
		
		<% 
			String s = (String)request.getAttribute("msg");
			if(s != null){
				%>
				
					<p><%= s %></p>
				<%
			}
		%>
		
	</div>

</body>
</html>