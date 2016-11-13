<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Username List Problem</title>
</head>
<body>

	<form:form id="loginForm" method="post" action="login"
		modelAttribute="loginBean">

		<form:label path="username">Enter your user name</form:label>
		<form:input id="username" name="username" path="" />
		<br>
		<br>
		<font color="red">${message}</font>
		<br>
		<br>
		<form:label path="sugesstedNames">suggested usernames </form:label>
		<br>
		<br>
		<form:textarea path="sugesstedNames" rows="10" cols="30" />

		<c:forEach var="item" items="${sugesstedNames}">
			<p>${item}</p>
		</c:forEach>
		<br>
		<br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>