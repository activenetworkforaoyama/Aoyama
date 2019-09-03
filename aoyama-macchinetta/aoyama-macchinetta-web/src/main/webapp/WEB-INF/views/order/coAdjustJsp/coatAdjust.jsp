<form:form id="idAdjustForm"
	action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm"
	method="post" modelAttribute="orderForm" class="form-horizontal">
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
								path="adjustCoatStandardInfo.corCtSize"
								class="form-control-sm form-control hidedown">
								<form:options
									items="${orderForm.adjustCoatStandardInfo.corCtSizeMap}" />
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
                                <input type="range" id="corCtBodylengthRange" name="adjustCoatStandardInfo.corCtBodylengthCorrect" value="0" min="" max="" step="0.5">&nbsp;
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
                                <input type="range" id="corCtWaistRange" name="adjustCoatStandardInfo.corCtWaistCorrect" value="0" min="" max="" step="0.5">&nbsp;
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
                                <input type="range" id="corCtRightsleeveRange" name="adjustCoatStandardInfo.corCtRightsleeveCorrect" value="0" min="" max="" step="0.5">&nbsp;
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
                                <input type="range" id="corCtLeftsleeveRange" name="adjustCoatStandardInfo.corCtLeftsleeveCorrect" value="0" min="" max="" step="0.5">&nbsp;
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
                                <input type="range" id="corCtVenthightRange" name="adjustCoatStandardInfo.corCtVenthightCorrect" value="0" min="" max="" step="0.5">&nbsp;
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
                                <input type="range" id="corCtPktposRange" name="adjustCoatStandardInfo.corCtPktposCorrect" value="0" min="" max="" step="0.5">&nbsp;
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
                                <textarea name="adjustCoatStandardInfo.corCtStoreCorrectionMemo" id="corCtStoreCorrectionMemo" rows="3" placeholder="再補正コメント" class="form-control"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
		<!-- COAT -->
   <input type="hidden" id="corCtBodylength_div_Size"
		name="adjustCoatStandardInfo.corCtBodylengthSize" value="" />
	<input type="hidden" id="corCtBodylength_div_Gross"
		name="adjustCoatStandardInfo.corCtBodylengthGross" value="" />
		
	<input type="hidden" id="corCtWaist_div_Size"
		name="adjustCoatStandardInfo.corCtWaistSize" value="" />
	<input type="hidden" id="corCtWaist_div_Gross"
		name="adjustCoatStandardInfo.corCtWaistGross" value="" />
		
	<input type="hidden" id="corCtRightsleeve_div_Size"
		name="adjustCoatStandardInfo.corCtRightsleeveSize" value="" />
	<input type="hidden" id="corCtRightsleeve_div_Gross"
		name="adjustCoatStandardInfo.corCtRightsleeveGross" value="" />
			
	<input type="hidden" id="corCtLeftsleeve_div_Size"
		name="adjustCoatStandardInfo.corCtLeftsleeveSize" value="" />
	<input type="hidden" id="corCtLeftsleeve_div_Gross"
		name="adjustCoatStandardInfo.corCtLeftsleeveGross" value="" />
		
	<input type="hidden" id="corCtVenthight_div_Size"
		name="adjustCoatStandardInfo.corCtVenthightSize" value="" />
	<input type="hidden" id="corCtVenthight_div_Gross"
		name="adjustCoatStandardInfo.corCtVenthightGross" value="" />
		
	<input type="hidden" id="corCtPktpos_div_Size"
		name="adjustCoatStandardInfo.corCtPktposSize" value="" />
	<input type="hidden" id="corCtPktpos_div_Gross"
		name="adjustCoatStandardInfo.corCtPktposGross" value="" />
	
	<input type="hidden" id="coatAdFlag" name="coatAdFlag" value="1" />
</form:form>
<script
	src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var orderPattern = "CO";
var itemCode ="${orderForm.productItem}";
var coatAdFlag="${orderForm.coatAdFlag}";
var coatModel = "${orderForm.optionCoatStandardInfo.coatModel}";
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
    //getFigureAndNumberByItem();
    initAlter();
    /* if(itemFlag=="1"){
		 adjustReInit();
	 }else if(coatFlag=="0"&&coatModel==""){

	 }else if(coatFlag=="1"){
		 getFigureAndNumberByItem();
	 }else if(coatFlag=="0"&&coatModel!=""){
		 getFigureAndNumberByItem();
		 adjustSession();
	 } */
    if(coatAdFlag==""){
		
	}else if(coatAdFlag=="0"){
		adjustReInit();
		getFigureAndNumberByItem();
	}else if(coatAdFlag=="1"){
		getFigureAndNumberByItem();
		adjustSession();
	}
jQuery("#selectCorCtSize").change(function(){
    	coatAdjust();
   })   
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
	jQuery("#corStNeckRange_out").html("0");
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

	jQuery("#selectCorCtSize").val("${orderForm.adjustCoatStandardInfo.corCtSize}");

	
	jQuery("#corCtBodylength_div_Size").val("${orderForm.adjustCoatStandardInfo.corCtBodylengthSize}");
	jQuery("#corCtBodylength_div_Gross").val("${orderForm.adjustCoatStandardInfo.corCtBodylengthGross}");
	jQuery("#corCtBodylength_div_html").html("${orderForm.adjustCoatStandardInfo.corCtBodylengthGross}"+".cm");
	if("${orderForm.adjustCoatStandardInfo.corCtBodylengthGross}"==""){
		jQuery("#corCtBodylength_div_html").html("000.0cm");
		}
	jQuery("#corCtBodylengthRange_out").html("${orderForm.adjustCoatStandardInfo.corCtBodylengthCorrect}");
	jQuery("#corCtBodylengthRange").val("${orderForm.adjustCoatStandardInfo.corCtBodylengthCorrect}");
	setFont("corCtBodylengthRange");

	jQuery("#corCtWaist_div_Size").val("${orderForm.adjustCoatStandardInfo.corCtWaistSize}");
	jQuery("#corCtWaist_div_Gross").val("${orderForm.adjustCoatStandardInfo.corCtWaistGross}");
	jQuery("#corCtWaist_div_html").html("${orderForm.adjustCoatStandardInfo.corCtWaistGross}"+".cm");
	if("${orderForm.adjustCoatStandardInfo.corCtWaistGross}"==""){
		jQuery("#corCtWaist_div_html").html("000.0cm");
		}
	jQuery("#corStNeckRange_out").html("${orderForm.adjustCoatStandardInfo.corCtWaistCorrect}");
	jQuery("#corCtWaistRange").val("${orderForm.adjustCoatStandardInfo.corCtWaistCorrect}");
	setFont("corCtWaistRange");

	jQuery("#corCtRightsleeve_div_Size").val("${orderForm.adjustCoatStandardInfo.corCtRightsleeveSize}");
	jQuery("#corCtRightsleeve_div_Gross").val("${orderForm.adjustCoatStandardInfo.corCtRightsleeveGross}");
	jQuery("#corCtRightsleeve_div_html").html("${orderForm.adjustCoatStandardInfo.corCtRightsleeveGross}"+".cm");
	if("${orderForm.adjustCoatStandardInfo.corCtRightsleeveGross}"==""){
		jQuery("#corCtRightsleeve_div_html").html("000.0cm");
		}
	jQuery("#corCtRightsleeveRange_out").html("${orderForm.adjustCoatStandardInfo.corCtRightsleeveCorrect}");
	jQuery("#corCtRightsleeveRange").val("${orderForm.adjustCoatStandardInfo.corCtRightsleeveCorrect}");
	setFont("corCtRightsleeveRange");

	jQuery("#corCtLeftsleeve_div_Size").val("${orderForm.adjustCoatStandardInfo.corCtLeftsleeveSize}");
	jQuery("#corCtLeftsleeve_div_Gross").val("${orderForm.adjustCoatStandardInfo.corCtLeftsleeveGross}");
	jQuery("#corCtLeftsleeve_div_html").html("${orderForm.adjustCoatStandardInfo.corCtLeftsleeveGross}"+".cm");
	if("${orderForm.adjustCoatStandardInfo.corCtLeftsleeveGross}"==""){
		jQuery("#corCtLeftsleeve_div_html").html("000.0cm");
		}
	jQuery("#corCtLeftsleeveRange_out").html("${orderForm.adjustCoatStandardInfo.corCtLeftsleeveCorrect}");
	jQuery("#corCtLeftsleeveRange").val("${orderForm.adjustCoatStandardInfo.corCtLeftsleeveCorrect}");
	setFont("corCtLeftsleeveRange");

	jQuery("#corCtVenthight_div_Size").val("${orderForm.adjustCoatStandardInfo.corCtVenthightSize}");
	jQuery("#corCtVenthight_div_Gross").val("${orderForm.adjustCoatStandardInfo.corCtVenthightGross}");
	jQuery("#corCtVenthight_div_html").html("${orderForm.adjustCoatStandardInfo.corCtVenthightGross}"+".cm");
	if("${orderForm.adjustCoatStandardInfo.corCtVenthightGross}"==""){
		jQuery("#corCtVenthight_div_html").html("000.0cm");
		}
	jQuery("#corCtVenthightRange_out").html("${orderForm.adjustCoatStandardInfo.corCtVenthightCorrect}");
	jQuery("#corCtVenthightRange").val("${orderForm.adjustCoatStandardInfo.corCtVenthightCorrect}");
	setFont("corCtVenthightRange");

	jQuery("#corCtPktpos_div_Size").val("${orderForm.adjustCoatStandardInfo.corCtPktposSize}");
	jQuery("#corCtPktpos_div_Gross").val("${orderForm.adjustCoatStandardInfo.corCtPktposGross}");
	jQuery("#corCtPktpos_div_html").html("${orderForm.adjustCoatStandardInfo.corCtPktposGross}"+".cm");
	if("${orderForm.adjustCoatStandardInfo.corCtPktposGross}"==""){
		jQuery("#corCtPktpos_div_html").html("000.0cm");
		}
	jQuery("#corCtPktposRange_out").html("${orderForm.adjustCoatStandardInfo.corCtPktposCorrect}");
	jQuery("#corCtPktposRange").val("${orderForm.adjustCoatStandardInfo.corCtPktposCorrect}");
	setFont("corCtPktposRange");
	jQuery("#corCtStoreCorrectionMemo").val("${orderForm.adjustCoatStandardInfo.corCtStoreCorrectionMemo}");
	
	
} 

</script>