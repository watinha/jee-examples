<form action="" method="get" accept-charset="utf-8">
    <label for="busca">Busca: </label>
    <% if (request.getParameter("busca") != null) { %>
        <input type="text" name="busca" value="<%= request.getParameter("busca") %>" id="busca">
    <% } else { %>
        <input type="text" name="busca" value="" id="busca">
    <% } %>
    <input type="submit" value="buscar...">
</form>
