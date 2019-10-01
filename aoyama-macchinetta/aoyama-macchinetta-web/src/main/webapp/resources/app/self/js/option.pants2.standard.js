/*********************************************
 * 標準PANTS2用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionPants2Standard() {

	jQuery('#op2_pantsModel').attr("oldPants2Model",jQuery('#op2_pantModel').val());
	// PANTSモデル
	jQuery('#op2_pantsModel').change(function() {
		// 選択されたPantsモデルを取得
		var pantsModel = jQuery(this).val();
		var pantsoldModel = jQuery('#op2_pantsModel').attr("oldPants2Model");
		if (pantsModel != pantsoldModel) {
			jQuery("#pants2Flag").val("0");
		}else{
			jQuery("#pants2Flag").val("1");
		}
		jQuery('#op2_pantsModel').attr("oldPants2Model",jQuery('#op2_pantsModel').val());
		var pants2Flag = jQuery("#pants2Flag").val();
		if(pants2Flag == "0"){
			// 選択されたJacketモデルを取得
			if (pantsModel == '') {
				// 未選択時は何もしない
				return;
			}

		// 選択中のタック
		var tackElem = jQuery('#op2_tack');
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
		jQuery('input[name="coOptionPants2StandardInfo.op2FrontSpec"]').val([sFrontSpec]);

		// パンチェリーナ特殊制御
		pancherinaSpecialController2();

		// 選択中のアジャスター仕様
		var selectedAdjuster = jQuery('input[name="coOptionPants2StandardInfo.op2Adjuster"]:checked').val();

		// アジャスター仕様の選択肢制御
		jQuery('input[id^="op2_adjuster_"]').each(function() {
			var tmpOp2AdjusterElem = jQuery(this);
			var value = tmpOp2AdjusterElem.val();

			if (adjusterList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なアジャスター仕様の場合、有効化
				tmpOp2AdjusterElem.prop("disabled", false);
			} else {
				// 有効なアジャスター仕様ではない場合、無効化
				tmpOp2AdjusterElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name="coOptionPants2StandardInfo.op2Adjuster"]').val([adjusterList[pantsModel].defaultValue]);

		// 選択中のベルトループ
		var selectedBeltLoop = jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoop"]:checked').val();

		// ベルトループの選択肢制御
		jQuery('input[id^="op2_beltLoop_"]').each(function() {
			var tmpOp2BeltLoopElem = jQuery(this);
			var value = tmpOp2BeltLoopElem.val();

			if (beltLoopList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なベルトループの場合、有効化
				tmpOp2BeltLoopElem.prop("disabled", false);
			} else {
				// 有効なベルトループではない場合、無効化
				tmpOp2BeltLoopElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoop"]').val([beltLoopList[pantsModel].defaultValue]);
		jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoop"]').change();

		// ベルトループ変更時処理
		changedBeltLoop2();

		// 選択中の脇ポケット
		var sidePktElem = jQuery('input[name="coOptionPants2StandardInfo.op2SidePkt"]:checked');
		var selectedSidePkt = sidePktElem.val();

		// モデルに基づくデフォルトの脇ポケット
		var modelSidePkt = pantsModelDefaultList[pantsModel].op_sidePkt;
		// デフォルトを選択
		jQuery('input[name="coOptionPants2StandardInfo.op2SidePkt"]').val([modelSidePkt]);

		// 選択中の忍びポケット
		var sinobiPktElem = jQuery('input[name="coOptionPants2StandardInfo.op2SinobiPkt"]:checked');
		var selectedSinobiPkt = sinobiPktElem.val();

		// モデルに基づくデフォルトの忍びポケット
		var modelSinobiPkt = pantsModelDefaultList[pantsModel].op_sinobiPkt;
		// デフォルトを選択
		jQuery('input[name="coOptionPants2StandardInfo.op2SinobiPkt"]').val([modelSinobiPkt]);

		// モデルに基づくデフォルトのコインポケット
		var modelCoinPkt = pantsModelDefaultList[pantsModel].op_coinPkt;
		// デフォルトを選択
		jQuery('#op2_coinPkt').val([modelCoinPkt]);
		jQuery('#op2_coinPkt').change();

		// 選択中の上前ピスポケット
		var pisPktUf = jQuery('input[name="coOptionPants2StandardInfo.op2PisPktUf"]:checked');
		var selectedPisPktUf = pisPktUf.val();

		// モデルに基づくデフォルトの上前ピスポケット
		var modelPisPktUf = pantsModelDefaultList[pantsModel].op_pisPktUf;
		// デフォルトを選択
		jQuery('input[name="coOptionPants2StandardInfo.op2PisPktUf"]').val([modelPisPktUf]);
		jQuery('input[name="coOptionPants2StandardInfo.op2PisPktUf"]').change();

		// 選択中の下前ピスポケット
		var pisPktDf = jQuery('input[name="coOptionPants2StandardInfo.op2PisPktDf"]:checked');
		var selectedPisPktDf = pisPktDf.val();

		// モデルに基づくデフォルトの下前ピスポケット
		var modelPisPktDf = pantsModelDefaultList[pantsModel].op_pisPktDf;
		// デフォルトを選択
		jQuery('input[name="coOptionPants2StandardInfo.op2PisPktDf"]').val([modelPisPktDf]);
		jQuery('input[name="coOptionPants2StandardInfo.op2PisPktDf"]').change();

		// 選択中のVカット
		var vCut = jQuery('input[name="coOptionPants2StandardInfo.op2VCut"]:checked');
		var selectedVCut = vCut.val();

		// モデルに基づくデフォルトのVカット
		var modelVCut = pantsModelDefaultList[pantsModel].op_vCut;
		// デフォルトを選択
		jQuery('input[name="coOptionPants2StandardInfo.op2VCut"]').val([modelVCut]);

		// ステッチ箇所変更
		ctrlOp2StitchModify();
		ctrlOp2StitchModifyPisFlap();

		// ダブルステッチ
		ctrlOp2DStitch();
		ctrlOp2DStitchPlace();

		// AMF色指定の有効/無効を制御する
		ctrlOp2AmfColor();

		// 別モデルに変更された場合はアラート表示
		if ((tmpOp2PantsModel != '' || tmpOp2PantsModel != null) && pantsModel != tmpOp2PantsModel) {
//		    appendAlert('op2_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		    setAlert('op2_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		}
		// 一時保存のモデルを更新
		tmpOp2PantsModel = pantsModel;
		}
	});

	// 膝裏
	jQuery('input[name="coOptionPants2StandardInfo.op2KneeBack"]').each(function() {
		jQuery(this).change(function(){

			// 現在の膝裏を取得
			var selectedKneeBack = jQuery('input[name="coOptionPants2StandardInfo.op2KneeBack"]:checked').val();
			var disabledFlg = false;

			if (selectedKneeBack == '0000202') {
				disabledFlg = true;
				jQuery('#op2_kneeBackMate_div').hide();
			} else {
				jQuery('#op2_kneeBackMate_div').show();
			}

			// 膝裏が無しの場合は膝裏素材を全て選択不可
			jQuery('input[id^="op2_kneeBackMate_"]').each(function() {
				var tmpKneeBackMateElem = jQuery(this);
				tmpKneeBackMateElem.prop("disabled", disabledFlg);
			});
		});
	});

	// フロント仕様
	jQuery('input[name="coOptionPants2StandardInfo.op2FrontSpec"]').each(function() {
		jQuery(this).change(function(){
			// パンチェリーナ特殊制御
			pancherinaSpecialController2();
		});
	});
	jQuery('#op2_frontSpec_id1').change();

	// ベルトループ
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoop"]').each(function() {
		jQuery(this).change(function(){
			// ベルトループ変更時処理
			changedBeltLoop2();
		});
	});
	changedBeltLoop2();
	// フラップ付コインポケット
	jQuery('input[name="coOptionPants2WashableInfo.wp2FlapCoinPkt"]').each(function() {
		jQuery(this).change(function(){
			// ボタンホール色指定箇所の制御
			ctrlOp2BhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlOp2ByColorPlace();
			
		});
	});

	// 上前ピスポケット
	jQuery('input[name="coOptionPants2StandardInfo.op2PisPktUf"]').each(function() {
		jQuery(this).change(function(){
			// ステッチ箇所変更(ピスフラップ)の制御
			ctrlOp2StitchModifyPisFlap();
			// ダブルステッチ(選択肢)の制御
			ctrlOp2DStitchPlace();
			// ボタンホール色指定箇所の制御
			ctrlOp2BhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlOp2ByColorPlace();
		});
	});
	jQuery('#op2_pisPktUf_id1').change();

	// 下前ピスポケット
	jQuery('input[name="coOptionPants2StandardInfo.op2PisPktDf"]').each(function() {
		jQuery(this).change(function(){
			// ステッチ箇所変更(ピスフラップ)の制御
			ctrlOp2StitchModifyPisFlap();
			// ダブルステッチ(選択肢)の制御
			ctrlOp2DStitchPlace();
			// ボタンホール色指定箇所の制御
			ctrlOp2BhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlOp2ByColorPlace();
		});
	});
	jQuery('#op2_pisPktDf_id1').change();

	// 裾上げ
	jQuery('#op2_hemUp').change(function() {

		// 現在の裾上げを取得
		var selectedHemUp = jQuery('#op2_hemUp').val();

		// ダブルがつくもの以外は非表示にする
		if (selectedHemUp == '0001702' || selectedHemUp == '0001703') {
			jQuery('#op2_doubleWide_div').show();
		} else {
			jQuery('#op2_doubleWide_div').hide();
			jQuery('input[id="op2_doubleWide"]').prop("disabled",true);
		}
	});

	// AMFステッチ
	jQuery('input[name="coOptionPants2StandardInfo.op2Stitch"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のAMFステッチ
			var stitchValue = jQuery('input[name="coOptionPants2StandardInfo.op2Stitch"]:checked').val();

			if (stitchValue != "0001903") {
				// 有りの場合、関連する項目を有効化
				// ステッチ箇所変更
				jQuery('input[name="coOptionPants2StandardInfo.op2StitchModify"]').prop("disabled", false);

				// ダブルステッチ
				jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]').prop("disabled", false);

				// AMF色指定
				jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor"]').prop("disabled", false);
				
				// 関連項目を表示
				jQuery('#op2_stitch_yes_area').show();
			} else {
				// 無しの場合、関連する項目を無効化・値変更
				// ステッチ箇所変更
				jQuery('input[name="coOptionPants2StandardInfo.op2StitchModify"]').prop("disabled", true);
				jQuery('#op2_stitchModify_id1').prop("checked", true);
				jQuery('#op2_stitchModify_id1').change();

				// ダブルステッチ
				jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]').prop("disabled", true);
				jQuery('#op2_dStitch_id1').prop("checked", true);
				jQuery('#op2_dStitch_id1').change();

				// AMF色指定
				jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor"]').prop("disabled", true);
				jQuery('#op2_amfColor_id1').prop("checked", true);
				jQuery('#op2_amfColor_id1').change();
				
				// 関連項目を非表示
				jQuery('#op2_stitch_yes_area').hide();
			}

			// ダブルステッチの特殊制御
			dStichSpecialController2();
		});
	});

	// ステッチ箇所変更
	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModify"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のステッチ箇所変更
			var stitchModifyValue = jQuery('input[name="coOptionPants2StandardInfo.op2StitchModify"]:checked').val();
			// 0002001(無し)
			if (stitchModifyValue == "0002001") {
				// 無しの場合は全て無効化
				jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace"]').prop("disabled", true);
				jQuery('#btn_as_op2_stitchModifyPlace').prop("disabled", true);
				jQuery('#btn_ar_op2_stitchModifyPlace').prop("disabled", true);

				jQuery('#op2_stitchModifyPlace').hide();
			} else {
				// 有りの場合は全て有効化
				jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace"]').prop("disabled", false);
				jQuery('#btn_as_op2_stitchModifyPlace').prop("disabled", false);
				jQuery('#btn_ar_op2_stitchModifyPlace').prop("disabled", false);

				jQuery('#op2_stitchModifyPlace').show();
			}

			// ステッチ箇所変更
			ctrlOp2StitchModify();
			ctrlOp2StitchModifyPisFlap();

			// ダブルステッチ
			ctrlOp2DStitch();
			ctrlOp2DStitchPlace();

			// AMF色指定の有効/無効を制御する
			ctrlOp2AmfColor();
		});
	});
	jQuery('#op2_stitchModify_id1').change();

	// ステッチ箇所変更(選択肢)
	jQuery('input[id^="op2_stitchModifyPlace_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のダブルステッチ変更
			ctrlOp2DStitchPlace();
			// AMF色指定の有効/無効を制御する
			ctrlOp2AmfColor();
		});
	});

	// ダブルステッチ
	jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]').each(function() {
		jQuery(this).change(function(){
			ctrlOp2DStitch();
			ctrlOp2DStitchPlace();
		});
	});
	jQuery('#op2_dStitch_id1').change();

	// AMF色指定(有り/無し)
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor"]').each(function() {
		jQuery(this).change(function(){
			ctrlOp2AmfColor();
		});
	});
	ctrlOp2AmfColor();

	// AMF色指定(全選択)
	jQuery('#btn_as_op2_amfColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#op2_amfColorPlaceAll').val();

		jQuery('#op2_amfColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// AMF色指定箇所
	jQuery('input[id^="op2_amfColorPlace_"]').each(function() {
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
	jQuery('input[id^="op2_bhColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var op2_bhColor = jQuery('input[name="coOptionPants2StandardInfo.op2BhColor"]:checked').val();

			if (op2_bhColor == '0002701') {
				// 無しの場合は操作不可
				jQuery('input[id^="op2_bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#op2_bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_op2_bhColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#op2_bhColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタンホール色指定箇所の制御
				ctrlOp2BhColorPlace();
				jQuery('input[id^="op2_bhColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#op2_bhColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_op2_bhColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#op2_bhColor_div').show();
			}
		});
	});
	jQuery('#op2_bhColor_id1').change();

	// ボタンホール色指定(全選択)
	jQuery('#btn_as_op2_bhColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#op2_bhColorPlaceAll').val();

		jQuery('#op2_bhColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタンホール色指定箇所
	jQuery('input[id^="op2_bhColorPlace_"]').each(function() {
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
	ctrlOp2BhColorPlace();

	// ボタン付け糸指定(有り/無し)
	jQuery('input[id^="op2_byColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var op2_byColor = jQuery('input[name="coOptionPants2StandardInfo.op2ByColor"]:checked').val();

			if (op2_byColor == '0003001') {
				// 無しの場合は操作不可
				jQuery('input[id^="op2_byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#op2_byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_op2_byColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#op2_byColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタン付け糸指定箇所の制御
				ctrlOp2ByColorPlace();
				jQuery('input[id^="op2_byColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#op2_byColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_op2_byColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#op2_byColor_div').show();
			}
		});
	});
	jQuery('#op2_byColor_id1').change();

	// ボタン付け糸指定(全選択)
	jQuery('#btn_as_op2_byColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#op2_byColorPlaceAll').val();

		jQuery('#op2_byColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタン付け糸指定箇所
	jQuery('input[id^="op2_byColorPlace_"]').each(function() {
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
	ctrlOp2ByColorPlace();

	// 釦素材
	/*jQuery('#op2_button').change(function (){
		var btnMate = jQuery('#op2_button').val();

		// 釦品番
		var btnMateStkNoElem = jQuery('#op2_btnMateStkNo');

		// 選択肢をクリア
		btnMateStkNoElem.empty();

		if (btnMateStkNoList[btnMate]) {
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < btnMateStkNoList[btnMate].length; i++) {
				btnMateStkNoElem.append(jQuery('<option />').val(btnMateStkNoList[btnMate][i]).text(btnMateStkNoList[btnMate][i]));
			}
		}
	});
	jQuery('#op2_button').change();*/

	// JKと同じボタン
	jQuery('#op2_sameJacketBtn').click(function(){

		// JACKETの釦素材を取得
		var jacketBtnMate = jQuery('#btnMate').val();
		// JACKETの釦素材をPANTSの釦素材にコピー
		jQuery('#op2_button').val(jacketBtnMate);
		// 釦素材変更処理
		jQuery('#op2_button').change();

		// JACKETの釦品番を取得
		var jacketBtnMateStkNo = jQuery('#btnMateStkNo').val();
		// JACKETの釦品番をPANTSの釦品番にコピー
		jQuery('#op2_btnMateStkNo').val(jacketBtnMateStkNo);
	});
}

//--------------------------------------------
// 部品
//--------------------------------------------
//ボタンホール色指定箇所の有効/無効を制御する
function ctrlOp2BhColorPlace() {

	// 選択中のボタンホール色指定
	var op2_bhColor = jQuery('input[name="coOptionPants2StandardInfo.op2BhColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name="coOptionPants2StandardInfo.op2PisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name="coOptionPants2StandardInfo.op2PisPktDf"]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="coOptionPants2StandardInfo.op2FlapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#op2_bhColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (op2_bhColor == "0002702") {
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
function ctrlOp2ByColorPlace() {

	// 選択中のボタン付け糸指定
	var op2_byColor = jQuery('input[name="coOptionPants2StandardInfo.op2ByColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name="coOptionPants2StandardInfo.op2PisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name="coOptionPants2StandardInfo.op2PisPktDf"]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="coOptionPants2StandardInfo.op2FlapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#op2_byColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (op2_byColor == "0003002") {
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
function pancherinaSpecialController2() {

	// 現在選択中のPANTSモデル
	var selectedPantsModel = jQuery('#op2_pantsModel').val();

	// 現在選択中のパンチェリーナ
	var selectedPancherina = jQuery('input[name="coOptionPants2StandardInfo.op2Pancherina"]:checked').val();

	// 特定のモデル以外はパンチェリーナ選択不可
	if (selectedPantsModel != 'TR02'
			&& selectedPantsModel != 'CH14'
			&& selectedPantsModel != 'NZ01'
			&& selectedPantsModel != 'JW21'
			&& selectedPantsModel != 'AY01') {

		jQuery('#op2_pancherina_id1').prop("disabled", true);
		jQuery('#op2_pancherina_id1').prop("checked", true);
		jQuery('#op2_pancherina_id1').change();
		jQuery('#op2_pancherina_id1').prop("disabled", true);

	} else {

		// 後続処理のために一旦パンチェリーナの選択肢を活性化させる
		jQuery('#op2_pancherina_id1').prop("disabled", false);
		jQuery('#op2_pancherina_id2').prop("disabled", false);

		// 現在のフロント仕様を取得
		var selectedFrontSpec = jQuery('input[name="coOptionPants2StandardInfo.op2FrontSpec"]:checked').val();

		// フロント仕様がホック留めの場合はパンチェリーナは無し固定
		if (selectedFrontSpec == '0000401') {
			jQuery('#op2_pancherina_id2').prop('disabled', true);
			jQuery('#op2_pancherina_id1').prop('checked', true);
		}
	}

	// 処理後のパンチェリーナ
	var changedPancherina = jQuery('input[name="coOptionPants2StandardInfo.op2Pancherina"]:checked').val();
}

//ベルトループ変更時処理
function changedBeltLoop2() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoop"]:checked').val();
	//var disabledFlg = false;
	if (selectedBeltLoop == '0000701') {
		// 表示
		jQuery('#op2_beltLoopPlace').show();
		jQuery("#op2_beltLoopPlace_id1").prop("checked", true);
		jQuery("#op2_beltLoopPlace_id2").prop("checked", true);
		jQuery("#op2_beltLoopPlace_id3").prop("checked", true);
		jQuery("#op2_beltLoopPlace_id4").prop("checked", true);
		jQuery("#op2_beltLoopPlace_id5").prop("checked", true);
		jQuery("#op2_beltLoopPlace_id6").prop("checked", true);
	} else {
		// 非表示
		jQuery('#op2_beltLoopPlace').hide();
		jQuery("#op2_beltLoopPlace_id1").prop("checked", false);
		jQuery("#op2_beltLoopPlace_id2").prop("checked", false);
		jQuery("#op2_beltLoopPlace_id3").prop("checked", false);
		jQuery("#op2_beltLoopPlace_id4").prop("checked", false);
		jQuery("#op2_beltLoopPlace_id5").prop("checked", false);
		jQuery("#op2_beltLoopPlace_id6").prop("checked", false);
		//disabledFlg = true;
	}

	// ベルトループ項目の活性/非活性
	/*jQuery('input[id^="op2_beltLoopPlace_"]').each(function() {
		var tmpBeltLoopElem = jQuery(this);
		tmpBeltLoopElem.prop("disabled", disabledFlg);
		if (!disabledFlg) {
		    tmpBeltLoopElem.prop("checked", true);
		}
	});*/

	// ピンループ設定 ※アジャスター仕様が小でベルトループ有の場合に無しに設定する
	if (selectedBeltLoop == '0000701') {
		if (jQuery('input[name="coOptionPants2StandardInfo.op2Adjuster"]:checked').val() == '0000603') {
			jQuery('#op2_pinLoop_id2').prop('checked', 'true');
		}
	}	

	// フラシループ設定
	var frsAreaElem = jQuery('#op2_beltLoopPlace_id17');
	if (jQuery('#op2_pantsModel').val() == 'NZ01') {
		// 表示
		frsAreaElem.show();
	} else {
		jQuery("#op2_beltLoopPlace_id7").prop("checked", false);
		// 非表示
		frsAreaElem.hide();
	}
	// ピンループ特殊制御
	pinLoopSpecialController2();
}

//ピンループ特殊制御
function pinLoopSpecialController2() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoop"]:checked').val();
	// 選択中のピンループ
	var selectedPinLoop = jQuery('input[name="coOptionPants2StandardInfo.op2PinLoop"]:checked').val();

	if (selectedBeltLoop == '0000702') {
		// ベルトループ無しの場合はピンループ無し固定
		jQuery('input[id="op2_pinLoop_id1"]').prop("disabled", true);
		jQuery('input[id="op2_pinLoop_id2"]').prop("disabled", false);
		jQuery('input[id="op2_pinLoop_id2"]').prop("checked", true);
	} else {
		jQuery('input[id="op2_pinLoop_id1"]').prop("disabled", false);
		jQuery('input[id="op2_pinLoop_id2"]').prop("disabled", false);
	}

	// 処理後のピンループ
	var changedPinLoop = jQuery('input[name="coOptionPants2StandardInfo.op2PinLoop"]:checked').val();
}

//ダブルステッチの特殊制御を行う
function dStichSpecialController2() {

	// 選択中のAMFステッチ
	var selectedStich = jQuery('input[name="coOptionPants2StandardInfo.op2Stitch"]:checked').val();

	// AMFステッチが有りの場合はダブルステッチを有効化する
	if (selectedStich == '0001904') {
		jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]').prop("disabled", false);
	} else {
		jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]').prop("disabled", true);
		jQuery('input[id="op2_dStitch_id1"]').prop("checked", true);
	}
}

//ステッチ箇所変更の有効/無効を制御する
function ctrlOp2StitchModify() {

	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="coOptionPants2StandardInfo.op2StitchModify"]:checked').val();

	// ステッチ箇所変更の有無で下位階層の表示制御
	if (stitchModifyValue != '0002001') {
		jQuery('#op2_stitchModify_yes_area').show();
	} else {
		jQuery('#op2_stitchModify_yes_area').hide();
	}

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#op2_pantsModel').val();

	if (!opStitchModifyList[pantsModel]) {
		// Pantsモデルが定義にない場合はすべて変更不可
		jQuery('input[id^="op2_stitchModifyPlace_"]').each(function() {
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
		tmpStitchModify = jQuery('#op2_stitchModifyPlace_'+tmpStitchModifyPlace);

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
		jQuery('#btn_as_op2_stitchModifyPlace').prop("disabled", false);
		jQuery('#btn_ar_op2_stitchModifyPlace').prop("disabled", false);
	} else {
		jQuery('#btn_as_op2_stitchModifyPlace').prop("disabled", true);
		jQuery('#btn_ar_op2_stitchModifyPlace').prop("disabled", true);
	}
}

//ステッチ箇所変更(ピスフラップ)の有効/無効を制御する
function ctrlOp2StitchModifyPisFlap() {

	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="coOptionPants2StandardInfo.op2StitchModify"]:checked').val();

	// ステッチ箇所変更無しの場合は処理終了
	if (stitchModifyValue == '0002001') {
		return;
	}

	// ピスフラップの要素取得
	stitchModifyPisFlap = jQuery('#op2_stitchModifyPlace_id4');

	// 選択中の上前ピスポケット
	var pisPktUf = jQuery('input[name="coOptionPants2StandardInfo.op2PisPktU"]:checked').val();
	// 選択中の下前ピスポケット
	var pisPktDf = jQuery('input[name="coOptionPants2StandardInfo.op2PisPktDf"]:checked').val();

	// 上前ピスポケットと下前ピスポケットのどちらかがフラップ/ボタン有の場合は選択可
	if (pisPktUf == '0001403' || pisPktDf == '0001503') {
		stitchModifyPisFlap.prop("disabled", false);
	} else {
		stitchModifyPisFlap.prop("disabled", true);
		stitchModifyPisFlap.prop("checked", false);
	}
}

//ダブルステッチの有効/無効を制御する
function ctrlOp2DStitch() {
	// 選択中のステッチ箇所変更
	var dStitchValue = jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]:checked').val();

	if (dStitchValue == "0002202") {
		jQuery('#op2_dStitch_yes_area').show();
	} else {
		jQuery('#op2_dStitch_yes_area').hide();
	}

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#op2_pantsModel').val();

	if (!opStitchModifyList[pantsModel]) {
		// Pantsモデルが定義にない場合はすべて変更不可
		jQuery('input[id^="op2_dStitchPlace_"]').each(function() {
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
		tmpStitchModify = jQuery('#op2_dStitchPlace_'+tmpStitchModifyPlace);

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
function ctrlOp2DStitchPlace() {

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#op2_pantsModel').val();
	if (pantsModel == '' || pantsModel == null) {
		// 未選択時は何もしない
		return;
	}

	// 選択中のステッチ箇所変更
	var dStitchValue = jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]:checked').val();

	var tmpStitchModifyPlace = null;
	var tmpStitchModify = null;
	var stichModifyChecked = false;

	for (tmpStitchModifyPlace in opStitchModifyList[pantsModel]) {
		// 定義取得
		stitchModifyDef = opStitchModifyList[pantsModel][tmpStitchModifyPlace];
		// ダブルステッチ要素取得
		tmpStitchModify = jQuery('#op2_dStitchPlace_'+tmpStitchModifyPlace);
		// ステッチ箇所変更要素取得
		stichModifyChecked = jQuery('#op2_stitchModifyPlace_'+tmpStitchModifyPlace).prop("checked");

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
function ctrlOp2AmfColor() {
	// 選択中のステッチ箇所変更
	var amfColorValue = jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor"]:checked').val();

	if (amfColorValue == "0002402") {
		jQuery('#op2_amfColor_div').show();
	} else {
		jQuery('#op2_amfColor_div').hide();
	}

	// AMF色指定の有効/無効設定
	jQuery('input[id^="op2_amfColorPlace_"]').each(function() {
		if (amfColorValue == "0002402") {
			// 有りの場合はステッチ箇所変更に基づく
			var id = this.id;
			id = id.replace("op2_amfColorPlace_", "op2_stitchModifyPlace_id");
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
jQuery('#op2_coinPkt').change(function() {

	var selectedValue = jQuery('#op2_coinPkt').val();

		jQuery('#op2_flapCoinPkt_id2').prop('disabled', false);
	if (selectedValue == "0001201") {
		jQuery('#op2_flapCoinPkt_id1').prop('checked', true);
		jQuery('#op2_flapCoinPkt_id2').prop('disabled', true);
	}
	
	
});
jQuery('#op2_coinPkt').change();

// アジャスター仕様変更時
jQuery('input[name="coOptionPants2StandardInfo.op2Adjuster"]').change(function(index, elem) {
	var selected = jQuery('input[name="coOptionPants2StandardInfo.op2Adjuster"]:checked').val();

	var oBLoopElemY = jQuery('#op2_beltLoop_id1');
	var oBLoopElemN = jQuery('#op2_beltLoop_id2');

	var oPLoopElemY = jQuery('#op2_pinLoop_id1');
	var oPLoopElemN = jQuery('#op2_pinLoop_id2');
	
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

	changedBeltLoop2();

});
jQuery('#op2_adjuster_id1').change();

