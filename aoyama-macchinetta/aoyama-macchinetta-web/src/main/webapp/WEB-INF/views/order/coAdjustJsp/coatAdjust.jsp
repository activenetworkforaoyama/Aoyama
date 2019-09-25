<form:form id="idAdjustForm"
	action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm"
	method="post" modelAttribute="orderCoForm" class="form-horizontal">
	<div id="al_coat_div">
		<div class="card-header">
			<strong class="card-title">COAT</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">COATサイズ</label>
						</div>
						<div class="col-12 col-md-3">
							<form:select id="selectCorCtSize"
								path="coAdjustCoatStandardInfo.corCtSize"
								class="form-control-sm form-control hidedown">
								<form:options
									items="${orderCoForm.coAdjustCoatStandardInfo.corCtSizeMap}" />
							</form:select>							
						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">COAT補正</label>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corCtBodylengthRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corCtBodylengthRange" name="coAdjustCoatStandardInfo.corCtBodylengthCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corCtBodylengthRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corCtBodylengthRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corCtBodylength_div">
							<output id="corCtBodylength_div_html">000.0cm</output>

						</div>
						<div class="col-12 col-md-9 offset-md-3" id="ac_kitake_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>					
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corCtWaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corCtWaistRange" name="coAdjustCoatStandardInfo.corCtWaistCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corCtWaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corCtWaistRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corCtWaist_div">
							<output id="corCtWaist_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="ac_weist_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈右修正</label>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corCtRightsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corCtRightsleeveRange" name="coAdjustCoatStandardInfo.corCtRightsleeveCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corCtRightsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corCtRightsleeveRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corCtRightsleeve_div">
							<output id="corCtRightsleeve_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="ac_sleeveRight_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈左修正</label>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corCtLeftsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corCtLeftsleeveRange" name="coAdjustCoatStandardInfo.corCtLeftsleeveCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corCtLeftsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corCtLeftsleeveRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corCtLeftsleeve_div">
							<output id="corCtLeftsleeve_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="ac_sleeveLeft_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ベント修正（高さ）</label>
							<button type="button" class="btn btn-link btn-sm"
								data-toggle="modal" data-target="#infotext_vents">
								<i class="fa fa-question-circle text-danger"></i>
							</button>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corCtVenthightRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corCtVenthightRange" name="coAdjustCoatStandardInfo.corCtVenthightCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corCtVenthightRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corCtVenthightRange_out">0</output>cm
                                </div>
						</div>

						<div class="col-12 col-md-2" id="corCtVenthight_div"
							style="display: none">
							<output id="corCtVenthight_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="ac_vents_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ポケット位置</label>
							<button type="button" class="btn btn-link btn-sm"
								data-toggle="modal" data-target="#infotext_pocketPos">
								<i class="fa fa-question-circle text-danger"></i>
							</button>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corCtPktposRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corCtPktposRange" name="coAdjustCoatStandardInfo.corCtPktposCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corCtPktposRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corCtPktposRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corCtPktpos_div"
							style="display: none">
							<output id="corCtPktpos_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="ac_pocketPos_alert"></div>
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
                                <form:textarea path="coAdjustCoatStandardInfo.corCtStoreCorrectionMemo" id="corCtStoreCorrectionMemo" rows="3" placeholder="再補正コメント" class="form-control"></form:textarea>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
		<!-- COAT -->
   <input type="hidden" id="corCtBodylength_div_Size"
		name="coAdjustCoatStandardInfo.corCtBodylengthSize" value="" />
	<input type="hidden" id="corCtBodylength_div_Gross"
		name="coAdjustCoatStandardInfo.corCtBodylengthGross" value="" />
		
	<input type="hidden" id="corCtWaist_div_Size"
		name="coAdjustCoatStandardInfo.corCtWaistSize" value="" />
	<input type="hidden" id="corCtWaist_div_Gross"
		name="coAdjustCoatStandardInfo.corCtWaistGross" value="" />
		
	<input type="hidden" id="corCtRightsleeve_div_Size"
		name="coAdjustCoatStandardInfo.corCtRightsleeveSize" value="" />
	<input type="hidden" id="corCtRightsleeve_div_Gross"
		name="coAdjustCoatStandardInfo.corCtRightsleeveGross" value="" />
			
	<input type="hidden" id="corCtLeftsleeve_div_Size"
		name="coAdjustCoatStandardInfo.corCtLeftsleeveSize" value="" />
	<input type="hidden" id="corCtLeftsleeve_div_Gross"
		name="coAdjustCoatStandardInfo.corCtLeftsleeveGross" value="" />
		
	<input type="hidden" id="corCtVenthight_div_Size"
		name="coAdjustCoatStandardInfo.corCtVenthightSize" value="" />
	<input type="hidden" id="corCtVenthight_div_Gross"
		name="coAdjustCoatStandardInfo.corCtVenthightGross" value="" />
		
	<input type="hidden" id="corCtPktpos_div_Size"
		name="coAdjustCoatStandardInfo.corCtPktposSize" value="" />
	<input type="hidden" id="corCtPktpos_div_Gross"
		name="coAdjustCoatStandardInfo.corCtPktposGross" value="" />
	
	<input type="hidden" id="coatAdFlag" name="coatAdFlag" value="1" />
	<input type="hidden" id="jacketAdFlag" name="jacketAdFlag" value="${orderCoForm.jacketAdFlag }" />
    <input type="hidden" id="giletAdFlag" name="giletAdFlag" value="${orderCoForm.giletAdFlag }" />
    <input type="hidden" id="pantsAdFlag" name="pantsAdFlag" value="${orderCoForm.pantsAdFlag }" />
    <input type="hidden" id="pants2AdFlag" name="pants2AdFlag" value="${orderCoForm.pants2AdFlag }" />
    <input type="hidden" id="shirtAdFlag" name="shirtAdFlag" value="${orderCoForm.shirtAdFlag }" />
</form:form>
<script
	src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var orderPattern = "CO";
var itemCode ="${orderCoForm.productItem}";
var coatAdFlag="${orderCoForm.coatAdFlag}";
var coatModel = "${orderCoForm.coOptionCoatStandardInfo.coatModel}";
var coatAdjustList = [
	{type:"01",id:"corCtBodylength_div"},
	{type:"02",id:"corCtWaist_div"},
	{type:"03",id:"corCtLeftsleeve_div"},
	{type:"04",id:"corCtRightsleeve_div"},
	{type:"17",id:"corCtVenthight_div"},
	{type:"18",id:"corCtPktpos_div"}
];
jQuery(document).ready(function() {
	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });
	getAdjustByItem();
    initAlter();
    var orderFlag = "${orderCoForm.orderFlag}";
    if(orderFlag == "orderCo"){
    	if(coatAdFlag==""){
        	
    	}else if(coatAdFlag=="0"){
    		adjustReInit();
    		getFigureAndNumberByItem();
    	}else if(coatAdFlag=="1"){
    		getFigureAndNumberByItem();
    		adjustSession();
    	}
    }
   if(orderFlag == "orderLink"||orderFlag == "orderCheck"||orderFlag == "orderBack"){
		if(coatAdFlag=="0"){
			adjustReInit();
    		getFigureAndNumberByItem();
    	}else if(coatAdFlag=="1"){
    		getFigureAndNumberByItem();
    		adjustSession();
    	}else if(coatAdFlag==""){
    		getFigureAndNumberByItem();
    		adjustSession();
    	}
    }
    
    
jQuery("#selectCorCtSize").change(function(){
    	coatAdjust();
   })  
   jQuery("#coatAdFlag").val("1"); 
});
function getAdjustByItem(){
	var subItemCode = "";
	if(itemCode == "06"){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getAdjustByItem",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	        	   if(e.subItemCode == "06"){
		        	   if(e.adjusteClass == "01"){
							document.getElementById("corCtBodylengthRange").max = e.adjusteMax;
							document.getElementById("corCtBodylengthRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "03"){
							document.getElementById("corCtRightsleeveRange").max = e.adjusteMax;
							document.getElementById("corCtRightsleeveRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "04"){
							document.getElementById("corCtLeftsleeveRange").max = e.adjusteMax;
							document.getElementById("corCtLeftsleeveRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "02"){
							document.getElementById("corCtWaistRange").max = e.adjusteMax;
							document.getElementById("corCtWaistRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "17"){
							document.getElementById("corCtVenthightRange").max = e.adjusteMax;
							document.getElementById("corCtVenthightRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "18"){
							document.getElementById("corCtPktposRange").max = e.adjusteMax;
							document.getElementById("corCtPktposRange").min = e.adjusteMin;
						} 
			       }
	           });
	        }
	    });
	}
}
function getFigureAndNumberByItem(){
	var subItemCode = "";
	if(itemCode == "06"){
		subItemCode = itemCode;
		var selectCorCtSize = document.getElementById("selectCorCtSize");
		getSizeNumber(itemCode,subItemCode,coatModel,selectCorCtSize);
			}
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
function coatAdjust(){
	if(coatModel==""||coatModel==null){
		
	}else{
		jQuery("#corCtBodylengthRange").val(0);
		setFont("corCtBodylengthRange");
		jQuery("#corCtWaistRange").val(0);
		setFont("corCtWaistRange");
		jQuery("#corCtRightsleeveRange").val(0);
		setFont("corCtRightsleeveRange");
		jQuery("#corCtLeftsleeveRange").val(0);
		setFont("corCtLeftsleeveRange");
		jQuery("#corCtVenthightRange").val(0);
		setFont("corCtVenthightRange");
		jQuery("#corCtPktposRange").val(0);
		setFont("corCtPktposRange");
		
		jQuery("#corCtBodylengthRange_out").html('0');
		jQuery("#corCtWaistRange_out").html('0');
		jQuery("#corCtRightsleeveRange_out").html('0');
		jQuery("#corCtLeftsleeveRange_out").html('0');
		jQuery("#corCtVenthightRange_out").html('0');
		jQuery("#corCtPktposRange_out").html('0');
	}
	var subItemCode = "06";
	corCtFigure = "";
	corCtNumber = jQuery("#selectCorCtSize").val();
	if(isNotEmpty(corCtNumber)){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":coatModel,"figure":corCtFigure,"number":corCtNumber},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "01"){
						jQuery("#corCtBodylength_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corCtBodylength_div_Size").val(data[i].typeSize);
	            		jQuery("#corCtBodylength_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "02"){
						jQuery("#corCtWaist_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corCtWaist_div_Size").val(data[i].typeSize);
	            		jQuery("#corCtWaist_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "03"){
						jQuery("#corCtLeftsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corCtLeftsleeve_div_Size").val(data[i].typeSize);
	            		jQuery("#corCtLeftsleeve_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "04"){
						jQuery("#corCtRightsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corCtRightsleeve_div_Size").val(data[i].typeSize);
	            		jQuery("#corCtRightsleeve_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "17"){
						jQuery("#corCtVenthight_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corCtVenthight_div_Size").val(data[i].typeSize);
	            		jQuery("#corCtVenthight_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "18"){
						jQuery("#corCtPktpos_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corCtPktpos_div_Size").val(data[i].typeSize);
	            		jQuery("#corCtPktpos_div_Gross").val(data[i].typeSize);
					}
		        }
		    }
		})
	}else{
		for (coat of coatAdjustList) {
			jQuery("#"+coat.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+coat.id+"_Size").val("0");
    		jQuery("#"+coat.id+"_Gross").val("0");
		}
	}	
}
function adjustReInit(){
	
	// COAT
	var corCtSize = document.getElementById("selectCorCtSize");
	corCtSize.options.length=0;
	corCtSize.add(new Option("選択　　　",""));

	jQuery("#corCtBodylength_div_Size").val("");
	jQuery("#corCtBodylength_div_Gross").val("");
	jQuery("#corCtBodylength_div_html").html("000.0cm");
	jQuery("#corCtBodylengthRange_out").html("0");
	jQuery("#corCtBodylengthRange").val("0");
	setFont("corCtBodylengthRange");

	jQuery("#corCtWaist_div_Size").val("");
	jQuery("#corCtWaist_div_Gross").val("");
	jQuery("#corCtWaist_div_html").html("000.0cm");
	jQuery("#corCtWaistRange_out").html("0");
	jQuery("#corCtWaistRange").val("0");
	setFont("corCtWaistRange");

	jQuery("#corCtRightsleeve_div_Size").val("");
	jQuery("#corCtRightsleeve_div_Gross").val("");
	jQuery("#corCtRightsleeve_div_html").html("000.0cm");
	jQuery("#corRightsleeveRange_out").html("0");
	jQuery("#corCtRightsleeveRange").val("0");
	setFont("corCtRightsleeveRange");

	jQuery("#corCtLeftsleeve_div_Size").val("");
	jQuery("#corCtLeftsleeve_div_Gross").val("");
	jQuery("#corCtLeftsleeve_div_html").html("000.0cm");
	jQuery("#corCtLeftsleeve_out").html("0");
	jQuery("#corCtLeftsleeveRange").val("0");
	setFont("corCtLeftsleeveRange");

	jQuery("#corCtVenthight_div_Size").val("");
	jQuery("#corCtVenthight_div_Gross").val("");
	jQuery("#corCtVenthight_div_html").html("000.0cm");
	jQuery("#corCtVenthightRange_out").html("0");
	jQuery("#corCtVenthightRange").val("0");
	setFont("corCtVenthightRange");

	jQuery("#corCtPktpos_div_Size").val("");
	jQuery("#corCtPktpos_div_Gross").val("");
	jQuery("#corCtPktpos_div_html").html("000.0cm");
	jQuery("#corCtPktposRange_out").html("0");
	jQuery("#corCtPktposRange").val("0");
	setFont("corCtPktposRange");
	
} 
function adjustSession(){

	jQuery("#selectCorCtSize").val("${orderCoForm.coAdjustCoatStandardInfo.corCtSize}");

	
	jQuery("#corCtBodylength_div_Size").val("${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthSize}");
	jQuery("#corCtBodylength_div_Gross").val("${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthGross}");
	jQuery("#corCtBodylength_div_html").html("${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthGross}"+".cm");
	if("${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthGross}"==""){
		jQuery("#corCtBodylength_div_html").html("000.0cm");
		}
	jQuery("#corCtBodylengthRange_out").html("${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthCorrect}");
	jQuery("#corCtBodylengthRange").val("${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthCorrect}");
	setFont("corCtBodylengthRange");

	jQuery("#corCtWaist_div_Size").val("${orderCoForm.coAdjustCoatStandardInfo.corCtWaistSize}");
	jQuery("#corCtWaist_div_Gross").val("${orderCoForm.coAdjustCoatStandardInfo.corCtWaistGross}");
	jQuery("#corCtWaist_div_html").html("${orderCoForm.coAdjustCoatStandardInfo.corCtWaistGross}"+".cm");
	if("${orderCoForm.coAdjustCoatStandardInfo.corCtWaistGross}"==""){
		jQuery("#corCtWaist_div_html").html("000.0cm");
		}
	jQuery("#corCtWaistRange_out").html("${orderCoForm.coAdjustCoatStandardInfo.corCtWaistCorrect}");
	jQuery("#corCtWaistRange").val("${orderCoForm.coAdjustCoatStandardInfo.corCtWaistCorrect}");
	setFont("corCtWaistRange");

	jQuery("#corCtRightsleeve_div_Size").val("${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveSize}");
	jQuery("#corCtRightsleeve_div_Gross").val("${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveGross}");
	jQuery("#corCtRightsleeve_div_html").html("${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveGross}"+".cm");
	if("${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveGross}"==""){
		jQuery("#corCtRightsleeve_div_html").html("000.0cm");
		}
	jQuery("#corCtRightsleeveRange_out").html("${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveCorrect}");
	jQuery("#corCtRightsleeveRange").val("${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveCorrect}");
	setFont("corCtRightsleeveRange");

	jQuery("#corCtLeftsleeve_div_Size").val("${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveSize}");
	jQuery("#corCtLeftsleeve_div_Gross").val("${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveGross}");
	jQuery("#corCtLeftsleeve_div_html").html("${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveGross}"+".cm");
	if("${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveGross}"==""){
		jQuery("#corCtLeftsleeve_div_html").html("000.0cm");
		}
	jQuery("#corCtLeftsleeveRange_out").html("${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveCorrect}");
	jQuery("#corCtLeftsleeveRange").val("${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveCorrect}");
	setFont("corCtLeftsleeveRange");

	jQuery("#corCtVenthight_div_Size").val("${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightSize}");
	jQuery("#corCtVenthight_div_Gross").val("${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightGross}");
	jQuery("#corCtVenthight_div_html").html("${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightGross}"+".cm");
	if("${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightGross}"==""){
		jQuery("#corCtVenthight_div_html").html("000.0cm");
		}
	jQuery("#corCtVenthightRange_out").html("${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightCorrect}");
	jQuery("#corCtVenthightRange").val("${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightCorrect}");
	setFont("corCtVenthightRange");

	jQuery("#corCtPktpos_div_Size").val("${orderCoForm.coAdjustCoatStandardInfo.corCtPktposSize}");
	jQuery("#corCtPktpos_div_Gross").val("${orderCoForm.coAdjustCoatStandardInfo.corCtPktposGross}");
	jQuery("#corCtPktpos_div_html").html("${orderCoForm.coAdjustCoatStandardInfo.corCtPktposGross}"+".cm");
	if("${orderCoForm.coAdjustCoatStandardInfo.corCtPktposGross}"==""){
		jQuery("#corCtPktpos_div_html").html("000.0cm");
		}
	jQuery("#corCtPktposRange_out").html("${orderCoForm.coAdjustCoatStandardInfo.corCtPktposCorrect}");
	jQuery("#corCtPktposRange").val("${orderCoForm.coAdjustCoatStandardInfo.corCtPktposCorrect}");
	setFont("corCtPktposRange");
// 	jQuery("#corCtStoreCorrectionMemo").val("${orderCoForm.coAdjustCoatStandardInfo.corCtStoreCorrectionMemo}");
	
	
} 

</script>