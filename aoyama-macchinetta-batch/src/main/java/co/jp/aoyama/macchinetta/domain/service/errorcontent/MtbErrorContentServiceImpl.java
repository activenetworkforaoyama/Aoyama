package co.jp.aoyama.macchinetta.domain.service.errorcontent;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import co.jp.aoyama.macchinetta.domain.model.MtbErrorContent;
import co.jp.aoyama.macchinetta.domain.repository.errorcontent.MtbErrorContentRepository;

/**
 * 
 * @author liufeng
 *
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class MtbErrorContentServiceImpl implements MtbErrorContentService {

	/** log */
	private static final Logger logger = LoggerFactory.getLogger(MtbErrorContentServiceImpl.class);

	@Inject
	MtbErrorContentRepository repository;

	@Override
	public List<MtbErrorContent> selectByFactoryPattern(String factory, String pattern) {
		List<MtbErrorContent> list = repository.selectByFactoryPattern(factory, pattern);
		logger.info("エラーメッセージオブジェクトリスト件数:" + list.size());
		logger.info("エラーメッセージオブジェクトリスト:" + JSON.toJSONString(list));
		return list;
	}

}
