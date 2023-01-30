<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>Insert Shoes Details</h1>
<body>

<%@include file="searchshoe.jsp" %>
<br><br>

<form action="insertshoe">
ShoeName <input type="text" name="shoeName"><br><br>

Price <input type="text" name="shoePrice"><br><br>

<input type="submit" value="Insert">

</form>
</body>
</html>