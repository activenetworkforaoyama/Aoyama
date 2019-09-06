package aoyama.member.domain.model;

/**
 * 非トークン化№取得レスポンスBean（顧客情報配列内用）
 */
public class DecryptKokNoResListBean {

    /** 結果コード */
    private int retCd = 0;

    /** リクエスト顧客No. */
    private long reqKokNo = 0;

    /** 顧客No. */
    private long kokNo = 0;

    /**
     * @return 結果コード
     */
    public int getRetCd() {
        return retCd;
    }

    /**
     * @param retCd セットする 結果コード
     */
    public void setRetCd(int retCd) {
        this.retCd = retCd;
    }

    /**
     * @return リクエスト顧客No.
     */
    public long getReqKokNo() {
        return reqKokNo;
    }

    /**
     * @param reqKokNo セットする リクエスト顧客No.
     */
    public void setReqKokNo(long reqKokNo) {
        this.reqKokNo = reqKokNo;
    }

    /**
     * @return 顧客No.
     */
    public long getKokNo() {
        return kokNo;
    }

    /**
     * @param kokNo セットする 顧客No.
     */
    public void setKokNo(long kokNo) {
        this.kokNo = kokNo;
    }
}