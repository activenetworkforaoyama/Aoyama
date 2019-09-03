/*********************************************
 * シャツ用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initOptionShirt() {
	jQuery('.casHemLineSizeArea').hide();
	// カジュアルヘムライン仕様
	jQuery(':radio[name="optionShirtStandardInfo.osCasHemLine"]').each(function(){
		jQuery(this).change(function(){
			var casHemLine = jQuery(':radio[name="optionShirtStandardInfo.osCasHemLine"]:checked').val();
			if (casHemLine == "0002002") {
				// カジュアルヘムライン仕様が有りの場合、後ろ丈を表示
				jQuery('.casHemLineSizeArea').show();
			} else {
				jQuery('.casHemLineSizeArea').hide();
			}
		});
	});
	//jQuery('#os_casHemLine_id').change();
		
	// 襟型
	jQuery('#os_chainModel').change(function(){
		var os_chainModel = jQuery('#os_chainModel').val();
		
		//ピンホールピン
		if (os_chainModel == "0000113" || os_chainModel == "0000114") {
			// 襟型「ピンホール・ラウンドピンホール」選択時のみ「ピンホールピン」選択可
			jQuery(':radio[name="optionShirtStandardInfo.osPinHolePin"]').prop('disabled', false);
		} else {
			jQuery(':radio[name="optionShirtStandardInfo.osPinHolePin"]').prop('disabled', true);
			jQuery('#os_pinHolePin_id1').prop('checked', true);
		}

		//カラーキーパー
		var os_colorKeeper_disabled = jQuery('#os_colorKeeper_id2').prop('disabled');
		if (os_chainModel == "0000108" || os_chainModel == "0000109" ||
				os_chainModel == "0000113" || os_chainModel == "0000114" ||
				os_chainModel == "0000115") {
			// 「襟型」ボタンダウン・ショートボタンダウン・ピンホール・ラウンドピンホール・ウイング選択時、
			// 「カラーキーパー」は「無し」にて選択不可
			jQuery('#os_colorKeeper_id2').prop('checked', true);
			jQuery(':radio[name="optionShirtStandardInfo.osColorKeeper"]').prop('disabled', true);
		} else {
			jQuery(':radio[name="optionShirtStandardInfo.osColorKeeper"]').prop('disabled', false);
			if (os_colorKeeper_disabled) {
				// 元々無効化されていた場合、デフォルトの「有り」を選択状態にする
				jQuery('#os_colorKeeper_id2').prop('checked', true);
			}
		}
		
		//タブ釦
		if (os_chainModel == "0000111" || os_chainModel == "0000112") {
			// 通常、スナップ
			jQuery('#os_tabBtn_id1').prop('checked', true);
			jQuery('#os_tabBtn_id1').prop('disabled', false);
			jQuery('#os_tabBtn_id2').prop('disabled', false);
			jQuery('#os_tabBtn_id3').prop('disabled', true);
		} else {
			// なし
			jQuery('#os_tabBtn_id3').prop('checked', true);
			jQuery('#os_tabBtn_id1').prop('disabled', true);
			jQuery('#os_tabBtn_id2').prop('disabled', true);
			jQuery('#os_tabBtn_id3').prop('disabled', false);
		}

	});
	jQuery('#os_chainModel').change();


	// カフス
	jQuery('#os_cuffs').change(function(){
		
		//コンバーチブル
		var os_cuffs = jQuery('#os_cuffs').val();
		if (os_cuffs == "0000204" || os_cuffs == "0000205") {
			// ダブルカフスの場合、コンバーチブルの選択不可
			jQuery('#os_convertible').prop('disabled', true);
			jQuery('#os_convertible').val("0000301");
		} else {
			jQuery('#os_convertible').prop('disabled', false);
		}
		jQuery('#os_convertible').change();
		
		// カフスボタン追加の変更
		changeAddCuff();
	});
	jQuery('#os_cuffs').change();

	// コンバーチブル
	jQuery('#os_convertible').change(function(){
		var os_convertible = jQuery('#os_convertible').val();
		if (os_convertible == '0000302') {
			// 「コンバーチブル」選択「有り」のときのみ「アジャスト釦」は選択可
			jQuery('#os_adjustBtn').prop('disabled', false);
			jQuery('#os_adjustBtn').val("0000402");
		} else {
			jQuery('#os_adjustBtn').prop('disabled', true);
			jQuery('#os_adjustBtn').val("0000401");
		}

		// カフスボタン追加の変更
		changeAddCuff();
	});
	//jQuery('#os_convertible').change();
	
	// 胸ポケット
	jQuery(':radio[name="optionShirtStandardInfo.osBreastPk"]').each(function(){
		jQuery(this).change(function(){

			jQuery('#os_breastPkSizeArea').show();

			var sSelected = jQuery(':radio[name="optionShirtStandardInfo.osBreastPk"]:checked').val();
			if (sSelected == "0001202") {
				jQuery('#os_breastPkSizeArea').hide();
			}
		});
	});
	
	// ボタン位置変更
	jQuery(':radio[name="optionShirtStandardInfo.osBtnPosChg"]').each(function(){
		jQuery(this).change(function(){
			// 選択中のクレリック仕様
			var os_clericSpec = jQuery(':radio[name="optionShirtStandardInfo.osBtnPosChg"]:checked').val();
			if (os_clericSpec == "0002102") {
				jQuery('#os_btnPosChg_area').show();
			} else if (os_clericSpec == "0002101") {
				jQuery('#os_btnPosChg_area').hide();
			}
		});
	});
	//jQuery('#os_btnPosChg_id').change();

}

//--------------------------------------------
// 部品
//--------------------------------------------
// カフスボタン追加の入力制御
function changeAddCuff() {

	jQuery('#os_AddCuff_id2').prop('disabled', false);
	
	//カフスはダブルカフス仕様（折り返しスクエア）、ダブルカフス仕様（ミラノカフス）の場合は、選択不可
	var os_cuffs = jQuery('#os_cuffs').val();
	if (os_cuffs == "0000204" || os_cuffs == "0000205") {
		// カフスボタン追加は使用不可
		jQuery('#os_AddCuff_id1').prop('checked', true);
		jQuery('#os_AddCuff_id2').prop('disabled', true);
	}

	//コンバーチブル「有」選択時不可
	var os_convertible = jQuery('#os_convertible').val();
	if (os_convertible == '0000302') {
		// カフスボタン追加は使用不可
		jQuery('#os_AddCuff_id1').prop('checked', true);
		jQuery('#os_AddCuff_id2').prop('disabled', true);
	}
}



