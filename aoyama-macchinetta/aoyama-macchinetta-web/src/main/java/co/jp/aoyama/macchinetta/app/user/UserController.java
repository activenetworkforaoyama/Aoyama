package co.jp.aoyama.macchinetta.app.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.app.message.MessageKeys;
import co.jp.aoyama.macchinetta.app.session.SessionContent;
import co.jp.aoyama.macchinetta.domain.service.user.MineUserService;

/**
 * ログインユーザー 登録画面.
 * @author liuzhenyu
 *
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Inject
    MineUserService userService;
    
    @Inject
    Mapper beanMapper;
    
    @Inject
    SessionContent sessionContent;
    
    private static final Logger logger = LoggerFactory
            .getLogger(UserController.class);
    
    @ModelAttribute(value = "userForm")
	public UserForm setupForm() {
    	return new UserForm();
	}
  
    /**
     * ログイン.
     * @return 画面JSP名称
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String createForm() {
    	return "user/userForm";
	}

    /**
     * ログイン失敗.
     * @param model model
     * @return　画面JSP名称
     */
    @RequestMapping(value = "loginFailure", method = {RequestMethod.POST, RequestMethod.GET})
    public String loginFailure(Model model) {
    	
    	ResultMessages messages = ResultMessages.error();

		// ユーザー ID、またはパスワードが間違っています。
    	messages.add(MessageKeys.E001); 

    	model.addAttribute("resultMessages", messages);
    	
    	logger.error(messages.toString());

    	return "user/userForm";

	}
    
    /**
     * 無効なセッション.
     * @param reqeust
     * @param response
     * @return String
     */
    @RequestMapping(value = "invalidateSession")
    @ResponseBody
    public String invalidateSession(HttpServletRequest reqeust,HttpServletResponse response) {
    	 String ajaxHeader = reqeust.getHeader("X-Requested-With");
	        boolean isAjax = "XMLHttpRequest".equals(ajaxHeader);
	        // Ajax Requestの場合
	        if (isAjax) {
	        	return "invalidSession";
	        } else {
	        	// form actionの場合
	        	try {
					response.sendRedirect(reqeust.getContextPath()+ "/user/login");
				} catch (IOException e) {
					e.printStackTrace();
					logger.error(e.toString());
				}
	        }
	        return "";
    }

}
