<%--
  Created by IntelliJ IDEA.
  User: MRK
  Date: 2016/3/28
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prototype-Demo登陆页面</title>
</head>
<body>
<div style="width:20%;height: 20%;;margin: 0px auto;background-color: aquamarine">
    <form action='${pageContext.request.contextPath}/login' method="post">
        请输入用户名：<input name="username"><br />
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
