<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>IPLT20</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of IPL T20 FAMILY</h2>	
	<table>
		<tr>
			<td>ID</td><td>USER NAME</td><td>ROLE ID</td><td>TEAM ID</td><td></td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
			<td>${user.user_id}</td>
			<td>${user.user_name}</td>
			<td>${user.role_id}</td>
			<td>${user.team_id}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<h2><a href="<c:url value='/search' />">Search</a></h2>
</body>
</html>