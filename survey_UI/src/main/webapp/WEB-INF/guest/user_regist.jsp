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
		<form action="user/doRegist" method="post">
			<table>
				<c:if test="${requestScope.message != null }">
					<tr>
						<td colspan="2">${requestScope.message }</td>
					</tr>
				</c:if>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" name="rePassword"></td>
				</tr>
				<tr>
					<td colspan="2"><input id="isCompany" type="radio"
						name="company" value="true"><label for="isCompany">企业用户</label>
						<input id="notCompany" type="radio" name="company"
						checked="checked" value="false"> <label for="notCompany">个人用户</label></td>
				</tr>
				<tr>
					<td rowspan="2"><input type="submit" value="注册"></td>
				</tr>
			</table>

		</form>
	</div>

	<%@include file="/jsp_res/bottom.jsp"%>



</body>
</html>