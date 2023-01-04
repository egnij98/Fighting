<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../include2/head.jsp" %>
<link rel="stylesheet" type="text/css" href="${contextpath}/resources/css/styles.css"/>
 <script type="text/javascript">
            	$(document).ready(function() {
            		var result='<c:out value="${result}"/>';
            		checkModal(result);
            		
            		history.replaceState({}, null, null);
            		
            		function checkModal(result) {
            			if(result==='' || history.state) {
            				return;
            			}
            			
            			if(parseInt(result) > 0) {
            				$(".modal-body").html("게시글 " + parseInt(result) + "번이 등록되었습니다.");
            			}
            			
            			$("#myModal").modal("show");
            		}
            		
            		$("#regBtn").on("click", function() {
            			self.location="/board/register";
            		});
            		
            		var actionForm = $("#actionForm");
            		
            		$(".paginate_button a").on("click", function(e) {
            			e.preventDefault();
            			console.log('click');
            			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
            			actionForm.submit();
            		});
            	});
            </script>


<div class="site-wrapper">
	
	<%@ include file = "../include2/menu.jsp" %>
	

	<header class="main-header post-head " style="background-image: url(${contextpath}/resources/img/jo.png)">
	<div class="vertical">
		<div class="main-header-content inner">
			<h1 class="post-title">언제나 어디서나 에센셜</h1>
			<div class="entry-title-divider">
				<span></span><span></span><span></span>
			</div>
		</div>
	</div>
	</header>
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
		 <main>


		     <c:forEach var="board" items="${product }" >
        <section class="py-5" >
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="${contextpath }/wonder/resources/img/${board.product_img}" alt="사진없음"  />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><a href="product/productdetail?product_name=${board.product_name}&product_cate=${board.product_cate}">${board.product_name}</a></h5>
                                    <!-- Product price-->
                                    ${board.product_desc}
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </c:forEach>
		 
		 </main>

	<footer class="site-footer clearfix">

	</footer>
</div>

</body>
</html>