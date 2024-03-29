/*********************************************
 * タキシードPANTS1用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionPants1Tuxedo() {
	jQuery('#tp_pantsModel').attr("oldTpPantsModel",jQuery('#tp_pantsModel').val());
	// PANTSモデル
	jQuery('#tp_pantsModel').change(function() {
		// 選択されたPantsモデルを取得
		var pantsModel = jQuery(this).val();
		
		var pantsoldModel = jQuery('#tp_pantsModel').attr("oldTpPantsModel");
		var modelFlag = 0;
		if(pantsoldModel == '' || pantsoldModel == null){
			modelFlag = 1;
		}
		else {
			modelFlag = 2;
		}
		if (pantsModel != pantsoldModel) {
			jQuery("#pantsFlag").val("0");
		}else{
			jQuery("#pantsFlag").val("1");
		}
		
		jQuery('#tp_pantsModel').attr("oldTpPantsModel",jQuery('#tp_pantsModel').val());
		var pantsFlag = jQuery("#pantsFlag").val();
		if(pantsFlag == "0"){
			// 選択されたJacketモデルを取得
			if (pantsModel == '') {
				// 未選択時は何もしない
				return;
			}
		
		var productFabricNo = jQuery("#productFabricNo").val();
		var item = jQuery("#item").val();
		var subItemCode = "03"
		var itemCode = "";
		if(item == "01"){
			itemCode = "01"
		}else if(item == "03"){
			itemCode = "03";
		}
		
		//生地チェクフラッグ
		var fabricCheckValue = jQuery("#fabricFlag").val();
		//fabricCheckValue[0]:0 or 1 or 2
		//fabricCheckValue[1]:エラーメッセージ 
		fabricCheckValue = fabricCheckValue.split("*");
		
		//生地チェク成功の場合
		if((fabricCheckValue[0]=="0"||fabricCheckValue[0]=="2")&&isNotEmpty(productFabricNo)){
			//モデルチェク
			var checkResult = modelCheck(pantsModel,productFabricNo,orderPattern,itemCode,subItemCode);
			if(checkResult == "true"){
				//0はモデルチェク成功の場合
				jQuery("#ptModelFlag").val("0");
				jQuery("#tp_pantsModelCheck").empty();
				jQuery("#fabricMsg").empty();
				jQuery("#tp_pantsModelCheck").hide();
			}else if(checkResult == "false"){
				//2はモデルチェク失敗の場合
				jQuery("#tp_pantsModelCheck").show();
				jQuery("#ptModelFlag").val("1"+"*"+getMsgByOneArg('msg065','PANTS'));
				appendAlertPo('tp_pantsModelCheck',getMsgByOneArg('msg065','PANTS'));
			}
		}

		// 選択中のタック
		var tackElem = jQuery('#tp_tack');
		var selectedTack = tackElem.val();

		// タックの選択肢更新
		tackElem.empty();
		var tmpTack = null;
		for (tmpTack of tackList[pantsModel].activeList) {
			tackElem.append(jQuery('<option />').val(tmpTack.val).text(tmpTack.text));
		}
		// デフォルトを選択
		tackElem.val(tackList[pantsModel].defaultValue);

		// フロント仕様設定
		var sFrontSpec = defaultFrontSpec[pantsModel];
		jQuery('input[name="coOptionPantsTuxedoInfo.tpFrontSpec"]').val([sFrontSpec]);
		jQuery('input[id^="tp_frontSpec_id"]:checked').change();
		
		// パンチェリーナ特殊制御
		tpPancherinaSpecialController();

		// 選択中のアジャスター仕様
		var selectedAdjuster = jQuery('input[name="coOptionPantsTuxedoInfo.tpAdjuster"]:checked').val();

		// アジャスター仕様の選択肢制御
		jQuery('input[id^="tp_adjuster_"]').each(function() {
			var tmpTpAdjusterElem = jQuery(this);
			var value = tmpTpAdjusterElem.val();

			if (adjusterList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なアジャスター仕様の場合、有効化
				tmpTpAdjusterElem.prop("disabled", false);
			} else {
				// 有効なアジャスター仕様ではない場合、無効化
				tmpTpAdjusterElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name="coOptionPantsTuxedoInfo.tpAdjuster"]').val([adjusterList[pantsModel].defaultValue]);
		jQuery('input[id^="tp_adjuster_id"]:checked').change();
		// 選択中のベルトループ
		var selectedBeltLoop = jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoop"]:checked').val();
		
		// ベルトループの選択肢制御
		jQuery('input[id^="tp_beltLoop_"]').each(function() {
			var tmpTpBeltLoopElem = jQuery(this);
			var value = tmpTpBeltLoopElem.val();

			if (beltLoopList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なベルトループの場合、有効化
				tmpTpBeltLoopElem.prop("disabled", false);
			} else {
				// 有効なベルトループではない場合、無効化
				tmpTpBeltLoopElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoop"]').val([beltLoopList[pantsModel].defaultValue]);
		jQuery('input[id^="op_beltLoop_id"]:checked').change();

		// ベルトループ変更時処理
		tpChangedBeltLoop();

		// 選択中の脇ポケット
		var sidePktElem = jQuery('input[name="coOptionPantsTuxedoInfo.tpSidePkt"]:checked');
		var selectedSidePkt = sidePktElem.val();

		// モデルに基づくデフォルトの脇ポケット
		var modelSidePkt = pantsModelDefaultList[pantsModel].op_sidePkt;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsTuxedoInfo.tpSidePkt"]').val([modelSidePkt]);

		// 選択中の忍びポケット
		var sinobiPktElem = jQuery('input[name="coOptionPantsTuxedoInfo.tpSinobiPkt"]:checked');
		var selectedSinobiPkt = sinobiPktElem.val();
		jQuery('input[id^="tp_sinobiPkt_id"]:checked').change();

		// モデルに基づくデフォルトの忍びポケット
		var modelSinobiPkt = pantsModelDefaultList[pantsModel].op_sinobiPkt;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsTuxedoInfo.tpSinobiPkt"]').val([modelSinobiPkt]);

		// モデルに基づくデフォルトのコインポケット
		var modelCoinPkt = pantsModelDefaultList[pantsModel].op_coinPkt;
		// デフォルトを選択
		jQuery('#tp_coinPkt').val([modelCoinPkt]);
		jQuery('#tp_coinPkt').change();

		// 選択中の上前ピスポケット
		var pisPktUf = jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktUf"]:checked');
		var selectedPisPktUf = pisPktUf.val();

		// モデルに基づくデフォルトの上前ピスポケット
		var modelPisPktUf = pantsModelDefaultList[pantsModel].op_pisPktUf;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktUf"]').val([modelPisPktUf]);
		jQuery('input[id^="tp_pisPktUf_id"]:checked').change();

		// 選択中の下前ピスポケット
		var pisPktDf = jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktDf"]:checked');
		var selectedPisPktDf = pisPktDf.val();

		// モデルに基づくデフォルトの下前ピスポケット
		var modelPisPktDf = pantsTuxedoModelDefaultList[pantsModel].op_pisPktDf;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktDf"]').val([modelPisPktDf]);
		jQuery('input[id^="tp_pisPktDf_id"]:checked').change();

		// 選択中のVカット
		var vCut = jQuery('input[name="coOptionPantsTuxedoInfo.tpVCut"]:checked');
		var selectedVCut = vCut.val();

		// モデルに基づくデフォルトのVカット
		var modelVCut = pantsModelDefaultList[pantsModel].op_vCut;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsTuxedoInfo.tpVCut"]').val([modelVCut]);

		//ボタンホール色指定
		jQuery('#tp_bhColor_id1').prop("checked",true);
		jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor"]:checked').change();
		
		//ボタン付け糸指定
		jQuery('#tp_byColor_id1').prop("checked",true);
		jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor"]:checked').change();
		
		// 別モデルに変更された場合はアラート表示
		if ((tmpTpPantsModel != '' || tmpTpPantsModel != null) && pantsModel != tmpTpPantsModel && modelFlag == 2) {
		    setAlert('tp_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		}
		// 一時保存のモデルを更新
		tmpTpPantsModel = pantsModel;
		}
	});

	//拝絹地
	var item = jQuery("#item").val();
	if(item == "01"){
		jQuery("#tp_GlossFablic").prop("disabled",true);
	}else{
		jQuery("#tp_GlossFablic").prop("disabled",false);
	}
	
	// 膝裏
	jQuery('input[name="coOptionPantsTuxedoInfo.tpKneeBack"]').each(function() {
		jQuery(this).change(function(){

			// 現在の膝裏を取得
			var selectedKneeBack = jQuery('input[name="coOptionPantsTuxedoInfo.tpKneeBack"]:checked').val();
			var disabledFlg = false;

			if (selectedKneeBack == '0000202') {
				disabledFlg = true;
				jQuery('#tp_kneeBackMate_div').hide();
			} else {
				jQuery('#tp_kneeBackMate_div').show();
			}


			// 膝裏が無しの場合は膝裏素材を全て選択不可
			jQuery('input[id^="tp_kneeBackMate_"]').each(function() {
				var tmpKneeBackMateElem = jQuery(this);
				tmpKneeBackMateElem.prop("disabled", disabledFlg);
			});
		});
	});

	// フロント仕様
	jQuery('input[name="coOptionPantsTuxedoInfo.tpFrontSpec"]').each(function() {
		jQuery(this).change(function(){
			// パンチェリーナ特殊制御
			tpPancherinaSpecialController();
		});
	});
	jQuery('input[id^="tp_frontSpec_id"]:checked').change();

	// ベルトループ
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoop"]').each(function() {
		jQuery(this).change(function(){
			// ベルトループ変更時処理
			tpChangedBeltLoop();
		});
	});
	// ベルトループ変更時処理
	tpChangedBeltLoop();

	// フラップ付コインポケット
	jQuery('input[name="coOptionPantsTuxedoInfo.tpFlapCoinPkt"]').each(function() {
		jQuery(this).change(function(){
			// ボタンホール色指定箇所の制御
			ctrlTpBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlTpByColorPlace();
	    });
	});

	// 上前ピスポケット
	jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktUf"]').each(function() {
		jQuery(this).change(function(){
			// ボタンホール色指定箇所の制御
			ctrlTpBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlTpByColorPlace();
		});
	});
	jQuery('#tp_pisPktUf_id1').change();

	// 下前ピスポケット
	jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktDf"]').each(function() {
		jQuery(this).change(function(){
			// ボタンホール色指定箇所の制御
			ctrlTpBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlTpByColorPlace();
		});
	});
	jQuery('#tp_pisPktDf_id1').change();

	// 裾上げ
	jQuery('#tp_hemUp').change(function() {

		// 現在の裾上げを取得
		var selectedHemUp = jQuery('#tp_hemUp').val();

		// ダブルがつくもの以外は非表示にする
		if (selectedHemUp == '0001702' || selectedHemUp == '0001703') {
			jQuery('#tp_doubleWide_div').show();
		} else {
			jQuery('#tp_doubleWide_div').hide();
			jQuery('input[id="tp_doubleWide"]').prop("disabled",true);
		}
	});

	// ボタンホール色指定(有り/無し)
	jQuery('input[id^="tp_bhColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var tp_bhColor = jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor"]:checked').val();

			if (tp_bhColor == '0002701') {
				// 無しの場合は操作不可
				jQuery('input[id^="tp_bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#tp_bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_tp_bhColorPlace').prop("disabled", true);
				jQuery('#tp_bhColor_div input[type="radio"]').each(function(index, elem){
					elem = jQuery(elem);
					if (elem.prop("checked")) {
						elem.removeAttr("checked");
					}
				})
				jQuery('#tp_bhColor_div input[type="checkbox"]').each(function(index, elem){
					elem = jQuery(elem);
					if (elem.prop("checked")) {
						elem.removeAttr("checked");
					}
				})
				// 無しの場合は2階層目を表示しない
				jQuery('#tp_bhColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタンホール色指定箇所の制御
				ctrlTpBhColorPlace();
				jQuery('input[id^="tp_bhColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#tp_bhColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_tp_bhColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#tp_bhColor_div').show();
			}
		});
	});
	jQuery('#tp_bhColor_id1').change();

	// ボタンホール色指定(全選択)
	jQuery('#btn_as_tp_bhColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#tp_bhColorPlaceAll').val();

		jQuery('#tp_bhColor_div input[type="checkBox"]').each(function(index, elemCheckBox){ 
			elemCheckBox = jQuery(elemCheckBox); 
			if(!elemCheckBox.prop("disabled")){ 
			var bhColorCheckBoxId = elemCheckBox.attr("id"); 
			jQuery('#'+bhColorCheckBoxId+'_div input[type="radio"]').each(function(index, elem){ 
			elem = jQuery(elem); 
			if (elem.val() == allColor) elem.prop('checked', true); 
			}); 
			} 
		}); 

	});

	// ボタンホール色指定箇所
	jQuery('input[id^="tp_bhColorPlace_"]').each(function() {
		jQuery(this).change(function(){
			if (jQuery(this).prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+this.id+'_div').show();
			} else {
				jQuery('#'+this.id+'_div input[type="radio"]').each(function(index, elem){ 
					elem = jQuery(elem); 
					if (elem.prop("checked")) { 
					elem.removeAttr("checked"); 
					elem.change(); 
					} 
				}) 

				// 選択されていない場合、色指定エリアを非表示
				jQuery('#'+this.id+'_div').hide();
			}
		});
	});
	// ボタンホール色指定箇所の制御
	ctrlTpBhColorPlace();

	// ボタン付け糸指定(有り/無し)
	jQuery('input[id^="tp_byColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var tp_byColor = jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor"]:checked').val();

			if (tp_byColor == '0003001') {
				// 無しの場合は操作不可
				jQuery('input[id^="tp_byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#tp_byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_tp_byColorPlace').prop("disabled", true);
				jQuery('#tp_byColor_div input[type="radio"]').each(function(index, elem){
					elem = jQuery(elem);
					if (elem.prop("checked")) {
						elem.removeAttr("checked");
					}
				})
				jQuery('#tp_byColor_div input[type="checkbox"]').each(function(index, elem){
					elem = jQuery(elem);
					if (elem.prop("checked")) {
						elem.removeAttr("checked");
					}
				})
				// 無しの場合は2階層目を表示しない
				jQuery('#tp_byColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタン付け糸指定箇所の制御
				ctrlTpByColorPlace();
				jQuery('input[id^="tp_byColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#tp_byColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_tp_byColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#tp_byColor_div').show();
			}
		});
	});
	jQuery('#tp_byColor_id1').change();

	// ボタン付け糸指定(全選択)
	jQuery('#btn_as_tp_byColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#tp_byColorPlaceAll').val();

		jQuery('#tp_byColor_div input[type="checkBox"]').each(function(index, elemCheckBox){ 
			elemCheckBox = jQuery(elemCheckBox); 
			if(!elemCheckBox.prop("disabled")){ 
			var byColorCheckBoxId = elemCheckBox.attr("id"); 
			jQuery('#'+byColorCheckBoxId+'_div input[type="radio"]').each(function(index, elem){ 
			elem = jQuery(elem); 
			if (elem.val() == allColor) elem.prop('checked', true); 
			}); 
			} 
		}); 
	});

	// ボタン付け糸指定箇所
	jQuery('input[id^="tp_byColorPlace_"]').each(function() {
		jQuery(this).change(function(){
			if (jQuery(this).prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+this.id+'_div').show();
			} else {
				jQuery('#'+this.id+'_div input[type="radio"]').each(function(index, elem){ 
					elem = jQuery(elem); 
					if (elem.prop("checked")) { 
					elem.removeAttr("checked"); 
					elem.change(); 
					} 
				})
				
				// 選択されていない場合、色指定エリアを非表示
				jQuery('#'+this.id+'_div').hide();
			}
		});
	});
	// ボタン付け糸指定箇所の制御
	ctrlTpByColorPlace();
	
	// 釦素材
	jQuery('#tp_btnMate').change(function (){
		var btnMate = jQuery('#tp_btnMate').val();

		// 釦品番
		var btnMateStkNoElem = jQuery('#tp_btnMateStkNo');

		// 選択肢をクリア
		btnMateStkNoElem.empty();

		if (btnMate == '包み') {
			jQuery('#tp_btnMateStkNo').hide();
			jQuery('#tp_btnMateStkNo').prop('disabled', true);
		} else if (btnMateStkNoList[btnMate]) {
			jQuery('#tp_btnMateStkNo').show();
			jQuery('#tp_btnMateStkNo').prop('disabled', false);
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < btnMateStkNoList[btnMate].length; i++) {
				btnMateStkNoElem.append(jQuery('<option />').val(btnMateStkNoList[btnMate][i]).text(btnMateStkNoList[btnMate][i]));
			}
		}
	});
	jQuery('#tp_btnMate').change();

	/*// 釦素材
	jQuery('#tp_button').change(function (){
		var btnMate = jQuery('#tp_button').val();

		// 釦品番
		var btnMateStkNoElem = jQuery('#tp_btnMateStkNo');

		// 選択肢をクリア
		btnMateStkNoElem.empty();

		if (btnMate == '包み') {
			jQuery('#tp_btnMateStkNo').hide();
			jQuery('#tp_btnMateStkNo').prop('disabled', true);
		} else if (btnMateStkNoList[btnMate]) {
			jQuery('#tp_btnMateStkNo').show();
			jQuery('#tp_btnMateStkNo').prop('disabled', false);
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < btnMateStkNoList[btnMate].length; i++) {
				btnMateStkNoElem.append(jQuery('<option />').val(btnMateStkNoList[btnMate][i]).text(btnMateStkNoList[btnMate][i]));
			}
		}
	});
	jQuery('#tp_button').change();*/

	// JKと同じボタン
	jQuery('#tp_sameJacketBtn').click(function(){

		// JACKETの釦素材を取得
		var jacketBtnMate = jQuery('#tj_btnMate').val();

		// JACKETの釦素材をPANTSの釦素材にコピー
		jQuery('#tp_button').val(jacketBtnMate);
		// 釦素材変更処理
		jQuery('#tp_button').change();

		// JACKETの釦品番を取得
		var jacketBtnMateStkNo = jQuery('#tj_btnMateStkNo').val();
		// JACKETの釦品番をPANTSの釦品番にコピー
		jQuery('#tp_btnMateStkNo').val(jacketBtnMateStkNo);
	});

	// 側章
	jQuery('input[id^="tp_sideStripe_"]').each(function() {
		jQuery(this).change(function(){

			// 選択中の側章
			var sideStripe = jQuery('input[name="coOptionPantsTuxedoInfo.tpSideStripe"]:checked').val();
			if (sideStripe == '0003902') {
				// 側章が有りの場合は側章幅を表示する
				jQuery('#tp_sideStripe_yes_area').show();
			} else {
				// 側章が無しの場合は側章幅を非表示にする
				jQuery('#tp_sideStripe_yes_area').hide();
			}
		});
	});
}

//--------------------------------------------
// 部品
//--------------------------------------------
//ボタンホール色指定箇所の有効/無効を制御する
function ctrlTpBhColorPlace() {

	// 選択中のボタンホール色指定
	var tp_bhColor = jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktDf"]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="coOptionPantsTuxedoInfo.tpFlapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#tp_bhColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (tp_bhColor == "0002702") {
			// 有りの場合は一旦有効化し、項目ごとに無効判定
			elem.prop("disabled", false);

			if (elem.val() == "0002902") {
				if (selectedPisPktUf == "0001404" || selectedPisPktUf == "0001405" || selectedPisPktUf == "0001406") {
					elem.prop("disabled", true);
				}
			} else if (elem.val() == "0002903") {
				if (selectedPisPktDf == "0001504" || selectedPisPktDf == '0001505' || selectedPisPktDf == '0001506') {
					elem.prop("disabled", true);
				}
			} else if (elem.val() == "0002904") {
				if (selectedFlapCoinPkt == '0001301') {
					elem.prop("disabled", true);
				}
			}

			// 判定結果が無効の場合、チェックを外す
			if (elem.prop("disabled")) {
				elem.prop("checked", false);
				elem.change();
			}
		} else {
			// 無しの場合は全て無効化
			elem.prop("disabled", true);
		}
	});

}

//ボタン付け糸指定箇所の有効/無効を制御する
function ctrlTpByColorPlace() {

	// 選択中のボタン付け糸指定
	var tp_byColor = jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktDf"]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="coOptionPantsTuxedoInfo.tpFlapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#tp_byColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (tp_byColor == "0003002") {
			// 有りの場合は一旦有効化し、項目ごとに無効判定
			elem.prop("disabled", false);

			if (elem.val() == "0003202") {
				if (selectedPisPktUf == "0001404" || selectedPisPktUf == "0001405" || selectedPisPktUf == "0001406") {
					elem.prop("disabled", true);
				}
			} else if (elem.val() == "0003203") {
				if (selectedPisPktDf == "0001504" || selectedPisPktDf == '0001505' || selectedPisPktDf == '0001506') {
					elem.prop("disabled", true);
				}
			} else if (elem.val() == "0003204") {
				if (selectedFlapCoinPkt == '0001301') {
					elem.prop("disabled", true);
				}
			}

			// 判定結果が無効の場合、チェックを外す
			if (elem.prop("disabled")) {
				elem.prop("checked", false);
				elem.change();
			}
		} else {
			// 無しの場合は全て無効化
			elem.prop("disabled", true);
		}
	});
}

//パンチェリーナの特殊制御
function tpPancherinaSpecialController() {

	// 現在選択中のPANTSモデル
	var selectedPantsModel = jQuery('#tp_pantsModel').val();

	// 現在選択中のパンチェリーナ
	var selectedPancherina = jQuery('input[name="coOptionPantsTuxedoInfo.tpPancherina"]:checked').val();

	// 特定のモデル以外はパンチェリーナ選択不可
	if (selectedPantsModel != 'TR02'
			&& selectedPantsModel != 'CH14'
			&& selectedPantsModel != 'NZ01'
			&& selectedPantsModel != 'JW21'
			&& selectedPantsModel != 'AY01') {

		jQuery('#tp_pancherina_id1').prop("disabled", false);
		jQuery('#tp_pancherina_id1').prop("checked", true);
		jQuery('#tp_pancherina_id1').change();
		jQuery('#tp_pancherina_id2').prop("disabled", true);

	} else {

		// 後続処理のために一旦パンチェリーナの選択肢を活性化させる
		jQuery('#tp_pancherina_id1').prop("disabled", false);
		jQuery('#tp_pancherina_id2').prop("disabled", false);

		// 現在のフロント仕様を取得
		var selectedFrontSpec = jQuery('input[name="coOptionPantsTuxedoInfo.tpFrontSpec"]:checked').val();

		// フロント仕様がホック留めの場合はパンチェリーナは無し固定
		if (selectedFrontSpec == '0000401') {
		} else {
			jQuery('#tp_pancherina_id2').prop('disabled', true);
			jQuery('#tp_pancherina_id1').prop('checked', true);
		}
	}

	// 処理後のパンチェリーナ
	jQuery('input[name="coOptionPantsTuxedoInfo.tpPancherina"]:checked').change();
}

//ベルトループ変更時処理
function tpChangedBeltLoop() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoop"]:checked').val();
	//var disabledFlg = false;

	if (selectedBeltLoop == '0000701') {
		// 表示
		jQuery('#tp_beltLoopPlace').show();
		jQuery("#tp_beltLoopPlace_id1").prop("checked", true);
		jQuery("#tp_beltLoopPlace_id2").prop("checked", true);
		jQuery("#tp_beltLoopPlace_id3").prop("checked", true);
		jQuery("#tp_beltLoopPlace_id4").prop("checked", true);
		jQuery("#tp_beltLoopPlace_id5").prop("checked", true);
		jQuery("#tp_beltLoopPlace_id6").prop("checked", true);
	} else {
		// 非表示
		jQuery('#tp_beltLoopPlace').hide();
		jQuery("#tp_beltLoopPlace_id1").prop("checked", false);
		jQuery("#tp_beltLoopPlace_id2").prop("checked", false);
		jQuery("#tp_beltLoopPlace_id3").prop("checked", false);
		jQuery("#tp_beltLoopPlace_id4").prop("checked", false);
		jQuery("#tp_beltLoopPlace_id5").prop("checked", false);
		jQuery("#tp_beltLoopPlace_id6").prop("checked", false);
		//disabledFlg = true;
	}

	// ピンループ設定でベルトループ有の場合に有りに設定する
	if (selectedBeltLoop == '0000701') {
		jQuery('#tp_pinLoop_id1').prop('checked', 'true');
		jQuery('#tp_pinLoop_id1').change();
	}	

	// フラシループ設定
	var frsAreaElem = jQuery('#tp_beltLoopPlace_id17');
	if (jQuery('#tp_pantsModel').val() == 'NZ01') {
		// 表示
		frsAreaElem.show();
		jQuery("#tp_beltLoopPlace_id7").prop("disabled",false);
	} else {
		jQuery("#tp_beltLoopPlace_id7").prop("disabled",true);
		jQuery("#tp_beltLoopPlace_id7").prop("checked", false);
		// 非表示
		frsAreaElem.hide();
	}

	// ピンループ特殊制御
	tpPinLoopSpecialController();
}

//ピンループ特殊制御
function tpPinLoopSpecialController() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoop"]:checked').val();
	// 選択中のピンループ
	var selectedPinLoop = jQuery('input[name="coOptionPantsTuxedoInfo.tpPinLoop"]:checked').val();

	if (selectedBeltLoop == '0000702') {
		// ベルトループ無しの場合はピンループ無し固定
		jQuery('input[id="tp_pinLoop_id1"]').prop("disabled", true);
		jQuery('input[id="tp_pinLoop_id2"]').prop("disabled", false);
		jQuery('input[id="tp_pinLoop_id2"]').prop("checked", true);
		jQuery('input[id="tp_pinLoop_id2"]').change();
	} else {
		jQuery('input[id="tp_pinLoop_id1"]').prop("disabled", false);
		jQuery('input[id="tp_pinLoop_id2"]').prop("disabled", false);
	}

	// 処理後のピンループ
	var changedPinLoop = jQuery('input[name="coOptionPantsTuxedoInfo.tpPinLoop"]:checked').val();
}


jQuery('#tp_coinPkt').change(function() {

	var selectedValue = jQuery('#tp_coinPkt').val();

		jQuery('#tp_flapCoinPkt_id2').prop('disabled', false);
	if (selectedValue == "0001201") {
		jQuery('#tp_flapCoinPkt_id1').prop('checked', true);
		jQuery('#tp_flapCoinPkt_id1').change();
		jQuery('#tp_flapCoinPkt_id2').prop('disabled', true);
	}
	
	
});
jQuery('#tp_coinPkt').change();

// アジャスター仕様変更時
jQuery('input[name="coOptionPantsTuxedoInfo.tpAdjuster"]').change(function(index, elem) {
	// 現在選択中のPANTSモデル
	var selectedPantsModel = jQuery('#tp_pantsModel').val();
	var selected = jQuery('input[name="coOptionPantsTuxedoInfo.tpAdjuster"]:checked').val();

	var oBLoopElemY = jQuery('#tp_beltLoop_id1');
	var oBLoopElemN = jQuery('#tp_beltLoop_id2');

	var oPLoopElemY = jQuery('#tp_pinLoop_id1');
	var oPLoopElemN = jQuery('#tp_pinLoop_id2');
	
	if(selectedPantsModel == 'AY01'){
		jQuery('#tp_beltLoop_id1').prop('disabled', true);
		switch(selected) {
		case "0000601": oBLoopElemN.prop("checked", true); break;
		case "0000602": oBLoopElemN.prop("checked", true); break;
		case "0000603": oBLoopElemN.prop("checked", true); break;
		case "0000604": oBLoopElemY.prop("checked", true); break;
		default:oBLoopElemN.prop("checked", true);
		}
		switch(selected) {
		case "0000601": oPLoopElemN.prop("checked", true); break;
		case "0000602": oPLoopElemN.prop("checked", true); break;
		case "0000603": oPLoopElemN.prop("checked", true); break;
		case "0000604": oPLoopElemY.prop("checked", true); break;
		default:oPLoopElemN.prop("checked", true);
		}
	}
	else {
		switch(selected) {
		case "0000601": oBLoopElemY.prop("checked", true); break;
		case "0000602": oBLoopElemN.prop("checked", true); break;
		case "0000603": oBLoopElemN.prop("checked", true); break;
		case "0000604": oBLoopElemY.prop("checked", true); break;
		default:oBLoopElemN.prop("checked", true);
		}
		switch(selected) {
		case "0000601": oPLoopElemY.prop("checked", true); break;
		case "0000602": oPLoopElemN.prop("checked", true); break;
		case "0000603": oPLoopElemN.prop("checked", true); break;
		case "0000604": oPLoopElemY.prop("checked", true); break;
		default:oPLoopElemN.prop("checked", true);
		}
		
		if(selectedPantsModel == 'NZ01'){
			if(selected == '0000604'){
				jQuery('#tp_sidePkt_id1').prop('disabled',true);
				jQuery('#tp_sidePkt_id2').prop('checked',true);
				jQuery('#tp_sidePkt_id2').change();
			}
			else {
				jQuery('#tp_sidePkt_id1').prop('disabled',false);
			}
		}
		else {
			jQuery('#tp_sidePkt_id1').prop('disabled',false);
		}
	}
	
	jQuery('input[id^="tp_beltLoop_id"]:checked').change();
	tpChangedBeltLoop();

});
jQuery('#tp_adjuster_id1').change();

function modelCheck(modelCode,productFabricNo,orderPattern,itemCode,subItemCode){
	var checkResult = jQuery.ajax({url:contextPath + "/orderCo/checkModel",data:{"modelCode":modelCode,"productFabricNo":productFabricNo,"orderPattern":orderPattern,"itemCode":itemCode,"subItemCode":subItemCode},async:false});
	checkResult = checkResult.responseText;
	return checkResult;
}