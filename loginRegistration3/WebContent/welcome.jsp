<%@page import="loginRegistration.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%// if you write this way then only the following works
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
if(session.getAttribute("user")==null) 
{
    response.sendRedirect("view.jsp");
} 
%>
Welcome... Here is your details:<br>
<%  
	user u=(user)session.getAttribute("user");
	out.println(u);
%>
Here is one video for you:<br> <br>
<iframe width="560" height="315" src="https://www.youtube.com/embed/uo35R9zQsAI" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<form action="logout" method="post">
<input type="submit" value="logout">
</form>
</body>
</html>