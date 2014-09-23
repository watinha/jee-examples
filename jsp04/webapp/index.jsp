<jsp:include page="header.jsp">
    <jsp:param name="title" value="Busque aqui!"/>
</jsp:include>

<h1>Ol&aacute; mundo pelo JSP</h1>
<form action="./busca.jsp" method="get" accept-charset="utf-8">
    <label for="busca">Busca: </label>
    <input type="text" name="busca" value="" id="busca">
    <input type="submit" name="enviar" value="enviar">
</form>

<%@include file="footer.jsp" %>
