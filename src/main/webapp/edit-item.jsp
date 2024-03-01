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
		FirstName: <input type="text" name="firstName" value="${itemToEdit.firstName}">
		LastName: <input type="text" name="lastName" value="${itemToEdit.lastName}">
		Phone: <input type="text" name="phone" value="${itemToEdit.phone}">
		Email: <input type="text" name="email" value="${itemToEdit.email}">
		Street Address: <input type="text" name="streetAddress" value="${itemToEdit.streetAddress}">
		LastName: <input type="text" name="lastName" value="${itemToEdit.lastName}">
		City: <input type="text" name="city" value="${itemToEdit.city}">
		State: <input type="text" name="state" value="${itemToEdit.state}">
		Zip: <input type="text" name="zip" value="${itemToEdit.zip}">
		
		<input type="submit" value="Save Edited Book">
	</form>
		
	<br />
	<form action="addItemServlet" method="post">
		<button type="submit">Add a Book</button>
	</form>
	<br />
	<button onclick="window.location.href='add-contact.jsp'">Add A
		New Contact</button>
	
	<form action="viewAllAddressBooksServlet" method="get">
		<button type="submit">View All Address Books</button>
	</form>
	<button onclick="window.location.href='index.html'">Main Menu</button>
</body>
</html>