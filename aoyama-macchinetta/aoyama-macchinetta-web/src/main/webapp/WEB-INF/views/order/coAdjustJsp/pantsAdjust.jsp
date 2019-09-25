<form:form id="idAdjustForm"
	action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm"
	method="post" modelAttribute="orderCoForm" class="form-horizontal">
	<div id="al_pants_div">
		<div class="card-header">
			<strong class="card-title">PANTS</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">PANTSサイズ</label>
						</div>
						<div class="col-12 col-md-6">
							体型
							<div class="form-check-inline form-check">
								<form:select id="selectPantsFigure"
									path="coAdjustPantsStandardInfo.sizeFigure"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderCoForm.coAdjustPantsStandardInfo.sizeFigureMap}" />
								</form:select>								
							</div>
							号数
							<div class="form-check-inline form-check">
								<form:select id="selectPantsNumber"
									path="coAdjustPantsStandardInfo.sizeNumber"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderCoForm.coAdjustPantsStandardInfo.sizeNumberMap}" />
								</form:select>								
							</div>
						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">PANTS補正</label>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtWaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtWaistRange" name="coAdjustPantsStandardInfo.corPtWaistCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corPtWaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtWaistRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPtWaist_div">
							<output id="corPtWaist_div_html">000.0cm</output>
						</div>						
						<div class="col-12 col-md-9 offset-md-3" id="ap_waist_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ヒップ修正</label>
						</div>
                                <div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtHipRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtHipRange" name="coAdjustPantsStandardInfo.corPtHipCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corPtHipRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtHipRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPtHip_div">
							<output id="corPtHip_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="ap_hip_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ワタリ幅修正</label>
						</div>
						<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtThighRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtThighRange" name="coAdjustPantsStandardInfo.corPtThighCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corPtThighRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtThighRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPtThigh_div">
							<output id="corPtThigh_div_html">000.0cm</output>
							<!-- <output>000.0</output>cm -->
						</div>
			<div class="col-12 col-md-9 offset-md-3" id="ap_watari_alert"></div>
						<div class="col-12 col-md-2 offset-md-3">
							<label class=" form-control-label">裾幅</label>
						</div>
						<div class="col-12 col-md-1">
							<label for="ap_hemWidth_relative" class="form-check-label ">
								<input type="radio" id="pt_hemWidth_relative" name="coAdjustPantsStandardInfo.corPtHemwidthType"
								value="1" class="form-check-input" checked>修正
							</label>
						</div>
						<div class="col-12 col-md-4" id="corPtHemwidthRangeId">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtHemwidthRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtHemwidthRange" name="coAdjustPantsStandardInfo.corPtHemwidthCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corPtHemwidthRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtHemwidthRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPtHemwidth_div"
							style="display: none">
							<output id="corPtHemwidth_div_html">000.0cm</output>
						</div>						
						<div class="col-12 col-md-9 offset-md-3" id="ap_hemWidthRel_alert"></div>
						<div class="col-12 col-md-1 offset-md-5">
							<label for="ap_hemWidth_absolute" class="form-check-label ">
								<input type="radio" id="pt_hemWidth_absolute" name="coAdjustPantsStandardInfo.corPtHemwidthType"
								value="2" class="form-check-input">指定
							</label>
						</div>
					<div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <select name="ap_hemWidthAbs10" id="ap_hemWidthAbs10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                </select>
                                <select name="ap_hemWidthAbs1" id="ap_hemWidthAbs1" class="form-control-sm form-control hidedown" style="width:32px">
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
                                <select name="ap_hemWidthAbsM1" id="ap_hemWidthAbsM1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
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
                                </div>
                            </div>
					
					
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="card-header">
                <strong class="card-title">店舗補正</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col-12 col-md-3">
                                <label class=" form-control-label">店舗補正入力欄</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <form:textarea path="coAdjustPantsStandardInfo.corPtStoreCorrectionMemo" id="corPtStoreCorrectionMemo" rows="3" placeholder="再補正コメント" class="form-control"></form:textarea>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
	<!-- PANTS1 -->
	<input type="hidden" id="corPtWaist_div_Size"
		name="coAdjustPantsStandardInfo.corPtWaistSize" value="" />
	<input type="hidden" id="corPtWaist_div_Gross"
		name="coAdjustPantsStandardInfo.corPtWaistGross" value="" />
    <!-- ヒップ修正            -->
    <input type="hidden" id="corPtHip_div_Size"
		name="coAdjustPantsStandardInfo.corPtHipSize" value="" />
	<input type="hidden" id="corPtHip_div_Gross"
		name="coAdjustPantsStandardInfo.corPtHipGross" value="" />

	<input type="hidden" id="corPtThigh_div_Size"
		name="coAdjustPantsStandardInfo.corPtThighSize" value="" />
	<input type="hidden" id="corPtThigh_div_Gross"
		name="coAdjustPantsStandardInfo.corPtThighGross" value="" />

	<input type="hidden" id="corPtHemwidth_div_Size"
		name="coAdjustPantsStandardInfo.corPtHemwidthSize" value="" />
	<input type="hidden" id="corPtHemwidth_div_Gross"
		name="coAdjustPantsStandardInfo.corPtHemwidthGross" value="" />
		
	<input type="hidden" id="corPtHemwidthDegignate"
		name="coAdjustPantsStandardInfo.corPtHemwidthDegignate" value="" />

	<input type="hidden" id="corPtRightinseam_div_Size"
		name="coAdjustPantsStandardInfo.corPtRightinseamSize" value="" />
	<input type="hidden" id="corPtRightinseamGross"
		name="coAdjustPantsStandardInfo.corPtRightinseamGross" value="" />


	<input type="hidden" id="corPtLeftinseam_div_Size"
		name="coAdjustPantsStandardInfo.corPtLeftinseamSize" value="" />
	<input type="hidden" id="corPtLeftinseamGross"
		name="coAdjustPantsStandardInfo.corPtLeftinseamGross" value="" />
	       <input type="hidden" id="pantsAdFlag" name="pantsAdFlag" value="1" />
		   <input type="hidden" id="jacketAdFlag" name="jacketAdFlag" value="${orderCoForm.jacketAdFlag }" />
           <input type="hidden" id="coatAdFlag" name="coatAdFlag" value="${orderCoForm.coatAdFlag }" />
           <input type="hidden" id="giletAdFlag" name="giletAdFlag" value="${orderCoForm.giletAdFlag }" />
           <input type="hidden" id="pants2AdFlag" name="pants2AdFlag" value="${orderCoForm.pants2AdFlag }" />
           <input type="hidden" id="shirtAdFlag" name="shirtAdFlag" value="${orderCoForm.shirtAdFlag }" />
</form:form>
<script
	src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";
var itemCode ="${orderCoForm.productItem}";
var pantsAdFlag="${orderCoForm.pantsAdFlag}";
var orderFlag = "${orderCoForm.orderFlag}";
var productCategory="${orderCoForm.productCategory}";
var ptModel="";
var opModel = "${orderCoForm.coOptionPantsStandardInfo.opPantsModel}";
var tpModel = "${orderCoForm.coOptionPantsTuxedoInfo.tpPantsModel}";
var wpModel = "${orderCoForm.coOptionPantsWashableInfo.wpPantsModel}";
var ptAdjustList = [
	{type:"05",id:"corPtHip_div"},
	{type:"06",id:"corPtWaist_div"},
	{type:"08",id:"corPtHemwidth_div"}
];
//06：ウエスト修正
var ptTackList = [
	{type:"07",id:"corPtThigh_div"}
	
];
jQuery(document).ready(function() {

	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });
    if(productCategory=="9000101"){
    	ptModel = opModel;
	}else if(productCategory=="9000102"){
		ptModel = tpModel;
	}else if(productCategory=="9000103"){
		ptModel = wpModel;
	}
     getAdjustByItem();
	 initAlter();
	 if(orderFlag == "orderCo"){
	    if(pantsAdFlag==""){
	    	adjustReInit();
		}else if(pantsAdFlag=="0"){
			adjustReInit();
			getFigureAndNumberByItem();
		}else if(pantsAdFlag=="1"){
			getFigureAndNumberByItem();
			adjustSession();
		}
	 }
	 if(orderFlag == "orderLink"||orderFlag == "orderCheck"||orderFlag == "orderBack"){
	     if(pantsAdFlag=="0"){
			adjustReInit();
			getFigureAndNumberByItem();
	    }else if(pantsAdFlag=="1"){
			getFigureAndNumberByItem();
			adjustSession();
		}else if(pantsAdFlag==""){
			 getFigureAndNumberByItem();
			 adjustSession();
		}
	 }
	  /*   }
	    if(orderFlag == "orderLink" || orderFlag == "orderCheck"){
	    	ptModel = opModel;
			getFigureAndNumberByItem();
			adjustSession();
		} */
jQuery("#selectPantsFigure,#selectPantsNumber").change(function(){
	ptAdjust();		
}) 
jQuery("#pantsAdFlag").val("1");
    //PANTS裾幅 指定
    jQuery("#pt_hemWidth_absolute").click(function(){
    	
    	jQuery("#corPtHemwidthRangeId").hide();
    	jQuery("#corPtHemwidth_div_Gross").val("0");
    	jQuery("#corPtHemwidthRange_out").val("0");
    	jQuery("#corPtHemwidthRange").val("0");
    	setFont("corPtHemwidthRange");
    	jQuery("#corPtHemwidthDegignate").val("10.0");
    });
    jQuery("#pt_hemWidth_relative").click(function(){
    	jQuery("#corPtHemwidth_div_Gross").val("0");
    	jQuery("#corPtHemwidthRange_out").val("0");
    	jQuery("#corPtHemwidthRange").val("0");
	    jQuery("#corPtHemwidthRangeId").show();
	    setFont("corPtHemwidthRange");
    });
    	jQuery("#ap_hemWidthAbs10,#ap_hemWidthAbs1,#ap_hemWidthAbsM1").change(function(){
    		var ap_hemWidthAbs10 = jQuery("#ap_hemWidthAbs10").val();
    		var ap_hemWidthAbs1 = jQuery("#ap_hemWidthAbs1").val();
    		var ap_hemWidthAbsM1 = jQuery("#ap_hemWidthAbsM1").val();
    		var corPtHemwidthDegignate = ap_hemWidthAbs10+ap_hemWidthAbs1+"."+ap_hemWidthAbsM1;
    		jQuery("#corPtHemwidthDegignate").val(corPtHemwidthDegignate);
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



});

function getAdjustByItem(){
	var subItemCode = "";
	if(itemCode == "03"){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getAdjustByItem",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	        	   if(e.subItemCode == "03"){
	        		   if(e.adjusteClass == "05"){
		            		document.getElementById("corPtHipRange").max = e.adjusteMax;
							document.getElementById("corPtHipRange").min = e.adjusteMin;
						}
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
	}if(itemCode == "01"){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getAdjustByItem",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {	  
		            if(e.subItemCode == "03"){
		               if(e.adjusteClass == "05"){
		            		document.getElementById("corPtHipRange").max = e.adjusteMax;
							document.getElementById("corPtHipRange").min = e.adjusteMin;
						}
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
	
	if(itemCode == "03"){
		subItemCode = itemCode;
		var ptFigure = document.getElementById("selectPantsFigure");
 	    getSizeFigure(itemCode,subItemCode,ptModel,ptFigure);
 	    

		var ptNumber = document.getElementById("selectPantsNumber");
		getSizeNumber(itemCode,subItemCode,ptModel,ptNumber);
	}if(itemCode == "01"){
		if(isNotEmpty(ptModel)){
			subItemCode = "03";
			var ptFigure = document.getElementById("selectPantsFigure");
     	    getSizeFigure(itemCode,subItemCode,ptModel,ptFigure);
     	    

			var ptNumber = document.getElementById("selectPantsNumber");
			getSizeNumber(itemCode,subItemCode,ptModel,ptNumber);
		}
	}
}
function getSizeFigure(itemCode,subItemCode,modelCode,figure){
	figure.options.length=0;
	figure.add(new Option("選択　　　",""));
	jQuery.ajax({
        url: contextPath + "/orderCo/getSizeFigureByItem",
        type: 'get',
        async:false,
        data:{"orderPattern":"CO","itemCode":itemCode,"subItemCode":subItemCode,"modelCode":modelCode},
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
        url: contextPath + "/orderCo/getSizeNumberByItem",
        type: 'get',
        async:false,
        data:{"orderPattern":"CO","itemCode":itemCode,"subItemCode":subItemCode,"modelCode":modelCode},
        success: function(data){
           jQuery.each(data, function (index, e) {
        	   number.add(new Option(e.sizeNumber,e.sizeNumber));
           });
        }
    });
}
function ptAdjust(){
	var pantsModel = ptModel;
	if(pantsModel==""||pantsModel==null){
		
	}else{
		jQuery("#corPtWaistRange").val(0);
		setFont("corPtWaistRange");
		jQuery("#corPtThighRange").val(0);
		setFont("corPtThighRange");
		jQuery("#corPtHipRange").val(0);
		setFont("corPtHipRange");
		jQuery("#corPtHemwidthRange").val(0);
		setFont("corPtHemwidthRange");

		jQuery("#corPtWaistRange_out").html('0');
		jQuery("#corPtThighRange_out").html('0');
		jQuery("#corPtHipRange_out").html('0');
		jQuery("#corPtHemwidthRange_out").html('0');
	}
	var subItemCode = "03";
	pantsFigure = jQuery("#selectPantsFigure").val();
	pantsNumber = jQuery("#selectPantsNumber").val();
	var opTack = "${orderCoForm.coOptionPantsStandardInfo.opTack}";
	

	//ノータック:0000101  1アウトタック:0000102  2アウトタック:0000104
	if(isNotEmpty(pantsFigure)&&isNotEmpty(pantsNumber)){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
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
					}else if(data[i].adjustClass == "05"){
						jQuery("#corPtHip_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPtHip_div_Size").val(data[i].typeSize);
	            		jQuery("#corPtHip_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "08"){
						jQuery("#corPtHemwidth_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPtHemwidth_div_Size").val(data[i].typeSize);
	            		jQuery("#corPtHemwidth_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "07"){
						if(opTack=="0000101"){
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize);
						}else if(opTack=="0000102"){
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize1Outtack + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize1Outtack);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize1Outtack);
						}else if(opTack=="0000103"){
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize1Intack + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize1Intack);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize1Intack);
						}else if(opTack=="0000104"){
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize2Outtack + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize2Outtack);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize2Outtack);
						}else if(opTack=="0000105"){
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize2Intack + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize2Intack);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize2Intack);
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

function adjustReInit(){
		
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

	jQuery("#corPtHip_div_Size").val("");
	jQuery("#corPtHip_div_Gross").val("");
	jQuery("#corPtHip_div_html").html("000.0cm");
	jQuery("#corPtHipRange_out").html("0");
	jQuery("#corPtHipRange").val("0");
	setFont("corPtHipRange");
	
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

	
	jQuery("#corPtHemwidthDegignate").val("");
	jQuery("#ap_hemWidthAbs10").val("1");
	jQuery("#ap_hemWidthAbs1").val("0");
	jQuery("#ap_hemWidthAbsM1").val("0");

} 

function adjustSession(){
	jQuery("#selectPantsFigure").val("${orderCoForm.coAdjustPantsStandardInfo.sizeFigure}");
	jQuery("#selectPantsNumber").val("${orderCoForm.coAdjustPantsStandardInfo.sizeNumber}");
	
	//PT　型サイズ値、補正値とグロス値を設定
	jQuery("#corPtWaist_div_Size").val("${orderCoForm.coAdjustPantsStandardInfo.corPtWaistSize}");
	jQuery("#corPtWaist_div_Gross").val("${orderCoForm.coAdjustPantsStandardInfo.corPtWaistGross}");
	jQuery("#corPtWaist_div_html").html("${orderCoForm.coAdjustPantsStandardInfo.corPtWaistGross}"+".cm");
	if("${orderCoForm.coAdjustPantsStandardInfo.corPtWaistGross}"==""){
		jQuery("#corPtWaist_div_html").html("000.0cm");
		}
	jQuery("#corPtWaistRange_out").html("${orderCoForm.coAdjustPantsStandardInfo.corPtWaistCorrect}");
	jQuery("#corPtWaistRange").val("${orderCoForm.coAdjustPantsStandardInfo.corPtWaistCorrect}");
	setFont("corPtWaistRange");

	jQuery("#corPtHip_div_Size").val("${orderCoForm.coAdjustPantsStandardInfo.corPtHipSize}");
	jQuery("#corPtHip_div_Gross").val("${orderCoForm.coAdjustPantsStandardInfo.corPtHipGross}");
	jQuery("#corPtHip_div_html").html("${orderCoForm.coAdjustPantsStandardInfo.corPtHipGross}"+".cm");
	if("${orderCoForm.coAdjustPantsStandardInfo.corPtHipGross}"==""){
		jQuery("#corPtHip_div_html").html("000.0cm");
		}
	jQuery("#corPtHipRange_out").html("${orderCoForm.coAdjustPantsStandardInfo.corPtHipCorrect}");
	jQuery("#corPtHipRange").val("${orderCoForm.coAdjustPantsStandardInfo.corPtHipCorrect}");
	setFont("corPtHipRange");
	
	jQuery("#corPtThigh_div_Size").val("${orderCoForm.coAdjustPantsStandardInfo.corPtThighSize}");
	jQuery("#corPtThigh_div_Gross").val("${orderCoForm.coAdjustPantsStandardInfo.corPtThighGross}");
	jQuery("#corPtThigh_div_html").html("${orderCoForm.coAdjustPantsStandardInfo.corPtThighGross}"+".cm");
	if("${orderCoForm.coAdjustPantsStandardInfo.corPtThighGross}"==""){
		jQuery("#corPtThigh_div_html").html("000.0cm");
		}
	jQuery("#corPtThighRange_out").html("${orderCoForm.coAdjustPantsStandardInfo.corPtThighCorrect}");
	jQuery("#corPtThighRange").val("${orderCoForm.coAdjustPantsStandardInfo.corPtThighCorrect}");
	setFont("corPtThighRange");

	var corPtRightinseamSize = "${orderCoForm.coAdjustPantsStandardInfo.corPtRightinseamSize}";
	jQuery("#corPtRightinseam_div_Size").val(corPtRightinseamSize);	
	
	var corPtRightinseamGross = "${orderCoForm.coAdjustPantsStandardInfo.corPtRightinseamGross}";
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

	var corPtLeftinseamSize = "${orderCoForm.coAdjustPantsStandardInfo.corPtLeftinseamSize}";
	jQuery("#corPtLeftinseam_div_Size").val(corPtLeftinseamSize);
	var corPtLeftinseamGross = "${orderCoForm.coAdjustPantsStandardInfo.corPtLeftinseamGross}";
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

	var corPtHemwidthTypeValue="${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthType}";
	if(corPtHemwidthTypeValue=="1"){
		jQuery("#pt_hemWidth_relative").prop("checked", true);
		jQuery("#corPtHemwidth_div_Size").val("${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthSize}");
		jQuery("#corPtHemwidth_div_Gross").val("${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthGross}");
		jQuery("#corPtHemwidth_div_html").html("${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthGross}"+".cm");
		if("${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthGross}"==""){
			jQuery("#corPtHemwidth_div_html").html("000.0cm");
			}
		jQuery("#corPtHemwidthRange_out").html("${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthCorrect}");
		jQuery("#corPtHemwidthRange").val("${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthCorrect}");
		setFont("corPtHemwidthRange");
	 }else if(corPtHemwidthTypeValue=="2"){
		 jQuery("#pt_hemWidth_absolute").prop("checked", true);
			var corPtHemwidthDegignate = "${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthDegignate}";
			jQuery("#corPtHemwidthDegignate").val(corPtHemwidthDegignate);
			corPtHemwidthDegignate = corPtHemwidthDegignate.split(".");
			if(isNotEmpty(corPtHemwidthDegignate[1])){
				jQuery("#ap_hemWidthAbsM1").val(corPtHemwidthDegignate[1]);
			}
			var str = corPtHemwidthDegignate[0];
			if(str.length == 2){
				str = str.split("");
				var left1 = str[1];
				var left10 = str[0];
				if(left10=="1"){
					jQuery("#ap_hemWidthAbs10").val("1");
				}else if(left10=="2"){
					jQuery("#ap_hemWidthAbs10").val("2");
				}
				jQuery("#ap_hemWidthAbs1").val(left1);
			}
    }
// 	jQuery("#corPtStoreCorrectionMemo").val("${orderCoForm.coAdjustPantsStandardInfo.corPtStoreCorrectionMemo}");
	
} 

</script>