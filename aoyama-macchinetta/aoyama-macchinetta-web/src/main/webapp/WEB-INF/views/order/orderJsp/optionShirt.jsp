 <form:form id="idInfoForm" action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm" method="post" modelAttribute="orderForm" class="form-horizontal">
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
                                <form:select id="shirtModel" path="optionShirtStandardInfo.osShirtModel" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionShirtStandardInfo.osShirtModelMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">襟型</label></div>
                            <div class="col col-md-3">
                            	<form:select id="os_chainModel" path="optionShirtStandardInfo.osChainModel" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionShirtStandardInfo.osChainModelMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">カフス</label></div>
                            <div class="col col-md-3">
                            	<form:select id="os_cuffs" path="optionShirtStandardInfo.osCuffs" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionShirtStandardInfo.osCuffsMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コンバーチブル</label></div>
                            <div class="col col-md-3">
                            	<form:select id="os_convertible" path="optionShirtStandardInfo.osConvertible" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionShirtStandardInfo.osConvertibleMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスト釦</label></div>
                            <div class="col col-md-3">
                            	<form:select id="os_adjustBtn" path="optionShirtStandardInfo.osAdjustBtn" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionShirtStandardInfo.osAdjustBtnMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">クレリック仕様</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_clericSpec_id" path="optionShirtStandardInfo.osClericSpec" class="form-check-input" items="${orderForm.optionShirtStandardInfo.osClericSpecMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ダブルカフス仕様</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_dblCuff_id" path="optionShirtStandardInfo.osDblCuff" class="form-check-input" items="${orderForm.optionShirtStandardInfo.osDblCuffMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">カフスボタン追加</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_AddCuff_id" path="optionShirtStandardInfo.osAddCuff" class="form-check-input" items="${orderForm.optionShirtStandardInfo.osAddCuffMap}"/>
                                </div>
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
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
                            <div class="col col-md-4">
                            	<form:select id="os_btnMate" path="optionShirtStandardInfo.osBtnMate" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionShirtStandardInfo.osBtnMateMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タブ釦</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_tabBtn_id" path="optionShirtStandardInfo.osTabBtn" class="form-check-input" items="${orderForm.optionShirtStandardInfo.osTabBtnMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ガントレットボタン位置</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_galetteBtnPos_nomal" path="optionShirtStandardInfo.osGaletteBtnPos" class="form-check-input" items="${orderForm.optionShirtStandardInfo.osGaletteBtnPosMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンホールピン</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_pinHolePin_id" path="optionShirtStandardInfo.osPinHolePin" class="form-check-input" items="${orderForm.optionShirtStandardInfo.osPinHolePinMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_breastPk_yes" path="optionShirtStandardInfo.osBreastPk" class="form-check-input" items="${orderForm.optionShirtStandardInfo.osBreastPkMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group" id="os_breastPkSizeArea">
                            <div class="col col-md-3"><label class=" form-control-label">胸ポケット大きさ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_breastPkSize_normal" path="optionShirtStandardInfo.osBreastPkSize" class="form-check-input" items="${orderForm.optionShirtStandardInfo.osBreastPkSizeMap}"/>
                             	</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロントデザイン</label></div>
                            <div class="col col-md-4">
                            	<form:select id="os_frontDesign" path="optionShirtStandardInfo.osFrontDesign" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionShirtStandardInfo.osFrontDesignMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンタックブザム</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_pinTack_no" path="optionShirtStandardInfo.osPinTack" class="form-check-input" items="${orderForm.optionShirtStandardInfo.osPinTackMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_stitch_nomal" path="optionShirtStandardInfo.osStitch" class="form-check-input" items="${orderForm.optionShirtStandardInfo.osStitchMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">カラーキーパー</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_colorKeeper_id" path="optionShirtStandardInfo.osColorKeeper" class="form-check-input" items="${orderForm.optionShirtStandardInfo.osColorKeeperMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタンホール色変更</label></div>
                            <div class="col col-md-3">
                            	<form:select id="os_bhColor" path="optionShirtStandardInfo.osBhColor" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionShirtStandardInfo.osBhColorMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸色変更</label></div>
                            <div class="col col-md-3">
                            	<form:select id="os_byColor" path="optionShirtStandardInfo.osByColor" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionShirtStandardInfo.osByColorMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">カジュアルヘムライン仕様</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_casHemLine_id" path="optionShirtStandardInfo.osCasHemLine" class="form-check-input" items="${orderForm.optionShirtStandardInfo.osCasHemLineMap}"/>
                                </div>
                            </div>
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
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="os_btnPosChg_id" path="optionShirtStandardInfo.osBtnPosChg" class="form-check-input" items="${orderForm.optionShirtStandardInfo.osBtnPosChgMap}"/>
                                </div>
                            </div>
                            
                            <div id="os_btnPosChg_area" style="display:none;">
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">台襟釦</label>
                            </div>
                            <div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="os_btnPosChg_collar_m"><i class="fa fa-caret-square-o-down" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="os_btnPosChg_collar" name="optionShirtStandardInfo.osBtnPosChgCollar" value="0" min="-1" max="1" step="0.5">&nbsp;
                                <a href="#" id="os_btnPosChg_collar_p"><i class="fa fa-caret-square-o-up" style="font-size:32px"></i></a>
                                　                                                                           <output id="os_btnPosChg_collar_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">フロント第1釦</label>
                            </div>
                            <div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="os_btnPosChg_front1_m"><i class="fa fa-caret-square-o-down" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="os_btnPosChg_front1" name="optionShirtStandardInfo.osBtnPosChgFront1" value="0" min="-3" max="3" step="0.5">&nbsp;
                                <a href="#" id="os_btnPosChg_front1_p"><i class="fa fa-caret-square-o-up" style="font-size:32px"></i></a>
                                　                                                                           <output id="os_btnPosChg_front1_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">フロント第2釦</label>
                            </div>
                            <div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="os_btnPosChg_front2_m"><i class="fa fa-caret-square-o-down" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="os_btnPosChg_front2" name="optionShirtStandardInfo.osBtnPosChgFront2" value="0" min="-3" max="3" step="0.5">&nbsp;
                                <a href="#" id="os_btnPosChg_front2_p"><i class="fa fa-caret-square-o-up" style="font-size:32px"></i></a>
                                　                                                                           <output id="os_btnPosChg_front2_out">0</output>cm
                                </div>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            
            <input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="${orderForm.jacketItemFlag }"/>
			<input type="hidden" id="pantsItemFlag" name="pantsItemFlag" value="${orderForm.pantsItemFlag }"/>
			<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="${orderForm.giletItemFlag }"/>
			<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="0"/>
			<input type="hidden" id="shirtFlag" name="shirtFlag" value="0"/>
			<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="${orderForm.coatItemFlag }"/>
			<input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="${orderForm.pants2ItemFlag }"/>
            <input type="hidden" id="stCasualHemlineSize" name="optionShirtStandardInfo.stCasualHemlineSize"  value="" />
</form:form>
<script	src="${pageContext.request.contextPath}/resources/app/js/jquery.min.js"></script>
<script	src="${pageContext.request.contextPath}/resources/app/js/popper.min.js"></script>
<script	src="${pageContext.request.contextPath}/resources/app/js/jquery.validate.min.js"></script>
<script	src="${pageContext.request.contextPath}/resources/app/js/bootstrap.min.js"></script>
<script	src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
<script	src="${pageContext.request.contextPath}/resources/app/js/chosen.jquery.js"></script>
<script	src="${pageContext.request.contextPath}/resources/app/js/bootstrap-datepicker.js"></script>

<!-- 自作js -->
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.shirt.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>


<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";
var shirtItemFlag="${orderForm.shirtItemFlag}";
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

	initAlter();

	initOptionShirt();
	
	if (shirtItemFlag == "1") {
		optionShirtSession();
	}
	
	setShirtModelDisable();
	
	jQuery("#shirtModel").change(function(){
		jQuery("#shirtFlag").val("1");
	})
	
	//カジュアルヘムラインサイズ
	setCasHemLineSize();
	
	jQuery("#shirtItemFlag").val("1");
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
	var osCasHemLine = "${orderForm.optionShirtStandardInfo.osCasHemLine}" ;
	if (osCasHemLine == "0002002") {
		// カジュアルヘムライン仕様が有りの場合
		jQuery('.casHemLineSizeArea').show();
	} else {
		jQuery('.casHemLineSizeArea').hide();
	}

	//襟型
	var os_chainModel = "${orderForm.optionShirtStandardInfo.osChainModel}";
	//ピンホールピン
	if (os_chainModel == "0000113" || os_chainModel == "0000114") {
		// 襟型「ピンホール・ラウンドピンホール」選択時のみ「ピンホールピン」選択可
		jQuery(':radio[name="optionShirtStandardInfo.osPinHolePin"]').prop('disabled', false);
		
	} else {
		jQuery(':radio[name="optionShirtStandardInfo.osPinHolePin"]').prop('disabled', true);
		jQuery('#os_pinHolePin_id1').prop('checked', true);
	}

	//カラーキーパー
	var os_colorKeeper_disabled = jQuery('#os_colorKeeper_id2').prop('disabled');
	if (os_chainModel == "0000108" || os_chainModel == "0000109" ||
			os_chainModel == "0000113" || os_chainModel == "0000114" ||
			os_chainModel == "0000115") {
		// 「襟型」ボタンダウン・ショートボタンダウン・ピンホール・ラウンドピンホール・ウイング選択時、
		// 「カラーキーパー」は「無し」にて選択不可
		jQuery('#os_colorKeeper_id2').prop('checked', true);
		jQuery(':radio[name="optionShirtStandardInfo.osColorKeeper"]').prop('disabled', true);
	} else {
		jQuery(':radio[name="optionShirtStandardInfo.osColorKeeper"]').prop('disabled', false);
		if (os_colorKeeper_disabled) {
			// 元々無効化されていた場合、デフォルトの「有り」を選択状態にする
			jQuery('#os_colorKeeper_id2').prop('checked', true);
		}
	}

	var osTabBtn = "${orderForm.optionShirtStandardInfo.osTabBtn}" ;
	jQuery("input[name='optionShirtStandardInfo.osTabBtn'][value='" + osTabBtn + "']").prop("checked", true);
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

	// カフス
	var os_cuffs = "${orderForm.optionShirtStandardInfo.osCuffs}" ;
	if (os_cuffs == "0000204" || os_cuffs == "0000205") {
		// ダブルカフスの場合、コンバーチブルの選択不可
		jQuery('#os_convertible').prop('disabled', true);
		jQuery('#os_convertible').val("0000301");
	} else {
		jQuery('#os_convertible').prop('disabled', false);
	}
	//jQuery('#os_convertible').change();

	// コンバーチブル	
	var os_convertible = "${orderForm.optionShirtStandardInfo.osConvertible}" ;
	if (os_convertible == '0000302') {
		// 「コンバーチブル」選択「有り」のときのみ「アジャスト釦」は選択可
		jQuery('#os_adjustBtn').prop('disabled', false);
		//jQuery('#os_adjustBtn').val("0000402");
	} else if ((os_cuffs == "0000204" || os_cuffs == "0000205") && os_convertible == '0000301') {
		jQuery('#os_adjustBtn').prop('disabled', true);
		//jQuery('#os_adjustBtn').val("0000401");
	} else if (os_cuffs != "0000200" && os_convertible == '0000301') {
		jQuery('#os_adjustBtn').prop('disabled', true);
		//jQuery('#os_adjustBtn').val("0000401");
	} 
		
	// カフスボタン追加の変更
	changeAddCuffSession();

	// 胸ポケット
	var osBreastPk = "${orderForm.optionShirtStandardInfo.osBreastPk}" ;
	if (osBreastPk == "0001202") {
		jQuery('#os_breastPkSizeArea').hide();
	}
		
	// ボタン位置変更
	var osBtnPosChg = "${orderForm.optionShirtStandardInfo.osBtnPosChg}" ;
	if (osBtnPosChg == "0002102") {
		// ボタン位置変更の場合
		jQuery('#os_btnPosChg_area').show();
	} else {
		jQuery('#os_btnPosChg_area').hide();
	}
	
	//台襟釦、フロント第1釦、フロント第2釦
	var stCasualHemlineSize = "${orderForm.optionShirtStandardInfo.stCasualHemlineSize}" ;
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

	jQuery("#os_btnPosChg_collar").val("${orderForm.optionShirtStandardInfo.osBtnPosChgCollar}");
	jQuery("#os_btnPosChg_collar_out").val("${orderForm.optionShirtStandardInfo.osBtnPosChgCollar}");
	setFont("os_btnPosChg_collar");
	
	jQuery("#os_btnPosChg_front1").val("${orderForm.optionShirtStandardInfo.osBtnPosChgFront1}");
	jQuery("#os_btnPosChg_front1_out").val("${orderForm.optionShirtStandardInfo.osBtnPosChgFront1}");
	setFont("os_btnPosChg_front1");
	
	jQuery("#os_btnPosChg_front2").val("${orderForm.optionShirtStandardInfo.osBtnPosChgFront2}");
	jQuery("#os_btnPosChg_front2_out").val("${orderForm.optionShirtStandardInfo.osBtnPosChgFront2}");
	setFont("os_btnPosChg_front2");	
	
}

//カフスボタン追加の入力制御
function changeAddCuffSession() {
	
	//カフスはダブルカフス仕様（折り返しスクエア）、ダブルカフス仕様（ミラノカフス）の場合は、選択不可
	var os_cuffs = "${orderForm.optionShirtStandardInfo.osCuffs}" ;
	if (os_cuffs == "0000204" || os_cuffs == "0000205") {
		// カフスボタン追加は使用不可
		jQuery('#os_AddCuff_id1').prop('checked', true);
		jQuery('#os_AddCuff_id2').prop('disabled', true);
	}

	//コンバーチブル「有」選択時不可
	var os_cuffs = "${orderForm.optionShirtStandardInfo.osConvertible}" ;
	if (os_convertible == '0000302') {
		// カフスボタン追加は使用不可
		jQuery('#os_AddCuff_id1').prop('checked', true);
		jQuery('#os_AddCuff_id2').prop('disabled', true);
	}
}
</script>
