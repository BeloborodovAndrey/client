<%--
  Created by IntelliJ IDEA.
  User: belob
  Date: 13.04.2020
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <h2>USERS</h2>
</head>
<body>

<form action = "/admin/add" method="get">
    <input type="submit" value="Add user">
</form>

<form action="/user" method="get">
    <input type="submit" value="User data" style="float:right">
</form>

<table border="2">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Password</td>
        <td>Role</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td><c:forEach var="role" items="${user.roles}">
                <i>${role.name}</i><br>
                </c:forEach>
            </td>
            <td>
                <form action = "/admin/update" method="get">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="hidden" name="username" value="${user.username}">
                    <input type="hidden" name="password" value="${user.password}">
                    <input type="submit" value="Update" style="float:left">
                </form>
                <form action="/admin/delete" method="get">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="hidden" name="name" value="${user.username}">
                    <input type="hidden" name="password" value="${user.password}">
                    <input type="hidden" name="roles" value="${user.roles}">
                    <input type="submit" value="Delete" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="/logout" method="get">
    <input type="submit" value="logout" style="float:outside">
</form>

</body>
</html>
