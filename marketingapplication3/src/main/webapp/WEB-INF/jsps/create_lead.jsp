<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@import file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Create Lead</h2>
	<form action="saveLead" method="post">
	<pre>
	First Name<input type="text" name="firstName"/>
	Last Name<input type="text" name="lastName"/>
	Email<input type="text" name="email"/>
	Mobile<input type="text" name="mobile"/>
	<input type="submit" value="save"/>
	</pre>
	</form>
	${msg}
</body>
</html>