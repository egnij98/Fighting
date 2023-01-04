<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
 <h1>변경하실 비밀번호를 입력해주세요/.</h1>
<form role="form" method="post" action="pwupdate">
		<div class="box-body">
			<div class="form-group">
				<label></label> <input type="hidden" readonly
					name="mem_id" id="mem_id" class="form-control"  value="${mem_id}">
				<label>변경할 비밀번호:</label> <input type="password"
					name="mem_password" id="mem_password" class="form-control"  value="${mem_password}">
			</div>
				
   <button type="submit" >수정완료</button> <button type="reset">다시 입력</button>
	</div>
	</form>
</body>
</html>