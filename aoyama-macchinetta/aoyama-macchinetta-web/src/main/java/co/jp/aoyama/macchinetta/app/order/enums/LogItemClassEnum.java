package co.jp.aoyama.macchinetta.app.order.enums;

import co.jp.aoyama.macchinetta.domain.model.Order;

public enum LogItemClassEnum {
	
	// key: 補正の アイテムコード
	// value: 補正のクラス
	
	ITEM_CODE_SUIT2P("0121","SUIT（2P）"),
	ITEM_CODE_SUIT2PP("0122","SUIT（2PP）"),
	ITEM_CODE_SUIT3P("0131","SUIT（3P）"),
	ITEM_CODE_SUIT3P2PP("0132","SUIT（3P2PP）"),
	ITEM_CODE_JACKET("02","JACKET"),
	ITEM_CODE_PANTS("03","PANTS"),
	ITEM_CODE_GILET("04","GILET"),
	ITEM_CODE_SHIRTS("05","SHIRT"),
	ITEM_CODE_COAT("06","COAT");
	
	private final String key;
	private final String value;
    
	private LogItemClassEnum(String k ,String v ) {
        this.value = v;
        this.key = k;
    }  

	public String toString() {
        return this.key.concat(",").concat(this.value);
    }  
	
	public String getKey() {
		return this.key;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static String getValue(String key) {
		for (LogItemClassEnum e : values()) {
            if(e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return "";
	}
  
    public static LogItemClassEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static LogItemClassEnum get(String str) {
        for (LogItemClassEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
    
    public static String getLogItem(Order order) {
		//商品情報_ITEM
		String productItem = order.getProductItem();
		//商品情報_ITEM表示用
		String productItemDisplaycode = order.getProductItemDisplaycode();
		if(productItemDisplaycode == null || "".equals(productItemDisplaycode)) {
			productItemDisplaycode = "";
		}
		String item = LogItemClassEnum.getValue(productItem.concat(productItemDisplaycode));
		
		return item;
	}
}
