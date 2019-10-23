/*********************************************
 * ウォッシャブルPANTS2用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionPants2Washable() {
	jQuery('#wp2_pantsModel').attr("oldWpPants2Model",jQuery('#wp2_pantsModel').val());
	// PANTSモデル
	jQuery('#wp2_pantsModel').change(function() {
		// 選択されたPantsモデルを取得
		var pantsModel = jQuery(this).val();

		var pantsoldModel = jQuery('#wp2_pantsModel').attr("oldWpPants2Model");
		if (pantsModel != pantsoldModel) {
			jQuery("#pants2Flag").val("0");
		}else{
			jQuery("#pants2Flag").val("1");
		}
		jQuery('#wp2_pantsModel').attr("oldWpPants2Model",jQuery('#wp2_pantsModel').val());
		var pantsFlag = jQuery("#pants2Flag").val();
		if(pantsFlag == "0"){
			// 選択されたJacketモデルを取得
			if (pantsModel == '') {
				// 未選択時は何もしない
				return;
			}
		// 選択中のタック
		var tackElem = jQuery('#wp2_tack');
		//var selectedTack = tackElem.val();

		// タックの選択肢更新
		tackElem.empty();
		var tmpTack = null;
		for (tmpTack of tackList[pantsModel].activeList) {
			tackElem.append(jQuery('<option />').val(tmpTack.val).text(tmpTack.text));
		}
		// デフォルトを選択
		tackElem.val(tackList[pantsModel].defaultValue);

//		// フロント仕様設定
//		var sFrontSpec = defaultFrontSpec[pantsModel];
//		jQuery('input[name="coOptionPants2WashableInfo.wp2FrontSpec"]').val([sFrontSpec]);

		// パンチェリーナ特殊制御
		wp2PancherinaSpecialController();

		// 選択中のアジャスター仕様
		var selectedAdjuster = jQuery('input[name="coOptionPants2WashableInfo.wp2Adjuster"]:checked').val();

		// アジャスター仕様の選択肢制御
		jQuery('input[id^="wp2_adjuster_"]').each(function() {
			var tmpWp2AdjusterElem = jQuery(this);
			var value = tmpWp2AdjusterElem.val();

			if (adjusterList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なアジャスター仕様の場合、有効化
				tmpWp2AdjusterElem.prop("disabled", false);
			} else {
				// 有効なアジャスター仕様ではない場合、無効化
				tmpWp2AdjusterElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name="coOptionPants2WashableInfo.wp2Adjuster"]').val([adjusterList[pantsModel].defaultValue]);

		// 選択中のベルトループ
		var selectedBeltLoop = jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]:checked').val();

		// ベルトループの選択肢制御
		jQuery('input[id^="wp2_beltLowp2_"]').each(function() {
			var tmpWp2BeltLoopElem = jQuery(this);
			var value = tmpWp2BeltLoopElem.val();

			if (beltLoopList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なベルトループの場合、有効化
				tmpWp2BeltLoopElem.prop("disabled", false);
			} else {
				// 有効なベルトループではない場合、無効化
				tmpWp2BeltLoopElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]').val([beltLoopList[pantsModel].defaultValue]);
		jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]').change();

		// ベルトループ変更時処理
		wp2ChangedBeltLoop();

		// 選択中の脇ポケット
		var sidePktElem = jQuery('input[name="coOptionPants2WashableInfo.wp2SidePkt"]:checked');
		var selectedSidePkt = sidePktElem.val();

		// モデルに基づくデフォルトの脇ポケット
		var modelSidePkt = pantsModelDefaultList[pantsModel].op_sidePkt;
		// デフォルトを選択
		jQuery('input[name="coOptionPants2WashableInfo.wp2SidePkt"]').val([modelSidePkt]);

		// 選択中の忍びポケット
		var sinobiPktElem = jQuery('input[name="coOptionPants2WashableInfo.wp2SinobiPkt"]:checked');
		var selectedSinobiPkt = sinobiPktElem.val();

		// モデルに基づくデフォルトの忍びポケット
		var modelSinobiPkt = pantsModelDefaultList[pantsModel].op_sinobiPkt;
		// デフォルトを選択
		jQuery('input[name="coOptionPants2WashableInfo.wp2SinobiPkt"]').val([modelSinobiPkt]);

		// モデルに基づくデフォルトのコインポケット
		var modelCoinPkt = pantsModelDefaultList[pantsModel].op_coinPkt;
		// デフォルトを選択
		jQuery('#wp2_coinPkt').val([modelCoinPkt]);
		jQuery('#wp2_coinPkt').change();

		// 選択中の上前ピスポケット
		var pisPktUf = jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktUf"]:checked');
		var selectedPisPktUf = pisPktUf.val();

		// モデルに基づくデフォルトの上前ピスポケット
		var modelPisPktUf = pantsModelDefaultList[pantsModel].op_pisPktUf;
		// デフォルトを選択
		jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktUf"]').val([modelPisPktUf]);
		jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktUf"]').change();

		// 選択中の下前ピスポケット
		var pisPktDf = jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktDf"]:checked');
		var selectedPisPktDf = pisPktDf.val();

		// モデルに基づくデフォルトの下前ピスポケット
		var modelPisPktDf = pantsModelDefaultList[pantsModel].op_pisPktDf;
		// デフォルトを選択
		jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktDf"]').val([modelPisPktDf]);
		jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktDf"]').change();

		// 選択中のVカット
		var vCut = jQuery('input[name="coOptionPants2WashableInfo.wp2VCut"]:checked');
		var selectedVCut = vCut.val();

		// モデルに基づくデフォルトのVカット
		var modelVCut = pantsModelDefaultList[pantsModel].op_vCut;
		// デフォルトを選択
		jQuery('input[name="coOptionPants2WashableInfo.wp2VCut"]').val([modelVCut]);

		// ステッチ箇所変更
		ctrlWp2StitchModify();
		ctrlWp2StitchModifyPisFlap();

		// ダブルステッチ
		ctrlWp2DStitch();
		ctrlWp2DStitchPlace();

		// AMF色指定の有効/無効を制御する
		ctrlWp2AmfColor();

		//AY01の場合、ベルトループ仕様とピンループの制御。
		if (pantsModel == "AY01") {
			jQuery('#wp2_beltLoop_id1').prop('disabled', true);
			jQuery('#wp2_beltLoop_id2').prop('disabled', false);
			jQuery('#wp2_beltLoop_id2').prop('checked', true);
			
			jQuery('#wp2_pinLoop_id1').prop('disabled', true);
			jQuery('#wp2_pinLoop_id2').prop('disabled', false);
			jQuery('#wp2_pinLoop_id2').prop('checked', true);
		}
		
		// 別モデルに変更された場合はアラート表示
		if ((tmpWp2PantsModel != '') && pantsModel != tmpWp2PantsModel) {
//		    appendAlert('wp2_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		    setAlert('wp2_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		}
		// 一時保存のモデルを更新
		tmpWp2PantsModel = pantsModel;
		}
	});

	// 膝裏
	jQuery('input[name="coOptionPants2WashableInfo.wp2KneeBack"]').each(function() {
		jQuery(this).change(function(){

			// 現在の膝裏を取得
			var selectedKneeBack = jQuery('input[name="coOptionPants2WashableInfo.wp2KneeBack"]:checked').val();
			var disabledFlg = false;

			if (selectedKneeBack == '0000202') {
				disabledFlg = true;
				jQuery('#wp2_kneeBackMate_div').hide();
			} else {
				jQuery('#wp2_kneeBackMate_div').show();
			}


			// 膝裏が無しの場合は膝裏素材を全て選択不可
			jQuery('input[id^="wp2_kneeBackMate_"]').each(function() {
				var tmpKneeBackMateElem = jQuery(this);
				tmpKneeBackMateElem.prop("disabled", disabledFlg);
			});
		});
	});

	// フロント仕様
	jQuery('input[name="coOptionPants2WashableInfo.wp2FrontSpec"]').each(function() {
		jQuery(this).change(function(){
			// パンチェリーナ特殊制御
			wp2PancherinaSpecialController();
		});
	});
	jQuery('#wp2_frontSpec_id1').change();

	// ベルトループ
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]').each(function() {
		jQuery(this).change(function(){
			// ベルトループ変更時処理
			wp2ChangedBeltLoop();
		});
	});
	wp2ChangedBeltLoop();

	// フラップ付コインポケット
	jQuery('input[name="coOptionPants2WashableInfo.wp2FlapCoinPkt"]').each(function() {
		jQuery(this).change(function(){
			// ボタンホール色指定箇所の制御
			ctrlWp2BhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlWp2ByColorPlace();
	    });
	});

	// 上前ピスポケット
	jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktUf"]').each(function() {
		jQuery(this).change(function(){
			// ステッチ箇所変更(ピスフラップ)の制御
			ctrlWp2StitchModifyPisFlap();
			// ダブルステッチ(選択肢)の制御
			ctrlWp2DStitchPlace();
			// ボタンホール色指定箇所の制御
			ctrlWp2BhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlWp2ByColorPlace();
		});
	});
	jQuery('#wp2_pisPktUf_id1').change();

	// 下前ピスポケット
	jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktDf"]').each(function() {
		jQuery(this).change(function(){
			// ステッチ箇所変更(ピスフラップ)の制御
			ctrlWp2StitchModifyPisFlap();
			// ダブルステッチ(選択肢)の制御
			ctrlWp2DStitchPlace();
			// ボタンホール色指定箇所の制御
			ctrlWp2BhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlWp2ByColorPlace();
		});
	});
	jQuery('#wp2_pisPktDf_id1').change();

	// 裾上げ
	jQuery('#wp2_hemUp').change(function() {

		// 現在の裾上げを取得
		var selectedHemUp = jQuery('#wp2_hemUp').val();

		// ダブルがつくもの以外は非表示にする
		//if (selectedHemUp == '0001702' || selectedHemUp == 'ダブルスナップ' || selectedHemUp == 'ダブルモーニングカット') {
		if (selectedHemUp == '0001702' || selectedHemUp == '0001703') {
			jQuery('#wp2_doubleWide_div').show();
		} else {
			jQuery('#wp2_doubleWide_div').hide();
			jQuery('input[id="wp2_doubleWide"]').prop("disabled",true);
		}
	});

	// AMFステッチ
	jQuery('input[name="coOptionPants2WashableInfo.wp2Stitch"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のAMFステッチ
			var stitchValue = jQuery('input[name="coOptionPants2WashableInfo.wp2Stitch"]:checked').val();

			if (stitchValue != "0001903") {
				// 有りの場合、関連する項目を有効化
				// ステッチ箇所変更
				jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModify"]').prop("disabled", false);

				// ダブルステッチ
				jQuery('input[name="coOptionPants2WashableInfo.wp2DStitch"]').prop("disabled", false);

				// AMF色指定
				jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor"]').prop("disabled", false);
			} else {
				// 無しの場合、関連する項目を無効化・値変更
				// ステッチ箇所変更
				jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModify"]').prop("disabled", true);
				jQuery('#wp2_stitchModify_id1').prop("checked", true);
				jQuery('#wp2_stitchModify_id1').change();

				// ダブルステッチ
				jQuery('input[name="coOptionPants2WashableInfo.wp2DStitch"]').prop("disabled", true);
				jQuery('#wp2_dStitch_id1').prop("checked", true);
				jQuery('#wp2_dStitch_id1').change();

				// AMF色指定
				jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor"]').prop("disabled", true);
				jQuery('#wp2_amfColor_id1').prop("checked", true);
				jQuery('#wp2_amfColor_id1').change();
			}

			// ダブルステッチの特殊制御
			wp2DStichSpecialController();
		});
	});

	// ステッチ箇所変更
	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModify"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のステッチ箇所変更
			var stitchModifyValue = jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModify"]:checked').val();

			if (stitchModifyValue == "0002001") {
				// 無しの場合は全て無効化
				jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace"]').prop("disabled", true);
				jQuery('#btn_as_wp2_stitchModifyPlace').prop("disabled", true);
				jQuery('#btn_ar_wp2_stitchModifyPlace').prop("disabled", true);
				jQuery('#wp2_stitchModify_yes_area').hide();
			} else {
				// 有りの場合は全て有効化
				jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace"]').prop("disabled", false);
				jQuery('#btn_as_wp2_stitchModifyPlace').prop("disabled", false);
				jQuery('#btn_ar_wp2_stitchModifyPlace').prop("disabled", false);
				jQuery('#wp2_stitchModify_yes_area').show();
			}

			// ステッチ箇所変更
			ctrlWp2StitchModify();
			ctrlWp2StitchModifyPisFlap();

			// ダブルステッチ
			ctrlWp2DStitch();
			ctrlWp2DStitchPlace();

			// AMF色指定の有効/無効を制御する
			ctrlWp2AmfColor();
		});
	});
	jQuery('#wp2_stitchModify_id1').change();

	// ステッチ箇所変更(選択肢)
	jQuery('input[id^="wp2_stitchModifyPlace_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のダブルステッチ変更
			ctrlWp2DStitchPlace();
			// AMF色指定の有効/無効を制御する
			ctrlWp2AmfColor();
		});
	});

	// ダブルステッチ
	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitch"]').each(function() {
		jQuery(this).change(function(){
			ctrlWp2DStitch();
			ctrlWp2DStitchPlace();
		});
	});

	// AMF色指定(有り/無し)
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor"]').each(function() {
		jQuery(this).change(function(){
			ctrlWp2AmfColor();
		});
	});
	ctrlWp2AmfColor();

	// AMF色指定(全選択)
	jQuery('#btn_as_wp2_amfColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#wp2_amfColorPlaceAll').val();
		
		jQuery('#wp2_amfColor_div input[type="checkBox"]').each(function(index, elemCheckBox){ 
			elemCheckBox = jQuery(elemCheckBox); 
			if(!elemCheckBox.prop("disabled")){ 
			var amfColorCheckBoxId = elemCheckBox.attr("id"); 
			jQuery('#'+amfColorCheckBoxId+'_div input[type="radio"]').each(function(index, elem){ 
			elem = jQuery(elem); 
			if (elem.val() == allColor) elem.prop('checked', true); 
			}); 
			} 
		}); 
	});

	// AMF色指定箇所
	jQuery('input[id^="wp2_amfColorPlace_"]').each(function() {
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

	// ボタンホール色指定(有り/無し)
	jQuery('input[id^="wp2_bhColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var wp2_bhColor = jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor"]:checked').val();

			if (wp2_bhColor == '0002701') {
				// 無しの場合は操作不可
				jQuery('input[id^="wp2_bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#wp2_bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_wp2_bhColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#wp2_bhColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタンホール色指定箇所の制御
				ctrlWp2BhColorPlace();
				jQuery('input[id^="wp2_bhColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#wp2_bhColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_wp2_bhColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#wp2_bhColor_div').show();
			}
		});
	});
	jQuery('#wp2_bhColor_id1').change();

	// ボタンホール色指定(全選択)
	jQuery('#btn_as_wp2_bhColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#wp2_bhColorPlaceAll').val();

		jQuery('#wp2_bhColor_div input[type="checkBox"]').each(function(index, elemCheckBox){ 
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
	jQuery('input[id^="wp2_bhColorPlace_"]').each(function() {
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
	ctrlWp2BhColorPlace();

	// ボタン付け糸指定(有り/無し)
	jQuery('input[id^="wp2_byColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var wp2_byColor = jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor"]:checked').val();

			if (wp2_byColor == '0003001') {
				// 無しの場合は操作不可
				jQuery('input[id^="wp2_byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#wp2_byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_wp2_byColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#wp2_byColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタン付け糸指定箇所の制御
				ctrlWp2ByColorPlace();
				jQuery('input[id^="wp2_byColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#wp2_byColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_wp2_byColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#wp2_byColor_div').show();
			}
		});
	});
	jQuery('#wp2_byColor_id1').change();

	// ボタン付け糸指定(全選択)
	jQuery('#btn_as_wp2_byColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#wp2_byColorPlaceAll').val();

		jQuery('#wp2_byColor_div input[type="checkBox"]').each(function(index, elemCheckBox){ 
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
	jQuery('input[id^="wp2_byColorPlace_"]').each(function() {
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
	ctrlWp2ByColorPlace();

	// 釦素材
	/*jQuery('#wp2_button').change(function (){
		var btnMate = jQuery('#wp2_button').val();

		// 釦品番
		var btnMateStkNoElem = jQuery('#wp2_btnMateStkNo');

		// 選択肢をクリア
		btnMateStkNoElem.empty();

		if (btnMate == '包み') {
			jQuery('#wp2_btnMateStkNo').hide();
			jQuery('#wp2_btnMateStkNo').prop('disabled', true);
		} else if (btnMateStkNoList[btnMate]) {
			jQuery('#wp2_btnMateStkNo').show();
			jQuery('#wp2_btnMateStkNo').prop('disabled', false);
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < btnMateStkNoList[btnMate].length; i++) {
				btnMateStkNoElem.append(jQuery('<option />').val(btnMateStkNoList[btnMate][i]).text(btnMateStkNoList[btnMate][i]));
			}
		}
	});
	jQuery('#wp2_button').change();*/

	// JKと同じボタン
	jQuery('#wp2_sameJacketBtn').click(function(){

		// JACKETの釦素材を取得
		var jacketBtnMate = jQuery('#wj_btnMate').val();

		// JACKETの釦素材をPANTSの釦素材にコピー
		jQuery('#wp2_button').val(jacketBtnMate);
		// 釦素材変更処理
		jQuery('#wp2_button').change();

		// JACKETの釦品番を取得
		var jacketBtnMateStkNo = jQuery('#wj_btnMateStkNo').val();
		// JACKETの釦品番をPANTSの釦品番にコピー
		jQuery('#wp2_btnMateStkNo').val(jacketBtnMateStkNo);
	});
}

//--------------------------------------------
// 部品
//--------------------------------------------
//ボタンホール色指定箇所の有効/無効を制御する
function ctrlWp2BhColorPlace() {

	// 選択中のボタンホール色指定
	var wp2_bhColor = jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktDf"]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="coOptionPants2WashableInfo.wp2FlapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#wp2_bhColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (wp2_bhColor == "0002702") {
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

//ボタン付け糸指定箇所の有効/無効を制御する
function ctrlWp2ByColorPlace() {

	// 選択中のボタン付け糸指定
	var wp2_byColor = jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktDf"]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="coOptionPants2WashableInfo.wp2FlapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#wp2_byColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (wp2_byColor == "0003002") {
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

//パンチェリーナの特殊制御
function wp2PancherinaSpecialController() {

	// 現在選択中のPANTSモデル
	var selectedPantsModel = jQuery('#wp2_pantsModel').val();

	// 現在選択中のパンチェリーナ
	var selectedPancherina = jQuery('input[name="coOptionPants2WashableInfo.wp2Pancherina"]:checked').val();

	// 特定のモデル以外はパンチェリーナ選択不可
	if (selectedPantsModel != 'TR02'
			&& selectedPantsModel != 'CH14'
			&& selectedPantsModel != 'NZ01'
			&& selectedPantsModel != 'JW21'
			&& selectedPantsModel != 'AY01') {

		jQuery('#wp2_pancherina_id1').prop("disabled", true);
		jQuery('#wp2_pancherina_id1').prop("checked", true);
		jQuery('#wp2_pancherina_id1').change();
		jQuery('#wp2_pancherina_id1').prop("disabled", false);

	} else {

		// 後続処理のために一旦パンチェリーナの選択肢を活性化させる
		jQuery('#wp1_pancherina_id1').prop("disabled", false);
		jQuery('#wp2_pancherina_id2').prop("disabled", false);

		// 現在のフロント仕様を取得
		var selectedFrontSpec = jQuery('input[name="coOptionPants2WashableInfo.wp2FrontSpec"]:checked').val();

		// フロント仕様がホック留めの場合はパンチェリーナは無し固定
		if (selectedFrontSpec == '0000402') {
			jQuery('#wp2_pancherina_id2').prop('disabled', true);
			jQuery('#wp2_pancherina_id1').prop('disabled', false);
			jQuery('#wp2_pancherina_id1').prop('checked', true);
		}
	}

	// 処理後のパンチェリーナ
	var changedPancherina = jQuery('input[name="coOptionPants2WashableInfo.wp2Pancherina"]:checked').val();
}

//ベルトループ変更時処理
function wp2ChangedBeltLoop() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]:checked').val();
	//var disabledFlg = false;

	if (selectedBeltLoop == '0000701') {
		// 表示
		jQuery('#wp2_beltLoopPlace').show();
		jQuery("#wp2_beltLoopPlace_id1").prop("checked", true);
		jQuery("#wp2_beltLoopPlace_id2").prop("checked", true);
		jQuery("#wp2_beltLoopPlace_id3").prop("checked", true);
		jQuery("#wp2_beltLoopPlace_id4").prop("checked", true);
		jQuery("#wp2_beltLoopPlace_id5").prop("checked", true);
		jQuery("#wp2_beltLoopPlace_id6").prop("checked", true);
	} else {
		// 非表示
		jQuery('#wp2_beltLoopPlace').hide();
		jQuery("#wp2_beltLoopPlace_id1").prop("checked", false);
		jQuery("#wp2_beltLoopPlace_id2").prop("checked", false);
		jQuery("#wp2_beltLoopPlace_id3").prop("checked", false);
		jQuery("#wp2_beltLoopPlace_id4").prop("checked", false);
		jQuery("#wp2_beltLoopPlace_id5").prop("checked", false);
		jQuery("#wp2_beltLoopPlace_id6").prop("checked", false);
		//disabledFlg = true;
	}

	// ベルトループ項目の活性/非活性
	/*jQuery('input[id^="wp2_beltLoopPlace_"]').each(function() {
		var tmpBeltLoopElem = jQuery(this);
		tmpBeltLoopElem.prop("disabled", disabledFlg);
		if (!disabledFlg) {
			tmpBeltLoopElem.prop("checked", true);
		}
	});*/

	// ピンループ設定 ※アジャスター仕様が小でベルトループ有の場合に無しに設定する
	if (selectedBeltLoop == '0000701') {
		if (jQuery('input[name="coOptionPants2WashableInfo.wp2Adjuster"]:checked').val() == '0000603') {
			jQuery('#wp2_pinLoop_id1').prop('checked', 'true');
		}
	}	

	// フラシループ設定
	var frsAreaElem = jQuery('#wp2_beltLoopPlace_id17');
	if (jQuery('#wp2_pantsModel').val() == 'NZ01') {
		// 表示
		frsAreaElem.show();
	} else {
		jQuery("#wp2_beltLoopPlace_id7").prop("checked", false);
		// 非表示
		frsAreaElem.hide();
	}

	// ピンループ特殊制御
	wp2PinLoopSpecialController();
}

//ピンループ特殊制御
function wp2PinLoopSpecialController() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]:checked').val();
	// 選択中のピンループ
	var selectedPinLoop = jQuery('input[name="coOptionPants2WashableInfo.wp2PinLoop"]:checked').val();

	if (selectedBeltLoop == '0000702') {
		// ベルトループ無しの場合はピンループ無し固定
		jQuery('input[id="wp2_pinLoop_id1"]').prop("disabled", true);
		jQuery('input[id="wp2_pinLoop_id2"]').prop("disabled", false);
		jQuery('input[id="wp2_pinLoop_id2"]').prop("checked", true);
	} else {
		jQuery('input[id="wp2_pinLoop_id1"]').prop("disabled", false);
		jQuery('input[id="wp2_pinLoop_id2"]').prop("disabled", false);
		//jQuery(':radio[name="coOptionPants2WashableInfo.wp2PinLoop"]').prop('checked', true);
	}

//	// 処理後のピンループ
//	var changedPinLoop = jQuery('input[name="coOptionPants2WashableInfo.wp2PinLoop"]:checked').val();
}

//ダブルステッチの特殊制御を行う
function wp2DStichSpecialController() {

	// 選択中のAMFステッチ
	var selectedStich = jQuery('input[name="coOptionPants2StandardInfo.op2Stitch"]:checked').val();

	// AMFステッチが有りの場合はダブルステッチを有効化する
	if (selectedStich == '0001904') {
		jQuery('input[name="coOptionPants2WashableInfo.wp2DStitch"]').prop("disabled", false);
	} else {
		jQuery('input[name="coOptionPants2WashableInfo.wp2DStitch"]').prop("disabled", true);
		jQuery('input[id="wp2_dStitch_id1"]').prop("checked", true);
	}
}

//ステッチ箇所変更の有効/無効を制御する
function ctrlWp2StitchModify() {

	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModify"]:checked').val();

	// ステッチ箇所変更の有無で下位階層の表示制御
	if (stitchModifyValue != '0002001') {
		jQuery('#wp2_stitchModify_yes_area').show();
	} else {
		jQuery('#wp2_stitchModify_yes_area').hide();
	}

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#wp2_pantsModel').val();

	if (!opStitchModifyList[pantsModel]) {
		// Pantsモデルが定義にない場合はすべて変更不可
		jQuery('input[id^="wp2_stitchModifyPlace_"]').each(function() {
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
		tmpStitchModify = jQuery('#wp2_stitchModifyPlace_'+tmpStitchModifyPlace);

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
		jQuery('#btn_as_wp2_stitchModifyPlace').prop("disabled", false);
		jQuery('#btn_ar_wp2_stitchModifyPlace').prop("disabled", false);
	} else {
		jQuery('#btn_as_wp2_stitchModifyPlace').prop("disabled", true);
		jQuery('#btn_ar_wp2_stitchModifyPlace').prop("disabled", true);
	}
}

//ステッチ箇所変更(ピスフラップ)の有効/無効を制御する
function ctrlWp2StitchModifyPisFlap() {

	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModify"]:checked').val();

	// ステッチ箇所変更無しの場合は処理終了
	if (stitchModifyValue == '0002001') {
		return;
	}

	// ピスフラップの要素取得
	stitchModifyPisFlap = jQuery('#wp2_stitchModifyPlace_id4');

	// 選択中の上前ピスポケット
	var pisPktUf = jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var pisPktDf = jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktDf"]:checked').val();

	// 上前ピスポケットと下前ピスポケットのどちらかがフラップ/ボタン有の場合は選択可
	if (pisPktUf == '0001403' || pisPktDf == '0001503') {
		stitchModifyPisFlap.prop("disabled", false);
	} else {
		stitchModifyPisFlap.prop("disabled", true);
		stitchModifyPisFlap.prop("checked", false);
	}
}

//ダブルステッチの有効/無効を制御する
function ctrlWp2DStitch() {
	// 選択中のステッチ箇所変更
	var dStitchValue = jQuery('input[name="coOptionPants2WashableInfo.wp2DStitch"]:checked').val();

	if (dStitchValue == "0002202") {
		jQuery('#wp2_dStitchModify_yes_area').show();
	} else {
		jQuery('#wp2_dStitchModify_yes_area').hide();
	}

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#wp2_pantsModel').val();

	if (!opStitchModifyList[pantsModel]) {
		// Pantsモデルが定義にない場合はすべて変更不可
		jQuery('input[id^="wp2_dStitchModifyPlace_"]').each(function() {
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
		tmpStitchModify = jQuery('#wp2_dStitchModifyPlace_'+tmpStitchModifyPlace);

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
function ctrlWp2DStitchPlace() {

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#wp2_pantsModel').val();
	if (pantsModel == '' || pantsModel == null) {
		// 未選択時は何もしない
		return;
	}

	// 選択中のステッチ箇所変更
	var dStitchValue = jQuery('input[name="coOptionPants2WashableInfo.wp2DStitch"]:checked').val();

	var tmpStitchModifyPlace = null;
	var tmpStitchModify = null;
	var stichModifyChecked = false;

	for (tmpStitchModifyPlace in opStitchModifyList[pantsModel]) {
		// 定義取得
		stitchModifyDef = opStitchModifyList[pantsModel][tmpStitchModifyPlace];
		// ダブルステッチ要素取得
		tmpStitchModify = jQuery('#wp2_dStitchModifyPlace_'+tmpStitchModifyPlace);
		// ステッチ箇所変更要素取得
		stichModifyChecked = jQuery('#wp2_stitchModifyPlace_'+tmpStitchModifyPlace).prop("checked");

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

//AMF色指定の有効/無効を制御する
function ctrlWp2AmfColor() {
	// 選択中のステッチ箇所変更
	var amfColorValue = jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor"]:checked').val();

	if (amfColorValue == "0002402") {
		jQuery('#wp2_amfColor_div').show();
	} else {
		jQuery('#wp2_amfColor_div').hide();
	}

	// AMF色指定の有効/無効設定
	jQuery('input[id^="wp2_amfColorPlace_"]').each(function() {
		if (amfColorValue == "0002402") {
			// 有りの場合はステッチ箇所変更に基づく
			var id = this.id;
			id = id.replace("wp2_amfColorPlace_", "wp2_stitchModifyPlace_id");
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

jQuery('#wp2_coinPkt').change(function() {

	var selectedValue = jQuery('#wp2_coinPkt').val();

		jQuery('#wp2_flapCoinPkt_id2').prop('disabled', false);
	if (selectedValue == "0001201") {
		jQuery('#wp2_flapCoinPkt_id1').prop('checked', true);
		jQuery('#wp2_flapCoinPkt_id2').prop('disabled', true);
	}
	
	
});
jQuery('#wp2_coinPkt').change();

// アジャスター仕様変更時
jQuery('input[name="coOptionPants2WashableInfo.wp2Adjuster"]').change(function(index, elem) {
	var selected = jQuery('input[name="coOptionPants2WashableInfo.wp2Adjuster"]:checked').val();

	var oBLoopElemY = jQuery('#wp2_beltLoop_id1');
	var oBLoopElemN = jQuery('#wp2_beltLoop_id2');
	
	var oPLoopElemY = jQuery('#wp2_pinLoop_id1');
	var oPLoopElemN = jQuery('#wp2_pinLoop_id2');
	
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
	
	//AY01の場合、ベルトループ仕様とピンループの制御。
	var wp2PantsModel = jQuery('#wp2_pantsModel').val();
	if (wp2PantsModel == "AY01") {
		jQuery('#wp2_beltLoop_id1').prop('disabled', true);
		jQuery('#wp2_beltLoop_id2').prop('disabled', false);
		jQuery('#wp2_beltLoop_id2').prop('checked', true);
		
		jQuery('#wp2_pinLoop_id1').prop('disabled', true);
		jQuery('#wp2_pinLoop_id2').prop('disabled', false);
		jQuery('#wp2_pinLoop_id2').prop('checked', true);
	}

	wp2ChangedBeltLoop();

});
jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]').change(function(index, elem) {
	var wp2BeltLoop = jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]:checked').val();
	if (wp2BeltLoop == "0000701") {
		jQuery('#wp2_pinLoop_id1').prop('disabled', false);
		jQuery('#wp2_pinLoop_id1').prop('checked', true);
		jQuery('#wp2_pinLoop_id2').prop('disabled', false);
	}
});
jQuery('#wp2_adjuster_id1').change();

