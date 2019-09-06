package aoyama.member.domain.renkei;

import aoyama.member.api.wsdl_test.UserInfoServiceStubTest;
import aoyama.member.domain.conf.MyProperty;
import aoyama.member.domain.model.DecryptKokNoReqBean;
import aoyama.member.domain.model.DecryptKokNoResBean;
import aoyama.member.domain.model.DecryptKokNoResListBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 顧客No非トークン化WEBサービス処理を行います。
 */
@Component
public class DecryptKokNoRealRenkeiTest {
    
    @Autowired
    MyProperty myProp;
    
    // TODO Exception等仮入れの状態
    
    private static final Logger logger = LoggerFactory
            .getLogger(DecryptKokNoRealRenkeiTest.class);

    /**
     * WEBサービスから顧客No非トークン化情報を取得し、返します。
     * @param   prop             CSaProperties
     * @param   reqBean          顧客No非トークン化リクエストbean
     * @return  DecryptKokNoResBean　顧客No非トークン化レスポンスbean
     */
    public DecryptKokNoResBean requestGetDecryptKokNo(DecryptKokNoReqBean reqBean, int gyotaiCd) throws Exception {
        logger.info("requestGetDecryptKokNo - real - START");
        if (reqBean == null) {
            logger.error("DecryptKokNoReqBean is null");
            throw new Exception();
        }

        UserInfoServiceStubTest stub = null;
        UserInfoServiceStubTest.GetDecryptKokNoRequest gdknRequest = null;
        try {
            // リクエストクラスの生成
            gdknRequest = new UserInfoServiceStubTest.GetDecryptKokNoRequest();
            // リクエストに値をセット
            gdknRequest.setCorpCode(myProp.getRealRenkeiReqCorpCode()); // 提携企業コード
            gdknRequest.setPassword(myProp.getRealRenkeiReqPassword()); // 提携企業パスワード
            gdknRequest.setTestId(myProp.getRealRenkeiReqTestId()); // 試験ID
            gdknRequest.setGyotaiCd(gyotaiCd); // 業態
            
            // データ件数を設定
            int dataCnt = reqBean.getDecryptKokNoRequest().size();
            gdknRequest.setDataCnt(dataCnt);
            
         // 顧客情報配列に顧客番号を設定
            UserInfoServiceStubTest.StructGetDecryptKokNoRequest[] struct = new UserInfoServiceStubTest.StructGetDecryptKokNoRequest[dataCnt];
            UserInfoServiceStubTest.StructGetDecryptKokNoRequest structItem = null;
            for (int i = 0; i < dataCnt; i++) {
                // 顧客No.を設定
                structItem = new UserInfoServiceStubTest.StructGetDecryptKokNoRequest();
                structItem.setKokNo(reqBean.getDecryptKokNoRequest().get(i).getKokNo());
                struct[i] = structItem;
            }
            UserInfoServiceStubTest.ArrayOfStructGetDecryptKokNoRequest arrayKokNo = new UserInfoServiceStubTest.ArrayOfStructGetDecryptKokNoRequest();
            arrayKokNo.setItem(struct);
            gdknRequest.setUserArray(arrayKokNo);

            // 顧客No非トークン化
            stub = new UserInfoServiceStubTest();
            // 送信用XML
            UserInfoServiceStubTest.GetDecryptKokNo gdkn = new UserInfoServiceStubTest.GetDecryptKokNo();
            gdkn.setIn0(gdknRequest);

            // リアル連携の設定取得
        	String waitTime = myProp.getRealRenkeiReqWaitTime();
        	String sleepTime = myProp.getRealRenkeiReqSleepTime();
        	
            // 経過時間(開始)
            long beforeTime = (new java.util.Date()).getTime();
            // スリープ処理(ミリ秒)
            if(new Long(sleepTime) > 0){
                Thread.sleep((new Long(sleepTime)).longValue());
            }
            logger.warn("request - 提携企業コード [" + gdknRequest.getCorpCode() + "]");
            logger.warn("request - 提携企業パスワード [" + gdknRequest.getPassword() + "]");
            logger.warn("request - 試験ID [" + gdknRequest.getTestId() + "]");
            logger.warn("request - 業態 [" + gdknRequest.getGyotaiCd() + "]");
            logger.warn("request - データ件数 [" + gdknRequest.getDataCnt() + "]");

            // 顧客サーバへ接続
            UserInfoServiceStubTest.GetDecryptKokNoResponseE decryptKokNo = stub.getDecryptKokNo(gdkn);

            // 経過時間(終了)
            long afterTime = (new java.util.Date()).getTime();
            // 指定ミリ秒以上経過時のログ出力
            if(new Long(waitTime) > 0){
                if((afterTime - beforeTime) > (new Long(waitTime)).longValue()){
                    logger.warn("");
                }
            }

            // XMLの受信
            UserInfoServiceStubTest.GetDecryptKokNoResponse decryptKokNoResponse = decryptKokNo.getGetDecryptKokNoReturn();
            if (decryptKokNoResponse == null) {
                return null;
            }
            
            // 非トークン化№取得レスポンスBeanを返却
            DecryptKokNoResBean resBean = makeGetDecryptKokNoResponseBean(decryptKokNoResponse);
            
            return resBean;

        } catch (Exception e) {
            if (e instanceof org.apache.axis2.AxisFault) {
                // 連携先でのエラー
                org.apache.axis2.AxisFault ex = (org.apache.axis2.AxisFault)e;
                String faultCode = "";
                    
                if (ex.getFaultCode() != null) {
                    faultCode = ex.getFaultCode().toString();
                    if ("2303".equals(faultCode)) {
                        // 2303:最新顧客情報取得ビューに存在しない
                        return null;
                    }
                    logger.error("処理中にエラーが発生しました。", e);
                    throw new Exception();
                }
                logger.error("処理中にエラーが発生しました。", e);
                throw new Exception();
            } else {
                // 顧客カルテ内部処理エラー
                logger.error("internal error", e);
                throw new Exception();
            }
        } finally {
            if (stub != null) {
                // stubのクリンナップ
                try {
                    stub._getServiceClient().cleanup();
                    stub.cleanup();
                } catch (Throwable t) {
                }
            }
            logger.info("requestGetDecryptKokNo - real - END");
        }
    }

    /**
     * 顧客サーバからのレスポンスをレスポンス用Beanにセットします。
     * @param prop
     * @param response
     * @return DecryptKokNoResBean
     * @throws Exception
     */
    private DecryptKokNoResBean makeGetDecryptKokNoResponseBean(UserInfoServiceStubTest.GetDecryptKokNoResponse response) throws Exception {
        DecryptKokNoResBean bean = new DecryptKokNoResBean();

        int dataCnt = response.getDataCnt();
        if (dataCnt == 0) {
            return null;
        }
        bean.setDataCnt(dataCnt); // データ件数

        UserInfoServiceStubTest.ArrayOfStructGetDecryptKokNoResponse array = response.getUserArray();
        UserInfoServiceStubTest.StructGetDecryptKokNoResponse[] struct = array.getItem();

        List<DecryptKokNoResListBean> kokNoList = new ArrayList<DecryptKokNoResListBean>();
        DecryptKokNoResListBean kokNoBean = null;
        for (int i = 0; struct != null && i < struct.length; i++) {
            kokNoBean = new DecryptKokNoResListBean();
            kokNoBean.setRetCd(struct[i].getRetCd()); // 結果コード
            kokNoBean.setReqKokNo(struct[i].getReqKokNo()); // リクエスト顧客No.
            kokNoBean.setKokNo(struct[i].getKokNo()); // 顧客No.
            kokNoList.add(kokNoBean);
        }
        bean.setDecryptKokNoResponse(kokNoList);
        return bean;
    }
}