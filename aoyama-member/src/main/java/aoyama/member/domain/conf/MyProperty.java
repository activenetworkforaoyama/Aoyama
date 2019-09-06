package aoyama.member.domain.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyProperty {
    
    //提携企業コード
    @Value("${real.renkei.req.corpcode}")
    private String realRenkeiReqCorpCode;
    
    //提携企業パスワード
    @Value("${real.renkei.req.password}")
    private String realRenkeiReqPassword;
    
    //試験ID
    @Value("${real.renkei.req.testid}")
    private String realRenkeiReqTestId;
    
    //業態
    @Value("${real.renkei.req.gyotaicd}")
    private String realRenkeiReqGyotaiCd;
    
  //店舗コード
    @Value("${real.renkei.req.tencd}")
    private String realRenkeiReqTenCd;
    
    //POSNo
    @Value("${real.renkei.req.posno}")
    private String realRenkeiReqPosNo;
    
    //ログ出力時間(ミリ秒)
    @Value("${real.renkei.waittime}")
    private String realRenkeiReqWaitTime;
    
    //アラートログ出力時間(ミリ秒)
    @Value("${real.renkei.timeout}")
    private String realRenkeiReqTimeOut;
    
    //スリープ時間(ミリ秒)
    @Value("${real.renkei.sleeptime}")
    private String realRenkeiReqSleepTime;
    
    //会員情報再連携タスク 実行間隔（分）
    @Value("${renkei.timer.period.minute}")
    private String renkeiTimerPeriodMinute;
    
    //会員情報再連携タスク 実行間隔（秒）
    @Value("${renkei.timer.period.second}")
    private String renkeiTimerPeriodSecond;
    
    //カルテアップデート処理成功フラグ
    @Value("${local.test.karte.update.flg}")
    private String localTestKarteUpdateFlg;
    
    //スタブ使用フラグ
    @Value("${local.test.stub.use.flg}")
    private String localTestStubUseFlg;
    
    //tmpkarteの有効日数
    @Value("${tmpkarte.expiration.days}")
    private String tmpkarteExpirationDays;

    //非会員番号 初期値
    @Value("${nonmember.init.number}")
    private String nonmemberIinitNumber;
    
    /* getter群 */
    public int getRealRenkeiReqCorpCode() {
        return Integer.parseInt(realRenkeiReqCorpCode);
    }

    public String getRealRenkeiReqPassword() {
        return realRenkeiReqPassword;
    }

    public int getRealRenkeiReqTestId() {
        return Integer.parseInt(realRenkeiReqTestId);
    }

    public int getRealRenkeiReqGyotaiCd() {
        return Integer.parseInt(realRenkeiReqGyotaiCd);
    }
    
    public int getRealRenkeiReqTenCd() {
        return Integer.parseInt(realRenkeiReqTenCd);
    }

    public int getRealRenkeiReqPosNo() {
        return Integer.parseInt(realRenkeiReqPosNo);
    }

    public String getRealRenkeiReqWaitTime() {
        return realRenkeiReqWaitTime;
    }

    public String getRealRenkeiReqTimeOut() {
        return realRenkeiReqTimeOut;
    }

    public String getRealRenkeiReqSleepTime() {
        return realRenkeiReqSleepTime;
    }

    public int getRenkeiTimerPeriodMinute() {
        if (renkeiTimerPeriodMinute != null && renkeiTimerPeriodMinute != "") {
            try {
                return Integer.parseInt(renkeiTimerPeriodMinute);
            } catch(Exception e) {
                // intに変換できない場合は0を返す
                return 0;
            }
        } else {
            return 0;
        }
    }

    public int getRenkeiTimerPeriodSecond() {
        if (renkeiTimerPeriodSecond != null && renkeiTimerPeriodSecond != "") {
            try {
                return Integer.parseInt(renkeiTimerPeriodSecond);
            } catch(Exception e) {
                // intに変換できない場合は0を返す
                return 0;
            }
        } else {
            return 0;
        }
    }
    
    public boolean getLocalTestKarteUpdateFlg() {
        if ("true".equals(localTestKarteUpdateFlg)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getLocalTestStubUseFlg() {
        if ("true".equals(localTestStubUseFlg)) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getTmpkarteExpirationDays() {
        if (tmpkarteExpirationDays != null && tmpkarteExpirationDays != "") {
            try {
                return Integer.parseInt(tmpkarteExpirationDays);
            } catch(Exception e) {
                // intに変換できない場合は0を返す
                return 0;
            }
        } else {
            return 0;
        }
    }
    public String getInitNonMemberNumber() {
        return nonmemberIinitNumber;
    	
    }
}
