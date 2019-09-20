package co.jp.aoyama.macchinetta.app.rest.api.model;

import java.util.List;

import co.jp.aoyama.macchinetta.domain.dto.ReturnGetOrderStatusShanghaiFuliangCo;

/**
 * 
 * @author liufeng
 *
 */
public class OrderStatusShanghaiFuliangCoOutput {

	/** マイン注文ID */
	private String mainorder;

	/** status code */
	private String result;

	private List<ReturnGetOrderStatusShanghaiFuliangCo> listMainorder;

	public String getMainorder() {
		return mainorder;
	}

	public void setMainorder(String mainorder) {
		this.mainorder = mainorder;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<ReturnGetOrderStatusShanghaiFuliangCo> getListMainorder() {
		return listMainorder;
	}

	public void setListMainorder(List<ReturnGetOrderStatusShanghaiFuliangCo> listMainorder) {
		this.listMainorder = listMainorder;
	}

}
