package aoyama.member.domain.renkei;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import aoyama.member.api.wsdl.UserInfoServiceStub;
import aoyama.member.domain.conf.MyProperty;
import aoyama.member.domain.model.NonMemberUpdateReqBean;
import aoyama.member.domain.model.NonMemberUpdateResBean;

/**
 * 非会員登録に入力された情報を更新するAPI
 * @author nsk_horiuchi
 *
 */
@Component
public class NonMemberUpdateRealRenkei {
    
    // TODO Exception等仮入れの状態
    
    @Autowired
    MyProperty myProp;
    
    @Autowired
    MessageSource messageSource;
    
    private static final Logger logger = LoggerFactory
            .getLogger(NonMemberUpdateRealRenkei.class);
    
    /**
     * 顧客サーバに非会員情報の更新をリクエストし、結果を返す。
     * @param reqBean
     * @return
     * @throws Exception
     */
    public NonMemberUpdateResBean requestNonMemberUpdate(NonMemberUpdateReqBean reqBean) throws Exception {
        
        logger.info("requestNonMemberUpdate - real - START");
        if (reqBean == null) {
            logger.error("NonMemberUpdateReqBeanArray is null");
            throw new Exception("");
        }
     // TODO 本番用もSTG環境へ仮接続
        UserInfoServiceStub stub = null;
        UserInfoServiceStub.SetNonMemberDataRequest snmRequest = null;

        long kokNo = reqBean.getKokNo();

        try {
            // リクエストクラスの生成
            snmRequest = new UserInfoServiceStub.SetNonMemberDataRequest();

            // リクエストに値をセット
            snmRequest.setCorpCode(myProp.getRealRenkeiReqCorpCode());
            snmRequest.setPassword(myProp.getRealRenkeiReqPassword());
            snmRequest.setTestId(myProp.getRealRenkeiReqTestId());
            snmRequest.setGyotaiCd(reqBean.getGyotai());
            snmRequest.setKokNo(kokNo);
            snmRequest.setGyotai(reqBean.getGyotai());
            snmRequest.setTelNo(reqBean.getTelNo());
            if (!reqBean.getEmail().isEmpty()) {
                snmRequest.setEmail(reqBean.getEmail());
            }
            snmRequest.setSei(reqBean.getSei());
            snmRequest.setMei(reqBean.getMei());
            if (!reqBean.getSeiJ().isEmpty()) {
                snmRequest.setSeiJ(reqBean.getSeiJ());
            }
            if (!reqBean.getMeiJ().isEmpty()) {
                snmRequest.setMeiJ(reqBean.getMeiJ());
            }
            snmRequest.setUpdTenCd(reqBean.getUpdTenCd());
            snmRequest.setUpdSyainNo(reqBean.getUpdSyainNo());
            snmRequest.setCrtTenCd(reqBean.getCrtTenCd());
            snmRequest.setCrtSyainNo(reqBean.getCrtSyainNo());
            // 現在日時取得
            Date nowDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
            String formatDate = sdf.format(nowDate);
            snmRequest.setUpdYmd(formatDate.substring(0, 8));
            snmRequest.setUpdHms(formatDate.substring(8, 14));
            snmRequest.setCrtYmd(formatDate.substring(0, 8));
            snmRequest.setCrtHms(formatDate.substring(8, 14));
            
            // リクエストパラメータをログに出力
            outputStructReqKokValue(snmRequest);

            // 顧客情報の照会
            stub = new UserInfoServiceStub();
            // 送信用XML
            UserInfoServiceStub.SetNonMemberData snm = new UserInfoServiceStub.SetNonMemberData();
            snm.setIn0(snmRequest);

            // リアル連携の設定取得
            String waitTime = myProp.getRealRenkeiReqWaitTime();
            String sleepTime = myProp.getRealRenkeiReqSleepTime();
            String timeoutTime = myProp.getRealRenkeiReqTimeOut();

            // 経過時間(開始)
            long beforeTime = (new java.util.Date()).getTime();
            // スリープ処理(ミリ秒)
            if(new Long(sleepTime) > 0){
                Thread.sleep((new Long(sleepTime)).longValue());
            }

            // 顧客サーバへ接続
            UserInfoServiceStub.SetNonMemberDataResponseE nonMemberData = stub.setNonMemberData(snm);

            // 経過時間(終了)
            long afterTime = (new java.util.Date()).getTime();
            // 指定ミリ秒以上経過時のログ出力
            if(new Long(waitTime) > 0){
                if((afterTime - beforeTime) > (new Long(waitTime)).longValue()){
                    logger.warn(messageSource.getMessage("e.ts.co.2001", null, Locale.JAPAN));
                }
            }
            // 指定ミリ秒以上経過時のログ出力（エラー）
            if(new Long(timeoutTime) > 0){
                if((afterTime - beforeTime) > (new Long(timeoutTime)).longValue()){
                    logger.error(messageSource.getMessage("e.ts.co.2001", null, Locale.JAPAN));
                }
            }

            // XMLの受信
            UserInfoServiceStub.SetNonMemberDataResponse nonMemberDataResponse = nonMemberData.getSetNonMemberDataReturn();
            if (nonMemberDataResponse == null) {
                throw new Exception();
            }

            // 非会員情報取得レスポンスBeanを返却
            NonMemberUpdateResBean resBean = makeSetNonMemberDataResBean(nonMemberDataResponse, snmRequest);

            return resBean;
        }
        catch (Exception e) {
            if (e instanceof org.apache.axis2.AxisFault) {
                // 連携先でのエラー
                org.apache.axis2.AxisFault ex = (org.apache.axis2.AxisFault)e;
                String faultCode = "";
                if (ex.getFaultCode() != null) {
                    faultCode = ex.getFaultCode().toString();

                    ////////////////////////////////////////////////////
                    // この会員情報は登録されていません。
                    ////////////////////////////////////////////////////
                    Map<String, Boolean> faultCodeMap = new HashMap<String, Boolean>();
                    faultCodeMap.put("2006", true);
                    faultCodeMap.put("2007", true);
                    faultCodeMap.put("2010", true);
                    faultCodeMap.put("2011", true);
                    if (faultCodeMap.containsKey(faultCode)) {
                        // 2006:顧客No.異常
                        // 2007:該当データなし
                        // 2010:退会済み
                        // 2011:業態コードが顧客基本情報の値と不一致

                        logger.warn(messageSource.getMessage("e.ts.co.4001", new String[] {faultCode, Long.toString(kokNo)}, Locale.JAPAN));
                        throw new Exception();
                    }
                    ////////////////////////////////////////////////////
                    // サーバの接続に失敗しました。
                    ////////////////////////////////////////////////////
                    faultCodeMap = new HashMap<String, Boolean>();
                    faultCodeMap.put("2001", true);
                    faultCodeMap.put("2002", true);
                    faultCodeMap.put("2003", true);
                    faultCodeMap.put("2004", true);
                    faultCodeMap.put("2005", true);
                    if (faultCodeMap.containsKey(faultCode)) {
                        // 2001:数値チェック、日付チェック不整合
                        // 2002:提携企業コード異常
                        // 2003:提携企業パスワード異常
                        // 2004:試験ID異常
                        // 2005:業態異常
                        logger.error(messageSource.getMessage("e.ts.co.4002", new String[] {faultCode}, Locale.JAPAN), e);
                        outputReqConfValue(snmRequest);
                        throw new Exception();
                    }
                    ////////////////////////////////////////////////////
                    // 処理中にエラーが発生しました。
                    ////////////////////////////////////////////////////
                    logger.error(messageSource.getMessage("e.ts.co.3001", new String[] {faultCode}, Locale.JAPAN), e);
                    outputReqConfValue(snmRequest);
                    throw new Exception();
                }
                logger.error("処理中にエラーが発生しました。", e);
                throw new Exception();
            }
            else {
                // 顧客カルテ内部処理エラー
                logger.error("internal error", e);
                throw new Exception();
            }
        }
        finally {
            // stubのクリンナップ
            try {
                stub._getServiceClient().cleanup();
                stub.cleanup();
            } catch (Throwable t) {
            }
            logger.info("requestSetUserInfoWebArray - real - END");
        }
    }
    
    /**
     * 非会員情報更新レスポンスBeanを作成する。
     * @param prop CSaProperties
     * @param measureringInfoResponse メジャーリング情報更新レスポンス
     * @return メジャーリング情報更新レスポンスBean
     * @throws Exception
     */
    private NonMemberUpdateResBean makeSetNonMemberDataResBean(UserInfoServiceStub.SetNonMemberDataResponse nonMemberDataResponse, UserInfoServiceStub.SetNonMemberDataRequest smiRequest) throws Exception {

        // メジャーリング情報更新レスポンスをBeanにセット

        // 顧客サーバからの値をそのままセット
        NonMemberUpdateResBean beanData = new NonMemberUpdateResBean();
        beanData.setKokNo(nonMemberDataResponse.getKokNo());
        beanData.setUpdYmd(nonMemberDataResponse.getUpdYmd());
        beanData.setUpdHms(nonMemberDataResponse.getUpdHms());
        
        return beanData;
    }
    
    /**
     * リクエストにセットした設定ファイルから取得している値をログに出力する。
     * @param smiRequest メジャーリング情報更新リクエスト
     */

    private void outputReqConfValue(UserInfoServiceStub.SetNonMemberDataRequest smiRequest) {
        logger.warn("request - 提携企業コード [" + smiRequest.getCorpCode() + "]");
        logger.warn("request - 提携企業パスワード [" + smiRequest.getPassword() + "]");
        logger.warn("request - 試験ID [" + smiRequest.getTestId() + "]");
        logger.warn("request - 業態 [" + smiRequest.getGyotaiCd() + "]");
        logger.warn("request - 顧客No. [" + smiRequest.getKokNo() + "]");
    }
    
    /**
     * リクエストにセットした顧客カルテの値をログに出力する。
     * @param request メジャーリング情報更新リクエスト
     */
     private void outputStructReqKokValue(UserInfoServiceStub.SetNonMemberDataRequest request) {
         
        logger.info("request - 提携企業コード [" + request.getCorpCode() + "]");
        logger.info("request - 提携企業パスワード [" + request.getPassword() + "]");
        logger.info("request - 試験ID [" + request.getTestId() + "]");
        logger.info("request - 業態 [" + request.getGyotaiCd() + "]");
        logger.info("request - 顧客No. [" + request.getKokNo() + "]");
        logger.info("request - 更新店舗コード[" + request.getUpdTenCd() + "]");
        logger.info("request - 更新社員コード[" + request.getUpdSyainNo() + "]");
        logger.info("request - 更新日 [" + request.getUpdYmd() + "]");
        logger.info("request - 更新時刻 [" + request.getUpdHms() + "]");
    }
}
