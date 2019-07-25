<style>
table.dataTable tbody td {
	padding: 2px 10px;
}

.slick-cell.selected {
	background-color: #FBB;
}

.cell-del-type {
	text-align: center;
}

.test_input {
	width: 100%;
	height: 100%;
	border: 0;
	margin: 0;
	background: transparent;
	outline: 0;
	padding: 0;
	disabled: true;
}

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
	width: 800px;
}

.btn_off {
	cursor: pointer;
	vertical-align: middle;
	background: #85786A;
	border: 1px solid #85786A;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	color: #fff;
	width: 142px;
	height: 35px;
	padding: 0;
	font-size: 16px;
	vertical-align: middle;
	font-weight: bold;
	position: relative;
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.3);
	border: 1px solid #E25A00;
	border: 1px solid #85786A;
}

.btn_blue {
	background: #007bff;
	border: 1px solid #007bff;
	margin-left: 62px;
}

.btn_red {
	background: #dc3545;
	border: 1px solid #dc3545;
}

.div {
	width: 800px;
	text-align: center
}
</style>

<div class="breadcrumbs">
	<div class="col-sm-4">
		<div class="page-header float-left">
			<div class="page-title">
				<h1>会計登録</h1>
			</div>
		</div>
	</div>
</div>

<form:form id="formId" action="${pageContext.request.contextPath}/cash/cashReconfirm" method="post" modelAttribute="cashForm" class="form-horizontal">
	<div class="content mt-3">
	<div class="alert alert-error" id="errormssage" style="display:none"></div>
	<div class="alert alert-success" id="successmssage" style="display:none"></div>
	<t:messagesPanel  messagesAttributeName="resultMessages"/>
		<div class="animated fadeIn">
			<div class="card" id="nav1_custom_div" style="margin-bottom: 0.5em;">
				<div class="card-body" style="padding-bottom: 0;">
					<!-- 検索条件部分 End -->
						<!-- 左側項目 -->
						<div class="col col-lg-6">
							<div class="row">
								<div class="col col-md-4">
									<label class=" form-control-label">お客様氏名</label>
								</div>
								<div class="col-12 col-md-8">
									<strong><output>${cashForm.custNm}</output></strong> 
									<!-- <input type="hidden" name="custNm" value="${cashForm.custNm}" /> -->
								</div>
							</div>
							<div class="row">
								<div class="col col-md-4">
									<label class=" form-control-label">会計No.</label>
								</div>
								<div class="col-12 col-md-8">
									<strong><output id="cashId">${cashForm.cashId}</output></strong>
									<!-- <input id="cashIdDate" type="hidden" name="cashId" value="${order.cashId}" /> -->
									<!-- <input type="hidden" name="shopCode" value="${order.shopCode}"/> -->
								</div>
							</div>
						</div>
						<!-- 右側項目 -->
						<c:choose>
						<c:when test="${cashForm != null && cashForm.cashTotalPrice == null}">
						<div class="col col-lg-6">
							<div class="row">
								<div class="col col-md-4">
									<label class=" form-control-label">ご注文合計</label>
								</div>
								<div class="col-12 col-md-4">
									<input id="cash_total_price" name="cashTotalPrice" maxlength="9"
										oninput="this.value=this.value.replace(/[^\d]/g,'')"
										class="input-sm form-control-sm form-control  text-right">
								</div>
								<div class="col-12 col-md-4"></div>
							</div>
							<div class="row">
								<div class="col col-md-4">
									<label class=" form-control-label">内商品合計</label>
								</div>
								<div class="col-12 col-md-4 text-right">
									<strong class="text-right">&yen;<output id="cash_except_tax_price" name="cashExceptTaxPrice"></output>
									</strong>
										<input id="except_tax_price" type="hidden" name="cashExceptTaxPrice" value="" />
										<!-- <input id="cash_except_tax_price" name="cashExceptTaxPrice" style="vertical-align: middle; border-width: 0; BACKGROUND-COLOR: transparent; text-align:right;" readonly> -->
								</div>
								<div class="col-12 col-md-4"></div>
							</div>
							<div class="row">
								<div class="col col-md-4">
									<label class=" form-control-label">内消費税</label>
								</div>
								<div class="col-12 col-md-4 text-right">
									<strong>&yen;<output id="cash_tax_amount"
											name="cashTaxAmount"></output></strong> <input id="tax_amount"
										type="hidden" name="cashTaxAmount" value="" />
									<!-- <strong>
									<input id="cash_tax_amount" name="cashTaxAmount" style="vertical-align: middle; border-width: 0; BACKGROUND-COLOR: transparent; text-align:right;" readonly></strong>  -->
								</div>
								<div class="col-12 col-md-4"></div>
							</div>
						</div>
						</c:when>
						<c:when test="${cashForm != null && cashForm.cashTotalPrice != null}">
							<div class="col col-lg-6">
							<div class="row">
								<div class="col col-md-4">
									<label class=" form-control-label">ご注文合計</label>
								</div>
								<div class="col-12 col-md-4">
									<input id="cash_total_price" value="${cashForm.cashTotalPrice}" name="cashTotalPrice" maxlength="9"
										oninput="this.value=this.value.replace(/[^\d]/g,'')"
										class="input-sm form-control-sm form-control  text-right">
									<%-- <input id="cashTotal_price" value="${cashForm.cashTotalPrice}" name="cashTotalPrice" maxlength="9"
										oninput="this.value=this.value.replace(/[^\d]/g,'')"
										class="input-sm form-control-sm form-control  text-right"> --%>
								</div>
								<div class="col-12 col-md-4"></div>
							</div>
							<div class="row">
								<div class="col col-md-4">
									<label class=" form-control-label">内商品合計</label>
								</div>
								<div class="col-12 col-md-4 text-right">
									<%-- <strong>&yen;<output id="cashExceptTax_price" name="cashExceptTaxPrice">${cashForm.cashExceptTaxPrice}</output></strong>
									<input id="cash_exceptTaxPrice" type="hidden" name="cashExceptTaxPrice" value="" /> --%>
									<strong class="text-right">&yen;<output id="cash_except_tax_price" name="cashExceptTaxPrice">${cashForm.cashExceptTaxPrice}</output></strong>
									<input id="except_tax_price" type="hidden" name="cashExceptTaxPrice" value="" />
								</div>
								<div class="col-12 col-md-4"></div>
							</div>
							<div class="row">
								<div class="col col-md-4">
									<label class=" form-control-label">内消費税</label>
								</div>
								<div class="col-12 col-md-4 text-right">
									<%-- <strong>&yen;<output id="cashTax_amount" name="cashTaxAmount">${cashForm.cashTaxAmount}</output></strong>
									<input id="cash_taxAmount" type="hidden" name="cashTaxAmount" value="" /> --%>
									<strong>&yen;<output id="cash_tax_amount" name="cashTaxAmount">${cashForm.cashTaxAmount}</output></strong>
									<input id="tax_amount" type="hidden" name="cashTaxAmount" value="" />
								</div>
								<div class="col-12 col-md-4"></div>
							</div>
						</div>
						</c:when>
						</c:choose>
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
					<c:choose>
					<c:when test="${cashForm != null && cashForm.cashId == null}">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th class="text-center"
										style="vertical-align: middle; padding: 0px;">注文ID</th>
									<th class="text-center"
										style="vertical-align: middle; padding: 0px;">単価</th>
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
										<td><input id="orderId"
											name="helpCashForm[${row.index}].orderId"
											value="${cash.orderId }" readonly
											style="border-width: 0; BACKGROUND-COLOR: transparent;"/></td>
										<td id="totalPrice" class="text-right">
										<input id="totalPrice_${row.index}"
											name="helpCashForm[${row.index}].totalPrice"
											value="${cash.totalPrice}" readonly
											style="BACKGROUND-COLOR: transparent;" />
										</td>
										<td><div class="col col-md-6">
												<input type="text" value="" id="cash_discount_price_${row.index}"
													name="helpCashForm[${row.index}].cashDiscountPrice"
													oninput="this.value=this.value.replace(/[^\d]/g,'')"
													maxlength="9"
													class="input-sm form-control-sm form-control text-right">
											</div></td>
										<td class="text-right">&yen;<output id="cash_product_price_${row.index}"></output>
											<input id="cash_productPrice_${row.index}" type="hidden" name="helpCashForm[${row.index}].cashProductPrice" value="" />
											<%-- <input id="cash_product_price_${row.index}" name="helpCashForm[${row.index}].cashProductPrice" value="" readonly style="vertical-align: middle; border-width: 0; BACKGROUND-COLOR: transparent;" > --%>
										</td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
						</c:when>
						<c:when test="${cashForm != null && cashForm.cashId != null}">
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
							<c:forEach var="order" items="${cashForm.orderIdList}" varStatus="row">
								<c:if test="${order.isCancelled == '1'  && cashForm.cashStatus == '03'}">
									<p style="font-size:20px;color:red">注文${order.orderId }が取り消したため、会計を再確認してください。</p>
								</c:if>	
							</c:forEach>
							<c:forEach var="cash" items="${cashForm.helpCashForm}" varStatus="row">
								<tbody>
									<tr>
										<td style="width:25%;"><input id="orderId"
											name="helpCashForm[${row.index}].orderId"
											value="${cash.orderId }" readonly
											style="border-width: 0; BACKGROUND-COLOR: transparent;" /></td>
										<td class="text-right" style="width:25%;">&yen;<output id="totalPrice_${row.index}">${cash.totalPrice}</output>
											<input type="hidden" name="helpCashForm[${row.index}].totalPrice" value="${cash.totalPrice }"/> 
											<%-- <input name="helpCashForm[${row.index}].totalPrice" value="${cash.totalPrice}" readonly style=" border-width: 0; BACKGROUND-COLOR: transparent;"/> --%>
										</td>
										<td style="width:25%;">
												<input type="text" value="${cash.cashDiscountPrice}" id="cash_discount_price_${row.index}"
													name="helpCashForm[${row.index}].cashDiscountPrice" oninput="this.value=this.value.replace(/[^\d]/g,'')"
													maxlength="9" class="input-sm form-control-sm form-control text-right">
											
										</td>
										<td class="text-right" style="width:25%;">&yen;<output id="cash_product_price_${row.index}">${cash.cashProductPrice}</output>
											<%-- <input id="cash_product_price_${row.index}" name="helpCashForm[${row.index}].cashProductPrice" value="${cash.cashProductPrice}" readonly style="vertical-align: middle; border-width: 0; BACKGROUND-COLOR: transparent;" > --%>
											
											<input id="cash_productPrice_${row.index}" type="hidden" name="helpCashForm[${row.index}].cashProductPrice" value="" />
										</td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
						</c:when>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body text-center">
						<c:choose>
						<c:when test="${cashForm.tscStatus == 'T2'}">
						<div class="row">
							<div class="col col-md-2"></div>
							<div class="col col-md-4">
								<button id="backButton" type="button" class="btn btn-success btn-block"><i class="fa fa-arrow-left"></i> 戻る</button>
							</div>
							<div class="col col-md-4">
								<button id="submit" type="submit" class="btn btn-primary btn-block" onclick="return imageCheck();"><i class="fa fa-check-circle"></i> 内容確認</button>
							</div>
							<div class="col col-md-2"></div>
							<%-- <c:choose>
			                	<c:when test="${cashForm != null && cashForm.cashStatus == '03'}">
			                		<div class="col col-md-4"><button id="deleteButton" type="button" class="btn btn-danger btn-block"><i class="fa fa-trash-o"></i> 会計取消</button></div>
			                	</c:when>
			                </c:choose> --%>
						</div>
						</c:when>
			                <c:when test="${cashForm != null && cashForm.cashStatus == '01' || cashForm.cashStatus == '02' || cashForm.cashStatus == '03'}">
						<div class="row">
							<div class="col col-md-4">
								<button id="backButton" type="button" class="btn btn-success btn-block"><i class="fa fa-arrow-left"></i> 戻る</button>
							</div>
							<div class="col col-md-4">
								<button id="submit" type="submit" class="btn btn-primary btn-block" onclick="return imageCheck();"><i class="fa fa-check-circle"></i> 内容確認</button>
							</div>
							<div class="col col-md-4">
								<button id="deleteButton" type="button" class="btn btn-danger btn-block"><i class="fa fa-trash-o"></i> 会計取消</button>
							</div> 
						</div>
							</c:when>
			           </c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
</form:form>
<!-- 依存ライブラリの読み込み -->
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/firebugx.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-1.11.2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-ui-1.11.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery.event.drag-2.3.0.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>

<script>

var contextPath = $("meta[name='contextPath']").attr("content");
var list = ${json};
// var dataView = [];
var data =[];
var sendData = JSON.stringify(list);
var obj = eval('('+ sendData +')');
var taxRate = "${taxRateStr}";
var flag = localStorage.getItem("key");
if(flag == 'cashLink'){
	localStorage.clear();
}

$(document).ready(function() {
var backFlag = "${cashForm.backFlag}";
if(backFlag == "orderFrom" || backFlag == "cashInit"){
	if($("#cash_except_tax_price").val() == null || $("#cash_except_tax_price").val() == undefined 
			|| $("#cash_except_tax_price").val() == ""){
		$("#cash_except_tax_price").val("0");
	}else{
		var cashExceptTaxPrice = $("#cash_except_tax_price").val();
		jQuery("#cash_except_tax_price").val(formatMoney(cashExceptTaxPrice, 0, ""));
		}
	
	if($("#cash_tax_amount").val() == null || $("#cash_tax_amount").val() == undefined 
			|| $("#cash_tax_amount").val() == ""){
		$("#cash_tax_amount").val("0");
	}else{
		var cashTaxAmount = $("#cash_tax_amount").val();
		jQuery("#cash_tax_amount").val(formatMoney(cashTaxAmount, 0, ""));
		}
	
	for(var i = 0;i<=obj.length-1;i++){
		jQuery("#totalPrice_"+i).val(formatMoney(jQuery("#totalPrice_"+i).val(), 0, ""));
		if($("#cash_product_price_"+i).val() == null || $("#cash_product_price_"+i).val() == undefined 
				|| $("#cash_product_price_"+i).val() == ""){
			$("#cash_product_price_"+i).val("0");
			}else{
				jQuery("#cash_product_price_"+i).val(formatMoney($("#cash_product_price_"+i).val(), 0, ""))
				}
		}
}
	
	/* if(backFlag == "cashGoBack"){
		var cashExceptTaxPrice = "${cashForm.cashExceptTaxPrice}";
		jQuery("#cash_except_tax_price").val(cashExceptTaxPrice);
		var cashTaxAmount = "${cashForm.cashTaxAmount}";
		alert(cashTaxAmount)
		jQuery("#cash_tax_amount").val(cashTaxAmount);
		} */
		
	/* var flag_1 = localStorage.getItem("key_1");
	if(flag_1 == 'cashRecon'){
		var cashTotalPrice = localStorage.getItem("cashTotalPrice");
		var cashExceptTaxPrice = localStorage.getItem("cashExceptTaxPrice");
		jQuery("#cash_except_tax_price").val(cashExceptTaxPrice);
		var cashTaxAmount = localStorage.getItem("cashTaxAmount");
		jQuery("#cash_tax_amount").val(cashTaxAmount);
		var cashDiscountPrice = JSON.parse(localStorage.getItem("cashDiscountPrice"));
		var cashProductPrice = JSON.parse(localStorage.getItem("cashProductPrice"));
		for(var i = 0;i<=cashDiscountPrice.length-1;i++){
			jQuery("#cash_discount_price_"+i).val(cashDiscountPrice[i]);
			}
		for(var i = 0;i<=cashProductPrice.length-1;i++){
			jQuery("#cash_product_price_"+i).val(formatMoney(cashProductPrice[i], 0, ""));
			}
		localStorage.clear();
		} */
		
});

function imageCheck(){
	// エラーメッセージのDIVを表示しない
	jQuery("div.alert-error").hide();
	jQuery("div.alert-success").hide();
	//ご注文合計：cash_total_price
	var cash_total_price = jQuery("#cash_total_price").val();
	if(isEmpty(cash_total_price)) {
        appendAlert('errormssage', getMsgByOneArg('msg001', 'ご注文合計'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}
	if(isNumeric(cash_total_price)) {
        appendAlert('errormssage', getMsgByTwoArgs('msg012','ご注文合計','数字'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}
	//値引後金額(税抜):cash_discount_price
	for(var i = 0;i<=obj.length-1;i++){
		var cash_discount_price = jQuery("#cash_discount_price_"+i).val();
		if(isEmpty(cash_discount_price)){
			appendAlert('errormssage', getMsgByOneArg('msg001', '値引後金額(税抜)'));
	        return false;
		}else{
			appendAlertDel('errormssage');
			}
		if(isNumeric(cash_discount_price)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','値引後金額(税抜)','数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
	var total = jQuery("#cash_total_price").val();
	var tax = Math.floor(total-(total/(1+Number(taxRate)/100)));
	var fomartTax = tax.toString();
	for(var i = 1; i < fomartTax.length / 3; i++){
		var temp = fomartTax.slice(0, -4 * i + 1);
		fomartTax = fomartTax.replace(temp, temp + ',');
		if(fomartTax.startsWith(',')){
			fomartTax = fomartTax.substr(1, fomartTax.length-1);
			}
		}
	if(total != null && total != ''){
		jQuery("#cash_tax_amount").val(fomartTax);
		jQuery("#tax_amount").val(fomartTax);
		}else{
			jQuery("#cash_tax_amount").val('');
			jQuery("#tax_amount").val('');
			}
	var tax1 = jQuery("#cash_tax_amount").val().replace(/\,/g, "");
	var format = total - tax1;
	var val = format.toString();
	for(var i = 1; i < val.length / 3; i++){
		var temp = val.slice(0, -4 * i + 1);
		val = val.replace(temp, temp + ',');
		if(val.startsWith(',')){
				val = val.substr(1, val.length-1);
			}
		}
	if(total != null && total != ''){
		jQuery("#cash_except_tax_price").val(val);
		jQuery("#except_tax_price").val(val);
		}else{
			jQuery("#cash_except_tax_price").val('');
			jQuery("#except_tax_price").val('');
			}
	var count = 0;
	var discount = 0;
	var except_tax = jQuery("#cash_except_tax_price").val().replace(/\,/g, "");
	var sum = 0; 
	var zero = 0;
	for(var i = 0;i<=obj.length-1;i++){
		zero = jQuery("#cash_discount_price_"+i).val();
		count += Number(zero);
		}
	for(var i = 0;i<=obj.length-1;i++){
		discount = jQuery("#cash_discount_price_"+i).val();
		sum = Math.round(Number(discount)*Number(except_tax)/(Number(count)));
		if(total != null && total != '' && discount != null && discount != '' && count != 0){
			jQuery("#cash_product_price_"+i).val(formatMoney(sum, 0, ""));
			jQuery("#cash_productPrice_"+i).val(sum);
			}else{
				jQuery("#cash_product_price_"+i).val('0');
				jQuery("#cash_productPrice_"+i).val('0');
				}
	}
}

for(var i = 0;i<=obj.length-1;i++){
	//ご注文合計：cash_total_price
	//内商品合計：cash_except_tax_price
	//内消費税：cash_tax_amount
	//値引後金額(税抜):cash_discount_price_
	//商品金額(税抜):cash_product_price_
	jQuery("#cash_discount_price_"+i).on('input',function(){
		var total = jQuery("#cash_total_price").val();
		var tax = Math.floor(total-(total/(1+Number(taxRate)/100)));
		var fomartTax = tax.toString();
		for(var i = 1; i < fomartTax.length / 3; i++){
			var temp = fomartTax.slice(0, -4 * i + 1);
			fomartTax = fomartTax.replace(temp, temp + ',');
			if(fomartTax.startsWith(',')){
				fomartTax = fomartTax.substr(1, fomartTax.length-1);
				}
			}
		if(total != null && total != ''){
			jQuery("#cash_tax_amount").val(fomartTax);
			jQuery("#tax_amount").val(fomartTax);
			}else{
				jQuery("#cash_tax_amount").val('0');
				jQuery("#tax_amount").val('0');
				}
		/* jQuery("#cash_tax_amount").val(fomartTax);
		jQuery("#tax_amount").val(fomartTax); */
		var tax1 = jQuery("#cash_tax_amount").val().replace(/\,/g, "");
		var format = total - tax1;
		var val = format.toString();
		for(var i = 1; i < val.length / 3; i++){
			var temp = val.slice(0, -4 * i + 1);
			val = val.replace(temp, temp + ',');
			if(val.startsWith(',')){
					val = val.substr(1, val.length-1);
				}
			}
		if(total != null && total != ''){
			jQuery("#cash_except_tax_price").val(val);
			jQuery("#except_tax_price").val(val);
			}else{
				jQuery("#cash_except_tax_price").val('0');
				jQuery("#except_tax_price").val('0');
				}
		/* jQuery("#cash_except_tax_price").val(format);
		jQuery("#except_tax_price").val(format); */
		var count = 0;
		var discount = 0;
		var except_tax = jQuery("#cash_except_tax_price").val().replace(/\,/g, "");
		var sum = 0; 
		var zero = 0;
		for(var i = 0;i<=obj.length-1;i++){
			zero = jQuery("#cash_discount_price_"+i).val();
			count += Number(zero);
			}
		for(var i = 0;i<=obj.length-1;i++){
			discount = jQuery("#cash_discount_price_"+i).val();
			sum = Math.round(Number(discount)*Number(except_tax)/(Number(count)));
			if(total != null && total != '' && discount != null && discount != '' && count != 0){
				jQuery("#cash_product_price_"+i).val(formatMoney(sum, 0, ""));
				jQuery("#cash_productPrice_"+i).val(sum);
				}else{
					jQuery("#cash_product_price_"+i).val('0');
					jQuery("#cash_productPrice_"+i).val('0');
					}
		}
		
		});
}

//商品金額（税抜）
jQuery("#cash_total_price").on('input',function(){
	var total = jQuery("#cash_total_price").val();
	var tax = Math.floor(total-(total/(1+Number(taxRate)/100)));
	var fomartTax = tax.toString();
	for(var i = 1; i < fomartTax.length / 3; i++){
		var temp = fomartTax.slice(0, -4 * i + 1);
		fomartTax = fomartTax.replace(temp, temp + ',');
		if(fomartTax.startsWith(',')){
			fomartTax = fomartTax.substr(1, fomartTax.length-1);
			}
		}
	jQuery("#cash_tax_amount").val(fomartTax);
	jQuery("#tax_amount").val(fomartTax);	
	var tax1 = jQuery("#cash_tax_amount").val().replace(/\,/g, "");
	var format = total - tax1;
	var val = format.toString();
	for(var i = 1; i < val.length / 3; i++){
		var temp = val.slice(0, -4 * i + 1);
		val = val.replace(temp, temp + ',');
		if(val.startsWith(',')){
				val = val.substr(1, val.length-1);
			}
		}
	jQuery("#cash_except_tax_price").val(val);
	jQuery("#except_tax_price").val(val);
	var count = 0;
	var discount = 0;
	var except_tax = jQuery("#cash_except_tax_price").val().replace(/\,/g, "");
	var sum = 0; 
	var zero = 0;
	for(var i = 0;i<=obj.length-1;i++){
		zero = jQuery("#cash_discount_price_"+i).val();
		count += Number(zero);
		}
	for(var i = 0;i<=obj.length-1;i++){
		discount = jQuery("#cash_discount_price_"+i).val();
		if(total != null && total != '' && discount != null && discount != '' && count != 0){
			sum = Math.round(Number(discount)*Number(except_tax)/(Number(count)));
			jQuery("#cash_product_price_"+i).val(formatMoney(sum, 0, ""));
			jQuery("#cash_productPrice_"+i).val(sum);
			}
		else{
			jQuery("#cash_product_price_"+i).val('0');
			jQuery("#cash_productPrice_"+i).val('0');
			}
	}
	
});
localStorage.clear();

jQuery('#deleteButton').on('click', function() {
	// 確認ダイアログ表示
	swal({
		text:"会計を取消してもよろしいですか？",
		icon:"info",
		buttons: ["キャンセル", true],
	}).then((willDelete) => {
		if (willDelete) {
			// OK押下時は会計一覧へ
			var version = "${cashForm.version}";
			var cashId = jQuery("#cashId").val();
			window.location.href = contextPath + "/cashConfirm/updateCash?cashId=" + cashId + "&version=" + version;
		} else {
			// Cancel押下時は何もしない
		}
	});
});

jQuery('#backButton').on('click', function() {

	//window.history.back();
	var status = "${cashForm.tscStatus}";
	if(status == "T2"){
		window.location.href= contextPath + "/orderlist/gotoOrderlist";
		}
	else{
		window.location.href= contextPath + "/accounting/init";
		}
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
