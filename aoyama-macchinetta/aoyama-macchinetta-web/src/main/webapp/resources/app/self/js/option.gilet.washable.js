/*********************************************
 * ウォッシャブルGILET用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionGiletWashable() {

	jQuery('#wg_giletModel').attr("oldGlModel",jQuery('#wg_giletModel').val());
	// GILETモデル
	jQuery('#wg_giletModel').change(function(){
		var giletModel = jQuery(this).val();
		var giletOldModel = jQuery('#wg_giletModel').attr("oldGlModel");
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
		jQuery('#wg_giletModel').attr("oldGlModel",jQuery('#wg_giletModel').val());
		var giletFlag = jQuery('#giletFlag').val();
		if (giletFlag == "0") {
			// 選択されたGiletモデルを取得
			if (giletModel == '') {
				// 未選択時は何もしない
				return;
			}

			//モデルを選択すると、"ステッチ箇所変更"は選択できます
			if(giletModel != null && giletModel != ""){
				jQuery('input[id^="wg_stitchModifyPlace_id"]').prop("disabled", false);
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
					jQuery("#wg_giletModelCheck").empty();
					jQuery("#fabricMsg").empty();
					jQuery("#wg_giletModelCheck").hide();
				}else if(checkResult == "false"){
					//2はモデルチェク失敗の場合
					jQuery("#wg_giletModelCheck").show();
					jQuery("#glModelFlag").val("1"+"*"+getMsgByOneArg('msg065','GILET'));
					setAlert('wg_giletModelCheck',getMsgByOneArg('msg065','GILET'));
				}
			}
			
			// GILETモデルに基づき、各項目をデフォルトへ変更
			// 胸ポケット
			var beforeBreastPkt = jQuery('input[name="coOptionGiletWashableInfo.wgBreastPkt"]:checked').val();
			jQuery('input[name="coOptionGiletWashableInfo.wgBreastPkt"]').val([ogGiletModelDefaultList[giletModel]["og_breastPkt"]]);
	
			// 腰ポケット
			var beforeWaistPkt = jQuery('input[name="coOptionGiletWashableInfo.wgWaistPkt"]:checked').val();
			jQuery('input[name="coOptionGiletWashableInfo.wgWaistPkt"]').val([ogGiletModelDefaultList[giletModel]["og_waistPkt"]]);
	
			// 腰ポケット形状
			var beforeWaistPktSpec = jQuery('input[name="coOptionGiletWashableInfo.wgWaistPktSpec"]:checked').val();
			jQuery('input[name="coOptionGiletWashableInfo.wgWaistPktSpec"]').val([ogGiletModelDefaultList[giletModel]["og_waistPktSpec"]]);
	
			if(itemCode == "04"){
				// ステッチ種類
				var beforeStitch = jQuery('input[name="coOptionGiletWashableInfo.wgStitch"]:checked').val();
				jQuery('input[name="coOptionGiletWashableInfo.wgStitch"]').val([ogGiletModelDefaultList[giletModel]["wg_stitch"]]);
			}
			
			// ステッチ箇所変更
			if (ogStitchModifyList[giletModel]) {
				// 定義がある場合、モデルに基づくチェック状態にする
				jQuery('input[id^="wg_stitchModifyPlace_id"]').val(ogStitchModifyList[giletModel]);
				jQuery('input[id^="wg_dStitchModifyPlace_id"]').val(ogStitchModifyList[giletModel]);
			} else {
				// 想定外のGiletモデルの場合はすべて変更不可＆チェックなし
				jQuery('input[id^="wg_stitchModifyPlace_id"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				});
			}
	
			// バックベルト
			var beforeBackBelt = jQuery('#wg_backBelt').val();
			jQuery('#wg_backBelt').val(ogGiletModelDefaultList[giletModel]["og_backBelt"]);
	
			ctrlWgStitchModify();
			ctrlWgDStitchModify();
			ctrlWgDStitchModifyPlace();
			ctrlWgAmfColor();
			
			// ボタンホール色指定箇所の有効/無効を制御
			ctrlWgBhColorPlace();
			// ボタン付け糸指定箇所の有効/無効を制御
			ctrlWgByColorPlace();
	
			
			//ステッチ箇所変更
			jQuery('#wg_stitchModify_id1').prop("checked", true);
 			jQuery('input[name="coOptionGiletWashableInfo.wgStitchModify"]:checked').change();
			
			//ダブルステッチ変更
 			jQuery('#wg_dStitchModify_id1').prop("checked", true);
 			jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]:checked').change();
			
			//AMF色指定
 			jQuery('#wg_amfColor_id1').prop("checked", true);
 			jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor"]:checked').change();
			
			//ボタンホール色指定
 			jQuery('#wg_bhColor_id1').prop("checked", true);
 			jQuery('input[name="coOptionGiletWashableInfo.wgBhColor"]:checked').change();
			
			//ボタン付け糸指定
 			jQuery('#wg_byColor_id1').prop("checked", true);
 			jQuery('input[name="coOptionGiletWashableInfo.wgByColor"]:checked').change();
	
			// 別モデルに変更された場合はアラート表示
 			if ((tmpWgGiletModel != '' || tmpWgGiletModel !=null) && giletModel != tmpWgGiletModel  && modelFlag == 2) {
			    setAlert('wg_giletModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
			}
			// 一時保存のモデルを更新
			tmpWgGiletModel = giletModel;
		}
		
		// 選択中のAMFステッチ
		var stitchValue = jQuery('input[name="coOptionGiletWashableInfo.wgStitch"]:checked').val();
		var dStitchModifyValue = jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]:checked').val();
		var amfColorValue = jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor"]:checked').val();
		//AMFステッチ(ステッチ種類):0005102
		if (stitchValue != '0005101') {
			if(stitchValue == "0005102"){
				jQuery('input[id="wg_dStitchModify_id2"]').prop("disabled", false);
				jQuery('input[id="wg_amfColor_id2"]').prop("disabled", false);
			}else{
				jQuery('input[id="wg_dStitchModify_id2"]').prop("disabled", true);
				jQuery('input[id="wg_dStitchModify_id1"]').prop("checked", true);
				if(dStitchModifyValue != "0002601"){
					jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]:checked').change();
				}
				if(stitchValue == "0005104"){
					jQuery('input[id="wg_amfColor_id2"]').prop("disabled", true);
					jQuery('input[id="wg_amfColor_id1"]').prop("checked", true);
					if(amfColorValue != "0000801"){
						jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor"]:checked').change();
					}
				}
			}
		} else {
			jQuery('input[id="wg_dStitchModify_id2"]').prop("disabled", true);
			jQuery('input[id="wg_dStitchModify_id1"]').prop("checked", true);
			if(dStitchModifyValue != "0002601"){
				jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]:checked').change();
			}
			jQuery('input[id="wg_amfColor_id2"]').prop("disabled", true);
			jQuery('input[id="wg_amfColor_id1"]').prop("checked", true);
			if(amfColorValue != "0000801"){
				jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor"]:checked').change();
			}
		}
		
	});
	
	// 胸ポケット
	jQuery('input[id^="wg_breastPkt_id"]').each(function() {
		jQuery(this).change(function(){
			// ダブルステッチ変更箇所の有効/無効
			// 選択中のステッチ箇所変更
			var wgStitchModifyValue = jQuery('input[name="coOptionGiletWashableInfo.wgStitchModify"]:checked').val();
			// 選択中の胸ポケットを取得
			var wgBreastPktValue = jQuery('input[name="coOptionGiletWashableInfo.wgBreastPkt"]:checked').val();
			
			if (wgStitchModifyValue == '0000602') {
				//ステッチ箇所変更は有りです
				jQuery('input[id^="wg_stitchModifyPlace_id"]').each(function() {
					if(jQuery(this).attr("id") == "wg_stitchModifyPlace_id2"){
						//胸ポケットは無し:0000101
						if(wgBreastPktValue == "0000101"){
							jQuery(this).prop("disabled", true);
							jQuery(this).prop("checked", false);
						}else{
							jQuery(this).prop("disabled", false);
						}
					}
				});
			}
			
			// ダブルステッチの有効/無効設定
			jQuery('input[id^="wg_dStitchModifyPlace_id"]').each(function() {
				var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("wg_dS","wg_s");
				var twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
				
				if (jQuery(this).val() == "0002702"){
					//ダブルステッチが「胸ポケット」:0002702
					if(wgStitchModifyValue == "0000602"){
						//ステッチ箇所変更が「無し」:0000601  「有り」:0000602
						if((wgBreastPktValue == "0000102" || wgBreastPktValue == "0000103") && twoStichModifyPlaceChecked){
							//胸ポケットが「無し」:0000101  「上前」:0000102  「両前」:0000103
							jQuery(this).prop("disabled", false);
						}else{
							jQuery(this).prop("disabled", true);
							jQuery(this).prop("checked", false);
						}
					}else{
						if(wgBreastPktValue == "0000102" || wgBreastPktValue == "0000103"){
							jQuery(this).prop("disabled", false);
						}else{
							jQuery(this).prop("disabled", true);
							jQuery(this).prop("checked", false);
						}
					}
				}
			});
			
		});
	});
	
	var item = jQuery("#item").val();
	if(item == "01"){
		jQuery('input[name="coOptionGiletWashableInfo.wgStitch"]').prop("disabled",true);
	}else{
		jQuery('input[name="coOptionGiletWashableInfo.wgStitch"]').prop("disabled",false);
	}
	
	// 選択中の腰ポケット
	var waistPkt = jQuery('input[name="coOptionGiletWashableInfo.wgWaistPkt"]:checked').val();
	if (waistPkt == "0000201") {
		// 腰ポケットが有りの場合は腰ポケット形状を表示する
		jQuery('#wg_waistPkt_yes_area').show();
	} else {
		// 腰ポケットが有りの場合は腰ポケット形状を非表示にする
		jQuery('#wg_waistPkt_yes_area').hide();
	}

	// 腰ポケット
	jQuery('input[name="coOptionGiletWashableInfo.wgWaistPkt"]').each(function() {
		jQuery(this).change(function(){
			// 選択中の腰ポケット
			var waistPkt = jQuery('input[name="coOptionGiletWashableInfo.wgWaistPkt"]:checked').val();
			if (waistPkt == "0000201") {
				// 腰ポケットが有りの場合は腰ポケット形状を表示する
				jQuery('#wg_waistPkt_yes_area').show();
			} else {
				// 腰ポケットが有りの場合は腰ポケット形状を非表示にする
				jQuery('#wg_waistPkt_yes_area').hide();
			}
			
			// 選択中のステッチ箇所変更
			var wgStitchModifyValue = jQuery('input[name="coOptionGiletWashableInfo.wgStitchModify"]:checked').val();
			// 選択中の腰ポケットを取得
			var wgWaistPktValue = jQuery('input[name="coOptionGiletWashableInfo.wgWaistPkt"]:checked').val();

			if (wgStitchModifyValue == '0000602') {
				//ステッチ箇所変更は有りです
				jQuery('input[id^="wg_stitchModifyPlace_id"]').each(function() {
					if(jQuery(this).attr("id") == "wg_stitchModifyPlace_id3"){
						//腰ポケットは無し:0000202
						if(wgWaistPktValue == "0000202"){
							jQuery(this).prop("disabled", true);
							jQuery(this).prop("checked", false);
						}else{
							jQuery(this).prop("disabled", false);
						}
					}
				});
			}
			
			// ダブルステッチの有効/無効設定
			jQuery('input[id^="wg_dStitchModifyPlace_id"]').each(function() {
				var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("wg_dS","wg_s");
				var twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
				
				if (jQuery(this).val() == "0002703"){
					//ダブルステッチが「腰ポケット」:0002703
					if(wgStitchModifyValue == "0000602"){
						//ステッチ箇所変更が「無し」:0000601  「有り」:0000602
						if(wgWaistPktValue == "0000201" && twoStichModifyPlaceChecked){
							//胸ポケットが「有り」:0000201  「無し」:0000202
							jQuery(this).prop("disabled", false);
						}else{
							jQuery(this).prop("disabled", true);
							jQuery(this).prop("checked", false);
						}
					}else{
						if(wgWaistPktValue == "0000201"){
							//胸ポケットが「有り」:0000201  「無し」:0000202
							jQuery(this).prop("disabled", false);
						}else{
							jQuery(this).prop("disabled", true);
							jQuery(this).prop("checked", false);
						}
					}
				}
			});
			
		});
	});

	// ステッチ種類
	jQuery('input[name="coOptionGiletWashableInfo.wgStitch"]').each(function() {
		jQuery(this).change(function(){
			changeWgStitch();
		});
	});
	changeWgStitch();

	// ステッチ箇所変更
	jQuery('input[name="coOptionGiletWashableInfo.wgStitchModify"]').each(function() {
		jQuery(this).change(function(){
			ctrlWgStitchModify();
		});
	});
	ctrlWgStitchModify();

	// ステッチ箇所(選択肢)
	jQuery('input[id^="wg_stitchModifyPlace_id"]').each(function() {
		jQuery(this).change(function(){
			ctrlWgDStitchModifyPlace();
			ctrlWgAmfColor();
		});
	});

	// ダブルステッチ
	jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]').each(function() {
		jQuery(this).change(function(){
			ctrlWgDStitchModify();
			ctrlWgDStitchModifyPlace();
		});
	});
	ctrlWgDStitchModify();
	ctrlWgDStitchModifyPlace();

	// AMF色指定(有り/無し)
	jQuery('input[id^="wg_amfColor_"]').each(function() {
		jQuery(this).change(function(){
			ctrlWgAmfColor();
		});
	});
	ctrlWgAmfColor();

	// AMF色指定(全選択)
	jQuery('#btn_as_wg_amfColorPlace').click(function(){ 
		// 全選択する色を取得 
		var allColor = jQuery('#wg_amfColorPlaceAll').val(); 
	
		jQuery('#wg_amfColor_div input[type="checkBox"]').each(function(index, elemCheckBox){ 
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
	jQuery('input[id^="wg_amfColorPlace_"]').each(function() { 
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
	
	// 選択中のボタンホール色指定を取得
	var bhColor = jQuery('input[name="coOptionGiletWashableInfo.wgBhColor"]:checked').val();

	if (bhColor == '0001101') {
		// 無しの場合は操作不可
		jQuery('input[id^="wg_bhColorPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
			jQuery('#'+this.id+'_div').hide();
		});
		jQuery('#wg_bhColorPlaceAll').prop("disabled", true);
		jQuery('#btn_as_wg_bhColorPlace').prop("disabled", true);

		// 無しの場合は2階層目を表示しない
		jQuery('#wg_bhColor_div').hide();
	} else {
		// 有りの場合は操作可能
		ctrlWgBhColorPlace();
		jQuery('input[id^="wg_bhColorPlace_"]').each(function() {
//			jQuery(this).prop("disabled", false);
			if (jQuery(this).prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+this.id+'_div').show();
			}
		});
		jQuery('#wg_bhColorPlaceAll').prop("disabled", false);
		jQuery('#btn_as_wg_bhColorPlace').prop("disabled", false);

		// 有りの場合は2階層目を表示
		jQuery('#wg_bhColor_div').show();
	}
	
	// ボタンホール色指定(有り/無し)
	jQuery('input[name="coOptionGiletWashableInfo.wgBhColor"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var bhColor = jQuery('input[name="coOptionGiletWashableInfo.wgBhColor"]:checked').val();

			if (bhColor == '0001101') {
				// 無しの場合は操作不可
				jQuery('input[id^="wg_bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#wg_bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_wg_bhColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#wg_bhColor_div').hide();
			} else {
				// 有りの場合は操作可能
				ctrlWgBhColorPlace();
				jQuery('input[id^="wg_bhColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#wg_bhColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_wg_bhColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#wg_bhColor_div').show();
			}
		});
	});
	jQuery('#wg_bhColor_id1').change();

	// ボタンホール色指定(全選択)
	jQuery('#btn_as_wg_bhColorPlace').click(function(){ 
		// 全選択する色を取得 
		var allColor = jQuery('#wg_bhColorPlaceAll').val(); 
	
		jQuery('#wg_bhColor_div input[type="checkBox"]').each(function(index, elemCheckBox){ 
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
	jQuery('input[id^="wg_bhColorPlace_"]').each(function() { 
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
	ctrlWgBhColorPlace();

	// 選択中のボタンホール色指定を取得
	var byColor = jQuery('input[name="coOptionGiletWashableInfo.wgByColor"]:checked').val();

	if (byColor == '0001401') {
		// 無しの場合は操作不可
		jQuery('input[id^="wg_byColorPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
			jQuery('#'+this.id+'_div').hide();
		});
		jQuery('#wg_byColorPlaceAll').prop("disabled", true);
		jQuery('#btn_as_wg_byColorPlace').prop("disabled", true);

		// 無しの場合は2階層目を表示しない
		jQuery('#wg_byColor_div').hide();
	} else {
		// ボタン付け糸指定箇所の有効/無効を制御
		ctrlWgByColorPlace();

		jQuery('input[id^="wg_byColorPlace_"]').each(function() {
			if (jQuery(this).prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+this.id+'_div').show();
			}
		});
		jQuery('#wg_byColorPlaceAll').prop("disabled", false);
		jQuery('#btn_as_wg_byColorPlace').prop("disabled", false);

		// 有りの場合は2階層目を表示
		jQuery('#wg_byColor_div').show();
	}
	
	// ボタン付け糸指定(有り/無し)
	jQuery('input[name="coOptionGiletWashableInfo.wgByColor"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var byColor = jQuery('input[name="coOptionGiletWashableInfo.wgByColor"]:checked').val();

			if (byColor == '0001401') {
				// 無しの場合は操作不可
				jQuery('input[id^="wg_byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#wg_byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_wg_byColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#wg_byColor_div').hide();
			} else {
				// ボタン付け糸指定箇所の有効/無効を制御
				ctrlWgByColorPlace();

				jQuery('input[id^="wg_byColorPlace_"]').each(function() {
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#wg_byColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_wg_byColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#wg_byColor_div').show();
			}
		});
	});
	jQuery('#wg_byColor_id1').change();

	// ボタン付け糸指定(全選択)
	jQuery('#btn_as_wg_byColorPlace').click(function(){ 
		// 全選択する色を取得 
		var allColor = jQuery('#wg_byColorPlaceAll').val(); 
	
		jQuery('#wg_byColor_div input[type="checkBox"]').each(function(index, elemCheckBox){ 
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
	jQuery('input[id^="wg_byColorPlace_"]').each(function() { 
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
	
	// ボタン付け糸指定箇所の有効/無効を制御
	ctrlWgByColorPlace();

//	// 背裏地素材
//	jQuery('#wg_backLiningMate').change(function (){
//		var bodyBackMate = jQuery('#wg_backLiningMate').val();
//
//		// 背裏地品番
//		var bodyBackMateStkNoElem = jQuery('#wg_backLiningMateStkNo');
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
//			jQuery('#btn_wg_insideLiningMate').prop("disabled", false);
//		} else if (bodyBackMate == "1000400") {
//			// 表地仕様の場合は品番選択不可
//			bodyBackMateStkNoElem.prop("disabled", true);
//			jQuery('#btn_wg_insideLiningMate').prop("disabled", true);
//		}
//
//		// バックベルト
//		var backBeltElem = jQuery('#wg_backBelt');
//		var selectedBackBelt = backBeltElem.val();
//
//		// 選択肢をクリア
//		backBeltElem.empty();
//
//		if (bodyBackMate == "1000400") {
//			// 背裏素材「表地」選択時、バックベルトは「無し」か「537-5K」のみ
//			backBeltElem.append(jQuery('<option />').val("0002302").text("546-20（尾錠型）"));
////			backBeltElem.append(jQuery('<option />').val("0002301").text("537-5K（2×1型）"));
//			backBeltElem.append(jQuery('<option />').val("0002303").text("無し"));
//
//			if (selectedBackBelt == "0002301") {
//				backBeltElem.val("0002302");
//				jQuery('#wg_backBelt').change();
//			} else {
//				backBeltElem.val(selectedBackBelt);
//			}
//		} else {
//			backBeltElem.append(jQuery('<option />').val("0002302").text("546-20（尾錠型）"));
//			backBeltElem.append(jQuery('<option />').val("0002301").text("537-5K（2×1型）"));
//			backBeltElem.append(jQuery('<option />').val("0002303").text("無し"));
//			backBeltElem.val(selectedBackBelt);
//		}
//	
//	});
//	jQuery('#wg_backLiningMate').change();

//	// 内側裏地素材
//	jQuery('#wg_insideLiningMate').change(function (){
//		var bodyBackMate = jQuery('#wg_insideLiningMate').val();
//
//		// 内側裏地品番
//		var bodyBackMateStkNoElem = jQuery('#wg_insideLiningMateStkNo');
//
//		// 選択肢をクリア
//		bodyBackMateStkNoElem.empty();
//
//		if (bodyBackMateStkNoList[bodyBackMate]) {
//			// 定義が存在する場合は品番を選択肢にセット
//			for (var i = 0; i < bodyBackMateStkNoList[bodyBackMate].length; i++) {
//				bodyBackMateStkNoElem.append(jQuery('<option />').val(bodyBackMateStkNoList[bodyBackMate][i]).text(bodyBackMateStkNoList[bodyBackMate][i]));
//			}
//		}
//	});
//	jQuery('#wg_insideLiningMate').change();
//
//	// 内側裏地素材（背裏地と同じ）
//	jQuery('#btn_wg_insideLiningMate').click(function() {
//		// 背裏地素材
//		var backLiningMate = jQuery('#wg_backLiningMate').val();
//		// 背裏地品番
//		var backLiningMateStkNo = jQuery('#wg_backLiningMateStkNo').val();
//
//		// 背裏地素材への反映
//		jQuery('#wg_insideLiningMate').val(backLiningMate);
//		jQuery('#wg_insideLiningMate').change();
//		jQuery('#wg_insideLiningMateStkNo').val(backLiningMateStkNo);
//	});

//	// フロント釦
//	jQuery('#wg_frontBtnMate').change(function (){
//		var btnMate = jQuery('#wg_frontBtnMate').val();
//
//		// フロント釦品番
//		var btnMateStkNoElem = jQuery('#wg_frontBtnMateStkNo');
//
//		// 選択肢をクリア
//		btnMateStkNoElem.empty();
//
//		// 定義が存在する場合は品番を選択肢にセット
//	});
//	jQuery('#wg_frontBtnMate').change();

}

function myGiletWashableMethod(){
	var wg_giletModel = jQuery("#wg_giletModel option:selected").val();
	
	//GILETモデルが空の場合,ステッチ箇所変更,ダブルステッチ,AMF色指定,ボタンホール色指定,ボタン付け糸指定を空にします
	if(wg_giletModel == '' || wg_giletModel == null){
		//ステッチ箇所変更
		jQuery('input[id^="wg_stitchModifyPlace_id"]').each(function() {
			jQuery(this).removeAttr("checked");
			jQuery(this).prop("disabled", true);
		});
		//ダブルステッチ
		jQuery('input[id^="wg_dStitchModifyPlace_id"]').each(function() {
			jQuery(this).removeAttr("checked");
			jQuery(this).prop("disabled", true);
		});
		//AMF色指定
		jQuery('input[id^="wg_amfColorPlace_"]').each(function() {
			jQuery(this).removeAttr("checked");
			jQuery(this).prop("disabled", true);
		});
		jQuery('input[id^="wg_amfColor_"]').each(function() {
			var ogAmfColorId = jQuery(this).val();
			if(ogAmfColorId != "0000801" && ogAmfColorId != "0000802"){
				jQuery(this).removeAttr("checked");
			}
		});
		//ボタンホール色指定
		jQuery('input[id^="wg_bhColorPlace_"]').each(function() {
			jQuery(this).removeAttr("checked");
			jQuery(this).prop("disabled", true);
			jQuery('#' + this.id + "_div").hide();
		});
		jQuery('input[id^="wg_bhColor_"]').each(function() {
			var ogBhColorId = jQuery(this).val();
			if(ogBhColorId != "0001101" && ogBhColorId != "0001102"){
				jQuery(this).removeAttr("checked");
			}
		});
		//ボタン付け糸指定
		jQuery('input[id^="wg_byColorPlace_"]').each(function() {
			jQuery(this).removeAttr("checked");
			jQuery(this).prop("disabled", true);
			jQuery('#' + this.id + "_div").hide();
		});
		jQuery('input[id^="wg_byColor_"]').each(function() {
			var ogByColorId = jQuery(this).val();
			if(ogByColorId != "0001401" && ogByColorId != "0001402"){
				jQuery(this).removeAttr("checked");
			}
		});
	}
}

//ステッチ種類は変更時
function changeWgStitch() {
	// 選択中のAMFステッチ
	var stitchValue = jQuery('input[name="coOptionGiletWashableInfo.wgStitch"]:checked').val();
	var dStitchModifyValue = jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]:checked').val();
	var amfColorValue = jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor"]:checked').val();
	//無し:0005101
	if (stitchValue != "0005101") {
		// 有りの場合、関連する項目を有効化
		// ステッチ箇所変更
		jQuery('input[name="coOptionGiletWashableInfo.wgStitchModify"]').prop("disabled", false);
		// ダブルステッチ変更
		jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]').prop("disabled", false);
		// AMF色指定
		jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor"]').prop("disabled", false);

		// ステッチ関連の項目を表示
		jQuery('#wg_stitch_yes_area').show();
	} else {
		// 無しの場合、関連する項目を無効化・値変更
		// ステッチ箇所変更
		jQuery('#wg_stitchModify_id1').prop("checked", true);
		jQuery('#wg_stitchModify_id1').change();
		// ダブルステッチ変更
		jQuery('#wg_dStitchModify_id1').prop("checked", true);
		jQuery('#wg_dStitchModify_id1').change();
		// AMF色指定
		jQuery('#wg_amfColor_id1').prop("checked", true);
		jQuery('#wg_amfColor_id1').change();

		// ステッチ関連の項目を非表示
		jQuery('#wg_stitch_yes_area').hide();
	}

	//ステッチ種類が有りの場合はダブルステッチを有効化する
	//AMFステッチ(ステッチ種類):0005102
	if (stitchValue != '0005101') {
		if(stitchValue == "0005102"){
			jQuery('input[id="wg_dStitchModify_id2"]').prop("disabled", false);
			jQuery('input[id="wg_amfColor_id2"]').prop("disabled", false);
		}else{
			jQuery('input[id="wg_dStitchModify_id2"]').prop("disabled", true);
			jQuery('input[id="wg_dStitchModify_id1"]').prop("checked", true);
			if(dStitchModifyValue != "0002601"){
				jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]:checked').change();
			}
			if(stitchValue == "0005104"){
				jQuery('input[id="wg_amfColor_id2"]').prop("disabled", true);
				jQuery('input[id="wg_amfColor_id1"]').prop("checked", true);
				if(amfColorValue != "0000801"){
					jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor"]:checked').change();
				}
			}
		}
	} else {
		jQuery('input[id="wg_dStitchModify_id2"]').prop("disabled", true);
		jQuery('input[id="wg_dStitchModify_id1"]').prop("checked", true);
		if(dStitchModifyValue != "0002601"){
			jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]:checked').change();
		}
		jQuery('input[id="wg_amfColor_id2"]').prop("disabled", true);
		jQuery('input[id="wg_amfColor_id1"]').prop("checked", true);
		if(amfColorValue != "0000801"){
			jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor"]:checked').change();
		}
	}
}

//ステッチ箇所変更の有効/無効を制御する
function ctrlWgStitchModify() {
	// 選択中のステッチ箇所変更
	var wgStitchModifyValue = jQuery('input[name="coOptionGiletWashableInfo.wgStitchModify"]:checked').val();
	// 選択中の胸ポケットを取得
	var wgBreastPktValue = jQuery('input[name="coOptionGiletWashableInfo.wgBreastPkt"]:checked').val();
	// 選択中の腰ポケットを取得
	var wgWaistPktValue = jQuery('input[name="coOptionGiletWashableInfo.wgWaistPkt"]:checked').val();

	// ステッチ箇所変更の有無で下位階層の表示制御
	//無し:0000601 有り:0000602
	if (wgStitchModifyValue == '0000601') {
		jQuery('#wg_stitchModifyPlace').hide();
	} else if (wgStitchModifyValue == '0000602') {
		jQuery('#wg_stitchModifyPlace').show();
	}

	// 選択中のgiletモデルを取得
	var giletModel = jQuery('#wg_giletModel').val();

	if (!ogStitchModifyList[giletModel]) {
		jQuery('input[id^="wg_stitchModifyPlace_id"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		});
		return;
	}
	
	if(wgStitchModifyValue == '0000601'){
		//ステッチ箇所変更は無しです
		jQuery('input[id^="wg_stitchModifyPlace_id"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).removeAttr("checked");
		});
	}else if (wgStitchModifyValue == '0000602') {
		//ステッチ箇所変更は有りです
		//ラペル・フロントと胸ポケットと腰ポケット,デフォルト選択
		jQuery('input[id^="wg_stitchModifyPlace_id"]').each(function() {
			jQuery(this).prop("disabled", false);
			var wgStitchModifyTemp = false;
			for(var i=0; i<ogStitchModifyList[giletModel].length; i++){
				if(jQuery(this).val() == ogStitchModifyList[giletModel][i]){
					jQuery(this).prop("checked", true);
					wgStitchModifyTemp = true;
				}
			}
			if(wgStitchModifyTemp == false){
				jQuery(this).prop("checked", false);
			}
			
			if(jQuery(this).attr("id") == "wg_stitchModifyPlace_id2"){
				//胸ポケットは無し:0000101
				if(wgBreastPktValue == "0000101"){
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				}
			}else if(jQuery(this).attr("id") == "wg_stitchModifyPlace_id3"){
				//腰ポケットは無し:0000202
				if(wgWaistPktValue == "0000202"){
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				}
			}
		});
	}

	// 全選択・全解除ボタン
	//無し:0000601 有り:0000602
	if (wgStitchModifyValue == '0000601') {
		jQuery('#btn_as_wg_stitchModifyPlace').prop("disabled", true);
		jQuery('#btn_ar_wg_stitchModifyPlace').prop("disabled", true);
	} else if (wgStitchModifyValue == '0000602') {
		jQuery('#btn_as_wg_stitchModifyPlace').prop("disabled", false);
		jQuery('#btn_ar_wg_stitchModifyPlace').prop("disabled", false);
	}
	
	if(wgStitchModifyValue == "0000602"){
		jQuery('input[id^="wg_stitchModifyPlace_id"]').change();
	}
}

//ダブルステッチの有効/無効を制御する
function ctrlWgDStitchModify() {
	// 選択中のステッチ箇所変更
	var wgStitchModifyValue = jQuery('input[name="coOptionGiletWashableInfo.wgStitchModify"]:checked').val();
	// 選択中のステッチ箇所変更
	var wgDStitchModifyValue = jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]:checked').val();
	// 選択中の胸ポケットを取得
	var wgBreastPktValue = jQuery('input[name="coOptionGiletWashableInfo.wgBreastPkt"]:checked').val();
	// 選択中の腰ポケットを取得
	var wgWaistPktValue = jQuery('input[name="coOptionGiletWashableInfo.wgWaistPkt"]:checked').val();
	
	//無し:0002601 有り:0002602
	if(wgDStitchModifyValue == "0002601") {
		jQuery('#wg_dStitchModifyPlace').hide();
	}else if(wgDStitchModifyValue == "0002602") {
		jQuery('#wg_dStitchModifyPlace').show();
	}

	// 選択中のgiletモデルを取得
	var giletModel = jQuery('#wg_giletModel').val();
	
	if (!ogDStitchModifyList[giletModel]) {
		// Jacketモデルとラペルデザインの組み合わせが定義にない場合はすべて変更不可
		jQuery('input[id^="wg_dStitchModifyPlace_id"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		});
		return;
	}
	
	if(wgDStitchModifyValue == '0002601'){
		//ダブルステッチは無しです
		jQuery('input[id^="wg_dStitchModifyPlace_id"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).removeAttr("checked");
		});
	}else if (wgDStitchModifyValue == '0002602') {
		//ダブルステッチは有りです
		//ラペル・フロントと胸ポケットと腰ポケット,デフォルト選択
		jQuery('input[id^="wg_dStitchModifyPlace_id"]').each(function() {
			jQuery(this).prop("disabled", false);
			var wgDStitchModifyTemp = false;
			for(var i=0; i<ogDStitchModifyList[giletModel].length; i++){
				if(jQuery(this).val() == ogDStitchModifyList[giletModel][i]){
					jQuery(this).prop("checked", true);
					wgDStitchModifyTemp = true;
				}
			}
			if(wgDStitchModifyTemp == false){
				jQuery(this).prop("checked", false);
			}
		});
	}

	// ダブルステッチの有効/無効設定
	jQuery('input[id^="wg_dStitchModifyPlace_id"]').each(function() {
		var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("wg_dS","wg_s");
		var twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
		
		if (jQuery(this).val() == "0002702"){
			//ダブルステッチが「胸ポケット」:0002702
			if(wgStitchModifyValue == "0000602"){
				//ステッチ箇所変更が「無し」:0000601  「有り」:0000602
				if((wgBreastPktValue == "0000102" || wgBreastPktValue == "0000103") && twoStichModifyPlaceChecked){
					//胸ポケットが「無し」:0000101  「上前」:0000102  「両前」:0000103
					jQuery(this).prop("disabled", false);
				}else{
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				}
			}else{
				if(wgBreastPktValue == "0000102" || wgBreastPktValue == "0000103"){
					jQuery(this).prop("disabled", false);
				}else{
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				}
			}
		}else if (jQuery(this).val() == "0002703"){
			//ダブルステッチが「腰ポケット」:0002703
			if(wgStitchModifyValue == "0000602"){
				//ステッチ箇所変更が「無し」:0000601  「有り」:0000602
				if(wgWaistPktValue == "0000201" && twoStichModifyPlaceChecked){
					//胸ポケットが「有り」:0000201  「無し」:0000202
					jQuery(this).prop("disabled", false);
				}else{
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				}
			}else{
				if(wgWaistPktValue == "0000201"){
					//胸ポケットが「有り」:0000201  「無し」:0000202
					jQuery(this).prop("disabled", false);
				}else{
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				}
			}
		}else{
		}
		
	});
}

//ダブルステッチ(選択肢)の有効/無効を制御する
function ctrlWgDStitchModifyPlace() {
	// 選択中のgiletモデルを取得
	var giletModel = jQuery('#wg_giletModel').val();
	if (isEmpty(giletModel)) {
		// 未選択時は何もしない
		return;
	}
	
	// 選択中のステッチ箇所変更
	var wgStitchModifyValue = jQuery('input[name="coOptionGiletWashableInfo.wgStitchModify"]:checked').val();
	// 選択中のダブルステッチ
	var wgDStitchModifyValue = jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]:checked').val();
	
	if(wgStitchModifyValue == "0000602"){
		var twoStichModifyPlaceChecked = false;
		var twoDStitchModifyPlace = null;

		jQuery('input[id^="wg_dStitchModifyPlace_id"]').each(function(){
			var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("wg_dS","wg_s");
			// ステッチ箇所変更要素取得
			twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
			// ダブルステッチ要素取得
			twoDStitchModifyPlace = jQuery(this);
			
			if (wgDStitchModifyValue == '0002602' && twoStichModifyPlaceChecked) {
				twoDStitchModifyPlace.prop("disabled", false);
				if(twoDStitchModifyPlace.attr("id") == "wg_dStitchModifyPlace_id2"){
					//選択中の胸ポケットを取得
					var twoBreastPkt = jQuery('input[name="coOptionGiletWashableInfo.wgBreastPkt"]:checked').val();
					//胸ポケットは無し:0000101
					if(twoBreastPkt == "0000101"){
						twoDStitchModifyPlace.prop("disabled", true);
						twoDStitchModifyPlace.prop("checked", false);
					}
				}else if(twoDStitchModifyPlace.attr("id") == "wg_dStitchModifyPlace_id3"){
					//選択中の腰ポケットを取得
					var twoWaistPkt = jQuery('input[name="coOptionGiletWashableInfo.wgWaistPkt"]:checked').val();
					//腰ポケットは無し:0000202
					if(twoWaistPkt == "0000202"){
						twoDStitchModifyPlace.prop("disabled", true);
						twoDStitchModifyPlace.prop("checked", false);
					}
				}else{
					// 有り且つステッチ箇所変更の同項目が有効の場合、ダブルステッチも有効にする
					twoDStitchModifyPlace.prop("disabled", false);
				}
			} else {
				// 上記以外の場合、無効にする
				twoDStitchModifyPlace.prop("disabled", true);
				twoDStitchModifyPlace.prop("checked", false);
			}
		});
		
	}else if(wgStitchModifyValue == "0000601"){
		var twoDStitchModifyPlace = null;

		jQuery('input[id^="wg_dStitchModifyPlace_id"]').each(function(){
			// ダブルステッチ要素取得
			twoDStitchModifyPlace = jQuery(this);
			
			if (wgDStitchModifyValue == '0002602') {
				twoDStitchModifyPlace.prop("disabled", false);
				if(twoDStitchModifyPlace.attr("id") == "wg_dStitchModifyPlace_id2"){
					//選択中の胸ポケットを取得
					var twoBreastPkt = jQuery('input[name="coOptionGiletWashableInfo.wgBreastPkt"]:checked').val();
					//胸ポケットは無し:0000101
					if(twoBreastPkt == "0000101"){
						twoDStitchModifyPlace.prop("disabled", true);
						twoDStitchModifyPlace.prop("checked", false);
					}
				}else if(twoDStitchModifyPlace.attr("id") == "wg_dStitchModifyPlace_id3"){
					//選択中の腰ポケットを取得
					var twoWaistPkt = jQuery('input[name="coOptionGiletWashableInfo.wgWaistPkt"]:checked').val();
					//腰ポケットは無し:0000202
					if(twoWaistPkt == "0000202"){
						twoDStitchModifyPlace.prop("disabled", true);
						twoDStitchModifyPlace.prop("checked", false);
					}
				}else{
					// 有り且つステッチ箇所変更の同項目が有効の場合、ダブルステッチも有効にする
					var wgDStitchModifyTemp = false;
					for(var i=0; i<ogDStitchModifyList[giletModel].length; i++){
						if(jQuery(this).val() == ogDStitchModifyList[giletModel][i]){
							twoDStitchModifyPlace.prop("disabled", false);
							wgDStitchModifyTemp = true;
						}
					}
					if(wgDStitchModifyTemp == false){
						twoDStitchModifyPlace.prop("disabled", true);
					}
				}
			} else {
				// 上記以外の場合、無効にする
				twoDStitchModifyPlace.prop("disabled", true);
				twoDStitchModifyPlace.prop("checked", false);
			}
		});
	}
	
}

//--------------------------------------------
// 部品
//--------------------------------------------
//ボタンホール色指定箇所の有効/無効を制御する
function ctrlWgBhColorPlace() {

	// 選択中のボタンホール色指定
	var bhColor = jQuery('input[name="coOptionGiletWashableInfo.wgBhColor"]:checked').val();

	// 選択中のGILETモデル
	var giletModel = jQuery('#wg_giletModel').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#wg_bhColor_div input[type="checkbox"]').each(function(index, elem){
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

// ボタン付け糸指定箇所の有効/無効を制御する
function ctrlWgByColorPlace() {

	// 選択中のボタン付け糸指定
	var byColor = jQuery('input[name="coOptionGiletWashableInfo.wgByColor"]:checked').val();

	// 選択中のGILETモデル
	var giletModel = jQuery('#wg_giletModel').val();

	// ボタン付け糸指定箇所の有効/無効を制御
	jQuery('#wg_byColor_div input[type="checkbox"]').each(function(index, elem){
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

	//AMF色指定の有効/無効を制御する
function ctrlWgAmfColor() {
	var stitchModifyValue = jQuery('input[name="coOptionGiletWashableInfo.wgStitchModify"]:checked').val();
	var amfColorValue = jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor"]:checked').val();
	
	if (amfColorValue == "0000802") {
		jQuery('#wg_amfColor_div').show();
	} else {
		jQuery('#wg_amfColor_div').hide();
	}
	
	// AMF色指定の有無で下位階層の表示制御
	//有り:0000802
	if (amfColorValue == '0000802') {
		jQuery('#wg_amfColor_div').show();
		jQuery('#wg_amfColorPlaceAll').prop("disabled", false);
		jQuery('#btn_as_wg_amfColorPlace').prop("disabled", false);
	} else {
		jQuery('#wg_amfColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.prop("checked")) {
				elem.removeAttr("checked");
			}
		});
		jQuery('#wg_amfColor_div input[type="checkbox"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.prop("checked")) {
				elem.removeAttr("checked");
			}
		});
		jQuery('#wg_amfColor_div').hide();
		jQuery('#wg_amfColorPlaceAll').prop("disabled", true);
		jQuery('#btn_as_wg_amfColorPlace').prop("disabled", true);
	}

	// 選択中のgiletモデルを取得
	var giletModel = jQuery('#wg_giletModel').val();

	if (!ogAmfColorList[giletModel]) {
		// Jacketモデルとラペルデザインの組み合わせが定義にない場合はすべて変更不可
		jQuery('input[id^="wg_amfColorPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		});
		return;
	}
	if(stitchModifyValue == "0000602"){
		var twoStichModifyPlaceChecked = false;
		var twoAmfColorPlace = null;

		jQuery('input[id^="wg_amfColorPlace_"]').each(function(){
			var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("wg_amfColorPlace_","wg_stitchModifyPlace_id");
			// ステッチ箇所変更要素取得
			twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
			// ダブルステッチ要素取得
			twoAmfColorPlace = jQuery(this);
			stitchModifyValue
			if (amfColorValue == '0000802' && twoStichModifyPlaceChecked) {
				twoAmfColorPlace.prop("disabled", false);
				if(twoAmfColorPlace.attr("id") == "wg_amfColorPlace_2"){
					//選択中の胸ポケットを取得
					var twoBreastPkt = jQuery('input[name="coOptionGiletWashableInfo.wgBreastPkt"]:checked').val();
					//胸ポケットは無し:0000101
					if(twoBreastPkt == "0000101"){
						twoAmfColorPlace.prop("disabled", true);
						twoAmfColorPlace.prop("checked", false);
					}
				}else if(twoAmfColorPlace.attr("id") == "wg_amfColorPlace_3"){
					//選択中の腰ポケットを取得
					var twoWaistPkt = jQuery('input[name="coOptionGiletWashableInfo.wgWaistPkt"]:checked').val();
					//腰ポケットは無し:0000202
					if(twoWaistPkt == "0000202"){
						twoAmfColorPlace.prop("disabled", true);
						twoAmfColorPlace.prop("checked", false);
					}
				}else{
					// 有り且つステッチ箇所変更の同項目が有効の場合、ダブルステッチも有効にする
					twoAmfColorPlace.prop("disabled", false);
				}
			} else {
				// 上記以外の場合、無効にする
				twoAmfColorPlace.prop("disabled", true);
				twoAmfColorPlace.prop("checked", false);
			}
			
			// 要素のID取得
			twoAmfColorPlaceId = twoAmfColorPlace.attr("id");
			if (twoAmfColorPlace.prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+twoAmfColorPlaceId+'_div').show();
			} else {
				jQuery('#'+twoAmfColorPlaceId+'_div').hide();
			}
			
		});
		
	}else if(stitchModifyValue == "0000601"){
		var twoAmfColorPlace = null;

		jQuery('input[id^="wg_amfColorPlace_"]').each(function(){
			// ダブルステッチ要素取得
			twoAmfColorPlace = jQuery(this);
			
			if (amfColorValue == '0000802') {
				twoAmfColorPlace.prop("disabled", false);
				if(twoAmfColorPlace.attr("id") == "wg_amfColorPlace_2"){
					//選択中の胸ポケットを取得
					var twoBreastPkt = jQuery('input[name="coOptionGiletWashableInfo.wgBreastPkt"]:checked').val();
					//胸ポケットは無し:0000101
					if(twoBreastPkt == "0000101"){
						twoAmfColorPlace.prop("disabled", true);
						twoAmfColorPlace.prop("checked", false);
					}
				}else if(twoAmfColorPlace.attr("id") == "wg_amfColorPlace_3"){
					//選択中の腰ポケットを取得
					var twoWaistPkt = jQuery('input[name="coOptionGiletWashableInfo.wgWaistPkt"]:checked').val();
					//腰ポケットは無し:0000202
					if(twoWaistPkt == "0000202"){
						twoAmfColorPlace.prop("disabled", true);
						twoAmfColorPlace.prop("checked", false);
					}
				}else{
					// 有り且つステッチ箇所変更の同項目が有効の場合、ダブルステッチも有効にする
					var wgAmfColorTemp = false;
					for(var i=0; i<ogAmfColorList[giletModel].length; i++){
						if(jQuery(this).val() == ogAmfColorList[giletModel][i]){
							twoAmfColorPlace.prop("disabled", false);
							wgAmfColorTemp = true;
						}
					}
					if(wgAmfColorTemp == false){
						twoAmfColorPlace.prop("disabled", true);
					}
				}
			} else {
				// 上記以外の場合、無効にする
				twoAmfColorPlace.prop("disabled", true);
				twoAmfColorPlace.prop("checked", false);
			}
			
			// 要素のID取得
			twoAmfColorPlaceId = twoAmfColorPlace.attr("id");

			if (twoAmfColorPlace.prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+twoAmfColorPlaceId+'_div').show();
			} else {
				jQuery('#'+twoAmfColorPlaceId+'_div').hide();
			}
			
		});
	}
	
}

function modelCheck(modelCode,productFabricNo,orderPattern,itemCode,subItemCode){
	var checkResult = jQuery.ajax({url:contextPath + "/orderCo/checkModel",data:{"modelCode":modelCode,"productFabricNo":productFabricNo,"orderPattern":orderPattern,"itemCode":itemCode,"subItemCode":subItemCode},async:false});
	checkResult = checkResult.responseText;
	return checkResult;
}