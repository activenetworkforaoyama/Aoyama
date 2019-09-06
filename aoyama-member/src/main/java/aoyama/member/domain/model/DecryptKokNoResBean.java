package aoyama.member.domain.model;

import java.util.List;

/**
 * 非トークン化№取得レスポンスBean
 */
public class DecryptKokNoResBean {

    /** データ件数 */
    private int dataCnt = 0;
    /** 顧客情報配列 */
    private List<DecryptKokNoResListBean> decryptKokNoResponse = null;

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
     * @return 顧客情報配列
     */
    public List<DecryptKokNoResListBean> getDecryptKokNoResponse() {
        return decryptKokNoResponse;
    }

    /**
     * @param decryptKokNoResponse セットする 顧客情報配列
     */
    public void setDecryptKokNoResponse(List<DecryptKokNoResListBean> decryptKokNoResponse) {
        this.decryptKokNoResponse = decryptKokNoResponse;
    }
}