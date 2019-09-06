package aoyama.member.domain.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import aoyama.member.domain.conf.MyProperty;
import aoyama.member.domain.model.EncryptKokNoReqBean;
import aoyama.member.domain.model.EncryptKokNoReqListBean;
import aoyama.member.domain.model.EncryptKokNoResBean;
import aoyama.member.domain.model.EncryptKokNoResListBean;
import aoyama.member.domain.model.KarteUpdateReqBean;
import aoyama.member.domain.model.KarteUpdateResBean;
import aoyama.member.domain.renkei.RealRenkei;
import aoyama.member.domain.renkei.RealRenkeiStub;

@Service
public class KarteUpdateApiServiceImpl implements KarteUpdateApiService {
    
    @Autowired
    RealRenkei realRenkei;
    
    @Autowired
    RealRenkeiStub realRenkeiStub;
    
    @Autowired
    MessageSource messageSource;
    
    @Autowired
    MyProperty myProp;
    
    private static final Logger logger = LoggerFactory
            .getLogger(KarteUpdateApiServiceImpl.class);
    
    @Override
    public KarteUpdateResBean karteUpdate(KarteUpdateReqBean reqBean) {
        
        // 顧客No
        long kokNo = reqBean.getKokNo();
        
        // 顧客Noトークン化Bean作成
        EncryptKokNoReqBean eknReqBean = new EncryptKokNoReqBean();
        EncryptKokNoReqListBean eknReqListBean = new EncryptKokNoReqListBean();
        List<EncryptKokNoReqListBean> eknReqList = new ArrayList<EncryptKokNoReqListBean>();
        eknReqListBean.setKokNo(kokNo);
        eknReqList.add(eknReqListBean);
        eknReqBean.setEncryptKokNoRequest(eknReqList);
        int gyotaiCd = reqBean.getGyotaiCd();
        
        // 顧客Noトークン化WEBサービス処理実行
        EncryptKokNoResBean eknResBean = new EncryptKokNoResBean();
        try {
            
            // スタブを使用する
            if (myProp.getLocalTestStubUseFlg()) {
                eknResBean= realRenkeiStub.getEncryptKokNo(eknReqBean);
            } else {
                eknResBean= realRenkei.getEncryptKokNo(eknReqBean, gyotaiCd);
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
        
        // リクエストBeanの顧客Noを入れなおす
        reqBean.setKokNo(enkKokNo);
        
        // メジャーリング情報更新WEBサービス処理実行
        KarteUpdateResBean resBean = new KarteUpdateResBean();
        try {
            
            // スタブを使用する
            if (myProp.getLocalTestStubUseFlg()) {
                resBean = realRenkeiStub.karteUpdate(reqBean);
            } else {
                // スタブを使用しない
                resBean = realRenkei.karteUpdate(reqBean);
            }
            if (resBean == null) {
                
                throw new Exception();
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
            logger.error(messageSource.getMessage("e.ts.cu.7001", null, Locale.JAPAN));
            
            return null;
        }
        
        return resBean;
    }

}
