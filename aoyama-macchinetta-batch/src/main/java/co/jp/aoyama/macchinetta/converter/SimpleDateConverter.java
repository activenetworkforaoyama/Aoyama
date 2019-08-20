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
package co.jp.aoyama.macchinetta.converter;

import org.springframework.stereotype.Component;

/**
 * 
 * 入力された日付（YYYY-MM-DD）をYYYYMMDDに変換する
 * @author ANCC
 */
@Component
public class SimpleDateConverter {

	public String getValue(String src) {
		
		String sourceString = src;
		
		//文字列が空もしくはnullの場合、そのままを返す
		if (null == sourceString || 0 == sourceString.length()) {
			return sourceString;
		}
		//入力された日付（YYYY-MM-DD）の場合、YYYYMMDDに変換する
		if (sourceString.length() == 10) {
			return sourceString.substring(0, 4) + sourceString.substring(5, 7) + sourceString.substring(8, 10);
		}
		
		//上記以外の場合、そのままを返す
		return sourceString;
	}
}
