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
			<form action="survey/doAddSurvey" enctype="multipart/form-data"
				method="post">
				<table>
					<c:if test="${requestScope.message!=null }">
						<tr>
							<td colspan="2" align="center">${requestScope.message }</td>
						</tr>
					</c:if>
					<tr>
						<td>问卷名称</td>
						<td ><input type="text" name="name" size="50"></td>
					</tr>
					<tr>
						<td>问卷logo</td>
						<td><input type="file" name="logoFile"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="确认"></td>
					</tr>
				</table>
			</form>
		</center>

	</div>
	<%@include file="/jsp_res/bottom.jsp"%>
</body>
</html>