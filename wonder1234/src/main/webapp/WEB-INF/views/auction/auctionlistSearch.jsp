
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp" %>
<head>
<meta charset="UTF-8">
<title>WONDER</title>
</head>
<body>
경매 목록

<div class="content-wrapper">

    <!-- Main content -->
    <section class="content container-fluid">
		 <div>${msg}</div>
		 
		<div class="table-responsive">
		  	 <td>경매 목록</td>
		  	<div class="box">
		<div class="box-header with-border">
				<a href="${contextPath}/wonder/auctionaddproduct"><h3 class="box-title">경매 상품 등록</h3></a>
		</div>
	</div>
		  <table class="table">
		  <tr>
		  	<td>글번호</td>
		  	<td>제목</td>
		  	<td>경매 기간</td>
		  	<td>작성자</td>
		<!--   	<td>조회수</td> -->
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
	<div>
 			 <select name="searchType">
   				  <option value="title">제목</option>
       			  <option value="content">내용</option>
	       		  <option value="title_content">제목+내용</option>
					<option value="writer">작성자</option>
 			 </select>
  
  			<input type="text" name="keyword" />
  
  			<button type="button">검색</button>
 </div>
  
  </div>
 
</body>
</html>

























