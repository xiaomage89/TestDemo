<%--
  Created by IntelliJ IDEA.
  User: majj
  Date: 2021/12/9
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户登录按钮</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-2.1.0.min.js" ></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js" ></script>
    <script>
        function refreshCode() {
            let vcode = document.getElementById("vcode");
            vcode.src="${pageContext.request.contextPath}/checkCodeServlet?time=" + new Date().getTime();
        }
    </script>
</head>
<body>

<div class="container" style="width: 400px;">
    <h2 style="text-align: center;">用户登录</h2>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div >
            <label for="username">用户名：</label>
            <input  type="text" id="username" name="username" class="form-control" placeholder="请输入用户名" required autofocus>
        </div>

        <div style="margin-top: 5px;" >
            <label for="password">密码：</label>
            <input  type="password" id="password" name="password" class="form-control" placeholder="请输入密码" required>
        </div>
        <div class="form-inline" style="margin-top: 5px">
            <label for="verifycode">验证码：</label>
            <input type="text" id="verifycode" name="verifycode" class="form-control" placeholder="请输入验证码" style="width: 150px">
            <a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/checkCodeServlet" id="vcode" title="看不清请点击刷新"></a>
        </div>

        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录">
        </div>
    </form>

    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span></button>
        <strong>${login_msg}</strong>
    </div>

</div>

</body>
</html>

