<%-- 
    Document   : exercicio03
    Created on : 19/04/2018, 15:48:13
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercício 03</title>
    </head>
    <body>
        <h1>Exercício 03</h1>
        <% int num = Integer.parseInt(request.getParameter("num")); %>
        <%!
            long fatorial(int x) {
                if (x == 0) return 1;
                else return x * fatorial(x-1);
            }
        %>
        <p>Fatorial de <%= num %> é: <%= fatorial(num) %></p>
    </body>
</html>
