<jsp:include page="../common/header.jsp" />

<form action="${url}" method="POST" accept-charset="utf-8">
    <input type="text" name="login" value=""/>
    <input type="password" name="passwd" value=""/>
    <input type="submit" value="Login &rarr;"/>
</form>

<jsp:include page="../common/footer.jsp" />
