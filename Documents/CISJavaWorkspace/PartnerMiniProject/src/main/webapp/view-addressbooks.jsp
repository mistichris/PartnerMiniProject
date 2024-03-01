<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Address Book Lists</title>
</head>
<body>
	<h1>All Address Books List</h1>
	<form action="navigationAllListsServlet" method="post">
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentAddressBook">
				<input type="radio" name="id"
						value="${currentAddressBook.id}"> <b>${currentAddressBook.listName}</b>
				<table>
				<tr>
					<td>Address Book Owner: ${currentAddressBook.owner}</td>
					<td colspan="2">Created Date:
						${currentAddressBook.createdDate}</td>
				</tr>
				<c:forEach items="${currentAddressBook.listOfContacts}"
					var="contactsList">
					<tr>
						<td>${contactsList.firstName}${contactsList.lastName}</td>
						<td></td>
						<td colspan="3">Phone#: ${contactsList.phone}</td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2">Email: ${contactsList.email}</td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2">Address: ${contactsList.streetAddress}</td>
					</tr>
					<tr>
						<td></td>
						<td colspan="3">${contactsList.city}${contactsList.state}
							${contactsList.zip}</td>

					</tr>
				</c:forEach>
				</table>
			</c:forEach>
		</table>
		<input type="submit" value="Edit An Address Book" name="doThisToList">
		<input type="submit" value="Delete An Address Book"
			name="doThisToList"> <input type="submit"
			value="Add An Address Book" name="doThisToList">
	</form>
	<form action="viewAllItemsServlet" method="get">
		<button type="submit">View All Contacts</button>
	</form>
	<button onclick="window.location.href='add-contact.jsp'">Add A
		New Contact</button>
	<button onclick="window.location.href='index.html'">Main Menu</button>
</body>
</html>