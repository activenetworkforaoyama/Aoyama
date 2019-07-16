package co.jp.aoyama.macchinetta.app.warn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/warn")
public class WarnController {

	
	// 未登録データ提示一覧
    @RequestMapping(value = "init", method = RequestMethod.GET)
    public String init() {
    	return "warn/warnForm";
    }
}
