/*********************************************
 * ウォッシャブルJACKET用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionJacketWashable() {

	// Jacketモデル
	jQuery('#wj_jacketModel').change(function(){
		// 選択されたJacketモデルを取得
		var jacketModel = jQuery(this).val();

		if (isEmpty(jacketModel)) {
			// 未選択時は何もしない
			return;
		}
		
		var productFabricNo = jQuery("#productFabricNo").val();
		var itemCode = "";
		var item = jQuery("#item").val();
		var subItemCode = "02"
		if(item == "01"){
			itemCode = "01"
		}else if(item == "02"){
			itemCode = "02"
		}
		
		//生地チェクフラッグ
		var fabricCheckValue = jQuery("#fabricFlag").val();
		//fabricCheckValue[0]:0 or 1 or 2 
		//fabricCheckValue[1]:エラーメッセージ 
		fabricCheckValue = fabricCheckValue.split("*");
		
		//生地チェク成功の場合
		if((fabricCheckValue[0]=="0"||fabricCheckValue[0]=="2")&&isNotEmpty(productFabricNo)){
			//モデルチェク
			var checkResult = modelCheck(jacketModel,productFabricNo,orderPattern,itemCode,subItemCode);
			if(checkResult == "true"){
				//0はモデルチェク成功の場合
				jQuery("#jkModelFlag").val("0");
				jQuery("#wj_jacketModelCheck").empty();
				jQuery("#fabricMsg").empty();
			}else if(checkResult == "false"){
				//2はモデルチェク失敗の場合
				jQuery("#jkModelFlag").val("1"+"*"+getMsgByOneArg('msg065','JACKET'));
				setAlert('wj_jacketModelCheck',getMsgByOneArg('msg065','JACKET'));
			}
		}

		// 選択中のフロント釦数
		var frontBtnCntElem = jQuery('#wj_frontBtnCnt');
		var selectedFrontBtnCnt = frontBtnCntElem.val();

		// フロント釦数の選択肢更新
		frontBtnCntElem.empty();
		var tmpFrontBtnCnt = null;
		for (tmpFrontBtnCnt of lapelDesignImageMap[jacketModel].activeList) {
			frontBtnCntElem.append(jQuery('<option />').val(tmpFrontBtnCnt.val).text(tmpFrontBtnCnt.text));
		}
		// デフォルトを選択
		frontBtnCntElem.val(lapelDesignImageMap[jacketModel].defaultValue);

		// フロント釦数変更時の制御実施
		jQuery('#wj_frontBtnCnt').change();

		// 袖釦のデフォルト制御
		jQuery('input[name="optionJacketWashableInfo.wjSleeveBtnType"]').val([sleeveBtnTypeList[jacketModel]]);
		jQuery('input[name="optionJacketWashableInfo.wjSleeveBtnType"]').change();

		// ベントのデフォルト制御
		jQuery('input[name="optionJacketWashableInfo.wjVentSpec"]').val([ventSpecList[jacketModel]]);

		// 袖仕様のデフォルト制御
		if (jacketModel == 'TR02') {
			jQuery('#wj_sleeveSpec_id2').prop('disabled', false);
		} else {
			jQuery('#wj_sleeveSpec_id1').prop('checked', true);  // 通常にチェック
			jQuery('#wj_sleeveSpec_id2').prop('disabled', true);
		}

		// 別モデルに変更された場合はアラート表示
		if (tmpWjJacketModel != '' && jacketModel != tmpWjJacketModel) {
		    setAlert('wj_jacketModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		}
		// 一時保存のモデルを更新
		tmpWjJacketModel = jacketModel;

		// ステッチ箇所変更の制御
		ctrlWjStitchModify();
		// ダブルステッチ変更箇所の制御
		ctrlWjDStitchModify();
		ctrlWjDStitchPlace();
		// AMF色指定の有効/無効を制御する
		ctrlWjAmfColor();

		// 補正の制御（標準・タキシード・ウォッシャブルで同じ構文※後勝ち）
		jQuery('#oj_shoulderPat_no').prop('disabled', false);
		jQuery('#oj_shoulderPat_thin').prop('disabled', true);
		jQuery('#oj_shoulderPat_thick').prop('disabled', true);
		jQuery('#oj_figureAlter_1').prop('disabled', true);
		jQuery('#oj_figureAlter_2').prop('disabled', true);
		if (jacketModel == 'TR02') {
			jQuery('#oj_shoulderPat_thin').prop('disabled', false);
			jQuery('#oj_shoulderPat_thick').prop('disabled', false);
			jQuery('#oj_figureAlter_1').prop('disabled', false);
			jQuery('#oj_figureAlter_2').prop('disabled', false);
		}
	});

	// フロント釦数変更時の制御
	jQuery('#wj_frontBtnCnt').change(function(){
		// 選択中のJacketモデルを取得
		var jacketModel = jQuery('#wj_jacketModel').val();
		if (isEmpty(jacketModel)) {
			// 未選択の場合は何もしない
			return;
		}

		// 選択中のフロント釦数
		var frontBtnCnt = jQuery('#wj_frontBtnCnt').val();

		// 選択中のラペルデザイン
		var selectedLapelDesign = jQuery('input[name="optionJacketWashableInfo.wjLapelDesign"]:checked').val();

		// ラペルデザインの選択肢制御
		jQuery('input[id^="wj_lapelDesign_"]').each(function() {
			var tmpLapelDesignElem = jQuery(this);
			var value = tmpLapelDesignElem.val();

			if (lapelDesignMap[jacketModel].activeList[frontBtnCnt].activeList.indexOf(value) != -1) {
				// 有効なラペルデザインの場合、有効化
				tmpLapelDesignElem.prop("disabled", false);
			} else {
				// 有効なラペルデザインではない場合、無効化
				tmpLapelDesignElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name="optionJacketWashableInfo.wjLapelDesign"]').val([lapelDesignMap[jacketModel].activeList[frontBtnCnt].defaultValue]);

		// ラペルデザイン変更時の制御
		changeWjLapelDesign();

		// 胸ポケットの項目制御
		//ダブル６つボタン:0000105
		if (frontBtnCnt == "0000105") {
			// 「ダブル6B」選択時、「パッチ」不可
			jQuery('#wj_breastPkt_id2').prop("disabled", true);
			if (jQuery('#wj_breastPkt_id2').prop("checked")) {
				// 「パッチ」が選択されている場合は「バルカ」へ変更
				jQuery('#wj_breastPkt_id1').prop("checked", true);
			}
		} else {
			jQuery('#wj_breastPkt_id2').prop("disabled", false);
		}

		// ボタンホール色指定箇所の制御
		ctrlWjBhColorPlace();
		// ボタン付け糸指定箇所の制御
		ctrlWjByColorPlace();
	});

	// ラペルデザイン変更時の制御
	jQuery('input[id^="wj_lapelDesign_"]').each(function() {
		jQuery(this).change(changeWjLapelDesign);
	});

	// 裏仕様選択時の台場制御
	jQuery('#wj_backSpec').change(function(){
		/*// 選択中グレードの値取得
		var gradeValue = jQuery('input[name="optionJacketWashableInfo.wjGrade"]:checked').val();
		if (!gradeValue || !fortList[gradeValue]) {
			// 未選択or想定外は終了
			return;
		}

		// 裏仕様（プルダウン）
		// 選択中裏仕様の値取得
		var backSpecValue = jQuery('#wj_backSpec').val();
		if (!backSpecValue || !fortList[gradeValue].activeList[backSpecValue]) {
			// 未選択or想定外は終了
			return;
		}

		// 台場の要素取得
		var fortElem = jQuery('#wj_fort');
		var beforeValue = fortElem.val();

		// 台場の選択肢変更
		fortElem.empty();
		var tmpFortValue = null;
		for (var i = 0; i < fortList[gradeValue].activeList[backSpecValue].activeList.length; i++) {
			fortElem.append(jQuery('<option />').val(fortList[gradeValue].activeList[backSpecValue].activeList[i].val).text(fortList[gradeValue].activeList[backSpecValue].activeList[i].text));
		}

		// デフォルトを選択
		fortElem.val(fortList[gradeValue].activeList[backSpecValue].defaultValue);*/
	});

	// フラワーホール
	jQuery('#wj_flowerHole').change(function(){
		// ボタンホール色指定箇所の有効/無効を制御
		ctrlWjBhColorPlace();
	});

	// 腰ポケット
	jQuery('#wj_waistPkt').change(function(){
		// 選択中の腰ポケット
		var waistPkt = jQuery('#wj_waistPkt').val();
		if (!slantedPktList[waistPkt]) {
			// 想定外の値の場合は何もしない
			return;
		}

		// チェンジポケットの有効無効を制御
		jQuery('input[id^="wj_changePkt_"]').each(function(index, elem) {
			var tmpElem = jQuery(elem);
			if (tmpElem.val() in slantedPktList[waistPkt].activeList) {
				// 有効な場合
				tmpElem.prop("disabled", false);
			} else {
				// 無効な場合
				tmpElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name="optionJacketWashableInfo.wjChangePkt"]').val([slantedPktList[waistPkt].defaultValue]);

		// チェンジポケット変更時の制御
		changeWjChangePkt();

		// ダブルステッチ変更箇所の有効/無効
		ctrlWjDStitchModify();
	});

	// チェンジポケット変更時
	jQuery('input[name="optionJacketWashableInfo.wjChangePkt"]').each(function() {
		jQuery(this).click(changeWjChangePkt);
	});

	// AMFステッチ
	jQuery('input[name="optionJacketWashableInfo.wjStitch"]').each(function() {
		jQuery(this).click(changeWjStitch);
	});
	changeWjStitch();

	// ステッチ箇所変更
	jQuery('input[name="optionJacketWashableInfo.wjStitchModify"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のステッチ箇所変更
			ctrlWjStitchModify();
		});
	});
	ctrlWjStitchModify();

	// ステッチ箇所
	jQuery('input[name="optionJacketWashableInfo.wjStitchModifyPlace"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のダブルステッチ変更
			ctrlWjDStitchPlace();
			ctrlWjAmfColor();
		});
	});

	// AMF色指定(有り/無し)
	jQuery('input[name="optionJacketWashableInfo.wjAmfColor"]').each(function() {
		jQuery(this).change(function(){
			ctrlWjAmfColor();
		});
	});
	ctrlWjAmfColor();

	// AMF色指定(全選択)
	jQuery('#btn_as_wj_amfColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#wj_amfColorPlaceAll').val();

		jQuery('#wj_amfColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// AMF色指定箇所 
	jQuery('input[name="optionJacketWashableInfo.wjAmfColorPlace"]').each(function() {
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

	// 袖釦
	jQuery('input[name="optionJacketWashableInfo.wjSleeveBtnType"]').each(function() {
		jQuery(this).change(function(){
			var sleeveBtnType = jQuery('input[name="optionJacketWashableInfo.wjSleeveBtnType"]:checked').val();
			var sleeveBtnCnt = jQuery('#wj_sleeveBtnCnt').val() - 0;

			// 袖釦数をデフォルトに変更
			jQuery('#wj_sleeveBtnCnt').val(4);

			// ボタンホール色指定箇所の制御
			ctrlWjBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlWjByColorPlace();
		});
	});
	// 袖釦数
	jQuery('#wj_sleeveBtnCnt_m').click(function(){
		var sleeveBtnType = jQuery('input[name="optionJacketWashableInfo.wjSleeveBtnType"]:checked').val();
		//無し:0001803
		if (sleeveBtnType == "0001803") return false;

		var value = jQuery('#wj_sleeveBtnCnt').val() - 0;
		if (value <= 1) return false;
		jQuery('#wj_sleeveBtnCnt').val(value - 1);

		// ボタンホール色指定箇所の制御
		ctrlWjBhColorPlace();
		// ボタン付け糸指定箇所の制御
		ctrlWjByColorPlace();
		return false;
	});
	jQuery('#wj_sleeveBtnCnt_p').click(function(){
		var sleeveBtnType = jQuery('input[name="optionJacketWashableInfo.wjSleeveBtnType"]:checked').val();
		//無し:0001803,並び:0001802
		if (sleeveBtnType == "0001803") return false;

		var value = jQuery('#wj_sleeveBtnCnt').val() - 0;
		var max = (sleeveBtnType == "0001802") ? 4 : 5;
		if (value >= max) return false;
		jQuery('#wj_sleeveBtnCnt').val(value + 1);

		// ボタンホール色指定箇所の制御
		ctrlWjBhColorPlace();
		// ボタン付け糸指定箇所の制御
		ctrlWjByColorPlace();
		return false;
	});

	// 内ポケット変更
	jQuery('input[name="optionJacketWashableInfo.wjInsidePktChange"]').each(function() {
		jQuery(this).change(function(){
			/* // 選択中の内ポケット変更
			var insidePktChange = jQuery('input[name="optionJacketWashableInfo.wjInsidePktChange"]:checked').val();
			
			if (insidePktChange == "有り") {
				// 有りの場合、下位項目を有効化
				jQuery('input[name="wj_insidePktPlace"]').prop("disabled", false);
				jQuery('#btn_as_wj_insidePktPlace').prop("disabled", false);
				jQuery('#btn_ar_wj_insidePktPlace').prop("disabled", false);
				jQuery('#wj_insidePktChange_yes_area').show();
			} else {
				// 無しの場合、下位項目を無効化
				jQuery('input[name="wj_insidePktPlace"]').prop("disabled", true);
				jQuery('#btn_as_wj_insidePktPlace').prop("disabled", true);
				jQuery('#btn_ar_wj_insidePktPlace').prop("disabled", true);
				jQuery('#wj_insidePktChange_yes_area').hide();
			}*/
		});
	});
	//jQuery('#wj_insidePktChange_no').change();

	// ダブルステッチ変更
	jQuery('input[name="optionJacketWashableInfo.wjDStitchModify"]').each(function() {
		jQuery(this).change(function(){
			ctrlWjDStitchModify();
			ctrlWjDStitchPlace();
		});
	});
	ctrlWjDStitchModify();
	ctrlWjDStitchPlace();
	
	// ボタンホール色指定(有り/無し)
	jQuery('input[name="optionJacketWashableInfo.wjBhColor"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var bhColor = jQuery('input[name="optionJacketWashableInfo.wjBhColor"]:checked').val();
			//無し:0003101
			if (bhColor == '0003101') {
				// 無しの場合は操作不可
				jQuery('input[id^="wj_bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#wj_bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_wj_bhColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#wj_bhColor_div').hide();
			} else {
				// 有りの場合は操作可能
				ctrlWjBhColorPlace();
				jQuery('input[id^="wj_bhColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#wj_bhColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_wj_bhColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#wj_bhColor_div').show();
			}
		});
	});
	jQuery('#wj_bhColor_id1').change();

	// ボタンホール色指定(全選択)
	jQuery('#btn_as_wj_bhColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#wj_bhColorPlaceAll').val();

		jQuery('#wj_bhColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタンホール色指定箇所
	jQuery('input[name="optionJacketWashableInfo.wjBhColorPlace"]').each(function() {
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
	ctrlWjBhColorPlace();

	// ボタン付け糸指定(有り/無し)
	jQuery('input[name="optionJacketWashableInfo.wjByColor"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var byColor = jQuery('input[name="optionJacketWashableInfo.wjByColor"]:checked').val();
			//無し:0003401
			if (byColor == '0003401') {
				// 無しの場合は操作不可
				jQuery('input[id^="wj_byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#wj_byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_wj_byColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#wj_byColor_div').hide();
			} else {
				// 有りの場合は操作可能
				ctrlWjByColorPlace();
				jQuery('input[id^="wj_byColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#wj_byColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_wj_byColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#wj_byColor_div').show();
			}
		});
	});
	jQuery('#wj_byColor_id1').change();

	// ボタン付け糸指定(全選択)
	jQuery('#btn_as_wj_byColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#wj_byColorPlaceAll').val();

		jQuery('#wj_byColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタン付け糸指定箇所
	jQuery('input[name="optionJacketWashableInfo.wjByColor"]').each(function() {
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
	ctrlWjByColorPlace();

	/*// 胴裏素材
	jQuery('#wj_bodyBackMate').change(function (){
		var bodyBackMate = jQuery('#wj_bodyBackMate').val();

		// 胴裏品番
		var bodyBackMateStkNoElem = jQuery('#wj_bodyBackMateStkNo');

		// 選択肢をクリア
		bodyBackMateStkNoElem.empty();

		if (bodyBackMateStkNoList[bodyBackMate]) {
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < bodyBackMateStkNoList[bodyBackMate].length; i++) {
				bodyBackMateStkNoElem.append(jQuery('<option />').val(bodyBackMateStkNoList[bodyBackMate][i]).text(bodyBackMateStkNoList[bodyBackMate][i]));
			}
		}
	});
	jQuery('#wj_bodyBackMate').change();*/

	/*// 袖裏素材
	jQuery('#wj_cuffBackMate').change(function (){
		var cuffBackMate = jQuery('#wj_cuffBackMate').val();

		// 袖裏品番
		var cuffBackMateStkNoElem = jQuery('#wj_cuffBackMateStkNo');

		// 選択肢をクリア
		cuffBackMateStkNoElem.empty();

		if (cuffBackMateStkNoList[cuffBackMate]) {
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < cuffBackMateStkNoList[cuffBackMate].length; i++) {
				cuffBackMateStkNoElem.append(jQuery('<option />').val(cuffBackMateStkNoList[cuffBackMate][i]).text(cuffBackMateStkNoList[cuffBackMate][i]));
			}
			jQuery('#wj_cuffBackMateStkNo').prop("disabled", false);
		} else {
			jQuery('#wj_cuffBackMateStkNo').prop("disabled", true);
		}
	});
	jQuery('#wj_cuffBackMate').change();*/

	/*// 釦素材
	jQuery('#wj_btnMate').change(function (){
		var btnMate = jQuery('#wj_btnMate').val();

		// 釦品番
		var btnMateStkNoElem = jQuery('#wj_btnMateStkNo');

		// 選択肢をクリア
		btnMateStkNoElem.empty();

		// 定義が存在する場合は品番を選択肢にセット
		for (var i = 0; i < btnMateStkNoList[btnMate].length; i++) {
			btnMateStkNoElem.append(jQuery('<option />').val(btnMateStkNoList[btnMate][i]).text(btnMateStkNoList[btnMate][i]));
		}

		var sItem = jQuery('#item').val();
		var elemPants1    = jQuery('#wp_button');
		var elemPants2    = jQuery('#wp2_button');
		var elemPants1Stk = jQuery('#wp_btnMateStkNo');
		var elemPants2Stk = jQuery('#wp2_btnMateStkNo');
		if (sItem == "SUIT") {
			// スーツの場合はパンツの釦素材を合わせて変更
			elemPants1.val([btnMate]);
			elemPants1.change();
			elemPants1Stk.change();
			elemPants2.val([btnMate]);
			elemPants2.change();
			elemPants2Stk.change();
		}
	});
	jQuery('#wj_btnMate').change();*/
	
	/*// 釦素材
	jQuery('#wj_btnMateStkNo').change(function() {

		var sItem = jQuery('#item').val();
		var sMateStkNo = jQuery('#wj_btnMateStkNo').val();
		var elemPants1Stk = jQuery('#wp_btnMateStkNo');
		var elemPants2Stk = jQuery('#wp2_btnMateStkNo');

		// 釦品番
		if (sItem == "SUIT") {
			elemPants1Stk.val([sMateStkNo]);
			elemPants2Stk.val([sMateStkNo]);
		}
	});
	jQuery('#wj_btnMateStkNo').change();*/


}

//--------------------------------------------
// 部品
//--------------------------------------------
//ラペルデザイン変更時
function changeWjLapelDesign() {
	// ステッチ箇所変更の制御
	ctrlWjStitchModify();

	var lapelDesign = jQuery('input[name="optionJacketWashableInfo.wjLapelDesign"]:checked').val();

	// 襟裏（ヒゲ）の制御
	//ショール:0000203
	if (lapelDesign == "0000203") {
		// 「ショール」選択時、「無」のみ
		jQuery('#wj_backCollar_id2').prop("disabled", true);
		jQuery('#wj_backCollar_id2').prop("checked", true);
	} else {
		jQuery('#wj_backCollar_id2').prop("disabled", false);
	}

	// ラペル幅の制御
	//ショール:0000203
	if (lapelDesign == "0000203") {
		// 「ショール」選択時、「通常」のみ
		jQuery('#wj_lapelWidth_id2').prop("disabled", true);
		jQuery('#wj_lapelWidth_id3').prop("disabled", true);
		// 「通常」以外が選択されている場合、「通常」へ変更
		jQuery('#wj_lapelWidth_id1').prop("checked", true);
	} else {
		jQuery('#wj_lapelWidth_id2').prop("disabled", false);
		jQuery('#wj_lapelWidth_id3').prop("disabled", false);
	}
}

//AMFステッチ変更時
function changeWjStitch() {
	// 選択中のAMFステッチ
	var stitchValue = jQuery('input[name="optionJacketWashableInfo.wjStitch"]:checked').val();
	//ミシンステッチ:0002304,AMFステッチ:0002301
	if (stitchValue == "0002304" || stitchValue == "0002301") {
		// 有りの場合、関連する項目を有効化
		// ステッチ箇所変更
		jQuery('input[name="optionJacketWashableInfo.wjStitchModify"]').prop("disabled", false);

		// ダブルステッチ変更
		if (stitchValue == "0002301") {
		    jQuery('input[name="optionJacketWashableInfo.wjDStitchModify"]').prop("disabled", false);
		} else {
			jQuery('input[name="optionJacketWashableInfo.wjDStitchModify"]').prop("disabled", true);
		}

		// AMF色指定
		jQuery('input[name="optionJacketWashableInfo.wjAmfColor"]').prop("disabled", false);
	} else {
		// 無しの場合、関連する項目を無効化・値変更
		// ステッチ箇所変更
		jQuery('input[name="optionJacketWashableInfo.wjStitchModify"]').prop("disabled", true);
		jQuery('#wj_stitchModify_id1').prop("checked", true);
		jQuery('#wj_stitchModify_id1').change();

		// ダブルステッチ変更
		jQuery('input[name="optionJacketWashableInfo.wjDStitchModify"]').prop("disabled", true);
		jQuery('#wj_dStitch_id1').prop("checked", true);
		jQuery('#wj_dStitch_id1').change();

		// AMF色指定
		jQuery('input[name="optionJacketWashableInfo.wjAmfColor"]').prop("disabled", true);
		jQuery('#wj_amfColor_id1').prop("checked", true);
		jQuery('#wj_amfColor_id1').change();
	}
}

//ステッチ箇所変更の有効/無効を制御する
function ctrlWjStitchModify() {
	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="optionJacketWashableInfo.wjStitchModify"]:checked').val();

	// 下位項目の表示制御
	//無し:0002401
	if (stitchModifyValue != "0002401") {
		jQuery('#wj_stitchModifyPlace').show();
	} else {
		jQuery('#wj_stitchModifyPlace').hide();
	}

	// 選択中のJacketモデルを取得
	var jacketModel = jQuery('#wj_jacketModel').val();

	// 選択中のラペルデザインを取得
	var selectedLapelDesign = jQuery('input[name="optionJacketWashableInfo.wjLapelDesign"]:checked').val();

	if (!stitchModifyList[jacketModel] || !stitchModifyList[jacketModel][selectedLapelDesign]) {
		// Jacketモデルとラペルデザインの組み合わせが定義にない場合はすべて変更不可
		jQuery('input[id^="wj_stitchModifyPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		});
		return;
	}

	var tmpStitchModifyPlace = null;
	var stitchModifyDef = null;
	var tmpStitchModify = null;
	for (tmpStitchModifyPlace in stitchModifyList[jacketModel][selectedLapelDesign]) {
		// 定義取得
		stitchModifyDef = stitchModifyList[jacketModel][selectedLapelDesign][tmpStitchModifyPlace];
		// 要素取得
		tmpStitchModify = jQuery('#wj_stitchModifyPlace_'+tmpStitchModifyPlace);

		// 有効無効設定
		if (stitchModifyValue == '0002402') {
			// 有りの場合、定義に基づいて設定変更
			//tmpStitchModify.prop("disabled", stitchModifyDef.disabled);
			tmpStitchModify.prop("disabled", false);
		} else {
			// 無しの場合、無効にする
			tmpStitchModify.prop("disabled", true);
		}
		// チェック状態の設定
		tmpStitchModify.prop("checked", stitchModifyDef.default);
	}

	// 全選択・全解除ボタン
	if (stitchModifyValue == '0002402') {
		jQuery('#btn_as_wj_stitchModifyPlace').prop("disabled", false);
		jQuery('#btn_ar_wj_stitchModifyPlace').prop("disabled", false);
	} else {
		jQuery('#btn_as_wj_stitchModifyPlace').prop("disabled", true);
		jQuery('#btn_ar_wj_stitchModifyPlace').prop("disabled", true);
	}
}

//ダブルステッチ変更箇所の有効/無効を制御する
function ctrlWjDStitchModify() {
	// 選択中のステッチ箇所変更
	var dStitchValue = jQuery('input[name="optionJacketWashableInfo.wjDStitchModify"]:checked').val();

	// 選択中の胸ポケットを取得
	var breastPktValue = jQuery('input[name="optionJacketWashableInfo.wjBreastPkt"]:checked').val();

	// 選択中の腰ポケットを取得
	var waistPktValue = jQuery('#wj_waistPkt').val();
	
	//有り:0002602
	if (dStitchValue == "0002602") {
		jQuery('#wj_dStitchPlace').show();
	} else {
		jQuery('#wj_dStitchPlace').hide();
	}

	// 選択中のJacketモデルを取得
	var jacketModel = jQuery('#wj_jacketModel').val();

	// 選択中のラペルデザインを取得
	var selectedLapelDesign = jQuery('input[name="optionJacketWashableInfo.wjLapelDesign"]:checked').val();

	if (!stitchModifyList[jacketModel] || !stitchModifyList[jacketModel][selectedLapelDesign]) {
		// Jacketモデルとラペルデザインの組み合わせが定義にない場合はすべて変更不可
		jQuery('input[id^="wj_dStitchPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		});
		return;
	}

	var tmpStitchModifyPlace = null;
	var stitchModifyDef = null;
	var tmpStitchModify = null;
	for (tmpStitchModifyPlace in stitchModifyList[jacketModel][selectedLapelDesign]) {
		// 定義取得
		stitchModifyDef = stitchModifyList[jacketModel][selectedLapelDesign][tmpStitchModifyPlace];
		// 要素取得
		tmpStitchModify = jQuery('#wj_dStitchPlace_'+tmpStitchModifyPlace);

		// 有効無効設定
		//有り:0002602
		if (dStitchValue == '0002602') {
			// 有りの場合、定義に基づいて設定変更
			tmpStitchModify.prop("disabled", stitchModifyDef.disabled);
		} else {
			// 無しの場合、無効にする
			tmpStitchModify.prop("disabled", true);
		}
		// チェック状態の設定
		tmpStitchModify.prop("checked", stitchModifyDef.default);
	}

	// ダブルステッチ変更箇所の有効/無効設定
	jQuery('input[id^="wj_dStitchPlace_"]').each(function() {
		if(jQuery(this).prop("disabled")){
			// 無効選択肢は何もしない
			//胸ポケット:0002702,パッチ:0001102
		} else if (jQuery(this).val() == "0002702" && breastPktValue == "0001102") {
			// 胸ポケットが「パッチ」選択時、胸ポケットは選択不可
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
			//腰ポケット0002703:,パッチ:0001203,パッチ＆フラップ:0001204
		} else if (jQuery(this).val() == "0002703" && (waistPktValue == "0001203" || waistPktValue == "0001204")) {
			// 腰ポケットが「パッチ、パッチ＆フラップ」選択時、腰ポケットは選択不可
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		} else {
			jQuery(this).prop("checked", true);
		}
	});

	// ダブルステッチ変更箇所の有効/無効設定
	/*
	jQuery('input[id^="wj_dStitchPlace_"]').each(function() {
		if (dStitchModifyValue == "有り") {
			// 有りの場合はステッチ箇所変更に基づく
			var id = this.id;
			id = id.replace("wj_dStitchPlace", "wj_stitchModifyPlace");
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
	});
	*/
}

//ダブルステッチ変更(選択肢)の有効/無効を制御する
function ctrlWjDStitchPlace() {

	// 選択中のJacketモデルを取得
	var jacketModel = jQuery('#wj_jacketModel').val();
	if (isEmpty(jacketModel)) {
		// 未選択時は何もしない
		return;
	}

	// 選択中のステッチ箇所変更
	var dStitchValue = jQuery('input[name="optionJacketWashableInfo.wjDStitchModify"]:checked').val();

	// 選択中のラペルデザインを取得
	var selectedLapelDesign = jQuery('input[name="optionJacketWashableInfo.wjLapelDesign"]:checked').val();

	var tmpStitchModifyPlace = null;
	var tmpStitchModify = null;
	var stichModifyChecked = false;

	for (tmpStitchModifyPlace in stitchModifyList[jacketModel][selectedLapelDesign]) {
		// 定義取得
		stitchModifyDef = stitchModifyList[jacketModel][selectedLapelDesign][tmpStitchModifyPlace];
		// ダブルステッチ要素取得
		tmpStitchModify = jQuery('#wj_dStitchPlace_'+tmpStitchModifyPlace);
		// ステッチ箇所変更要素取得
		stichModifyChecked = jQuery('#wj_stitchModifyPlace_'+tmpStitchModifyPlace).prop("checked");

		// 有効無効設定
		//有り:0002602
		if (dStitchValue == '0002602' && stichModifyChecked) {
			// 有り且つステッチ箇所変更の同項目が有効の場合、ダブルステッチも有効にする
			tmpStitchModify.prop("disabled", false);
		} else {
			// 上記以外の場合、無効にする
			tmpStitchModify.prop("disabled", true);
			tmpStitchModify.prop("checked", false);
		}
	}
}

//AMF色指定の有効/無効を制御する
function ctrlWjAmfColor() {
	// 選択中のステッチ箇所変更
	var amfColorValue = jQuery('input[name="optionJacketWashableInfo.wjAmfColor"]:checked').val();
	//有り:0002801
	if (amfColorValue == "0002802") {
		jQuery('#wj_amfColor_div').show();
	} else {
		jQuery('#wj_amfColor_div').hide();
	}

	// AMF色指定の有効/無効設定
	jQuery('input[id^="wj_amfColorPlace_"]').each(function() {
		if (amfColorValue == "0002801") {
			// 有りの場合はステッチ箇所変更に基づく
			var id = this.id;
			id = id.replace("wj_amfColorPlace", "wj_stitchModifyPlace");
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

//チェンジポケット変更時
function changeWjChangePkt() {
	// 選択中の腰ポケット
	var waistPkt = jQuery('#wj_waistPkt').val();
	if (!slantedPktList[waistPkt]) {
		// 想定外の値の場合は何もしない
		return;
	}

	// 選択中のチェンジポケット
	var changePkt = jQuery('input[name="optionJacketWashableInfo.wjChangePkt"]:checked').val();
	if (!slantedPktList[waistPkt].activeList[changePkt]) {
		// 想定外の値の場合は何もしない
		return;
	}

	// スランテッドポケットの有効無効を制御
	jQuery('input[id^="wj_slantedPkt_"]').each(function(index, elem) {
		var tmpElem = jQuery(elem);
		if (slantedPktList[waistPkt].activeList[changePkt].activeList.indexOf(tmpElem.val()) != -1) {
			// 有効な場合
			tmpElem.prop("disabled", false);
		} else {
			// 無効な場合
			tmpElem.prop("disabled", true);
		}
	});
	// デフォルトを選択
	jQuery('input[name="optionJacketWashableInfo.wjSlantedPkt"]').val([slantedPktList[waistPkt].activeList[changePkt].defaultValue]);
}

//ボタンホール色指定箇所の有効/無効を制御する
function ctrlWjBhColorPlace() {

	// 選択中のボタンホール色指定
	var bhColor = jQuery('input[name="optionJacketWashableInfo.wjBhColor"]:checked').val();

	// 選択中のフラワーホール
	var flowerHole = jQuery('#wj_flowerHole').val();

	// 選択中のフロント釦数
	var frontBtnCnt = jQuery('#wj_frontBtnCnt').val();

	// 選択中の袖釦
	var sleeveBtnType = jQuery('input[name="optionJacketWashableInfo.wjSleeveBtnType"]:checked').val();
	var sleeveBtnCnt = jQuery('#wj_sleeveBtnCnt').val() - 0;

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#wj_bhColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);
		//有り:0003102
		if (bhColor == "0003102") {
			// 有りの場合は一旦有効化し、項目ごとに無効判定
			elem.prop("disabled", false);
			//フラワーホール(上前1):0003201
			if (elem.val() == "0003201") {
				// フラワーホールの指定に関わらず、常に有効
				//フラワーホール(上前2):0003202
			} else if (elem.val() == "0003202") {
				//上前2つ:0001003,両前2つ:0001004
				if (!(flowerHole == "0001003" || flowerHole == "0001004")) {
					elem.prop("disabled", true);
				}
				//フラワーホール(下前1):0003203
			} else if (elem.val() == "0003203") {
				//両前:0001002,両前2つ:0001004
				if (!(flowerHole == "0001002" || flowerHole == "0001004")) {
					elem.prop("disabled", true);
				}
				//フラワーホール(下前2):0003204
			} else if (elem.val() == "0003204") {
				//,両前2つ:0001004
				if (!(flowerHole == "0001004")) {
					elem.prop("disabled", true);
				}
				//フロント１:0003205
			} else if (elem.val() == "0003205") {
				// フロント釦数の指定に関わらず、常に有効
				//段返り3つボタン:0000101
				if (frontBtnCnt != "0000101") {
					elem.prop("disabled", true);
				}
				//フロント２:0003206
			} else if (elem.val() == "0003206") {
//				if (frontBtnCnt == "1つボタン") {
//					elem.prop("disabled", true);
//				}
				//フロント３:0003207
			} else if (elem.val() == "0003207") {
//				if (frontBtnCnt != "段返り3つボタン") {
				//1つボタン:0000103
				if (frontBtnCnt == "0000103") {
					elem.prop("disabled", true);
				}
				//上前袖口１:0003208,下前袖口１:0003213
			} else if (elem.val() == "0003208" || elem.val() == "0003213") {
				//無し:0001803
				if (sleeveBtnType == "0001803") {
					elem.prop("disabled", true);
				}
				//上前袖口２:0003209,下前袖口２:0003214
			} else if (elem.val() == "0003209" || elem.val() == "0003214") {
				//無し:0001803
				if (sleeveBtnType == "0001803" || sleeveBtnCnt < 2) {
					elem.prop("disabled", true);
				}
				//上前袖口３:0003210,下前袖口３:0003215
			} else if (elem.val() == "0003210" || elem.val() == "0003215") {
				//無し:0001803
				if (sleeveBtnType == "0001803" || sleeveBtnCnt < 3) {
					elem.prop("disabled", true);
				}
				//上前袖口４:0003211,下前袖口４:0003216
			} else if (elem.val() == "0003211" || elem.val() == "0003216") {
				//無し:0001803
				if (sleeveBtnType == "0001803" || sleeveBtnCnt < 4) {
					elem.prop("disabled", true);
				}
				//上前袖口５:0003212,下前袖口５:0003217
			} else if (elem.val() == "0003212" || elem.val() == "0003217") {
				//無し:0001803
				if (sleeveBtnType == "0001803" || sleeveBtnCnt < 5) {
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
function ctrlWjByColorPlace() {

	// 選択中のボタン付け糸指定
	var byColor = jQuery('input[name="optionJacketWashableInfo.wjByColor"]:checked').val();

	// 選択中のフロント釦数
	var frontBtnCnt = jQuery('#wj_frontBtnCnt').val();

	// 選択中の袖釦
	var sleeveBtnType = jQuery('input[name="optionJacketWashableInfo.wjSleeveBtnType"]:checked').val();
	var sleeveBtnCnt = jQuery('#wj_sleeveBtnCnt').val() - 0;

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#wj_byColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);
		//有り:0003402
		if (byColor == "0003402") {
			// 有りの場合は一旦有効化し、項目ごとに無効判定
			elem.prop("disabled", false);
			//フロント下前1:0003504
			if (elem.val() == "0003504") {
//				if (frontBtnCnt == "ダブル４つボタン") {
				//段返り3つボタン:0000101
				if (frontBtnCnt != "0000101") {
					elem.prop("disabled", true);
				}
				//フロント下前2:0003505
			} else if (elem.val() == "0003505") {
//				if (frontBtnCnt == "1つボタン") {
//					elem.prop("disabled", true);
//				}
				//フロント下前3:0003506
			} else if (elem.val() == "0003506") {
//				if (frontBtnCnt == "1つボタン" || frontBtnCnt == "2つボタン") {
				//1つボタン:0000103
				if (frontBtnCnt == "0000103") {
					elem.prop("disabled", true);
				}
				//フロント上前1:0003501
			} else if (elem.val() == "0003501") {
//				if (frontBtnCnt != "ダブル６つボタン") {
					elem.prop("disabled", true);
//				}
				//フロント上前2:0003502
			} else if (elem.val() == "0003502") {
				//ダブル４つボタン:0000106,ダブル６つボタン:0000105
				if (!(frontBtnCnt == "0000106" || frontBtnCnt == "0000105")) {
					elem.prop("disabled", true);
				}
				//フロント上前3:0003503
			} else if (elem.val() == "0003503") {
				//ダブル４つボタン:0000106,ダブル６つボタン:0000105
				if (!(frontBtnCnt == "0000106" || frontBtnCnt == "0000105")) {
					elem.prop("disabled", true);
				}
				//上前袖口1:0003507,下前袖口1:0003512
			} else if (elem.val() == "0003507" || elem.val() == "0003512") {
				//無し:0001803
				if (sleeveBtnType == "0001803") {
					elem.prop("disabled", true);
				}
				//上前袖口2:0003508,下前袖口2:0003513
			} else if (elem.val() == "0003508" || elem.val() == "0003513") {
				//無し:0001803
				if (sleeveBtnType == "0001803" || sleeveBtnCnt < 2) {
					elem.prop("disabled", true);
				}
				//上前袖口3:0003509,下前袖口3:0003514
			} else if (elem.val() == "0003509" || elem.val() == "0003514") {
				//無し:0001803
				if (sleeveBtnType == "0001803" || sleeveBtnCnt < 3) {
					elem.prop("disabled", true);
				}
				//上前袖口4:0003510,下前袖口4:0003515
			} else if (elem.val() == "0003510" || elem.val() == "0003515") {
				//無し:0001803
				if (sleeveBtnType == "0001803" || sleeveBtnCnt < 4) {
					elem.prop("disabled", true);
				}
				//上前袖口5:0003511,下前袖口5:0003516
			} else if (elem.val() == "0003511" || elem.val() == "0003516") {
				//無し:0001803
				if (sleeveBtnType == "0001803" || sleeveBtnCnt < 5) {
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

function modelCheck(modelCode,productFabricNo,orderPattern,itemCode,subItemCode){
	var checkResult = jQuery.ajax({url:contextPath + "/orderCo/checkModel",data:{"modelCode":modelCode,"productFabricNo":productFabricNo,"orderPattern":orderPattern,"itemCode":itemCode,"subItemCode":subItemCode},async:false});
	checkResult = checkResult.responseText;
	return checkResult;
}