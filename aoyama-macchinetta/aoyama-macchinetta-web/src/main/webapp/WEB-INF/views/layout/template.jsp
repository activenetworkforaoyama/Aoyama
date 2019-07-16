<!DOCTYPE html>
<html class="no-js" lang="ja">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="description" content="Sufee Admin - HTML5 Admin Template">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="contextPath" content="${pageContext.request.contextPath}" />
<c:set var="titleKey">
    <tiles:insertAttribute name="title" ignore="true" />
</c:set>
<title><spring:message code="${titleKey}" text="受発注システム" /></title>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/button.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.grid.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/controls/slick.pager.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/css/smoothness/jquery-ui-1.11.3.custom.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/slickGrid.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/controls/slick.columnpicker.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick-default-theme.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
<script src="${pageContext.request.contextPath}/resources/app/js/message.js"></script>

</head>
<body class="bg-dark">
	<div class="sufee-login d-flex align-content-center flex-wrap">
    <div class="container">
        <tiles:insertAttribute name="body" />
    </div>
    </div>
</body>
</html>