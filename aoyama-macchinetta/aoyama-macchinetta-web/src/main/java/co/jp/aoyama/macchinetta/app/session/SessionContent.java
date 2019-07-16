package co.jp.aoyama.macchinetta.app.session;

import java.io.Serializable;

public class SessionContent implements Serializable {

	private static final long serialVersionUID = -5085984402733871710L;
	
	private String userId;
	// 権限
    private String authority;
    // 所属コード
    private String belongCode;
    // 所属コード名称
    private String belongName;
    // オーダーパタン　ログイン時にCO/SO/POを選択する
    private String category;
    // 店舗の業態（店舗のみ）
    private String storeBrandCode;
    
	public String getUserId() {
		return userId;
	}
	public String getBelongName() {
		return belongName;
	}
	public void setBelongName(String belongName) {
		this.belongName = belongName;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getBelongCode() {
		return belongCode;
	}
	public void setBelongCode(String belongCode) {
		this.belongCode = belongCode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStoreBrandCode() {
		return storeBrandCode;
	}
	public void setStoreBrandCode(String storeBrandCode) {
		this.storeBrandCode = storeBrandCode;
	}


}
