<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<form:form action="survey/doEdit" method="post"
				modelAttribute="survey" enctype="multipart/form-data">
				<form:hidden path="id" />
				<form:hidden path="picPath" />
				<table>
					<tr>
						<td>标题</td>
						<td><form:input path="name" size="28" /></td>
					</tr>
					<tr>
						<td>Logo</td>
						<td><img src="${requestScope.survey.picPath }"></td>
					</tr>
					<tr>
						<td>上传Logo</td>
						<td><input type="file" name="logoFile"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="确认"></td>
					</tr>
				</table>

			</form:form>
		</center>
	</div>
	<%@include file="/jsp_res/bottom.jsp"%>
</body>
</html>