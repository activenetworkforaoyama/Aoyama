/*********************************************
 * タブメニュー用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initCustomer() {
	
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

