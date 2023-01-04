<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/navbar2.jsp"%> 
<%@include file="../include/header2.jsp" %>
<title>title.</title>


		<h2>캐쉬충전 신청</h2>
	<div class="content" style="text-align :center">
			<div class="table-responsive">
				  <table class="table">
				  <tr>
				  	<td>회원아이디</td>
				  	<td>이름</td>
				  	<td>신청금액</td>
				  	<td>신청시간</td>
				  
				  </tr>
				<c:forEach var="Member" items="${list}">
					
				 	<tr>
				 	<td>${Member.mem_id}</td>
				 	<td>${Member.mem_name} </a></td>
				 	<td>${Member.mem_amount}</td>
				 	<td>${Member.mem_chargedate}</td>
				 	<td colspan="5" align="center">
						<a href="charge?mem_id=${Member.mem_id}">승인</a>
						<a href="chargedelete?mem_id=${Member.mem_id}">삭제</a>	
					</td>
				 	</tr>
				</c:forEach>
				
				  </table>
				 
				</div>
		
		
		</div>
<%@include file="../include/footer.jsp" %>	