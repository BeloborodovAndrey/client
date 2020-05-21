<%--
  Created by IntelliJ IDEA.
  User: belob
  Date: 14.04.2020
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h2>Update user</h2>
</head>
<body>

<form action="/admin/update" method="post">
    <input type="hidden" name = "id" value="${user.id}">
    name:<input type="text" name="username" value="${user.username}">
    password:<input type="text" name="password">
    Roles:<select name="roles" size="1">
    <option selected="selected" value="ROLE_ADMIN">Admin</option>
    <option value="ROLE_USER">User</option>
    <option value="ALL">All</option>
    <input type="submit" value="Update">
</form>

<form action="/logout" method="get">
    <input type="submit" value="logout" style="float:outside">
</form>

</body>
</html>

