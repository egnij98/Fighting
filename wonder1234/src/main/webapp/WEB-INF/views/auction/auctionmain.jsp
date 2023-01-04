  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ page session="true" %>
  <%@include file="../include2/head.jsp" %>
  <%@include file="../include2/menu.jsp" %>
	<main class="content" role="main">
	<div class="content-wrapper">

    <!-- Main content -->
    <section class="content container-fluid">
		 <div>${msg}</div>
		 
		<div class="table-responsive">
		  	
		  	<div class="box">
		<div class="box-header with-border">
				<a href="${contextPath}auctionaddproduct"><h3 class="box-title">경매 목록</h3></a>
		</div>
	</div>
		  <table class="table">
		  <tr>
		  	<td>글번호</td>
		  	<td>제목</td>
		  	<td>경매 기간</td>

		
		  </tr>
		<c:forEach var="wonder" items="${list }">
		 	<tr>
		 	<td>${wonder.ab_id}</td>
		 	<td>
		 	<a href="auctionproductdetail${auctionPageMaker.makeQuery(auctionPageMaker.pag.page)}&ab_id=${wonder.ab_id}">
		 	${wonder.ab_title} </a>
		 	</td>
		 	<td>${wonder.ab_limit}</td>
	
		 	</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5" align="center">
					<button><a href ="auctionmain"> 경매메인 </a></button>
			</td>
		</tr>
		  </table>
		
		</div>
		<div>
		  <div class="text-center">
	<ul class="pagination">
 	 	
	<c:if test="${auctionPageMaker.prev }">
		<li><a href="auctionlist${auctionPageMaker.makeQuery(auctionPageMaker.startPage - 1)}">&laquo;</a></li>
		</c:if>
		
		<c:forEach begin="${auctionPageMaker.startPage }"
					end="${auctionPageMaker.endPage }" var="pageNum">
					<li
						<c:out value="${auctionPageMaker.pag.page == pageNum?'class =active':' '}"/>>
						<a href="auctionlist${auctionPageMaker.makeQuery(pageNum)}">${pageNum }</a>
						</li>
		</c:forEach>
			<c:if test="${auctionPageMaker.next && auctionPageMaker.endPage > 0 }">
			<li><a href="auctionlist${auctionPageMaker.makeQuery(auctionPageMaker.endPage+1)}">&raquo;</a>
			</li>
			</c:if>
	</ul>
  
  </div>
		
		</div>
    </section>
        <script>
	$(function(){
		//메인 버튼을 눌렀을 때 처리
		$(".btn-success").click(function(){
			console.log ="1";
			location.href="../";
		});
	})
	</script>
    <!-- content -->
  </div>
	</main>
<%@include file="../include2/footer.jsp"%>