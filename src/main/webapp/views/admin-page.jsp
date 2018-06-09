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
	<h3>Admin Welcome ${person.firstName} </h3>
	<a href="<c:url value="/logout" />"> Now logout </a>

	<hr />
	<h2>Product</h2>
	<h3>
		<a href="createProduct">Create Product</a>
	</h3>
	<h3>
		<a href="listProduct">List of Products</a>
	</h3>
	<!-- <h3>
		<a href="delete-product">Delete Product</a>
	</h3>
	<h3>
		<a href="update-product">Update Product</a>
	</h3> -->
	<hr />

	<h2>Person</h2>
	<h3>
		<a href="createPerson">Create Person</a>
	</h3>
	<h3>
		<a href="listPerson">List of Person</a>
	</h3>
	<hr />

	<h2>Order</h2>
	<h3>
		<a href="listOrder">List of Orders</a>
	</h3>
	
	<hr />

</body>
</html>