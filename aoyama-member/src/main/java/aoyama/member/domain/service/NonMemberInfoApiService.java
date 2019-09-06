package aoyama.member.domain.service;

import aoyama.member.domain.model.NonMemberDataReqBean;
import aoyama.member.domain.model.NonMemberDataResBean;

public interface NonMemberInfoApiService {
    
	NonMemberDataResBean getNonMemberInfo(NonMemberDataReqBean reqBean);
}
