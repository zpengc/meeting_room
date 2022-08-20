<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bytedance
  Date: 2022/8/16
  Time: 下午5:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Reservation</title>
</head>
<body>
<%@include file="nav.jsp" %>

<div align="center">
    <h2>New Room</h2>
    <form:form action="add" method="post" modelAttribute="reservation">
        <table border="0" cellpadding="5">
            <tr>
                <td>room name: </td>
                <td><form:input path="room_id" /></td>
            </tr>
            <tr>
                <td>room desc: </td>
                <td><form:input path="username" /></td>
            </tr>
            <tr>
                <td>start time: </td>
                <td><form:input type="datetime-local" path="stime" /></td>
            </tr>
            <tr>
                <td>end time: </td>
                <td><form:input type="datetime-local" path="etime" /></td>
            </tr>
            <tr>
                <td colspan="5"><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
