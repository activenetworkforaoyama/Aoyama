package co.jp.aoyama.macchinetta.app.password;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.message.MessageKeys;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.model.MineUser;
import co.jp.aoyama.macchinetta.domain.service.user.MineUserService;

/**
 * パスワード変更.
 * @author liuzhenyu
 *
 */
@Controller
@RequestMapping("password")
public class PasswordController {

    @Inject
    MineUserService userService;
    
    @Inject
    Mapper beanMapper;
    
    @Inject
    SessionContent sessionContent;
    
    private static final Logger logger = LoggerFactory
            .getLogger(PasswordController.class);
    
    @ModelAttribute(value = "passwordForm")
	public PasswordForm setupForm() {
    	return new PasswordForm();
	}
  
    /**
     * 初期表示.
     * @return
     */
    @RequestMapping(value = "init")
    public String createForm() {
    	return "password/passwordForm";
	}
    
    /**
     * 全部ユーザーを検索.
     * @return ユーザー情報リスト
     */
    @ResponseBody
    @RequestMapping(value = "selectAllUser", method = RequestMethod.GET)
    public List<MineUser> selectAllUser() {
    	
    	List<MineUser> userList = userService.findAll();
		return userList;

	}

    /**
     * パスワード更新.
     * @param form 画面Form
     * @param result　チェック結果
     * @param model model
     * @return 画面JSP名称
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
	public String loginSelect(@Validated PasswordForm form, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		return "password/passwordForm";
    	}
    	String userId = form.getMyUserId();
    	if (userId == null || userId.isEmpty()) {
    		userId = sessionContent.getUserId();
    	}
    	try {
	    	
	    	MineUser myUser = userService.findOne(userId);
	    	
	    	// メッセージリスト
	    	ResultMessages messages = ResultMessages.error();
	    	
	    	if (form.getMyPassword().equals(myUser.getUserPasswd())) {
	    		// パスワードが直前のパスワードと一致しています。
	        	messages.add(MessageKeys.E004); 
	    	}

	    	// エラーあり場合
	    	if (messages.isNotEmpty()) {
	    		model.addAttribute("resultMessages", messages);
	    		// ログを出力
		    	logger.error(messages.toString());
	    	} else {
		    	myUser.setUserPasswd(form.getMyPassword());
		    	myUser.setUpdatedUserId(userId);
	    	
	    		userService.update(myUser);
		    	
		    	// 処理完了の場合、提示ダイアログ
		    	ResultMessages infoMessages = ResultMessages.success();
		    	infoMessages.add(MessageKeys.I001, userId); 
		    	model.addAttribute("resultMessages", infoMessages);
	    	}

    	} catch (BusinessException e) {
    		// メッセージリスト
	    	ResultMessages messages = e.getResultMessages();
	    	messages.add(MessageKeys.E009, userId);
			// エラーメッセージ
	    	model.addAttribute("resultMessages", messages);
	    	// ログを出力
	    	logger.error(messages.toString());
        } catch (ResourceNotFoundException e) {
    		// メッセージリスト
	    	ResultMessages messages = e.getResultMessages();
	    	messages.add(MessageKeys.E009, userId);
			// エラーメッセージ
	    	model.addAttribute("resultMessages", messages);
	    	// ログを出力
	    	logger.error(messages.toString());
        }

    	return "password/passwordForm";
    }

}
