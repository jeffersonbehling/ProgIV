<%-- 
    Document   : exercicio02
    Created on : 19/04/2018, 15:38:54
    Author     : Jefferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 02</title>
    </head>
    <body>
        <% double num = Double.parseDouble(request.getParameter("num")); %>
        <% double porcent = Double.parseDouble(request.getParameter("porcent")); %>
        <h1>Exercicio 02</h1>
        <p>Resultado = <%= (num * porcent)/100 %></p>
    </body>
</html>
