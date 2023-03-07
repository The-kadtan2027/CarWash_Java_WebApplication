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

	<link rel="stylesheet" href="style.css">
</head>
<body>
	<%
		UserBean ub = (UserBean)session.getAttribute("user");
		ArrayList<PlaceBean> list = new PlaceDAO().getPlaces();
		ArrayList<ServiceBean> services = new ServiceDAO().getServices();
	%>
	<div class="wrapper">
		<h1>Hi, <%= ub.firstName() %></h1>
		<form action="bookslot" method="post" class="bookslot" >
			<div><input type="text" placeholder="Model Name" name="modelname" /></div>
			<div><input type="text" placeholder="Vehical Number" name="vNumber" /></div>
			<div>
				<label>Select Place</label>
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
			<div>
				  <p>Select what services you want</p>
				  <%
				  		for(ServiceBean sb : services){%>
				  		 	<div class="service">
				  		 	<label>
				  		 	
							    <input type="checkbox" name="services" value="<%= sb.serviceName()%>" />
							    <%= sb.serviceName() +" - Rs."+ sb.serviceCost()%></label>
							 </div>
				  		 <%
				  		 }
				  %>
				
			</div>
			<div>
				<label>Select Booking Date:</label>
				<input type="date" name="date" />
			</div>
			
			<button>Book Slot</button>
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