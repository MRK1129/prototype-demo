<%--
  Created by IntelliJ IDEA.
  User: MRK
  Date: 2016/3/28
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prototype-Demo授权</title>
</head>
<body>
        <div style="width:20%;height: 20%;;margin: 0px auto;">
            尊敬的【${account.screenName}】，你的ID是【${account.accountId}】，你的邮箱是【${account.email}】
            <a href="http://cn-bj-yatsen.anicel.cn:8080/service-bus/oauth/authorize?client_id=1058595963104900977&redirect_uri=http://localhost:8080/sunny/redirect&response_type=code&scope=read">点我授权</a>
        </div>
</body>
</html>
