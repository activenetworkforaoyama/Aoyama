package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.NextGenerationPrice;
import co.jp.aoyama.macchinetta.domain.repository.order.NextGenerationRepository;

@Service
@Transactional
public class NextGenerationServiceImpl implements NextGenerationService{
	
	@Inject
	NextGenerationRepository nextGenerationRepository;

	@Override
	public List<NextGenerationPrice> selectOptionNextGenerationPrice(String jkSubItemCode, String gtSubItemCode,
			String ptSubItemCode, String pt2SubItemCode) {
		List<NextGenerationPrice> optionNextGenerationPriceList = nextGenerationRepository.selectOptionNextGenerationPrice(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode);
		return optionNextGenerationPriceList;
	}

	@Override
	public List<NextGenerationPrice> selectBasicNextGenerationPrice(String jkSubItemCode, String gtSubItemCode,
			String ptSubItemCode, String pt2SubItemCode, String itemCode, String fabricNo) {
		List<NextGenerationPrice> basicNextGenerationPrice = nextGenerationRepository.selectBasicNextGenerationPrice(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode, itemCode, fabricNo);
		return basicNextGenerationPrice;
	}

	@Override
	public List<NextGenerationPrice> selectDetailNextGenerationPrice(String jkSubItemCode, String gtSubItemCode,
			String ptSubItemCode, String pt2SubItemCode) {
		List<NextGenerationPrice> detailNextGenerationPrice = nextGenerationRepository.selectDetailNextGenerationPrice(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode);
		return detailNextGenerationPrice;
	}

	@Override
	public List<NextGenerationPrice> selectYield(String jkSubItemCode, String ptSubItemCode, String gtSubItemCode,
			String pt2SubItemCode) {
		List<NextGenerationPrice> yieldList = nextGenerationRepository.selectYield(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode);
		return yieldList;
	}

	@Override
	public List<NextGenerationPrice> selectWholesalePiece(String fabricNo) {
		
		List<NextGenerationPrice> wholesalePieceList = nextGenerationRepository.selectWholesalePiece(fabricNo);
		return wholesalePieceList;
	}

	@Override
	public NextGenerationPrice selectMarginRate(String fabricNo) {
		
		NextGenerationPrice marginRate = nextGenerationRepository.selectMarginRate(fabricNo);
		return marginRate;
	}

	@Override
	public NextGenerationPrice selectFactoryCode(String fabricNo) {
		
		NextGenerationPrice mfaFactoryCode = nextGenerationRepository.selectFactoryCode(fabricNo);
		return mfaFactoryCode;
	}

}
