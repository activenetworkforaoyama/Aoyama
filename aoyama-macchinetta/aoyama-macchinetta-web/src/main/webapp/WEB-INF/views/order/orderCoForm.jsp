<script src="${pageContext.request.contextPath}/resources/app/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.blockUI.js"></script>
<script>
$.blockUI({ message: '<div class="content mt-3"><img src="${pageContext.request.contextPath}/resources/app/images/loading.gif" .></div>' });
</script>
<spring:eval var="sessionContent" expression="@sessionContent" />
<style type="text/css">
span {
	margin-right: 16px;
}

.error-message-list {
	margin-left:20px ;
	margin-bottom: 15px;
    padding: 10px;
    border: 1px solid;
    border-radius: 4px;
    text-shadow: 0 1px 0 #ffffff;
    background-color: #fde9f3;
    color: #b94a48;
    border-color: rgba(216, 80, 48, 0.3);
    width:800px;
}

select.hidedown {
	-webkit-appearance:none;
	-moz-appearance:none;
	appearance:none;
}
.activebk{
	border: solid 0.1px #DDD;
  	background:#fff;
}
.alert-error {
	margin-bottom: 15px;
    padding: 10px;
    border: 1px solid;
    border-radius: 4px;
    text-shadow: 0 1px 0 #ffffff;
    background: #fff1f0;
    color: #d85030;
    border-color: rgba(216, 80, 48, 0.3);
    width:800px;
}
.alert-success {
	margin-bottom: 15px;
    padding: 10px;
    border: 1px solid;
    border-radius: 4px;
    text-shadow: 0 1px 0 #ffffff;
	color: #155724;
	background-color: #d4edda;
	border-color: #c3e6cb;
	width:800px;
}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/chosen.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/bootstrap-datepicker3.css" type="text/css">

        <div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>オーダー登録</h1>
                    </div>
                </div>
            </div>
        </div>
        <spring:nestedPath path="orderCoForm">
    			<form:errors path="*" element="div" class="error-message-list" />
		</spring:nestedPath>
		<form:form id="idForm" action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm" method="post" modelAttribute="orderCoForm" class="form-horizontal">
        <div class="content mt-3">
            <div class="animated fadeIn">
            <div id="resultMessages">
            <t:messagesPanel  messagesAttributeName="resultMessages"/>
            </div>
            <div class="alert alert-error" id="errormssage" style="display:none"></div>
       		<div class="alert alert-success" id="successmssage" style="display:none"></div>
            <div class="row">
            <div class="col-lg-6">
                <div class="row">
                    <div class="col col-md-4"><label class=" form-control-label">お客様名</label></div> 
                    <div class="col-12 col-md-8" id="custNmDiv">

                    </div>
                </div>
                <div class="row">
                    <div class="col col-md-4"><label class=" form-control-label">ステータス</label></div>
                    <div class="col-12 col-md-8" id="status">
                    	<c:if test="${order.tscStatus == '' || orderCoForm.status == ''}">
                        	
                        </c:if>
                        <c:if test="${order.tscStatus == 'T0' || orderCoForm.status == 'T0'}">
                        	一時保存
                        </c:if>
                        <c:if test="${order.tscStatus == 'T1' || orderCoForm.status == 'T1'}">
                        	取り置き
                        </c:if>
                        <c:if test="${order.tscStatus == 'T2' || orderCoForm.status == 'T2'}">
                        	登録済
                        </c:if>
                        <c:if test="${order.tscStatus == 'T3' || orderCoForm.status == 'T3'}">
                         	会計済
                        </c:if>
                        <c:if test="${order.tscStatus == 'T4' || orderCoForm.status == 'T4'}">
                         	商品部承認済
                        </c:if>
                        <c:if test="${order.tscStatus == 'T5' || orderCoForm.status == 'T5'}">
                         	メーカー承認済
                        </c:if>
                        <c:if test="${order.tscStatus == 'T6' || orderCoForm.status == 'T6'}">
                         	仕入済
                        </c:if>
                        <c:if test="${order.tscStatus == 'T7' || orderCoForm.status == 'T7'}">
                         	お渡し済
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="row">
                    <div class="col text-right">
                        <strong>ご請求金額：￥<label id="askPrice">0</label>（内消費税￥<label id="excisePrice">0</label>）</strong>
                    </div>
                </div>
                <div class="row">
                    <div class="col text-right">
                       商品金額：￥<label id="goodsPrice">0</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col text-right">
                         オプション金額：￥<label id="optionPrice">0</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col text-right">
                        合計金額：￥<label id="allPrice">0</label>
                    </div>
                </div>

            </div>
            </div>
            </div>
            <div class="row">
            <div class="col-lg-6">
                                <ul class="nav nav-tabs nav-justified">
                                    <li class="nav-item">
                                        <a class="nav-link active" href="#" id="nav1_custom">お客様情報</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#" id="nav1_mejer">メジャーリング</a>
                                    </li>
                                </ul>
            </div>
            <div class="col-md-12">
            <div class="card" id="nav1_custom_div">
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-6">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">注文ID</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <input type="text" id="orderId" name="coCustomerMessageInfo.orderId" class="input-sm form-control-sm form-control" value="" readonly> -->
                                <form:input id="orderId" path="coCustomerMessageInfo.orderId" class="input-sm form-control-sm form-control" readonly = "true"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">会員番号</label></div>
                            <div class="col-12 col-md-6" style="padding-right:0;">
                                <div class="input-group">
                                	<form:input id="custCd" path="coCustomerMessageInfo.custCd" class="input-sm form-control-sm form-control" maxlength="13"/>
                                    <span class="input-group-btn"><button type="button" id="custSearchButton" class="btn btn-primary btn-sm">会員検索</button></span>
                            	</div>
                        	</div>
                            <div class="col col-md-3" style="padding-left:0;"><button type="button" id="searchButton" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#infotext_2">非会員検索</button></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">お客様氏名</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <input type="text" id="custNm" name="coCustomerMessageInfo.custNm" class="input-sm form-control-sm form-control" maxlength="50"> -->
                                <form:input id="custNm" path="coCustomerMessageInfo.custNm" class="input-sm form-control-sm form-control" maxlength="50" readonly="true"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フリガナ</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <input type="text" id="custKanaNm" name="coCustomerMessageInfo.custKanaNm" class="input-sm form-control-sm form-control" maxlength="60"> -->
                                <form:input id="custKanaNm" path="coCustomerMessageInfo.custKanaNm" class="input-sm form-control-sm form-control" maxlength="60" readonly="true"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">名簿納期</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <input type="text" autocomplete="off" id="custDeliverDate" name="coCustomerMessageInfo.custDeliverDate" placeholder="年/月/日" class="input-sm form-control-sm form-control"> -->
                                <form:input id="custDeliverDate" path="coCustomerMessageInfo.custDeliverDate" class="input-sm form-control-sm form-control" placeholder="年/月/日" autocomplete="off"/>
                            </div>
                        </div>
                    </div>
                    <div class="col col-lg-6">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">納期短縮</label></div>
                            <div class="col-12 col-md-4">
                                <!-- <select name="coCustomerMessageInfo.custIsDeliverShortning" id="expediteDelivery" class="form-control-sm form-control">
                                    <option value="0">無</option>
                                    <option value="1">有</option>
                                </select> -->
                                <%-- <form:select path="coCustomerMessageInfo.custIsDeliverShortning" id="expediteDelivery" class="form-control-sm form-control">
                                	<form:option value="0">無</form:option>
                                	<form:option value="1">有</form:option>
                                </form:select> --%>
                                <form:select id="expediteDelivery" path="custIsDeliverShortning" class="form-control-sm form-control">
                                    	<form:options items="${orderCoForm.coProductInfo.custIsDeliverShortningMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-5 text-right" id="expediteDelivery_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">早割</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <select name="coCustomerMessageInfo.custIsEarlyDiscount" id="earlyDiscount" class="form-control-sm form-control">
                                    <option value="0">無</option>
                                    <option value="1">有</option>
                                </select> -->
                                <%-- <form:select path="coCustomerMessageInfo.custIsEarlyDiscount" id="earlyDiscount" class="form-control-sm form-control">
                                	<form:option value="0">無</form:option>
                                	<form:option value="1">有</form:option>
                                </form:select> --%>
                                <form:select id="earlyDiscount" path="custIsEarlyDiscount" class="form-control-sm form-control">
                                    <form:options items="${orderCoForm.coProductInfo.custIsEarlyDiscountMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">お渡し日</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <input type="text" id="custShopDeliveryDate" name="coCustomerMessageInfo.custShopDeliveryDate" placeholder="年/月/日" class="input-sm form-control-sm form-control" readonly="readonly"> -->
                                <form:input id="custShopDeliveryDate" path="coCustomerMessageInfo.custShopDeliveryDate" class="input-sm form-control-sm form-control" placeholder="年/月/日" autocomplete="off" />
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">スタッフ</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <input type="text" id="custStaff" name="coCustomerMessageInfo.custStaff" class="input-sm form-control-sm form-control" maxlength="50"> -->
                                <form:input id="custStaff" path="coCustomerMessageInfo.custStaff" class="input-sm form-control-sm form-control" maxlength="50"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">区分</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <select name="coCustomerMessageInfo.custType" id="custType" class="form-control-sm form-control">
                                    <option value="01">一般</option>
                                    <option value="02">社着</option>
                                    <option value="03">サンプル</option>
                                    <option value="04">ゲージ</option>
                                    <option value="05">本社内見会</option>
                                    <option value="06">販売会</option>
                                    <option value="07">作り直し</option>
                                </select> -->
                                <form:select path="coCustomerMessageInfo.custType" id="custType" class="form-control-sm form-control">
                                	<form:option value="01">一般</form:option>
                                	<form:option value="02">社着</form:option>
                                	<form:option value="03">サンプル</form:option>
                                	<form:option value="04">ゲージ</form:option>
                                	<form:option value="05">本社内見会</form:option>
                                	<form:option value="06">販売会</form:option>
                                	<form:option value="07">作り直し</form:option>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">出荷先</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <select name="coCustomerMessageInfo.custShippingDestination" id="destination" class="form-control-sm form-control">
                                    <option value="01">店舗</option>
                                    <option value="02">福山本社</option>
                                    <option value="03">TSC事業本部</option>
                                    <option value="04">お客様</option>
                                    <option value="05">他店舗</option>
                                </select> -->
                                <form:select path="coCustomerMessageInfo.custShippingDestination" id="destination" class="form-control-sm form-control">
                                	<form:option value="01">店舗</form:option>
                                	<form:option value="02">福山本社</form:option>
                                	<%-- <form:option value="03">TSC事業本部</form:option> --%>
                                	<form:option value="04">お客様</form:option>
                                	<form:option value="05">他店舗</form:option>
                                </form:select>
                            </div>
                            <c:if test="${order.custShippingDestination == 05}">
                            	<div class="col-12 col-md-9 offset-md-3" id="shopNameDiv">
                                <!-- <select name="coCustomerMessageInfo.custShippingDestnationOtherstore" id="shopName" data-placeholder="店舗を選択" class="standardSelect" >
                                </select> -->
                                <form:select path="coCustomerMessageInfo.custShippingDestnationOtherstore" id="shopName" data-placeholder="店舗を選択" class="standardSelect">
                                </form:select>
                            	</div>
                            </c:if>
                            <c:if test="${order.custShippingDestination != 05}">
                            	<div class="col-12 col-md-9 offset-md-3" id="shopNameDiv" style="display:none;">
                                	<!-- <select name="coCustomerMessageInfo.custShippingDestnationOtherstore" id="shopName" data-placeholder="店舗を選択" class="standardSelect" >
                                	</select> -->
                                	<form:select path="coCustomerMessageInfo.custShippingDestnationOtherstore" id="shopName" data-placeholder="店舗を選択" class="standardSelect">
                                	</form:select>
                            	</div>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-2"     style="max-width: 12.5%;"><label class=" form-control-label">お客様備考</label></div>
                            <div class="col-12 col-md-12" style="max-width: 87.5%;">
                                <!-- <textarea name="coCustomerMessageInfo.custRemark" id="custRemark" rows="3" placeholder="" class="form-control" maxlength="500"></textarea> -->
                                <form:textarea id="custRemark" path="coCustomerMessageInfo.custRemark" rows="3" placeholder="" class="form-control" maxlength="500"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div></div>
            <div class="card" id="nav1_mejer_div" style="display:none;">
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-4">
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">フルレングス</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="fullLengthTe" name="fullLengthTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="fullLengthSe" id="fullLengthSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ショルダー</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="shoulderTe" name="shoulderTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="shoulderSe" id="shoulderSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">リーチ（右）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="reachRightTe" name="reachRightTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="reachRightSe" id="reachRightSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">リーチ（左）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="reachLeftTe" name="reachLeftTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="reachLeftSe" id="reachLeftSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col col-lg-4">
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">アウトバスト</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="outBustTe" name="outBustTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="outBustSe" id="outBustSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">バスト</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="bustTe" name="bustTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="bustSe" id="bustSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">JKウエスト</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="jacketWaistTe" name="jacketWaistTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="jacketWaistSe" id="jacketWaistSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">PTウエスト</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="pantsWaistTe" name="pantsWaistTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="pantsWaistSe" id="pantsWaistSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ヒップ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="hipTe" name="hipTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="hipSe" id="hipSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col col-lg-4">
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ワタリ（右）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="spanRightTe" name="spanRightTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="spanRightSe" id="spanRightSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ワタリ（左）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="spanLeftTe" name="spanLeftTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="spanLeftSe" id="spanLeftSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ふくらはぎ（右）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="calfRightTe" name="calfRightTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="calfRightSe" id="calfRightSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ふくらはぎ（左）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="calfLeftTe" name="calfLeftTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="calfLeftSe" id="calfLeftSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ネック</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="neckTe" name="neckTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="neckSe" id="neckSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-2"     style="max-width: 12.5%;"><label class=" form-control-label">メジャーリング備考</label></div>
                            <div class="col-12 col-md-12" style="max-width: 77.5%;">
                                <textarea name="measureringInfo" id="measureringInfo" rows="3" placeholder="" class="form-control"></textarea>
                            </div>
                            <button type="button" id="updMeasureButton" class="btn btn-info btn-sm" style="height:38px;">情報登録</button>
                        </div>
                    </div>
                </div>
            </div></div>
            </div>
            </div>
            <div class="row">
            <c:if test="${order.tscStatus == 'T0'||order.tscStatus == 'T1' ||order.tscStatus == 'T2' ||order.tscStatus == 'T3' ||order.tscStatus == 'T4' ||order.tscStatus == 'T5'||order.tscStatus == ''||order.tscStatus == null}">
            <div class="col-lg-8">
                                <ul class="nav nav-tabs nav-justified">
                                    <li class="nav-item productbox">
                                        <a class="nav-link active" href="#nav2_product" id="nav2_product">商品</a>
                                    </li>
                                    <li class="nav-item tabbox">
                                        <a class="nav-link " href="#nav2_option" id="nav2_option">オプション</a>
                                    </li>
                                    <li class="nav-item alertbox">
                                        <a class="nav-link" href="#nav2_alter" id="nav2_alter">補正</a>
                                    </li>
                                </ul>
            </div>
            </c:if>
            <c:if test="${order.tscStatus == 'T7'||order.tscStatus == 'T6' }">
					<div class="col-lg-8">
						<ul class="nav nav-tabs nav-justified">
							<li class="nav-item">
								<a class="nav-link">商品</a>
							</li>
							<li class="nav-item">
								<a class="nav-link">オプション</a>
							</li>
							<li class="nav-item">
								<a class="nav-link">補正</a>
							</li>
							<li class="nav-item">
								<a class="nav-link active" href="#" id="nav2_realter">再補正</a>
							</li>
						</ul>
					</div>
				</c:if>
            <div class="col-lg-8" style="display:none;" id="option_div">
                                <ul class="nav nav-tabs nav-justified">
                                    <li class="nav-item jacketbox" id="jacketOption">
                                    	<a href="#nav2_JACKET" class="nav-link" id="nav2_JACKET">JACKET</a>
                                    </li>
                                    <li class="nav-item giletbox" id="giletOption" style="display:none;">
                                        <a href="#nav2_GILET" class="nav-link" id="nav2_GILET">GILET</a>
                                    </li>
                                    <li class="nav-item pantsbox" id="pantsOption" style="display:none;">
                                        <a href="#nav2_PANTS" class="nav-link" id="nav2_PANTS">PANTS</a>
                                    </li>
                                    <li class="nav-item pants2box" id="pants2Option" style="display:none;">
                                        <a href="#nav2_2PANTS" class="nav-link" id="nav2_2PANTS">2PANTS</a>
                                    </li>
                                    <li class="nav-item" id="shirtOption" style="display:none;">
                                        <a href="#nav2_SHIRT" class="nav-link" id="nav2_SHIRT">SHIRT</a>
                                    </li>
                                    <li class="nav-item" id="coatOption" style="display:none;">
                                        <a href="#nav2_COAT" class="nav-link" id="nav2_COAT">COAT</a>
                                    </li>
                                </ul>
            </div>
           	<div class="col-lg-8" style="display:none;" id="option_div_adjust">
					 <ul class="nav nav-tabs nav-justified">
					 				<li class="nav-item jkadjustbox" id="itemsChoose">
                                    	<a href="#nav2_ITEMS_Ad" class="nav-link" id="nav2_ITEMS_Ad">JACKET</a>
                                    </li>
                                    <!-- <li class="nav-item jkadjustbox" id="jacketChoose">
                                    	<a href="#nav2_JACKET_Ad" class="nav-link" id="nav2_JACKET_Ad">JACKET</a>
                                    </li>
                                    <li class="nav-item gladjustbox" id="giletChoose" style="display:none;">
                                        <a href="#nav2_GILET_Ad" class="nav-link" id="nav2_GILET_Ad">GILET</a>
                                    </li>
                                    <li class="nav-item ptadjustbox" id="pantsChoose" style="display:none;">
                                        <a href="#nav2_PANTS_Ad" class="nav-link" id="nav2_PANTS_Ad">PANTS</a>
                                    </li>
                                    <li class="nav-item pt2adjustbox" id="pants2Choose" style="display:none;">
                                        <a href="#nav2_2PANTS_Ad" class="nav-link" id="nav2_2PANTS_Ad">2PANTS</a>
                                    </li>
                                    <li class="nav-item" id="shirtChoose" style="display:none;">
                                        <a href="#nav2_SHIRT_Ad" class="nav-link" id="nav2_SHIRT_Ad">SHIRT</a>
                                    </li>
                                    <li class="nav-item" id="coatChoose" style="display:none;">
                                        <a href="#nav2_COAT_Ad" class="nav-link" id="nav2_COAT_Ad">COAT</a>
                                    </li> -->
                       </ul>
              </div>	   
           
            <div class="col-md-12">
            <div class="card" id="nav2_product_div">
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ITEM</label></div>
                            <div class="col-12 col-md-3">
                                <form:select id="item" path="productItem" class="form-control-sm form-control">
                                    <form:options items="${orderCoForm.productItemMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group" id="threePiece_div">
                            <div class="col col-md-3"><label class=" form-control-label">３Piece</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="threePiece_id" path="productIs3Piece" class="form-check-input" items="${orderCoForm.coOptionGiletStandardInfo.threePieceMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="threePiece_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group" id="sparePants_div">
                            <div class="col col-md-3"><label class=" form-control-label">スペアパンツ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="sparePants_id" path="productSparePantsClass" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.twoPantsMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="sparePants_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">生地品番</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:input id="productFabricNo" path="productFabricNo" placeholder="" class="form-control-sm form-control" style="width:128px" maxlength="20" onblur="stockCheck()"/>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <output id="stockMsg"  style="display:none;"></output>
                                    <output id="fabricMsg"></output>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">カテゴリ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_1"><i class="fa fa-question-circle"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <%-- <label for="category_nomal" class="form-check-label ">
                                        <!-- <input type="radio" id="category_nomal" name="productCategory" value="0" class="form-check-input" checked>標準 -->
                                        <form:radiobutton id="category_nomal" path="productCategory" value="0" class="form-check-input"/>標準
                                    </label>　
                                    <label for="category_tuxedo" class="form-check-label ">
                                        <!-- <input type="radio" id="category_tuxedo" name="productCategory" value="2" class="form-check-input">タキシード -->
                                        <form:radiobutton id="category_tuxedo" path="productCategory" value="2" class="form-check-input"/>タキシード
                                    </label>　
                                    <label for="category_washable" class="form-check-label ">
                                        <!-- <input type="radio" id="category_washable" name="productCategory" value="1" class="form-check-input">ウォッシャブル -->
                                        <form:radiobutton id="category_washable" path="productCategory" value="1" class="form-check-input"/>ウォッシャブル
                                    </label> --%>
                                    <form:radiobuttons id="category_id" path="productCategory" class="form-check-input" items="${orderCoForm.coProductInfo.productCategoryMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group" id="lcrSewing_div">
                            <div class="col col-md-3"><label class=" form-control-label">LCR縫製</label>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <%-- <label for="lcrSewing_no" class="form-check-label ">
                                        <!-- <input type="radio" id="lcrSewing_no" name="productLcrSewing" value="0000000" class="form-check-input" checked>無し -->
                                        <form:radiobutton id="lcrSewing_no" path="productLcrSewing" value="0000000" class="form-check-input"/>無し
                                    </label>　
                                    <label for="lcrSewing_yes" class="form-check-label ">
                                        <!-- <input type="radio" id="lcrSewing_yes" name="productLcrSewing" value="0000001" class="form-check-input">有り -->
                                        <form:radiobutton id="lcrSewing_yes" path="productLcrSewing" value="0000001" class="form-check-input"/>有り
                                    </label> --%>
                                    <form:radiobuttons id="lcrSewing_id" path="productLcrSewing" class="form-check-input" items="${orderCoForm.coProductInfo.productLcrSewingMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="lcrSewing_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ブランドネーム</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <%-- <label for="brandName_ulm" class="form-check-label ">
                                        <!-- <input type="radio" id="brandName_ulm" name="productBrandNm" value="UNIVERSAL LANGUAGE MEASURE'S" class="form-check-input">UNIVERSAL LANGUAGE MEASURE'S -->
                                        <form:radiobutton id="brandName_ulm" path="productBrandNm" value="UNIVERSAL LANGUAGE MEASURE'S" class="form-check-input"/>UNIVERSAL LANGUAGE MEASURE'S
                                    </label>　
                                    <label for="brandName_hilton" class="form-check-label ">
                                        <!-- <input type="radio" id="brandName_hilton" name="productBrandNm" value="HILTON" class="form-check-input">HILTON -->
                                        <form:radiobutton id="brandName_hilton" path="productBrandNm" value="HILTON" class="form-check-input"/>HILTON
                                    </label>　
                                    <label for="brandName_no" class="form-check-label ">
                                        <!-- <input type="radio" id="brandName_no" name="productBrandNm" value="無し" class="form-check-input">無し -->
                                        <form:radiobutton id="brandName_no" path="productBrandNm" value="無し" class="form-check-input"/>無し
                                    </label> --%>
                                    <form:radiobuttons id="brandName_id" path="productBrandNm" class="form-check-input" items="${orderCoForm.coProductInfo.productBrandNmMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">生地ネーム</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <%-- <label for="clothName_yes" class="form-check-label ">
                                        <!-- <input type="radio" id="clothName_yes" name="productFabricNmNecessity" value="1" class="form-check-input" checked>有り -->
                                        <form:radiobutton id="clothName_yes" path="productFabricNmNecessity" value="1" class="form-check-input"/>有り
                                    </label>　
                                    <label for="clothName_no" class="form-check-label ">
                                        <!-- <input type="radio" id="clothName_no" name="productFabricNmNecessity" value="0" class="form-check-input">無し -->
                                        <form:radiobutton id="clothName_no" path="productFabricNmNecessity" value="0" class="form-check-input"/>無し
                                    </label> --%>
                                    <form:radiobuttons id="clothName_id" path="productFabricNmNecessity" class="form-check-input" items="${orderCoForm.coProductInfo.productFabricNmNecessityMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍入れ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <%-- <label for="embroidered_no" class="form-check-label ">
                                        <!-- <input type="radio" id="embroidered_no" name="productEmbroideryNecessity" value="0" class="form-check-input" checked>無し -->
                                        <form:radiobutton id="embroidered_no" path="productEmbroideryNecessity" value="0" class="form-check-input"/>無し
                                    </label>　
                                    <label for="embroidered_yes" class="form-check-label ">
                                        <!-- <input type="radio" id="embroidered_yes" name="productEmbroideryNecessity" value="1" class="form-check-input">有り -->
                                        <form:radiobutton id="embroidered_yes" path="productEmbroideryNecessity" value="1" class="form-check-input"/>有り
                                    </label> --%>
                                    <form:radiobuttons id="embroidered_id" path="productEmbroideryNecessity" class="form-check-input" items="${orderCoForm.coProductInfo.productEmbroideryNecessityMap}"/>
                                </div>
                            </div>
                        </div>
                        <div id="embroidered_yes_area">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍ネーム</label></div>
                            <div class="col-12 col-md-6">
                                <!-- <input type="text" id="embroideryName" name="productEmbroideryNm" class="form-control-sm form-control"> -->
                                <form:input id="embroideryName" path="productEmbroideryNm" class="form-control-sm form-control" maxlength="15"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍書体</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <%-- <label for="embroideryFont_14" class="form-check-label ">
                                        <!-- <input type="radio" id="embroideryFont_14" name="productEmbroideryFont" value="14（花文字）" class="form-check-input">14（花文字） -->
                                        <form:radiobutton id="embroideryFont_14" path="productEmbroideryFont" value="14（花文字）" class="form-check-input"/>14（花文字）
                                    </label>　
                                    <label for="embroideryFont_48" class="form-check-label ">
                                        <!-- <input type="radio" id="embroideryFont_48" name="productEmbroideryFont" value="48（ブロック）" class="form-check-input">48（ブロック） -->
                                        <form:radiobutton id="embroideryFont_48" path="productEmbroideryFont" value="48（ブロック）" class="form-check-input"/>48（ブロック）
                                    </label> --%>
                                    <form:radiobuttons id="embroideryFont_id" path="productEmbroideryFont" class="form-check-input" items="${orderCoForm.coProductInfo.productEmbroideryFontMap}"/>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row form-group" id="jkEembroideryColor">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍糸色</label></div>
                            <div class="col-12 col-md-3">
                                <!-- <select name="productEmbroideryThreadColor" id="embroideryColor" class="form-control-sm form-control">
                                    <option value="110（金茶）">110（金茶）</option>
                                    <option value="140（白）">140（白）</option>
                                </select> -->
                                <form:select id="embroideryColor" path="jkProductEmbroideryThreadColor" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionJacketStandardInfo.jkProductEmbroideryThreadColorMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="embroideryColorMsg">
                            </div>
                        </div>
                        
                        <div class="row form-group" id="stEembroideryColor" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍糸色</label></div>
                            <div class="col-12 col-md-3">
                                <!-- <select name="productEmbroideryThreadColor" id="embroideryColor" class="form-control-sm form-control">
                                    <option value="110（金茶）">110（金茶）</option>
                                    <option value="140（白）">140（白）</option>
                                </select> -->
                                <form:select id="embroideryColor" path="stProductEmbroideryThreadColor" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionShirtStandardInfo.stProductEmbroideryThreadColorMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="embroideryColorMsg">
                            </div>
                        </div>
                        
                        <div id="embroidered_shirts_area">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍箇所</label></div>
                            <div class="col col-md-4">
                                <!-- <select name="productEmbroideryNmPos" id="productEmbroideryNmPos" class="form-control-sm form-control">
                                    <option value="" selected>無し</option>
                                    <option value="上前胸">上前胸</option>
                                    <option value="上前腰">上前腰</option>
                                    <option value="上前二の腕">上前二の腕</option>
                                    <option value="上前カフス">上前カフス</option>
                                    <option value="下前カフス">下前カフス</option>
                                </select> -->
                                <%-- <form:select id="productEmbroideryNmPos" path="productEmbroideryNmPos" class="form-control-sm form-control">
                                	<form:option value="無し">無し</form:option>
                                	<form:option value="上前胸">上前胸</form:option>
                                	<form:option value="上前腰">上前腰</form:option>
                                	<form:option value="上前二の腕">上前二の腕</form:option>
                                	<form:option value="上前カフス">カフス</form:option>
                                	<form:option value="下前カフス">下前カフス</form:option>
                                </form:select> --%>
                                <form:select id="productEmbroideryNmPos" path="productEmbroideryNmPos" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionShirtStandardInfo.productEmbroideryNmPosMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-5" align="right">
                            	<output id="embroideryNmPos_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍サイズ</label></div>
                            <div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                縦　
                                <a href="#" id="embroideryHeightRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="embroideryHeightRange" name="productEmbroideryLength" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="embroideryHeightRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="embroideryHeightRange_out">0</output>cm
                                </div>
                                <div class="col-12 col-md-2" id="embroideryHeight_div"
							style="display: none">
							<output id="embroideryHeight_div_html">000.0cm</output>
						</div>
                            </div>
                            <div class="col-12 col-md-4 offset-md-3">
                                <div class="form-check-inline form-check">
                                横　
                                <a href="#" id="embroideryWidthRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="embroideryWidthRange" name="productEmbroideryWidth" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="embroideryWidthRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="embroideryWidthRange_out">0</output>cm
                                </div>
                                <div class="col-12 col-md-2" id="embroideryWidth_div"
							style="display: none">
							<output id="embroideryWidth_div_html">000.0cm</output>
						</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ガゼット刺繍</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <%-- <label for="gadget_no" class="form-check-label ">
                                        <!-- <input type="radio" id="gadget_no" name="productEmbroideryGazette" value="0000000" class="form-check-input" checked>無し -->
                                        <form:radiobutton id="gadget_no" path="productEmbroideryGazette" value="0000000" class="form-check-input"/>無し
                                    </label>　
                                    <label for="gadget_yes" class="form-check-label ">
                                        <!-- <input type="radio" id="gadget_yes" name=productEmbroideryGazette value="0000001" class="form-check-input">有り -->
                                        <form:radiobutton id="gadget_yes" path="productEmbroideryGazette" value="0000001" class="form-check-input"/>有り
                                    </label> --%>
                                    <form:radiobuttons id="gadget_id" path="productEmbroideryGazette" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.productEmbroideryGazetteMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="gadget_Msg"></output>
                            </div>
                        </div>
                        </div>
                        </div>
                        <div class="row form-group" id="cloth_div">
                            <div class="col col-md-3"><label class=" form-control-label">残布</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <%-- <label for="cloth_small" class="form-check-label ">
                                        <!-- <input type="radio" id="cloth_small" name="productRemainingClothType" value="01" class="form-check-input">小（通常） -->
                                        <form:radiobutton id="cloth_small" path="productRemainingClothType" value="01" class="form-check-input"/>小（通常）
                                    </label>　
                                    <label for="cloth_big" class="form-check-label ">
                                        <!-- <input type="radio" id="cloth_big" name="productRemainingClothType" value="02" class="form-check-input">大（タテ15cm×ヨコ15cm） -->
                                        <form:radiobutton id="cloth_big" path="productRemainingClothType" value="02" class="form-check-input"/>大（タテ15cm×ヨコ15cm）
                                    </label> --%>
                                    <form:radiobuttons id="cloth_id" path="productRemainingClothType" class="form-check-input" items="${orderCoForm.coProductInfo.productRemainingClothTypeMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">生地ブランド</label></div>
                            <div class="col-12 col-md-9">
                                <p id="fabric_brand_nm_p" class="form-control-static"></p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">素材名</label></div>
                            <div class="col-12 col-md-9">
                                <p id="service_nm_p" class="form-control-static"></p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">組成表示　表地</label></div>
                            <div class="col-12 col-md-9">
                                <p id="compos_frt_fabric_p" class="form-control-static"></p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">組成表示　胴裏地</label></div>
                            <div class="col-12 col-md-9">
                                <p id ="compos_body_liner_p" class="form-control-static"></p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">組成表示　袖裏地</label></div>
                            <div class="col-12 col-md-9">
                                <p id ="compos_sleeve_liner_p" class="form-control-static"></p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">取扱注意</label></div>
                            <div class="col-12 col-md-9">
                                <p id="notice" class="form-control-static"></p>
                            </div>
                        </div>
                    </div>
                </div>

            </div></div>
            
            <div class="card" id="nav2_div_option" style="display:none;">
           		<div id="nav2_Div"></div>
            </div>
            
            <div class="card" id="nav3_div_choose" style="display:none;">
           		<div id="nav3_Div"></div>
            </div>  
           
            </div>
            <!-- 再補正タブ内容 Start -->
		    <c:if test="${order.tscStatus == 'T7'||order.tscStatus == 'T6' }">
		    <div class="col-md-12">
		    <div class="card" id="nav2_realter_div">
		    <div id="re_jacket_div">
			<div class="card-header">
				<strong class="card-title">JACKET</strong>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col col-lg-12">
						<div class="row">
						<div class="col-12 col-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
						<div class="col-12 col-md-9" id="corJkBodylengthCorrectAgain">
							<a id="corJkBody_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corJkBody_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corJkBodyRe" name="coAdjustJacketStandardInfo.corJkBodylengthCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-9" id="corJkWaistCorrectAgain">
							<a id="corJkWaist_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corJkWaist_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corJkWaistRe" name="coAdjustJacketStandardInfo.corJkWaistCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">袖丈右修正</label>
						</div>
						<div class="col-12 col-md-9" id="corJkRightsleeveCorrectAgain">
							<a id="corJkRightsleeve_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corJkRightsleeve_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corJkRightsleeveRe" name="coAdjustJacketStandardInfo.corJkRightsleeveCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">袖丈左修正</label>
						</div>
						<div class="col-12 col-md-9" id="corJkLeftsleeveCorrectAgain">
							<a id="corJkLeftsleeve_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corJkLeftsleeve_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corJkLeftsleeveRe" name="coAdjustJacketStandardInfo.corJkLeftsleeveCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
							</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		    <div id="re_gilet_div">
			<div class="card-header">
				<strong class="card-title">GILET</strong>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col col-lg-12">
						<div class="row">
							<div class="col-12 col-md-3">
								<label class=" form-control-label">着丈修正</label>
							</div>
							<div class="col-12 col-md-9" id="corGlBodylengthCorrectAgain">
								<a id="corGlBodylength_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corGlBodylength_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corGlBodylengthRe" name="coAdjustGiletStandardInfo.corGlBodylengthCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">バスト修正</label>
						</div>
						<div class="col-12 col-md-9" id="corGlBustCorrectAgain">
							<a id="corGlBustCorrect_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corGlBustCorrect_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corGlBustCorrectRe" name="coAdjustGiletStandardInfo.corGlBustCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-9" id="corGlWaistCorrectAgain">
							<a id="corGlWaistCorrect_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corGlWaistCorrect_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corGlWaistCorrectRe" name="coAdjustGiletStandardInfo.corGlWaistCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="re_pants_div">
			<div class="card-header">
				<strong class="card-title">PANTS</strong>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col col-lg-12">
						<div class="row">
							<div class="col-12 col-md-3">
								<label class=" form-control-label">ウエスト修正</label>
							</div>
							<div class="col-12 col-md-9" id="corPtWaistCorrectAgain">
								<a id="corPtWaist_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corPtWaist_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corPtWaistRe" name="coAdjustPantsStandardInfo.corPtWaistCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ヒップ修正</label>
						</div>
						<div class="col-12 col-md-9" id="corPtHipCorrectAgain">
							<a id="corPtHip_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corPtHip_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corPtHipRe" name="coAdjustPantsStandardInfo.corPtHipCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ワタリ幅修正</label>
						</div>
						<div class="col-12 col-md-9" id="corPtThighwidthCorrectAgain">
							<a id="corPtThighwidth_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corPtThighwidth_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corPtThighwidthRe" name="coAdjustPantsStandardInfo.corPtThighwidthCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">裾幅修正</label>
						</div>
						<div class="col-12 col-md-9" id="corPtHemwidthCorrectAgain">
							<a id="corPtHemwidth_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corPtHemwidth_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corPtHemwidthRe" name="coAdjustPantsStandardInfo.corPtHemwidthCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">股下右修正</label>
						</div>
						<div class="col-12 col-md-9" id="corPtRightinseamCorrectAgain">
							<a id="corPtRightinseam_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corPtRightinseam_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corPtRightinseamRe" name="coAdjustPantsStandardInfo.corPtRightinseamCorrectAgain" placeholder="0" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">股下左修正</label>
						</div>
						<div class="col-12 col-md-9" id="corPtLeftinseamCorrectAgain">
							<a id="corPtLeftinseam_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corPtLeftinseam_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corPtLeftinseamRe" name="coAdjustPantsStandardInfo.corPtLeftinseamCorrectAgain" placeholder="0" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="re2_pants_div">
			<div class="card-header">
				<strong class="card-title">PANTS（2本目）　</strong>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col col-lg-12">
						<div class="row">
							<div class="col-12 col-md-3">
								<label class=" form-control-label">ウエスト修正</label>
							</div>
							<div class="col-12 col-md-9" id="corPt2WaistCorrectAgain">
								<a id="corPt2Waist_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corPt2Waist_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corPt2WaistRe" name="coAdjustPants2StandardInfo.corPt2WaistCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ヒップ修正</label>
						</div>
						<div class="col-12 col-md-9" id="corPt2HipCorrectAgain">
							<a id="corPt2Hip_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corPt2Hip_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corPt2HipRe" name="coAdjustPants2StandardInfo.corPt2HipCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ワタリ幅修正</label>
						</div>
						<div class="col-12 col-md-9" id="corPt2ThighwidthCorrectAgain">
							<a id="corPt2Thighwidth_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corPt2Thighwidth_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corPt2ThighwidthRe" name="coAdjustPants2StandardInfo.corPt2ThighwidthCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">裾幅修正</label>
						</div>
						<div class="col-12 col-md-9" id="corPt2HemwidthCorrectAgain">
							<a id="corPt2Hemwidth_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corPt2Hemwidth_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corPt2HemwidthRe" name="coAdjustPants2StandardInfo.corPt2HemwidthCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">股下右修正</label>
						</div>
						<div class="col-12 col-md-9" id="corPt2RightinseamCorrectAgain">
							<a id="corPt2Rightinseam_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corPt2Rightinseam_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corPt2RightinseamRe" name="coAdjustPants2StandardInfo.corPt2RightinseamCorrectAgain" placeholder="0" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">股下左修正</label>
						</div>
						<div class="col-12 col-md-9" id="corPt2LeftinseamCorrectAgain">
							<a id="corPt2Leftinseam_range_1_m" class="re_alter_sign minus" style="display:none;">
								<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
							</a>
							<a id="corPt2Leftinseam_range_1_p" class="re_alter_sign plus">
								<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
							</a>
							<div style="float:left;">&nbsp;</div>
							<input type="text" id="corPt2LeftinseamRe" name="coAdjustPants2StandardInfo.corPt2LeftinseamCorrectAgain" placeholder="0" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
							<div style="float:left;">&nbsp;cm</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="re_memo_div">
				<div class="card-header">
					<strong class="card-title">コメント入力欄</strong>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col col-lg-10">
						<textarea id="corStoreCorrectionMemoAgain" name="corStoreCorrectionMemoAgain" rows="3" class="form-control" maxlength="500"></textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		</c:if>
		<!-- 再補正タブ内容 End -->
            </div>
            <c:if test="${(order==''||order==null||order.tscStatus == null)&&(orderCoForm.status==''||orderCoForm.status=='T0'||orderCoForm.status=='T1')}">
            <div class="row">
            <div class="col-md-12">
            <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col">
                <button id="temporarySave" type="button" class="btn btn-info btn-block"><i class="fa fa-save"></i> 一時保存</button>
                    </div>
                    <div class="col">
                <button id="layUpSave" type="button" class="btn btn-warning btn-block"><i class="fa fa-save"></i> 取り置き</button>
                    </div>
                    <div class="col">
                <button id="coConfirm" type="submit" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i> 内容確認</button>
                    </div>
                    <div class="col">
                <button type="button" id= "deleteButton" class="btn btn-danger btn-block"><i class="fa fa-trash-alt"></i> 注文削除</button>
                    </div>
                </div>
            </div>
            </div>
            </div>
            </div>
            </c:if>
            <c:if test="${order.tscStatus == 'T2'||order.tscStatus == 'T3'||order.tscStatus == 'T4'||order.tscStatus == 'T5'||orderCoForm.status == 'T2'||orderCoForm.status == 'T3'||orderCoForm.status == 'T4'||orderCoForm.status == 'T5'}">
            <div class="row">
            <div class="col-md-12">
            <div class="card">
            <div class="card-body">
            
            
                <div class="row">
                    <div class="col">
                    </div>
                    	<div class="col col-md-3">
                			<button id="coConfirm" type="submit" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i> 内容確認</button>
                    	</div>
                    	<div class="col col-md-3">
                			<button id="cancelButton" type="button" class="btn btn-danger btn-block"><i class="fa fa-trash-alt"></i> 注文取消</button>
                    	</div>
                    <div class="col">
                    </div>
                </div>
            
            </div>
            </div>
            </div>
            </div>
            </c:if>
            <c:if test="${order.tscStatus == 'T0'||order.tscStatus == 'T1'||order.tscStatus == ''}">
            <div class="row">
            <div class="col-md-12">
            <div class="card">
            
           
            	<div class="card-body">
                <div class="row">
                    <div class="col">
                <button type="button" id="temporarySave" class="btn btn-info btn-block"><i class="fa fa-save"></i> 一時保存</button>
                    </div>
                    <div class="col">
                <button type="button" id="layUpSave" class="btn btn-warning btn-block"><i class="fa fa-save"></i> 取り置き</button>
                
                    </div>
                    <div class="col">
                <button id = "coConfirm" type="submit" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i> 内容確認</button>
                    </div>
                    	<div class="col">
                			<button type="button" id= "deleteButton" class="btn btn-danger btn-block"><i class="fa fa-trash-alt"></i> 注文削除</button>
                    	</div>
                </div>
            </div>
            </div>
            </div>
            </div>
            </c:if>
            <c:if test="${order.tscStatus == 'T7'||order.tscStatus == 'T6'}">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-body" id="realter_div">
							<div class="row">
								<div class="col">
									<div class="col col-md-4"></div>
									<div class="col col-md-4">
										<button id="entryButton" type="button" class="btn btn-primary btn-block" onclick="return entryCheck();">
											<i class="fa fa-check-circle"></i> 確定
										</button>
									</div>
									<div class="col col-md-4"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</c:if>
            </div>   
            
            <!-- メジャーリング -->   
            <input type="hidden" id="fullLength" name="CoMeasuringInfo.fullLength"  value="" />
            <input type="hidden" id="shoulder" name="CoMeasuringInfo.shoulder"  value=""/>
            <input type="hidden" id="reachRight" name="CoMeasuringInfo.reachRight"  value="" />
            <input type="hidden" id="reachLeft" name="CoMeasuringInfo.reachLeft"  value="" />
            <input type="hidden" id="outBust" name="CoMeasuringInfo.outBust"  value="" />
            <input type="hidden" id="bust" name="CoMeasuringInfo.bust"  value="" />
            <input type="hidden" id="jacketWaist" name="CoMeasuringInfo.jacketWaist"  value="" />
            <input type="hidden" id="pantsWaist" name="CoMeasuringInfo.pantsWaist"  value="" />
            <input type="hidden" id="hip" name="CoMeasuringInfo.hip"  value="" />
            <input type="hidden" id="spanRight" name="CoMeasuringInfo.spanRight"  value="" />
            <input type="hidden" id="spanLeft" name="CoMeasuringInfo.spanLeft"  value="" />
            <input type="hidden" id="calfRight" name="CoMeasuringInfo.calfRight"  value="" />
            <input type="hidden" id="calfLeft" name="CoMeasuringInfo.calfLeft"  value="" />
            <input type="hidden" id="neck" name="CoMeasuringInfo.neck"  value="" />
			<input type="hidden" id="statusInput" name="status"  value="" />
			<!-- 商品 -->
			<!-- 生地ブランド  -->
			<input type="hidden" id="productFabricBrandNm"  name="productFabricBrandNm"   value="" />
			<!-- サービスネーム -->
			<input type="hidden" id="productServiceNm"  name="productServiceNm"   value="" />
			<!-- 組成表示_胴裏地 -->
			<input type="hidden" id="productComposBodyLiner"  name="productComposBodyLiner"   value="" />
			<!-- 組成表示_袖裏地 -->
			<input type="hidden" id="productComposSleeveLiner"  name="productComposSleeveLiner"   value="" />
			<!-- 組成表示_表地 -->
			<input type="hidden" id="productComposFrtFabric"  name="productComposFrtFabric"   value="" />
			<!-- 取扱注意 -->
			<input type="hidden" id="productNotice"  name="productNotice"   value="" />
			<!-- ご請求金額 -->
			<input type="hidden" id="billingAmountId"  name="billingAmount"   value="${orderCoForm.billingAmount}" />
			<!-- 商品金額 -->
			<input type="hidden" id="productPriceId"  name="productPrice"   value="${orderCoForm.productPrice}" />
			<!-- オプション金額 -->
			<input type="hidden" id="optionPriceId"  name="optionPrice"   value="${orderCoForm.optionPrice}" />
			<input type="hidden" id="jkOptionPriceId"  name="jkOptionPrice"   value="${orderCoForm.jkOptionPrice}" />
            <input type="hidden" id="ptOptionPriceId"  name="ptOptionPrice"   value="${orderCoForm.ptOptionPrice}" />
            <input type="hidden" id="pt2OptionPriceId"  name="pt2OptionPrice"   value="${orderCoForm.pt2OptionPrice}" />
            <input type="hidden" id="glOptionPriceId"  name="glOptionPrice"   value="${orderCoForm.glOptionPrice}" />
            <input type="hidden" id="ctOptionPriceId"  name="ctOptionPrice"   value="${orderCoForm.ctOptionPrice}" />
            <input type="hidden" id="stOptionPriceId"  name="stOptionPrice"   value="${orderCoForm.stOptionPrice}" />
            <input type="hidden" id="jkDoubleModelPrice"  name="jkDoubleModelPrice"   value="${orderCoForm.jkDoubleModelPrice}" />
            <input type="hidden" id="glDoubleModelPrice"  name="glDoubleModelPrice"   value="${orderCoForm.glDoubleModelPrice}" />
            <input type="hidden" id="ctDoubleModelPrice"  name="ctDoubleModelPrice"   value="${orderCoForm.ctDoubleModelPrice}" />
			<!-- 合計金額 -->
			<input type="hidden" id="totalPriceId"  name="totalPrice"   value="${orderCoForm.totalPrice}" />
			<!-- 内消費税 -->
			<input type="hidden" id="consumptionTaxAmountId"  name="consumptionTaxAmount"   value="${orderCoForm.consumptionTaxAmount}" />
			<!-- 生地色 -->
			<input type="hidden" id="fabricColor"  name="fabricColor"   value="" />
			<!-- 生地柄 -->
			<input type="hidden" id="fabricPattern"  name="fabricPattern"   value="" />
			<!-- バージョン -->
			<input type="hidden" id="version"  name="version"  value="${orderCoForm.version }" />
			<!-- 非画面表示 -->
			<!-- オーダーパターン -->
			<input type="hidden" id="orderPattern" name="orderPattern" value="CO">
			
			<input type="hidden" id="shopCode"  name="shopCode"   value="${sessionContent.belongCode}" />
			
			<input type="hidden" id="factoryCode"  name="productFactoryCd"   value="" />
			
			<input type="hidden" id="makerCode"  name="productMakerCode"   value="" />
			
			<input type="hidden" id="storeBrandCode"  name="storeBrandCode"   value="${sessionContent.storeBrandCode}" />
			
			<input type="hidden" id="storeNm"  name="storeNm"   value="${sessionContent.belongName}" />
			
			<input type="hidden" id="saveFlag"  name="saveFlag"   value="" />
			
			<input type="hidden" id="fabricFlag"  name="fabricFlag"   value="${orderCoForm.fabricFlag}" />
			
			<input type="hidden" id="orderTscStatus"  name="orderTscStatus"   value="${orderCoForm.orderTscStatus}" />
			
			<input type="hidden" id="jkModelFlag"  name="jkModelFlag"   value="0" />
			<input type="hidden" id="glModelFlag"  name="glModelFlag"   value="0" />
			<input type="hidden" id="ptModelFlag"  name="ptModelFlag"   value="0" />
			<input type="hidden" id="pt2ModelFlag"  name="pt2ModelFlag"   value="0" />
			<input type="hidden" id="ctModelFlag"  name="pt2ModelFlag"   value="0" />
			<input type="hidden" id="shModelFlag"  name="pt2ModelFlag"   value="0" />
			
			<input type="hidden" id="expediteDeliveryPrice" name="expediteDeliveryPrice" value="0"/>
			<input type="hidden" id="lcrSewingPrice" name="lcrSewingPrice" value="0"/>
			<input type="hidden" id="gadgetPrice" name="gadgetPrice" value="0"/>
			<input type="hidden" id="embroideryNmPosPrice" name="embroideryNmPosPrice" value="0"/>
			<input type="hidden" id="versionFlag"  name="versionFlag" value="" />
			<input type="hidden" id="jacketFlag" name="jacketFlag" value="${orderCoForm.jacketFlag}"/>
			<input type="hidden" id="giletFlag" name="giletFlag" value="${orderCoForm.giletFlag}"/>
			<input type="hidden" id="pantsFlag" name="pantsFlag" value="${orderCoForm.pantsFlag}"/>
			<input type="hidden" id="pants2Flag" name="pants2Flag" value="${orderCoForm.pants2Flag}"/>
			
			<c:if test="${orderCoForm.orderFlag == 'orderCo'}">
				<input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="0"/>
				<input type="hidden" id="pantsItemFlag" name="pantsItemFlag" value="0"/>
				<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="0"/>
				<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="0"/>
				<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="0"/>
				<input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="0"/>
			</c:if>
			<c:if test="${orderCoForm.orderFlag == 'orderLink'|| orderCoForm.orderFlag == 'orderDivert'}">
				<input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="1"/>
				<input type="hidden" id="pantsItemFlag" name="pantsItemFlag" value="1"/>
				<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="1"/>
				<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="1"/>
				<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="1"/>
				<input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="1"/>
			</c:if>
					
			<input type="hidden" id="itemCoFlag" name="itemCoFlag" value="0"/>
			<input type="hidden" id="itemCoChangeFlag" name="itemCoChangeFlag" value="888888"/>
			
			<input type="hidden" id="jacketAdFlag" name="jacketAdFlag" value=""/>
			<input type="hidden" id="pantsAdFlag" name="pantsAdFlag" value=""/>
			<input type="hidden" id="pants2AdFlag" name="pants2AdFlag" value=""/>
			<input type="hidden" id="giletAdFlag" name="giletAdFlag" value=""/>
			<input type="hidden" id="coatAdFlag" name="coatAdFlag" value=""/>
			<input type="hidden" id="shirtAdFlag" name="shirtAdFlag" value=""/>
			<!-- 理論在庫 -->　
			<input type="hidden" id="theoryFabricUsedMountId" name="theoryFabricUsedMount" value="">
			<!--  Shirt -->
            <input type="hidden" id="embroideryHeight_div_Size" name="adjustShirtStandardInfo.embroideryHeightSize" value="" />
	        <input type="hidden" id="embroideryHeight_div_Gross" name="adjustShirtStandardInfo.embroideryHeightGross" value="" />
		    <input type="hidden" id="embroideryWidth_div_Size" name="adjustShirtStandardInfo.embroideryWidthSize" value="" />
	        <input type="hidden" id="embroideryWidth_div_Gross" name="adjustShirtStandardInfo.embroideryWidthGross" value="" />
            <c:if test="${order.tscStatus == 'T7'||order.tscStatus == 'T6'}">
            <!-- 再補正フラッグ -->
			<!-- JACKET -->
			<input type="hidden" id="corJkBodyRe_Flag"  name="coAdjustJacketStandardInfo.corJkBodylengthCorrectAgainFlag" value="1" />
			<input type="hidden" id="corJkWaistRe_Flag"  name="coAdjustJacketStandardInfo.corJkWaistCorrectAgainFlag" value="1" />
			<input type="hidden" id="corJkRightsleeveRe_Flag"  name="coAdjustJacketStandardInfo.corJkRightsleeveCorrectAgainFlag" value="1" />
			<input type="hidden" id="corJkLeftsleeveRe_Flag"  name="coAdjustJacketStandardInfo.corJkLeftsleeveCorrectAgainFlag" value="1" />
			<!-- PANTS -->
			<input type="hidden" id="corPtWaistRe_Flag"  name="coAdjustPantsStandardInfo.corPtWaistCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPtHipRe_Flag"  name="coAdjustPantsStandardInfo.corPtHipCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPtThighwidthRe_Flag"  name="coAdjustPantsStandardInfo.corPtThighwidthCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPtHemwidthRe_Flag"  name="coAdjustPantsStandardInfo.corPtHemwidthCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPtRightinseamRe_Flag"  name="coAdjustPantsStandardInfo.corPtRightinseamCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPtLeftinseamRe_Flag"  name="coAdjustPantsStandardInfo.corPtLeftinseamCorrectAgainFlag" value="1" />
			<!-- GILET -->
			<input type="hidden" id="corGlBodylengthRe_Flag"  name="coAdjustGiletStandardInfo.corGlBodylengthCorrectAgainFlag" value="1" />
			<input type="hidden" id="corGlBustCorrectRe_Flag"  name="coAdjustGiletStandardInfo.corGlBustCorrectAgainFlag" value="1" />
			<input type="hidden" id="corGlWaistCorrectRe_Flag"  name="coAdjustGiletStandardInfo.corGlWaistCorrectAgainFlag" value="1" />
			<!-- 2PANTS -->
			<input type="hidden" id="corPt2WaistRe_Flag"  name="coAdjustPants2StandardInfo.corPt2WaistCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPt2HipRe_Flag"  name="coAdjustPants2StandardInfo.corPt2HipCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPt2ThighwidthRe_Flag"  name="coAdjustPants2StandardInfo.corPt2ThighwidthCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPt2HemwidthRe_Flag"  name="coAdjustPants2StandardInfo.corPt2HemwidthCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPt2RightinseamRe_Flag"  name="coAdjustPants2StandardInfo.corPt2RightinseamCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPt2LeftinseamRe_Flag"  name="coAdjustPants2StandardInfo.corPt2LeftinseamCorrectAgainFlag" value="1" />
			</c:if>
            </form:form>
          <div class="modal fade" id="infotext_2" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog modal-lg" role="document" style="max-width:900px;">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">非会員検索</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="content mt-3">
                    <form action="" id="frmSearch" method="post" enctype="multipart/form-data" class="form-horizontal">
                        <input type="hidden" id="chkSearch" value="">
                        <ul class="nav nav-tabs nav-justified">
                            <li class="nav-item">
                                <a class="nav-link active" href="#" id="nav3_search">検索</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#" id="nav3_regist">登録</a>
                            </li>
                        </ul>
                        <div class="card" id="nav3_search_div">
                            <div class="card-body">
                                <!-- 検索条件部分 Start -->
                                <div class="row">
                                    <!-- 左側項目 -->
                                    <div class="col col-lg-6">
                                        <div class="row form-group">
                                            <div class="col col-md-4"><label class=" form-control-label">電話番号</label><span class="text-danger">*</span></div>
                                            <div class="col-12 col-md-8">
                                                <input type="text" id="searchTelNo" name="text-input" placeholder="" class="input-sm form-control-sm form-control">
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-4"><label class=" form-control-label">姓（カナ）</label><span class="text-danger">*</span></div>
                                            <div class="col-12 col-md-8">
                                                <input type="text" id="searchSei" name="text-input" placeholder="" class="input-sm form-control-sm form-control zentohan">
                                            </div>
                                        </div>
                                    </div>
                                    <!-- 右側項目 -->
                                    <div class="col col-lg-6">
                                        <div class="row form-group">
                                            <div class="col col-md-4"><label class=" form-control-label">　</label></div>
                                            <div class="col-12 col-md-8">　</div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-4"><label class=" form-control-label">名（カナ）</label><span class="text-danger">*</span></div>
                                            <div class="col-12 col-md-8">
                                                <input type="text" id="searchMei" name="text-input" placeholder="" class="input-sm form-control-sm form-control zentohan">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- 制御ボタン部分 Start -->
                                <div class="row">
                                    <div class="col">　</div>
                                    <div class="col col-md-4">
                                        <button type="button" id="clearButton" class="btn btn-danger btn-block"><i class="fa fa-trash-o"></i> クリア</button>
                                    </div>
                                    <div class="col col-md-4">
                                        <button type="button" id="search2Button" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i> 検索</button>
                                    </div>
                                    <div class="col">　</div>
                                </div>
                                <!-- 制御ボタン部分 End -->
                            </div><!-- card body -->
                            <div class="card" id="areaResult" style="display:none;">
                                <div class="card-body" id="areaResult1">
                                    <div class="row">
                                        <div class="col">
                                            <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!-- card -->
                        <div class="card" id="nav3_regist_div">
                            <div class="card-body">
                                <!-- 登録部分 Start -->
                                <div class="row">
                                    <!-- 左側項目 -->
                                    <div class="col col-lg-6">
                                        <div class="row form-group">
                                            <div class="col col-md-4"><label class=" form-control-label">電話番号</label><span class="text-danger">*</span></div>
                                            <div class="col-12 col-md-8">
                                                <input type="text" id="updTelNo" name="text-input" placeholder="" class="input-sm form-control-sm form-control" tabindex="1">
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-4"><label class=" form-control-label">姓（カナ）</label><span class="text-danger">*</span></div>
                                            <div class="col-12 col-md-8">
                                                <input type="text" id="updSei" name="text-input" placeholder="" class="input-sm form-control-sm form-control zentohan" tabindex="2">
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-4"><label class=" form-control-label">姓</label></div>
                                            <div class="col-12 col-md-8">
                                                <input type="text" id="updSeiJ" name="text-input" placeholder="" class="input-sm form-control-sm form-control" tabindex="4">
                                            </div>
                                        </div>
                                    </div>
                                    <!-- 右側項目 -->
                                    <div class="col col-lg-6">
                                        <div class="row form-group">
                                            <div class="col col-md-4"><label class=" form-control-label">　</label></div>
                                            <div class="col-12 col-md-8">　</div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-4"><label class=" form-control-label">名（カナ）</label><span class="text-danger">*</span></div>
                                            <div class="col-12 col-md-8">
                                                <input type="text" id="updMei" name="text-input" placeholder="" class="input-sm form-control-sm form-control zentohan" tabindex="3">
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-4"><label class=" form-control-label">名</label></div>
                                            <div class="col-12 col-md-8">
                                                <input type="text" id="updMeiJ" name="text-input" placeholder="" class="input-sm form-control-sm form-control" tabindex="5">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col col-lg-12">
                                        <div class="row form-group">
                                            <div class="col col-md-2"><label class=" form-control-label small">メールアドレス</label></div>
                                            <div class="col-12 col-md-10">
                                                <input type="text" id="updEmail" name="text-input" placeholder="" class="input-sm form-control-sm form-control" tabindex="6">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- 検索条件部分 End -->
                                <!-- 制御ボタン部分 Start -->
                                <div class="row">
                                    <div class="col">　</div>
                                    <div class="col-md-6">
                                        <button type="button" id="registButton" class="btn btn-info btn-block"><i class="fa fa-save"></i> 入力内容で登録</button>
                                    </div>
                                    <div class="col">　</div>
                                </div>
                                <!-- 制御ボタン部分 End -->
                            </div><!-- card body -->
                        </div><!-- card -->
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>                          
<!-- 説明テキスト -->
<div class="modal fade" id="infotext_1" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
<div class="modal-dialog modal-lg" role="document">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title" id="mediumModalLabel">カテゴリ</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body">
<p>
カテゴリの説明<br />
カテゴリの説明<br />
カテゴリの説明<br />
カテゴリの説明<br />
カテゴリの説明
</p>
</div>
<div class="modal-footer">
<button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
</div>
</div>
</div>
</div>


<script src="${pageContext.request.contextPath}/resources/app/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script> 
<script src="${pageContext.request.contextPath}/resources/app/js/chosen.jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/bootstrap-datepicker.js"></script>


<!-- 自作js -->
<script src="${pageContext.request.contextPath}/resources/app/self/js/rule.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/config.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/customer.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/tabMenu.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/product.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var jacketTwiceflag = '0';
var pantsTwiceflag = '0';
var pants2Twiceflag = '0';
var	giletTwiceflag = '0';
var orderFlag = "${orderCoForm.orderFlag}";
function zenkakuToHankaku(mae){
	  let zen = new Array('ア','イ','ウ','エ','オ','カ','キ','ク','ケ','コ','サ','シ','ス','セ','ソ','タ','チ','ツ','テ','ト','ナ','ニ','ヌ','ネ','ノ','ハ','ヒ','フ','ヘ','ホ','マ','ミ','ム','メ','モ','ヤ','ヰ','ユ','ヱ','ヨ','ラ','リ','ル','レ','ロ','ワ','ヲ','ン','ガ','ギ','グ','ゲ','ゴ','ザ','ジ','ズ','ゼ','ゾ','ダ','ヂ','ヅ','デ','ド','バ','ビ','ブ','ベ','ボ','パ','ピ','プ','ペ','ポ','ァ','ィ','ゥ','ェ','ォ','ャ','ュ','ョ','ッ','゛','°','、','。','「','」','ー','・');
	  let han = new Array('ｱ','ｲ','ｳ','ｴ','ｵ','ｶ','ｷ','ｸ','ｹ','ｺ','ｻ','ｼ','ｽ','ｾ','ｿ','ﾀ','ﾁ','ﾂ','ﾃ','ﾄ','ﾅ','ﾆ','ﾇ','ﾈ','ﾉ','ﾊ','ﾋ','ﾌ','ﾍ','ﾎ','ﾏ','ﾐ','ﾑ','ﾒ','ﾓ','ﾔ','ｲ','ﾕ','ｴ','ﾖ','ﾗ','ﾘ','ﾙ','ﾚ','ﾛ','ﾜ','ｦ','ﾝ','ｶﾞ','ｷﾞ','ｸﾞ','ｹﾞ','ｺﾞ','ｻﾞ','ｼﾞ','ｽﾞ','ｾﾞ','ｿﾞ','ﾀﾞ','ﾁﾞ','ﾂﾞ','ﾃﾞ','ﾄﾞ','ﾊﾞ','ﾋﾞ','ﾌﾞ','ﾍﾞ','ﾎﾞ','ﾊﾟ','ﾋﾟ','ﾌﾟ','ﾍﾟ','ﾎﾟ','ｧ','ｨ','ｩ','ｪ','ｫ','ｬ','ｭ','ｮ','ｯ','ﾞ','ﾟ','､','｡','｢','｣','ｰ','･');
	 
	  let ato = "";
	  for (let i=0;i<mae.length;i++){
	    let maechar = mae.charAt(i);
	    let zenindex = zen.indexOf(maechar);
	    if(zenindex >= 0){
	      maechar = han[zenindex];
	    }
	    ato += maechar;
	  }
	  return ato;
	}

	jQuery(function() {
	    jQuery('.zentohan').on('blur', function() {
	        var str = jQuery(this).val();
	        jQuery(this).val(zenkakuToHankaku(str));
	    });
	});
	
	function isHanKana(str){
	  var reg = new RegExp(/^[ｦ-ﾟ]*$/);
	  return reg.test(str);
	}
	/**
	 * 業態コードを取得する
	 */
	function getGyotaiCd() {
		var gyotaiCd = 1;
			var shopCodePrefix = jQuery("#shopCode").val().substring(0, 1);
		if (shopCodePrefix == "1") {
			gyotaiCd = 1;
		} else if (shopCodePrefix == "3") {
			gyotaiCd = 3;
		} else {
			var custCdPrefix = jQuery("#custCd").val().substring(0, 2);
			if ((custCdPrefix == "62") || (custCdPrefix == "63")) {
				gyotaiCd = 3;
			} else {
				gyotaiCd = 1;
			}
		}
			return gyotaiCd;
	}
var defaultList = {
		   activeList : [
				//３Piece
				{id:"productIs3Piece",dVal:"0009901",type:"1"},
				//スペアパンツ
				{id:"productSparePantsClass",dVal:"0009901",type:"1"}
			]
};
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";
jQuery('#custDeliverDate').datepicker({
    format: 'yyyy/mm/dd',
    clearBtn: true,
    language: 'ja',
    todayBtn: "linked",
    orientation: 'buttom auto',
    todayHighlight: true,
    autoclose: true
});

jQuery('#custShopDeliveryDate').datepicker({
    format: 'yyyy/mm/dd',
    clearBtn: true,
    language: 'ja',
    todayBtn: "linked",
    orientation: 'buttom auto',
    todayHighlight: true,
    autoclose: true
});

//納期短縮
jQuery('#expediteDelivery').change(function(){
	var item = jQuery("#item").val();
	var productFabricNo = jQuery("#productFabricNo").val();
	var expediteDelivery = jQuery('#expediteDelivery').val();
	// 納期短縮と早割の両立はできないため、納期短縮が有の場合は早割を無に変更
	//有:9000902
	if (expediteDelivery == "9000902") {
		jQuery('#earlyDiscount').val('9001001');
		jQuery("#custShopDeliveryDate").attr("disabled",false);
		dateEarlyCheck(productFabricNo,item);
	}else{
		jQuery("#custShopDeliveryDate").attr("disabled",true);
		dateEarlyCheck(productFabricNo,item);
	}
});

// 早割
jQuery('#earlyDiscount').change(function(){
	var productFabricNo = jQuery("#productFabricNo").val();
	var earlyDiscount = jQuery('#earlyDiscount').val();
	var item = jQuery("#item").val();
	// 納期短縮と早割の両立はできないため、早割が有の場合は納期短縮を無に変更
	if (earlyDiscount == "9001002") {
		jQuery('#expediteDelivery').val('9000901');
		jQuery('#expediteDelivery').change();
		dateEarlyCheck(productFabricNo,item);
	}else{
		dateEarlyCheck(productFabricNo,item);
	}
});



/************************************************
 * 読み込み時イベント設定
 ************************************************/
 // 自作jsに記載
jQuery(function() {
	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });
  	//--------------------------------------------
	// お客様情報
	//--------------------------------------------
	initCustomer();

    //お客様名初期表示
    var gyotaiCd = getGyotaiCd();
    var membersId = jQuery("#custCd").val();
    if (membersId != "") {
        if ("7" == membersId.substring(0, 1)) {
            var data = {"gyotai": gyotaiCd,"kokNo": membersId,"telNo": "","sei": "","mei": ""};
            jQuery.ajax({
                url: location.protocol+ '//' + location.host + "/member/api/v1/nonmemInfo",
                type: 'post',
                contentType: 'application/json;charset=UTF-8',
                async:false,
                data: JSON.stringify(data),
                success: function(data){
                    if(!isEmpty(data)){
                        for(var i=0; i<data.dataCnt; i++){
                            var retSei = data.nonMemberDataResponse[i]['sei'];
                            var retMei = data.nonMemberDataResponse[i]['mei'];
                            var retSeiJ = data.nonMemberDataResponse[i]['seij'];
                            var retMeiJ = data.nonMemberDataResponse[i]['meij'];
                            $('#custNm').val(retSeiJ + ' ' + retMeiJ);
                            $('#custKanaNm').val(retSei + ' ' + retMei);
                            var custNm = $('#custNm').val();
                            var custKanaNm = $('#custKanaNm').val();
                            if(isEmpty(custKanaNm)||custKanaNm == ' '){
                            	$('#custNmDiv').text(retSeiJ + ' ' + retMeiJ);
                            }else if(isEmpty(custNm)|| custNm == ' '){
                            	$('#custNmDiv').text(retSei + ' ' + retMei);
                            }else{
                            	$('#custNmDiv').text(retSeiJ + ' ' + retMeiJ + "(" + retSei + ' ' + retMei + ")");
                            }
                        }
                    }
                }
            });
        } else {
            var request = new XMLHttpRequest();
            var pathName = '/member/api/v1/memInfo?membersId=';
            var parmName = '&gyotaiCd=';
            request.open('GET', location.protocol+ '//' + location.host + pathName + membersId + parmName + gyotaiCd, true);
            request.responseType = 'json';
            request.onload = function () {
                var data = this.response;
                    if (isEmpty(data)){
                        return false;
                    }
                    $('#custNm').val(data.lastName + ' ' + data.firstName);
                    $('#custKanaNm').val(data.lastNameKana + ' ' + data.firstNameKana);
                    var custNm = $('#custNm').val();
                    var custKanaNm = $('#custKanaNm').val();
                    if(isEmpty(custKanaNm)||custKanaNm == ' '){
                    	$('#custNmDiv').text(data.lastName + ' ' + data.firstName);
                    }else if(isEmpty(custNm)|| custNm == ' '){
                    	$('#custNmDiv').text(data.lastNameKana + ' ' + data.firstNameKana);
                    }else{
                    	$('#custNmDiv').text(data.lastName + ' ' + data.firstName + "(" + data.lastNameKana + ' ' + data.firstNameKana + ")");
                    }
                    $('#measureringInfo').val(data.clothPre);
                };
            request.send();
        }
    }


	//お客様名を表示
	jQuery("#custNm,#custKanaNm").on('input', function(){
		var custNm = jQuery("#custNm").val();
		var custKanaNm = jQuery("#custKanaNm").val();

		if(isEmpty(custKanaNm)){
			jQuery("#custNmDiv").html(custNm + " 様");
		}else{
			jQuery("#custNmDiv").html(custNm+ "(" + custKanaNm +") 様");
		}

		if(isEmpty(custKanaNm)&&isEmpty(custNm)){
			jQuery("#custNmDiv").empty();
		}
		
	})
	
	
	//--------------------------------------------
	// タブメニュー
	//--------------------------------------------
	jQuery('a[id^="nav1_"]').each(function() {
		jQuery(this).click(function(){
			if (jQuery(this).hasClass('active')) {
				return false;
			}
			var id = this.id;
			jQuery('a[id^="nav1_"]').each(function(index, element) {
				if (element.id == id) {
					jQuery(element).addClass("active");
				} else {
					jQuery(element).removeClass("active");
					jQuery('#'+element.id+'_div').hide();
				}
			});
			jQuery('#'+id+'_div').fadeIn(200);
			return false;
		});

		if (!jQuery(this).hasClass('active')) {
			jQuery('#'+this.id+'_div').hide();
		}
	});
	jQuery('a[id^="nav2_"]').each(function() {
		jQuery(this).click(function(){
			if (jQuery(this).hasClass('acrive')) {
				return false;
			}
			var id = this.id;
			jQuery('a[id^="nav2_"]').each(function(index, element) {
				if (element.id == id) {
					jQuery(element).addClass("active");
				} else {
					jQuery(element).removeClass("active");
					jQuery('#'+element.id+'_div').hide();
				}
			});
			jQuery('#'+id+'_div').fadeIn(200);
			return false;
		});

		if (!jQuery(this).hasClass('active')) {
			jQuery('#'+this.id+'_div').hide();
		}
	});
	jQuery('a[id^="nav3_"]').each(function() {
		jQuery(this).click(function(){
			if (jQuery(this).hasClass('acrive')) {
				return false;
			}
			var id = this.id;
			jQuery('a[id^="nav3_"]').each(function(index, element) {
				if (element.id == id) {
					jQuery(element).addClass("active");
				} else {
					jQuery(element).removeClass("active");
					jQuery('#'+element.id+'_div').hide();
				}
			});
			jQuery('#'+id+'_div').fadeIn(200);
			return false;
		});

		if (!jQuery(this).hasClass('active')) {
			jQuery('#'+this.id+'_div').hide();
		}
	});

    var status = "${order.tscStatus}";
   	if(status == 'T7'||status == 'T6'){
   		jQuery("#option_div").hide();
   		jQuery("#option_div_adjust").hide();
   		jQuery("#nav2_product_div").hide();

   		jQuery("#nav1_custom_div input").attr("readOnly","true");
   		jQuery("#nav1_mejer_div input").attr("readOnly","true");
   			
   		jQuery("#nav1_custom_div select").attr("disabled","disabled");
   		jQuery("#nav1_mejer_div select").attr("disabled","disabled");

   		jQuery("#nav1_custom_div textarea").attr("readOnly","true");

   		jQuery("#custDeliverDate").attr("disabled","disabled");
   		
   		jQuery("#shopName").attr("disabled","disabled");
   		jQuery("#shopName").trigger("chosen:updated");

   	   	//item
   		var item = "${order.productItem}"
   		
   		//スペアパンツ  0009901： 無し、0009902：有り
   		var twoPants = "${order.productSparePantsClass}";

   		//３Piece  0009901：無し、0009902：有り
   		var is3piece = "${order.productIs3piece}";
   		
   		//SUITの場合
   		if(item == "01"){
   			jQuery("#re_jacket_div").show();
   			jQuery("#re_pants_div").show();
   			jQuery("#re_gilet_div").hide();
   			jQuery("#re2_pants_div").hide();
   			if(twoPants == "0009902"){
   				jQuery("#re2_pants_div").show();
   			}else{
   				jQuery("#re2_pants_div").hide();
   			}
   			
   			if(is3piece == "0009902"){
   				jQuery("#re_gilet_div").show();
   			}else{
   				jQuery("#re_gilet_div").hide();
   			}
   			
   		}else if (item == "02"){
   			jQuery("#re_jacket_div").show();
   			jQuery("#re_gilet_div").hide();
   			jQuery("#re_pants_div").hide();
   			jQuery("#re2_pants_div").hide();
   		}else if (item == "03"){
   			jQuery("#re_jacket_div").hide();
   			jQuery("#re_gilet_div").hide();
   			jQuery("#re_pants_div").show();
   			jQuery("#re2_pants_div").hide();
   		}else if (item == "04"){
   			jQuery("#re_jacket_div").hide();
   			jQuery("#re_gilet_div").show();
   			jQuery("#re_pants_div").hide();
   			jQuery("#re2_pants_div").hide();
   		}
   	}
   	
    projectControl();

    getProductPrice();
    shirtProductPrice();
    //--------------------------------------------
	// 共通
	//--------------------------------------------
	initCommon();

	//--------------------------------------------
	// タブメニュー
	//--------------------------------------------
	initTabMenu();

	//--------------------------------------------
	// 商品タブ
	//--------------------------------------------
	initProduct();
	
	//メジャーリングの制御
	measuringSetting();

	compositionExpress();

	initAlter();
	
	var orderFlag = "${orderCoForm.orderFlag}";
	if(orderFlag == "orderLink"){
		
		//状態区分をクリア
		var status = "${order.tscStatus}"
		jQuery("#statusInput").val(status);

		//バージョン
		var version = "${order.version}";
		jQuery("#version").val(version);

		var item = jQuery("#item").val();

		var productFabricNo = jQuery("#productFabricNo").val();
		
		//生地によって、商品を表示
		var theoreticalStockCheck = "${order.theoreticalStockCheck}";
		if(theoreticalStockCheck == "1"){
			fabricView(item,productFabricNo);
			var yieldNum = "${order.theoryFabricUsedMount}";
			jQuery("#theoryFabricUsedMountId").val(yieldNum);
		}

		//組成表示　胴裏地
		var bodyText = "${order.productComposBodyLiner}";
		jQuery("#productComposBodyLiner").val(bodyText);
		if(bodyText.indexOf(" ")!=-1){
			bodyText = bodyText.split(" ");
			jQuery("#compos_body_liner_p").html(bodyText[0]).append("<br>").append(bodyText[1]);
		}else{
			jQuery("#compos_body_liner_p").html(bodyText);
		}
		//組成表示　袖裏地
		var sleeveText = "${order.productComposSleeveLiner}";
		jQuery("#compos_sleeve_liner_p").html(sleeveText);
		jQuery("#productComposSleeveLiner").val(sleeveText);
		
		//名簿納期
		var custDeliverDate = "${order.custDeliverDate}";
		if(isNotEmpty(custDeliverDate)){
			custDeliverDate = dateFormat(custDeliverDate);
			jQuery("#custDeliverDate").datepicker("update", custDeliverDate);
		}
		
		//お渡し日
		var custShopDeliveryDate = "${order.custShopDeliveryDate}";
		if(isNotEmpty(custShopDeliveryDate)){
			custShopDeliveryDate = dateFormat(custShopDeliveryDate);
			jQuery("#custShopDeliveryDate").datepicker("update",custShopDeliveryDate);
		}

		//出荷先_他店舗コード
		var shopNameCode = "${order.custShippingDestnationOtherstore}";
		jQuery("#shopName").val(shopNameCode);
		jQuery("#shopName").trigger("chosen:updated");
		
		//メジャーリングを設定
		measuring();

		//ご請求金額
		var billingAmount = "${order.billingAmount}";
		if(isNotEmpty(billingAmount)){
			billingAmount = formatMoney(billingAmount,0,"");
			jQuery("#askPrice").html(billingAmount)
		}else{
			jQuery("#askPrice").html("0");
		}
		
		//消費税
		var consumptionTaxAmount = "${order.consumptionTaxAmount}";
		if(isNotEmpty(consumptionTaxAmount)){
			consumptionTaxAmount = formatMoney(consumptionTaxAmount,0,"");
			jQuery("#excisePrice").html(consumptionTaxAmount);
		}else{
			jQuery("#excisePrice").html("0");
		}
		
		//商品金額
		var productPrice = "${order.productPrice}";
		if(isNotEmpty(productPrice)){
			productPrice = formatMoney(productPrice,0,"");
			jQuery("#goodsPrice").html(productPrice);
		}else{
			jQuery("#goodsPrice").html("0");
		}
		
		//オプション金額
		var optionPrice = "${order.optionPrice}";
		if(isNotEmpty(optionPrice)){
			optionPrice = formatMoney(optionPrice,0,"");
			jQuery("#optionPrice").html(optionPrice);
		}else{
			jQuery("#optionPrice").html("0");
		}
		
		//合計金額
		var totalPrice = "${order.totalPrice}";
		if(isNotEmpty(totalPrice)){
			totalPrice = formatMoney(totalPrice,0,"");
			jQuery("#allPrice").html(totalPrice);
		}else{
			jQuery("#allPrice").html("0");
		}

		if(item == "05"){
			//縦
			var productEmbroideryLength = "${order.productEmbroideryLength}";
			if(isNotEmpty(productEmbroideryLength)){
				jQuery("#embroideryHeightRange").val(productEmbroideryLength);
				setFont("embroideryHeightRange");
				jQuery("#embroideryHeightRange_out").empty();
				jQuery("#embroideryHeightRange_out").html(productEmbroideryLength)
			}
			
			//横
			var productEmbroideryWidth = "${order.productEmbroideryWidth}";
			if(isNotEmpty(productEmbroideryWidth)){
				jQuery("#embroideryWidthRange").val(productEmbroideryWidth);
				setFont("embroideryWidthRange");
				jQuery("#embroideryWidthRange_out").empty();
				jQuery("#embroideryWidthRange_out").html(productEmbroideryWidth)
			}
		}

		//ブランドネーム
		var productBrandNm = "${order.productBrandType}";
		//jQuery('input[name="productBrandNm"][value="0"]').prop("checked",true);
		jQuery(":radio[name=productBrandNm][value='" + productBrandNm + "']").prop("checked", true);
		
	} else if(orderFlag == "orderDivert"){
		
		//組成表示　胴裏地
		var bodyText = "${order.productComposBodyLiner}";
		jQuery("#productComposBodyLiner").val(bodyText);
		if(bodyText.indexOf(" ")!=-1){
			bodyText = bodyText.split(" ");
			jQuery("#compos_body_liner_p").html(bodyText[0]).append("<br>").append(bodyText[1]);
		}else{
			jQuery("#compos_body_liner_p").html(bodyText);
		}
		//組成表示　袖裏地
		var sleeveText = "${order.productComposSleeveLiner}";
		jQuery("#compos_sleeve_liner_p").html(sleeveText);
		jQuery("#productComposSleeveLiner").val(sleeveText);
		
		//出荷先_他店舗コード
		var shopNameCode = "${order.custShippingDestnationOtherstore}";
		jQuery("#shopName").val(shopNameCode);
		jQuery("#shopName").trigger("chosen:updated");
		
		//メジャーリングを設定
		measuring();

		var item = jQuery("#item").val();
		if(item == "05"){
			//縦
			var productEmbroideryLength = "${order.productEmbroideryLength}";
			if(isNotEmpty(productEmbroideryLength)){
				jQuery("#embroideryHeightRange").val(productEmbroideryLength);
				setFont("embroideryHeightRange");
				jQuery("#embroideryHeightRange_out").empty();
				jQuery("#embroideryHeightRange_out").html(productEmbroideryLength)
			}
			
			//横
			var productEmbroideryWidth = "${order.productEmbroideryWidth}";
			if(isNotEmpty(productEmbroideryWidth)){
				jQuery("#embroideryWidthRange").val(productEmbroideryWidth);
				setFont("embroideryWidthRange");
				jQuery("#embroideryWidthRange_out").empty();
				jQuery("#embroideryWidthRange_out").html(productEmbroideryWidth)
			}
		}
		
	} else if(orderFlag == "orderDetail"){

		//名簿納期
		var custDeliverDate = "${order.custDeliverDate}";
		if(isNotEmpty(custDeliverDate)){
			custDeliverDate = dateFormat(custDeliverDate);
			jQuery("#custDeliverDate").datepicker("update", custDeliverDate);
		}
		//お渡し日
		var custShopDeliveryDate = "${order.custShopDeliveryDate}";
		if(isNotEmpty(custShopDeliveryDate)){
			custShopDeliveryDate = dateFormat(custShopDeliveryDate);
			jQuery("#custShopDeliveryDate").val(custShopDeliveryDate);
		}
		
		//出荷先_他店舗コード
		var shopNameCode = "${order.custShippingDestnationOtherstore}";
		jQuery("#shopName").val(shopNameCode);
		jQuery("#shopName").trigger("chosen:updated");
		
		//お客様備考
		var custRemark = "${f:js(order.custRemark)}";
		jQuery("#custRemark").val(custRemark);
		
		//メジャーリングを設定
		measuring();

		//再補正リスト
		//val:注文各項目の再補正値 、textId:各項目入力框のId、rangeId:各項目再補正の符号ボタンのId
		var correctAgainList = [
			//JACKET　
			//着丈修正、ウエスト修正、袖丈右修正、袖丈左修正
			{val:"${order.corJkBodylengthCorrectAgain}",textId:"#corJkBodyRe",rangeId:"#corJkBody"},
			{val:"${order.corJkWaistCorrectAgain}",textId:"#corJkWaistRe",rangeId:"#corJkWaist"},
			{val:"${order.corJkRightsleeveCorrectAgain}",textId:"#corJkRightsleeveRe",rangeId:"#corJkRightsleeve"},
			{val:"${order.corJkLeftsleeveCorrectAgain}",textId:"#corJkLeftsleeveRe",rangeId:"#corJkLeftsleeve"},

			//GILET
			//着丈修正、バスト修正、ウエスト修正
			{val:"${order.corGlBodylengthCorrectAgain}",textId:"#corGlBodylengthRe",rangeId:"#corGlBodylength"},
			{val:"${order.corGlBustCorrectAgain}",textId:"#corGlBustCorrectRe",rangeId:"#corGlBustCorrect"},
			{val:"${order.corGlWaistCorrectAgain}",textId:"#corGlWaistCorrectRe",rangeId:"#corGlWaistCorrect"},
			
			//PANTS
			//ウエスト修正、ヒップ修正、ワタリ修正、裾幅修正、股下右修正、股下左修正
			{val:"${order.corPtWaistCorrectAgain}",textId:"#corPtWaistRe",rangeId:"#corPtWaist"},
			{val:"${order.corPtHipCorrectAgain}",textId:"#corPtHipRe",rangeId:"#corPtHip"},
			{val:"${order.corPtThighwidthCorrectAgain}",textId:"#corPtThighwidthRe",rangeId:"#corPtThighwidth"},
			{val:"${order.corPtHemwidthCorrectAgain}",textId:"#corPtHemwidthRe",rangeId:"#corPtHemwidth"},
			{val:"${order.corPtRightinseamCorrectAgain}",textId:"#corPtRightinseamRe",rangeId:"#corPtRightinseam"},
			{val:"${order.corPtLeftinseamCorrectAgain}",textId:"#corPtLeftinseamRe",rangeId:"#corPtLeftinseam"},

			//2PANTS
			//ウエスト修正、ヒップ修正、ワタリ修正、裾幅修正、股下右修正、股下左修正
			{val:"${order.corPt2WaistCorrectAgain}",textId:"#corPt2WaistRe",rangeId:"#corPt2Waist"},
			{val:"${order.corPt2HipCorrectAgain}",textId:"#corPt2HipRe",rangeId:"#corPt2Hip"},
			{val:"${order.corPt2ThighwidthCorrectAgain}",textId:"#corPt2ThighwidthRe",rangeId:"#corPt2Thighwidth"},
			{val:"${order.corPt2HemwidthCorrectAgain}",textId:"#corPt2HemwidthRe",rangeId:"#corPt2Hemwidth"},
			{val:"${order.corPt2RightinseamCorrectAgain}",textId:"#corPt2RightinseamRe",rangeId:"#corPt2Rightinseam"},
			{val:"${order.corPt2LeftinseamCorrectAgain}",textId:"#corPt2LeftinseamRe",rangeId:"#corPt2Leftinseam"}
		];
		
		var correct = null;
		for(correct of correctAgainList){
			//各再補正値が無しの場合
			if(isNotEmpty(correct.val)){
				if(correct.val.indexOf("-")!=-1){
					jQuery(correct.textId).val(correct.val.replace("-",""));
					jQuery(correct.rangeId + "_range_1_m").toggle();
					jQuery(correct.rangeId + "_range_1_p").toggle();
					jQuery(correct.textId + "_Flag").val("-1");
				}else{
					jQuery(correct.textId).val(correct.val);
					jQuery(correct.textId + "_Flag").val("1");
				}
			}else{
				if(correct.textId == "#corPtRightinseamRe" || correct.textId == "#corPtLeftinseamRe"
					||correct.textId == "#corPt2RightinseamRe" || correct.textId == "#corPt2LeftinseamRe"){
					continue;
				}else{
					jQuery(correct.textId).val("0");
				}
				
			}
		}

		//コメント入力欄
		var corStoreCorrectionMemoAgain = "${f:js(order.corStoreCorrectionMemoAgain)}";
		jQuery("#corStoreCorrectionMemoAgain").val(corStoreCorrectionMemoAgain);

		// 再補正の符号ボタン切替
		jQuery('.re_alter_sign').on('click', function() {
			var thisId = jQuery(this).attr('id');
			var parentId = jQuery("#"+thisId).parent().attr('id');
			var childId = jQuery("#"+parentId).find('input').attr('id');
			
			var sThisClassText = jQuery(this).attr('class');
			var iMinus = sThisClassText.indexOf('minus');
			var oParent = jQuery(this).parent();
			var oPareButton;

			var childFlag = childId + "_Flag";
			jQuery(this).hide(); // 自身を非表示にする
			// 対のオブジェクトを取得する
			if (iMinus >= 0) { // 押されたのがマイナスの場合
				jQuery("#"+childFlag).val("1");
				oPareButton = oParent.find('a.plus');
			} else { // 押されたのがプラスの場合
				jQuery("#"+childFlag).val("-1");
				oPareButton = oParent.find('a.minus');
			}
			oPareButton.show(); // 対のボタンを表示する

		});

		//ご請求金額
		var billingAmount = "${order.billingAmount}";
		if(isNotEmpty(billingAmount)){
			billingAmount = formatMoney(billingAmount,0,"");
			jQuery("#askPrice").html(billingAmount)
		}else{
			jQuery("#askPrice").html("0");
		}
		
		//消費税
		var consumptionTaxAmount = "${order.consumptionTaxAmount}";
		if(isNotEmpty(consumptionTaxAmount)){
			consumptionTaxAmount = formatMoney(consumptionTaxAmount,0,"");
			jQuery("#excisePrice").html(consumptionTaxAmount);
		}else{
			jQuery("#excisePrice").html("0");
		}
		
		//商品金額
		var productPrice = "${order.productPrice}";
		if(isNotEmpty(productPrice)){
			productPrice = formatMoney(productPrice,0,"");
			jQuery("#goodsPrice").html(productPrice);
		}else{
			jQuery("#goodsPrice").html("0");
		}
		
		//オプション金額
		var optionPrice = "${order.optionPrice}";
		if(isNotEmpty(optionPrice)){
			optionPrice = formatMoney(optionPrice,0,"");
			jQuery("#optionPrice").html(optionPrice);
		}else{
			jQuery("#optionPrice").html("0");
		}
		
		//合計金額
		var totalPrice = "${order.totalPrice}";
		if(isNotEmpty(totalPrice)){
			totalPrice = formatMoney(totalPrice,0,"");
			jQuery("#allPrice").html(totalPrice);
		}else{
			jQuery("#allPrice").html("0");
		}
	}else if(orderFlag == "orderCheck"||orderFlag == "orderBack"){
		//jQuery("#version").val("${orderCoForm.version}");
		
		jQuery("#jkOptionPriceId").val("${orderCoForm.jkOptionPrice}");
	  	jQuery("#ptOptionPriceId").val("${orderCoForm.ptOptionPrice}");
	  	jQuery("#pt2OptionPriceId").val("${orderCoForm.pt2OptionPrice}");
	  	jQuery("#glOptionPriceId").val("${orderCoForm.glOptionPrice}");
	  	jQuery("#ctOptionPriceId").val("${orderCoForm.ctOptionPrice}");
	  	jQuery("#stOptionPriceId").val("${orderCoForm.stOptionPrice}");
	  	
	  	jQuery("#jkDoubleModelPrice").val("${orderCoForm.jkDoubleModelPrice}");
	  	jQuery("#ctDoubleModelPrice").val("${orderCoForm.ctDoubleModelPrice}");
	  	jQuery("#glDoubleModelPrice").val("${orderCoForm.glDoubleModelPrice}");
		//出荷先_他店舗コード
		var shopNameCode = "${orderCoForm.coCustomerMessageInfo.custShippingDestnationOtherstore}";
		jQuery("#shopName").val(shopNameCode);
		jQuery("#shopName").trigger("chosen:updated");

		jQuery("#fabricFlag").val("${orderCoForm.fabricFlag}");

		var item = jQuery("#item").val();

		var productFabricNo = jQuery("#productFabricNo").val();

		var fabricCheckValue = jQuery("#fabricFlag").val();
		fabricCheckValue = fabricCheckValue.split("*");
		//fabricCheckValue[0]:0 or 1 or 2 
		//fabricCheckValue[1]:エラーメッセージ 
		//生地チェク成功の場合
		if(fabricCheckValue[0]=="0"&&isNotEmpty(productFabricNo)){
			//生地によって、商品を表示
			fabricView(item,productFabricNo);
		}

		if(item == "05"){
			jQuery("#embroideryHeightRange").val("${orderCoForm.productEmbroideryLength}");
			setFont("embroideryHeightRange");
			jQuery("#embroideryWidthRange").val("${orderCoForm.productEmbroideryWidth}");
			setFont("embroideryWidthRange");
		}

		var yieldNum = "${orderCoForm.theoryFabricUsedMount}";
		jQuery("#theoryFabricUsedMountId").val(yieldNum);

		orderFormMeasuring();

	}

	jQuery('a[href="#nav2_JACKET"]').click(function(){
		optionControlNotDisabled();
		$.blockUI({ message: '<div class="content mt-3"><img src="${pageContext.request.contextPath}/resources/app/images/loading.gif" .></div>' });
		jQuery(".tabbox").addClass("activebk");
		jQuery(".giletbox").removeClass("activebk");
		jQuery(".pantsbox").removeClass("activebk");
		jQuery(".pants2box").removeClass("activebk");
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});
		jQuery("#nav2_Div").load(contextPath + "/orderCo/goToJacketOption");
	})

	jQuery('a[href="#nav2_PANTS"]').click(function(){
		optionControlNotDisabled();
		$.blockUI({ message: '<div class="content mt-3"><img src="${pageContext.request.contextPath}/resources/app/images/loading.gif" .></div>' });
		jQuery(".tabbox").addClass("activebk");
		jQuery(".jacketbox").removeClass("activebk");
		jQuery(".giletbox").removeClass("activebk");
		jQuery(".pants2box").removeClass("activebk");
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});
		jQuery("#nav2_Div").load(contextPath + "/orderCo/goToPants1Option");
	})

	jQuery('a[href="#nav2_2PANTS"]').click(function(){
		optionControlNotDisabled();
		$.blockUI({ message: '<div class="content mt-3"><img src="${pageContext.request.contextPath}/resources/app/images/loading.gif" .></div>' });
		jQuery(".tabbox").addClass("activebk");
		jQuery(".jacketbox").removeClass("activebk");
		jQuery(".giletbox").removeClass("activebk");
		jQuery(".pantsbox").removeClass("activebk")
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});
		jQuery("#nav2_Div").load(contextPath + "/orderCo/goToPants2Option");
	})

	jQuery('a[href="#nav2_GILET"]').click(function(){
		optionControlNotDisabled();
		$.blockUI({ message: '<div class="content mt-3"><img src="${pageContext.request.contextPath}/resources/app/images/loading.gif" .></div>' });
		jQuery(".tabbox").addClass("activebk");
		jQuery(".jacketbox").removeClass("activebk");
		jQuery(".pantsbox").removeClass("activebk");
		jQuery(".pants2box").removeClass("activebk")
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});
		jQuery("#nav2_Div").load(contextPath + "/orderCo/goToGiletOption");
	})

	jQuery('a[href="#nav2_SHIRT"]').click(function(){
		optionControlNotDisabled();
		$.blockUI({ message: '<div class="content mt-3"><img src="${pageContext.request.contextPath}/resources/app/images/loading.gif" .></div>' });
		jQuery(".tabbox").addClass("activebk");
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});
		jQuery("#nav2_Div").load(contextPath + "/orderCo/goToShirtOption");
	})

	jQuery('a[href="#nav2_COAT"]').click(function(){
		optionControlNotDisabled();
		$.blockUI({ message: '<div class="content mt-3"><img src="${pageContext.request.contextPath}/resources/app/images/loading.gif" .></div>' });
		jQuery(".tabbox").addClass("activebk");
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});
		jQuery("#nav2_Div").load(contextPath + "/orderCo/goToCoatOption");
	})
	
	jQuery("#nav2_option").click(function(){
		jQuery(".alertbox").removeClass("activebk");
		jQuery(".jacketbox").addClass("activebk");
		jQuery(".giletbox").addClass("activebk");
		jQuery(".pantsbox").addClass("activebk");
		jQuery(".pants2box").addClass("activebk");
		jQuery("#nav2_div_option").show();
		
		var item = jQuery("#item").val();
		var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
		var sparePants = jQuery('input[name="productSparePantsClass"]:checked').val();
		if(item == "01"){
			jQuery("#option_div").show();
			document.getElementById("nav2_JACKET").click();
			jQuery("#jacketOption").show();
			jQuery("#pantsOption").show();
			jQuery("#pants2Option").hide();
			jQuery("#giletOption").hide();
			jQuery("#coatOption").hide();
			jQuery("#shirtOption").hide();
			if(threePiece == "0009902"){
				jQuery("#giletOption").show();
			}
			if(sparePants == "0009902"){
				jQuery("#pants2Option").show();
			}
		}else if(item == "02"){
			jQuery("#option_div").hide();
			document.getElementById("nav2_JACKET").click();
		}else if(item == "03"){
			jQuery("#option_div").hide();
			document.getElementById("nav2_PANTS").click();
		}else if(item == "04"){
			jQuery("#option_div").hide();
			document.getElementById("nav2_GILET").click();
		}else if(item == "05"){
			jQuery("#option_div").hide();
			document.getElementById("nav2_SHIRT").click();
		}else if(item == "06"){
			jQuery("#option_div").hide();
			document.getElementById("nav2_COAT").click();
		}
	})
	
	jQuery("#nav2_product").click(function(){
		optionControlNotDisabled();
		jQuery(".tabbox").removeClass("activebk");
		jQuery(".alertbox").removeClass("activebk");
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});
		compositionExpress();
		jQuery("#nav3_div_choose").hide();
		jQuery("#option_div_adjust").hide();
		jQuery("#option_div").hide();
		jQuery("#nav2_div_option").hide();
	})
	
	jQuery("#nav2_option").click(function(){
		jQuery("#nav3_div_choose").hide();
		jQuery("#option_div_adjust").hide();
	})
	
	jQuery('#nav2_alter').click(function(){
		optionControlNotDisabled();
		//jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').ghostsf_serialize(),type: "post",async:false});
		//jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').ghostsf_serialize(),type: "post",async:false});
		//jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});
		jQuery("#option_div").hide();
		jQuery("#nav2_div_option").hide();
	})
	
	//js
	jQuery('a[href="#nav2_ITEMS_Ad"]').click(function(){
		$.blockUI({ message: '<div class="content mt-3"><img src="${pageContext.request.contextPath}/resources/app/images/loading.gif" .></div>' });
		jQuery(".alertbox").addClass("activebk");
		jQuery(".gladjustbox").removeClass("activebk");
		jQuery(".ptadjustbox").removeClass("activebk");
		jQuery(".pt2adjustbox").removeClass("activebk");
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});
		jQuery("#nav3_Div").load(contextPath + "/orderCo/orderCoAdjust");
	})
	
	
	jQuery("#nav2_alter").click(function(){
		
		jQuery(".tabbox").removeClass("activebk");
		jQuery(".jkadjustbox").addClass("activebk");
		jQuery(".gladjustbox").addClass("activebk");
		jQuery(".ptadjustbox").addClass("activebk");
		jQuery(".pt2adjustbox").addClass("activebk");
		jQuery("#nav3_div_choose").show();
		shirtProductPrice();
		var item = jQuery("#item").val();
		var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
		var sparePants = jQuery('input[name="productSparePantsClass"]:checked').val();
	    jQuery("#option_div_adjust").hide();
		//jQuery("#itemsChoose").show();
		document.getElementById("nav2_ITEMS_Ad").click();
		jQuery("#itemsChoose").show();
	})
	
	var authority = "${sessionContent.authority}";
	if(authority == "02"){
		
	}else{
		//30s自動保存
	 	//注文のTSCステータス
		//var orderStatus = "${order.tscStatus}";
		var orderStatus = jQuery("#orderTscStatus").val();
		//戻るの場合、orderFormのTSCステータス
		var orderFormStatus = "${orderCoForm.status}";
		//T0 ：一時保存、T1 ：取り置き、""：ステータス無し
		//「オーダー一覧」画面から来たの場合
		if(　((orderStatus=="T0"||orderStatus=="T1")&&orderFormStatus=="")||
			//「内容確認」画面来たの場合	
			((orderFormStatus=="T0"||orderFormStatus=="T1")&&orderStatus=="")||
			//新規登録の場合
			(orderStatus==""&&orderFormStatus=="")){
				
			setInterval(function(){
				//保存flag
				jQuery("#saveFlag").val("1");
				//TSCステータス  一時保存
				var statusInput = jQuery("#statusInput").val();

				if(statusInput==""||statusInput==null){
					jQuery("#statusInput").val("T0");
				}else{
					jQuery("#statusInput").val(jQuery("#statusInput").val());
				}
				var stockCheckResult = stockCheck();
				
				var result = temporarySaveCheck();
					
				if(!result){
					jQuery("div.alert-success").hide();
					return false;
				}
				if(stockCheckResult){
					optionControlNotDisabled();
					jQuery.ajax({
			              url : contextPath + "/orderCo/orderCoTemporarySave",
					      type: "post",
					      async:false,
					      data: jQuery('#idForm').ghostsf_serialize(),
						  }).then(function(data) {
							  if(!data.orderMsgFlag){
								  if(data.orderMsg == 'T2ERROR'){
									  swal({
					        				text: getMsg('msg048'),
					        				icon: "info"
					        		  }).then(function(val){
					        				window.location.href= contextPath + "/orderlist/gotoOrderlist";
					        		  });
								  }else if(data.orderMsg == 'T3ERROR'){
									  swal({
					        				text: getMsg('msg048'),
					        				icon: "info"
					        		  }).then(function(val){
					        				window.location.href= contextPath + "/orderlist/gotoOrderlist";
					        		  });
								  }
							  }else{
								  if(data.orderId == "true"){
									  //ステータス設定
								   	  jQuery("#status").empty();
								   	  var statusInput = jQuery("#statusInput").val();
									  if(statusInput=="T0"){
									 	  jQuery("#status").html("一時保存");
									  }else{
										  jQuery("#status").html("取り置き");
									  }
								  }else if(data.orderId.length == 12){
									  jQuery("#orderId").val(data.orderId);
								      //ステータス設定
									  jQuery("#status").empty();
								   	  var statusInput = jQuery("#statusInput").val();
									  if(statusInput=="T0"){
									 	  jQuery("#status").html("一時保存");
									  }else{
										  jQuery("#status").html("取り置き");
									  }
									  var version = jQuery.ajax({url:contextPath + "/orderCo/getOrderVersion",data:{"orderId":data.orderId},async:false});
									  version = version.responseText;
									  jQuery("#version").val(version);
								  }
							  }
						  })
				}
				optionControlDisabled();
				projectControl();
			  },30000)
		};
	}
	
	//一時保存ボタンをクリック
	jQuery("#temporarySave").click(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});

		//保存flag
		jQuery("#saveFlag").val("0");
		//TSCステータス  一時保存
		jQuery("#statusInput").val("T0");
		
		var stockCheckResult = stockCheck();
		
		var result = temporarySaveCheck();
		
		if(!result){
			jQuery("div.alert-success").hide();
			return false;
		}
		
		if(stockCheckResult){
			optionControlNotDisabled();
			jQuery.ajax({url : contextPath + "/orderCo/orderCoTemporarySave",
			    type: "post",
			    async:false,
				data: jQuery('#idForm').ghostsf_serialize(),
			    }).then(function(data){
			    	if(!data.orderMsgFlag){
						  if(data.orderMsg == 'T2ERROR'){
							  swal({
			        				text: getMsg('msg048'),
			        				icon: "info"
			        		  }).then(function(val){
			        				window.location.href= contextPath + "/orderlist/gotoOrderlist";
			        		  });
						  }else if(data.orderMsg == 'T3ERROR'){
							  swal({
			        				text: getMsg('msg048'),
			        				icon: "info"
			        		  }).then(function(val){
			        				window.location.href= contextPath + "/orderlist/gotoOrderlist";
			        		  });
						  }
					}else{
						if(data.orderId == "true"){
					    	//ステータス設定
							jQuery("#status").empty();
							jQuery("#status").html("一時保存");
						   	appendAlert('successmssage', getMsgByOneArg('msg015',jQuery("#orderId").val()));
						   	var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
							version = version.responseText;
							jQuery("#version").val(version);
						}else if(data.orderId.length == 12){
							jQuery("#orderId").val(data.orderId);
					    	//ステータス設定
							jQuery("#status").empty();
							jQuery("#status").html("一時保存");
						   	appendAlert('successmssage', getMsgByOneArg('msg015',jQuery("#orderId").val()));
						   	var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
							version = version.responseText;
							jQuery("#version").val(version);
						}
					}
				})
		}
			optionControlDisabled();
			projectControl();
	})

	
	//取り置きボタンをクリック
	jQuery("#layUpSave").click(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').ghostsf_serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});

		//保存flag
		jQuery("#saveFlag").val("0");
		//TSCステータス  取り置き
		jQuery("#statusInput").val("T1");
		var stockCheckResult = stockCheck();
		var result = temporarySaveCheck();
		
		if(!result){
			jQuery("div.alert-success").hide();
			return false;
		}
		
		if(stockCheckResult){
			optionControlNotDisabled();
			jQuery.ajax({url : contextPath + "/orderCo/orderCoTemporarySave",
			    type: "post",
			    async:false,
			    data: jQuery('#idForm').ghostsf_serialize(),
			    }).then(function(data){
			    	if(!data.orderMsgFlag){
						  if(data.orderMsg == 'T2ERROR'){
							  swal({
			        				text: getMsg('msg048'),
			        				icon: "info"
			        		  }).then(function(val){
			        				window.location.href= contextPath + "/orderlist/gotoOrderlist";
			        		  });
						  }else if(data.orderMsg == 'T3ERROR'){
							  swal({
			        				text: getMsg('msg048'),
			        				icon: "info"
			        		  }).then(function(val){
			        				window.location.href= contextPath + "/orderlist/gotoOrderlist";
			        		  });
						  }
					}else{
						if(data.orderId == "true"){
					  	    //ステータス設定
						   	jQuery("#status").empty();
						   	jQuery("#status").html("取り置き");
						   	appendAlert('successmssage', getMsgByOneArg('msg058',jQuery("#orderId").val()));
						  	var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
							version = version.responseText;
							jQuery("#version").val(version);
						}else if(data.orderId.length == 12){
							jQuery("#orderId").val(data.orderId);
					    	//ステータス設定
							jQuery("#status").empty();
							jQuery("#status").html("取り置き");
						   	appendAlert('successmssage', getMsgByOneArg('msg058',jQuery("#orderId").val()));
						   	var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
							version = version.responseText;
							jQuery("#version").val(version);
						}
					}
				})
		}
			optionControlDisabled();
			projectControl();
	})
	
	// メジャーリング情報登録ボタンクリック
	jQuery('#updMeasureButton').on('click', function() {
		var membersId = jQuery("#custCd").val();
		if (!membersId) {
			return;
		}
		if ("7" == membersId.substring(0, 1)) {
			swal({
				text:"非会員のメジャーリング情報は登録できません。",
				icon:"warning"
			});
			return;
		}

		var gyotaiCd = getGyotaiCd();
		var tenCd = jQuery("#shopCode").val();
// TODO:社員コードを動的に取得する
		var syainNo = jQuery("#custStaff").val();
		var fullLength = getPartsSize(jQuery("#fullLengthTe"), jQuery("#fullLengthSe"), "フルレングス");
		if (fullLength == null) {
			return;
		}
		var shoulder = getPartsSize(jQuery("#shoulderTe"), jQuery("#shoulderSe"), "ショルダー");
		if (shoulder == null) {
			return;
		}
		var reachRight = getPartsSize(jQuery("#reachRightTe"), jQuery("#reachRightSe"), "リーチ（右）");
		if (reachRight == null) {
			return;
		}
		var reachLeft = getPartsSize(jQuery("#reachLeftTe"), jQuery("#reachLeftSe"), "リーチ（左）");
		if (reachLeft == null) {
			return;
		}
		var outBust = getPartsSize(jQuery("#outBustTe"), jQuery("#outBustSe"), "アウトバスト");
		if (outBust == null) {
			return;
		}
		var bust = getPartsSize(jQuery("#bustTe"), jQuery("#bustSe"), "バスト");
		if (bust == null) {
			return;
		}
		var jacketWaist = getPartsSize(jQuery("#jacketWaistTe"), jQuery("#jacketWaistSe"), "JKウエスト");
		if (jacketWaist == null) {
			return;
		}
		var pantsWaist = getPartsSize(jQuery("#pantsWaistTe"), jQuery("#pantsWaistSe"), "PTウエスト");
		if (pantsWaist == null) {
			return;
		}
		var hip = getPartsSize(jQuery("#hipTe"), jQuery("#hipSe"), "ヒップ");
		if (hip == null) {
			return;
		}
		var spanRight = getPartsSize(jQuery("#spanRightTe"), jQuery("#spanRightSe"), "ワタリ（右）");
		if (spanRight == null) {
			return;
		}
		var spanLeft = getPartsSize(jQuery("#spanLeftTe"), jQuery("#spanLeftSe"), "ワタリ（左）");
		if (spanLeft == null) {
			return;
		}
		var calfRight = getPartsSize(jQuery("#calfRightTe"), jQuery("#calfRightSe"), "ふくらはぎ（右）");
		if (calfRight == null) {
			return;
		}
		var calfLeft = getPartsSize(jQuery("#calfLeftTe"), jQuery("#calfLeftSe"), "ふくらはぎ（左）");
		if (calfLeft == null) {
			return;
		}
		var neck = getPartsSize(jQuery("#neckTe"), jQuery("#neckSe"), "ネック");
		if (neck == null) {
			return;
		}
		var measureringInfo = jQuery("#measureringInfo").val();

		var data = {
				"gyotaiCd"  : gyotaiCd,
				"kokNo"     : membersId,
				"size01"    : fullLength,
				"size02"    : shoulder,
				"size03"    : reachRight,
				"size04"    : reachLeft,
				"size05"    : outBust,
				"size06"    : bust,
				"size07"    : jacketWaist,
				"size08"    : pantsWaist,
				"size09"    : hip,
				"size10"    : spanRight,
				"size11"    : spanLeft,
				"size12"    : calfRight,
				"size13"    : calfLeft,
				"size14"    : neck,
				"size15"    : NaN,
				"size16"    : NaN,
				"size17"    : NaN,
				"size18"    : NaN,
				"size19"    : NaN,
				"size20"    : NaN,
				"sizeUpdYmd": "",
				"biko01"    : measureringInfo,
				"biko02"    : "",
				"biko03"    : "",
				"updTenCd"  : tenCd,
				"updSyainNo": syainNo,
				"updYmd"    : "",
				"updHms"    : ""
		};

		jQuery.ajax({
			url: location.protocol+ '//' + location.host + "/member/api/v1/upKarte",
			type: 'post',
			contentType: 'application/json;charset=UTF-8',
			async:false,
			data: JSON.stringify(data)
		}).then(
			// 通信成功時のコールバック
			function(data){
				if(isEmpty(data)){
					swal({
						text:"メジャーリング情報の登録に失敗しました。",
						icon:"error"
					});
				} else {
					swal({
						text:"メジャーリング情報を登録しました。",
						icon:"info"
					});
				}
			},
			// 通信失敗時のコールバック
			function(){
				swal({
					text:"メジャーリング情報の登録に失敗しました。",
					icon:"error"
				});
			}
		);
	});

	/**
	 * JSONにNaNを渡すためのreplacer
	 */
	var replacer = function(key, value) {
		if (Number.isNaN(value)) {
			return {
				__extendData__: true,
				type: 'number',
				value: 'NaN',
			};
		}
		return value;
	};

	/**
	 * パーツごとの採寸情報を取得する、
	 * return
	 *   NaN     : 整数部、小数部ともに未入力の場合
	 *   null    : 整数部、小数部のいずれかの入力に不備がある場合
	 *   上記以外: サイズ情報（整数部 + "." + 小数部）
	 */
	function getPartsSize(objTe, objSe, partsText) {
		var regex = new RegExp(/^[0-9]+$/);
		if (!objTe.val()) {
			// 少数部だけ入力されている場合はエラー
			if (objSe.val()) {
				swal({
					text:partsText + "を入力してください。",
					icon:"warning"
				}).then(function(val){
					objTe.focus();
				});
				return null;
			} else {
				return NaN;
			}
		} else {
			// 整数部が整数でない場合はエラー
			if (!regex.test(objTe.val())) {
				swal({
					text:partsText + "には数値を入力してください。",
					icon:"warning"
				}).then(function(val){
					objTe.focus();
				});
				return null;
			}

			// 小数部が入力されている場合
			if (objSe.val()) {
				// 少数部が整数でない場合はエラー
				if (!regex.test(objSe.val())) {
					swal({
						text:partsText + "には数値を入力してください。",
						icon:"warning"
					}).then(function(val){
						objSe.focus();
					});
					return null;
				} else {
					return parseFloat(objTe.val() + "." + objSe.val());
				}
			} else {
				return parseFloat(objTe.val());
			}
		}
	}

    //会員検索ボタンクリック
    jQuery('#custSearchButton').on('click', function() {
            var membersId = jQuery("#custCd").val();
            var shopCode = jQuery("#shopCode").val();
            var gyotaiCd = "1";
            if (!isEmpty(shopCode)) {
                if (shopCode[0] == '1' || shopCode[0] == '3') {
                    gyotaiCd = shopCode[0];
                } else {
                    if (membersId.length >= 2) {
                        switch(membersId.substr(0,2)){
                          case '62':
                          case '63':
                            gyotaiCd = '3';
                            break;
                          default:
                            gyotaiCd = '1';
                        }
                    }
                }
            } else {
                if (membersId.length >= 2) {
                    switch(membersId.substr(0,2)){
                      case '62':
                      case '63':
                        gyotaiCd = '3';
                        break;
                      default:
                        gyotaiCd = '1';
                    }
                }
            }
            if (membersId == "") {
                    swal({
                            text:"会員番号を入力してください。",
                            icon:"error"
                    }).then(function(val){
                            jQuery("#custCd").focus();
                    });
                    jQuery("#custNm").val('');
                    jQuery("#custKanaNm").val('');
                    return false;
            }
            jQuery.ajax({
                url: location.protocol+ '//' + location.host + "/member/api/v1/memInfo",
                type: 'get',
                async:false,
                data:{"membersId":membersId,"gyotaiCd":gyotaiCd},
                success: function(data){
                    if(isEmpty(data)){
                        swal({
                            text:"会員番号が存在しません。確認して再入力してください。",
                            icon:"error"
                        }).then(function(val){
                            jQuery("#custCd").focus();
                        });
                        return false;
                    } else {
                    	$('#custNm').val(data.lastName + ' ' + data.firstName);
                        $('#custKanaNm').val(data.lastNameKana + ' ' + data.firstNameKana);
                        var custNm = $('#custNm').val();
                        var custKanaNm = $('#custKanaNm').val();
                        if(isEmpty(custKanaNm)||custKanaNm == ' '){
                        	$('#custNmDiv').text(data.lastName + ' ' + data.firstName);
                        }else if(isEmpty(custNm)|| custNm == ' '){
                        	$('#custNmDiv').text(data.lastNameKana + ' ' + data.firstNameKana);
                        }else{
                        	$('#custNmDiv').text(data.lastName + ' ' + data.firstName + "(" + data.lastNameKana + ' ' + data.firstNameKana + ")");
                        }
                        $('#measureringInfo').val(data.clothPre);
                    }
                }
            });

    });

	// 非会員検索ボタンクリック
	jQuery('#search2Button').on('click', function() {
                jQuery('#bootstrap-data-table').empty();
                var membersId = jQuery("#custCd").val();
                var shopCode = jQuery("#shopCode").val();
		var phoneNo = jQuery("#searchTelNo").val();
		var firstNameKana = jQuery("#searchSei").val();
		var secondNameKana = jQuery("#searchMei").val();
                var gyotaiCd = "1";
                if (!isEmpty(shopCode)) {
                    if (shopCode[0] == '1' || shopCode[0] == '3') {
                        gyotaiCd = shopCode[0];
                    } else {
                        if (membersId.length >= 2) {
                            switch(membersId.substr(0,2)){
                              case '62':
                              case '63':
                                gyotaiCd = '3';
                                break;
                              default:
                                gyotaiCd = '1';
                            }
                        }
                    }
                } else {
                    if (membersId.length >= 2) {
                        switch(membersId.substr(0,2)){
                          case '62':
                          case '63':
                            gyotaiCd = '3';
                            break;
                          default:
                            gyotaiCd = '1';
                        }
                    }
                }
		if (phoneNo == "") {
			swal({
				text:"電話番号を入力してください。",
				icon:"error"
			}).then(function(val){
				jQuery("#searchTelNo").focus();
			});
			return false;
		} else if (firstNameKana == "") {
			swal({
				text:"姓（カナ）を入力してください。",
				icon:"error"
			}).then(function(val){
				jQuery("#searchSei").focus();
			});
			return false;
		} else if (secondNameKana == "") {
			swal({
				text:"名（カナ）を入力してください。",
				icon:"error"
			}).then(function(val){
				jQuery("#searchMei").focus();
			});
			return false;
		}
		if (!isHanKana(firstNameKana)) {
            swal({
                    text:"姓（カナ）は半角カナで入力してください。",
                    icon:"error"
            }).then(function(val){
                    jQuery("#searchSei").focus();
            });
            return false;
		}
        var data = {"gyotai": gyotaiCd,"kokNo": 0,"telNo": phoneNo,"sei": firstNameKana,"mei": secondNameKana};
        jQuery.ajax({
            url: location.protocol+ '//' + location.host + "/member/api/v1/nonmemInfo",
            type: 'post',
            contentType: 'application/json;charset=UTF-8',
            async:false,
            data: JSON.stringify(data),
            success: function(data){
                if(isEmpty(data)){
                    swal({
                        text:"会員情報が存在しません。確認して再入力してください。",
                        icon:"error"
                    }).then(function(val){
                        jQuery("#custCd").focus();
                    });
                    return false;
                } else {
                    $('#bootstrap-data-table').append('<thead><tr><th><label class="small">顧客No</label></th>' +
                               '<th><label class="small">電話番号</label></th>' +
                               '<th><label class="small">メールアドレス</label></th>' +
                               '<th><label class="small">姓名</label></th>' +
                               '<th><label class="small">姓名（カナ）</label></th>' +
                               '<th></th></tr></thead>');
                    for(var i=0; i<data.dataCnt; i++){
                        var retKokNo = data.nonMemberDataResponse[i]['kokno'];
                        var retTelno = data.nonMemberDataResponse[i]['telno'];
                        var retEmail = data.nonMemberDataResponse[i]['email'];
                        var retSei = data.nonMemberDataResponse[i]['sei'];
                        var retMei = data.nonMemberDataResponse[i]['mei'];
                        var retSeiJ = data.nonMemberDataResponse[i]['seij'];
                        var retMeiJ = data.nonMemberDataResponse[i]['meij'];
                        $('#bootstrap-data-table').append(
                               '<tr><td><label id="cust_num_' + i + '">' + retKokNo + '</label></td>' +
                               '<td><label class="small" id="cust_phone_' + i + '">' + retTelno + '</label></td>' +
                               '<td><label class="small" id="cust_email_' + i + '">' + retEmail + '</label></td>' +
                               '<td><label class="small" id="cust_Nam_' + i + '">' + retSeiJ + ' ' + retMeiJ + '</label></td>' +
                               '<td><label class="small" id="cust_knam_' + i + '">' + retSei + ' ' + retMei + '</label></td><td>' +
                               '<button type="button" id="selectButton_' + i +
                               '" class="btn btn-info btn-block selectbtn">選択</button></td></tr>');
                    }
                }
            }
        });

        // 一覧部を非表示
        jQuery('#areaResult').show();
	});

	// 登録ボタンクリック
	jQuery('#registButton').on('click', function() {
                var gyotaiCd = getGyotaiCd();
		var phoneNo = jQuery("#updTelNo").val();
		var firstNameKana = jQuery("#updSei").val();
		var secondNameKana = jQuery("#updMei").val();
		var firstName = jQuery("#updSeiJ").val();
		var secondName = jQuery("#updMeiJ").val();
		var Email = jQuery("#updEmail").val();
		if (phoneNo == "") {
			swal({
				text:"電話番号を入力してください。",
				icon:"error"
			}).then(function(val){
				jQuery("#updTelNo").focus();
			});
			return false;
		} else if (firstNameKana == "") {
			swal({
				text:"姓（カナ）を入力してください。",
				icon:"error"
			}).then(function(val){
				jQuery("#updSei").focus();
			});
			return false;
		} else if (secondNameKana == "") {
			swal({
				text:"名（カナ）を入力してください。",
				icon:"error"
			}).then(function(val){
				jQuery("#updMei").focus();
			});
			return false;
		}
        var data = {"gyotai": gyotaiCd,"kokNo": 0,"telNo": phoneNo,"sei": firstNameKana,"mei": secondNameKana,"seiJ":firstName,"meiJ":secondName,"email":Email};
        jQuery.ajax({
            url: location.protocol+ '//' + location.host + "/member/api/v1/updNonMem",
            type: 'post',
            contentType: 'application/json;charset=UTF-8',
            async:false,
            data: JSON.stringify(data),
            success: function(data){
                if(isEmpty(data)){
                    swal({
                        text:"非会員登録に失敗しました。",
                        icon:"error"
                    }).then(function(val){
                        jQuery("#custCd").focus();
                    });
                    return false;
                } else {
                    swal({
                        text:"非会員情報を登録しました。",
                        icon:"info"
                    });
                    jQuery('#areaResult').hide();
                    jQuery('#custCd').val(data.kokNo);
                    jQuery('#custKanaNm').val(firstNameKana + ' ' + secondNameKana);
                    jQuery('#custNmDiv').text(firstNameKana + ' ' + secondNameKana);
                    jQuery('#custNm').val(firstName + ' ' + secondName);
                    jQuery('#infotext_2').modal('hide');
                }
            }
        });
	});
	
	// ３Piece
	jQuery('input[name="productIs3Piece"]').each(function() {
		jQuery(this).change(function(){
			var threePiece = jQuery(this).val();
			var item = jQuery("#item option:selected").val();
			if(threePiece == "0009902"){
				jQuery.ajax({url:contextPath + "/orderCo/optionInit",data:{"oldItem":"04"},type: "get",async:false});
				jQuery("#giletItemFlag").val("0");
			}else if(threePiece == "0009901"){
				jQuery("#glOptionPriceId").val("0");
				jQuery("#glDoubleModelPrice").val("0");
			}
			compositionExpress();
			stockCheck();
			changeViewArea();
			projectControl();
		});
	});	

	// スペアパンツ
	jQuery('input[name="productSparePantsClass"]').each(function() {
		jQuery(this).change(function(){
			var sparePants = jQuery(this).val();
			if(sparePants == "0009902"){
				jQuery.ajax({url:contextPath + "/orderCo/optionInit",data:{"oldItem":"07"},type: "get",async:false});
				jQuery("#pants2ItemFlag").val("0");
			}else if(sparePants == "0009901"){
				jQuery("#pt2OptionPriceId").val("0");
			}
			stockCheck();
			changeViewArea()
			projectControl();
		});
	});

	var oldCategory = jQuery('input[name="productCategory"]:checked').val();
	jQuery('input[name="productCategory"]').attr("hookCate",oldCategory);
	
	// カテゴリ
	jQuery('input[name="productCategory"]').each(function() {
		jQuery(this).change(function(){
			var item = jQuery('#item').val();
			var category = jQuery(this).val();
			var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
			var twoPants = jQuery('input[name="productSparePantsClass"]:checked').val();
			swal({
				  text: getMsg('msg128'),
				  icon: "info",
				  buttons: ["キャンセル", true],
				})
				.then((isConfirm) => {
				  if (isConfirm) {
					  jQuery("#jkOptionPriceId").val("0");
					  jQuery("#ptOptionPriceId").val("0");
					  jQuery("#pt2OptionPriceId").val("0");
					  jQuery("#glOptionPriceId").val("0");
					  jQuery("#ctOptionPriceId").val("0");
					  jQuery("#stOptionPriceId").val("0");
				      jQuery("#jkDoubleModelPrice").val("0");
				      jQuery("#ctDoubleModelPrice").val("0");
				      jQuery("#glDoubleModelPrice").val("0");

				      if(jQuery('#itemCoFlag').val()=="1"){
					  		jQuery("#itemCoChangeFlag").val("1");
					  	}
				      
					  if(oldCategory != category){
						  jQuery('input[name="productCategory"]').attr("hookCate",category);
					  }
					  jQuery.ajax({url:contextPath + "/orderCo/optionInit",data:{"oldItem":item},type: "get",async:false});
					  if(item == "01") {
						  jQuery("#jacketItemFlag").val("0");
						  jQuery("#pantsItemFlag").val("0");
					  	  if(threePiece == "0009902") {
					      		jQuery("#giletItemFlag").val("0");
					      }
					      if(twoPants == "0009902") {
						        jQuery("#pants2ItemFlag").val("0");
					      }
					  }else if(item == "02") {
						  jQuery("#jacketItemFlag").val("0");
					  }else if(item == "03") {
						  jQuery("#pantsItemFlag").val("0");
					  }else if(item == "04") {
						  jQuery("#giletItemFlag").val("0");
					  }
					  jQuery("#fabricMsg").empty();
					  compositionExpress();
					  //stockCheck();
					  var productFabricNo = jQuery("#productFabricNo").val();
					  if(isNotEmpty(productFabricNo)){
						  var checkResult = fabricCheck(item,productFabricNo);
							//生地によって、商品を表示
						  if(checkResult == "0"||checkResult == "2"){
							  fabricView(item,productFabricNo);
						  }
					  }
					  changeViewArea();
					  projectControl();
				  }else{
					  var newCate = jQuery('input[name="productCategory"]').attr("hookCate");
					  jQuery(":radio[name='productCategory'][value='" + newCate + "']").prop("checked", true);
				  }
			});
		});
	});

	//注文削除ボタンクリック
	jQuery('#deleteButton').on('click', function() {
		var orderId = jQuery('#orderId').val();
		if(isEmpty(orderId)){
			appendAlert('errormssage', getMsg('msg124'));
		    return false;
		}else{
			// 確認ダイアログ表示
			swal({
				text:getMsg('msg110'),
				icon:"info",
				buttons: ["キャンセル", true],
			}).then((willDelete) => {
				if (willDelete) {
					// OK押下時は注文一覧へ
					var version = jQuery("#version").val();
					window.location.href= contextPath + "/orderCo/physicalDelete?orderId=" + orderId + "&version=" + version;
				} else {
					// Cancel押下時は何もしない
				}
			});
		}
	});

	// 注文取消ボタンクリック
	jQuery('#cancelButton').on('click', function() {
		// 確認ダイアログ表示
		swal({
			text:getMsg('msg111'),
			icon:"info",
			buttons: ["キャンセル", true],
		}).then((willDelete) => {
			if (willDelete) {
				// OK押下時は注文一覧へ
				var orderId = jQuery('#orderId').val();
				var version = jQuery("#version").val();
				window.location.href= contextPath + "/orderCo/logicalDelete?orderId=" + orderId + "&version=" + version;
			} else {
				// Cancel押下時は何もしない
			}
		});
	});
    jQuery('#itemCoFlag').val("1");
});


//メジャーリングの制御
function measuringSetting(){
	//メジャーリング 
	//メジャーリング 
	var fullLengthText="";
	var fullLengthSelect="";
	jQuery("#fullLengthTe").on('input', function(){
		var makeUpVal = null
		fullLengthText = jQuery("#fullLengthTe").val();
		var fullLengthSe = jQuery("#fullLengthSe").val();
		if(isNotEmpty(fullLengthSe)){
			makeUpVal = fullLengthText+"."+fullLengthSe;
		}else{
			makeUpVal = fullLengthText+".0";
		}
		jQuery("#fullLength").val(makeUpVal);
	})
	jQuery("#fullLengthSe").change(function(){
		fullLengthText = jQuery("#fullLengthTe").val();
		fullLengthSelect = jQuery("#fullLengthSe").val();
		var makeUpVal = fullLengthText+"."+fullLengthSelect;
		jQuery("#fullLength").val(makeUpVal);
	})
	
	var shoulderText="";
	var shoulderSelect="";
	jQuery("#shoulderTe").on('input', function(){
		var makeUpVal = null;
		shoulderText = jQuery("#shoulderTe").val();
		var shoulderSe = jQuery("#shoulderSe").val();
		if(isNotEmpty(shoulderSe)){
			makeUpVal = shoulderText+"."+shoulderSe;
		}else{
			makeUpVal = shoulderText+".0";
		}
		jQuery("#shoulder").val(makeUpVal);
	})
	jQuery("#shoulderSe").change(function(){
		shoulderSelect = jQuery("#shoulderSe").val();
		shoulderText = jQuery("#shoulderTe").val();
		var makeUpVal = shoulderText+"."+shoulderSelect;
		jQuery("#shoulder").val(makeUpVal);
	})
	
	var reachRightText="";
	var reachRightSelect="";
	jQuery("#reachRightTe").on('input', function(){
		var makeUpVal = null;
		reachRightText = jQuery("#reachRightTe").val();
		var reachRightSe = jQuery("#reachRightSe").val();
		if(isNotEmpty(reachRightSe)){
			makeUpVal = reachRightText+"."+reachRightSe;
		}else{
			makeUpVal = reachRightText+".0";
		}
		jQuery("#reachRight").val(makeUpVal);
	})
	jQuery("#reachRightSe").change(function(){
		reachRightText = jQuery("#reachRightTe").val();
		reachRightSelect = jQuery("#reachRightSe").val();
		var makeUpVal = reachRightText+"."+reachRightSelect;
		jQuery("#reachRight").val(makeUpVal);
	})
	
	var reachLeftText="";
	var reachLeftSelect="";
	jQuery("#reachLeftTe").on('input', function(){
		var makeUpVal = null;
		reachLeftText = jQuery("#reachLeftTe").val();
		var reachLeftSe = jQuery("#reachLeftSe").val();
		if(isNotEmpty(reachLeftSe)){
			makeUpVal = reachLeftText+"."+reachLeftSe;
		}else{
			makeUpVal = reachLeftText+".0";
		}
		jQuery("#reachLeft").val(makeUpVal);
	})
	jQuery("#reachLeftSe").change(function(){
		reachLeftSelect = jQuery("#reachLeftSe").val();
		reachLeftText = jQuery("#reachLeftTe").val();
		var makeUpVal = reachLeftText+"."+reachLeftSelect;
		jQuery("#reachLeft").val(makeUpVal);
	})
	
	var outBustText="";
	var outBustSelect="";
	jQuery("#outBustTe").on('input', function(){
		var makeUpVal = null;
		outBustText = jQuery("#outBustTe").val();
		var outBustSe = jQuery("#outBustSe").val();
		if(isNotEmpty(outBustSe)){
			makeUpVal = outBustText+"."+outBustSe;
		}else{
			makeUpVal = outBustText+".0";
		}
		jQuery("#outBust").val(makeUpVal);
	})
	jQuery("#outBustSe").change(function(){
		outBustText = jQuery("#outBustTe").val();
		outBustSelect = jQuery("#outBustSe").val();
		var makeUpVal = outBustText+"."+outBustSelect;
		jQuery("#outBust").val(makeUpVal);
	})
	
	var bustText="";
	var bustSelect="";
	jQuery("#bustTe").on('input', function(){
		var makeUpVal = null;
		bustText = jQuery("#bustTe").val();
		var bustSe = jQuery("#bustSe").val();
		if(isNotEmpty(bustSe)){
			makeUpVal = bustText+"."+bustSe;
		}else{
			makeUpVal = bustText+".0";
		}
		jQuery("#bust").val(makeUpVal);
	})
	jQuery("#bustSe").change(function(){
		bustSelect = jQuery("#bustSe").val();
		bustText = jQuery("#bustTe").val();
		var makeUpVal = bustText+"."+bustSelect;
		jQuery("#bust").val(makeUpVal);
	})
	
	var jacketWaistText="";
	var jacketWaistSelect="";
	jQuery("#jacketWaistTe").on('input', function(){
		var makeUpVal = null;
		jacketWaistText = jQuery("#jacketWaistTe").val();
		var jacketWaistSe = jQuery("#jacketWaistSe").val();
		if(isNotEmpty(jacketWaistSe)){
			makeUpVal = jacketWaistText+"."+jacketWaistSe;
		}else{
			makeUpVal = jacketWaistText+".0";
		}
		jQuery("#jacketWaist").val(makeUpVal);
	})
	jQuery("#jacketWaistSe").change(function(){
		jacketWaistText = jQuery("#jacketWaistTe").val();
		jacketWaistSelect = jQuery("#jacketWaistSe").val();
		var makeUpVal = jacketWaistText+"."+jacketWaistSelect;
		jQuery("#jacketWaist").val(makeUpVal);
	})
	
	var pantsWaistText="";
	var pantsWaistSelect="";
	jQuery("#pantsWaistTe").on('input', function(){
		var makeUpVal = null;
		pantsWaistText = jQuery("#pantsWaistTe").val();
		var pantsWaistSe = jQuery("#pantsWaistSe").val();
		if(isNotEmpty(pantsWaistSe)){
			makeUpVal = pantsWaistText+"."+pantsWaistSe;
		}else{
			makeUpVal = pantsWaistText+".0";
		}
		jQuery("#pantsWaist").val(makeUpVal);
	})
	jQuery("#pantsWaistSe").change(function(){
		pantsWaistText = jQuery("#pantsWaistTe").val();
		pantsWaistSelect = jQuery("#pantsWaistSe").val();
		var makeUpVal = pantsWaistText+"."+pantsWaistSelect;
		jQuery("#pantsWaist").val(makeUpVal);
	})
	
	var hipText="";
	var hipSelect="";
	jQuery("#hipTe").on('input', function(){
		var makeUpVal = null;
		hipText = jQuery("#hipTe").val();
		var hipSe = jQuery("#hipSe").val();
		if(isNotEmpty(hipSe)){
			makeUpVal = hipText+"."+hipSe;
		}else{
			makeUpVal = hipText+".0";
		}
		jQuery("#hip").val(makeUpVal);
	})
	jQuery("#hipSe").change(function(){
		hipSelect = jQuery("#hipSe").val();
		hipText = jQuery("#hipTe").val();
		var makeUpVal = hipText+"."+hipSelect;
		jQuery("#hip").val(makeUpVal);
	})
	
	var spanRightText="";
	var spanRightSelect="";
	jQuery("#spanRightTe").on('input', function(){
		var makeUpVal = null;
		spanRightText = jQuery("#spanRightTe").val();
		var spanRightSe = jQuery("#spanRightSe").val();
		if(isNotEmpty(spanRightSe)){
			makeUpVal = spanRightText+"."+spanRightSe;
		}else{
			makeUpVal = spanRightText+".0";
		}
		jQuery("#spanRight").val(makeUpVal);
	})
	jQuery("#spanRightSe").change(function(){
		spanRightSelect = jQuery("#spanRightSe").val();
		spanRightText = jQuery("#spanRightTe").val();
		var makeUpVal = spanRightText+"."+spanRightSelect;
		jQuery("#spanRight").val(makeUpVal);
	})
	
	var spanLeftText="";
	var spanLeftSelect="";
	jQuery("#spanLeftTe").on('input', function(){
		var makeUpVal = null;
		spanLeftText = jQuery("#spanLeftTe").val();
		var spanLeftSe = jQuery("#spanLeftSe").val();
		if(isNotEmpty(spanLeftSe)){
			makeUpVal = spanLeftText+"."+spanLeftSe;
		}else{
			makeUpVal = spanLeftText+".0";
		}
		jQuery("#spanLeft").val(makeUpVal);
	})
	jQuery("#spanLeftSe").change(function(){
		spanLeftSelect = jQuery("#spanLeftSe").val();
		spanLeftText = jQuery("#spanLeftTe").val();
		var makeUpVal = spanLeftText+"."+spanLeftSelect;
		jQuery("#spanLeft").val(makeUpVal);
	})
	
	var calfRightText="";
	var calfRightSelect="";
	jQuery("#calfRightTe").on('input', function(){
		var makeUpVal = null;
		var calfRightSe = jQuery("#calfRightSe").val();
		calfRightText = jQuery("#calfRightTe").val();
		if(isNotEmpty(calfRightSe)){
			makeUpVal = calfRightText+"."+calfRightSe;
		}else{
			makeUpVal = calfRightText+".0";
		}
		jQuery("#calfRight").val(makeUpVal);
	})
	jQuery("#calfRightSe").change(function(){
		calfRightText = jQuery("#calfRightTe").val();
		calfRightSelect = jQuery("#calfRightSe").val();
		var makeUpVal = calfRightText+"."+calfRightSelect;
		jQuery("#calfRight").val(makeUpVal);
	})
	
	var calfLeftText="";
	var calfLeftSelect="";
	jQuery("#calfLeftTe").on('input', function(){
		var makeUpVal = null;
		calfLeftText = jQuery("#calfLeftTe").val();
		var calfLeftSe = jQuery("#calfLeftSe").val();
		if(isNotEmpty(calfLeftSe)){
			makeUpVal = calfLeftText+"."+calfLeftSe;
		}else{
			makeUpVal = calfLeftText+".0";
		}
		jQuery("#calfLeft").val(makeUpVal);
	})
	jQuery("#calfLeftSe").change(function(){
		calfLeftText = jQuery("#calfLeftTe").val();
		calfLeftSelect = jQuery("#calfLeftSe").val();
		var makeUpVal = calfLeftText+"."+calfLeftSelect;
		jQuery("#calfLeft").val(makeUpVal);
	})
	
	var neckText="";
	var neckSelect="";
	jQuery("#neckTe").on('input', function(){
		var makeUpVal = null;
		neckText = jQuery("#neckTe").val();
		var neckSe = jQuery("#neckSe").val();
		if(isNotEmpty(neckSe)){
			makeUpVal = neckText+"."+neckSe;
		}else{
			makeUpVal = neckText+".0";
		}
		jQuery("#neck").val(makeUpVal);
	})
	jQuery("#neckSe").change(function(){
		neckText = jQuery("#neckTe").val();
		neckSelect = jQuery("#neckSe").val();
		var makeUpVal = neckText+"."+neckSelect;
		jQuery("#neck").val(makeUpVal);
	})
}

function defaultGoodsInit(){
	var goodsTemp = null;
	for (goodsTemp of defaultList.activeList) {
		//プルダウンの場合
		if(goodsTemp.type == "2"){
			jQuery("#"+goodsTemp.id+" option[value='"+goodsTemp.dVal+"']").prop("selected", true);
		//ラジオボタンの場合
		}else if(goodsTemp.type == "1"){
			jQuery(":radio[name='" + goodsTemp.id + "'][value='" + goodsTemp.dVal + "']").prop("checked", true);
		}
	}
}

jQuery('#coConfirm').click(function(){
	// 確認メッセージ
	swal({
		  text: getMsg('msg122'),
		  icon: "info",
		  buttons: ["キャンセル", true],
		}).then((isConfirm) => {
		    if (isConfirm) {
			 imageCheck();
		  	}
		});

	return false;
})
//--------------------------------------------
//メジャーリングの初期化
//--------------------------------------------
function measuring(){
	
	var measuringList = [
		{type:"fullLength",size:"${measuring.fullLength}"},
		{type:"shoulder",size:"${measuring.shoulder}"},
		{type:"reachRight",size:"${measuring.reachRight}"},
		{type:"reachLeft",size:"${measuring.reachLeft}"},
		{type:"outBust",size:"${measuring.outBust}"},
		{type:"bust",size:"${measuring.bust}"},
		{type:"jacketWaist",size:"${measuring.jacketWaist}"},
		{type:"pantsWaist",size:"${measuring.pantsWaist}"},
		{type:"hip",size:"${measuring.hip}"},
		{type:"spanRight",size:"${measuring.spanRight}"},
		{type:"spanLeft",size:"${measuring.spanLeft}"},
		{type:"calfRight",size:"${measuring.calfRight}"},
		{type:"calfLeft",size:"${measuring.calfLeft}"},
		{type:"neck",size:"${measuring.neck}"}
		];
	
	var i = null;
	for(i of measuringList){
		var measuring = i.size;
		measuring = measuring.split(".");
		if(measuring[0]=="0"&&measuring[1]=="0"){

		}else{
			jQuery("#"+i.type+"Te").val(measuring[0]);
			jQuery("#"+i.type+"Se").val(measuring[1]);
			jQuery("#"+i.type).val(i.size)
		}
	}
	

}
//日付書式の変更
function dateFormat(time){
	var date = new Date(time);
	var year = date.getFullYear();  
	var month = date.getMonth() + 1;
	if(month<=9){
		month = "0" + month;
	}
	var day = date.getDate();
	if(day<=9){
		day = "0" + day;
	}
	return year+"/"+month+"/"+day;
}

function stockCheck(){
	jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').ghostsf_serialize(),type: "post",async:false});
	var checkFlag = true;
	var item = jQuery("#item option:selected").val();
	var productFabricNo = jQuery("#productFabricNo").val();
	jQuery("div.error-message-list").hide();
	//注文のTSCステータス
	//var orderStatus = "${order.tscStatus}";
	var orderStatus = jQuery("#orderTscStatus").val();
	//戻るの場合、orderFormのTSCステータス
	var orderFormStatus = "${orderForm.status}";
	//T0 ：一時保存、T1 ：取り置き、""：ステータス無し
	//オーダー一覧から来たの場合
	if(　((orderStatus=="T0"||orderStatus=="T1")&&orderFormStatus=="")||
		//「内容確認」画面来たの場合	
		((orderFormStatus=="T0"||orderFormStatus=="T1")&&orderStatus=="")||
		//新規登録の場合
		(orderStatus==""&&orderFormStatus=="")){
		//TSCステータス  一時保存
		var statusInput = jQuery("#statusInput").val();

		if(statusInput==""||statusInput==null){
			jQuery("#statusInput").val("T0");
		}else{
			jQuery("#statusInput").val(jQuery("#statusInput").val());
		}
		//生地品番が無しの場合
		if(isEmpty(productFabricNo)){
			//生地のメッセージをクリア
			jQuery("#notice").empty();
	    	jQuery("#fabric_brand_nm_p").empty();
	    	jQuery("#service_nm_p").empty();
			jQuery("#compos_frt_fabric_p").empty();
			jQuery("#goodsPrice").html('0');
			jQuery("productPriceId").val("");
			jQuery("#theoryFabricUsedMountId").val("");
			jQuery("#fabricColor").val("");
			jQuery("#fabricPattern").val("");
			jQuery("#factoryCode").val("");
			jQuery("#makerCode").val("");
			jQuery("#fabricMsg").empty();
			jQuery("#fabricFlag").val("0");
			jQuery("#custShopDeliveryDate").val("");
			jQuery("#stockMsg").empty();
			jQuery("#lcrSewing_id2").removeAttr("disabled","disabled");
			jQuery("#jkDoubleModelPrice").val("0");
		  	jQuery("#ctDoubleModelPrice").val("0");
			optionRetailPrice("");
			allPrice();

			//注文を登録
			optionControlNotDisabled();
			jQuery.ajax({
				 type:"post",
				 url: contextPath + "/orderCo/stockDecrease",
				 data: jQuery('#idForm').ghostsf_serialize(),
				 async:false,
				 success:function(result){
					 checkFlag = true;
					 if(!result.orderMsgFlag){
						  if(result.orderMsg == 'T2ERROR'){
							  swal({
			        				text: getMsg('msg048'),
			        				icon: "info"
			        		  }).then(function(val){
			        				window.location.href= contextPath + "/orderlist/gotoOrderlist";
			        		  });
						  }else if(result.orderMsg == 'T3ERROR'){
							  swal({
			        				text: getMsg('msg048'),
			        				icon: "info"
			        		  }).then(function(val){
			        				window.location.href= contextPath + "/orderlist/gotoOrderlist";
			        		  });
						  }
					}else{
						if(result.orderId == "true"){
							//ステータス設定
						   	jQuery("#status").empty();
						   	var statusInput = jQuery("#statusInput").val();
							if(statusInput=="T0"){
							   jQuery("#status").html("一時保存");
							}else{
							   jQuery("#status").html("取り置き");
							}
						 }else if(result.orderId.length == 12){
							 appendAlertDel('errormssage');
							 jQuery("#orderId").val(result.orderId);
						     //ステータス設定
							 jQuery("#status").empty();
						   	 var statusInput = jQuery("#statusInput").val();
							 if(statusInput=="T0"){
							 	 jQuery("#status").html("一時保存");
							 }else{
								 jQuery("#status").html("取り置き");
							 }
							 var version = jQuery.ajax({url:contextPath + "/orderCo/getOrderVersion",data:{"orderId":result.orderId},async:false});
							 version = version.responseText;
							 jQuery("#version").val(version);
						 }
					}
		    	 },
		         error:function (result) {
		        	 checkFlag = false;
		         }
			})
		//生地品番が有りの場合
		}else{
			//在庫チェック
			var checkResult = fabricCheck(item,productFabricNo);
			//在庫成功の場合
			if(checkResult == "0"){
				//注文を登録　8、9
				optionControlNotDisabled();
				jQuery.ajax({
					 type:"post",
					 url: contextPath + "/orderCo/stockDecrease",
					 data: jQuery('#idForm').ghostsf_serialize(),
					 async:false,
					 success:function(result){
						 checkFlag = true;
						 if(!result.orderMsgFlag){
							  if(result.orderMsg == 'T2ERROR'){
								  swal({
				        				text: getMsg('msg048'),
				        				icon: "info"
				        		  }).then(function(val){
				        				window.location.href= contextPath + "/orderlist/gotoOrderlist";
				        		  });
							  }else if(result.orderMsg == 'T3ERROR'){
								  swal({
				        				text: getMsg('msg048'),
				        				icon: "info"
				        		  }).then(function(val){
				        				window.location.href= contextPath + "/orderlist/gotoOrderlist";
				        		  });
							  }
						}else{
							if(result.orderId == "true"){
								//ステータス設定
							   	jQuery("#status").empty();
							   	var statusInput = jQuery("#statusInput").val();
								if(statusInput=="T0"){
								   jQuery("#status").html("一時保存");
								}else{
								   jQuery("#status").html("取り置き");
								}
							 }else if(result.orderId.length == 12){
								 appendAlertDel('errormssage');
								 jQuery("#orderId").val(result.orderId);
							     //ステータス設定
								 jQuery("#status").empty();
							   	 var statusInput = jQuery("#statusInput").val();
								 if(statusInput=="T0"){
								 	 jQuery("#status").html("一時保存");
								 }else{
									 jQuery("#status").html("取り置き");
								 }
								 var version = jQuery.ajax({url:contextPath + "/orderCo/getOrderVersion",data:{"orderId":result.orderId},async:false});
								 version = version.responseText;
								 jQuery("#version").val(version);
							 }
						}
			    	 },
			         error:function (result) {
			        	 checkFlag = false;
			         }
				})
			}
			//生地によって、商品を表示
			if(checkResult == "0"||checkResult == "2"){
				fabricView(item,productFabricNo);
			}
		}
	}
	//登録済以降の場合
	else{
	    //在庫チェック
	    var checkResult = fabricCheck(item,productFabricNo);
	    //在庫成功の場合
		if(checkResult){
			//生地によって、商品を表示
			fabricView(item,productFabricNo);
		}
	}
	optionControlDisabled();
	projectControl();
	return checkFlag;
}

//生地によって、商品を表示
function fabricView(item,productFabricNo){
	jQuery.ajax({
		 type:"get",
		 url: contextPath + "/orderCo/findStock",
		 data:{"fabricNo":productFabricNo,"orderPattern":orderPattern},
		 async:false,
		 success:function(result){
			 if(result == "" || result == null){
				 
			 }else{
				 // 生地品番の色を取得
				 var color = result.color;
				 // 生地品番の柄を取得
				 var pattern = result.pattern;

				 //LCR縫製可否
				 var lcrSewing = result.lcrSewingAvailable;
				 //LCR縫製否の場合
				 if(lcrSewing == "0"){
					jQuery("#lcrSewing_id2").prop("disabled",true);
					jQuery("#lcrSewing_id1").prop("checked","checked");
					jQuery("input[name='productLcrSewing']:checked").change();
				 }
				 //LCR縫製有りの場合
				 else if(lcrSewing == "1"){
					 jQuery("#lcrSewing_id2").removeAttr("disabled",false);
					 //jQuery("#lcrSewing_id1").prop("checked","checked");
					 //jQuery("input[name='productLcrSewing']:checked").change();
				 }
				  
				 //商品金額と合計金額を計算する　7
				 allGoodsPrice(result);

				 optionRetailPrice(result);
				  
				 // 生地品番の値から対象の素材色をセット
				 jQuery("#factoryCode").val(result.factoryCode);
				 jQuery("#makerCode").val(result.makerCode);
				 jQuery("#productFabricBrandNm").val(result.brandName);
				 jQuery("#productServiceNm").val(result.materialName);
				 jQuery("#productComposFrtFabric").val(result.compositionLabel);
				 jQuery("#productNotice").val(result.handlingCaution);
				 jQuery("#fabricColor").val(color);
				 jQuery("#fabricPattern").val(pattern);

				 var countUsage = result.stockResult;
				 jQuery("#stockMsg").html("-" + color + pattern + " 在庫 " + countUsage + "m");
				 //理論在庫を表示
				 jQuery("#fabric_brand_nm_p").html(result.brandName);
				 jQuery("#service_nm_p").html(result.materialName);
				 
				 //組成表示　表地
				 jQuery("#compos_frt_fabric_p").empty();
				 jQuery("#compos_frt_fabric_p").append(result.compositionLabel);
				 jQuery("#notice").html(result.handlingCaution);
				 allPrice();
			 }
    	 }
	})
	jQuery('#stockMsg').show();
}

//--------------------------------------------
//合計金額
//--------------------------------------------
function allPrice(){
	//optionPrice：オプション金額、　goodsPrice：商品金額
	var priceDivList = ["optionPrice","goodsPrice"]
	var priceDiv = null;
	var count = 0;
	var price;
	for(priceDiv of priceDivList){
		price = jQuery("#"+priceDiv).html();
		if(price.length>3){
			price = price.replace(/,/g,'');
		}
		count += Number(price);
	}
	count = count.toString();
	jQuery("#totalPriceId").val(count)
	count = formatMoney(count,0,"");
	
  jQuery("#allPrice").html(count)


  var myDate = new Date();
  var excisePrice;
  var askPrice;
  var taxRate = "${orderCoForm.taxRate}"
	if(count.length>3){
		count = count.replace(/,/g,'');
	}
	excisePrice = Math.floor(Number(count) * Number(taxRate)/100);
	askPrice = excisePrice + Number(count);

	jQuery("#consumptionTaxAmountId").val(excisePrice.toString());
	jQuery("#billingAmountId").val(askPrice.toString())
		 
	excisePrice = formatMoney(excisePrice.toString(),0,"");
	askPrice = formatMoney(askPrice.toString(),0,"");
		
	jQuery("#askPrice").html(askPrice);
	jQuery("#excisePrice").html(excisePrice);
}

//--------------------------------------------
//金額フォーマット
//--------------------------------------------
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

function optionRetailPrice(result){
	
	if(result == ""){
	   jQuery("#threePiece_Msg").empty();
	   jQuery("#sparePants_Msg").empty();
	   jQuery("#jacketModel_Msg").empty();
	}else{
		  var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
		  //3Pieceが有りの場合
		  if(threePiece == "0009902"){
			 var formulaPrice = result.is3PiecePrice;
			 var format = formatMoney(Number(formulaPrice),0,"￥");
			 jQuery("#threePiece_Msg").html(format);
		  }
		  //3Pieceが無しの場合
		  else if(threePiece == "0009901"){
			 jQuery("#threePiece_Msg").html("無料");
		  }
		  
		  jQuery('input[name="productIs3Piece"]:checked').change(function(){
			  var threePiece = jQuery(this).val();
			  //3Pieceが有りの場合
			  if(threePiece == "0009902"){
				 var formulaPrice = result.is3PiecePrice;
				 var format = formatMoney(Number(formulaPrice),0,"￥");
				 jQuery("#threePiece_Msg").html(format);
			  }
			  //3Pieceが無しの場合
			  else if(threePiece == "0009901"){
				 jQuery("#threePiece_Msg").html("無料");
	 	      }
		  })
		
		  var twoPants = jQuery('input[name="productSparePantsClass"]:checked').val();
		  //2Pantsが有りの場合
		  if(twoPants == "0009902"){
			 var formulaPrice = result.is2PantsPrice;
			 var format = formatMoney(Number(formulaPrice),0,"￥");
			 jQuery("#sparePants_Msg").html(format);
		  }
		  //2Pantsが無しの場合
		  else if(twoPants == "0009901"){
			 jQuery("#sparePants_Msg").html("無料");
 	      }
 	      
		  jQuery('input[name="productSparePantsClass"]:checked').change(function(){
			  var twoPants = jQuery(this).val();
			  //2Pantsが有りの場合
			  if(twoPants == "0009902"){
				 var formulaPrice = result.is2PantsPrice;
				 var format = formatMoney(Number(formulaPrice),0,"￥");
				 jQuery("#sparePants_Msg").html(format);
			  }
			  //2Pantsが無しの場合
			  else if(twoPants == "0009901"){
				 jQuery("#sparePants_Msg").html("無料");
	 	      }
		  })

		  var item = jQuery("#item").val();
		  if(item == "01"){
			  jQuery("#jkDoubleModelPrice").val(result.jkDoublePrice);
			  jQuery("#glDoubleModelPrice").val(result.glDoublePrice);
		  }else if(item == "02"){
			  jQuery("#jkDoubleModelPrice").val(result.jkDoublePrice);
		  }else if(item == "04"){
			  jQuery("#glDoubleModelPrice").val(result.glDoublePrice);
		  }else if(item == "06"){
			  jQuery("#ctDoubleModelPrice").val(result.ctDoublePrice);
		  }
	}
	 allOptionPrice();
}
//--------------------------------------------
//オプション金額
//--------------------------------------------
function allOptionPrice(){
	var count = 0;
	var sparePantsPrice = jQuery("#sparePants_Msg").html();
	var threePiecePrice = jQuery("#threePiece_Msg").html();
	sparePantsPrice = htmlPriceFormat(sparePantsPrice);
	threePiecePrice = htmlPriceFormat(threePiecePrice);
	

	var jkOptionPriceId = jQuery("#jkOptionPriceId").val();
	var glOptionPriceId = jQuery("#glOptionPriceId").val();
	var ptOptionPriceId = jQuery("#ptOptionPriceId").val();
	var pt2OptionPriceId = jQuery("#pt2OptionPriceId").val();
	var ctOptionPriceId = jQuery("#ctOptionPriceId").val();
	var stOptionPriceId = jQuery("#stOptionPriceId").val();
	var jkDoubleModelPrice = jQuery("#jkDoubleModelPrice").val();
	var ctDoubleModelPrice = jQuery("#ctDoubleModelPrice").val();
	var glDoubleModelPrice = jQuery("#glDoubleModelPrice").val();
	var expediteDeliveryPrice = jQuery("#expediteDeliveryPrice").val();
	var lcrSewingPrice = jQuery("#lcrSewingPrice").val();
	var embroideryNmPosPrice = jQuery("#embroideryNmPosPrice").val();
	var gadgetPrice = jQuery("#gadgetPrice").val();

	var item = jQuery("#item").val();
	var hasThreePiece = jQuery('input[name="productIs3Piece"]:checked').val();
	var hasTwoPants = jQuery('input[name="productSparePantsClass"]:checked').val();
	if(item == "01"){
		count = Number(count) + Number(jkOptionPriceId) + Number(ptOptionPriceId) + Number(jkDoubleModelPrice) + Number(lcrSewingPrice);
		if(hasThreePiece == "0009902"){
			count = Number(count) + Number(glOptionPriceId) + Number(glDoubleModelPrice) + Number(threePiecePrice);
		}
		if(hasTwoPants == "0009902"){
			count = Number(count) + Number(pt2OptionPriceId) + Number(sparePantsPrice);
		}
	}else if(item == "02"){
		count = Number(count) + Number(jkOptionPriceId) + Number(jkDoubleModelPrice) + Number(lcrSewingPrice);
	}else if(item == "03"){
		count = Number(count) + Number(ptOptionPriceId) + Number(lcrSewingPrice);
	}else if(item == "04"){
		count = Number(count) + Number(glOptionPriceId) + Number(glDoubleModelPrice) + Number(lcrSewingPrice);
	}else if(item == "05"){
		count = Number(count) + Number(stOptionPriceId);
		var productEmbroideryNecessity = jQuery('input[name=productEmbroideryNecessity]:checked').val();
		if (productEmbroideryNecessity == '9000502') {
			count = Number(count) + Number(embroideryNmPosPrice) + Number(gadgetPrice);
		}
	}else if(item == "06"){
		count = Number(count) + Number(ctDoubleModelPrice) + Number(ctOptionPriceId);
	}

	count = Number(count) + Number(expediteDeliveryPrice);
	
	count = count.toString();
	jQuery("#optionPriceId").val(count);
	count = formatMoney(count,0,"");
	jQuery("#optionPrice").html(count);
	allPrice();
}
//--------------------------------------------
//商品金額
//--------------------------------------------
function allGoodsPrice(result){
	
	var itemCode;
	var threePiece;
	var productSparePantsClass;
	var frontBtnCnt;
	var goodsPrice;
	var glModel;
	
	
	itemCode = jQuery("#item option:selected").val();
	
	threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
	
	hasTwoPants = jQuery('input[name="productSparePantsClass"]:checked').val();
	
	goodsPrice = result.productPrice;
  if(isNaN(goodsPrice)){
  	jQuery("#goodsPrice").html('0')
  	jQuery("#productPriceId").val('0');
  }else{
  	goodsPrice = Math.floor(goodsPrice)
  	jQuery("#productPriceId").val(goodsPrice);
  	goodsPrice = goodsPrice.toString();
  	goodsPrice = formatMoney(goodsPrice,0,"");
  	jQuery("#goodsPrice").html(goodsPrice)
  }
  
  allPrice();
}


//生地チェク
function fabricCheck(item,productFabricNo){
	//生地チェク成功フラッグ
	var fabricCheckValue = "0";
	var jkModelFlag = "0";
	var glModelFlag = "0";
	var ptModelFlag = "0";
	var pt2ModelFlag = "0";
	var ctModelFlag = "0";
	var shModelFlag = "0";
	//カテゴリ
	var category = jQuery('input[name="productCategory"]:checked').val();
	//半角英数字チェック  1
	if(isAlphabetNumeric(productFabricNo)){
		 setAlert('stockMsg', getMsgByTwoArgs('msg012', '生地品番', '半角英数字'));
		 //生地メッセージをクリア
		 jQuery("#notice").empty();
	     jQuery("#fabric_brand_nm_p").empty();
		 jQuery("#service_nm_p").empty();
		 jQuery("#compos_frt_fabric_p").empty();
		 jQuery("#factoryCode").val("");
		 jQuery("#theoryFabricUsedMountId").val("");
		 jQuery("#makerCode").val("");
		 jQuery("#goodsPrice").html('0');
		 jQuery("#fabricColor").val("");
		 jQuery("#fabricPattern").val("");
		 jQuery("#threePiece_Msg").empty();
		 jQuery("#sparePants_Msg").empty();
		 jQuery("#jacketModel_Msg").empty();
		 jQuery("#fabricMsg").empty();
		 jQuery("#jkModelFlag").val("0");
		 jQuery("#ptModelFlag").val("0");
		 jQuery("#glModelFlag").val("0");
		 jQuery("#pt2ModelFlag").val("0");
		 jQuery("#jkDoubleModelPrice").val("0");
		 jQuery("#ctDoubleModelPrice").val("0");
		 /* jQuery("#jacketModelMsg").empty();
		 jQuery("#pantsModelMsg").empty();
		 jQuery("#2pantsModelMsg").empty();
		 jQuery("#giletModelMsg").empty(); */
		 jQuery("#fabricMsg").empty();

		 jQuery("#lcrSewing_id2").removeAttr("disabled","disabled");
		 allOptionPrice();
		 //生地チェク失敗フラッグ
		 fabricCheckValue = "1";
		 jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsgByTwoArgs('msg012', '生地品番', '英数字'));
	}
	else{
	    jQuery.ajax({
	     	 type:"get",
	     	 url: contextPath + "/orderCo/findStock",
	     	 data:{"fabricNo":productFabricNo,"orderPattern":orderPattern},
	     	 async:false,
	     	 success:function(result){
		     	//生地情報が無しの場合　3
	     		if(result == "" || result == null){
	     			　//生地メッセージをクリア
	     			 jQuery("#notice").empty();
	 			   	 jQuery("#fabric_brand_nm_p").empty();
	 			   	 jQuery("#service_nm_p").empty();
	 				 jQuery("#compos_frt_fabric_p").empty();
	 				 jQuery("#goodsPrice").html('0');
	   				 jQuery("productPriceId").val("")
	   				 jQuery("#factoryCode").val("");
					 jQuery("#makerCode").val("");
					 jQuery("#fabricColor").val("");
					 jQuery("#fabricPattern").val("");
					 jQuery("#theoryFabricUsedMountId").val("");
					 jQuery("#custShopDeliveryDate").val("");
					 jQuery("#threePiece_Msg").empty();
					 jQuery("#sparePants_Msg").empty();
					 jQuery("#jacketModel_Msg").empty();
					 jQuery("#fabricMsg").empty();
					 jQuery("#jkDoubleModelPrice").val("0");
					 jQuery("#ctDoubleModelPrice").val("0");
					 jQuery("#lcrSewing_id2").removeAttr("disabled","disabled");
					 allOptionPrice();
	 				 setAlert('stockMsg', getMsg('msg049'));
	 				 //生地チェク失敗フラッグ
	 				 fabricCheckValue = "1";
	 				 jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsg('msg049'));
	     		} 
	     		//生地情報が有りの場合
	     		else{
	     			//モデルチェック
		     		if(item == "01"){
		     			jQuery("#fabricMsg").empty();
		     			var jkCheckResult = result.jkModelCheck;
		     			if(jkCheckResult == true){
		     				//生地チェク成功フラッグ
	     					jkModelFlag = "0";
	     					fabricCheckValue = "0";
	     					jQuery("#jkModelFlag").val(jkModelFlag);
			     		}else{
			     			//生地チェク失敗フラッグ
		     				jkModelFlag = "1";
		     				fabricCheckValue = "2";
		     				setAlert('fabricMsg', getMsgByOneArg('msg065','JACKET'));
		     				jQuery("#jkModelFlag").val(jkModelFlag+"*"+getMsgByOneArg('msg065','JACKET'));
				     	}

		     			var ptCheckResult = result.ptModelCheck;
						if(ptCheckResult == true){
							//生地チェク成功フラッグ
	     					ptModelFlag = "0";
	     					fabricCheckValue = "0";
	     					jQuery("#ptModelFlag").val(ptModelFlag);
	     					//jQuery("#fabricMsg").empty();
			     		}else{
			     			//生地チェク失敗フラッグ
		     				ptModelFlag = "1";
		     				fabricCheckValue = "2";
		     				setAlert('fabricMsg', getMsgByOneArg('msg065','PANTS'));
		     				jQuery("#ptModelFlag").val(ptModelFlag+"*"+getMsgByOneArg('msg065','PANTS'));
				     	}

						 var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
						 var twoPants = jQuery('input[name="productSparePantsClass"]:checked').val();
						 if(threePiece == "0009902"){
							 var glCheckResult = result.glModelCheck;
								if(glCheckResult == true){
									//生地チェク成功フラッグ
			     					glModelFlag = "0";
			     					fabricCheckValue = "0";
			     					jQuery("#glModelFlag").val(glModelFlag);
			     					//jQuery("#fabricMsg").empty();
					     		}else{
					     			//生地チェク失敗フラッグ
				     				glModelFlag = "1";
				     				fabricCheckValue = "2";
				     				setAlert('fabricMsg', getMsgByOneArg('msg065','GILET'));
				     				jQuery("#glModelFlag").val(glModelFlag+"*"+getMsgByOneArg('msg065','GILET'));
						     	}
						 }
						 if(twoPants == "0009902"){
							var pt2CheckResult = result.pt2ModelCheck;
							if(pt2CheckResult == true){
								//生地チェク成功フラッグ
		     					pt2ModelFlag = "0";
		     					fabricCheckValue = "0";
		     					jQuery("#pt2ModelFlag").val(pt2ModelFlag);
		     					//jQuery("#fabricMsg").empty();
				     		}else{
				     			//生地チェク失敗フラッグ
			     				pt2ModelFlag = "1";
			     				fabricCheckValue = "2";
			     				appendAlertPo('fabricMsg', getMsgByOneArg('msg065','PANTS（2本目）'));
			     				jQuery("#pt2ModelFlag").val(pt2ModelFlag+"*"+getMsgByOneArg('msg065','PANTS（2本目）'));
					     	}
						 }
			     	}else if(item == "02"){
	     				var jkCheckResult = result.jkModelCheck;
		     			if(jkCheckResult == true){
		     				//生地チェク成功フラッグ
	     					jkModelFlag = "0";
	     					fabricCheckValue = "0";
	     					jQuery("#jkModelFlag").val(jkModelFlag);
	     					jQuery("#fabricMsg").empty();
			     		}else{
			     			//生地チェク失敗フラッグ
		     				jkModelFlag = "1";
		     				fabricCheckValue = "2";
		     				setAlert('fabricMsg', getMsgByOneArg('msg065','JACKET'));
		     				jQuery("#jkModelFlag").val(jkModelFlag+"*"+getMsgByOneArg('msg065','JACKET'));
				     	}
		     		}else if(item == "03"){
						var ptCheckResult = result.ptModelCheck;
						if(ptCheckResult == true){
							//生地チェク成功フラッグ
	     					ptModelFlag = "0";
	     					fabricCheckValue = "0";
	     					jQuery("#ptModelFlag").val(ptModelFlag);
	     					jQuery("#fabricMsg").empty();
			     		}else{
			     			//生地チェク失敗フラッグ
		     				ptModelFlag = "1";
		     				fabricCheckValue = "2";
		     				setAlert('fabricMsg', getMsgByOneArg('msg065','PANTS'));
		     				jQuery("#ptModelFlag").val(ptModelFlag+"*"+getMsgByOneArg('msg065','PANTS'));
				     	}
			     	}else if(item == "04"){
						var glCheckResult = result.glModelCheck;
						if(glCheckResult == true){
							//生地チェク成功フラッグ
	     					glModelFlag = "0";
	     					fabricCheckValue = "0";
	     					jQuery("#glModelFlag").val(glModelFlag);
	     					jQuery("#fabricMsg").empty();
			     		}else{
			     			//生地チェク失敗フラッグ
		     				glModelFlag = "1";
		     				fabricCheckValue = "2";
		     				setAlert('fabricMsg', getMsgByOneArg('msg065','GILET'));
		     				jQuery("#glModelFlag").val(glModelFlag+"*"+getMsgByOneArg('msg065','GILET'));
				     	}
				    }else if(item == "05"){
				    	var shCheckResult = result.shModelCheck;
				    	if(shCheckResult == true){
							//生地チェク成功フラッグ
	     					shModelFlag = "0";
	     					fabricCheckValue = "0";
	     					jQuery("#shModelFlag").val(shModelFlag);
	     					jQuery("#fabricMsg").empty();
			     		}else{
			     			//生地チェク失敗フラッグ
		     				shModelFlag = "1";
		     				fabricCheckValue = "2";
		     				setAlert('fabricMsg', getMsgByOneArg('msg065','SHIRT'));
		     				jQuery("#shModelFlag").val(shModelFlag+"*"+getMsgByOneArg('msg065','SHIRT'));
				     	}
					}else if(item == "06"){
				    	var ctCheckResult = result.ctModelCheck;
				    	if(ctCheckResult == true){
							//生地チェク成功フラッグ
	     					ctModelFlag = "0";
	     					fabricCheckValue = "0";
	     					jQuery("#ctModelFlag").val(ctCheckResult);
	     					jQuery("#fabricMsg").empty();
			     		}else{
			     			//生地チェク失敗フラッグ
		     				ctModelFlag = "1";
		     				fabricCheckValue = "2";
		     				setAlert('fabricMsg', getMsgByOneArg('msg065','COAT'));
		     				jQuery("#ctModelFlag").val(ctModelFlag+"*"+getMsgByOneArg('msg065','COAT'));
				     	}
					}
	     			
		     		//入力した生地は選択したITEMを作るできるのチェク
		     		//canMake(アイテム,アイテム区分)　4
	     			if(!canMake(item,result.itemClass,result.coatAvailable)){
	     				//生地メッセージをクリア	
	     				jQuery("#notice").empty();
	     			    jQuery("#fabric_brand_nm_p").empty();
	     			    jQuery("#service_nm_p").empty();
	     				jQuery("#compos_frt_fabric_p").empty();
	     				jQuery("#goodsPrice").html('0');
	       				jQuery("productPriceId").val("");
	       				jQuery("#factoryCode").val("");
	       				jQuery("#custShopDeliveryDate").val("");
						jQuery("#makerCode").val("");
						jQuery("#theoryFabricUsedMountId").val("");
						jQuery("#fabricColor").val("");
						jQuery("#fabricPattern").val("");
						jQuery("#threePiece_Msg").empty();
						jQuery("#sparePants_Msg").empty();
						jQuery("#jacketModel_Msg").empty();
						jQuery("#fabricMsg").empty();
						jQuery("#jkDoubleModelPrice").val("0");
					  	jQuery("#ctDoubleModelPrice").val("0");
						jQuery("#lcrSewing_id2").removeAttr("disabled","disabled");
						allOptionPrice();
	     				setAlert('stockMsg', getMsg('msg049'));
	     				//生地チェク失敗フラッグ
	     				fabricCheckValue = "1";
	     				jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsg('msg049'));
	     				return false;
	         		 }
					 //生地店着日チェク
					 //isShopDeliveryEmpty(店着納期区分（通常）,生地品番)　5
	     			 if(!isShopDeliveryEmpty(result,item)){
		     			var earlyDiscount = jQuery("#earlyDiscount").val();
	         			//生地メッセージをクリア
	         			jQuery("#notice").empty();
	     			    jQuery("#fabric_brand_nm_p").empty();
	     			    jQuery("#service_nm_p").empty();
	     				jQuery("#compos_frt_fabric_p").empty();
	     				jQuery("#goodsPrice").html('0');
	       				jQuery("productPriceId").val("");
	       				jQuery("#theoryFabricUsedMountId").val("");
	       				jQuery("#fabricColor").val("");
						jQuery("#fabricPattern").val("");
						jQuery("#factoryCode").val("");
						jQuery("#custShopDeliveryDate").val("");
						jQuery("#makerCode").val("");
						jQuery("#fabricMsg").empty();
						jQuery("#threePiece_Msg").empty();
						jQuery("#sparePants_Msg").empty();
						jQuery("#jacketModel_Msg").empty();
						jQuery("#jkDoubleModelPrice").val("0");
					  	jQuery("#ctDoubleModelPrice").val("0");
						jQuery("#lcrSewing_id2").removeAttr("disabled","disabled");
						allOptionPrice();
						//生地チェク失敗フラッグ
						fabricCheckValue = "1";
						if(earlyDiscount == "9001002"){
		     				setAlert('stockMsg', getMsgByOneArg('msg127','早割'));
		     				jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsgByOneArg('msg127','早割'));
			     		}else{
			     			setAlert('stockMsg', getMsgByOneArg('msg072',productFabricNo));
			     			jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsgByOneArg('msg072',productFabricNo));
				     	}
	     				return false;
	     			 }

	     			 //カテゴリチェク
	     			 if(!categoryCheck(result.washableAvailable,result.tuxedoAvailable,category)){
	         			//生地メッセージをクリア
	         			jQuery("#notice").empty();
	     			    jQuery("#fabric_brand_nm_p").empty();
	     			    jQuery("#service_nm_p").empty();
	     				jQuery("#compos_frt_fabric_p").empty();
	     				jQuery("#goodsPrice").html('0');
	       				jQuery("productPriceId").val("");
	       				jQuery("#theoryFabricUsedMountId").val("");
	       				jQuery("#fabricColor").val("");
						jQuery("#fabricPattern").val("");
						jQuery("#factoryCode").val("");
						jQuery("#custShopDeliveryDate").val("");
						jQuery("#makerCode").val("");
						jQuery("#fabricMsg").empty();
						jQuery("#threePiece_Msg").empty();
						jQuery("#sparePants_Msg").empty();
						jQuery("#jacketModel_Msg").empty();
						jQuery("#jkDoubleModelPrice").val("0");
					  	jQuery("#ctDoubleModelPrice").val("0");
						jQuery("#lcrSewing_id2").removeAttr("disabled","disabled");
						fabricCheckValue = "1";
						allOptionPrice();
	     				return false;
	     			 }

	     			  var fakeStock = null;
	     			  var orderId = jQuery("#orderId").val();
	     			  if(isNotEmpty(orderId)){
	     				  fakeStock = jQuery.ajax({url:contextPath + "/orderCo/stockFakeRecovery",data:{"orderId":jQuery("#orderId").val(),"productFabricNo":productFabricNo},async:false});
		     			  fakeStock = fakeStock.responseText;
		     		  }else{
		     			  fakeStock	= "0";
			     	  }
					  
	     			  //要尺を取得
	     			  var yieldNum = result.yieldNum;
	     			  jQuery("#theoryFabricUsedMountId").val(yieldNum);
					  //受注可能在庫数 = 理論在庫 - 予約生地量
	     			  var countUsage = Number(result.theoreticalStock) - (Number(result.reservationStock)-Number(fakeStock));
	     			  //受注可能在庫数チェク　6
	     			  if(countUsage<yieldNum){
     					  setAlert('stockMsg', getMsgByThreeArgs('msg063', result.color,result.pattern,result.stockResult));
     					  //生地メッセージをクリア
     					  jQuery("#notice").empty();
        		    	  jQuery("#fabric_brand_nm_p").empty();
        		    	  jQuery("#service_nm_p").empty();
        				  jQuery("#compos_frt_fabric_p").empty();
        				  jQuery("#goodsPrice").html('0');
        				  jQuery("productPriceId").val("");
        				  jQuery("#factoryCode").val("");
						  jQuery("#makerCode").val("");
						  jQuery("#fabricColor").val("");
						  jQuery("#fabricPattern").val("");
						  jQuery("#fabricMsg").empty();
						  jQuery("#custShopDeliveryDate").val("");
						  jQuery("#theoryFabricUsedMountId").val("");
						  jQuery("#threePiece_Msg").empty();
						  jQuery("#sparePants_Msg").empty();
						  jQuery("#jacketModel_Msg").empty();
						  jQuery("#jkDoubleModelPrice").val("0");
						  	jQuery("#ctDoubleModelPrice").val("0");
						  jQuery("#lcrSewing_id2").removeAttr("disabled","disabled");
						  allOptionPrice();
						  //生地チェク失敗フラッグ
						  fabricCheckValue = "1";
        				  jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsgByThreeArgs('msg063', result.color,result.pattern,result.stockResult));
        				  return false;	 
	     		      }
	     		      
	     			  //LCR縫製可否
	     			  var lcrSewing = result.lcrSewingAvailable;
	     			  
					  if(lcrSewing == "0"){
						 jQuery("#lcrSewing_id2").prop("disabled",true);
						 jQuery("#lcrSewing_id1").prop("checked","checked");
						 jQuery("input[name='productLcrSewing']:checked").change();
					  }
					  else if(lcrSewing == "1"){
						  jQuery("#lcrSewing_id2").removeAttr("disabled",false);
						  //jQuery("#lcrSewing_id1").prop("checked","checked");
						  //jQuery("input[name='productLcrSewing']:checked").change();
					  }
					  
	     			  //商品金額と合計金額を計算する　7
	     			  allGoodsPrice(result);
	     			  optionRetailPrice(result)
	         		  // 生地品番の色を取得
					  var color = result.color;
					  // 生地品番の柄を取得
					  var pattern = result.pattern;
					  // 生地品番の値から対象の素材色をセット
					  jQuery("#factoryCode").val(result.factoryCode);
					  jQuery("#makerCode").val(result.makerCode);
					  jQuery("#theoryFabricUsedMountId").val(yieldNum);
					  jQuery("#productFabricBrandNm").val(result.brandName);
					  jQuery("#productServiceNm").val(result.materialName);
					  jQuery("#productComposFrtFabric").val(result.compositionLabel);
					  jQuery("#productNotice").val(result.handlingCaution);
					  jQuery("#fabricColor").val(color);
					  jQuery("#fabricPattern").val(pattern);
					  jQuery("#fabricFlag").val(fabricCheckValue);
		     	   }
	     		}
	       });	 
		}
	jQuery('#stockMsg').show();
	return fabricCheckValue;
}

//入力した生地は選択したITEMを作るできることをチェックする
function canMake(item,itemClass,coatAvailable){
	// 01:　ｽｰﾂ、ｼﾞｬｹｯﾄ、ﾊﾟﾝﾂ、ｼﾞﾚ、ｺｰﾄﾞ可 、02：ｼﾞｬｹｯﾄ、ｼﾞﾚ、ｺｰﾄﾞ可、05： ｼｬﾂ可、06：ｺｰﾄ可
	var itemClassList = {"01":"01,02,03,04,06","02":"02,04,06","05":"05","06":"06"}
	var itemNum = itemClassList[itemClass];
	itemNum = itemNum.split(",");
	if(jQuery.inArray(item, itemNum)!=-1){
		if(itemClass == "01"&&item == "06"){
			if(coatAvailable == "1"){
				return true;
			}else{
				return false;
			}
		}else if(itemClass == "02"&&item == "06"){
			if(coatAvailable == "1"){
				return true;
			}else{
				return false;
			}
		}else if(itemClass == "06"&&item == "06"){
			if(coatAvailable == "1"){
				return true;
			}else{
				return false;
			}
		}else{
			return true;
		}
	}else{
		return false;
	}
}

//生地店着日チェク
function isShopDeliveryEmpty(result,item){
	var checkResult = true;
	var storeDelv = "";
	//納期短縮
	var expediteDelivery = jQuery("#expediteDelivery").val();
	//早割
	var earlyDiscount = jQuery("#earlyDiscount").val();

	if(item == "06"){
		storeDelv = result.storeDelvCoat;
	}else{
		if(earlyDiscount == "9001002"){
			storeDelv = result.storeDelvEarly;
		}else{
			storeDelv = result.storeDelvNormal;
		}
	}
	jQuery.ajax({url : contextPath + "/orderCo/getShopDeliveryOn", 
		async:false,
		data:{"storeDelv":storeDelv},
		type : 'get'}).then(function(result) {
			if(result.length==0){
				checkResult = false;
			}else{
				if(expediteDelivery == "9000902"){
					var nowDate = new Date();
            		var minDate = new Date(nowDate.getTime() + 24*60*60*1000);
            		var resultDate = dateFormat(result);
					jQuery("#custShopDeliveryDate").datepicker("update",result);
					jQuery("#custShopDeliveryDate").attr("minDate",dateFormat(minDate));
				}else{
					var resultDate = dateFormat(result);
					jQuery("#custShopDeliveryDate").datepicker("update",result);
					jQuery("#custShopDeliveryDate").attr("minDate","true");
				}
				
				appendAlertDel('errormssage');
				checkResult = true;
			}
		})
	return checkResult;
}

function categoryCheck(washableAvailable,tuxedoAvailable,category){
	var checkResult = true;
	if(category == "9000101"){
		
	}else if(category == "9000102"){
		if(tuxedoAvailable == "0"){
			setAlert("stockMsg", getMsgByOneArg('msg127','タキシード'));
			jQuery("#fabricFlag").val("1"+"*"+getMsgByOneArg('msg127','タキシード'));
			checkResult = false;
		}
	}else if(category == "9000103"){
		if(washableAvailable == "0"){
			setAlert("stockMsg", getMsgByOneArg('msg127','ウォッシャブル'));
			jQuery("#fabricFlag").val("1"+"*"+getMsgByOneArg('msg127','ウォッシャブル'));
			checkResult = false;
		}
	}
	return checkResult;
}

function htmlPriceFormat(msg){
	//msg =='' || msg == null
	if(msg =='無料' || isEmpty(msg) || typeof(msg) == "undefined"){
		msg = '0';
	}
	
	if(msg.indexOf("￥")!=-1){
		msg = msg.substr(1,msg.length-1);
		if(msg.length>3){
			msg = msg.replace(/,/g,'');
		}
	}else{
		if(msg.length>3){
			msg = msg.replace(/,/g,'');
		}
	}
	return msg;
}

//組成表示
function compositionExpress(){
	//組成表示の制御
	//JACKET組成表示　胴裏地
	var bodyText = "";
	//JACKET組成表示　袖裏地
	var sleeveText = "";
	//GILET組成表示　胴裏地
	var glBodyText = "";
	//COAT組成表示　胴裏地
	var ctBodyText = "";
	//組成表示　胴裏地
	//item
	var item = jQuery("#item").val();
	//スペアパンツ
	var sparePants = jQuery('input[name="productSparePantsClass"]:checked').val();
	//３Piece
	var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
	jQuery("#compos_body_liner_p").empty();
	jQuery("#productComposBodyLiner").val("");
	jQuery("#compos_sleeve_liner_p").empty();
	jQuery("#productComposSleeveLiner").val("");
	jQuery.ajax({
		 type:"post",
		 url: contextPath + "/orderCo/getComposBodyIiner",
		 data: jQuery('#idForm').ghostsf_serialize(),
		 async:false,
		 contentType: 'text/json,charset=utf-8',
		 success:function(result){
			 if(isEmpty(result)){

			 }else{
				 if(isNotEmpty(result.bodyLiner)){
					 jQuery("#compos_body_liner_p").html(result.bodyLiner);
					 jQuery("#productComposBodyLiner").val(result.bodyLiner);
				 }else{}
				 if(isNotEmpty(result.sleeveLiner)){
					 jQuery("#compos_sleeve_liner_p").html(result.sleeveLiner);
					 jQuery("#productComposSleeveLiner").val(result.sleeveLiner);
				 }else{}
			 }
		 }
	})
}

function projectControl(){
	//ブランドネーム
	var storeBrandCode = jQuery("#storeBrandCode").val();
	if(storeBrandCode == "01"){
		jQuery("#brandName_id1").prop("disabled",true);
		jQuery("#brandName_id2").prop("disabled",false);
		jQuery("#brandName_id3").prop("disabled",false);
	}else{
		jQuery("#brandName_id1").prop("disabled",false);
		jQuery("#brandName_id3").prop("disabled",false);
		jQuery("#brandName_id2").prop("disabled",true);
	}

	//お渡し日
	var expediteDelivery = jQuery("#expediteDelivery").val();
	if(expediteDelivery == "9000901"){
		jQuery("#custShopDeliveryDate").prop("disabled",true)
	}
}
//--------------------------------------------
//再補正チェック
//--------------------------------------------
function entryCheck(){
	// エラーメッセージのDIVを表示しない
	jQuery("div.alert-error").hide();
	jQuery("div.alert-success").hide();

	var item = "${order.productItem}";

	//スペアパンツ  0009901： 無し、0009902：有り
	var twoPants = "${order.productSparePantsClass}";

	//３Piece  0009901： 無し、0009902：有り
	var is3Piece = "${order.productIs3piece}";
	
	//SUITの場合
	if(item == "01"){
		if(twoPants == "0009902"){
			//JACKET
			//着丈修正
			var corJkBodyRe = jQuery("#corJkBodyRe").val();
			if(isNotEmpty(corJkBodyRe)){
				if(isNumericDecimal(corJkBodyRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', '着丈修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corJkBodyReSp = corJkBodyRe.split(".");
				if(corJkBodyReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','着丈修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//ウエスト修正
			var corJkWaistRe = jQuery("#corJkWaistRe").val();
			if(isNotEmpty(corJkWaistRe)){
				if(isNumericDecimal(corJkWaistRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ウエスト修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corJkWaistReSp = corJkWaistRe.split(".");
				if(corJkWaistReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','ウエスト修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//袖丈右修正
			var corJkRightsleeveRe = jQuery("#corJkRightsleeveRe").val();
			if(isNotEmpty(corJkRightsleeveRe)){
				if(isNumericDecimal(corJkRightsleeveRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', '袖丈右修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corJkRightsleeveReSp = corJkRightsleeveRe.split(".");
				if(corJkRightsleeveReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','袖丈右修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//袖丈左修正
			var corJkLeftsleeveRe = jQuery("#corJkLeftsleeveRe").val();
			if(isNotEmpty(corJkLeftsleeveRe)){
				if(isNumericDecimal(corJkLeftsleeveRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', '袖丈左修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corJkLeftsleeveReSp = corJkLeftsleeveRe.split(".");
				if(corJkLeftsleeveReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','袖丈左修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//PANTS
			//ウエスト修正
			var corPtWaistRe = jQuery("#corPtWaistRe").val();
			if(isNotEmpty(corPtWaistRe)){
				if(isNumericDecimal(corPtWaistRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ウエスト修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPtWaistReSp = corPtWaistRe.split(".");
				if(corPtWaistReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','ウエスト修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//ヒップ修正
			var corPtHipRe = jQuery("#corPtHipRe").val();
			if(isNotEmpty(corPtHipRe)){
				if(isNumericDecimal(corPtHipRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ヒップ修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPtHipReSp = corPtHipRe.split(".");
				if(corPtHipReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','ヒップ修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//ワタリ修正
			var corPtThighwidthRe = jQuery("#corPtThighwidthRe").val();
			if(isNotEmpty(corPtThighwidthRe)){
				if(isNumericDecimal(corPtThighwidthRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ワタリ修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPtThighwidthReSp = corPtThighwidthRe.split(".");
				if(corPtThighwidthReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','ワタリ修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//裾幅修正
			var corPtHemwidthRe = jQuery("#corPtHemwidthRe").val();
			if(isNotEmpty(corPtHemwidthRe)){
				if(isNumericDecimal(corPtHemwidthRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', '裾幅修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPtHemwidthReSp = corPtHemwidthRe.split(".");
				if(corPtHemwidthReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','裾幅修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//股下右修正
			var corPtRightinseamRe = jQuery("#corPtRightinseamRe").val();
			if(isNotEmpty(corPtRightinseamRe)){
				if(isNumericDecimal(corPtRightinseamRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', '股下右修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPtRightinseamReSp = corPtRightinseamRe.split(".");
				if(corPtRightinseamReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','股下右修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//股下左修正
			var corPtLeftinseamRe = jQuery("#corPtLeftinseamRe").val();
			if(isNotEmpty(corPtLeftinseamRe)){
				if(isNumericDecimal(corPtLeftinseamRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', '股下左修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPtLeftinseamReSp = corPtLeftinseamRe.split(".");
				if(corPtLeftinseamReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','股下左修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}

			//2PANTS
			//ウエスト修正
			var corPt2WaistRe = jQuery("#corPt2WaistRe").val();
			if(isNotEmpty(corPt2WaistRe)){
				if(isNumericDecimal(corPt2WaistRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'PANTS（2本目）ウエスト修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPt2WaistReSp = corPt2WaistRe.split(".");
				if(corPt2WaistReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','PANTS（2本目）ウエスト修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//ヒップ修正
			var corPt2HipRe = jQuery("#corPt2HipRe").val();
			if(isNotEmpty(corPt2HipRe)){
				if(isNumericDecimal(corPt2HipRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'PANTS（2本目）ヒップ修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPt2HipReSp = corPt2HipRe.split(".");
				if(corPt2HipReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','PANTS（2本目）ヒップ修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//ワタリ修正
			var corPt2ThighwidthRe = jQuery("#corPt2ThighwidthRe").val();
			if(isNotEmpty(corPt2ThighwidthRe)){
				if(isNumericDecimal(corPt2ThighwidthRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'PANTS（2本目）ワタリ修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPt2ThighwidthReSp = corPt2ThighwidthRe.split(".");
				if(corPt2ThighwidthReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','PANTS（2本目）ワタリ修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//裾幅修正
			var corPt2HemwidthRe = jQuery("#corPt2HemwidthRe").val();
			if(isNotEmpty(corPt2HemwidthRe)){
				if(isNumericDecimal(corPt2HemwidthRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'PANTS（2本目）裾幅修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPt2HemwidthReSp = corPt2HemwidthRe.split(".");
				if(corPt2HemwidthReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','PANTS（2本目）裾幅修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//股下右修正
			var corPt2RightinseamRe = jQuery("#corPt2RightinseamRe").val();
			if(isNotEmpty(corPt2RightinseamRe)){
				if(isNumericDecimal(corPt2RightinseamRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'PANTS（2本目）股下右修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPt2RightinseamReSp = corPt2RightinseamRe.split(".");
				if(corPt2RightinseamReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','PANTS（2本目）股下右修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//股下左修正
			var corPt2LeftinseamRe = jQuery("#corPt2LeftinseamRe").val();
			if(isNotEmpty(corPt2LeftinseamRe)){
				if(isNumericDecimal(corPt2LeftinseamRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'PANTS（2本目）股下左修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPt2LeftinseamReSp = corPt2LeftinseamRe.split(".");
				if(corPt2LeftinseamReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','PANTS（2本目）股下左修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
		}else{
			//着丈修正
			var corJkBodyRe = jQuery("#corJkBodyRe").val();
			if(isNotEmpty(corJkBodyRe)){
				if(isNumericDecimal(corJkBodyRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', '着丈修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corJkBodyReSp = corJkBodyRe.split(".");
				if(corJkBodyReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','着丈修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//ウエスト修正
			var corJkWaistRe = jQuery("#corJkWaistRe").val();
			if(isNotEmpty(corJkWaistRe)){
				if(isNumericDecimal(corJkWaistRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ウエスト修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corJkWaistReSp = corJkWaistRe.split(".");
				if(corJkWaistReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','ウエスト修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//袖丈右修正
			var corJkRightsleeveRe = jQuery("#corJkRightsleeveRe").val();
			if(isNotEmpty(corJkRightsleeveRe)){
				if(isNumericDecimal(corJkRightsleeveRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', '袖丈右修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corJkRightsleeveReSp = corJkRightsleeveRe.split(".");
				if(corJkRightsleeveReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','袖丈右修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//袖丈左修正
			var corJkLeftsleeveRe = jQuery("#corJkLeftsleeveRe").val();
			if(isNotEmpty(corJkLeftsleeveRe)){
				if(isNumericDecimal(corJkLeftsleeveRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', '袖丈左修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corJkLeftsleeveReSp = corJkLeftsleeveRe.split(".");
				if(corJkLeftsleeveReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','袖丈左修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//ウエスト修正
			var corPtWaistRe = jQuery("#corPtWaistRe").val();
			if(isNotEmpty(corPtWaistRe)){
				if(isNumericDecimal(corPtWaistRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ウエスト修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPtWaistReSp = corPtWaistRe.split(".");
				if(corPtWaistReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','ウエスト修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//ヒップ修正
			var corPtHipRe = jQuery("#corPtHipRe").val();
			if(isNotEmpty(corPtHipRe)){
				if(isNumericDecimal(corPtHipRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ヒップ修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPtHipReSp = corPtHipRe.split(".");
				if(corPtHipReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','ヒップ修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//ワタリ修正
			var corPtThighwidthRe = jQuery("#corPtThighwidthRe").val();
			if(isNotEmpty(corPtThighwidthRe)){
				if(isNumericDecimal(corPtThighwidthRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ワタリ修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPtThighwidthReSp = corPtThighwidthRe.split(".");
				if(corPtThighwidthReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','ワタリ修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//裾幅修正
			var corPtHemwidthRe = jQuery("#corPtHemwidthRe").val();
			if(isNotEmpty(corPtHemwidthRe)){
				if(isNumericDecimal(corPtHemwidthRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', '裾幅修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPtHemwidthReSp = corPtHemwidthRe.split(".");
				if(corPtHemwidthReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','裾幅修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//股下右修正
			var corPtRightinseamRe = jQuery("#corPtRightinseamRe").val();
			if(isNotEmpty(corPtRightinseamRe)){
				if(isNumericDecimal(corPtRightinseamRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', '股下右修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPtRightinseamReSp = corPtRightinseamRe.split(".");
				if(corPtRightinseamReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','股下右修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//股下左修正
			var corPtLeftinseamRe = jQuery("#corPtLeftinseamRe").val();
			if(isNotEmpty(corPtLeftinseamRe)){
				if(isNumericDecimal(corPtLeftinseamRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', '股下左修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corPtLeftinseamReSp = corPtLeftinseamRe.split(".");
				if(corPtLeftinseamReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','股下左修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			
		}

		if(is3Piece == "0009902"){
			//着丈修正
			var corGlBodylengthRe = jQuery("#corGlBodylengthRe").val();
			if(isNotEmpty(corGlBodylengthRe)){
				if(isNumericDecimal(corGlBodylengthRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', '着丈修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corGlBodylengthReSp = corGlBodylengthRe.split(".");
				if(corGlBodylengthReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','着丈修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//バスト修正
			var corGlBustCorrectRe = jQuery("#corGlBustCorrectRe").val();
			if(isNotEmpty(corGlBustCorrectRe)){
				if(isNumericDecimal(corGlBustCorrectRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'バスト修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corGlBustCorrectReSp = corGlBustCorrectRe.split(".");
				if(corGlBustCorrectReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','バスト修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
			//ウエスト修正
			var corGlWaistCorrectRe = jQuery("#corGlWaistCorrectRe").val();
			if(isNotEmpty(corGlWaistCorrectRe)){
				if(isNumericDecimal(corGlWaistCorrectRe)){
					appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ウエスト修正','半角数字'));
			        return false;
				}else{
					appendAlertDel('errormssage');
				}

				var corGlWaistCorrectReSp = corGlWaistCorrectRe.split(".");
				if(corGlWaistCorrectReSp[0].length>3){
					appendAlert('errormssage', getMsgByOneArg('msg132','ウエスト修正'));
					 return false;
				}else{
					appendAlertDel('errormssage');
				}
			}
		}
	}
	//JACKETの場合
	else if (item == "02"){
		//着丈修正
		var corJkBodyRe = jQuery("#corJkBodyRe").val();
		if(isNotEmpty(corJkBodyRe)){
			if(isNumericDecimal(corJkBodyRe)){
				appendAlert('errormssage', getMsgByTwoArgs('msg012', '着丈修正','半角数字'));
		        return false;
			}else{
				appendAlertDel('errormssage');
			}

			var corJkBodyReSp = corJkBodyRe.split(".");
			if(corJkBodyReSp[0].length>3){
				appendAlert('errormssage', getMsgByOneArg('msg132','着丈修正'));
				 return false;
			}else{
				appendAlertDel('errormssage');
			}
		}
		//ウエスト修正
		var corJkWaistRe = jQuery("#corJkWaistRe").val();
		if(isNotEmpty(corJkWaistRe)){
			if(isNumericDecimal(corJkWaistRe)){
				appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ウエスト修正','半角数字'));
		        return false;
			}else{
				appendAlertDel('errormssage');
			}

			var corJkWaistReSp = corJkWaistRe.split(".");
			if(corJkWaistReSp[0].length>3){
				appendAlert('errormssage', getMsgByOneArg('msg132','ウエスト修正'));
				 return false;
			}else{
				appendAlertDel('errormssage');
			}
		}
		//袖丈右修正
		var corJkRightsleeveRe = jQuery("#corJkRightsleeveRe").val();
		if(isNotEmpty(corJkRightsleeveRe)){
			if(isNumericDecimal(corJkRightsleeveRe)){
				appendAlert('errormssage', getMsgByTwoArgs('msg012', '袖丈右修正','半角数字'));
		        return false;
			}else{
				appendAlertDel('errormssage');
			}

			var corJkRightsleeveReSp = corJkRightsleeveRe.split(".");
			if(corJkRightsleeveReSp[0].length>3){
				appendAlert('errormssage', getMsgByOneArg('msg132','袖丈右修正'));
				 return false;
			}else{
				appendAlertDel('errormssage');
			}
		}
		//袖丈左修正
		var corJkLeftsleeveRe = jQuery("#corJkLeftsleeveRe").val();
		if(isNotEmpty(corJkLeftsleeveRe)){
			if(isNumericDecimal(corJkLeftsleeveRe)){
				appendAlert('errormssage', getMsgByTwoArgs('msg012', '袖丈左修正','半角数字'));
		        return false;
			}else{
				appendAlertDel('errormssage');
			}

			var corJkLeftsleeveReSp = corJkLeftsleeveRe.split(".");
			if(corJkLeftsleeveReSp[0].length>3){
				appendAlert('errormssage', getMsgByOneArg('msg132','袖丈左修正'));
				 return false;
			}else{
				appendAlertDel('errormssage');
			}
		}
	}
	//PANTSの場合
	else if (item == "03"){
		//ウエスト修正
		var corPtWaistRe = jQuery("#corPtWaistRe").val();
		if(isNotEmpty(corPtWaistRe)){
			if(isNumericDecimal(corPtWaistRe)){
				appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ウエスト修正','半角数字'));
		        return false;
			}else{
				appendAlertDel('errormssage');
			}

			var corPtWaistReSp = corPtWaistRe.split(".");
			if(corPtWaistReSp[0].length>3){
				appendAlert('errormssage', getMsgByOneArg('msg132','ウエスト修正'));
				 return false;
			}else{
				appendAlertDel('errormssage');
			}
		}
		//ヒップ修正
		var corPtHipRe = jQuery("#corPtHipRe").val();
		if(isNotEmpty(corPtHipRe)){
			if(isNumericDecimal(corPtHipRe)){
				appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ヒップ修正','半角数字'));
		        return false;
			}else{
				appendAlertDel('errormssage');
			}
			var corPtHipReSp = corPtHipRe.split(".");
			if(corPtHipReSp[0].length>3){
				appendAlert('errormssage', getMsgByOneArg('msg132','ヒップ修正'));
				 return false;
			}else{
				appendAlertDel('errormssage');
			}
		}
		//ワタリ修正
		var corPtThighwidthRe = jQuery("#corPtThighwidthRe").val();
		if(isNotEmpty(corPtThighwidthRe)){
			if(isNumericDecimal(corPtThighwidthRe)){
				appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ワタリ修正','半角数字'));
		        return false;
			}else{
				appendAlertDel('errormssage');
			}
			var corPtThighwidthReSp = corPtThighwidthRe.split(".");
			if(corPtThighwidthReSp[0].length>3){
				appendAlert('errormssage', getMsgByOneArg('msg132','ワタリ修正'));
				 return false;
			}else{
				appendAlertDel('errormssage');
			}
		}
		//裾幅修正
		var corPtHemwidthRe = jQuery("#corPtHemwidthRe").val();
		if(isNotEmpty(corPtHemwidthRe)){
			if(isNumericDecimal(corPtHemwidthRe)){
				appendAlert('errormssage', getMsgByTwoArgs('msg012', '裾幅修正','半角数字'));
		        return false;
			}else{
				appendAlertDel('errormssage');
			}
			var corPtHemwidthReSp = corPtHemwidthRe.split(".");
			if(corPtHemwidthReSp[0].length>3){
				appendAlert('errormssage', getMsgByOneArg('msg132','裾幅修正'));
				 return false;
			}else{
				appendAlertDel('errormssage');
			}
		}
		//股下右修正
		var corPtRightinseamRe = jQuery("#corPtRightinseamRe").val();
		if(isNotEmpty(corPtRightinseamRe)){
			if(isNumericDecimal(corPtRightinseamRe)){
				appendAlert('errormssage', getMsgByTwoArgs('msg012', '股下右修正','半角数字'));
		        return false;
			}else{
				appendAlertDel('errormssage');
			}
			var corPtRightinseamReSp = corPtRightinseamRe.split(".");
			if(corPtRightinseamReSp[0].length>3){
				appendAlert('errormssage', getMsgByOneArg('msg132','股下右修正'));
				 return false;
			}else{
				appendAlertDel('errormssage');
			}
		}
		//股下左修正
		var corPtLeftinseamRe = jQuery("#corPtLeftinseamRe").val();
		if(isNotEmpty(corPtLeftinseamRe)){
			if(isNumericDecimal(corPtLeftinseamRe)){
				appendAlert('errormssage', getMsgByTwoArgs('msg012', '股下左修正','半角数字'));
		        return false;
			}else{
				appendAlertDel('errormssage');
			}
			var corPtLeftinseamReSp = corPtLeftinseamRe.split(".");
			if(corPtLeftinseamReSp[0].length>3){
				appendAlert('errormssage', getMsgByOneArg('msg132','股下左修正'));
				 return false;
			}else{
				appendAlertDel('errormssage');
			}
		}
	}//GILETの場合
	else if (item == "04"){
		//着丈修正
		var corGlBodylengthRe = jQuery("#corGlBodylengthRe").val();
		if(isNotEmpty(corGlBodylengthRe)){
			if(isNumericDecimal(corGlBodylengthRe)){
				appendAlert('errormssage', getMsgByTwoArgs('msg012', '着丈修正','半角数字'));
		        return false;
			}else{
				appendAlertDel('errormssage');
			}
			var corGlBodylengthReSp = corGlBodylengthRe.split(".");
			if(corGlBodylengthReSp[0].length>3){
				appendAlert('errormssage', getMsgByOneArg('msg132','着丈修正'));
				 return false;
			}else{
				appendAlertDel('errormssage');
			}
		}
		//バスト修正
		var corGlBustCorrectRe = jQuery("#corGlBustCorrectRe").val();
		if(isNotEmpty(corGlBustCorrectRe)){
			if(isNumericDecimal(corGlBustCorrectRe)){
				appendAlert('errormssage', getMsgByTwoArgs('msg012', 'バスト修正','半角数字'));
		        return false;
			}else{
				appendAlertDel('errormssage');
			}
			var corGlBustCorrectReSp = corGlBustCorrectRe.split(".");
			if(corGlBustCorrectReSp[0].length>3){
				appendAlert('errormssage', getMsgByOneArg('msg132','バスト修正'));
				 return false;
			}else{
				appendAlertDel('errormssage');
			}
		}
		//ウエスト修正
		var corGlWaistCorrectRe = jQuery("#corGlWaistCorrectRe").val();
		if(isNotEmpty(corGlWaistCorrectRe)){
			if(isNumericDecimal(corGlWaistCorrectRe)){
				appendAlert('errormssage', getMsgByTwoArgs('msg012', 'ウエスト修正','半角数字'));
		        return false;
			}else{
				appendAlertDel('errormssage');
			}
			var corGlWaistCorrectReSp = corGlWaistCorrectRe.split(".");
			if(corGlWaistCorrectReSp[0].length>3){
				appendAlert('errormssage', getMsgByOneArg('msg132','ウエスト修正'));
				 return false;
			}else{
				appendAlertDel('errormssage');
			}
		}
	}

	var corStoreCorrectionMemoAgain = jQuery('#corStoreCorrectionMemoAgain').val();
	if(charactersCheck(corStoreCorrectionMemoAgain)) {
	  	appendAlert('errormssage', getMsg('msg120'));
	    return false;
	}else{
  		appendAlertDel('errormssage');
	}
		
	document.forms.idForm.action= contextPath + "/orderCo/orderCoEntry";
	document.forms.idForm.submit();
}

jQuery('#areaResult').on('click', '.selectbtn', function() {
    var id =  $(this).attr("id");
    var result = id.split('_');
    var idx = result[1];
    var custNum = jQuery('#cust_num_' + idx).text();
    var phoneNo = jQuery('#cust_phone_' + idx).text();
    var nameKana = jQuery('#cust_knam_' + idx).text();
    var custName = jQuery('#cust_Nam_' + idx).text();

    jQuery('#areaResult').hide();
    jQuery('#custCd').val(custNum);
    jQuery('#custKanaNm').val(nameKana);
    jQuery('#custNmDiv').text(nameKana);
    jQuery('#custNm').val(custName);
    jQuery('#infotext_2').modal('hide');
    jQuery('#bootstrap-data-table').empty();
});

	// クリアボタンクリック
jQuery('#clearButton').on('click', function() {

	// form内のテキストボックスを初期化
	jQuery("#frmSearch").find("input[type='text'], input[type='date']")
		.each(function(i, elem) {
			// 表示のみ項目はクリアしない
			if (elem.readOnly == false) {
				elem.value = "";
			}
		});
	// form内のチェックボックスボックスを初期化
	jQuery("#frmSearch").find("input[type='checkbox']")
		.each(function(i, elem) {
			elem.checked = false;
		});
	// form内のコンボボックスを初期化
	jQuery("#frmSearch").find("select")
		.each(function(i, elem) {
			elem.selectedIndex = 0;
		});
});
//--------------------------------------------
//内容確認チェック
//--------------------------------------------
function imageCheck(){
	jQuery("div.alert-error").hide();
	jQuery("div.alert-success").hide();
	//オプションチェク
	var item = jQuery("#item option:selected").val()

	var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();

	var twoPants = jQuery('input[name="productSparePantsClass"]:checked').val();

	//お客様情報
	//会員番号
	var custCd = jQuery("#custCd").val();
	
	if(isEmpty(custCd)) {
        appendAlert('errormssage', getMsgByOneArg('msg001', '会員番号'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}
	
	if(isNumeric(custCd)) {
        appendAlert('errormssage', getMsgByTwoArgs('msg012','会員番号','数字'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}

	if(custCd.length != 13){
		appendAlert('errormssage', getMsgByTwoArgs('msg011', '会員番号','13'));
		return false;
	}else{
    	appendAlertDel('errormssage');
	}

	//お客様備考
	var custRemark = jQuery("#custRemark").val();
	if(charactersCheck(custRemark)) {
		appendAlert('errormssage', getMsg('msg120'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}
	
	//名簿納期
	var custDeliverDate = jQuery("#custDeliverDate").val()
	//var format = custDeliverDate.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
	
    //if(format==null){
    if(isEmpty(custDeliverDate)){
       appendAlert('errormssage', getMsgByOneArg('msg001', '名簿納期'));
       //appendAlert('errormssage', getMsgByTwoArgs('msg012', '名簿納期','正し日付'));
       return false;
    }else{
    	appendAlertDel('errormssage');
	}
	
	//お渡し日
	var custShopDeliveryDate = jQuery("#custShopDeliveryDate").val();

	//var format = custShopDeliveryDate.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
	
    //if(format==null){
    if(isEmpty(custShopDeliveryDate)){
       appendAlert('errormssage', getMsg('mag138'));
       return false;
    }else{
    	appendAlertDel('errormssage');
	}

    var DeliverDate = new Date(custDeliverDate.replace(/\-/g, "\/"));
	var ShopDeliveryDate = new Date(custShopDeliveryDate.replace(/\-/g, "\/"));
    
	if(custDeliverDate!=""&&custShopDeliveryDate!=""&&custDeliverDate <custShopDeliveryDate){  
		appendAlert('errormssage', getMsg('msg055'));
	    return false;  
	}else{
    	appendAlertDel('errormssage');
	}
	
	//納期短縮
	var expediteDelivery = jQuery("#expediteDelivery").val();
	if(expediteDelivery == "9000902"){
		var minDate = jQuery("#custShopDeliveryDate").attr("minDate");

		if ((typeof(minDate) == "undefined")||minDate == "" || minDate == null) {
			
		}else{
			var custShopDeliveryDate = jQuery("#custShopDeliveryDate").val();

			var minDateCheck = new Date(minDate.replace(/\-/g, "\/"));
			var custShopDeliveryDateCheck = new Date(custShopDeliveryDate.replace(/\-/g, "\/"));
		    
			if(minDateCheck!=""&&custShopDeliveryDateCheck!=""&&custShopDeliveryDateCheck <minDateCheck){  
				appendAlert('errormssage', getMsg('msg129'));
			    return false;  
			}else{
		    	appendAlertDel('errormssage');
			}
		}
	}
	
    //スタッフ
    var custStaff = jQuery("#custStaff").val();

    if(isEmpty(custStaff)) {
        appendAlert('errormssage', getMsgByOneArg('msg001', 'スタッフ'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}
    
    
    if(custStaff.length>50){
		appendAlert('errormssage', getMsgByTwoArgs('msg011', 'スタッフ','50'));
		return false;
	}else{
    	appendAlertDel('errormssage');
	}

    if(charactersCheck(custStaff)) {
    	appendAlert('errormssage', getMsg('msg120'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}

	//出荷先
	var destination = jQuery("#destination").val();
	//他店舗の場合
	if(destination=="05"){
		var shopName = jQuery("#shopName").val();
		if(isEmpty(shopName)){
			appendAlert('errormssage', getMsgByOneArg('msg001', '出荷先他店舗'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
    
	//メジャーリング
	
    var fullLengthTe = jQuery("#fullLengthTe").val();
    
    if(fullLengthTe!=""){
    	if(isNumeric(fullLengthTe)) {
            appendAlert('errormssage', getMsgByTwoArgs('msg012','フルレングス','半角数字'));
            return false;
        }else{
	    	appendAlertDel('errormssage');
		}
    }
    

	var shoulderTe = jQuery("#shoulderTe").val();

	if(shoulderTe!=""){
		if(isNumeric(shoulderTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ショルダー','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}

	var reachRightTe = jQuery("#reachRightTe").val();

	if(reachRightTe!=""){
		if(isNumeric(reachRightTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','リーチ（右）','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
	

	var reachLeftTe = jQuery("#reachLeftTe").val();

	if(reachLeftTe!=""){
		if(isNumeric(reachLeftTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','リーチ（左）','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
	

	var outBustTe = jQuery("#outBustTe").val();
	if(outBustTe!=""){
		if(isNumeric(outBustTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','アウトバスト','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
	

	var bustTe = jQuery("#bustTe").val();
	
	if(bustTe!=""){
		if(isNumeric(bustTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','バスト','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
	

	var jacketWaistTe = jQuery("#jacketWaistTe").val();

	if(jacketWaistTe!=""){
		if(isNumeric(jacketWaistTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','JKウエスト','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
	

	var pantsWaistTe = jQuery("#pantsWaistTe").val();

	if(pantsWaistTe!=""){
		if(isNumeric(pantsWaistTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','PTウエスト','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}

	var hipTe = jQuery("#hipTe").val();

	if(hipTe!=""){
		if(isNumeric(hipTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ヒップ','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
	

	var spanRightTe = jQuery("#spanRightTe").val();

	if(spanRightTe!=""){
		if(isNumeric(spanRightTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ワタリ（右）','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}

	var spanLeftTe = jQuery("#spanLeftTe").val();

	if(spanLeftTe!=""){
		if(isNumeric(spanLeftTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ワタリ（左）','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
    
	var calfRightTe = jQuery("#calfRightTe").val();

	if(calfRightTe!=""){
		if(isNumeric(calfRightTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ふくらはぎ（右）','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}

	var calfLeftTe = jQuery("#calfLeftTe").val();

	if(calfLeftTe!=""){
		if(isNumeric(calfLeftTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ふくらはぎ（左）','半角数字'));
	        return false;
	    }	else{
	    	appendAlertDel('errormssage');
		}
	}

	var neckTe = jQuery("#neckTe").val();
	
	if(neckTe!=""){
		if(isNumeric(neckTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ネック','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}

	//商品
	stockCheck();
	//生地品番
	var productFabricNo = jQuery("#productFabricNo").val();
	if(isEmpty(productFabricNo)){
		appendAlert('errormssage', getMsgByOneArg('msg001', '生地品番'));
        return false;
	}else{
    	appendAlertDel('errormssage');
	}

	//刺繍ネーム
	var productEmbroideryNecessity = jQuery('input[name=productEmbroideryNecessity]:checked').val();
	if (productEmbroideryNecessity == '9000502') {
		var embroideryName = jQuery("#embroideryName").val();
		if(embroideryName.length>50){
			appendAlert('errormssage', getMsgByTwoArgs('msg011', '刺繍ネーム','40'));
			return false;
		}else{
	    	appendAlertDel('errormssage');
		}

		if(isEmpty(embroideryName)){
			appendAlert('errormssage', getMsgByOneArg('msg001', '刺繍ネーム'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(charactersCheck(embroideryName)) {
			appendAlert('errormssage', getMsg('msg120'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}

		if (!jQuery("input[name='productEmbroideryFont']").is(":checked")) {
			appendAlert('errormssage', getMsgByOneArg('msg003', '刺繍書体'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}
		
	}

	var item = jQuery("#item").val();

	if(item != "05"){
		//残布
		var productEmbroideryNecessity = jQuery('input[name="productRemainingClothType"]:checked').val();
		if(isEmpty(productEmbroideryNecessity)){
			appendAlert('errormssage', getMsgByOneArg('msg001','残布'));
	        return false;
		}else{
			appendAlertDel('errormssage');
		}
	}

	//生地チェクフラッグ
	var fabricCheckValue = jQuery("#fabricFlag").val();
	
	fabricCheckValue = fabricCheckValue.split("*");
	//fabricCheckValue[0]:0 or 1 or 2 
	//fabricCheckValue[1]:エラーメッセージ 
	//生地チェク成功の場合
	if(fabricCheckValue[0]=="0"){
		
	//生地チェクの場合	
	}else if(fabricCheckValue[0]=="1"){
	    appendAlert('errormssage',fabricCheckValue[1]);
		return false;
	}

	var jkModelFlag = jQuery("#jkModelFlag").val();
	 jkModelFlag = jkModelFlag.split("*");
	 //jkModelFlag[0]:0 or 1 
	 //jkModelFlag[1]:エラーメッセージ 
	 //生地チェク成功の場合
	 if(jkModelFlag[0]=="0"){
			
	 //生地チェクの場合	
	 }else if(jkModelFlag[0]=="1"){
	     appendAlert('errormssage',jkModelFlag[1]);
	     return false;
	 }


	 var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
	

	 if(item == "01"){
		if(threePiece == "0009901"){
			jQuery("#glModelFlag").val("0");
		}
	 }
	 var glModelFlag = jQuery("#glModelFlag").val();
	 glModelFlag = glModelFlag.split("*");
	 //glModelFlag[0]:0 or 1 
	 //glModelFlag[1]:エラーメッセージ 
	 //生地チェク成功の場合
	 if(glModelFlag[0]=="0"){
			
	 //生地チェクの場合	
	 }else if(glModelFlag[0]=="1"){
	     appendAlert('errormssage',glModelFlag[1]);
	     return false;
	 }
	 

	 var ptModelFlag = jQuery("#ptModelFlag").val();
	 ptModelFlag = ptModelFlag.split("*");
	 //ptModelFlag[0]:0 or 1 
	 //ptModelFlag[1]:エラーメッセージ 
	 //生地チェク成功の場合
	 if(ptModelFlag[0]=="0"){
			
	 //生地チェクの場合	
	 }else if(ptModelFlag[0]=="1"){
	     appendAlert('errormssage',ptModelFlag[1]);
	     return false;
	 }


	 var twoPants = jQuery('input[name="productSparePantsClass"]:checked').val();
	 if(item == "01"){
		if(twoPants == "0009901"){
			jQuery("#pt2ModelFlag").val("0");
		}
	 }
	 var pt2ModelFlag = jQuery("#pt2ModelFlag").val();
	 pt2ModelFlag = pt2ModelFlag.split("*");
	 //pt2ModelFlag[0]:0 or 1 
	 //pt2ModelFlag[1]:エラーメッセージ 
	 //生地チェク成功の場合
	 if(pt2ModelFlag[0]=="0"){
			
	 //生地チェクの場合	
	 }else if(pt2ModelFlag[0]=="1"){
	     appendAlert('errormssage',pt2ModelFlag[1]);
	     return false;
	 }
   
   
   var statusInput = "${order.tscStatus}"
   if(isEmpty(statusInput)){
          
   }else{
   	   jQuery("#statusInput").val(statusInput);
   }
  	
	jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').ghostsf_serialize(),type: "post",async:false});
	jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').ghostsf_serialize(),type: "post",async:false});
	jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});
	jQuery('select').removeAttr("disabled");
	jQuery('input').removeAttr("disabled");
	document.getElementById('idForm').submit();
	return true;
  
}

//一時保存チェク
function temporarySaveCheck(){
	// エラーメッセージのDIVを表示しない
	jQuery("div.alert-error").hide();
	jQuery("div.alert-success").hide();

	//会員番号
	var custCd = jQuery("#custCd").val();
	if(isNotEmpty(custCd)){
		if(isNumeric(custCd)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','会員番号','数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}

		if(custCd.length != 13){
			appendAlert('errormssage', getMsgByTwoArgs('msg011', '会員番号','13'));
			return false;
		}else{
	    	appendAlertDel('errormssage');
		}
	}


	//名簿納期
	var custDeliverDate = jQuery("#custDeliverDate").val()
	if(isNotEmpty(custDeliverDate)){
		var format = custDeliverDate.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
		
	    if(format==null){
	       appendAlert('errormssage', getMsgByTwoArgs('msg012', '名簿納期','正し日付'));
	       return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}

	//納期短縮
	var expediteDelivery = jQuery("#expediteDelivery").val();
	if(expediteDelivery == "9000902"){
		var minDate = jQuery("#custShopDeliveryDate").attr("minDate");

		if ((typeof(minDate) == "undefined")||minDate == "" || minDate == null) {
			
		}else{
			var custShopDeliveryDate = jQuery("#custShopDeliveryDate").val();

			var minDateCheck = new Date(minDate.replace(/\-/g, "\/"));
			var custShopDeliveryDateCheck = new Date(custShopDeliveryDate.replace(/\-/g, "\/"));
		    
			if(minDateCheck!=""&&custShopDeliveryDateCheck!=""&&custShopDeliveryDateCheck <minDateCheck){  
				appendAlert('errormssage', getMsg('msg129'));
			    return false;  
			}else{
		    	appendAlertDel('errormssage');
			}
		}
	}

	//お客様備考
	var custRemark = jQuery("#custRemark").val();
	if(charactersCheck(custRemark)) {
		appendAlert('errormssage', getMsg('msg120'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}
	
	//お渡し日
	var custShopDeliveryDate = jQuery("#custShopDeliveryDate").val();
	if(isNotEmpty(custShopDeliveryDate)){
		var format = custShopDeliveryDate.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
		
	    if(format==null){
	       appendAlert('errormssage', getMsgByTwoArgs('msg012', 'お渡し日','正し日付'));
	       return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}

	var custDeliverDate = new Date(custDeliverDate.replace(/\-/g, "\/"));
	var custShopDeliveryDate = new Date(custShopDeliveryDate.replace(/\-/g, "\/"));
    
	if(custDeliverDate!=""&&custShopDeliveryDate!=""&&custDeliverDate <custShopDeliveryDate){  
		appendAlert('errormssage', getMsg('msg055'));
	    return false;  
	}else{
    	appendAlertDel('errormssage');
	}

	//スタッフ
    var custStaff = jQuery("#custStaff").val();
    if(isNotEmpty(custStaff)){
    	if(custStaff.length>50){
    		appendAlert('errormssage', getMsgByTwoArgs('msg011', 'スタッフ','50'));
    		return false;
    	}else{
	    	appendAlertDel('errormssage');
		}

        if(charactersCheck(custStaff)) {
        	appendAlert('errormssage', getMsg('msg120'));
            return false;
        }else{
	    	appendAlertDel('errormssage');
		}
    }

    //メジャーリングチェク
	var fullLengthTe = jQuery("#fullLengthTe").val();
    
    if(fullLengthTe!=""){
    	if(isNumeric(fullLengthTe)) {
            appendAlert('errormssage', getMsgByTwoArgs('msg012','フルレングス','半角数字'));
            return false;
        }else{
	    	appendAlertDel('errormssage');
		}
    }
    

	var shoulderTe = jQuery("#shoulderTe").val();

	if(shoulderTe!=""){
		if(isNumeric(shoulderTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ショルダー','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}

	var reachRightTe = jQuery("#reachRightTe").val();

	if(reachRightTe!=""){
		if(isNumeric(reachRightTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','リーチ（右）','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
	

	var reachLeftTe = jQuery("#reachLeftTe").val();

	if(reachLeftTe!=""){
		if(isNumeric(reachLeftTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','リーチ（左）','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
	

	var outBustTe = jQuery("#outBustTe").val();
	if(outBustTe!=""){
		if(isNumeric(outBustTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','アウトバスト','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
	

	var bustTe = jQuery("#bustTe").val();
	
	if(bustTe!=""){
		if(isNumeric(bustTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','バスト','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
	

	var jacketWaistTe = jQuery("#jacketWaistTe").val();

	if(jacketWaistTe!=""){
		if(isNumeric(jacketWaistTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','JKウエスト','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
	

	var pantsWaistTe = jQuery("#pantsWaistTe").val();

	if(pantsWaistTe!=""){
		if(isNumeric(pantsWaistTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','PTウエスト','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}

	var hipTe = jQuery("#hipTe").val();

	if(hipTe!=""){
		if(isNumeric(hipTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ヒップ','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
	

	var spanRightTe = jQuery("#spanRightTe").val();

	if(spanRightTe!=""){
		if(isNumeric(spanRightTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ワタリ（右）','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}

	var spanLeftTe = jQuery("#spanLeftTe").val();

	if(spanLeftTe!=""){
		if(isNumeric(spanLeftTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ワタリ（左）','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}
    
	var calfRightTe = jQuery("#calfRightTe").val();

	if(calfRightTe!=""){
		if(isNumeric(calfRightTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ふくらはぎ（右）','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}

	var calfLeftTe = jQuery("#calfLeftTe").val();

	if(calfLeftTe!=""){
		if(isNumeric(calfLeftTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ふくらはぎ（左）','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}	
	}

	var neckTe = jQuery("#neckTe").val();
	
	if(neckTe!=""){
		if(isNumeric(neckTe)) {
	        appendAlert('errormssage', getMsgByTwoArgs('msg012','ネック','半角数字'));
	        return false;
	    }else{
	    	appendAlertDel('errormssage');
		}
	}

	//商品
	//刺繍ネーム
	var productEmbroideryNecessity = jQuery('input[name=productEmbroideryNecessity]:checked').val();
	if(isNotEmpty(productEmbroideryNecessity)){
		if (productEmbroideryNecessity == '9000502') {
			var embroideryName = jQuery("#embroideryName").val();
			if(embroideryName.length>50){
				appendAlert('errormssage', getMsgByTwoArgs('msg011', '刺繍ネーム','40'));
				return false;
			}else{
		    	appendAlertDel('errormssage');
			}

			if(charactersCheck(embroideryName)) {
				appendAlert('errormssage', getMsg('msg120'));
		        return false;
		    }else{
		    	appendAlertDel('errormssage');
			}
		}
	}
	
	//
	var productFabricNo = jQuery("#productFabricNo").val();

	if(isNotEmpty(productFabricNo)){
		//生地チェクフラッグ
		var fabricCheckValue = jQuery("#fabricFlag").val();
		fabricCheckValue = fabricCheckValue.split("*");
		if(isEmpty(productFabricNo)){
			fabricCheckValue == "0";
		}
		//fabricCheckValue[0]:0 or 1 or 2 
		//fabricCheckValue[1]:エラーメッセージ 
		//生地チェク成功の場合
		if(fabricCheckValue[0]=="0"){
			appendAlertDel('errormssage');
		//生地チェクの場合	
		}else if(fabricCheckValue[0]=="1"){
		    appendAlert('errormssage',fabricCheckValue[1]);
			return false;
		}
		 var jkModelFlag = jQuery("#jkModelFlag").val();
		 jkModelFlag = jkModelFlag.split("*");
		 //jkModelFlag[0]:0 or 1 
		 //jkModelFlag[1]:エラーメッセージ 
		 //生地チェク成功の場合
		 if(jkModelFlag[0]=="0"){
				
		 //生地チェクの場合	
		 }else if(jkModelFlag[0]=="1"){
		     appendAlert('errormssage',jkModelFlag[1]);
		     return false;
		 }
		 var item = jQuery("#item").val();
		 var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
		 if(item == "01"){
			if(threePiece == "0009901"){
				jQuery("#glModelFlag").val("0");
			}
		 }
		 var glModelFlag = jQuery("#glModelFlag").val();
		 glModelFlag = glModelFlag.split("*");
		 //glModelFlag[0]:0 or 1 
		 //glModelFlag[1]:エラーメッセージ 
		 //生地チェク成功の場合
		 if(glModelFlag[0]=="0"){
				
		 //生地チェクの場合	
		 }else if(glModelFlag[0]=="1"){
		     appendAlert('errormssage',glModelFlag[1]);
		     return false;
		 }
		 var ptModelFlag = jQuery("#ptModelFlag").val();
		 ptModelFlag = ptModelFlag.split("*");
		 //ptModelFlag[0]:0 or 1 
		 //ptModelFlag[1]:エラーメッセージ 
		 //生地チェク成功の場合
		 if(ptModelFlag[0]=="0"){
				
		 //生地チェクの場合	
		 }else if(ptModelFlag[0]=="1"){
		     appendAlert('errormssage',ptModelFlag[1]);
		     return false;
		 }
		 var twoPants = jQuery('input[name="productSparePantsClass"]:checked').val();
		 if(item == "01"){
			if(twoPants == "0009901"){
				jQuery("#pt2ModelFlag").val("0");
			}
		 }
		 var pt2ModelFlag = jQuery("#pt2ModelFlag").val();
		 pt2ModelFlag = pt2ModelFlag.split("*");
		 //pt2ModelFlag[0]:0 or 1 
		 //pt2ModelFlag[1]:エラーメッセージ 
		 //生地チェク成功の場合
		 if(pt2ModelFlag[0]=="0"){
				
		 //生地チェクの場合	
		 }else if(pt2ModelFlag[0]=="1"){
		     appendAlert('errormssage',pt2ModelFlag[1]);
		     return false;
		 }
	}
	return true;
}

function dateEarlyCheck(productFabricNo,item){
	if(isNotEmpty(productFabricNo)){
		//生地チェクフラッグ
		var fabricCheckValue = jQuery("#fabricFlag").val();
		fabricCheckValue = fabricCheckValue.split("*");
		//生地チェク成功の場合
		if(fabricCheckValue[0]=="0"){
			jQuery.ajax({
				 type:"get",
				 url: contextPath + "/order/findStock",
				 data:{"fabricNo":productFabricNo,"orderPattern":"CO"},
				 async:false,
				 success:function(result){
					 if(!isShopDeliveryEmpty(result,item)){
		         			setAlert('stockMsg', getMsgByOneArg('msg127','早割'));
		         			//生地メッセージをクリア
		         			jQuery("#notice").empty();
		     			    jQuery("#fabric_brand_nm_p").empty();
		     			    jQuery("#service_nm_p").empty();
		     				jQuery("#compos_frt_fabric_p").empty();
		     				jQuery("#goodsPrice").html('0');
		       				jQuery("productPriceId").val("");
		       				jQuery("#theoryFabricUsedMountId").val("");
		       				jQuery("#fabricColor").val("");
							jQuery("#fabricPattern").val("");
							jQuery("#factoryCode").val("");
							jQuery("#custShopDeliveryDate").val("");
							jQuery("#makerCode").val("");
							jQuery("#fabricMsg").empty();
							jQuery("#threePiece_Msg").empty();
							jQuery("#sparePants_Msg").empty();
							jQuery("#jacketModel_Msg").empty();
							jQuery("#lcrSewing_id2").removeAttr("disabled","disabled");
							allOptionPrice();
							//生地チェク失敗フラッグ
							fabricCheckValue = "1";
		     				jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsgByOneArg('msg127','早割'));
		     			 }	 
				 }
			})
		}
	}
}


function getProductPrice(){
	var item = jQuery("#item").val();	
	var productCode = "";
	var productModel = "ALL";
	var productItemCode = "99";
	var productSubItemCode = "99";
	jQuery("#expediteDelivery").change(function(){
		var expediteDelivery = jQuery(this).val();
		var valueName = jQuery(this).attr("id");
		productCode = productItemCode + productSubItemCode + productModel;
		jQuery.ajax({
			type:"get",
			async:false,
		    url:contextPath + "/orderCo/productPrice",
		    data:{"productCode":productCode,"valueCode":expediteDelivery,"valueName":valueName},
		    success:function(result){
			    if(result == "0" || result == 0){
			    	jQuery("#expediteDeliveryPrice").val(result);
			    	jQuery("#expediteDelivery_Msg").html("無料");
				}else{
				    jQuery("#expediteDeliveryPrice").val(result);
				    jQuery("#expediteDelivery_Msg").html(formatMoney(result,0,"￥"));
				}
		    }
        });
		allOptionPrice();
	});

	if(item!="05"&&item!="06"){
		var lcrSewing = jQuery('input[name=productLcrSewing]:checked').val();
		var valueName = jQuery('input[name=productLcrSewing]:checked').attr("id");
		if(valueName.indexOf("_id")!=-1){
			valueName = valueName.substr(0, valueName.length - 1);
			valueName = valueName.replace("_id","");
		}
		productCode = productItemCode + productSubItemCode + productModel;
		jQuery.ajax({
			type:"get",
			async:false,
		    url:contextPath + "/orderCo/productPrice",
		    data:{"productCode":productCode,"valueCode":lcrSewing,"valueName":valueName},
		    success:function(result){
			    if(result == "0" || result == 0){
			    	jQuery("#lcrSewingPrice").val(result);
			    	jQuery("#lcrSewing_Msg").html("無料");
				}else{
				    jQuery("#lcrSewingPrice").val(result);
				    jQuery("#lcrSewing_Msg").html(formatMoney(result,0,"￥"));
				}
		    }
	    });
		allOptionPrice();
		jQuery('input[id^="lcrSewing_"]').change(function(){
			var lcrSewing = jQuery(this).val();
			var valueName = jQuery(this).attr("id");
			if(valueName.indexOf("_id")!=-1){
				valueName = valueName.substr(0, valueName.length - 1);
				valueName = valueName.replace("_id","");
			}
			productCode = productItemCode + productSubItemCode + productModel;
			jQuery.ajax({
				type:"get",
				async:false,
			    url:contextPath + "/orderCo/productPrice",
			    data:{"productCode":productCode,"valueCode":lcrSewing,"valueName":valueName},
			    success:function(result){
				    if(result == "0" || result == 0){
				    	jQuery("#lcrSewingPrice").val(result);
				    	jQuery("#lcrSewing_Msg").html("無料");
					}else{
					    jQuery("#lcrSewingPrice").val(result);
					    jQuery("#lcrSewing_Msg").html(formatMoney(result,0,"￥"));
					}
				    allOptionPrice();
			    }
	        });
		});
	}else{
		jQuery("#lcrSewingPrice").val("0");
	}
}

function shirtProductPrice(){
	var item = jQuery("#item").val();
	var embroidered = jQuery('input[name="productEmbroideryNecessity"]:checked').val();
	if(item == "05"&&embroidered == "9000502"){
		var productEmbroideryNmPos = jQuery("#productEmbroideryNmPos").val();
		var valueName = jQuery("#productEmbroideryNmPos").attr("id");
		jQuery.ajax({
			type:"get",
			async:false,
		    url:contextPath + "/orderCo/productPrice",
		    data:{"valueCode":productEmbroideryNmPos,"valueName":valueName},
		    success:function(result){
		    	if(result == "0" || result == 0){
			    	jQuery("#embroideryNmPosPrice").val(result);
			    	jQuery("#embroideryNmPos_Msg").html("無料");
				}else{
				    jQuery("#embroideryNmPosPrice").val(result);
				    jQuery("#embroideryNmPos_Msg").html(formatMoney(result,0,"￥"));
				}
			    allOptionPrice();
		    }
        });
        
		jQuery("#productEmbroideryNmPos").change(function(){
			var productEmbroideryNmPos = jQuery(this).val();
			var valueName = jQuery(this).attr("id");
			jQuery.ajax({
				type:"get",
				async:false,
			    url:contextPath + "/orderCo/productPrice",
			    data:{"valueCode":productEmbroideryNmPos,"valueName":valueName},
			    success:function(result){
			    	if(result == "0" || result == 0){
				    	jQuery("#embroideryNmPosPrice").val(result);
				    	jQuery("#embroideryNmPos_Msg").html("無料");
					}else{
					    jQuery("#embroideryNmPosPrice").val(result);
					    jQuery("#embroideryNmPos_Msg").html(formatMoney(result,0,"￥"));
					}
				    allOptionPrice();
			    }
	        });
		});

		var gadget = jQuery('input[name=productEmbroideryGazette]:checked').val();
		var valueName = jQuery('input[name=productEmbroideryGazette]:checked').attr("id");
		if(valueName.indexOf("_id")!=-1){
			valueName = valueName.substr(0, valueName.length - 1);
			valueName = valueName.replace("_id","");
		}
		jQuery.ajax({
			type:"get",
			async:false,
		    url:contextPath + "/orderCo/productPrice",
		    data:{"valueCode":gadget,"valueName":valueName},
		    success:function(result){
		    	if(result == "0" || result == 0){
			    	jQuery("#gadgetPrice").val(result);
			    	jQuery("#gadget_Msg").html("無料");
				}else{
				    jQuery("#gadgetPrice").val(result);
				    jQuery("#gadget_Msg").html(formatMoney(result,0,"￥"));
				}
		    }
	    });
		allOptionPrice();
	
		jQuery('input[id^="gadget_"]').change(function(){
			var gadget = jQuery(this).val();
			var valueName = jQuery(this).attr("id");
			if(valueName.indexOf("_id")!=-1){
				valueName = valueName.substr(0, valueName.length - 1);
				valueName = valueName.replace("_id","");
			}
			jQuery.ajax({
				type:"get",
				async:false,
			    url:contextPath + "/orderCo/productPrice",
			    data:{"valueCode":gadget,"valueName":valueName},
			    success:function(result){
				    if(result == "0" || result == 0){
				    	jQuery("#gadgetPrice").val(result);
				    	jQuery("#gadget_Msg").html("無料");
					}else{
					    jQuery("#gadgetPrice").val(result);
					    jQuery("#gadget_Msg").html(formatMoney(result,0,"￥"));
					}
				    allOptionPrice();
			    }
	        });
		});
	}else{
		jQuery("#embroideryNmPosPrice").val("0");
		jQuery("#embroideryNmPos_Msg").empty();
		jQuery("#gadgetPrice").val("0");
		jQuery("#gadget_Msg").empty();
		allOptionPrice();
	}
}

$.fn.ghostsf_serialize = function () {
    var a = this.serializeArray();
    var $radio = $('input[type=radio],input[type=checkbox]', this);
    var temp = {};
    $.each($radio, function () {
        if (!temp.hasOwnProperty(this.name)) {
            if ($("input[name='" + this.name + "']:checked").length == 0) {
                temp[this.name] = "";
                a.push({name: this.name, value: ""});
            }
        }
    });
    return jQuery.param(a);
};

function optionControlNotDisabled(){
	var item = jQuery("#item").val();
	var productCategory = jQuery('input[name="productCategory"]:checked').val();
	var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
	var sparePants = jQuery('input[name="productSparePantsClass"]:checked').val();
	if(item == "01"){
		if(productCategory == "9000101"){
			//JACKET
			jQuery('#flowerHole').removeAttr("disabled");
			jQuery('#cuffBackMateStkNo').removeAttr("disabled");
			//PANTS
		}else if(productCategory == "9000102"){
			//JACKET
			jQuery('#tj_flowerHole').removeAttr("disabled");
			jQuery('#tj_btnMateStkNo').removeAttr("disabled");
			//PANTS
		}else if(productCategory == "9000103"){
			//JACKET
			jQuery('#wj_flowerHole').removeAttr("disabled");
			//PANTS
		}
		if(threePiece == "0009902"){
			//GILET
		}
		
		if(sparePants == "0009902"){
			//2PANTS
		}
	}else if(item == "02"){
		if(productCategory == "9000101"){
			jQuery('#flowerHole').removeAttr("disabled");
			jQuery('#cuffBackMateStkNo').removeAttr("disabled");
		}else if(productCategory == "9000102"){
			jQuery('#tj_flowerHole').removeAttr("disabled");
			jQuery('#tj_btnMateStkNo').removeAttr("disabled");
		}else if(productCategory == "9000103"){
			jQuery('#wj_flowerHole').removeAttr("disabled");
		}
	}else if(item == "03"){

	}else if(item == "04"){

	}else if(item == "05"){

	}else if(item == "06"){

	}
}

function optionControlDisabled(){
	var item = jQuery("#item").val();
	var productCategory = jQuery('input[name="productCategory"]:checked').val();
	var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
	var sparePants = jQuery('input[name="productSparePantsClass"]:checked').val();
	if(item == "01"){

		if(productCategory == "9000101"){
			//JACKET
			var selectedLapelDesign = jQuery('input[name="coOptionJacketStandardInfo.ojLapelDesign"]:checked').val();
			if(selectedLapelDesign == "0000203"){
				jQuery("#flowerHole").prop("disabled",true);
			}
			var cuffBackMate = jQuery('#cuffBackMate').val();
			if(cuffBackMate == "2000300"){
				jQuery("#cuffBackMateStkNo").prop("disabled",true);
			}
			//PANTS
		}else if(productCategory == "9000102"){
			//JACKET
			var selectedLapelDesign = jQuery('input[name="coOptionJacketTuxedoInfo.tjLapelDesign"]:checked').val();
			if(selectedLapelDesign == "0000203"){
				jQuery("#tj_flowerHole").prop("disabled",true);
			}
			var tj_btnMate = jQuery('#tj_btnMate').val();
			if(tj_btnMate == "3000700"){
				jQuery("#tj_btnMateStkNo").prop("disabled",true);
			}
			//PANTS
		}else if(productCategory == "9000103"){
			//JACKET
			var selectedLapelDesign = jQuery('input[name="coOptionJacketWashableInfo.wjFlowerHole"]:checked').val();
			if(selectedLapelDesign == "0000203"){
				jQuery("#wj_flowerHole").prop("disabled",true);
			}
			//PANTS
		}

		if(threePiece == "0009902"){
			//GILET
		}
		
		if(sparePants == "0009902"){
			//2PANTS
		}
	}else if(item == "02"){
		if(productCategory == "9000101"){
			var selectedLapelDesign = jQuery('input[name="coOptionJacketStandardInfo.ojLapelDesign"]:checked').val();
			if(selectedLapelDesign == "0000203"){
				jQuery("#flowerHole").prop("disabled",true);
			}
			var cuffBackMate = jQuery('#cuffBackMate').val();
			if(cuffBackMate == "2000300"){
				jQuery("#cuffBackMateStkNo").prop("disabled",true);
			}
		}else if(productCategory == "9000102"){
			var selectedLapelDesign = jQuery('input[name="coOptionJacketTuxedoInfo.tjLapelDesign"]:checked').val();
			if(selectedLapelDesign == "0000203"){
				jQuery("#tj_flowerHole").prop("disabled",true);
			}
			var tj_btnMate = jQuery('#tj_btnMate').val();
			if(tj_btnMate == "3000700"){
				jQuery("#tj_btnMateStkNo").prop("disabled",true);
			}
		}else if(productCategory == "9000103"){
			var selectedLapelDesign = jQuery('input[name="coOptionJacketWashableInfo.wjFlowerHole"]:checked').val();
			if(selectedLapelDesign == "0000203"){
				jQuery("#wj_flowerHole").prop("disabled",true);
			}
		}
	}else if(item == "03"){

	}else if(item == "04"){

	}else if(item == "05"){

	}else if(item == "06"){

	}
}

//メジャーリングの初期化
//--------------------------------------------
function orderFormMeasuring(){
	var measuringList = [
		{type:"fullLength",size:"${orderCoForm.coMeasuringInfo.fullLength}"},
		{type:"shoulder",size:"${orderCoForm.coMeasuringInfo.shoulder}"},
		{type:"reachRight",size:"${orderCoForm.coMeasuringInfo.reachRight}"},
		{type:"reachLeft",size:"${orderCoForm.coMeasuringInfo.reachLeft}"},
		{type:"outBust",size:"${orderCoForm.coMeasuringInfo.outBust}"},
		{type:"bust",size:"${orderCoForm.coMeasuringInfo.bust}"},
		{type:"jacketWaist",size:"${orderCoForm.coMeasuringInfo.jacketWaist}"},
		{type:"pantsWaist",size:"${orderCoForm.coMeasuringInfo.pantsWaist}"},
		{type:"hip",size:"${orderCoForm.coMeasuringInfo.hip}"},
		{type:"spanRight",size:"${orderCoForm.coMeasuringInfo.spanRight}"},
		{type:"spanLeft",size:"${orderCoForm.coMeasuringInfo.spanLeft}"},
		{type:"calfRight",size:"${orderCoForm.coMeasuringInfo.calfRight}"},
		{type:"calfLeft",size:"${orderCoForm.coMeasuringInfo.calfLeft}"},
		{type:"neck",size:"${orderCoForm.coMeasuringInfo.neck}"}
		];
	var i = null;
	for(i of measuringList){
		var measuring = i.size;
		measuring = measuring.split(".");
		if(measuring[0]=="0"&&measuring[1]=="0"){

		}else{
			jQuery("#"+i.type+"Te").val(measuring[0]);
			jQuery("#"+i.type+"Se").val(measuring[1]);
			jQuery("#"+i.type).val(i.size)
		}
	}
}

if (document.readyState=="complete"){  
    $.unblockUI();
}else{
    document.onreadystatechange = function(){  
        if (document.readyState == "complete"){  
           $.unblockUI();   
        }
    }
}
</script>
