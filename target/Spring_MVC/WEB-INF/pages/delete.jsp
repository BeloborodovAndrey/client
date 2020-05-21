<%--
  Created by IntelliJ IDEA.
  User: belob
  Date: 14.04.2020
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h2>Delete</h2>
</head>
<body>
<h1>Delete user with id = ${id}?</h1>

<form action="/admin/delete" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="submit" value="Delete">
</form>

<form action="/logout" method="get">
    <input type="submit" value="logout" style="float:outside">
</form>

</body>
</html>
