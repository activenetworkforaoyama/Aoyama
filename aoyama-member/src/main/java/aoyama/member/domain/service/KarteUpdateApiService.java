package aoyama.member.domain.service;

import aoyama.member.domain.model.KarteUpdateReqBean;
import aoyama.member.domain.model.KarteUpdateResBean;
import aoyama.member.domain.model.KarteUpdateResBeanArray;

public interface KarteUpdateApiService {
    
    KarteUpdateResBean karteUpdate(KarteUpdateReqBean reqBean);
}
