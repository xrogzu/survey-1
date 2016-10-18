<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${requestScope.page.hasPrev }">
	<a href="${pageScope.targetUrl }?pageStr=1">[首页]</a> &nbsp;&nbsp;<a
		href="${pageScope.targetUrl }?pageStr=${requestScope.page.prev }">[上一页]</a>
</c:if>
<input type="text" size="2" id="chpage" />
共${requestScope.page.totalPageNo }页 当前第${requestScope.page.pageNo }页
<c:if test="${requestScope.page.hasNext }">
	<a href="${pageScope.targetUrl }?pageStr=${requestScope.page.next }">[下一页]</a> &nbsp;&nbsp;<a
		href="${pageScope.targetUrl }?pageStr=${requestScope.page.totalPageNo }">[末页]</a>
</c:if>