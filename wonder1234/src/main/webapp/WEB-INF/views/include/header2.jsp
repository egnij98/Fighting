<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Header-->
 <div id="right-panel" class="right-panel">
        <header id="header" class="header">
            <div class="top-left">
                <div class="navbar-header">
                    <a class="navbar-brand" href="adminhome"><img src="${pageContext.request.contextPath}/resources/images/wonder.png" alt="Logo"></a>         
                   	<a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
               	</div>
              
            </div>
            <div class="top-right">
                <div class="header-menu">
                    <div class="header-left">
                        <button class="search-trigger"><i class="fa fa-search"></i></button>
                        <div class="form-inline">
                            <form class="search-form">
                                <input class="form-control mr-sm-2" type="text" placeholder="Search ..." aria-label="Search">
                                <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                            </form>
                        </div>

              

                        
                    </div>
                  
                            <a class="nav-link" href="#">Logout</a>
             
                 

                </div>
            </div>
        </header>
   