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
	<form>
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentAddressBook">
				<tr>
					<td><input type="radio" name="id"
						value="${currentAddressBook.id}"></td>
					<td><h2>${currentlist.listName}</h2></td>
				</tr>

				<tr>
					<td>Address Book Owner: ${currentAddressBook.owner}</td>
					<td colspan="2">Created Date:
						${currentAddressBook.createdDate}</td>
				</tr>
				<c:forEach items="${currentAddressBook.listOfContacts}"
					var="contactsList">
					<tr>
						<td>${contactsList.firstName}
							${contactsList.lastName}</td>
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
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="Edit An Address Book" name="doThisToList">
		<input type="submit" value="Delete An Address Book"
			name="doThisToList"> <input type="submit"
			value="Add An Address Book" name="doThisToList">
	</form>

</body>
</html>