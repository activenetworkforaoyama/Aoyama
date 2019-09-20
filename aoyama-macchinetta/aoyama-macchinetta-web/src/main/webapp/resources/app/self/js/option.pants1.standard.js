/*********************************************
 * 標準PANTS1用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionPants1Standard() {

	// PANTSモデル
	jQuery('#op_pantsModel').change(function() {
		// 選択されたPantsモデルを取得
		var pantsModel = jQuery(this).val();
		
		if (pantsModel == '' || pantsModel == null) {
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
				jQuery("#op_pantsModelCheck").empty();
				jQuery("#fabricMsg").empty();
			}else if(checkResult == "false"){
				//2はモデルチェク失敗の場合
				jQuery("#ptModelFlag").val("1"+"*"+getMsgByOneArg('msg065','PANTS'));
				appendAlertPo('op_pantsModelCheck',getMsgByOneArg('msg065','PANTS'));
			}
		}

		// 選択中のタック
		var tackElem = jQuery('#op_tack');
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
		jQuery('input[name="coOptionPantsStandardInfo.opFrontSpec"]').val([sFrontSpec]);

		// パンチェリーナ特殊制御
		pancherinaSpecialController();
		

		// 選択中のアジャスター仕様
		var selectedAdjuster = jQuery('input[name="coOptionPantsStandardInfo.opAdjuster"]:checked').val();

		// アジャスター仕様の選択肢制御
		var beforeAdjuster = false;
		jQuery('input[id^="op_adjuster_"]').each(function() {
			var tmpOpAdjusterElem = jQuery(this);
			var value = tmpOpAdjusterElem.val();

			if (adjusterList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なアジャスター仕様の場合、有効化
				tmpOpAdjusterElem.prop("disabled", false);
				if (selectedAdjuster == value) {
					beforeAdjuster = true;	
				}
			} else {
				// 有効なアジャスター仕様ではない場合、無効化
				tmpOpAdjusterElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name="coOptionPantsStandardInfo.opAdjuster"]').val([adjusterList[pantsModel].defaultValue]);

		// 選択中のベルトループ
		var selectedBeltLoop = jQuery('input[name="coOptionPantsStandardInfo.opBeltLoop"]:checked').val();

		// ベルトループの選択肢制御
		jQuery('input[id^="op_beltLoop_"]').each(function() {
			var tmpOpBeltLoopElem = jQuery(this);
			var value = tmpOpBeltLoopElem.val();

			if (beltLoopList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なベルトループの場合、有効化
				tmpOpBeltLoopElem.prop("disabled", false);
			} else {
				// 有効なベルトループではない場合、無効化
				tmpOpBeltLoopElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name="coOptionPantsStandardInfo.opBeltLoop"]').val([beltLoopList[pantsModel].defaultValue]);
		jQuery('input[name="coOptionPantsStandardInfo.opBeltLoop"]').change();

		// ベルトループ変更時処理
		changedBeltLoop();

		// 選択中の脇ポケット
		var sidePktElem = jQuery('input[name="coOptionPantsStandardInfo.opSidePkt"]:checked');
		var selectedSidePkt = sidePktElem.val();

		// モデルに基づくデフォルトの脇ポケット
		var modelSidePkt = pantsModelDefaultList[pantsModel].op_sidePkt;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsStandardInfo.opSidePkt"]').val([modelSidePkt]);

		// 選択中の忍びポケット
		var sinobiPktElem = jQuery('input[name="coOptionPantsStandardInfo.opSinobiPkt"]:checked');
		var selectedSinobiPkt = sinobiPktElem.val();

		// モデルに基づくデフォルトの忍びポケット
		var modelSinobiPkt = pantsModelDefaultList[pantsModel].op_sinobiPkt;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsStandardInfo.opSinobiPkt"]').val([modelSinobiPkt]);

		// モデルに基づくデフォルトのコインポケット
		var modelCoinPkt = pantsModelDefaultList[pantsModel].op_coinPkt;
		// デフォルトを選択
//		jQuery('input[name=op_coinPkt]').val([modelCoinPkt]);
		jQuery('#op_coinPkt').val([modelCoinPkt]);
		jQuery('#op_coinPkt').change();

		// 選択中の上前ピスポケット
		var pisPktUf = jQuery('input[name="coOptionPantsStandardInfo.opPisPktUf"]:checked');
		var selectedPisPktUf = pisPktUf.val();

		// モデルに基づくデフォルトの上前ピスポケット
		var modelPisPktUf = pantsModelDefaultList[pantsModel].op_pisPktUf;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsStandardInfo.opPisPktUf"]').val([modelPisPktUf]);
		jQuery('input[name="coOptionPantsStandardInfo.opPisPktUf"]').change();

		// 選択中の下前ピスポケット
		var pisPktDf = jQuery('input[name="coOptionPantsStandardInfo.opPisPktDf"]:checked');
		var selectedPisPktDf = pisPktDf.val();

		// モデルに基づくデフォルトの下前ピスポケット
		var modelPisPktDf = pantsModelDefaultList[pantsModel].op_pisPktDf;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsStandardInfo.opPisPktDf"]').val([modelPisPktDf]);
		jQuery('input[name="coOptionPantsStandardInfo.opPisPktDf"]').change();

		// 選択中のVカット
		var vCut = jQuery('input[name="coOptionPantsStandardInfo.opVCut"]:checked');
		var selectedVCut = vCut.val();

		// モデルに基づくデフォルトのVカット
		var modelVCut = pantsModelDefaultList[pantsModel].op_vCut;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsStandardInfo.opVCut"]').val([modelVCut]);

		// ステッチ箇所変更
		ctrlOpStitchModify();
		ctrlOpStitchModifyPisFlap();

		// ダブルステッチ
		ctrlOpDStitch();
		ctrlOpDStitchPlace();

		// AMF色指定の有効/無効を制御する
		ctrlOpAmfColor();

		// 別モデルに変更された場合はアラート表示
		if ((tmpOpPantsModel != '' || tmpOpPantsModel != null) && pantsModel != tmpOpPantsModel) {
//		    appendAlert('op_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		    setAlert('op_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		}
		// 一時保存のモデルを更新
		tmpOpPantsModel = pantsModel;
	});

	// 膝裏
	jQuery('input[name="coOptionPantsStandardInfo.opKneeBack"]').each(function() {
		jQuery(this).change(function(){

			// 現在の膝裏を取得
			var selectedKneeBack = jQuery('input[name="coOptionPantsStandardInfo.opKneeBack"]:checked').val();
			var disabledFlg = false;

			// 0000202(無し)
			if (selectedKneeBack == '0000202') {
				disabledFlg = true;
				jQuery('#op_kneeBackMate_div').hide();
			} else {
				jQuery('#op_kneeBackMate_div').show();
			}

			// 膝裏が無しの場合は膝裏素材を全て選択不可
			jQuery('input[id^="op_kneeBackMate_"]').each(function() {
				var tmpKneeBackMateElem = jQuery(this);
				tmpKneeBackMateElem.prop("disabled", disabledFlg);
			});
		});
	});

	// フロント仕様
	jQuery('input[name="coOptionPantsStandardInfo.opFrontSpec"]').each(function() {
		jQuery(this).change(function(){
			// パンチェリーナ特殊制御
			pancherinaSpecialController();
		});
	});
	jQuery('#op_frontSpec_id1').change();

	// ベルトループ
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoop"]').each(function() {
		jQuery(this).change(function(){
			// ベルトループ変更時処理
			changedBeltLoop();
		});
	});
	changedBeltLoop();

	// フラップ付コインポケット
	jQuery('input[name="coOptionPantsWashableInfo.wpFlapCoinPkt"]').each(function() {
		jQuery(this).change(function(){
			// ボタンホール色指定箇所の制御
			ctrlOpBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlOpByColorPlace();
	    });
	});

	// 上前ピスポケット
	jQuery('input[name="coOptionPantsStandardInfo.opPisPktUf"]').each(function() {
		jQuery(this).change(function(){
			// ステッチ箇所変更(ピスフラップ)の制御
			ctrlOpStitchModifyPisFlap();
			// ダブルステッチ(選択肢)の制御
			ctrlOpDStitchPlace();
			// ボタンホール色指定箇所の制御
			ctrlOpBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlOpByColorPlace();
		});
	});
	jQuery('#op_pisPktUf_id1').change();

	// 下前ピスポケット
	jQuery('input[name="coOptionPantsStandardInfo.opPisPktDf"]').each(function() {
		jQuery(this).change(function(){
			// ステッチ箇所変更(ピスフラップ)の制御
			ctrlOpStitchModifyPisFlap();
			// ダブルステッチ(選択肢)の制御
			ctrlOpDStitchPlace();
			// ボタンホール色指定箇所の制御
			ctrlOpBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlOpByColorPlace();
		});
	});
	jQuery('#op_pisPktDf_id1').change();

	// 裾上げ
	jQuery('#op_hemUp').change(function() {

		// 現在の裾上げを取得
		var selectedHemUp = jQuery('#op_hemUp').val();

		// ダブルがつくもの以外は非表示にする
		if (selectedHemUp == '0001702' || selectedHemUp == '0001703') {
			jQuery('#op_doubleWide_div').show();
		} else {
			jQuery('#op_doubleWide_div').hide();
			jQuery('input[id="op_doubleWide"]').prop("disabled",true);
		}
	});

	// AMFステッチ
	jQuery('input[name="coOptionPantsStandardInfo.opStitch"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のAMFステッチ
			var stitchValue = jQuery('input[name="coOptionPantsStandardInfo.opStitch"]:checked').val();

			// 0001903(無し)
			if (stitchValue != "0001903") {
				// 有りの場合、関連する項目を有効化
				// ステッチ箇所変更
				jQuery('input[name="coOptionPantsStandardInfo.opStitchModify"]').prop("disabled", false);

				// ダブルステッチ
				jQuery('input[name="coOptionPantsStandardInfo.opDStitch"]').prop("disabled", false);

				// AMF色指定
				jQuery('input[name="coOptionPantsStandardInfo.opAmfColor"]').prop("disabled", false);

				// 関連項目を表示
				jQuery('#op_stitch_yes_area').show();
			} else {
				// 無しの場合、関連する項目を無効化・値変更
				// ステッチ箇所変更
				jQuery('input[name="coOptionPantsStandardInfo.opStitchModify"]').prop("disabled", true);
				jQuery('#op_stitchModify_id1').prop("checked", true);
				jQuery('#op_stitchModify_id1').change();

				// ダブルステッチ
				jQuery('input[name="coOptionPantsStandardInfo.opDStitch"]').prop("disabled", true);
				jQuery('#op_dStitch_id1').prop("checked", true);
				jQuery('#op_dStitch_id1').change();

				// AMF色指定
				jQuery('input[name="coOptionPantsStandardInfo.opAmfColor"]').prop("disabled", true);
				jQuery('#op_amfColor_id1').prop("checked", true);
				jQuery('#op_amfColor_id1').change();

				// 関連項目を非表示
				jQuery('#op_stitch_yes_area').hide();
			}

			// ダブルステッチの特殊制御
			dStichSpecialController();
		});
	});

	// ステッチ箇所変更
	jQuery('input[name="coOptionPantsStandardInfo.opStitchModify"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のステッチ箇所変更
			var stitchModifyValue = jQuery('input[name="coOptionPantsStandardInfo.opStitchModify"]:checked').val();

			// 0002001(無し)
			if (stitchModifyValue == "0002001") {
				// 無しの場合は全て無効化
				jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace"]').prop("disabled", true);
				jQuery('#btn_as_op_stitchModifyPlace').prop("disabled", true);
				jQuery('#btn_ar_op_stitchModifyPlace').prop("disabled", true);
				jQuery('#op_stitchModify_yes_area').hide();
			} else {
				// 有りの場合は全て有効化
				jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace"]').prop("disabled", false);
				jQuery('#btn_as_op_stitchModifyPlace').prop("disabled", false);
				jQuery('#btn_ar_op_stitchModifyPlace').prop("disabled", false);
				jQuery('#op_stitchModify_yes_area').show();
			}

			// ステッチ箇所変更の制御
			ctrlOpStitchModify();
			ctrlOpStitchModifyPisFlap();

			// ダブルステッチ
			ctrlOpDStitch();
			ctrlOpDStitchPlace();

			// AMF色指定の有効/無効を制御する
			ctrlOpAmfColor();
		});
	});
	jQuery('#op_stitchModify_id1').change();

	// ステッチ箇所変更(選択肢)
	jQuery('input[id^="op_stitchModifyPlace_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のダブルステッチ変更
			ctrlOpDStitchPlace();
			// AMF色指定の有効/無効を制御する
			ctrlOpAmfColor();
		});
	});

	// ダブルステッチ
	jQuery('input[name="coOptionPantsStandardInfo.opDStitch"]').each(function() {
		jQuery(this).change(function(){
			ctrlOpDStitch();
			ctrlOpDStitchPlace();
		});
	});
	jQuery('#op_dStitch_id1').change();

	// AMF色指定(有り/無し)
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor"]').each(function() {
		jQuery(this).change(function(){
			ctrlOpAmfColor();
		});
	});
	ctrlOpAmfColor();

	// AMF色指定(全選択)
	jQuery('#btn_as_op_amfColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#op_amfColorPlaceAll').val();

		jQuery('#op_amfColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// AMF色指定箇所
	jQuery('input[id^="op_amfColorPlace_"]').each(function() {
		jQuery(this).change(function(){
			if (jQuery(this).prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+this.id+'_div').show();
			} else {
				// 選択されていない場合、色指定エリアを非表示
				jQuery('#'+this.id+'_div').hide();
			}
		});
	});

	// ボタンホール色指定(有り/無し)
	jQuery('input[id^="op_bhColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var op_bhColor = jQuery('input[name="coOptionPantsStandardInfo.opBhColor"]:checked').val();

			if (op_bhColor == '0002701') {
				// 無しの場合は操作不可
				jQuery('input[id^="op_bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#op_bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_op_bhColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#op_bhColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタンホール色指定箇所の制御
				ctrlOpBhColorPlace();
				jQuery('input[id^="op_bhColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#op_bhColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_op_bhColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#op_bhColor_div').show();
			}
		});
	});
	jQuery('#op_bhColor_id1').change();

	// ボタンホール色指定(全選択)
	jQuery('#btn_as_op_bhColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#op_bhColorPlaceAll').val();

		jQuery('#op_bhColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタンホール色指定箇所
	jQuery('input[id^="op_bhColorPlace_"]').each(function() {
		jQuery(this).change(function(){
			if (jQuery(this).prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+this.id+'_div').show();
			} else {
				// 選択されていない場合、色指定エリアを非表示
				jQuery('#'+this.id+'_div').hide();
			}
		});
	});
	// ボタンホール色指定箇所の制御
	ctrlOpBhColorPlace();

	// ボタン付け糸指定(有り/無し)
	jQuery('input[id^="op_byColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var op_byColor = jQuery('input[name="coOptionPantsStandardInfo.opByColor"]:checked').val();

			if (op_byColor == '0003001') {
				// 無しの場合は操作不可
				jQuery('input[id^="op_byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#op_byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_op_byColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#op_byColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタン付け糸指定箇所の制御
				ctrlOpByColorPlace();
				jQuery('input[id^="op_byColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#op_byColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_op_byColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#op_byColor_div').show();
			}
		});
	});
	jQuery('#op_byColor_id1').change();

	// ボタン付け糸指定(全選択)
	jQuery('#btn_as_op_byColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#op_byColorPlaceAll').val();

		jQuery('#op_byColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタン付け糸指定箇所
	jQuery('input[id^="op_byColorPlace_"]').each(function() {
		jQuery(this).change(function(){
			if (jQuery(this).prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+this.id+'_div').show();
			} else {
				// 選択されていない場合、色指定エリアを非表示
				jQuery('#'+this.id+'_div').hide();
			}
		});
	});
	// ボタン付け糸指定箇所の制御
	ctrlOpByColorPlace();

	/*// 釦素材
	jQuery('#op_button').change(function (){
		var btnMate = jQuery('#op_button').val();

		// 釦品番
		var btnMateStkNoElem = jQuery('#op_btnMateStkNo');

		// 選択肢をクリア
		btnMateStkNoElem.empty();

		if (btnMateStkNoList[btnMate]) {
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < btnMateStkNoList[btnMate].length; i++) {
				btnMateStkNoElem.append(jQuery('<option />').val(btnMateStkNoList[btnMate][i]).text(btnMateStkNoList[btnMate][i]));
			}
		}
	});
	jQuery('#op_button').change();*/

	// JKと同じボタン
	jQuery('#op_sameJacketBtn').click(function(){

		// JACKETの釦素材を取得
		var jacketBtnMate = jQuery('#btnMate').val();

		// JACKETの釦素材をPANTSの釦素材にコピー
		jQuery('#op_btnMate').val(jacketBtnMate);
		// 釦素材変更処理
		jQuery('#op_btnMate').change();

		// JACKETの釦品番を取得
		var jacketBtnMateStkNo = jQuery('#btnMateStkNo').val();
		// JACKETの釦品番をPANTSの釦品番にコピー
		jQuery('#op_btnMateStkNo').val(jacketBtnMateStkNo);
	});
}

//--------------------------------------------
// 部品
//--------------------------------------------
// ボタンホール色指定箇所の有効/無効を制御する
function ctrlOpBhColorPlace() {

	// 選択中のボタンホール色指定
	var op_bhColor = jQuery('input[name="coOptionPantsStandardInfo.opBhColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name="coOptionPantsStandardInfo.opPisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name="coOptionPantsStandardInfo.opPisPktDf"]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="coOptionPantsStandardInfo.opFlapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#op_bhColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (op_bhColor == "0002702") {
			// 有りの場合は一旦有効化し、項目ごとに無効判定
			elem.prop("disabled", false);

			if (elem.val() == "0002902") {
				if (selectedPisPktUf == "0001402" || selectedPisPktUf == "0001404") {
					elem.prop("disabled", true);
				}
			} else if (elem.val() == "0002903") {
				if (selectedPisPktDf == "0001502" || selectedPisPktDf == '0001504') {
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

// ボタン付け糸指定箇所の有効/無効を制御する
function ctrlOpByColorPlace() {

	// 選択中のボタン付け糸指定
	var op_byColor = jQuery('input[name="coOptionPantsStandardInfo.opByColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name="coOptionPantsStandardInfo.opPisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name="coOptionPantsStandardInfo.opPisPktDf"]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="coOptionPantsStandardInfo.opFlapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#op_byColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (op_byColor == "0003002") {
			// 有りの場合は一旦有効化し、項目ごとに無効判定
			elem.prop("disabled", false);

			if (elem.val() == "0003202") {
				if (selectedPisPktUf == "0001402" || selectedPisPktUf == "0001404") {
					elem.prop("disabled", true);
				}
			} else if (elem.val() == "0003203") {
				if (selectedPisPktDf == "0001502" || selectedPisPktDf == '0001504') {
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

// パンチェリーナの特殊制御
function pancherinaSpecialController() {

	// 現在選択中のPANTSモデル
	var selectedPantsModel = jQuery('#op_pantsModel').val();

	// 現在選択中のパンチェリーナ
	var selectedPancherina = jQuery('input[name="coOptionPantsStandardInfo.opPancherina"]:checked').val();

	// 特定のモデル以外はパンチェリーナ選択不可
	if (selectedPantsModel != 'TR02'
			&& selectedPantsModel != 'CH14'
			&& selectedPantsModel != 'NZ01'
			&& selectedPantsModel != 'JW21'
			&& selectedPantsModel != 'AY01') {
		
		jQuery('#op_pancherina_id1').prop("disabled", true);
		jQuery('#op_pancherina_id1').prop("checked", true);
		jQuery('#op_pancherina_id1').change();
		jQuery('#op_pancherina_id2').prop("disabled", true);

	} else {
		// 後続処理のために一旦パンチェリーナの選択肢を活性化させる
		jQuery('#op_pancherina_id1').prop("disabled", false);
		jQuery('#op_pancherina_id2').prop("disabled", false);

		// 現在のフロント仕様を取得
		var selectedFrontSpec = jQuery('input[name="coOptionPantsStandardInfo.opFrontSpec"]:checked').val();

		// フロント仕様がホック留めの場合はパンチェリーナは無し固定
		if (selectedFrontSpec == '0000401') {
		} else {
			jQuery('#op_pancherina_id2').prop('disabled', true);
			jQuery('#op_pancherina_id1').prop('checked', true);
		}
	}

	// 処理後のパンチェリーナ
	var changedPancherina = jQuery('input[name="coOptionPantsStandardInfo.opPancherina"]:checked').val();
}

// ベルトループ変更時処理
function changedBeltLoop() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="coOptionPantsStandardInfo.opBeltLoop"]:checked').val();
	var disabledFlg = false;

	if (selectedBeltLoop == '0000701') {
		// 表示
		jQuery('#op_beltLoopPlace').show();
	} else {
		// 非表示
		jQuery('#op_beltLoopPlace').hide();
		disabledFlg = true;
	}

	// ベルトループ項目の活性/非活性
	jQuery('input[id^="op_beltLoopPlace_"]').each(function() {
		var tmpBeltLoopElem = jQuery(this);
		tmpBeltLoopElem.prop("disabled", disabledFlg);
		if (!disabledFlg) {
			tmpBeltLoopElem.prop("checked", true);
		}
	});

	// ピンループ設定 ※アジャスター仕様が小でベルトループ有の場合に無しに設定する
	if (selectedBeltLoop == '0000701') {
		if (jQuery('input[name="coOptionPantsStandardInfo.opAdjuster"]:checked').val() == '0000603') {
			jQuery('#op_pinLoop_id2').prop('checked', 'true');
		}
	}	

	// フラシループ設定
	var frsAreaElem = jQuery('#op_beltLoopPlace_id17');
	if (jQuery('#op_pantsModel').val() == 'NZ01') {
		// 表示
		frsAreaElem.show();
	} else {
		jQuery("#op_beltLoopPlace_id7").prop("checked", false);
		// 非表示
		frsAreaElem.hide();
	}

	// ピンループ特殊制御
	pinLoopSpecialController();
}

// ピンループ特殊制御
function pinLoopSpecialController() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="coOptionPantsStandardInfo.opBeltLoop"]:checked').val();
	// 選択中のピンループ
	var selectedPinLoop = jQuery('input[name="coOptionPantsStandardInfo.opPinLoop"]:checked').val();

	if (selectedBeltLoop == '0000702') {
		// ベルトループ無しの場合はピンループ無し固定
		jQuery('input[id="op_pinLoop_id1"]').prop("disabled", true);
		jQuery('input[id="op_pinLoop_id2"]').prop("disabled", false);
		jQuery('input[id="op_pinLoop_id2"]').prop("checked", true);
	} else {
		jQuery('input[id="op_pinLoop_id1"]').prop("disabled", false);
		jQuery('input[id="op_pinLoop_id2"]').prop("disabled", false);
	}

	// 処理後のピンループ
	var changedPinLoop = jQuery('input[name="coOptionPantsStandardInfo.opPinLoop"]:checked').val();
}

// ダブルステッチの特殊制御を行う
function dStichSpecialController() {

	// 選択中のAMFステッチ
	var selectedStich = jQuery('input[name="coOptionPantsStandardInfo.opStitch"]:checked').val();

	// AMFステッチが有りの場合はダブルステッチを有効化する
	if (selectedStich == '0001904') {
		jQuery('input[name="coOptionPantsStandardInfo.opDStitch"]').prop("disabled", false);
	} else {
		jQuery('input[name="coOptionPantsStandardInfo.opDStitch"]').prop("disabled", true);
		jQuery('input[id="op_dStitch_id1"]').prop("checked", true);
	}
}

// ステッチ箇所変更の有効/無効を制御する
function ctrlOpStitchModify() {

	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="coOptionPantsStandardInfo.opStitchModify"]:checked').val();

	// ステッチ箇所変更の有無で下位階層の表示制御
	if (stitchModifyValue != '0002001') {
		jQuery('#op_stitchModify_yes_area').show();
	} else {
		jQuery('#op_stitchModify_yes_area').hide();
	}

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#op_pantsModel').val();

	if (!opStitchModifyList[pantsModel]) {
		// Pantsモデルが定義にない場合はすべて変更不可
		jQuery('input[id^="op_stitchModifyPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		});
		return;
	}

	var tmpStitchModifyPlace = null;
	var stitchModifyDef = null;
	var tmpStitchModify = null;
	for (tmpStitchModifyPlace in opStitchModifyList[pantsModel]) {
		// 定義取得
		stitchModifyDef = opStitchModifyList[pantsModel][tmpStitchModifyPlace];
		// 要素取得
		tmpStitchModify = jQuery('#op_stitchModifyPlace_'+tmpStitchModifyPlace);

		// 有効無効設定
		if (stitchModifyValue == '0002002') {
			// 有りの場合、定義に基づいて設定変更
			tmpStitchModify.prop("disabled", false);
			// チェック状態の設定
			tmpStitchModify.prop("checked", stitchModifyDef.default);
		} else {
			tmpStitchModify.prop("disabled", true);
		}
	}

	// 全選択・全解除ボタン
	if (stitchModifyValue == '0002002') {
		jQuery('#btn_as_op_stitchModifyPlace').prop("disabled", false);
		jQuery('#btn_ar_op_stitchModifyPlace').prop("disabled", false);
	} else {
		jQuery('#btn_as_op_stitchModifyPlace').prop("disabled", true);
		jQuery('#btn_ar_op_stitchModifyPlace').prop("disabled", true);
	}
}

//ステッチ箇所変更(ピスフラップ)の有効/無効を制御する
function ctrlOpStitchModifyPisFlap() {

	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="coOptionPantsStandardInfo.opStitchModify"]:checked').val();

	// ステッチ箇所変更無しの場合は処理終了
	if (stitchModifyValue == '0002001') {
		return;
	}

	// ピスフラップの要素取得
	stitchModifyPisFlap = jQuery('#op_stitchModifyPlace_id4');

	// 選択中の上前ピスポケット
	var pisPktUf = jQuery('input[name="coOptionPantsStandardInfo.opPisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var pisPktDf = jQuery('input[name="coOptionPantsStandardInfo.opPisPktDf"]:checked').val();

	// 上前ピスポケットと下前ピスポケットのどちらかがフラップ/ボタン有の場合は選択可
	if (pisPktUf == '0001403' || pisPktDf == '0001503') {
		stitchModifyPisFlap.prop("disabled", false);
	} else {
		stitchModifyPisFlap.prop("disabled", true);
		stitchModifyPisFlap.prop("checked", false);
	}
}

//ダブルステッチの有効/無効を制御する
function ctrlOpDStitch() {
	// 選択中のステッチ箇所変更
	var dStitchValue = jQuery('input[name="coOptionPantsStandardInfo.opDStitch"]:checked').val();

	if (dStitchValue == "0002202") {
		jQuery('#op_dStitch_yes_area').show();
	} else {
		jQuery('#op_dStitch_yes_area').hide();
	}

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#op_pantsModel').val();

	if (!opStitchModifyList[pantsModel]) {
		// Pantsモデルが定義にない場合はすべて変更不可
		jQuery('input[id^="op_dStitchPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		});
		return;
	}

	var tmpStitchModifyPlace = null;
	var stitchModifyDef = null;
	var tmpStitchModify = null;
	for (tmpStitchModifyPlace in opStitchModifyList[pantsModel]) {
		// 定義取得
		stitchModifyDef = opStitchModifyList[pantsModel][tmpStitchModifyPlace];
		// 要素取得
		tmpStitchModify = jQuery('#op_dStitchPlace_'+tmpStitchModifyPlace);

		// 有効無効設定
		if (dStitchValue == '0002202') {
			// 有りの場合、定義に基づいて設定変更
			tmpStitchModify.prop("disabled", false);
			// チェック状態の設定
			tmpStitchModify.prop("checked", stitchModifyDef.default);
		} else {
			// 無しの場合、無効にする
			tmpStitchModify.prop("disabled", true);
		}
	}
}

//ダブルステッチ(選択肢)の有効/無効を制御する
function ctrlOpDStitchPlace() {

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#op_pantsModel').val();
	if (pantsModel == '' || pantsModel == null) {
		// 未選択時は何もしない
		return;
	}

	// 選択中のステッチ箇所変更
	var dStitchValue = jQuery('input[name="coOptionPantsStandardInfo.opDStitch"]:checked').val();

	var tmpStitchModifyPlace = null;
	var tmpStitchModify = null;
	var stichModifyChecked = false;

	for (tmpStitchModifyPlace in opStitchModifyList[pantsModel]) {
		// 定義取得
		stitchModifyDef = opStitchModifyList[pantsModel][tmpStitchModifyPlace];
		// ダブルステッチ要素取得
		tmpStitchModify = jQuery('#op_dStitchPlace_'+tmpStitchModifyPlace);
		// ステッチ箇所変更要素取得
		stichModifyChecked = jQuery('#op_stitchModifyPlace_'+tmpStitchModifyPlace).prop("checked");

		// 有効無効設定
		if (dStitchValue == '0002202' && stichModifyChecked) {
			// 有りの場合、定義に基づいて設定変更
			tmpStitchModify.prop("disabled", false);
		} else {
			// 無しの場合、無効にする
			tmpStitchModify.prop("disabled", true);
			tmpStitchModify.prop("checked", false);
		}
	}
}

// AMF色指定の有効/無効を制御する
function ctrlOpAmfColor() {
	// 選択中のステッチ箇所変更
	var amfColorValue = jQuery('input[name="coOptionPantsStandardInfo.opAmfColor"]:checked').val();

	if (amfColorValue == "0002402") {
		jQuery('#op_amfColor_div').show();
	} else {
		jQuery('#op_amfColor_div').hide();
	}

	// AMF色指定の有効/無効設定
	jQuery('input[id^="op_amfColorPlace_"]').each(function() {
		if (amfColorValue == "0002402") {
			// 有りの場合はステッチ箇所変更に基づく
			var id = this.id;
			id = id.replace("op_amfColorPlace_", "op_stitchModifyPlace_id");
			if (jQuery('#'+id).prop("checked")) {
				jQuery(this).prop("disabled", false);
			} else {
				jQuery(this).prop("disabled", true);
				jQuery(this).prop("checked", false);
			}
		} else {
			// 無しの場合は変更不可
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		}
		jQuery(this).change();
	});
}

jQuery('#op_coinPkt').change(function() {

	var selectedValue = jQuery('#op_coinPkt').val();

		jQuery('#op_flapCoinPkt_id2').prop('disabled', false);
	if (selectedValue == "0001201") {
		jQuery('#op_flapCoinPkt_id1').prop('checked', true);
		jQuery('#op_flapCoinPkt_id2').prop('disabled', true);
	}
	
	
});
jQuery('#op_coinPkt').change();

// アジャスター仕様変更時
jQuery('input[name="coOptionPantsStandardInfo.opAdjuster"]').change(function(index, elem) {
	var selected = jQuery('input[name="coOptionPantsStandardInfo.opAdjuster"]:checked').val();

	var oBLoopElemY = jQuery('#op_beltLoop_id1');
	var oBLoopElemN = jQuery('#op_beltLoop_id2');

	var oPLoopElemY = jQuery('#op_pinLoop_id1');
	var oPLoopElemN = jQuery('#op_pinLoop_id2');
	
	switch(selected) {
		case "0000601"                : oBLoopElemY.prop("checked", true); break;
		case "0000602": oBLoopElemN.prop("checked", true); break;
		case "0000603": oBLoopElemN.prop("checked", true); break;
		case "0000604"        : oBLoopElemY.prop("checked", true); break;
		default:oBLoopElemN.prop("checked", true);
	}
	switch(selected) {
		case "0000601"                : oPLoopElemY.prop("checked", true); break;
		case "0000602": oPLoopElemN.prop("checked", true); break;
		case "0000603": oPLoopElemN.prop("checked", true); break;
		case "0000604"        : oPLoopElemY.prop("checked", true); break;
		default:oPLoopElemN.prop("checked", true);
	}
	changedBeltLoop();

});
jQuery('#op_adjuster_id1').change();



function modelCheck(modelCode,productFabricNo,orderPattern,itemCode,subItemCode){
	var checkResult = jQuery.ajax({url:contextPath + "/orderCo/checkModel",data:{"modelCode":modelCode,"productFabricNo":productFabricNo,"orderPattern":orderPattern,"itemCode":itemCode,"subItemCode":subItemCode},async:false});
	checkResult = checkResult.responseText;
	return checkResult;
}