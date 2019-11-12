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
<spring:eval var="sessionContent" expression="@sessionContent" />
<div class="breadcrumbs">
    <div class="col-sm-4">
        <div class="page-header float-left">
            <div class="page-title">            
                <h1>注文内容確認書印刷</h1>
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
<form:form modelAttribute="printForm" method="post" class="form-horizontal" action="${pageContext.request.contextPath}/print/update" >
<div class="row">
<div class="col col-lg-8">
	<div class="row form-group">
	    <div class="col col-md-2">
	    	<label class=" form-control-label">注文ID</label>
	    </div>
	    <div class="col col-md-4">
	        <input maxlength='12' type="text" id="orderId" name="customerMessageInfo.orderId" class="input-sm form-control-sm form-control" value="" >
	    </div>
	    <div class="col col-md-4">
			<button type="submit" id="printButton"  class="btn btn-primary btn-block" ><i class="fa fa-check-circle"></i>&nbsp;印刷</button>
		</div>
	    <br> 
	 </div>
</div>
</div>
</form:form>
</div>
</div>
</div>
</div>
<!-- 依存ライブラリの読み込み -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/bootstrap-datepicker3.css" type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/firebugx.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-1.11.2.min.js"></script>

<!-- SlickGridモジュールの読み込み -->
<script
	src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
<script 
	src="${pageContext.request.contextPath}/resources/app/js/jquery.blockUI.js"></script>

<script>

jQuery(document).ready(function() {
	
	var contextPath = jQuery("meta[name='contextPath']").attr("content");
	var belongCode = '${sessionContent.belongCode}';
	jQuery("#orderId").focus();
	// 印刷ボタン
	jQuery("#printButton").click(function(){
		jQuery("#orderId").select();
		if(check()){
			$.blockUI({ message: '<div class="content mt-3"><img src="${pageContext.request.contextPath}/resources/app/images/loading.gif" .></div>' });
			openPdfWindow(1,belongCode);
		};
		return false;
	});
});

function openPdfWindow(sign,belongCode){
	var orderId = jQuery("#orderId").val();
	var productItem = jQuery("#product_item").text();
	jQuery.ajax({
	    url:contextPath + "/pdfFile/poPdfFileCheck",
	    type:"get",
	    data:{"orderId" : orderId},
	    contentType:"application/json",
	    success:function(result){
	    	var shippingNumber = result.shippingNumber;
	    	var hostTransmitARow = result.hostTransmitARow;
	    	var productFactoryCd = result.productFactoryCd;
	    	var makerFactoryStatus = result.makerFactoryStatus;
	    	if(productFactoryCd != belongCode){
	    		//"1" == sign：注文内容確認書
		    	//msg139 = 入力された注文IDは存在しません。
				appendAlert('errormssage', getMsgByTwoArgs('msg139'));
				$.unblockUI();
		    }else if (makerFactoryStatus == 'F0'){
				//"1" == sign：注文内容確認書
		    	//msg140 = {0}へ未連携のためＰＤＦを生成できません。
				appendAlert('errormssage', getMsgByOneArg('msg140', '工場'));
				$.unblockUI();
			}else if((shippingNumber == null || "" == shippingNumber) && "1" == sign){
		    	//"1" == sign：注文内容確認書
	    		//msg113 = {0}が未連携のためＰＤＦを生成できません。
				appendAlert('errormssage', getMsgByOneArg('msg113', '出荷番号'));
				$.unblockUI();
		    }else if((hostTransmitARow == null || "" == hostTransmitARow) && "1" == sign){
		    	//"1" == sign：注文内容確認書
		    	//msg113 = {0}が未連携のためＰＤＦを生成できません。
				appendAlert('errormssage', getMsgByOneArg('msg113', 'A行'));
				$.unblockUI();
			}else{
				var path = contextPath+'/';
				var fileNameDefault = "注文内容確認書("+orderId+").pdf";
				var printwindow = pdfCreate(sign,orderId,productItem,fileNameDefault);
				printwindow.onafterprint = function(){
					var result = pdfDelete(fileNameDefault);
					if (result){
						printwindow.close();
					}
				 }
			}
	    },
        error: function(sign,orderId,productItem) {
            appendAlert('errormssage', getMsgByTwoArgs('msg139'));
            $.unblockUI();
        }
	});
}
function pdfCreate(sign,orderId,productItem,fileNameDefault){
	var childWindow = null ;
	jQuery.ajax({
		url: contextPath + "/pdfFile/PdfFileCreate",
		type: 'get',
		data:{"orderId" : orderId ,"sign" : sign ,"productItem" : productItem , "fileNameDefault" : fileNameDefault},
		contentType:"application/pdf",
		async: false,
		success: function(result){
			appendAlert('errormssage', getMsgByTwoArgs('msg019', 'PDF表示'));
			//ローカル環境
			childWindow =window.open(location.protocol+ '//' + location.host  +'/pdfjs/web/viewer.html?file=../..' + contextPath + '/pdf/' + fileNameDefault, 'newtab');
			//ステージング環境
			//childWindow =window.open('http://202.214.88.88/order/pdfjs/web/viewer.html?file=' + fileNameDefault, 'newtab');
			$.unblockUI();
		},
		error: function(sign,orderId,productItem) {
            appendAlert('errormssage', getMsgByTwoArgs('msg020', 'PDF表示'));
            $.unblockUI();
        }
    });
    return childWindow;
}

function pdfDelete(fileNameDefault){
	result = true;
	jQuery.ajax({
		url: contextPath + "/pdfFile/poPdfFileDelete",
		type: 'get',
		data:{"fileNameDefault" : fileNameDefault},
		contentType:"application/json",
		success: function(result){
			result = true;
		},
		error: function(sign,orderId,productItem) {
            result = false;
        }
    });
    return result;
}
/**
 * 画面のチェック処理
 */
function check() {

	// エラーメッセージのDIVを表示しない
	jQuery("div.alert-error").hide();
	jQuery("div.alert-success").hide();
	// localStorageで画面のmyUserIdの値を設定
    var orderid = jQuery("#orderId").val();
    if(isEmpty(orderid)) {
        appendAlert('errormssage', getMsgByOneArg('msg001', '注文ID'));
        return false;
    }
    // 入力チェック
    if (!num_check(orderid)) {
        appendAlert('errormssage', getMsgByTwoArgs('msg012', '注文ID','半角数字'));
        return false;
	}
	if(orderid.length < 12) {
		appendAlert('errormssage', getMsgByTwoArgs('msg011', '注文ID','12'));
        return false;
    }
    return true;
}
function num_check(str){
	var ok = true;
	var wresult = "";
	var wcheck = true;
	var wnum = str;
	wresult = /[^\d-.]/.test(wnum);
	if (wresult){
		ok=false;
	} else {
		wresult = /-+/.test(wnum);
		if (wresult){
			wcheck=minus_check(wnum);
		}
		if (wcheck){
			wresult = /[.]+/.test(wnum);
			if (wresult){
				wcheck=point_check(wnum);
			}
		}
		if (!wcheck){
			ok=false;
		}
	}
	return(ok);
}
</script>