<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WONDER</title>
</head>
<body>
    댓글 목록 <br>
  <table class="table">
	<form>
	<div class="form-group1">
	<c:forEach var="boardReply" items="${list}">
		<tr>
			<td>작성자 : ${boardReply.rewriter}    작성일자 : ${boardReply.redate} </td>
		</tr>
		<tr>
			<td><textarea name="rememo" rows="5" cols="40"
				readonly="readonly" class="form-control1">${boardReply.rememo}</textarea>
			</td>
			<td><a href="replyupdate?reno=${boardReply.reno}">댓글수정</a>
			<td><a href="replydelete?reno=${boardReply.reno}">댓글삭제</a>
			<script>
			
			$(function(){
				//댓글수정 버튼을 눌렀을 때 처리
				$(".btn-defalut").click(function(){
					location.href="replyupdate?reno=" + ${boardReply.reno}; 
				});
			})		
			</script>
			</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>