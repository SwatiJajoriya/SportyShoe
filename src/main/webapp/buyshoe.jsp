<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="buyshoe">
<input type="hidden" name="shoePrice" value=<%=request.getParameter("shoePrice") %>>

Bank Name <input type="text" name="bname"><br><br>

<input type="submit" value="Proceed to Pay">

</form>
</body>
</html>