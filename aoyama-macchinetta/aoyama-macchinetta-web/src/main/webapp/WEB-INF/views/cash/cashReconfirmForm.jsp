<style>
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
</style>
<div class="breadcrumbs">
	<div class="col-sm-4">
		<div class="page-header float-left">
			<div class="page-title">
				<h1>会計内容確認</h1>
			</div>
		</div>
	</div>
</div>
<form:form id="idForm" action="${pageContext.request.contextPath}/cashConfirm/cashReFormInDb" method="post" modelAttribute="cashForm" class="form-horizontal">
<div class="content mt-3">
<div class="alert alert-error" id="errormssage" style="display:none"></div>
<t:messagesPanel  messagesAttributeName="resultMessages"/>
	<div class="animated fadeIn">

		<div class="card" id="nav1_custom_div" style="margin-bottom: 0.5em;">
			<div class="card-body">
						<!-- 左側項目 -->
						<div class="col col-lg-6">
							<div class="row">
								<div class="col col-md-4">
									<label class=" form-control-label">お客様氏名</label>
								</div>
								<c:if test="${cashForm.custNm != null && cashForm.custKanaNm != null}">
								<div class="col-12 col-md-8">
									<strong><output>${f:h(cashForm.custNm)}(${f:h(cashForm.custKanaNm)})</output></strong> 
								</div>
								</c:if>
								<c:if test="${cashForm.custNm != null && cashForm.custKanaNm == null}">
								<div class="col-12 col-md-8">
									<strong><output>${f:h(cashForm.custNm)}</output></strong> 
								</div>
								</c:if>
								<c:if test="${cashForm.custNm == null && cashForm.custKanaNm != null}">
								<div class="col-12 col-md-8">
									<strong><output>${f:h(cashForm.custKanaNm)}</output></strong> 
								</div>
								</c:if>
								<c:if test="${cashForm.custNm == null && cashForm.custKanaNm == null}">
								<div class="col-12 col-md-8">
									<strong><output></output></strong> 
								</div>
								</c:if>
							</div>
							<div class="row">
								<div class="col col-md-4">
									<label class=" form-control-label">会計No.</label>
								</div>
								<div class="col-12 col-md-8">
									<strong><output>${cashForm.cashId}</output></strong>
									<!-- <input type="hidden" name="cashId" value="${cashForm.cashId}"/>
									<input type="hidden" name="shopCode" value="${cashForm.shopCode}"/>  -->
								</div>
							</div>
						</div>
						<!-- 右側項目 -->
						<div class="col col-lg-6">
							<div class="row">
								<div class="col col-md-4">
									<label class=" form-control-label">ご注文合計</label>
								</div>
								<div class="col-12 col-md-4 text-right">
									<strong>￥<output id="cashTotalPrice">${cashForm.cashTotalPrice}</output></strong>
									<input type="hidden" name="cashTotalPrice" value="${cashForm.cashTotalPrice}"/>
									<%-- <strong><input value="${cashForm.cashTotalPrice}" name="cashTotalPrice" style="vertical-align: right; border-width: 0; BACKGROUND-COLOR: transparent;" readonly></strong> --%>
								</div>
								<div class="col-12 col-md-4"></div>
							</div>
							<div class="row">
								<div class="col col-md-4">
									<label class=" form-control-label">内商品合計</label>
								</div>
								<div class="col-12 col-md-4 text-right">
									<strong>￥<output id="cashExceptTaxPrice">${cashForm.cashExceptTaxPrice}</output></strong>
									<input type="hidden" name="cashExceptTaxPrice" value="${cashForm.cashExceptTaxPrice}"/>
									<%-- <strong><input value="${cashForm.cashExceptTaxPrice}" name="cashExceptTaxPrice" style="vertical-align: right; border-width: 0; BACKGROUND-COLOR: transparent;" readonly></strong> --%>
								</div>
								<div class="col-12 col-md-4"></div>
							</div>
							<div class="row">
								<div class="col col-md-4">
									<label class=" form-control-label">内消費税</label>
								</div>
								<div class="col-12 col-md-4 text-right">
									<strong>￥<output id="cashTaxAmount">${cashForm.cashTaxAmount}</output></strong>
									<input type="hidden" name="cashTaxAmount" value="${cashForm.cashTaxAmount}"/>
									<%-- <strong><input value="${cashForm.cashTaxAmount}" name="cashTaxAmount" style="vertical-align: right; border-width: 0; BACKGROUND-COLOR: transparent;" readonly></strong> --%>
								</div>
								<div class="col-12 col-md-4"></div>
							</div>
						</div>
						<!-- 検索条件部分 End -->

			</div>
			<!-- card body -->
		</div>
		<!-- card -->

	</div>
	<!-- .animated -->

	<div class="card" id="areaResult" style="margin-bottom: 0.5em;">
		<div class="card-body">
			<div class="row">
				<div class="col">
					<table id="bootstrap-data-table"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th class="text-center"
									style="vertical-align: middle; padding: 0px;">注文ID</th>
								<th class="text-center"
									style="vertical-align: middle; padding: 0px;">単価<br>（税抜）</th>
								<th class="text-center"
									style="vertical-align: middle; padding: 0px;">値引後金額<br>（税抜）
								</th>
								<th class="text-center"
									style="vertical-align: middle; padding: 0px;">商品金額<br>（税抜）
								</th>
							</tr>
						</thead>
						<c:forEach var="cash" items="${cashForm.helpCashForm}" varStatus="row">
						<tbody>
							<tr>
								<td style="width:25%;"><input value="${cash.orderId }" name="helpCashForm[${row.index}].orderId" style="vertical-align: right; border-width: 0; BACKGROUND-COLOR: transparent;" readonly>
								<!-- <input type="hidden" name="helpCashForm[${row.count}].orderId" value="${cash.orderId }" readonly/> -->
								</td>
								<td class="text-right" style="width:25%;">￥<output id="totalPrice_${row.index}">${cash.totalPrice }</output>
								<input type="hidden" name="helpCashForm[${row.index}].totalPrice" value="${cash.totalPrice }" readonly/> 
								<%-- <input value="${cash.totalPrice }" name="helpCashForm[${row.index}].totalPric" style="vertical-align: right; border-width: 0; BACKGROUND-COLOR: transparent;" readonly> --%>
								</td>
								<td class="text-right" style="width:25%;">￥<output id="cashDiscountPrice_${row.index}">${cash.cashDiscountPrice }</output>
								<input type="hidden" name="helpCashForm[${row.index}].cashDiscountPrice" value="${cash.cashDiscountPrice }" readonly/>
								<%-- <input value="${cash.cashDiscountPrice }" name="helpCashForm[${row.index}].cashDiscountPrice" style="vertical-align: right; border-width: 0; BACKGROUND-COLOR: transparent;" readonly> --%>
								</td>
								<td class="text-right" style="width:25%;">￥<output id="cashProductPrice_${row.index}">${cash.cashProductPrice }</output>
								<input type="hidden" name="helpCashForm[${row.index}].cashProductPrice" value="${cash.cashProductPrice }" readonly/>
								<%-- <input value="${cash.cashProductPrice }" name="helpCashForm[${row.index}].cashProductPrice" style="vertical-align: right; border-width: 0; BACKGROUND-COLOR: transparent;" readonly> --%>
								</td>
							</tr>
						</tbody>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div id="cashFrom" class="card-body text-center">
					<div class="col col-md-2"></div>
					<div class="col col-md-4">
						<button id="backButton" type="button"
							class="btn btn-success btn-block">
							<i class="fa fa-arrow-left"></i> 戻る
						</button>
					</div>
					<div class="col col-md-4">
						<button id="submit" type="submit" onclick="return imageCheck();"
							class="btn btn-primary btn-block">
							<i class="fa fa-check-circle"></i> 確定
						</button>
					</div>
					<div class="col col-md-2"></div>
				</div>
				<div id="accountingFrom" class="card-body text-center" style="display:none">
					<div class="col col-md-4"></div>
					<div class="col col-md-4">
						<button id="accountingBackButton" type="button"
							class="btn btn-success btn-block">
							<i class="fa fa-arrow-left"></i> 戻る
						</button>
					</div>
					<div class="col col-md-4"></div>
				</div>
			</div>
		</div>
	</div>
</div>
</form:form>
<script
	src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
<script type="text/javascript">
var contextPath = jQuery("meta[name='contextPath']").attr("content");
//CSRF令牌
jQuery(function () {
	// CSRFトークン値を連携するためのリクエストヘッダ名を取得する
    var headerName = jQuery("meta[name='_csrf_header']").attr("content");
    // CSRFトークン値を取得する
    var tokenValue = jQuery("meta[name='_csrf']").attr("content");
    jQuery(document).ajaxSend(function(e, xhr, options) {
        // リクエストヘッダにCSRFトークン値を設定する
        xhr.setRequestHeader(headerName, tokenValue);
    });
});

var list = ${json};
var sendData = JSON.stringify(list);
var obj = eval('('+ sendData +')');
jQuery(document).ready(function(){
	var flag = localStorage.getItem("key");
	if(flag == 'cashLink'){
		jQuery("#cashFrom").hide();
		jQuery("#accountingFrom").show();
		}
	else{
		jQuery("#cashFrom").show();
		}
	var cashTotalPrice = "${cashForm.cashTotalPrice}";
	jQuery("#cashTotalPrice").val(formatMoney(cashTotalPrice, 0, ""));
	
	var cashExceptTaxPrice = "${cashForm.cashExceptTaxPrice}";
	if(cashExceptTaxPrice.match(",")){

		}else{
			jQuery("#cashExceptTaxPrice").val(formatMoney(cashExceptTaxPrice, 0, ""));
		}
	
	var cashTaxAmount = "${cashForm.cashTaxAmount}";
	if(cashTaxAmount.match(",")){

		}else{
			jQuery("#cashTaxAmount").val(formatMoney(cashTaxAmount, 0, ""));
		}
	for(var i = 0;i<=obj.length-1;i++){
		jQuery("#totalPrice_"+i).val(formatMoney(jQuery("#totalPrice_"+i).val(), 0, ""));
		jQuery("#cashDiscountPrice_"+i).val(formatMoney(jQuery("#cashDiscountPrice_"+i).val(), 0, ""));
		jQuery("#cashProductPrice_"+i).val(formatMoney(jQuery("#cashProductPrice_"+i).val(), 0, ""));
		}
});

//--------------------------------------------
//確認チェック
//--------------------------------------------
function imageCheck(){
	//会計No.
	var cashId = "${cashForm.cashId}";
	if(isEmpty(cashId)) {
        appendAlert('errormssage', getMsgByOneArg('msg001', '会計No.'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}
	//ご注文合計：cashTotalPrice
	var cashTotalPrice = "${cashForm.cashTotalPrice}";
	if(isEmpty(cashTotalPrice)) {
        appendAlert('errormssage', getMsgByOneArg('msg118', 'ご注文合計'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}
	//内商品合計
	var cashExceptTaxPrice = "${cashForm.cashExceptTaxPrice}";
	if(isEmpty(cashExceptTaxPrice)) {
        appendAlert('errormssage', getMsgByOneArg('msg118', '内商品合計'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}
	//内消費税
	var cashTaxAmount = "${cashForm.cashTaxAmount}";
	if(isEmpty(cashTaxAmount)) {
        appendAlert('errormssage', getMsgByOneArg('msg118', '内消費税'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}
	
	var cashDiscountPriceList = obj;
	for( var i = 0;i<cashDiscountPriceList.length;i++){
		//値引後金額(税抜):cashDiscountPrice
		if(cashDiscountPriceList[i].cashDiscountPrice === "" || cashDiscountPriceList[i].cashDiscountPrice == null){
			appendAlert('errormssage', getMsgByOneArg('msg118', '値引後金額(税抜)'));
	        return false;
		}else{
			appendAlertDel('errormssage');
		}
		//商品金額(税抜):cashDiscountPrice
		if(cashDiscountPriceList[i].cashProductPrice === "" || cashDiscountPriceList[i].cashProductPrice == null){
			appendAlert('errormssage', getMsgByOneArg('msg118', '商品金額(税抜)'));
	        return false;
		}else{
			appendAlertDel('errormssage');
		}
		
	}
}

jQuery('#backButton').click(function(){
	var cashTotalPrice = "${cashForm.cashTotalPrice}";
	var cashExceptTaxPrice = "${cashForm.cashExceptTaxPrice}";
	var cashTaxAmount = "${cashForm.cashTaxAmount}";
	jQuery("#idForm").attr("action", "${pageContext.request.contextPath}/cash/goBack");
	jQuery("#submit").click();
	/* localStorage.setItem("key_1", "cashRecon");
	localStorage.setItem("cashTotalPrice", cashTotalPrice);
	localStorage.setItem("cashExceptTaxPrice", cashExceptTaxPrice);
	localStorage.setItem("cashTaxAmount", cashTaxAmount);
	localStorage.setItem("key_1", "cashRecon");
	var cashDiscountPrice = new Array();
	var cashProductPrice = new Array();
	for(var i = 0;i<=obj.length-1;i++){
		cashDiscountPrice.push(jQuery("#cashDiscountPrice_"+i).val().replace(/\,/g, ""));
		cashProductPrice.push(jQuery("#cashProductPrice_"+i).val().replace(/\,/g, ""));
		}
	localStorage.setItem("cashDiscountPrice", JSON.stringify(cashDiscountPrice));
	localStorage.setItem("cashProductPrice", JSON.stringify(cashProductPrice)); */
	/* window.history.go(-1) */
});
jQuery('#accountingBackButton').on('click', function() {
	window.location.href= contextPath + "/accounting/gotoAccounting";
});

//金額フォーマット
function formatMoney(number, places, symbol, thousand, decimal) {
    number = number || 0;
    places = !isNaN(places = Math.abs(places)) ? places : 2;
    symbol = symbol !== undefined ? symbol : "$";
    thousand = thousand || ",";
    decimal = decimal || ".";
    var negative = number < 0 ? "-" : "",
        i = parseInt(number = Math.abs(+number || 0).toFixed(places), 10) + "",
        j = (a = i.length) > 3 ? a % 3 : 0;
    return symbol + negative + (j ? i.substr(0, j) + thousand : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + thousand) + (places ? decimal + Math.abs(number - i).toFixed(places).slice(2) : "");
}
</script>