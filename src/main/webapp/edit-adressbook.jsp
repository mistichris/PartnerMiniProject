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
	<form>
		<!-- List Name -->
		<!-- List Owner List  -->
		<!-- Created Date  -->
		<!-- List Items -->
		<table>
			<!-- Iterate threw all Contact Items -->
			<c:forEach items="${currentAddressBook.listOfContacts}"
				var="contactsList">
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
			</c:forEach>

		</table>
	</form>

</body>
</html>