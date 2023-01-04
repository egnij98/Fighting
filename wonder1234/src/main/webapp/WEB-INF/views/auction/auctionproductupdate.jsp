<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WONDER</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<body>
	<div class="content-wrapper">

		<!-- Main content -->
		<section class="content container-fluid">
			<div class="box-header">
				<h3 class="box-title">상품 수정</h3>
			</div>
			<form  method="post" action="auctionproductupdate">
				<div class="box-body">
					<div class="form-group">
						<label>번호</label> <input type="text" name="ab_id"
							class="form-control" value="${auctionproductdetail.ab_id}" readonly />
					</div>
					<div class="form-group">
						<label>제목</label> <input type="text" name="ab_title"
							class="form-control" value="${auctionproductdetail.ab_title}" />
					</div>

					<div class="form-group">
						<label>카테고리</label> <input type="text" name="ab_category"
							class="form-control" value="${auctionproductdetail.ab_category}" />
					</div>


					<div class="form-group">
						<label>경매 기간</label> <input type="text" name="ab_limit"
							class="form-control" value="${auctionproductdetail.ab_limit}" />
					</div>

					<div class="form-group">
						<label>시작 가격</label> <input type="text" name="ab_startprice"
							class="form-control"
							value="${auctionproductdetail.ab_startprice}" />
					</div>

					<div class="form-group">
						<label>최소 입찰가</label> <input type="text" name="ab_minimumprice"
							class="form-control"
							value="${auctionproductdetail.ab_minimumprice}" />
					</div>

					<div class="form-group">
						<label>즉시 입찰가</label> <input type="text" name="ab_endprice"
							class="form-control" value="${auctionproductdetail.ab_endprice}" />
					</div>

					<div class="form-group">
						<label>내용</label>
						<textarea name="ab_content" rows="5" class="form-control">${auctionproductdetail.ab_content}</textarea>
					</div>

					<!-- <div class="form-group">
					<label>작성자</label> <input type="text" name="ab_id"
						class="form-control" value="${wonder.mem_id}" readonly="readonly" />
				</div>
				 -->
				</div>
				<!-- 수정에 사용할 글번호 -->
				
				<div class="box-footer">
					<input type="submit" value="수정완료"/>
				</div>
			</form>
	</section>
	</div>


	<!-- /.content -->
	

</body>
</html>