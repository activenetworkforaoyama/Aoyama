package co.jp.aoyama.macchinetta.domain.service.userdetails;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import co.jp.aoyama.macchinetta.domain.model.MineUser;

public class MineUserDetails extends User {

	private static final long serialVersionUID = 3159215654358175137L;
	
	private final MineUser myUser;
	
	public MineUserDetails(MineUser mineUser, List<GrantedAuthority> roleList) {
		// Userクラスのコンストラクタを呼び出す。第1引数はユーザー名、第2引数はパスワード、第3引数は権限リストである。
		super(mineUser.getUserId(), mineUser.getUserPasswd(), roleList);
		this.myUser = mineUser;
	}

	public MineUser getMyUser() {
		return myUser;
	}

}
