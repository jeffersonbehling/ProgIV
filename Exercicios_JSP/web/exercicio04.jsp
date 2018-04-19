<%-- 
    Document   : exercicio04
    Created on : 19/04/2018, 15:55:08
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 04</title>
    </head>
    <body>
       <h1>Exercício 04</h1>
        <% int num = Integer.parseInt(request.getParameter("num")); %>
        <%!
            long fatorial(int x) {
                if (x == 0) return 1;
                else return x * fatorial(x-1);
            }
        %>
        <% for (int i = 0; i <= num; i++) { %>
            <p>Fatorial de <%= i %> é: <%= fatorial(i) %></p>
        <% } %>
    </body>
</html>
