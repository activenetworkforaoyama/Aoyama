<style>
.alert {
    margin-bottom: 15px;
    padding: 10px;
    border: 1px solid;
    border-radius: 4px;
    text-shadow: 0 1px 0 #ffffff;
}
.alert-error {
    background: #fff1f0;
    color: #d85030;
    border-color: rgba(216, 80, 48, 0.3);
    width:800px;
}
.alert-info {
	margin-bottom: 15px;
    padding: 10px;
    border: 1px solid;
    border-radius: 4px;
    text-shadow: 0 1px 0 #ffffff;
    background: #fff3cd;
    color: #856404;
    border-color: #fff3cd;
    width:100%;
}
</style>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/bootstrap-datepicker3.css" type="text/css">
<div class="breadcrumbs">
		<div class="col-sm-4">
			<div class="page-header float-left">
				<div class="page-title">
					<h1>オーダー内容確認</h1>
				</div>
			</div>
		</div>
		<div class="col-md-4">
		</div>
	<div class="col-md-8">
		<c:if test="${authority == '01'}">
			<c:if test="${order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5' || order.tscStatus == 'T6' || order.tscStatus == 'T7'}">
				<div class="col col-md-7">
				</div>
				<div class="col col-md-5">
					<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(2)">
						お客様注文内容確認書
					</button>
				</div>
			</c:if>
		</c:if>
		
		<c:if test="${authority == '02'}">
			<c:if test="${order.tscStatus == 'T3' || order.tscStatus == 'T4'}">
				<c:if test="${order.makerFactoryStatus == 'F0'}">
					<div class="col col-md-7">
					</div>
					<div class="col col-md-5">
						<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(2)">
							お客様注文内容確認書
						</button>
					</div>
				</c:if>
			</c:if>
		</c:if>
		
		<c:if test="${authority == '02'}">
			<c:if test="${order.tscStatus == 'T3' || order.tscStatus == 'T4'}">
				<c:if test="${order.makerFactoryStatus == 'F1' || order.makerFactoryStatus == 'F2'}">
				<div class="col col-md-4">
				</div>
				<div class="col col-md-5">
					<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(2)">
						お客様注文内容確認書
					</button>
				</div>
				<div class="col col-md-3">
					<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(3)">
						工場指示書
					</button>
				</div>
				</c:if>
			</c:if>
		</c:if>
		
		<c:if test="${authority == '02'}">
			<c:if test="${order.tscStatus == 'T5' || order.tscStatus == 'T6' || order.tscStatus == 'T7'}">
				<c:if test="${order.makerFactoryStatus == 'F1' || order.makerFactoryStatus == 'F2'}">
					<c:choose>
						<c:when test="${order.hostTransmitARow != null && order.hostTransmitARow != '' && order.shippingNumber != null && order.shippingNumber != ''}">
							<div class="col col-md-5">
								<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(2)">
									お客様注文内容確認書
								</button>
							</div>
							
							<div class="col col-md-4">
								<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(1)">
									注文内容確認書
								</button>
							</div>
							
							<div class="col col-md-3">
								<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(3)">
									工場指示書
								</button>
							</div>
						</c:when>
					
						<c:otherwise>
							<div class="col col-md-4">
							</div>
							<div class="col col-md-5">
								<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(2)">
									お客様注文内容確認書
								</button>
							</div>
							<div class="col col-md-3">
								<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(3)">
									工場指示書
								</button>
							</div>
						</c:otherwise>
					</c:choose>
				</c:if>
			</c:if>
		</c:if>
		
		<c:if test="${authority == '02'}">
			<c:if test="${order.tscStatus == 'T5'}">
				<c:if test="${order.makerFactoryStatus == 'F0'}">
					<c:choose>
						<c:when test="${order.hostTransmitARow != null && order.hostTransmitARow != '' && order.shippingNumber != null && order.shippingNumber != ''}">
						
							<div class="col col-md-3">
							</div>
							<div class="col col-md-5">
								<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(2)">
									お客様注文内容確認書
								</button>
							</div>
							
							<div class="col col-md-4">
								<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(1)">
									注文内容確認書
								</button>
							</div>
						</c:when>
					
						<c:otherwise>
							<div class="col col-md-4">
							</div>
							
							<div class="col col-md-3">
							</div>
							<div class="col col-md-5">
								<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(2)">
									お客様注文内容確認書
								</button>
							</div>
						</c:otherwise>
					</c:choose>
				</c:if>
			</c:if>
		</c:if>
		
		<c:if test="${authority == '03'}">
			<c:if test="${order.tscStatus == 'T3' || order.tscStatus == 'T4'}">
				<c:if test="${order.makerFactoryStatus == 'F1' || order.makerFactoryStatus == 'F2'}">
					<div class="col col-md-9">
					</div>
					<div class="col col-md-3">
						<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(3)">
							工場指示書
						</button>
					</div>
				</c:if>
			</c:if>
		</c:if>
		
		<c:if test="${authority == '03'}">
			<c:if test="${order.tscStatus == 'T5' || order.tscStatus == 'T6' || order.tscStatus == 'T7'}">
				<c:if test="${order.makerFactoryStatus == 'F1' || order.makerFactoryStatus == 'F2'}">
					<c:choose>
						<c:when test="${order.hostTransmitARow != null && order.hostTransmitARow != '' && order.shippingNumber != null && order.shippingNumber != ''}">
							<div class="col col-md-5">
							</div>
							
							<div class="col col-md-4">
								<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(1)">
									注文内容確認書
								</button>
							</div>
							
							<div class="col col-md-3">
								<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(3)">
									工場指示書
								</button>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col col-md-5">
							</div>
							
							<div class="col col-md-4">
							</div>
							
							<div class="col col-md-3">
								<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(3)">
									工場指示書
								</button>
							</div>
						</c:otherwise>
					</c:choose>
				</c:if>
			</c:if>
		</c:if>
		
		<c:if test="${authority == '03'}">
			<c:if test="${order.tscStatus == 'T5'}">
				<c:if test="${order.makerFactoryStatus == 'F0'}">
					<c:if test="${order.hostTransmitARow != null && order.hostTransmitARow != '' && order.shippingNumber != null && order.shippingNumber != ''}">
						<div class="col col-md-5">
						</div>
						
						<div class="col col-md-3">
						</div>
						
						<div class="col col-md-4">
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(1)">
								注文内容確認書
							</button>
						</div>
						
					</c:if>
				</c:if>
			</c:if>
		</c:if>
		
		<c:if test="${authority == '04'}">
			<c:if test="${order.tscStatus == 'T3' || order.tscStatus == 'T4'}">
				<c:if test="${order.makerFactoryStatus == 'F1' || order.makerFactoryStatus == 'F2'}">
					<div class="col col-md-9">
					</div>
					<div class="col col-md-3">
						<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(3)">
							工場指示書
						</button>
					</div>
				</c:if>
			</c:if>
		</c:if>
		
		<c:if test="${authority == '04'}">
			<c:if test="${order.tscStatus == 'T5' || order.tscStatus == 'T6' || order.tscStatus == 'T7'}">
				<c:if test="${order.makerFactoryStatus == 'F1' || order.makerFactoryStatus == 'F2'}">
					<c:choose>
					<c:when test="${order.hostTransmitARow != null && order.hostTransmitARow != '' && order.shippingNumber != null && order.shippingNumber != ''}">
						<div class="col col-md-4">
						</div>
						
						<div class="col col-md-5">
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(1)">
								注文内容確認書
							</button>
						</div>
						<div class="col col-md-3">
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(3)">
								工場指示書
							</button>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col col-md-4">
						</div>
						
						<div class="col col-md-5">
						</div>
						<div class="col col-md-3">
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(3)">
								工場指示書
							</button>
						</div>
					</c:otherwise>
					</c:choose>
				</c:if>
			</c:if>
		</c:if>
		<c:if test="${authority == '04'}">
			<c:if test="${order.tscStatus == 'T5'}">
				<c:if test="${order.makerFactoryStatus == 'F0'}">
					<c:if test="${order.hostTransmitARow != null && order.hostTransmitARow != '' && order.shippingNumber != null && order.shippingNumber != ''}">
						<div class="col col-md-4">
						</div>
						
						<div class="col col-md-3">
						</div>
						
						<div class="col col-md-5">
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(1)">
								注文内容確認書
							</button>
						</div>
						
					</c:if>
				</c:if>
			</c:if>
		</c:if>
	</div>
</div>
<div class="col-md-12">
<div class="alert alert-info" id="errorResult" style="display:none"></div>
</div>
<div class="content mt-3">

<div class="alert alert-error" id="errormssage"  style="display:none"></div>
<t:messagesPanel  messagesAttributeName="resultMessages"/>
	<div class="animated fadeIn">
		<div class="row">
			<div class="col col-lg-6">
				<c:if test="${authority == '01' || authority == '02' || authority == '05'}">
					<div class="row">
						<div class="col col-md-4">
							<label class=" form-control-label">お客様名</label>
						</div>
						<c:if test="${order.custNm != null && order.custKanaNm != null}">
						<div class="col-12 col-md-8">
							<label class=" form-control-label-value">${f:h(order.custNm)}(${f:h(order.custKanaNm)})</label>様
						</div>
						</c:if>
						<c:if test="${order.custNm != null && order.custKanaNm == null}">
						<div class="col-12 col-md-8">
							<label class=" form-control-label-value">${f:h(order.custNm)}</label>様
						</div>
						</c:if>
						<c:if test="${order.custNm != null && order.custKanaNm == null}">
						<div class="col-12 col-md-8">
							<label class=" form-control-label-value">(${f:h(order.custKanaNm)})</label>様
						</div>
						</c:if>
						<c:if test="${order.custNm == null && order.custKanaNm == null}">
						<div class="col-12 col-md-8">
						</div>
						</c:if>
					</div>
				</c:if>
				<div class="row">
					<div class="col col-md-4">
						<label class=" form-control-label">ステータス</label>
					</div>
					<div class="col-12 col-md-8">
						<label class=" form-control-label-value" id="status_appear"></label>
					</div>
				</div>
			</div>
			<c:if test="${authority == '01' || authority == '02'}">
				<div class="col col-lg-6">
					<div class="row">
						<div class="col text-right">
							<strong>ご請求金額：￥<label id="header_billingAmount"></label>（内消費税￥<label id="header_consumptionTaxAmount"></label>）</strong>
						</div>
					</div>
					<div class="row">
						<div class="col text-right">商品金額：￥<label id="header_productPrice"></label></div>
					</div>
					<div class="row">
						<div class="col text-right">オプション金額：￥<label id="header_optionPrice"></label></div>
					</div>
					<div class="row">
						<div class="col text-right">合計金額：￥<label id="header_totalPrice"></label></div>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</div>
<br/>
<br>
<br>
<br>

<c:if test="${authority == '01' || authority == '02'}">
	<br/>
	<br>
	<br>

</c:if>
<div class="col-md-12">
	<div class="card">
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-6">
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">注文ID</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${order.orderId}</label></strong>
						</div>
					</div>
					<c:if test="${authority == '01' || authority == '02' || authority == '05'}">
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">会員番号</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">${order.custCd}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">お客様氏名</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">${f:h(order.custNm)}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">フリガナ</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">${f:h(order.custKanaNm)}</label></strong>
							</div>
						</div>
						<c:if test="${authority == '01' || authority == '03' || authority == '04'}">
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">承り日</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value" id="product_orderd_date"></label></strong>
							</div>
						</div>
						</c:if>
						<c:if test="${authority == '02' || authority == '05'}">
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">名簿納期</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value" id="cust_deliver_date"></label></strong>
							</div>
						</div>
						</c:if>
					</c:if>
				</div>
				<c:if test="${authority == '01' || authority == '02' || authority == '05'}">
					<div class="col col-lg-6">
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">お渡し日</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value" id="cust_shop_delivery_date"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">スタッフ</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">${f:h(order.custStaff)}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">区分</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value" id="cust_type"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">出荷先</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value" id="cust_shipping_destination"></label></strong>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="row">
							<div class="col col-lg-12">
								<div class="row form-group">
									<div  style="padding-left:15px;width:12.5%"><label class=" form-control-label">お客様備考</label></div>
									<div style="padding-right:15px;padding-left:15px;width:87.5%">
										<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${f:h(order.custRemark)}</textarea>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</div>

<div class="col-md-12" id="op_meijyaringu_div">
	<div class="card" id="nav_alter_div">
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-4">
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">フルレングス</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="fullLength"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">ショルダー</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="shoulder"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">リーチ（右）</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="reachRight"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">リーチ（左）</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="reachLeft"></label>cm</strong>
						</div>
					</div>
				</div>

				<div class="col col-lg-4">
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">アウトバスト</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="outBust"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">バスト</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="bust"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">JKウエスト</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="jacketWaist"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">PTウエスト</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="pantsWaist"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">ヒップ</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="hip"></label>cm</strong>
						</div>
					</div>
				</div>
				
				<div class="col col-lg-4">
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">ワタリ（右）</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="spanRight"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">ワタリ（左）</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="spanLeft"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">ふくらはぎ（右）</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="calfRight"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">ふくらはぎ（左）</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="calfLeft"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6">
							<label class=" form-control-label">ネック</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="neck"></label>cm</strong>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-md-12">
	<div class="card" id="nav2_product_div">
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">ITEM</label>
						</div>
						<div class="col-12 col-md-3">
							<strong><label class=" form-control-label-value" id="product_item"></label></strong>
						</div>
					</div>
					<c:if test="${order.productItem == '01'}">
						<c:if test="${order.productIs3piece == '0009901'}">
							<div class="row" id="threePiece_div">
								<div class="col col-md-3">
									<label class=" form-control-label">３Piece</label>
								</div>
								<div class="col col-md-8">
									<strong><label class=" form-control-label-value">無し</label></strong>
								</div>
								<div class="col-12 col-md-1" align="right">
									<strong><label class=" form-control-label-value" id="product_is_3Piece_rt_price"></label></strong>
								</div>
							</div>
						</c:if>
						
						<c:if test="${order.productIs3piece == '0009902'}">
							<div class="row" id="threePiece_div">
								<div class="col col-md-3">
									<label class=" form-control-label">３Piece</label>
								</div>
								<div class="col col-md-8">
									<strong><label class=" form-control-label-value">有り</label></strong>
								</div>
								<div class="col-12 col-md-1" align="right">
									<strong><label class=" form-control-label-value" id="product_is_3Piece_rt_price"></label></strong>
								</div>
							</div>
						</c:if>
						<c:if test="${order.productSparePantsClass == '0009901'}">
							<div class="row" id="sparePants_div">
								<div class="col col-md-3">
									<label class=" form-control-label">スペアパンツ</label>
								</div>
								<div class="col col-md-8">
									<strong><label class=" form-control-label-value">無し</label></strong>
								</div>
								<div class="col-12 col-md-1" align="right">
									<strong><label class=" form-control-label-value" id="product_spare_pants_rt_price"></label></strong>
								</div>
							</div>
						</c:if>
						<c:if test="${order.productSparePantsClass == '0009902'}">
							<div class="row" id="sparePants_div">
								<div class="col col-md-3">
									<label class=" form-control-label">スペアパンツ</label>
								</div>
								<div class="col col-md-8">
									<strong><label class=" form-control-label-value">2パンツ</label></strong>
								</div>
								<div class="col-12 col-md-1" align="right">
									<strong><label class=" form-control-label-value" id="product_spare_pants_rt_price"></label></strong>
								</div>
							</div>
						</c:if>
					</c:if>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">生地品番</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${order.productFabricNo}-${order.fabricColor}${order.fabricPattern}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">カテゴリ</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">標準</label></strong>
						</div>
					</div>
					<c:if test="${order.productBrandType == '0'}">
						<div class="row" id="brandName_div">
							<div class="col col-md-3">
								<label class=" form-control-label">ブランドネーム</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">無し</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${order.productBrandType == '1'}">
						<div class="row" id="brandName_div">
							<div class="col col-md-3">
								<label class=" form-control-label">ブランドネーム</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">有り</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${order.productFabricNmNecessity == '0'}">
						<div class="row" id="clothName_div">
							<div class="col col-md-3">
								<label class=" form-control-label">生地ネーム</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">無し</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${order.productFabricNmNecessity == '1'}">
						<div class="row" id="clothName_div">
							<div class="col col-md-3">
								<label class=" form-control-label">生地ネーム</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">有り</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${order.productEmbroideryNecessity == '0'}">
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">刺繍入れ</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">無し</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${order.productEmbroideryNecessity == '1'}">
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">刺繍入れ</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">有り</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${order.productEmbroideryNecessity == '1'}">
						<div id="embroidered_yes_area">
							<div class="row">
								<div class="col col-md-3">
									<label class=" form-control-label">刺繍ネーム</label>
								</div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${order.productEmbroideryNm}</label></strong>
								</div>
							</div>
							<c:if test="${order.productEmbroideryFont == '14（花文字）'}">
								<div class="row">
									<div class="col col-md-3">
										<label class=" form-control-label">刺繍書体</label>
									</div>
									<div class="col-12 col-md-9">
										<strong><label class=" form-control-label-value">14（花文字）</label></strong>
									</div>
								</div>
							</c:if>
							<c:if test="${order.productEmbroideryFont == '48（ブロック）'}">
								<div class="row">
									<div class="col col-md-3">
										<label class=" form-control-label">刺繍書体</label>
									</div>
									<div class="col-12 col-md-9">
										<strong><label class=" form-control-label-value">48（ブロック）</label></strong>
									</div>
								</div>
							</c:if>
							<div class="row">
								<div class="col col-md-3">
									<label class=" form-control-label">刺繍糸色</label>
								</div>
								<div class="col-12 col-md-3">
									<strong><label class=" form-control-label-value" id="product_embroidery_thread_color">${order.productEmbroideryThreadColor}</label></strong>
								</div>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">生地ブランド</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${order.productFabricBrandNm}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">素材名</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${order.productServiceNm}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">組成表示　表地</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value" id="composFrtFabric">${order.productComposFrtFabric}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">組成表示　胴裏地</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value" id="composBodyLiner"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">組成表示　袖裏地</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${order.productComposSleeveLiner}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">取扱注意</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${order.productNotice}</label></strong>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-md-12" id="op_jacket_div" style="display:none;">
<div class="card" id="nav2_option_div">
		<div class="card-header">
			<strong class="card-title">JACKET</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3">
							<strong><label class=" form-control-label">JACKETモデル</label></strong>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value">${order.jkModelNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_model_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">フロント釦数</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.jkFrtBtnNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_frt_btn_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">ラペルデザイン</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.jkLapelDesignNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_lapel_design_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">台場</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.jkDaibaNm }</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_daiba_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">裏仕様</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.jkInnerClothNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_inner_cloth_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">腰ポケット</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.jkWaistPktNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_waist_pkt_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">チェンジポケット</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.jkChgPktNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_chg_pkt_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">スランテッドポケット</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.jkSlantedPktNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_slanted_pkt_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">袖口</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.jkCuffNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_cuff_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">AMFステッチ</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.jkStitchTypeNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_stitch_type_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">ベント</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.jkVentNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_vent_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label" id="jkInnerBodyCloth">胴裏素材</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="jkInnerBodyCloth_appear">${order.jkInnerBodyClothNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_inner_body_cloth_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label" id="jkInnerSleeveCloth">袖裏素材</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="jkInnerSleeveCloth_appear">${order.jkInnerSleeveClothNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_inner_sleeve_cloth_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label" id="jkBtnMaterial">釦素材</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="jkBtnMaterial_appear">${order.jkBtnMaterialNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="jk_btn_material_rt_price"></label></strong>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="card-body">
				<div class="row">
					<div class="col col-lg-12">
						<div class="row">
							<div class="col col-md-3">
								<strong><label class=" form-control-label">JACKETサイズ</label></strong>
							</div>
							<div class="col-12 col-md-3">
								<strong><label class=" form-control-label-value">${order.corJkDrop}&nbsp &nbsp &nbsp${order.corJkSize}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<strong><label class=" form-control-label">JACKET補正</label></strong>
							</div>
							<div class="col-12 col-md-3">
								<label class=" form-control-label">着丈修正</label>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${order.corJkBodylengthGross}</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">ウエスト修正</label>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${order.corJkWaistGross}</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">袖丈右修正</label>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${order.corJkRightsleeveGross}</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">袖丈左修正</label>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${order.corJkLeftsleeveGross}</label>cm</strong> 
							</div>
						</div>
					</div>
				</div>
			</div>
	</div>
</div>

<div class="col-md-12" id="op_gilet_div" style="display:none;">
	<div class="card" id="nav2_alter_div">
		<div class="card-header">
			<strong class="card-title">GILET</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3">
							<strong><label class=" form-control-label">GILETモデル</label></strong>
						</div>
						<div class="col col-md-3">
							<strong><label class=" form-control-label-value">${order.glModelNm}</label></strong>
						</div>
					</div>
					<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">胸ポケット</label>
							</div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${order.glBreastPktNm}</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="gl_breast_pkt_rt_price"></label></strong>
							</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">AMFステッチ</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.glAmfStitchNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="gl_amf_stitch_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">背裏地素材</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="glBackCloth_appear">${order.glBackClothNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="gl_back_cloth_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">内側裏地素材</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="glInnnerCloth_appear">${order.glInnnerClothNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="gl_innner_cloth_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">釦素材</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="glFrtBtn_appear">${order.glFrtBtnNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="gl_frt_btn_rt_price"></label></strong>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3">
							<strong><label class=" form-control-label">GILETサイズ</label></strong>
						</div>
						<div class="col-12 col-md-3">
							<strong><label class=" form-control-label-value">${order.corGlDrop}&nbsp &nbsp &nbsp${order.corGlSize}</label></strong>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	
<div class="col-md-12" id="op_pants_div" style="display:none;">
	<div class="card" id="nav2_alter_div">
		<div class="card-header">
			<strong class="card-title">PANTS</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3">
							<strong><label class=" form-control-label">PANTSモデル</label></strong>
						</div>
						<div class="col col-md-3">
							<strong><label class=" form-control-label-value">${order.ptModelNm}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">タック</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value">${order.ptTackNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
						<strong><label class=" form-control-label-value" id="pt_tack_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">アジャスター仕様</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.ptAdjusterNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt_adjuster_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">裾上げ</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="op_hemUp">${order.ptHemUpNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt_hem_up_rt_price"></label></strong>
						</div>
					</div>
					<c:if test="${order.ptHemUpNm == 'ダブルスナップ' || order.ptHemUpNm == 'ダブル糸'}">
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">ダブル幅</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value">${order.ptDblWidthNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt_dbl_width_rt_price"></label></strong>
						</div>
					</div>
					</c:if>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">釦素材</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="ptBtnMaterial_appear">${order.ptBtnMaterialNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt_btn_material_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">エイト（滑り止め）</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.ptNonSlipNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt_non_slip_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">シック大（股補強）</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.ptChicSlipNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt_chic_slip_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">形状記憶</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.ptShapeMemoryNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt_shape_memory_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">靴ずれ</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.ptShoeSoreNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt_shoe_sore_rt_price"></label></strong>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3">
							<strong><label class=" form-control-label">PANTSサイズ</label></strong>
						</div>
						<div class="col-12 col-md-3">
							<strong><label class=" form-control-label-value">${order.corPtDrop}&nbsp &nbsp &nbsp${order.corPtSize}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<strong><label class=" form-control-label">PANTS補正</label></strong>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPtWaistGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ワタリ修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPtThighwidthGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">裾幅</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPtHemwidthGross}</label>cm</strong>
						</div>
						
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">股下</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="pantsCorinseamGross"></label>cm</strong>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-md-12" id="op2_pants_div" style="display:none;">
	<div class="card" id="nav2_alter_div">
		<div class="card-header">
			<strong class="card-title">PANTS（2本目）</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3">
							<strong><label class=" form-control-label">PANTSモデル</label></strong>
						</div>
						<div class="col col-md-3">
							<strong><label class=" form-control-label-value">${order.pt2ModelNm}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">タック</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value">${order.pt2TackNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
						<strong><label class=" form-control-label-value" id="pt2_tack_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">アジャスター仕様</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.pt2AdjusterNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt2_adjuster_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">裾上げ</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="op_hemUp">${order.pt2HemUpNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt2_hem_up_rt_price"></label></strong>
						</div>
					</div>
					<c:if test="${order.pt2HemUpNm == 'ダブルスナップ' || order.pt2HemUpNm == 'ダブル糸'}">
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">ダブル幅</label>
							</div>
							<div class="col col-md-8">
							<strong><label class=" form-control-label-value">${order.pt2DblWidthNm}</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt2_dbl_width_rt_price"></label></strong>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">釦素材</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="pt2BtnMaterial_appear">${order.pt2BtnMaterialNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt2_btn_material_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">エイト（滑り止め）</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.pt2NonSlipNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt2_non_slip_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">シック大（股補強）</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.pt2ChicSlipNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt2_chic_slip_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">形状記憶</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.pt2ShapeMemoryNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt2_shape_memory_rt_price"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">靴ずれ</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${order.pt2ShoeSoreNm}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="pt2_shoe_sore_rt_price"></label></strong>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3">
							<strong><label class=" form-control-label">PANTSサイズ</label></strong>
						</div>
						<div class="col-12 col-md-3">
							<strong><label class=" form-control-label-value">${order.corPt2Drop}&nbsp &nbsp &nbsp${order.corPt2Size}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<strong><label class=" form-control-label">PANTS補正</label></strong>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPt2WaistGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ワタリ修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPt2ThighwidthGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">裾幅</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPt2HemwidthGross}</label>cm</strong>
						</div>
						
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">股下</label>
						</div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="pants2CorinseamGross"></label>cm</strong>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<c:if test="${authority == '01' || authority == '02'}">
<div class="col-md-12">
	<div class="card">
		<div class="card-body">
			<div class="row">
					<div class="col col-lg-6">
						<label class=" form-control-label">ご請求金額</label>
					</div>
					<div class="col col-lg-6">
						<div class="row">
							<div class="col text-right">
							<strong><span>ご請求金額：￥<label id="bottom_billingAmount"></label>（内消費税￥<label id="bottom_consumptionTaxAmount"></label>）</span></strong>
							</div>
						</div>
							<div class="row">
							<div class="col text-right">
							<span class="smlFnt85">商品金額：￥<label id="bottom_productPrice"></label></span><br /> 
							</div>
							</div>
							<div class="row">
							<div class="col text-right">
							<span class="smlFnt85">オプション金額：￥<label id="bottom_optionPrice"></label></span><br /> 
							</div>
							</div>
							<div class="row">
							<div class="col text-right">
							<span class="smlFnt85">合計金額：￥<label id="bottom_totalPrice"></label></span>
							</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:if>

<c:if test="${authority == '01' || authority == '02' || authority == '05'}">
<c:if test="${order.tscStatus == 'T6' || order.tscStatus == 'T7'}">
<div class="col-md-12" id="jkCorrectAgain" style="display:none;">
	<div class="card">
		<div class="card-header">
			<strong class="card-title">JACKET店舗補正</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="corJkBodylengthCorrectAgain">${order.corJkBodylengthCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="corJkWaistCorrectAgain">${order.corJkWaistCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">袖丈右修正</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value" id="corJkRightsleeveCorrectAgain">${order.corJkRightsleeveCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">袖丈左修正</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="corJkLeftsleeveCorrectAgain">${order.corJkLeftsleeveCorrectAgain}</label>cm</strong> 
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-md-12" id="ptCorrectAgain" style="display:none;">
	<div class="card">
		<div class="card-header">
			<strong class="card-title">PANTS店舗補正</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="corPtWaistCorrectAgain">${order.corPtWaistCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">ワタリ修正</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="corPtHipCorrectAgain">${order.corPtHipCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">ワタリ幅修正</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value" id="corPtThighwidthCorrectAgain">${order.corPtThighwidthCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">裾幅修正</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="corPtHemwidthCorrectAgain">${order.corPtHemwidthCorrectAgain}</label>cm</strong> 
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">股下右修正</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="corPtRightinseamCorrectAgain">${order.corPtRightinseamCorrectAgain}</label>cm</strong> 
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">股下左修正</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="corPtLeftinseamCorrectAgain">${order.corPtLeftinseamCorrectAgain}</label>cm</strong> 
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-md-12" id="pt2CorrectAgain" style="display:none;">
	<div class="card">
		<div class="card-header">
			<strong class="card-title">PANTS（2本目）店舗補正</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="corPt2WaistCorrectAgain">${order.corPt2WaistCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">ワタリ修正</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="corPt2HipCorrectAgain">${order.corPt2HipCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">ワタリ幅修正</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value" id="corPt2ThighwidthCorrectAgain">${order.corPt2ThighwidthCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">裾幅修正</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="corPt2HemwidthCorrectAgain">${order.corPt2HemwidthCorrectAgain}</label>cm</strong> 
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">股下右修正</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="corPt2RightinseamCorrectAgain">${order.corPt2RightinseamCorrectAgain}</label>cm</strong> 
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">股下左修正</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="corPt2LeftinseamCorrectAgain">${order.corPt2LeftinseamCorrectAgain}</label>cm</strong> 
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-md-12" id="correctionMemoAgain" style="display:none;">
	<div class="card">
		<div class="card-header">
			<strong class="card-title">店舗補正入力欄</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${order.corStoreCorrectionMemoAgain}</textarea>
				</div>	
			</div>
		</div>
	</div>
</div>
</c:if>
</c:if>

<c:if test="${authority == '02' || authority == '03' || authority == '04' || authority == '05'}">
<div class="col-md-12">
	<div class="card">
		
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<c:if test="${authority == '02' || authority == '03' || authority == '05'}">
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">下代価格</label>
							</div>
							<div class="col col-md-8">
								<strong><label class=" form-control-label-value" id="wsPrice"></label></strong>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">出荷日</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="shippingDateFormat"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">積載日</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="loadingDateFormat"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">生地使用量</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value">${order.fabricUsedMount}</label></strong>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</c:if>

<c:if test="${authority == '01'}">
<c:if test="${userId == order.createdUserId}">
<c:if test="${order.isCancelled != '1'}">
	<div class="col-md-12">
		<div class="card" id="nav2_alter_div">
			<div class="row">
				<div class="col-md-12">
					<div class="card-body">
						<div class="row">
							<c:if test="${order.makerFactoryStatus == 'F0' && (order.tscStatus == 'T2' || order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5')}">		
								<div class="col col-md-2">
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-info btn-block" id="backButton" >
										一覧へ戻る
									</button>
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-danger btn-block" id="ChangeOrderValue">
										注文訂正
									</button>
								</div>
								<div class="col col-md-2">
								</div>
							</c:if>
							<c:if test="${order.tscStatus == 'T6' && (order.productItem == '01' || order.productItem == '02' || order.productItem == '03')}">		
								<div class="col col-md-4">
									<button type="button" class="btn btn-info btn-block" id="backButton" >
										一覧へ戻る
									</button>
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-primary btn-block" id="goRecorrection">
										お渡し時再補正入力
									</button>
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-danger btn-block" id="ChangeStatus">
										お渡し済
									</button>
								</div>
							</c:if>
							<c:if test="${order.tscStatus == 'T6' && (order.productItem == '04')}">		
								<div class="col col-md-2">
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-info btn-block" id="backButton" >
										一覧へ戻る
									</button>
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-danger btn-block" id="ChangeStatus">
										お渡し済
									</button>
								</div>
								<div class="col col-md-2">
								</div>
							</c:if>
							<c:if test="${order.tscStatus == 'T7' && (order.productItem == '01' || order.productItem == '02' || order.productItem == '03')}">		
								<div class="col col-md-2">
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-info btn-block" id="backButton" >
										一覧へ戻る
									</button>
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-primary btn-block" id="goRecorrection">
										お渡し時再補正入力
									</button>
								</div>
								<div class="col col-md-2">
								</div>
							</c:if>
							<c:if test="${order.tscStatus == 'T7' && (order.productItem == '04')}">		
								<div class="col col-md-4">
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-info btn-block" id="backButton" >
										一覧へ戻る
									</button>
								</div>
								<div class="col col-md-4">
								</div>
							</c:if>
							<c:if test="${(order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5') && (order.makerFactoryStatus == 'F1' || order.makerFactoryStatus == 'F2')}">
								<div class="col col-md-4">
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-info btn-block" id="backButton" >
										一覧へ戻る
									</button>
								</div>
								<div class="col col-md-4">
								</div>							
							</c:if>
						</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</c:if>
</c:if>

<c:if test="${authority == '01'}">
<c:if test="${userId != order.createdUserId}">
	<div class="col-md-12">
		<div class="card">
			<div class="col-md-12">
				<div class="card-body">
					<div class="row">
						<div class="col col-md-4">
						</div>
						<div class="col col-md-4">
							<button type="button" class="btn btn-info btn-block" id="backButton">
								一覧へ戻る
							</button>
						</div>
						<div class="col col-md-4">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>							
</c:if>
</c:if>

<c:if test="${authority == '02'}">
<c:if test="${order.isCancelled != '1'}">
	<div class="col-md-12">
		<div class="card" id="nav2_alter_div">
			<c:if test="${order.makerFactoryStatus == 'F0' && order.tscStatus == 'T2'}">		
			<div class="row">
				<div class="col-md-12">
					<div class="card-body">
						<div class="row">
							<div class="col col-md-2">
							</div>
							<div class="col col-md-4">
								<button type="button" class="btn btn-info btn-block" id="backButton" >
									一覧へ戻る
								</button>
							</div>
							<div class="col col-md-4">
								<button type="button" class="btn btn-danger btn-block" id="ChangeOrderValue">
									注文訂正
								</button>
							</div>
							<div class="col col-md-2">
							</div>
						</div>
					</div>
				</div>
			</div>
			</c:if>
			<c:if test="${((order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5') && order.makerFactoryStatus == 'F1') || ((order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5') && order.makerFactoryStatus == 'F0') }">
			<div class="row">
				<div class="col-md-12">
					<div class="card-body">
						<div class="row">
							<div class="col col-md-2">
							</div>
							<div class="col col-md-4">
								<input type="text" id="nextGenerationDisplay" class="input-sm form-control-sm form-control" value="${order.wsPrice}" maxlength="10"/>
							</div>
							<div class="col col-md-4">
								<button type="button" class="btn btn-warning btn-block" id="nextGenerationCount">
									下代自動計算
								</button>
							</div>
							<div class="col col-md-2">
							</div>
						</div>
					</div>
				</div>
			</div>
			</c:if>
			<c:if test="${((order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5') && order.makerFactoryStatus == 'F1') || ((order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5') && order.makerFactoryStatus == 'F0') }">
				<div class="row">
					<div class="col-md-12">
						<div class="card-body">
							<div class="row">
								<div class="col col-md-2">
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-info btn-block" id="backButton">
										一覧へ戻る
									</button>
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-primary btn-block" id="nextGenerationSave">
										確定
									</button>
								</div>
								<div class="col col-md-2">
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${((order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5') && order.makerFactoryStatus == 'F2') || (order.tscStatus == 'T6' || order.tscStatus == 'T7') }">
				<div class="row">
					<div class="col-md-12">
						<div class="card-body">
							<div class="row">
								<div class="col col-md-4">
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-info btn-block" id="backButton">
										一覧へ戻る
									</button>
								</div>
								<div class="col col-md-4">
								 </div>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			</div>
		</div>
	</c:if>
</c:if>

<c:if test="${authority == '03' || authority == '05'}">
<c:if test="${order.isCancelled != '1'}">
	<div class="col-md-12">
		<div class="card" id="nav2_alter_div">
			<div class="row">
				<div class="col-md-12">
					<div class="card-body">
						<div class="row">
							<div class="col col-md-4">
								
							</div>
							<div class="col col-md-4">
								<button type="button" class="btn btn-info btn-block" id="backButton">
									一覧へ戻る
								</button>
							</div>
							<div class="col col-md-4">
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:if>
</c:if>


<c:if test="${authority == '04'}">
<c:if test="${order.isCancelled != '1'}">
	<div class="col-md-12">
		<div class="card" id="nav2_alter_div">
			<c:if test="${order.makerFactoryStatus == 'F1' }">
			<div class="row">
				<div class="col-md-12">
					<div class="card-body">
						<div class="row">
							<div class="col col-md-4">
								生地使用量:
								<div class="col col-xl-6 float-right">
									<input type="text" id="fabricUsedMount" class="input-sm form-control-sm form-control"  onkeyup="clearNoNum(this)" value="${order.fabricUsedMount}" maxlength="6"/>
								</div>
							</div>
							<div class="col col-md-4">
								出荷日:
								<div class="col col-xl-6 float-right">
									<input type="text" id="shippingDate" placeholder="年/月/日" class="input-sm form-control-sm form-control" />
									
								</div>
							</div>
							<div class="col col-md-4">
								積載日:
								<div class="col col-xl-6 float-right">
									<input type="text" id="loadingDate" placeholder="年/月/日" class="input-sm form-control-sm form-control" />
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="card-body">
						<div class="row">
							<div class="col col-md-4">
								<button type="button" class="btn btn-info btn-block" id="backButton">
									一覧へ戻る
								</button>
							</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-primary btn-block" id="saveValue">
										保存
									</button>
								</div>
								<div class="col col-md-4">
									<button type="submit" class="btn btn-danger btn-block" id="saveOrChangeValue">
										生産終了にする
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${order.tscStatus == 'T6' || order.tscStatus == 'T7' || order.makerFactoryStatus == 'F2'}">
			<div class="row">
				<div class="col-md-12">
					<div class="card-body">
						<div class="row">
							<div class="col col-md-4">
							</div>
							<div class="col col-md-4">
								<button type="button" class="btn btn-info btn-block" id="backButton">
									一覧へ戻る
								</button>
							</div>
							<div class="col col-md-4">
							</div>
						</div>
						</div>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</c:if>
</c:if>
<c:if test="${order.isCancelled == '1'}">
	<div class="col-md-12">
		<div class="card">
			<div class="col-md-12">
				<div class="card-body">
					<div class="row">
						<div class="col col-md-4">
						</div>
						<div class="col col-md-4">
							<button type="button" class="btn btn-info btn-block" id="backButton">
								一覧へ戻る
							</button>
						</div>
						<div class="col col-md-4">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:if>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">

//CSRF令牌
jQuery(function () {
	// CSRFトークン値を連携するためのリクエストヘッダ名を取得する
    var headerName = jQuery("meta[name='_csrf_header']").attr("content");
    // CSRFトークン値を取得する
    var tokenValue = jQuery("meta[name='_csrf']").attr("content");
    jQuery(document).ajaxSend(function(e, xhr, options) {
        // リクエストヘッダにCSRFトークン値を設定する
        xhr.setRequestHeader(headerName, tokenValue);
    });
});

var authority = "${sessionContent.authority}";
var errorResult = "${errorResult}";

if(authority == "01"){
	
}else{
	if(isNotEmpty(errorResult)){
		appendAlert('errorResult', getMsgByOneArg('msg117',errorResult));
	}
}

var contextPath = jQuery("meta[name='contextPath']").attr("content");
		var statusList = {
		T0 : "一時保存",
		T1 : "取り置き",
		T2 : "登録済",
		T3 : "会計済",
		T4 : "商品部承認済",
		T5 : "メーカー承認済",
		T6 : "仕入済",
		T7 : "お渡し済"
	};

		var factoryStatusList = {
				F0 : "生産開始前",
				F1 : "生産開始",
				F2 : "生産終了"
			};
if("${order.makerFactoryStatus}" == "F1" || "${order.makerFactoryStatus}" == "F2"){
	jQuery("#status_appear").html(statusList["${order.tscStatus}"] +" "+ "・" + " " + factoryStatusList["${order.makerFactoryStatus}"]);
}
else{
	jQuery("#status_appear").html(statusList["${order.tscStatus}"]);
}
	
	//お客様情報_区分の内容表示
	var custType = {
		t01 : "一般",
		t02 : "社着",
		t03 : "サンプル",
		t04 : "ゲージ",
		t05 : "本社内見会",
		t06 : "販売会",
		t07 : "作り直し"
	};
	jQuery("#cust_type").html(custType["t${order.custType}"]);

	function dateFormat(time) {
		var date = new Date(time);
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		if (month <= 9) {
			month = "0" + month;
		}
		var day = date.getDate();
		if (day <= 9) {
			day = "0" + day;
		}
		return year + "/" + month + "/" + day;
	}

	function dateFormatValue(time) {
		var date = new Date(time);
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		if (month <= 9) {
			month = "0" + month;
		}
		var day = date.getDate();
		if (day <= 9) {
			day = "0" + day;
		}
		return year + "年" + month + "月" + day + "日";
	}
	var custShopDeliveryDate = "${order.custShopDeliveryDate}";
	if (custShopDeliveryDate != null) {
		jQuery("#cust_shop_delivery_date").html(
				dateFormat(custShopDeliveryDate))
	}

	var productOrderdDate = "${order.productOrderdDate}";
	if (productOrderdDate != null) {
		jQuery("#product_orderd_date").html(dateFormat(productOrderdDate))
	}

	var custDeliverDate = "${order.custDeliverDate}";
	if (custDeliverDate != null) {
		jQuery("#cust_deliver_date").html(dateFormat(custDeliverDate))
	}
	
	//お客様情報_出荷先の内容表示
	var custShippingDestination = {
		s01 : '店舗',
		s02 : '福山本社',
		s03 : 'TSC事業本部',
		s04 : 'お客様',
		s05 : '他店舗'
	};
	if ("${order.custShippingDestination}" == "05"
			&& "${order.custShippingDestnationOtherstore}" != "") {
		jQuery("#cust_shipping_destination")
				.html(
						custShippingDestination["s${order.custShippingDestination}"]
								+ '\xa0\xa0\xa0\xa0\xa0\xa0\xa0'
								+ "${mapShop[order.custShippingDestnationOtherstore]}");
	} else {
		jQuery("#cust_shipping_destination").html(
				custShippingDestination["s${order.custShippingDestination}"]);
	}

	//ITEMの内容表示

	var productItem = {
		I01 : "SUIT",
		I02 : "JACKET",
		I03 : "PANTS",
		I04 : "GILET",
		I05 : "SHIRT",
		I06 : "COAT",
		I21 : "SUIT(2P)",
		I22 : "SUIT(2PP)",
		I31 : "SUIT(3P)",
		I32 : "SUIT(3P2PP)"
	};
	if ("${order.productItem}" == "01" && "${order.productItemDisplaycode}" != "") {
		jQuery("#product_item").html(
				productItem["I${order.productItemDisplaycode}"]);
	} else {
		jQuery("#product_item").html(productItem["I${order.productItem}"]);
	}

	//オプション内容の表示
	var item = jQuery("#product_item").html();
	if (item.substring(0, 4) == "SUIT") {
		if ("${order.productIs3piece}" == '0009902'
				&& "${order.productSparePantsClass}" == '0009902') {
			jQuery('#op_jacket_div').show();
			jQuery('#al_jacket_div').show();

			jQuery('#op_gilet_div').show();
			jQuery('#al_gilet_div').show();

			jQuery('#op_pants_div').show();
			jQuery('#al_pants_div').show();

			jQuery('#op2_pants_div').show();
			jQuery('#al2_pants_div').show();
		} else if ("${order.productIs3piece}" == '0009902'
				&& "${order.productSparePantsClass}" == '0009901') {
			jQuery('#op_jacket_div').show();
			jQuery('#al_jacket_div').show();

			jQuery('#op_gilet_div').show();
			jQuery('#al_gilet_div').show();

			jQuery('#op_pants_div').show();
			jQuery('#al_pants_div').show();

		} else if ("${order.productIs3piece}" == '0009901'
				&& "${order.productSparePantsClass}" == '0009902') {
			jQuery('#op_jacket_div').show();
			jQuery('#al_jacket_div').show();

			jQuery('#op_pants_div').show();
			jQuery('#al_pants_div').show();

			jQuery('#op2_pants_div').show();
			jQuery('#al2_pants_div').show();
		} else if ("${order.productIs3piece}" == '0009901'
				&& "${order.productSparePantsClass}" == '0009901') {
			jQuery('#op_jacket_div').show();
			jQuery('#al_jacket_div').show();

			jQuery('#op_pants_div').show();
			jQuery('#al_pants_div').show();
		}
	} else if (item == "JACKET") {
		jQuery('#op_jacket_div').show();
		jQuery('#al_jacket_div').show();
	} else if (item == "PANTS") {
		jQuery('#op_pants_div').show();
		jQuery('#al_pants_div').show();
	} else if (item == "GILET") {
		jQuery('#op_gilet_div').show();
		jQuery('#al_gilet_div').show();
	}

	//再補正内容表示
	var productItemValue = "${order.productItem}";
	var productItemDisplayValue = "${order.productItemDisplaycode}";
	
	//JACKET_着丈_再補正値
	var corJkBodylengthCorrectAgain = "${order.corJkBodylengthCorrectAgain}";
	//JACKET_ウエスト_再補正値
	var corJkWaistCorrectAgain = "${order.corJkWaistCorrectAgain}";
	//JACKET_袖丈右_再補正値
	var corJkRightsleeveCorrectAgain = "${order.corJkRightsleeveCorrectAgain}";
	//JACKET_袖丈左_再補正値
	var corJkLeftsleeveCorrectAgain = "${order.corJkLeftsleeveCorrectAgain}";
	
	//PANTS_ウエスト_再補正値
	var corPtWaistCorrectAgain = "${order.corPtWaistCorrectAgain}";
	//PANTS_ヒップ_再補正値
	var corPtHipCorrectAgain = "${order.corPtHipCorrectAgain}";
	//PANTS_ワタリ_再補正値
	var corPtThighwidthCorrectAgain = "${order.corPtThighwidthCorrectAgain}";
	//PANTS_裾幅_修正_再補正値
	var corPtHemwidthCorrectAgain = "${order.corPtHemwidthCorrectAgain}";
	//PANTS_股下右_再補正値
	var corPtRightinseamCorrectAgain = "${order.corPtRightinseamCorrectAgain}";
	//PANTS_股下左_再補正値
	var corPtLeftinseamCorrectAgain = "${order.corPtLeftinseamCorrectAgain}";

	//２PANTS_ウエスト_再補正値
	var corPt2WaistCorrectAgain = "${order.corPt2WaistCorrectAgain}";
	//２PANTS_ヒップ_再補正値
	var corPt2HipCorrectAgain = "${order.corPt2HipCorrectAgain}";
	//２PANTS_ワタリ_再補正値
	var corPt2ThighwidthCorrectAgain = "${order.corPt2ThighwidthCorrectAgain}";
	//２PANTS_裾幅_修正_再補正値
	var corPt2HemwidthCorrectAgain = "${order.corPt2HemwidthCorrectAgain}";
	//２PANTS_股下右_再補正値
	var corPt2RightinseamCorrectAgain = "${order.corPt2RightinseamCorrectAgain}";
	//２PANTS_股下左_再補正値
	var corPt2LeftinseamCorrectAgain = "${order.corPt2LeftinseamCorrectAgain}";
	
	
	if(productItemValue == '01'){
		if(productItemDisplayValue == '21' || productItemDisplayValue == '31'){
			if(!isEmpty(corJkBodylengthCorrectAgain) || !isEmpty(corJkWaistCorrectAgain) || !isEmpty(corJkRightsleeveCorrectAgain) ||　!isEmpty(corJkLeftsleeveCorrectAgain)
					|| !isEmpty(corPtWaistCorrectAgain) || !isEmpty(corPtHipCorrectAgain) || !isEmpty(corPtThighwidthCorrectAgain) 
					|| !isEmpty(corPtHemwidthCorrectAgain) || !isEmpty(corPtRightinseamCorrectAgain) || !isEmpty(corPtLeftinseamCorrectAgain)){
				jQuery('#jkCorrectAgain').show();
				jQuery('#ptCorrectAgain').show();
				jQuery('#correctionMemoAgain').show();
			}
		}
		else if(productItemDisplayValue == '22' || productItemDisplayValue == '32'){
			if(!isEmpty(corJkBodylengthCorrectAgain) || !isEmpty(corJkWaistCorrectAgain) || !isEmpty(corJkRightsleeveCorrectAgain) ||　!isEmpty(corJkLeftsleeveCorrectAgain)
					|| !isEmpty(corPtWaistCorrectAgain) || !isEmpty(corPtHipCorrectAgain) || !isEmpty(corPtThighwidthCorrectAgain) 
					|| !isEmpty(corPtHemwidthCorrectAgain) || !isEmpty(corPtRightinseamCorrectAgain) || !isEmpty(corPtLeftinseamCorrectAgain)
					|| !isEmpty(corPt2WaistCorrectAgain) || !isEmpty(corPt2HipCorrectAgain) || !isEmpty(corPt2ThighwidthCorrectAgain) 
					|| !isEmpty(corPt2HemwidthCorrectAgain) || !isEmpty(corPt2RightinseamCorrectAgain) || !isEmpty(corPt2LeftinseamCorrectAgain)){
				jQuery('#jkCorrectAgain').show();
				jQuery('#ptCorrectAgain').show();
				jQuery('#pt2CorrectAgain').show();
				jQuery('#correctionMemoAgain').show();
			}
		}
	}
	else if(productItemValue == '02'){
		if(!isEmpty(corJkBodylengthCorrectAgain) || !isEmpty(corJkWaistCorrectAgain) || !isEmpty(corJkRightsleeveCorrectAgain) ||　!isEmpty(corJkLeftsleeveCorrectAgain)){
			jQuery('#jkCorrectAgain').show();
			jQuery('#correctionMemoAgain').show();
		}
	}
	else if(productItemValue == '03'){
		if(!isEmpty(corPtWaistCorrectAgain) || !isEmpty(corPtHipCorrectAgain) || !isEmpty(corPtThighwidthCorrectAgain) 
				|| !isEmpty(corPtHemwidthCorrectAgain) || !isEmpty(corPtRightinseamCorrectAgain) || !isEmpty(corPtLeftinseamCorrectAgain)){
			jQuery('#ptCorrectAgain').show();
			jQuery('#correctionMemoAgain').show();
		}
		
	}
	
	
	
	if ("${order.productIs3pieceRtPrice}" == "0"
			|| "${order.productIs3pieceRtPrice}" == "") {
		jQuery("#product_is_3Piece_rt_price").html("無料");
	} else {
		jQuery("#product_is_3Piece_rt_price").html(
				formatMoney("${order.productIs3pieceRtPrice}",0,"￥"));
	}

	if ("${order.productSparePantsRtPrice}" == "0"
			|| "${order.productSparePantsRtPrice}" == "") {
		jQuery("#product_spare_pants_rt_price").html("無料");
	} else {
		jQuery("#product_spare_pants_rt_price").html(
				formatMoney("${order.productSparePantsRtPrice}",0,"￥"));
	}
	if("${order.jkModelRtPrice}" !=  "0" && "${order.jkModelRtPrice}" != ""){
		jQuery("#jk_model_rt_price").html(
				formatMoney("${order.jkModelRtPrice}",0,"￥"));
		}
	
	if ("${order.jkFrtBtnRtPrice}" == "0" || "${order.jkFrtBtnRtPrice}" == "") {
		jQuery("#jk_frt_btn_rt_price").html("無料");
	} else {
		jQuery("#jk_frt_btn_rt_price").html(formatMoney("${order.jkFrtBtnRtPrice}",0,"￥"));
	}

	if ("${order.jkLapelDesignRtPrice}" == "0"
			|| "${order.jkLapelDesignRtPrice}" == "") {
		jQuery("#jk_lapel_design_rt_price").html("無料");
	} else {
		jQuery("#jk_lapel_design_rt_price").html(
				formatMoney("${order.jkLapelDesignRtPrice}",0,"￥"));
	}

	if ("${order.jkDaibaRtPrice}" == "0" || "${order.jkDaibaRtPrice}" == "") {
		jQuery("#jk_daiba_rt_price").html("無料");
	} else {
		jQuery("#jk_daiba_rt_price").html(formatMoney("${order.jkDaibaRtPrice}",0,"￥"));
	}

	if ("${order.jkInnerClothRtPrice}" == "0"
			|| "${order.jkInnerClothRtPrice}" == "") {
		jQuery("#jk_inner_cloth_rt_price").html("無料");
	} else {
		jQuery("#jk_inner_cloth_rt_price").html(formatMoney("${order.jkInnerClothRtPrice}",0,"￥"));
	}

	if ("${order.jkWaistPktRtPrice}" == "0"
			|| "${order.jkWaistPktRtPrice}" == "") {
		jQuery("#jk_waist_pkt_rt_price").html("無料");
	} else {
		jQuery("#jk_waist_pkt_rt_price").html(formatMoney("${order.jkWaistPktRtPrice}",0,"￥"));
	}

	if ("${order.jkChgPktRtPrice}" == "0" || "${order.jkChgPktRtPrice}" == "") {
		jQuery("#jk_chg_pkt_rt_price").html("無料");
	} else {
		jQuery("#jk_chg_pkt_rt_price").html(formatMoney("${order.jkChgPktRtPrice}",0,"￥"));
	}

	if ("${order.jkSlantedPktRtPrice}" == "0"
			|| "${order.jkSlantedPktRtPrice}" == "") {
		jQuery("#jk_slanted_pkt_rt_price").html("無料");
	} else {
		jQuery("#jk_slanted_pkt_rt_price").html(formatMoney("${order.jkSlantedPktRtPrice}",0,"￥"));
	}

	if ("${order.jkCuffRtPrice}" == "0" || "${order.jkCuffRtPrice}" == "") {
		jQuery("#jk_cuff_rt_price").html("無料");
	} else {
		jQuery("#jk_cuff_rt_price").html(formatMoney("${order.jkCuffRtPrice}",0,"￥"));
	}

	if ("${order.jkStitchTypeRtPrice}" == "0"
			|| "${order.jkStitchTypeRtPrice}" == "") {
		jQuery("#jk_stitch_type_rt_price").html("無料");
	} else {
		jQuery("#jk_stitch_type_rt_price").html(formatMoney("${order.jkStitchTypeRtPrice}",0,"￥"));
	}

	if ("${order.jkVentRtPrice}" == "0" || "${order.jkVentRtPrice}" == "") {
		jQuery("#jk_vent_rt_price").html("無料");
	} else {
		jQuery("#jk_vent_rt_price").html(formatMoney("${order.jkVentRtPrice}",0,"￥"));
	}

	if ("${order.jkInnerBodyClothRtPrice}" == "0"
			|| "${order.jkInnerBodyClothRtPrice}" == "") {
		jQuery("#jk_inner_body_cloth_rt_price").html("無料");
	} else {
		jQuery("#jk_inner_body_cloth_rt_price").html(
				formatMoney("${order.jkInnerBodyClothRtPrice}",0,"￥"));
	}

	if ("${order.jkInnerSleeveClothRtPrice}" == "0"
			|| "${order.jkInnerSleeveClothRtPrice}" == "") {
		jQuery("#jk_inner_sleeve_cloth_rt_price").html("無料");
	} else {
		jQuery("#jk_inner_sleeve_cloth_rt_price").html(
				formatMoney("${order.jkInnerSleeveClothRtPrice}",0,"￥"));
	}

	if ("${order.jkBtnMaterialRtPrice}" == "0"
			|| "${order.jkBtnMaterialRtPrice}" == "") {
		jQuery("#jk_btn_material_rt_price").html("無料");
	} else {
		jQuery("#jk_btn_material_rt_price").html(
				formatMoney("${order.jkBtnMaterialRtPrice}",0,"￥"));
	}

	if ("${order.glBreastPktRtPrice}" == "0"
		|| "${order.glBreastPktRtPrice}" == "") {
	jQuery("#gl_breast_pkt_rt_price").html("無料");
	} else {
		jQuery("#gl_breast_pkt_rt_price").html(formatMoney("${order.glBreastPktRtPrice}",0,"￥"));
	}	

	if ("${order.glAmfStitchRtPrice}" == "0"
			|| "${order.glAmfStitchRtPrice}" == "") {
		jQuery("#gl_amf_stitch_rt_price").html("無料");
	} else {
		jQuery("#gl_amf_stitch_rt_price").html(formatMoney("${order.glAmfStitchRtPrice}",0,"￥"));
	}

	if ("${order.glBackClothRtPrice}" == "0"
			|| "${order.glBackClothRtPrice}" == "") {
		jQuery("#gl_back_cloth_rt_price").html("無料");
	} else {
		jQuery("#gl_back_cloth_rt_price").html(formatMoney("${order.glBackClothRtPrice}",0,"￥"));
	}

	if ("${order.glInnnerClothRtPrice}" == "0"
			|| "${order.glInnnerClothRtPrice}" == "") {
		jQuery("#gl_innner_cloth_rt_price").html("無料");
	} else {
		jQuery("#gl_innner_cloth_rt_price").html(
				formatMoney("${order.glInnnerClothRtPrice}",0,"￥"));
	}

	if ("${order.glFrtBtnRtPrice}" == "0" || "${order.glFrtBtnRtPrice}" == "") {
		jQuery("#gl_frt_btn_rt_price").html("無料");
	} else {
		jQuery("#gl_frt_btn_rt_price").html(formatMoney("${order.glFrtBtnRtPrice}",0,"￥"));
	}

	if ("${order.ptTackRtPrice}" == "0" || "${order.ptTackRtPrice}" == "") {
		jQuery("#pt_tack_rt_price").html("無料");
	} else {
		jQuery("#pt_tack_rt_price").html(formatMoney("${order.ptTackRtPrice}",0,"￥"));
	}

	if ("${order.ptAdjusterRtPrice}" == "0"
			|| "${order.ptAdjusterRtPrice}" == "") {
		jQuery("#pt_adjuster_rt_price").html("無料");
	} else {
		jQuery("#pt_adjuster_rt_price").html(formatMoney("${order.ptAdjusterRtPrice}",0,"￥"));
	}

	if ("${order.ptHemUpRtPrice}" == "0" || "${order.ptHemUpRtPrice}" == "") {
		jQuery("#pt_hem_up_rt_price").html("無料");
	} else {
		jQuery("#pt_hem_up_rt_price").html(formatMoney("${order.ptHemUpRtPrice}",0,"￥"));
	}

	if ("${order.ptDblWidthRtPrice}" == "0"
			|| "${order.ptDblWidthRtPrice}" == "") {
		jQuery("#pt_dbl_width_rt_price").html("無料");
	} else {
		jQuery("#pt_dbl_width_rt_price").html(formatMoney("${order.ptDblWidthRtPrice}",0,"￥"));
	}

	if ("${order.ptBtnMaterialRtPrice}" == "0"
			|| "${order.ptBtnMaterialRtPrice}" == "") {
		jQuery("#pt_btn_material_rt_price").html("無料");
	} else {
		jQuery("#pt_btn_material_rt_price").html(
				formatMoney("${order.ptBtnMaterialRtPrice}",0,"￥"	));
	}

	if ("${order.ptNonSlipRtPrice}" == "0" || "${order.ptNonSlipRtPrice}" == "") {
		jQuery("#pt_non_slip_rt_price").html("無料");
	} else {
		jQuery("#pt_non_slip_rt_price").html(formatMoney("${order.ptNonSlipRtPrice}",0,"￥"));
	}

	if ("${order.ptChicSlipRtPrice}" == "0"
			|| "${order.ptChicSlipRtPrice}" == "") {
		jQuery("#pt_chic_slip_rt_price").html("無料");
	} else {
		jQuery("#pt_chic_slip_rt_price").html(formatMoney("${order.ptChicSlipRtPrice}",0,"￥"));
	}

	if ("${order.ptShapeMemoryRtPrice}" == "0"
			|| "${order.ptShapeMemoryRtPrice}" == "") {
		jQuery("#pt_shape_memory_rt_price").html("無料");
	} else {
		jQuery("#pt_shape_memory_rt_price").html(
				formatMoney("${order.ptShapeMemoryRtPrice}",0,"￥"));
	}

	if ("${order.ptShoeSoreRtPrice}" == "0"
			|| "${order.ptShoeSoreRtPrice}" == "") {
		jQuery("#pt_shoe_sore_rt_price").html("無料");
	} else {
		jQuery("#pt_shoe_sore_rt_price").html(formatMoney("${order.ptShoeSoreRtPrice}",0,"￥"));
	}

	if ("${order.pt2TackRtPrice}" == "0" || "${order.pt2TackRtPrice}" == "") {
		jQuery("#pt2_tack_rt_price").html("無料");
	} else {
		jQuery("#pt2_tack_rt_price").html(formatMoney("${order.pt2TackRtPrice}",0,"￥"));
	}

	if ("${order.pt2AdjusterRtPrice}" == "0"
			|| "${order.pt2AdjusterRtPrice}" == "") {
		jQuery("#pt2_adjuster_rt_price").html("無料");
	} else {
		jQuery("#pt2_adjuster_rt_price").html(formatMoney("${order.pt2AdjusterRtPrice}",0,"￥"));
	}

	if ("${order.pt2HemUpRtPrice}" == "0" || "${order.pt2HemUpRtPrice}" == "") {
		jQuery("#pt2_hem_up_rt_price").html("無料");
	} else {
		jQuery("#pt2_hem_up_rt_price").html(formatMoney("${order.pt2HemUpRtPrice}",0,"￥"));
	}

	if ("${order.pt2DblWidthRtPrice}" == "0"
			|| "${order.pt2DblWidthRtPrice}" == "") {
		jQuery("#pt2_dbl_width_rt_price").html("無料");
	} else {
		jQuery("#pt2_dbl_width_rt_price").html(formatMoney("${order.pt2DblWidthRtPrice}",0,"￥"));
	}

	if ("${order.pt2BtnMaterialRtPrice}" == "0"
			|| "${order.pt2BtnMaterialRtPrice}" == "") {
		jQuery("#pt2_btn_material_rt_price").html("無料");
	} else {
		jQuery("#pt2_btn_material_rt_price").html(
				formatMoney("${order.pt2BtnMaterialRtPrice}",0,"￥"));
	}

	if ("${order.pt2NonSlipRtPrice}" == "0"
			|| "${order.pt2NonSlipRtPrice}" == "") {
		jQuery("#pt2_non_slip_rt_price").html("無料");
	} else {
		jQuery("#pt2_non_slip_rt_price").html(formatMoney("${order.pt2NonSlipRtPrice}",0,"￥"));
	}

	if ("${order.pt2ChicSlipRtPrice}" == "0"
			|| "${order.pt2ChicSlipRtPrice}" == "") {
		jQuery("#pt2_chic_slip_rt_price").html("無料");
	} else {
		jQuery("#pt2_chic_slip_rt_price").html(formatMoney("${order.pt2ChicSlipRtPrice}",0,"￥"));
	}

	if ("${order.pt2ShapeMemoryRtPrice}" == "0"
			|| "${order.pt2ShapeMemoryRtPrice}" == "") {
		jQuery("#pt2_shape_memory_rt_price").html("無料");
	} else {
		jQuery("#pt2_shape_memory_rt_price").html(
				formatMoney("${order.pt2ShapeMemoryRtPrice}",0,"￥"));
	}

	if ("${order.pt2ShoeSoreRtPrice}" == "0"
			|| "${order.pt2ShoeSoreRtPrice}" == "") {
		jQuery("#pt2_shoe_sore_rt_price").html("無料");
	} else {
		jQuery("#pt2_shoe_sore_rt_price").html(formatMoney("${order.pt2ShoeSoreRtPrice}",0,"￥"));
	}

	if ("${authority}" == "03" || "${authority}" == "04"
			|| "${authority}" == "05") {
		jQuery("#product_is_3Piece_rt_price ").hide();
		jQuery("#product_spare_pants_rt_price ").hide();
		jQuery("#jk_model_rt_price").hide();
		jQuery("#jk_frt_btn_rt_price ").hide();
		jQuery("#jk_lapel_design_rt_price ").hide();
		jQuery("#jk_daiba_rt_price ").hide();
		jQuery("#jk_inner_cloth_rt_price ").hide();
		jQuery("#jk_waist_pkt_rt_price ").hide();
		jQuery("#jk_chg_pkt_rt_price ").hide();
		jQuery("#jk_slanted_pkt_rt_price ").hide();
		jQuery("#jk_cuff_rt_price ").hide();
		jQuery("#jk_stitch_type_rt_price ").hide();
		jQuery("#jk_vent_rt_price").hide();
		jQuery("#jk_inner_body_cloth_rt_price").hide();
		jQuery("#jk_inner_sleeve_cloth_rt_price").hide();
		jQuery("#jk_btn_material_rt_price").hide();
		jQuery("#jk_shape_memory_rt_price").hide();
		jQuery("#gl_amf_stitch_rt_price").hide();
		jQuery("#gl_breast_pkt_rt_price").hide();
		jQuery("#gl_back_cloth_rt_price").hide();
		jQuery("#gl_innner_cloth_rt_price").hide();
		jQuery("#gl_frt_btn_rt_price").hide();
		jQuery("#pt_tack_rt_price").hide();
		jQuery("#pt_adjuster_rt_price").hide();
		jQuery("#pt_hem_up_rt_price").hide();
		jQuery("#pt_dbl_width_rt_price").hide();
		jQuery("#pt_amf_stitch_rt_price").hide();
		jQuery("#pt_btn_material_rt_price").hide();
		jQuery("#pt_non_slip_rt_price").hide();
		jQuery("#pt_chic_slip_rt_price").hide();
		jQuery("#pt_shape_memory_rt_price").hide();
		jQuery("#pt_shoe_sore_rt_price").hide();
		jQuery("#pt2_tack_rt_price").hide();
		jQuery("#pt2_adjuster_rt_price").hide();
		jQuery("#pt2_hem_up_rt_price").hide();
		jQuery("#pt2_dbl_width_rt_price").hide();
		jQuery("#pt2_amf_stitch_rt_price").hide();
		jQuery("#pt2_btn_material_rt_price").hide();
		jQuery("#pt2_non_slip_rt_price").hide();
		jQuery("#pt2_chic_slip_rt_price").hide();
		jQuery("#pt2_shape_memory_rt_price").hide();
		jQuery("#pt2_shoe_sore_rt_price").hide();
	}

//TSCステータスを「お渡し済」に変更する、保存完了後、「オーダー登録結果」画面へ遷移する
jQuery("#ChangeStatus").click(function(){
	var orderId = "${order.orderId}";
	//TSCステータス
	var changeTscStatus = 'T7'; 
	//バージョン
	var orderVersion = "${order.version}";
	window.location.href= contextPath + "/orderDetail/changeStatus/" + orderId + "/" + changeTscStatus + "/" + orderVersion;
})

//お渡し時再補正入力画面にジャンプ	
var orderId = "${order.orderId}";
jQuery("#goRecorrection").click(function(){
	window.location.href= contextPath + "/orderDetail/orderDetailToPo/" + orderId;
})

//戻るボタンクリック
jQuery('#backButton').on('click', function() {
	window.location.href= contextPath + "/orderlist/gotoOrderlist";
});

//生地使用量・出荷日・船積日の保存を行う、保存完了後、「オーダー登録結果」画面へ遷移する
jQuery("#saveValue").click(function(){

	//生地使用量
	var orderId = "${order.orderId}";
	var productFabricNo = "${order.productFabricNo}";
	var fabricUsedMountValue = jQuery("#fabricUsedMount").val(); 
	if(fabricUsedMountValue != ''){
		var hasPrivileage = true;
		jQuery.ajax({
			 type:"post",
			 url: contextPath + "/orderDetail/decideFabricUsedMount",
			 data:{"productFabricNo":productFabricNo,"fabricUsedMountValue":fabricUsedMountValue,"orderId":orderId},
			 async:false,
			 success:function(result){
		         if(result == false){
			        hasPrivileage = false;
		        	appendAlert('errormssage', getMsg('msg076'));
		     		return hasPrivileage;
			         }
			 }
		});
	}
	if(hasPrivileage == false){
		return false;
		}
	
	//お渡し日
	var ShopDeliveryDate = dateFormat("${order.custShopDeliveryDate}");
	//出荷日
	var shippingDate = jQuery("#shippingDate").val(); 
	//積載日
	var loadingDate = jQuery("#loadingDate").val(); 
	//出荷日（初期値）
	var oldShippingDate = "${order.shippingDate}";

	if(oldShippingDate != "" && shippingDate == ""){
		appendAlert('errormssage', getMsgByOneArg('msg001', '出荷日'));
		return false;
		}
	else if(shippingDate!=""&&loadingDate!=""&& loadingDate <shippingDate){ 
		appendAlert('errormssage', getMsgByTwoArgs('msg095','出荷日','積載日')); 
		return false; 
	}
	else if(shippingDate!="" && ShopDeliveryDate!="" && ShopDeliveryDate <shippingDate && ShopDeliveryDate < loadingDate){
		swal({						
			  text: getMsg('msg077'),			
			  icon: "info",			
			  buttons: ["キャンセル", true],			
			}).then((isConfirm) => {			
			  if (isConfirm) {			
				  swal({		
					  text: getMsgByOneArg('msg115', dateFormatValue(ShopDeliveryDate)),	
					  icon: "info",	
					  buttons: ["キャンセル", true],	
					}).then((isConfirm) => {	
					  if (isConfirm) {
						  swal({		
							  text: getMsgByOneArg('msg116', dateFormatValue(ShopDeliveryDate)),	
							  icon: "info",	
							  buttons: ["キャンセル", true],	
							}).then((isConfirm) => {	
							  if (isConfirm) {	
								//注文ID
								var orderId = "${order.orderId}";
								//商品情報_生地番号
								var fabricNo = "${order.productFabricNo}"
								//生地使用量
								var fabricUsedMount = jQuery("#fabricUsedMount").val();
								//出荷日
								var shippingDate = jQuery("#shippingDate").val();
								//積載日
								var loadingDate = jQuery("#loadingDate").val();
								//バージョン
								var orderVersion = "${order.version}";
								window.location.href= contextPath + "/orderDetail/saveValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&orderVersion=" + orderVersion;
								  }
							})		
						  }
					})	
				  }		
			})
	}
	else if(shippingDate!="" && ShopDeliveryDate!="" && ShopDeliveryDate <shippingDate && ShopDeliveryDate < loadingDate){
		swal({						
			  text: getMsg('msg077'),			
			  icon: "info",			
			  buttons: ["キャンセル", true],			
			}).then((isConfirm) => {			
			  if (isConfirm) {			
				  swal({		
					  text: getMsgByOneArg('msg115', dateFormatValue(ShopDeliveryDate)),	
					  icon: "info",	
					  buttons: ["キャンセル", true],	
					}).then((isConfirm) => {	
					  if (isConfirm) {
						  swal({		
							  text: getMsgByOneArg('msg116', dateFormatValue(ShopDeliveryDate)),	
							  icon: "info",	
							  buttons: ["キャンセル", true],	
							}).then((isConfirm) => {	
							  if (isConfirm) {	
								//注文ID
								var orderId = "${order.orderId}";
								//商品情報_生地番号
								var fabricNo = "${order.productFabricNo}"
								//生地使用量
								var fabricUsedMount = jQuery("#fabricUsedMount").val();
								//出荷日
								var shippingDate = jQuery("#shippingDate").val();
								//積載日
								var loadingDate = jQuery("#loadingDate").val();
								//バージョン
								var orderVersion = "${order.version}";
								window.location.href= contextPath + "/orderDetail/saveValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&orderVersion=" + orderVersion;
								  }
							})		
						  }
					})	
				  }		
			})
	}
	else if(shippingDate!="" && ShopDeliveryDate!="" && loadingDate == "" && ShopDeliveryDate <shippingDate){ 
		swal({						
			  text: getMsg('msg077'),			
			  icon: "info",			
			  buttons: ["キャンセル", true],			
			}).then((isConfirm) => {			
			  if (isConfirm) {			
				  swal({		
					  text: getMsgByOneArg('msg115', dateFormatValue(ShopDeliveryDate)),	
					  icon: "info",	
					  buttons: ["キャンセル", true],	
					}).then((isConfirm) => {	
					  if (isConfirm) {	
						//注文ID
						var orderId = "${order.orderId}";
						//商品情報_生地番号
						var fabricNo = "${order.productFabricNo}"
						//生地使用量
						var fabricUsedMount = jQuery("#fabricUsedMount").val();
						//出荷日
						var shippingDate = jQuery("#shippingDate").val();
						//積載日
						var loadingDate = jQuery("#loadingDate").val();
						//バージョン
						var orderVersion = "${order.version}";
						window.location.href= contextPath + "/orderDetail/saveValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&orderVersion=" + orderVersion;
						  }
					})	
				  }		
			})
	}
	else if(loadingDate!="" && ShopDeliveryDate!="" && ShopDeliveryDate <loadingDate && ShopDeliveryDate >= shippingDate){ 
		swal({						
			  text: getMsg('msg077'),			
			  icon: "info",			
			  buttons: ["キャンセル", true],			
			}).then((isConfirm) => {			
			  if (isConfirm) {			
				  swal({		
					  text: getMsgByOneArg('msg116', dateFormatValue(ShopDeliveryDate)),	
					  icon: "info",	
					  buttons: ["キャンセル", true],	
					}).then((isConfirm) => {	
					  if (isConfirm) {	
						//注文ID
						var orderId = "${order.orderId}";
						//商品情報_生地番号
						var fabricNo = "${order.productFabricNo}"
						//生地使用量
						var fabricUsedMount = jQuery("#fabricUsedMount").val();
						//出荷日
						var shippingDate = jQuery("#shippingDate").val();
						//積載日
						var loadingDate = jQuery("#loadingDate").val();
						//バージョン
						var orderVersion = "${order.version}";
						window.location.href= contextPath + "/orderDetail/saveValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&orderVersion=" + orderVersion;
						  }
					})	
				  }		
			})			
	}
	else if(loadingDate!="" && ShopDeliveryDate!="" && shippingDate=="" && ShopDeliveryDate <loadingDate ){ 
		swal({						
			  text: getMsg('msg077'),			
			  icon: "info",			
			  buttons: ["キャンセル", true],			
			}).then((isConfirm) => {			
			  if (isConfirm) {			
				  swal({		
					  text: getMsgByOneArg('msg116', dateFormatValue(ShopDeliveryDate)),	
					  icon: "info",	
					  buttons: ["キャンセル", true],	
					}).then((isConfirm) => {	
					  if (isConfirm) {	
						//注文ID
						var orderId = "${order.orderId}";
						//商品情報_生地番号
						var fabricNo = "${order.productFabricNo}"
						//生地使用量
						var fabricUsedMount = jQuery("#fabricUsedMount").val();
						//出荷日
						var shippingDate = jQuery("#shippingDate").val();
						//積載日
						var loadingDate = jQuery("#loadingDate").val();
						//バージョン
						var orderVersion = "${order.version}";
						window.location.href= contextPath + "/orderDetail/saveValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&orderVersion=" + orderVersion;
						  }
					})	
				  }		
			})			
	}
	else{
		swal({						
			  text: getMsg('msg077'),			
			  icon: "info",			
			  buttons: ["キャンセル", true],			
			}).then((isConfirm) => {			
			  if (isConfirm) {			
				//注文ID
				var orderId = "${order.orderId}";
				//商品情報_生地番号
				var fabricNo = "${order.productFabricNo}"
				//生地使用量
				var fabricUsedMount = jQuery("#fabricUsedMount").val();
				//出荷日
				var shippingDate = jQuery("#shippingDate").val();
				//積載日
				var loadingDate = jQuery("#loadingDate").val();
				//バージョン
				var orderVersion = "${order.version}";
				window.location.href= contextPath + "/orderDetail/saveValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&orderVersion=" + orderVersion;	
				  }		
			})
	}
	
})

//ステータスを「生産終了」に変更する、生地使用量・出荷日・船積日の保存を行う、保存完了後、「オーダー登録結果」画面へ遷移する
jQuery("#saveOrChangeValue").click(function(){
	//生地使用量チェック
	var fabricUsedMountValue = jQuery("#fabricUsedMount").val();
	if(fabricUsedMountValue == ''){
		appendAlert('errormssage', getMsgByOneArg('msg001', '生地使用量'));
		return false;
	}
	//出荷日チェック
	var shippingDateValue = jQuery("#shippingDate").val();
	if(!isNotEmpty(shippingDateValue)){
		appendAlert('errormssage', getMsgByOneArg('msg001', '出荷日'));
		return false;
		}

	//積載日チェック
	var loadingDateValue = jQuery("#loadingDate").val();
	if(!isNotEmpty(loadingDateValue)){
		appendAlert('errormssage', getMsgByOneArg('msg001', '積載日'));
		return false;
		}

	//生地使用量
	var orderId = "${order.orderId}";
	var productFabricNo = "${order.productFabricNo}";
	var fabricUsedMountValue = jQuery("#fabricUsedMount").val(); 
	var hasPrivileage = true;
	jQuery.ajax({
		 type:"post",
		 url: contextPath + "/orderDetail/decideFabricUsedMount",
		 data:{"productFabricNo":productFabricNo,"fabricUsedMountValue":fabricUsedMountValue,"orderId":orderId},
		 async:false,
		 success:function(result){
	         if(result == false){
		        hasPrivileage = false;
	        	appendAlert('errormssage', getMsg('msg076'));
	     		return hasPrivileage;
		         }
		 }
	});
	if(hasPrivileage == false){
		return false;
		}
	//お渡し日
	var ShopDeliveryDate = dateFormat("${order.custShopDeliveryDate}");
	//出荷日
	var shippingDate = jQuery("#shippingDate").val(); 
	//積載日
	var loadingDate = jQuery("#loadingDate").val(); 

	if(shippingDate!=""&&loadingDate!=""&& loadingDate <shippingDate){ 
		appendAlert('errormssage', getMsgByTwoArgs('msg095','出荷日','積載日')); 
		return false; 
	}
	else if(shippingDate!="" && ShopDeliveryDate!="" && ShopDeliveryDate < shippingDate && ShopDeliveryDate < loadingDate){
		swal({
			  text: getMsg('msg077'),
			  icon: "info",
			  buttons: ["キャンセル", true],
			}).then((isConfirm) => {
			  if (isConfirm) {
				  swal({
					  text: getMsgByOneArg('msg115', dateFormatValue(ShopDeliveryDate)),
					  icon: "info",
					  buttons: ["キャンセル", true],
					}).then((isConfirm) => {
					  if (isConfirm) {
						  swal({
							  text: getMsgByOneArg('msg116', dateFormatValue(ShopDeliveryDate)),
							  icon: "info",
							  buttons: ["キャンセル", true],
							}).then((isConfirm) => {
							  if (isConfirm) {
									//注文ID
									var orderId = "${order.orderId}";
									//商品情報_生地番号
									var fabricNo = "${order.productFabricNo}"
									//生地使用量
									var fabricUsedMount = jQuery("#fabricUsedMount").val();
									//出荷日
									var shippingDate = jQuery("#shippingDate").val();
									//積載日
									var loadingDate = jQuery("#loadingDate").val();
									//ステータス「生産終了」
									var makerFactoryStatus = 'F2'; 
									//バージョン
									var orderVersion = "${order.version}";
									window.location.href= contextPath + "/orderDetail/saveOrChangeValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&makerFactoryStatus=" + makerFactoryStatus + "&orderVersion=" + orderVersion;
								  }
							})
						  }
					})
				  }
			})
	}
	else if(shippingDate!="" && ShopDeliveryDate!="" && ShopDeliveryDate < shippingDate && ShopDeliveryDate >= loadingDate){ 
		swal({
			  text: getMsg('msg077'),
			  icon: "info",
			  buttons: ["キャンセル", true],
			}).then((isConfirm) => {
			  if (isConfirm) {
				  swal({
					  text: getMsgByOneArg('msg115', dateFormatValue(ShopDeliveryDate)),
					  icon: "info",
					  buttons: ["キャンセル", true],
					}).then((isConfirm) => {
					  if (isConfirm) {
							//注文ID
							var orderId = "${order.orderId}";
							//商品情報_生地番号
							var fabricNo = "${order.productFabricNo}"
							//生地使用量
							var fabricUsedMount = jQuery("#fabricUsedMount").val();
							//出荷日
							var shippingDate = jQuery("#shippingDate").val();
							//積載日
							var loadingDate = jQuery("#loadingDate").val();
							//ステータス「生産終了」
							var makerFactoryStatus = 'F2'; 
							//バージョン
							var orderVersion = "${order.version}";
							window.location.href= contextPath + "/orderDetail/saveOrChangeValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&makerFactoryStatus=" + makerFactoryStatus + "&orderVersion=" + orderVersion;
						  }
					})
				  }
			})
	}
	else if(loadingDate!="" && ShopDeliveryDate!="" && ShopDeliveryDate <loadingDate && ShopDeliveryDate >= shippingDate){ 
		swal({
			  text: getMsg('msg077'),
			  icon: "info",
			  buttons: ["キャンセル", true],
			}).then((isConfirm) => {
			  if (isConfirm) {
				  swal({
					  text: getMsgByOneArg('msg116', dateFormatValue(ShopDeliveryDate)),
					  icon: "info",
					  buttons: ["キャンセル", true],
					}).then((isConfirm) => {
					  if (isConfirm) {
							//注文ID
							var orderId = "${order.orderId}";
							//商品情報_生地番号
							var fabricNo = "${order.productFabricNo}"
							//生地使用量
							var fabricUsedMount = jQuery("#fabricUsedMount").val();
							//出荷日
							var shippingDate = jQuery("#shippingDate").val();
							//積載日
							var loadingDate = jQuery("#loadingDate").val();
							//ステータス「生産終了」
							var makerFactoryStatus = 'F2'; 
							//バージョン
							var orderVersion = "${order.version}";
							window.location.href= contextPath + "/orderDetail/saveOrChangeValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&makerFactoryStatus=" + makerFactoryStatus + "&orderVersion=" + orderVersion;
						  }
					})
				  }
			})
	}
	else{
		swal({
			  text: getMsg('msg077'),
			  icon: "info",
			  buttons: ["キャンセル", true],
			}).then((isConfirm) => {
			  if (isConfirm) {
				//注文ID
					var orderId = "${order.orderId}";
					//商品情報_生地番号
					var fabricNo = "${order.productFabricNo}"
					//生地使用量
					var fabricUsedMount = jQuery("#fabricUsedMount").val();
					//出荷日
					var shippingDate = jQuery("#shippingDate").val();
					//積載日
					var loadingDate = jQuery("#loadingDate").val();
					//ステータス「生産終了」
					var makerFactoryStatus = 'F2'; 
					//バージョン
					var orderVersion = "${order.version}";
					window.location.href= contextPath + "/orderDetail/saveOrChangeValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&makerFactoryStatus=" + makerFactoryStatus + "&orderVersion=" + orderVersion;
				  }
			})
	}
	
})

jQuery("#ChangeOrderValue").click(function(){
	//注文ID
	var orderId = "${order.orderId}"
	window.location.href= contextPath + "/orderDetail/orderDetailToOrderPo/" + orderId;
})


//下代価格を計算する
jQuery("#nextGenerationCount").click(function(){
	appendAlertDel('errormssage');
	//注文ID
	var orderId = "${order.orderId}";
	jQuery.ajax({
		 type:"post",
		 url: contextPath + "/orderDetail/nextGenerationCount",
		 data:{"orderId":orderId},
		 success:function(result){
			 if(result == "1"){
				 appendAlert('errormssage', getMsgByOneArg('msg102', orderId));
				 }
			 else if(result == "2"){
				 appendAlert('errormssage', getMsg('msg103'));
					 }
			 else{
				 jQuery("#nextGenerationDisplay").val(result);
				 }
			 }
	})
})

//下代価格を保存する、保存完了後、「オーダー登録結果」画面へ遷移する
jQuery("#nextGenerationSave").on('click', function(){

	//下代価格入力チェック
	var nextGenerationInputValue = jQuery("#nextGenerationDisplay").val();
	if(nextGenerationInputValue == ''){
		appendAlert('errormssage', getMsgByOneArg('msg001', '下代価格'));
		return false;
		}
	if(isNumericDecimal(nextGenerationInputValue)){
		appendAlert('errormssage', getMsgByTwoArgs('msg012', '下代価格','半角数字'));
		return false;
		}
	else if(nextGenerationInputValue > 2147483647 || nextGenerationInputValue.indexOf(".") != -1){
		appendAlert('errormssage', getMsgByOneArg('msg099', '下代価格'));
		return false;
	}
	
	//注文ID
	var orderId = "${order.orderId}";
	//バージョン
	var orderVersion = "${order.version}";
	var nextGenerationPrice = jQuery("#nextGenerationDisplay").val();
	var status = "${order.tscStatus}";
	window.location.href= contextPath + "/orderDetail/nextGenerationPrice/" + orderId + "/" + nextGenerationPrice + "/" + orderVersion + "/" + status;
		
})

//積載日初期値
jQuery('#loadingDate').datepicker({
	  format: 'yyyy/mm/dd',
	  clearBtn: true,
	  language: 'ja',
	  todayBtn: "linked",
	  orientation: 'buttom auto',
	  autoclose: true
	});
var loadingDate = "${order.loadingDate}";
if (loadingDate != null && loadingDate != '') {
	jQuery("#loadingDate").val(
			dateFormat(loadingDate));
	jQuery("#loadingDate").datepicker("update", dateFormat(loadingDate));
}

//出荷日初期値
jQuery('#shippingDate').datepicker({
  format: 'yyyy/mm/dd',
  clearBtn: true,
  language: 'ja',
  todayBtn: "linked",
  orientation: 'buttom auto',
  autoclose: true
});
var shippingDate = "${order.shippingDate}";
if (shippingDate != null && shippingDate != '') {
	jQuery("#shippingDate").val(
			dateFormat(shippingDate));
	jQuery("#shippingDate").datepicker("update", dateFormat(shippingDate));
}

//積載日のFormat
var loadingDateFormat = "${order.loadingDate}";
	if (loadingDateFormat != null && loadingDateFormat != '') {
		jQuery("#loadingDateFormat").html(
				dateFormat(loadingDateFormat));
	}
	else if(loadingDateFormat == ''){
		jQuery("#loadingDateFormat").html('');
	}
//出荷日のFormat
var shippingDateFormat = "${order.shippingDate}";
if (shippingDateFormat != null && shippingDateFormat != '') {
	jQuery("#shippingDateFormat").html(
			dateFormat(shippingDateFormat));
}
else if(shippingDateFormat == ''){
	jQuery("#shippingDateFormat").html('');
}

//formatオプション金額
function formatMoney(number, places, symbol, thousand, decimal) {
	        number = number || 0;
	        places = !isNaN(places = Math.abs(places)) ? places : 2;
	        symbol = symbol !== undefined ? symbol : "$";
	        thousand = thousand || ",";
	        decimal = decimal || ".";
	        var negative = number < 0 ? "-" : "",
	            i = parseInt(number = Math.abs(+number || 0).toFixed(places), 10) + "",
	            j = (a = i.length) > 3 ? a % 3 : 0;
	        return symbol + negative + (j ? i.substr(0, j) + thousand : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + thousand) + (places ? decimal + Math.abs(number - i).toFixed(places).slice(2) : "");
	    }

//画面上部のご請求金額の表示について
jQuery("#header_billingAmount").html(formatMoney("${order.billingAmount}",0,""));
jQuery("#header_consumptionTaxAmount").html(formatMoney("${order.consumptionTaxAmount}",0,""));
jQuery("#header_productPrice").html(formatMoney("${order.productPrice}",0,""));
jQuery("#header_optionPrice").html(formatMoney("${order.optionPrice}",0,""));
jQuery("#header_totalPrice").html(formatMoney("${order.totalPrice}",0,""));

//画面下部のご請求金額の表示について
jQuery("#bottom_billingAmount").html(formatMoney("${order.billingAmount}",0,""));
jQuery("#bottom_consumptionTaxAmount").html(formatMoney("${order.consumptionTaxAmount}",0,""));
jQuery("#bottom_productPrice").html(formatMoney("${order.productPrice}",0,""));
jQuery("#bottom_optionPrice").html(formatMoney("${order.optionPrice}",0,""));
jQuery("#bottom_totalPrice").html(formatMoney("${order.totalPrice}",0,""));

//下代価格
var wspriceValue = "${order.wsPrice}";
if(wspriceValue != ''){
	jQuery("#wsPrice").html(formatMoney(wspriceValue,0,"￥"));
}

//生地使用量を制限して入る力
function clearNoNum(obj) {
	obj.value = obj.value.replace(/[^\d.]/g,"");
    obj.value = obj.value.replace(/^\./g,"");
    obj.value = obj.value.replace(/\.{2,}/g,".");
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');
    
    
    if(obj.value.indexOf(".")==-1){
		obj.value = obj.value.substring(0,3);
	}
}

//組成表示　胴裏地
var result = "${order.productComposBodyLiner}";
if(result.indexOf(" ") != -1 ){
	 var labelArray = new Array();
	 labelArray = result.split(" ");
	 for (i=0; i<labelArray.length; i++ ){
		 jQuery("#composBodyLiner").append(labelArray[i]).append("<Br>");
	 }
 	 }else{
	 	 jQuery("#composBodyLiner").html(result);
 	 }

//去除字符串头部空格或指定字符
String.prototype.TrimStart = function (c) {
    if (c == null || c == "") {
        var str = this.replace(/^s*/, '');
        return str;
    }
    else {
        var rg = new RegExp("^" + c + "*");
        var str = this.replace(rg, '');
        return str;
    }
}

//画面にmeasuringについての項目
var measuringList = ["${measuring.fullLength}",
						"${measuring.shoulder}",
						"${measuring.reachRight}",
						"${measuring.reachLeft}",
						"${measuring.outBust}",
						"${measuring.bust}",
						"${measuring.jacketWaist}",
						"${measuring.pantsWaist}",
						"${measuring.hip}",
						"${measuring.spanRight}",
						"${measuring.spanLeft}",
						"${measuring.calfRight}",
						"${measuring.calfLeft}",
						"${measuring.neck}"];
var measuringItemarry = ["fullLength","shoulder","reachRight","reachLeft","outBust",
	"bust","jacketWaist","pantsWaist","hip","spanRight","spanLeft","calfRight","calfLeft","neck"];

for(var i in measuringList){
	var fullLengthValue = measuringList[i];
		var fullLengthFormat = fullLengthValue.TrimStart('0');
		if(fullLengthFormat == '.0' || fullLengthFormat == '.5'){
			var fullLengthFormatv = '0' + fullLengthFormat;
			jQuery("#" + measuringItemarry[i]).html(fullLengthFormatv);
			}
		else if(/^[0-9]{1,3}\.$/.test(fullLengthFormat)){
			jQuery("#" + measuringItemarry[i]).html(fullLengthFormat + '0');
			}
		else{
			jQuery("#" + measuringItemarry[i]).html(fullLengthFormat);
			}
}

//画面にmeasuringについての項目初期値表示
var measuringItemList = ["fullLength","shoulder","reachRight","reachLeft","outBust",
	"bust","jacketWaist","pantsWaist","hip","spanRight","spanLeft","calfRight","calfLeft","neck"];
for(var j in measuringItemList){
	var measuringItemValue = jQuery("#" + measuringItemList[j] ).html();
	if(measuringItemValue == ''){
		jQuery("#" + measuringItemList[j] ).html('0.0');
		}
}

//pants股下初期値表示
if("${order.corPtLeftinseamGross }" == '' && "${order.corPtRightinseamGross }" == ''){
	jQuery("#pantsCorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右 000.0');
	}
else if("${order.corPtLeftinseamGross }" != '' && "${order.corPtRightinseamGross }" == ''){
	jQuery("#pantsCorinseamGross" ).html('左 ' +"${order.corPtLeftinseamGross}" + 'cm &nbsp &nbsp &nbsp 右  000.0');
}
else if("${order.corPtLeftinseamGross }" == '' && "${order.corPtRightinseamGross }" != ''){
	jQuery("#pantsCorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右 ' + "${order.corPtRightinseamGross}");
}
else{
	jQuery("#pantsCorinseamGross" ).html('左 ' +"${order.corPtLeftinseamGross}" + 'cm &nbsp &nbsp &nbsp 右  ' + "${order.corPtRightinseamGross}");
	}

//pants2股下初期値表示
if("${order.corPt2LeftinseamGross}" == '' && "${order.corPt2RightinseamGross}" == ''){
	jQuery("#pants2CorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右 000.0');
	}
else if("${order.corPt2LeftinseamGross}" != '' && "${order.corPt2RightinseamGross}" == ''){
	jQuery("#pants2CorinseamGross" ).html('左 ' +"${order.corPt2LeftinseamGross}" + 'cm &nbsp &nbsp &nbsp 右 000.0 ');
}
else if("${order.corPt2LeftinseamGross}" == '' && "${order.corPt2RightinseamGross}" != ''){
	jQuery("#pants2CorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右 ' + "${order.corPt2RightinseamGross}");
}
else{
	jQuery("#pants2CorinseamGross" ).html('左 ' +"${order.corPt2LeftinseamGross}" + 'cm &nbsp &nbsp &nbsp 右 ' + "${order.corPt2RightinseamGross}");
	}

function pdfDownload(sign){
	var orderId = "${order.orderId}";
	var authority = "${authority}";
	var makerFactoryStatus = "${order.makerFactoryStatus}";
	var productItem = jQuery("#product_item").text();

	jQuery.ajax({
	    url:contextPath + "/pdfFile/poPdfFileCheck",
	    type:"get",
	    data:{"orderId" : orderId},
	    contentType:"application/json",
	    success:function(result){
	    	var shippingNumber = result.shippingNumber;
	    	var hostTransmitARow = result.hostTransmitARow;
	    	if((shippingNumber == null || "" == shippingNumber) && "1" == sign){
		    	//"1" == sign：注文内容確認書
	    		//msg113 = {0}が未連携のためＰＤＦを生成できません。
				appendAlert('errormssage', getMsgByOneArg('msg113', '出荷番号'));
		    }else if((hostTransmitARow == null || "" == hostTransmitARow) && "1" == sign){
		    	//"1" == sign：注文内容確認書
		    	//msg113 = {0}が未連携のためＰＤＦを生成できません。
				appendAlert('errormssage', getMsgByOneArg('msg113', 'A行'));
			}else{
				if(("01" == authority || "02" == authority) && "F0" == makerFactoryStatus){
					//"01" == authority：店舗。"02" == authority：商品部
					//"F0" == makerFactoryStatus：生産開始前
					// 確認メッセージ
					swal({
						// 注文確定が完了していない場合、PDFと注文内容に差異が出る可能性があります。PDF出力後、速やかに注文確定を行ってください。
						text: getMsg('msg112'),
						icon: "info",
					})
					.then((isConfirm) => {
						if (isConfirm) {
							window.location.href = contextPath + "/pdfFile/poPdfFileDownload?sign="+sign+"&orderId="+orderId+"&productItem="+productItem;
						}
					});
				}else{
					window.location.href = contextPath + "/pdfFile/poPdfFileDownload?sign="+sign+"&orderId="+orderId+"&productItem="+productItem;
				}
			}
	    }
	});

}
</script>

