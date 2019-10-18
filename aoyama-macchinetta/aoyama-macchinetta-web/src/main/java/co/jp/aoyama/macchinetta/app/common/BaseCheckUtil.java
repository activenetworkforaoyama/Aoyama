package co.jp.aoyama.macchinetta.app.common;

import java.math.BigDecimal;

import org.terasoluna.gfw.common.message.ResultMessages;

public class BaseCheckUtil {
	public static Boolean isEmpty(String value) {
		if("".equals(value)||null == value) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Boolean isNotEmpty(String value) {
		  if (value == "" || value == null) {
		    return false;
		  }
		  return true;
	}
	
	public static Boolean isNotBigDecimalNull(BigDecimal args) {
		if(args != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Boolean GrossCompareTo(String gross, ResultMessages messages, String msg) {
		if (gross == null || gross == "") {
			messages.add("E036", msg);
			return true;
		}
		String maxGross = "110";
		String minGross = "50";
		BigDecimal maxGross1 = new BigDecimal(maxGross);
		BigDecimal minGross1 = new BigDecimal(minGross);
		BigDecimal gross1 = new BigDecimal(gross);

		if (gross1.compareTo(minGross1) == -1) {
			messages.add("E036", msg);
			return true;
		}
		if (gross1.compareTo(maxGross1) == 1) {
			messages.add("E036", msg);
			return true;
		}
		return false;

	}
}
