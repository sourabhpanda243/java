<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");%>
<form action="registration">
Enter user name : <input type="text" name="uname" ><br>
Enter school name :<input type="text" name="school" ><br>
Enter reg_id : <input type="text" name="reg_no" ><br>
Enter password :<input type="password" name="pass" ><br>
<input type="submit" value="register">
</form>
</body>
</html>