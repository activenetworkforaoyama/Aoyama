/*********************************************
 * タキシードPANTS3用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionPants3Tuxedo() {

	// PANTSモデル
	jQuery('#tp3_pantsModel').change(function() {
		// 選択されたPantsモデルを取得
		var pantsModel = jQuery(this).val();

		if (pantsModel == '選択') {
			// 未選択時は何もしない
			return;
		}

		// 選択中のタック
		var tackElem = jQuery('#tp3_tack');
		var selectedTack = tackElem.val();

		// タックの選択肢更新
		tackElem.empty();
		var tmpTack = null;
		for (tmpTack of tackList[pantsModel].activeList) {
			tackElem.append(jQuery('<option />').val(tmpTack).text(tmpTack));
		}
		// デフォルトを選択
		tackElem.val(tackList[pantsModel].defaultValue);

		// パンチェリーナ特殊制御
		tp3PancherinaSpecialController();

		// 選択中のアジャスター仕様
		var selectedAdjuster = jQuery('input[name=tp3_adjuster]:checked').val();

		// アジャスター仕様の選択肢制御
		jQuery('input[id^="tp3_adjuster_"]').each(function() {
			var tmpTp3AdjusterElem = jQuery(this);
			var value = tmpTp3AdjusterElem.val();

			if (adjusterList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なアジャスター仕様の場合、有効化
				tmpTp3AdjusterElem.prop("disabled", false);
			} else {
				// 有効なアジャスター仕様ではない場合、無効化
				tmpTp3AdjusterElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name=tp3_adjuster]').val([adjusterList[pantsModel].defaultValue]);

		// 選択中のベルトループ
		var selectedBeltLoop = jQuery('input[name=tp3_beltLoop]:checked').val();

		// ベルトループの選択肢制御
		jQuery('input[id^="tp3_beltLotp3_"]').each(function() {
			var tmpTp3BeltLoopElem = jQuery(this);
			var value = tmpTp3BeltLoopElem.val();

			if (beltLoopList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なベルトループの場合、有効化
				tmpTp3BeltLoopElem.prop("disabled", false);
			} else {
				// 有効なベルトループではない場合、無効化
				tmpTp3BeltLoopElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name=tp3_beltLoop]').val([beltLoopList[pantsModel].defaultValue]);
		jQuery('input[name=tp3_beltLoop]').change();

		// ベルトループ変更時処理
		tp3ChangedBeltLoop();

		// 選択中の脇ポケット
		var sidePktElem = jQuery('input[name=tp3_sidePkt]:checked');
		var selectedSidePkt = sidePktElem.val();

		// モデルに基づくデフォルトの脇ポケット
		var modelSidePkt = pantsModelDefaultList[pantsModel].op_sidePkt;
		// デフォルトを選択
		jQuery('input[name=tp3_sidePkt]').val([modelSidePkt]);

		// 選択中の忍びポケット
		var sinobiPktElem = jQuery('input[name=tp3_sinobiPkt]:checked');
		var selectedSinobiPkt = sinobiPktElem.val();

		// モデルに基づくデフォルトの忍びポケット
		var modelSinobiPkt = pantsModelDefaultList[pantsModel].op_sinobiPkt;
		// デフォルトを選択
		jQuery('input[name=tp3_sinobiPkt]').val([modelSinobiPkt]);

		// モデルに基づくデフォルトのコインポケット
		var modelCoinPkt = pantsModelDefaultList[pantsModel].op_coinPkt;
		// デフォルトを選択
		jQuery('input[name=tp3_coinPkt]').val([modelCoinPkt]);
		jQuery('input[name=tp3_coinPkt]').change();

		// 選択中の上前ピスポケット
		var pisPktUf = jQuery('input[name=tp3_pisPktUf]:checked');
		var selectedPisPktUf = pisPktUf.val();

		// モデルに基づくデフォルトの上前ピスポケット
		var modelPisPktUf = pantsModelDefaultList[pantsModel].op_pisPktUf;
		// デフォルトを選択
		jQuery('input[name=tp3_pisPktUf]').val([modelPisPktUf]);
		jQuery('input[name=tp3_pisPktUf]').change();

		// 選択中の下前ピスポケット
		var pisPktDf = jQuery('input[name=tp3_pisPktDf]:checked');
		var selectedPisPktDf = pisPktDf.val();

		// モデルに基づくデフォルトの下前ピスポケット
		var modelPisPktDf = pantsModelDefaultList[pantsModel].op_pisPktDf;
		// デフォルトを選択
		jQuery('input[name=tp3_pisPktDf]').val([modelPisPktDf]);
		jQuery('input[name=tp3_pisPktDf]').change();

		// 選択中のVカット
		var vCut = jQuery('input[name=tp3_vCut]:checked');
		var selectedVCut = vCut.val();

		// モデルに基づくデフォルトのVカット
		var modelVCut = pantsModelDefaultList[pantsModel].op_vCut;
		// デフォルトを選択
		jQuery('input[name=tp3_vCut]').val([modelVCut]);

		// ステッチ箇所変更
		if (opStitchModifyList[pantsModel]) {
			// 定義がある場合、モデルに基づくチェック状態にする
			jQuery('input[name="tp3_stitchModifyPlace"]').val(opStitchModifyList[pantsModel]);
		} else {
			// 想定外のPANTSモデルの場合はすべて変更不可＆チェックなし
			jQuery('input[name="tp3_stitchModifyPlace"]').each(function() {
				jQuery(this).prop("disabled", true);
				jQuery(this).prop("checked", false);
			});
		}

		// 別モデルに変更された場合はアラート表示
		if (tmpTp3PantsModel != '選択' && pantsModel != tmpTp3PantsModel) {
//		    appendAlert('tp3_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		    setAlert('tp3_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		}
		// 一時保存のモデルを更新
		tmpTp3PantsModel = pantsModel;
	});

	// 膝裏
	jQuery('input[name="tp3_kneeBack"]').each(function() {
		jQuery(this).change(function(){

			// 現在の膝裏を取得
			var selectedKneeBack = jQuery('input[name=tp3_kneeBack]:checked').val();
			var disabledFlg = false;

			if (selectedKneeBack == '無し') {
				disabledFlg = true;
			}

			// 膝裏が無しの場合は膝裏素材を全て選択不可
			jQuery('input[id^="tp3_kneeBackMate_"]').each(function() {
				var tmpKneeBackMateElem = jQuery(this);
				tmpKneeBackMateElem.prop("disabled", disabledFlg);
			});
		});
	});

	// フロント仕様
	jQuery('input[name="tp3_frontSpec"]').each(function() {
		jQuery(this).change(function(){
			// パンチェリーナ特殊制御
			tp3PancherinaSpecialController();
		});
	});
	jQuery('#tp3_frontSpec_hook').change();

	// ベルトループ
	jQuery('input[name="tp3_beltLoop"]').each(function() {
		jQuery(this).change(function(){
			// ベルトループ変更時処理
			tp3ChangedBeltLoop();
		});
	});

	// フラップ付コインポケット
	jQuery('input[name="tp3_flapCoinPkt"]').each(function() {
		jQuery(this).change(function(){
			// ボタンホール色指定箇所の制御
			ctrlTp3BhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlTp3ByColorPlace();
	    });
	});

	// 上前ピスポケット
	jQuery('input[name="tp3_pisPktUf"]').each(function() {
		jQuery(this).change(function(){
			// ボタンホール色指定箇所の制御
			ctrlTp3BhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlTp3ByColorPlace();
		});
	});
	jQuery('#tp3_pisPktUf_btnYes').change();

	// 下前ピスポケット
	jQuery('input[name="tp3_pisPktDf"]').each(function() {
		jQuery(this).change(function(){
			// ボタンホール色指定箇所の制御
			ctrlTp3BhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlTp3ByColorPlace();
		});
	});
	jQuery('#tp3_pisPktDf_btnYes').change();

	// 裾上げ
	jQuery('#tp3_hemUp').change(function() {

		// 現在の裾上げを取得
		var selectedHemUp = jQuery('#tp3_hemUp').val();

		// ダブルがつくもの以外は非表示にする
		if (selectedHemUp == 'ダブル糸' || selectedHemUp == 'ダブルスナップ' || selectedHemUp == 'ダブルモーニングカット') {
			jQuery('#tp3_doubleWide_div').show();
		} else {
			jQuery('#tp3_doubleWide_div').hide();
			jQuery('input[id="tp3_doubleWide"]').prop("disabled",true);
		}
	});

	// AMFステッチ
	jQuery('input[name="tp3_stitch"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のAMFステッチ
			var stitchValue = jQuery('input[name="tp3_stitch"]:checked').val();

			if (stitchValue == "有り") {
				// 有りの場合、関連する項目を有効化
				// ステッチ箇所変更
				jQuery('input[name="tp3_stitchModify"]').prop("disabled", false);

				// ダブルステッチ
				jQuery('input[name="tp3_dStitch"]').prop("disabled", false);

				// AMF色指定
				jQuery('input[name="tp3_amfColor"]').prop("disabled", false);
			} else {
				// 無しの場合、関連する項目を無効化・値変更
				// ステッチ箇所変更
				jQuery('input[name="tp3_stitchModify"]').prop("disabled", true);
				jQuery('#tp3_stitchModify_no').prop("checked", true);
				jQuery('#tp3_stitchModify_no').change();

				// ダブルステッチ
				jQuery('input[name="tp3_dStitch"]').prop("disabled", true);
				jQuery('#tp3_dStitch_no').prop("checked", true);
				jQuery('#tp3_dStitch_no').change();

				// AMF色指定
				jQuery('input[name="tp3_amfColor"]').prop("disabled", true);
				jQuery('#tp3_amfColor_no').prop("checked", true);
				jQuery('#tp3_amfColor_no').change();
			}

			// ダブルステッチの特殊制御
			tp3DStichSpecialController();
		});
	});

	// ステッチ箇所変更
	jQuery('input[name="tp3_stitchModify"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のステッチ箇所変更
			var stitchModifyValue = jQuery('input[name="tp3_stitchModify"]:checked').val();

			if (stitchModifyValue == "無し") {
				// 無しの場合は全て無効化
				jQuery('input[name="tp3_stitchModifyPlace"]').prop("disabled", true);
				jQuery('#btn_as_tp3_stitchModifyPlace').prop("disabled", true);
				jQuery('#btn_ar_tp3_stitchModifyPlace').prop("disabled", true);
			} else {
				// 有りの場合は全て有効化
				jQuery('input[name="tp3_stitchModifyPlace"]').prop("disabled", false);
				jQuery('#btn_as_tp3_stitchModifyPlace').prop("disabled", false);
				jQuery('#btn_ar_tp3_stitchModifyPlace').prop("disabled", false);
			}
		});
	});
	jQuery('#tp3_stitchModify_no').change();

	// AMF色指定(有り/無し)
	jQuery('input[name="tp3_amfColor"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のAMF色指定を取得
			var amfColor = jQuery('input[name="tp3_amfColor"]:checked').val();

			if (amfColor == '無し') {
				// 無しの場合は操作不可
				jQuery('input[name="tp3_amfColorPlace"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#tp3_amfColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_tp3_amfColorPlace').prop("disabled", true);

				// 無しの場合は2階層目以降を非表示
				jQuery('#tp3_amfColor_div').hide();
			} else {
				// 有りの場合は操作可能
				jQuery('input[name="tp3_amfColorPlace"]').each(function() {
					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#tp3_amfColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_tp3_amfColorPlace').prop("disabled", false);

				// 有りの場合は2階層目以降を表示
				jQuery('#tp3_amfColor_div').show();
			}
		});
	});

	// AMF色指定(全選択)
	jQuery('#btn_as_tp3_amfColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#tp3_amfColorPlaceAll').val();

		jQuery('#tp3_amfColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// AMF色指定箇所
	jQuery('input[name="tp3_amfColorPlace"]').each(function() {
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
	jQuery('input[id^="tp3_bhColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var tp3_bhColor = jQuery('input[name="tp3_bhColor"]:checked').val();

			if (tp3_bhColor == '無し') {
				// 無しの場合は操作不可
				jQuery('input[id^="tp3_bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#tp3_bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_tp3_bhColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#tp3_bhColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタンホール色指定箇所の制御
				ctrlTp3BhColorPlace();
				jQuery('input[id^="tp3_bhColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#tp3_bhColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_tp3_bhColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#tp3_bhColor_div').show();
			}
		});
	});
	jQuery('#tp3_bhColor_no').change();

	// ボタンホール色指定(全選択)
	jQuery('#btn_as_tp3_bhColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#tp3_bhColorPlaceAll').val();

		jQuery('#tp3_bhColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタンホール色指定箇所
	jQuery('input[id^="tp3_bhColorPlace_"]').each(function() {
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
	ctrlTp3BhColorPlace();

	// ボタン付け糸指定(有り/無し)
	jQuery('input[id^="tp3_byColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var tp3_byColor = jQuery('input[name="tp3_byColor"]:checked').val();

			if (tp3_byColor == '無し') {
				// 無しの場合は操作不可
				jQuery('input[id^="tp3_byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#tp3_byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_tp3_byColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#tp3_byColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタン付け糸指定箇所の制御
				ctrlTp3ByColorPlace();
				jQuery('input[id^="tp3_byColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#tp3_byColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_tp3_byColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#tp3_byColor_div').show();
			}
		});
	});
	jQuery('#tp3_byColor_no').change();

	// ボタン付け糸指定(全選択)
	jQuery('#btn_as_tp3_byColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#tp3_byColorPlaceAll').val();

		jQuery('#tp3_byColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタン付け糸指定箇所
	jQuery('input[id^="tp3_byColorPlace_"]').each(function() {
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
	ctrlTp3ByColorPlace();

	// 釦素材
	jQuery('#tp3_button').change(function (){
		var btnMate = jQuery('#tp3_button').val();

		// 釦品番
		var btnMateStkNoElem = jQuery('#tp3_btnMateStkNo');

		// 選択肢をクリア
		btnMateStkNoElem.empty();

		if (btnMate == '包み') {
			jQuery('#tp3_frontBtnMateStkNo').hide();
			jQuery('#tp3_frontBtnMateStkNo').prop('disabled', true);
		} else if (btnMateStkNoList[btnMate]) {
			jQuery('#tp3_frontBtnMateStkNo').show();
			jQuery('#tp3_frontBtnMateStkNo').prop('disabled', false);
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < btnMateStkNoList[btnMate].length; i++) {
				btnMateStkNoElem.append(jQuery('<option />').val(btnMateStkNoList[btnMate][i]).text(btnMateStkNoList[btnMate][i]));
			}
		}
	});
	jQuery('#tp3_button').change();

	// JKと同じボタン
	jQuery('#tp3_sameJacketBtn').click(function(){

		// JACKETの釦素材を取得
		var jacketBtnMate = jQuery('#tj_btnMate').val();

		// JACKETの釦素材をPANTSの釦素材にコピー
		jQuery('#tp3_button').val(jacketBtnMate);
		// 釦素材変更処理
		jQuery('#tp3_button').change();

		// JACKETの釦品番を取得
		var jacketBtnMateStkNo = jQuery('#tj_btnMateStkNo').val();
		// JACKETの釦品番をPANTSの釦品番にコピー
		jQuery('#tp3_btnMateStkNo').val(jacketBtnMateStkNo);
	});

	// 側章
	jQuery('input[id^="tp3_sideStripe_"]').each(function() {
		jQuery(this).change(function(){

			// 選択中の側章
			var sideStripe = jQuery('input[name="tp3_sideStripe"]:checked').val();
			if (sideStripe == '有り') {
				// 側章が有りの場合は側章幅を表示する
				jQuery('#tp3_sideStripe_yes_area').show();
			} else {
				// 側章が無しの場合は側章幅を非表示にする
				jQuery('#tp3_sideStripe_yes_area').hide();
			}
		});
	});
}

//--------------------------------------------
// 部品
//--------------------------------------------
//ボタンホール色指定箇所の有効/無効を制御する
function ctrlTp3BhColorPlace() {

	// 選択中のボタンホール色指定
	var tp3_bhColor = jQuery('input[name="tp3_bhColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name=tp3_pisPktUf]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name=tp3_pisPktDf]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="tp3_flapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#tp3_bhColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (tp3_bhColor == "有り") {
			// 有りの場合は一旦有効化し、項目ごとに無効判定
			elem.prop("disabled", false);

			if (elem.val() == "上前ピスポケット") {
				if (selectedPisPktUf == "ボタン無" || selectedPisPktUf == "ポケット無") {
					elem.prop("disabled", true);
				}
			} else if (elem.val() == "下前ピスポケット") {
				if (selectedPisPktDf == "ボタン無" || selectedPisPktDf == 'ポケット無') {
					elem.prop("disabled", true);
				}
			} else if (elem.val() == "フラップ付コインポケット") {
				if (selectedFlapCoinPkt == '無し') {
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
function ctrlTp3ByColorPlace() {

	// 選択中のボタン付け糸指定
	var tp3_byColor = jQuery('input[name="tp3_byColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name=tp3_pisPktUf]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name=tp3_pisPktDf]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="tp3_flapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#tp3_byColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (tp3_byColor == "有り") {
			// 有りの場合は一旦有効化し、項目ごとに無効判定
			elem.prop("disabled", false);

			if (elem.val() == "上前ピスポケット") {
				if (selectedPisPktUf == "ボタン無" || selectedPisPktUf == "ポケット無") {
					elem.prop("disabled", true);
				}
			} else if (elem.val() == "下前ピスポケット") {
				if (selectedPisPktDf == "ボタン無" || selectedPisPktDf == 'ポケット無') {
					elem.prop("disabled", true);
				}
			} else if (elem.val() == "フラップ付コインポケット") {
				if (selectedFlapCoinPkt == '無し') {
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
function tp3PancherinaSpecialController() {

	// 現在選択中のPANTSモデル
	var selectedPantsModel = jQuery('#tp3_pantsModel').val();

	// 現在選択中のパンチェリーナ
	var selectedPancherina = jQuery('input[name=tp3_pancherina]:checked').val();

	// 特定のモデル以外はパンチェリーナ選択不可
	if (selectedPantsModel != 'TR02'
			&& selectedPantsModel != 'CH14'
			&& selectedPantsModel != 'NZ01'
			&& selectedPantsModel != 'JW21'
			&& selectedPantsModel != 'AY01') {

		jQuery('#tp3_pancherina_no').prop("disabled", true);
		jQuery('#tp3_pancherina_no').prop("checked", true);
		jQuery('#tp3_pancherina_no').change();
		jQuery('#tp3_pancherina_yes').prop("disabled", true);

	} else {

		// 後続処理のために一旦パンチェリーナの選択肢を活性化させる
		jQuery('#tp3_pancherina_no').prop("disabled", false);
		jQuery('#tp3_pancherina_yes').prop("disabled", false);

		// 現在のフロント仕様を取得
		var selectedFrontSpec = jQuery('input[name=tp3_frontSpec]:checked').val();

		// フロント仕様がホック留めの場合はパンチェリーナは無し固定
		if (selectedFrontSpec == 'ホック留め') {
			jQuery('#tp3_pancherina_yes').prop('disabled', true);
			jQuery('#tp3_pancherina_no').prop('checked', true);
		}
	}

	// 処理後のパンチェリーナ
	var changedPancherina = jQuery('input[name=tp3_pancherina]:checked').val();
}

//ベルトループ変更時処理
function tp3ChangedBeltLoop() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name=tp3_beltLoop]:checked').val();
	var disabledFlg = false;

	if (selectedBeltLoop == '有り') {
		// 表示
		jQuery('#tp3_beltLoopPlace').show();
	} else {
		// 非表示
		jQuery('#tp3_beltLoopPlace').hide();
		disabledFlg = true;
	}

	// ベルトループ項目の活性/非活性
	jQuery('input[id^="tp3_beltLoopPlace_"]').each(function() {
		var tmpBeltLoopElem = jQuery(this);
		tmpBeltLoopElem.prop("disabled", disabledFlg);
		if (!disabledFlg) {
			tmpBeltLoopElem.prop("checked", true);
		}
	});

	// ピンループ特殊制御
	tp3PinLoopSpecialController();
}

//ピンループ特殊制御
function tp3PinLoopSpecialController() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name=tp3_beltLoop]:checked').val();
	// 選択中のピンループ
	var selectedPinLoop = jQuery('input[name=tp3_pinLoop]:checked').val();

	if (selectedBeltLoop == '無し（ベルトレス）') {
		// ベルトループ無しの場合はピンループ無し固定
		jQuery('input[id="tp3_pinLotp3_yes"]').prop("disabled", true);
		jQuery('input[id="tp3_pinLotp3_no"]').prop("disabled", false);
		jQuery('input[id="tp3_pinLotp3_no"]').prop("checked", true);
	} else {
		jQuery('input[id="tp3_pinLotp3_yes"]').prop("disabled", false);
		jQuery('input[id="tp3_pinLotp3_no"]').prop("disabled", false);
	}

	// 処理後のピンループ
	var changedPinLoop = jQuery('input[name=tp3_pinLoop]:checked').val();
}

//ダブルステッチの特殊制御を行う
function tp3DStichSpecialController() {

	// 選択中のAMFステッチ
	var selectedStich = jQuery('input[name=tp3_stitch]:checked').val();

	// AMFステッチが有りの場合はダブルステッチを有効化する
	if (selectedStich == '有り') {
		jQuery('input[name="tp3_dStitch"]').prop("disabled", false);
	} else {
		jQuery('input[name="tp3_dStitch"]').prop("disabled", true);
		jQuery('input[id="tp3_dStitch_no"]').prop("checked", true);
	}
}