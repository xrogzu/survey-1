<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/jsp_res/base.jsp"%>
</head>
<body>
	<%@include file="/jsp_res/head.jsp"%>
	<div id="bodyDiv" style="font-size: larger;">
		<center>
			设计调查<br>调查基本信息
			<table>
				<tr>
					<td colspan="2"><img src="${survey.picPath }"></td>
					<td>${survey.name }</td>
					<td><a href="bag/addBag/${survey.id}">创建包裹</a></td>
					<td colspan="2"><a href="bag/toAdjustUI/${survey.id}">调整包裹顺序</a></td>
				</tr>
				<tr>
					<td colspan="6">包裹基本信息</td>
				</tr>
				<tr>
					<td colspan="1">包裹名称</td>
					<td colspan="5">包裹基本操作</td>
				</tr>
				<c:if test="${!empty survey.bagSet}">
					<c:forEach items="${survey.bagSet}" var="bag">
						<tr>
							<td>${bag.bagName }</td>
							<td><a href="bag/delete/${bag.bagId }/${survey.id}">删除包裹</a></td>
							<td><a href="bag/update/${bag.bagId }/${survey.id}">更新包裹</a></td>
							<td><a href="question/create/${bag.bagId }/${survey.id}">创建问题</a></td>
							<td><a href="bag/doDelete/${bag.bagId }/${survey.id}"
								style="background: black; color: yellow;">深度删除</a></td>
							<td><a href="bag/move/${bag.bagId }/${survey.id}">移动/复制包裹</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</center>

	</div>
	<%@include file="/jsp_res/bottom.jsp"%>
</body>
</html>