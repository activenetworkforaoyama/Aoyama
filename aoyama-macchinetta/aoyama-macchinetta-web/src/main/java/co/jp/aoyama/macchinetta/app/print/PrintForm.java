package co.jp.aoyama.macchinetta.app.print;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class PrintForm implements Serializable {

	private static final long serialVersionUID = -7854754589334258917L;
	
	private String Path;
	 
	public String getPath() {
		return Path;
	}
	public void setPath(String Path) {
		this.Path = Path;
	}
}
