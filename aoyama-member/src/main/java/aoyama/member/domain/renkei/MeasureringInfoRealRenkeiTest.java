package aoyama.member.domain.renkei;

import aoyama.member.api.wsdl_test.UserInfoServiceStubTest;
import aoyama.member.domain.conf.MyProperty;
import aoyama.member.domain.model.MeasureringInfoReqBean;
import aoyama.member.domain.model.MeasureringInfoResBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * ポイント情報参照WEBサービス処理を行います。
 */
@Component
public class MeasureringInfoRealRenkeiTest {
    
    @Autowired
    MyProperty myProp;
    
    @Autowired
    MessageSource messageSource;
    
    private static final Logger logger = LoggerFactory
            .getLogger(MeasureringInfoRealRenkeiTest.class);

    /**
     * WEBサービスからポイント情報を取得し、返します。
     * @param   prop             CSaProperties
     * @param   reqBean          ポイント情報参照リクエストbean
     * @return  MeasureringInfoResBean　ポイント情報参照レスポンスbean
     */
    public MeasureringInfoResBean requestGetMeasureringInfo(MeasureringInfoReqBean reqBean, int gyotaiCd) throws Exception {
        logger.info("requestGetMeasureringInfo - real - START");
        if (reqBean == null) {
            logger.error("MeasureringInfoReqBean is null");
            throw new Exception();
        }

        UserInfoServiceStubTest stub = null;
        UserInfoServiceStubTest.GetMeasureringInfoRequest gmiRequest = null;
        long kokNo = 0;
        try {
            // リクエストクラスの生成
            gmiRequest = new UserInfoServiceStubTest.GetMeasureringInfoRequest();
            // リクエストに値をセット
            gmiRequest.setCorpCode(myProp.getRealRenkeiReqCorpCode()); // 提携企業コード
            gmiRequest.setPassword(myProp.getRealRenkeiReqPassword()); // 提携企業パスワード
            gmiRequest.setTestId(myProp.getRealRenkeiReqTestId()); // 試験ID
            gmiRequest.setGyotaiCd(gyotaiCd); // 業態
            kokNo = reqBean.getKokNo();
            gmiRequest.setKokNo(kokNo); // 顧客No

            // メジャーリング情報の照会
            stub = new UserInfoServiceStubTest();
            // 送信用XML
            UserInfoServiceStubTest.GetMeasureringInfo gmi = new UserInfoServiceStubTest.GetMeasureringInfo();
            gmi.setIn0(gmiRequest);

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
            UserInfoServiceStubTest.GetMeasureringInfoResponseE measureringInfo = stub.getMeasureringInfo(gmi);

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
            UserInfoServiceStubTest.GetMeasureringInfoResponse measureringInfoResponse = measureringInfo.getGetMeasureringInfoReturn();
            if (measureringInfoResponse == null) {
                throw new Exception();
            }
            return makeMeasureringInfoResBean(measureringInfoResponse);

        } catch (Exception e) {
            if (e instanceof org.apache.axis2.AxisFault) {
                // 連携先でのエラー
                org.apache.axis2.AxisFault ex = (org.apache.axis2.AxisFault)e;
                String faultCode = null;
                if (ex.getFaultCode() != null) {
                    faultCode = ex.getFaultCode().toString();
                    
                    logger.warn("リクエストに設定した内容およびレスポンスのエラー内容を調査してください。");
                    Map<String, Boolean> faultCodeMap = new HashMap<String, Boolean>();
                    
                    faultCodeMap.put("2001", true);
                    faultCodeMap.put("2002", true);
                    faultCodeMap.put("2003", true);
                    faultCodeMap.put("2004", true);
                    faultCodeMap.put("2005", true);
                    faultCodeMap.put("2006", true);
                    faultCodeMap.put("2007", true);
                    faultCodeMap.put("2010", true);
                    faultCodeMap.put("2011", true);
                    
                    if (faultCodeMap.containsKey(faultCode)) {
                        // 2001:数値チェック、日付チェック不整合
                        // 2002:提携企業コード異常
                        // 2003:提携企業パスワード異常
                        // 2004:試験ID異常
                        // 2005:業態異常
                        // 2006:顧客No.異常
                        // 2007:該当データなし
                        // 2010:退会済み顧客
                        // 2011:業態コードが顧客基本情報の値と不一致
                        logger.warn(messageSource.getMessage("e.ts.co.4001", new String[] {faultCode, Long.toString(kokNo)}, Locale.JAPAN));
                        outputReqConfValue(gmiRequest);
                        throw new Exception();
                    }
                }
                logger.error(messageSource.getMessage("e.ts.co.3001", new String[] {faultCode}, Locale.JAPAN), e);
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
            logger.info("requestGetMeasureringInfo - real - END");
        }
    }

    /**
     * 顧客サーバからの値をMeasureringInfoResBeanにセットします。
     * @param   measureringResponse ポイント情報
     * @return  MeasureringInfoResBean
     */
    private MeasureringInfoResBean makeMeasureringInfoResBean(UserInfoServiceStubTest.GetMeasureringInfoResponse measureringResponse) throws Exception {
        
        MeasureringInfoResBean bean = new MeasureringInfoResBean();
        bean.setSize01(isNanCheck(measureringResponse.getSize01())); // サイズ01
        bean.setSize02(isNanCheck(measureringResponse.getSize02())); // サイズ02
        bean.setSize03(isNanCheck(measureringResponse.getSize03())); // サイズ03
        bean.setSize04(isNanCheck(measureringResponse.getSize04())); // サイズ04
        bean.setSize05(isNanCheck(measureringResponse.getSize05())); // サイズ05
        bean.setSize06(isNanCheck(measureringResponse.getSize06())); // サイズ06
        bean.setSize07(isNanCheck(measureringResponse.getSize07())); // サイズ07
        bean.setSize08(isNanCheck(measureringResponse.getSize08())); // サイズ08
        bean.setSize09(isNanCheck(measureringResponse.getSize09())); // サイズ09
        bean.setSize10(isNanCheck(measureringResponse.getSize10())); // サイズ10
        bean.setSize11(isNanCheck(measureringResponse.getSize11())); // サイズ11
        bean.setSize12(isNanCheck(measureringResponse.getSize12())); // サイズ12
        bean.setSize13(isNanCheck(measureringResponse.getSize13())); // サイズ13
        bean.setSize14(isNanCheck(measureringResponse.getSize14())); // サイズ14
        bean.setSize15(isNanCheck(measureringResponse.getSize15())); // サイズ15
        bean.setSize16(isNanCheck(measureringResponse.getSize16())); // サイズ16
        bean.setSize17(isNanCheck(measureringResponse.getSize17())); // サイズ17
        bean.setSize18(isNanCheck(measureringResponse.getSize18())); // サイズ18
        bean.setSize19(isNanCheck(measureringResponse.getSize19())); // サイズ19
        bean.setSize20(isNanCheck(measureringResponse.getSize20())); // サイズ20
        if (measureringResponse.getSizeUpdYmd() == null || measureringResponse.getSizeUpdYmd().equals("")) {
            // 現在日時を設定
            Date nowDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String formatDate = sdf.format(nowDate);
            bean.setSizeUpdYmd(formatDate); // サイズ更新日
        } else {
            bean.setSizeUpdYmd(measureringResponse.getSizeUpdYmd()); // サイズ更新日
        }
        bean.setBiko01(measureringResponse.getBiko01()); // 備考01
        bean.setBiko02(measureringResponse.getBiko02()); // 備考02
        bean.setBiko03(measureringResponse.getBiko03()); // 備考03
        
        return bean;
    }
    
    /**
     * 引数の値がNaNならば0を返す。
     * NaNでなければ引数をそのまま返す。
     * @param d
     * @return
     */
    private double isNanCheck(double d) {
        
        if (Double.isNaN(d)) {
            return 0;
        } else {
            return d;
        }
    }
    
    /**
     * リクエストにセットした設定ファイルから取得している値をログに出力する。
     * @param gudRequest 顧客情報取得リクエスト
     */
    private void outputReqConfValue(UserInfoServiceStubTest.GetMeasureringInfoRequest gmiRequest) {

        logger.warn("request - 提携企業コード [" + gmiRequest.getCorpCode() + "]");
        logger.warn("request - 提携企業パスワード [" + gmiRequest.getPassword() + "]");
        logger.warn("request - 試験ID [" + gmiRequest.getTestId() + "]");
        logger.warn("request - 業態 [" + gmiRequest.getGyotaiCd() + "]");
        logger.warn("request - 顧客No. [" + gmiRequest.getKokNo() + "]");
    }
}