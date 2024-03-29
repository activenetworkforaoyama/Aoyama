package co.jp.aoyama.macchinetta.app.rest.api.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Http请求
 * 
 * @author mszhou
 *
 */
public class HttpUtil {
	int connectTimeout;

	int readTimeout;

	/** log */
	private final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	public final String ENCODING = "UTF-8";

	public HttpUtil(int connectTimeout, int readTimeout) {
		this.connectTimeout = connectTimeout;
		this.readTimeout = readTimeout;
	}

	/**
	 * 创建HTTP连接
	 *
	 * @param urlStr           地址
	 * @param method           方法
	 * @param headerParameters 头信息
	 * @param body             请求内容
	 * @return
	 * @throws Exception
	 */
	private HttpURLConnection createConnection(String urlStr, String method, Map<String, String> headerParameters,
			String body) throws Exception {
		URL url = new URL(urlStr);
		trustAllHttpsCertificates();
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		// 设置请求时间
		logger.info("HTTPproxy connectTimeout: {}", connectTimeout);
		httpConnection.setConnectTimeout(connectTimeout);
		logger.info("HTTPproxy readTimeout: {}", readTimeout);
		httpConnection.setReadTimeout(readTimeout);
		// 设置 header
		if (headerParameters != null) {
			Iterator<String> iteratorHeader = headerParameters.keySet().iterator();
			while (iteratorHeader.hasNext()) {
				String key = iteratorHeader.next();
				httpConnection.setRequestProperty(key, headerParameters.get(key));
			}
		}
		httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + ENCODING);

		// 设置请求方法
		httpConnection.setRequestMethod(method);
		httpConnection.setDoOutput(true);
		httpConnection.setDoInput(true);
		// 写query数据流
		if (!(body == null || body.trim().equals(""))) {
			OutputStream writer = httpConnection.getOutputStream();
			try {
				writer.write(body.getBytes(ENCODING));
			} finally {
				if (writer != null) {
					writer.flush();
					writer.close();
				}
			}
		}

		// 请求结果
		int responseCode = httpConnection.getResponseCode();
		if (responseCode != 200) {
			throw new Exception(responseCode + ":" + inputStream2String(httpConnection.getErrorStream(), ENCODING));
		}

		return httpConnection;
	}

	/**
	 * POST请求
	 * 
	 * @param address          请求地址
	 * @param headerParameters 参数
	 * @param body
	 * @return
	 * @throws Exception
	 */
	public String post(String address, Map<String, String> headerParameters, String body) throws Exception {

		return proxyHttpRequest(address, "POST", null, getRequestBody(headerParameters));
	}

	/**
	 * GET请求
	 * 
	 * @param address
	 * @param headerParameters
	 * @param body
	 * @return
	 * @throws Exception
	 */
	public String get(String address, Map<String, String> headerParameters, String body) throws Exception {

		return proxyHttpRequest(address + "?" + getRequestBody(headerParameters), "GET", null, null);
	}

	/**
	 * 读取网络文件
	 * 
	 * @param address
	 * @param headerParameters
	 * @param
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public String getFile(String address, Map<String, String> headerParameters, File file) throws Exception {
		String result = "fail";

		HttpURLConnection httpConnection = null;
		try {
			httpConnection = createConnection(address, "POST", null, getRequestBody(headerParameters));
			result = readInputStream(httpConnection.getInputStream(), file);

		} catch (Exception e) {
			throw e;
		} finally {
			if (httpConnection != null) {
				httpConnection.disconnect();
			}

		}

		return result;
	}

	public byte[] getFileByte(String address, Map<String, String> headerParameters) throws Exception {
		byte[] result = null;

		HttpURLConnection httpConnection = null;
		try {
			httpConnection = createConnection(address, "POST", null, getRequestBody(headerParameters));
			result = readInputStreamToByte(httpConnection.getInputStream());

		} catch (Exception e) {
			throw e;
		} finally {
			if (httpConnection != null) {
				httpConnection.disconnect();
			}

		}

		return result;
	}

	/**
	 * 读取文件流
	 * 
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public String readInputStream(InputStream in, File file) throws Exception {
		FileOutputStream out = null;
		ByteArrayOutputStream output = null;

		try {
			output = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = in.read(buffer)) != -1) {
				output.write(buffer, 0, len);
			}

			out = new FileOutputStream(file);
			out.write(output.toByteArray());

		} catch (Exception e) {
			throw e;
		} finally {
			if (output != null) {
				output.close();
			}
			if (out != null) {
				out.close();
			}
		}
		return "success";
	}

	public byte[] readInputStreamToByte(InputStream in) throws Exception {
		FileOutputStream out = null;
		ByteArrayOutputStream output = null;
		byte[] byteFile = null;

		try {
			output = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = in.read(buffer)) != -1) {
				output.write(buffer, 0, len);
			}
			byteFile = output.toByteArray();
		} catch (Exception e) {
			throw e;
		} finally {
			if (output != null) {
				output.close();
			}
			if (out != null) {
				out.close();
			}
		}

		return byteFile;
	}

	/**
	 * HTTP请求
	 *
	 * @param address          地址
	 * @param method           方法
	 * @param headerParameters 头信息
	 * @param body             请求内容
	 * @return
	 * @throws Exception
	 */
	public String proxyHttpRequest(String address, String method, Map<String, String> headerParameters, String body)
			throws Exception {
		String result = null;
		HttpURLConnection httpConnection = null;

		try {
			httpConnection = createConnection(address, method, headerParameters, body);

			String encoding = ENCODING;
			if (httpConnection.getContentType() != null && httpConnection.getContentType().indexOf("charset=") >= 0) {
				encoding = httpConnection.getContentType()
						.substring(httpConnection.getContentType().indexOf("charset=") + 8);
			}
			result = inputStream2String(httpConnection.getInputStream(), encoding);
			logger.info("HTTPproxy response: {},{}", address, result.toString());

		} catch (Exception e) {
			logger.info("HTTPproxy error: {}", e.getMessage());
			throw e;
		} finally {
			if (httpConnection != null) {
				httpConnection.disconnect();
			}
		}
		return result;
	}

	/**
	 * 将参数化为 body
	 * 
	 * @param params
	 * @return
	 */
	public String getRequestBody(Map<String, String> params) {
		return getRequestBody(params, true);
	}

	/**
	 * 将参数化为 body
	 * 
	 * @param params
	 * @return
	 */
	public String getRequestBody(Map<String, String> params, boolean urlEncode) {
		StringBuilder body = new StringBuilder();

		Iterator<String> iteratorHeader = params.keySet().iterator();
		while (iteratorHeader.hasNext()) {
			String key = iteratorHeader.next();
			String value = params.get(key);

			if (urlEncode) {
				try {
					body.append(key + "=" + URLEncoder.encode(value, ENCODING) + "&");
				} catch (UnsupportedEncodingException e) {
					// e.printStackTrace();
				}
			} else {
				body.append(key + "=" + value + "&");
			}
		}

		if (body.length() == 0) {
			return "";
		}
		return body.substring(0, body.length() - 1);
	}

	/**
	 * 读取inputStream 到 string
	 * 
	 * @param input
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	private String inputStream2String(InputStream input, String encoding) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input, encoding));
		StringBuilder result = new StringBuilder();
		String temp = null;
		while ((temp = reader.readLine()) != null) {
			result.append(temp);
		}

		return result.toString();

	}

	/**
	 * 设置 https 请求
	 * 
	 * @throws Exception
	 */
	private void trustAllHttpsCertificates() throws Exception {
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String str, SSLSession session) {
				return true;
			}
		});
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new Mitm();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}

	// 设置 https 请求证书
	static class Mitm implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
		@Override
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}

		@Override
		public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}

		@Override
		public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}

	}

	// ====================================================================
	// ============================= 测试调用 ============================
	// ====================================================================
	public static void main(String[] args) {

//        try {
//
//            //请求地址()
//           // String address = "https://ifind-admin-beta.ifdc.top/servlet/tobject";
//            String address = "https://ifind-admin.fdcfabric.com/servlet/tobject";
//
//            //请求参数
//            Map<String, String> params = new HashMap<String, String>();
//            Map<String, Object> map = new HashMap<String, Object>();
//
//            //这是该接口需要的参数
//            params.put("objectName", "GroupRole");
//            params.put("action", "getList");
//            params.put("group_role_isdealGroup", "0");
//            params.put("order", "createTime");
//            params.put("desc", "0");
//            params.put("resultFormat", "7");
//            params.put("condition", "group_role_type&16=16");
//            params.put("blob", "1");
//
//            // 调用 get 请求
//           String res = get(address, params, null);
//            //String  res = "{\"code\":\"0\",\"value\":\"2\",\"message\":\"\",\"record\":[{\"id\":\"476231555140602405\",\"name\":\"找布中心0413\",\"group_role_id\":\"476231555140602405\",\"group_role_code\":\"000001\",\"group_role_name\":\"找布中心0413\",\"group_role_group\":\"221721555140601790\",\"group_role_type\":\"19\",\"group_role_period\":\"111\",\"group_role_interval\":\"24\",\"group_role_remark\":\"\",\"group_role_longitude\":\"45.454545\",\"group_role_latitude\":\"67.676767\",\"group_role_telephone\":\"1585040476\",\"group_role_addresscity\":\"北京市市辖区\",\"group_role_addressstreet\":\"东城区\",\"group_role_addressstate\":\"北京市\",\"group_role_addressname\":\"找布中心0413\",\"group_role_addresslandmark\":\"\",\"group_role_status\":\"1\"},{\"id\":\"642671555144267375\",\"name\":\"找布中心041301\",\"group_role_id\":\"642671555144267375\",\"group_role_code\":\"000001\",\"group_role_name\":\"找布中心041301\",\"group_role_group\":\"22711555144266730\",\"group_role_type\":\"17\",\"group_role_period\":\"32134\",\"group_role_interval\":\"24\",\"group_role_remark\":\"\",\"group_role_longitude\":\"45.454545\",\"group_role_latitude\":\"34.455678\",\"group_role_telephone\":\"3453543543\",\"group_role_addresscity\":\"北京市市辖区\",\"group_role_addressstreet\":\"东城区\",\"group_role_addressstate\":\"北京市\",\"group_role_addressname\":\"找布中心041301\",\"group_role_addresslandmark\":\"534321554344903803\",\"group_role_status\":\"1\"}]}";
//            System.out.println(res);//打印返回参数
//
////            ResFdcInfo resFdcInfo = JSON.parseObject(res, ResFdcInfo.class);
////            System.out.println(resFdcInfo.getRecord().size());
////            System.out.println(resFdcInfo.getRecord().toString());
//        } catch (Exception e) {
//            // TODO 异常
//            e.printStackTrace();
//        }

	}

}
