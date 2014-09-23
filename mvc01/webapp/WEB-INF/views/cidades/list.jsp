<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="content-type"
              content="text/html; charset=utf-8">
        <title>List</title>
    </head>
    <body>
        <ul>
        <%@page import="java.util.List" %>
        <%@page import="models.CidadesModel" %>
        <%
            List <CidadesModel> cidades = (List <CidadesModel>)
                    request.getAttribute("cidades");
            for (CidadesModel cidade : cidades) {
         %>
              <li><%= cidade.getNome() %></li>
         <% } %>
        </ul>
    </body>
</html>
