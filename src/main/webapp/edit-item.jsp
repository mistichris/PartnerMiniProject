<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Contact Item</title>
</head>
<body>
	<h1>Edit Book Form</h1>
	<form action="EditBookServlet" method="post">
		Book Title: <input type="text" name="book" value="${bookToEdit.book}">
		Author: <input type="text" name="author" value="${bookToEdit.author}">
		<input type="hidden" name="id" value="${bookToEdit.id}"> 
		<input type="submit" value="Save Edited Book">
	</form>
		
	<br />
	<form action="AddBookServlet" method="post">
		<button type="submit">Add a Book</button>
	</form>
	<br />
	<button onclick="window.location.href='index.html'">Main Menu</button>
</body>
</html>