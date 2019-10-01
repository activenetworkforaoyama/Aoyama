<spring:eval var="sessionContent" expression="@sessionContent" />
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
<div class="col-md-8">
	<c:if test="${authority == '01'}">
		<c:if test="${order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5' || order.tscStatus == 'T6' || order.tscStatus == 'T7'}">
			<div class="col col-md-7">
			</div>
			<div class="col col-md-5">
				<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.orderKakuninKyakSign})">
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
					<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.orderKakuninKyakSign})">
						お客様注文内容確認書
					</button>
				</div>
			</c:if>
			
			<c:if test="${order.makerFactoryStatus == 'F1' || order.makerFactoryStatus == 'F2'}">
			<div class="col col-md-4">
			</div>
			<div class="col col-md-5">
				<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.orderKakuninKyakSign})">
					お客様注文内容確認書
				</button>
			</div>
			<div class="col col-md-3">
				<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.factorySijiSign})">
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
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.orderKakuninKyakSign})">
								お客様注文内容確認書
							</button>
						</div>
						
						<div class="col col-md-4">
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.orderKakuninSign})">
								注文内容確認書
							</button>
						</div>
						
						<div class="col col-md-3">
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.factorySijiSign})">
								工場指示書
							</button>
						</div>
					</c:when>
				
					<c:otherwise>
						<div class="col col-md-4">
						</div>
						<div class="col col-md-5">
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.orderKakuninKyakSign})">
								お客様注文内容確認書
							</button>
						</div>
						<div class="col col-md-3">
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.factorySijiSign})">
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
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.orderKakuninKyakSign})">
								お客様注文内容確認書
							</button>
						</div>
						
						<div class="col col-md-4">
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.orderKakuninSign})">
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
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.orderKakuninKyakSign})">
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
					<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.factorySijiSign})">
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
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.orderKakuninSign})">
								注文内容確認書
							</button>
						</div>
						
						<div class="col col-md-3">
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.factorySijiSign})">
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
							<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.factorySijiSign})">
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
						<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.orderKakuninSign})">
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
					<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.factorySijiSign})">
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
						<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.orderKakuninSign})">
							注文内容確認書
						</button>
					</div>
					<div class="col col-md-3">
						<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.factorySijiSign})">
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
						<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.factorySijiSign})">
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
						<button  type="button" class="btn btn-warning btn-block" onclick="pdfDownload(${orderFm.orderKakuninSign})">
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
			<div class="col-lg-6">
			<c:if test="${authority == '01' || authority == '02' || authority == '05'}">
				<div class="row">
					<div class="col col-md-4"><label class=" form-control-label">お客様名</label></div>
					<div class="col-12 col-md-8">
					<c:if test="${order.custNm != null && order.custKanaNm != null}">
							<label class=" form-control-label-value">${f:h(order.custNm)}(${f:h(order.custKanaNm)})</label>様
					</c:if>
					<c:if test="${order.custNm != null && order.custKanaNm == null}">
							<label class=" form-control-label-value">${f:h(order.custNm)}</label>様
					</c:if>
					<c:if test="${order.custNm != null && order.custKanaNm == null}">
							<label class=" form-control-label-value">(${f:h(order.custKanaNm)})</label>様
					</c:if>
					<c:if test="${order.custNm == null && order.custKanaNm == null}">
					</c:if>
				</div>
				</div>
				</c:if>
				<div class="row">
					<div class="col col-md-4"><label class=" form-control-label">ステータス</label></div>
					<div class="col-12 col-md-8">
						<label class=" form-control-label-value" id="status_appear"></label>
					</div>
				</div>
			</div>
			<c:if test="${authority == '01' || authority == '02'}">
			<div class="col-lg-6">
				<div class="row">
					<div class="col text-right">
						<strong><label>ご請求金額：${orderFm.billingAmountFm}（消費税${orderFm.consumptionTaxAmountFm}）</label></strong>
					</div>
				</div>
				<div class="row">
					<div class="col text-right">
						<label>商品金額：${orderFm.productPriceFm}</label>
					</div>
				</div>
				<div class="row">
					<div class="col text-right">
						<label>オプション金額：${orderFm.optionPriceFm}</label>
					</div>
				</div>
				<div class="row">
					<div class="col text-right">
						<label>合計金額：${orderFm.totalPriceFm}</label>
					</div>
				</div>
			</div>
			</c:if>
		</div>
	</div>
</div>
<br>

<!-- お客様情報 Start -->
<div class="col-md-12">
<div class="card"> <!-- id="nav1_custom_div" -->
<div class="card-body">
	<div class="row">
		<div class="col col-lg-6">
			<div class="row">
				<div class="col col-md-3"><label class=" form-control-label">注文ID</label></div>
				<div class="col-12 col-md-9"><strong><label class=" form-control-label-value">${order.orderId}</label></strong></div>
			</div>
			<c:if test="${authority == '01' || authority == '02' || authority == '05'}">
			<div class="row">
				<div class="col col-md-3"><label class=" form-control-label">会員番号</label></div>
				<div class="col-12 col-md-9"><strong><label class=" form-control-label-value">${order.custCd}</label></strong></div>
			</div>
			<div class="row">
				<div class="col col-md-3"><label class=" form-control-label">お客様氏名</label></div>
				<div class="col-12 col-md-9"><strong><label class=" form-control-label-value">${f:h(order.custNm)}</label></strong></div>
			</div>
			<div class="row">
				<div class="col col-md-3"><label class=" form-control-label">フリガナ</label></div>
				<div class="col-12 col-md-9"><strong><label class=" form-control-label-value">${f:h(order.custKanaNm)}</label></strong></div>
			</div>
			</c:if>
			
			<c:if test="${authority == '01'}">
			<div class="row">
				<div class="col col-md-3"><label class=" form-control-label">承り日</label></div>
				<div class="col-12 col-md-9"><strong><label class=" form-control-label-value" id="product_orderd_date"></label></strong></div>
			</div>
			</c:if>
			
			<c:if test="${authority == '02' || authority == '05'}">
			<div class="row">
				<div class="col col-md-3"><label class=" form-control-label">名簿納期</label></div>
				<div class="col-12 col-md-9"><strong><label class=" form-control-label-value" id="cust_deliver_date"></label></strong></div>
			</div>
			</c:if>
			
		</div>
		<c:if test="${authority == '01' || authority == '02' || authority == '05'}">
		<div class="col col-lg-6">
			<div class="row">
				<div class="col col-md-3"><label class=" form-control-label">納期短縮</label></div>
				<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.custIsDeliverShortning}</label></strong></div>
				<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="cust_is_deliver_shortning_rt_price">${orderFm.custIsDeliverShortningRtPriceFm}</label></strong></div>
			</div>
			<div class="row">
				<div class="col col-md-3"><label class=" form-control-label">早割</label></div>
				<div class="col-12 col-md-9"><strong><label class=" form-control-label-value">${order.custIsEarlyDiscount}</label></strong></div>
			</div>
			<div class="row">
				<div class="col col-md-3"><label class=" form-control-label">お渡し日</label></div>
				<div class="col-12 col-md-9"><strong><label class=" form-control-label-value" id="cust_shop_delivery_date"></label></strong></div>
			</div>
			<div class="row">
				<div class="col col-md-3"><label class=" form-control-label">スタッフ</label></div>
				<div class="col-12 col-md-9"><strong><label class=" form-control-label-value">${f:h(order.custStaff)}</label></strong></div>
			</div>
			<div class="row">
				<div class="col col-md-3"><label class=" form-control-label">区分</label></div>
				<div class="col-12 col-md-9"><strong><label class=" form-control-label-value" id="cust_type"></label></strong></div>
			</div>
			<div class="row">
				<div class="col col-md-3"><label class=" form-control-label">出荷先</label></div>
				<div class="col-12 col-md-9"><strong><label class=" form-control-label-value" id="cust_shipping_destination"></label></strong></div>
			</div>
		</div>
		</c:if>
	</div>
	<c:if test="${authority == '01' || authority == '02' || authority == '05'}">
		<div class="row">
			<div class="col col-lg-12">
				<div class="row form-group">
					<div style="padding-left:15px;width:12.5%">
					    <label class=" form-control-label">お客様備考</label>
					</div>
					<div style="padding-right:15px;padding-left:15px;width:87.5%">
						<textarea readonly name="textarea-input" id="textarea-input" rows="3" class="form-control">${f:h(order.custRemark)}</textarea>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</div>
</div>
</div>
<!-- お客様情報 End -->
<!-- メジャーリング Start-->
<div class="col-md-12">
	<div class="card" ><!-- id="nav1_mejer_div" -->
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-4">
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">フルレングス</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.fullLength}</label>cm</strong></div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ショルダー</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.shoulder}</label>cm</strong></div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">リーチ（右）</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.reachRight}</label>cm</strong></div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">リーチ（左）</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.reachLeft}</label>cm</strong></div>
					</div>
				</div>
				<div class="col col-lg-4">
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">アウトバスト</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.outBust}</label>cm</strong></div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">バスト</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.bust}</label>cm</strong></div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">JKウエスト</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.jacketWaist}</label>cm</strong></div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">PTウエスト</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.pantsWaist}</label>cm</strong></div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ヒップ</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.hip}</label>cm</strong></div>
					</div>
				</div>
				<div class="col col-lg-4">
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ワタリ（右）</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.spanRight}</label>cm</strong></div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ワタリ（左）</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.spanLeft}</label>cm</strong></div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ふくらはぎ（右）</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.calfRight}</label>cm</strong></div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ふくらはぎ（左）</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.calfLeft}</label>cm</strong></div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ネック</label></div>
						<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${measuring.neck}</label>cm</strong></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- メジャーリング End -->
<!-- オプション Start -->
<!-- ITEM Start -->
<div class="col-md-12">
<div class="card" ><!-- id="nav2_product_div" -->
	<div class="card-body">
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
				<div class="col col-md-3"><label class=" form-control-label">ITEM</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value" id="product_item"></label></strong></div>
				</div>
				<c:if test="${order.productItem == '01'}">
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">３Piece</label>
							</div>
							<div class="col-12 col-md-8">
							<c:if test="${order.productIs3piece == '0009901'}">
								<strong><label class=" form-control-label-value">無し</label></strong>
							</c:if>
							<c:if test="${order.productIs3piece == '0009902'}">
								<strong><label class=" form-control-label-value">有り</label></strong>
							</c:if>
							</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="product_is_3Piece_rt_price">${orderFm.productIs3pieceRtPriceFm}</label></strong>
						</div>
						</div>

					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">スペアパンツ</label>
						</div>
						<div class="col-12 col-md-8">
						<c:if test="${order.productSparePantsClass == '0009901'}">
							<strong><label class=" form-control-label-value">無し</label></strong>
						</c:if>
						<c:if test="${order.productSparePantsClass == '0009902'}">
						<strong><label class=" form-control-label-value">2パンツ</label></strong>
						</c:if>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="product_spare_pants_rt_price">${orderFm.productSparePantsRtPriceFm}</label></strong>
						</div>
					</div>
				</c:if>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">生地品番</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.productFabricNo}-${order.fabricColor}${order.fabricPattern}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">カテゴリ</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value" id="product_category"></label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">LCR縫製</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.productLcrSewing}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="product_lcr_sewing_rt_price">${orderFm.productLcrSewingRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ブランドネーム</label></div>
					<div class="col-12 col-md-6">
					<strong><label class=" form-control-label-value">${order.productBrandNm}</label></strong>
					</div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">生地ネーム</label></div>
					<div class="col-12 col-md-6">
					<strong><label class=" form-control-label-value">${order.productFabricNmNecessity}</label></strong>
					</div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">刺繍入れ</label></div>
					<div class="col-12 col-md-6">
					<strong><label class=" form-control-label-value">${order.productEmbroideryNecessity}</label></strong>
					</div>
				</div>
				<c:if test="${order.productEmbroideryNecessity == '有り'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">刺繍ネーム</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.productEmbroideryNm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">刺繍書体</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.productEmbroideryFont}</label></strong>
					</div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">刺繍糸色</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.productEmbroideryThreadColor}</label></strong></div>
				</div>
				
				<c:if test="${order.productItem == '05'}">
				
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">刺繍箇所</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.productEmbroideryNmPos}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="product_embroidery_nm_pos_rt_price">${orderFm.productEmbroideryNmPosRtPriceFm}</label></strong></div>
				</div>
				
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">刺繍サイズ</label></div>
					<div class="col-12 col-md-6">
					<strong>
					<label class=" form-control-label-value">縦　${order.productEmbroideryLength}cm　　横　${order.productEmbroideryWidth}cm</label>
					</strong>
					</div>
				</div>
				
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ガゼット刺繡</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.productEmbroideryGazette}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="product_embroidery_gazette_rt_price">${orderFm.productEmbroideryGazetteRtPriceFm}</label></strong></div>
				</div>
				</c:if>
				</c:if>
				
				<c:if test="${order.productItem != '05'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">残布</label></div>
					<div class="col-12 col-md-6">
					<strong>
					<label class=" form-control-label-value">${order.productRemainingClothNm}</label>
					</strong>
					</div>
				</div>
				</c:if>
				
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">生地ブランド</label></div>
					<div class="col-12 col-md-9"><strong><label class=" form-control-label-value">${order.productFabricBrandNm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">素材名</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.productServiceNm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">組成表示　表地</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.productComposFrtFabric}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">組成表示　胴裏地</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value" id="composBodyLiner"></label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">組成表示　袖裏地</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.productComposSleeveLiner}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">取扱注意</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.productNotice}</label></strong></div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<!-- ITEM End -->
<!-- JACKET Start -->
<div class="col-md-12" id="op_jacket_div" style="display:none;">
<div class="card" ><!-- id="nav2_option_div" -->
<div ><!-- id="op_jacket_div" -->
	<div class="card-header">
		<strong class="card-title">JACKET</strong>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>JACKETモデル</strong></label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkModelNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right">
						<strong><label class=" form-control-label-value" id="jk_model_rt_price">${orderFm.jkModelRtPriceFm}</label></strong>
					</div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">フロント釦数</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkFrtBtnNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_frt_btn_rt_price">${orderFm.jkFrtBtnRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkLapelDesignNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_lapel_design_rt_price">${orderFm.jkLapelDesignRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">グレード</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkGradeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_grade_rt_price">${orderFm.jkGradeRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">裏仕様</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkInnerClothNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_inner_cloth_rt_price">${orderFm.jkInnerClothRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">台場</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkDaibaNm }</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_daiba_rt_price">${orderFm.jkDaibaRtPriceFm}</label></strong></div>
				</div>
				<c:if test="${order.productCategory == '9000102'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">拝絹地</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkLookClothNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_look_cloth_rt_price">${orderFm.jkLookClothRtPriceFm}</label></strong></div>
				</div>
				</c:if>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">襟裏（ヒゲ）</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkCollarInnerNm }</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_collar_inner_rt_price">${orderFm.jkCollarInnerRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkCollarHangNm }</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_collar_hang_rt_price">${orderFm.jkCollarHangRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ラペル幅</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkLapelWidthNm }</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_lapel_width_rt_price">${orderFm.jkLapelWidthRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">フラワーホール</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkFlowerHoleNm }</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_flower_hole_rt_price">${orderFm.jkFlowerHoleRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkBreastPktNm }</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_breast_pkt_rt_price">${orderFm.jkBreastPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkWaistPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_waist_pkt_rt_price">${orderFm.jkWaistPktRtPriceFm}</label></strong></div>
				</div>										
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkChgPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_chg_pkt_rt_price">${orderFm.jkChgPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkSlantedPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_slanted_pkt_rt_price">${orderFm.jkSlantedPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkShinobiPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_shinobi_pkt_rt_price">${orderFm.jkShinobiPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkSleeveTypeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_sleeve_type_rt_price">${orderFm.jkSleeveTypeRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">マニカ</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkManicaNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_manica_rt_price">${orderFm.jkManicaRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">袖釦</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkSleeveBtnNm}${order.jkSleeveBtnNumber}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_sleeve_btn_rt_price">${orderFm.jkSleeveBtnRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkCuffNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_cuff_rt_price">${orderFm.jkCuffRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">内ポケット変更</label></div>
					<div class="col-12 col-md-6">
					<strong><label class=" form-control-label-value">${order.jkInnerPktType}</label></strong>
					</div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_inner_pkt_rt_price">${orderFm.jkInnerPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">下前胸内ポケット仕様</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkRightInnerPktTypeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_right_inner_pkt_type_rt_price">${orderFm.jkRightInnerPktTypeRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkStitchTypeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_stitch_type_rt_price">${orderFm.jkStitchTypeRtPriceFm}</label></strong></div>
				</div>
				<c:if test="${order.productCategory != '9000102' && order.jkStitchTypeNm != '無し'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.jkStitchPlcType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="jk_stitch_plc_rt_price">${orderFm.jkStitchPlcRtPriceFm}</label></strong></div>
				</div>
				
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ変更</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.jkDblstitchPlcType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="jk_dblstitch_plc_rt_price">${orderFm.jkDblstitchPlcRtPriceFm}</label></strong></div>
				</div>
				
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.jkAmfColorType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="jk_amf_color_rt_price">${orderFm.jkAmfColorRtPriceFm}</label></strong></div>
				</div>
				</c:if>
				
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.jkBtnholeColorType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="jk_btnhole_plc_color_rt_price">${orderFm.jkBtnholePlcColorRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.jkBtnthreadColorType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="jk_btnthread_plc_color_rt_price">${orderFm.jkBtnthreadPlcColorRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.jkVentNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_vent_rt_price">${orderFm.jkVentRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
					<div class="col-12 col-md-6">
					<strong><label class=" form-control-label-value" id="jkInnerBodyCloth_appear">${order.jkInnerBodyClothNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_inner_body_cloth_rt_price">${orderFm.jkInnerBodyClothRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
					<div class="col-12 col-md-6">
					<strong><label class=" form-control-label-value" id="jkInnerSleeveCloth_appear">${order.jkInnerSleeveClothNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_inner_sleeve_cloth_rt_price">${orderFm.jkInnerSleeveClothRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
					<div class="col-12 col-md-6">
					<strong><label class=" form-control-label-value" id="jkBtnMaterial_appear">${order.jkBtnMaterialNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_btn_material_rt_price">${orderFm.jkBtnMaterialRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value" id="jkBtnMaterial_appear">${order.jkShapeMemoryNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="jk_shape_memory_rt_price">${orderFm.jkShapeMemoryRtPriceFm}</label></strong></div>
				</div>
			</div>
		</div>
		<div class="row">　</div>
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>JACKETサイズ</strong></label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.corJkDrop}&nbsp &nbsp &nbsp${order.corJkSize}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>JACKET補正</strong></label></div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">着丈修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corJkBodylengthCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corJkBodylengthGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">ウエスト修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corJkWaistCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corJkWaistGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">袖丈右修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corJkRightsleeveCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corJkRightsleeveGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">袖丈左修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corJkLeftsleeveCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corJkLeftsleeveGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">肩パット</label>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corJkShoulderpad}</label></strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">体型補正</label>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corJkFigureCorrect}</label></strong></div>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${authority != '03' && authority != '04'}">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">店舗補正入力欄</strong>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col col-lg-12">
								<textarea readonly name="textarea-input" id="textarea-input"
									rows="3" class="form-control">${f:h(order.corJkStoreCorrectionMemo)}</textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</div>
</div>
</div>
<!-- JACKETEnd -->
<!-- GILET Start -->
<div class="col-md-12"  id="op_gilet_div" style="display:none;">
<div class="card" id="nav2_alter_div">
	<div class="card-header">
		<strong class="card-title">GILET</strong>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>GILETモデル</strong></label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.glModelNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right">
						<strong><label class=" form-control-label-value" id="gl_model_rt_price">${orderFm.glModelRtPriceFm}</label></strong>
					</div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.glBreastPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="gl_breast_pkt_rt_price">${orderFm.glBreastPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.glWaistPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="gl_waist_pkt_rt_price">${orderFm.glWaistPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">腰ポケット形状</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.glWaistPktShapeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="gl_waist_pkt_shape_rt_price">${orderFm.glWaistPktShapeRtPriceFm}</label></strong></div>
				</div>
				<c:if test="${order.productCategory == '9000102'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">腰ポケット素材</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.glWaistPktClothNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="gl_waist_pkt_cloth_rt_price">${orderFm.glWaistPktClothRtPriceFm}</label></strong></div>
				</div>
				</c:if>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.glAmfStitchNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="gl_amf_stitch_rt_price">${orderFm.glAmfStitchRtPriceFm}</label></strong></div>
				</div>
				<c:if test="${order.productCategory != '9000102' && order.glAmfStitchNm != '無し'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.glStitchPlcType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="gl_stitch_plc_rt_price">${orderFm.glStitchPlcRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ変更</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.glDblstitchPlcType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="gl_dblstitch_plc_rt_price">${orderFm.glDblstitchPlcRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.glAmfColorType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="gl_amf_color_rt_price">${orderFm.glAmfColorRtPriceFm}</label></strong></div>
				</div>
				</c:if>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.glBtnholeColorType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="gl_btnhole_color_rt_price">${orderFm.glBtnholeColorRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.glBtnthreadColorType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="gl_btnthread_color_rt_price">${orderFm.glBtnthreadColorRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">背裏地素材</label></div>
					<div class="col-12 col-md-6">
					<strong><label class=" form-control-label-value">${order.glBackClothNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="gl_back_cloth_rt_price">${orderFm.glBackClothRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label></div>
					<div class="col-12 col-md-6">
					<strong><label class=" form-control-label-value">${order.glInnnerClothNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="gl_innner_cloth_rt_price">${orderFm.glInnnerClothRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
					<div class="col-12 col-md-6">
					<strong><label class=" form-control-label-value">${order.glFrtBtnNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="gl_frt_btn_rt_price">${orderFm.glFrtBtnRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.glBackBeltNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="gl_back_belt_rt_price">${orderFm.glBackBeltRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ウォッチチェーン</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.glWatchChainNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="gl_watch_chain_rt_price">${orderFm.glWatchChainRtPriceFm}</label></strong></div>
				</div>
			</div>
		</div>　<div class="row">
		</div>
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>GILETサイズ</strong></label></div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corGlDrop}&nbsp &nbsp &nbsp${order.corGlSize}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>GILET補正</strong></label></div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">着丈修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corGlBodylengthCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong>${order.corGlBodylengthGross}cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">バスト修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corGlBustCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong>${order.corGlBustGross}cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">ウエスト修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corGlWaistCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong>${order.corGlWaistGross}cm</strong></div>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${authority != '03' && authority != '04'}">
	<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="card-header">
				<strong class="card-title">店舗補正入力欄</strong>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col col-lg-12">
						<textarea readonly name="textarea-input" id="textarea-input"
							rows="3" class="form-control">${f:h(order.corGlStoreCorrectionMemo)}</textarea>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</c:if>
</div>
</div>
<!-- GILET End -->
<!-- PANTS 1 Start -->
<div class="col-md-12"  id="op_pants_div" style="display:none;">
<div class="card"> <!-- id="nav2_option_div" -->
	<div class="card-header">
		<strong class="card-title">PANTS</strong>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptModelNm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptTackNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_tack_rt_price">${orderFm.ptTackRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptKneeinnerTypeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_kneeinner_type_rt_price">${orderFm.ptKneeinnerTypeRtPriceFm}</label></strong></div>
				</div>
				<c:if test="${order.ptKneeinnerTypeNm != '無し'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptKneeinnerClothNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_kneeinner_cloth_rt_price">${orderFm.ptKneeinnerClothRtPriceFm}</label></strong></div>
				</div>
				</c:if>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptFrtTypeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_frt_type_rt_price">${orderFm.ptFrtTypeRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptPancherinaNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_pancherina_rt_price">${orderFm.ptPancherinaRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptAdjusterNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_adjuster_rt_price">${orderFm.ptAdjusterRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
					<div class="col-12 col-md-8"><strong><label class=" form-control-label-value">${order.ptBeltloopType}</label></strong></div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="pt_beltloop_rt_price">${orderFm.ptBeltloopRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptPinloopNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_pinloop_rt_price">${orderFm.ptPinloopRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptSidePktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_side_pkt_rt_price">${orderFm.ptSidePktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptShinobiPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_shinobi_pkt_rt_price">${orderFm.ptShinobiPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptCoinPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_coin_pkt_rt_price">${orderFm.ptCoinPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptFlapcoinPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_flapcoin_pkt_rt_price">${orderFm.ptFlapcoinPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptLeftPisPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_left_pis_pkt_rt_price">${orderFm.ptLeftPisPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptRightPisPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_right_pis_pkt_rt_price">${orderFm.ptRightPisPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptVCutNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_v_cut_rt_price">${orderFm.ptVCutRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptHemUpNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_hem_up_rt_price">${orderFm.ptHemUpRtPriceFm}</label></strong></div>
				</div>
				<c:if test="${order.ptHemUpNm == 'ダブル糸' || order.ptHemUpNm == 'ダブルスナップ'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptDblWidthNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_dbl_width_rt_price">${orderFm.ptDblWidthRtPriceFm}</label></strong></div>
				</div>
				</c:if>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptAmfStitchNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_amf_stitch_rt_price">${orderFm.ptAmfStitchRtPriceFm}</label></strong></div>
				</div>
				<c:if test="${order.productCategory != '9000102' && order.ptAmfStitchNm != '無し'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.ptStitchPlcType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="pt_stitch_plc_rt_price">${orderFm.ptStitchPlcRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.ptDblstitchPlcType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="pt_dblstitch_plc_rt_price">${orderFm.ptDblstitchPlcRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.ptAmfColorType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="pt_amf_color_rt_price">${orderFm.ptAmfColorRtPriceFm}</label></strong></div>
				</div>
				</c:if>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.ptBtnholeColorType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="pt_btnhole_color_rt_price">${orderFm.ptBtnholeColorRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.ptBtnthreadColorType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="pt_btnthread_color_rt_price">${orderFm.ptBtnthreadColorRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value" id="ptBtnMaterial_appear">${order.ptBtnMaterialNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_btn_material_rt_price">${orderFm.ptBtnMaterialRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptSuspenderBtnNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_suspender_btn_rt_price">${orderFm.ptSuspenderBtnRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptNonSlipNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_non_slip_rt_price">${orderFm.ptNonSlipRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptChicSlipNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_chic_slip_rt_price">${orderFm.ptChicSlipRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptShapeMemoryNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_shape_memory_rt_price">${orderFm.ptShapeMemoryRtPriceFm}</label></strong></div>
				</div>
				<c:if test="${order.productCategory == '9000102'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">側章</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptSideStripeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_side_stripe_rt_price">${orderFm.ptSideStripeRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">側章幅</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ptSideStripeWidthNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt_side_stripe_width_rt_price">${orderFm.ptSideStripeWidthRtPriceFm}</label></strong></div>
				</div>
				</c:if>
			</div>
		</div>
		<div class="row">　</div>
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSサイズ</strong></label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.corPtDrop}&nbsp &nbsp &nbsp${order.corPtSize}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>PANTS補正</strong></label></div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">ウエスト修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corPtWaistCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corPtWaistGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">ヒップ修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corPtHipCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corPtHipGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">ワタリ幅修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corPtThighwidthCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corPtThighwidthGross}</label>cm</strong></div>
					<div class="col-12 col-md-2 offset-md-3">
						<label class=" form-control-label">裾幅</label>
					</div>					
				    <c:if test="${order.corPtHemwidthType == '1'}">
					<div class="col-12 col-md-1">
						<strong><label for="ap_hemWidth_absolute" class="form-check-label ">修正</label></strong>
					</div>
					<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value">${orderFm.corPtHemwidthCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4">
						<strong><label class=" form-control-label-value">${order.corPtHemwidthGross}</label>cm</strong>
					</div>
					</c:if>
					<c:if test="${order.corPtHemwidthType == '2'}">
					<div class="col-12 col-md-1">
						<strong><label for="ap_hemWidth_absolute" class="form-check-label ">指定</label></strong>
					</div>
					<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value">${order.corPtHemwidthDegignate}</label>cm</strong>
					</div>
					<div class="col-12 col-md-4">
					</div>
					</c:if>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">股下</label>
					</div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value" id="pantsCorinseamGross"></label>cm</strong></div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
	<c:if test="${authority != '03' && authority != '04'}">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<strong class="card-title">店舗補正入力欄</strong>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col col-lg-12">
							<textarea readonly name="textarea-input" id="textarea-input"
								rows="3" class="form-control">${f:h(order.corPtStoreCorrectionMemo)}</textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	</div>
</div>
</div>
<!-- PANTS 1 End -->
<!-- PANTS 2 Start -->
<div class="col-md-12"  id="op2_pants_div" style="display:none;">
<div class="card">
	<div class="card-header">
		<strong class="card-title">PANTS（2本目）</strong>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2ModelNm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2TackNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_tack_rt_price">${orderFm.pt2TackRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2KneeinnerTypeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_kneeinner_type_rt_price">${orderFm.pt2KneeinnerTypeRtPriceFm}</label></strong></div>
				</div>
				<c:if test="${order.pt2KneeinnerTypeNm != '無し'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2KneeinnerClothNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_kneeinner_cloth_rt_price">${orderFm.pt2KneeinnerClothRtPriceFm}</label></strong></div>
				</div>
				</c:if>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2FrtTypeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_frt_type_rt_price">${orderFm.pt2FrtTypeRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2PancherinaNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_pancherina_rt_price">${orderFm.pt2PancherinaRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2AdjusterNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_adjuster_rt_price">${orderFm.pt2AdjusterRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
					<div class="col-12 col-md-8"><strong><label class=" form-control-label-value">${order.pt2BeltloopType}</label></strong></div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="pt2_beltloop_rt_price">${orderFm.pt2BeltloopRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2PinloopNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_pinloop_rt_price">${orderFm.pt2PinloopRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2SidePktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_side_pkt_rt_price">${orderFm.pt2SidePktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2ShinobiPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_shinobi_pkt_rt_price">${orderFm.pt2ShinobiPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2CoinPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_coin_pkt_rt_price">${orderFm.pt2CoinPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2FlapcoinPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_flapcoin_pkt_rt_price">${orderFm.pt2FlapcoinPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2LeftPisPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_left_pis_pkt_rt_price">${orderFm.pt2LeftPisPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2RightPisPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_right_pis_pkt_rt_price">${orderFm.pt2RightPisPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2VCutNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_v_cut_rt_price">${orderFm.pt2VCutRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value" id="op_hemUp">${order.pt2HemUpNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_hem_up_rt_price">${orderFm.pt2HemUpRtPriceFm}</label></strong></div>
				</div>
				<c:if test="${order.pt2HemUpNm == 'ダブル糸' || order.pt2HemUpNm == 'ダブルスナップ'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2DblWidthNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_dbl_width_rt_price">${orderFm.pt2DblWidthRtPriceFm}</label></strong></div>
				</div>
				</c:if>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2AmfStitchNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_amf_stitch_rt_price">${orderFm.pt2AmfStitchRtPriceFm}</label></strong></div>
				</div>
				<c:if test="${order.productCategory != '9000102' && order.pt2AmfStitchNm != '無し'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.pt2StitchPlcType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="pt2_stitch_plc_rt_price">${orderFm.pt2StitchPlcRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.pt2DblstitchPlcType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="pt2_dblstitch_plc_rt_price">${orderFm.pt2DblstitchPlcRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.pt2AmfColorType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="pt2_amf_color_rt_price">${orderFm.pt2AmfColorRtPriceFm}</label></strong></div>
				</div>
				</c:if>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.pt2BtnholeColorType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="pt2_btnhole_color_rt_price">${orderFm.pt2BtnholeColorRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
					<div class="col-12 col-md-8">
					<strong><label class=" form-control-label-value">${order.pt2BtnthreadColorType}</label></strong>
					</div>
					<div class="col-12 col-md-1 text-right"><strong><label class=" form-control-label-value" id="pt2_btnthread_color_rt_price">${orderFm.pt2BtnthreadColorRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value" id="pt2BtnMaterial_appear">${order.pt2BtnMaterialNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_btn_material_rt_price">${orderFm.pt2BtnMaterialRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2SuspenderBtnNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_suspender_btn_rt_price">${orderFm.pt2SuspenderBtnRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2NonSlipNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_non_slip_rt_price">${orderFm.pt2NonSlipRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2ChicSlipNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_chic_slip_rt_price">${orderFm.pt2ChicSlipRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2ShapeMemoryNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_shape_memory_rt_price">${orderFm.pt2ShapeMemoryRtPriceFm}</label></strong></div>
				</div>
				<c:if test="${order.productCategory == '9000102'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">側章</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2SideStripeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_side_stripe_rt_price">${orderFm.pt2SideStripeRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">側章幅</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.pt2SideStripeWidthNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="pt2_side_stripe_width_rt_price">${orderFm.pt2SideStripeWidthRtPriceFm}</label></strong></div>
				</div>
				</c:if>
			</div>
		</div>
		<div class="row">　</div>
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSサイズ</strong></label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.corPt2Drop}&nbsp &nbsp &nbsp${order.corPt2Size}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>PANTS補正</strong></label></div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">ウエスト修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corPt2WaistCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corPt2WaistGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">ヒップ修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corPt2HipCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corPt2HipGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">ワタリ幅修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corPt2ThighwidthCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corPt2ThighwidthGross}</label>cm</strong></div>
					<div class="col-12 col-md-2 offset-md-3">
						<label class=" form-control-label">裾幅</label>
					</div>
					<c:if test="${order.corPt2HemwidthType == '1'}">
					<div class="col-12 col-md-1">
						<strong><label for="ap_hemWidth_absolute" class="form-check-label ">修正</label></strong>
					</div>
					<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value">${orderFm.corPt2HemwidthCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4">
						<strong><label class=" form-control-label-value">${order.corPt2HemwidthGross}</label>cm</strong>
					</div>
					</c:if>
					<c:if test="${order.corPt2HemwidthType == '2'}">
					<div class="col-12 col-md-1">
						<strong><label for="ap_hemWidth_absolute" class="form-check-label ">指定</label></strong>
					</div>
					<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value">${order.corPt2HemwidthDegignate}</label>cm</strong>
					</div>
					<div class="col-12 col-md-4">
					</div>
					</c:if>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">股下</label>
					</div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value" id="pants2CorinseamGross"></label>cm</strong></div>
				</div>
			</div>
		</div>
    </div>
	<div class="row">
	<c:if test="${authority != '03' && authority != '04'}">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<strong class="card-title">店舗補正入力欄</strong>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col col-lg-12">
							<textarea readonly name="textarea-input" id="textarea-input"
								rows="3" class="form-control">${f:h(order.corPt2StoreCorrectionMemo)}</textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</div>
</div>
</div>
<!-- PANTS 2 End -->
<!-- COAT Start -->
<div class="col-md-12"  id="op_coat_div" style="display:none;">
<div class="card" ><!-- id="nav2_option_div" -->
<div >
	<div class="card-header">
		<strong class="card-title">COAT</strong>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>COATモデル</strong></label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctModelNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right">
						<strong><label class=" form-control-label-value" id="ct_model_rt_price">${orderFm.ctModelRtPriceFm}</label></strong>
					</div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctLapelDesignNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_lapel_design_rt_price">${orderFm.ctLapelDesignRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctSleeveTypeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_sleeve_type_rt_price">${orderFm.ctSleeveTypeRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctWaistPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_waist_pkt_rt_price">${orderFm.ctWaistPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctChgPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_chg_pkt_rt_price">${orderFm.ctChgPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctSlantedPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_slanted_pkt_rt_price">${orderFm.ctSlantedPktRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctVentNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_vent_rt_price">${orderFm.ctVentRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">フロント釦数</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctFrtBtnNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_frt_btn_rt_price">${orderFm.ctFrtBtnRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctCuffNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_cuff_rt_price">${orderFm.ctCuffRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">袖釦</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctSleeveBtnNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_sleeve_btn_rt_price">${orderFm.ctSleeveBtnRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctBackBeltNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_back_belt_rt_price">${orderFm.ctBackBeltRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctCollarHangNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_collar_hang_rt_price">${orderFm.ctCollarHangRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctInnerBodyClothNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_inner_body_cloth_rt_price">${orderFm.ctInnerBodyClothRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctInnerSleeveClothNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_inner_sleeve_cloth_rt_price">${orderFm.ctInnerSleeveClothRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.ctBtnMaterialNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="ct_btn_material_rt_price">${orderFm.ctBtnMaterialRtPriceFm}</label></strong></div>
				</div>
			</div>
		</div>
		<div class="row">　</div>
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>COATサイズ</strong></label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.corCtSize}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>COAT補正</strong></label></div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">着丈修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corCtBodylengthCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corCtBodylengthGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">ウエスト修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corCtWaistCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corCtWaistGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">袖丈右修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corCtRightsleeveCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corCtRightsleeveGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">袖丈左修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corCtLeftsleeveCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corCtLeftsleeveGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">ベント修正（高さ）</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corCtVenthightCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corCtVenthightGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">ポケット位置</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corCtPktposCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corCtPktposGross}</label>cm</strong></div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
	<c:if test="${authority != '03' && authority != '04'}">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<strong class="card-title">店舗補正入力欄</strong>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col col-lg-12">
							<textarea readonly name="textarea-input" id="textarea-input"
								rows="3" class="form-control">${f:h(order.corCtStoreCorrectionMemo)}</textarea>
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
<!-- COAT End -->
<!-- SHIRT Start -->
<div class="col-md-12"  id="op_shirt_div" style="display:none;">
<div class="card" ><!-- id="nav2_option_div" -->
<div >
	<div class="card-header">
		<strong class="card-title">SHIRT</strong>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>SHIRTモデル</strong></label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stModelNm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">襟型</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stCollarTypeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_collar_type_rt_price">${orderFm.stCollarTypeRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">カフス</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stCuffsNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_cuffs_rt_price">${orderFm.stCuffsRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">コンバーチブル</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stConvertibleNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_convertible_rt_price">${orderFm.stConvertibleRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">アジャスト釦</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stAdjusterBtnNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_adjuster_btn_rt_price">${orderFm.stAdjusterBtnRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">クレリック仕様</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stClericNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_cleric_rt_price">${orderFm.stClericRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ダブルカフス仕様</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stDblCuffsNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_dbl_cuffs_rt_price">${orderFm.stDblCuffsRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">カフスボタン追加</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stCuffsBtnNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_cuffs_btn_rt_price">${orderFm.stCuffsBtnRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">釦</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stBtnMaterialNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_btn_material_rt_price">${orderFm.stBtnMaterialRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">タブ釦</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stDblBtnNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_dbl_btn_rt_price">${orderFm.stDblBtnRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ガントレットボタン位置</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stGauntletBtnPosNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_gauntlet_btn_pos_rt_price">${orderFm.stGauntletBtnPosRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ピンホールピン</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stPinholePinNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_pinhole_pin_rt_price">${orderFm.stPinholePinRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stBreastPktNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_breast_pkt_rt_price">${orderFm.stBreastPktRtPriceFm}</label></strong></div>
				</div>
				<c:if test="${order.stBreastPktNm != '無し'}">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">胸ポケット大きさ</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stBreastSizeNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_breast_size_rt_price">${orderFm.stBreastSizeRtPriceFm}</label></strong></div>
				</div>
				</c:if>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">フロントデザイン</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stFrtDesignNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_frt_design_rt_price">${orderFm.stFrtDesignRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ピンタックブザム</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stPintuckBosomNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_pintuck_bosom_rt_price">${orderFm.stPintuckBosomRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ステッチ</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stStitchNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_stitch_rt_price">${orderFm.stStitchRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">カラーキーパー</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stColarKeeperNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_colar_keeper_rt_price">${orderFm.stColarKeeperRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ボタンホール色変更</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stBtnholeColorNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_btnhole_color_rt_price">${orderFm.stBtnholeColorRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸色変更</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stBtnthreadColorNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_btnthread_color_rt_price">${orderFm.stBtnthreadColorRtPriceFm}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">カジュアルヘムライン仕様</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stCasualHemlineCd}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_casual_hemline_rt_price">${orderFm.stCasualHemlineRtPriceFm}</label></strong></div>
				
				    <c:if test="${order.stCasualHemlineCd == '有り'}">
				    <div class="col col-md-3"><label class=" form-control-label"></label></div>
					<div class="col-12 col-md-3"><strong><label class=" form-control-label-value">${order.stCasualHemlineSize}</label>cm</strong></div>
					<div class="col-12 col-md-2"></div>
					<div class="col-12 col-md-4"></div>
					</c:if>
					
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ボタン位置変更</label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.stBtnposChgNm}</label></strong></div>
					<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value" id="st_btnpos_chg_rt_price">${orderFm.stBtnposChgRtPriceFm}</label></strong></div>
				
				    <c:if test="${order.stBtnposChgNm == '有り'}">
				    <div class="col col-md-3"><label class=" form-control-label"></label></div>
					<div class="col-12 col-md-3"><label class=" form-control-label">台襟釦</label></div>
					<div class="col-12 col-md-2"><strong><label class=" form-control-label-value">${order.stNeckbandBtnChgNm} ${order.stNeckbandBtnPosChg}</label>cm</strong></div>
					<div class="col-12 col-md-4"></div>
					
					<div class="col col-md-3"><label class=" form-control-label"></label></div>
					<div class="col-12 col-md-3"><label class=" form-control-label">フロント第１釦</label></div>
					<div class="col-12 col-md-2"><strong><label class=" form-control-label-value">${order.stFrtfirstBtnChgNm} ${order.stFrtfirstBtnPosChg}</label>cm</strong></div>
					<div class="col-12 col-md-4"></div>
					
					<div class="col col-md-3"><label class=" form-control-label"></label></div>
					<div class="col-12 col-md-3"><label class=" form-control-label">フロント第2釦</label></div>
					<div class="col-12 col-md-2"><strong><label class=" form-control-label-value">${order.stFrtsecondBtnChgNm} ${order.stFrtsecondBtnPosChg}</label>cm</strong></div>
					<div class="col-12 col-md-4"></div>
					</c:if>
				</div>
			</div>
		</div>
		<div class="row">　</div>
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>SHIRTサイズ</strong></label></div>
					<div class="col-12 col-md-6"><strong><label class=" form-control-label-value">${order.corStSize}</label></strong></div>
				</div>
				<div class="row">
					<div class="col col-md-3"><label class=" form-control-label"><strong>SHIRT補正</strong></label></div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">ネック</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corStNeckCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corStNeckGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">着丈修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corStBodylengthCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corStBodylengthGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">袖丈右修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corStRightsleeveCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corStRightsleeveGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">袖丈左修正</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corStLeftsleeveCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corStLeftsleeveGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">背ダーツ詰め</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corStBackdartsPackCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">背ダーツ出し</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${order.corStBackdartsUnpackNm}</label></strong>
					</div>
					<div class="col-12 col-md-4"></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">カフス周り右</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corStRightcuffsSurroundingCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corStRightcuffsSurroundingGross}</label>cm</strong></div>
					<div class="col-12 col-md-3 offset-md-3">
						<label class=" form-control-label">カフス周り左</label>
					</div>
					<div class="col-12 col-md-2">
						<strong><label class=" form-control-label-value">${orderFm.corStLeftcuffsSurroundingCorrectFm}</label></strong>
					</div>
					<div class="col-12 col-md-4"><strong><label class=" form-control-label-value">${order.corStLeftcuffsSurroundingGross}</label>cm</strong></div>
				</div>
			</div>
		</div>
		
	</div>
	<div class="row">
	<c:if test="${authority != '03' && authority != '04'}">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<strong class="card-title">店舗補正入力欄</strong>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col col-lg-12">
							<textarea readonly name="textarea-input" id="textarea-input"
								rows="3" class="form-control">${f:h(order.corStoreCorrectionMemo)}</textarea>
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
<!-- SHIRT End -->
<!-- オプション End -->
<c:if test="${authority == '01' || authority == '02'}">
<div class="col-md-12">
<div class="card">
	<div class="card-body">
		<div class="row">
			<div class="col-lg-6">
				<div class="row">
					<div class="col"><label class=" form-control-label">ご請求金額</label></div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="row">
					<div class="col text-right">
						<strong><label>ご請求金額：${orderFm.billingAmountFm}（消費税${orderFm.consumptionTaxAmountFm}）</label></strong>
					</div>
				</div>
				<div class="row">
					<div class="col text-right">
						<label>商品金額：${orderFm.productPriceFm}</label>
					</div>
				</div>
				<div class="row">
					<div class="col text-right">
						<label>オプション金額：${orderFm.optionPriceFm}</label>
					</div>
				</div>
				<div class="row">
					<div class="col text-right">
						<label>合計金額：${orderFm.totalPriceFm}</label>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
</c:if>

<!-- 再補正タブ内容 Start -->
<c:if test="${authority == '01' || authority == '02' || authority == '05'}">
<c:if test="${order.tscStatus == 'T6' || order.tscStatus == 'T7'}">
<div class="col-md-12" id="jkCorrectAgain" style="display:none;">
	<div class="card">
		<div class="card-header">
			<strong class="card-title">JACKET 店舗補正</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col-12 col-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
						<div class="col-12 col-md-9">
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${order.corJkBodylengthCorrectAgain}</label>cm</strong>
							</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-9">
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${order.corJkWaistCorrectAgain}</label>cm</strong>
							</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">袖丈右修正</label>
						</div>
						<div class="col-12 col-md-9">
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${order.corJkRightsleeveCorrectAgain}</label>cm</strong>
							</div>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">袖丈左修正</label>
						</div>
						<div class="col-12 col-md-9">
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${order.corJkLeftsleeveCorrectAgain}</label>cm</strong>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-md-12" id="giletCorrectAgain" style="display: none;">
<div class="card">
	<div class="card-header">
		<strong class="card-title">GILET 店舗補正</strong>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col-12 col-md-3">
						<label class=" form-control-label">着丈修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corGlBodylengthCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">バスト修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corGlBustCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">ウエスト修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corGlWaistCorrectAgain}</label>cm</strong>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-md-12" id="ptCorrectAgain" style="display: none;">
<div class="card">
	<div class="card-header">
		<strong class="card-title">PANTS 店舗補正</strong>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col-12 col-md-3">
						<label class=" form-control-label">ウエスト修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPtWaistCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">ヒップ修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPtHipCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">ワタリ幅修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPtThighwidthCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">裾幅修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPtHemwidthCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">股下右修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPtRightinseamCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">股下左修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPtLeftinseamCorrectAgain}</label>cm</strong>
							</div>
						</div>
					</div>
			</div>
		</div>
	</div>
</div>
</div>

<div class="col-md-12" id="pt2CorrectAgain" style="display: none;">
<div class="card">
	<div class="card-header">
		<strong class="card-title">PANTS（2本目） 店舗補正</strong>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col col-lg-12">
				<div class="row">
					<div class="col-12 col-md-3">
						<label class=" form-control-label">ウエスト修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPt2WaistCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">ヒップ修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPt2HipCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">ワタリ幅修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPt2ThighwidthCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">裾幅修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPt2HemwidthCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">股下右修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPt2RightinseamCorrectAgain}</label>cm</strong>
						</div>
					</div>
					<div class="col-12 col-md-3">
						<label class=" form-control-label">股下左修正</label>
					</div>
					<div class="col-12 col-md-9">
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${order.corPt2LeftinseamCorrectAgain}</label>cm</strong>
							</div>
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
			<div class="col col-lg-10">
				<textarea readonly name="textarea-input" id="textarea-input"
					rows="3" class="form-control">${f:h(order.corStoreCorrectionMemoAgain)}</textarea>
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
						<c:if
							test="${authority == '02' || authority == '03' || authority == '05'}">
							<div class="row">
								<div class="col col-md-3">
									<label class=" form-control-label">下代価格</label>
								</div>
								<div class="col col-md-8">
									<strong><label class=" form-control-label-value">${orderFm.wsPriceFm}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">出荷日</label>
							</div>
							<div class="col col-md-8">
								<strong><label class=" form-control-label-value"
									id="shippingDateFormat"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">積載日</label>
							</div>
							<div class="col col-md-8">
								<strong><label class=" form-control-label-value"
									id="loadingDateFormat"></label></strong>
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
<!-- 再補正タブ内容 End -->

<!-- ボタン類 Start -->
<c:if test="${authority == '01'}">
	<c:if test="${userId == order.createdUserId}">
		<c:if test="${order.isCancelled != '1'}">
			<div class="col-md-12">
				<div class="card" id="nav2_alter_div">
					<div class="row">
						<div class="col-md-12">
							<div class="card-body">
								<div class="row">
									<c:if test="${order.makerFactoryStatus == 'F0' && (order.tscStatus == 'T2' || order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5') && (order.send2factoryStatus == '0' || order.send2factoryStatus == '2' || order.send2factoryStatus == '3' || order.send2factoryStatus == '4')}">
										<div class="col col-md-2"></div>
										<div class="col col-md-4">
											<button type="button" class="btn btn-success btn-block"
												id="backButton">一覧へ戻る</button>
										</div>
										<div class="col col-md-4">
											<button type="button" class="btn btn-danger btn-block"
												id="ChangeOrderValue">注文訂正</button>
										</div>
										<div class="col col-md-2"></div>
									</c:if>
									<c:if test="${order.makerFactoryStatus == 'F0' && (order.tscStatus == 'T2' || order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5') && order.send2factoryStatus == '1'}">		
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
									<c:if test="${order.tscStatus == 'T6' && (order.productItem == '01' || order.productItem == '02' || order.productItem == '03' || order.productItem == '04')}">
										<div class="col col-md-4">
											<button type="button" class="btn btn-success btn-block"
												id="backButton">一覧へ戻る</button>
										</div>
										<div class="col col-md-4">
											<button type="button" class="btn btn-primary btn-block"
												id="goRecorrection">お渡し時再補正入力</button>
										</div>
										<div class="col col-md-4">
											<button type="button" class="btn btn-danger btn-block"
												id="ChangeStatus">お渡し済</button>
										</div>
									</c:if>
									<c:if test="${order.tscStatus == 'T6' && (order.productItem == '05' || order.productItem == '06')}">
										<div class="col col-md-2"></div>
										<div class="col col-md-4">
											<button type="button" class="btn btn-success btn-block"
												id="backButton">一覧へ戻る</button>
										</div>
										<div class="col col-md-4">
											<button type="button" class="btn btn-danger btn-block"
												id="ChangeStatus">お渡し済</button>
										</div>
										<div class="col col-md-2"></div>
									</c:if>
									<c:if test="${order.tscStatus == 'T7' && (order.productItem == '01' || order.productItem == '02' || order.productItem == '03' || order.productItem == '04')}">
										<div class="col col-md-2"></div>
										<div class="col col-md-4">
											<button type="button" class="btn btn-success btn-block"
												id="backButton">一覧へ戻る</button>
										</div>
										<div class="col col-md-4">
											<button type="button" class="btn btn-primary btn-block"
												id="goRecorrection">お渡し時再補正入力</button>
										</div>
										<div class="col col-md-2"></div>
									</c:if>
									<c:if test="${order.tscStatus == 'T7' && (order.productItem == '05' || order.productItem == '06')}">
										<div class="col col-md-4"></div>
										<div class="col col-md-4">
											<button type="button" class="btn btn-success btn-block"
												id="backButton">一覧へ戻る</button>
										</div>
										<div class="col col-md-4"></div>
									</c:if>
									<c:if test="${(order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5') && (order.makerFactoryStatus == 'F1' || order.makerFactoryStatus == 'F2')}">
										<div class="col col-md-4"></div>
										<div class="col col-md-4">
											<button type="button" class="btn btn-success btn-block"
												id="backButton">一覧へ戻る</button>
										</div>
										<div class="col col-md-4"></div>
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
							<div class="col col-md-4"></div>
							<div class="col col-md-4">
								<button type="button" class="btn btn-success btn-block"
									id="backButton">一覧へ戻る</button>
							</div>
							<div class="col col-md-4"></div>
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
				<c:if test="${order.makerFactoryStatus == 'F0' && order.tscStatus == 'T2' && (order.send2factoryStatus == '0' || order.send2factoryStatus == '2' || order.send2factoryStatus == '3' || order.send2factoryStatus == '4')}">
					<div class="row">
						<div class="col-md-12">
							<div class="card-body">
								<div class="row">
									<div class="col col-md-2"></div>
									<div class="col col-md-4">
										<button type="button" class="btn btn-success btn-block"
											id="backButton">一覧へ戻る</button>
									</div>
									<div class="col col-md-4">
										<button type="button" class="btn btn-danger btn-block"
											id="ChangeOrderValue">注文訂正</button>
									</div>
									<div class="col col-md-2"></div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${order.makerFactoryStatus == 'F0' && order.tscStatus == 'T2' && order.send2factoryStatus == '1'}">		
				<div class="row">
					<div class="col-md-12">
						<div class="card-body">
							<div class="row">
								<div class="col col-md-4">
								</div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-info btn-block" id="backButton" >
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
				<c:if
					test="${((order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5') && order.makerFactoryStatus == 'F1') || ((order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5') && order.makerFactoryStatus == 'F0') }">
					<div class="row">
						<div class="col-md-12">
							<div class="card-body">
								<div class="row">
									<div class="col col-md-2"></div>
									<div class="col col-md-4">
										<input type="text" id="nextGenerationDisplay"
											class="input-sm form-control-sm form-control"
											value="${order.wsPrice}" maxlength="10" />
									</div>
									<div class="col col-md-4">
										<button type="button" class="btn btn-warning btn-block"
											id="nextGenerationCount">下代自動計算</button>
									</div>
									<div class="col col-md-2"></div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-12">
							<div class="card-body">
								<div class="row">
									<div class="col col-md-2"></div>
									<div class="col col-md-4">
										<button type="button" class="btn btn-success btn-block"
											id="backButton">一覧へ戻る</button>
									</div>
									<div class="col col-md-4">
										<button type="button" class="btn btn-primary btn-block"
											id="nextGenerationSave">オーダーを変更</button>
									</div>
									<div class="col col-md-2"></div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if
					test="${((order.tscStatus == 'T3' || order.tscStatus == 'T4' || order.tscStatus == 'T5') && order.makerFactoryStatus == 'F2') || (order.tscStatus == 'T6' || order.tscStatus == 'T7') }">
					<div class="row">
						<div class="col-md-12">
							<div class="card-body">
								<div class="row">
									<div class="col col-md-4"></div>
									<div class="col col-md-4">
										<button type="button" class="btn btn-success btn-block"
											id="backButton">一覧へ戻る</button>
									</div>
									<div class="col col-md-4"></div>
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
								<div class="col col-md-4"></div>
								<div class="col col-md-4">
									<button type="button" class="btn btn-success btn-block"
										id="backButton">一覧へ戻る</button>
								</div>
								<div class="col col-md-4"></div>
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
											<input type="text" id="fabricUsedMount" class="input-sm form-control-sm form-control" onkeyup="clearNoNum(this)" value="${order.fabricUsedMount}" maxlength="6" />
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
										<button type="button" class="btn btn-success btn-block"
											id="backButton">一覧へ戻る</button>
									</div>
									<div class="col col-md-4">
										<button type="button" class="btn btn-primary btn-block"
											id="saveValue">保存</button>
									</div>
									<div class="col col-md-4">
										<button type="submit" class="btn btn-danger btn-block"
											id="saveOrChangeValue">生産終了にする</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if
					test="${order.tscStatus == 'T6' || order.tscStatus == 'T7' || order.makerFactoryStatus == 'F2'}">
					<div class="row">
						<div class="col-md-12">
							<div class="card-body">
								<div class="row">
									<div class="col col-md-4"></div>
									<div class="col col-md-4">
										<button type="button" class="btn btn-success btn-block"
											id="backButton">一覧へ戻る</button>
									</div>
									<div class="col col-md-4"></div>
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
						<div class="col col-md-4"></div>
						<div class="col col-md-4">
							<button type="button" class="btn btn-success btn-block"
								id="backButton">一覧へ戻る</button>
						</div>
						<div class="col col-md-4"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:if>
<!-- ボタン類 End -->

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
	
	//戻るボタンクリック
	jQuery('#backButton').on('click', function() {
		window.location.href= contextPath + "/orderlist/gotoOrderlist";
	});

	//注文訂正
	jQuery("#ChangeOrderValue").click(function(){
		//注文ID
		var orderId = "${order.orderId}"
		window.location.href= contextPath + "/orderCoDetail/orderDetailToOrderCo/" + orderId;
	})

	//お渡し時再補正入力画面にジャンプ	
	var orderId = "${order.orderId}";
	jQuery("#goRecorrection").click(function(){
		window.location.href= contextPath + "/orderCoDetail/orderDetailToCo/" + orderId;
	})

	//TSCステータスを「お渡し済」に変更する、保存完了後、「オーダー登録結果」画面へ遷移する
	jQuery("#ChangeStatus").click(function(){
		var orderId = "${order.orderId}";
		//TSCステータス
		var changeTscStatus = 'T7'; 
		//バージョン
		var orderVersion = "${order.version}";
		window.location.href= contextPath + "/orderCoDetail/changeStatusCo/" + orderId + "/" + changeTscStatus + "/" + orderVersion;
	})

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
			 url: contextPath + "/orderCoDetail/decideFabricUsedMount",
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
								window.location.href= contextPath + "/orderCoDetail/saveValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&orderVersion=" + orderVersion;
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
								window.location.href= contextPath + "/orderCoDetail/saveValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&orderVersion=" + orderVersion;
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
						window.location.href= contextPath + "/orderCoDetail/saveValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&orderVersion=" + orderVersion;
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
						window.location.href= contextPath + "/orderCoDetail/saveValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&orderVersion=" + orderVersion;
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
						window.location.href= contextPath + "/orderCoDetail/saveValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&orderVersion=" + orderVersion;
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
				window.location.href= contextPath + "/orderCoDetail/saveValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&orderVersion=" + orderVersion;	
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
		 url: contextPath + "/orderCoDetail/decideFabricUsedMount",
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
									window.location.href= contextPath + "/orderCoDetail/saveOrChangeValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&makerFactoryStatus=" + makerFactoryStatus + "&orderVersion=" + orderVersion;
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
							window.location.href= contextPath + "/orderCoDetail/saveOrChangeValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&makerFactoryStatus=" + makerFactoryStatus + "&orderVersion=" + orderVersion;
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
							window.location.href= contextPath + "/orderCoDetail/saveOrChangeValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&makerFactoryStatus=" + makerFactoryStatus + "&orderVersion=" + orderVersion;
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
					window.location.href= contextPath + "/orderCoDetail/saveOrChangeValue/?orderId=" + orderId + "&fabricNo=" + fabricNo + "&fabricUsedMount=" + fabricUsedMount + "&shippingDate=" + shippingDate + "&loadingDate=" + loadingDate + "&makerFactoryStatus=" + makerFactoryStatus + "&orderVersion=" + orderVersion;
				  }
			})
	}
	
})

	//下代価格を計算する
	jQuery("#nextGenerationCount").click(function(){
		appendAlertDel('errormssage');
		//注文ID
		var orderId = "${order.orderId}";
		jQuery.ajax({
			 type:"post",
			 url: contextPath + "/orderCoDetail/nextGenerationCoCount",
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
		window.location.href= contextPath + "/orderCoDetail/nextGenerationCoPrice/" + orderId + "/" + nextGenerationPrice + "/" + orderVersion + "/" + status;
			
	})

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

	if ("${order.makerFactoryStatus}" == "F1" || "${order.makerFactoryStatus}" == "F2") {
		jQuery("#status_appear").html(statusList["${order.tscStatus}"] + " " + "・" + " "
						+ factoryStatusList["${order.makerFactoryStatus}"]);
	} else {
		jQuery("#status_appear").html(statusList["${order.tscStatus}"]);
	}

	var productOrderdDate = "${order.productOrderdDate}";
	if (productOrderdDate != null) {
		jQuery("#product_orderd_date").html(dateFormat(productOrderdDate))
	}

	var custDeliverDate = "${order.custDeliverDate}";
	if (custDeliverDate != null) {
		jQuery("#cust_deliver_date").html(dateFormat(custDeliverDate))
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

	//商品情報_カテゴリの内容表示
	var categoryType = {
		9000101 : "標準",
		9000103 : "ウォッシャブル",
		9000102 : "タキシード"
	};
	jQuery("#product_category").html(categoryType["${order.productCategory}"]);

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

	var custShopDeliveryDate = "${order.custShopDeliveryDate}";
	if (custShopDeliveryDate != null) {
		jQuery("#cust_shop_delivery_date").html(
				dateFormat(custShopDeliveryDate))
	}
	
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

	if ("${authority}" == "03" || "${authority}" == "04"
			|| "${authority}" == "05") {
		jQuery("#product_is_3Piece_rt_price").hide();
		jQuery("#product_spare_pants_rt_price").hide();
		jQuery("#product_embroidery_gazette_rt_price").hide();
		jQuery("#product_embroidery_nm_pos_rt_price").hide();
		jQuery("#product_lcr_sewing_rt_price").hide();
		jQuery("#cust_is_deliver_shortning_rt_price").hide();
		jQuery("#jk_model_rt_price").hide();
		jQuery("#jk_frt_btn_rt_price").hide();
		jQuery("#jk_lapel_design_rt_price").hide();
		jQuery("#jk_grade_rt_price").hide();
		jQuery("#jk_daiba_rt_price").hide();
		jQuery("#jk_look_cloth_rt_price").hide();
		jQuery("#jk_collar_inner_rt_price").hide();
		jQuery("#jk_collar_hang_rt_price").hide();
		jQuery("#jk_lapel_width_rt_price").hide();
		jQuery("#jk_flower_hole_rt_price").hide();
		jQuery("#jk_breast_pkt_rt_price").hide();
		jQuery("#jk_inner_cloth_rt_price").hide();
		jQuery("#jk_waist_pkt_rt_price").hide();
		jQuery("#jk_chg_pkt_rt_price").hide();
		jQuery("#jk_slanted_pkt_rt_price").hide();
		jQuery("#jk_shinobi_pkt_rt_price").hide();
		jQuery("#jk_sleeve_type_rt_price").hide();
		jQuery("#jk_manica_rt_price").hide();
		jQuery("#jk_sleeve_btn_rt_price").hide();
		jQuery("#jk_cuff_rt_price").hide();
		jQuery("#jk_inner_pkt_rt_price").hide();
		jQuery("#jk_right_inner_pkt_type_rt_price").hide();
		jQuery("#jk_dblstitch_plc_rt_price").hide();
		jQuery("#jk_amf_color_rt_price").hide();
		jQuery("#jk_stitch_type_rt_price").hide();
		jQuery("#jk_stitch_plc_rt_price").hide();
		jQuery("#jk_btnhole_plc_color_rt_price").hide();
		jQuery("#jk_btnthread_plc_color_rt_price").hide();
		jQuery("#jk_vent_rt_price").hide();
		jQuery("#jk_inner_body_cloth_rt_price").hide();
		jQuery("#jk_inner_sleeve_cloth_rt_price").hide();
		jQuery("#jk_btn_material_rt_price").hide();
		jQuery("#jk_shape_memory_rt_price").hide();
		jQuery("#gl_model_rt_price").hide();
		jQuery("#gl_breast_pkt_rt_price").hide();
		jQuery("#gl_waist_pkt_rt_price").hide();
		jQuery("#gl_waist_pkt_shape_rt_price").hide();
		jQuery("#gl_waist_pkt_cloth_rt_price").hide();
		jQuery("#gl_amf_stitch_rt_price").hide();
		jQuery("#gl_stitch_plc_rt_price").hide();
		jQuery("#gl_dblstitch_plc_rt_price").hide();
		jQuery("#gl_amf_color_rt_price").hide();
		jQuery("#gl_btnhole_color_rt_price").hide();
		jQuery("#gl_btnthread_color_rt_price").hide();
		jQuery("#gl_back_cloth_rt_price").hide();
		jQuery("#gl_innner_cloth_rt_price").hide();
		jQuery("#gl_frt_btn_rt_price").hide();
		jQuery("#gl_back_belt_rt_price").hide();
		jQuery("#gl_watch_chain_rt_price").hide();
		jQuery("#pt_tack_rt_price").hide();
		jQuery("#pt_kneeinner_type_rt_price").hide();
		jQuery("#pt_kneeinner_cloth_rt_price").hide();
		jQuery("#pt_frt_type_rt_price").hide();
		jQuery("#pt_pancherina_rt_price").hide();
		jQuery("#pt_adjuster_rt_price").hide();
		jQuery("#pt_beltloop_rt_price").hide();
		jQuery("#pt_pinloop_rt_price").hide();
		jQuery("#pt_side_pkt_rt_price").hide();
		jQuery("#pt_shinobi_pkt_rt_price").hide();
		jQuery("#pt_coin_pkt_rt_price").hide();
		jQuery("#pt_flapcoin_pkt_rt_price").hide();
		jQuery("#pt_left_pis_pkt_rt_price").hide();
		jQuery("#pt_right_pis_pkt_rt_price").hide();
		jQuery("#pt_v_cut_rt_price").hide();
		jQuery("#pt_hem_up_rt_price").hide();
		jQuery("#pt_dbl_width_rt_price").hide();
		jQuery("#pt_amf_stitch_rt_price").hide();
		jQuery("#pt_stitch_plc_rt_price").hide();
		jQuery("#pt_dblstitch_plc_rt_price").hide();
		jQuery("#pt_amf_color_rt_price").hide();
		jQuery("#pt_btnhole_color_rt_price").hide();
		jQuery("#pt_btnthread_color_rt_price").hide();
		jQuery("#pt_btn_material_rt_price").hide();
		jQuery("#pt_suspender_btn_rt_price").hide();
		jQuery("#pt_non_slip_rt_price").hide();
		jQuery("#pt_chic_slip_rt_price").hide();
		jQuery("#pt_shape_memory_rt_price").hide();
		jQuery("#pt2_kneeinner_type_rt_price").hide();
		jQuery("#pt2_kneeinner_cloth_rt_price").hide();
		jQuery("#pt2_frt_type_rt_price").hide();
		jQuery("#pt2_pancherina_rt_price").hide();
		jQuery("#pt2_beltloop_rt_price").hide();
		jQuery("#pt2_pinloop_rt_price").hide();
		jQuery("#pt2_side_pkt_rt_price").hide();
		jQuery("#pt2_shinobi_pkt_rt_price").hide();
		jQuery("#pt2_coin_pkt_rt_price").hide();
		jQuery("#pt2_flapcoin_pkt_rt_price").hide();
		jQuery("#pt2_left_pis_pkt_rt_price").hide();
		jQuery("#pt2_right_pis_pkt_rt_price").hide();
		jQuery("#pt2_v_cut_rt_price").hide();
		jQuery("#pt2_amf_stitch_rt_price").hide();
		jQuery("#pt2_stitch_plc_rt_price").hide();
		jQuery("#pt2_dblstitch_plc_rt_price").hide();
		jQuery("#pt2_amf_color_rt_price").hide();
		jQuery("#pt2_btnhole_color_rt_price").hide();
		jQuery("#pt2_btnthread_color_rt_price").hide();
		jQuery("#pt2_suspender_btn_rt_price").hide();
		jQuery("#pt2_adjuster_rt_price").hide();
		jQuery("#pt2_hem_up_rt_price").hide();
		jQuery("#pt2_dbl_width_rt_price").hide();
		jQuery("#pt2_btn_material_rt_price").hide();
		jQuery("#pt2_non_slip_rt_price").hide();
		jQuery("#pt2_chic_slip_rt_price").hide();
		jQuery("#pt2_shape_memory_rt_price").hide();
		jQuery("#pt2_tack_rt_price").hide();
		jQuery("#ct_model_rt_price").hide();
		jQuery("#ct_lapel_design_rt_price").hide();
		jQuery("#ct_sleeve_type_rt_price").hide();
		jQuery("#ct_waist_pkt_rt_price").hide();
		jQuery("#ct_chg_pkt_rt_price").hide();
		jQuery("#ct_slanted_pkt_rt_price").hide();
		jQuery("#ct_vent_rt_price").hide();
		jQuery("#ct_frt_btn_rt_price").hide();
		jQuery("#ct_cuff_rt_price").hide();
		jQuery("#ct_sleeve_btn_rt_price").hide();
		jQuery("#ct_back_belt_rt_price").hide();
		jQuery("#ct_collar_hang_rt_price").hide();
		jQuery("#ct_inner_body_cloth_rt_price").hide();
		jQuery("#ct_inner_sleeve_cloth_rt_price").hide();
		jQuery("#ct_btn_material_rt_price").hide();
		jQuery("#st_collar_type_rt_price").hide();
		jQuery("#st_cuffs_rt_price").hide();
		jQuery("#st_convertible_rt_price").hide();
		jQuery("#st_adjuster_btn_rt_price").hide();
		jQuery("#st_cleric_rt_price").hide();
		jQuery("#st_dbl_cuffs_rt_price").hide();
		jQuery("#st_cuffs_btn_rt_price").hide();
		jQuery("#st_btn_material_rt_price").hide();
		jQuery("#st_dbl_btn_rt_price").hide();
		jQuery("#st_gauntlet_btn_pos_rt_price").hide();
		jQuery("#st_pinhole_pin_rt_price").hide();
		jQuery("#st_breast_pkt_rt_price").hide();
		jQuery("#st_breast_size_rt_price").hide();
		jQuery("#st_frt_design_rt_price").hide();
		jQuery("#st_pintuck_bosom_rt_price").hide();
		jQuery("#st_stitch_rt_price").hide();
		jQuery("#st_colar_keeper_rt_price").hide();
		jQuery("#st_btnhole_color_rt_price").hide();
		jQuery("#st_btnthread_color_rt_price").hide();
		jQuery("#st_casual_hemline_rt_price").hide();
		jQuery("#st_btnpos_chg_rt_price").hide();
		jQuery("#st_neckband_btn_chg_rt_price").hide();
		jQuery("#st_frtfirst_btn_chg_rt_price").hide();
		jQuery("#st_frtsecond_btn_chg_rt_price").hide();
		jQuery("#pt_side_stripe_rt_price").hide();
		jQuery("#pt_side_stripe_width_rt_price").hide();
		jQuery("#pt2_side_stripe_rt_price").hide();
		jQuery("#pt2_side_stripe_width_rt_price").hide();
	}
	
	//組成表示　胴裏地
	var result = "${order.productComposBodyLiner}";
	if (result.indexOf(" ") != -1) {
		var labelArray = new Array();
		labelArray = result.split(" ");
		for (i = 0; i < labelArray.length; i++) {
			jQuery("#composBodyLiner").append(labelArray[i]).append("<Br>");
		}
	} else {
		jQuery("#composBodyLiner").html(result);
	}

	//pants股下初期値表示
	if ("${order.corPtLeftinseamGross }" == ''
			&& "${order.corPtRightinseamGross }" == '') {
		jQuery("#pantsCorinseamGross").html('左 000.0cm &nbsp &nbsp &nbsp 右 000.0');
	} else if ("${order.corPtLeftinseamGross }" != ''
			&& "${order.corPtRightinseamGross }" == '') {
		jQuery("#pantsCorinseamGross").html('左 ' + "${order.corPtLeftinseamGross}"+ 'cm &nbsp &nbsp &nbsp 右  000.0');
	} else if ("${order.corPtLeftinseamGross }" == ''
			&& "${order.corPtRightinseamGross }" != '') {
		jQuery("#pantsCorinseamGross").html('左 000.0cm &nbsp &nbsp &nbsp 右 '+ "${order.corPtRightinseamGross}");
	} else {
		jQuery("#pantsCorinseamGross").html('左 ' + "${order.corPtLeftinseamGross}"+ 'cm &nbsp &nbsp &nbsp 右  '+ "${order.corPtRightinseamGross}");
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
								window.location.href = contextPath + "/pdfFile/coPdfFileDownload?sign="+sign+"&orderId="+orderId+"&productItem="+productItem;
							}
						});
					}else{
						window.location.href = contextPath + "/pdfFile/coPdfFileDownload?sign="+sign+"&orderId="+orderId+"&productItem="+productItem;
					}
				}
		    }
		});
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
	
	//出荷日のFormat
	var shippingDateFormat = "${order.shippingDate}";
	if (shippingDateFormat != null && shippingDateFormat != '') {
		jQuery("#shippingDateFormat").html(
				dateFormat(shippingDateFormat));
	}
	else if(shippingDateFormat == ''){
		jQuery("#shippingDateFormat").html('');
	}

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

	//積載日のFormat
	var loadingDateFormat = "${order.loadingDate}";
	if (loadingDateFormat != null && loadingDateFormat != '') {
		jQuery("#loadingDateFormat").html(
				dateFormat(loadingDateFormat));
	}
	else if(loadingDateFormat == ''){
		jQuery("#loadingDateFormat").html('');
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

			jQuery('#op_gilet_div').show();

			jQuery('#op_pants_div').show();

			jQuery('#op2_pants_div').show();
		} else if ("${order.productIs3piece}" == '0009902'
				&& "${order.productSparePantsClass}" == '0009901') {
			jQuery('#op_jacket_div').show();

			jQuery('#op_gilet_div').show();

			jQuery('#op_pants_div').show();
		} else if ("${order.productIs3piece}" == '0009901'
				&& "${order.productSparePantsClass}" == '0009902') {
			jQuery('#op_jacket_div').show();

			jQuery('#op_pants_div').show();

			jQuery('#op2_pants_div').show();
		} else if ("${order.productIs3piece}" == '0009901'
				&& "${order.productSparePantsClass}" == '0009901') {
			jQuery('#op_jacket_div').show();

			jQuery('#op_pants_div').show();
		}
	} else if (item == "JACKET") {
		jQuery('#op_jacket_div').show();
		
	} else if (item == "PANTS") {
		jQuery('#op_pants_div').show();
		
	} else if (item == "GILET") {
		jQuery('#op_gilet_div').show();
		
	} else if (item == "SHIRT") {
		jQuery('#op_shirt_div').show();
		
	}else if (item == "COAT") {
		jQuery('#op_coat_div').show();
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
	
	//GILET_着丈_再補正値
	var corGlBodylengthCorrectAgain = "${order.corGlBodylengthCorrectAgain}";
	//GILET_バスト_再補正値
	var corGlBustCorrectAgain = "${order.corGlBustCorrectAgain}";
	//GILET_ウエスト_再補正値
	var corGlWaistCorrectAgain = "${order.corGlWaistCorrectAgain}";

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

	//GILET_着丈修正_再補正値
	var corGlBodylengthCorrectAgain = "${order.corGlBodylengthCorrectAgain}";
	//GILET_バスト修正_再補正値
	var corGlBustCorrectAgain = "${order.corGlBustCorrectAgain}";
	//GILET_ウエスト修正_再補正値
	var corGlWaistCorrectAgain = "${order.corGlWaistCorrectAgain}";

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

		if(productItemDisplayValue == '31' || productItemDisplayValue == '32'){
			if(!isEmpty(corGlBodylengthCorrectAgain) || !isEmpty(corGlBustCorrectAgain) || !isEmpty(corGlWaistCorrectAgain)){
				jQuery('#giletCorrectAgain').show();
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
	else if(productItemValue == '04'){
		if(!isEmpty(corGlBodylengthCorrectAgain) || !isEmpty(corGlBustCorrectAgain) || !isEmpty(corGlWaistCorrectAgain)){
			jQuery('#giletCorrectAgain').show();
			jQuery('#correctionMemoAgain').show();
		}
	}
		
</script>


