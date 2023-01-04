<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../include/header2.jsp" %>
<title>title.</title>
<%@include file="../include/navbar2.jsp"%> 
<style>
.form-select {
  display: block;
  width: 100%;
  text-align:center;
  position:relative;
  margin-top:10px;
  margin-left:15%;
  margin-bottom:20px;
  
}

</style>

	<div class="content" style="text-align :center">
		
			<h2>공지사항등록</h2>
	
		<form:form modelAttribute="AdminNoticeDTO" method="post" action="noticeadd">
			<form:label path="notice_sort">
			
    		<form:select class="form-select" items="${sortList}" path="notice_sort" />
    		
			</form:label>
			<p>
				제목 : <form:textarea cols="100px" rows="1px" path="notice_title" />
				<font color="red">
					<form:errors path="notice_title" />
				</font>
			</p>
			<p>
				내용 : <form:textarea cols="100px" rows="15px" placeholder="내용을 입력하세요" path="notice_content" />
				<font color="red">
					<form:errors path="notice_content" />
				</font>
			</p>
			
	<form:button name="noticetadd">등록</form:button>
</form:form>
	</div>
<%@include file="../include/footer.jsp" %>	