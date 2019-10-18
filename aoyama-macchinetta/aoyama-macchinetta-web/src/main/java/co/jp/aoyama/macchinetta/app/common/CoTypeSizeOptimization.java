package co.jp.aoyama.macchinetta.app.common;

import java.util.ArrayList;
import java.util.List;

import co.jp.aoyama.macchinetta.app.order.TypeSizeOptimization;
import co.jp.aoyama.macchinetta.domain.model.TypeSize;

public class CoTypeSizeOptimization {

	/**
	 * 型サイズ
	 * @param coTypeSizeList
	 * @return
	 */
	public List<TypeSizeOptimization> getCoTypeSizeOptimization(List<TypeSize> coTypeSizeList) {
		List<TypeSizeOptimization> typeSizeList = new ArrayList<TypeSizeOptimization>();
		for (TypeSize typeSize : coTypeSizeList) {
			TypeSizeOptimization typeSizeOptimization = new TypeSizeOptimization();
			typeSizeOptimization.setAdjustClass(typeSize.getAdjustClass());
			typeSizeOptimization.setTypeSize(numericalToString(typeSize.getTypeSize()));
			typeSizeOptimization.setTypeSize1Intack(numericalToString(typeSize.getTypeSize1Intack()));
			typeSizeOptimization.setTypeSize1Outtack(numericalToString(typeSize.getTypeSize1Outtack()));
			typeSizeOptimization.setTypeSize2Intack(numericalToString(typeSize.getTypeSize2Intack()));
			typeSizeOptimization.setTypeSize2Outtack(numericalToString(typeSize.getTypeSize2Outtack()));
			typeSizeList.add(typeSizeOptimization);
		}
		return typeSizeList;
	}
	
	public static String numericalToString(Object object) {
		if(object == null || "".equals(object)) {
			return "0";
		}else {
			return String.valueOf(object);
		}
	}
}
