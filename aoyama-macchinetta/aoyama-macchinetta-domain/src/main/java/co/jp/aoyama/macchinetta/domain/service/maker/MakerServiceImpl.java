package co.jp.aoyama.macchinetta.domain.service.maker;

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

import co.jp.aoyama.macchinetta.domain.model.Maker;
import co.jp.aoyama.macchinetta.domain.repository.maker.MakerRepository;

@Service
@Transactional
public class MakerServiceImpl implements MakerService {

	
	@Inject
	MakerRepository makerRepository;
	
	private static final Logger logger = LoggerFactory
            .getLogger(MakerServiceImpl.class);
	
	@Override
	@Transactional(readOnly = true)
    public Maker findOne(String makerCode) {
		Maker maker = makerRepository.findOne(makerCode);

        if (maker == null) {
            ResultMessages messages = ResultMessages.error();
            // 該当メーカーのデータがありません。(userid={0})
            messages.add("E017", makerCode);
            logger.error(messages.toString());

            throw new ResourceNotFoundException(messages);
        }
        return maker;
    }
	
	@Override
	@Transactional(readOnly = true)
	public List<Maker> findAll() {
		
		return makerRepository.findAll();
	}

	@Override
	public List<Maker> fuzzyQuery(Maker maker) {
		return makerRepository.fuzzyQuery(maker.getMakerCode(),maker.getMakerName());
	}

	@Override
	public void deleteMakerByKey(List<Maker> makerDelList) {
		makerRepository.deleteMakerByKey(makerDelList);
		
	}

	@Override
	public Boolean updateMakerByKey(List<Maker> makerList) {
		List<Maker> makerInsertList = new ArrayList<Maker>();
		List<Maker> makerUpdList = new ArrayList<Maker>();
		for (Maker maker : makerList) {
			// "1"は更新区分
			if("1".equals(maker.getOptionType())) {
				Maker makerFind = makerRepository.findOne(maker.getMakerCode());
				if (makerFind != null) {
					makerUpdList.add(maker);
					}
				else {
					ResultMessages messages = ResultMessages.error();
					//該当メーカーのデータがありません。(userid={0})
		            messages.add("E017", maker.getMakerCode());
		            logger.error(messages.toString());

		            throw new ResourceNotFoundException(messages);
				}
			}
			//　"2"は挿入区分
			else if("2".equals(maker.getOptionType())) {
				Maker makerFind = makerRepository.findOne(maker.getMakerCode());
				if(makerFind == null) {
					maker.setCreatedAt(new Date());
					maker.setCreatedUserId(maker.getUpdatedUserId());
					maker.setUpdatedAt(new Date());
					makerInsertList.add(maker);
				}
			}
		}
		
		if(makerInsertList.size() != 0) {
			makerRepository.insertMakerByKey(makerInsertList);
		}
		
		if(makerUpdList.size() != 0) {
			makerRepository.updateMakerByKey(makerUpdList);
		}
		return true;
		
	}

	@Override
	public Boolean makerIsExist(String makerCode) {
		Maker findOne = makerRepository.findOne(makerCode);
		if(findOne == null) {
			return false;
		}
		return true;
	}

}
