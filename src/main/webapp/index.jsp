<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html ng-app="flashApp">

<head>
    <title>FLASH</title>    

    <!-- Bootstrap -->
    <link rel="stylesheet" href="components/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container-fluid">
        <div class="row" style="margin-top: 25px;">
            <div class="col-md-8 col-md-offset-2">
                <a href="http://www.simoncomputing.com">
                    <img width="220px" src="http://www.simoncomputing.com/main/img/SC-Brand-mobile.png">
                </a>
                <br>
                <uib-tabset active="active">
                    <uib-tab index="0" heading="Home" ui-sref="home"></uib-tab>
                    <uib-tab index="1" heading="Users" ui-sref="users"></uib-tab>
                </uib-tabset>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div ui-view></div>    
            </div>
        </div>
    </div>
    

    <!-- Vendor scripts -->
    <script src="components/lib/angular/angular.js"></script>
    <script src="components/lib/angular-ui-router/angular-ui-router.js"></script>
    <script src="components/lib/ui-bootstrap/ui-bootstrap-tpls-2.0.0.min.js"></script>

    <!-- Application scripts -->
    <script src="app.js"></script>
    <script src="app.routes.js"></script>
    <script src="modules/home/home.module.js"></script>
    <script src="modules/home/home.controller.js"></script>
</body>

</html>