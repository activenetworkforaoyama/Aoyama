package aoyama.member.domain.renkei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import aoyama.member.api.wsdl.UserInfoServiceStub;
import aoyama.member.domain.conf.MyProperty;
import aoyama.member.domain.model.DecryptKokNoReqBean;
import aoyama.member.domain.model.DecryptKokNoReqListBean;
import aoyama.member.domain.model.DecryptKokNoResBean;
import aoyama.member.domain.model.DecryptKokNoResListBean;
import aoyama.member.domain.model.EncryptKokNoResListBean;
import aoyama.member.domain.model.NonMemberDataReqBean;
import aoyama.member.domain.model.NonMemberDataResBean;
import aoyama.member.domain.model.NonMemberDataResListBean;
import aoyama.member.domain.renkei.RealRenkei;
import aoyama.member.domain.renkei.RealRenkeiStub;

/**
 * 非会員情報取得WEBサービス処理を行います。
 */
@Component
public class NonMemberDataRealRenkei  {
    
    @Autowired
    MyProperty myProp;
    
    @Autowired
    MessageSource messageSource;
    
    @Autowired
    RealRenkei realRenkei;

    @Autowired
    RealRenkeiStub realRenkeiStub;
    
    private static final Logger logger = LoggerFactory
            .getLogger(NonMemberDataRealRenkei.class);

    /**
     * 顧客サーバから非会員情報を取得する。
     * @param   reqBean         非会員情報取得リクエストbean
     * @return  NonMemberDataResBean 非会員情報取得レスポンスbean
     */
    public NonMemberDataResBean requestGetNonMemberData(NonMemberDataReqBean reqBean) throws Exception {

        logger.info("requestGetNonMemberDataRequest - real - START");
        if (reqBean == null) {
            logger.error("NonMemberDataReqBean is null");
            throw new Exception();
        }
        UserInfoServiceStub stub = null;
        UserInfoServiceStub.GetNonMemberDataRequest gupaRequest = null;
        long kokNo = 0;  // 13桁の会員番号
        String strKokNo = String.valueOf(reqBean.getKokNo());
        if ((strKokNo.length() == 13) && (strKokNo.charAt(0) == '7')) {
        	kokNo = reqBean.getKokNo();
        }
        String telNo = reqBean.getTelNo();
        String sei = reqBean.getSei();
        String mei = reqBean.getMei();
        int gyotai = reqBean.getGyotai();

        try {
            // リクエストクラスの生成
            gupaRequest = new UserInfoServiceStub.GetNonMemberDataRequest();

            // リクエストに値をセット
            gupaRequest.setCorpCode(myProp.getRealRenkeiReqCorpCode());  // 提携企業コード
            gupaRequest.setPassword(myProp.getRealRenkeiReqPassword());  // 提携企業パスワード
            gupaRequest.setTestId(myProp.getRealRenkeiReqTestId());      // 試験ID
//            gupaRequest.setGyotaiCd(myProp.getRealRenkeiReqGyotaiCd());  // 業態
            gupaRequest.setGyotaiCd(gyotai);  // 業態
            if(kokNo != 0) {
                gupaRequest.setKokNo(kokNo); // 顧客No.
            } else {
                gupaRequest.setKokNo(java.lang.Long.MIN_VALUE); // 顧客No.
                gupaRequest.setTelNo(telNo); // 電話番号
                gupaRequest.setSei(sei); // 姓（カナ）
                gupaRequest.setMei(mei); // 名（カナ）
            }
            
            logger.debug("提携企業コード:" + gupaRequest.getCorpCode());
            logger.debug("提携企業パスワード:" + gupaRequest.getPassword());
            logger.debug("試験ID:" + gupaRequest.getTestId());
            logger.debug("業態:" + gupaRequest.getGyotaiCd());
            logger.debug("顧客No:" + gupaRequest.getKokNo());
            logger.debug("電話番号:" + gupaRequest.getTelNo());
            logger.debug("姓（カナ）:" + gupaRequest.getSei());
            logger.debug("名（カナ）:" + gupaRequest.getMei());

            // 非会員情報の照会
            stub = new UserInfoServiceStub();
            // 送信用XML
            UserInfoServiceStub.GetNonMemberData gupa = new UserInfoServiceStub.GetNonMemberData();
            gupa.setIn0(gupaRequest);

            // リアル連携の設定取得
            String waitTime = myProp.getRealRenkeiReqWaitTime();
            String sleepTime = myProp.getRealRenkeiReqSleepTime();
            String timeoutTime = myProp.getRealRenkeiReqTimeOut();

            // 経過時間(開始)
            long beforeTime = (new java.util.Date()).getTime();
            // スリープ処理(ミリ秒)
            Thread.sleep((new Long(sleepTime)).longValue());

            // 顧客サーバへ接続
            UserInfoServiceStub.GetNonMemberDataResponseE nonMemberData = stub.getNonMemberData(gupa);

            // 経過時間(終了)
            long afterTime = (new java.util.Date()).getTime();
            // 指定ミリ秒以上経過時のログ出力
            if((afterTime - beforeTime) > (new Long(waitTime)).longValue()){
                logger.warn(messageSource.getMessage("e.ts.co.2001", null, Locale.JAPAN));
            }
            // 指定ミリ秒以上経過時のログ出力（エラー）
            if((afterTime - beforeTime) > (new Long(timeoutTime)).longValue()){
                logger.error(messageSource.getMessage("e.ts.co.2001", null, Locale.JAPAN));
            }

            // XMLの受信
            UserInfoServiceStub.GetNonMemberDataResponse nonMemberDataResponse = nonMemberData.getGetNonMemberDataReturn();
            if (nonMemberDataResponse == null) {
                throw new Exception();
            }

            // 非会員情報取得レスポンスBeanを返却
            NonMemberDataResBean resBean = makeNonMemberDataResBean(nonMemberDataResponse,reqBean.getGyotai());

            return resBean;
        }
        catch (Exception e) {
            if (e instanceof org.apache.axis2.AxisFault) {
                // 連携先でのエラー
                org.apache.axis2.AxisFault ex = (org.apache.axis2.AxisFault)e;
                String faultCode = "";
                if (ex.getFaultCode() != null) {
                    faultCode = ex.getFaultCode().toString();

                    logger.warn("リクエストに設定した内容およびレスポンスのエラー内容を調査してください。");
                    Map<String, Boolean> faultCodeMap = new HashMap<String, Boolean>();

                    ////////////////////////////////////////////////////
                    // この会員情報は登録されていません。
                    ////////////////////////////////////////////////////
                    faultCodeMap.put("2001", true);
                    faultCodeMap.put("2006", true);
                    faultCodeMap.put("2007", true);
                    faultCodeMap.put("2008", true);
                    faultCodeMap.put("2009", true);
                    faultCodeMap.put("2010", true);
                    faultCodeMap.put("2012", true);
                    faultCodeMap.put("2013", true);
                    faultCodeMap.put("2014", true);
                    if (faultCodeMap.containsKey(faultCode)) {
                        // 2001:数値チェック、日付チェック不整合
                        // 2006:顧客番号異常
                        // 2007:該当データなし
                        // 2008:電話番号が一致しない
                        // 2009:生月日が一致しない
                        // 2010:退会済顧客
                        // 2012:PCサイトログインパスワードが一致しない
                        // 2013:携帯サイトログインパスワードが一致しない
                        // 2014:WEB顧客パスワード（TSC）が一致しない

                        logger.warn(messageSource.getMessage("e.ts.co.4001", new String[] {faultCode, Long.toString(kokNo)}, Locale.JAPAN));
                        outputReqConfValue(gupaRequest);
                        outputReqKokValue(gupaRequest);
                        throw new Exception();
                    }
                    ////////////////////////////////////////////////////
                    // サーバの接続に失敗しました。
                    ////////////////////////////////////////////////////
                    faultCodeMap = new HashMap<String, Boolean>();
                    faultCodeMap.put("2002", true);
                    faultCodeMap.put("2003", true);
                    faultCodeMap.put("2004", true);
                    faultCodeMap.put("2005", true);
                    faultCodeMap.put("2011", true);
                    if (faultCodeMap.containsKey(faultCode)) {
                        // 2002:提携企業コード異常
                        // 2003:提携企業パスワード異常
                        // 2004:試験ID異常
                        // 2005:業態異常
                        // 2011:業態コードが顧客基本情報の値と不一致

                        logger.error(messageSource.getMessage("e.ts.co.4002", new String[] {faultCode}, Locale.JAPAN), e);
                        outputReqConfValue(gupaRequest);
                        throw new Exception();
                    }
                    ////////////////////////////////////////////////////
                    // 処理中にエラーが発生しました。
                    ////////////////////////////////////////////////////
                    logger.error(messageSource.getMessage("e.ts.co.3001", new String[] {faultCode}, Locale.JAPAN), e);
                    outputReqConfValue(gupaRequest);
                    outputReqKokValue(gupaRequest);
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
            logger.info("requestGetNonMemberDataRequest - real - END");
        }
    }

    /**
     * リクエストにセットした設定ファイルから取得している値をログに出力する。
     * @param gupaRequest 非会員情報取得リクエスト
     */
    private void outputReqConfValue(UserInfoServiceStub.GetNonMemberDataRequest gupaRequest) {

        logger.warn("request - 連携企業コード [" + gupaRequest.getCorpCode() + "]");
        logger.warn("request - 連携企業パスワード [" + gupaRequest.getPassword() + "]");
        logger.warn("request - 試験ID [" + gupaRequest.getTestId() + "]");
        logger.warn("request - 業態 [" + gupaRequest.getGyotaiCd() + "]");
    }

    /**
     * リクエストにセットした個人情報の値をログに出力する。<br />
     * ※本番環境では、[WARN]レベル以上が出力対象のため、出力されない。<br />
     * ※調査の際には、リアル連携ログの出力レベルを下げることで、調査を可能にする。
     * @param gupaRequest 非会員情報取得リクエスト
     */
    private void outputReqKokValue(UserInfoServiceStub.GetNonMemberDataRequest gupaRequest) {

        logger.info("request - 顧客No. [" + gupaRequest.getKokNo() + "]");
        logger.info("request - 電話番号 [" + gupaRequest.getTelNo() + "]");
        logger.info("request - 姓（カナ） [" + gupaRequest.getSei() + "]");
        logger.info("request - 名（カナ） [" + gupaRequest.getMei() + "]");
    }

    /**
     * 非会員情報取得レスポンスの値を、返却用非会員情報取得レスポンスBeanにセットします。
     * @param nonMemberDataResponse 非会員情報取得レスポンス
     * @return 非会員情報取得レスポンスBean
     * @throws Exception
     */
    private NonMemberDataResBean makeNonMemberDataResBean(UserInfoServiceStub.GetNonMemberDataResponse nonMemberDataResponse, int gyotai) throws Exception {
        // 非会員情報取得レスポンス
        NonMemberDataResBean bean = new NonMemberDataResBean();
        
        int dataCnt = nonMemberDataResponse.getDataCnt();
        if (dataCnt == 0) {
            return null;
        }
        bean.setDataCnt(dataCnt); // データ件数

        UserInfoServiceStub.ArrayOfStructGetNonMemberDataResponse  array = nonMemberDataResponse.getUserArray();
        UserInfoServiceStub.StructGetNonMemberDataResponse[] struct = array.getItem();

        // 顧客No非トークン化Bean作成
        DecryptKokNoReqBean decReqBean = new DecryptKokNoReqBean();
        List<DecryptKokNoReqListBean> decReqList = new ArrayList<DecryptKokNoReqListBean>();

        for (int i = 0; struct != null && i < struct.length; i++) {
            DecryptKokNoReqListBean decReqListBean = new DecryptKokNoReqListBean();
        	decReqListBean.setKokNo(struct[i].getKokNo());
            decReqList.add(decReqListBean);
        }
        decReqBean.setDecryptKokNoRequest(decReqList);
        // 顧客No非トークン化WEBサービス処理実行
        DecryptKokNoResBean decResBean = new DecryptKokNoResBean();
        try {
            
            // スタブを使用する
            if (myProp.getLocalTestStubUseFlg()) {
                decResBean= realRenkeiStub.getDecryptKokNo(decReqBean);
            } else {
                decResBean= realRenkei.getDecryptKokNo(decReqBean, gyotai);
            }
            
            if (decResBean.getDataCnt() <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            
            // 顧客Noトークン化中にエラーが発生した場合はnullを返す
            e.printStackTrace();
            return null;
        }

        List<NonMemberDataResListBean> nonMemberList = new ArrayList<NonMemberDataResListBean>();
        List<DecryptKokNoResListBean> decResBeanList = decResBean.getDecryptKokNoResponse();

        NonMemberDataResListBean nonMemberBean = null;
        for (int i = 0; struct != null && i < struct.length; i++) {
        	nonMemberBean = new NonMemberDataResListBean();
            DecryptKokNoResListBean eknResBeanDtl = decResBeanList.get(i);
        	nonMemberBean.setKokno(eknResBeanDtl.getKokNo());
        	nonMemberBean.setTelno(struct[i].getTelNo());
        	nonMemberBean.setEmail(struct[i].getEmail());
        	nonMemberBean.setSeij(struct[i].getSeiJ());
        	nonMemberBean.setMeij(struct[i].getMeiJ());
        	nonMemberBean.setTelno(struct[i].getTelNo());
        	nonMemberBean.setSei(struct[i].getSei());
        	nonMemberBean.setMei(struct[i].getMei());
        	nonMemberBean.setUpdymd(struct[i].getUpdYmd());
        	nonMemberBean.setUpdhms(struct[i].getUpdHms());

        	nonMemberList.add(nonMemberBean);
        }
        bean.setNonMemberDataResponse(nonMemberList);
        return bean;
    }
}
