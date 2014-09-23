<%@page import="java.util.ResourceBundle" %>

<% ResourceBundle rb = (ResourceBundle) request.getAttribute("resources"); %>
<form action="" method="get" accept-charset="utf-8">
    <label for="busca"><%= rb.getString("SEARCH_LABEL") %></label>
    <% if (request.getParameter("busca") != null) { %>
        <input type="text" name="busca" value="<%= request.getParameter("busca") %>" id="busca">
    <% } else { %>
        <input type="text" name="busca" value="" id="busca">
    <% } %>
    <input type="submit" value="<%= rb.getString("SUBMIT_VALUE") %>">
</form>
