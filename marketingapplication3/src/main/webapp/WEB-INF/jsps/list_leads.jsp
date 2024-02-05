<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>leads</title>
</head>
<body>
<h2>List All Leads..</h2>
<table>
	<tr>
	<th>Name</th>
	<th>City</th>
	<th>Email</th>
	<th>Mobile</th>
	<th>Action</th>
	</tr>
<c:forEach var="leads" items="${lead}">
	<tr>
	<td>${leads.firstName}</td>
	<td>${leads.lastName}</td>
	<td>${leads.email}</td>
	<td>${leads.mobile}</td>
	<td><a href="delete?id=${leads.id}">delete</a></td>
	<td><a href="update?id=${leads.id}">update</a></td>
	<td>
</tr>

</c:forEach>
</table>
</body>
</html>