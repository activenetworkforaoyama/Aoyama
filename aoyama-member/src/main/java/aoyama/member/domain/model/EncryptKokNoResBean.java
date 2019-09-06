package aoyama.member.domain.model;

import java.util.List;

/**
 * トークン化№取得レスポンスBean
 */
public class EncryptKokNoResBean {

    /** データ件数 */
    private int dataCnt = 0;
    /** 顧客情報配列 */
    private List<EncryptKokNoResListBean> encryptKokNoResponse = null;

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
    public List<EncryptKokNoResListBean> getEncryptKokNoResponse() {
        return encryptKokNoResponse;
    }

    /**
     * @param encryptKokNoResponse セットする 顧客情報配列
     */
    public void setEncryptKokNoResponse(List<EncryptKokNoResListBean> encryptKokNoResponse) {
        this.encryptKokNoResponse = encryptKokNoResponse;
    }
}