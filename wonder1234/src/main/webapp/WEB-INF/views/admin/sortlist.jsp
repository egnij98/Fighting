<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/header2.jsp" %>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>


<div class="content" style="text-align :center"></div>

  <table class="table">
	<c:forEach var="noticelist" items="${list}">
		<tr>
			<td>종류 : ${noticelist.notice_sort} </td>
		</tr>
		<tr>
			<td>제목 : ${noticelist.notice_title} </td>
		</tr>
		<tr>
			<td><textarea name="notice" rows="5" cols="40"
				readonly="readonly" class="form-control1">${noticelist.notice_content}</textarea>
			</td>
			<td><a href="replyupdate?reno=${boardreply.reno}">댓글수정</a>
			
			</td>
			<td><a href="replydelete?reno=${boardreply.reno}">댓글삭제</a>
			
			</td>
			
		</tr>
	</c:forEach>
 </table>
<%@include file="../include/footer.jsp" %>	