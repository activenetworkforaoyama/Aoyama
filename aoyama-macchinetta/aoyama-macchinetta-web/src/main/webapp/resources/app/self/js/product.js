/*********************************************
 * 商品タブ用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initProduct() {
	
	var oldItem = jQuery("#item").val();
	 // ３Piece、スペアパンツ
	if (oldItem == "01") {
		jQuery('#threePiece_div').show();
		jQuery('#sparePants_div').show();
	} else {
		jQuery('#threePiece_div').hide();
		jQuery('#sparePants_div').hide();
	}

	// 刺繍入れ
	if (oldItem == "01" || oldItem == "02" || oldItem == "06" || oldItem == "05") {
		jQuery('input[id="embroidered_id1"]').prop("disabled",false);
	} else {
		jQuery('input[id="embroidered_id2"]').prop("disabled",true);
		jQuery('input[id="embroidered_id1"]').prop("checked",true);
	}
	jQuery('input[name="productEmbroideryNecessity"]').change();

	// 刺繍糸色
	if (oldItem == "05") {
		jQuery("#jkEembroideryColor").hide();
		jQuery("#stEembroideryColor").show();
	}else{
		jQuery("#jkEembroideryColor").show();
		jQuery("#stEembroideryColor").hide();
	}
	getAdjustByItem();
	/*var embroideryColorElem = jQuery('#embroideryColor');
	var selectedEmbroideryColor = embroideryColorElem.val();
	embroideryColorElem.empty();
	var embroideryColorList = null;
	if (oldItem == "05") {
		embroideryColorList = [
			{value:"402（黒）", text:"402（黒）"},
			{value:"760（ネイビー）", text:"760（ネイビー）"},
			{value:"145（水色）", text:"145（水色）"},
			{value:"75（ブルー）", text:"75（ブルー）"},
			{value:"9（赤）", text:"9（赤）"},
			{value:"56（グリーン）", text:"56（グリーン）"},
			{value:"89（ライトブラウン）", text:"89（ライトブラウン）"},
			{value:"94（ブラウン）", text:"94（ブラウン）"},
			{value:"152（ボルドー）", text:"152（ボルドー）"},
			{value:"169（パープル）", text:"169（パープル）"},
			{value:"343（ベージュ）", text:"343（ベージュ）"},
			{value:"701（モカ）", text:"701（モカ）"},
			{value:"403（白）", text:"403（白）"}
		];
	} else {
		embroideryColorList = [
			{value:"110（金茶）", text:"110（金茶）"},
			{value:"401（白）", text:"401（白）"}
		];
	}
	var isExistSelectedEmbroideryColor = false;
	for (var i = 0; i < embroideryColorList.length; i++) {
		embroideryColorElem.append(jQuery('<option />').val(embroideryColorList[i].value).text(embroideryColorList[i].text));
		if (embroideryColorList[i].value == selectedEmbroideryColor) isExistSelectedEmbroideryColor = true;
	}
	if (isExistSelectedEmbroideryColor) {
		embroideryColorElem.val(selectedEmbroideryColor);
	} else {
		
	}*/

	// ガゼット刺繍・ネーム刺繍位置
	if (oldItem == "05") {
		// ガゼット刺繍・ネーム刺繍位置はシャツのみ表示
		jQuery('#embroidered_shirts_area').show();
	} else {
		jQuery('#embroidered_shirts_area').hide();
	}

	// カテゴリ
	if (oldItem == "06" || oldItem == "05") {
		// コートとシャツは標準のみ
		var category = jQuery('input[name="productCategory"]:checked').val();
		if (category != "9000101") {
			jQuery('#category_id1').prop('checked', true);
		}
		jQuery('input[name="productCategory"]').each(function(index, elem){
			elem = jQuery(elem);
			if (elem.val() == "9000101") {
				elem.prop("disabled", false);
			} else {
				elem.prop("disabled", true);
			}
		});
	} else {
		jQuery('input[name="productCategory"]').each(function(index, elem){
			elem = jQuery(elem);
			elem.prop("disabled", false);
		});
	}

	// 残布
	if (oldItem == "05") {
		jQuery('#cloth_div').hide();
	} else {
		jQuery('#cloth_div').show();
	}

	// オプションタグ内の表示制御
	changeViewArea();
	
	jQuery('#item').attr("hook",oldItem);
	
	// アイテム
	jQuery('#item').change(function(){
		// 選択されたITEMを取得
		var item = jQuery(this).val();
		swal({
			  text: getMsg('msg047'),
			  icon: "info",
			  buttons: ["キャンセル", true],
			})
			.then((isConfirm) => {
			  if (isConfirm) {
				    jQuery("#resultMessages").hide();
				    appendAlertDel('errormssage');
				    defaultGoodsInit();
				    getAdjustByItem();
				    jQuery.ajax({url:contextPath + "/orderCo/optionInit",data:{"oldItem":jQuery('#item').attr("hook")},type: "get",async:false});
				  	jQuery("#jacketItemFlag").val("0");
				  	jQuery("#pantsItemFlag").val("0");
				  	jQuery("#giletItemFlag").val("0");
				  	jQuery("#shirtItemFlag").val("0");
				  	jQuery("#coatItemFlag").val("0");
				  	jQuery("#pants2ItemFlag").val("0");
				  	
				  	
				    jQuery("#jacketAdFlag").val("0");
				  	jQuery("#pantsAdFlag").val("0");
				  	jQuery("#pants2AdFlag").val("0");
				  	jQuery("#giletAdFlag").val("0");
				  	jQuery("#coatAdFlag").val("0");
				  	jQuery("#shirtAdFlag").val("0");
				  	
			        jQuery("#jkOptionPriceId").val("0");
				  	jQuery("#ptOptionPriceId").val("0");
				  	jQuery("#pt2OptionPriceId").val("0");
				  	jQuery("#glOptionPriceId").val("0");
				  	jQuery("#ctOptionPriceId").val("0");
				  	jQuery("#stOptionPriceId").val("0");
				  	
				  	jQuery("#jkDoubleModelPrice").val("0");
				  	jQuery("#ctDoubleModelPrice").val("0");
				  	jQuery("#glDoubleModelPrice").val("0");
				  	
				  	jQuery('input[name="productEmbroideryNecessity"][value="9000501"]').prop("checked",true);
				  	
				  	//jQuery('#embroidered_no').change();
				  	getProductPrice();
				  	shirtProductPrice();
				  	stockCheck();
				    compositionExpress();
				    getAdjustByItem();
			        // ３Piece、スペアパンツ
					if (item == "01") {
						jQuery('#threePiece_div').show();
						jQuery('#sparePants_div').show();
					} else {
						jQuery('#threePiece_div').hide();
						jQuery('#sparePants_div').hide();
					}

					// 刺繍入れ
					if (item == "01" || item == "02" || item == "06" || item == "05") {
						jQuery('input[id="embroidered_id1"]').prop("disabled",false);
					} else {
						jQuery('input[id="embroidered_id2"]').prop("disabled",true);
						jQuery('input[id="embroidered_id1"]').prop("checked",true);
					}
					jQuery('input[name="productEmbroideryNecessity"]').change();

					// 刺繍糸色
					// 刺繍糸色
					if (item == "05") {
						jQuery("#jkEembroideryColor").hide();
						jQuery("#stEembroideryColor").show();
					}else{
						jQuery("#jkEembroideryColor").show();
						jQuery("#stEembroideryColor").hide();
					}
					/*var embroideryColorElem = jQuery('#embroideryColor');
					var selectedEmbroideryColor = embroideryColorElem.val();
					embroideryColorElem.empty();
					var embroideryColorList = null;
					if (item == "05") {
						embroideryColorList = [
							{value:"402", text:"402（黒）"},
							{value:"760", text:"760（ネイビー）"},
							{value:"145", text:"145（水色）"},
							{value:"75", text:"75（ブルー）"},
							{value:"9", text:"9（赤）"},
							{value:"56", text:"56（グリーン）"},
							{value:"89", text:"89（ライトブラウン）"},
							{value:"94", text:"94（ブラウン）"},
							{value:"152", text:"152（ボルドー）"},
							{value:"169", text:"169（パープル）"},
							{value:"343", text:"343（ベージュ）"},
							{value:"701", text:"701（モカ）"},
							{value:"403", text:"403（白）"}
						];
					} else {
						embroideryColorList = [
							{value:"110", text:"110（金茶）"},
							{value:"401", text:"401（白）"}
						];
					}
					var isExistSelectedEmbroideryColor = false;
					for (var i = 0; i < embroideryColorList.length; i++) {
						embroideryColorElem.append(jQuery('<option />').val(embroideryColorList[i].value).text(embroideryColorList[i].text));
						if (embroideryColorList[i].value == selectedEmbroideryColor) isExistSelectedEmbroideryColor = true;
					}
					if (isExistSelectedEmbroideryColor) {
						embroideryColorElem.val(selectedEmbroideryColor);
					} else {
			
						appendAlert('embroideryColorMsg', "デフォルトに変更しました。");
			
					}*/

					// ガゼット刺繍・ネーム刺繍位置
					if (item == "05") {
						// ガゼット刺繍・ネーム刺繍位置はシャツのみ表示
						jQuery('#embroidered_shirts_area').show();
					} else {
						jQuery('#embroidered_shirts_area').hide();
					}

					// カテゴリ
					if (item == "06" || item == "05") {
						// コートとシャツは標準とＳＰのみ
						var category = jQuery('input[name="productCategory"]:checked').val();
						if (category != "9000101") {
							jQuery('#category_id1').prop('checked', true);
						}
						jQuery('input[name="productCategory"]').each(function(index, elem){
							elem = jQuery(elem);
							if (elem.val() == "9000101") {
								elem.prop("disabled", false);
							} else {
								elem.prop("disabled", true);
							}
						});
					} else {
						jQuery('input[name="productCategory"]').each(function(index, elem){
							elem = jQuery(elem);
							elem.prop("disabled", false);
						});
					}

					// 残布
					if (item == "05") {
						jQuery('#cloth_div').hide();
					} else {
						jQuery('#cloth_div').show();
					}

					// オプションタグ内の表示制御
					changeViewArea();
					if(item!=oldItem){
						jQuery('#item').attr("hook",item);
					}
					
			  }else{
				 jQuery("#itemFlag").val("0");
				 jQuery('#item').val(jQuery('#item').attr("hook"));
			  }
		});
		
	});
	//jQuery('#item').change();

	/*// 生地品番 在庫チェック
	jQuery('#productFabricNo').blur(function() {
		if (jQuery(this).val() == "") {
			jQuery('#stockMsg').hide();
		} else {
			jQuery('#stockMsg').show();
		}
	});*/
	/*jQuery('#stockCheck').click(function() {
		jQuery('#stockMsg').show();
	});*/
	
	// 選択中の刺繍入れ
	var embroidered = jQuery('input[name="productEmbroideryNecessity"]:checked').val();
	var item = jQuery("#item").val();
	// 刺繍入れが有りの場合は刺繍関連項目を表示する
	if (embroidered == '9000502') {
		if(item == "05"){
			shirtProductPrice();
		}
		jQuery('#embroidered_yes_area').show();
	} else {
		if(item == "05"){
			jQuery("#embroideryNmPosPrice").val("0");
			jQuery("#gadgetPrice").val("0");
			allOptionPrice();
		}
		jQuery('#embroidered_yes_area').hide();
	}
	// 刺繍入れ
	jQuery('input[name="productEmbroideryNecessity"]').each(function() {
		jQuery(this).change(function(){
			// 選択中の刺繍入れ
			var embroidered = jQuery('input[name="productEmbroideryNecessity"]:checked').val();
			var item = jQuery("#item").val();
			// 刺繍入れが有りの場合は刺繍関連項目を表示する
			if (embroidered == '9000502') {
				if(item == "05"){
					shirtProductPrice();
				}
				jQuery('#embroidered_yes_area').show();
			} else {
				if(item == "05"){
					jQuery("#embroideryNmPosPrice").val("0");
					jQuery("#gadgetPrice").val("0");
					allOptionPrice();
				}
				jQuery('#embroidered_yes_area').hide();
			}
		});
	});

	// 納期短縮
	jQuery('#expediteDelivery').change(function() {
		var sValue = jQuery(this).val();
		// 有の場合は金額表示
		if (sValue == "有") {
			jQuery('#expediteDeliveryMsg').show();
		} else {
			jQuery('#expediteDeliveryMsg').hide();
		}
	});
	jQuery('#expediteDelivery').change();

}

//--------------------------------------------
// 部品
//--------------------------------------------
function changeViewArea() {
	// 選択中のITEM
	var item = jQuery('#item').val();
	// 選択中の３Piece
	var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
	// 選択中のスペアパンツ
	var sparePants = jQuery('input[name="productSparePantsClass"]:checked').val();
	// 選択中のカテゴリー
	var category = jQuery('input[name="productCategory"]:checked').val();

	if (category == "9000102") {
		// 標準オプションを非表示
		normalOptionHide();
		// ウォッシャブルオプションを非表示
		washableOptionHide();

		if (item == "01") {
			jQuery('#tu_jacket_div').show();
			jQuery('#al_jacket_div').show();
			//有り:0009902
			if (threePiece == "0009902") {
				jQuery('#tu_gilet_div').show();
				jQuery('#btn_tg_backLiningMate').show();
				jQuery('#btn_tg_frontBtnMate').show();
				jQuery('#al_gilet_div').show();
			} else {
				jQuery('#tu_gilet_div').hide();
				jQuery('#al_gilet_div').hide();
			}
			jQuery('#tu_pants_div').show();
			jQuery('#al_pants_div').show();
			if (sparePants == "0009902") {
				jQuery('#tu2_pants_div').show();
				jQuery('#al2_pants_div').show();
			} else {
				jQuery('#tu2_pants_div').hide();
				jQuery('#al2_pants_div').hide();
			}
			if (sparePants == "3パンツ") {
				jQuery('#tu3_pants_div').show();
				jQuery('#al3_pants_div').show();
			} else {
				jQuery('#tu3_pants_div').hide();
				jQuery('#al3_pants_div').hide();
			}
			jQuery('#tp_sameJacketBtn').show();
		} else if (item == "02") {
			jQuery('#tu_jacket_div').show();
			jQuery('#al_jacket_div').show();
			jQuery('#tu_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
			jQuery('#tu_pants_div').hide();
			jQuery('#al_pants_div').hide();
			jQuery('#tu2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#tu3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
		} else if (item == "03") {
			jQuery('#tu_jacket_div').hide();
			jQuery('#al_jacket_div').hide();
			jQuery('#tu_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
			jQuery('#tu_pants_div').show();
			jQuery('#al_pants_div').show();
			jQuery('#tu2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#tu3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
			jQuery('#tp_sameJacketBtn').hide();
		} else if (item == "04") {
			jQuery('#tu_jacket_div').hide();
			jQuery('#al_jacket_div').hide();
			jQuery('#tu_gilet_div').show();
			jQuery('#al_gilet_div').show();
			jQuery('#tu_pants_div').hide();
			jQuery('#al_pants_div').hide();
			jQuery('#tu2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#tu3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
			jQuery('#btn_tg_backLiningMate').hide();
			jQuery('#btn_tg_frontBtnMate').hide();
		} else if (item == "06") {
			jQuery('#tu_jacket_div').hide();
			jQuery('#al_jacket_div').hide();
			jQuery('#tu_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
			jQuery('#tu_pants_div').hide();
			jQuery('#al_pants_div').hide();
			jQuery('#tu2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#tu3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
		} else if (item == "05") {
			jQuery('#tu_jacket_div').hide();
			jQuery('#al_jacket_div').hide();
			jQuery('#tu_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
			jQuery('#tu_pants_div').hide();
			jQuery('#al_pants_div').hide();
			jQuery('#tu2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#tu3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
		}
	} else if (category == "9000103") {
		// 標準オプションを非表示
		normalOptionHide();
		// タキシードオプションを非表示
		tuxedoOptionHide();

		if (item == "01") {
			jQuery('#wa_jacket_div').show();
			jQuery('#al_jacket_div').show();
			if (threePiece == "0009902") {
				jQuery('#wa_gilet_div').show();
				jQuery('#btn_wg_backLiningMate').show();
				jQuery('#btn_wg_frontBtnMate').show();
				jQuery('#al_gilet_div').show();
			} else {
				jQuery('#wa_gilet_div').hide();
				jQuery('#al_gilet_div').hide();
			}
			jQuery('#wa_pants_div').show();
			jQuery('#al_pants_div').show();
			if (sparePants == "0009902" || sparePants == "3パンツ") {
				jQuery('#wa2_pants_div').show();
				jQuery('#al2_pants_div').show();
			} else {
				jQuery('#wa2_pants_div').hide();
				jQuery('#al2_pants_div').hide();
			}
			if (sparePants == "3パンツ") {
				jQuery('#wa3_pants_div').show();
				jQuery('#al3_pants_div').show();
			} else {
				jQuery('#wa3_pants_div').hide();
				jQuery('#al3_pants_div').hide();
			}
			jQuery('#wp_sameJacketBtn').show();
		} else if (item == "02") {
			jQuery('#wa_jacket_div').show();
			jQuery('#al_jacket_div').show();
			jQuery('#wa_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
			jQuery('#wa_pants_div').hide();
			jQuery('#al_pants_div').hide();
			jQuery('#wa2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#wa3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
		} else if (item == "03") {
			jQuery('#wa_jacket_div').hide();
			jQuery('#al_jacket_div').hide();
			jQuery('#wa_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
			jQuery('#wa_pants_div').show();
			jQuery('#al_pants_div').show();
			jQuery('#wa2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#wa3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
			jQuery('#wp_sameJacketBtn').hide();
		} else if (item == "04") {
			jQuery('#wa_jacket_div').hide();
			jQuery('#al_jacket_div').hide();
			jQuery('#wa_gilet_div').show();
			jQuery('#al_gilet_div').show();
			jQuery('#wa_pants_div').hide();
			jQuery('#al_pants_div').hide();
			jQuery('#wa2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#wa3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
			jQuery('#btn_wg_backLiningMate').hide();
			jQuery('#btn_wg_frontBtnMate').hide();
		} else if (item == "06") {
			jQuery('#wa_jacket_div').hide();
			jQuery('#al_jacket_div').hide();
			jQuery('#wa_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
			jQuery('#wa_pants_div').hide();
			jQuery('#al_pants_div').hide();
			jQuery('#wa2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#wa3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
		} else if (item == "05") {
			jQuery('#wa_jacket_div').hide();
			jQuery('#al_jacket_div').hide();
			jQuery('#wa_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
			jQuery('#wa_pants_div').hide();
			jQuery('#al_pants_div').hide();
			jQuery('#wa2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#wa3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
		}
	} else {
		// タキシードオプションを非表示
		tuxedoOptionHide();
		// ウォッシャブルオプションを非表示
		washableOptionHide();

		if (item == "01") {
			jQuery('#op_jacket_div').show();
			jQuery('#al_jacket_div').show();
			if (threePiece == "0009902") {
				jQuery('#op_gilet_div').show();
				jQuery('#btn_og_backLiningMate').show();
				jQuery('#btn_og_frontBtnMate').show();
				jQuery('#al_gilet_div').show();
			} else {
				jQuery('#op_gilet_div').hide();
				jQuery('#al_gilet_div').hide();
			}
			jQuery('#op_pants_div').show();
			jQuery('#al_pants_div').show();
			if (sparePants == "0009902") {
				jQuery('#op2_pants_div').show();
				jQuery('#al2_pants_div').show();
			} else {
				jQuery('#op2_pants_div').hide();
				jQuery('#al2_pants_div').hide();
			}
			if (sparePants == "3パンツ") {
				jQuery('#op3_pants_div').show();
				jQuery('#al3_pants_div').show();
			} else {
				jQuery('#op3_pants_div').hide();
				jQuery('#al3_pants_div').hide();
			}
			jQuery('#op_sameJacketBtn').show();
			jQuery('#op_coat_div').hide();
			jQuery('#al_coat_div').hide();
			jQuery('#op_shirt_div').hide();
			jQuery('#al_shirt_div').hide();
		} else if (item == "02") {
			jQuery('#op_jacket_div').show();
			jQuery('#al_jacket_div').show();
			jQuery('#op_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
			jQuery('#op_pants_div').hide();
			jQuery('#al_pants_div').hide();
			jQuery('#op2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#op3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
			jQuery('#op_sameJacketBtn').hide();
			jQuery('#op_coat_div').hide();
			jQuery('#al_coat_div').hide();
			jQuery('#op_shirt_div').hide();
			jQuery('#al_shirt_div').hide();
		} else if (item == "03") {
			jQuery('#op_jacket_div').hide();
			jQuery('#al_jacket_div').hide();
			jQuery('#op_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
			jQuery('#op_pants_div').show();
			jQuery('#al_pants_div').show();
			jQuery('#op2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#op3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
			jQuery('#op_sameJacketBtn').hide();
			jQuery('#op_coat_div').hide();
			jQuery('#al_coat_div').hide();
			jQuery('#op_shirt_div').hide();
			jQuery('#al_shirt_div').hide();
		} else if (item == "04") {
			jQuery('#op_jacket_div').hide();
			jQuery('#al_jacket_div').hide();
			jQuery('#op_gilet_div').show();
			jQuery('#al_gilet_div').show();
			jQuery('#op_pants_div').hide();
			jQuery('#al_pants_div').hide();
			jQuery('#op2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#op3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
			jQuery('#btn_og_backLiningMate').hide();
			jQuery('#btn_og_frontBtnMate').hide();
			jQuery('#op_sameJacketBtn').hide();
			jQuery('#op_coat_div').hide();
			jQuery('#al_coat_div').hide();
			jQuery('#op_shirt_div').hide();
			jQuery('#al_shirt_div').hide();
		} else if (item == "06") {
			jQuery('#op_jacket_div').hide();
			jQuery('#al_jacket_div').hide();
			jQuery('#op_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
			jQuery('#op_pants_div').hide();
			jQuery('#al_pants_div').hide();
			jQuery('#op2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#op3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
			jQuery('#op_sameJacketBtn').hide();
			jQuery('#op_coat_div').show();
			jQuery('#al_coat_div').show();
			jQuery('#op_shirt_div').hide();
			jQuery('#al_shirt_div').hide();
		} else if (item == "05") {
			jQuery('#op_jacket_div').hide();
			jQuery('#al_jacket_div').hide();
			jQuery('#op_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
			jQuery('#op_pants_div').hide();
			jQuery('#al_pants_div').hide();
			jQuery('#op2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
			jQuery('#op3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
			jQuery('#op_sameJacketBtn').hide();
			jQuery('#op_coat_div').hide();
			jQuery('#al_coat_div').hide();
			jQuery('#op_shirt_div').show();
			jQuery('#al_shirt_div').show();
		}
	}
	
	// PANTS釦素材の設定
	// JKと同じボタンを非表示
	jQuery('#op_sameJacketBtn').hide();
	jQuery('#op2_sameJacketBtn').hide();
	jQuery('#tp_sameJacketBtn').hide();
	jQuery('#tp2_sameJacketBtn').hide();
	jQuery('#wp_sameJacketBtn').hide();
	jQuery('#wp2_sameJacketBtn').hide();

	

/*
	// 選択項目を設定
	var setSameBtnDisabled = false;
	if (item=="SUIT") {
		// 選択項目を無効
		setSameBtnDisabled = true;
	}
	
	jQuery('#op_button').prop('disabled', setSameBtnDisabled);
	jQuery('#op_btnMateStkNo').prop('disabled', setSameBtnDisabled);
	jQuery('#op2_button').prop('disabled', setSameBtnDisabled);
	jQuery('#op2_btnMateStkNo').prop('disabled', setSameBtnDisabled);
	jQuery('#tp_button').prop('disabled', setSameBtnDisabled);
	jQuery('#tp_btnMateStkNo').prop('disabled', setSameBtnDisabled);
	jQuery('#tp2_button').prop('disabled', setSameBtnDisabled);
	jQuery('#tp2_btnMateStkNo').prop('disabled', setSameBtnDisabled);
	jQuery('#wp_button').prop('disabled', setSameBtnDisabled);
	jQuery('#wp_btnMateStkNo').prop('disabled', setSameBtnDisabled);
	jQuery('#wp2_button').prop('disabled', setSameBtnDisabled);
	jQuery('#wp2_btnMateStkNo').prop('disabled', setSameBtnDisabled);	
*/
}

// 標準オプションのジャケット、ジレ、パンツを非表示にする
function normalOptionHide() {
	jQuery('#op_jacket_div').hide();
	jQuery('#al_jacket_div').hide();
	jQuery('#op_gilet_div').hide();
	jQuery('#al_gilet_div').hide();
	jQuery('#op_pants_div').hide();
	jQuery('#al_pants_div').hide();
	jQuery('#op2_pants_div').hide();
	jQuery('#al2_pants_div').hide();
	jQuery('#op3_pants_div').hide();
	jQuery('#al3_pants_div').hide();
	jQuery('#op_sameJacketBtn').hide();
	jQuery('#op_coat_div').hide();
	jQuery('#al_coat_div').hide();
	jQuery('#op_shirt_div').hide();
	jQuery('#al_shirt_div').hide();
}

// タキシードオプションのジャケット、ジレ、パンツを非表示にする
function tuxedoOptionHide() {
	jQuery('#tu_jacket_div').hide();
	jQuery('#tu_gilet_div').hide();
	jQuery('#tu_pants_div').hide();
	jQuery('#tu2_pants_div').hide();
	jQuery('#tu3_pants_div').hide();
}

//ウォッシャブルオプションのジャケット、ジレ、パンツを非表示にする
function washableOptionHide() {
	jQuery('#wa_jacket_div').hide();
	jQuery('#wa_gilet_div').hide();
	jQuery('#wa_pants_div').hide();
	jQuery('#wa2_pants_div').hide();
	jQuery('#wa3_pants_div').hide();
}

function getAdjustByItem(){
	var subItemCode = "";
	var itemCode = jQuery("#item").val();
	if(itemCode == "05"){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getAdjustByItem",
	        type: 'get',
	        //async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	        	   if(e.subItemCode == "05"){
	        		   if(e.adjusteClass == "15"){
							document.getElementById("embroideryHeightRange").max = e.adjusteMax;
							jQuery("#embroideryHeightRange_out").val(e.adjusteMin);	
							document.getElementById("embroideryHeightRange").min = e.adjusteMin;
						}
		        	   if(e.adjusteClass == "16"){
							document.getElementById("embroideryWidthRange").max = e.adjusteMax;
							jQuery("#embroideryWidthRange_out").val(e.adjusteMin);
							document.getElementById("embroideryWidthRange").min = e.adjusteMin;
						}						 
			       }
	           });
	        }
	    });
	}
}
