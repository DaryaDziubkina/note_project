<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Users</h1>

<c:url var="addUrl" value="/main/users/add"></c:url>
<table style="border: 2px solid; width: 450px; text-align:center">
    <thead style="background:#abc">
    <tr>
        <th>First Name</th>
        <th colspan="4"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="users">
        <c:url var="editUrl" value="/main/users/edit?id=${users.id}"/>
        <c:url var="deleteUrl" value="/main/users/delete?id=${users.id}"/>
        <c:url var="addUrl" value="/main/users/add?id=${users.id}"/>
        <%--<tr>--%>
            <%--<td><c:out value="${users.name}"/></td>--%>
            <%--<td><a href="${editUrl}">Edit</a></td>--%>
            <%--<td><a href="${deleteUrl}">Delete</a></td>--%>
            <%--<td><a href="${addUrl}">Add</a></td>--%>
        <%--</tr>--%>
    </c:forEach>
    </tbody>
</table>

<c:if test="${empty users}">
    There are currently no users in the list. <a href="${addUrl}">Add</a> a user.
</c:if>

</body>
</html>
