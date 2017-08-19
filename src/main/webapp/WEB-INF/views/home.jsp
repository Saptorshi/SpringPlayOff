<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<!-- <form:input type="hidden" path="id" id="id"/> -->
	
	<h2>User Data and Report List:</h2>	
	
	
	<c:if test="${!empty uw}">
		<table>
		<tr>
			<td>ID</td>
			<td>USER NAME</td>
			<td>ROLE ID</td>
			<td>ROLE NAME</td>
			<td>TEAM ID</td>
			<td>TEAM NAME</td>
		</tr>
		<c:forEach items="${uw}" var="uw">
			<tr>
			<td>${uw.user_id}</td>
			<td>${uw.user_name}</td>
			<td>${uw.role_id}</td>
			<td>${uw.role_name}</td>
			<td>${uw.team_id}</td>
			<td>${uw.role_name}</td>
			</tr>
		</c:forEach>
	</table>
	
		<a href="<c:url value='/r1' />">Report 1: List of teams (from Team)</a> <br />
		<a href="<c:url value='/r2' />">Report 2: List of roles (from Role)</a> <br />
		<a href="<c:url value='/r3' />">Report 3: List of users (from User)</a> <br />
		<a href="<c:url value='/r4' />">Report 4: Data of each user (from Data)</a> <br />
		<a href="<c:url value='/r5' />">Report 5: List of reports (from Report)</a> <br />
		<a href="<c:url value='/r6' />">Report 6: List of users with corresponding report access details</a> <br />
		<a href="<c:url value='/r7' />">Report 7: List of users of a given team (from User)</a>
		
	</c:if>
</body>
</html>