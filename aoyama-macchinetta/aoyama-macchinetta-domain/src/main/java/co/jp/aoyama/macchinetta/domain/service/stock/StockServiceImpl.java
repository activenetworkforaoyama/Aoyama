package co.jp.aoyama.macchinetta.domain.service.stock;

import java.math.BigDecimal;
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

import co.jp.aoyama.macchinetta.domain.model.Stock;
import co.jp.aoyama.macchinetta.domain.repository.stock.StockRepository;
import co.jp.aoyama.macchinetta.domain.service.user.MineUserServiceImpl;

@Service
@Transactional
public class StockServiceImpl implements StockService {
	
	@Inject
	StockRepository stockRepository;	
	
	private static final Logger logger = LoggerFactory
            .getLogger(MineUserServiceImpl.class);
	
	@Override
	public List<Stock> findAllStock() {
		List<Stock> stockList = stockRepository.findAllStock();
		return stockList;
	}
	
	@Override
	public List<Stock> fuzzyQuery(Stock stock) {
		List<Stock> stockList = stockRepository.fuzzyQuery(stock.getFabricNo(), stock.getColor(), stock.getPattern(), stock.getBrandName(), stock.getRetailPrice(), stock.getRetailPriceTo(), stock.getMakerName(), stock.getFactoryName());
		return stockList;
	}

	@Override
	public Boolean updateStockByPk(List<Stock> stockList) {
		List<Stock> stockUpd = new ArrayList<Stock>();
		for(int i = 0; i < stockList.size(); i ++) {
			Stock stock = stockList.get(i);
			// "1"は更新区分
			if("1".equals(stock.getOptionType())) {
				Stock stockFind = stockRepository.findStockByPk(stock.getFabricNo());
				if(stockFind != null && stock.getVersion().equals(stockFind.getVersion())) {
					stock.setTheoreticalStock(stock.getTheoreticalStock());
					stock.setActualStock(stock.getActualStock());
					stock.setUpdatedAt(new Date());
					stock.setUpdatedUserId(stock.getUpdatedUserId());
					stockUpd.add(stock);
				}else if(stockFind == null){
					ResultMessages messages = ResultMessages.error();
					// 該当在庫のデータがありません。
		            messages.add("E015", stock.getFabricNo());
		            
		            logger.error(messages.toString());

		            throw new ResourceNotFoundException(messages);
				}else {
					ResultMessages messages = ResultMessages.error();
					// 該当在庫のデータがありません。
		            messages.add("E026", stock.getVersion());
		            
		            logger.error(messages.toString());

		            throw new ResourceNotFoundException(messages);
				}
			}
		}
		if(stockUpd.size() != 0) {
			stockRepository.updateStockByPk(stockUpd);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public void updateStockValue(String fabricNo, BigDecimal theoreticalStockUpdate,
			BigDecimal reservationStockUpdate) {
		stockRepository.updateStockValue(fabricNo, theoreticalStockUpdate, reservationStockUpdate);
	}

	@Override
	public void updateTheoreticalStock(String fabricNo, BigDecimal theoreticalStockUpdate) {
		stockRepository.updateTheoreticalStock(fabricNo, theoreticalStockUpdate);
	}

}