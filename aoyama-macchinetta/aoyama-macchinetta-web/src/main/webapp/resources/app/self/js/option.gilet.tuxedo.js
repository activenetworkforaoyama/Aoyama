/*********************************************
 * タキシードGILET用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionGiletTuxedo() {

	jQuery('#tg_giletModel').attr("oldGlModel",jQuery('#tg_giletModel').val());
	// GILETモデル
	jQuery('#tg_giletModel').change(function(){
		var giletModel = jQuery(this).val();
		var giletOldModel = jQuery('#tg_giletModel').attr("oldGlModel");
		var modelFlag = 0;
		if(giletOldModel == '' || giletOldModel == null){
			modelFlag = 1;
		}else {
			modelFlag = 2;
		}
		if(giletModel != giletOldModel){
			jQuery("#giletFlag").val("0");
		}else{
			jQuery("#giletFlag").val("1");
		}
		jQuery('#tg_giletModel').attr("oldGlModel",jQuery('#tg_giletModel').val());
		var giletFlag = jQuery('#giletFlag').val();
		if (giletFlag == "0") {
			// 選択されたGiletモデルを取得
			if (giletModel == '') {
				// 未選択時は何もしない
				return;
			}
		
			var productFabricNo = jQuery("#productFabricNo").val();
			var itemCode = "";
			var item = jQuery("#item").val();
			var subItemCode = "04"
			if(item == "01"){
				itemCode = "01"
			}else if(item == "04"){
				itemCode = "04"
			}
			
			//生地チェクフラッグ
			var fabricCheckValue = jQuery("#fabricFlag").val();
			//fabricCheckValue[0]:0 or 1 or 2 
			//fabricCheckValue[1]:エラーメッセージ 
			fabricCheckValue = fabricCheckValue.split("*");
			
			//生地チェク成功の場合
			if((fabricCheckValue[0]=="0"||fabricCheckValue[0]=="2")&&isNotEmpty(productFabricNo)){
				//モデルチェク
				var checkResult = modelCheck(giletModel,productFabricNo,orderPattern,itemCode,subItemCode);
				if(checkResult == "true"){
					//0はモデルチェク成功の場合
					jQuery("#glModelFlag").val("0");
					jQuery("#tg_giletModelCheck").empty();
					jQuery("#fabricMsg").empty();
					jQuery("#tg_giletModelCheck").hide();
				}else if(checkResult == "false"){
					//2はモデルチェク失敗の場合
					jQuery("#tg_giletModelCheck").show();
					jQuery("#glModelFlag").val("1"+"*"+getMsgByOneArg('msg065','GILET'));
					setAlert('tg_giletModelCheck',getMsgByOneArg('msg065','GILET'));
				}
			}
	
			// GILETモデルに基づき、各項目をデフォルトへ変更
			// 胸ポケット
			var beforeBreastPkt = jQuery('input[name="coOptionGiletTuxedoInfo.tgBreastPkt"]:checked').val();
			jQuery('input[name="coOptionGiletTuxedoInfo.tgBreastPkt"]').val([ogGiletModelDefaultList[giletModel]["og_breastPkt"]]);
	
			// 腰ポケット
			var beforeWaistPkt = jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPkt"]:checked').val();
			jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPkt"]').val([ogGiletModelDefaultList[giletModel]["og_waistPkt"]]);
	
			// 腰ポケット形状
			var beforeWaistPktSpec = jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPktSpec"]:checked').val();
			jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPktSpec"]').val([ogGiletModelDefaultList[giletModel]["og_waistPktSpec"]]);
	
			// バックベルト
			var beforeBackBelt = jQuery('#tg_backBelt').val();
			jQuery('#tg_backBelt').val(ogGiletModelDefaultList[giletModel]["og_backBelt"]);
	
			// ボタンホール色指定箇所の有効/無効を制御
			ctrlTgBhColorPlace();
	
			// ボタン付け糸指定箇所の有効/無効を制御
			ctrlTgByColorPlace();
			
			//ボタンホール色指定
			jQuery('#tg_bhColor_id1').prop("checked", true);
			jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColor"]:checked').change();
	
			//ボタン付け糸指定
			jQuery('#tg_byColor_id1').prop("checked", true);
			jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor"]:checked').change();
	
			// 別モデルに変更された場合はアラート表示
			if ((tmpTgGiletModel != '' || tmpTgGiletModel !=null) && giletModel != tmpTgGiletModel  && modelFlag == 2) {
			    setAlert('tg_giletModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
			}
			// 一時保存のモデルを更新
			tmpTgGiletModel = giletModel;
		}
		
	});
	
	//拝絹地
	var item = jQuery("#item").val();
	if(item == "01"){
		jQuery("#tg_GlossFablic").prop("disabled",true);
	}else{
		jQuery("#tg_GlossFablic").prop("disabled",false);
	}
	
	// 選択中の腰ポケット
	var waistPkt = jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPkt"]:checked').val();
	if (waistPkt == "0000201") {
		// 腰ポケットが有りの場合は腰ポケット形状と腰ポケット素材を表示する
		jQuery('#tg_waistPkt_yes_area').show();
	} else {
		// 腰ポケットが有りの場合は腰ポケット形状と腰ポケット素材を非表示にする
		jQuery('#tg_waistPkt_yes_area').hide();
	}

	// 腰ポケット
	jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPkt"]').each(function() {
		jQuery(this).change(function(){
			// 選択中の腰ポケット
			var waistPkt = jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPkt"]:checked').val();
			if (waistPkt == "0000201") {
				// 腰ポケットが有りの場合は腰ポケット形状と腰ポケット素材を表示する
				jQuery('#tg_waistPkt_yes_area').show();
			} else {
				// 腰ポケットが有りの場合は腰ポケット形状と腰ポケット素材を非表示にする
				jQuery('#tg_waistPkt_yes_area').hide();
			}
		});
	});

	// 選択中のボタンホール色指定を取得
	var bhColor = jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColor"]:checked').val();

	if (bhColor == '0001101') {
		// 無しの場合は操作不可
		jQuery('input[id^="tg_bhColorPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
			jQuery('#'+this.id+'_div').hide();
		});
		jQuery('#tg_bhColorPlaceAll').prop("disabled", true);
		jQuery('#btn_as_tg_bhColorPlace').prop("disabled", true);

		// 無しの場合は2階層目を表示しない
		jQuery('#tg_bhColor_div').hide();
	} else {
		// 有りの場合は操作可能
		ctrlTgBhColorPlace();
		jQuery('input[id^="tg_bhColorPlace_"]').each(function() {
//			jQuery(this).prop("disabled", false);
			if (jQuery(this).prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+this.id+'_div').show();
			}
		});
		jQuery('#tg_bhColorPlaceAll').prop("disabled", false);
		jQuery('#btn_as_tg_bhColorPlace').prop("disabled", false);

		// 有りの場合は2階層目を表示
		jQuery('#tg_bhColor_div').show();
	}
	
	// ボタンホール色指定(有り/無し)
	jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColor"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var bhColor = jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColor"]:checked').val();

			if (bhColor == '0001101') {
				// 無しの場合は操作不可
				jQuery('input[id^="tg_bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#tg_bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_tg_bhColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#tg_bhColor_div').hide();
			} else {
				// 有りの場合は操作可能
				ctrlTgBhColorPlace();
				jQuery('input[id^="tg_bhColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#tg_bhColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_tg_bhColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#tg_bhColor_div').show();
			}
		});
	});
	jQuery('#tg_bhColor_id1').change();

	// ボタンホール色指定(全選択)
	jQuery('#btn_as_tg_bhColorPlace').click(function(){ 
		// 全選択する色を取得 
		var allColor = jQuery('#tg_bhColorPlaceAll').val(); 
	
		jQuery('#tg_bhColor_div input[type="checkBox"]').each(function(index, elemCheckBox){ 
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
	jQuery('input[id^="tg_bhColorPlace_"]').each(function() { 
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
	ctrlTgBhColorPlace();

	// 選択中のボタンホール色指定を取得
	var byColor = jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor"]:checked').val();

	if (byColor == '0001401') {
		// 無しの場合は操作不可
		jQuery('input[id^="tg_byColorPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
			jQuery('#'+this.id+'_div').hide();
		});
		jQuery('#tg_byColorPlaceAll').prop("disabled", true);
		jQuery('#btn_as_tg_byColorPlace').prop("disabled", true);

		// 無しの場合は2階層目を表示しない
		jQuery('#tg_byColor_div').hide();
	} else {
		// 有りの場合は操作可能
		ctrlTgByColorPlace();
		jQuery('input[id^="tg_bhColorPlace_"]').each(function() {
			if (jQuery(this).prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+this.id+'_div').show();
			}
		});
		jQuery('#tg_byColorPlaceAll').prop("disabled", false);
		jQuery('#btn_as_tg_byColorPlace').prop("disabled", false);

		// 有りの場合は2階層目を表示
		jQuery('#tg_byColor_div').show();
	}
	
	// ボタン付け糸指定(有り/無し)
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var byColor = jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor"]:checked').val();

			if (byColor == '0001401') {
				// 無しの場合は操作不可
				jQuery('input[id^="tg_byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#tg_byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_tg_byColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#tg_byColor_div').hide();
			} else {
				// 有りの場合は操作可能
				ctrlTgByColorPlace();
				jQuery('input[id^="tg_bhColorPlace_"]').each(function() {
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#tg_byColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_tg_byColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#tg_byColor_div').show();
			}
		});
	});
	jQuery('#tg_byColor_id1').change();

	// ボタン付け糸指定(全選択)
	jQuery('#btn_as_tg_byColorPlace').click(function(){ 
		// 全選択する色を取得 
		var allColor = jQuery('#tg_byColorPlaceAll').val(); 
	
		jQuery('#tg_byColor_div input[type="checkBox"]').each(function(index, elemCheckBox){ 
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

	// ボタンホール色指定箇所
	jQuery('input[id^="tg_byColorPlace_"]').each(function() { 
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
	ctrlTgByColorPlace();

	var bodyBackMate = jQuery('#tg_backLiningMate').val();
	// バックベルト
	var backBeltElem = jQuery('#tg_backBelt');
	var selectedBackBelt = backBeltElem.val();
	// 選択肢をクリア
	backBeltElem.empty();
	if (bodyBackMate == "1000400") {
		// 背裏素材「表地」選択時、バックベルトは「無し」か「537-5K」のみ
		backBeltElem.append(jQuery('<option />').val("0002302").text("546-20（尾錠型）"));
		backBeltElem.append(jQuery('<option />').val("0002303").text("無し"));

		if (selectedBackBelt == "0002301") {
			backBeltElem.val("0002302");
			jQuery('#tg_backBelt').change();
		} else {
			backBeltElem.val(selectedBackBelt);
		}
	} else {
		backBeltElem.append(jQuery('<option />').val("0002302").text("546-20（尾錠型）"));
		backBeltElem.append(jQuery('<option />').val("0002301").text("537-5K（2×1型）"));
		backBeltElem.append(jQuery('<option />').val("0002303").text("無し"));
		backBeltElem.val(selectedBackBelt);
	}
	
//	// 背裏地素材
	jQuery('#tg_backLiningMate').change(function (){
		var bodyBackMate = jQuery('#tg_backLiningMate').val();

//		// 背裏地品番
//		var bodyBackMateStkNoElem = jQuery('#tg_backLiningMateStkNo');
//
//		// 選択肢をクリア
//		bodyBackMateStkNoElem.empty();
//
//		if (bodyBackMateStkNoList[bodyBackMate]) {
//			// 定義が存在する場合は品番を選択肢にセット
//			for (var i = 0; i < bodyBackMateStkNoList[bodyBackMate].length; i++) {
//				bodyBackMateStkNoElem.append(jQuery('<option />').val(bodyBackMateStkNoList[bodyBackMate][i]).text(bodyBackMateStkNoList[bodyBackMate][i]));
//			}
//			bodyBackMateStkNoElem.prop("disabled", false);
//			jQuery('#btn_tg_insideLiningMate').prop("disabled", false);
//		} else if (bodyBackMate == "1000400") {
//			// 表地仕様の場合は品番選択不可
//			bodyBackMateStkNoElem.prop("disabled", true);
//			jQuery('#btn_tg_insideLiningMate').prop("disabled", true);
//		}

		// バックベルト
		var backBeltElem = jQuery('#tg_backBelt');
		var selectedBackBelt = backBeltElem.val();
		// 選択肢をクリア
		backBeltElem.empty();
		if (bodyBackMate == "1000400") {
			// 背裏素材「表地」選択時、バックベルトは「無し」か「537-5K」のみ
			backBeltElem.append(jQuery('<option />').val("0002302").text("546-20（尾錠型）"));
//			backBeltElem.append(jQuery('<option />').val("0002301").text("537-5K（2×1型）"));
			backBeltElem.append(jQuery('<option />').val("0002303").text("無し"));

			if (selectedBackBelt == "0002301") {
				backBeltElem.val("0002302");
				jQuery('#tg_backBelt').change();
			} else {
				backBeltElem.val(selectedBackBelt);
			}
		} else {
			backBeltElem.append(jQuery('<option />').val("0002302").text("546-20（尾錠型）"));
			backBeltElem.append(jQuery('<option />').val("0002301").text("537-5K（2×1型）"));
			backBeltElem.append(jQuery('<option />').val("0002303").text("無し"));
			backBeltElem.val(selectedBackBelt);
		}
	});
//	jQuery('#tg_backLiningMate').change();
//
//	// 背裏地素材（上着と同じ）
//	jQuery('#btn_tg_backLiningMate').click(function() {
//		// JACKET胴裏素材
//		var bodyBackMate = jQuery('#tj_bodyBackMate').val();
//		// JACKET胴裏品番
//		var bodyBackMateStkNo = jQuery('#tj_bodyBackMateStkNo').val();
//
//		// 背裏地素材への反映
//		jQuery('#tg_backLiningMate').val(bodyBackMate);
//		jQuery('#tg_backLiningMate').change();
//		jQuery('#tg_backLiningMateStkNo').val(bodyBackMateStkNo);
//	});

//	// 内側裏地素材
//	jQuery('#tg_insideLiningMate').change(function (){
//		var bodyBackMate = jQuery('#tg_insideLiningMate').val();
//
//		// 内側裏地品番
//		var bodyBackMateStkNoElem = jQuery('#tg_insideLiningMateStkNo');
//
//		// 選択肢をクリア
//		bodyBackMateStkNoElem.empty();
//
//		if (giletInsideLiningMateStkNoList[bodyBackMate]) {
//			// 定義が存在する場合は品番を選択肢にセット
//			for (var i = 0; i < giletInsideLiningMateStkNoList[bodyBackMate].length; i++) {
//				bodyBackMateStkNoElem.append(jQuery('<option />').val(giletInsideLiningMateStkNoList[bodyBackMate][i]).text(giletInsideLiningMateStkNoLists[bodyBackMate][i]));
//			}
//		}
//	});
//	jQuery('#tg_insideLiningMate').change();

//	// フロント釦
//	jQuery('#tg_frontBtnMate').change(function (){
//		var btnMate = jQuery('#tg_frontBtnMate').val();
//
//		// フロント釦品番
//		var btnMateStkNoElem = jQuery('#tg_frontBtnMateStkNo');
//
//		// 選択肢をクリア
//		btnMateStkNoElem.empty();
//
//		// 釦素材が包みの場合は品番の選択肢を非表示
//		if (btnMate == '3000700') {
////			jQuery('#tg_frontBtnMateStkNo').hide();
//			jQuery('#tg_frontBtnMateStkNo').prop('disabled', true);
//		} else if (btnMateStkNoList[btnMate]) {
////			jQuery('#tg_frontBtnMateStkNo').show();
//			jQuery('#tg_frontBtnMateStkNo').prop('disabled', false);
//			// 定義が存在する場合は品番を選択肢にセット
//			/*for (var i = 0; i < btnMateStkNoList[btnMate].length; i++) {
//				btnMateStkNoElem.append(jQuery('<option />').val(btnMateStkNoList[btnMate][i]).text(btnMateStkNoList[btnMate][i]));
//			}*/
//		}
//	});
//	jQuery('#tg_frontBtnMate').change();

}

function myGiletTuxedoMethod(){
	var tg_giletModel = jQuery("#tg_giletModel option:selected").val();
	
	//GILETモデルが空の場合,ボタンホール色指定,ボタン付け糸指定を空にします
	if(tg_giletModel == '' || tg_giletModel == null){
		//ボタンホール色指定
		jQuery('input[id^="tg_bhColorPlace_"]').each(function() {
			jQuery(this).removeAttr("checked");
			jQuery(this).prop("disabled", true);
			jQuery('#' + this.id + "_div").hide();
		});
		jQuery('input[id^="tg_bhColor_"]').each(function() {
			var ogBhColorId = jQuery(this).val();
			if(ogBhColorId != "0001101" && ogBhColorId != "0001102"){
				jQuery(this).removeAttr("checked");
			}
		});
		//ボタン付け糸指定
		jQuery('input[id^="tg_byColorPlace_"]').each(function() {
			jQuery(this).removeAttr("checked");
			jQuery(this).prop("disabled", true);
			jQuery('#' + this.id + "_div").hide();
		});
		jQuery('input[id^="tg_byColor_"]').each(function() {
			var ogByColorId = jQuery(this).val();
			if(ogByColorId != "0001401" && ogByColorId != "0001402"){
				jQuery(this).removeAttr("checked");
			}
		});
	}
}

//--------------------------------------------
// 部品
//--------------------------------------------
//ボタンホール色指定箇所の有効/無効を制御する
function ctrlTgBhColorPlace() {

	// 選択中のボタンホール色指定
	var bhColor = jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColor"]:checked').val();

	// 選択中のGILETモデル
	var giletModel = jQuery('#tg_giletModel').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#tg_bhColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		elem = jQuery(elem);

		if (bhColor == "0001102" && giletModelBtnMap[giletModel]) {
			// 有りの場合はモデルに基づいて項目ごとに判定
			if (giletModelBtnMap[giletModel].bh[elem.val()]) {
				// 有効な場合
				elem.prop("disabled", false);
			} else {
				// 無効な場合
				elem.prop("disabled", true);
			}

			// 判定結果が無効の場合、チェックを外す
			if (elem.prop("disabled")) {
				elem.prop("checked", false);
				elem.change();
			}
		} else {
			// 無しの場合、または、想定外のモデルの場合は全て無効化
			elem.prop("disabled", true);
		}
	});
}

//ボタン付け糸指定箇所の有効/無効を制御する
function ctrlTgByColorPlace() {

	// 選択中のボタン付け糸指定
	var byColor = jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor"]:checked').val();

	// 選択中のGILETモデル
	var giletModel = jQuery('#tg_giletModel').val();

	// ボタン付け糸指定箇所の有効/無効を制御
	jQuery('#tg_byColor_div input[type="checkbox"]').each(function(index, elem){
		elem = jQuery(elem);

		if (byColor == "0001402" && giletModelBtnMap[giletModel]) {
			// 有りの場合はモデルに基づいて項目ごとに判定
			if (giletModelBtnMap[giletModel].by[elem.val()]) {
				// 有効な場合
				elem.prop("disabled", false);
			} else {
				// 無効な場合
				elem.prop("disabled", true);
			}

			// 判定結果が無効の場合、チェックを外す
			if (elem.prop("disabled")) {
				elem.prop("checked", false);
				elem.change();
			}
		} else {
			// 無しの場合、または、想定外のモデルの場合は全て無効化
			elem.prop("disabled", true);
		}
	});
}


function modelCheck(modelCode,productFabricNo,orderPattern,itemCode,subItemCode){
	var checkResult = jQuery.ajax({url:contextPath + "/orderCo/checkModel",data:{"modelCode":modelCode,"productFabricNo":productFabricNo,"orderPattern":orderPattern,"itemCode":itemCode,"subItemCode":subItemCode},async:false});
	checkResult = checkResult.responseText;
	return checkResult;
}	