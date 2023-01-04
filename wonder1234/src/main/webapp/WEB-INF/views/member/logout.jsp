<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }" />
    <%@page session="false" %>
 

	
    
<!DOCTYPE html>
<html>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<head>
<meta charset="UTF-8">
<title>로그인 창입니다.</title>
</head>
<body>
	<div style="text-align: center;">
	<form action="loginProc" method="post">
			아이디 : <input type="text" name ="id" placeholder="ID를 입력해주세요"><br>
			비밀번호 : <input type="password" name="password" placeholder="비밀번호를 입력해주세요"><br>
		
		<input type="submit" value="login">
	
	</form>
	<a href ="addMember">회원가입</a>
	
	</div>
	
</body>
 

</html>