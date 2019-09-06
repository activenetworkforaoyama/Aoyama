package aoyama.member.domain.service;

import java.util.ArrayList;
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
import aoyama.member.domain.model.EncryptKokNoResBean;
import aoyama.member.domain.model.EncryptKokNoReqListBean;
import aoyama.member.domain.model.EncryptKokNoResListBean;
import aoyama.member.domain.model.NonMemberUpdateReqBean;
import aoyama.member.domain.model.NonMemberUpdateResBean;
import aoyama.member.domain.renkei.RealRenkei;
import aoyama.member.domain.renkei.RealRenkeiStub;
import aoyama.member.domain.repository.NonMemberRepository;

@Service
public class NonMemberUpdateApiServiceImpl implements NonMemberUpdateApiService {
    
    @Inject
    NonMemberRepository nonMemberRepository;

    @Autowired
    RealRenkei realRenkei;
    
    @Autowired
    RealRenkeiStub realRenkeiStub;
    
    @Autowired
    MessageSource messageSource;
    
    @Autowired
    MyProperty myProp;
    
    private static final Logger logger = LoggerFactory
            .getLogger(NonMemberUpdateApiServiceImpl.class);
    
    @Override
    public NonMemberUpdateResBean nonMemberUpdate(NonMemberUpdateReqBean reqBean) {
        
        // 顧客No採番
    	long nonMemNoSeq = nonMemberRepository.getNonMemberNumber();

    	String strNonMemNoSeq = String.format("%08d", nonMemNoSeq);    //8桁でゼロパディング
    	String memNoPrefix = myProp.getInitNonMemberNumber();

    	String nonMemNoCheckDigit = makeCheckDigit(memNoPrefix + strNonMemNoSeq);

    	// 非会員番号（13桁） = 固定番号(4桁) + シーケンス（8桁）  + チェックデジット(1桁)
        String newNonMemNo = memNoPrefix + strNonMemNoSeq + nonMemNoCheckDigit;
        logger.warn("request - 非会員No.（トークン化前） [" + newNonMemNo + "]");
        
    	long kokNo = Long.parseLong(newNonMemNo);
        
        // 顧客Noトークン化Bean作成
        int gyotaiCd = 1;
        EncryptKokNoReqBean eknReqBean = new EncryptKokNoReqBean();
        EncryptKokNoReqListBean eknReqListBean = new EncryptKokNoReqListBean();
        List<EncryptKokNoReqListBean> eknReqList = new ArrayList<EncryptKokNoReqListBean>();
        eknReqListBean.setKokNo(kokNo);
        eknReqList.add(eknReqListBean);
        eknReqBean.setEncryptKokNoRequest(eknReqList);
        
        // 顧客Noトークン化WEBサービス処理実行
        EncryptKokNoResBean eknResBean = new EncryptKokNoResBean();
        try {
            
            // スタブを使用する
            if (myProp.getLocalTestStubUseFlg()) {
                eknResBean= realRenkeiStub.getEncryptKokNo(eknReqBean);
            } else {
                eknResBean= realRenkei.getEncryptKokNo(eknReqBean,gyotaiCd);
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
        
        // 非会員情報更新WEBサービス処理実行
        NonMemberUpdateResBean resBean = new NonMemberUpdateResBean();
        try {
            
            // スタブを使用する
            if (myProp.getLocalTestStubUseFlg()) {
                resBean = realRenkeiStub.NonMemberUpdate(reqBean);
            } else {
                // スタブを使用しない
                resBean = realRenkei.NonMemberUpdate(reqBean);
            }
            if (resBean == null) {
                
                throw new Exception();
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
            logger.error(messageSource.getMessage("e.ts.cu.7001", null, Locale.JAPAN));
            
            return null;
        }
        
        // レスポンスBeanの顧客Noを入れなおす
        resBean.setKokNo(Long.parseLong(newNonMemNo));
        return resBean;
    }
    
    /**
     * モジュラス10/ウェイト3で会員番号のチェックデジットを算出します。
     *
     * 計算例）
     * memNoが604601028259の場合、チェックデジットは7
     *
     *                 ●:奇数桁
     *                 ○:偶数桁
     * ●|○|●|○|●|○|●|○|●|○|●|○
     * 6|0|4|6|0|1|0|2|8|2|5|9
     *
     * 項1)6＋4＋0＋0＋8＋5=23
     * 項2)0＋6＋1＋2＋2＋9=20
     * 項3)20*3＋23=83
     * 項4)83/10=8
     * 項5)8＋1=9
     * 項6)9*10=90
     * 項7)90-83=7
     *
     * @param memNo 12桁の会員番号
     * @return チェックディジット
     */
     private String makeCheckDigit(String memNo) {
         String checkDegit = "0";

         if (memNo.length() != 12) {
             // TODO:エラー処理
         }

         // 項1)奇数桁No.の和
         int sumOddPlace = 0;
         for (int i = 0; i < memNo.length(); i += 2) {
             sumOddPlace += Integer.parseInt(memNo.substring(i, i + 1));
         }

         // 項2)偶数桁No.の和
         int sumEvenPlace = 0;
         for (int i = 1; i < memNo.length(); i += 2) {
             sumEvenPlace += Integer.parseInt(memNo.substring(i, i + 1));
         }

         // 項3)偶数桁No.の和を3倍した値と、奇数桁No.の和を加算
         int tmp3 = (3 * sumEvenPlace) + sumOddPlace;

         // 項4)項3で求めた値を10で除算し、小数点以下を切り捨て
         int tmp4 = tmp3 / 10;

         // 項5)項4で求めた値に、1を加算
         int tmp5 = tmp4 + 1;

         // 項6)項5で求めた値に、10を乗算
         int tmp6 = tmp5 * 10;

         // 項7)項6で求めた値から、、項3で求めた値を減算
         int tmp7 = tmp6 - tmp3;

         // 減算した値＝10の場合は、「0」をチェックデジットとする。
         // 減算した値＜10の場合は、減算した値をチェックデジットとする。
         if (tmp7 < 10) {
             checkDegit = String.valueOf(tmp7);
         }

         return checkDegit;
     }
}
