package co.jp.aoyama.macchinetta.domain.dto;

public class OrderStatusOutput extends OrderStatus {

	private String orderno;
	private String[] Process;
	private String[] Consume;
	private String Result;
	private String appsecrets;

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String[] getProcess() {
		return Process;
	}

	public void setProcess(String[] process) {
		Process = process;
	}

	public String[] getConsume() {
		return Consume;
	}

	public void setConsume(String[] consume) {
		Consume = consume;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public String getAppsecrets() {
		return appsecrets;
	}

	public void setAppsecrets(String appsecrets) {
		this.appsecrets = appsecrets;
	}

}
