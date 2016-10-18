<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/jsp_res/base.jsp"%>
<style type="text/css">
.NSign-TT {
	background: #0094da;
	overflow: hidden;
	line-height: 38px;
	font-size: 14px;
	color: #fff;
	text-align: center;
}
</style>
</head>
<body>
	<%@include file="/jsp_res/head.jsp"%>
	<div id="ctl00_ContentPlaceHolder1_Register1_divVT" class="NSign-TT"
		style="margin: 0px auto 10px; width: 910px;">
		<p>
			<span>注册新用户，立即开始使用阿里在线调查</span>
		</p>
	</div>

	<div style="padding-bottom: 40px;" id="RE-Content">
		<center>
			<form action="user/doRegist" method="post">
				<table>
					<c:if test="${requestScope.message!=null }">
						<tr>
							<td colspan="2" align="center">${requestScope.message }</td>
						</tr>
					</c:if>
					<tr>
						<td>用户名</td>
						<td><input type="text" name="name"></td>
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
						<td align="center"><input type="radio" name="company"
							value="true" id="com1"><label for="com1"> 企业用户</label></td>
						<td align="center"><input type=radio name="company"
							value="false" checked="checked" id="com2"><label
							for="com2">个人用户 </label></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="创建用户"></td>
					</tr>
				</table>
			</form>
		</center>
	</div>
	<%@include file="/jsp_res/bottom.jsp"%>



</body>
</html>