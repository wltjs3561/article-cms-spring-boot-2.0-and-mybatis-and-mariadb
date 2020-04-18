<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%@ page import="com.sbs.starter.dto.Article"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 사이트 - 게시물 리스트</title>
</head>
<body>
	<h1>게시물 리스트</h1>

	<!-- el의 장점은 request.getAttrivut("article")할 필요가 없다 -->
	<c:forEach items="${list}" var="article"> 
		<section>
			번호 : ${article.id}, 제목 : ${article.title}
		</section>
		<hr>
	</c:forEach>
</body>
</html>