package co.jp.aoyama.macchinetta.app.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.Order;
import co.jp.aoyama.macchinetta.domain.service.measuring.MeasuringService;
import co.jp.aoyama.macchinetta.domain.service.orderlist.OrderListService;
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
	
	@Inject
	OrderListService orderListService;
	
	@Inject
	MeasuringService measuringService;
	
	private static final Logger logger = LoggerFactory
            .getLogger(PdfFileController.class);
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() {
		return "pdf/pdfDownload";
	}
    
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "poPdfFileDownload", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity poPdfFileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		String sign = request.getParameter("sign");
		String orderId = request.getParameter("orderId");
		String productItem = request.getParameter("productItem");
		
		//orderIdでorderオブジェクトを取得します
		Order order = orderListService.findOrderByPk(orderId);
		//orderIdでmeasuringオブジェクトを取得します
    	Measuring measuring = measuringService.selectByPrimaryKey(orderId);
    	
    	if(measuring == null) {
    		logger.info("measuring対象はnullです。");
    	}
    	
    	try {
			output = pdfFileService.outputSamplePoPdf(sign, order, measuring, productItem);
			
			String fileNameDefault = "";
			if("1".equals(sign)) {
				//"注文内容確認書
				fileNameDefault = "注文内容確認書（"+orderId+"）.pdf";
			}else if("2".equals(sign)) {
				//"注文内容確認書_お客様向け
				fileNameDefault = "注文内容確認書_お客様向け（"+orderId+"）.pdf";
			}else if("3".equals(sign)) {
				//工場指示書
				fileNameDefault = "工場指示書（"+orderId+"）.pdf";
			}else{
				 logger.info("このスタイルはありません");
			}
				
			response.addHeader("Content-Type", "application/force-download");
			response.addHeader("Content-Disposition", "attachment; filename=" + new String(fileNameDefault.getBytes("UTF-8"),"ISO8859-1"));
			response.getOutputStream().write(output.toByteArray());
			response.setStatus(200);
			logger.info("Download is OK");
		} catch (IOException e) {
			e.printStackTrace();
			logger.info(e.toString());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "coPdfFileDownload", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity coPdfFileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		String sign = request.getParameter("sign");
		String orderId = request.getParameter("orderId");
		String productItem = request.getParameter("productItem");
		
		Order order= new Order();
		//orderIdでorderオブジェクトを取得します
		if("10".equals(sign) || "11".equals(sign) || "12".equals(sign)) {
			order = orderListService.findOrderByPkChinese(orderId);
		}else {
			order = orderListService.findOrderByPk(orderId);
		}
		//orderIdでmeasuringオブジェクトを取得します
    	Measuring measuring = measuringService.selectByPrimaryKey(orderId);
    	
    	if(measuring == null) {
    		logger.info("measuring対象はnullです。");
    	}
    	
    	try {
			output = pdfFileService.outputSampleCoPdf(sign, order, measuring, productItem);
			
			String fileNameDefault = "";
			if("1".equals(sign)) {
				//注文内容確認書（SUIT）
				fileNameDefault = "注文内容確認書（"+orderId+"）.pdf";
			}else if("2".equals(sign)) {
				//注文内容確認書_お客様向け（SUIT）
				fileNameDefault = "注文内容確認書_お客様向け（"+orderId+"）.pdf";
			}else if("3".equals(sign)) {
				//工場指示書（SUIT）
				fileNameDefault = "工場指示書（"+orderId+"）.pdf";
			}else if("4".equals(sign)) {
				//注文内容確認書（COAT）
				fileNameDefault = "注文内容確認書（"+orderId+"）.pdf";
			}else if("5".equals(sign)) {
				//注文内容確認書_お客様向け（COAT）
				fileNameDefault = "注文内容確認書_お客様向け（"+orderId+"）.pdf";
			}else if("6".equals(sign)) {
				//工場指示書（COAT）
				fileNameDefault = "工場指示書（"+orderId+"）.pdf";
			}else if("7".equals(sign)) {
				//注文内容確認書（SHIRT）
				fileNameDefault = "注文内容確認書（"+orderId+"）.pdf";
			}else if("8".equals(sign)) {
				//注文内容確認書_お客様向け（SHIRT）
				fileNameDefault = "注文内容確認書_お客様向け（"+orderId+"）.pdf";
			}else if("9".equals(sign)) {
				//工場指示書（SHIRT）
				fileNameDefault = "工場指示書（"+orderId+"）.pdf";
			}else if("10".equals(sign)) {
				//工場指示書（SUIT）
				fileNameDefault = "工場指示書(中国語)（"+orderId+"）.pdf";
			}else if("11".equals(sign)) {
				//工場指示書（SHIRT）
				fileNameDefault = "工場指示書(中国語)（"+orderId+"）.pdf";
			}else if("12".equals(sign)) {
				//工場指示書（COAT）
				fileNameDefault = "工場指示書(中国語)（"+orderId+"）.pdf";
			}else{
				 logger.info("このスタイルはありません");
			}
				
			response.addHeader("Content-Type", "application/force-download");
			response.addHeader("Content-Disposition", "attachment; filename=" + new String(fileNameDefault.getBytes("UTF-8"),"ISO8859-1"));
			response.getOutputStream().write(output.toByteArray());
			response.setStatus(200);
			logger.info("Download is OK");
		} catch (IOException e) {
			e.printStackTrace();
			logger.info(e.toString());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/**
	 * orderIdに基ずいてオブジェクトを照会する
	 * @param request
	 * @param response
	 * @param model
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "poPdfFileCheck", method = RequestMethod.GET)
	@ResponseBody
	public Order poPdfFileCheck(HttpServletRequest request, HttpServletResponse response, String orderId) throws Exception {
		//orderIdでorderオブジェクトを取得します
		Order order = orderListService.findOrderByPk(orderId);
		
		if(order == null) {
    		logger.info("order対象はnullです。");
    	}
		
		return order;
	}
	@RequestMapping(value = "PdfFileCreate", method = RequestMethod.GET)
	@ResponseBody
	public String  PdfFileCreate(HttpServletRequest request, HttpServletResponse response,String orderId,String sign,String productItem,String fileNameDefault,String orderPattern) throws Exception {
		
		//orderIdでorderオブジェクトを取得します
		Order order = orderListService.findOrderByPk(orderId);
		//orderIdでmeasuringオブジェクトを取得します
    	Measuring measuring = measuringService.selectByPrimaryKey(orderId);
    	ServletContext servletContext = request.getSession().getServletContext();
		String path = servletContext.getRealPath("")+ File.separator + "pdf";
		
		File uploadDir = new File(path);
		 if (!uploadDir.exists()) {
		  uploadDir.mkdir();
		 }
    	if(measuring == null) {
    		logger.info("measuring対象はnullです。");
    	}
    	
    	try {
			pdfFileService.outputPrintPdf(sign, order, measuring, productItem,path,fileNameDefault,orderPattern);
			logger.info("Download is OK");
		} catch (IOException e) {
			e.printStackTrace();
			logger.info(e.toString());
			return path;
		}
    	return path;
	}
	
	@RequestMapping(value = "poPdfFileDelete", method = RequestMethod.GET)
	@ResponseBody
	public String  poPdfFileDelete(HttpServletRequest request, HttpServletResponse response,String fileNameDefault) throws Exception {
		
    	ServletContext servletContext = request.getSession().getServletContext();
    	String path = servletContext.getRealPath("")+ File.separator + "pdf" + File.separator ;
    	
		pdfFileService.delectePrintPdf(path+fileNameDefault);
		
    	return path;
	}
	
}
