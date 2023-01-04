<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../include2/head.jsp" %>
<%@include file="../include2/menu.jsp" %>

<div data-v-76574781="" class="container customer md">
	<div data-v-76574781="">
		<div data-v-76574781="" class="snb_area">
			<a data-v-76574781="" href="${contextPath}/notice/notice" class="nuxt-link-exact-active nuxt-link-active" aria-current="page">
			<h2 data-v-76574781="" class="snb_main_title">고객센터</h2></a>
			<nav data-v-7bcac446="" data-v-76574781="" class="snb">
				<div data-v-7bcac446="" class="snb_list">
				<!---->
					<ul data-v-4d11470e="" data-v-7bcac446="" class="snb_menu">
						<li data-v-4d11470e="" class="menu_item"><a data-v-4d11470e="" href="${contextPath}/notice/notice" class="menu_link nuxt-link-exact-active nuxt-link-active" aria-current="page"> 공지사항 </a></li>
						<li data-v-4d11470e="" class="menu_item"><a data-v-4d11470e="" href="${contextPath}/notice/event" class="menu_link"> 이벤트 </a></li>
						<li data-v-4d11470e="" class="menu_item"><a data-v-4d11470e="" href="${contextPath}/notice/update" class="menu_link"> 업데이트 </a></li>
						<li data-v-4d11470e="" class="menu_item menu_on"><a data-v-4d11470e="" href="${contextPath}/notice/inquiry" class="menu_link"> 1:1문의 </a></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
		<div data-v-76574781="" class="content_area">
			<div data-v-0067a928="" data-v-76574781="" class="customer_content my_notice">
				<div data-v-88eb18f6="" data-v-0067a928="" class="content_title border">
					<div data-v-88eb18f6="" class="title">
					<h3 data-v-88eb18f6="">1:1문의하기 </h3>
					</div>
					</div>
			 <form:form modelAttribute="InquiryDTO" method="post" action="inquiryadd" >
			
				<ul data-v-0067a928="" class="dropdown_list">
					<li data-v-0067a928="">
					<div data-v-0067a928="" class="dropdown">
						<div data-v-0067a928="" class="dropdown_head">
							<div data-v-0067a928="" class="title_box">
								<p data-v-0067a928="" class="title">
								문의유형 : <form:select path="inquiry_sort">
											<form:option value="회원정보">회원정보</form:option>
											<form:option value="주문/결제">주문/결제</form:option>
											<form:option value="교환/취소">교환/취소</form:option>
											<form:option value="배송">배송</form:option>
								
										 </form:select>
							
								</p>
							</div>
						</div>
					</div>
					</li>					
				</ul>	
				
				
				
				<ul data-v-0067a928="" class="dropdown_list">
					<li data-v-0067a928="">
					<div data-v-0067a928="" class="dropdown">
						<div data-v-0067a928="" class="dropdown_head">
							<div data-v-0067a928="" class="title_box">
								<p data-v-0067a928="" class="title">
								제목 : <form:input path="inquiry_title" />
								<font color="red">
									<form:errors path="inquiry_title" />
								</font>
								</p>
							</div>
						</div>
					</div>
					</li>					
				</ul>
				<ul data-v-0067a928="" class="dropdown_list">
					<li data-v-0067a928="">
					<div data-v-0067a928="" class="dropdown">
						<div data-v-0067a928="" class="dropdown_head">
							<div data-v-0067a928="" class="title_box">
								<p data-v-0067a928="" class="title">
								내용 : <form:textarea cols="100" rows="14" placeholder="내용을 입력하세요" path="inquiry_content" />
								<font color="red">
									<form:errors path="inquiry_content" />
								</font>
								</p>
							</div>
						</div>
					</div>
					</li>					
				</ul>
				<p class="button"><form:button name="inquiryadd">작성완료</form:button></p>
			 </form:form>
			</div>
		</div>
</div>

<%@include file="../include2/footer.jsp" %>