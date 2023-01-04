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
경매상품 등록

	<button><a href ="auctionregcomfirm"> 등록 </a></button>
	 <section class="content container-fluid">
    	<div id="divtest">
    		<input type="button" id="test" name="test" onclick="testajax();" value="ajax Btn">
    	
    	</div>
    
		<div class="box-header">
			<h3 class="box-title">게시판 글쓰기</h3>
		</div>
	
		<form role="form" name="f" method="post" onsubmit="return validate();">
			<div class="box-body">
				<div class="form-group">
					<label>제목</label> <input type="text"
						name='title' id="title" class="form-control" placeholder="제목을 입력하세요">
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea class="form-control" name="content" rows="3"
						placeholder="내용을 입력하세요"></textarea>
				</div>
	
				<div class="form-group">
					<label>작성자</label> <input type="text" name="id" class="form-control"  
						value="${user.name }" readonly>
				</div>
			</div>
	
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">작성완료</button>
			</div>
		</form>
    </section>

</body>
</html>