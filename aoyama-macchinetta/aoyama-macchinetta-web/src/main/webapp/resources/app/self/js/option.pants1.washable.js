/*********************************************
 * ウォッシャブルPANTS1用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionPants1Washable() {
	jQuery('#wp_pantsModel').attr("oldWpPantsModel",jQuery('#wp_pantsModel').val());
	// PANTSモデル
	jQuery('#wp_pantsModel').change(function() {
		// 選択されたPantsモデルを取得
		var pantsModel = jQuery(this).val();
		var pantsoldModel = jQuery('#wp_pantsModel').attr("oldWpPantsModel");
		if (pantsModel != pantsoldModel) {
			jQuery("#pantsFlag").val("0");
		}else{
			jQuery("#pantsFlag").val("1");
		}
		jQuery('#wp_pantsModel').attr("oldWpPantsModel",jQuery('#wp_pantsModel').val());
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
				jQuery("#wp_pantsModelCheck").empty();
				jQuery("#fabricMsg").empty();
			}else if(checkResult == "false"){
				//2はモデルチェク失敗の場合
				jQuery("#ptModelFlag").val("1"+"*"+getMsgByOneArg('msg065','PANTS'));
				appendAlertPo('wp_pantsModelCheck',getMsgByOneArg('msg065','PANTS'));
			}
		}
		
		// 選択中のタック
		var tackElem = jQuery('#wp_tack');
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
		jQuery('input[name="coOptionPantsWashableInfo.wpFrontSpec"]').val([sFrontSpec]);

		// パンチェリーナ特殊制御
		wpPancherinaSpecialController();

		// 選択中のアジャスター仕様
		var selectedAdjuster = jQuery('input[name="coOptionPantsWashableInfo.wpAdjuster"]:checked').val();

		// アジャスター仕様の選択肢制御
		jQuery('input[id^="wp_adjuster_"]').each(function() {
			var tmpWpAdjusterElem = jQuery(this);
			var value = tmpWpAdjusterElem.val();

			if (adjusterList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なアジャスター仕様の場合、有効化
				tmpWpAdjusterElem.prop("disabled", false);
			} else {
				// 有効なアジャスター仕様ではない場合、無効化
				tmpWpAdjusterElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name="coOptionPantsWashableInfo.wpAdjuster"]').val([adjusterList[pantsModel].defaultValue]);

		// 選択中のベルトループ
		var selectedBeltLoop = jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoop"]:checked').val();

		// ベルトループの選択肢制御
		jQuery('input[id^="wp_beltLowp_"]').each(function() {
			var tmpWpBeltLoopElem = jQuery(this);
			var value = tmpWpBeltLoopElem.val();

			if (beltLoopList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なベルトループの場合、有効化
				tmpWpBeltLoopElem.prop("disabled", false);
			} else {
				// 有効なベルトループではない場合、無効化
				tmpWpBeltLoopElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoop"]').val([beltLoopList[pantsModel].defaultValue]);
		jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoop"]').change();

		// ベルトループ変更時処理
		wpChangedBeltLoop();

		// 選択中の脇ポケット
		var sidePktElem = jQuery('input[name="coOptionPantsWashableInfo.wpSidePkt"]:checked');
		var selectedSidePkt = sidePktElem.val();

		// モデルに基づくデフォルトの脇ポケット
		var modelSidePkt = pantsModelDefaultList[pantsModel].op_sidePkt;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsWashableInfo.wpSidePkt"]').val([modelSidePkt]);

		// 選択中の忍びポケット
		var sinobiPktElem = jQuery('input[name="coOptionPantsWashableInfo.wpSinobiPkt"]:checked');
		var selectedSinobiPkt = sinobiPktElem.val();

		// モデルに基づくデフォルトの忍びポケット
		var modelSinobiPkt = pantsModelDefaultList[pantsModel].op_sinobiPkt;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsWashableInfo.wpSinobiPkt"]').val([modelSinobiPkt]);

		// モデルに基づくデフォルトのコインポケット
		var modelCoinPkt = pantsModelDefaultList[pantsModel].op_coinPkt;
		// デフォルトを選択
		jQuery('#wp_coinPkt').val([modelCoinPkt]);
		jQuery('#wp_coinPkt').change();

		// 選択中の上前ピスポケット
		var pisPktUf = jQuery('input[name="coOptionPantsWashableInfo.wpPisPktUf"]:checked');
		var selectedPisPktUf = pisPktUf.val();

		// モデルに基づくデフォルトの上前ピスポケット
		var modelPisPktUf = pantsModelDefaultList[pantsModel].op_pisPktUf;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsWashableInfo.wpPisPktUf"]').val([modelPisPktUf]);
		jQuery('input[name="coOptionPantsWashableInfo.wpPisPktUf"]').change();

		// 選択中の下前ピスポケット
		var pisPktDf = jQuery('input[name="coOptionPantsWashableInfo.wpPisPktDf"]:checked');
		var selectedPisPktDf = pisPktDf.val();

		// モデルに基づくデフォルトの下前ピスポケット
		var modelPisPktDf = pantsModelDefaultList[pantsModel].op_pisPktDf;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsWashableInfo.wpPisPktDf"]').val([modelPisPktDf]);
		jQuery('input[name="coOptionPantsWashableInfo.wpPisPktDf"]').change();

		// 選択中のVカット
		var vCut = jQuery('input[name="coOptionPantsWashableInfo.wpVCut"]:checked');
		var selectedVCut = vCut.val();

		// モデルに基づくデフォルトのVカット
		var modelVCut = pantsModelDefaultList[pantsModel].op_vCut;
		// デフォルトを選択
		jQuery('input[name="coOptionPantsWashableInfo.wpVCut"]').val([modelVCut]);

		// ステッチ箇所変更
		ctrlWpStitchModify();
		ctrlWpStitchModifyPisFlap();

		// ダブルステッチ
		ctrlWpDStitch();
		ctrlWpDStitchPlace();

		// AMF色指定の有効/無効を制御する
		ctrlWpAmfColor();

		// 別モデルに変更された場合はアラート表示
		if ((tmpWpPantsModel != '' || tmpWpPantsModel != null ) && pantsModel != tmpWpPantsModel) {
//		    appendAlert('wp_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		    setAlert('wp_pantsModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		}
		// 一時保存のモデルを更新
		tmpWpPantsModel = pantsModel;
		}
	});

	// 膝裏
	jQuery('input[name="coOptionPantsWashableInfo.wpKneeBack"]').each(function() {
		jQuery(this).change(function(){

			// 現在の膝裏を取得
			var selectedKneeBack = jQuery('input[name="coOptionPantsWashableInfo.wpKneeBack"]:checked').val();
			var disabledFlg = false;

			if (selectedKneeBack == '0000202') {
				disabledFlg = true;
				jQuery('#wp_kneeBackMate_div').hide();
			} else {
				jQuery('#wp_kneeBackMate_div').show();
			}


			// 膝裏が無しの場合は膝裏素材を全て選択不可
			jQuery('input[id^="wp_kneeBackMate_"]').each(function() {
				var tmpKneeBackMateElem = jQuery(this);
				tmpKneeBackMateElem.prop("disabled", disabledFlg);
			});
		});
	});

	// フロント仕様
	jQuery('input[name="coOptionPantsWashableInfo.wpFrontSpec"]').each(function() {
		jQuery(this).change(function(){
			// パンチェリーナ特殊制御
			wpPancherinaSpecialController();
		});
	});
	jQuery('#wp_frontSpec_id1').change();

	// ベルトループ
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoop"]').each(function() {
		jQuery(this).change(function(){
			// ベルトループ変更時処理
			wpChangedBeltLoop();
		});
	});
	wpChangedBeltLoop();

	// フラップ付コインポケット
	jQuery('input[name="coOptionPantsWashableInfo.wpFlapCoinPkt"]').each(function() {
		jQuery(this).change(function(){
			// ボタンホール色指定箇所の制御
			ctrlWpBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlWpByColorPlace();
	    });
	});

	// 上前ピスポケット
	jQuery('input[name="coOptionPantsWashableInfo.wpPisPktUf"]').each(function() {
		jQuery(this).change(function(){
			// ステッチ箇所変更(ピスフラップ)の制御
			ctrlWpStitchModifyPisFlap();
			// ダブルステッチ(選択肢)の制御
			ctrlWpDStitchPlace();
			// ボタンホール色指定箇所の制御
			ctrlWpBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlWpByColorPlace();
		});
	});
	jQuery('#wp_pisPktUf_id1').change();

	// 下前ピスポケット
	jQuery('input[name="coOptionPantsWashableInfo.wpPisPktDf"]').each(function() {
		jQuery(this).change(function(){
			// ステッチ箇所変更(ピスフラップ)の制御
			ctrlWpStitchModifyPisFlap();
			// ダブルステッチ(選択肢)の制御
			ctrlWpDStitchPlace();
			// ボタンホール色指定箇所の制御
			ctrlWpBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlWpByColorPlace();
		});
	});
	jQuery('#wp_pisPktDf_id1').change();

	// 裾上げ
	jQuery('#wp_hemUp').change(function() {

		// 現在の裾上げを取得
		var selectedHemUp = jQuery('#wp_hemUp').val();

		// ダブルがつくもの以外は非表示にする
		if (selectedHemUp == '0001702' || selectedHemUp == '0001703') {
			jQuery('#wp_doubleWide_div').show();
		} else {
			jQuery('#wp_doubleWide_div').hide();
			jQuery('input[id="wp_doubleWide"]').prop("disabled",true);
		}
	});

	// AMFステッチ
	jQuery('input[name="coOptionPantsWashableInfo.wpStitch"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のAMFステッチ
			var stitchValue = jQuery('input[name="coOptionPantsWashableInfo.wpStitch"]:checked').val();

			if (stitchValue != "0001903") {
				// 有りの場合、関連する項目を有効化
				// ステッチ箇所変更
				jQuery('input[name="coOptionPantsWashableInfo.wpStitchModify"]').prop("disabled", false);

				// ダブルステッチ
				jQuery('input[name="coOptionPantsWashableInfo.wpDStitch"]').prop("disabled", false);

				// AMF色指定
				jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor"]').prop("disabled", false);
			} else {
				// 無しの場合、関連する項目を無効化・値変更
				// ステッチ箇所変更
				jQuery('input[name="coOptionPantsWashableInfo.wpStitchModify"]').prop("disabled", true);
				jQuery('#wp_stitchModify_id1').prop("checked", true);
				jQuery('#wp_stitchModify_id1').change();

				// ダブルステッチ
				jQuery('input[name="coOptionPantsWashableInfo.wpDStitch"]').prop("disabled", true);
				jQuery('#wp_dStitch_id1').prop("checked", true);
				jQuery('#wp_dStitch_id1').change();

				// AMF色指定
				jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor"]').prop("disabled", true);
				jQuery('#wp_amfColor_id1').prop("checked", true);
				jQuery('#wp_amfColor_id1').change();
			}

			// ダブルステッチの特殊制御
			wpDStichSpecialController();
		});
	});

	// ステッチ箇所変更
	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModify"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のステッチ箇所変更
			var stitchModifyValue = jQuery('input[name="coOptionPantsWashableInfo.wpStitchModify"]:checked').val();

			if (stitchModifyValue == "0002001") {
				// 無しの場合は全て無効化
				jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace"]').prop("disabled", true);
				jQuery('#btn_as_wp_stitchModifyPlace').prop("disabled", true);
				jQuery('#btn_ar_wp_stitchModifyPlace').prop("disabled", true);
				jQuery('#wp_stitchModify_yes_area').hide();
			} else {
				// 有りの場合は全て有効化
				jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace"]').prop("disabled", false);
				jQuery('#btn_as_wp_stitchModifyPlace').prop("disabled", false);
				jQuery('#btn_ar_wp_stitchModifyPlace').prop("disabled", false);
				jQuery('#wp_stitchModify_yes_area').show();
			}

			// ステッチ箇所変更
			ctrlWpStitchModify();
			ctrlWpStitchModifyPisFlap();

			// ダブルステッチ
			ctrlWpDStitch();
			ctrlWpDStitchPlace();

			// AMF色指定の有効/無効を制御する
			ctrlWpAmfColor();
		});
	});
	jQuery('#wp_stitchModify_id1').change();

	// ステッチ箇所変更(選択肢)
	jQuery('input[id^="wp_stitchModifyPlace_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のダブルステッチ変更
			ctrlWpDStitchPlace();
			// AMF色指定の有効/無効を制御する
			ctrlWpAmfColor();
		});
	});

	// ダブルステッチ
	jQuery('input[name="coOptionPantsWashableInfo.wpDStitch"]').each(function() {
		jQuery(this).change(function(){
			ctrlWpDStitch();
			ctrlWpDStitchPlace();
		});
	});

	// AMF色指定(有り/無し)
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor"]').each(function() {
		jQuery(this).change(function(){
			ctrlWpAmfColor();
		});
	});
	ctrlWpAmfColor();

	// AMF色指定(全選択)
	jQuery('#btn_as_wp_amfColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#wp_amfColorPlaceAll').val();

		jQuery('#wp_amfColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// AMF色指定箇所
	jQuery('input[id^="wp_amfColorPlace_"]').each(function() {
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
	jQuery('input[id^="wp_bhColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var wp_bhColor = jQuery('input[name="coOptionPantsWashableInfo.wpBhColor"]:checked').val();

			if (wp_bhColor == '0002701') {
				// 無しの場合は操作不可
				jQuery('input[id^="wp_bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#wp_bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_wp_bhColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#wp_bhColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタンホール色指定箇所の制御
				ctrlWpBhColorPlace();
				jQuery('input[id^="wp_bhColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#wp_bhColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_wp_bhColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#wp_bhColor_div').show();
			}
		});
	});
	jQuery('#wp_bhColor_id1').change();

	// ボタンホール色指定(全選択)
	jQuery('#btn_as_wp_bhColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#wp_bhColorPlaceAll').val();

		jQuery('#wp_bhColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタンホール色指定箇所
	jQuery('input[id^="wp_bhColorPlace_"]').each(function() {
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
	ctrlWpBhColorPlace();

	// ボタン付け糸指定(有り/無し)
	jQuery('input[id^="wp_byColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var wp_byColor = jQuery('input[name="coOptionPantsWashableInfo.wpByColor"]:checked').val();

			// 0003001(無し)
			if (wp_byColor == '0003001') {
				// 無しの場合は操作不可
				jQuery('input[id^="wp_byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#wp_byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_wp_byColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#wp_byColor_div').hide();
			} else {
				// 有りの場合は操作可能

				// ボタン付け糸指定箇所の制御
				ctrlWpByColorPlace();
				jQuery('input[id^="wp_byColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#wp_byColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_wp_byColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#wp_byColor_div').show();
			}
		});
	});
	jQuery('#wp_byColor_id1').change();

	// ボタン付け糸指定(全選択)
	jQuery('#btn_as_wp_byColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#wp_byColorPlaceAll').val();

		jQuery('#wp_byColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタン付け糸指定箇所
	jQuery('input[id^="wp_byColorPlace_"]').each(function() {
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
	ctrlWpByColorPlace();

	/*// 釦素材
	jQuery('#wp_btnMate').change(function (){
		var btnMate = jQuery('#wp_btnMate').val();

		// 釦品番
		var btnMateStkNoElem = jQuery('#wp_btnMateStkNo');

		// 選択肢をクリア
		btnMateStkNoElem.empty();

		// 定義が存在する場合は品番を選択肢にセット
		for (var i = 0; i < btnMateStkNoList[btnMate].length; i++) {
			btnMateStkNoElem.append(jQuery('<option />').val(btnMateStkNoList[btnMate][i]).text(btnMateStkNoList[btnMate][i]));
		}
	});
	jQuery('#wp_btnMate').change();*/

	// JKと同じボタン
	jQuery('#wp_sameJacketBtn').click(function(){

		// JACKETの釦素材を取得
		var jacketBtnMate = jQuery('#wj_btnMate').val();

		// JACKETの釦素材をPANTSの釦素材にコピー
		jQuery('#wp_btnMate').val(jacketBtnMate);
		// 釦素材変更処理
		jQuery('#wp_btnMate').change();

		// JACKETの釦品番を取得
		var jacketBtnMateStkNo = jQuery('#wj_btnMateStkNo').val();
		// JACKETの釦品番をPANTSの釦品番にコピー
		jQuery('#wp_btnMateStkNo').val(jacketBtnMateStkNo);
	});
}

//--------------------------------------------
// 部品
//--------------------------------------------
//ボタンホール色指定箇所の有効/無効を制御する
function ctrlWpBhColorPlace() {

	// 選択中のボタンホール色指定
	var wp_bhColor = jQuery('input[name="coOptionPantsWashableInfo.wpBhColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name="coOptionPantsWashableInfo.wpPisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name="coOptionPantsWashableInfo.wpPisPktDf"]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="coOptionPantsWashableInfo.wpFlapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#wp_bhColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (wp_bhColor == "0002702") {
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
function ctrlWpByColorPlace() {

	// 選択中のボタン付け糸指定
	var wp_byColor = jQuery('input[name="coOptionPantsWashableInfo.wpByColor"]:checked').val();

	// 選択中の上前ピスポケット
	var selectedPisPktUf = jQuery('input[name="coOptionPantsWashableInfo.wpPisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var selectedPisPktDf = jQuery('input[name="coOptionPantsWashableInfo.wpPisPktDf"]:checked').val();
	// 選択中のフラップ付コインポケット
	var selectedFlapCoinPkt = jQuery('input[name="coOptionPantsWashableInfo.wpFlapCoinPkt"]:checked').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#wp_byColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		// 0003002(有り)
		if (wp_byColor == "0003002") {
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
function wpPancherinaSpecialController() {

	// 現在選択中のPANTSモデル
	var selectedPantsModel = jQuery('#wp_pantsModel').val();

	// 現在選択中のパンチェリーナ
	var selectedPancherina = jQuery('input[name="coOptionPantsWashableInfo.wpPancherina"]:checked').val();

	// 特定のモデル以外はパンチェリーナ選択不可
	if (selectedPantsModel != 'TR02'
			&& selectedPantsModel != 'CH14'
			&& selectedPantsModel != 'NZ01'
			&& selectedPantsModel != 'JW21'
			&& selectedPantsModel != 'AY01') {

		jQuery('#wp_pancherina_id1').prop("disabled", true);
		jQuery('#wp_pancherina_id1').prop("checked", true);
		jQuery('#wp_pancherina_id1').change();
		jQuery('#wp_pancherina_id2').prop("disabled", true);

	} else {

		// 後続処理のために一旦パンチェリーナの選択肢を活性化させる
		jQuery('#wp_pancherina_id1').prop("disabled", false);
		jQuery('#wp_pancherina_id2').prop("disabled", false);

		// 現在のフロント仕様を取得
		var selectedFrontSpec = jQuery('input[name="coOptionPantsWashableInfo.wpFrontSpec"]:checked').val();

		// フロント仕様がホック留めの場合はパンチェリーナは無し固定
		//0000401(ホック留め) 
		if (selectedFrontSpec == '0000401') {
		} else {
			jQuery('#wp_pancherina_id2').prop('disabled', true);
			jQuery('#wp_pancherina_id1').prop('checked', true);
		}
	}

	// 処理後のパンチェリーナ
	var changedPancherina = jQuery('input[name="coOptionPantsWashableInfo.wpPancherina"]:checked').val();
}

//ベルトループ変更時処理
function wpChangedBeltLoop() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoop"]:checked').val();
	//var disabledFlg = false;
	
	//0000701(有り)
	if (selectedBeltLoop == '0000701') {
		// 表示
		jQuery('#wp_beltLoopPlace').show();
		jQuery("#wp_beltLoopPlace_id1").prop("checked", true);
		jQuery("#wp_beltLoopPlace_id2").prop("checked", true);
		jQuery("#wp_beltLoopPlace_id3").prop("checked", true);
		jQuery("#wp_beltLoopPlace_id4").prop("checked", true);
		jQuery("#wp_beltLoopPlace_id5").prop("checked", true);
		jQuery("#wp_beltLoopPlace_id6").prop("checked", true);
	} else {
		// 非表示
		jQuery('#wp_beltLoopPlace').hide();
		jQuery("#wp_beltLoopPlace_id1").prop("checked", false);
		jQuery("#wp_beltLoopPlace_id2").prop("checked", false);
		jQuery("#wp_beltLoopPlace_id3").prop("checked", false);
		jQuery("#wp_beltLoopPlace_id4").prop("checked", false);
		jQuery("#wp_beltLoopPlace_id5").prop("checked", false);
		jQuery("#wp_beltLoopPlace_id6").prop("checked", false);
		//disabledFlg = true;
	}

	// ベルトループ項目の活性/非活性
	/*jQuery('input[id^="wp_beltLoopPlace_"]').each(function() {
		var tmpBeltLoopElem = jQuery(this);
		tmpBeltLoopElem.prop("disabled", disabledFlg);
		if (!disabledFlg) {
			tmpBeltLoopElem.prop("checked", true);
		}
	});*/

	// ピンループ設定 ※アジャスター仕様が小でベルトループ有の場合に無しに設定する
	//0000701(有り)
	if (selectedBeltLoop == '0000701') {
		//0000603(サイドアジャスター小)
		if (jQuery('input[name="coOptionPantsWashableInfo.wpAdjuster"]:checked').val() == '0000603') {
			jQuery('#wp_pinLoop_id2').prop('checked', 'true');
		}
	}
	
	// フラシループ設定
	var frsAreaElem = jQuery('#wp_beltLoopPlace_id17');
	if (jQuery('#wp_pantsModel').val() == 'NZ01') {
		// 表示
		frsAreaElem.show();
	} else {
		jQuery("#wp_beltLoopPlace_id7").prop("checked", false);
		// 非表示
		frsAreaElem.hide();
	}
	// ピンループ特殊制御
	wpPinLoopSpecialController();
}

//ピンループ特殊制御
function wpPinLoopSpecialController() {

	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoop"]:checked').val();
	// 選択中のピンループ
	var selectedPinLoop = jQuery('input[name="coOptionPantsWashableInfo.wpPinLoop"]:checked').val();

	// 0000702(無し)
	if (selectedBeltLoop == '0000702') {
		// ベルトループ無しの場合はピンループ無し固定
		jQuery('input[id="wp_pinLoop_id1"]').prop("disabled", true);
		jQuery('input[id="wp_pinLoop_id2"]').prop("disabled", false);
		jQuery('input[id="wp_pinLoop_id2"]').prop("checked", true);
	} else {
		jQuery('input[id="wp_pinLoop_id1"]').prop("disabled", false);
		jQuery('input[id="wp_pinLoop_id2"]').prop("disabled", false);
	}

	// 処理後のピンループ
	var changedPinLoop = jQuery('input[name="coOptionPantsWashableInfo.wpPinLoop"]:checked').val();
}

//ダブルステッチの特殊制御を行う
function wpDStichSpecialController() {

	// 選択中のAMFステッチ
	var selectedStich = jQuery('input[name="coOptionPantsStandardInfo.opStitch"]:checked').val();

	// AMFステッチが有りの場合はダブルステッチを有効化する
	// 0001904(AMFステッチ)
	if (selectedStich == '0001904') {
		jQuery('input[name="coOptionPantsWashableInfo.wpDStitch"]').prop("disabled", false);
	} else {
		jQuery('input[name="coOptionPantsWashableInfo.wpDStitch"]').prop("disabled", true);
		jQuery('input[id="wp_dStitch_id1"]').prop("checked", true);
	}
}

//ステッチ箇所変更の有効/無効を制御する
function ctrlWpStitchModify() {

	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="coOptionPantsWashableInfo.wpStitchModify"]:checked').val();

	// ステッチ箇所変更の有無で下位階層の表示制御
	// 0002001(無し)
	if (stitchModifyValue != '0002001') {
		jQuery('#wp_stitchModify_yes_area').show();
	} else {
		jQuery('#wp_stitchModify_yes_area').hide();
	}

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#wp_pantsModel').val();

	if (!opStitchModifyList[pantsModel]) {
		// Pantsモデルが定義にない場合はすべて変更不可
		jQuery('input[id^="wp_stitchModifyPlace_"]').each(function() {
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
		tmpStitchModify = jQuery('#wp_stitchModifyPlace_'+tmpStitchModifyPlace);

		// 有効無効設定
		// 0002002(有り)
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
	// 0002002(有り)
	if (stitchModifyValue == '0002002') {
		jQuery('#btn_as_wp_stitchModifyPlace').prop("disabled", false);
		jQuery('#btn_ar_wp_stitchModifyPlace').prop("disabled", false);
	} else {
		jQuery('#btn_as_wp_stitchModifyPlace').prop("disabled", true);
		jQuery('#btn_ar_wp_stitchModifyPlace').prop("disabled", true);
	}
}

//ステッチ箇所変更(ピスフラップ)の有効/無効を制御する
function ctrlWpStitchModifyPisFlap() {

	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="coOptionPantsWashableInfo.wpStitchModify"]:checked').val();

	// ステッチ箇所変更無しの場合は処理終了
	// 0002001(無し)
	if (stitchModifyValue == '0002001') {
		return;
	}

	// ピスフラップの要素取得
	stitchModifyPisFlap = jQuery('#wp_stitchModifyPlace_id4');

	// 選択中の上前ピスポケット
	var pisPktUf = jQuery('input[name="coOptionPantsWashableInfo.wpPisPktUf"]:checked').val();
	// 選択中の下前ピスポケット
	var pisPktDf = jQuery('input[name="coOptionPantsWashableInfo.wpPisPktDf"]:checked').val();

	// 上前ピスポケットと下前ピスポケットのどちらかがフラップ/ボタン有の場合は選択可
	// 0001403(上前ピスポケット	フラップ/ボタン有)
	// 0001503(下前ピスポケット	フラップ/ボタン有)
	if (pisPktUf == '0001403' || pisPktDf == '0001503') {
		stitchModifyPisFlap.prop("disabled", false);
	} else {
		stitchModifyPisFlap.prop("disabled", true);
		stitchModifyPisFlap.prop("checked", false);
	}
}

//ダブルステッチの有効/無効を制御する
function ctrlWpDStitch() {
	// 選択中のステッチ箇所変更
	var dStitchValue = jQuery('input[name="coOptionPantsWashableInfo.wpDStitch"]:checked').val();

	// 0002202(有り)
	if (dStitchValue == "0002202") {
		jQuery('#wp_dStitch_yes_area').show();
	} else {
		jQuery('#wp_dStitch_yes_area').hide();
	}

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#wp_pantsModel').val();

	if (!opStitchModifyList[pantsModel]) {
		// Pantsモデルが定義にない場合はすべて変更不可
		jQuery('input[id^="wp_dStitchPlace_"]').each(function() {
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
		tmpStitchModify = jQuery('#wp_dStitchPlace_'+tmpStitchModifyPlace);

		// 有効無効設定
		// 0002202(有り)
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
function ctrlWpDStitchPlace() {

	// 選択中のPantsモデルを取得
	var pantsModel = jQuery('#wp_pantsModel').val();
	if (pantsModel == '選択') {
		// 未選択時は何もしない
		return;
	}

	// 選択中のステッチ箇所変更
	var dStitchValue = jQuery('input[name="coOptionPantsWashableInfo.wpDStitch"]:checked').val();

	var tmpStitchModifyPlace = null;
	var tmpStitchModify = null;
	var stichModifyChecked = false;

	for (tmpStitchModifyPlace in opStitchModifyList[pantsModel]) {
		// 定義取得
		stitchModifyDef = opStitchModifyList[pantsModel][tmpStitchModifyPlace];
		// ダブルステッチ要素取得
		tmpStitchModify = jQuery('#wp_dStitchPlace_'+tmpStitchModifyPlace);
		// ステッチ箇所変更要素取得
		stichModifyChecked = jQuery('#wp_stitchModifyPlace_'+tmpStitchModifyPlace).prop("checked");

		// 有効無効設定
		// 0002202(有り)
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
function ctrlWpAmfColor() {
	// 選択中のステッチ箇所変更
	var amfColorValue = jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor"]:checked').val();

	// 0002402(有り)
	if (amfColorValue == "0002402") {
		jQuery('#wp_amfColor_div').show();
	} else {
		jQuery('#wp_amfColor_div').hide();
	}

	// AMF色指定の有効/無効設定
	jQuery('input[id^="wp_amfColorPlace_"]').each(function() {
		// 0002402(有り)
		if (amfColorValue == "0002402") {
			// 有りの場合はステッチ箇所変更に基づく
			var id = this.id;
			id = id.replace("wp_amfColorPlace_", "wp_stitchModifyPlace_id");
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
jQuery('#wp_coinPkt').change(function() {

	var selectedValue = jQuery('#wp_coinPkt').val();

		jQuery('#wp_flapCoinPkt_id2').prop('disabled', false);
		
	// 0001201(無し)
	if (selectedValue == "0001201") {
		jQuery('#wp_flapCoinPkt_id1').prop('checked', true);
		jQuery('#wp_flapCoinPkt_id2').prop('disabled', true);
	}
	
	
});
jQuery('#wp_coinPkt').change();

// アジャスター仕様変更時
jQuery('input[name="coOptionPantsWashableInfo.wpAdjuster"]').change(function(index, elem) {
	var selected = jQuery('input[name="coOptionPantsWashableInfo.wpAdjuster"]:checked').val();

	var oBLoopElemY = jQuery('#wp_beltLoop_id1');
	var oBLoopElemN = jQuery('#wp_beltLoop_id2');

	var oPLoopElemY = jQuery('#wp_pinLoop_id1');
	var oPLoopElemN = jQuery('#wp_pinLoop_id2');
	
	switch(selected) {
		case "0000601"                : oBLoopElemY.prop("checked", true); break;// 0000601(無し)
		case "0000602": oBLoopElemN.prop("checked", true); break;// 0000602(サイドアジャスター大)
		case "0000603": oBLoopElemN.prop("checked", true); break;// 0000603(サイドアジャスター小)
		case "0000604"        : oBLoopElemY.prop("checked", true); break;// 0000604(アジャスター)
		default:oBLoopElemN.prop("checked", true);
	}
	switch(selected) {
		case "0000601"                : oPLoopElemY.prop("checked", true); break;// 0000601(無し)
		case "0000602": oPLoopElemN.prop("checked", true); break;// 0000602(サイドアジャスター大)
		case "0000603": oPLoopElemN.prop("checked", true); break;// 0000603(サイドアジャスター小)
		case "0000604"        : oPLoopElemY.prop("checked", true); break;// 0000604(アジャスター)
		default:oPLoopElemN.prop("checked", true);
	}

	wpChangedBeltLoop();

});
jQuery('#wp_adjuster_id1').change();

function modelCheck(modelCode,productFabricNo,orderPattern,itemCode,subItemCode){
	var checkResult = jQuery.ajax({url:contextPath + "/orderCo/checkModel",data:{"modelCode":modelCode,"productFabricNo":productFabricNo,"orderPattern":orderPattern,"itemCode":itemCode,"subItemCode":subItemCode},async:false});
	checkResult = checkResult.responseText;
	return checkResult;
}