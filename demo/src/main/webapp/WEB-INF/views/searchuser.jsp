<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bytedance
  Date: 2022/8/16
  Time: 下午5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search User</title>
</head>
<body>
<%@include file="nav.jsp" %>

<div align="center">
    <h2>Search Result</h2>
    <table border="1" cellpadding="3">
        <tr>
            <th>ID</th>
            <th>username</th>
        </tr>
        <c:forEach items="${data}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
