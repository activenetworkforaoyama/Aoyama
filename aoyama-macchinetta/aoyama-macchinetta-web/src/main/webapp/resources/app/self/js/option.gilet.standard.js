/*********************************************
 * 標準GILET用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionGiletStandard() {

	jQuery('#giletModel').attr("oldGlModel",jQuery('#giletModel').val());
	// GILETモデル
	jQuery('#giletModel').change(function(){
		var giletModel = jQuery(this).val();
		var giletOldModel = jQuery('#giletModel').attr("oldGlModel");
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
		jQuery('#giletModel').attr("oldGlModel",jQuery('#giletModel').val());
		var giletFlag = jQuery('#giletFlag').val();
		if (giletFlag == "0") {
			// 選択されたGiletモデルを取得
			if (giletModel == '') {
				// 未選択時は何もしない
				return;
			}
			
			//モデルを選択すると、"ステッチ箇所変更"は選択できます
			if(giletModel != null && giletModel != ""){
				jQuery('input[id^="og_stitchModifyPlace_id"]').prop("disabled", false);
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
					jQuery("#giletModelCheck").empty();
					jQuery("#fabricMsg").empty();
					jQuery("#giletModelCheck").hide();
				}else if(checkResult == "false"){
					//2はモデルチェク失敗の場合
					jQuery("#giletModelCheck").show();
					jQuery("#glModelFlag").val("1"+"*"+getMsgByOneArg('msg065','GILET'));
					setAlert('giletModelCheck',getMsgByOneArg('msg065','GILET'));
				}
			}
	
			// GILETモデルに基づき、各項目をデフォルトへ変更
			// 胸ポケット
			var beforeBreastPkt = jQuery('input[name="coOptionGiletStandardInfo.ogBreastPkt"]:checked').val();
			jQuery('input[name="coOptionGiletStandardInfo.ogBreastPkt"]').val([ogGiletModelDefaultList[giletModel]["og_breastPkt"]]);
	
			// 腰ポケット
			var beforeWaistPkt = jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]:checked').val();
			jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]').val([ogGiletModelDefaultList[giletModel]["og_waistPkt"]]);
	
			// 腰ポケット形状
			var beforeWaistPktSpec = jQuery('input[name="coOptionGiletStandardInfo.ogWaistPktSpec"]:checked').val();
			jQuery('input[name="coOptionGiletStandardInfo.ogWaistPktSpec"]').val([ogGiletModelDefaultList[giletModel]["og_waistPktSpec"]]);
	
			if(itemCode == "04"){
				// ステッチ種類
				var beforeStitch = jQuery('input[name="coOptionGiletStandardInfo.ogStitch"]:checked').val();
				jQuery('input[name="coOptionGiletStandardInfo.ogStitch"]').val([ogGiletModelDefaultList[giletModel]["og_stitch"]]);
			}
			
			// ステッチ箇所変更
			if (ogStitchModifyList[giletModel]) {
				// 定義がある場合、モデルに基づくチェック状態にする
				jQuery('input[id^="og_stitchModifyPlace_id"]').val(ogStitchModifyList[giletModel]);
				jQuery('input[id^="og_dStitchModifyPlace_id"]').val(ogStitchModifyList[giletModel]);
			} 
			
			if (!ogStitchModifyList[giletModel]) {
				// 想定外のGiletモデルの場合はすべて変更不可＆チェックなし
				jQuery('input[id^="og_stitchModifyPlace_id"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				});
				return;
			}
			
			ctrlOgStitchModify();
			ctrlOgDStitchModify();
			ctrlOgDStitchModifyPlace();
			ctrlOgAmfColor();
	
			// バックベルト
			var beforeBackBelt = jQuery('#backBelt').val();
			jQuery('#og_backBelt').val(ogGiletModelDefaultList[giletModel]["og_backBelt"]);
	
			// ボタンホール色指定箇所の有効/無効を制御
			ctrlOgBhColorPlace();
			// ボタン付け糸指定箇所の有効/無効を制御
			ctrlOgByColorPlace();
			
			//ステッチ箇所変更
			jQuery('#og_stitchModify_id1').prop("checked", true);
			jQuery('input[name="coOptionGiletStandardInfo.ogStitchModify"]:checked').change();
			
			//ダブルステッチ変更
			jQuery('#og_dStitchModify_id1').prop("checked", true);
			jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]:checked').change();
			
			//AMF色指定
			jQuery('#og_amfColor_id1').prop("checked", true);
			jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor"]:checked').change();
			
			//ボタンホール色指定
			jQuery('#og_bhColor_id1').prop("checked", true);
			jQuery('input[name="coOptionGiletStandardInfo.ogBhColor"]:checked').change();
			
			//ボタン付け糸指定
			jQuery('#og_byColor_id1').prop("checked", true);
			jQuery('input[name="coOptionGiletStandardInfo.ogByColor"]:checked').change();
	
			// 別モデルに変更された場合はアラート表示
			if ((tmpGiletModel != '' || tmpGiletModel !=null) && giletModel != tmpGiletModel  && modelFlag == 2) {
				setAlert('giletModelMsg', "モデルが変更されました。選択項目の見直しを行ってください。");
			}
			// 一時保存のモデルを更新
			tmpGiletModel = giletModel;
		}
		
		// 選択中のAMFステッチ
		var stitchValue = jQuery('input[name="coOptionGiletStandardInfo.ogStitch"]:checked').val();
		var dStitchModifyValue = jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]:checked').val();
		var amfColorValue = jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor"]:checked').val();
		//AMFステッチ(ステッチ種類):0005102
		if (stitchValue != '0005101') {
			if(stitchValue == "0005102"){
				jQuery('input[id="og_dStitchModify_id2"]').prop("disabled", false);
				jQuery('input[id="og_amfColor_id2"]').prop("disabled", false);
			}else{
				jQuery('input[id="og_dStitchModify_id2"]').prop("disabled", true);
				jQuery('input[id="og_dStitchModify_id1"]').prop("checked", true);
				if(dStitchModifyValue != "0002601"){
					jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]:checked').change();
				}
				if(stitchValue == "0005104"){
					jQuery('input[id="og_amfColor_id2"]').prop("disabled", true);
					jQuery('input[id="og_amfColor_id1"]').prop("checked", true);
					if(amfColorValue != "0000801"){
						jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor"]:checked').change();
					}
				}
			}
		} else {
			jQuery('input[id="og_dStitchModify_id2"]').prop("disabled", true);
			jQuery('input[id="og_dStitchModify_id1"]').prop("checked", true);
			if(dStitchModifyValue != "0002601"){
				jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]:checked').change();
			}
			jQuery('input[id="og_amfColor_id2"]').prop("disabled", true);
			jQuery('input[id="og_amfColor_id1"]').prop("checked", true);
			if(amfColorValue != "0000801"){
				jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor"]:checked').change();
			}
		}
		
	});
	
	// 胸ポケット
	jQuery('input[id^="og_breastPkt_id"]').each(function() {
		jQuery(this).change(function(){
			// ダブルステッチ変更箇所の有効/無効
			
			// 選択中のステッチ箇所変更
			var ogStitchModifyValue = jQuery('input[name="coOptionGiletStandardInfo.ogStitchModify"]:checked').val();
			// 選択中の胸ポケットを取得
			var ogBreastPktValue = jQuery('input[name="coOptionGiletStandardInfo.ogBreastPkt"]:checked').val();
			
			if (ogStitchModifyValue == '0000602') {
				//ステッチ箇所変更は有りです
				jQuery('input[id^="og_stitchModifyPlace_id"]').each(function() {
					if(jQuery(this).attr("id") == "og_stitchModifyPlace_id2"){
						//胸ポケットは無し:0000101
						if(ogBreastPktValue == "0000101"){
							jQuery(this).prop("disabled", true);
							jQuery(this).prop("checked", false);
						}else{
							jQuery(this).prop("disabled", false);
						}
						jQuery(this).change();
					}
				});
			}
			
			// ダブルステッチの有効/無効設定
			jQuery('input[id^="og_dStitchModifyPlace_id"]').each(function() {
				var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("og_dS","og_s");
				var twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
				
				if (jQuery(this).val() == "0002702"){
					//ダブルステッチが「胸ポケット」:0002702
					if(ogStitchModifyValue == "0000602"){
						//ステッチ箇所変更が「無し」:0000601  「有り」:0000602
						if((ogBreastPktValue == "0000102" || ogBreastPktValue == "0000103") && twoStichModifyPlaceChecked){
							//胸ポケットが「無し」:0000101  「上前」:0000102  「両前」:0000103
							jQuery(this).prop("disabled", false);
						}else{
							jQuery(this).prop("disabled", true);
							jQuery(this).prop("checked", false);
						}
					}else{
						if(ogBreastPktValue == "0000102" || ogBreastPktValue == "0000103"){
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
		jQuery('input[name="coOptionGiletStandardInfo.ogStitch"]').prop("disabled",true);
	}else{
		jQuery('input[name="coOptionGiletStandardInfo.ogStitch"]').prop("disabled",false);
	}
	
	// 選択中の腰ポケット
	var waistPkt = jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]:checked').val();
	if (waistPkt == "0000201") {
		// 腰ポケットが有りの場合は腰ポケット形状を表示する
		jQuery('#og_waistPkt_yes_area').show();
	} else {
		// 腰ポケットが有りの場合は腰ポケット形状を非表示にする
		jQuery('#og_waistPkt_yes_area').hide();
	}

	// 腰ポケット
	jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]').each(function() {
		jQuery(this).change(function(){
			// 選択中の腰ポケット
			var waistPkt = jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]:checked').val();
			if (waistPkt == "0000201") {
				// 腰ポケットが有りの場合は腰ポケット形状を表示する
				jQuery('#og_waistPkt_yes_area').show();
			} else {
				// 腰ポケットが有りの場合は腰ポケット形状を非表示にする
				jQuery('#og_waistPkt_yes_area').hide();
			}
			
			// 選択中のステッチ箇所変更
			var ogStitchModifyValue = jQuery('input[name="coOptionGiletStandardInfo.ogStitchModify"]:checked').val();
			// 選択中の腰ポケットを取得
			var ogWaistPktValue = jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]:checked').val();
			
			if (ogStitchModifyValue == '0000602') {
				//ステッチ箇所変更は有りです
				jQuery('input[id^="og_stitchModifyPlace_id"]').each(function() {
					if(jQuery(this).attr("id") == "og_stitchModifyPlace_id3"){
						//腰ポケットは無し:0000202
						if(ogWaistPktValue == "0000202"){
							jQuery(this).prop("disabled", true);
							jQuery(this).prop("checked", false);
						}else{
							jQuery(this).prop("disabled", false);
						}
						jQuery(this).change();
					}
				});
			}
			
			// ダブルステッチの有効/無効設定
			jQuery('input[id^="og_dStitchModifyPlace_id"]').each(function() {
				var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("og_dS","og_s");
				var twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
				
				if (jQuery(this).val() == "0002703"){
					//ダブルステッチが「腰ポケット」:0002703
					if(ogStitchModifyValue == "0000602"){
						//ステッチ箇所変更が「無し」:0000601  「有り」:0000602
						if(ogWaistPktValue == "0000201" && twoStichModifyPlaceChecked){
							//胸ポケットが「有り」:0000201  「無し」:0000202
							jQuery(this).prop("disabled", false);
						}else{
							jQuery(this).prop("disabled", true);
							jQuery(this).prop("checked", false);
						}
					}else{
						if(ogWaistPktValue == "0000201"){
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
	jQuery('input[name="coOptionGiletStandardInfo.ogStitch"]').each(function() {
		jQuery(this).change(function(){
			changeOgStitch();
		});
	});
	changeOgStitch();

	// ステッチ箇所変更
	jQuery('input[name="coOptionGiletStandardInfo.ogStitchModify"]').each(function() {
		jQuery(this).change(function(){
			ctrlOgStitchModify();
			if(jQuery(this).val() == "0000601"){
				ctrlOgDStitchModify();
				ctrlOgDStitchModifyPlace();
				ctrlOgAmfColor();
			}
		});
	});
	ctrlOgStitchModify();

	// ステッチ箇所変更(選択肢)
	jQuery('input[id^="og_stitchModifyPlace_id"]').each(function() {
		jQuery(this).change(function(){
			ctrlOgDStitchModifyPlace();
			ctrlOgAmfColor();
			var amfColorPlaceIdTemp = jQuery(this).attr("id").replace("og_stitchModifyPlace_id","og_amfColorPlace_");
			jQuery("#"+amfColorPlaceIdTemp).change();
		});
	});

	// ダブルステッチ
	jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]').each(function() {
		jQuery(this).change(function(){
			ctrlOgDStitchModify();
			ctrlOgDStitchModifyPlace();
		});
	});
	ctrlOgDStitchModify();
	ctrlOgDStitchModifyPlace();

	// AMF色指定(有り/無し)
	jQuery('input[id^="og_amfColor_"]').each(function() {
		jQuery(this).change(function(){
			ctrlOgAmfColor();
		});
	});
	ctrlOgAmfColor();

	// AMF色指定(全選択)
	jQuery('#btn_as_og_amfColorPlace').click(function(){
		// 全選択する色を取得
		var allColor = jQuery('#og_amfColorPlaceAll').val();
	
		jQuery('#og_amfColor_div input[type="checkBox"]').each(function(index, elemCheckBox){
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
	jQuery('input[id^="og_amfColorPlace_"]').each(function() {
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
	var bhColor = jQuery('input[name="coOptionGiletStandardInfo.ogBhColor"]:checked').val();

	if (bhColor == '0001101') {
		// 無しの場合は操作不可
		jQuery('input[id^="og_bhColorPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
			jQuery('#'+this.id+'_div').hide();
		});
		jQuery('#og_bhColorPlaceAll').prop("disabled", true);
		jQuery('#btn_as_og_bhColorPlace').prop("disabled", true);

		// 無しの場合は2階層目を表示しない
		jQuery('#og_bhColor_div').hide();
	} else {
		// 有りの場合は操作可能
		ctrlOgBhColorPlace();
		jQuery('input[id^="og_bhColorPlace_"]').each(function() {
//			jQuery(this).prop("disabled", false);
			if (jQuery(this).prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+this.id+'_div').show();
			}
		});
		jQuery('#og_bhColorPlaceAll').prop("disabled", false);
		jQuery('#btn_as_og_bhColorPlace').prop("disabled", false);

		// 有りの場合は2階層目を表示
		jQuery('#og_bhColor_div').show();
	}

	// ボタンホール色指定(有り/無し)
	jQuery('input[name="coOptionGiletStandardInfo.ogBhColor"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var bhColor = jQuery('input[name="coOptionGiletStandardInfo.ogBhColor"]:checked').val();

			if (bhColor == '0001101') {
				// 無しの場合は操作不可
				jQuery('input[id^="og_bhColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#og_bhColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_og_bhColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#og_bhColor_div').hide();
			} else {
				// 有りの場合は操作可能
				ctrlOgBhColorPlace();
				jQuery('input[id^="og_bhColorPlace_"]').each(function() {
//					jQuery(this).prop("disabled", false);
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#og_bhColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_og_bhColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#og_bhColor_div').show();
			}
		});
	});
	jQuery('#og_bhColor_id1').change();
	
	// ボタンホール色指定(全選択)
	jQuery('#btn_as_og_bhColorPlace').click(function(){ 
		// 全選択する色を取得 
		var allColor = jQuery('#og_bhColorPlaceAll').val(); 
	
		jQuery('#og_bhColor_div input[type="checkBox"]').each(function(index, elemCheckBox){ 
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
	jQuery('input[id^="og_bhColorPlace_"]').each(function() { 
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
	ctrlOgBhColorPlace();
	
	// 選択中のボタンホール色指定を取得
	var byColor = jQuery('input[name="coOptionGiletStandardInfo.ogByColor"]:checked').val();

	if (byColor == '0001401') {
		// 無しの場合は操作不可
		jQuery('input[id^="og_byColorPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
			jQuery('#'+this.id+'_div').hide();
		});
		jQuery('#og_byColorPlaceAll').prop("disabled", true);
		jQuery('#btn_as_og_byColorPlace').prop("disabled", true);

		// 無しの場合は2階層目を表示しない
		jQuery('#og_byColor_div').hide();
	} else {
		// 有りの場合は操作可能
		ctrlOgByColorPlace();
		jQuery('input[id^="og_byColorPlace_"]').each(function() {
			if (jQuery(this).prop("checked")) {
				// 選択されているの場合、色指定エリアを表示
				jQuery('#'+this.id+'_div').show();
			}
		});
		jQuery('#og_byColorPlaceAll').prop("disabled", false);
		jQuery('#btn_as_og_byColorPlace').prop("disabled", false);

		// 有りの場合は2階層目を表示
		jQuery('#og_byColor_div').show();
	}
	
	// ボタン付け糸指定(有り/無し)
	jQuery('input[name="coOptionGiletStandardInfo.ogByColor"]').each(function() {
		jQuery(this).change(function(){
			// 選択中のボタンホール色指定を取得
			var byColor = jQuery('input[name="coOptionGiletStandardInfo.ogByColor"]:checked').val();

			if (byColor == '0001401') {
				// 無しの場合は操作不可
				jQuery('input[id^="og_byColorPlace_"]').each(function() {
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
					jQuery('#'+this.id+'_div').hide();
				});
				jQuery('#og_byColorPlaceAll').prop("disabled", true);
				jQuery('#btn_as_og_byColorPlace').prop("disabled", true);

				// 無しの場合は2階層目を表示しない
				jQuery('#og_byColor_div').hide();
			} else {
				// 有りの場合は操作可能
				ctrlOgByColorPlace();
				jQuery('input[id^="og_byColorPlace_"]').each(function() {
					if (jQuery(this).prop("checked")) {
						// 選択されているの場合、色指定エリアを表示
						jQuery('#'+this.id+'_div').show();
					}
				});
				jQuery('#og_byColorPlaceAll').prop("disabled", false);
				jQuery('#btn_as_og_byColorPlace').prop("disabled", false);

				// 有りの場合は2階層目を表示
				jQuery('#og_byColor_div').show();
			}
		});
	});
	jQuery('#og_byColor_id1').change();

	// ボタン付け糸指定(全選択)
	jQuery('#btn_as_og_byColorPlace').click(function(){ 
		// 全選択する色を取得 
		var allColor = jQuery('#og_byColorPlaceAll').val(); 
	
		jQuery('#og_byColor_div input[type="checkBox"]').each(function(index, elemCheckBox){ 
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
	jQuery('input[id^="og_byColorPlace_"]').each(function() { 
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
	ctrlOgByColorPlace();
	
	var bodyBackMate = jQuery('#og_backLiningMate').val();
	// バックベルト
	var backBeltElem = jQuery('#og_backBelt');
	var selectedBackBelt = backBeltElem.val();
	// 選択肢をクリア
	backBeltElem.empty();
	if (bodyBackMate == "1000400") {
		// 背裏素材「表地」選択時、バックベルトは「無し」か「537-5K」のみ
		backBeltElem.append(jQuery('<option />').val("0002302").text("546-20（尾錠型）"));
		backBeltElem.append(jQuery('<option />').val("0002303").text("無し"));

		if (selectedBackBelt == "0002301") {
			backBeltElem.val("0002302");
			jQuery('#og_backBelt').change();
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
	jQuery('#og_backLiningMate').change(function (){
		var bodyBackMate = jQuery('#og_backLiningMate').val();

//		// 背裏地品番
//		var bodyBackMateStkNoElem = jQuery('#og_backLiningMateStkNo');
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
//			jQuery('#btn_og_insideLiningMate').prop("disabled", false);
//		} else if (bodyBackMate == "1000400") {
//			// 表地仕様の場合は品番選択不可
//			bodyBackMateStkNoElem.prop("disabled", true);
//			jQuery('#btn_og_insideLiningMate').prop("disabled", true);
//		}

		// バックベルト
		var backBeltElem = jQuery('#og_backBelt');
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
				jQuery('#og_backBelt').change();
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
//	jQuery('#og_backLiningMate').change();

//	// 内側裏地素材
//	jQuery('#og_insideLiningMate').change(function (){
//		var bodyBackMate = jQuery('#og_insideLiningMate').val();
//
//		// 内側裏地品番
//		var bodyBackMateStkNoElem = jQuery('#og_insideLiningMateStkNo');
//
//		// 選択肢をクリア
//		bodyBackMateStkNoElem.empty();
//
//		if (giletInsideLiningMateStkNoList[bodyBackMate]) {
//			// 定義が存在する場合は品番を選択肢にセット
//			for (var i = 0; i < giletInsideLiningMateStkNoList[bodyBackMate].length; i++) {
//				bodyBackMateStkNoElem.append(jQuery('<option />').val(giletInsideLiningMateStkNoList[bodyBackMate][i]).text(giletInsideLiningMateStkNoList[bodyBackMate][i]));
//			}
//		}
//	});
//	jQuery('#og_insideLiningMate').change();

//	// フロント釦
//	jQuery('#og_frontBtnMate').change(function (){
//		var btnMate = jQuery('#og_frontBtnMate').val();
//
//		// フロント釦品番
//		var btnMateStkNoElem = jQuery('#og_frontBtnMateStkNo');
//
//		// 選択肢をクリア
//		btnMateStkNoElem.empty();
//
//		if (btnMateStkNoList[btnMate]) {
//			// 定義が存在する場合は品番を選択肢にセット
//			for (var i = 0; i < btnMateStkNoList[btnMate].length; i++) {
//				btnMateStkNoElem.append(jQuery('<option />').val(btnMateStkNoList[btnMate][i]).text(btnMateStkNoList[btnMate][i]));
//			}
//		}
//	});
//	jQuery('#og_frontBtnMate').change();
	
}

function myGiletStandardMethod(){
	var giletModel = jQuery("#giletModel option:selected").val();
	
	//GILETモデルが空の場合,ステッチ箇所変更,ダブルステッチ,AMF色指定,ボタンホール色指定,ボタン付け糸指定を空にします
	if(giletModel == '' || giletModel == null){
		//ステッチ箇所変更
		jQuery('input[id^="og_stitchModifyPlace_id"]').each(function() {
			jQuery(this).removeAttr("checked");
			jQuery(this).prop("disabled", true);
		});
		//ダブルステッチ
		jQuery('input[id^="og_dStitchModifyPlace_id"]').each(function() {
			jQuery(this).removeAttr("checked");
			jQuery(this).prop("disabled", true);
		});
		//AMF色指定
		jQuery('input[id^="og_amfColorPlace_"]').each(function() {
			jQuery(this).removeAttr("checked");
			jQuery(this).prop("disabled", true);
		});
		jQuery('input[id^="og_amfColor_"]').each(function() {
			var ogAmfColorId = jQuery(this).val();
			if(ogAmfColorId != "0000801" && ogAmfColorId != "0000802"){
				jQuery(this).removeAttr("checked");
			}
		});
		//ボタンホール色指定
		jQuery('input[id^="og_bhColorPlace_"]').each(function() {
			jQuery(this).removeAttr("checked");
			jQuery(this).prop("disabled", true);
			jQuery('#' + this.id + "_div").hide();
		});
		jQuery('input[id^="og_bhColor_"]').each(function() {
			var ogBhColorId = jQuery(this).val();
			if(ogBhColorId != "0001101" && ogBhColorId != "0001102"){
				jQuery(this).removeAttr("checked");
			}
		});
		//ボタン付け糸指定
		jQuery('input[id^="og_byColorPlace_"]').each(function() {
			jQuery(this).removeAttr("checked");
			jQuery(this).prop("disabled", true);
			jQuery('#' + this.id + "_div").hide();
		});
		jQuery('input[id^="og_byColor_"]').each(function() {
			var ogByColorId = jQuery(this).val();
			if(ogByColorId != "0001401" && ogByColorId != "0001402"){
				jQuery(this).removeAttr("checked");
			}
		});
	}
}

//ステッチ種類は変更時
function changeOgStitch() {
	// 選択中のAMFステッチ
	var stitchValue = jQuery('input[name="coOptionGiletStandardInfo.ogStitch"]:checked').val();
	var dStitchModifyValue = jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]:checked').val();
	var amfColorValue = jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor"]:checked').val();
	//無し:0005101
	if (stitchValue != "0005101") {
		// 有りの場合、関連する項目を有効化
		// ステッチ箇所変更
		jQuery('input[name="coOptionGiletStandardInfo.ogStitchModify"]').prop("disabled", false);
		// ダブルステッチ変更
		jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]').prop("disabled", false);
		// AMF色指定
		jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor"]').prop("disabled", false);

		// ステッチ関連の項目を表示
		jQuery('#og_stitch_yes_area').show();
	} else {
		// 無しの場合、関連する項目を無効化・値変更
		// ステッチ箇所変更
		jQuery('#og_stitchModify_id1').prop("checked", true);
		jQuery('#og_stitchModify_id1').change();
		// ダブルステッチ変更
		jQuery('#og_dStitchModify_id1').prop("checked", true);
		jQuery('#og_dStitchModify_id1').change();
		// AMF色指定
		jQuery('#og_amfColor_id1').prop("checked", true);
		jQuery('#og_amfColor_id1').change();

		// ステッチ関連の項目を非表示
		jQuery('#og_stitch_yes_area').hide();
	}

	//ステッチ種類が有りの場合はダブルステッチを有効化する
	//AMFステッチ(ステッチ種類):0005102
	if (stitchValue != '0005101') {
		if(stitchValue == "0005102"){
			jQuery('input[id="og_dStitchModify_id2"]').prop("disabled", false);
			jQuery('input[id="og_amfColor_id2"]').prop("disabled", false);
		}else{
			jQuery('input[id="og_dStitchModify_id2"]').prop("disabled", true);
			jQuery('input[id="og_dStitchModify_id1"]').prop("checked", true);
			if(dStitchModifyValue != "0002601"){
				jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]:checked').change();
			}
			if(stitchValue == "0005104"){
				jQuery('input[id="og_amfColor_id2"]').prop("disabled", true);
				jQuery('input[id="og_amfColor_id1"]').prop("checked", true);
				if(amfColorValue != "0000801"){
					jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor"]:checked').change();
				}
			}
		}
	} else {
		jQuery('input[id="og_dStitchModify_id2"]').prop("disabled", true);
		jQuery('input[id="og_dStitchModify_id1"]').prop("checked", true);
		if(dStitchModifyValue != "0002601"){
			jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]:checked').change();
		}
		jQuery('input[id="og_amfColor_id2"]').prop("disabled", true);
		jQuery('input[id="og_amfColor_id1"]').prop("checked", true);
		if(amfColorValue != "0000801"){
			jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor"]:checked').change();
		}
	}
}

jQuery('#btn_ar_og_stitchModifyPlace').click(function(){
	var wgDStitchModify = jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]:checked').val();
	var wgAmfColor = jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor"]:checked').val();
	
	if(wgDStitchModify == "0002602"){
		jQuery("#btn_ar_og_dStitchModifyPlace").click();
	}
	
	if(wgAmfColor == "0000802"){
		jQuery("#btn_ar_og_amfColorPlace").click();
	}
})

//ステッチ箇所変更の有効/無効を制御する
function ctrlOgStitchModify() {
	// 選択中のステッチ箇所変更
	var ogStitchModifyValue = jQuery('input[name="coOptionGiletStandardInfo.ogStitchModify"]:checked').val();
	// 選択中の胸ポケットを取得
	var ogBreastPktValue = jQuery('input[name="coOptionGiletStandardInfo.ogBreastPkt"]:checked').val();
	// 選択中の腰ポケットを取得
	var ogWaistPktValue = jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]:checked').val();

	// ステッチ箇所変更の有無で下位階層の表示制御
	//無し:0000601 有り:0000602
	if (ogStitchModifyValue == '0000601') {
		jQuery('#og_stitchModifyPlace').hide();
	} else if (ogStitchModifyValue == '0000602') {
		jQuery('#og_stitchModifyPlace').show();
	}

	// 選択中のgiletモデルを取得
	var giletModel = jQuery('#giletModel').val();

	if (!ogStitchModifyList[giletModel]) {
		jQuery('input[id^="og_stitchModifyPlace_id"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		});
		return;
	}
	
	if(ogStitchModifyValue == '0000601'){
		//ステッチ箇所変更は無しです
		jQuery('input[id^="og_stitchModifyPlace_id"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).removeAttr("checked");
		});
	}else if (ogStitchModifyValue == '0000602') {
		//ステッチ箇所変更は有りです
		//ラペル・フロントと胸ポケットと腰ポケット,デフォルト選択
		jQuery('input[id^="og_stitchModifyPlace_id"]').each(function() {
			jQuery(this).prop("disabled", false);
			var ogStitchModifyTemp = false;
			for(var i=0; i<ogStitchModifyList[giletModel].length; i++){
				if(jQuery(this).val() == ogStitchModifyList[giletModel][i]){
					jQuery(this).prop("checked", true);
					ogStitchModifyTemp = true;
				}
			}
			if(ogStitchModifyTemp == false){
				jQuery(this).prop("checked", false);
			}
			
			if(jQuery(this).attr("id") == "og_stitchModifyPlace_id2"){
				//胸ポケットは無し:0000101
				if(ogBreastPktValue == "0000101"){
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				}
			}else if(jQuery(this).attr("id") == "og_stitchModifyPlace_id3"){
				//腰ポケットは無し:0000202
				if(ogWaistPktValue == "0000202"){
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				}
			}
		});
	}

	// 全選択・全解除ボタン
	//無し:0000601 有り:0000602
	if (ogStitchModifyValue == '0000601') {
		jQuery('#btn_as_og_stitchModifyPlace').prop("disabled", true);
		jQuery('#btn_ar_og_stitchModifyPlace').prop("disabled", true);
	} else if (ogStitchModifyValue == '0000602') {
		jQuery('#btn_as_og_stitchModifyPlace').prop("disabled", false);
		jQuery('#btn_ar_og_stitchModifyPlace').prop("disabled", false);
	}
	
	if(ogStitchModifyValue == "0000602"){
		jQuery('input[id^="og_stitchModifyPlace_id"]').change();
	}
}

//ダブルステッチの有効/無効を制御する
function ctrlOgDStitchModify() {
	// 選択中のステッチ箇所変更
	var ogStitchModifyValue = jQuery('input[name="coOptionGiletStandardInfo.ogStitchModify"]:checked').val();
	
	// 選択中のステッチ箇所変更
	var ogDStitchModifyValue = jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]:checked').val();
	
	// 選択中の胸ポケットを取得
	var ogBreastPktValue = jQuery('input[name="coOptionGiletStandardInfo.ogBreastPkt"]:checked').val();

	// 選択中の腰ポケットを取得
	var ogWaistPktValue = jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]:checked').val();
	
	//無し:0002601 有り:0002602
	if(ogDStitchModifyValue == "0002601") {
		jQuery('#og_dStitchModifyPlace').hide();
	}else if(ogDStitchModifyValue == "0002602") {
		jQuery('#og_dStitchModifyPlace').show();
	}

	// 選択中のgiletモデルを取得
	var giletModel = jQuery('#giletModel').val();
	
	if (!ogDStitchModifyList[giletModel]) {
		// Jacketモデルとラペルデザインの組み合わせが定義にない場合はすべて変更不可
		jQuery('input[id^="og_dStitchModifyPlace_id"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		});
		return;
	}
	
	if(ogDStitchModifyValue == '0002601'){
		//ダブルステッチは無しです
		jQuery('input[id^="og_dStitchModifyPlace_id"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).removeAttr("checked");
		});
	}else if (ogDStitchModifyValue == '0002602') {
		//ダブルステッチは有りです
		//ラペル・フロントと胸ポケットと腰ポケット,デフォルト選択
		jQuery('input[id^="og_dStitchModifyPlace_id"]').each(function() {
			jQuery(this).prop("disabled", false);
			var ogDStitchModifyTemp = false;
			for(var i=0; i<ogDStitchModifyList[giletModel].length; i++){
				if(jQuery(this).val() == ogDStitchModifyList[giletModel][i]){
					jQuery(this).prop("checked", true);
					ogDStitchModifyTemp = true;
				}
			}
			if(ogDStitchModifyTemp == false){
				jQuery(this).prop("checked", false);
			}
		});
	}

	// ダブルステッチの有効/無効設定
	jQuery('input[id^="og_dStitchModifyPlace_id"]').each(function() {
		var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("og_dS","og_s");
		var twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
		
		if (jQuery(this).val() == "0002702"){
			//ダブルステッチが「胸ポケット」:0002702
			if(ogStitchModifyValue == "0000602"){
				//ステッチ箇所変更が「無し」:0000601  「有り」:0000602
				if((ogBreastPktValue == "0000102" || ogBreastPktValue == "0000103") && twoStichModifyPlaceChecked){
					//胸ポケットが「無し」:0000101  「上前」:0000102  「両前」:0000103
					jQuery(this).prop("disabled", false);
				}else{
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				}
			}else{
				if(ogBreastPktValue == "0000102" || ogBreastPktValue == "0000103"){
					jQuery(this).prop("disabled", false);
				}else{
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				}
			}
		}else if (jQuery(this).val() == "0002703"){
			//ダブルステッチが「腰ポケット」:0002703
			if(ogStitchModifyValue == "0000602"){
				//ステッチ箇所変更が「無し」:0000601  「有り」:0000602
				if(ogWaistPktValue == "0000201" && twoStichModifyPlaceChecked){
					//胸ポケットが「有り」:0000201  「無し」:0000202
					jQuery(this).prop("disabled", false);
				}else{
					jQuery(this).prop("disabled", true);
					jQuery(this).prop("checked", false);
				}
			}else{
				if(ogWaistPktValue == "0000201"){
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

// ダブルステッチ(選択肢)の有効/無効を制御する
function ctrlOgDStitchModifyPlace() {
	// 選択中のgiletモデルを取得
	var giletModel = jQuery('#giletModel').val();
	if (isEmpty(giletModel)) {
		// 未選択時は何もしない
		return;
	}
	
	// 選択中のステッチ箇所変更
	var ogStitchModifyValue = jQuery('input[name="coOptionGiletStandardInfo.ogStitchModify"]:checked').val();
	// 選択中のダブルステッチ
	var ogDStitchModifyValue = jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]:checked').val();
	
	if(ogStitchModifyValue == "0000602"){
		var twoStichModifyPlaceChecked = false;
		var twoDStitchModifyPlace = null;

		jQuery('input[id^="og_dStitchModifyPlace_id"]').each(function(){
			var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("og_dS","og_s");
			// ステッチ箇所変更要素取得
			twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
			// ダブルステッチ要素取得
			twoDStitchModifyPlace = jQuery(this);
			
			if (ogDStitchModifyValue == '0002602' && twoStichModifyPlaceChecked) {
				twoDStitchModifyPlace.prop("disabled", false);
				if(twoDStitchModifyPlace.attr("id") == "og_dStitchModifyPlace_id2"){
					//選択中の胸ポケットを取得
					var twoBreastPkt = jQuery('input[name="coOptionGiletStandardInfo.ogBreastPkt"]:checked').val();
					//胸ポケットは無し:0000101
					if(twoBreastPkt == "0000101"){
						twoDStitchModifyPlace.prop("disabled", true);
						twoDStitchModifyPlace.prop("checked", false);
					}
				}else if(twoDStitchModifyPlace.attr("id") == "og_dStitchModifyPlace_id3"){
					//選択中の腰ポケットを取得
					var twoWaistPkt = jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]:checked').val();
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
		
	}else if(ogStitchModifyValue == "0000601"){
		var twoDStitchModifyPlace = null;

		jQuery('input[id^="og_dStitchModifyPlace_id"]').each(function(){
			// ダブルステッチ要素取得
			twoDStitchModifyPlace = jQuery(this);
			
			if (ogDStitchModifyValue == '0002602') {
				twoDStitchModifyPlace.prop("disabled", false);
				if(twoDStitchModifyPlace.attr("id") == "og_dStitchModifyPlace_id2"){
					//選択中の胸ポケットを取得
					var twoBreastPkt = jQuery('input[name="coOptionGiletStandardInfo.ogBreastPkt"]:checked').val();
					//胸ポケットは無し:0000101
					if(twoBreastPkt == "0000101"){
						twoDStitchModifyPlace.prop("disabled", true);
						twoDStitchModifyPlace.prop("checked", false);
					}
				}else if(twoDStitchModifyPlace.attr("id") == "og_dStitchModifyPlace_id3"){
					//選択中の腰ポケットを取得
					var twoWaistPkt = jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]:checked').val();
					//腰ポケットは無し:0000202
					if(twoWaistPkt == "0000202"){
						twoDStitchModifyPlace.prop("disabled", true);
						twoDStitchModifyPlace.prop("checked", false);
					}
				}else{
					// 有り且つステッチ箇所変更の同項目が有効の場合、ダブルステッチも有効にする
					var ogDStitchModifyTemp = false;
					for(var i=0; i<ogDStitchModifyList[giletModel].length; i++){
						if(jQuery(this).val() == ogDStitchModifyList[giletModel][i]){
							twoDStitchModifyPlace.prop("disabled", false);
							ogDStitchModifyTemp = true;
						}
					}
					if(ogDStitchModifyTemp == false){
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
// ボタンホール色指定箇所の有効/無効を制御する
function ctrlOgBhColorPlace() {

	// 選択中のボタンホール色指定
	var bhColor = jQuery('input[name="coOptionGiletStandardInfo.ogBhColor"]:checked').val();

	// 選択中のGILETモデル
	var giletModel = jQuery('#giletModel').val();

	// ボタンホール色指定箇所の有効/無効を制御
	jQuery('#og_bhColor_div input[type="checkbox"]').each(function(index, elem){
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
function ctrlOgByColorPlace() {

	// 選択中のボタン付け糸指定
	var byColor = jQuery('input[name="coOptionGiletStandardInfo.ogByColor"]:checked').val();

	// 選択中のGILETモデル
	var giletModel = jQuery('#giletModel').val();

	// ボタン付け糸指定箇所の有効/無効を制御
	jQuery('#og_byColor_div input[type="checkbox"]').each(function(index, elem){
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

// AMF色指定の有効/無効を制御する
function ctrlOgAmfColor() {
	var stitchModifyValue = jQuery('input[name="coOptionGiletStandardInfo.ogStitchModify"]:checked').val();
	var amfColorValue = jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor"]:checked').val();
	
	if (amfColorValue == "0000802") {
		jQuery('#og_amfColor_div').show();
	} else {
		jQuery('#og_amfColor_div').hide();
	}
	
	// AMF色指定の有無で下位階層の表示制御
	//有り:0000802
	if (amfColorValue == '0000802') {
		jQuery('#og_amfColor_div').show();
		jQuery('#og_amfColorPlaceAll').prop("disabled", false);
		jQuery('#btn_as_og_amfColorPlace').prop("disabled", false);
	} else {
		jQuery('#og_amfColor_div input[type="radio"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.prop("checked")) {
				elem.removeAttr("checked");
			}
		});
		jQuery('#og_amfColor_div input[type="checkbox"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.prop("checked")) {
				elem.removeAttr("checked");
			}
		});
		jQuery('#og_amfColor_div').hide();
		jQuery('#og_amfColorPlaceAll').prop("disabled", true);
		jQuery('#btn_as_og_amfColorPlace').prop("disabled", true);
	}

	// 選択中のgiletモデルを取得
	var giletModel = jQuery('#giletModel').val();

	if (!ogAmfColorList[giletModel]) {
		// Jacketモデルとラペルデザインの組み合わせが定義にない場合はすべて変更不可
		jQuery('input[id^="og_amfColorPlace_"]').each(function() {
			jQuery(this).prop("disabled", true);
			jQuery(this).prop("checked", false);
		});
		return;
	}
	if(stitchModifyValue == "0000602"){
		var twoStichModifyPlaceChecked = false;
		var twoAmfColorPlace = null;

		jQuery('input[id^="og_amfColorPlace_"]').each(function(){
			var stichModifyPlaceIdTemp = jQuery(this).attr("id").replace("og_amfColorPlace_","og_stitchModifyPlace_id");
			// ステッチ箇所変更要素取得
			twoStichModifyPlaceChecked = jQuery("#"+stichModifyPlaceIdTemp).prop("checked");
			// ダブルステッチ要素取得
			twoAmfColorPlace = jQuery(this);
			stitchModifyValue
			if (amfColorValue == '0000802' && twoStichModifyPlaceChecked) {
				twoAmfColorPlace.prop("disabled", false);
				if(twoAmfColorPlace.attr("id") == "og_amfColorPlace_2"){
					//選択中の胸ポケットを取得
					var twoBreastPkt = jQuery('input[name="coOptionGiletStandardInfo.ogBreastPkt"]:checked').val();
					//胸ポケットは無し:0000101
					if(twoBreastPkt == "0000101"){
						twoAmfColorPlace.prop("disabled", true);
						twoAmfColorPlace.prop("checked", false);
					}
				}else if(twoAmfColorPlace.attr("id") == "og_amfColorPlace_3"){
					//選択中の腰ポケットを取得
					var twoWaistPkt = jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]:checked').val();
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

		jQuery('input[id^="og_amfColorPlace_"]').each(function(){
			// ダブルステッチ要素取得
			twoAmfColorPlace = jQuery(this);
			
			if (amfColorValue == '0000802') {
				twoAmfColorPlace.prop("disabled", false);
				if(twoAmfColorPlace.attr("id") == "og_amfColorPlace_2"){
					//選択中の胸ポケットを取得
					var twoBreastPkt = jQuery('input[name="coOptionGiletStandardInfo.ogBreastPkt"]:checked').val();
					//胸ポケットは無し:0000101
					if(twoBreastPkt == "0000101"){
						twoAmfColorPlace.prop("disabled", true);
						twoAmfColorPlace.prop("checked", false);
					}
				}else if(twoAmfColorPlace.attr("id") == "og_amfColorPlace_3"){
					//選択中の腰ポケットを取得
					var twoWaistPkt = jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]:checked').val();
					//腰ポケットは無し:0000202
					if(twoWaistPkt == "0000202"){
						twoAmfColorPlace.prop("disabled", true);
						twoAmfColorPlace.prop("checked", false);
					}
				}else{
					// 有り且つステッチ箇所変更の同項目が有効の場合、ダブルステッチも有効にする
					var ogAmfColorTemp = false;
					for(var i=0; i<ogAmfColorList[giletModel].length; i++){
						if(jQuery(this).val() == ogAmfColorList[giletModel][i]){
							twoAmfColorPlace.prop("disabled", false);
							ogAmfColorTemp = true;
						}
					}
					if(ogAmfColorTemp == false){
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