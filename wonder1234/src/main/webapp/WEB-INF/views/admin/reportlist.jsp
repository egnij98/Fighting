<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/navbar2.jsp"%> 
<%@include file="../include/header2.jsp" %>
<title>title.</title>


        <h3>신고된 상품 목록</h3>
<div class="content">
		<div class="product">
		<c:forEach var="Board" items="${list}" >
		
        
          	<div class="card">
              	 <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/${Board.ab_img}.jpg" width="80%" >
          
             	 <div class="card-body">
                    <a href="auctiondetail?ab_id=${Board.ab_id}"> ${Board.ab_title} </a>
               	 </div>
             
               	 <div class="card-text">
                     ${Board.ab_id}
               	 </div>
            
           </div>
       

        </c:forEach>
  		</div>
    </div>

<%@include file="../include/footer.jsp" %>	