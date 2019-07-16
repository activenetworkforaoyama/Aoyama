package co.jp.aoyama.macchinetta.domain.service.userdetails;

import javax.inject.Inject;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import co.jp.aoyama.macchinetta.domain.model.MineUser;
import co.jp.aoyama.macchinetta.domain.service.user.MineUserService;

@Service
public class MineUserDetailsService implements UserDetailsService {

	@Inject
	MineUserService mineUserService;
	
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MineUserDetails mineUserDetails = null;
		try {
			MineUser mineUser = mineUserService.findOne(username);
			// 01：店舗
			if ("01".equals(mineUser.getAuthority())) {
				mineUserDetails = new MineUserDetails(mineUser, AuthorityUtils.createAuthorityList("ROLE_SHOP"));
			// 02：商品部の場合
			} else if ("02".equals(mineUser.getAuthority())) {
				mineUserDetails = new MineUserDetails(mineUser, AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
			// 03：メーカー
			} else if ("03".equals(mineUser.getAuthority())){
				mineUserDetails = new MineUserDetails(mineUser, AuthorityUtils.createAuthorityList("ROLE_MAKER"));
			// 04：工場
			} else if ("04".equals(mineUser.getAuthority())){
				mineUserDetails = new MineUserDetails(mineUser, AuthorityUtils.createAuthorityList("ROLE_FACTORY"));
			// 05：千葉センター
			}else {
				mineUserDetails = new MineUserDetails(mineUser, AuthorityUtils.createAuthorityList("ROLE_OTHER"));
			}
            
        } catch (ResourceNotFoundException e) {
            throw new UsernameNotFoundException("user not found", e);
        }

		return mineUserDetails;
	}

}
