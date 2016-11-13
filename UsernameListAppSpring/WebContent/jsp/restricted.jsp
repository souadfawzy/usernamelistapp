
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>restricted</title>
</head>
<body>

	<form:form id="restrictedForm" method="post" action="restricted"
		modelAttribute="loginBean">

		<form:label path="username">Restricted Username</form:label>
		<form:input id="username" name="username" path="" />
		<br>
		<br>
		<font color="red">${message}</font>
		<br>
		<input type="submit" value="Add to restricted" />
	</form:form>
</body>
</html>