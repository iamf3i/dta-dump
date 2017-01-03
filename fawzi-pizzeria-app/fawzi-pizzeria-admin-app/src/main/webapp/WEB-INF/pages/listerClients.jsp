<%--
  Created by IntelliJ IDEA.
  User: ETY5
  Date: 03/01/2017
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link
            href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css"
            rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="application/javascript">
        function processPost() {


            var jsonData = {};

            jsonData["prenom"] = $( "input[name='firstname']" ).val();
            jsonData["nom"] = $( "input[name='lastname']" ).val();

            $.ajax({
                url : 'http://localhost:8080/api/clients',
                type : 'post',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(jsonData),
                success : function(code_html, statut){ // success est toujours en place, bien sûr !
                    location.reload();
                },

                error : function(resultat, statut, erreur){

                }

            });
        }

        $(function () {
            $.get("http://localhost:8080/api/clients", function (data, status) {
                $.each(data, function (index) {
                    $("#here").append('<div class="col-md-4">' + data[index].id + '</div>')
                        .append('<div class="col-md-4">' + data[index].prenom + '</div>')
                        .append('<div class="col-md-4">' + data[index].nom + '</div>');
                });
            });

            $('form').on('submit', function(e){
                // validation code here
                e.preventDefault();
            });

            $("#sendForm").click(processPost);
        });
    </script>
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
                <form action="/pizzas/list" class="navbar-form navbar-right"
                      method="post">
                    <button type="submit" class="btn btn-primary">Pizzas</button>
                </form>
            </div>
        </div>
        <div class="row" id="here">
            <div class="col-md-4">Id</div>
            <div class="col-md-4">Prenom</div>
            <div class="col-md-4">Nom</div>
        </div>
        <div class="row">
            <form class="col-md-4">
                <p>Add New Client</p>
                First name:<br>
                <input type="text" name="firstname" value="Mickey"><br>
                Last name:<br>
                <input type="text" name="lastname" value="Mouse"><br><br>
                <input id="sendForm" type="submit" value="Submit">
            </form>
        </div>
    </div>
</div>
</body>
</html>
