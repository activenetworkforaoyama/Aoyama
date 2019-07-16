package co.jp.aoyama.macchinetta.app.cash;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("/cashResult")
public class CashResultController {
	
	@Inject
	Mapper beanMapper;
	
	private CashForm cashForm = new  CashForm();
	

	@ModelAttribute
	public CashForm setupCashForm() {
		return cashForm;
	}
	
	@RequestMapping(value = "cashResultForm")
	public String toCashResultForm(Model model,SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "cash/cashResultForm";
	}

}
