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
	<div id="bodyDiv">
		<c:if test="${empty  requestScope.bags}">请添加包裹</c:if>
		<c:if test="${!empty  requestScope.bags}">
			<center>
				调整包裹顺序
				<form action="survey/doAdjust/${requestScope.surveyId}"
					method="post">
					<table>
						<tr>
							<th>ID</th>
							<th>包裹名称</th>
							<th>序号</th>
						</tr>
						<c:forEach items="${requestScope.bags}" var="bag">
							<tr>
								<td>${bag.bagId }</td>
								<td>${bag.bagName }</td>
								<td><input type="hidden" name="orderId"
									value="${bag.bagId }"><input type="text" size="20"
									value="${bag.bagOrder }" name="order"></td>
							</tr>

						</c:forEach>
						<tr>
							<td colspan="3"><input type="submit" value="确认"></td>
						</tr>
					</table>
				</form>
			</center>
		</c:if>
	</div>
	<%@include file="/jsp_res/bottom.jsp"%>
</body>
</html>