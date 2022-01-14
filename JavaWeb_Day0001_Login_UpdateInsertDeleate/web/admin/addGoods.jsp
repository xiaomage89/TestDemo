<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="nc.com.dto.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="adminAddGoods?act=add" method="post" enctype="multipart/form-data">
		<table border="1">
			<h1>添加商品</h1>
			<tr>
				<td>商品名称<font color="red">*</font></td>
				<td><input type="text" name="goodname"></td>
			</tr>
			<tr>
				<td>商品原价<font color="red">*</font></td>
				<td><input type="text" name="goodoldprice"></td>
			</tr>
			<tr>
				<td>商品折扣价<font color="red">*</font></td>
				<td><input type="text" name="goodnewprice"></td>
			</tr>
			<tr>
				<td>商品数量<font color="red">*</font></td>
				<td><input type="text" name="goodstore"></td>
			</tr>
			<tr>
				<td>商品图片<font color="red">*</font></td>
				<td><input type="file" name="goodimg"></td>
			</tr>
			<tr>
				<td>商品类型<font color="red">*</font></td>
				<td>
					<select name="typeid" id="">
						<c:forEach var="gtp" items="${sessionScope.goodstypeId}">
							<option value="${gtp.id}">${gtp.typename}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>