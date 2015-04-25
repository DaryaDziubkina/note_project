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
<h1>Notes</h1>

<c:url var="addUrl" value="/main/notes/add"></c:url>
<table style="border: 2px solid; width: 450px; text-align:center">
  <thead style="background:#abc">
  <tr>
    <th>Name</th>
    <th colspan="4"></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${notes}" var="notes">
    <c:url var="editUrl" value="/main/notes/edit?id=${notes.id}"/>
    <c:url var="deleteUrl" value="/main/notes/delete?id=${notes.id}"/>
    <c:url var="addUrl" value="/main/notes/add?id=${notes.id}"/>
    <tr>
      <td><c:out value="${notes.topic}"/></td>
      <td><a href="${editUrl}">Edit</a></td>
      <td><a href="${deleteUrl}">Delete</a></td>
      <td><a href="${addUrl}">Add</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<c:if test="${empty notes}">
  There are currently no note in the list. <a href="${addUrl}">Add</a> a notes.
</c:if>

</body>
</html>

