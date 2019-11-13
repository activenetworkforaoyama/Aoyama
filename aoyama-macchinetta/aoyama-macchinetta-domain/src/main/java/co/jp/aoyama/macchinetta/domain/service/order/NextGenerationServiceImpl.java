package co.jp.aoyama.macchinetta.domain.service.order;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.jp.aoyama.macchinetta.domain.model.NextGenerationPrice;
import co.jp.aoyama.macchinetta.domain.model.OrderFindFabric;
import co.jp.aoyama.macchinetta.domain.repository.order.NextGenerationRepository;
import co.jp.aoyama.macchinetta.domain.repository.order.OrderRepository;

@Service
@Transactional
public class NextGenerationServiceImpl implements NextGenerationService{
	
	@Inject
	NextGenerationRepository nextGenerationRepository;
	
	@Inject
	OrderRepository orderRepository;
	
	private static final Logger logger = LoggerFactory
            .getLogger(NextGenerationServiceImpl.class);

	@Override
	public List<NextGenerationPrice> selectOptionNextGenerationPrice(String jkSubItemCode, String gtSubItemCode,
			String ptSubItemCode, String pt2SubItemCode,String factoryCode,String itemCode) {
		List<NextGenerationPrice> optionNextGenerationPriceList = nextGenerationRepository.selectOptionNextGenerationPrice(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode,factoryCode,itemCode);
		if(optionNextGenerationPriceList.isEmpty()) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024");
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		return optionNextGenerationPriceList;
	}

	@Override
	public List<NextGenerationPrice> selectBasicNextGenerationPrice(String jkSubItemCode, String gtSubItemCode,
			String ptSubItemCode, String pt2SubItemCode, String itemCode, String fabricNo) {
		
		List<NextGenerationPrice> basicNextGenerationPrice = nextGenerationRepository.selectBasicNextGenerationPrice(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode, itemCode, fabricNo);
		if(basicNextGenerationPrice.isEmpty()) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024");
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		return basicNextGenerationPrice;
	}

	@Override
	public List<NextGenerationPrice> selectDetailNextGenerationPrice(String jkSubItemCode, String gtSubItemCode,
			String ptSubItemCode, String pt2SubItemCode,String factoryCode,String itemCode) {
		List<NextGenerationPrice> detailNextGenerationPrice = nextGenerationRepository.selectDetailNextGenerationPrice(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode,factoryCode,itemCode);
		if(detailNextGenerationPrice.isEmpty()) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024");
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		return detailNextGenerationPrice;
	}

	@Override
	public List<NextGenerationPrice> selectYield(String jkSubItemCode, String ptSubItemCode, String gtSubItemCode,
			String pt2SubItemCode) {
		List<NextGenerationPrice> yieldList = nextGenerationRepository.selectYield(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode);
		if(yieldList.isEmpty()) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024");
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		return yieldList;
	}

	@Override
	public List<NextGenerationPrice> selectWholesalePiece(String fabricNo) {
		
		List<NextGenerationPrice> wholesalePieceList = nextGenerationRepository.selectWholesalePiece(fabricNo);
		if(wholesalePieceList.isEmpty()) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024");
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		return wholesalePieceList;
	}

	@Override
	public NextGenerationPrice selectMarginRate(String fabricNo) {
		String orderPattern = "PO";
		OrderFindFabric orderFabric = orderRepository.getOrderFabric(fabricNo, orderPattern);
		NextGenerationPrice marginRate = nextGenerationRepository.selectMarginRate(fabricNo);
		
		if(marginRate == null) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024", orderFabric.getMakerCode());
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		
		return marginRate;
	}

	@Override
	public NextGenerationPrice selectFactoryCode(String fabricNo) {
		
		NextGenerationPrice mfaFactoryCode = nextGenerationRepository.selectFactoryCode(fabricNo);
		if(mfaFactoryCode == null) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024");
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		return mfaFactoryCode;
	}

	@Override
	public List<NextGenerationPrice> selectCoYield(String jkSubItemCode, String ptSubItemCode, String gtSubItemCode,
			String pt2SubItemCode, String shirtSubItemCode, String coatSubItemCode) {
		List<NextGenerationPrice> yieldCoList = nextGenerationRepository.selectCoYield(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode,shirtSubItemCode,coatSubItemCode);
		if(yieldCoList.isEmpty()) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024");
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		return yieldCoList;
	}

	@Override
	public List<NextGenerationPrice> selectCoWholesalePiece(String fabricNo,String factoryCd) {
		List<NextGenerationPrice> coWholesalePieceList = nextGenerationRepository.selectCoWholesalePiece(fabricNo,factoryCd);
		if(coWholesalePieceList.isEmpty()) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024");
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		return coWholesalePieceList;
	}

	@Override
	public List<NextGenerationPrice> selectCoBasicNextGenerationPrice(String jkSubItemCode, String ptSubItemCode,
			String gtSubItemCode, String pt2SubItemCode, String shirtSubItemCode, String coatSubItemCode,
			String itemCode, String fabricNo,String factoryCd) {
		List<NextGenerationPrice> coBasicNextGenerationPrice = nextGenerationRepository.selectCoBasicNextGenerationPrice(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode,shirtSubItemCode,coatSubItemCode, itemCode, fabricNo,factoryCd);
		if(coBasicNextGenerationPrice.isEmpty()) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024");
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		return coBasicNextGenerationPrice;
	}

	@Override
	public NextGenerationPrice selectCoMarginRate(String fabricNo,String makerCode) {
		String orderPattern = "CO";
		OrderFindFabric orderFabric = orderRepository.getOrderFabric(fabricNo, orderPattern);
		NextGenerationPrice marginRate = nextGenerationRepository.selectCoMarginRate(fabricNo,makerCode);
		
		if(marginRate == null) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024", orderFabric.getMakerCode());
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		
		return marginRate;
	}

	@Override
	public NextGenerationPrice selectCoFactoryCode(String fabricNo) {
		NextGenerationPrice mfaFactoryCode = nextGenerationRepository.selectCoFactoryCode(fabricNo);
		if(mfaFactoryCode == null) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024");
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		return mfaFactoryCode;
	}

	@Override
	public List<NextGenerationPrice> selectCoOptionNextGenerationPrice(String jkSubItemCode, String ptSubItemCode,
			String gtSubItemCode, String pt2SubItemCode, String factoryCode, String itemCode, String stSubItemCode,
			String ctSubItemCode) {
		List<NextGenerationPrice> selectCoOptionNextGenerationPrice = nextGenerationRepository.selectCoOptionNextGenerationPrice(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode, factoryCode, itemCode, stSubItemCode, ctSubItemCode);
		if(selectCoOptionNextGenerationPrice.isEmpty()) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024");
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		return selectCoOptionNextGenerationPrice;
	}

	@Override
	public List<NextGenerationPrice> selectCoDetailNextGenerationPrice(String jkSubItemCode, String ptSubItemCode,
			String gtSubItemCode, String pt2SubItemCode, String factoryCode, String itemCode, String stSubItemCode,
			String ctSubItemCode) {
		List<NextGenerationPrice> selectCoDetailNextGenerationPrice = nextGenerationRepository.selectCoDetailNextGenerationPrice(jkSubItemCode, ptSubItemCode, gtSubItemCode, pt2SubItemCode, factoryCode, itemCode, stSubItemCode, ctSubItemCode);
		if(selectCoDetailNextGenerationPrice.isEmpty()) {
			ResultMessages resultMessages = ResultMessages.error();
			resultMessages.add("E024");
			logger.error(resultMessages.toString());
			
			throw new ResourceNotFoundException(resultMessages);
		}
		return selectCoDetailNextGenerationPrice;
	}

	@Override
	public List<NextGenerationPrice> selectCoComplexItemsAccessoryPriceList(String factoryCode, String item, String subItem,
			String optionCode) {
		List<NextGenerationPrice> selectCoComplexItemsList = nextGenerationRepository.selectCoComplexItemsAccessoryPriceList(factoryCode, item, subItem, optionCode);
		return selectCoComplexItemsList;
	}

	@Override
	public List<NextGenerationPrice> selectCoComplexItemsWageList(String factoryCode, String item, String subItem,
			String optionCode) {
		List<NextGenerationPrice> selectCoComplexItemsWageList = nextGenerationRepository.selectCoComplexItemsWageList(factoryCode, item, subItem, optionCode);
		return selectCoComplexItemsWageList;
	}

}
