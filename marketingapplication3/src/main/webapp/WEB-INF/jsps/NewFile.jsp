<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><table>
<tr>
<tr>
	<th>Name</th>
	<th>City</th>
	<th>Email</th>
	<th>Mobile</th>
	</tr>

<c:forEach var="leads" items="${lead}">
<tr>
<td>${leads.firstName}</td>
<td>${leads.lastName}</td>
<td>${leads.email}</td>
<td>${leads.mobile}</td>
</tr>

</c:forEach>
</table>
</body>
</html>