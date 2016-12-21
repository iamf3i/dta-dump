<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		email:<br /> <input type="text" name="email" value=""> <br />
		password:<br /> <input type="text" name="password" value="">
		<br> <br> <input type="submit" value="Valider">
	</form>
	<c:forEach var="error" items="${errors}">
		<c:if test="${error.key == 'login'}">
			<div>${error.value}</div>
		</c:if>
	</c:forEach>
</body>
</html>