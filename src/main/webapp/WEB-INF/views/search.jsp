<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>IPLT20</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Search User</h2>
 
	<form:form method="POST" modelAttribute="employee">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">UserName: </label> </td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
		</table>
	</form:form>
	<br/>
	<br/>
	<h4><a href="<c:url value='/' />">FAMILY IS HERE</a></h4>
</body>
</html>