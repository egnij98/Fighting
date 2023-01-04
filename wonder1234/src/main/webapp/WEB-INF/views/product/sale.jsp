<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../include2/head.jsp" %>
	<%@ include file = "../include2/menu.jsp" %>
	<link rel="stylesheet" type="text/css" href="${contextpath}/resources/css/styles.css"/>
<div class="site-wrapper">
	
	
	<header class="main-header " style="background-image: url(resources/img/q2.jpg)">
	<div class="vertical">
		<div class="main-header-content inner">
			<h1 class="page-title">Fashion</h1>
			<div class="entry-title-divider">
				<span></span><span></span><span></span>
			</div>
			<h2 class="page-description">원더는 고객이 더 싸게 살수있게 도와드립니다</h2>
		</div>
	</div>
	<a class="scroll-down icon-arrow-left" href="#content" data-offset="-45"><span class="hidden">Scroll Down</span></a>
	</header>
	
	<main id="content" class="content" role="main">
		<h3>판매</h3>
		<c:forEach var="item" items="${sizebuy}" >
      		<button style = "font-size:large;"><a href="${contextpath }/product/saleinsert?product_name=${item.product_name}&product_size=${item.product_size }&price=${item.product_price }">
				${item.product_size }
				<br>
				${item.product_price }
				</a>
			</button>
		</c:forEach>
	</main>
	<footer class="site-footer clearfix">

	</footer>
</div>

</body>
</html>