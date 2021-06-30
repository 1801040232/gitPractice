<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta title="viewport" content="width=device-width, initial-scale=1">
<title>Newspaper List</title>
</head>
<body>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<br>

	<table border="1">
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
				<td><a href="delete?id=<c:out value='${n.id}' />">Delete</a></td>
				<td><a href="edit?id=<c:out value='${n.id}' />">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>