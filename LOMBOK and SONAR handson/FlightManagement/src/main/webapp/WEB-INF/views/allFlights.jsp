<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Listing</title>
</head>
<body>
	<h2>The available flights are:-</h2>
	<table style="border: 2px solid black">
		<thead>
			<tr>
				<td>Flight Details</td>
				<td>Passenger To Remove</td>
			</tr>
		</thead>
		<c:forEach items="${flights}" var="flight">
			<tr>
				<td><c:out value="${flight}" /></td>
				<c:forEach items="${flight.passengers }" var="passenger">
					<td><c:out value="${passenger }" /></td>
					<td><a href="/flights/${flight.flightType }?param1=${passenger.name }&param2=${passenger.vip}" >Remove this passenger</a></td>	
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a href="/flights">Return to homepage</a>
</body>
</html>
