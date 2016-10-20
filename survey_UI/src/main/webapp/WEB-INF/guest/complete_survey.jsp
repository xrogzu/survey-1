<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title><%@include file="/jsp_res/base.jsp"%>
</head>
<body>
	<%@include file="/jsp_res/head.jsp"%>
	<div style="font-size: large;">
		<center>
		<p style="color: red;">${requestScope.message }</p>
			<c:if test="${empty requestScope.page.list }">
				<h4>尚未创建问卷</h4>
			</c:if>
			<c:if test="${!empty requestScope.page.list }">
				<table>
					<tr>
						<th>ID</th>
						<th>name</th>
						<th>Logo</th>
						<th colspan="4">操纵</th>
					</tr>
					<c:forEach items="${requestScope.page.list}" var="survey">
						<tr>
							<td>${survey.id }</td>
							<td>${survey.name }</td>
							<td><img alt="Logo" height="80px" src="${survey.picPath }"></td>
							<td><a href="survey/design/${survey.id}">设计</a></td>
							<td><a href="survey/edit/${survey.id}/${requestScope.page.pageNo}">更新</a></td>
							<td><a href="survey/delete/${survey.id}/${requestScope.page.pageNo}">删除</a></td>
							<td><a
								href="survey/doDelete/${survey.id}/${requestScope.page.pageNo}" style="background: black;color: yellow">彻底删除</a></td>
						</tr>
					</c:forEach>
				</table>
				<c:set var="targetUrl" value="survey/completeSurvey" scope="page"></c:set>
				<%@include file="/jsp_res/navigator.jsp"%>
			</c:if>
		</center>
	</div>
	<%@include file="/jsp_res/bottom.jsp"%>
</body>
</html>