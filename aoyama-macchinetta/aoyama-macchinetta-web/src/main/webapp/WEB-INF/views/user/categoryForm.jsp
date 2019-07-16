
<script>
jQuery(function() {

	// カスタムオーダー(CO)
	jQuery("#btn_custom").click(function(){

		jQuery("#categoryForm").attr("action", "${pageContext.request.contextPath}/category/selectCO");

	});

	// パターンオーダー(PO)
	jQuery("#btn_pattern").click(function(){

		jQuery("#categoryForm").attr("action", "${pageContext.request.contextPath}/category/selectPO");
	});
});
</script>

<div class="login-content">
    <div class="login-logo">
        <span>受発注システム</span>
    </div>
    <div class="login-form">
        <form:form modelAttribute="categoryForm" method="post" action="">
    		<sec:authentication property="principal.myUser" var="myUser" />
            <div class="register-link m-t-15 text-center">
                <strong style="color:black;">利用する業態を選択してください。</strong>
            </div>
            <div class="social-login-content">
                <div class="social-button">
                	<c:choose>
		    			<c:when test="${myUser.authorityCo == '1' && myUser.authorityPo == '1'}">
		    				<button type="submit" id="btn_custom" class="btn btn-lg btn-block mb-3" style="background: #8b4513; color: #ffffff; font-size: 120%;">カスタムオーダー</button>
		    				<button type="submit" id="btn_pattern" class="btn btn-lg btn-block mt-3" style="background: #000066; color: #ffffff; font-size: 120%;">パターンオーダー</button>
		    			</c:when>
		    			<c:when test="${myUser.authorityCo == '1'}">
		    				<button type="submit" id="btn_custom" class="btn btn-lg btn-block mb-3" style="background: #8b4513; color: #ffffff; font-size: 120%;">カスタムオーダー</button>
		    			</c:when>
						<c:when test="${myUser.authorityPo == '1'}">
							<button type="submit" id="btn_pattern" class="btn btn-lg btn-block mt-3" style="background: #000066; color: #ffffff; font-size: 120%;">パターンオーダー</button>
		    			</c:when>
		    		</c:choose>
                </div>
            </div>
        </form:form>
    </div>
</div>
