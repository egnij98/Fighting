<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@include file="../include2/head.jsp" %>
<%@include file="../include2/menu.jsp" %>

<link rel="stylesheet" href="${contextPath}/resources/css1/test.css">
<main id="content" class="content" role="main">

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	var idJ = /^[a-z0-9]{4,12}$/;
// 아이디 유효성 검사(1 = 중복 / 0 != 중복)
$(document).ready(function(){
		console.log("반응이있다");
	$("#mem_id").blur(function() {
		// id = "id_reg" / name = "userId"
		var mem_id = $('#mem_id').val();
		var params = {
				"mem_id" : mem_id
		};
		console.log("2222");
		$.ajax({
			url : '${pageContext.request.contextPath}/idCheck',
			data : params, 
			type : 'get',
			success : function(data) {
				console.log("1 = 중복o / 0 = 중복x : "+ data);							
				$('#id_check').text("사용가능한 아이디입니다. ");
				$('#id_check').css('color', 'green');
				if (data == mem_id) {
						// 1 : 아이디가 중복되는 문구
						console.log("왜 이게나와");
						$("#id_check").text("사용중인 아이디입니다.");
						$("#id_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					} else {
				
						
						if(idJ.test(mem_id)){
							// 0 : 아이디 길이 / 문자열 검사
							$("#id_check").text("");
							$("#reg_submit").attr("disabled", false);
				
						}else if (mem_id == "") {

                            $('#id_check').text('아이디를 입력해주세요.');
                            $('#id_check').css('color','red');
                            $("#reg_submit").attr("disabled", true);

                         }else {
							
							$('#id_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다 ");
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);
						}
					}
			
				
				}, error : function() {
						console.log("실패");
				}
			});
		});
		
});
</script>
							
							
						

<!--  다음API -->
<script>
function execPostCode() {
		console.log("반응")
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

<script type="text/javascript">
   function pwtest() {
      var p1 = document.getElementById('password').value;
      var p2 = document.getElementById('password2').value;
      if (p1 != p2) {
         alert("비밀번호가 일치 하지 않습니다");
         return false;
      } else {
         alert("비밀번호가 일치합니다");
         return true;
      }

   }
   </script>
 
    <form action="addMember2" method="post">
        <h2>회원가입</h2>
    <div class="addmemberbox">    
      <div class="textForm">
        <input name="mem_id" type="text" class="id" name="mem_id" id="mem_id" placeholder="아이디">
      </div>
        <div class="check_font" id="id_check"></div> <p>
      <div class="textForm">
        <input name="mem_password" type="password" class="pw" name="mem_password" id="password" placeholder="비밀번호">
      </div>
       <div class="textForm">
        <input name="p2" type="password" class="pw" name="password2" id="password2" placeholder="비밀번호 확인">
        <button type="button" onclick="pwtest()" class="btn1" >비밀번호 확인</button>
      </div>
      <div class="textForm">
        <input name="mem_name" type="text" class="name" name="mem_name" placeholder="이름">
      </div>
      <div class="textForm1">
        <input name="mem_address" type="text" class="address" name="mem_address" id="mem_address" placeholder="우편번호" readonly="readonly">
      <button type="button" class="btn1" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>
      </div>
      <div class="textForm">
        <input name="mem_address1" type="text" class="address1" name="mem_address1" id="mem_address1" placeholder="도로명주소" readonly="readonly">
      </div>
      <div class="textForm">
        <input name="mem_address2" type="text" class="address2" name="mem_address2" id="mem_address2" placeholder="상세주소">
      </div>
       <div class="textForm">
        <input name="mem_email1" type="text" class="email" name="mem_email1" placeholder="이메일">
      </div>
      <div class="textForm">
        <input name="mem_nickname" type="text" class="nickname" name="mem_nickname" placeholder="닉네임">
      </div>
      <div class="textForm">
        <input name="mem_phonenum" type="number" class="cellphoneNo" name="mem_phonenum" placeholder="전화번호">
      </div>
      <div class="textForm">
        <input name="mem_birth" type="date" class="birth" name="mem_birth" placeholder="생년월일">
      </div>
      <div class="textForm">
      성별 : <input type="checkbox" name="mem_gender" value="남"> 남 <input type="checkbox" name=mem_gender value="여"> 여 <p>
      </div>
     <%@ include file="../include2/hint1.jsp" %>
      <!--  <div class="textForm">
        <input name="cellphoneNo" type="number" class="cellphoneNo" name="mem_id" placeholder="전화번호">
      </div>-->
      <div class="textForm">
        <input name="mem_hint2" type="text" class="hint2" name="mem_hint2" placeholder="답변">
      </div>
      <input type="submit" class="btn" id="submit" value="J O I N"/>
      
      </div>
      
	  </form>
	
</main>
<%@include file = "../include2/script.jsp" %>

			