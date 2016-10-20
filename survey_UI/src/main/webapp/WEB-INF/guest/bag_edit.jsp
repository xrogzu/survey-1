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
		<center>
			修改包裹
			<form action="bag/doUpdate" method="post">
				<input type="hidden" name="survey.id" value="${surveyId }">
				<input type="hidden" name="bagId" value="${bag.bagId}">
				<table>
					<tr>
						<td>包裹名称</td>
						<td><input type="text" name="bagName"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="提交"></td>
					</tr>
				</table>
			</form>
		</center>
	</div>
	<%@include file="/jsp_res/bottom.jsp"%>
</body>
</html>