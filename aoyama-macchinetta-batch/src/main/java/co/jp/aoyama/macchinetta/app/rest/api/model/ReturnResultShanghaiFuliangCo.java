package co.jp.aoyama.macchinetta.app.rest.api.model;

/**
 * 
 * @author liufeng
 *
 */
public class ReturnResultShanghaiFuliangCo {

	/** status code */
	private String result;

	/** AccessToken string または Order JSON Encryption string */
	private String msgid;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

}
