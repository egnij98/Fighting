<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@include file="../include/header2.jsp" %>
<title>상세보기</title>
<%@include file="../include/navbar2.jsp"%> 
	<div class="content" style="text-align :center">
		<form:form modelAttribute="AdminMemDTO" method="post" action="ratingedit">
			
				<div class="table-responsive">
				  <table class="table">
				  <tr>
				  	<td>회원아이디</td>
				  	<td>이름</td>
				  	<td>닉네임</td>
				  	<td>등급</td>
				  	
				  </tr>
				
					
				 	<tr>
				 	<td>${AdminMemDTO.mem_id}</td>
				 	<form:hidden path="mem_id"></form:hidden>
				 	<td>${AdminMemDTO.mem_name}</td>
				 	<td>${AdminMemDTO.mem_nickname}</td>
				 	<td>
				 	
				 	<select name="mem_rating" id="mem_rating" >
				 		<option value="99" <c:if test="${AdminMemDTO.mem_rating == 99}">selected</c:if>>관리자</option>
				 		<option value="1" <c:if test="${AdminMemDTO.mem_rating == 1}">selected</c:if>>회원</option>
				 		<option value="2" <c:if test="${AdminMemDTO.mem_rating == 2}">selected</c:if>>판매자</option>
				 		<option value="5" <c:if test="${AdminMemDTO.mem_rating == 5}">selected</c:if>>정지회원</option>
				 	</select>
				 	</td>
				 	</tr>
				   </table>
					<tr>
					<td colspan="5" align="center">
						<form:button name="ratingedit" >등급수정</form:button>
					</td>
					</tr>
				 
				</div>
			</form:form>
			
	</div>

<%@include file="../include/footer.jsp" %>	