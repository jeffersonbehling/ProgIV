<%-- 
    Document   : exercicio06
    Created on : 19/04/2018, 16:17:35
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercício 06</title>
    </head>
    <body>
        <h1>Exercício 06</h1>
        <% int min = Integer.parseInt(request.getParameter("min")); %>
        <% int max = Integer.parseInt(request.getParameter("max")); %>
        <% int div = Integer.parseInt(request.getParameter("div")); %>
        
        <% for (int i = min; i <= max; i++) {
            if (i%div == 0) { 
                i = max;
            } else { %>
                <p><%= i %></p>
            <% } %>
            
        <% } %>
    </body>
</html>
