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
						<li data-v-4d11470e="" class="menu_item"><a data-v-4d11470e="" href="${contextPath}/notice/notice" class="menu_link nuxt-link-exact-active nuxt-link-active" aria-current="page"> 공지사항 </a></li>
						<li data-v-4d11470e="" class="menu_item menu_on"><a data-v-4d11470e="" href="${contextPath}/notice/event" class="menu_link"> 이벤트 </a></li>
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
					<h3 data-v-88eb18f6="">이벤트</h3>
					<br>
					</div>
					</div>
			<c:forEach var="Notice" items="${list}">	
			   <c:if test="${Notice.notice_sort eq '이벤트'}">	
				<ul data-v-0067a928="" class="dropdown_list">
					<li data-v-0067a928="">
					<div data-v-0067a928="" class="dropdown">
						<div data-v-0067a928="" class="dropdown_head">
							<div data-v-0067a928="" class="title_box">
							<p data-v-0067a928="" class="title">[${Notice.notice_sort}]-<a href="noticedetail?notice_id=${Notice.notice_id}"> ${Notice.notice_title} </a></p>
							</div>
						</div>
					</div>
					</li>					
				</ul>
			  </c:if>
			</c:forEach>
			</div>
		</div>
</div>

		<ul class="pagination">
				<c:if test="${pageMaker.prev}">
					<li class="list"><a href="event?page=${pageMaker.startPage-1}">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
				 	<li class="list">
				 		<a 
				 		<c:out value="${pageMaker.cri.page == idx?'style=color:blue':''}"/>
				 		href="event?page=${idx}">${idx}</a>
				    </li> 			
				</c:forEach>
				
				<c:if test ="${pageMaker.next && pageMaker.endPage >0 }">
					<li class="list"><a href ="event?page=${pageMaker.endPage+1 }">&raquo;</a></li>
	   			</c:if>
							
			</ul>
<%@include file="../include2/footer.jsp" %>