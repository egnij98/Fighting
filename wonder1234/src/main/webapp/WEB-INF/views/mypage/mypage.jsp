<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@include file="../include2/head.jsp" %>
<%@include file="../include2/menu.jsp" %>
<main id="content" class="content" role="main">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%@include file="../include2/head.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#profileUpdateBtn").on("click", function(){
			location.href="${contextPath}/mypage/profileUpdateView";
		})
		
	})
</script>
<div data-v-76574781="" class="container customer md">
	<div data-v-76574781="">
		<div data-v-76574781="" class="snb_area">
			<a data-v-76574781="" href="${contextPath}/mypage/mypage" class="nuxt-link-exact-active nuxt-link-active" aria-current="page">
			<h2 data-v-76574781="" class="snb_main_title">마이페이지</h2></a>
			<nav data-v-7bcac446="" data-v-76574781="" class="snb">
				<div data-v-7bcac446="" class="snb_list">
				<!---->
					<ul data-v-4d11470e="" data-v-7bcac446="" class="snb_menu">
						<li data-v-4d11470e="" class="menu_item menu_on"><a data-v-4d11470e="" href="${contextPath}/mypage/mypage" class="menu_link nuxt-link-exact-active nuxt-link-active" aria-current="page"> 마이페이지 </a></li>
						<li data-v-4d11470e="" class="menu_item"><a data-v-4d11470e="" href="${contextPath}/notice/event" class="menu_link"> 프로필수정 </a></li>
						<li data-v-4d11470e="" class="menu_item"><a data-v-4d11470e="" href="${contextPath}/notice/update" class="menu_link"> 캐쉬충전 </a></li>
						<li data-v-4d11470e="" class="menu_item"><a data-v-4d11470e="" href="${contextPath}/notice/inquiry" class="menu_link"> 캐쉬출금 </a></li>
						<li data-v-4d11470e="" class="menu_item"><a data-v-4d11470e="" href="${contextPath}/notice/inquiry" class="menu_link"> 회원탈퇴 </a></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
	

	<form class="mypage" action="mypage" method="GET">
<div style="text-align:left">	<h3>프로필 정보</h3>  <p>
	<hr color="black" size="10px">
	
	<div class="profilebox">
		<div class="profile_group">
		
		<h6 class="group-title">아이디</h6>
			
			<div class="unit">
			<div class="profileid">${user.mem_id }</div>
			</div>
				</div>
				
				<div class="profile_group">
		<h6 class="group-title">이름</h6>
			
			<div class="unit">
			<div class="profileid">${user.mem_name }</div>
			</div>	
				</div>
				<div class="profile_group">
		<h6 class="group-title">닉네임</h6>
			
			<div class="unit">
			<div class="profileid">${user.mem_nickname }</div>
			</div>	
				</div>
				<div class="profile_group">
		<h6 class="group-title">우편번호</h6>
			
			<div class="unit">
			<div class="profileid">${user.mem_address }</div>
			</div>	
				</div>
				<div class="profile_group">
		<h6 class="group-title">도로명주소</h6>
			
			<div class="unit">
			<div class="profileid">${user.mem_address1 }</div>
			</div>	
				</div>
				<div class="profile_group">
		<h6 class="group-title">상세주소</h6>
			
			<div class="unit">
			<div class="profileid">${user.mem_address2 }</div>
			</div>	
				</div>
				<div class="profile_group">
		<h6 class="group-title">전화번호</h6>
			
			<div class="unit">
			<div class="profileid">${user.mem_phonenum }</div>
			</div>	
				</div>
				<div class="profile_group">
		<h6 class="group-title">이메일</h6>
			
			<div class="unit">
			<div class="profileid">${user.mem_email1 }</div>
			</div>	
				</div>
				<div class="profile_group">
		<h6 class="group-title">생일</h6>
			
			<div class="unit">
			<div class="profileid">${user.mem_birth }</div>
			</div>	
				</div>
				<div class="profile_group">
		<h6 class="group-title">성별</h6>
			
			<div class="unit">
			<div class="profileid">${user.mem_gender }</div>
			</div>	
				</div>
				<div class="profile_group">
		<h6 class="group-title">캐쉬</h6>
			
			<div class="unit">
			<div class="profileid">${user.mem_cash}</div>
		<button type="button" class="btn1" onclick ="location.href='cashChargeView'">충전</button>
		<button type="button" class="btn1" onclick ="location.href='cashWithdrawView'">출금</button>
			</div>	
				</div>

			<hr>
			<button id="profileUpdateBtn" class="btn4" type="button" >프로필 수정</button> <button type="button" class="btn4" onclick="location.href='${contextPath}/'">돌아가기</button>
			</div> <!--  end of profilebox -->
	
	</div>
		</form>
		
		
		
		
		
		<a class="scroll-down icon-arrow-left" href="#content" data-offset="-45"><span class="hidden">Scroll Down</span></a>
	
	
		</main>
	<%@include file = "../include2/script.jsp" %>
		<%@include file = "../include2/footer.jsp" %>



	
	   
		
		
		
		


   
   
