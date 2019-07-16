package co.jp.aoyama.macchinetta.domain.repository.user;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.model.MineUser;

public interface UserRepository {
    MineUser findOne(String userId);
    
    MineUser loginSelect(MineUser user);

    List<MineUser> findAll();

    void create(MineUser user);

    boolean update(MineUser user);

    void delete(MineUser user);
    
    long exists(String userId);
   
}


