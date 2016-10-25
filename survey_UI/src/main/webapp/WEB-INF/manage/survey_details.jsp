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
	<div style="font-size: larger; text-align: center;">
		<center>
			<h2>显示调查大纲【${requestScope.survey.name }】</h2>
			<table>
				<tr>
					<th>包裹列表</th>
					<th colspan="2">包裹详细</th>
				</tr>
				<c:forEach items="${requestScope.survey.bagSet }" var="bag">
					<tr>
						<td>${bag.bagName }</td>
						<td colspan="2">问题统计信息</td>
					</tr>
					<c:forEach items="${bag.questionSet }" var="question">
						<tr>
							<td></td>
							<td>${question.questionName }</td>
							<td><c:if test="${question.questionType!=2 }">
									<a href="manage/staticis/chart/${question.questionId}">查看统计图表</a>
								</c:if> <c:if test="${question.questionType==2 }">
									<a href="manage/staticis/input/${question.questionId}">显示简答题答案列表</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</c:forEach>
			</table>
		</center>
	</div>
	<%@include file="/jsp_res/manage_bottom.jsp"%>
</body>
</html>