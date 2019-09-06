package aoyama.member.domain.model;

import java.util.List;

/**
 * 受渡顧客登録リクエストBean(顧客カルテ)
 */
public class KarteUpdateReqBeanArray {
    
    /** 顧客情報配列 */
    private List<KarteUpdateReqBean> karteUpdateRequest = null;

    public List<KarteUpdateReqBean> getKarteUpdateRequest() {
        return karteUpdateRequest;
    }

    public void setKarteUpdateRequest(List<KarteUpdateReqBean> karteUpdateRequest) {
        this.karteUpdateRequest = karteUpdateRequest;
    }
}
