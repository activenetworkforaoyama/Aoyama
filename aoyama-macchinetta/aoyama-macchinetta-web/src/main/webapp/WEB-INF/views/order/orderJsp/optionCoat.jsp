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
                            <div class="col-12 col-md-9 offset-md-3" id="coatModelMsg" style="margin-top:8px"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="coatModelCheck" style="margin-top:8px"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label></div>
                            <div class="col-12 col-md-3">
                            	<form:select id="oc_lapelDesign" path="optionCoatStandardInfo.ocLapelDesign" class="form-control-sm form-control">
                                    <form:options items="${orderForm.optionCoatStandardInfo.ocLapelDesignMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right">
                            	<output id="oc_lapelDesign_Msg" name="rtPrice"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <div class="form-check-inline form-check">
                                    	<form:radiobuttons id="oc_sleeveSpec_id" path="optionCoatStandardInfo.ocSleeveSpec" class="form-check-input" items="${orderForm.optionCoatStandardInfo.ocSleeveSpecMap}"/>
                                	</div>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="oc_sleeveSpec_Msg"></output>
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
                            	<output id="oc_waistPkt_Msg" name="rtPrice"></output>
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
                            	<output id="oc_changePkt_Msg" name="rtPrice"></output>
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
                            	<output id="oc_slantedPkt_Msg" name="rtPrice"></output>
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
                            	<output id="oc_ventSpec_Msg" name="rtPrice"></output>
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
                            	<output id="oc_frontBtnCnt_Msg" name="rtPrice"></output>
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
                            	<output id="oc_cuffSpec_Msg" name="rtPrice"></output>
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
                            	<output id="oc_sleeveBtnType_Msg" name="rtPrice"></output>
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
                            	<output id="oc_backBelt_Msg" name="rtPrice"></output>
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
                            	<output id="oc_chainHange_Msg" name="rtPrice"></output>
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
                            	<output id="oc_bodyBackMate_Msg" name="rtPrice"></output>
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
                            	<output id="oc_cuffBackMate_Msg" name="rtPrice"></output>
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
                            	<output id="oc_frontBtnMate_Msg" name="rtPrice"></output>
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
			"oc_sleeveSpec":"00014",
}
//各項目対応するのサブアイテムコード
var subList = {
		"oc_lapelDesign":"06",
		"oc_sleeveSpec":"06",
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
	{id:"oc_sleeveSpec",idVal:"optionCoatStandardInfo.ocSleeveSpecMap",type:"1"},
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
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		coatModel = jQuery("#coatModel option:selected").val();
		var itemCode = "06";
	    var subItemCode = jQuery("#item").val();
	    var code = itemCode + subItemCode + coatModel;
	    jQuery.ajax({
	    	type:"get",
		    url:contextPath + "/orderCo/getOrderPriceForCoatModel",
		    data:{"code":code},
		    async:false,
		    success:function(result){
		    	var aDiv = document.getElementsByName('rtPrice');
				for(var i=0;i<aDiv.length;i++){
					aDiv[i].innerHTML = result.coPrice[i];
				}
		    	jQuery("#optionPriceId").val(result.optionPrice);
		    	jQuery("#optionPrice").html(result.optionPrice);
			}
		});
	    
	});
	var coatModel = "";
	//プルダウンの変更処理
	//項目：ラペルデザイン、腰ポケット、フロント釦数、袖口、袖釦、胴裏素材、胴裏素材品番、袖裏素材、袖裏素材品番、釦素材、釦素材品番
	jQuery("#oc_lapelDesign,#oc_waistPkt,#oc_frontBtnCnt,#oc_cuffSpec,#oc_sleeveBtnType,#oc_bodyBackMate,#oc_bodyBackMateStkNo,#oc_cuffBackMate,#oc_cuffBackMateStkNo,#oc_frontBtnMate,#oc_frontBtnMateStkNo")
	   .change(function(){
	   jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
	   coatModel = jQuery("#coatModel option:selected").val();
	   var itemCode = "06";
	   var subItemCode = jQuery("#item").val();
	   var idValueName = jQuery(this).attr("id");
	   var price;
	   if(isNotEmpty(coatModel)){
		   var code = itemCode + subItemCode + coatModel;
		   jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/getOrderPriceForCoatProject",
			    data:{"code":code,"idValue":idValueName},
			    dataType:"json",
			    async:false,
			    success:function(result){
			    	if(jQuery("#"+idValueName+"_Msg").length>0){
			    		if(result.idValuePrice == "0"){
							price = "無料"
				         }else{
				        	price = formatMoney(result.idValuePrice,0,"￥");
					     }
			             jQuery("#"+idValueName+"_Msg").html(price);
			             jQuery("#optionPrice").html(result.optionPrice);
			        }else{
			             var lengthforLastFive = idValueName.length - 5;
			             var idValueTemp = idValueName.substring(0,lengthforLastFive);
			             if(result.idValuePrice == "0"){
							price = "無料"
				         }else{
				        	price = formatMoney(result.idValuePrice,0,"￥");
					     }
			             jQuery("#"+idValueTemp+"_Msg").html(price);
			             jQuery("#optionPrice").html(result.optionPrice);
			        }		    
			   }
	        });
		}
	});
	//ラジオボタンの変更処理
	//項目：チェンジポケット、スランテッドポケット、ベント、バックベルト、襟吊
	jQuery('input[id^="oc_sleeveSpec_id"],[id^="oc_changePkt_id"],[id^="oc_slantedPkt_id"],[id^="oc_ventSpec_id"],[id^="oc_backBelt_id"],[id^="oc_chainHange_id"]')
	.change(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		coatModel = jQuery("#coatModel option:selected").val();
		var itemCode = "06";
	    var subItemCode = jQuery("#item").val();
	    var idValueName = jQuery(this).attr("id");
	    var price;
	  //IDの後の番号を削除します
	    var findIdPosition = idValueName.indexOf("_id");
	    var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
		    
		if(isNotEmpty(coatModel)){
			var code = itemCode + subItemCode + coatModel;
			jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/getOrderPriceForCoatProject",
			    data:{"code":code,"idValue":interceptedIdValueName},
			    async:false,
			    success:function(result){
			    	var msgIdValueName = interceptedIdValueName.replace(/_id/g,"_Msg");
			    	if(result.idValuePrice == "0"){
						price = "無料"
			         }else{
			        	price = formatMoney(result.idValuePrice,0,"￥");
				     }
			        jQuery("#"+msgIdValueName).html(price);
			        jQuery("#optionPrice").html(result.optionPrice);	    
			   }
	        });
		}
	});
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
