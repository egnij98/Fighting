<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../include/header2.jsp" %>
<title>상세보기</title>
<%@include file="../include/navbar2.jsp"%> 
	<div class="content" style="text-align :center">
		<form:form modelAttribute="AdminAuctionDTO" method="get" action="auctiondelete">
			
				<div class="table-responsive">
				  <table class="table">
				  <tr>
				  	<td>경매번호</td>
				  	<td>제목</td>
				  
				  	<td>날짜</td>
				  	<td>종료시간</td>
				  </tr>
				
					
				 	<tr>
				 	<td>${AdminAuctionDTO.ab_id}</td>
				 	<td>${AdminAuctionDTO.ab_title}</td>
				 	<td>${AdminAuctionDTO.ab_date}</td>
				 	<td>${AdminAuctionDTO.ab_limit}</td>
				 	
				 	</tr>
				   </table>
					<tr>
					<td colspan="5" align="center">
					
						<a href="auctiondelete?ab_id=${AdminAuctionDTO.ab_id}">삭제</a>	
					</td>
				</tr>
			</div>
				</form:form>
				 
	</div>
		


<%@include file="../include/footer.jsp" %>	