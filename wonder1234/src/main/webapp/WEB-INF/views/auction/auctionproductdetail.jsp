
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@include file="../include2/head.jsp"%>
<%@include file="../include2/menu.jsp"%>

<main id="content" class="content" role="main">
	<div class="container">
		<div class="row justify-content-center" id="loadDataItems">


			<div class="detailleft">

				<img class="detailleft" alt="사진없음"
					src="${contextpath }/resources/img/에어조던1.jpg">
			</div>


			<div class="detailright">


				<div class="sp10"></div>
				<div
					style="border: 0; width: 100%; height: 1px; padding: 0; clear: both; background-color: #eee"></div>
				<div class="sp10"></div>
				<div style="font-size: 1.4em;">
					<span style="color: #000000">${auctionproductdetail.ab_title}</span><span
						style="float: right; margin-right: 20px" align="right"
						id="wishStatus_100"></span>
				</div>
				<div class="sp10"></div>
				<div
					style="border: 0; width: 100%; height: 1px; padding: 0; clear: both; background-color: #eee"></div>
				<div class="sp10"></div>
				<div style="font-size: 1.2em; color: #4f555b; line-height: 20px">
					<div style="float: left; width: 25%;">
						<span class="card-text color_grey1">희망가</span>
					</div>
					<div style="float: left; width: 75%;">${auctionproductdetail.ab_endprice}원</div>
					<div class="sp10"></div>
					<div style="float: left; width: 25%;">
						<span class="card-text color_grey1">시작가</span>
					</div>
					<div style="float: left; width: 75%;">${auctionproductdetail.ab_startprice}원</div>
					<div class="sp10"></div>
					<div style="float: left; width: 25%;">
						<span class="card-text color_grey1">현재가</span>
					</div>
					<div id="currentprice" name="currentprice" style="float: left; width: 75%;">${auctionproductdetail.ab_currentprice}원</div>
					<div class="sp10"></div>

					<div class="sp5"></div>
				</div>
				<!-- 카운트다운 -->
				<div
					style="float: left; width: 25%; font-size: 1.3em; color: #4f555b;">남은시간</div>
				<!-- 남은시간 -->
				<div
					style="float: left; width: 75%; font-size: 1.3em; color: #4f555b;">
					<div id="getting-started" class="getting-started"
						style="font-size: 0.9em; color: #21B6C8">01일 14시간 55분 57초</div>
				</div>

				<div style="clear: both; font-size: 0; height: 10px; width: 1px"></div>
				<div style="float: left; width: 25%;">응찰</div>
				<!-- 응찰 -->
				<div style="float: left; width: 75%;">0 건</div>
				<div class="sp5"></div>

				<div style="float: left; width: 25%;">보유 캐시</div>
				<!-- 보유캐시 -->
				<div id="mem_cash" name="mem_cash" style="float: left; width: 75%;">${user.mem_cash}원</div>
				<div class="sp5"></div>

				<div style="float: left; width: 25%;">호가(증액)</div>
				<!-- 호가(증가액) -->
				<div style="float: left; width: 75%;">${auctionproductdetail.ab_pricerise}원
				</div>
				<div class="sp5"></div>
				<div style="float: left; width: 25%;">응찰가격</div>
				<!-- 응찰가격 -->
				<div style="float: left; width: 75%;">
					<span style="float: left"><input type="button" class="minus"
						data-id="0" value="-"
						style="background-color: #FFFFFF; border: 1px solid #d6c9cc; width: 33px; height: 33px"></span>
					<span style="float: left"><input type="text"
						id="ab_pricerise" name="$ab_pricerise"
						value="${auctionproductdetail.ab_pricerise}" readonly></span> <span
						style="float: left"><input type="button" class="plus"
						data-id="0" value="+"
						style="background-color: #FFFFFF; border: 1px solid #d6c9cc; width: 33px; height: 33px"></span>
				</div>
				<div class="sp5"></div>
				<div style="width: 100%;">

						<button type="button" onclick="productbid();"
							style="border: 0; background-color: #21b6c8; padding-top: 10px; padding-bottom: 10px; width: 100%; font-size: 15px; color: #FFFFFF; margin-top: 7px; cursor: pointer; border-radius: 8px">응찰</button>
						<!-- 로그인 후 응찰-->
					 <input type="hidden" id="steps" value="0">
				</div>

				<div class="sp10"></div>
				<!--경매철회 안내-->
				<div
					style="width: 98%; background-color: #dfdfdf; padding: 5px; font-size: 1.0em; line-height: 30px">
					회원님이 응찰한 가격이 낙찰금액으로 결정될 수 있습니다.<br>응찰은 취소할 수 없습니다. 신중하게
					응찰해주세요.<br>판매자의 사정으로 경매가 철회될 수 있습니다.<br>경매가 종료되면 낙찰자와
					판매자에게 전화번호가 공개됩니다.<br>희망가와 같거나 높은 금액으로 응찰하면 즉시 낙찰됩니다.
				</div>
				<div class="clearfix"></div>

			</div>



		</div>
		<br>
		<div class="sp10"></div>
		<!--경매철회 안내-->
		<div
			style="width: 98%; background-color: #ebebeb; padding: 5px; font-size: 1.0em; line-height: 30px">여기는
			경매 컨테츠(내용)</div>
		<div class="clearfix"></div>

	</div>


	<div class="box-footer">
		<button class="btn btn-success">메인</button>
		<c:if test="${user eq auctionproductdetail.mem_id}">
			<button class="btn btn-warning">수정</button>
			<button class="btn btn-danger">삭제</button>
		</c:if>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	
	<script type="text/javascript">
		function productbid() {
			console.log("ddd");
			var cash  =    <%=(String)session.getAttribute("user")%>     
			console.log(cash);
			var currentprice  = document.getElementById('ab_currentprice').value;
			if (cash < currentprice) {
				alert("보유 캐시가 입찰가 보다 낮습니다.");
				return false;
			}else {
				alert("입찰되었습니다.");
				return true;
			}
		}
		
	</script>

	<script>
    $(document).ready(function(){
    	
    	var formObj = $("form[role='form']");
    	
    	console.log(formObj);
    	//목록 버튼을 눌렀을 때 처리
	    $(".goListBtn").on("click", function(){
	    	formObj.attr("method","get");
	    	formObj.attr("action","auctionlist");
	    	formObj.submit();
	    });
	  //메인 버튼을 눌렀을 때 처리
		$(".btn-success").click(function(){
			location.href="auctionlist";
		});
	
		//삭제 버튼을 눌렀을 때 처리
		$(".btn-danger").click(function(){
			location.href="auctionproductdelete?ab_id=" + ${auctionproductdetail.ab_id};
		});
		//수정 버튼을 눌렀을 때 처리
		$(".btn-warning").click(function(){
			location.href="auctionproductupdate?ab_id=" + ${auctionproductdetail.ab_id};
		});
		//댓글작성 버튼을 눌렀을 때 처리
		$(".btn-info").click(function() {
			location.href = "reply?ab_id=" + ${auctionproductdetail.ab_id};
		});
    });

	</script>

</main>

<%@include file="../include2/footer.jsp"%>