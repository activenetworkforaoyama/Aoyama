package aoyama.member.api.karte;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aoyama.member.domain.model.KarteUpdateReqBean;
import aoyama.member.domain.model.KarteUpdateResBean;
import aoyama.member.domain.service.KarteUpdateApiService;

@RestController
public class KarteUpdateRestController {
    
    @Autowired
    private KarteUpdateApiService service;
    
    private static final Logger logger = LoggerFactory
            .getLogger(KarteUpdateRestController.class);
    
    @RequestMapping(value="upKarte", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public KarteUpdateResBean karteUpdate(@RequestBody KarteUpdateReqBean reqBean) {
        
        // update処理
        KarteUpdateResBean resBean = service.karteUpdate(reqBean);
        if (resBean == null) {
            
            return null;
        }
        return resBean;
    }
}
