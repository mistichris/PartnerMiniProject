<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Contact Item</title>
</head>
<body>
	<h1>Edit Contact Info Form</h1>
	<form action="editItemServlet" method="post">
		<input type="hidden" name="id" value="${itemToEdit.id}"> 
			<p>
				FirstName: <input type="text" name="firstName" value="${itemToEdit.firstName}"></p>
			<p>
				LastName: <input type="text" name="lastName" value="${itemToEdit.lastName}"></p>
			<p>
				Phone: <input type="text" name="phone" value="${itemToEdit.phone}"></p>
			<p>
				Email: <input type="text" name="email" value="${itemToEdit.email}"></p>
			<p>
				Street Address: <input type="text" name="streetAddress" value="${itemToEdit.streetAddress}"></p>
			<p>
				City: <input type="text" name="city" value="${itemToEdit.city}"></p>
			<p>
				State: <input type="text" name="state" value="${itemToEdit.state}"></p>
			<p>
				Zip: <input type="text" name="zip" value="${itemToEdit.zip}"></p>
		<input type="submit" value="Save Edited Contact">
	</form>
		
	<br />
	<form action="viewAllItemsServlet" method="get">
		<button type="submit">Return to Contacts List</button>
	</form>
	<br />
	<button onclick="window.location.href='add-contact.jsp'">Add A New Contact Instead</button>
	<br />
	<form action="viewAllAddressBooksServlet" method="get">
		<button type="submit">View All Address Books</button>
	</form>
	<br />
	<button onclick="window.location.href='index.html'">Main Menu</button>
</body>
</html>