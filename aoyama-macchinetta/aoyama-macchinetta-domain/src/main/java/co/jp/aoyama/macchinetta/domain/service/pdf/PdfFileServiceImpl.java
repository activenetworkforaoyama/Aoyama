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

import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.repository.measuring.MeasuringRepository;
import co.jp.aoyama.macchinetta.domain.repository.orderlist.OrderListRepository;
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
	
	private static final Logger logger = LoggerFactory
            .getLogger(PdfFileServiceImpl.class);
	
	// (SUIT)
	private static final String IS_CO_SUIT = "01";
	// (SHIRT)
	private static final String IS_CO_SHIRT = "05";
	// (COAT)
	private static final String IS_CO_COAT = "06";

	/**
	 * pdfファイルの書き方
	 */
	@Override
	public ByteArrayOutputStream outputSamplePoPdf(String sign, String orderId) throws Exception{
		//orderIdでorderオブジェクトを取得します
		Order order = orderListRepository.findOrderByPk(orderId);
		//orderIdでmeasuringオブジェクトを取得します
    	Measuring measuring = measuringRepository.selectByPrimaryKey(orderId);
    	if(order == null) {
    		logger.info("order対象はnullです。");
    	}
    	if(measuring == null) {
    		logger.info("measuring対象はnullです。");
    	}
    	
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
            			+ "confirmationBookSuit-Factory.cfx");
            	form = CrForm.open(draw, resource.getInputStream());
			}else if("2".equals(sign)) {
				//注文内容確認書(SUIT)_お客様向
				doc.setDocumentName("注文内容確認書(SUIT)_お客様向");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "confirmationBookSuit-Guest.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("3".equals(sign)) {
				//工場指示書(SUIT)
				doc.setDocumentName("工場指示書(SUIT)");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "factoryInstructionsSuit.cfx");
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
                	//名前Shipping_no_data
                	form.getField("Name_data").setData("????");
                	//名簿納期
            		form.getField("Cust_deliver_date_data").setData(dateChange(order.getCustDeliverDate()));
                	//組成
                	form.getField("Product_compos_data").setData(stringChange(order.getProductComposFrtFabric())+","+stringChange(order.getProductComposBodyLiner())+","+stringChange(order.getProductComposSleeveLiner()));
                	//お客様備考
                	form.getField("Cust_remark_data").setData(stringChange(order.getCustRemark()));
                	//A行
                	form.getField("Host_transmit_A_row_data").setData(stringChange(order.getHostTransmitARow()));
                	//出荷番号
                	form.getField("Shipping_no_data").setData("A"+stringChange(order.getShippingNumber())+"A");
                	insertPoOrderData(form, order);
                	insertPoMeasuringData(form, measuring);
    			}else if("2".equals(sign)) {
    				//注文内容確認書(SUIT)_お客様向
    				//名前
    				form.getField("Name_data").setData("????");
    				//名簿納期
    				form.getField("Cust_deliver_date_data").setData(dateChange(order.getCustDeliverDate()));
    				//組成
    				form.getField("Data106").setData(stringChange(order.getProductComposFrtFabric())+","+stringChange(order.getProductComposBodyLiner())+","+stringChange(order.getProductComposSleeveLiner()));
    				//お客様備考
    				form.getField("Data107").setData(stringChange(order.getCustRemark()));
    				insertPoOrderData(form, order);
    				insertPoMeasuringData(form, measuring);
    			}else if("3".equals(sign)) {
    				//工場指示書(SUIT)
    				//工場
    				form.getField("Product_factory_data").setData(stringChange(order.getProductFactoryCd()));
    				//お渡し日
    				form.getField("Cust_shop_delivery_date_data").setData(dateChange(order.getCustShopDeliveryDate()));
    				//組成
    				form.getField("Product_compos_data").setData(stringChange(order.getProductComposFrtFabric())+","+stringChange(order.getProductComposBodyLiner())+","+stringChange(order.getProductComposSleeveLiner()));
    				//お客様備考
    				form.getField("Cust_remark_data").setData(stringChange(order.getCustRemark()));
    				insertPoOrderData(form, order);
    				insertPoMeasuringData(form, measuring);
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
	
	public ByteArrayOutputStream outputSampleCoPdf(String path, String sign, String orderId) {
		Order order = new Order();
		order = orderListRepository.findOrderByPk(orderId);
    	Measuring measuring = new Measuring();
    	measuring = measuringRepository.selectByPrimaryKey(orderId);
    	
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
            doc.setDocumentName("お客様内容確認書");
            
            CrForm form = null;
            // （５）フォームファイルを開きます
            if("1".equals(sign) && IS_CO_SUIT.equals(order.getProductItem())) {
            	 form = CrForm.open(draw, path + "\\cfx\\confirmationBookSuit-Guest-Co.cfx");
            }else if("1".equals(sign) && IS_CO_SHIRT.equals(order.getProductItem())){
            	 form = CrForm.open(draw, path + "\\cfx\\confirmationBookShirt-Guest-Co.cfx");
            }else if("1".equals(sign) && IS_CO_COAT.equals(order.getProductItem())){
            	 form = CrForm.open(draw, path + "\\cfx\\confirmationBookCoat-Guest-Co.cfx");
            }else if("2".equals(sign) && IS_CO_SUIT.equals(order.getProductItem())){
            	 form = CrForm.open(draw, path + "\\cfx\\confirmationBookSuit-Factory-Co.cfx");
            }else if("2".equals(sign) && IS_CO_SHIRT.equals(order.getProductItem())){
            	 form = CrForm.open(draw, path + "\\cfx\\confirmationBookShirt-Factory-Co.cfx");
            }else if("2".equals(sign) && IS_CO_COAT.equals(order.getProductItem())){
            	 form = CrForm.open(draw, path + "\\cfx\\confirmationBookCoat-Factory-Co.cfx");
            }else if("3".equals(sign) && IS_CO_SUIT.equals(order.getProductItem())) {
            	 form = CrForm.open(draw, path + "\\cfx\\factoryInstructionsSuit-Co.cfx");
			}else if("3".equals(sign) && IS_CO_SHIRT.equals(order.getProductItem())) {
				 form = CrForm.open(draw, path + "\\cfx\\factoryInstructionsShirt-Co.cfx");
			}else if("3".equals(sign) && IS_CO_COAT.equals(order.getProductItem())) {
				 form = CrForm.open(draw, path + "\\cfx\\factoryInstructionsCoat-Co.cfx");
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
                if("1".equals(sign) && IS_CO_SUIT.equals(order.getProductItem())) {
                	form.getField("Total_price_date").setData(order.getTotalPrice());
                	form.getField("Billing_amount_date").setData(order.getBillingAmount());
                	insertCoSuitData(form, order, measuring);
                }else if("1".equals(sign) && IS_CO_SHIRT.equals(order.getProductItem())) {
                	form.getField("Total_price_date").setData(order.getTotalPrice());
                	form.getField("Billing_amount_date").setData(order.getBillingAmount());
                	insertCoShirtData(form, order, measuring);
                }else if("1".equals(sign) && IS_CO_COAT.equals(order.getProductItem())) {
                	form.getField("Total_price_date").setData(order.getTotalPrice());
                	form.getField("Billing_amount_date").setData(order.getBillingAmount());
                	insertCoCoatData(form, order, measuring);
                }else if("2".equals(sign) && IS_CO_SUIT.equals(order.getProductItem())) {
                	form.getField("Host_transmit_A_row_data").setData(order.getHostTransmitARow());
                	form.getField("Shipping_no_data").setData(order.getShippingNumber());
                	insertCoSuitData(form, order, measuring);
                }else if("2".equals(sign) && IS_CO_SHIRT.equals(order.getProductItem())) {
                	form.getField("Host_transmit_A_row_data1").setData(order.getHostTransmitARow());
                	form.getField("Shipping_no_data1").setData(order.getShippingNumber());
                	insertCoShirtData(form, order, measuring);
                }else if("2".equals(sign) && IS_CO_COAT.equals(order.getProductItem())) {
                	form.getField("Host_transmit_A_row_data1").setData(order.getHostTransmitARow());
                	form.getField("Shipping_no_data1").setData(order.getShippingNumber());
                	insertCoCoatData(form, order, measuring);
                }else if("3".equals(sign) && IS_CO_SUIT.equals(order.getProductItem())) {
            		insertCoSuitData(form, order, measuring);
    			}else if("3".equals(sign) && IS_CO_SHIRT.equals(order.getProductItem())) {
    				insertCoShirtData(form, order, measuring);
    			}else if("3".equals(sign) && IS_CO_COAT.equals(order.getProductItem())) {
    				insertCoCoatData(form, order, measuring);
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
        } finally {
            // （１２）描画クラスの後処理を行います
            draw.deleteInstance();

        }
        return output;
    }
	/**
	 * 共通のデータを挿入
	 * @param 
	 * @return 
	 */
	private void insertPoOrderData(CrForm form, Order order) {
		//注文ID
		form.getField("Order_id_data").setData(stringChange(order.getOrderId()));
		//EMBROIDERY,刺繡表示
		form.getField("Product_embroidery_nm_data").setData(stringChange(order.getProductEmbroideryNm()));
		//FONT,書体
		form.getField("Product_embroidery_font_data").setData(stringChange(order.getProductEmbroideryFont()));
		//カテゴリ
		form.getField("Product_category_data").setData(stringChange(order.getProductCategory()));
		//承り日
		form.getField("Product_orderd_date_data").setData(dateChange(order.getProductOrderdDate()));
		
		//品名
		form.getField("Product_item_data").setData(stringChange(order.getProductItem()));
		//工場ID.
		form.getField("Product_fabric_no_data").setData(stringChange(order.getProductFabricNo()));
		//生地ブランド
		form.getField("Product_brand_nm_data").setData(stringChange(order.getProductFabricBrandNm()));
		//サービスネーム
		form.getField("Product_service_nm_data").setData(stringChange(order.getProductServiceNm()));
		//取り扱い注意
		form.getField("Product_notice_data").setData(stringChange(order.getProductNotice()));
		//店舗名
		form.getField("Store_nm_data").setData(stringChange(order.getStoreNm()));
		//担当者名
		form.getField("Store_staff_nm_data").setData(stringChange(order.getStoreStaffNm()));
		
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
		form.getField("Cor_jk_bodylength_size_data").setData(bigDecimalChange(order.getCorJkBodylengthCorrect()));
		//ウエスト
		form.getField("Cor_jk_waist_size_data").setData(bigDecimalChange(order.getCorJkWaistCorrect()));
		//袖丈右
		form.getField("Cor_jk_rightsleeve_size_data").setData(bigDecimalChange(order.getCorJkRightsleeveCorrect()));
		//袖丈左
		form.getField("Cor_jk_leftsleeve_size_data").setData(bigDecimalChange(order.getCorJkLeftsleeveCorrect()));
		
		//グロス
		//着丈
		form.getField("Cor_jk_bodylength_size_data").setData(bigDecimalChange(order.getCorJkBodylengthGross()));
		//ウエスト
		form.getField("Cor_jk_waist_size_data").setData(bigDecimalChange(order.getCorJkWaistGross()));
		//袖丈右
		form.getField("Cor_jk_rightsleeve_size_data").setData(bigDecimalChange(order.getCorJkRightsleeveGross()));
		//袖丈左
		form.getField("Cor_jk_leftsleeve_size_data").setData(bigDecimalChange(order.getCorJkLeftsleeveGross()));
		
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
		form.getField("Cor_pt_rightinseam_correct_data1").setData(bigDecimalChange(order.getCorPtRightinseamCorrect()));
		//股下左
		form.getField("Cor_pt_leftinseam_correct_data1").setData(bigDecimalChange(order.getCorPtLeftinseamCorrect()));
		
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
		form.getField("Cor_pt2_rightinseam_correct_data").setData(bigDecimalChange(order.getCorPt2RightinseamCorrect()));
		//股下左
		form.getField("Cor_pt2_leftinseam_correct_data").setData(bigDecimalChange(order.getCorPt2LeftinseamCorrect()));
		
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
	}
	
	/**
	 * 共通のmeasuringデータを挿入
	 * @param 
	 * @return 
	 */
	private void insertPoMeasuringData(CrForm form, Measuring measuring) {
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
			//ネック
			form.getField("Neck_data").setData(bigDecimalChange(measuring.getNeck()));
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
			//ネック
			form.getField("Neck_data").setData("0");
		}
	}

	private void insertCoSuitData(CrForm form, Order order,Measuring measuring) {
		//注文ID
		form.getField("Order_id_data").setData(order.getOrderId());
		//工場
		form.getField("Product_factory_data").setData(order.getProductFactoryCd());
		//品名
		form.getField("Product_item_data").setData(order.getProductItem());
		//工場ID.
		form.getField("Product_fabric_no_data").setData(order.getProductFabricNo());
		//店舗名
		form.getField("Store_nm_data").setData(order.getStoreNm());
		//担当者名
		form.getField("Store_staff_nm_data").setData(order.getStoreStaffNm());
		//刺繡表示
		form.getField("Product_embroidery_nm_data").setData(order.getProductEmbroideryNm());
		//書体
		form.getField("Product_embroidery_font_data").setData(order.getProductEmbroideryFont());
		//生地ブランド
		form.getField("Product_brand_nm_data").setData(order.getProductFabricBrandNm());
		//サービスネーム
		form.getField("Product_service_nm_data").setData(order.getProductServiceNm());
		//取り扱い注意
		form.getField("Product_notice_data").setData(order.getProductNotice());
		//カテゴリ
		form.getField("Product_category_data").setData(order.getProductCategory());
		//承り日
		form.getField("Product_orderd_date_data").setData(dateChange(order.getProductOrderdDate()));
		//お渡し日
		form.getField("Cust_shop_delivery_date_data").setData(dateChange(order.getCustShopDeliveryDate()));
		//組成　
		form.getField("Product_compos_data").setData(order.getProductComposBodyLiner()+" - "+order.getProductComposFrtFabric()+" - "+order.getProductComposSleeveLiner());
		//お客様備考
		form.getField("Cust_remark_data").setData(order.getCustRemark());
		
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
		//ネック
		form.getField("Neck_data").setData(bigDecimalChange(measuring.getNeck()));
		
		//サイズ
		form.getField("Cor_jk_size_data").setData(order.getCorJkDrop()+" - "+order.getCorJkSize());
		//着丈
		form.getField("Cor_jk_bodylength_size_data").setData(bigDecimalChange(order.getCorJkBodylengthSize()));
		form.getField("Cor_jk_bodylength_correct_data").setData(bigDecimalChange(order.getCorJkBodylengthCorrect()));
		form.getField("Cor_jk_bodylength_gross_data").setData(bigDecimalChange(order.getCorJkBodylengthGross()));
		//ウエスト
		form.getField("Cor_jk_waist_size_data").setData(bigDecimalChange(order.getCorJkWaistSize()));
		form.getField("Cor_jk_waist_correct_data").setData(bigDecimalChange(order.getCorJkWaistCorrect()));
		form.getField("Cor_jk_waist_gross_data").setData(bigDecimalChange(order.getCorJkWaistGross()));
		//袖丈右
		form.getField("Cor_jk_rightsleeve_size_data").setData(bigDecimalChange(order.getCorJkRightsleeveSize()));
		form.getField("Cor_jk_rightsleeve_correct_data").setData(bigDecimalChange(order.getCorJkRightsleeveCorrect()));
		form.getField("Cor_jk_rightsleeve_gross_data").setData(bigDecimalChange(order.getCorJkRightsleeveGross()));
		//袖丈左
		form.getField("Cor_jk_leftsleeve_size_data").setData(bigDecimalChange(order.getCorJkLeftsleeveSize()));
		form.getField("Cor_jk_leftsleeve_correct_data").setData(bigDecimalChange(order.getCorJkLeftsleeveCorrect()));
		form.getField("Cor_jk_leftsleeve_gross_data").setData(bigDecimalChange(order.getCorJkLeftsleeveGross()));
		//肩パット
		form.getField("Cor_jk_shoulderpad_data").setData(order.getCorJkShoulderpad());
		//体型補正
		form.getField("Cor_jk_figure_correct_data").setData(order.getCorJkFigureCorrect());
		
		//サイズ
		form.getField("Cor_pt_size_data1").setData(order.getCorPtDrop()+" - "+order.getCorPtSize());
		//ウエスト
		form.getField("Cor_pt_waist_size_data1").setData(bigDecimalChange(order.getCorPtWaistSize()));
		form.getField("Cor_pt_waist_correct_data1").setData(bigDecimalChange(order.getCorPtWaistCorrect()));
		form.getField("Cor_pt_waist_gross_data1").setData(bigDecimalChange(order.getCorPtWaistGross()));
		//ヒップ
		form.getField("Cor_pt_hip_size_data1").setData(bigDecimalChange(order.getCorPtHipSize()));
		form.getField("Cor_pt_hip_correct_data1").setData(bigDecimalChange(order.getCorPtHipCorrect()));
		form.getField("Cor_pt_hip_gross_data1").setData(bigDecimalChange(order.getCorPtHipGross()));
		//ワタリ
		form.getField("Cor_pt_thighwidth_size_data1").setData(bigDecimalChange(order.getCorPtThighwidthSize()));
		form.getField("Cor_pt_thighwidth_correct_data1").setData(bigDecimalChange(order.getCorPtThighwidthCorrect()));
		form.getField("Cor_pt_thighwidth_gross_data1").setData(bigDecimalChange(order.getCorPtThighwidthGross()));
		//裾幅
		form.getField("Cor_pt_hemwidth_size_data1").setData(bigDecimalChange(order.getCorPtHemwidthSize()));
		form.getField("Cor_pt_hemwidth_correct_data1").setData(bigDecimalChange(order.getCorPtHemwidthCorrect()));
		form.getField("Cor_pt_hemwidth_gross_data1").setData(bigDecimalChange(order.getCorPtHemwidthGross()));
		//股下右
		form.getField("Cor_pt_rightinseam_size_data1").setData(bigDecimalChange(order.getCorPtRightinseamSize()));
		form.getField("Cor_pt_rightinseam_correct_data1").setData(bigDecimalChange(order.getCorPtRightinseamCorrect()));
		form.getField("Cor_pt_rightinseam_gross_data1").setData(bigDecimalChange(order.getCorPtRightinseamGross()));
		//股下左
		form.getField("Cor_pt_leftinseam_size_data1").setData(bigDecimalChange(order.getCorPtLeftinseamSize()));
		form.getField("Cor_pt_leftinseam_correct_data1").setData(bigDecimalChange(order.getCorPtLeftinseamCorrect()));
		form.getField("Cor_pt_leftinseam_gross_data1").setData(bigDecimalChange(order.getCorPtLeftinseamGross()));
		
		//サイズ
		form.getField("Cor_pt2_size_data").setData(order.getCorPt2Drop()+" - "+order.getCorPt2Size());
		//ウエスト
		form.getField("Cor_pt2_waist_size_data").setData(bigDecimalChange(order.getCorPt2WaistSize()));
		form.getField("Cor_pt2_waist_correct_data").setData(bigDecimalChange(order.getCorPt2WaistCorrect()));
		form.getField("Cor_pt2_waist_gross_data").setData(bigDecimalChange(order.getCorPt2WaistGross()));
		//ヒップ
		form.getField("Cor_pt2_hip_size_data").setData(bigDecimalChange(order.getCorPt2HipSize()));
		form.getField("Cor_pt2_hip_correct_data").setData(bigDecimalChange(order.getCorPt2HipCorrect()));
		form.getField("Cor_pt2_hip_gross_data").setData(bigDecimalChange(order.getCorPt2HipGross()));
		//ワタリ
		form.getField("Cor_pt2_thighwidth_size_data").setData(bigDecimalChange(order.getCorPt2ThighwidthSize()));
		form.getField("Cor_pt2_thighwidth_correct_data").setData(bigDecimalChange(order.getCorPt2ThighwidthCorrect()));
		form.getField("Cor_pt2_thighwidth_gross_data").setData(bigDecimalChange(order.getCorPt2ThighwidthGross()));
		//裾幅
		form.getField("Cor_pt2_hemwidth_size_data").setData(bigDecimalChange(order.getCorPt2HemwidthSize()));
		form.getField("Cor_pt2_hemwidth_correct_data").setData(bigDecimalChange(order.getCorPt2HemwidthCorrect()));
		form.getField("Cor_pt2_hemwidth_gross_data").setData(bigDecimalChange(order.getCorPt2HemwidthGross()));
		//股下右
		form.getField("Cor_pt2_rightinseam_size_data").setData(bigDecimalChange(order.getCorPt2RightinseamSize()));
		form.getField("Cor_pt2_rightinseam_correct_data").setData(bigDecimalChange(order.getCorPt2RightinseamCorrect()));
		form.getField("Cor_pt2_rightinseam_gross_data").setData(bigDecimalChange(order.getCorPt2RightinseamGross()));
		//股下左
		form.getField("Cor_pt2_leftinseam_size_data").setData(bigDecimalChange(order.getCorPt2LeftinseamSize()));
		form.getField("Cor_pt2_leftinseam_correct_data").setData(bigDecimalChange(order.getCorPt2LeftinseamCorrect()));
		form.getField("Cor_pt2_leftinseam_gross_data").setData(bigDecimalChange(order.getCorPt2LeftinseamGross()));
		
		//サイズ
		form.getField("Cor_pt2_size1").setData(order.getCorGlDrop()+" - "+order.getCorGlSize());
		//ウエスト
		form.getField("Cor_gl_bodylength_size_data").setData(bigDecimalChange(order.getCorGlBodylengthSize()));
		form.getField("Cor_gl_bodylength_correct_data").setData(bigDecimalChange(order.getCorGlBodylengthCorrect()));
		form.getField("Cor_gl_bodylength_gross_data").setData(bigDecimalChange(order.getCorGlBodylengthGross()));
		//ヒップ
		form.getField("Cor_gl_bust_size_data").setData(bigDecimalChange(order.getCorGlBustSize()));
		form.getField("Cor_gl_bust_correct_data").setData(bigDecimalChange(order.getCorGlBustCorrect()));
		form.getField("Cor_gl_bust_gross_data").setData(bigDecimalChange(order.getCorGlBustGross()));
		//ワタリ
		form.getField("Cor_gl_waist_size_data").setData(bigDecimalChange(order.getCorGlWaistSize()));
		form.getField("Cor_gl_waist_correct_data").setData(bigDecimalChange(order.getCorGlWaistCorrect()));
		form.getField("Cor_gl_waist_gross_data").setData(bigDecimalChange(order.getCorGlWaistGross()));
		
		//JACKETモデル
		form.getField("Jk_model_cd_data").setData(order.getJkModelNm());
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
		form.getField("Jk_inner_pkt_data").setData(order.getJkInnerPktNm());
		//下前胸内ポケット仕様
		form.getField("Jk_right_inner_pkt_type_data").setData(order.getJkRightInnerPktTypeNm());
		//ステッチ種類
		form.getField("Jk_stitch_type_data").setData(order.getJkStitchTypeNm());
		//ステッチ箇所変更
		form.getField("Jk_stitch_plc_data").setData(order.getJkStitchPlcNm());
		//ダブルステッチ変更
		form.getField("Jk_dblstitch_plc_data").setData(order.getJkDblstitchPlcNm());
		//AMF色指定
		form.getField("Jk_amf_color_data").setData(order.getJkAmfColorNm());
		//ボタンホール色指定
		form.getField("Jk_btnhole_color_data").setData(order.getJkBtnholeColorNm());
		//ボタン付け糸指定
		form.getField("Jk_btnthread_color_data").setData(order.getJkBtnthreadColorNm());
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
		form.getField("Pt_beltloop_data").setData(order.getPtBeltloopNm());
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
		form.getField("Pt_stitch_type_data").setData(order.getPtStitchPlcType());
		//ステッチ箇所変更
		form.getField("Pt_stitch_plc_data").setData(order.getPtStitchPlcNm());
		//ダブルステッチ
		form.getField("Pt_dblstitch_plc_data").setData(order.getPtDblstitchPlcNm());
		//AMF色指定
		form.getField("Pt_amf_color_data").setData(order.getPtAmfColorNm());
		//ボタンホール色指定
		form.getField("Pt_btnhole_color_data").setData(order.getPtBtnholeColorNm());
		//ボタン付け糸指定
		form.getField("Pt_btnthread_color_data").setData(order.getPtBtnthreadColorNm());
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
		form.getField("Pt_beltloop_data2").setData(order.getPt2BeltloopNm());
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
		form.getField("Pt_stitch_type_data2").setData(order.getPt2StitchPlcType());
		//ステッチ箇所変更
		form.getField("Pt_stitch_plc_data2").setData(order.getPt2StitchPlcNm());
		//ダブルステッチ
		form.getField("Pt_dblstitch_plc_data2").setData(order.getPt2DblstitchPlcNm());
		//AMF色指定
		form.getField("Pt_amf_color_data2").setData(order.getPt2AmfColorNm());
		//ボタンホール色指定
		form.getField("Pt_btnhole_color_data2").setData(order.getPt2BtnholeColorNm());
		//ボタン付け糸指定
		form.getField("Pt_btnthread_color_data2").setData(order.getPt2BtnthreadColorNm());
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
		form.getField("Gl_stitch_type_data").setData(order.getGlStitchPlcType());
		//ステッチ箇所変更
		form.getField("Gl_stitch_plc_data").setData(order.getGlStitchPlcNm());
		//ダブルステッチ変更
		form.getField("Gl_dblstitch_plc_data").setData(order.getGlDblstitchPlcNm());
		//AMF色指定
		form.getField("Gl_amf_color_data").setData(order.getGlAmfColorNm());
		//ボタンホール色指定
		form.getField("Gl_btnhole_color_data").setData(order.getGlBtnholeColorNm());
		//ボタン付け糸指定
		form.getField("Gl_btnthread_color_data").setData(order.getGlBtnthreadColorNm());
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
	
	private void insertCoCoatData(CrForm form, Order order,Measuring measuring) {
		//注文ID
		form.getField("Order_id_data").setData(order.getOrderId());
		//工場
		form.getField("Product_factory_data").setData(order.getProductFactoryCd());
		//品名
		form.getField("Product_item_data").setData(order.getProductItem());
		//工場ID.
		form.getField("Product_fabric_no_data").setData(order.getProductFabricNo());
		//店舗名
		form.getField("Store_nm_data").setData(order.getStoreNm());
		//担当者名
		form.getField("Store_staff_nm_data").setData(order.getStoreStaffNm());
		//刺繡表示
		form.getField("Product_embroidery_nm_data").setData(order.getProductEmbroideryNm());
		//書体
		form.getField("Product_embroidery_font_data").setData(order.getProductEmbroideryFont());
		//生地ブランド
		form.getField("Product_brand_nm_data").setData(order.getProductFabricBrandNm());
		//サービスネーム
		form.getField("Product_service_nm_data").setData(order.getProductServiceNm());
		//取り扱い注意
		form.getField("Product_notice_data").setData(order.getProductNotice());
		//カテゴリ
		form.getField("Product_category_data").setData(order.getProductCategory());
		//承り日
		form.getField("Product_orderd_date_data").setData(dateChange(order.getProductOrderdDate()));
		//お渡し日
		form.getField("Cust_shop_delivery_date_data").setData(dateChange(order.getCustShopDeliveryDate()));
		//組成　
		form.getField("Product_compos_data").setData(order.getProductComposBodyLiner());
		//お客様備考
		form.getField("Cust_remark_data").setData(order.getCustRemark());
		
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
		//ネック
		form.getField("Neck_data").setData(bigDecimalChange(measuring.getNeck()));
		
		//サイズ
		form.getField("Cor_ct_size_data").setData(order.getCorCtSize());
		//着丈
		form.getField("Cor_ct_bodylength_size_data").setData(bigDecimalChange(order.getCorCtBodylengthSize()));
		form.getField("Cor_ct_bodylength_correct_data").setData(bigDecimalChange(order.getCorCtBodylengthCorrect()));
		form.getField("Cor_ct_bodylength_gross_data").setData(bigDecimalChange(order.getCorCtBodylengthGross()));
		//ウエスト
		form.getField("Cor_ct_waist_size_data").setData(bigDecimalChange(order.getCorCtWaistSize()));
		form.getField("Cor_ct_waist_correct_data").setData(bigDecimalChange(order.getCorCtWaistCorrect()));
		form.getField("Cor_ct_waist_gross_data").setData(bigDecimalChange(order.getCorCtWaistGross()));
		//袖丈右
		form.getField("Cor_ct_rightsleeve_size_data").setData(bigDecimalChange(order.getCorCtRightsleeveSize()));
		form.getField("Cor_ct_rightsleeve_correct_data").setData(bigDecimalChange(order.getCorCtRightsleeveCorrect()));
		form.getField("Cor_ct_rightsleeve_gross_data").setData(bigDecimalChange(order.getCorCtRightsleeveGross()));
		//袖丈左
		form.getField("Cor_ct_leftsleeve_size_data").setData(bigDecimalChange(order.getCorCtLeftsleeveSize()));
		form.getField("Cor_ct_leftsleeve_correct_data").setData(bigDecimalChange(order.getCorCtLeftsleeveCorrect()));
		form.getField("Cor_ct_leftsleeve_gross_data").setData(bigDecimalChange(order.getCorCtLeftsleeveGross()));
		//ベンツ
		form.getField("Cor_ct_venthight_size_data").setData(bigDecimalChange(order.getCorCtVenthightSize()));
		form.getField("Cor_ct_venthight_correct_data").setData(bigDecimalChange(order.getCorCtVenthightCorrect()));
		form.getField("Cor_ct_venthight_gross_data").setData(bigDecimalChange(order.getCorCtVenthightGross()));
		//ポケット位置
		form.getField("Cor_ct_pktpos_size_data").setData(bigDecimalChange(order.getCorCtPktposSize()));
		form.getField("Cor_ct_pktpos_correct_data").setData(bigDecimalChange(order.getCorCtPktposCorrect()));
		form.getField("Cor_ct_pktpos_gross_data").setData(bigDecimalChange(order.getCorCtPktposGross()));
		
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
	
	private void insertCoShirtData(CrForm form, Order order,Measuring measuring) {
		//注文ID
		form.getField("Order_id_data").setData(order.getOrderId());
		//工場
		form.getField("Product_factory_data").setData(order.getProductFactoryCd());
		//品名
		form.getField("Product_item_data").setData(order.getProductItem());
		//工場ID.
		form.getField("Product_fabric_no_data").setData(order.getProductFabricNo());
		//店舗名
		form.getField("Store_nm_data").setData(order.getStoreNm());
		//担当者名
		form.getField("Store_staff_nm_data").setData(order.getStoreStaffNm());
		//刺繡表示
		form.getField("Product_embroidery_nm_data").setData(order.getProductEmbroideryNm());
		//書体
		form.getField("Product_embroidery_font_data").setData(order.getProductEmbroideryFont());
		//生地ブランド
		form.getField("Product_brand_nm_data").setData(order.getProductFabricBrandNm());
		//サービスネーム
		form.getField("Product_service_nm_data").setData(order.getProductServiceNm());
		//取り扱い注意
		form.getField("Product_notice_data").setData(order.getProductNotice());
		//カテゴリ
		form.getField("Product_category_data").setData(order.getProductCategory());
		//承り日
		form.getField("Product_orderd_date_data").setData(dateChange(order.getProductOrderdDate()));
		//お渡し日
		form.getField("Cust_shop_delivery_date_data").setData(dateChange(order.getCustShopDeliveryDate()));
		//組成　
		form.getField("Product_compos_data").setData(order.getProductComposBodyLiner());
		//お客様備考
		form.getField("Cust_remark_data").setData(order.getCustRemark());
		
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
		//ネック
		form.getField("Neck_data").setData(bigDecimalChange(measuring.getNeck()));
		
		//サイズ
		form.getField("Cor_ct_size_data").setData(order.getCorCtSize());
		//ネック
		form.getField("Cor_st_neck_size_data").setData(bigDecimalChange(order.getCorStNeckSize()));
		form.getField("Cor_st_neck_correct_data").setData(bigDecimalChange(order.getCorStNeckCorrect()));
		form.getField("Cor_st_neck_gross_data").setData(bigDecimalChange(order.getCorStNeckGross()));
		//着丈
		form.getField("Cor_st_bodylength_size_data").setData(bigDecimalChange(order.getCorStBodylengthSize()));
		form.getField("Cor_st_bodylength_correct_data").setData(bigDecimalChange(order.getCorStBodylengthCorrect()));
		form.getField("Cor_st_bodylength_gross_data").setData(bigDecimalChange(order.getCorStBodylengthGross()));
		//袖丈右
		form.getField("Cor_st_rightsleeve_size_data").setData(bigDecimalChange(order.getCorStRightsleeveSize()));
		form.getField("Cor_st_rightsleeve_correct_data").setData(bigDecimalChange(order.getCorStRightsleeveCorrect()));
		form.getField("Cor_st_rightsleeve_gross_data").setData(bigDecimalChange(order.getCorStRightsleeveGross()));
		//袖丈左
		form.getField("Cor_st_leftsleeve_size_data").setData(bigDecimalChange(order.getCorStLeftsleeveSize()));
		form.getField("Cor_st_leftsleeve_correct_data").setData(bigDecimalChange(order.getCorStLeftsleeveCorrect()));
		form.getField("Cor_st_leftsleeve_gross_data").setData(bigDecimalChange(order.getCorStLeftsleeveGross()));
		//背ダーツ詰め
		form.getField("Cor_st_backdarts_pack_size_data").setData(bigDecimalChange(order.getCorStBackdartsPackSize()));
		form.getField("Cor_st_backdarts_pack_correct_data").setData(bigDecimalChange(order.getCorStBackdartsPackCorrect()));
		form.getField("Cor_st_backdarts_pack_gross_data").setData(bigDecimalChange(order.getCorStBackdartsPackGross()));
		//着丈背ダーツ出し
		form.getField("Cor_st_backdarts_unpack_size_data").setData(bigDecimalChange(order.getCorStBackdartsUnpackSize()));
		form.getField("Cor_st_backdarts_unpack_correct_data").setData(bigDecimalChange(order.getCorStBackdartsUnpackCorrect()));
		form.getField("Cor_st_backdarts_unpack_gross_data").setData(bigDecimalChange(order.getCorStBackdartsUnpackGross()));
		//カフス周り右
		form.getField("Cor_st_rightcuffs_surrounding_size_data").setData(bigDecimalChange(order.getCorStRightcuffsSurroundingSize()));
		form.getField("Cor_st_rightcuffs_surrounding_correct_data").setData(bigDecimalChange(order.getCorStRightcuffsSurroundingCorrect()));
		form.getField("Cor_st_rightcuffs_surrounding_gross_data").setData(bigDecimalChange(order.getCorStRightcuffsSurroundingGross()));
		//カフス周り左
		form.getField("Cor_st_leftcuffs_surrounding_size_data").setData(bigDecimalChange(order.getCorStLeftcuffsSurroundingSize()));
		form.getField("Cor_st_leftcuffs_surrounding_correct_data").setData(bigDecimalChange(order.getCorStLeftcuffsSurroundingCorrect()));
		form.getField("Cor_st_leftcuffs_surrounding_gross_data").setData(bigDecimalChange(order.getCorStLeftcuffsSurroundingGross()));
		
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
		form.getField("St_btnhole_color_cd_data").setData(order.getStBtnholeColorNm());
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
			return "0";
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
	
}
