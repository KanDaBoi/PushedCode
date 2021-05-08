<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD BUSINESS FLIGHT</title>
</head>
<body>
	<sf:form action="/flights/business" method="post" name="form" modelAttribute="passenger">
		<table>
			<caption>FILL PASSENGER DETAILS</caption>
			<tr>
				<td>Name:</td>
				<td><sf:input type="textbox" id="name" path="name" /></td>
			</tr>
			<tr>
				<td>VIP Status:</td>
				<td><sf:input type="textbox" id="vip" path="vip" value="true"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Enter Details" /></td>
				<td><input type="reset" value="Cancel"></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>