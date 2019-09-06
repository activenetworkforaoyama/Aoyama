package aoyama.member.domain.model;

import java.util.List;

/**
 * トークン化№取得リクエストbean
 */
public class DecryptKokNoReqBean {
    /** 顧客情報配列 */
    private List<DecryptKokNoReqListBean> decryptKokNoRequest = null;

    /**
     * @return 顧客情報配列
     */
    public List<DecryptKokNoReqListBean> getDecryptKokNoRequest() {
        return decryptKokNoRequest;
    }

    /**
     * @param encryptKokNoRequest セットする 顧客情報配列
     */
    public void setDecryptKokNoRequest(List<DecryptKokNoReqListBean> decryptKokNoRequest) {
        this.decryptKokNoRequest = decryptKokNoRequest;
    }
}