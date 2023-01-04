<script>
 
    /* 로그인 버튼 클릭 메서드 */
    
    $(".login_button").click(function(){
        
        alert("로그인 버튼 작동")
        
    });
</script>\






<c:if test ="${user.name == null }">
        <li class="active"><a href="${contextPath}/wonder/login"><i class="fa fa-link"></i> <span>로그인</span></a></li>
        </c:if>
        
        <c:if test="${user.name != null }">
        <li class="active"><a href="${contextPath}/wonder/logout"><i class="fa fa-link"></i> <span>로그아웃</span></a></li>
        </c:if>