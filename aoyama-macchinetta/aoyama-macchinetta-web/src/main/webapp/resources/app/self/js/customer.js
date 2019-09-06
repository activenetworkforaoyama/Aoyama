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

function dateEarlyCheck(productFabricNo,item){
	if(isNotEmpty(productFabricNo)){
		//生地チェクフラッグ
		var fabricCheckValue = jQuery("#fabricFlag").val();
		fabricCheckValue = fabricCheckValue.split("*");
		//生地チェク成功の場合
		if(fabricCheckValue[0]=="0"){
			jQuery.ajax({
				 type:"get",
				 url: contextPath + "/order/findStock",
				 data:{"fabricNo":productFabricNo,"orderPattern":"CO"},
				 async:false,
				 success:function(result){
					 if(!isShopDeliveryEmpty(result,item)){
		         			setAlert('stockMsg', getMsgByOneArg('msg072',productFabricNo));
		         			//生地メッセージをクリア
		         			jQuery("#notice").empty();
		     			    jQuery("#fabric_brand_nm_p").empty();
		     			    jQuery("#service_nm_p").empty();
		     				jQuery("#compos_frt_fabric_p").empty();
		     				jQuery("#goodsPrice").html('0');
		       				jQuery("productPriceId").val("");
		       				jQuery("#theoryFabricUsedMountId").val("");
		       				jQuery("#fabricColor").val("");
							jQuery("#fabricPattern").val("");
							jQuery("#factoryCode").val("");
							jQuery("#custShopDeliveryDate").val("");
							jQuery("#makerCode").val("");
							jQuery("#fabricMsg").empty();
							jQuery("#threePiece_Msg").empty();
							jQuery("#sparePants_Msg").empty();
							jQuery("#jacketModel_Msg").empty();
							jQuery("#clothName_yes").removeAttr("disabled","disabled");
							allOptionPrice();
							//生地チェク失敗フラッグ
							fabricCheckValue = "1";
		     				jQuery("#fabricFlag").val(fabricCheckValue+"*"+getMsgByOneArg('msg072',productFabricNo));
		     			 }	 
				 }
			})
		}
	}
}