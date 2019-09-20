package co.jp.aoyama.macchinetta.domain.service.optionenum;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import co.jp.aoyama.macchinetta.domain.model.MtbOptionEnum;
import co.jp.aoyama.macchinetta.domain.repository.optionenum.MtbOptionEnumRepository;

/**
 * 
 * @author liufeng
 *
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class MtbOptionEnumServiceImpl implements MtbOptionEnumService {

	/** log */
	private static final Logger logger = LoggerFactory.getLogger(MtbOptionEnumServiceImpl.class);

	@Inject
	MtbOptionEnumRepository repository;

	@Override
	public List<MtbOptionEnum> selectAll() {
		List<MtbOptionEnum> list = repository.selectAll();
		logger.info("オプション列挙体オブジェクトリスト件数:" + list.size());
		logger.info("オプション列挙体オブジェクトリスト:" + JSON.toJSONString(list));
		return list;
	}

	@Override
	public List<MtbOptionEnum> selectByTypeFactoryPattern(String type, String factory, String pattern) {
		List<MtbOptionEnum> list = repository.selectByTypeFactoryPattern(type, factory, pattern);
		logger.info("工場[" + factory + "]のパターン[" + pattern + "]のオプション[" + type + "]列挙体オブジェクトリスト件数:" + list.size());
		logger.info("工場[" + factory + "]のパターン[" + pattern + "]のオプション[" + type + "]列挙体オブジェクトリスト:" + JSON.toJSONString(list));
		return list;
	}

}
