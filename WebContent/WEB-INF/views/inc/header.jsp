<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <c:set var="path"    value="${pageContext.request.contextPath }" />
 <header id="header">
      <div class="content-container">
      <h1 id="logo">
         <a href="">            
            <img src="${pageContext.request.contextPath }/images/logo.png" alt="뉴렉처사이트" />
         </a>
      </h1>
      <section>
         <h2 class="hidden">머릿말</h2>   
         <nav id="main-menu"  class="hr-list main-menu">
            <h1 class="hidden"> 메인메뉴</h1>
            <ul class="">
               <li><a href="">학습가이드</a></li>
               <li><a href="">뉴렉과정</a></li>
               <li><a href="">강좌선택</a></li>
            </ul>
         </nav>
         
         <section id="search-form">
            <h1 class="hidden">강좌검색 폼</h1>
            <form>
               <label>과정검색</label>
               <input type="text" />
               <input class= "btn btn-search"  type="submit" value="검색" />
            </form>
         </section>
         
         <nav id="member-menu" class="hr-list  pad member-menu">   
            <h1 class="hidden">회원메뉴</h1>
            <ul>
               <li><a href="">HOME</a></li>
               <li><a href="">로그인</a></li>
               <li><a href="${path}/member/agree">회원가입</a></li>
            </ul>   
         </nav>
            
         <nav id="customer-menu" class="hr-list">
            <h1 class="hidden">고객메뉴</h1>
            <ul>
               <li><a href=""><img src="${pageContext.request.contextPath }/images/txt-mypage.png"  alt="마이페이지" /></a></li>
               <li><a href=""><img src="${pageContext.request.contextPath }/images/txt-customer.png"  alt="고객센터" /></a></li>
            </ul>
         </nav>
      </section>
      </div>
   </header>