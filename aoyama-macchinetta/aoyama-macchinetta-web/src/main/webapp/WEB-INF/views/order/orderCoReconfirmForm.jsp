<style type="text/css">
span {
	margin-right: 16px;
}
select.hidedown {
	-webkit-appearance:none;
	-moz-appearance:none;
	appearance:none;
}
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
</style>
<form:form id="idForm" action="${pageContext.request.contextPath}/orderCoConfirm/orderCoReFormInDb" method="post" modelAttribute="orderCoForm" class="form-horizontal">
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
<div class="alert alert-error" id="errormssage" style="display:none"></div>
	<div class="animated fadeIn">
		<div class="row">
			<div class="col-lg-6">
				<div class="row">
					<div class="col col-md-4">
						<label class=" form-control-label">お客様名</label>
					</div>
					<c:if test="${orderCoForm.coCustomerMessageInfo.custNm != '' && orderCoForm.coCustomerMessageInfo.custKanaNm != '' && orderCoForm.coCustomerMessageInfo.custNm != null && orderCoForm.coCustomerMessageInfo.custKanaNm != null}">
						<div class="col-12 col-md-8">
							<label class=" form-control-label-value">${f:h(orderCoForm.coCustomerMessageInfo.custNm)}(${f:h(orderCoForm.coCustomerMessageInfo.custKanaNm)})</label>様
						</div>
					</c:if>
					<c:if test="${orderCoForm.coCustomerMessageInfo.custKanaNm != null && orderCoForm.coCustomerMessageInfo.custKanaNm != '' && (orderCoForm.coCustomerMessageInfo.custNm == '' || orderCoForm.coCustomerMessageInfo.custNm == null)}">
						<div class="col-12 col-md-8">
							<label class=" form-control-label-value">(${f:h(orderCoForm.coCustomerMessageInfo.custKanaNm)})</label>様
						</div>
					</c:if>
					<c:if test="${orderCoForm.coCustomerMessageInfo.custNm != '' && orderCoForm.coCustomerMessageInfo.custNm != null && (orderCoForm.coCustomerMessageInfo.custKanaNm == '' || orderCoForm.coCustomerMessageInfo.custKanaNm == null)}">
						<div class="col-12 col-md-8">
							<label class=" form-control-label-value">${f:h(orderCoForm.coCustomerMessageInfo.custNm)}</label>様
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
						<strong><label class=" form-control-label-value">${orderCoForm.coCustomerMessageInfo.orderId}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">会員番号</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value">${orderCoForm.coCustomerMessageInfo.custCd}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">お客様氏名</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value">${f:h(orderCoForm.coCustomerMessageInfo.custNm)}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">フリガナ</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value">${f:h(orderCoForm.coCustomerMessageInfo.custKanaNm)}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label" >承り日</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value" id="License_day"></label></strong>
						</div>
					</div>
					<div class="row"><div class="col col-md-3"><label class=" form-control-label">　</label></div></div>
				</div>
				<div class="col col-lg-6">
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">納期短縮</label></div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderCoForm.coProductInfo.custIsDeliverShortningMap[orderCoForm.custIsDeliverShortning]}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value">${productAboutPrice["expediteDeliveryPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">早割</label></div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${orderCoForm.coProductInfo.custIsEarlyDiscountMap[orderCoForm.custIsEarlyDiscount]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">お渡し日</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value" id="cust_shop_delivery_date"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">スタッフ</label></div>
						<div class="col-12 col-md-9">
						<strong><label class=" form-control-label-value">${f:h(orderCoForm.coCustomerMessageInfo.custStaff)}</label></strong>
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
							<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${f:h(orderCoForm.coCustomerMessageInfo.custRemark)}</textarea>
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
						<strong><label class=" form-control-label-value" id="product_item">${orderCoForm.productItemMap[orderCoForm.productItem]}</label></strong>
						</div>
					</div>
					<c:if test="${orderCoForm.productItem == '01'}">
						<c:if test="${orderCoForm.productIs3Piece == '0009901'}">
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
						<c:if test="${orderCoForm.productIs3Piece == '0009902'}">
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
						<c:if test="${orderCoForm.productSparePantsClass == '0009901'}">
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
						<c:if test="${orderCoForm.productSparePantsClass == '0009902'}">
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
							<strong><label class=" form-control-label-value">${orderCoForm.productFabricNo}-${color}${pattern}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">カテゴリ</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coProductInfo.productCategoryMap[orderCoForm.productCategory]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">LCR縫製</label></div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderCoForm.coProductInfo.productLcrSewingMap[orderCoForm.productLcrSewing]}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value">${productAboutPrice["lcrSewingPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ブランドネーム</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coProductInfo.productBrandNmMap[orderCoForm.productBrandNm]}</label></strong>
						</div>
					</div>
					<div class="row" id="clothName_div">
						<div class="col col-md-3">
							<label class=" form-control-label">生地ネーム</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${orderCoForm.coProductInfo.productFabricNmNecessityMap[orderCoForm.productFabricNmNecessity]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">刺繍入れ</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${orderCoForm.coProductInfo.productEmbroideryNecessityMap[orderCoForm.productEmbroideryNecessity]}</label></strong>
						</div>
					</div>
					<c:if test="${orderCoForm.productEmbroideryNecessity == '9000502'}">
						<div id="embroidered_yes_area">
							<div class="row">
								<div class="col col-md-3">
									<label class=" form-control-label">刺繍ネーム</label>
								</div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.productEmbroideryNm}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3">
									<label class=" form-control-label">刺繍書体</label>
								</div>
								<div class="col-12 col-md-9">
									<strong><label class=" form-control-label-value">${orderCoForm.coProductInfo.productEmbroideryFontMap[orderCoForm.productEmbroideryFont]}</label></strong>
								</div>
							</div>
							<c:if test="${orderCoForm.productItem == '01' || orderCoForm.productItem == '02'}">
								<div class="row">
									<div class="col col-md-3">
										<label class=" form-control-label">刺繍糸色</label>
									</div>
									<div class="col-12 col-md-3">
										<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.jkProductEmbroideryThreadColorMap[orderCoForm.jkProductEmbroideryThreadColor]}</label></strong>
									</div>
								</div>
							</c:if>
							<c:if test="${orderCoForm.productItem == '05'}">
								<div class="row">
									<div class="col col-md-3">
										<label class=" form-control-label">刺繍糸色</label>
									</div>
									<div class="col-12 col-md-3">
										<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.stProductEmbroideryThreadColorMap[orderCoForm.stProductEmbroideryThreadColor]}</label></strong>
									</div>
								</div>
							</c:if>
							<c:if test="${orderCoForm.productItem == '05'}">
								<div class="row">
									<div class="col col-md-3">
										<label class=" form-control-label">刺繍箇所</label>
									</div>
									<div class="col-12 col-md-8">
										<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.productEmbroideryNmPosMap[orderCoForm.productEmbroideryNmPos]}</label></strong>
									</div>
									<div class="col-12 col-md-1" align="right">
										<strong><label class=" form-control-label-value">${productAboutPrice["embroideryNmPosPrice"]}</label></strong>
									</div>
								</div>
								<div class="row">
									<div class="col col-md-3">
										<label class=" form-control-label">刺繍サイズ</label>
									</div>
									<div class="col-12 col-md-3">
										<strong><label class=" form-control-label-value">縦　${orderCoForm.productEmbroideryLength}cm　　横　${orderCoForm.productEmbroideryWidth}cm</label></strong>
									</div>
								</div>
								<div class="row">
									<div class="col col-md-3">
										<label class=" form-control-label">ガゼット刺繍</label>
									</div>
									<div class="col-12 col-md-8">
										<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.productEmbroideryGazetteMap[orderCoForm.productEmbroideryGazette]}</label></strong>
									</div>
									<div class="col-12 col-md-1" align="right">
										<strong><label class=" form-control-label-value">${productAboutPrice["gadgetPrice"]}</label></strong>
									</div>
								</div>
							</c:if>
						</div>
					</c:if>
					<c:if test="${orderCoForm.productItem != '05'}">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">残布</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coProductInfo.productRemainingClothTypeMap[orderCoForm.productRemainingClothType]}</label></strong>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">生地ブランド</label></div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${orderCoForm.productFabricBrandNm}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">素材名</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${orderCoForm.productServiceNm}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">組成表示　表地</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="composFrtFabric">${orderCoForm.productComposFrtFabric}</label></strong>
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
							<strong><label class=" form-control-label-value">${orderCoForm.productComposSleeveLiner}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">取扱注意</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.productNotice}</label></strong>
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
						<c:if test="${orderCoForm.productCategory == '9000101' }">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label"><strong>JACKETモデル</strong></label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojJacketModelMap[orderCoForm.coOptionJacketStandardInfo.ojJacketModel]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojJacketModel_appear">${modelDoublePriceShow["jkDoubleModelPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">フロント釦数</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojFrontBtnCntMap[orderCoForm.coOptionJacketStandardInfo.ojFrontBtnCnt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojFrontBtnCnt_appear">${standardFrameJkDisplayUpperPrice["oj_frontBtnCnt"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojLapelDesignMap[orderCoForm.coOptionJacketStandardInfo.ojLapelDesign]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojLapelDesign_appear">${standardFrameJkDisplayUpperPrice["lapelDesign_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">グレード</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojGradeMap[orderCoForm.coOptionJacketStandardInfo.ojGrade]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojGrade_appear">${standardFrameJkDisplayUpperPrice["grade_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">裏仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojGackSpecMap[orderCoForm.coOptionJacketStandardInfo.ojGackSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojGackSpec_appear">${standardFrameJkDisplayUpperPrice["backSpec"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">台場</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojFortMap[orderCoForm.coOptionJacketStandardInfo.ojFort]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojFort_appear">${standardFrameJkDisplayUpperPrice["fort"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">襟裏（ヒゲ）</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojBackCollarMap[orderCoForm.coOptionJacketStandardInfo.ojBackCollar]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojBackCollar_appear">${standardFrameJkDisplayUpperPrice["backCollar_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojChainHangeMap[orderCoForm.coOptionJacketStandardInfo.ojChainHange]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojChainHange_appear">${standardFrameJkDisplayUpperPrice["chainHange_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ラペル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojLapelWidthMap[orderCoForm.coOptionJacketStandardInfo.ojLapelWidth]}</label></strong>	
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojLapelWidth_appear">${standardFrameJkDisplayUpperPrice["lapelWidth_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">フラワーホール</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojFlowerHoleMap[orderCoForm.coOptionJacketStandardInfo.ojFlowerHole]}</label></strong>	
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojFlowerHole_appear">${standardFrameJkDisplayUpperPrice["flowerHole"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojBreastPktMap[orderCoForm.coOptionJacketStandardInfo.ojBreastPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojBreastPkt_appear">${standardFrameJkDisplayUpperPrice["breastPkt_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojWaistPktMap[orderCoForm.coOptionJacketStandardInfo.ojWaistPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojWaistPkt_appear">${standardFrameJkDisplayUpperPrice["waistPkt"]}</label></strong>
								</div>
							</div>										
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojChangePktMap[orderCoForm.coOptionJacketStandardInfo.ojChangePkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right"><strong><label class=" form-control-label-value">${standardFrameJkDisplayUpperPrice["changePkt_id"]}</label></strong></div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojSlantedPktMap[orderCoForm.coOptionJacketStandardInfo.ojSlantedPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojSlantedPkt_appear">${standardFrameJkDisplayUpperPrice["slantedPkt_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojCoinPktMap[orderCoForm.coOptionJacketStandardInfo.ojCoinPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojCoinPkt_appear">${standardFrameJkDisplayUpperPrice["coinPkt"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojSleeveSpecMap[orderCoForm.coOptionJacketStandardInfo.ojSleeveSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojSleeveSpec_appear">${standardFrameJkDisplayUpperPrice["sleeveSpec_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">マニカ</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojManicaMap[orderCoForm.coOptionJacketStandardInfo.ojManica]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojManica_appear">${standardFrameJkDisplayUpperPrice["manica_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖釦</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojSleeveBtnTypeMap[orderCoForm.coOptionJacketStandardInfo.ojSleeveBtnType]}${orderCoForm.coOptionJacketStandardInfo.ojSleeveBtnCnt}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojSleeveBtnType_appear">${standardFrameJkDisplayUpperPrice["sleeveBtnType_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojCuffSpecMap[orderCoForm.coOptionJacketStandardInfo.ojCuffSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojCuffSpec_appear">${standardFrameJkDisplayUpperPrice["cuffSpec_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">内ポケット変更</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="ojInsidePktChangeAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojInsidePktChange_appear">${standardFrameJkDisplayUpperPrice["insidePktChange_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">下前胸内ポケット仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojBreastInnerPktMap[orderCoForm.coOptionJacketStandardInfo.ojBreastInnerPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojBreastInnerPkt_appear">${standardFrameJkDisplayUpperPrice["breastInnerPkt_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojStitchMap[orderCoForm.coOptionJacketStandardInfo.ojStitch]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="ojStitch_appear">${standardFrameJkDisplayUpperPrice["stitch_id"]}</label></strong>
								</div>
							</div>
							<c:if test="${orderCoForm.coOptionJacketStandardInfo.ojStitch != '0002302'}">
								<div class="row">
									<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
									<div class="col-12 col-md-8">
										<strong><label class=" form-control-label-value" id="ojStitchModifyPlaceAndSubItem"></label></strong>
									</div>
									<div class="col-12 col-md-1 text-right">
										<strong><label class=" form-control-label-value" id="ojStitchModifyPlace_appear">${standardFrameJkDisplayUpperPrice["stitchModify_id"]}</label></strong>
									</div>
								</div>
								<div class="row">
									<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ変更</label></div>
									<div class="col-12 col-md-8">
										<strong><label class=" form-control-label-value" id="ojDStitchModifyAndSubItem"></label></strong>
									</div>
									<div class="col-12 col-md-1 text-right">
										<strong><label class=" form-control-label-value" id="ojDStitchModify_appear">${standardFrameJkDisplayUpperPrice["dStitchModify_id"]}</label></strong>
									</div>
								</div>
								<div class="row">
									<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
									<div class="col-12 col-md-8">
										<strong><label class=" form-control-label-value" id="ojAmfColorAndSubItem"></label></strong>
									</div>
									<div class="col-12 col-md-1 text-right">
										<strong><label class=" form-control-label-value" id="ojAmfColor_appear">${standardFrameJkDisplayUpperPrice["amfColor_id"]}</label></strong>
									</div>
								</div>
							</c:if>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value" id="ojBhColorAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="ojBhColor_appear">${standardFrameJkDisplayUpperPrice["bhColor_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value" id="ojByColorAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="ojByColor_appear">${standardFrameJkDisplayUpperPrice["byColor_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojVentSpecMap[orderCoForm.coOptionJacketStandardInfo.ojVentSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojVentSpec_appear">${standardFrameJkDisplayUpperPrice["ventSpec_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="ojBodyBackMate_name">${standardJkMateSelectMap["ojBodyBackMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojBodyBackMate_app_appear">${standardFrameJkDisplayUpperPrice["bodyBackMate"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="ojCuffBackMate_name">${standardJkMateSelectMap["ojCuffBackMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojCuffBackMate_app_appear">${standardFrameJkDisplayUpperPrice["cuffBackMate"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="ojBtnMate_name">${standardJkMateSelectMap["ojBtnMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojBtnMate_app_appear">${standardFrameJkDisplayUpperPrice["btnMate"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.ojShapeMemoryMap[orderCoForm.coOptionJacketStandardInfo.ojShapeMemory]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojShapeMemory_appear">${standardFrameJkDisplayUpperPrice["shapeMemory_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<c:if test="${orderCoForm.productCategory == '9000102' }">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label"><strong>JACKETモデル</strong></label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjJacketModelMap[orderCoForm.coOptionJacketTuxedoInfo.tjJacketModel]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjJacketModel_appear">${modelDoublePriceShow["jkDoubleModelPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">フロント釦数</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjFrontBtnCntMap[orderCoForm.coOptionJacketTuxedoInfo.tjFrontBtnCnt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjFrontBtnCnt_appear">${tuxedoFrameJkDisplayUpperPrice["tj_frontBtnCnt"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjLapelDesignMap[orderCoForm.coOptionJacketTuxedoInfo.tjLapelDesign]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjLapelDesign_appear">${tuxedoFrameJkDisplayUpperPrice["tj_lapelDesign_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">グレード</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjGradeMap[orderCoForm.coOptionJacketTuxedoInfo.tjGrade]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjGrade_appear">${tuxedoFrameJkDisplayUpperPrice["tj_grade_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">裏仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjBackSpecMap[orderCoForm.coOptionJacketTuxedoInfo.tjBackSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjBackSpec_appear">${tuxedoFrameJkDisplayUpperPrice["tj_backSpec"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">台場</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjFortMap[orderCoForm.coOptionJacketTuxedoInfo.tjFort]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjFort_appear">${tuxedoFrameJkDisplayUpperPrice["tj_fort"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">拝絹地</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjGlossFablicMap[orderCoForm.coOptionJacketTuxedoInfo.tjGlossFablic]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjGlossFablic_appear">${tuxedoFrameJkDisplayUpperPrice["tj_GlossFablic"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">襟裏（ヒゲ）</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjBackCollarMap[orderCoForm.coOptionJacketTuxedoInfo.tjBackCollar]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjBackCollar_appear">${tuxedoFrameJkDisplayUpperPrice["tj_backCollar_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjChainHangeMap[orderCoForm.coOptionJacketTuxedoInfo.tjChainHange]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjChainHange_appear">${tuxedoFrameJkDisplayUpperPrice["tj_chainHange_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ラペル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjLapelWidthMap[orderCoForm.coOptionJacketTuxedoInfo.tjLapelWidth]}</label></strong>	
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjLapelWidth_appear">${tuxedoFrameJkDisplayUpperPrice["tj_lapelWidth_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">フラワーホール</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjFlowerHoleMap[orderCoForm.coOptionJacketTuxedoInfo.tjFlowerHole]}</label></strong>	
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjFlowerHole_appear">${tuxedoFrameJkDisplayUpperPrice["tj_flowerHole"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjBreastPktMap[orderCoForm.coOptionJacketTuxedoInfo.tjBreastPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjBreastPkt_appear">${tuxedoFrameJkDisplayUpperPrice["tj_breastPkt_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjWaistPktMap[orderCoForm.coOptionJacketTuxedoInfo.tjWaistPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjWaistPkt_appear">${tuxedoFrameJkDisplayUpperPrice["tj_waistPkt"]}</label></strong>
								</div>
							</div>										
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjChangePktMap[orderCoForm.coOptionJacketTuxedoInfo.tjChangePkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjChangePkt_appear">${tuxedoFrameJkDisplayUpperPrice["tj_changePkt_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjSlantedPktMap[orderCoForm.coOptionJacketTuxedoInfo.tjSlantedPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjSlantedPkt_appear">${tuxedoFrameJkDisplayUpperPrice["tj_slantedPkt_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjCoinPktMap[orderCoForm.coOptionJacketTuxedoInfo.tjCoinPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjCoinPkt_appear">${tuxedoFrameJkDisplayUpperPrice["tj_coinPkt"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjSleeveSpecMap[orderCoForm.coOptionJacketTuxedoInfo.tjSleeveSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjSleeveSpec_appear">${tuxedoFrameJkDisplayUpperPrice["tj_sleeveSpec_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">マニカ</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjManicaMap[orderCoForm.coOptionJacketTuxedoInfo.tjManica]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjManica_appear">${tuxedoFrameJkDisplayUpperPrice["tj_manica_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖釦</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjSleeveBtnTypeMap[orderCoForm.coOptionJacketTuxedoInfo.tjSleeveBtnType]}${orderCoForm.coOptionJacketTuxedoInfo.tjSleeveBtnCnt}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjSleeveBtnType_appear">${tuxedoFrameJkDisplayUpperPrice["tj_sleeveBtnType_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjCuffSpecMap[orderCoForm.coOptionJacketTuxedoInfo.tjCuffSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjCuffSpec_appear">${tuxedoFrameJkDisplayUpperPrice["tj_cuffSpec_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">内ポケット変更</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjInsidePktChangeMap[orderCoForm.coOptionJacketTuxedoInfo.tjInsidePktChange]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjInsidePktChange_appear">${tuxedoFrameJkDisplayUpperPrice["tj_insidePktChange_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">下前胸内ポケット仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjBreastInnerPktMap[orderCoForm.coOptionJacketTuxedoInfo.tjBreastInnerPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjBreastInnerPkt_appear">${tuxedoFrameJkDisplayUpperPrice["tj_breastInnerPkt_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjStitchMap[orderCoForm.coOptionJacketTuxedoInfo.tjStitch]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjStitch_appear">${tuxedoFrameJkDisplayUpperPrice["tj_stitch_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${tuxedoServelItemShow["tjBhColorPlaceAndColor"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="tjBhColor_appear">${tuxedoFrameJkDisplayUpperPrice["tj_bhColor_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${tuxedoServelItemShow["tjByColorPlaceAndColor"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="tjByColor_appear">${tuxedoFrameJkDisplayUpperPrice["tj_byColor_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjVentSpecMap[orderCoForm.coOptionJacketTuxedoInfo.tjVentSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjVentSpec_appear">${tuxedoFrameJkDisplayUpperPrice["tj_ventSpec_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="tjBodyBackMate_name">${tuxedoJkMateSelectMap["tjBodyBackMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjBodyBackMate_app_appear">${tuxedoFrameJkDisplayUpperPrice["tj_bodyBackMate"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="tjCuffBackMate_name">${tuxedoJkMateSelectMap["tjCuffBackMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="ojCuffBackMate_app_appear">${tuxedoFrameJkDisplayUpperPrice["tj_cuffBackMate"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="tjBtnMate_name">${tuxedoJkMateSelectMap["tjBtnMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjBtnMate_app_appear">${tuxedoFrameJkDisplayUpperPrice["tj_btnMate"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketTuxedoInfo.tjShapeMemoryMap[orderCoForm.coOptionJacketTuxedoInfo.tjShapeMemory]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tjShapeMemory_appear">${tuxedoFrameJkDisplayUpperPrice["tj_shapeMemory_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<c:if test="${orderCoForm.productCategory == '9000103' }">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label"><strong>JACKETモデル</strong></label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjJacketModelMap[orderCoForm.coOptionJacketWashableInfo.wjJacketModel]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjJacketModel_appear">${modelDoublePriceShow["jkDoubleModelPrice"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">フロント釦数</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjFrontBtnCntMap[orderCoForm.coOptionJacketWashableInfo.wjFrontBtnCnt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjFrontBtnCnt_appear">${washableFrameJkDisplayUpperPrice["wj_frontBtnCnt"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjLapelDesignMap[orderCoForm.coOptionJacketWashableInfo.wjLapelDesign]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjLapelDesign_appear">${washableFrameJkDisplayUpperPrice["wj_lapelDesign_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">グレード</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjGradeMap[orderCoForm.coOptionJacketWashableInfo.wjGrade]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjGrade_appear">${washableFrameJkDisplayUpperPrice["wj_grade_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">裏仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjBackSpecMap[orderCoForm.coOptionJacketWashableInfo.wjBackSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjBackSpec_appear">${washableFrameJkDisplayUpperPrice["wj_backSpec"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">台場</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjFortMap[orderCoForm.coOptionJacketWashableInfo.wjFort]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjFort_appear">${washableFrameJkDisplayUpperPrice["wj_fort"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">襟裏（ヒゲ）</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjBackCollarMap[orderCoForm.coOptionJacketWashableInfo.wjBackCollar]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjBackCollar_appear">${washableFrameJkDisplayUpperPrice["wj_backCollar_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjChainHangeMap[orderCoForm.coOptionJacketWashableInfo.wjChainHange]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjChainHange_appear">${washableFrameJkDisplayUpperPrice["wj_chainHange_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ラペル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjLapelWidthMap[orderCoForm.coOptionJacketWashableInfo.wjLapelWidth]}</label></strong>	
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjLapelWidth_appear">${washableFrameJkDisplayUpperPrice["wj_lapelWidth_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">フラワーホール</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjFlowerHoleMap[orderCoForm.coOptionJacketWashableInfo.wjFlowerHole]}</label></strong>	
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjFlowerHole_appear">${washableFrameJkDisplayUpperPrice["wj_flowerHole"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjBreastPktMap[orderCoForm.coOptionJacketWashableInfo.wjBreastPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjBreastPkt_appear">${washableFrameJkDisplayUpperPrice["wj_breastPkt_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjWaistPktMap[orderCoForm.coOptionJacketWashableInfo.wjWaistPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjWaistPkt_appear">${washableFrameJkDisplayUpperPrice["wj_waistPkt"]}</label></strong>
								</div>
							</div>										
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjChangePktMap[orderCoForm.coOptionJacketWashableInfo.wjChangePkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjChangePkt_appear">${washableFrameJkDisplayUpperPrice["wj_changePkt_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjSlantedPktMap[orderCoForm.coOptionJacketWashableInfo.wjSlantedPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjSlantedPkt_appear">${washableFrameJkDisplayUpperPrice["wj_slantedPkt_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjCoinPktMap[orderCoForm.coOptionJacketWashableInfo.wjCoinPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjCoinPkt_appear">${washableFrameJkDisplayUpperPrice["wj_coinPkt"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjSleeveSpecMap[orderCoForm.coOptionJacketWashableInfo.wjSleeveSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjSleeveSpec_appear">${washableFrameJkDisplayUpperPrice["wj_sleeveSpec_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">マニカ</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjManicaMap[orderCoForm.coOptionJacketWashableInfo.wjManica]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjManica_appear">${washableFrameJkDisplayUpperPrice["wj_manica_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖釦</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjSleeveBtnTypeMap[orderCoForm.coOptionJacketWashableInfo.wjSleeveBtnType]}${orderCoForm.coOptionJacketWashableInfo.wjSleeveBtnCnt}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjSleeveBtnType_appear">${washableFrameJkDisplayUpperPrice["wj_sleeveBtnTypeKasane_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjCuffSpecMap[orderCoForm.coOptionJacketWashableInfo.wjCuffSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjCuffSpec_appear">${washableFrameJkDisplayUpperPrice["wj_cuffSpec_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">内ポケット変更</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjInsidePktChangeMap[orderCoForm.coOptionJacketWashableInfo.wjInsidePktChange]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjInsidePktChange_appear">${washableFrameJkDisplayUpperPrice["wj_insidePktChange_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">下前胸内ポケット仕様</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjBreastInnerPktMap[orderCoForm.coOptionJacketWashableInfo.wjBreastInnerPkt]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjBreastInnerPkt_appear">${washableFrameJkDisplayUpperPrice["wj_breastInnerPkt_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjStitchMap[orderCoForm.coOptionJacketWashableInfo.wjStitch]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjStitch_appear">${washableFrameJkDisplayUpperPrice["wj_stitch_id"]}</label></strong>
								</div>
							</div>
							<c:if test="${orderCoForm.coOptionJacketStandardInfo.ojStitch != '0002302'}">
								<div class="row">
									<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
									<div class="col-12 col-md-8">
										<strong><label class=" form-control-label-value">${washableJkServelItemShow["wjStitchModifyPlace"]}</label></strong>
									</div>
									<div class="col-12 col-md-1 text-right">
										<strong><label class=" form-control-label-value" id="wjStitchModifyPlace_appear">${washableFrameJkDisplayUpperPrice["wj_stitchModify_id"]}</label></strong>
									</div>
								</div>
								<div class="row">
									<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ変更</label></div>
									<div class="col-12 col-md-8">
										<strong><label class=" form-control-label-value">${washableJkServelItemShow["wjDStitchModifyPlace"]}</label></strong>
									</div>
									<div class="col-12 col-md-1 text-right">
										<strong><label class=" form-control-label-value" id="wjDStitchModify_appear">${washableFrameJkDisplayUpperPrice["wj_dStitchModify_id"]}</label></strong>
									</div>
								</div>
								<div class="row">
									<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
									<div class="col-12 col-md-8">
										<strong><label class=" form-control-label-value">${washableJkServelItemShow["wjAmfColorPlaceAndColor"]}</label></strong>
									</div>
									<div class="col-12 col-md-1 text-right">
										<strong><label class=" form-control-label-value" id="wjAmfColor_appear">${washableFrameJkDisplayUpperPrice["wj_amfColor_id"]}</label></strong>
									</div>
								</div>
							</c:if>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${washableJkServelItemShow["wjBhColorPlaceAndColor"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="wjBhColor_appear">${washableFrameJkDisplayUpperPrice["wj_bhColor_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${washableJkServelItemShow["wjBhColorPlaceAndColor"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="wjByColor_appear">${washableFrameJkDisplayUpperPrice["wj_byColor_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjVentSpecMap[orderCoForm.coOptionJacketWashableInfo.wjVentSpec]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjVentSpec_appear">${washableFrameJkDisplayUpperPrice["wj_ventSpec_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="wjBodyBackMate_name">${washableJkMateSelectMap["wjBodyBackMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjBodyBackMate_app_appear">${washableFrameJkDisplayUpperPrice["wj_bodyBackMate"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="wjCuffBackMate_name">${washableJkMateSelectMap["wjCuffBackMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjCuffBackMate_app_appear">${washableFrameJkDisplayUpperPrice["wj_cuffBackMate"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value" id="wjBtnMate_name">${washableJkMateSelectMap["wjBtnMateStkNo"]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjBtnMate_app_appear">${washableFrameJkDisplayUpperPrice["wj_btnMate"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketWashableInfo.wjShapeMemoryMap[orderCoForm.coOptionJacketWashableInfo.wjShapeMemory]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wjShapeMemory_appear">${washableFrameJkDisplayUpperPrice["wj_shapeMemory_id"]}</label></strong>
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
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustJacketStandardInfo.sizeFigure}&nbsp &nbsp &nbsp${orderCoForm.coAdjustJacketStandardInfo.sizeNumber}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>JACKET補正</strong></label></div>
							<div class="col-12 col-md-3">
								<label class=" form-control-label">着丈修正</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value" id="corJkBodyCorrect"></label>cm</strong>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderCoForm.coAdjustJacketStandardInfo.corJkBodyGross}</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">ウエスト修正</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value" id="corJkWaistCorrect"></label>cm</strong>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderCoForm.coAdjustJacketStandardInfo.corJkWaistGross}</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">袖丈右修正</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value" id="corJkRightsleeveCorrect"></label>cm</strong>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderCoForm.coAdjustJacketStandardInfo.corJkRightsleeveGross}</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">袖丈左修正</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value" id="corJkLeftsleeveCorrect"></label>cm</strong>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderCoForm.coAdjustJacketStandardInfo.corJkLeftsleeveGross}</label>cm</strong> 
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">肩パット</label>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.corJkShoulderPadMap[orderCoForm.coAdjustJacketStandardInfo.corJkShoulderPad]}</label></strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">体型補正</label>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionJacketStandardInfo.corJkFigureCorrectMap[orderCoForm.coAdjustJacketStandardInfo.corJkFigureCorrect]}</label></strong>
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
								<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${orderCoForm.coAdjustJacketStandardInfo.corJkStoreCorrectionMemo}</textarea>
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
					<c:if test="${orderCoForm.productCategory == '9000101' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>GILETモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletStandardInfo.ogGiletModelMap[orderCoForm.coOptionGiletStandardInfo.ogGiletModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogGiletModel_appear">${modelDoublePriceShow["glDoubleModelPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletStandardInfo.ogBreastPktMap[orderCoForm.coOptionGiletStandardInfo.ogBreastPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogBreastPkt_appear"></label>${standardFrameGlDisplayUpperPrice["og_breastPkt_id"]}</strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletStandardInfo.ogWaistPktMap[orderCoForm.coOptionGiletStandardInfo.ogWaistPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogWaistPkt_appear">${standardFrameGlDisplayUpperPrice["og_waistPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット形状</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletStandardInfo.ogWaistPktSpecMap[orderCoForm.coOptionGiletStandardInfo.ogWaistPktSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogWaistPktSpec_appear">${standardFrameGlDisplayUpperPrice["og_waistPktSpec_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ種類 </label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletStandardInfo.ogStitchMap[orderCoForm.coOptionGiletStandardInfo.ogStitch]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogStitch_appear">${standardFrameGlDisplayUpperPrice["og_stitch_id"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionGiletStandardInfo.ogStitch != '0000503'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value" id="ogStitchModifyAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="ogStitchModify_appear">${standardFrameGlDisplayUpperPrice["og_stitchModify_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value" id="ogDStitchModifyAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="ogDStitchModify_appear">${standardFrameGlDisplayUpperPrice["og_dStitchModify_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value" id="ogAmfColorAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="ogAmfColor_appear">${standardFrameGlDisplayUpperPrice["og_amfColor_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="ogBhColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="ogBhColor_appear">${standardFrameGlDisplayUpperPrice["og_bhColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="ogByColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="ogBhColor_appear">${standardFrameGlDisplayUpperPrice["og_byColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">背裏地素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="ogBackLiningMate_name">${standardGlMateSelectMap["ogBackLiningMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogBackLiningMate_app_appear">${standardFrameGlDisplayUpperPrice["og_backLiningMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="ogInsideLiningMate_name">${standardGlMateSelectMap["ogInsideLiningMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogInsideLiningMate_app_appear">${standardFrameGlDisplayUpperPrice["og_insideLiningMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="ogFrontBtnMate_name">${standardGlMateSelectMap["ogFrontBtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogFrontBtnMate_app_appear">${standardFrameGlDisplayUpperPrice["og_frontBtnMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletStandardInfo.ogBackBeltMap[orderCoForm.coOptionGiletStandardInfo.ogBackBelt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogBackBelt_appear">${standardFrameGlDisplayUpperPrice["og_backBelt"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ウォッチチェーン</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletStandardInfo.ogWatchChainMap[orderCoForm.coOptionGiletStandardInfo.ogWatchChain]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="ogWatchChain_appear">${standardFrameGlDisplayUpperPrice["og_watchChain_id"]}</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderCoForm.productCategory == '9000102'}">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>GILETモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletTuxedoInfo.tgGiletModelMap[orderCoForm.coOptionGiletTuxedoInfo.tgGiletModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgGiletModel_appear">${modelDoublePriceShow["glDoubleModelPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletTuxedoInfo.tgBreastPktMap[orderCoForm.coOptionGiletTuxedoInfo.tgBreastPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgBreastPkt_appear">${tuxedoFrameGlDisplayUpperPrice["tg_breastPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletTuxedoInfo.tgWaistPktMap[orderCoForm.coOptionGiletTuxedoInfo.tgWaistPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgWaistPkt_appear">${tuxedoFrameGlDisplayUpperPrice["tg_waistPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット形状</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletTuxedoInfo.tgWaistPktSpecMap[orderCoForm.coOptionGiletTuxedoInfo.tgWaistPktSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgWaistPktSpec_appear">${tuxedoFrameGlDisplayUpperPrice["tg_waistPktSpec_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletTuxedoInfo.tgWaistPktMateMap[orderCoForm.coOptionGiletTuxedoInfo.tgWaistPktMate]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgWaistPktMate_appear">${tuxedoFrameGlDisplayUpperPrice["tg_waistPktMate_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ種類 </label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletTuxedoInfo.tgStitchMap[orderCoForm.coOptionGiletTuxedoInfo.tgStitch]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgStitch_appear">${tuxedoFrameGlDisplayUpperPrice["tg_stitch_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoGlServelItemShow["tgBhColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tgBhColor_appear">${tuxedoFrameGlDisplayUpperPrice["tg_bhColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoGlServelItemShow["tgByColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tgBhColor_appear">${tuxedoFrameGlDisplayUpperPrice["tg_byColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">背裏地素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="tgBackLiningMate_name">${tuxedoGlMateSelectMap["tgBackLiningMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgBackLiningMate_app_appear">${tuxedoFrameGlDisplayUpperPrice["tg_backLiningMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="tgInsideLiningMate_name">${tuxedoGlMateSelectMap["tgInsideLiningMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgInsideLiningMate_app_appear">${tuxedoFrameGlDisplayUpperPrice["tg_insideLiningMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="tgFrontBtnMate_name">${tuxedoGlMateSelectMap["tgFrontBtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgFrontBtnMate_app_appear">${tuxedoFrameGlDisplayUpperPrice["tg_frontBtnMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletTuxedoInfo.tgBackBeltMap[orderCoForm.coOptionGiletTuxedoInfo.tgBackBelt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgBackBelt_appear">${tuxedoFrameGlDisplayUpperPrice["tg_backBelt"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ウォッチチェーン</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletTuxedoInfo.tgWatchChainMap[orderCoForm.coOptionGiletTuxedoInfo.tgWatchChain]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tgWatchChain_appear">${tuxedoFrameGlDisplayUpperPrice["tg_watchChain_id"]}</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderCoForm.productCategory == '9000103' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>GILETモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletWashableInfo.wgGiletModelMap[orderCoForm.coOptionGiletWashableInfo.wgGiletModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgGiletModel_appear">${modelDoublePriceShow["glDoubleModelPrice"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletWashableInfo.wgBreastPktMap[orderCoForm.coOptionGiletWashableInfo.wgBreastPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgBreastPkt_appear">${washableFrameGlDisplayUpperPrice["wg_breastPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletWashableInfo.wgWaistPktMap[orderCoForm.coOptionGiletWashableInfo.wgWaistPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgWaistPkt_appear">${washableFrameGlDisplayUpperPrice["wg_waistPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">腰ポケット形状</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletWashableInfo.wgWaistPktSpecMap[orderCoForm.coOptionGiletWashableInfo.wgWaistPktSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgWaistPktSpec_appear">${washableFrameGlDisplayUpperPrice["wg_waistPktSpec_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ種類 </label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletWashableInfo.wgStitchMap[orderCoForm.coOptionGiletWashableInfo.wgStitch]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgStitch_appear">${washableFrameGlDisplayUpperPrice["wg_stitch_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washableGlServelItemShow["wgStitchModifyPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wgStitchModify_appear">${washableFrameGlDisplayUpperPrice["wg_stitchModify_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washableGlServelItemShow["wgDStitchModifyPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wgDStitchModify_appear">${washableFrameGlDisplayUpperPrice["wg_dStitchModify_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washableGlServelItemShow["wgAmfColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wgAmfColor_appear">${washableFrameGlDisplayUpperPrice["wg_amfColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washableGlServelItemShow["wgBhColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wgBhColor_appear">${washableFrameGlDisplayUpperPrice["wg_bhColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washableGlServelItemShow["wgByColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wgByColor_appear">${washableFrameGlDisplayUpperPrice["wg_byColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">背裏地素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="wgBackLiningMate_name">${washableGlMateSelectMap["wgBackLiningMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgBackLiningMate_app_appear">${washableFrameGlDisplayUpperPrice["wg_backLiningMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="glInnnerCloth_name">${washableGlMateSelectMap["wgInsideLiningMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgInsideLiningMate_app_appear">${washableFrameGlDisplayUpperPrice["wg_insideLiningMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="wgFrontBtnMate_name">${washableGlMateSelectMap["wgFrontBtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgFrontBtnMate_app_appear">${washableFrameGlDisplayUpperPrice["wg_frontBtnMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletWashableInfo.wgBackBeltMap[orderCoForm.coOptionGiletWashableInfo.wgBackBelt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgBackBelt_appear">${washableFrameGlDisplayUpperPrice["wg_backBelt"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ウォッチチェーン</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionGiletWashableInfo.wgWatchChainMap[orderCoForm.coOptionGiletWashableInfo.wgWatchChain]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wgWatchChain_appear">${washableFrameGlDisplayUpperPrice["wg_watchChain_id"]}</label></strong>
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
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustGiletStandardInfo.sizeFigure}&nbsp &nbsp &nbsp${orderCoForm.coAdjustGiletStandardInfo.sizeNumber}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>GILET補正</strong></label></div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
						<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value" id="corGlBodyCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustGiletStandardInfo.corGlBodyGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">バスト修正</label>
						</div>
						<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value" id="corGlBustCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustGiletStandardInfo.corGlBustGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value" id="corGlWaistCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustGiletStandardInfo.corGlWaistGross}</label>cm</strong>
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
								<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${orderCoForm.coAdjustGiletStandardInfo.corGlStoreCorrectionMemo}</textarea>
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
					<c:if test="${orderCoForm.productCategory == '9000101' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opPantsModelMap[orderCoForm.coOptionPantsStandardInfo.opPantsModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opPantsModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opTackMap[orderCoForm.coOptionPantsStandardInfo.opTack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opTack_appear">${standardFramePtDisplayUpperPrice["op_tack"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opKneeBackMap[orderCoForm.coOptionPantsStandardInfo.opKneeBack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opKneeBack_appear">${standardFramePtDisplayUpperPrice["op_kneeBack_id"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPantsStandardInfo.opKneeBack != '0000202'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opKneeBackMateMap[orderCoForm.coOptionPantsStandardInfo.opKneeBackMate]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="opKneeBackMate_appear">${standardFramePtDisplayUpperPrice["op_kneeBackMate_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opFrontSpecMap[orderCoForm.coOptionPantsStandardInfo.opFrontSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opFrontSpec_appear">${standardFramePtDisplayUpperPrice["op_frontSpec_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opPancherinaMap[orderCoForm.coOptionPantsStandardInfo.opPancherina]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opPancherina_appear">${standardFramePtDisplayUpperPrice["op_pancherina_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opAdjusterMap[orderCoForm.coOptionPantsStandardInfo.opAdjuster]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opAdjuster_appear">${standardFramePtDisplayUpperPrice["op_adjuster_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="opBeltLoopAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="opBeltLoop_appear">${standardFramePtDisplayUpperPrice["op_beltLoop_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opPinLoopMap[orderCoForm.coOptionPantsStandardInfo.opPinLoop]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opPinLoop_appear">${standardFramePtDisplayUpperPrice["op_pinLoop_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opSidePktMap[orderCoForm.coOptionPantsStandardInfo.opSidePkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opSidePkt_appear">${standardFramePtDisplayUpperPrice["op_sidePkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opSinobiPktMap[orderCoForm.coOptionPantsStandardInfo.opSinobiPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opSinobiPkt_appear">${standardFramePtDisplayUpperPrice["op_sinobiPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opCoinPktMap[orderCoForm.coOptionPantsStandardInfo.opCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opCoinPkt_appear">${standardFramePtDisplayUpperPrice["op_coinPkt"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opFlapCoinPktMap[orderCoForm.coOptionPantsStandardInfo.opFlapCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opFlapCoinPkt_appear">${standardFramePtDisplayUpperPrice["op_flapCoinPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opPisPktUfMap[orderCoForm.coOptionPantsStandardInfo.opPisPktUf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opPisPktUf_appear">${standardFramePtDisplayUpperPrice["op_pisPktUf_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opPisPktDfMap[orderCoForm.coOptionPantsStandardInfo.opPisPktDf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opPisPktDf_appear">${standardFramePtDisplayUpperPrice["op_pisPktDf_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opVCutMap[orderCoForm.coOptionPantsStandardInfo.opVCut]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opVCut_appear">${standardFramePtDisplayUpperPrice["op_vCut_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opHemUpMap[orderCoForm.coOptionPantsStandardInfo.opHemUp]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opHemUp_appear">${standardFramePtDisplayUpperPrice["op_hemUp"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPantsStandardInfo.opHemUp == '0001702' || orderCoForm.coOptionPantsStandardInfo.opHemUp == '0001703'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opDoubleWideMap[orderCoForm.coOptionPantsStandardInfo.opDoubleWide]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="opDoubleWide_appear">${standardFramePtDisplayUpperPrice["op_doubleWide"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opStitchMap[orderCoForm.coOptionPantsStandardInfo.opStitch]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="opStitch_appear">${standardFramePtDisplayUpperPrice["op_stitch_id"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPantsStandardInfo.opStitch != '0001903'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value" id="opStitchModifyAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="opStitchModify_appear">${standardFramePtDisplayUpperPrice["op_stitchModify_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value" id="opDStitchAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="opDStitch_appear">${standardFramePtDisplayUpperPrice["op_dStitch_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value" id="opAmfColorAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="opAmfColor_appear">${standardFramePtDisplayUpperPrice["op_amfColor_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="opBhColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="opBhColor_appear">${standardFramePtDisplayUpperPrice["op_bhColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="opByColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="opByColor_appear">${standardFramePtDisplayUpperPrice["op_byColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="opButton_name">${standardPtMateSelectMap["opBtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opButton_app_appear">${standardFramePtDisplayUpperPrice["op_btnMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opSuspenderBtnMap[orderCoForm.coOptionPantsStandardInfo.opSuspenderBtn]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opSuspenderBtn_appear">${standardFramePtDisplayUpperPrice["op_suspenderBtn_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opEightMap[orderCoForm.coOptionPantsStandardInfo.opEight]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opEight_appear">${standardFramePtDisplayUpperPrice["op_eight_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opThickMap[orderCoForm.coOptionPantsStandardInfo.opThick]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opBlister_appear">${standardFramePtDisplayUpperPrice["op_thick_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsStandardInfo.opShapeMemoryMap[orderCoForm.coOptionPantsStandardInfo.opShapeMemory]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="opShapeMemory_appear">${standardFramePtDisplayUpperPrice["op_shapeMemory_id"]}</label></strong>
							</div>
						</div>
					</c:if>
					
					
					<c:if test="${orderCoForm.productCategory == '9000102' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpPantsModelMap[orderCoForm.coOptionPantsTuxedoInfo.tpPantsModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpPantsModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpTackMap[orderCoForm.coOptionPantsTuxedoInfo.tpTack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpTack_appear">${tuxedoFramePtDisplayUpperPrice["tp_tack"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpKneeBackMap[orderCoForm.coOptionPantsTuxedoInfo.tpKneeBack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpKneeBack_appear">${tuxedoFramePtDisplayUpperPrice["tp_kneeBack_id"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPantsTuxedoInfo.tpKneeBack != '0000202'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpKneeBackMateMap[orderCoForm.coOptionPantsTuxedoInfo.tpKneeBackMate]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tpKneeBackMate_appear">${tuxedoFramePtDisplayUpperPrice["tp_kneeBackMate_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpFrontSpecMap[orderCoForm.coOptionPantsTuxedoInfo.tpFrontSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpFrontSpec_appear">${tuxedoFramePtDisplayUpperPrice["tp_frontSpec_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpPancherinaMap[orderCoForm.coOptionPantsTuxedoInfo.tpPancherina]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpPancherina_appear">${tuxedoFramePtDisplayUpperPrice["tp_pancherina_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpAdjusterMap[orderCoForm.coOptionPantsTuxedoInfo.tpAdjuster]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpAdjuster_appear">${tuxedoFramePtDisplayUpperPrice["tp_adjuster_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoPtServelItemShow["tpBeltLoopPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tpBeltLoop_appear">${tuxedoFramePtDisplayUpperPrice["tp_beltLoop_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpPinLoopMap[orderCoForm.coOptionPantsTuxedoInfo.tpPinLoop]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpPinLoop_appear">${tuxedoFramePtDisplayUpperPrice["tp_pinLoop_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpSidePktMap[orderCoForm.coOptionPantsTuxedoInfo.tpSidePkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpSidePkt_appear">${tuxedoFramePtDisplayUpperPrice["tp_sidePkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpSinobiPktMap[orderCoForm.coOptionPantsTuxedoInfo.tpSinobiPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpSinobiPkt_appear">${tuxedoFramePtDisplayUpperPrice["tp_sinobiPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpCoinPktMap[orderCoForm.coOptionPantsTuxedoInfo.tpCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpCoinPkt_appear">${tuxedoFramePtDisplayUpperPrice["tp_coinPkt"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpFlapCoinPktMap[orderCoForm.coOptionPantsTuxedoInfo.tpFlapCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpFlapCoinPkt_appear">${tuxedoFramePtDisplayUpperPrice["tp_flapCoinPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpPisPktUfMap[orderCoForm.coOptionPantsTuxedoInfo.tpPisPktUf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpPisPktUf_appear">${tuxedoFramePtDisplayUpperPrice["tp_pisPktUf_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpPisPktDfMap[orderCoForm.coOptionPantsTuxedoInfo.tpPisPktDf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpPisPktDf_appear">${tuxedoFramePtDisplayUpperPrice["tp_pisPktDf_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpVCutMap[orderCoForm.coOptionPantsTuxedoInfo.tpVCut]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpVCut_appear">${tuxedoFramePtDisplayUpperPrice["tp_vCut_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpHemUpMap[orderCoForm.coOptionPantsTuxedoInfo.tpHemUp]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpHemUp_appear">${tuxedoFramePtDisplayUpperPrice["tp_hemUp"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPantsTuxedoInfo.tpHemUp == '0001702' || orderCoForm.coOptionPantsTuxedoInfo.tpHemUp == '0001703'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpDoubleWideMap[orderCoForm.coOptionPantsTuxedoInfo.tpDoubleWide]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tpDoubleWide_appear">${tuxedoFramePtDisplayUpperPrice["tp_doubleWide"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpStitchMap[orderCoForm.coOptionPantsTuxedoInfo.tpStitch]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tpBhColor_appear">${tuxedoFramePtDisplayUpperPrice["tp_stitch_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoPtServelItemShow["tpBhColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tpBhColor_appear">${tuxedoFramePtDisplayUpperPrice["tp_bhColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoPtServelItemShow["tpByColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tpByColor_appear">${tuxedoFramePtDisplayUpperPrice["tp_byColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="tpButton_name">${tuxedoPtMateSelectMap["tpBtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpButton_app_appear">${tuxedoFramePtDisplayUpperPrice["tp_btnMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpSuspenderBtnMap[orderCoForm.coOptionPantsTuxedoInfo.tpSuspenderBtn]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpSuspenderBtn_appear">${tuxedoFramePtDisplayUpperPrice["tp_suspenderBtn_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpEightMap[orderCoForm.coOptionPantsTuxedoInfo.tpEight]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpEight_appear">${tuxedoFramePtDisplayUpperPrice["tp_eight_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpThickMap[orderCoForm.coOptionPantsTuxedoInfo.tpThick]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpThick_appear">${tuxedoFramePtDisplayUpperPrice["tp_thick_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpShapeMemoryMap[orderCoForm.coOptionPantsTuxedoInfo.tpShapeMemory]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpShapeMemory_appear">${tuxedoFramePtDisplayUpperPrice["tp_shapeMemory_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">側章</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpSideStripeMap[orderCoForm.coOptionPantsTuxedoInfo.tpSideStripe]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpSideStripe_appear">${tuxedoFramePtDisplayUpperPrice["tp_sideStripe_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">側章幅</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsTuxedoInfo.tpSideStripeWidthMap[orderCoForm.coOptionPantsTuxedoInfo.tpSideStripeWidth]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tpSideStripeWidth_appear">${tuxedoFramePtDisplayUpperPrice["tp_sideStripeWidth_id"]}</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderCoForm.productCategory == '9000103' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpPantsModelMap[orderCoForm.coOptionPantsWashableInfo.wpPantsModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpPantsModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpTackMap[orderCoForm.coOptionPantsWashableInfo.wpTack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpTack_appear">${washableFramePtDisplayUpperPrice["wp_tack"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpKneeBackMap[orderCoForm.coOptionPantsWashableInfo.wpKneeBack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpKneeBack_appear">${washableFramePtDisplayUpperPrice["wp_kneeBack_id"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPantsWashableInfo.wpKneeBack != '0000202'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpKneeBackMateMap[orderCoForm.coOptionPantsWashableInfo.wpKneeBackMate]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wpKneeBackMate_appear">${washableFramePtDisplayUpperPrice["wp_kneeBackMate_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpFrontSpecMap[orderCoForm.coOptionPantsWashableInfo.wpFrontSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpFrontSpec_appear">${washableFramePtDisplayUpperPrice["wp_frontSpec_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpPancherinaMap[orderCoForm.coOptionPantsWashableInfo.wpPancherina]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpPancherina_appear">${washableFramePtDisplayUpperPrice["wp_pancherina_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpAdjusterMap[orderCoForm.coOptionPantsWashableInfo.wpAdjuster]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpAdjuster_appear">${washableFramePtDisplayUpperPrice["wp_adjuster_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washablePtServelItemShow["wpBeltLoopPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wpBeltLoop_appear">${washableFramePtDisplayUpperPrice["wp_beltLoop_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpPinLoopMap[orderCoForm.coOptionPantsWashableInfo.wpPinLoop]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpPinLoop_appear">${washableFramePtDisplayUpperPrice["wp_pinLoop_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpSidePktMap[orderCoForm.coOptionPantsWashableInfo.wpSidePkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpSidePkt_appear">${washableFramePtDisplayUpperPrice["wp_sidePkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpSinobiPktMap[orderCoForm.coOptionPantsWashableInfo.wpSinobiPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpSinobiPkt_appear">${washableFramePtDisplayUpperPrice["wp_sinobiPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpCoinPktMap[orderCoForm.coOptionPantsWashableInfo.wpCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpCoinPkt_appear">${washableFramePtDisplayUpperPrice["wp_coinPkt"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpFlapCoinPktMap[orderCoForm.coOptionPantsWashableInfo.wpFlapCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpFlapCoinPkt_appear">${washableFramePtDisplayUpperPrice["wp_flapCoinPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpPisPktUfMap[orderCoForm.coOptionPantsWashableInfo.wpPisPktUf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpPisPktUf_appear">${washableFramePtDisplayUpperPrice["wp_pisPktUf_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpPisPktDfMap[orderCoForm.coOptionPantsWashableInfo.wpPisPktDf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpPisPktDf_appear">${washableFramePtDisplayUpperPrice["wp_pisPktDf_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpVCutMap[orderCoForm.coOptionPantsWashableInfo.wpVCut]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpVCut_appear">${washableFramePtDisplayUpperPrice["wp_vCut_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpHemUpMap[orderCoForm.coOptionPantsWashableInfo.wpHemUp]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpHemUp_appear">${washableFramePtDisplayUpperPrice["wp_hemUp"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPantsWashableInfo.wpHemUp == '0001702' || orderCoForm.coOptionPantsWashableInfo.wpHemUp == '0001703'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpDoubleWideMap[orderCoForm.coOptionPantsWashableInfo.wpDoubleWide]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wpDoubleWide_appear">${washableFramePtDisplayUpperPrice["wp_doubleWide"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpStitchMap[orderCoForm.coOptionPantsWashableInfo.wpStitch]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wpStitch_appear">${washableFramePtDisplayUpperPrice["wp_stitch_id"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPantsWashableInfo.wpStitch != '0001903'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${washablePtServelItemShow["wpStitchModifyPlace"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="wpStitchModify_appear">${washableFramePtDisplayUpperPrice["wp_stitchModify_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${washablePtServelItemShow["wpDStitchPlace"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="wpDStitch_appear">${washableFramePtDisplayUpperPrice["wp_dStitch_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${washablePtServelItemShow["wpAmfColorPlaceAndColor"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="wpAmfColor_appear">${washableFramePtDisplayUpperPrice["wp_amfColor_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washablePtServelItemShow["wpBhColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wpBhColor_appear">${washableFramePtDisplayUpperPrice["wp_bhColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washablePtServelItemShow["wpByColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wpByColor_appear">${washableFramePtDisplayUpperPrice["wp_byColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="wpButton_name">${washablePtMateSelectMap["wpBtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpButton_app_appear">${washableFramePtDisplayUpperPrice["wp_btnMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpSuspenderBtnMap[orderCoForm.coOptionPantsWashableInfo.wpSuspenderBtn]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpSuspenderBtn_appear">${washableFramePtDisplayUpperPrice["wp_suspenderBtn_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpEightMap[orderCoForm.coOptionPantsWashableInfo.wpEight]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpEight_appear">${washableFramePtDisplayUpperPrice["wp_eight_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpThickMap[orderCoForm.coOptionPantsWashableInfo.wpThick]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpThick_appear">${washableFramePtDisplayUpperPrice["wp_thick_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPantsWashableInfo.wpShapeMemoryMap[orderCoForm.coOptionPantsWashableInfo.wpShapeMemory]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wpShapeMemory_appear">${washableFramePtDisplayUpperPrice["wp_shapeMemory_id"]}</label></strong>
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
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustPantsStandardInfo.sizeFigure}&nbsp &nbsp &nbsp${orderCoForm.coAdjustPantsStandardInfo.sizeNumber}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>PANTS補正</strong></label></div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value" id="corPtWaistCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustPantsStandardInfo.corPtWaistGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ヒップ修正</label>
						</div>
						<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value" id="corPtHipCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustPantsStandardInfo.corPtHipGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ワタリ修正</label>
						</div>
						<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value" id="corPtThighCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustPantsStandardInfo.corPtThighGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-2 offset-md-3">
							<label class=" form-control-label">裾幅</label>
						</div>
						<c:if test="${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthType == '1'}">
						<div class="col-12 col-md-1">
							<strong><label for="ap_hemWidth_absolute" class="form-check-label ">修正</label></strong>
						</div>
						<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value" id="corPtHemwidthCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthGross}</label>cm</strong>
						</div>
						</c:if>
						<c:if test="${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthType == '2'}">
						<div class="col-12 col-md-1">
							<strong><label for="ap_hemWidth_absolute" class="form-check-label ">指定</label></strong>
						</div>
						<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value">${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthDegignate}</label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							
						</div>
						</c:if>
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
								<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${orderCoForm.coAdjustPantsStandardInfo.corPtStoreCorrectionMemo}</textarea>
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
					<c:if test="${orderCoForm.productCategory == '9000101' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2PantsModelMap[orderCoForm.coOptionPants2StandardInfo.op2PantsModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2PantsModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2TackMap[orderCoForm.coOptionPants2StandardInfo.op2Tack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Tack_appear">${standardFramePt2DisplayUpperPrice["op2_tack"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2KneeBackMap[orderCoForm.coOptionPants2StandardInfo.op2KneeBack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2KneeBack_appear">${standardFramePt2DisplayUpperPrice["op2_kneeBack_id"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPants2StandardInfo.op2KneeBack != '0000202'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2KneeBackMateMap[orderCoForm.coOptionPants2StandardInfo.op2KneeBackMate]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="op2KneeBackMate_appear">${standardFramePt2DisplayUpperPrice["op2_kneeBackMate_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2FrontSpecMap[orderCoForm.coOptionPants2StandardInfo.op2FrontSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2FrontSpec_appear">${standardFramePt2DisplayUpperPrice["op2_frontSpec_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2PancherinaMap[orderCoForm.coOptionPants2StandardInfo.op2Pancherina]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Pancherina_appear">${standardFramePt2DisplayUpperPrice["op2_pancherina_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2AdjusterMap[orderCoForm.coOptionPants2StandardInfo.op2Adjuster]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Adjuster_appear">${standardFramePt2DisplayUpperPrice["op2_adjuster_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="op2BeltLoopAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="op2BeltLoop_appear">${standardFramePt2DisplayUpperPrice["op2_beltLoop_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2PinLoopMap[orderCoForm.coOptionPants2StandardInfo.op2PinLoop]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2PinLoop_appear">${standardFramePt2DisplayUpperPrice["op2_pinLoop_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2SidePktMap[orderCoForm.coOptionPants2StandardInfo.op2SidePkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2SidePkt_appear">${standardFramePt2DisplayUpperPrice["op2_sidePkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2SinobiPktMap[orderCoForm.coOptionPants2StandardInfo.op2SinobiPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2SinobiPkt_appear">${standardFramePt2DisplayUpperPrice["op2_sinobiPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2CoinPktMap[orderCoForm.coOptionPants2StandardInfo.op2CoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2CoinPkt_appear">${standardFramePt2DisplayUpperPrice["op2_coinPkt"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2FlapCoinPktMap[orderCoForm.coOptionPants2StandardInfo.op2FlapCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2FlapCoinPkt_appear">${standardFramePt2DisplayUpperPrice["op2_flapCoinPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2PisPktUfMap[orderCoForm.coOptionPants2StandardInfo.op2PisPktUf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2PisPktUf_appear">${standardFramePt2DisplayUpperPrice["op2_pisPktUf_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2PisPktDfMap[orderCoForm.coOptionPants2StandardInfo.op2PisPktDf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2PisPktDf_appear">${standardFramePt2DisplayUpperPrice["op2_pisPktDf_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2VCutMap[orderCoForm.coOptionPants2StandardInfo.op2VCut]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2VCut_appear">${standardFramePt2DisplayUpperPrice["op2_vCut_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2HemUpMap[orderCoForm.coOptionPants2StandardInfo.op2HemUp]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2HemUp_appear">${standardFramePt2DisplayUpperPrice["op2_hemUp"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPants2StandardInfo.op2HemUp == '0001702' || orderCoForm.coOptionPants2StandardInfo.op2HemUp == '0001703'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2DoubleWideMap[orderCoForm.coOptionPants2StandardInfo.op2DoubleWide]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="op2DoubleWide_appear">${standardFramePt2DisplayUpperPrice["op2_doubleWide"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2StitchMap[orderCoForm.coOptionPants2StandardInfo.op2Stitch]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="op2Stitch_appear">${standardFramePt2DisplayUpperPrice["op2_stitch_id"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPants2StandardInfo.op2Stitch != '0001903'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value" id="op2StitchModifyAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="op2StitchModify_appear">${standardFramePt2DisplayUpperPrice["op2_stitchModify_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value" id="op2DStitchAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="op2DStitch_appear">${standardFramePt2DisplayUpperPrice["op2_dStitch_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value" id="op2AmfColorAndSubItem"></label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="op2AmfColor_appear">${standardFramePt2DisplayUpperPrice["op2_amfColor_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="op2BhColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="op2BhColor_appear">${standardFramePt2DisplayUpperPrice["op2_bhColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value" id="op2ByColorAndSubItem"></label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="op2ByColor_appear">${standardFramePt2DisplayUpperPrice["op2_byColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="op2Button_name">${standardPt2MateSelectMap["op2BtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Button_app_appear">${standardFramePt2DisplayUpperPrice["op2_btnMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2SuspenderBtnMap[orderCoForm.coOptionPants2StandardInfo.op2SuspenderBtn]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2SuspenderBtn_appear">${standardFramePt2DisplayUpperPrice["op2_suspenderBtn_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2EightMap[orderCoForm.coOptionPants2StandardInfo.op2Eight]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Eight_appear">${standardFramePt2DisplayUpperPrice["op2_thick_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2ThickMap[orderCoForm.coOptionPants2StandardInfo.op2Thick]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Thick_appear">${standardFramePt2DisplayUpperPrice["op2_eight_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2StandardInfo.op2ShapeMemoryMap[orderCoForm.coOptionPants2StandardInfo.op2ShapeMemory]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2ShapeMemory_appear">${standardFramePt2DisplayUpperPrice["op2_shapeMemory_id"]}</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderCoForm.productCategory == '9000102' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2PantsModelMap[orderCoForm.coOptionPants2TuxedoInfo.tp2PantsModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2PantsModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2TackMap[orderCoForm.coOptionPants2TuxedoInfo.tp2Tack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2Tack_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_tack"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2KneeBackMap[orderCoForm.coOptionPants2TuxedoInfo.tp2KneeBack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2KneeBack_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_kneeBack_id"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPants2TuxedoInfo.tp2KneeBack != '0000202'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2KneeBackMateMap[orderCoForm.coOptionPants2TuxedoInfo.tp2KneeBackMate]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tp2KneeBackMate_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_kneeBackMate_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2FrontSpecMap[orderCoForm.coOptionPants2TuxedoInfo.tp2FrontSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2FrontSpec_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_frontSpec_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2PancherinaMap[orderCoForm.coOptionPants2TuxedoInfo.tp2Pancherina]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2Pancherina_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_pancherina_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2AdjusterMap[orderCoForm.coOptionPants2TuxedoInfo.tp2Adjuster]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2Adjuster_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_adjuster_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoPt2ServelItemShow["tp2BeltLoopPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tp2BeltLoop_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_beltLoop_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2PinLoopMap[orderCoForm.coOptionPants2TuxedoInfo.tp2PinLoop]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2PinLoop_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_pinLoop_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2SidePktMap[orderCoForm.coOptionPants2TuxedoInfo.tp2SidePkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2SidePkt_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_sidePkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2SinobiPktMap[orderCoForm.coOptionPants2TuxedoInfo.tp2SinobiPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2SinobiPkt_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_sinobiPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2CoinPktMap[orderCoForm.coOptionPants2TuxedoInfo.tp2CoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2CoinPkt_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_coinPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2FlapCoinPktMap[orderCoForm.coOptionPants2TuxedoInfo.tp2FlapCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2FlapCoinPkt_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_flapCoinPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2PisPktUfMap[orderCoForm.coOptionPants2TuxedoInfo.tp2PisPktUf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2PisPktUf_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_pisPktUf_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2PisPktDfMap[orderCoForm.coOptionPants2TuxedoInfo.tp2PisPktDf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2PisPktDf_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_pisPktDf_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2VCutMap[orderCoForm.coOptionPants2TuxedoInfo.tp2VCut]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2VCut_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_vCut_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2HemUpMap[orderCoForm.coOptionPants2TuxedoInfo.tp2HemUp]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2HemUp_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_hemUp"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPants2TuxedoInfo.tp2HemUp == '0001702' || orderCoForm.coOptionPants2TuxedoInfo.tp2HemUp == '0001703'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2DoubleWideMap[orderCoForm.coOptionPants2TuxedoInfo.tp2DoubleWide]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="tp2DoubleWide_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_doubleWide"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2StitchMap[orderCoForm.coOptionPants2TuxedoInfo.tp2Stitch]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tp2BhColor_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_stitch_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoPt2ServelItemShow["tp2BhColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tp2BhColor_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_bhColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${tuxedoPt2ServelItemShow["tp2ByColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="tp2ByColor_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_byColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="pt2BtnMaterial_name">${tuxedoPt2MateSelectMap["tp2BtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Button_app_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_btnMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2SuspenderBtnMap[orderCoForm.coOptionPants2TuxedoInfo.tp2SuspenderBtn]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2SuspenderBtn_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_suspenderBtn_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2EightMap[orderCoForm.coOptionPants2TuxedoInfo.tp2Eight]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2Eight_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_thick_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2ThickMap[orderCoForm.coOptionPants2TuxedoInfo.tp2Thick]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2Thick_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_eight_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2ShapeMemoryMap[orderCoForm.coOptionPants2TuxedoInfo.tp2ShapeMemory]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2ShapeMemory_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_shapeMemory_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">側章</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2SideStripeMap[orderCoForm.coOptionPants2TuxedoInfo.tp2SideStripe]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2SideStripe_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_sideStripe_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">側章幅</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2TuxedoInfo.tp2SideStripeWidthMap[orderCoForm.coOptionPants2TuxedoInfo.tp2SideStripeWidth]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="tp2SideStripeWidth_appear">${tuxedoFramePt2DisplayUpperPrice["tp2_sideStripeWidth_id"]}</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderCoForm.productCategory == '9000103' }">
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label"><strong>PANTSモデル</strong></label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2PantsModelMap[orderCoForm.coOptionPants2WashableInfo.wp2PantsModel]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2PantsModel_appear"></label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">タック</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2TackMap[orderCoForm.coOptionPants2WashableInfo.wp2Tack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2Tack_appear">${washableFramePt2DisplayUpperPrice["wp2_tack_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">膝裏</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2KneeBackMap[orderCoForm.coOptionPants2WashableInfo.wp2KneeBack]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2KneeBack_appear">${washableFramePt2DisplayUpperPrice["wp2_kneeBack_id"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPants2WashableInfo.wp2KneeBack != '0000202'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2KneeBackMateMap[orderCoForm.coOptionPants2WashableInfo.wp2KneeBackMate]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wp2KneeBackMate_appear">${washableFramePt2DisplayUpperPrice["wp2_kneeBackMate_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フロント仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2FrontSpecMap[orderCoForm.coOptionPants2WashableInfo.wp2FrontSpec]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2FrontSpec_appear">${washableFramePt2DisplayUpperPrice["wp2_frontSpec_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2PancherinaMap[orderCoForm.coOptionPants2WashableInfo.wp2Pancherina]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2Pancherina_appear">${washableFramePt2DisplayUpperPrice["wp2_pancherina_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2AdjusterMap[orderCoForm.coOptionPants2WashableInfo.wp2Adjuster]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2Adjuster_appear">${washableFramePt2DisplayUpperPrice["wp2_adjuster_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ベルトループ</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washablePt2ServelItemShow["wp2BeltLoopPlace"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wp2BeltLoop_appear">${washableFramePt2DisplayUpperPrice["wp2_beltLoop_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2PinLoopMap[orderCoForm.coOptionPants2WashableInfo.wp2PinLoop]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2PinLoop_appear">${washableFramePt2DisplayUpperPrice["wp2_pinLoop_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2SidePktMap[orderCoForm.coOptionPants2WashableInfo.wp2SidePkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2SidePkt_appear">${washableFramePt2DisplayUpperPrice["wp2_sidePkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2SinobiPktMap[orderCoForm.coOptionPants2WashableInfo.wp2SinobiPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2SinobiPkt_appear">${washableFramePt2DisplayUpperPrice["wp2_sinobiPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2CoinPktMap[orderCoForm.coOptionPants2WashableInfo.wp2CoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2CoinPkt_appear">${washableFramePt2DisplayUpperPrice["wp2_coinPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2FlapCoinPktMap[orderCoForm.coOptionPants2WashableInfo.wp2FlapCoinPkt]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2FlapCoinPkt_appear">${washableFramePt2DisplayUpperPrice["wp2_flapCoinPkt_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2PisPktUfMap[orderCoForm.coOptionPants2WashableInfo.wp2PisPktUf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2PisPktUf_appear">${washableFramePt2DisplayUpperPrice["wp2_pisPktUf_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2PisPktDfMap[orderCoForm.coOptionPants2WashableInfo.wp2PisPktDf]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2PisPktDf_appear">${washableFramePt2DisplayUpperPrice["wp2_pisPktDf_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">Ｖカット</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2VCutMap[orderCoForm.coOptionPants2WashableInfo.wp2VCut]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2VCut_appear">${washableFramePt2DisplayUpperPrice["wp2_vCut_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">裾上げ</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2HemUpMap[orderCoForm.coOptionPants2WashableInfo.wp2HemUp]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2HemUp_appear">${washableFramePt2DisplayUpperPrice["wp2_hemUp_id"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPants2WashableInfo.wp2HemUp == '0001702' || orderCoForm.coOptionPants2WashableInfo.wp2HemUp == '0001703'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
								<div class="col-12 col-md-6">
									<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2DoubleWideMap[orderCoForm.coOptionPants2WashableInfo.wp2DoubleWide]}</label></strong>
								</div>
								<div class="col-12 col-md-3 text-right">
									<strong><label class=" form-control-label-value" id="wp2DoubleWide_appear">${washableFramePt2DisplayUpperPrice["wp2_doubleWide_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2StitchMap[orderCoForm.coOptionPants2WashableInfo.wp2Stitch]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wp2Stitch_appear">${washableFramePt2DisplayUpperPrice["wp2_stitch_id"]}</label></strong>
							</div>
						</div>
						<c:if test="${orderCoForm.coOptionPants2WashableInfo.wp2Stitch != '0001903'}">
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${washablePt2ServelItemShow["wp2StitchModifyPlace"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="wp2StitchModify_appear">${washableFramePt2DisplayUpperPrice["wp2_stitchModify_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${washablePt2ServelItemShow["wp2DStitchPlace"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="wp2DStitch_appear">${washableFramePt2DisplayUpperPrice["wp2_dStitch_id"]}</label></strong>
								</div>
							</div>
							<div class="row">
								<div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
								<div class="col-12 col-md-8">
									<strong><label class=" form-control-label-value">${washablePt2ServelItemShow["wp2AmfColorPlaceAndColor"]}</label></strong>
								</div>
								<div class="col-12 col-md-1 text-right">
									<strong><label class=" form-control-label-value" id="wp2AmfColor_appear">${washableFramePt2DisplayUpperPrice["wp2_amfColor_id"]}</label></strong>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washablePt2ServelItemShow["wp2BhColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wp2BhColor_appear">${washableFramePt2DisplayUpperPrice["wp2_bhColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${washablePt2ServelItemShow["wp2ByColorPlaceAndColor"]}</label></strong>
							</div>
							<div class="col-12 col-md-1 text-right">
								<strong><label class=" form-control-label-value" id="wp2ByColor_appear">${washableFramePt2DisplayUpperPrice["wp2_byColor_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value" id="pt2BtnMaterial_name">${washablePt2MateSelectMap["wp2BtnMateStkNo"]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="op2Button_app_appear">${washableFramePt2DisplayUpperPrice["wp2_btnMate"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2SuspenderBtnMap[orderCoForm.coOptionPants2WashableInfo.wp2SuspenderBtn]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2SuspenderBtn_appear">${washableFramePt2DisplayUpperPrice["wp2_suspenderBtn_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2EightMap[orderCoForm.coOptionPants2WashableInfo.wp2Eight]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2Eight_appear">${washableFramePt2DisplayUpperPrice["wp2_thick_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2ThickMap[orderCoForm.coOptionPants2WashableInfo.wp2Thick]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2Thick_appear">${washableFramePt2DisplayUpperPrice["wp2_eight_id"]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
							<div class="col-12 col-md-6">
								<strong><label class=" form-control-label-value">${orderCoForm.coOptionPants2WashableInfo.wp2ShapeMemoryMap[orderCoForm.coOptionPants2WashableInfo.wp2ShapeMemory]}</label></strong>
							</div>
							<div class="col-12 col-md-3 text-right">
								<strong><label class=" form-control-label-value" id="wp2ShapeMemory_appear">${washableFramePt2DisplayUpperPrice["wp2_shapeMemory_id"]}</label></strong>
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
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustPants2StandardInfo.sizeFigure}&nbsp &nbsp &nbsp${orderCoForm.coAdjustPants2StandardInfo.sizeNumber}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>PANTS補正</strong></label></div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corPt2WaistCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustPants2StandardInfo.corPt2WaistGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ヒップ修正</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corPt2HipCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustPants2StandardInfo.corPt2HipGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ワタリ修正</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corPt2ThighCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustPants2StandardInfo.corPt2ThighGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-2 offset-md-3">
							<label class=" form-control-label">裾幅</label>
						</div>
						<c:if test="${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthType == '1'}">
						<div class="col-12 col-md-1">
							<strong><label for="ap2_hemWidth_absolute" class="form-check-label ">修正</label></strong>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corPt2HemwidthCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthGross}</label>cm</strong>
						</div>
						</c:if>
						<c:if test="${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthType == '2'}">
						<div class="col-12 col-md-1">
							<strong><label for="ap_hemWidth_absolute" class="form-check-label ">指定</label></strong>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthDegignate}</label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							
						</div>
						</c:if>
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
								<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${orderCoForm.coAdjustPants2StandardInfo.corPt2StoreCorrectionMemo}</textarea>
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
							<strong><label class="form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osShirtModelMap[orderCoForm.coOptionShirtStandardInfo.osShirtModel]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osShirtModel_appear"></label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">襟型</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osChainModelMap[orderCoForm.coOptionShirtStandardInfo.osChainModel]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osChainModel_appear">${standardFrameStDisplayUpperPrice["os_chainModel"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">カフス</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osCuffsMap[orderCoForm.coOptionShirtStandardInfo.osCuffs]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osCuffs_appear">${standardFrameStDisplayUpperPrice["os_cuffs"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">コンバーチブル</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osConvertibleMap[orderCoForm.coOptionShirtStandardInfo.osConvertible]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osConvertible_appear">${standardFrameStDisplayUpperPrice["os_convertible"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">アジャスト釦</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osAdjustBtnMap[orderCoForm.coOptionShirtStandardInfo.osAdjustBtn]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osAdjustBtn_appear">${standardFrameStDisplayUpperPrice["os_adjustBtn"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">クレリック仕様</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osClericSpecMap[orderCoForm.coOptionShirtStandardInfo.osClericSpec]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osClericSpec_appear">${standardFrameStDisplayUpperPrice["os_clericSpec_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ダブルカフス仕様</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osDblCuffMap[orderCoForm.coOptionShirtStandardInfo.osDblCuff]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osDblCuff_appear">${standardFrameStDisplayUpperPrice["os_dblCuff_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">カフスボタン追加</label></div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osAddCuffMap[orderCoForm.coOptionShirtStandardInfo.osAddCuff]}</label></strong>
						</div>
						<div class="col-12 col-md-1 text-right">
							<strong><label class=" form-control-label-value" id="osAddCuff_appear">${standardFrameStDisplayUpperPrice["os_AddCuff_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">釦</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osBtnMateMap[orderCoForm.coOptionShirtStandardInfo.osBtnMate]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osBtnMate_appear">${standardFrameStDisplayUpperPrice["os_btnMate"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">タブ釦</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osTabBtnMap[orderCoForm.coOptionShirtStandardInfo.osTabBtn]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osTabBtn_appear">${standardFrameStDisplayUpperPrice["os_tabBtn_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ガントレットボタン位置</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osGaletteBtnPosMap[orderCoForm.coOptionShirtStandardInfo.osGaletteBtnPos]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osGaletteBtnPos_appear">${standardFrameStDisplayUpperPrice["os_galetteBtnPos_nomal_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ピンホールピン</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osPinHolePinMap[orderCoForm.coOptionShirtStandardInfo.osPinHolePin]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osPinHolePin_appear">${standardFrameStDisplayUpperPrice["os_pinHolePin_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osBreastPkMap[orderCoForm.coOptionShirtStandardInfo.osBreastPk]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osBreastPk_appear">${standardFrameStDisplayUpperPrice["os_breastPk_yes_id"]}</label></strong>
						</div>
					</div>
					<c:if test="${orderCoForm.coOptionShirtStandardInfo.osBreastPk != '0001202'}">
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">胸ポケット大きさ</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osBreastPkSizeMap[orderCoForm.coOptionShirtStandardInfo.osBreastPkSize]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osBreastPkSize_appear">${standardFrameStDisplayUpperPrice["os_breastPkSize_normal_id"]}</label></strong>
						</div>
					</div>
					</c:if>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">フロントデザイン</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osFrontDesignMap[orderCoForm.coOptionShirtStandardInfo.osFrontDesign]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osFrontDesign_appear">${standardFrameStDisplayUpperPrice["os_frontDesign"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ピンタックブザム</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osPinTackMap[orderCoForm.coOptionShirtStandardInfo.osPinTack]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osPinTack_appear">${standardFrameStDisplayUpperPrice["os_pinTack_no_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ステッチ</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osStitchMap[orderCoForm.coOptionShirtStandardInfo.osStitch]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osStitch_appear">${standardFrameStDisplayUpperPrice["os_stitch_nomal_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">カラーキーパー</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osColorKeeperMap[orderCoForm.coOptionShirtStandardInfo.osColorKeeper]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osColorKeeper_appear">${standardFrameStDisplayUpperPrice["os_colorKeeper_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ボタンホール色変更</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osBhColorMap[orderCoForm.coOptionShirtStandardInfo.osBhColor]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osBhColor_appear">${standardFrameStDisplayUpperPrice["os_bhColor"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ボタン付け糸色変更</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osByColorMap[orderCoForm.coOptionShirtStandardInfo.osByColor]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osByColor_appear">${standardFrameStDisplayUpperPrice["os_byColor"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">カジュアルヘムライン仕様</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osCasHemLineMap[orderCoForm.coOptionShirtStandardInfo.osCasHemLine]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osCasHemLine_appear">${standardFrameStDisplayUpperPrice["os_casHemLine_id"]}</label></strong>
						</div>
						<c:if test="${orderCoForm.coOptionShirtStandardInfo.osCasHemLine == '0002002'}">
						<div class="col col-md-3"></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.stCasualHemlineSize}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 text-right">
						</div>
						</c:if>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ボタン位置変更</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.osBtnPosChgMap[orderCoForm.coOptionShirtStandardInfo.osBtnPosChg]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="osBtnPosChg_appear">${standardFrameStDisplayUpperPrice["os_btnPosChg_id"]}</label></strong>
						</div>
						<c:if test="${orderCoForm.coOptionShirtStandardInfo.osBtnPosChg == '0002102'}">
						<div class="col-12 col-md-3">
						</div>
						<div class="col-12 col-md-3">
							<strong><label class=" form-control-label">台襟釦</label></strong>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.stNeckbandBtnPosChg}</label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
						</div>
						<div class="col-12 col-md-3">
						</div>
						<div class="col-12 col-md-3">
							<strong><label class=" form-control-label">フロント第1釦</label></strong>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.stFrtfirstBtnPosChg}</label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
						</div>
						<div class="col-12 col-md-3">
						</div>
						<div class="col-12 col-md-3">
							<strong><label class=" form-control-label">フロント第2釦</label></strong>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.stFrtsecondBtnPosChg}</label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
						</div>
						</c:if>
					</div>
				</div>
			</div>
			<div class="row">　</div>
			<div class="row">
				<div class="col col-lg-12">
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>SHIRTサイズ</strong></label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustShirtStandardInfo.corStSize}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>SHIRT補正</strong></label></div>
						
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ネック</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corStNeckCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustShirtStandardInfo.corStNeckGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corStBodylengthCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustShirtStandardInfo.corStBodylengthGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈右修正</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corStRightsleeveCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustShirtStandardInfo.corStRightsleeveGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈左修正</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corStLeftsleeveCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustShirtStandardInfo.corStLeftsleeveGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">背ダーツ詰め</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corStBackdartsPackCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">背ダーツ出し</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionShirtStandardInfo.corStBackdartsUnpackCorrectMap[orderCoForm.coAdjustShirtStandardInfo.corStBackdartsUnpackCd]}</label></strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">カフス周り右</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corStRightcuffsSurroundingCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustShirtStandardInfo.corStRightcuffsSurroundingGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">カフス周り左</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corStLeftcuffsSurroundingCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustShirtStandardInfo.corStLeftcuffsSurroundingGross}</label>cm</strong>
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
								<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${orderCoForm.corStoreCorrectionMemoAgain}</textarea>
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
							<strong><label class="form-control-label-value">${orderCoForm.coOptionCoatStandardInfo.coatModelMap[orderCoForm.coOptionCoatStandardInfo.coatModel]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="coatModel_appear">${modelDoublePriceShow["ctDoubleModelPrice"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionCoatStandardInfo.ocLapelDesignMap[orderCoForm.coOptionCoatStandardInfo.ocLapelDesign]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocLapelDesign_appear">${standardFrameCtDisplayUpperPrice["oc_lapelDesign"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionCoatStandardInfo.ocSleeveSpecMap[orderCoForm.coOptionCoatStandardInfo.ocSleeveSpec]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocLapelDesign_appear">${standardFrameCtDisplayUpperPrice["oc_sleeveSpec_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionCoatStandardInfo.ocWaistPktMap[orderCoForm.coOptionCoatStandardInfo.ocWaistPkt]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocWaistPkt_appear">${standardFrameCtDisplayUpperPrice["oc_waistPkt"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionCoatStandardInfo.ocChangePktMap[orderCoForm.coOptionCoatStandardInfo.ocChangePkt]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocChangePkt_appear">${standardFrameCtDisplayUpperPrice["oc_changePkt_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionCoatStandardInfo.ocSlantedPktMap[orderCoForm.coOptionCoatStandardInfo.ocSlantedPkt]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocSlantedPkt_appear">${standardFrameCtDisplayUpperPrice["oc_slantedPkt_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionCoatStandardInfo.ocVentSpecMap[orderCoForm.coOptionCoatStandardInfo.ocVentSpec]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocVentSpec_appear">${standardFrameCtDisplayUpperPrice["oc_ventSpec_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">フロント釦数</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionCoatStandardInfo.ocFrontBtnCntMap[orderCoForm.coOptionCoatStandardInfo.ocFrontBtnCnt]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocFrontBtnCnt_appear">${standardFrameCtDisplayUpperPrice["oc_frontBtnCnt"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionCoatStandardInfo.ocCuffSpecMap[orderCoForm.coOptionCoatStandardInfo.ocCuffSpec]}</label></strong>
						</div>
						<div class="col-12 col-md-1 text-right">
							<strong><label class=" form-control-label-value" id="ocCuffSpec_appear">${standardFrameCtDisplayUpperPrice["oc_cuffSpec"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">袖釦</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="ocSleeveBtnType_appear">${orderCoForm.coOptionCoatStandardInfo.ocSleeveBtnTypeMap[orderCoForm.coOptionCoatStandardInfo.ocSleeveBtnType]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value">${standardFrameCtDisplayUpperPrice["oc_sleeveBtnType"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionCoatStandardInfo.ocBackBeltMap[orderCoForm.coOptionCoatStandardInfo.ocBackBelt]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocBackBelt_appear">${standardFrameCtDisplayUpperPrice["oc_backBelt_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value">${orderCoForm.coOptionCoatStandardInfo.ocChainHangeMap[orderCoForm.coOptionCoatStandardInfo.ocChainHange]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocChainHange_appear">${standardFrameCtDisplayUpperPrice["oc_chainHange_id"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="ocBodyBackMate_name">${standardCtMateSelectMap["ocBodyBackMateStkNo"]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocBodyBackMate_app_appear">${standardFrameCtDisplayUpperPrice["oc_bodyBackMate"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="ocCuffBackMate_name">${standardCtMateSelectMap["ocCuffBackMateStkNo"]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocCuffBackMate_app_appear">${standardFrameCtDisplayUpperPrice["oc_cuffBackMate"]}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
						<div class="col-12 col-md-6">
							<strong><label class=" form-control-label-value" id="ocFrontBtnMate_name">${standardCtMateSelectMap["ocFrontBtnMateStkNo"]}</label></strong>
						</div>
						<div class="col-12 col-md-3 text-right">
							<strong><label class=" form-control-label-value" id="ocFrontBtnMate_app_appear">${standardFrameCtDisplayUpperPrice["oc_frontBtnMate"]}</label></strong>
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
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustCoatStandardInfo.corCtSize}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3"><label class=" form-control-label"><strong>COAT補正</strong></label></div>
						
						<div class="col-12 col-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corCtBodylengthCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corCtWaistCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustCoatStandardInfo.corCtWaistGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈右修正</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corCtRightsleeveCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈左修正</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corCtLeftsleeveCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ベント修正（高さ）</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corCtVenthightCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightGross}</label>cm</strong>
						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ポケット位置</label>
						</div>
						<div class="col-12 col-md-2">
							<strong><label class=" form-control-label-value" id="corCtPktposCorrect"></label>cm</strong>
						</div>
						<div class="col-12 col-md-4">
							<strong><label class=" form-control-label-value">${orderCoForm.coAdjustCoatStandardInfo.corCtPktposGross}</label>cm</strong>
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
								<textarea readonly name="textarea-input" id="textarea-input" rows="3"  class="form-control">${orderCoForm.coAdjustCoatStandardInfo.corCtStoreCorrectionMemo}</textarea>
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
							<button id="coConfirm" type="submit" class="btn btn-primary btn-block" onclick="return imageCheck();"><i class="fa fa-check-circle"></i> 確定</button>
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
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
jQuery("#goBack").click(function(){
	jQuery("#idForm").attr("action", "${pageContext.request.contextPath}/orderCo/orderCoBack");
	jQuery("#coConfirm").click();
})
//オプション内容の表示
var item = jQuery("#product_item").html();
if (item == "SUIT") {
	jQuery('#op_jacket_div').show();
	jQuery('#op_pants_div').show();
	//３Pieceは有り、スペアパンツは有りの場合
	if("${orderCoForm.productIs3Piece}" == '0009902' && "${orderCoForm.productSparePantsClass}" == '0009902'){
		jQuery('#op_jacket_div').show();
		jQuery('#op_gilet_div').show();
		jQuery('#op_pants_div').show();
		jQuery('#op2_pants_div').show();
	}
	//３Pieceは有り、スペアパンツは無しの場合
	else if("${orderCoForm.productIs3Piece}" == '0009902' && "${orderCoForm.productSparePantsClass}" == '0009901'){
		jQuery('#op_jacket_div').show();
		jQuery('#op_gilet_div').show();
		jQuery('#op_pants_div').show();
	}
	//３Pieceは無し、スペアパンツは有りの場合
	else if("${orderCoForm.productIs3Piece}" == '0009901' && "${orderCoForm.productSparePantsClass}"  == '0009902'){
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
jQuery("#status_appear").html(statusList["${orderCoForm.status}"]);

//お客様情報_区分の内容表示
var custType = {01:'一般',02:'社着',03:'サンプル',04:'ゲージ',05:'本社内見会',06:'販売会',07:'作り直し'};
jQuery("#cust_type").html(custType[${orderCoForm.coCustomerMessageInfo.custType}]);

//お客様情報_出荷先の内容表示
var custShippingDestination ={01:'店舗',02:'福山本社',03:'TSC事業本部',04:'お客様',05:'他店舗'};
if("${orderCoForm.coCustomerMessageInfo.custShippingDestination}" == "05" && "${orderCoForm.coCustomerMessageInfo.custShippingDestnationOtherstore}" !=""){
	jQuery("#cust_shipping_destination").html(custShippingDestination[${orderCoForm.coCustomerMessageInfo.custShippingDestination}] + '\xa0\xa0\xa0\xa0\xa0\xa0\xa0' +  "${mapShop[orderCoForm.coCustomerMessageInfo.custShippingDestnationOtherstore]}" );
}
else{
	jQuery("#cust_shipping_destination").html(custShippingDestination[${orderCoForm.coCustomerMessageInfo.custShippingDestination}]);	
}

//承り日は現在の日
if("${orderCoForm.status}" == "" || "${orderCoForm.status}" == "T0" || "${orderCoForm.status}" == "T1"){
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
var custShopDeliveryDate = "${orderCoForm.coCustomerMessageInfo.custShopDeliveryDate}";
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
var measuringList = ["${orderCoForm.coMeasuringInfo.fullLength}",
						"${orderCoForm.coMeasuringInfo.shoulder}",
						"${orderCoForm.coMeasuringInfo.reachRight}",
						"${orderCoForm.coMeasuringInfo.reachLeft}",
						"${orderCoForm.coMeasuringInfo.outBust}",
						"${orderCoForm.coMeasuringInfo.bust}",
						"${orderCoForm.coMeasuringInfo.jacketWaist}",
						"${orderCoForm.coMeasuringInfo.pantsWaist}",
						"${orderCoForm.coMeasuringInfo.hip}",
						"${orderCoForm.coMeasuringInfo.spanRight}",
						"${orderCoForm.coMeasuringInfo.spanLeft}",
						"${orderCoForm.coMeasuringInfo.calfRight}",
						"${orderCoForm.coMeasuringInfo.calfLeft}",
						"${orderCoForm.coMeasuringInfo.neck}"];
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
var result = "${orderCoForm.productComposBodyLiner}";
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

//３Piece
jQuery("#productIs3Piece_appear").html(formatMoney("${priceMap.price3Piece}",0,"￥"));
//スペアパンツ
jQuery("#productSparePantsClass_appear").html(formatMoney("${priceMap.sparePants}",0,"￥"));

//オーダー内容確認画面上部のご請求金額の表示について
jQuery("#header_billingAmount").html(formatMoney("${orderCoForm.billingAmount}",0,""));
jQuery("#header_consumptionTaxAmount").html(formatMoney("${orderCoForm.consumptionTaxAmount}",0,""));
jQuery("#header_productPrice").html(formatMoney("${orderCoForm.productPrice}",0,""));
jQuery("#header_optionPrice").html(formatMoney("${orderCoForm.optionPrice}",0,""));
jQuery("#header_totalPrice").html(formatMoney("${orderCoForm.totalPrice}",0,""));

//オーダー内容確認画面下部のご請求金額の表示について
jQuery("#bottom_billingAmount").html(formatMoney("${orderCoForm.billingAmount}",0,""));
jQuery("#bottom_consumptionTaxAmount").html(formatMoney("${orderCoForm.consumptionTaxAmount}",0,""));
jQuery("#bottom_productPrice").html(formatMoney("${orderCoForm.productPrice}",0,""));
jQuery("#bottom_optionPrice").html(formatMoney("${orderCoForm.optionPrice}",0,""));
jQuery("#bottom_totalPrice").html(formatMoney("${orderCoForm.totalPrice}",0,""));

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

function CorrectChange(correct){
	if(correct != null || correct != ""){
		if(correct.indexOf("-") == -1){
			return "+" + correct;
		}
		else{
			return correct;
		}
	}
	else{
		return "0";
	}
}

//jk着丈修正
var corJkBodyCorrect = "${orderCoForm.coAdjustJacketStandardInfo.corJkBodyCorrect}";
jQuery("#corJkBodyCorrect").html(CorrectChange(corJkBodyCorrect));
//jkウエスト修正
var corJkWaistCorrect = "${orderCoForm.coAdjustJacketStandardInfo.corJkWaistCorrect}";
jQuery("#corJkWaistCorrect").html(CorrectChange(corJkWaistCorrect));
//jk袖丈右修正
var corJkRightsleeveCorrect = "${orderCoForm.coAdjustJacketStandardInfo.corJkRightsleeveCorrect}";
jQuery("#corJkRightsleeveCorrect").html(CorrectChange(corJkRightsleeveCorrect));
//jk袖丈左修正
var corJkLeftsleeveCorrect = "${orderCoForm.coAdjustJacketStandardInfo.corJkLeftsleeveCorrect}";
jQuery("#corJkLeftsleeveCorrect").html(CorrectChange(corJkLeftsleeveCorrect));

//gl着丈修正
var corGlBodyCorrect = "${orderCoForm.coAdjustGiletStandardInfo.corGlBodyCorrect}";
jQuery("#corGlBodyCorrect").html(CorrectChange(corGlBodyCorrect));
//glバスト修正
var corGlBustCorrect = "${orderCoForm.coAdjustGiletStandardInfo.corGlBustCorrect}";
jQuery("#corGlBustCorrect").html(CorrectChange(corGlBustCorrect));
//glウエスト修正
var corGlWaistCorrect = "${orderCoForm.coAdjustGiletStandardInfo.corGlWaistCorrect}";
jQuery("#corGlWaistCorrect").html(CorrectChange(corGlWaistCorrect));

//ptウエスト修正
var corPtWaistCorrect = "${orderCoForm.coAdjustPantsStandardInfo.corPtWaistCorrect}";
jQuery("#corPtWaistCorrect").html(CorrectChange(corPtWaistCorrect));
//ptワタリ修正
var corPtThighCorrect = "${orderCoForm.coAdjustPantsStandardInfo.corPtThighCorrect}";
jQuery("#corPtThighCorrect").html(CorrectChange(corPtThighCorrect));
//ptヒップ修正
var corPtHipCorrect = "${orderCoForm.coAdjustPantsStandardInfo.corPtHipCorrect}";
jQuery("#corPtHipCorrect").html(CorrectChange(corPtHipCorrect));
//pt裾幅修正
var corPtHemwidthCorrect = "${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthCorrect}";
jQuery("#corPtHemwidthCorrect").html(CorrectChange(corPtHemwidthCorrect));

//pt2ウエスト修正
var corPt2WaistCorrect = "${orderCoForm.coAdjustPants2StandardInfo.corPt2WaistCorrect}";
jQuery("#corPt2WaistCorrect").html(CorrectChange(corPt2WaistCorrect));
//pt2ワタリ修正
var corPt2ThighCorrect = "${orderCoForm.coAdjustPants2StandardInfo.corPt2ThighCorrect}";
jQuery("#corPt2ThighCorrect").html(CorrectChange(corPt2ThighCorrect));
//pt2ヒップ修正
var corPt2HipCorrect = "${orderCoForm.coAdjustPants2StandardInfo.corPt2HipCorrect}";
jQuery("#corPt2HipCorrect").html(CorrectChange(corPt2HipCorrect));
//pt2裾幅修正2
var corPt2HemwidthCorrect = "${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthCorrect}";
jQuery("#corPt2HemwidthCorrect").html(CorrectChange(corPt2HemwidthCorrect));

//stネック
var corStNeckCorrect = "${orderCoForm.coAdjustShirtStandardInfo.corStNeckCorrect}";
jQuery("#corStNeckCorrect").html(CorrectChange(corStNeckCorrect));
//st着丈修正
var corStBodylengthCorrect = "${orderCoForm.coAdjustShirtStandardInfo.corStBodylengthCorrect}";
if(corStBodylengthCorrect != null && corStBodylengthCorrect != ""){
	jQuery("#corStBodylengthCorrect").html(CorrectChange(corStBodylengthCorrect));
}
else {
	jQuery("#corStBodylengthCorrect").html('+0');
}

//st袖丈右修正
var corStRightsleeveCorrect = "${orderCoForm.coAdjustShirtStandardInfo.corStRightsleeveCorrect}";
jQuery("#corStRightsleeveCorrect").html(CorrectChange(corStRightsleeveCorrect));
//st袖丈左修正
var corStLeftsleeveCorrect = "${orderCoForm.coAdjustShirtStandardInfo.corStLeftsleeveCorrect}";
jQuery("#corStLeftsleeveCorrect").html(CorrectChange(corStLeftsleeveCorrect));
//st背ダーツ詰め
var corStBackdartsPackCorrect = "${orderCoForm.coAdjustShirtStandardInfo.corStBackdartsPackCorrect}";
jQuery("#corStBackdartsPackCorrect").html(CorrectChange(corStBackdartsPackCorrect));
//stカフス周り右
var corStRightcuffsSurroundingCorrect = "${orderCoForm.coAdjustShirtStandardInfo.corStRightcuffsSurroundingCorrect}";
jQuery("#corStRightcuffsSurroundingCorrect").html(CorrectChange(corStRightcuffsSurroundingCorrect));
//stカフス周り左
var corStLeftcuffsSurroundingCorrect = "${orderCoForm.coAdjustShirtStandardInfo.corStLeftcuffsSurroundingCorrect}";
jQuery("#corStLeftcuffsSurroundingCorrect").html(CorrectChange(corStLeftcuffsSurroundingCorrect));

//ct着丈修正
var corCtBodylengthCorrect = "${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthCorrect}";
jQuery("#corCtBodylengthCorrect").html(CorrectChange(corCtBodylengthCorrect));
//ctウエスト修正
var corCtWaistCorrect = "${orderCoForm.coAdjustCoatStandardInfo.corCtWaistCorrect}";
jQuery("#corCtWaistCorrect").html(CorrectChange(corCtWaistCorrect));
//ct袖丈右修正
var corCtRightsleeveCorrect = "${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveCorrect}";
jQuery("#corCtRightsleeveCorrect").html(CorrectChange(corCtRightsleeveCorrect));
//ct袖丈左修正
var corCtLeftsleeveCorrect = "${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveCorrect}";
jQuery("#corCtLeftsleeveCorrect").html(CorrectChange(corCtLeftsleeveCorrect));
//ctベント修正（高さ）
var corCtVenthightCorrect = "${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightCorrect}";
jQuery("#corCtVenthightCorrect").html(CorrectChange(corCtVenthightCorrect));
//ctポケット位置
var corCtPktposCorrect = "${orderCoForm.coAdjustCoatStandardInfo.corCtPktposCorrect}";
jQuery("#corCtPktposCorrect").html(CorrectChange(corCtPktposCorrect));

//pants股下初期値表示
if("${orderCoForm.coAdjustPantsStandardInfo.corPtLeftinseamGross }" == '' && "${orderCoForm.coAdjustPantsStandardInfo.corPtRightinseamGross }" == ''){
	jQuery("#pantsCorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右 000.0');
	}
else if("${orderCoForm.coAdjustPantsStandardInfo.corPtLeftinseamGross }" == '' && "${orderCoForm.coAdjustPantsStandardInfo.corPtRightinseamGross }" != ''){
	jQuery("#pantsCorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右 ' + "${orderCoForm.coAdjustPantsStandardInfo.corPtRightinseamGross }".TrimStart('0'));
}
else if("${orderCoForm.coAdjustPantsStandardInfo.corPtLeftinseamGross }" != '' && "${orderCoForm.coAdjustPantsStandardInfo.corPtRightinseamGross }" == ''){
	jQuery("#pantsCorinseamGross" ).html('左 ' +"${orderCoForm.coAdjustPantsStandardInfo.corPtLeftinseamGross }".TrimStart('0') + 'cm &nbsp &nbsp &nbsp  右 000.0');
}
else{
	jQuery("#pantsCorinseamGross" ).html('左 ' +"${orderCoForm.coAdjustPantsStandardInfo.corPtLeftinseamGross }".TrimStart('0') + 'cm &nbsp &nbsp &nbsp 右 ' + "${orderCoForm.coAdjustPantsStandardInfo.corPtRightinseamGross }".TrimStart('0'));
	}

//pants2股下初期値表示
if("${orderCoForm.coAdjustPants2StandardInfo.corPt2LeftinseamGross }" == '' && "${orderCoForm.coAdjustPants2StandardInfo.corPt2RightinseamGross }" == ''){
	jQuery("#pants2CorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右000.0');
	}
else if("${orderCoForm.coAdjustPants2StandardInfo.corPt2LeftinseamGross }" == '' && "${orderCoForm.coAdjustPants2StandardInfo.corPt2RightinseamGross }" != ''){
	jQuery("#pants2CorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右 ' + "${orderCoForm.coAdjustPants2StandardInfo.corPt2RightinseamGross }".TrimStart('0'));
}
else if("${orderCoForm.coAdjustPants2StandardInfo.corPt2LeftinseamGross }" != '' && "${orderCoForm.coAdjustPants2StandardInfo.corPt2RightinseamGross }" == ''){
	jQuery("#pants2CorinseamGross" ).html('左 ' +"${orderCoForm.coAdjustPants2StandardInfo.corPt2LeftinseamGross }".TrimStart('0') + 'cm &nbsp &nbsp &nbsp 右000.0');
}
else{
	jQuery("#pants2CorinseamGross" ).html('左 ' +"${orderCoForm.coAdjustPants2StandardInfo.corPt2LeftinseamGross }".TrimStart('0') + 'cm &nbsp &nbsp &nbsp 右 ' + "${orderCoForm.coAdjustPants2StandardInfo.corPt2RightinseamGross }".TrimStart('0'));
	}


//商品情報_ITEM
var itemCode = "${orderCoForm.productItem}";

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
if("${orderCoForm.productCategory}" == '9000101'){
	initStandardComplexOptions();
}

function initStandardComplexOptions(){
	//標準JACKETの内ポケット変更
	var ojInsidePktChange = "${orderCoForm.coOptionJacketStandardInfo.ojInsidePktChangeMap[orderCoForm.coOptionJacketStandardInfo.ojInsidePktChange]}";
	if('有り' == ojInsidePktChange){
		var ojInsidePktPlace1 = "${orderCoForm.coOptionJacketStandardInfo.ojInsidePktPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojInsidePktPlace1]}";
		var ojInsidePktPlace2 = "${orderCoForm.coOptionJacketStandardInfo.ojInsidePktPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojInsidePktPlace2]}";
		var ojInsidePktPlace3 = "${orderCoForm.coOptionJacketStandardInfo.ojInsidePktPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojInsidePktPlace3]}";
		var ojInsidePktPlace4 = "${orderCoForm.coOptionJacketStandardInfo.ojInsidePktPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojInsidePktPlace4]}";
		var ojInsidePktPlace = '';
		if(isEmpty(ojInsidePktPlace1)){
			ojInsidePktPlace = ojInsidePktPlace + ojInsidePktPlace1 + '　　';
		}
		if(isEmpty(ojInsidePktPlace2)){
			ojInsidePktPlace = ojInsidePktPlace + ojInsidePktPlace2 + '　　';
		}
		if(isEmpty(ojInsidePktPlace3)){
			ojInsidePktPlace = ojInsidePktPlace + ojInsidePktPlace3 + '　　';
		}
		if(isEmpty(ojInsidePktPlace4)){
			ojInsidePktPlace = ojInsidePktPlace + ojInsidePktPlace4;
		}
		jQuery("#ojInsidePktChangeAndSubItem").html(ojInsidePktChange + '　　' + ojInsidePktPlace);
	}
	else {
		jQuery("#ojInsidePktChangeAndSubItem").html(ojInsidePktChange);
	}

	//標準JACKETのステッチ箇所変更
	var ojStitchModify = "${orderCoForm.coOptionJacketStandardInfo.ojStitchModifyMap[orderCoForm.coOptionJacketStandardInfo.ojStitchModify]}";
	if(ojStitchModify == '有り'){
		var ojStitchModifyPlace1 = "${orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlace1]}";
		var ojStitchModifyPlace2 = "${orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlace2]}";
		var ojStitchModifyPlace3 = "${orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlace3]}";
		var ojStitchModifyPlace4 = "${orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlace4]}";
		var ojStitchModifyPlace5 = "${orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlace5]}";
		var ojStitchModifyPlace6 = "${orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlace6]}";
		var ojStitchModifyPlace7 = "${orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlace7]}";
		var ojStitchModifyPlace8 = "${orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlace8]}";
		var ojStitchModifyPlace9 = "${orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojStitchModifyPlace9]}";
		var ojStitchModifyPlaceList = [ojStitchModifyPlace1,ojStitchModifyPlace2,ojStitchModifyPlace3,ojStitchModifyPlace4,
			ojStitchModifyPlace5,ojStitchModifyPlace6,ojStitchModifyPlace7,ojStitchModifyPlace8,ojStitchModifyPlace9];
		var ojStitchModifyPlace = '';
		for(var i = 0;i < ojStitchModifyPlaceList.length;i++){
			if(isEmpty(ojStitchModifyPlaceList[i])){
				ojStitchModifyPlace = ojStitchModifyPlace + ojStitchModifyPlaceList[i] + '　　';
			}
		}
		jQuery("#ojStitchModifyPlaceAndSubItem").html(ojStitchModify + '　　' + ojStitchModifyPlace)
	}
	else {
		jQuery("#ojStitchModifyPlaceAndSubItem").html(ojStitchModify)
	}

	//標準JACKETのダブルステッチ変更
	var ojDStitchModify = "${orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyMap[orderCoForm.coOptionJacketStandardInfo.ojDStitchModify]}";
	if(ojDStitchModify == '有り'){
		var ojDStitchModifyPlace1 = "${orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlace1]}";
		var ojDStitchModifyPlace2 = "${orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlace2]}";
		var ojDStitchModifyPlace3 = "${orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlace3]}";
		var ojDStitchModifyPlace4 = "${orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlace4]}";
		var ojDStitchModifyPlace5 = "${orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlace5]}";
		var ojDStitchModifyPlace6 = "${orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlace6]}";
		var ojDStitchModifyPlace7 = "${orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlace7]}";
		var ojDStitchModifyPlace8 = "${orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlace8]}";
		var ojDStitchModifyPlace9 = "${orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojDStitchModifyPlace9]}";

		var ojDStitchModifyPlaceList = [ojDStitchModifyPlace1,ojDStitchModifyPlace2,ojDStitchModifyPlace3,ojDStitchModifyPlace4,
			ojDStitchModifyPlace5,ojDStitchModifyPlace6,ojDStitchModifyPlace7,ojDStitchModifyPlace8,ojDStitchModifyPlace9];
		var ojDStitchModifyPlace = '';
		for(var i = 0;i < ojDStitchModifyPlaceList.length;i++){
			if(isEmpty(ojDStitchModifyPlaceList[i])){
				ojDStitchModifyPlace = ojDStitchModifyPlace + ojDStitchModifyPlaceList[i] + '　　';
			}
		}
		jQuery("#ojDStitchModifyAndSubItem").html(ojDStitchModify　+ '　　' + ojDStitchModifyPlace);
	}
	else {
		jQuery("#ojDStitchModifyAndSubItem").html(ojDStitchModify);
	}

	//標準JACKETのAMF色指定
	var ojAmfColor = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColor]}";
	if(ojAmfColor == '有り'){
		var ojAmfColorPlace1 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlace1]}";
		var ojAmfColorPlace2 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlace2]}";
		var ojAmfColorPlace3 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlace3]}";
		var ojAmfColorPlace4 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlace4]}";
		var ojAmfColorPlace5 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlace5]}";
		var ojAmfColorPlace6 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlace6]}";
		var ojAmfColorPlace7 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlace7]}";
		var ojAmfColorPlace8 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlace8]}";
		var ojAmfColorPlace9 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColorPlace9]}";
		var ojAmfColor1 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorsMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColor1]}";
		var ojAmfColor2 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorsMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColor2]}";
		var ojAmfColor3 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorsMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColor3]}";
		var ojAmfColor4 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorsMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColor4]}";
		var ojAmfColor5 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorsMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColor5]}";
		var ojAmfColor6 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorsMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColor6]}";
		var ojAmfColor7 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorsMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColor7]}";
		var ojAmfColor8 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorsMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColor8]}";
		var ojAmfColor9 = "${orderCoForm.coOptionJacketStandardInfo.ojAmfColorsMap[orderCoForm.coOptionJacketStandardInfo.ojAmfColor9]}";

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
				ojAmfColorPlaceAndColor = ojAmfColorPlaceAndColor + ojAmfColorPlaceAndColorList.activeOjAmfColorPlaceAndColor[i].place + '-' + ojAmfColorPlaceAndColorList.activeOjAmfColorPlaceAndColor[i].color
				+ '　　';
			}
			else if(isEmpty(ojAmfColorPlaceAndColorList.activeOjAmfColorPlaceAndColor[i].place) && (amfFlag == 3 || amfFlag == 6)){
				amfFlag +=1;
				ojAmfColorPlaceAndColor = ojAmfColorPlaceAndColor + "\<br\>　　　　" + ojAmfColorPlaceAndColorList.activeOjAmfColorPlaceAndColor[i].place + '-' + ojAmfColorPlaceAndColorList.activeOjAmfColorPlaceAndColor[i].color + '　　';
			}
		}
		jQuery("#ojAmfColorAndSubItem").html(ojAmfColor + '　　'　+ ojAmfColorPlaceAndColor);
	}
	else {
		jQuery("#ojAmfColorAndSubItem").html(ojAmfColor);
	}

	//標準JACKETのボタンホール色指定
	var ojBhColor = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor]}";
	if(ojBhColor == '有り'){
		var ojBhColorPlace1 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace1]}";
		var ojBhColorPlace2 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace2]}";
		var ojBhColorPlace3 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace3]}";
		var ojBhColorPlace4 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace4]}";
		var ojBhColorPlace5 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace5]}";
		var ojBhColorPlace6 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace6]}";
		var ojBhColorPlace7 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace7]}";
		var ojBhColorPlace8 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace8]}";
		var ojBhColorPlace9 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace9]}";
		var ojBhColorPlace10 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace10]}";
		var ojBhColorPlace11 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace11]}";
		var ojBhColorPlace12 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace12]}";
		var ojBhColorPlace13 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace13]}";
		var ojBhColorPlace14 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace14]}";
		var ojBhColorPlace15 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace15]}";
		var ojBhColorPlace16 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace16]}";
		var ojBhColorPlace17 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojBhColorPlace17]}";

		var ojBhColor1 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor1]}";
		var ojBhColor2 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor2]}";
		var ojBhColor3 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor3]}";
		var ojBhColor4 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor4]}";
		var ojBhColor5 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor5]}";
		var ojBhColor6 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor6]}";
		var ojBhColor7 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor7]}";
		var ojBhColor8 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor8]}";
		var ojBhColor9 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor9]}";
		var ojBhColor10 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor10]}";
		var ojBhColor11 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor11]}";
		var ojBhColor12 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor12]}";
		var ojBhColor13 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor13]}";
		var ojBhColor14 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor14]}";
		var ojBhColor15 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor15]}";
		var ojBhColor16 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor16]}";
		var ojBhColor17 = "${orderCoForm.coOptionJacketStandardInfo.ojBhColorsMap[orderCoForm.coOptionJacketStandardInfo.ojBhColor17]}";

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
				ojBhColorPlaceAndColor = ojBhColorPlaceAndColor + ojBhColorPlaceAndColorList.activeOjBhColorPlaceAndColor[i].place + '-' + ojBhColorPlaceAndColorList.activeOjBhColorPlaceAndColor[i].color
				+ '　　';
			}
			else if(isEmpty(ojBhColorPlaceAndColorList.activeOjBhColorPlaceAndColor[i].place) && (bnFlag == 3 || bnFlag == 6 || bnFlag == 9 || bnFlag == 12 || bnFlag == 15)){
				bnFlag +=1;
				ojBhColorPlaceAndColor = ojBhColorPlaceAndColor + "\<br\>　　　　" + ojBhColorPlaceAndColorList.activeOjBhColorPlaceAndColor[i].place + '-' + ojBhColorPlaceAndColorList.activeOjBhColorPlaceAndColor[i].color + '　　';
			}
		}
		jQuery("#ojBhColorAndSubItem").html(ojBhColor + '　　'　+ ojBhColorPlaceAndColor);
	}
	else {
		jQuery("#ojBhColorAndSubItem").html(ojBhColor);
	}
	
	//標準JACKETのボタン付け糸指定
	var ojByColor = "${orderCoForm.coOptionJacketStandardInfo.ojByColorMap[orderCoForm.coOptionJacketStandardInfo.ojByColor]}";
	if(ojByColor == '有り'){
		var ojByColorPlace1 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace1]}";
		var ojByColorPlace2 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace2]}";
		var ojByColorPlace3 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace3]}";
		var ojByColorPlace4 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace4]}";
		var ojByColorPlace5 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace5]}";
		var ojByColorPlace6 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace6]}";
		var ojByColorPlace7 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace7]}";
		var ojByColorPlace8 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace8]}";
		var ojByColorPlace9 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace9]}";
		var ojByColorPlace10 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace10]}";
		var ojByColorPlace11 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace11]}";
		var ojByColorPlace12 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace12]}";
		var ojByColorPlace13 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace13]}";
		var ojByColorPlace14 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace14]}";
		var ojByColorPlace15 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace15]}";
		var ojByColorPlace16 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorPlaceMap[orderCoForm.coOptionJacketStandardInfo.ojByColorPlace16]}";

		var ojByColor1 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor1]}";
		var ojByColor2 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor2]}";
		var ojByColor3 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor3]}";
		var ojByColor4 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor4]}";
		var ojByColor5 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor5]}";
		var ojByColor6 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor6]}";
		var ojByColor7 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor7]}";
		var ojByColor8 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor8]}";
		var ojByColor9 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor9]}";
		var ojByColor10 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor10]}";
		var ojByColor11 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor11]}";
		var ojByColor12 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor12]}";
		var ojByColor13 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor13]}";
		var ojByColor14 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor14]}";
		var ojByColor15 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor15]}";
		var ojByColor16 = "${orderCoForm.coOptionJacketStandardInfo.ojByColorsMap[orderCoForm.coOptionJacketStandardInfo.ojByColor16]}";

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
				ojByColorPlaceAndColor = ojByColorPlaceAndColor + ojByColorPlaceAndColorList.activeOjByColorPlaceAndColor[i].place + '-' + ojByColorPlaceAndColorList.activeOjByColorPlaceAndColor[i].color
				+ '　　';
			}
			else if(isEmpty(ojByColorPlaceAndColorList.activeOjByColorPlaceAndColor[i].place) && (byFlag == 3 || byFlag == 6 || byFlag == 9 || byFlag == 12 || byFlag == 15)){
				byFlag +=1;
				ojByColorPlaceAndColor = ojByColorPlaceAndColor + "\<br\>　　　　" + ojByColorPlaceAndColorList.activeOjByColorPlaceAndColor[i].place + '-' + ojByColorPlaceAndColorList.activeOjByColorPlaceAndColor[i].color + '　　';
			}
		}
		jQuery("#ojByColorAndSubItem").html(ojByColor + '　　' +　ojByColorPlaceAndColor);
	}
	else {
		jQuery("#ojByColorAndSubItem").html(ojByColor);
	}
	

	//標準Pantsのベルトループ 
	var opBeltLoop = "${orderCoForm.coOptionPantsStandardInfo.opBeltLoopMap[orderCoForm.coOptionPantsStandardInfo.opBeltLoop]}";
	if(opBeltLoop == '有り'){
		var opBeltLoopPlace1 = "${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlaceMap[orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace1]}";
		var opBeltLoopPlace2 = "${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlaceMap[orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace2]}";
		var opBeltLoopPlace3 = "${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlaceMap[orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace3]}";
		var opBeltLoopPlace4 = "${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlaceMap[orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace4]}";
		var opBeltLoopPlace5 = "${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlaceMap[orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace5]}";
		var opBeltLoopPlace6 = "${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlaceMap[orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace6]}";
		var opBeltLoopPlace7 = "${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlaceMap[orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace7]}";

		var opBeltLoopPlaceList = [opBeltLoopPlace1,opBeltLoopPlace2,opBeltLoopPlace3,opBeltLoopPlace4,opBeltLoopPlace5,opBeltLoopPlace6,opBeltLoopPlace7];

		var opBeltLoopPlace = '';
		for(var i = 0;i < opBeltLoopPlaceList.length;i++){
			if(isEmpty(opBeltLoopPlaceList[i])){
				opBeltLoopPlace = opBeltLoopPlace + opBeltLoopPlaceList[i] + '　　';
			}
		}
		jQuery("#opBeltLoopAndSubItem").html(opBeltLoop　+ '　　' + opBeltLoopPlace);
	}
	else {
		jQuery("#opBeltLoopAndSubItem").html(opBeltLoop);
	}

	//標準Pantsのステッチ箇所変更
	var opStitchModify = "${orderCoForm.coOptionPantsStandardInfo.opStitchModifyMap[orderCoForm.coOptionPantsStandardInfo.opStitchModify]}";
	if(opStitchModify == '有り'){
		var opStitchModifyPlace1 = "${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlaceMap[orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace1]}";
		var opStitchModifyPlace2 = "${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlaceMap[orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace2]}";
		var opStitchModifyPlace3 = "${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlaceMap[orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace3]}";
		var opStitchModifyPlace4 = "${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlaceMap[orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace4]}";

		var opStitchModifyPlaceList = [opStitchModifyPlace1,opStitchModifyPlace2,opStitchModifyPlace3,opStitchModifyPlace4];
		var opStitchModifyPlace = '';
		for(var i = 0;i < opStitchModifyPlaceList.length;i++){
			if(isEmpty(opStitchModifyPlaceList[i])){
				opStitchModifyPlace = opStitchModifyPlace + opStitchModifyPlaceList[i] + '　　';
			}
		}
		jQuery("#opStitchModifyAndSubItem").html(opStitchModify + '　　' + opStitchModifyPlace);
	}
	else {
		jQuery("#opStitchModifyAndSubItem").html(opStitchModify);
	}

	//標準Pantsのダブルステッチ
	var opDStitch = "${orderCoForm.coOptionPantsStandardInfo.opDStitchMap[orderCoForm.coOptionPantsStandardInfo.opDStitch]}";
	if(opDStitch == '有り'){
		var opDStitchPlace1 = "${orderCoForm.coOptionPantsStandardInfo.opDStitchPlaceMap[orderCoForm.coOptionPantsStandardInfo.opDStitchPlace1]}";
		var opDStitchPlace2 = "${orderCoForm.coOptionPantsStandardInfo.opDStitchPlaceMap[orderCoForm.coOptionPantsStandardInfo.opDStitchPlace2]}";
		var opDStitchPlace3 = "${orderCoForm.coOptionPantsStandardInfo.opDStitchPlaceMap[orderCoForm.coOptionPantsStandardInfo.opDStitchPlace3]}";
		var opDStitchPlace4 = "${orderCoForm.coOptionPantsStandardInfo.opDStitchPlaceMap[orderCoForm.coOptionPantsStandardInfo.opDStitchPlace4]}";

		var opDStitchPlaceList = [opDStitchPlace1,opDStitchPlace2,opDStitchPlace3,opDStitchPlace4];
		var opDStitchPlace = '';
		for(var i = 0;i < opDStitchPlaceList.length;i++){
			if(isEmpty(opDStitchPlaceList[i])){
				opDStitchPlace = opDStitchPlace + opDStitchPlaceList[i] + '　　';
			}
		}
		jQuery("#opDStitchAndSubItem").html(opDStitch + '　　' + opDStitchPlace);
	}
	else {
		jQuery("#opDStitchAndSubItem").html(opDStitch);
	}

	//標準PantsのAMF色指定
	var opAmfColor = "${orderCoForm.coOptionPantsStandardInfo.opAmfColorMap[orderCoForm.coOptionPantsStandardInfo.opAmfColor]}";
	if(opAmfColor == '有り'){
		var opAmfColorPlace1 = "${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlaceMap[orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace1]}";
		var opAmfColorPlace2 = "${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlaceMap[orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace2]}";
		var opAmfColorPlace3 = "${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlaceMap[orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace3]}";
		var opAmfColorPlace4 = "${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlaceMap[orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace4]}";

		var opAmfColor1 = "${orderCoForm.coOptionPantsStandardInfo.opAmfColorsMap[orderCoForm.coOptionPantsStandardInfo.opAmfColor1]}";
		var opAmfColor2 = "${orderCoForm.coOptionPantsStandardInfo.opAmfColorsMap[orderCoForm.coOptionPantsStandardInfo.opAmfColor2]}";
		var opAmfColor3 = "${orderCoForm.coOptionPantsStandardInfo.opAmfColorsMap[orderCoForm.coOptionPantsStandardInfo.opAmfColor3]}";
		var opAmfColor4 = "${orderCoForm.coOptionPantsStandardInfo.opAmfColorsMap[orderCoForm.coOptionPantsStandardInfo.opAmfColor4]}";

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
				opAmfColorPlaceAndColor = opAmfColorPlaceAndColor + opAmfColorPlaceAndColorList.activeOpAmfColorPlaceAndColor[i].place + '-' + opAmfColorPlaceAndColorList.activeOpAmfColorPlaceAndColor[i].color
				+ '　　';
			}
			else if(isEmpty(opAmfColorPlaceAndColorList.activeOpAmfColorPlaceAndColor[i].place) && opAmfFlag == 3){
				opAmfFlag += 1;
				opAmfColorPlaceAndColor = opAmfColorPlaceAndColor + "\<br\>　　　　" + opAmfColorPlaceAndColorList.activeOpAmfColorPlaceAndColor[i].place + '-' + opAmfColorPlaceAndColorList.activeOpAmfColorPlaceAndColor[i].color + '　　';
			}
		}
		jQuery("#opAmfColorAndSubItem").html(opAmfColor + '　　'　 + opAmfColorPlaceAndColor);
	}
	else {
		jQuery("#opAmfColorAndSubItem").html(opAmfColor);
	}

	//標準Pantsのボタンホール色指定
	var opBhColor = "${orderCoForm.coOptionPantsStandardInfo.opBhColorMap[orderCoForm.coOptionPantsStandardInfo.opBhColor]}";
	if(opBhColor == '有り'){
		var opBhColorPlace1 = "${orderCoForm.coOptionPantsStandardInfo.opBhColorPlaceMap[orderCoForm.coOptionPantsStandardInfo.opBhColorPlace1]}";
		var opBhColorPlace2 = "${orderCoForm.coOptionPantsStandardInfo.opBhColorPlaceMap[orderCoForm.coOptionPantsStandardInfo.opBhColorPlace2]}";
		var opBhColorPlace3 = "${orderCoForm.coOptionPantsStandardInfo.opBhColorPlaceMap[orderCoForm.coOptionPantsStandardInfo.opBhColorPlace3]}";
		var opBhColorPlace4 = "${orderCoForm.coOptionPantsStandardInfo.opBhColorPlaceMap[orderCoForm.coOptionPantsStandardInfo.opBhColorPlace4]}";

		var opBhColor1 = "${orderCoForm.coOptionPantsStandardInfo.opBhColorsMap[orderCoForm.coOptionPantsStandardInfo.opBhColor1]}";
		var opBhColor2 = "${orderCoForm.coOptionPantsStandardInfo.opBhColorsMap[orderCoForm.coOptionPantsStandardInfo.opBhColor2]}";
		var opBhColor3 = "${orderCoForm.coOptionPantsStandardInfo.opBhColorsMap[orderCoForm.coOptionPantsStandardInfo.opBhColor3]}";
		var opBhColor4 = "${orderCoForm.coOptionPantsStandardInfo.opBhColorsMap[orderCoForm.coOptionPantsStandardInfo.opBhColor4]}";

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
				opBhColorPlaceAndColor = opBhColorPlaceAndColor + opBhColorPlaceAndColorList.activeOpBhColorPlaceAndColor[i].place + '-'　+ opBhColorPlaceAndColorList.activeOpBhColorPlaceAndColor[i].color
				+ '　　';
			}
			else if(isEmpty(opBhColorPlaceAndColorList.activeOpBhColorPlaceAndColor[i].place) && opBhFlag ==3){
				opBhFlag += 1;
				opBhColorPlaceAndColor = opBhColorPlaceAndColor + "\<br\>　　　　" + opBhColorPlaceAndColorList.activeOpBhColorPlaceAndColor[i].place + '-'　+ opBhColorPlaceAndColorList.activeOpBhColorPlaceAndColor[i].color + '　　';
			}
		}
		jQuery("#opBhColorAndSubItem").html(opBhColor + '　　' + opBhColorPlaceAndColor);
	}
	else {
		jQuery("#opBhColorAndSubItem").html(opBhColor);
	}
	

	//標準Pantsのボタン付け糸指定
	var opByColor = "${orderCoForm.coOptionPantsStandardInfo.opByColorMap[orderCoForm.coOptionPantsStandardInfo.opByColor]}";
	if(opByColor == '有り'){
		var opByColorPlace1 = "${orderCoForm.coOptionPantsStandardInfo.opByColorPlaceMap[orderCoForm.coOptionPantsStandardInfo.opByColorPlace1]}";
		var opByColorPlace2 = "${orderCoForm.coOptionPantsStandardInfo.opByColorPlaceMap[orderCoForm.coOptionPantsStandardInfo.opByColorPlace2]}";
		var opByColorPlace3 = "${orderCoForm.coOptionPantsStandardInfo.opByColorPlaceMap[orderCoForm.coOptionPantsStandardInfo.opByColorPlace3]}";
		var opByColorPlace4 = "${orderCoForm.coOptionPantsStandardInfo.opByColorPlaceMap[orderCoForm.coOptionPantsStandardInfo.opByColorPlace4]}";

		var opByColor1 = "${orderCoForm.coOptionPantsStandardInfo.opByColorsMap[orderCoForm.coOptionPantsStandardInfo.opByColor1]}";
		var opByColor2 = "${orderCoForm.coOptionPantsStandardInfo.opByColorsMap[orderCoForm.coOptionPantsStandardInfo.opByColor2]}";
		var opByColor3 = "${orderCoForm.coOptionPantsStandardInfo.opByColorsMap[orderCoForm.coOptionPantsStandardInfo.opByColor3]}";
		var opByColor4 = "${orderCoForm.coOptionPantsStandardInfo.opByColorsMap[orderCoForm.coOptionPantsStandardInfo.opByColor4]}";

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
				opByColorPlaceAndColor = opByColorPlaceAndColor + opByColorPlaceAndColorList.activeOpByColorPlaceAndColor[i].place + '-' +  opByColorPlaceAndColorList.activeOpByColorPlaceAndColor[i].color
				+ '　　';
			}
			else if(isEmpty(opByColorPlaceAndColorList.activeOpByColorPlaceAndColor[i].place) && opByFlag == 3){
				opByFlag += 1;
				opByColorPlaceAndColor = opByColorPlaceAndColor + "\<br\>　　　　" + opByColorPlaceAndColorList.activeOpByColorPlaceAndColor[i].place + '-' +  opByColorPlaceAndColorList.activeOpByColorPlaceAndColor[i].color + '　　';
			}
		}
		jQuery("#opByColorAndSubItem").html(opByColor + '　　' +　opByColorPlaceAndColor);
	}
	else {
		jQuery("#opByColorAndSubItem").html(opByColor);
	}

	//標準Giletのステッチ箇所変更
	var ogStitchModify = "${orderCoForm.coOptionGiletStandardInfo.ogStitchModifyMap[orderCoForm.coOptionGiletStandardInfo.ogStitchModify]}";
	if(ogStitchModify == '有り'){
		var ogStitchModifyPlace1 = "${orderCoForm.coOptionGiletStandardInfo.ogStitchModifyPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogStitchModifyPlace1]}";
		var ogStitchModifyPlace2 = "${orderCoForm.coOptionGiletStandardInfo.ogStitchModifyPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogStitchModifyPlace2]}";
		var ogStitchModifyPlace3 = "${orderCoForm.coOptionGiletStandardInfo.ogStitchModifyPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogStitchModifyPlace3]}";

		var ogStitchModifyPlaceList = [ogStitchModifyPlace1,ogStitchModifyPlace2,ogStitchModifyPlace3];
		var ogStitchModifyPlace = '';
		for(var i = 0;i < ogStitchModifyPlaceList.length;i++){
			if(isEmpty(ogStitchModifyPlaceList[i])){
				ogStitchModifyPlace = ogStitchModifyPlace + ogStitchModifyPlaceList[i] + '　　';
			}
		}
		jQuery("#ogStitchModifyAndSubItem").html(ogStitchModify + '　　' + ogStitchModifyPlace);
	}
	else {
		jQuery("#ogStitchModifyAndSubItem").html(ogStitchModify);
	}

	//標準Giletのダブルステッチ
	var ogDStitchModify = "${orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyMap[orderCoForm.coOptionGiletStandardInfo.ogDStitchModify]}";
	if(ogDStitchModify == '有り'){
		var ogDStitchModifyPlace1 = "${orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyPlace1]}";
		var ogDStitchModifyPlace2 = "${orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyPlace2]}";
		var ogDStitchModifyPlace3 = "${orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyPlace3]}";

		var ogDStitchModifyPlaceList = [ogDStitchModifyPlace1,ogDStitchModifyPlace2,ogDStitchModifyPlace3];
		var ogDStitchModifyPlace = '';
		for(var i =0;i < ogDStitchModifyPlaceList.length;i++){
			if(isEmpty(ogDStitchModifyPlaceList[i])){
				ogDStitchModifyPlace = ogDStitchModifyPlace + ogDStitchModifyPlaceList[i] + '　　';
			}
		}
		jQuery("#ogDStitchModifyAndSubItem").html(ogDStitchModify + '　　' + ogDStitchModifyPlace);
	}
	else {
		jQuery("#ogDStitchModifyAndSubItem").html(ogDStitchModify);
	}

	//標準GiletのAMF色指定
	var ogAmfColor = "${orderCoForm.coOptionGiletStandardInfo.ogAmfColorMap[orderCoForm.coOptionGiletStandardInfo.ogAmfColor]}";
	if(ogAmfColor == '有り'){
		var ogAmfColorPlace1 = "${orderCoForm.coOptionGiletStandardInfo.ogAmfColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogAmfColorPlace1]}";
		var ogAmfColorPlace2 = "${orderCoForm.coOptionGiletStandardInfo.ogAmfColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogAmfColorPlace2]}";
		var ogAmfColorPlace3 = "${orderCoForm.coOptionGiletStandardInfo.ogAmfColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogAmfColorPlace3]}";

		var ogAmfColor1 = "${orderCoForm.coOptionGiletStandardInfo.ogAmfColorsMap[orderCoForm.coOptionGiletStandardInfo.ogAmfColor1]}";
		var ogAmfColor2 = "${orderCoForm.coOptionGiletStandardInfo.ogAmfColorsMap[orderCoForm.coOptionGiletStandardInfo.ogAmfColor2]}";
		var ogAmfColor3 = "${orderCoForm.coOptionGiletStandardInfo.ogAmfColorsMap[orderCoForm.coOptionGiletStandardInfo.ogAmfColor3]}";

		var ogAmfColorPlaceAndColorList = {
				activeOgAmfColorPlaceAndColor : [{"place":ogAmfColorPlace1,"color":ogAmfColor1},
					{"place":ogAmfColorPlace2,"color":ogAmfColor2},
					{"place":ogAmfColorPlace3,"color":ogAmfColor3}]
		};
		var ogAmfColorPlaceAndColor = '';
		for(var i = 0;i < ogAmfColorPlaceAndColorList.activeOgAmfColorPlaceAndColor.length;i++){
			if(isEmpty(ogAmfColorPlaceAndColorList.activeOgAmfColorPlaceAndColor[i].place)){
				ogAmfColorPlaceAndColor = ogAmfColorPlaceAndColor + ogAmfColorPlaceAndColorList.activeOgAmfColorPlaceAndColor[i].place + '-' + ogAmfColorPlaceAndColorList.activeOgAmfColorPlaceAndColor[i].color + '　　';
			}
		}
		jQuery("#ogAmfColorAndSubItem").html(ogAmfColor + '　　' + ogAmfColorPlaceAndColor);
	}
	else {
		jQuery("#ogAmfColorAndSubItem").html(ogAmfColor);
	}

	//標準Giletのボタンホール色指定
	var ogBhColor = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorMap[orderCoForm.coOptionGiletStandardInfo.ogBhColor]}";
	if(ogBhColor == '有り'){
		var ogBhColorPlace1 = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogBhColorPlace1]}";
		var ogBhColorPlace2 = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogBhColorPlace2]}";
		var ogBhColorPlace3 = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogBhColorPlace3]}";
		var ogBhColorPlace4 = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogBhColorPlace4]}";
		var ogBhColorPlace5 = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogBhColorPlace5]}";
		var ogBhColorPlace6 = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogBhColorPlace6]}";

		var ogBhColor1 = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorsMap[orderCoForm.coOptionGiletStandardInfo.ogBhColor1]}";
		var ogBhColor2 = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorsMap[orderCoForm.coOptionGiletStandardInfo.ogBhColor2]}";
		var ogBhColor3 = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorsMap[orderCoForm.coOptionGiletStandardInfo.ogBhColor3]}";
		var ogBhColor4 = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorsMap[orderCoForm.coOptionGiletStandardInfo.ogBhColor4]}";
		var ogBhColor5 = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorsMap[orderCoForm.coOptionGiletStandardInfo.ogBhColor5]}";
		var ogBhColor6 = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorsMap[orderCoForm.coOptionGiletStandardInfo.ogBhColor6]}";

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
				ogBhColorPlaceAndColor = ogBhColorPlaceAndColor + ogBhColorPlaceAndColorList.activeOgBhColorPlaceAndColor[i].place + '-' + ogBhColorPlaceAndColorList.activeOgBhColorPlaceAndColor[i].color
				+ '　　';
			}
			else if (isEmpty(ogBhColorPlaceAndColorList.activeOgBhColorPlaceAndColor[i].place) && ogBhFlag == 3){
				ogBhFlag += 1;
				ogBhColorPlaceAndColor = ogBhColorPlaceAndColor + "\<br\>　　　　" + ogBhColorPlaceAndColorList.activeOgBhColorPlaceAndColor[i].place + '-' + ogBhColorPlaceAndColorList.activeOgBhColorPlaceAndColor[i].color + '　　'
				;
			}
		}
		jQuery("#ogBhColorAndSubItem").html(ogBhColor + '　　' + ogBhColorPlaceAndColor);
	}
	else {
		jQuery("#ogBhColorAndSubItem").html(ogBhColor);
	}

	//標準Giletのボタン付け糸指定
	var ogByColor = "${orderCoForm.coOptionGiletStandardInfo.ogByColorMap[orderCoForm.coOptionGiletStandardInfo.ogByColor]}"; 
	if(ogByColor == '有り'){
		var ogByColorPlace1 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogByColorPlace1]}"; 
		var ogByColorPlace2 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogByColorPlace2]}"; 
		var ogByColorPlace3 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogByColorPlace3]}"; 
		var ogByColorPlace4 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogByColorPlace4]}"; 
		var ogByColorPlace5 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogByColorPlace5]}"; 
		var ogByColorPlace6 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogByColorPlace6]}"; 
		var ogByColorPlace7 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogByColorPlace7]}"; 
		var ogByColorPlace8 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogByColorPlace8]}"; 
		var ogByColorPlace9 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogByColorPlace9]}"; 
		var ogByColorPlace10 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorPlaceMap[orderCoForm.coOptionGiletStandardInfo.ogByColorPlace10]}"; 

		var ogByColor1 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorsMap[orderCoForm.coOptionGiletStandardInfo.ogByColor1]}"; 
		var ogByColor2 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorsMap[orderCoForm.coOptionGiletStandardInfo.ogByColor2]}"; 
		var ogByColor3 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorsMap[orderCoForm.coOptionGiletStandardInfo.ogByColor3]}"; 
		var ogByColor4 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorsMap[orderCoForm.coOptionGiletStandardInfo.ogByColor4]}"; 
		var ogByColor5 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorsMap[orderCoForm.coOptionGiletStandardInfo.ogByColor5]}"; 
		var ogByColor6 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorsMap[orderCoForm.coOptionGiletStandardInfo.ogByColor6]}"; 
		var ogByColor7 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorsMap[orderCoForm.coOptionGiletStandardInfo.ogByColor7]}"; 
		var ogByColor8 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorsMap[orderCoForm.coOptionGiletStandardInfo.ogByColor8]}"; 
		var ogByColor9 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorsMap[orderCoForm.coOptionGiletStandardInfo.ogByColor9]}"; 
		var ogByColor10 = "${orderCoForm.coOptionGiletStandardInfo.ogByColorsMap[orderCoForm.coOptionGiletStandardInfo.ogByColor10]}"; 

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
				ogByColorPlaceAndColor = ogByColorPlaceAndColor + ogByColorPlaceAndColorList.activeOgByColorPlaceAndColor[i].place + '-' + ogByColorPlaceAndColorList.activeOgByColorPlaceAndColor[i].color
				+ '　　';
			}
			else if(isEmpty(ogByColorPlaceAndColorList.activeOgByColorPlaceAndColor[i].place) && (ogByFlag != 3 || ogByFlag != 6 || ogByFlag != 9)){
				ogByFlag += 1;
				ogByColorPlaceAndColor = ogByColorPlaceAndColor + "\<br\>　　　　" + ogByColorPlaceAndColorList.activeOgByColorPlaceAndColor[i].place + '-' + ogByColorPlaceAndColorList.activeOgByColorPlaceAndColor[i].color + '　　';
			}
		}
		jQuery("#ogByColorAndSubItem").html(ogByColor + '　　' + ogByColorPlaceAndColor);
	}
	else {
		jQuery("#ogByColorAndSubItem").html(ogByColor);
	}

	//標準2PANTSのベルトループ
	var op2BeltLoop = "${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopMap[orderCoForm.coOptionPants2StandardInfo.op2BeltLoop]}";
	if(op2BeltLoop == '有り'){
		var op2BeltLoopPlace1 = "${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace1]}";
		var op2BeltLoopPlace2 = "${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace2]}";
		var op2BeltLoopPlace3 = "${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace3]}";
		var op2BeltLoopPlace4 = "${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace4]}";
		var op2BeltLoopPlace5 = "${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace5]}";
		var op2BeltLoopPlace6 = "${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace6]}";
		var op2BeltLoopPlace7 = "${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace7]}";

		var op2BeltLoopPlaceList = [op2BeltLoopPlace1,op2BeltLoopPlace2,op2BeltLoopPlace3,op2BeltLoopPlace4,op2BeltLoopPlace5,op2BeltLoopPlace6,op2BeltLoopPlace7];
		var op2BeltLoopPlace = '';
		for(var i = 0;i < op2BeltLoopPlaceList.length;i++){
			if(isEmpty(op2BeltLoopPlaceList[i])){
				op2BeltLoopPlace = op2BeltLoopPlace + op2BeltLoopPlaceList[i] + '　　';
			}
		}
		jQuery("#op2BeltLoopAndSubItem").html(op2BeltLoop　+ '　　' +　op2BeltLoopPlace);
	}
	else {
		jQuery("#op2BeltLoopAndSubItem").html(op2BeltLoop);
	}

	//標準2PANTSのステッチ箇所変更
	var op2StitchModify = "${orderCoForm.coOptionPants2StandardInfo.op2StitchModifyMap[orderCoForm.coOptionPants2StandardInfo.op2StitchModify]}";
	if(op2StitchModify == '有り'){
		var op2StitchModifyPlace1 = "${orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlace1]}";
		var op2StitchModifyPlace2 = "${orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlace2]}";
		var op2StitchModifyPlace3 = "${orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlace3]}";
		var op2StitchModifyPlace4 = "${orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlace4]}";

		var op2StitchModifyPlaceList = [op2StitchModifyPlace1,op2StitchModifyPlace2,op2StitchModifyPlace3,op2StitchModifyPlace4];
		var op2StitchModifyPlace = '';
		for(var i = 0;i < op2StitchModifyPlaceList.length;i++){
			if(isEmpty(op2StitchModifyPlaceList[i])){
				op2StitchModifyPlace = op2StitchModifyPlace + op2StitchModifyPlaceList[i] + '　　';
			}
		}
		jQuery("#op2StitchModifyAndSubItem").html(op2StitchModify + '　　' + op2StitchModifyPlace);
	}
	else {
		jQuery("#op2StitchModifyAndSubItem").html(op2StitchModify);
	}

	//標準2PANTSのダブルステッチ
	var op2DStitch = "${orderCoForm.coOptionPants2StandardInfo.op2DStitchMap[orderCoForm.coOptionPants2StandardInfo.op2DStitch]}";
	if(op2DStitch == '有り'){
		var op2DStitchPlace1 = "${orderCoForm.coOptionPants2StandardInfo.op2DStitchPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2DStitchPlace1]}";
		var op2DStitchPlace2 = "${orderCoForm.coOptionPants2StandardInfo.op2DStitchPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2DStitchPlace2]}";
		var op2DStitchPlace3 = "${orderCoForm.coOptionPants2StandardInfo.op2DStitchPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2DStitchPlace3]}";
		var op2DStitchPlace4 = "${orderCoForm.coOptionPants2StandardInfo.op2DStitchPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2DStitchPlace4]}";

		var op2DStitchPlaceList = [op2DStitchPlace1,op2DStitchPlace2,op2DStitchPlace3,op2DStitchPlace4];
		var op2DStitchPlace = '';
		for(var i =0;i < op2DStitchPlaceList.length;i++){
			if(isEmpty(op2DStitchPlaceList[i])){
				op2DStitchPlace = op2DStitchPlace + op2DStitchPlaceList[i] + '　　';
			}
		}
		jQuery("#op2DStitchAndSubItem").html(op2DStitch + '　　' + op2DStitchPlace);
	}
	else {
		jQuery("#op2DStitchAndSubItem").html(op2DStitch);
	}

	//標準2PANTSのAMF色指定
	var op2AmfColor = "${orderCoForm.coOptionPants2StandardInfo.op2AmfColorMap[orderCoForm.coOptionPants2StandardInfo.op2AmfColor]}";
	if(op2AmfColor == '有り'){
		var op2AmfColorPlace1 = "${orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlace1]}";
		var op2AmfColorPlace2 = "${orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlace2]}";
		var op2AmfColorPlace3 = "${orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlace3]}";
		var op2AmfColorPlace4 = "${orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlace4]}";

		var op2AmfColor1 = "${orderCoForm.coOptionPants2StandardInfo.op2AmfColorsMap[orderCoForm.coOptionPants2StandardInfo.op2AmfColor1]}";
		var op2AmfColor2 = "${orderCoForm.coOptionPants2StandardInfo.op2AmfColorsMap[orderCoForm.coOptionPants2StandardInfo.op2AmfColor2]}";
		var op2AmfColor3 = "${orderCoForm.coOptionPants2StandardInfo.op2AmfColorsMap[orderCoForm.coOptionPants2StandardInfo.op2AmfColor3]}";
		var op2AmfColor4 = "${orderCoForm.coOptionPants2StandardInfo.op2AmfColorsMap[orderCoForm.coOptionPants2StandardInfo.op2AmfColor4]}";

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
				op2AmfColorPlaceAndColor = op2AmfColorPlaceAndColor + op2AmfColorPlaceAndColorList.activeOp2AmfColorPlaceAndColor[i].place + '-' + op2AmfColorPlaceAndColorList.activeOp2AmfColorPlaceAndColor[i].color
				+ '　　';
			}
			else if(isEmpty(op2AmfColorPlaceAndColorList.activeOp2AmfColorPlaceAndColor[i].place)　&& op2AmfFlag == 3){
				op2AmfFlag += 1;
				op2AmfColorPlaceAndColor = op2AmfColorPlaceAndColor + "\<br\>　　　　" + op2AmfColorPlaceAndColorList.activeOp2AmfColorPlaceAndColor[i].place + '-' + op2AmfColorPlaceAndColorList.activeOp2AmfColorPlaceAndColor[i].color + '　　';
			}
		}
		jQuery("#op2AmfColorAndSubItem").html(op2AmfColor + '　　' + op2AmfColorPlaceAndColor);
	}
	else {
		jQuery("#op2AmfColorAndSubItem").html(op2AmfColor);
	}

	//標準2PANTSのボタンホール色指定
	var op2BhColor = "${orderCoForm.coOptionPants2StandardInfo.op2BhColorMap[orderCoForm.coOptionPants2StandardInfo.op2BhColor]}";
	if(op2BhColor == '有り'){
		var op2BhColorPlace1 = "${orderCoForm.coOptionPants2StandardInfo.op2BhColorPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2BhColorPlace1]}";
		var op2BhColorPlace2 = "${orderCoForm.coOptionPants2StandardInfo.op2BhColorPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2BhColorPlace2]}";
		var op2BhColorPlace3 = "${orderCoForm.coOptionPants2StandardInfo.op2BhColorPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2BhColorPlace3]}";
		var op2BhColorPlace4 = "${orderCoForm.coOptionPants2StandardInfo.op2BhColorPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2BhColorPlace4]}";

		var op2BhColor1 = "${orderCoForm.coOptionPants2StandardInfo.op2BhColorsMap[orderCoForm.coOptionPants2StandardInfo.op2BhColor1]}";
		var op2BhColor2 = "${orderCoForm.coOptionPants2StandardInfo.op2BhColorsMap[orderCoForm.coOptionPants2StandardInfo.op2BhColor2]}";
		var op2BhColor3 = "${orderCoForm.coOptionPants2StandardInfo.op2BhColorsMap[orderCoForm.coOptionPants2StandardInfo.op2BhColor3]}";
		var op2BhColor4 = "${orderCoForm.coOptionPants2StandardInfo.op2BhColorsMap[orderCoForm.coOptionPants2StandardInfo.op2BhColor4]}";

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
				op2BhColorPlaceAndColor = op2BhColorPlaceAndColor + op2BhColorPlaceAndColorList.activeOp2BhColorPlaceAndColor[i].place + '-' + op2BhColorPlaceAndColorList.activeOp2BhColorPlaceAndColor[i].color
				+ '　　'; 
			}
			else if(isEmpty(op2BhColorPlaceAndColorList.activeOp2BhColorPlaceAndColor[i].place) && op2BhFlag == 3){
				op2BhFlag　+= 1;
				op2BhColorPlaceAndColor = op2BhColorPlaceAndColor + "\<br\>　　　　" + op2BhColorPlaceAndColorList.activeOp2BhColorPlaceAndColor[i].place + '-' + op2BhColorPlaceAndColorList.activeOp2BhColorPlaceAndColor[i].color + '　　'; 
			}
		}
		jQuery("#op2BhColorAndSubItem").html(op2BhColor + '　　' + op2BhColorPlaceAndColor);
	}
	else {
		jQuery("#op2BhColorAndSubItem").html(op2BhColor);
	}

	//標準2PANTSのボタン付け糸指定
	var op2ByColor = "${orderCoForm.coOptionPants2StandardInfo.op2ByColorMap[orderCoForm.coOptionPants2StandardInfo.op2ByColor]}";
	if(op2ByColor == '有り'){
		var op2ByColorPlace1 = "${orderCoForm.coOptionPants2StandardInfo.op2ByColorPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2ByColorPlace1]}";
		var op2ByColorPlace2 = "${orderCoForm.coOptionPants2StandardInfo.op2ByColorPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2ByColorPlace2]}";
		var op2ByColorPlace3 = "${orderCoForm.coOptionPants2StandardInfo.op2ByColorPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2ByColorPlace3]}";
		var op2ByColorPlace4 = "${orderCoForm.coOptionPants2StandardInfo.op2ByColorPlaceMap[orderCoForm.coOptionPants2StandardInfo.op2ByColorPlace4]}";

		var op2ByColor1 = "${orderCoForm.coOptionPants2StandardInfo.op2ByColorsMap[orderCoForm.coOptionPants2StandardInfo.op2ByColor1]}";
		var op2ByColor2 = "${orderCoForm.coOptionPants2StandardInfo.op2ByColorsMap[orderCoForm.coOptionPants2StandardInfo.op2ByColor2]}";
		var op2ByColor3 = "${orderCoForm.coOptionPants2StandardInfo.op2ByColorsMap[orderCoForm.coOptionPants2StandardInfo.op2ByColor3]}";
		var op2ByColor4 = "${orderCoForm.coOptionPants2StandardInfo.op2ByColorsMap[orderCoForm.coOptionPants2StandardInfo.op2ByColor4]}";

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
				op2ByColorPlaceAndColor = op2ByColorPlaceAndColor + op2ByColorPlaceAndColorList.activeOp2ByColorPlaceAndColor[i].place + '-' + op2ByColorPlaceAndColorList.activeOp2ByColorPlaceAndColor[i].color
				+ '　　';
			}
			else if(isEmpty(op2ByColorPlaceAndColorList.activeOp2ByColorPlaceAndColor[i].place) && op2ByFlag == 3){
				op2ByFlag += 1;
				op2ByColorPlaceAndColor = op2ByColorPlaceAndColor + "\<br\>　　　　" + op2ByColorPlaceAndColorList.activeOp2ByColorPlaceAndColor[i].place + '-' + op2ByColorPlaceAndColorList.activeOp2ByColorPlaceAndColor[i].color + '　　';
			}
		}
		jQuery("#op2ByColorAndSubItem").html(op2ByColor + '　　' + op2ByColorPlaceAndColor);
	}
	else {
		jQuery("#op2ByColorAndSubItem").html(op2ByColor);
	}
	
}

function imageCheck(){
	//会員番号
	var custCd = "${orderCoForm.coCustomerMessageInfo.custCd}";

	if(!isEmpty(custCd)){
		appendAlert('errormssage', getMsgByOneArg('msg114', '会員番号'));
		return false;
	}
	else{
		appendAlertDel('errormssage');
	}

	//名簿納期
	var custDeliverDate = "${orderCoForm.coCustomerMessageInfo.custDeliverDate}"; 

	if(!isEmpty(custDeliverDate)){
		appendAlert('errormssage', getMsgByOneArg('msg114', '名簿納期'));
		return false;
	}
	else{
		appendAlertDel('errormssage');
	}

	//お渡し日
	var custShopDeliveryDate = "${orderCoForm.coCustomerMessageInfo.custShopDeliveryDate}";

	if(!isEmpty(custShopDeliveryDate)){
		appendAlert('errormssage', getMsgByOneArg('msg114', 'お渡し日'));
		return false;
	}
	else{
		appendAlertDel('errormssage');
	}

	//スタッフ
	var custStaff = "${orderCoForm.coCustomerMessageInfo.custStaff}";

	if(!isEmpty(custStaff)){
		appendAlert('errormssage', getMsgByOneArg('msg114', 'スタッフ'));
		return false;
	}
	else{
		appendAlertDel('errormssage');
	}

	//出荷先
	var destination = "${orderCoForm.coCustomerMessageInfo.custShippingDestination}";
	//出荷先_他店舗コード
	var custShippingDestnationOtherstore = "${orderCoForm.coCustomerMessageInfo.custShippingDestnationOtherstore}";

	if(!destination == "05"){
		if(isEmpty(custShippingDestnationOtherstore)){
			appendAlert('errormssage', getMsgByOneArg('msg114', '他店舗'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
	}

	//生地品番
	var productFabricNo = "${orderCoForm.productFabricNo}";

	if(!isEmpty(productFabricNo)){
		appendAlert('errormssage', getMsgByOneArg('msg114', '生地品番'));
		return false;
	}
	else{
		appendAlertDel('errormssage');
	}

	//刺繍ネーム
	var productEmbroideryNm = "${orderCoForm.productEmbroideryNm}";
	//刺繍入れ
	var productEmbroideryNecessity = "${orderCoForm.productEmbroideryNecessity}";

	if(productEmbroideryNecessity == 1){
		if(!isEmpty(productEmbroideryNm)){
			appendAlert('errormssage', getMsgByOneArg('msg114', '刺繍ネーム'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
	}
	//商品情報_ITEM
	var item = "${orderCoForm.productItem}";
	//商品情報_残布_type
	var productRemainingClothType = "${orderCoForm.productRemainingClothType}";
	if(item != '05'){
		if(!isEmpty(productRemainingClothType)){
			appendAlert('errormssage', getMsgByOneArg('msg114', '残布'));
			return false;
		}
		else {
			appendAlertDel('errormssage');
		}
	}
	
	//商品情報_３Piece
	var productIs3Piece = "${orderCoForm.productIs3Piece}";
	//商品情報_スペアパンツ
	var productSparePants = "${orderCoForm.productSparePantsClass}";
	//３Pieceは有り、スペアパンツは有り
	var productIs3PieceAndSparePantsIsYes = "0009902";
	//商品情報_カテゴリ
	var productCategory = "${orderCoForm.productCategory}";
	
	//JACKET_Drop
	var corJkDrop = "${orderCoForm.coAdjustJacketStandardInfo.sizeFigure}";
	//JACKET_号数
	var corJkSize = "${orderCoForm.coAdjustJacketStandardInfo.sizeNumber}";
	
	//PANTS_Drop
	var corPtDrop = "${orderCoForm.coAdjustPantsStandardInfo.sizeFigure}";
	//PANTS_号数
	var corPtSize = "${orderCoForm.coAdjustPantsStandardInfo.sizeNumber}";
	
	//GILET_Drop
	var corGlDrop = "${orderCoForm.coAdjustGiletStandardInfo.sizeFigure}";
	//GILET_号数
	var corGlSize = "${orderCoForm.coAdjustGiletStandardInfo.sizeNumber}";
	
	//2PANTS_Drop
	var corPt2Drop = "${orderCoForm.coAdjustPants2StandardInfo.sizeFigure}";
	//2PANTS_号数
	var corPt2Size = "${orderCoForm.coAdjustPants2StandardInfo.sizeNumber}";

	//SHIRT_サイズ
	var corStSize = "${orderCoForm.coAdjustShirtStandardInfo.corStSize}";

	//COAT_サイズ
	var corCtSize = "${orderCoForm.coAdjustCoatStandardInfo.corCtSize}";

	// 0 : 標準
	if(productCategory == '9000101'){
		//JACKET_モデル
		var jkModel = "${orderCoForm.coOptionJacketStandardInfo.ojJacketModelMap[orderCoForm.coOptionJacketStandardInfo.ojJacketModel]}";
		
		//PANTS_モデル
		var ptModel = "${orderCoForm.coOptionPantsStandardInfo.opPantsModelMap[orderCoForm.coOptionPantsStandardInfo.opPantsModel]}";
		
		//GILET_モデル
		var glModel = "${orderCoForm.coOptionGiletStandardInfo.ogGiletModelMap[orderCoForm.coOptionGiletStandardInfo.ogGiletModel]}";
		
		//2PANTS_モデル
		var pt2Model = "${orderCoForm.coOptionPants2StandardInfo.op2PantsModelMap[orderCoForm.coOptionPants2StandardInfo.op2PantsModel]}";

		//SHIRT_モデル
		var stModel = "${orderCoForm.coOptionShirtStandardInfo.osShirtModelMap[orderCoForm.coOptionShirtStandardInfo.osShirtModel]}";

		//COAT_モデル
		var ctModel = "${orderCoForm.coOptionCoatStandardInfo.coatModelMap[orderCoForm.coOptionCoatStandardInfo.coatModel]}";
		
		if(item == "01"){
			//JACKET_モデル
			if(!isEmpty(jkModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKETモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			//JACKET_Drop
			if(!isEmpty(corJkDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			//JACKET_号数
			if(!isEmpty(corJkSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}


			//PANTS_モデル
			if(!isEmpty(ptModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTSモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//PANTS_Drop
			if(!isEmpty(corPtDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

			//PANTS_号数
			if(!isEmpty(corPtSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			if(productIs3Piece == productIs3PieceAndSparePantsIsYes && productSparePants == productIs3PieceAndSparePantsIsYes){
				//GILET_モデル
				if(!isEmpty(glModel)){
					appendAlert('errormssage', getMsgByOneArg('msg114', 'GILETモデル'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
				
				//GILET_Drop
				if(!isEmpty(corGlDrop)){
					appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET体型'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}

				//GILET_号数
				if(!isEmpty(corGlSize)){
					appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET号数'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}


				//2PANTS_モデル
				if(!isEmpty(pt2Model)){
					appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTSモデル'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
				
				//2PANTS_Drop
				if(!isEmpty(corPt2Drop)){
					appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTS体型'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}

				//2PANTS_号数
				if(!isEmpty(corPt2Size)){
					appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTS号数'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
			}
			else if(productIs3Piece == productIs3PieceAndSparePantsIsYes && productSparePants != productIs3PieceAndSparePantsIsYes){
				//GILET_モデル
				if(!isEmpty(glModel)){
					appendAlert('errormssage', getMsgByOneArg('msg114', 'GILETモデル'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
				
				//GILET_Drop
				if(!isEmpty(corGlDrop)){
					appendAlert('errormssage', getMsgByOneArg('msg001', 'GILET体型'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}

				//GILET_号数
				if(!isEmpty(corGlSize)){
					appendAlert('errormssage', getMsgByOneArg('msg001', 'GILET号数'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
			}
			else if(productIs3Piece != productIs3PieceAndSparePantsIsYes && productSparePants == productIs3PieceAndSparePantsIsYes){
				//2PANTS_モデル
				if(!isEmpty(pt2Model)){
					appendAlert('errormssage', getMsgByOneArg('msg001', '2PANTSモデル'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
				
				//2PANTS_Drop
				if(!isEmpty(corPt2Drop)){
					appendAlert('errormssage', getMsgByOneArg('msg001', '2PANTS体型'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}

				//2PANTS_号数
				if(!isEmpty(corPt2Size)){
					appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTS号数'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
			}
		}
		else if(item == "02"){
			//JACKET_モデル
			if(!isEmpty(jkModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKETモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			//JACKET_Drop
			if(!isEmpty(corJkDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			//JACKET_号数
			if(!isEmpty(corJkSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
		}
		else if(item == "03"){
			//PANTS_モデル
			if(!isEmpty(ptModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTSモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//PANTS_Drop
			if(!isEmpty(corPtDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

			//PANTS_号数
			if(!isEmpty(corPtSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

		}
		else if(item == "04"){
			//GILET_モデル
			if(!isEmpty(glModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'GILETモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//GILET_Drop
			if(!isEmpty(corGlDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

			//GILET_号数
			if(!isEmpty(corGlSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
		}
		else if(item == "05"){
			//SHIRT_モデル
			if(!isEmpty(stModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'SHIRTモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//SHIRT_サイズ
			if(!isEmpty(corStSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'SHIRTサイズ'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
		}
		else if(item == "06"){
			//COAT_モデル
			if(!isEmpty(ctModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'COATモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//COAT_サイズ
			if(!isEmpty(corCtSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'COATサイズ'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
		}
	}
	// 2 : タキシード
	else if(productCategory == '9000102'){
		//JACKET_モデル
		var jkModel = "${orderCoForm.coOptionJacketTuxedoInfo.tjJacketModelMap[orderCoForm.coOptionJacketTuxedoInfo.tjJacketModel]}";
		
		//PANTS_モデル
		var ptModel = "${orderCoForm.coOptionPantsTuxedoInfo.tpPantsModelMap[orderCoForm.coOptionPantsTuxedoInfo.tpPantsModel]}";
		
		//GILET_モデル
		var glModel = "${orderCoForm.coOptionGiletTuxedoInfo.tgGiletModelMap[orderCoForm.coOptionGiletTuxedoInfo.tgGiletModel]}";
		
		//2PANTS_モデル
		var pt2Model = "${orderCoForm.coOptionPants2TuxedoInfo.tp2PantsModelMap[orderCoForm.coOptionPants2TuxedoInfo.tp2PantsModel]}";

		if(item == "01"){
			//JACKET_モデル
			if(!isEmpty(jkModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKETモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			//JACKET_Drop
			if(!isEmpty(corJkDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			//JACKET_号数
			if(!isEmpty(corJkSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}


			//PANTS_モデル
			if(!isEmpty(ptModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTSモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//PANTS_Drop
			if(!isEmpty(corPtDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

			//PANTS_号数
			if(!isEmpty(corPtSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			if(productIs3Piece == productIs3PieceAndSparePantsIsYes && productSparePants == productIs3PieceAndSparePantsIsYes){
				//GILET_モデル
				if(!isEmpty(glModel)){
					appendAlert('errormssage', getMsgByOneArg('msg114', 'GILETモデル'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
				
				//GILET_Drop
				if(!isEmpty(corGlDrop)){
					appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET体型'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}

				//GILET_号数
				if(!isEmpty(corGlSize)){
					appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET号数'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}


				//2PANTS_モデル
				if(!isEmpty(pt2Model)){
					appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTSモデル'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
				
				//2PANTS_Drop
				if(!isEmpty(corPt2Drop)){
					appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTS体型'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}

				//2PANTS_号数
				if(!isEmpty(corPt2Size)){
					appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTS号数'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
			}
			else if(productIs3Piece == productIs3PieceAndSparePantsIsYes && productSparePants != productIs3PieceAndSparePantsIsYes){
				//GILET_モデル
				if(!isEmpty(glModel)){
					appendAlert('errormssage', getMsgByOneArg('msg114', 'GILETモデル'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
				
				//GILET_Drop
				if(!isEmpty(corGlDrop)){
					appendAlert('errormssage', getMsgByOneArg('msg001', 'GILET体型'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}

				//GILET_号数
				if(!isEmpty(corGlSize)){
					appendAlert('errormssage', getMsgByOneArg('msg001', 'GILET号数'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
			}
			else if(productIs3Piece != productIs3PieceAndSparePantsIsYes && productSparePants == productIs3PieceAndSparePantsIsYes){
				//2PANTS_モデル
				if(!isEmpty(pt2Model)){
					appendAlert('errormssage', getMsgByOneArg('msg001', '2PANTSモデル'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
				
				//2PANTS_Drop
				if(!isEmpty(corPt2Drop)){
					appendAlert('errormssage', getMsgByOneArg('msg001', '2PANTS体型'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}

				//2PANTS_号数
				if(!isEmpty(corPt2Size)){
					appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTS号数'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
			}
		}
		else if(item == "02"){
			//JACKET_モデル
			if(!isEmpty(jkModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKETモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			//JACKET_Drop
			if(!isEmpty(corJkDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			//JACKET_号数
			if(!isEmpty(corJkSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
		}
		else if(item == "03"){
			//PANTS_モデル
			if(!isEmpty(ptModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTSモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//PANTS_Drop
			if(!isEmpty(corPtDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

			//PANTS_号数
			if(!isEmpty(corPtSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

		}
		else if(item == "04"){
			//GILET_モデル
			if(!isEmpty(glModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'GILETモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//GILET_Drop
			if(!isEmpty(corGlDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

			//GILET_号数
			if(!isEmpty(corGlSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
		}
	}
	// 1 :ウォッシャブル
	else if(productCategory == '9000103'){
		//JACKET_モデル
		var jkModel = "${orderCoForm.coOptionJacketWashableInfo.wjJacketModelMap[orderCoForm.coOptionJacketWashableInfo.wjJacketModel]}";
		
		//PANTS_モデル
		var ptModel = "${orderCoForm.coOptionPantsWashableInfo.wpPantsModelMap[orderCoForm.coOptionPantsWashableInfo.wpPantsModel]}";
		
		//GILET_モデル
		var glModel = "${orderCoForm.coOptionGiletWashableInfo.wgGiletModelMap[orderCoForm.coOptionGiletWashableInfo.wgGiletModel]}";
		
		//2PANTS_モデル
		var pt2Model = "${orderCoForm.coOptionPants2WashableInfo.wp2PantsModelMap[orderCoForm.coOptionPants2WashableInfo.wp2PantsModel]}";

		if(item == "01"){
			//JACKET_モデル
			if(!isEmpty(jkModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKETモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			//JACKET_Drop
			if(!isEmpty(corJkDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			//JACKET_号数
			if(!isEmpty(corJkSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}


			//PANTS_モデル
			if(!isEmpty(ptModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTSモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//PANTS_Drop
			if(!isEmpty(corPtDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

			//PANTS_号数
			if(!isEmpty(corPtSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			if(productIs3Piece == productIs3PieceAndSparePantsIsYes && productSparePants == productIs3PieceAndSparePantsIsYes){
				//GILET_モデル
				if(!isEmpty(glModel)){
					appendAlert('errormssage', getMsgByOneArg('msg114', 'GILETモデル'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
				
				//GILET_Drop
				if(!isEmpty(corGlDrop)){
					appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET体型'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}

				//GILET_号数
				if(!isEmpty(corGlSize)){
					appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET号数'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}


				//2PANTS_モデル
				if(!isEmpty(pt2Model)){
					appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTSモデル'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
				
				//2PANTS_Drop
				if(!isEmpty(corPt2Drop)){
					appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTS体型'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}

				//2PANTS_号数
				if(!isEmpty(corPt2Size)){
					appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTS号数'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
			}
			else if(productIs3Piece == productIs3PieceAndSparePantsIsYes && productSparePants != productIs3PieceAndSparePantsIsYes){
				//GILET_モデル
				if(!isEmpty(glModel)){
					appendAlert('errormssage', getMsgByOneArg('msg114', 'GILETモデル'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
				
				//GILET_Drop
				if(!isEmpty(corGlDrop)){
					appendAlert('errormssage', getMsgByOneArg('msg001', 'GILET体型'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}

				//GILET_号数
				if(!isEmpty(corGlSize)){
					appendAlert('errormssage', getMsgByOneArg('msg001', 'GILET号数'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
			}
			else if(productIs3Piece != productIs3PieceAndSparePantsIsYes && productSparePants == productIs3PieceAndSparePantsIsYes){
				//2PANTS_モデル
				if(!isEmpty(pt2Model)){
					appendAlert('errormssage', getMsgByOneArg('msg001', '2PANTSモデル'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
				
				//2PANTS_Drop
				if(!isEmpty(corPt2Drop)){
					appendAlert('errormssage', getMsgByOneArg('msg001', '2PANTS体型'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}

				//2PANTS_号数
				if(!isEmpty(corPt2Size)){
					appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTS号数'));
					return false;
				}
				else{
					appendAlertDel('errormssage');
				}
			}
		}
		else if(item == "02"){
			//JACKET_モデル
			if(!isEmpty(jkModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKETモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			//JACKET_Drop
			if(!isEmpty(corJkDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			//JACKET_号数
			if(!isEmpty(corJkSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
		}
		else if(item == "03"){
			//PANTS_モデル
			if(!isEmpty(ptModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTSモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//PANTS_Drop
			if(!isEmpty(corPtDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

			//PANTS_号数
			if(!isEmpty(corPtSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

		}
		else if(item == "04"){
			//GILET_モデル
			if(!isEmpty(glModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'GILETモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//GILET_Drop
			if(!isEmpty(corGlDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

			//GILET_号数
			if(!SisEmpty(corGlSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
		}
	}
 }
</script>