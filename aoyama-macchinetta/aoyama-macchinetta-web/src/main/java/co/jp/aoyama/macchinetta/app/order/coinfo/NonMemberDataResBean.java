package co.jp.aoyama.macchinetta.app.order.coinfo;

import java.util.List;

/**
 * 非会員情報参照レスポンスBean
 */
public class NonMemberDataResBean {

    /** データ件数 */
    private int dataCnt = 0;
	/** 非会員情報配列 */
    private List<NonMemberDataResListBean> nonMemberDataResponse = null;

    /**
     * @return データ件数
     */
    public int getDataCnt() {
        return dataCnt;
    }

    /**
     * @param dataCnt セットする データ件数
     */
    public void setDataCnt(int dataCnt) {
        this.dataCnt = dataCnt;
    }

    /**
     * @return 非会員情報配列
     */
    public List<NonMemberDataResListBean> getNonMemberDataResponse() {
        return nonMemberDataResponse;
    }

    /**
     * @param nonMemberDataRequest セットする 非会員情報配列
     */
    public void setNonMemberDataResponse(List<NonMemberDataResListBean> nonMemberDataResponse) {
        this.nonMemberDataResponse = nonMemberDataResponse;
    }
}