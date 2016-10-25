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
	<div style="padding:50px ">
		<center>
		<h1>欢迎来到后台</h1>
			<form action="admin/doLogin" method="post">
				<table>
					<c:if test="${requestScope.message!=null }">
						<tr>
							<td colspan="2" align="center">${requestScope.message }</td>
						</tr>
					</c:if>
					<tr>
						<td>管理员用户名</td>
						<td><input type="text" name="adminName"></td>
					</tr>
					<tr>
						<td>管理员密码</td>
						<td><input type="password" name="adminPwd"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="登录"></td>
					</tr>
				</table>
			</form>
		</center>
	</div>

	<%@include file="/jsp_res/manage_bottom.jsp"%>
</body>
</html>