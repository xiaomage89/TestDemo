<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<script type="text/javascript">
	    document.getElementById("btn").onclick = function () {
	        // 获取img元素
	        // 为了让浏览器发送请求到servlet, 所以一定要改变src
	        document.getElementsByTagName("img")[0].src =
	            "VerifyCodeServlet?time=" + new Date().getTime();
	    };
	</script>
	
</head>
<body>
	<form action="loginAdmin">
		用户：<input type="text" name="user"><font color="red">${requestScope.userMess}</font><br>
		密码：<input type="password" name="password"><br>
		验证码:<input type="text" name="image">
		 <img src="VerifyCodeServlet">
		 <input type="button" value="看不清? 换一张." id="btn"><font color="red">${requestScope.imageMess}</font>
		 <br>
		<input type="submit" name="submit" value="登录">
	</form>
</body>
</html>