<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Address Book Page</title>
</head>
<body>
	<h1>Add A New Address Book</h1>
	<form action="createNewAddressBookServlet" method="post">
		<h2>Enter List Details</h2>
		<div>
			<label for="addressBookName">Address Book Name: </label> <input
				type="text" name="addressBookName" placeholder="Address Book Name">
		</div>
		<div>
			<label for="listOwner">List Created By: </label> <input type="text"
				name="listOwner" placeholder="Jane Smith">
		</div>
		<h2>Choose Contacts To Add</h2>
		<div>
			<!-- 	<select name="allItemsToAdd" multiple size=""> -->
			<c:forEach items="${requestScope.allItems}" var="contactsList">
				<input type="checkbox" id="allItemsToAdd" name="allItemsToAdd"
					value="${contactsList.id}">
				<b> ${contactsList.firstName} ${contactsList.lastName}</b>
				<table>
					<tr>

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
			<!-- 			</select> -->
		</div>
		<input type="submit" value="Create List and Add Items">
	</form>
	<button onclick="window.location.href='add-contact.jsp'">Add A
		New Contact Instead</button>


</body>
</html>