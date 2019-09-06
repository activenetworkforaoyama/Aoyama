<form:form id="idAdjustForm"
	action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm"
	method="post" modelAttribute="orderForm" class="form-horizontal">

	<div id="al_jacket_div">
		<div class="card-header">
			<strong class="card-title">JACKET</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">JACKETサイズ</label>
						</div>
						<div class="col-12 col-md-6">
							体型
							<div class="form-check-inline form-check">
								<form:select id="selectJacketFigure"
									path="adjustJacketStandardInfo.sizeFigure"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderForm.adjustJacketStandardInfo.sizeFigureMap}" />
								</form:select>							
							</div>
							号数
							<div class="form-check-inline form-check">
								<form:select id="selectJacketNumber"
									path="adjustJacketStandardInfo.sizeNumber"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderForm.adjustJacketStandardInfo.sizeNumberMap}" />
								</form:select>								
							</div>
						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">JACKET補正</label>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
						<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkBodyRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkBodyRange" name="adjustJacketStandardInfo.corJkBodyCorrect" value="0" min="" max="" step="0.5" alert-min="-1" alert-max="1">&nbsp;
                                <a href="#" id="corJkBodyRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkBodyRange_out" name="">0</output>cm
                                </div>
                            </div>
						<div class="col-12 col-md-2" id="corJkBody_div">
							<output id="corJkBody_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corJkBodyRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkWaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkWaistRange" name="adjustJacketStandardInfo.corJkWaistCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corJkWaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkWaistRange_out">0</output>cm
							</div>
						</div>
						<div class="col-12 col-md-2" id="corJkWaist_div">
							<!-- <output>000.0</output>cm -->
							<output id="corJkWaist_div_html">000.0cm</output>
						</div>


						<div class="col-12 col-md-9 offset-md-3" id="range_2_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈右修正</label>
						</div>
						<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkRightsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkRightsleeveRange" name="adjustJacketStandardInfo.corJkRightsleeveCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corJkRightsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkRightsleeveRange_out">0</output>cm
                                </div>
						</div>

						<div class="col-12 col-md-2" id="corJkRightsleeve_div">
							<!--  <output>000.0</output>cm -->
							<output id="corJkRightsleeve_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="range_3_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈左修正</label>
						</div>
						<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkLeftsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkLeftsleeveRange" name="adjustJacketStandardInfo.corJkLeftsleeveCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corJkLeftsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkLeftsleeveRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corJkLeftsleeve_div">
							<output id="corJkLeftsleeve_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="range_4_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">肩パット</label>
						</div>
						 <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <label for="oj_shoulderPat_no" class="form-check-label ">
                                        <input type="radio" id="oj_shoulderPat_no" name="adjustJacketStandardInfo.corJkShoulderPad" value="無し" class="form-check-input">無し
                                    </label>　
                                    <label for="oj_shoulderPat_thin" class="form-check-label ">
                                        <input type="radio" id="oj_shoulderPat_thin" name="adjustJacketStandardInfo.corJkShoulderPad" value="薄" class="form-check-input">薄
                                    </label>　
                                    <label for="oj_shoulderPat_thick" class="form-check-label ">
                                        <input type="radio" id="oj_shoulderPat_thick" name="adjustJacketStandardInfo.corJkShoulderPad" value="厚" class="form-check-input">厚
                                    </label>
                                </div>
                            </div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">体型補正</label>
						</div>
						 <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <label for="oj_figureAlter_no" class="form-check-label ">
                                        <input type="radio" id="oj_figureAlter_no" name="adjustJacketStandardInfo.corJkFigureCorrect" value="無し" class="form-check-input">無し
                                    </label>　
                                    <label for="oj_figureAlter_1" class="form-check-label ">
                                        <input type="radio" id="oj_figureAlter_1" name="adjustJacketStandardInfo.corJkFigureCorrect" value="なで肩" class="form-check-input">なで肩
                                    </label>　
                                    <label for="oj_figureAlter_2" class="form-check-label ">
                                        <input type="radio" id="oj_figureAlter_2" name="adjustJacketStandardInfo.corJkFigureCorrect" value="いかり肩" class="form-check-input">いかり肩
                                    </label>
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
                                <textarea name="adjustJacketStandardInfo.corJkStoreCorrectionMemo" id="corJkStoreCorrectionMemo" rows="3" placeholder="再補正コメント" class="form-control"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
	<!-- JACKET -->
	<input type="hidden" id="corJkBody_div_Size"
		name="adjustJacketStandardInfo.corJkBodySize" value="" />
	<input type="hidden" id="corJkBody_div_Gross"
		name="adjustJacketStandardInfo.corJkBodyGross" value="" />
	<input type="hidden" id="corJkWaist_div_Size"
		name="adjustJacketStandardInfo.corJkWaistSize" value="" />
	<input type="hidden" id="corJkWaist_div_Gross"
		name="adjustJacketStandardInfo.corJkWaistGross" value="" />
	<input type="hidden" id="corJkRightsleeve_div_Size"
		name="adjustJacketStandardInfo.corJkRightsleeveSize" value="" />
	<input type="hidden" id="corJkRightsleeve_div_Gross"
		name="adjustJacketStandardInfo.corJkRightsleeveGross" value="" />
	<input type="hidden" id="corJkLeftsleeve_div_Size"
		name="adjustJacketStandardInfo.corJkLeftsleeveSize" value="" />
	<input type="hidden" id="corJkLeftsleeve_div_Gross"
		name="adjustJacketStandardInfo.corJkLeftsleeveGross" value="" />
		
		
	<input type="hidden" id="jacketAdFlag" name="jacketAdFlag" value="1" />
</form:form>

<script
	src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";
var itemCode ="${orderForm.productItem}";
var jacketAdFlag="${orderForm.jacketAdFlag}";
var jacketModel = "${orderForm.optionJacketStandardInfo.ojJacketModel}";
//01:着丈修正、02：ウエスト修正、03：袖丈右修正、04：袖丈左修正
var jkAdjustList = [
	{type:"01",id:"corJkBody_div"},
	{type:"02",id:"corJkWaist_div"},
	{type:"03",id:"corJkRightsleeve_div"},
	{type:"04",id:"corJkLeftsleeve_div"}
];
jQuery(document).ready(function() {
	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });
	     getAdjustByItem();
		 initAlter();
		/*  if(itemFlag=="1"){
			 adjustReInit();
		 }else if(jacketFlag=="0"&&jacketModel==""){

		 }else if(jacketFlag=="1"){
			 getFigureAndNumberByItem();
		 }else if(jacketFlag=="0"&&jacketModel!=""){
			 getFigureAndNumberByItem();
			 adjustSession();
		 } */
		   if(jacketAdFlag==""){	
			   getAdjustByItem();		   
			     jQuery("#oj_shoulderPat_no").prop("checked", true);
			     jQuery("#oj_figureAlter_no").prop("checked", true);
			}else if(jacketAdFlag=="0"){
				getAdjustByItem();
				//adjustReInit();				
				getFigureAndNumberByItem();
				jQuery("#oj_shoulderPat_no").prop("checked", true);
			    jQuery("#oj_figureAlter_no").prop("checked", true);
			}else if(jacketAdFlag=="1"){
				getFigureAndNumberByItem();
				adjustSession();
			}
    jQuery("#selectJacketFigure,#selectJacketNumber").change(function(){
		jkAdjust();	
		 jQuery("oj_shoulderPat_no").val();
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
	        	   if(e.subItemCode == "02"){
						if(e.adjusteClass == "01"){
							document.getElementById("corJkBodyRange").max = e.adjusteMax;
							document.getElementById("corJkBodyRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "02"){
							document.getElementById("corJkWaistRange").max = e.adjusteMax;
							document.getElementById("corJkWaistRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "03"){
							document.getElementById("corJkRightsleeveRange").max = e.adjusteMax;
							document.getElementById("corJkRightsleeveRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "04"){
							document.getElementById("corJkLeftsleeveRange").max = e.adjusteMax;
							document.getElementById("corJkLeftsleeveRange").min = e.adjusteMin;
						}
		           }		  
	           });
	        }
	    });
	}if(itemCode == "02"){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getAdjustByItem",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	        	   if(e.subItemCode == "02"){
						if(e.adjusteClass == "01"){
							document.getElementById("corJkBodyRange").max = e.adjusteMax;
							document.getElementById("corJkBodyRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "02"){
							document.getElementById("corJkWaistRange").max = e.adjusteMax;
							document.getElementById("corJkWaistRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "03"){
							document.getElementById("corJkRightsleeveRange").max = e.adjusteMax;
							document.getElementById("corJkRightsleeveRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "04"){
							document.getElementById("corJkLeftsleeveRange").max = e.adjusteMax;
							document.getElementById("corJkLeftsleeveRange").min = e.adjusteMin;
						}
		           }
	           });
	        }
	    });
	}

}
function jkAdjust(){
	if(jacketModel==""||jacketModel==null){

	}else{
		jQuery("#corJkBodyRange").val(0);
		setFont("corJkBodyRange");
		jQuery("#corJkWaistRange").val(0);
		setFont("corJkWaistRange");
		jQuery("#corJkRightsleeveRange").val(0);
		setFont("corJkRightsleeveRange");
		jQuery("#corJkLeftsleeveRange").val(0);
		setFont("corJkLeftsleeveRange");

		jQuery("#corJkBodyRange_out").val("0");
		jQuery("#corJkWaistRange_out").val("0");
		jQuery("#corJkRightsleeveRange_out").val("0");
		jQuery("#corJkLeftsleeveRange_out").val("0");
	}
	
	
	var subItemCode = "02";
	
	jacketFigure = jQuery("#selectJacketFigure").val();
	jacketNumber = jQuery("#selectJacketNumber").val();
	
if(isNotEmpty(jacketFigure)&&isNotEmpty(jacketNumber)){

	jQuery.ajax({
        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
        type: 'get',
        async:false,
        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":jacketModel,"figure":jacketFigure,"number":jacketNumber},
        success: function(data){
        	for(var i=0; i<data.length; i++){
        		if(data[i].adjustClass == "01"){
					jQuery("#corJkBody_div_html")[0].innerHTML=data[i].typeSize + 'cm';
            		jQuery("#corJkBody_div_Size").val(data[i].typeSize);
            		jQuery("#corJkBody_div_Gross").val(data[i].typeSize);
				}else if(data[i].adjustClass == "02"){
					jQuery("#corJkWaist_div_html")[0].innerHTML=data[i].typeSize + 'cm';
            		jQuery("#corJkWaist_div_Size").val(data[i].typeSize);
            		jQuery("#corJkWaist_div_Gross").val(data[i].typeSize);
				}else if(data[i].adjustClass == "03"){
					jQuery("#corJkRightsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
            		jQuery("#corJkRightsleeve_div_Size").val(data[i].typeSize);
            		jQuery("#corJkRightsleeve_div_Gross").val(data[i].typeSize);
				}else if(data[i].adjustClass == "04"){
					jQuery("#corJkLeftsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
            		jQuery("#corJkLeftsleeve_div_Size").val(data[i].typeSize);
            		jQuery("#corJkLeftsleeve_div_Gross").val(data[i].typeSize);
				}
            }
        }
    })

	}else{
		for (jk of jkAdjustList) {
			jQuery("#"+jk.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+jk.id+"_Size").val("0");
    		jQuery("#"+jk.id+"_Gross").val("0");
		}
	} 
}
	
function getFigureAndNumberByItem(){
	var subItemCode = "";
	var jkModel = jacketModel;
	if(itemCode == "01"){
		if(isNotEmpty(jkModel)){
			subItemCode = "02";
			var jkFigure = document.getElementById("selectJacketFigure");
     	    getSizeFigure(itemCode,subItemCode,jkModel,jkFigure);
     	    

			var jkNumber = document.getElementById("selectJacketNumber");
			getSizeNumber(itemCode,subItemCode,jkModel,jkNumber);
		}
	}else if(itemCode == "02"){
		subItemCode = itemCode;
		var jkFigure = document.getElementById("selectJacketFigure");
 	    getSizeFigure(itemCode,subItemCode,jkModel,jkFigure);
 	    

		var jkNumber = document.getElementById("selectJacketNumber");
		getSizeNumber(itemCode,subItemCode,jkModel,jkNumber);
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
 function adjustReInit(){
	
	var jkFigure = document.getElementById("selectJacketFigure");
	jkFigure.options.length=0;
	jkFigure.add(new Option("選択　　　",""));
	var jkNumber = document.getElementById("selectJacketNumber");
	jkNumber.options.length=0;
	jkNumber.add(new Option("選択　　　",""));
	
	jQuery("#corJkBody_div_Size").val("");
	jQuery("#corJkBody_div_Gross").val("");
	jQuery("#corJkBody_div_html").html("000.0cm");
	jQuery("#corJkBodyRange_out").html("0");
	jQuery("#corJkBodyRange").val("0");
	setFont("corJkBodyRange");
	
	jQuery("#corJkWaist_div_Size").val("");
	jQuery("#corJkWaist_div_Gross").val("");
	jQuery("#corJkWaist_div_html").html("000.0cm");
	jQuery("#corJkWaistRange_out").html("0");
	jQuery("#corJkWaistRange").val("0");
	setFont("corJkWaistRange");

	jQuery("#corJkRightsleeve_div_Size").val("");
	jQuery("#corJkRightsleeve_div_Gross").val("");
	jQuery("#corJkRightsleeve_div_html").html("000.0cm");
	jQuery("#corJkRightsleeveRange_out").html("0");
	jQuery("#corJkRightsleeveRange").val("0");
	setFont("corJkRightsleeveRange");

	jQuery("#corJkLeftsleeve_div_Size").val("");
	jQuery("#corJkLeftsleeve_div_Gross").val("");
	jQuery("#corJkLeftsleeve_div_html").html("000.0cm");
	jQuery("#corJkLeftsleeveRange_out").html("0");
	jQuery("#corJkLeftsleeveRange").val("0");
	setFont("corJkLeftsleeveRange");	
} 
 function adjustSession(){
		jQuery("#selectJacketFigure").val("${orderForm.adjustJacketStandardInfo.sizeFigure}");
		jQuery("#selectJacketNumber").val("${orderForm.adjustJacketStandardInfo.sizeNumber}");

		jQuery("#corJkBody_div_Size").val("${orderForm.adjustJacketStandardInfo.corJkBodySize}");
		jQuery("#corJkBody_div_Gross").val("${orderForm.adjustJacketStandardInfo.corJkBodyGross}");
		jQuery("#corJkBody_div_html").html("${orderForm.adjustJacketStandardInfo.corJkBodyGross}"+".cm");
		if("${orderForm.adjustJacketStandardInfo.corJkBodyGross}"==""){
			jQuery("#corJkBody_div_html").html("000.0cm");
			}
		jQuery("#corJkBodyRange_out").html("${orderForm.adjustJacketStandardInfo.corJkBodyCorrect}");
		jQuery("#corJkBodyRange").val("${orderForm.adjustJacketStandardInfo.corJkBodyCorrect}");
		setFont("corJkBodyRange");
		
		jQuery("#corJkWaist_div_Size").val("${orderForm.adjustJacketStandardInfo.corJkWaistSize}");
		jQuery("#corJkWaist_div_Gross").val("${orderForm.adjustJacketStandardInfo.corJkWaistGross}");
		jQuery("#corJkWaist_div_html").html("${orderForm.adjustJacketStandardInfo.corJkWaistGross}"+".cm");
		if("${orderForm.adjustJacketStandardInfo.corJkWaistGross}"==""){
			jQuery("#corJkWaist_div_html").html("000.0cm");
			}
		jQuery("#corJkWaistRange_out").html("${orderForm.adjustJacketStandardInfo.corJkWaistCorrect}");
		jQuery("#corJkWaistRange").val("${orderForm.adjustJacketStandardInfo.corJkWaistCorrect}");
		setFont("corJkWaistRange");

		jQuery("#corJkRightsleeve_div_Size").val("${orderForm.adjustJacketStandardInfo.corJkRightsleeveSize}");
		jQuery("#corJkRightsleeve_div_Gross").val("${orderForm.adjustJacketStandardInfo.corJkRightsleeveGross}");
		jQuery("#corJkRightsleeve_div_html").html("${orderForm.adjustJacketStandardInfo.corJkRightsleeveGross}"+".cm");
		if("${orderForm.adjustJacketStandardInfo.corJkRightsleeveGross}"==""){
			jQuery("#corJkRightsleeve_div_html").html("000.0cm");
			}
		jQuery("#corJkRightsleeveRange_out").html("${orderForm.adjustJacketStandardInfo.corJkRightsleeveCorrect}");
		jQuery("#corJkRightsleeveRange").val("${orderForm.adjustJacketStandardInfo.corJkRightsleeveCorrect}");
		setFont("corJkRightsleeveRange");

		jQuery("#corJkLeftsleeve_div_Size").val("${orderForm.adjustJacketStandardInfo.corJkLeftsleeveSize}");
		jQuery("#corJkLeftsleeve_div_Gross").val("${orderForm.adjustJacketStandardInfo.corJkLeftsleeveGross}");
		jQuery("#corJkLeftsleeve_div_html").html("${orderForm.adjustJacketStandardInfo.corJkLeftsleeveGross}"+".cm");
		if("${orderForm.adjustJacketStandardInfo.corJkLeftsleeveGross}"==""){
			jQuery("#corJkLeftsleeve_div_html").html("000.0cm");
			}
		jQuery("#corJkLeftsleeveRange_out").html("${orderForm.adjustJacketStandardInfo.corJkLeftsleeveCorrect}");
		jQuery("#corJkLeftsleeveRange").val("${orderForm.adjustJacketStandardInfo.corJkLeftsleeveCorrect}");
		setFont("corJkLeftsleeveRange");
		
		var corJkShoulderPadValue="${orderForm.adjustJacketStandardInfo.corJkShoulderPad}";
		var corJkFigureCorrectValue="${orderForm.adjustJacketStandardInfo.corJkFigureCorrect}"; 
		if(corJkShoulderPadValue=="無し"){
			jQuery("#oj_shoulderPat_no").prop("checked", true);
		}else if(corJkShoulderPadValue=="薄"){
			jQuery("#oj_shoulderPat_thin").prop("checked", true);
		}else if(corJkShoulderPadValue=="厚"){
			jQuery("#oj_shoulderPat_thick").prop("checked", true);
		}
		if(corJkFigureCorrectValue=="無し"){
			jQuery("#oj_figureAlter_no").prop("checked", true);
		}else if(corJkFigureCorrectValue=="なで肩"){
			jQuery("#oj_figureAlter_1").prop("checked", true);
		}else if(corJkFigureCorrectValue=="いかり肩"){
			jQuery("#oj_figureAlter_2").prop("checked", true);
		}
		jQuery("#corJkStoreCorrectionMemo").val("${orderForm.adjustJacketStandardInfo.corJkStoreCorrectionMemo}");
	
	}

</script>