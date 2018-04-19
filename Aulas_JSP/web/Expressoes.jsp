<%-- 
    Document   : Expressoes
    Created on : 19/04/2018, 14:42:12
    Author     : Jefferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expressões JSP</title>
    </head>
    <body>
        <h1>Expressões JSP</h1>
       
         <%! double celsius = 30.7; %>
        
        <ul>
            <li>Data/Hora: <%= new java.util.Date() %></li>
            <li>Hostname: <%= request.getRemoteHost() %></li>
            <li>ID Sessão: <%= session.getId() %></li>
            <li>Temp. Celsius: <%= celsius %> </li>
            <li>Temp. Fahrenheit: <%= celsius*9/5 + 32 %></li>
        </ul>
    </body>
</html>
