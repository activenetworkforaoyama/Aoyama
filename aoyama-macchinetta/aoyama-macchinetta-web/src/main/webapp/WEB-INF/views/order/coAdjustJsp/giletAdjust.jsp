<form:form id="idAdjustForm"
	action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm"
	method="post" modelAttribute="orderForm" class="form-horizontal">
	<div id="al_gilet_div">
		<div class="card-header">
			<strong class="card-title">GILET</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">GILETサイズ</label>
						</div>
						<div class="col-12 col-md-6">
							体型
							<div class="form-check-inline form-check">
								<form:select id="selectGiletFigure"
									path="adjustGiletStandardInfo.sizeFigure"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderForm.adjustGiletStandardInfo.sizeFigureMap}" />
								</form:select>								
							</div>
							号数
							<div class="form-check-inline form-check">
								<form:select id="selectGiletNumber"
									path="adjustGiletStandardInfo.sizeNumber"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderForm.adjustGiletStandardInfo.sizeNumberMap}" />
								</form:select>							
							</div>
						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">GILET補正</label>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
						<!-- <div class="col-12 col-md-4">
							<div class="form-check-inline form-check">
								<a href="#" id="corGlBodylengthRange_m"><i
									class="fa fa-minus-square" style="font-size: 32px"></i></a>&nbsp; <input
									type="range" id="corGlBodylengthRange"
									name="adjustPantsStandardInfo.corGlBodylengthCorrect" value="0"
									min="" max="" step="0.5">&nbsp; <a href="#"
									id="corGlBodylengthRange_p"><i class="fa fa-plus-square"
									style="font-size: 32px"></i></a>
								<output id="corGlBodylengthRange_out">0</output>
								cm
							</div> -->
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corGlBodyRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corGlBodyRange" name="adjustGiletStandardInfo.corGlBodyCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corGlBodyRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corGlBodyRange_out">0</output>cm
                                </div>
							
						</div>
						<div class="col-12 col-md-2" id="corGlBodylength_div">
							<output id="corGlBody_div_html">000.0cm</output>

						</div>
						<div class="col-12 col-md-9 offset-md-3" id="range_5_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">バスト修正</label>
						</div>
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corGlBustRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corGlBustRange" name="adjustGiletStandardInfo.corGlBustCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corGlBustRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corGlBustRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corGlBust_div">
							<output id="corGlBust_div_html">000.0cm</output>

						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
												
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corGlWaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corGlWaistRange" name="adjustGiletStandardInfo.corGlWaistCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corGlWaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corGlWaistRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corGlWaist_div">
							<output id="corGlWaist_div_html">000.0cm</output>

						</div>
						<div class="col-12 col-md-9 offset-md-3" id="range_6_alert"></div>
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
                                <textarea name="adjustGiletStandardInfo.corGlStoreCorrectionMemo" id="corGlStoreCorrectionMemo" rows="3" placeholder="再補正コメント" class="form-control"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
	 <!-- GILET -->
   <input type="hidden" id="corGlBody_div_Size"
		name="adjustGiletStandardInfo.corGlBodySize" value="" />
    <input type="hidden" id="corGlBody_div_Gross"
		name="adjustGiletStandardInfo.corGlBodyGross" value="" />
		
	<input type="hidden" id="corGlBust_div_Size"
		name="adjustGiletStandardInfo.corGlBustSize" value="" />
	<input type="hidden" id="corGlBust_div_Gross"
		name="adjustGiletStandardInfo.corGlBustGross" value="" />
		
	<input type="hidden" id="corGlWaist_div_Size"
		name="adjustGiletStandardInfo.corGlWaistSize" value="" />
	<input type="hidden" id="corGlWaist_div_Gross"
		name="adjustGiletStandardInfo.corGlWaistGross" value="" />
		
	<input type="hidden" id="giletAdFlag"
		name="giletAdFlag" value="1" />	
		
</form:form>
<script
	src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var orderPattern = "CO";
var itemCode ="${orderForm.productItem}";
var giletAdFlag="${orderForm.giletAdFlag}";
var glModel = "${orderForm.optionGiletStandardInfo.ogGiletModel}";
var giletAdjustList = [
	{type:"01",id:"corGlBody_div"},
	{type:"14",id:"corGlBust_div"},
	{type:"02",id:"corGlWaist_div"}
];
jQuery(document).ready(function() {

	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });
		getAdjustByItem();
		/* if(itemFlag=="1"){
			 adjustReInit();
		 }else if(giletFlag=="0"&&glModel==""){

		 }else if(giletFlag=="1"){
			 getFigureAndNumberByItem();
		 }else if(giletFlag=="0"&&glModel!=""){
			 getFigureAndNumberByItem();
			 adjustSession();
		 } */
		if(giletAdFlag==""){
			
		}else if(giletAdFlag=="0"){
			adjustReInit();
			getFigureAndNumberByItem();
		}else if(giletAdFlag=="1"){
			getFigureAndNumberByItem();
			adjustSession();
		}
	    //getFigureAndNumberByItem();
	    initAlter();
jQuery("#selectGiletFigure,#selectGiletNumber").change(function(){
	   giletAdjust();
    })   
});
function getAdjustByItem(){
	var subItemCode = "";
	if(itemCode == "04"){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getAdjustByItem",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	        	   if(e.subItemCode == "04"){
	        		   if(e.adjusteClass == "01"){
		            		document.getElementById("corGlBodyRange").max = e.adjusteMax;
							document.getElementById("corGlBodyRange").min = e.adjusteMin;
						}
		        	   if(e.adjusteClass == "14"){
							document.getElementById("corGlBustRange").max = e.adjusteMax;
							document.getElementById("corGlBustRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "02"){
							document.getElementById("corGlWaistRange").max = e.adjusteMax;
							document.getElementById("corGlWaistRange").min = e.adjusteMin;
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
	        	   if(e.subItemCode == "04"){
	        		   if(e.adjusteClass == "01"){
		            		document.getElementById("corGlBodyRange").max = e.adjusteMax;
							document.getElementById("corGlBodyRange").min = e.adjusteMin;
						}
		        	   if(e.adjusteClass == "14"){
							document.getElementById("corGlBustRange").max = e.adjusteMax;
							document.getElementById("corGlBustRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "02"){
							document.getElementById("corGlWaistRange").max = e.adjusteMax;
							document.getElementById("corGlWaistRange").min = e.adjusteMin;
						}
		           }		  
	           });
	        }
	    });
	}
}
function getFigureAndNumberByItem(){
	var subItemCode = "";
	if(itemCode == "04"){
		subItemCode = itemCode;
		var glFigure = document.getElementById("selectGiletFigure");
 	    getSizeFigure(itemCode,subItemCode,glModel,glFigure);
 	    
		var glNumber = document.getElementById("selectGiletNumber");
		getSizeNumber(itemCode,subItemCode,glModel,glNumber);
	}
	if(itemCode == "01"){
		if(isNotEmpty(glModel)){
			subItemCode = "04";
			var glFigure = document.getElementById("selectGiletFigure");
	 	    getSizeFigure(itemCode,subItemCode,glModel,glFigure);
	 	 
			var glNumber = document.getElementById("selectGiletNumber");
			getSizeNumber(itemCode,subItemCode,glModel,glNumber);
		}

	}}

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

function giletAdjust(){
	if(glModel==""||glModel==null){
		
	}else{
		jQuery("#corGlBodyRange").val(0);
		setFont("corGlBodyRange");
		jQuery("#corGlBustRange").val(0);
		setFont("corGlBustRange");
		jQuery("#corGlWaistRange").val(0);
		setFont("corGlWaistRange");

		jQuery("#corGlBodyRange_out").html('0');
		jQuery("#corGlBustRange_out").html('0');
		jQuery("#corGlWaistRange_out").html('0');
	}
	var subItemCode = "04";
	giletFigure = jQuery("#selectGiletFigure").val();
	giletNumber = jQuery("#selectGiletNumber").val();
	
	if(isNotEmpty(giletFigure)&&isNotEmpty(giletNumber)){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":glModel,"figure":giletFigure,"number":giletNumber},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "01"){
						jQuery("#corGlBody_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corGlBody_div_Size").val(data[i].typeSize);
	            		jQuery("#corGlBodylength_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "14"){
						jQuery("#corGlBust_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corGlBust_div_Size").val(data[i].typeSize);
	            		jQuery("#corGlBust_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "02"){
						jQuery("#corGlWaist_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corGlWaist_div_Size").val(data[i].typeSize);
	            		jQuery("#corGlWaist_div_Gross").val(data[i].typeSize);
					}
		        }
		    }
		})
	}else{
		for (gilet of giletAdjustList) {
			jQuery("#"+gilet.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+gilet.id+"_Size").val("0");
    		jQuery("#"+gilet.id+"_Gross").val("0");
		}
	}	
}
function adjustReInit(){
	//GLサイズを設定
	var glFigure = document.getElementById("selectGiletFigure");
	glFigure.options.length=0;
	glFigure.add(new Option("選択　　　",""));
	var glNumber = document.getElementById("selectGiletNumber");
	glNumber.options.length=0;
	glNumber.add(new Option("選択　　　",""));

	jQuery("#corGlBody_div_Size").val("");
	jQuery("#corGlBody_div_Gross").val("");
	jQuery("#corGlBody_div_html").html("000.0cm");
	jQuery("#corGlBodyRange_out").html("0");
	jQuery("#corGlBodyRange").val("0");
	setFont("corGlBodyRange");
	
	jQuery("#corGlBust_div_Size").val("");
	jQuery("#corGlBust_div_Gross").val("");
	jQuery("#corGlBust_div_html").html("000.0cm");
	jQuery("#corGlBust_out").html("0");
	jQuery("#corGlBustRange").val("0");
	setFont("corGlBustRange");

	jQuery("#corGlWaist_div_Size").val("");
	jQuery("#corGlWaist_div_Gross").val("");
	jQuery("#corGlWaist_div_html").html("000.0cm");
	jQuery("#corGlWaist_out").html("0");
	jQuery("#corGlWaistRange").val("0");
	setFont("corGlWaistRange");
} 
function adjustSession(){

	jQuery("#selectGiletFigure").val("${orderForm.adjustGiletStandardInfo.sizeFigure}");
	jQuery("#selectGiletNumber").val("${orderForm.adjustGiletStandardInfo.sizeNumber}");

	jQuery("#corGlBody_div_Size").val("${orderForm.adjustGiletStandardInfo.corGlBodySize}");
	jQuery("#corGlBody_div_Gross").val("${orderForm.adjustGiletStandardInfo.corGlBodyGross}");
	jQuery("#corGlBody_div_html").html("${orderForm.adjustGiletStandardInfo.corGlBodyGross}"+".cm");
	if("${orderForm.adjustGiletStandardInfo.corGlBodyGross}"==""){
		jQuery("#corGlBody_div_html").html("000.0cm");
		}
	jQuery("#corGlBodyRange_out").html("${orderForm.adjustGiletStandardInfo.corGlBodyCorrect}");
	jQuery("#corGlBodyRange").val("${orderForm.adjustGiletStandardInfo.corGlBodyCorrect}");
	setFont("corGlBodyRange");
	
	jQuery("#corGlBust_div_Size").val("${orderForm.adjustGiletStandardInfo.corGlBustSize}");
	jQuery("#corGlBust_div_Gross").val("${orderForm.adjustGiletStandardInfo.corGlBustGross}");
	jQuery("#corGlBust_div_html").html("${orderForm.adjustGiletStandardInfo.corGlBustGross}"+".cm");
	if("${orderForm.adjustGiletStandardInfo.corGlBustGross}"==""){
		jQuery("#corGlBust_div_html").html("000.0cm");
		}
	
	jQuery("#corGlBustRange_out").html("${orderForm.adjustGiletStandardInfo.corGlBustCorrect}");
	jQuery("#corGlBustRange").val("${orderForm.adjustGiletStandardInfo.corGlBustCorrect}");
	setFont("corGlBustRange");

	jQuery("#corGlWaist_div_Size").val("${orderForm.adjustGiletStandardInfo.corGlWaistSize}");
	jQuery("#corGlWaist_div_Gross").val("${orderForm.adjustGiletStandardInfo.corGlWaistGross}");
	jQuery("#corGlWaist_div_html").html("${orderForm.adjustGiletStandardInfo.corGlWaistGross}"+".cm");
	if("${orderForm.adjustGiletStandardInfo.corGlWaistGross}"==""){
		jQuery("#corGlWaist_div_html").html("000.0cm");
		}
	jQuery("#corGlWaistRange_out").html("${orderForm.adjustGiletStandardInfo.corGlWaistCorrect}");
	jQuery("#corGlWaistRange").val("${orderForm.adjustGiletStandardInfo.corGlWaistCorrect}");
	setFont("corGlWaistRange");
	jQuery("#corGlStoreCorrectionMemo").val("${orderForm.adjustGiletStandardInfo.corGlStoreCorrectionMemo}");
	
}
		


</script>