package aoyama.member.api.nonmemberinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aoyama.member.domain.model.NonMemberDataReqBean;
import aoyama.member.domain.model.NonMemberDataResBean;
import aoyama.member.domain.service.NonMemberInfoApiService;

@RestController
public class NonMemberInfoRestController {
    
    @Autowired
    private NonMemberInfoApiService service;

    @Autowired
    MessageSource messageSource;
    
    private static final Logger logger = LoggerFactory
            .getLogger(NonMemberInfoRestController.class);
    
    @RequestMapping(value="nonmemInfo", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public NonMemberDataResBean getNonMemberInfo(@RequestBody NonMemberDataReqBean reqBean) {
        
    	NonMemberDataResBean NonMemberDataResBean = new NonMemberDataResBean();
        try {
        	NonMemberDataResBean = service.getNonMemberInfo(reqBean);
        } catch(Exception e) {
            return null;
        }
        
        return NonMemberDataResBean;
    }

}

