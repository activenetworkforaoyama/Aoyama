package aoyama.member.domain.model;

import java.util.List;

/**
 * トークン化№取得リクエストbean
 */
public class EncryptKokNoReqBean {
    /** 顧客情報配列 */
    private List<EncryptKokNoReqListBean> encryptKokNoRequest = null;

    /**
     * @return 顧客情報配列
     */
    public List<EncryptKokNoReqListBean> getEncryptKokNoRequest() {
        return encryptKokNoRequest;
    }

    /**
     * @param encryptKokNoRequest セットする 顧客情報配列
     */
    public void setEncryptKokNoRequest(List<EncryptKokNoReqListBean> encryptKokNoRequest) {
        this.encryptKokNoRequest = encryptKokNoRequest;
    }
}