<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta charset="UTF-8">
<%@include file="../include/navbar2.jsp"%> 
<%@include file="../include/header2.jsp" %>
<title>title.</title>


		<h2>회원목록</h2>
<div class="content" style="text-align :center">
		 
		 
				<div class="table-responsive">
				  <table class="table">
				  <tr>
				  	<td>회원아이디</td>
				  	<td>이름</td>
				  	<td>회원닉네임</td>
				  	<td>회원등급</td>
				  
				  </tr>
				<c:forEach var="Member" items="${list}">
					
				 	<tr>
				 	<td>${Member.mem_id}</td>
				 	<td><a href="memdetail?mem_id=${Member.mem_id}"> ${Member.mem_name} </a></td>
				 	<td>${Member.mem_nickname}</td>
				 	<c:if test="${Member.mem_rating == 99}"><td>관리자</td></c:if>
				 	<c:if test="${Member.mem_rating == 1}"><td>회원</td></c:if>
				 	<c:if test="${Member.mem_rating == 2}"><td>판매자</td></c:if>
				 	<c:if test="${Member.mem_rating == 5}"><td>정지회원</td></c:if>
				 
				 	</tr>
				</c:forEach>
				
				  </table>
				 
				</div>
   
	</div>
	
<%@include file="../include/footer.jsp" %>	