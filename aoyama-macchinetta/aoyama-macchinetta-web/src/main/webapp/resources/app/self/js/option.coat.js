/*********************************************
 * COAT用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionCoat() {
	jQuery('#coatModel').change(function(){
		// 選択中のCOATモデル
		var coatModel = jQuery('#coatModel').val();
		
		var productFabricNo = jQuery("#productFabricNo").val();
		var itemCode = "06";
		var subItemCode = "06"
		//生地チェクフラッグ
		var fabricCheckValue = jQuery("#fabricFlag").val();
		//fabricCheckValue[0]:0 or 1 or 2 
		//fabricCheckValue[1]:エラーメッセージ 
		fabricCheckValue = fabricCheckValue.split("*");

		//生地チェク成功の場合
		if((fabricCheckValue[0]=="0"||fabricCheckValue[0]=="2") && isNotEmpty(productFabricNo)&&isNotEmpty(coatModel)){
			//モデルチェク
			var checkResult = modelCheck(coatModel,productFabricNo,orderPattern,itemCode,subItemCode);
			if(checkResult == "true"){
				//0はモデルチェク成功の場合
				jQuery("#ctModelFlag").val("0");
				jQuery("#coatModelCheck").empty();
				jQuery("#fabricMsg").empty();
			}else if(checkResult == "false"){
				//2はモデルチェク失敗の場合
				jQuery("#ctModelFlag").val("1"+"*"+getMsgByOneArg('msg065','COAT'));
				setAlert('coatModelCheck',getMsgByOneArg('msg065','COAT'));
			}
		}
		

		// ラペルデザインの制御
		if (coatModel == "SingleChester") {
			jQuery('#oc_lapelDesign').prop('disabled', false);
		} else {
			jQuery('#oc_lapelDesign').val("0000101");
			jQuery('#oc_lapelDesign').prop('disabled', true);
		}
		
		// 袖仕様の制御
		if (coatModel == "SoutienCollar") {
			// チェンジポケット　選択可
			jQuery(':radio[name="coOptionCoatStandardInfo.ocSleeveSpec"]').each(function (index, elem) {
				jQuery(elem).prop('disabled', false);
			});
		} else {
			// チェンジポケット　選択不可
			jQuery(':radio[name="coOptionCoatStandardInfo.ocSleeveSpec"]').each(function (index, elem) {
				jQuery(elem).prop('disabled', true);
			});
			jQuery('#oc_sleeveSpec_id1').prop('checked', true);;
		}
		// 腰ポケットの制御
		var oc_waistPkt_options = ["フラップ通常", "箱（斜め）", "パッチ", "パッチ＆フラップ"];
		var oc_waistPkt_options_code = ["0000201", "0000202", "0000203", "0000204"];
		var oc_waistPkt_stenOptions = ["箱（斜め）"];
		var oc_waistPkt_stenOptions_code = ["0000202"];
		var oc_waistPktElem = jQuery('#oc_waistPkt');
		var before_oc_waistPkt = oc_waistPktElem.val();
		oc_waistPktElem.empty();
		if (coatModel == "SoutienCollar") {
			for (var index = 0; index < oc_waistPkt_stenOptions.length; index++) {
				oc_waistPktElem.append(jQuery('<option />').val(oc_waistPkt_stenOptions_code[index]).text(oc_waistPkt_stenOptions[index]));
			}
		} else {
			for (var index = 0; index < oc_waistPkt_options.length; index++) {
				oc_waistPktElem.append(jQuery('<option />').val(oc_waistPkt_options_code[index]).text(oc_waistPkt_options[index]));
			}
			oc_waistPktElem.val(before_oc_waistPkt);
		}
		jQuery('#oc_waistPkt').change();

		// 袖口の制御
		var oc_cuffSpec_options = ["本切羽", "仮切羽", "ターンナップカフス"];
		var oc_cuffSpec_options_code = ["0000701", "0000702", "0000703"];
		var oc_cuffSpec_stenOptions = ["ベルト"];
		var oc_cuffSpec_stenOptions_code = ["0000704"];
		var oc_cuffSpecElem = jQuery('#oc_cuffSpec');
		var before_oc_cuffSpec = oc_cuffSpecElem.val();
		var existBefore = false;
		
		oc_cuffSpecElem.empty();
		if (coatModel == "SoutienCollar") {
			for (var index = 0; index < oc_cuffSpec_stenOptions.length; index++) {
				oc_cuffSpecElem.append(jQuery('<option />').val(oc_cuffSpec_stenOptions_code[index]).text(oc_cuffSpec_stenOptions[index]));
			}
		} else {
			for (var index = 0; index < oc_cuffSpec_options.length; index++) {
				oc_cuffSpecElem.append(jQuery('<option />').val(oc_cuffSpec_options_code[index]).text(oc_cuffSpec_options[index]));
				if (oc_cuffSpec_options_code[index] == before_oc_cuffSpec) {
					existBefore = true;
				}
			}
			if (coatModel == "DoublePolo") {
				oc_cuffSpecElem.val("0000703");
			} else {
				oc_cuffSpecElem.val("0000701");
			}
			var coatItemFlag=jQuery('#coatItemFlag').val();
			if ((coatItemFlag == "0" || coatItemFlag == "") && (orderFlag == "orderLink" 
				|| orderFlag == "orderDetail" || orderFlag == "orderBack" 
				|| orderFlag == "orderCheck" || orderFlag == "orderDivert")) {
				if (existBefore) {
					oc_cuffSpecElem.val(before_oc_cuffSpec);
				} else {
					oc_cuffSpecElem.val(oc_cuffSpec_options_code[0]);
				}
			}
			
			
/*
			} else if (existBefore) {
				oc_cuffSpecElem.val(before_oc_cuffSpec);
			} else {
				oc_cuffSpecElem.val(oc_cuffSpec_options_code[0]);
			}
*/
			//jQuery('#oc_cuffSpec').change();
		}
		jQuery('#oc_cuffSpec').change();

		// バックベルトの制御
		if (coatModel == "") {
			jQuery('#oc_backBelt_id2').prop('disabled', true);
			jQuery('#oc_backBelt_id3').prop('disabled', true);
			jQuery('#oc_backBelt_id1').prop('checked', true);
		} else if (coatModel == "SingleChester" || coatModel == "DoubleChester" || coatModel == "DoublePolo") {
			jQuery('#oc_backBelt_id2').prop('disabled', false);
			jQuery('#oc_backBelt_id3').prop('disabled', true);
			if (jQuery('#oc_backBelt_id3').prop('checked')) {
				jQuery('#oc_backBelt_id1').prop('checked', true);
			}
		} else {
			jQuery('#oc_backBelt_id2').prop('disabled', true);
			jQuery('#oc_backBelt_id3').prop('disabled', false);
			if (jQuery('#oc_backBelt_id2').prop('checked')) {
				jQuery('#oc_backBelt_id1').prop('checked', true);
			}
		}
		
		// フロント釦数
		// 「シングルチェスター」選択時のみ、選択可、ほかの場合には「通常」
		var oSelectFBC = jQuery('#oc_frontBtnCnt');
		var oOptionsFBC = oSelectFBC.find('.Front-Btn-Cnt');
		if (coatModel == "SingleChester") {
			//oSelectFBC.attr('readonly', false);
			//oOptionsFBC.prop('disabled', false);
			oSelectFBC.prop('disabled', false);
		} else {
			oSelectFBC.val('0000601');
			//oSelectFBC.attr('readonly', true);
			//oOptionsFBC.prop('disabled', true);
			oSelectFBC.prop('disabled', true);
		}

		// 別モデルに変更された場合はアラート表示
		if (tmpCoatModel != '' && coatModel != tmpCoatModel) {
		    setAlert('coatModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		}
		// 一時保存のモデルを更新
		tmpCoatModel = coatModel;

	});
	//jQuery('#coatModel').change();

	// 腰ポケット
	jQuery('#oc_waistPkt').change(function(){
		var oc_waistPkt = jQuery('#oc_waistPkt').val();
		if (oc_waistPkt == "0000201") {
			// チェンジポケット　選択可
			jQuery(':radio[name="coOptionCoatStandardInfo.ocChangePkt"]').each(function (index, elem) {
				jQuery(elem).prop('disabled', false);
			});
			// スランテッドポケット　選択可
			jQuery(':radio[name="coOptionCoatStandardInfo.ocSlantedPkt"]').each(function (index, elem) {
				jQuery(elem).prop('disabled', false);
			});
		} else {
			// チェンジポケット　選択不可
			jQuery(':radio[name="coOptionCoatStandardInfo.ocChangePkt"]').each(function (index, elem) {
				jQuery('#oc_changePkt_id1').prop('checked', true).change();
				jQuery(elem).prop('disabled', true);
			});
			jQuery('#oc_changePkt_id1').prop('checked', true).change();
			// スランテッドポケット　選択不可
			jQuery(':radio[name="coOptionCoatStandardInfo.ocSlantedPkt"]').each(function (index, elem) {
				jQuery('#oc_slantedPkt_id1').prop('checked', true).change();
				jQuery(elem).prop('disabled', true);
			});
			jQuery('#oc_slantedPkt_id1').prop('checked', true).change();
		}
	});

	// 袖口
	jQuery('#oc_cuffSpec').change(function(){

		var oc_cuffSpec = jQuery('#oc_cuffSpec').val();
		var oc_sleeveBtnTypeElem = jQuery('#oc_sleeveBtnType');
		var before_oc_sleeveBtnType = oc_sleeveBtnTypeElem.val();
		var oc_sleeveBtnType_k_options = ["重ね4", "並び4"];
		var oc_sleeveBtnType_k_options_code = ["0000801", "0000802"];
		var oc_sleeveBtnType_b_options = ["2"];
		var oc_sleeveBtnType_b_options_code = ["0000804"];
		var oc_sleeveBtnType_t_options = ["無し"];
		var oc_sleeveBtnType_t_options_code = ["0000803"];
		var oc_sleeveBtnTypeSet = null;
		var oc_sleeveBtnTypeSet_code = null;
		var before_oc_sleeveBtnType = oc_sleeveBtnTypeElem.val();
		var existBeforeSl = false;

		// option候補値を選択
		if (oc_cuffSpec == "0000701" || oc_cuffSpec == "0000702") {
			oc_sleeveBtnTypeSet = oc_sleeveBtnType_k_options;
			oc_sleeveBtnTypeSet_code = oc_sleeveBtnType_k_options_code;
		} else if (oc_cuffSpec == "0000704") {
			oc_sleeveBtnTypeSet = oc_sleeveBtnType_b_options;
			oc_sleeveBtnTypeSet_code = oc_sleeveBtnType_b_options_code;
		} else {
			oc_sleeveBtnTypeSet = oc_sleeveBtnType_t_options;
			oc_sleeveBtnTypeSet_code = oc_sleeveBtnType_t_options_code;
		}

		// optionを作成
		oc_sleeveBtnTypeElem.empty();
		for (var index = 0; index < oc_sleeveBtnTypeSet.length; index++) {
			oc_sleeveBtnTypeElem.append(jQuery('<option />')
				.val(oc_sleeveBtnTypeSet_code[index])
				.text(oc_sleeveBtnTypeSet[index]));
			if (oc_sleeveBtnTypeSet_code[index] == before_oc_sleeveBtnType) {
				existBeforeSl = true;
			}
		}
		if (existBeforeSl) {
			oc_sleeveBtnTypeElem.val(before_oc_sleeveBtnType);
		} else {
			oc_sleeveBtnTypeElem.val(oc_sleeveBtnTypeSet_code[0]);
		}
		jQuery('#oc_sleeveBtnType_div').show();

/*
		if (oc_cuffSpec == "本切羽" || oc_cuffSpec == "仮切羽") {
			// 本切羽か仮切羽の場合のみ、袖釦を表示
			jQuery('#oc_sleeveBtnType_div').show();
		} else {
			jQuery('#oc_sleeveBtnType_div').hide();
			jQuery('#oc_sleeveBtnType').val("重ね4");
		}
*/
	});
	
	// 袖裏地品番（胴裏地と同じ）
/*	jQuery('#btn_oc_cuffBackMate').click(function() {
		// 胴裏地品番
		var backLiningMateStkNo = jQuery('#oc_bodyBackMateStkNo').val();

		// 袖裏地素材への反映
		jQuery('#oc_cuffBackMateStkNo').val(backLiningMateStkNo);
	});

	// 胴裏素材
	jQuery('#oc_bodyBackMate').change(function (){
		var bodyBackMate = jQuery('#oc_bodyBackMate').val();

		// 胴裏素材品番
		var bodyBackMateStkNoElem = jQuery('#oc_bodyBackMateStkNo');

		// 選択肢をクリア
		bodyBackMateStkNoElem.empty();

		if (coatBodyBackMateStkNoList[bodyBackMate]) {
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < coatBodyBackMateStkNoList[bodyBackMate].length; i++) {
				bodyBackMateStkNoElem.append(jQuery('<option />').val(coatBodyBackMateStkNoList[bodyBackMate][i]).text(coatBodyBackMateStkNoList[bodyBackMate][i]));
			}
		}
	});
	jQuery('#oc_bodyBackMate').change();

	// 袖裏素材
	jQuery('#oc_cuffBackMate').change(function (){
		var cuffBackMate = jQuery('#oc_cuffBackMate').val();

		// 袖裏素材品番
		var cuffBackMateStkNoElem = jQuery('#oc_cuffBackMateStkNo');

		// 選択肢をクリア
		cuffBackMateStkNoElem.empty();

		if (coatCuffBackMateStkNoList[cuffBackMate]) {
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < coatCuffBackMateStkNoList[cuffBackMate].length; i++) {
				cuffBackMateStkNoElem.append(jQuery('<option />').val(coatCuffBackMateStkNoList[cuffBackMate][i]).text(coatCuffBackMateStkNoList[cuffBackMate][i]));
			}
		}
	});
	jQuery('#oc_cuffBackMate').change();

	// 釦素材
	jQuery('#oc_frontBtnMate').change(function (){
		var frontBtnMate = jQuery('#oc_frontBtnMate').val();

		// 品番
		var frontBtnMateStkNoElem = jQuery('#oc_frontBtnMateStkNo');

		// 選択肢をクリア
		frontBtnMateStkNoElem.empty();

		if (coatFrontBtnMatStkNoList[frontBtnMate]) {
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < coatFrontBtnMatStkNoList[frontBtnMate].length; i++) {
				frontBtnMateStkNoElem.append(jQuery('<option />').val(coatFrontBtnMatStkNoList[frontBtnMate][i]).text(coatFrontBtnMatStkNoList[frontBtnMate][i]));
			}
		}
	});
	jQuery('#oc_frontBtnMate').change();*/

}

function modelCheck(modelCode,productFabricNo,orderPattern,itemCode,subItemCode){
	var checkResult = jQuery.ajax({url:contextPath + "/orderCo/checkModel",data:{"modelCode":modelCode,"productFabricNo":productFabricNo,"orderPattern":orderPattern,"itemCode":itemCode,"subItemCode":subItemCode},async:false});
	checkResult = checkResult.responseText;
	return checkResult;
}
//--------------------------------------------
// 部品
//--------------------------------------------
