package co.jp.aoyama.macchinetta.domain.service.errshanghaifuliang;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import co.jp.aoyama.macchinetta.domain.model.MtbErrShanghaiFuliang;
import co.jp.aoyama.macchinetta.domain.repository.errshanghaifuliang.MtbErrShanghaiFuliangRepository;

/**
 * 
 * @author liufeng
 *
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class MtbErrShanghaiFuliangServiceImpl implements MtbErrShanghaiFuliangService {

	/** log */
	private static final Logger logger = LoggerFactory.getLogger(MtbErrShanghaiFuliangServiceImpl.class);

	@Inject
	MtbErrShanghaiFuliangRepository repository;

	@Override
	public List<MtbErrShanghaiFuliang> selectAll() {
		List<MtbErrShanghaiFuliang> list = repository.selectAll();
		logger.info("上海服良エラーメッセージオブジェクトリスト件数:" + list.size());
		logger.info("上海服良エラーメッセージオブジェクトリスト:" + JSON.toJSONString(list));
		return list;
	}

}
