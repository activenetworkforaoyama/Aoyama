package aoyama.member.domain.service;

import aoyama.member.domain.model.NonMemberUpdateReqBean;
import aoyama.member.domain.model.NonMemberUpdateResBean;

public interface NonMemberUpdateApiService {
    
	public NonMemberUpdateResBean nonMemberUpdate(NonMemberUpdateReqBean reqBean);

}
