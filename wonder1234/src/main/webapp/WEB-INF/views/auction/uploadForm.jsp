<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%  request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>WONDER</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	// 파일 업로드 name 값을 각각 다르게 하는 변수
	var cnt = 1;
	
	// 파일 추가를 클릭시 동적으로 파일 업로드를 추가할 것이라는 것
	// name 속성의 값으로 'file'+cnt 를 설정함으로써 값을 다르게 해준다
	function fn_addFile() {
		$("#d_file").append("<br>"+"<input  type='file' name='file"+cnt+"' />");
		cnt++;
	}
</script>

</head>
<body>
	<h1>파일 업로드 하기</h1>
	
	<!-- enctype : 파일 업로드시 반드시 mutilp
	 ]]] art/form-data로 설정해야 한다 -->
	<form method="post" action="${contextPath}/auction/upload" enctype="multipart/form-data">
	<div>

		  	<div>
		  	<label>제목 : </label><input type="text" name="ab_title" placeholder="제목을 입력하세요."/>
		  	</div>
		  	
		  	<div>
		  	<label>카테고리 : </label><input type="text" name="ab_category" placeholder="카테고리를 입력하세요."/>
		  	</div>
		  	
		  	<div>
		  	<label>경매 기간 : </label><input type="text" name="ab_limit" placeholder="경매기간을 입력하세요."/>
		  	</div>			  			
		  	
		  	<div>
		  	<label>시작 가격 : </label><input type="text" name="ab_startprice" placeholder="시작 가격을 입력하세요."/>
		  	</div>		
		  	
		  	<div>
		  	<label>최소 입찰가 : </label><input type="text" name="ab_minimumprice" placeholder="최소 입찰가를 입력하세요."/>
		  	</div>
		  	
		  	<div>
		  	<label>호가 : </label><input type="number" name="ab_pricerise" placeholder="호가를 입력하세요."/>
		  	</div>
		  	
		  	<div>
		  	<label>즉시 입찰가 : </label><input type="text" name="ab_endprice" placeholder="즉시 입찰가를 입력하세요."/>
		  	</div>		  			  	  	
		  	
		  	<div>
		  	<label>내용 : </label><textarea name="ab_content" placeholder="상세한 내용을 입력하세요."></textarea>
		  	</div>		  	
			</div>
		
		<input type="button"  value="파일추가" onclick="fn_addFile()"/><br>
		<!-- 자바 스크립트를 이용해 <div> 태그안에 파일 업로드를 추가 -->
		<div id="d_file">
  		</div>
		<input type="submit"  value="업로드"/>
		
		<div>
			<button type="submit">등록</button>
			</div>
	</form>
</body>
</html>