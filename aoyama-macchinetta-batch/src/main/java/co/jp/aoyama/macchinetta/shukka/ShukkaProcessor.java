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
package co.jp.aoyama.macchinetta.shukka;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import co.jp.aoyama.macchinetta.converter.HalfWidthZeroInserter;
import co.jp.aoyama.macchinetta.converter.SimpleDateConverter;

/**
 * ItemProcessor of Shukka.
 */
@Component("shukkaProcessor")
@Scope("step")
public class ShukkaProcessor implements ItemProcessor<Shukka, Shukka> {

	@Inject ShukkaRepository shukkaRepository;
	
	@Inject
	HalfWidthZeroInserter halfWidthZeroInserter;
	
	@Inject
	SimpleDateConverter simpleDateConverter;
	
    /**
     * Processing some stuff for each Shukka.
     *
     * @param item Shukka model
     * @return processed Shukka model.
     */
    @Override
    public Shukka process(Shukka item) {

    	
    	//業態
    	item.setGyotaiCd(halfWidthZeroInserter.getvalue(item.getChumonId(), 2, 0, 1));
    	
    	//出荷日
    	item.setShukkaYmd(simpleDateConverter.getValue(item.getShukkaYmd()));
    	
    	item.setUpdatedAt(new Date());
    	
    	shukkaRepository.update(item);
    	
        return item;
    }
}
