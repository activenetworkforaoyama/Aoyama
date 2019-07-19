<style type="text/css">
.alert {
    margin-bottom: 15px;
    padding: 10px;
    border: 1px solid;
    border-radius: 4px;
    text-shadow: 0 1px 0 #ffffff;
}
.alert-error {
    background: #fff1f0;
    color: #d85030;
    border-color: rgba(216, 80, 48, 0.3);
    width:800px;
}
.alert-success {
	color: #155724;
	background-color: #d4edda;
	border-color: #c3e6cb;
	width:800px;
}

</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/chosen.css" type="text/css">
<div class="breadcrumbs">
    <div class="col-sm-4">
        <div class="page-header float-left">
            <div class="page-title">
                <h1>パスワード管理</h1>
            </div>
        </div>
    </div>
</div>

<div class="content mt-3">
<t:messagesPanel messagesAttributeName="resultMessages"/>
<div class="alert alert-error" id="errormssage" style="display:none"></div>
<div class="animated fadeIn">
<div class="card">
<div class="card-body">
<form:form modelAttribute="passwordForm" method="post" class="form-horizontal"
        action="${pageContext.request.contextPath}/password/update" >
<div class="row">
<div class="col col-lg-8">
	<spring:eval var="sessionContent" expression="@sessionContent" />
	<div class="row form-group">
		<c:choose>
			<c:when test="${sessionContent.authority == '02'}">
		    <div class="col col-md-4"><label class=" form-control-label">ユーザ ID:</label></div>
		    <div class="col-12 col-md-4">
		       <select name="userId" id="userId" data-placeholder="ユーザ IDを選択">
	           </select>
		    </div>
			<br>
			</c:when>
		</c:choose>
	</div>
	<div class="row form-group">
	    <div class="col col-md-4"><label class=" form-control-label">新しいパスワード:</label></div>
	    <div class="col-12 col-md-4">
	        <form:password path="password" maxlength = "10" class="input-sm form-control-sm form-control"/>
	        
	    </div>
	    <br>
	 </div>
	 <div class="row form-group">
	    <div class="col col-md-4"><label class=" form-control-label">新しいパスワード(確認):</label></div>
	    <div class="col-12 col-md-4">
	        <form:password path="passwordConfirm" maxlength = "10" class="input-sm form-control-sm form-control"/>
	        
	    </div>
	    <br>
	 </div>
	 <div class="row form-group">
		<div class="col col-md-4">
			<button type="button" id="clearButton" class="btn btn-danger btn-block"><i class="fa fa-trash-o"></i> クリア</button>
		</div>
		<div class="col col-md-4">
			<button type="submit" id="confirmButton" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i> 変更する</button>
		</div>
	 </div>
</div>
</div>
</form:form>
</div>
</div>
</div>
</div>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/chosen.jquery.js"></script>
<script>
/**
 * 画面のチェック処理
 */
function check() {

	// エラーメッセージのDIVを表示しない
	jQuery("div.alert-error").hide();
	jQuery("div.alert-success").hide();
	// localStorageで画面のuserIdの値を設定
	localStorage.setItem("userId",jQuery("#userId option:selected").val());
    var pw = jQuery("#password").val();
    var pwCo = jQuery("#passwordConfirm").val();

    if(isEmpty(pw)) {
    	
        appendAlert('errormssage', getMsgByOneArg('msg001', '新しいパスワード'));
        return false;
    }
    
    // 半角英数字チェック
    if (isAlphabetNumeric(pw) || (pw.length < 6)) {
	    
        appendAlert('errormssage', getMsgByTwoArgs('msg042', '新しいパスワード','半角英数字６'));
        return false;
	}
	
    if(isEmpty(pwCo)) {

        appendAlert('errormssage', getMsgByOneArg('msg001', '新しいパスワード(確認)'));
        return false;
    }

    // 半角英数字チェック
    if (isAlphabetNumeric(pwCo) || (pwCo.length < 6)) {
	    
        appendAlert('errormssage', getMsgByTwoArgs('msg042', '新しいパスワード（確認）','半角英数字６'));
        return false;
	}
    
    // 新しいパスワードと新しいパスワード(確認)が一致していません。
    if (pw != pwCo) {

        appendAlert('errormssage', getMsg('msg035'));
        return false;
    }
	// チェック処理正常の場合、Form.submit
    document.getElementById('passwordForm').submit();
    return true;
}

jQuery(document).ready(function() {

	var contextPath = jQuery("meta[name='contextPath']").attr("content");
	// ユーザの権限:02：商品部
	var authority = '${sessionContent.authority}';
	var sessionUserid = '${sessionContent.userId}';
	
	//　localStorageから画面の値を取得
	var updateUserId = localStorage.getItem("userId");
	jQuery("#password").focus();
	

	if (updateUserId == null || updateUserId == "") {
		updateUserId = sessionUserid;
	}

	// 変更するボタン
	jQuery("#confirmButton").click(function(){
		var msginfo = "";
		// 02：商品部の場合
		if (authority == "02") {
			msginfo = getMsgByOneArg('msg039', jQuery("#userId option:selected").val());
		}else {
			msginfo = getMsgByOneArg('msg039', sessionUserid);
		}

		// 確認メッセージ
		swal({
			  text: msginfo,
			  icon: "info",
			  buttons: ["キャンセル", true],
			  dangerMode: true,
			  closeOnEsc: false,
			})
			.then((isConfirm) => {
			  if (isConfirm) {
				  // 画面のチェック処理を実行
				  check();
			  }
			});

		return false;

	});

	// クリア
	jQuery("#clearButton").click(function(){
		jQuery("#password").val("");
		jQuery("#passwordConfirm").val("");
		// エラーメッセージのDIVを表示しない
		jQuery("div.alert-error").hide();
		jQuery("div.alert-success").hide();
	});


	// 02：商品部の場合
	if (authority == "02") {
		var msg = getMsg('msg045');
		var obj = document.getElementById("userId");
		 obj.options.length=0;
		 obj.add(new Option("",""));
	        jQuery.ajax({
	            url: contextPath + "/password/selectAllUser",
	            type: 'get',
	            async:false,
	            success: function(data){
	               jQuery.each(data, function (index, e) {
	                   obj.add(new Option(e.userId, e.userId));
	               });
	               jQuery("#userId").trigger("chosen:updated");
	               jQuery("#userId").chosen({
	           	   disable_search_threshold: 10,
	           	   no_results_text: msg,
	           	   width: "100%"
	           	   }); 
	            }
	        });
		
		}

	// 初期表示のユーザ値を設定
	jQuery("#userId option[value='"+ updateUserId +"']").prop("selected", true);
	jQuery("#userId").trigger("chosen:updated");
	// クリアlocalStorageの値
	localStorage.clear();

});

</script>