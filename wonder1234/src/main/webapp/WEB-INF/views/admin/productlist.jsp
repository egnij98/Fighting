<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>title.</title>
<%@include file="../include/navbar2.jsp"%> 
<%@include file="../include/header2.jsp" %>

        <h3>상품목록</h3>
	<div class="content">
		<div class="product">
		<c:forEach var="Product" items="${list}" >
		
        
          	<div class="card">
              	 <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/${Product.product_img}" width="80%" >
          
             	 <div class="card-body">
                    <a href="productdetail?product_id=${Product.product_id}"> ${Product.product_name} </a>
               	 </div>
             
               	 <div class="card-text">
                    ${Product.product_id}
               	 </div>
            
           </div>
       

        </c:forEach>
  		</div>
    </div>
<%@include file="../include/footer.jsp" %>	