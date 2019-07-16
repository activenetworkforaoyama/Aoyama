package co.jp.aoyama.macchinetta.domain.service.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.domain.model.Factory;
import co.jp.aoyama.macchinetta.domain.repository.factory.FactoryRepository;

@Service
@Transactional
public class FactoryServiceImpl implements FactoryService {

	@Inject
	FactoryRepository aoyamaRepositoryFactory;

	private static final Logger logger = LoggerFactory
            .getLogger(FactoryServiceImpl.class);
	
	@Override
	@Transactional(readOnly = true)
    public Factory findOne(String factoryCode) {
		Factory aoyamafactory = aoyamaRepositoryFactory.findOne(factoryCode);

        if (aoyamafactory == null) {
            ResultMessages messages = ResultMessages.error();
            // 該当工場のデータがありません。(userid={0})
            messages.add("E016", factoryCode);
            logger.error(messages.toString());

            throw new ResourceNotFoundException(messages);
        }
        return aoyamafactory;
    }
	
	@Override
	@Transactional(readOnly = true)
	public List<Factory> findAll() {
		return aoyamaRepositoryFactory.findAll();
	}

	// Factoryに複数データを更新、追加
	@Override
	public Boolean updateFactoryByKey(List<Factory> factoryList) {
		for (Factory factory : factoryList) {
			System.out.println(factory.getOptionType());
		}
		List<Factory> factoryInsertList = new ArrayList<Factory>();
		List<Factory> factoryUpdList = new ArrayList<Factory>();
		for (Factory factory : factoryList) {
			// "1"は更新区分
			if("1".equals(factory.getOptionType())) {
				Factory factoryFind = aoyamaRepositoryFactory.findOne(factory.getFactoryCode());
				if(factoryFind != null) {
					factoryUpdList.add(factory);
				}else {
					ResultMessages messages = ResultMessages.error();
					// 該当工場のデータがありません。(userid={0})
		            messages.add("E016", factory.getFactoryCode());
		            logger.error(messages.toString());

		            throw new ResourceNotFoundException(messages);
				}
			}
			//　"2"は挿入区分
			else if("2".equals(factory.getOptionType())) {
				Factory factoryFind = aoyamaRepositoryFactory.findOne(factory.getFactoryCode());
				if(factoryFind == null) {
					factory.setCreatedAt(new Date());
					factory.setCreatedUserId(factory.getUpdatedUserId());
					factory.setUpdatedAt(new Date());
					factoryInsertList.add(factory);
				}
			}
		}
		if (factoryInsertList.size() != 0) {
			aoyamaRepositoryFactory.insertFactoryBykey(factoryInsertList);
		}

		if (factoryUpdList.size() != 0) {
			aoyamaRepositoryFactory.updateFactoryByKey(factoryUpdList);
		}

		return true;
	}

	// Factoryに複数データを削除
	@Override
	public void deleteFactoryBykey(List<Factory> factorydelList) {
		aoyamaRepositoryFactory.deleteFactoryBykey(factorydelList);
	}

	@Override
	public List<Factory> fuzzyQuery(Factory factory) {
		List<Factory> factoryList = aoyamaRepositoryFactory.fuzzyQuery(factory.getFactoryCode(),factory.getFactoryName());
		return factoryList;
	}

	@Override
	public Boolean factoryIsExist(String factoryCode) {
		Factory aoyamafactory = aoyamaRepositoryFactory.findOne(factoryCode);
		if(aoyamafactory == null) {
			return false;
		}
		return true;
	}

}
