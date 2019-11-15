 <form:form id="idInfoForm" action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm" method="post" modelAttribute="orderCoForm" class="form-horizontal">
            <div id="op_shirt_div">
            <div class="card-header">
                <strong class="card-title">SHIRT</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">SHIRTモデル</label></div>
                            <div class="col col-md-3">
                                <form:select id="shirtModel" path="coOptionShirtStandardInfo.osShirtModel" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionShirtStandardInfo.osShirtModelMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="shirtModelMsg" style="margin-top:8px"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="shirtModelCheck" style="display:none"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">襟型</label></div>
                            <div class="col-12 col-md-3">
                            	<form:select id="os_chainModel" path="coOptionShirtStandardInfo.osChainModel" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionShirtStandardInfo.osChainModelMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="os_chainModel_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">カフス</label></div>
                            <div class="col col-md-3">
                            	<form:select id="os_cuffs" path="coOptionShirtStandardInfo.osCuffs" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionShirtStandardInfo.osCuffsMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="os_cuffs_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コンバーチブル</label></div>
                            <div class="col col-md-3">
                            	<form:select id="os_convertible" path="coOptionShirtStandardInfo.osConvertible" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionShirtStandardInfo.osConvertibleMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="os_convertible_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスト釦</label></div>
                            <div class="col col-md-3">
                            	<form:select id="os_adjustBtn" path="coOptionShirtStandardInfo.osAdjustBtn" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionShirtStandardInfo.osAdjustBtnMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="os_adjustBtn_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">クレリック仕様</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_clericSpec_id" path="coOptionShirtStandardInfo.osClericSpec" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.osClericSpecMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="os_clericSpec_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ダブルカフス仕様</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_dblCuff_id" path="coOptionShirtStandardInfo.osDblCuff" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.osDblCuffMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="os_dblCuff_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">カフスボタン追加</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_AddCuff_id" path="coOptionShirtStandardInfo.osAddCuff" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.osAddCuffMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="os_AddCuff_Msg">
                            </div>
                        </div>
                       <!--  <div class="row form-group" id="os_cuffCleric_div">
                            <div class="col col-md-3"><label class=" form-control-label">袖クレリック</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="os_cuffCleric_yes" class="form-check-label ">
                                        <input type="radio" id="os_cuffCleric_yes" name="os_cuffCleric" value="有り" class="form-check-input" checked>有り
                                    </label>　
                                    <label for="os_cuffCleric_no" class="form-check-label ">
                                        <input type="radio" id="os_cuffCleric_no" name="os_cuffCleric" value="無し" class="form-check-input">無し
                                    </label>
                                </div>
                            </div>
                        </div> -->
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦</label></div>
                            <div class="col-12 col-md-3">
                            	<form:select id="os_btnMate" path="coOptionShirtStandardInfo.osBtnMate" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionShirtStandardInfo.osBtnMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="os_btnMate_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タブ釦</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_tabBtn_id" path="coOptionShirtStandardInfo.osTabBtn" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.osTabBtnMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="os_tabBtn_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ガントレットボタン位置</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_galetteBtnPos_nomal_id" path="coOptionShirtStandardInfo.osGaletteBtnPos" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.osGaletteBtnPosMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="os_galetteBtnPos_nomal_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンホールピン</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_pinHolePin_id" path="coOptionShirtStandardInfo.osPinHolePin" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.osPinHolePinMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="os_pinHolePin_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_breastPk_yes_id" path="coOptionShirtStandardInfo.osBreastPk" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.osBreastPkMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="os_breastPk_yes_Msg">
                            </div>
                        </div>
                        <div class="row form-group" id="os_breastPkSizeArea">
                            <div class="col col-md-3"><label class=" form-control-label">胸ポケット大きさ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_breastPkSize_normal_id" path="coOptionShirtStandardInfo.osBreastPkSize" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.osBreastPkSizeMap}"/>
                             	</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="os_breastPkSize_normal_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロントデザイン</label></div>
                            <div class="col col-md-3">
                            	<form:select id="os_frontDesign" path="coOptionShirtStandardInfo.osFrontDesign" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionShirtStandardInfo.osFrontDesignMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="os_frontDesign_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンタックブザム</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_pinTack_no_id" path="coOptionShirtStandardInfo.osPinTack" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.osPinTackMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="os_pinTack_no_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_stitch_nomal_id" path="coOptionShirtStandardInfo.osStitch" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.osStitchMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="os_stitch_nomal_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">カラーキーパー</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_colorKeeper_id" path="coOptionShirtStandardInfo.osColorKeeper" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.osColorKeeperMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="os_colorKeeper_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタンホール色変更</label></div>
                            <div class="col col-md-3">
                            	<form:select id="os_bhColor" path="coOptionShirtStandardInfo.osBhColor" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionShirtStandardInfo.osBhColorMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="os_bhColor_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸色変更</label></div>
                            <div class="col col-md-3">
                            	<form:select id="os_byColor" path="coOptionShirtStandardInfo.osByColor" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionShirtStandardInfo.osByColorMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="os_byColor_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">カジュアルヘムライン仕様</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_casHemLine_id" path="coOptionShirtStandardInfo.osCasHemLine" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.osCasHemLineMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="os_casHemLine_Msg">
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="osCasHemLineCheck"></div>
                            <div class="col col-md-3 casHemLineSizeArea">　</div>
                            <div class="col-12 col-md-9 casHemLineSizeArea" style="display:none;">
                                <div class="form-check-inline form-check">
                                <select name="os_casHemLineSize100" id="os_casHemLineSize100" class="form-control-sm form-control hidedown casHemLineSizeValue" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                </select>
                                <select name="os_casHemLineSize10" id="os_casHemLineSize10" class="form-control-sm form-control hidedown casHemLineSizeValue" style="width:32px">
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
                                <select name="os_casHemLineSize1" id="os_casHemLineSize1" class="form-control-sm form-control hidedown casHemLineSizeValue" style="width:32px">
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
                                <select name="os_casHemLineSizeM1" id="os_casHemLineSizeM1" class="form-control-sm form-control hidedown casHemLineSizeValue" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>

                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタン位置変更</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_btnPosChg_id" path="coOptionShirtStandardInfo.osBtnPosChg" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.osBtnPosChgMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="os_btnPosChg_Msg">
                            </div>
                            <div id="os_btnPosChg_area" class="col-12 col-md-9" style="display:none;">
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">台襟釦</label>
                            </div>
                            <div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="os_btnPosChg_collar_m"><i class="fa fa-caret-square-o-down" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="os_btnPosChg_collar" name="coOptionShirtStandardInfo.stNeckbandBtnPosChg" value="0" min="-1" max="1" step="0.5">&nbsp;
                                <a href="#" id="os_btnPosChg_collar_p"><i class="fa fa-caret-square-o-up" style="font-size:32px"></i></a>
                                &nbsp;&nbsp;<output id="os_btnPosChg_collar_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">フロント第1釦</label>
                            </div>
                            <div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="os_btnPosChg_front1_m"><i class="fa fa-caret-square-o-down" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="os_btnPosChg_front1" name="coOptionShirtStandardInfo.stFrtfirstBtnPosChg" value="0" min="-3" max="3" step="0.5">&nbsp;
                                <a href="#" id="os_btnPosChg_front1_p"><i class="fa fa-caret-square-o-up" style="font-size:32px"></i></a>
                                &nbsp;&nbsp;<output id="os_btnPosChg_front1_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">フロント第2釦</label>
                            </div>
                            <div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="os_btnPosChg_front2_m"><i class="fa fa-caret-square-o-down" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="os_btnPosChg_front2" name="coOptionShirtStandardInfo.stFrtsecondBtnPosChg" value="0" min="-3" max="3" step="0.5">&nbsp;
                                <a href="#" id="os_btnPosChg_front2_p"><i class="fa fa-caret-square-o-up" style="font-size:32px"></i></a>
                                &nbsp;&nbsp;<output id="os_btnPosChg_front2_out">0</output>cm
                                </div>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            <input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="${orderCoForm.jacketItemFlag }"/>
			<input type="hidden" id="pantsItemFlag" name="pantsItemFlag" value="${orderCoForm.pantsItemFlag }"/>
			<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="${orderCoForm.giletItemFlag }"/>
			<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="0"/>
			<input type="hidden" id="shirtFlag" name="shirtFlag" value="0"/>
			<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="${orderCoForm.coatItemFlag }"/>
			<input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="${orderCoForm.pants2ItemFlag }"/>
            <input type="hidden" id="stCasualHemlineSize" name="coOptionShirtStandardInfo.stCasualHemlineSize"  value="" />
            <%-- <input type="hidden" id="shirtAdFlag" name="shirtAdFlag" value="${orderCoForm.shirtAdFlag }" />
            <input type="hidden" id="pants2AdFlag" name="pants2AdFlag" value="${orderCoForm.pants2AdFlag }" />
            <input type="hidden" id="jacketAdFlag" name="jacketAdFlag" value="${orderCoForm.jacketAdFlag }" />
            <input type="hidden" id="coatAdFlag" name="coatAdFlag" value="${orderCoForm.coatAdFlag }" />
            <input type="hidden" id="giletAdFlag" name="giletAdFlag" value="${orderCoForm.giletAdFlag }" />
            <input type="hidden" id="pantsAdFlag" name="pantsAdFlag" value="${orderCoForm.pantsAdFlag }" /> --%>
            <input type="hidden" id="osCasHemLineIdFlag" name="osCasHemLineIdFlag" value="${orderCoForm.osCasHemLineIdFlag }" />
            <%-- <input type="hidden" id="corStBodylengthGross" name="coAdjustShirtStandardInfo.corStBodylengthGross" value="${orderCoForm.coAdjustShirtStandardInfo.corStBodylengthGross}" />  --%>
            <%-- <input type="hidden" id="corStBodylengthSize"  name="coAdjustShirtStandardInfo.corStBodylengthSize"  value="${orderCoForm.coAdjustShirtStandardInfo.corStBodylengthSize}" /> --%>
</form:form>

<!-- 自作js -->
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.shirt.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/config.js"></script>

<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";
var shirtItemFlag="${orderCoForm.shirtItemFlag}";
var orderFlag = "${orderCoForm.orderFlag}";
/************************************************
 * 読み込み時イベント設定
 ************************************************/
 // 自作jsに記載
jQuery(function() {

	if("orderCo"==orderFlag){
		if(shirtAdFlag=="1"){
		}else{
			shirtAdFlag="0";
		}
	}

	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });

    shirtInitAlter();
    shirtProductPrice();
	initOptionShirt();
	if (shirtItemFlag == "1" || orderFlag == "orderLink" 
		|| orderFlag == "orderDetail" || orderFlag == "orderBack" 
		|| orderFlag == "orderCheck" || orderFlag == "orderDivert") {
		optionShirtSession();
	} else {
		//カジュアルヘムライン仕様サイズの初期化設定
		jQuery("#stCasualHemlineSize").val("0");
		jQuery("#os_casHemLineSize100").val("0");
		jQuery("#os_casHemLineSize10").val("0");
		jQuery("#os_casHemLineSize1").val("0");
		jQuery("#os_casHemLineSizeM1").val("0");
	}
	
	setShirtModelDisable();
	
	jQuery("#shirtModel").change(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});
		var shirtModel = jQuery(this).val();
		var productFabricNo = jQuery("#productFabricNo").val();
		var itemCode = jQuery("#item").val();
		var subItemCode = jQuery("#item").val();
		var code = itemCode + subItemCode + shirtModel;
		$.ajax({
			type:"get",
			url:contextPath + "/orderCo/getOrderPriceForShirtModel",
			data:{"code":code},
			dataType:"json",
			contentType:"application/json",
			async:false,
			success:function(result){
				var allPriceMap = result.priceMap;
	         	for (var priceMapKey in allPriceMap) {
	            	if(jQuery("#"+priceMapKey+"_Msg").length>0){
	            	jQuery("#"+priceMapKey+"_Msg").html(allPriceMap[priceMapKey]);
	            	}else{
	              	var msgIdValueName = priceMapKey.replace(/_id/,"_Msg");
	              	jQuery("#"+msgIdValueName).html(allPriceMap[priceMapKey]);
	            	}
	         	}
				jQuery("#optionPriceId").val(result.optionPrice);
				jQuery("#optionPrice").html(formatMoney(result.optionPrice,0,""));
				getAllPrice(itemCode, result.optionPrice);
				allOptionPrice();
			}
		});
		// 別モデルに変更された場合はアラート表示
		if (tmpShirtModel != '' && shirtModel != tmpShirtModel) {
		    setAlert('shirtModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		}
		// 一時保存のモデルを更新
		tmpShirtModel = shirtModel;
		
		//生地チェクフラッグ
		var fabricCheckValue = jQuery("#fabricFlag").val();
		//fabricCheckValue[0]:0 or 1 or 2 
		//fabricCheckValue[1]:エラーメッセージ 
		fabricCheckValue = fabricCheckValue.split("*");
			
		//生地チェク成功の場合
		if((fabricCheckValue[0]=="0"||fabricCheckValue[0]=="2")&&isNotEmpty(productFabricNo)){
			//モデルチェク
			var checkResult = modelCheck(shirtModel,productFabricNo,orderPattern,itemCode,subItemCode);
			if(checkResult == "true"){
				//0はモデルチェク成功の場合
				jQuery("#shModelFlag").val("0");
				jQuery("#shirtModelCheck").empty();
				jQuery("#shirtModelCheck").hide();
				jQuery("#fabricMsg").empty();
			}else if(checkResult == "false"){
				//2はモデルチェク失敗の場合
				jQuery("#shirtModelCheck").show();
				jQuery("#shModelFlag").val("1"+"*"+getMsgByOneArg('msg065','SHIRT'));
				setAlert('shirtModelCheck',getMsgByOneArg('msg065','SHIRT'));
			}
		}	
		shirtProductPrice();
		jQuery("#shirtFlag").val("1");
	})

	//カジュアルヘムラインサイズ
	setCasHemLineSize();
	
	jQuery("#shirtItemFlag").val("1");

	//ラジオボタンの変更処理
	jQuery('input[id^="os_clericSpec_id"],[id^="os_dblCuff_id"],[id^="os_AddCuff_id"],[id^="os_tabBtn_id"],[id^="os_galetteBtnPos_nomal_id"],[id^="os_pinHolePin_id"],[id^="os_breastPk_yes_id"],[id^="os_breastPkSize_normal_id"],[id^="os_pinTack_no_id"],[id^="os_stitch_nomal_id"],[id^="os_colorKeeper_id"],[id^="os_casHemLine_id"],[id^="os_btnPosChg_id"]')
	.change(function(){
		//jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		
		var shirtModel = jQuery("#shirtModel option:selected").val();
		var itemCode = jQuery("#item").val();
		var subItemCode = jQuery("#item").val();
		var idValueName = jQuery(this).attr("id");
		var thisVal = jQuery("#"+idValueName).val();

    	var breastPkVal = jQuery('input[id^="os_breastPk_yes_id"]:checked').val();
    	if(idValueName == 'os_breastPk_yes_id1' || idValueName == 'os_breastPk_yes_id2' || idValueName == 'os_breastPk_yes_id3'){
    		jQuery('input[id^="os_breastPkSize_normal_id"]:checked').change();
 	    }

		//IDの後の番号を削除します
		var findIdPosition = idValueName.indexOf("_id");
		var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
		if(isNotEmpty(shirtModel)){
			var code = itemCode + subItemCode + shirtModel;
			jQuery.ajax({
				type:"get",
				url:contextPath + "/orderCo/getOrderPriceForShirtProject",
				data:{"code":code,"idValueName":interceptedIdValueName,"thisVal":thisVal,"valueBreastPk":breastPkVal},
				dataType:"json",
				contentType:"application/json",
				async:false,
				success:function(result){
					var msgIdValueName = interceptedIdValueName.replace(/_id/g,"_Msg");
					jQuery("#"+msgIdValueName).html(result.idValuePrice);
					getAllPrice(subItemCode, result.optionPrice);
					allOptionPrice();
				}
			});
		}
		if (idValueName == 'os_casHemLine_id1' || idValueName == 'os_casHemLine_id2'){
			setAlert('osCasHemLineCheck', getMsg('msg147'));
		}
	});

	//プルダウンの変更処理
	jQuery('#os_chainModel,#os_cuffs,#os_convertible,#os_adjustBtn,#os_btnMate,#os_frontDesign,#os_bhColor,#os_byColor')
	.change(function(){
		//jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		
		var shirtModel = jQuery("#shirtModel option:selected").val();
		var itemCode = jQuery("#item").val();
		var subItemCode = jQuery("#item").val();
		var idValueName = jQuery(this).attr("id");
		var thisVal = jQuery("#" + idValueName).val();

		if(isNotEmpty(shirtModel)){
			var code = itemCode + subItemCode + shirtModel;
			jQuery.ajax({
				type:"get",
				url:contextPath + "/orderCo/getOrderPriceForShirtProject",
				data:{"code":code,"idValueName":idValueName,"thisVal":thisVal},
				dataType:"json",
				contentType:"application/json",
				async:false,
				success:function(result){
		            jQuery("#"+idValueName+"_Msg").html(result.idValuePrice);
		            getAllPrice(subItemCode, result.optionPrice);
		            allOptionPrice();
				}
			});
		}
	});
	showPrice();
});

function setShirtModelDisable(){
	var shirtModel = null;
	shirtModel = document.getElementById("shirtModel");
	var allShirtOption = shirtModel.options;
	allShirtOption[0].disabled = true;
}

function setCasHemLineSize() {
	//カジュアルヘムラインサイズ
	jQuery("#os_casHemLineSize100,#os_casHemLineSize10,#os_casHemLineSize1,#os_casHemLineSizeM1").change(function(){
		var os_casHemLineSize100 = jQuery("#os_casHemLineSize100").val();
		var os_casHemLineSize10 = jQuery("#os_casHemLineSize10").val();
		var os_casHemLineSize1 = jQuery("#os_casHemLineSize1").val();
		var os_casHemLineSizeM1 = jQuery("#os_casHemLineSizeM1").val();
		var stCasualHemlineSize = os_casHemLineSize100+os_casHemLineSize10+os_casHemLineSize1+"."+os_casHemLineSizeM1;
		jQuery("#stCasualHemlineSize").val(stCasualHemlineSize);
	})
}

function optionShirtSession() {
	
	//カジュアルヘムライン仕様
	var osCasHemLine = "${orderCoForm.coOptionShirtStandardInfo.osCasHemLine}" ;
	if (osCasHemLine == "0002002") {
		// カジュアルヘムライン仕様が有りの場合
		jQuery('.casHemLineSizeArea').show();
	} else {
		jQuery('.casHemLineSizeArea').hide();
	}

	//襟型
	var os_chainModel = "${orderCoForm.coOptionShirtStandardInfo.osChainModel}";
	//ピンホールピン
	if (os_chainModel == "0000113" || os_chainModel == "0000114") {
		// 襟型「ピンホール・ラウンドピンホール」選択時のみ「ピンホールピン」選択可
		jQuery(':radio[name="coOptionShirtStandardInfo.osPinHolePin"]').prop('disabled', false);
		
	} else {
		jQuery(':radio[name="coOptionShirtStandardInfo.osPinHolePin"]').prop('disabled', true);
		jQuery('#os_pinHolePin_id1').prop('checked', true);
		jQuery('#os_pinHolePin_id1').prop('disabled', false);
	}
	jQuery('input[name="coOptionShirtStandardInfo.osPinHolePin"]:checked').change();
	
	//カラーキーパー
	var os_colorKeeper_disabled = jQuery('#os_colorKeeper_id2').prop('disabled');
	if (os_chainModel == "0000108" || os_chainModel == "0000109" ||
			os_chainModel == "0000113" || os_chainModel == "0000114" ||
			os_chainModel == "0000115") {
		// 「襟型」ボタンダウン・ショートボタンダウン・ピンホール・ラウンドピンホール・ウイング選択時、
		// 「カラーキーパー」は「無し」にて選択不可
		jQuery('#os_colorKeeper_id2').prop('checked', true);
		jQuery('#os_colorKeeper_id1').prop('disabled', true);
		jQuery('#os_colorKeeper_id2').prop('disabled', false);
		//jQuery(':radio[name="coOptionShirtStandardInfo.osColorKeeper"]').prop('disabled', true);
	} else {
		jQuery(':radio[name="coOptionShirtStandardInfo.osColorKeeper"]').prop('disabled', false);
		if (os_colorKeeper_disabled) {
			// 元々無効化されていた場合、デフォルトの「有り」を選択状態にする
			jQuery('#os_colorKeeper_id1').prop('checked', true);
		}
	}
	jQuery('input[name="coOptionShirtStandardInfo.osColorKeeper"]:checked').change();
	
	var osTabBtn = "${orderCoForm.coOptionShirtStandardInfo.osTabBtn}" ;
	jQuery("input[name='coOptionShirtStandardInfo.osTabBtn'][value='" + osTabBtn + "']").prop("checked", true);
	//タブ釦
	if (os_chainModel == "0000111" || os_chainModel == "0000112") {
		// 通常、スナップ
		jQuery('#os_tabBtn_id1').prop('disabled', false);
		jQuery('#os_tabBtn_id2').prop('disabled', false);
		jQuery('#os_tabBtn_id3').prop('disabled', true);
	} else {
		// なし
		jQuery('#os_tabBtn_id1').prop('disabled', true);
		jQuery('#os_tabBtn_id2').prop('disabled', true);
		jQuery('#os_tabBtn_id3').prop('disabled', false);
	}
	jQuery('input[name="coOptionShirtStandardInfo.osTabBtn"]:checked').change();

	// カフス
	var os_cuffs = "${orderCoForm.coOptionShirtStandardInfo.osCuffs}" ;
	if (os_cuffs == "0000204" || os_cuffs == "0000205") {
		// ダブルカフスの場合、コンバーチブルの選択不可
		jQuery('#os_convertible').prop('disabled', true);
		jQuery('#os_convertible').val("0000301");
	} else {
		jQuery('#os_convertible').prop('disabled', false);
	}
	//jQuery('#os_convertible').change();

	// コンバーチブル	
	var os_convertible = "${orderCoForm.coOptionShirtStandardInfo.osConvertible}" ;
	if (os_convertible == '0000302') {
		// 「コンバーチブル」選択「有り」のときのみ「アジャスト釦」は選択可
		jQuery('#os_adjustBtn').prop('disabled', false);
	} else {
		jQuery('#os_adjustBtn').prop('disabled', true);
	} 
		
	// カフスボタン追加の変更
	changeAddCuffSession();

	// 胸ポケット
	var osBreastPk = "${orderCoForm.coOptionShirtStandardInfo.osBreastPk}" ;
	if (osBreastPk == "0001202") {
		jQuery('#os_breastPkSizeArea').hide();
	}
		
	// ボタン位置変更
	var osBtnPosChg = "${orderCoForm.coOptionShirtStandardInfo.osBtnPosChg}" ;
	if (osBtnPosChg == "0002102") {
		// ボタン位置変更の場合
		jQuery('#os_btnPosChg_area').show();
	} else {
		jQuery('#os_btnPosChg_area').hide();
	}
	
	//カジュアルヘムライン仕様
	var stCasualHemlineSize = "${orderCoForm.coOptionShirtStandardInfo.stCasualHemlineSize}" ;
	jQuery("#stCasualHemlineSize").val(stCasualHemlineSize);
	stCasualHemlineSize = stCasualHemlineSize.split(".");
	if(isNotEmpty(stCasualHemlineSize[1])){
		jQuery("#os_casHemLineSizeM1").val(stCasualHemlineSize[1])
	}
	
	var str = stCasualHemlineSize[0];
	if(str.length == 3){
		str = str.split("");
		var str1 = str[2];
		var str10 = str[1];
		var str100 = str[0];
		jQuery("#os_casHemLineSize100").val(str100);
		jQuery("#os_casHemLineSize10").val(str10);
		jQuery("#os_casHemLineSize1").val(str1);
	}else if(str.length == 2){
		str = str.split("");
		var str1 = str[1];
		var str10 = str[0];
		jQuery("#os_casHemLineSize100").val("0");
		jQuery("#os_casHemLineSize10").val(str10);
		jQuery("#os_casHemLineSize1").val(str1);
	}else if(str.length == 1){
		str = str.split("");
		var str1 = str[0];
		jQuery("#os_casHemLineSize100").val("0");
		jQuery("#os_casHemLineSize10").val("0");
		jQuery("#os_casHemLineSize1").val(str1);
	}

	jQuery("#os_btnPosChg_collar").val("${orderCoForm.coOptionShirtStandardInfo.stNeckbandBtnPosChg}");
	jQuery("#os_btnPosChg_collar_out").val("${orderCoForm.coOptionShirtStandardInfo.stNeckbandBtnPosChg}");
	setFont("os_btnPosChg_collar");
	
	jQuery("#os_btnPosChg_front1").val("${orderCoForm.coOptionShirtStandardInfo.stFrtfirstBtnPosChg}");
	jQuery("#os_btnPosChg_front1_out").val("${orderCoForm.coOptionShirtStandardInfo.stFrtfirstBtnPosChg}");
	setFont("os_btnPosChg_front1");
	
	jQuery("#os_btnPosChg_front2").val("${orderCoForm.coOptionShirtStandardInfo.stFrtsecondBtnPosChg}");
	jQuery("#os_btnPosChg_front2_out").val("${orderCoForm.coOptionShirtStandardInfo.stFrtsecondBtnPosChg}");
	setFont("os_btnPosChg_front2");	
	
}

//カフスボタン追加の入力制御
function changeAddCuffSession() {
	
	//カフスはダブルカフス仕様（折り返しスクエア）、ダブルカフス仕様（ミラノカフス）の場合は、選択不可
	var os_cuffs = "${orderCoForm.coOptionShirtStandardInfo.osCuffs}" ;
	if (os_cuffs == "0000204" || os_cuffs == "0000205") {
		// カフスボタン追加は使用不可
		jQuery('#os_AddCuff_id1').prop('checked', true);
		jQuery('#os_AddCuff_id2').prop('disabled', true);

		jQuery('#os_convertible').prop('disabled', true);
		jQuery('#os_adjustBtn').prop('disabled', true);
	}

	//コンバーチブル「有」選択時不可
	var os_cuffs = "${orderCoForm.coOptionShirtStandardInfo.osConvertible}" ;
	if (os_convertible == '0000302') {
		// カフスボタン追加は使用不可
		jQuery('#os_AddCuff_id1').prop('checked', true);
		jQuery('#os_AddCuff_id2').prop('disabled', true);
	}

	jQuery('input[name="coOptionShirtStandardInfo.osAddCuff"]:checked').change();
}


function modelCheck(modelCode,productFabricNo,orderPattern,itemCode,subItemCode){
	var checkResult = jQuery.ajax({url:contextPath + "/orderCo/checkModel",data:{"modelCode":modelCode,"productFabricNo":productFabricNo,"orderPattern":orderPattern,"itemCode":itemCode,"subItemCode":subItemCode},async:false});
	checkResult = checkResult.responseText;
	return checkResult;
}

function getAllPrice(subItemCode, optionPrice){
	jQuery("#stOptionPriceId").val(optionPrice);
    var stOptionPriceId = optionPrice;
    var allPrice = 0;
    allPrice = Number(stOptionPriceId);
    jQuery("#optionPriceId").val(allPrice);
    jQuery("#optionPrice").html(formatMoney(allPrice,0,""));
}
jQuery("#os_casHemLine_id1").click(function(){
	var sessionoSCasHemLine="${orderCoForm.coOptionShirtStandardInfo.osCasHemLine}";
	//var sCasHemLine2 = jQuery("#os_casHemLine_id2").val();
	if(sessionoSCasHemLine=="0002002"){
		jQuery("#osCasHemLineIdFlag").val("1");
	}
	/* var shirtNumber="${orderCoForm.coAdjustShirtStandardInfo.corStSize}";
	var subItemCode = jQuery("#item").val();
	var shirtModel = jQuery("#shirtModel option:selected").val();
	shirtFigure = "";
	if(isNotEmpty(shirtNumber)){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":shirtModel,"figure":shirtFigure,"number":shirtNumber},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "01"){
	            		jQuery("#corStBodylengthGross").val(data[i].typeSize);
	            		//jQuery("#corStBodylengthSize").val(data[i].typeSize);
	            		alert(jQuery("#corStBodylengthGross").val());
					}
		        }
		    }
		})
	}else{
		jQuery("#corStBodylengthGross").val("");
		//jQuery("#corStBodylengthSize").val("");
		} */
	
})
jQuery("#shirtModel").change(function(){
	if("orderCo"==orderFlag){
		shirtAdFlag="0";	
	}else if("1"==jQuery("#shirtItemFlag").val()){
		if("orderCo"!=orderFlag ){
			shirtAdFlag="0";
		}
	}
})

function showPrice(){
	var shirtModel = jQuery("#shirtModel option:selected").val();
	if(!(shirtModel == "")){
		jQuery("#shirtModel").change();
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
</script>
