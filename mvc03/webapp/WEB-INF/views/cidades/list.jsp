<%@page import="java.util.List" %>
<%@page import="models.CidadesModel" %>

<jsp:include page="/WEB-INF/views/commons/header.jsp">
    <jsp:param name="title" value="<%= request.getAttribute("title") %>" />
    <jsp:param name="busca" value="<%= request.getAttribute("busca") %>" />
</jsp:include>

<%@include file="/WEB-INF/views/cidades/_search.jsp" %>

<ul>
<%
    List <CidadesModel> cidades = (List <CidadesModel>) request.getAttribute("cidades");
    for (CidadesModel cidade : cidades) {
 %>
         <li><%= cidade.getNome() %></li>
 <% } %>
</ul>

<%@include file="/WEB-INF/views/commons/footer.jsp" %>
