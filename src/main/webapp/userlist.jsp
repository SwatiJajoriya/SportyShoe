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
<a href="adminhomepage.jsp">Home</a>&nbsp
<a href="Logout.jsp">Logout</a>
<br><br>	
<h1 align="center"><a href="insertuser.jsp">Insert More Users</a></h1>

<%@include file="searchuser.jsp" %><br><br>	

<%List<UserData> u=(List<UserData>)request.getAttribute("list");%>

<table border="1">
<tr><th>UserId</th><th>Name</th><th>Email</th><th>Phone No.</th><th>Username</th><th>Password</th><th>Action</th></tr>
<%for(UserData ud:u){%>
<tr><td><%=ud.getId()%></td><td><%=ud.getName()%></td><td><%=ud.getEmail()%></td><td><%=ud.getPhono()%></td><td><%=ud.getUsername()%></td><td><%=ud.getPassword()%></td><td><a href="edituser.jsp?id=<%=ud.getId()%>">Edit</a><br><a href="deleteuser.jsp?id=<%=ud.getId()%>">Delete</a></td></tr>
<%}%>

</table>
</body>
</html>