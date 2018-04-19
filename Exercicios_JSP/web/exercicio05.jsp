<%-- 
    Document   : exercicio05
    Created on : 19/04/2018, 15:59:57
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 05</title>
    </head>
    <body>
        <h1>Exercicio 05</h1>
        <% double salario = Double.parseDouble(request.getParameter("s")); %>
        <% double porcentagem = Double.parseDouble(request.getParameter("p")); %>
        
        <%! 
            double aumento(double s, double p) {
                return (s*p)/100;
            }
        %>
        <% if (aumento(salario, porcentagem) < 400) { %>
            <h2>Você recebeu um aumento de R$ <%= aumento(salario, porcentagem) %>! Teu emprego é um lixo, sai logo daí!</h2>
        <% } else if (aumento(salario, porcentagem) > 400 && aumento(salario, porcentagem) < 2999.99) { %>
            <h2>Você recebeu um aumento de R$ <%= aumento(salario, porcentagem) %>! Até que teu salário não é tão ruim!</h2>
        <% } else { %>
            <h2>Seu novo salário é R$ <%= aumento(salario, porcentagem) %></h2>
        <% } %>
    </body>
</html>
