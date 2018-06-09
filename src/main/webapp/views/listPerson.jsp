<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products currently in the shop</title>
</head>
<body>
	<a href="<c:url value="/logout" />"> Now logout </a>

	<h1>Available Products List</h1>
	<table border="2pt">
	<tr><th>First Name</th>
		<th>Last Name</th>
		<th>Phone</th>
		<th>Email</th>
		<th>City</th>
		<th>State</th>
		<th>Country</th>
		<th>Zip Code</th>
		<!-- <th>Password</th> -->
		
		<th><a href="#">edit</a></th></tr>
	<c:forEach var="person" items="${persons}">
	<tr>
		<td>${person.firstName}</td>
		<td>${person.lastName}</td>
		<td>${person.phone}</td>
		<td>${person.email}</td>
		<td>${person.address.city}</td>
		<td>${person.address.state}</td>
		<td>${person.address.country}</td>
		<td>${person.address.zipcode}</td>
	<%-- 	<td>${person.password}</td> --%>
		<td><a href="person/${person.id}">EDIT</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="createPerson"> Create Person</a>
</body>
</html>