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
 * 入力された文字列に半角スペースを挿入する
 * @author ANCC
 */
@Component
public class HalfWidthSpaceInserter {

	//半角スペースの定義
	private static final String half_space = " ";
	
	/**
	 * 入力された文字列に半角スペースを挿入する
	 * @param src：指定された文字列
	 * @param len：編集後の	文字列長
	 * @param location　先頭、または最後にスペースを挿入
	 *         righ：文字列の最後に挿入
	 *         left：文字列の先頭に挿入
	 * @return
	 */
	public String getvalue(String src, int len, String location) {
		String sourceString = src;
		//文字列が空もしくはnullの場合、空を返す
		if (null == sourceString || 0 == sourceString.length()) {
			sourceString = "";
		}
		
		StringBuffer resultSrc = new StringBuffer(sourceString);
		//文字列の最後にスペースを挿入
		if ("righ".equals(location)) {
			for (int i=resultSrc.length(); i < len; i++) {
				resultSrc.insert(i, half_space);
			}
		//文字列の先頭にスペースを挿入	
		} else if ("left".equals(location)) {
			
			for (int i=resultSrc.length(); i < len; i++) {
				resultSrc.insert(0, half_space);
			}
		}
		
		return resultSrc.toString();
	}
	
}
