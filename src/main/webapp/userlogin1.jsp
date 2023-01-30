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

<h2><%="Welcome "+request.getAttribute("name") %></h2>

<h3><%=request.getAttribute("msg") %></h3>
<%@include file="userlogin.jsp" %>
</body>
</html>