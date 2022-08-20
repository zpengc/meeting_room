<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bytedance
  Date: 2022/8/16
  Time: 下午4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Reservation</title>
</head>
<body>
<%@include file="nav.jsp" %>

<div align="center">
    <h2>List Room</h2>
    <form method="get" action="search">
        <label for="room_id">Enter room_id:</label>
        <input id="room_id" type="number" name="room_id" /> &nbsp;
        <label for="username">Enter username:</label>
        <input id="username" type="text" name="username" /> &nbsp;
        <input type="submit" value="Search" />
    </form>

    <h3><a href="${pageContext.request.contextPath}/reservation/add">Add Reservation</a></h3>

    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>room_id</th>
            <th>username</th>
            <th>start time</th>
            <th>end time</th>
        </tr>
        <c:forEach items="${data}" var="reservation">
            <tr>
                <td>${reservation}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/reservation/edit?id=${reservation.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/reservation/delete?id=${reservation.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
