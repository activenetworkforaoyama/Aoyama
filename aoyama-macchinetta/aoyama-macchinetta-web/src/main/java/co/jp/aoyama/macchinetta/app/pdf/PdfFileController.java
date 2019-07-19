package co.jp.aoyama.macchinetta.app.pdf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.inject.Inject;
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

import co.jp.aoyama.macchinetta.domain.service.pdf.PdfFileService;

/**
 * pdfをダウンロードする
 * @author wuzhengyang
 *
 */
@Controller
@RequestMapping(value = "/pdfFile")
public class PdfFileController {
	
	@Inject
	PdfFileService pdfFileService;
	
	private static final Logger logger = LoggerFactory
            .getLogger(PdfFileController.class);
	
	// (SUIT)
	private static final String IS_CO_SUIT = "01";
	// (SHIRT)
	private static final String IS_CO_SHIRT = "05";
	// (COAT)
	private static final String IS_CO_COAT = "06";
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		return "pdf/pdfDownload";
	}
    
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "poPdfFileDownload", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity poPdfFileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		String sign = request.getParameter("sign");
		String orderId = request.getParameter("orderId");
		try {
			output = pdfFileService.outputSamplePoPdf(sign, orderId);
			
			String fileNameDefault = null;
			if("1".equals(sign)) {
				//注文内容確認書(SUIT)_工場向
				fileNameDefault = "注文内容確認書(SUIT)_工場向.pdf";
			}else if("2".equals(sign)) {
				//注文内容確認書(SUIT)_お客様向
				fileNameDefault = "注文内容確認書(SUIT)_お客様向.pdf";
			}else if("3".equals(sign)) {
				//工場指示書(SUIT)
				fileNameDefault = "工場指示書(SUIT).pdf";
			}else{
				 logger.info("このスタイルはありません");
			}
				
			response.addHeader("Content-Type", "application/force-download");
			response.addHeader("Content-Disposition", "attachment; filename=" + new String(fileNameDefault.getBytes("UTF-8"),"ISO8859-1"));
			response.getOutputStream().write(output.toByteArray());
			response.setStatus(200);
			logger.info("done");
		} catch (IOException e) {
			e.printStackTrace();
			logger.info(e.toString());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		//RunTime.getRunTime().exec("rundll32 url.dll,FileProtocolHandler " + url);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "coPdfFileDownload", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity createCoPDFFile(HttpServletRequest request, HttpServletResponse response) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		String sign = request.getParameter("sign");
		String orderId = request.getParameter("orderId");
		try {
			ServletContext servletContext = request.getSession().getServletContext();
		    //パスの設定する
			String path = servletContext.getRealPath("/");
			output = pdfFileService.outputSampleCoPdf(path, sign, orderId);
			
			String fileNameDefault = null;
			if("1".equals(sign)) {
				//注文内容確認書(SUIT)_工場向
				fileNameDefault = "注文内容確認書(SUIT)_工場向.pdf";
			}else if("2".equals(sign)) {
				//注文内容確認書(SUIT)_お客様向
				fileNameDefault = "注文内容確認書(SUIT)_お客様向.pdf";
			}else if("3".equals(sign)) {
				//工場指示書(SUIT)
				fileNameDefault = "工場指示書(SUIT).pdf";
			}else{
				 logger.info("このスタイルはありません");
			}
				
			response.addHeader("Content-Type", "application/force-download");
			response.addHeader("Content-Disposition", "attachment; filename=" + new String(fileNameDefault.getBytes("UTF-8"),"ISO8859-1"));
			response.getOutputStream().write(output.toByteArray());
			response.setStatus(200);
			logger.info("done");
		} catch (IOException e) {
			e.printStackTrace();
			logger.info(e.toString());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		//RunTime.getRunTime().exec("rundll32 url.dll,FileProtocolHandler " + url);
		return new ResponseEntity(HttpStatus.OK);
	}
    
}
