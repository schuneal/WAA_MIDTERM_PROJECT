<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Car</title>
</head>
<body>
	<a href="<c:url value="/logout" />"> Now logout </a>

	<form action="../personUpdate" method="post">
	<table>
		<tr>
			<td>Person ID:</td>
			<td><input type="hidden" name="id"
				value="${person.id}" /></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="firstName"
				value="${person.firstName}" /></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="lastName"
				value="${person.lastName}" /></td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td><input type="text" name="phone" value="${person.phone}" />
			</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email" value="${person.email}" />
			</td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" name="city" value="${person.city}" /></td>
		</tr>

		<tr>
			<td>State:</td>
			<td><input type="text" name="state" value="${person.state}" />
			</td>
		</tr>

		<tr>
			<td>Country:</td>
			<td><input type="text" name="country" value="${person.country}" />
			</td>
		</tr>

		<tr>
			<td>Zip Code:</td>
			<td><input type="text" name="zipcode" value="${person.zipcode}" />
			</td>
		</tr>

		<tr>
			<td>Password:</td>
			<td><input type="text" name="password"
				value="${person.password}" /></td>
		</tr>
		</table>
		<input type="submit" value="update" />
	</form>
<%-- 	<form action="../person/delete?personId=${person.id}" method="post">
		<button type="submit">Delete</button>
	</form> --%>
</body>
</html>