/*********************************************
 * タキシードPANTS1用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionPants1Tuxedo() {

	// PANTSモデル
	jQuery('#tp_pantsModel').change(function() {
		// 選択されたPantsモデルを取得
		var pantsModel = jQuery(this).val();

		if (pantsModel == '' || pantsModel == null) {
			// 未選択時は何もしない
			return;
		}

		// 選択中のタック
		var tackElem = jQuery('#tp_tack');
		var selectedTack = tackElem.val();

		// タックの選択肢更新
		tackElem.empty();
		var tmpTack = null;
		for (tmpTack of tackList[pantsModel].activeList) {
			tackElem.append(jQuery('<option />').val(tmpTack).text(tmpTack));
		}
		// デフォルトを選択
		tackElem.val(tackList[pantsModel].defaultValue);

		// フロント仕様設定
		var sFrontSpec = defaultFrontSpec[pantsModel];
		jQuery('input[name="optionPantsTuxedoInfo.tpFrontSpec"]').val([sFrontSpec]);

		// パンチェリーナ特殊制御
		tpPancherinaSpecialController();

		// 選択中のアジャスター仕様
		var selectedAdjuster = jQuery('input[name="optionPantsTuxedoInfo.tpAdjuster"]:checked').val();

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
		jQuery('input[name="optionPantsTuxedoInfo.tpAdjuster"]').val([adjusterList[pantsModel].defaultValue]);

		// 選択中のベルトループ
		var selectedBeltLoop = jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoop"]:checked').val();

		// ベルトループの選択肢制御
		jQuery('input[id^="tp_beltLotp_"]').each(function() {
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
		jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoop"]').val([beltLoopList[pantsModel].defaultValue]);
		jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoop"]').change();

		// ベルトループ変更時処理
		tpChangedBeltLoop();

		// 選択中の脇ポケット
		var sidePktElem = jQuery('input[name="optionPantsTuxedoInfo.tpSidePkt"]:checked');
		var selectedSidePkt = sidePktElem.val();

		// モデルに基づくデフォルトの脇ポケット
		var modelSidePkt = pantsModelDefaultList[pantsModel].op_sidePkt;
		// デフォルトを選択
		jQuery('input[name="optionPantsTuxedoInfo.tpSidePkt"]').val([modelSidePkt]);

		// 選択中の忍びポケット
		var sinobiPktElem = jQuery('input[name="optionPantsTuxedoInfo.tpSinobiPkt"]:checked');
		var selectedSinobiPkt = sinobiPktElem.val();

		// モデルに基づくデフォルトの忍びポケット
		var modelSinobiPkt = pantsModelDefaultList[pantsModel].op_sinobiPkt;
		// デフォルトを選択
		jQuery('input[name="optionPantsTuxedoInfo.tpSinobiPkt"]').val([modelSinobiPkt]);

		// モデルに基づくデフォルトのコインポケット
		var modelCoinPkt = pantsModelDefaultList[pantsModel].op_coinPkt;
		// デフォルトを選択
		jQuery('#tp_coinPkt').val([modelCoinPkt]);
		jQuery('#tp_coinPkt').change();

		// 選択中の上前ピスポケット
		var pisPktUf = jQuery('input[name="optionPantsTuxedoInfo.tpPisPktUf"]:checked');
		var selectedPisPktUf = pisPktUf.val();

		// モデルに基づくデフォルトの上前ピスポケット
		var modelPisPktUf = pantsModelDefaultList[pantsModel].op_pisPktUf;
		// デフォルトを選択
		jQuery('input[name="optionPantsTuxedoInfo.tpPisPktUf"]').val([modelPisPktUf]);
		jQuery('input[name="optionPantsTuxedoInfo.tpPisPktUf"]').change();

		// 選択中の下前ピスポケット
		var pisPktDf = jQuery('input[name="optionPantsTuxedoInfo.tpPisPktDf"]:checked');
		var selectedPisPktDf = pisPktDf.val();

		// モデルに基づくデフォルトの下前ピスポケット
		var modelPisPktDf = pantsTuxedoModelDefaultList[pantsModel].op_pisPktDf;
		// デフォルトを選択
		jQuery('input[name="optionPantsTuxedoInfo.tpPisPktDf"]').val([modelPisPktDf]);
		jQuery('input[name="optionPantsTuxedoInfo.tpPisPktDf"]').change();

		// 選択中のVカット
		var vCut = jQuery('input[name="optionPantsTuxedoInfo.tpVCut"]:checked');
		var selectedVCut = vCut.val();

		// モデルに基づくデフォルトのVカット
		var modelVCut = pantsModelDefaultList[pantsModel].op_vCut;
		// デフォルトを選択
		jQuery('input[name="optionPantsTuxedoInfo.tpVCut"]').val([modelVCut]);

		// ステッチ箇所変更
		if (opStitchModifyList[pantsModel]) {
			// 定義がある場合、モデルに基づくチェック状態にする
			jQuery('input[name="tp_stitchModifyPlace"]').val(opStitchModifyList[pantsModel]);
		} else {
			// 想定外のPANTSモデルの場合はすべて変更不可＆チェックなし
			jQuery('input[name="tp_stitchModifyPlace"]').each(function() {
				jQuery(this).prop("disabled", true);
				jQuery(this).prop("checked", false);
			});
		}

		// 別モデルに変更された場合はアラート表示
		if ((tmpTpPantsModel != '' || tmpTpPantsModel != null) && pantsModel != tmpTpPantsModel) {
//		    appendAlert('tp_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		    setAlert('tp_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		}
		// 一時保存のモデルを更新
		tmpTpPantsModel = pantsModel;
	});

	// 膝裏
	jQuery('input[name="optionPantsTuxedoInfo.tpKneeBack"]').each(function() {
		jQuery(this).change(function(){

			// 現在の膝裏を取得
			var selectedKneeBack = jQuery('input[name="optionPantsTuxedoInfo.tpKneeBack"]:checked').val();
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
	jQuery('input[name="optionPantsTuxedoInfo.tpFrontSpec"]').each(function() {
		jQuery(this).change(function(){
			// パンチェリーナ特殊制御
			tpPancherinaSpecialController();
		});
	});
	jQuery('#tp_frontSpec_id1').change();

	// ベルトループ
	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoop"]').each(function() {
		jQuery(this).change(function(){
			// ベルトループ変更時処理
			tpChangedBeltLoop();
		});
	});
	// ベルトループ変更時処理
	tpChangedBeltLoop();

	// フラップ付コインポケット
	jQuery('input[name="optionPantsTuxedoInfo.tpFlapCoinPkt"]').each(function() {
		jQuery(this).change(function(){
			// ボタンホール色指定箇所の制御
			ctrlTpBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlTpByColorPlace();
	    });
	});

	// 上前ピスポケット
	jQuery('input[name="optionPantsTuxedoInfo.tpPisPktUf"]').each(function() {
		jQuery(this).change(function(){
			// ボタンホール色指定箇所の制御
			ctrlTpBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlTpByColorPlace();
		});
	});
	jQuery('#tp_pisPktUf_id1').change();

	// 下前ピスポケット
	jQuery('input[name="optionPantsTuxedoInfo.tpPisPktDf"]').each(function() {
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

	// AMFステッチ
//	jQuery('input[name="optionPantsTuxedoInfo.tpStitch"]').each(function() {
//		jQuery(this).change(function(){
//			// 選択中のAMFステッチ
//			var stitchValue = jQuery('input[name="optionPantsTuxedoInfo.tpStitch"]:checked').val();
//
//			if (stitchValue == "有り") {
//				// 有りの場合、関連する項目を有効化
//				// ステッチ箇所変更
//				jQuery('input[name="tp_stitchModify"]').prop("disabled", false);
//
//				// ダブルステッチ
//				jQuery('input[name="tp_dStitch"]').prop("disabled", false);
//
//				// AMF色指定
//				jQuery('input[name="tp_amfColor"]').prop("disabled", false);
//			} else {
//				// 無しの場合、関連する項目を無効化・値変更
//				// ステッチ箇所変更
//				jQuery('input[name="tp_stitchModify"]').prop("disabled", true);
//				jQuery('#tp_stitchModify_no').prop("checked", true);
//				jQuery('#tp_stitchModify_no').change();
//
//				// ダブルステッチ
//				jQuery('input[name="tp_dStitch"]').prop("disabled", true);
//				jQuery('#tp_dStitch_no').prop("checked", true);
//				jQuery('#tp_dStitch_no').change();
//
//				// AMF色指定
//				jQuery('input[name="tp_amfColor"]').prop("disabled", true);
//				jQuery('#tp_amfColor_no').prop("checked", true);
//				jQuery('#tp_amfColor_no').change();
//			}
//
//			// ダブルステッチの特殊制御
//			tpDStichSpecialController();
//		});
//	});

	// ステッチ箇所変更
//	jQuery('input[name="tp_stitchModify"]').each(function() {
//		jQuery(this).change(function(){
//			// 選択中のステッチ箇所変更
//			var stitchModifyValue = jQuery('input[name="tp_stitchModify"]:checked').val();
//
//			if (stitchModifyValue == "無し") {
//				// 無しの場合は全て無効化
//				jQuery('input[name="tp_stitchModifyPlace"]').prop("disabled", true);
//				jQuery('#btn_as_tp_stitchModifyPlace').prop("disabled", true);
//				jQuery('#btn_ar_tp_stitchModifyPlace').prop("disabled", true);
//			} else {
//				// 有りの場合は全て有効化
//				jQuery('input[name="tp_stitchModifyPlace"]').prop("disabled", false);
//				jQuery('#btn_as_tp_stitchModifyPlace').prop("disabled", false);
//				jQuery('#btn_ar_tp_stitchModifyPlace').prop("disabled", false);
//			}
//		});
//	});
//	jQuery('#tp_stitchModify_no').change();
//
//	// AMF色指定(有り/無し)
//	jQuery('input[name="tp_amfColor"]').each(function() {
//		jQuery(this).change(function(){
//			// 選択中のAMF色指定を取得
//			var amfColor = jQuery('input[name="tp_amfColor"]:checked').val();
//
//			if (amfColor == '無し') {
//				// 無しの場合は操作不可
//				jQuery('input[name="tp_amfColorPlace"]').each(function() {
//					jQuery(this).prop("disabled", true);
//					jQuery(this).prop("checked", false);
//					jQuery('#'+this.id+'_div').hide();
//				});
//				jQuery('#tp_amfColorPlaceAll').prop("disabled", true);
//				jQuery('#btn_as_tp_amfColorPlace').prop("disabled", true);
//
//				// 無しの場合は2階層目以降を非表示
//				jQuery('#tp_amfColor_div').hide();
//			} else {
//				// 有りの場合は操作可能
//				jQuery('input[name="tp_amfColorPlace"]').each(function() {
//					jQuery(this).prop("disabled", false);
//					if (jQuery(this).prop("checked")) {
//						// 選択されているの場合、色指定エリアを表示
//						jQuery('#'+this.id+'_div').show();
//					}
//				});
//				jQuery('#tp_amfColorPlaceAll').prop("disabled", false);
//				jQuery('#btn_as_tp_amfColorPlace').prop("disabled", false);
//
//				// 有りの場合は2階層目以降を表示
//				jQuery('#tp_amfColor_div').show();
//			}
//		});
//	});
//
//	// AMF色指定(全選択)
//	jQuery('#btn_as_tp_amfColorPlace').click(function(){
//		// 全選択する色を取得
//		var allColor = jQuery('#tp_amfColorPlaceAll').val();
//
//		jQuery('#tp_amfColor_div input[type="radio"]').each(function(index, elem){
//			elem = jQuery(elem);
//			if (elem.val() == allColor) elem.prop('checked', true);
//		});
//	});
//
//	// AMF色指定箇所
//	jQuery('input[name="tp_amfColorPlace"]').each(function() {
//		jQuery(this).change(function(){
//			if (jQuery(this).prop("checked")) {
//				// 選択されているの場合、色指定エリアを表示
//				jQuery('#'+this.id+'_div').show();
//			} else {
//				// 選択されていない場合、色指定エリアを非表示
//				jQuery('#'+this.id+'_div').hide();
//			}
//		});
//	});

	// ボタンホール色指定(有り/無し)
	jQuery('input[id^="tp_bhColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var tp_bhColor = jQuery('input[name="optionPantsTuxedoInfo.tpBhColor"]:checked').val();

			if (tp_bhColor == '0002701') {
				// 無しの場合は操作不可
				jQuery('input[id^="tp_bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#tp_bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_tp_bhColorPlace').prop("disabled", true);

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

		jQuery('#tp_bhColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタンホール色指定箇所
	jQuery('input[id^="tp_bhColorPlace_"]').each(function() {
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
	ctrlTpBhColorPlace();

	// ボタン付け糸指定(有り/無し)
	jQuery('input[id^="tp_byColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var tp_byColor = jQuery('input[name="optionPantsTuxedoInfo.tpByColor"]:checked').val();

			if (tp_byColor == '0003001') {
				// 無しの場合は操作不可
				jQuery('input[id^="tp_byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#tp_byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_tp_byColorPlace').prop("disabled", true);

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

		jQuery('#tp_byColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタン付け糸指定箇所
	jQuery('input[id^="tp_byColorPlace_"]').each(function() {
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
	ctrlTpByColorPlace();

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
			var sideStripe = jQuery('input[name="optionPantsTuxedoInfo.tpSideStripe"]:checked').val();
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
	var tp_bhColor = jQuery('input[name="optionPantsTuxedoInfo.tpBhColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name="optionPantsTuxedoInfo.tpPisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name="optionPantsTuxedoInfo.tpPisPktDf"]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="optionPantsTuxedoInfo.tpFlapCoinPkt"]:checked').val();

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
	var tp_byColor = jQuery('input[name="optionPantsTuxedoInfo.tpByColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name="optionPantsTuxedoInfo.tpPisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name="optionPantsTuxedoInfo.tpPisPktDf"]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="optionPantsTuxedoInfo.tpFlapCoinPkt"]:checked').val();

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
	var selectedPancherina = jQuery('input[name="optionPantsTuxedoInfo.tpPancherina"]:checked').val();

	// 特定のモデル以外はパンチェリーナ選択不可
	if (selectedPantsModel != 'TR02'
			&& selectedPantsModel != 'CH14'
			&& selectedPantsModel != 'NZ01'
			&& selectedPantsModel != 'JW21'
			&& selectedPantsModel != 'AY01') {

		jQuery('#tp_pancherina_id1').prop("disabled", true);
		jQuery('#tp_pancherina_id1').prop("checked", true);
		jQuery('#tp_pancherina_id1').change();
		jQuery('#tp_pancherina_id2').prop("disabled", true);

	} else {

		// 後続処理のために一旦パンチェリーナの選択肢を活性化させる
		jQuery('#tp_pancherina_id1').prop("disabled", false);
		jQuery('#tp_pancherina_id2').prop("disabled", false);

		// 現在のフロント仕様を取得
		var selectedFrontSpec = jQuery('input[name="optionPantsTuxedoInfo.tpFrontSpec"]:checked').val();

		// フロント仕様がホック留めの場合はパンチェリーナは無し固定
		if (selectedFrontSpec == '0000401') {
		} else {
			jQuery('#tp_pancherina_id2').prop('disabled', true);
			jQuery('#tp_pancherina_id1').prop('checked', true);
		}
	}

	// 処理後のパンチェリーナ
	var changedPancherina = jQuery('input[name="optionPantsTuxedoInfo.tpPancherina"]:checked').val();
}

//ベルトループ変更時処理
function tpChangedBeltLoop() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoop"]:checked').val();
	var disabledFlg = false;

	if (selectedBeltLoop == '0000701') {
		// 表示
		jQuery('#tp_beltLoopPlace').show();
	} else {
		// 非表示
		jQuery('#tp_beltLoopPlace').hide();
		disabledFlg = true;
	}

	// ベルトループ項目の活性/非活性
	jQuery('input[id^="tp_beltLoopPlace_"]').each(function() {
		var tmpBeltLoopElem = jQuery(this);
		tmpBeltLoopElem.prop("disabled", disabledFlg);
		if (!disabledFlg) {
			tmpBeltLoopElem.prop("checked", true);
		}
	});

	// ピンループ設定 ※アジャスター仕様が小でベルトループ有の場合に無しに設定する
	if (selectedBeltLoop == '0000701') {
		if (jQuery('input[name="tp_adjuster"]:checked').val() == '0000603') {
			jQuery('#tp_pinLoop_id2').prop('checked', 'true');
		}
	}	

	// フラシループ設定
	var frsAreaElem = jQuery('#tp_beltLoopPlace_id7');
	if (jQuery('#tp_pantsModel').val() == 'NZ01') {
		// 表示
		frsAreaElem.show();
	} else {
		// 非表示
		frsAreaElem.hide();
	}

	// ピンループ特殊制御
	tpPinLoopSpecialController();
}

//ピンループ特殊制御
function tpPinLoopSpecialController() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoop"]:checked').val();
	// 選択中のピンループ
	var selectedPinLoop = jQuery('input[name="optionPantsTuxedoInfo.tpPinLoop"]:checked').val();

	if (selectedBeltLoop == '0000702') {
		// ベルトループ無しの場合はピンループ無し固定
		jQuery('input[id="tp_pinLoop_id1"]').prop("disabled", true);
		jQuery('input[id="tp_pinLoop_id2"]').prop("disabled", false);
		jQuery('input[id="tp_pinLoop_id2"]').prop("checked", true);
	} else {
		jQuery('input[id="tp_pinLoop_id1"]').prop("disabled", false);
		jQuery('input[id="tp_pinLoop_id2"]').prop("disabled", false);
	}

	// 処理後のピンループ
	var changedPinLoop = jQuery('input[name="optionPantsTuxedoInfo.tpPinLoop"]:checked').val();
}

//ダブルステッチの特殊制御を行う
//function tpDStichSpecialController() {
//
//	// 選択中のAMFステッチ
//	var selectedStich = jQuery('input[name="optionPantsTuxedoInfo.tpStitch"]:checked').val();
//
//	// AMFステッチが有りの場合はダブルステッチを有効化する
//	if (selectedStich == '0001904') {
//		jQuery('input[name="optionPantsTuxedoInfo.tpStitch"]').prop("disabled", false);
//	} else {
//		jQuery('input[name="optionPantsTuxedoInfo.tpStitch"]').prop("disabled", true);
////		jQuery('input[id="tp_dStitch_no"]').prop("checked", true);
//	}
//}

jQuery('#tp_coinPkt').change(function() {

	var selectedValue = jQuery('#tp_coinPkt').val();

		jQuery('#tp_flapCoinPkt_id2').prop('disabled', false);
	if (selectedValue == "0001201") {
		jQuery('#tp_flapCoinPkt_id1').prop('checked', true);
		jQuery('#tp_flapCoinPkt_id2').prop('disabled', true);
	}
	
	
});
jQuery('#tp_coinPkt').change();

// アジャスター仕様変更時
jQuery('input[name="optionPantsTuxedoInfo.tpAdjuster"]').change(function(index, elem) {
	var selected = jQuery('input[name="optionPantsTuxedoInfo.tpAdjuster"]:checked').val();

	var oBLoopElemY = jQuery('#tp_beltLoop_id1');
	var oBLoopElemN = jQuery('#tp_beltLoop_id2');

	var oPLoopElemY = jQuery('#tp_pinLoop_id1');
	var oPLoopElemN = jQuery('#tp_pinLoop_id2');
	
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

	tpChangedBeltLoop();

});
jQuery('#tp_adjuster_id1').change();

// PANTS2本目（1本目と同じ）
jQuery('#btn_tp2_samePants').click(function (){
	jQuery('#tp2_pantsModel').val([jQuery('#tp_pantsModel').val()]);
	jQuery('#tp2_tack').val([jQuery('#tp_tack').val()]);
	jQuery('input[name="tp2_kneeBack"]').val([jQuery('input[name="tp_kneeBack"]:checked').val()]);
	jQuery('input[name="tp2_kneeBack"]').change();
	jQuery('input[name="tp2_kneeBackMate"]').val([jQuery('input[name="tp_kneeBackMate"]:checked').val()]);
	jQuery('input[name="tp2_kneeBackMate"]').change();
	jQuery('input[name="tp2_frontSpec"]').val([jQuery('input[name="tp_frontSpec"]:checked').val()]);
	jQuery('input[name="tp2_frontSpec"]').change();
	jQuery('input[name="tp2_pancherina"]').val([jQuery('input[name="tp_pancherina"]:checked').val()]);
	jQuery('input[name="tp2_pancherina"]').change();
	jQuery('input[name="tp2_adjuster"]').val([jQuery('input[name="tp_adjuster"]:checked').val()]);
	jQuery('input[name="tp2_adjuster"]').change();
	jQuery('input[name="tp2_beltLoop"]').val([jQuery('input[name="tp_beltLoop"]:checked').val()]);
	jQuery('input[name="tp2_beltLoop"]').change();
	
	jQuery('input[name="tp2_beltLoopPlace"').each(function() {
		var _1stId = jQuery(this).prop('id').replace('tp2_', 'tp_');
		jQuery(this).prop('checked', jQuery('#' + _1stId).prop('checked'));
		jQuery(this).change();
	});
	
	jQuery('input[name="tp2_pinLoop"]').val([jQuery('input[name="tp_pinLoop"]:checked').val()]);
	jQuery('input[name="tp2_pinLoop"]').change();
	jQuery('input[name="tp2_sidePkt"]').val([jQuery('input[name="tp_sidePkt"]:checked').val()]);
	jQuery('input[name="tp2_sidePkt"]').change();
	jQuery('input[name="tp2_sinobiPkt"]').val([jQuery('input[name="tp_sinobiPkt"]:checked').val()]);
	jQuery('input[name="tp2_sinobiPkt"]').change();
	jQuery('#tp2_coinPkt').val([jQuery('#tp_coinPkt').val()]);
	jQuery('input[name="tp2_coinPkt"]').change();
	jQuery('input[name="tp2_flapCoinPkt"]').val([jQuery('input[name="tp_flapCoinPkt"]:checked').val()]);
	jQuery('input[name="tp2_flapCoinPkt"]').change();
	jQuery('input[name="tp2_pisPktUf"]').val([jQuery('input[name="tp_pisPktUf"]:checked').val()]);
	jQuery('input[name="tp2_pisPktUf"]').change();
	jQuery('input[name="tp2_pisPktDf"]').val([jQuery('input[name="tp_pisPktDf"]:checked').val()]);
	jQuery('input[name="tp2_pisPktDf"]').change();
	jQuery('input[name="tp2_vCut"]').val([jQuery('input[name="tp_vCut"]:checked').val()]);
	jQuery('input[name="tp2_vCut"]').change();
	jQuery('#tp2_hemUp').val([jQuery('#tp_hemUp').val()]);
	jQuery('#tp2_hemUp').change();
	jQuery('#tp2_doubleWide').val([jQuery('#tp_doubleWide').val()]);
	jQuery('#tp2_doubleWide').change();
	jQuery('input[name="tp2_stitch"]').val([jQuery('input[name="tp_stitch"]:checked').val()]);
	jQuery('input[name="tp2_stitch"]').change();
	jQuery('input[name="tp2_stitchModify"]').val([jQuery('input[name="tp_stitchModify"]:checked').val()]);
	jQuery('input[name="tp2_stitchModify"]').change();
	jQuery('input[name="tp2_stitchModifyPlace"').each(function() {
		var _1stId = jQuery(this).prop('id').replace('tp2_', 'tp_');
		jQuery(this).prop('checked', jQuery('#' + _1stId).prop('checked'));
		jQuery(this).change();
	});
	jQuery('input[name="tp2_dStitch"]').val([jQuery('input[name="tp_dStitch"]:checked').val()]);
	jQuery('input[name="tp2_dStitch"]').change();
	jQuery('input[name="tp2_dStitchPlace"').each(function() {
		var _1stId = jQuery(this).prop('id').replace('tp2_', 'tp_');
		jQuery(this).prop('checked', jQuery('#' + _1stId).prop('checked'));
	});
	jQuery('input[name="tp2_amfColor"]').val([jQuery('input[name="tp_amfColor"]:checked').val()]);
	jQuery('input[name="tp2_amfColor"]').change();
	jQuery('#tp2_amfColorPlaceAll').val([jQuery('#tp_amfColorPlaceAll').val()]);
	jQuery('#tp2_amfColorPlaceAll').change();
	jQuery('input[name="tp2_amfColorPlace"').each(function() {
		var _1stId = jQuery(this).prop('id').replace('tp2_', 'tp_');
		jQuery(this).prop('checked', jQuery('#' + _1stId).prop('checked'));
		jQuery(this).change();
	});
	jQuery('input[name="tp2_amfColorSidePkt"]').val([jQuery('input[name="tp_amfColorSidePkt"]:checked').val()]);
	jQuery('input[name="tp2_amfColorSidePkt"]').change();
	jQuery('input[name="tp2_amfColorSideSeam"]').val([jQuery('input[name="tp_amfColorSideSeam"]:checked').val()]);
	jQuery('input[name="tp2_amfColorSideSeam"]').change();
	jQuery('input[name="tp2_amfColorDarts"]').val([jQuery('input[name="tp_amfColorDarts"]:checked').val()]);
	jQuery('input[name="tp2_amfColorDarts"]').change();
	jQuery('input[name="tp2_amfColorPisFlap"]').val([jQuery('input[name="tp_amfColorPisFlap"]:checked').val()]);
	jQuery('input[name="tp2_amfColorPisFlap"]').change();
	jQuery('input[name="tp2_bhColor"]').val([jQuery('input[name="tp_bhColor"]:checked').val()]);
	jQuery('input[name="tp2_bhColor"]').change();
	jQuery('#tp2_bhColorPlaceAll').val([jQuery('#tp_bhColorPlaceAll').val()]);
	jQuery('#tp2_bhColorPlaceAll').change();
	jQuery('input[name="tp2_bhColorPlace"').each(function() {
		var _1stId = jQuery(this).prop('id').replace('tp2_', 'tp_');
		jQuery(this).prop('checked', jQuery('#' + _1stId).prop('checked'));
		jQuery(this).change();
	});
	jQuery('input[name="tp2_bhColorPlaceFront"]').val([jQuery('input[name="tp_bhColorPlaceFront"]:checked').val()]);
	jQuery('input[name="tp2_bhColorPlaceFront"]').change();
	jQuery('input[name="tp2_bhColorPlaceUfbp"]').val([jQuery('input[name="tp_bhColorPlaceUfbp"]:checked').val()]);
	jQuery('input[name="tp2_bhColorPlaceUfbp"]').change();
	jQuery('input[name="tp2_bhColorPlaceDfbp"]').val([jQuery('input[name="tp_bhColorPlaceDfbp"]:checked').val()]);
	jQuery('input[name="tp2_bhColorPlaceDfbp"]').change();
	jQuery('input[name="tp2_bhColorPlaceCoin"]').val([jQuery('input[name="tp_bhColorPlaceCoin"]:checked').val()]);
	jQuery('input[name="tp2_bhColorPlaceCoin"]').change();
	jQuery('input[name="tp2_byColor"]').val([jQuery('input[name="tp_byColor"]:checked').val()]);
	jQuery('input[name="tp2_byColor"]').change();
	jQuery('#tp2_byColorPlaceAll').val([jQuery('#tp_byColorPlaceAll').val()]);
	jQuery('#tp2_byColorPlaceAll').change();
	jQuery('input[name="tp2_byColorPlace"').each(function() {
		var _1stId = jQuery(this).prop('id').replace('tp2_', 'tp_');
		jQuery(this).prop('checked', jQuery('#' + _1stId).prop('checked'));
		jQuery(this).change();
	});
	jQuery('input[name="tp2_byColorPlaceFront"]').val([jQuery('input[name="tp_byColorPlaceFront"]:checked').val()]);
	jQuery('input[name="tp2_byColorPlaceFront"]').change();
	jQuery('input[name="tp2_byColorPlaceUf"]').val([jQuery('input[name="tp_byColorPlaceUf"]:checked').val()]);
	jQuery('input[name="tp2_byColorPlaceUf"]').change();
	jQuery('input[name="tp2_byColorPlaceDf"]').val([jQuery('input[name="tp_byColorPlaceDf"]:checked').val()]);
	jQuery('input[name="tp2_byColorPlaceDf"]').change();
	jQuery('input[name="tp2_byColorPlaceCoinPkt"]').val([jQuery('input[name="tp_byColorPlaceCoinPkt"]:checked').val()]);
	jQuery('input[name="tp2_byColorPlaceCoinPkt"]').change();
	jQuery('#tp2_button').val([jQuery('#tp_button').val()]);
	jQuery('#tp2_button').change();
	jQuery('#tp2_btnMateStkNo').val([jQuery('#tp_btnMateStkNo').val()]);
	jQuery('#tp2_btnMateStkNo').change();
	jQuery('input[name="tp2_suspenderBtn"]').val([jQuery('input[name="tp_suspenderBtn"]:checked').val()]);
	jQuery('input[name="tp2_suspenderBtn"]').change();
	jQuery('input[name="tp2_thick"]').val([jQuery('input[name="tp_thick"]:checked').val()]);
	jQuery('input[name="tp2_thick"]').change();
	jQuery('input[name="tp2_eight"]').val([jQuery('input[name="tp_eight"]:checked').val()]);
	jQuery('input[name="tp2_eight"]').change();
	jQuery('input[name="tp2_shapeMemory"]').val([jQuery('input[name="tp_shapeMemory"]:checked').val()]);
	jQuery('input[name="tp2_shapeMemory"]').change();
	jQuery('input[name="tp2_sideStripe"]').val([jQuery('input[name="tp_sideStripe"]:checked').val()]);
	jQuery('input[name="tp2_sideStripe"]').change();
	jQuery('input[name="tp2_sideStripeWidth"]').val([jQuery('input[name="tp_sideStripeWidth"]:checked').val()]);
	jQuery('input[name="tp2_sideStripeWidth"]').change();
});
