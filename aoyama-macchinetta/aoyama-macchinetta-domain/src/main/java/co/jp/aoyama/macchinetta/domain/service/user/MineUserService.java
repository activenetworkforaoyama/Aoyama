package co.jp.aoyama.macchinetta.domain.service.user;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.MineUser;

public interface MineUserService {
	MineUser findOne(String userId);
	
	MineUser loginSelect(MineUser user);
	
    List<MineUser> findAll();

    MineUser create(MineUser user);

    MineUser update(MineUser user);

    void delete(String userId);
    
    long exists(String userId);
    
}
