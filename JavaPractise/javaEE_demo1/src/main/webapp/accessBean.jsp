<%--
  Created by IntelliJ IDEA.
  User: ltt
  Date: 20-1-6
  Time: 下午5:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.test.userLogin"%>
<jsp:useBean id="user" class="com.test.userLogin" scope="session"></jsp:useBean>

<html>
<head>
    <title>使用存取运算符访问JavaBean的属性</title>
</head>
<body>
用户名:${user.userName}
密码:${user.password}
电子邮箱:${user.email}
</body>
</html>
