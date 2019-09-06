package aoyama.member.domain.model;

/**
 * メジャーリング情報参照リクエストbean
 */
public class MeasureringInfoReqBean {
    /** 顧客No. */
    private long kokNo = 0;

    public long getKokNo() {
        return kokNo;
    }
    public void setKokNo(long kokNo) {
        this.kokNo = kokNo;
    }
}