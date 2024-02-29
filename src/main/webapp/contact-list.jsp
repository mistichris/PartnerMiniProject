<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Contacts from Address List</title>
</head>
<body>
	<h1>Contacts List</h1>
	<form method="post" action="navigationServlet">
		<table>
			<!-- pull variable created in ViewAllItemsServlet and assign a new variable to use in page  -->
			<c:forEach items="${requestScope.allContacts}" var="currentContact">
				<tr>
					<td><input type="radio" name="id" value="${currentContact.id}"></td>
					<td>${currentContact.firstName}</td>
					<td>${currentContact.lastName}</td>
					<td>${currentContact.phone}</td>
					<td>${currentContact.email}</td>
					<td>${currentContact.streetAddress}</td>
					<td>${currentContact.city}</td>
					<td>${currentContact.state}</td>
					<td>${currentContact.zip}</td>
				</tr>
			</c:forEach>
		</table>
		<br /> <input type="submit" value="Edit" name="doActionToContact">
		<input type="submit" value="Delete" name="doActionToContact">
	</form>
	<br />
	<button onclick="window.location.href='add-contact.jsp'">Add A
		New Contact</button>
	<button onclick="window.location.href='index.html'">Main Menu</button>
</body>
</html>