<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/jsp_res/base.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#_options").hide();
		$(":radio").click(function() {
			var i = this.value;
			if (i == 2) {
				$("#_options").hide();
			}
			if (i != 2) {
				$("#_options").show()
			}
		})
	})
</script>
</head>
<body>
	<%@include file="/jsp_res/head.jsp"%>
	<div id="bodyDiv">
		<center>
			创建问题
			<form action="question/doAdd/${requestScope.surveyId}" method="post">
				<input type="hidden" name="bag.bagId" value="${requestScope.bagId}">
				<table>
					<tr>
						<td>问题名称</td>
						<td><input type="text" name="questionName"></td>
					</tr>
					<tr>
						<td>题型</td>
						<td><input type="radio" name="questionType" value="0"
							id="_type0"><label for="_type0">单选题</label> <input
							type="radio" name="questionType" value="1" id="_type1"><label
							for="_type1">多选题</label> <input type="radio" name="questionType"
							value="2" id="_type2" checked="checked"><label
							for="_type2">简答题</label></td>
					</tr>
					<tr>
						<td>选项</td>
						<td><textarea rows="8" cols="20" name="options" id="_options"></textarea></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="保存"></td>
					</tr>
				</table>
			</form>
		</center>
	</div>
	<%@include file="/jsp_res/bottom.jsp"%>
</body>
</html>