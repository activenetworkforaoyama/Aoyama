/*********************************************
 * 補正タブ用JS
 *********************************************/
function initAlter() {
	jQuery('input[type="range"]').each(function() {
		var elem = jQuery(this);
		var id = elem.prop('id');
		var step = elem.prop('step') - 0;
		elem.on('input', function(){
			
			jQuery('#'+id+'_out').val(this.value);
			var idRe = id.replace('Range','_div');
			var sizeVal = jQuery("#"+idRe+"_Size").val();
			var labelVaUplCm = jQuery('#'+idRe+'_html').html()
			var labelValUp = labelVaUplCm.replace('cm','');
			var thisVal = this.value;
			if(sizeVal!=""&&typeof(sizeVal)!="undefined"){
				var val = (parseFloat(sizeVal)+parseFloat(this.value)).toFixed(1);
			}else{
				var val = parseFloat(this.value).toFixed(1);
			}
			
			jQuery("#"+idRe+"_html").html(val+"cm");
			jQuery('#'+idRe+'_Gross').val(val);
			setFont(id);
			checkRange(id, elem.val());
		});
		jQuery('#'+id+'_p').click(function(){
			elem.val(elem.val()-0+step);
			jQuery('#'+id+'_out').val(elem.val());
			var max = document.getElementById(id).max;
			var idRe = id.replace('Range','_div');	
			var sizeVal = jQuery("#"+idRe+"_Size").val();
			var labelVaUplCm = jQuery('#'+idRe+'_html').html();
			if(typeof(labelVaUplCm)!="undefined"&&labelVaUplCm!=null){
				var idRejQ = jQuery('#'+idRe);
				
				var labelValUp = labelVaUplCm.replace('cm','');
				
				var maxVal = (parseFloat(max)+parseFloat(sizeVal)).toFixed(1);
				
				var val = (parseFloat(labelValUp)+parseFloat(step)).toFixed(1);

				if(val<=maxVal){
					jQuery("#"+idRe+"_html").html(val+"cm");
					jQuery('#'+idRe+'_Gross').val(val);
				}else{
					return false;
				}
			}
			setFont(id);	
			checkRange(id, elem.val());
			return false;
		});
		jQuery('#'+id+'_m').click(function(){
			elem.val(elem.val()-0-step);
			jQuery('#'+id+'_out').val(elem.val());
			var min = document.getElementById(id).min;
			var idRe = id.replace('Range','_div');
			var sizeVal = jQuery("#"+idRe+"_Size").val();
			var labelValDoCm = jQuery('#'+idRe+'_html').html();
			if(typeof(labelValDoCm)!="undefined"&&labelValDoCm!=null){
				
				var idRejQ = jQuery('#'+idRe);

				var labelValDo = labelValDoCm.replace('cm','');

				var minVal = (parseFloat(min)+parseFloat(sizeVal)).toFixed(1);
				
				var val = (parseFloat(labelValDo)-parseFloat(step)).toFixed(1);
				if(val>=minVal){
					
					jQuery("#"+idRe+"_html").html(val+"cm");
					jQuery('#'+idRe+'_Gross').val(val);
				}else{
					return false;
				}
			}
			setFont(id);			
			checkRange(id, elem.val());
			return false;
		});
	});	
}

function shirtInitAlter() {
	jQuery('input[type="range"]').each(function() {
		var elem = jQuery(this);
		var id = elem.prop('id');
		var step = elem.prop('step') - 0;
		elem.on('input', function(){
			jQuery('#'+id+'_out').val(this.value);
			setFont(id);
			//規定値超えチェック
			checkRange(id, elem.val());
		});
		jQuery('#'+id+'_p').click(function(){
			// 無効設定チェック
			var disabled = elem.attr('disabled');
			if (disabled != null && disabled != "") return false;
			
			elem.val(elem.val()-0+step);
			jQuery('#'+id+'_out').val(elem.val());
			setFont(id);
			//規定値超えチェック
			checkRange(id, elem.val());
			return false;
		});
		jQuery('#'+id+'_m').click(function(){
			// 無効設定チェック
			var disabled = elem.attr('disabled');
			if (disabled != null && disabled != "") return false;
			
			elem.val(elem.val()-0-step);
			jQuery('#'+id+'_out').val(elem.val());
			setFont(id);
			//規定値超えチェック
			checkRange(id, elem.val());
			return false;
		});
	});	
}

//--------------------------------------------
// 部品
//--------------------------------------------
function setFont(id) {
	var color = "black";
	var value = jQuery('#'+id).val() - 0;
	if (value < 0) {
		color = "red";
	} else if (value > 0) {
		color = "blue";
	}else if (value == 0) {
		color = "black";
	}
	jQuery('#'+id).parent().css("color", color);
}

function setRangeDisable(id, flag) {
	var oMinus = jQuery('#' + id + '_m');
	var oRange = jQuery('#' + id);
	var oPlus  = jQuery('#' + id + '_p');

	oMinus.attr('disabled', flag);
	oRange.prop('disabled', flag);
	oPlus.attr( 'disabled', flag);

	if (flag) {
		oMinus.removeAttr('href');
		oMinus.css('color', '#878787');
		oPlus.removeAttr('href');
		oPlus.css('color', '#878787');
	} else {
		oMinus.prop('href', '#');
		oMinus.css('color', '');
		oPlus.prop('href', '#');
		oPlus.css('color', '');
	}
}

// 補正の規定値超えチェック
// エラー時はid + "_alert"にメッセージ出力します。
function checkRange(id, val) {
	var resultRange = false;
	var resultHip   = false;
	var setValue = val - 0;
	var checkVal;
	var idHip;

	try {
		// 最大値チェック
		var alertMaxValue = jQuery("#" + id).attr("alert-max") - 0;
		if (setValue > alertMaxValue) throw new Exception();

		// 最小値チェック
		var alerMintValue = jQuery("#" + id).attr("alert-min") - 0;
		if (setValue < alerMintValue) throw new Exception();
		
		resultRange = true;
	} catch(e) {
		// チェック処理から抜けるだけなのでここでの処理は行わない
	}
	
	// ヒップの場合のウエストチェック
	try {
		if (id=="ap_hip") {
			idHip = "ap_hip";
			checkVal =  jQuery("#ap_waist").val() - 0;
			if ((setValue > 0 && checkVal < 0) || (checkVal > 0 && setValue < 0)) {
				throw new Exception();
			}
		}
		if (id=="ap2_hip") {
			idHip = "ap2_hip";
			checkVal =  jQuery("#ap2_waist").val() - 0;
			if ((setValue > 0 && checkVal < 0) || (checkVal > 0 && setValue < 0)) {
				throw new Exception();
			}
		}
		if (id=="ap_waist") {
			idHip = "ap_hip";
			checkVal =  jQuery("#ap_hip").val() - 0;
			if ((setValue > 0 && checkVal < 0) || (checkVal > 0 && setValue < 0)) {
				throw new Exception();
			}
		}
		if (id=="ap2_waist") {
			idHip = "ap2_hip";
			checkVal =  jQuery("#ap2_hip").val() - 0;
			if ((setValue > 0 && checkVal < 0) || (checkVal > 0 && setValue < 0)) {
				throw new Exception();
			}
		}
		resultHip = true;
	} catch(e) {
		// チェック処理から抜けるだけなのでここでの処理は行わない
	}

	clearAlert(id + "_alert");
	clearAlert(idHip + "_alert");
	if (resultRange == false) {
		setAlert(id + "_alert", "値が規定値を超えています。");
	}
	if (resultHip == false) {
		appendAlertCo(idHip + "_alert", "補正値に矛盾があります。工場にて修正を加える場合があります。");
	}
	
	return (resultRange && resultHip);
}