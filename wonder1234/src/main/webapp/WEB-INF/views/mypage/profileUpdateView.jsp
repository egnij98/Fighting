<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@include file="../include2/head.jsp" %>
<%@include file="../include2/menu.jsp" %>
<main id="content" class="content" role="main">

<i class="fa fa-love"></i><a href="https://bootstrapthemes.co"></a>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%@include file="../include2/head.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#profileUpdateBtn").on("click", function(){
			location.href="wonder/profileUpdateView";
		});
		
	})
</script>
<!--  다음API -->
<script>
function execPostCode() {
         new daum.Postcode({
             oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                console.log(data.zonecode);
                console.log(fullRoadAddr);
                
                
                $("[name=mem_address]").val(data.zonecode);
                $("[name=mem_address1]").val(fullRoadAddr);
                
                /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
                document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
            }
         }).open();
     }
</script>


	<form class="profileUpdate" action="profileUpdate" method="POST">
<div style="text-align:left">	<h3>프로필 수정</h3>  <p>
	<hr color="black" size="10px">
	
	<div class="profilebox">
		<div class="profile_group">
		
		<h6 class="group-title">아이디</h6>
			
			<div class="unit">
			<div class="profileid">${user.mem_id }</div>
			<input type="hidden" id="mem_id" name="mem_id" value="${user.mem_id }">
			</div>
				</div>
				
				<div class="profile_group">
		<h6 class="group-title">이름</h6>
			
			<input type="text" name="mem_name"  value = "${user.mem_name}">
				</div>
				
				<div class="profile_group">
		<h6 class="group-title">닉네임</h6>
			
			<input type="text" name="mem_nickname"  value = "${user.mem_nickname}">
				</div>
				
				<div class="profile_group">
		<h6 class="group-title">우편번호</h6>
			
		<input type="text" name="mem_address"  value = "${user.mem_address}" readonly="readonly">
				</div>
		<button type="button" class="btn5" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>
				
				<div class="profile_group">
		<h6 class="group-title">도로명주소</h6>
			<input type="text" name="mem_address1"  value = "${user.mem_address1}" readonly="readonly">
				</div>
				
				<div class="profile_group">
		<h6 class="group-title">상세주소</h6>
			<input type="text" name="mem_address2"  value = "${user.mem_address2}">
				</div>
				
				<div class="profile_group">
		<h6 class="group-title">전화번호</h6>
		<input type="text" name="mem_phonenum"  value = "${user.mem_phonenum}">
				</div>
				
				<div class="profile_group">
		<h6 class="group-title">이메일</h6>
		<input type="text" name="mem_email1"  value = "${user.mem_email1}">
				</div>
				
				<div class="profile_group">
		<h6 class="group-title">생일</h6>
			<input type="text" name="mem_birth"  value = "${user.mem_birth}">
				</div>
				
				<div class="profile_group">
				
		<h6 class="group-title">성별</h6>
		<input type="text" name="mem_gender"  value = "${user.mem_gender}">
				</div>
			
				<div class="profile_group">
		<h6 class="group-title">캐쉬</h6>
			<input type="text" name="mem_cash"  value = "${user.mem_cash}">
				</div>
				
		
			</div>	
				</div>

		<button type="submit" class="btn3">수정완료</button> <button type="reset" class="btn3">다시입력</button> <p>
		<button type="button" onclick= "location.href ='${contextPath}/mypage/deleteView'" class="btn3">회원 탈퇴</button>
	</form>
	
	<a class="scroll-down icon-arrow-left" href="#content" data-offset="-45"><span class="hidden">Scroll Down</span></a>
	
	</main>

	<%@include file = "../include2/footer.jsp" %>
<%@include file = "../include2/script.jsp" %>
		
		
		
		
