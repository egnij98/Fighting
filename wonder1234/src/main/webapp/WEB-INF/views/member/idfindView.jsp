<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@include file="../include2/head.jsp" %>
<%@include file="../include2/menu.jsp" %>
<link rel="stylesheet" href="${contextPath}/resources/css1/test.css">
	<main id="content" class="content" role="main">
	
	
	<script
    src="https://code.jquery.com/jquery-3.4.1.js"
    integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
    crossorigin="anonymous"></script>
    
<script type="text/javascript">

	var msg = "${msg}";
		if (msg != "") {
			alert(msg);
		}
		 
  		 function fn_submit(){
  			 
		if($("#mem_name") == ""){
			alert("이름을입력해주세요");        
        }
  		 }
	</script>	
	<form class="user" action="idfind" method="POST">
	<h2>아이디 찾기</h2>
<div class="findbox">
	<div class="textForm">
		<input type="text" id="mem_name" name ="mem_name" placeholder="이름을 입력해주세요."> 
		</div>
		<div class="textForm">
		 <input type="tel" id="mem_phonenum" name="mem_phonenum" placeholder="전화번호를 입력해주세요."> 
		</div>
		<input type="submit" value="조회" id="btn2" onclick="fn_submit();"> <input type="reset" id="btn2" value="다시입력">
		</div>
		
			
	</form>
	
	<a class="scroll-down icon-arrow-left" href="#content" data-offset="-45"><span class="hidden">Scroll Down</span></a>
	
	</main>
<%@include file="../include2/footer.jsp" %>