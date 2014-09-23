<%@page import="java.io.BufferedReader" %>
<%@page import="java.io.FileReader" %>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Resultado da busca" />
</jsp:include>

<h1>Resultados da busca</h1>
<a href="./index.jsp">Voltar</a>
<ul>
    <%
        BufferedReader reader = new BufferedReader(
                                 new FileReader(
                                  request.getServletContext().getRealPath("frutas.txt")));
        String line = reader.readLine();
        while (line != null) {
            if (line.toUpperCase().startsWith(request.getParameter("busca").toUpperCase()))
                out.println("<li>" + line + "</li>");
            line = reader.readLine();
        }
     %>

</ul>

<%@ include file="footer.jsp" %>
