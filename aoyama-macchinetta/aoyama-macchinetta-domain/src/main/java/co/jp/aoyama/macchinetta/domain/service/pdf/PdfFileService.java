package co.jp.aoyama.macchinetta.domain.service.pdf;

import java.io.ByteArrayOutputStream;

public interface PdfFileService {

	ByteArrayOutputStream outputSamplePoPdf(String sign, String orderId) throws Exception;
	
	ByteArrayOutputStream outputSampleCoPdf(String path, String sign, String orderId);

}
