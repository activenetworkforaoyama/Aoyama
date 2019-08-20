package co.jp.aoyama.macchinetta.app.password;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class PasswordForm implements Serializable {

	private static final long serialVersionUID = -7854754589334258917L;
	
	 private String myUserId;
	 @NotBlank
	 private String myPassword;
	 @NotBlank
	 private String myPasswordConfirm;
	 
	public String getMyUserId() {
		return myUserId;
	}
	public String getMyPassword() {
		return myPassword;
	}
	public String getMyPasswordConfirm() {
		return myPasswordConfirm;
	}
	public void setMyUserId(String myUserId) {
		this.myUserId = myUserId;
	}
	public void setMyPassword(String myPassword) {
		this.myPassword = myPassword;
	}
	public void setMyPasswordConfirm(String myPasswordConfirm) {
		this.myPasswordConfirm = myPasswordConfirm;
	}
	  

}
