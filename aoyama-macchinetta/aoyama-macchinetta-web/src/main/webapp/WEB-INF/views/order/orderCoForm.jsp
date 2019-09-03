<spring:eval var="sessionContent" expression="@sessionContent" />
<style type="text/css">
span {
	margin-right: 16px;
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
		<form:form id="idForm" action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm" method="post" modelAttribute="orderForm" class="form-horizontal">
        <div class="content mt-3">
            <div class="animated fadeIn">
            <t:messagesPanel  messagesAttributeName="resultMessages"/>
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
                    	<c:if test="${order.tscStatus == '' || orderForm.status == ''}">
                        	
                        </c:if>
                        <c:if test="${order.tscStatus == 'T0' || orderForm.status == 'T0'}">
                        	一時保存
                        </c:if>
                        <c:if test="${order.tscStatus == 'T1' || orderForm.status == 'T1'}">
                        	取り置き
                        </c:if>
                        <c:if test="${order.tscStatus == 'T2' || orderForm.status == 'T2'}">
                        	登録済
                        </c:if>
                        <c:if test="${order.tscStatus == 'T3' || orderForm.status == 'T3'}">
                         	会計済
                        </c:if>
                        <c:if test="${order.tscStatus == 'T4' || orderForm.status == 'T4'}">
                         	商品部承認済
                        </c:if>
                        <c:if test="${order.tscStatus == 'T5' || orderForm.status == 'T5'}">
                         	メーカー承認済
                        </c:if>
                        <c:if test="${order.tscStatus == 'T6' || orderForm.status == 'T6'}">
                         	仕入済
                        </c:if>
                        <c:if test="${order.tscStatus == 'T7' || orderForm.status == 'T7'}">
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
                                <!-- <input type="text" id="orderId" name="customerMessageInfo.orderId" class="input-sm form-control-sm form-control" value="" readonly> -->
                                <form:input id="orderId" path="customerMessageInfo.orderId" class="input-sm form-control-sm form-control" readonly = "true"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">会員番号</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <input type="text" id="custCd" name="customerMessageInfo.custCd" class="input-sm form-control-sm form-control" maxlength="13"> -->
                                <form:input id="custCd" path="customerMessageInfo.custCd" class="input-sm form-control-sm form-control" maxlength="13"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">お客様氏名</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <input type="text" id="custNm" name="customerMessageInfo.custNm" class="input-sm form-control-sm form-control" maxlength="50"> -->
                                <form:input id="custNm" path="customerMessageInfo.custNm" class="input-sm form-control-sm form-control" maxlength="50"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フリガナ</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <input type="text" id="custKanaNm" name="customerMessageInfo.custKanaNm" class="input-sm form-control-sm form-control" maxlength="60"> -->
                                <form:input id="custKanaNm" path="customerMessageInfo.custKanaNm" class="input-sm form-control-sm form-control" maxlength="60"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">名簿納期</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <input type="text" autocomplete="off" id="custDeliverDate" name="customerMessageInfo.custDeliverDate" placeholder="年/月/日" class="input-sm form-control-sm form-control"> -->
                                <form:input id="custDeliverDate" path="customerMessageInfo.custDeliverDate" class="input-sm form-control-sm form-control" placeholder="年/月/日" autocomplete="off"/>
                            </div>
                        </div>
                    </div>
                    <div class="col col-lg-6">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">納期短縮</label></div>
                            <div class="col-12 col-md-4">
                                <!-- <select name="customerMessageInfo.custIsDeliverShortning" id="expediteDelivery" class="form-control-sm form-control">
                                    <option value="0">無</option>
                                    <option value="1">有</option>
                                </select> -->
                                <form:select path="customerMessageInfo.custIsDeliverShortning" id="expediteDelivery" class="form-control-sm form-control">
                                	<form:option value="0">無</form:option>
                                	<form:option value="1">有</form:option>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-5 text-right">
                                <span id="expediteDeliveryMsg" style="display:none;">&yen;2,000</span>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">早割</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <select name="customerMessageInfo.custIsEarlyDiscount" id="earlyDiscount" class="form-control-sm form-control">
                                    <option value="0">無</option>
                                    <option value="1">有</option>
                                </select> -->
                                <form:select path="customerMessageInfo.custIsEarlyDiscount" id="earlyDiscount" class="form-control-sm form-control">
                                	<form:option value="0">無</form:option>
                                	<form:option value="1">有</form:option>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">お渡し日</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <input type="text" id="custShopDeliveryDate" name="customerMessageInfo.custShopDeliveryDate" placeholder="年/月/日" class="input-sm form-control-sm form-control" readonly="readonly"> -->
                                <form:input id="custShopDeliveryDate" path="customerMessageInfo.custShopDeliveryDate" class="input-sm form-control-sm form-control" placeholder="年/月/日" autocomplete="off" readonly="true"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">スタッフ</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <input type="text" id="custStaff" name="customerMessageInfo.custStaff" class="input-sm form-control-sm form-control" maxlength="50"> -->
                                <form:input id="custStaff" path="customerMessageInfo.custStaff" class="input-sm form-control-sm form-control" maxlength="50"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">区分</label></div>
                            <div class="col-12 col-md-9">
                                <!-- <select name="customerMessageInfo.custType" id="custType" class="form-control-sm form-control">
                                    <option value="01">一般</option>
                                    <option value="02">社着</option>
                                    <option value="03">サンプル</option>
                                    <option value="04">ゲージ</option>
                                    <option value="05">本社内見会</option>
                                    <option value="06">販売会</option>
                                    <option value="07">作り直し</option>
                                </select> -->
                                <form:select path="customerMessageInfo.custType" id="custType" class="form-control-sm form-control">
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
                                <!-- <select name="customerMessageInfo.custShippingDestination" id="destination" class="form-control-sm form-control">
                                    <option value="01">店舗</option>
                                    <option value="02">福山本社</option>
                                    <option value="03">TSC事業本部</option>
                                    <option value="04">お客様</option>
                                    <option value="05">他店舗</option>
                                </select> -->
                                <form:select path="customerMessageInfo.custShippingDestination" id="destination" class="form-control-sm form-control">
                                	<form:option value="01">店舗</form:option>
                                	<form:option value="02">福山本社</form:option>
                                	<form:option value="03">TSC事業本部</form:option>
                                	<form:option value="04">お客様</form:option>
                                	<form:option value="05">他店舗</form:option>
                                </form:select>
                            </div>
                            <c:if test="${order.custShippingDestination == 05}">
                            	<div class="col-12 col-md-9 offset-md-3" id="shopNameDiv">
                                <!-- <select name="customerMessageInfo.custShippingDestnationOtherstore" id="shopName" data-placeholder="店舗を選択" class="standardSelect" >
                                </select> -->
                                <form:select path="customerMessageInfo.custShippingDestnationOtherstore" id="shopName" data-placeholder="店舗を選択" class="standardSelect">
                                </form:select>
                            	</div>
                            </c:if>
                            <c:if test="${order.custShippingDestination != 05}">
                            	<div class="col-12 col-md-9 offset-md-3" id="shopNameDiv" style="display:none;">
                                	<!-- <select name="customerMessageInfo.custShippingDestnationOtherstore" id="shopName" data-placeholder="店舗を選択" class="standardSelect" >
                                	</select> -->
                                	<form:select path="customerMessageInfo.custShippingDestnationOtherstore" id="shopName" data-placeholder="店舗を選択" class="standardSelect">
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
                                <textarea name="customerMessageInfo.custRemark" id="custRemark" rows="3" placeholder="" class="form-control" maxlength="500"></textarea>
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
            </div></div>
            </div>
            </div>

            <div class="row">
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
                                    <li class="nav-item jkadjustbox" id="jacketChoose">
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
                                    </li>
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
                                    <form:options items="${orderForm.productItemMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group" id="threePiece_div">
                            <div class="col col-md-3"><label class=" form-control-label">３Piece</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="threePiece_id" path="productIs3Piece" class="form-check-input" items="${orderForm.optionGiletStandardInfo.threePieceMap}"/>
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
                                    <form:radiobuttons id="sparePants_id" path="productSparePantsClass" class="form-check-input" items="${orderForm.optionPantsStandardInfo.twoPantsMap}"/>
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
                                    <input type="text" id="productFabricNo" name="productFabricNo" placeholder="" class="form-control-sm form-control" style="width:128px" maxlength="20" onblur="stockCheck()">　
                                    <!-- <button type="button" class="btn btn-outline-info btn-sm" id="stockCheck">在庫チェック</button> -->
                                	<output id="stockMsg" style="display:none;"></output>
                                	<output id="fabricMsg"></output>
                                </div>
                            </div>
                            <!-- <div class="col-12 col-md-5">
                                <output id="stockMsg" style="display:none;"></output>
                                <output id="fabricMsg"></output>
                            </div> -->
                        </div>
                        <!-- <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">生地品番</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <input type="text" id="productFabricNo" name="productFabricNo" placeholder="" class="form-control-sm form-control" style="width:128px">
                                    <input type="text" id="productFabricNo" name="productFabricNo" placeholder="" class="form-control-sm form-control" style="width:128px" maxlength="20" onblur="stockCheck()">
                                    <output id="stockMsg"  style="display:none;"></output>
                                    <output id="fabricMsg"></output>
                                </div>
                            </div>
                        </div> -->
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">カテゴリ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_1"><i class="fa fa-question-circle"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="category_nomal" class="form-check-label ">
                                        <input type="radio" id="category_nomal" name="productCategory" value="0" class="form-check-input" checked>標準
                                    </label>　
                                    <label for="category_tuxedo" class="form-check-label ">
                                        <input type="radio" id="category_tuxedo" name="productCategory" value="2" class="form-check-input">タキシード
                                    </label>　
                                    <label for="category_washable" class="form-check-label ">
                                        <input type="radio" id="category_washable" name="productCategory" value="1" class="form-check-input">ウォッシャブル
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">LCR縫製</label>
<!--
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_1"><i class="fa fa-question-circle"></i></button>
-->
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="lcrSewing_no" class="form-check-label ">
                                        <input type="radio" id="lcrSewing_no" name="productLcrSewing" value="0000000" class="form-check-input" checked>無し
                                    </label>　
                                    <label for="lcrSewing_yes" class="form-check-label ">
                                        <input type="radio" id="lcrSewing_yes" name="productLcrSewing" value="0000001" class="form-check-input">有り
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <!--
                                ブランドネームはログインしたユーザーによって選択不可項目を設定する
                                    TSCユーザー：HILTON選択不可
                                    青山ユーザー：UNIVERSAL LANGUAGE MEASURE'S選択不可

                                モックではTSCユーザーでログインしている前提でHILTONを選択不可(disabled)としている
                            -->
                            <div class="col col-md-3"><label class=" form-control-label">ブランドネーム</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="brandName_ulm" class="form-check-label ">
                                        <input type="radio" id="brandName_ulm" name="productBrandNm" value="UNIVERSAL LANGUAGE MEASURE'S" class="form-check-input" checked>UNIVERSAL LANGUAGE MEASURE'S
                                    </label>　
                                    <label for="brandName_hilton" class="form-check-label ">
                                        <input type="radio" id="brandName_hilton" name="productBrandNm" value="HILTON" class="form-check-input" disabled="disabled">HILTON
                                    </label>　
                                    <label for="brandName_no" class="form-check-label ">
                                        <input type="radio" id="brandName_no" name="productBrandNm" value="無し" class="form-check-input">無し
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">生地ネーム</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="clothName_yes" class="form-check-label ">
                                        <input type="radio" id="clothName_yes" name="productFabricNmNecessity" value="1" class="form-check-input" checked>有り
                                    </label>　
                                    <label for="clothName_no" class="form-check-label ">
                                        <input type="radio" id="clothName_no" name="productFabricNmNecessity" value="0" class="form-check-input">無し
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍入れ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="embroidered_no" class="form-check-label ">
                                        <input type="radio" id="embroidered_no" name="productEmbroideryNecessity" value="0" class="form-check-input" checked>無し
                                    </label>　
                                    <label for="embroidered_yes" class="form-check-label ">
                                        <input type="radio" id="embroidered_yes" name="productEmbroideryNecessity" value="1" class="form-check-input">有り
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div id="embroidered_yes_area">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍ネーム</label></div>
                            <div class="col-12 col-md-6">
                                <input type="text" id="embroideryName" name="productEmbroideryNm" class="form-control-sm form-control">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍書体</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="embroideryFont_14" class="form-check-label ">
                                        <input type="radio" id="embroideryFont_14" name="productEmbroideryFont" value="14（花文字）" class="form-check-input">14（花文字）
                                    </label>　
                                    <label for="embroideryFont_48" class="form-check-label ">
                                        <input type="radio" id="embroideryFont_48" name="productEmbroideryFont" value="48（ブロック）" class="form-check-input">48（ブロック）
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍糸色</label></div>
                            <div class="col-12 col-md-3">
                                <select name="productEmbroideryThreadColor" id="embroideryColor" class="form-control-sm form-control">
                                    <!-- <option value="110（金茶）">110（金茶）</option>
                                    <option value="140（白）">140（白）</option> -->
                                </select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="embroideryColorMsg">
                            </div>
                        </div>
                        <div id="embroidered_shirts_area">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍箇所</label></div>
                            <div class="col col-md-4">
                                <select name="namePos" id="productEmbroideryNmPos" class="form-control-sm form-control">
                                    <option value="" selected>無し</option>
                                    <option value="上前胸">上前胸</option>
                                    <option value="上前腰">上前腰</option>
                                    <option value="上前二の腕">上前二の腕</option>
                                    <option value="上前カフス">上前カフス</option>
                                    <option value="下前カフス">下前カフス</option>
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍サイズ</label></div>
                            <div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                縦　
                                <a href="#" id="embroideryHeightRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="embroideryHeightRange" name="adjustShirtStandardInfo.embroideryHeightCorrect" value="0" min="" max="" step="0.5">&nbsp;
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
                                <input type="range" id="embroideryWidthRange" name="adjustShirtStandardInfo.embroideryWidthCorrect" value="0" min="" max="" step="0.5">&nbsp;
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
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="gadget_no" class="form-check-label ">
                                        <input type="radio" id="gadget_no" name="productEmbroideryGazette" value="0000000" class="form-check-input" checked>無し
                                    </label>　
                                    <label for="gadget_yes" class="form-check-label ">
                                        <input type="radio" id="gadget_yes" name=productEmbroideryGazette value="0000001" class="form-check-input">有り
                                    </label>
                                </div>
                            </div>
                        </div>
                        </div>
                        </div>
                        <div class="row form-group" id="cloth_div">
                            <div class="col col-md-3"><label class=" form-control-label">残布</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="cloth_small" class="form-check-label ">
                                        <input type="radio" id="cloth_small" name="productRemainingClothType" value="01" class="form-check-input">小（通常）
                                    </label>　
                                    <label for="cloth_big" class="form-check-label ">
                                        <input type="radio" id="cloth_big" name="productRemainingClothType" value="02" class="form-check-input">大（タテ15cm×ヨコ15cm）
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">生地ブランド</label></div>
                            <div class="col-12 col-md-9">
                                <p class="form-control-static">CARLO BARBERA</p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">素材名</label></div>
                            <div class="col-12 col-md-9">
                                <p class="form-control-static">CARLO BARBERA Super 130's Tropical</p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">組成表示　表地</label></div>
                            <div class="col-12 col-md-9">
                                <p class="form-control-static">ウール１００%</p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">組成表示　胴裏素材</label></div>
                            <div class="col-12 col-md-9">
                                <p class="form-control-static">キュプラ１００％</p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">組成表示　袖裏素材</label></div>
                            <div class="col-12 col-md-9">
                                <p class="form-control-static">キュプラ１００％</p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">取扱注意</label></div>
                            <div class="col-12 col-md-9">
                                <p class="form-control-static">取扱注意</p>
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
            </div>

            <div class="row">
            <div class="col-md-12">
            <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col">
                <button id="temporarySave" type="button" class="btn btn-info btn-block"><i class="fa fa-save"></i> 一時保存</button>
                    </div>
                    <div class="col">
                <button id="layUpSave" type="button" class="btn btn-warning btn-block"><i class="fa fa-hand-paper"></i> 取り置き</button>
                    </div>
                    <div class="col">
                <button id="coConfirm" type="submit" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i> 内容確認</button>
                    </div>
                    <div class="col">
                <button id="deleteButtom" type="button" class="btn btn-danger btn-block"><i class="fa fa-trash-o"></i> 削除</button>
                    </div>
                </div>
            </div>
            </div>
            </div>
            </div>

            </div>   
            
            <!-- メジャーリング -->   
            
            <input type="hidden" id="fullLength" name="MeasuringInfo.fullLength"  value="" />
            <input type="hidden" id="shoulder" name="MeasuringInfo.shoulder"  value=""/>
            <input type="hidden" id="reachRight" name="MeasuringInfo.reachRight"  value="" />
            <input type="hidden" id="reachLeft" name="MeasuringInfo.reachLeft"  value="" />
            <input type="hidden" id="outBust" name="MeasuringInfo.outBust"  value="" />
            <input type="hidden" id="bust" name="MeasuringInfo.bust"  value="" />
            <input type="hidden" id="jacketWaist" name="MeasuringInfo.jacketWaist"  value="" />
            <input type="hidden" id="pantsWaist" name="MeasuringInfo.pantsWaist"  value="" />
            <input type="hidden" id="hip" name="MeasuringInfo.hip"  value="" />
            <input type="hidden" id="spanRight" name="MeasuringInfo.spanRight"  value="" />
            <input type="hidden" id="spanLeft" name="MeasuringInfo.spanLeft"  value="" />
            <input type="hidden" id="calfRight" name="MeasuringInfo.calfRight"  value="" />
            <input type="hidden" id="calfLeft" name="MeasuringInfo.calfLeft"  value="" />
            <input type="hidden" id="neck" name="MeasuringInfo.neck"  value="" />
                
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
			<input type="hidden" id="billingAmountId"  name="billingAmount"   value="0" />
			<!-- 商品金額 -->
			<input type="hidden" id="productPriceId"  name="productPrice"   value="0" />
			<!-- オプション金額 -->
			<input type="hidden" id="optionPriceId"  name="optionPrice"   value="0" />
			<!-- 合計金額 -->
			<input type="hidden" id="totalPriceId"  name="totalPrice"   value="0" />
			<!-- 内消費税 -->
			<input type="hidden" id="consumptionTaxAmountId"  name="consumptionTaxAmount"   value="0" />
			<!-- 生地色 -->
			<input type="hidden" id="fabricColor"  name="fabricColor"   value="" />
			<!-- 生地柄 -->
			<input type="hidden" id="fabricPattern"  name="fabricPattern"   value="" />
			<!-- バージョン -->
			<input type="hidden" id="version"  name="version"  value="" />
			
			<!-- 非画面表示 -->
			<!-- オーダーパターン -->
			<input type="hidden" id="orderPattern" name="orderPattern" value="CO">
			
			<input type="hidden" id="shopCode"  name="shopCode"   value="${sessionContent.belongCode}" />
			
			<input type="hidden" id="factoryCode"  name="productFactoryCd"   value="" />
			
			<input type="hidden" id="makerCode"  name="productMakerCode"   value="" />
			
			<input type="hidden" id="storeBrandCode"  name="storeBrandCode"   value="${sessionContent.storeBrandCode}" />
			
			<input type="hidden" id="saveFlag"  name="saveFlag"   value="" />
			
			<input type="hidden" id="fabricFlag"  name="fabricFlag"   value="" />
			
			<input type="hidden" id="jkModelFlag"  name="jkModelFlag"   value="0" />
			<input type="hidden" id="glModelFlag"  name="glModelFlag"   value="0" />
			<input type="hidden" id="ptModelFlag"  name="ptModelFlag"   value="0" />
			<input type="hidden" id="pt2ModelFlag"  name="pt2ModelFlag"   value="0" />
			
			<input type="hidden" id="versionFlag"  name="versionFlag" value="" />
			
			
			<input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="0"/>
			<input type="hidden" id="pantsItemFlag" name="pantsItemFlag" value="0"/>
			<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="0"/>
			<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="0"/>
			<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="0"/>
			<input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="0"/>
					
			
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
            
            </form:form>
                                    
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


<script src="${pageContext.request.contextPath}/resources/app/js/jquery.min.js"></script>
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

	
	var orderFlag = "${orderForm.orderFlag}";
	if(orderFlag == "orderLink"){
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
		
		//メジャーリングを設定
		measuring();
	}

	initAlter();

	defaultGoodsInit();
	
	jQuery("#item").change(function(){
		getAdjustByItem();
	})
	
	jQuery('a[href="#nav2_JACKET"]').click(function(){
		jQuery(".tabbox").addClass("activebk");
		jQuery(".giletbox").removeClass("activebk");
		jQuery(".pantsbox").removeClass("activebk");
		jQuery(".pants2box").removeClass("activebk");
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		jQuery("#nav2_Div").load(contextPath + "/orderCo/goToJacketOption");
	})

	jQuery('a[href="#nav2_PANTS"]').click(function(){
		jQuery(".tabbox").addClass("activebk");
		jQuery(".jacketbox").removeClass("activebk");
		jQuery(".giletbox").removeClass("activebk");
		jQuery(".pants2box").removeClass("activebk");
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		jQuery("#nav2_Div").load(contextPath + "/orderCo/goToPants1Option");
	})

	jQuery('a[href="#nav2_2PANTS"]').click(function(){
		jQuery(".tabbox").addClass("activebk");
		jQuery(".jacketbox").removeClass("activebk");
		jQuery(".giletbox").removeClass("activebk");
		jQuery(".pantsbox").removeClass("activebk")
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		jQuery("#nav2_Div").load(contextPath + "/orderCo/goToPants2Option");
	})

	jQuery('a[href="#nav2_GILET"]').click(function(){
		jQuery(".tabbox").addClass("activebk");
		jQuery(".jacketbox").removeClass("activebk");
		jQuery(".pantsbox").removeClass("activebk");
		jQuery(".pants2box").removeClass("activebk")
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		jQuery("#nav2_Div").load(contextPath + "/orderCo/goToGiletOption");
	})

	jQuery('a[href="#nav2_SHIRT"]').click(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		jQuery("#nav2_Div").load(contextPath + "/orderCo/goToShirtOption");
	})

	jQuery('a[href="#nav2_COAT"]').click(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
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
		jQuery(".tabbox").removeClass("activebk");
		jQuery(".alertbox").removeClass("activebk");
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
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
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').serialize(),type: "post",async:false});
		jQuery("#option_div").hide();
		jQuery("#nav2_div_option").hide();
	})
	
	//js
	jQuery('a[href="#nav2_JACKET_Ad"]').click(function(){
		jQuery(".alertbox").addClass("activebk");
		jQuery(".gladjustbox").removeClass("activebk");
		jQuery(".ptadjustbox").removeClass("activebk");
		jQuery(".pt2adjustbox").removeClass("activebk");
		var jacketModel= jQuery("#jacketModel").val();
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		jQuery("#nav3_Div").load(contextPath + "/orderCo/jacketJsp");
	})

	jQuery('a[href="#nav2_PANTS_Ad"]').click(function(){
		jQuery(".alertbox").addClass("activebk");
		jQuery(".gladjustbox").removeClass("activebk");
		jQuery(".jkadjustbox").removeClass("activebk");
		jQuery(".pt2adjustbox").removeClass("activebk");
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		jQuery("#nav3_Div").load(contextPath + "/orderCo/pantsJsp");
	})

	jQuery('a[href="#nav2_2PANTS_Ad"]').click(function(){
		jQuery(".alertbox").addClass("activebk");
		jQuery(".gladjustbox").removeClass("activebk");
		jQuery(".jkadjustbox").removeClass("activebk");
		jQuery(".ptadjustbox").removeClass("activebk");
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		jQuery("#nav3_Div").load(contextPath + "/orderCo/pants2Jsp");
	})

	jQuery('a[href="#nav2_GILET_Ad"]').click(function(){
		jQuery(".alertbox").addClass("activebk");
		jQuery(".pt2adjustbox").removeClass("activebk");
		jQuery(".jkadjustbox").removeClass("activebk");
		jQuery(".ptadjustbox").removeClass("activebk");
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		jQuery("#nav3_Div").load(contextPath + "/orderCo/giletJsp");
	})

	jQuery('a[href="#nav2_SHIRT_Ad"]').click(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		jQuery("#nav3_Div").load(contextPath + "/orderCo/shirtJsp");
	})

	jQuery('a[href="#nav2_COAT_Ad"]').click(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		jQuery("#nav3_Div").load(contextPath + "/orderCo/coatJsp");
	})
	
	jQuery("#nav2_alter").click(function(){
		
		jQuery(".tabbox").removeClass("activebk");
		jQuery(".jkadjustbox").addClass("activebk");
		jQuery(".gladjustbox").addClass("activebk");
		jQuery(".ptadjustbox").addClass("activebk");
		jQuery(".pt2adjustbox").addClass("activebk");
		jQuery("#nav3_div_choose").show();
		
		var item = jQuery("#item").val();
		var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
		var sparePants = jQuery('input[name="productSparePantsClass"]:checked').val();
		if(item == "01"){
			jQuery("#option_div_adjust").show();
			document.getElementById("nav2_JACKET_Ad").click();
			jQuery("#jacketChoose").show();
			jQuery("#pantsChoose").show();
			jQuery("#pants2Choose").hide();
			jQuery("#giletChoose").hide();
			jQuery("#coatChoose").hide();
			jQuery("#shirtChoose").hide();
			if(threePiece == "0009902"){
				jQuery("#giletChoose").show();
			}
			if(sparePants == "0009902"){
				jQuery("#pants2Choose").show();
			}
		}else if(item == "02"){
			jQuery("#option_div_adjust").hide();
			document.getElementById("nav2_JACKET_Ad").click();
		}else if(item == "03"){
			jQuery("#option_div_adjust").hide();
			document.getElementById("nav2_PANTS_Ad").click();
		}else if(item == "04"){
			jQuery("#option_div_adjust").hide();
			document.getElementById("nav2_GILET_Ad").click();
		}else if(item == "05"){
			jQuery("#option_div_adjust").hide();
			document.getElementById("nav2_SHIRT_Ad").click();
		}else if(item == "06"){
			jQuery("#option_div_adjust").hide();
			document.getElementById("nav2_COAT_Ad").click();
		}
	})
	
	
	
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

	
	//一時保存ボタンをクリック
	jQuery("#temporarySave").click(function(){

		//保存flag
		jQuery("#saveFlag").val("0");
		//TSCステータス  一時保存
		jQuery("#statusInput").val("T0");
		
		jQuery.ajax({url : contextPath + "/orderCo/orderCoTemporarySave",
		    type: "post",
		    async:false,
			data: jQuery('#idForm').serialize(),
		    }).then(function(data){
			    if(data == "true"){
			    	//ステータス設定
					jQuery("#status").empty();
					jQuery("#status").html("一時保存");
				   	appendAlert('successmssage', getMsgByOneArg('msg015',jQuery("#orderId").val()));
				   	var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
					version = version.responseText;
					jQuery("#version").val(version);
				}else if(data.length == 12){
					jQuery("#orderId").val(data);
			    	//ステータス設定
					jQuery("#status").empty();
					jQuery("#status").html("一時保存");
				   	appendAlert('successmssage', getMsgByOneArg('msg015',jQuery("#orderId").val()));
				   	var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
					version = version.responseText;
					jQuery("#version").val(version);
				}
			})
	})

	
	//取り置きボタンをクリック
	jQuery("#layUpSave").click(function(){
		
		//バージョンフラッグ
		//var versionFlag = "";
		
		//保存flag
		jQuery("#saveFlag").val("0");
		//TSCステータス  取り置き
		jQuery("#statusInput").val("T1");
		
		jQuery.ajax({url : contextPath + "/order/orderPoTemporarySave",
		    type: "post",
		    async:false,
		    data: jQuery('#idForm').serialize(),
		    }).then(function(data){
		    	if(data == "true"){
			  	    //ステータス設定
				   	jQuery("#status").empty();
				   	jQuery("#status").html("取り置き");
				   	appendAlert('successmssage', getMsgByOneArg('msg058',jQuery("#orderId").val()));
				  	/* var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
					version = version.responseText;
					jQuery("#version").val(version); */
				}else if(data.length == 12){
					jQuery("#orderId").val(data);
			    	//ステータス設定
					jQuery("#status").empty();
					jQuery("#status").html("取り置き");
				   	appendAlert('successmssage', getMsgByOneArg('msg058',jQuery("#orderId").val()));
				   	/* var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
					version = version.responseText;
					jQuery("#version").val(version); */
				}
			})
	})

	jQuery('#deleteButtom').on('click', function() {
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
						/* var version = jQuery("#version").val();
						window.location.href= contextPath + "/orderCo/physicalDelete?orderId=" + orderId + "&version=" + version; */
					} else {
						// Cancel押下時は何もしない
					}
				});
			}
			
	});

});


//メジャーリングの制御
function measuringSetting(){
	//メジャーリング 
	var fullLengthText="";
	var fullLengthSelect="";
	jQuery("#fullLengthTe").on('input', function(){
		fullLengthText = jQuery("#fullLengthTe").val();
		var makeUpVal = fullLengthText+".0";
		jQuery("#fullLength").val(makeUpVal);
	})
	jQuery("#fullLengthSe").change(function(){
		fullLengthSelect = jQuery("#fullLengthSe").val();
		var makeUpVal = fullLengthText+"."+fullLengthSelect;
		jQuery("#fullLength").val(makeUpVal);
	})
	
	var shoulderText="";
	var shoulderSelect="";
	jQuery("#shoulderTe").on('input', function(){
		shoulderText = jQuery("#shoulderTe").val();
		var makeUpVal = shoulderText+".0";
		jQuery("#shoulder").val(makeUpVal);
	})
	jQuery("#shoulderSe").change(function(){
		shoulderSelect = jQuery("#shoulderSe").val();
		var makeUpVal = shoulderText+"."+shoulderSelect;
		jQuery("#shoulder").val(makeUpVal);
	})
	
	var reachRightText="";
	var reachRightSelect="";
	jQuery("#reachRightTe").on('input', function(){
		reachRightText = jQuery("#reachRightTe").val();
		var makeUpVal = reachRightText+".0";
		jQuery("#reachRight").val(makeUpVal);
	})
	jQuery("#reachRightSe").change(function(){
		reachRightSelect = jQuery("#reachRightSe").val();
		var makeUpVal = reachRightText+"."+reachRightSelect;
		jQuery("#reachRight").val(makeUpVal);
	})
	
	var reachLeftText="";
	var reachLeftSelect="";
	jQuery("#reachLeftTe").on('input', function(){
		reachLeftText = jQuery("#reachLeftTe").val();
		var makeUpVal = reachLeftText+".0";
		jQuery("#reachLeft").val(makeUpVal);
	})
	jQuery("#reachLeftSe").change(function(){
		reachLeftSelect = jQuery("#reachLeftSe").val();
		var makeUpVal = reachLeftText+"."+reachLeftSelect;
		jQuery("#reachLeft").val(makeUpVal);
	})
	
	var outBustText="";
	var outBustSelect="";
	jQuery("#outBustTe").on('input', function(){
		outBustText = jQuery("#outBustTe").val();
		var makeUpVal = outBustText+".0";
		jQuery("#outBust").val(makeUpVal);
	})
	jQuery("#outBustSe").change(function(){
		outBustSelect = jQuery("#outBustSe").val();
		var makeUpVal = outBustText+"."+outBustSelect;
		jQuery("#outBust").val(makeUpVal);
	})
	
	var bustText="";
	var bustSelect="";
	jQuery("#bustTe").on('input', function(){
		bustText = jQuery("#bustTe").val();
		var makeUpVal = bustText+".0";
		jQuery("#bust").val(makeUpVal);
	})
	jQuery("#bustSe").change(function(){
		bustSelect = jQuery("#bustSe").val();
		var makeUpVal = bustText+"."+bustSelect;
		jQuery("#bust").val(makeUpVal);
	})
	
	var jacketWaistText="";
	var jacketWaistSelect="";
	jQuery("#jacketWaistTe").on('input', function(){
		jacketWaistText = jQuery("#jacketWaistTe").val();
		var makeUpVal = jacketWaistText+".0";
		jQuery("#jacketWaist").val(makeUpVal);
	})
	jQuery("#jacketWaistSe").change(function(){
		jacketWaistSelect = jQuery("#jacketWaistSe").val();
		var makeUpVal = jacketWaistText+"."+jacketWaistSelect;
		jQuery("#jacketWaist").val(makeUpVal);
	})
	
	var pantsWaistText="";
	var pantsWaistSelect="";
	jQuery("#pantsWaistTe").on('input', function(){
		pantsWaistText = jQuery("#pantsWaistTe").val();
		var makeUpVal = pantsWaistText+".0";
		jQuery("#pantsWaist").val(makeUpVal);
	})
	jQuery("#pantsWaistSe").change(function(){
		pantsWaistSelect = jQuery("#pantsWaistSe").val();
		var makeUpVal = pantsWaistText+"."+pantsWaistSelect;
		jQuery("#pantsWaist").val(makeUpVal);
	})
	
	var hipText="";
	var hipSelect="";
	jQuery("#hipTe").on('input', function(){
		hipText = jQuery("#hipTe").val();
		var makeUpVal = hipText+".0";
		jQuery("#hip").val(makeUpVal);
	})
	jQuery("#hipSe").change(function(){
		hipSelect = jQuery("#hipSe").val();
		var makeUpVal = hipText+"."+hipSelect;
		jQuery("#hip").val(makeUpVal);
	})
	
	var spanRightText="";
	var spanRightSelect="";
	jQuery("#spanRightTe").on('input', function(){
		spanRightText = jQuery("#spanRightTe").val();
		var makeUpVal = spanRightText+".0";
		jQuery("#spanRight").val(makeUpVal);
	})
	jQuery("#spanRightSe").change(function(){
		spanRightSelect = jQuery("#spanRightSe").val();
		var makeUpVal = spanRightText+"."+spanRightSelect;
		jQuery("#spanRight").val(makeUpVal);
	})
	
	var spanLeftText="";
	var spanLeftSelect="";
	jQuery("#spanLeftTe").on('input', function(){
		spanLeftText = jQuery("#spanLeftTe").val();
		var makeUpVal = spanLeftText+".0";
		jQuery("#spanLeft").val(makeUpVal);
	})
	jQuery("#spanLeftSe").change(function(){
		spanLeftSelect = jQuery("#spanLeftSe").val();
		var makeUpVal = spanLeftText+"."+spanLeftSelect;
		jQuery("#spanLeft").val(makeUpVal);
	})
	
	var calfRightText="";
	var calfRightSelect="";
	jQuery("#calfRightTe").on('input', function(){
		calfRightText = jQuery("#calfRightTe").val();
		var makeUpVal = calfRightText+".0";
		jQuery("#calfRight").val(makeUpVal);
	})
	jQuery("#calfRightSe").change(function(){
		calfRightSelect = jQuery("#calfRightSe").val();
		var makeUpVal = calfRightText+"."+calfRightSelect;
		jQuery("#calfRight").val(makeUpVal);
	})
	
	var calfLeftText="";
	var calfLeftSelect="";
	jQuery("#calfLeftTe").on('input', function(){
		calfLeftText = jQuery("#calfLeftTe").val();
		var makeUpVal = calfLeftText+".0";
		jQuery("#calfLeft").val(makeUpVal);
	})
	jQuery("#calfLeftSe").change(function(){
		calfLeftSelect = jQuery("#calfLeftSe").val();
		var makeUpVal = calfLeftText+"."+calfLeftSelect;
		jQuery("#calfLeft").val(makeUpVal);
	})
	
	var neckText="";
	var neckSelect="";
	jQuery("#neckTe").on('input', function(){
		neckText = jQuery("#neckTe").val();
		var makeUpVal = neckText+".0";
		jQuery("#neck").val(makeUpVal);
	})
	jQuery("#neckSe").change(function(){
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
		}else if(goodsTemp.type == "4"){
			jQuery("#"+goodsTemp.id).val(goodsTemp.dVal);
		}
	}
}

jQuery('#coConfirm').click(function(){
	// 確認メッセージ
	swal({
		  text: getMsg('msg122'),
		  icon: "info",
		  buttons: ["キャンセル", true],
		})
		.then((isConfirm) => {
		  if (isConfirm) {
			 jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idAdjustForm').serialize(),type: "post",async:false});
			 jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idForm').serialize(),type: "post",async:false});
			 jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
			 jQuery('select').removeAttr("disabled");
			 jQuery('input').removeAttr("disabled");
			 document.getElementById('idForm').submit();
						 
		  }
		});

	return false;
})

function getAdjustByItem(){
	var subItemCode = "";
	var itemCode = jQuery("#item").val();
	if(itemCode == "05"){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getAdjustByItem",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	        	   if(e.subItemCode == "05"){
	        		   if(e.adjusteClass == "15"){
							document.getElementById("embroideryHeightRange").max = e.adjusteMax;
							document.getElementById("embroideryHeightRange").min = e.adjusteMin;
						}
		        	   if(e.adjusteClass == "16"){
							document.getElementById("embroideryWidthRange").max = e.adjusteMax;
							document.getElementById("embroideryWidthRange").min = e.adjusteMin;
						}						 
			       }
	           });
	        }
	    });
	}
}

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
	var item = jQuery("#item option:selected").val();
	var productFabricNo = jQuery("#productFabricNo").val();
	//保存flag
	jQuery("#saveFlag").val("1");
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
		jQuery("#clothName_yes").removeAttr("disabled","disabled");
		optionRetailPrice("");
		allPrice();

		//注文を登録
		jQuery('select').removeAttr("disabled");
		jQuery('input').not("#clothName_yes").removeAttr("disabled");
		jQuery.ajax({url : contextPath + "/orderCo/stockDecrease",
		    type: "post",
		    async:false,
		    data: jQuery('#idForm').serialize(),
		 }).then(function(result){
			 if(result == "true"){
				//ステータス設定
			   	jQuery("#status").empty();
			   	var statusInput = jQuery("#statusInput").val();
				if(statusInput=="T0"){
				   jQuery("#status").html("一時保存");
				}else{
				   jQuery("#status").html("取り置き");
				}
				var version = jQuery.ajax({url:contextPath + "/orderCo/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
				version = version.responseText;
				jQuery("#version").val(version);
			 }else if(result.length == 12){
				 appendAlertDel('errormssage');
				 jQuery("#orderId").val(result);
			     //ステータス設定
				 jQuery("#status").empty();
			   	 var statusInput = jQuery("#statusInput").val();
				 if(statusInput=="T0"){
				 	 jQuery("#status").html("一時保存");
				 }else{
					 jQuery("#status").html("取り置き");
				 }
				 var version = jQuery.ajax({url:contextPath + "/orderCo/getOrderVersion",data:{"orderId":result},async:false});
				 version = version.responseText;
				 jQuery("#version").val(version);
			 }
		 })
	//生地品番が有りの場合
	}else{
		//在庫チェック
		var checkResult = fabricCheck(item,productFabricNo);
		//在庫成功の場合
		if(checkResult == "0"){
			//注文を登録　8、9
			jQuery('select').removeAttr("disabled");
			jQuery('input').not("#clothName_yes").removeAttr("disabled");
			jQuery.ajax({url : contextPath + "/orderCo/stockDecrease",
			    type: "post",
			    async:false,
			    data: jQuery('#idForm').serialize(),
		        }).then(function(result){
		        	if(result == "true"){
						jQuery("#status").empty();
					   	 var statusInput = jQuery("#statusInput").val();
						 if(statusInput=="T0"){
						 	 jQuery("#status").html("一時保存");
						 }else{
							 jQuery("#status").html("取り置き");
						 }
		        		var version = jQuery.ajax({url:contextPath + "/orderCo/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
						version = version.responseText;
						jQuery("#version").val(version);
				    }else if(result.length == 12){
						 appendAlertDel('errormssage');
						 jQuery("#orderId").val(result);
					     //ステータス設定
						 jQuery("#status").empty();
					   	 var statusInput = jQuery("#statusInput").val();
						 if(statusInput=="T0"){
						 	 jQuery("#status").html("一時保存");
						 }else{
							 jQuery("#status").html("取り置き");
						 }
						 var version = jQuery.ajax({url:contextPath + "/orderCo/getOrderVersion",data:{"orderId":result},async:false});
						 version = version.responseText;
						 jQuery("#version").val(version);
					 }
			    });
		}
		//生地によって、商品を表示
		if(checkResult == "0"||checkResult == "2"){
			fabricView(item,productFabricNo);
		}
	}
}

//生地によって、商品を表示
function fabricView(item,productFabricNo){
	jQuery.ajax({
		 type:"get",
		 url: contextPath + "/order/findStock",
		 data:{"fabricNo":productFabricNo,"orderPattern":orderPattern},
		 async:false,
		 success:function(result){
			 if(result == "" || result == null){
				 
			 }else{
				 // 生地品番の色を取得
				 var color = result.color;
				 // 生地品番の柄を取得
				 var pattern = result.pattern;

				 //生地ネーム有無
				 var fabricNameExis = result.fabricNameExis;
				 //生地ネーム無しの場合
				 if(fabricNameExis == "0"){
					jQuery('input[id="clothName_yes"]').prop("disabled",true);
					jQuery("#clothName_no").prop("checked","checked");
				 }
				 //生地ネーム有りの場合
				 else if(fabricNameExis == "1"){
					 jQuery("#clothName_yes").removeAttr("disabled","disabled");
				 }
				  
				 //商品金額と合計金額を計算する　7
				 allGoodsPrice(result);

				 optionRetailPrice(result)
				  
				 // 生地品番の値から対象の素材色をセット
				 jQuery("#factoryCode").val(result.factoryCode);
				 jQuery("#makerCode").val(result.makerCode);
				 jQuery("#productFabricBrandNm").val(result.brandName);
				 jQuery("#productServiceNm").val(result.materialName);
				 jQuery("#productComposFrtFabric").val(result.compositionLabel);
				 jQuery("#productNotice").val(result.handlingCaution);
				 jQuery("#fabricColor").val(color);
				 jQuery("#fabricPattern").val(pattern);

				 var countUsage = (result.theoreticalStock*1000 - result.reservationStock*1000)/1000;
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
  var taxRate = "${orderForm.taxRate}"
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
	   allOptionPrice();
	}else{
		  var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
		  //3Pieceが有りの場合
		  if(threePiece == "0009902"){
			 //上代
			 var retailPrice = Number(result.retailPrice);
			 //シングルGILET追加増額率/100
			 var additionalSingleGiletRate = Number(result.additionalSingleGiletRate)/100;
			 
			 var formulaPrice = retailPrice*additionalSingleGiletRate;
			 var format = formatMoney(Number(formulaPrice),0,"￥");
			 jQuery("#threePiece_Msg").html(format);
			 allOptionPrice();
			 
		  }
		  //3Pieceが無しの場合
		  else if(threePiece == "0009901"){
			 jQuery("#threePiece_Msg").html("無料");
			 allOptionPrice();
		  }
		  
		  jQuery('input[name="productIs3Piece"]').unbind("click").click(function(){
			  var threePiece = jQuery(this).val();
			  //3Pieceが有りの場合
			  if(threePiece == "0009902"){
				 //上代
				 var retailPrice = Number(result.retailPrice);
				 //シングルGILET追加増額率/100
				 var additionalSingleGiletRate = Number(result.additionalSingleGiletRate)/100;
				 
				 var formulaPrice = retailPrice*additionalSingleGiletRate;
				 var format = formatMoney(Number(formulaPrice),0,"￥");
				 jQuery("#threePiece_Msg").html(format);
				 allOptionPrice();
				 
			  }
			  //3Pieceが無しの場合
			  else if(threePiece == "0009901"){
				 jQuery("#threePiece_Msg").html("無料");
				 allOptionPrice();
	 	      }
		  })
		
		  var twoPants = jQuery('input[name="productSparePantsClass"]:checked').val();
		  //2Pantsが有りの場合
		  if(twoPants == "0009902"){
			 //上代
			 var retailPrice = Number(result.retailPrice);
			 //PANTS追加増額率/100
			 var additionalPantsRate = Number(result.additionalPantsRate)/100;
			 
			 var formulaPrice = retailPrice*additionalPantsRate;
			 var format = formatMoney(Number(formulaPrice),0,"￥");
			 jQuery("#sparePants_Msg").html(format);
			 allOptionPrice();
		  }
		  //2Pantsが無しの場合
		  else if(twoPants == "0009901"){
			 jQuery("#sparePants_Msg").html("無料");
			 allOptionPrice();
 	      }
 	      
		  jQuery('input[name="productSparePantsClass"]').unbind("click").click(function(){
			  var twoPants = jQuery(this).val();
			  //2Pantsが有りの場合
			  if(twoPants == "0009902"){
				 //上代
				 var retailPrice = Number(result.retailPrice);
				 //PANTS追加増額率/100
				 var additionalPantsRate = Number(result.additionalPantsRate)/100;
				 
				 var formulaPrice = retailPrice*additionalPantsRate;
				 var format = formatMoney(Number(formulaPrice),0,"￥");
				 jQuery("#sparePants_Msg").html(format);
				 allOptionPrice();
			  }
			  //2Pantsが無しの場合
			  else if(twoPants == "0009901"){
				 jQuery("#sparePants_Msg").html("無料");
				 allOptionPrice();
	 	      }
		  })

		// フロント釦数
		var frontBtnCnt = jQuery('#oj_frontBtnCnt').val();
		//ダブル６つボタン:0000105
		//ラペルデザイン  ノッチ:lapelDesign_id1 、ピークド:lapelDesign_id2
		if (frontBtnCnt == "0000105"||frontBtnCnt == "0000106") {
				var item = jQuery("#item").val();
				if(item == "01"){
					//ダブルJACKET増額率
					var additionalDoubleJacketRate = result.additionalDoubleJacketRate;
					if(additionalDoubleJacketRate=="0"||additionalDoubleJacketRate==0){
						jQuery("#jacketModel_Msg").html("無料");
						allOptionPrice();
					}else{
						var format = formatMoney(Number(additionalDoubleJacketRate),0,"￥");
						jQuery("#jacketModel_Msg").html(format);
						allOptionPrice();
					}
				}else if(item == "02"){
					//(上代*ダブルJACKET単品率/100+「ダブルJacketの単品購買追加金額」) -　(上代*シングルJACKET単品率/100+「シングルJacketの単品購買追加金額」)
					//上代
					var retailPrice = Number(result.retailPrice);
					//ダブルJACKET単品率/100
					var doubleJacketOnlyRate = Number(result.doubleJacketOnlyRate)/100;
					//ダブルJacketの単品購買追加金額
					var jkDoubleOnlyPlusAlphaPrice = Number(result.jkDoubleOnlyPlusAlphaPrice);
					//シングルJACKET単品率/100
					var singleJacketOnlyRate = Number(result.singleJacketOnlyRate)/100;
					//シングルJacketの単品購買追加金額
					var jkSingleOnlyPlusAlphaPrice = Number(result.jkSingleOnlyPlusAlphaPrice);
						
					var formulaPrice = ((retailPrice*doubleJacketOnlyRate)+jkDoubleOnlyPlusAlphaPrice) - 
					((retailPrice*singleJacketOnlyRate)+jkSingleOnlyPlusAlphaPrice);

					var format = formatMoney(Number(formulaPrice),0,"￥");
					jQuery("#jacketModel_Msg").html(format);
					allOptionPrice();
				}
		} else {
			jQuery("#jacketModel_Msg").empty();
			allOptionPrice();
		}
			
		jQuery('#oj_frontBtnCnt').change(function(){
			var frontBtnCnt = jQuery(this).val();
			//ダブル６つボタン:0000105
			//ラペルデザイン  ノッチ:lapelDesign_id1 、ピークド:lapelDesign_id2
			if (frontBtnCnt == "0000105"||frontBtnCnt == "0000106") {
					var item = jQuery("#item").val();
					if(item == "01"){
						//ダブルJACKET増額率
						var additionalDoubleJacketRate = result.additionalDoubleJacketRate;
						if(additionalDoubleJacketRate=="0"||additionalDoubleJacketRate==0){
							jQuery("#jacketModel_Msg").html("無料");
							allOptionPrice();
						}else{
							var format = formatMoney(Number(additionalDoubleJacketRate),0,"￥");
							jQuery("#jacketModel_Msg").html(format);
							allOptionPrice();
						}
					}else if(item == "02"){
						//(上代*ダブルJACKET単品率/100+「ダブルJacketの単品購買追加金額」) -　(上代*シングルJACKET単品率/100+「シングルJacketの単品購買追加金額」)
						//上代
						var retailPrice = Number(result.retailPrice);
						//ダブルJACKET単品率/100
						var doubleJacketOnlyRate = Number(result.doubleJacketOnlyRate)/100;
						//ダブルJacketの単品購買追加金額
						var jkDoubleOnlyPlusAlphaPrice = Number(result.jkDoubleOnlyPlusAlphaPrice);
						//シングルJACKET単品率/100
						var singleJacketOnlyRate = Number(result.singleJacketOnlyRate)/100;
						//シングルJacketの単品購買追加金額
						var jkSingleOnlyPlusAlphaPrice = Number(result.jkSingleOnlyPlusAlphaPrice);
						
						var formulaPrice = ((retailPrice*doubleJacketOnlyRate)+jkDoubleOnlyPlusAlphaPrice) - 
						((retailPrice*singleJacketOnlyRate)+jkSingleOnlyPlusAlphaPrice);

						var format = formatMoney(Number(formulaPrice),0,"￥");
						jQuery("#jacketModel_Msg").html(format);
						allOptionPrice();
					}
			} else {
				jQuery("#jacketModel_Msg").empty();
				allOptionPrice();
			}
		});
	}
}
//--------------------------------------------
//オプション金額
//--------------------------------------------
function allOptionPrice(){
	//oj_frontBtnCnt_Msg： フロント釦数、　lapelDesign_Msg：ラペルデザイン、　fort_Msg：台場、　backSpec_Msg：裏仕様、　waistPkt_Msg：腰ポケット、
	//changePkt_Msg：チェンジポケット、　slantedPkt_Msg：スランテッドポケット、　cuffSpec_Msg：袖口、　stitch_Msg：AMFステッチ、　ventSpec_Msg：ベント、
	//bodyBackMate_Msg：胴裏素材、　cuffBackMate_Msg：袖裏素材、　btnMate_Msg：釦素材、　og_stitch_Msg：AMFステッチ、　og_backLiningMate_Msg：背裏地素材、
	//og_insideLiningMate_Msg：内側裏地素材、　og_frontBtnMate_Msg：釦素材、　op_tack_Msg：タック、　op_adjuster_Msg：アジャスター仕様、
	//op_hemUp_Msg：裾上げ、　op_doubleWide_Msg：ダブル幅、　op_btnMate_Msg：釦素材、　op_eight_Msg：エイト（滑り止め）、　op_thick_Msg：シック大（股補強）、
	//op_shapeMemory_Msg：形状記憶、　op_blister_Msg：靴ずれ、　op2_shapeMemory_Msg：形状記憶、　op2_blister_Msg：靴ずれ
	//op2_tack_Msg：タック、　op2_adjuster_Msg：アジャスター仕様、
	//op2_hemUp_Msg：裾上げ、　op2_doubleWide_Msg：ダブル幅、　op2_btnMate_Msg：釦素材、　op2_eight_Msg：エイト（滑り止め）、　op2_thick_Msg：シック大（股補強）、
	//sparePants_Msg：スペアパンツ、　threePiece_Msg：３Piece　、　og_breastPkt_Msg：胸ポケット
	var priceHtmlMsgList = ["oj_frontBtnCnt_Msg","lapelDesign_Msg","fort_Msg","backSpec_Msg","waistPkt_Msg","changePkt_Msg",
		"slantedPkt_Msg","cuffSpec_Msg","stitch_Msg","ventSpec_Msg","bodyBackMate_Msg","cuffBackMate_Msg","btnMate_Msg",
		"og_stitch_Msg","og_backLiningMate_Msg","og_insideLiningMate_Msg","og_frontBtnMate_Msg","op_tack_Msg","op_adjuster_Msg","op_hemUp_Msg",
		"op_doubleWide_Msg","op_btnMate_Msg","op_eight_Msg","op_thick_Msg","op_shapeMemory_Msg","op_blister_Msg",
		"op2_tack_Msg","op2_adjuster_Msg","op2_hemUp_Msg","op2_doubleWide_Msg","op2_btnMate_Msg","op2_eight_Msg","op2_thick_Msg",
		"op2_shapeMemory_Msg","op2_blister_Msg","sparePants_Msg","threePiece_Msg","og_breastPkt_Msg","jacketModel_Msg"];

  var op_hemUp = jQuery("#op_hemUp option:selected").val();
  var op2_hemUp = jQuery("#op2_hemUp option:selected").val();
  
	var msgPrice = null;
	var count = 0;
	var msg;
	for(msgPrice of priceHtmlMsgList){
		//シングル:0001701  モーニングカット:0001704
		if(msgPrice=="op_doubleWide_Msg"){
			if(op_hemUp=="0001701"||op_hemUp=="0001704"){
				continue;
			}else{
				msg = jQuery("#"+msgPrice).html();
				if(msg =='無料'){
					msg = '0';
				}else if(msg ==''||msg == null){
					msg = '0';
				}
				
				if(msg.indexOf("￥")!=-1){
					msg = msg.substr(1,msg.length-1);
					if(msg.length>3){
						msg = msg.replace(/,/g,'');
					}
					
				}
				count += Number(msg);
			}
		}else if(msgPrice=="op2_doubleWide_Msg"){
			if(op2_hemUp=="0001701"||op2_hemUp=="0001704"){
				continue;
			}else{
				msg = jQuery("#"+msgPrice).html();
				if(msg =='無料'){
					msg = '0';
				}else if(msg ==''||msg == null){
					msg = '0';
				}
				
				if(msg.indexOf("￥")!=-1){
					msg = msg.substr(1,msg.length-1);
					if(msg.length>3){
						msg = msg.replace(/,/g,'');
					}
					
				}
				count += Number(msg);
			}
		}else{
			msg = jQuery("#"+msgPrice).html();
			if(msg =='無料'){
				msg = '0';
			}else if(msg ==''||msg == null){
				msg = '0';
			}
			
			if(msg.indexOf("￥")!=-1){
				msg = msg.substr(1,msg.length-1);
				if(msg.length>3){
					msg = msg.replace(/,/g,'');
				}
				
			}
			count += Number(msg);
		}
		
		
	}
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
	
	giletModel = jQuery("#giletModel option:selected").val();
	
	//フロント釦数 : oj_frontBtnCnt   0000102: 2つボタン  0000103: 1つボタン      0000105: ダブル6つボタン    
	frontBtnCnt = jQuery("#oj_frontBtnCnt option:selected").val();
	
	//threePiece　　　	 0009901： 無し　0009902：有り　　
	//hasTwoPants　　　　　　0009901： 無し　0009902：有り　　
	
	//JACKET+PANTS
	if(itemCode=='01'){
		goodsPrice = result.retailPrice;
	}
	//JACKET単品
	else if(itemCode == '02'&&frontBtnCnt!='0000105'){
		goodsPrice = (Number(result.retailPrice)*(Number(result.singleJacketOnlyRate))/100) + Number(result.jkSingleOnlyPlusAlphaPrice);
	}
	//ダブルJACKET単品
	else if(itemCode == '02'&&frontBtnCnt=='0000105'){
		goodsPrice = (Number(result.retailPrice)*(Number(result.singleJacketOnlyRate))/100) + Number(result.jkSingleOnlyPlusAlphaPrice);
	}
	//シングルGILET単品
	else if(itemCode == '04'){
		goodsPrice = (Number(result.retailPrice)*(Number(result.singleGiletOnlyRate))/100) + Number(result.glSingleOnlyPlusAlphaPrice);
	}
	//PANTS単品
	else if(itemCode == '03'){
		goodsPrice = (Number(result.retailPrice)*(Number(result.pantOnlyRate))/100) + Number(result.ptOnlyPlusAlphaPrice);
	}
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
		 jQuery("#jacketModelMsg").empty();
		 jQuery("#pantsModelMsg").empty();
		 jQuery("#2pantsModelMsg").empty();
		 jQuery("#giletModelMsg").empty();
		 jQuery("#fabricMsg").empty();

		 jQuery("#clothName_yes").removeAttr("disabled","disabled");
		 allOptionPrice();
		 //生地チェク失敗フラッグ
		 fabricCheckValue = "1";
		 jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsgByTwoArgs('msg012', '生地品番', '英数字'));
		 return false;
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
					 jQuery("#clothName_yes").removeAttr("disabled","disabled");
					 allOptionPrice();
	 				 setAlert('stockMsg', getMsg('msg049'));
	 				 //生地チェク失敗フラッグ
	 				 fabricCheckValue = "1";
	 				 jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsg('msg049'));
	     		} 
	     		//生地情報が有りの場合
	     		else{
		     		//入力した生地は選択したITEMを作るできるのチェク
		     		//canMake(アイテム,アイテム区分)　4
	     			if(!canMake(item,result.itemClass)){
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
						jQuery("#clothName_yes").removeAttr("disabled","disabled");
						allOptionPrice();
	     				setAlert('stockMsg', getMsg('msg049'));
	     				//生地チェク失敗フラッグ
	     				fabricCheckValue = "1";
	     				jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsg('msg049'));
	     				return false;
	         		 }
					 //生地店着日チェク
					 //isShopDeliveryEmpty(店着納期区分（通常）,生地品番)　5
	     			 if(!isShopDeliveryEmpty(result.storeDelvNormal,productFabricNo)){
	         			setAlert('stockMsg', getMsgByOneArg('msg072',productFabricNo));
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
						jQuery("#clothName_yes").removeAttr("disabled","disabled");
						allOptionPrice();
						//生地チェク失敗フラッグ
						fabricCheckValue = "1";
	     				jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsgByOneArg('msg072',productFabricNo));
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
	     			  var yieldNum = getYieldNum(item);
					  //受注可能在庫数 = 理論在庫 - 予約生地量
	     			  var countUsage = Number(result.theoreticalStock) - (Number(result.reservationStock)-Number(fakeStock));
	     			  //受注可能在庫数チェク　6
	     			  if(countUsage<yieldNum){
     					  setAlert('stockMsg', getMsgByThreeArgs('msg063', result.color,result.pattern,Number(result.theoreticalStock) - Number(result.reservationStock)));
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
						  jQuery("#clothName_yes").removeAttr("disabled","disabled");
						  allOptionPrice();
						  //生地チェク失敗フラッグ
						  fabricCheckValue = "1";
        				  jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsgByThreeArgs('msg063', result.color,result.pattern,result.theoreticalStock));
        				  return false;	 
	     		      }
	     		      
	     			  //生地ネーム有無
	     			  var fabricNameExis = result.fabricNameExis;
	     			  //生地ネーム無しの場合
					  if(fabricNameExis == "0"){
						 jQuery('input[id="clothName_yes"]').prop("disabled",true);
						 jQuery("#clothName_no").prop("checked","checked");
					  }
					  //生地ネーム有りの場合
					  else if(fabricNameExis == "1"){
						  jQuery("#clothName_yes").removeAttr("disabled","disabled");
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
function canMake(item,itemClass){
	// 01:　ｽｰﾂ、ｼﾞｬｹｯﾄ、ﾊﾟﾝﾂ、ｼﾞﾚ、ｺｰﾄﾞ可 、02：ｼﾞｬｹｯﾄ、ｼﾞﾚ、ｺｰﾄﾞ可、05： ｼｬﾂ可、06：ｺｰﾄ可
	var itemClassList = {"01":"01,02,03,04,06","02":"02,04,06","05":"05","06":"06"}
	var itemNum = itemClassList[itemClass];
	itemNum = itemNum.split(",");
	if(jQuery.inArray(item, itemNum)!=-1){
		return true;
	}else{
		return false;
	}
}

//生地店着日チェク
function isShopDeliveryEmpty(storeDelvNormal,productFabricNo){
	var checkResult = true;
	jQuery.ajax({url : contextPath + "/order/getShopDeliveryOn", 
		async:false,
		data:{"storeDelvNormal":storeDelvNormal},
		type : 'get'}).then(function(result) {
			if(result.length==0){
				checkResult = false;
			}else{
				jQuery("#custShopDeliveryDate").val(dateFormat(result));
				appendAlertDel('errormssage');
				checkResult = true;
			}
		})
	return checkResult;
}

//要尺を取得
function getYieldNum(item){
	var yieldNum = 0;
	var yieldList = ${orderForm.yield};
	var yieldIndex = null;

	 var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
	 var twoPants = jQuery('input[name="productSparePantsClass"]:checked').val();
	 var glModel = jQuery("#giletModel option:selected").val();
	 var frontBtnCntVal = jQuery("#oj_frontBtnCnt option:selected").val();
	 
	 //ダブル6つボタン : 0000105   ３Piece 0009901 : 無し  0009902 : 有り   スペアパンツ 0009901 : 無し   0009902 : 有り
	 
	 //SUIT、３Piece:無し 、スペアパンツ: 無し  
	 if(item=="01"&&threePiece=="0009901"&&twoPants=="0009901"){
		// シングル JACKET
		if(frontBtnCntVal!="0000105"){
			for(yieldIndex of yieldList){
				if(yieldIndex.subItemCode=='02'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
				if(yieldIndex.subItemCode=='03'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
			}
		// ダブル JACKET	
		}else if(frontBtnCntVal=="0000105"){
			for(yieldIndex of yieldList){
				if(yieldIndex.subItemCode=='02'){
					yieldNum = yieldNum + yieldIndex.doubleBreastedFabricAmount;
				}
				if(yieldIndex.subItemCode=='03'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
			}
		}
	 //SUIT、３Piece:有り 、スペアパンツ: 無し  
	 }else if(item=="01"&&threePiece=="0009902"&&twoPants=="0009901"){
		// シングル JACKET  シングル GILET
		if(frontBtnCntVal!="0000105"){
			for(yieldIndex of yieldList){
				if(yieldIndex.subItemCode=='02'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
				if(yieldIndex.subItemCode=='03'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
				if(yieldIndex.subItemCode=='04'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
		    }
		//ダブル JACKET  シングル GILET   
		}else if(frontBtnCntVal=="0000105"){
			for(yieldIndex of yieldList){
				if(yieldIndex.subItemCode=='02'){
					yieldNum = yieldNum + yieldIndex.doubleBreastedFabricAmount;
				}
				if(yieldIndex.subItemCode=='03'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
				if(yieldIndex.subItemCode=='04'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
		    }
		}
	 //SUIT、３Piece:無し 、スペアパンツ: 有り  
     }else if(item=="01"&&threePiece=="0009901"&&twoPants=="0009902"){
    	 //シングル JACKET
		if(frontBtnCntVal!="0000105"){
			for(yieldIndex of yieldList){
				if(yieldIndex.subItemCode=='02'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
				if(yieldIndex.subItemCode=='03'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
				if(yieldIndex.subItemCode=='07'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
		    }
		//ダブル JACKET
		}else if(frontBtnCntVal=="0000105"){
			for(yieldIndex of yieldList){
				if(yieldIndex.subItemCode=='02'){
					yieldNum = yieldNum + yieldIndex.doubleBreastedFabricAmount;
				}
				if(yieldIndex.subItemCode=='03'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
				if(yieldIndex.subItemCode=='07'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
		    }
		}
	 }else if(item=="01"&&threePiece=="0009902"&&twoPants=="0009902"){
		// シングル JACKET  シングル GILET
			if(frontBtnCntVal!="0000105"){
				for(yieldIndex of yieldList){
					if(yieldIndex.subItemCode=='02'){
						yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
					}
					if(yieldIndex.subItemCode=='03'){
						yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
					}
					if(yieldIndex.subItemCode=='04'){
						yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
					}
					if(yieldIndex.subItemCode=='07'){
						yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
					}
			    }
			//ダブル JACKET  シングル GILET   
			}else if(frontBtnCntVal=="0000105"&&glModel.indexOf("-D")==-1){
				for(yieldIndex of yieldList){
					if(yieldIndex.subItemCode=='02'){
						yieldNum = yieldNum + yieldIndex.doubleBreastedFabricAmount;
					}
					if(yieldIndex.subItemCode=='03'){
						yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
					}
					if(yieldIndex.subItemCode=='04'){
						yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
					}
					if(yieldIndex.subItemCode=='07'){
						yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
					}
			    }
			}
	 }else if(item == '02'){
		//シングル JACKET 
		 if(frontBtnCntVal!='0000105'){
			 for(yieldIndex of yieldList){
					if(yieldIndex.subItemCode=='02'){
						yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
					}
			     }
		 //ダブル JACKET
	     }else if(frontBtnCntVal=='0000105'){
	    	 for(yieldIndex of yieldList){
					if(yieldIndex.subItemCode=='02'){
						yieldNum = yieldNum + yieldIndex.doubleBreastedFabricAmount;
					}
				 }
		 }
	 //PANTSの場合
     }else if(item == '03'){
    	for(yieldIndex of yieldList){
				if(yieldIndex.subItemCode=='03'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
		}
	　//GILETの場合
	 }else if(item == '04'){
		 //シングル GILET
	     for(yieldIndex of yieldList){
				if(yieldIndex.subItemCode=='04'){
					yieldNum = yieldNum + yieldIndex.nomalFabricAmount;
				}
		 }
    }
	yieldNum = yieldNum/1000;
	jQuery("#theoryFabricUsedMountId").val(yieldNum);
	return yieldNum;
}
</script>
