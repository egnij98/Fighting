<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../include2/head.jsp" %>
<link rel="stylesheet" type="text/css" href="${contextpath}/resources/css/styles.css"/>
<script type="text/javascript">
	
function cart() {	
		confirm("장바구니 추가되었습니다")
}
</script>

<div class="site-wrapper">
	<nav class="main-nav overlay clearfix">
	<%@ include file = "../include2/menu.jsp" %>
	<link rel="stylesheet" type="text/css" href="${contextpath}/resources/css/main.css"/>
	</nav>
	<header class="main-header post-head " style="background-image: url(${contextpath}/resources/img/jo.png)">
	<div class="vertical">
		<div class="main-header-content inner">
			<h1 class="post-title">원더</h1>
			<div class="entry-title-divider">
				<span></span><span></span><span></span>
			</div>
		</div>
	</div>
	</header>
<section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img src="${contextpath}/resources/img/${dto.product_img}" width="300px"
                height="300px"></div>
                    <div class="col-md-6">
                        <h1 class="display-5 fw-bolder">${dto.product_name }</h1>
                        <p class="lead">${dto.product_desc }</p>
                        <c:choose> 
						    <c:when test="${price.product_code eq '판매완료'}">
						        <a>즉시 구매할수있는 상품이 없습니다</a>
						    </c:when>
						    <c:otherwise>
						    	<td>즉시구매가:${price.product_price }원</td>	
						    </c:otherwise>
						</c:choose>
                        <div class="d-flex">
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                <a href = "${contextpath }/product/order?product_name=${dto.product_name}&product_cate=${dto.product_cate}">구매</a>
                            </button>
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                <a href = "${contextpath }/product/sale?product_name=${dto.product_name}&product_cate=${dto.product_cate}">판매</a>
                            </button>
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                <a href = "${contextPath}/product/wishlistinsert?product_name=${dto.product_name }&product_cate=${dto.product_cate}">찜하기</a>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Related items section-->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">Related products</h2>
                <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                <c:forEach var="board" items="${cate }">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="${contextpath }/resources/img/${board.product_img }" alt="사진없음"/>
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

	<footer class="site-footer clearfix">

	</footer>
</div>

</body>
</html>