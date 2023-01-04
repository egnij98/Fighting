
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@include file="../include2/head.jsp"%>
<%@include file="../include2/menu.jsp"%>
<main class="content" role="main">
	<div class="content-wrapper">
		<!-- content -->
	</div>
<div class="container">
 		
 	<c:forEach var="wonder" items="${list }">
 	
 		<tr>
            <div class="row justify-content-center" id="loadDataItems" style="margin:5%;">
				<div class="col-lg-3 col-sm-6 col-md-6">
                    <div class="item-box">
					   <a href="auctionproductdetail${auctionPageMaker.makeQuery(auctionPageMaker.pag.page)}&ab_id=${wonder.ab_id}">
					   <img src="${pageContext.request.contextPath}/resources/images/${Product.product_img}" alt="" style="width:100%;height:100%;border-radius:5px"></a>
                        <ul class="item-features list-unstyled"><li style="width:150px;float:left;list-style:none;padding-top:15px;font-size:16px;text-overflow:ellipsis; white-space: nowrap; overflow: hidden">${wonder.ab_title}</li><li style="max-width:40px;float:right;list-style:none;padding-top:15px" align="right"><span id="wishStatus_100"></span></li></ul>
						<div class="sp10"></div> 
                        <ul class="item-features list-unstyled"><li style="width:103px;float:left;list-style:none;font-size:1.0em;">즉시입찰가격</li><li style="max-width:90px;float:right;list-style:none;" align="right">${wonder.ab_endprice}</li></ul>
						<div class="sp1"></div>
                        <ul class="item-features list-unstyled"><li style="width:70px;float:left;list-style:none;font-size:1.0em;">시작가</li><li style="max-width:90px;float:right;list-style:none;" align="right">${wonder.ab_startprice}</li></ul>
						<div class="sp1"></div>
                        <ul class="item-features list-unstyled"><li style="width:70px;float:left;list-style:none;font-size:1.0em;">현재가</li><li style="max-width:90px;float:right;list-style:none;" align="right">${wonder.ab_currentprice}</li></ul>		
						<div class="sp1"></div> 
						
				        <!-- 카운트다운 -->
					    <span class="block ">
						<span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span id="getting-started" class="getting-started-100" style="font-size:1.0em;letter-spacing:.01px">02일 20시간 07분 07초</span>
						</span>
     					<div class="sp10"></div> 
						<div style="border:0;width:100%;height:1px;padding:0;clear:both;background-color:#eee"></div>
						<div class="sp10"></div> 
                        <div style="width:100%" align="center">
                        						<a href="auctionproductdetail${auctionPageMaker.makeQuery(auctionPageMaker.pag.page)}&ab_id=${wonder.ab_id}" class="btn btn-primary btn-circled" style="font-size:1.0em;padding:10px;border-radius:20px">응찰하러 가기</a>
												</div>
                    </div>
					<div class="sp20"></div>
                </div>
                </div>
                
                </tr>
             
           </c:forEach>
</div>
                
                					<tr>
						<td colspan="5" align="center">
							<button>
								<a href="/"> 메인 </a>
							</button>
								<button class="btn btn-info">경매 등록</button>
		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>		 
		<script>
		 //경매상품등록 버튼을 눌렀을 때 처리
		$(".btn-info").click(function(){
			location.href="auctionaddproduct";
		});
		</script>
						</td>
					</tr>
			
	<div class="row">
 			 <select name="searchType">
   				  <option value="title">물품</option>
       			  <option value="content">내용</option>
	       		  <option value="title_content">물품명+내용</option>
					<option value="writer">작성자</option>
 			 </select>
  
  			<input type="text" name="keyword" />
  
  			<span class="input-group-btn">
  			<button type="submit" class="btn-square btn-primary" id="search">검색</button></span>
 </div>

		

			<div class="col-lg-12 col-sm-12 col-md-126">
				<div class="main_cont_wrap mo_tr" style="padding: 10px">
					<ul class="pagination justify-content-center">
						<li class="active page-item">
						<c:if test="${auctionPageMaker.prev }">
							<li><a
								href="auctionlist${auctionPageMaker.makeQuery(auctionPageMaker.startPage - 1)}">&laquo;</a></li>
						</c:if>

						<c:forEach begin="${auctionPageMaker.startPage }"
							end="${auctionPageMaker.endPage }" var="pageNum">
							<li
								<c:out value="${auctionPageMaker.pag.page == pageNum?'class =active':' '}"/>>
								<a href="auctionlist${auctionPageMaker.makeQuery(pageNum)}">${pageNum }</a>
							</li>
						</c:forEach>
						<c:if
							test="${auctionPageMaker.next && auctionPageMaker.endPage > 0 }">
							<li><a
								href="auctionlist${auctionPageMaker.makeQuery(auctionPageMaker.endPage+1)}">&raquo;</a>
							</li>
						</c:if>
					</ul>

				</div>
			</div>


                       <div class="sp30"></div>

	</main>
	<%@include file="../include2/footer.jsp"%>