package aoyama.member.domain.service;

import aoyama.member.domain.model.MemberInfo;

public interface MemberInfoApiService {
    
    MemberInfo getMemberInfo(String membersId, String userId);
}
