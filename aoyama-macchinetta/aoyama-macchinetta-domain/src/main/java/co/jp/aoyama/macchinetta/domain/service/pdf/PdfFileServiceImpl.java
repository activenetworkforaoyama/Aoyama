package co.jp.aoyama.macchinetta.domain.service.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.aoyama.macchinetta.domain.model.Factory;
import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.MemberName;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.repository.factory.FactoryRepository;
import co.jp.aoyama.macchinetta.domain.repository.measuring.MeasuringRepository;
import co.jp.aoyama.macchinetta.domain.repository.orderlist.OrderListRepository;
import co.jp.aoyama.macchinetta.domain.repository.shop.ShopRepository;
import co.jp.aoyama.macchinetta.domain.service.member.MemberNameService;
import jp.co.hos.coreports.CrDraw;
import jp.co.hos.coreports.CrFileOutJob;
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
	
	@Inject
	MemberNameService memberNameService;
	
	@Value("${member.url:http://202.214.88.88/member/api/v1/memname}")
	String memberUrl;

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
            	doc.setDocumentName("注文内容確認書_工場向");
            	Resource resource = customerService.getResource("classpath:cfx" + File.separator 
            			+ "co" + File.separator + "confirmationBookSuit-Factory.cfx");
            	form = CrForm.open(draw, resource.getInputStream());
			}else if("2".equals(sign)) {
				//注文内容確認書(SUIT)_お客様向
				doc.setDocumentName("注文内容確認書_お客様向");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "confirmationBookSuit-Guest.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("3".equals(sign)) {
				//工場指示書(SUIT)
				doc.setDocumentName("工場指示書");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "factoryInstructionsSuit.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("4".equals(sign)) {
				//注文内容確認書(COAT)_工場向
				doc.setDocumentName("注文内容確認書_工場向");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "confirmationBookCoat-Factory.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("5".equals(sign)) {
				//注文内容確認書(COAT)_お客様向
				doc.setDocumentName("注文内容確認書_お客様向");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "confirmationBookCoat-Guest.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("6".equals(sign)) {
				//工場指示書(COAT)
				doc.setDocumentName("工場指示書");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "factoryInstructionsCoat.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("7".equals(sign)) {
				//注文内容確認書(SHIRT)_工場向
				doc.setDocumentName("注文内容確認書_工場向");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "confirmationBookShirt-Factory.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("8".equals(sign)) {
				//注文内容確認書(SHIRT)_お客様向
				doc.setDocumentName("注文内容確認書_お客様向");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "confirmationBookShirt-Guest.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("9".equals(sign)) {
				//工場指示書(SHIRT)
				doc.setDocumentName("工場指示書");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "factoryInstructionsShirt.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("10".equals(sign)) {
				//工場指示書(SUIT)
				doc.setDocumentName("工場指示書(中国語)");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "factoryInstructionsSuitChinese.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("11".equals(sign)) {
				//工場指示書(SHIRT)
				doc.setDocumentName("工場指示書(中国語)");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "factoryInstructionsShirtChinese.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else if("12".equals(sign)) {
				//工場指示書(COAT)
				doc.setDocumentName("工場指示書中国語");
				Resource resource = customerService.getResource("classpath:cfx" + File.separator 
						+ "co" + File.separator + "factoryInstructionsCoatChinese.cfx");
				form = CrForm.open(draw, resource.getInputStream());
			}else{
				logger.info("このスタイルはありません");
			}
            
//            CrForm formTwo = null;
            
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
                	
                	if("01".equals(order.getProductItem()) || "02".equals(order.getProductItem())) {
                		//01:suit  02:jacket
                		insertJacketdetailedFieldDataCo(form, order);
                	}
                	if("01".equals(order.getProductItem()) || "03".equals(order.getProductItem())) {
                		//01:suit  03:pants
                		insertPantsdetailedFieldDataCo(form, order);
                	}
                	if("01".equals(order.getProductItem()) 
                			&& ("22".equals(order.getProductItemDisplaycode()) || "32".equals(order.getProductItemDisplaycode()))) {
                		//01:suit  22:2PP  32:3P2PP
                		insertPants2detailedFieldDataCo(form, order);
                	}
                	if(("01".equals(order.getProductItem()) && ("31".equals(order.getProductItemDisplaycode()) 
                			|| "32".equals(order.getProductItemDisplaycode())))
                			|| "04".equals(order.getProductItem())) {
                		//01:suit  31:3P  32:3P2PP  04:gilet
                		insertGiletdetailedFieldDataCo(form, order);
                	}
                	
    			}else if("2".equals(sign)) {
    				//注文内容確認書(SUIT)_お客様向
    				insertCommonProject(form, order, productItem);
    				insertConfirmationBookGuestSpecial(form, order);
    				insertMeasuringData(form, measuring, "0");
    				insertSuitDataCo(form, order);
    				
    				if("01".equals(order.getProductItem()) || "02".equals(order.getProductItem())) {
                		//01:suit  02:jacket
                		insertJacketdetailedFieldDataCo(form, order);
                	}
                	if("01".equals(order.getProductItem()) || "03".equals(order.getProductItem())) {
                		//01:suit  03:pants
                		insertPantsdetailedFieldDataCo(form, order);
                	}
                	if("01".equals(order.getProductItem()) 
                			&& ("22".equals(order.getProductItemDisplaycode()) || "32".equals(order.getProductItemDisplaycode()))) {
                		//01:suit  22:2PP  32:3P2PP
                		insertPants2detailedFieldDataCo(form, order);
                	}
                	if(("01".equals(order.getProductItem()) && ("31".equals(order.getProductItemDisplaycode()) 
                			|| "32".equals(order.getProductItemDisplaycode())))
                			|| "04".equals(order.getProductItem())) {
                		//01:suit  31:3P  32:3P2PP  04:gilet
                		insertGiletdetailedFieldDataCo(form, order);
                	}
    				
    			}else if("3".equals(sign)) {
    				//工場指示書(SUIT)
    				insertCommonProject(form, order, productItem);
    				insertfactoryInstructionsSpecial(form, order);
    				insertMeasuringData(form, measuring, "1");
    				insertSuitDataCo(form, order);
    				
    				if("01".equals(order.getProductItem()) || "02".equals(order.getProductItem())) {
                		//01:suit  02:jacket
                		insertJacketdetailedFieldDataCo(form, order);
                	}
                	if("01".equals(order.getProductItem()) || "03".equals(order.getProductItem())) {
                		//01:suit  03:pants
                		insertPantsdetailedFieldDataCo(form, order);
                	}
                	if("01".equals(order.getProductItem()) 
                			&& ("22".equals(order.getProductItemDisplaycode()) || "32".equals(order.getProductItemDisplaycode()))) {
                		//01:suit  22:2PP  32:3P2PP
                		insertPants2detailedFieldDataCo(form, order);
                	}
                	if(("01".equals(order.getProductItem()) && ("31".equals(order.getProductItemDisplaycode()) 
                			|| "32".equals(order.getProductItemDisplaycode())))
                			|| "04".equals(order.getProductItem())) {
                		//01:suit  31:3P  32:3P2PP  04:gilet
                		insertGiletdetailedFieldDataCo(form, order);
                	}
    				
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
    				
    			}else if("10".equals(sign)) {
    				//工場指示書(SUIT)中国語
    				insertCommonProjectChinese(form, order, productItem);
    				insertfactoryInstructionsSpecial(form, order);
    				insertMeasuringData(form, measuring, "1");
    				insertSuitDataCoChinese(form, order);
    				
    				if("01".equals(order.getProductItem()) || "02".equals(order.getProductItem())) {
                		//01:suit  02:jacket
    					insertJacketdetailedFieldDataCoChinese(form, order);
                	}
                	if("01".equals(order.getProductItem()) || "03".equals(order.getProductItem())) {
                		//01:suit  03:pants
                		insertPantsdetailedFieldDataCoChinese(form, order);
                	}
                	if("01".equals(order.getProductItem()) 
                			&& ("22".equals(order.getProductItemDisplaycode()) || "32".equals(order.getProductItemDisplaycode()))) {
                		//01:suit  22:2PP  32:3P2PP
                		insertPants2detailedFieldDataCoChinese(form, order);
                	}
                	if(("01".equals(order.getProductItem()) && ("31".equals(order.getProductItemDisplaycode()) 
                			|| "32".equals(order.getProductItemDisplaycode())))
                			|| "04".equals(order.getProductItem())) {
                		//01:suit  31:3P  32:3P2PP  04:gilet
                		insertGiletdetailedFieldDataCoChinese(form, order);
                	}
            		
    			}else if("11".equals(sign)) {
    				//工場指示書(SHIRT)中国語
    				insertCommonProject(form, order, productItem);
    				insertfactoryInstructionsSpecial(form, order);
    				insertMeasuringData(form, measuring, "1");
    				insertShirtDataCoChinese(form, order);
    				
    			}else if("12".equals(sign)) {
    				//工場指示書(COAT)中国語
    				insertCommonProject(form, order, productItem);
    				insertfactoryInstructionsSpecial(form, order);
    				insertMeasuringData(form, measuring, "1");
    				insertCoatDataCo(form, order);
    				
    			}else{
    				logger.info("このスタイルはありません");
    			}
            	// （９）１ページ出力します
                form.printOut();
                
//                if("1".equals(sign)) {
//                	//注文内容確認書(SUIT)_工場向
//                	doc.setDocumentName("注文内容確認書_工場向");
//                	Resource resourceTwo = customerService.getResource("classpath:cfx" + File.separator 
//                			+ "co" + File.separator + "suitTwo.cfx");
//                	formTwo = CrForm.open(draw, resourceTwo.getInputStream());
//    			}else if("2".equals(sign)) {
//    				//注文内容確認書(SUIT)_お客様向
//    				doc.setDocumentName("注文内容確認書_お客様向");
//    				Resource resourceTwo = customerService.getResource("classpath:cfx" + File.separator 
//    						+ "co" + File.separator + "suitTwo.cfx");
//    				formTwo = CrForm.open(draw, resourceTwo.getInputStream());
//    			}else if("3".equals(sign)) {
//    				//工場指示書(SUIT)
//    				doc.setDocumentName("工場指示書");
//    				Resource resourceTwo = customerService.getResource("classpath:cfx" + File.separator 
//    						+ "co" + File.separator + "suitTwo.cfx");
//    				formTwo = CrForm.open(draw, resourceTwo.getInputStream());
//    				form.getField("Order_id_data").setData(stringChange(order.getOrderId()));
//    			}else{
//    				logger.info("このスタイルはありません");
//    			}
//                strjob.getCrPrinter().setFormSize(formTwo);
//                if("1".equals(sign)) {
//                	//注文内容確認書(SUIT)_工場向
//                	insertJacketdetailedFieldDataCo(form, order);
//            		insertPantsdetailedFieldDataCo(form, order);
//            		insertPants2detailedFieldDataCo(form, order);
//            		insertGiletdetailedFieldDataCo(form, order);
//    			}else if("2".equals(sign)) {
//    				//注文内容確認書(SUIT)_お客様向
//    				insertJacketdetailedFieldDataCo(form, order);
//            		insertPantsdetailedFieldDataCo(form, order);
//            		insertPants2detailedFieldDataCo(form, order);
//            		insertGiletdetailedFieldDataCo(form, order);
//    			}else if("3".equals(sign)) {
//    				//工場指示書(SUIT)
//    				insertJacketdetailedFieldDataCo(form, order);
//            		insertPantsdetailedFieldDataCo(form, order);
//            		insertPants2detailedFieldDataCo(form, order);
//            		insertGiletdetailedFieldDataCo(form, order);
//    			}
                
//				formTwo.printOut();
                // （１０）ファイル出力ジョブを終了します
                draw.endJob();
            } finally {
                // （１１）フォームを閉じます
                form.close();
//                formTwo.close();
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
	 * pdfファイルの書き方
	 */
	@Override
	public void outputPrintPdf(String sign, Order order, Measuring measuring, String productItem,String path,String filename) throws Exception{
		@SuppressWarnings("resource")
		//xmlファイルの読む込み
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"META-INF" + File.separator + "spring" + File.separator + "aoyama-macchinetta-customer.xml");
		
		//リソースを読み込むServiceのクラスを準備します
		CustomerService customerService = (CustomerService) appContext.getBean("customerService");
		
		
        // （１）描画クラスのインスタンスを生成します
        CrDraw draw = new CrDraw();
        
        draw.setDocumentPath(path);
        
        try {
        	
            // （２）CrDrawのプロパティを設定します
            // フォームファイルを読み込むパスを指定します
            // 出力先のフォルダを指定します
            // 画像等のデータファイルが置いてあるディレクトリを設定します
            // 作業用ディレクトリを設定します
        	
            // （３）出力形式とファイル名を指定してファイル出力ジョブを生成します
            //CrStreamOutJob strjob = new CrStreamOutJob(CorDocumentType.PDF, output);
        	// ドキュメントタイプとファイル名を指定してジョブを作成します
        	
        	CrFileOutJob strjob = new CrFileOutJob(CorDocumentType.PDF, filename);
            
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
    }
	
	public void delectePrintPdf(String pdfPath) throws Exception{
		
		File file = new File(pdfPath);
		if (file.exists()){
			file.delete();
		}else{
			logger.info("DeletePrintPDF は存在しません");
		}
	
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
		if("9000101".equals(stringChange(order.getProductCategory()))) {
			form.getField("Product_category_data").setData("標準");
		}else if("9000103".equals(stringChange(order.getProductCategory()))) {
			form.getField("Product_category_data").setData("ウォッシャブル");
		}else if("9000102".equals(stringChange(order.getProductCategory()))) {
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
		ProductCompos = ProductCompos.replace("<br>", " ");
    	form.getField("Product_compos_data").setData(ProductCompos);
    	//お客様備考
//    	form.getField("Cust_remark_data").setData(stringChange(order.getCustRemark()));
		
		//品名,ITEM
		form.getField("Product_item_data").setData(stringChange(productItem));
		//工場品番,FABRIC ID.
		form.getField("Product_fabric_no_data").setData(stringChange(order.getProductFabricNo()) + "-" 
				+ stringChange(order.getFabricColor()) + stringChange(order.getFabricPattern()));
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
	 * 共通のプロジェクト
	 * @param form
	 * @param order
	 */
	private void insertCommonProjectChinese(CrForm form, Order order, String productItem) {
		//注文ID
		form.getField("Order_id_data").setData(stringChange(order.getOrderId()));
		//EMBROIDERY,刺繡表示
		form.getField("Product_embroidery_nm_data").setData(stringChange(order.getProductEmbroideryNm()));
		//FONT,書体
		form.getField("Product_embroidery_font_data").setData(stringChange(order.getProductEmbroideryFont()));
		//COLOR,糸色
		form.getField("product_embroidery_thread_color_data").setData(stringChange(order.getProductEmbroideryThreadColor()));
		//カテゴリ
		form.getField("Product_category_data").setData(stringChange(order.getProductCategoryNm()));
		//承り日
		form.getField("Product_orderd_date_data").setData(dateChange(order.getProductOrderdDate()));
		
		//組成
		String ProductCompos = "";
		if(!("".equals(order.getProductComposFrtFabric()) || order.getProductComposFrtFabric() == null)) {
			ProductCompos = "【面料】"+order.getProductComposFrtFabric();
			if(!("".equals(order.getProductComposBodyLiner()) || order.getProductComposBodyLiner() == null)) {
				ProductCompos = ProductCompos+"  【身里料】"+order.getProductComposBodyLiner();
    		}
			if(!("".equals(order.getProductComposSleeveLiner()) || order.getProductComposSleeveLiner() == null)) {
				ProductCompos = ProductCompos+"  【袖里料】"+order.getProductComposSleeveLiner();
    		}
		}else {
			if(!("".equals(order.getProductComposBodyLiner()) || order.getProductComposBodyLiner() == null)) {
				ProductCompos = "【身里料】"+order.getProductComposBodyLiner();
				if(!("".equals(order.getProductComposSleeveLiner()) || order.getProductComposSleeveLiner() == null)) {
    				ProductCompos = ProductCompos+"  【袖里料】"+order.getProductComposSleeveLiner();
        		}
    		}else if(!("".equals(order.getProductComposSleeveLiner()) || order.getProductComposSleeveLiner() == null)) {
				ProductCompos = "【袖里料】"+order.getProductComposSleeveLiner();
    		}
		}
		ProductCompos = ProductCompos.replace("<br>", " ");
    	form.getField("Product_compos_data").setData(ProductCompos);
    	//お客様備考
    	//form.getField("Cust_remark_data").setData(stringChange(order.getCustRemark()));
		
		//品名,ITEM
		form.getField("Product_item_data").setData(stringChange(productItem));
		//工場品番,FABRIC ID.
		form.getField("Product_fabric_no_data").setData(stringChange(order.getProductFabricNo()) + "-" 
				+ stringChange(order.getFabricColor()) + stringChange(order.getFabricPattern()));
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
		form.getField("Name_data").setData(stringChange(getNameByMemberUrl(order)));
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
		form.getField("Name_data").setData(stringChange(getNameByMemberUrl(order)));
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
		//残布
		form.getField("product_remaining_cloth_data").setData(stringChange(order.getProductRemainingClothNm()));
		
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
		//肩パット
		form.getField("Cor_jk_shoulderpad_data").setData(stringChange(order.getCorJkShoulderpad()));
		//体型補正
		form.getField("Cor_jk_figure_correct_data").setData(stringChange(order.getCorJkFigureCorrect()));
								
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
		
		//裾幅name
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_size_name").setData("裾幅修正");
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_size_name").setData("裾幅指定");
		}
		
		//型サイズ
		//ウエスト
		form.getField("Cor_pt_waist_size_data1").setData(bigDecimalChange(order.getCorPtWaistSize()));
		//ヒップ
		form.getField("Cor_pt_hip_size_data1").setData(bigDecimalChange(order.getCorPtHipSize()));
		//ワタリ
		form.getField("Cor_pt_thighwidth_size_data1").setData(bigDecimalChange(order.getCorPtThighwidthSize()));
		//裾幅
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_size_data1").setData(bigDecimalChange(order.getCorPtHemwidthSize()));
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_size_data1").setData("");
		}
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
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_correct_data1").setData(bigDecimalChange(order.getCorPtHemwidthCorrect()));
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_correct_data1").setData("");
		}
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
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_gross_data1").setData(bigDecimalChange(order.getCorPtHemwidthGross()));
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_gross_data1").setData(bigDecimalChange(order.getCorPtHemwidthDegignate()));
		}
		//股下右
		form.getField("Cor_pt_rightinseam_gross_data1").setData(bigDecimalChange(order.getCorPtRightinseamGross()));
		//股下左
		form.getField("Cor_pt_leftinseam_gross_data1").setData(bigDecimalChange(order.getCorPtLeftinseamGross()));
		
		//PANTS
		//サイズ
		form.getField("Cor_pt2_size_data").setData(stringChange(order.getCorPt2Drop())+" - "+stringChange(order.getCorPt2Size()));
		
		//裾幅name
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_size_name").setData("裾幅修正");
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_size_name").setData("裾幅指定");
		}
		
		//型サイズ
		//ウエスト
		form.getField("Cor_pt2_waist_size_data").setData(bigDecimalChange(order.getCorPt2WaistSize()));
		//ヒップ
		form.getField("Cor_pt2_hip_size_data").setData(bigDecimalChange(order.getCorPt2HipSize()));
		//ワタリ
		form.getField("Cor_pt2_thighwidth_size_data").setData(bigDecimalChange(order.getCorPt2ThighwidthSize()));
		//裾幅
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_size_data").setData(bigDecimalChange(order.getCorPt2HemwidthSize()));
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_size_data").setData("");
		}
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
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_correct_data").setData(bigDecimalChange(order.getCorPt2HemwidthCorrect()));
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_correct_data").setData("");
		}
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
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_gross_data").setData(bigDecimalChange(order.getCorPt2HemwidthGross()));
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_gross_data").setData(bigDecimalChange(order.getCorPt2HemwidthDegignate()));
		}
		//股下右
		form.getField("Cor_pt2_rightinseam_gross_data").setData(bigDecimalChange(order.getCorPt2RightinseamGross()));
		//股下左
		form.getField("Cor_pt2_leftinseam_gross_data").setData(bigDecimalChange(order.getCorPt2LeftinseamGross()));
		
		//GILET
		//サイズ
		form.getField("cor_gl_size_data").setData(stringChange(order.getCorGlDrop())+" - "+stringChange(order.getCorGlSize()));
		
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
		form.getField("Jk_model_cd_data").setData(stringChange(order.getJkModelNm()));
		//フロント釦数
		form.getField("Jk_frt_btn_data").setData(stringChange(order.getJkFrtBtnNm()));
		//ラペルデザイン
		form.getField("Jk_lapel_design_data").setData(stringChange(order.getJkLapelDesignNm()));
		//グレード
		form.getField("Jk_grade_data").setData(stringChange(order.getJkGradeNm()));
		//裏仕様
		form.getField("Jk_inner_cloth_data").setData(stringChange(order.getJkInnerClothNm()));
		//台場
		form.getField("Jk_daiba_data").setData(stringChange(order.getJkDaibaNm()));
		//拝見地
		form.getField("Jk_look_cloth_data").setData(stringChange(order.getJkLookClothNm()));
		//襟裏（ヒゲ）
		form.getField("Jk_collar_inner_data").setData(stringChange(order.getJkCollarInnerNm()));
		//襟吊
		form.getField("Jk_collar_hang_data").setData(stringChange(order.getJkCollarHangNm()));
		//ラペル幅
		form.getField("Jk_lapel_width_data").setData(stringChange(order.getJkLapelWidthNm()));
		//フラワーホール
		form.getField("Jk_flower_hole_data").setData(stringChange(order.getJkFlowerHoleNm()));
		//胸ポケット
		form.getField("Jk_breast_pkt_data").setData(stringChange(order.getJkBreastPktNm()));
		//腰ポケット
		form.getField("Jk_waist_pkt_data").setData(stringChange(order.getJkWaistPktNm()));
		//チェンジポケット
		form.getField("Jk_chg_pkt_data").setData(stringChange(order.getJkChgPktNm()));
		//スランテッドポケット
		form.getField("Jk_slanted_pkt_data").setData(stringChange(order.getJkSlantedPktNm()));
		//忍びポケット
		form.getField("Jk_shinobi_pkt_data").setData(stringChange(order.getJkShinobiPktNm()));
		//袖仕様
		form.getField("Jk_sleeve_type_data").setData(stringChange(order.getJkSleeveTypeNm()));
		//マニカ
		form.getField("Jk_manica_data").setData(stringChange(order.getJkManicaNm()));
		//袖釦
		Short jkSleeveBtnNumber = order.getJkSleeveBtnNumber();
		if(jkSleeveBtnNumber == null) {
			form.getField("Jk_sleeve_btn_data").setData("");
		}else {
			form.getField("Jk_sleeve_btn_data").setData(stringChange(order.getJkSleeveBtnNm()) + shortChange(jkSleeveBtnNumber));
		}
		//袖口
		form.getField("Jk_cuff_data").setData(stringChange(order.getJkCuffNm()));
		//内ポケット変更
		if("0002001".equals(stringChange(order.getJkInnerPktType()))) {
			form.getField("Jk_inner_pkt_data").setData("無し");
		}else if("0002002".equals(stringChange(order.getJkInnerPktType()))){
			form.getField("Jk_inner_pkt_data").setData("有り");
		}
		//下前胸内ポケット仕様
		form.getField("Jk_right_inner_pkt_type_data").setData(stringChange(order.getJkRightInnerPktTypeNm()));
		//ステッチ種類
		form.getField("Jk_stitch_type_data").setData(stringChange(order.getJkStitchTypeNm()));
		//ステッチ箇所変更
		if("0002401".equals(stringChange(order.getJkStitchPlcType()))) {
			form.getField("Jk_stitch_plc_data").setData("無し");
		}else if("0002402".equals(stringChange(order.getJkStitchPlcType()))){
			form.getField("Jk_stitch_plc_data").setData("有り");
		}
		//ダブルステッチ変更
		if("0002601".equals(stringChange(order.getJkDblstitchPlcType()))) {
			form.getField("Jk_dblstitch_plc_data").setData("無し");
		}else if("0002602".equals(stringChange(order.getJkDblstitchPlcType()))){
			form.getField("Jk_dblstitch_plc_data").setData("有り");
		}
		//AMF色指定
		if("0002801".equals(stringChange(order.getJkAmfColorType()))) {
			form.getField("Jk_amf_color_data").setData("無し");
		}else if("0002802".equals(stringChange(order.getJkAmfColorType()))){
			form.getField("Jk_amf_color_data").setData("有り");
		}
		//ボタンホール色指定
		if("0003101".equals(stringChange(order.getJkBtnholeColorType()))) {
			form.getField("Jk_btnhole_color_data").setData("無し");
		}else if("0003102".equals(stringChange(order.getJkBtnholeColorType()))){
			form.getField("Jk_btnhole_color_data").setData("有り");
		}
		//ボタン付け糸指定
		if("0003401".equals(stringChange(order.getJkBtnthreadColorType()))) {
			form.getField("Jk_btnthread_color_data").setData("無し");
		}else if("0003402".equals(stringChange(order.getJkBtnthreadColorType()))){
			form.getField("Jk_btnthread_color_data").setData("有り");
		}
		//ベント
		form.getField("Jk_vent_data").setData(stringChange(order.getJkVentNm()));
		//胴裏素材
		form.getField("Jk_inner_body_cloth_data").setData(stringChange(order.getJkInnerBodyClothNm()));
		//袖裏素材
		form.getField("Jk_inner_sleeve_cloth_data").setData(stringChange(order.getJkInnerSleeveClothNm()));
		//釦素材
		form.getField("Jk_btn_material_data").setData(stringChange(order.getJkBtnMaterialNm()));
		//形状記憶
		form.getField("Jk_shape_memory_data").setData(stringChange(order.getJkShapeMemoryNm()));
		
		//PANTS
		//PANTSモデル
		form.getField("Pt_model_data").setData(stringChange(order.getPtModelNm()));
		//タック
		form.getField("Pt_tack_data").setData(stringChange(order.getPtTackNm()));
		//膝裏
		form.getField("Pt_kneeinner_type_data").setData(stringChange(order.getPtKneeinnerTypeNm()));
		//膝裏素材
		form.getField("Pt_kneeinner_cloth_data").setData(stringChange(order.getPtKneeinnerClothNm()));
		//フロント仕様
		form.getField("Pt_frt_type_data").setData(stringChange(order.getPtFrtTypeNm()));
		//パンチェリーナ
		form.getField("Pt_pancherina_data").setData(stringChange(order.getPtPancherinaNm()));
		//アジャスター仕様
		form.getField("Pt_adjuster_data").setData(stringChange(order.getPtAdjusterNm()));
		//ベルトループ
		if("0000702".equals(stringChange(order.getPtBeltloopType()))) {
			form.getField("Pt_beltloop_data").setData("無し");
		}else if("0000701".equals(stringChange(order.getPtBeltloopType()))){
			form.getField("Pt_beltloop_data").setData("有り");
		}
		//ピンループ
		form.getField("Pt_pinloop_data").setData(stringChange(order.getPtPinloopNm()));
		//脇ポケット
		form.getField("Pt_side_pkt_data").setData(stringChange(order.getPtSidePktNm()));
		//忍びポケット
		form.getField("Pt_shinobi_pkt_data").setData(stringChange(order.getPtShinobiPktNm()));
		//コインポケット
		form.getField("Pt_coin_pkt_cd_data").setData(stringChange(order.getPtCoinPktNm()));
		//フラップ付コインポケット
		form.getField("Pt_flapcoin_pkt_data").setData(stringChange(order.getPtFlapcoinPktNm()));
		//上前ピスポケット
		form.getField("Pt_left_pis_pkt_data").setData(stringChange(order.getPtLeftPisPktNm()));
		//下前ピスポケット
		form.getField("Pt_right_pis_pkt_data").setData(stringChange(order.getPtRightPisPktNm()));
		//Vカット
		form.getField("Pt_v_cut_data").setData(stringChange(order.getPtVCutNm()));
		//裾上げ
		form.getField("Pt_hem_up_data").setData(stringChange(order.getPtHemUpNm()));
		//ダブル幅
		form.getField("Pt_dbl_width_data").setData(stringChange(order.getPtDblWidthNm()));
		//ステッチ種類
		form.getField("Pt_stitch_type_data").setData(stringChange(order.getPtAmfStitchNm()));
		//ステッチ箇所変更
		if("0002001".equals(stringChange(order.getPtStitchPlcType()))) {
			form.getField("Pt_stitch_plc_data").setData("無し");
		}else if("0002002".equals(stringChange(order.getPtStitchPlcType()))){
			form.getField("Pt_stitch_plc_data").setData("有り");
		}
		//ダブルステッチ
		if("0002201".equals(stringChange(order.getPtDblstitchPlcType()))) {
			form.getField("Pt_dblstitch_plc_data").setData("無し");
		}else if("0002202".equals(stringChange(order.getPtDblstitchPlcType()))){
			form.getField("Pt_dblstitch_plc_data").setData("有り");
		}
		//AMF色指定
		if("0002401".equals(stringChange(order.getPtAmfColorType()))) {
			form.getField("Pt_amf_color_data").setData("無し");
		}else if("0002402".equals(stringChange(order.getPtAmfColorType()))){
			form.getField("Pt_amf_color_data").setData("有り");
		}
		//ボタンホール色指定
		if("0002701".equals(stringChange(order.getPtBtnholeColorType()))) {
			form.getField("Pt_btnhole_color_data").setData("無し");
		}else if("0002702".equals(stringChange(order.getPtBtnholeColorType()))){
			form.getField("Pt_btnhole_color_data").setData("有り");
		}
		//ボタン付け糸指定
		if("0003001".equals(stringChange(order.getPtBtnthreadColorType()))) {
			form.getField("Pt_btnthread_color_data").setData("無し");
		}else if("0003002".equals(stringChange(order.getPtBtnthreadColorType()))){
			form.getField("Pt_btnthread_color_data").setData("有り");
		}
		//釦素材
		form.getField("Pt_btn_material_data").setData(stringChange(order.getPtBtnMaterialNm()));
		//サスペンダー釦
		form.getField("Pt_suspender_btn_data").setData(stringChange(order.getPtSuspenderBtnNm()));
		//エイト（滑り止め）
		form.getField("Pt_non_slip_data").setData(stringChange(order.getPtNonSlipNm()));
		//シック（股補強）
		form.getField("Pt_chic_slip_data").setData(stringChange(order.getPtChicSlipNm()));
		//形状記憶
		form.getField("Pt_shape_memory_data").setData(stringChange(order.getPtShapeMemoryNm()));
		//側章
		form.getField("Pt_side_stripe_data").setData(stringChange(order.getPtSideStripeNm()));
		//側章幅
		form.getField("Pt_side_stripe_width_data").setData(stringChange(order.getPtSideStripeWidthNm()));
		
		//PANTS
		//PANTSモデル
		form.getField("Pt_model_data2").setData(stringChange(order.getPt2ModelNm()));
		//タック
		form.getField("Pt_tack_data2").setData(stringChange(order.getPt2TackNm()));
		//膝裏
		form.getField("Pt_kneeinner_type_data2").setData(stringChange(order.getPt2KneeinnerTypeNm()));
		//膝裏素材
		form.getField("Pt_kneeinner_cloth_data2").setData(stringChange(order.getPt2KneeinnerClothNm()));
		//フロント仕様
		form.getField("Pt_frt_type_data2").setData(stringChange(order.getPt2FrtTypeNm()));
		//パンチェリーナ
		form.getField("Pt_pancherina_data2").setData(stringChange(order.getPt2PancherinaNm()));
		//アジャスター仕様
		form.getField("Pt_adjuster_data2").setData(stringChange(order.getPt2AdjusterNm()));
		//ベルトループ
		if("0000702".equals(stringChange(order.getPt2BeltloopType()))) {
			form.getField("Pt_beltloop_data2").setData("無し");
		}else if("0000701".equals(stringChange(order.getPt2BeltloopType()))){
			form.getField("Pt_beltloop_data2").setData("有り");
		}
		//ピンループ
		form.getField("Pt_pinloop_data2").setData(stringChange(order.getPt2PinloopNm()));
		//脇ポケット
		form.getField("Pt_side_pkt_data2").setData(stringChange(order.getPt2SidePktNm()));
		//忍びポケット
		form.getField("Pt_shinobi_pkt_data2").setData(stringChange(order.getPt2ShinobiPktNm()));
		//コインポケット
		form.getField("Pt_coin_pkt_cd_data2").setData(stringChange(order.getPt2CoinPktNm()));
		//フラップ付コインポケット
		form.getField("Pt_flapcoin_pkt_data2").setData(stringChange(order.getPt2FlapcoinPktNm()));
		//上前ピスポケット
		form.getField("Pt_left_pis_pkt_data2").setData(stringChange(order.getPt2LeftPisPktNm()));
		//下前ピスポケット
		form.getField("Pt_right_pis_pkt_data2").setData(stringChange(order.getPt2RightPisPktNm()));
		//Vカット
		form.getField("Pt_v_cut_data2").setData(stringChange(order.getPt2VCutNm()));
		//裾上げ
		form.getField("Pt_hem_up_data2").setData(stringChange(order.getPt2HemUpNm()));
		//ダブル幅
		form.getField("Pt_dbl_width_data2").setData(stringChange(order.getPt2DblWidthNm()));
		//ステッチ種類
		form.getField("Pt_stitch_type_data2").setData(stringChange(order.getPt2AmfStitchNm()));
		//ステッチ箇所変更
		if("0002001".equals(stringChange(order.getPt2StitchPlcType()))) {
			form.getField("Pt_stitch_plc_data2").setData("無し");
		}else if("0002002".equals(stringChange(order.getPt2StitchPlcType()))){
			form.getField("Pt_stitch_plc_data2").setData("有り");
		}
		//ダブルステッチ
		if("0002201".equals(stringChange(order.getPt2DblstitchPlcType()))) {
			form.getField("Pt_dblstitch_plc_data2").setData("無し");
		}else if("0002202".equals(stringChange(order.getPt2DblstitchPlcType()))){
			form.getField("Pt_dblstitch_plc_data2").setData("有り");
		}
		//AMF色指定
		if("0002401".equals(stringChange(order.getPt2AmfColorType()))) {
			form.getField("Pt_amf_color_data2").setData("無し");
		}else if("0002402".equals(stringChange(order.getPt2AmfColorType()))){
			form.getField("Pt_amf_color_data2").setData("有り");
		}
		//ボタンホール色指定
		if("0002701".equals(stringChange(order.getPt2BtnholeColorType()))) {
			form.getField("Pt_btnhole_color_data2").setData("無し");
		}else if("0002702".equals(stringChange(order.getPt2BtnholeColorType()))){
			form.getField("Pt_btnhole_color_data2").setData("有り");
		}
		//ボタン付け糸指定
		if("0003001".equals(stringChange(order.getPt2BtnthreadColorType()))) {
			form.getField("Pt_btnthread_color_data2").setData("無し");
		}else if("0003002".equals(stringChange(order.getPt2BtnthreadColorType()))){
			form.getField("Pt_btnthread_color_data2").setData("有り");
		}
		//釦素材
		form.getField("Pt_btn_material_data2").setData(stringChange(order.getPt2BtnMaterialNm()));
		//サスペンダー釦
		form.getField("Pt_suspender_btn_data2").setData(stringChange(order.getPt2SuspenderBtnNm()));
		//エイト（滑り止め）
		form.getField("Pt_non_slip_data2").setData(stringChange(order.getPt2NonSlipNm()));
		//シック（股補強）
		form.getField("Pt_chic_slip_data2").setData(stringChange(order.getPt2ChicSlipNm()));
		//形状記憶
		form.getField("Pt_shape_memory_data2").setData(stringChange(order.getPt2ShapeMemoryNm()));
		//側章
		form.getField("Pt_side_stripe_data2").setData(stringChange(order.getPt2SideStripeNm()));
		//側章幅
		form.getField("Pt_side_stripe_width_data2").setData(stringChange(order.getPt2SideStripeWidthNm()));
		
		//GILET
		//GILETモデル
		form.getField("Gl_model_data").setData(stringChange(order.getGlModelNm()));
		//胸ポケット
		form.getField("Gl_breast_pkt_data").setData(stringChange(order.getGlBreastPktNm()));
		//腰ポケット
		form.getField("Gl_waist_pkt_data").setData(stringChange(order.getGlWaistPktNm()));
		//腰ポケット形状
		form.getField("Gl_waist_pkt_shape_data").setData(stringChange(order.getGlWaistPktShapeNm()));
		//腰ポケット素材
		form.getField("Gl_waist_pkt_cloth_data").setData(stringChange(order.getGlWaistPktClothNm()));
		//ステッチ種類
		form.getField("Gl_stitch_type_data").setData(stringChange(order.getGlAmfStitchNm()));
		//ステッチ箇所変更
		if("0000601".equals(stringChange(order.getGlStitchPlcType()))) {
			form.getField("Gl_stitch_plc_data").setData("無し");
		}else if("0000602".equals(stringChange(order.getGlStitchPlcType()))){
			form.getField("Gl_stitch_plc_data").setData("有り");
		}
		//ダブルステッチ変更
		if("0002601".equals(stringChange(order.getGlDblstitchPlcType()))) {
			form.getField("Gl_dblstitch_plc_data").setData("無し");
		}else if("0002602".equals(stringChange(order.getGlDblstitchPlcType()))){
			form.getField("Gl_dblstitch_plc_data").setData("有り");
		}
		//AMF色指定
		if("0000801".equals(stringChange(order.getGlAmfColorType()))) {
			form.getField("Gl_amf_color_data").setData("無し");
		}else if("0000802".equals(stringChange(order.getGlAmfColorType()))){
			form.getField("Gl_amf_color_data").setData("有り");
		}
		//ボタンホール色指定
		if("0001101".equals(stringChange(order.getGlBtnholeColorType()))) {
			form.getField("Gl_btnhole_color_data").setData("無し");
		}else if("0001102".equals(stringChange(order.getGlBtnholeColorType()))){
			form.getField("Gl_btnhole_color_data").setData("有り");
		}
		//ボタン付け糸指定
		if("0001401".equals(stringChange(order.getGlBtnthreadColorType()))) {
			form.getField("Gl_btnthread_color_data").setData("無し");
		}else if("0001402".equals(stringChange(order.getGlBtnthreadColorType()))){
			form.getField("Gl_btnthread_color_data").setData("有り");
		}
		//背裏地素材
		form.getField("Gl_back_cloth_data").setData(stringChange(order.getGlBackClothNm()));
		//内側裏地素材
		form.getField("Gl_innner_cloth_data").setData(stringChange(order.getGlInnnerClothNm()));
		//釦素材
		form.getField("Gl_btn_material_data").setData(stringChange(order.getGlFrtBtnNm()));
		//バックベルト
		form.getField("Gl_back_belt_data").setData(stringChange(order.getGlBackBeltNm()));
		//ウォッチチェーン
		form.getField("Gl_watch_chain_data").setData(stringChange(order.getGlWatchChainNm()));			
	}
	
	private void insertSuitDataCoChinese(CrForm form, Order order) {
		//残布
		form.getField("product_remaining_cloth_data").setData(stringChange(order.getProductRemainingClothNm()));
		
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
		//肩パット
		form.getField("Cor_jk_shoulderpad_data").setData(stringChange(order.getCorJkShoulderpad()));
		//体型補正
		form.getField("Cor_jk_figure_correct_data").setData(stringChange(order.getCorJkFigureCorrect()));
								
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
		
		//裾幅name
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_size_name").setData("褲口修正");
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_size_name").setData("褲口指定");
		}
		
		//型サイズ
		//ウエスト
		form.getField("Cor_pt_waist_size_data1").setData(bigDecimalChange(order.getCorPtWaistSize()));
		//ヒップ
		form.getField("Cor_pt_hip_size_data1").setData(bigDecimalChange(order.getCorPtHipSize()));
		//ワタリ
		form.getField("Cor_pt_thighwidth_size_data1").setData(bigDecimalChange(order.getCorPtThighwidthSize()));
		//裾幅
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_size_data1").setData(bigDecimalChange(order.getCorPtHemwidthSize()));
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_size_data1").setData("");
		}
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
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_correct_data1").setData(bigDecimalChange(order.getCorPtHemwidthCorrect()));
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_correct_data1").setData("");
		}
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
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_gross_data1").setData(bigDecimalChange(order.getCorPtHemwidthGross()));
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt_hemwidth_gross_data1").setData(bigDecimalChange(order.getCorPtHemwidthDegignate()));
		}
		//股下右
		form.getField("Cor_pt_rightinseam_gross_data1").setData(bigDecimalChange(order.getCorPtRightinseamGross()));
		//股下左
		form.getField("Cor_pt_leftinseam_gross_data1").setData(bigDecimalChange(order.getCorPtLeftinseamGross()));
		
		//PANTS
		//サイズ
		form.getField("Cor_pt2_size_data").setData(stringChange(order.getCorPt2Drop())+" - "+stringChange(order.getCorPt2Size()));
		
		//裾幅name
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_size_name").setData("褲口修正");
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_size_name").setData("褲口指定");
		}
		
		//型サイズ
		//ウエスト
		form.getField("Cor_pt2_waist_size_data").setData(bigDecimalChange(order.getCorPt2WaistSize()));
		//ヒップ
		form.getField("Cor_pt2_hip_size_data").setData(bigDecimalChange(order.getCorPt2HipSize()));
		//ワタリ
		form.getField("Cor_pt2_thighwidth_size_data").setData(bigDecimalChange(order.getCorPt2ThighwidthSize()));
		//裾幅
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_size_data").setData(bigDecimalChange(order.getCorPt2HemwidthSize()));
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_size_data").setData("");
		}
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
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_correct_data").setData(bigDecimalChange(order.getCorPt2HemwidthCorrect()));
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_correct_data").setData("");
		}
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
		if("1".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_gross_data").setData(bigDecimalChange(order.getCorPt2HemwidthGross()));
		}else if("2".equals(order.getCorPtHemwidthType())) {
			form.getField("Cor_pt2_hemwidth_gross_data").setData(bigDecimalChange(order.getCorPt2HemwidthDegignate()));
		}
		//股下右
		form.getField("Cor_pt2_rightinseam_gross_data").setData(bigDecimalChange(order.getCorPt2RightinseamGross()));
		//股下左
		form.getField("Cor_pt2_leftinseam_gross_data").setData(bigDecimalChange(order.getCorPt2LeftinseamGross()));
		
		//GILET
		//サイズ
		form.getField("cor_gl_size_data").setData(stringChange(order.getCorGlDrop())+" - "+stringChange(order.getCorGlSize()));
		
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
		form.getField("Jk_model_cd_data").setData(stringChange(order.getJkModelNm()));
		//フロント釦数
		form.getField("Jk_frt_btn_data").setData(stringChange(order.getJkFrtBtnNm()));
		//ラペルデザイン
		form.getField("Jk_lapel_design_data").setData(stringChange(order.getJkLapelDesignNm()));
		//グレード
		form.getField("Jk_grade_data").setData(stringChange(order.getJkGradeNm()));
		//裏仕様
		form.getField("Jk_inner_cloth_data").setData(stringChange(order.getJkInnerClothNm()));
		//台場
		form.getField("Jk_daiba_data").setData(stringChange(order.getJkDaibaNm()));
		//拝見地
		form.getField("Jk_look_cloth_data").setData(stringChange(order.getJkLookClothNm()));
		//襟裏（ヒゲ）
		form.getField("Jk_collar_inner_data").setData(stringChange(order.getJkCollarInnerNm()));
		//襟吊
		form.getField("Jk_collar_hang_data").setData(stringChange(order.getJkCollarHangNm()));
		//ラペル幅
		form.getField("Jk_lapel_width_data").setData(stringChange(order.getJkLapelWidthNm()));
		//フラワーホール
		form.getField("Jk_flower_hole_data").setData(stringChange(order.getJkFlowerHoleNm()));
		//胸ポケット
		form.getField("Jk_breast_pkt_data").setData(stringChange(order.getJkBreastPktNm()));
		//腰ポケット
		form.getField("Jk_waist_pkt_data").setData(stringChange(order.getJkWaistPktNm()));
		//チェンジポケット
		form.getField("Jk_chg_pkt_data").setData(stringChange(order.getJkChgPktNm()));
		//スランテッドポケット
		form.getField("Jk_slanted_pkt_data").setData(stringChange(order.getJkSlantedPktNm()));
		//忍びポケット
		form.getField("Jk_shinobi_pkt_data").setData(stringChange(order.getJkShinobiPktNm()));
		//袖仕様
		form.getField("Jk_sleeve_type_data").setData(stringChange(order.getJkSleeveTypeNm()));
		//マニカ
		form.getField("Jk_manica_data").setData(stringChange(order.getJkManicaNm()));
		//袖釦
		Short jkSleeveBtnNumber = order.getJkSleeveBtnNumber();
		if(jkSleeveBtnNumber == null) {
			form.getField("Jk_sleeve_btn_data").setData("");
		}else {
			form.getField("Jk_sleeve_btn_data").setData(stringChange(order.getJkSleeveBtnNm()) + shortChange(jkSleeveBtnNumber));
		}
		//袖口
		form.getField("Jk_cuff_data").setData(stringChange(order.getJkCuffNm()));
		//内ポケット変更
		if("0002001".equals(stringChange(order.getJkInnerPktType()))) {
			form.getField("Jk_inner_pkt_data").setData("无");
		}else if("0002002".equals(stringChange(order.getJkInnerPktType()))){
			form.getField("Jk_inner_pkt_data").setData("有");
		}
		//下前胸内ポケット仕様
		form.getField("Jk_right_inner_pkt_type_data").setData(stringChange(order.getJkRightInnerPktTypeNm()));
		//ステッチ種類
		form.getField("Jk_stitch_type_data").setData(stringChange(order.getJkStitchTypeNm()));
		//ステッチ箇所変更
		if("0002401".equals(stringChange(order.getJkStitchPlcType()))) {
			form.getField("Jk_stitch_plc_data").setData("无");
		}else if("0002402".equals(stringChange(order.getJkStitchPlcType()))){
			form.getField("Jk_stitch_plc_data").setData("有");
		}
		//ダブルステッチ変更
		if("0002601".equals(stringChange(order.getJkDblstitchPlcType()))) {
			form.getField("Jk_dblstitch_plc_data").setData("无");
		}else if("0002602".equals(stringChange(order.getJkDblstitchPlcType()))){
			form.getField("Jk_dblstitch_plc_data").setData("有");
		}
		//AMF色指定
		if("0002801".equals(stringChange(order.getJkAmfColorType()))) {
			form.getField("Jk_amf_color_data").setData("无");
		}else if("0002802".equals(stringChange(order.getJkAmfColorType()))){
			form.getField("Jk_amf_color_data").setData("有");
		}
		//ボタンホール色指定
		if("0003101".equals(stringChange(order.getJkBtnholeColorType()))) {
			form.getField("Jk_btnhole_color_data").setData("无");
		}else if("0003102".equals(stringChange(order.getJkBtnholeColorType()))){
			form.getField("Jk_btnhole_color_data").setData("有");
		}
		//ボタン付け糸指定
		if("0003401".equals(stringChange(order.getJkBtnthreadColorType()))) {
			form.getField("Jk_btnthread_color_data").setData("无");
		}else if("0003402".equals(stringChange(order.getJkBtnthreadColorType()))){
			form.getField("Jk_btnthread_color_data").setData("有");
		}
		//ベント
		form.getField("Jk_vent_data").setData(stringChange(order.getJkVentNm()));
		//胴裏素材
		form.getField("Jk_inner_body_cloth_data").setData(stringChange(order.getJkInnerBodyClothNm()));
		//袖裏素材
		form.getField("Jk_inner_sleeve_cloth_data").setData(stringChange(order.getJkInnerSleeveClothNm()));
		//釦素材
		form.getField("Jk_btn_material_data").setData(stringChange(order.getJkBtnMaterialNm()));
		//形状記憶
		form.getField("Jk_shape_memory_data").setData(stringChange(order.getJkShapeMemoryNm()));
		
		//PANTS
		//PANTSモデル
		form.getField("Pt_model_data").setData(stringChange(order.getPtModelNm()));
		//タック
		form.getField("Pt_tack_data").setData(stringChange(order.getPtTackNm()));
		//膝裏
		form.getField("Pt_kneeinner_type_data").setData(stringChange(order.getPtKneeinnerTypeNm()));
		//膝裏素材
		form.getField("Pt_kneeinner_cloth_data").setData(stringChange(order.getPtKneeinnerClothNm()));
		//フロント仕様
		form.getField("Pt_frt_type_data").setData(stringChange(order.getPtFrtTypeNm()));
		//パンチェリーナ
		form.getField("Pt_pancherina_data").setData(stringChange(order.getPtPancherinaNm()));
		//アジャスター仕様
		form.getField("Pt_adjuster_data").setData(stringChange(order.getPtAdjusterNm()));
		//ベルトループ
		if("0000702".equals(stringChange(order.getPtBeltloopType()))) {
			form.getField("Pt_beltloop_data").setData("无");
		}else if("0000701".equals(stringChange(order.getPtBeltloopType()))){
			form.getField("Pt_beltloop_data").setData("有");
		}
		//ピンループ
		form.getField("Pt_pinloop_data").setData(stringChange(order.getPtPinloopNm()));
		//脇ポケット
		form.getField("Pt_side_pkt_data").setData(stringChange(order.getPtSidePktNm()));
		//忍びポケット
		form.getField("Pt_shinobi_pkt_data").setData(stringChange(order.getPtShinobiPktNm()));
		//コインポケット
		form.getField("Pt_coin_pkt_cd_data").setData(stringChange(order.getPtCoinPktNm()));
		//フラップ付コインポケット
		form.getField("Pt_flapcoin_pkt_data").setData(stringChange(order.getPtFlapcoinPktNm()));
		//上前ピスポケット
		form.getField("Pt_left_pis_pkt_data").setData(stringChange(order.getPtLeftPisPktNm()));
		//下前ピスポケット
		form.getField("Pt_right_pis_pkt_data").setData(stringChange(order.getPtRightPisPktNm()));
		//Vカット
		form.getField("Pt_v_cut_data").setData(stringChange(order.getPtVCutNm()));
		//裾上げ
		form.getField("Pt_hem_up_data").setData(stringChange(order.getPtHemUpNm()));
		//ダブル幅
		form.getField("Pt_dbl_width_data").setData(stringChange(order.getPtDblWidthNm()));
		//ステッチ種類
		form.getField("Pt_stitch_type_data").setData(stringChange(order.getPtAmfStitchNm()));
		//ステッチ箇所変更
		if("0002001".equals(stringChange(order.getPtStitchPlcType()))) {
			form.getField("Pt_stitch_plc_data").setData("无");
		}else if("0002002".equals(stringChange(order.getPtStitchPlcType()))){
			form.getField("Pt_stitch_plc_data").setData("有");
		}
		//ダブルステッチ
		if("0002201".equals(stringChange(order.getPtDblstitchPlcType()))) {
			form.getField("Pt_dblstitch_plc_data").setData("无");
		}else if("0002202".equals(stringChange(order.getPtDblstitchPlcType()))){
			form.getField("Pt_dblstitch_plc_data").setData("有");
		}
		//AMF色指定
		if("0002401".equals(stringChange(order.getPtAmfColorType()))) {
			form.getField("Pt_amf_color_data").setData("无");
		}else if("0002402".equals(stringChange(order.getPtAmfColorType()))){
			form.getField("Pt_amf_color_data").setData("有");
		}
		//ボタンホール色指定
		if("0002701".equals(stringChange(order.getPtBtnholeColorType()))) {
			form.getField("Pt_btnhole_color_data").setData("无");
		}else if("0002702".equals(stringChange(order.getPtBtnholeColorType()))){
			form.getField("Pt_btnhole_color_data").setData("有");
		}
		//ボタン付け糸指定
		if("0003001".equals(stringChange(order.getPtBtnthreadColorType()))) {
			form.getField("Pt_btnthread_color_data").setData("无");
		}else if("0003002".equals(stringChange(order.getPtBtnthreadColorType()))){
			form.getField("Pt_btnthread_color_data").setData("有");
		}
		//釦素材
		form.getField("Pt_btn_material_data").setData(stringChange(order.getPtBtnMaterialNm()));
		//サスペンダー釦
		form.getField("Pt_suspender_btn_data").setData(stringChange(order.getPtSuspenderBtnNm()));
		//エイト（滑り止め）
		form.getField("Pt_non_slip_data").setData(stringChange(order.getPtNonSlipNm()));
		//シック（股補強）
		form.getField("Pt_chic_slip_data").setData(stringChange(order.getPtChicSlipNm()));
		//形状記憶
		form.getField("Pt_shape_memory_data").setData(stringChange(order.getPtShapeMemoryNm()));
		//側章
		form.getField("Pt_side_stripe_data").setData(stringChange(order.getPtSideStripeNm()));
		//側章幅
		form.getField("Pt_side_stripe_width_data").setData(stringChange(order.getPtSideStripeWidthNm()));
		
		//PANTS
		//PANTSモデル
		form.getField("Pt_model_data2").setData(stringChange(order.getPt2ModelNm()));
		//タック
		form.getField("Pt_tack_data2").setData(stringChange(order.getPt2TackNm()));
		//膝裏
		form.getField("Pt_kneeinner_type_data2").setData(stringChange(order.getPt2KneeinnerTypeNm()));
		//膝裏素材
		form.getField("Pt_kneeinner_cloth_data2").setData(stringChange(order.getPt2KneeinnerClothNm()));
		//フロント仕様
		form.getField("Pt_frt_type_data2").setData(stringChange(order.getPt2FrtTypeNm()));
		//パンチェリーナ
		form.getField("Pt_pancherina_data2").setData(stringChange(order.getPt2PancherinaNm()));
		//アジャスター仕様
		form.getField("Pt_adjuster_data2").setData(stringChange(order.getPt2AdjusterNm()));
		//ベルトループ
		if("0000702".equals(stringChange(order.getPt2BeltloopType()))) {
			form.getField("Pt_beltloop_data2").setData("无");
		}else if("0000701".equals(stringChange(order.getPt2BeltloopType()))){
			form.getField("Pt_beltloop_data2").setData("有");
		}
		//ピンループ
		form.getField("Pt_pinloop_data2").setData(stringChange(order.getPt2PinloopNm()));
		//脇ポケット
		form.getField("Pt_side_pkt_data2").setData(stringChange(order.getPt2SidePktNm()));
		//忍びポケット
		form.getField("Pt_shinobi_pkt_data2").setData(stringChange(order.getPt2ShinobiPktNm()));
		//コインポケット
		form.getField("Pt_coin_pkt_cd_data2").setData(stringChange(order.getPt2CoinPktNm()));
		//フラップ付コインポケット
		form.getField("Pt_flapcoin_pkt_data2").setData(stringChange(order.getPt2FlapcoinPktNm()));
		//上前ピスポケット
		form.getField("Pt_left_pis_pkt_data2").setData(stringChange(order.getPt2LeftPisPktNm()));
		//下前ピスポケット
		form.getField("Pt_right_pis_pkt_data2").setData(stringChange(order.getPt2RightPisPktNm()));
		//Vカット
		form.getField("Pt_v_cut_data2").setData(stringChange(order.getPt2VCutNm()));
		//裾上げ
		form.getField("Pt_hem_up_data2").setData(stringChange(order.getPt2HemUpNm()));
		//ダブル幅
		form.getField("Pt_dbl_width_data2").setData(stringChange(order.getPt2DblWidthNm()));
		//ステッチ種類
		form.getField("Pt_stitch_type_data2").setData(stringChange(order.getPt2AmfStitchNm()));
		//ステッチ箇所変更
		if("0002001".equals(stringChange(order.getPt2StitchPlcType()))) {
			form.getField("Pt_stitch_plc_data2").setData("无");
		}else if("0002002".equals(stringChange(order.getPt2StitchPlcType()))){
			form.getField("Pt_stitch_plc_data2").setData("有");
		}
		//ダブルステッチ
		if("0002201".equals(stringChange(order.getPt2DblstitchPlcType()))) {
			form.getField("Pt_dblstitch_plc_data2").setData("无");
		}else if("0002202".equals(stringChange(order.getPt2DblstitchPlcType()))){
			form.getField("Pt_dblstitch_plc_data2").setData("有");
		}
		//AMF色指定
		if("0002401".equals(stringChange(order.getPt2AmfColorType()))) {
			form.getField("Pt_amf_color_data2").setData("无");
		}else if("0002402".equals(stringChange(order.getPt2AmfColorType()))){
			form.getField("Pt_amf_color_data2").setData("有");
		}
		//ボタンホール色指定
		if("0002701".equals(stringChange(order.getPt2BtnholeColorType()))) {
			form.getField("Pt_btnhole_color_data2").setData("无");
		}else if("0002702".equals(stringChange(order.getPt2BtnholeColorType()))){
			form.getField("Pt_btnhole_color_data2").setData("有");
		}
		//ボタン付け糸指定
		if("0003001".equals(stringChange(order.getPt2BtnthreadColorType()))) {
			form.getField("Pt_btnthread_color_data2").setData("无");
		}else if("0003002".equals(stringChange(order.getPt2BtnthreadColorType()))){
			form.getField("Pt_btnthread_color_data2").setData("有");
		}
		//釦素材
		form.getField("Pt_btn_material_data2").setData(stringChange(order.getPt2BtnMaterialNm()));
		//サスペンダー釦
		form.getField("Pt_suspender_btn_data2").setData(stringChange(order.getPt2SuspenderBtnNm()));
		//エイト（滑り止め）
		form.getField("Pt_non_slip_data2").setData(stringChange(order.getPt2NonSlipNm()));
		//シック（股補強）
		form.getField("Pt_chic_slip_data2").setData(stringChange(order.getPt2ChicSlipNm()));
		//形状記憶
		form.getField("Pt_shape_memory_data2").setData(stringChange(order.getPt2ShapeMemoryNm()));
		//側章
		form.getField("Pt_side_stripe_data2").setData(stringChange(order.getPt2SideStripeNm()));
		//側章幅
		form.getField("Pt_side_stripe_width_data2").setData(stringChange(order.getPt2SideStripeWidthNm()));
		
		//GILET
		//GILETモデル
		form.getField("Gl_model_data").setData(stringChange(order.getGlModelNm()));
		//胸ポケット
		form.getField("Gl_breast_pkt_data").setData(stringChange(order.getGlBreastPktNm()));
		//腰ポケット
		form.getField("Gl_waist_pkt_data").setData(stringChange(order.getGlWaistPktNm()));
		//腰ポケット形状
		form.getField("Gl_waist_pkt_shape_data").setData(stringChange(order.getGlWaistPktShapeNm()));
		//腰ポケット素材
		form.getField("Gl_waist_pkt_cloth_data").setData(stringChange(order.getGlWaistPktClothNm()));
		//ステッチ種類
		form.getField("Gl_stitch_type_data").setData(stringChange(order.getGlAmfStitchNm()));
		//ステッチ箇所変更
		if("0000601".equals(stringChange(order.getGlStitchPlcType()))) {
			form.getField("Gl_stitch_plc_data").setData("无");
		}else if("0000602".equals(stringChange(order.getGlStitchPlcType()))){
			form.getField("Gl_stitch_plc_data").setData("有");
		}
		//ダブルステッチ変更
		if("0002601".equals(stringChange(order.getGlDblstitchPlcType()))) {
			form.getField("Gl_dblstitch_plc_data").setData("无");
		}else if("0002602".equals(stringChange(order.getGlDblstitchPlcType()))){
			form.getField("Gl_dblstitch_plc_data").setData("有");
		}
		//AMF色指定
		if("0000801".equals(stringChange(order.getGlAmfColorType()))) {
			form.getField("Gl_amf_color_data").setData("无");
		}else if("0000802".equals(stringChange(order.getGlAmfColorType()))){
			form.getField("Gl_amf_color_data").setData("有");
		}
		//ボタンホール色指定
		if("0001101".equals(stringChange(order.getGlBtnholeColorType()))) {
			form.getField("Gl_btnhole_color_data").setData("无");
		}else if("0001102".equals(stringChange(order.getGlBtnholeColorType()))){
			form.getField("Gl_btnhole_color_data").setData("有");
		}
		//ボタン付け糸指定
		if("0001401".equals(stringChange(order.getGlBtnthreadColorType()))) {
			form.getField("Gl_btnthread_color_data").setData("无");
		}else if("0001402".equals(stringChange(order.getGlBtnthreadColorType()))){
			form.getField("Gl_btnthread_color_data").setData("有");
		}
		//背裏地素材
		form.getField("Gl_back_cloth_data").setData(stringChange(order.getGlBackClothNm()));
		//内側裏地素材
		form.getField("Gl_innner_cloth_data").setData(stringChange(order.getGlInnnerClothNm()));
		//釦素材
		form.getField("Gl_btn_material_data").setData(stringChange(order.getGlFrtBtnNm()));
		//バックベルト
		form.getField("Gl_back_belt_data").setData(stringChange(order.getGlBackBeltNm()));
		//ウォッチチェーン
		form.getField("Gl_watch_chain_data").setData(stringChange(order.getGlWatchChainNm()));		
	}
	
	private void insertCoatDataCo(CrForm form, Order order) {
		//残布
		form.getField("product_remaining_cloth_data").setData(stringChange(order.getProductRemainingClothNm()));
		
		//COAT
		//サイズ
		form.getField("Cor_ct_size_data").setData(stringChange(order.getCorCtSize()));
		
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
		form.getField("Ct_model_data").setData(stringChange(order.getCtModelNm()));
		//ラペルデザイン
		form.getField("Ct_lapel_design_data").setData(stringChange(order.getCtLapelDesignNm()));
		//袖仕様
		form.getField("Ct_sleeve_type_data").setData(stringChange(order.getCtSleeveTypeNm()));
		//腰ポケット
		form.getField("Ct_waist_pkt_data").setData(stringChange(order.getCtWaistPktNm()));
		//チェンジポケット
		form.getField("Ct_chg_pkt_data").setData(stringChange(order.getCtChgPktNm()));
		//スランテッドポケット
		form.getField("Ct_slanted_pkt_data").setData(stringChange(order.getCtSlantedPktNm()));
		//ベント
		form.getField("Ct_vent_data").setData(stringChange(order.getCtVentNm()));
		//フロント釦数
		form.getField("Ct_frt_btn_data").setData(stringChange(order.getCtFrtBtnNm()));
		//袖口
		form.getField("Ct_cuff_data").setData(stringChange(order.getCtCuffNm()));
		//袖釦
		form.getField("Ct_sleeve_btn_data").setData(stringChange(order.getCtSleeveBtnNm()));
		//バックベルト
		form.getField("Ct_back_belt_data").setData(stringChange(order.getCtBackBeltNm()));
		//襟吊
		form.getField("Ct_collar_hang_data").setData(stringChange(order.getCtCollarHangNm()));
		//胴裏地
		form.getField("Ct_inner_body_cloth_data").setData(stringChange(order.getCtInnerBodyClothNm()));
		//袖裏地
		form.getField("Ct_inner_sleeve_cloth_data").setData(stringChange(order.getCtInnerSleeveClothNm()));
		//釦素材
		form.getField("Ct_btn_material_data").setData(stringChange(order.getCtBtnMaterialNm()));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private void insertShirtDataCo(CrForm form, Order order) {
		//刺繍箇所
		form.getField("product_embroidery_nm_pos_data").setData(stringChange(order.getProductEmbroideryNmPos()));
		//刺繍サイズ:縦+横
		String productEmbroiderySize = "";
		if(!("".equals(bigDecimalChange(order.getProductEmbroideryLength())))) {
			productEmbroiderySize = "縦：" + bigDecimalChange(order.getProductEmbroideryLength());
		}
		if(!("".equals(bigDecimalChange(order.getProductEmbroideryWidth()))) 
				&& !("".equals(productEmbroiderySize))) {
			productEmbroiderySize = productEmbroiderySize + "  横：" + bigDecimalChange(order.getProductEmbroideryWidth());
		}else if(!("".equals(bigDecimalChange(order.getProductEmbroideryWidth())))) {
			productEmbroiderySize = "横：" + bigDecimalChange(order.getProductEmbroideryWidth());
		}
		form.getField("product_embroidery_size_data").setData(productEmbroiderySize);
		//ガゼット刺繍
		form.getField("product_embroidery_gazette_data").setData(stringChange(order.getProductEmbroideryGazette()));
				
		//SHIRT
		//サイズ
		form.getField("Cor_st_size_data").setData(stringChange(order.getCorStSize()));
		
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
		//カフス周り右
		form.getField("Cor_st_rightcuffs_surrounding_size_data").setData(bigDecimalChange(order.getCorStRightcuffsSurroundingSize()));
		//カフス周り左
		form.getField("Cor_st_leftcuffs_surrounding_size_data").setData(bigDecimalChange(order.getCorStLeftcuffsSurroundingSize()));
		//背ダーツ出し
		form.getField("Cor_st_backdarts_unpack_size_data").setData(stringChange(order.getCorStBackdartsUnpackNm()));
			
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
		//カフス周り右
		form.getField("Cor_st_rightcuffs_surrounding_correct_data").setData(bigDecimalChange(order.getCorStRightcuffsSurroundingCorrect()));
		//カフス周り左
		form.getField("Cor_st_leftcuffs_surrounding_correct_data").setData(bigDecimalChange(order.getCorStLeftcuffsSurroundingCorrect()));
		//背ダーツ出し
//		form.getField("Cor_st_backdarts_unpack_correct_data").setData(bigDecimalChange(order.getCorStBackdartsUnpackCorrect()));
		
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
		//カフス周り右
		form.getField("Cor_st_rightcuffs_surrounding_gross_data").setData(bigDecimalChange(order.getCorStRightcuffsSurroundingGross()));
		//カフス周り左
		form.getField("Cor_st_leftcuffs_surrounding_gross_data").setData(bigDecimalChange(order.getCorStLeftcuffsSurroundingGross()));
		//背ダーツ出し
//		form.getField("Cor_st_backdarts_unpack_gross_data").setData(bigDecimalChange(order.getCorStBackdartsUnpackGross()));
		
		//SHIRT
		//SHIRTモデル
		form.getField("St_model_data").setData(stringChange(order.getStModelNm()));
		//襟型
		form.getField("St_collar_type_data").setData(stringChange(order.getStCollarTypeNm()));
		//カフス
		form.getField("St_cuffs_data").setData(stringChange(order.getStCuffsNm()));
		//コンバーチブル
		form.getField("St_convertible_data").setData(stringChange(order.getStConvertibleNm()));
		//アジャスト釦
		form.getField("St_adjuster_btn_data").setData(stringChange(order.getStAdjusterBtnNm()));
		//クレリック仕様
		form.getField("St_cleric_data").setData(stringChange(order.getStClericNm()));
		//ダブルカフス仕様
		form.getField("St_dbl_cuffs_data").setData(stringChange(order.getStDblCuffsNm()));
		//カフスボタン追加
		form.getField("St_cuffs_btn_data").setData(stringChange(order.getStCuffsBtnNm()));
		//釦
		form.getField("St_btn_material_data").setData(stringChange(order.getStBtnMaterialNm()));
		//タブ釦
		form.getField("St_dbl_btn_data").setData(stringChange(order.getStDblBtnNm()));
		//ガントレットボタン位置
		form.getField("St_gauntlet_btn_pos_data").setData(stringChange(order.getStGauntletBtnPosNm()));
		//ピンホールピン
		form.getField("St_pinhole_pin_data").setData(stringChange(order.getStPinholePinNm()));
		//胸ポケット
		form.getField("St_breast_pkt_data").setData(stringChange(order.getStBreastPktNm()));
		//胸ポケット大きさ
		form.getField("St_breast_size_data").setData(stringChange(order.getStBreastSizeNm()));
		//フロントデザイン
		form.getField("St_frt_design_data").setData(stringChange(order.getStFrtDesignNm()));
		//ピンタックブザム
		form.getField("St_pintuck_bosom_data").setData(stringChange(order.getStPintuckBosomNm()));
		//ステッチ
		form.getField("St_stitch_data").setData(stringChange(order.getStStitchNm()));
		//カラーキーパー
		form.getField("St_colar_keeper_data").setData(stringChange(order.getStColarKeeperNm()));
		//ボタンホール色変更
		form.getField("St_btnhole_color_cd_data").setData(stringChange(order.getStBtnholeColorNm()));
		//ボタン付け糸色変更
		form.getField("St_btnthread_color_data").setData(stringChange(order.getStBtnthreadColorNm()));
		//カジュアルヘムライン仕様
		if("有り".equals(order.getStCasualHemlineNm())) {
			form.getField("St_casual_hemline_data").setData(stringChange(order.getStCasualHemlineNm()) 
					+ "  " + bigDecimalChange(order.getStCasualHemlineSize()) + "cm");
		}else if("無し".equals(order.getStCasualHemlineNm())) {
			form.getField("St_casual_hemline_data").setData(stringChange(order.getStCasualHemlineNm()));
		}
		//ボタン位置変更
		form.getField("St_btnpos_chg_data").setData(stringChange(order.getStBtnposChgNm()));
		//ボタン位置変更,詳細
		String stNeckbandBtnPosChg = "";
		if(!("".equals(order.getStNeckbandBtnPosChg()) || order.getStNeckbandBtnPosChg() == null)) {
			stNeckbandBtnPosChg = "【台襟釦】"+order.getStNeckbandBtnPosChg();
		}
		if(!("".equals(order.getStFrtfirstBtnPosChg()) || order.getStFrtfirstBtnPosChg() == null) 
				&& !("".equals(stNeckbandBtnPosChg))) {
			stNeckbandBtnPosChg = stNeckbandBtnPosChg + "  【フロント第1釦】"+order.getStFrtfirstBtnPosChg();
		}else if(!("".equals(order.getStFrtfirstBtnPosChg()) || order.getStFrtfirstBtnPosChg() == null)) {
			stNeckbandBtnPosChg = "【フロント第1釦】"+order.getStFrtfirstBtnPosChg();
		}
		if(!("".equals(order.getStFrtsecondBtnPosChg()) || order.getStFrtsecondBtnPosChg() == null) 
				&& !("".equals(stNeckbandBtnPosChg))) {
			stNeckbandBtnPosChg = stNeckbandBtnPosChg + "  【フロント第2釦】"+order.getStFrtsecondBtnPosChg();
		}else if(!("".equals(order.getStFrtsecondBtnPosChg()) || order.getStFrtsecondBtnPosChg() == null)) {
			stNeckbandBtnPosChg = "【フロント第2釦】"+order.getStFrtsecondBtnPosChg();
		}
		form.getField("St_btnpos_chg_syousai").setData(stringChange(stNeckbandBtnPosChg));
		
	}

	@SuppressWarnings("unlikely-arg-type")
	private void insertShirtDataCoChinese(CrForm form, Order order) {
		//刺繍箇所
		form.getField("product_embroidery_nm_pos_data").setData(stringChange(order.getProductEmbroideryNmPos()));
		//刺繍サイズ:縦+横
		String productEmbroiderySize = "";
		if(!("".equals(bigDecimalChange(order.getProductEmbroideryLength())))) {
			productEmbroiderySize = "縦：" + bigDecimalChange(order.getProductEmbroideryLength());
		}
		if(!("".equals(bigDecimalChange(order.getProductEmbroideryWidth()))) 
				&& !("".equals(productEmbroiderySize))) {
			productEmbroiderySize = productEmbroiderySize + "  横：" + bigDecimalChange(order.getProductEmbroideryWidth());
		}else if(!("".equals(bigDecimalChange(order.getProductEmbroideryWidth())))) {
			productEmbroiderySize = "横：" + bigDecimalChange(order.getProductEmbroideryWidth());
		}
		form.getField("product_embroidery_size_data").setData(productEmbroiderySize);
		//ガゼット刺繍
		form.getField("product_embroidery_gazette_data").setData(stringChange(order.getProductEmbroideryGazette()));
				
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
		//カフス周り右
		form.getField("Cor_st_rightcuffs_surrounding_size_data").setData(bigDecimalChange(order.getCorStRightcuffsSurroundingSize()));
		//カフス周り左
		form.getField("Cor_st_leftcuffs_surrounding_size_data").setData(bigDecimalChange(order.getCorStLeftcuffsSurroundingSize()));
		//背ダーツ出し
		form.getField("Cor_st_backdarts_unpack_size_data").setData(stringChange(order.getCorStBackdartsUnpackNm()));
			
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
		//カフス周り右
		form.getField("Cor_st_rightcuffs_surrounding_correct_data").setData(bigDecimalChange(order.getCorStRightcuffsSurroundingCorrect()));
		//カフス周り左
		form.getField("Cor_st_leftcuffs_surrounding_correct_data").setData(bigDecimalChange(order.getCorStLeftcuffsSurroundingCorrect()));
		//背ダーツ出し
//		form.getField("Cor_st_backdarts_unpack_correct_data").setData(bigDecimalChange(order.getCorStBackdartsUnpackCorrect()));
		
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
		//カフス周り右
		form.getField("Cor_st_rightcuffs_surrounding_gross_data").setData(bigDecimalChange(order.getCorStRightcuffsSurroundingGross()));
		//カフス周り左
		form.getField("Cor_st_leftcuffs_surrounding_gross_data").setData(bigDecimalChange(order.getCorStLeftcuffsSurroundingGross()));
		//背ダーツ出し
//		form.getField("Cor_st_backdarts_unpack_gross_data").setData(bigDecimalChange(order.getCorStBackdartsUnpackGross()));
		
		//SHIRT
		//SHIRTモデル
		if("スリム（BS27）darts".equals(order.getStModelNm())) {
			form.getField("St_model_data").setData("PO-LBW27-141");
		}else if ("スリム（BS27）pleats".equals(order.getStModelNm())) {
			form.getField("St_model_data").setData("PO-LBW27-SIDE-141");
		}else if ("スリム（BS27）box".equals(order.getStModelNm())) {
			form.getField("St_model_data").setData("PO-LBW27-BOX-141");
		}else if ("スタンダード（BS35）darts".equals(order.getStModelNm())) {
			form.getField("St_model_data").setData("PO-LAT-64");
		}else if ("スタンダード（BS35）pleats".equals(order.getStModelNm())) {
			form.getField("St_model_data").setData("PO-LAT-SIDE-64");
		}else if ("スタンダード（BS35）box".equals(order.getStModelNm())) {
			form.getField("St_model_data").setData("PO-LAT-BOX-64");
		}else if ("スーパースリム（BS23）darts".equals(order.getStModelNm())) {
			form.getField("St_model_data").setData("PO-LBW23-39");
		}

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
		if("无".equals(order.getStPintuckBosomNm())) {
			form.getField("St_pintuck_bosom_data").setData(order.getStPintuckBosomNm());
		}else {
			form.getField("St_pintuck_bosom_data").setData("有");
		}
		//ステッチ
		form.getField("St_stitch_data").setData(order.getStStitchNm());
		//カラーキーパー
		form.getField("St_colar_keeper_data").setData(order.getStColarKeeperNm());
		//ボタンホール色変更
		form.getField("St_btnhole_color_cd_data").setData(order.getStBtnholeColorNm());
		//ボタン付け糸色変更
		form.getField("St_btnthread_color_data").setData(order.getStBtnthreadColorNm());
		//カジュアルヘムライン仕様
		if("有".equals(order.getStCasualHemlineNm())) {
			form.getField("St_casual_hemline_data").setData(order.getStCasualHemlineNm() 
					+ "  " + order.getStCasualHemlineSize() + "cm");
		}else if("无".equals(order.getStCasualHemlineNm())) {
			form.getField("St_casual_hemline_data").setData(order.getStCasualHemlineNm());
		}
		//ボタン位置変更
		form.getField("St_btnpos_chg_data").setData(order.getStBtnposChgNm());
		//ボタン位置変更,詳細
		String stNeckbandBtnPosChg = "";
		if(!("".equals(order.getStNeckbandBtnPosChg()) || order.getStNeckbandBtnPosChg() == null)) {
			stNeckbandBtnPosChg = "【台領釦】"+order.getStNeckbandBtnPosChg();
		}
		if(!("".equals(order.getStFrtfirstBtnPosChg()) || order.getStFrtfirstBtnPosChg() == null) 
				&& !("".equals(stNeckbandBtnPosChg))) {
			stNeckbandBtnPosChg = stNeckbandBtnPosChg + "  【前牌第1釦】"+order.getStFrtfirstBtnPosChg();
		}else if(!("".equals(order.getStFrtfirstBtnPosChg()) || order.getStFrtfirstBtnPosChg() == null)) {
			stNeckbandBtnPosChg = "【前牌第1釦】"+order.getStFrtfirstBtnPosChg();
		}
		if(!("".equals(order.getStFrtsecondBtnPosChg()) || order.getStFrtsecondBtnPosChg() == null) 
				&& !("".equals(stNeckbandBtnPosChg))) {
			stNeckbandBtnPosChg = stNeckbandBtnPosChg + "  【前牌第2釦】"+order.getStFrtsecondBtnPosChg();
		}else if(!("".equals(order.getStFrtsecondBtnPosChg()) || order.getStFrtsecondBtnPosChg() == null)) {
			stNeckbandBtnPosChg = "【前牌第2釦】"+order.getStFrtsecondBtnPosChg();
		}
		form.getField("St_btnpos_chg_syousai").setData(stringChange(stNeckbandBtnPosChg));
		
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
	 * 変換short型
	 * @param 
	 * @return 
	 */
	private String shortChange(short shortNum) {
		if(shortNum != 0){
			//空ではない
			return String.valueOf(shortNum);
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
	 * 色名を変換する
	 * @return
	 */
	private String convertTheColorName(String colorName) {
		if("402（黒）".equals(colorName)) {
			return "bk";
		}else if("760（ネイビー）".equals(colorName)) {
			return "nv";
		}else if("145（水色）".equals(colorName)) {
			return "lu";
		}else if("75（ブルー）".equals(colorName)) {
			return "bl";
		}else if("9（赤）".equals(colorName)) {
			return "re";
		}else if("56（グリーン）".equals(colorName)) {
			return "gr";
		}else if("89（ライトブラウン）".equals(colorName)) {
			return "lb";
		}else if("94（ブラウン）".equals(colorName)) {
			return "br";
		}else if("152（ボルドー）".equals(colorName)) {
			return "bd";
		}else if("169（パープル）".equals(colorName)) {
			return "pp";
		}else if("343（ベージュ）".equals(colorName)) {
			return "bg";
		}else if("701（モカ）".equals(colorName)) {
			return "mc";
		}else if("403（白）".equals(colorName)) {
			return "wt";
		}else if("110（金茶）".equals(colorName)) {
			return "lj";
		}
		return colorName;
	}
	
	/**
	 * 名前の省略形を設定します
	 * @return
	 */
	private String convertTheProjectName(String projectName) {
		if("フラワーホール上前1".equals(projectName)) {
			return "フ上1";
		}else if("フラワーホール上前2".equals(projectName)) {
			return "フ上2";
		}else if("フラワーホール下前1".equals(projectName)) {
			return "フ下1";
		}else if("フラワーホール下前2".equals(projectName)) {
			return "フ下2";
		}else if("フロント1".equals(projectName)) {
			return "フト1";
		}else if("フロント2".equals(projectName)) {
			return "フト2";
		}else if("フロント3".equals(projectName)) {
			return "フト3";
		}else if("上前袖口1".equals(projectName)) {
			return "上袖1";
		}else if("上前袖口2".equals(projectName)) {
			return "上袖2";
		}else if("上前袖口3".equals(projectName)) {
			return "上袖3";
		}else if("上前袖口4".equals(projectName)) {
			return "上袖4";
		}else if("上前袖口5".equals(projectName)) {
			return "上袖5";
		}else if("下前袖口1".equals(projectName)) {
			return "下袖1";
		}else if("下前袖口2".equals(projectName)) {
			return "下袖2";
		}else if("下前袖口3".equals(projectName)) {
			return "下袖3";
		}else if("下前袖口4".equals(projectName)) {
			return "下袖4";
		}else if("下前袖口5".equals(projectName)) {
			return "下袖5";
		}
		else if("フロント下前1".equals(projectName)) {
			return "フト下1";
		}else if("フロント下前2".equals(projectName)) {
			return "フト下2";
		}else if("フロント下前3".equals(projectName)) {
			return "フト下3";
		}else if("フロント下前4".equals(projectName)) {
			return "フト下4";
		}else if("フロント下前5".equals(projectName)) {
			return "フト下5";
		}else if("フロント下前6".equals(projectName)) {
			return "フト下6";
		}else if("フロント上前1".equals(projectName)) {
			return "フト上1";
		}else if("フロント上前2".equals(projectName)) {
			return "フト上2";
		}else if("フロント上前3".equals(projectName)) {
			return "フト上3";
		}else if("フロント上前4".equals(projectName)) {
			return "フト上4";
		}
		return projectName;
	}
	
	/**
	 * 名前の省略形を設定します
	 * @return
	 */
	private String convertTheProjectNameChinese(String projectName) {
		if("フラワーホール上前1".equals(projectName)) {
			return "左看眼1";
		}else if("フラワーホール上前2".equals(projectName)) {
			return "左看眼2";
		}else if("フラワーホール下前1".equals(projectName)) {
			return "右看眼1";
		}else if("フラワーホール下前2".equals(projectName)) {
			return "右看眼2";
		}else if("フロント1".equals(projectName)) {
			return "前扣1";
		}else if("フロント2".equals(projectName)) {
			return "前扣2";
		}else if("フロント3".equals(projectName)) {
			return "前扣3";
		}else if("上前袖口1".equals(projectName)) {
			return "左袖1";
		}else if("上前袖口2".equals(projectName)) {
			return "左袖2";
		}else if("上前袖口3".equals(projectName)) {
			return "左袖3";
		}else if("上前袖口4".equals(projectName)) {
			return "左袖4";
		}else if("上前袖口5".equals(projectName)) {
			return "左袖5";
		}else if("下前袖口1".equals(projectName)) {
			return "右袖1";
		}else if("下前袖口2".equals(projectName)) {
			return "右袖2";
		}else if("下前袖口3".equals(projectName)) {
			return "右袖3";
		}else if("下前袖口4".equals(projectName)) {
			return "右袖4";
		}else if("下前袖口5".equals(projectName)) {
			return "右袖5";
		}
		else if("フロント下前1".equals(projectName)) {
			return "右前扣1";
		}else if("フロント下前2".equals(projectName)) {
			return "右前扣2";
		}else if("フロント下前3".equals(projectName)) {
			return "右前扣3";
		}else if("フロント下前4".equals(projectName)) {
			return "右前扣4";
		}else if("フロント下前5".equals(projectName)) {
			return "右前扣5";
		}else if("フロント下前6".equals(projectName)) {
			return "右前扣6";
		}else if("フロント上前1".equals(projectName)) {
			return "左前扣1";
		}else if("フロント上前2".equals(projectName)) {
			return "左前扣2";
		}else if("フロント上前3".equals(projectName)) {
			return "左前扣3";
		}else if("フロント上前4".equals(projectName)) {
			return "左前扣4";
		}
		return projectName;
	}
	
	/**
	 * JACKET詳細情報,PDFで印刷
	 * @return
	 */
	private void insertJacketdetailedFieldDataCo(CrForm form, Order order) {
		StringBuffer sbJacketTitle = new StringBuffer();
		StringBuffer sbJacket = new StringBuffer();
		sbJacketTitle.append("JACKET\r\n");
		sbJacket.append("（フ：フラワーホール\tフト：フロント）\r\n");
		
		//内ポケット
		String strJacketInnerPktNm = stringChange(order.getJkInnerPktNm());
		if(!("".equals(strJacketInnerPktNm))) {
			sbJacketTitle.append("\t内ポケット\r\n");
			String[] dataJacketInnerPktNm = strJacketInnerPktNm.split("/");
			for(int i = 0; i < dataJacketInnerPktNm.length; i++) {
				if(i == dataJacketInnerPktNm.length-1) {
					sbJacket.append(dataJacketInnerPktNm[i]).append("\r\n");
				}else {
					sbJacket.append(dataJacketInnerPktNm[i]).append("  ");
				}
			}
		}else {
			sbJacketTitle.append("\r\n");
			sbJacket.append("\r\n");
			logger.info("JACKETの内ポケットは空です");
		}
		
		//ステッチ箇所変更
		String strJacketStitchPlcNm = stringChange(order.getJkStitchPlcNm());
		if(!("".equals(strJacketStitchPlcNm))) {
			sbJacketTitle.append("\tステッチ箇所変更\r\n");
			String[] dataJacketStitchPlcNm = strJacketStitchPlcNm.split("/");
			for(int i = 0; i < dataJacketStitchPlcNm.length; i++) {
				if(i == dataJacketStitchPlcNm.length-1) {
					sbJacket.append(dataJacketStitchPlcNm[i]).append("\r\n");
				}else {
					sbJacket.append(dataJacketStitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbJacketTitle.append("\r\n");
			sbJacket.append("\r\n");
			logger.info("JACKETのステッチ箇所変更は空です");
		}
		
		//ダブルステッチ変更
		String strJacketDblstitchPlcNm = stringChange(order.getJkDblstitchPlcNm());
		if(!("".equals(strJacketDblstitchPlcNm))) {
			sbJacketTitle.append("\tダブルステッチ変更\r\n");
		String[] dataJacketDblstitchPlcNm = strJacketDblstitchPlcNm.split("/");
			for(int i = 0; i < dataJacketDblstitchPlcNm.length; i++) {
				if(i == dataJacketDblstitchPlcNm.length-1) {
					sbJacket.append(dataJacketDblstitchPlcNm[i]).append("\r\n");
				}else {
					sbJacket.append(dataJacketDblstitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbJacketTitle.append("\r\n");
			sbJacket.append("\r\n");
			logger.info("JACKETのダブルステッチ変更は空です");
		}
		
		//AMF色指定
		String strJacketAmfColorNm = stringChange(order.getJkAmfColorNm());
		String strJacketAmfColorPlcNm = stringChange(order.getJkAmfColorPlcNm());
		if(!("".equals(strJacketAmfColorNm)) && !("".equals(strJacketAmfColorPlcNm))) {
			String[] dataJacketAmfColorNm = strJacketAmfColorNm.split("/");
			String[] dataJacketAmfColorPlcNm = strJacketAmfColorPlcNm.split("/");
			if(dataJacketAmfColorNm.length-1 == dataJacketAmfColorPlcNm.length-1) {
				sbJacketTitle.append("\tAMF色指定\r\n");
				for(int i = 0; i < dataJacketAmfColorNm.length; i++) {
					if(i == dataJacketAmfColorNm.length-1) {
						sbJacket.append(dataJacketAmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataJacketAmfColorNm[i])).append("\r\n");
					}else {
						sbJacket.append(dataJacketAmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataJacketAmfColorNm[i])).append("  ");
					}
				}
			}else {
				sbJacketTitle.append("\r\n");
				sbJacket.append("\r\n");
				logger.info("JACKETAMF色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbJacketTitle.append("\r\n");
			sbJacket.append("\r\n");
			logger.info("JACKETのAMF色指定は空です");
		}
		
		//ボタンホール色指定
		String strJacketBtnholeColorNm = stringChange(order.getJkBtnholeColorNm());
		String strJacketBtnholeColorPlcN = stringChange(order.getJkBtnholeColorPlcN());
		if(!("".equals(strJacketBtnholeColorNm)) && !("".equals(strJacketBtnholeColorPlcN))) {
			String[] dataJacketBtnholeColorNm = strJacketBtnholeColorNm.split("/");
			String[] dataJacketBtnholeColorPlcN = strJacketBtnholeColorPlcN.split("/");
			if(dataJacketBtnholeColorNm.length-1 == dataJacketBtnholeColorPlcN.length-1) {
				sbJacketTitle.append("\tボタンホール色指定\r\n");
				for(int i = 0; i < dataJacketBtnholeColorNm.length; i++) {
					if(i == dataJacketBtnholeColorNm.length-1) {
						sbJacket.append(convertTheProjectName(dataJacketBtnholeColorPlcN[i])).append("-").
						append(convertTheColorName(dataJacketBtnholeColorNm[i])).append("\r\n");
					}else {
						sbJacket.append(convertTheProjectName(dataJacketBtnholeColorPlcN[i])).append("-").
						append(convertTheColorName(dataJacketBtnholeColorNm[i])).append("  ");
					}
				}
			}else {
				sbJacketTitle.append("\r\n");
				sbJacket.append("\r\n");
				logger.info("JACKETボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbJacketTitle.append("\r\n");
			sbJacket.append("\r\n");
			logger.info("JACKETのAMF色指定は空です");
		}
		
		//ボタン付け糸指定
		String strJacketBtnthreadColorNm = stringChange(order.getJkBtnthreadColorNm());
		String strJacketBtnthreadColorPlcN = stringChange(order.getJkBtnthreadColorPlcN());
		if(!("".equals(strJacketBtnthreadColorNm)) && !("".equals(strJacketBtnthreadColorPlcN))) {
			String[] dataJacketBtnthreadColorNm = strJacketBtnthreadColorNm.split("/");
			String[] dataJacketBtnthreadColorPlcN = strJacketBtnthreadColorPlcN.split("/");
			if(dataJacketBtnthreadColorNm.length-1 == dataJacketBtnthreadColorPlcN.length-1) {
				sbJacketTitle.append("\tボタン付け糸指定\r\n");
				for(int i = 0; i < dataJacketBtnthreadColorNm.length; i++) {
					if(i == dataJacketBtnthreadColorNm.length-1) {
						sbJacket.append(convertTheProjectName(dataJacketBtnthreadColorPlcN[i])).append("-").
						append(convertTheColorName(dataJacketBtnthreadColorNm[i])).append("");
					}else {
						sbJacket.append(convertTheProjectName(dataJacketBtnthreadColorPlcN[i])).append("-").
						append(convertTheColorName(dataJacketBtnthreadColorNm[i])).append("  ");
					}
				}
			}else {
				sbJacketTitle.append("\r\n");
				sbJacket.append("\r\n");
				logger.info("JACKETボタン付け糸指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbJacketTitle.append("\r\n");
			sbJacket.append("\r\n");
			logger.info("JACKETのボタン付け糸指定は空です");
		}
		
		String detailedFieldJacketTitle = String.valueOf(sbJacketTitle);
		String detailedFieldJacket = String.valueOf(sbJacket);
		//JACKET詳細情報
		form.getField("Jk_detailed_field_title_data").setData(stringChange(detailedFieldJacketTitle));
		form.getField("Jk_detailed_field_data").setData(stringChange(detailedFieldJacket));
	}
	
	/**
	 * JACKET詳細情報,PDFで印刷(中国語)
	 * @return
	 */
	private void insertJacketdetailedFieldDataCoChinese(CrForm form, Order order) {
		StringBuffer sbJacketTitle = new StringBuffer();
		StringBuffer sbJacket = new StringBuffer();
		sbJacketTitle.append("JACKET\r\n");
		sbJacket.append("\r\n");
		
		//内ポケット
		String strJacketInnerPktNm = stringChange(order.getJkInnerPktNm());
		if(!("".equals(strJacketInnerPktNm))) {
			sbJacketTitle.append("\t内兜\r\n");
			String[] dataJacketInnerPktNm = strJacketInnerPktNm.split("/");
			for(int i = 0; i < dataJacketInnerPktNm.length; i++) {
				if(i == dataJacketInnerPktNm.length-1) {
					sbJacket.append(dataJacketInnerPktNm[i]).append("\r\n");
				}else {
					sbJacket.append(dataJacketInnerPktNm[i]).append("  ");
				}
			}
		}else {
			sbJacketTitle.append("\r\n");
			sbJacket.append("\r\n");
			logger.info("JACKETの内ポケットは空です");
		}
		
		//ステッチ箇所変更
		String strJacketStitchPlcNm = stringChange(order.getJkStitchPlcNm());
		if(!("".equals(strJacketStitchPlcNm))) {
			sbJacketTitle.append("\t明線位置変更\r\n");
			String[] dataJacketStitchPlcNm = strJacketStitchPlcNm.split("/");
			for(int i = 0; i < dataJacketStitchPlcNm.length; i++) {
				if(i == dataJacketStitchPlcNm.length-1) {
					sbJacket.append(dataJacketStitchPlcNm[i]).append("\r\n");
				}else {
					sbJacket.append(dataJacketStitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbJacketTitle.append("\r\n");
			sbJacket.append("\r\n");
			logger.info("JACKETのステッチ箇所変更は空です");
		}
		
		//ダブルステッチ変更
		String strJacketDblstitchPlcNm = stringChange(order.getJkDblstitchPlcNm());
		if(!("".equals(strJacketDblstitchPlcNm))) {
			sbJacketTitle.append("\t双明線変更\r\n");
		String[] dataJacketDblstitchPlcNm = strJacketDblstitchPlcNm.split("/");
			for(int i = 0; i < dataJacketDblstitchPlcNm.length; i++) {
				if(i == dataJacketDblstitchPlcNm.length-1) {
					sbJacket.append(dataJacketDblstitchPlcNm[i]).append("\r\n");
				}else {
					sbJacket.append(dataJacketDblstitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbJacketTitle.append("\r\n");
			sbJacket.append("\r\n");
			logger.info("JACKETのダブルステッチ変更は空です");
		}
		
		//AMF色指定
		String strJacketAmfColorNm = stringChange(order.getJkAmfColorNm());
		String strJacketAmfColorPlcNm = stringChange(order.getJkAmfColorPlcNm());
		if(!("".equals(strJacketAmfColorNm)) && !("".equals(strJacketAmfColorPlcNm))) {
			String[] dataJacketAmfColorNm = strJacketAmfColorNm.split("/");
			String[] dataJacketAmfColorPlcNm = strJacketAmfColorPlcNm.split("/");
			if(dataJacketAmfColorNm.length-1 == dataJacketAmfColorPlcNm.length-1) {
				sbJacketTitle.append("\tAMF\r\n");
				for(int i = 0; i < dataJacketAmfColorNm.length; i++) {
					if(i == dataJacketAmfColorNm.length-1) {
						sbJacket.append(dataJacketAmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataJacketAmfColorNm[i])).append("\r\n");
					}else {
						sbJacket.append(dataJacketAmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataJacketAmfColorNm[i])).append("  ");
					}
				}
			}else {
				sbJacketTitle.append("\r\n");
				sbJacket.append("\r\n");
				logger.info("JACKETAMF色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbJacketTitle.append("\r\n");
			sbJacket.append("\r\n");
			logger.info("JACKETのAMF色指定は空です");
		}
		
		//ボタンホール色指定
		String strJacketBtnholeColorNm = stringChange(order.getJkBtnholeColorNm());
		String strJacketBtnholeColorPlcN = stringChange(order.getJkBtnholeColorPlcN());
		if(!("".equals(strJacketBtnholeColorNm)) && !("".equals(strJacketBtnholeColorPlcN))) {
			String[] dataJacketBtnholeColorNm = strJacketBtnholeColorNm.split("/");
			String[] dataJacketBtnholeColorPlcN = strJacketBtnholeColorPlcN.split("/");
			if(dataJacketBtnholeColorNm.length-1 == dataJacketBtnholeColorPlcN.length-1) {
				sbJacketTitle.append("\t釦眼色指定\r\n");
				for(int i = 0; i < dataJacketBtnholeColorNm.length; i++) {
					if(i == dataJacketBtnholeColorNm.length-1) {
						sbJacket.append(convertTheProjectNameChinese(dataJacketBtnholeColorPlcN[i])).append("-").
						append(convertTheColorName(dataJacketBtnholeColorNm[i])).append("\r\n");
					}else {
						sbJacket.append(convertTheProjectNameChinese(dataJacketBtnholeColorPlcN[i])).append("-").
						append(convertTheColorName(dataJacketBtnholeColorNm[i])).append("  ");
					}
				}
			}else {
				sbJacketTitle.append("\r\n");
				sbJacket.append("\r\n");
				logger.info("JACKETボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbJacketTitle.append("\r\n");
			sbJacket.append("\r\n");
			logger.info("JACKETのAMF色指定は空です");
		}
		
		//ボタン付け糸指定
		String strJacketBtnthreadColorNm = stringChange(order.getJkBtnthreadColorNm());
		String strJacketBtnthreadColorPlcN = stringChange(order.getJkBtnthreadColorPlcN());
		if(!("".equals(strJacketBtnthreadColorNm)) && !("".equals(strJacketBtnthreadColorPlcN))) {
			String[] dataJacketBtnthreadColorNm = strJacketBtnthreadColorNm.split("/");
			String[] dataJacketBtnthreadColorPlcN = strJacketBtnthreadColorPlcN.split("/");
			if(dataJacketBtnthreadColorNm.length-1 == dataJacketBtnthreadColorPlcN.length-1) {
				sbJacketTitle.append("\t訂釦線指定\r\n");
				for(int i = 0; i < dataJacketBtnthreadColorNm.length; i++) {
					if(i == dataJacketBtnthreadColorNm.length-1) {
						sbJacket.append(convertTheProjectNameChinese(dataJacketBtnthreadColorPlcN[i])).append("-").
						append(convertTheColorName(dataJacketBtnthreadColorNm[i])).append("");
					}else {
						sbJacket.append(convertTheProjectNameChinese(dataJacketBtnthreadColorPlcN[i])).append("-").
						append(convertTheColorName(dataJacketBtnthreadColorNm[i])).append("  ");
					}
				}
			}else {
				sbJacketTitle.append("\r\n");
				sbJacket.append("\r\n");
				logger.info("JACKETボタン付け糸指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbJacketTitle.append("\r\n");
			sbJacket.append("\r\n");
			logger.info("JACKETのボタン付け糸指定は空です");
		}
		
		String detailedFieldJacketTitle = String.valueOf(sbJacketTitle);
		String detailedFieldJacket = String.valueOf(sbJacket);
		//JACKET詳細情報
		form.getField("Jk_detailed_field_title_data").setData(stringChange(detailedFieldJacketTitle));
		form.getField("Jk_detailed_field_data").setData(stringChange(detailedFieldJacket));
	}
	/**
	
	/**
	 * PANTS詳細情報,PDFで印刷
	 * @return
	 */
	private void insertPantsdetailedFieldDataCo(CrForm form, Order order) {
		StringBuffer sbPantsTitle = new StringBuffer();
		StringBuffer sbPants = new StringBuffer();
		sbPantsTitle.append("PANTS\r\n");
		sbPants.append("\r\n");
		
		//ベルトループ
		String strPantsBeltloopNm = stringChange(order.getPtBeltloopNm());
		if(!("".equals(strPantsBeltloopNm))) {
			sbPantsTitle.append("\tベルトループ\r\n");
			String[] dataPantsBeltloopNm = strPantsBeltloopNm.split("/");
			for(int i = 0; i < dataPantsBeltloopNm.length; i++) {
				if(i == dataPantsBeltloopNm.length-1) {
					sbPants.append(dataPantsBeltloopNm[i]).append("\r\n");
				}else {
					sbPants.append(dataPantsBeltloopNm[i]).append("  ");
				}
			}
		}else {
			sbPantsTitle.append("\r\n");
			sbPants.append("\r\n");
			logger.info("PANTSのベルトループは空です");
		}
		
		//ステッチ箇所変更
		String strPantsStitchPlcNm = stringChange(order.getPtStitchPlcNm());
		if(!("".equals(strPantsStitchPlcNm))) {
			sbPantsTitle.append("\tステッチ箇所変更\r\n");
			String[] dataPantsStitchPlcNm = strPantsStitchPlcNm.split("/");
			for(int i = 0; i < dataPantsStitchPlcNm.length; i++) {
				if(i == dataPantsStitchPlcNm.length-1) {
					sbPants.append(dataPantsStitchPlcNm[i]).append("\r\n");
				}else {
					sbPants.append(dataPantsStitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbPantsTitle.append("\r\n");
			sbPants.append("\r\n");
			logger.info("PANTSのステッチ箇所変更は空です");
		}
		
		//ダブルステッチ変更 
		String strPantsDblstitchPlcNm = stringChange(order.getPtDblstitchPlcNm());
		if(!("".equals(strPantsDblstitchPlcNm))) {
			sbPantsTitle.append("\tダブルステッチ変更 \r\n");
		String[] dataPantsDblstitchPlcNm = strPantsDblstitchPlcNm.split("/");
			for(int i = 0; i < dataPantsDblstitchPlcNm.length; i++) {
				if(i == dataPantsDblstitchPlcNm.length-1) {
					sbPants.append(dataPantsDblstitchPlcNm[i]).append("\r\n");
				}else {
					sbPants.append(dataPantsDblstitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbPantsTitle.append("\r\n");
			sbPants.append("\r\n");
			logger.info("PANTSのダブルステッチ変更 は空です");
		}
		
		//AMF色指定
		String strPantsAmfColorNm = stringChange(order.getPtAmfColorNm());
		String strPantsAmfColorPlcNm = stringChange(order.getPtAmfColorPlcNm());
		if(!("".equals(strPantsAmfColorNm)) && !("".equals(strPantsAmfColorPlcNm))) {
			String[] dataPantsAmfColorNm = strPantsAmfColorNm.split("/");
			String[] dataPantsAmfColorPlcNm = strPantsAmfColorPlcNm.split("/");
			if(dataPantsAmfColorNm.length-1 == dataPantsAmfColorPlcNm.length-1) {
				sbPantsTitle.append("\tAMF色指定\r\n");
				for(int i = 0; i < dataPantsAmfColorNm.length; i++) {
					if(i == dataPantsAmfColorNm.length-1) {
						sbPants.append(dataPantsAmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPantsAmfColorNm[i])).append("\r\n");
					}else {
						sbPants.append(dataPantsAmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPantsAmfColorNm[i])).append("  ");
					}
				}
			}else {
				sbPantsTitle.append("\r\n");
				sbPants.append("\r\n");
				logger.info("PANTSAMF色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPantsTitle.append("\r\n");
			sbPants.append("\r\n");
			logger.info("PANTSのAMF色指定は空です");
		}
		
		//ボタンホール色指定
		String strPantsBtnholeColorNm = stringChange(order.getPtBtnholeColorNm());
		String strPantsBtnholeColorPlcNm = stringChange(order.getPtBtnholeColorPlcNm());
		if(!("".equals(strPantsBtnholeColorNm)) && !("".equals(strPantsBtnholeColorPlcNm))) {
			String[] dataPantsBtnholeColorNm = strPantsBtnholeColorNm.split("/");
			String[] dataPantsBtnholeColorPlcNm = strPantsBtnholeColorPlcNm.split("/");
			if(dataPantsBtnholeColorNm.length-1 == dataPantsBtnholeColorPlcNm.length-1) {
				sbPantsTitle.append("\tボタンホール色指定\r\n");
				for(int i = 0; i < dataPantsBtnholeColorNm.length; i++) {
					if(i == dataPantsBtnholeColorNm.length-1) {
						sbPants.append(dataPantsBtnholeColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPantsBtnholeColorNm[i])).append("\r\n");
					}else {
						sbPants.append(dataPantsBtnholeColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPantsBtnholeColorNm[i])).append("  ");
					}
				}
			}else {
				sbPantsTitle.append("\r\n");
				sbPants.append("\r\n");
				logger.info("PANTSボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPantsTitle.append("\r\n");
			sbPants.append("\r\n");
			logger.info("PANTSのAMF色指定は空です");
		}
		
		//ボタン付け糸指定
		String strPantsBtnthreadColorNm = stringChange(order.getPtBtnthreadColorNm());
		String strPantsBtnthreadColorPlcNm = stringChange(order.getPtBtnthreadColorPlcNm());
		if(!("".equals(strPantsBtnthreadColorNm)) && !("".equals(strPantsBtnthreadColorPlcNm))) {
			String[] dataPantsBtnthreadColorNm = strPantsBtnthreadColorNm.split("/");
			String[] dataPantsBtnthreadColorPlcNm = strPantsBtnthreadColorPlcNm.split("/");
			if(dataPantsBtnthreadColorNm.length-1 == dataPantsBtnthreadColorPlcNm.length-1) {
				sbPantsTitle.append("\tボタン付け糸指定\r\n");
				for(int i = 0; i < dataPantsBtnthreadColorNm.length; i++) {
					if(i == dataPantsBtnthreadColorNm.length-1) {
						sbPants.append(dataPantsBtnthreadColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPantsBtnthreadColorNm[i])).append("");
					}else {
						sbPants.append(dataPantsBtnthreadColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPantsBtnthreadColorNm[i])).append("  ");
					}
				}
			}else {
				sbPantsTitle.append("\r\n");
				sbPants.append("\r\n");
				logger.info("PANTSボタン付け糸指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPantsTitle.append("\r\n");
			sbPants.append("\r\n");
			logger.info("PANTSのボタン付け糸指定は空です");
		}
		
		String detailedFieldPantsTitle = String.valueOf(sbPantsTitle);
		String detailedFieldPants = String.valueOf(sbPants);
		//PANTS詳細情報
		form.getField("Pt_detailed_field_title_data").setData(stringChange(detailedFieldPantsTitle));
		form.getField("Pt_detailed_field_data").setData(stringChange(detailedFieldPants));
	}
	
	/**
	 * PANTS詳細情報,PDFで印刷(中国語)
	 * @return
	 */
	private void insertPantsdetailedFieldDataCoChinese(CrForm form, Order order) {
		StringBuffer sbPantsTitle = new StringBuffer();
		StringBuffer sbPants = new StringBuffer();
		sbPantsTitle.append("PANTS\r\n");
		sbPants.append("\r\n");
		
		//ベルトループ
		String strPantsBeltloopNm = stringChange(order.getPtBeltloopNm());
		if(!("".equals(strPantsBeltloopNm))) {
			sbPantsTitle.append("\t絆帯\r\n");
			String[] dataPantsBeltloopNm = strPantsBeltloopNm.split("/");
			for(int i = 0; i < dataPantsBeltloopNm.length; i++) {
				if(i == dataPantsBeltloopNm.length-1) {
					sbPants.append(dataPantsBeltloopNm[i]).append("\r\n");
				}else {
					sbPants.append(dataPantsBeltloopNm[i]).append("  ");
				}
			}
		}else {
			sbPantsTitle.append("\r\n");
			sbPants.append("\r\n");
			logger.info("PANTSのベルトループは空です");
		}
		
		//ステッチ箇所変更
		String strPantsStitchPlcNm = stringChange(order.getPtStitchPlcNm());
		if(!("".equals(strPantsStitchPlcNm))) {
			sbPantsTitle.append("\t明線位置変更\r\n");
			String[] dataPantsStitchPlcNm = strPantsStitchPlcNm.split("/");
			for(int i = 0; i < dataPantsStitchPlcNm.length; i++) {
				if(i == dataPantsStitchPlcNm.length-1) {
					sbPants.append(dataPantsStitchPlcNm[i]).append("\r\n");
				}else {
					sbPants.append(dataPantsStitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbPantsTitle.append("\r\n");
			sbPants.append("\r\n");
			logger.info("PANTSのステッチ箇所変更は空です");
		}
		
		//ダブルステッチ変更 
		String strPantsDblstitchPlcNm = stringChange(order.getPtDblstitchPlcNm());
		if(!("".equals(strPantsDblstitchPlcNm))) {
			sbPantsTitle.append("\t双明線変更  \r\n");
		String[] dataPantsDblstitchPlcNm = strPantsDblstitchPlcNm.split("/");
			for(int i = 0; i < dataPantsDblstitchPlcNm.length; i++) {
				if(i == dataPantsDblstitchPlcNm.length-1) {
					sbPants.append(dataPantsDblstitchPlcNm[i]).append("\r\n");
				}else {
					sbPants.append(dataPantsDblstitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbPantsTitle.append("\r\n");
			sbPants.append("\r\n");
			logger.info("PANTSのダブルステッチ変更 は空です");
		}
		
		//AMF色指定
		String strPantsAmfColorNm = stringChange(order.getPtAmfColorNm());
		String strPantsAmfColorPlcNm = stringChange(order.getPtAmfColorPlcNm());
		if(!("".equals(strPantsAmfColorNm)) && !("".equals(strPantsAmfColorPlcNm))) {
			String[] dataPantsAmfColorNm = strPantsAmfColorNm.split("/");
			String[] dataPantsAmfColorPlcNm = strPantsAmfColorPlcNm.split("/");
			if(dataPantsAmfColorNm.length-1 == dataPantsAmfColorPlcNm.length-1) {
				sbPantsTitle.append("\tAMF\r\n");
				for(int i = 0; i < dataPantsAmfColorNm.length; i++) {
					if(i == dataPantsAmfColorNm.length-1) {
						sbPants.append(dataPantsAmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPantsAmfColorNm[i])).append("\r\n");
					}else {
						sbPants.append(dataPantsAmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPantsAmfColorNm[i])).append("  ");
					}
				}
			}else {
				sbPantsTitle.append("\r\n");
				sbPants.append("\r\n");
				logger.info("PANTSAMF色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPantsTitle.append("\r\n");
			sbPants.append("\r\n");
			logger.info("PANTSのAMF色指定は空です");
		}
		
		//ボタンホール色指定
		String strPantsBtnholeColorNm = stringChange(order.getPtBtnholeColorNm());
		String strPantsBtnholeColorPlcNm = stringChange(order.getPtBtnholeColorPlcNm());
		if(!("".equals(strPantsBtnholeColorNm)) && !("".equals(strPantsBtnholeColorPlcNm))) {
			String[] dataPantsBtnholeColorNm = strPantsBtnholeColorNm.split("/");
			String[] dataPantsBtnholeColorPlcNm = strPantsBtnholeColorPlcNm.split("/");
			if(dataPantsBtnholeColorNm.length-1 == dataPantsBtnholeColorPlcNm.length-1) {
				sbPantsTitle.append("\t釦眼色指定\r\n");
				for(int i = 0; i < dataPantsBtnholeColorNm.length; i++) {
					if(i == dataPantsBtnholeColorNm.length-1) {
						sbPants.append(dataPantsBtnholeColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPantsBtnholeColorNm[i])).append("\r\n");
					}else {
						sbPants.append(dataPantsBtnholeColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPantsBtnholeColorNm[i])).append("  ");
					}
				}
			}else {
				sbPantsTitle.append("\r\n");
				sbPants.append("\r\n");
				logger.info("PANTSボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPantsTitle.append("\r\n");
			sbPants.append("\r\n");
			logger.info("PANTSのAMF色指定は空です");
		}
		
		//ボタン付け糸指定
		String strPantsBtnthreadColorNm = stringChange(order.getPtBtnthreadColorNm());
		String strPantsBtnthreadColorPlcNm = stringChange(order.getPtBtnthreadColorPlcNm());
		if(!("".equals(strPantsBtnthreadColorNm)) && !("".equals(strPantsBtnthreadColorPlcNm))) {
			String[] dataPantsBtnthreadColorNm = strPantsBtnthreadColorNm.split("/");
			String[] dataPantsBtnthreadColorPlcNm = strPantsBtnthreadColorPlcNm.split("/");
			if(dataPantsBtnthreadColorNm.length-1 == dataPantsBtnthreadColorPlcNm.length-1) {
				sbPantsTitle.append("\t訂釦線指定\r\n");
				for(int i = 0; i < dataPantsBtnthreadColorNm.length; i++) {
					if(i == dataPantsBtnthreadColorNm.length-1) {
						sbPants.append(dataPantsBtnthreadColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPantsBtnthreadColorNm[i])).append("");
					}else {
						sbPants.append(dataPantsBtnthreadColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPantsBtnthreadColorNm[i])).append("  ");
					}
				}
			}else {
				sbPantsTitle.append("\r\n");
				sbPants.append("\r\n");
				logger.info("PANTSボタン付け糸指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPantsTitle.append("\r\n");
			sbPants.append("\r\n");
			logger.info("PANTSのボタン付け糸指定は空です");
		}
		
		String detailedFieldPantsTitle = String.valueOf(sbPantsTitle);
		String detailedFieldPants = String.valueOf(sbPants);
		//PANTS詳細情報
		form.getField("Pt_detailed_field_title_data").setData(stringChange(detailedFieldPantsTitle));
		form.getField("Pt_detailed_field_data").setData(stringChange(detailedFieldPants));
	}
	
	/**
	 * PANTS2詳細情報,PDFで印刷
	 * @return
	 */
	private void insertPants2detailedFieldDataCo(CrForm form, Order order) {
		StringBuffer sbPants2Title = new StringBuffer();
		StringBuffer sbPants2 = new StringBuffer();
		sbPants2Title.append("PANTS\r\n");
		sbPants2.append("\r\n");
		
		//ベルトループ
		String strPants2BeltloopNm = stringChange(order.getPt2BeltloopNm());
		if(!("".equals(strPants2BeltloopNm))) {
			sbPants2Title.append("\tベルトループ\r\n");
			String[] dataPants2BeltloopNm = strPants2BeltloopNm.split("/");
			for(int i = 0; i < dataPants2BeltloopNm.length; i++) {
				if(i == dataPants2BeltloopNm.length-1) {
					sbPants2.append(dataPants2BeltloopNm[i]).append("\r\n");
				}else {
					sbPants2.append(dataPants2BeltloopNm[i]).append("  ");
				}
			}
		}else {
			sbPants2Title.append("\r\n");
			sbPants2.append("\r\n");
			logger.info("PANTS2のベルトループは空です");
		}
		
		//ステッチ箇所変更
		String strPants2StitchPlcNm = stringChange(order.getPt2StitchPlcNm());
		if(!("".equals(strPants2StitchPlcNm))) {
			sbPants2Title.append("\tステッチ箇所変更\r\n");
			String[] dataPants2StitchPlcNm = strPants2StitchPlcNm.split("/");
			for(int i = 0; i < dataPants2StitchPlcNm.length; i++) {
				if(i == dataPants2StitchPlcNm.length-1) {
					sbPants2.append(dataPants2StitchPlcNm[i]).append("\r\n");
				}else {
					sbPants2.append(dataPants2StitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbPants2Title.append("\r\n");
			sbPants2.append("\r\n");
			logger.info("PANTS2のステッチ箇所変更は空です");
		}
		
		//ダブルステッチ変更 
		String strPants2DblstitchPlcNm = stringChange(order.getPt2DblstitchPlcNm());
		if(!("".equals(strPants2DblstitchPlcNm))) {
			sbPants2Title.append("\tダブルステッチ変更 \r\n");
		String[] dataPants2DblstitchPlcNm = strPants2DblstitchPlcNm.split("/");
			for(int i = 0; i < dataPants2DblstitchPlcNm.length; i++) {
				if(i == dataPants2DblstitchPlcNm.length-1) {
					sbPants2.append(dataPants2DblstitchPlcNm[i]).append("\r\n");
				}else {
					sbPants2.append(dataPants2DblstitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbPants2Title.append("\r\n");
			sbPants2.append("\r\n");
			logger.info("PANTS2のダブルステッチ変更 は空です");
		}
		
		//AMF色指定
		String strPants2AmfColorNm = stringChange(order.getPt2AmfColorNm());
		String strPants2AmfColorPlcNm = stringChange(order.getPt2AmfColorPlcNm());
		if(!("".equals(strPants2AmfColorNm)) && !("".equals(strPants2AmfColorPlcNm))) {
			String[] dataPants2AmfColorNm = strPants2AmfColorNm.split("/");
			String[] dataPants2AmfColorPlcNm = strPants2AmfColorPlcNm.split("/");
			if(dataPants2AmfColorNm.length-1 == dataPants2AmfColorPlcNm.length-1) {
				sbPants2Title.append("\tAMF色指定\r\n");
				for(int i = 0; i < dataPants2AmfColorNm.length; i++) {
					if(i == dataPants2AmfColorNm.length-1) {
						sbPants2.append(dataPants2AmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPants2AmfColorNm[i])).append("\r\n");
					}else {
						sbPants2.append(dataPants2AmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPants2AmfColorNm[i])).append("  ");
					}
				}
			}else {
				sbPants2Title.append("\r\n");
				sbPants2.append("\r\n");
				logger.info("PANTS2AMF色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPants2Title.append("\r\n");
			sbPants2.append("\r\n");
			logger.info("PANTS2のAMF色指定は空です");
		}
		
		//ボタンホール色指定
		String strPants2BtnholeColorNm = stringChange(order.getPt2BtnholeColorNm());
		String strPants2BtnholeColorPlcNm = stringChange(order.getPt2BtnholeColorPlcNm());
		if(!("".equals(strPants2BtnholeColorNm)) && !("".equals(strPants2BtnholeColorPlcNm))) {
			String[] dataPants2BtnholeColorNm = strPants2BtnholeColorNm.split("/");
			String[] dataPants2BtnholeColorPlcNm = strPants2BtnholeColorPlcNm.split("/");
			if(dataPants2BtnholeColorNm.length-1 == dataPants2BtnholeColorPlcNm.length-1) {
				sbPants2Title.append("\tボタンホール色指定\r\n");
				for(int i = 0; i < dataPants2BtnholeColorNm.length; i++) {
					if(i == dataPants2BtnholeColorNm.length-1) {
						sbPants2.append(dataPants2BtnholeColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPants2BtnholeColorNm[i])).append("\r\n");
					}else {
						sbPants2.append(dataPants2BtnholeColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPants2BtnholeColorNm[i])).append("  ");
					}
				}
			}else {
				sbPants2Title.append("\r\n");
				sbPants2.append("\r\n");
				logger.info("PANTS2ボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPants2Title.append("\r\n");
			sbPants2.append("\r\n");
			logger.info("PANTS2のAMF色指定は空です");
		}
		
		//ボタン付け糸指定
		String strPants2BtnthreadColorNm = stringChange(order.getPt2BtnthreadColorNm());
		String strPants2BtnthreadColorPlcNm = stringChange(order.getPt2BtnthreadColorPlcNm());
		if(!("".equals(strPants2BtnthreadColorNm)) && !("".equals(strPants2BtnthreadColorPlcNm))) {
			String[] dataPants2BtnthreadColorNm = strPants2BtnthreadColorNm.split("/");
			String[] dataPants2BtnthreadColorPlcNm = strPants2BtnthreadColorPlcNm.split("/");
			if(dataPants2BtnthreadColorNm.length-1 == dataPants2BtnthreadColorPlcNm.length-1) {
				sbPants2Title.append("\tボタン付け糸指定\r\n");
				for(int i = 0; i < dataPants2BtnthreadColorNm.length; i++) {
					if(i == dataPants2BtnthreadColorNm.length-1) {
						sbPants2.append(dataPants2BtnthreadColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPants2BtnthreadColorNm[i])).append("");
					}else {
						sbPants2.append(dataPants2BtnthreadColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPants2BtnthreadColorNm[i])).append("  ");
					}
				}
			}else {
				sbPants2Title.append("\r\n");
				sbPants2.append("\r\n");
				logger.info("PANTS2ボタン付け糸指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPants2Title.append("\r\n");
			sbPants2.append("\r\n");
			logger.info("PANTS2のボタン付け糸指定は空です");
		}
		
		String detailedFieldPants2Title = String.valueOf(sbPants2Title);
		String detailedFieldPants2 = String.valueOf(sbPants2);
		//PANTS2詳細情報
		form.getField("Pt2_detailed_field_title_data").setData(stringChange(detailedFieldPants2Title));
		form.getField("Pt2_detailed_field_data").setData(stringChange(detailedFieldPants2));
	}
	
	/**
	 * PANTS2詳細情報,PDFで印刷(中国語)
	 * @return
	 */
	private void insertPants2detailedFieldDataCoChinese(CrForm form, Order order) {
		StringBuffer sbPants2Title = new StringBuffer();
		StringBuffer sbPants2 = new StringBuffer();
		sbPants2Title.append("PANTS\r\n");
		sbPants2.append("\r\n");
		
		//ベルトループ
		String strPants2BeltloopNm = stringChange(order.getPt2BeltloopNm());
		if(!("".equals(strPants2BeltloopNm))) {
			sbPants2Title.append("\t絆帯\r\n");
			String[] dataPants2BeltloopNm = strPants2BeltloopNm.split("/");
			for(int i = 0; i < dataPants2BeltloopNm.length; i++) {
				if(i == dataPants2BeltloopNm.length-1) {
					sbPants2.append(dataPants2BeltloopNm[i]).append("\r\n");
				}else {
					sbPants2.append(dataPants2BeltloopNm[i]).append("  ");
				}
			}
		}else {
			sbPants2Title.append("\r\n");
			sbPants2.append("\r\n");
			logger.info("PANTS2のベルトループは空です");
		}
		
		//ステッチ箇所変更
		String strPants2StitchPlcNm = stringChange(order.getPt2StitchPlcNm());
		if(!("".equals(strPants2StitchPlcNm))) {
			sbPants2Title.append("\t明線位置変更 \r\n");
			String[] dataPants2StitchPlcNm = strPants2StitchPlcNm.split("/");
			for(int i = 0; i < dataPants2StitchPlcNm.length; i++) {
				if(i == dataPants2StitchPlcNm.length-1) {
					sbPants2.append(dataPants2StitchPlcNm[i]).append("\r\n");
				}else {
					sbPants2.append(dataPants2StitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbPants2Title.append("\r\n");
			sbPants2.append("\r\n");
			logger.info("PANTS2のステッチ箇所変更は空です");
		}
		
		//ダブルステッチ変更 
		String strPants2DblstitchPlcNm = stringChange(order.getPt2DblstitchPlcNm());
		if(!("".equals(strPants2DblstitchPlcNm))) {
			sbPants2Title.append("\t双明線変更 \r\n");
		String[] dataPants2DblstitchPlcNm = strPants2DblstitchPlcNm.split("/");
			for(int i = 0; i < dataPants2DblstitchPlcNm.length; i++) {
				if(i == dataPants2DblstitchPlcNm.length-1) {
					sbPants2.append(dataPants2DblstitchPlcNm[i]).append("\r\n");
				}else {
					sbPants2.append(dataPants2DblstitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbPants2Title.append("\r\n");
			sbPants2.append("\r\n");
			logger.info("PANTS2のダブルステッチ変更 は空です");
		}
		
		//AMF色指定
		String strPants2AmfColorNm = stringChange(order.getPt2AmfColorNm());
		String strPants2AmfColorPlcNm = stringChange(order.getPt2AmfColorPlcNm());
		if(!("".equals(strPants2AmfColorNm)) && !("".equals(strPants2AmfColorPlcNm))) {
			String[] dataPants2AmfColorNm = strPants2AmfColorNm.split("/");
			String[] dataPants2AmfColorPlcNm = strPants2AmfColorPlcNm.split("/");
			if(dataPants2AmfColorNm.length-1 == dataPants2AmfColorPlcNm.length-1) {
				sbPants2Title.append("\tAMF\r\n");
				for(int i = 0; i < dataPants2AmfColorNm.length; i++) {
					if(i == dataPants2AmfColorNm.length-1) {
						sbPants2.append(dataPants2AmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPants2AmfColorNm[i])).append("\r\n");
					}else {
						sbPants2.append(dataPants2AmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPants2AmfColorNm[i])).append("  ");
					}
				}
			}else {
				sbPants2Title.append("\r\n");
				sbPants2.append("\r\n");
				logger.info("PANTS2AMF色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPants2Title.append("\r\n");
			sbPants2.append("\r\n");
			logger.info("PANTS2のAMF色指定は空です");
		}
		
		//ボタンホール色指定
		String strPants2BtnholeColorNm = stringChange(order.getPt2BtnholeColorNm());
		String strPants2BtnholeColorPlcNm = stringChange(order.getPt2BtnholeColorPlcNm());
		if(!("".equals(strPants2BtnholeColorNm)) && !("".equals(strPants2BtnholeColorPlcNm))) {
			String[] dataPants2BtnholeColorNm = strPants2BtnholeColorNm.split("/");
			String[] dataPants2BtnholeColorPlcNm = strPants2BtnholeColorPlcNm.split("/");
			if(dataPants2BtnholeColorNm.length-1 == dataPants2BtnholeColorPlcNm.length-1) {
				sbPants2Title.append("\t釦眼色指定\r\n");
				for(int i = 0; i < dataPants2BtnholeColorNm.length; i++) {
					if(i == dataPants2BtnholeColorNm.length-1) {
						sbPants2.append(dataPants2BtnholeColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPants2BtnholeColorNm[i])).append("\r\n");
					}else {
						sbPants2.append(dataPants2BtnholeColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPants2BtnholeColorNm[i])).append("  ");
					}
				}
			}else {
				sbPants2Title.append("\r\n");
				sbPants2.append("\r\n");
				logger.info("PANTS2ボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPants2Title.append("\r\n");
			sbPants2.append("\r\n");
			logger.info("PANTS2のAMF色指定は空です");
		}
		
		//ボタン付け糸指定
		String strPants2BtnthreadColorNm = stringChange(order.getPt2BtnthreadColorNm());
		String strPants2BtnthreadColorPlcNm = stringChange(order.getPt2BtnthreadColorPlcNm());
		if(!("".equals(strPants2BtnthreadColorNm)) && !("".equals(strPants2BtnthreadColorPlcNm))) {
			String[] dataPants2BtnthreadColorNm = strPants2BtnthreadColorNm.split("/");
			String[] dataPants2BtnthreadColorPlcNm = strPants2BtnthreadColorPlcNm.split("/");
			if(dataPants2BtnthreadColorNm.length-1 == dataPants2BtnthreadColorPlcNm.length-1) {
				sbPants2Title.append("\t訂釦線指定\r\n");
				for(int i = 0; i < dataPants2BtnthreadColorNm.length; i++) {
					if(i == dataPants2BtnthreadColorNm.length-1) {
						sbPants2.append(dataPants2BtnthreadColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPants2BtnthreadColorNm[i])).append("");
					}else {
						sbPants2.append(dataPants2BtnthreadColorPlcNm[i]).append("-").
						append(convertTheColorName(dataPants2BtnthreadColorNm[i])).append("  ");
					}
				}
			}else {
				sbPants2Title.append("\r\n");
				sbPants2.append("\r\n");
				logger.info("PANTS2ボタン付け糸指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbPants2Title.append("\r\n");
			sbPants2.append("\r\n");
			logger.info("PANTS2のボタン付け糸指定は空です");
		}
		
		String detailedFieldPants2Title = String.valueOf(sbPants2Title);
		String detailedFieldPants2 = String.valueOf(sbPants2);
		//PANTS2詳細情報
		form.getField("Pt2_detailed_field_title_data").setData(stringChange(detailedFieldPants2Title));
		form.getField("Pt2_detailed_field_data").setData(stringChange(detailedFieldPants2));
	}
	
	/**
	 * GILET詳細情報,PDFで印刷
	 * @return
	 */
	private void insertGiletdetailedFieldDataCo(CrForm form, Order order) {
		StringBuffer sbGiletTitle = new StringBuffer();
		StringBuffer sbGilet = new StringBuffer();
		sbGiletTitle.append("GILET\r\n");
		sbGilet.append("（フト：フロント）\r\n");
		
		//ステッチ箇所変更
		String strGiletStitchPlcNm = stringChange(order.getGlStitchPlcNm());
		if(!("".equals(strGiletStitchPlcNm))) {
			sbGiletTitle.append("\tステッチ箇所変更\r\n");
			String[] dataGiletStitchPlcNm = strGiletStitchPlcNm.split("/");
			for(int i = 0; i < dataGiletStitchPlcNm.length; i++) {
				if(i == dataGiletStitchPlcNm.length-1) {
					sbGilet.append(dataGiletStitchPlcNm[i]).append("\r\n");
				}else {
					sbGilet.append(dataGiletStitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbGiletTitle.append("\r\n");
			sbGilet.append("\r\n");
			logger.info("GILETのステッチ箇所変更は空です");
		}
		
		//ダブルステッチ変更
		String strGiletDblstitchPlcNm = stringChange(order.getGlDblstitchPlcNm());
		if(!("".equals(strGiletDblstitchPlcNm))) {
			sbGiletTitle.append("\tダブルステッチ変更 \r\n");
		String[] dataGiletDblstitchPlcNm = strGiletDblstitchPlcNm.split("/");
			for(int i = 0; i < dataGiletDblstitchPlcNm.length; i++) {
				if(i == dataGiletDblstitchPlcNm.length-1) {
					sbGilet.append(dataGiletDblstitchPlcNm[i]).append("\r\n");
				}else {
					sbGilet.append(dataGiletDblstitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbGiletTitle.append("\r\n");
			sbGilet.append("\r\n");
			logger.info("GILETのダブルステッチ変更は空です");
		}
		
		//AMF色指定
		String strGiletAmfColorNm = stringChange(order.getGlAmfColorNm());
		String strGiletAmfColorPlcNm = stringChange(order.getGlAmfColorPlcNm());
		if(!("".equals(strGiletAmfColorNm)) && !("".equals(strGiletAmfColorPlcNm))) {
			String[] dataGiletAmfColorNm = strGiletAmfColorNm.split("/");
			String[] dataGiletAmfColorPlcNm = strGiletAmfColorPlcNm.split("/");
			if(dataGiletAmfColorNm.length-1 == dataGiletAmfColorPlcNm.length-1) {
				sbGiletTitle.append("\tAMF色指定\r\n");
				for(int i = 0; i < dataGiletAmfColorNm.length; i++) {
					if(i == dataGiletAmfColorNm.length-1) {
						sbGilet.append(dataGiletAmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataGiletAmfColorNm[i])).append("\r\n");
					}else {
						sbGilet.append(dataGiletAmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataGiletAmfColorNm[i])).append("  ");
					}
				}
			}else {
				sbGiletTitle.append("\r\n");
				sbGilet.append("\r\n");
				logger.info("GILETボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbGiletTitle.append("\r\n");
			sbGilet.append("\r\n");
			logger.info("GILETのAMF色指定は空です");
		}
		
		//ボタンホール色指定
		String strGiletBtnholeColorNm = stringChange(order.getGlBtnholeColorNm());
		String strGiletBtnholeColorPlcNm = stringChange(order.getGlBtnholeColorPlcNm());
		if(!("".equals(strGiletBtnholeColorNm)) && !("".equals(strGiletBtnholeColorPlcNm))) {
			String[] dataGiletBtnholeColorNm = strGiletBtnholeColorNm.split("/");
			String[] dataGiletBtnholeColorPlcNm = strGiletBtnholeColorPlcNm.split("/");
			if(dataGiletBtnholeColorNm.length-1 == dataGiletBtnholeColorPlcNm.length-1) {
				sbGiletTitle.append("\tボタンホール色指定\r\n");
				for(int i = 0; i < dataGiletBtnholeColorNm.length; i++) {
					if(i == dataGiletBtnholeColorNm.length-1) {
						sbGilet.append(dataGiletBtnholeColorPlcNm[i]).append("-").
						append(convertTheColorName(dataGiletBtnholeColorNm[i])).append("\r\n");
					}else {
						sbGilet.append(dataGiletBtnholeColorPlcNm[i]).append("-").
						append(convertTheColorName(dataGiletBtnholeColorNm[i])).append("  ");
					}
				}
			}else {
				sbGiletTitle.append("\r\n");
				sbGilet.append("\r\n");
				logger.info("GILETボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbGiletTitle.append("\r\n");
			sbGilet.append("\r\n");
			logger.info("GILETのボタンホール色指定は空です");
		}
		
		//ボタン付け糸指定
		String strGiletBtnthreadColorNm = stringChange(order.getGlBtnthreadColorNm());
		String strGiletBtnthreadColorPlcNm = stringChange(order.getGlBtnthreadColorPlcNm());
		if(!("".equals(strGiletBtnthreadColorNm)) && !("".equals(strGiletBtnthreadColorPlcNm))) {
			String[] dataGiletBtnthreadColorNm = strGiletBtnthreadColorNm.split("/");
			String[] dataGiletBtnthreadColorPlcNm = strGiletBtnthreadColorPlcNm.split("/");
			if(dataGiletBtnthreadColorNm.length-1 == dataGiletBtnthreadColorPlcNm.length-1) {
				sbGiletTitle.append("\tボタン付け糸指定\r\n");
				for(int i = 0; i < dataGiletBtnthreadColorNm.length; i++) {
					if(i == dataGiletBtnthreadColorNm.length-1) {
						sbGilet.append(convertTheProjectName(dataGiletBtnthreadColorPlcNm[i])).append("-").
						append(convertTheColorName(dataGiletBtnthreadColorNm[i])).append("\r\n");
					}else {
						sbGilet.append(convertTheProjectName(dataGiletBtnthreadColorPlcNm[i])).append("-").
						append(convertTheColorName(dataGiletBtnthreadColorNm[i])).append("  ");
					}
				}
			}else {
				sbGiletTitle.append("\r\n");
				sbGilet.append("\r\n");
				logger.info("GILETボタン付け糸指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbGiletTitle.append("\r\n");
			sbGilet.append("\r\n");
			logger.info("GILETのボタン付け糸指定は空です");
		}
		
		String detailedFieldGiletTitle = String.valueOf(sbGiletTitle);
		String detailedFieldGilet = String.valueOf(sbGilet);
		//GILET詳細情報
		form.getField("Gl_detailed_field_title_data").setData(stringChange(detailedFieldGiletTitle));
		form.getField("Gl_detailed_field_data").setData(stringChange(detailedFieldGilet));
	}
	
	/**
	 * GILET詳細情報,PDFで印刷(中国語)
	 * @return
	 */
	private void insertGiletdetailedFieldDataCoChinese(CrForm form, Order order) {
		StringBuffer sbGiletTitle = new StringBuffer();
		StringBuffer sbGilet = new StringBuffer();
		sbGiletTitle.append("GILET\r\n");
		sbGilet.append("\r\n");
		
		//ステッチ箇所変更
		String strGiletStitchPlcNm = stringChange(order.getGlStitchPlcNm());
		if(!("".equals(strGiletStitchPlcNm))) {
			sbGiletTitle.append("\t明線位置変更\r\n");
			String[] dataGiletStitchPlcNm = strGiletStitchPlcNm.split("/");
			for(int i = 0; i < dataGiletStitchPlcNm.length; i++) {
				if(i == dataGiletStitchPlcNm.length-1) {
					sbGilet.append(dataGiletStitchPlcNm[i]).append("\r\n");
				}else {
					sbGilet.append(dataGiletStitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbGiletTitle.append("\r\n");
			sbGilet.append("\r\n");
			logger.info("GILETのステッチ箇所変更は空です");
		}
		
		//ダブルステッチ変更
		String strGiletDblstitchPlcNm = stringChange(order.getGlDblstitchPlcNm());
		if(!("".equals(strGiletDblstitchPlcNm))) {
			sbGiletTitle.append("\t双明線変更 \r\n");
		String[] dataGiletDblstitchPlcNm = strGiletDblstitchPlcNm.split("/");
			for(int i = 0; i < dataGiletDblstitchPlcNm.length; i++) {
				if(i == dataGiletDblstitchPlcNm.length-1) {
					sbGilet.append(dataGiletDblstitchPlcNm[i]).append("\r\n");
				}else {
					sbGilet.append(dataGiletDblstitchPlcNm[i]).append("  ");
				}
			}
		}else {
			sbGiletTitle.append("\r\n");
			sbGilet.append("\r\n");
			logger.info("GILETのダブルステッチ変更は空です");
		}
		//AMF色指定
		String strGiletAmfColorNm = stringChange(order.getGlAmfColorNm());
		String strGiletAmfColorPlcNm = stringChange(order.getGlAmfColorPlcNm());
		if(!("".equals(strGiletAmfColorNm)) && !("".equals(strGiletAmfColorPlcNm))) {
			String[] dataGiletAmfColorNm = strGiletAmfColorNm.split("/");
			String[] dataGiletAmfColorPlcNm = strGiletAmfColorPlcNm.split("/");
			if(dataGiletAmfColorNm.length-1 == dataGiletAmfColorPlcNm.length-1) {
				sbGiletTitle.append("\tAMF\r\n");
				for(int i = 0; i < dataGiletAmfColorNm.length; i++) {
					if(i == dataGiletAmfColorNm.length-1) {
						sbGilet.append(dataGiletAmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataGiletAmfColorNm[i])).append("\r\n");
					}else {
						sbGilet.append(dataGiletAmfColorPlcNm[i]).append("-").
						append(convertTheColorName(dataGiletAmfColorNm[i])).append("  ");
					}
				}
			}else {
				sbGiletTitle.append("\r\n");
				sbGilet.append("\r\n");
				logger.info("GILETボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbGiletTitle.append("\r\n");
			sbGilet.append("\r\n");
			logger.info("GILETのAMF色指定は空です");
		}
		
		//ボタンホール色指定
		String strGiletBtnholeColorNm = stringChange(order.getGlBtnholeColorNm());
		String strGiletBtnholeColorPlcNm = stringChange(order.getGlBtnholeColorPlcNm());
		if(!("".equals(strGiletBtnholeColorNm)) && !("".equals(strGiletBtnholeColorPlcNm))) {
			String[] dataGiletBtnholeColorNm = strGiletBtnholeColorNm.split("/");
			String[] dataGiletBtnholeColorPlcNm = strGiletBtnholeColorPlcNm.split("/");
			if(dataGiletBtnholeColorNm.length-1 == dataGiletBtnholeColorPlcNm.length-1) {
				sbGiletTitle.append("\t釦眼色指定\r\n");
				for(int i = 0; i < dataGiletBtnholeColorNm.length; i++) {
					if(i == dataGiletBtnholeColorNm.length-1) {
						sbGilet.append(dataGiletBtnholeColorPlcNm[i]).append("-").
						append(convertTheColorName(dataGiletBtnholeColorNm[i])).append("\r\n");
					}else {
						sbGilet.append(dataGiletBtnholeColorPlcNm[i]).append("-").
						append(convertTheColorName(dataGiletBtnholeColorNm[i])).append("  ");
					}
				}
			}else {
				sbGiletTitle.append("\r\n");
				sbGilet.append("\r\n");
				logger.info("GILETボタンホール色指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbGiletTitle.append("\r\n");
			sbGilet.append("\r\n");
			logger.info("GILETのボタンホール色指定は空です");
		}
		
		//ボタン付け糸指定
		String strGiletBtnthreadColorNm = stringChange(order.getGlBtnthreadColorNm());
		String strGiletBtnthreadColorPlcNm = stringChange(order.getGlBtnthreadColorPlcNm());
		if(!("".equals(strGiletBtnthreadColorNm)) && !("".equals(strGiletBtnthreadColorPlcNm))) {
			String[] dataGiletBtnthreadColorNm = strGiletBtnthreadColorNm.split("/");
			String[] dataGiletBtnthreadColorPlcNm = strGiletBtnthreadColorPlcNm.split("/");
			if(dataGiletBtnthreadColorNm.length-1 == dataGiletBtnthreadColorPlcNm.length-1) {
				sbGiletTitle.append("\t訂釦線指定\r\n");
				for(int i = 0; i < dataGiletBtnthreadColorNm.length; i++) {
					if(i == dataGiletBtnthreadColorNm.length-1) {
						sbGilet.append(convertTheProjectNameChinese(dataGiletBtnthreadColorPlcNm[i])).append("-").
						append(convertTheColorName(dataGiletBtnthreadColorNm[i])).append("\r\n");
					}else {
						sbGilet.append(convertTheProjectNameChinese(dataGiletBtnthreadColorPlcNm[i])).append("-").
						append(convertTheColorName(dataGiletBtnthreadColorNm[i])).append("  ");
					}
				}
			}else {
				sbGiletTitle.append("\r\n");
				sbGilet.append("\r\n");
				logger.info("GILETボタン付け糸指定----場所と色のフィールドの数に一貫性がありません");
			}
		}else {
			sbGiletTitle.append("\r\n");
			sbGilet.append("\r\n");
			logger.info("GILETのボタン付け糸指定は空です");
		}
		
		String detailedFieldGiletTitle = String.valueOf(sbGiletTitle);
		String detailedFieldGilet = String.valueOf(sbGilet);
		//GILET詳細情報
		form.getField("Gl_detailed_field_title_data").setData(stringChange(detailedFieldGiletTitle));
		form.getField("Gl_detailed_field_data").setData(stringChange(detailedFieldGilet));
	}
	
	public String getNameByMemberUrl(Order order) {
		String storeBrandCode = order.getStoreBrandCode();
		String gyotaiCd = "1";
		if(storeBrandCode == null || "".equals(storeBrandCode)) {
			gyotaiCd = "1";
		}else if("01".equals(storeBrandCode)){
			gyotaiCd = "1";
		}else {
			gyotaiCd = "3";
		}
		MemberName memberName = memberNameService.execute(memberUrl, order.getCustCd(), gyotaiCd);
		if(memberName == null) {
			return "";
		}
		String firstName = stringChange(memberName.getFirstName());
		String lastName = stringChange(memberName.getLastName());
		String firstNameKana = stringChange(memberName.getFirstNameKana());
		String lastNameKana = stringChange(memberName.getLastNameKana());
		String firstNameOut = "";
		String lastNameOut = "";
		if(firstName != "" && lastName != "") {
			firstNameOut = firstName;
			lastNameOut = lastName;
		}else if(firstNameKana != "" && lastNameKana != "") {
			firstNameOut = firstNameKana;
			lastNameOut = lastNameKana;
		}
		return lastNameOut + " " + firstNameOut;
	}
	
}
