/*********************************************
 * タキシードJACKET用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionJacketTuxedo() {

	// Jacketモデル
	jQuery('#tj_jacketModel').change(function(){
		// 選択されたJacketモデルを取得
		var jacketModel = jQuery(this).val();

		if (jacketModel == '') {
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
				jQuery("#tj_jacketModelCheck").empty();
				jQuery("#fabricMsg").empty();
			}else if(checkResult == "false"){
				//2はモデルチェク失敗の場合
				jQuery("#jkModelFlag").val("1"+"*"+getMsgByOneArg('msg065','JACKET'));
				setAlert('tj_jacketModelCheck',getMsgByOneArg('msg065','JACKET'));
			}
		}

		// 選択中のフロント釦数
		var frontBtnCntElem = jQuery('#tj_frontBtnCnt');
		var selectedFrontBtnCnt = frontBtnCntElem.val();

		// フロント釦数の選択肢更新
		frontBtnCntElem.empty();
		var tmpFrontBtnCnt = null;
		for (tmpFrontBtnCnt of lapelDesignTuxedoImageMap[jacketModel].activeList) {
			frontBtnCntElem.append(jQuery('<option />').val(tmpFrontBtnCnt.val).text(tmpFrontBtnCnt.text));
			/*//1つボタン:0000103
			if (tmpFrontBtnCnt == "0000103") {
				// 拝み1つボタンを追加する
				frontBtnCntElem.append(jQuery('<option />').val(tmpFrontBtnCnt).text("拝み1つボタン"));
			}*/
		}
		
		// デフォルトを選択
		frontBtnCntElem.val(lapelDesignTuxedoImageMap[jacketModel].defaultValue);

		// フロント釦数変更時の制御実施
		jQuery('#tj_frontBtnCnt').change();

		// 袖釦のデフォルト制御
		jQuery('input[name="optionJacketTuxedoInfo.tjSleeveBtnType"]').val([sleeveBtnTypeList[jacketModel]]);
		jQuery('input[name="optionJacketTuxedoInfo.tjSleeveBtnType"]').change();

		// ベントのデフォルト制御
		jQuery('input[name="optionJacketTuxedoInfo.tjVentSpec"]').val([ventSpecList[jacketModel]]);

		// 袖仕様のデフォルト制御
		if (jacketModel == 'TR02') {
			jQuery('#tj_sleeveSpec_id2').prop('disabled', false);
		} else {
			jQuery('#tj_sleeveSpec_id1').prop('checked', true);  // 通常にチェック
			jQuery('#tj_sleeveSpec_id2').prop('disabled', true);
		}
		// 別モデルに変更された場合はアラート表示
		if (tmpTjJacketModel != '' && jacketModel != tmpTjJacketModel) {
		    setAlert('tj_jacketModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
		}
		// 一時保存のモデルを更新
		tmpTjJacketModel = jacketModel;

		// ステッチ箇所変更の制御
		//ctrlTjStitchModify();
		// ダブルステッチ変更箇所の制御
		//ctrlTjDStitchModify();
		//ctrlTjDStitchModifyPlace();

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
	jQuery('#tj_frontBtnCnt').change(function(){
		// 選択中のJacketモデルを取得
		var jacketModel = jQuery('#tj_jacketModel').val();
		if (jacketModel == '') {
			// 未選択の場合は何もしない
			return;
		}

		// 選択中のフロント釦数
		var frontBtnCnt = jQuery('#tj_frontBtnCnt').val();

		// 選択中のラペルデザイン
		var selectedLapelDesign = jQuery('input[name="optionJacketTuxedoInfo.tjLapelDesign"]:checked').val();

		// ラペルデザインの選択肢制御
		jQuery('input[id^="tj_lapelDesign_"]').each(function() {
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
		jQuery('input[name="optionJacketTuxedoInfo.tjLapelDesign"]').val([lapelDesignMap[jacketModel].activeList[frontBtnCnt].defaultValue]);

		// ラペルデザイン変更時の制御
		changeTjLapelDesign();

		// 胸ポケットの項目制御
		//ダブル６つボタン:0000105
		if (frontBtnCnt == "0000105") {
			// 「ダブル6B」選択時、「パッチ」不可
			jQuery('#tj_breastPkt_id2').prop("disabled", true);
			if (jQuery('#tj_breastPkt_id2').prop("checked")) {
				// 「パッチ」が選択されている場合は「バルカ」へ変更
				jQuery('#tj_breastPkt_id1').prop("checked", true);
			}
		} else {
			jQuery('#tj_breastPkt_id2').prop("disabled", false);
		}

		// ボタンホール色指定箇所の制御
		ctrlTjBhColorPlace();
		// ボタン付け糸指定箇所の制御
		ctrlTjByColorPlace();
	});

	// ラペルデザイン変更時の制御
	jQuery('input[id^="tj_lapelDesign_"]').each(function() {
		jQuery(this).change(changeTjLapelDesign);
	});

	// グレード選択時の裏仕様制御
	jQuery('input[id^="tj_grade_"]').each(function() {
		jQuery(this).change(function(){

			/*// 選択中グレードの値取得
			var gradeValue = jQuery('input[name="optionJacketTuxedoInfo.tjGrade"]:checked').val();
			if (!gradeValue || !fortList[gradeValue]) {
				// 未選択or想定外は終了
				return;
			}

			// 裏仕様の要素取得
			var backSpecElem = jQuery('#tj_backSpec');
			var beforeValue = backSpecElem.val();

			// 裏仕様の選択肢変更
			backSpecElem.empty();
			var tmpBackSpeckValue = null;
			for (tmpBackSpeckValue in fortList[gradeValue].activeList) {
				backSpecElem.append(jQuery('<option />').val(tmpBackSpeckValue).text(tmpBackSpeckValue));
			}

			// デフォルトを選択
			backSpecElem.val(fortList[gradeValue].defaultValue);

			// 裏仕様選択時の台場制御のコール
			jQuery('#tj_backSpec').change();*/
		});
	});

	// 裏仕様選択時の台場制御
	jQuery('#tj_backSpec').change(function(){
		/*// 選択中グレードの値取得
		var gradeValue = jQuery('input[name="tj_grade"]:checked').val();
		if (!gradeValue || !fortList[gradeValue]) {
			// 未選択or想定外は終了
			return;
		}

		// 裏仕様（プルダウン）
		// 選択中裏仕様の値取得
		var backSpecValue = jQuery('#tj_backSpec').val();
		if (!backSpecValue || !fortList[gradeValue].activeList[backSpecValue]) {
			// 未選択or想定外は終了
			return;
		}*/

		// 台場の要素取得
		/* タキシードはルール２の考慮は不要
		var fortElem = jQuery('#tj_fort');
		var beforeValue = fortElem.val();

		// 台場の選択肢変更
		fortElem.empty();
		var tmpFortValue = null;
		for (var i = 0; i < fortList[gradeValue].activeList[backSpecValue].activeList.length; i++) {
			fortElem.append(jQuery('<option />').val(fortList[gradeValue].activeList[backSpecValue].activeList[i]).text(fortList[gradeValue].activeList[backSpecValue].activeList[i]));
		}

		// 裏仕様の選択状態変更
		if (fortList[gradeValue].activeList[backSpecValue].activeList.indexOf(beforeValue) != -1) {
			// 元々選択されていた選択肢が変更後も存在する場合は選択する
			fortElem.val(beforeValue);
		} else {
			// 元々選択されていた選択肢がない場合はデフォルト
			fortElem.val(fortList[gradeValue].activeList[backSpecValue].defaultValue);
			appendAlert('tj_fortMsg', "デフォルトに変更しました。");
		}
		*/
	});

	// フラワーホール
	jQuery('#tj_flowerHole').change(function(){
		// ボタンホール色指定箇所の有効/無効を制御
		ctrlTjBhColorPlace();
	});

	// 胸ポケット
	jQuery('input[id^="tj_breastPkt_"]').each(function() {
		jQuery(this).click(function(){
			// ダブルステッチ変更箇所の有効/無効
			//ctrlTjDStitchModify();
		});
	});

	// 腰ポケット
	jQuery('#tj_waistPkt').change(function(){
		
		
		// 選択中の腰ポケット
		var waistPkt = jQuery('#tj_waistPkt').val();
		
		/*// デフォルト値の設定
		var sChangePktId = "tj_changePkt_no";
		switch (waistPkt) {
			case 'フラップなし（両玉縁　表地）'   :
				sChangePktId = "tj_changePkt_yesPipingOuterFablic";
				break;
			case 'フラップ（表地）'               :
				sChangePktId = "tj_changePkt_yesFlapOuterFablic";
				break;
			case 'フラップ（拝見地）'             :
				sChangePktId = "tj_changePkt_yesFlapGlossFablic";
				break;
			case 'フラップなし（両玉縁　拝見地）' :
				sChangePktId = "tj_changePkt_yesPipingGlossFablic";
				break;
			default : sChangePktId = "tj_changePkt_no"
		}
		// デフォルト値セット
		jQuery("#" + sChangePktId).prop('checked', true);*/
		
		//リストが意味のないものなので以下削除
		if (!slantedPktTuexdoList[waistPkt]) {
			// 想定外の値の場合は何もしない
			return;
		}

		// チェンジポケットの有効無効を制御
		jQuery('input[id^="tj_changePkt_"]').each(function(index, elem) {
			var tmpElem = jQuery(elem);
			if (tmpElem.val() in slantedPktTuexdoList[waistPkt].activeList) {
				// 有効な場合
				tmpElem.prop("disabled", false);
			} else {
				// 無効な場合
				tmpElem.prop("disabled", true);
			}
		});
		// デフォルトを選択
		jQuery('input[name="optionJacketTuxedoInfo.tjChangePkt"]').val([slantedPktTuexdoList[waistPkt].defaultValue]);

		// チェンジポケット変更時の制御
		changeTjChangePkt();

		// ダブルステッチ変更箇所の有効/無効
		ctrlTjDStitchModify();

	});

	// チェンジポケット変更時
	jQuery('input[id^="tj_changePkt_"]').each(function() {
		jQuery(this).click(changeTjChangePkt);
	});

	// AMFステッチ
	jQuery('input[id^="tj_stitch_"]').each(function() {
		//jQuery(this).click(changeTjStitch);
	});
	changeTjStitch();

	// ステッチ箇所変更
	jQuery('input[id^="tj_stitchModify_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のステッチ箇所変更
			//ctrlTjStitchModify();
		});
	});
	//ctrlTjStitchModify();

	// ステッチ箇所変更(選択肢)
	jQuery('input[id^="tj_stitchModifyPlace_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のダブルステッチ変更
			//ctrlTjDStitchModifyPlace();
		});
	});

	// AMF色指定(有り/無し)
	jQuery('input[id^="tj_amfColor_"]').each(function() {
		jQuery(this).change(function(){
			/*// 選択中のAMF色指定を取得
			var amfColor = jQuery('input[name="tj_amfColor"]:checked').val();

			if (amfColor == '無し') {
				// 無しの場合は操作不可
				jQuery('input[id^="tj_amfColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#tj_amfColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_tj_amfColorPlace').prop("disabled", true);

				// 無しの場合は2階層目以降を非表示
				jQuery('#tj_amfColor_div').hide();
			} else {
				// 有りの場合は操作可能
				jQuery('input[id^="tj_amfColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#tj_amfColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_tj_amfColorPlace').prop("disabled", false);

				// 有りの場合は2階層目以降を表示
				jQuery('#tj_amfColor_div').show();
			}*/
		});
	});

	// AMF色指定(全選択)
	jQuery('#btn_as_tj_amfColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#tj_amfColorPlaceAll').val();

		jQuery('#tj_amfColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// AMF色指定箇所
	jQuery('input[id^="tj_amfColorPlace_"]').each(function() {
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
	jQuery('input[id^="tj_sleeveBtnType"]').each(function() {
		jQuery(this).change(function(){
			var sleeveBtnType = jQuery('input[name="optionJacketTuxedoInfo.tjSleeveBtnType"]:checked').val();
			var sleeveBtnCnt = jQuery('#tj_sleeveBtnCnt').val() - 0;

			// 袖釦数をデフォルトに変更
			jQuery('#tj_sleeveBtnCnt').val(4);

			// ボタンホール色指定箇所の制御
			ctrlTjBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlTjByColorPlace();
		});
	});
	// 袖釦数
	jQuery('#tj_sleeveBtnCnt_m').click(function(){
		var sleeveBtnType = jQuery('input[name="optionJacketTuxedoInfo.tjSleeveBtnType"]:checked').val();
		//if (sleeveBtnType == "無し") return false;

		var value = jQuery('#tj_sleeveBtnCnt').val() - 0;
		if (value <= 1) return false;
		jQuery('#tj_sleeveBtnCnt').val(value - 1);

		// ボタンホール色指定箇所の制御
		ctrlTjBhColorPlace();
		// ボタン付け糸指定箇所の制御
		ctrlTjByColorPlace();
		return false;
	});
	jQuery('#tj_sleeveBtnCnt_p').click(function(){
		var sleeveBtnType = jQuery('input[name="optionJacketTuxedoInfo.tjSleeveBtnType"]:checked').val();
		//if (sleeveBtnType == "無し") return false;

		var value = jQuery('#tj_sleeveBtnCnt').val() - 0;
		var max = (sleeveBtnType == "並び") ? 4 : 5;
		if (value >= max) return false;
		jQuery('#tj_sleeveBtnCnt').val(value + 1);

		// ボタンホール色指定箇所の制御
		ctrlTjBhColorPlace();
		// ボタン付け糸指定箇所の制御
		ctrlTjByColorPlace();
		return false;
	});

	// 内ポケット変更
	jQuery('input[name="optionJacketTuxedoInfo.tjInsidePktChange"]').each(function() {
		jQuery(this).change(function(){
			/*// 選択中の内ポケット変更
			var insidePktChange = jQuery('input[name="optionJacketTuxedoInfo.tjInsidePktChange"]:checked').val();
			//有り:0002002
			if (insidePktChange == "0002002") {
				// 有りの場合、下位項目を有効化
				jQuery('input[name="tj_insidePktPlace"]').prop("disabled", false);
				jQuery('#btn_as_tj_insidePktPlace').prop("disabled", false);
				jQuery('#btn_ar_tj_insidePktPlace').prop("disabled", false);
				jQuery('#tj_insidePktChange_yes_area').show();
			} else {
				// 無しの場合、下位項目を無効化
				jQuery('input[name="tj_insidePktPlace"]').prop("disabled", true);
				jQuery('#btn_as_tj_insidePktPlace').prop("disabled", true);
				jQuery('#btn_ar_tj_insidePktPlace').prop("disabled", true);
				jQuery('#tj_insidePktChange_yes_area').hide();
			}*/
		});
	});
	//jQuery('#tj_insidePktChange_no').change();

	// ダブルステッチ変更
	/*jQuery('input[name="tj_dStitchModify"]').each(function() {
		jQuery(this).change(function(){
			//ctrlTjDStitchModify();
			//ctrlTjDStitchModifyPlace();
		});
	});*/
	//ctrlTjDStitchModify();
	//ctrlTjDStitchModifyPlace();

	// ボタンホール色指定(有り/無し)
	jQuery('input[name="optionJacketTuxedoInfo.tjBhColor"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var bhColor = jQuery('input[name="optionJacketTuxedoInfo.tjBhColor"]:checked').val();
			//無し:0003101
			if (bhColor == '0003101') {
				// 無しの場合は操作不可
				jQuery('input[id^="tj_bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#tj_bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_tj_bhColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#tj_bhColor_div').hide();
			} else {
				// 有りの場合は操作可能
				ctrlTjBhColorPlace();
				jQuery('input[id^="tj_bhColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#tj_bhColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_tj_bhColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#tj_bhColor_div').show();
			}
		});
	});
	jQuery('#tj_bhColor_id1').change();

	// ボタンホール色指定(全選択)
	jQuery('#btn_as_tj_bhColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#tj_bhColorPlaceAll').val();

		jQuery('#tj_bhColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタンホール色指定箇所
	jQuery('input[id^="tj_bhColorPlace_"]').each(function() {
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
	ctrlTjBhColorPlace();

	// ボタン付け糸指定(有り/無し)
	jQuery('input[name="optionJacketTuxedoInfo.tjByColor"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var byColor = jQuery('input[name="optionJacketTuxedoInfo.tjByColor"]:checked').val();
			//無し:0003401
			if (byColor == '0003401') {
				// 無しの場合は操作不可
				jQuery('input[id^="tj_byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#tj_byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_tj_byColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#tj_byColor_div').hide();
			} else {
				// 有りの場合は操作可能
				ctrlTjByColorPlace();
				jQuery('input[id^="tj_byColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#tj_byColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_tj_byColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#tj_byColor_div').show();
			}
		});
	});
	jQuery('#tj_byColor_id1').change();

	// ボタン付け糸指定(全選択)
	jQuery('#btn_as_tj_byColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#tj_byColorPlaceAll').val();

		jQuery('#tj_byColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == allColor) elem.prop('checked', true);
		});
	});

	// ボタン付け糸指定箇所
	jQuery('input[id^="tj_byColorPlace_"]').each(function() {
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
	ctrlTjByColorPlace();

	// 胴裏素材
	jQuery('#tj_bodyBackMate').change(function (){
		var bodyBackMate = jQuery('#tj_bodyBackMate').val();

		// 胴裏品番
		var bodyBackMateStkNoElem = jQuery('#tj_bodyBackMateStkNo');

		// 選択肢をクリア
		bodyBackMateStkNoElem.empty();

		if (bodyBackMateStkNoList[bodyBackMate]) {
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < bodyBackMateStkNoList[bodyBackMate].length; i++) {
				bodyBackMateStkNoElem.append(jQuery('<option />').val(bodyBackMateStkNoList[bodyBackMate][i]).text(bodyBackMateStkNoList[bodyBackMate][i]));
			}
		}
	});
	jQuery('#tj_bodyBackMate').change();

	// 袖裏素材
	jQuery('#tj_cuffBackMate').change(function (){
		var cuffBackMate = jQuery('#tj_cuffBackMate').val();

		// 袖裏品番
		var cuffBackMateStkNoElem = jQuery('#tj_cuffBackMateStkNo');

		// 選択肢をクリア
		cuffBackMateStkNoElem.empty();

		if (cuffBackMateStkNoList[cuffBackMate]) {
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < cuffBackMateStkNoList[cuffBackMate].length; i++) {
				cuffBackMateStkNoElem.append(jQuery('<option />').val(cuffBackMateStkNoList[cuffBackMate][i]).text(cuffBackMateStkNoList[cuffBackMate][i]));
			}
			jQuery('#tj_cuffBackMateStkNo').prop("disabled", false);
		} else {
			jQuery('#tj_cuffBackMateStkNo').prop("disabled", true);
		}
	});
	jQuery('#tj_cuffBackMate').change();

	// 釦素材
	jQuery('#tj_btnMate').change(function (){
		var btnMate = jQuery('#tj_btnMate').val();

		// 釦品番
		var btnMateStkNoElem = jQuery('#tj_btnMateStkNo');

		// 選択肢をクリア
		btnMateStkNoElem.empty();

		// 釦素材が包みの場合は品番の選択肢を非表示
		if (btnMate == '包み') {
			jQuery('#tj_btnMateStkNo').hide();
			jQuery('#tj_btnMateStkNo').prop('disabled', true);
		} else if (btnMateStkNoList[btnMate]) {
			jQuery('#tj_btnMateStkNo').show();
			jQuery('#tj_btnMateStkNo').prop('disabled', false);
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < btnMateStkNoList[btnMate].length; i++) {
				btnMateStkNoElem.append(jQuery('<option />').val(btnMateStkNoList[btnMate][i]).text(btnMateStkNoList[btnMate][i]));
			}
		}
		
		var sItem = jQuery('#item').val();
		var elemPants1    = jQuery('#tp_button');
		var elemPants2    = jQuery('#tp2_button');
		var elemPants1Stk = jQuery('#tp_btnMateStkNo');
		var elemPants2Stk = jQuery('#tp2_btnMateStkNo');
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
	jQuery('#tj_btnMate').change();

	// 釦素材
	jQuery('#tj_btnMateStkNo').change(function() {

		var sItem = jQuery('#item').val();
		var sMateStkNo = jQuery('#tj_btnMateStkNo').val();
		var elemPants1Stk = jQuery('#tp_btnMateStkNo');
		var elemPants2Stk = jQuery('#tp2_btnMateStkNo');

		// 釦品番
		if (sItem == "SUIT") {
			elemPants1Stk.val([sMateStkNo]);
			elemPants2Stk.val([sMateStkNo]);
		}
	});
	jQuery('#tj_btnMateStkNo').change();

}

//--------------------------------------------
// 部品
//--------------------------------------------
//ラペルデザイン変更時
function changeTjLapelDesign() {
	// ステッチ箇所変更の制御
	//ctrlTjStitchModify();

	var lapelDesign = jQuery('input[name="optionJacketTuxedoInfo.tjLapelDesign"]:checked').val();

	// 襟裏（ヒゲ）の制御
	//shawl:0000203
	if (lapelDesign == "0000203") {
		// 「ショール」選択時、「無」のみ
		jQuery('#tj_backCollar_id2').prop("disabled", true);
			// 「有り」が選択されていた場合、「無し」へ変更
		jQuery('#tj_backCollar_id2').prop("checked", true);
	} else {
		jQuery('#tj_backCollar_id2').prop("disabled", false);
	}

	// ラペル幅の制御
	//shawl:0000203
	if (lapelDesign == "0000203") {
		// 「ショール」選択時、「通常」のみ
		jQuery('#tj_lapelWidth_id2').prop("disabled", true);
		jQuery('#tj_lapelWidth_id3').prop("disabled", true);
		// 「通常」以外が選択されている場合、「通常」へ変更
		jQuery('#tj_lapelWidth_id1').prop("checked", true);
	} else {
		jQuery('#tj_lapelWidth_id2').prop("disabled", false);
		jQuery('#tj_lapelWidth_id3').prop("disabled", false);
	}
	
	// フラワーホールの設定
	//shawl:0000203
	if (lapelDesign == "0000203") {
		//無し:0001005
		jQuery('#tj_flowerHole').val("0001005");
		jQuery('#tj_flowerHole').prop("disabled", true);
	} else {
		jQuery('#tj_flowerHole').prop("disabled", false);
	}
}

//AMFステッチ変更時
function changeTjStitch() {
	/*// 選択中のAMFステッチ
	var stitchValue = jQuery('input[name="tj_stitch"]:checked').val();

	if (stitchValue == "有り") {
		// 有りの場合、関連する項目を有効化
		// ステッチ箇所変更
		jQuery('input[name="tj_stitchModify"]').prop("disabled", false);

		// ダブルステッチ変更
		jQuery('input[name="tj_dStitchModify"]').prop("disabled", false);

		// AMF色指定
		jQuery('input[name="tj_amfColor"]').prop("disabled", false);
	} else {
		// 無しの場合、関連する項目を無効化・値変更
		// ステッチ箇所変更
		jQuery('input[name="tj_stitchModify"]').prop("disabled", true);
		jQuery('#tj_stitchModify_no').prop("checked", true);
		jQuery('#tj_stitchModify_no').change();

		// ダブルステッチ変更
		jQuery('input[name="tj_dStitchModify"]').prop("disabled", true);
		jQuery('#tj_dStitchModify_no').prop("checked", true);
		jQuery('#tj_dStitchModify_no').change();

		// AMF色指定
		jQuery('input[name="tj_amfColor"]').prop("disabled", true);
		jQuery('#tj_amfColor_no').prop("checked", true);
		jQuery('#tj_amfColor_no').change();
	}*/
}

//ステッチ箇所変更の有効/無効を制御する
function ctrlTjStitchModify() {
	/*// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="tj_stitchModify"]:checked').val();

	// 選択中のJacketモデルを取得
	var jacketModel = jQuery('#tj_jacketModel').val();

	// 選択中のラペルデザインを取得
	var selectedLapelDesign = jQuery('input[name=tj_lapelDesign]:checked').val();

	if (!stitchModifyList[jacketModel] || !stitchModifyList[jacketModel][selectedLapelDesign]) {
		// Jacketモデルとラペルデザインの組み合わせが定義にない場合はすべて変更不可
		jQuery('input[id^="tj_stitchModifyPlace_"]').each(function() {
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
		tmpStitchModify = jQuery('#tj_stitchModifyPlace_'+tmpStitchModifyPlace);

		// 有効無効設定
		if (stitchModifyValue == '有り') {
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
	if (stitchModifyValue == '有り') {
		jQuery('#btn_as_tj_stitchModifyPlace').prop("disabled", false);
		jQuery('#btn_ar_tj_stitchModifyPlace').prop("disabled", false);
	} else {
		jQuery('#btn_as_tj_stitchModifyPlace').prop("disabled", true);
		jQuery('#btn_ar_tj_stitchModifyPlace').prop("disabled", true);
	}*/
}

//ダブルステッチ変更箇所の有効/無効を制御する
function ctrlTjDStitchModify() {
	/*// 選択中のステッチ箇所変更
	var dStitchModifyValue = jQuery('input[name="tj_dStitchModify"]:checked').val();

	// 選択中の胸ポケットを取得
	var breastPktValue = jQuery('input[name="tj_breastPkt"]:checked').val();

	// 選択中の腰ポケットを取得
	var waistPktValue = jQuery('#tj_waistPkt').val();

	// ダブルステッチ変更箇所の有効/無効設定
	jQuery('input[id^="tj_dStitchModifyPlace_"]').each(function() {
		if (dStitchModifyValue == "有り") {
			// 有りの場合は変更可能
			jQuery(this).prop("disabled", false);
		} else {
			// 無しの場合は変更不可
			jQuery(this).prop("disabled", true);
		}

		if (jQuery(this).val() == "胸ポケット" && breastPktValue == "パッチ") {
			// 胸ポケットが「パッチ」選択時、胸ポケットは選択不可
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		} else if (jQuery(this).val() == "腰ポケット" && (waistPktValue == "パッチ" || waistPktValue == "パッチ＆フラップ")) {
			// 腰ポケットが「パッチ、パッチ＆フラップ」選択時、腰ポケットは選択不可
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		} else {
			jQuery(this).prop("checked", true);
		}
	});*/
}

//ダブルステッチ変更(選択肢)の有効/無効を制御する
function ctrlTjDStitchModifyPlace() {

	/*// 選択中のJacketモデルを取得
	var jacketModel = jQuery('#tj_jacketModel').val();
	if (jacketModel == '選択') {
		// 未選択時は何もしない
		return;
	}

	// 選択中のステッチ箇所変更
	var dStitchModifyValue = jQuery('input[name="tj_dStitchModify"]:checked').val();

	// 選択中のラペルデザインを取得
	var selectedLapelDesign = jQuery('input[name=tj_lapelDesign]:checked').val();

	var tmpStitchModifyPlace = null;
	var tmpStitchModify = null;
	var stichModifyChecked = false;

	for (tmpStitchModifyPlace in stitchModifyList[jacketModel][selectedLapelDesign]) {
		// 定義取得
		stitchModifyDef = stitchModifyList[jacketModel][selectedLapelDesign][tmpStitchModifyPlace];
		// ダブルステッチ要素取得
		tmpStitchModify = jQuery('#tj_dStitchModifyPlace_'+tmpStitchModifyPlace);
		// ステッチ箇所変更要素取得
		stichModifyChecked = jQuery('#tj_stitchModifyPlace_'+tmpStitchModifyPlace).prop("checked");

		// 有効無効設定
		if (dStitchModifyValue == '有り' && stichModifyChecked) {
			// 有りの場合、定義に基づいて設定変更
			tmpStitchModify.prop("disabled", false);
		} else {
			// 無しの場合、無効にする
			tmpStitchModify.prop("disabled", true);
			tmpStitchModify.prop("checked", false);
		}
	}*/
}

//チェンジポケット変更時
function changeTjChangePkt() {
	// 選択中の腰ポケット
	var waistPkt = jQuery('#tj_waistPkt').val();
	if (!slantedPktTuexdoList[waistPkt]) {
		// 想定外の値の場合は何もしない
		return;
	}

	// 選択中のチェンジポケット
	var changePkt = jQuery('input[name="optionJacketTuxedoInfo.tjChangePkt"]:checked').val();
	if (!slantedPktTuexdoList[waistPkt].activeList[changePkt]) {
		// 想定外の値の場合は何もしない
		return;
	}

	// スランテッドポケットの有効無効を制御
	jQuery('input[id^="tj_slantedPkt_"]').each(function(index, elem) {
		var tmpElem = jQuery(elem);
		if (slantedPktTuexdoList[waistPkt].activeList[changePkt].activeList.indexOf(tmpElem.val()) != -1) {
			// 有効な場合
			tmpElem.prop("disabled", false);
		} else {
			// 無効な場合
			tmpElem.prop("disabled", true);
		}
	});
	// デフォルトを選択
	jQuery('input[name="optionJacketTuxedoInfo.tjSlantedPkt"]').val([slantedPktTuexdoList[waistPkt].activeList[changePkt].defaultValue]);
}

//ボタンホール色指定箇所の有効/無効を制御する
function ctrlTjBhColorPlace() {

	// 選択中のボタンホール色指定
	var bhColor = jQuery('input[name="optionJacketTuxedoInfo.tjBhColor"]:checked').val();

	// 選択中のフラワーホール
	var flowerHole = jQuery('#tj_flowerHole').val();

	// 選択中のフロント釦数
	var frontBtnCnt = jQuery('#tj_frontBtnCnt').val();

	// 選択中の袖釦
	var sleeveBtnType = jQuery('input[name="optionJacketTuxedoInfo.tjSleeveBtnType"]:checked').val();
	var sleeveBtnCnt = jQuery('#tj_sleeveBtnCnt').val() - 0;

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#tj_bhColor_div input[type="checkbox"]').each(function(index, elem){
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
function ctrlTjByColorPlace() {

	// 選択中のボタン付け糸指定
	var byColor = jQuery('input[name="optionJacketTuxedoInfo.tjByColor"]:checked').val();

	// 選択中のフロント釦数
	var frontBtnCnt = jQuery('#tj_frontBtnCnt').val();

	// 選択中の袖釦
	var sleeveBtnType = jQuery('input[name="optionJacketTuxedoInfo.tjSleeveBtnType"]:checked').val();
	var sleeveBtnCnt = jQuery('#tj_sleeveBtnCnt').val() - 0;

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#tj_byColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);
		//有り:0003402
		if (byColor == "0003402") {
			// 有りの場合は一旦有効化し、項目ごとに無効判定
			elem.prop("disabled", false);
			//フロント下前1:0003504
			if (elem.val() == "0003504") {
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