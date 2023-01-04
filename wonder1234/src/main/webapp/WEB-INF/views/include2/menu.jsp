  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<body class="home-template">
<div class="site-wrapper">
	<nav class="main-nav overlay clearfix">
	<!--  메인로고 이미지 (나중에바꿔야댐)-->
	<a class="blog-logo" href="/">
	<img src="${contextPath}/resources/img/wonder.png" alt="WONDER"/></a>
	
	
	<ul id="menu">
		<li class="nav-home nav-current" role="presentation"><a href="/">홈</a></li>
		
		<li class="nav-about-us" role="presentation"><a href="${contextPath}/auction/auctionlist">경매</a></li>
		<li class="nav-author-page" role="presentation"><a href="${contextPath}/notice/notice">고객센터</a></li>
		<span class="socialheader">		
		<c:if test ="${user== null }">
        <li class="active"><a href="${contextPath}/member/login"><i class="fa fa-link"></i> <span>로그인</span></a></li>
       
        </c:if>
        <c:if test="${user!= null }" >
        <h2 class="page-description">${user.mem_name}님 환영합니다.</h2>
        <li class="active"><a href="${contextPath}/logout" method="POST"><i class="fa fa-link"></i> <span>로그아웃</span></a></li>
        <a href="${contextPath}/mypage/mypage" method="POST">마이페이지</a>
        </c:if>
		</span>
	</ul>
	</nav>
