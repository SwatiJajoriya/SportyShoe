<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><i>Delete the User</i></h1>
<form action="deleteuser">
<input type="hidden" name="id" value=<%=request.getParameter("id") %>>

<input type="submit" value="Delete">
</form>
</body>
</html>