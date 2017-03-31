<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="gasoline.store.model.GasBean" %>    
<jsp:useBean id="forexRecords" type="java.sql.ResultSet" scope="request"/> 
	   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gasoline eStore</title>

<style>
body {background-color: lightblue;}
.yo {#6792A0; color: lightblue; text-shadow: 0px 2px 3px #555; 

	width: 500px; margin: 0 auto; background: #222; padding: 20px;
	font-size: 22px; color: #lightblue; text-shadow: 0px 2px 3px #171717;
	
	-webkit-box-shadow: 0px 2px 3px #555;
	-moz-box-shadow: 0px 2px 3px #555;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	
}

</style>
</head>
<body>
     <div class="container">
  
  <div class="page-header"><hr style="height:10px"><b>GASOLINE eSTORE</b></div>
  
  <div class="row">
	
    <div class="col-lg-12 yes" style="background-color:#F47940;"><br>
      <br><table align="center" border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>Transaction ID</th>
			<th>Fuel Type</th>
			<th>Number of Liters</th>
			<th>Purchase per Liter</th>
			<th>Purchase Amount</th>
			<th>Vat</th>
			<th>Total Amount</th>
			<th>Credit Card Type</th>
			<th>Credit Card Number</th>
		</tr>
		
		<% while (forexRecords.next()) { %>
			<tr>
				<td align="center"><%=forexRecords.getInt("id") %></td>
				<td align="center">
					<%=forexRecords.getString("fuelType") %></td>
				<td align="center">
					<%=forexRecords.getInt("lNum") %></td>
				<td align="center">
					<%=forexRecords.getDouble("ppLit") %></td>		
				<td align="center">
					<%=forexRecords.getDouble("purAm") %></td>	
				<td align="center">
					<%=forexRecords.getDouble("VatAm") %></td>	
				<td align="center">
					<%=forexRecords.getDouble("TotalAm") %></td>
				<td align="center">
					<%=forexRecords.getString("creditType") %></td>	
				<td align="center">
					<%=forexRecords.getLong("creditNum") %></td>	
			</tr>	
		<% } %>
	</table>
    </div>
    
	
	<div class="col-xs-12"><br>
	<form action="index.jsp" method="post">
					<button type="submit" class="btn btn-warning btn-block" style="font-size:20px;"><b>Submit<b></button>
				</form></div>
	
  </div>
</div>
</body>
</html>



