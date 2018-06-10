<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<h3>User Welcome ${person.firstName}</h3>
	<a href="<c:url value="/logout" />"> Now logout </a>
	<hr />
	<h3>
		<a href="updateprofile">Update Profile</a>
	</h3>
	<h3>
		<a href="placeOrder">Place Order</a>
	</h3>
	<hr />
</body>
</html>