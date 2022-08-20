<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bytedance
  Date: 2022/8/16
  Time: 下午6:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Room</title>
</head>
<body>
<%@include file="nav.jsp" %>


<div align="center">
    <h2>Edit Pokemon</h2>
    <form:form action="add" method="post" modelAttribute="room">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${room.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>name: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>desc: </td>
                <td><form:input path="description" /></td>
            </tr>
            <tr>
                <td>capacity: </td>
                <td><form:input path="capacity" /></td>
            </tr>
            <tr>
                <td>has projector: </td>
                <td><form:input path="has_projector" /></td>
            </tr>
            <tr>
                <td>has laptop: </td>
                <td><form:input path="has_laptop" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>


</body>
</html>
