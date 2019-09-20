package co.jp.aoyama.macchinetta.domain.service.orderdetailenum;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import co.jp.aoyama.macchinetta.domain.model.MtbOrderDetailEnum;
import co.jp.aoyama.macchinetta.domain.repository.orderdetailenum.MtbOrderDetailEnumRepository;

/**
 * 
 * @author liufeng
 *
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class MtbOrderDetailEnumServiceImpl implements MtbOrderDetailEnumService {

	/** log */
	private static final Logger logger = LoggerFactory.getLogger(MtbOrderDetailEnumServiceImpl.class);

	@Inject
	MtbOrderDetailEnumRepository repository;

	@Override
	public List<MtbOrderDetailEnum> selectAll() {
		List<MtbOrderDetailEnum> list = repository.selectAll();
		logger.info("注文明細列挙体オブジェクトリスト件数:" + list.size());
		logger.info("注文明細列挙体オブジェクトリスト:" + JSON.toJSONString(list));
		return list;
	}

	@Override
	public List<MtbOrderDetailEnum> selectByFactoryPattern(String factory, String pattern) {
		List<MtbOrderDetailEnum> list = repository.selectByFactoryPattern(factory, pattern);
		logger.info("工場[" + factory + "]のパターン[" + pattern + "]の注文明細列挙体オブジェクトリスト件数:" + list.size());
		logger.info("工場[" + factory + "]のパターン[" + pattern + "]の注文明細列挙体オブジェクトリスト:" + JSON.toJSONString(list));
		return list;
	}

}
