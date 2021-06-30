<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="update">
		<input type="text" name="id" value="${newspaper.id}" readonly /> 
		<input type="text" name="title" value="${newspaper.title}" /> 
		<input type="text" name="content" value="${newspaper.content}" />
		<button type="submit">Submit</button>
	</form>
</body>
</html>