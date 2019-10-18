package co.jp.aoyama.macchinetta.app.common;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

import co.jp.aoyama.macchinetta.app.order.OrderCoForm;
import co.jp.aoyama.macchinetta.app.order.OrderCodePrice;

public class CoContorllerPublicMethodUtil {
	
	public static String formatPrice(String price) {
		  
        price = new StringBuffer(price).reverse().toString();
        String str2 = "";  
        int size = (price.length() % 3 == 0) ? (price.length() / 3) : (price.length() / 3 + 1);
        if (price.length() < 3) { 
            str2 = price;  
        } else {  
            for (int i = 0; i < size - 1; i++) {// 前n-1段  
                str2 += price.substring(i * 3, i * 3 + 3) + ",";  
            }  
            for (int i = size - 1; i < size; i++) {// 第n段  
                str2 += price.substring(i * 3, price.length());  
            }  
        }  
        str2 = new StringBuffer(str2).reverse().toString();// 再将字符串颠倒顺序  
        return str2;
    }
	
	public static String getOrderPrice(String code, String codeDetail, OrderCoForm orderCoForm) {
		String resultPrice = null;
		List<OrderCodePrice> priceList = orderCoForm.getOrderCodePriceList();
		for (OrderCodePrice orderCodePrice : priceList) {
			String orderKeyCode = orderCodePrice.getOrderKeyCode();
			String orderDetailKeyCode = orderCodePrice.getOrderDetailKeyCode();
			String orderBranchPrice = orderCodePrice.getOrderBranchPrice();
			String orderBranchDetailPrice = orderCodePrice.getOrderBranchDetailPrice();
			if(orderDetailKeyCode == null) {
				orderDetailKeyCode = "";
			}
			if(orderBranchDetailPrice == null) {
				orderBranchDetailPrice = "0";
			}
			if (orderKeyCode.equals(code) && orderDetailKeyCode.equals(codeDetail)) {
				if (orderBranchPrice.equals("0") && orderBranchDetailPrice.equals("0")) {
					resultPrice = "0";
					break;
				} else {
					BigDecimal branchPrice = new BigDecimal(orderBranchPrice);
					BigDecimal branchDetailPrice = new BigDecimal(orderBranchDetailPrice);
					BigDecimal addPrice = branchPrice.add(branchDetailPrice);
					resultPrice = String.valueOf(addPrice);
					break;
				}
			} else {
				resultPrice = "0";
			}
		}
		return resultPrice;
	}
	
	public static String getOrderDoublePrice (String code,String codeDetail,OrderCoForm orderCoForm) {
		String resultPrice = null;
		List<OrderCodePrice> priceList = orderCoForm.getOrderCodePriceList();
		for (OrderCodePrice orderCodePrice : priceList) {
			String orderKeyCode = orderCodePrice.getOrderKeyCode();
			String orderDetailKeyCode = orderCodePrice.getOrderDetailKeyCode();
			String orderBranchDoublePrice = orderCodePrice.getOrderBranchDoublePrice();
			String orderBranchDetailDoublePrice = orderCodePrice.getOrderBranchDetailDoublePrice();
			if(orderDetailKeyCode == null) {
				orderDetailKeyCode = "";
			}
			if(orderBranchDetailDoublePrice == null) {
				orderBranchDetailDoublePrice = "0";
			}
			if(orderKeyCode.equals(code)&&orderDetailKeyCode.equals(codeDetail)) {
				if(orderBranchDoublePrice.equals("0")&&orderBranchDetailDoublePrice.equals("0")) {
					resultPrice = "0";
					break;
				}else {
					BigDecimal branchPrice = new BigDecimal(orderBranchDoublePrice);
					BigDecimal branchDetailPrice = new BigDecimal(orderBranchDetailDoublePrice);
					BigDecimal addPrice = branchPrice.add(branchDetailPrice);
					resultPrice = String.valueOf(addPrice);
					break;
				}
			}else {
				resultPrice = "0";
			}
		}
		return resultPrice;
	}
	
	public static Method getMethod(Class<?> classOne, String methodName) {
		Method[] methods = classOne.getMethods();
		Method result = null;
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				result = method;
				break;
			}
		}
		return result;
	}
	
}
