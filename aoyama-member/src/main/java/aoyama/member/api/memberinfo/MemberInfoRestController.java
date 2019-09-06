package aoyama.member.api.memberinfo;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aoyama.member.domain.service.MemberInfoApiService;
import aoyama.member.domain.model.MemberInfo;

@RestController
public class MemberInfoRestController {
    
    @Autowired
    private MemberInfoApiService service;

    @Autowired
    MessageSource messageSource;
    
    private static final Logger logger = LoggerFactory
            .getLogger(MemberInfoRestController.class);
    
    @RequestMapping(value="memInfo", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public MemberInfo getMemberInfo(@RequestParam("membersId") String membersId, @RequestParam("gyotaiCd") String gyotaiCd) {
        
        MemberInfo memberInfo = new MemberInfo();
        try {
            memberInfo = service.getMemberInfo(membersId, gyotaiCd);
        } catch(Exception e) {
            return null;
        }
        
        return memberInfo;
    }
}
