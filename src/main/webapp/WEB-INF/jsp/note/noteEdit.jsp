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
<c:url var="saveUrl" value="/main/notes/edit?id=${noteAttribute.id}"/>
<form:form modelAttribute="noteAttribute" method="POST" action="${saveUrl}">
  <table>
    <tr>
      <td>Topic</td>
      <td><form:input path="topic"/></td>
    </tr>
    <tr>
      <td>Text</td>
      <td><form:input path="text"/></td>
    </tr>
    <td>Author</td>
    <td>
      <form:select path="author.id">
        <form:options items="${userList}" itemValue="id" itemLabel="name"/>
      </form:select>
  </table>

  <input type="submit" value="Save"/>
</form:form>

</body>
</html>

