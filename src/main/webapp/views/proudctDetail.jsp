<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Car</title>
</head>
<body>
	<a href="<c:url value="/logout" />"> Now logout </a>

	<form action="../product/${product.id}" method="post">
	<table border="2pt">
		<tr>
			<td>Product Name:</td>
			<td><input type="text" name="productName" value="${product.productName}" /> </td>
		</tr>
		<tr>
			<td>Product Description:</td>
			<td><input type="text" name="description" value="${product.description}" /> </td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name="price" value="${product.price}" /> </td>
		</tr>
		<tr>
			<td>Product Type:</td>
			<td><input type="text" name="productType" value="${product.productType}" /> </td>
		</tr>
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="../product/delete?productId=${product.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>