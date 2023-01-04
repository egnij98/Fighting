<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@include file="../include2/head.jsp" %>
<%@include file="../include2/menu.jsp" %>
<link rel="stylesheet" href="${contextPath}/resources/css1/test.css">

	<main id="content" class="content" role="main">

	
	
  
 <form class="user" action="pwsfind" method="POST">
	<h2>비밀번호 찾기</h2>
	<div class="findbox">
		<div class="textForm">
		<input type="text" id="mem_id" name ="mem_id" placeholder="아이디를 입력해주세요.">
		</div>
	    <%@ include file= "../include2/hint1.jsp" %>
	    
	    <div class="textForm">
		<input type="text" id="mem_hint2" name="mem_hint2" placeholder="답변을 입력해주세요.">
		</div>
		<input type="submit" id="btn2" value="조회"> <input type="reset" id="btn2" value="다시입력">
		
	
		</div>
	</form>
	
	<a class="scroll-down icon-arrow-left" href="#content" data-offset="-45"><span class="hidden">Scroll Down</span></a>
	
	</main>
	<footer class="site-footer clearfix">
	<%@include file = "../include2/footer.jsp" %>
	</footer>

<%@include file = "../include2/script.jsp" %>
