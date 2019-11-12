package co.jp.aoyama.macchinetta.app.detail;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.OrderDetailFormat;

public class OrderDetailCoHelper {
	
	//全角両スペースの定義
	private static final String zen_space = "　　";
	
	//半角コンマの定義
	private static final String half_slash = "/";
	
	//定義：有り
	private static final String ari = "有り";
	
	//定義：無し
	private static final String nasi = "無し";

	/**
	 * 項目変換処理
	 * @param 注文情報
	 */
	public void getOptionDataFormat(Order order, OrderDetailFormat orderFm) {
		
		//商品
		//納期短縮
		String custIsDeliverShortning = order.getCustIsDeliverShortning();
		if ("9000901".equals(custIsDeliverShortning)) {
			order.setCustIsDeliverShortning("無" );
		} else if ("9000902".equals(custIsDeliverShortning)) {
			order.setCustIsDeliverShortning("有");
		}
		
		//早割
		String custIsEarlyDiscount = order.getCustIsEarlyDiscount();
		if ("9001001".equals(custIsEarlyDiscount)) {
			order.setCustIsEarlyDiscount("無" );
		} else if ("9001002".equals(custIsEarlyDiscount)) {
			order.setCustIsEarlyDiscount("有");
		}
		
		//生地ネーム
		String productFabricNmNecessity = order.getProductFabricNmNecessity();
		if ("9000401".equals(productFabricNmNecessity)) {
			order.setProductFabricNmNecessity(ari );
		} else if ("9000402".equals(productFabricNmNecessity)) {
			order.setProductFabricNmNecessity(nasi);
		}
		
		//刺繍入れ
		String productEmbroideryNecessity = order.getProductEmbroideryNecessity();
		if ("9000502".equals(productEmbroideryNecessity)) {
			order.setProductEmbroideryNecessity(ari );
		} else if ("9000501".equals(productEmbroideryNecessity)) {
			order.setProductEmbroideryNecessity(nasi);
		}
				
		//ガゼット刺繍
		String productEmbroideryGazette = order.getProductEmbroideryGazette();
		if ("0002302".equals(productEmbroideryGazette)) {
			order.setProductEmbroideryGazette(ari );
		} else if ("0002301".equals(productEmbroideryGazette)) {
			order.setProductEmbroideryGazette(nasi);
		}
		
		//JACKETモデル
		//内ポケット変更
		String jkInnerPktType = order.getJkInnerPktType();
		if ("0002002".equals(jkInnerPktType)) {
			order.setJkInnerPktType(ari + zen_space + getHalfReplaceValue(order.getJkInnerPktNm()));
		} else if ("0002001".equals(jkInnerPktType)) {
			order.setJkInnerPktType(nasi);
		}
		
		//ステッチ箇所変更
		String jkStitchPlcType = order.getJkStitchPlcType();
		if ("0002402".equals(jkStitchPlcType)) {
			order.setJkStitchPlcType(ari + zen_space + getHalfReplaceValue(order.getJkStitchPlcNm()));
		} else if ("0002401".equals(jkStitchPlcType)) {
			order.setJkStitchPlcType(nasi);
		}
		
		//ダブルステッチ
		String jkDblstitchPlcType = order.getJkDblstitchPlcType();
		if ("0002602".equals(jkDblstitchPlcType)) {
			order.setJkDblstitchPlcType(ari + zen_space + getHalfReplaceValue(order.getJkDblstitchPlcNm()));
		} else if ("0002601".equals(jkDblstitchPlcType)) {
			order.setJkDblstitchPlcType(nasi);
		}
	
		//AMF色指定
		String jkAmfColorNm = order.getJkAmfColorNm();
		String jkAmfColorPlcNm = order.getJkAmfColorPlcNm();
		String jkAmfColor = getHalfReplaceMap(jkAmfColorNm, jkAmfColorPlcNm);
		
		String jkAmfColorType =order.getJkAmfColorType();
		if ("0002802".equals(jkAmfColorType)) {
			order.setJkAmfColorType(ari + zen_space + jkAmfColor);
		} else if ("0002801".equals(jkAmfColorType)) {
			order.setJkAmfColorType(nasi);
		}
		
		//ボタンホール色指定
		String jkBtnholeColorNm = order.getJkBtnholeColorNm();
		String jkBtnholeColorPlcN = order.getJkBtnholeColorPlcN();
		String jkBtnholeColor = getHalfReplaceMap(jkBtnholeColorNm, jkBtnholeColorPlcN);
		
		String jkBtnholeColorType = order.getJkBtnholeColorType();
		if ("0003102".equals(jkBtnholeColorType)) {
			order.setJkBtnholeColorType(ari + zen_space + jkBtnholeColor);
		} else if ("0003101".equals(jkBtnholeColorType)) {
			order.setJkBtnholeColorType(nasi);
		}
		
		//ボタン付け糸指定
		String jkBtnthreadColorNm = order.getJkBtnthreadColorNm();
		String jkBtnthreadColorPlcN = order.getJkBtnthreadColorPlcN();
		String jkBtnthreadColor = getHalfReplaceMap(jkBtnthreadColorNm, jkBtnthreadColorPlcN);
		
		String jkBtnthreadColorType = order.getJkBtnthreadColorType();
		if ("0003402".equals(jkBtnthreadColorType)) {
			order.setJkBtnthreadColorType(ari + zen_space + jkBtnthreadColor);
		} else if ("0003401".equals(jkBtnthreadColorType)) {
			order.setJkBtnthreadColorType(nasi);
		}

		//GILETモデル
        //ステッチ箇所変更
        String glStitchPlcType = order.getGlStitchPlcType();
		if ("0000602".equals(glStitchPlcType)) {
			order.setGlStitchPlcType(ari + zen_space + getHalfReplaceValue(order.getGlStitchPlcNm()));
		} else if ("0000601".equals(glStitchPlcType)) {
			order.setGlStitchPlcType(nasi);
		}
		
		//ダブルステッチ変更
		String glDblstitchPlcType = order.getGlDblstitchPlcType();
		if ("0002602".equals(glDblstitchPlcType)) {
			order.setGlDblstitchPlcType(ari + zen_space + getHalfReplaceValue(order.getGlDblstitchPlcNm()));
		} else if ("0002601".equals(glDblstitchPlcType)) {
			order.setGlDblstitchPlcType(nasi);
		}
		
		//AMF色指定
		String glAmfColorNm = order.getGlAmfColorNm();
		String glAmfColorPlcNm = order.getGlAmfColorPlcNm();
		String glAmfColor = getHalfReplaceMap(glAmfColorNm, glAmfColorPlcNm);
		
		String glAmfColorType =order.getGlAmfColorType();
		if ("0000802".equals(glAmfColorType)) {
			order.setGlAmfColorType(ari + zen_space + glAmfColor);
		} else if ("0000801".equals(glAmfColorType)) {
			order.setGlAmfColorType(nasi);
		}

        //ボタンホール色指定
		String glBtnholeColorNm = order.getGlBtnholeColorNm();
		String glBtnholeColorPlcNm = order.getGlBtnholeColorPlcNm();
		String glBtnholeColor = getHalfReplaceMap(glBtnholeColorNm, glBtnholeColorPlcNm);
		
		String glBtnholeColorType =order.getGlBtnholeColorType();
		if ("0001102".equals(glBtnholeColorType)) {
			order.setGlBtnholeColorType(ari + zen_space + glBtnholeColor);
		} else if ("0001101".equals(glBtnholeColorType)) {
			order.setGlBtnholeColorType(nasi);
		}
		
		//ボタン付け糸指定
		String glBtnthreadColorNm = order.getGlBtnthreadColorNm();
		String glBtnthreadColorPlcNm = order.getGlBtnthreadColorPlcNm();
		String glBtnthreadColor = getHalfReplaceMap(glBtnthreadColorNm, glBtnthreadColorPlcNm);
		
		String glBtnthreadColorType =order.getGlBtnthreadColorType();
		if ("0001402".equals(glBtnthreadColorType)) {
			order.setGlBtnthreadColorType(ari + zen_space + glBtnthreadColor);
		} else if ("0001401".equals(glBtnthreadColorType)) {
			order.setGlBtnthreadColorType(nasi);
		}
		
		//PANTSモデル
		//ベルトループ
		String ptBeltloopType = order.getPtBeltloopType();
		if ("0000701".equals(ptBeltloopType)) {
			order.setPtBeltloopType(ari + zen_space + getHalfReplaceValue(order.getPtBeltloopNm()));
		} else if ("0000702".equals(ptBeltloopType)) {
			order.setPtBeltloopType(nasi);
		}
		
		//ステッチ箇所変更
		String ptStitchPlcType =order.getPtStitchPlcType();
		if ("0002002".equals(ptStitchPlcType)) {
			order.setPtStitchPlcType(ari + zen_space + getHalfReplaceValue(order.getPtStitchPlcNm()));
		} else if ("0002001".equals(ptStitchPlcType)) {
			order.setPtStitchPlcType(nasi);
		}
		
		//ダブルステッチ
		String ptDblstitchPlcType =order.getPtDblstitchPlcType();
		if ("0002202".equals(ptDblstitchPlcType)) {
			order.setPtDblstitchPlcType(ari + zen_space + getHalfReplaceValue(order.getPtDblstitchPlcNm()));
		} else if ("0002201".equals(ptDblstitchPlcType)) {
			order.setPtDblstitchPlcType(nasi);
		}
		
		//AMF色指定
		String ptAmfColorNm = order.getPtAmfColorNm();
		String ptAmfColorPlcNm = order.getPtAmfColorPlcNm();
		String ptAmfColor = getHalfReplaceMap(ptAmfColorNm, ptAmfColorPlcNm);
		
		String ptAmfColorType =order.getPtAmfColorType();
		if ("0002402".equals(ptAmfColorType)) {
			order.setPtAmfColorType(ari + zen_space + ptAmfColor);
		} else if ("0002401".equals(ptAmfColorType)) {
			order.setPtAmfColorType(nasi);
		}
		
		//ボタンホール色指定
		String ptBtnholeColorNm = order.getPtBtnholeColorNm();
		String ptBtnholeColorPlcNm = order.getPtBtnholeColorPlcNm();
		String ptBtnholeColor = getHalfReplaceMap(ptBtnholeColorNm, ptBtnholeColorPlcNm);
		
		String ptBtnholeColorType =order.getPtBtnholeColorType();
		if ("0002702".equals(ptBtnholeColorType)) {
			order.setPtBtnholeColorType(ari + zen_space + ptBtnholeColor);
		} else if ("0002701".equals(ptBtnholeColorType)) {
			order.setPtBtnholeColorType(nasi);
		}
		
		//ボタン付け糸指定
		String ptBtnthreadColorNm = order.getPtBtnthreadColorNm();
		String ptBtnthreadColorPlcNm = order.getPtBtnthreadColorPlcNm();
		String ptBtnthreadColor = getHalfReplaceMap(ptBtnthreadColorNm, ptBtnthreadColorPlcNm);
		
		String ptBtnthreadColorType =order.getPtBtnthreadColorType();
		if ("0003002".equals(ptBtnthreadColorType)) {
			order.setPtBtnthreadColorType(ari + zen_space + ptBtnthreadColor);
		} else if ("0003001".equals(ptBtnthreadColorType)) {
			order.setPtBtnthreadColorType(nasi);
		}
		
		//2PANTSモデル
		//ベルトループ
		String pt2BeltloopType = order.getPt2BeltloopType();
		if ("0000701".equals(pt2BeltloopType)) {
			order.setPt2BeltloopType(ari + zen_space + getHalfReplaceValue(order.getPt2BeltloopNm()));
		} else if ("0000702".equals(pt2BeltloopType)) {
			order.setPt2BeltloopType(nasi);
		}
		
		//ステッチ箇所変更
		String pt2StitchPlcType =order.getPt2StitchPlcType();
		if ("0002002".equals(pt2StitchPlcType)) {
			order.setPt2StitchPlcType(ari + zen_space + getHalfReplaceValue(order.getPt2StitchPlcNm()));
		} else if ("0002001".equals(pt2StitchPlcType)) {
			order.setPt2StitchPlcType(nasi);
		}
		
		//ダブルステッチ
		String pt2DblstitchPlcType =order.getPt2DblstitchPlcType();
		if ("0002202".equals(pt2DblstitchPlcType)) {
			order.setPt2DblstitchPlcType(ari + zen_space + getHalfReplaceValue(order.getPt2DblstitchPlcNm()));
		} else if ("0002201".equals(pt2DblstitchPlcType)) {
			order.setPt2DblstitchPlcType(nasi);
		}
		
		//AMF色指定
		String pt2AmfColorNm = order.getPt2AmfColorNm();
		String pt2AmfColorPlcNm = order.getPt2AmfColorPlcNm();
		String pt2AmfColor = getHalfReplaceMap(pt2AmfColorNm, pt2AmfColorPlcNm);
		
		String pt2AmfColorType =order.getPt2AmfColorType();
		if ("0002402".equals(pt2AmfColorType)) {
			order.setPt2AmfColorType(ari + zen_space + pt2AmfColor);
		} else if ("0002401".equals(pt2AmfColorType)) {
			order.setPt2AmfColorType(nasi);
		}
		
		//ボタンホール色指定
		String pt2BtnholeColorNm = order.getPt2BtnholeColorNm();
		String pt2BtnholeColorPlcNm = order.getPt2BtnholeColorPlcNm();
		String pt2BtnholeColor = getHalfReplaceMap(pt2BtnholeColorNm, pt2BtnholeColorPlcNm);
		
		String pt2BtnholeColorType =order.getPt2BtnholeColorType();
		if ("0002702".equals(pt2BtnholeColorType)) {
			order.setPt2BtnholeColorType(ari + zen_space + pt2BtnholeColor);
		} else if ("0002701".equals(pt2BtnholeColorType)) {
			order.setPt2BtnholeColorType(nasi);
		}
		
		//ボタン付け糸指定
		String pt2BtnthreadColorNm = order.getPt2BtnthreadColorNm();
		String pt2BtnthreadColorPlcNm = order.getPt2BtnthreadColorPlcNm();
		String pt2BtnthreadColor = getHalfReplaceMap(pt2BtnthreadColorNm, pt2BtnthreadColorPlcNm);
		
		String pt2BtnthreadColorType =order.getPt2BtnthreadColorType();
		if ("0003002".equals(pt2BtnthreadColorType)) {
			order.setPt2BtnthreadColorType(ari + zen_space + pt2BtnthreadColor);
		} else if ("0003001".equals(pt2BtnthreadColorType)) {
			order.setPt2BtnthreadColorType(nasi);
		}
		
//		//COAT
//		//COATモデル
//		Map<String,String> coatMap = new HashMap<String,String>();
//		coatMap.put("SingleChester","シングルチェスター（ノッチド）");
//		coatMap.put("DoubleChester","ダブルチェスター");
//		coatMap.put("DoublePolo","ダブルポロ");
//		coatMap.put("SoutienCollar","ステンカラー");
//		
//		String coatModel = order.getCtModelCd();
//		for (String key : coatMap.keySet()) {
//			if (key.equals(coatModel)) {
//				order.setCtModelNm(coatMap.get(key));
//			}
//		}
//				
		//SHIRT
//		//SHIRTモデル
//		Map<String,String> shirtMap = new HashMap<String,String>();
//		shirtMap.put("BS27-darts","スリム（BS27）darts");
//		shirtMap.put("BS27-pleats","スリム（BS27）pleats");
//		shirtMap.put("BS27-box","スリム（BS27）box");
//		shirtMap.put("BS35-darts","スタンダード（BS35）darts");
//		shirtMap.put("BS35-pleats","スタンダード（BS35）pleats");
//		shirtMap.put("BS35-box","スタンダード（BS35）box");
//		shirtMap.put("BS23-darts","スーパースリム（BS23）darts");
//		
//		String shirtModel = order.getStModelCd();
//		for (String key : shirtMap.keySet()) {
//			if (key.equals(shirtModel)) {
//				order.setStModelNm(shirtMap.get(key));
//			}
//		}
		
		//カジュアルヘムライン仕様
		String stCasualHemlineCd = order.getStCasualHemlineCd();
		if ("0002002".equals(stCasualHemlineCd)) {
			order.setStCasualHemlineCd(ari );
		} else if ("0002001".equals(stCasualHemlineCd)) {
			order.setStCasualHemlineCd(nasi);
		}
		
		//上代価格の変換
		orderFm.setProductIs3pieceRtPriceFm(getRtValue(order.getProductIs3pieceRtPrice()));
		orderFm.setProductSparePantsRtPriceFm(getRtValue(order.getProductSparePantsRtPrice()));
		orderFm.setProductEmbroideryGazetteRtPriceFm(getRtValue(order.getProductEmbroideryGazetteRtPrice()));
		orderFm.setProductEmbroideryNmPosRtPriceFm(getRtValue(order.getProductEmbroideryNmPosRtPrice()));
		orderFm.setProductLcrSewingRtPriceFm(getRtValue(order.getProductLcrSewingRtPrice()));
		orderFm.setCustIsDeliverShortningRtPriceFm(getRtValue(order.getCustIsDeliverShortningRtPrice()));
		orderFm.setJkModelRtPriceFm(getRtValue(order.getJkModelRtPrice()));
		orderFm.setGlModelRtPriceFm(getRtValue(order.getGlModelRtPrice()));
		orderFm.setCtModelRtPriceFm(getRtValue(order.getCtModelRtPrice()));
		orderFm.setJkFrtBtnRtPriceFm(getRtValue(order.getJkFrtBtnRtPrice()));
		orderFm.setJkLapelDesignRtPriceFm(getRtValue(order.getJkLapelDesignRtPrice()));
		orderFm.setJkGradeRtPriceFm(getRtValue(order.getJkGradeRtPrice()));
		orderFm.setJkDaibaRtPriceFm(getRtValue(order.getJkDaibaRtPrice()));
		orderFm.setJkCollarInnerRtPriceFm(getRtValue(order.getJkCollarInnerRtPrice()));
		orderFm.setJkLookClothRtPriceFm(getRtValue(order.getJkLookClothRtPrice()));
		orderFm.setJkCollarHangRtPriceFm(getRtValue(order.getJkCollarHangRtPrice()));
		orderFm.setJkLapelWidthRtPriceFm(getRtValue(order.getJkLapelWidthRtPrice()));
		orderFm.setJkFlowerHoleRtPriceFm(getRtValue(order.getJkFlowerHoleRtPrice()));
		orderFm.setJkBreastPktRtPriceFm(getRtValue(order.getJkBreastPktRtPrice()));
		orderFm.setJkInnerClothRtPriceFm(getRtValue(order.getJkInnerClothRtPrice()));
		orderFm.setJkWaistPktRtPriceFm(getRtValue(order.getJkWaistPktRtPrice()));
		orderFm.setJkChgPktRtPriceFm(getRtValue(order.getJkChgPktRtPrice()));
		orderFm.setJkSlantedPktRtPriceFm(getRtValue(order.getJkSlantedPktRtPrice()));
		orderFm.setJkShinobiPktRtPriceFm(getRtValue(order.getJkShinobiPktRtPrice()));
		orderFm.setJkSleeveTypeRtPriceFm(getRtValue(order.getJkSleeveTypeRtPrice()));
		orderFm.setJkManicaRtPriceFm(getRtValue(order.getJkManicaRtPrice()));
		orderFm.setJkSleeveBtnRtPriceFm(getRtValue(order.getJkSleeveBtnRtPrice()));
		orderFm.setJkCuffRtPriceFm(getRtValue(order.getJkCuffRtPrice()));
		orderFm.setJkInnerPktRtPriceFm(getRtValue(order.getJkInnerPktRtPrice()));
		orderFm.setJkRightInnerPktTypeRtPriceFm(getRtValue(order.getJkRightInnerPktTypeRtPrice()));
		orderFm.setJkStitchTypeRtPriceFm(getRtValue(order.getJkStitchTypeRtPrice()));
		orderFm.setJkStitchPlcRtPriceFm(getRtValue(order.getJkStitchPlcRtPrice()));
		orderFm.setJkDblstitchPlcRtPriceFm(getRtValue(order.getJkDblstitchPlcRtPrice()));
		orderFm.setJkAmfColorRtPriceFm(getRtValue(order.getJkAmfColorRtPrice()));
		orderFm.setJkBtnholePlcColorRtPriceFm(getRtValue(order.getJkBtnholePlcColorRtPrice()));
		orderFm.setJkBtnthreadPlcColorRtPriceFm(getRtValue(order.getJkBtnthreadPlcColorRtPrice()));
		orderFm.setJkVentRtPriceFm(getRtValue(order.getJkVentRtPrice()));
		orderFm.setJkInnerBodyClothRtPriceFm(getRtValue(order.getJkInnerBodyClothRtPrice()));
		orderFm.setJkInnerSleeveClothRtPriceFm(getRtValue(order.getJkInnerSleeveClothRtPrice()));
		orderFm.setJkBtnMaterialRtPriceFm(getRtValue(order.getJkBtnMaterialRtPrice()));
		orderFm.setJkShapeMemoryRtPriceFm(getRtValue(order.getJkShapeMemoryRtPrice()));
		orderFm.setGlBreastPktRtPriceFm(getRtValue(order.getGlBreastPktRtPrice()));
		orderFm.setGlWaistPktRtPriceFm(getRtValue(order.getGlWaistPktRtPrice()));
		orderFm.setGlWaistPktShapeRtPriceFm(getRtValue(order.getGlWaistPktShapeRtPrice()));
		orderFm.setGlWaistPktClothRtPriceFm(getRtValue(order.getGlWaistPktClothRtPrice()));
		orderFm.setGlAmfStitchRtPriceFm(getRtValue(order.getGlAmfStitchRtPrice()));
		orderFm.setGlStitchPlcRtPriceFm(getRtValue(order.getGlStitchPlcRtPrice()));
		orderFm.setGlDblstitchPlcRtPriceFm(getRtValue(order.getGlDblstitchPlcRtPrice()));
		orderFm.setGlAmfColorRtPriceFm(getRtValue(order.getGlAmfColorRtPrice()));
		orderFm.setGlBtnholeColorRtPriceFm(getRtValue(order.getGlBtnholeColorRtPrice()));
		orderFm.setGlBtnthreadColorRtPriceFm(getRtValue(order.getGlBtnthreadColorRtPrice()));
		orderFm.setGlBackClothRtPriceFm(getRtValue(order.getGlBackClothRtPrice()));
		orderFm.setGlInnnerClothRtPriceFm(getRtValue(order.getGlInnnerClothRtPrice()));
		orderFm.setGlFrtBtnRtPriceFm(getRtValue(order.getGlFrtBtnRtPrice()));
		orderFm.setGlBackBeltRtPriceFm(getRtValue(order.getGlBackBeltRtPrice()));
		orderFm.setGlWatchChainRtPriceFm(getRtValue(order.getGlWatchChainRtPrice()));
		orderFm.setPtTackRtPriceFm(getRtValue(order.getPtTackRtPrice()));
		orderFm.setPtKneeinnerTypeRtPriceFm(getRtValue(order.getPtKneeinnerTypeRtPrice()));
		orderFm.setPtKneeinnerClothRtPriceFm(getRtValue(order.getPtKneeinnerClothRtPrice()));
		orderFm.setPtFrtTypeRtPriceFm(getRtValue(order.getPtFrtTypeRtPrice()));
		orderFm.setPtPancherinaRtPriceFm(getRtValue(order.getPtPancherinaRtPrice()));
		orderFm.setPtAdjusterRtPriceFm(getRtValue(order.getPtAdjusterRtPrice()));
		orderFm.setPtBeltloopRtPriceFm(getRtValue(order.getPtBeltloopRtPrice()));
		orderFm.setPtPinloopRtPriceFm(getRtValue(order.getPtPinloopRtPrice()));
		orderFm.setPtSidePktRtPriceFm(getRtValue(order.getPtSidePktRtPrice()));
		orderFm.setPtShinobiPktRtPriceFm(getRtValue(order.getPtShinobiPktRtPrice()));
		orderFm.setPtCoinPktRtPriceFm(getRtValue(order.getPtCoinPktRtPrice()));
		orderFm.setPtFlapcoinPktRtPriceFm(getRtValue(order.getPtFlapcoinPktRtPrice()));
		orderFm.setPtLeftPisPktRtPriceFm(getRtValue(order.getPtLeftPisPktRtPrice()));
		orderFm.setPtRightPisPktRtPriceFm(getRtValue(order.getPtRightPisPktRtPrice()));
		orderFm.setPtVCutRtPriceFm(getRtValue(order.getPtVCutRtPrice()));
		orderFm.setPtHemUpRtPriceFm(getRtValue(order.getPtHemUpRtPrice()));
		orderFm.setPtDblWidthRtPriceFm(getRtValue(order.getPtDblWidthRtPrice()));
		orderFm.setPtAmfStitchRtPriceFm(getRtValue(order.getPtAmfStitchRtPrice()));
		orderFm.setPtStitchPlcRtPriceFm(getRtValue(order.getPtStitchPlcRtPrice()));
		orderFm.setPtDblstitchPlcRtPriceFm(getRtValue(order.getPtDblstitchPlcRtPrice()));
		orderFm.setPtAmfColorRtPriceFm(getRtValue(order.getPtAmfColorRtPrice()));
		orderFm.setPtBtnholeColorRtPriceFm(getRtValue(order.getPtBtnholeColorRtPrice()));
		orderFm.setPtBtnthreadColorRtPriceFm(getRtValue(order.getPtBtnthreadColorRtPrice()));
		orderFm.setPtBtnMaterialRtPriceFm(getRtValue(order.getPtBtnMaterialRtPrice()));
		orderFm.setPtSuspenderBtnRtPriceFm(getRtValue(order.getPtSuspenderBtnRtPrice()));
		orderFm.setPtNonSlipRtPriceFm(getRtValue(order.getPtNonSlipRtPrice()));
		orderFm.setPtChicSlipRtPriceFm(getRtValue(order.getPtChicSlipRtPrice()));
		orderFm.setPtShapeMemoryRtPriceFm(getRtValue(order.getPtShapeMemoryRtPrice()));
		orderFm.setPt2HemUpRtPriceFm(getRtValue(order.getPt2HemUpRtPrice()));
		orderFm.setPt2DblWidthRtPriceFm(getRtValue(order.getPt2DblWidthRtPrice()));
		orderFm.setPt2TackRtPriceFm(getRtValue(order.getPt2TackRtPrice()));
		orderFm.setPt2AdjusterRtPriceFm(getRtValue(order.getPt2AdjusterRtPrice()));
		orderFm.setPt2KneeinnerTypeRtPriceFm(getRtValue(order.getPt2KneeinnerTypeRtPrice()));
		orderFm.setPt2KneeinnerClothRtPriceFm(getRtValue(order.getPt2KneeinnerClothRtPrice()));
		orderFm.setPt2FrtTypeRtPriceFm(getRtValue(order.getPt2FrtTypeRtPrice()));
		orderFm.setPt2PancherinaRtPriceFm(getRtValue(order.getPt2PancherinaRtPrice()));
		orderFm.setPt2BeltloopRtPriceFm(getRtValue(order.getPt2BeltloopRtPrice()));
		orderFm.setPt2PinloopRtPriceFm(getRtValue(order.getPt2PinloopRtPrice()));
		orderFm.setPt2SidePktRtPriceFm(getRtValue(order.getPt2SidePktRtPrice()));
		orderFm.setPt2ShinobiPktRtPriceFm(getRtValue(order.getPt2ShinobiPktRtPrice()));
		orderFm.setPt2CoinPktRtPriceFm(getRtValue(order.getPt2CoinPktRtPrice()));
		orderFm.setPt2FlapcoinPktRtPriceFm(getRtValue(order.getPt2FlapcoinPktRtPrice()));
		orderFm.setPt2LeftPisPktRtPriceFm(getRtValue(order.getPt2LeftPisPktRtPrice()));
		orderFm.setPt2RightPisPktRtPriceFm(getRtValue(order.getPt2RightPisPktRtPrice()));
		orderFm.setPt2VCutRtPriceFm(getRtValue(order.getPt2VCutRtPrice()));
		orderFm.setPt2AmfStitchRtPriceFm(getRtValue(order.getPt2AmfStitchRtPrice()));
		orderFm.setPt2StitchPlcRtPriceFm(getRtValue(order.getPt2StitchPlcRtPrice()));
		orderFm.setPt2DblstitchPlcRtPriceFm(getRtValue(order.getPt2DblstitchPlcRtPrice()));
		orderFm.setPt2AmfColorRtPriceFm(getRtValue(order.getPt2AmfColorRtPrice()));
		orderFm.setPt2BtnholeColorRtPriceFm(getRtValue(order.getPt2BtnholeColorRtPrice()));
		orderFm.setPt2BtnthreadColorRtPriceFm(getRtValue(order.getPt2BtnthreadColorRtPrice()));
		orderFm.setPt2SuspenderBtnRtPriceFm(getRtValue(order.getPt2SuspenderBtnRtPrice()));
		orderFm.setPt2BtnMaterialRtPriceFm(getRtValue(order.getPt2BtnMaterialRtPrice()));
		orderFm.setPt2NonSlipRtPriceFm(getRtValue(order.getPt2NonSlipRtPrice()));
		orderFm.setPt2ChicSlipRtPriceFm(getRtValue(order.getPt2ChicSlipRtPrice()));
		orderFm.setPt2ShapeMemoryRtPriceFm(getRtValue(order.getPt2ShapeMemoryRtPrice()));
		orderFm.setCtLapelDesignRtPriceFm(getRtValue(order.getCtLapelDesignRtPrice()));
		//仕様変更　「袖仕様」画面削除
//		orderFm.setCtSleeveTypeRtPriceFm(getRtValue(order.getCtSleeveTypeRtPrice()));
		orderFm.setCtWaistPktRtPriceFm(getRtValue(order.getCtWaistPktRtPrice()));
		orderFm.setCtChgPktRtPriceFm(getRtValue(order.getCtChgPktRtPrice()));
		orderFm.setCtSlantedPktRtPriceFm(getRtValue(order.getCtSlantedPktRtPrice()));
		orderFm.setCtVentRtPriceFm(getRtValue(order.getCtVentRtPrice()));
		orderFm.setCtFrtBtnRtPriceFm(getRtValue(order.getCtFrtBtnRtPrice()));
		orderFm.setCtCuffRtPriceFm(getRtValue(order.getCtCuffRtPrice()));
		orderFm.setCtSleeveBtnRtPriceFm(getRtValue(order.getCtSleeveBtnRtPrice()));
		orderFm.setCtBackBeltRtPriceFm(getRtValue(order.getCtBackBeltRtPrice()));
		orderFm.setCtCollarHangRtPriceFm(getRtValue(order.getCtCollarHangRtPrice()));
		orderFm.setCtInnerBodyClothRtPriceFm(getRtValue(order.getCtInnerBodyClothRtPrice()));
		orderFm.setCtInnerSleeveClothRtPriceFm(getRtValue(order.getCtInnerSleeveClothRtPrice()));
		orderFm.setCtBtnMaterialRtPriceFm(getRtValue(order.getCtBtnMaterialRtPrice()));
		orderFm.setStCollarTypeRtPriceFm(getRtValue(order.getStCollarTypeRtPrice()));
		orderFm.setStCuffsRtPriceFm(getRtValue(order.getStCuffsRtPrice()));
		orderFm.setStConvertibleRtPriceFm(getRtValue(order.getStConvertibleRtPrice()));
		orderFm.setStAdjusterBtnRtPriceFm(getRtValue(order.getStAdjusterBtnRtPrice()));
		orderFm.setStClericRtPriceFm(getRtValue(order.getStClericRtPrice()));
		orderFm.setStDblCuffsRtPriceFm(getRtValue(order.getStDblCuffsRtPrice()));
		orderFm.setStCuffsBtnRtPriceFm(getRtValue(order.getStCuffsBtnRtPrice()));
		orderFm.setStBtnMaterialRtPriceFm(getRtValue(order.getStBtnMaterialRtPrice()));
		orderFm.setStDblBtnRtPriceFm(getRtValue(order.getStDblBtnRtPrice()));
		orderFm.setStGauntletBtnPosRtPriceFm(getRtValue(order.getStGauntletBtnPosRtPrice()));
		orderFm.setStPinholePinRtPriceFm(getRtValue(order.getStPinholePinRtPrice()));
		orderFm.setStBreastPktRtPriceFm(getRtValue(order.getStBreastPktRtPrice()));
		orderFm.setStBreastSizeRtPriceFm(getRtValue(order.getStBreastSizeRtPrice()));
		orderFm.setStFrtDesignRtPriceFm(getRtValue(order.getStFrtDesignRtPrice()));
		orderFm.setStPintuckBosomRtPriceFm(getRtValue(order.getStPintuckBosomRtPrice()));
		orderFm.setStStitchRtPriceFm(getRtValue(order.getStStitchRtPrice()));
		orderFm.setStColarKeeperRtPriceFm(getRtValue(order.getStColarKeeperRtPrice()));
		orderFm.setStBtnholeColorRtPriceFm(getRtValue(order.getStBtnholeColorRtPrice()));
		orderFm.setStBtnthreadColorRtPriceFm(getRtValue(order.getStBtnthreadColorRtPrice()));
		orderFm.setStCasualHemlineRtPriceFm(getRtValue(order.getStCasualHemlineRtPrice()));
		orderFm.setStBtnposChgRtPriceFm(getRtValue(order.getStBtnposChgRtPrice()));
		orderFm.setStNeckbandBtnChgRtPriceFm(getRtValue(order.getStNeckbandBtnChgRtPrice()));
		orderFm.setStFrtfirstBtnChgRtPriceFm(getRtValue(order.getStFrtfirstBtnChgRtPrice()));
		orderFm.setStFrtsecondBtnChgRtPriceFm(getRtValue(order.getStFrtsecondBtnChgRtPrice()));
		orderFm.setPtSideStripeRtPriceFm(getRtValue(order.getPtSideStripeRtPrice()));
		orderFm.setPtSideStripeWidthRtPriceFm(getRtValue(order.getPtSideStripeWidthRtPrice()));
		orderFm.setPt2SideStripeRtPriceFm(getRtValue(order.getPt2SideStripeRtPrice()));
		orderFm.setPt2SideStripeWidthRtPriceFm(getRtValue(order.getPt2SideStripeWidthRtPrice()));
		orderFm.setGlLookClothRtPriceFm(getRtValue(order.getGlLookClothRtPrice()));
		orderFm.setPtLookClothRtPriceFm(getRtValue(order.getPtLookClothRtPrice()));
		orderFm.setPt2LookClothRtPriceFm(getRtValue(order.getPt2LookClothRtPrice()));
		
		//下代価格
		orderFm.setWsPriceFm(getFormatMoneyValue(order.getWsPrice()));
		
		//ご請求金額
		orderFm.setBillingAmountFm(getFormatMoneyValue(order.getBillingAmount()));
		orderFm.setConsumptionTaxAmountFm(getFormatMoneyValue(order.getConsumptionTaxAmount()));
		orderFm.setProductPriceFm(getFormatMoneyValue(order.getProductPrice()));
		orderFm.setOptionPriceFm(getFormatMoneyValue(order.getOptionPrice()));
		orderFm.setTotalPriceFm(getFormatMoneyValue(order.getTotalPrice()));
		
		//補正値
		//JACKET補正
		orderFm.setCorJkBodylengthCorrectFm(getCorrectValue(order.getCorJkBodylengthCorrect()));
		orderFm.setCorJkWaistCorrectFm(getCorrectValue(order.getCorJkWaistCorrect()));
		orderFm.setCorJkRightsleeveCorrectFm(getCorrectValue(order.getCorJkRightsleeveCorrect()));
		orderFm.setCorJkLeftsleeveCorrectFm(getCorrectValue(order.getCorJkLeftsleeveCorrect()));

		//GILET補正
		orderFm.setCorGlBodylengthCorrectFm(getCorrectValue(order.getCorGlBodylengthCorrect()));
		orderFm.setCorGlBustCorrectFm(getCorrectValue(order.getCorGlBustCorrect()));
		orderFm.setCorGlWaistCorrectFm(getCorrectValue(order.getCorGlWaistCorrect()));

		//PANTS補正
		orderFm.setCorPtWaistCorrectFm(getCorrectValue(order.getCorPtWaistCorrect()));
		orderFm.setCorPtHipCorrectFm(getCorrectValue(order.getCorPtHipCorrect()));
		orderFm.setCorPtThighwidthCorrectFm(getCorrectValue(order.getCorPtThighwidthCorrect()));
		orderFm.setCorPtHemwidthCorrectFm(getCorrectValue(order.getCorPtHemwidthCorrect()));

		//PANTS補正
		orderFm.setCorPt2WaistCorrectFm(getCorrectValue(order.getCorPt2WaistCorrect()));
		orderFm.setCorPt2HipCorrectFm(getCorrectValue(order.getCorPt2HipCorrect()));
		orderFm.setCorPt2ThighwidthCorrectFm(getCorrectValue(order.getCorPt2ThighwidthCorrect()));
		orderFm.setCorPt2HemwidthCorrectFm(getCorrectValue(order.getCorPt2HemwidthCorrect()));

		//COAT補正
		orderFm.setCorCtBodylengthCorrectFm(getCorrectValue(order.getCorCtBodylengthCorrect()));
		orderFm.setCorCtWaistCorrectFm(getCorrectValue(order.getCorCtWaistCorrect()));
		orderFm.setCorCtRightsleeveCorrectFm(getCorrectValue(order.getCorCtRightsleeveCorrect()));
		orderFm.setCorCtLeftsleeveCorrectFm(getCorrectValue(order.getCorCtLeftsleeveCorrect()));
		orderFm.setCorCtVenthightCorrectFm(getCorrectValue(order.getCorCtVenthightCorrect()));
		orderFm.setCorCtPktposCorrectFm(getCorrectValue(order.getCorCtPktposCorrect()));

		//SHIRT補正
		orderFm.setCorStNeckCorrectFm(getCorrectValue(order.getCorStNeckCorrect()));
		orderFm.setCorStBodylengthCorrectFm(getCorrectValue(order.getCorStBodylengthCorrect()));
		orderFm.setCorStRightsleeveCorrectFm(getCorrectValue(order.getCorStRightsleeveCorrect()));
		orderFm.setCorStLeftsleeveCorrectFm(getCorrectValue(order.getCorStLeftsleeveCorrect()));
		orderFm.setCorStBackdartsPackCorrectFm(getCorrectValue(order.getCorStBackdartsPackCorrect()));
		orderFm.setCorStBackdartsUnpackCorrectFm(getCorrectValue(order.getCorStBackdartsUnpackCorrect()));
		orderFm.setCorStRightcuffsSurroundingCorrectFm(getCorrectValue(order.getCorStRightcuffsSurroundingCorrect()));
		orderFm.setCorStLeftcuffsSurroundingCorrectFm(getCorrectValue(order.getCorStLeftcuffsSurroundingCorrect()));
		
		
		//注文内容確認書と工場指示書の標示設定
		String productItem = order.getProductItem();
		
		//SUIT（01）、JACKET（02）、PANTS（03）、GILET（04）の場合
		if ("01".equals(productItem) || "02".equals(productItem) || "03".equals(productItem) || "04".equals(productItem)) {
			//注文内容確認書
			orderFm.setOrderKakuninSign("1");
			//注文内容確認書_お客様向け
			orderFm.setOrderKakuninKyakSign("2");
			//工場指示書
			orderFm.setFactorySijiSign("3");
			//工場指示書(中国語)
			orderFm.setChineseSijiSign("10");
			
		//SHIRT（05）の場合
		} else if ("05".equals(productItem)) {
			//注文内容確認書
			orderFm.setOrderKakuninSign("7");
			//注文内容確認書_お客様向け
			orderFm.setOrderKakuninKyakSign("8");
			//工場指示書
			orderFm.setFactorySijiSign("9");
			//工場指示書(中国語)
			orderFm.setChineseSijiSign("11");
			
		//COAT（06）の場合
		}  else if ("06".equals(productItem)) {
			//注文内容確認書
			orderFm.setOrderKakuninSign("4");
			//注文内容確認書_お客様向け
			orderFm.setOrderKakuninKyakSign("5");
			//工場指示書
			orderFm.setFactorySijiSign("6");
			//工場指示書(中国語)
			orderFm.setChineseSijiSign("12");
		}
		
	}
	
	/**
	 * 半角コンマを全角スペースに置換する
	 * @return　置換後の文字列
	 */
	public String getHalfReplaceValue(String src) {
		String sourceString = "";
		
		//文字列が空もしくはnullの場合、空を返す
		if (null == src || 0 == src.length()) {
			sourceString = src;
			
		} else {
			sourceString = src.replace(half_slash, zen_space);
		}
		
		return sourceString;
	}

	/**
	 * 上代価格の変換
	 * @return　変換後の上代価格
	 */
	public String getRtValue(Integer src) {
		
		String sourceString = "";
		
		//上代価格が空もしくは0の場合、無料を返す
		if (null == src || 0 == src) {
			sourceString = "無料";
			
		} else {
			try {
				BigDecimal value=new BigDecimal(src);
				DecimalFormat df=new DecimalFormat(",###");
				sourceString = "￥" + df.format(value);
				
			} catch (NumberFormatException e) {
				sourceString = "無料";
			}
		}
		
		return sourceString;
	}
	
	/**
	 * オプション金額の変換
	 * @return　変換後のオプション金額
	 */
	public String getFormatMoneyValue(Integer src) {
		
		String sourceString = "";
		
		//オプション金額が空もしくは0以外の場合、変換処理を行う
		if (!(null == src)) {
			try {
				BigDecimal value=new BigDecimal(src);
				DecimalFormat df=new DecimalFormat(",###");
				sourceString = "￥" + df.format(value);
				
			} catch (NumberFormatException e) {
				//何にもなし
			}
		}
		
		return sourceString;
	}
	
	/**
	 * 補正値の設定
	 * @return 変換後の補正値
	 */
	public String getCorrectValue(BigDecimal src) {
		
		String sourceString = "";
		
		//上代価格が空もしくは0の場合、無料を返す
		if (null != src) {
			if(src.toString().indexOf("-") == -1){
				sourceString = "+" + src;
			}
			else{
				sourceString = src.toString();
			}
		} else {
			sourceString = "0.0";
		}
		
		return sourceString + "cm";
	}
	
	/**
	 * 箇所名と色名の変換処理
	 * 例：箇所名-色名△△箇所名-色名△△箇所名-色名<br>
	 * @return　置換後の文字列
	 */
	public  String getHalfReplaceMap(String colorNm, String colorPlcNm) {
		String sourceString = "";
		
		//文字列が空もしくはnullの場合、空を返す
		if ((null == colorNm || 0 == colorNm.length()) || (null == colorPlcNm || 0 == colorPlcNm.length())) {
			sourceString = "";
			
		} else {
			try {
				String[] strColorNm = colorNm.split("/");
				String[] strColorPlcNm = colorPlcNm.split("/");
				
				for (int i = 0; i < strColorNm.length; i++) {
					
					sourceString = sourceString + strColorPlcNm[i] + "-" + strColorNm[i] + zen_space;
					
					if (i > 0 && (i + 1) % 3 == 0 &&  (i + 1) != strColorPlcNm.length) {
						sourceString = sourceString + "<br>"  + zen_space + zen_space;
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// 何にもしない
			}
		}
		return sourceString;
	}
}
