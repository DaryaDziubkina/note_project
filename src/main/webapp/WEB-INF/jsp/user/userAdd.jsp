<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
        <%@include file='resources/bootstrap.css' %>
        <%@include file='resources/style.css' %>
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h3>Create New Users</h3>
<c:url var="saveUrl" value="/main/users/add"/>
<form:form modelAttribute="userAttribute" method="POST" action="${saveUrl}">
    <%--<table>--%>
    <%--<tr>--%>
    <%--<td>Name</td>--%>
    <%--<td><form:input path="name"/></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
    <%--<td>Email</td>--%>
    <%--<td><form:input path="email"/></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
    <%--<td>Password</td>--%>
    <%--<td><form:input path="password"/></td>--%>
    <%--</tr>--%>
    <%--</table>--%>

<form class="form-horizontal">
    <div class="form-group">
        <label>Name</label>
        <div class="col-sm-10">
            <form:input path="name" class="form-control" placeholder="Jane"/>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <form:input type="email" path="email" class="form-control" placeholder="Email"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <form:input type="password" path="password" class="form-control" id="inputPassword3"
                            placeholder="Password"/>
            </div>
        </div>
            <%--<div class="form-group">--%>
            <%--<div class="col-sm-offset-2 col-sm-10">--%>
            <%--<div class="checkbox">--%>
            <%--<label>--%>
            <%--<input type="checkbox"> Remember me--%>
            <%--</label>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" value="Save" class="btn btn-default">Sign in</button>
            </div>
        </div>
    </div>
        <%--<input type="submit" value="Save"/>--%>
    </form:form>
</body>
</html>