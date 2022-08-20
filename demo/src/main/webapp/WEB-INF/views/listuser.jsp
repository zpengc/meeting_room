<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bytedance
  Date: 2022/8/16
  Time: 上午9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List User</title>
</head>
<body>
<%@include file="nav.jsp" %>

<div align="center">
    <h2>List User</h2>
    <form method="get" action="search">
        <label for="username">Enter username:</label>
        <input id="username" type="text" name="username" /> &nbsp;
        <input type="submit" value="Search" />
    </form>

    <h3><a href="${pageContext.request.contextPath}/userInfo/add">Register User</a></h3>

    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>username</th>
        </tr>
        <c:forEach items="${data}" var="userInfo">
            <tr>
                <td>${userInfo.id}</td>
                <td>${userInfo.username}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/userInfo/edit?id=${userInfo.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/userInfo/delete?id=${userInfo.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
