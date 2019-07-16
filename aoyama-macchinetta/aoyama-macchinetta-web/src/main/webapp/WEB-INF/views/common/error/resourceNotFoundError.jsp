<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="contextPath" content="${pageContext.request.contextPath}" />
<title>リソースエラー</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
    <div id="wrapper">
        <h1>リソースエラー</h1>
        <div class="error">
            <c:if test="${!empty exceptionCode}">[${f:h(exceptionCode)}]</c:if>
            <spring:message code="e.05.fw.5001" />
        </div>
        <t:messagesPanel />
        <br>
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/user/login" ><i class="fa fa-power-off"></i>ログイン</a>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
    </div>
</body>
</html>