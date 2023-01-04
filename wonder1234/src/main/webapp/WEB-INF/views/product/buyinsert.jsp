<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../include2/head.jsp" %>
<link rel="stylesheet" type="text/css" href="${contextpath}/resources/css/styles.css"/>
<script>
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}
</script>

<div class="site-wrapper">

	<%@ include file = "../include2/menu.jsp" %>
	
	<header class="main-header post-head " style="background-image: url(resources/img/jo.png)">
	<div class="vertical">
		<div class="main-header-content inner">
			<h1 class="post-title">언제나 어디서나 에센셜</h1>
			<div class="entry-title-divider">
				<span></span><span></span><span></span>
			</div>
		</div>
	</div>
	</header>
	<main id="content" class="content" role="main">
<div class="container">
		<form action="${contextpath }/product/saleinsert" method="post" accept-charset="utf-8">
		<c:set value="${product}" var="dto"/>
						<c:set var="ran"><%= java.lang.Math.round(java.lang.Math.random() * 999999) %></c:set>
							<input type="hidden" value="${dto.product_id*ran}" name="product_id">
							<input type="hidden" value="${dto.product_name}" name="product_name">
							<input type="hidden" value="${size }" name="product_size">
							<input type="hidden" value="${dto.product_auction }" name="product_auction">
							<input type="hidden" value="${dto.product_cate }" name="product_cate">
							<input type="hidden" value="${dto.product_hits }" name="product_hits">
							<input type="hidden" value="${dto.product_img }" name="img">
							${dto.product_name}
		<c:set value="2500" var="del_fee"/>
		<div class="row qnas" style="text-align: center;">
			<h1 class="page-header">구매하기</h1>
			<table class="table table-hover" style="width: 70%; margin: auto; border-bottom: 1px solid #D5D5D5;">
				<thead>
					<tr>
						<th>상품</th>
						<th>상품명</th>
						<th>사이즈</th>
						<th>수량</th>
					</tr>
				</thead>
				<tbody>
						<tr>
							<td><img alt="사진미출력" src="../resources/img/${dto.product_img }" width="40%">
							<input type="hidden" value="Deliverypreparation" name="order_status">
							</td>
							<td>${dto.product_name}</td>
							<td>${size }</td>
							<td>1개</td>
		

						</tr>			
				</tbody>
			</table>
		</div>
			<table>
				<tr>
					<c:choose>
					    <c:when test="${price eq '구매입찰' }">
					    <th> <input type="radio" name="radio" id="r1" value="1" checked><label for="r1">구매입찰</label>
					    </c:when>
					    <c:otherwise>
							<th> <input type="radio" name="radio" id="r1" value="1" ><label for="r1">구매입찰</label>
							<th> <input type="radio" name="radio" id="r2" value="0" checked><label for="r2" >즉시구매</label>
					    </c:otherwise>
					</c:choose>
				</tr>
				
				<tr>
				<c:choose>
					    <c:when test="${price eq '구매입찰' }">
					    <th><input type="text"name="product_price" id="price">원</th>
					    </c:when>
					    <c:otherwise>
					    	<th><input type="text"name="product_price" id="price">원</th>
							<th>${price}원</th>
					    </c:otherwise>
					</c:choose>
					
				</tr>
			</table>
			<script type="text/javascript">
			$(document).ready(function(){
			  $("input:radio[name=radio]").click(function(){
			    if($("input[name=radio]:checked").val() == "1"){
			      $("input:text[name=product_price]").attr("disabled",false);
			    }else if($("input[name=radio]:checked").val() == "0"){
			      $("input:text[name=product_price]").attr("disabled",true);
			    }
			  });
			});
			</script>
			
			
		
		<div class="row" style="text-align: center; margin: 80px 0;">
		<c:set value="${member}" var="vo"/>
			<h1 class="page-header">구매자정보</h1>
		</div>
		<div class="row">
			<div class="form-horizontal">
				<div class="form-group">
					<label for="inputId" class="col-sm-2 control-label">아이디</label>
					<div class="col-sm-10">
						<input class="form-control" id="inputId" placeholder="ID" name="mem_id" value="${vo.mem_id }" readonly>
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputName" class="col-sm-2 control-label">이름</label>
					<div class="col-sm-10">
						<input class="form-control" id="inputName" placeholder="Name" name="order_name" value="${vo.mem_name}" readonly>
					</div>
				</div>
				<div class="form-group">
					<label for="inputId" class="col-sm-2 control-label">휴대폰번호</label>
					<div class="col-sm-10">
						<input class="form-control" id="inputId" placeholder="ID" name="order_phone" value="${vo.mem_phonenum}" readonly>
					</div>
				</div>					
				<div class="form-group">
					<label for="inputEmail" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail" placeholder="Email" name="order_address" value="${vo.mem_email1}">@
						<input type="text" class="form-control" id="inputEmail" placeholder="Email" name="order_address2" value="${vo.mem_email2}">
					</div>
				</div>
				<div class="form-group">
					<label for="inputAdd" class="col-sm-2 control-label">Address</label>
					<div class="col-sm-10">
						<input type="text" id="sample6_postcode" placeholder="우편번호">
						<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
						<input type="text" id="sample6_address" placeholder="주소"><br>
						<input type="text" id="sample6_detailAddress" placeholder="상세주소">
					</div>
				</div>	
				<div class="form-group">
					<label for="inputTel" class="col-sm-2 control-label"></label>
					<div class="col-sm-10">				
						<select name="Delivery">
							<option value="">배송메세지</option>
						    <option value="">빨리배송해주세요</option>
						    <option value="학생">경비실에 맡겨주세요</option>
						    <option value="회사원">벨 누르지 말아주세요</option>
						    <option value="기타">조심히 배송해주세요</option>
						</select>
					</div>
							
			</div>
		</div><!-- class=row -->
		
		<div class="row" style="text-align: center; margin: 80px 0;">
			
			<div class="row" style="text-align: center; margin: 50px 0;">
				<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
				
				<input type="hidden" id="amount" name="totalAmount">
				</label>
			</div>
			<div>
				<button class="sub" type="submit" id ="sub">구매하기</button>
				<script type="text/javascript">
				$(document).ready(function(){
					  $("#sub").click(function(){
					    if($("input[name=radio]:checked").val() == "1"){
					    var price =	$("input:text[name=product_price]").val();
							
							$.ajax({
							    url: 'saleinsert',
							    type: 'POST',
							    data: {price: price},
							    success: function (data) {
							            alert("구매입찰이 등록되었습니다");
							            location.replace("${contextpath}/wonder/product"); 
							        }
							});

					    }else if($("input[name=radio]:checked").val() == "0"){
					      var price = ${price};
					      	
					      	$.ajax({
							    url: 'saleinsert',
							    type: 'POST',
							    data: {price: price},
							    success: function (data) {
							    		alert("물건을보내주시면 캐쉬가 자동충전됩니다")
							            location.replace("${contextpath}/wonder/product"); 
							        }
							});

					    }
					  });
					});
			</script>
			
			</div>
		</div>
		</form>
		<button class="btn btn-default back_btn"><a href ="${contextpath }/wonder/product/productdetail?product_name=${dto.product_name}&product_cate=${dto.product_cate}">돌아가기</a></button>
	</div>
	</main>
	<div class="clearfix">
	</div>
	<footer class="site-footer clearfix">

	</footer>
</div>

</body>
</html>