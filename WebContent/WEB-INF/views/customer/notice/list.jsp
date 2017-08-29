<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<!-- 헤더부분 -->
<!-- jsp action tag -->
<jsp:include page="../../inc/header.jsp"/>
  
  
<!--   비주얼부분 -->
<jsp:include page="../../customer/inc/visual.jsp"/>

   <div id="body" class="clearfix">
      <div class="content-container">

<!-- aside부분 -->
<jsp:include page="../../customer/inc/aside.jsp"/>
    
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

         <div>
            <h3>공지사항 검색 폼</h3>
            <form action="/customer/notice" method="get">
               <label>검색어</label> <input type="text" name="title" /> <input
                  type="submit" />
            </form>
         </div>
         <table class= "table table-list">
            <tr>
               <th>번호</th>
               
               <th>제목</th> 
               <th>작성자</th>
               <th>작성일</th>
               <th>조회수</th>
            </tr>
            <c:forEach var="n" items="${list}">
               <tr>
                  <td>${ n.id }</td>
                  <td><a href = "notice-detail?id=${n.id}">${ n.title } </a></td>
                  <td>${n.writerId}</td>
                  <td>${ n.regDate }</td>
                  <td>${ n.hit }</td>
               </tr>
            </c:forEach>
         </table>
         <a class="btn btn-default" href="notice-reg">글쓰기</a> 
         <a class="btn btn-img btn-cancel" href="">취소</a> 
         </main>
      </div>
   </div>
   
<!-- footer부분 -->
<jsp:include page="../../inc/footer.jsp"/>



</body>
</html>