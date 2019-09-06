package aoyama.member.domain.renkei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aoyama.member.domain.conf.MyProperty;
import aoyama.member.domain.model.DecryptKokNoReqBean;
import aoyama.member.domain.model.DecryptKokNoResBean;
import aoyama.member.domain.model.EncryptKokNoReqBean;
import aoyama.member.domain.model.EncryptKokNoResBean;
import aoyama.member.domain.model.KarteUpdateReqBean;
import aoyama.member.domain.model.KarteUpdateResBean;
import aoyama.member.domain.model.MeasureringInfoReqBean;
import aoyama.member.domain.model.MeasureringInfoResBean;
import aoyama.member.domain.model.NonMemberDataReqBean;
import aoyama.member.domain.model.NonMemberDataResBean;
import aoyama.member.domain.model.NonMemberUpdateReqBean;
import aoyama.member.domain.model.NonMemberUpdateResBean;
import aoyama.member.domain.model.UserDataReqBean;
import aoyama.member.domain.model.UserDataResBean;

/**
 * リアル連携処理を行います。
 */
@Component
public class RealRenkei  {
    
    @Autowired
    DecryptKokNoRealRenkei decryptKokNoRealRenkei;
    
    @Autowired
    DecryptKokNoRealRenkeiTest decryptKokNoRealRenkeiTest;
    
    @Autowired
    EncryptKokNoRealRenkei encryptKokNoRealRenkei;
    
    @Autowired
    EncryptKokNoRealRenkeiTest encryptKokNoRealRenkeiTest;
    
    @Autowired
    UserDataRealRenkei userDataRealRenkei;
    
    @Autowired
    UserDataRealRenkeiTest userDataRealRenkeiTest;

    @Autowired
    NonMemberDataRealRenkei nonMemberDataRealRenkei;

    @Autowired
    NonMemberDataRealRenkeiTest nonMemberDataRealRenkeiTest;
    
    @Autowired
    MeasureringInfoRealRenkei measureringInfoRealRenkei;
    
    @Autowired
    MeasureringInfoRealRenkeiTest measureringInfoRealRenkeiTest;
    
    @Autowired
    KarteUpdateRealRenkei karteUpdateRealRenkei;
    
    @Autowired
    KarteUpdateRealRenkeiTest karteUpdateRealRenkeiTest;
    
    @Autowired
    NonMemberUpdateRealRenkei nonMemberUpdateRealRenkei;
    
    @Autowired
    NonMemberUpdateRealRenkeiTest nonMemberUpdateRealRenkeiTest;

    @Autowired
    MyProperty myProp;
    
    private static final Logger logger = LoggerFactory
            .getLogger(RealRenkei.class);
    
    /**
     * 顧客情報取得WEBサービス処理を行います。
     */
    public DecryptKokNoResBean getDecryptKokNo(DecryptKokNoReqBean reqBean, int gyotaiCd) throws Exception {
        
        if (reqBean == null) {
            logger.error("UserDataReqBean is null");
            throw new Exception();
        }
        
        if (myProp.getRealRenkeiReqTestId() == 0) {
            // 本番
            return decryptKokNoRealRenkei.requestGetDecryptKokNo(reqBean, gyotaiCd);
        } else {
           // テスト 
            return decryptKokNoRealRenkeiTest.requestGetDecryptKokNo(reqBean, gyotaiCd);
        }
    }
    
    /**
     * 顧客情報取得WEBサービス処理を行います。
     */
    public EncryptKokNoResBean getEncryptKokNo(EncryptKokNoReqBean reqBean, int gyotaiCd) throws Exception {
        
        if (reqBean == null) {
            logger.error("UserDataReqBean is null");
            throw new Exception();
        }
        
        if (myProp.getRealRenkeiReqTestId() == 0) {
            // 本番
            return encryptKokNoRealRenkei.requestGetEncryptKokNo(reqBean, gyotaiCd);
        } else {
           // テスト 
            return encryptKokNoRealRenkeiTest.requestGetEncryptKokNo(reqBean, gyotaiCd);
        }
    }
    
    /**
     * 顧客情報取得WEBサービス処理を行います。
     */
    public UserDataResBean getUserData(UserDataReqBean reqBean, int gyotaiCd) throws Exception {
        
        if (reqBean == null) {
            logger.error("UserDataReqBean is null");
            throw new Exception();
        }
        
        if (myProp.getRealRenkeiReqTestId() == 0) {
            // 本番
            return userDataRealRenkei.requestGetUserPointArray(reqBean, gyotaiCd);
        } else {
           // テスト 
            return userDataRealRenkeiTest.requestGetUserPointArray(reqBean, gyotaiCd);
        }
    }
    
    /**
     * メジャーリング情報参照用のWEBサービス処理を行います。
     */

    public MeasureringInfoResBean getMeasureringnfo(MeasureringInfoReqBean reqBean, int gyotaiCd) throws Exception {
        
        if (reqBean == null) {
            logger.error("MeasureringInfoReqBean is null");
            throw new Exception();
        }
        
        if (myProp.getRealRenkeiReqTestId() == 0) {
            // 本番
            return measureringInfoRealRenkei.requestGetMeasureringInfo(reqBean, gyotaiCd);
        } else {
           // テスト 
            return measureringInfoRealRenkeiTest.requestGetMeasureringInfo(reqBean, gyotaiCd);
        }
    }

    /**
     * メジャーリング情報(顧客カルテ情報)更新WEBサービス処理を行います。
     */

    public KarteUpdateResBean karteUpdate(KarteUpdateReqBean reqBean) throws Exception {
        
        if (reqBean == null) {
            logger.error("KarteUpdateReqBean is null");
            throw new Exception();
        }
        
        if (myProp.getRealRenkeiReqTestId() == 0) {
            // 本番
            return karteUpdateRealRenkei.requestKarteUpdate(reqBean);
        } else {
            // テスト
            return karteUpdateRealRenkeiTest.requestKarteUpdate(reqBean);
        }
    }

    public NonMemberUpdateResBean NonMemberUpdate(NonMemberUpdateReqBean reqBean) throws Exception {
        
        if (reqBean == null) {
            logger.error("NonMemberUpdateReqBean is null");
            throw new Exception();
        }
        
        if (myProp.getRealRenkeiReqTestId() == 0) {
        	// 本番
            return nonMemberUpdateRealRenkei.requestNonMemberUpdate(reqBean);
        } else {
            // テスト
            return nonMemberUpdateRealRenkeiTest.requestNonMemberUpdate(reqBean);
        }
    }

    /**
     * 非会員情報取得WEBサービス処理を行います。
     */
    public NonMemberDataResBean getNonMemberData(NonMemberDataReqBean reqBean) throws Exception {
        
        if (reqBean == null) {
            logger.error("UserDataReqBean is null");
            throw new Exception();
        }
        
        if (myProp.getRealRenkeiReqTestId() == 0) {
            // 本番
            return nonMemberDataRealRenkei.requestGetNonMemberData(reqBean);
        } else {
           // テスト 
            return nonMemberDataRealRenkeiTest.requestGetNonMemberData(reqBean);
        }
    }
}
