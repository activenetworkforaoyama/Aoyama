package aoyama.member.domain.renkei;

import aoyama.member.api.wsdl.UserInfoServiceStub;
import aoyama.member.domain.conf.MyProperty;
import aoyama.member.domain.model.EncryptKokNoReqBean;
import aoyama.member.domain.model.EncryptKokNoResBean;
import aoyama.member.domain.model.EncryptKokNoResListBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 顧客Noトークン化WEBサービス処理を行います。
 */
@Component
public class EncryptKokNoRealRenkei {
    
    @Autowired
    MyProperty myProp;
    
    // TODO Exception等仮入れの状態
    
    private static final Logger logger = LoggerFactory
            .getLogger(EncryptKokNoRealRenkei.class);

    /**
     * WEBサービスから顧客Noトークン化情報を取得し、返します。
     * @param   prop             CSaProperties
     * @param   reqBean          顧客Noトークン化リクエストbean
     * @return  EncryptKokNoResBean　顧客Noトークン化レスポンスbean
     */
    public EncryptKokNoResBean requestGetEncryptKokNo(EncryptKokNoReqBean reqBean, int gyotaiCd) throws Exception {
        logger.info("requestGetEncryptKokNo - real - START");
        if (reqBean == null) {
            logger.error("EncryptKokNoReqBean is null");
            throw new Exception();
        }

        UserInfoServiceStub stub = null;
        UserInfoServiceStub.GetEncryptKokNoRequest geknRequest = null;
        try {
            // リクエストクラスの生成
            geknRequest = new UserInfoServiceStub.GetEncryptKokNoRequest();
            // リクエストに値をセット
            geknRequest.setCorpCode(myProp.getRealRenkeiReqCorpCode()); // 提携企業コード
            geknRequest.setPassword(myProp.getRealRenkeiReqPassword()); // 提携企業パスワード
            geknRequest.setTestId(myProp.getRealRenkeiReqTestId()); // 試験ID
//            geknRequest.setGyotaiCd(myProp.getRealRenkeiReqGyotaiCd()); // 業態
            geknRequest.setGyotaiCd(gyotaiCd); // 業態
            
            // データ件数を設定
            int dataCnt = reqBean.getEncryptKokNoRequest().size();
            geknRequest.setDataCnt(dataCnt);
            
         // 顧客情報配列に顧客番号を設定
            UserInfoServiceStub.StructGetEncryptKokNoRequest[] struct = new UserInfoServiceStub.StructGetEncryptKokNoRequest[dataCnt];
            UserInfoServiceStub.StructGetEncryptKokNoRequest structItem = null;
            for (int i = 0; i < dataCnt; i++) {
                // 顧客No.を設定
                structItem = new UserInfoServiceStub.StructGetEncryptKokNoRequest();
                structItem.setKokNo(reqBean.getEncryptKokNoRequest().get(i).getKokNo());
                struct[i] = structItem;
            }
            UserInfoServiceStub.ArrayOfStructGetEncryptKokNoRequest arrayKokNo = new UserInfoServiceStub.ArrayOfStructGetEncryptKokNoRequest();
            arrayKokNo.setItem(struct);
            geknRequest.setUserArray(arrayKokNo);

            // 顧客Noトークン化
            stub = new UserInfoServiceStub();
            // 送信用XML
            UserInfoServiceStub.GetEncryptKokNo gekn = new UserInfoServiceStub.GetEncryptKokNo();
            gekn.setIn0(geknRequest);

            // リアル連携の設定取得
        	String waitTime = myProp.getRealRenkeiReqWaitTime();
        	String sleepTime = myProp.getRealRenkeiReqSleepTime();
        	
            // 経過時間(開始)
            long beforeTime = (new java.util.Date()).getTime();
            // スリープ処理(ミリ秒)
            if(new Long(sleepTime) > 0){
                Thread.sleep((new Long(sleepTime)).longValue());
            }

            // 顧客サーバへ接続
            UserInfoServiceStub.GetEncryptKokNoResponseE encryptKokNo = stub.getEncryptKokNo(gekn);

            // 経過時間(終了)
            long afterTime = (new java.util.Date()).getTime();
            // 指定ミリ秒以上経過時のログ出力
            if(new Long(waitTime) > 0){
                if((afterTime - beforeTime) > (new Long(waitTime)).longValue()){
                    logger.warn("");
                }
            }

            // XMLの受信
            UserInfoServiceStub.GetEncryptKokNoResponse encryptKokNoResponse = encryptKokNo.getGetEncryptKokNoReturn();
            if (encryptKokNoResponse == null) {
                return null;
            }
            
            // トークン化№取得レスポンスBeanを返却
            EncryptKokNoResBean resBean = makeGetEncryptKokNoResponseBean(encryptKokNoResponse);
            
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
            logger.info("requestGetEncryptKokNo - real - END");
        }
    }

    /**
     * 顧客サーバからのレスポンスをレスポンス用Beanにセットします。
     * @param prop
     * @param response
     * @return EncryptKokNoResBean
     * @throws Exception
     */
    private EncryptKokNoResBean makeGetEncryptKokNoResponseBean(UserInfoServiceStub.GetEncryptKokNoResponse response) throws Exception {
        EncryptKokNoResBean bean = new EncryptKokNoResBean();

        int dataCnt = response.getDataCnt();
        if (dataCnt == 0) {
            return null;
        }
        bean.setDataCnt(dataCnt); // データ件数

        UserInfoServiceStub.ArrayOfStructGetEncryptKokNoResponse array = response.getUserArray();
        UserInfoServiceStub.StructGetEncryptKokNoResponse[] struct = array.getItem();

        List<EncryptKokNoResListBean> kokNoList = new ArrayList<EncryptKokNoResListBean>();
        EncryptKokNoResListBean kokNoBean = null;
        for (int i = 0; struct != null && i < struct.length; i++) {
            kokNoBean = new EncryptKokNoResListBean();
            kokNoBean.setRetCd(struct[i].getRetCd()); // 結果コード
            kokNoBean.setReqKokNo(struct[i].getReqKokNo()); // リクエスト顧客No.
            kokNoBean.setKokNo(struct[i].getKokNo()); // 顧客No.
            kokNoList.add(kokNoBean);
        }
        bean.setEncryptKokNoResponse(kokNoList);
        return bean;
    }
}