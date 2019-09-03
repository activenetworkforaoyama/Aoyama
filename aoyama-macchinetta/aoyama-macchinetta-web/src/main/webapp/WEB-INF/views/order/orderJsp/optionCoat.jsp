<form:form id="idInfoForm" action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm" method="post" modelAttribute="orderForm" class="form-horizontal">
            <div id="op_coat_div">
            <div class="card-header">
                <strong class="card-title">COAT</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">COATモデル</label></div>
                            <div class="col col-md-3">
                                <form:select id="coatModel" path="optionCoatStandardInfo.coatModel" class="form-control-sm form-control">
                                    <form:options items="${orderForm.optionCoatStandardInfo.coatModelMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="coatModelMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label></div>
                            <div class="col-12 col-md-3">
                            	<form:select id="oc_lapelDesign" path="optionCoatStandardInfo.ocLapelDesign" class="form-control-sm form-control">
                                    <form:options items="${orderForm.optionCoatStandardInfo.ocLapelDesignMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right">
                            	<output id="oc_lapelDesign_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <div class="form-check-inline form-check">
                                    	<form:radiobuttons id="oc_sleeveSpec_id" path="optionCoatStandardInfo.ocSleeveSpec" class="form-check-input" items="${orderForm.optionCoatStandardInfo.ocSleeveSpecMap}"/>
                                	</div>
                                </div>
                            </div>
                        </div>                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
                            <div class="col-12 col-md-3">
                            	<form:select id="oc_waistPkt" path="optionCoatStandardInfo.ocWaistPkt" class="form-control-sm form-control">
                                    <form:options items="${orderForm.optionCoatStandardInfo.ocWaistPktMap}"/>
                                </form:select>
                            </div>
                            <!-- <div class="col-12 col-md-9 offset-md-3" id="oc_waistPktMsg">
                            </div> -->
                            <div class="col-12 col-md-6" align="right">
                            	<output id="oc_waistPkt_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="oc_changePkt_id" path="optionCoatStandardInfo.ocChangePkt" class="form-check-input" items="${orderForm.optionCoatStandardInfo.ocChangePktMap}"/>
                                </div>
                            </div>
                            <!-- <div class="col-12 col-md-9 offset-md-3" id="oc_changePkt">
                            </div> -->
                            <div class="col-12 col-md-3" align="right">
                            	<output id="oc_changePkt_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="oc_slantedPkt_id" path="optionCoatStandardInfo.ocSlantedPkt" class="form-check-input" items="${orderForm.optionCoatStandardInfo.ocSlantedPktMap}"/>
                                </div>
                            </div>
                            <!-- <div class="col-12 col-md-9 offset-md-3" id="oc_slantedPktMsg">
                            </div> -->
                            <div class="col-12 col-md-3" align="right">
                            	<output id="oc_slantedPkt_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="oc_ventSpec_id" path="optionCoatStandardInfo.ocVentSpec" class="form-check-input" items="${orderForm.optionCoatStandardInfo.ocVentSpecMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="oc_ventSpec_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント釦数</label></div>
                            <div class="col-12 col-md-3">
                            	<form:select id="oc_frontBtnCnt" path="optionCoatStandardInfo.ocFrontBtnCnt" class="form-control-sm form-control">
                                    <form:options items="${orderForm.optionCoatStandardInfo.ocFrontBtnCntMap}" class="Front-Btn-Cnt"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right">
                            	<output id="oc_frontBtnCnt_Msg"></output>
                            </div>
                            <!-- <div class="col-12 col-md-9 offset-md-3" id="oc_frontBtnCntMsg">
                            </div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
                            <div class="col-12 col-md-3">
                            	<form:select id="oc_cuffSpec" path="optionCoatStandardInfo.ocCuffSpec" class="form-control-sm form-control">
                                    <form:options items="${orderForm.optionCoatStandardInfo.ocCuffSpecMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right">
                            	<output id="oc_cuffSpec_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group" id="oc_sleeveBtnType_div">
                            <div class="col col-md-3"><label class=" form-control-label">袖釦</label></div>
                            <div class="col-12 col-md-3">
                            	<form:select id="oc_sleeveBtnType" path="optionCoatStandardInfo.ocSleeveBtnType" class="form-control-sm form-control">
                                    <form:options items="${orderForm.optionCoatStandardInfo.ocSleeveBtnTypeMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right">
                            	<output id="oc_sleeveBtnType_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
                            <div class="col col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="oc_backBelt_id" path="optionCoatStandardInfo.ocBackBelt" class="form-check-input" items="${orderForm.optionCoatStandardInfo.ocBackBeltMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="oc_backBelt_Msg"></output>
                            </div>
                            <!-- <div class="col-12 col-md-9 offset-md-3" id="oc_backBeltMsg">
                            </div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                	<form:radiobuttons id="oc_chainHange_id" path="optionCoatStandardInfo.ocChainHange" class="form-check-input" items="${orderForm.optionCoatStandardInfo.ocChainHangeMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="oc_chainHange_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
                            <div class="col col-md-3">
                            	<form:select id="oc_bodyBackMate" path="optionCoatStandardInfo.ocBodyBackMate" class="form-control-sm form-control">
                                    <form:options items="${orderForm.optionCoatStandardInfo.ocBodyBackMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionCoatStandardInfo.ocBodyBackMateStkNo" id="oc_bodyBackMateStkNo" class="form-control-sm form-control">

                                </select>
                            </div>
                            <div class="col-12 col-md-2" align="right">
                            	<output id="oc_bodyBackMate_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
                            <div class="col col-md-3">
                            	<form:select id="oc_cuffBackMate" path="optionCoatStandardInfo.ocCuffBackMate" class="form-control-sm form-control">
                                    <form:options items="${orderForm.optionCoatStandardInfo.ocCuffBackMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionCoatStandardInfo.ocCuffBackMateStkNo" id="oc_cuffBackMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col-12 col-md-2" align="right">
                            	<output id="oc_cuffBackMate_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
                            <div class="col col-md-3">
                            	<form:select id="oc_frontBtnMate" path="optionCoatStandardInfo.ocFrontBtnMate" class="form-control-sm form-control">
                                    <form:options items="${orderForm.optionCoatStandardInfo.ocFrontBtnMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionCoatStandardInfo.ocFrontBtnMateStkNo" id="oc_frontBtnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col-12 col-md-2" align="right">
                            	<output id="oc_frontBtnMate_Msg"></output>
                            </div>
                        </div>
                    </div>
                </div>
            </div></div>
            <input type="hidden" id="coatItemFlag" name="coatItemFlag" value="0"/>
            <input type="hidden" id="coatFlag"  name="coatFlag" value="0" />
            <input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="${orderForm.jacketItemFlag }"/>
			<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="${orderForm.giletItemFlag }"/>
			<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="${orderForm.shirtItemFlag }"/>
			<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="${orderForm.coatItemFlag }"/>
			<input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="${orderForm.pants2ItemFlag }"/>
</form:form>
<script
	src="${pageContext.request.contextPath}/resources/app/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/app/js/popper.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/app/js/jquery.validate.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/app/js/main.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/app/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/app/js/chosen.jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/app/js/bootstrap-datepicker.js"></script>


<!-- 自作js -->
<script
	src="${pageContext.request.contextPath}/resources/app/self/js/option.coat.js"></script>

<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";
var selectIdList = {
		"oc_lapelDesign":"00001",
			"oc_waistPkt":"00002",
			"oc_changePkt":"00003",
			"oc_slantedPkt":"00004",
			"oc_ventSpec":"00005",
			"oc_frontBtnCnt":"00006",
			"oc_cuffSpec":"00007",
			"oc_sleeveBtnType":"00008",
			"oc_backBelt":"00009",
			"oc_chainHange":"00010",
			"oc_bodyBackMate":"00011",
			"oc_cuffBackMate":"00012",
			"oc_frontBtnMate":"00013",
}
//各項目対応するのサブアイテムコード
var subList = {
		"oc_lapelDesign":"06",
		"oc_waistPkt":"06",
		"oc_changePkt":"06",
		"oc_slantedPkt":"06",
		"oc_ventSpec":"06",
		"oc_frontBtnCnt":"06",
		"oc_cuffSpec":"06",
		"oc_sleeveBtnType":"06",
		"oc_backBelt":"06",
		"oc_chainHange":"06",
		"oc_bodyBackMate":"06",
		"oc_cuffBackMate":"06",
		"oc_frontBtnMate":"06"
};
//オプション金額を表示するリスト
var ctPriceList = [
	{id:"coatModel",type:"2"},
	{id:"oc_lapelDesign",type:"2"},
	{id:"oc_waistPkt",type:"2"},
	{id:"oc_changePkt",idVal:"optionCoatStandardInfo.ocChangePkt",type:"1"},
	{id:"oc_slantedPkt",idVal:"optionCoatStandardInfo.ocSlantedPkt",type:"1"},
	{id:"oc_ventSpec",idVal:"optionCoatStandardInfo.ocVentSpec",type:"1"},
	{id:"oc_frontBtnCnt",type:"2"},
	{id:"oc_cuffSpec",type:"2"},
	{id:"oc_sleeveBtnType",type:"2"},
	{id:"oc_backBelt",idVal:"optionCoatStandardInfo.ocBackBelt",type:"1"},
	{id:"oc_chainHange",idVal:"optionCoatStandardInfo.ocChainHange",type:"1"},
	{id:"oc_bodyBackMate",type:"2"},
	{id:"oc_bodyBackMateStkNo",type:"2"},
	{id:"oc_cuffBackMate",type:"2"},
	{id:"oc_cuffBackMateStkNo",type:"2"},
	{id:"oc_frontBtnMate",type:"2"},
	{id:"oc_frontBtnMateStkNo",type:"2"}
];

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
	
	setCoatModelDisable();
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
	
	//--------------------------------------------
	// オプションタブ（COAT）
	//--------------------------------------------
	initOptionCoat();
	mateInit();
	getPrice();
	jQuery("#coatItemFlag").val("1");
});

function setCoatModelDisable(){
	var ctModel = null;
	ctModel = document.getElementById("coatModel");
	var allCtOption = ctModel.options;
	allCtOption[0].disabled = true;
}
//--------------------------------------------
//素材品番の初期化
//--------------------------------------------
function mateInit(){
	var itemCode;
	var subItemCode;
	var category = "0";
	var StkNo;
	var mateChecked;
	var orderPattern = "CO";
	var optionCode;
	// 標準の場合　Coat 胴裏素材と袖裏素材と釦素材のid List
	var ctStandardMateList = ["oc_bodyBackMate","oc_cuffBackMate","oc_frontBtnMate"];
	var item = jQuery("#item option:selected").val();
	jQuery("#category option:first").prop("selected",true);
	if(item=="06"){
		itemCode = item;
		subItemCode = "06";
		initCtStandard(itemCode,subItemCode);
	}
	function initCtStandard(itemCode,subItemCode){
		for(var i in ctStandardMateList){
			optionCode = selectIdList[ctStandardMateList[i]];
			mateChecked = jQuery("#"+ctStandardMateList[i]+" option:checked").val();
			StkNo = "#"+ctStandardMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,0,orderPattern);
		}
		jQuery("#oc_bodyBackMate,#oc_cuffBackMate,#oc_frontBtnMate").change(function(){
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
		jQuery.ajax({
			 type:"get",
			 url: contextPath + "/orderCo/standardMateSelect",
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
//全部のitem金額制御
//--------------------------------------------
function getPrice(){
	//COATの料金を表示
	var coatModel = "";
	jQuery("#coatModel").change(function(){
		coatModel = jQuery("#coatModel option:selected").val();
		if(isNotEmpty(coatModel)){
			coatChangePrice(coatModel);
		}
	})	
	var coatModel = "";
	//プルダウンの変更処理
	//項目：ラペルデザイン、腰ポケット、フロント釦数、袖口、袖釦、胴裏素材、胴裏素材品番、袖裏素材、袖裏素材品番、釦素材、釦素材品番
	jQuery("#oc_lapelDesign,#oc_waistPkt,#oc_frontBtnCnt,#oc_cuffSpec,#oc_sleeveBtnType,#oc_bodyBackMate,#oc_bodyBackMateStkNo,#oc_cuffBackMate,#oc_cuffBackMateStkNo,#oc_frontBtnMate,#oc_frontBtnMateStkNo")
	   .change(function(){
		   coatModel = jQuery("#coatModel option:selected").val();
	   if(isNotEmpty(coatModel)){
		   var idValue = jQuery(this).attr("id");
		   if(idValue=='coatModel'){
			   coatChangePrice(coatModel);
		   }
		   var thisVal = jQuery(this).val();
		   coatModel = jQuery("#coatModel").val();
		   dealWithPice(idValue,thisVal,coatModel);
		   }
	});
	//ラジオボタンの変更処理
	//項目：チェンジポケット、スランテッドポケット、ベント、バックベルト、襟吊
	jQuery('input[id^="lapelDesign_"],[id^="fort_"],[id^="backSpec_"],[id^="waistPkt_"],[id^="changePkt_"],[id^="slantedPkt_"],[id^="cuffSpec_"],[id^="stitch_"],[id^="ventSpec_"]')
	.change(function(){
		coatModel = jQuery("#jacketModel option:selected").val();
		if(isNotEmpty(coatModel)){
			var idValue = jQuery(this).attr("id");
			var thisVal = jQuery(this).val();
			frontBtnCntVal = jQuery("#oj_frontBtnCnt").val();
			dealWithPice(idValue,thisVal,coatModel);
		}
	});
}
//--------------------------------------------
//COAT 金額変更制御
//--------------------------------------------
function coatChangePrice(ctModelCode){
	var coatModel = jQuery("#coatModel").val();
	for(i of ctPriceList){
		if(coatModel=="SingleChester"){
			//プルダウンの場合
			if(i.type == "2"){
				var idValue = i.id;
				var thisVal = jQuery("#"+idValue).val();
				dealWithPice(idValue,thisVal,ctModelCode);
			//ラジオボタンの場合
			}else if(i.type == "1"){
				var idValue = i.id;
				var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
				dealWithPice(idValue,thisVal,ctModelCode);
			}
		}else if(coatModel=="DoubleChester"){
			//プルダウンの場合
			if(i.type == "2"){
				var idValue = i.id;
				var thisVal = jQuery("#"+idValue).val();
				dealWithPice(idValue,thisVal,ctModelCode);
			//ラジオボタンの場合
			}else if(i.type == "1"){
				var idValue = i.id;
				var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
				dealWithPice(idValue,thisVal,ctModelCode);
			}
		}else if(coatModel=="DoublePolo"){
			//プルダウンの場合
			if(i.type == "2"){
				var idValue = i.id;
				var thisVal = jQuery("#"+idValue).val();
				dealWithPice(idValue,thisVal,ctModelCode);
			//ラジオボタンの場合
			}else if(i.type == "1"){
				var idValue = i.id;
				var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
				dealWithPice(idValue,thisVal,ctModelCode);
			}
		}else if(coatModel=="SoutienCollar"){
			//プルダウンの場合
			if(i.type == "2"){
				var idValue = i.id;
				var thisVal = jQuery("#"+idValue).val();
				dealWithPice(idValue,thisVal,ctModelCode);
			//ラジオボタンの場合
			}else if(i.type == "1"){
				var idValue = i.id;
				var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
				dealWithPice(idValue,thisVal,ctModelCode);
			}
		}
	}
}
//--------------------------------------------
//シングル金額制御
//--------------------------------------------
function dealWithPice(idValue,thisVal,modelCode){
	//アイテムコード
	var itemCode = "06";
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
	if(idValue=="oc_bodyBackMate"||idValue=="oc_cuffBackMate"||idValue=="oc_frontBtnMate"){
		var stkNo = idValue+"StkNo";
		var stkNoVal = jQuery("#"+stkNo).val();
		//アイテムコード + サブアイテムコード + モデルコード + オプションコード + オプション選択肢コード + オプション選択肢詳細コード
		var codeDetail = itemCode + subItemCode + modelCode + optionCode + thisVal + stkNoVal;
		var price = jQuery.ajax({url:contextPath + "/orderCo/getOrderPrice",data:{"code":code,"codeDetail":codeDetail},async:false});
		price = price.responseText;
		if(price == "0"){
			price = "無料";
		}else{
			price = formatMoney(price,0,"￥");
		}
		jQuery("#"+idValue+"_Msg").html(price);
		allOptionPrice();
		
	//各素材品番の変更処理
	}else if(idValue=="oc_bodyBackMateStkNo"||idValue=="oc_cuffBackMateStkNo"||idValue=="oc_frontBtnMateStkNo"){
		//*StkNo　⇒　*
		idValue = idValue.substr(0, idValue.length - 5);
		
		subItemCode = subList[idValue];
		optionCode = selectIdList[idValue];
		
		var valCode = jQuery("#"+idValue).val();
		//アイテムコード + サブアイテムコード + モデルコード + オプションコード + オプション選択肢コード
		var code = itemCode + subItemCode + modelCode + optionCode  + valCode;
		//アイテムコード + サブアイテムコード + モデルコード + オプションコード + オプション選択肢コード + オプション選択肢詳細コード
		var codeDetail = itemCode + subItemCode + modelCode + optionCode + valCode + thisVal;
		var price = jQuery.ajax({url:contextPath + "/orderCo/getOrderPrice",data:{"code":code,"codeDetail":codeDetail},async:false});
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
		var price = jQuery.ajax({url:contextPath + "/orderCo/getOrderNormalPrice",data:{"code":code,"codeDetail":codeDetail},async:false});
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
//オプション金額
//--------------------------------------------
function allOptionPrice(){
	var priceHtmlMsgList = ["oc_lapelDesign_Msg","oc_waistPkt_Msg","oc_changePkt_Msg","oc_slantedPkt_Msg","oc_ventSpec_Msg",
		"oc_frontBtnCnt_Msg","oc_cuffSpec_Msg","oc_sleeveBtnType_Msg","oc_backBelt_Msg","oc_chainHange_Msg","oc_bodyBackMate_Msg","oc_cuffBackMate_Msg",
		"oc_frontBtnMate_Msg"];

	var msgPrice = null;
	var count = 0;
	var msg;
	for(msgPrice of priceHtmlMsgList){
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
	count = count.toString();
	jQuery("#optionPriceId").val(count);
	count = formatMoney(count,0,"");
	jQuery("#optionPrice").html(count);
	//allPrice();
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

jQuery("#coatModel").change(function(){
		jQuery("#coatFlag").val("1");
});
/************************************************
 * 部品メソッド
 ************************************************/
 // 自作jsに記載

</script>
