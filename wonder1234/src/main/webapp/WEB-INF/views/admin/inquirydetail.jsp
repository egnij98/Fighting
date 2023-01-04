<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta charset="UTF-8">
<%@include file="../include/header2.jsp" %>
<title>title.</title>
<%@include file="../include/navbar2.jsp"%> 


	<div class="content" style="text-align :center">
		<h2>1:1문의 상세</h2>
		
		 <form:form modelAttribute="inquiryDTO" method="get" action="inquiryanswer">
			
				<div class="table-responsive">
				  <table class="table" style="text-align:center">
				  <tr>
				  	<td>문의제목</td>
				  	<td>문의번호</td>
				  	<td>ID</td>
				  	<td>이름</td>
				  	<td>내용</td>
				  	<td>날짜</td>
				  	
				  </tr>
				
					
				 	<tr>
				 	<td>${inquiryDTO.inquiry_title}</td>
				 	<td>${inquiryDTO.inquiry_id}</td>
				 	<td>${inquiryDTO.mem_id}</td>
				 	<td>${inquiryDTO.mem_name}</td>
				 	<td>${inquiryDTO.inquiry_content}</td>
				 	<td>${inquiryDTO.inquiry_date}</td>
				 	</tr>
				   </table>
					
							
				 
				</div>
				<form:hidden path="inquiry_id" />
				<form:hidden path="mem_id" />
				<form:button name="inquiryanswer" >답변</form:button>
				
				<button type="reset" onclick="location.href='inquiry'">취소</button>
			</form:form>
		
		
		
		
		</div>
	</div>
<%@include file="../include/footer.jsp" %>	