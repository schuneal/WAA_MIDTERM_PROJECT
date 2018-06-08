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
	<h1>Your product is added successfully</h1>
	<h3>Product Detail</h3>
	<br />
	<table border=2px>
		<tr>
			<th>Product Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Product Type</th>
			<th></th>
		</tr>
		<tr>
			<td>${product.productName}</td>
			<td>${product.description}</td>
			<td>${product.price}</td>
			<td>${product.productType}</td>
			<td><a href="#">Edit</a></td>
		</tr>
	</table>
	<br />
	<a href="secure">Go to home page</a>
</body>
</html>