<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="W-header">
	<div class="c-header">
		<div class="sojump_2016logo">
			<div class="W-sojump_image">
				<h1>问卷调查 • 考试 • 投票</h1>
			</div>
		</div>
		<div class="W-header_r">
			<c:if test="${sessionScope.loginAdmin == null }">
				<div id="ctl00_divLogin" class="W-header_reg">
					<ul>
						<li><a href="admin/login"><span style="cursor: pointer;"
								class="W-header_btn"> 登录</span></a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${sessionScope.loginAdmin != null }">
				<div class="W-Menu">
					<ul>
						<li id="ctl00_liIndex" class="acitve">欢迎您，${sessionScope.loginAdmin.adminName }</li>
						<li id="ctl00_liQCenter"><a title="退出登录" href="admin/logout">退出</a></li>
						<li id="ctl00_liPrice"><a href="manage/staticis/Survey">统计调查</a></li>
						<li id="ctl00_liUseCase"><a href="index.jsp"> 首页</a></li>
						<li id="ctl00_liUseCase"><a href="manage/res/details"> 资源管理</a></li>
					</ul>
				</div>
			</c:if>
			<div class="divclear"></div>
		</div>
	</div>
</div>
