<%@ page import="web.model.User" %><%--
  Created by IntelliJ IDEA.
  User: belob
  Date: 15.04.2020
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% User user = (User) session.getAttribute("user"); %>
<html>
<head>
    <h2> Current user </h2>
</head>
<body>
    <table>
        <tr>
            <td>Name</td>
            <td>Role</td>
        </tr>
        <tr>
            <td><%= user.getUsername() %></td>
            <td><%= user.getRolesList()%></td>
        </tr>
    </table>

    <form action="/logout" method="get">
        <input type="submit" value="logout" style="float:outside">
    </form>
</body>
</html>
