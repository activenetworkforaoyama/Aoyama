package co.jp.aoyama.macchinetta.domain.service.user;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.domain.model.MineUser;
import co.jp.aoyama.macchinetta.domain.repository.user.UserRepository;

@Service
@Transactional
public class MineUserServiceImpl implements MineUserService {

	private static final long MAX_COUNT = 1;
	
	@Inject
    UserRepository userRepository;
	
    private static final Logger logger = LoggerFactory
            .getLogger(MineUserServiceImpl.class);

    /**
     * ユーザー IDにより、データを取得
     */
	@Override
	@Transactional(readOnly = true)
    public MineUser findOne(String userId) {
        MineUser userRec = userRepository.findOne(userId);

        if (userRec == null) {
            
            ResultMessages messages = ResultMessages.error();
            // 該当ユーザーのデータがありません。(userid={0})
            messages.add("E002", userId);
            logger.error(messages.toString());

            throw new ResourceNotFoundException(messages);
        }
        return userRec;
    }
	
	/**
	 * ユーザー IDとパスワードにより、データを取得
	 */
	@Override
	@Transactional(readOnly = true)
    public MineUser loginSelect(MineUser user) {
        MineUser userRec = userRepository.loginSelect(user);

        if (userRec == null) {
        	ResultMessages messages = ResultMessages.error();
        	// 該当ユーザーのデータがありません。(userid={0})
            messages.add("E002", user.getUserId());
            logger.error(messages.toString());

            throw new ResourceNotFoundException(messages);
        }
        return userRec;
    }
	
	/**
	 * 全部データを取得
	 */
	@Override
	@Transactional(readOnly = true)
	public List<MineUser> findAll() {
		
		return userRepository.findAll();
	}

	/**
	 * データを登録
	 */
	@Override
	public MineUser create(MineUser user) {
		long count = userRepository.exists(user.getUserId());
        if (count >= MAX_COUNT) {
            ResultMessages messages = ResultMessages.error();
            // 該当ユーザーが存在しています。(userid={0})
            messages.add("E003", user.getUserId());
            logger.error(messages.toString());
            
            throw new BusinessException(messages);
        }

        Date createdAt = new Date();
        //所属が01（店舗）の場合
        //user.setBelongCode("01");
        //権限 01：店舗
        //user.setAuthority("01");
        user.setCreatedAt(createdAt);
        user.setUpdatedAt(createdAt);
        userRepository.create(user);

        return user;
	}

	/**
	 * データを更新
	 */
	@Override
	public MineUser update(MineUser user) {
		long count = userRepository.exists(user.getUserId());
        if (count <= 0) {
            ResultMessages messages = ResultMessages.error();
            // 該当ユーザーのデータがありません。(userid={0})
            messages.add("E002", user.getUserId());
            logger.error(messages.toString());
            
            throw new BusinessException(messages);
        }
        Date createdAt = new Date();
        user.setUpdatedAt(createdAt);
        userRepository.update(user);
        return user;
	}

	/**
	 * データを削除
	 */
	@Override
	public void delete(String userId) {
		MineUser user = findOne(userId);
        userRepository.delete(user);

	}

	/**
	 * データ存在個数
	 */
	@Transactional(readOnly = true)
    @Override
	public long exists(String userId) {
			long count = userRepository.exists(userId);
			return count;
		}
	
}
