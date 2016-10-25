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
	<div id="bodyDiv" style="font-size: large;">
		<center>
			<h2>参与调查</h2>
			<c:if test="${empty requestScope.page.list}">暂时没有问卷
		</c:if>
			<c:if test="${!empty requestScope.page.list}">
				<table>
					<tr>
						<th>Logo</th>
						<th>调查名称</th>
						<th>参与调查</th>
					</tr>
					<c:forEach items="${requestScope.page.list }" var="survey">
						<tr>
							<td><img alt="logo" src="${survey.picPath }"></td>
							<td>${survey.name }</td>
							<td><a href="engage/survey/${survey.id }">参与调查</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</center>
	</div>
	<c:set var="targetUrl" value="engage/showAllAviabelSurvey"></c:set>
	<%@include file="/jsp_res/navigator.jsp"%>
	<%@include file="/jsp_res/bottom.jsp"%>
</body>
</html>