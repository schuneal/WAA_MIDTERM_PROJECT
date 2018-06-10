<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Profile</title>
</head>
<body>
	<h2>Update Profile</h2>
	<a href="<c:url value="/logout" />"> Now logout </a>

	<form action="updateprofile" method="post">
	<table>
		<tr>
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
			<td><input type="hidden" name="email"
				value="${person.email}" /></td>
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

</body>
</html>