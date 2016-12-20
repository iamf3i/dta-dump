<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.dta.pizzeria.model.Pizza"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<%= request.getContextPath() %>/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet" type="text/css">
</head>
<body>

	<div class="jumbotron">
		<div class="container">

        <div class="row">
            <div class="col-md-2">Id</div>
            <div class="col-md-2">Code</div>
			<div class="col-md-2">Nom</div>
			<div class="col-md-2">Prix</div>
			<div class="col-md-4">Categorie</div>
			<%
				// retrieve your list from the request, with casting 
				ArrayList<Pizza> list = (ArrayList<Pizza>) request.getAttribute("pizzaList");

				// print the information about every category of the list
				for (Pizza pizza : list) {
			%>
            <div class="col-md-2"><%=pizza.getId()%></div>
            <div class="col-md-2"><%=pizza.getCode()%></div>
			<div class="col-md-2"><%=pizza.getNom()%></div>
			<div class="col-md-2"><%=pizza.getCode()%></div>
			<div class="col-md-4"><%=pizza.getCode()%></div>
			<%
				}
			%>
			</div>
		</div>
	</div>
</body>
</html>