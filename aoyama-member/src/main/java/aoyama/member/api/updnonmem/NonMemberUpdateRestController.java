package aoyama.member.api.updnonmem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aoyama.member.domain.model.NonMemberUpdateReqBean;
import aoyama.member.domain.model.NonMemberUpdateResBean;
import aoyama.member.domain.service.NonMemberUpdateApiService;

@RestController
public class NonMemberUpdateRestController {
    
    @Autowired
    private NonMemberUpdateApiService service;
    
    private static final Logger logger = LoggerFactory
            .getLogger(NonMemberUpdateRestController.class);
    
    @RequestMapping(value="updNonMem", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public NonMemberUpdateResBean NonMemberUpdate(@RequestBody NonMemberUpdateReqBean reqBean) {
        
        // update処理
        NonMemberUpdateResBean resBean = service.nonMemberUpdate(reqBean);
        if (resBean == null) {
            
            return null;
        }
        return resBean;
    }
}
