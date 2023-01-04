<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta charset="UTF-8">
<%@include file="../include/navbar2.jsp"%> 
<%@include file="../include/header2.jsp" %>
<title>title.</title>


		<h2>1:1문의목록</h2>
	<div class="content" style="text-align :center">
		 <table class="table">
				<c:forEach var="Inquiry" items="${list}">
					
				  <tr>
				  	<td>문의제목</td>
				  	<td><a href="inquirydetail?inquiry_id=${Inquiry.inquiry_id}">${Inquiry.inquiry_title}</a></td>
				  	<td>문의번호</td>
		 		 	<td>${Inquiry.inquiry_id}</td>
				 
				  	<td>ID</td>
				 	<td> ${Inquiry.mem_id}</td> 	
				 
				  	<td>이름</td>
		 		 	<td>${Inquiry.mem_name}</td>
				  
				  	<td>문의내용</td>
		 		 	<td>${Inquiry.inquiry_content}</td>
				  
				  	<td>문의날짜</td>
		 		 	<td>${Inquiry.inquiry_date}</td>
				  </tr>
				 
				</c:forEach>
				
		 </table>
			

		
		
		</div>
	</div>
<%@include file="../include/footer.jsp" %>	