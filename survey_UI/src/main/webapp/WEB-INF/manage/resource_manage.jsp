<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/jsp_res/base.jsp"%>
<link href="resources/style/nlogin2.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript">
	$(function() {
		$(".changeStatus").click(function() {
			var id = $(this).parents("tr").children("td").eq(0).text();
			var url = "manage/res/delete";
			var param = {
				"resId" : id,
				"date" : new Date()
			};
			var btn = $(this);
			$.post(url, param, function(data) {
				var state = data.resultStatus;
				if (state =="true") {
					btn.val("公共资源");
				} else if (state =="false") {
					btn.val("受保护资源");
				}
			}, "json")
		})
	})
</script>
</head>
<body>
	<%@include file="/jsp_res/mange_head.jsp"%>
	<center>
		<form action="manage/res_delete" method="post">
			<div style="padding: 50px; font-size: larger;">
				<h2>资源管理</h2>
				<table>
					<tr>
						<th>ID</th>
						<th>servletPath</th>
						<th>资源类别</th>
						<th>删除</th>
					</tr>
					<c:forEach items="${requestScope.ress }" var="res">
						<tr>
							<td>${res.resId }</td>
							<td>${res.servletPath }</td>
							<td><c:if test="${res.publicStatus==true }">
									<input type="button" class="changeStatus" value="公共资源">
								</c:if> <c:if test="${res.publicStatus==false }">
									<input type="button" class="changeStatus" value="受保护资源">
								</c:if></td>
							<td><input type="checkbox" name="resId" value="${res.resId}"></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
	</center>
	<%@include file="/jsp_res/manage_bottom.jsp"%>
</body>
</html>