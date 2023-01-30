<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.ecommerce.demo.POJO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="userlogin.jsp">Login</a>&nbsp
<a href="Logout.jsp">Logout</a><br>
<h1>Register-SignUp</h1>
<br>



<form action="registeruser">


Full Name <input type="text" name="name"><br><br>

Email     <input type="email" name="email"><br><br>

Phone No. <input type="text" name="phono"><br><br>

Username  <input type="text" name="username"><br><br>

Password  <input type="password" name="password"><br><br>

<input type="submit" value="SignUp">

</form>



</body>
</html>