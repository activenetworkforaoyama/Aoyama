package co.jp.aoyama.macchinetta.app.rest.api.model;

/**
 * 
 * @author liufeng
 *
 */
public class ReturnReceiveOrderShanghaiFuliangCo extends ReturnResultShanghaiFuliangCo {

	/** マイン注文ID */
	private String mainorder;

	/** サブ注文ID */
	private String orderdetailid;

	/** 同じグループのうち、データ順番号 */
	private String styleno;

	public String getMainorder() {
		return mainorder;
	}

	public void setMainorder(String mainorder) {
		this.mainorder = mainorder;
	}

	public String getOrderdetailid() {
		return orderdetailid;
	}

	public void setOrderdetailid(String orderdetailid) {
		this.orderdetailid = orderdetailid;
	}

	public String getStyleno() {
		return styleno;
	}

	public void setStyleno(String styleno) {
		this.styleno = styleno;
	}

}
