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
			<c:if test="${sessionScope.loginUser == null }">
				<div id="ctl00_divLogin" class="W-header_reg">
					<ul>
						<li><a href="user/regist"><span style="cursor: pointer;"
								class="W-header_btn"> 注册</span></a></li>
						<li id="ctl00_liLogin"><a href="user/login">登录</a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${sessionScope.loginUser != null }">
				<div class="W-Menu">
					<ul>
						<li id="ctl00_liIndex" class="acitve"><a href="index.jsp">欢迎您，${sessionScope.loginUser.name }</a></li>
						<li id="ctl00_liQCenter"><a title="退出登录" href="user/logout">退出</a></li>
						<li id="ctl00_liPrice"><a
							href="survey/engage/showAllAviabelSurvey" title="参与调查">参与调查</a></li>
						<c:if test="${sessionScope.loginUser.company }">
							<li id="ctl00_liUseCase"><a href="survey/addSurvey">
									新建问卷</a></li>
							<li id="ctl00_liCustomer" style="margin-right: 0;"><a
								href="survey/completeSurvey" title="未完成的问卷"> 完善</a></li>
						</c:if>
					</ul>
				</div>
			</c:if>
			<div class="divclear"></div>
		</div>
	</div>
</div>
