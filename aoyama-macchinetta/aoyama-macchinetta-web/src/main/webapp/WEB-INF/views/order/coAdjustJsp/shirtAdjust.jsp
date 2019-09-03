<form:form id="idAdjustForm"
	action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm"
	method="post" modelAttribute="orderForm" class="form-horizontal">

	<div id="al_shirt_div">
		<div class="card-header">
			<strong class="card-title">SHIRT</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">SHIRTサイズ</label>
						</div>
						<div class="col-12 col-md-3">
							<form:select id="selectCorStSize"
								path="adjustShirtStandardInfo.corStSize"
								class="form-control-sm form-control hidedown">
								<form:options
									items="${orderForm.adjustShirtStandardInfo.corStSizeMap}" />
							</form:select>				
						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">SHIRT補正</label>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ネック</label>
						</div>
						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStNeckRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStNeckRange" name="adjustShirtStandardInfo.corStNeckCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corStNeckRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStNeckRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStNeck_div">
							<output id="corStNeck_div_html">000.0cm</output>
							<!-- <output>000.0</output>cm -->
						</div>

						<div class="col-12 col-md-9 offset-md-3" id="as_neck_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStBodylengthRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStBodylengthRange" name="adjustShirtStandardInfo.corStBodylengthCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corStBodylengthRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStBodylengthRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStBodylength_div">
							<output id="corStBodylength_div_html">000.0cm</output>
						</div>						
						<div class="col-12 col-md-9 offset-md-3" id="as_kitake_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈右修正</label>
						</div>
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStRightsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStRightsleeveRange" name="adjustShirtStandardInfo.corStRightsleeveCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corStRightsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStRightsleeveRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStRightsleeve_div">
							<output id="corStRightsleeve_div_html">000.0cm</output>						
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="as_sleeveRight_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈左修正</label>
						</div>
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStLeftsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStLeftsleeveRange" name="adjustShirtStandardInfo.corStLeftsleeveCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corStLeftsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStLeftsleeveRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStLeftsleeve_div">
							<output id="corStLeftsleeve_div_html">000.0cm</output>
							<!-- <output>000.0</output>cm -->
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="as_sleeveLeft_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">背ダーツ詰め</label>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStBackdartsPackRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStBackdartsPackRange" name="adjustShirtStandardInfo.corStBackdartsPackCorrect" value="0" min="-5" max="0" step="0.5">&nbsp;
                                <a href="#" id="corStBackdartsPackRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStBackdartsPackRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStBackdartsPack_div"
							style="display: none">
							<output id="corStBackdartsPack_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3"
							id="as_backDartsCut_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">背ダーツ出し</label>
						</div>
						<div class="col-12 col-md-4">						
							<div class="form-check-inline form-check">
								<label for="backDartsPut_0" class="form-check-label "> <input
									type="radio" id="backDartsPut_0" name="adjustShirtStandardInfo.corStBackdartsUnpackCorrect" value="0"
									class="form-check-input">ダーツ無し
								</label> <label for="backDartsPut_2" class="form-check-label ">
									<input type="radio" id="backDartsPut_2" name="adjustShirtStandardInfo.corStBackdartsUnpackCorrect"
									value="2" class="form-check-input">プラス2cm
								</label>
							</div>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">カフス周り右</label>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStRightcuffsSurroundingRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStRightcuffsSurroundingRange" name="adjustShirtStandardInfo.corStRightcuffsSurroundingCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corStRightcuffsSurroundingRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStRightcuffsSurroundingRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStRightcuffsSurrounding_div"
							style="display: none">
							<output id="corStRightcuffsSurrounding_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3"
							id="as_cuffAroundRight_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">カフス周り左</label>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStLeftcuffsSurroundingRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStLeftcuffsSurroundingRange" name="adjustShirtStandardInfo.corStLeftcuffsSurroundingCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corStLeftcuffsSurroundingRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStLeftcuffsSurroundingRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStLeftcuffsSurrounding_div"
							style="display: none">
							<output id="corStLeftcuffsSurrounding_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3"
							id="as_cuffAroundLeft_alert"></div>					
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
                                <textarea name="corStoreCorrectionMemoAgain" id="corStoreCorrectionMemoAgain" rows="3" placeholder="再補正コメント" class="form-control"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
	 <!-- Shirt -->
   <input type="hidden" id="corStNeck_div_Size"
		name="adjustShirtStandardInfo.corStNeckSize" value="" />
	<input type="hidden" id="corStNeck_div_Gross"
		name="adjustShirtStandardInfo.corStNeckGross" value="" />
		
		<input type="hidden" id="corStBodylength_div_Size"
		name="adjustShirtStandardInfo.corStBodylengthSize" value="" />
	<input type="hidden" id="corStBodylength_div_Gross"
		name="adjustShirtStandardInfo.corStBodylengthGross" value="" />
		
		<input type="hidden" id="corStRightsleeve_div_Size"
		name="adjustShirtStandardInfo.corStRightsleeveSize" value="" />
	<input type="hidden" id="corStRightsleeve_div_Gross"
		name="adjustShirtStandardInfo.corStRightsleeveGross" value="" />
		
		<input type="hidden" id="corStLeftsleeve_div_Size"
		name="adjustShirtStandardInfo.corStLeftsleeveSize" value="" />
	<input type="hidden" id="corStLeftsleeve_div_Gross"
		name="adjustShirtStandardInfo.corStLeftsleeveGross" value="" />
		
		<input type="hidden" id="corStBackdartsPack_div_Size"
		name="adjustShirtStandardInfo.corStBackdartsPackSize" value="" />
	<input type="hidden" id="corStBackdartsPack_div_Gross"
		name="adjustShirtStandardInfo.corStBackdartsPackGross" value="" />
		
		<input type="hidden" id="corStRightcuffsSurrounding_div_Size"
		name="adjustShirtStandardInfo.corStRightcuffsSurroundingSize" value="" />
	<input type="hidden" id="corStRightcuffsSurrounding_div_Gross"
		name="adjustShirtStandardInfo.corStRightcuffsSurroundingGross" value="" />
		
		<input type="hidden" id="corStLeftcuffsSurrounding_div_Size"
		name="adjustShirtStandardInfo.corStLeftcuffsSurroundingSize" value="" />
	<input type="hidden" id="corStLeftcuffsSurrounding_div_Gross"
		name="adjustShirtStandardInfo.corStLeftcuffsSurroundingGross" value="" />
	<input type="hidden" id="shirtAdFlag" name="shirtAdFlag" value="1" />
</form:form>
<script
	src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var orderPattern = "CO";
var itemCode ="${orderForm.productItem}";
var shirtAdFlag="${orderForm.shirtAdFlag}";
var shirtModel = "${orderForm.optionShirtStandardInfo.osShirtModel}";
var shirtAdjustList = [
	{type:"01",id:"corStBodylength_div"},
	//{type:"02",id:"corStBackdartsPack_div"},
	{type:"03",id:"corStRightsleeve_div"},
	{type:"04",id:"corStLeftsleeve_div"},
	{type:"11",id:"corStNeck_div"},
	{type:"12",id:"corStRightcuffsSurrounding_div"},
	{type:"13",id:"corStLeftcuffsSurrounding_div"}
];
jQuery(document).ready(function() {

	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });
	getAdjustByItem();
   // getFigureAndNumberByItem();
    initAlter();
    /* if(itemFlag=="1"){
		 adjustReInit();
	 }else if(shirtFlag=="0"&&shirtModel==""){

	 }else if(shirtFlag=="1"){
		 getFigureAndNumberByItem();
	 }else if(shirtFlag=="0"&&shirtModel!=""){
		 getFigureAndNumberByItem();
		 adjustSession();
	 } */
    if(shirtAdFlag==""){
    	jQuery("#backDartsPut_0").prop("checked", true);	     
	}else if(shirtAdFlag=="0"){
		jQuery("#backDartsPut_0").prop("checked", true);
		adjustReInit();
		getFigureAndNumberByItem();
	}else if(shirtAdFlag=="1"){
		getFigureAndNumberByItem();
		adjustSession();
	}
    jQuery("#selectCorStSize").change(function(){
		shirtAdjust();
	})   
});

function getAdjustByItem(){
	var subItemCode = "";
	if(itemCode == "05"){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getAdjustByItem",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	        	   if(e.subItemCode == "05"){
	        		   if(e.adjusteClass == "11"){
							document.getElementById("corStNeckRange").max = e.adjusteMax;
							document.getElementById("corStNeckRange").min = e.adjusteMin;
						}
		        	   if(e.adjusteClass == "01"){
							document.getElementById("corStBodylengthRange").max = e.adjusteMax;
							document.getElementById("corStBodylengthRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "03"){
							document.getElementById("corStRightsleeveRange").max = e.adjusteMax;
							document.getElementById("corStRightsleeveRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "04"){
							document.getElementById("corStLeftsleeveRange").max = e.adjusteMax;
							document.getElementById("corStLeftsleeveRange").min = e.adjusteMin;
						}
					   /* if(e.adjusteClass == "02"){
							document.getElementById("corStBackdartsPackRange").max = e.adjusteMax;
							document.getElementById("corStBackdartsPackRange").min = e.adjusteMin;
						}  */
						if(e.adjusteClass == "12"){
							document.getElementById("corStRightcuffsSurroundingRange").max = e.adjusteMax;
							document.getElementById("corStRightcuffsSurroundingRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "13"){
							document.getElementById("corStLeftcuffsSurroundingRange").max = e.adjusteMax;
							document.getElementById("corStLeftcuffsSurroundingRange").min = e.adjusteMin;
						} 
			       }
	           });
	        }
	    });
	}
}
function getFigureAndNumberByItem(){
	var subItemCode = "";
	if(itemCode == "05"){
		subItemCode = itemCode;
		var selectCorStSize = document.getElementById("selectCorStSize");
		getSizeNumber(itemCode,subItemCode,shirtModel,selectCorStSize);
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
function shirtAdjust(){
	if(shirtModel==""||shirtModel==null){
		
	}else{
		jQuery("#corStNeckRange").val(0);
		setFont("corStNeckRange");
		jQuery("#corStBodylengthRange").val(0);
		setFont("corStBodylengthRange");
		jQuery("#corStRightsleeveRange").val(0);
		setFont("corStRightsleeveRange");
		jQuery("#corStLeftsleeveRange").val(0);
		setFont("corStLeftsleeveRange");
		jQuery("#corStBackdartsPackRange").val(0);
		setFont("corStBackdartsPackRange");
		jQuery("#corStRightcuffsSurroundingRange").val(0);
		setFont("corStRightcuffsSurroundingRange");
		jQuery("#corStLeftcuffsSurroundingRange").val(0);
		setFont("corStLeftcuffsSurroundingRange");
		

		jQuery("#corStNeckRange_out").html('0');
		jQuery("#corStBodylengthRange_out").html('0');
		jQuery("#corStRightsleeveRange_out").html('0');
		jQuery("#corStLeftsleeveRange_out").html('0');
		jQuery("#corStBackdartsPackRange_out").html('0');
		jQuery("#corStRightcuffsSurroundingRange_out").html('0');
		jQuery("#corStLeftcuffsSurroundingRange_out").html('0');
	}
	var subItemCode = "05";
	shirtFigure = "";
	shirtNumber = jQuery("#selectCorStSize").val();
	//ノータック:0000101  1アウトタック:0000102  2アウトタック:0000104
	if(isNotEmpty(shirtNumber)){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":shirtModel,"figure":shirtFigure,"number":shirtNumber},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "01"){
						jQuery("#corStBodylength_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStBodylength_div_Size").val(data[i].typeSize);
	            		jQuery("#corStBodylength_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "03"){
						jQuery("#corStRightsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStRightsleeve_div_Size").val(data[i].typeSize);
	            		jQuery("#corStRightsleeve_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "04"){
						jQuery("#corStLeftsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStLeftsleeve_div_Size").val(data[i].typeSize);
	            		jQuery("#corStLeftsleeve_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "11"){
						jQuery("#corStNeck_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStNeck_div_Size").val(data[i].typeSize);
	            		jQuery("#corStNeck_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "12"){
						jQuery("#corStRightcuffsSurrounding_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStRightcuffsSurrounding_div_Size").val(data[i].typeSize);
	            		jQuery("#corStRightcuffsSurrounding_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "13"){
						jQuery("#corStLeftcuffsSurrounding_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStLeftcuffsSurrounding_div_Size").val(data[i].typeSize);
	            		jQuery("#corStLeftcuffsSurrounding_div_Gross").val(data[i].typeSize);
					}
		        }
		    }
		})
	}else{
		for (shirt of shirtAdjustList) {
			jQuery("#"+shirt.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+shirt.id+"_Size").val("0");
    		jQuery("#"+shirt.id+"_Gross").val("0");
		}
	}}
	 function adjustReInit(){
			//SHIRT
			var corStSize = document.getElementById("selectCorStSize");
			corStSize.options.length=0;
			corStSize.add(new Option("選択　　　",""));

			jQuery("#corStNeck_div_Size").val("");
			jQuery("#corStNeck_div_Gross").val("");
			jQuery("#corStNeck_div_html").html("000.0cm");
			jQuery("#corStNeckRange_out").html("0");
			jQuery("#corStNeckRange").val("0");
			setFont("corStNeckRange");
			
			jQuery("#corStBodylength_div_Size").val("");
			jQuery("#corStBodylength_div_Gross").val("");
			jQuery("#corStBodylength_div_html").html("000.0cm");
			jQuery("#corStBodylength_out").html("0");
			jQuery("#corStBodylengthRange").val("0");
			setFont("corStBodylengthRange");

			jQuery("#corStRightsleeve_div_Size").val("");
			jQuery("#corStRightsleeve_div_Gross").val("");
			jQuery("#corStRightsleeve_div_html").html("000.0cm");
			jQuery("#corStRightsleeve_out").html("0");
			jQuery("#corStRightsleeveRange").val("0");
			setFont("corStRightsleeveRange");

			jQuery("#corStLeftsleeve_div_Size").val("");
			jQuery("#corStLeftsleeve_div_Gross").val("");
			jQuery("#corStLeftsleeve_div_html").html("000.0cm");
			jQuery("#corStLeftsleeveRange_out").html("0");
			jQuery("#corStLeftsleeveRange").val("0");
			setFont("corStLeftsleeveRange");

			jQuery("#corStBackdartsPack_div_Size").val("");
			jQuery("#corStBackdartsPack_div_Gross").val("");
			jQuery("#corStBackdartsPack_div_html").html("000.0cm");
			jQuery("#corStBackdartsPackRange_out").html("0");
			jQuery("#corStBackdartsPackRange").val("0");
			setFont("corStBackdartsPackRange");

			jQuery("#corStRightcuffsSurrounding_div_Size").val("");
			jQuery("#corStRightcuffsSurrounding_div_Gross").val("");
			jQuery("#corStRightcuffsSurrounding_div_html").html("000.0cm");
			jQuery("#corStRightcuffsSurroundingRange_out").html("0");
			jQuery("#corStRightcuffsSurroundingRange").val("0");
			setFont("corStRightcuffsSurroundingRange");

			jQuery("#corStLeftcuffsSurrounding_div_Size").val("");
			jQuery("#corStLeftcuffsSurrounding_div_Gross").val("");
			jQuery("#corStLeftcuffsSurrounding_div_html").html("000.0cm");
			jQuery("#corStLeftcuffsSurroundingRange_out").html("0");
			jQuery("#corStLeftcuffsSurroundingRange").val("0");
			setFont("corStLeftcuffsSurroundingRange");
		} 
	 function adjustSession(){

			jQuery("#selectCorStSize").val("${orderForm.adjustShirtStandardInfo.corStSize}");

			jQuery("#corStNeck_div_Size").val("${orderForm.adjustShirtStandardInfo.corStNeckSize}");
			jQuery("#corStNeck_div_Gross").val("${orderForm.adjustShirtStandardInfo.corStNeckGross}");
			jQuery("#corStNeck_div_html").html("${orderForm.adjustShirtStandardInfo.corStNeckGross}"+".cm");
			if("${orderForm.adjustShirtStandardInfo.corStNeckGross}"==""){
				jQuery("#corStNeck_div_html").html("000.0cm");
				}
			jQuery("#corStNeckRange_out").html("${orderForm.adjustShirtStandardInfo.corStNeckCorrect}");
			jQuery("#corStNeckRange").val("${orderForm.adjustShirtStandardInfo.corStNeckCorrect}");
			setFont("corStNeckRange");
			
			jQuery("#corStBodylength_div_Size").val("${orderForm.adjustShirtStandardInfo.corStBodylengthSize}");
			jQuery("#corStBodylength_div_Gross").val("${orderForm.adjustShirtStandardInfo.corStBodylengthGross}");
			jQuery("#corStBodylength_div_html").html("${orderForm.adjustShirtStandardInfo.corStBodylengthGross}"+".cm");
			if("${orderForm.adjustShirtStandardInfo.corStBodylengthGross}"==""){
				jQuery("#corStBodylength_div_html").html("000.0cm");
				}
			jQuery("#corStBodylength_out").html("${orderForm.adjustShirtStandardInfo.corStBodylengthCorrect}");
			jQuery("#corStBodylengthRange").val("${orderForm.adjustShirtStandardInfo.corStBodylengthCorrect}");
			setFont("corStBodylengthRange");

			jQuery("#corStRightsleeve_div_Size").val("${orderForm.adjustShirtStandardInfo.corStRightsleeveSize}");
			jQuery("#corStRightsleeve_div_Gross").val("${orderForm.adjustShirtStandardInfo.corStRightsleeveGross}");
			jQuery("#corStRightsleeve_div_html").html("${orderForm.adjustShirtStandardInfo.corStRightsleeveGross}"+".cm");
			if("${orderForm.adjustShirtStandardInfo.corStRightsleeveGross}"==""){
				jQuery("#corStRightsleeve_div_html").html("000.0cm");
				}
			jQuery("#corStRightsleeve_out").html("${orderForm.adjustShirtStandardInfo.corStRightsleeveCorrect}");
			jQuery("#corStRightsleeveRange").val("${orderForm.adjustShirtStandardInfo.corStRightsleeveCorrect}");
			setFont("corStRightsleeveRange");

			jQuery("#corStLeftsleeve_div_Size").val("${orderForm.adjustShirtStandardInfo.corStLeftsleeveSize}");
			jQuery("#corStLeftsleeve_div_Gross").val("${orderForm.adjustShirtStandardInfo.corStLeftsleeveGross}");
			jQuery("#corStLeftsleeve_div_html").html("${orderForm.adjustShirtStandardInfo.corStLeftsleeveGross}"+".cm");
			if("${orderForm.adjustShirtStandardInfo.corStLeftsleeveGross}"==""){
				jQuery("#corStLeftsleeve_div_html").html("000.0cm");
				}
			jQuery("#corStLeftsleeveRange_out").html("${orderForm.adjustShirtStandardInfo.corStLeftsleeveCorrect}");
			jQuery("#corStLeftsleeveRange").val("${orderForm.adjustShirtStandardInfo.corStLeftsleeveCorrect}");
			setFont("corStLeftsleeveRange");

			jQuery("#corStBackdartsPack_div_Size").val("${orderForm.adjustShirtStandardInfo.corStBackdartsPackSize}");
			jQuery("#corStBackdartsPack_div_Gross").val("${orderForm.adjustShirtStandardInfo.corStBackdartsPackGross}");
			jQuery("#corStBackdartsPack_div_html").html("${orderForm.adjustShirtStandardInfo.corStBackdartsPackGross}"+".cm");
			if("${orderForm.adjustShirtStandardInfo.corStBackdartsPackGross}"==""){
				jQuery("#corStBackdartsPack_div_html").html("000.0cm");
				}
			jQuery("#corStBackdartsPackRange_out").html("${orderForm.adjustShirtStandardInfo.corStBackdartsPackCorrect}");
			jQuery("#corStBackdartsPackRange").val("${orderForm.adjustShirtStandardInfo.corStBackdartsPackCorrect}");
			setFont("corStBackdartsPackRange");

			jQuery("#corStRightcuffsSurrounding_div_Size").val("${orderForm.adjustShirtStandardInfo.corStRightcuffsSurroundingSize}");
			jQuery("#corStRightcuffsSurrounding_div_Gross").val("${orderForm.adjustShirtStandardInfo.corStRightcuffsSurroundingGross}");
			jQuery("#corStRightcuffsSurrounding_div_html").html("${orderForm.adjustShirtStandardInfo.corStRightcuffsSurroundingGross}"+".cm");
			if("${orderForm.adjustShirtStandardInfo.corStRightcuffsSurroundingGross}"==""){
				jQuery("#corStRightcuffsSurrounding_div_html").html("000.0cm");
				}
			jQuery("#corStRightcuffsSurroundingRange_out").html("${orderForm.adjustShirtStandardInfo.corStRightcuffsSurroundingCorrect}");
			jQuery("#corStRightcuffsSurroundingRange").val("${orderForm.adjustShirtStandardInfo.corStRightcuffsSurroundingCorrect}");
			setFont("corStRightcuffsSurroundingRange");

			jQuery("#corStLeftcuffsSurrounding_div_Size").val("${orderForm.adjustShirtStandardInfo.corStLeftcuffsSurroundingSize}");
			jQuery("#corStLeftcuffsSurrounding_div_Gross").val("${orderForm.adjustShirtStandardInfo.corStLeftcuffsSurroundingGross}");
			jQuery("#corStLeftcuffsSurrounding_div_html").html("${orderForm.adjustShirtStandardInfo.corStLeftcuffsSurroundingGross}"+".cm");
			if("${orderForm.adjustShirtStandardInfo.corStLeftcuffsSurroundingGross}"==""){
				jQuery("#corStLeftcuffsSurrounding_div_html").html("000.0cm");
				}
			jQuery("#corStLeftcuffsSurroundingRange_out").html("${orderForm.adjustShirtStandardInfo.corStLeftcuffsSurroundingCorrect}");
			jQuery("#corStLeftcuffsSurroundingRange").val("${orderForm.adjustShirtStandardInfo.corStLeftcuffsSurroundingCorrect}");
			setFont("corStLeftcuffsSurroundingRange");
			jQuery("#corStoreCorrectionMemoAgain").val("${orderForm.corStoreCorrectionMemoAgain}");
			var corStBackdartsUnpackCorrect="${orderForm.adjustShirtStandardInfo.corStBackdartsUnpackCorrect}";
			if(corStBackdartsUnpackCorrect=="0"){
			    jQuery("#backDartsPut_0").prop("checked", true);
			}else if(corStBackdartsUnpackCorrect=="2"){
				jQuery("#backDartsPut_2").prop("checked", true);
				}
		} 
</script>