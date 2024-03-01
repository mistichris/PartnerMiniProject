<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Address Book Page</title>
</head>
<body>
	<h1>Edit Address Book</h1>
	<form method="post" action="EditAddressBookServlet">
		<h2>Edit List Owner and Title:</h2>
		<%--  items="${requestScope.allLists}" var="currentAddressBook" --%>
		<input type="hidden" name="id" value="${listToEdit.id}">
		<input type="hidden" name="ownerId" value="${listToEdit.owner.getId()}">
		List Name: <input type="text" name="listName"
			value="${listToEdit.listName}"> <br />
		<!-- List Name -->
		<!-- List Owner List  -->
		Address Book Creator: <input type="text" name="listOwner"
			value="${listToEdit.owner}"> <br />
		<!-- Created Date  -->
		<!-- List Items -->
		<h2>Edit Contacts in Address Book:</h2>
		<!-- Iterate threw all Contact Items -->
		<c:forEach items="${requestScope.allItems}" var="contactsList">
			<input type="checkbox" id="allItemsToAdd" name="allItemsToAdd"
				value="${contactsList.id}">
			<b> ${contactsList.firstName} ${contactsList.lastName}</b>
			<table>
				<tr>
					<td>${contactsList.firstName}${contactsList.lastName}</td>
					<td></td>
					<td colspan="3">Phone#: ${contactsList.phone}</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3">Email: ${contactsList.email}</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3">Address: ${contactsList.streetAddress}</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="4">${contactsList.city}${contactsList.state}
						${contactsList.zip}</td>

				</tr>
			</table>
		</c:forEach>
		<input type="submit" value="Edit List and Add Items">
	</form>
	<br />
	<form action="viewAllAddressBooksServlet" method="get">
		<button type="submit">Return To All Address Books</button>
	</form>
	<br />
	<form action="viewAllItemsServlet" method="get">
		<button type="submit">Return to Contacts List</button>
	</form>
	<br />
	<button onclick="window.location.href='add-contact.jsp'">Add A
		New Contact Instead</button>
	<br />
	<button onclick="window.location.href='index.html'">Main Menu</button>
</body>
</html>