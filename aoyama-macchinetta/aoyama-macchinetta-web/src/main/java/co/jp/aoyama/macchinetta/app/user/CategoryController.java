package co.jp.aoyama.macchinetta.app.user;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.Factory;
import co.jp.aoyama.macchinetta.domain.model.Maker;
import co.jp.aoyama.macchinetta.domain.model.MineUser;
import co.jp.aoyama.macchinetta.domain.model.Shop;
import co.jp.aoyama.macchinetta.domain.service.factory.FactoryService;
import co.jp.aoyama.macchinetta.domain.service.maker.MakerService;
import co.jp.aoyama.macchinetta.domain.service.shop.ShopService;
import co.jp.aoyama.macchinetta.domain.service.userdetails.MineUserDetails;

/**
 * 業態選択画面.
 * @author liuzhenyu
 *
 */
@Controller
@RequestMapping("category")
public class CategoryController {

	// 01：店舗
    public static final String SHOP_TYPE = "01";
    // 02：商品部
    public static final String DEPARTMENT_TYPE = "02";
    // 03：メーカー
    public static final String MAKER_TYPE = "03";
    // 04：工場
    public static final String FACTORY_TYPE = "04";
    // 05：千葉センター
    public static final String WAREHOUSE_TYPE = "05";
    // オーダーパタンPO
    public static final String PATTERN_PO = "PO";
    // オーダーパタンCO
    public static final String PATTERN_CO = "CO";

    @Inject
    SessionContent sessionContent;
    
    @Inject
	ShopService shopService;
    
    @Inject
	FactoryService factoryService;
    
    @Inject
	MakerService makerService;

    private static final Logger logger = LoggerFactory
            .getLogger(CategoryController.class);
    
    @ModelAttribute(value = "categoryForm")
	public CategoryForm setupForm() {
    	return new CategoryForm();
	}
    
    /**
     * 画面初期表示.
     * @return　画面のJSP名称
     */
    @RequestMapping(value = "init", method = RequestMethod.GET)
    public String init(Model model) {
    	
		// 認証されたユーザーのユーザー情報(UserDetailsインタフェースを実装したクラスのオブジェクト)を返却する
		MineUserDetails userDetails = (MineUserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();

		// ユーザー情報を取得
		MineUser user = userDetails.getMyUser();
		// ユーザー ID
		sessionContent.setUserId(user.getUserId());
		// 権限
		sessionContent.setAuthority(user.getAuthority());
		// 所属コード
		sessionContent.setBelongCode(user.getBelongCode());

		try {
			// 01：店舗の場合
	    	if (SHOP_TYPE.equals(user.getAuthority())) {
	    		
	    		Shop shop = shopService.findShopByPk(user.getBelongCode());
	    		// 所属コード名称
	    		sessionContent.setBelongName(shop.getShopName());
	    		// 店舗の業態（店舗のみ）
	    		sessionContent.setStoreBrandCode(shop.getStoreBrandCode());
	
	    	} else if (MAKER_TYPE.equals(user.getAuthority())) {
	    		
	    		// 03：メーカーの場合
	    		Maker maker = makerService.findOne(user.getBelongCode());
	    		// 所属コード名称
	    		sessionContent.setBelongName(maker.getMakerName());
	
	    	} else if (FACTORY_TYPE.equals(user.getAuthority())) {
	    		// 04：工場の場合
	    		Factory factory = factoryService.findOne(user.getBelongCode());
	    		// 所属コード名称
	    		sessionContent.setBelongName(factory.getFactoryName());
	    		
	    	} else if (DEPARTMENT_TYPE.equals(user.getAuthority())) {
	    		// 02：商品部の場合
	    		sessionContent.setBelongName("商品部");
	
	    	} else {
	    		// 05：千葉センターの場合
	    		sessionContent.setBelongName("千葉センター");
	
	    	}
		} catch (ResourceNotFoundException e) {
    		// メッセージリスト
	    	ResultMessages messages = e.getResultMessages();
			// エラーメッセージ
	    	model.addAttribute("resultMessages", messages);
	    	// ログを出力
	    	logger.error(messages.toString());
	    	// エラーの場合、ログイン画面べ遷移
	    	return "forward:/user/login";
        }
    	return "user/categoryForm";
	}
	
    /**
     * パターンオーダーを選択.
     * @param form　画面Form
     * @return　画面のJSP名称
     */
	@RequestMapping(value = "selectPO", method = RequestMethod.POST)
	public String selectPattern(@Validated CategoryForm form) {

		// オーダーパタン　ログイン時にPOを選択する
		sessionContent.setCategory(PATTERN_PO);

		return "redirect:/orderlist/init";

	}
	
	/**
	 * カスタムオーダーを選択.
	 * @param form　画面Form
	 * @return　画面のJSP名称
	 */
	@RequestMapping(value = "selectCO", method = RequestMethod.POST)
	public String selectCustom(@Validated CategoryForm form) {

		// オーダーパタン　ログイン時にCOを選択する
		sessionContent.setCategory(PATTERN_CO);

		return "redirect:/orderlist/init";

	}
}
