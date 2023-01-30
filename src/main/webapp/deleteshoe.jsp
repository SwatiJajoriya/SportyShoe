<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1><i>Delete the Shoes</i></h1>
<form action="deleteshoe">
<input type="hidden" name="shoeId" value=<%=request.getParameter("shoeId") %>>

<input type="submit" value="Delete">
</form>
</body>
</html>