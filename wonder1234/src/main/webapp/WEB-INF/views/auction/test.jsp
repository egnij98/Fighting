
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@include file="../include2/head.jsp"%>
<%@include file="../include2/menu.jsp"%>


 <!-- Main content -->
	 <div class="container">
		  
		  <h2>경매등록</h2>
		  <hr>

	</div>
		  <form action="/auction/auctionaddproduct" method="post">
<!-- enctype : 파일 업로드시 반드시 mutilpart/form-data로 설정해야 한다 -->
	<form method="post" action="${contextPath}/auction/upload" enctype="multipart/form-data">
	<div>
		  	
		  	
		  	<div>
		  	<label>물품 : </label><input type="text" name="ab_title" placeholder="물품명을 입력하세요."/>
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
		<input type="button"  value="파일추가" onClick="fn_addFile()"/><br>
		<!-- 자바 스크립트를 이용해 <div> 태그안에 파일 업로드를 추가 -->
		<div id="d_file">
  		</div>
		<input type="submit"  value="업로드"/>
		
		<div>
			<button type="submit">등록</button>
			</div>
	</form>
   
===========================================================

<div class="container">

           <div class="row" id="loadDataItems"><!-- aJax 데이타 로딩 시작-->
           
				<div class="col-lg-12 col-sm-12 col-md-12">

								  <form name="infoForm" id="infoForm" action="" method="post" enctype="multipart/form-data" onkeydown="return captureReturnKey(event)">

										  <div style="font-size:0.9em;width:100%">
											<div style="width:15%;float:left">물품<!--물품명-->
											</div>
											<div style="width:85%;float:left">
											<div style="float:left;width:100%">
											  <input type="text" id="title_kr" name="title_kr" value="" class="form-control" placeholder="물품명" required="">
											</div>		
											</div>
										  </div>
										  
										  <div class="sp10"></div>
										  <div style="clear:both;font-size:0;height:1px;width:100%;background-color:#eee"></div>
										  <div class="sp10"></div>
										  
										  <div style="font-size:0.9em;width:100%">
											<div style="width:15%;float:left">카테고리<!--카테고리-->
											</div>
											<div style="width:85%;float:left">
											<div style="float:left; width:160px">
											  <select id="category" name="category" class="form-control" required="">
												<option value="">선택하세요</option>
												<option value="1">디지털/가전</option><!--디지털/가전-->
												<option value="2">아웃도어/스포츠</option><!--아웃도어/스포츠-->
												<option value="3">자동차</option><!--자동차-->
												<option value="4">홈/생활</option><!--홈/생활-->
												<option value="5">패션/잡화/뷰티</option><!--패션/잡화/뷰티-->
											  </select>
											</div>
											<div style="width:160px;float:left" id="sub_category">  </div>
											</div>
											<div style="clear:both;font-size:0;height:1px;width:1px"></div>
										  </div>
                                          
										
										
										  <div class="sp10"></div>
										  <div style="clear:both;font-size:0;height:1px;width:100%;background-color:#eee"></div>
										  <div class="sp10"></div>


										  <div style="font-size:0.9em;width:100%">
											<div style="width:15%;float:left">물품정보<!--물품정보-->
											</div>
											<div style="width:85%;float:left">
											  <textarea class="form-control" id="description_kr" name="description_kr" style="min-height:200px" required="" placeholder="하자를 포함하여 물품정보를 상세하게 입력해주시고, 직거래 시 직거래 가능 지역을 물품정보에 입력하세요."></textarea> 
											</div>
											<div style="clear:both;font-size:0;height:1px;width:1px"></div>
										  </div>


										  <div class="sp10"></div>
										  <div style="clear:both;font-size:0;height:1px;width:100%;background-color:#eee"></div>
										  <div class="sp10"></div>



										  <div style="font-size:0.9em;width:100%">
											<div style="width:15%;float:left">희망가<!--희망가-->
											</div>
											<div style="width:140px;float:left">
											  <input type="text" class="form-control" id="estimated_price_high" name="estimated_price_high" placeholder="희망가 (원)" onkeyup="inputNumberFormat(this)" value="" required="">
											</div>
										
											<div style="clear:both;font-size:0;height:1px;width:1px"></div>
										  </div>


										  <div class="sp10"></div>
										  <div style="clear:both;font-size:0;height:1px;width:100%;background-color:#eee"></div>
										  <div class="sp10"></div>


										  <div style="font-size:0.9em;width:100%">
											<div style="width:15%;float:left">시작가<!--시작가-->
											</div>
											<div style="width:140px;float:left">
											  <input type="text" class="form-control" id="price_start" name="price_start" placeholder="시작가 (원)" onkeyup="inputNumberFormat(this)" value="" required="">
											</div>									
											<div style="clear:both;font-size:0;height:1px;width:1px"></div>
										  </div>
										  

										  <div class="sp10"></div>
										  <div style="clear:both;font-size:0;height:1px;width:100%;background-color:#eee"></div>
										  <div class="sp10"></div>


										  <div style="font-size:0.9em;width:100%">
											<div style="width:15%;float:left">호가<!--호가-->
											</div>
											<div style="width:85%;float:left">
											<div style="width:140px;float:left">
											  <input type="text" class="form-control" id="price_unit" name="price_unit" placeholder="호가 (원)" onkeyup="inputNumberFormat(this)" value="" required="">
											</div>
											<div style="width:140px;float:left;margin-top:7px">응찰 시 올리는 금액</div><!--응찰 시 올리는 금액-->	
											</div>
											<div style="clear:both;font-size:0;height:1px;width:1px"></div>
										  </div>


										  <div class="sp10"></div>
										  <div style="clear:both;font-size:0;height:1px;width:100%;background-color:#eee"></div>
										  <div class="sp10"></div>



										  <div style="font-size:0.9em;width:100%">
											<div style="width:15%;float:left">경매종료<!--경매종료-->
											</div>
											<div style="width:85%;float:left">
											  <div style="width:50%;float:left">
											  <select id="duedate_days" name="duedate_days" class="form-control" required="">
												<option value="">선택하세요</option>
												<option value="1">1일 후</option><!--일 후-->
												<option value="2">2일 후</option><!--일 후-->
												<option value="3" selected="">3일 후</option><!--일 후-->
												<option value="4">4일 후</option><!--일 후-->
												<option value="5">5일 후</option><!--일 후-->
												<option value="6">6일 후</option><!--일 후-->
												<option value="7">7일 후</option><!--일 후-->
											  </select>
											  </div>
											  <div style="width:50%;float:left">
											  <select id="duedate_hour" name="duedate_hour" class="form-control" required="">
												<option value="">선택하세요</option>
												<option value="08:59">09:00</option>
												<option value="09:29">09:30</option>
												<option value="09:59">10:00</option>
												<option value="10:29">10:30</option>
												<option value="10:59">11:00</option>
												<option value="11:29">11:30</option>
												<option value="11:59">12:00</option>
												<option value="12:29">12:30</option>
												<option value="12:59">13:00</option>
												<option value="13:29">13:30</option>
												<option value="13:59">14:00</option>
												<option value="14:29">14:30</option>
												<option value="14:59">15:00</option>
												<option value="15:29">15:30</option>
												<option value="15:59">16:00</option>
												<option value="16:29">16:30</option>
												<option value="16:59">17:00</option>
												<option value="17:29">17:30</option>
												<option value="17:59">18:00</option>
												<option value="18:29">18:30</option>
												<option value="18:59">19:00</option>
												<option value="19:29">19:30</option>
												<option value="19:59">20:00</option>
												<option value="20:29">20:30</option>
												<option value="20:59">21:00</option>
												<option value="21:29">21:30</option>
												<option value="21:59">22:00</option>
												<option value="22:29">22:30</option>
												<option value="22:59">23:00</option>
												<option value="23:29">23:30</option>
											  </select>
											  </div>
											</div>
										
											<div style="clear:both;font-size:0;height:1px;width:1px"></div>
										  </div>

										  <div class="sp10"></div>
										  <div style="clear:both;font-size:0;height:1px;width:100%;background-color:#eee"></div>
										  <div class="sp10"></div>


										  <div style="font-size:0.9em;width:100%">
											<div style="width:15%;float:left">자동연장<!--자동연장-->
											</div>
											<div style="width:85%;float:left">
                                              <input type="checkbox" id="extend" name="extend" value="Y" checked="">  응찰이 없으면 설정한 기간만큼 자동으로 연장됩니다.											</div>
										
											<div style="clear:both;font-size:0;height:1px;width:1px"></div>
										  </div>										  
										  
										  
										  <input type="hidden" id="original" name="original" value="Y">






									  <div class="clearfix"></div>
								  <hr>
									<div class="sp1"></div>
									<div style="width:100%;">*사진업로드와 변환에 잠깐 시간이 걸립니다.<br>&nbsp;&nbsp;등록버튼 클릭후 잠시만 기다려주세요.</div>
									<div class="sp10"></div>
								  <div align="center">
									<button type="submit" style="background-color:#000000;border-radius:0;border-color:#000000;padding:5px;color:#FFFFFF;font-size:1.0em;cursor:pointer">경매등록</button><!--경매등록-->
								  </div>

								  <div class="clearfix"></div>



								</form>		
			
			
			
			

			   </div><!---   --->
			
			
			
			<div class="sp20"></div>
		
		
		  </div> <!-- row -->
		</div>









   
   
   
	<%@include file="../include2/footer.jsp"%>