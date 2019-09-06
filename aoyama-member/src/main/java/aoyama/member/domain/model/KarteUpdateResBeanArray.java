package aoyama.member.domain.model;

import java.util.List;

/**
 * 受渡顧客登録レスポンスBean(顧客カルテ)
 */
public class KarteUpdateResBeanArray {
    
    /** 顧客情報配列 */
    private List<KarteUpdateResBean> karteUpdateResponse = null;

    public List<KarteUpdateResBean> getKarteUpdateResponse() {
        return karteUpdateResponse;
    }

    public void setKarteUpdateResponse(List<KarteUpdateResBean> karteUpdateResponse) {
        this.karteUpdateResponse = karteUpdateResponse;
    }
}
