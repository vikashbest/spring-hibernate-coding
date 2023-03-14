<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
	First Name: <form:input path="firstName" />
	<br><br>
	
	Last Name: <form:input path="lastName" />
	<br><br>
	
	Country: 
	<form:select path="country">
		<form:options items="${student.countryOptions}" />
	</form:select>
	<br><br>
	
	Favourite Language: 
<!--  	<form:radiobutton path="favouriteLanguage" value="Java"/> Java 
	<form:radiobutton path="favouriteLanguage" value="C++"/> C++ 
	<form:radiobutton path="favouriteLanguage" value="PHP"/> PHP 
	<form:radiobutton path="favouriteLanguage" value="Ruby"/> Ruby -->
	
	<form:radiobuttons path="favouriteLanguage" items="${student.favouriteLanguageOptions}"/>
	
	<br><br>
	Operating Systems: 
 	<form:checkbox path="operatingSystems" value="Linux"/> Linux
	<form:checkbox path="operatingSystems" value="Mac OS"/> Mac OS
	<form:checkbox path="operatingSystems" value="MS Windows"/> MS Windows   
	
	
	<br><br>
	
	<input type="submit" value="Submit" />
	
	</form:form>

</body>

</html>