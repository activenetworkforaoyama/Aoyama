package co.jp.aoyama.macchinetta.domain.service.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.Factory;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.model.Shop;
import co.jp.aoyama.macchinetta.domain.repository.factory.FactoryRepository;
import co.jp.aoyama.macchinetta.domain.repository.measuring.MeasuringRepository;
import co.jp.aoyama.macchinetta.domain.repository.orderlist.OrderListRepository;
import co.jp.aoyama.macchinetta.domain.repository.shop.ShopRepository;
import jp.co.hos.coreports.CrDraw;
import jp.co.hos.coreports.CrForm;
import jp.co.hos.coreports.CrStreamOutJob;
import jp.co.hos.coreports.constants.CorDocumentType;
import jp.co.hos.coreports.document.CrPdfDocument;

/**
 * pdfをダウンロードする
 * @author wuzhengyang
 *
 */
@Service
@Transactional
public class PdfFileServiceImpl implements PdfFileService{
	
	@Inject
	OrderListRepository orderListRepository;
	
	@Inject
	MeasuringRepository measuringRepository;
	
	@Inject
	FactoryRepository factoryRepository;
	
	@Inject
	ShopRepository shopRepository;
	
	private static final Logger logger = LoggerFactory
            .getLogger(PdfFileServiceImpl.class);
	
	/**
	 * pdfファイルの書き方
	 */
	@Override
	public ByteArrayOutputStream outputSamplePoPdf(String sign, Order order, Measuring measuring, String productItem) throws Exception{
		@SuppressWarnings("resource")
		//xmlファイルの読む込み
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"META-INF" + File.separator + "spring" + File.separator + "aoyama-macchinetta-customer.xml");
		
		//リソースを読み込むServiceのクラスを準備します
		CustomerService customerService = (CustomerService) appContext.getBean("customerService");
		
        // （１）描画クラスのインスタンスを生成します
        CrDraw draw = new CrDraw();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        try {
        	
            // （２）CrDrawのプロパティを設定します
            // フォームファイルを読み込むパスを指定します
            // 出力先のフォルダを指定します
            // 画像等のデータファイルが置いてあるディレクトリを設定します
            // 作業用ディレクトリを設定します
        	
            // （３）出力形式とファイル名を指定してファイル出力ジョブを生成します
            CrStreamOutJob strjob = new CrStreamOutJob(CorDocumentType.PDF, output);
            
            // （４）出力形式ごとのプロパティを設定します
            // ここではドキュメントを開くためのパスワードを設定しています
            CrPdfDocument doc = strjob.getDocument();
            
            CrForm form = null;
            // （５）フォームファイルを開きます
            if("1".equals(sign)) {
            	//注文内容確認書_工場向
            	doc.setDocumentName("注文内容確認書_工場向");
            	Resource resource = customerService.getResource("classpath:cfx" + File.separator 
            			+ "po" + File.separator + "confirmationBook-Factory.cfx");
            	form = CrForm.open(draw, resource.getInputStream());
			}else if("2".equals(sign)) {
				//注文内容確認書_お客様向
				doc.setDocumentName("注文内容確認書_お客様向");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "po" + File.separator + "confirmationBook-Guest.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("3".equals(sign)) {
				//工場指示書
				doc.setDocumentName("工場指示書");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "po" + File.separator + "factoryInstructions.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else{
				logger.info("このスタイルはありません");
			}
            try {
                // （６）ファイル出力ジョブを開始します
                draw.startJob(strjob);
                // （７）出力先の用紙サイズをフォームのサイズに設定します
                strjob.getCrPrinter().setFormSize(form);
                // （８）フォームファイル上の「Title」という名前のテキストフィールドに
                // 「Hello, World」という文字列を設定します
                if("1".equals(sign)) {
                	//注文内容確認書_工場向
                	insertCommonProject(form, order, productItem);
                	insertConfirmationBookFactorySpecial(form, order);
                	insertMeasuringData(form, measuring, "1");
                	insertOrderDataPo(form, order);
                	
    			}else if("2".equals(sign)) {
    				//注文内容確認書_お客様向
    				insertCommonProject(form, order, productItem);
    				insertConfirmationBookGuestSpecial(form, order);
    				insertMeasuringData(form, measuring, "1");
    				insertOrderDataPo(form, order);
    				
    			}else if("3".equals(sign)) {
    				//工場指示書
    				insertCommonProject(form, order, productItem);
    				insertfactoryInstructionsSpecial(form, order);
    				insertMeasuringData(form, measuring, "1");
    				insertOrderDataPo(form, order);
    				
    			}else{
    				 logger.info("このスタイルはありません");
    			}
            	
            	// （９）１ページ出力します
                form.printOut();
                // （１０）ファイル出力ジョブを終了します
                draw.endJob();
            } finally {
                // （１１）フォームを閉じます
                form.close();
            }
        } catch (Exception cex) {
            // シーオーリポーツ内で発生した例外を処理します
            cex.printStackTrace();
            // 実行中のジョブがあれば破棄します
            draw.abortJob();
            logger.info(cex.toString());
        } finally {
            // （１２）描画クラスの後処理を行います
            draw.deleteInstance();

        }
        return output;
    }
	
	public ByteArrayOutputStream outputSampleCoPdf(String sign, Order order, Measuring measuring, String productItem) throws Exception{
    	@SuppressWarnings("resource")
		//xmlファイルの読む込み
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"META-INF" + File.separator + "spring" + File.separator + "aoyama-macchinetta-customer.xml");
		
		//リソースを読み込むServiceのクラスを準備します
		CustomerService customerService = (CustomerService) appContext.getBean("customerService");
    	
        // （１）描画クラスのインスタンスを生成します
        CrDraw draw = new CrDraw();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        try {
        	
            // （２）CrDrawのプロパティを設定します
            // フォームファイルを読み込むパスを指定します
            // 出力先のフォルダを指定します
            // 画像等のデータファイルが置いてあるディレクトリを設定します
            // 作業用ディレクトリを設定します
        	
            // （３）出力形式とファイル名を指定してファイル出力ジョブを生成します
            CrStreamOutJob strjob = new CrStreamOutJob(CorDocumentType.PDF, output);
            
            // （４）出力形式ごとのプロパティを設定します
            // ここではドキュメントを開くためのパスワードを設定しています
            CrPdfDocument doc = strjob.getDocument();
            
            CrForm form = null;
            // （５）フォームファイルを開きます
            if("1".equals(sign)) {
            	//注文内容確認書(SUIT)_工場向
            	doc.setDocumentName("注文内容確認書(SUIT)_工場向");
            	Resource resource = customerService.getResource("classpath:cfx" + File.separator 
            			+ "co" + File.separator + "confirmationBookSuit-Factory.cfx");
            	form = CrForm.open(draw, resource.getInputStream());
			}else if("2".equals(sign)) {
				//注文内容確認書(SUIT)_お客様向
				doc.setDocumentName("注文内容確認書(SUIT)_お客様向");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "confirmationBookSuit-Guest.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("3".equals(sign)) {
				//工場指示書(SUIT)
				doc.setDocumentName("工場指示書(SUIT)");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "factoryInstructionsSuit.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("4".equals(sign)) {
				//注文内容確認書(COAT)_工場向
				doc.setDocumentName("注文内容確認書(COAT)_工場向");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "confirmationBookCoat-Factory.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("5".equals(sign)) {
				//注文内容確認書(COAT)_お客様向
				doc.setDocumentName("注文内容確認書(COAT)_お客様向");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "confirmationBookCoat-Guest.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("6".equals(sign)) {
				//工場指示書(COAT)
				doc.setDocumentName("工場指示書(COAT)");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "factoryInstructionsCoat.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("7".equals(sign)) {
				//注文内容確認書(SHIRT)_工場向
				doc.setDocumentName("注文内容確認書(SHIRT)_工場向");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "confirmationBookShirt-Factory.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("8".equals(sign)) {
				//注文内容確認書(SHIRT)_お客様向
				doc.setDocumentName("注文内容確認書(SHIRT)_お客様向");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "confirmationBookShirt-Guest.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("9".equals(sign)) {
				//工場指示書(SHIRT)
				doc.setDocumentName("工場指示書(SHIRT)");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "factoryInstructionsShirt.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else{
				logger.info("このスタイルはありません");
			}
            
            try {
                // （６）ファイル出力ジョブを開始します
                draw.startJob(strjob);
                // （７）出力先の用紙サイズをフォームのサイズに設定します
                strjob.getCrPrinter().setFormSize(form);
                // （８）フォームファイル上の「Title」という名前のテキストフィールドに
                // 「Hello, World」という文字列を設定します
                if("1".equals(sign)) {
                	//注文内容確認書(SUIT)_工場向
                	insertCommonProject(form, order, productItem);
                	insertConfirmationBookFactorySpecial(form, order);
                	insertMeasuringData(form, measuring, "1");
                	insertSuitDataCo(form, order);
                	
                	insertJacketdetailedFieldDataCo(form, order);
            		insertPantsdetailedFieldDataCo(form, order);
            		insertPants2detailedFieldDataCo(form, order);
            		insertGiletdetailedFieldDataCo(form, order);
                	
//                	if("21".equals(order.getProductItemDisplaycode())) {
//                		//SUIT(2p)
//                		
//                	}else if("22".equals(order.getProductItemDisplaycode())) {
//                		//SUIT(2pp)
//                		
//                	}else if("31".equals(order.getProductItemDisplaycode())) {
//                		//SUIT(3p)
//                		
//                	}else if("32".equals(order.getProductItemDisplaycode())) {
//                		//SUIT(3p2pp)
//                		
//                	}
                	
    			}else if("2".equals(sign)) {
    				//注文内容確認書(SUIT)_お客様向
    				insertCommonProject(form, order, productItem);
    				insertConfirmationBookGuestSpecial(form, order);
    				insertMeasuringData(form, measuring, "0");
    				insertSuitDataCo(form, order);
    				
    				insertJacketdetailedFieldDataCo(form, order);
            		insertPantsdetailedFieldDataCo(form, order);
            		insertPants2detailedFieldDataCo(form, order);
            		insertGiletdetailedFieldDataCo(form, order);
    				
    			}else if("3".equals(sign)) {
    				//工場指示書(SUIT)
    				insertCommonProject(form, order, productItem);
    				insertfactoryInstructionsSpecial(form, order);
    				insertMeasuringData(form, measuring, "1");
    				insertSuitDataCo(form, order);
    				
    				insertJacketdetailedFieldDataCo(form, order);
            		insertPantsdetailedFieldDataCo(form, order);
            		insertPants2detailedFieldDataCo(form, order);
            		insertGiletdetailedFieldDataCo(form, order);
    				
    			}else if("4".equals(sign)) {
    				//注文内容確認書(COAT)_工場向
    				insertCommonProject(form, order, productItem);
    				insertConfirmationBookFactorySpecial(form, order);
    				insertMeasuringData(form, measuring, "1");
    				insertCoatDataCo(form, order);
    				
    			}else if("5".equals(sign)) {
    				//注文内容確認書(COAT)_お客様向
    				insertCommonProject(form, order, productItem);
    				insertConfirmationBookGuestSpecial(form, order);
    				insertMeasuringData(form, measuring, "1");
    				insertCoatDataCo(form, order);
    				
    			}else if("6".equals(sign)) {
    				//工場指示書(COAT)
    				insertCommonProject(form, order, productItem);
    				insertfactoryInstructionsSpecial(form, order);
    				insertMeasuringData(form, measuring, "1");
    				insertCoatDataCo(form, order);
    				
    			}else if("7".equals(sign)) {
    				//注文内容確認書(SHIRT)_工場向
    				insertCommonProject(form, order, productItem);
    				insertConfirmationBookFactorySpecial(form, order);
    				insertMeasuringData(form, measuring, "1");
    				insertShirtDataCo(form, order);
    				
    			}else if("8".equals(sign)) {
    				//注文内容確認書(SHIRT)_お客様向
    				insertCommonProject(form, order, productItem);
    				insertConfirmationBookGuestSpecial(form, order);
    				insertMeasuringData(form, measuring, "1");
    				insertShirtDataCo(form, order);
    				
    			}else if("9".equals(sign)) {
    				//工場指示書(SHIRT)
    				insertCommonProject(form, order, productItem);
    				insertfactoryInstructionsSpecial(form, order);
    				insertMeasuringData(form, measuring, "1");
    				insertShirtDataCo(form, order);
    				
    			}else{
    				logger.info("このスタイルはありません");
    			}
            	// （９）１ページ出力します
                form.printOut();
                // （１０）ファイル出力ジョブを終了します
                draw.endJob();
            } finally {
                // （１１）フォームを閉じます
                form.close();
            }
        } catch (Exception cex) {
            // シーオーリポーツ内で発生した例外を処理します
            cex.printStackTrace();
            // 実行中のジョブがあれば破棄します
            draw.abortJob();
            logger.info(cex.toString());
        } finally {
            // （１２）描画クラスの後処理を行います
            draw.deleteInstance();

        }
        return output;
    }
	
	/**
	 * 共通のプロジェクト
	 * @param form
	 * @param order
	 */
	private void insertCommonProject(CrForm form, Order order, String productItem) {
		//注文ID
		form.getField("Order_id_data").setData(stringChange(order.getOrderId()));
		//EMBROIDERY,刺繡表示
		form.getField("Product_embroidery_nm_data").setData(stringChange(order.getProductEmbroideryNm()));
		//FONT,書体
		form.getField("Product_embroidery_font_data").setData(stringChange(order.getProductEmbroideryFont()));
		//COLOR,糸色
		form.getField("product_embroidery_thread_color_data").setData(stringChange(order.getProductEmbroideryThreadColor()));
		//カテゴリ
		if("0".equals(stringChange(order.getProductCategory()))) {
			form.getField("Product_category_data").setData("標準");
		}else if("1".equals(stringChange(order.getProductCategory()))) {
			form.getField("Product_category_data").setData("ウォッシャブル");
		}else if("2".equals(stringChange(order.getProductCategory()))) {
			form.getField("Product_category_data").setData("タキシード");
		}
		//承り日
		form.getField("Product_orderd_date_data").setData(dateChange(order.getProductOrderdDate()));
		
		//組成
		String ProductCompos = "";
		if(!("".equals(order.getProductComposFrtFabric()) || order.getProductComposFrtFabric() == null)) {
			ProductCompos = "【表地】"+order.getProductComposFrtFabric();
			if(!("".equals(order.getProductComposBodyLiner()) || order.getProductComposBodyLiner() == null)) {
				ProductCompos = ProductCompos+"  【胴裏地】"+order.getProductComposBodyLiner();
    		}
			if(!("".equals(order.getProductComposSleeveLiner()) || order.getProductComposSleeveLiner() == null)) {
				ProductCompos = ProductCompos+"  【袖裏地】"+order.getProductComposSleeveLiner();
    		}
		}else {
			if(!("".equals(order.getProductComposBodyLiner()) || order.getProductComposBodyLiner() == null)) {
				ProductCompos = "【胴裏地】"+order.getProductComposBodyLiner();
				if(!("".equals(order.getProductComposSleeveLiner()) || order.getProductComposSleeveLiner() == null)) {
    				ProductCompos = ProductCompos+"  【袖裏地】"+order.getProductComposSleeveLiner();
        		}
    		}else if(!("".equals(order.getProductComposSleeveLiner()) || order.getProductComposSleeveLiner() == null)) {
				ProductCompos = "【袖裏地】"+order.getProductComposSleeveLiner();
    		}
		}
    	form.getField("Product_compos_data").setData(ProductCompos);
    	//お客様備考
    	form.getField("Cust_remark_data").setData(stringChange(order.getCustRemark()));
		
		//品名,ITEM
		form.getField("Product_item_data").setData(stringChange(productItem));
		//工場ID.,FABRIC ID.
		form.getField("Product_fabric_no_data").setData(stringChange(order.getProductFabricNo()));
		//生地ブランド,BRAND　NAME　
		form.getField("Product_brand_nm_data").setData(stringChange(order.getProductFabricBrandNm()));
		//サービスネーム,SERVICE　NAME　
		form.getField("Product_service_nm_data").setData(stringChange(order.getProductServiceNm()));
		//取り扱い注意
		form.getField("Product_notice_data").setData(stringChange(order.getProductNotice()));
		//店舗名
		form.getField("Store_nm_data").setData(stringChange(order.getStoreNm()));
		//担当者名
		form.getField("Store_staff_nm_data").setData(stringChange(order.getCustStaff()));
	}
	
	/**
	 * 注文内容確認書_工場向の特別プロジェクト
	 * @param form
	 * @param order
	 */
	private void insertConfirmationBookFactorySpecial(CrForm form, Order order) {
		//名前
		form.getField("Name_data").setData("");
		//名簿納期
		form.getField("Cust_deliver_date_data").setData(dateChange(order.getCustDeliverDate()));
		//A行
		form.getField("Host_transmit_A_row_data").setData(stringChange(order.getHostTransmitARow()));
		form.getField("Host_transmit_A_row_numberdata").setData(stringChange(order.getHostTransmitARow()));
		//出荷番号
		form.getField("Shipping_no_data").setData("A"+stringChange(order.getShippingNumber())+"A");
		form.getField("Shipping_no_numberdata").setData("A"+stringChange(order.getShippingNumber())+"A");
	}
	
	/**
	 * 注文内容確認書_お客様向の特別プロジェクト
	 * @param form
	 * @param order
	 */
	private void insertConfirmationBookGuestSpecial(CrForm form, Order order) {
		//名前
		form.getField("Name_data").setData("");
		//名簿納期
		form.getField("Cust_deliver_date_data").setData(dateChange(order.getCustDeliverDate()));
		//合計金額（税抜）
		form.getField("Total_price_date").setData("￥"+addAmountSeparator(order.getCashProductPrice()));
		//合計金額（税込）
		form.getField("Billing_amount_date").setData("￥"+addAmountSeparator(order.getCashContailTaxProductPrice()));
	}
	
	/**
	 * 工場指示書の特別プロジェクト
	 * @param form
	 * @param order
	 */
	private void insertfactoryInstructionsSpecial(CrForm form, Order order) {
		//工場
		Factory factory = factoryRepository.findOne(order.getProductFactoryCd());
		if(factory != null) {
			form.getField("Product_factory_data").setData(stringChange(factory.getFactoryName()));
		}else {
			logger.info(order.getProductFactoryCd()+"対応する工場情報が存在しません。");
		}
		//お渡し日
		form.getField("Cust_shop_delivery_date_data").setData(dateChange(order.getCustShopDeliveryDate()));
	}
	
	/**
	 * 共通のmeasuringデータを挿入
	 * @param 
	 * @return 
	 */
	private void insertMeasuringData(CrForm form, Measuring measuring, String includeNeck) {
		if(measuring != null) {
			//フルレングス
			form.getField("Full_length_data").setData(bigDecimalChange(measuring.getFullLength()));
			//ショルダー
			form.getField("Shoulder_data").setData(bigDecimalChange(measuring.getShoulder()));
			//リーチ（右）
			form.getField("Reach_right_data").setData(bigDecimalChange(measuring.getReachRight()));
			//リーチ（左）
			form.getField("Reach_left_data").setData(bigDecimalChange(measuring.getReachLeft()));
			//アウトバスト
			form.getField("Out_bust_data").setData(bigDecimalChange(measuring.getOutBust()));
			//バスト
			form.getField("Bust_data").setData(bigDecimalChange(measuring.getBust()));
			//JKウエスト
			form.getField("Jacket_waist_data").setData(bigDecimalChange(measuring.getJacketWaist()));
			//PTウエスト
			form.getField("Pants_waist_data").setData(bigDecimalChange(measuring.getPantsWaist()));
			//ヒップ
			form.getField("Hip_data").setData(bigDecimalChange(measuring.getHip()));
			//ワタリ（右）
			form.getField("Span_right_data").setData(bigDecimalChange(measuring.getSpanRight()));
			//ワタリ（左）
			form.getField("Span_left_data").setData(bigDecimalChange(measuring.getSpanLeft()));
			//ふくらはぎ（右）
			form.getField("Calf_right_data").setData(bigDecimalChange(measuring.getCalfRight()));
			//ふくらはぎ（左）
			form.getField("Calf_left_data").setData(bigDecimalChange(measuring.getCalfLeft()));
			if("1".equals(includeNeck)) {
				//includeNeckは１の状況、neckを含む
				//ネック
				form.getField("Neck_data").setData(bigDecimalChange(measuring.getNeck()));
			}
		}else {
			//フルレングス
			form.getField("Full_length_data").setData("0");
			//ショルダー
			form.getField("Shoulder_data").setData("0");
			//リーチ（右）
			form.getField("Reach_right_data").setData("0");
			//リーチ（左）
			form.getField("Reach_left_data").setData("0");
			//アウトバスト
			form.getField("Out_bust_data").setData("0");
			//バスト
			form.getField("Bust_data").setData("0");
			//JKウエスト
			form.getField("Jacket_waist_data").setData("0");
			//PTウエスト
			form.getField("Pants_waist_data").setData("0");
			//ヒップ
			form.getField("Hip_data").setData("0");
			//ワタリ（右）
			form.getField("Span_right_data").setData("0");
			//ワタリ（左）
			form.getField("Span_left_data").setData("0");
			//ふくらはぎ（右）
			form.getField("Calf_right_data").setData("0");
			//ふくらはぎ（左）
			form.getField("Calf_left_data").setData("0");
			if("1".equals(includeNeck)) {
				//includeNeckは１の状況、neckを含む
				//ネック
				form.getField("Neck_data").setData("0");
			}
		}
	}
	
	/**
	 * 共通のデータを挿入Po
	 * @param 
	 * @return 
	 */
	private void insertOrderDataPo(CrForm form, Order order) {
		//JACKET
		//サイズ
		form.getField("Cor_jk_size_data").setData(stringChange(order.getCorJkDrop())+" - "+stringChange(order.getCorJkSize()));
		
		//型サイズ
		//着丈
		form.getField("Cor_jk_bodylength_size_data").setData(bigDecimalChange(order.getCorJkBodylengthSize()));
		//ウエスト
		form.getField("Cor_jk_waist_size_data").setData(bigDecimalChange(order.getCorJkWaistSize()));
		//袖丈右
		form.getField("Cor_jk_rightsleeve_size_data").setData(bigDecimalChange(order.getCorJkRightsleeveSize()));
		//袖丈左
		form.getField("Cor_jk_leftsleeve_size_data").setData(bigDecimalChange(order.getCorJkLeftsleeveSize()));
		
		//補正値
		//着丈
		form.getField("Cor_jk_bodylength_correct_data").setData(bigDecimalChange(order.getCorJkBodylengthCorrect()));
		//ウエスト
		form.getField("Cor_jk_waist_correct_data").setData(bigDecimalChange(order.getCorJkWaistCorrect()));
		//袖丈右
		form.getField("Cor_jk_rightsleeve_correct_data").setData(bigDecimalChange(order.getCorJkRightsleeveCorrect()));
		//袖丈左
		form.getField("Cor_jk_leftsleeve_correct_data").setData(bigDecimalChange(order.getCorJkLeftsleeveCorrect()));
		
		//グロス
		//着丈
		form.getField("Cor_jk_bodylength_gross_data").setData(bigDecimalChange(order.getCorJkBodylengthGross()));
		//ウエスト
		form.getField("Cor_jk_waist_gross_data").setData(bigDecimalChange(order.getCorJkWaistGross()));
		//袖丈右
		form.getField("Cor_jk_rightsleeve_gross_data").setData(bigDecimalChange(order.getCorJkRightsleeveGross()));
		//袖丈左
		form.getField("Cor_jk_leftsleeve_gross_data").setData(bigDecimalChange(order.getCorJkLeftsleeveGross()));
		
		//PANTS
		//サイズ
		form.getField("Cor_pt_size_data1").setData(stringChange(order.getCorPtDrop())+" - "+stringChange(order.getCorPtSize()));
		
		//型サイズ
		//ウエスト
		form.getField("Cor_pt_waist_size_data1").setData(bigDecimalChange(order.getCorPtWaistSize()));
		//ワタリ
		form.getField("Cor_pt_thighwidth_size_data1").setData(bigDecimalChange(order.getCorPtThighwidthSize()));
		//裾幅
		form.getField("Cor_pt_hemwidth_size_data1").setData(bigDecimalChange(order.getCorPtHemwidthSize()));
		//股下右
		form.getField("Cor_pt_rightinseam_size_data1").setData(bigDecimalChange(order.getCorPtRightinseamSize()));
		//股下左
		form.getField("Cor_pt_leftinseam_size_data1").setData(bigDecimalChange(order.getCorPtLeftinseamSize()));
		
		//補正値
		//ウエスト
		form.getField("Cor_pt_waist_correct_data1").setData(bigDecimalChange(order.getCorPtWaistCorrect()));
		//ワタリ
		form.getField("Cor_pt_thighwidth_correct_data1").setData(bigDecimalChange(order.getCorPtThighwidthCorrect()));
		//裾幅
		form.getField("Cor_pt_hemwidth_correct_data1").setData(bigDecimalChange(order.getCorPtHemwidthCorrect()));
		//股下右
		form.getField("Cor_pt_rightinseam_correct_data1").setData("");
		//股下左
		form.getField("Cor_pt_leftinseam_correct_data1").setData("");
		
		//グロス
		//ウエスト
		form.getField("Cor_pt_waist_gross_data1").setData(bigDecimalChange(order.getCorPtWaistGross()));
		//ワタリ
		form.getField("Cor_pt_thighwidth_gross_data1").setData(bigDecimalChange(order.getCorPtThighwidthGross()));
		//裾幅
		form.getField("Cor_pt_hemwidth_gross_data1").setData(bigDecimalChange(order.getCorPtHemwidthGross()));
		//股下右
		form.getField("Cor_pt_rightinseam_gross_data1").setData(bigDecimalChange(order.getCorPtRightinseamGross()));
		//股下左
		form.getField("Cor_pt_leftinseam_gross_data1").setData(bigDecimalChange(order.getCorPtLeftinseamGross()));
		
		//PANTS
		//サイズ
		form.getField("Cor_pt2_size_data").setData(stringChange(order.getCorPt2Drop())+" - "+stringChange(order.getCorPt2Size()));
		
		//型サイズ
		//ウエスト
		form.getField("Cor_pt2_waist_size_data").setData(bigDecimalChange(order.getCorPt2WaistSize()));
		//ワタリ
		form.getField("Cor_pt2_thighwidth_size_data").setData(bigDecimalChange(order.getCorPt2ThighwidthSize()));
		//裾幅
		form.getField("Cor_pt2_hemwidth_size_data").setData(bigDecimalChange(order.getCorPt2HemwidthSize()));
		//股下右
		form.getField("Cor_pt2_rightinseam_size_data").setData(bigDecimalChange(order.getCorPt2RightinseamSize()));
		//股下左
		form.getField("Cor_pt2_leftinseam_size_data").setData(bigDecimalChange(order.getCorPt2LeftinseamSize()));
		
		//補正値
		//ウエスト
		form.getField("Cor_pt2_waist_correct_data").setData(bigDecimalChange(order.getCorPt2WaistCorrect()));
		//ワタリ
		form.getField("Cor_pt2_thighwidth_correct_data").setData(bigDecimalChange(order.getCorPt2ThighwidthCorrect()));
		//裾幅
		form.getField("Cor_pt2_hemwidth_correct_data").setData(bigDecimalChange(order.getCorPt2HemwidthCorrect()));
		//股下右
		form.getField("Cor_pt2_rightinseam_correct_data").setData("");
		//股下左
		form.getField("Cor_pt2_leftinseam_correct_data").setData("");
		
		//グロス
		//ウエスト
		form.getField("Cor_pt2_waist_gross_data").setData(bigDecimalChange(order.getCorPt2WaistGross()));
		//ワタリ
		form.getField("Cor_pt2_thighwidth_gross_data").setData(bigDecimalChange(order.getCorPt2ThighwidthGross()));
		//裾幅
		form.getField("Cor_pt2_hemwidth_gross_data").setData(bigDecimalChange(order.getCorPt2HemwidthGross()));
		//股下右
		form.getField("Cor_pt2_rightinseam_gross_data").setData(bigDecimalChange(order.getCorPt2RightinseamGross()));
		//股下左
		form.getField("Cor_pt2_leftinseam_gross_data").setData(bigDecimalChange(order.getCorPt2LeftinseamGross()));
		
		//Gillet
		//サイズ
		form.getField("Cor_pt2_size1").setData(stringChange(order.getCorGlDrop())+" - "+stringChange(order.getCorGlSize()));
		
		//JACKET
		//JACKETモデル
		form.getField("Jk_model_cd_data").setData(stringChange(order.getJkModelNm()));
		//フロント釦数
		form.getField("Jk_frt_btn_data").setData(stringChange(order.getJkFrtBtnNm()));
		//ラペルデザイン
		form.getField("Jk_lapel_design_data").setData(stringChange(order.getJkLapelDesignNm()));
		//台場
		form.getField("Jk_daiba_data").setData(stringChange(order.getJkDaibaNm()));
		//裏仕様
		form.getField("Jk_inner_cloth_data").setData(stringChange(order.getJkInnerClothNm()));
		//腰ポケット
		form.getField("Jk_waist_pkt_data").setData(stringChange(order.getJkWaistPktNm()));
		//チェンジポケット
		form.getField("Jk_chg_pkt_data").setData(stringChange(order.getJkChgPktNm()));
		//スランテッドポケット
		form.getField("Jk_slanted_pkt_data").setData(stringChange(order.getJkSlantedPktNm()));
		//袖口
		form.getField("Jk_cuff_data").setData(stringChange(order.getJkCuffNm()));
		//ステッチ種類
		form.getField("Jk_amf_color_type_data").setData(stringChange(order.getJkStitchTypeNm()));
		//ベント
		form.getField("Jk_vent_data").setData(stringChange(order.getJkVentNm()));
		//胴裏素材
		form.getField("Jk_inner_body_cloth_data").setData(stringChange(order.getJkInnerBodyClothNm()));
		//袖裏素材
		form.getField("Jk_inner_sleeve_cloth_data").setData(stringChange(order.getJkInnerSleeveClothNm()));
		//釦素材
		form.getField("Jk_btn_material_data").setData(stringChange(order.getJkBtnMaterialNm()));
		
		//PANTS
		//PANTSモデル
		form.getField("Pt_model_data").setData(stringChange(order.getPtModelNm()));
		//タック
		form.getField("Pt_tack_data").setData(stringChange(order.getPtTackNm()));
		//アジャスター仕様
		form.getField("Pt_adjuster_data").setData(stringChange(order.getPtAdjusterNm()));
		//裾上げ
		form.getField("Pt_hem_up_data").setData(stringChange(order.getPtHemUpNm()));
		//ダブル幅
		form.getField("Pt_dbl_width_data").setData(stringChange(order.getPtDblWidthNm()));
		//釦素材
		form.getField("Pt_btn_material_data").setData(stringChange(order.getPtBtnMaterialNm()));
		//エイト（滑り止め）
		form.getField("Pt_non_slip_data").setData(stringChange(order.getPtNonSlipNm()));
		//シック（股補強）
		form.getField("Pt_chic_slip_data").setData(stringChange(order.getPtChicSlipNm()));
		//形状記憶
		form.getField("Pt_shape_memory_data").setData(stringChange(order.getPtShapeMemoryNm()));
		//靴ずれ
		form.getField("Pt_shoe_sore_data").setData(stringChange(order.getPtShoeSoreNm()));
		
		//PANTS
		//PANTSモデル
		form.getField("Pt_model_data2").setData(stringChange(order.getPt2ModelNm()));
		//タック
		form.getField("Pt_tack_data2").setData(stringChange(order.getPt2TackNm()));
		//アジャスター仕様
		form.getField("Pt_adjuster_data2").setData(stringChange(order.getPt2AdjusterNm()));
		//裾上げ
		form.getField("Pt_hem_up_data2").setData(stringChange(order.getPt2HemUpNm()));
		//ダブル幅
		form.getField("Pt_dbl_width_data2").setData(stringChange(order.getPt2DblWidthNm()));
		//釦素材
		form.getField("Pt_btn_material_data2").setData(stringChange(order.getPt2BtnMaterialNm()));
		//エイト（滑り止め）
		form.getField("Pt_non_slip_data2").setData(stringChange(order.getPt2NonSlipNm()));
		//シック（股補強）
		form.getField("Pt_chic_slip_data2").setData(stringChange(order.getPt2ChicSlipNm()));
		//形状記憶
		form.getField("Pt_shape_memory_data2").setData(stringChange(order.getPt2ShapeMemoryNm()));
		//靴ずれ
		form.getField("Pt_shoe_sore_data2").setData(stringChange(order.getPt2ShoeSoreNm()));
		
		//Gillet
		//GILETモデル
		form.getField("Gl_model_data").setData(stringChange(order.getGlModelNm()));
		//胸ポケット
		form.getField("Gl_breast_pkt_data").setData(stringChange(order.getGlBreastPktNm()));
		//AMFステッチ
		form.getField("Gl_amf_color_type_data").setData(stringChange(order.getGlAmfStitchNm()));
		//背裏地素材
		form.getField("Gl_back_cloth_data").setData(stringChange(order.getGlBackClothNm()));
		//内側裏地素材
		form.getField("Gl_innner_cloth_data").setData(stringChange(order.getGlInnnerClothNm()));
		//釦素材
		form.getField("Gl_frt_btn_data").setData(stringChange(order.getGlFrtBtnNm()));
	}

	private void insertSuitDataCo(CrForm form, Order order) {
		//JACKET
		//サイズ
		form.getField("Cor_jk_size_data").setData(order.getCorJkDrop()+" - "+order.getCorJkSize());
		
		//型サイズ
		//着丈
		form.getField("Cor_jk_bodylength_size_data").setData(bigDecimalChange(order.getCorJkBodylengthSize()));
		//ウエスト
		form.getField("Cor_jk_waist_size_data").setData(bigDecimalChange(order.getCorJkWaistSize()));
		//袖丈右
		form.getField("Cor_jk_rightsleeve_size_data").setData(bigDecimalChange(order.getCorJkRightsleeveSize()));
		//袖丈左
		form.getField("Cor_jk_leftsleeve_size_data").setData(bigDecimalChange(order.getCorJkLeftsleeveSize()));
		//肩パット
		form.getField("Cor_jk_shoulderpad_data").setData(order.getCorJkShoulderpad());
		//体型補正
		form.getField("Cor_jk_figure_correct_data").setData(order.getCorJkFigureCorrect());
								
		//補正値
		//着丈
		form.getField("Cor_jk_bodylength_correct_data").setData(bigDecimalChange(order.getCorJkBodylengthCorrect()));
		//ウエスト
		form.getField("Cor_jk_waist_correct_data").setData(bigDecimalChange(order.getCorJkWaistCorrect()));
		//袖丈右
		form.getField("Cor_jk_rightsleeve_correct_data").setData(bigDecimalChange(order.getCorJkRightsleeveCorrect()));
		//袖丈左
		form.getField("Cor_jk_leftsleeve_correct_data").setData(bigDecimalChange(order.getCorJkLeftsleeveCorrect()));
		
		//グロス
		//着丈
		form.getField("Cor_jk_bodylength_gross_data").setData(bigDecimalChange(order.getCorJkBodylengthGross()));
		//ウエスト
		form.getField("Cor_jk_waist_gross_data").setData(bigDecimalChange(order.getCorJkWaistGross()));
		//袖丈右
		form.getField("Cor_jk_rightsleeve_gross_data").setData(bigDecimalChange(order.getCorJkRightsleeveGross()));
		//袖丈左
		form.getField("Cor_jk_leftsleeve_gross_data").setData(bigDecimalChange(order.getCorJkLeftsleeveGross()));
		
		//PANTS
		//サイズ
		form.getField("Cor_pt_size_data1").setData(order.getCorPtDrop()+" - "+order.getCorPtSize());
		
		//型サイズ
		//ウエスト
		form.getField("Cor_pt_waist_size_data1").setData(bigDecimalChange(order.getCorPtWaistSize()));
		//ヒップ
		form.getField("Cor_pt_hip_size_data1").setData(bigDecimalChange(order.getCorPtHipSize()));
		//ワタリ
		form.getField("Cor_pt_thighwidth_size_data1").setData(bigDecimalChange(order.getCorPtThighwidthSize()));
		//裾幅
		form.getField("Cor_pt_hemwidth_size_data1").setData(bigDecimalChange(order.getCorPtHemwidthSize()));
		//股下右
		form.getField("Cor_pt_rightinseam_size_data1").setData(bigDecimalChange(order.getCorPtRightinseamSize()));
		//股下左
		form.getField("Cor_pt_leftinseam_size_data1").setData(bigDecimalChange(order.getCorPtLeftinseamSize()));
												
		//補正値
		//ウエスト
		form.getField("Cor_pt_waist_correct_data1").setData(bigDecimalChange(order.getCorPtWaistCorrect()));
		//ヒップ
		form.getField("Cor_pt_hip_correct_data1").setData(bigDecimalChange(order.getCorPtHipCorrect()));
		//ワタリ
		form.getField("Cor_pt_thighwidth_correct_data1").setData(bigDecimalChange(order.getCorPtThighwidthCorrect()));
		//裾幅
		form.getField("Cor_pt_hemwidth_correct_data1").setData(bigDecimalChange(order.getCorPtHemwidthCorrect()));
		//股下右
		form.getField("Cor_pt_rightinseam_correct_data1").setData("");
		//股下左
		form.getField("Cor_pt_leftinseam_correct_data1").setData("");
				
		//グロス
		//ウエスト
		form.getField("Cor_pt_waist_gross_data1").setData(bigDecimalChange(order.getCorPtWaistGross()));
		//ヒップ
		form.getField("Cor_pt_hip_gross_data1").setData(bigDecimalChange(order.getCorPtHipGross()));
		//ワタリ
		form.getField("Cor_pt_thighwidth_gross_data1").setData(bigDecimalChange(order.getCorPtThighwidthGross()));
		//裾幅
		form.getField("Cor_pt_hemwidth_gross_data1").setData(bigDecimalChange(order.getCorPtHemwidthGross()));
		//股下右
		form.getField("Cor_pt_rightinseam_gross_data1").setData(bigDecimalChange(order.getCorPtRightinseamGross()));
		//股下左
		form.getField("Cor_pt_leftinseam_gross_data1").setData(bigDecimalChange(order.getCorPtLeftinseamGross()));
		
		//PANTS
		//サイズ
		form.getField("Cor_pt2_size_data").setData(order.getCorPt2Drop()+" - "+order.getCorPt2Size());
		
		//型サイズ
		//ウエスト
		form.getField("Cor_pt2_waist_size_data").setData(bigDecimalChange(order.getCorPt2WaistSize()));
		//ヒップ
		form.getField("Cor_pt2_hip_size_data").setData(bigDecimalChange(order.getCorPt2HipSize()));
		//ワタリ
		form.getField("Cor_pt2_thighwidth_size_data").setData(bigDecimalChange(order.getCorPt2ThighwidthSize()));
		//裾幅
		form.getField("Cor_pt2_hemwidth_size_data").setData(bigDecimalChange(order.getCorPt2HemwidthSize()));
		//股下右
		form.getField("Cor_pt2_rightinseam_size_data").setData(bigDecimalChange(order.getCorPt2RightinseamSize()));
		//股下左
		form.getField("Cor_pt2_leftinseam_size_data").setData(bigDecimalChange(order.getCorPt2LeftinseamSize()));
											
		//補正値
		//ウエスト
		form.getField("Cor_pt2_waist_correct_data").setData(bigDecimalChange(order.getCorPt2WaistCorrect()));
		//ヒップ
		form.getField("Cor_pt2_hip_correct_data").setData(bigDecimalChange(order.getCorPt2HipCorrect()));
		//ワタリ
		form.getField("Cor_pt2_thighwidth_correct_data").setData(bigDecimalChange(order.getCorPt2ThighwidthCorrect()));
		//裾幅
		form.getField("Cor_pt2_hemwidth_correct_data").setData(bigDecimalChange(order.getCorPt2HemwidthCorrect()));
		//股下右
		form.getField("Cor_pt2_rightinseam_correct_data").setData("");
		//股下左
		form.getField("Cor_pt2_leftinseam_correct_data").setData("");
		
		//グロス
		//ウエスト
		form.getField("Cor_pt2_waist_gross_data").setData(bigDecimalChange(order.getCorPt2WaistGross()));
		//ヒップ
		form.getField("Cor_pt2_hip_gross_data").setData(bigDecimalChange(order.getCorPt2HipGross()));
		//ワタリ
		form.getField("Cor_pt2_thighwidth_gross_data").setData(bigDecimalChange(order.getCorPt2ThighwidthGross()));
		//裾幅
		form.getField("Cor_pt2_hemwidth_gross_data").setData(bigDecimalChange(order.getCorPt2HemwidthGross()));
		//股下右
		form.getField("Cor_pt2_rightinseam_gross_data").setData(bigDecimalChange(order.getCorPt2RightinseamGross()));
		//股下左
		form.getField("Cor_pt2_leftinseam_gross_data").setData(bigDecimalChange(order.getCorPt2LeftinseamGross()));
		
		//GILET
		//サイズ
		form.getField("cor_gl_size_data").setData(order.getCorGlDrop()+" - "+order.getCorGlSize());
		
		//型サイズ
		//ウエスト
		form.getField("Cor_gl_bodylength_size_data").setData(bigDecimalChange(order.getCorGlBodylengthSize()));
		//ヒップ
		form.getField("Cor_gl_bust_size_data").setData(bigDecimalChange(order.getCorGlBustSize()));
		//ワタリ
		form.getField("Cor_gl_waist_size_data").setData(bigDecimalChange(order.getCorGlWaistSize()));
		
		//補正値
		//ウエスト
		form.getField("Cor_gl_bodylength_correct_data").setData(bigDecimalChange(order.getCorGlBodylengthCorrect()));
		//ヒップ
		form.getField("Cor_gl_bust_correct_data").setData(bigDecimalChange(order.getCorGlBustCorrect()));
		//ワタリ
		form.getField("Cor_gl_waist_correct_data").setData(bigDecimalChange(order.getCorGlWaistCorrect()));
			
		//グロス
		//ウエスト
		form.getField("Cor_gl_bodylength_gross_data").setData(bigDecimalChange(order.getCorGlBodylengthGross()));
		//ヒップ
		form.getField("Cor_gl_bust_gross_data").setData(bigDecimalChange(order.getCorGlBustGross()));
		//ワタリ
		form.getField("Cor_gl_waist_gross_data").setData(bigDecimalChange(order.getCorGlWaistGross()));
		
		//JACKET
		//JACKETモデル
		form.getField("Jk_model_cd_data").setData("");
		//フロント釦数
		form.getField("Jk_frt_btn_data").setData(order.getJkFrtBtnNm());
		//ラペルデザイン
		form.getField("Jk_lapel_design_data").setData(order.getJkLapelDesignNm());
		//グレード
		form.getField("Jk_grade_data").setData(order.getJkGradeNm());
		//裏仕様
		form.getField("Jk_inner_cloth_data").setData(order.getJkInnerClothNm());
		//台場
		form.getField("Jk_daiba_data").setData(order.getJkDaibaNm());
		//拝見地
		form.getField("Jk_look_cloth_data").setData(order.getJkLookClothNm());
		//襟裏（ヒゲ）
		form.getField("Jk_collar_inner_data").setData(order.getJkCollarInnerNm());
		//襟吊
		form.getField("Jk_collar_hang_data").setData(order.getJkCollarHangNm());
		//ラペル幅
		form.getField("Jk_lapel_width_data").setData(order.getJkLapelWidthNm());
		//フラワーホール
		form.getField("Jk_flower_hole_data").setData(order.getJkFlowerHoleNm());
		//胸ポケット
		form.getField("Jk_breast_pkt_data").setData(order.getJkBreastPktNm());
		//腰ポケット
		form.getField("Jk_waist_pkt_data").setData(order.getJkWaistPktNm());
		//チェンジポケット
		form.getField("Jk_chg_pkt_data").setData(order.getJkChgPktNm());
		//スランテッドポケット
		form.getField("Jk_slanted_pkt_data").setData(order.getJkSlantedPktNm());
		//忍びポケット
		form.getField("Jk_shinobi_pkt_data").setData(order.getJkShinobiPktNm());
		//袖仕様
		form.getField("Jk_sleeve_type_data").setData(order.getJkSleeveTypeNm());
		//マニカ
		form.getField("Jk_manica_data").setData(order.getJkManicaNm());
		//袖釦
		form.getField("Jk_sleeve_btn_data").setData(order.getJkSleeveBtnNm());
		//袖口
		form.getField("Jk_cuff_data").setData(order.getJkCuffNm());
		//内ポケット変更
		form.getField("Jk_inner_pkt_data").setData(order.getJkInnerPktType());
		//下前胸内ポケット仕様
		form.getField("Jk_right_inner_pkt_type_data").setData(order.getJkRightInnerPktTypeNm());
		//ステッチ種類
		form.getField("Jk_stitch_type_data").setData(order.getJkStitchTypeNm());
		//ステッチ箇所変更
		form.getField("Jk_stitch_plc_data").setData(order.getJkStitchPlcType());
		//ダブルステッチ変更
		form.getField("Jk_dblstitch_plc_data").setData(order.getJkDblstitchPlcType());
		//AMF色指定
		form.getField("Jk_amf_color_data").setData(order.getJkAmfColorType());
		//ボタンホール色指定
		form.getField("Jk_btnhole_color_data").setData(order.getJkBtnholeColorType());
		//ボタン付け糸指定
		form.getField("Jk_btnthread_color_data").setData(order.getJkBtnthreadColorType());
		//ベント
		form.getField("Jk_vent_data").setData(order.getJkVentNm());
		//胴裏素材
		form.getField("Jk_inner_body_cloth_data").setData(order.getJkInnerBodyClothNm());
		//袖裏素材
		form.getField("Jk_inner_sleeve_cloth_data").setData(order.getJkInnerSleeveClothNm());
		//釦素材
		form.getField("Jk_btn_material_data").setData(order.getJkBtnMaterialNm());
		//形状記憶
		form.getField("Jk_shape_memory_data").setData(order.getJkShapeMemoryNm());
		
		//PANTS
		//PANTSモデル
		form.getField("Pt_model_data").setData(order.getPtModelNm());
		//タック
		form.getField("Pt_tack_data").setData(order.getPtTackNm());
		//膝裏
		form.getField("Pt_kneeinner_type_data").setData(order.getPtKneeinnerTypeNm());
		//膝裏素材
		form.getField("Pt_kneeinner_cloth_data").setData(order.getPtKneeinnerClothNm());
		//フロント仕様
		form.getField("Pt_frt_type_data").setData(order.getPtFrtTypeNm());
		//パンチェリーナ
		form.getField("Pt_pancherina_data").setData(order.getPtPancherinaNm());
		//アジャスター仕様
		form.getField("Pt_adjuster_data").setData(order.getPtAdjusterNm());
		//ベルトループ
		form.getField("Pt_beltloop_data").setData(order.getPtBeltloopType());
		//ピンループ
		form.getField("Pt_pinloop_data").setData(order.getPtPinloopNm());
		//脇ポケット
		form.getField("Pt_side_pkt_data").setData(order.getPtSidePktNm());
		//忍びポケット
		form.getField("Pt_shinobi_pkt_data").setData(order.getPtShinobiPktNm());
		//コインポケット
		form.getField("Pt_coin_pkt_cd_data").setData(order.getPtCoinPktNm());
		//フラップ付コインポケット
		form.getField("Pt_flapcoin_pkt_data").setData(order.getPtFlapcoinPktNm());
		//上前ピスポケット
		form.getField("Pt_left_pis_pkt_data").setData(order.getPtLeftPisPktNm());
		//下前ピスポケット
		form.getField("Pt_right_pis_pkt_data").setData(order.getPtRightPisPktNm());
		//Vカット
		form.getField("Pt_v_cut_data").setData(order.getPtVCutNm());
		//裾上げ
		form.getField("Pt_hem_up_data").setData(order.getPtHemUpNm());
		//ダブル幅
		form.getField("Pt_dbl_width_data").setData(order.getPtDblWidthNm());
		//ステッチ種類
		form.getField("Pt_stitch_type_data").setData("");
		//ステッチ箇所変更
		form.getField("Pt_stitch_plc_data").setData(order.getPtStitchPlcType());
		//ダブルステッチ
		form.getField("Pt_dblstitch_plc_data").setData(order.getPtDblstitchPlcType());
		//AMF色指定
		form.getField("Pt_amf_color_data").setData(order.getPtAmfColorType());
		//ボタンホール色指定
		form.getField("Pt_btnhole_color_data").setData(order.getPtBtnholeColorType());
		//ボタン付け糸指定
		form.getField("Pt_btnthread_color_data").setData(order.getPtBtnthreadColorType());
		//釦素材
		form.getField("Pt_btn_material_data").setData(order.getPtBtnMaterialNm());
		//サスペンダー釦
		form.getField("Pt_suspender_btn_data").setData(order.getPtSuspenderBtnNm());
		//エイト（滑り止め）
		form.getField("Pt_non_slip_data").setData(order.getPtNonSlipNm());
		//シック（股補強）
		form.getField("Pt_chic_slip_data").setData(order.getPtChicSlipNm());
		//形状記憶
		form.getField("Pt_shape_memory_data").setData(order.getPtShapeMemoryNm());
		//側章
		form.getField("Pt_side_stripe_data").setData(order.getPtSideStripeNm());
		//側章幅
		form.getField("Pt_side_stripe_width_data").setData(order.getPtSideStripeWidthNm());
		
		//PANTS
		//PANTSモデル
		form.getField("Pt_model_data2").setData(order.getPt2ModelNm());
		//タック
		form.getField("Pt_tack_data2").setData(order.getPt2TackNm());
		//膝裏
		form.getField("Pt_kneeinner_type_data2").setData(order.getPt2KneeinnerTypeNm());
		//膝裏素材
		form.getField("Pt_kneeinner_cloth_data2").setData(order.getPt2KneeinnerClothNm());
		//フロント仕様
		form.getField("Pt_frt_type_data2").setData(order.getPt2FrtTypeNm());
		//パンチェリーナ
		form.getField("Pt_pancherina_data2").setData(order.getPt2PancherinaNm());
		//アジャスター仕様
		form.getField("Pt_adjuster_data2").setData(order.getPt2AdjusterNm());
		//ベルトループ
		form.getField("Pt_beltloop_data2").setData(order.getPt2BeltloopType());
		//ピンループ
		form.getField("Pt_pinloop_data2").setData(order.getPt2PinloopNm());
		//脇ポケット
		form.getField("Pt_side_pkt_data2").setData(order.getPt2SidePktNm());
		//忍びポケット
		form.getField("Pt_shinobi_pkt_data2").setData(order.getPt2ShinobiPktNm());
		//コインポケット
		form.getField("Pt_coin_pkt_cd_data2").setData(order.getPt2CoinPktNm());
		//フラップ付コインポケット
		form.getField("Pt_flapcoin_pkt_data2").setData(order.getPt2FlapcoinPktNm());
		//上前ピスポケット
		form.getField("Pt_left_pis_pkt_data2").setData(order.getPt2LeftPisPktNm());
		//下前ピスポケット
		form.getField("Pt_right_pis_pkt_data2").setData(order.getPt2RightPisPktNm());
		//Vカット
		form.getField("Pt_v_cut_data2").setData(order.getPt2VCutNm());
		//裾上げ
		form.getField("Pt_hem_up_data2").setData(order.getPt2HemUpNm());
		//ダブル幅
		form.getField("Pt_dbl_width_data2").setData(order.getPt2DblWidthNm());
		//ステッチ種類
		form.getField("Pt_stitch_type_data2").setData("");
		//ステッチ箇所変更
		form.getField("Pt_stitch_plc_data2").setData(order.getPt2StitchPlcType());
		//ダブルステッチ
		form.getField("Pt_dblstitch_plc_data2").setData(order.getPt2DblstitchPlcType());
		//AMF色指定
		form.getField("Pt_amf_color_data2").setData(order.getPt2AmfColorType());
		//ボタンホール色指定
		form.getField("Pt_btnhole_color_data2").setData(order.getPt2BtnholeColorType());
		//ボタン付け糸指定
		form.getField("Pt_btnthread_color_data2").setData(order.getPt2BtnthreadColorType());
		//釦素材
		form.getField("Pt_btn_material_data2").setData(order.getPt2BtnMaterialNm());
		//サスペンダー釦
		form.getField("Pt_suspender_btn_data2").setData(order.getPt2SuspenderBtnNm());
		//エイト（滑り止め）
		form.getField("Pt_non_slip_data2").setData(order.getPt2NonSlipNm());
		//シック（股補強）
		form.getField("Pt_chic_slip_data2").setData(order.getPt2ChicSlipNm());
		//形状記憶
		form.getField("Pt_shape_memory_data2").setData(order.getPt2ShapeMemoryNm());
		//側章
		form.getField("Pt_side_stripe_data2").setData(order.getPt2SideStripeNm());
		//側章幅
		form.getField("Pt_side_stripe_width_data2").setData(order.getPt2SideStripeWidthNm());
		
		//GILET
		//GILETモデル
		form.getField("Gl_model_data").setData(order.getGlModelNm());
		//胸ポケット
		form.getField("Gl_breast_pkt_data").setData(order.getGlBreastPktNm());
		//腰ポケット
		form.getField("Gl_waist_pkt_data").setData(order.getGlWaistPktNm());
		//腰ポケット形状
		form.getField("Gl_waist_pkt_shape_data").setData(order.getGlWaistPktShapeNm());
		//腰ポケット素材
		form.getField("Gl_waist_pkt_cloth_data").setData(order.getGlWaistPktClothNm());
		//ステッチ種類
		form.getField("Gl_stitch_type_data").setData("");
		//ステッチ箇所変更
		form.getField("Gl_stitch_plc_data").setData(order.getGlStitchPlcType());
		//ダブルステッチ変更
		form.getField("Gl_dblstitch_plc_data").setData(order.getGlDblstitchPlcNm());
		//AMF色指定
		form.getField("Gl_amf_color_data").setData(order.getGlAmfColorType());
		//ボタンホール色指定
		form.getField("Gl_btnhole_color_data").setData(order.getGlBtnholeColorType());
		//ボタン付け糸指定
		form.getField("Gl_btnthread_color_data").setData(order.getGlBtnthreadColorType());
		//背裏地素材
		form.getField("Gl_back_cloth_data").setData(order.getGlBackClothNm());
		//内側裏地素材
		form.getField("Gl_innner_cloth_data").setData(order.getGlInnnerClothNm());
		//釦素材
		form.getField("Gl_btn_material_data").setData(order.getGlFrtBtnNm());
		//バックベルト
		form.getField("Gl_back_belt_data").setData(order.getGlBackBeltNm());
		//ウォッチチェーン
		form.getField("Gl_watch_chain_data").setData(order.getGlWatchChainNm());			
	}
	
	private void insertCoatDataCo(CrForm form, Order order) {
		//COAT
		//サイズ
		form.getField("Cor_ct_size_data").setData(order.getCorCtSize());
		
		//型サイズ
		//着丈
		form.getField("Cor_ct_bodylength_size_data").setData(bigDecimalChange(order.getCorCtBodylengthSize()));
		//ウエスト
		form.getField("Cor_ct_waist_size_data").setData(bigDecimalChange(order.getCorCtWaistSize()));
		//袖丈右
		form.getField("Cor_ct_rightsleeve_size_data").setData(bigDecimalChange(order.getCorCtRightsleeveSize()));
		//袖丈左
		form.getField("Cor_ct_leftsleeve_size_data").setData(bigDecimalChange(order.getCorCtLeftsleeveSize()));
		//ベンツ
		form.getField("Cor_ct_venthight_size_data").setData(bigDecimalChange(order.getCorCtVenthightSize()));
		//ポケット位置
		form.getField("Cor_ct_pktpos_size_data").setData(bigDecimalChange(order.getCorCtPktposSize()));
									
		//補正値
		//着丈
		form.getField("Cor_ct_bodylength_correct_data").setData(bigDecimalChange(order.getCorCtBodylengthCorrect()));
		//ウエスト
		form.getField("Cor_ct_waist_correct_data").setData(bigDecimalChange(order.getCorCtWaistCorrect()));
		//袖丈右
		form.getField("Cor_ct_rightsleeve_correct_data").setData(bigDecimalChange(order.getCorCtRightsleeveCorrect()));
		//袖丈左
		form.getField("Cor_ct_leftsleeve_correct_data").setData(bigDecimalChange(order.getCorCtLeftsleeveCorrect()));
		//ベンツ
		form.getField("Cor_ct_venthight_correct_data").setData(bigDecimalChange(order.getCorCtVenthightCorrect()));
		//ポケット位置
		form.getField("Cor_ct_pktpos_correct_data").setData(bigDecimalChange(order.getCorCtPktposCorrect()));
						
		//グロス
		//着丈		
		form.getField("Cor_ct_bodylength_gross_data").setData(bigDecimalChange(order.getCorCtBodylengthGross()));
		//ウエスト
		form.getField("Cor_ct_waist_gross_data").setData(bigDecimalChange(order.getCorCtWaistGross()));
		//袖丈右
		form.getField("Cor_ct_rightsleeve_gross_data").setData(bigDecimalChange(order.getCorCtRightsleeveGross()));
		//袖丈左
		form.getField("Cor_ct_leftsleeve_gross_data").setData(bigDecimalChange(order.getCorCtLeftsleeveGross()));
		//ベンツ
		form.getField("Cor_ct_venthight_gross_data").setData(bigDecimalChange(order.getCorCtVenthightGross()));
		//ポケット位置
		form.getField("Cor_ct_pktpos_gross_data").setData(bigDecimalChange(order.getCorCtPktposGross()));
		
		//COAT
		//COATモデル
		form.getField("Ct_model_data").setData(order.getCtModelNm());
		//ラペルデザイン
		form.getField("Ct_lapel_design_data").setData(order.getCtLapelDesignNm());
		//袖仕様
		form.getField("Ct_sleeve_type_data").setData(order.getCtSleeveTypeNm());
		//腰ポケット
		form.getField("Ct_waist_pkt_data").setData(order.getCtWaistPktNm());
		//チェンジポケット
		form.getField("Ct_chg_pkt_data").setData(order.getCtChgPktNm());
		//スランテッドポケット
		form.getField("Ct_slanted_pkt_data").setData(order.getCtSlantedPktNm());
		//ベント
		form.getField("Ct_vent_data").setData(order.getCtVentNm());
		//フロント釦数
		form.getField("Ct_frt_btn_data").setData(order.getCtFrtBtnNm());
		//袖口
		form.getField("Ct_cuff_data").setData(order.getCtCuffNm());
		//袖釦
		form.getField("Ct_sleeve_btn_data").setData(order.getCtSleeveBtnNm());
		//襟吊
		form.getField("Ct_collar_hang_data").setData(order.getCtCollarHangNm());
		//胴裏地
		form.getField("Ct_inner_body_cloth_data").setData(order.getCtInnerBodyClothNm());
		//袖裏地
		form.getField("Ct_inner_sleeve_cloth_data").setData(order.getCtInnerSleeveClothNm());
		//釦素材
		form.getField("Ct_btn_material_data").setData(order.getCtBtnMaterialNm());
	}
	
	private void insertShirtDataCo(CrForm form, Order order) {
		//SHIRT
		//サイズ
		form.getField("Cor_st_size_data").setData(order.getCorStSize());
		
		//型サイズ
		//ネック
		form.getField("Cor_st_neck_size_data").setData(bigDecimalChange(order.getCorStNeckSize()));
		//着丈
		form.getField("Cor_st_bodylength_size_data").setData(bigDecimalChange(order.getCorStBodylengthSize()));
		//袖丈右
		form.getField("Cor_st_rightsleeve_size_data").setData(bigDecimalChange(order.getCorStRightsleeveSize()));
		//袖丈左
		form.getField("Cor_st_leftsleeve_size_data").setData(bigDecimalChange(order.getCorStLeftsleeveSize()));
		//背ダーツ詰め
		form.getField("Cor_st_backdarts_pack_size_data").setData(bigDecimalChange(order.getCorStBackdartsPackSize()));
		//背ダーツ出し
		form.getField("Cor_st_backdarts_unpack_size_data").setData(bigDecimalChange(order.getCorStBackdartsUnpackSize()));
		//カフス周り右
		form.getField("Cor_st_rightcuffs_surrounding_size_data").setData(bigDecimalChange(order.getCorStRightcuffsSurroundingSize()));
		//カフス周り左
		form.getField("Cor_st_leftcuffs_surrounding_size_data").setData(bigDecimalChange(order.getCorStLeftcuffsSurroundingSize()));
			
		//補正値
		//ネック
		form.getField("Cor_st_neck_correct_data").setData(bigDecimalChange(order.getCorStNeckCorrect()));
		//着丈
		form.getField("Cor_st_bodylength_correct_data").setData(bigDecimalChange(order.getCorStBodylengthCorrect()));
		//袖丈右
		form.getField("Cor_st_rightsleeve_correct_data").setData(bigDecimalChange(order.getCorStRightsleeveCorrect()));
		//袖丈左
		form.getField("Cor_st_leftsleeve_correct_data").setData(bigDecimalChange(order.getCorStLeftsleeveCorrect()));
		//背ダーツ詰め
		form.getField("Cor_st_backdarts_pack_correct_data").setData(bigDecimalChange(order.getCorStBackdartsPackCorrect()));
		//背ダーツ出し
		form.getField("Cor_st_backdarts_unpack_correct_data").setData(bigDecimalChange(order.getCorStBackdartsUnpackCorrect()));
		//カフス周り右
		form.getField("Cor_st_rightcuffs_surrounding_correct_data").setData(bigDecimalChange(order.getCorStRightcuffsSurroundingCorrect()));
		//カフス周り左
		form.getField("Cor_st_leftcuffs_surrounding_correct_data").setData(bigDecimalChange(order.getCorStLeftcuffsSurroundingCorrect()));
		
		//グロス
		//ネック
		form.getField("Cor_st_neck_gross_data").setData(bigDecimalChange(order.getCorStNeckGross()));
		//着丈
		form.getField("Cor_st_bodylength_gross_data").setData(bigDecimalChange(order.getCorStBodylengthGross()));
		//袖丈右
		form.getField("Cor_st_rightsleeve_gross_data").setData(bigDecimalChange(order.getCorStRightsleeveGross()));
		//袖丈左
		form.getField("Cor_st_leftsleeve_gross_data").setData(bigDecimalChange(order.getCorStLeftsleeveGross()));
		//背ダーツ詰め
		form.getField("Cor_st_backdarts_pack_gross_data").setData(bigDecimalChange(order.getCorStBackdartsPackGross()));
		//背ダーツ出し
		form.getField("Cor_st_backdarts_unpack_gross_data").setData(bigDecimalChange(order.getCorStBackdartsUnpackGross()));
		//カフス周り右
		form.getField("Cor_st_rightcuffs_surrounding_gross_data").setData(bigDecimalChange(order.getCorStRightcuffsSurroundingGross()));
		//カフス周り左
		form.getField("Cor_st_leftcuffs_surrounding_gross_data").setData(bigDecimalChange(order.getCorStLeftcuffsSurroundingGross()));
		
		//SHIRT
		//SHIRTモデル
		form.getField("St_model_data").setData(order.getStModelNm());
		//襟型
		form.getField("St_collar_type_data").setData(order.getStCollarTypeNm());
		//カフス
		form.getField("St_cuffs_data").setData(order.getStCuffsNm());
		//コンバーチブル
		form.getField("St_convertible_data").setData(order.getStConvertibleNm());
		//アジャスト釦
		form.getField("St_adjuster_btn_data").setData(order.getStAdjusterBtnNm());
		//クレリック仕様
		form.getField("St_cleric_data").setData(order.getStClericNm());
		//ダブルカフス仕様
		form.getField("St_dbl_cuffs_data").setData(order.getStDblCuffsNm());
		//カフスボタン追加
		form.getField("St_cuffs_btn_data").setData(order.getStCuffsBtnNm());
		//釦
		form.getField("St_btn_material_data").setData(order.getStBtnMaterialNm());
		//タブ釦
		form.getField("St_dbl_btn_data").setData(order.getStDblBtnNm());
		//ガントレットボタン位置
		form.getField("St_gauntlet_btn_pos_data").setData(order.getStGauntletBtnPosNm());
		//ピンホールピン
		form.getField("St_pinhole_pin_data").setData(order.getStPinholePinNm());
		//胸ポケット
		form.getField("St_breast_pkt_data").setData(order.getStBreastPktNm());
		//胸ポケット大きさ
		form.getField("St_breast_size_data").setData(order.getStBreastSizeNm());
		//フロントデザイン
		form.getField("St_frt_design_data").setData(order.getStFrtDesignNm());
		//ピンタックブザム
		form.getField("St_pintuck_bosom_data").setData(order.getStPintuckBosomNm());
		//ステッチ
		form.getField("St_stitch_data").setData(order.getStStitchNm());
		//カラーキーパー
		form.getField("St_colar_keeper_data").setData(order.getStColarKeeperNm());
		//ボタンホール色変更
		form.getField("St_btnhole_color_cd_data").setData("");
		//ボタン付け糸色変更
		form.getField("St_btnthread_color_data").setData(order.getStBtnthreadColorNm());
		//カジュアルヘムライン仕様
		form.getField("St_casual_hemline_data").setData(order.getStCasualHemlineNm());
		//ボタン位置変更
		form.getField("St_btnpos_chg_data").setData(order.getStBtnposChgNm());
		
	}

	/**
	 * 変換bigDecimal型
	 * @param 
	 * @return 
	 */
	private String bigDecimalChange(BigDecimal bigDecimal) {
		if(bigDecimal != null){
			//空ではない
			return bigDecimal.toString();
		}else {
			//空
			return "";
		}
	}
	
	/**
	 * 変換date型
	 * @param 
	 * @return 
	 */
	private String dateChange(Date date) {
		String dateStr = null;
		SimpleDateFormat spinningLimitDateSDF = new SimpleDateFormat("yyyy/MM/dd");
		if(date != null) {
			//空ではない
			dateStr = spinningLimitDateSDF.format(date);
			return dateStr;
		}else {
			//空
			return "";
		}
	}
	
	/**
	 * stringタイプが空かどうかを判断します
	 * @param 
	 * @return 
	 */
	private String stringChange(String string) {
		if(string != null){
			//空ではない
			return string;
		}else {
			//空
			return "";
		}
	}
	
	/**
	 * 金額区切り記号を追加
	 * @return
	 */
	private String addAmountSeparator(Integer integer) {
		String str = String.valueOf(integer);
		if(integer == null) {
			//空
			return "0";
		}else {
			StringBuilder StringBuilder = new StringBuilder(str);
			int amountNumber = (str.length() - 1) / 3;
			int remainderNumber = (str.length()) % 3;
			if(remainderNumber == 0) {
				for(int i = amountNumber; i >= 1; i--) {
					StringBuilder.insert((i * 3), ",");
				}
			}else if(remainderNumber == 1) {
				for(int i = amountNumber; i >= 1; i--) {
					StringBuilder.insert((i * 3 - 2), ",");
				}
			}else if(remainderNumber == 2) {
				for(int i = amountNumber; i >= 1; i--) {
					StringBuilder.insert((i * 3 - 1), ",");
				}
			}
			str = StringBuilder.toString();
		}
		return str;
	}
	
	/**
	 * JACKET詳細情報,PDFで印刷
	 * @return
	 */
	private void insertJacketdetailedFieldDataCo(CrForm form, Order order) {
		StringBuffer sbJacket = new StringBuffer();
		sbJacket.append("\r\n");
		
		//内ポケット
		String strJacketInnerPktNm = stringChange(order.getJkInnerPktNm());
		if(!("".equals(strJacketInnerPktNm))) {
			String[] dataJacketInnerPktNm = strJacketInnerPktNm.split(",");
			for(int i = 0; i < dataJacketInnerPktNm.length; i++) {
				if(i == dataJacketInnerPktNm.length-1) {
					sbJacket.append(dataJacketInnerPktNm[i]).append("\r\n");
				}else {
					sbJacket.append(dataJacketInnerPktNm[i]).append("  ");
				}
			}
		}else {
			sbJacket.append("\r\n");
			logger.info("JACKETの内ポケットは空です");
		}
		
		//ステッチ箇所変更
		String strJacketStitchPlcNm = stringChange(order.getJkStitchPlcNm());
		if(!("".equals(strJacketStitchPlcNm))) {
			String[] dataJacketStitchPlcNm = strJacketStitchPlcNm.split(",");
			for(int i = 0; i < dataJacketStitchPlcNm.length; i++) {
				if(i == dataJacketStitchPlcNm.length-1) {
					sbJacket.append(dataJacketStitchPlcNm[i]).append("\r\n");
				}else {
					sbJacket.append(dataJacketStitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbJacket.append("\r\n");
			logger.info("JACKETのステッチ箇所変更は空です");
		}
		
		//ダブルステッチ変更
		String strJacketDblstitchPlcNm = stringChange(order.getJkDblstitchPlcNm());
		if(!("".equals(strJacketDblstitchPlcNm))) {
		String[] dataJacketDblstitchPlcNm = strJacketDblstitchPlcNm.split(",");
			for(int i = 0; i < dataJacketDblstitchPlcNm.length; i++) {
				if(i == dataJacketDblstitchPlcNm.length-1) {
					sbJacket.append(dataJacketDblstitchPlcNm[i]).append("\r\n");
				}else {
					sbJacket.append(dataJacketDblstitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbJacket.append("\r\n");
			logger.info("JACKETのダブルステッチ変更は空です");
		}
		
		//AMF色指定
		String strJacketAmfColorNm = stringChange(order.getJkAmfColorNm());
		String strJacketAmfColorPlcNm = stringChange(order.getJkAmfColorPlcNm());
		if(!("".equals(strJacketAmfColorNm)) && !("".equals(strJacketAmfColorPlcNm))) {
			String[] dataJacketAmfColorNm = strJacketAmfColorNm.split(",");
			String[] dataJacketAmfColorPlcNm = strJacketAmfColorPlcNm.split(",");
			if(dataJacketAmfColorNm.length-1 == dataJacketAmfColorPlcNm.length-1) {
				for(int i = 0; i < dataJacketAmfColorNm.length; i++) {
					if(i == dataJacketAmfColorNm.length-1) {
						sbJacket.append(dataJacketAmfColorNm[i]).append("-").
						append(dataJacketAmfColorPlcNm[i]).append("\r\n");
					}else {
						sbJacket.append(dataJacketAmfColorNm[i]).append("-").
						append(dataJacketAmfColorPlcNm[i]).append("  ");
					}
				}
			}else {
				sbJacket.append("\r\n");
				logger.info("JACKETAMF色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbJacket.append("\r\n");
			logger.info("JACKETのAMF色指定は空です");
		}
		
		//ボタンホール色指定
		String strJacketBtnholeColorNm = stringChange(order.getJkBtnholeColorNm());
		String strJacketBtnholeColorPlcN = stringChange(order.getJkBtnholeColorPlcN());
		if(!("".equals(strJacketBtnholeColorNm)) && !("".equals(strJacketBtnholeColorPlcN))) {
			String[] dataJacketBtnholeColorNm = strJacketBtnholeColorNm.split(",");
			String[] dataJacketBtnholeColorPlcN = strJacketBtnholeColorPlcN.split(",");
			if(dataJacketBtnholeColorNm.length-1 == dataJacketBtnholeColorPlcN.length-1) {
				for(int i = 0; i < dataJacketBtnholeColorNm.length; i++) {
					if(i == dataJacketBtnholeColorNm.length-1) {
						sbJacket.append(dataJacketBtnholeColorNm[i]).append("-").
						append(dataJacketBtnholeColorPlcN[i]).append("\r\n");
					}else {
						sbJacket.append(dataJacketBtnholeColorNm[i]).append("-").
						append(dataJacketBtnholeColorPlcN[i]).append("  ");
					}
				}
			}else {
				sbJacket.append("\r\n");
				logger.info("JACKETボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbJacket.append("\r\n");
			logger.info("JACKETのAMF色指定は空です");
		}
		
		//ボタン付け糸指定
		String strJacketBtnthreadColorNm = stringChange(order.getJkBtnthreadColorNm());
		String strJacketBtnthreadColorPlcN = stringChange(order.getJkBtnthreadColorPlcN());
		if(!("".equals(strJacketBtnthreadColorNm)) && !("".equals(strJacketBtnthreadColorPlcN))) {
			String[] dataJacketBtnthreadColorNm = strJacketBtnthreadColorNm.split(",");
			String[] dataJacketBtnthreadColorPlcN = strJacketBtnthreadColorPlcN.split(",");
			if(dataJacketBtnthreadColorNm.length-1 == dataJacketBtnthreadColorPlcN.length-1) {
				for(int i = 0; i < dataJacketBtnthreadColorNm.length; i++) {
					if(i == dataJacketBtnthreadColorNm.length-1) {
						sbJacket.append(dataJacketBtnthreadColorNm[i]).append("-").
						append(dataJacketBtnthreadColorPlcN[i]).append("");
					}else {
						sbJacket.append(dataJacketBtnthreadColorNm[i]).append("-").
						append(dataJacketBtnthreadColorPlcN[i]).append("  ");
					}
				}
			}else {
				sbJacket.append("\r\n");
				logger.info("JACKETボタン付け糸指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbJacket.append("\r\n");
			logger.info("JACKETのボタン付け糸指定は空です");
		}
		
		String detailedFieldJacket = String.valueOf(sbJacket);
		//JACKET詳細情報
		form.getField("Jk_detailed_field_data").setData(stringChange(detailedFieldJacket));
	}
	
	/**
	 * PANTS詳細情報,PDFで印刷
	 * @return
	 */
	private void insertPantsdetailedFieldDataCo(CrForm form, Order order) {
		StringBuffer sbPants = new StringBuffer();
		sbPants.append("\r\n");
		
		//ベルトループ
		String strPantsBeltloopNm = stringChange(order.getPtBeltloopNm());
		if(!("".equals(strPantsBeltloopNm))) {
			String[] dataPantsBeltloopNm = strPantsBeltloopNm.split(",");
			for(int i = 0; i < dataPantsBeltloopNm.length; i++) {
				if(i == dataPantsBeltloopNm.length-1) {
					sbPants.append(dataPantsBeltloopNm[i]).append("\r\n");
				}else {
					sbPants.append(dataPantsBeltloopNm[i]).append("  ");
				}
			}
		}else {
			sbPants.append("\r\n");
			logger.info("PANTSのベルトループは空です");
		}
		
		//ステッチ箇所変更
		String strPantsStitchPlcNm = stringChange(order.getPtStitchPlcNm());
		if(!("".equals(strPantsStitchPlcNm))) {
			String[] dataPantsStitchPlcNm = strPantsStitchPlcNm.split(",");
			for(int i = 0; i < dataPantsStitchPlcNm.length; i++) {
				if(i == dataPantsStitchPlcNm.length-1) {
					sbPants.append(dataPantsStitchPlcNm[i]).append("\r\n");
				}else {
					sbPants.append(dataPantsStitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbPants.append("\r\n");
			logger.info("PANTSのステッチ箇所変更は空です");
		}
		
		//ダブルステッチ変更 
		String strPantsDblstitchPlcNm = stringChange(order.getPtDblstitchPlcNm());
		if(!("".equals(strPantsDblstitchPlcNm))) {
		String[] dataPantsDblstitchPlcNm = strPantsDblstitchPlcNm.split(",");
			for(int i = 0; i < dataPantsDblstitchPlcNm.length; i++) {
				if(i == dataPantsDblstitchPlcNm.length-1) {
					sbPants.append(dataPantsDblstitchPlcNm[i]).append("\r\n");
				}else {
					sbPants.append(dataPantsDblstitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbPants.append("\r\n");
			logger.info("PANTSのダブルステッチ変更 は空です");
		}
		
		//AMF色指定
		String strPantsAmfColorNm = stringChange(order.getPtAmfColorNm());
		String strPantsAmfColorPlcNm = stringChange(order.getPtAmfColorPlcNm());
		if(!("".equals(strPantsAmfColorNm)) && !("".equals(strPantsAmfColorPlcNm))) {
			String[] dataPantsAmfColorNm = strPantsAmfColorNm.split(",");
			String[] dataPantsAmfColorPlcNm = strPantsAmfColorPlcNm.split(",");
			if(dataPantsAmfColorNm.length-1 == dataPantsAmfColorPlcNm.length-1) {
				for(int i = 0; i < dataPantsAmfColorNm.length; i++) {
					if(i == dataPantsAmfColorNm.length-1) {
						sbPants.append(dataPantsAmfColorNm[i]).append("-").
						append(dataPantsAmfColorPlcNm[i]).append("\r\n");
					}else {
						sbPants.append(dataPantsAmfColorNm[i]).append("-").
						append(dataPantsAmfColorPlcNm[i]).append("  ");
					}
				}
			}else {
				sbPants.append("\r\n");
				logger.info("PANTSAMF色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPants.append("\r\n");
			logger.info("PANTSのAMF色指定は空です");
		}
		
		//ボタンホール色指定
		String strPantsBtnholeColorNm = stringChange(order.getPtBtnholeColorNm());
		String strPantsBtnholeColorPlcNm = stringChange(order.getPtBtnholeColorPlcNm());
		if(!("".equals(strPantsBtnholeColorNm)) && !("".equals(strPantsBtnholeColorPlcNm))) {
			String[] dataPantsBtnholeColorNm = strPantsBtnholeColorNm.split(",");
			String[] dataPantsBtnholeColorPlcNm = strPantsBtnholeColorPlcNm.split(",");
			if(dataPantsBtnholeColorNm.length-1 == dataPantsBtnholeColorPlcNm.length-1) {
				for(int i = 0; i < dataPantsBtnholeColorNm.length; i++) {
					if(i == dataPantsBtnholeColorNm.length-1) {
						sbPants.append(dataPantsBtnholeColorNm[i]).append("-").
						append(dataPantsBtnholeColorPlcNm[i]).append("\r\n");
					}else {
						sbPants.append(dataPantsBtnholeColorNm[i]).append("-").
						append(dataPantsBtnholeColorPlcNm[i]).append("  ");
					}
				}
			}else {
				sbPants.append("\r\n");
				logger.info("PANTSボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPants.append("\r\n");
			logger.info("PANTSのAMF色指定は空です");
		}
		
		//ボタン付け糸指定
		String strPantsBtnthreadColorNm = stringChange(order.getPtBtnthreadColorNm());
		String strPantsBtnthreadColorPlcNm = stringChange(order.getPtBtnthreadColorPlcNm());
		if(!("".equals(strPantsBtnthreadColorNm)) && !("".equals(strPantsBtnthreadColorPlcNm))) {
			String[] dataPantsBtnthreadColorNm = strPantsBtnthreadColorNm.split(",");
			String[] dataPantsBtnthreadColorPlcNm = strPantsBtnthreadColorPlcNm.split(",");
			if(dataPantsBtnthreadColorNm.length-1 == dataPantsBtnthreadColorPlcNm.length-1) {
				for(int i = 0; i < dataPantsBtnthreadColorNm.length; i++) {
					if(i == dataPantsBtnthreadColorNm.length-1) {
						sbPants.append(dataPantsBtnthreadColorNm[i]).append("-").
						append(dataPantsBtnthreadColorPlcNm[i]).append("");
					}else {
						sbPants.append(dataPantsBtnthreadColorNm[i]).append("-").
						append(dataPantsBtnthreadColorPlcNm[i]).append("  ");
					}
				}
			}else {
				sbPants.append("\r\n");
				logger.info("PANTSボタン付け糸指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPants.append("\r\n");
			logger.info("PANTSのボタン付け糸指定は空です");
		}
		
		String detailedFieldPants = String.valueOf(sbPants);
		//PANTS詳細情報
		form.getField("Pt_detailed_field_data").setData(stringChange(detailedFieldPants));
	}
	
	/**
	 * PANTS2詳細情報,PDFで印刷
	 * @return
	 */
	private void insertPants2detailedFieldDataCo(CrForm form, Order order) {
		StringBuffer sbPants2 = new StringBuffer();
		sbPants2.append("\r\n");
		
		//ベルトループ
		String strPants2BeltloopNm = stringChange(order.getPt2BeltloopNm());
		if(!("".equals(strPants2BeltloopNm))) {
			String[] dataPants2BeltloopNm = strPants2BeltloopNm.split(",");
			for(int i = 0; i < dataPants2BeltloopNm.length; i++) {
				if(i == dataPants2BeltloopNm.length-1) {
					sbPants2.append(dataPants2BeltloopNm[i]).append("\r\n");
				}else {
					sbPants2.append(dataPants2BeltloopNm[i]).append("  ");
				}
			}
		}else {
			sbPants2.append("\r\n");
			logger.info("PANTS2のベルトループは空です");
		}
		
		//ステッチ箇所変更
		String strPants2StitchPlcNm = stringChange(order.getPt2StitchPlcNm());
		if(!("".equals(strPants2StitchPlcNm))) {
			String[] dataPants2StitchPlcNm = strPants2StitchPlcNm.split(",");
			for(int i = 0; i < dataPants2StitchPlcNm.length; i++) {
				if(i == dataPants2StitchPlcNm.length-1) {
					sbPants2.append(dataPants2StitchPlcNm[i]).append("\r\n");
				}else {
					sbPants2.append(dataPants2StitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbPants2.append("\r\n");
			logger.info("PANTS2のステッチ箇所変更は空です");
		}
		
		//ダブルステッチ変更 
		String strPants2DblstitchPlcNm = stringChange(order.getPt2DblstitchPlcNm());
		if(!("".equals(strPants2DblstitchPlcNm))) {
		String[] dataPants2DblstitchPlcNm = strPants2DblstitchPlcNm.split(",");
			for(int i = 0; i < dataPants2DblstitchPlcNm.length; i++) {
				if(i == dataPants2DblstitchPlcNm.length-1) {
					sbPants2.append(dataPants2DblstitchPlcNm[i]).append("\r\n");
				}else {
					sbPants2.append(dataPants2DblstitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbPants2.append("\r\n");
			logger.info("PANTS2のダブルステッチ変更 は空です");
		}
		
		//AMF色指定
		String strPants2AmfColorNm = stringChange(order.getPt2AmfColorNm());
		String strPants2AmfColorPlcNm = stringChange(order.getPt2AmfColorPlcNm());
		if(!("".equals(strPants2AmfColorNm)) && !("".equals(strPants2AmfColorPlcNm))) {
			String[] dataPants2AmfColorNm = strPants2AmfColorNm.split(",");
			String[] dataPants2AmfColorPlcNm = strPants2AmfColorPlcNm.split(",");
			if(dataPants2AmfColorNm.length-1 == dataPants2AmfColorPlcNm.length-1) {
				for(int i = 0; i < dataPants2AmfColorNm.length; i++) {
					if(i == dataPants2AmfColorNm.length-1) {
						sbPants2.append(dataPants2AmfColorNm[i]).append("-").
						append(dataPants2AmfColorPlcNm[i]).append("\r\n");
					}else {
						sbPants2.append(dataPants2AmfColorNm[i]).append("-").
						append(dataPants2AmfColorPlcNm[i]).append("  ");
					}
				}
			}else {
				sbPants2.append("\r\n");
				logger.info("PANTS2AMF色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPants2.append("\r\n");
			logger.info("PANTS2のAMF色指定は空です");
		}
		
		//ボタンホール色指定
		String strPants2BtnholeColorNm = stringChange(order.getPt2BtnholeColorNm());
		String strPants2BtnholeColorPlcNm = stringChange(order.getPt2BtnholeColorPlcNm());
		if(!("".equals(strPants2BtnholeColorNm)) && !("".equals(strPants2BtnholeColorPlcNm))) {
			String[] dataPants2BtnholeColorNm = strPants2BtnholeColorNm.split(",");
			String[] dataPants2BtnholeColorPlcNm = strPants2BtnholeColorPlcNm.split(",");
			if(dataPants2BtnholeColorNm.length-1 == dataPants2BtnholeColorPlcNm.length-1) {
				for(int i = 0; i < dataPants2BtnholeColorNm.length; i++) {
					if(i == dataPants2BtnholeColorNm.length-1) {
						sbPants2.append(dataPants2BtnholeColorNm[i]).append("-").
						append(dataPants2BtnholeColorPlcNm[i]).append("\r\n");
					}else {
						sbPants2.append(dataPants2BtnholeColorNm[i]).append("-").
						append(dataPants2BtnholeColorPlcNm[i]).append("  ");
					}
				}
			}else {
				sbPants2.append("\r\n");
				logger.info("PANTS2ボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPants2.append("\r\n");
			logger.info("PANTS2のAMF色指定は空です");
		}
		
		//ボタン付け糸指定
		String strPants2BtnthreadColorNm = stringChange(order.getPt2BtnthreadColorNm());
		String strPants2BtnthreadColorPlcNm = stringChange(order.getPt2BtnthreadColorPlcNm());
		if(!("".equals(strPants2BtnthreadColorNm)) && !("".equals(strPants2BtnthreadColorPlcNm))) {
			String[] dataPants2BtnthreadColorNm = strPants2BtnthreadColorNm.split(",");
			String[] dataPants2BtnthreadColorPlcNm = strPants2BtnthreadColorPlcNm.split(",");
			if(dataPants2BtnthreadColorNm.length-1 == dataPants2BtnthreadColorPlcNm.length-1) {
				for(int i = 0; i < dataPants2BtnthreadColorNm.length; i++) {
					if(i == dataPants2BtnthreadColorNm.length-1) {
						sbPants2.append(dataPants2BtnthreadColorNm[i]).append("-").
						append(dataPants2BtnthreadColorPlcNm[i]).append("");
					}else {
						sbPants2.append(dataPants2BtnthreadColorNm[i]).append("-").
						append(dataPants2BtnthreadColorPlcNm[i]).append("  ");
					}
				}
			}else {
				sbPants2.append("\r\n");
				logger.info("PANTS2ボタン付け糸指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPants2.append("\r\n");
			logger.info("PANTS2のボタン付け糸指定は空です");
		}
		
		String detailedFieldPants2 = String.valueOf(sbPants2);
		//PANTS2詳細情報
		form.getField("Pt2_detailed_field_data").setData(stringChange(detailedFieldPants2));
	}
	
	/**
	 * GILET詳細情報,PDFで印刷
	 * @return
	 */
	private void insertGiletdetailedFieldDataCo(CrForm form, Order order) {
		StringBuffer sbGilet = new StringBuffer();
		sbGilet.append("\r\n");
		
		//ステッチ箇所変更
		String strGiletStitchPlcNm = stringChange(order.getGlStitchPlcNm());
		if(!("".equals(strGiletStitchPlcNm))) {
			String[] dataGiletStitchPlcNm = strGiletStitchPlcNm.split(",");
			for(int i = 0; i < dataGiletStitchPlcNm.length; i++) {
				if(i == dataGiletStitchPlcNm.length-1) {
					sbGilet.append(dataGiletStitchPlcNm[i]).append("\r\n");
				}else {
					sbGilet.append(dataGiletStitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbGilet.append("\r\n");
			logger.info("GILETのステッチ箇所変更は空です");
		}
		
		//AMF色指定
		String strGiletAmfColorNm = stringChange(order.getGlAmfColorNm());
		if(!("".equals(strGiletAmfColorNm))) {
			String[] dataGiletAmfColorNm = strGiletAmfColorNm.split(",");
			for(int i = 0; i < dataGiletAmfColorNm.length; i++) {
				if(i == dataGiletAmfColorNm.length-1) {
					sbGilet.append(dataGiletAmfColorNm[i]).append("\r\n");
				}else {
					sbGilet.append(dataGiletAmfColorNm[i]).append("  ");
				}
			}
		}else {
			sbGilet.append("\r\n");
			logger.info("GILETのAMF色指定は空です");
		}
		
		//ボタンホール色指定
		String strGiletBtnholeColorNm = stringChange(order.getGlBtnholeColorNm());
		String strGiletBtnholeColorPlcNm = stringChange(order.getGlBtnholeColorPlcNm());
		if(!("".equals(strGiletBtnholeColorNm)) && !("".equals(strGiletBtnholeColorPlcNm))) {
			String[] dataGiletBtnholeColorNm = strGiletBtnholeColorNm.split(",");
			String[] dataGiletBtnholeColorPlcNm = strGiletBtnholeColorPlcNm.split(",");
			if(dataGiletBtnholeColorNm.length-1 == dataGiletBtnholeColorPlcNm.length-1) {
				for(int i = 0; i < dataGiletBtnholeColorNm.length; i++) {
					if(i == dataGiletBtnholeColorNm.length-1) {
						sbGilet.append(dataGiletBtnholeColorNm[i]).append("-").
						append(dataGiletBtnholeColorPlcNm[i]).append("\r\n");
					}else {
						sbGilet.append(dataGiletBtnholeColorNm[i]).append("-").
						append(dataGiletBtnholeColorPlcNm[i]).append("  ");
					}
				}
			}else {
				sbGilet.append("\r\n");
				logger.info("GILETボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbGilet.append("\r\n");
			logger.info("GILETのボタンホール色指定は空です");
		}
		
		//ボタン付け糸指定
		String strGiletBtnthreadColorNm = stringChange(order.getGlBtnthreadColorNm());
		String strGiletBtnthreadColorPlcNm = stringChange(order.getGlBtnthreadColorPlcNm());
		if(!("".equals(strGiletBtnthreadColorNm)) && !("".equals(strGiletBtnthreadColorPlcNm))) {
			String[] dataGiletBtnthreadColorNm = strGiletBtnthreadColorNm.split(",");
			String[] dataGiletBtnthreadColorPlcNm = strGiletBtnthreadColorPlcNm.split(",");
			if(dataGiletBtnthreadColorNm.length-1 == dataGiletBtnthreadColorPlcNm.length-1) {
				for(int i = 0; i < dataGiletBtnthreadColorNm.length; i++) {
					if(i == dataGiletBtnthreadColorNm.length-1) {
						sbGilet.append(dataGiletBtnthreadColorNm[i]).append("-").
						append(dataGiletBtnthreadColorPlcNm[i]).append("\r\n");
					}else {
						sbGilet.append(dataGiletBtnthreadColorNm[i]).append("-").
						append(dataGiletBtnthreadColorPlcNm[i]).append("  ");
					}
				}
			}else {
				sbGilet.append("\r\n");
				logger.info("GILETボタン付け糸指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbGilet.append("\r\n");
			logger.info("GILETのボタン付け糸指定は空です");
		}
		
		String detailedFieldGilet = String.valueOf(sbGilet);
		//GILET詳細情報
		form.getField("Gl_detailed_field_data").setData(stringChange(detailedFieldGilet));
	}
	
}
