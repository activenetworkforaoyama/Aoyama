/*********************************************
 * タブメニュー用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initCustomer() {
	// 納期短縮
	jQuery('#expediteDelivery').change(function(){
		var expediteDelivery = jQuery('#expediteDelivery').val();
		// 納期短縮と早割の両立はできないため、納期短縮が有の場合は早割を無に変更
		if (expediteDelivery == "1") {
			jQuery('#earlyDiscount').val('0');
		}
	});
	jQuery('#expediteDelivery').change();

	// 早割
	jQuery('#earlyDiscount').change(function(){
		var earlyDiscount = jQuery('#earlyDiscount').val();
		// 納期短縮と早割の両立はできないため、早割が有の場合は納期短縮を無に変更
		if (earlyDiscount == "1") {
			jQuery('#expediteDelivery').val('0');
		}
	});
	jQuery('#earlyDiscount').change();

	//出荷先
	var allShop = jQuery("#shopName");
	jQuery('#destination').change(function(){
		//他店舗コード:05
		var destination = jQuery('#destination').val();
		if (destination == "05") {
			var obj = document.getElementById("shopName");
			 obj.options.length=0;
			 obj.add(new Option("",""));
		        jQuery.ajax({
		            url: contextPath + "/orderCo/selectAllShop",
		            type: 'get',
		            async:false,
		            success: function(data){
		               jQuery.each(data, function (index, e) {
		                   obj.add(new Option(e.shopName,e.shopCode));
		               });
		               jQuery("#shopName").trigger("chosen:updated");
		               jQuery("#shopName").chosen({
		           	   disable_search_threshold: 10,
		           	   no_results_text: getMsg('msg085'),
		           	   width: "100%"
		           	   }); 
		            }
		        });
		    jQuery('#shopNameDiv').show();
		} else {
			jQuery("#shopName").val("");
			jQuery('#shopNameDiv').hide();
		}
	});
	jQuery('#destination').change();
}

//--------------------------------------------
// 部品
//--------------------------------------------
