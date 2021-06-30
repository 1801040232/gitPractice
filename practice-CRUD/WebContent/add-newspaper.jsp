<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add newspaper</title>
</head>
<body>
	<jsp:include page="nav-bar.jsp"></jsp:include>


	<form action="insert">
		<input type="text" name="title" /> <input type="text" name="content" />
		<button type="submit">Submit</button>
	</form>

</body>
</html>