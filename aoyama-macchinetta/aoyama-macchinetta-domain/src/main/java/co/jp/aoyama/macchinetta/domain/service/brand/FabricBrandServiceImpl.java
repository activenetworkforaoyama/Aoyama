package co.jp.aoyama.macchinetta.domain.service.brand;

import java.text.DecimalFormat;
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

import co.jp.aoyama.macchinetta.domain.model.FabricBrand;
import co.jp.aoyama.macchinetta.domain.repository.brand.FabricBrandRepository;

@Service
@Transactional
public class FabricBrandServiceImpl implements FabricBrandService {
	
	@Inject
	FabricBrandRepository fabricBrandRepository;
	
	private static final Logger logger = LoggerFactory
            .getLogger(FabricBrandServiceImpl.class);

	@Override
	public List<FabricBrand> findAllFabricBrand() {
		List<FabricBrand> fabricBrandList = fabricBrandRepository.findAllFabricBrand();
		return fabricBrandList;
	}

	@Override
	public List<FabricBrand> fuzzyQuery(FabricBrand fabricBrand) {
		List<FabricBrand> fabricBrandList = fabricBrandRepository.fuzzyQuery(fabricBrand.getBrandName(), fabricBrand.getCountryName());
		return fabricBrandList;
	}

	@Override
	public List<FabricBrand> updateFabricBrandByPk(List<FabricBrand> fabricBrandList) {
		List<FabricBrand> fabricBrandInsertList = new ArrayList<FabricBrand>();
		List<FabricBrand> fabricBrandUpdList = new ArrayList<FabricBrand>();
		int num = 1;
		for(int i=0;i<fabricBrandList.size();i++) {
			FabricBrand fabricBrand = fabricBrandList.get(i);
			// "1"は更新区分
			if("1".equals(fabricBrand.getOptionType())) {
				FabricBrand fabricBrandFind = fabricBrandRepository.findFabricBrandByPk(fabricBrand.getFablicBrandNo());
				if(fabricBrandFind != null) {
					fabricBrand.setUpdatedAt(new Date());
					fabricBrandUpdList.add(fabricBrand);
				}else {
					ResultMessages messages = ResultMessages.error();
					
		            messages.add("E014", fabricBrand.getFablicBrandNo());
		            
		            logger.error(messages.toString());

		            throw new ResourceNotFoundException(messages);
				}
			}
			//　"2"は挿入区分
			else if("2".equals(fabricBrand.getOptionType())) {
				String fablicBrandNo = this.findMaxNo();
				if(fablicBrandNo == null) {
					fablicBrandNo ="00000";
					DecimalFormat brandNo=new DecimalFormat("00000");
					String maxNo = brandNo.format(Integer.parseInt(fablicBrandNo) + num);
					fabricBrand.setFablicBrandNo(maxNo);
				}else {
					DecimalFormat brandNo=new DecimalFormat("00000");
					String maxNo = brandNo.format(Integer.parseInt(fablicBrandNo) + num);
					
					fabricBrand.setFablicBrandNo(maxNo);
				}
				FabricBrand fabricBrandFind = fabricBrandRepository.findFabricBrandByPk(fabricBrand.getFablicBrandNo());
				if(fabricBrandFind == null) {
					fabricBrand.setCreatedAt(new Date()); 
					fabricBrand.setUpdatedAt(new Date());
					fabricBrand.setCreatedUserId(fabricBrand.getUpdatedUserId());
					fabricBrandInsertList.add(fabricBrand);
					num = num + 1;
				}else {
					ResultMessages messages = ResultMessages.error();
					// 該当生地ブランドのデータがありません
		            messages.add("E014", fabricBrand.getFablicBrandNo());
		            
		            logger.error(messages.toString());

		            throw new ResourceNotFoundException(messages);
				}
			}
		}
		if(fabricBrandInsertList.size()!=0) {
			fabricBrandRepository.insertFabricBrandByKey(fabricBrandInsertList);
		}
		
		if(fabricBrandUpdList.size()!=0) {
			fabricBrandRepository.updateFabricBrandByKey(fabricBrandUpdList);
		}
		return fabricBrandList;
	}

	@Override
	public FabricBrand findFabricBrandByPk(String fablicBrandNo) {
		FabricBrand fabricBrand = fabricBrandRepository.findFabricBrandByPk(fablicBrandNo);
		if(fabricBrand != null) {
			ResultMessages messages = ResultMessages.error();
			// 該当生地ブランドのデータがありません
			messages.add("E014", fablicBrandNo);
            
            logger.error(messages.toString());

            throw new ResourceNotFoundException(messages);
		}
		return fabricBrand;
	}

	@Override
	public void deleteFabricBrandByPk(List<FabricBrand> fabricBrandList) {
		fabricBrandRepository.deleteFabricBrandByKey(fabricBrandList);		
	}

	@Override
	public String findMaxNo() {
		String MaxNo = fabricBrandRepository.findMaxNo();
		return MaxNo;
	}

	@Override
	public Boolean fabricBrandIsExist(String fablicBrandNo) {
		FabricBrand findOne = fabricBrandRepository.findFabricBrandByPk(fablicBrandNo);
		if(findOne == null) {
			return false;
		}
		return true;
	};

}
