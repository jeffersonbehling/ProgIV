<%-- 
    Document   : OlaMundoJSP
    Created on : 19/04/2018, 14:16:37
    Author     : Jefferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>JSP Simples</h2>
        <% 
            String user = request.getParameter("user"); 
            
            if (user == null) {
                user = "Mundo";
            }
        %>
        <p>Olá <%= user %>. Agora você está utilizando JSP</p>
    </body>
</html>
