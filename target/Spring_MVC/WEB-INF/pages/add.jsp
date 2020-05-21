<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h2>Add user</h2>
</head>
<body>
<form action="/admin/add" method="post">
    name:<input required type="text" name="name">
    password:<input required type="text" name="password">
    Roles:<select name="role" size="1">
    <option selected="selected" value="ROLE_ADMIN">Admin</option>
    <option value="ROLE_USER">User</option>
    <option value="ALL">All</option>
</select>
    <input type="submit" value="OK">
</form>

<form action="/logout" method="get">
    <input type="submit" value="logout" style="float:outside">
</form>
</body>
</html>