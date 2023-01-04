<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../include/header2.jsp" %>
<title>상세보기</title>
<%@include file="../include/navbar2.jsp"%> 
	<div class="content" style="text-align :center">
		<form:form modelAttribute="AdminProductDTO" method="get" action="productedit">
			
				<div class="table-responsive">
				  <table class="table">
				  <tr>
				  	<td>상품번호</td>
				  	<td>상품명</td>
				  	<td>상품설명</td>
				  	<td>상품카테고리</td>
				  	<td>상품코드</td>
				  </tr>
				
					
				 	<tr>
				 	<td>${AdminProductDTO.product_id}</td>
				 	<td>${AdminProductDTO.product_name}</td>
				 	<td>${AdminProductDTO.product_desc}</td>
				 	<td>${AdminProductDTO.product_cate}</td>
				 	<td>${AdminProductDTO.product_code}</td>
				 	</tr>
				   </table>
					<tr>
					<td colspan="5" align="center">
						<a href="productedit?product_id=${AdminProductDTO.product_id}">수정 </a>
						<a href="productdelete?product_id=${AdminProductDTO.product_id}">삭제</a>	
					</td>
				</tr>
			</div>
				</form:form>
				 
	</div>
		


<%@include file="../include/footer.jsp" %>	