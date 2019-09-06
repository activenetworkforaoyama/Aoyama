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
import aoyama.member.domain.model.KarteUpdateReqBean;
import aoyama.member.domain.model.KarteUpdateResBean;

/**
 * 顧客カルテに入力された情報を更新するAPI
 * @author nsk_horiuchi
 *
 */
@Component
public class KarteUpdateRealRenkei {
    
    // TODO Exception等仮入れの状態
    
    @Autowired
    MyProperty myProp;
    
    @Autowired
    MessageSource messageSource;
    
    private static final Logger logger = LoggerFactory
            .getLogger(KarteUpdateRealRenkei.class);
    
    /**
     * 顧客サーバに顧客情報の更新をリクエストし、結果を返す。
     * @param reqBean
     * @return
     * @throws Exception
     */
    public KarteUpdateResBean requestKarteUpdate(KarteUpdateReqBean reqBean) throws Exception {
        
        logger.info("requestKarteUpdate - real - START");
        if (reqBean == null) {
            logger.error("KarteUpdateReqBeanArray is null");
            throw new Exception("");
        }

        UserInfoServiceStub stub = null;
        UserInfoServiceStub.SetMeasureringInfoRequest smiRequest = null;
        long kokNo = reqBean.getKokNo();

        try {
            // リクエストクラスの生成
            smiRequest = new UserInfoServiceStub.SetMeasureringInfoRequest();

            // リクエストに値をセット
            smiRequest.setCorpCode(myProp.getRealRenkeiReqCorpCode());
            smiRequest.setPassword(myProp.getRealRenkeiReqPassword());
            smiRequest.setTestId(myProp.getRealRenkeiReqTestId());
            smiRequest.setGyotaiCd(reqBean.getGyotaiCd());
            smiRequest.setKokNo(kokNo);
            smiRequest.setSize01(reqBean.getSize01());
            smiRequest.setSize02(reqBean.getSize02());
            smiRequest.setSize03(reqBean.getSize03());
            smiRequest.setSize04(reqBean.getSize04());
            smiRequest.setSize05(reqBean.getSize05());
            smiRequest.setSize06(reqBean.getSize06());
            smiRequest.setSize07(reqBean.getSize07());
            smiRequest.setSize08(reqBean.getSize08());
            smiRequest.setSize09(reqBean.getSize09());
            smiRequest.setSize10(reqBean.getSize10());
            smiRequest.setSize11(reqBean.getSize11());
            smiRequest.setSize12(reqBean.getSize12());
            smiRequest.setSize13(reqBean.getSize13());
            smiRequest.setSize14(reqBean.getSize14());
            smiRequest.setSize15(reqBean.getSize15());
            smiRequest.setSize16(reqBean.getSize16());
            smiRequest.setSize17(reqBean.getSize17());
            smiRequest.setSize18(reqBean.getSize18());
            smiRequest.setSize19(reqBean.getSize19());
            smiRequest.setSize20(reqBean.getSize20());
            smiRequest.setBiko01(reqBean.getBiko01());
            smiRequest.setBiko02(reqBean.getBiko02());
            smiRequest.setBiko03(reqBean.getBiko03());
            smiRequest.setUpdTenCd(reqBean.getUpdTenCd());
            smiRequest.setUpdSyainNo(reqBean.getUpdSyainNo());
            // 現在日時取得
            Date nowDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
            String formatDate = sdf.format(nowDate);
            smiRequest.setUpdYmd(formatDate.substring(0, 8));
            smiRequest.setUpdHms(formatDate.substring(8, 14));
            smiRequest.setSizeUpdYmd(formatDate.substring(0, 8));
            
            // リクエストパラメータをログに出力
            outputStructReqKokValue(smiRequest);

            // 顧客情報の照会
            stub = new UserInfoServiceStub();
            // 送信用XML
            UserInfoServiceStub.SetMeasureringInfo smi = new UserInfoServiceStub.SetMeasureringInfo();
            smi.setIn0(smiRequest);

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
            UserInfoServiceStub.SetMeasureringInfoResponseE measureringInfo = stub.setMeasureringInfo(smi);

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
            UserInfoServiceStub.SetMeasureringInfoResponse measureringInfoResponse = measureringInfo.getSetMeasureringInfoReturn();
            if (measureringInfoResponse == null) {
                throw new Exception();
            }

            // 顧客情報取得レスポンスBeanを返却
            KarteUpdateResBean resBean = makeSetMeasureringInfoResBean(measureringInfoResponse, smiRequest);

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
                        outputReqConfValue(smiRequest);
                        throw new Exception();
                    }
                    ////////////////////////////////////////////////////
                    // 処理中にエラーが発生しました。
                    ////////////////////////////////////////////////////
                    logger.error(messageSource.getMessage("e.ts.co.3001", new String[] {faultCode}, Locale.JAPAN), e);
                    outputReqConfValue(smiRequest);
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
     * メジャーリング情報更新レスポンスBeanを作成する。
     * @param prop CSaProperties
     * @param measureringInfoResponse メジャーリング情報更新レスポンス
     * @return メジャーリング情報更新レスポンスBean
     * @throws Exception
     */
    private KarteUpdateResBean makeSetMeasureringInfoResBean(UserInfoServiceStub.SetMeasureringInfoResponse measureringInfoResponse, UserInfoServiceStub.SetMeasureringInfoRequest smiRequest) throws Exception {

        // メジャーリング情報更新レスポンスをBeanにセット

        // 顧客サーバからの値をそのままセット
        KarteUpdateResBean beanData = new KarteUpdateResBean();
        beanData.setKokNo(measureringInfoResponse.getKokNo());
        beanData.setUpdYmd(measureringInfoResponse.getUpdYmd());
        beanData.setUpdHms(measureringInfoResponse.getUpdHms());
        
        return beanData;
    }
    
    /**
     * リクエストにセットした設定ファイルから取得している値をログに出力する。
     * @param smiRequest メジャーリング情報更新リクエスト
     */

    private void outputReqConfValue(UserInfoServiceStub.SetMeasureringInfoRequest smiRequest) {
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
     private void outputStructReqKokValue(UserInfoServiceStub.SetMeasureringInfoRequest request) {
         
        logger.info("request - 提携企業コード [" + request.getCorpCode() + "]");
        logger.info("request - 提携企業パスワード [" + request.getPassword() + "]");
        logger.info("request - 試験ID [" + request.getTestId() + "]");
        logger.info("request - 業態 [" + request.getGyotaiCd() + "]");
        logger.info("request - 顧客No. [" + request.getKokNo() + "]");
        logger.info("request - サイズ01(フルレングス) [" + request.getSize01() + "]");
        logger.info("request - サイズ02(ショルダー) [" + request.getSize02() + "]");
        logger.info("request - サイズ03(リーチ（右）) [" + request.getSize03() + "]");
        logger.info("request - サイズ04(リーチ（左）) [" + request.getSize04() + "]");
        logger.info("request - サイズ05(アウトバスト) [" + request.getSize05() + "]");
        logger.info("request - サイズ06(バスト) [" + request.getSize06() + "]");
        logger.info("request - サイズ07(JKウエスト) [" + request.getSize07() + "]");
        logger.info("request - サイズ08(PTウエスト) [" + request.getSize08() + "]");
        logger.info("request - サイズ09(ヒップ) [" + request.getSize09() + "]");
        logger.info("request - サイズ10(ワタリ（右）) [" + request.getSize10() + "]");
        logger.info("request - サイズ11(ワタリ（左）) [" + request.getSize11() + "]");
        logger.info("request - サイズ12(ふくらはぎ（右）) [" + request.getSize12() + "]");
        logger.info("request - サイズ13(ふくらはぎ（左）) [" + request.getSize13() + "]");
        logger.info("request - サイズ14(ネック) [" + request.getSize14() + "]");
        logger.info("request - サイズ15 [" + request.getSize15() + "]");
        logger.info("request - サイズ16 [" + request.getSize16() + "]");
        logger.info("request - サイズ17 [" + request.getSize17() + "]");
        logger.info("request - サイズ18 [" + request.getSize18() + "]");
        logger.info("request - サイズ19 [" + request.getSize19() + "]");
        logger.info("request - サイズ20 [" + request.getSize20() + "]");
        logger.info("request - サイズ更新日 [" + request.getSizeUpdYmd() + "]");
        logger.info("request - 備考01 [" + request.getBiko01() + "]");
        logger.info("request - 備考02[" + request.getBiko02() + "]");
        logger.info("request - 備考03 [" + request.getBiko03() + "]");
        logger.info("request - 更新店舗コード[" + request.getUpdTenCd() + "]");
        logger.info("request - 更新社員コード[" + request.getUpdSyainNo() + "]");
        logger.info("request - 更新日 [" + request.getUpdYmd() + "]");
        logger.info("request - 更新時刻 [" + request.getUpdHms() + "]");
    }
}
