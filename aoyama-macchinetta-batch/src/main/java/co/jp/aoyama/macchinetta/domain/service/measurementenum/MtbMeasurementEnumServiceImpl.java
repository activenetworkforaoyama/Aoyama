package co.jp.aoyama.macchinetta.domain.service.measurementenum;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import co.jp.aoyama.macchinetta.domain.model.MtbMeasurementEnum;
import co.jp.aoyama.macchinetta.domain.repository.measurementenum.MtbMeasurementEnumRepository;

/**
 * 
 * @author liufeng
 *
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class MtbMeasurementEnumServiceImpl implements MtbMeasurementEnumService {

	/** log */
	private static final Logger logger = LoggerFactory.getLogger(MtbMeasurementEnumServiceImpl.class);

	@Inject
	MtbMeasurementEnumRepository repository;

	@Override
	public List<MtbMeasurementEnum> selectAll() {
		List<MtbMeasurementEnum> list = repository.selectAll();
		logger.info("補正列挙体オブジェクトリスト件数:" + list.size());
		logger.info("補正列挙体オブジェクトリスト:" + JSON.toJSONString(list));
		return list;
	}

	@Override
	public List<MtbMeasurementEnum> selectByFactoryPattern(String factory, String pattern) {
		List<MtbMeasurementEnum> list = repository.selectByFactoryPattern(factory, pattern);
		logger.info("工場[" + factory + "]のパターン[" + pattern + "]の補正列挙体オブジェクトリスト件数:" + list.size());
		logger.info("工場[" + factory + "]のパターン[" + pattern + "]の補正列挙体オブジェクトリスト:" + JSON.toJSONString(list));
		return list;
	}

}
