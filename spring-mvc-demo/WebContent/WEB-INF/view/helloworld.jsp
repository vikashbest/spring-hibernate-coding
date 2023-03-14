<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello World</title>
</head>
<body>

<h1>Hello World of Spring!</h1>
<br><br>
Student Name: ${param.studentName}

<br><br>
The message: ${message}

<br><br>
<img src="${pageContext.request.contextPath}/resources/images/SpringMVC.jpg">

</body>
</html>