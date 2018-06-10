<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CoffeShopPlaceOrder</title>
</head>
<body>

	<a href="<c:url value="/logout" />"> Now logout </a>

	<form action="placeOrder" method="post">
		<table>
			<tr>
				<td>Select Product: </td>
				<td>
					<select name="productname">
						<c:forEach var="productName" items="${productNames}">
							<option>${productName}</option>
						</c:forEach>
					
					</select>
				
				</td>
			</tr>
			<tr>
				<td>Description: </td>
				<td>
					<select name="desciption">
						<c:forEach var="discr" items="${description}">
							<option>${discr}</option>
						</c:forEach>
					</select>
				
				</td>
				
			</tr>
			<tr>
				<td>Quantity: </td>
				<td>
					<select name="quantity">
						<c:forEach var="i" begin="1" end="10">
							<option>${i}</option>
						</c:forEach>
					</select>
				
				</td>
				
			</tr>
		</table>
		
		<input type="submit" value="order">
	
	</form>

</body>
</html>