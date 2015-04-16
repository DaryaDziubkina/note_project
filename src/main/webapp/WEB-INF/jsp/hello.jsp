<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple jsp page</title>
</head>
<body>
    Hello <%= request.getAttribute("name")%>
<form action="test.form" method="get">
    <%--<input type="text" name="name">--%>
    <%--<input type="submit">--%>
</form>

</body>
</html>


