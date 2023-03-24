<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title>Springtuts Company Home Page</title>
</head>

<body>

	<h2>Springtuts Company Home Page - Yoohoo</h2>
	<hr>
	
	<p>
	Welcome to the Springtuts company homepage.
	</p>
	
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
		<input type="submit" value="Logout" />
		
	</form:form>
	

</body>

</html>