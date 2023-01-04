<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../include/header2.jsp" %>
<title>title.</title>
<%@include file="../include/navbar2.jsp"%>


	<div class="content" style="text-align :center">
		<h2>1:1문의 답변</h2>
				<form:form modelAttribute="inquiryDTO" method="post" action="inquiryanswer">
					<p>
						답변제목 : <form:input path="inquiry_title" />
						<font color="red">
							<form:errors path="inquiry_title" />
						</font>
					</p>
					<p>
						답변내용 : <form:textarea cols="100" rows="15" path="inquiry_content" />
						<font color="red">
							<form:errors path="inquiry_content" />
						</font>
					</p>
					<form:hidden path="mem_id" />
				
					
					<form:button name="inquiryanswer" >답변완료</form:button>
				</form:form>
		</div>
	</div>
<%@include file="../include/footer.jsp" %>	