package co.jp.aoyama.macchinetta.app.user;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class UserForm implements Serializable {

	private static final long serialVersionUID = -6044774964723003863L;

	  @NotNull
	  private String userId;
	  @NotNull
	  private String password;
	  
	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
