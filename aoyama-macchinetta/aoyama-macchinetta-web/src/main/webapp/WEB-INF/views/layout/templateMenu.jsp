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
<sec:csrfMetaTags />
<title><spring:message code="${titleKey}" text="受発注システム" /></title>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/app/images/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/button.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.grid.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/controls/slick.pager.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/css/smoothness/jquery-ui-1.11.3.custom.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/slickGrid.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/controls/slick.columnpicker.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick-default-theme.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/themify-icons.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/flag-icon.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/cs-skin-elastic.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/chosen.css" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
<script src="${pageContext.request.contextPath}/resources/app/js/main.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/message.js"></script>


</head>
<body>

    <aside id="left-panel" class="left-panel" >
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand">受発注システム</a>
                <a class="navbar-brand hidden" href="./"><img src="${pageContext.request.contextPath}/resources/app/images/logo2.png" alt="Logo"></a>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <tiles:insertAttribute name="menu" />
            </div>
        </nav>
    </aside>




    <spring:eval var="sessionContent" expression="@sessionContent" />
    <div id="right-panel" class="right-panel" >


        <header id="header" class="header">

            <div class="header-menu">

                <div class="col-sm-7">
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks"></i></a>
                    <div class="header-left">
                        ${sessionContent.userId}【${sessionContent.belongName}】
                    </div>
                </div>

                <div class="col-sm-5">
                    <div class="user-area float-right">
                    	<form id="logoutForm" action="${pageContext.request.contextPath}/logout" method="post">
                        	<a href="javascript:logoutSubmit()" style="color:black"><i class="fa fa-power-off"></i> ログアウト</a>
                        	<sec:csrfInput />
                        </form>
                    </div>
                </div>
            </div>

        </header>
 
		<tiles:insertAttribute name="body" />

    </div>
	<script>
        function logoutSubmit() {
            document.getElementById("logoutForm").submit();
        }
	</script>
</body>
</html>