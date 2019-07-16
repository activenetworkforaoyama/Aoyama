package co.jp.aoyama.macchinetta.app.user;

import java.io.Serializable;

public class CategoryForm implements Serializable {

	private static final long serialVersionUID = 2496242759308493731L;
	
	// オーダーパタン　ログイン時にCO/SO/POを選択する
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	  


}
