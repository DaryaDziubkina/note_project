<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<h1>Create New Notification</h1>
<c:url var="saveUrl" value="/main/notifications/add"/>
<form:form modelAttribute="notificationAttribute" method="POST" action="${saveUrl}">
    <table>

        <tr>
            <td>Note</td>
            <td>
                <form:select path="note.id">
                    <form:options items="${noteList}" itemValue="id" itemLabel="topic"/>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>Date</td>
            <td>
                <fmt:formatDate value="${DateTime}" var="dateString" pattern="dd/MM/yyyy HH:mm:ss" />
                <form:input path="DateTime" value="${dateString}"/>
            </td>
        </tr>

    </table>

    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
