<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>International Patients Management System</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Pinyon+Script&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/style-table.css">
<link rel="stylesheet" href="/css/style-admin.css">
</head>
<body>
	<div class="main-container-register">
		<%@ include file="fragments/header.jsp"%>
		<div class="section grid">
			<%@ include file="admin-fragments/admin-sidebar.jsp"%>
			<div class="content list-container">
				<h1>Add A New Specialist</h1>
				<div class="container">
					<form:form action="addSpecialist" method="GET"
						modelAttribute="specialistDetail">
						<div class="form-group">
							<form:label path="specialistId">Enter Specialist ID:</form:label>
							<form:input path="specialistId" class="form-control"
								id="specialistId" required="required" />
						</div>
						<div class="form-group">
							<form:label path="name">Enter Specialist Name:</form:label>
							<form:input path="name" class="form-control" id="name"
								required="required" />
						</div>
						<div class="form-group">
							<form:label path="areaOfExpertise">Enter Area of Expertise:</form:label>
							<form:input path="areaOfExpertise" class="form-control"
								id="areaOfExpertise" required="required" />
						</div>
						<div class="form-group">
							<form:label path="experienceInYears">Enter Experience In Years:</form:label>
							<form:input path="experienceInYears" class="form-control"
								id="experienceInYears" required="required" />
						</div>
						<div class="form-group">
							<form:label path="contactNumber">Enter Contact Number:</form:label>
							<form:input path="contactNumber" class="form-control"
								id="contactNumber" required="required" />
						</div>
						<form:button class="btn">Add Specialist</form:button>
					</form:form>
				</div>

				<div class="container result-container center border">
					<c:if test="${status == 200 }">
						<h3>Specialist added successfully.</h3>
					</c:if>

				</div>
			</div>
		</div>
		<%@ include file="fragments/footer.jsp"%>
	</div>
</body>
</html>