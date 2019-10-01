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
#custRemark {
	font-size:.875rem;
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
		<spring:nestedPath path="orderForm">
    			<form:errors path="*" element="div" class="error-message-list" />
		</spring:nestedPath>
        <form:form id="formId" action="${pageContext.request.contextPath}/order/orderPoReconfirm" method="post" modelAttribute="orderForm" class="form-horizontal">
        <div class="content mt-3">
            <div class="animated fadeIn">
            <t:messagesPanel  messagesAttributeName="resultMessages"/>
            <!-- <div class="alert alert-info" id="errorResult" style="display:none"></div> -->
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
			<%-- <form:form action="${pageContext.request.contextPath}/order/orderPoReconfirm" method="post" modelAttribute="orderForm" class="form-horizontal"> --%>
            <div class="animated fadeIn">
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
                                <input type="text" id="orderId" name="customerMessageInfo.orderId" class="input-sm form-control-sm form-control" value="" readonly>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">会員番号</label></div>
                            <div class="col-12 col-md-6" style="padding-right:0;">
                                <div class="input-group">
                                <input type="text" id="custCd" name="customerMessageInfo.custCd" class="input-sm form-control-sm form-control" maxlength="13">
                                    <span class="input-group-btn"><button type="button" id="custSearchButton" class="btn btn-primary btn-sm">会員検索</button></span>
                            </div>
                        </div>
                            <div class="col col-md-3" style="padding-left:0;"><button type="button" id="searchButton" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#infotext_2">非会員検索</button></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">お客様氏名</label></div>
                            <div class="col-12 col-md-9">
                                <input type="text" id="custNm" name="customerMessageInfo.custNm" class="input-sm form-control-sm form-control" maxlength="50" readonly="readonly">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フリガナ</label></div>
                            <div class="col-12 col-md-9">
                                <input type="text" id="custKanaNm" name="customerMessageInfo.custKanaNm" class="input-sm form-control-sm form-control" maxlength="60" readonly="readonly">
                            </div>
                        </div>
                         <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">名簿納期</label></div>
                            <div class="col-12 col-md-9">
                                <input type="text" autocomplete="off" id="custDeliverDate" name="customerMessageInfo.custDeliverDate" placeholder="年/月/日" class="input-sm form-control-sm form-control">
                            </div>
                        </div>
                    </div>
                    <div class="col col-lg-6">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">お渡し日</label></div>
                            <div class="col-12 col-md-9">
                                <input type="text" id="custShopDeliveryDate" name="customerMessageInfo.custShopDeliveryDate" placeholder="年/月/日" class="input-sm form-control-sm form-control" readonly="readonly">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">スタッフ</label></div>
                            <div class="col-12 col-md-9">
                                <input type="text" id="custStaff" name="customerMessageInfo.custStaff" class="input-sm form-control-sm form-control" maxlength="50">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">区分</label></div>
                            <div class="col-12 col-md-9">
                                <select name="customerMessageInfo.custType" id="custType" class="form-control-sm form-control">
                                    <option value="01">一般</option>
                                    <option value="02">社着</option>
                                    <option value="03">サンプル</option>
                                    <option value="04">ゲージ</option>
                                    <option value="05">本社内見会</option>
                                    <option value="06">販売会</option>
                                    <option value="07">作り直し</option>
                                </select>
                            </div>
                        </div>

                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">出荷先</label></div>
                            <div class="col-12 col-md-9">
                                <select name="customerMessageInfo.custShippingDestination" id="destination" class="form-control-sm form-control">
                                    <option value="01">店舗</option>
                                    <option value="02">福山本社</option>
                                    <!-- <option value="03">TSC事業本部</option> -->
                                    <option value="04">お客様</option>
                                    <option value="05">他店舗</option>
                                </select>
                            </div>
                            <c:if test="${order.custShippingDestination == 05}">
                            	<div class="col-12 col-md-9 offset-md-3" id="shopNameDiv">
                                <select name="customerMessageInfo.custShippingDestnationOtherstore" id="shopName" data-placeholder="店舗を選択" class="standardSelect" >
                                </select>
                            </div>
                            </c:if>
                            <c:if test="${order.custShippingDestination != 05}">
                            	<div class="col-12 col-md-9 offset-md-3" id="shopNameDiv" style="display:none;">
                                	<select name="customerMessageInfo.custShippingDestnationOtherstore" id="shopName" data-placeholder="店舗を選択" class="standardSelect" >
                                	</select>
                            	</div>
                            </c:if>
                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div style="padding-left:15px;width:12.5%"><label class=" form-control-label">お客様備考</label></div>
                            <div style="padding-right:15px;padding-left:15px;width:87.5%">
                                <textarea name="customerMessageInfo.custRemark" id="custRemark" rows="3" class="form-control" maxlength="500"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div></div>
            <div class="card" id="nav1_mejer_div">
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
                                    <li class="nav-item">
                                        <a class="nav-link active" href="#" id="nav2_product">商品</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#" id="nav2_option">オプション</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#" id="nav2_alter">補正</a>
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
                                    <div class="form-check-inline form-check">
                                    	<form:radiobuttons id="threePiece_id" path="productIs3Piece" class="form-check-input" items="${orderForm.optionGiletStandardInfo.threePieceMap}"/>
                                	</div>
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
                                    <div class="form-check-inline form-check">
                                    	<form:radiobuttons id="sparePants_id" path="productSparePantsClass" class="form-check-input" items="${orderForm.optionPantsStandardInfo.twoPantsMap}"/>
                                	</div>
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
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">カテゴリ</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <select name="productCategory" id="category" class="form-control-sm form-control">
                                        <option value="0">標準</option>
                                        <!-- <option value="ウォッシャブル">ウォッシャブル</option> -->
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group" id="brandName_div">
                            <div class="col col-md-3"><label class=" form-control-label">ブランドネーム</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="brandName_yes" class="form-check-label ">
                                        <input type="radio" id="brandName_yes" name="productBrandType" value="1" class="form-check-input" checked>有り
                                    </label>　
                                    <label for="brandName_no" class="form-check-label ">
                                        <input type="radio" id="brandName_no" name="productBrandType" value="0" class="form-check-input">無し
                                    </label>

                                </div>
                            </div>
                        </div>
                        <div class="row form-group" id="clothName_div">
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
                                <input type="text" id="embroideryName" name="productEmbroideryNm" class="form-control-sm form-control" maxlength="15">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍書体</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="embroideryFont_14" class="form-check-label ">
                                        <input type="radio" id="embroideryFont_14" name="productEmbroideryFont" value="14（花文字）" class="form-check-input" >14（花文字）
                                    </label>　
                                    <label for="embroideryFont_48" class="form-check-label ">
                                        <input type="radio" id="embroideryFont_48" name="productEmbroideryFont" value="48（ブロック）" class="form-check-input">48（ブロック）
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍糸色</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="embroideryColor_110" class="form-check-label ">
                                        <input type="radio" id="embroideryColor_110" name="productEmbroideryThreadColor" value="110（金茶）" class="form-check-input" >110（金茶）
                                    </label>　
                                    <label for="embroideryColor_401" class="form-check-label ">
                                        <input type="radio" id="embroideryColor_401" name="productEmbroideryThreadColor" value="401（白）" class="form-check-input">401（白）
                                    </label>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="embroideryColorMsg">
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
                        <div class="row form-group" id="composFrtFabric_div">
                            <div class="col col-md-3"><label class=" form-control-label">組成表示　表地</label></div>
                            <div class="col-12 col-md-9">
                                <p id="compos_frt_fabric_p" class="form-control-static"></p>
                            </div>
                        </div>
                        <div class="row form-group" id="composBodyLiner_div">
                            <div class="col col-md-3"><label class=" form-control-label">組成表示　胴裏地</label></div>
                            <div class="col-12 col-md-9">
                                <p id ="compos_body_liner_p" class="form-control-static"></p>
                            </div>
                        </div>
                        <div class="row form-group" id="composSleeveLiner_div">
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
            <div class="card" id="nav2_option_div">
            <div id="op_jacket_div">
            <div class="card-header">
                <strong class="card-title">JACKET</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">JACKETモデル</label>
                            </div>
                            <div class="col-12 col-md-3">
                                <form:select id="jacketModel" path="optionJacketStandardInfo.ojJacketModel" class="form-control-sm form-control">
                                    	<%-- <form:options items="${orderForm.optionJacketStandardInfo.ojJacketModelMap}"/> --%>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right">
                            	<output id="jacketModel_Msg" ></output>
                            </div>
                            <div class="col-12 col-md-6 offset-md-3" id="jacketModelMsg" style="margin-top:8px">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント釦数</label>
                            </div>
                            <div class="col-12 col-md-3">
                                <form:select id="oj_frontBtnCnt" path="optionJacketStandardInfo.ojFrontBtnCnt" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionJacketStandardInfo.ojFrontBtnCntMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right">
                            	<output id="oj_frontBtnCnt_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <div class="form-check-inline form-check">
                                    <form:radiobuttons id="lapelDesign_id" path="optionJacketStandardInfo.ojLapelDesign" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojLapelDesignMap}"/>
                                </div>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="lapelDesign_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">台場</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="fort_id" path="optionJacketStandardInfo.ojFort" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojFortMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="fort_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裏仕様</label>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="backSpec_id" path="optionJacketStandardInfo.ojGackSpec" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojGackSpecMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="backSpec_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">腰ポケット</label>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="waistPkt_id" path="optionJacketStandardInfo.ojWaistPkt" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojWaistPktMap}"/>
                            	</div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="waistPkt_Msg"></output>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="waistPktMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="changePkt_id" path="optionJacketStandardInfo.ojChangePkt" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojChangePktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="changePkt_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="slantedPkt_id" path="optionJacketStandardInfo.ojSlantedPkt" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojSlantedPktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="slantedPkt_Msg"></output>
                            </div>
                        </div>
                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="cuffSpec_id" path="optionJacketStandardInfo.ojCuffSpec" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojCuffSpecMap}"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" align="right">
                             	<output id="cuffSpec_Msg"></output>
                        	 </div>
                        </div>
                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMFステッチ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="stitch_id" path="optionJacketStandardInfo.ojStitch" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojStitchMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="stitch_Msg"></output>
                        	</div>
                        </div>
                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
                            <div class="col-12 col-md-7">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="ventSpec_id" path="optionJacketStandardInfo.ojVentSpec" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojVentSpecMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-2" align="right">
                            	<output id="ventSpec_Msg"></output>
                        	</div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
                            <div class="col col-md-3">
                                <form:select id="bodyBackMate" path="optionJacketStandardInfo.ojBodyBackMate" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketStandardInfo.ojBodyBackMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionJacketStandardInfo.ojBodyBackMateStkNo" id="bodyBackMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2" align="right">
                            	<output id="bodyBackMate_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
                            <div class="col col-md-3">
                                <form:select id="cuffBackMate" path="optionJacketStandardInfo.ojCuffBackMate" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketStandardInfo.ojCuffBackMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionJacketStandardInfo.ojCuffBackMateStkNo" id="cuffBackMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2" align="right">
                            	<output id="cuffBackMate_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
                            <div class="col col-md-3">
                                <form:select id="btnMate" path="optionJacketStandardInfo.ojBtnMate" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketStandardInfo.ojBtnMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionJacketStandardInfo.ojBtnMateStkNo" id="btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2" align="right">
                            	<output id="btnMate_Msg"></output>
                            </div>
                        </div>
                        <%-- <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="shapeMemory_id" path="optionJacketStandardInfo.ojShapeMemory" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojShapeMemoryMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="shapeMemory_Msg" align="right">
                        	</div>
                        </div> --%>
                    </div>
                </div>

            </div></div>
            <div id="op_gilet_div">
            <div class="card-header">
                <strong class="card-title">GILET</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">GILETモデル</label>
                            </div>
                            <div class="col col-md-3">
                                
                                <form:select id="giletModel" path="optionGiletStandardInfo.ogGiletModel" class="form-control-sm form-control">
                                    	<%-- <form:options items="${orderForm.optionGiletStandardInfo.ogGiletModelMap}"/> --%>
                                </form:select>
                                
                            </div>
                            <div class="col-12 col-md-6 offset-md-3" id="giletModelMsg" style="margin-top:8px"></div>
                        </div>
                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="og_breastPkt_id" path="optionGiletStandardInfo.ogBreastPkt" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogBreastPktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="og_breastPkt_Msg"></output>
                            </div>
                        </div>
                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMFステッチ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="og_stitch_id" path="optionGiletStandardInfo.ogStitch" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogStitchMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="og_stitch_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">背裏地素材</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="og_backLiningMate" path="optionGiletStandardInfo.ogBackLiningMate" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionGiletStandardInfo.ogBackLiningMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionGiletStandardInfo.ogBackLiningMateStkNo" id="og_backLiningMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2" align="right">
                            	<output id="og_backLiningMate_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="og_insideLiningMate" path="optionGiletStandardInfo.ogInsideLiningMate" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionGiletStandardInfo.ogInsideLiningMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionGiletStandardInfo.ogInsideLiningMateStkNo" id="og_insideLiningMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2" align="right">
                            	<output id="og_insideLiningMate_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="og_frontBtnMate" path="optionGiletStandardInfo.ogFrontBtnMate" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionGiletStandardInfo.ogFrontBtnMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionGiletStandardInfo.ogFrontBtnMateStkNo" id="og_frontBtnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2" align="right">
                            	<output id="og_frontBtnMate_Msg"></output>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            <div id="op_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSモデル</label>
                            </div>
                            <div class="col col-md-3">
                                
                                <form:select id="op_pantsModel" path="optionPantsStandardInfo.opPantsModel" class="form-control-sm form-control">
                                    	<%-- <form:options items="${orderForm.optionPantsStandardInfo.opPantsModelMap}"/> --%>
                                </form:select>
                                
                            </div>
                            <div class="col-12 col-md-6 offset-md-3" id="pantsModelMsg" style="margin-top:8px"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                                <form:select id="op_tack" path="optionPantsStandardInfo.opTack" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opTackMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-6" align="right">
                            	<output id="op_tack_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_adjuster_id" path="optionPantsStandardInfo.opAdjuster" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opAdjusterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="op_adjuster_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op_hemUp" path="optionPantsStandardInfo.opHemUp" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opHemUpMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-6" align="right">
                            	<output id="op_hemUp_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group"  id="op_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                                <form:select id="op_doubleWide" path="optionPantsStandardInfo.opDoubleWide" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opDoubleWideMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-6" align="right">
                            	 <output id="op_doubleWide_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op_btnMate" class="form-control-sm form-control" path="optionPantsStandardInfo.opButton">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opButtonMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionPantsStandardInfo.opBtnMateStkNo" id="op_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2" align="right">
                            	<output id="op_btnMate_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_eight_id" path="optionPantsStandardInfo.opEight" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opEightMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="op_eight_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_thick_id" path="optionPantsStandardInfo.opThick" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opThickMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="op_thick_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_shapeMemory_id" path="optionPantsStandardInfo.opShapeMemory" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opShapeMemoryMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="op_shapeMemory_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">靴ずれ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_blister_id" path="optionPantsStandardInfo.opBlister" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opBlisterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="op_blister_Msg"></output>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            <div id="op2_pants_div">
            <div class="card-header">
                <!-- <strong class="card-title" style="margin-top:10px;margin-left:15px;margin-bottom:10px;">PANTS（2本目）</strong>　　
                <button type="button" class="btn btn-outline-info btn-sm" style="height:30px" id="btn_op2_samePants">1本目と同じ</button> -->
                <strong class="card-title">PANTS（2本目）</strong>　　
                <button type="button" class="btn btn-outline-info btn-sm" id="btn_op2_samePants">1本目と同じ</button>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSモデル</label>
                            </div>
                            <div class="col col-md-3">
                                
                                <form:select id="op2_pantsModel" path="optionPants2StandardInfo.op2PantsModel" class="form-control-sm form-control">
                                    	<%-- <form:options items="${orderForm.optionPants2StandardInfo.op2PantsModelMap}"/> --%>
                                </form:select>
                                
                            </div>
                            <div class="col-12 col-md-6 offset-md-3" id="2pantsModelMsg" style="margin-top:8px"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                                <form:select id="op2_tack" path="optionPants2StandardInfo.op2Tack" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPants2StandardInfo.op2TackMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right">
                            	<output id="op2_tack_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_adjuster_id" path="optionPants2StandardInfo.op2Adjuster" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2AdjusterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="op2_adjuster_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op2_hemUp" path="optionPants2StandardInfo.op2HemUp" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPants2StandardInfo.op2HemUpMap }"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right">
                            	<output id="op2_hemUp_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group"  id="op2_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                                <form:select id="op2_doubleWide" path="optionPants2StandardInfo.op2DoubleWide" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPants2StandardInfo.op2DoubleWideMap }"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right">
                            	 <output id="op2_doubleWide_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op2_btnMate" class="form-control-sm form-control" path="optionPants2StandardInfo.op2Button">
                                	<form:options items="${orderForm.optionPants2StandardInfo.op2ButtonMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionPants2StandardInfo.op2BtnMateStkNo" id="op2_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2" align="right">
                            	<output id="op2_btnMate_Msg"></output>
                            </div>
                            <div class="col col-md-7" align="right">
                            	<output id="op2BtnMateMsg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_eight_id" path="optionPants2StandardInfo.op2Eight" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2EightMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="op2_eight_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_thick_id" path="optionPants2StandardInfo.op2Thick" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2ThickMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="op2_thick_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_shapeMemory_id" path="optionPants2StandardInfo.op2ShapeMemory" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2ShapeMemoryMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="op2_shapeMemory_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">靴ずれ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_blister_id" path="optionPants2StandardInfo.op2Blister" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2BlisterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="op2_blister_Msg"></output>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            </div>
            <div class="card" id="nav2_alter_div">
            <div id="al_jacket_div">
            <div class="card-header">
                <strong class="card-title">JACKET</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">JACKETサイズ</label></div>
                            <div class="col-12 col-md-6">
                           		 体型
                                <div class="form-check-inline form-check">
                                <form:select id="selectJacketFigure" path="adjustJacketStandardInfo.sizeFigure" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustJacketStandardInfo.sizeFigureMap}"/> 
                                </form:select>
                                </div>
                               	 号数
                                <div class="form-check-inline form-check">
                                <form:select id="selectJacketNumber" path="adjustJacketStandardInfo.sizeNumber" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustJacketStandardInfo.sizeNumberMap}"/> 
                                </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">JACKET補正</label></div>
                            <div class="col-12 col-md-3">
                                <label class=" form-control-label">着丈修正</label>
                            </div>
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkBodyRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkBodyRange" name="adjustJacketStandardInfo.corJkBodyCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corJkBodyRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkBodyRange_out" name="">0</output>cm
                                </div>
                            </div>
                            
                            <div class="col-12 col-md-2" id="corJkBody_div">
                                <output id="corJkBody_div_html">000.0cm</output>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">ウエスト修正</label>
                            </div>
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkWaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkWaistRange" name="adjustJacketStandardInfo.corJkWaistCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corJkWaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkWaistRange_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-2" id="corJkWaist_div">
                                <!-- <output>000.0</output>cm -->
                                <output id="corJkWaist_div_html">000.0cm</output>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">袖丈右修正</label>
                            </div>
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkRightsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkRightsleeveRange" name="adjustJacketStandardInfo.corJkRightsleeveCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corJkRightsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkRightsleeveRange_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-2" id="corJkRightsleeve_div">
                               <!--  <output>000.0</output>cm -->
                               <output id="corJkRightsleeve_div_html">000.0cm</output>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">袖丈左修正</label>
                            </div>
								<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkLeftsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkLeftsleeveRange" name="adjustJacketStandardInfo.corJkLeftsleeveCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corJkLeftsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkLeftsleeveRange_out">0</output>cm
                                </div>
                            </div>                            
                            <div class="col-12 col-md-2" id="corJkLeftsleeve_div">
                            <output id="corJkLeftsleeve_div_html">000.0cm</output>
                                <!-- <output>000.0</output>cm -->
                            </div>
                        </div>
                    </div>
                </div>
            </div></div>
            <div id="al_gilet_div">
            <div class="card-header">
                <strong class="card-title">GILET</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">GILETサイズ</label></div>
                            <div class="col-12 col-md-6">
                            	体型
                                <div class="form-check-inline form-check">
                                <form:select id="selectGiletFigure" path="adjustGiletStandardInfo.sizeFigure" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustGiletStandardInfo.sizeFigureMap}"/>
                                </form:select>
                                </div>
                                                                                                号数
                                <div class="form-check-inline form-check">
                                <form:select id="selectGiletNumber" path="adjustGiletStandardInfo.sizeNumber" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustGiletStandardInfo.sizeNumberMap}"/>
                                </form:select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div></div>
            <div id="al_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSサイズ</label></div>
                            <div class="col-12 col-md-6">
                          	            体型
                                <div class="form-check-inline form-check">
                                <form:select id="selectPantsFigure" path="adjustPantsStandardInfo.sizeFigure" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustPantsStandardInfo.sizeFigureMap}"/>
                                </form:select>
                                </div>
                               	 号数
                                <div class="form-check-inline form-check">
                                <form:select id="selectPantsNumber" path="adjustPantsStandardInfo.sizeNumber" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustPantsStandardInfo.sizeNumberMap}"/>
                                </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTS補正</label></div>
                            <div class="col-12 col-md-3">
                                <label class=" form-control-label">ウエスト修正</label>
                            </div>
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtWaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtWaistRange" name="adjustPantsStandardInfo.corPtWaistCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corPtWaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtWaistRange_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-2" id="corPtWaist_div">
                            	<output id="corPtWaist_div_html">000.0cm</output>
                                <!-- <output>000.0</output>cm -->
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">ワタリ幅修正</label>
                            </div>
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtThighRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtThighRange" name="adjustPantsStandardInfo.corPtThighCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corPtThighRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtThighRange_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-2" id="corPtThigh_div">
                            	<output id="corPtThigh_div_html">000.0cm</output>
                                <!-- <output>000.0</output>cm -->
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">裾幅</label>
                            </div>
                            <!-- <div class="col-12 col-md-1">
                                <label for="ap_hemWidth_relative" class="form-check-label ">
                                    <input type="radio" id="corPtHemwidthType" name="adjustPantsStandardInfo.corPtHemwidthType" value="1" class="form-check-input">修正
                                </label>
                            </div> -->
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtHemwidthRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtHemwidthRange" name="adjustPantsStandardInfo.corPtHemwidthCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corPtHemwidthRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtHemwidthRange_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-2" id="corPtHemwidth_div" style="display:none">
                                <output id="corPtHemwidth_div_html">000.0cm</output>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">股下</label>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                左&nbsp;
                                <select name="ap_inseamLeft100" id="ap_inseamLeft100" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                </select>
                                <select name="ap_inseamLeft10" id="ap_inseamLeft10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>
                                <select name="ap_inseamLeft1" id="ap_inseamLeft1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>.
                                <select name="ap_inseamLeftM1" id="ap_inseamLeftM1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                <div class="col-12 col-md-2" id="corPtLeftinseam_div" style="display:none">
                                	<label id="corPtLeftinseam_div_html"></label>
                            	</div>
                                　　右&nbsp;
                                <select name="ap_inseamRight100" id="ap_inseamRight100" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                </select>
                                <select name="ap_inseamRight10" id="ap_inseamRight10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>
                                <select name="ap_inseamRight1" id="ap_inseamRight1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>.
                                <select name="ap_inseamRightM1" id="ap_inseamRightM1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                <div class="col-12 col-md-2" id="corPtRightinseam_div" style="display:none">
                                	<label id="corPtRightinseam_div_html"></label>
                            	</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div></div>
            <div id="al2_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS（2本目）</strong>　　<button type="button" class="btn btn-outline-info btn-sm" id="btn_ap2_samePants">1本目と同じ</button>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSサイズ</label></div>
                            <div class="col-12 col-md-6">
                            	体型
                                <div class="form-check-inline form-check">
                                <form:select id="selectPants2Figure" path="adjustPants2StandardInfo.sizeFigure" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustPants2StandardInfo.sizeFigureMap}"/>
                                </form:select>
                                </div>
                               	 号数
                                <div class="form-check-inline form-check">
                                <form:select id="selectPants2Number" path="adjustPants2StandardInfo.sizeNumber" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustPants2StandardInfo.sizeNumberMap}"/>
                                </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTS補正</label></div>
                            <div class="col-12 col-md-3">
                                <label class=" form-control-label">ウエスト修正</label>
                            </div>
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPt2WaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPt2WaistRange" name="adjustPants2StandardInfo.corPt2WaistCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corPt2WaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPt2WaistRange_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-2" id="corPt2Waist_div">
                            	<output id="corPt2Waist_div_html">000.0cm</output>
                                <!-- <output>000.0</output>cm -->
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">ワタリ幅修正</label>
                            </div>
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPt2ThighRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPt2ThighRange" name="adjustPants2StandardInfo.corPt2ThighCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corPt2ThighRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPt2ThighRange_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-2" id="corPt2Thigh_div">
                            	<output id="corPt2Thigh_div_html">000.0cm</output>
                                <!-- <output>000.0</output>cm -->
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">裾幅</label>
                            </div>
                            <!-- <div class="col-12 col-md-1">
                                <label for="ap_hemWidth_relative" class="form-check-label ">
                                    <input type="radio" id="corPt2HemwidthType" name="adjustPants2StandardInfo.corPt2HemwidthType" value="1" class="form-check-input">修正
                                </label>
                            </div> -->
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPt2HemwidthRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPt2HemwidthRange" name="adjustPants2StandardInfo.corPt2HemwidthCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corPt2HemwidthRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPt2HemwidthRange_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-2" id="corPt2Hemwidth_div" style="display:none">
                                <output id="corPt2Hemwidth_div_html">000.0cm</output>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">股下</label>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                左&nbsp;
                                <select name="ap2_inseamLeft100" id="ap2_inseamLeft100" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                </select>
                                <select name="ap2_inseamLeft10" id="ap2_inseamLeft10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>
                                <select name="ap2_inseamLeft1" id="ap2_inseamLeft1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>.
                                <select name="ap2_inseamLeftM1" id="ap2_inseamLeftM1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                <div class="col-12 col-md-2" id="corPt2Leftinseam_div" style="display:none">
                                	<label id="corPt2Leftinseam_div_html"></label>
                            	</div>
                                　　右&nbsp;
                                <select name="ap2_inseamRight100" id="ap2_inseamRight100" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                </select>
                                <select name="ap2_inseamRight10" id="ap2_inseamRight10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>
                                <select name="ap2_inseamRight1" id="ap2_inseamRight1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>.
                                <select name="ap2_inseamRightM1" id="ap2_inseamRightM1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                <div class="col-12 col-md-2" id="corPt2Rightinseam_div" style="display:none">
                                	<label id="corPt2Rightinseam_div_html"></label>
                            	</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div></div>
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
										<input type="text" id="corJkBodyRe" name="adjustJacketStandardInfo.corJkBodylengthCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
										<input type="text" id="corJkWaistRe" name="adjustJacketStandardInfo.corJkWaistCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
										<input type="text" id="corJkRightsleeveRe" name="adjustJacketStandardInfo.corJkRightsleeveCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
										<input type="text" id="corJkLeftsleeveRe" name="adjustJacketStandardInfo.corJkLeftsleeveCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
										<input type="text" id="corPtWaistRe" name="adjustPantsStandardInfo.corPtWaistCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
										<input type="text" id="corPtHipRe" name="adjustPantsStandardInfo.corPtHipCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
										<div style="float:left;">&nbsp;cm</div>
									</div>
									<div class="col-12 col-md-3">
										<label class=" form-control-label">ワタリ修正</label>
									</div>
									<div class="col-12 col-md-9" id="corPtThighwidthCorrectAgain">
										<a id="corPtThighwidth_range_1_m" class="re_alter_sign minus" style="display:none;">
											<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
										</a>
										<a id="corPtThighwidth_range_1_p" class="re_alter_sign plus">
											<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
										</a>
										<div style="float:left;">&nbsp;</div>
										<input type="text" id="corPtThighwidthRe" name="adjustPantsStandardInfo.corPtThighwidthCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
										<input type="text" id="corPtHemwidthRe" name="adjustPantsStandardInfo.corPtHemwidthCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
										<input type="text" id="corPtRightinseamRe" name="adjustPantsStandardInfo.corPtRightinseamCorrectAgain" placeholder="0" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
										<input type="text" id="corPtLeftinseamRe" name="adjustPantsStandardInfo.corPtLeftinseamCorrectAgain" placeholder="0" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
										<input type="text" id="corPt2WaistRe" name="adjustPants2StandardInfo.corPt2WaistCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
										<input type="text" id="corPt2HipRe" name="adjustPants2StandardInfo.corPt2HipCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
										<div style="float:left;">&nbsp;cm</div>
									</div>
									<div class="col-12 col-md-3">
										<label class=" form-control-label">ワタリ修正</label>
									</div>
									<div class="col-12 col-md-9" id="corPt2ThighwidthCorrectAgain">
										<a id="corPt2Thighwidth_range_1_m" class="re_alter_sign minus" style="display:none;">
											<i class="fa fa-minus-square" style="font-size:32px; float:left;"></i>
										</a>
										<a id="corPt2Thighwidth_range_1_p" class="re_alter_sign plus">
											<i class="fa fa-plus-square" style="font-size:32px; float:left;"></i>
										</a>
										<div style="float:left;">&nbsp;</div>
										<input type="text" id="corPt2ThighwidthRe" name="adjustPants2StandardInfo.corPt2ThighwidthCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
										<input type="text" id="corPt2HemwidthRe" name="adjustPants2StandardInfo.corPt2HemwidthCorrectAgain" placeholder="" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
										<input type="text" id="corPt2RightinseamRe" name="adjustPants2StandardInfo.corPt2RightinseamCorrectAgain" placeholder="0" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
										<input type="text" id="corPt2LeftinseamRe" name="adjustPants2StandardInfo.corPt2LeftinseamCorrectAgain" placeholder="0" class="input-sm form-control-sm form-control" style="width:100px; float:left; text-align:right;" maxlength="5" onkeyup='clearNoNum(this)'>
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
								<textarea id="corStoreCorrectionMemo" name="corStoreCorrectionMemoAgain" rows="3" class="form-control" maxlength="500"></textarea>
							</div>
						</div>
					</div>
				</div>
		</div>
		</div>
        <!-- 再補正タブ内容 End -->
        </c:if>
            </div>
            </div>
            </div>
 			<c:if test="${(order==''||order==null||order.tscStatus == null)&&(orderForm.status==''||orderForm.status=='T0'||orderForm.status=='T1')}">
            <div class="row">
            <div class="col-md-12">
            <div class="card">
            
           
            	<div class="card-body" id="normalBtnType_div">
                <div class="row">
                    <div class="col">
                <button type="button" id="temporarySave" class="btn btn-info btn-block"><i class="fa fa-save"></i> 一時保存</button>
                    </div>
                    <div class="col">
                <button type="button" id="layUpSave" class="btn btn-warning btn-block"><i class="fa fa-save"></i> 取り置き</button>
                
                    </div>
                    <div class="col">
                <button id = "poConfirm" type="submit" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i> 内容確認</button>
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
            <c:if test="${order.tscStatus == 'T2'||order.tscStatus == 'T3'||order.tscStatus == 'T4'||order.tscStatus == 'T5'||orderForm.status == 'T2'||orderForm.status == 'T3'||orderForm.status == 'T4'||orderForm.status == 'T5'}">
            <div class="row">
            <div class="col-md-12">
            <div class="card">
            <div class="card-body">
            
            
                <div class="row">
                    <div class="col">
                    </div>
                    	<div class="col col-md-3">
                			<button id="poConfirm" type="submit" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i> 内容確認</button>
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
                <button id = "poConfirm" type="submit" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i> 内容確認</button>
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
						<div class="col col-md-4">　</div>
							<div class="col col-md-4"><button id="entryButton" type="button" class="btn btn-primary btn-block" onclick="return entryCheck();"><i class="fa fa-check-circle"></i> 確定</button></div>
						<div class="col col-md-4">　</div>
					</div>
				</div>
            </div>
            
            </div>
            </div>
            </div>
            
            </c:if>
            
            <!-- JACKET -->
            <input type="hidden" id="corJkBody_div_Size"  name="adjustJacketStandardInfo.corJkBodySize"   value="" />
            <input type="hidden" id="corJkBody_div_Gross" name="adjustJacketStandardInfo.corJkBodyGross"  value="" />
            <input type="hidden" id="corJkWaist_div_Size"  name="adjustJacketStandardInfo.corJkWaistSize"   value="" />
            <input type="hidden" id="corJkWaist_div_Gross" name="adjustJacketStandardInfo.corJkWaistGross"  value="" />
			<input type="hidden" id="corJkRightsleeve_div_Size"  name="adjustJacketStandardInfo.corJkRightsleeveSize"   value="" />
            <input type="hidden" id="corJkRightsleeve_div_Gross" name="adjustJacketStandardInfo.corJkRightsleeveGross"  value="" />
			<input type="hidden" id="corJkLeftsleeve_div_Size"  name="adjustJacketStandardInfo.corJkLeftsleeveSize"   value="" />
            <input type="hidden" id="corJkLeftsleeve_div_Gross" name="adjustJacketStandardInfo.corJkLeftsleeveGross"  value="" />
            <!-- PANTS1 -->
            <input type="hidden" id="corPtWaist_div_Size"  name="adjustPantsStandardInfo.corPtWaistSize"  value="" />
            <input type="hidden" id="corPtWaist_div_Gross" name="adjustPantsStandardInfo.corPtWaistGross"  value="" />
            
            <input type="hidden" id="corPtThigh_div_Size"  name="adjustPantsStandardInfo.corPtThighSize"  value="" />
            <input type="hidden" id="corPtThigh_div_Gross" name="adjustPantsStandardInfo.corPtThighGross"  value="" />
            
            <input type="hidden" id="corPtHemwidth_div_Size" name="adjustPantsStandardInfo.corPtHemwidthSize"  value="" />
            <input type="hidden" id="corPtHemwidth_div_Gross" name="adjustPantsStandardInfo.corPtHemwidthGross"  value="" />
            
            <input type="hidden" id="corPtRightinseam_div_Size"  name="adjustPantsStandardInfo.corPtRightinseamSize"  value="" />
            <input type="hidden" id="corPtRightinseamGross" name="adjustPantsStandardInfo.corPtRightinseamGross"  value="" />
            
            
            <input type="hidden" id="corPtLeftinseam_div_Size" name="adjustPantsStandardInfo.corPtLeftinseamSize"  value="" />
            <input type="hidden" id="corPtLeftinseamGross" name="adjustPantsStandardInfo.corPtLeftinseamGross"  value="" />
            
            <!-- PANTS2 -->
			<input type="hidden" id="corPt2Waist_div_Size"  name="adjustPants2StandardInfo.corPt2WaistSize"  value="" />
            <input type="hidden" id="corPt2Waist_div_Gross" name="adjustPants2StandardInfo.corPt2WaistGross"  value="" />
            
            <input type="hidden" id="corPt2Thigh_div_Size"  name="adjustPants2StandardInfo.corPt2ThighSize"  value="" />
            <input type="hidden" id="corPt2Thigh_div_Gross" name="adjustPants2StandardInfo.corPt2ThighGross"  value="" />
            
            <input type="hidden" id="corPt2Hemwidth_div_Size" name="adjustPants2StandardInfo.corPt2HemwidthSize"  value="" />
            <input type="hidden" id="corPt2Hemwidth_div_Gross" name="adjustPants2StandardInfo.corPt2HemwidthGross"  value="" />
            
            <input type="hidden" id="corPt2Rightinseam_div_Size"  name="adjustPants2StandardInfo.corPt2RightinseamSize"  value="" />
            <input type="hidden" id="corPt2RightinseamGross" name="adjustPants2StandardInfo.corPt2RightinseamGross"  value="" />
            
            
            <input type="hidden" id="corPt2Leftinseam_div_Size" name="adjustPants2StandardInfo.corPt2LeftinseamSize"  value="" />
            <input type="hidden" id="corPt2LeftinseamGross" name="adjustPants2StandardInfo.corPt2LeftinseamGross"  value="" />    
            
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
			<input type="hidden" id="orderPattern" name="orderPattern" value="PO">
			
			<input type="hidden" id="shopCode"  name="shopCode"   value="${sessionContent.belongCode}" />
			
			<input type="hidden" id="factoryCode"  name="productFactoryCd"   value="" />
			
			<input type="hidden" id="makerCode"  name="productMakerCode"   value="" />
			
			<input type="hidden" id="storeBrandCode"  name="storeBrandCode"   value="${sessionContent.storeBrandCode}" />
			
			<input type="hidden" id="storeNm"  name="storeNm"   value="${sessionContent.belongName}" />
			
			<input type="hidden" id="saveFlag"  name="saveFlag"   value="" />
			
			<input type="hidden" id="fabricFlag"  name="fabricFlag"   value="" />
			
			<input type="hidden" id="jkModelFlag"  name="jkModelFlag"   value="0" />
			<input type="hidden" id="glModelFlag"  name="glModelFlag"   value="0" />
			<input type="hidden" id="ptModelFlag"  name="ptModelFlag"   value="0" />
			<input type="hidden" id="pt2ModelFlag"  name="pt2ModelFlag"   value="0" />
			
			<!-- <input type="hidden" id="versionFlag"  name="versionFlag" value="" /> -->
			
			<!-- 理論在庫 -->　
			<input type="hidden" id="theoryFabricUsedMountId" name="theoryFabricUsedMount" value="">
			
			<c:if test="${order.tscStatus == 'T7'||order.tscStatus == 'T6'}">
			<!-- 再補正フラッグ -->
			<!-- JACKET -->
			<input type="hidden" id="corJkBodyRe_Flag"  name="adjustJacketStandardInfo.corJkBodylengthCorrectAgainFlag" value="1" />
			<input type="hidden" id="corJkWaistRe_Flag"  name="adjustJacketStandardInfo.corJkWaistCorrectAgainFlag" value="1" />
			<input type="hidden" id="corJkRightsleeveRe_Flag"  name="adjustJacketStandardInfo.corJkRightsleeveCorrectAgainFlag" value="1" />
			<input type="hidden" id="corJkLeftsleeveRe_Flag"  name="adjustJacketStandardInfo.corJkLeftsleeveCorrectAgainFlag" value="1" />
			
			<!-- PANTS -->
			<input type="hidden" id="corPtWaistRe_Flag"  name="adjustPantsStandardInfo.corPtWaistCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPtHipRe_Flag"  name="adjustPantsStandardInfo.corPtHipCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPtThighwidthRe_Flag"  name="adjustPantsStandardInfo.corPtThighwidthCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPtHemwidthRe_Flag"  name="adjustPantsStandardInfo.corPtHemwidthCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPtRightinseamRe_Flag"  name="adjustPantsStandardInfo.corPtRightinseamCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPtLeftinseamRe_Flag"  name="adjustPantsStandardInfo.corPtLeftinseamCorrectAgainFlag" value="1" />
			
			<!-- 2PANTS -->
			<input type="hidden" id="corPt2WaistRe_Flag"  name="adjustPants2StandardInfo.corPt2WaistCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPt2HipRe_Flag"  name="adjustPants2StandardInfo.corPt2HipCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPt2ThighwidthRe_Flag"  name="adjustPants2StandardInfo.corPt2ThighwidthCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPt2HemwidthRe_Flag"  name="adjustPants2StandardInfo.corPt2HemwidthCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPt2RightinseamRe_Flag"  name="adjustPants2StandardInfo.corPt2RightinseamCorrectAgainFlag" value="1" />
			<input type="hidden" id="corPt2LeftinseamRe_Flag"  name="adjustPants2StandardInfo.corPt2LeftinseamCorrectAgainFlag" value="1" />
			</c:if>
	</div>
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
<script src="${pageContext.request.contextPath}/resources/app/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.validate.unobtrusive.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/chosen.jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/bootstrap-datepicker.js"></script>
<script>
jQuery(document).bind("ajaxError", function(){
    // ajax失敗
	swal({
		text: "データが取得できません。時間をおいて改めて作業してください。",
		icon: "warning"
	}).then(function(val){
	});
});
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
/************************************************
 * ルールMAP
 ************************************************/
//各項目対応するのオプションコード
	/* option_code: 00001,option_name: フロント釦数
	option_code: 00002,option_name: ラペルデザイン
	option_code: 00005,option_name: 台場
	option_code: 00004,option_name: 裏仕様
	option_code: 00012,option_name: 腰ポケット
	option_code: 00013,option_name: チェンジポケット
	option_code: 00014,option_name: スランテッドポケット
	option_code: 00019,option_name: 袖口
	option_code: 00023,option_name: AMFステッチ
	option_code: 00037,option_name: ベント
	option_code: 00038,option_name: 胴裏素材
	option_code: 00040,option_name: 袖裏素材
	option_code: 00042,option_name: 釦素材
	option_code: 00001,option_name: 胸ポケット
	option_code: 00005,option_name: AMFステッチ
	option_code: 00017,option_name: 背裏地素材
	option_code: 00019,option_name: 内側裏地素材
	option_code: 00021,option_name: 釦素材
	option_code: 00001,option_name: タック
	option_code: 00006,option_name: アジャスター仕様
	option_code: 00017,option_name: 裾上げ
	option_code: 00018,option_name: ダブル幅
	option_code: 00019,option_name: AMFステッチ
	option_code: 00033,option_name: 釦素材
	option_code: 00036,option_name: エイト（滑り止め）
	option_code: 00041,option_name: シック大（股補強）
	option_code: 00037,option_name: 形状記憶
	option_code: 00038,option_name: 靴ずれ
	option_code: 00001,option_name: タック
	option_code: 00006,option_name: アジャスター仕様
	option_code: 00017,option_name: 裾上げ
	option_code: 00018,option_name: ダブル幅
	option_code: 00019,option_name: AMFステッチ
	option_code: 00033,option_name: 釦素材
	option_code: 00036,option_name: エイト（滑り止め）
	option_code: 00041,option_name: シック大（股補強）
	option_code: 00037,option_name: 形状記憶
	option_code: 00038,option_name: 靴ずれ
	option_code: 00038,option_name: 胴裏素材
	option_code: 00040,option_name: 袖裏素材
	option_code: 00042,option_name: 釦素材
	option_code: 00017,option_name: 背裏地素材
	option_code: 00019,option_name: 内側裏地素材
	option_code: 00021,option_name: 釦素材
	option_code: 00033,option_name: 釦素材 */
var selectIdList = {
		"op_tack":"00001",
		"op_hemUp":"00017",
		"oj_frontBtnCnt":"00001",
 		"op_doubleWide":"00018",
 		"op2_tack":	"00001",
 		"op2_hemUp":"00017",
 		"op2_doubleWide":"00018",
	 	"lapelDesign":"00002",
	 	"fort":"00005",
	 	"backSpec":"00004",
	 	"waistPkt":"00012",
	 	"changePkt":"00013",
	 	"slantedPkt":"00014",
	 	"cuffSpec":"00019",
	 	"stitch":"00023",
	 	"ventSpec":"00037",
	 	"op2_adjuster":"00006",
	 	"op2_stitch":"00019",
	 	"op2_eight":"00036",
	 	"op2_thick":"00041",
	 	"op2_shapeMemory":"00037",
	 	"op2_blister":"00038",
	 	"op_adjuster":"00006",
		"op_stitch":"00019",
		"op_eight":"00036",
		"op_thick":"00041",
		"op_shapeMemory":"00037",
		"op_blister":"00038",
		"og_stitch":"00005",
		"bodyBackMate":"00038",
		"cuffBackMate":"00040",
		"btnMate":"00042",
		"op_btnMate":"00033",
		"op2_btnMate":"00033",
		"og_backLiningMate":"00017",
		"og_insideLiningMate":"00019",
		"og_frontBtnMate":"00021",
		"threePiece":"00099",
		"sparePants":"00099",
		"og_breastPkt":"00001"
};

//各項目対応するのサブアイテムコード
var subList = {
		"op_tack":"03",
		"op_hemUp":"03",
		"oj_frontBtnCnt":"02",
		"op_doubleWide":"03",
		"op2_tack":"07",
		"op2_hemUp":"07",
		"op2_doubleWide":"07",
		"lapelDesign":"02",
	 	"fort":"02",
	 	"backSpec":"02",
	 	"waistPkt":"02",
	 	"changePkt":"02",
	 	"slantedPkt":"02",
	 	"cuffSpec":"02",
	 	"stitch":"02",
	 	"ventSpec":"02",
	 	"op2_adjuster":"07",
	 	"op2_stitch":"07",
	 	"op2_eight":"07",
	 	"op2_thick":"07",
	 	"op2_shapeMemory":"07",
	 	"op2_blister":"07",
	 	"op_adjuster":"03",
	 	"op_stitch":"03",
	 	"op_eight":"03",
	 	"op_thick":"03",
	 	"op_shapeMemory":"03",
	 	"op_blister":"03",
	 	"og_stitch":"04",
	 	"bodyBackMate":"02",
		"cuffBackMate":"02",
		"btnMate":"02",
		"op_btnMate":"03",
		"op2_btnMate":"07",
		"og_backLiningMate":"04",
		"og_insideLiningMate":"04",
		"og_frontBtnMate":"04",
		"threePiece":"04",
		"sparePants":"03",
		"og_breastPkt":"04"	
};


//JACKETデフォルト値リスト
var jacketDefaultList = {
  		   activeList : [{id:"jacketModel",dVal:"",type:"2"},
	  			{id:"oj_frontBtnCnt",dVal:"0000102",type:"2"},
	  			{id:"optionJacketStandardInfo.ojVentSpec",dVal:"0003702",type:"1"},
				{id:"optionJacketStandardInfo.ojFort",dVal:"0000504",type:"1"},
				{id:"optionJacketStandardInfo.ojGackSpec",dVal:"0000401",type:"1"},
				{id:"optionJacketStandardInfo.ojWaistPkt",dVal:"0001201",type:"1"},
				{id:"optionJacketStandardInfo.ojChangePkt",dVal:"0001301",type:"1"},
				{id:"optionJacketStandardInfo.ojSlantedPkt",dVal:"0001401",type:"1"},
				{id:"optionJacketStandardInfo.ojCuffSpec",dVal:"0001902",type:"1"},
				{id:"optionJacketStandardInfo.ojStitch",dVal:"0002302",type:"1"},
				{id:"bodyBackMate",dVal:"1000100",type:"2"},
				{id:"cuffBackMate",dVal:"2000100",type:"2"},
				{id:"btnMate",dVal:"3000800",type:"2"},
				{id:"productIs3Piece",dVal:"0009901",type:"1"}
			]
};
//PANTSデフォルト値リスト
var pantsDefaultList = {
		  activeList : [{id:"op_pantsModel",dVal:"",type:"2"},
			  			{id:"op_tack",dVal:"0000101",type:"2"},
						{id:"optionPantsStandardInfo.opAdjuster",dVal:"0000601",type:"1"},
						{id:"op_hemUp",dVal:"0001701",type:"2"},
						{id:"op_doubleWide",dVal:"4",type:"2"},
						{id:"op_btnMate",dVal:"3000800",type:"2"},
						{id:"optionPantsStandardInfo.opEight",dVal:"0003601",type:"1"},
						{id:"optionPantsStandardInfo.opThick",dVal:"0004101",type:"1"},
						{id:"optionPantsStandardInfo.opShapeMemory",dVal:"0003701",type:"1"},
						{id:"optionPantsStandardInfo.opBlister",dVal:"0003801",type:"1"},
						{id:"adjustPantsStandardInfo.corPtHemwidthType",dVal:"1",type:"1"},
						{id:"productSparePantsClass",dVal:"0009901",type:"1"}
					]
};
//2PANTSデフォルト値リスト
var pants2DefaultList = {
		  activeList : [{id:"op2_pantsModel",dVal:"",type:"2"},
			  			{id:"op2_tack",dVal:"0000101",type:"2"},
						{id:"optionPants2StandardInfo.op2Adjuster",dVal:"0000601",type:"1"},
						{id:"op2_hemUp",dVal:"0001701",type:"2"},
						{id:"op2_doubleWide",dVal:"4",type:"2"},
						{id:"op2_btnMate",dVal:"3000800",type:"2"},
						{id:"optionPants2StandardInfo.op2Eight",dVal:"0003601",type:"1"},
						{id:"optionPants2StandardInfo.op2Thick",dVal:"0004101",type:"1"},
						{id:"optionPants2StandardInfo.op2ShapeMemory",dVal:"0003701",type:"1"},
						{id:"optionPants2StandardInfo.op2Blister",dVal:"0003801",type:"1"},
						{id:"adjustPants2StandardInfo.corPt2HemwidthType",dVal:"1",type:"1"}
					]
};
//GILETデフォルト値リスト
var giletDefaultList = {
		  activeList : [{id:"giletModel",dVal:"",type:"2"},
			  			{id:"optionGiletStandardInfo.ogStitch",dVal:"0000503",type:"1"},
			  			{id:"optionGiletStandardInfo.ogBreastPkt",dVal:"",type:"3"},
						{id:"og_backLiningMate",dVal:"1000100",type:"2"},
						{id:"og_insideLiningMate",dVal:"1000100",type:"2"},
						{id:"og_frontBtnMate",dVal:"3000800",type:"2"}
					]
};		

//オーダー一覧からのJACKETデフォルト値リスト
var jacketDefaultOrderList = {
		  activeList : [{id:"productIs3Piece",dVal:"${order.productIs3piece}",type:"1"},
			  			{id:"jacketModel",dVal:"${order.jkModelCd}",type:"2"},
			  			{id:"oj_frontBtnCnt",dVal:"${order.jkFrtBtnCd}",type:"2"},
						{id:"optionJacketStandardInfo.ojLapelDesign",dVal:"${order.jkLapelDesignCd}",type:"1"},
						{id:"optionJacketStandardInfo.ojFort",dVal:"${order.jkDaibaCd}",type:"1"},
						{id:"optionJacketStandardInfo.ojGackSpec",dVal:"${order.jkInnerClothCd}",type:"1"},
						{id:"optionJacketStandardInfo.ojWaistPkt",dVal:"${order.jkWaistPktCd}",type:"1"},
						{id:"optionJacketStandardInfo.ojChangePkt",dVal:"${order.jkChgPktCd}",type:"1"},
						{id:"optionJacketStandardInfo.ojSlantedPkt",dVal:"${order.jkSlantedPktCd}",type:"1"},
						{id:"optionJacketStandardInfo.ojCuffSpec",dVal:"${order.jkCuffCd}",type:"1"},
						{id:"optionJacketStandardInfo.ojStitch",dVal:"${order.jkStitchTypeCd}",type:"1"},
						{id:"optionJacketStandardInfo.ojVentSpec",dVal:"${order.jkVentCd}",type:"1"},
						{id:"bodyBackMate",dVal:"${order.jkInnerBodyClothType}",type:"2"},
						{id:"cuffBackMate",dVal:"${order.jkInnerSleeveClothType}",type:"2"},
						{id:"btnMate",dVal:"${order.jkBtnMaterialType}",type:"2"},
					]
};
//オーダー一覧からのPANTSデフォルト値リスト
var pantsDefaultOrderList = {
		activeList : [
					{id:"productSparePantsClass",dVal:"${order.productSparePantsClass}",type:"1"},
					{id:"op_pantsModel",dVal:"${order.ptModelCd}",type:"2"},
					{id:"op_tack",dVal:"${order.ptTackCd}",type:"2"},
					{id:"optionPantsStandardInfo.opAdjuster",dVal:"${order.ptAdjusterCd}",type:"1"},
					{id:"op_hemUp",dVal:"${order.ptHemUpCd}",type:"2"},
					{id:"op_doubleWide",dVal:"${order.ptDblWidthCd}",type:"2"},
					{id:"op_btnMate",dVal:"${order.ptBtnMaterialType}",type:"2"},
					{id:"optionPantsStandardInfo.opEight",dVal:"${order.ptNonSlipCd}",type:"1"},
					{id:"optionPantsStandardInfo.opThick",dVal:"${order.ptChicSlipCd}",type:"1"},
					{id:"optionPantsStandardInfo.opShapeMemory",dVal:"${order.ptShapeMemoryCd}",type:"1"},
					{id:"optionPantsStandardInfo.opBlister",dVal:"${order.ptShoeSoreCd}",type:"1"},
					{id:"adjustPantsStandardInfo.corPtHemwidthType",dVal:"${order.corPtHemwidthType}",type:"1"}
				]
};

//オーダー一覧からの2PANTSデフォルト値リスト
var pants2DefaultOrderList = {
		activeList : [
					{id:"op2_pantsModel",dVal:"${order.pt2ModelCd}",type:"2"},
					{id:"op2_tack",dVal:"${order.pt2TackCd}",type:"2"},
					{id:"optionPants2StandardInfo.op2Adjuster",dVal:"${order.pt2AdjusterCd}",type:"1"},
					{id:"op2_hemUp",dVal:"${order.pt2HemUpCd}",type:"2"},
					{id:"op2_doubleWide",dVal:"${order.pt2DblWidthCd}",type:"2"},
					{id:"op2_btnMate",dVal:"${order.pt2BtnMaterialType}",type:"2"},
					{id:"optionPants2StandardInfo.op2Eight",dVal:"${order.pt2NonSlipCd}",type:"1"},
					{id:"optionPants2StandardInfo.op2Thick",dVal:"${order.pt2ChicSlipCd}",type:"1"},
					{id:"optionPants2StandardInfo.op2ShapeMemory",dVal:"${order.pt2ShapeMemoryCd}",type:"1"},
					{id:"optionPants2StandardInfo.op2Blister",dVal:"${order.pt2ShoeSoreCd}",type:"1"},
					{id:"adjustPants2StandardInfo.corPt2HemwidthType",dVal:"${order.corPt2HemwidthType}",type:"1"}
				]
};
//オーダー一覧からのGILETデフォルト値リスト
var giletDefaultOrderList = {
	   activeList : [
		   			{id:"giletModel",dVal:"${order.glModelCd}",type:"2"},
		   			{id:"optionGiletStandardInfo.ogBreastPkt",dVal:"${order.glBreastPktCd}",type:"1"},
		   			{id:"optionGiletStandardInfo.ogStitch",dVal:"${order.glAmfStitchCd}",type:"1"},
					{id:"og_backLiningMate",dVal:"${order.glBackClothType}",type:"2"},
					{id:"og_insideLiningMate",dVal:"${order.glInnnerClothType}",type:"2"},
					{id:"og_frontBtnMate",dVal:"${order.glFrtBtnType}",type:"2"}
				]
};




//からのJACKETデフォルト値リスト
var jacketDefaultOrderFormList = {
		  activeList : [
			  		{id:"productIs3Piece",dVal:"${orderForm.productIs3Piece}",type:"1"},
			  		{id:"jacketModel",dVal:"${orderForm.optionJacketStandardInfo.ojJacketModel}",type:"2"},
			  		{id:"oj_frontBtnCnt",dVal:"${orderForm.optionJacketStandardInfo.ojFrontBtnCnt}",type:"2"},
					{id:"optionJacketStandardInfo.ojLapelDesign",dVal:"${orderForm.optionJacketStandardInfo.ojLapelDesign}",type:"1"},
					{id:"optionJacketStandardInfo.ojFort",dVal:"${orderForm.optionJacketStandardInfo.ojFort}",type:"1"},
					{id:"optionJacketStandardInfo.ojGackSpec",dVal:"${orderForm.optionJacketStandardInfo.ojGackSpec}",type:"1"},
					{id:"optionJacketStandardInfo.ojWaistPkt",dVal:"${orderForm.optionJacketStandardInfo.ojWaistPkt}",type:"1"},
					{id:"optionJacketStandardInfo.ojChangePkt",dVal:"${orderForm.optionJacketStandardInfo.ojChangePkt}",type:"1"},
					{id:"optionJacketStandardInfo.ojSlantedPkt",dVal:"${orderForm.optionJacketStandardInfo.ojSlantedPkt}",type:"1"},
					{id:"optionJacketStandardInfo.ojCuffSpec",dVal:"${orderForm.optionJacketStandardInfo.ojCuffSpec}",type:"1"},
					{id:"optionJacketStandardInfo.ojStitch",dVal:"${orderForm.optionJacketStandardInfo.ojStitch}",type:"1"},
					{id:"optionJacketStandardInfo.ojVentSpec",dVal:"${orderForm.optionJacketStandardInfo.ojVentSpec}",type:"1"},
					{id:"bodyBackMate",dVal:"${orderForm.optionJacketStandardInfo.ojBodyBackMate}",type:"2"},
					{id:"cuffBackMate",dVal:"${orderForm.optionJacketStandardInfo.ojCuffBackMate}",type:"2"},
					{id:"btnMate",dVal:"${orderForm.optionJacketStandardInfo.ojBtnMate}",type:"2"}
				]
};
//オーダー一覧からのPANTSデフォルト値リスト
var pantsDefaultOrderFormList = {
		activeList : [
					{id:"productSparePantsClass",dVal:"${orderForm.productSparePantsClass}",type:"1"},
					{id:"op_pantsModel",dVal:"${orderForm.optionPantsStandardInfo.opPantsModel}",type:"2"},
					{id:"op_tack",dVal:"${orderForm.optionPantsStandardInfo.opTack}",type:"2"},
					{id:"optionPantsStandardInfo.opAdjuster",dVal:"${orderForm.optionPantsStandardInfo.opAdjuster}",type:"1"},
					{id:"op_hemUp",dVal:"${orderForm.optionPantsStandardInfo.opHemUp}",type:"2"},
					{id:"op_doubleWide",dVal:"${orderForm.optionPantsStandardInfo.opDoubleWide}",type:"2"},
					{id:"op_btnMate",dVal:"${orderForm.optionPantsStandardInfo.opButton}",type:"2"},
					{id:"optionPantsStandardInfo.opEight",dVal:"${orderForm.optionPantsStandardInfo.opEight}",type:"1"},
					{id:"optionPantsStandardInfo.opThick",dVal:"${orderForm.optionPantsStandardInfo.opThick}",type:"1"},
					{id:"optionPantsStandardInfo.opShapeMemory",dVal:"${orderForm.optionPantsStandardInfo.opShapeMemory}",type:"1"},
					{id:"optionPantsStandardInfo.opBlister",dVal:"${orderForm.optionPantsStandardInfo.opBlister}",type:"1"},
				]
};

//オーダー一覧からの2PANTSデフォルト値リスト
var pants2DefaultOrderFormList = {
		activeList : [
					{id:"op2_pantsModel",dVal:"${orderForm.optionPants2StandardInfo.op2PantsModel}",type:"2"},
					{id:"op2_tack",dVal:"${orderForm.optionPants2StandardInfo.op2Tack}",type:"2"},
					{id:"optionPants2StandardInfo.op2Adjuster",dVal:"${orderForm.optionPants2StandardInfo.op2Adjuster}",type:"1"},
					{id:"op2_hemUp",dVal:"${orderForm.optionPants2StandardInfo.op2HemUp}",type:"2"},
					{id:"op2_doubleWide",dVal:"${orderForm.optionPants2StandardInfo.op2DoubleWide}",type:"2"},
					{id:"op2_btnMate",dVal:"${orderForm.optionPants2StandardInfo.op2Button}",type:"2"},
					{id:"optionPants2StandardInfo.op2Eight",dVal:"${orderForm.optionPants2StandardInfo.op2Eight}",type:"1"},
					{id:"optionPants2StandardInfo.op2Thick",dVal:"${orderForm.optionPants2StandardInfo.op2Thick}",type:"1"},
					{id:"optionPants2StandardInfo.op2ShapeMemory",dVal:"${orderForm.optionPants2StandardInfo.op2ShapeMemory}",type:"1"},
					{id:"optionPants2StandardInfo.op2Blister",dVal:"${orderForm.optionPants2StandardInfo.op2Blister}",type:"1"},
				]
};
//オーダー一覧からのGILETデフォルト値リスト
var giletDefaultOrderFormList = {
	   activeList : [
		   			{id:"giletModel",dVal:"${orderForm.optionGiletStandardInfo.ogGiletModel}",type:"2"},
		   			{id:"optionGiletStandardInfo.ogBreastPkt",dVal:"${orderForm.optionGiletStandardInfo.ogBreastPkt}",type:"1"},
		   			{id:"optionGiletStandardInfo.ogStitch",dVal:"${orderForm.optionGiletStandardInfo.ogStitch}",type:"1"},
					{id:"og_backLiningMate",dVal:"${orderForm.optionGiletStandardInfo.ogBackLiningMate}",type:"2"},
					{id:"og_insideLiningMate",dVal:"${orderForm.optionGiletStandardInfo.ogInsideLiningMate}",type:"2"},
					{id:"og_frontBtnMate",dVal:"${orderForm.optionGiletStandardInfo.ogFrontBtnMate}",type:"2"}
				]
};

//オプション金額を表示するリスト
var jkPriceList = [
	{id:"oj_frontBtnCnt",type:"2"},
	{id:"lapelDesign",idVal:"optionJacketStandardInfo.ojLapelDesign",type:"1"},
	{id:"fort",idVal:"optionJacketStandardInfo.ojFort",type:"1"},
	{id:"backSpec",idVal:"optionJacketStandardInfo.ojGackSpec",type:"1"},
	{id:"waistPkt",idVal:"optionJacketStandardInfo.ojWaistPkt",type:"1"},
	{id:"changePkt",idVal:"optionJacketStandardInfo.ojChangePkt",type:"1"},
	{id:"slantedPkt",idVal:"optionJacketStandardInfo.ojSlantedPkt",type:"1"},
	{id:"cuffSpec",idVal:"optionJacketStandardInfo.ojCuffSpec",type:"1"},
	{id:"stitch",idVal:"optionJacketStandardInfo.ojStitch",type:"1"},
	{id:"ventSpec",idVal:"optionJacketStandardInfo.ojVentSpec",type:"1"},
	{id:"bodyBackMate",type:"2"},
	{id:"bodyBackMateStkNo",type:"2"},
	{id:"cuffBackMate",type:"2"},
	{id:"cuffBackMateStkNo",type:"2"},
	{id:"btnMate",type:"2"},
	{id:"btnMateStkNo",type:"2"},
];
var ptPriceList = [
	{id:"op_pantsModel",type:"2"},
	{id:"op_tack",type:"2"},
	{id:"op_adjuster",idVal:"optionPantsStandardInfo.opAdjuster",type:"1"},
	{id:"op_hemUp",type:"2"},
	{id:"op_doubleWide",type:"2"},
	{id:"op_btnMate",type:"2"},
	{id:"op_btnMateStkNo",type:"2"},
	{id:"op_eight",idVal:"optionPantsStandardInfo.opEight",type:"1"},
	{id:"op_thick",idVal:"optionPantsStandardInfo.opThick",type:"1"},
	{id:"op_shapeMemory",idVal:"optionPantsStandardInfo.opShapeMemory",type:"1"},
	{id:"op_blister",idVal:"optionPantsStandardInfo.opBlister",type:"1"},
];

var pt2PriceList = [
	{id:"op2_pantsModel",type:"2"},
	{id:"op2_tack",type:"2"},
	{id:"op2_adjuster",idVal:"optionPants2StandardInfo.op2Adjuster",type:"1"},
	{id:"op2_hemUp",type:"2"},
	{id:"op2_doubleWide",type:"2"},
	{id:"op2_btnMate",type:"2"},
	{id:"op2_btnMateStkNo",type:"2"},
	{id:"op2_eight",idVal:"optionPants2StandardInfo.op2Eight",type:"1"},
	{id:"op2_thick",idVal:"optionPants2StandardInfo.op2Thick",type:"1"},
	{id:"op2_shapeMemory",idVal:"optionPants2StandardInfo.op2ShapeMemory",type:"1"},
	{id:"op2_blister",idVal:"optionPants2StandardInfo.op2Blister",type:"1"},
];

var glPriceList = [
	{id:"giletModel",type:"2"},
	{id:"og_stitch",idVal:"optionGiletStandardInfo.ogStitch",type:"1"},
	{id:"og_breastPkt",idVal:"optionGiletStandardInfo.ogBreastPkt",type:"1"},
	{id:"og_backLiningMate",type:"2"},
	{id:"og_backLiningMateStkNo",type:"2"},
	{id:"og_insideLiningMate",type:"2"},
	{id:"og_insideLiningMateStkNo",type:"2"},
	{id:"og_frontBtnMate",type:"2"},
	{id:"og_frontBtnMateStkNo",type:"2"}
];

//01:着丈修正、02：ウエスト修正、03：袖丈右修正、04：袖丈左修正
var jkAdjustList = [
	{type:"01",id:"corJkBody_div"},
	{type:"02",id:"corJkWaist_div"},
	{type:"03",id:"corJkRightsleeve_div"},
	{type:"04",id:"corJkLeftsleeve_div"}
];
//07：ワタリ幅修正、08：裾幅
var ptAdjustList = [
	{type:"09",id:"corPtRightinseam_div"},
	{type:"10",id:"corPtLeftinseam_div"},
	{type:"06",id:"corPtWaist_div"},
	{type:"08",id:"corPtHemwidth_div"}
];
//06：ウエスト修正
var ptTackList = [
	{type:"07",id:"corPtThigh_div"}
	
];
//07：ワタリ幅修正、08：裾幅
var pt2AdjustList = [
	{type:"06",id:"corPt2Waist_div"},
	{type:"08",id:"corPt2Hemwidth_div"},
	{type:"09",id:"corPt2Rightinseam_div"},
	{type:"10",id:"corPt2Leftinseam_div"}
];
//06：ウエスト修正
var pt2TackList = [
	{type:"07",id:"corPt2Thigh_div"}
];

/************************************************
 * 読み込み時イベント設定
 ************************************************/
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "PO";
jQuery('#custDeliverDate').datepicker({
    format: 'yyyy/mm/dd',
    clearBtn: true,
    language: 'ja',
    todayBtn: "linked",
    orientation: 'buttom auto',
    todayHighlight: true,
    autoclose: true
});

jQuery(document).ready(function() {

	var orderFlag = "${orderFlag}";
	var ofOrderFlag = "${orderForm.orderFlag}";
	
	if(orderFlag=="orderLink"&&ofOrderFlag==""){
		
		//状態区分をクリア
		var status = "${order.tscStatus}"
		jQuery("#statusInput").val(status);		
		//注文ID
		var orderId = "${order.orderId}";
		jQuery("#orderId").val(orderId);
		//会員番号
		var custCd = "${order.custCd}";
		jQuery("#custCd").val(custCd)
		
		//バージョン
		var version = "${order.version}";
		jQuery("#version").val(version);
		
		//スタッフ
		var custStaff = "${f:js(order.custStaff)}";
		jQuery("#custStaff").val(custStaff);
		
		//区分
		var custType = "${order.custType}";
		jQuery("#custType").val(custType);
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
		//出荷先
		var destination = "${order.custShippingDestination}";
		jQuery("#destination").val(destination);
		
		//他店舗のとき　店舗を検索した
		initCustomer();
		
		//出荷先_他店舗コード
		var shopNameCode = "${order.custShippingDestnationOtherstore}";
		jQuery("#shopName").val(shopNameCode);
		jQuery("#shopName").trigger("chosen:updated");
		
		//お客様備考
		var custRemark = "${f:js(order.custRemark)}";
		jQuery("#custRemark").val(custRemark);
		
		//メジャーリングを設定
		measuring();

		//商品
		//ITEM
		var item = "${order.productItem}";
		jQuery("#item").val(item);
		
		getModelByItem();

		getAdjustByItem();
		
		//３Piece
		var threePiece = "${order.productIs3piece}" ;
		jQuery("input[name='productIs3Piece'][value='" + threePiece + "']").prop("checked", true);
		//スペアパンツ
		var productSparePantsClass = "${order.productSparePantsClass}";
		jQuery("input[name='productSparePantsClass'][value='" + productSparePantsClass + "']").prop("checked", true);

		//組成表示
		compositionExpress();
		
		//生地品番
		var productFabricNo = "${order.productFabricNo}";
		jQuery("#productFabricNo").val(productFabricNo);

		if(isNotEmpty(productFabricNo)){
			//生地によって、商品を表示
			fabricView(item,productFabricNo);
		}
		
		var yieldNum = "${order.theoryFabricUsedMount}";
		jQuery("#theoryFabricUsedMountId").val(yieldNum);
		
		//ブランドネーム
		var productBrandType = "${order.productBrandType}";
		jQuery("input[name='productBrandType'][value='" + productBrandType + "']").prop("checked", true);
		//生地ネーム
		var productFabricNmNecessity = "${order.productFabricNmNecessity}";
		jQuery("input[name='productFabricNmNecessity'][value='" + productFabricNmNecessity + "']").prop("checked", true);
		//刺繍入れ
		var productEmbroideryNecessity = "${order.productEmbroideryNecessity}";
		jQuery("input[name='productEmbroideryNecessity'][value='" + productEmbroideryNecessity + "']").prop("checked", true);
		
		//刺繍ネーム
		var embroideryName = "${f:js(order.productEmbroideryNm)}";
		jQuery("#embroideryName").val(embroideryName);
		
		//刺繍書体
		var productEmbroideryFont = "${order.productEmbroideryFont}";
		jQuery("input[name='productEmbroideryFont'][value='" + productEmbroideryFont + "']").prop("checked", true);
		//刺繍糸色
		var embroideryColor = "${order.productEmbroideryThreadColor}";
		jQuery("input[name='productEmbroideryThreadColor'][value='" + embroideryColor + "']").prop("checked", true);
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

		//オプションのデフォルト値を設定
		if(item == "01"){
			var i = null;
			for (i of jacketDefaultOrderList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}
				}else if(i.type == "1"){
					if(i.dVal!=""){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}

			for (i of pantsDefaultOrderList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}else{
						if(i.id == 'op_doubleWide'){
							jQuery("#"+i.id+" option[value='4']").prop("selected", true);
						}
					}
				}else if(i.type == "1"){
					if(i.dVal!=""){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}

			if(threePiece == "0009902"){
				for (i of giletDefaultOrderList.activeList) {
					if(i.type == "2"){
						if(i.dVal!=""){
							jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
						}
					}else if(i.type == "1"){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}
			if(productSparePantsClass == "0009902"){
				for (i of pants2DefaultOrderList.activeList) {
					if(i.type == "2"){
						if(i.dVal!=""){
							jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
						}else{
							if(i.id == 'op2_doubleWide'){
								jQuery("#"+i.id+" option[value='4']").prop("selected", true);
							}
						}
					}else if(i.type == "1"){
						if(i.dVal!=""){
							jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
						}
					}
				}
			}
		}else if(item == "02"){
			for (i of jacketDefaultOrderList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}
				}else if(i.type == "1"){
					if(i.dVal!=""){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}
		}else if(item == "03"){
			for (i of pantsDefaultOrderList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}else{
						if(i.id == 'op_doubleWide'){
							jQuery("#"+i.id+" option[value='4']").prop("selected", true);
						}
					}
				}else if(i.type == "1"){
					if(i.dVal!=""){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}
		}else if(item == "04"){
			for (i of giletDefaultOrderList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}
				}else if(i.type == "1"){
					jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
				}
			}
		}
		
		//品番値を設定
		mateInit();
		
		//品番のデフォルト値を設定
		var ptBtnMaterialCd = "${order.ptBtnMaterialCd}";
		if(ptBtnMaterialCd!=""){
			jQuery("#op_btnMateStkNo option[value='"+ptBtnMaterialCd+"']").attr("selected", true);
		}
		var pt2BtnMaterialCd = "${order.pt2BtnMaterialCd}";
		if(pt2BtnMaterialCd!=""){
			jQuery("#op2_btnMateStkNo option[value='"+pt2BtnMaterialCd+"']").attr("selected", true);
		}


		var jkInnerBodyClothCd = "${order.jkInnerBodyClothCd}";
		if(jkInnerBodyClothCd!=""){
			jQuery("#bodyBackMateStkNo option[value='"+jkInnerBodyClothCd+"']").attr("selected", true);
		}
		var jkInnerSleeveClothCd = "${order.jkInnerSleeveClothCd}";
		if(jkInnerSleeveClothCd!=""){
			jQuery("#cuffBackMateStkNo option[value='"+jkInnerSleeveClothCd+"']").attr("selected", true);
		}
		var jkBtnMaterialCd = "${order.jkBtnMaterialCd}";
		if(jkBtnMaterialCd!=""){
			jQuery("#btnMateStkNo option[value='"+jkBtnMaterialCd+"']").attr("selected", true);
		}
		

		var glBackClothCd = "${order.glBackClothCd}";
		if(glBackClothCd!=""){
			jQuery("#og_backLiningMateStkNo option[value='"+glBackClothCd+"']").attr("selected", true);
		}
		var glInnnerClothCd = "${order.glInnnerClothCd}";
		if(glInnnerClothCd!=""){
			jQuery("#og_insideLiningMateStkNo option[value='"+glInnnerClothCd+"']").attr("selected", true);
		}
		var glFrtBtnCd = "${order.glFrtBtnCd}";
		if(glFrtBtnCd!=""){
			jQuery("#og_frontBtnMateStkNo option[value='"+glFrtBtnCd+"']").attr("selected", true);
		}

		getFigureAndNumberByItem();
		
		//補正の値を設定
		adjustInit();

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
	//オーダー一覧から流用をクリックとき	
	}else if(orderFlag == "orderDivert"&&ofOrderFlag == ""){
		//注文ID
		//var orderId = "${order.orderId}";
		
		jQuery("#orderId").val("");
		//会員番号
		var custCd = "${order.custCd}";
		jQuery("#custCd").val(custCd)
		
		//スタッフ
		var custStaff = "${f:js(order.custStaff)}";
		jQuery("#custStaff").val(custStaff);
		
		//区分
		var custType = "${order.custType}";
		jQuery("#custType").val(custType);
		//出荷先
		var destination = "${order.custShippingDestination}";
		jQuery("#destination").val(destination);

		//他店舗のとき　店舗を検索した
		initCustomer();
		
		//出荷先_他店舗コード
		var shopNameCode = "${order.custShippingDestnationOtherstore}";
		jQuery("#shopName").val(shopNameCode);
		jQuery("#shopName").trigger("chosen:updated");
		
		//お客様備考
		var custRemark = "${f:js(order.custRemark)}";
		jQuery("#custRemark").val(custRemark);
		
		//メジャーリング
		measuring();

		//商品
		//ITEM
		var item = "${order.productItem}";
		jQuery("#item").val(item);
		
		getModelByItem();

		getAdjustByItem();

		//３Piece
		var threePiece = "${order.productIs3piece}" ;
		jQuery("input[name='productIs3Piece'][value='" + threePiece + "']").prop("checked", true);
		//スペアパンツ
		var productSparePantsClass = "${order.productSparePantsClass}";
		jQuery("input[name='productSparePantsClass'][value='" + productSparePantsClass + "']").prop("checked", true);
		//組成表示
		compositionExpress();
		
		//ブランドネーム
		var productBrandType = "${order.productBrandType}";
		jQuery("input[name='productBrandType'][value='" + productBrandType + "']").prop("checked", true);
		//刺繍入れ
		var productEmbroideryNecessity = "${order.productEmbroideryNecessity}";
		jQuery("input[name='productEmbroideryNecessity'][value='" + productEmbroideryNecessity + "']").prop("checked", true);
		
		//刺繍ネーム
		var embroideryName = "${f:js(order.productEmbroideryNm)}";
		jQuery("#embroideryName").val(embroideryName);
		
		//刺繍書体
		var productEmbroideryFont = "${order.productEmbroideryFont}";
		jQuery("input[name='productEmbroideryFont'][value='" + productEmbroideryFont + "']").prop("checked", true);	
		//刺繍糸色
		var embroideryColor = "${order.productEmbroideryThreadColor}";
		jQuery("input[name='productEmbroideryThreadColor'][value='" + embroideryColor + "']").prop("checked", true);
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

		
		//オプションのデフォルト値を設定
		if(item == "01"){
			var i = null;
			for (i of jacketDefaultOrderList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}
				}else if(i.type == "1"){
					if(i.dVal!=""){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}

			for (i of pantsDefaultOrderList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}else{
						if(i.id == 'op_doubleWide'){
							jQuery("#"+i.id+" option[value='4']").prop("selected", true);
						}
					}
				}else if(i.type == "1"){
					if(i.dVal!=""){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}

			if(threePiece == "0009902"){
				for (i of giletDefaultOrderList.activeList) {
					if(i.type == "2"){
						if(i.dVal!=""){
							jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
						}
					}else if(i.type == "1"){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}
			if(productSparePantsClass == "0009902"){
				for (i of pants2DefaultOrderList.activeList) {
					if(i.type == "2"){
						if(i.dVal!=""){
							jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
						}else{
							if(i.id == 'op2_doubleWide'){
								jQuery("#"+i.id+" option[value='4']").prop("selected", true);
							}
						}
					}else if(i.type == "1"){
						if(i.dVal!=""){
							jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
						}
					}
				}
			}
		}else if(item == "02"){
			for (i of jacketDefaultOrderList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}
				}else if(i.type == "1"){
					if(i.dVal!=""){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}
		}else if(item == "03"){
			for (i of pantsDefaultOrderList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}else{
						if(i.id == 'op_doubleWide'){
							jQuery("#"+i.id+" option[value='4']").prop("selected", true);
						}
					}
				}else if(i.type == "1"){
					if(i.dVal!=""){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}
		}else if(item == "04"){
			for (i of giletDefaultOrderList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}
				}else if(i.type == "1"){
					jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
				}
			}
		}
		
		//品番値を設定
		mateInit();
		
		//品番のデフォルト値を設定
		var ptBtnMaterialCd = "${order.ptBtnMaterialCd}";
		if(ptBtnMaterialCd!=""){
			jQuery("#op_btnMateStkNo option[value='"+ptBtnMaterialCd+"']").attr("selected", true);
		}
		var pt2BtnMaterialCd = "${order.pt2BtnMaterialCd}";
		if(pt2BtnMaterialCd!=""){
			jQuery("#op2_btnMateStkNo option[value='"+pt2BtnMaterialCd+"']").attr("selected", true);
		}


		var jkInnerBodyClothCd = "${order.jkInnerBodyClothCd}";
		if(jkInnerBodyClothCd!=""){
			jQuery("#bodyBackMateStkNo option[value='"+jkInnerBodyClothCd+"']").attr("selected", true);
		}
		var jkInnerSleeveClothCd = "${order.jkInnerSleeveClothCd}";
		if(jkInnerSleeveClothCd!=""){
			jQuery("#cuffBackMateStkNo option[value='"+jkInnerSleeveClothCd+"']").attr("selected", true);
		}
		var jkBtnMaterialCd = "${order.jkBtnMaterialCd}";
		if(jkBtnMaterialCd!=""){
			jQuery("#btnMateStkNo option[value='"+jkBtnMaterialCd+"']").attr("selected", true);
		}
		

		var glBackClothCd = "${order.glBackClothCd}";
		if(glBackClothCd!=""){
			jQuery("#og_backLiningMateStkNo option[value='"+glBackClothCd+"']").attr("selected", true);
		}
		var glInnnerClothCd = "${order.glInnnerClothCd}";
		if(glInnnerClothCd!=""){
			jQuery("#og_insideLiningMateStkNo option[value='"+glInnnerClothCd+"']").attr("selected", true);
		}
		var glFrtBtnCd = "${order.glFrtBtnCd}";
		if(glFrtBtnCd!=""){
			jQuery("#og_frontBtnMateStkNo option[value='"+glFrtBtnCd+"']").attr("selected", true);
		}
		
		getFigureAndNumberByItem();
		
		//補正の値を設定
		adjustInit();


	}else if(orderFlag == "orderDetail"&&ofOrderFlag == ""){
		//注文ID
		var ordrId = "${order.orderId}";
		jQuery("#orderId").val(ordrId);
		//会員番号
		var custCd = "${order.custCd}";
		jQuery("#custCd").val(custCd)
		//スタッフ
		var custStaff = "${f:js(order.custStaff)}";
		jQuery("#custStaff").val(custStaff);
		
		//区分
		var custType = "${order.custType}";
		jQuery("#custType").val(custType);

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

		//バージョン
		var version = "${order.version}";
		jQuery("#version").val("version");
		
		//出荷先
		var destination = "${order.custShippingDestination}";
		jQuery("#destination").val(destination);

		//他店舗のとき　店舗を検索した
		initCustomer();
		
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
		jQuery("#corStoreCorrectionMemo").val(corStoreCorrectionMemoAgain);
		

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
		

		//日付フォーマット
		function dateFormat(time){
			var date = new Date(custDeliverDate);
			var year = date.getFullYear();  
			var month = date.getMonth() + 1
			if(month<=9){
				month = "0" + month;
			}
			var day = date.getDate();
			if(day<=9){
				day = "0" + day;
			}
			return year+"/"+month+"/"+day;
		}
	}else if(ofOrderFlag=="orderPo"&&orderFlag == ""){
		//var orderId = "${orderForm.customerMessageInfo.orderId }";
		jQuery("#orderId").val("");

		jQuery("#item").val("01");
		
		//他店舗のとき　店舗を検索した
		initCustomer();

		//オプションコードの初期値を設定
		defaultOptionInit();

		//品番値を設定
		mateInit();

		//組成表示
		compositionExpress();

		getAdjustByItem();

		getModelByItem();

		
	}else if(ofOrderFlag=="orderBack"&&orderFlag==""){
		//注文ID
		var orderId = "${orderForm.customerMessageInfo.orderId}";
		jQuery("#orderId").val(orderId);
		//会員番号
		var custCd = "${orderForm.customerMessageInfo.custCd}";
		jQuery("#custCd").val(custCd)
		
		var status = "${orderForm.status}";
		jQuery("#statusInput").val(status);

		//バージョン
		var version = "${orderForm.version}";
		jQuery("#version").val(version);

		var yieldNum = "${orderForm.theoryFabricUsedMount}";
		jQuery("#theoryFabricUsedMountId").val(yieldNum);
		
		//スタッフ
		var custStaff = "${f:js(orderForm.customerMessageInfo.custStaff)}";
		jQuery("#custStaff").val(custStaff);
		
		//区分
		var custType = "${orderForm.customerMessageInfo.custType}";
		jQuery("#custType").val(custType);
		
		//名簿納期
		var custDeliverDate = "${orderForm.customerMessageInfo.custDeliverDate}";
		if(isNotEmpty(custDeliverDate)){
			custDeliverDate = dateFormat(custDeliverDate);
			jQuery("#custDeliverDate").datepicker("update", custDeliverDate);
			//jQuery("#custDeliverDate").val(custDeliverDate)
		}
		//お渡し日
		var custShopDeliveryDate = "${orderForm.customerMessageInfo.custShopDeliveryDate}";
		if(isNotEmpty(custShopDeliveryDate)){
			custShopDeliveryDate = dateFormat(custShopDeliveryDate);
			jQuery("#custShopDeliveryDate").val(custShopDeliveryDate);
		}
		//出荷先
		var destination = "${orderForm.customerMessageInfo.custShippingDestination}";
		jQuery("#destination").val(destination);

		//他店舗のとき　店舗を検索した
		initCustomer();
		
		//出荷先_他店舗コード
		var shopNameCode = "${orderForm.customerMessageInfo.custShippingDestnationOtherstore}";
		jQuery("#shopName").val(shopNameCode);
		jQuery("#shopName").trigger("chosen:updated");
		
		//お客様備考
		var custRemark = "${f:js(orderForm.customerMessageInfo.custRemark)}";
		jQuery("#custRemark").val(custRemark);
		
		//メジャーリングを設定
		orderFormMeasuring();

		//商品
		//ITEM
		var item = "${orderForm.productItem}";
		jQuery("#item").val(item);

		getModelByItem();

		getAdjustByItem();
		
		//３Piece
		var threePiece = "${orderForm.productIs3Piece}" ;
		jQuery("input[name='productIs3Piece'][value='" + threePiece + "']").prop("checked", true);
		//スペアパンツ
		var productSparePantsClass = "${orderForm.productSparePantsClass}";
		jQuery("input[name='productSparePantsClass'][value='" + productSparePantsClass + "']").prop("checked", true);

		//組成表示
		compositionExpress();
		//生地品番
		var productFabricNo = "${orderForm.productFabricNo}";
		jQuery("#productFabricNo").val(productFabricNo);

		//生地によって、商品を表示
		fabricView(item,productFabricNo);
		
		//ブランドネーム
		var productBrandType = "${orderForm.productBrandType}";
		jQuery("input[name='productBrandType'][value='" + productBrandType + "']").prop("checked", true);
		//生地ネーム
		var productFabricNmNecessity = "${orderForm.productFabricNmNecessity}";
		jQuery("input[name='productFabricNmNecessity'][value='" + productFabricNmNecessity + "']").prop("checked", true);
		//刺繍入れ
		var productEmbroideryNecessity = "${orderForm.productEmbroideryNecessity}";
		jQuery("input[name='productEmbroideryNecessity'][value='" + productEmbroideryNecessity + "']").prop("checked", true);
		//刺繍ネーム
		var embroideryName = "${orderForm.productEmbroideryNm}";
		jQuery("#embroideryName").val(embroideryName);
		//刺繍書体
		var productEmbroideryFont = "${orderForm.productEmbroideryFont}";
		jQuery("input[name='productEmbroideryFont'][value='" + productEmbroideryFont + "']").prop("checked", true);
		//刺繍糸色
		var embroideryColor = "${orderForm.productEmbroideryThreadColor}";
		jQuery("input[name='productEmbroideryThreadColor'][value='" + embroideryColor + "']").prop("checked", true);
		//組成表示　胴裏地
		var bodyText = "${orderForm.productComposBodyLiner}";
		jQuery("#productComposBodyLiner").val(bodyText);
		if(bodyText.indexOf(" ")!=-1){
			bodyText = bodyText.split(" ");
			jQuery("#compos_body_liner_p").html(bodyText[0]).append("<br>").append(bodyText[1]);
		}else{
			jQuery("#compos_body_liner_p").html(bodyText);
		}
		//組成表示　袖裏地
		var sleeveText = "${orderForm.productComposSleeveLiner}";
		jQuery("#compos_sleeve_liner_p").html(sleeveText);
		jQuery("#productComposSleeveLiner").val(sleeveText);

	
		
		//オプションのデフォルト値を設定
		if(item == "01"){
			var i = null;
			for (i of jacketDefaultOrderFormList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}
				}else if(i.type == "1"){
					if(i.dVal!=""){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}

			for (i of pantsDefaultOrderFormList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}else{
						if(i.id == 'op_doubleWide'){
							jQuery("#"+i.id+" option[value='4']").prop("selected", true);
						}
					}
				}else if(i.type == "1"){
					if(i.dVal!=""){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}

			if(threePiece == "0009902"){
				for (i of giletDefaultOrderFormList.activeList) {
					if(i.type == "2"){
						if(i.dVal!=""){
							jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
						}
					}else if(i.type == "1"){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}
			if(productSparePantsClass == "0009902"){
				for (i of pants2DefaultOrderFormList.activeList) {
					if(i.type == "2"){
						if(i.dVal!=""){
							jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
						}else{
							if(i.id == 'op2_doubleWide'){
								jQuery("#"+i.id+" option[value='4']").prop("selected", true);
							}
						}
					}else if(i.type == "1"){
						if(i.dVal!=""){
							jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
						}
					}
				}
			}
		}else if(item == "02"){
			var i = null;
			for (i of jacketDefaultOrderFormList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}
				}else if(i.type == "1"){
					if(i.dVal!=""){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}
		}else if(item == "03"){
			for (i of pantsDefaultOrderFormList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}else{
						if(i.id == 'op_doubleWide'){
							jQuery("#"+i.id+" option[value='4']").prop("selected", true);
						}
					}
				}else if(i.type == "1"){
					if(i.dVal!=""){
						jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
					}
				}
			}
		}else if(item == "04"){
			for (i of giletDefaultOrderFormList.activeList) {
				if(i.type == "2"){
					if(i.dVal!=""){
						jQuery("#"+i.id+" option[value='"+i.dVal+"']").prop("selected", true);
					}
				}else if(i.type == "1"){
					jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
				}
			}
		}

		//品番値を設定
		mateInit();

		//品番のデフォルト値を設定
		var ptBtnMaterialCd = "${orderForm.optionPantsStandardInfo.opBtnMateStkNo}";
		if(ptBtnMaterialCd!=""){
			jQuery("#op_btnMateStkNo option[value='"+ptBtnMaterialCd+"']").attr("selected", true);
		}
		var pt2BtnMaterialCd = "${orderForm.optionPants2StandardInfo.op2BtnMateStkNo}";
		if(pt2BtnMaterialCd!=""){
			jQuery("#op2_btnMateStkNo option[value='"+pt2BtnMaterialCd+"']").attr("selected", true);
		}


		var jkInnerBodyClothCd = "${orderForm.optionJacketStandardInfo.ojBodyBackMateStkNo}";
		if(jkInnerBodyClothCd!=""){
			jQuery("#bodyBackMateStkNo option[value='"+jkInnerBodyClothCd+"']").attr("selected", true);
		}
		var jkInnerSleeveClothCd = "${orderForm.optionJacketStandardInfo.ojCuffBackMateStkNo}";
		if(jkInnerSleeveClothCd!=""){
			jQuery("#cuffBackMateStkNo option[value='"+jkInnerSleeveClothCd+"']").attr("selected", true);
		}
		var jkBtnMaterialCd = "${orderForm.optionJacketStandardInfo.ojBtnMateStkNo}";
		if(jkBtnMaterialCd!=""){
			jQuery("#btnMateStkNo option[value='"+jkBtnMaterialCd+"']").attr("selected", true);
		}

		var glBackClothCd = "${orderForm.optionGiletStandardInfo.ogBackLiningMateStkNo}";
		if(glBackClothCd!=""){
			jQuery("#og_backLiningMateStkNo option[value='"+glBackClothCd+"']").attr("selected", true);
		}
		var glInnnerClothCd = "${orderForm.optionGiletStandardInfo.ogInsideLiningMateStkNo}";
		if(glInnnerClothCd!=""){
			jQuery("#og_insideLiningMateStkNo option[value='"+glInnnerClothCd+"']").attr("selected", true);
		}
		var glFrtBtnCd = "${orderForm.optionGiletStandardInfo.ogFrontBtnMateStkNo}";
		if(glFrtBtnCd!=""){
			jQuery("#og_frontBtnMateStkNo option[value='"+glFrtBtnCd+"']").attr("selected", true);
		}
			
		getFigureAndNumberByItem();	
		
		//補正
		adjustBackInit();
		
		//日付書式の変更
		function dateFormat(time){
			var date = new Date(time);
			var year = date.getFullYear();  
			var month = date.getMonth() + 1
			if(month<=9){
				month = "0" + month;
			}
			var day = date.getDate();
			if(day<=9){
				day = "0" + day;
			}
			return year+"/"+month+"/"+day;
		}
	}
	
	//料金の制御
	getPrice();
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
});
		
jQuery(document).ready(function(){

	var status = "${order.tscStatus}"
	if(status == 'T7'||status == 'T6'){
		jQuery("#nav2_product_div").hide();
		jQuery("#nav2_option_div").hide();
		jQuery("#nav2_alter_div").hide();

		jQuery("#nav1_custom_div input").attr("readOnly","true");
		jQuery("#nav1_mejer_div input").attr("readOnly","true");
			
		jQuery("#nav1_custom_div select").attr("disabled","disabled");
		jQuery("#nav1_mejer_div select").attr("disabled","disabled");
			
		jQuery("#shopName").attr("disabled","disabled");
		jQuery("#shopName").trigger("chosen:updated");

		jQuery("#custRemark").attr("disabled","disabled");
		
		//item
		var item = "${order.productItem}"

		//スペアパンツ  0009901： 無し、0009902：有り
		var twoPants = "${order.productSparePantsClass}";
		
		//SUITの場合
		if(item == "01"){
			jQuery("#re_jacket_div").show();
			jQuery("#re_pants_div").show();
			jQuery("#re2_pants_div").hide();
			if(twoPants == "0009902"){
				jQuery("#re2_pants_div").show();
			}else{
				jQuery("#re2_pants_div").hide();
			}
		}else if (item == "02"){
			jQuery("#re_jacket_div").show();
			jQuery("#re_pants_div").hide();
			jQuery("#re2_pants_div").hide();
		}else if (item == "03"){
			jQuery("#re_jacket_div").hide();
			jQuery("#re_pants_div").show();
			jQuery("#re2_pants_div").hide();
		}
	}


	var authority = "${sessionContent.authority}";
	if(authority == "02"){
		
	}else{
		//30s自動保存
	 	//注文のTSCステータス
		var orderStatus = "${order.tscStatus}";
		//戻るの場合、orderFormのTSCステータス
		var orderFormStatus = "${orderForm.status}";
		//T0 ：一時保存、T1 ：取り置き、""：ステータス無し
		//「オーダー一覧」画面から来たの場合
		if(　((orderStatus=="T0"||orderStatus=="T1")&&orderFormStatus=="")||
			//「内容確認」画面来たの場合	
			((orderFormStatus=="T0"||orderFormStatus=="T1")&&orderStatus=="")||
			//新規登録の場合
			(orderStatus==""&&orderFormStatus=="")){
				
			setInterval(function(){

				//バージョンフラッグ
				//var versionFlag = "";
				//保存flag
				jQuery("#saveFlag").val("1");
				//TSCステータス  一時保存
				var statusInput = jQuery("#statusInput").val();

				if(statusInput==""||statusInput==null){
					jQuery("#statusInput").val("T0");
				}else{
					jQuery("#statusInput").val(jQuery("#statusInput").val());
				}
				
				var result = temporarySaveCheck();
					
				if(!result){
					jQuery("div.alert-success").hide();
					return false;
				}
				
				jQuery('select').removeAttr("disabled");
				jQuery('input').not("#clothName_yes").removeAttr("disabled");
				jQuery.ajax({
		              url : contextPath + "/order/orderPoTemporarySave",
				      type: "post",
				      async:false,
				      data: jQuery('#formId').serialize(),
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
								  /* versionFlag = data;
								  jQuery("#versionFlag").val(versionFlag); */
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
								  var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":data.orderId},async:false});
								  version = version.responseText;
								  jQuery("#version").val(version);
								  /* versionFlag = "true";
								  jQuery("#versionFlag").val(versionFlag); */
							  }
						  }
						  /* else if(data == "1"){
							  versionFlag = "false";
							  jQuery("#versionFlag").val(versionFlag);
							  appendAlert('errormssage', getMsg('msg048'));
						  } */
						  
					  })
					  
				changeViewArea();
			  },30000)
		};
	}
 	
	//一時保存ボタンをクリック
	jQuery("#temporarySave").click(function(){

		//バージョンフラッグ
		//var versionFlag = "";
		//保存flag
		jQuery("#saveFlag").val("0");
		//TSCステータス  一時保存
		jQuery("#statusInput").val("T0");
		//一時保存チェク結果
		var result = temporarySaveCheck();
		
		if(!result){
			return false;
		}
		
		jQuery('select').removeAttr("disabled");
		jQuery('input').not("#clothName_yes").removeAttr("disabled");
		jQuery.ajax({url : contextPath + "/order/orderPoTemporarySave",
		    type: "post",
		    async:false,
			data: jQuery('#formId').serialize(),
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
						/* versionFlag = data;
						jQuery("#versionFlag").val(versionFlag); */
					}else if(data.orderId.length == 12){
						jQuery("#orderId").val(data.orderId);
				    	//ステータス設定
						jQuery("#status").empty();
						jQuery("#status").html("一時保存");
					   	appendAlert('successmssage', getMsgByOneArg('msg015',jQuery("#orderId").val()));
					   	var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
						version = version.responseText;
						jQuery("#version").val(version);
						/* versionFlag = "true";
						jQuery("#versionFlag").val(versionFlag); */
					}
				}
			    /* else if(data == "1"){
					versionFlag = "false";
					jQuery("#versionFlag").val(versionFlag);
					appendAlert('errormssage', getMsg('msg048'));
					jQuery("#version").val(jQuery("#version").val());
				} */
			})
		changeViewArea();
	})
	
	//取り置きボタンをクリック
	jQuery("#layUpSave").click(function(){
		
		//バージョンフラッグ
		//var versionFlag = "";
		
		//保存flag
		jQuery("#saveFlag").val("0");
		//TSCステータス  取り置き
		jQuery("#statusInput").val("T1");
		
		//取り置きチェク結果
		var result = temporarySaveCheck();
		
		if(!result){
			return false;
		}
		
		jQuery('select').removeAttr("disabled");
		jQuery('input').not("#clothName_yes").removeAttr("disabled");
		jQuery.ajax({url : contextPath + "/order/orderPoTemporarySave",
		    type: "post",
		    async:false,
		    data: jQuery('#formId').serialize(),
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
						/* versionFlag = "true";
			    		jQuery("#versionFlag").val(versionFlag); */
					}else if(data.orderId.length == 12){
						jQuery("#orderId").val(data.orderId);
				    	//ステータス設定
						jQuery("#status").empty();
						jQuery("#status").html("取り置き");
					   	appendAlert('successmssage', getMsgByOneArg('msg058',jQuery("#orderId").val()));
					   	var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
						version = version.responseText;
						jQuery("#version").val(version);
						/* versionFlag = "true";
						jQuery("#versionFlag").val(versionFlag); */
					}
				}
		    	/* else if(data == "1"){
					versionFlag = "false";
					jQuery("#versionFlag").val(versionFlag);
					appendAlert('errormssage', getMsg('msg048'));
					versionFlag = "1";
					jQuery("#version").val(jQuery("#version").val());
				} */
			})
		changeViewArea();
	})
	
	//注文削除ボタンクリック
	jQuery('#deleteButton').on('click', function(){
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
					window.location.href= contextPath + "/order/physicalDelete?orderId=" + orderId + "&version=" + version;
				} else {
					// Cancel押下時は何もしない
				}
			});
		}
	})
	
	
	
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
				window.location.href= contextPath + "/order/logicalDelete?orderId=" + orderId + "&version=" + version;
			} else {
				// Cancel押下時は何もしない
			}
		});
	});

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

	//JACKET モデル
	jQuery("#jacketModel").change(function(){

		var itemCode = "";
		var item = jQuery("#item").val();
		var subItemCode = "02"
		if(item == "01"){
			itemCode = "01"
		}else if(item == "02"){
			itemCode = "02"
		}	
		//生地品番
		var productFabricNo = jQuery("#productFabricNo").val();
		//生地チェクフラッグ
		var fabricCheckValue = jQuery("#fabricFlag").val();
		//fabricCheckValue[0]:0 or 1 or 2 
		//fabricCheckValue[1]:エラーメッセージ 
		fabricCheckValue = fabricCheckValue.split("*");
		var jkModel = jQuery(this).val();

		var jkFigure = document.getElementById("selectJacketFigure");
     	getSizeFigure(itemCode,subItemCode,jkModel,jkFigure);
     	   

		var jkNumber = document.getElementById("selectJacketNumber");
		getSizeNumber(itemCode,subItemCode,jkModel,jkNumber);

		jkAdjust();
			
		//生地チェク成功の場合
		if((fabricCheckValue[0]=="0"||fabricCheckValue[0]=="2")&&isNotEmpty(productFabricNo)){
			//モデルチェク
			var checkResult = modelCheck(jkModel,productFabricNo,orderPattern,itemCode,subItemCode);
			if(checkResult == "true"){
				//0はモデルチェク成功の場合
				jQuery("#jkModelFlag").val("0");
				jQuery("#jacketModelMsg").empty();
				jQuery("#fabricMsg").empty();
			}else if(checkResult == "false"){
				//2はモデルチェク失敗の場合
				jQuery("#jkModelFlag").val("1"+"*"+getMsgByOneArg('msg065','JACKET'));
				appendAlertPo('jacketModelMsg',getMsgByOneArg('msg065','JACKET'));
			}
		}
	})
	
	//PANTS モデル
	jQuery("#op_pantsModel").change(function(){
		var item = jQuery("#item").val();
		var subItemCode = "03"
		var itemCode = "";
		if(item == "01"){
			itemCode = "01"
		}else if(item == "03"){
			itemCode = "03";
		}
		//生地品番
		var productFabricNo = jQuery("#productFabricNo").val();
		//生地チェクフラッグ
		var fabricCheckValue = jQuery("#fabricFlag").val();
		//fabricCheckValue[0]:0 or 1 or 2
		//fabricCheckValue[1]:エラーメッセージ 
		fabricCheckValue = fabricCheckValue.split("*");
		
		var ptModel = jQuery(this).val();

		var ptFigure = document.getElementById("selectPantsFigure");
     	getSizeFigure(itemCode,subItemCode,ptModel,ptFigure);
     	    

		var ptNumber = document.getElementById("selectPantsNumber");
		getSizeNumber(itemCode,subItemCode,ptModel,ptNumber);

		jQuery("#corPtRightinseam_div_Size").val("");
		jQuery("#corPtLeftinseam_div_Size").val("");
		jQuery("#corPtRightinseamGross").val("");	
		jQuery("#ap_inseamRightM1").val("0");
		jQuery("#ap_inseamRight100").val("0");
		jQuery("#ap_inseamRight10").val("0");
		jQuery("#ap_inseamRight1").val("0");
			
		jQuery("#corPtLeftinseamGross").val("");
		jQuery("#ap_inseamLeftM1").val("0");
		jQuery("#ap_inseamLeft100").val("0");
		jQuery("#ap_inseamLeft10").val("0");
		jQuery("#ap_inseamLeft1").val("0");

		ptAdjust();
			
		//生地チェク成功の場合
		if((fabricCheckValue[0]=="0"||fabricCheckValue[0]=="2")&&isNotEmpty(productFabricNo)){
			//モデルチェク
			var checkResult = modelCheck(ptModel,productFabricNo,orderPattern,itemCode,subItemCode);
			if(checkResult == "true"){
				//0はモデルチェク成功の場合
				jQuery("#ptModelFlag").val("0");
				jQuery("#pantsModelMsg").empty();
				jQuery("#fabricMsg").empty();
			}else if(checkResult == "false"){
				//2はモデルチェク失敗の場合
				jQuery("#ptModelFlag").val("1"+"*"+getMsgByOneArg('msg065','PANTS'));
				appendAlertPo('pantsModelMsg',getMsgByOneArg('msg065','PANTS'));
			}
		}
		
	})
	
	//2PANTS モデル
	jQuery("#op2_pantsModel").change(function(){
		var subItemCode = "07"
		var itemCode = "01";
		//生地品番
		var productFabricNo = jQuery("#productFabricNo").val();
		//生地チェクフラッグ
		var fabricCheckValue = jQuery("#fabricFlag").val();
		//fabricCheckValue[0]:0 or 1 or 2 
		//fabricCheckValue[1]:エラーメッセージ 
		fabricCheckValue = fabricCheckValue.split("*");
		
		var pt2Model = jQuery(this).val();
		
		var pt2Figure = document.getElementById("selectPants2Figure");
        getSizeFigure(itemCode,subItemCode,pt2Model,pt2Figure);
     	    

		var pt2Number = document.getElementById("selectPants2Number");
		getSizeNumber(itemCode,subItemCode,pt2Model,pt2Number);
			
		jQuery("#corPt2Rightinseam_div_Size").val("");
		jQuery("#corPt2Leftinseam_div_Size").val("");

		jQuery("#corPt2RightinseamGross").val("");
		jQuery("#ap2_inseamRightM1").val("0");
		jQuery("#ap2_inseamRight100").val("0");
		jQuery("#ap2_inseamRight10").val("0");
		jQuery("#ap2_inseamRight1").val("0");
			
			
		jQuery("#corPt2LeftinseamGross").val("");
		jQuery("#ap2_inseamLeftM1").val("0");
		jQuery("#ap2_inseamLeft100").val("0");
		jQuery("#ap2_inseamLeft10").val("0");
		jQuery("#ap2_inseamLeft1").val("0");
			
		pt2Adjust();
			
		//生地チェク成功の場合
		if((fabricCheckValue[0]=="0"||fabricCheckValue[0]=="2")&&isNotEmpty(productFabricNo)){
			//モデルチェク
			var checkResult = modelCheck(pt2Model,productFabricNo,orderPattern,itemCode,subItemCode);
			if(checkResult == "true"){
				//0はモデルチェク成功の場合
				jQuery("#pt2ModelFlag").val("0");
				jQuery("#fabricMsg").empty();
				jQuery("#2pantsModelMsg").empty();
			}else if(checkResult == "false"){
				//2はモデルチェク失敗の場合
				jQuery("#pt2ModelFlag").val("1"+"*"+getMsgByOneArg('msg065','PANTS（2本目）'));
				appendAlertPo('2pantsModelMsg',getMsgByOneArg('msg065','PANTS（2本目）'));
			}
		}	
		
	})
	
	//2PANTS モデル
	jQuery("#giletModel").change(function(){
		var item = jQuery("#item").val();
		var subItemCode = "04"
		var itemCode = "";
		if(item == "01"){
			itemCode = "01"
		}else if(item == "04"){
			itemCode = "04"
		}
		
		var productFabricNo = jQuery("#productFabricNo").val();
		//生地チェクフラッグ
		var fabricCheckValue = jQuery("#fabricFlag").val();
		//fabricCheckValue[0]:0 or 1 or 2 
		//fabricCheckValue[1]:エラーメッセージ 
		fabricCheckValue = fabricCheckValue.split("*");
		
		var glModel = jQuery(this).val();


		var glFigure = document.getElementById("selectGiletFigure");
     	getSizeFigure(itemCode,subItemCode,glModel,glFigure);
     	    

		var glNumber = document.getElementById("selectGiletNumber");
		getSizeNumber(itemCode,subItemCode,glModel,glNumber);
			
			//生地チェク成功の場合
		if((fabricCheckValue[0]=="0"||fabricCheckValue[0]=="2")&&isNotEmpty(productFabricNo)){
			//モデルチェク
			var checkResult = modelCheck(glModel,productFabricNo,orderPattern,itemCode,subItemCode);
			if(checkResult == "true"){
				//0はモデルチェク成功の場合
				jQuery("#glModelFlag").val("0");
				jQuery("#fabricMsg").empty();
				jQuery("#giletModelMsg").empty();
			}else if(checkResult == "false"){
				//2はモデルチェク失敗の場合
				jQuery("#glModelFlag").val("1"+"*"+getMsgByOneArg('msg065','GILET'));
				appendAlertPo('giletModelMsg',getMsgByOneArg('msg065','GILET'));
			}
		}
		
	})

	
	//JACKET補正値を設定
	var jk = null;
	
	var jacketFigure;
	var jacketNumber;
	var	jacketModel;
	//体型、号数 、JACKETモデル
	jQuery("#selectJacketFigure,#selectJacketNumber").change(function(){
		
		jkAdjust();
	})
	
	
	//PANTS補正値を設定
	var pt = null;
	var ptt = null;
	
	var	pantsModel;
	var pantsFigure;
	var pantsNumber;
	var opTack;
	//体型 、号数、PANTSモデル、タック
	jQuery("#selectPantsFigure,#selectPantsNumber,#op_tack").change(function(){
		ptAdjust();
	})
	
	//2PANTS補正値を設定
	var pt2 = null;
	var ptt2 = null;
	
	var	pants2Model;
	var pants2Figure;
	var pants2Number;
	var op2Tack;
	//体型 、号数、2PANTSモデル、タック
	jQuery("#selectPants2Figure,#selectPants2Number,#op2_tack").change(function(){
		pt2Adjust();
	})
	

	//PANTS股下左
	jQuery("#ap_inseamLeft100,#ap_inseamLeft10,#ap_inseamLeft1,#ap_inseamLeftM1").change(function(){
		var ap_inseamLeft100 = jQuery("#ap_inseamLeft100").val();
		var ap_inseamLeft10 = jQuery("#ap_inseamLeft10").val();
		var ap_inseamLeft1 = jQuery("#ap_inseamLeft1").val();
		var ap_inseamLeftM1 = jQuery("#ap_inseamLeftM1").val();
		var corPtLeftinseamGross = ap_inseamLeft100+ap_inseamLeft10+ap_inseamLeft1+"."+ap_inseamLeftM1;
		jQuery("#corPtLeftinseamGross").val(corPtLeftinseamGross);
	})
	
	//PANTS股下右
	jQuery("#ap_inseamRight100,#ap_inseamRight10,#ap_inseamRight1,#ap_inseamRightM1").change(function(){
		var ap_inseamRight100 = jQuery("#ap_inseamRight100").val();
		var ap_inseamRight10 = jQuery("#ap_inseamRight10").val();
		var ap_inseamRight1 = jQuery("#ap_inseamRight1").val();
		var ap_inseamRightM1 = jQuery("#ap_inseamRightM1").val();
		var corPtRightinseamGross = ap_inseamRight100+ap_inseamRight10+ap_inseamRight1+"."+ap_inseamRightM1;
		jQuery("#corPtRightinseamGross").val(corPtRightinseamGross);
	})
	
	//2PANTS股下左
	jQuery("#ap2_inseamLeft100,#ap2_inseamLeft10,#ap2_inseamLeft1,#ap2_inseamLeftM1").change(function(){
		var ap2_inseamLeft100 = jQuery("#ap2_inseamLeft100").val();
		var ap2_inseamLeft10 = jQuery("#ap2_inseamLeft10").val();
		var ap2_inseamLeft1 = jQuery("#ap2_inseamLeft1").val();
		var ap2_inseamLeftM1 = jQuery("#ap2_inseamLeftM1").val();
		var corPt2LeftinseamGross = ap2_inseamLeft100+ap2_inseamLeft10+ap2_inseamLeft1+"."+ap2_inseamLeftM1;
		jQuery("#corPt2LeftinseamGross").val(corPt2LeftinseamGross);
	})
	
	//2PANTS股下右
	jQuery("#ap2_inseamRight100,#ap2_inseamRight10,#ap2_inseamRight1,#ap2_inseamRightM1").change(function(){
		var ap2_inseamRight100 = jQuery("#ap2_inseamRight100").val();
		var ap2_inseamRight10 = jQuery("#ap2_inseamRight10").val();
		var ap2_inseamRight1 = jQuery("#ap2_inseamRight1").val();
		var ap2_inseamRightM1 = jQuery("#ap2_inseamRightM1").val();
		var corPt2RightinseamGross = ap2_inseamRight100+ap2_inseamRight10+ap2_inseamRight1+"."+ap2_inseamRightM1;
		jQuery("#corPt2RightinseamGross").val(corPt2RightinseamGross);
	})
	
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

	//--------------------------------------------
	// 商品タブ
	//--------------------------------------------
	// アイテム
	var oldItem = jQuery("#item").val();
	
	jQuery('#item').attr("hook",oldItem);
	
	jQuery('#item').change(function(){
		//localStorage.setItem("fabricFlag","0");
		// 選択されたITEMを取得
		var item = jQuery("#item").val();
		
		swal({
			  text: getMsg('msg047'),
			  icon: "info",
			  buttons: ["キャンセル", true],
			})
			.then((isConfirm) => {
			  if (isConfirm) {

				    getModelByItem();

				    jQuery("#jkModelFlag").val("0");
					jQuery("#ptModelFlag").val("0");
					jQuery("#glModelFlag").val("0");
					jQuery("#pt2ModelFlag").val("0");
					jQuery("#jacketModelMsg").empty();
					jQuery("#pantsModelMsg").empty();
					jQuery("#2pantsModelMsg").empty();
					jQuery("#giletModelMsg").empty();
					jQuery("#fabricMsg").empty(); 
					jQuery("#opBtnMateMsg").empty();
					jQuery("#op2BtnMateMsg").empty();
					
					//オプションコード初期化
				  	defaultOptionInit();

					jQuery('#optionPrice').html('0');
					
					jQuery('#optionPriceId').val("");

					//補正初期化
					adjustReInit();

					//合計金額初期化
					allPrice();

					//素材品番初期化
					mateInit();

					//組成表示
					compositionExpress();

					//商品タブ用初期化
					changeViewArea();

					getAdjustByItem();
					
					jQuery('input[name=productEmbroideryNecessity][value="0"]').prop("checked",true);
					jQuery('input[name="productEmbroideryNecessity"]').change();
					
					jQuery("[id$=_Msg]").empty();

					//注文のTSCステータス
					var orderStatus = "${order.tscStatus}";
					//戻るの場合、orderFormのTSCステータス
					var orderFormStatus = "${orderForm.status}";
					//T0 ：一時保存、T1 ：取り置き、""：ステータス無し
					//オーダー一覧から来たの場合
					if(　((orderStatus=="T0"||orderStatus=="T1")&&orderFormStatus=="")||
						//「内容確認」画面来たの場合	
						((orderFormStatus=="T0"||orderFormStatus=="T1")&&orderStatus=="")||
						//新規登録の場合
						(orderStatus==""&&orderFormStatus=="")){
						//在庫チェク
						stockCheck();
					}else{
						//生地品番
					    var productFabricNo = jQuery("#productFabricNo").val();

					    var checkResult = fabricCheck(item,productFabricNo);
						if(checkResult){
							//生地によって、商品を表示
							fabricView(item,productFabricNo);
						}
					}
					
					if(item!=oldItem){
						jQuery('#item').attr("hook",item);
					}
					
			  }else{
				 jQuery('#item').val(jQuery('#item').attr("hook"));
			  }
		});


	});
	
	changeViewArea();
	
	// ３Piece
	jQuery('input[name="productIs3Piece"]').each(function() {
		jQuery(this).change(changeViewArea);
		jQuery(this).change(function(){
			jQuery("#fabricMsg").empty();
			jQuery("#giletModelMsg").empty();
			jQuery("#op_gilet_div [id$=_Msg]").empty();

			for (g of giletDefaultList.activeList) {
				//プルダウンの場合
				if(g.type == "2"){
					jQuery("#"+g.id+" option[value='"+g.dVal+"']").prop("selected", true);
				//ラジオボタンの場合
				}else if(g.type == "1"){
					jQuery(":radio[name='" + g.id + "'][value='" + g.dVal + "']").prop("checked", true);
				}else if(g.type == "3"){
					jQuery(":radio[name='" + g.id + "']").removeAttr("checked");
				}
			}

			var threePiece = jQuery(this).val();
			var item = jQuery("#item option:selected").val();
			if(threePiece == '0009902'){
				if(item == "01"){
					//AMFステッチ
					var ojStitch = jQuery('input[name="optionJacketStandardInfo.ojStitch"]:checked').val();
					//無し
					if(ojStitch == "0002302"){
						jQuery(":radio[name='optionGiletStandardInfo.ogStitch'][value='0000503']").prop("checked", "checked");
					}
					//有り
					else if(ojStitch == "0002305"){
						jQuery(":radio[name='optionGiletStandardInfo.ogStitch'][value='0000502']").prop("checked", "checked");
					}
					//背裏地素材
					var bodyBackMate = jQuery("#bodyBackMate").val();
					jQuery("#og_backLiningMate").val(bodyBackMate);
					jQuery("#og_backLiningMate").change();
					var bodyBackMateStkNo = jQuery("#bodyBackMateStkNo").val();
					jQuery("#og_backLiningMateStkNo").val(bodyBackMateStkNo);
					jQuery("#og_backLiningMateStkNo").prop("disabled",true);
					//内側裏地素材
					jQuery("#og_insideLiningMate").val(bodyBackMate);
					jQuery("#og_insideLiningMate").change();
					var bodyBackMateStkNo = jQuery("#bodyBackMateStkNo").val();
					jQuery("#og_insideLiningMateStkNo").val(bodyBackMateStkNo);
					jQuery("#og_insideLiningMateStkNo").prop("disabled",true);
					//釦素材
					var btnMate = jQuery("#btnMate").val();
					jQuery("#og_frontBtnMate").val(btnMate);
					jQuery("#og_frontBtnMate").change();
					var btnMateStkNo = jQuery("#btnMateStkNo").val();
					jQuery("#og_frontBtnMateStkNo").val(btnMateStkNo);
					jQuery("#og_frontBtnMateStkNo").prop("disabled",true);
					var jacketModel = jQuery('#jacketModel').val();
					if(isNotEmpty(jacketModel)){
						jQuery('#giletModel').val(jacketModel);
						jQuery('#giletModel').change();
					}
					
					var glBodyText = jQuery("#og_backLiningMate").find("option:selected").text();
					glBodyText = "GILET："+glBodyText;
					var bodyText = jQuery("#bodyBackMate").find("option:selected").text();
					bodyText = "JACKET："+bodyText;
					jQuery("#productComposBodyLiner").val(bodyText+" "+glBodyText);
					jQuery("#compos_body_liner_p").html(bodyText).append("<Br>").append(glBodyText);
				}
			}
			
			//注文のTSCステータス
			var orderStatus = "${order.tscStatus}";
			//戻るの場合、orderFormのTSCステータス
			var orderFormStatus = "${orderForm.status}";
			//T0 ：一時保存、T1 ：取り置き、""：ステータス無し
			//オーダー一覧から来たの場合
			if(　((orderStatus=="T0"||orderStatus=="T1")&&orderFormStatus=="")||
			//「内容確認」画面来たの場合	
			((orderFormStatus=="T0"||orderFormStatus=="T1")&&orderStatus=="")||
			//新規登録の場合
			(orderStatus==""&&orderFormStatus=="")){
				//在庫チェク
				stockCheck();
			}else{

				//生地品番
			    var productFabricNo = jQuery("#productFabricNo").val();

			    var checkResult = fabricCheck(item,productFabricNo);
				if(checkResult){
					//生地によって、商品を表示
					fabricView(item,productFabricNo);
				}
			}

		})
		
		
	});

	// スペアパンツ
	jQuery('input[name="productSparePantsClass"]').each(function() {
		jQuery(this).change(changeViewArea);
		jQuery(this).change(function(){
			var twoPants = jQuery(this).val();
			var item = jQuery("#item").val();
			jQuery("#2pantsModelMsg").empty();
			jQuery("#fabricMsg").empty();
			jQuery("#op2_pants_div [id$=_Msg]").empty();
			jQuery("#op2BtnMateMsg").empty();

			//2PT　型サイズ値、補正値とグロス値を設定
			jQuery("#corPt2Waist_div_Size").val("");
			jQuery("#corPt2Waist_div_Gross").val("");
			jQuery("#corPt2Waist_div_html").html("000.0cm");
			jQuery("#corPt2WaistRange_out").html("0");
			jQuery("#corPt2WaistRange").val("0");
			setFont("corPt2WaistRange");
			
			jQuery("#corPt2Thigh_div_Size").val("");
			jQuery("#corPt2Thigh_div_Gross").val("");
			jQuery("#corPt2Thigh_div_html").html("000.0cm");
			jQuery("#corPt2ThighRange_out").html("0");
			jQuery("#corPt2ThighRange").val("0");
			setFont("corPt2ThighRange");

			jQuery("#corPt2Hemwidth_div_Size").val("");
			jQuery("#corPt2Hemwidth_div_Gross").val("");
			jQuery("#corPt2Hemwidth_div_html").html("000.0cm");
			jQuery("#corPt2HemwidthRange_out").html("0");
			jQuery("#corPt2HemwidthRange").val("0");
			setFont("corPt2HemwidthRange");

			jQuery("#corPt2Rightinseam_div_Size").val("");
			jQuery("#corPt2Leftinseam_div_Size").val("");

			jQuery("#corPt2RightinseamGross").val("");
			jQuery("#ap2_inseamRightM1").val("0");
			jQuery("#ap2_inseamRight100").val("0");
			jQuery("#ap2_inseamRight10").val("0");
			jQuery("#ap2_inseamRight1").val("0");
			
			
			jQuery("#corPt2LeftinseamGross").val("");
			jQuery("#ap2_inseamLeftM1").val("0");
			jQuery("#ap2_inseamLeft100").val("0");
			jQuery("#ap2_inseamLeft10").val("0");
			jQuery("#ap2_inseamLeft1").val("0");

			for (p2 of pants2DefaultList.activeList) {
				//プルダウンの場合
				if(p2.type == "2"){
					jQuery("#"+p2.id+" option[value='"+p2.dVal+"']").prop("selected", true);
				//ラジオボタンの場合
				}else if(p2.type == "1"){
					jQuery(":radio[name='" + p2.id + "'][value='" + p2.dVal + "']").prop("checked", true);
				}
			}
			jQuery("#op2_doubleWide_div").hide();	
			
			var jacketModel = jQuery('#jacketModel').val();
			
			if(twoPants == '0009902'){
				if(item == "01"){
					//釦素材
					jQuery("#op2_btnMate").val(jQuery("#btnMate").val());
					jQuery("#op2_btnMate").change();
					jQuery("#op2_btnMateStkNo").val(jQuery("#btnMateStkNo").val());
					jQuery("#op2_btnMateStkNo").prop("disabled",true);
					if(isNotEmpty(jacketModel)){
						jQuery('#op2_pantsModel').val(jacketModel);
						jQuery('#op2_pantsModel').change(); 
					}
				}
			}
			
			//注文のTSCステータス
			var orderStatus = "${order.tscStatus}";
			//戻るの場合、orderFormのTSCステータス
			var orderFormStatus = "${orderForm.status}";
			//T0 ：一時保存、T1 ：取り置き、""：ステータス無し
				//オーダー一覧から来たの場合
				if(　((orderStatus=="T0"||orderStatus=="T1")&&orderFormStatus=="")||
				//「内容確認」画面来たの場合	
				((orderFormStatus=="T0"||orderFormStatus=="T1")&&orderStatus=="")||
				//新規登録の場合
				(orderStatus==""&&orderFormStatus=="")){
				//在庫チェク
				stockCheck();
			}else{
				
				//生地品番
			    var productFabricNo = jQuery("#productFabricNo").val();

			    var checkResult = fabricCheck(item,productFabricNo);
				if(checkResult){
					//生地によって、商品を表示
					fabricView(item,productFabricNo);
				}
			}

		});
	});

	// カテゴリ
	jQuery('input[name="productCategory"]').each(function() {
		jQuery(this).change(changeViewArea);
	});
	
	var productEmbroideryNecessity = jQuery('input[name="productEmbroideryNecessity"]:checked').val();
	if(productEmbroideryNecessity == '1'){
		jQuery('#embroidered_yes_area').show();
	}else{
		jQuery('#embroidered_yes_area').hide();
	}
	// 刺繍入れ
	jQuery('input[name="productEmbroideryNecessity"]').each(function() {
		jQuery(this).change(function(){
			// 選択中の刺繍入れ
			var productEmbroideryNecessity = jQuery('input[name=productEmbroideryNecessity]:checked').val();

			//刺繍書体
			var productEmbroideryFont = "${order.productEmbroideryFont}";
			
			//刺繍糸色
			var embroideryColor = "${order.productEmbroideryThreadColor}";
			
			if(productEmbroideryFont!=""&&embroideryColor!=""){
				// 刺繍入れが有りの場合は刺繍関連項目を表示する
				if (productEmbroideryNecessity == '1') {
					if(isEmpty(productEmbroideryFont)){
						jQuery(":radio[name='productEmbroideryFont'][value='14（花文字）']").prop("checked", "checked");
					}else{
						jQuery("input[name='productEmbroideryFont'][value='" + productEmbroideryFont + "']").prop("checked", "checked");
					}
					
					if(isEmpty(embroideryColor)){
						jQuery(":radio[name='productEmbroideryThreadColor'][value='110（金茶）']").prop("checked", "checked");
					}else{
						jQuery("input[name='productEmbroideryThreadColor'][value='" + embroideryColor + "']").prop("checked", "checked");
					}
					
					
					jQuery('#embroidered_yes_area').show();
				} else {
					jQuery("#embroideryName").val("");
					jQuery(":radio[name='productEmbroideryFont']").removeAttr("checked");
					jQuery(":radio[name='productEmbroideryThreadColor']").removeAttr("checked");
					jQuery('#embroidered_yes_area').hide();
				}
			}else{
				// 刺繍入れが有りの場合は刺繍関連項目を表示する
				if (productEmbroideryNecessity == '1') {
					jQuery(":radio[name='productEmbroideryFont'][value='14（花文字）']").prop("checked", "checked");
					jQuery(":radio[name='productEmbroideryThreadColor'][value='110（金茶）']").prop("checked", "checked");
					jQuery('#embroidered_yes_area').show();
				} else {
					jQuery("#embroideryName").val("");
					jQuery(":radio[name='productEmbroideryFont']").removeAttr("checked");
					jQuery(":radio[name='productEmbroideryThreadColor']").removeAttr("checked");
					jQuery('#embroidered_yes_area').hide();
				}
			}
			
		});
	});
	//jQuery('#embroidered_no').change();


	// 腰ポケット
	jQuery('input[id^="waistPkt_"]').each(function() {
		jQuery(this).change(function(){
			var waistPkt = jQuery(this).val();
			//0001203  パッチ
			//チェンジポケット changePkt_id1:無し、changePkt_id2:有り
			//スランテッドポケット slantedPkt_id1:無し、slantedPkt_id2:有り
			jQuery('#changePkt_id2').prop('disabled', false);
			jQuery('#slantedPkt_id2').prop('disabled', false);
			if (waistPkt == "0001203") {
				appendAlertPo('waistPktMsg', getMsg('msg059'));
				jQuery('#changePkt_id1').prop('checked', true);
				jQuery('#slantedPkt_id1').prop('checked', true);
				jQuery('#changePkt_id2').prop('disabled', true);
				jQuery('#slantedPkt_id2').prop('disabled', true);
				jQuery('input[id^="changePkt_"]:checked').change();
				jQuery('input[id^="slantedPkt_"]:checked').change();
			}else{
				jQuery("#waistPktMsg").empty();
			}
		});
	});

	// GILETモデル変更　胸ポケットの制御
	jQuery("#giletModel").change(function(){
		
		var giletModel = jQuery("#giletModel").val();
		if(giletModel=="CH14"){
			//0000104 ：有り　　0000101：無し
			jQuery(":radio[name='optionGiletStandardInfo.ogBreastPkt']").removeAttr("disabled");
			jQuery(":radio[name='optionGiletStandardInfo.ogBreastPkt'][value='0000104']").prop("checked", true);
			jQuery('input[id^="og_breastPkt_"]:checked').change();
		}else if(giletModel=='SAVILEROW'){
			//0000104 ：有り　　0000101：無し
			//og_breastPkt_id2   有り
			//jQuery("#og_breastPkt_id2").prop("disabled",true);
			jQuery(":radio[name='optionGiletStandardInfo.ogBreastPkt']").prop("disabled",true);
			jQuery(":radio[name='optionGiletStandardInfo.ogBreastPkt'][value='0000101']").prop("checked", true);
			jQuery('input[id^="og_breastPkt_"]:checked').change();
		}
	})
	
	// フロント釦数
	jQuery('#oj_frontBtnCnt').change(function(){
		var frontBtnCnt = jQuery(this).val();
		//ダブル６つボタン:0000105
		//ラペルデザイン  ノッチ:lapelDesign_id1 、ピークド:lapelDesign_id2
		if (frontBtnCnt == "0000105") {
			jQuery('#lapelDesign_id1').prop('disabled', true);
			jQuery('#lapelDesign_id1').prop('checked', false);
			jQuery('#lapelDesign_id2').prop('checked', true);
		} else {
			jQuery('#lapelDesign_id1').prop('disabled', false);
		}
	});
	jQuery('#oj_frontBtnCnt').change();
	
	//ダブル糸: 0001702 ,ダブルスナップ  :0001703
	var op_doubleWide = jQuery('#op_doubleWide option:selected').val();
	
	var hemUp = jQuery("#op_hemUp").val();
	
	if (hemUp == "0001702" || hemUp == "0001703") {
		jQuery('#op_doubleWide').val(op_doubleWide);
		jQuery('#op_doubleWide_div').show();
		jQuery('#op_doubleWide').change();
	}else{
		jQuery('#op_doubleWide_div').hide();
	}
	
	jQuery('#op_hemUp').change(function (){
		var hemUp = jQuery(this).val();
		if (hemUp == "0001702" || hemUp == "0001703") {
			jQuery('#op_doubleWide').val("4");
			jQuery('#op_doubleWide').change();
			jQuery('#op_doubleWide_div').show();
		}else{
			jQuery('#op_doubleWide').change();
			jQuery('#op_doubleWide_div').hide();
		}
	});
	
	//jQuery('#op_hemUp').change();

	//ダブル糸: 0001702 ,ダブルスナップ  :0001703
	var op2_doubleWide = jQuery('#op2_doubleWide option:selected').val();
	
	var hemUp2 = jQuery('#op2_hemUp').val();
	if (hemUp2 == "0001702" || hemUp2 == "0001703") {
		jQuery('#op2_doubleWide').val(op2_doubleWide);
		jQuery('#op2_doubleWide').change();
		jQuery('#op2_doubleWide_div').show();
	}else{
		jQuery('#op2_doubleWide_div').hide();
	}
	
	jQuery('#op2_hemUp').change(function (){
		var hemUp2 = jQuery(this).val();
		if (hemUp2 == "0001702" || hemUp2 == "0001703") {
			jQuery('#op2_doubleWide').val("4");
			jQuery('#op2_doubleWide').change();
			jQuery('#op2_doubleWide_div').show();
		}else{
			jQuery('#op2_doubleWide').change();
			jQuery('#op2_doubleWide_div').hide();
		}
	});
	//jQuery('#op2_hemUp').change()

	
	//--------------------------------------------
	// 補正タブ 
	//--------------------------------------------
	
	jQuery('input[type="range"]').each(function() {
		var elem = jQuery(this);
		var id = elem.prop('id');
		var step = elem.prop('step') - 0;
		elem.on('input', function(){
			
			jQuery('#'+id+'_out').val(this.value);
			var idRe = id.replace('Range','_div');
			var sizeVal = jQuery("#"+idRe+"_Size").val();
			var labelVaUplCm = jQuery('#'+idRe+'_html').html()
			var labelValUp = labelVaUplCm.replace('cm','');
			var thisVal = this.value;
			if(sizeVal!=""&&typeof(sizeVal)!="undefined"){
				var val = (parseFloat(sizeVal)+parseFloat(this.value)).toFixed(1);
			}else{
				var val = parseFloat(this.value).toFixed(1);
			}
			
			jQuery("#"+idRe+"_html").html(val+"cm");
			jQuery('#'+idRe+'_Gross').val(val);
			setFont(id);
		});
		jQuery('#'+id+'_p').click(function(){
			elem.val(elem.val()-0+step);
			jQuery('#'+id+'_out').val(elem.val());
			var max = document.getElementById(id).max;
			var idRe = id.replace('Range','_div');	
			var sizeVal = jQuery("#"+idRe+"_Size").val();
			var labelVaUplCm = jQuery('#'+idRe+'_html').html();
			if((typeof(labelVaUplCm)!="undefined"&&labelVaUplCm!=null)&&sizeVal != ""){
				var idRejQ = jQuery('#'+idRe);
				
				var labelValUp = labelVaUplCm.replace('cm','');
				
				var maxVal = (parseFloat(max)+parseFloat(sizeVal)).toFixed(1);
				
				var val = (parseFloat(sizeVal)+parseFloat(elem.val())).toFixed(1);

				//if(parseFloat(val)<=parseFloat(maxVal)){
				jQuery("#"+idRe+"_html").html(val+"cm");
				jQuery('#'+idRe+'_Gross').val(val);
				//}else{
					//return false;
				//}
			}
			setFont(id);
			return false;
		});
		jQuery('#'+id+'_m').click(function(){ 
			elem.val(elem.val()-0-step);
			jQuery('#'+id+'_out').val(elem.val());
			var min = document.getElementById(id).min;
			var idRe = id.replace('Range','_div');
			var sizeVal = jQuery("#"+idRe+"_Size").val();
			var labelValDoCm = jQuery('#'+idRe+'_html').html();
			if((typeof(labelValDoCm)!="undefined"&&labelValDoCm!=null)&&sizeVal != ""){
				
				var idRejQ = jQuery('#'+idRe);

				var labelValDo = labelValDoCm.replace('cm','');

				var minVal = (parseFloat(min)+parseFloat(sizeVal)).toFixed(1);
				
				var val = (parseFloat(sizeVal)+parseFloat(elem.val())).toFixed(1);
				//if(parseFloat(val)>=parseFloat(minVal)){
					
				jQuery("#"+idRe+"_html").html(val+"cm");
				jQuery('#'+idRe+'_Gross').val(val);
				//}else{
					//return false;
				//}
			}
			setFont(id);
			return false;
		});
	});

	// PANTS2本目（1本目と同じ）
	jQuery("#btn_op2_samePants").click(function(){
		
		jQuery("#op2_pantsModel").val(jQuery("#op_pantsModel").val());
		jQuery("#op2_tack").val(jQuery("#op_tack").val());
		jQuery("#op2_tack").change();

		//アジャスター仕様
		var opAdjuster = jQuery("input[name='optionPantsStandardInfo.opAdjuster']:checked").val();
		jQuery("input[name='optionPants2StandardInfo.op2Adjuster'][value='" + opAdjuster + "']").prop("checked",'checked');
		jQuery("input[name='optionPants2StandardInfo.op2Adjuster']:checked").change();

		//裾上げ
		jQuery("#op2_hemUp").val(jQuery("#op_hemUp").val());
		jQuery("#op2_hemUp").change();

		//ダブル幅
		jQuery("#op2_doubleWide").val(jQuery("#op_doubleWide").val());
		jQuery("#op2_doubleWide").change();

		//釦素材
		jQuery("#op2_btnMate").val(jQuery("#op_btnMate").val());

		jQuery("#op2_btnMateStkNo").val(jQuery("#op_btnMateStkNo").val());

		//jQuery('#op2_btnMate').change();
		
		jQuery("#op2_btnMateStkNo").change();
		
		//エイト（滑り止め）
		var opEight = jQuery("input[name='optionPantsStandardInfo.opEight']:checked").val();
		jQuery("input[name='optionPants2StandardInfo.op2Eight'][value='" + opEight + "']").prop("checked",'checked');
		jQuery("input[name='optionPants2StandardInfo.op2Eight']:checked").change();

		//シック大（股補強）
		var opThick = jQuery("input[name='optionPantsStandardInfo.opThick']:checked").val();
		jQuery("input[name='optionPants2StandardInfo.op2Thick'][value='" + opThick + "']").prop("checked",'checked');
		jQuery("input[name='optionPants2StandardInfo.op2Thick']:checked").change();
		
		//形状記憶
		var opShapeMemory = jQuery("input[name='optionPantsStandardInfo.opShapeMemory']:checked").val();
		jQuery("input[name='optionPants2StandardInfo.op2ShapeMemory'][value='" + opShapeMemory + "']").prop("checked",'checked');
		jQuery("input[name='optionPants2StandardInfo.op2ShapeMemory']:checked").change();
		
		//靴ずれ
		var opBlister = jQuery("input[name='optionPantsStandardInfo.opBlister']:checked").val();
		jQuery("input[name='optionPants2StandardInfo.op2Blister'][value='" + opBlister + "']").prop("checked",'checked');
		jQuery("input[name='optionPants2StandardInfo.op2Blister']:checked").change();

		jQuery('#op2_btnMate').prop("disabled",true);

		jQuery("#op2_btnMateStkNo").prop("disabled",true);

		//jQuery("#op2_pantsModel").change();

		jQuery('#btn_ap2_samePants').click();
		
	})

	
	// PANTS2本目（1本目と同じ）補正
	jQuery('#btn_ap2_samePants').click(function (){
		jQuery('#selectPants2Figure').val(jQuery('#selectPantsFigure').val());
		jQuery('#selectPants2Number').val(jQuery('#selectPantsNumber').val());
		jQuery('#corPt2WaistRange').val(jQuery('#corPtWaistRange').val());
		jQuery('#corPt2WaistRange_out').val(jQuery('#corPt2WaistRange').val());
		setFont('corPt2WaistRange');
		
		jQuery('#corPt2ThighRange').val(jQuery('#corPtThighRange').val());
		jQuery('#corPt2ThighRange_out').val(jQuery('#corPt2ThighRange').val());
		setFont('corPt2ThighRange');
		
		jQuery('#corPt2HemwidthType').prop('checked', jQuery('#corPtHemwidthType').prop('checked'));
		jQuery('#corPt2HemwidthRange').val(jQuery('#corPtHemwidthRange').val());
		jQuery('#corPt2HemwidthRange_out').val(jQuery('#corPt2HemwidthRange').val());
		setFont('corPt2HemwidthRange');
		
		jQuery('#ap2_inseamLeft100').val(jQuery('#ap_inseamLeft100').val());
		jQuery('#ap2_inseamLeft10').val(jQuery('#ap_inseamLeft10').val());
		jQuery('#ap2_inseamLeft1').val(jQuery('#ap_inseamLeft1').val());
		jQuery('#ap2_inseamLeftM1').val(jQuery('#ap_inseamLeftM1').val());
		jQuery('#ap2_inseamRight100').val(jQuery('#ap_inseamRight100').val());
		jQuery('#ap2_inseamRight10').val(jQuery('#ap_inseamRight10').val());
		jQuery('#ap2_inseamRight1').val(jQuery('#ap_inseamRight1').val());
		jQuery('#ap2_inseamRightM1').val(jQuery('#ap_inseamRightM1').val());

		var ap2_inseamLeft100 = jQuery("#ap2_inseamLeft100").val();
		var ap2_inseamLeft10 = jQuery("#ap2_inseamLeft10").val();
		var ap2_inseamLeft1 = jQuery("#ap2_inseamLeft1").val();
		var ap2_inseamLeftM1 = jQuery("#ap2_inseamLeftM1").val();
		var corPt2LeftinseamGross = ap2_inseamLeft100+ap2_inseamLeft10+ap2_inseamLeft1+"."+ap2_inseamLeftM1;
		jQuery("#corPt2LeftinseamGross").val(corPt2LeftinseamGross);
		
		var ap2_inseamRight100 = jQuery("#ap2_inseamRight100").val();
		var ap2_inseamRight10 = jQuery("#ap2_inseamRight10").val();
		var ap2_inseamRight1 = jQuery("#ap2_inseamRight1").val();
		var ap2_inseamRightM1 = jQuery("#ap2_inseamRightM1").val();
		var corPt2RightinseamGross = ap2_inseamRight100+ap2_inseamRight10+ap2_inseamRight1+"."+ap2_inseamRightM1;
		jQuery("#corPt2RightinseamGross").val(corPt2RightinseamGross);

		
		jQuery("#corPt2Waist_div_html").html(jQuery("#corPtWaist_div_html").html());
		jQuery("#corPt2Waist_div_Size").val(jQuery("#corPtWaist_div_Size").val());
		jQuery("#corPt2Waist_div_Gross").val(jQuery("#corPtWaist_div_Gross").val());

		jQuery("#corPt2Thigh_div_html").html(jQuery("#corPtThigh_div_html").html());
		jQuery("#corPt2Thigh_div_Size").val(jQuery("#corPtThigh_div_Size").val());
		jQuery("#corPt2Thigh_div_Gross").val(jQuery("#corPtThigh_div_Gross").val());

		jQuery("#corPt2Hemwidth_div_html").html(jQuery("#corPtHemwidth_div_html").html());
		jQuery("#corPt2Hemwidth_div_Size").val(jQuery("#corPtHemwidth_div_Size").val());
		jQuery("#corPt2Hemwidth_div_Gross").val(jQuery("#corPtHemwidth_div_Gross").val());

		jQuery("#corPt2Rightinseam_div_Size").val(jQuery("#corPtRightinseam_div_Size").val());
		jQuery("#corPt2Leftinseam_div_Size").val(jQuery("#corPtLeftinseam_div_Size").val());

	});

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

	
});


/************************************************
 * 部品メソッド
 ************************************************/
//--------------------------------------------
// 共通
//--------------------------------------------
// 指定したIDの要素にアラートを挿入する
function appendAlertPo(id, message) {
	jQuery('#'+id).empty();
	var alertElem = jQuery(
			'<div class="alert alert-warning alert-dismissible" role="alert" style="display:none;">' +
			'<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
			'<i class="fa fa-exclamation-triangle"></i> ' + message +
			'</div>');
	alertElem.appendTo('#'+id);
	alertElem.fadeIn(500);
}

//--------------------------------------------
//商品タブ用
//--------------------------------------------
function changeViewArea() {
	// 選択中のITEM
	var item = jQuery('#item option:selected').val();
	// 選択中の３Piece
	var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
	// 選択中のスペアパンツ
	var sparePants = jQuery('input[name="productSparePantsClass"]:checked').val();


	// ３Piece、スペアパンツ
	if (item == "01") {
		jQuery('#threePiece_div').show();
		jQuery('#sparePants_div').show();
	}else if(item=='02'){
		jQuery('#threePiece_div').hide();
		jQuery('#sparePants_div').hide();
		jQuery('input[name="productIs3Piece"][value="0"]').prop('checked',true);
		jQuery('input[name="productSparePantsClass"][value="0"]').prop('checked',true);
	} else {
		jQuery('#threePiece_div').hide();
		jQuery('#sparePants_div').hide();
		jQuery('input[name="productIs3Piece"][value="0"]').prop('checked',true);
		jQuery('input[name="productSparePantsClass"][value="0"]').prop('checked',true);
	}

	// 刺繍入れ
	if (item == "01" || item == "02") {
		jQuery('input[id="embroidered_yes"]').prop("disabled",false);
	} else {
		jQuery('input[id="embroidered_yes"]').prop("disabled",true);
		jQuery('input[id="embroidered_no"]').prop("checked",true);
	}
	//jQuery('input[name="productEmbroideryNecessity"]').change();

	//３Piece  0009902 ： 有り　　0009901：無し　3Piece
	if (item == "01") {
		jQuery('#op_jacket_div').show();
		jQuery('#al_jacket_div').show();
		if (threePiece == "0009902") {
			jQuery('#op_gilet_div').show();
			jQuery('#btn_og_backLiningMate').show();
			jQuery('#btn_og_frontBtnMate').show();
			jQuery('#al_gilet_div').show();
		} else {
			jQuery('#op_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
		}
		jQuery('#op_pants_div').show();
		jQuery('#al_pants_div').show();

		//2PANTS  0009902 ：有り　　0009901：有り
		if (sparePants == "0009902" || sparePants == "3パンツ") {
			jQuery('#op2_pants_div').show();
			jQuery('#al2_pants_div').show();
		} else {
			jQuery('#op2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
		}
		if (sparePants == "3パンツ") {
			jQuery('#op3_pants_div').show();
			jQuery('#al3_pants_div').show();
		} else {
			jQuery('#op3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
		}
		jQuery('#op_sameJacketBtn').show();
	} else if (item == "02") {
		jQuery('#op_jacket_div').show();
		jQuery('#al_jacket_div').show();
		jQuery('#op_gilet_div').hide();
		jQuery('#al_gilet_div').hide();
		jQuery('#op_pants_div').hide();
		jQuery('#al_pants_div').hide();
		jQuery('#op2_pants_div').hide();
		jQuery('#al2_pants_div').hide();
		jQuery('#op3_pants_div').hide();
		jQuery('#al3_pants_div').hide();
		jQuery('#op_sameJacketBtn').hide();
	} else if (item == "03") {
		jQuery('#op_jacket_div').hide();
		jQuery('#al_jacket_div').hide();
		jQuery('#op_gilet_div').hide();
		jQuery('#al_gilet_div').hide();
		jQuery('#op_pants_div').show();
		jQuery('#al_pants_div').show();
		jQuery('#op2_pants_div').hide();
		jQuery('#al2_pants_div').hide();
		jQuery('#op3_pants_div').hide();
		jQuery('#al3_pants_div').hide();
		jQuery('#op_sameJacketBtn').hide();
	} else if (item == "04") {
		jQuery('#op_jacket_div').hide();
		jQuery('#al_jacket_div').hide();
		jQuery('#op_gilet_div').show();
		jQuery('#al_gilet_div').show();
		jQuery('#op_pants_div').hide();
		jQuery('#al_pants_div').hide();
		jQuery('#op2_pants_div').hide();
		jQuery('#al2_pants_div').hide();
		jQuery('#op3_pants_div').hide();
		jQuery('#al3_pants_div').hide();
		jQuery('#btn_og_backLiningMate').hide();
		jQuery('#btn_og_frontBtnMate').hide();
		jQuery('#op_sameJacketBtn').hide();
	}

	// 素材の入力制
	setMaterialPattern(item);

	//生地品番
    var productFabricNo = jQuery("#productFabricNo").val();
	if(isNotEmpty(productFabricNo)){
		jQuery.ajax({
			type:"get",
			url: contextPath + "/order/findStock",
			data:{"fabricNo":productFabricNo,"orderPattern":orderPattern},
			async:false,
			success:function(result){
				colorSet(item,result.color)
			}
		 })
	}

    var giletModel = jQuery("#giletModel").val();
	if(giletModel=="CH14"){
		
	}else if(giletModel=='SAVILEROW'){
		//0000104 ：有り　　0000101：無し
		//og_breastPkt_id2   有り
		jQuery(":radio[name='optionGiletStandardInfo.ogBreastPkt']").prop("disabled",true);
		jQuery(":radio[name='optionGiletStandardInfo.ogBreastPkt'][value='0000101']").prop("checked", true);
		jQuery('input[id^="og_breastPkt_"]:checked').change();
	}

	// フロント釦数
	var frontBtnCnt = jQuery('#oj_frontBtnCnt').val();
		//ダブル６つボタン:0000105
		//ラペルデザイン  ノッチ:lapelDesign_id1 、ピークド:lapelDesign_id2
	if (frontBtnCnt == "0000105") {
		jQuery('#lapelDesign_id1').prop('disabled', true);
		jQuery('#lapelDesign_id1').prop('checked', false);
		jQuery('#lapelDesign_id2').prop('checked', true);
	} else {
		jQuery('#lapelDesign_id1').prop('disabled', false);
	}

	// 腰ポケット
	var waistPkt = jQuery('input[name="optionJacketStandardInfo.ojWaistPkt"]:checked').val();
	//0001203  パッチ
	//チェンジポケット changePkt_id1:無し、changePkt_id2:有り
	//スランテッドポケット slantedPkt_id1:無し、slantedPkt_id2:有り
	jQuery('#changePkt_id2').prop('disabled', false);
	jQuery('#slantedPkt_id2').prop('disabled', false);
	if (waistPkt == "0001203") {
		jQuery('#changePkt_id1').prop('checked', true);
		jQuery('#slantedPkt_id1').prop('checked', true);
		jQuery('#changePkt_id2').prop('disabled', true);
		jQuery('#slantedPkt_id2').prop('disabled', true);
		jQuery('input[id^="changePkt_"]:checked').change();
		jQuery('input[id^="slantedPkt_"]:checked').change();
	}else{
		jQuery("#waistPktMsg").empty();
	}		

}

// 素材の入力制御
function setMaterialPattern(item) {
	
	if (item == "01") {
		jQuery('#og_backLiningMate').prop("disabled", true);
		jQuery('#og_backLiningMateStkNo').prop("disabled", true);
		jQuery('#og_insideLiningMate').prop("disabled", true);
		jQuery('#og_insideLiningMateStkNo').prop("disabled", true);
		jQuery('#og_frontBtnMate').prop("disabled", true);
		jQuery('#og_frontBtnMateStkNo').prop("disabled", true);
		jQuery('#op_btnMate').prop("disabled", true);
		jQuery('#op_btnMateStkNo').prop("disabled", true);
		jQuery('#op2_btnMate').prop("disabled", true);
		jQuery('#op2_btnMateStkNo').prop("disabled", true);
		jQuery('#og_stitch_id2').prop("disabled", true);
		jQuery('#og_stitch_id1').prop("disabled", true);
		jQuery('#giletModel').prop("disabled", true);
		jQuery('#op_pantsModel').prop("disabled", true);
		jQuery('#op2_pantsModel').prop("disabled", true);
		
		jQuery(":radio[name='optionJacketStandardInfo.ojStitch']").click(function(){
			var ojStitch = jQuery('input[name="optionJacketStandardInfo.ojStitch"]:checked').val();
			//JACKET:AMFステッチ  0002302:無し 0002305:有り
			if(ojStitch=='0002302'){
				//GILET:AMFステッチ  0000503:無し 0000502:有り
				jQuery(":radio[name='optionGiletStandardInfo.ogStitch'][value='0000503']").prop("checked", "checked");
			}else{
				jQuery(":radio[name='optionGiletStandardInfo.ogStitch'][value='0000502']").prop("checked", "checked");
			}
		})
	} else if (item == "04") {
		jQuery('#og_stitch_id2').prop("disabled", false);
		jQuery('#og_stitch_id1').prop("disabled", false);
		jQuery('#og_backLiningMate').prop("disabled", false);
		jQuery('#og_backLiningMateStkNo').prop("disabled", false);
		jQuery('#og_insideLiningMate').prop("disabled", true);
		jQuery('#og_insideLiningMateStkNo').prop("disabled", true);
		jQuery('#og_frontBtnMate').prop("disabled", false);
		jQuery('#og_frontBtnMateStkNo').prop("disabled", false);
		jQuery('#giletModel').prop("disabled", false);
	} else if (item == "03") {
		jQuery('#op_pantsModel').prop("disabled", false);
		jQuery('#op_btnMate').prop("disabled", false);
		jQuery('#op_btnMateStkNo').prop("disabled", false);
		
	}
}

jQuery('#jacketModel').change(function (){
	
	var item = jQuery('#item option:selected').val();
	
	var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
	var hasTwoPants = jQuery('input[name="productSparePantsClass"]:checked').val();
	
	if (item == "01") {
		var jacketModel = jQuery(this).val();
		jQuery('#op_pantsModel').val(jacketModel);
		jQuery('#op_pantsModel').change();
		if(threePiece == '0009902'){
			jQuery('#giletModel').val(jacketModel);
			jQuery('#giletModel').change();
		}
		if(hasTwoPants == '0009902'){
			jQuery('#op2_pantsModel').val(jacketModel);
			jQuery('#op2_pantsModel').change();
		}
	}
})

//--------------------------------------------
//素材変更時の連動制御
//--------------------------------------------
jQuery('#bodyBackMate').change(function (){
	var item = jQuery('#item option:selected').val();
	if (item == "01") {
		var sValue = jQuery('#bodyBackMate option:selected').val();
		jQuery('#og_backLiningMate').val(sValue);
		jQuery('#og_backLiningMate').change();
		jQuery('#og_insideLiningMateStkNo').prop("disabled","disabled");
		jQuery('#og_backLiningMateStkNo').prop("disabled","disabled");
	}
});

jQuery('#bodyBackMateStkNo').change(function (){
	var item = jQuery('#item option:selected').val();
	if (item == "01") {
		var sValue = jQuery('#bodyBackMateStkNo option:selected').val();
		jQuery('#og_backLiningMateStkNo').val(sValue);
		jQuery('#og_backLiningMateStkNo').change();
	}
});

jQuery('#og_backLiningMate').change(function (){
	var sValue = jQuery('#og_backLiningMate option:selected').val();
	jQuery('#og_insideLiningMate').val(sValue);
	jQuery('#og_insideLiningMate').change();
	jQuery('#og_insideLiningMateStkNo').prop("disabled","disabled");
});

jQuery('#og_backLiningMateStkNo').change(function (){
	var sValue = jQuery('#og_backLiningMateStkNo option:selected').val();
	jQuery('#og_insideLiningMateStkNo').val(sValue);
	jQuery('#og_insideLiningMateStkNo').change();
});


jQuery('#btnMate').change(function (){
	var item = jQuery('#item option:selected').val();
	if (item == "01") {
		var sValue = jQuery('#btnMate option:selected').val();
		if(sValue == "3000400"){
			swal({
				text: getMsg('msg126'),
				icon: "info"
			})
		}
		jQuery('#og_frontBtnMate').val(sValue);
		jQuery('#og_frontBtnMate').change();
		jQuery('#op_btnMate').val(sValue);
		jQuery('#op_btnMate').change();
		jQuery('#op2_btnMate').val(sValue);
		jQuery('#op2_btnMate').change();

		jQuery('#op_btnMateStkNo').prop("disabled","disabled");
		jQuery('#op2_btnMateStkNo').prop("disabled","disabled");
		jQuery('#og_frontBtnMateStkNo').prop("disabled","disabled");
	} 
});

jQuery(":radio[name='optionJacketStandardInfo.ojStitch']").click(function(){
	var item = jQuery("#item").val();
	if(item == "01"){
		var ojStitch = jQuery('input[name="optionJacketStandardInfo.ojStitch"]:checked').val();
		//JACKET:AMFステッチ  0002302:無し 0002305:有り
		if(ojStitch=='0002302'){
			//GILET:AMFステッチ  0000503:無し 0000502:有り
			jQuery(":radio[name='optionGiletStandardInfo.ogStitch'][value='0000503']").prop("checked", "checked");
			jQuery(":radio[name='optionGiletStandardInfo.ogStitch']:checked").change();
		}else{
			jQuery(":radio[name='optionGiletStandardInfo.ogStitch'][value='0000502']").prop("checked", "checked");
			jQuery(":radio[name='optionGiletStandardInfo.ogStitch']:checked").change();
		}
	}
})

jQuery('#btnMateStkNo').change(function (){
	var item = jQuery('#item option:selected').val();
	if (item == "01") {
		var sValue = jQuery('#btnMateStkNo option:selected').val();
		jQuery('#og_frontBtnMateStkNo').val(sValue);
		jQuery('#og_frontBtnMateStkNo').change();
		jQuery('#op_btnMateStkNo').val(sValue);
		jQuery('#op_btnMateStkNo').change();
		jQuery('#op2_btnMateStkNo').val(sValue);
		jQuery('#op2_btnMateStkNo').change();
	} 
});


//--------------------------------------------
// 補正タブ用
//--------------------------------------------
function setFont(id) {
	var color = "black";
	var value = jQuery('#'+id).val() - 0;
	if (value < 0) {
		color = "red";
	} else if (value > 0) {
		color = "blue";
	}
	jQuery('#'+id).parent().css("color", color);
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

//メジャーリングの初期化
//--------------------------------------------
function orderFormMeasuring(){
	
	var measuringList = [
		{type:"fullLength",size:"${orderForm.measuringInfo.fullLength}"},
		{type:"shoulder",size:"${orderForm.measuringInfo.shoulder}"},
		{type:"reachRight",size:"${orderForm.measuringInfo.reachRight}"},
		{type:"reachLeft",size:"${orderForm.measuringInfo.reachLeft}"},
		{type:"outBust",size:"${orderForm.measuringInfo.outBust}"},
		{type:"bust",size:"${orderForm.measuringInfo.bust}"},
		{type:"jacketWaist",size:"${orderForm.measuringInfo.jacketWaist}"},
		{type:"pantsWaist",size:"${orderForm.measuringInfo.pantsWaist}"},
		{type:"hip",size:"${orderForm.measuringInfo.hip}"},
		{type:"spanRight",size:"${orderForm.measuringInfo.spanRight}"},
		{type:"spanLeft",size:"${orderForm.measuringInfo.spanLeft}"},
		{type:"calfRight",size:"${orderForm.measuringInfo.calfRight}"},
		{type:"calfLeft",size:"${orderForm.measuringInfo.calfLeft}"},
		{type:"neck",size:"${orderForm.measuringInfo.neck}"}
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

//--------------------------------------------
//補正の初期化
//--------------------------------------------
function adjustInit(){
	//補正
	//JKサイズを設定
	var selectJacketFigure = "${order.corJkDrop}";
	var selectJacketNumber = "${order.corJkSize}";
	jQuery("#selectJacketFigure").val(selectJacketFigure);
	jQuery("#selectJacketNumber").val(selectJacketNumber);
	
	//JK 型サイズ値、補正値とグロス値を設定
	var corJkBodySize = "${order.corJkBodylengthSize}";
	jQuery("#corJkBody_div_Size").val(corJkBodySize);
	var corJkBodyGross = "${order.corJkBodylengthGross}";
	jQuery("#corJkBody_div_Gross").val(corJkBodyGross);
	if(corJkBodyGross!=""){
		jQuery("#corJkBody_div_html").html(corJkBodyGross+"cm");
	}
	var corJkBodyCorrect = "${order.corJkBodylengthCorrect}";
	jQuery("#corJkBodyRange_out").html(corJkBodyCorrect);
	jQuery("#corJkBodyRange").val(corJkBodyCorrect);
	setFont("corJkBodyRange");
	
	var corJkWaistSize = "${order.corJkWaistSize}";
	jQuery("#corJkWaist_div_Size").val(corJkWaistSize);
	var corJkWaistGross = "${order.corJkWaistGross}";
	jQuery("#corJkWaist_div_Gross").val(corJkWaistGross);
	if(corJkWaistGross!=""){
		jQuery("#corJkWaist_div_html").html(corJkWaistGross+"cm");
	}
	var corJkWaistCorrect = "${order.corJkWaistCorrect}";
	jQuery("#corJkWaistRange_out").html(corJkWaistCorrect);
	jQuery("#corJkWaistRange").val(corJkWaistCorrect);
	setFont("corJkWaistRange");

	var corJkRightsleeveSize = "${order.corJkRightsleeveSize}";
	jQuery("#corJkRightsleeve_div_Size").val(corJkRightsleeveSize);
	var corJkRightsleeveGross = "${order.corJkRightsleeveGross}";
	jQuery("#corJkRightsleeve_div_Gross").val(corJkRightsleeveGross);
	if(corJkRightsleeveGross!=""){
		jQuery("#corJkRightsleeve_div_html").html(corJkRightsleeveGross+"cm");
	}
	var corJkRightsleeveCorrect = "${order.corJkRightsleeveCorrect}";
	jQuery("#corJkRightsleeveRange_out").html(corJkRightsleeveCorrect);
	jQuery("#corJkRightsleeveRange").val(corJkRightsleeveCorrect);
	setFont("corJkRightsleeveRange");

	var corJkLeftsleeveSize = "${order.corJkLeftsleeveSize}";
	jQuery("#corJkLeftsleeve_div_Size").val(corJkLeftsleeveSize);
	var corJkLeftsleeveGross = "${order.corJkLeftsleeveGross}";
	jQuery("#corJkLeftsleeve_div_Gross").val(corJkLeftsleeveGross);
	if(corJkLeftsleeveGross!=""){
		jQuery("#corJkLeftsleeve_div_html").html(corJkLeftsleeveGross+"cm");
	}
	var corJkLeftsleeveCorrect = "${order.corJkLeftsleeveCorrect}";
	jQuery("#corJkLeftsleeveRange_out").html(corJkLeftsleeveCorrect);
	jQuery("#corJkLeftsleeveRange").val(corJkLeftsleeveCorrect);
	setFont("corJkLeftsleeveRange");
	
	//PTサイズを設定
	var selectPantsFigure = "${order.corPtDrop}";
	var selectPantsNumber = "${order.corPtSize}";
	jQuery("#selectPantsFigure").val(selectPantsFigure);
	jQuery("#selectPantsNumber").val(selectPantsNumber);
	
	//PT　型サイズ値、補正値とグロス値を設定
	var corPtWaistSize = "${order.corPtWaistSize}";
	jQuery("#corPtWaist_div_Size").val(corPtWaistSize);
	var corPtWaistGross = "${order.corPtWaistGross}";
	jQuery("#corPtWaist_div_Gross").val(corPtWaistGross);
	if(corPtWaistGross!=""){
		jQuery("#corPtWaist_div_html").html(corPtWaistGross+"cm");
	}
	var corPtWaistCorrect = "${order.corPtWaistCorrect}";
	jQuery("#corPtWaistRange_out").html(corPtWaistCorrect);
	jQuery("#corPtWaistRange").val(corPtWaistCorrect);
	setFont("corPtWaistRange");
	
	var corPtThighSize = "${order.corPtThighwidthSize}";
	jQuery("#corPtThigh_div_Size").val(corPtThighSize);
	var corPtThighGross = "${order.corPtThighwidthGross}";
	jQuery("#corPtThigh_div_Gross").val(corPtThighGross);
	if(corPtThighGross!=""){
		jQuery("#corPtThigh_div_html").html(corPtThighGross+"cm");
	}
	var corPtThighCorrect = "${order.corPtThighwidthCorrect}";
	jQuery("#corPtThighRange_out").html(corPtThighCorrect);
	jQuery("#corPtThighRange").val(corPtThighCorrect);
	setFont("corPtThighRange");

	var corPtHemwidthSize = "${order.corPtHemwidthSize}";
	jQuery("#corPtHemwidth_div_Size").val(corPtHemwidthSize);
	var corPtHemwidthGross = "${order.corPtHemwidthGross}";
	jQuery("#corPtHemwidth_div_Gross").val(corPtHemwidthGross);
	if(corPtHemwidthGross!=""){
		jQuery("#corPtHemwidth_div_html").html(corPtHemwidthGross+"cm");
	}
	var corPtHemwidthCorrect = "${order.corPtHemwidthCorrect}";
	jQuery("#corPtHemwidthRange_out").html(corPtHemwidthCorrect);
	jQuery("#corPtHemwidthRange").val(corPtHemwidthCorrect);
	setFont("corPtHemwidthRange");

	var corPtRightinseamSize = "${order.corPtRightinseamSize}";
	jQuery("#corPtRightinseam_div_Size").val(corPtRightinseamSize);	
	
	var corPtRightinseamGross = "${order.corPtRightinseamGross}";
	jQuery("#corPtRightinseamGross").val(corPtRightinseamGross);	
	corPtRightinseamGross = corPtRightinseamGross.split(".");
	if(isNotEmpty(corPtRightinseamGross[1])){
		jQuery("#ap_inseamRightM1").val(corPtRightinseamGross[1]);
	}
	var str = corPtRightinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var right1 = str[2];
		var right10 = str[1];
		var right100 = str[0];
		jQuery("#ap_inseamRight100").val(right100);
		jQuery("#ap_inseamRight10").val(right10);
		jQuery("#ap_inseamRight1").val(right1);
	}else if(str.length == 2){
		str = str.split("");
		var right1 = str[1];
		var right10 = str[0];
		jQuery("#ap_inseamRight100").val("0");
		jQuery("#ap_inseamRight10").val(right10);
		jQuery("#ap_inseamRight1").val(right1);
	}else if(str.length == 1){
		str = str.split("");
		var right1 = str[0];
		jQuery("#ap_inseamRight100").val("0");
		jQuery("#ap_inseamRight10").val("0");
		jQuery("#ap_inseamRight1").val(right1);
	}

	var corPtLeftinseamSize = "${order.corPtLeftinseamSize}";
	jQuery("#corPtLeftinseam_div_Size").val(corPtLeftinseamSize);
	var corPtLeftinseamGross = "${order.corPtLeftinseamGross}";
	jQuery("#corPtLeftinseamGross").val(corPtLeftinseamGross);
	corPtLeftinseamGross = corPtLeftinseamGross.split(".");
	if(isNotEmpty(corPtLeftinseamGross[1])){
		jQuery("#ap_inseamLeftM1").val(corPtLeftinseamGross[1]);
	}
	var str = corPtLeftinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var left1 = str[2];
		var left10 = str[1];
		var left100 = str[0];
		jQuery("#ap_inseamLeft100").val(left100);
		jQuery("#ap_inseamLeft10").val(left10);
		jQuery("#ap_inseamLeft1").val(left1);
	}else if(str.length == 2){
		str = str.split("");
		var left1 = str[1];
		var left10 = str[0];
		jQuery("#ap_inseamLeft100").val("0");
		jQuery("#ap_inseamLeft10").val(left10);
		jQuery("#ap_inseamLeft1").val(left1);
	}else if(str.length == 1){
		str = str.split("");
		var left1 = str[0];
		jQuery("#ap_inseamLeft100").val("0");
		jQuery("#ap_inseamLeft10").val("0");
		jQuery("#ap_inseamLeft1").val(left1);
	}
	
	
	//2PTサイズを設定
	var selectPants2Figure = "${order.corPt2Drop}";
	var selectPants2Number = "${order.corPt2Size}";
	jQuery("#selectPants2Figure").val(selectPants2Figure);
	jQuery("#selectPants2Number").val(selectPants2Number);
	
	//2PT　型サイズ値、補正値とグロス値を設定
	var corPt2WaistSize = "${order.corPt2WaistSize}";
	jQuery("#corPt2Waist_div_Size").val(corPt2WaistSize);
	var corPt2WaistGross = "${order.corPt2WaistGross}";
	jQuery("#corPt2Waist_div_Gross").val(corPt2WaistGross);
	if(corPt2WaistGross!=""){
		jQuery("#corPt2Waist_div_html").html(corPt2WaistGross+"cm");
	}
	var corPt2WaistCorrect = "${order.corPt2WaistCorrect}";
	jQuery("#corPt2WaistRange_out").html(corPt2WaistCorrect);
	jQuery("#corPt2WaistRange").val(corPt2WaistCorrect);
	setFont("corPt2WaistRange");
	
	var corPt2ThighSize = "${order.corPt2ThighwidthSize}";
	jQuery("#corPt2Thigh_div_Size").val(corPt2ThighSize);
	var corPt2ThighGross = "${order.corPt2ThighwidthGross}";
	jQuery("#corPt2Thigh_div_Gross").val(corPt2ThighGross);
	if(corPt2ThighGross!=""){
		jQuery("#corPt2Thigh_div_html").html(corPt2ThighGross+"cm");
	}
	var corPt2ThighCorrect = "${order.corPt2ThighwidthCorrect}";
	jQuery("#corPt2ThighRange_out").html(corPt2ThighCorrect);
	jQuery("#corPt2ThighRange").val(corPt2ThighCorrect);
	setFont("corPt2ThighRange");

	var corPt2HemwidthSize = "${order.corPt2HemwidthSize}";
	jQuery("#corPt2Hemwidth_div_Size").val(corPt2HemwidthSize);
	var corPt2HemwidthGross = "${order.corPt2HemwidthGross}";
	jQuery("#corPt2Hemwidth_div_Gross").val(corPt2HemwidthGross);
	if(corPt2HemwidthGross!=""){
		jQuery("#corPt2Hemwidth_div_html").html(corPt2HemwidthGross+"cm");
	}
	var corPt2HemwidthCorrect = "${order.corPt2HemwidthCorrect}";
	jQuery("#corPt2HemwidthRange_out").html(corPt2HemwidthCorrect);
	jQuery("#corPt2HemwidthRange").val(corPt2HemwidthCorrect);
	setFont("corPt2HemwidthRange");

	var corPt2RightinseamSize = "${order.corPt2RightinseamSize}";
	jQuery("#corPt2Rightinseam_div_Size").val(corPt2RightinseamSize);	
	
	var corPt2RightinseamGross = "${order.corPt2RightinseamGross}";
	jQuery("#corPt2RightinseamGross").val(corPt2RightinseamGross);
	corPt2RightinseamGross = corPt2RightinseamGross.split(".");
	if(isNotEmpty(corPt2RightinseamGross[1])){
		jQuery("#ap2_inseamRightM1").val(corPt2RightinseamGross[1]);
	}
	var str = corPt2RightinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var right1 = str[2];
		var right10 = str[1];
		var right100 = str[0];
		jQuery("#ap2_inseamRight100").val(right100);
		jQuery("#ap2_inseamRight10").val(right10);
		jQuery("#ap2_inseamRight1").val(right1);
	}else if(str.length == 2){
		str = str.split("");
		var right1 = str[1];
		var right10 = str[0];
		jQuery("#ap2_inseamRight100").val("0");
		jQuery("#ap2_inseamRight10").val(right10);
		jQuery("#ap2_inseamRight1").val(right1);
	}else if(str.length == 1){
		str = str.split("");
		var right1 = str[0];
		jQuery("#ap2_inseamRight100").val("0");
		jQuery("#ap2_inseamRight10").val("0");
		jQuery("#ap2_inseamRight1").val(right1);
	}
	
	var corPt2LeftinseamSize = "${order.corPt2LeftinseamSize}";
	jQuery("#corPt2Leftinseam_div_Size").val(corPt2LeftinseamSize);
	
	var corPt2LeftinseamGross = "${order.corPt2LeftinseamGross}";
	jQuery("#corPt2LeftinseamGross").val(corPt2LeftinseamGross);
	corPt2LeftinseamGross = corPt2LeftinseamGross.split(".");
	if(isNotEmpty(corPt2LeftinseamGross[1])){
		jQuery("#ap2_inseamLeftM1").val(corPt2LeftinseamGross[1])
	}
	var str = corPt2LeftinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var left1 = str[2];
		var left10 = str[1];
		var left100 = str[0];
		jQuery("#ap2_inseamLeft100").val(left100);
		jQuery("#ap2_inseamLeft10").val(left10);
		jQuery("#ap2_inseamLeft1").val(left1);
	}else if(str.length == 2){
		str = str.split("");
		var left1 = str[1];
		var left10 = str[0];
		jQuery("#ap2_inseamLeft100").val("0");
		jQuery("#ap2_inseamLeft10").val(left10);
		jQuery("#ap2_inseamLeft1").val(left1);
	}else if(str.length == 1){
		str = str.split("");
		var left1 = str[0];
		jQuery("#ap2_inseamLeft100").val("0");
		jQuery("#ap2_inseamLeft10").val("0");
		jQuery("#ap2_inseamLeft1").val(left1);
	}
	
	
	//GLサイズを設定
	var selectGiletFigure = "${order.corGlDrop}";
	var selectGiletNumber = "${order.corGlSize}";
	jQuery("#selectGiletFigure").val(selectGiletFigure);
	jQuery("#selectGiletNumber").val(selectGiletNumber);
}

function adjustBackInit(){
	
	//JKサイズを設定
	var selectJacketFigure = "${orderForm.adjustJacketStandardInfo.sizeFigure}";
	var selectJacketNumber = "${orderForm.adjustJacketStandardInfo.sizeNumber}";
	jQuery("#selectJacketFigure").val(selectJacketFigure);
	jQuery("#selectJacketNumber").val(selectJacketNumber);

	//JK 型サイズ値、補正値とグロス値を設定
	var corJkBodySize = "${orderForm.adjustJacketStandardInfo.corJkBodySize}";
	jQuery("#corJkBody_div_Size").val(corJkBodySize);
	var corJkBodyGross = "${orderForm.adjustJacketStandardInfo.corJkBodyGross}";
	jQuery("#corJkBody_div_Gross").val(corJkBodyGross);
	if(corJkBodyGross!=""){
		jQuery("#corJkBody_div_html").html(corJkBodyGross+"cm");
	}
	var corJkBodyCorrect = "${orderForm.adjustJacketStandardInfo.corJkBodyCorrect}";
	
	jQuery("#corJkBodyRange_out").html(corJkBodyCorrect);
	jQuery("#corJkBodyRange").val(corJkBodyCorrect);
	setFont("corJkBodyRange");
	
	var corJkWaistSize = "${orderForm.adjustJacketStandardInfo.corJkWaistSize}";
	jQuery("#corJkWaist_div_Size").val(corJkWaistSize);
	var corJkWaistGross = "${orderForm.adjustJacketStandardInfo.corJkWaistGross}";
	jQuery("#corJkWaist_div_Gross").val(corJkWaistGross);
	if(corJkWaistGross!=""){
		jQuery("#corJkWaist_div_html").html(corJkWaistGross+"cm");
	}
	var corJkWaistCorrect = "${orderForm.adjustJacketStandardInfo.corJkWaistCorrect}";
	jQuery("#corJkWaistRange_out").html(corJkWaistCorrect);
	jQuery("#corJkWaistRange").val(corJkWaistCorrect);
	setFont("corJkWaistRange");

	var corJkRightsleeveSize = "${orderForm.adjustJacketStandardInfo.corJkRightsleeveSize}";
	jQuery("#corJkRightsleeve_div_Size").val(corJkRightsleeveSize);
	var corJkRightsleeveGross = "${orderForm.adjustJacketStandardInfo.corJkRightsleeveGross}";
	jQuery("#corJkRightsleeve_div_Gross").val(corJkRightsleeveGross);
	if(corJkRightsleeveGross!=""){
		jQuery("#corJkRightsleeve_div_html").html(corJkRightsleeveGross+"cm");
	}
	var corJkRightsleeveCorrect = "${orderForm.adjustJacketStandardInfo.corJkRightsleeveCorrect}";
	jQuery("#corJkRightsleeveRange_out").html(corJkRightsleeveCorrect);
	jQuery("#corJkRightsleeveRange").val(corJkRightsleeveCorrect);
	setFont("corJkRightsleeveRange");

	var corJkLeftsleeveSize = "${orderForm.adjustJacketStandardInfo.corJkLeftsleeveSize}";
	jQuery("#corJkLeftsleeve_div_Size").val(corJkLeftsleeveSize);
	var corJkLeftsleeveGross = "${orderForm.adjustJacketStandardInfo.corJkLeftsleeveGross}";
	jQuery("#corJkLeftsleeve_div_Gross").val(corJkLeftsleeveGross);
	if(corJkLeftsleeveGross!=""){
		jQuery("#corJkLeftsleeve_div_html").html(corJkLeftsleeveGross+"cm");
	}
	var corJkLeftsleeveCorrect = "${orderForm.adjustJacketStandardInfo.corJkLeftsleeveCorrect}";
	jQuery("#corJkLeftsleeveRange_out").html(corJkLeftsleeveCorrect);
	jQuery("#corJkLeftsleeveRange").val(corJkLeftsleeveCorrect);
	setFont("corJkLeftsleeveRange");

	//PTサイズを設定
	var selectPantsFigure = "${orderForm.adjustPantsStandardInfo.sizeFigure}";
	var selectPantsNumber = "${orderForm.adjustPantsStandardInfo.sizeNumber}";
	jQuery("#selectPantsFigure").val(selectPantsFigure);
	jQuery("#selectPantsNumber").val(selectPantsNumber);
	
	//PT　型サイズ値、補正値とグロス値を設定
	var corPtWaistSize = "${orderForm.adjustPantsStandardInfo.corPtWaistSize}";
	jQuery("#corPtWaist_div_Size").val(corPtWaistSize);
	var corPtWaistGross = "${orderForm.adjustPantsStandardInfo.corPtWaistGross}";
	jQuery("#corPtWaist_div_Gross").val(corPtWaistGross);
	if(corPtWaistGross!=""){
		jQuery("#corPtWaist_div_html").html(corPtWaistGross+"cm");
	}
	var corPtWaistCorrect = "${orderForm.adjustPantsStandardInfo.corPtWaistCorrect}";
	jQuery("#corPtWaistRange_out").html(corPtWaistCorrect);
	jQuery("#corPtWaistRange").val(corPtWaistCorrect);
	setFont("corPtWaistRange");
	
	var corPtThighSize = "${orderForm.adjustPantsStandardInfo.corPtThighSize}";
	jQuery("#corPtThigh_div_Size").val(corPtThighSize);
	var corPtThighGross = "${orderForm.adjustPantsStandardInfo.corPtThighGross}";
	jQuery("#corPtThigh_div_Gross").val(corPtThighGross);
	if(corPtThighGross!=""){
		jQuery("#corPtThigh_div_html").html(corPtThighGross+"cm");
	}
	var corPtThighCorrect = "${orderForm.adjustPantsStandardInfo.corPtThighCorrect}";
	jQuery("#corPtThighRange_out").html(corPtThighCorrect);
	jQuery("#corPtThighRange").val(corPtThighCorrect);
	setFont("corPtThighRange");

	var corPtHemwidthSize = "${orderForm.adjustPantsStandardInfo.corPtHemwidthSize}";
	jQuery("#corPtHemwidth_div_Size").val(corPtHemwidthSize);
	var corPtHemwidthGross = "${orderForm.adjustPantsStandardInfo.corPtHemwidthGross}";
	jQuery("#corPtHemwidth_div_Gross").val(corPtHemwidthGross);
	if(corPtHemwidthGross!=""){
		jQuery("#corPtHemwidth_div_html").html(corPtHemwidthGross+"cm");
	}
	var corPtHemwidthCorrect = "${orderForm.adjustPantsStandardInfo.corPtHemwidthCorrect}";
	jQuery("#corPtHemwidthRange_out").html(corPtHemwidthCorrect);
	jQuery("#corPtHemwidthRange").val(corPtHemwidthCorrect);
	setFont("corPtHemwidthRange");
	
	var corPtRightinseamSize = "${orderForm.adjustPantsStandardInfo.corPtRightinseamSize}";
	jQuery("#corPtRightinseam_div_Size").val(corPtRightinseamSize);
	var corPtRightinseamGross = "${orderForm.adjustPantsStandardInfo.corPtRightinseamGross}";
	jQuery("#corPtRightinseamGross").val(corPtRightinseamGross);	
	corPtRightinseamGross = corPtRightinseamGross.split(".");
	if(isNotEmpty(corPtRightinseamGross[1])){
		jQuery("#ap_inseamRightM1").val(corPtRightinseamGross[1]);
	}
	var str = corPtRightinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var right1 = str[2];
		var right10 = str[1];
		var right100 = str[0];
		jQuery("#ap_inseamRight100").val(right100);
		jQuery("#ap_inseamRight10").val(right10);
		jQuery("#ap_inseamRight1").val(right1);
	}else if(str.length == 2){
		str = str.split("");
		var right1 = str[1];
		var right10 = str[0];
		jQuery("#ap_inseamRight100").val("0");
		jQuery("#ap_inseamRight10").val(right10);
		jQuery("#ap_inseamRight1").val(right1);
	}else if(str.length == 1){
		str = str.split("");
		var right1 = str[0];
		jQuery("#ap_inseamRight100").val("0");
		jQuery("#ap_inseamRight10").val("0");
		jQuery("#ap_inseamRight1").val(right1);
	}

	var corPtLeftinseamSize = "${orderForm.adjustPantsStandardInfo.corPtLeftinseamSize}";
	jQuery("#corPtLeftinseam_div_Size").val(corPtLeftinseamSize);
	var corPtLeftinseamGross = "${orderForm.adjustPantsStandardInfo.corPtLeftinseamGross}";
	jQuery("#corPtLeftinseamGross").val(corPtLeftinseamGross);
	corPtLeftinseamGross = corPtLeftinseamGross.split(".");
	if(isNotEmpty(corPtLeftinseamGross[1])){
		jQuery("#ap_inseamLeftM1").val(corPtLeftinseamGross[1]);
	}
	var str = corPtLeftinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var left1 = str[2];
		var left10 = str[1];
		var left100 = str[0];
		jQuery("#ap_inseamLeft100").val(left100);
		jQuery("#ap_inseamLeft10").val(left10);
		jQuery("#ap_inseamLeft1").val(left1);
	}else if(str.length == 2){
		str = str.split("");
		var left1 = str[1];
		var left10 = str[0];
		jQuery("#ap_inseamLeft100").val("0");
		jQuery("#ap_inseamLeft10").val(left10);
		jQuery("#ap_inseamLeft1").val(left1);
	}else if(str.length == 1){
		str = str.split("");
		var left1 = str[0];
		jQuery("#ap_inseamLeft100").val("0");
		jQuery("#ap_inseamLeft10").val("0");
		jQuery("#ap_inseamLeft1").val(left1);
	}

	//2PTサイズを設定
	var selectPants2Figure = "${orderForm.adjustPants2StandardInfo.sizeFigure}";
	var selectPants2Number = "${orderForm.adjustPants2StandardInfo.sizeNumber}";
	jQuery("#selectPants2Figure").val(selectPants2Figure);
	jQuery("#selectPants2Number").val(selectPants2Number);
	
	//2PT　型サイズ値、補正値とグロス値を設定
	var corPt2WaistSize = "${orderForm.adjustPants2StandardInfo.corPt2WaistSize}";
	jQuery("#corPt2Waist_div_Size").val(corPt2WaistSize);
	var corPt2WaistGross = "${orderForm.adjustPants2StandardInfo.corPt2WaistGross}";
	jQuery("#corPt2Waist_div_Gross").val(corPt2WaistGross);
	if(corPt2WaistGross!=""){
		jQuery("#corPt2Waist_div_html").html(corPt2WaistGross+"cm");
	}
	var corPt2WaistCorrect = "${orderForm.adjustPants2StandardInfo.corPt2WaistCorrect}";
	jQuery("#corPt2WaistRange_out").html(corPt2WaistCorrect);
	jQuery("#corPt2WaistRange").val(corPt2WaistCorrect);
	setFont("corPt2WaistRange");
	
	var corPt2ThighSize = "${orderForm.adjustPants2StandardInfo.corPt2ThighSize}";
	jQuery("#corPt2Thigh_div_Size").val(corPt2ThighSize);
	var corPt2ThighGross = "${orderForm.adjustPants2StandardInfo.corPt2ThighGross}";
	jQuery("#corPt2Thigh_div_Gross").val(corPt2ThighGross);
	if(corPt2ThighGross!=""){
		jQuery("#corPt2Thigh_div_html").html(corPt2ThighGross+"cm");
	}
	var corPt2ThighCorrect = "${orderForm.adjustPants2StandardInfo.corPt2ThighCorrect}";
	jQuery("#corPt2ThighRange_out").html(corPt2ThighCorrect);
	jQuery("#corPt2ThighRange").val(corPt2ThighCorrect);
	setFont("corPt2ThighRange");

	var corPt2HemwidthSize = "${orderForm.adjustPants2StandardInfo.corPt2HemwidthSize}";
	jQuery("#corPt2Hemwidth_div_Size").val(corPt2HemwidthSize);
	var corPt2HemwidthGross = "${orderForm.adjustPants2StandardInfo.corPt2HemwidthGross}";
	jQuery("#corPt2Hemwidth_div_Gross").val(corPt2HemwidthGross);
	if(corPt2HemwidthGross!=""){
		jQuery("#corPt2Hemwidth_div_html").html(corPt2HemwidthGross+"cm");
	}
	var corPt2HemwidthCorrect = "${orderForm.adjustPants2StandardInfo.corPt2HemwidthCorrect}";
	jQuery("#corPt2HemwidthRange_out").html(corPt2HemwidthCorrect);
	jQuery("#corPt2HemwidthRange").val(corPt2HemwidthCorrect);
	setFont("corPt2HemwidthRange");


	var corPt2RightinseamSize = "${orderForm.adjustPants2StandardInfo.corPt2RightinseamSize}";
	jQuery("#corPt2Rightinseam_div_Size").val(corPt2RightinseamSize);
	var corPt2RightinseamGross = "${orderForm.adjustPants2StandardInfo.corPt2RightinseamGross}";
	jQuery("#corPt2RightinseamGross").val(corPt2RightinseamGross);
	corPt2RightinseamGross = corPt2RightinseamGross.split(".");
	if(isNotEmpty(corPt2RightinseamGross[1])){
		jQuery("#ap2_inseamRightM1").val(corPt2RightinseamGross[1]);
	}
	var str = corPt2RightinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var right1 = str[2];
		var right10 = str[1];
		var right100 = str[0];
		jQuery("#ap2_inseamRight100").val(right100);
		jQuery("#ap2_inseamRight10").val(right10);
		jQuery("#ap2_inseamRight1").val(right1);
	}else if(str.length == 2){
		str = str.split("");
		var right1 = str[1];
		var right10 = str[0];
		jQuery("#ap2_inseamRight100").val("0");
		jQuery("#ap2_inseamRight10").val(right10);
		jQuery("#ap2_inseamRight1").val(right1);
	}else if(str.length == 1){
		str = str.split("");
		var right1 = str[0];
		jQuery("#ap2_inseamRight100").val("0");
		jQuery("#ap2_inseamRight10").val("0");
		jQuery("#ap2_inseamRight1").val(right1);
	}

	
	var corPt2LeftinseamSize = "${orderForm.adjustPants2StandardInfo.corPt2LeftinseamSize}";
	jQuery("#corPt2Leftinseam_div_Size").val(corPt2LeftinseamSize);
	var corPt2LeftinseamGross = "${orderForm.adjustPants2StandardInfo.corPt2LeftinseamGross}";
	jQuery("#corPt2LeftinseamGross").val(corPt2LeftinseamGross);
	corPt2LeftinseamGross = corPt2LeftinseamGross.split(".");
	if(isNotEmpty(corPt2LeftinseamGross[1])){
		jQuery("#ap2_inseamLeftM1").val(corPt2LeftinseamGross[1])
	}
	var str = corPt2LeftinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var left1 = str[2];
		var left10 = str[1];
		var left100 = str[0];
		jQuery("#ap2_inseamLeft100").val(left100);
		jQuery("#ap2_inseamLeft10").val(left10);
		jQuery("#ap2_inseamLeft1").val(left1);
	}else if(str.length == 2){
		str = str.split("");
		var left1 = str[1];
		var left10 = str[0];
		jQuery("#ap2_inseamLeft100").val("0");
		jQuery("#ap2_inseamLeft10").val(left10);
		jQuery("#ap2_inseamLeft1").val(left1);
	}else if(str.length == 1){
		str = str.split("");
		var left1 = str[0];
		jQuery("#ap2_inseamLeft100").val("0");
		jQuery("#ap2_inseamLeft10").val("0");
		jQuery("#ap2_inseamLeft1").val(left1);
	}

	//GLサイズを設定
	var selectGiletFigure = "${orderForm.adjustGiletStandardInfo.sizeFigure}";
	var selectGiletNumber = "${orderForm.adjustGiletStandardInfo.sizeNumber}";
	jQuery("#selectGiletFigure").val(selectGiletFigure);
	jQuery("#selectGiletNumber").val(selectGiletNumber);
}

//--------------------------------------------
//素材品番の初期化
//--------------------------------------------
function mateInit(){
	var itemCode;
	var subItemCode;
	var category;
	var StkNo;
	var mateChecked;
	var orderPattern = "PO";
	var optionCode;
	// 標準の場合　Jacket 胴裏素材と袖裏素材と釦素材のid List
	var jkStandardMateList = ["bodyBackMate","cuffBackMate","btnMate"];
	// 標準の場合　Gilet 背裏地素材と内側裏地素材と釦素材のid List
	var glStandardMateList = ["og_backLiningMate","og_insideLiningMate","og_frontBtnMate"];
	var item = jQuery("#item option:selected").val();
	jQuery("#category option:first").prop("selected",true);
	if(item == "01"){
		itemCode = item;
		//SUITの場合　素材品番を設定
		initSuitStandard(itemCode)
	}else if(item=="02"){
			subItemCode = "02";
			itemCode = item;
			category = jQuery("#category").val();
			if(category=="0"){
				initJkStandard(itemCode,subItemCode);
			}
			jQuery("#category").change(function(){
				initJkStandard(itemCode,subItemCode);
			});
		//PANTSの場合　素材品番を設定  
		}else if(item=="03"){
			subItemCode = "03";
			itemCode = item;
			category = jQuery("#category").val();
			if(category=="0"){
				initPtStandard(itemCode,subItemCode);
			}
			jQuery("#category").change(function(){
				initPtStandard(itemCode,subItemCode);
			});
		//GILETの場合　素材品番を設定  
		}else if(item=="04"){
			itemCode = item;
			subItemCode = "04";
			category = jQuery("#category").val();
			if(category=="0"){
				initGlStandard(itemCode,subItemCode);
			}
			jQuery("#category").change(function(){
				category = jQuery("#category").val();
				initGlStandard(itemCode,subItemCode);
			});
		//SUITの場合　素材品番を設定  
		}
	//})
	
	function initSuitStandard(itemCode){
		subItemCode = "02";
		initJkStandard(itemCode,subItemCode);
		subItemCode = "03";
		initPtStandard(itemCode,subItemCode);
		subItemCode = "04";
		initGlStandard(itemCode,subItemCode);
		subItemCode = "07";
		initPt2Standard(itemCode,subItemCode);
	}
			
	function initGlStandard(itemCode,subItemCode){
		for(var i in glStandardMateList){
			optionCode = selectIdList[glStandardMateList[i]];
			mateChecked = jQuery("#"+glStandardMateList[i]+" option:checked").val();
			StkNo = "#"+glStandardMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,0,orderPattern);
		}
		jQuery("#og_backLiningMate,#og_insideLiningMate,#og_frontBtnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			optionCode = selectIdList[idValue];
			mateChecked = jQuery("#"+idValue+" option:checked").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,0,orderPattern);
		})	
	}
	function initPtStandard(itemCode,subItemCode) {
		mateChecked = jQuery("#op_btnMate option:checked").val();
		optionCode = selectIdList["op_btnMate"];
		StkNo = "#op_btnMateStkNo";
		mateSelect(itemCode,subItemCode, mateChecked,optionCode,StkNo,0,orderPattern);
		jQuery("#op_btnMate").change(function() {
			optionCode = selectIdList["op_btnMate"];
			mateChecked = jQuery("#op_btnMate option:checked").val();
			StkNo = "#op_btnMateStkNo";
			mateSelect(itemCode,subItemCode, mateChecked,optionCode,StkNo,0,orderPattern);
		})
	}
	function initPt2Standard(itemCode,subItemCode) {
		mateChecked = jQuery("#op2_btnMate option:checked").val();
		optionCode = selectIdList["op2_btnMate"];
		StkNo = "#op2_btnMateStkNo";
		mateSelect(itemCode,subItemCode, mateChecked,optionCode,StkNo,0,orderPattern);
		jQuery("#op2_btnMate").change(function() {
			optionCode = selectIdList["op2_btnMate"];
			mateChecked = jQuery("#op2_btnMate option:checked").val();
			StkNo = "#op2_btnMateStkNo";
			mateSelect(itemCode,subItemCode, mateChecked,optionCode,StkNo,0,orderPattern);
		})
	}	
	function initJkStandard(itemCode,subItemCode){
		for(var i in jkStandardMateList){
			optionCode = selectIdList[jkStandardMateList[i]];
			mateChecked = jQuery("#"+jkStandardMateList[i]+" option:checked").val();
			StkNo = "#"+jkStandardMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,0,orderPattern);
		}
		jQuery("#bodyBackMate,#cuffBackMate,#btnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			optionCode = selectIdList[idValue];
			mateChecked = jQuery("#"+idValue+" option:checked").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,0,orderPattern);
		})	
	}

	//素材によって　品番を設定
	function mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,type,orderPattern){
		var StkNoSelect = jQuery(StkNo);
		var url;
		if (type == 0){
			url = "/order/standardMateSelect";
		}else if(type == 1){
			url = "/order/tuxdoMateSelect";
		}else if(type == 2){
			url = "/order/washabiMateSelect";
		}
		jQuery.ajax({
			 type:"get",
			 url: contextPath + url,
			 async: false,
			 data:{"itemCode":itemCode,"subItemCode":subItemCode,"mateChecked":mateChecked,"orderPattern":orderPattern,"optionCode":optionCode},
			 success:function(result){
				 StkNoSelect.empty();
				 StkNoSelect.empty();
				 if(Object.keys(result).length==0){
					 StkNoSelect.prop("disabled",true);
				 }else{
					 StkNoSelect.removeAttr("disabled");
					 for (var key in result) {
						 StkNoSelect.append(jQuery('<option />').val(key).text(result[key]));
					 }
				 }
			 }
		});
	}
}

//--------------------------------------------
//日期フォーマット
//--------------------------------------------
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


//--------------------------------------------
//全部のitem金額制御
//--------------------------------------------
function getPrice(){
		var i = null;
		var jkModelCode = jQuery("#jacketModel").val();
		if(isNotEmpty(jkModelCode)){
			//JACKETの料金を表示
			jacketChangePrice(jkModelCode);
			//フロント釦数がダブルの場合
			jQuery("#oj_frontBtnCnt").change(function(){
				jacketChangePrice(jkModelCode);
			})
		}

		//PANTSの料金を表示
		var pantsModel = jQuery("#op_pantsModel").val();
		if(isNotEmpty(pantsModel)){
			for(i of ptPriceList){
				if(i.type == "2"){
					var idValue = i.id;
					var thisVal = jQuery("#"+idValue).val();
					dealWithPice(idValue,thisVal,pantsModel);
				}else if(i.type == "1"){
					var idValue = i.id;
					var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
					dealWithPice(idValue,thisVal,pantsModel);
				}
			}
		}
				
				
		//2PANTSの料金を表示
		var pants2Model = jQuery("#op2_pantsModel").val();
		if(isNotEmpty(pants2Model)){
			for(i of pt2PriceList){
				if(i.type == "2"){
					var idValue = i.id;
					var thisVal = jQuery("#"+idValue).val();
					dealWithPice(idValue,thisVal,pants2Model);
				}else if(i.type == "1"){
					var idValue = i.id;
					var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
					dealWithPice(idValue,thisVal,pants2Model);
				}
			}
		}
				
		//GILETの料金を表示
		var giletModel = jQuery("#giletModel").val();
		if(isNotEmpty(giletModel)){
			for(i of glPriceList){
				if(i.type == "2"){
					var idValue = i.id;
					var thisVal = jQuery("#"+idValue).val();
					dealWithPice(idValue,thisVal,giletModel);
				}else if(i.type == "1"){
					var idValue = i.id;
					var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
					dealWithPice(idValue,thisVal,giletModel);
				}
			}
		}

			//PANTSの料金を表示
			var pantsModel = "";
			
			jQuery("#op_pantsModel").change(function(){

				pantsModel = jQuery("#op_pantsModel").val();
				if(isNotEmpty(pantsModel)){
					for(i of ptPriceList){
						//プルダウンの場合
						if(i.type == "2"){
							var idValue = i.id;
							var thisVal = jQuery("#"+idValue).val();
							dealWithPice(idValue,thisVal,pantsModel);
						//ラジオボタンの場合	
						}else if(i.type == "1"){
							var idValue = i.id;
							var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
							dealWithPice(idValue,thisVal,pantsModel);
						}
					}
				}
			})
			//ラジオボタンの変更処理
			//項目：アジャスター仕様、エイト（滑り止め）、シック大（股補強）、形状記憶、靴ずれ
			jQuery('input[id^="op_adjuster_"],[id^="op_eight_"],[id^="op_thick_"],[id^="op_shapeMemory_"],[id^="op_blister_"]').change(function(){
				pantsModel = jQuery("#op_pantsModel").val();
				if(isNotEmpty(pantsModel)){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,pantsModel);
				}
			});
				
			//プルダウンの変更処理
			//項目：タック、裾上げ、ダブル幅、釦素材、釦素材品番
			jQuery("#op_hemUp,#op_tack,#op_doubleWide,#op_btnMate,#op_btnMateStkNo").change(function(){
				pantsModel = jQuery("#op_pantsModel").val();
				if(isNotEmpty(pantsModel)){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,pantsModel);
				}
			})
			
			//2PANTSの料金を表示
			var pants2Model = "";
			jQuery("#op2_pantsModel").change(function(){
				pants2Model = jQuery("#op2_pantsModel").val();
				if(isNotEmpty(pants2Model)){
					for(i of pt2PriceList){
						if(i.type == "2"){
							var idValue = i.id;
							var thisVal = jQuery("#"+idValue).val();
							dealWithPice(idValue,thisVal,pants2Model);
						}else if(i.type == "1"){
							var idValue = i.id;
							var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
							dealWithPice(idValue,thisVal,pants2Model);
						}
					}
				}
			})
			//ラジオボタンの変更処理
			//項目：アジャスター仕様、エイト（滑り止め）、シック大（股補強）、形状記憶、靴ずれ
			jQuery('input[id^="op2_adjuster_"],[id^="op2_eight_"],[id^="op2_thick_"],[id^="op2_shapeMemory_"],[id^="op2_blister_"]').change(function(){
				pants2Model = jQuery("#op2_pantsModel").val();
				if(isNotEmpty(pants2Model)){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,pants2Model);
				}
			});

			//プルダウンの変更処理
			//項目：タック、裾上げ、ダブル幅、釦素材、釦素材品番
			jQuery("#op2_hemUp,#op2_tack,#op2_doubleWide,#op2_btnMate,#op2_btnMateStkNo").change(function(){
				pants2Model = jQuery("#op2_pantsModel").val();
				if(isNotEmpty(pants2Model)){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,pants2Model);
				}
			})
			
			//JACKETの料金を表示
			var jacketModel = "";
			jQuery("#jacketModel").change(function(){
				jacketModel = jQuery("#jacketModel option:selected").val();
				if(isNotEmpty(jacketModel)){
					jacketChangePrice(jacketModel);
				}
			})	
			var frontBtnCntVal = "";
			//プルダウンの変更処理
			//項目：フロント釦数、胴裏素材、胴裏素材品番、袖裏素材、袖裏素材品番、釦素材、釦素材品番
			jQuery("#oj_frontBtnCnt,#bodyBackMate,#bodyBackMateStkNo,#cuffBackMate,#cuffBackMateStkNo,#btnMate,#btnMateStkNo")
			   .change(function(){
			   jacketModel = jQuery("#jacketModel option:selected").val();
			   if(isNotEmpty(jacketModel)){
				   var idValue = jQuery(this).attr("id");
				   if(idValue=='oj_frontBtnCnt'){
					   jacketChangePrice(jacketModel);
				   }
				   var thisVal = jQuery(this).val();
				   frontBtnCntVal = jQuery("#oj_frontBtnCnt").val();
				   //フロント釦数がダブルの場合
				   //ダブル6つボタン : 0000105    
				   if(frontBtnCntVal=="0000105"){
				      dealWithDoublePice(idValue,thisVal,jacketModel);
					  }else{
					     dealWithPice(idValue,thisVal,jacketModel);
					  }
				   }
			})
				
				//ラジオボタンの変更処理
				//項目：ラペルデザイン、台場、裏仕様、腰ポケット、チェンジポケット、スランテッドポケット、袖口、AMFステッチ、ベント
				jQuery('input[id^="lapelDesign_"],[id^="fort_"],[id^="backSpec_"],[id^="waistPkt_"],[id^="changePkt_"],[id^="slantedPkt_"],[id^="cuffSpec_"],[id^="stitch_"],[id^="ventSpec_"]')
				.change(function(){
					jacketModel = jQuery("#jacketModel option:selected").val();
					if(isNotEmpty(jacketModel)){
						var idValue = jQuery(this).attr("id");
						var thisVal = jQuery(this).val();
						frontBtnCntVal = jQuery("#oj_frontBtnCnt").val();
						//ダブル6つボタン : 0000105
						if(frontBtnCntVal=="0000105"){
							dealWithDoublePice(idValue,thisVal,jacketModel);
						}else{
							dealWithPice(idValue,thisVal,jacketModel);
						}
					}
				});
			 
					
			//GILETの料金を表示
			var giletModel = "";
			jQuery("#giletModel").change(function(){
				giletModel = jQuery("#giletModel").val();
				if(isNotEmpty(giletModel)){
					for(i of glPriceList){
						if(i.type == "2"){
							var idValue = i.id;
							var thisVal = jQuery("#"+idValue).val();
							dealWithPice(idValue,thisVal,giletModel);
						}else if(i.type == "1"){
							var idValue = i.id;
							var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
							dealWithPice(idValue,thisVal,giletModel);
						}
					}
				}
			})

			//ラジオボタンの変更処理
			//項目：AMFステッチ、胸ポケット、３Piece
			jQuery('input[id^="og_stitch_"],[id^="og_breastPkt_"]').change(function(){
				giletModel = jQuery("#giletModel").val();
				if(isNotEmpty(giletModel)){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,giletModel);
				}
			})
	
			//プルダウンの変更処理
			//項目：背裏地素材、背裏地素材品番、内側裏地素材、内側裏地素材品番、釦素材、釦素材品番
			jQuery("#og_backLiningMate,#og_backLiningMateStkNo,#og_insideLiningMate,#og_insideLiningMateStkNo,#og_frontBtnMate,#og_frontBtnMateStkNo")
			.change(function(){
				giletModel = jQuery("#giletModel").val();
				if(isNotEmpty(giletModel)){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,giletModel);
				}
			})
}

//--------------------------------------------
//シングル金額制御
//--------------------------------------------
function dealWithPice(idValue,thisVal,modelCode){
	//アイテムコード
	var itemCode = jQuery("#item").val();
	//*_id1 ⇒　*
	if(idValue.indexOf("_id")!=-1){
		idValue = idValue.substr(0, idValue.length - 1);
		idValue = idValue.replace("_id","");
	}
	//オプションコード
	optionCode = selectIdList[idValue];
	//サブアイテムコード
	subItemCode = subList[idValue];
	//アイテムコード + サブアイテムコード + モデルコード + オプションコード + オプション選択肢コード
	var code = itemCode + subItemCode + modelCode + optionCode  + thisVal;
	//各素材の変更処理
	if(idValue=="op_btnMate"||idValue=="op2_btnMate"||idValue=="og_backLiningMate"||idValue=="og_insideLiningMate"||idValue=="og_frontBtnMate"
		|| idValue=="bodyBackMate"||idValue=="cuffBackMate"||idValue=="btnMate"){
		var stkNo = idValue+"StkNo";
		var stkNoVal = jQuery("#"+stkNo).val();
		//アイテムコード + サブアイテムコード + モデルコード + オプションコード + オプション選択肢コード + オプション選択肢詳細コード
		var codeDetail = itemCode + subItemCode + modelCode + optionCode + thisVal + stkNoVal;
		var price = jQuery.ajax({url:contextPath + "/order/getOrderPrice",data:{"code":code,"codeDetail":codeDetail},async:false});
		price = price.responseText;
		if(price == "0"){
			price = "無料";
		}else{
			price = formatMoney(price,0,"￥");
		}
		jQuery("#"+idValue+"_Msg").html(price);
		allOptionPrice();
		
	//各素材品番の変更処理
	}else if(idValue=="bodyBackMateStkNo"||idValue=="cuffBackMateStkNo"||idValue=="btnMateStkNo"||
			idValue == "op_btnMateStkNo"||idValue=="op2_btnMateStkNo"||idValue=="og_backLiningMateStkNo"||
			idValue=="og_insideLiningMateStkNo"||idValue=="og_frontBtnMateStkNo"){
		//*StkNo　⇒　*
		idValue = idValue.substr(0, idValue.length - 5);
		
		subItemCode = subList[idValue];
		optionCode = selectIdList[idValue];
		
		var valCode = jQuery("#"+idValue).val();
		//アイテムコード + サブアイテムコード + モデルコード + オプションコード + オプション選択肢コード
		var code = itemCode + subItemCode + modelCode + optionCode  + valCode;
		//アイテムコード + サブアイテムコード + モデルコード + オプションコード + オプション選択肢コード + オプション選択肢詳細コード
		var codeDetail = itemCode + subItemCode + modelCode + optionCode + valCode + thisVal;
		var price = jQuery.ajax({url:contextPath + "/order/getOrderPrice",data:{"code":code,"codeDetail":codeDetail},async:false});
		price = price.responseText;
		if(price == "0"){
			price = "無料";
		}else{
			price = formatMoney(price,0,"￥");
		}
		jQuery("#"+idValue+"_Msg").html(price);
		allOptionPrice();
			//他の項目の変更処理
	}else{
		var price = jQuery.ajax({url:contextPath + "/order/getOrderNormalPrice",data:{"code":code,"codeDetail":codeDetail},async:false});
		price = price.responseText;
		if(price == "0"){
			price = "無料";
		}else{
			price = formatMoney(price,0,"￥");
		}
		jQuery("#"+idValue+"_Msg").html(price);
		allOptionPrice();
			
	}
}

//--------------------------------------------
//ダブル金額制御
//--------------------------------------------
function dealWithDoublePice(idValue,thisVal,modelCode){
	//アイテムコード
	var itemCode = jQuery("#item").val();
	//*_id1 ⇒　*
	if(idValue.indexOf("_id")!=-1){
		idValue = idValue.substr(0, idValue.length - 1);
		idValue = idValue.replace("_id","");
	}
	optionCode = selectIdList[idValue];
	subItemCode = subList[idValue];
	//アイテムコード + サブアイテムコード + モデルコード + オプションコード + オプション選択肢コード
	var code = itemCode + subItemCode + modelCode + optionCode  + thisVal;
	//JACKET素材の変更処理
	//胴裏素材、袖裏素材、釦素材
	if(idValue=="bodyBackMate"||idValue=="cuffBackMate"||idValue=="btnMate"){
		var stkNo = idValue+"StkNo";
		var stkNoVal = jQuery("#"+stkNo).val();
		//アイテムコード + サブアイテムコード + モデルコード + オプションコード + オプション選択肢コード + オプション選択肢詳細コード
		var codeDetail = itemCode + subItemCode + modelCode + optionCode + thisVal + stkNoVal;
		var price = jQuery.ajax({url:contextPath + "/order/getOrderDoublePrice",data:{"code":code,"codeDetail":codeDetail},async:false});
		price = price.responseText;
		if(price == "0"){
			price = "無料";
		}else{
			price = formatMoney(price,0,"￥");
		}
		jQuery("#"+idValue+"_Msg").html(price);
		allOptionPrice();
		
	//JACKET素材品番の変更処理
	//胴裏素材品番、袖裏素材品番、釦素材品番
	}else if(idValue=="bodyBackMateStkNo"||idValue=="cuffBackMateStkNo"||idValue=="btnMateStkNo"){
		idValue = idValue.substr(0, idValue.length - 5);
		subItemCode = subList[idValue];
		optionCode = selectIdList[idValue];
		var valCode = jQuery("#"+idValue).val();
		//アイテムコード + サブアイテムコード + モデルコード + オプションコード + オプション選択肢コード
		var code = itemCode + subItemCode + modelCode + optionCode  + valCode;
		//アイテムコード + サブアイテムコード + モデルコード + オプションコード + オプション選択肢コード + オプション選択肢詳細コード
		var codeDetail = itemCode + subItemCode + modelCode + optionCode + valCode + thisVal;
		var price = jQuery.ajax({url:contextPath + "/order/getOrderDoublePrice",data:{"code":code,"codeDetail":codeDetail},async:false});
		price = price.responseText;
		if(price == "0"){
			price = "無料";
		}else{
			price = formatMoney(price,0,"￥");
		}
		jQuery("#"+idValue+"_Msg").html(price);
		allOptionPrice();
		
	}else{
		//他の項目の変更処理
		var price = jQuery.ajax({url:contextPath + "/order/getOrderDoubleNormalPrice",data:{"code":code,"codeDetail":codeDetail},async:false});
		price = price.responseText;
		if(price == "0"){
			price = "無料";
		}else{
			price = formatMoney(price,0,"￥");
		}
		jQuery("#"+idValue+"_Msg").html(price);
		allOptionPrice();
		
	}
	
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

//--------------------------------------------
//jacket 金額変更制御
//--------------------------------------------
function jacketChangePrice(jkModelCode){
	var frontBtnCntVal = jQuery("#oj_frontBtnCnt").val();
	//フロント釦数 : oj_frontBtnCnt  0000105: ダブル6つボタン    
	for(i of jkPriceList){
		if(frontBtnCntVal=="0000105"){
			//プルダウンの場合
			if(i.type == "2"){
				var idValue = i.id;
				var thisVal = jQuery("#"+idValue).val();
				dealWithDoublePice(idValue,thisVal,jkModelCode);
			//ラジオボタンの場合
			}else if(i.type == "1"){
				var idValue = i.id;
				var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
				dealWithDoublePice(idValue,thisVal,jkModelCode);
			}
		}else{
			//プルダウンの場合
			if(i.type == "2"){
				var idValue = i.id;
				var thisVal = jQuery("#"+idValue).val();
				dealWithPice(idValue,thisVal,jkModelCode);
			//ラジオボタンの場合
			}else if(i.type == "1"){
				var idValue = i.id;
				var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
				dealWithPice(idValue,thisVal,jkModelCode);
			}
		}
		
	}
}

//補正値設定
function getFigureNumber(id,FN,tack,subItemCode,modelCode){
	jQuery.ajax({
        url: contextPath + "/order/getPoTypeSize",
        type: 'get',
        async:false,
        data:{"orderPattern":"PO","subItemCode":subItemCode,"modelCode":modelCode},
        success: function(data){
        	for(var i=0; i<data.length; i++){
            	if(FN == data[i].key&&tack=="0000102"){
            		//jQuery("#"+id+"_html").html(data[i].outTack1Value + 'cm');
            		jQuery("#"+id+"_html")[0].innerHTML=data[i].outTack1Value + 'cm';
            		jQuery("#"+id+"_Size").val(data[i].outTack1Value);
            		jQuery("#"+id+"_Gross").val(data[i].outTack1Value);
            		break;
                }else if(FN == data[i].key&&tack=="0000104"){
            		//jQuery("#"+id+"_html").html(data[i].outTack2Value + 'cm');
            		jQuery("#"+id+"_html")[0].innerHTML = data[i].outTack2Value + 'cm';
            		jQuery("#"+id+"_Size").val(data[i].outTack2Value);
            		jQuery("#"+id+"_Gross").val(data[i].outTack2Value);
            		break;
                }else if(FN == data[i].key&&tack==""){
            		//jQuery("#"+id+"_html").html(data[i].value + 'cm');
            		jQuery("#"+id+"_html")[0].innerHTML = data[i].value + 'cm';
            		jQuery("#"+id+"_Size").val(data[i].value);
            		jQuery("#"+id+"_Gross").val(data[i].value);
            		break;
                }else{
                	//jQuery("#"+id+"_html").html('000.0cm');
                	jQuery("#"+id+"_html")[0].innerHTML = '000.0cm';
            		jQuery("#"+id+"_Size").val("0");
            		jQuery("#"+id+"_Gross").val("0");
                }
            }
        }
    });
}

//--------------------------------------------
//他店舗のとき　店舗を検索した
//--------------------------------------------
function initCustomer() {
	var allShop = jQuery("#shopName");
	jQuery('#destination').change(function(){
		var destination = jQuery('#destination').val();
		//他店舗コード:05
		if (destination == "05") {
				 var obj = document.getElementById("shopName");
				 obj.options.length=0;
				 obj.add(new Option("",""));
			        jQuery.ajax({
			            url: contextPath + "/order/selectAllShop",
			            type: 'get',
			            async:false,
			            success: function(data){
			               jQuery.each(data, function (index, e) {
			                   obj.add(new Option(e.shopName,e.shopCode));
			               });
			               jQuery("#shopName").trigger("chosen:updated");
			               jQuery("#shopName").chosen({
			           	   disable_search_threshold: 10,
			           	   no_results_text: getMsg('msg085'),
			           	   width: "100%"
			           	   }); 
			            }
			        });
			jQuery('#shopNameDiv').show();
		} else {
			jQuery("#shopName").val("");
			jQuery('#shopNameDiv').hide();
		}
	});
	jQuery('#destination').change();
}


//--------------------------------------------
//補正初期化
//--------------------------------------------
function adjustReInit(){
	
	var jkFigure = document.getElementById("selectJacketFigure");
	jkFigure.options.length=0;
	jkFigure.add(new Option("選択　　　",""));
	var jkNumber = document.getElementById("selectJacketNumber");
	jkNumber.options.length=0;
	jkNumber.add(new Option("選択　　　",""));
	
	//jQuery("#selectJacketFigure").val("");
	//jQuery("#selectJacketNumber").val("");
	
	//JK 型サイズ値、補正値とグロス値を設定
	jQuery("#corJkBody_div_Size").val("");
	jQuery("#corJkBody_div_Gross").val("");
	jQuery("#corJkBody_div_html").html("000.0cm");
	jQuery("#corJkBodyRange_out").html("0");
	jQuery("#corJkBodyRange").val("0");
	setFont("corJkBodyRange");
	
	jQuery("#corJkWaist_div_Size").val("");
	jQuery("#corJkWaist_div_Gross").val("");
	jQuery("#corJkWaist_div_html").html("000.0cm");
	jQuery("#corJkWaistRange_out").html("0");
	jQuery("#corJkWaistRange").val("0");
	setFont("corJkWaistRange");

	jQuery("#corJkRightsleeve_div_Size").val("");
	jQuery("#corJkRightsleeve_div_Gross").val("");
	jQuery("#corJkRightsleeve_div_html").html("000.0cm");
	jQuery("#corJkRightsleeveRange_out").html("0");
	jQuery("#corJkRightsleeveRange").val("0");
	setFont("corJkRightsleeveRange");

	jQuery("#corJkLeftsleeve_div_Size").val("");
	jQuery("#corJkLeftsleeve_div_Gross").val("");
	jQuery("#corJkLeftsleeve_div_html").html("000.0cm");
	jQuery("#corJkLeftsleeveRange_out").html("0");
	jQuery("#corJkLeftsleeveRange").val("0");
	setFont("corJkLeftsleeveRange");
	
	//PTサイズを設定
	var ptFigure = document.getElementById("selectPantsFigure");
	ptFigure.options.length=0;
	ptFigure.add(new Option("選択　　　",""));
	var ptNumber = document.getElementById("selectPantsNumber");
	ptNumber.options.length=0;
	ptNumber.add(new Option("選択　　　",""));
	
	//PT　型サイズ値、補正値とグロス値を設定
	jQuery("#corPtWaist_div_Size").val("");
	jQuery("#corPtWaist_div_Gross").val("");
	jQuery("#corPtWaist_div_html").html("000.0cm");
	jQuery("#corPtWaistRange_out").html("0");
	jQuery("#corPtWaistRange").val("0");
	setFont("corPtWaistRange");
	
	jQuery("#corPtThigh_div_Size").val("");
	jQuery("#corPtThigh_div_Gross").val("");
	jQuery("#corPtThigh_div_html").html("000.0cm");
	jQuery("#corPtThighRange_out").html("0");
	jQuery("#corPtThighRange").val("0");
	setFont("corPtThighRange");

	jQuery("#corPtHemwidth_div_Size").val("");
	jQuery("#corPtHemwidth_div_Gross").val("");
	jQuery("#corPtHemwidth_div_html").html("000.0cm");
	jQuery("#corPtHemwidthRange_out").html("0");
	jQuery("#corPtHemwidthRange").val("0");
	setFont("corPtHemwidthRange");

	jQuery("#corPtRightinseam_div_Size").val("");
	jQuery("#corPtLeftinseam_div_Size").val("");

	jQuery("#corPtRightinseamGross").val("");	
	jQuery("#ap_inseamRightM1").val("0");
	jQuery("#ap_inseamRight100").val("0");
	jQuery("#ap_inseamRight10").val("0");
	jQuery("#ap_inseamRight1").val("0");
	
	jQuery("#corPtLeftinseamGross").val("");
	jQuery("#ap_inseamLeftM1").val("0");
	jQuery("#ap_inseamLeft100").val("0");
	jQuery("#ap_inseamLeft10").val("0");
	jQuery("#ap_inseamLeft1").val("0");
	
	
	//2PTサイズを設定
	var pt2Figure = document.getElementById("selectPants2Figure");
	pt2Figure.options.length=0;
	pt2Figure.add(new Option("選択　　　",""));
	var pt2Number = document.getElementById("selectPants2Number");
	pt2Number.options.length=0;
	pt2Number.add(new Option("選択　　　",""));
	
	//2PT　型サイズ値、補正値とグロス値を設定
	jQuery("#corPt2Waist_div_Size").val("");
	jQuery("#corPt2Waist_div_Gross").val("");
	jQuery("#corPt2Waist_div_html").html("000.0cm");
	jQuery("#corPt2WaistRange_out").html("0");
	jQuery("#corPt2WaistRange").val("0");
	setFont("corPt2WaistRange");
	
	jQuery("#corPt2Thigh_div_Size").val("");
	jQuery("#corPt2Thigh_div_Gross").val("");
	jQuery("#corPt2Thigh_div_html").html("000.0cm");
	jQuery("#corPt2ThighRange_out").html("0");
	jQuery("#corPt2ThighRange").val("0");
	setFont("corPt2ThighRange");

	jQuery("#corPt2Hemwidth_div_Size").val("");
	jQuery("#corPt2Hemwidth_div_Gross").val("");
	jQuery("#corPt2Hemwidth_div_html").html("000.0cm");
	jQuery("#corPt2HemwidthRange_out").html("0");
	jQuery("#corPt2HemwidthRange").val("0");
	setFont("corPt2HemwidthRange");

	jQuery("#corPt2Rightinseam_div_Size").val("");
	jQuery("#corPt2Leftinseam_div_Size").val("");

	jQuery("#corPt2RightinseamGross").val("");
	jQuery("#ap2_inseamRightM1").val("0");
	jQuery("#ap2_inseamRight100").val("0");
	jQuery("#ap2_inseamRight10").val("0");
	jQuery("#ap2_inseamRight1").val("0");
	
	
	jQuery("#corPt2LeftinseamGross").val("");
	jQuery("#ap2_inseamLeftM1").val("0");
	jQuery("#ap2_inseamLeft100").val("0");
	jQuery("#ap2_inseamLeft10").val("0");
	jQuery("#ap2_inseamLeft1").val("0");
	
	
	//GLサイズを設定
	var glFigure = document.getElementById("selectGiletFigure");
	glFigure.options.length=0;
	glFigure.add(new Option("選択　　　",""));
	var glNumber = document.getElementById("selectGiletNumber");
	glNumber.options.length=0;
	glNumber.add(new Option("選択　　　",""));
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

//生地チェク
function fabricCheck(item,productFabricNo){
	//生地チェク成功フラッグ
	var fabricCheckValue = "0";
	var jkModelFlag = "0";
	var glModelFlag = "0";
	var ptModelFlag = "0";
	var pt2ModelFlag = "0";
	//半角英数字チェック  1
	if(isAlphabetNumeric(productFabricNo)){
		 appendAlertPo('stockMsg', getMsgByTwoArgs('msg012', '生地品番', '半角英数字'));
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
	}
	else{
	    jQuery.ajax({
	     	 type:"get",
	     	 url: contextPath + "/order/findStock",
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
	 				 appendAlertPo('stockMsg', getMsg('msg049'));
	 				 //生地チェク失敗フラッグ
	 				 fabricCheckValue = "1";
	 				 jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsg('msg049'));
	     		} 
	     		//生地情報が有りの場合
	     		else{
					//モデルチェック
	     			var jkModel = jQuery("#jacketModel").val();
	     			var jkItemCode = "";
	     			var glModel = jQuery("#giletModel").val();
	     			var glItemCode = "";
	     			var ptModel = jQuery("#op_pantsModel").val();
	     			var ptItemCode = "";
	     			var pt2Model = jQuery("#op2_pantsModel").val();
	     			
	     			if(isNotEmpty(jkModel)){
		     			if(item == "01"){
		     				jkItemCode = "01";
			     		}else if(item == "02"){
			     			jkItemCode = "02";
				     	}
		     			var jkSubItemCode = "02";
	     				var checkResult = modelCheck(jkModel,productFabricNo,orderPattern,jkItemCode,jkSubItemCode);
	     				if(checkResult == "true"){
	     					//生地チェク成功フラッグ
	     					jkModelFlag = "0";
	     					fabricCheckValue = "0";
	     					jQuery("#jkModelFlag").val(jkModelFlag);
	     					jQuery("#fabricMsg").empty();
	     					jQuery("#jacketModelMsg").empty();
		     			}else{
		     				//生地チェク失敗フラッグ
		     				jkModelFlag = "1";
		     				fabricCheckValue = "2";
		     				appendAlertPo('fabricMsg', getMsgByOneArg('msg065','JACKET'));
		     				jQuery("#jkModelFlag").val(jkModelFlag+"*"+getMsgByOneArg('msg065','JACKET'));
				     	}
	     			}

	     			if(isNotEmpty(ptModel)){
	     				jQuery("#fabricMsg").empty();
	     				if(item == "01"){
	     					ptItemCode = "01";
			     		}else if(item == "03"){
			     			ptItemCode = "03";
				     	}
		     			var ptSubItemCode = "03";
	     				var checkResult = modelCheck(ptModel,productFabricNo,orderPattern,ptItemCode,ptSubItemCode);
	     				if(checkResult == "true"){
	     					//生地チェク成功フラッグ
	     					ptModelFlag = "0";
	     					fabricCheckValue = "0";
	     					jQuery("#ptModelFlag").val(ptModelFlag);
	     					jQuery("#fabricMsg").empty();
	     					jQuery("#pantsModelMsg").empty();
		     			}else{
		     				//生地チェク失敗フラッグ
		     				ptModelFlag = "1";
		     				fabricCheckValue = "2";
		     				appendAlertPo('fabricMsg', getMsgByOneArg('msg065','PANTS'));
		     				jQuery("#ptModelFlag").val(ptModelFlag+"*"+getMsgByOneArg('msg065','PANTS'));
				     	}
	     			}

	     			if(isNotEmpty(glModel)){
	     				jQuery("#fabricMsg").empty();
	     				if(item == "01"){
	     					glItemCode = "01";
			     		}else if(item == "04"){
			     			glItemCode = "04";
				     	}
		     			var glSubItemCode = "04";
	     				var checkResult = modelCheck(glModel,productFabricNo,orderPattern,glItemCode,glSubItemCode);
	     				if(checkResult == "true"){
	     					//生地チェク成功フラッグ
	     					glModelFlag = "0";
	     					fabricCheckValue = "0";
	     					jQuery("#glModelFlag").val(glModelFlag);
	     					jQuery("#fabricMsg").empty();
	     					jQuery("#giletModelMsg").empty();
		     			}else{
		     				//生地チェク失敗フラッグ
		     				glModelFlag = "1";
		     				fabricCheckValue = "2";
		     				appendAlertPo('fabricMsg', getMsgByOneArg('msg065','GILET'));
		     				jQuery("#glModelFlag").val(glModelFlag+"*"+getMsgByOneArg('msg065','GILET'));
				     	}
	     			}

	     			if(isNotEmpty(pt2Model)){
	     				jQuery("#fabricMsg").empty();
		     			var pt2ItemCode = "01";
		     			var pt2SubItemCode = "07";
	     				var checkResult = modelCheck(pt2Model,productFabricNo,orderPattern,pt2ItemCode,pt2SubItemCode);
	     				if(checkResult == "true"){
	     					//生地チェク成功フラッグ
	     					pt2ModelFlag = "0";
	     					fabricCheckValue = "0";
	     					jQuery("#pt2ModelFlag").val(pt2ModelFlag);
	     					jQuery("#fabricMsg").empty();
	     					jQuery("#2pantsModelMsg").empty();
		     			}else{
		     				//生地チェク失敗フラッグ
		     				pt2ModelFlag = "1";
		     				fabricCheckValue = "2";
		     				appendAlertPo('fabricMsg', getMsgByOneArg('msg065','PANTS（2本目）'));
		     				jQuery("#pt2ModelFlag").val(pt2ModelFlag+"*"+getMsgByOneArg('msg065','PANTS（2本目）'));
				     	}
	     			}
		     		
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
	     				appendAlertPo('stockMsg', getMsg('msg049'));
	     				//生地チェク失敗フラッグ
	     				fabricCheckValue = "1";
	     				jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsg('msg049'));
	     				return false;
	         		 }
					 //生地店着日チェク
					 //isShopDeliveryEmpty(店着納期区分（通常）,生地品番)　5
	     			 if(!isShopDeliveryEmpty(result.storeDelvNormal,productFabricNo)){
	         			appendAlertPo('stockMsg', getMsgByOneArg('msg072',productFabricNo));
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
	     				  fakeStock = jQuery.ajax({url:contextPath + "/order/stockFakeRecovery",data:{"orderId":jQuery("#orderId").val(),"productFabricNo":productFabricNo},async:false});
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
     					  appendAlertPo('stockMsg', getMsgByThreeArgs('msg063', result.color,result.pattern,result.stockResult));
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
        				  jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsgByThreeArgs('msg063', result.color,result.pattern,result.stockResult));
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
					  colorSet(item,color);
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

//--------------------------------------------
//オプションコードの初期値を設定
//--------------------------------------------
function defaultOptionInit(){
	var j = null;
	var p = null;
	var g = null;
	var j2 = null;
	for (j of jacketDefaultList.activeList) {
		//プルダウンの場合
		if(j.type == "2"){
			jQuery("#"+j.id+" option[value='"+j.dVal+"']").prop("selected", true);
		//ラジオボタンの場合
		}else if(j.type == "1"){
			jQuery(":radio[name='" + j.id + "'][value='" + j.dVal + "']").prop("checked", true);
		}
	}

	for (p of pantsDefaultList.activeList) {
		//プルダウンの場合
		if(p.type == "2"){
			jQuery("#"+p.id+" option[value='"+p.dVal+"']").prop("selected", true);
		//ラジオボタンの場合
		}else if(p.type == "1"){
			jQuery(":radio[name='" + p.id + "'][value='" + p.dVal + "']").prop("checked", true);
		}
	}

	for (g of giletDefaultList.activeList) {
		//プルダウンの場合
		if(g.type == "2"){
			jQuery("#"+g.id+" option[value='"+g.dVal+"']").prop("selected", true);
		//ラジオボタンの場合
		}else if(g.type == "1"){
			jQuery(":radio[name='" + g.id + "'][value='" + g.dVal + "']").prop("checked", true);
		}
	}

	for (p2 of pants2DefaultList.activeList) {
		//プルダウンの場合
		if(p2.type == "2"){
			jQuery("#"+p2.id+" option[value='"+p2.dVal+"']").prop("selected", true);
		//ラジオボタンの場合
		}else if(p2.type == "1"){
			jQuery(":radio[name='" + p2.id + "'][value='" + p2.dVal + "']").prop("checked", true);
		}
	}
	jQuery(":radio[name='optionJacketStandardInfo.ojLapelDesign']").removeAttr("checked");
	jQuery(":radio[name='optionGiletStandardInfo.ogBreastPkt']").removeAttr("checked");
	jQuery("#op_doubleWide_div").hide();
	jQuery("#op2_doubleWide_div").hide();
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
		
	//SUITの場合
	if(item == "01"){
		if(twoPants == "0009902"){
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
	}

	var corStoreCorrectionMemo = jQuery('#corStoreCorrectionMemo').val();
	if(charactersCheck(corStoreCorrectionMemo)) {
    	appendAlert('errormssage', getMsg('msg120'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}
	
		
	document.forms.formId.action= contextPath + "/order/orderPoEntry";
	document.forms.formId.submit();
}
jQuery('#poConfirm').click(function(){
	// 確認メッセージ
	swal({
		  text: getMsg('msg122'),
		  icon: "info",
		  buttons: ["キャンセル", true],
		})
		.then((isConfirm) => {
		  if (isConfirm) {
			  imageCheck();
		  }
		});

	return false;
})
//--------------------------------------------
//内容確認チェック
//--------------------------------------------
function imageCheck(){
	// エラーメッセージのDIVを表示しない
	jQuery("div.alert-error").hide();
	jQuery("div.error-message-list").hide();
	jQuery("div.alert-success").hide();
	/* var versionFlag = jQuery("#versionFlag").val();
	if(versionFlag == "true"){

	}else if(versionFlag == "false"){
		appendAlert('errormssage', getMsg('msg048'));
		return false;
	} */
	
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
	
	//お客様氏名
	var custNm = jQuery("#custNm").val();
	if(charactersCheck(custNm)) {
        appendAlert('errormssage', getMsg('msg120'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}

	//フリガナ
	var custKanaNm = jQuery("#custKanaNm").val();
	if(charactersCheck(custKanaNm)) {
		appendAlert('errormssage', getMsg('msg120'));
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
       appendAlert('errormssage', getMsg('msg123'));
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
	if (productEmbroideryNecessity == '1') {
		var embroideryName = jQuery("#embroideryName").val();
		if(embroideryName.length>15){
			appendAlert('errormssage', getMsgByTwoArgs('msg011', '刺繍ネーム','15'));
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

		if(embroideryNameCheck(embroideryName)) {
			appendAlertDel('errormssage');
	    }else{
	    	appendAlert('errormssage', getMsgByOneArg('msg137','刺繍ネーム'));
	        return false;
		}
		
	}
	
    //オプションチェック
    var item = jQuery("#item option:selected").val()
    
    var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();

    var twoPants = jQuery('input[name="productSparePantsClass"]:checked').val();

    //SUIT、３Pieceが無し、スペアパンツが無しの場合
    if(item=='01'&&threePiece=='0009901'&&twoPants=='0009901'){
    	var jacketModel = jQuery("#jacketModel").val();
    	if(isEmpty(jacketModel)){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'JACKET モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}
    	
		var jkFigure = jQuery("#selectJacketFigure").val();
		var jkNumber = jQuery("#selectJacketNumber").val();

		if(isEmpty(jkFigure)||isEmpty(jkNumber)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'JACKETサイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}

		//着丈修正
		var corJkBodySize = jQuery("#corJkBody_div_Size").val();
		var corJkBodyGross = jQuery("#corJkBody_div_Gross").val();
		var corJkBodyRangeMax = document.getElementById("corJkBodyRange").max;
		var corJkBodyRangeMin = document.getElementById("corJkBodyRange").min;
		
		//ウエスト修正
		var corJkWaistSize = jQuery("#corJkWaist_div_Size").val();
		var corJkWaistGross = jQuery("#corJkWaist_div_Gross").val();
		var corJkWaistRangeMax = document.getElementById("corJkWaistRange").max;
		var corJkWaistRangeMin = document.getElementById("corJkWaistRange").min;
		
		//袖丈右修正
		var corJkRightsleeveSize = jQuery("#corJkRightsleeve_div_Size").val();
		var corJkRightsleeveGross = jQuery("#corJkRightsleeve_div_Gross").val();
		var corJkRightsleeveRangeMax = document.getElementById("corJkRightsleeveRange").max;
		var corJkRightsleeveRangeMin = document.getElementById("corJkRightsleeveRange").min;
		
		//袖丈左修正
		var corJkLeftsleeveSize = jQuery("#corJkLeftsleeve_div_Size").val();
		var corJkLeftsleeveGross = jQuery("#corJkLeftsleeve_div_Gross").val();
		var corJkLeftsleeveRangeMax = document.getElementById("corJkLeftsleeveRange").max;
		var corJkLeftsleeveRangeMin = document.getElementById("corJkLeftsleeveRange").min;

		if(isEmpty(corJkBodySize)||corJkBodySize == "0" || corJkBodySize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの着丈修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkWaistSize) || corJkWaistSize == "0" || corJkWaistSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETのウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkRightsleeveSize) || corJkRightsleeveSize == "0" || corJkRightsleeveSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの袖丈右修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkLeftsleeveSize) || corJkLeftsleeveSize == "0" || corJkLeftsleeveSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの袖丈左修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}


		var corJkBodyGrossMax = parseFloat(corJkBodySize) + parseFloat(corJkBodyRangeMax);
		var corJkBodyGrossMin = parseFloat(corJkBodySize) + parseFloat(corJkBodyRangeMin);

		if(corJkBodyGross<corJkBodyGrossMin || corJkBodyGross>corJkBodyGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの着丈修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkWaistGrossMax = parseFloat(corJkWaistSize) + parseFloat(corJkWaistRangeMax);
		var corJkWaistGrossMin = parseFloat(corJkWaistSize) + parseFloat(corJkWaistRangeMin);

		if(corJkWaistGross<corJkWaistGrossMin || corJkWaistGross>corJkWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETのウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkRightsleeveGrossMax = parseFloat(corJkRightsleeveSize) + parseFloat(corJkRightsleeveRangeMax);
		var corJkRightsleeveGrossMin = parseFloat(corJkRightsleeveSize) + parseFloat(corJkRightsleeveRangeMin);

		if(corJkRightsleeveGross<corJkRightsleeveGrossMin || corJkRightsleeveGross>corJkRightsleeveGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの袖丈右修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkLeftsleeveGrossMax = parseFloat(corJkLeftsleeveSize) + parseFloat(corJkLeftsleeveRangeMax);
		var corJkLeftsleeveGrossMin = parseFloat(corJkLeftsleeveSize) + parseFloat(corJkLeftsleeveRangeMin);

		if(corJkLeftsleeveGross<corJkLeftsleeveGrossMin || corJkLeftsleeveGross>corJkLeftsleeveGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの袖丈左修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}
		
		//ラペルデザイン
		if (!jQuery("input[name='optionJacketStandardInfo.ojLapelDesign']").is(":checked")) {
			appendAlert('errormssage', getMsgByOneArg('msg003', 'ラペルデザイン'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}

    	var pantsModel = jQuery("#op_pantsModel").val();
    	if(pantsModel==""||pantsModel==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTS モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}

    	var ptFigure = jQuery("#selectPantsFigure").val();
		var ptNumber = jQuery("#selectPantsNumber").val();

    	if(isEmpty(ptFigure)||isEmpty(ptNumber)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTSサイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}

		var corPtLeftinseamGross = jQuery("#corPtLeftinseamGross").val();
		if(corPtLeftinseamGross<50||corPtLeftinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（1本目）の股下左'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtRightinseamGross = jQuery("#corPtRightinseamGross").val();
		if(corPtRightinseamGross<50||corPtRightinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（1本目）の股下右'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		//ウエスト修正
		var corPtWaistSize = jQuery("#corPtWaist_div_Size").val();
		var corPtWaistGross = jQuery("#corPtWaist_div_Gross").val();
		var corPtWaistRangeMax = document.getElementById("corPtWaistRange").max;
		var corPtWaistRangeMin = document.getElementById("corPtWaistRange").min;
		
		//ワタリ幅修正
		var corPtThighSize = jQuery("#corPtThigh_div_Size").val();
		var corPtThighGross = jQuery("#corPtThigh_div_Gross").val();
		var corPtThighRangeMax = document.getElementById("corPtThighRange").max;
		var corPtThighRangeMin = document.getElementById("corPtThighRange").min;
		
		//裾幅
		var corPtHemwidthSize = jQuery("#corPtHemwidth_div_Size").val();
		var corPtHemwidthGross = jQuery("#corPtHemwidth_div_Gross").val();
		var corPtHemwidthRangeMax = document.getElementById("corPtHemwidthRange").max;
		var corPtHemwidthRangeMin = document.getElementById("corPtHemwidthRange").min;

		if(isEmpty(corPtWaistSize)||corPtWaistSize == "0" || corPtWaistSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）のウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPtThighSize) || corPtThighSize == "0" || corPtThighSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）のワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPtHemwidthSize) || corPtHemwidthSize == "0" || corPtHemwidthSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）の裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtWaistGrossMax = parseFloat(corPtWaistSize) + parseFloat(corPtWaistRangeMax);
		var corPtWaistGrossMin = parseFloat(corPtWaistSize) + parseFloat(corPtWaistRangeMin);

		if(corPtWaistGross<corPtWaistGrossMin || corPtWaistGross>corPtWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）のウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtWaistGrossMax = parseFloat(corPtThighSize) + parseFloat(corPtThighRangeMax);
		var corPtWaistGrossMin = parseFloat(corPtThighSize) + parseFloat(corPtThighRangeMin);

		if(corPtThighGross<corPtWaistGrossMin || corPtThighGross>corPtWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）のワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtHemwidthGrossMax = parseFloat(corPtHemwidthSize) + parseFloat(corPtHemwidthRangeMax);
		var corPtHemwidthGrossMin = parseFloat(corPtHemwidthSize) + parseFloat(corPtHemwidthRangeMin);

		if(corPtHemwidthGross<corPtHemwidthGrossMin || corPtHemwidthGross>corPtHemwidthGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）の裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

    }
    
 	//SUIT、３Pieceが有り、スペアパンツが無しの場合
    if(item=='01'&&threePiece=='0009902'&&twoPants=='0009901'){
    	var jacketModel = jQuery("#jacketModel").val();
    	if(jacketModel==""||jacketModel==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'JACKET モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}

    	var jkFigure = jQuery("#selectJacketFigure").val();
		var jkNumber = jQuery("#selectJacketNumber").val();

		if(isEmpty(jkFigure)||isEmpty(jkNumber)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'JACKETサイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}

		//着丈修正
		var corJkBodySize = jQuery("#corJkBody_div_Size").val();
		var corJkBodyGross = jQuery("#corJkBody_div_Gross").val();
		var corJkBodyRangeMax = document.getElementById("corJkBodyRange").max;
		var corJkBodyRangeMin = document.getElementById("corJkBodyRange").min;
		
		//ウエスト修正
		var corJkWaistSize = jQuery("#corJkWaist_div_Size").val();
		var corJkWaistGross = jQuery("#corJkWaist_div_Gross").val();
		var corJkWaistRangeMax = document.getElementById("corJkWaistRange").max;
		var corJkWaistRangeMin = document.getElementById("corJkWaistRange").min;
		
		//袖丈右修正
		var corJkRightsleeveSize = jQuery("#corJkRightsleeve_div_Size").val();
		var corJkRightsleeveGross = jQuery("#corJkRightsleeve_div_Gross").val();
		var corJkRightsleeveRangeMax = document.getElementById("corJkRightsleeveRange").max;
		var corJkRightsleeveRangeMin = document.getElementById("corJkRightsleeveRange").min;
		
		//袖丈左修正
		var corJkLeftsleeveSize = jQuery("#corJkLeftsleeve_div_Size").val();
		var corJkLeftsleeveGross = jQuery("#corJkLeftsleeve_div_Gross").val();
		var corJkLeftsleeveRangeMax = document.getElementById("corJkLeftsleeveRange").max;
		var corJkLeftsleeveRangeMin = document.getElementById("corJkLeftsleeveRange").min;

		if(isEmpty(corJkBodySize)||corJkBodySize == "0" || corJkBodySize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの着丈修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkWaistSize) || corJkWaistSize == "0" || corJkWaistSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETのウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkRightsleeveSize) || corJkRightsleeveSize == "0" || corJkRightsleeveSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの袖丈右修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkLeftsleeveSize) || corJkLeftsleeveSize == "0" || corJkLeftsleeveSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの袖丈左修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}


		var corJkBodyGrossMax = parseFloat(corJkBodySize) + parseFloat(corJkBodyRangeMax);
		var corJkBodyGrossMin = parseFloat(corJkBodySize) + parseFloat(corJkBodyRangeMin);

		if(corJkBodyGross<corJkBodyGrossMin || corJkBodyGross>corJkBodyGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの着丈修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkWaistGrossMax = parseFloat(corJkWaistSize) + parseFloat(corJkWaistRangeMax);
		var corJkWaistGrossMin = parseFloat(corJkWaistSize) + parseFloat(corJkWaistRangeMin);

		if(corJkWaistGross<corJkWaistGrossMin || corJkWaistGross>corJkWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETのウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkRightsleeveGrossMax = parseFloat(corJkRightsleeveSize) + parseFloat(corJkRightsleeveRangeMax);
		var corJkRightsleeveGrossMin = parseFloat(corJkRightsleeveSize) + parseFloat(corJkRightsleeveRangeMin);

		if(corJkRightsleeveGross<corJkRightsleeveGrossMin || corJkRightsleeveGross>corJkRightsleeveGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの袖丈右修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkLeftsleeveGrossMax = parseFloat(corJkLeftsleeveSize) + parseFloat(corJkLeftsleeveRangeMax);
		var corJkLeftsleeveGrossMin = parseFloat(corJkLeftsleeveSize) + parseFloat(corJkLeftsleeveRangeMin);

		if(corJkLeftsleeveGross<corJkLeftsleeveGrossMin || corJkLeftsleeveGross>corJkLeftsleeveGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの袖丈左修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}
		
		//ラペルデザイン
		if (!jQuery("input[name='optionJacketStandardInfo.ojLapelDesign']").is(":checked")) {
			appendAlert('errormssage', getMsgByOneArg('msg066', 'ラペルデザイン'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}
		
    	var pantsModel = jQuery("#op_pantsModel").val();
    	if(pantsModel==""||pantsModel==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTS モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}

    	var ptFigure = jQuery("#selectPantsFigure").val();
		var ptNumber = jQuery("#selectPantsNumber").val();

    	if(isEmpty(ptFigure)||isEmpty(ptNumber)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTSサイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}

		var corPtLeftinseamGross = jQuery("#corPtLeftinseamGross").val();
		if(corPtLeftinseamGross<50||corPtLeftinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（1本目）の股下左'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtRightinseamGross = jQuery("#corPtRightinseamGross").val();
		if(corPtRightinseamGross<50||corPtRightinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（1本目）の股下右'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		//ウエスト修正
		var corPtWaistSize = jQuery("#corPtWaist_div_Size").val();
		var corPtWaistGross = jQuery("#corPtWaist_div_Gross").val();
		var corPtWaistRangeMax = document.getElementById("corPtWaistRange").max;
		var corPtWaistRangeMin = document.getElementById("corPtWaistRange").min;
		
		//ワタリ幅修正
		var corPtThighSize = jQuery("#corPtThigh_div_Size").val();
		var corPtThighGross = jQuery("#corPtThigh_div_Gross").val();
		var corPtThighRangeMax = document.getElementById("corPtThighRange").max;
		var corPtThighRangeMin = document.getElementById("corPtThighRange").min;
		
		//裾幅
		var corPtHemwidthSize = jQuery("#corPtHemwidth_div_Size").val();
		var corPtHemwidthGross = jQuery("#corPtHemwidth_div_Gross").val();
		var corPtHemwidthRangeMax = document.getElementById("corPtHemwidthRange").max;
		var corPtHemwidthRangeMin = document.getElementById("corPtHemwidthRange").min;

		if(isEmpty(corPtWaistSize)||corPtWaistSize == "0" || corPtWaistSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）のウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPtThighSize) || corPtThighSize == "0" || corPtThighSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）のワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPtHemwidthSize) || corPtHemwidthSize == "0" || corPtHemwidthSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）の裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtWaistGrossMax = parseFloat(corPtWaistSize) + parseFloat(corPtWaistRangeMax);
		var corPtWaistGrossMin = parseFloat(corPtWaistSize) + parseFloat(corPtWaistRangeMin);

		if(corPtWaistGross<corPtWaistGrossMin || corPtWaistGross>corPtWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）のウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtWaistGrossMax = parseFloat(corPtThighSize) + parseFloat(corPtThighRangeMax);
		var corPtWaistGrossMin = parseFloat(corPtThighSize) + parseFloat(corPtThighRangeMin);

		if(corPtThighGross<corPtWaistGrossMin || corPtThighGross>corPtWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）のワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtHemwidthGrossMax = parseFloat(corPtHemwidthSize) + parseFloat(corPtHemwidthRangeMax);
		var corPtHemwidthGrossMin = parseFloat(corPtHemwidthSize) + parseFloat(corPtHemwidthRangeMin);

		if(corPtHemwidthGross<corPtHemwidthGrossMin || corPtHemwidthGross>corPtHemwidthGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）の裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

    	var giletModel = jQuery("#giletModel").val();
    	if(giletModel==""||giletModel==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'GILET モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}
		
    	var glFigure = jQuery("#selectGiletFigure").val();
		var glNumber = jQuery("#selectGiletNumber").val();

    	if(isEmpty(glFigure)||isEmpty(glNumber)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'GILETサイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}
		
    }
  	//SUIT、３Pieceが無し、スペアパンツが有りの場合
    if(item=='01'&&threePiece=='0009901'&&twoPants=='0009902'){
    	var jacketModel = jQuery("#jacketModel").val();
    	if(jacketModel==""||jacketModel==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'JACKET モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}

    	var jkFigure = jQuery("#selectJacketFigure").val();
		var jkNumber = jQuery("#selectJacketNumber").val();

		if(isEmpty(jkFigure)||isEmpty(jkNumber)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'JACKETサイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}

		//着丈修正
		var corJkBodySize = jQuery("#corJkBody_div_Size").val();
		var corJkBodyGross = jQuery("#corJkBody_div_Gross").val();
		var corJkBodyRangeMax = document.getElementById("corJkBodyRange").max;
		var corJkBodyRangeMin = document.getElementById("corJkBodyRange").min;
		
		//ウエスト修正
		var corJkWaistSize = jQuery("#corJkWaist_div_Size").val();
		var corJkWaistGross = jQuery("#corJkWaist_div_Gross").val();
		var corJkWaistRangeMax = document.getElementById("corJkWaistRange").max;
		var corJkWaistRangeMin = document.getElementById("corJkWaistRange").min;
		
		//袖丈右修正
		var corJkRightsleeveSize = jQuery("#corJkRightsleeve_div_Size").val();
		var corJkRightsleeveGross = jQuery("#corJkRightsleeve_div_Gross").val();
		var corJkRightsleeveRangeMax = document.getElementById("corJkRightsleeveRange").max;
		var corJkRightsleeveRangeMin = document.getElementById("corJkRightsleeveRange").min;
		
		//袖丈左修正
		var corJkLeftsleeveSize = jQuery("#corJkLeftsleeve_div_Size").val();
		var corJkLeftsleeveGross = jQuery("#corJkLeftsleeve_div_Gross").val();
		var corJkLeftsleeveRangeMax = document.getElementById("corJkLeftsleeveRange").max;
		var corJkLeftsleeveRangeMin = document.getElementById("corJkLeftsleeveRange").min;

		if(isEmpty(corJkBodySize)||corJkBodySize == "0" || corJkBodySize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの着丈修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkWaistSize) || corJkWaistSize == "0" || corJkWaistSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETのウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkRightsleeveSize) || corJkRightsleeveSize == "0" || corJkRightsleeveSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの袖丈右修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkLeftsleeveSize) || corJkLeftsleeveSize == "0" || corJkLeftsleeveSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの袖丈左修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}


		var corJkBodyGrossMax = parseFloat(corJkBodySize) + parseFloat(corJkBodyRangeMax);
		var corJkBodyGrossMin = parseFloat(corJkBodySize) + parseFloat(corJkBodyRangeMin);

		if(corJkBodyGross<corJkBodyGrossMin || corJkBodyGross>corJkBodyGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの着丈修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkWaistGrossMax = parseFloat(corJkWaistSize) + parseFloat(corJkWaistRangeMax);
		var corJkWaistGrossMin = parseFloat(corJkWaistSize) + parseFloat(corJkWaistRangeMin);

		if(corJkWaistGross<corJkWaistGrossMin || corJkWaistGross>corJkWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETのウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkRightsleeveGrossMax = parseFloat(corJkRightsleeveSize) + parseFloat(corJkRightsleeveRangeMax);
		var corJkRightsleeveGrossMin = parseFloat(corJkRightsleeveSize) + parseFloat(corJkRightsleeveRangeMin);

		if(corJkRightsleeveGross<corJkRightsleeveGrossMin || corJkRightsleeveGross>corJkRightsleeveGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの袖丈右修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkLeftsleeveGrossMax = parseFloat(corJkLeftsleeveSize) + parseFloat(corJkLeftsleeveRangeMax);
		var corJkLeftsleeveGrossMin = parseFloat(corJkLeftsleeveSize) + parseFloat(corJkLeftsleeveRangeMin);

		if(corJkLeftsleeveGross<corJkLeftsleeveGrossMin || corJkLeftsleeveGross>corJkLeftsleeveGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの袖丈左修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		//ラペルデザイン
		if (!jQuery("input[name='optionJacketStandardInfo.ojLapelDesign']").is(":checked")) {
			appendAlert('errormssage', getMsgByOneArg('msg003', 'ラペルデザイン'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}
		
    	var pantsModel = jQuery("#op_pantsModel").val();
    	if(pantsModel==""||pantsModel==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTS モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}

    	var ptFigure = jQuery("#selectPantsFigure").val();
		var ptNumber = jQuery("#selectPantsNumber").val();

    	if(isEmpty(ptFigure)||isEmpty(ptNumber)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTSサイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}

		var corPtLeftinseamGross = jQuery("#corPtLeftinseamGross").val();
		if(corPtLeftinseamGross<50||corPtLeftinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（1本目）の股下左'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtRightinseamGross = jQuery("#corPtRightinseamGross").val();
		if(corPtRightinseamGross<50||corPtRightinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（1本目）の股下右'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		//ウエスト修正
		var corPtWaistSize = jQuery("#corPtWaist_div_Size").val();
		var corPtWaistGross = jQuery("#corPtWaist_div_Gross").val();
		var corPtWaistRangeMax = document.getElementById("corPtWaistRange").max;
		var corPtWaistRangeMin = document.getElementById("corPtWaistRange").min;
		
		//ワタリ幅修正
		var corPtThighSize = jQuery("#corPtThigh_div_Size").val();
		var corPtThighGross = jQuery("#corPtThigh_div_Gross").val();
		var corPtThighRangeMax = document.getElementById("corPtThighRange").max;
		var corPtThighRangeMin = document.getElementById("corPtThighRange").min;
		
		//裾幅
		var corPtHemwidthSize = jQuery("#corPtHemwidth_div_Size").val();
		var corPtHemwidthGross = jQuery("#corPtHemwidth_div_Gross").val();
		var corPtHemwidthRangeMax = document.getElementById("corPtHemwidthRange").max;
		var corPtHemwidthRangeMin = document.getElementById("corPtHemwidthRange").min;

		if(isEmpty(corPtWaistSize)||corPtWaistSize == "0" || corPtWaistSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）のウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPtThighSize) || corPtThighSize == "0" || corPtThighSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）のワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPtHemwidthSize) || corPtHemwidthSize == "0" || corPtHemwidthSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）の裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtWaistGrossMax = parseFloat(corPtWaistSize) + parseFloat(corPtWaistRangeMax);
		var corPtWaistGrossMin = parseFloat(corPtWaistSize) + parseFloat(corPtWaistRangeMin);

		if(corPtWaistGross<corPtWaistGrossMin || corPtWaistGross>corPtWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）のウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtWaistGrossMax = parseFloat(corPtThighSize) + parseFloat(corPtThighRangeMax);
		var corPtWaistGrossMin = parseFloat(corPtThighSize) + parseFloat(corPtThighRangeMin);

		if(corPtThighGross<corPtWaistGrossMin || corPtThighGross>corPtWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）のワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtHemwidthGrossMax = parseFloat(corPtHemwidthSize) + parseFloat(corPtHemwidthRangeMax);
		var corPtHemwidthGrossMin = parseFloat(corPtHemwidthSize) + parseFloat(corPtHemwidthRangeMin);

		if(corPtHemwidthGross<corPtHemwidthGrossMin || corPtHemwidthGross>corPtHemwidthGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）の裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

    	var pants2Model = jQuery("#op2_pantsModel").val();
    	if(pants2Model==""||pants2Model==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTS（2本目）モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}

    	var pt2Figure = jQuery("#selectPants2Figure").val();
		var pt2Number = jQuery("#selectPants2Number").val();

    	if(isEmpty(pt2Figure)||isEmpty(pt2Number)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTS（2本目）サイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}


    	var corPt2LeftinseamGross = jQuery("#corPt2LeftinseamGross").val();
		if(corPt2LeftinseamGross<50||corPt2LeftinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（2本目）の股下左'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		
    	var corPt2RightinseamGross = jQuery("#corPt2RightinseamGross").val();
		if(corPt2RightinseamGross<50||corPt2RightinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（2本目）の股下右'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		//ウエスト修正
		var corPt2WaistSize = jQuery("#corPt2Waist_div_Size").val();
		var corPt2WaistGross = jQuery("#corPt2Waist_div_Gross").val();
		var corPt2WaistRangeMax = document.getElementById("corPt2WaistRange").max;
		var corPt2WaistRangeMin = document.getElementById("corPt2WaistRange").min;
		
		//ワタリ幅修正
		var corPt2ThighSize = jQuery("#corPt2Thigh_div_Size").val();
		var corPt2ThighGross = jQuery("#corPt2Thigh_div_Gross").val();
		var corPt2ThighRangeMax = document.getElementById("corPt2ThighRange").max;
		var corPt2ThighRangeMin = document.getElementById("corPt2ThighRange").min;
		
		//裾幅
		var corPt2HemwidthSize = jQuery("#corPt2Hemwidth_div_Size").val();
		var corPt2HemwidthGross = jQuery("#corPt2Hemwidth_div_Gross").val();
		var corPt2HemwidthRangeMax = document.getElementById("corPt2HemwidthRange").max;
		var corPt2HemwidthRangeMin = document.getElementById("corPt2HemwidthRange").min;
		
		if(isEmpty(corPt2WaistSize)||corPt2WaistSize == "0" || corPt2WaistSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（2本目）ウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPt2ThighSize) || corPt2ThighSize == "0" || corPt2ThighSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（2本目）ワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPt2HemwidthSize) || corPt2HemwidthSize == "0" || corPt2HemwidthSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（2本目）裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPt2WaistGrossMax = parseFloat(corPt2WaistSize) + parseFloat(corPt2WaistRangeMax);
		var corPt2WaistGrossMin = parseFloat(corPt2WaistSize) + parseFloat(corPt2WaistRangeMin);

		if(corPt2WaistGross<corPt2WaistGrossMin || corPt2WaistGross>corPt2WaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（2本目）ウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPt2ThighGrossMax = parseFloat(corPt2ThighSize) + parseFloat(corPt2ThighRangeMax);
		var corPt2ThighGrossMin = parseFloat(corPt2ThighSize) + parseFloat(corPt2ThighRangeMin);

		if(corPt2ThighGross<corPt2ThighGrossMin || corPt2ThighGross>corPt2ThighGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（2本目）ワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPt2HemwidthGrossMax = parseFloat(corPt2HemwidthSize) + parseFloat(corPt2HemwidthRangeMax);
		var corPt2HemwidthGrossMin = parseFloat(corPt2HemwidthSize) + parseFloat(corPt2HemwidthRangeMin);

		if(corPt2HemwidthGross<corPt2HemwidthGrossMin || corPt2HemwidthGross>corPt2HemwidthGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（2本目）裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

    }
  	//SUIT、３Pieceが有り、スペアパンツが有りの場合
    if(item=='01'&&threePiece=='0009902'&&twoPants=='0009902'){
    	var jacketModel = jQuery("#jacketModel").val();
    	if(jacketModel==""||jacketModel==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'JACKET モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}

    	var jkFigure = jQuery("#selectJacketFigure").val();
		var jkNumber = jQuery("#selectJacketNumber").val();

		if(isEmpty(jkFigure)||isEmpty(jkNumber)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'JACKETサイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}

		//着丈修正
		var corJkBodySize = jQuery("#corJkBody_div_Size").val();
		var corJkBodyGross = jQuery("#corJkBody_div_Gross").val();
		var corJkBodyRangeMax = document.getElementById("corJkBodyRange").max;
		var corJkBodyRangeMin = document.getElementById("corJkBodyRange").min;
		
		//ウエスト修正
		var corJkWaistSize = jQuery("#corJkWaist_div_Size").val();
		var corJkWaistGross = jQuery("#corJkWaist_div_Gross").val();
		var corJkWaistRangeMax = document.getElementById("corJkWaistRange").max;
		var corJkWaistRangeMin = document.getElementById("corJkWaistRange").min;
		
		//袖丈右修正
		var corJkRightsleeveSize = jQuery("#corJkRightsleeve_div_Size").val();
		var corJkRightsleeveGross = jQuery("#corJkRightsleeve_div_Gross").val();
		var corJkRightsleeveRangeMax = document.getElementById("corJkRightsleeveRange").max;
		var corJkRightsleeveRangeMin = document.getElementById("corJkRightsleeveRange").min;
		
		//袖丈左修正
		var corJkLeftsleeveSize = jQuery("#corJkLeftsleeve_div_Size").val();
		var corJkLeftsleeveGross = jQuery("#corJkLeftsleeve_div_Gross").val();
		var corJkLeftsleeveRangeMax = document.getElementById("corJkLeftsleeveRange").max;
		var corJkLeftsleeveRangeMin = document.getElementById("corJkLeftsleeveRange").min;

		if(isEmpty(corJkBodySize)||corJkBodySize == "0" || corJkBodySize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの着丈修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkWaistSize) || corJkWaistSize == "0" || corJkWaistSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETのウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkRightsleeveSize) || corJkRightsleeveSize == "0" || corJkRightsleeveSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの袖丈右修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkLeftsleeveSize) || corJkLeftsleeveSize == "0" || corJkLeftsleeveSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの袖丈左修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}


		var corJkBodyGrossMax = parseFloat(corJkBodySize) + parseFloat(corJkBodyRangeMax);
		var corJkBodyGrossMin = parseFloat(corJkBodySize) + parseFloat(corJkBodyRangeMin);

		if(corJkBodyGross<corJkBodyGrossMin || corJkBodyGross>corJkBodyGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの着丈修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkWaistGrossMax = parseFloat(corJkWaistSize) + parseFloat(corJkWaistRangeMax);
		var corJkWaistGrossMin = parseFloat(corJkWaistSize) + parseFloat(corJkWaistRangeMin);

		if(corJkWaistGross<corJkWaistGrossMin || corJkWaistGross>corJkWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETのウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkRightsleeveGrossMax = parseFloat(corJkRightsleeveSize) + parseFloat(corJkRightsleeveRangeMax);
		var corJkRightsleeveGrossMin = parseFloat(corJkRightsleeveSize) + parseFloat(corJkRightsleeveRangeMin);

		if(corJkRightsleeveGross<corJkRightsleeveGrossMin || corJkRightsleeveGross>corJkRightsleeveGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの袖丈右修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkLeftsleeveGrossMax = parseFloat(corJkLeftsleeveSize) + parseFloat(corJkLeftsleeveRangeMax);
		var corJkLeftsleeveGrossMin = parseFloat(corJkLeftsleeveSize) + parseFloat(corJkLeftsleeveRangeMin);

		if(corJkLeftsleeveGross<corJkLeftsleeveGrossMin || corJkLeftsleeveGross>corJkLeftsleeveGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの袖丈左修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}
		
		//ラペルデザイン
		if (!jQuery("input[name='optionJacketStandardInfo.ojLapelDesign']").is(":checked")) {
			appendAlert('errormssage', getMsgByOneArg('msg003', 'ラペルデザイン'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}

		var ptFigure = jQuery("#selectPantsFigure").val();
		var ptNumber = jQuery("#selectPantsNumber").val();

    	if(isEmpty(ptFigure)||isEmpty(ptNumber)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTSサイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}
		
		
    	var pantsModel = jQuery("#op_pantsModel").val();
    	if(pantsModel==""||pantsModel==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTS モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}


		var corPtLeftinseamGross = jQuery("#corPtLeftinseamGross").val();
		if(corPtLeftinseamGross<50||corPtLeftinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（1本目）の股下左'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtRightinseamGross = jQuery("#corPtRightinseamGross").val();
		if(corPtRightinseamGross<50||corPtRightinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（1本目）の股下右'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		//ウエスト修正
		var corPtWaistSize = jQuery("#corPtWaist_div_Size").val();
		var corPtWaistGross = jQuery("#corPtWaist_div_Gross").val();
		var corPtWaistRangeMax = document.getElementById("corPtWaistRange").max;
		var corPtWaistRangeMin = document.getElementById("corPtWaistRange").min;
		
		//ワタリ幅修正
		var corPtThighSize = jQuery("#corPtThigh_div_Size").val();
		var corPtThighGross = jQuery("#corPtThigh_div_Gross").val();
		var corPtThighRangeMax = document.getElementById("corPtThighRange").max;
		var corPtThighRangeMin = document.getElementById("corPtThighRange").min;
		
		//裾幅
		var corPtHemwidthSize = jQuery("#corPtHemwidth_div_Size").val();
		var corPtHemwidthGross = jQuery("#corPtHemwidth_div_Gross").val();
		var corPtHemwidthRangeMax = document.getElementById("corPtHemwidthRange").max;
		var corPtHemwidthRangeMin = document.getElementById("corPtHemwidthRange").min;

		if(isEmpty(corPtWaistSize)||corPtWaistSize == "0" || corPtWaistSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）のウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPtThighSize) || corPtThighSize == "0" || corPtThighSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）のワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPtHemwidthSize) || corPtHemwidthSize == "0" || corPtHemwidthSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）の裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtWaistGrossMax = parseFloat(corPtWaistSize) + parseFloat(corPtWaistRangeMax);
		var corPtWaistGrossMin = parseFloat(corPtWaistSize) + parseFloat(corPtWaistRangeMin);

		if(corPtWaistGross<corPtWaistGrossMin || corPtWaistGross>corPtWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）のウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtWaistGrossMax = parseFloat(corPtThighSize) + parseFloat(corPtThighRangeMax);
		var corPtWaistGrossMin = parseFloat(corPtThighSize) + parseFloat(corPtThighRangeMin);

		if(corPtThighGross<corPtWaistGrossMin || corPtThighGross>corPtWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）のワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtHemwidthGrossMax = parseFloat(corPtHemwidthSize) + parseFloat(corPtHemwidthRangeMax);
		var corPtHemwidthGrossMin = parseFloat(corPtHemwidthSize) + parseFloat(corPtHemwidthRangeMin);

		if(corPtHemwidthGross<corPtHemwidthGrossMin || corPtHemwidthGross>corPtHemwidthGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）の裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var pants2Model = jQuery("#op2_pantsModel").val();
    	if(pants2Model==""||pants2Model==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTS（2本目）モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}
		
    	var pt2Figure = jQuery("#selectPants2Figure").val();
		var pt2Number = jQuery("#selectPants2Number").val();

    	if(isEmpty(pt2Figure)||isEmpty(pt2Number)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTS（2本目）サイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}

		var corPt2LeftinseamGross = jQuery("#corPt2LeftinseamGross").val();
		if(corPt2LeftinseamGross<50||corPt2LeftinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（2本目）の股下左'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPt2RightinseamGross = jQuery("#corPt2RightinseamGross").val();
		if(corPt2RightinseamGross<50||corPt2RightinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（2本目）の股下右'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		//ウエスト修正
		var corPt2WaistSize = jQuery("#corPt2Waist_div_Size").val();
		var corPt2WaistGross = jQuery("#corPt2Waist_div_Gross").val();
		var corPt2WaistRangeMax = document.getElementById("corPt2WaistRange").max;
		var corPt2WaistRangeMin = document.getElementById("corPt2WaistRange").min;
		
		//ワタリ幅修正
		var corPt2ThighSize = jQuery("#corPt2Thigh_div_Size").val();
		var corPt2ThighGross = jQuery("#corPt2Thigh_div_Gross").val();
		var corPt2ThighRangeMax = document.getElementById("corPt2ThighRange").max;
		var corPt2ThighRangeMin = document.getElementById("corPt2ThighRange").min;
		
		//裾幅
		var corPt2HemwidthSize = jQuery("#corPt2Hemwidth_div_Size").val();
		var corPt2HemwidthGross = jQuery("#corPt2Hemwidth_div_Gross").val();
		var corPt2HemwidthRangeMax = document.getElementById("corPt2HemwidthRange").max;
		var corPt2HemwidthRangeMin = document.getElementById("corPt2HemwidthRange").min;
		
		if(isEmpty(corPt2WaistSize)||corPt2WaistSize == "0" || corPt2WaistSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（2本目）ウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPt2ThighSize) || corPt2ThighSize == "0" || corPt2ThighSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（2本目）ワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPt2HemwidthSize) || corPt2HemwidthSize == "0" || corPt2HemwidthSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（2本目）裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPt2WaistGrossMax = parseFloat(corPt2WaistSize) + parseFloat(corPt2WaistRangeMax);
		var corPt2WaistGrossMin = parseFloat(corPt2WaistSize) + parseFloat(corPt2WaistRangeMin);

		if(corPt2WaistGross<corPt2WaistGrossMin || corPt2WaistGross>corPt2WaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（2本目）ウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPt2ThighGrossMax = parseFloat(corPt2ThighSize) + parseFloat(corPt2ThighRangeMax);
		var corPt2ThighGrossMin = parseFloat(corPt2ThighSize) + parseFloat(corPt2ThighRangeMin);

		if(corPt2ThighGross<corPt2ThighGrossMin || corPt2ThighGross>corPt2ThighGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（2本目）ワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPt2HemwidthGrossMax = parseFloat(corPt2HemwidthSize) + parseFloat(corPt2HemwidthRangeMax);
		var corPt2HemwidthGrossMin = parseFloat(corPt2HemwidthSize) + parseFloat(corPt2HemwidthRangeMin);

		if(corPt2HemwidthGross<corPt2HemwidthGrossMin || corPt2HemwidthGross>corPt2HemwidthGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（2本目）裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var giletModel = jQuery("#giletModel").val();
    	if(giletModel==""||giletModel==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'GILET モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}

    	var glFigure = jQuery("#selectGiletFigure").val();
		var glNumber = jQuery("#selectGiletNumber").val();

    	if(isEmpty(glFigure)||isEmpty(glNumber)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'GILETサイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}
    }
	//JACKETの場合
    if(item=='02'){
    	var jacketModel = jQuery("#jacketModel").val();
    	if(jacketModel==""||jacketModel==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'JACKET モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}

    	var jkFigure = jQuery("#selectJacketFigure").val();
		var jkNumber = jQuery("#selectJacketNumber").val();

		if(isEmpty(jkFigure)||isEmpty(jkNumber)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'JACKETサイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}

		//着丈修正
		var corJkBodySize = jQuery("#corJkBody_div_Size").val();
		var corJkBodyGross = jQuery("#corJkBody_div_Gross").val();
		var corJkBodyRangeMax = document.getElementById("corJkBodyRange").max;
		var corJkBodyRangeMin = document.getElementById("corJkBodyRange").min;
		
		//ウエスト修正
		var corJkWaistSize = jQuery("#corJkWaist_div_Size").val();
		var corJkWaistGross = jQuery("#corJkWaist_div_Gross").val();
		var corJkWaistRangeMax = document.getElementById("corJkWaistRange").max;
		var corJkWaistRangeMin = document.getElementById("corJkWaistRange").min;
		
		//袖丈右修正
		var corJkRightsleeveSize = jQuery("#corJkRightsleeve_div_Size").val();
		var corJkRightsleeveGross = jQuery("#corJkRightsleeve_div_Gross").val();
		var corJkRightsleeveRangeMax = document.getElementById("corJkRightsleeveRange").max;
		var corJkRightsleeveRangeMin = document.getElementById("corJkRightsleeveRange").min;
		
		//袖丈左修正
		var corJkLeftsleeveSize = jQuery("#corJkLeftsleeve_div_Size").val();
		var corJkLeftsleeveGross = jQuery("#corJkLeftsleeve_div_Gross").val();
		var corJkLeftsleeveRangeMax = document.getElementById("corJkLeftsleeveRange").max;
		var corJkLeftsleeveRangeMin = document.getElementById("corJkLeftsleeveRange").min;

		if(isEmpty(corJkBodySize)||corJkBodySize == "0" || corJkBodySize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの着丈修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkWaistSize) || corJkWaistSize == "0" || corJkWaistSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETのウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkRightsleeveSize) || corJkRightsleeveSize == "0" || corJkRightsleeveSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの袖丈右修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corJkLeftsleeveSize) || corJkLeftsleeveSize == "0" || corJkLeftsleeveSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'JACKETの袖丈左修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}


		var corJkBodyGrossMax = parseFloat(corJkBodySize) + parseFloat(corJkBodyRangeMax);
		var corJkBodyGrossMin = parseFloat(corJkBodySize) + parseFloat(corJkBodyRangeMin);

		if(corJkBodyGross<corJkBodyGrossMin || corJkBodyGross>corJkBodyGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの着丈修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkWaistGrossMax = parseFloat(corJkWaistSize) + parseFloat(corJkWaistRangeMax);
		var corJkWaistGrossMin = parseFloat(corJkWaistSize) + parseFloat(corJkWaistRangeMin);

		if(corJkWaistGross<corJkWaistGrossMin || corJkWaistGross>corJkWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETのウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkRightsleeveGrossMax = parseFloat(corJkRightsleeveSize) + parseFloat(corJkRightsleeveRangeMax);
		var corJkRightsleeveGrossMin = parseFloat(corJkRightsleeveSize) + parseFloat(corJkRightsleeveRangeMin);

		if(corJkRightsleeveGross<corJkRightsleeveGrossMin || corJkRightsleeveGross>corJkRightsleeveGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの袖丈右修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corJkLeftsleeveGrossMax = parseFloat(corJkLeftsleeveSize) + parseFloat(corJkLeftsleeveRangeMax);
		var corJkLeftsleeveGrossMin = parseFloat(corJkLeftsleeveSize) + parseFloat(corJkLeftsleeveRangeMin);

		if(corJkLeftsleeveGross<corJkLeftsleeveGrossMin || corJkLeftsleeveGross>corJkLeftsleeveGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'JACKETの袖丈左修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}
		
		//ラペルデザイン
		if (!jQuery("input[name='optionJacketStandardInfo.ojLapelDesign']").is(":checked")) {
			appendAlert('errormssage', getMsgByOneArg('msg003', 'ラペルデザイン'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}
		
    }
  　　　//PANTSの場合
    if(item=='03'){
    	var pantsModel = jQuery("#op_pantsModel").val();
    	if(pantsModel==""||pantsModel==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTS モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}
    	var ptFigure = jQuery("#selectPantsFigure").val();
		var ptNumber = jQuery("#selectPantsNumber").val();

    	if(isEmpty(ptFigure)||isEmpty(ptNumber)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'PANTSサイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}

		var corPtLeftinseamGross = jQuery("#corPtLeftinseamGross").val();
		if(corPtLeftinseamGross<50||corPtLeftinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（1本目）の股下左'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtRightinseamGross = jQuery("#corPtRightinseamGross").val();
		if(corPtRightinseamGross<50||corPtRightinseamGross>110){
			appendAlert('errormssage', getMsgByOneArg('msg121', 'PANTS（1本目）の股下右'));
			return false;
		}else{
			appendAlertDel('errormssage');
		}

		//ウエスト修正
		var corPtWaistSize = jQuery("#corPtWaist_div_Size").val();
		var corPtWaistGross = jQuery("#corPtWaist_div_Gross").val();
		var corPtWaistRangeMax = document.getElementById("corPtWaistRange").max;
		var corPtWaistRangeMin = document.getElementById("corPtWaistRange").min;
		
		//ワタリ幅修正
		var corPtThighSize = jQuery("#corPtThigh_div_Size").val();
		var corPtThighGross = jQuery("#corPtThigh_div_Gross").val();
		var corPtThighRangeMax = document.getElementById("corPtThighRange").max;
		var corPtThighRangeMin = document.getElementById("corPtThighRange").min;
		
		//裾幅
		var corPtHemwidthSize = jQuery("#corPtHemwidth_div_Size").val();
		var corPtHemwidthGross = jQuery("#corPtHemwidth_div_Gross").val();
		var corPtHemwidthRangeMax = document.getElementById("corPtHemwidthRange").max;
		var corPtHemwidthRangeMin = document.getElementById("corPtHemwidthRange").min;

		if(isEmpty(corPtWaistSize)||corPtWaistSize == "0" || corPtWaistSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）のウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPtThighSize) || corPtThighSize == "0" || corPtThighSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）のワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		if(isEmpty(corPtHemwidthSize) || corPtHemwidthSize == "0" || corPtHemwidthSize == 0){
			appendAlert('errormssage', getMsgByOneArg('msg135', 'PANTS（1本目）の裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtWaistGrossMax = parseFloat(corPtWaistSize) + parseFloat(corPtWaistRangeMax);
		var corPtWaistGrossMin = parseFloat(corPtWaistSize) + parseFloat(corPtWaistRangeMin);

		if(corPtWaistGross<corPtWaistGrossMin || corPtWaistGross>corPtWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）のウエスト修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtWaistGrossMax = parseFloat(corPtThighSize) + parseFloat(corPtThighRangeMax);
		var corPtWaistGrossMin = parseFloat(corPtThighSize) + parseFloat(corPtThighRangeMin);

		if(corPtThighGross<corPtWaistGrossMin || corPtThighGross>corPtWaistGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）のワタリ幅修正'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}

		var corPtHemwidthGrossMax = parseFloat(corPtHemwidthSize) + parseFloat(corPtHemwidthRangeMax);
		var corPtHemwidthGrossMin = parseFloat(corPtHemwidthSize) + parseFloat(corPtHemwidthRangeMin);

		if(corPtHemwidthGross<corPtHemwidthGrossMin || corPtHemwidthGross>corPtHemwidthGrossMax){
			appendAlert('errormssage', getMsgByOneArg('msg136', 'PANTS（1本目）の裾幅'));
            return false;
		}else{
			appendAlertDel('errormssage');
		}
    }
    //GILITの場合
    if(item=='04'){
    	var giletModel = jQuery("#giletModel").val();
    	if(giletModel==""||giletModel==null){
    		appendAlert('errormssage', getMsgByOneArg('msg066', 'GILET モデル'));
            return false;
    	}else{
	    	appendAlertDel('errormssage');
		}

    	var glFigure = jQuery("#selectGiletFigure").val();
		var glNumber = jQuery("#selectGiletNumber").val();

    	if(isEmpty(glFigure)||isEmpty(glNumber)){
			appendAlert('errormssage', getMsgByOneArg('msg066', 'GILETサイズ'));
            return false;
		}else{
	    	appendAlertDel('errormssage');
		}
    }

    var productFabricNo = jQuery("#productFabricNo").val();

    if(isEmpty(productFabricNo)){
    	appendAlert('errormssage',getMsgByOneArg('msg001', '生地品番'));
		return false;
    }else{
    	appendAlertDel('errormssage');
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
    
    
    var statusInput = "${order.tscStatus}"
    if(isEmpty(statusInput)){
           
    }else{
    	jQuery("#statusInput").val(statusInput);
    }
	
	jQuery('select').removeAttr("disabled");
	jQuery('input').removeAttr("disabled");

	document.getElementById('formId').submit();
    return true;
}

//一時保存チェク
function temporarySaveCheck(){
	// エラーメッセージのDIVを表示しない
	jQuery("div.alert-error").hide();
	jQuery("div.error-message-list").hide();
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

	//お客様氏名
	var custNm = jQuery("#custNm").val();
	if(charactersCheck(custNm)) {
		appendAlert('errormssage', getMsg('msg120'));
        return false;
    }else{
    	appendAlertDel('errormssage');
	}

	//フリガナ
	var custKanaNm = jQuery("#custKanaNm").val();
	if(charactersCheck(custKanaNm)) {
		appendAlert('errormssage', getMsg('msg120'));
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
		if (productEmbroideryNecessity == '1') {
			var embroideryName = jQuery("#embroideryName").val();
			if(embroideryName.length>15){
				appendAlert('errormssage', getMsgByTwoArgs('msg011', '刺繍ネーム','15'));
				return false;
			}else{
		    	appendAlertDel('errormssage');
			}

			if(embroideryNameCheck(embroideryName)) {
				appendAlertDel('errormssage');
		    }else{
		    	appendAlert('errormssage', getMsgByOneArg('msg137','刺繍ネーム'));
		        return false;
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


function clearNoNum(obj) {
	obj.value = obj.value.replace(/[^\d.]/g,"");
    obj.value = obj.value.replace(/^\./g,""); 
    obj.value = obj.value.replace(/\.{2,}/g,"."); 
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d).*$/,'$1$2.$3');

    if(obj.value.indexOf(".")==-1){
		obj.value = obj.value.substring(0,3);
	}

}

//在庫チェク
function stockCheck(){
	var item = jQuery("#item option:selected").val();
	var productFabricNo = jQuery("#productFabricNo").val();
	jQuery("div.error-message-list").hide();
	//注文のTSCステータス
	var orderStatus = "${order.tscStatus}";
	//戻るの場合、orderFormのTSCステータス
	var orderFormStatus = "${orderForm.status}";
	//T0 ：一時保存、T1 ：取り置き、""：ステータス無し
	//オーダー一覧から来たの場合
	if(　((orderStatus=="T0"||orderStatus=="T1")&&orderFormStatus=="")||
		//「内容確認」画面来たの場合	
		((orderFormStatus=="T0"||orderFormStatus=="T1")&&orderStatus=="")||
		//新規登録の場合
		(orderStatus==""&&orderFormStatus=="")){
		
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
			//var versionFlag = "";
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
			
			//保存flag ２：在庫チェク
			//jQuery("#saveFlag").val("2");
			
			//注文を登録
			jQuery('select').removeAttr("disabled");
			jQuery('input').not("#clothName_yes").removeAttr("disabled");
			jQuery.ajax({url : contextPath + "/order/stockDecrease",
			    type: "post",
			    async:false,
			    data: jQuery('#formId').serialize(),
			 }).then(function(result){
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
						var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
						version = version.responseText;
						jQuery("#version").val(version);
						/* versionFlag = result;
						jQuery("#versionFlag").val(versionFlag); */
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
						 var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":result.orderId},async:false});
						 version = version.responseText;
						 jQuery("#version").val(version);
						 /* versionFlag = "true";
						 jQuery("#versionFlag").val(versionFlag); */
					 }
				}		 
				 /* else if(result == "1"){
					 versionFlag = "false";
					 jQuery("#versionFlag").val(versionFlag);
					 jQuery("#version").val(jQuery("#version").val());
				     appendAlert('errormssage', getMsg('msg048'));
				 } */
			 })
			 changeViewArea();
		//生地品番が有りの場合
	    }else{
	    	//var versionFlag = "";
	    	//保存flag ２：在庫チェク
	    	//jQuery("#saveFlag").val("2");
	    	
			//在庫チェック
			var checkResult = fabricCheck(item,productFabricNo);
			//在庫成功の場合
			if(checkResult == "0"){
				//注文を登録　8、9
				jQuery('select').removeAttr("disabled");
				jQuery('input').not("#clothName_yes").removeAttr("disabled");
				jQuery.ajax({url : contextPath + "/order/stockDecrease",
				    type: "post",
				    async:false,
				    data: jQuery('#formId').serialize(),
			        }).then(function(result){
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
								jQuery("#status").empty();
							   	 var statusInput = jQuery("#statusInput").val();
								 if(statusInput=="T0"){
								 	 jQuery("#status").html("一時保存");
								 }else{
									 jQuery("#status").html("取り置き");
								 }
				        		var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":jQuery("#orderId").val()},async:false});
								version = version.responseText;
								jQuery("#version").val(version);
								/* versionFlag = result;
								jQuery("#versionFlag").val(versionFlag); */
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
								 var version = jQuery.ajax({url:contextPath + "/order/getOrderVersion",data:{"orderId":result.orderId},async:false});
								 version = version.responseText;
								 jQuery("#version").val(version);
								 /* versionFlag = "true";
								 jQuery("#versionFlag").val(versionFlag); */
							 }
						}
			        	/* else if(result == "1"){
						    	versionFlag = "false";
								jQuery("#versionFlag").val(versionFlag);
						    	appendAlert('errormssage', getMsg('msg048'));
						    	jQuery("#version").val(jQuery("#version").val());
						 } */
				    });
			}
			//生地によって、商品を表示
			if(checkResult == "0"||checkResult == "2"){
				fabricView(item,productFabricNo);
			}
			changeViewArea();
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
				 colorSet(item,color);
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

//組成表示
function compositionExpress(){
	//組成表示の制御
	//JACKET組成表示　胴裏地
	var bodyText = "";
	//JACKET組成表示　袖裏地
	var sleeveText = "";
	//GILET組成表示　胴裏地
	var glBodyText = "";
	
	//組成表示　胴裏地
	//item
	var item = jQuery("#item").val();
	//スペアパンツ
	var sparePants = jQuery('input[name="productSparePantsClass"]:checked').val();
	//３Piece
	var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();

	if(item == "01"){
		jQuery("#compos_body_liner_p").empty();
		jQuery("#productComposBodyLiner").val("");
		bodyText = jQuery("#bodyBackMate").find("option:selected").text();
		jQuery("#compos_body_liner_p").append("JACKET："+bodyText);
		jQuery("#productComposBodyLiner").val("JACKET："+bodyText);
		
		jQuery("#bodyBackMate").change(function(){
			 jQuery("#compos_body_liner_p").empty();
			 bodyText = jQuery("#bodyBackMate").find("option:selected").text();
			 bodyText = "JACKET："+bodyText;
			 jQuery("#compos_body_liner_p").append(bodyText);
			 jQuery("#productComposBodyLiner").val(bodyText);
		})
		
		var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
		if(threePiece == "0009902"){
			jQuery("#bodyBackMate").change(function(){
				glBodyText = jQuery("#og_backLiningMate").find("option:selected").text();
				glBodyText = "GILET："+glBodyText;
				bodyText = jQuery("#bodyBackMate").find("option:selected").text();
				bodyText = "JACKET："+bodyText;
				jQuery("#productComposBodyLiner").val(bodyText+" "+glBodyText);
				jQuery("#compos_body_liner_p").html(bodyText).append("<Br>").append(glBodyText);
			})
		}else if(threePiece == "0009901"){
			jQuery("#compos_body_liner_p").empty();
			bodyText = jQuery("#bodyBackMate").find("option:selected").text();
			jQuery("#compos_body_liner_p").append("JACKET："+bodyText);
			var bodyTextHtml = jQuery("#compos_body_liner_p").html();
			jQuery("#productComposBodyLiner").val(bodyTextHtml);
		}
		
		jQuery('input[name="productIs3Piece"]').each(function() {
			jQuery(this).change(function(){
				var threePiece = jQuery(this).val();
				if(threePiece == "0009902"){
					jQuery("#bodyBackMate").change(function(){
						glBodyText = jQuery("#og_backLiningMate").find("option:selected").text();
						glBodyText = "GILET："+glBodyText;
						bodyText = jQuery("#bodyBackMate").find("option:selected").text();
						bodyText = "JACKET："+bodyText;
						jQuery("#productComposBodyLiner").val(bodyText+" "+glBodyText);
						jQuery("#compos_body_liner_p").html(bodyText).append("<Br>").append(glBodyText);
					})
				}else if(threePiece == "0009901"){
					jQuery("#compos_body_liner_p").empty();
					bodyText = jQuery("#bodyBackMate").find("option:selected").text();
					jQuery("#compos_body_liner_p").append("JACKET："+bodyText);
					var bodyTextHtml = jQuery("#compos_body_liner_p").html();
					jQuery("#productComposBodyLiner").val(bodyTextHtml);
				}
			});
		})
	}else if(item == "02"){
		jQuery("#productComposBodyLiner").val("");
		jQuery("#compos_body_liner_p").empty();
		bodyText = jQuery("#bodyBackMate").find("option:selected").text();
		jQuery("#compos_body_liner_p").append("JACKET："+bodyText);
		jQuery("#productComposBodyLiner").val("JACKET："+bodyText);
		
		jQuery("#bodyBackMate").change(function(){
			jQuery("#productComposBodyLiner").val("");
			jQuery("#compos_body_liner_p").empty();
			bodyText = jQuery("#bodyBackMate").find("option:selected").text();
			bodyText = "JACKET："+bodyText;
			jQuery("#compos_body_liner_p").append(bodyText);
			jQuery("#productComposBodyLiner").val(bodyText);
		})
	}else if(item == "03"){
		 jQuery("#compos_body_liner_p").empty();
		 jQuery("#productComposBodyLiner").val("");
	}else if(item == "04"){
		jQuery("#productComposBodyLiner").val("");
		jQuery("#compos_body_liner_p").empty();
		glBodyText = jQuery("#og_backLiningMate").find("option:selected").text();
		jQuery("#compos_body_liner_p").append("GILET："+glBodyText);
		jQuery("#productComposBodyLiner").val("GILET："+glBodyText);
		
		jQuery("#og_backLiningMate").change(function(){
			 jQuery("#compos_body_liner_p").empty();
			 glBodyText = jQuery("#og_backLiningMate").find("option:selected").text();
			 jQuery("#compos_body_liner_p").append("GILET："+glBodyText);
			 jQuery("#productComposBodyLiner").val("GILET："+glBodyText);
		})
	}
	//組成表示　袖裏地
	if(item == "01"||item == "02"){
		sleeveText = jQuery("#cuffBackMate").find("option:selected").text();
		jQuery("#cuffBackMate").change(function(){
			sleeveText = jQuery("#cuffBackMate").find("option:selected").text();
			 jQuery("#compos_sleeve_liner_p").html(sleeveText);
			 jQuery("#productComposSleeveLiner").val(sleeveText);
		})
		jQuery("#compos_sleeve_liner_p").html(sleeveText);
		jQuery("#productComposSleeveLiner").val(sleeveText);
	}else{
		jQuery("#compos_sleeve_liner_p").html("");
		jQuery("#productComposSleeveLiner").val("");
	}
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
		if (frontBtnCnt == "0000105") {
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
			if (frontBtnCnt == "0000105") {
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

function modelCheck(modelCode,productFabricNo,orderPattern,itemCode,subItemCode){
	var checkResult = jQuery.ajax({url:contextPath + "/order/checkModel",data:{"modelCode":modelCode,"productFabricNo":productFabricNo,"orderPattern":orderPattern,"itemCode":itemCode,"subItemCode":subItemCode},async:false});
	checkResult = checkResult.responseText;
	return checkResult;
}

function getModelByItem(){
	
	var itemCode = jQuery("#item").val();
	if(itemCode == "01"){
		var jkModel = document.getElementById("jacketModel");
		jkModel.options.length=0;

		var glModel = document.getElementById("giletModel");
		glModel.options.length=0;

		var ptModel = document.getElementById("op_pantsModel");
		ptModel.options.length=0;

		var pt2Model = document.getElementById("op2_pantsModel");
		pt2Model.options.length=0;
		
		jkModel.add(new Option("モデル選択",""));
		glModel.add(new Option("モデル選択",""));
		ptModel.add(new Option("モデル選択",""));
		pt2Model.add(new Option("モデル選択",""));
		
		jQuery.ajax({
	        url: contextPath + "/order/getModel",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	               if(e.subItemCode == "02"){
	            	   jkModel.add(new Option(e.modelName,e.modelCode));
	               }
	               if(e.subItemCode == "03"){
	            	   ptModel.add(new Option(e.modelName,e.modelCode));
	               }
	               if(e.subItemCode == "04"){
	            	   glModel.add(new Option(e.modelName,e.modelCode));
	               }
	               if(e.subItemCode == "07"){
	            	   pt2Model.add(new Option(e.modelName,e.modelCode));
	               }
	           });
	        }
	    });

		var allJkOption = jkModel.options;
		allJkOption[0].disabled = true;

		var allPtOption = ptModel.options;
		allPtOption[0].disabled = true;

		var allGlOption = glModel.options;
		allGlOption[0].disabled = true;

		var allPt2Option = pt2Model.options;
		allPt2Option[0].disabled = true;
	    
	}else if(itemCode == "02"){
		var jkModel = document.getElementById("jacketModel");
		jkModel.options.length=0;
		jkModel.add(new Option("モデル選択",""));
		jQuery.ajax({
	        url: contextPath + "/order/getModel",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	           		jkModel.add(new Option(e.modelName,e.modelCode));
	           });
	        }
	    });
		var allJkOption = jkModel.options;
		allJkOption[0].disabled = true;
	}else if(itemCode == "03"){
		var ptModel = document.getElementById("op_pantsModel");
		ptModel.options.length=0;
		ptModel.add(new Option("モデル選択",""));
		jQuery.ajax({
	        url: contextPath + "/order/getModel",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	        	   ptModel.add(new Option(e.modelName,e.modelCode));
	           });
	        }
	    });
		var allPtOption = ptModel.options;
		allPtOption[0].disabled = true;
	}else if(itemCode == "04"){
		var glModel = document.getElementById("giletModel");
		glModel.options.length=0;
		glModel.add(new Option("モデル選択",""));
		jQuery.ajax({
	        url: contextPath + "/order/getModel",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	        	   glModel.add(new Option(e.modelName,e.modelCode));
	           });
	        }
	    });
		var allGlOption = glModel.options;
		allGlOption[0].disabled = true;
	}
}

function getAdjustByItem(){
	var subItemCode = "";
	var itemCode = jQuery("#item").val();
	if(itemCode == "01"){
		jQuery.ajax({
	        url: contextPath + "/order/getAdjustByItem",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	        	   if(e.subItemCode == "02"){
						if(e.adjusteClass == "01"){
							document.getElementById("corJkBodyRange").max = e.adjusteMax;
							document.getElementById("corJkBodyRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "02"){
							document.getElementById("corJkWaistRange").max = e.adjusteMax;
							document.getElementById("corJkWaistRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "03"){
							document.getElementById("corJkRightsleeveRange").max = e.adjusteMax;
							document.getElementById("corJkRightsleeveRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "04"){
							document.getElementById("corJkLeftsleeveRange").max = e.adjusteMax;
							document.getElementById("corJkLeftsleeveRange").min = e.adjusteMin;
						}
		           }
		           if(e.subItemCode == "03"){
		        	   if(e.adjusteClass == "06"){
							document.getElementById("corPtWaistRange").max = e.adjusteMax;
							document.getElementById("corPtWaistRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "07"){
							document.getElementById("corPtThighRange").max = e.adjusteMax;
							document.getElementById("corPtThighRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "08"){
							document.getElementById("corPtHemwidthRange").max = e.adjusteMax;
							document.getElementById("corPtHemwidthRange").min = e.adjusteMin;
						}
			       }
		           if(e.subItemCode == "07"){
		        	   if(e.adjusteClass == "06"){
							document.getElementById("corPt2WaistRange").max = e.adjusteMax;
							document.getElementById("corPt2WaistRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "07"){
							document.getElementById("corPt2ThighRange").max = e.adjusteMax;
							document.getElementById("corPt2ThighRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "08"){
							document.getElementById("corPt2HemwidthRange").max = e.adjusteMax;
							document.getElementById("corPt2HemwidthRange").min = e.adjusteMin;
						}
			       }
	           });
	        }
	    });
	}else if(itemCode == "02"){
		jQuery.ajax({
	        url: contextPath + "/order/getAdjustByItem",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	        	   if(e.subItemCode == "02"){
						if(e.adjusteClass == "01"){
							document.getElementById("corJkBodyRange").max = e.adjusteMax;
							document.getElementById("corJkBodyRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "02"){
							document.getElementById("corJkWaistRange").max = e.adjusteMax;
							document.getElementById("corJkWaistRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "03"){
							document.getElementById("corJkRightsleeveRange").max = e.adjusteMax;
							document.getElementById("corJkRightsleeveRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "04"){
							document.getElementById("corJkLeftsleeveRange").max = e.adjusteMax;
							document.getElementById("corJkLeftsleeveRange").min = e.adjusteMin;
						}
		           }
	           });
	        }
	    });
	}else if(itemCode == "03"){
		jQuery.ajax({
	        url: contextPath + "/order/getAdjustByItem",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	        	   if(e.subItemCode == "03"){
		        	   if(e.adjusteClass == "06"){
							document.getElementById("corPtWaistRange").max = e.adjusteMax;
							document.getElementById("corPtWaistRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "07"){
							document.getElementById("corPtThighRange").max = e.adjusteMax;
							document.getElementById("corPtThighRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "08"){
							document.getElementById("corPtHemwidthRange").max = e.adjusteMax;
							document.getElementById("corPtHemwidthRange").min = e.adjusteMin;
						}
			       }
	           });
	        }
	    });
	}
}

function getFigureAndNumberByItem(){
	var subItemCode = "";
	var itemCode = jQuery("#item").val();
	var jkModel = jQuery("#jacketModel").val();
	var glModel = jQuery("#giletModel").val();
	var ptModel = jQuery("#op_pantsModel").val();
	var pt2Model = jQuery("#op2_pantsModel").val();
	if(itemCode == "01"){
		if(isNotEmpty(jkModel)){
			subItemCode = "02";
			var jkFigure = document.getElementById("selectJacketFigure");
     	    getSizeFigure(itemCode,subItemCode,jkModel,jkFigure);
     	    

			var jkNumber = document.getElementById("selectJacketNumber");
			getSizeNumber(itemCode,subItemCode,jkModel,jkNumber);
		}
		if(isNotEmpty(ptModel)){
			subItemCode = "03";
			var ptFigure = document.getElementById("selectPantsFigure");
     	    getSizeFigure(itemCode,subItemCode,ptModel,ptFigure);
     	    

			var ptNumber = document.getElementById("selectPantsNumber");
			getSizeNumber(itemCode,subItemCode,ptModel,ptNumber);
		}

		if(isNotEmpty(pt2Model)){
			subItemCode = "07";
			var pt2Figure = document.getElementById("selectPants2Figure");
     	    getSizeFigure(itemCode,subItemCode,pt2Model,pt2Figure);
     	    

			var pt2Number = document.getElementById("selectPants2Number");
			getSizeNumber(itemCode,subItemCode,pt2Model,pt2Number);
		}

		if(isNotEmpty(glModel)){
			subItemCode = "04";
			var glFigure = document.getElementById("selectGiletFigure");
     	    getSizeFigure(itemCode,subItemCode,glModel,glFigure);
     	    

			var glNumber = document.getElementById("selectGiletNumber");
			getSizeNumber(itemCode,subItemCode,glModel,glNumber);
		}
		
	}else if(itemCode == "02"){
		subItemCode = itemCode;
		var jkFigure = document.getElementById("selectJacketFigure");
 	    getSizeFigure(itemCode,subItemCode,jkModel,jkFigure);
 	    

		var jkNumber = document.getElementById("selectJacketNumber");
		getSizeNumber(itemCode,subItemCode,jkModel,jkNumber);
	}else if(itemCode == "03"){
		subItemCode = itemCode;
		var ptFigure = document.getElementById("selectPantsFigure");
 	    getSizeFigure(itemCode,subItemCode,ptModel,ptFigure);
 	    

		var ptNumber = document.getElementById("selectPantsNumber");
		getSizeNumber(itemCode,subItemCode,ptModel,ptNumber);
	}else if(itemCode == "04"){
		subItemCode = itemCode;
		var glFigure = document.getElementById("selectGiletFigure");
 	    getSizeFigure(itemCode,subItemCode,glModel,glFigure);
 	    

		var glNumber = document.getElementById("selectGiletNumber");
		getSizeNumber(itemCode,subItemCode,glModel,glNumber);
	}
}

function getSizeFigure(itemCode,subItemCode,modelCode,figure){
	figure.options.length=0;
	figure.add(new Option("選択　　　",""));
	jQuery.ajax({
        url: contextPath + "/order/getSizeFigureByItem",
        type: 'get',
        async:false,
        data:{"orderPattern":orderPattern,"itemCode":itemCode,"subItemCode":subItemCode,"modelCode":modelCode},
        success: function(data){
           jQuery.each(data, function (index, e) {
        	   figure.add(new Option(e.figure,e.figure));
           });
        }
    });
}

function getSizeNumber(itemCode,subItemCode,modelCode,number){
	number.options.length=0;
	number.add(new Option("選択　　　",""));
	jQuery.ajax({
        url: contextPath + "/order/getSizeNumberByItem",
        type: 'get',
        async:false,
        data:{"orderPattern":orderPattern,"itemCode":itemCode,"subItemCode":subItemCode,"modelCode":modelCode},
        success: function(data){
           jQuery.each(data, function (index, e) {
        	   number.add(new Option(e.sizeNumber,e.sizeNumber));
           });
        }
    });
}

function jkAdjust(){
	jacketModel = jQuery("#jacketModel option:selected").val();
	if(jacketModel==""||jacketModel==null){

	}else{
		jQuery("#corJkBodyRange").val(0);
		setFont("corJkBodyRange");
		jQuery("#corJkWaistRange").val(0);
		setFont("corJkWaistRange");
		jQuery("#corJkRightsleeveRange").val(0);
		setFont("corJkRightsleeveRange");
		jQuery("#corJkLeftsleeveRange").val(0);
		setFont("corJkLeftsleeveRange");

		jQuery("#corJkBodyRange_out").val("0");
		jQuery("#corJkWaistRange_out").val("0");
		jQuery("#corJkRightsleeveRange_out").val("0");
		jQuery("#corJkLeftsleeveRange_out").val("0");
	}
	
	
	var subItemCode = "02";
	jacketFigure = jQuery("#selectJacketFigure").val();
	jacketNumber = jQuery("#selectJacketNumber").val();
	if(isNotEmpty(jacketFigure)&&isNotEmpty(jacketNumber)){
		jQuery.ajax({
	        url: contextPath + "/order/getPoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":jacketModel,"figure":jacketFigure,"number":jacketNumber},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "01"){
						jQuery("#corJkBody_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corJkBody_div_Size").val(data[i].typeSize);
	            		jQuery("#corJkBody_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "02"){
						jQuery("#corJkWaist_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corJkWaist_div_Size").val(data[i].typeSize);
	            		jQuery("#corJkWaist_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "03"){
						jQuery("#corJkRightsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corJkRightsleeve_div_Size").val(data[i].typeSize);
	            		jQuery("#corJkRightsleeve_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "04"){
						jQuery("#corJkLeftsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corJkLeftsleeve_div_Size").val(data[i].typeSize);
	            		jQuery("#corJkLeftsleeve_div_Gross").val(data[i].typeSize);
					}
		        }
		    }
		})
	}else{
		for (jk of jkAdjustList) {
			jQuery("#"+jk.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+jk.id+"_Size").val("0");
    		jQuery("#"+jk.id+"_Gross").val("0");
		}
	}
}

function ptAdjust(){
	pantsModel = jQuery("#op_pantsModel").val();
	if(pantsModel==""||pantsModel==null){
		
	}else{
		jQuery("#corPtWaistRange").val(0);
		setFont("corPtWaistRange");
		jQuery("#corPtThighRange").val(0);
		setFont("corPtThighRange");
		jQuery("#corPtHemwidthRange").val(0);
		setFont("corPtHemwidthRange");

		jQuery("#corPtWaistRange_out").html('0');
		jQuery("#corPtThighRange_out").html('0');
		jQuery("#corPtHemwidthRange_out").html('0');
	}
	var subItemCode = "03";
	pantsFigure = jQuery("#selectPantsFigure").val();
	pantsNumber = jQuery("#selectPantsNumber").val();
	opTack = jQuery("#op_tack").val();

	

	//ノータック:0000101  1アウトタック:0000102  2アウトタック:0000104
	if(isNotEmpty(pantsFigure)&&isNotEmpty(pantsNumber)){
		jQuery.ajax({
	        url: contextPath + "/order/getPoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":pantsModel,"figure":pantsFigure,"number":pantsNumber},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "09"){
	            		jQuery("#corPtRightinseam_div_Size").val(data[i].typeSize);
					}else if(data[i].adjustClass == "10"){
	            		jQuery("#corPtLeftinseam_div_Size").val(data[i].typeSize);
					}else if(data[i].adjustClass == "06"){
						jQuery("#corPtWaist_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPtWaist_div_Size").val(data[i].typeSize);
	            		jQuery("#corPtWaist_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "08"){
						jQuery("#corPtHemwidth_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPtHemwidth_div_Size").val(data[i].typeSize);
	            		jQuery("#corPtHemwidth_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "07"){
						if(opTack=="0000102"){
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize1Outtack + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize1Outtack);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize1Outtack);
						}else if(opTack=="0000104"){
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize2Outtack + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize2Outtack);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize2Outtack);
						}else{
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize);
						}
					}
		        }
		    }
		})
	}else{
		for (ptt of ptTackList) {
			jQuery("#"+ptt.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+ptt.id+"_Size").val("0");
    		jQuery("#"+ptt.id+"_Gross").val("0");
		}
		for (pt of ptAdjustList) {
			jQuery("#"+pt.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+pt.id+"_Size").val("0");
    		jQuery("#"+pt.id+"_Gross").val("0");
		}
	}
}

function pt2Adjust(){
	pants2Model = jQuery("#op2_pantsModel").val();
	if(pants2Model==""||pants2Model==null){
		
	}else{
		jQuery("#corPt2WaistRange").val(0);
		setFont("corPt2WaistRange");
		jQuery("#corPt2ThighRange").val(0);
		setFont("corPt2ThighRange");
		jQuery("#corPt2HemwidthRange").val(0);
		setFont("corPt2HemwidthRange");
		jQuery("#corPt2WaistRange_out").html('0');
		jQuery("#corPt2ThighRange_out").html('0');
		jQuery("#corPt2HemwidthRange_out").html('0');
	}

	var subItemCode = "07";
	pants2Figure = jQuery("#selectPants2Figure").val();
	pants2Number = jQuery("#selectPants2Number").val();
	op2Tack = jQuery("#op2_tack").val();
	//ノータック:0000101  1アウトタック:0000102  2アウトタック:0000104
	if(isNotEmpty(pants2Figure)&&isNotEmpty(pants2Number)){
		jQuery.ajax({
	        url: contextPath + "/order/getPoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":pants2Model,"figure":pants2Figure,"number":pants2Number},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "09"){
	            		jQuery("#corPt2Rightinseam_div_Size").val(data[i].typeSize);
					}else if(data[i].adjustClass == "10"){
	            		jQuery("#corPt2Leftinseam_div_Size").val(data[i].typeSize);
					}else if(data[i].adjustClass == "06"){
						jQuery("#corPt2Waist_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPt2Waist_div_Size").val(data[i].typeSize);
	            		jQuery("#corPt2Waist_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "08"){
						jQuery("#corPt2Hemwidth_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPt2Hemwidth_div_Size").val(data[i].typeSize);
	            		jQuery("#corPt2Hemwidth_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "07"){
						if(op2Tack=="0000102"){
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize1Outtack + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize1Outtack);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize1Outtack);
						}else if(op2Tack=="0000104"){
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize2Outtack + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize2Outtack);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize2Outtack);
						}else{
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize);
						}
					}
		        }
		    }
		})
	}else{
		for (ptt2 of pt2TackList) {
			jQuery("#"+ptt2.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+ptt2.id+"_Size").val("0");
    		jQuery("#"+ptt2.id+"_Gross").val("0");
		}
		for (pt2 of pt2AdjustList) {
			jQuery("#"+pt2.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+pt2.id+"_Size").val("0");
    		jQuery("#"+pt2.id+"_Gross").val("0");
		}
	}
}

function colorSet(item,color){
	if(color!=null&&color!=""){
		 // 生地品番の値から対象の素材色をセット
		 color = color.toUpperCase();

		 var sBackValue = jQuery("#bodyBackMateStkNo").val();
		 var sCuffValue = jQuery("#cuffBackMateStkNo").val();
		 var sButtonValue = jQuery("#btnMateStkNo").val();
		 var colorFlag = "";
		 switch (color) {
			case 'Z':
				colorFlag = "0";
				//5001WY-10Y(黒) : 100010002
				sBackValue = "100010002";
				//S1890-BK(黒)
				sCuffValue = "200010005";
				//DEL-10-09(黒)
				sButtonValue = "300080002";
				break;
			case 'M':
				colorFlag = "0";
				//5001WY-130Y(ネイビー)
				sBackValue = "100010007";
				//CS3253-18(ネイビー)
				sCuffValue = "200010003";
				//DEL-10-59(ネイビー)
				sButtonValue = "300080005";
				break;
			case 'D':
				colorFlag = "0";
				//5001WY-F202Y(ブルー)
				sBackValue = "100010006";
				//CS3253-18(ネイビー)
				sCuffValue = "200010003";
				//DEL-10-59(ネイビー)
				sButtonValue = "300080005";
				break;
			case 'X':
				colorFlag = "0";
				//5001WY-3Y(グレー)
				sBackValue = "100010001";
				//CS3253-892(チャコールグレー)
				sCuffValue = "200010004";
				//DEL-10-08(グレー)
				sButtonValue = "300080001";
				break;
			case 'G':
				colorFlag = "0";
				//5001WY-3Y(グレー)
				sBackValue = "100010001";
				//CS3253-892(チャコールグレー)
				sCuffValue = "200010004";
				//DEL-10-08(グレー)
				sButtonValue = "300080001";
				break;
			case 'E':
				colorFlag = "0";
				//5001WY-F32Y(ライトグレー)
				sBackValue = "100010005";
				//CS3253-11(ライトグレー)
				sCuffValue = "200010002";
				//DEL-10-08(グレー)
				sButtonValue = "300080001";
				break;
			case 'J':
				colorFlag = "0";
				//5001WY-25Y(ブラウン)
				sBackValue = "100010003";
				//CS3253-3(ベージュ)
				sCuffValue = "200010001";
				//DEL-10-45(ブラウン)
				sButtonValue = "300080004";
				break;
			case 'K':
				colorFlag = "0";
				//5001WY-F22Y(ベージュ)
				sBackValue = "100010004";
				//CS3253-3(ベージュ)
				sCuffValue = "200010001";
				//DEL-10-42(ベージュ)
				sButtonValue = "300080003";
				break;
			default:
				colorFlag = "1";
		 }
		 if(colorFlag=="0"){
			// 各項目ポリエステルの場合に設定する 
			 //SUITとJACKETの場合
			 if(item == "01" || item == "02"){
				 //ポリエステル  1000100
				 if(jQuery('#bodyBackMate').val() == "1000100") {
							jQuery('#bodyBackMateStkNo').val([sBackValue]);
							jQuery("#bodyBackMateStkNo").prop("disabled",true);
							jQuery('#og_backLiningMateStkNo').val([sBackValue]);
							jQuery('#og_insideLiningMateStkNo').val([sBackValue]);
					 }
				 jQuery('#bodyBackMate').change(function(){
					 if(jQuery('#bodyBackMate').val() == "1000100") {
							jQuery('#bodyBackMateStkNo').val([sBackValue]);
							jQuery("#bodyBackMateStkNo").prop("disabled",true);
							jQuery('#og_backLiningMateStkNo').val([sBackValue]);
							jQuery('#og_insideLiningMateStkNo').val([sBackValue]);
					 }
				 })
				 //ポリエステル  2000100
				 if(jQuery('#cuffBackMate').val() == "2000100") {
					  jQuery('#cuffBackMateStkNo').val([sCuffValue]);
					  jQuery('#cuffBackMateStkNo').prop("disabled", true);
				 }
			 	 jQuery('#cuffBackMate').change(function(){
				 	if(jQuery('#cuffBackMate').val() == "2000100") {
					  jQuery('#cuffBackMateStkNo').val([sCuffValue]);
					  jQuery('#cuffBackMateStkNo').prop("disabled", true);
				 	}
			 	 })
			 	 //ユリア 3000800
			 	 if(jQuery('#btnMate').val() == "3000800") {
					 	 jQuery('#btnMateStkNo').val([sButtonValue]);
						 jQuery('#btnMateStkNo').prop("disabled", true);
						 jQuery('#op_btnMateStkNo').val([sButtonValue]);
						 jQuery('#op2_btnMateStkNo').val([sButtonValue]);
						 jQuery('#og_frontBtnMateStkNo').val([sButtonValue]);
				 }
			 	 jQuery('#btnMate').change(function(){
				 	 if(jQuery('#btnMate').val() == "3000800") {
					 	 jQuery('#btnMateStkNo').val([sButtonValue]);
						 jQuery('#btnMateStkNo').prop("disabled", true);
						 jQuery('#op_btnMateStkNo').val([sButtonValue]);
						 jQuery('#op2_btnMateStkNo').val([sButtonValue]);
						 jQuery('#og_frontBtnMateStkNo').val([sButtonValue]);
				 	}
				 })
			 }
			//PANTSの場合
			if(item == "03"){
				 	if(jQuery('#op_btnMate').val() == "3000800"){
						jQuery('#op_btnMateStkNo').val([sButtonValue]);
						jQuery('#op_btnMateStkNo').prop("disabled", true);;
					}
				 	jQuery('#op_btnMate').change(function(){
				 		if(jQuery('#op_btnMate').val() == "3000800"){
							jQuery('#op_btnMateStkNo').val([sButtonValue]);
							jQuery('#op_btnMateStkNo').prop("disabled", true);;
						}
					})
			 }
			 //GILETの場合
			 if(item == "04"){
				 if(jQuery('#og_backLiningMate').val() == "1000100"){
					 jQuery('#og_backLiningMateStkNo').val([sBackValue])
					 jQuery('#og_backLiningMateStkNo').prop("disabled", true);
					 jQuery('#og_insideLiningMateStkNo').val([sBackValue]);
					 jQuery('#og_insideLiningMateStkNo').prop("disabled", true);
				 }
				 jQuery('#og_backLiningMate').change(function(){
					 if(jQuery('#og_backLiningMate').val() == "1000100"){
						 jQuery('#og_backLiningMateStkNo').val([sBackValue])
						 jQuery('#og_backLiningMateStkNo').prop("disabled", true);
						 jQuery('#og_insideLiningMateStkNo').val([sBackValue]);
						 jQuery('#og_insideLiningMateStkNo').prop("disabled", true);
					 }
				 })
				 if(jQuery('#og_frontBtnMate').val() == "3000800"){
					 jQuery('#og_frontBtnMateStkNo').val([sButtonValue]);
					 jQuery('#og_frontBtnMateStkNo').prop("disabled", true);
				 }
				 jQuery('#og_frontBtnMate').change(function(){
					 if(jQuery('#og_frontBtnMate').val() == "3000800"){
						 jQuery('#og_frontBtnMateStkNo').val([sButtonValue]);
						 jQuery('#og_frontBtnMateStkNo').prop("disabled", true);
					 }
				 })
			 }
		 }
		 else{
			
		 }
	}
}

if (document.readyState=="complete")  
{  
        $.unblockUI();
}  
else  
{  
        document.onreadystatechange = function()  
        {  
             
                if (document.readyState == "complete")  
                {  
                        $.unblockUI();   
                }  
        }  
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
</script>
