<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1><i>Edit the Shoes</i></h1>
<form action="editshoe">
<input type="hidden" name="shoeId" value=<%=request.getParameter("shoeId") %>>

ShoeName <input type="text" name="shoeName"><br><br>

Price <input type="text" name="shoePrice"><br><br>

<input type="submit" value="Edit">

</form>
</body>
</html>