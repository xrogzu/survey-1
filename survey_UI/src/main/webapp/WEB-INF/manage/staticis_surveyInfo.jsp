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
</head>
<body>
	<%@include file="/jsp_res/mange_head.jsp"%>
	<div align="center">
		<h2>所有已经完成的的调查</h2>
		<c:if test="${empty requestScope.page }">
			<h2>暂时没有数据</h2>
		</c:if>
		<c:if test="${!empty requestScope.page }">
			<table style="font-size: larger; text-align: center;">
				<tr>
					<th>ID</th>
					<th>调查名称</th>
					<th colspan="2">操作</th>
				</tr>
				<c:forEach items="${requestScope.page.list }" var="survey">
					<tr>
						<td>${survey.id }</td>
						<td>${survey.name }</td>
						<td><a href="manage/staticis/outline/${survey.id }">查看调查大纲</a></td>
						<td><a href="manage/staticis/excel/${survey.id }">导出Excel文件</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<c:set var="targetUrl" value="manage/staticis/Survey"></c:set>
	<%@include file="/jsp_res/navigator.jsp"%>
	<%@include file="/jsp_res/manage_bottom.jsp"%>
</body>
</html>