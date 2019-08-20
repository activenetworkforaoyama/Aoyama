/*
 * Copyright (C) 2017 NTT Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package co.jp.aoyama.macchinetta.siireYoky;

import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import co.jp.aoyama.macchinetta.converter.HalfWidthSpaceInserter;
import co.jp.aoyama.macchinetta.converter.HalfWidthZeroInserter;
import co.jp.aoyama.macchinetta.converter.SimpleDateConverter;

/**
 * ItemProcessor of SiireYoteiYoky.
 */
@Component("siireYoteiYokyProcessor")
@Scope("step")
public class SiireYoteiYokyProcessor implements ItemProcessor<SiireYoteiYoky, SiireYoteiYoky> {

	@Inject
	SiireYoteiYokyRepository siireYoteiYokyRepository;
	
	@Inject
	HalfWidthSpaceInserter halfWidthSpaceInserter;
	
	@Inject
	HalfWidthZeroInserter halfWidthZeroInserter;
	
	@Inject
	SimpleDateConverter simpleDateConverter;
	
	private static final Logger logger = LoggerFactory.getLogger(SiireYoteiYokyProcessor.class);
    /**
     * Processing some stuff for each SiireYoteiYoky.
     *
     * @param item SiireYoteiYoky model
     * @return processed SiireYoteiYoky model.
     */
    @Override
    public SiireYoteiYoky process(SiireYoteiYoky item) {
    	
    	//業態コード
    	item.setStoreBrandCode(halfWidthZeroInserter.getvalue(item.getOrderId(), 2, 0, 1));
    	
    	//メーカー品番枝番あり
    	String hostTransmitMakerProduct = item.getHostTransmitMakerProduct();
    	if (null == hostTransmitMakerProduct || 0 == hostTransmitMakerProduct.length()) {
    		logger.error("host_transmit_maker_product is null.[Order_Id:{}]"
                    ,item.getOrderId());
    	}
    	item.setHostTransmitMakerProduct(halfWidthSpaceInserter.getvalue(hostTransmitMakerProduct,12,"righ"));
    	
    	//PO：パターンオーダー、CO：カスタムオーダーの場合
    	if (4 == item.getHostTransmitSize().length()) {
    		
    		if ("05".equals(item.getProductItem())) {
    			//縦軸サイズコード
            	item.setTateSizeCd(item.getHostTransmitSize().substring(2, 4));
            	//横軸サイズコード
            	item.setYokoSizeCd(item.getHostTransmitSize().substring(0, 2));
    		} else {
    			//縦軸サイズコード
            	item.setTateSizeCd(item.getHostTransmitSize().substring(0, 2));
            	//横軸サイズコード
            	item.setYokoSizeCd(item.getHostTransmitSize().substring(2, 4));
    		}
    		
        //CO：カスタムオーダーの場合
    	} else if ("CO".equals(item.getOrderPattern()) && 2 == item.getHostTransmitSize().length()) {
    		//縦軸サイズコード
        	item.setTateSizeCd("  ");
        	//横軸サイズコード
        	item.setYokoSizeCd(item.getHostTransmitSize());
        	
    	} else {
    		//縦軸サイズコード
        	item.setTateSizeCd("  ");
        	//横軸サイズコード
        	item.setYokoSizeCd("  ");
    	}
    	
    	//仕入単価
    	item.setWsPrice(halfWidthZeroInserter.getvalue(item.getWsPrice(), 7));
    	
    	//標準単価
    	item.setBillingAmount(halfWidthZeroInserter.getvalue(item.getBillingAmount(), 7));
    	
    	//売上店コード
    	item.setHostTransmitStoreCd(halfWidthZeroInserter.getvalue(item.getHostTransmitStoreCd(), 6, 1, 4));
    	
    	//発注日
    	item.setProductOrderdDate(simpleDateConverter.getValue(item.getProductOrderdDate()));
    	
        return item;
    }
}
