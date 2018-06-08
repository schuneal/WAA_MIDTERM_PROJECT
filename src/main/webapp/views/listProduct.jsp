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
	<tr><th>Product ID</th>
		<th>Product Name</th>
		<th>Product Description</th>
		<th>Price</th>
		<th>Product Type</th>
		<th><a href="#">edit</a></th></tr>
	<c:forEach var="product" items="${products}">
	<tr>
		<td>${product.id}</td>
		<td>${product.productName}</td>
		<td>${product.description}</td>
		<td>${product.price}</td>
		<td>${product.productType}</td>
		<td><a href="product/${product.id}">EDIT</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="createProduct"> Create Product</a>
</body>
</html>