<form:form id="idInfoForm" action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm" method="post" modelAttribute="orderCoForm" class="form-horizontal">
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
                                <form:select id="coatModel" path="coOptionCoatStandardInfo.coatModel" class="form-control-sm form-control">
                                    <form:options items="${orderCoForm.coOptionCoatStandardInfo.coatModelMap}"/>
                                </form:select>
                            </div>
                             <div class="col-12 col-md-6" align="right">
                            	<output id="coatModel_Msg" ></output>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="coatModelMsg" style="margin-top:8px"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="coatModelCheck" style="margin-top:8px"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label></div>
                            <div class="col-12 col-md-3">
                            	<form:select id="oc_lapelDesign" path="coOptionCoatStandardInfo.ocLapelDesign" class="form-control-sm form-control">
                                    <form:options items="${orderCoForm.coOptionCoatStandardInfo.ocLapelDesignMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right">
                            	<output id="oc_lapelDesign_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <div class="form-check-inline form-check">
                                    	<form:radiobuttons id="oc_sleeveSpec_id" path="coOptionCoatStandardInfo.ocSleeveSpec" class="form-check-input" items="${orderCoForm.coOptionCoatStandardInfo.ocSleeveSpecMap}"/>
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
                            	<form:select id="oc_waistPkt" path="coOptionCoatStandardInfo.ocWaistPkt" class="form-control-sm form-control">
                                    <form:options items="${orderCoForm.coOptionCoatStandardInfo.ocWaistPktMap}"/>
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
                                	<form:radiobuttons id="oc_changePkt_id" path="coOptionCoatStandardInfo.ocChangePkt" class="form-check-input" items="${orderCoForm.coOptionCoatStandardInfo.ocChangePktMap}"/>
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
                                	<form:radiobuttons id="oc_slantedPkt_id" path="coOptionCoatStandardInfo.ocSlantedPkt" class="form-check-input" items="${orderCoForm.coOptionCoatStandardInfo.ocSlantedPktMap}"/>
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
                                    <form:radiobuttons id="oc_ventSpec_id" path="coOptionCoatStandardInfo.ocVentSpec" class="form-check-input" items="${orderCoForm.coOptionCoatStandardInfo.ocVentSpecMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="oc_ventSpec_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント釦数</label></div>
                            <div class="col-12 col-md-3">
                            	<form:select id="oc_frontBtnCnt" path="coOptionCoatStandardInfo.ocFrontBtnCnt" class="form-control-sm form-control">
                                    <form:options items="${orderCoForm.coOptionCoatStandardInfo.ocFrontBtnCntMap}" class="Front-Btn-Cnt"/>
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
                            	<form:select id="oc_cuffSpec" path="coOptionCoatStandardInfo.ocCuffSpec" class="form-control-sm form-control">
                                    <form:options items="${orderCoForm.coOptionCoatStandardInfo.ocCuffSpecMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right">
                            	<output id="oc_cuffSpec_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group" id="oc_sleeveBtnType_div">
                            <div class="col col-md-3"><label class=" form-control-label">袖釦</label></div>
                            <div class="col-12 col-md-3">
                            	<form:select id="oc_sleeveBtnType" path="coOptionCoatStandardInfo.ocSleeveBtnType" class="form-control-sm form-control">
                                    <form:options items="${orderCoForm.coOptionCoatStandardInfo.ocSleeveBtnTypeMap}"/>
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
                                	<form:radiobuttons id="oc_backBelt_id" path="coOptionCoatStandardInfo.ocBackBelt" class="form-check-input" items="${orderCoForm.coOptionCoatStandardInfo.ocBackBeltMap}"/>
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
                                	<form:radiobuttons id="oc_chainHange_id" path="coOptionCoatStandardInfo.ocChainHange" class="form-check-input" items="${orderCoForm.coOptionCoatStandardInfo.ocChainHangeMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="oc_chainHange_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
                            <div class="col col-md-3">
                            	<form:select id="oc_bodyBackMate" path="coOptionCoatStandardInfo.ocBodyBackMate" class="form-control-sm form-control">
                                    <form:options items="${orderCoForm.coOptionCoatStandardInfo.ocBodyBackMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="coOptionCoatStandardInfo.ocBodyBackMateStkNo" id="oc_bodyBackMateStkNo" class="form-control-sm form-control">

                                </select>
                            </div>
                            <div class="col-12 col-md-2" align="right">
                            	<output id="oc_bodyBackMate_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
                            <div class="col col-md-3">
                            	<form:select id="oc_cuffBackMate" path="coOptionCoatStandardInfo.ocCuffBackMate" class="form-control-sm form-control">
                                    <form:options items="${orderCoForm.coOptionCoatStandardInfo.ocCuffBackMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="coOptionCoatStandardInfo.ocCuffBackMateStkNo" id="oc_cuffBackMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col-12 col-md-2" align="right">
                            	<output id="oc_cuffBackMate_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
                            <div class="col col-md-3">
                            	<form:select id="oc_frontBtnMate" path="coOptionCoatStandardInfo.ocFrontBtnMate" class="form-control-sm form-control">
                                    <form:options items="${orderCoForm.coOptionCoatStandardInfo.ocFrontBtnMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="coOptionCoatStandardInfo.ocFrontBtnMateStkNo" id="oc_frontBtnMateStkNo" class="form-control-sm form-control">
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
            <input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="${orderCoForm.jacketItemFlag }"/>
			<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="${orderCoForm.giletItemFlag }"/>
			<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="${orderCoForm.shirtItemFlag }"/>
			<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="${orderCoForm.coatItemFlag }"/>
			<input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="${orderCoForm.pants2ItemFlag }"/>

            <%--  <input type="hidden" id="jacketAdFlag" name="jacketAdFlag" value="${orderCoForm.jacketAdFlag }" />
             <input type="hidden" id="coatAdFlag" name="coatAdFlag" value="${orderCoForm.coatAdFlag }" />
             <input type="hidden" id="giletAdFlag" name="giletAdFlag" value="${orderCoForm.giletAdFlag }" />
             <input type="hidden" id="pantsAdFlag" name="pantsAdFlag" value="${orderCoForm.pantsAdFlag }" />
             <input type="hidden" id="pants2AdFlag" name="pants2AdFlag" value="${orderCoForm.pants2AdFlag }" />
             <input type="hidden" id="shirtAdFlag" name="shirtAdFlag" value="${orderCoForm.shirtAdFlag }" /> --%>
</form:form>


<!-- 自作js -->
<script
	src="${pageContext.request.contextPath}/resources/app/self/js/option.coat.js"></script>

<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";
var orderFlag = "${orderCoForm.orderFlag}";
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

/************************************************
 * 読み込み時イベント設定
 ************************************************/
 // 自作jsに記載
jQuery(document).ready(function() {
	
	
	if("orderCo"==orderFlag){
		if(coatAdFlag=="1"){
		}else{
			coatAdFlag="0";
		}
	}else if("0"==jQuery("#coatItemFlag").val() && "orderCo"!=orderFlag){
		    coatAdFlag="1";
	}
	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });
	
	setCoatModelDisable();
	//--------------------------------------------
	// オプションタブ（COAT）
	//--------------------------------------------
	initOptionCoat();
	mateInit();
	mateStkNoReInit();
	getPrice();
	showPrice();
	doubleOptionModelPrice();
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
	var category = "9000101";
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
function showPrice(){
	var coatModel = jQuery("#coatModel option:selected").val();
	if(!(coatModel == "")){
		jQuery("#coatModel").change();
	}
}
//--------------------------------------------
//全部のitem金額制御
//--------------------------------------------
function getPrice(){
	//COATの料金を表示
	var coatModel = "";
	jQuery("#coatModel").change(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});
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
		});
	    
	var coatModel = "";
	//プルダウンの変更処理
	//項目：ラペルデザイン、腰ポケット、フロント釦数、袖口、袖釦、胴裏素材、胴裏素材品番、袖裏素材、袖裏素材品番、釦素材、釦素材品番
	jQuery("#oc_lapelDesign,#oc_waistPkt,#oc_frontBtnCnt,#oc_cuffSpec,#oc_sleeveBtnType,#oc_bodyBackMate,#oc_bodyBackMateStkNo,#oc_cuffBackMate,#oc_cuffBackMateStkNo,#oc_frontBtnMate,#oc_frontBtnMateStkNo")
	   .change(function(){
	   //jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
	   coatModel = jQuery("#coatModel option:selected").val();
	   var thisVal = "";
	   var thisValStkNo = "";
	   var itemCode = "06";
	   var subItemCode = jQuery("#item").val();
	   var idValueName = jQuery(this).attr("id");
	   if(idValueName.indexOf("StkNo") == -1){
		   thisVal = jQuery("#" + idValueName).val();
		   thisValStkNo = jQuery("#" + idValueName + "StkNo").val();
	   }else{
		   thisValStkNo = jQuery("#" + idValueName).val();
		   idValueName = idValueName.replace("StkNo","");
		   thisVal = jQuery("#" + idValueName).val();
	   }
	   var price;
	   if(isNotEmpty(coatModel)){
		   var code = itemCode + subItemCode + coatModel;
		   jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/getOrderPriceForCoatProject",
			    data:{"code":code,"idValue":idValueName,"thisVal":thisVal,"thisValStkNo":thisValStkNo},
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
			             //jQuery("#optionPrice").html(result.optionPrice);
			        }else{
			             var lengthforLastFive = idValueName.length - 5;
			             var idValueTemp = idValueName.substring(0,lengthforLastFive);
			             if(result.idValuePrice == "0"){
							price = "無料"
				         }else{
				        	price = formatMoney(result.idValuePrice,0,"￥");
					     }
			             jQuery("#"+idValueTemp+"_Msg").html(price);
			             //jQuery("#optionPrice").html(result.optionPrice);
			             
			        }
			    	getAllPrice(itemCode, result.optionPrice);
		            allOptionPrice();	    
			   }
	        });
		}
	});
	var coatModel = "";
	//ラジオボタンの変更処理
	//項目：チェンジポケット、スランテッドポケット、ベント、バックベルト、襟吊
	jQuery('input[id^="oc_sleeveSpec_id"],[id^="oc_changePkt_id"],[id^="oc_slantedPkt_id"],[id^="oc_ventSpec_id"],[id^="oc_backBelt_id"],[id^="oc_chainHange_id"]')
	.change(function(){
		//jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		coatModel = jQuery("#coatModel option:selected").val();
		var thisVal = "";  
		var itemCode = "06";
	    var subItemCode = jQuery("#item").val();
	    var idValueName = jQuery(this).attr("id");
	    thisVal = jQuery("#"+idValueName).val();
	    var price;
	  //IDの後の番号を削除します
	    var findIdPosition = idValueName.indexOf("_id");
	    var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
		    
		if(isNotEmpty(coatModel)){
			var code = itemCode + subItemCode + coatModel;
			jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/getOrderPriceForCoatProject",
			    data:{"code":code,"idValue":interceptedIdValueName,"thisVal":thisVal},
			    async:false,
			    success:function(result){
			    	var msgIdValueName = interceptedIdValueName.replace(/_id/,"_Msg");
			    	if(result.idValuePrice == "0"){
						price = "無料"
			         }else{
			        	price = formatMoney(result.idValuePrice,0,"￥");
				     }
			        jQuery("#"+msgIdValueName).html(price);
			        jQuery("#optionPrice").html(result.optionPrice);
			        getAllPrice(itemCode, result.optionPrice);	
			        allOptionPrice();    
			   }
	        });
		}
	});
}
function getAllPrice(subItemCode, optionPrice){
	jQuery("#ctOptionPriceId").val(optionPrice);
    var ctOptionPriceId = optionPrice;
    var jkOptionPriceId = jQuery("#jkOptionPriceId").val();
    var ptOptionPriceId = jQuery("#ptOptionPriceId").val();
    var pt2OptionPriceId = jQuery("#pt2OptionPriceId").val();
    var glOptionPriceId = jQuery("#glOptionPriceId").val();
    var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
    var twoPants = jQuery('input[name="productSparePantsClass"]:checked').val();
    var allPrice = 0;
    if(subItemCode == "01"){
        if(threePiece == "0009901" && twoPants == "0009901"){
        	allPrice = Number(jkOptionPriceId) + Number(ptOptionPriceId);
        }
        else if(threePiece == "0009902" && twoPants == "0009901"){
        	allPrice = Number(jkOptionPriceId) + Number(ptOptionPriceId) + Number(glOptionPriceId);
        }
        else if(threePiece == "0009901" && twoPants == "0009902"){
        	allPrice = Number(jkOptionPriceId) + Number(ptOptionPriceId) + Number(pt2OptionPriceId);
        }else{
        	allPrice = Number(jkOptionPriceId) + Number(ptOptionPriceId) + Number(pt2OptionPriceId) + Number(glOptionPriceId);
        }
    }else{
    	allPrice = Number(ctOptionPriceId);
    }
    jQuery("#optionPriceId").val(allPrice);
    jQuery("#optionPrice").html(formatMoney(allPrice,0,""));
}
function doubleOptionModelPrice(){
	jQuery("#coatModel_Msg").empty();
	var productCategory = jQuery('input[name="productCategory"]:checked').val();
	var productFabricNo = jQuery("#productFabricNo").val();
	var item = jQuery("#item").val();
	var subItem = "06";
	var coatModelVal = jQuery("#coatModel").val();
	//生地チェクフラッグ
	if(coatModelVal == "DoubleChester" || coatModelVal == "DoublePolo"){
		var fabricCheckValue = jQuery("#fabricFlag").val();
		//fabricCheckValue[0]:0 or 1 or 2 
		//fabricCheckValue[1]:エラーメッセージ 
		fabricCheckValue = fabricCheckValue.split("*");
		//生地チェク成功の場合
		if((fabricCheckValue[0]=="0")&&isNotEmpty(productFabricNo)){
			jQuery.ajax({
				 type:"get",
				 url: contextPath + "/orderCo/findStockModelDoublePrice",
				 data:{"fabricNo":productFabricNo,"orderPattern":orderPattern,"doubleCheck":coatModelVal,"item":item,"subItem":subItem},
				 async:false,
				 success:function(result){
					if(isNotEmpty(result)){
						if(result.ctDoublePrice == "0"){
							jQuery("#ctDoubleModelPrice").val(result.ctDoublePrice);
							jQuery("#coatModel_Msg").html("無料");
							allOptionPrice();
						}else{
							jQuery("#ctDoubleModelPrice").val(result.ctDoublePrice);
							jQuery("#coatModel_Msg").html(formatMoney(result.ctDoublePrice,0,"￥"));
							allOptionPrice();
						}
					}else{
						jQuery("#ctDoubleModelPrice").val("0");
						jQuery("#coatModel_Msg").html("無料");
						allOptionPrice();
					}
			     }
			});
		}
	}
	
	if(productCategory == "9000101"){
		jQuery('#coatModel').change(function(){
			var coatModel = jQuery(this).val();
			if(coatModel == "DoubleChester" || coatModel == "DoublePolo"){
				//生地チェクフラッグ
				var fabricCheckValue = jQuery("#fabricFlag").val();
				//fabricCheckValue[0]:0 or 1 or 2 
				//fabricCheckValue[1]:エラーメッセージ 
				fabricCheckValue = fabricCheckValue.split("*");
				//生地チェク成功の場合
				if((fabricCheckValue[0]=="0")&&isNotEmpty(productFabricNo)){
					jQuery.ajax({
						 type:"get",
						 url: contextPath + "/orderCo/findStockModelDoublePrice",
						 data:{"fabricNo":productFabricNo,"orderPattern":orderPattern,"doubleCheck":coatModel,"item":item,"subItem":subItem},
						 async:false,
						 success:function(result){
							 if(isNotEmpty(result)){
								 if(result.ctDoublePrice == "0"){
									 jQuery("#ctDoubleModelPrice").val(result.ctDoublePrice);
									 jQuery("#coatModel_Msg").html("無料");
									 allOptionPrice();
								 }else{
									 jQuery("#ctDoubleModelPrice").val(result.ctDoublePrice);
									 jQuery("#coatModel_Msg").html(formatMoney(result.ctDoublePrice,0,"￥"));
									 allOptionPrice();
								 }
							 }else{
								 jQuery("#ctDoubleModelPrice").val("0");
								 jQuery("#coatModel_Msg").html("無料");
								 allOptionPrice();
							 }
						 }
					});
				}
			}else{
				jQuery("#ctDoubleModelPrice").val("0");
				jQuery("#coatModel_Msg").html("無料");
				allOptionPrice();
			}
		})
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
function mateStkNoReInit(){
	var ctInnerBodyClothCd = "${orderCoForm.coOptionCoatStandardInfo.ocBodyBackMateStkNo}";
	if(isNotEmpty(ctInnerBodyClothCd)){
		jQuery("#oc_bodyBackMateStkNo option[value='"+ctInnerBodyClothCd+"']").attr("selected", true);
	}
	var ctInnerSleeveClothCd = "${orderCoForm.coOptionCoatStandardInfo.ocCuffBackMateStkNo}";
	if(isNotEmpty(ctInnerSleeveClothCd)){
		jQuery("#oc_cuffBackMateStkNo option[value='"+ctInnerSleeveClothCd+"']").attr("selected", true);
	}
	var ctBtnMaterialCd = "${orderCoForm.coOptionCoatStandardInfo.ocFrontBtnMateStkNo}";
	if(isNotEmpty(ctBtnMaterialCd)){
		jQuery("#oc_frontBtnMateStkNo option[value='"+ctBtnMaterialCd+"']").attr("selected", true);
	}
}
jQuery("#coatModel").change(function() {
	jQuery("#coatFlag").val("1");
	if("orderCo"==orderFlag){
		coatAdFlag="0";	
	}else if("1"==jQuery("#coatItemFlag").val()){
		if("orderCo"!=orderFlag ){
			coatAdFlag="0";
		}
	}	
});
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
