package co.jp.aoyama.macchinetta.domain.service.pdf;

import java.io.ByteArrayOutputStream;

import co.jp.aoyama.macchinetta.domain.model.Measuring;
import co.jp.aoyama.macchinetta.domain.model.Order;

public interface PdfFileService {

	ByteArrayOutputStream outputSamplePoPdf(String sign, Order order, Measuring measuring, String productItem) throws Exception;
	
	ByteArrayOutputStream outputSampleCoPdf(String sign, Order order, Measuring measuring, String productItem) throws Exception;
	
	void outputPrintPdf(String sign, Order order, Measuring measuring, String productItem,String path,String filename) throws Exception;
	
	void delectePrintPdf(String pdfPath) throws Exception;

}
