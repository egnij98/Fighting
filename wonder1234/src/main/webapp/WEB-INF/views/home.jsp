  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ page session="true" %>
  <%@ include file="include2/head.jsp" %>
  <%@ include file="include2/menu.jsp" %>
<link rel="stylesheet" type="text/css" href="${contextpath}/resources/css/styles.css"/>
<script>
  $(function(){
	$("#find_id_btn").click(function(){
		location.href="/idfind";
		
	})  
  }) 
</script>
  	<header class="main-header " style="background-image: url(resources/img/jo.png)">
	<div class="vertical">
		<div class="main-header-content inner">
			<h1 class="page-title">원더</h1>
			<div class="entry-title-divider">
				<span></span><span></span><span></span>
			</div>
			<h2 class="page-description">원하는 패션을 더 싸게</h2>
		</div>
	</div>
	<a class="scroll-down icon-arrow-left" href="#content" data-offset="-45"><span class="hidden">Scroll Down</span></a>
	</header>

	 <!-- Related items section-->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">모든상품</h2>
                <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                <c:forEach var="board" items="${product }">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="${contextpath }/resources/img/${board.product_img}" alt="사진없음"/>
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><a href="${contextpath }/product/productdetail?product_name=${board.product_name}&product_cate=${board.product_cate}">${board.product_name}</a></h5>
                                    <!-- Product price-->
                                    ${board.product_desc }
                                </div>
                            </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                        </div>
                    </div>  
        </section>

		
		<!-- <div class='pull-right'>
		
			<ul class="paginatuion">
			<c:if test="${pageMaker.prev}">
				<li class= "paginate_button prenious"><a href="${pageMaker.startPage-1}">previous</a>
				</li>
			</c:if>
			<c:forEach var="num" begin ="${pageMaker.startPage}"
			end="${pageMaker.endPage}">
			<li class="paginate_button ${pageMaker.cri.page == num ? "active":""} ">
			<a href="${num}">${num}</a>
			</li>
			 </c:forEach>
			 <c:if test="${pageMaker.next}">
				<li class= "paginate_button next"><a href="${pageMaker.endPage + 1 }">Next</a>
				</li>
			</c:if>
			</ul>
			<form id='actionForm' action="/wonder/product" mothod = 'get'>
				<input type="hidden" name='pageNum' value = '${pageMaker.cri.page}'>
				<input type="hidden" name='perPageNum' value = '${pageMaker.cri.perPageNum}'>
				</form>
			
		</div>
		 -->
		
		
		</section>
		</footer>

		</article>
	</div>
	</main>
<%@ include file="include2/footer.jsp" %>