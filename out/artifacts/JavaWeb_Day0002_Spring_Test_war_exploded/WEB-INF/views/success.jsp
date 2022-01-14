<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	恭喜您成功了
	<br> postClass值：${people.name }
	<br> postClass值：${people.school.schoolname }
	<br>
	子表值schoolname：<br />
	<c:forEach items="${people.schoolList}" var="node">
		<c:out value="${node.schoolname}"></c:out>
		<br />
	</c:forEach>
	
	<br> getModelandView的值：${requestScope.name}
	<br> getMap值：${requestScope.name }
	<br> getMap值：${requestScope.name1 }
	<br> getModel值：${requestScope.name }
	<br> getModel值：${requestScope.name1 }
	<br> getModelMap值：${requestScope.name }
	<br> getModelMap值：${requestScope.name1 }
	<br>


	<br>
	<table>
		<tr>
			<th>id
			<th>name
		<tr>
			<td>${user.id }
			<td>${user.name}
	</table>
	<br />
	<p>书籍列表</p>
	<c:forEach items="${bookList}" var="node">
		<c:out value="${node}"></c:out>
		<br />
	</c:forEach>
	<br />

	<c:forEach items="${map}" var="node">
		姓名 : <c:out value="${node.key}"></c:out>
		地址 : <c:out value="${node.value}"></c:out>
		<br>
	</c:forEach>

	<table>
		<tr>
			<th>姓名
			<th>地址
		<tr>
			<c:forEach items="${map}" var="node">
				<td><c:out value="${node.key}"></c:out>
				<td><c:out value="${node.value}"></c:out>
				<tr>
			</c:forEach>
	</table>

	<a href="sessionattributes"> test sessionattributes</a>

	<br>
	<br>
	<br> test modelattributes:
	<form action="modelattributes" method="POST">
		id:<input type="text" name="id"><br> name:<input
			type="text" name="name"><br> <input type="submit"
			,value="submit">
	</form>
	<br>


</body>
</html>