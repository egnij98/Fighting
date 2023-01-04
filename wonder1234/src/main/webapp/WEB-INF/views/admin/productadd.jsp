<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../include/header2.jsp" %>
<title>title.</title>
<%@include file="../include/navbar2.jsp"%> 

			<h2>상품등록</h2>
	<div class="content" style="text-align :center">
		
			
	
		<form:form modelAttribute="AdminProductDTO" method="post" action="productadd" enctype="multipart/form-data">
			<p>
				상품이미지 : <input type="file" name="img" multiple/>
				
			</p>
			<p>
				상품명 : <form:input path="product_name" />
				<font color="red">
					<form:errors path="product_name" />
				</font>
			</p>
			<p>
				상품번호 : <form:input path="product_id" />
				<font color="red">
					<form:errors path="product_id" />
				</font>
			</p>
			<p>
				상품설명 : <form:textarea cols="100px" rows="2px" path="product_desc" />
				<font color="red">
					<form:errors path="product_desc" />
				</font>
			</p>
			<p>
				상품카테고리 : <form:input path="product_cate" />
				<font color="red">
					<form:errors path="product_cate" />
				</font>
			</p>
			<p>
				상품코드 : <form:input path="product_code" />
				<font color="red">
					<form:errors path="product_code" />
				</font>
			</p>
			<form:button name="productadd">등록</form:button>
		</form:form>
	</div>
	</div>
<%@include file="../include/footer.jsp" %>	