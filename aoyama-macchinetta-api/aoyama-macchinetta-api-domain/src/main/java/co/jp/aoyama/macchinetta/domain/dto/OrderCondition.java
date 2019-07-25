package co.jp.aoyama.macchinetta.domain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wangyingrui
 *
 */
public class OrderCondition implements Serializable {
	
	private static final long serialVersionUID = 6170766039218552949L;

	private String selectFlag;

	public String getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(String selectFlag) {
		this.selectFlag = selectFlag;
	}
    

}