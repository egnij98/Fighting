<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../include/navbar2.jsp"%>
<%@include file="../include/header2.jsp" %>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<script>
		
$(document).ready(function(){
		console.log('ajax test ready~~');
		//댓글 목록 불러오기
        Noticelist();
		
});
function Noticelist(){
	var url ="${pageContext.request.contextPath}/admin/sortlist";
	var paramData = {
			"notice_sort" : $('#list option:selected').val()
			
	};

	
	$.ajax({
		
		url : url,
		data : paramData,
		dataType : 'json',
		type : 'POST',
		success : function(result){
			
			var htmls = ""; //문서꾸미기
			if(result.length < 1){
				htmls += '<h3>공지사항이 없습니다.</h3>';
			}
			else{
				$(result).each(function(){
						
					   htmls = htmls + '<div class="" id="notice_id' +this.notice_id + '">';
                       //<div id="reno12"> <div id="reno13">
				       htmls += '<span class="d-block">';
				       htmls += '공지번호:';
				       htmls += this.notice_id
				       htmls += ',';
				       htmls += this.notice_sort + ' - ';
				       htmls += '<strong class="text-gray-dark">'+'제목:' + this.notice_title +'-'+ '</strong>';
				       htmls += '내용:';
				       htmls += this.notice_content;
				       htmls += '<span style="padding-left: 7px; font-size: 9pt">';
				       htmls += '<a href="javascript:void(0)" onclick="fn_noticeEdit(' + this.notice_id + ', \'' + this.notice_title + '\', \'' + this.notice_content + '\' )" style="padding-right:5px">수정</a>';
				       htmls += '<a href="javascript:void(0)" onclick="fn_noticeDelete(' + this.notice_id + ')" >삭제</a>';
				       htmls += '</span>';
				       htmls += '</span>';
				       htmls += '</p>';
				       htmls += '</div>';   
				       htmls += '</div>'; 
				});
			}
			
			$("#sortlist").html(htmls); //댓글위치에 html로 보여주기
		},
		error : function(result){
			alert('실패');
		}
		
	});
	} //end noticelist()
function fn_noticeDelete(notice_id){
		var url ="${pageContext.request.contextPath }/noticedelete";
		var paramData = {
				"notice_id" : notice_id,
				
		};
			$.ajax({
				url : url,
				data : paramData,
				dataType :'json',
				type : 'POST',
				success : function(result){
					alert('삭제됐습니다.');
					Noticelist();
				},
				error : function(result){
					alert('실패');
				}	
			});
			
	} //end noticedelete
	
function fn_noticeEdit(notice_id,notice_title,notice_content){
		
		
		var htmls = "";
		   htmls = htmls + '<div class="" id="notice_id' +notice_id + '">';
	       htmls += '<span class="d-block">';
	       htmls += '공지번호:';
	       htmls += notice_id + ' - ';
	      
	       htmls += '<span style="padding-left: 7px; font-size: 9pt">';
	       htmls += '<a href="javascript:void(0)" onclick="fn_noticeupdate(' + notice_id + ', \'' + notice_title + '\', \'' + notice_content + '\' )" style="padding-right:5px">수정완료</a>';
	       htmls += '<a href="javascript:void(0)" onclick="Noticelist()" >취소</a>';
	       htmls += '</span>';
	       htmls += '</span><br>';
	       htmls += '제목:';
	       htmls += '<input type="text" id="edittitle" name = "edittitle" rows ="3" placeholder="'+notice_title+'\">';
	     
	       htmls += '</input>';
	       htmls += '내용:';
	       htmls += '<input type="text" id="editcontent" name = "editcontent" rows ="3" placeholder="'+notice_content+'\">';
	     
	       htmls += '</input>';
	       htmls += '</p>';
	       htmls += '</div>'; 
		   
		   // 선택한 요소를 다른것으로 바꿉니다.(변경)
		   $('#notice_id'+notice_id).replaceWith(htmls);
		   $('#notice_title'+notice_title+'#edittitle').focus();
		   $('#notice_content'+notice_content+'#editcontent').focus();
	
}

function fn_noticeupdate(notice_id,notice_title,notice_content){
		var editcontent = $('#editcontent').val();
		var edittitle = $('#edittitle').val();
		var url ="${pageContext.request.contextPath }/noticeedit";
		var paramData = {
			"notice_id" : notice_id,
			"notice_title" : edittitle,
			"notice_content" : editcontent
			
		};
			$.ajax({
			url : url,
			data : paramData,
			dataType :'json',
			type : 'POST',
			success : function(result){
				console.log(result);
				alert('수정완료');
				Noticelist();
			},
			error : function(result){
				console.log(result);
				alert('에러가 발생했습니다.');
			}
			
			});	

}
	
	
</script>
<title>title.</title>
 
<style>
.form-select {
  display: block;
  width: 100%;
  text-align:center;
  position:relative;
  margin-top:10px;
  margin-left:15%;
  margin-bottom:20px;
  
}

</style>


		<h2>공지사항목록</h2>
<div class="content" style="text-align :center">
	
			<form:label path="list">
	    		<form:select class="form-select" item= "${list}" path="list" id ="list" onchange= "Noticelist()">
	    				<c:forEach begin="0" end="2" var="Notice" items="${list}">
						  
					 		<option value="${Notice.notice_sort}">${Notice.notice_sort}</option>
					 		
						</c:forEach>
	    	
	
				</form:select>
			</form:label>
	<hr><p></p>
	<div id="sortlist"></div>

<%@include file="../include/footer.jsp" %>	