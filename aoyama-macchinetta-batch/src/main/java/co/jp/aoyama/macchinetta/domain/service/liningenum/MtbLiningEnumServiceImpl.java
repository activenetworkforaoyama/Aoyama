package co.jp.aoyama.macchinetta.domain.service.liningenum;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import co.jp.aoyama.macchinetta.domain.model.MtbLiningEnum;
import co.jp.aoyama.macchinetta.domain.repository.liningenum.MtbLiningEnumRepository;

/**
 * 
 * @author liufeng
 *
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class MtbLiningEnumServiceImpl implements MtbLiningEnumService {

	/** log */
	private static final Logger logger = LoggerFactory.getLogger(MtbLiningEnumServiceImpl.class);

	@Inject
	MtbLiningEnumRepository repository;

	@Override
	public List<MtbLiningEnum> selectAll() {
		List<MtbLiningEnum> list = repository.selectAll();
		logger.info("胴裏列挙体オブジェクトリスト件数:" + list.size());
		logger.info("胴裏列挙体オブジェクトリスト:" + JSON.toJSONString(list));
		return list;
	}

	@Override
	public List<MtbLiningEnum> selectByFactoryPattern(String factory, String pattern) {
		List<MtbLiningEnum> list = repository.selectByFactoryPattern(factory, pattern);
		logger.info("工場[" + factory + "]のパターン[" + pattern + "]の胴裏列挙体オブジェクトリスト件数:" + list.size());
		logger.info("工場[" + factory + "]のパターン[" + pattern + "]の胴裏列挙体オブジェクトリスト:" + JSON.toJSONString(list));
		return list;
	}

}
