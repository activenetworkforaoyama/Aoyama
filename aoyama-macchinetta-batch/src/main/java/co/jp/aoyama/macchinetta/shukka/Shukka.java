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

/**
 * Model bean of Shukka.
 */
public class Shukka {
	
    private String gyotaiCd;
    private String chumonId;
    private String shukkaYmd;
    private Date updatedAt;
    
	public String getGyotaiCd() {
		return gyotaiCd;
	}
	public void setGyotaiCd(String gyotaiCd) {
		this.gyotaiCd = gyotaiCd;
	}
	public String getChumonId() {
		return chumonId;
	}
	public void setChumonId(String chumonId) {
		this.chumonId = chumonId;
	}
	public String getShukkaYmd() {
		return shukkaYmd;
	}
	public void setShukkaYmd(String shukkaYmd) {
		this.shukkaYmd = shukkaYmd;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
