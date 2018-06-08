<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<h1><em>Please enter the product details below</em></h1>
	<a href="<c:url value="/logout" />"> Now logout </a>

	<form:form action="createProduct" modelAttribute="product" method="POST">
		<table>
			<tr>
				<td>Product Name:</td>
				<td><form:input path="productName" /></td>
				<td><form:errors path="productName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Product Type:</td>
				<td><form:input path="productType" /></td>
				<td><form:errors path="productType" cssClass="error" /></td>
			</tr>
		</table>
		<input type="submit" value="Add Product"/>
	</form:form>
</body>
</html>