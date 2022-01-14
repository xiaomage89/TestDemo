<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="selGoodsServlet" method="post" >
			<table>
				<tr>
					<td width="250px">
						商品名称：<input type="text" name="goodname" value="${goodname}">
					</td>
					<td width="200px">
						商品类型：
						<select name="goodstypeId" id="">
							<option value="all">全部</option>
							<c:forEach var="gtp" items="${goodsType}">
								<option value="${gtp.id}">
									<c:if test="${goodstypeId !='all' && goodstypeId=gtp.id}">
										selected
									</c:if>${gtp.typename}
								</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<input type="hidden" name="act" value="condiction">
						<input type="submit" value="条件查询">
					</td>
				</tr>
			</table>
		</form>
		<table border="1" bgcolor="PaleGreen">
			<tr>
				<th width="250px">商品ID</th>
				<th width="250px">商品名称</th>
				<th width="250px">商品类型</th>
				<th width="250px">查看详情</th>
			</tr>
			<c:forEach var="g" items="${requestScope.allGoods}">
			<tr>
				<td>${g.id}</td>
				<td>${g.goodname}</td>
				<td>${g.typename}</td>
				<td><a href="admin_detail?gno=${g.id}&act=detail" target="_blank">详情</a></td>
			</tr>
			</c:forEach>

			<tr>
				<td colspan="4" align="right">
					&nbsp;&nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
					第${pageCur}页&nbsp;&nbsp;
					<c:url var="url_pre" value="selGoodsServlet?act=${act}&& gname1=${goodname}&&gid=${goodstypeId}" >
						<c:param name = "pageCur" value="${pageCur - 1}"/>
					</c:url>
					<c:url var="url_next" value="selGoodsServlet?act=${act}&& gname1=${goodname}&&gid=${goodstypeId}" >
						<c:param name = "pageCur" value="${pageCur + 1}"/>
					</c:url>

					<c:if test = "${pageCur != 1}">
						<a href="${url_pre}">上一页</a>&nbsp;&nbsp;
					</c:if>

					<c:if test = "${pageCur != totalPage && totalPage!= 0 }">
						<a href="${url_next}">下一页</a>&nbsp;&nbsp;
					</c:if>
				</td>
			</tr>
		</table>
</body>
</html>