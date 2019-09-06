package aoyama.member.domain.renkei;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aoyama.member.domain.conf.MyProperty;
import aoyama.member.domain.model.DecryptKokNoReqBean;
import aoyama.member.domain.model.DecryptKokNoResBean;
import aoyama.member.domain.model.DecryptKokNoResListBean;
import aoyama.member.domain.model.EncryptKokNoReqBean;
import aoyama.member.domain.model.EncryptKokNoResBean;
import aoyama.member.domain.model.EncryptKokNoResListBean;
import aoyama.member.domain.model.KarteUpdateReqBean;
import aoyama.member.domain.model.KarteUpdateResBean;
import aoyama.member.domain.model.MeasureringInfoReqBean;
import aoyama.member.domain.model.MeasureringInfoResBean;
import aoyama.member.domain.model.NonMemberDataReqBean;
import aoyama.member.domain.model.NonMemberDataResBean;
import aoyama.member.domain.model.NonMemberDataResListBean;
import aoyama.member.domain.model.NonMemberUpdateReqBean;
import aoyama.member.domain.model.NonMemberUpdateResBean;
import aoyama.member.domain.model.UserDataReqBean;
import aoyama.member.domain.model.UserDataResBean;

/**
 * リアル連携処理を行います。
 */
@Component
public class RealRenkeiStub  {
    
    @Autowired
    MyProperty myProp;
    
    private static final Logger logger = LoggerFactory
            .getLogger(RealRenkeiStub.class);
    
    /**
     * 顧客情報取得WEBサービス処理を行います。
     */
    public DecryptKokNoResBean getDecryptKokNo(DecryptKokNoReqBean reqBean) throws Exception {
        
        if (reqBean == null) {
            logger.error("UserDataReqBean is null");
            throw new Exception();
        }
        
        DecryptKokNoResBean resBean = new DecryptKokNoResBean();
        DecryptKokNoResListBean resBeanList = new DecryptKokNoResListBean();
        List<DecryptKokNoResListBean> resList = new ArrayList<DecryptKokNoResListBean>();
        
        // 返却値設定
        resBeanList.setRetCd(0);
        resBeanList.setKokNo(3210987654321L);
        resBeanList.setReqKokNo(1234567890123L);
        resList.add(resBeanList);
        resBean.setDataCnt(1);
        resBean.setDecryptKokNoResponse(resList);
        
        return resBean;
    }

    /**
     * 顧客情報取得WEBサービス処理を行います。
     */
    public EncryptKokNoResBean getEncryptKokNo(EncryptKokNoReqBean reqBean) throws Exception {
        
        if (reqBean == null) {
            logger.error("UserDataReqBean is null");
            throw new Exception();
        }
        
        EncryptKokNoResBean resBean = new EncryptKokNoResBean();
        EncryptKokNoResListBean resBeanList = new EncryptKokNoResListBean();
        List<EncryptKokNoResListBean> resList = new ArrayList<EncryptKokNoResListBean>();
        
        // 返却値設定
        resBeanList.setRetCd(0);
        resBeanList.setKokNo(6210987654321L);
        resBeanList.setReqKokNo(6234567890123L);
        resList.add(resBeanList);
        resBean.setDataCnt(1);
        resBean.setEncryptKokNoResponse(resList);
        
        return resBean;
    }
    
    /**
     * 顧客情報取得WEBサービス処理を行います。
     */
    public UserDataResBean getUserData(UserDataReqBean reqBean) throws Exception {
        
        if (reqBean == null) {
            logger.error("UserDataReqBean is null");
            throw new Exception();
        }
        
        // 返却値設定
        UserDataResBean resBean = new UserDataResBean();
        resBean.setSeij("手簀戸");
        resBean.setMeij("太郎");
        resBean.setSei("ﾃｽﾄ");
        resBean.setMei("ﾀﾛｳ");
        resBean.setKokno(reqBean.getKokNo());
        resBean.setCardsyu(1);
        resBean.setYubinno("1800005");
        resBean.setAddr1("東京都");
        resBean.setAddr2("武蔵野市");
        resBean.setBirthday("19920610");
        resBean.setRuikpoint_mst(3000);
        resBean.setNen_zan_p4(1000);
        resBean.setPcmailkbn("00100001");
        resBean.setMobilmailkbn("01010000");
        resBean.setQcmaKbn(1);

        return resBean;
    }
    
    /**
     * メジャーリング情報参照用のWEBサービス処理を行います。
     */

    public MeasureringInfoResBean getMeasureringnfo(MeasureringInfoReqBean reqBean) throws Exception {
        
        if (reqBean == null) {
            logger.error("PointInfoReqBean is null");
            throw new Exception();
        }
        
        // 返却値設定
        MeasureringInfoResBean resBean = new MeasureringInfoResBean();
        resBean.setSize01(160.00);
        resBean.setSize02(50.00);
        resBean.setSize03(75.00);
        resBean.setSize04(75.00);
        resBean.setSize05(80.00);
        resBean.setSize06(90.00);
        resBean.setSize07(88.00);
        resBean.setSize08(84.00);
        resBean.setSize09(90.00);
        resBean.setSize10(52.00);
        resBean.setSize11(52.00);
        resBean.setSize12(38.00);
        resBean.setSize13(38.00);
        resBean.setSize14(42.00);
        resBean.setSizeUpdYmd("20190320");
        
        return resBean;
    }

    /**
     * 受渡顧客登録WEBサービス処理を行います。
     */

    public KarteUpdateResBean karteUpdate(KarteUpdateReqBean reqBean) throws Exception {
        
        if (reqBean == null) {
            logger.error("KarteUpdateReqBean is null");
            throw new Exception();
        }
        
        // プロパティファイルの会員情報アップデート処理成功フラグがfalseの場合はnullを返す
        if (!myProp.getLocalTestKarteUpdateFlg()) {
            return null;
        }
        
        // 返却値設定
        KarteUpdateResBean resBean = new KarteUpdateResBean();
        long kokNo = Long.parseLong("6234567890123");
        resBean.setKokNo(kokNo);
        
        return resBean;
    }

    /**
     * 受渡顧客登録WEBサービス処理を行います。
     */
    public NonMemberUpdateResBean NonMemberUpdate(NonMemberUpdateReqBean reqBean) throws Exception {
        
        if (reqBean == null) {
            logger.error("NonMemberUpdateReqBean is null");
            throw new Exception();
        }
        
        // 返却値設定
        NonMemberUpdateResBean resBean = new NonMemberUpdateResBean();
        long kokNo = Long.parseLong("6234567890123");
        String updYmd = "20190815";
        String updHms = "114235";
        resBean.setKokNo(kokNo);
        resBean.setUpdYmd(updYmd);
        resBean.setUpdYmd(updHms);
        
        return resBean;
    }

    /**
     * 顧客情報取得WEBサービス処理を行います。
     */
    public NonMemberDataResBean getNonMemberData(NonMemberDataReqBean reqBean) throws Exception {
        
        if (reqBean == null) {
            logger.error("UserDataReqBean is null");
            throw new Exception();
        }
        NonMemberDataResBean resBean = new NonMemberDataResBean();
        NonMemberDataResListBean resBeanList = new NonMemberDataResListBean();
        List<NonMemberDataResListBean> resList = new ArrayList<NonMemberDataResListBean>();
        
        // 返却値設定
        resBeanList.setSeij("てすと");
        resBeanList.setMeij("じろう");
        resBeanList.setSei("ﾃｽﾄ");
        resBeanList.setMei("ｼﾞﾛｳ");
        resBeanList.setTelno("0311112222");
        resBeanList.setKokno(7100000000055L);
        resList.add(resBeanList);
        resBean.setDataCnt(1);
        resBean.setNonMemberDataResponse(resList);

        return resBean;
    }
}
