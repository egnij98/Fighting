<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@include file="../include2/head.jsp" %>
<%@include file="../include2/menu.jsp" %>
<main id="content" class="content" role="main">

<title>캐쉬출금</title>

<!-- jQuery 3 -->
<script src="${contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="${contextPath}/resources/dist/js/adminlte.min.js"></script>

<script>
$(document).ready(function(){
	console.log("반응이있다");
	
	drawlist();
function drawlist(){
	   var url ="${pageContext.request.contextPath}/mypage/drawlist";
	   var paramData = {
			   
	         "mem_id" : '<%=(String)session.getAttribute("mem_id")%>'         
	   };

	   
	   $.ajax({
	      
	      url : url,
	      data : paramData,
	      dataType : 'json',
	      type : 'POST',
	      success : function(result){
	         
	         var htmls = ""; //문서꾸미기
	         if(result.length < 1){
	            htmls += '<h3>신청내역이 없습니다.</h3>';
	         }
	         else{
	            $(result).each(function(){
	                  
	                  htmls = htmls + '<div class="" id="mem_id' +this.mem_id + '">';
	                       //<div id="reno12"> <div id="reno13">
	                   htmls += '<span class="d-block">';
	                  
	                   htmls += this.mem_withdraw + ' - ';
	                   htmls += '<strong class="text-gray-dark">'+'금액:' + this.mem_amount1 +'-'+ '</strong>';
	                   htmls += '날짜:';
	                   htmls += this.mem_drawdate;
	                   htmls += '<span style="padding-left: 7px; font-size: 9pt">';
	                  
	                   htmls += '</span>';
	                   htmls += '</span>';
	                   htmls += '</p>';
	                   htmls += '</div>';   
	                   htmls += '</div>'; 
	            });
	         }
	         
	         $("#drawlist").html(htmls); //댓글위치에 html로 보여주기
	      },
	      error : function(result){
	         alert('로그인 후 이용해주세요.');
	      }
	      
	   });
	   } //end noticelist()
});
</script>

<form action="withdraw" method="POST">
${user.mem_id } 님의 보유 캐쉬 : ${user.mem_cash }원

<div> 출금할 금액을 입력해주세요 : <hr>
<input type="text" id="mem_amount1" name="mem_amount1" placeholder="금액을 입력해주세요"> <p>

<input type="submit" class="Chargebtn" value="출금신청"> <input type="reset" class="Chargebtn" value="다시입력">
</div>
<hr>
	${user.mem_id } 님의 캐쉬 출금 내역 :

<div id="drawlist"></div>
</form>


</main>
<%@include file="../include2/footer.jsp" %>