package co.jp.aoyama.macchinetta.app.cash;

import java.io.Serializable;
import java.util.List;

public class CashFormModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4665481160830160246L;
	
	private List<CashForm> cashListForm;


	
	public List<CashForm> getCashListForm() {
		return cashListForm;
	}

	public void setCashListForm(List<CashForm> cashListForm) {
		this.cashListForm = cashListForm;
	}

	public CashFormModel(List<CashForm> cashListForm) {
        super();
        this.cashListForm = cashListForm;
    }
	
	public CashFormModel() {
        super();
    }

}
