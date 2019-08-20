package co.jp.aoyama.macchinetta.domain.dto;

public class OrderStatusOutput {

	private String orderno;
	private String order_status;
	private String shipping_status;
	private String fabric_status;
	private String delivery_no;
	private String mother_delivery_no;
	private String express_company;
	private String deliver_date;
	private String expect_shipdate;
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

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getShipping_status() {
		return shipping_status;
	}

	public void setShipping_status(String shipping_status) {
		this.shipping_status = shipping_status;
	}

	public String getFabric_status() {
		return fabric_status;
	}

	public void setFabric_status(String fabric_status) {
		this.fabric_status = fabric_status;
	}

	public String getDelivery_no() {
		return delivery_no;
	}

	public void setDelivery_no(String delivery_no) {
		this.delivery_no = delivery_no;
	}

	public String getMother_delivery_no() {
		return mother_delivery_no;
	}

	public void setMother_delivery_no(String mother_delivery_no) {
		this.mother_delivery_no = mother_delivery_no;
	}

	public String getExpress_company() {
		return express_company;
	}

	public void setExpress_company(String express_company) {
		this.express_company = express_company;
	}

	public String getDeliver_date() {
		return deliver_date;
	}

	public void setDeliver_date(String deliver_date) {
		this.deliver_date = deliver_date;
	}

	public String getExpect_shipdate() {
		return expect_shipdate;
	}

	public void setExpect_shipdate(String expect_shipdate) {
		this.expect_shipdate = expect_shipdate;
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
