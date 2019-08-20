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
 * 入力された文字列に半角ゼロを挿入する
 * @author ANCC
 */
@Component
public class HalfWidthZeroInserter {

	//半角ゼロの定義
	private static final char zero_char = '0';
	
	/**
	 * 入力された文字列の先頭に半角ゼロを挿入する
	 * @param src：指定された文字列
	 * @param len：編集後の	文字列長
	 * @return
	 */
	public String getvalue(String src, int len) {
		String sourceString = src;
		
		//文字列が空もしくはnullの場合、空を返す
		if (null == sourceString || 0 == sourceString.length()) {
			sourceString = "";
		}
		
		StringBuffer resultSrc = new StringBuffer(sourceString);
		//文字列の先頭にゼロを挿入
		for (int i=resultSrc.length(); i < len; i++) {
			resultSrc.insert(0, zero_char);
		}
		
		return resultSrc.toString();
	}
	
	/**
	 * 入力された文字列を指定された桁数で切り取りした、先頭に半角ゼロを挿入する
	 * @param src：指定された文字列
	 * @param len：編集後の	文字列長
	 * @param start：切り取りの開始位置
	 * @param end：切り取りの最終位置
	 * @return
	 */
	public String getvalue(String src, int len, int start, int end) {
		
		String sourceString = src;
		//文字列が空もしくはnullの場合、空を返す
		if (null == sourceString || 0 == sourceString.length()) {
			sourceString = "";
		}
		
		//切り取りの長＞文字列の長の場合、文字列がそのままで先頭にゼロを挿入
		if (sourceString.length() < end) {
			StringBuffer resultSrc = new StringBuffer(sourceString);
			for (int i=resultSrc.length(); i < len; i++) {
				resultSrc.insert(0, zero_char);
			}
			return resultSrc.toString();
		//文字列の先頭にゼロを挿入
		} else {
			StringBuffer resultSrc = new StringBuffer(sourceString.substring(start, end));
			for (int i=resultSrc.length(); i < len; i++) {
				resultSrc.insert(0, zero_char);
			}
			return resultSrc.toString();
		}
	}
	
}
