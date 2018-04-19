<%-- 
    Document   : exercicio01
    Created on : 19/04/2018, 15:27:54
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercício 1</title>
    </head>
    <body>
        <%! int soma = 0; %>
        <% int sub = 100; %>
        
        <p>Soma: <%= soma+=10 %></p>    
        <p>Sub: <%= sub-=10 %></p>
    </body>
</html>
