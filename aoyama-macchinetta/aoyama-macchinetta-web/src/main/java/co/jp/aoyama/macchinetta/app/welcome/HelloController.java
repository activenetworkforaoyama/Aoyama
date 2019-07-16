package co.jp.aoyama.macchinetta.app.welcome;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

//import jp.co.hos.coreports.CrDraw;
//import jp.co.hos.coreports.CrFileOutJob;
//import jp.co.hos.coreports.CrForm;
//import jp.co.hos.coreports.CrStreamOutJob;
//import jp.co.hos.coreports.constants.CorDocumentType;
//import jp.co.hos.coreports.document.CrPdfDocument;
//import jp.co.hos.coreports.exception.CrException;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/aoyama")
public class HelloController {

    private static final Logger logger = LoggerFactory
            .getLogger(HelloController.class);
    
	private static final String FORM_PATH = "C:\\CrHokenSample\\";
	
	private static final String DOCUMENT_PATH = "C:\\CrHokenSample\\";
	

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "welcome/home";
    }
    
//	@SuppressWarnings("rawtypes")
//	@RequestMapping(value = "createpdf", method = RequestMethod.GET)
//	@ResponseStatus(value = HttpStatus.OK)
//	public ResponseEntity createPDF(HttpServletRequest request, HttpServletResponse response) {
//		ByteArrayOutputStream output = new ByteArrayOutputStream();
//		try {
//	        ServletContext servletContext = request.getSession().getServletContext();
//	      //パスの設定する
//			String path = servletContext.getRealPath("/");
//			output = outputSamplePdf(path);
//	        
//			//output = aoyamaService.createPDF();
//			response.addHeader("Content-Type", "application/force-download");
//			response.addHeader("Content-Disposition", "attachment; filename=\"test.pdf\"");
//			response.getOutputStream().write(output.toByteArray());
//			response.setStatus(200);
//			logger.info("done");
//		} catch (IOException e) {
//			e.printStackTrace();
//			logger.info(e.toString());
//			return new ResponseEntity(HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity(HttpStatus.OK);
//	}

    
//    public ByteArrayOutputStream outputSamplePdf(String path) {
//        // （１）描画クラスのインスタンスを生成します
//        CrDraw draw = new CrDraw();
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//
//		
//        try {
//        	
//            // （２）CrDrawのプロパティを設定します
//            // フォームファイルを読み込むパスを指定します
////            draw.setFormPath(FORM_PATH);
////            // 出力先のフォルダを指定します
////            draw.setDocumentPath(DOCUMENT_PATH);
////
////            // 画像等のデータファイルが置いてあるディレクトリを設定します
////            draw.setDataPath("C:\\CrHokenSample\\");
////            // 作業用ディレクトリを設定します
////            draw.setWorkPath("C:\\CrHokenSample\\");
//     
//            // （３）出力形式とファイル名を指定してファイル出力ジョブを生成します
//            //CrFileOutJob job = new CrFileOutJob(CorDocumentType.PDF, "C:\\CrHokenSample\\TestSample.pdf");
//            
//            CrStreamOutJob strjob = new CrStreamOutJob(CorDocumentType.PDF, output);
//            // （４）出力形式ごとのプロパティを設定します
//            // ここではドキュメントを開くためのパスワードを設定しています
//            //CrBinaryDocument doc = job.getDocument();
//            CrPdfDocument doc = strjob.getDocument();
//            //doc.setPassword("hogehoge");
//            doc.setDocumentName("お客様内容確認書");
//     
//            // （５）フォームファイルを開きます
//            CrForm form = CrForm.open(draw, path + "\\cfx\\TestSample.cfx");
//            try {
//                // （６）ファイル出力ジョブを開始します
//                draw.startJob(strjob);
//                // （７）出力先の用紙サイズをフォームのサイズに設定します
//                strjob.getCrPrinter().setFormSize(form);
//                // （８）フォームファイル上の「Title」という名前のテキストフィールドに
//                // 「Hello, World」という文字列を設定します
//                form.getField("Title").setData("熱田支店テスト流新う");
//                //form.getField("Todo").setData("Hello, World」という文字列を設定します。");
//                // （９）１ページ出力します
//                form.printOut();
//                // （１０）ファイル出力ジョブを終了します
//                draw.endJob();
//            } finally {
//                // （１１）フォームを閉じます
//                form.close();
//            }
//        } catch (CrException cex) {
//            // シーオーリポーツ内で発生した例外を処理します
//            cex.printStackTrace();
//            // 実行中のジョブがあれば破棄します
//            draw.abortJob();
//        } finally {
//            // （１２）描画クラスの後処理を行います
//            draw.deleteInstance();
//
//        }
//        return output;
//    }
}
