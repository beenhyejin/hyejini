<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

	   
   <div id="visual">
      <div class="content-container">
      </div>
   </div>
   
   <div id="body" class="clearfix">
      <div class="content-container">      
      
      <aside id="aside">
         
         <!-- <h1>고객센터</h1>
         
         <nav>
            <h1>고객센터 메뉴</h1>
            <ul>
               <li><a href="">공지사항</a></li>
               <li><a href="">1:1고객문의</li>
               <li><a href="">학습안내</li>
            </ul>
         </nav>
      
         <nav>
            <h1>추천사이트</h1>
            <ul>
               <li>앤서이즈</li>
               <li>W3C</li>
               <li>마이크로소프트</li>
            </ul>
         </nav>
         
         <nav>
            <h1>구글광고</h1>
         </nav> -->
        </aside>
        
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
        
        <form method="get"  action = "/customer/notice"><!-- 현재페이지와 같은 url이면 작성하지 않는다 -->
	        <table class="table">
	<%--             <tr>
	               <th>번호</th>
	               <td>${detail.id}</td>
	            </tr> --%>
	            <tr>
	                <th >제목</th>
	                <td colspan = "3"> <input name = "title"value = "${detail.title}"></td>
	            </tr>
	             <tr>
					<th>첨부파일</th>
					<td colspan = "3"></td>
	            </tr>
	             <tr>
	             	<td colspan="4">
	             	<textarea name = "content" ></textarea>
	             	</td>
	
	         </table>
	         
	         
	         <div>
	         	<input type = "submit" class="btn btn-default" value = "등록"/><!-- input에 있는 값, key가 있는 값만 전달 -->
	         	<a href="notice-edit?id=${notice.id }" class = "btn btn-default">취소</a>
	         </div>
         </form>
        
        
       
      </main>   
      </div>
   </div>
   
   <footer id="footer">
      <div class="content-container">
      </div>
   </footer>
   
</body>
</html>