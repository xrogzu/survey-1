<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fire" uri="http://www.fire.com/core"%>
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
			<h2>参与调查</h2>
			<h4>调查信息</h4>
			<form action="engage/doSurvey" method="post">
				<input type="hidden" name="currentIndex"
					value="${requestScope.currentIndex }">
				<table>
					<tr>
						<td><img src="${sessionScope.survey.picPath }"></td>
						<td>${sessionScope.survey.name }</td>
					</tr>
					<tr>
						<td colspan="2">当前包裹：${requestScope.bag.bagName }</td>
					</tr>
					<c:forEach items="${requestScope.bag.questionSet}" var="question">
						<tr>
							<td>${question.questionName }</td>
							<td><c:set
									value="_op_${sessionScope.survey.id }_${requestScope.bag.bagId }_${question.questionId }"
									var="_name"></c:set> <c:if test="${question.questionType==0 }">
									<c:forEach items="${question.showOptions }" var="op"
										varStatus="status">
										<input type="radio" name="${pageScope._name}"
											value="${status.index }" id="${pageScope._name}${status.index }"
											<fire:check option="${status.index }" map="${sessionScope.ansMap }" id="${pageScope._name }"/> />
											<label for="${pageScope._name}${status.index }">${op }</label>
											</c:forEach>
								</c:if> <c:if test="${question.questionType==1 }">
									<c:forEach items="${question.showOptions }" var="op"
										varStatus="status">
										<input type="checkbox" name="${pageScope._name}"
											value="${status.index }" id="${pageScope._name}${status.index }"
											<fire:check option="${status.index }" map="${sessionScope.ansMap }" id="${pageScope._name}"/> /> 
										<label for="${pageScope._name}${status.index }">${op }</label></c:forEach>
								</c:if> <c:if test="${question.questionType==2 }">
									<input type="text" name="${pageScope._name}" value="<fire:check option="" input="true"  map="${sessionScope.ansMap }" id="${pageScope._name }"/>"/>
								</c:if></td>
						</tr>
					</c:forEach>
					<tr align="center">
						<td colspan="2">
						<c:if test="${requestScope.currentIndex > 0}"> <input type="submit" value="上一部分" name="p_prev"></c:if> 
						<c:if test="${requestScope.currentIndex < sessionScope.totalIndex -1}"> <input type="submit" value="下一部分" name="p_next"> </c:if> 
						<input type="submit" value="放弃" name="p_abort"> 
					<c:if test="${requestScope.currentIndex == sessionScope.totalIndex -1}"> 	<input type="submit" value="完成" name="p_commit"></c:if>
					</td>
					</tr>
				</table>
			</form>
		</center>
	</div>
	<%@include file="/jsp_res/bottom.jsp"%>
</body>
</html>