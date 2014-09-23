<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp" />

<form action="${url}" method="POST" accept-charset="utf-8">
    <input type="text" name="something" value=""/>
    <input type="submit" value="Continue &rarr;"/>
</form>

<ul>
    <c:forEach items="${list}" var="usuario">
        <li>${usuario.nome}</li>
    </c:forEach>
</ul>

<a href="${deslogarUrl}">deslogar</a>

<jsp:include page="footer.jsp" />
