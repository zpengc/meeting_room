<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bytedance
  Date: 2022/8/16
  Time: 下午3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Room</title>
</head>
<body>
<%@include file="nav.jsp" %>

<div align="center">
    <h2>List Room</h2>
    <form method="get" action="search">
        <label for="name">Enter name:</label>
        <input id="name" type="text" name="name" /> &nbsp;
        <label for="capacity">Enter capacity:</label>
        <input id="capacity" type="number" name="capacity" /> &nbsp;
        <label for="desc">Enter description:</label>
        <input id="desc" type="text" name="desc" /> &nbsp;
        <label for="has_projector">Enter has_projector:</label>
        <input id="has_projector" type="number" name="has_projector" /> &nbsp;
        <label for="has_laptop">Enter has_laptop:</label>
        <input id="has_laptop" type="number" name="has_laptop" /> &nbsp;
        <input type="submit" value="Search" />
    </form>

    <h3><a href="${pageContext.request.contextPath}/room/add">Add Room</a></h3>

    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>name</th>
            <th>desc</th>
            <th>capacity</th>
            <th>has projector</th>
            <th>has laptop</th>
        </tr>
        <c:forEach items="${data}" var="room">
            <tr>
                <td>${room.id}</td>
                <td>${room.name}</td>
                <td>${room.description}</td>
                <td>${room.capacity}</td>
                <td>${room.has_projector}</td>
                <td>${room.has_laptop}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/room/edit?id=${room.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/room/delete?id=${room.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
