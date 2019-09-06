package aoyama.member.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aoyama.member.domain.conf.MyProperty;
import aoyama.member.domain.model.MemberInfo;
import aoyama.member.domain.model.EncryptKokNoReqBean;
import aoyama.member.domain.model.EncryptKokNoReqListBean;
import aoyama.member.domain.model.EncryptKokNoResBean;
import aoyama.member.domain.model.EncryptKokNoResListBean;
import aoyama.member.domain.model.MeasureringInfoReqBean;
import aoyama.member.domain.model.MeasureringInfoResBean;
import aoyama.member.domain.model.UserDataReqBean;
import aoyama.member.domain.model.UserDataResBean;
import aoyama.member.domain.renkei.RealRenkei;
import aoyama.member.domain.renkei.RealRenkeiConstDef;
import aoyama.member.domain.renkei.RealRenkeiStub;

@Service
public class MemberInfoApiServiceImpl implements MemberInfoApiService {
    
    @Autowired
    MyProperty myProp;
    
    @Autowired
    RealRenkei realRenkei;
    
    @Autowired
    RealRenkeiStub realRenkeiStub;
    
    private static final Logger logger = LoggerFactory
            .getLogger(MemberInfoApiServiceImpl.class);
    
    /**
     * 顧客サーバから顧客情報を取得するAPI
     */
    @Override
    public MemberInfo getMemberInfo(String membersId, String gyotaiCd) {
        
        // 顧客No
        long kokNo = Long.parseLong(membersId);
        
        // 顧客Noトークン化Bean作成
        EncryptKokNoReqBean eknReqBean = new EncryptKokNoReqBean();
        EncryptKokNoReqListBean eknReqListBean = new EncryptKokNoReqListBean();
        List<EncryptKokNoReqListBean> eknReqList = new ArrayList<EncryptKokNoReqListBean>();
        eknReqListBean.setKokNo(kokNo);
        eknReqList.add(eknReqListBean);
        eknReqBean.setEncryptKokNoRequest(eknReqList);

        int iGyotaiCd = Integer.parseInt(gyotaiCd);
        
        // 顧客Noトークン化WEBサービス処理実行
        EncryptKokNoResBean eknResBean = new EncryptKokNoResBean();
        try {
            
            // スタブを使用する
            if (myProp.getLocalTestStubUseFlg()) {
                eknResBean= realRenkeiStub.getEncryptKokNo(eknReqBean);
            } else {
                eknResBean= realRenkei.getEncryptKokNo(eknReqBean, iGyotaiCd);
            }
            
            if (eknResBean.getDataCnt() <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            
            // 顧客Noトークン化中にエラーが発生した場合はnullを返す
            e.printStackTrace();
            return null;
        }
        
        List<EncryptKokNoResListBean> eknResBeanList = eknResBean.getEncryptKokNoResponse();
        EncryptKokNoResListBean eknResBeanDtl = eknResBeanList.get(0);
        // トークン化された顧客No
        long enkKokNo = eknResBeanDtl.getKokNo();
        logger.info("enkKokNo:" + enkKokNo);
        
        // 送信用Bean作成(顧客情報取得用)
        UserDataReqBean reqBean = new UserDataReqBean();
        reqBean.setKokNo(enkKokNo);
        
        // メジャーリング情報参照用Bean作成

        MeasureringInfoReqBean measureringInfoReqBean = new MeasureringInfoReqBean();
        measureringInfoReqBean.setKokNo(enkKokNo);
        
        UserDataResBean userDataResBean = new UserDataResBean();

        MeasureringInfoResBean measureringInfoResBean = new MeasureringInfoResBean();
        
        // 顧客情報取得WEBサービス処理実行
        try {
            
            // スタブを使用する
            if (myProp.getLocalTestStubUseFlg()) {
                userDataResBean= realRenkeiStub.getUserData(reqBean);

                measureringInfoResBean = realRenkeiStub.getMeasureringnfo(measureringInfoReqBean);

            } else {
                userDataResBean= realRenkei.getUserData(reqBean,iGyotaiCd);

                measureringInfoResBean = realRenkei.getMeasureringnfo(measureringInfoReqBean,iGyotaiCd);

            }
        } catch (Exception e) {
            
            // 顧客情報取得中にエラーが発生した場合はnullを返す
            e.printStackTrace();
            return null;
        }
        
        MemberInfo memberInfo = new MemberInfo();
        
        // レスポンスの変換処理 start
        memberInfo.setLastName(userDataResBean.getSeij());
        memberInfo.setFirstName(userDataResBean.getMeij());
        memberInfo.setLastNameKana(userDataResBean.getSei());
        memberInfo.setFirstNameKana(userDataResBean.getMei());
        memberInfo.setMembersId(String.valueOf(kokNo));
        memberInfo.setCardType(cardTypeConverter(userDataResBean.getCardsyu()));
        memberInfo.setZipCode(userDataResBean.getYubinno());
        memberInfo.setPrefectures(userDataResBean.getAddr1());
        memberInfo.setCity(userDataResBean.getAddr2());
        memberInfo.setBirthDay(userDataResBean.getBirthday());
        memberInfo.setOwnedPoints(userDataResBean.getRuikpoint_mst());
        memberInfo.setLosePoints(userDataResBean.getNen_zan_p4());
        memberInfo.setItemMailMagazine(maiMagagineKbnConverter(userDataResBean.getPcmailkbn()));
        memberInfo.setStoreMailMagazine(maiMagagineKbnConverter(userDataResBean.getMobilmailkbn()));
        memberInfo.setBusinessTypeMailMagazine(businessTypeMailMagazineConverter(userDataResBean.getQcmaKbn()));
        memberInfo.setAppRegistration("登録済み");
        // TODO メジャーリング項目のマッピングは仮

        memberInfo.setMeasuringLatestDm(measureringInfoResBean.getSizeUpdYmd());
        memberInfo.setMeasuringFullLength(String.valueOf(measureringInfoResBean.getSize01()));
        memberInfo.setMeasuringShoulder(String.valueOf(measureringInfoResBean.getSize02()));
        memberInfo.setMeasuringReachRight(String.valueOf(measureringInfoResBean.getSize03()));
        memberInfo.setMeasuringReachLeft(String.valueOf(measureringInfoResBean.getSize04()));
        memberInfo.setMeasuringOutBust(String.valueOf(measureringInfoResBean.getSize05()));
        memberInfo.setMeasuringBust(String.valueOf(measureringInfoResBean.getSize06()));
        memberInfo.setMeasuringJkWeist(String.valueOf(measureringInfoResBean.getSize07()));
        memberInfo.setMeasuringPtWeist(String.valueOf(measureringInfoResBean.getSize08()));
        memberInfo.setMeasuringHip(String.valueOf(measureringInfoResBean.getSize09()));
        memberInfo.setMeasuringThighWidthRight(String.valueOf(measureringInfoResBean.getSize10()));
        memberInfo.setMeasuringThighWidthLeft(String.valueOf(measureringInfoResBean.getSize11()));
        memberInfo.setMeasuringCalfWidthRight(String.valueOf(measureringInfoResBean.getSize12()));
        memberInfo.setMeasuringCalfWidthLeft(String.valueOf(measureringInfoResBean.getSize13()));
        memberInfo.setMeasuringNeck(String.valueOf(measureringInfoResBean.getSize14()));
        memberInfo.setClothPre(measureringInfoResBean.getBiko01());
        memberInfo.setCorrectionInfo(measureringInfoResBean.getBiko02());
        memberInfo.setNote(measureringInfoResBean.getBiko03());

        return memberInfo;
    }
    
    /**
     * 顧客APIから取得したカード種別を表示用に変換する
     * @param cardType
     * @return
     */
    public String cardTypeConverter(int cardType) {
        
        String retCardType = "";
        
        String strCardType = String.valueOf(cardType);
        if (RealRenkeiConstDef.CARD_TYPE_MAP.containsKey(strCardType)) {
            retCardType = RealRenkeiConstDef.CARD_TYPE_MAP.get(strCardType);
        }
        
        return retCardType;
    }
    
    /**
     * 顧客APIから取得したメールマガジン詳細区分を表示用に変換する
     * PCMAILKBNとMOBILMAILKBNで共通
     * @param mailMagagineKbn
     * @return
     */
    public String[] maiMagagineKbnConverter(String mailMagagineKbn) {
        
        String[] retMailMagagineKbn = new String[5];
        if(mailMagagineKbn == null || mailMagagineKbn == "" || mailMagagineKbn.length() < 8) {
            return null;
        }
        
        char[] arrMailMagaChar = mailMagagineKbn.toCharArray();
        /*
         * 各メールマガジンとMAILKBNの紐づきは以下の通り
         * TSC MENS:PCMAILKBNの1文字目
         * TSC LADIES:PCMAILKBNの2文字目
         * UL MENS:PCMAILKBNの3文字目
         * UL LADIES:PCMAILKBNの4文字目
         * WHITE LADIES:PCMAILKBNの8文字目
         */
        retMailMagagineKbn[0] = String.valueOf(arrMailMagaChar[0]);
        retMailMagagineKbn[1] = String.valueOf(arrMailMagaChar[1]);
        retMailMagagineKbn[2] = String.valueOf(arrMailMagaChar[2]);
        retMailMagagineKbn[3] = String.valueOf(arrMailMagaChar[3]);
        retMailMagagineKbn[4] = String.valueOf(arrMailMagaChar[7]);
        
        return retMailMagagineKbn;
    }
    
    /**
     * 顧客APIから取得したQCMA区分を表示用に変換する
     * @param qcmaKbn
     * @return
     */
    public String[] businessTypeMailMagazineConverter(int qcmaKbn) {
        
        String[] businessTypeMailMagazine = {"0", "0", "0"};
        if (qcmaKbn == 1 || qcmaKbn == 2) {
            businessTypeMailMagazine[0] = "1";
        } else if (qcmaKbn == 3) {
            businessTypeMailMagazine[1] = "1";
        } else if (qcmaKbn == 4) {
            businessTypeMailMagazine[2] = "1";
        }
        
        return businessTypeMailMagazine;
    }
}
