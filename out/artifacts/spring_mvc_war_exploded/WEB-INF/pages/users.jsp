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

<form action = "/add" method="get">
    <input type="submit" value="Add user">
</form>

<table border="2">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>LastName</td>
        <td>Email</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>
                <form action = "/update" method="get">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="hidden" name="name" value="${user.name}">
                    <input type="hidden" name="password" value="${user.lastName}">
                    <input type="hidden" name="email" value="${user.email}">
                    <input type="submit" value="Update" style="float:left">
                </form>
                <form action="/delete" method="get">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Delete" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
