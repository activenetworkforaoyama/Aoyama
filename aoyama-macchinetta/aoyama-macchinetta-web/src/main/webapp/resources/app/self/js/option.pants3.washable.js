/*********************************************
 * ウォッシャブルPANTS3用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionPants3Washable() {

	// PANTSモデル
	jQuery('#wp3_pantsModel').change(function() {
		// 選択されたPantsモデルを取得
		var pantsModel = jQuery(this).val();

		if (pantsModel == '選択') {
			// 未選択時は何もしない
			return;
		}

		// 選択中のタック
		var tackElem = jQuery('#wp3_tack');
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
		wp2PancherinaSpecialController();

		// 選択中のアジャスター仕様
		var selectedAdjuster = jQuery('input[name=wp3_adjuster]:checked').val();

		// アジャスター仕様の選択肢制御
		jQuery('input[id^="wp3_adjuster_"]').each(function() {
			var tmpWp3AdjusterElem = jQuery(this);
			var value = tmpWp3AdjusterElem.val();

			if (adjusterList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なアジャスター仕様の場合、有効化
				tmpWp3AdjusterElem.prop("disabled", false);
			} else {
				// 有効なアジャスター仕様ではない場合、無効化
				tmpWp3AdjusterElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name=wp3_adjuster]').val([adjusterList[pantsModel].defaultValue]);

		// 選択中のベルトループ
		var selectedBeltLoop = jQuery('input[name=wp3_beltLoop]:checked').val();

		// ベルトループの選択肢制御
		jQuery('input[id^="wp3_beltLowp3_"]').each(function() {
			var tmpWp3BeltLoopElem = jQuery(this);
			var value = tmpWp3BeltLoopElem.val();

			if (beltLoopList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なベルトループの場合、有効化
				tmpWp3BeltLoopElem.prop("disabled", false);
			} else {
				// 有効なベルトループではない場合、無効化
				tmpWp3BeltLoopElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name=wp3_beltLoop]').val([beltLoopList[pantsModel].defaultValue]);
		jQuery('input[name=wp3_beltLoop]').change();

		// ベルトループ変更時処理
		wp3ChangedBeltLoop();

		// 選択中の脇ポケット
		var sidePktElem = jQuery('input[name=wp3_sidePkt]:checked');
		var selectedSidePkt = sidePktElem.val();

		// モデルに基づくデフォルトの脇ポケット
		var modelSidePkt = pantsModelDefaultList[pantsModel].op_sidePkt;
		// デフォルトを選択
		jQuery('input[name=wp3_sidePkt]').val([modelSidePkt]);

		// 選択中の忍びポケット
		var sinobiPktElem = jQuery('input[name=wp3_sinobiPkt]:checked');
		var selectedSinobiPkt = sinobiPktElem.val();

		// モデルに基づくデフォルトの忍びポケット
		var modelSinobiPkt = pantsModelDefaultList[pantsModel].op_sinobiPkt;
		// デフォルトを選択
		jQuery('input[name=wp3_sinobiPkt]').val([modelSinobiPkt]);

		// モデルに基づくデフォルトのコインポケット
		var modelCoinPkt = pantsModelDefaultList[pantsModel].op_coinPkt;
		// デフォルトを選択
		jQuery('input[name=wp3_coinPkt]').val([modelCoinPkt]);
		jQuery('input[name=wp3_coinPkt]').change();

		// 選択中の上前ピスポケット
		var pisPktUf = jQuery('input[name=wp3_pisPktUf]:checked');
		var selectedPisPktUf = pisPktUf.val();

		// モデルに基づくデフォルトの上前ピスポケット
		var modelPisPktUf = pantsModelDefaultList[pantsModel].op_pisPktUf;
		// デフォルトを選択
		jQuery('input[name=wp3_pisPktUf]').val([modelPisPktUf]);
		jQuery('input[name=wp3_pisPktUf]').change();

		// 選択中の下前ピスポケット
		var pisPktDf = jQuery('input[name=wp3_pisPktDf]:checked');
		var selectedPisPktDf = pisPktDf.val();

		// モデルに基づくデフォルトの下前ピスポケット
		var modelPisPktDf = pantsModelDefaultList[pantsModel].op_pisPktDf;
		// デフォルトを選択
		jQuery('input[name=wp3_pisPktDf]').val([modelPisPktDf]);
		jQuery('input[name=wp3_pisPktDf]').change();

		// 選択中のVカット
		var vCut = jQuery('input[name=wp3_vCut]:checked');
		var selectedVCut = vCut.val();

		// モデルに基づくデフォルトのVカット
		var modelVCut = pantsModelDefaultList[pantsModel].op_vCut;
		// デフォルトを選択
		jQuery('input[name=wp3_vCut]').val([modelVCut]);

		// ステッチ箇所変更
		ctrlWp3StitchModify();
		ctrlWp3StitchModifyPisFlap();

		// ダブルステッチ
		ctrlWp3DStitch();
		ctrlWp3DStitchPlace();

		// AMF色指定の有効/無効を制御する
		ctrlWp3AmfColor();

		// 別モデルに変更された場合はアラート表示
		if (tmpWp3PantsModel != '選択' && pantsModel != tmpWp3PantsModel) {
//		    appendAlert('wp3_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		    setAlert('wp3_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		}
		// 一時保存のモデルを更新
		tmpWp3PantsModel = pantsModel;
	});

	// 膝裏
	jQuery('input[name="wp3_kneeBack"]').each(function() {
		jQuery(this).change(function(){

			// 現在の膝裏を取得
			var selectedKneeBack = jQuery('input[name=wp3_kneeBack]:checked').val();
			var disabledFlg = false;

			if (selectedKneeBack == '無し') {
				disabledFlg = true;
			}

			// 膝裏が無しの場合は膝裏素材を全て選択不可
			jQuery('input[id^="wp3_kneeBackMate_"]').each(function() {
				var tmpKneeBackMateElem = jQuery(this);
				tmpKneeBackMateElem.prop("disabled", disabledFlg);
			});
		});
	});

	// フロント仕様
	jQuery('input[name="wp3_frontSpec"]').each(function() {
		jQuery(this).change(function(){
			// パンチェリーナ特殊制御
			wp2PancherinaSpecialController();
		});
	});
	jQuery('#wp3_frontSpec_hook').change();

	// ベルトループ
	jQuery('input[name="wp3_beltLoop"]').each(function() {
		jQuery(this).change(function(){
			// ベルトループ変更時処理
			wp3ChangedBeltLoop();
		});
	});

	// フラップ付コインポケット
	jQuery('input[name="wp3_flapCoinPkt"]').each(function() {
		jQuery(this).change(function(){
			// ボタンホール色指定箇所の制御
			ctrlWp3BhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlWp3ByColorPlace();
	    });
	});

	// 上前ピスポケット
	jQuery('input[name="wp3_pisPktUf"]').each(function() {
		jQuery(this).change(function(){
			// ステッチ箇所変更(ピスフラップ)の制御
			ctrlWp3StitchModifyPisFlap();
			// ダブルステッチ(選択肢)の制御
			ctrlWp3DStitchPlace();
			// ボタンホール色指定箇所の制御
			ctrlWp3BhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlWp3ByColorPlace();
		});
	});
	jQuery('#wp3_pisPktUf_btnYes').change();

	// 下前ピスポケット
	jQuery('input[name="wp3_pisPktDf"]').each(function() {
		jQuery(this).change(function(){
			// ステッチ箇所変更(ピスフラップ)の制御
			ctrlWp3StitchModifyPisFlap();
			// ダブルステッチ(選択肢)の制御
			ctrlWp3DStitchPlace();
			// ボタンホール色指定箇所の制御
			ctrlWp3BhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlWp3ByColorPlace();
		});
	});
	jQuery('#wp3_pisPktDf_btnYes').change();

	// 裾上げ
	jQuery('#wp3_hemUp').change(function() {

		// 現在の裾上げを取得
		var selectedHemUp = jQuery('#wp3_hemUp').val();

		// ダブルがつくもの以外は非表示にする
		if (selectedHemUp == 'ダブル糸' || selectedHemUp == 'ダブルスナップ' || selectedHemUp == 'ダブルモーニングカット') {
			jQuery('#wp3_doubleWide_div').show();
		} else {
			jQuery('#wp3_doubleWide_div').hide();
			jQuery('input[id="wp3_doubleWide"]').prop("disabled",true);
		}
	});

	// AMFステッチ
	jQuery('input[name="wp3_stitch"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のAMFステッチ
			var stitchValue = jQuery('input[name="wp3_stitch"]:checked').val();

			if (stitchValue != "無し") {
				// 有りの場合、関連する項目を有効化
				// ステッチ箇所変更
				jQuery('input[name="wp3_stitchModify"]').prop("disabled", false);

				// ダブルステッチ
				jQuery('input[name="wp3_dStitchModify"]').prop("disabled", false);

				// AMF色指定
				jQuery('input[name="wp3_amfColor"]').prop("disabled", false);
			} else {
				// 無しの場合、関連する項目を無効化・値変更
				// ステッチ箇所変更
				jQuery('input[name="wp3_stitchModify"]').prop("disabled", true);
				jQuery('#wp3_stitchModify_no').prop("checked", true);
				jQuery('#wp3_stitchModify_no').change();

				// ダブルステッチ
				jQuery('input[name="wp3_dStitchModify"]').prop("disabled", true);
				jQuery('#wp3_dStitchModify_no').prop("checked", true);
				jQuery('#wp3_dStitchModify_no').change();

				// AMF色指定
				jQuery('input[name="wp3_amfColor"]').prop("disabled", true);
				jQuery('#wp3_amfColor_no').prop("checked", true);
				jQuery('#wp3_amfColor_no').change();
			}

			// ダブルステッチの特殊制御
			wp3DStichSpecialController();
		});
	});

	// ステッチ箇所変更
	jQuery('input[name="wp3_stitchModify"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のステッチ箇所変更
			var stitchModifyValue = jQuery('input[name="wp3_stitchModify"]:checked').val();

			if (stitchModifyValue == "無し") {
				// 無しの場合は全て無効化
				jQuery('input[name="wp3_stitchModifyPlace"]').prop("disabled", true);
				jQuery('#btn_as_wp3_stitchModifyPlace').prop("disabled", true);
				jQuery('#btn_ar_wp3_stitchModifyPlace').prop("disabled", true);
			} else {
				// 有りの場合は全て有効化
				jQuery('input[name="wp3_stitchModifyPlace"]').prop("disabled", false);
				jQuery('#btn_as_wp3_stitchModifyPlace').prop("disabled", false);
				jQuery('#btn_ar_wp3_stitchModifyPlace').prop("disabled", false);
			}

			// ステッチ箇所変更
			ctrlWp3StitchModify();
			ctrlWp3StitchModifyPisFlap();

			// ダブルステッチ
			ctrlWp3DStitch();
			ctrlWp3DStitchPlace();

			// AMF色指定の有効/無効を制御する
			ctrlWp3AmfColor();
		});
	});
	jQuery('#wp3_stitchModify_no').change();

	// ステッチ箇所変更(選択肢)
	jQuery('input[id^="wp3_stitchModifyPlace_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のダブルステッチ変更
			ctrlWp3DStitchPlace();
			// AMF色指定の有効/無効を制御する
			ctrlWp3AmfColor();
		});
	});

	// ダブルステッチ
	jQuery('input[name="wp3_dStitchModify"]').each(function() {
		jQuery(this).change(function(){
			ctrlWp3DStitch();
			ctrlWp3DStitchPlace();
		});
	});

	// AMF色指定(有り/無し)
	jQuery('input[name="wp3_amfColor"]').each(function() {
		jQuery(this).change(function(){
			ctrlWp3AmfColor();
		});
	});
	ctrlWp3AmfColor();

	// AMF色指定(全選択)
	jQuery('#btn_as_wp3_amfColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#wp3_amfColorPlaceAll').val();

		jQuery('#wp3_amfColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// AMF色指定箇所
	jQuery('input[name="wp3_amfColorPlace"]').each(function() {
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
	jQuery('input[id^="wp3_bhColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var wp3_bhColor = jQuery('input[name="wp3_bhColor"]:checked').val();

			if (wp3_bhColor == '無し') {
				// 無しの場合は操作不可
				jQuery('input[id^="wp3_bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#wp3_bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_wp3_bhColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#wp3_bhColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタンホール色指定箇所の制御
				ctrlWp3BhColorPlace();
				jQuery('input[id^="wp3_bhColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#wp3_bhColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_wp3_bhColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#wp3_bhColor_div').show();
			}
		});
	});
	jQuery('#wp3_bhColor_no').change();

	// ボタンホール色指定(全選択)
	jQuery('#btn_as_wp3_bhColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#wp3_bhColorPlaceAll').val();

		jQuery('#wp3_bhColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタンホール色指定箇所
	jQuery('input[id^="wp3_bhColorPlace_"]').each(function() {
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
	ctrlWp3BhColorPlace();

	// ボタン付け糸指定(有り/無し)
	jQuery('input[id^="wp3_byColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var wp3_byColor = jQuery('input[name="wp3_byColor"]:checked').val();

			if (wp3_byColor == '無し') {
				// 無しの場合は操作不可
				jQuery('input[id^="wp3_byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#wp3_byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_wp3_byColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#wp3_byColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタン付け糸指定箇所の制御
				ctrlWp3ByColorPlace();
				jQuery('input[id^="wp3_byColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#wp3_byColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_wp3_byColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#wp3_byColor_div').show();
			}
		});
	});
	jQuery('#wp3_byColor_no').change();

	// ボタン付け糸指定(全選択)
	jQuery('#btn_as_wp3_byColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#wp3_byColorPlaceAll').val();

		jQuery('#wp3_byColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタン付け糸指定箇所
	jQuery('input[id^="wp3_byColorPlace_"]').each(function() {
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
	ctrlWp3ByColorPlace();

	// 釦素材
	jQuery('#wp3_button').change(function (){
		var btnMate = jQuery('#wp3_button').val();

		// 釦品番
		var btnMateStkNoElem = jQuery('#wp3_btnMateStkNo');

		// 選択肢をクリア
		btnMateStkNoElem.empty();

		if (btnMate == '包み') {
			jQuery('#wp3_btnMateStkNo').hide();
			jQuery('#wp3_btnMateStkNo').prop('disabled', true);
		} else if (btnMateStkNoList[btnMate]) {
			jQuery('#wp3_btnMateStkNo').show();
			jQuery('#wp3_btnMateStkNo').prop('disabled', false);
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < btnMateStkNoList[btnMate].length; i++) {
				btnMateStkNoElem.append(jQuery('<option />').val(btnMateStkNoList[btnMate][i]).text(btnMateStkNoList[btnMate][i]));
			}
		}
	});
	jQuery('#wp3_button').change();

	// JKと同じボタン
	jQuery('#wp3_sameJacketBtn').click(function(){

		// JACKETの釦素材を取得
		var jacketBtnMate = jQuery('#wj_btnMate').val();

		// JACKETの釦素材をPANTSの釦素材にコピー
		jQuery('#wp3_button').val(jacketBtnMate);
		// 釦素材変更処理
		jQuery('#wp3_button').change();

		// JACKETの釦品番を取得
		var jacketBtnMateStkNo = jQuery('#wj_btnMateStkNo').val();
		// JACKETの釦品番をPANTSの釦品番にコピー
		jQuery('#wp3_btnMateStkNo').val(jacketBtnMateStkNo);
	});
}

//--------------------------------------------
// 部品
//--------------------------------------------
//ボタンホール色指定箇所の有効/無効を制御する
function ctrlWp3BhColorPlace() {

	// 選択中のボタンホール色指定
	var wp3_bhColor = jQuery('input[name="wp3_bhColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name=wp3_pisPktUf]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name=wp3_pisPktDf]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="wp3_flapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#wp3_bhColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (wp3_bhColor == "有り") {
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
function ctrlWp3ByColorPlace() {

	// 選択中のボタン付け糸指定
	var wp3_byColor = jQuery('input[name="wp3_byColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name=wp3_pisPktUf]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name=wp3_pisPktDf]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="wp3_flapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#wp3_byColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (wp3_byColor == "有り") {
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
function wp3PancherinaSpecialController() {

	// 現在選択中のPANTSモデル
	var selectedPantsModel = jQuery('#wp3_pantsModel').val();

	// 現在選択中のパンチェリーナ
	var selectedPancherina = jQuery('input[name=wp3_pancherina]:checked').val();

	// 特定のモデル以外はパンチェリーナ選択不可
	if (selectedPantsModel != 'TR02'
			&& selectedPantsModel != 'CH14'
			&& selectedPantsModel != 'NZ01'
			&& selectedPantsModel != 'JW21'
			&& selectedPantsModel != 'AY01') {

		jQuery('#wp3_pancherina_no').prop("disabled", true);
		jQuery('#wp3_pancherina_no').prop("checked", true);
		jQuery('#wp3_pancherina_no').change();
		jQuery('#wp3_pancherina_yes').prop("disabled", true);

	} else {

		// 後続処理のために一旦パンチェリーナの選択肢を活性化させる
		jQuery('#wp3_pancherina_no').prop("disabled", false);
		jQuery('#wp3_pancherina_yes').prop("disabled", false);

		// 現在のフロント仕様を取得
		var selectedFrontSpec = jQuery('input[name=wp3_frontSpec]:checked').val();

		// フロント仕様がホック留めの場合はパンチェリーナは無し固定
		if (selectedFrontSpec == 'ホック留め') {
			jQuery('#wp3_pancherina_yes').prop('disabled', true);
			jQuery('#wp3_pancherina_no').prop('checked', true);
		}
	}

	// 処理後のパンチェリーナ
	var changedPancherina = jQuery('input[name=wp3_pancherina]:checked').val();
}

//ベルトループ変更時処理
function wp3ChangedBeltLoop() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name=wp3_beltLoop]:checked').val();
	var disabledFlg = false;

	if (selectedBeltLoop == '有り') {
		// 表示
		jQuery('#wp3_beltLoopPlace').show();
	} else {
		// 非表示
		jQuery('#wp3_beltLoopPlace').hide();
		disabledFlg = true;
	}

	// ベルトループ項目の活性/非活性
	jQuery('input[id^="wp3_beltLoopPlace_"]').each(function() {
		var tmpBeltLoopElem = jQuery(this);
		tmpBeltLoopElem.prop("disabled", disabledFlg);
		if (!disabledFlg) {
			tmpBeltLoopElem.prop("checked", true);
		}
	});

	// ピンループ特殊制御
	wp3PinLoopSpecialController();
}

//ピンループ特殊制御
function wp3PinLoopSpecialController() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name=wp3_beltLoop]:checked').val();
	// 選択中のピンループ
	var selectedPinLoop = jQuery('input[name=wp3_pinLoop]:checked').val();

	if (selectedBeltLoop == '無し（ベルトレス）') {
		// ベルトループ無しの場合はピンループ無し固定
		jQuery('input[id="wp3_pinLowp3_yes"]').prop("disabled", true);
		jQuery('input[id="wp3_pinLowp3_no"]').prop("disabled", false);
		jQuery('input[id="wp3_pinLowp3_no"]').prop("checked", true);
	} else {
		jQuery('input[id="wp3_pinLowp3_yes"]').prop("disabled", false);
		jQuery('input[id="wp3_pinLowp3_no"]').prop("disabled", false);
	}

	// 処理後のピンループ
	var changedPinLoop = jQuery('input[name=wp3_pinLoop]:checked').val();
}

//ダブルステッチの特殊制御を行う
function wp3DStichSpecialController() {

	// 選択中のAMFステッチ
	var selectedStich = jQuery('input[name=wp3_stitch]:checked').val();

	// AMFステッチが有りの場合はダブルステッチを有効化する
	if (selectedStich == 'AMFステッチ') {
		jQuery('input[name="wp3_dStitchModify"]').prop("disabled", false);
	} else {
		jQuery('input[name="wp3_dStitchModify"]').prop("disabled", true);
		jQuery('input[id="wp3_dStitchModify_no"]').prop("checked", true);
	}
}

//ステッチ箇所変更の有効/無効を制御する
function ctrlWp3StitchModify() {

	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="wp3_stitchModify"]:checked').val();

	// ステッチ箇所変更の有無で下位階層の表示制御
	if (stitchModifyValue != '無し') {
		jQuery('#wp3_stitchModify_yes_area').show();
	} else {
		jQuery('#wp3_stitchModify_yes_area').hide();
	}

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#wp3_pantsModel').val();

	if (!opStitchModifyList[pantsModel]) {
		// Pantsモデルが定義にない場合はすべて変更不可
		jQuery('input[id^="wp3_stitchModifyPlace_"]').each(function() {
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
		tmpStitchModify = jQuery('#wp3_stitchModifyPlace_'+tmpStitchModifyPlace);

		// 有効無効設定
		if (stitchModifyValue == '有り') {
			// 有りの場合、定義に基づいて設定変更
			tmpStitchModify.prop("disabled", false);
			// チェック状態の設定
			tmpStitchModify.prop("checked", stitchModifyDef.default);
		} else {
			tmpStitchModify.prop("disabled", true);
		}
	}

	// 全選択・全解除ボタン
	if (stitchModifyValue == '有り') {
		jQuery('#btn_as_wp3_stitchModifyPlace').prop("disabled", false);
		jQuery('#btn_ar_wp3_stitchModifyPlace').prop("disabled", false);
	} else {
		jQuery('#btn_as_wp3_stitchModifyPlace').prop("disabled", true);
		jQuery('#btn_ar_wp3_stitchModifyPlace').prop("disabled", true);
	}
}

//ステッチ箇所変更(ピスフラップ)の有効/無効を制御する
function ctrlWp3StitchModifyPisFlap() {

	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="wp3_stitchModify"]:checked').val();

	// ステッチ箇所変更無しの場合は処理終了
	if (stitchModifyValue == '無し') {
		return;
	}

	// ピスフラップの要素取得
	stitchModifyPisFlap = jQuery('#wp3_stitchModifyPlace_pisFlap');

	// 選択中の上前ピスポケット
	var pisPktUf = jQuery('input[name="wp3_pisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var pisPktDf = jQuery('input[name="wp3_pisPktDf"]:checked').val();

	// 上前ピスポケットと下前ピスポケットのどちらかがフラップ/ボタン有の場合は選択可
	if (pisPktUf == 'フラップ/ボタン有' || pisPktDf == 'フラップ/ボタン有') {
		stitchModifyPisFlap.prop("disabled", false);
	} else {
		stitchModifyPisFlap.prop("disabled", true);
		stitchModifyPisFlap.prop("checked", false);
	}
}

//ダブルステッチの有効/無効を制御する
function ctrlWp3DStitch() {
	// 選択中のステッチ箇所変更
	var dStitchValue = jQuery('input[name="wp3_dStitchModify"]:checked').val();

	if (dStitchValue == "有り") {
		jQuery('#wp3_dStitchModify_yes_area').show();
	} else {
		jQuery('#wp3_dStitchModify_yes_area').hide();
	}

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#wp3_pantsModel').val();

	if (!opStitchModifyList[pantsModel]) {
		// Pantsモデルが定義にない場合はすべて変更不可
		jQuery('input[id^="wp3_dStitchModifyPlace_"]').each(function() {
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
		tmpStitchModify = jQuery('#wp3_dStitchModifyPlace_'+tmpStitchModifyPlace);

		// 有効無効設定
		if (dStitchValue == '有り') {
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
function ctrlWp3DStitchPlace() {

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#wp3_pantsModel').val();
	if (pantsModel == '選択') {
		// 未選択時は何もしない
		return;
	}

	// 選択中のステッチ箇所変更
	var dStitchValue = jQuery('input[name="wp3_dStitchModify"]:checked').val();

	var tmpStitchModifyPlace = null;
	var tmpStitchModify = null;
	var stichModifyChecked = false;

	for (tmpStitchModifyPlace in opStitchModifyList[pantsModel]) {
		// 定義取得
		stitchModifyDef = opStitchModifyList[pantsModel][tmpStitchModifyPlace];
		// ダブルステッチ要素取得
		tmpStitchModify = jQuery('#wp3_dStitchModifyPlace_'+tmpStitchModifyPlace);
		// ステッチ箇所変更要素取得
		stichModifyChecked = jQuery('#wp3_stitchModifyPlace_'+tmpStitchModifyPlace).prop("checked");

		// 有効無効設定
		if (dStitchValue == '有り' && stichModifyChecked) {
			// 有りの場合、定義に基づいて設定変更
			tmpStitchModify.prop("disabled", false);
		} else {
			// 無しの場合、無効にする
			tmpStitchModify.prop("disabled", true);
			tmpStitchModify.prop("checked", false);
		}
	}
}

//AMF色指定の有効/無効を制御する
function ctrlWp3AmfColor() {
	// 選択中のステッチ箇所変更
	var amfColorValue = jQuery('input[name="wp3_amfColor"]:checked').val();

	if (amfColorValue == "有り") {
		jQuery('#wp3_amfColor_div').show();
	} else {
		jQuery('#wp3_amfColor_div').hide();
	}

	// AMF色指定の有効/無効設定
	jQuery('input[id^="wp3_amfColorPlace_"]').each(function() {
		if (amfColorValue == "有り") {
			// 有りの場合はステッチ箇所変更に基づく
			var id = this.id;
			id = id.replace("wp3_amfColorPlace", "wp3_stitchModifyPlace");
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