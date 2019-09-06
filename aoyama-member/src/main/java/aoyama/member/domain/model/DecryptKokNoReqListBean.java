package aoyama.member.domain.model;

/**
 * 非トークン化№取得リクエストBean（顧客情報配列内用）
 */
public class DecryptKokNoReqListBean {

    /** 顧客No. */
    private long kokNo = 0;

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