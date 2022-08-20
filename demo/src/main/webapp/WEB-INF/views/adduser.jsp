<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bytedance
  Date: 2022/8/16
  Time: 下午1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<%@include file="nav.jsp" %>

<div align="center">
    <h2>New User</h2>
    <form:form action="add" method="post" modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr>
                <td>Username: </td>
                <td><form:input path="username" /></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><form:password path="password" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
