<form:form id="idAdjustForm"
	action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm"
	method="post" modelAttribute="orderForm" class="form-horizontal">
	<div id="al2_pants_div">
		<div class="card-header">
			<strong class="card-title">PANTS（2本目）</strong>
			<button type="button" class="btn btn-outline-info btn-sm"
				id="btn_ap2_samePants">1本目と同じ</button>
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
							
								<form:select id="selectPants2Figure"
									path="adjustPants2StandardInfo.sizeFigure"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderForm.adjustPants2StandardInfo.sizeFigureMap}" />
								</form:select>

							</div>
							号数
							<div class="form-check-inline form-check">
								<form:select id="selectPants2Number"
									path="adjustPants2StandardInfo.sizeNumber"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderForm.adjustPants2StandardInfo.sizeNumberMap}" />
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
                                <a href="#" id="corPt2WaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPt2WaistRange" name="adjustPants2StandardInfo.corPt2WaistCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corPt2WaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPt2WaistRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPt2Waist_div">
							<output id="corPt2Waist_div_html">000.0cm</output>

						</div>
						<div class="col-12 col-md-9 offset-md-3" id="ap2_waist_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ヒップ修正</label>
						</div>					
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPt2HipRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPt2HipRange" name="adjustPants2StandardInfo.corPt2HipCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corPt2HipRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPt2HipRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPt2Hip_div">
							<output id="corPt2Hip_div_html">000.0cm</output>

						</div>
					
						<div class="col-12 col-md-9 offset-md-3" id="ap2_hip_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ワタリ修正</label>
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
							
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="ap2_watari_alert"></div>
						<div class="col-12 col-md-2 offset-md-3">
							<label class=" form-control-label">裾幅</label>
						</div>
						<div class="col-12 col-md-1">
							<label for="ap2_hemWidth_relative" class="form-check-label ">
								<input type="radio" id="pt2_hemWidth_relative"
								name="adjustPants2StandardInfo.corPt2HemwidthType" value="1" class="form-check-input" checked>修正
							</label>
						</div>
							<div class="col-12 col-md-4" id="corPt2HemwidthRangeId">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPt2HemwidthRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPt2HemwidthRange" name="adjustPants2StandardInfo.corPt2HemwidthCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corPt2HemwidthRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPt2HemwidthRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPt2Hemwidth_div"
							style="display: none">
							<output id="corPt2Hemwidth_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3"
							id="ap2_hemWidthRel_alert"></div>
						<div class="col-12 col-md-1 offset-md-5">
							<label for="ap2_hemWidth_absolute" class="form-check-label ">
								<input type="radio" id="pt2_hemWidth_absolute"
								name="adjustPants2StandardInfo.corPt2HemwidthType" value="2" class="form-check-input">指定
							</label>
						</div>
						 <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <select name="ap2_hemWidthAbs10" id="ap2_hemWidthAbs10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">1</option>
                                    <option value="2">2</option>
                                </select>
                                <select name="ap2_hemWidthAbs1" id="ap2_hemWidthAbs1" class="form-control-sm form-control hidedown" style="width:32px">
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
                                <select name="ap2_hemWidthAbsM1" id="ap2_hemWidthAbsM1" class="form-control-sm form-control hidedown" style="width:32px">
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
                                <textarea name="adjustPants2StandardInfo.corPt2StoreCorrectionMemo" id="corPt2StoreCorrectionMemo" rows="3" placeholder="再補正コメント" class="form-control"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
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
<input type="hidden" id="pants2AdFlag" name="pants2AdFlag" value="1" />
</form:form>
<script
	src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var orderPattern = "CO";
var itemCode ="${orderForm.productItem}";
var pants2AdFlag="${orderForm.pants2AdFlag}";
var pt2Model = "${orderForm.optionPants2StandardInfo.op2PantsModel}";
var opTack = "${orderForm.optionPants2StandardInfo.op2Tack}";
var pants2AdjustList = [
	{type:"05",id:"corPt2Hip_div"},
	{type:"06",id:"corPt2Waist_div"},
	{type:"07",id:"corPt2Thigh_div"},
	{type:"08",id:"corPt2Hemwidth_div"}
	//{type:"09",id:"corPt2Rightinseam_div"},
	//{type:"10",id:"corPt2Leftinseam_div"}
];
jQuery(document).ready(function() {

	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });
	
	getAdjustByItem();
	if(pants2AdFlag==""){
		
	}else if(pants2AdFlag=="0"){
		adjustReInit();
		getFigureAndNumberByItem();
	}else if(pants2AdFlag=="1"){
		getFigureAndNumberByItem();
		adjustSession();
	}
    
    initAlter();
jQuery("#selectPants2Figure,#selectPants2Number").change(function(){
    pt2Adjust();
   })   

//PANTS裾幅 指定
    jQuery("#pt2_hemWidth_absolute").click(function(){
    	
    	jQuery("#corPt2HemwidthRangeId").hide();
    	jQuery("#corPt2Hemwidth_div_Gross").val("0cm");
    	jQuery("#corPt2HemwidthRange_out").val("0");
    	jQuery("#corPt2HemwidthRange").val("0");
    	setFont("corPt2HemwidthRange");
    	
    });
    jQuery("#pt2_hemWidth_relative").click(function(){
    	jQuery("#corPt2Hemwidth_div_Gross").val("0cm");
    	jQuery("#corPt2HemwidthRange_out").val("0");
    	jQuery("#corPt2HemwidthRange").val("0");
	    jQuery("#corPt2HemwidthRangeId").show();
	    setFont("corPt2HemwidthRange");
    });
    	jQuery("#ap2_hemWidthAbs10,#ap2_hemWidthAbs1,#ap2_hemWidthAbsM1").change(function(){
    		var ap2_hemWidthAbs10 = jQuery("#ap2_hemWidthAbs10").val();
    		var ap2_hemWidthAbs1 = jQuery("#ap2_hemWidthAbs1").val();
    		var ap2_hemWidthAbsM1 = jQuery("#ap2_hemWidthAbsM1").val();
    		var corPtHemwidthGross = ap2_hemWidthAbs10+ap2_hemWidthAbs1+"."+ap2_hemWidthAbsM1;
    		jQuery("#corPt2Hemwidth_div_Gross").val(corPtHemwidthGross);
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

   
});
function getAdjustByItem(){
	var subItemCode = "";
	if(itemCode == "01"){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getAdjustByItem",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
		             if(e.subItemCode == "07"){
		               if(e.adjusteClass == "05"){
			            	document.getElementById("corPt2HipRange").max = e.adjusteMax;
							document.getElementById("corPt2HipRange").min = e.adjusteMin;
					    }
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
	}
}
function getFigureAndNumberByItem(){
	var subItemCode = "";
	if(itemCode == "01"){
		 if(isNotEmpty(pt2Model)){
			subItemCode = "07";
			var pt2Figure = document.getElementById("selectPants2Figure");
     	    getSizeFigure(itemCode,subItemCode,pt2Model,pt2Figure);
			var pt2Number = document.getElementById("selectPants2Number");
			getSizeNumber(itemCode,subItemCode,pt2Model,pt2Number);
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
function pt2Adjust(){
	if(pt2Model==""||pt2Model==null){
		
	}else{
		jQuery("#corPt2WaistRange").val(0);
		setFont("corPt2WaistRange");
		jQuery("#corPt2HipRange").val(0);
		setFont("corPt2HipRange");
		jQuery("#corPt2ThighRange").val(0);
		setFont("corPt2ThighRange");
		jQuery("#corPt2HemwidthRange").val(0);
		setFont("corPt2HemwidthRange");

		jQuery("#corPt2WaistRange_out").html('0');
		jQuery("#corPt2HipRange_out").html('0');
		jQuery("#corPt2ThighRange_out").html('0');
		jQuery("#corPt2HemwidthRange_out").html('0');
	}
	var subItemCode = "07";
	pants2Figure = jQuery("#selectPants2Figure").val();
	pants2Number = jQuery("#selectPants2Number").val();
	if(isNotEmpty(pants2Figure)&&isNotEmpty(pants2Number)){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":pt2Model,"figure":pants2Figure,"number":pants2Number},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "05"){
						jQuery("#corPt2Hip_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPt2Hip_div_Size").val(data[i].typeSize);
	            		jQuery("#corPt2Hip_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "06"){
						jQuery("#corPt2Waist_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPt2Waist_div_Size").val(data[i].typeSize);
	            		jQuery("#corPt2Waist_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "07"){
						if(opTack=="0000102"){
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize1Outtack + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize1Outtack);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize1Outtack);
						}else if(opTack=="0000104"){
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize2Outtack + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize2Outtack);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize2Outtack);
						}else if(opTack=="0000103"){
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize2Outtack + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize2Outtack);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize2Outtack);
						}else if(opTack=="0000101"){
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize2Outtack + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize2Outtack);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize2Outtack);
						}else if(opTack=="0000105"){
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize2Outtack + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize2Outtack);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize2Outtack);
						}else{
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize);
						}
					}else if(data[i].adjustClass == "08"){
						jQuery("#corPt2Hemwidth_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPt2Hemwidth_div_Size").val(data[i].typeSize);
	            		jQuery("#corPt2Hemwidth_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "09"){
	            		jQuery("#corPt2Rightinseam_div_Size").val(data[i].typeSize);
					}else if(data[i].adjustClass == "10"){						
	            		jQuery("#corPt2Leftinseam_div_Size").val(data[i].typeSize);	            		
					}
		        }
		    }
		})
	}else{
		for (pants2 of pants2AdjustList) {
			jQuery("#"+pants2.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+pants2.id+"_Size").val("0");
    		jQuery("#"+pants2.id+"_Gross").val("0");
		}
	}	
}

function adjustReInit(){
	
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

	jQuery("#corPt2Hip_div_Size").val("");
	jQuery("#corPt2Hip_div_Gross").val("");
	jQuery("#corPt2Hip_div_html").html("000.0cm");
	jQuery("#corPt2HipRange_out").html("0");
	jQuery("#corPt2HipRange").val("0");
	setFont("corPt2HipRange");
	
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

	jQuery("#corPtHemwidthGross").val("");
	jQuery("#ap_hemWidthAbs10").val("0");
	jQuery("#ap_hemWidthAbs1").val("0");
	jQuery("#ap_hemWidthAbsM1").val("0");
} 
function adjustSession(){


	jQuery("#selectPants2Figure").val("${orderForm.adjustPants2StandardInfo.sizeFigure}");
	jQuery("#selectPants2Number").val("${orderForm.adjustPants2StandardInfo.sizeNumber}");
	
	//2PT　型サイズ値、補正値とグロス値を設定
	jQuery("#corPt2Waist_div_Size").val("${orderForm.adjustPants2StandardInfo.corPt2WaistSize}");
	jQuery("#corPt2Waist_div_Gross").val("${orderForm.adjustPants2StandardInfo.corPt2WaistGross}");
	jQuery("#corPt2Waist_div_html").html("${orderForm.adjustPants2StandardInfo.corPt2WaistGross}"+".cm");
	if("${orderForm.adjustPants2StandardInfo.corPt2WaistGross}"==""){
		jQuery("#corPt2Waist_div_html").html("000.0cm");
		}
	jQuery("#corPt2WaistRange_out").html("${orderForm.adjustPants2StandardInfo.corPt2WaistCorrect}");
	jQuery("#corPt2WaistRange").val("${orderForm.adjustPants2StandardInfo.corPt2WaistCorrect}");
	setFont("corPt2WaistRange");

	jQuery("#corPt2Hip_div_Size").val("${orderForm.adjustPants2StandardInfo.corPt2HipSize}");
	jQuery("#corPt2Hip_div_Gross").val("${orderForm.adjustPants2StandardInfo.corPt2HipGross}");
	jQuery("#corPt2Hip_div_html").html("${orderForm.adjustPants2StandardInfo.corPt2HipGross}"+".cm");
	if("${orderForm.adjustPants2StandardInfo.corPt2HipGross}"==""){
		jQuery("#corPt2Hip_div_html").html("000.0cm");
		}
	jQuery("#corPt2HipRange_out").html("${orderForm.adjustPants2StandardInfo.corPt2HipCorrect}");
	jQuery("#corPt2HipRange").val("${orderForm.adjustPants2StandardInfo.corPt2HipCorrect}");
	setFont("corPt2HipRange");
	
	jQuery("#corPt2Thigh_div_Size").val("${orderForm.adjustPants2StandardInfo.corPt2ThighSize}");
	jQuery("#corPt2Thigh_div_Gross").val("${orderForm.adjustPants2StandardInfo.corPt2ThighGross}");
	jQuery("#corPt2Thigh_div_html").html("${orderForm.adjustPants2StandardInfo.corPt2ThighGross}"+".cm");
	if("${orderForm.adjustPants2StandardInfo.corPt2ThighGross}"==""){
		jQuery("#corPt2Thigh_div_html").html("000.0cm");
		}
	jQuery("#corPt2ThighRange_out").html("${orderForm.adjustPants2StandardInfo.corPt2ThighCorrect}");
	jQuery("#corPt2ThighRange").val("${orderForm.adjustPants2StandardInfo.corPt2ThighCorrect}");
	setFont("corPt2ThighRange");

	jQuery("#corPt2Hemwidth_div_Size").val("${orderForm.adjustPants2StandardInfo.corPt2HemwidthSize}");
	jQuery("#corPt2Hemwidth_div_Gross").val("${orderForm.adjustPants2StandardInfo.corPt2HemwidthGross}");
	jQuery("#corPt2Hemwidth_div_html").html("${orderForm.adjustPants2StandardInfo.corPt2HemwidthGross}"+".cm");
	if("${orderForm.adjustPants2StandardInfo.corPt2HemwidthGross}"==""){
		jQuery("#corPt2Hemwidth_div_html").html("000.0cm");
		}
	jQuery("#corPt2HemwidthRange_out").html("${orderForm.adjustPants2StandardInfo.corPt2HemwidthCorrect}");
	jQuery("#corPt2HemwidthRange").val("${orderForm.adjustPants2StandardInfo.corPt2HemwidthCorrect}");
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
	var corPt2HemwidthTypeValue="${orderForm.adjustPants2StandardInfo.corPt2HemwidthType}";
	if(corPt2HemwidthTypeValue=="1"){
		jQuery("#pt2_hemWidth_relative").prop("checked", true);
		jQuery("#corPt2Hemwidth_div_Size").val("${orderForm.adjustPants2StandardInfo.corPt2HemwidthSize}");
		jQuery("#corPt2Hemwidth_div_Gross").val("${orderForm.adjustPants2StandardInfo.corPt2HemwidthGross}");
		jQuery("#corPt2Hemwidth_div_html").html("${orderForm.adjustPants2StandardInfo.corPt2HemwidthGross}"+".cm");
		if("${orderForm.adjustPants2StandardInfo.corPt2HemwidthGross}"==""){
			jQuery("#corPt2Hemwidth_div_html").html("000.0cm");
			}
		jQuery("#corPt2HemwidthRange_out").html("${orderForm.adjustPants2StandardInfo.corPt2HemwidthCorrect}");
		jQuery("#corPt2HemwidthRange").val("${orderForm.adjustPants2StandardInfo.corPt2HemwidthCorrect}");
		setFont("corPt2HemwidthRange");
	 }else if(corPt2HemwidthTypeValue=="2"){
		 jQuery("#pt2_hemWidth_absolute").prop("checked", true);
		 var corPt2HemwidthSize = "${orderForm.adjustPants2StandardInfo.corPt2HemwidthSize}";
			jQuery("#corPt2Hemwidth_div_Size").val(corPt2HemwidthSize);
			var corPt2HemwidthGross = "${orderForm.adjustPants2StandardInfo.corPt2HemwidthGross}";
			jQuery("#corPt2Hemwidth_div_Gross").val(corPt2HemwidthGross);
			corPt2HemwidthGross = corPt2HemwidthGross.split(".");
			if(isNotEmpty(corPt2HemwidthGross[1])){
				jQuery("#ap2_hemWidthAbsM1").val(corPt2HemwidthGross[1]);
			}
			var str = corPt2HemwidthGross[0];
			if(str.length == 2){
				str = str.split("");
				var left1 = str[1];
				var left10 = str[0];
				jQuery("#ap2_hemWidthAbs10").val(left10);
				jQuery("#ap2_hemWidthAbs1").val(left1);
			}else if(str.length == 1){
				str = str.split("");
				var left1 = str[0];
				jQuery("#ap2_hemWidthAbs10").val(left10);
				jQuery("#ap2_hemWidthAbs1").val(left1);
			}


    }
	jQuery("#corPt2StoreCorrectionMemo").val("${orderForm.adjustPants2StandardInfo.corPt2StoreCorrectionMemo}");
	
} 

</script>