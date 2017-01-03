<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet" type="text/css">
</head>
<body>

	<!-- Navigation -->
	<div class="container">
		<div class="jumbotron">
			<div class="row">
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
                    <form action="/logout" class="navbar-form navbar-right"
                          method="post">
                        <button type="submit" class="btn btn-primary">Logout</button>
                    </form>
                    <form action="/clients" class="navbar-form navbar-right"
                          method="post">
                        <button type="submit" class="btn btn-primary">Clients</button>
                    </form>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">Id</div>
				<div class="col-md-2">Code</div>
				<div class="col-md-2">Nom</div>
				<div class="col-md-2">Prix</div>
				<div class="col-md-4">Categorie</div>

				<c:forEach var="pizzaList" items="${pizzaList}">
					<div class="col-md-2">${pizzaList.id}</div>
					<div class="col-md-2">${pizzaList.code}</div>
					<div class="col-md-2">${pizzaList.nom}</div>
					<div class="col-md-2">${pizzaList.prix}</div>
					<div class="col-md-4">${pizzaList.cat}</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>