/*********************************************
 * 標準JACKET用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionJacketStandard() {

	//胴裏素材,袖裏素材:無し
	jQuery("#bodyBackMate option[value='1000400']").remove();
	jQuery("#cuffBackMate option[value='2000300']").remove();
	
	jQuery('#jacketModel').attr("oldJkModel",jQuery('#jacketModel').val());
	// Jacketモデル
	jQuery('#jacketModel').change(function(){
		var jacketModel = jQuery(this).val();
		var jacketOldModel = jQuery('#jacketModel').attr("oldJkModel");
		var modelFlag = 0;
		if(jacketOldModel == '' || jacketOldModel == null){
			modelFlag = 1;
		}
		else {
			modelFlag = 2;
		}
		if(jacketModel != jacketOldModel){
			jQuery("#jacketFlag").val("0");
		}else{
			jQuery("#jacketFlag").val("1");
		}
		jQuery('#jacketModel').attr("oldJkModel",jQuery('#jacketModel').val());
		var jacketFlag = jQuery("#jacketFlag").val();
		if(jacketFlag == "0"){
			// 選択されたJacketモデルを取得
			if (jacketModel == '') {
				// 未選択時は何もしない
				return;
			}
			
			var productFabricNo = jQuery("#productFabricNo").val();
			var itemCode = jQuery("#item").val();;
			var subItemCode = "02"
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
					jQuery("#jacketModelCheck").empty();
					jQuery("#jacketModelCheck").hide();
					jQuery("#fabricMsg").empty();
				}else if(checkResult == "false"){
					//2はモデルチェク失敗の場合
					jQuery("#jkModelFlag").val("1"+"*"+getMsgByOneArg('msg065','JACKET'));
					jQuery("#jacketModelCheck").show()
					setAlert('jacketModelCheck',getMsgByOneArg('msg065','JACKET'));
				}
			}

			// 選択中のフロント釦数
			var frontBtnCntElem = jQuery('#oj_frontBtnCnt');
			var selectedFrontBtnCnt = frontBtnCntElem.val();

			// フロント釦数の選択肢更新
			frontBtnCntElem.empty();
			var tmpFrontBtnCnt = null;
			var isExistBefore = false;
			for (tmpFrontBtnCnt of lapelDesignImageMap[jacketModel].activeList) {
				frontBtnCntElem.append(jQuery('<option />').val(tmpFrontBtnCnt.val).text(tmpFrontBtnCnt.text));
				if (tmpFrontBtnCnt == selectedFrontBtnCnt) isExistBefore = true;
			}
			frontBtnCntElem.val(lapelDesignImageMap[jacketModel].defaultValue);

			// フロント釦数変更時の制御実施
			jQuery('#oj_frontBtnCnt').change();

			// 袖釦のデフォルト制御
			jQuery('input[name="coOptionJacketStandardInfo.ojSleeveBtnType"]').val([sleeveBtnTypeList[jacketModel]]);
			jQuery('input[name="coOptionJacketStandardInfo.ojSleeveBtnType"]').change();
			jQuery('#sleeveBtnCnt').val(4);

			// ベントのデフォルト制御
			jQuery('input[name="coOptionJacketStandardInfo.ojVentSpec"]').val([ventSpecList[jacketModel]]);
			
			// 袖仕様のデフォルト制御
			if (jacketModel == 'TR02') {
				jQuery('#sleeveSpec_id2').prop('disabled', false);
			} else {
				jQuery('#sleeveSpec_id1').prop('checked', true);  // 通常にチェック
				jQuery('#sleeveSpec_id2').prop('disabled', true);
			}
			
			// 別モデルに変更された場合はアラート表示
			if ((tmpJacketModel != '' || tmpJacketModel !=null) && jacketModel != tmpJacketModel && modelFlag == 2) {
			    setAlert('jacketModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
			}
			// 一時保存のモデルを更新
			tmpJacketModel = jacketModel;

			// ステッチ箇所変更の制御
			ctrlStitchModify();
			// ダブルステッチ変更箇所の制御
			ctrlDStitchModify();
			ctrlDStitchModifyPlace();
			ctrlAmfColor();
			
			//ステッチ箇所変更
			jQuery("#stitchModify_id1").prop("checked",true);
			jQuery('input[name="coOptionJacketStandardInfo.ojStitchModify"]:checked').change();
			
			//ダブルステッチ変更
			jQuery("#dStitchModify_id1").prop("checked",true);
			jQuery('input[name="coOptionJacketStandardInfo.ojDStitchModify"]:checked').change();
			
			//AMF色指定
			jQuery("#amfColor_id1").prop("checked",true);
			jQuery('input[name="coOptionJacketStandardInfo.ojAmfColor"]:checked').change();
			
			//ボタンホール色指定
			jQuery("#bhColor_id1").prop("checked",true);
			jQuery('input[name="coOptionJacketStandardInfo.ojBhColor"]:checked').change();
			
			//ボタン付け糸指定
			jQuery("#byColor_id1").prop("checked",true);
			jQuery('input[name="coOptionJacketStandardInfo.ojByColor"]:checked').change();
		}
	});
	
	var jacketModel = jQuery('#jacketModel').val();
	
	// 袖仕様のデフォルト制御
	if (jacketModel == 'TR02') {
		jQuery('#sleeveSpec_id2').prop('disabled', false);
	} else {
		jQuery('#sleeveSpec_id1').prop('checked', true);  // 通常にチェック
		jQuery('#sleeveSpec_id2').prop('disabled', true);
	}

	// フロント釦数変更時の制御
	jQuery('#oj_frontBtnCnt').change(function(){
		// 選択中のJacketモデルを取得
		var jacketModel = jQuery('#jacketModel').val();
		if (isEmpty(jacketModel)) {
			// 未選択の場合は何もしない
			return;
		}

		// 選択中のフロント釦数
		var frontBtnCnt = jQuery('#oj_frontBtnCnt').val();

		// 選択中のラペルデザイン
		var selectedLapelDesign = jQuery('input[name="coOptionJacketStandardInfo.ojLapelDesign"]:checked').val();

		// ラペルデザインの選択肢制御
		jQuery('input[id^="lapelDesign_"]').each(function() {
			var tmpLapelDesignElem = jQuery(this);
			var value = tmpLapelDesignElem.val();
			if (lapelDesignMap[jacketModel].activeList[frontBtnCnt].activeList.indexOf(value) != -1) {
				// 有効なラペルデザインの場合、有効化
				tmpLapelDesignElem.prop("disabled", false);
			} else {
				// 有効なラペルデザインではない場合、無効化
				tmpLapelDesignElem.prop("disabled", true);


			}
			// デフォルトを選択
			jQuery('input[name="coOptionJacketStandardInfo.ojLapelDesign"]').val([lapelDesignMap[jacketModel].activeList[frontBtnCnt].defaultValue]);
		});

		// ラペルデザイン変更時の制御
		changeLapelDesign();

		// 胸ポケットの項目制御
		//ダブル６つボタン:0000105
		if (frontBtnCnt == "0000105") {
			// 「ダブル6B」選択時、「パッチ」不可
			jQuery('#breastPkt_id2').prop("disabled", true);
			if (jQuery('#breastPkt_id2').prop("checked")) {
				// 「パッチ」が選択されている場合は「バルカ」へ変更
				jQuery('#breastPkt_id1').prop("checked", true);
			}
		} else {
			jQuery('#breastPkt_id2').prop("disabled", false);
		}

		// ボタンホール色指定箇所の制御
		ctrlBhColorPlace();
		// ボタン付け糸指定箇所の制御
		ctrlByColorPlace();
	});

	// ラペルデザイン変更時の制御
	jQuery('input[id^="lapelDesign_"]').each(function() {
		jQuery(this).change(changeLapelDesign);
	});

	var gradeValue = jQuery('input[name="coOptionJacketStandardInfo.ojGrade"]:checked').val();
	if(gradeValue == "0000301"||gradeValue == "0000303"){
		jQuery("#backSpec option:last-child").prop("disabled",true);
	}
	
	
	// グレード選択時の裏仕様制御
	jQuery('input[id^="grade_"]').each(function() {
		jQuery(this).change(function(){

			// 選択中グレードの値取得
			var gradeValue = jQuery('input[name="coOptionJacketStandardInfo.ojGrade"]:checked').val();
			if (!gradeValue || !fortList[gradeValue]) {
				// 未選択or想定外は終了
				return;
			}

			// 裏仕様の要素取得
			var backSpecElem = jQuery('#backSpec');
			var beforeValue = backSpecElem.val();

			// 裏仕様の選択肢変更
			backSpecElem.empty();
			var tmpBackSpeckValue = null;
			for (tmpBackSpeckValue of fortImageList[gradeValue].activeList) {
				backSpecElem.append(jQuery('<option />').val(tmpBackSpeckValue.val).text(tmpBackSpeckValue.text));
				
			}
			
			if(gradeValue == "0000301"||gradeValue == "0000303"){
				jQuery("#backSpec option:last-child").prop("disabled",true);
			}
			
			// デフォルトを選択
			backSpecElem.val(fortList[gradeValue].defaultValue);

			// 裏仕様選択時の台場制御のコール
			jQuery('#backSpec').change();
		});
	});

	var backSpecValue = jQuery('#backSpec').val();
	if(backSpecValue == '0000404'){
		//袖裏素材
		//jQuery("#cuffBackMate option:last-child").prop("disabled",false);
		jQuery("#cuffBackMate").append(jQuery('<option />').val("2000300").text("無し"));
		jQuery("#cuffBackMate").val("2000300");
		jQuery("#cuffBackMate").change();
		jQuery("#cuffBackMate").prop("disabled",true);
		
		//胴裏素材
		jQuery("#bodyBackMate").append(jQuery('<option />').val("1000400").text("無し"));
		jQuery("#bodyBackMate").val("1000400");
		jQuery("#bodyBackMate").change();
		jQuery("#bodyBackMate").prop("disabled",true);
	}else{
		//袖裏素材
		jQuery("#cuffBackMate").prop("disabled",false);
		var cuffBackMate = jQuery("#cuffBackMate").val();
		if(cuffBackMate == '2000300'){
			jQuery("#cuffBackMate option:first").prop('selected', 'selected');
		}
		//jQuery("#cuffBackMate option:last-child").prop("disabled",true);
		jQuery("#cuffBackMate option[value='2000300']").remove();
		jQuery("#cuffBackMate").change();
		
		//胴裏素材
		jQuery("#bodyBackMate").prop("disabled",false);
		var bodyBackMate = jQuery("#bodyBackMate").val();
		if(bodyBackMate == '1000400'){
			jQuery("#bodyBackMate option:first").prop('selected', 'selected');
		}
		jQuery("#bodyBackMate option[value='1000400']").remove();
		jQuery("#bodyBackMate").change();
	}
	
	// 裏仕様選択時の台場制御
	jQuery('#backSpec').change(function(){
		// 選択中グレードの値取得
		var gradeValue = jQuery('input[name="coOptionJacketStandardInfo.ojGrade"]:checked').val();
		if (!gradeValue || !fortList[gradeValue]) {
			// 未選択or想定外は終了
			return;
		}

		// 裏仕様（プルダウン）
		// 選択中裏仕様の値取得
		var backSpecValue = jQuery('#backSpec').val();
		if (!backSpecValue || !fortList[gradeValue].activeList[backSpecValue]) {
			// 未選択or想定外は終了
			return;
		}

		var backSpecValue = jQuery('#backSpec').val();
		if(backSpecValue == '0000404'){
			//袖裏素材
			//jQuery("#cuffBackMate option:last-child").prop("disabled",false);
			jQuery("#cuffBackMate").append(jQuery('<option />').val("2000300").text("無し"));
			jQuery("#cuffBackMate").val("2000300");
			jQuery("#cuffBackMate").change();
			jQuery("#cuffBackMate").prop("disabled",true);
			
			//胴裏素材
			jQuery("#bodyBackMate").append(jQuery('<option />').val("1000400").text("無し"));
			jQuery("#bodyBackMate").val("1000400");
			jQuery("#bodyBackMate").change();
			jQuery("#bodyBackMate").prop("disabled",true);
		}else{
			//袖裏素材
			jQuery("#cuffBackMate").prop("disabled",false);
			var cuffBackMate = jQuery("#cuffBackMate").val();
			if(cuffBackMate == '2000300'){
				jQuery("#cuffBackMate option:first").prop('selected', 'selected');
			}
			//jQuery("#cuffBackMate option:last-child").prop("disabled",true);
			jQuery("#cuffBackMate option[value='2000300']").remove();
			jQuery("#cuffBackMate").change();
			
			//胴裏素材
			jQuery("#bodyBackMate").prop("disabled",false);
			var bodyBackMate = jQuery("#bodyBackMate").val();
			if(bodyBackMate == '1000400'){
				jQuery("#bodyBackMate option:first").prop('selected', 'selected');
			}
			jQuery("#bodyBackMate option[value='1000400']").remove();
			jQuery("#bodyBackMate").change();
		}
		
		// 台場の要素取得
		var fortElem = jQuery('#fort');
		var beforeValue = fortElem.val();

		// 台場の選択肢変更
		fortElem.empty();
		var tmpFortValue = null;
		for (var i = 0; i < fortList[gradeValue].activeList[backSpecValue].activeList.length; i++) {
			fortElem.append(jQuery('<option />').val(fortList[gradeValue].activeList[backSpecValue].activeList[i].val).text(fortList[gradeValue].activeList[backSpecValue].activeList[i].text));
		}
		
		var fort = jQuery('#fort').val();
		//切台場:0000502
		if (fort == "0000502") {
			// 台場にて「切台場」選択時、内ポケット変更は全て無し
			jQuery('#insidePktChange_id1').prop('checked', true);
			jQuery('#insidePktChange_id1').change();
			jQuery('#insidePktChange_id2').prop('disabled', true);
			//jQuery('input[name="coOptionJacketStandardInfo.ojInsidePktChange"]').prop("disabled", true);
		} else {
			//jQuery('input[name="coOptionJacketStandardInfo.ojInsidePktChange"]').prop("disabled", false);
			jQuery('#insidePktChange_id2').prop('disabled', false);
		}

		// デフォルトを選択
		fortElem.val(fortList[gradeValue].activeList[backSpecValue].defaultValue);
		
		jQuery('#fort').change();
	});

	// 台場
	jQuery('#fort').change(function(){
		var fort = jQuery('#fort').val();
		//切台場:0000502
		if (fort == "0000502") {
			// 台場にて「切台場」選択時、内ポケット変更は全て無し
			jQuery('#insidePktChange_id1').prop('checked', true);
			jQuery('#insidePktChange_id1').change();
			jQuery('#insidePktChange_id2').prop('disabled', true);
			//jQuery('input[name="coOptionJacketStandardInfo.ojInsidePktChange"]').prop("disabled", true);
		} else {
			//jQuery('input[name="coOptionJacketStandardInfo.ojInsidePktChange"]').prop("disabled", false);
			jQuery('#insidePktChange_id2').prop('disabled', false);
		}
	});

	// フラワーホール
	jQuery('#flowerHole').change(function(){
		// ボタンホール色指定箇所の有効/無効を制御
		ctrlBhColorPlace();
	});

	// 胸ポケット
	jQuery('input[id^="breastPkt_"]').each(function() {
		jQuery(this).change(function(){
			// ダブルステッチ変更箇所の有効/無効
			// 選択中のステッチ箇所変更
			var dStitchModifyValue = jQuery('input[name="coOptionJacketStandardInfo.ojDStitchModify"]:checked').val();

			// 選択中の胸ポケットを取得
			var breastPktValue = jQuery('input[name="coOptionJacketStandardInfo.ojBreastPkt"]:checked').val();

			// 選択中の腰ポケットを取得
			var waistPktValue = jQuery('#waistPkt').val();
			
			// ダブルステッチ変更箇所の有効/無効設定
			jQuery('input[id^="dStitchModifyPlace_"]').each(function() {
				var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("dStitch","stitch");
				var twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
				
				//胸ポケット:0002702,パッチ:0001102
				if(jQuery(this).val() == "0002702"){
					// 胸ポケットが「パッチ」選択時、胸ポケットは選択不可
					if(breastPktValue == "0001102"){
						jQuery(this).prop("disabled", true);
						jQuery(this).prop("checked", false);
					}else if(breastPktValue == "0001101" && twoStichModifyPlaceChecked){
						jQuery(this).prop("disabled", false);
					}
				}
			});
		});
	});
	
	ojWaistPktChange();

	// 腰ポケット
	jQuery('#waistPkt').change(function(){
		// 選択中の腰ポケット
		var waistPkt = jQuery('#waistPkt').val();
		if (!slantedPktList[waistPkt]) {
			// 想定外の値の場合は何もしない
			return;
		}

		// チェンジポケットの有効無効を制御
		jQuery('input[id^="changePkt_"]').each(function(index, elem) {
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
		jQuery('input[name="coOptionJacketStandardInfo.ojChangePkt"]').val([slantedPktList[waistPkt].defaultValue]);
		jQuery('input[name="coOptionJacketStandardInfo.ojChangePkt"]:checked').change();
		// チェンジポケット変更時の制御
		changeChangePkt();

		// ダブルステッチ変更箇所の有効/無効
		// 選択中のステッチ箇所変更
		var dStitchModifyValue = jQuery('input[name="coOptionJacketStandardInfo.ojDStitchModify"]:checked').val();

		// 選択中の胸ポケットを取得
		var breastPktValue = jQuery('input[name="coOptionJacketStandardInfo.ojBreastPkt"]:checked').val();

		// 選択中の腰ポケットを取得
		var waistPktValue = jQuery('#waistPkt').val();
		
		// ダブルステッチ変更箇所の有効/無効設定
		jQuery('input[id^="dStitchModifyPlace_"]').each(function() {
			var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("dStitch","stitch");
			var twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
			//腰ポケット0002703:,パッチ:0001203,パッチ＆フラップ:0001204
			if(jQuery(this).val() == "0002703"){
				if(waistPktValue == "0001203" || waistPktValue == "0001204"){
					// 腰ポケットが「パッチ、パッチ＆フラップ」選択時、腰ポケットは選択不可
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);	
				}else{
					if(twoStichModifyPlaceChecked){
						jQuery(this).prop("disabled", false);
					}
				}
			}
		});
	});

	// チェンジポケット変更時
	jQuery('input[name="coOptionJacketStandardInfo.ojChangePkt"]').each(function() {
	//jQuery('input[id^="changePkt_"]').each(function() {
		jQuery(this).change(changeChangePkt);
	});

	// AMFステッチ
	jQuery('input[name="coOptionJacketStandardInfo.ojStitch"]').each(function() {
	//jQuery('input[id^="stitch_"]').each(function() {
		jQuery(this).change(changeStitch);
	});
	changeStitch();

	// ステッチ箇所変更
	jQuery('input[name="coOptionJacketStandardInfo.ojStitchModify"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のステッチ箇所変更
			ctrlStitchModify();
		});
	});
	ctrlStitchModify();

	// ステッチ箇所変更(選択肢)
	jQuery('input[id^="stitchModifyPlace_id"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のダブルステッチ変更
			ctrlDStitchModifyPlace();
			// AMF色指定の有効/無効を制御
			ctrlAmfColor();
		});
	});

	// AMF色指定(有り/無し)
	jQuery('input[name="coOptionJacketStandardInfo.ojAmfColor"]').each(function() {
		jQuery(this).change(function(){
			ctrlAmfColor();
		});
	});
	ctrlAmfColor();

	// AMF色指定(全選択)
	jQuery('#btn_as_amfColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#amfColorPlaceAll').val();

		jQuery('#amfColor_div input[type="checkBox"]').each(function(index, elemCheckBox){
			elemCheckBox = jQuery(elemCheckBox);
			if(!elemCheckBox.prop("disabled")){
				var amfCheckBoxId = elemCheckBox.attr("id");
				jQuery('#'+amfCheckBoxId+'_div input[type="radio"]').each(function(index, elem){
					elem = jQuery(elem);
					if (elem.val() == allColor) elem.prop('checked', true);
				});
			}
		});
	});

	// AMF色指定箇所
	jQuery('input[id^="amfColorPlace_"]').each(function() {
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

	// 袖釦
	jQuery('input[id^="sleeveBtnType"]').each(function() {
		jQuery(this).change(function(){
			var sleeveBtnType = jQuery('input[name="coOptionJacketStandardInfo.ojSleeveBtnType"]:checked').val();
			var sleeveBtnCnt = jQuery('#sleeveBtnCnt').val() - 0;
			//重ね:0001801、 並び:0001802
			if(sleeveBtnType == '0001802'){
				if(sleeveBtnCnt == 5 ||sleeveBtnCnt == '5'){
					// 袖釦数をデフォルトに変更
					jQuery('#sleeveBtnCnt').val(4);
				}
			}
			// 袖釦数をデフォルトに変更
			//jQuery('#sleeveBtnCnt').val(4);

			// ボタンホール色指定箇所の制御
			ctrlBhColorPlace();
			// ボタン付け糸指定箇所の制御
			ctrlByColorPlace();
		});
	});
	// 袖釦数
	jQuery('#sleeveBtnCnt_m').click(function(){
		var sleeveBtnType = jQuery('input[name="coOptionJacketStandardInfo.ojSleeveBtnType"]:checked').val();
		//無し:0001803
		if (sleeveBtnType == "0001803") return false;

		var value = jQuery('#sleeveBtnCnt').val() - 0;
		if (value <= 1) return false;
		jQuery('#sleeveBtnCnt').val(value - 1);

		// ボタンホール色指定箇所の制御
		ctrlBhColorPlace();
		// ボタン付け糸指定箇所の制御
		ctrlByColorPlace();
		return false;
	});
	jQuery('#sleeveBtnCnt_p').click(function(){
		var sleeveBtnType = jQuery('input[name="coOptionJacketStandardInfo.ojSleeveBtnType"]:checked').val();
		//無し:0001803,並び:0001802
		if (sleeveBtnType == "0001803") return false;

		var value = jQuery('#sleeveBtnCnt').val() - 0;
		var max = (sleeveBtnType == "0001802") ? 4 : 5;
		if (value >= max) return false;
		jQuery('#sleeveBtnCnt').val(value + 1);

		// ボタンホール色指定箇所の制御
		ctrlBhColorPlace();
		// ボタン付け糸指定箇所の制御
		ctrlByColorPlace();
		return false;
	});

	// 選択中の内ポケット変更
	var insidePktChange = jQuery('input[name="coOptionJacketStandardInfo.ojInsidePktChange"]:checked').val();
	//有り:0002002,無し:0002001
	if (insidePktChange == "0002002") {
		// 有りの場合、下位項目を有効化
		jQuery('input[name="coOptionJacketStandardInfo.ojInsidePktPlace"]').prop("disabled", false);
		jQuery('#btn_as_insidePktPlace').prop("disabled", false);
		jQuery('#btn_ar_insidePktPlace').prop("disabled", false);
		jQuery('#insidePktChange_yes_area').show();
	} else {
		// 無しの場合、下位項目を無効化
		jQuery('input[name="coOptionJacketStandardInfo.ojInsidePktPlace"]').prop("disabled", true);
		jQuery('#btn_ar_insidePktPlace').click();
		jQuery('#btn_as_insidePktPlace').prop("disabled", true);
		jQuery('#btn_ar_insidePktPlace').prop("disabled", true);
		jQuery('#insidePktChange_yes_area').hide();
	}
	
	// 内ポケット変更
	jQuery('input[name="coOptionJacketStandardInfo.ojInsidePktChange"]').each(function() {
		jQuery(this).change(function(){
			// 選択中の内ポケット変更
			var insidePktChange = jQuery('input[name="coOptionJacketStandardInfo.ojInsidePktChange"]:checked').val();
			//有り:0002002,無し:0002001
			if (insidePktChange == "0002002") {
				// 有りの場合、下位項目を有効化
				jQuery('input[name="coOptionJacketStandardInfo.ojInsidePktPlace"]').prop("disabled", false);
				jQuery('#btn_as_insidePktPlace').click();
				jQuery('#btn_as_insidePktPlace').prop("disabled", false);
				jQuery('#btn_ar_insidePktPlace').prop("disabled", false);
				jQuery('#insidePktChange_yes_area').show();
			} else {
				// 無しの場合、下位項目を無効化
				jQuery('#btn_ar_insidePktPlace').click();
				jQuery('#btn_as_insidePktPlace').prop("disabled", true);
				jQuery('#btn_ar_insidePktPlace').prop("disabled", true);
				jQuery('#insidePktChange_yes_area').hide();
			}
		});
	});
	//jQuery('#insidePktChange_id1').change();

	// ダブルステッチ変更
	jQuery('input[name="coOptionJacketStandardInfo.ojDStitchModify"]').each(function() {
		jQuery(this).change(function(){
			ctrlDStitchModify();
			ctrlDStitchModifyPlace();
		});
	});
	ctrlDStitchModify();
	ctrlDStitchModifyPlace();

	// 選択中のボタンホール色指定を取得
	var bhColor = jQuery('input[name="coOptionJacketStandardInfo.ojBhColor"]:checked').val();

	//無し:0003101
	if (bhColor == '0003101') {
		// 無しの場合は操作不可
		jQuery('input[id^="bhColorPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
			jQuery('#'+this.id+'_div').hide();
		});
		jQuery('#bhColorPlaceAll').prop("disabled", true);
		jQuery('#btn_as_bhColorPlace').prop("disabled", true);

		jQuery('#bhColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.prop("checked")) {
				elem.removeAttr("checked");
			}
		})
		
		jQuery('#bhColor_div input[type="checkbox"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.prop("checked")) {
				elem.removeAttr("checked");
			}
		})
		
		// 無しの場合は2階層目を表示しない
		jQuery('#bhColor_div').hide();
	} else {
		// 有りの場合は操作可能
		ctrlBhColorPlace();
		jQuery('input[id^="bhColorPlace_"]').each(function() {
//			jQuery(this).prop("disabled", false);
			if (jQuery(this).prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+this.id+'_div').show();
			}
		});
		jQuery('#bhColorPlaceAll').prop("disabled", false);
		jQuery('#btn_as_bhColorPlace').prop("disabled", false);

		// 有りの場合は2階層目を表示
		jQuery('#bhColor_div').show();
	}
	
	// ボタンホール色指定(有り/無し)
	jQuery('input[name="coOptionJacketStandardInfo.ojBhColor"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var bhColor = jQuery('input[name="coOptionJacketStandardInfo.ojBhColor"]:checked').val();

			//無し:0003101
			if (bhColor == '0003101') {
				// 無しの場合は操作不可
				jQuery('input[id^="bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_bhColorPlace').prop("disabled", true);
				jQuery('#bhColor_div input[type="checkbox"]').each(function(index, elem){
					elem = jQuery(elem);
					if (elem.prop("checked")) {
						elem.removeAttr("checked");
					}
				})
				jQuery('#bhColor_div input[type="radio"]').each(function(index, elem){
					elem = jQuery(elem);
					if (elem.prop("checked")) {
						elem.removeAttr("checked");
					}
				})
				// 無しの場合は2階層目を表示しない
				jQuery('#bhColor_div').hide();
			} else {
				// 有りの場合は操作可能
				ctrlBhColorPlace();
				jQuery('input[id^="bhColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#bhColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_bhColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#bhColor_div').show();
			}
		});
	});

	// ボタンホール色指定(全選択)
	jQuery('#btn_as_bhColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#bhColorPlaceAll').val();

		jQuery('#bhColor_div input[type="checkBox"]').each(function(index, elemCheckBox){
			elemCheckBox = jQuery(elemCheckBox);
			if(!elemCheckBox.prop("disabled")){
				var bhCheckBoxId = elemCheckBox.attr("id");
				jQuery('#'+bhCheckBoxId+'_div input[type="radio"]').each(function(index, elem){
					elem = jQuery(elem);
					if (elem.val() == allColor) elem.prop('checked', true);
				});
			}
		});
	});

	// ボタンホール色指定箇所
	jQuery('input[id^="bhColorPlace_"]').each(function() {
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
	ctrlBhColorPlace();

	// 選択中のボタンホール色指定を取得
	var byColor = jQuery('input[name="coOptionJacketStandardInfo.ojByColor"]:checked').val();
	//無し
	if (byColor == '0003401') {
		// 無しの場合は操作不可
		jQuery('input[id^="byColorPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
			jQuery('#'+this.id+'_div').hide();
		});
		jQuery('#byColorPlaceAll').prop("disabled", true);
		jQuery('#btn_as_byColorPlace').prop("disabled", true);

		jQuery('#byColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.prop("checked")) {
				elem.removeAttr("checked");
			}
		})
		jQuery('#byColor_div input[type="checkbox"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.prop("checked")) {
				elem.removeAttr("checked");
			}
		})
		// 無しの場合は2階層目を表示しない
		jQuery('#byColor_div').hide();
	} else {
		// 有りの場合は操作可能
		ctrlByColorPlace();
		jQuery('input[id^="byColorPlace_"]').each(function() {
//			jQuery(this).prop("disabled", false);
			if (jQuery(this).prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+this.id+'_div').show();
			}
		});
		jQuery('#byColorPlaceAll').prop("disabled", false);
		jQuery('#btn_as_byColorPlace').prop("disabled", false);

		// 有りの場合は2階層目を表示
		jQuery('#byColor_div').show();
	}
	
	// ボタン付け糸指定(有り/無し)
	jQuery('input[id^="byColor_"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var byColor = jQuery('input[name="coOptionJacketStandardInfo.ojByColor"]:checked').val();
			//無し
			if (byColor == '0003401') {
				// 無しの場合は操作不可
				jQuery('input[id^="byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_byColorPlace').prop("disabled", true);
				jQuery('#byColor_div input[type="radio"]').each(function(index, elem){
					elem = jQuery(elem);
					if (elem.prop("checked")) {
						elem.removeAttr("checked");
					}
				})
				jQuery('#byColor_div input[type="checkbox"]').each(function(index, elem){
					elem = jQuery(elem);
					if (elem.prop("checked")) {
						elem.removeAttr("checked");
					}
				})
				// 無しの場合は2階層目を表示しない
				jQuery('#byColor_div').hide();
			} else {
				// 有りの場合は操作可能
				ctrlByColorPlace();
				jQuery('input[id^="byColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#byColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_byColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#byColor_div').show();
			}
		});
	});

	// ボタン付け糸指定(全選択)
	jQuery('#btn_as_byColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#byColorPlaceAll').val();
		jQuery('#byColor_div input[type="checkBox"]').each(function(index, elemCheckBox){
			elemCheckBox = jQuery(elemCheckBox);
			if(!elemCheckBox.prop("disabled")){
				var byCheckBoxId = elemCheckBox.attr("id");
				jQuery('#'+byCheckBoxId+'_div input[type="radio"]').each(function(index, elem){
					elem = jQuery(elem);
					if (elem.val() == allColor) elem.prop('checked', true);
				});
			}
		});
	});

	// ボタン付け糸指定箇所
	jQuery('input[id^="byColorPlace_"]').each(function() {
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
	ctrlByColorPlace();

	/*// 胴裏素材
	jQuery('#bodyBackMate').change(function (){
		var bodyBackMate = jQuery('#bodyBackMate').val();

		// 胴裏品番
		var bodyBackMateStkNoElem = jQuery('#bodyBackMateStkNo');

		// 選択肢をクリア
		bodyBackMateStkNoElem.empty();

		if (bodyBackMateStkNoList[bodyBackMate]) {
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < bodyBackMateStkNoList[bodyBackMate].length; i++) {
				bodyBackMateStkNoElem.append(jQuery('<option />').val(bodyBackMateStkNoList[bodyBackMate][i]).text(bodyBackMateStkNoList[bodyBackMate][i]));
			}
		}
	});
	jQuery('#bodyBackMate').change();*/
	var cuffBackMate = jQuery('#cuffBackMate').val();
	
	// 袖裏品番
	var cuffBackMateStkNoElem = jQuery('#cuffBackMateStkNo');

	if (cuffBackMate == '2000300') {
		jQuery('#cuffBackMateStkNo').prop("disabled", false);
	} else {
		jQuery('#cuffBackMateStkNo').prop("disabled", true);
	}
	// 袖裏素材
	jQuery('#cuffBackMate').change(function (){
		var cuffBackMate = jQuery('#cuffBackMate').val();
		
		// 袖裏品番
		var cuffBackMateStkNoElem = jQuery('#cuffBackMateStkNo');

		if (cuffBackMate == '2000300') {
			jQuery('#cuffBackMateStkNo').prop("disabled", false);
		} else {
			jQuery('#cuffBackMateStkNo').prop("disabled", true);
		}
	});
	//jQuery('#cuffBackMate').change();

	/*// 釦素材
	jQuery('#btnMate').change(function (){
		var btnMate = jQuery('#btnMate').val();

		// 釦品番
		var btnMateStkNoElem = jQuery('#btnMateStkNo');

		// 選択肢をクリア
		btnMateStkNoElem.empty();

		if (btnMateStkNoList[btnMate]) {
			// 定義が存在する場合は品番を選択肢にセット
			for (var i = 0; i < btnMateStkNoList[btnMate].length; i++) {
				btnMateStkNoElem.append(jQuery('<option />').val(btnMateStkNoList[btnMate][i]).text(btnMateStkNoList[btnMate][i]));
			}
		}

		var sItem = jQuery('#item').val();
		var elemPants1    = jQuery('#op_button');
		var elemPants2    = jQuery('#op2_button');
		var elemPants1Stk = jQuery('#op_btnMateStkNo');
		var elemPants2Stk = jQuery('#op2_btnMateStkNo');
		if (sItem == "01") {
			// スーツの場合はパンツの釦素材を合わせて変更
			elemPants1.val([btnMate]);
			elemPants1.change();
			elemPants1Stk.change();
			elemPants2.val([btnMate]);
			elemPants2.change();
			elemPants2Stk.change();
		}

	});
	jQuery('#btnMate').change();*/

	/*// 釦素材
	jQuery('#btnMateStkNo').change(function() {

		var sItem = jQuery('#item').val();
		var sMateStkNo = jQuery('#btnMateStkNo').val();
		var elemPants1Stk = jQuery('#op_btnMateStkNo');
		var elemPants2Stk = jQuery('#op2_btnMateStkNo');

		// 釦品番
		if (sItem == "01") {
			elemPants1Stk.val([sMateStkNo]);
			elemPants2Stk.val([sMateStkNo]);
		}
	});
	jQuery('#btnMateStkNo').change();*/

}


//--------------------------------------------
// 部品
//--------------------------------------------
// ラペルデザイン変更時
function changeLapelDesign() {
	// AMF色指定の有効/無効を制御
	//ctrlAmfColor();

	var lapelDesign = jQuery('input[name="coOptionJacketStandardInfo.ojLapelDesign"]:checked').val();

	// 襟裏（ヒゲ）の制御
	//shawl:0000203
	if (lapelDesign == "0000203") {
		// 「ショール」選択時、「無」のみ
		jQuery('#backCollar_id1').prop("disabled", true);
		jQuery('#backCollar_id2').prop("checked", true);
		jQuery('input[name="coOptionJacketStandardInfo.ojBackCollar"]:checked').change();
	} else {
		jQuery('#backCollar_id1').prop("disabled", false);
	}
	
	// ラペル幅の制御
	//shawl:0000203
	if (lapelDesign == "0000203") {
		// 「ショール」選択時、「通常」のみ
		jQuery('#lapelWidth_id2').prop("disabled", true);
		jQuery('#lapelWidth_id3').prop("disabled", true);
		jQuery('#lapelWidth_id1').prop("checked", true);
		jQuery('input[name="coOptionJacketStandardInfo.ojLapelWidth"]:checked').change();
	} else {
		jQuery('#lapelWidth_id2').prop("disabled", false);
		jQuery('#lapelWidth_id3').prop("disabled", false);
	}
	
	//フラワーホールの制御
	//shawl:0000203
	if (lapelDesign == "0000203") {
		// 「ショール」選択時、「通常」のみ
		//jQuery('#flowerHole').val("0001005");
		jQuery("#flowerHole option[value='0001005']").prop("selected", true);  
		jQuery('#flowerHole').prop("disabled",true);
		jQuery('#flowerHole').change();
	} else {
		jQuery('#flowerHole').prop("disabled",false);
	}
}

// AMFステッチ変更時
function changeStitch() {
	// 選択中のAMFステッチ
	var stitchValue = jQuery('input[name="coOptionJacketStandardInfo.ojStitch"]:checked').val();
	var stitchDValue = jQuery('input[name="coOptionJacketStandardInfo.ojDStitchModify"]:checked').val();
	var amfValue = jQuery('input[name="coOptionJacketStandardInfo.ojAmfColor"]:checked').val();
	//無し:0005101
	if (stitchValue != "0005101") {
		// 有りの場合、関連する項目を有効化
		// ステッチ箇所変更
		jQuery('input[name="coOptionJacketStandardInfo.ojStitchModify"]').prop("disabled", false);

		// ダブルステッチ変更
		jQuery('input[name="coOptionJacketStandardInfo.ojDStitchModify"]').prop("disabled", false);

		// AMF色指定
		jQuery('input[name="coOptionJacketStandardInfo.ojAmfColor"]').prop("disabled", false);

		// ステッチ関連の項目を表示
		jQuery('#stitch_yes_area').show();
	} else {
		// 無しの場合、関連する項目を無効化・値変更
		// ステッチ箇所変更
		//jQuery('input[name="coOptionJacketStandardInfo.ojStitchModify"]').prop("disabled", true);
		jQuery('#stitchModify_id1').prop("checked", true);
		jQuery('#stitchModify_id1').change();

		// ダブルステッチ変更
		//jQuery('input[name="coOptionJacketStandardInfo.ojDStitchModify"]').prop("disabled", true);
		jQuery('#dStitchModify_id1').prop("checked", true);
		jQuery('#dStitchModify_id1').change();

		// AMF色指定
		//jQuery('input[name="coOptionJacketStandardInfo.ojAmfColor"]').prop("disabled", true);
		jQuery('#amfColor_id1').prop("checked", true);
		jQuery('#amfColor_id1').change();


		// ステッチ関連の項目を非表示
		jQuery('#stitch_yes_area').hide();
	}

	// AMFステッチが有りの場合はダブルステッチを有効化する
	//有り(AMFステッチ):0005102
	if (stitchValue != '0005104') {
		if(stitchValue == "0005102"){
			jQuery('input[id="dStitchModify_id2"]').prop("disabled", false);
		}else{
			jQuery('input[id="dStitchModify_id2"]').prop("disabled", true);
			jQuery('input[id="dStitchModify_id1"]').prop("checked", true);
			if(stitchDValue != "0002601"){
				jQuery('input[name="coOptionJacketStandardInfo.ojDStitchModify"]:checked').change();
			}
		}
	} else {
		jQuery('input[id="dStitchModify_id2"]').prop("disabled", true);
		jQuery('input[id="dStitchModify_id1"]').prop("checked", true);
		if(stitchDValue != "0002601"){
			jQuery('input[name="coOptionJacketStandardInfo.ojDStitchModify"]:checked').change();
		}
		jQuery('input[id="amfColor_id2"]').prop("disabled", true);
		jQuery('input[id="amfColor_id1"]').prop("checked", true);
		if(amfValue != "0002801"){
			jQuery('input[name="coOptionJacketStandardInfo.ojAmfColor"]:checked').change();
		}
	}
}

jQuery('#btn_ar_stitchModifyPlace').click(function(){
	var ojStitchModify = jQuery('input[name="coOptionJacketStandardInfo.ojStitchModify"]:checked').val();
	var ojDStitchModify = jQuery('input[name="coOptionJacketStandardInfo.ojDStitchModify"]:checked').val();
	var ojAmfColor = jQuery('input[name="coOptionJacketStandardInfo.ojAmfColor"]:checked').val();
	
	if(ojDStitchModify == "0002602"){
		jQuery("#btn_ar_dStitchModifyPlace").click();
	}
	
	if(ojAmfColor == "0002802"){
		jQuery("#btn_ar_amfColorPlace").click();
	}
})

// ステッチ箇所変更の有効/無効を制御する
function ctrlStitchModify() {
	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="coOptionJacketStandardInfo.ojStitchModify"]:checked').val();

	// ステッチ箇所変更の有無で下位階層の表示制御
	//無し:0002401
	if (stitchModifyValue != '0002401') {
		jQuery('#stitchModify_yes_area').show();
	} else {
		jQuery('#stitchModify_yes_area').hide();
	}

	// 選択中のJacketモデルを取得
	var jacketModel = jQuery('#jacketModel').val();

	if (!stitchModifyList[jacketModel] || !stitchModifyList[jacketModel]) {
		// Jacketモデルとラペルデザインの組み合わせが定義にない場合はすべて変更不可
		jQuery('input[id^="stitchModifyPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		});
		return;
	}

	var tmpStitchModifyPlace = null;
	var stitchModifyDef = null;
	var tmpStitchModify = null;
	for (tmpStitchModifyPlace in stitchModifyList[jacketModel]) {
		// 定義取得
		stitchModifyDef = stitchModifyList[jacketModel][tmpStitchModifyPlace];
		// 要素取得
		tmpStitchModify = jQuery('#stitchModifyPlace_'+tmpStitchModifyPlace);

		// 有効無効設定
		//有り:0002402
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
	//有り:0002402
	if (stitchModifyValue == '0002402') {
		jQuery('#btn_as_stitchModifyPlace').prop("disabled", false);
		jQuery('#btn_ar_stitchModifyPlace').prop("disabled", false);
	} else {
		jQuery('#btn_as_stitchModifyPlace').prop("disabled", true);
		jQuery('#btn_ar_stitchModifyPlace').prop("disabled", true);
	}
	
	if(stitchModifyValue!="0002401"){
		jQuery('input[id^="stitchModifyPlace_id"]').change();
	}
}

// ダブルステッチ変更箇所の有効/無効を制御する
function ctrlDStitchModify() {
	// 選択中のステッチ箇所変更
	var dStitchModifyValue = jQuery('input[name="coOptionJacketStandardInfo.ojDStitchModify"]:checked').val();

	// 選択中の胸ポケットを取得
	var breastPktValue = jQuery('input[name="coOptionJacketStandardInfo.ojBreastPkt"]:checked').val();

	// 選択中の腰ポケットを取得
	var waistPktValue = jQuery('#waistPkt').val();
	
	//有り:0002602
	if (dStitchModifyValue == "0002602") {
		jQuery('#dStitchModifyPlace').show();
	} else {
		jQuery('#dStitchModifyPlace').hide();
	}

	// 選択中のJacketモデルを取得
	var jacketModel = jQuery('#jacketModel').val();

	if (!stitchModifyList[jacketModel] || !stitchModifyList[jacketModel]) {
		// Jacketモデルとラペルデザインの組み合わせが定義にない場合はすべて変更不可
		jQuery('input[id^="dStitchModifyPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		});
		return;
	}

	var tmpStitchModifyPlace = null;
	var stitchModifyDef = null;
	var tmpStitchModify = null;
	var stichModifyChecked = false;
	for (tmpStitchModifyPlace in stitchModifyList[jacketModel]) {
		// 定義取得
		stitchModifyDef = stitchModifyList[jacketModel][tmpStitchModifyPlace];
		// 要素取得
		
		if(tmpStitchModifyPlace == 'id4'){
			continue;
		}
		else if(tmpStitchModifyPlace == 'id5'){
			tmpStitchModifyPlace = 'id4';
		}
		else if(tmpStitchModifyPlace == 'id6'){
			tmpStitchModifyPlace = 'id5';
		}
		else if(tmpStitchModifyPlace == 'id7'){
			tmpStitchModifyPlace = 'id6';
		}
		else if(tmpStitchModifyPlace == 'id8'){
			tmpStitchModifyPlace = 'id7';
		}
		else if(tmpStitchModifyPlace == 'id9'){
			tmpStitchModifyPlace = 'id8';
		}
		
		tmpStitchModify = jQuery('#dStitchModifyPlace_'+tmpStitchModifyPlace);
		
		//stichModifyChecked = jQuery('#stitchModifyPlace_'+tmpStitchModifyPlace).prop("checked");
		
		// 有効無効設定
		//有り:0002602
		if (dStitchModifyValue == '0002602') {
			// 有りの場合、定義に基づいて設定変更
			//tmpStitchModify.prop("disabled", stitchModifyDef.disabled);
		} else {
			// 無しの場合、無効にする
			tmpStitchModify.prop("disabled", true);
		}
		// チェック状態の設定
		tmpStitchModify.prop("checked", stitchModifyDef.default);
	}

	// ダブルステッチ変更箇所の有効/無効設定
	jQuery('input[id^="dStitchModifyPlace_"]').each(function() {
		var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("dStitch","stitch");
		var twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
		
		//胸ポケット:0002702,パッチ:0001102
		if(jQuery(this).val() == "0002702"){
			// 胸ポケットが「パッチ」選択時、胸ポケットは選択不可
			if(breastPktValue == "0001102"){
				jQuery(this).prop("disabled", true);
				jQuery(this).prop("checked", false);
			}else if(breastPktValue == "0001101" && twoStichModifyPlaceChecked){
				jQuery(this).prop("disabled", false);
			}
		}
		//腰ポケット0002703:,パッチ:0001203,パッチ＆フラップ:0001204
		else if(jQuery(this).val() == "0002703"){
			if(waistPktValue == "0001203" || waistPktValue == "0001204"){
				// 腰ポケットが「パッチ、パッチ＆フラップ」選択時、腰ポケットは選択不可
				jQuery(this).prop("disabled", true);
				jQuery(this).prop("checked", false);	
			}else{
				if(twoStichModifyPlaceChecked){
					jQuery(this).prop("disabled", false);
				}
			}
		}
		
/*		if(jQuery(this).prop("disabled")){
			if(jQuery(this).val() == "0002702"){
				if(breastPktValue == "0001102"){
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				}else{
					jQuery(this).prop("disabled", false);
				}
			}
			
			if(jQuery(this).val() == "0002703"){
				if(waistPktValue == "0001203" || waistPktValue == "0001204"){
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				}else{
					jQuery(this).prop("disabled", false);
				}
			}
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
			//jQuery(this).prop("checked", true);
		}
*/	});
}

// ダブルステッチ変更(選択肢)の有効/無効を制御する
function ctrlDStitchModifyPlace() {

	// 選択中のJacketモデルを取得
	var jacketModel = jQuery('#jacketModel').val();
	if (isEmpty(jacketModel)) {
		// 未選択時は何もしない
		return;
	}

	// 選択中のステッチ箇所変更
	var dStitchModifyValue = jQuery('input[name="coOptionJacketStandardInfo.ojDStitchModify"]:checked').val();

	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="coOptionJacketStandardInfo.ojStitchModify"]:checked').val();
	
	if(stitchModifyValue == "0002402"){
		var tmpStitchModifyPlace = null;
		var tmpStitchModify = null;
		var stichModifyChecked = false;

		for (tmpStitchModifyPlace in stitchModifyList[jacketModel]) {
			// 定義取得
			stitchModifyDef = stitchModifyList[jacketModel][tmpStitchModifyPlace];
			
			// ステッチ箇所変更要素取得
			stichModifyChecked = jQuery('#stitchModifyPlace_'+tmpStitchModifyPlace).prop("checked");

			if(tmpStitchModifyPlace == 'id4'){
				continue;
			}
			else if(tmpStitchModifyPlace == 'id5'){
				tmpStitchModifyPlace = 'id4';
			}
			else if(tmpStitchModifyPlace == 'id6'){
				tmpStitchModifyPlace = 'id5';
			}
			else if(tmpStitchModifyPlace == 'id7'){
				tmpStitchModifyPlace = 'id6';
			}
			else if(tmpStitchModifyPlace == 'id8'){
				tmpStitchModifyPlace = 'id7';
			}
			else if(tmpStitchModifyPlace == 'id9'){
				tmpStitchModifyPlace = 'id8';
			}
			
			// ダブルステッチ要素取得
			tmpStitchModify = jQuery('#dStitchModifyPlace_'+tmpStitchModifyPlace);
			
			// 有効無効設定
			//有り:0002602
			if (dStitchModifyValue == '0002602' && stichModifyChecked) {
				tmpStitchModify.prop("disabled", false);
				//胸ポケットについて
				if(tmpStitchModifyPlace == "id2"){
					var breastPkt = jQuery('input[name="coOptionJacketStandardInfo.ojBreastPkt"]:checked').val();
					//パッチ:0001102
					if(breastPkt == "0001102"){
						tmpStitchModify.prop("disabled", true);
						tmpStitchModify.prop("checked", false);
					}
				}else if(tmpStitchModifyPlace == "id3"){
					// 選択中の腰ポケットを取得
					var waistPktValue = jQuery('#waistPkt').val();
					if(waistPktValue == "0001203" || waistPktValue == "0001204"){
						tmpStitchModify.prop("disabled", true);
						tmpStitchModify.prop("checked", false);
					}
				}else{
					// 有り且つステッチ箇所変更の同項目が有効の場合、ダブルステッチも有効にする
					tmpStitchModify.prop("disabled", false);
				}
			} else {
				// 上記以外の場合、無効にする
				tmpStitchModify.prop("disabled", true);
				tmpStitchModify.prop("checked", false);
			}
		}
	}else{
		var tmpStitchModifyPlace = null;
		var tmpStitchModify = null;
		var stichModifyChecked = false;

		for (tmpStitchModifyPlace in stitchModifyList[jacketModel]) {
			// 定義取得
			stitchModifyDef = stitchModifyList[jacketModel][tmpStitchModifyPlace];
			
			// ステッチ箇所変更要素取得
			stichModifyChecked = jQuery('#stitchModifyPlace_'+tmpStitchModifyPlace).prop("checked");

			if(tmpStitchModifyPlace == 'id4'){
				continue;
			}
			else if(tmpStitchModifyPlace == 'id5'){
				tmpStitchModifyPlace = 'id4';
			}
			else if(tmpStitchModifyPlace == 'id6'){
				tmpStitchModifyPlace = 'id5';
			}
			else if(tmpStitchModifyPlace == 'id7'){
				tmpStitchModifyPlace = 'id6';
			}
			else if(tmpStitchModifyPlace == 'id8'){
				tmpStitchModifyPlace = 'id7';
			}
			else if(tmpStitchModifyPlace == 'id9'){
				tmpStitchModifyPlace = 'id8';
			}
			
			// ダブルステッチ要素取得
			tmpStitchModify = jQuery('#dStitchModifyPlace_'+tmpStitchModifyPlace);
			
			// 有効無効設定
			//有り:0002602
			if (dStitchModifyValue == '0002602') {
				tmpStitchModify.prop("disabled", false);
				//胸ポケットについて
				if(tmpStitchModifyPlace == "id2"){
					var breastPkt = jQuery('input[name="coOptionJacketStandardInfo.ojBreastPkt"]:checked').val();
					//パッチ:0001102
					if(breastPkt == "0001102"){
						tmpStitchModify.prop("disabled", true);
						tmpStitchModify.prop("checked", false);
					}
				}else if(tmpStitchModifyPlace == "id3"){
					// 選択中の腰ポケットを取得
					var waistPktValue = jQuery('#waistPkt').val();
					if(waistPktValue == "0001203" || waistPktValue == "0001204"){
						tmpStitchModify.prop("disabled", true);
						tmpStitchModify.prop("checked", false);
					}
				}else{
					// 有り且つステッチ箇所変更の同項目が有効の場合、ダブルステッチも有効にする
					tmpStitchModify.prop("disabled", stitchModifyDef.disabled);
				}
			} else {
				// 上記以外の場合、無効にする
				tmpStitchModify.prop("disabled", true);
				tmpStitchModify.prop("checked", false);
			}
		}
	}

	
}

// AMF色指定の有効/無効を制御する
function ctrlAmfColor() {
	// 選択中AMF色指定
	var amfColorValue = jQuery('input[name="coOptionJacketStandardInfo.ojAmfColor"]:checked').val();
	
	// 選択中のステッチ箇所変更
	var stitchModifyValue = jQuery('input[name="coOptionJacketStandardInfo.ojStitchModify"]:checked').val();
	
	// ステッチ箇所変更の有無で下位階層の表示制御
	//有り:0002802
	if (amfColorValue == '0002802') {
		jQuery('#amfColor_div').show();
		jQuery('#amfColorPlaceAll').prop("disabled", false);
		jQuery('#btn_as_amfColorPlace').prop("disabled", false);
	} else {
		jQuery('#amfColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.prop("checked")) {
				elem.removeAttr("checked");
			}
		});
		jQuery('#amfColor_div input[type="checkbox"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.prop("checked")) {
				elem.removeAttr("checked");
			}
		});
		jQuery('#amfColor_div').hide();
		jQuery('#amfColorPlaceAll').prop("disabled", true);
		jQuery('#btn_as_amfColorPlace').prop("disabled", true);
	}

	// 選択中のJacketモデルを取得
	var jacketModel = jQuery('#jacketModel').val();

	if (!stitchModifyList[jacketModel]) {
		// Jacketモデルとラペルデザインの組み合わせが定義にない場合はすべて変更不可
		jQuery('input[id^="amfColorPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		});
		return;
	}
	if(stitchModifyValue == "0002402"){
		var tmpAmfColorPlace = null;
		var stitchModifyDef = null;
		var tmpAmfColorPlace = null;
		var stichModifyChecked = false;
		for (tmpAmfColorPlace in stitchModifyList[jacketModel]) {
			// 定義取得
			stitchModifyDef = stitchModifyList[jacketModel][tmpAmfColorPlace];
			// ステッチ箇所変更要素取得
			stichModifyChecked = jQuery('#stitchModifyPlace_'+tmpAmfColorPlace).prop("checked");
			// 要素取得
			tmpAmfColorPlace = jQuery('#amfColorPlace_'+tmpAmfColorPlace.replace("id",""));

			// 有効無効設定
			//有り:0002802
			if (amfColorValue == '0002802' && stichModifyChecked) {
				// 有り且つステッチ箇所変更の同項目が有効の場合、AMF色指定も有効にする
				tmpAmfColorPlace.prop("disabled", false);
			} else {
				// 無しの場合、無効にする
				tmpAmfColorPlace.prop("disabled", true);
			}

			if (tmpAmfColorPlace.prop("disabled")) {
				tmpAmfColorPlace.prop("checked", false);
			}

			// 要素のID取得
			tmpAmfColorPlaceId = tmpAmfColorPlace.attr("id");

			if (tmpAmfColorPlace.prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+tmpAmfColorPlaceId+'_div').show();
			} else {
				jQuery('#'+tmpAmfColorPlaceId+'_div').hide();
			}
		}
	}else{
		var tmpAmfColorPlace = null;
		var stitchModifyDef = null;
		var tmpAmfColorPlace = null;
		var stichModifyChecked = false;
		for (tmpAmfColorPlace in stitchModifyList[jacketModel]) {
			// 定義取得
			stitchModifyDef = stitchModifyList[jacketModel][tmpAmfColorPlace];
			// ステッチ箇所変更要素取得
			stichModifyChecked = jQuery('#stitchModifyPlace_'+tmpAmfColorPlace).prop("checked");
			// 要素取得
			tmpAmfColorPlace = jQuery('#amfColorPlace_'+tmpAmfColorPlace.replace("id",""));

			// 有効無効設定
			//有り:0002802
			if (amfColorValue == '0002802') {
				tmpAmfColorPlace.prop("disabled", stitchModifyDef.disabled);
			} 
			
			if (tmpAmfColorPlace.prop("disabled")) {
				tmpAmfColorPlace.prop("checked", false);
			}

			// 要素のID取得
			tmpAmfColorPlaceId = tmpAmfColorPlace.attr("id");

			if (tmpAmfColorPlace.prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+tmpAmfColorPlaceId+'_div').show();
			} else {
				jQuery('#'+tmpAmfColorPlaceId+'_div').hide();
			}
		}
	}
}

function ojWaistPktChange(){
	// 選択中の腰ポケット
	var waistPkt = jQuery('#waistPkt').val();
	if (!slantedPktList[waistPkt]) {
		// 想定外の値の場合は何もしない
		return;
	}

	// チェンジポケットの有効無効を制御
	jQuery('input[id^="changePkt_"]').each(function(index, elem) {
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
	jQuery('input[name="coOptionJacketStandardInfo.ojChangePkt"]').val([slantedPktList[waistPkt].defaultValue]);
	// チェンジポケット変更時の制御
	changeChangePkt();
	
	// ダブルステッチ変更箇所の有効/無効
	// 選択中のステッチ箇所変更
	var dStitchModifyValue = jQuery('input[name="coOptionJacketStandardInfo.ojDStitchModify"]:checked').val();

	// 選択中の胸ポケットを取得
	var breastPktValue = jQuery('input[name="coOptionJacketStandardInfo.ojBreastPkt"]:checked').val();

	// 選択中の腰ポケットを取得
	var waistPktValue = jQuery('#waistPkt').val();
	
	// ダブルステッチ変更箇所の有効/無効設定
	jQuery('input[id^="dStitchModifyPlace_"]').each(function() {
		var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("dStitch","stitch");
		var twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
		//腰ポケット0002703:,パッチ:0001203,パッチ＆フラップ:0001204
		if(jQuery(this).val() == "0002703"){
			if(waistPktValue == "0001203" || waistPktValue == "0001204"){
				// 腰ポケットが「パッチ、パッチ＆フラップ」選択時、腰ポケットは選択不可
				jQuery(this).prop("disabled", true);
				jQuery(this).prop("checked", false);	
			}else{
				if(twoStichModifyPlaceChecked){
					jQuery(this).prop("disabled", false);
				}
			}
		}
	});
}

// チェンジポケット変更時
function changeChangePkt() {
	// 選択中の腰ポケット
	var waistPkt = jQuery('#waistPkt').val();
	if (!slantedPktList[waistPkt]) {
		// 想定外の値の場合は何もしない
		return;
	}

	// 選択中のチェンジポケット
	var changePkt = jQuery('input[name="coOptionJacketStandardInfo.ojChangePkt"]:checked').val();
	if (!slantedPktList[waistPkt].activeList[changePkt]) {
		// 想定外の値の場合は何もしない
		return;
	}

	// スランテッドポケットの有効無効を制御
	jQuery('input[id^="slantedPkt_"]').each(function(index, elem) {
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
	jQuery('input[name="coOptionJacketStandardInfo.ojSlantedPkt"]').val([slantedPktList[waistPkt].activeList[changePkt].defaultValue]);
	jQuery('input[name="coOptionJacketStandardInfo.ojSlantedPkt"]:checked').change();
}

// ボタンホール色指定箇所の有効/無効を制御する
function ctrlBhColorPlace() {

	// 選択中のボタンホール色指定
	var bhColor = jQuery('input[name="coOptionJacketStandardInfo.ojBhColor"]:checked').val();

	// 選択中のフラワーホール
	var flowerHole = jQuery('#flowerHole').val();

	// 選択中のフロント釦数
	var frontBtnCnt = jQuery('#oj_frontBtnCnt').val();

	// 選択中の袖釦
	var sleeveBtnType = jQuery('input[name="coOptionJacketStandardInfo.ojSleeveBtnType"]:checked').val();
	var sleeveBtnCnt = jQuery('#sleeveBtnCnt').val() - 0;

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#bhColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (bhColor == "0003102") {
			// 有りの場合は一旦有効化し、項目ごとに無効判定
			elem.prop("disabled", false);
			//フラワーホール(上前1):0003201
			if (elem.val() == "0003201") {
				// フラワーホールの指定に関わらず、常に有効
				if (flowerHole == "0001005") {
					elem.prop("disabled", true);
				}
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

// ボタン付け糸指定箇所の有効/無効を制御する
function ctrlByColorPlace() {

	// 選択中のボタン付け糸指定
	var byColor = jQuery('input[name="coOptionJacketStandardInfo.ojByColor"]:checked').val();

	// 選択中のフロント釦数
	var frontBtnCnt = jQuery('#oj_frontBtnCnt').val();

	// 選択中の袖釦
	var sleeveBtnType = jQuery('input[name="coOptionJacketStandardInfo.ojSleeveBtnType"]:checked').val();
	var sleeveBtnCnt = jQuery('#sleeveBtnCnt').val() - 0;

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#byColor_div input[type="checkbox"]').each(function(index, elem){
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
					if (frontBtnCnt == "0000105") {
						elem.prop("disabled", false);
					}else{
						elem.prop("disabled", true);
					}
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
				if (frontBtnCnt != "0000105") {
					elem.prop("disabled", true);
				}
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