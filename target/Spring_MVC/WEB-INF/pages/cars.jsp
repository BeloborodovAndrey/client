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
    <h1>${head}</h1>
</head>
<body>
<table border="2">
    <tr>
        <td>Номер</td>
        <td>Модель</td>
        <td>Марка</td>
    </tr>
    <c:forEach var="car" items="${cars}">
        <tr>
            <td>${car.number}</td>
            <td>${car.model}</td>
            <td>${car.brand}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
