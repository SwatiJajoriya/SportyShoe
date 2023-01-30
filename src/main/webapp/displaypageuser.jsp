<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2><%=request.getAttribute("msg") %></h2>
<h1><i>Display the Shoes List</i></h1>
<form action="usershoelist">
<input type="submit" value="Shoelist">
</form>
</body>
</html>