package co.jp.aoyama.macchinetta.app.password;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class PasswordForm implements Serializable {

	private static final long serialVersionUID = -7854754589334258917L;
	
	 private String userId;
	 @NotBlank
	 private String password;
	@NotBlank
	 private String passwordConfirm;
	  
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
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
}
