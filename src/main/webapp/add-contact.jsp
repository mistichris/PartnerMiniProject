<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a New Contact Form</title>
</head>
<body>
	<h1>Add A New Contact To Database</h1>
	<form action="AddItemServlet" method="post">
		<h2>Contact Info:</h2>

		<table>

			<tr>
				<td>First Name: <input type="text" name="firstName"></td>
				<td>Last Name: <input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>Email: <input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Phone: <input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>Street Address: <input type="text" name="streetAddress"></td>
			</tr>
			<tr>
				<td>City: <input type="text" name="city"></td>
				<td>State: <input type="text" name="state"></td>
				<td>Zip: <input type="text" name="zip"></td>
			</tr>
		</table>
		<input type="submit" name="Add Contact">
	</form>

	<button onclick="window.location.href='index.html'">Main Menu</button>
</body>
</html>