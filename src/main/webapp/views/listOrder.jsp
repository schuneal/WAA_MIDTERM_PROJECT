<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Orders</title>
</head>
<body>
	<a href="<c:url value="/logout" />"> Now logout </a>

	<h1>List of Orders</h1>
	<table border="2pt">
		<c:forEach var="order" items="${orders}">
			<tr>
				<th colspan=3>${order.person.firstName}</th>
			</tr>
			<tr>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Order Date</th>
					<%-- 	<td><a href="order/${order.id}">EDIT</a></td> --%>
				</tr>

			<c:forEach var="ol" items="${order.orderLines}">
				<tr>
					<td>${ol.product.productName}</td>
					<td>${ol.quantity}</td>
					<td>${order.orderDate}</td>
					<%-- 	<td><a href="order/${order.id}">EDIT</a></td> --%>
				</tr>
			</c:forEach>

		</c:forEach>
	</table>
</body>
</html>