<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Segundo JSP</title>
    </head>
    <body>
        <h1>Ol&aacute; mundo pelo JSP</h1>
        <form action="./index.jsp" method="get" accept-charset="utf-8">
            <label for="busca">Busca: </label><input type="text" name="busca" value="" id="busca">
            <input type="submit" name="enviar" value="enviar">
        </form>
        <div style="background-color: yellow;
                    padding: 10px;
                    font-weight:bolder;
                    box-shadow: 3px 3px 3px #999">
        <%
            String parametro = request.getParameter("busca");
            out.println(parametro);
        %>
        </div>
    </body>
</html>
