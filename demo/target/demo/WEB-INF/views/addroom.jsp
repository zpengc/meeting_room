<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bytedance
  Date: 2022/8/16
  Time: 下午3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Room</title>
</head>
<body>
<%@include file="nav.jsp" %>


<div align="center">
    <h2>New Room</h2>
    <form:form action="add" method="post" modelAttribute="room">
        <table border="0" cellpadding="5">
            <tr>
                <td>room name: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>room desc: </td>
                <td><form:input path="description" /></td>
            </tr>
            <tr>
                <td>room capacity: </td>
                <td><form:input path="capacity" /></td>
            </tr>
            <tr>
                <td>has projector: </td>
                <td><form:input path="has_projector" /></td>
            </tr>
            <tr>
                <td>has_laptop: </td>
                <td><form:input path="has_laptop" /></td>
            </tr>
            <tr>
                <td colspan="5"><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
