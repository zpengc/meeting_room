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
    <title>Edit Reservation</title>
</head>
<body>
<%@include file="nav.jsp" %>


<div align="center">
    <h2>Edit Pokemon</h2>
    <form:form action="add" method="post" modelAttribute="reservation">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${room.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>room_id: </td>
                <td><form:input path="room_id" /></td>
            </tr>
            <tr>
                <td>username: </td>
                <td><form:input path="username" /></td>
            </tr>
            <tr>
                <td>start time: </td>
                <td><form:input path="stime" /></td>
            </tr>
            <tr>
                <td>end time: </td>
                <td><form:input path="etime" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>


</body>
</html>
