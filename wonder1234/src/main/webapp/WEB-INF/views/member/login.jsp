<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@include file="../include2/head.jsp" %>
<%@include file="../include2/menu.jsp" %>
<link rel="stylesheet" href="${contextPath}/resources/css1/test.css">
<main id="content" class="content" role="main">

	
    <div class="loginbox">
        <form id="idForm" action="loginProc" method="post">
        <div class="textForm">
            <input type="text" name="mem_id" placeholder="아이디" class="id">
            </div>
            <div class="textForm">
            <input type="password" name="mem_password" class="id" placeholder="비밀번호" class="in">
            </div>
            <input type="submit" id="btn2" value="로그인"><br>
        </form>
        <a href="addMember"> 회원가입</a> <br>
        <a href="idfindView">아이디를 잊어버리셨나요?</a> <br>
        <a href="pwsFindView">비밀번호를 잊어버리셨나요?</a>
    </div>


	
</main>
<%@include file="../include2/footer.jsp" %>