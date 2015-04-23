<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>Edit User</h1>
<c:url var="saveUrl" value="/main/users/edit?id=${userAttribute.id}"/>
<form:form modelAttribute="userAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td>Name</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><form:input path="password"/></td>
        </tr>

            <%--<tr>--%>
            <%--<td><form:label path="name">First Name:</form:label></td>--%>
            <%--<td><form:input path=" " disabled="false"/></td>--%>
            <%--</tr>--%>

            <%--<tr>--%>
            <%--<td><form:label path="nam">Last Name</form:label></td>--%>
            <%--&lt;%&ndash;<td><form:input path="lastName1"/></td>&ndash;%&gt;--%>
            <%--</tr>--%>

    </table>

    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
