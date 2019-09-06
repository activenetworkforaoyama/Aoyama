package co.jp.aoyama.macchinetta.domain.service.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.jp.aoyama.macchinetta.domain.model.MemberName;

@Service
public class MemberNameServiceImpl implements MemberNameService{

	private static final Logger logger = LoggerFactory
            .getLogger(MemberNameServiceImpl.class);
	
	public MemberName execute(String memberUrl, String kokNo, String gyotaiCd) {
        String strUrl = memberUrl + "?kokNo=" + kokNo + "&gyotaiCd=" + gyotaiCd;
        HttpURLConnection urlConn = null;
        InputStream in = null;
        BufferedReader reader = null;
 
        MemberName nameBean = null;
        try {
            URL url = new URL(strUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            // WEBサービスを呼び出す
            urlConn.connect();
            int status = urlConn.getResponseCode();
            logger.debug(strUrl + "/HTTP Status:" + status);

            if (status != HttpURLConnection.HTTP_OK) {
                return null;
            }

            // レスポンスを取得する
            in = urlConn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line.replaceAll("\"", ""));
            }
            logger.debug(output.toString());

            // 該当顧客が存在しない場合
            if (output.length() == 0) {
                return null;
            }

            // レスポンスの文字列からMemberNameを生成する
            nameBean = MemberName.loadFromPlainText(output.toString());

            // 名前を返却する
            return nameBean;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (urlConn != null) {
                    urlConn.disconnect();
                }
            } catch (IOException e) {
            }
        }
    }
	
}
