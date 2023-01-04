<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
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
						<li data-v-4d11470e="" class="menu_item menu_on"><a data-v-4d11470e="" href="${contextPath}/notice/notice" class="menu_link nuxt-link-exact-active nuxt-link-active" aria-current="page"> 공지사항 </a></li>
						<li data-v-4d11470e="" class="menu_item"><a data-v-4d11470e="" href="${contextPath}/notice/event" class="menu_link"> 이벤트 </a></li>
						<li data-v-4d11470e="" class="menu_item"><a data-v-4d11470e="" href="${contextPath}/notice/update" class="menu_link"> 업데이트 </a></li>
						<li data-v-4d11470e="" class="menu_item"><a data-v-4d11470e="" href="${contextPath}/notice/inquiry" class="menu_link"> 1:1문의 </a></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
		<div data-v-76574781="" class="content_area">
			<div data-v-0067a928="" data-v-76574781="" class="customer_content my_notice">
				<div data-v-88eb18f6="" data-v-0067a928="" class="content_title border">
					<div data-v-88eb18f6="" class="title">
					<h3 data-v-88eb18f6="">${Notice.notice_sort}</h3>
					<br>
					</div>
					</div>
					
			
			
				<ul data-v-0067a928="" class="dropdown_list">
					<li data-v-0067a928="">
					<div data-v-0067a928="" class="dropdown">
						<div data-v-0067a928="" class="dropdown_head">
							<div data-v-0067a928="" class="title_box">
							 <p data-v-0067a928="" class="title">[제목]-${Notice.notice_title}</p>
							</div>
						</div>
						<div data-v-652025ab="" class="dropdown_content">
							<div data-v-652025ab="" class="contents">
								<p>${Notice.notice_content}</p>
							</div>
						</div>
					</div>
					</li>					
				</ul>
			
			
		
			</div>
		</div>
			<div data-v-652025ab="" class="btn_list">
				<a data-v-3d1bcc82="" data-v-652025ab="" href="${contextPath}/notice/
				<c:if test="${Notice.notice_sort == '공지사항'}">notice</c:if>
				<c:if test="${Notice.notice_sort == '이벤트'}">event</c:if>
				<c:if test="${Notice.notice_sort == '업데이트'}">update</c:if>
				" class="btn outlinegrey medium"> 목록보기 </a>
			</div>
</div>



<%@include file="../include2/footer.jsp" %>