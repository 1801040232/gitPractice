<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Newspaper List</title>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>title</th>
			<th>content</th>
		</tr>
		<c:forEach var="n" items="${list}">
			<tr>
				<td><c:out value="${n.id}" /></td>
				<td><c:out value="${n.title}" /></td>
				<td><c:out value="${n.content}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>