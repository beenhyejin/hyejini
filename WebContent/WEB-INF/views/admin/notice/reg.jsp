<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 글등록</title>
<link href="../../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../../css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- header 부분 -->
	<jsp:include page="../../inc/header.jsp" />
	<!-- visual 부분 -->
	<jsp:include page="../../customer/inc/visual.jsp" />
	<div id="body" class="clearfix">
		<div class="content-container">		
	<!-- aside부분 -->
	<jsp:include page="../../customer/inc/aside.jsp" />
			<main id="main">
			<h2>공지사항</h2>
			<div>
				<h3>경로</h3>
				<ol>
					<li>home</li>
					<li>고객센터</li>
					<li>공지사항</li>
				</ol>
			</div>
				<form method="post" >
				<table class="table">
					<tr>
						<th>제목</th>
						<td colspan="3"><input name="title" value="${detail.title}"></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td colspan="4"><textarea name="content"></textarea></td>
				</table>
				<div>
					<input type="submit" class="btn btn-default" value="등록" />
					<a href="notice-list" class="btn btn-default">취소</a>
				</div>
			</form>
			</main>
		</div>
	</div>
	<footer id="footer">
		<div class="content-container"></div>
	</footer>

</body>
</html>