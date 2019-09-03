/*********************************************
 * タブメニュー用JS
 *********************************************/
//--------------------------------------------
// 読み込み時
//--------------------------------------------
function initTabMenu() {

	jQuery('a[id^="nav1_"]').each(function() {
		jQuery(this).click(function(){
			if (jQuery(this).hasClass('active')) {
				return false;
			}
			var id = this.id;
			jQuery('a[id^="nav1_"]').each(function(index, element) {
				if (element.id == id) {
					jQuery(element).addClass("active");
				} else {
					jQuery(element).removeClass("active");
					jQuery('#'+element.id+'_div').hide();
				}
			});
			jQuery('#'+id+'_div').fadeIn(200);
			return false;
		});

		if (!jQuery(this).hasClass('active')) {
			jQuery('#'+this.id+'_div').hide();
		}
	});
	jQuery('a[id^="nav2_"]').each(function() {
		jQuery(this).click(function(){
			if (jQuery(this).hasClass('acrive')) {
				return false;
			}
			var id = this.id;
			jQuery('a[id^="nav2_"]').each(function(index, element) {
				if (element.id == id) {
					jQuery(element).addClass("active");
				} else {
					jQuery(element).removeClass("active");
					jQuery('#'+element.id+'_div').hide();
				}
			});
			jQuery('#'+id+'_div').fadeIn(200);
			return false;
		});

		if (!jQuery(this).hasClass('active')) {
			jQuery('#'+this.id+'_div').hide();
		}
	});
}

//--------------------------------------------
// 部品
//--------------------------------------------
