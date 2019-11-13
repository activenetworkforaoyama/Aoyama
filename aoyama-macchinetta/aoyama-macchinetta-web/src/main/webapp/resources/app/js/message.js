/**
 * messages.propertiesファイルの取込
 * @returns　ファイルの内容
 */
function load() {
	var cxtPath = jQuery("meta[name='contextPath']").attr("content");
	jQuery.i18n.properties({
        name:'messages',
        path:cxtPath+'/resources/app/message/',
        mode:'map' 
    }); 
}

/**
 * 取得メッセージ内容
 * @param msgId　メッセージID
 * @returns メッセージ内容
 */
function getMsg(msgId){
	load();
    return jQuery.i18n.prop(msgId);
}

/**
 * 取得メッセージ内容
 * @param msgId メッセージID
 * @param arg メッセージのパラメータ{0}
 * @returns メッセージ内容
 */
function getMsgByOneArg(msgId, arg){
	load();
    return jQuery.i18n.prop(msgId, arg);
}

/**
 * 取得メッセージ内容
 * @param msgId メッセージID
 * @param arg1 メッセージのパラメータ{0}
 * @param arg2 メッセージのパラメータ{1}
 * @returns メッセージ内容
 */
function getMsgByTwoArgs(msgId, arg1, arg2){
	load();
    return jQuery.i18n.prop(msgId, arg1, arg2);
}

/**
 * 取得メッセージ内容
 * @param msgId メッセージID
 * @param arg1 メッセージのパラメータ{0}
 * @param arg2 メッセージのパラメータ{1}
 * @param arg3 メッセージのパラメータ{2}
 * @returns メッセージ内容
 */
function getMsgByThreeArgs(msgId, arg1, arg2, arg3){
	load();
    return jQuery.i18n.prop(msgId, arg1, arg2, arg3);
}

/**
 * エラーメッセージのヒントボックス
 * @param id メッセージヒントボックスのID
 * @param errMsg　メッセージ内容
 * @returns 
 */
function appendAlert(id,errMsg){
	var s=document.getElementById(id);
	s.removeAttribute("style");
	s.innerHTML = errMsg;
}


/**
 * クリアエラーメッセージ
 * @param id メッセージヒントボックスのID
 * @returns
 */
function appendAlertDel(id) {
	var s=document.getElementById(id);
	s.style.display = "none";
	jQuery('#'+id).empty();
}

/**
 * 値がnull、空白ではないチェック
 * @param argValue パラメータ
 * @returns true/false
 */
function isNotEmpty(argValue) {
	  if (argValue == "" || argValue == null) {
	    return false;
	  }
	  return true;
}

/**
 * 値がnull、空白のチェック
 * @param argValue パラメータ
 * @returns true/false
 */
function isEmpty(argValue) {
	  if (argValue == "" || argValue == null) {
	    return true;
	  }
	  return false;
}

/**
 * 半角数字チェック
 * @param argValue パラメータ
 * @returns true/false
 */
function isNumeric(argValue) {
	  if (argValue.match(/^[0-9]+$/g)) {
	    return false;
	  } else {
	    return true;
	  }
}

/**
 * 半角数字チェック（小数を含む）
 * @param argValue　パラメータ
 * @returns　true/false
 */
function isNumericDecimal(argValue) {
	  if (argValue.match(/^[0-9]+(.[0-9]+)?$/g)) {
	    return false;
	  } else {
	    return true;
	  }
}

/**
 * 半角英数字チェック
 * @param argValue パラメータ
 * @returns true/false
 */
function isAlphabetNumeric(argValue) {
	  if (argValue.match(/^[A-Za-z0-9]+$/g)) {
	    return false;
	  } else {
	    return true;
	  }
	}

/**
 * 半角英文チェック
 * @param argValue パラメータ
 * @returns true/false
 */
function isAlphabet(argValue) {
	  if (argValue.match(/^[A-Za-z]+$/g)) {
	    return false;
	  } else {
	    return true;
	  }
	}

/**
 * 全角文字チェック
 * @param argVlaue パラメータ
 * @returns true/false
 */
function isFullCharacters(argVlaue) {

	var cArr =argVlaue.match(/[^\x00-\xff|\uff61-\uff9f]/ig);

	return (cArr==null ? true : false);

}

/**
 * 文字チェック 
 * @param argVlaue パラメータ
 * @returns true/false
 */
function charactersCheck(argVlaue) {
	var patrn = /[!'"#$%&`()=~^¥<>,]/im;
	if (patrn.test(argVlaue)) {
		   return true;

    }else{
    	 return false;
    }
}

/**2019/9/25 
 * 文字チェック 刺繍ネーム
 * @param argVlaue パラメータ
 * @returns true/false
 */
function embroideryNameCheck(argVlaue) {
	var patrn = /(^$)|^[ a-z0-9A-Z!@&$():;.”?*#’\[\]\/-]+$/g;
	
	if (patrn.test(argVlaue)) {
		   return true;
    }else{
    	 return false;
    }
}

/**2019/9/25 
 * 文字チェック 刺繍ネーム
 * @param argVlaue パラメータ
 * @returns true/false
 */
function embroideryCoNameCheck(argVlaue) {
	var patrn = /(^$)|^[ a-z0-9A-Z!”&’().\/?-]+$/g;
	
	if (patrn.test(argVlaue)) {
		   return true;
    }else{
    	 return false;
    }
}


//function charactersCheck(argVlaue) {
//	var patrn = /[`~!@#$%^&*()_\-+=<>?:"{}|,.\/;'\\[\]·~！@#￥%……&*（）——\-+={}|《》？：“”【】、；‘’，。、]/im;
//	if (patrn.test(argVlaue)) {
//		   return true;
//
//    }else{
//    	 return false;
//    }
//}

/**
 * 全角カナチェック
 * @param argVlaue パラメータ
 * @returns true/false
 */
function kanaChk(argVlaue) {
    if(argVlaue.match(/[^ア-ンァャュョヴ　－]/)) {
        return true;
    }
    return false;
}

/**
 * エラーメッセージを追加
 * @param errorMsgId メッセージヒントボックスのID
 * @param subErrorMsgId 子メッセージヒントボックスのID
 * @param message メッセージ内容
 * @returns
 */
function addAlert(errorMsgId, subErrorMsgId, message) {
	jQuery('#'+errorMsgId).removeAttr('style');
	if (jQuery('#'+subErrorMsgId).length == 0){
		var alertElem = jQuery(
			'<div id="'+ subErrorMsgId +'">' +
			'<i class="fa fa-exclamation-triangle"></i> ' + message +
			'</div>');
		alertElem.appendTo('#'+errorMsgId);
		alertElem.fadeIn(500);
	}
}

/**
 * エラーメッセージを削除
 * @param errorMsgId メッセージヒントボックスのID
 * @param subErrorMsgId 子メッセージヒントボックスのID
 * @returns
 */
function closeAlert(errorMsgId, subErrorMsgId) {
	jQuery('#'+subErrorMsgId).remove();
    if ( jQuery('#'+errorMsgId).html().length == 0){
    	jQuery('#'+errorMsgId).hide();
    }
}

