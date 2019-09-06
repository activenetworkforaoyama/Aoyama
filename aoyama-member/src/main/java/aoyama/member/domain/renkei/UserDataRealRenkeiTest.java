package aoyama.member.domain.renkei;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import aoyama.member.api.wsdl_test.UserInfoServiceStubTest;
import aoyama.member.domain.conf.MyProperty;
import aoyama.member.domain.model.UserDataReqBean;
import aoyama.member.domain.model.UserDataResBean;

/**
 * 顧客情報取得WEBサービス処理を行います。
 */
@Component
public class UserDataRealRenkeiTest  {
    
    @Autowired
    MyProperty myProp;
    
    @Autowired
    MessageSource messageSource;
    
    private static final Logger logger = LoggerFactory
            .getLogger(UserDataRealRenkeiTest.class);

    /**
     * 顧客サーバから顧客情報を取得する。
     * @param   reqBean         顧客情報取得リクエストbean
     * @return  UserDataResBean 顧客情報取得レスポンスbean
     */
    public UserDataResBean requestGetUserPointArray(UserDataReqBean reqBean, int gyotaiCd) throws Exception {

        logger.info("requestGetUserPointArray - real - START");
        if (reqBean == null) {
            logger.error("UserDataReqBean is null");
            throw new Exception();
        }

        UserInfoServiceStubTest stub = null;
        UserInfoServiceStubTest.GetUserPointArrayRequest gupaRequest = null;
        long kokNo = reqBean.getKokNo();  // 13桁の会員番号

        try {
            // リクエストクラスの生成
            gupaRequest = new UserInfoServiceStubTest.GetUserPointArrayRequest();

            // リクエストに値をセット
            gupaRequest.setCorpCode(myProp.getRealRenkeiReqCorpCode());  // 提携企業コード
            gupaRequest.setPassword(myProp.getRealRenkeiReqPassword());  // 提携企業パスワード
            gupaRequest.setTestId(myProp.getRealRenkeiReqTestId());      // 試験ID
//            gupaRequest.setGyotaiCd(myProp.getRealRenkeiReqGyotaiCd());  // 業態
            gupaRequest.setGyotaiCd(gyotaiCd);  // 業態
            gupaRequest.setTenCd(myProp.getRealRenkeiReqTenCd()); // 店舗コード
            gupaRequest.setPosNo(myProp.getRealRenkeiReqPosNo()); // POSNo.
            gupaRequest.setKokNo(kokNo); // 顧客No.
            gupaRequest.setTelNo(""); // 電話番号
            logger.debug("提携企業コード:" + gupaRequest.getCorpCode());
            logger.debug("提携企業パスワード:" + gupaRequest.getPassword());
            logger.debug("試験ID:" + gupaRequest.getTestId());
            logger.debug("業態:" + gupaRequest.getGyotaiCd());
            logger.debug("店舗コード:" + gupaRequest.getTenCd());
            logger.debug("POSNo:" + gupaRequest.getPosNo());
            logger.debug("顧客No:" + gupaRequest.getKokNo());
            logger.debug("電話番号:" + gupaRequest.getTelNo());

            // 顧客情報の照会
            stub = new UserInfoServiceStubTest();
            // 送信用XML
            UserInfoServiceStubTest.GetUserPointArray gupa = new UserInfoServiceStubTest.GetUserPointArray();
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
            UserInfoServiceStubTest.GetUserPointArrayResponseE userData = stub.getUserPointArray(gupa);

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
            UserInfoServiceStubTest.GetUserPointArrayResponse userDataResponse = userData.getGetUserPointArrayReturn();
            if (userDataResponse == null) {
                throw new Exception();
            }

            // 顧客情報取得レスポンスBeanを返却
            UserDataResBean resBean = makeUserDataResBean(userDataResponse);

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
            logger.info("requestGetUserPointArray - real - END");
        }
    }

    /**
     * リクエストにセットした設定ファイルから取得している値をログに出力する。
     * @param gupaRequest 顧客情報取得リクエスト
     */
    private void outputReqConfValue(UserInfoServiceStubTest.GetUserPointArrayRequest gupaRequest) {

        logger.warn("request - 連携企業コード [" + gupaRequest.getCorpCode() + "]");
        logger.warn("request - 連携企業パスワード [" + gupaRequest.getPassword() + "]");
        logger.warn("request - 試験ID [" + gupaRequest.getTestId() + "]");
        logger.warn("request - 業態 [" + gupaRequest.getGyotaiCd() + "]");
        logger.warn("request - 店舗コード [" + gupaRequest.getTenCd() + "]");
        logger.warn("request - POSNo. [" + gupaRequest.getPosNo() + "]");
    }

    /**
     * リクエストにセットした個人情報の値をログに出力する。<br />
     * ※本番環境では、[WARN]レベル以上が出力対象のため、出力されない。<br />
     * ※調査の際には、リアル連携ログの出力レベルを下げることで、調査を可能にする。
     * @param gupaRequest 顧客情報取得リクエスト
     */
    private void outputReqKokValue(UserInfoServiceStubTest.GetUserPointArrayRequest gupaRequest) {

        logger.info("request - 顧客No. [" + gupaRequest.getKokNo() + "]");
        logger.info("request - 電話番号 [" + gupaRequest.getTelNo() + "]");
    }

    /**
     * 顧客情報取得レスポンスの値を、返却用顧客情報取得レスポンスBeanにセットします。
     * @param userDataResponse 顧客情報取得レスポンス
     * @param isMailAddrStat String 既存会員のメールアドレス購読状況
     * @return 顧客情報取得レスポンスBean
     * @throws Exception
     */
    private UserDataResBean makeUserDataResBean(UserInfoServiceStubTest.GetUserPointArrayResponse userDataResponse) throws Exception {
        // 顧客情報取得レスポンス
        UserDataResBean bean = new UserDataResBean();
        
        UserInfoServiceStubTest.ArrayOfStructGetUserPointArrayResponse  array = userDataResponse.getUserArray();
        UserInfoServiceStubTest.StructGetUserPointArrayResponse[] struct = array.getItem();

        // 顧客サーバからの値をそのままセット
        bean.setKokno(struct[0].getKokNo());
        bean.setSeij(struct[0].getSeiJ());
        bean.setMeij(struct[0].getMeiJ());
        bean.setAddr1(struct[0].getAddr1());
        bean.setAddr2(struct[0].getAddr2());
        bean.setTelno(struct[0].getTelNo());
        bean.setBirthday(struct[0].getBirthday());
        bean.setSei(struct[0].getSei());
        bean.setMei(struct[0].getMei());
        bean.setYubinno(struct[0].getYubinNo());
        bean.setSeibetu(struct[0].getSeibetu());
        bean.setCardsyu(struct[0].getCardSyu());
        bean.setNensei(struct[0].getNensei());
        bean.setNengetu(struct[0].getNengetu());
        bean.setDmstpkbn(struct[0].getDmStpKbn());
        bean.setDmstpriyu(struct[0].getDmStpRiyu());
        bean.setSeikyocd(struct[0].getSeikyoCd());
        bean.setLstkaiymd(struct[0].getLstKaiYmd());
        bean.setDakaiymd(struct[0].getDakaiYmd());
        bean.setJyotaiikbn(struct[0].getJyotaiKbn());
        bean.setUpdymd(struct[0].getUpdYmd());
        bean.setUpdhms(struct[0].getUpdHms());
        bean.setRuikpoint_mst(struct[0].getRuikPoint_Mst());
        bean.setNen_zan_p4(struct[0].getNen_Zan_P4());
        bean.setPcmail(struct[0].getPcMail());
        bean.setPcmailflg(struct[0].getPcMailFlg());
        bean.setMobilemail(struct[0].getMobileMail());
        bean.setMobilemailflg(struct[0].getMobileMailFlg());
        bean.setMobilemailstopflg(struct[0].getMobileMailStopFlg());
        bean.setInfomailflg(struct[0].getInfoMailFlg());
        bean.setWebkbn(struct[0].getWebKbn());
        bean.setWebtourokuymd(struct[0].getWebTourokuYmd());
        bean.setWebtourokuhms(struct[0].getWebTourokuHms());
        bean.setPcmailkbn(struct[0].getPcMailKbn());
        bean.setMobilmailkbn(struct[0].getMobileMailKbn());
        bean.setWebdakaiymd(struct[0].getWebDakaiYmd());
        bean.setWebdakaihms(struct[0].getWebDakaiHms());
        bean.setQcmaKbn(struct[0].getQcmaKbn());
        
        return bean;
    }
}
