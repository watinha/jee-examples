<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Exemplo MVC01 - Cidade</title>
    </head>
    <body>
        <h1>Lista de Cidades</h1>
        <form action="cidade" method="POST">
            <label for="busca">Nova cidade:</label>
            <input type="text" name="nova" id="nova"/>
            <input type="submit" value="inserir..." />
        </form>

        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <ul>
        <c:forEach items="${lista}" var="cidade">
            <li>${cidade.nome}</li>
        </c:forEach>
        </ul>
    </body>
</html>
