<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books currently in the shop</title>
</head>
<body>
	<h1>Person added successfully</h1>
	<h3>Person Detail</h3>
	<br />
	<table border=2px>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Enable</th>
		</tr>
		<tr>
			<td>${person.firstName}</td>
			<td>${person.lastName}</td>
			<td>${person.email}</td>
			<td>${person.address}</td>
			<td>${person.phone}</td>
			<td>${person.enable}</td>
			<td><a href="#">Edit</a></td>
		</tr>
	</table>
	<br />
	<a href="secure">Go to home page</a>
</body>
</html>