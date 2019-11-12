package co.jp.aoyama.macchinetta.app.print;

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
 * 印刷画面
 * @author gaoxiang
 *
 */
@Controller
@RequestMapping(value = "/print")
public class printController {

    @Inject
    MineUserService userService;
    
    @Inject
    Mapper beanMapper;
    
    @Inject
    SessionContent sessionContent;
    
    private static final Logger logger = LoggerFactory
            .getLogger(printController.class);
    
    @ModelAttribute(value = "printForm")
	public PrintForm setupForm() {
    	return new PrintForm();
	}
  
    /**
     * 初期表示.
     * @return
     */
    @RequestMapping(value = "init")
    public String createForm() {
    	return "print/printForm";
	}
    

}
