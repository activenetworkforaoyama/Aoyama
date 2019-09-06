package co.jp.aoyama.macchinetta.domain.service.member;

import co.jp.aoyama.macchinetta.domain.model.MemberName;

public interface MemberNameService {

	MemberName execute(String memberUrl, String kokNo, String gyotaiCd);
	
}
