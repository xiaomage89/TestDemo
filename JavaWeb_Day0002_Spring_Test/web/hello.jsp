<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>spring MVC 映射:<br>
	<a href="hello"> spring MVC 映射：value</a><br>
	<a href="method">Spring MVC 映射：method</a><br>
	<a href="params?name=majj&age=12">Spring MVC 映射： params</a><br>
	<a href="headers">Spring mvn 映射：headers</a><br>
	<a href="pathvar/ma1">Spring mvn 映射： pathVariable</a><br>
	
	<br>REST风格:<br>
	<a href="methodGet/12"> GET请求： 获取信息</a><br>
	
	
	<form method = "POST" action="methodPost">
		<input type = "submit" value = "Post请求，新建信息">
	</form><br>
	
	<form method = "POST" action="methodDelete/ma">
		<input type = "hidden" name="_method"  value = "DELETE">
		<input type = "submit" value = "Post请求 delete，删除信息">
	</form><br>
	
	<form action="methodUpdate/ma" method = "POST">
		<input type = "hidden" name="_method" value= "PUT">
		<input type = "submit" value = "Post请求 put，删除信息">
	</form><br>
		
	
	参数传递：
		<form action="postparams" method = "POST">
			id:<input type = "text" name = "id" ><br>
			name:<input type="text" name="name"><br>
			<input type="submit",value="submit">
		</form> <br>
		
		<form action="postClass" method = "POST">
			id:<input type = "text" name = "id" ><br>
			name:<input type="text" name="name"><br>
			schoolname:<input type="text" name="school.schoolname"><br>
			classname:<input type="text" name="school.classname"><br>
			curriculum:<input type="text" name="school.curriculum"><br>
			<input type="submit",value="submit">
		</form> <br>
		
		<br><br>
		请求报文的信息：
		<a href = "getheader"> 获取报文表头信息</a><br>
		获取Cookie的值
		<a href = "getCookie"> 获取Cookie的值信息</a><br>
		Servlet API
		<a href = "getServletAPI"> 获取Servlet API的值信息</a><br>
		
		<br><br>
		Spring mvn 返回数据模型
		<a href = "getModelandView"> 获取ModelandView的值信息</a><br>
		<a href = "getMap"> 获取map的值信息</a><br>
		<a href = "getModel"> 获取Modelw的值信息</a><br>
		<a href = "getModelMap"> 获取ModelMap的值信息</a><br>
		
		<br>
		<br>
		
		
</body>
</html>