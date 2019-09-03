/*********************************************
 * 共通処理用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initCommon() {

	// 全選択ボタン
	jQuery('button[id^="btn_as_"]').each(function() {
		jQuery(this).click(function(){
			var targetId = this.id.substring(7);
			jQuery('input[id^="'+targetId+'"]').each(function() {
				if (!jQuery(this).prop("disabled")) {
					jQuery(this).prop("checked", true);
					jQuery(this).change();
				}
			});
		});
	});

	// 全解除ボタン
	jQuery('button[id^="btn_ar_"]').each(function() {
		jQuery(this).click(function(){
			var targetId = this.id.substring(7);
			jQuery('input[id^="'+targetId+'"]').each(function() {
				if (!jQuery(this).prop("disabled")) {
					jQuery(this).prop("checked", false);
					jQuery(this).change();
				}
			});
		});
	});
	
	// standardSelect
	/*jQuery(".standardSelect").chosen({
		disable_search_threshold: 10,
		no_results_text: "Oops, nothing found!",
		width: "100%"
	});*/
}

//--------------------------------------------
// 部品
//--------------------------------------------
// 指定したIDの要素にアラートを挿入する
function appendAlertCo(id, message) {
	var alertElem = jQuery(
		'<div class="alert alert-warning alert-dismissible" role="alert" style="display:none;">' +
		'<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
//		'<strong><i class="fa fa-exclamation-triangle"></i></strong> ' + message +
		'<i class="fa fa-exclamation-triangle"></i> ' + message +
		'</div>');
	alertElem.appendTo('#'+id);
	alertElem.fadeIn(500);
}

// 指定したIDの要素にアラートを表示する ※既にあるメッセージは破棄する
function setAlert(id, message) {
	// メッセージ要素のクリア
	clearAlert(id);
	// メッセージ要素を作成
	var alertElem = jQuery(
		'<div class="alert alert-warning alert-dismissible" role="alert" style="display:none;">' +
		'<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
//		'<strong><i class="fa fa-exclamation-triangle"></i></strong> ' + message +
		'<i class="fa fa-exclamation-triangle"></i> ' + message +
		'</div>');
	alertElem.appendTo('#'+id);
	alertElem.fadeIn(500);
}
// 指定したIDの要素にアラートを削除する
function clearAlert(id) {
		// メッセージ要素のクリア
	var TargetElem = jQuery('#'+id);
	TargetElem.empty();
}