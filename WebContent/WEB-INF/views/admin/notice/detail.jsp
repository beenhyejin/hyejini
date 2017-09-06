<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../../css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- header 부분 -->
	<jsp:include page="../../inc/header.jsp" />
	<div id="body" class="clearfix">
		<div class="content-container">
			<!-- aside부분 -->
			<jsp:include page="../inc/aside.jsp" />
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
			<table class="table">
				<tr>
					<th>제목</th>
					<td class="text-left" colspan="3">${detail.title }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td colspan="3">${detail.regDate}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${detail.writerId }</td>
					<th>조회수</th>
					<td>${detail.hit}</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td colspan="4">${detail.content}</td>
			</table>
			<div>
				<a href="list" class="btn btn-default">목록</a> <a
					href="edit?id=${detail.id}" class="btn btn-default">수정</a> <a
					href="del" class="btn btn-default">삭제</a>
			</div>
			</main>
		</div>
	</div>
	<footer id="footer">
		<div class="content-container"></div>
	</footer>
</body>
</html>