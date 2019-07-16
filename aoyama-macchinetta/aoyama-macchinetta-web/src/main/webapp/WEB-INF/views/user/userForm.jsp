<style type="text/css">

.alert-error {
    background: #fff1f0;
    color: #d85030;
    border-color: rgba(216, 80, 48, 0.3);
}
</style>

<div class="login-content">
    <div class="login-logo">
        <span>受発注システム</span>
    </div>
    <div class="login-form">
    <t:messagesPanel  messagesAttributeName="resultMessages"/>
		<form:form modelAttribute="userForm" method="post" action="${pageContext.request.contextPath}/login">
			
			<div class="form-group">
                   <!-- <label>ユーザID</label> -->
                   <form:input path="userId" class="form-control" placeholder="ユーザID"/>
            </div>
            <div class="form-group">
                <!-- <label>パスワード</label> -->
                <form:password path="password" class="form-control" placeholder="パスワード"/>
            </div>
            <button id="btn_login" name="Login"  type="submit" class="btn btn-success btn-flat m-b-30 m-t-30" >ログイン</button>
		</form:form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
<script>
jQuery(function() {
	jQuery("#userId").focus();
	
	jQuery("#btn_login").click(function(){

		var userId = jQuery("#userId").val();
		var userPasswd = jQuery("#password").val();
		
		if (userId == "") {
			var msg = getMsgByOneArg('msg001', 'ユーザID');
			swal({
				text:msg,
				icon:"error"
			}).then(function(val){
				jQuery("#userId").focus();
			});
			return false;
		} else if (userPasswd == "") {
			var msg = getMsgByOneArg('msg001', 'パスワード');
			swal({
				text:msg,
				icon:"error"
			}).then(function(val){
				jQuery("#password").focus();
			});
			return false;
		}

		//jQuery("#userForm").attr("action", "${pageContext.request.contextPath}/login");
		return true;
	});
});
</script>
