<style type="text/css">
span {
	margin-right: 16px;
}
select.hidedown {
	-webkit-appearance:none;
	-moz-appearance:none;
	appearance:none;
}
</style>
<form:form id="idForm" action="${pageContext.request.contextPath}/orderCoConfirm/orderCoReFormInDb" method="post" modelAttribute="orderForm" class="form-horizontal">
<div class="breadcrumbs">
	<div class="col-sm-4">
		<div class="page-header float-left">
			<div class="page-title">
				<h1>オーダー内容確認</h1>
			</div>
		</div>
	</div>
</div>
<div class="content mt-3">
	<div class="animated fadeIn">
		<div class="row">
			<div class="col-lg-6">
				<div class="row">
					<div class="col col-md-4">
						<label class=" form-control-label">お客様名</label>
					</div>
					<c:if test="${orderForm.customerMessageInfo.custNm != '' && orderForm.customerMessageInfo.custKanaNm != '' && orderForm.customerMessageInfo.custNm != null && orderForm.customerMessageInfo.custKanaNm != null}">
						<div class="col-12 col-md-8">
							<label class=" form-control-label-value">${f:h(orderForm.customerMessageInfo.custNm)}(${f:h(orderForm.customerMessageInfo.custKanaNm)})</label>様
						</div>
					</c:if>
					<c:if test="${orderForm.customerMessageInfo.custKanaNm != null && orderForm.customerMessageInfo.custKanaNm != '' && (orderForm.customerMessageInfo.custNm == '' || orderForm.customerMessageInfo.custNm == null)}">
						<div class="col-12 col-md-8">
							<label class=" form-control-label-value">(${f:h(orderForm.customerMessageInfo.custKanaNm)})</label>様
						</div>
					</c:if>
					<c:if test="${orderForm.customerMessageInfo.custNm != '' && orderForm.customerMessageInfo.custNm != null && (orderForm.customerMessageInfo.custKanaNm == '' || orderForm.customerMessageInfo.custKanaNm == null)}">
						<div class="col-12 col-md-8">
							<label class=" form-control-label-value">${f:h(orderForm.customerMessageInfo.custNm)}</label>様
						</div>
					</c:if>
				</div>
				<div class="row">
					<div class="col col-md-4">
						<label class=" form-control-label">ステータス</label>
					</div>
					<div class="col-12 col-md-8">
						<label class=" form-control-label-value" id="status_appear"></label>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
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
		</div>
	</div>
</div>
<br>
<div class="col-md-12">
	<div class="card">
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-6">
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">注文ID</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value">${orderForm.customerMessageInfo.orderId}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">会員番号</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value">${orderForm.customerMessageInfo.custCd}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">お客様氏名</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value">${f:h(orderForm.customerMessageInfo.custNm)}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">フリガナ</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value">${f:h(orderForm.customerMessageInfo.custKanaNm)}</label></strong>
						</div>
					</div>
					<div class="row"><div class="col col-md-3"><label class=" form-control-label">　</label></div></div>
					<div class="row"><div class="col col-md-3"><label class=" form-control-label">　</label></div></div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label" >承り日</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value" id="License_day"></label></strong>
						</div>
					</div>
				</div>
				<div class="col col-lg-6">
					<c:if test="${orderForm.customerMessageInfo.custIsDeliverShortning == '0'}">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">納期短縮</label></div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">無</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.customerMessageInfo.custIsDeliverShortning == '1'}">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">納期短縮</label></div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">有</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.customerMessageInfo.custIsEarlyDiscount == '0'}">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">早割</label></div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">無</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.customerMessageInfo.custIsEarlyDiscount == '1'}">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">早割</label></div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">有</label></strong>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">お渡し日</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value" id="cust_shop_delivery_date"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">スタッフ</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value">${f:h(orderForm.customerMessageInfo.custStaff)}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">区分</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value" id="cust_type"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">出荷先</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value" id='cust_shipping_destination'></label></strong>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col col-lg-12">
					<div class="row form-group">
						<div  style="padding-left:15px;width:12.5%"><label class=" form-control-label">お客様備考</label></div>
						<div style="padding-right:15px;padding-left:15px;width:87.5%">
							<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${f:h(orderForm.customerMessageInfo.custRemark)}</textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- お客様情報 End -->
<!-- メジャーリング Start-->
<div class="col-md-12">
	<div class="card">
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-4">
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">フルレングス</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="fullLength"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ショルダー</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="shoulder"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">リーチ（右）</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="reachRight"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">リーチ（左）</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="reachLeft"></label>cm</strong>
						</div>
					</div>
				</div>
				<div class="col col-lg-4">
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">アウトバスト</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="outBust"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">バスト</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="bust"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">JKウエスト</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="jacketWaist"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">PTウエスト</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="pantsWaist"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ヒップ</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="hip"></label>cm</strong>
						</div>
					</div>
				</div>
				<div class="col col-lg-4">
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ワタリ（右）</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="spanRight"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ワタリ（左）</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="spanLeft"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ふくらはぎ（右）</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="calfRight"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ふくらはぎ（左）</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="calfLeft"></label>cm</strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-6"><label class=" form-control-label">ネック</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="neck"></label>cm</strong>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- メジャーリング End -->
<!-- ITEM Start -->
<div class="col-md-12">
	<div class="card">
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
					<div class="col col-md-3"><label class=" form-control-label">ITEM</label></div>
						<div class="col-12 col-md-6">
						<strong><label class=" form-control-label-value" id="product_item">${orderForm.productItemMap[orderForm.productItem]}</label></strong>
						</div>
					</div>
					<c:if test="${orderForm.productItem == '01'}">
						<c:if test="${orderForm.productIs3Piece == '0009901'}">
							<div class="row" id="threePiece_div">
								<div class="col col-md-3">
									<label class=" form-control-label">３Piece</label>
								</div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">無し</label></strong>
								</div>
								<div class="col-12 col-md-1" align="right">
									<strong><label class=" form-control-label-value" id="productIs3Piece">無料</label></strong>
								</div>
							</div>
						</c:if>
						<c:if test="${orderForm.productIs3Piece == '0009902'}">
							<div class="row" id="threePiece_div">
								<div class="col col-md-3">
									<label class=" form-control-label">３Piece</label>
								</div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">有り</label></strong>
								</div>
								<div class="col-12 col-md-1" align="right">
									<strong><label class=" form-control-label-value" id="productIs3Piece_appear"></label></strong>
								</div>
							</div>
						</c:if>
						<c:if test="${orderForm.productSparePantsClass == '0009901'}">
							<div class="row" id="sparePants_div">
								<div class="col col-md-3">
									<label class=" form-control-label">スペアパンツ</label>
								</div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">無し</label></strong>
								</div>
								<div class="col-12 col-md-1" align="right">
									<strong><label class=" form-control-label-value" id="productSparePantsClass">無料</label></strong>
								</div>
							</div>
						</c:if>
						<c:if test="${orderForm.productSparePantsClass == '0009902'}">
							<div class="row" id="sparePants_div">
								<div class="col col-md-3">
									<label class=" form-control-label">スペアパンツ</label>
								</div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">2パンツ</label></strong>
								</div>
								<div class="col-12 col-md-1" align="right">
									<strong><label class=" form-control-label-value" id="productSparePantsClass_appear"></label></strong>
								</div>
							</div>
						</c:if>
					</c:if>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">生地品番</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.productFabricNo}-${color}${pattern}</label></strong>
						</div>
					</div>
					<c:if test="${orderForm.productCategory == '0'}">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">カテゴリ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">標準</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productCategory == '2'}">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">カテゴリ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">タキシード</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productCategory == '1'}">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">カテゴリ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">ウォッシャブル</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productLcrSewing == '0000000'}">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">LCR縫製</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">無し</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productLcrSewing == '0000001'}">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">LCR縫製</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">有り</label></strong>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ブランドネーム</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.productBrandNm}</label></strong>
						</div>
					</div>
					<c:if test="${orderForm.productFabricNmNecessity == '0'}">
						<div class="row" id="clothName_div">
							<div class="col col-md-3">
								<label class=" form-control-label">生地ネーム</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">無し</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productFabricNmNecessity == '1'}">
						<div class="row" id="clothName_div">
							<div class="col col-md-3">
								<label class=" form-control-label">生地ネーム</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">有り</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productEmbroideryNecessity == '0'}">
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">刺繍入れ</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">無し</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productEmbroideryNecessity == '1'}">
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">刺繍入れ</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">有り</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productEmbroideryNecessity == '1'}">
						<div id="embroidered_yes_area">
							<div class="row">
								<div class="col col-md-3">
									<label class=" form-control-label">刺繍ネーム</label>
								</div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.productEmbroideryNm}</label></strong>
								</div>
							</div>
							<c:if test="${orderForm.productEmbroideryFont == '14（花文字）'}">
								<div class="row">
									<div class="col col-md-3">
										<label class=" form-control-label">刺繍書体</label>
									</div>
									<div class="col-12 col-md-9">
										<strong><label class=" form-control-label-value">14（花文字）</label></strong>
									</div>
								</div>
							</c:if>
							<c:if test="${orderForm.productEmbroideryFont == '48（ブロック）'}">
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
									<strong><label class=" form-control-label-value">${orderForm.productEmbroideryThreadColor}</label></strong>
								</div>
							</div>
							<c:if test="${orderForm.productItem == '05'}">
								<div class="row">
									<div class="col col-md-3">
										<label class=" form-control-label">刺繍箇所</label>
									</div>
									<div class="col-12 col-md-3">
										<strong><label class=" form-control-label-value"></label></strong>
									</div>
								</div>
								<div class="row">
									<div class="col col-md-3">
										<label class=" form-control-label">刺繍サイズ</label>
									</div>
									<div class="col-12 col-md-3">
										<strong><label class=" form-control-label-value"></label></strong>
									</div>
								</div>
								<c:if test="${orderForm.productEmbroideryGazette == '0'}">
									<div class="row">
										<div class="col col-md-3">
											<label class=" form-control-label">ガゼット刺繍</label>
										</div>
										<div class="col-12 col-md-3">
											<strong><label class=" form-control-label-value">無し</label></strong>
										</div>
									</div>
								</c:if>
								<c:if test="${orderForm.productEmbroideryGazette == '1'}">
									<div class="row">
										<div class="col col-md-3">
											<label class=" form-control-label">ガゼット刺繍</label>
										</div>
										<div class="col-12 col-md-3">
											<strong><label class=" form-control-label-value">有り</label></strong>
										</div>
									</div>
								</c:if>
							</c:if>
						</div>
					</c:if>
					<c:if test="${orderForm.productItem != '05'}">
						<c:if test="${orderForm.productRemainingClothType == '01'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">残布</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">小（通常）</label></strong>
								</div>
							</div>
						</c:if>
						<c:if test="${orderForm.productRemainingClothType == '02'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">残布</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">大（タテ15cm×ヨコ15cm）</label></strong>
								</div>
							</div>
						</c:if>
					</c:if>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">生地ブランド</label></div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${orderForm.productFabricBrandNm}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">素材名</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${orderForm.productServiceNm}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">組成表示　表地</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="composFrtFabric">${orderForm.productComposFrtFabric}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">組成表示　胴裏地</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="composBodyLiner"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">組成表示　袖裏地</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.productComposSleeveLiner}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">取扱注意</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.productNotice}</label></strong>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- ITEM End -->
<!-- オプション Start -->
<div class="col-md-12" id="op_jacket_div" style="display:none;">
	<div class="card">
		<div >
			<div class="card-header">
				<strong class="card-title">JACKET</strong>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col col-lg-12">
						<c:if test="${orderForm.productCategory == '0' }">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label"><strong>JACKETモデル</strong></label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojJacketModelMap[orderForm.optionJacketStandardInfo.ojJacketModel]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojJacketModel_appear"></label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">フロント釦数</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojFrontBtnCntMap[orderForm.optionJacketStandardInfo.ojFrontBtnCnt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojFrontBtnCnt_appear">${jacketUpperPrice["ojFrontBtnCntPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojLapelDesignMap[orderForm.optionJacketStandardInfo.ojLapelDesign]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojLapelDesign_appear">${jacketUpperPrice["ojLapelDesignPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">グレード</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojGradeMap[orderForm.optionJacketStandardInfo.ojGrade]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojGrade_appear">${jacketUpperPrice["ojGradePrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">裏仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojGackSpecMap[orderForm.optionJacketStandardInfo.ojGackSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojGackSpec_appear">${jacketUpperPrice["ojGackSpecPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">台場</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojFortMap[orderForm.optionJacketStandardInfo.ojFort]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojFort_appear">${jacketUpperPrice["ojFortPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">襟裏（ヒゲ）</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojBackCollarMap[orderForm.optionJacketStandardInfo.ojBackCollar]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojBackCollar_appear">${jacketUpperPrice["ojBackCollarPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojChainHangeMap[orderForm.optionJacketStandardInfo.ojChainHange]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojChainHange_appear">${jacketUpperPrice["ojChainHangePrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ラペル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojLapelWidthMap[orderForm.optionJacketStandardInfo.ojLapelWidth]}</label></strong>	
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojLapelWidth_appear">${jacketUpperPrice["ojLapelWidthPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">フラワーホール</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojFlowerHoleMap[orderForm.optionJacketStandardInfo.ojFlowerHole]}</label></strong>	
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojFlowerHole_appear">${jacketUpperPrice["ojFlowerHolePrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojBreastPktMap[orderForm.optionJacketStandardInfo.ojBreastPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojBreastPkt_appear">${jacketUpperPrice["ojBreastPktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojWaistPktMap[orderForm.optionJacketStandardInfo.ojWaistPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojWaistPkt_appear">${jacketUpperPrice["ojWaistPktPrice"]}</label></strong>
								</div>
							</div>										
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojChangePktMap[orderForm.optionJacketStandardInfo.ojChangePkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value">${jacketUpperPrice["ojChangePktPrice"]}</label></strong></div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojSlantedPktMap[orderForm.optionJacketStandardInfo.ojSlantedPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojSlantedPkt_appear">${jacketUpperPrice["ojSlantedPktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojCoinPktMap[orderForm.optionJacketStandardInfo.ojCoinPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojCoinPkt_appear">${jacketUpperPrice["ojCoinPktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojSleeveSpecMap[orderForm.optionJacketStandardInfo.ojSleeveSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojSleeveSpec_appear">${jacketUpperPrice["ojSleeveSpecPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">マニカ</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojManicaMap[orderForm.optionJacketStandardInfo.ojManica]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojManica_appear">${jacketUpperPrice["ojManicaPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖釦</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojSleeveBtnTypeMap[orderForm.optionJacketStandardInfo.ojSleeveBtnType]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojSleeveBtnType_appear">無料</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojCuffSpecMap[orderForm.optionJacketStandardInfo.ojCuffSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojCuffSpec_appear">${jacketUpperPrice["ojCuffSpecPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">内ポケット変更</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="ojInsidePktChangeAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojInsidePktChange_appear">無料</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">下前胸内ポケット仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojBreastInnerPktMap[orderForm.optionJacketStandardInfo.ojBreastInnerPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojBreastInnerPkt_appear">${jacketUpperPrice["ojBreastInnerPktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojStitchMap[orderForm.optionJacketStandardInfo.ojStitch]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojStitch_appear">${jacketUpperPrice["ojStitchPrice"]}</label></strong>
								</div>
							</div>
							<c:if test="${orderForm.optionJacketStandardInfo.ojStitch != '0002302'}">
								<div class="row">
									<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
									<div class="col-12 col-md-7">
										<strong><label class=" form-control-label-value" id="ojStitchModifyPlaceAndSubItem"></label></strong>
									</div>
									<div class="col-12 col-md-2 text-right">
										<strong><label class=" form-control-label-value" id="ojStitchModifyPlace_appear">${standardJkUpperCount["ojStitchModifyPlaceMap"]}</label></strong>
									</div>
								</div>
								<div class="row">
									<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ変更</label></div>
									<div class="col-12 col-md-7">
										<strong><label class=" form-control-label-value" id="ojDStitchModifyAndSubItem"></label></strong>
									</div>
									<c:if test="${orderForm.optionJacketStandardInfo.ojDStitchModifyMap[orderForm.optionJacketStandardInfo.ojDStitchModify] == '有り'}">
										<div class="col-12 col-md-2 text-right">
											<strong><label class=" form-control-label-value" id="ojDStitchModify_appear">${jacketUpperPrice["ojDStitchModifyPrice"]}</label></strong>
										</div>
									</c:if>
									<c:if test="${orderForm.optionJacketStandardInfo.ojDStitchModifyMap[orderForm.optionJacketStandardInfo.ojDStitchModify] == '無し'}">
										<div class="col-12 col-md-2 text-right">
											<strong><label class=" form-control-label-value" id="ojDStitchModify_appear">無料</label></strong>
										</div>
									</c:if>
								</div>
								<div class="row">
									<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
									<div class="col-12 col-md-7">
										<strong><label class=" form-control-label-value" id="ojAmfColorAndSubItem"></label></strong>
									</div>
									<div class="col-12 col-md-2 text-right">
										<strong><label class=" form-control-label-value" id="ojAmfColor_appear">${standardJkOjAmfColorUpperCount["ojAmfColorsMap"]}</label></strong>
									</div>
								</div>
							</c:if>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value" id="ojBhColorAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="ojBhColor_appear">${standardJkOjBhColorUpperCount["ojBhColorsMap"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value" id="ojByColorAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="ojByColor_appear">${standardJkOjByColorUpperCount["ojByColorsMap"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojVentSpecMap[orderForm.optionJacketStandardInfo.ojVentSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojVentSpec_appear">${jacketUpperPrice["ojVentSpecPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="ojBodyBackMate_name">${standardJkMateSelectMap["ojBodyBackMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojBodyBackMate_app_appear">${jacketUpperPrice["ojBodyBackMateStkNoPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="ojCuffBackMate_name">${standardJkMateSelectMap["ojCuffBackMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojCuffBackMate_app_appear">${jacketUpperPrice["ojCuffBackMateStkNoPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="ojBtnMate_name">${standardJkMateSelectMap["ojBtnMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojBtnMate_app_appear">${jacketUpperPrice["ojBtnMateStkNoPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojShapeMemoryMap[orderForm.optionJacketStandardInfo.ojShapeMemory]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojShapeMemory_appear">${jacketUpperPrice["ojShapeMemoryPrice"]}</label></strong>
								</div>
							</div>
						</c:if>
						<c:if test="${orderForm.productCategory == '2' }">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label"><strong>JACKETモデル</strong></label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjJacketModelMap[orderForm.optionJacketTuxedoInfo.tjJacketModel]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjJacketModel_appear"></label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">フロント釦数</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjFrontBtnCntMap[orderForm.optionJacketTuxedoInfo.tjFrontBtnCnt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjFrontBtnCnt_appear">${tuxedoJacketUpperPrice["tjFrontBtnCntPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjLapelDesignMap[orderForm.optionJacketTuxedoInfo.tjLapelDesign]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjLapelDesign_appear">${tuxedoJacketUpperPrice["tjLapelDesignPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">グレード</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjGradeMap[orderForm.optionJacketTuxedoInfo.tjGrade]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjGrade_appear">${tuxedoJacketUpperPrice["tjGradePrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">裏仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjBackSpecMap[orderForm.optionJacketTuxedoInfo.tjBackSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjBackSpec_appear">${tuxedoJacketUpperPrice["tjBackSpecPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">台場</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjFortMap[orderForm.optionJacketTuxedoInfo.tjFort]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjFort_appear">${tuxedoJacketUpperPrice["tjFortPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">拝絹地</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjGlossFablicMap[orderForm.optionJacketTuxedoInfo.tjGlossFablic]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjGlossFablic_appear">${tuxedoJacketUpperPrice["tjGlossFablicPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">襟裏（ヒゲ）</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjBackCollarMap[orderForm.optionJacketTuxedoInfo.tjBackCollar]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjBackCollar_appear">${tuxedoJacketUpperPrice["tjBackSpecPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjChainHangeMap[orderForm.optionJacketTuxedoInfo.tjChainHange]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjChainHange_appear">${tuxedoJacketUpperPrice["tjChainHangePrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ラペル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjLapelWidthMap[orderForm.optionJacketTuxedoInfo.tjLapelWidth]}</label></strong>	
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjLapelWidth_appear">${tuxedoJacketUpperPrice["tjLapelWidthPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">フラワーホール</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjFlowerHoleMap[orderForm.optionJacketTuxedoInfo.tjFlowerHole]}</label></strong>	
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjFlowerHole_appear">${tuxedoJacketUpperPrice["tjFlowerHolePrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjBreastPktMap[orderForm.optionJacketTuxedoInfo.tjBreastPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjBreastPkt_appear">${tuxedoJacketUpperPrice["tjBreastPktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjWaistPktMap[orderForm.optionJacketTuxedoInfo.tjWaistPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjWaistPkt_appear">${tuxedoJacketUpperPrice["tjWaistPktPrice"]}</label></strong>
								</div>
							</div>										
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjChangePktMap[orderForm.optionJacketTuxedoInfo.tjChangePkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjChangePkt_appear">${tuxedoJacketUpperPrice["tjChangePktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjSlantedPktMap[orderForm.optionJacketTuxedoInfo.tjSlantedPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjSlantedPkt_appear">${tuxedoJacketUpperPrice["tjSlantedPktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjCoinPktMap[orderForm.optionJacketTuxedoInfo.tjCoinPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjCoinPkt_appear">${tuxedoJacketUpperPrice["tjCoinPktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjSleeveSpecMap[orderForm.optionJacketTuxedoInfo.tjSleeveSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjSleeveSpec_appear">${tuxedoJacketUpperPrice["tjSleeveSpecPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">マニカ</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjManicaMap[orderForm.optionJacketTuxedoInfo.tjManica]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjManica_appear">${tuxedoJacketUpperPrice["tjManicaPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖釦</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjSleeveBtnTypeMap[orderForm.optionJacketTuxedoInfo.tjSleeveBtnType]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjSleeveBtnType_appear">${tuxedoJacketUpperPrice["tjSleeveBtnTypePrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjCuffSpecMap[orderForm.optionJacketTuxedoInfo.tjCuffSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjCuffSpec_appear">${tuxedoJacketUpperPrice["tjCuffSpecPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">内ポケット変更</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjInsidePktChangeMap[orderForm.optionJacketTuxedoInfo.tjInsidePktChange]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjInsidePktChange_appear">${tuxedoJacketUpperPrice["tjInsidePktChangePrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">下前胸内ポケット仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjBreastInnerPktMap[orderForm.optionJacketTuxedoInfo.tjBreastInnerPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjBreastInnerPkt_appear">${tuxedoJacketUpperPrice["tjBreastInnerPktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjStitchMap[orderForm.optionJacketTuxedoInfo.tjStitch]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjStitch_appear">${tuxedoJacketUpperPrice["tjStitchPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${tuxedoServelItemShow["tjBhColorPlaceAndColor"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="tjBhColor_appear">${tuxedoJacketUpperPrice["tjBhColorPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${tuxedoServelItemShow["tjByColorPlaceAndColor"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="tjByColor_appear">${tuxedoJacketUpperPrice["tjByColorPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjVentSpecMap[orderForm.optionJacketTuxedoInfo.tjVentSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjVentSpec_appear">${tuxedoJacketUpperPrice["tjVentSpecPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="tjBodyBackMate_name">${tuxedoJkMateSelectMap["tjBodyBackMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjBodyBackMate_app_appear">${tuxedoJacketUpperPrice["tjBodyBackMateStkNoPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="tjCuffBackMate_name">${tuxedoJkMateSelectMap["tjCuffBackMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojCuffBackMate_app_appear">${tuxedoJacketUpperPrice["tjCuffBackMateStkNoPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="tjBtnMate_name">${tuxedoJkMateSelectMap["tjBtnMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjBtnMate_app_appear">${tuxedoJacketUpperPrice["tjBtnMateStkNoPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketTuxedoInfo.tjShapeMemoryMap[orderForm.optionJacketTuxedoInfo.tjShapeMemory]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjShapeMemory_appear">${tuxedoJacketUpperPrice["tjShapeMemoryPrice"]}</label></strong>
								</div>
							</div>
						</c:if>
						<c:if test="${orderForm.productCategory == '1' }">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label"><strong>JACKETモデル</strong></label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjJacketModelMap[orderForm.optionJacketWashableInfo.wjJacketModel]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjJacketModel_appear"></label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">フロント釦数</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjFrontBtnCntMap[orderForm.optionJacketWashableInfo.wjFrontBtnCnt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjFrontBtnCnt_appear">${washableJacketUpperPrice["wjFrontBtnCntPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjLapelDesignMap[orderForm.optionJacketWashableInfo.wjLapelDesign]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjLapelDesign_appear">${washableJacketUpperPrice["wjLapelDesignPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">グレード</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjGradeMap[orderForm.optionJacketWashableInfo.wjGrade]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjGrade_appear">${washableJacketUpperPrice["wjGradePrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">裏仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjBackSpecMap[orderForm.optionJacketWashableInfo.wjBackSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjBackSpec_appear">${washableJacketUpperPrice["wjBackSpecPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">台場</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjFortMap[orderForm.optionJacketWashableInfo.wjFort]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjFort_appear">${washableJacketUpperPrice["wjFortPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">襟裏（ヒゲ）</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjBackCollarMap[orderForm.optionJacketWashableInfo.wjBackCollar]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjBackCollar_appear">${washableJacketUpperPrice["wjBackCollarPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjChainHangeMap[orderForm.optionJacketWashableInfo.wjChainHange]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjChainHange_appear">${washableJacketUpperPrice["wjChainHangePrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ラペル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjLapelWidthMap[orderForm.optionJacketWashableInfo.wjLapelWidth]}</label></strong>	
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjLapelWidth_appear">${washableJacketUpperPrice["wjLapelWidthPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">フラワーホール</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjFlowerHoleMap[orderForm.optionJacketWashableInfo.wjFlowerHole]}</label></strong>	
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjFlowerHole_appear">${washableJacketUpperPrice["wjFlowerHolePrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjBreastPktMap[orderForm.optionJacketWashableInfo.wjBreastPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjBreastPkt_appear">${washableJacketUpperPrice["wjBreastPktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjWaistPktMap[orderForm.optionJacketWashableInfo.wjWaistPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjWaistPkt_appear">${washableJacketUpperPrice["wjWaistPktPrice"]}</label></strong>
								</div>
							</div>										
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjChangePktMap[orderForm.optionJacketWashableInfo.wjChangePkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjChangePkt_appear">${washableJacketUpperPrice["wjChangePktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjSlantedPktMap[orderForm.optionJacketWashableInfo.wjSlantedPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjSlantedPkt_appear">${washableJacketUpperPrice["wjSlantedPktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjCoinPktMap[orderForm.optionJacketWashableInfo.wjCoinPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjCoinPkt_appear">${washableJacketUpperPrice["wjCoinPktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjSleeveSpecMap[orderForm.optionJacketWashableInfo.wjSleeveSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjSleeveSpec_appear">${washableJacketUpperPrice["wSleeveSpecPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">マニカ</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjManicaMap[orderForm.optionJacketWashableInfo.wjManica]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjManica_appear">${washableJacketUpperPrice["wjManicaPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖釦</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjSleeveBtnTypeMap[orderForm.optionJacketWashableInfo.wjSleeveBtnType]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjSleeveBtnType_appear">${washableJacketUpperPrice["wjSleeveBtnTypePrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjCuffSpecMap[orderForm.optionJacketWashableInfo.wjCuffSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjCuffSpec_appear">${washableJacketUpperPrice["wjCuffSpecPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">内ポケット変更</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjInsidePktChangeMap[orderForm.optionJacketWashableInfo.wjInsidePktChange]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjInsidePktChange_appear">${washableJacketUpperPrice["wjInsidePktChangePrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">下前胸内ポケット仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjBreastInnerPktMap[orderForm.optionJacketWashableInfo.wjBreastInnerPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjBreastInnerPkt_appear">${washableJacketUpperPrice["wjBreastInnerPktPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjStitchMap[orderForm.optionJacketWashableInfo.wjStitch]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjStitch_appear">${washableJacketUpperPrice["wjStitchPrice"]}</label></strong>
								</div>
							</div>
							<c:if test="${orderForm.optionJacketStandardInfo.ojStitch != '0002302'}">
								<div class="row">
									<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
									<div class="col-12 col-md-6">
										<strong><label class=" form-control-label-value">${washableJkServelItemShow["wjStitchModifyPlace"]}</label></strong>
									</div>
									<div class="col-12 col-md-3 text-right">
										<strong><label class=" form-control-label-value" id="wjStitchModifyPlace_appear">${washableJacketUpperPrice["wjStitchModifyPrice"]}</label></strong>
									</div>
								</div>
								<div class="row">
									<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ変更</label></div>
									<div class="col-12 col-md-6">
										<strong><label class=" form-control-label-value">${washableJkServelItemShow["wjDStitchModifyPlace"]}</label></strong>
									</div>
									<div class="col-12 col-md-3 text-right">
										<strong><label class=" form-control-label-value" id="wjDStitchModify_appear">${washableJacketUpperPrice["wjDStitchModifyPrice"]}</label></strong>
									</div>
								</div>
								<div class="row">
									<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
									<div class="col-12 col-md-6">
										<strong><label class=" form-control-label-value">${washableJkServelItemShow["wjAmfColorPlaceAndColor"]}</label></strong>
									</div>
									<div class="col-12 col-md-3 text-right">
										<strong><label class=" form-control-label-value" id="wjAmfColor_appear">${washableJacketUpperPrice["wjAmfColorPrice"]}</label></strong>
									</div>
								</div>
							</c:if>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${washableJkServelItemShow["wjBhColorPlaceAndColor"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="wjBhColor_appear">${washableJacketUpperPrice["wjBhColorPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${washableJkServelItemShow["wjBhColorPlaceAndColor"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="wjByColor_appear">${washableJacketUpperPrice["wjByColorPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjVentSpecMap[orderForm.optionJacketWashableInfo.wjVentSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjVentSpec_appear">${washableJacketUpperPrice["wjVentSpecPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="wjBodyBackMate_name">${washableJkMateSelectMap["wjBodyBackMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjBodyBackMate_app_appear">${washableJacketUpperPrice["wjBodyBackMateStkNoPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="wjCuffBackMate_name">${washableJkMateSelectMap["wjCuffBackMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjCuffBackMate_app_appear">${washableJacketUpperPrice["wjCuffBackMateStkNoPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="wjBtnMate_name">${washableJkMateSelectMap["wjBtnMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjBtnMate_app_appear">${washableJacketUpperPrice["wjBtnMateStkNoPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionJacketWashableInfo.wjShapeMemoryMap[orderForm.optionJacketWashableInfo.wjShapeMemory]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjShapeMemory_appear">${washableJacketUpperPrice["wjShapeMemoryPrice"]}</label></strong>
								</div>
							</div>
						</c:if>
					</div>
				</div>
				<div class="row">　</div>
				<div class="row">
					<div class="col col-lg-12">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>JACKETサイズ</strong></label></div>
							<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.sizeFigure}&nbsp &nbsp &nbsp${orderForm.adjustJacketStandardInfo.sizeNumber}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>JACKET補正</strong></label></div>
							<div class="col-12 col-md-3">
								<label class=" form-control-label">着丈修正</label>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkBodyGross}</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">ウエスト修正</label>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkWaistGross}</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">袖丈右修正</label>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkRightsleeveGross}</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">袖丈左修正</label>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkLeftsleeveGross}</label>cm</strong> 
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">肩パット</label>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkShoulderPad}</label></strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">体型補正</label>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkFigureCorrect}</label></strong>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col col-lg-12">
				<div class="card">
					<div class="card-header">
						<label class=" form-control-label"><strong>店舗補正入力欄</strong></label>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col col-lg-12">
								<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${orderForm.adjustJacketStandardInfo.corJkLeftsleeveCorrectAgainFlag}</textarea>
							</div>	
						</div>
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>
</div>
<!-- オプション スーツEnd -->
<!-- オプション ジレ Start -->
<div class="col-md-12" id="op_gilet_div" style="display:none;">
	<div class="card" id="nav2_alter_div">
		<div class="card-header">
			<strong class="card-title">GILET</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<c:if test="${orderForm.productCategory == '0' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>GILETモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletStandardInfo.ogGiletModelMap[orderForm.optionGiletStandardInfo.ogGiletModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogGiletModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletStandardInfo.ogBreastPktMap[orderForm.optionGiletStandardInfo.ogBreastPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogBreastPkt_appear"></label>${giletUpperPrice["ogBreastPktPrice"]}</strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletStandardInfo.ogWaistPktMap[orderForm.optionGiletStandardInfo.ogWaistPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogWaistPkt_appear">${giletUpperPrice["ogWaistPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット形状</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletStandardInfo.ogWaistPktSpecMap[orderForm.optionGiletStandardInfo.ogWaistPktSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogWaistPktSpec_appear">${giletUpperPrice["ogWaistPktSpecPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ種類 </label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletStandardInfo.ogStitchMap[orderForm.optionGiletStandardInfo.ogStitch]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogStitch_appear">${giletUpperPrice["ogStitchPrice"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderForm.optionGiletStandardInfo.ogStitch != '0000503'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="ogStitchModifyAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ogStitchModify_appear">${standardOgStitchModifyPlaceUpperCount["ogStitchModifyPlaceMap"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="ogDStitchModifyAndSubItem"></label></strong>
								</div>
								<c:if test="${orderForm.optionGiletStandardInfo.ogDStitchModifyMap[orderForm.optionGiletStandardInfo.ogDStitchModify] == '有り'}">
									<div class="col-12 col-md-3 text-right">
										<strong><label class=" form-control-label-value" id="ogDStitchModify_appear">${giletUpperPrice["ogDStitchModifyPrice"]}</label></strong>
									</div>
								</c:if>
								<c:if test="${orderForm.optionGiletStandardInfo.ogDStitchModifyMap[orderForm.optionGiletStandardInfo.ogDStitchModify] == '無し'}">
									<div class="col-12 col-md-3 text-right">
										<strong><label class=" form-control-label-value" id="ogDStitchModify_appear">無料</label></strong>
									</div>
								</c:if>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="ogAmfColorAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ogAmfColor_appear">${standardOgAmfColorUpperCount["ogAmfColorPlaceMap"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="ogBhColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="ogBhColor_appear">${standardOgBhColorUpperCount["ogBhColorsMap"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="ogByColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="ogBhColor_appear">${standardOgByColorUpperCount["ogByColorsMap"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">背裏地素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="ogBackLiningMate_name">${standardGlMateSelectMap["ogBackLiningMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogBackLiningMate_app_appear">${giletUpperPrice["ogBackLiningMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="ogInsideLiningMate_name">${standardGlMateSelectMap["ogInsideLiningMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogInsideLiningMate_app_appear">${giletUpperPrice["ogInsideLiningMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="ogFrontBtnMate_name">${standardGlMateSelectMap["ogFrontBtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogFrontBtnMate_app_appear">${giletUpperPrice["ogFrontBtnMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletStandardInfo.ogBackBeltMap[orderForm.optionGiletStandardInfo.ogBackBelt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogBackBelt_appear">${giletUpperPrice["ogBackBeltPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ウォッチチェーン</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletStandardInfo.ogWatchChainMap[orderForm.optionGiletStandardInfo.ogWatchChain]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogWatchChain_appear">${giletUpperPrice["ogWatchChainPrice"]}</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productCategory == '2'}">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>GILETモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletTuxedoInfo.tgGiletModelMap[orderForm.optionGiletTuxedoInfo.tgGiletModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgGiletModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletTuxedoInfo.tgBreastPktMap[orderForm.optionGiletTuxedoInfo.tgBreastPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgBreastPkt_appear">${tuxedoGiletUpperPrice["tgBreastPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletTuxedoInfo.tgWaistPktMap[orderForm.optionGiletTuxedoInfo.tgWaistPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgWaistPkt_appear">${tuxedoGiletUpperPrice["tgWaistPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット形状</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletTuxedoInfo.tgWaistPktSpecMap[orderForm.optionGiletTuxedoInfo.tgWaistPktSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgWaistPktSpec_appear">${tuxedoGiletUpperPrice["tgWaistPktSpecPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletTuxedoInfo.tgWaistPktMateMap[orderForm.optionGiletTuxedoInfo.tgWaistPktMate]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgWaistPktMate_appear">${tuxedoGiletUpperPrice["tgWaistPktMatePrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ種類 </label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletTuxedoInfo.tgStitchMap[orderForm.optionGiletTuxedoInfo.tgStitch]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgStitch_appear">${tuxedoGiletUpperPrice["tgStitchPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoGlServelItemShow["tgBhColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tgBhColor_appear">${tuxedoGiletUpperPrice["tgBhColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoGlServelItemShow["tgByColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tgBhColor_appear">${tuxedoGiletUpperPrice["tgByColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">背裏地素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="tgBackLiningMate_name">${tuxedoGlMateSelectMap["tgBackLiningMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgBackLiningMate_app_appear">${tuxedoGiletUpperPrice["tgBackLiningMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="tgInsideLiningMate_name">${tuxedoGlMateSelectMap["tgInsideLiningMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgInsideLiningMate_app_appear">${tuxedoGiletUpperPrice["tgInsideLiningMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="tgFrontBtnMate_name">${tuxedoGlMateSelectMap["tgFrontBtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgFrontBtnMate_app_appear">${tuxedoGiletUpperPrice["tgFrontBtnMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletTuxedoInfo.tgBackBeltMap[orderForm.optionGiletTuxedoInfo.tgBackBelt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgBackBelt_appear">${tuxedoGiletUpperPrice["tgBackBeltPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ウォッチチェーン</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletTuxedoInfo.tgWatchChainMap[orderForm.optionGiletTuxedoInfo.tgWatchChain]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgWatchChain_appear">${tuxedoGiletUpperPrice["tgWatchChainPrice"]}</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productCategory == '1' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>GILETモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletWashableInfo.wgGiletModelMap[orderForm.optionGiletWashableInfo.wgGiletModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgGiletModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletWashableInfo.wgBreastPktMap[orderForm.optionGiletWashableInfo.wgBreastPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgBreastPkt_appear">${washableGiletUpperPrice["wgBreastPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletWashableInfo.wgWaistPktMap[orderForm.optionGiletWashableInfo.wgWaistPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgWaistPkt_appear">${washableGiletUpperPrice["wgWaistPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット形状</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletWashableInfo.wgWaistPktSpecMap[orderForm.optionGiletWashableInfo.wgWaistPktSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgWaistPktSpec_appear">${washableGiletUpperPrice["wgWaistPktSpecPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ種類 </label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletWashableInfo.wgStitchMap[orderForm.optionGiletWashableInfo.wgStitch]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgStitch_appear">${washableGiletUpperPrice["wgStitchPrice"]}</label></strong>
							</div>
						</div>
						<c:if test="">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${washableGlServelItemShow["wgStitchModifyPlace"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wgStitchModify_appear">${washableGiletUpperPrice["wgStitchModifyPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${washableGlServelItemShow["wgDStitchModifyPlace"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wgDStitchModify_appear">${washableGiletUpperPrice["wgDStitchModifyPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${washableGlServelItemShow["wgAmfColorPlaceAndColor"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wgAmfColor_appear">${washableGiletUpperPrice["wgAmfColorPrice"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washableGlServelItemShow["wgBhColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wgBhColor_appear">${washableGiletUpperPrice["wgBhColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washableGlServelItemShow["wgByColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wgByColor_appear">${washableGiletUpperPrice["wgByColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">背裏地素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="wgBackLiningMate_name">${washableGlMateSelectMap["wgBackLiningMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgBackLiningMate_app_appear">${washableGiletUpperPrice["wgBackLiningMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="glInnnerCloth_name">${washableGlMateSelectMap["wgInsideLiningMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgInsideLiningMate_app_appear">${washableGiletUpperPrice["wgInsideLiningMatePrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="wgFrontBtnMate_name">${washableGlMateSelectMap["wgFrontBtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgFrontBtnMate_app_appear">${washableGiletUpperPrice["wgFrontBtnMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletWashableInfo.wgBackBeltMap[orderForm.optionGiletWashableInfo.wgBackBelt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgBackBelt_appear">${washableGiletUpperPrice["wgBackBeltPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ウォッチチェーン</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletWashableInfo.wgWatchChainMap[orderForm.optionGiletWashableInfo.wgWatchChain]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgWatchChain_appear">${washableGiletUpperPrice["wgWatchChainPrice"]}</label></strong>
							</div>
						</div>
					</c:if>
				</div>
			</div>　<div class="row">
			</div>
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>GILETサイズ</strong></label></div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustGiletStandardInfo.sizeFigure}&nbsp &nbsp &nbsp${orderForm.adjustGiletStandardInfo.sizeNumber}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>GILET補正</strong></label></div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustGiletStandardInfo.corGlBodyGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">バスト修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustGiletStandardInfo.corGlBustGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustGiletStandardInfo.corGlWaistGross}</label>cm</strong>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
				<div class="col col-lg-12">
				<div class="card">
					<div class="card-header">
						<label class=" form-control-label"><strong>店舗補正入力欄</strong></label>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col col-lg-12">
								<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${orderForm.adjustGiletStandardInfo.corGlStoreCorrectionMemo}</textarea>
							</div>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- オプション ジレ End -->
<!-- PANTS 1 Start -->
<div class="col-md-12" id="op_pants_div" style="display:none;">
	<div class="card">
		<div class="card-header">
			<strong class="card-title">PANTS</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<c:if test="${orderForm.productCategory == '0' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opPantsModelMap[orderForm.optionPantsStandardInfo.opPantsModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opPantsModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opTackMap[orderForm.optionPantsStandardInfo.opTack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opTack_appear">${pantsUpperPrice["opTackPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opKneeBackMap[orderForm.optionPantsStandardInfo.opKneeBack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opKneeBack_appear">${pantsUpperPrice["opKneeBackPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opKneeBackMateMap[orderForm.optionPantsStandardInfo.opKneeBackMate]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opKneeBackMate_appear">${pantsUpperPrice["opKneeBackMatePrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opFrontSpecMap[orderForm.optionPantsStandardInfo.opFrontSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opFrontSpec_appear">${pantsUpperPrice["opFrontSpecPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opPancherinaMap[orderForm.optionPantsStandardInfo.opPancherina]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opPancherina_appear">${pantsUpperPrice["opPancherinaPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opAdjusterMap[orderForm.optionPantsStandardInfo.opAdjuster]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opAdjuster_appear">${pantsUpperPrice["opAdjusterPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="opBeltLoopAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="opBeltLoop_appear">無料</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opPinLoopMap[orderForm.optionPantsStandardInfo.opPinLoop]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opPinLoop_appear">${pantsUpperPrice["opPinLoopPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opSidePktMap[orderForm.optionPantsStandardInfo.opSidePkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opSidePkt_appear">${pantsUpperPrice["opSidePktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opSinobiPktMap[orderForm.optionPantsStandardInfo.opSinobiPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opSinobiPkt_appear">${pantsUpperPrice["opSinobiPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opCoinPktMap[orderForm.optionPantsStandardInfo.opCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opCoinPkt_appear">${pantsUpperPrice["opCoinPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opFlapCoinPktMap[orderForm.optionPantsStandardInfo.opFlapCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opFlapCoinPkt_appear">${pantsUpperPrice["opFlapCoinPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opPisPktUfMap[orderForm.optionPantsStandardInfo.opPisPktUf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opPisPktUf_appear">${pantsUpperPrice["opPisPktUfPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opPisPktDfMap[orderForm.optionPantsStandardInfo.opPisPktDf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opPisPktDf_appear">${pantsUpperPrice["opPisPktDfPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opVCutMap[orderForm.optionPantsStandardInfo.opVCut]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opVCut_appear">${pantsUpperPrice["opVCutPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opHemUpMap[orderForm.optionPantsStandardInfo.opHemUp]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opHemUp_appear">${pantsUpperPrice["opHemUpPrice"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderForm.optionPantsStandardInfo.opHemUp == '0001702' || orderForm.optionPantsStandardInfo.opHemUp == '0001703'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opDoubleWideMap[orderForm.optionPantsStandardInfo.opDoubleWide]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="opDoubleWide_appear">${pantsUpperPrice["opDoubleWidePrice"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">AMFステッチ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opStitchMap[orderForm.optionPantsStandardInfo.opStitch]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opStitch_appear">${pantsUpperPrice["opStitchPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="opStitchModifyAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opStitchModify_appear">${standardOpStitchModifyPlaceUpperCount["opStitchModifyPlaceMap"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="opDStitchAndSubItem"></label></strong>
							</div>
							<c:if test="${orderForm.optionPantsStandardInfo.opDStitchMap[orderForm.optionPantsStandardInfo.opDStitch] == '有り'}">
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="opDStitch_appear">${pantsUpperPrice["opDStitchPrice"]}</label></strong>
								</div>
							</c:if>
							<c:if test="${orderForm.optionPantsStandardInfo.opDStitchMap[orderForm.optionPantsStandardInfo.opDStitch] == '無し'}">
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="opDStitch_appear">無料</label></strong>
								</div>
							</c:if>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="opAmfColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="opAmfColor_appear">${standardOpAmfColorUpperCount["opAmfColorsMap"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="opBhColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="opBhColor_appear">${standardOpBhColorUpperCount["opBhColorsMap"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="opByColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="opByColor_appear">${standardOpByColorUpperCount["opByColorsMap"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="opButton_name">${standardPtMateSelectMap["opBtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opButton_app_appear">${pantsUpperPrice["opBtnMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opSuspenderBtnMap[orderForm.optionPantsStandardInfo.opSuspenderBtn]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opSuspenderBtn_appear">${pantsUpperPrice["opSuspenderBtnPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opThickMap[orderForm.optionPantsStandardInfo.opThick]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opBlister_appear">${pantsUpperPrice["opThickPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opEightMap[orderForm.optionPantsStandardInfo.opEight]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opEight_appear">${pantsUpperPrice["opEightPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opShapeMemoryMap[orderForm.optionPantsStandardInfo.opShapeMemory]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opShapeMemory_appear">${pantsUpperPrice["opShapeMemoryPrice"]}</label></strong>
							</div>
						</div>
					</c:if>
					
					
					<c:if test="${orderForm.productCategory == '2' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpPantsModelMap[orderForm.optionPantsTuxedoInfo.tpPantsModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpPantsModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpTackMap[orderForm.optionPantsTuxedoInfo.tpTack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpTack_appear">${tuxedoPantsUpperPrice["tpTackPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpKneeBackMap[orderForm.optionPantsTuxedoInfo.tpKneeBack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpKneeBack_appear">${tuxedoPantsUpperPrice["tpKneeBackPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpKneeBackMateMap[orderForm.optionPantsTuxedoInfo.tpKneeBackMate]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpKneeBackMate_appear">${tuxedoPantsUpperPrice["tpKneeBackMatePrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpFrontSpecMap[orderForm.optionPantsTuxedoInfo.tpFrontSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpFrontSpec_appear">${tuxedoPantsUpperPrice["tpFrontSpecPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpPancherinaMap[orderForm.optionPantsTuxedoInfo.tpPancherina]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpPancherina_appear">${tuxedoPantsUpperPrice["tpPancherinaPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpAdjusterMap[orderForm.optionPantsTuxedoInfo.tpAdjuster]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpAdjuster_appear">${tuxedoPantsUpperPrice["tpAdjusterPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoPtServelItemShow["tpBeltLoopPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tpBeltLoop_appear">${tuxedoPantsUpperPrice["tpBeltLoopPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpPinLoopMap[orderForm.optionPantsTuxedoInfo.tpPinLoop]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpPinLoop_appear">${tuxedoPantsUpperPrice["tpPinLoopPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpSidePktMap[orderForm.optionPantsTuxedoInfo.tpSidePkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpSidePkt_appear">${tuxedoPantsUpperPrice["tpSidePktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpSinobiPktMap[orderForm.optionPantsTuxedoInfo.tpSinobiPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpSinobiPkt_appear">${tuxedoPantsUpperPrice["tpSinobiPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpCoinPktMap[orderForm.optionPantsTuxedoInfo.tpCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpCoinPkt_appear">${tuxedoPantsUpperPrice["tpCoinPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpFlapCoinPktMap[orderForm.optionPantsTuxedoInfo.tpFlapCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpFlapCoinPkt_appear">${tuxedoPantsUpperPrice["tpFlapCoinPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpPisPktUfMap[orderForm.optionPantsTuxedoInfo.tpPisPktUf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpPisPktUf_appear">${tuxedoPantsUpperPrice["tpPisPktUfPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpPisPktDfMap[orderForm.optionPantsTuxedoInfo.tpPisPktDf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpPisPktDf_appear">${tuxedoPantsUpperPrice["tpPisPktDfPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpVCutMap[orderForm.optionPantsTuxedoInfo.tpVCut]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpVCut_appear">${tuxedoPantsUpperPrice["tpVCutPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpHemUpMap[orderForm.optionPantsTuxedoInfo.tpHemUp]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpHemUp_appear">${tuxedoPantsUpperPrice["tpHemUpPrice"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderForm.optionPantsStandardInfo.opHemUp == '0001702' || orderForm.optionPantsStandardInfo.opHemUp == '0001703'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpDoubleWideMap[orderForm.optionPantsTuxedoInfo.tpDoubleWide]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tpDoubleWide_appear">${tuxedoPantsUpperPrice["tpDoubleWidePrice"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">AMFステッチ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpStitchMap[orderForm.optionPantsTuxedoInfo.tpStitch]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpStitch_appear">${tuxedoPantsUpperPrice["tpStitchPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoPtServelItemShow["tpBhColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tpBhColor_appear">${tuxedoPantsUpperPrice["tpBhColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoPtServelItemShow["tpByColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tpByColor_appear">${tuxedoPantsUpperPrice["tpByColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="tpButton_name">${tuxedoPtMateSelectMap["tpBtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpButton_app_appear">${tuxedoPantsUpperPrice["tpBtnMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpSuspenderBtnMap[orderForm.optionPantsTuxedoInfo.tpSuspenderBtn]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpSuspenderBtn_appear">${tuxedoPantsUpperPrice["tpSuspenderBtnPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpThickMap[orderForm.optionPantsTuxedoInfo.tpThick]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpThick_appear">${tuxedoPantsUpperPrice["tpThickPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpEightMap[orderForm.optionPantsTuxedoInfo.tpEight]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpEight_appear">${tuxedoPantsUpperPrice["tpEightPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpShapeMemoryMap[orderForm.optionPantsTuxedoInfo.tpShapeMemory]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpShapeMemory_appear">${tuxedoPantsUpperPrice["tpShapeMemoryPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">側章</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpSideStripeMap[orderForm.optionPantsTuxedoInfo.tpSideStripe]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpSideStripe_appear">${tuxedoPantsUpperPrice["tpSideStripePrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">側章幅</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsTuxedoInfo.tpSideStripeWidthMap[orderForm.optionPantsTuxedoInfo.tpSideStripeWidth]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpSideStripeWidth_appear">${tuxedoPantsUpperPrice["tpSideStripeWidthPrice"]}</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productCategory == '1' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpPantsModelMap[orderForm.optionPantsWashableInfo.wpPantsModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpPantsModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpTackMap[orderForm.optionPantsWashableInfo.wpTack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpTack_appear">${washablePantsUpperPrice["wpTackPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpKneeBackMap[orderForm.optionPantsWashableInfo.wpKneeBack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpKneeBack_appear">${washablePantsUpperPrice["wpKneeBackPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpKneeBackMateMap[orderForm.optionPantsWashableInfo.wpKneeBackMate]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpKneeBackMate_appear">${washablePantsUpperPrice["wpKneeBackMatePrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpFrontSpecMap[orderForm.optionPantsWashableInfo.wpFrontSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpFrontSpec_appear">${washablePantsUpperPrice["wpFrontSpecPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpPancherinaMap[orderForm.optionPantsWashableInfo.wpPancherina]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpPancherina_appear">${washablePantsUpperPrice["wpPancherinaPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpAdjusterMap[orderForm.optionPantsWashableInfo.wpAdjuster]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpAdjuster_appear">${washablePantsUpperPrice["wpAdjusterPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washablePtServelItemShow["wpBeltLoopPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wpBeltLoop_appear">${washablePantsUpperPrice["wpBeltLoopPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpPinLoopMap[orderForm.optionPantsWashableInfo.wpPinLoop]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpPinLoop_appear">${washablePantsUpperPrice["wpPinLoopPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpSidePktMap[orderForm.optionPantsWashableInfo.wpSidePkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpSidePkt_appear">${washablePantsUpperPrice["wpSidePktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpSinobiPktMap[orderForm.optionPantsWashableInfo.wpSinobiPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpSinobiPkt_appear">${washablePantsUpperPrice["wpSinobiPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpCoinPktMap[orderForm.optionPantsWashableInfo.wpCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpCoinPkt_appear">${washablePantsUpperPrice["wpCoinPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpFlapCoinPktMap[orderForm.optionPantsWashableInfo.wpFlapCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpFlapCoinPkt_appear">${washablePantsUpperPrice["wpFlapCoinPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpPisPktUfMap[orderForm.optionPantsWashableInfo.wpPisPktUf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpPisPktUf_appear">${washablePantsUpperPrice["wpPisPktUfPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpPisPktDfMap[orderForm.optionPantsWashableInfo.wpPisPktDf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpPisPktDf_appear">${washablePantsUpperPrice["wpPisPktDfPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpVCutMap[orderForm.optionPantsWashableInfo.wpVCut]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpVCut_appear">${washablePantsUpperPrice["wpVCutPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpHemUpMap[orderForm.optionPantsWashableInfo.wpHemUp]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpHemUp_appear">${washablePantsUpperPrice["wpHemUpPrice"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderForm.optionPantsStandardInfo.opHemUp == '0001702' || orderForm.optionPantsStandardInfo.opHemUp == '0001703'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpDoubleWideMap[orderForm.optionPantsWashableInfo.wpDoubleWide]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wpDoubleWide_appear">${washablePantsUpperPrice["wpDoubleWidePrice"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">AMFステッチ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpStitchMap[orderForm.optionPantsWashableInfo.wpStitch]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpStitch_appear">${washablePantsUpperPrice["wpStitchPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${washablePtServelItemShow["wpStitchModifyPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpStitchModify_appear">${washablePantsUpperPrice["wpStitchModifyPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${washablePtServelItemShow["wpDStitchPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpDStitch_appear">${washablePantsUpperPrice["wpDStitchPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${washablePtServelItemShow["wpAmfColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpAmfColor_appear">${washablePantsUpperPrice["wpAmfColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washablePtServelItemShow["wpBhColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wpBhColor_appear">${washablePantsUpperPrice["wpBhColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washablePtServelItemShow["wpByColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wpByColor_appear">${washablePantsUpperPrice["wpByColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="wpButton_name">${washablePtMateSelectMap["wpBtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpButton_app_appear">${washablePantsUpperPrice["wpBtnMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpSuspenderBtnMap[orderForm.optionPantsWashableInfo.wpSuspenderBtn]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpSuspenderBtn_appear">${washablePantsUpperPrice["wpSuspenderBtnPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpThickMap[orderForm.optionPantsWashableInfo.wpThick]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpThick_appear">${washablePantsUpperPrice["wpThickPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpEightMap[orderForm.optionPantsWashableInfo.wpEight]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpEight_appear">${washablePantsUpperPrice["wpEightPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsWashableInfo.wpShapeMemoryMap[orderForm.optionPantsWashableInfo.wpShapeMemory]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpShapeMemory_appear">${washablePantsUpperPrice["wpShapeMemoryPrice"]}</label></strong>
							</div>
						</div>
					</c:if>
				</div>
			</div>
			<div class="row">　</div>
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSサイズ</strong></label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.adjustPantsStandardInfo.sizeFigure}&nbsp &nbsp &nbsp${orderForm.adjustPantsStandardInfo.sizeNumber}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>PANTS補正</strong></label></div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustPantsStandardInfo.corPtWaistGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ヒップ修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustPantsStandardInfo.corPtHipGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ワタリ修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustPantsStandardInfo.corPtThighGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">裾幅</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label for="ap_hemWidth_absolute" class="form-check-label ">指定</label></strong>
								<strong><label class=" form-control-label-value">${orderForm.adjustPantsStandardInfo.corPtHemwidthGross}</label>cm</strong>
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
		<div class="row">
				<div class="col col-lg-12">
				<div class="card">
					<div class="card-header">
						<label class=" form-control-label"><strong>店舗補正入力欄</strong></label>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col col-lg-12">
								<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${orderForm.adjustPantsStandardInfo.corPtStoreCorrectionMemo}</textarea>
							</div>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- PANTS 1 End -->
<!-- PANTS 2 Start -->
<div class="col-md-12" id="op2_pants_div" style="display:none;">
	<div class="card">
		<div class="card-header">
			<strong class="card-title">PANTS（2本目）</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<c:if test="${orderForm.productCategory == '0' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2PantsModelMap[orderForm.optionPants2StandardInfo.op2PantsModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2PantsModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2TackMap[orderForm.optionPants2StandardInfo.op2Tack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Tack_appear">${pants2UpperPrice["op2TackPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2KneeBackMap[orderForm.optionPants2StandardInfo.op2KneeBack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2KneeBack_appear">${pants2UpperPrice["op2KneeBackPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2KneeBackMateMap[orderForm.optionPants2StandardInfo.op2KneeBackMate]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2KneeBackMate_appear">${pants2UpperPrice["op2KneeBackMatePrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2FrontSpecMap[orderForm.optionPants2StandardInfo.op2FrontSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2FrontSpec_appear">${pants2UpperPrice["op2FrontSpecPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2PancherinaMap[orderForm.optionPants2StandardInfo.op2Pancherina]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Pancherina_appear">${pants2UpperPrice["op2PancherinaPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2AdjusterMap[orderForm.optionPants2StandardInfo.op2Adjuster]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Adjuster_appear">${pants2UpperPrice["op2AdjusterPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="op2BeltLoopAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="op2BeltLoop_appear">無料</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2PinLoopMap[orderForm.optionPants2StandardInfo.op2PinLoop]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2PinLoop_appear">${pants2UpperPrice["op2PinLoopPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2SidePktMap[orderForm.optionPants2StandardInfo.op2SidePkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2SidePkt_appear">${pants2UpperPrice["op2SidePktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2SinobiPktMap[orderForm.optionPants2StandardInfo.op2SinobiPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2SinobiPkt_appear">${pants2UpperPrice["op2SinobiPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2CoinPktMap[orderForm.optionPants2StandardInfo.op2CoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2CoinPkt_appear">${pants2UpperPrice["op2CoinPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2FlapCoinPktMap[orderForm.optionPants2StandardInfo.op2FlapCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2FlapCoinPkt_appear">${pants2UpperPrice["op2FlapCoinPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2PisPktUfMap[orderForm.optionPants2StandardInfo.op2PisPktUf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2PisPktUf_appear">${pants2UpperPrice["op2PisPktUfPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2PisPktDfMap[orderForm.optionPants2StandardInfo.op2PisPktDf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2PisPktDf_appear">${pants2UpperPrice["op2PisPktDfPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2VCutMap[orderForm.optionPants2StandardInfo.op2VCut]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2VCut_appear">${pants2UpperPrice["op2VCutPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2HemUpMap[orderForm.optionPants2StandardInfo.op2HemUp]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2HemUp_appear">${pants2UpperPrice["op2HemUpPrice"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderForm.optionPants2StandardInfo.op2HemUp == '0001702' || orderForm.optionPants2StandardInfo.op2HemUp == '0001703'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2DoubleWideMap[orderForm.optionPants2StandardInfo.op2DoubleWide]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="op2DoubleWide_appear">${pants2UpperPrice["op2DoubleWidePrice"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">AMFステッチ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2StitchMap[orderForm.optionPants2StandardInfo.op2Stitch]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Stitch_appear">${pants2UpperPrice["op2StitchPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="op2StitchModifyAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2StitchModify_appear">${standardOp2StitchModifyPlaceUpperCount["op2StitchModifyPlaceMap"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="op2DStitchAndSubItem"></label></strong>
							</div>
							<c:if test="${orderForm.optionPants2StandardInfo.op2DStitchMap[orderForm.optionPants2StandardInfo.op2DStitch] == '有り'}">
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="op2DStitch_appear">${pants2UpperPrice["op2DStitchPrice"]}</label></strong>
								</div>
							</c:if>
							<c:if test="${orderForm.optionPants2StandardInfo.op2DStitchMap[orderForm.optionPants2StandardInfo.op2DStitch] == '無し'}">
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="op2DStitch_appear">無料</label></strong>
								</div>
							</c:if>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="op2AmfColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2AmfColor_appear">${standardOp2AmfColorUpperCount["op2AmfColorsMap"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="op2BhColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="op2BhColor_appear">${standardOp2BhColorUpperCount["op2BhColorsMap"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="op2ByColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="op2ByColor_appear">${standardOp2ByColorUpperCount["op2ByColorsMap"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="op2Button_name">${standardPt2MateSelectMap["op2BtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Button_app_appear">${pants2UpperPrice["op2BtnMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2SuspenderBtnMap[orderForm.optionPants2StandardInfo.op2SuspenderBtn]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2SuspenderBtn_appear">${pants2UpperPrice["op2SuspenderBtnPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2ThickMap[orderForm.optionPants2StandardInfo.op2Thick]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Thick_appear">${pants2UpperPrice["op2ThickPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2EightMap[orderForm.optionPants2StandardInfo.op2Eight]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Eight_appear">${pants2UpperPrice["op2EightPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2ShapeMemoryMap[orderForm.optionPants2StandardInfo.op2ShapeMemory]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2ShapeMemory_appear">${pants2UpperPrice["op2ShapeMemoryPrice"]}</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productCategory == '2' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2PantsModelMap[orderForm.optionPants2TuxedoInfo.tp2PantsModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2PantsModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2TackMap[orderForm.optionPants2TuxedoInfo.tp2Tack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2Tack_appear">${tuxedoPants2UpperPrice["tp2TackPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2KneeBackMap[orderForm.optionPants2TuxedoInfo.tp2KneeBack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2KneeBack_appear">${tuxedoPants2UpperPrice["tp2KneeBackPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2KneeBackMateMap[orderForm.optionPants2TuxedoInfo.tp2KneeBackMate]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2KneeBackMate_appear">${tuxedoPants2UpperPrice["tp2KneeBackMatePrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2FrontSpecMap[orderForm.optionPants2TuxedoInfo.tp2FrontSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2FrontSpec_appear">${tuxedoPants2UpperPrice["tp2FrontSpecPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2PancherinaMap[orderForm.optionPants2TuxedoInfo.tp2Pancherina]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2Pancherina_appear">${tuxedoPants2UpperPrice["tp2PancherinaPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2AdjusterMap[orderForm.optionPants2TuxedoInfo.tp2Adjuster]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2Adjuster_appear">${tuxedoPants2UpperPrice["tp2AdjusterPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoPt2ServelItemShow["tp2BeltLoopPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tp2BeltLoop_appear">${tuxedoPants2UpperPrice["tp2BeltLoopPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2PinLoopMap[orderForm.optionPants2TuxedoInfo.tp2PinLoop]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2PinLoop_appear">${tuxedoPants2UpperPrice["tp2PinLoopPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2SidePktMap[orderForm.optionPants2TuxedoInfo.tp2SidePkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2SidePkt_appear">${tuxedoPants2UpperPrice["tp2SidePktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2SinobiPktMap[orderForm.optionPants2TuxedoInfo.tp2SinobiPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2SinobiPkt_appear">${tuxedoPants2UpperPrice["tp2SinobiPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2CoinPktMap[orderForm.optionPants2TuxedoInfo.tp2CoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2CoinPkt_appear">${tuxedoPants2UpperPrice["tp2CoinPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2FlapCoinPktMap[orderForm.optionPants2TuxedoInfo.tp2FlapCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2FlapCoinPkt_appear">${tuxedoPants2UpperPrice["tp2FlapCoinPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2PisPktUfMap[orderForm.optionPants2TuxedoInfo.tp2PisPktUf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2PisPktUf_appear">${tuxedoPants2UpperPrice["tp2PisPktUfPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2PisPktDfMap[orderForm.optionPants2TuxedoInfo.tp2PisPktDf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2PisPktDf_appear">${tuxedoPants2UpperPrice["tp2PisPktDfPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2VCutMap[orderForm.optionPants2TuxedoInfo.tp2VCut]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2VCut_appear">${tuxedoPants2UpperPrice["tp2VCutPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2HemUpMap[orderForm.optionPants2TuxedoInfo.tp2HemUp]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2HemUp_appear">${tuxedoPants2UpperPrice["tp2HemUpPrice"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderForm.optionPants2StandardInfo.op2HemUp == '0001702' || orderForm.optionPants2StandardInfo.op2HemUp == '0001703'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2DoubleWideMap[orderForm.optionPants2TuxedoInfo.tp2DoubleWide]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tp2DoubleWide_appear">${tuxedoPants2UpperPrice["tp2DoubleWidePrice"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">AMFステッチ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2StitchMap[orderForm.optionPants2TuxedoInfo.tp2Stitch]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2Stitch_appear">${tuxedoPants2UpperPrice["tp2StitchPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoPt2ServelItemShow["tp2BhColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tp2BhColor_appear">${tuxedoPants2UpperPrice["tp2BhColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoPt2ServelItemShow["tp2ByColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tp2ByColor_appear">${tuxedoPants2UpperPrice["tp2ByColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="pt2BtnMaterial_name">${tuxedoPt2MateSelectMap["tp2BtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Button_app_appear">${tuxedoPants2UpperPrice["tp2BtnMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2SuspenderBtnMap[orderForm.optionPants2TuxedoInfo.tp2SuspenderBtn]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2SuspenderBtn_appear">${tuxedoPants2UpperPrice["tp2SuspenderBtnPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2ThickMap[orderForm.optionPants2TuxedoInfo.tp2Thick]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2Thick_appear">${tuxedoPants2UpperPrice["tp2ThickPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2EightMap[orderForm.optionPants2TuxedoInfo.tp2Eight]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2Eight_appear">${tuxedoPants2UpperPrice["tp2EightPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2ShapeMemoryMap[orderForm.optionPants2TuxedoInfo.tp2ShapeMemory]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2ShapeMemory_appear">${tuxedoPants2UpperPrice["tp2ShapeMemoryPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">側章</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2SideStripeMap[orderForm.optionPants2TuxedoInfo.tp2SideStripe]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2SideStripe_appear">${tuxedoPants2UpperPrice["tp2SideStripePrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">側章幅</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2TuxedoInfo.tp2SideStripeWidthMap[orderForm.optionPants2TuxedoInfo.tp2SideStripeWidth]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2SideStripeWidth_appear">${tuxedoPants2UpperPrice["tp2SideStripeWidthPrice"]}</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productCategory == '1' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2PantsModelMap[orderForm.optionPants2WashableInfo.wp2PantsModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2PantsModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2TackMap[orderForm.optionPants2WashableInfo.wp2Tack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2Tack_appear">${washablePants2UpperPrice["wp2TackPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2KneeBackMap[orderForm.optionPants2WashableInfo.wp2KneeBack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2KneeBack_appear">${washablePants2UpperPrice["wp2KneeBackPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2KneeBackMateMap[orderForm.optionPants2WashableInfo.wp2KneeBackMate]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2KneeBackMate_appear">${washablePants2UpperPrice["wp2KneeBackMatePrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2FrontSpecMap[orderForm.optionPants2WashableInfo.wp2FrontSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2FrontSpec_appear">${washablePants2UpperPrice["wp2FrontSpecPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2PancherinaMap[orderForm.optionPants2WashableInfo.wp2Pancherina]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2Pancherina_appear">${washablePants2UpperPrice["wp2PancherinaPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2AdjusterMap[orderForm.optionPants2WashableInfo.wp2Adjuster]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2Adjuster_appear">${washablePants2UpperPrice["wp2AdjusterPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washablePt2ServelItemShow["wp2BeltLoopPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wp2BeltLoop_appear">${washablePants2UpperPrice["wp2BeltLoopPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2PinLoopMap[orderForm.optionPants2WashableInfo.wp2PinLoop]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2PinLoop_appear">${washablePants2UpperPrice["wp2PinLoopPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2SidePktMap[orderForm.optionPants2WashableInfo.wp2SidePkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2SidePkt_appear">${washablePants2UpperPrice["wp2SidePktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2SinobiPktMap[orderForm.optionPants2WashableInfo.wp2SinobiPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2SinobiPkt_appear">${washablePants2UpperPrice["wp2SinobiPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2CoinPktMap[orderForm.optionPants2WashableInfo.wp2CoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2CoinPkt_appear">${washablePants2UpperPrice["wp2CoinPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2FlapCoinPktMap[orderForm.optionPants2WashableInfo.wp2FlapCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2FlapCoinPkt_appear">${washablePants2UpperPrice["wp2FlapCoinPktPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2PisPktUfMap[orderForm.optionPants2WashableInfo.wp2PisPktUf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2PisPktUf_appear">${washablePants2UpperPrice["wp2PisPktUfPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2PisPktDfMap[orderForm.optionPants2WashableInfo.wp2PisPktDf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2PisPktDf_appear">${washablePants2UpperPrice["wp2PisPktDfPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2VCutMap[orderForm.optionPants2WashableInfo.wp2VCut]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2VCut_appear">${washablePants2UpperPrice["wp2VCutPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2HemUpMap[orderForm.optionPants2WashableInfo.wp2HemUp]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2HemUp_appear">${washablePants2UpperPrice["wp2HemUpPrice"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderForm.optionPants2StandardInfo.op2HemUp == '0001702' || orderForm.optionPants2StandardInfo.op2HemUp == '0001703'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2DoubleWideMap[orderForm.optionPants2WashableInfo.wp2DoubleWide]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wp2DoubleWide_appear">${washablePants2UpperPrice["wp2DoubleWidePrice"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">AMFステッチ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2StitchMap[orderForm.optionPants2WashableInfo.wp2Stitch]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2Stitch_appear">${washablePants2UpperPrice["wp2StitchPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${washablePt2ServelItemShow["wp2StitchModifyPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2StitchModify_appear">${washablePants2UpperPrice["wp2StitchModifyPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${washablePt2ServelItemShow["wp2DStitchPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2DStitch_appear">${washablePants2UpperPrice["wp2DStitchPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washablePt2ServelItemShow["wp2AmfColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wp2AmfColor_appear">${washablePants2UpperPrice["wp2AmfColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washablePt2ServelItemShow["wp2BhColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wp2BhColor_appear">${washablePants2UpperPrice["wp2BhColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washablePt2ServelItemShow["wp2ByColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wp2ByColor_appear">${washablePants2UpperPrice["wp2ByColorPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="pt2BtnMaterial_name">${washablePt2MateSelectMap["wp2BtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Button_app_appear">${washablePants2UpperPrice["wp2BtnMateStkNoPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2SuspenderBtnMap[orderForm.optionPants2WashableInfo.wp2SuspenderBtn]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2SuspenderBtn_appear">${washablePants2UpperPrice["wp2SuspenderBtnPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2ThickMap[orderForm.optionPants2WashableInfo.wp2Thick]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2Thick_appear">${washablePants2UpperPrice["wp2ThickPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2EightMap[orderForm.optionPants2WashableInfo.wp2Eight]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2Eight_appear">${washablePants2UpperPrice["wp2EightPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2WashableInfo.wp2ShapeMemoryMap[orderForm.optionPants2WashableInfo.wp2ShapeMemory]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2ShapeMemory_appear">${washablePants2UpperPrice["wp2ShapeMemoryPrice"]}</label></strong>
							</div>
						</div>
					</c:if>
				</div>
			</div>
			<div class="row">　</div>
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSサイズ</strong></label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.adjustPants2StandardInfo.sizeFigure}&nbsp &nbsp &nbsp${orderForm.adjustPants2StandardInfo.sizeNumber}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>PANTS補正</strong></label></div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustPants2StandardInfo.corPt2WaistGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ヒップ修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustPants2StandardInfo.corPt2HipGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ワタリ修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustPants2StandardInfo.corPt2ThighGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">裾幅</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label for="ap2_hemWidth_absolute" class="form-check-label "> 指定 </label></strong>
								<strong><label class=" form-control-label-value">${orderForm.adjustPants2StandardInfo.corPt2HemwidthGross}</label>cm</strong>
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
		<div class="row">
				<div class="col col-lg-12">
				<div class="card">
					<div class="card-header">
						<label class=" form-control-label"><strong>店舗補正入力欄</strong></label>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col col-lg-12">
								<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${orderForm.adjustPants2StandardInfo.corPt2StoreCorrectionMemo}</textarea>
							</div>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- PANTS 2 End -->
<!-- SHIRT Start -->
<div class="col-md-12" id="op_shirt_div" style="display:none;">
	<div class="card">
		<div class="card-header">
			<strong class="card-title">SHIRT</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>SHIRTモデル</strong></label></div>
						<div class="col-12 col-md-6">
							<strong><label class="form-control-label-value">${orderForm.optionShirtStandardInfo.osShirtModelMap[orderForm.optionShirtStandardInfo.osShirtModel]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osShirtModel_appear"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">襟型</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osChainModelMap[orderForm.optionShirtStandardInfo.osChainModel]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osChainModel_appear">${shirtUpperPrice["osChainModelPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">カフス</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osCuffsMap[orderForm.optionShirtStandardInfo.osCuffs]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osCuffs_appear">${shirtUpperPrice["osCuffsPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">コンバーチブル</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osConvertibleMap[orderForm.optionShirtStandardInfo.osConvertible]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osConvertible_appear">${shirtUpperPrice["osConvertiblePrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">アジャスト釦</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osAdjustBtnMap[orderForm.optionShirtStandardInfo.osAdjustBtn]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osAdjustBtn_appear">${shirtUpperPrice["osAdjustBtnPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">クレリック仕様</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osClericSpecMap[orderForm.optionShirtStandardInfo.osClericSpec]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osClericSpec_appear">${shirtUpperPrice["osClericSpecPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ダブルカフス仕様</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osDblCuffMap[orderForm.optionShirtStandardInfo.osDblCuff]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osDblCuff_appear">${shirtUpperPrice["osDblCuffPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">カフスボタン追加</label></div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osAddCuffMap[orderForm.optionShirtStandardInfo.osAddCuff]}</label></strong>
						</div>
						<div class="col-12 col-md-1 text-right">
							<strong><label class=" form-control-label-value" id="osAddCuff_appear">${shirtUpperPrice["osAddCuffPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osBtnMateMap[orderForm.optionShirtStandardInfo.osBtnMate]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osBtnMate_appear">${shirtUpperPrice["osBtnMatePrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">タブ釦</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osTabBtnMap[orderForm.optionShirtStandardInfo.osTabBtn]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osTabBtn_appear">${shirtUpperPrice["osTabBtnPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ガントレットボタン位置</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osGaletteBtnPosMap[orderForm.optionShirtStandardInfo.osGaletteBtnPos]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osGaletteBtnPos_appear">${shirtUpperPrice["osGaletteBtnPosPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ピンホールピン</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osPinHolePinMap[orderForm.optionShirtStandardInfo.osPinHolePin]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osPinHolePin_appear">${shirtUpperPrice["osPinHolePinPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osBreastPkMap[orderForm.optionShirtStandardInfo.osBreastPk]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osBreastPk_appear">${shirtUpperPrice["osBreastPkPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">胸ポケット大きさ</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osBreastPkSizeMap[orderForm.optionShirtStandardInfo.osBreastPkSize]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osBreastPkSize_appear">${shirtUpperPrice["osBreastPkSizePrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">フロントデザイン</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osFrontDesignMap[orderForm.optionShirtStandardInfo.osFrontDesign]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osFrontDesign_appear">${shirtUpperPrice["osFrontDesignPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ピンタックブザム</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osPinTackMap[orderForm.optionShirtStandardInfo.osPinTack]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osPinTack_appear">${shirtUpperPrice["osPinTackPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ステッチ</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osStitchMap[orderForm.optionShirtStandardInfo.osStitch]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osStitch_appear">${shirtUpperPrice["osStitchPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">カラーキーパー</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osColorKeeperMap[orderForm.optionShirtStandardInfo.osColorKeeper]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osColorKeeper_appear">${shirtUpperPrice["osColorKeeperPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ボタンホール色変更</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osBhColorMap[orderForm.optionShirtStandardInfo.osBhColor]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osBhColor_appear">${shirtUpperPrice["osBhColorPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸色変更</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osByColorMap[orderForm.optionShirtStandardInfo.osByColor]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osByColor_appear">${shirtUpperPrice["osByColorPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">カジュアルヘムライン仕様</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osCasHemLineMap[orderForm.optionShirtStandardInfo.osCasHemLine]}</label></strong>
						</div>
						<c:if test="${orderForm.optionShirtStandardInfo.osCasHemLineMap[orderForm.optionShirtStandardInfo.osCasHemLine] == '有り'}">
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="osCasHemLine_appear">${shirtUpperPrice["osCasHemLinePrice"]}</label></strong>
							</div>
						</c:if>
						<c:if test="${orderForm.optionShirtStandardInfo.osCasHemLineMap[orderForm.optionShirtStandardInfo.osCasHemLine] == '無し'}">
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="osCasHemLine_appear">無料</label></strong>
							</div>
						</c:if>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ボタン位置変更</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionShirtStandardInfo.osBtnPosChgMap[orderForm.optionShirtStandardInfo.osBtnPosChg]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osBtnPosChg_appear">無料</label></strong>
						</div>
					</div>
				</div>
			</div>
			<div class="row">　</div>
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>SHIRTサイズ</strong></label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.adjustShirtStandardInfo.corStSize}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>SHIRT補正</strong></label></div>
						
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ネック</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustShirtStandardInfo.corStNeckGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustShirtStandardInfo.corStBodylengthGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈右修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustShirtStandardInfo.corStRightsleeveGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈左修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustShirtStandardInfo.corStLeftsleeveGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">背ダーツ詰め</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustShirtStandardInfo.corStBackdartsPackGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">背ダーツ出し</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustShirtStandardInfo.corStBackdartsUnpackGross}</label></strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">カフス周り右</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustShirtStandardInfo.corStRightcuffsSurroundingGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">カフス周り左</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustShirtStandardInfo.corStLeftcuffsSurroundingGross}</label>cm</strong>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
				<div class="col col-lg-12">
				<div class="card">
					<div class="card-header">
						<label class=" form-control-label"><strong>店舗補正入力欄</strong></label>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col col-lg-12">
								<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${orderForm.adjustShirtStandardInfo.corStoreCorrectionMemo}</textarea>
							</div>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- SHIRT End -->
<!-- COAT Start -->
<div class="col-md-12" id="op_coat_div" style="display:none;">
	<div class="card">
		<div class="card-header">
			<strong class="card-title">COAT</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>COATモデル</strong></label></div>
						<div class="col-12 col-md-6">
							<strong><label class="form-control-label-value">${orderForm.optionCoatStandardInfo.coatModelMap[orderForm.optionCoatStandardInfo.coatModel]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="coatModel_appear"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionCoatStandardInfo.ocLapelDesignMap[orderForm.optionCoatStandardInfo.ocLapelDesign]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocLapelDesign_appear">${coatUpperPrice["ocLapelDesignPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionCoatStandardInfo.ocWaistPktMap[orderForm.optionCoatStandardInfo.ocWaistPkt]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocWaistPkt_appear">${coatUpperPrice["ocWaistPktPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionCoatStandardInfo.ocChangePktMap[orderForm.optionCoatStandardInfo.ocChangePkt]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocChangePkt_appear">${coatUpperPrice["ocChangePktPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionCoatStandardInfo.ocSlantedPktMap[orderForm.optionCoatStandardInfo.ocSlantedPkt]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocSlantedPkt_appear">${coatUpperPrice["ocSlantedPktPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionCoatStandardInfo.ocVentSpecMap[orderForm.optionCoatStandardInfo.ocVentSpec]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocVentSpec_appear">${coatUpperPrice["ocVentSpecPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">フロント釦数</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionCoatStandardInfo.ocFrontBtnCntMap[orderForm.optionCoatStandardInfo.ocFrontBtnCnt]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocFrontBtnCnt_appear">${coatUpperPrice["ocFrontBtnCntPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderForm.optionCoatStandardInfo.ocCuffSpecMap[orderForm.optionCoatStandardInfo.ocCuffSpec]}</label></strong>
						</div>
						<div class="col-12 col-md-1 text-right">
							<strong><label class=" form-control-label-value" id="ocCuffSpec_appear">${coatUpperPrice["ocCuffSpecPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">袖釦</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="ocSleeveBtnType_appear">${orderForm.optionCoatStandardInfo.ocSleeveBtnTypeMap[orderForm.optionCoatStandardInfo.ocSleeveBtnType]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value">${coatUpperPrice["ocSleeveBtnTypePrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionCoatStandardInfo.ocBackBeltMap[orderForm.optionCoatStandardInfo.ocBackBelt]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocBackBelt_appear">${coatUpperPrice["ocBackBeltPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.optionCoatStandardInfo.ocChainHangeMap[orderForm.optionCoatStandardInfo.ocChainHange]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocChainHange_appear">${coatUpperPrice["ocChainHangePrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="ocBodyBackMate_name">${standardCtMateSelectMap["ocBodyBackMateStkNo"]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocBodyBackMate_app_appear">${coatUpperPrice["ocBodyBackMateStkNoPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="ocCuffBackMate_name">${standardCtMateSelectMap["ocCuffBackMateStkNo"]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocCuffBackMate_app_appear">${coatUpperPrice["ocCuffBackMateStkNoPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="ocFrontBtnMate_name">${standardCtMateSelectMap["ocFrontBtnMateStkNo"]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocFrontBtnMate_app_appear">${coatUpperPrice["ocFrontBtnMateStkNoPrice"]}</label></strong>
						</div>
					</div>
				</div>
			</div>
			<div class="row">　</div>
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>COATサイズ</strong></label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderForm.adjustCoatStandardInfo.corCtSize}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>COAT補正</strong></label></div>
						
						<div class="col-12 col-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustCoatStandardInfo.corCtBodylengthGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustCoatStandardInfo.corCtWaistGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈右修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustCoatStandardInfo.corCtRightsleeveGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈左修正</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustCoatStandardInfo.corCtLeftsleeveGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ベント修正（高さ）</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustCoatStandardInfo.corCtVenthightGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ポケット位置</label>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderForm.adjustCoatStandardInfo.corCtPktposGross}</label>cm</strong>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
				<div class="col col-lg-12">
				<div class="card">
					<div class="card-header">
						<label class=" form-control-label"><strong>店舗補正入力欄</strong></label>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col col-lg-12">
								<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${orderForm.adjustCoatStandardInfo.corCtStoreCorrectionMemo}</textarea>
							</div>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- COAT End -->
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

<!-- ボタン類 Start -->
<div class="col-md-12">
	<div class="card">
		<div class="row">
			<div class="col-md-12">
				<div class="card-body">
					<div class="row">
						<div class="col col-md-2">　</div>
						<div class="col col-md-4">
							<button type="button" class="btn btn-success btn-block" id="goBack"><i class="fa fa-arrow-left"></i> 戻る</button>
						</div>
						<div class="col col-md-4">
							<button id="coConfirm" type="submit" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i> 確定</button>
						</div>
						<div class="col col-md-2">　</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</form:form>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.validate.unobtrusive.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/main.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/chosen.jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/customer.js"></script>
<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");

//オプション内容の表示
var item = jQuery("#product_item").html();
if (item == "SUIT") {
	jQuery('#op_jacket_div').show();
	jQuery('#op_pants_div').show();
	//３Pieceは有り、スペアパンツは有りの場合
	if("${orderForm.productIs3Piece}" == '0009902' && "${orderForm.productSparePantsClass}" == '0009902'){
		jQuery('#op_jacket_div').show();
		jQuery('#op_gilet_div').show();
		jQuery('#op_pants_div').show();
		jQuery('#op2_pants_div').show();
	}
	//３Pieceは有り、スペアパンツは無しの場合
	else if("${orderForm.productIs3Piece}" == '0009902' && "${orderForm.productSparePantsClass}" == '0009901'){
		jQuery('#op_jacket_div').show();
		jQuery('#op_gilet_div').show();
		jQuery('#op_pants_div').show();
	}
	//３Pieceは無し、スペアパンツは有りの場合
	else if("${orderForm.productIs3Piece}" == '0009901' && "${orderForm.productSparePantsClass}"  == '0009902'){
		jQuery('#op_jacket_div').show();
		jQuery('#op_pants_div').show();
		jQuery('#op2_pants_div').show();
	}
}
//JACKETを表示の場合のみ
else if(item == "JACKET"){
	jQuery('#op_jacket_div').show();
}
//PANTSを表示の場合のみ
else if(item == "PANTS"){
	jQuery('#op_pants_div').show();
}
//GILETを表示の場合のみ
else if(item == "GILET"){
	jQuery('#op_gilet_div').show();
}
//SHIRTを表示の場合のみ
else if(item == "SHIRTS"){
	jQuery('#op_shirt_div').show();
}
//COATを表示の場合のみ
else if(item == "COAT"){
	jQuery('#op_coat_div').show();
}

//TSCステータス
var statusList = {T0:"一時保存",T1:"取り置き",T2:"登録済",T3:"会計済",T4:"商品部承認済",T5:"メーカー承認済",T6:"仕入済",T7:"お渡し済"};
jQuery("#status_appear").html(statusList["${orderForm.status}"]);

//お客様情報_区分の内容表示
var custType = {01:'一般',02:'社着',03:'サンプル',04:'ゲージ',05:'本社内見会',06:'販売会',07:'作り直し'};
jQuery("#cust_type").html(custType[${orderForm.customerMessageInfo.custType}]);

//お客様情報_出荷先の内容表示
var custShippingDestination ={01:'店舗',02:'福山本社',03:'TSC事業本部',04:'お客様',05:'他店舗'};
if("${orderForm.customerMessageInfo.custShippingDestination}" == "05" && "${orderForm.customerMessageInfo.custShippingDestnationOtherstore}" !=""){
	jQuery("#cust_shipping_destination").html(custShippingDestination[${orderForm.customerMessageInfo.custShippingDestination}] + '\xa0\xa0\xa0\xa0\xa0\xa0\xa0' +  "${map[orderForm.customerMessageInfo.custShippingDestnationOtherstore]}" );
}
else{
	jQuery("#cust_shipping_destination").html(custShippingDestination[${orderForm.customerMessageInfo.custShippingDestination}]);	
}

//承り日は現在の日
if("${orderForm.status}" == "" || "${orderForm.status}" == "T0" || "${orderForm.status}" == "T1"){
	var now = new Date();
	var day = ("0" + now.getDate()).slice(-2);
	var month = ("0" + (now.getMonth() + 1)).slice(-2);

	jQuery("#License_day").html(now.getFullYear() + "/" + month + "/" + day);
}
else {
	var productOrderdDate = "${productOrderdDateFormat}";
	jQuery("#License_day").html(dateFormat(productOrderdDate));
}

//お渡し日format
function dateFormat(time) {
	var date = new Date(time);
	var year = date.getFullYear();
	var month = date.getMonth() + 1
	if (month <= 9) {
		month = "0" + month;
	}
	var day = date.getDate();
	if (day <= 9) {
		day = "0" + day;
	}
	return year + "/" + month + "/" + day;
}
//お客様情報_お渡し日
var custShopDeliveryDate = "${orderForm.customerMessageInfo.custShopDeliveryDate}";
if (custShopDeliveryDate != null) {
	jQuery("#cust_shop_delivery_date").html(
			dateFormat(custShopDeliveryDate))
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
var measuringList = ["${orderForm.measuringInfo.fullLength}",
						"${orderForm.measuringInfo.shoulder}",
						"${orderForm.measuringInfo.reachRight}",
						"${orderForm.measuringInfo.reachLeft}",
						"${orderForm.measuringInfo.outBust}",
						"${orderForm.measuringInfo.bust}",
						"${orderForm.measuringInfo.jacketWaist}",
						"${orderForm.measuringInfo.pantsWaist}",
						"${orderForm.measuringInfo.hip}",
						"${orderForm.measuringInfo.spanRight}",
						"${orderForm.measuringInfo.spanLeft}",
						"${orderForm.measuringInfo.calfRight}",
						"${orderForm.measuringInfo.calfLeft}",
						"${orderForm.measuringInfo.neck}"];
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

//組成表示　胴裏地
var result = "${orderForm.productComposBodyLiner}";
if(result.indexOf(" ") != -1 ){
	 var labelArray = new Array();
	 labelArray = result.split(" ");
	 for (i=0; i<labelArray.length; i++ ){
		 jQuery("#composBodyLiner").append(labelArray[i]).append("<Br>");
	 }
}else{
	 jQuery("#composBodyLiner").html(result);
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

//オーダー内容確認画面上部のご請求金額の表示について
jQuery("#header_billingAmount").html(formatMoney("${orderForm.billingAmount}",0,""));
jQuery("#header_consumptionTaxAmount").html(formatMoney("${orderForm.consumptionTaxAmount}",0,""));
jQuery("#header_productPrice").html(formatMoney("${orderForm.productPrice}",0,""));
jQuery("#header_optionPrice").html(formatMoney("${orderForm.optionPrice}",0,""));
jQuery("#header_totalPrice").html(formatMoney("${orderForm.totalPrice}",0,""));

//オーダー内容確認画面下部のご請求金額の表示について
jQuery("#bottom_billingAmount").html(formatMoney("${orderForm.billingAmount}",0,""));
jQuery("#bottom_consumptionTaxAmount").html(formatMoney("${orderForm.consumptionTaxAmount}",0,""));
jQuery("#bottom_productPrice").html(formatMoney("${orderForm.productPrice}",0,""));
jQuery("#bottom_optionPrice").html(formatMoney("${orderForm.optionPrice}",0,""));
jQuery("#bottom_totalPrice").html(formatMoney("${orderForm.totalPrice}",0,""));

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

//pants股下初期値表示
if("${orderForm.adjustPantsStandardInfo.corPtLeftinseamGross }" == '' && "${orderForm.adjustPantsStandardInfo.corPtRightinseamGross }" == ''){
	jQuery("#pantsCorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右 000.0');
	}
else if("${orderForm.adjustPantsStandardInfo.corPtLeftinseamGross }" == '' && "${orderForm.adjustPantsStandardInfo.corPtRightinseamGross }" != ''){
	jQuery("#pantsCorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右 ' + "${orderForm.adjustPantsStandardInfo.corPtRightinseamGross }".TrimStart('0'));
}
else if("${orderForm.adjustPantsStandardInfo.corPtLeftinseamGross }" != '' && "${orderForm.adjustPantsStandardInfo.corPtRightinseamGross }" == ''){
	jQuery("#pantsCorinseamGross" ).html('左 ' +"${orderForm.adjustPantsStandardInfo.corPtLeftinseamGross }".TrimStart('0') + 'cm &nbsp &nbsp &nbsp  右 000.0');
}
else{
	jQuery("#pantsCorinseamGross" ).html('左 ' +"${orderForm.adjustPantsStandardInfo.corPtLeftinseamGross }".TrimStart('0') + 'cm &nbsp &nbsp &nbsp 右 ' + "${orderForm.adjustPantsStandardInfo.corPtRightinseamGross }".TrimStart('0'));
	}

//pants2股下初期値表示
if("${orderForm.adjustPants2StandardInfo.corPt2LeftinseamGross }" == '' && "${orderForm.adjustPants2StandardInfo.corPt2RightinseamGross }" == ''){
	jQuery("#pants2CorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右000.0');
	}
else if("${orderForm.adjustPants2StandardInfo.corPt2LeftinseamGross }" == '' && "${orderForm.adjustPants2StandardInfo.corPt2RightinseamGross }" != ''){
	jQuery("#pants2CorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右 ' + "${orderForm.adjustPants2StandardInfo.corPt2RightinseamGross }".TrimStart('0'));
}
else if("${orderForm.adjustPants2StandardInfo.corPt2LeftinseamGross }" != '' && "${orderForm.adjustPants2StandardInfo.corPt2RightinseamGross }" == ''){
	jQuery("#pants2CorinseamGross" ).html('左 ' +"${orderForm.adjustPants2StandardInfo.corPt2LeftinseamGross }".TrimStart('0') + 'cm &nbsp &nbsp &nbsp 右000.0');
}
else{
	jQuery("#pants2CorinseamGross" ).html('左 ' +"${orderForm.adjustPants2StandardInfo.corPt2LeftinseamGross }".TrimStart('0') + 'cm &nbsp &nbsp &nbsp 右 ' + "${orderForm.adjustPants2StandardInfo.corPt2RightinseamGross }".TrimStart('0'));
	}


//商品情報_ITEM
var itemCode = "${orderForm.productItem}";

//サブアイテムコード
var subItemCode = {SUIT:"01",JACKET:"02",PANTS:"03",GILET:"04",PANTS2:"07",SHIRTS:"05",COAT:"06"};

function isEmpty(parameter){
	if(parameter != null && parameter != ''){
		return true;
	}
	else{
		return false;
	}
}
if("${orderForm.productCategory}" == '0'){
	initStandardComplexOptions();
}
else if("${orderForm.productCategory}" == '2'){
	
}
else if("${orderForm.productCategory}" == '1'){
	
}


function initStandardComplexOptions(){
	//標準JACKETの内ポケット変更
	var ojInsidePktChange = "${orderForm.optionJacketStandardInfo.ojInsidePktChangeMap[orderForm.optionJacketStandardInfo.ojInsidePktChange]}";
	var ojInsidePktPlace1 = "${orderForm.optionJacketStandardInfo.ojInsidePktPlaceMap[orderForm.optionJacketStandardInfo.ojInsidePktPlace1]}";
	var ojInsidePktPlace2 = "${orderForm.optionJacketStandardInfo.ojInsidePktPlaceMap[orderForm.optionJacketStandardInfo.ojInsidePktPlace2]}";
	var ojInsidePktPlace3 = "${orderForm.optionJacketStandardInfo.ojInsidePktPlaceMap[orderForm.optionJacketStandardInfo.ojInsidePktPlace3]}";
	var ojInsidePktPlace4 = "${orderForm.optionJacketStandardInfo.ojInsidePktPlaceMap[orderForm.optionJacketStandardInfo.ojInsidePktPlace4]}";
	var ojInsidePktPlace = '';
	if(isEmpty(ojInsidePktPlace1)){
		ojInsidePktPlace = ojInsidePktPlace + ojInsidePktPlace1 + '　';
	}
	if(isEmpty(ojInsidePktPlace2)){
		ojInsidePktPlace = ojInsidePktPlace + ojInsidePktPlace2 + '　';
	}
	if(isEmpty(ojInsidePktPlace3)){
		ojInsidePktPlace = ojInsidePktPlace + ojInsidePktPlace3 + '　';
	}
	if(isEmpty(ojInsidePktPlace4)){
		ojInsidePktPlace = ojInsidePktPlace + ojInsidePktPlace4;
	}
	jQuery("#ojInsidePktChangeAndSubItem").html(ojInsidePktChange + '　　' + ojInsidePktPlace);

	//標準JACKETのステッチ箇所変更
	var ojStitchModify = "${orderForm.optionJacketStandardInfo.ojStitchModifyMap[orderForm.optionJacketStandardInfo.ojStitchModify]}";
	var ojStitchModifyPlace1 = "${orderForm.optionJacketStandardInfo.ojStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojStitchModifyPlace1]}";
	var ojStitchModifyPlace2 = "${orderForm.optionJacketStandardInfo.ojStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojStitchModifyPlace2]}";
	var ojStitchModifyPlace3 = "${orderForm.optionJacketStandardInfo.ojStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojStitchModifyPlace3]}";
	var ojStitchModifyPlace4 = "${orderForm.optionJacketStandardInfo.ojStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojStitchModifyPlace4]}";
	var ojStitchModifyPlace5 = "${orderForm.optionJacketStandardInfo.ojStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojStitchModifyPlace5]}";
	var ojStitchModifyPlace6 = "${orderForm.optionJacketStandardInfo.ojStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojStitchModifyPlace6]}";
	var ojStitchModifyPlace7 = "${orderForm.optionJacketStandardInfo.ojStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojStitchModifyPlace7]}";
	var ojStitchModifyPlace8 = "${orderForm.optionJacketStandardInfo.ojStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojStitchModifyPlace8]}";
	var ojStitchModifyPlace9 = "${orderForm.optionJacketStandardInfo.ojStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojStitchModifyPlace9]}";
	var ojStitchModifyPlaceList = [ojStitchModifyPlace1,ojStitchModifyPlace2,ojStitchModifyPlace3,ojStitchModifyPlace4,
		ojStitchModifyPlace5,ojStitchModifyPlace6,ojStitchModifyPlace7,ojStitchModifyPlace8,ojStitchModifyPlace9];
	var ojStitchModifyPlace = '';
	for(var i = 0;i < ojStitchModifyPlaceList.length;i++){
		if(isEmpty(ojStitchModifyPlaceList[i])){
			ojStitchModifyPlace = ojStitchModifyPlace + ojStitchModifyPlaceList[i] + '　';
		}
	}
	jQuery("#ojStitchModifyPlaceAndSubItem").html(ojStitchModify + '　　' + ojStitchModifyPlace)

	//標準JACKETのダブルステッチ変更
	var ojDStitchModify = "${orderForm.optionJacketStandardInfo.ojDStitchModifyMap[orderForm.optionJacketStandardInfo.ojDStitchModify]}";
	var ojDStitchModifyPlace1 = "${orderForm.optionJacketStandardInfo.ojDStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojDStitchModifyPlace1]}";
	var ojDStitchModifyPlace2 = "${orderForm.optionJacketStandardInfo.ojDStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojDStitchModifyPlace2]}";
	var ojDStitchModifyPlace3 = "${orderForm.optionJacketStandardInfo.ojDStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojDStitchModifyPlace3]}";
	var ojDStitchModifyPlace4 = "${orderForm.optionJacketStandardInfo.ojDStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojDStitchModifyPlace4]}";
	var ojDStitchModifyPlace5 = "${orderForm.optionJacketStandardInfo.ojDStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojDStitchModifyPlace5]}";
	var ojDStitchModifyPlace6 = "${orderForm.optionJacketStandardInfo.ojDStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojDStitchModifyPlace6]}";
	var ojDStitchModifyPlace7 = "${orderForm.optionJacketStandardInfo.ojDStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojDStitchModifyPlace7]}";
	var ojDStitchModifyPlace8 = "${orderForm.optionJacketStandardInfo.ojDStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojDStitchModifyPlace8]}";
	var ojDStitchModifyPlace9 = "${orderForm.optionJacketStandardInfo.ojDStitchModifyPlaceMap[orderForm.optionJacketStandardInfo.ojDStitchModifyPlace9]}";

	var ojDStitchModifyPlaceList = [ojDStitchModifyPlace1,ojDStitchModifyPlace2,ojDStitchModifyPlace3,ojDStitchModifyPlace4,
		ojDStitchModifyPlace5,ojDStitchModifyPlace6,ojDStitchModifyPlace7,ojDStitchModifyPlace8,ojDStitchModifyPlace9];
	var ojDStitchModifyPlace = '';
	for(var i = 0;i < ojDStitchModifyPlaceList.length;i++){
		if(isEmpty(ojDStitchModifyPlaceList[i])){
			ojDStitchModifyPlace = ojDStitchModifyPlace + ojDStitchModifyPlaceList[i] + '　';
		}
	}
	jQuery("#ojDStitchModifyAndSubItem").html(ojDStitchModify　+ '　　' + ojDStitchModifyPlace);

	//標準JACKETのAMF色指定
	var ojAmfColor = "${orderForm.optionJacketStandardInfo.ojAmfColorMap[orderForm.optionJacketStandardInfo.ojAmfColor]}";
	var ojAmfColorPlace1 = "${orderForm.optionJacketStandardInfo.ojAmfColorPlaceMap[orderForm.optionJacketStandardInfo.ojAmfColorPlace1]}";
	var ojAmfColorPlace2 = "${orderForm.optionJacketStandardInfo.ojAmfColorPlaceMap[orderForm.optionJacketStandardInfo.ojAmfColorPlace2]}";
	var ojAmfColorPlace3 = "${orderForm.optionJacketStandardInfo.ojAmfColorPlaceMap[orderForm.optionJacketStandardInfo.ojAmfColorPlace3]}";
	var ojAmfColorPlace4 = "${orderForm.optionJacketStandardInfo.ojAmfColorPlaceMap[orderForm.optionJacketStandardInfo.ojAmfColorPlace4]}";
	var ojAmfColorPlace5 = "${orderForm.optionJacketStandardInfo.ojAmfColorPlaceMap[orderForm.optionJacketStandardInfo.ojAmfColorPlace5]}";
	var ojAmfColorPlace6 = "${orderForm.optionJacketStandardInfo.ojAmfColorPlaceMap[orderForm.optionJacketStandardInfo.ojAmfColorPlace6]}";
	var ojAmfColorPlace7 = "${orderForm.optionJacketStandardInfo.ojAmfColorPlaceMap[orderForm.optionJacketStandardInfo.ojAmfColorPlace7]}";
	var ojAmfColorPlace8 = "${orderForm.optionJacketStandardInfo.ojAmfColorPlaceMap[orderForm.optionJacketStandardInfo.ojAmfColorPlace8]}";
	var ojAmfColorPlace9 = "${orderForm.optionJacketStandardInfo.ojAmfColorPlaceMap[orderForm.optionJacketStandardInfo.ojAmfColorPlace9]}";
	var ojAmfColor1 = "${orderForm.optionJacketStandardInfo.ojAmfColorsMap[orderForm.optionJacketStandardInfo.ojAmfColor1]}";
	var ojAmfColor2 = "${orderForm.optionJacketStandardInfo.ojAmfColorsMap[orderForm.optionJacketStandardInfo.ojAmfColor2]}";
	var ojAmfColor3 = "${orderForm.optionJacketStandardInfo.ojAmfColorsMap[orderForm.optionJacketStandardInfo.ojAmfColor3]}";
	var ojAmfColor4 = "${orderForm.optionJacketStandardInfo.ojAmfColorsMap[orderForm.optionJacketStandardInfo.ojAmfColor4]}";
	var ojAmfColor5 = "${orderForm.optionJacketStandardInfo.ojAmfColorsMap[orderForm.optionJacketStandardInfo.ojAmfColor5]}";
	var ojAmfColor6 = "${orderForm.optionJacketStandardInfo.ojAmfColorsMap[orderForm.optionJacketStandardInfo.ojAmfColor6]}";
	var ojAmfColor7 = "${orderForm.optionJacketStandardInfo.ojAmfColorsMap[orderForm.optionJacketStandardInfo.ojAmfColor7]}";
	var ojAmfColor8 = "${orderForm.optionJacketStandardInfo.ojAmfColorsMap[orderForm.optionJacketStandardInfo.ojAmfColor8]}";
	var ojAmfColor9 = "${orderForm.optionJacketStandardInfo.ojAmfColorsMap[orderForm.optionJacketStandardInfo.ojAmfColor9]}";

	var ojAmfColorPlaceAndColorList = {
			activeOjAmfColorPlaceAndColor : [{"place":ojAmfColorPlace1,"color":ojAmfColor1},
				{"place":ojAmfColorPlace2,"color":ojAmfColor2},
				{"place":ojAmfColorPlace3,"color":ojAmfColor3},
				{"place":ojAmfColorPlace4,"color":ojAmfColor4},
				{"place":ojAmfColorPlace5,"color":ojAmfColor5},
				{"place":ojAmfColorPlace6,"color":ojAmfColor6},
				{"place":ojAmfColorPlace7,"color":ojAmfColor7},
				{"place":ojAmfColorPlace8,"color":ojAmfColor8},
				{"place":ojAmfColorPlace9,"color":ojAmfColor9}]
	}
	var ojAmfColorPlaceAndColor = '';
	var amfFlag = 0;
	for(var i = 0;i < ojAmfColorPlaceAndColorList.activeOjAmfColorPlaceAndColor.length;i++){
		if(isEmpty(ojAmfColorPlaceAndColorList.activeOjAmfColorPlaceAndColor[i].place) && amfFlag != 3 && amfFlag != 6){
			amfFlag +=1;
			ojAmfColorPlaceAndColor = ojAmfColorPlaceAndColor + ojAmfColorPlaceAndColorList.activeOjAmfColorPlaceAndColor[i].place + '　' + ojAmfColorPlaceAndColorList.activeOjAmfColorPlaceAndColor[i].color
			+ '　　';
		}
		else if(isEmpty(ojAmfColorPlaceAndColorList.activeOjAmfColorPlaceAndColor[i].place) && (amfFlag == 3 || amfFlag == 6)){
			amfFlag +=1;
			ojAmfColorPlaceAndColor = ojAmfColorPlaceAndColor + "\<br\>　　　　" + ojAmfColorPlaceAndColorList.activeOjAmfColorPlaceAndColor[i].place + '　' + ojAmfColorPlaceAndColorList.activeOjAmfColorPlaceAndColor[i].color + '　　';
		}
	}
	jQuery("#ojAmfColorAndSubItem").html(ojAmfColor + '　　'　+ ojAmfColorPlaceAndColor);

	//標準JACKETのボタンホール色指定
	var ojBhColor = "${orderForm.optionJacketStandardInfo.ojBhColorMap[orderForm.optionJacketStandardInfo.ojBhColor]}";

	var ojBhColorPlace1 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace1]}";
	var ojBhColorPlace2 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace2]}";
	var ojBhColorPlace3 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace3]}";
	var ojBhColorPlace4 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace4]}";
	var ojBhColorPlace5 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace5]}";
	var ojBhColorPlace6 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace6]}";
	var ojBhColorPlace7 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace7]}";
	var ojBhColorPlace8 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace8]}";
	var ojBhColorPlace9 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace9]}";
	var ojBhColorPlace10 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace10]}";
	var ojBhColorPlace11 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace11]}";
	var ojBhColorPlace12 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace12]}";
	var ojBhColorPlace13 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace13]}";
	var ojBhColorPlace14 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace14]}";
	var ojBhColorPlace15 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace15]}";
	var ojBhColorPlace16 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace16]}";
	var ojBhColorPlace17 = "${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap[orderForm.optionJacketStandardInfo.ojBhColorPlace17]}";

	var ojBhColor1 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor1]}";
	var ojBhColor2 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor2]}";
	var ojBhColor3 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor3]}";
	var ojBhColor4 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor4]}";
	var ojBhColor5 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor5]}";
	var ojBhColor6 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor6]}";
	var ojBhColor7 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor7]}";
	var ojBhColor8 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor8]}";
	var ojBhColor9 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor9]}";
	var ojBhColor10 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor10]}";
	var ojBhColor11 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor11]}";
	var ojBhColor12 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor12]}";
	var ojBhColor13 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor13]}";
	var ojBhColor14 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor14]}";
	var ojBhColor15 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor15]}";
	var ojBhColor16 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor16]}";
	var ojBhColor17 = "${orderForm.optionJacketStandardInfo.ojBhColorsMap[orderForm.optionJacketStandardInfo.ojBhColor17]}";

	var ojBhColorPlaceAndColorList = {
			activeOjBhColorPlaceAndColor : [{"place":ojBhColorPlace1,"color":ojBhColor1},
				{"place":ojBhColorPlace2,"color":ojBhColor2},
				{"place":ojBhColorPlace3,"color":ojBhColor3},
				{"place":ojBhColorPlace4,"color":ojBhColor4},
				{"place":ojBhColorPlace5,"color":ojBhColor5},
				{"place":ojBhColorPlace6,"color":ojBhColor6},
				{"place":ojBhColorPlace7,"color":ojBhColor7},
				{"place":ojBhColorPlace8,"color":ojBhColor8},
				{"place":ojBhColorPlace9,"color":ojBhColor9},
				{"place":ojBhColorPlace10,"color":ojBhColor10},
				{"place":ojBhColorPlace11,"color":ojBhColor11},
				{"place":ojBhColorPlace12,"color":ojBhColor12},
				{"place":ojBhColorPlace13,"color":ojBhColor13},
				{"place":ojBhColorPlace14,"color":ojBhColor14},
				{"place":ojBhColorPlace15,"color":ojBhColor15},
				{"place":ojBhColorPlace16,"color":ojBhColor16},
				{"place":ojBhColorPlace17,"color":ojBhColor17}]
	}
	var ojBhColorPlaceAndColor = '';
	var bnFlag = 0;
	for(var i = 0;i < ojBhColorPlaceAndColorList.activeOjBhColorPlaceAndColor.length;i++){
		if(isEmpty(ojBhColorPlaceAndColorList.activeOjBhColorPlaceAndColor[i].place) && bnFlag != 3 && bnFlag != 6 && bnFlag != 9 && bnFlag != 12 && bnFlag != 15){
			bnFlag +=1;
			ojBhColorPlaceAndColor = ojBhColorPlaceAndColor + ojBhColorPlaceAndColorList.activeOjBhColorPlaceAndColor[i].place + '　' + ojBhColorPlaceAndColorList.activeOjBhColorPlaceAndColor[i].color
			+ '　　';
		}
		else if(isEmpty(ojBhColorPlaceAndColorList.activeOjBhColorPlaceAndColor[i].place) && (bnFlag == 3 || bnFlag == 6 || bnFlag == 9 || bnFlag == 12 || bnFlag == 15)){
			bnFlag +=1;
			ojBhColorPlaceAndColor = ojBhColorPlaceAndColor + "\<br\>　　　　" + ojBhColorPlaceAndColorList.activeOjBhColorPlaceAndColor[i].place + '　' + ojBhColorPlaceAndColorList.activeOjBhColorPlaceAndColor[i].color + '　　';
		}
	}
	jQuery("#ojBhColorAndSubItem").html(ojBhColor + '　　'　+ ojBhColorPlaceAndColor);
	//標準JACKETのボタン付け糸指定
	var ojByColor = "${orderForm.optionJacketStandardInfo.ojByColorMap[orderForm.optionJacketStandardInfo.ojByColor]}";

	var ojByColorPlace1 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace1]}";
	var ojByColorPlace2 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace2]}";
	var ojByColorPlace3 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace3]}";
	var ojByColorPlace4 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace4]}";
	var ojByColorPlace5 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace5]}";
	var ojByColorPlace6 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace6]}";
	var ojByColorPlace7 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace7]}";
	var ojByColorPlace8 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace8]}";
	var ojByColorPlace9 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace9]}";
	var ojByColorPlace10 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace10]}";
	var ojByColorPlace11 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace11]}";
	var ojByColorPlace12 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace12]}";
	var ojByColorPlace13 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace13]}";
	var ojByColorPlace14 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace14]}";
	var ojByColorPlace15 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace15]}";
	var ojByColorPlace16 = "${orderForm.optionJacketStandardInfo.ojByColorPlaceMap[orderForm.optionJacketStandardInfo.ojByColorPlace16]}";

	var ojByColor1 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor1]}";
	var ojByColor2 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor2]}";
	var ojByColor3 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor3]}";
	var ojByColor4 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor4]}";
	var ojByColor5 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor5]}";
	var ojByColor6 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor6]}";
	var ojByColor7 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor7]}";
	var ojByColor8 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor8]}";
	var ojByColor9 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor9]}";
	var ojByColor10 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor10]}";
	var ojByColor11 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor11]}";
	var ojByColor12 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor12]}";
	var ojByColor13 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor13]}";
	var ojByColor14 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor14]}";
	var ojByColor15 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor15]}";
	var ojByColor16 = "${orderForm.optionJacketStandardInfo.ojByColorsMap[orderForm.optionJacketStandardInfo.ojByColor16]}";

	var ojByColorPlaceAndColorList = {
			activeOjByColorPlaceAndColor : [{"place":ojByColorPlace1,"color":ojByColor1},
				{"place":ojByColorPlace2,"color":ojByColor2},
				{"place":ojByColorPlace3,"color":ojByColor3},
				{"place":ojByColorPlace4,"color":ojByColor4},
				{"place":ojByColorPlace5,"color":ojByColor5},
				{"place":ojByColorPlace6,"color":ojByColor6},
				{"place":ojByColorPlace7,"color":ojByColor7},
				{"place":ojByColorPlace8,"color":ojByColor8},
				{"place":ojByColorPlace9,"color":ojByColor9},
				{"place":ojByColorPlace10,"color":ojByColor10},
				{"place":ojByColorPlace11,"color":ojByColor11},
				{"place":ojByColorPlace12,"color":ojByColor12},
				{"place":ojByColorPlace13,"color":ojByColor13},
				{"place":ojByColorPlace14,"color":ojByColor14},
				{"place":ojByColorPlace15,"color":ojByColor15},
				{"place":ojByColorPlace16,"color":ojByColor16}]
	}
	var ojByColorPlaceAndColor = '';
	var byFlag = 0;
	for(var i = 0;i < ojByColorPlaceAndColorList.activeOjByColorPlaceAndColor.length;i++){
		if(isEmpty(ojByColorPlaceAndColorList.activeOjByColorPlaceAndColor[i].place) && byFlag != 3 && byFlag != 6 && byFlag != 9 && byFlag != 12 && byFlag != 15){
			byFlag +=1;
			ojByColorPlaceAndColor = ojByColorPlaceAndColor + ojByColorPlaceAndColorList.activeOjByColorPlaceAndColor[i].place + '　' + ojByColorPlaceAndColorList.activeOjByColorPlaceAndColor[i].color
			+ '　　';
		}
		else if(isEmpty(ojByColorPlaceAndColorList.activeOjByColorPlaceAndColor[i].place) && (byFlag == 3 || byFlag == 6 || byFlag == 9 || byFlag == 12 || byFlag == 15)){
			byFlag +=1;
			ojByColorPlaceAndColor = ojByColorPlaceAndColor + "\<br\>　　　　" + ojByColorPlaceAndColorList.activeOjByColorPlaceAndColor[i].place + '　' + ojByColorPlaceAndColorList.activeOjByColorPlaceAndColor[i].color + '　　';
		}
	}
	jQuery("#ojByColorAndSubItem").html(ojByColor + '　　' +　ojByColorPlaceAndColor);

	//標準Pantsのベルトループ 
	var opBeltLoop = "${orderForm.optionPantsStandardInfo.opBeltLoopMap[orderForm.optionPantsStandardInfo.opBeltLoop]}";
	var opBeltLoopPlace1 = "${orderForm.optionPantsStandardInfo.opBeltLoopPlaceMap[orderForm.optionPantsStandardInfo.opBeltLoopPlace1]}";
	var opBeltLoopPlace2 = "${orderForm.optionPantsStandardInfo.opBeltLoopPlaceMap[orderForm.optionPantsStandardInfo.opBeltLoopPlace2]}";
	var opBeltLoopPlace3 = "${orderForm.optionPantsStandardInfo.opBeltLoopPlaceMap[orderForm.optionPantsStandardInfo.opBeltLoopPlace3]}";
	var opBeltLoopPlace4 = "${orderForm.optionPantsStandardInfo.opBeltLoopPlaceMap[orderForm.optionPantsStandardInfo.opBeltLoopPlace4]}";
	var opBeltLoopPlace5 = "${orderForm.optionPantsStandardInfo.opBeltLoopPlaceMap[orderForm.optionPantsStandardInfo.opBeltLoopPlace5]}";
	var opBeltLoopPlace6 = "${orderForm.optionPantsStandardInfo.opBeltLoopPlaceMap[orderForm.optionPantsStandardInfo.opBeltLoopPlace6]}";
	var opBeltLoopPlace7 = "${orderForm.optionPantsStandardInfo.opBeltLoopPlaceMap[orderForm.optionPantsStandardInfo.opBeltLoopPlace7]}";

	var opBeltLoopPlaceList = [opBeltLoopPlace1,opBeltLoopPlace2,opBeltLoopPlace3,opBeltLoopPlace4,opBeltLoopPlace5,opBeltLoopPlace6,opBeltLoopPlace7];

	var opBeltLoopPlace = '';
	for(var i = 0;i < opBeltLoopPlaceList.length;i++){
		if(isEmpty(opBeltLoopPlaceList[i])){
			opBeltLoopPlace = opBeltLoopPlace + opBeltLoopPlaceList[i] + '　';
		}
	}
	jQuery("#opBeltLoopAndSubItem").html(opBeltLoop　+ '　' + opBeltLoopPlace);

	//標準Pantsのステッチ箇所変更
	var opStitchModify = "${orderForm.optionPantsStandardInfo.opStitchModifyMap[orderForm.optionPantsStandardInfo.opStitchModify]}";
	var opStitchModifyPlace1 = "${orderForm.optionPantsStandardInfo.opStitchModifyPlaceMap[orderForm.optionPantsStandardInfo.opStitchModifyPlace1]}";
	var opStitchModifyPlace2 = "${orderForm.optionPantsStandardInfo.opStitchModifyPlaceMap[orderForm.optionPantsStandardInfo.opStitchModifyPlace2]}";
	var opStitchModifyPlace3 = "${orderForm.optionPantsStandardInfo.opStitchModifyPlaceMap[orderForm.optionPantsStandardInfo.opStitchModifyPlace3]}";
	var opStitchModifyPlace4 = "${orderForm.optionPantsStandardInfo.opStitchModifyPlaceMap[orderForm.optionPantsStandardInfo.opStitchModifyPlace4]}";

	var opStitchModifyPlaceList = [opStitchModifyPlace1,opStitchModifyPlace2,opStitchModifyPlace3,opStitchModifyPlace4];
	var opStitchModifyPlace = '';
	for(var i = 0;i < opStitchModifyPlaceList.length;i++){
		if(isEmpty(opStitchModifyPlaceList[i])){
			opStitchModifyPlace = opStitchModifyPlace + opStitchModifyPlaceList[i] + '　';
		}
	}
	jQuery("#opStitchModifyAndSubItem").html(opStitchModify + '　　' + opStitchModifyPlace);

	//標準Pantsのダブルステッチ
	var opDStitch = "${orderForm.optionPantsStandardInfo.opDStitchMap[orderForm.optionPantsStandardInfo.opDStitch]}";
	var opDStitchPlace1 = "${orderForm.optionPantsStandardInfo.opDStitchPlaceMap[orderForm.optionPantsStandardInfo.opDStitchPlace1]}";
	var opDStitchPlace2 = "${orderForm.optionPantsStandardInfo.opDStitchPlaceMap[orderForm.optionPantsStandardInfo.opDStitchPlace2]}";
	var opDStitchPlace3 = "${orderForm.optionPantsStandardInfo.opDStitchPlaceMap[orderForm.optionPantsStandardInfo.opDStitchPlace3]}";
	var opDStitchPlace4 = "${orderForm.optionPantsStandardInfo.opDStitchPlaceMap[orderForm.optionPantsStandardInfo.opDStitchPlace4]}";

	var opDStitchPlaceList = [opDStitchPlace1,opDStitchPlace2,opDStitchPlace3,opDStitchPlace4];
	var opDStitchPlace = '';
	for(var i = 0;i < opDStitchPlaceList.length;i++){
		if(isEmpty(opDStitchPlaceList[i])){
			opDStitchPlace = opDStitchPlace + opDStitchPlaceList[i] + '　';
		}
	}
	jQuery("#opDStitchAndSubItem").html(opDStitch + '　　' + opDStitchPlace);

	//標準PantsのAMF色指定
	var opAmfColor = "${orderForm.optionPantsStandardInfo.opAmfColorMap[orderForm.optionPantsStandardInfo.opAmfColor]}";

	var opAmfColorPlace1 = "${orderForm.optionPantsStandardInfo.opAmfColorPlaceMap[orderForm.optionPantsStandardInfo.opAmfColorPlace1]}";
	var opAmfColorPlace2 = "${orderForm.optionPantsStandardInfo.opAmfColorPlaceMap[orderForm.optionPantsStandardInfo.opAmfColorPlace2]}";
	var opAmfColorPlace3 = "${orderForm.optionPantsStandardInfo.opAmfColorPlaceMap[orderForm.optionPantsStandardInfo.opAmfColorPlace3]}";
	var opAmfColorPlace4 = "${orderForm.optionPantsStandardInfo.opAmfColorPlaceMap[orderForm.optionPantsStandardInfo.opAmfColorPlace4]}";

	var opAmfColor1 = "${orderForm.optionPantsStandardInfo.opAmfColorsMap[orderForm.optionPantsStandardInfo.opAmfColor1]}";
	var opAmfColor2 = "${orderForm.optionPantsStandardInfo.opAmfColorsMap[orderForm.optionPantsStandardInfo.opAmfColor2]}";
	var opAmfColor3 = "${orderForm.optionPantsStandardInfo.opAmfColorsMap[orderForm.optionPantsStandardInfo.opAmfColor3]}";
	var opAmfColor4 = "${orderForm.optionPantsStandardInfo.opAmfColorsMap[orderForm.optionPantsStandardInfo.opAmfColor4]}";

	var opAmfColorPlaceAndColorList = {
			activeOpAmfColorPlaceAndColor : [{"place":opAmfColorPlace1,"color":opAmfColor1},
				{"place":opAmfColorPlace2,"color":opAmfColor2},
				{"place":opAmfColorPlace3,"color":opAmfColor3},
				{"place":opAmfColorPlace4,"color":opAmfColor4}]
	};
	var opAmfColorPlaceAndColor = '';
	var opAmfFlag = 0;
	for(var i = 0; i < opAmfColorPlaceAndColorList.activeOpAmfColorPlaceAndColor.length; i++){
		if(isEmpty(opAmfColorPlaceAndColorList.activeOpAmfColorPlaceAndColor[i].place) && opAmfFlag != 3){
			opAmfFlag += 1;
			opAmfColorPlaceAndColor = opAmfColorPlaceAndColor + opAmfColorPlaceAndColorList.activeOpAmfColorPlaceAndColor[i].place + '　' + opAmfColorPlaceAndColorList.activeOpAmfColorPlaceAndColor[i].color
			+ '　　';
		}
		else if(isEmpty(opAmfColorPlaceAndColorList.activeOpAmfColorPlaceAndColor[i].place) && opAmfFlag == 3){
			opAmfFlag += 1;
			opAmfColorPlaceAndColor = opAmfColorPlaceAndColor + "\<br\>　　　　" + opAmfColorPlaceAndColorList.activeOpAmfColorPlaceAndColor[i].place + '　' + opAmfColorPlaceAndColorList.activeOpAmfColorPlaceAndColor[i].color + '　　';
		}
	}
	jQuery("#opAmfColorAndSubItem").html(opAmfColor + '　　'　 + opAmfColorPlaceAndColor);

	//標準Pantsのボタンホール色指定
	var opBhColor = "${orderForm.optionPantsStandardInfo.opBhColorMap[orderForm.optionPantsStandardInfo.opBhColor]}";

	var opBhColorPlace1 = "${orderForm.optionPantsStandardInfo.opBhColorPlaceMap[orderForm.optionPantsStandardInfo.opBhColorPlace1]}";
	var opBhColorPlace2 = "${orderForm.optionPantsStandardInfo.opBhColorPlaceMap[orderForm.optionPantsStandardInfo.opBhColorPlace2]}";
	var opBhColorPlace3 = "${orderForm.optionPantsStandardInfo.opBhColorPlaceMap[orderForm.optionPantsStandardInfo.opBhColorPlace3]}";
	var opBhColorPlace4 = "${orderForm.optionPantsStandardInfo.opBhColorPlaceMap[orderForm.optionPantsStandardInfo.opBhColorPlace4]}";

	var opBhColor1 = "${orderForm.optionPantsStandardInfo.opBhColorsMap[orderForm.optionPantsStandardInfo.opBhColor1]}";
	var opBhColor2 = "${orderForm.optionPantsStandardInfo.opBhColorsMap[orderForm.optionPantsStandardInfo.opBhColor2]}";
	var opBhColor3 = "${orderForm.optionPantsStandardInfo.opBhColorsMap[orderForm.optionPantsStandardInfo.opBhColor3]}";
	var opBhColor4 = "${orderForm.optionPantsStandardInfo.opBhColorsMap[orderForm.optionPantsStandardInfo.opBhColor4]}";

	var opBhColorPlaceAndColorList = {
			activeOpBhColorPlaceAndColor : [{"place":opBhColorPlace1,"color":opBhColor1},
				{"place":opBhColorPlace2,"color":opBhColor2},
				{"place":opBhColorPlace3,"color":opBhColor3},
				{"place":opBhColorPlace4,"color":opBhColor4}]
	};
	var opBhColorPlaceAndColor = '';
	var opBhFlag = 0;
	for(var i =0;i < opBhColorPlaceAndColorList.activeOpBhColorPlaceAndColor.length; i++){
		if(isEmpty(opBhColorPlaceAndColorList.activeOpBhColorPlaceAndColor[i].place) && opBhFlag !=3){
			opBhFlag += 1;
			opBhColorPlaceAndColor = opBhColorPlaceAndColor + opBhColorPlaceAndColorList.activeOpBhColorPlaceAndColor[i].place + '　'　+ opBhColorPlaceAndColorList.activeOpBhColorPlaceAndColor[i].color
			+ '　　';
		}
		else if(isEmpty(opBhColorPlaceAndColorList.activeOpBhColorPlaceAndColor[i].place) && opBhFlag ==3){
			opBhFlag += 1;
			opBhColorPlaceAndColor = opBhColorPlaceAndColor + "\<br\>　　　　" + opBhColorPlaceAndColorList.activeOpBhColorPlaceAndColor[i].place + '　'　+ opBhColorPlaceAndColorList.activeOpBhColorPlaceAndColor[i].color + '　　';
		}
	}
	jQuery("#opBhColorAndSubItem").html(opBhColor + '　　' + opBhColorPlaceAndColor);

	//標準Pantsのボタン付け糸指定
	var opByColor = "${orderForm.optionPantsStandardInfo.opByColorMap[orderForm.optionPantsStandardInfo.opByColor]}";

	var opByColorPlace1 = "${orderForm.optionPantsStandardInfo.opByColorPlaceMap[orderForm.optionPantsStandardInfo.opByColorPlace1]}";
	var opByColorPlace2 = "${orderForm.optionPantsStandardInfo.opByColorPlaceMap[orderForm.optionPantsStandardInfo.opByColorPlace2]}";
	var opByColorPlace3 = "${orderForm.optionPantsStandardInfo.opByColorPlaceMap[orderForm.optionPantsStandardInfo.opByColorPlace3]}";
	var opByColorPlace4 = "${orderForm.optionPantsStandardInfo.opByColorPlaceMap[orderForm.optionPantsStandardInfo.opByColorPlace4]}";

	var opByColor1 = "${orderForm.optionPantsStandardInfo.opByColorsMap[orderForm.optionPantsStandardInfo.opByColor1]}";
	var opByColor2 = "${orderForm.optionPantsStandardInfo.opByColorsMap[orderForm.optionPantsStandardInfo.opByColor2]}";
	var opByColor3 = "${orderForm.optionPantsStandardInfo.opByColorsMap[orderForm.optionPantsStandardInfo.opByColor3]}";
	var opByColor4 = "${orderForm.optionPantsStandardInfo.opByColorsMap[orderForm.optionPantsStandardInfo.opByColor4]}";

	var opByColorPlaceAndColorList = {
			activeOpByColorPlaceAndColor : [{"place":opByColorPlace1,"color":opByColor1},
				{"place":opByColorPlace2,"color":opByColor2},
				{"place":opByColorPlace3,"color":opByColor3},
				{"place":opByColorPlace4,"color":opByColor4}]
	};
	var opByColorPlaceAndColor = '';
	var opByFlag = 0;
	for(var i = 0;i < opByColorPlaceAndColorList.activeOpByColorPlaceAndColor.length;i++){
		if(isEmpty(opByColorPlaceAndColorList.activeOpByColorPlaceAndColor[i].place) && opByFlag != 3){
			opByFlag += 1;
			opByColorPlaceAndColor = opByColorPlaceAndColor + opByColorPlaceAndColorList.activeOpByColorPlaceAndColor[i].place + '　' +  opByColorPlaceAndColorList.activeOpByColorPlaceAndColor[i].color
			+ '　　';
		}
		else if(isEmpty(opByColorPlaceAndColorList.activeOpByColorPlaceAndColor[i].place) && opByFlag == 3){
			opByFlag += 1;
			opByColorPlaceAndColor = opByColorPlaceAndColor + "\<br\>　　　　" + opByColorPlaceAndColorList.activeOpByColorPlaceAndColor[i].place + '　' +  opByColorPlaceAndColorList.activeOpByColorPlaceAndColor[i].color + '　　';
		}
	}
	jQuery("#opByColorAndSubItem").html(opByColor + '　　' +　opByColorPlaceAndColor);

	//標準Giletのステッチ箇所変更
	var ogStitchModify = "${orderForm.optionGiletStandardInfo.ogStitchModifyMap[orderForm.optionGiletStandardInfo.ogStitchModify]}";

	var ogStitchModifyPlace1 = "${orderForm.optionGiletStandardInfo.ogStitchModifyPlaceMap[orderForm.optionGiletStandardInfo.ogStitchModifyPlace1]}";
	var ogStitchModifyPlace2 = "${orderForm.optionGiletStandardInfo.ogStitchModifyPlaceMap[orderForm.optionGiletStandardInfo.ogStitchModifyPlace2]}";
	var ogStitchModifyPlace3 = "${orderForm.optionGiletStandardInfo.ogStitchModifyPlaceMap[orderForm.optionGiletStandardInfo.ogStitchModifyPlace3]}";

	var ogStitchModifyPlaceList = [ogStitchModifyPlace1,ogStitchModifyPlace2,ogStitchModifyPlace3];
	var ogStitchModifyPlace = '';
	for(var i = 0;i < ogStitchModifyPlaceList.length;i++){
		if(isEmpty(ogStitchModifyPlaceList[i])){
			ogStitchModifyPlace = ogStitchModifyPlace + ogStitchModifyPlaceList[i] + '　';
		}
	}
	jQuery("#ogStitchModifyAndSubItem").html(ogStitchModify + '　　' + ogStitchModifyPlace);

	//標準Giletのダブルステッチ
	var ogDStitchModify = "${orderForm.optionGiletStandardInfo.ogDStitchModifyMap[orderForm.optionGiletStandardInfo.ogDStitchModify]}";

	var ogDStitchModifyPlace1 = "${orderForm.optionGiletStandardInfo.ogDStitchModifyPlaceMap[orderForm.optionGiletStandardInfo.ogDStitchModifyPlace1]}";
	var ogDStitchModifyPlace2 = "${orderForm.optionGiletStandardInfo.ogDStitchModifyPlaceMap[orderForm.optionGiletStandardInfo.ogDStitchModifyPlace2]}";
	var ogDStitchModifyPlace3 = "${orderForm.optionGiletStandardInfo.ogDStitchModifyPlaceMap[orderForm.optionGiletStandardInfo.ogDStitchModifyPlace3]}";

	var ogDStitchModifyPlaceList = [ogDStitchModifyPlace1,ogDStitchModifyPlace2,ogDStitchModifyPlace3];
	var ogDStitchModifyPlace = '';
	for(var i =0;i < ogDStitchModifyPlaceList.length;i++){
		if(isEmpty(ogDStitchModifyPlaceList[i])){
			ogDStitchModifyPlace = ogDStitchModifyPlace + ogDStitchModifyPlaceList[i] + '　';
		}
	}
	jQuery("#ogDStitchModifyAndSubItem").html(ogDStitchModify + '　　' + ogDStitchModifyPlace);

	//標準GiletのAMF色指定
	var ogAmfColor = "${orderForm.optionGiletStandardInfo.ogAmfColorMap[orderForm.optionGiletStandardInfo.ogAmfColor]}";

	var ogAmfColorPlace1 = "${orderForm.optionGiletStandardInfo.ogAmfColorPlaceMap[orderForm.optionGiletStandardInfo.ogAmfColorPlace1]}";
	var ogAmfColorPlace2 = "${orderForm.optionGiletStandardInfo.ogAmfColorPlaceMap[orderForm.optionGiletStandardInfo.ogAmfColorPlace2]}";
	var ogAmfColorPlace3 = "${orderForm.optionGiletStandardInfo.ogAmfColorPlaceMap[orderForm.optionGiletStandardInfo.ogAmfColorPlace3]}";

	var ogAmfColor1 = "${orderForm.optionGiletStandardInfo.ogAmfColorsMap[orderForm.optionGiletStandardInfo.ogAmfColor1]}";
	var ogAmfColor2 = "${orderForm.optionGiletStandardInfo.ogAmfColorsMap[orderForm.optionGiletStandardInfo.ogAmfColor2]}";
	var ogAmfColor3 = "${orderForm.optionGiletStandardInfo.ogAmfColorsMap[orderForm.optionGiletStandardInfo.ogAmfColor3]}";

	var ogAmfColorPlaceAndColorList = {
			activeOgAmfColorPlaceAndColor : [{"place":ogAmfColorPlace1,"color":ogAmfColor1},
				{"place":ogAmfColorPlace2,"color":ogAmfColor2},
				{"place":ogAmfColorPlace3,"color":ogAmfColor3}]
	};
	var ogAmfColorPlaceAndColor = '';
	for(var i = 0;i < ogAmfColorPlaceAndColorList.activeOgAmfColorPlaceAndColor.length;i++){
		if(isEmpty(ogAmfColorPlaceAndColorList.activeOgAmfColorPlaceAndColor[i].place)){
			ogAmfColorPlaceAndColor = ogAmfColorPlaceAndColor + ogAmfColorPlaceAndColorList.activeOgAmfColorPlaceAndColor[i].place + '　' + ogAmfColorPlaceAndColorList.activeOgAmfColorPlaceAndColor[i].color + '　　';
		}
	}
	jQuery("#ogAmfColorAndSubItem").html(ogAmfColor + '　　' + ogAmfColorPlaceAndColor);

	//標準Giletのボタンホール色指定
	var ogBhColor = "${orderForm.optionGiletStandardInfo.ogBhColorMap[orderForm.optionGiletStandardInfo.ogBhColor]}";

	var ogBhColorPlace1 = "${orderForm.optionGiletStandardInfo.ogBhColorPlaceMap[orderForm.optionGiletStandardInfo.ogBhColorPlace1]}";
	var ogBhColorPlace2 = "${orderForm.optionGiletStandardInfo.ogBhColorPlaceMap[orderForm.optionGiletStandardInfo.ogBhColorPlace2]}";
	var ogBhColorPlace3 = "${orderForm.optionGiletStandardInfo.ogBhColorPlaceMap[orderForm.optionGiletStandardInfo.ogBhColorPlace3]}";
	var ogBhColorPlace4 = "${orderForm.optionGiletStandardInfo.ogBhColorPlaceMap[orderForm.optionGiletStandardInfo.ogBhColorPlace4]}";
	var ogBhColorPlace5 = "${orderForm.optionGiletStandardInfo.ogBhColorPlaceMap[orderForm.optionGiletStandardInfo.ogBhColorPlace5]}";
	var ogBhColorPlace6 = "${orderForm.optionGiletStandardInfo.ogBhColorPlaceMap[orderForm.optionGiletStandardInfo.ogBhColorPlace6]}";

	var ogBhColor1 = "${orderForm.optionGiletStandardInfo.ogBhColorsMap[orderForm.optionGiletStandardInfo.ogBhColor1]}";
	var ogBhColor2 = "${orderForm.optionGiletStandardInfo.ogBhColorsMap[orderForm.optionGiletStandardInfo.ogBhColor2]}";
	var ogBhColor3 = "${orderForm.optionGiletStandardInfo.ogBhColorsMap[orderForm.optionGiletStandardInfo.ogBhColor3]}";
	var ogBhColor4 = "${orderForm.optionGiletStandardInfo.ogBhColorsMap[orderForm.optionGiletStandardInfo.ogBhColor4]}";
	var ogBhColor5 = "${orderForm.optionGiletStandardInfo.ogBhColorsMap[orderForm.optionGiletStandardInfo.ogBhColor5]}";
	var ogBhColor6 = "${orderForm.optionGiletStandardInfo.ogBhColorsMap[orderForm.optionGiletStandardInfo.ogBhColor6]}";

	var ogBhColorPlaceAndColorList = {
			activeOgBhColorPlaceAndColor : [{"place":ogBhColorPlace1,"color":ogBhColor1},
				{"place":ogBhColorPlace2,"color":ogBhColor2},
				{"place":ogBhColorPlace3,"color":ogBhColor3},
				{"place":ogBhColorPlace4,"color":ogBhColor4},
				{"place":ogBhColorPlace5,"color":ogBhColor5},
				{"place":ogBhColorPlace6,"color":ogBhColor6}]
	};
	var ogBhColorPlaceAndColor = '';
	var ogBhFlag = 0;
	for(var i = 0;i < ogBhColorPlaceAndColorList.activeOgBhColorPlaceAndColor.length;i++){
		if(isEmpty(ogBhColorPlaceAndColorList.activeOgBhColorPlaceAndColor[i].place) && ogBhFlag != 3){
			ogBhFlag += 1;
			ogBhColorPlaceAndColor = ogBhColorPlaceAndColor + ogBhColorPlaceAndColorList.activeOgBhColorPlaceAndColor[i].place + '　' + ogBhColorPlaceAndColorList.activeOgBhColorPlaceAndColor[i].color
			+ '　　';
		}
		else if (isEmpty(ogBhColorPlaceAndColorList.activeOgBhColorPlaceAndColor[i].place) && ogBhFlag == 3){
			ogBhFlag += 1;
			ogBhColorPlaceAndColor = ogBhColorPlaceAndColor + "\<br\>　　　　" + ogBhColorPlaceAndColorList.activeOgBhColorPlaceAndColor[i].place + '　' + ogBhColorPlaceAndColorList.activeOgBhColorPlaceAndColor[i].color + '　　'
			;
		}
	}
	jQuery("#ogBhColorAndSubItem").html(ogBhColor + '　　' + ogBhColorPlaceAndColor);

	//標準Giletのボタン付け糸指定
	var ogByColor = "${orderForm.optionGiletStandardInfo.ogByColorMap[orderForm.optionGiletStandardInfo.ogByColor]}"; 

	var ogByColorPlace1 = "${orderForm.optionGiletStandardInfo.ogByColorPlaceMap[orderForm.optionGiletStandardInfo.ogByColorPlace1]}"; 
	var ogByColorPlace2 = "${orderForm.optionGiletStandardInfo.ogByColorPlaceMap[orderForm.optionGiletStandardInfo.ogByColorPlace2]}"; 
	var ogByColorPlace3 = "${orderForm.optionGiletStandardInfo.ogByColorPlaceMap[orderForm.optionGiletStandardInfo.ogByColorPlace3]}"; 
	var ogByColorPlace4 = "${orderForm.optionGiletStandardInfo.ogByColorPlaceMap[orderForm.optionGiletStandardInfo.ogByColorPlace4]}"; 
	var ogByColorPlace5 = "${orderForm.optionGiletStandardInfo.ogByColorPlaceMap[orderForm.optionGiletStandardInfo.ogByColorPlace5]}"; 
	var ogByColorPlace6 = "${orderForm.optionGiletStandardInfo.ogByColorPlaceMap[orderForm.optionGiletStandardInfo.ogByColorPlace6]}"; 
	var ogByColorPlace7 = "${orderForm.optionGiletStandardInfo.ogByColorPlaceMap[orderForm.optionGiletStandardInfo.ogByColorPlace7]}"; 
	var ogByColorPlace8 = "${orderForm.optionGiletStandardInfo.ogByColorPlaceMap[orderForm.optionGiletStandardInfo.ogByColorPlace8]}"; 
	var ogByColorPlace9 = "${orderForm.optionGiletStandardInfo.ogByColorPlaceMap[orderForm.optionGiletStandardInfo.ogByColorPlace9]}"; 
	var ogByColorPlace10 = "${orderForm.optionGiletStandardInfo.ogByColorPlaceMap[orderForm.optionGiletStandardInfo.ogByColorPlace10]}"; 

	var ogByColor1 = "${orderForm.optionGiletStandardInfo.ogByColorsMap[orderForm.optionGiletStandardInfo.ogByColor1]}"; 
	var ogByColor2 = "${orderForm.optionGiletStandardInfo.ogByColorsMap[orderForm.optionGiletStandardInfo.ogByColor2]}"; 
	var ogByColor3 = "${orderForm.optionGiletStandardInfo.ogByColorsMap[orderForm.optionGiletStandardInfo.ogByColor3]}"; 
	var ogByColor4 = "${orderForm.optionGiletStandardInfo.ogByColorsMap[orderForm.optionGiletStandardInfo.ogByColor4]}"; 
	var ogByColor5 = "${orderForm.optionGiletStandardInfo.ogByColorsMap[orderForm.optionGiletStandardInfo.ogByColor5]}"; 
	var ogByColor6 = "${orderForm.optionGiletStandardInfo.ogByColorsMap[orderForm.optionGiletStandardInfo.ogByColor6]}"; 
	var ogByColor7 = "${orderForm.optionGiletStandardInfo.ogByColorsMap[orderForm.optionGiletStandardInfo.ogByColor7]}"; 
	var ogByColor8 = "${orderForm.optionGiletStandardInfo.ogByColorsMap[orderForm.optionGiletStandardInfo.ogByColor8]}"; 
	var ogByColor9 = "${orderForm.optionGiletStandardInfo.ogByColorsMap[orderForm.optionGiletStandardInfo.ogByColor9]}"; 
	var ogByColor10 = "${orderForm.optionGiletStandardInfo.ogByColorsMap[orderForm.optionGiletStandardInfo.ogByColor10]}"; 

	var ogByColorPlaceAndColorList = {
			activeOgByColorPlaceAndColor : [{"place":ogByColorPlace1,"color":ogByColor1},
				{"place":ogByColorPlace2,"color":ogByColor2},
				{"place":ogByColorPlace3,"color":ogByColor3},
				{"place":ogByColorPlace4,"color":ogByColor4},
				{"place":ogByColorPlace5,"color":ogByColor5},
				{"place":ogByColorPlace6,"color":ogByColor6},
				{"place":ogByColorPlace7,"color":ogByColor7},
				{"place":ogByColorPlace8,"color":ogByColor8},
				{"place":ogByColorPlace9,"color":ogByColor9},
				{"place":ogByColorPlace10,"color":ogByColor10}]
	};
	var ogByColorPlaceAndColor = '';
	var ogByFlag = 0;
	for(var i = 0;i < ogByColorPlaceAndColorList.activeOgByColorPlaceAndColor.length;i++){
		if(isEmpty(ogByColorPlaceAndColorList.activeOgByColorPlaceAndColor[i].place) && ogByFlag != 3 && ogByFlag != 6 && ogByFlag != 9){
			ogByFlag += 1;
			ogByColorPlaceAndColor = ogByColorPlaceAndColor + ogByColorPlaceAndColorList.activeOgByColorPlaceAndColor[i].place + '　' + ogByColorPlaceAndColorList.activeOgByColorPlaceAndColor[i].color
			+ '　　';
		}
		else if(isEmpty(ogByColorPlaceAndColorList.activeOgByColorPlaceAndColor[i].place) && (ogByFlag != 3 || ogByFlag != 6 || ogByFlag != 9)){
			ogByFlag += 1;
			ogByColorPlaceAndColor = ogByColorPlaceAndColor + "\<br\>　　　　" + ogByColorPlaceAndColorList.activeOgByColorPlaceAndColor[i].place + '　' + ogByColorPlaceAndColorList.activeOgByColorPlaceAndColor[i].color + '　　';
		}
	}
	jQuery("#ogByColorAndSubItem").html(ogByColor + '　　' + ogByColorPlaceAndColor);

	//標準2PANTSのベルトループ
	var op2BeltLoop = "${orderForm.optionPants2StandardInfo.op2BeltLoopMap[orderForm.optionPants2StandardInfo.op2BeltLoop]}";

	var op2BeltLoopPlace1 = "${orderForm.optionPants2StandardInfo.op2BeltLoopPlaceMap[orderForm.optionPants2StandardInfo.op2BeltLoopPlace1]}";
	var op2BeltLoopPlace2 = "${orderForm.optionPants2StandardInfo.op2BeltLoopPlaceMap[orderForm.optionPants2StandardInfo.op2BeltLoopPlace2]}";
	var op2BeltLoopPlace3 = "${orderForm.optionPants2StandardInfo.op2BeltLoopPlaceMap[orderForm.optionPants2StandardInfo.op2BeltLoopPlace3]}";
	var op2BeltLoopPlace4 = "${orderForm.optionPants2StandardInfo.op2BeltLoopPlaceMap[orderForm.optionPants2StandardInfo.op2BeltLoopPlace4]}";
	var op2BeltLoopPlace5 = "${orderForm.optionPants2StandardInfo.op2BeltLoopPlaceMap[orderForm.optionPants2StandardInfo.op2BeltLoopPlace5]}";
	var op2BeltLoopPlace6 = "${orderForm.optionPants2StandardInfo.op2BeltLoopPlaceMap[orderForm.optionPants2StandardInfo.op2BeltLoopPlace6]}";
	var op2BeltLoopPlace7 = "${orderForm.optionPants2StandardInfo.op2BeltLoopPlaceMap[orderForm.optionPants2StandardInfo.op2BeltLoopPlace7]}";

	var op2BeltLoopPlaceList = [op2BeltLoopPlace1,op2BeltLoopPlace2,op2BeltLoopPlace3,op2BeltLoopPlace4,op2BeltLoopPlace5,op2BeltLoopPlace6,op2BeltLoopPlace7];
	var op2BeltLoopPlace = '';
	for(var i = 0;i < op2BeltLoopPlaceList.length;i++){
		if(isEmpty(op2BeltLoopPlaceList[i])){
			op2BeltLoopPlace = op2BeltLoopPlace + op2BeltLoopPlaceList[i] + '　';
		}
	}
	jQuery("#op2BeltLoopAndSubItem").html(op2BeltLoop　+ '　　' +　op2BeltLoopPlace);

	//標準2PANTSのステッチ箇所変更
	var op2StitchModify = "${orderForm.optionPants2StandardInfo.op2StitchModifyMap[orderForm.optionPants2StandardInfo.op2StitchModify]}";

	var op2StitchModifyPlace1 = "${orderForm.optionPants2StandardInfo.op2StitchModifyPlaceMap[orderForm.optionPants2StandardInfo.op2StitchModifyPlace1]}";
	var op2StitchModifyPlace2 = "${orderForm.optionPants2StandardInfo.op2StitchModifyPlaceMap[orderForm.optionPants2StandardInfo.op2StitchModifyPlace2]}";
	var op2StitchModifyPlace3 = "${orderForm.optionPants2StandardInfo.op2StitchModifyPlaceMap[orderForm.optionPants2StandardInfo.op2StitchModifyPlace3]}";
	var op2StitchModifyPlace4 = "${orderForm.optionPants2StandardInfo.op2StitchModifyPlaceMap[orderForm.optionPants2StandardInfo.op2StitchModifyPlace4]}";

	var op2StitchModifyPlaceList = [op2StitchModifyPlace1,op2StitchModifyPlace2,op2StitchModifyPlace3,op2StitchModifyPlace4];
	var op2StitchModifyPlace = '';
	for(var i = 0;i < op2StitchModifyPlaceList.length;i++){
		if(isEmpty(op2StitchModifyPlaceList[i])){
			op2StitchModifyPlace = op2StitchModifyPlace + op2StitchModifyPlaceList[i] + '　';
		}
	}
	jQuery("#op2StitchModifyAndSubItem").html(op2StitchModify + '　　' + op2StitchModifyPlace);

	//標準2PANTSのダブルステッチ
	var op2DStitch = "${orderForm.optionPants2StandardInfo.op2DStitchMap[orderForm.optionPants2StandardInfo.op2DStitch]}";

	var op2DStitchPlace1 = "${orderForm.optionPants2StandardInfo.op2DStitchPlaceMap[orderForm.optionPants2StandardInfo.op2DStitchPlace1]}";
	var op2DStitchPlace2 = "${orderForm.optionPants2StandardInfo.op2DStitchPlaceMap[orderForm.optionPants2StandardInfo.op2DStitchPlace2]}";
	var op2DStitchPlace3 = "${orderForm.optionPants2StandardInfo.op2DStitchPlaceMap[orderForm.optionPants2StandardInfo.op2DStitchPlace3]}";
	var op2DStitchPlace4 = "${orderForm.optionPants2StandardInfo.op2DStitchPlaceMap[orderForm.optionPants2StandardInfo.op2DStitchPlace4]}";

	var op2DStitchPlaceList = [op2DStitchPlace1,op2DStitchPlace2,op2DStitchPlace3,op2DStitchPlace4];
	var op2DStitchPlace = '';
	for(var i =0;i < op2DStitchPlaceList.length;i++){
		if(isEmpty(op2DStitchPlaceList[i])){
			op2DStitchPlace = op2DStitchPlace + op2DStitchPlaceList[i] + '　';
		}
	}
	jQuery("#op2DStitchAndSubItem").html(op2DStitch + '　　' + op2DStitchPlace);

	//標準2PANTSのAMF色指定
	var op2AmfColor = "${orderForm.optionPants2StandardInfo.op2AmfColorMap[orderForm.optionPants2StandardInfo.op2AmfColor]}";

	var op2AmfColorPlace1 = "${orderForm.optionPants2StandardInfo.op2AmfColorPlaceMap[orderForm.optionPants2StandardInfo.op2AmfColorPlace1]}";
	var op2AmfColorPlace2 = "${orderForm.optionPants2StandardInfo.op2AmfColorPlaceMap[orderForm.optionPants2StandardInfo.op2AmfColorPlace2]}";
	var op2AmfColorPlace3 = "${orderForm.optionPants2StandardInfo.op2AmfColorPlaceMap[orderForm.optionPants2StandardInfo.op2AmfColorPlace3]}";
	var op2AmfColorPlace4 = "${orderForm.optionPants2StandardInfo.op2AmfColorPlaceMap[orderForm.optionPants2StandardInfo.op2AmfColorPlace4]}";

	var op2AmfColor1 = "${orderForm.optionPants2StandardInfo.op2AmfColorsMap[orderForm.optionPants2StandardInfo.op2AmfColor1]}";
	var op2AmfColor2 = "${orderForm.optionPants2StandardInfo.op2AmfColorsMap[orderForm.optionPants2StandardInfo.op2AmfColor2]}";
	var op2AmfColor3 = "${orderForm.optionPants2StandardInfo.op2AmfColorsMap[orderForm.optionPants2StandardInfo.op2AmfColor3]}";
	var op2AmfColor4 = "${orderForm.optionPants2StandardInfo.op2AmfColorsMap[orderForm.optionPants2StandardInfo.op2AmfColor4]}";

	var op2AmfColorPlaceAndColorList = {
			activeOp2AmfColorPlaceAndColor : [{"place":op2AmfColorPlace1,"color":op2AmfColor1},
				{"place":op2AmfColorPlace2,"color":op2AmfColor2},
				{"place":op2AmfColorPlace3,"color":op2AmfColor3},
				{"place":op2AmfColorPlace4,"color":op2AmfColor4}]
	};
	var op2AmfColorPlaceAndColor = '';
	var op2AmfFlag = 0;
	for(var i = 0;i < op2AmfColorPlaceAndColorList.activeOp2AmfColorPlaceAndColor.length;i++){
		if(isEmpty(op2AmfColorPlaceAndColorList.activeOp2AmfColorPlaceAndColor[i].place)　&& op2AmfFlag != 3){
			op2AmfFlag += 1;
			op2AmfColorPlaceAndColor = op2AmfColorPlaceAndColor + op2AmfColorPlaceAndColorList.activeOp2AmfColorPlaceAndColor[i].place + '　' + op2AmfColorPlaceAndColorList.activeOp2AmfColorPlaceAndColor[i].color
			+ '　　';
		}
		else if(isEmpty(op2AmfColorPlaceAndColorList.activeOp2AmfColorPlaceAndColor[i].place)　&& op2AmfFlag == 3){
			op2AmfFlag += 1;
			op2AmfColorPlaceAndColor = op2AmfColorPlaceAndColor + "\<br\>　　　　" + op2AmfColorPlaceAndColorList.activeOp2AmfColorPlaceAndColor[i].place + '　' + op2AmfColorPlaceAndColorList.activeOp2AmfColorPlaceAndColor[i].color + '　　';
		}
	}
	jQuery("#op2AmfColorAndSubItem").html(op2AmfColor + '　　' + op2AmfColorPlaceAndColor);

	//標準2PANTSのボタンホール色指定
	var op2BhColor = "${orderForm.optionPants2StandardInfo.op2BhColorMap[orderForm.optionPants2StandardInfo.op2BhColor]}";

	var op2BhColorPlace1 = "${orderForm.optionPants2StandardInfo.op2BhColorPlaceMap[orderForm.optionPants2StandardInfo.op2BhColorPlace1]}";
	var op2BhColorPlace2 = "${orderForm.optionPants2StandardInfo.op2BhColorPlaceMap[orderForm.optionPants2StandardInfo.op2BhColorPlace2]}";
	var op2BhColorPlace3 = "${orderForm.optionPants2StandardInfo.op2BhColorPlaceMap[orderForm.optionPants2StandardInfo.op2BhColorPlace3]}";
	var op2BhColorPlace4 = "${orderForm.optionPants2StandardInfo.op2BhColorPlaceMap[orderForm.optionPants2StandardInfo.op2BhColorPlace4]}";

	var op2BhColor1 = "${orderForm.optionPants2StandardInfo.op2BhColorsMap[orderForm.optionPants2StandardInfo.op2BhColor1]}";
	var op2BhColor2 = "${orderForm.optionPants2StandardInfo.op2BhColorsMap[orderForm.optionPants2StandardInfo.op2BhColor2]}";
	var op2BhColor3 = "${orderForm.optionPants2StandardInfo.op2BhColorsMap[orderForm.optionPants2StandardInfo.op2BhColor3]}";
	var op2BhColor4 = "${orderForm.optionPants2StandardInfo.op2BhColorsMap[orderForm.optionPants2StandardInfo.op2BhColor4]}";

	var op2BhColorPlaceAndColorList = {
		activeOp2BhColorPlaceAndColor : [{"place":op2BhColorPlace1,"color":op2BhColor1},
			{"place":op2BhColorPlace2,"color":op2BhColor2},
			{"place":op2BhColorPlace3,"color":op2BhColor3},
			{"place":op2BhColorPlace4,"color":op2BhColor4}]
	};
	var op2BhColorPlaceAndColor = '';
	var op2BhFlag = 0;
	for(var i = 0;i < op2BhColorPlaceAndColorList.activeOp2BhColorPlaceAndColor.length;i++){
		if(isEmpty(op2BhColorPlaceAndColorList.activeOp2BhColorPlaceAndColor[i].place) && op2BhFlag != 3){
			op2BhFlag　+= 1;
			op2BhColorPlaceAndColor = op2BhColorPlaceAndColor + op2BhColorPlaceAndColorList.activeOp2BhColorPlaceAndColor[i].place + '　' + op2BhColorPlaceAndColorList.activeOp2BhColorPlaceAndColor[i].color
			+ '　　'; 
		}
		else if(isEmpty(op2BhColorPlaceAndColorList.activeOp2BhColorPlaceAndColor[i].place) && op2BhFlag == 3){
			op2BhFlag　+= 1;
			op2BhColorPlaceAndColor = op2BhColorPlaceAndColor + "\<br\>　　　　" + op2BhColorPlaceAndColorList.activeOp2BhColorPlaceAndColor[i].place + '　' + op2BhColorPlaceAndColorList.activeOp2BhColorPlaceAndColor[i].color + '　　'; 
		}
	}
	jQuery("#op2BhColorAndSubItem").html(op2BhColor + '　　' + op2BhColorPlaceAndColor);

	//標準2PANTSのボタン付け糸指定
	var op2ByColor = "${orderForm.optionPants2StandardInfo.op2ByColorMap[orderForm.optionPants2StandardInfo.op2ByColor]}";

	var op2ByColorPlace1 = "${orderForm.optionPants2StandardInfo.op2ByColorPlaceMap[orderForm.optionPants2StandardInfo.op2ByColorPlace1]}";
	var op2ByColorPlace2 = "${orderForm.optionPants2StandardInfo.op2ByColorPlaceMap[orderForm.optionPants2StandardInfo.op2ByColorPlace2]}";
	var op2ByColorPlace3 = "${orderForm.optionPants2StandardInfo.op2ByColorPlaceMap[orderForm.optionPants2StandardInfo.op2ByColorPlace3]}";
	var op2ByColorPlace4 = "${orderForm.optionPants2StandardInfo.op2ByColorPlaceMap[orderForm.optionPants2StandardInfo.op2ByColorPlace4]}";

	var op2ByColor1 = "${orderForm.optionPants2StandardInfo.op2ByColorsMap[orderForm.optionPants2StandardInfo.op2ByColor1]}";
	var op2ByColor2 = "${orderForm.optionPants2StandardInfo.op2ByColorsMap[orderForm.optionPants2StandardInfo.op2ByColor2]}";
	var op2ByColor3 = "${orderForm.optionPants2StandardInfo.op2ByColorsMap[orderForm.optionPants2StandardInfo.op2ByColor3]}";
	var op2ByColor4 = "${orderForm.optionPants2StandardInfo.op2ByColorsMap[orderForm.optionPants2StandardInfo.op2ByColor4]}";

	var op2ByColorPlaceAndColorList = {
			activeOp2ByColorPlaceAndColor : [{"place":op2ByColorPlace1,"color":op2ByColor1},
				{"place":op2ByColorPlace2,"color":op2ByColor2},
				{"place":op2ByColorPlace3,"color":op2ByColor3},
				{"place":op2ByColorPlace4,"color":op2ByColor4}] 
	};
	var op2ByColorPlaceAndColor = '';
	var op2ByFlag = 0;
	for(var i =0;i < op2ByColorPlaceAndColorList.activeOp2ByColorPlaceAndColor.length;i++){
		if(isEmpty(op2ByColorPlaceAndColorList.activeOp2ByColorPlaceAndColor[i].place) && op2ByFlag != 3){
			op2ByFlag += 1;
			op2ByColorPlaceAndColor = op2ByColorPlaceAndColor + op2ByColorPlaceAndColorList.activeOp2ByColorPlaceAndColor[i].place + '　' + op2ByColorPlaceAndColorList.activeOp2ByColorPlaceAndColor[i].color
			+ '　　';
		}
		else if(isEmpty(op2ByColorPlaceAndColorList.activeOp2ByColorPlaceAndColor[i].place) && op2ByFlag == 3){
			op2ByFlag += 1;
			op2ByColorPlaceAndColor = op2ByColorPlaceAndColor + "\<br\>　　　　" + op2ByColorPlaceAndColorList.activeOp2ByColorPlaceAndColor[i].place + '　' + op2ByColorPlaceAndColorList.activeOp2ByColorPlaceAndColor[i].color + '　　';
		}
	}
	jQuery("#op2ByColorAndSubItem").html(op2ByColor + '　　' + op2ByColorPlaceAndColor);
}
</script>