package aoyama.member.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aoyama.member.domain.conf.MyProperty;
import aoyama.member.domain.model.EncryptKokNoReqBean;
import aoyama.member.domain.model.EncryptKokNoReqListBean;
import aoyama.member.domain.model.EncryptKokNoResBean;
import aoyama.member.domain.model.EncryptKokNoResListBean;
import aoyama.member.domain.renkei.RealRenkei;
import aoyama.member.domain.renkei.RealRenkeiStub;
import aoyama.member.domain.model.NonMemberDataReqBean;
import aoyama.member.domain.model.NonMemberDataResBean;

@Service
public class NonMemberInfoApiServiceImpl implements NonMemberInfoApiService {
    
    @Autowired
    MyProperty myProp;
    
    @Autowired
    RealRenkei realRenkei;
    
    @Autowired
    RealRenkeiStub realRenkeiStub;
    
    private static final Logger logger = LoggerFactory
            .getLogger(MemberInfoApiServiceImpl.class);
    
    /**
     * 顧客サーバから非会員情報を取得するAPI
     */
    @Override
    public NonMemberDataResBean getNonMemberInfo(NonMemberDataReqBean reqBean) {
        
        // 顧客No
        long kokNo = 0;
        String strKokNo = String.valueOf(reqBean.getKokNo());
        if ((strKokNo.length() == 13) && (strKokNo.charAt(0) == '7')) {
        	kokNo = reqBean.getKokNo();
        }
        	
        // 顧客Noトークン化Bean作成
        EncryptKokNoReqBean eknReqBean = new EncryptKokNoReqBean();
        EncryptKokNoReqListBean eknReqListBean = new EncryptKokNoReqListBean();
        List<EncryptKokNoReqListBean> eknReqList = new ArrayList<EncryptKokNoReqListBean>();
        eknReqListBean.setKokNo(kokNo);
        eknReqList.add(eknReqListBean);
        eknReqBean.setEncryptKokNoRequest(eknReqList);

        if (kokNo > 0) {
            // 顧客Noトークン化WEBサービス処理実行
            EncryptKokNoResBean eknResBean = new EncryptKokNoResBean();
            try {
                
                // スタブを使用する
                if (myProp.getLocalTestStubUseFlg()) {
                    eknResBean= realRenkeiStub.getEncryptKokNo(eknReqBean);
                } else {
                    eknResBean= realRenkei.getEncryptKokNo(eknReqBean, reqBean.getGyotai());
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
            
            // 送信用Bean作成(非会員情報取得用)
            reqBean.setKokNo(enkKokNo);
        }
        
        // 非会員情報取得WEBサービス処理実行

        NonMemberDataResBean nmResBean = new NonMemberDataResBean();
        try {
            
            // スタブを使用する
            if (myProp.getLocalTestStubUseFlg()) {
            	nmResBean= realRenkeiStub.getNonMemberData(reqBean);
            } else {
            	nmResBean= realRenkei.getNonMemberData(reqBean);
            }
        } catch (Exception e) {
            
            // 顧客情報取得中にエラーが発生した場合はnullを返す
            e.printStackTrace();
            return null;
        }
        
        return nmResBean;
    }
    
}
