<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="logoDiv">在线调查系统</div>
<div id="headDiv">
	<c:if test="${sessionScope.loginUser == null }">[<a
			href="user/login">登录</a>]  [<a href="user/regist">注册</a>]</c:if>
	<c:if test="${sessionScope.loginUser != null }">欢迎您，${sessionScope.loginUser.name } [<a
			href="user/logout">退出登录</a>] [<a
			href="survey/engage/showAllAviabelSurvey">参与调查</a>]</c:if>
	<c:if test="${sessionScope.loginUser.company }">
		<a href="survey/addSurvey">[新建问卷]</a>
		<a href="survey/completeSurvey">[未完成的问卷]</a>
	</c:if>
</div>