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
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/app/images/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.grid.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/controls/slick.pager.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/css/smoothness/jquery-ui-1.11.3.custom.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/slickGrid.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick-default-theme.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/brands.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/solid.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/themify-icons.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/cs-skin-elastic.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/chosen.css" type="text/css">
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/main.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/message.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/sweetalert.min.js"></script>
<spring:eval var="sessionContent" expression="@sessionContent" />
<c:if test="${sessionContent.category == 'CO'}">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/style_overwrite_co.css" type="text/css">
</c:if>
<c:if test="${sessionContent.category == 'PO'}">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/style_overwrite_po.css" type="text/css">
</c:if>
</head>
<body>

    <aside id="left-panel" class="left-panel" >
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-bars"></i>
                </button>
                <c:if test="${sessionContent.category == 'PO'}">
                	<span class="navbar-brand" >パターンオーダー</span>
                	<span class="navbar-brand hidden"><span>P</span></span>
                </c:if>
                <c:if test="${sessionContent.category == 'CO'}">
                	<span class="navbar-brand" >カスタムオーダー</span>
                	<span class="navbar-brand hidden"><span>C</span></span>
                </c:if>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <tiles:insertAttribute name="menu" />
            </div>
        </nav>
    </aside>

    <div id="right-panel" class="right-panel" >
        <header id="header" class="header">

            <div class="header-menu">

                <div class="col-sm-7">
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fas fa-tasks"></i></a>
                    <div class="header-left">
                        ${sessionContent.userId}【${sessionContent.belongName}】
                    </div>
                </div>

                <div class="col-sm-5">
                    <div class="user-area float-right">
                    	<form id="logoutForm" action="${pageContext.request.contextPath}/logout" method="post">
                        	<a href="javascript:logoutSubmit()" style="color:black"><i class="fas fa-power-off"></i> ログアウト</a>
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
        
        var contextPath = $("meta[name='contextPath']").attr("content");
        /**
         * 無効なセッション.
         */
        jQuery.ajaxSetup({
        	contentType:"application/x-www-form-urlencoded;charset=utf-8",
        	complete:function(xhr,textStatus){
        		// Ajax 無効なセッション
        		if(xhr.responseText == 'invalidSession'){

        			swal({
        				text: getMsg('msg125'),
        				icon: "info"
        			}).then(function(val){
        				window.location.href= contextPath + "/user/login";
        			});

        		}
        	}
        });

	</script>
</body>
</html>