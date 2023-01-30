<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@page import="com.ecommerce.demo.POJO.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="Logout.jsp">Logout</a>
<br><br>	

<h1 align="center">List of Shoes</h1>
<%@include file="searchshoe.jsp" %><br><br>	

<%List<ShoeData> s=(List<ShoeData>)request.getAttribute("list");%>
<table border="1">
<tr><th>ShoeId</th><th>Name</th><th>Price</th><th>Action</th></tr>
<%for(ShoeData sd:s){%>
<tr><td><%=sd.getShoeId() %></td><td><%=sd.getShoeName() %></td><td><%=sd.getShoePrice()%></td><td><a href="buyshoe.jsp?shoePrice=<%=sd.getShoePrice() %> ">BuyNow</a></td></tr>
<%}%>
</table>
</body>
</html>