<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style.css" type="text/css" rel="stylesheet" />
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
			자세한 페이지

			<form method="get" >
				<!-- 현재페이지와 같은 url이면 작성하지 않는다 -->
				<table class="table">
					<%--             <tr>
	               <th>번호</th>
	               <td>${detail.id}</td>
	            </tr> --%>
					<tr>
						<th>제목</th>
						<td colspan="3"><input name="title" value="${detail.title}"></td>
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
						<td colspan="4"><textarea name="content">${detail.content }</textarea>
						</td>
				</table>


				<div>
					<input type="hidden" name="id" value=${notice.id }>
					<!-- 어떠한 값을 업데이트 할지 -->
					<input type="submit" class="btn btn-default" value="저장" />
					<!-- input에 있는 값, key가 있는 값만 전달 -->
					<a href="notice-edit?id=${notice.id }" class="btn btn-default">취소</a>
				</div>
			</form>
			</main>
		</div>
	</div>
	
<!-- footer부분 -->
<jsp:include page="../../inc/footer.jsp"/>

</body>
</html>