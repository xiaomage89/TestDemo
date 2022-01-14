<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	sessionattributes test <br>
		sessionattributes值：${sessionScope.name }<br>
		sessionattributes值：${sessionScope.name1 }<br>
		sessionattributes值：${abc.id }<br>
		sessionattributes值：${abc.name }<br>
		sessionattributes值：${abc.school.schoolname }<br>
</body>
</html>