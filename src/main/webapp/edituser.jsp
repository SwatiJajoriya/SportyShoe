<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><i>Edit the User</i></h1>
<form action="edituser">
<input type="hidden" name="id" value=<%=request.getParameter("id") %>>

Name <input type="text" name="name"><br><br>

Email <input type="email" name="email"><br><br>

Phone No. <input type="text" name="phono"><br><br>

Username <input type="text" name="username"><br><br>

Password <input type="text" name="password"><br><br>

<input type="submit" value="Edit">

</form>
</body>
</html>