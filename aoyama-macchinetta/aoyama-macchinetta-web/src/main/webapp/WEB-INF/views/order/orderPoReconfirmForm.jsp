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
</style>
<form:form id="idForm" action="${pageContext.request.contextPath}/orderConfirm/orderReFormInDb" method="post" modelAttribute="orderForm" class="form-horizontal">
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
<t:messagesPanel  messagesAttributeName="resultMessages"/>
<div class="alert alert-error" id="errormssage" style="display:none"></div>
	<div class="animated fadeIn">
		<div class="row">
			<div class="col col-lg-6">
				<div class="row">
					<div class="col col-md-4">
						<label class=" form-control-label">お客様名</label>
					</div>
					<c:if test="${orderForm.customerMessageInfo.custNm != '' && orderForm.customerMessageInfo.custKanaNm != '' }">
					<div class="col-12 col-md-8">
						<label class=" form-control-label-value">${f:h(orderForm.customerMessageInfo.custNm)}(${f:h(orderForm.customerMessageInfo.custKanaNm)})</label>様
					</div>
					</c:if>
					<c:if test="${orderForm.customerMessageInfo.custNm == '' && orderForm.customerMessageInfo.custKanaNm != ''}">
					<div class="col-12 col-md-8">
						<label class=" form-control-label-value">(${f:h(orderForm.customerMessageInfo.custKanaNm)})</label>様
					</div>
					</c:if>
					<c:if test="${orderForm.customerMessageInfo.custNm != '' && orderForm.customerMessageInfo.custKanaNm == ''}">
					<div class="col-12 col-md-8">
						<label class=" form-control-label-value">${f:h(orderForm.customerMessageInfo.custNm)}</label>様
					</div>
					</c:if>
				</div>
				<div class="row">
					<div class="col col-md-4">
						<label class=" form-control-label">ステータス</label>
					</div>
					<div class="col-12 col-md-8" id="status">
						<label class=" form-control-label-value" id="status_appear"></label>
					</div>
				</div>
			</div>
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
		</div>
	</div>
</div>
<br/>
<br/>
<br>
<br>
<br>
<br>
<br>
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
							<strong><label class=" form-control-label-value">${orderForm.customerMessageInfo.orderId}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">会員番号</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${orderForm.customerMessageInfo.custCd}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">お客様氏名</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${f:h(orderForm.customerMessageInfo.custNm)}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">フリガナ</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${f:h(orderForm.customerMessageInfo.custKanaNm)}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">承り日</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value" id="License_day"></label></strong>
						</div>
					</div>
				</div>
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
							<strong><label class=" form-control-label-value">${f:h(orderForm.customerMessageInfo.custStaff)}</label></strong>
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
							<strong><label class=" form-control-label-value" id='cust_shipping_destination'></label></strong>
						</div>
					</div>
				</div>
				<div class="col">
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
							<strong><label class=" form-control-label-value" id="product_item">${orderForm.productItemMap[orderForm.productItem] }</label></strong>
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
						<div class="col col-md-3">
							<label class=" form-control-label">生地品番</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${orderForm.productFabricNo}-${color}${pattern}</label></strong>
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
					<c:if test="${orderForm.productBrandType == '0'}">
						<div class="row" id="brandName_div">
							<div class="col col-md-3">
								<label class=" form-control-label">ブランドネーム</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">無し</label></strong>
							</div>
						</div>
					</c:if>
					<c:if test="${orderForm.productBrandType == '1'}">
						<div class="row" id="brandName_div">
							<div class="col col-md-3">
								<label class=" form-control-label">ブランドネーム</label>
							</div>
							<div class="col-12 col-md-9">
								<strong><label class=" form-control-label-value">有り</label></strong>
							</div>
						</div>
					</c:if>
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
									<strong><label class=" form-control-label-value" id="product_embroidery_thread_color"></label></strong>
								</div>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">生地ブランド</label>
						</div>
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
						<div class="col col-md-3">
							<label class=" form-control-label">組成表示　表地</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value" id="composFrtFabric">${orderForm.productComposFrtFabric}</label></strong>
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
							<strong><label class=" form-control-label-value">${orderForm.productComposSleeveLiner}</label></strong>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">取扱注意</label>
						</div>
						<div class="col-12 col-md-9">
							<strong><label class=" form-control-label-value">${orderForm.productNotice}</label></strong>
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
							<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojJacketModelMap[orderForm.optionJacketStandardInfo.ojJacketModel]}</label></strong>
						</div>
						<c:if test="${orderForm.optionJacketStandardInfo.ojFrontBtnCntMap[orderForm.optionJacketStandardInfo.ojFrontBtnCnt] == 'ダブル6つボタン'}">
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="ojJacketModel_appear"></label></strong>
							</div>
						</c:if>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">フロント釦数</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojFrontBtnCntMap[orderForm.optionJacketStandardInfo.ojFrontBtnCnt]}</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="ojFrontBtnCnt_appear"></label></strong>
							<label class=" form-control-label-value" id="ojFrontBtnCnt" style="display:none"></label>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">ラペルデザイン</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojLapelDesignMap[orderForm.optionJacketStandardInfo.ojLapelDesign] }</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="ojLapelDesign_appear"></label></strong>
							<label class=" form-control-label-value" id="ojLapelDesign" style="display:none"></label>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">台場</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojFortMap[orderForm.optionJacketStandardInfo.ojFort] }</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="ojFort_appear"></label></strong>
							<label class=" form-control-label-value" id="ojFort" style="display:none"></label>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">裏仕様</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojGackSpecMap[orderForm.optionJacketStandardInfo.ojGackSpec] }</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="ojGackSpec_appear"></label></strong>
							<label class=" form-control-label-value" id="ojGackSpec" style="display:none"></label>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">腰ポケット</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojWaistPktMap[orderForm.optionJacketStandardInfo.ojWaistPkt] }</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="ojWaistPkt_appear"></label></strong>
							<label class=" form-control-label-value" id="ojWaistPkt" style="display:none"></label>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">チェンジポケット</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojChangePktMap[orderForm.optionJacketStandardInfo.ojChangePkt] }</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="ojChangePkt_appear"></label></strong>
							<label class=" form-control-label-value" id="ojChangePkt" style="display:none"></label>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">スランテッドポケット</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojSlantedPktMap[orderForm.optionJacketStandardInfo.ojSlantedPkt] }</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="ojSlantedPkt_appear"></label></strong>
							<label class=" form-control-label-value" id="ojSlantedPkt" style="display:none"></label>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">袖口</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojCuffSpecMap[orderForm.optionJacketStandardInfo.ojCuffSpec] }</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="ojCuffSpec_appear"></label></strong>
							<label class=" form-control-label-value" id="ojCuffSpec" style="display:none"></label>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">AMFステッチ</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojStitchMap[orderForm.optionJacketStandardInfo.ojStitch] }</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="ojStitch_appear"></label></strong>
							<label class=" form-control-label-value" id="ojStitch" style="display:none"></label>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label">ベント</label>
						</div>
						<div class="col-12 col-md-8">
							<strong><label class=" form-control-label-value">${orderForm.optionJacketStandardInfo.ojVentSpecMap[orderForm.optionJacketStandardInfo.ojVentSpec] }</label></strong>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="ojVentSpec_appear"></label></strong>
							<label class=" form-control-label-value" id="ojVentSpec" style="display:none"></label>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label" id="jkInnerBodyCloth">胴裏素材</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="jkInnerBodyCloth_appear"></label></strong>
							<label class=" form-control-label-value" id="jkInnerBodyCloth_display" style="display:none">${orderForm.optionJacketStandardInfo.ojBodyBackMate}</label>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="ojBodyBackMate_app_appear"></label></strong>
							<label class=" form-control-label-value" id="ojBodyBackMate" style="display:none"></label>
							<label class=" form-control-label-value" id="ojBodyBackMate_app" style="display:none"></label>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label" id="jkInnerSleeveCloth">袖裏素材</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="jkInnerSleeveCloth_appear"></label></strong>
							<label class=" form-control-label-value" id="jkInnerSleeveCloth_display" style="display:none">${orderForm.optionJacketStandardInfo.ojCuffBackMate}</label>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="ojCuffBackMate_app_appear"></label></strong>
							<label class=" form-control-label-value" id="ojCuffBackMate" style="display:none"></label>
							<label class=" form-control-label-value" id="ojCuffBackMate_app" style="display:none"></label>
						</div>
					</div>
					<div class="row">
						<div class="col col-md-3">
							<label class=" form-control-label" id="jkBtnMaterial">釦素材</label>
						</div>
						<div class="col col-md-8">
							<strong><label class=" form-control-label-value" id="jkBtnMaterial_appear"></label></strong>
							<label class=" form-control-label-value" id="jkBtnMaterial_display" style="display:none">${orderForm.optionJacketStandardInfo.ojBtnMate}</label>
						</div>
						<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="ojBtnMate_app_appear"></label></strong>
							<label class=" form-control-label-value" id="ojBtnMate" style="display:none"></label>
							<label class=" form-control-label-value" id="ojBtnMate_app" style="display:none"></label>
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
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.sizeFigure}&nbsp &nbsp &nbsp${orderForm.adjustJacketStandardInfo.sizeNumber}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<strong><label class=" form-control-label">JACKET補正</label></strong>
							</div>
							<div class="col-12 col-md-3">
								<label class=" form-control-label">着丈修正</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkBodyCorrect }</label>cm</strong>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkBodyGross }</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">ウエスト修正</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkWaistCorrect }</label>cm</strong>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkWaistGross }</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">袖丈右修正</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkRightsleeveCorrect}</label>cm</strong>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkRightsleeveGross }</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">袖丈左修正</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkLeftsleeveCorrect }</label>cm</strong> 
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustJacketStandardInfo.corJkLeftsleeveGross }</label>cm</strong> 
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
								<strong><label class=" form-control-label-value">${orderForm.optionGiletStandardInfo.ogGiletModelMap[orderForm.optionGiletStandardInfo.ogGiletModel] }</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">胸ポケット</label>
							</div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletStandardInfo.ogBreastPktMap[orderForm.optionGiletStandardInfo.ogBreastPkt] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="ogBreastPkt_appear"></label></strong>
								<label class=" form-control-label-value" id="ogBreastPkt" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">AMFステッチ</label>
							</div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionGiletStandardInfo.ogStitchMap[orderForm.optionGiletStandardInfo.ogStitch] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="ogStitch_appear"></label></strong>
								<label class=" form-control-label-value" id="ogStitch" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">背裏地素材</label>
							</div>
							<div class="col col-md-8">
								<strong><label class=" form-control-label-value" id="glBackCloth_appear"></label></strong>
								<label class=" form-control-label-value" id="glBackCloth_display" style="display:none">${orderForm.optionGiletStandardInfo.ogBackLiningMate }</label>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="ogBackLiningMate_app_appear"></label></strong>
								<label class=" form-control-label-value" id="ogBackLiningMate" style="display:none"></label>
								<label class=" form-control-label-value" id="ogBackLiningMate_app" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">内側裏地素材</label>
							</div>
							<div class="col col-md-8">
								<strong><label class=" form-control-label-value" id="glInnnerCloth_appear"></label></strong>
								<label class=" form-control-label-value" id="glInnnerCloth_display" style="display:none">${orderForm.optionGiletStandardInfo.ogInsideLiningMate }</label>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="ogInsideLiningMate_app_appear"></label></strong>
								<label class=" form-control-label-value" id="ogInsideLiningMate" style="display:none"></label>
								<label class=" form-control-label-value" id="ogInsideLiningMate_app" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">釦素材</label>
							</div>
							<div class="col col-md-8">
								<strong><label class=" form-control-label-value" id="glFrtBtn_appear"></label></strong>
								<label class=" form-control-label-value" id="glFrtBtn_display" style="display:none">${orderForm.optionGiletStandardInfo.ogFrontBtnMate }</label>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="ogFrontBtnMate_app_appear"></label></strong>
								<label class=" form-control-label-value" id="ogFrontBtnMate" style="display:none"></label>
								<label class=" form-control-label-value" id="ogFrontBtnMate_app" style="display:none"></label>
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
								<strong><label class=" form-control-label-value">${orderForm.adjustGiletStandardInfo.sizeFigure}&nbsp &nbsp &nbsp${orderForm.adjustGiletStandardInfo.sizeNumber}</label></strong>
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
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opPantsModelMap[orderForm.optionPantsStandardInfo.opPantsModel] }</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">タック</label>
							</div>
							<div class="col col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opTackMap[orderForm.optionPantsStandardInfo.opTack] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
							<strong><label class=" form-control-label-value" id="opTack_appear"></label></strong>
							<label class=" form-control-label-value" id="opTack" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">アジャスター仕様</label>
							</div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opAdjusterMap[orderForm.optionPantsStandardInfo.opAdjuster] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="opAdjuster_appear"></label></strong>
								<label class=" form-control-label-value" id="opAdjuster" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">裾上げ</label>
							</div>
							<div class="col col-md-8">
								<strong><label class=" form-control-label-value" id="op_hemUp">${orderForm.optionPantsStandardInfo.opHemUpMap[orderForm.optionPantsStandardInfo.opHemUp] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="opHemUp_appear"></label></strong>
								<label class=" form-control-label-value" id="opHemUp" style="display:none"></label>
							</div>
						</div>
						<c:if test="${orderForm.optionPantsStandardInfo.opHemUpMap[orderForm.optionPantsStandardInfo.opHemUp] == 'ダブルスナップ' || orderForm.optionPantsStandardInfo.opHemUpMap[orderForm.optionPantsStandardInfo.opHemUp] == 'ダブル糸'}">
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">ダブル幅</label>
							</div>
							<div class="col col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opDoubleWideMap[orderForm.optionPantsStandardInfo.opDoubleWide] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="opDoubleWide_appear"></label></strong>
								<label class=" form-control-label-value" id="opDoubleWide" style="display:none"></label>
							</div>
						</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">釦素材</label>
							</div>
							<div class="col col-md-8">
								<strong><label class=" form-control-label-value" id="ptBtnMaterial_appear"></label></strong>
								<label class=" form-control-label-value" id="ptBtnMaterial_display" style="display:none">${orderForm.optionPantsStandardInfo.opButton }</label>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="opButton_app_appear"></label></strong>
								<label class=" form-control-label-value" id="opButton" style="display:none"></label>
								<label class=" form-control-label-value" id="opButton_app" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">エイト（滑り止め）</label>
							</div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opEightMap[orderForm.optionPantsStandardInfo.opEight] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="opEight_appear"></label></strong>
								<label class=" form-control-label-value" id="opEight" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">シック大（股補強）</label>
							</div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opThickMap[orderForm.optionPantsStandardInfo.opThick] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="opThick_appear"></label></strong>
								<label class=" form-control-label-value" id="opThick" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">形状記憶</label>
							</div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opShapeMemoryMap[orderForm.optionPantsStandardInfo.opShapeMemory] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="opShapeMemory_appear"></label></strong>
								<label class=" form-control-label-value" id="opShapeMemory" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">靴ずれ</label>
							</div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionPantsStandardInfo.opBlisterMap[orderForm.optionPantsStandardInfo.opBlister] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="opBlister_appear"></label></strong>
								<label class=" form-control-label-value" id="opBlister" style="display:none"></label>
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
								<strong><label class=" form-control-label-value">${orderForm.adjustPantsStandardInfo.sizeFigure}&nbsp &nbsp &nbsp${orderForm.adjustPantsStandardInfo.sizeNumber}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<strong><label class=" form-control-label">PANTS補正</label></strong>
							</div>
							<div class="col-12 col-md-3">
								<label class=" form-control-label">ウエスト修正</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value">${orderForm.adjustPantsStandardInfo.corPtWaistCorrect}</label>cm</strong>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustPantsStandardInfo.corPtWaistGross }</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">ワタリ修正</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value">${orderForm.adjustPantsStandardInfo.corPtThighCorrect }</label>cm</strong>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustPantsStandardInfo.corPtThighGross }</label>cm</strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">裾幅</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value">${orderForm.adjustPantsStandardInfo.corPtHemwidthCorrect }</label>cm</strong>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustPantsStandardInfo.corPtHemwidthGross }</label>cm</strong>
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
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2PantsModelMap[orderForm.optionPants2StandardInfo.op2PantsModel]}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">タック</label>
							</div>
							<div class="col col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2TackMap[orderForm.optionPants2StandardInfo.op2Tack] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="op2Tack_appear"></label></strong>
								<label class=" form-control-label-value" id="op2Tack" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">アジャスター仕様</label>
							</div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2AdjusterMap[orderForm.optionPants2StandardInfo.op2Adjuster] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="op2Adjuster_appear"></label></strong>
								<label class=" form-control-label-value" id="op2Adjuster" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">裾上げ</label>
							</div>
							<div class="col col-md-8">
								<strong><label class=" form-control-label-value" id="op2_hemUp">${orderForm.optionPants2StandardInfo.op2HemUpMap[orderForm.optionPants2StandardInfo.op2HemUp] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="op2HemUp_appear"></label></strong>
								<label class=" form-control-label-value" id="op2HemUp" style="display:none"></label>
							</div>
						</div>
						<c:if test="${orderForm.optionPants2StandardInfo.op2HemUpMap[orderForm.optionPants2StandardInfo.op2HemUp] == 'ダブルスナップ' || orderForm.optionPants2StandardInfo.op2HemUpMap[orderForm.optionPants2StandardInfo.op2HemUp] == 'ダブル糸'}">
							<div class="row">
								<div class="col col-md-3">
									<label class=" form-control-label">ダブル幅</label>
								</div>
								<div class="col col-md-8">
									<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2DoubleWideMap[orderForm.optionPants2StandardInfo.op2DoubleWide] }</label></strong>
								</div>
								<div class="col-12 col-md-1" align="right">
									<strong><label class=" form-control-label-value" id="op2DoubleWide_appear"></label></strong>
									<label class=" form-control-label-value" id="op2DoubleWide" style="display:none"></label>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">釦素材</label>
							</div>
							<div class="col col-md-8">
								<strong><label class=" form-control-label-value" id="pt2BtnMaterial_appear"></label></strong>
								<label class=" form-control-label-value" id="pt2BtnMaterial_display" style="display:none">${orderForm.optionPants2StandardInfo.op2Button }</label>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="op2Button_app_appear"></label></strong>
								<label class=" form-control-label-value" id="op2Button" style="display:none"></label>
								<label class=" form-control-label-value" id="op2Button_app" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">エイト（滑り止め）</label>
							</div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2EightMap[orderForm.optionPants2StandardInfo.op2Eight] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="op2Eight_appear"></label></strong>
								<label class=" form-control-label-value" id="op2Eight" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">シック大（股補強）</label>
							</div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2ThickMap[orderForm.optionPants2StandardInfo.op2Thick] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="op2Thick_appear"></label></strong>
								<label class=" form-control-label-value" id="op2Thick" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">形状記憶</label>
							</div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2ShapeMemoryMap[orderForm.optionPants2StandardInfo.op2ShapeMemory] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="op2ShapeMemory_appear"></label></strong>
								<label class=" form-control-label-value" id="op2ShapeMemory" style="display:none"></label>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<label class=" form-control-label">靴ずれ</label>
							</div>
							<div class="col-12 col-md-8">
								<strong><label class=" form-control-label-value">${orderForm.optionPants2StandardInfo.op2BlisterMap[orderForm.optionPants2StandardInfo.op2Blister] }</label></strong>
							</div>
							<div class="col-12 col-md-1" align="right">
								<strong><label class=" form-control-label-value" id="op2Blister_appear"></label></strong>
								<label class=" form-control-label-value" id="op2Blister" style="display:none"></label>
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
								<strong><label class=" form-control-label-value">${orderForm.adjustPants2StandardInfo.sizeFigure}&nbsp &nbsp &nbsp${orderForm.adjustPants2StandardInfo.sizeNumber}</label></strong>
							</div>
						</div>
						<div class="row">
							<div class="col col-md-3">
								<strong><label class=" form-control-label">PANTS補正</label></strong>
							</div>
							<div class="col-12 col-md-3">
								<label class=" form-control-label">ウエスト修正</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value">${orderForm.adjustPants2StandardInfo.corPt2WaistCorrect }cm</label></strong>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustPants2StandardInfo.corPt2WaistGross }cm</label></strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">ワタリ修正</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value">${orderForm.adjustPants2StandardInfo.corPt2ThighCorrect }cm</label></strong>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustPants2StandardInfo.corPt2ThighGross }cm</label></strong>
							</div>
							<div class="col-12 col-md-3 offset-md-3">
								<label class=" form-control-label">裾幅</label>
							</div>
							<div class="col-12 col-md-2">
								<strong><label class=" form-control-label-value">${orderForm.adjustPants2StandardInfo.corPt2HemwidthCorrect }cm</label></strong>
							</div>
							<div class="col-12 col-md-4">
								<strong><label class=" form-control-label-value">${orderForm.adjustPants2StandardInfo.corPt2HemwidthGross }cm</label></strong>
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
							<button id="confirm" type="submit" class="btn btn-primary btn-block" onclick="return imageCheck();"><i class="fa fa-check-circle"></i> 確定</button>
						</div>
						<div class="col col-md-2">　</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</form:form>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
<script type="text/javascript">
var contextPath = jQuery("meta[name='contextPath']").attr("content");
jQuery("#goBack").click(function(){
	jQuery("#idForm").attr("action", "${pageContext.request.contextPath}/order/orderPoBack");
    jQuery("#confirm").click();
})

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

//オプション内容の表示
var item = jQuery("#product_item").html();
if (item == "SUIT") {
	//３Pieceは有り、スペアパンツは有りの場合
	if("${orderForm.productIs3Piece}" == '0009902' && "${orderForm.productSparePantsClass}" == '0009902'){
		jQuery('#op_jacket_div').show();
		jQuery('#al_jacket_div').show();

		jQuery('#op_gilet_div').show();
		jQuery('#al_gilet_div').show();

		jQuery('#op_pants_div').show();
		jQuery('#al_pants_div').show();

		jQuery('#op2_pants_div').show();
		jQuery('#al2_pants_div').show();
		}
	//３Pieceは有り、スペアパンツは無しの場合
	else if("${orderForm.productIs3Piece}" == '0009902' && "${orderForm.productSparePantsClass}" == '0009901'){
		jQuery('#op_jacket_div').show();
		jQuery('#al_jacket_div').show();

		jQuery('#op_gilet_div').show();
		jQuery('#al_gilet_div').show();

		jQuery('#op_pants_div').show();
		jQuery('#al_pants_div').show();
		
		}
	//３Pieceは無し、スペアパンツは有りの場合
	else if("${orderForm.productIs3Piece}" == '0009901' && "${orderForm.productSparePantsClass}"  == '0009902'){
		jQuery('#op_jacket_div').show();
		jQuery('#al_jacket_div').show();

		jQuery('#op_pants_div').show();
		jQuery('#al_pants_div').show();

		jQuery('#op2_pants_div').show();
		jQuery('#al2_pants_div').show();
		}
	//３Pieceは無し、スペアパンツは無しの場合
	else if("${orderForm.productIs3Piece}" == '0009901' && "${orderForm.productSparePantsClass}"  == '0009901'){
		jQuery('#op_jacket_div').show();
		jQuery('#al_jacket_div').show();

		jQuery('#op_pants_div').show();
		jQuery('#al_pants_div').show();
		}
}
//JACKETを表示の場合のみ
else if(item == "JACKET"){
	jQuery('#op_jacket_div').show();
	jQuery('#al_jacket_div').show();
}
//PANTSを表示の場合のみ
else if(item == "PANTS"){
	jQuery('#op_pants_div').show();
	jQuery('#al_pants_div').show();
}
//GILETを表示の場合のみ
else if(item == "GILET"){
	jQuery('#op_gilet_div').show();
	jQuery('#al_gilet_div').show();
}

var data = {
		activeList: [{id:"jkInnerBodyCloth",option:"00038"},
					{id:"jkInnerSleeveCloth",option:"00040"},
					{id:"jkBtnMaterial",option:"00042"},
					{id:"glBackCloth",option:"00017"},
					{id:"glInnnerCloth",option:"00019"},
					{id:"glFrtBtn",option:"00021"},
					{id:"ptBtnMaterial",option:"00033"},
					{id:"pt2BtnMaterial",option:"00033"}]
};
//商品情報_ITEM
var itemCode = "${orderForm.productItem}";

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

//商品情報_刺繍糸色の内容表示
//var productEmbroideryEhreadColor = {110:'110（金茶）',140:'140（白）',402:'402（黒）',760:'760（ネイビー）',145:'145（水色）',75:'75（ブルー）',9:'9（赤）',56:'56（グリーン）',89:'89（ライトブラウン）',94:'94（ブラウン）',152:'152（ボルドー）',169:'169（パープル）',343:'343（ベージュ）',701:'701（モカ）',401:'401（白）'};
jQuery("#product_embroidery_thread_color").html("${orderForm.productEmbroideryThreadColor}");


//JACKETの胴裏素材表示
jQuery.ajax({
	 type:"get",
	 url: contextPath + "/order/standardMateSelect",
	 data:{"itemCode":itemCode,"subItemCode":"02","mateChecked":jQuery("#"+data.activeList[0].id+"_display").html(),"orderPattern":"PO","optionCode":data.activeList[0].option},
	 success:function(result){
         jQuery("#jkInnerBodyCloth_appear").html("${orderForm.optionJacketStandardInfo.ojBodyBackMateMap[orderForm.optionJacketStandardInfo.ojBodyBackMate]}"   + '\xa0\xa0' +  result["${orderForm.optionJacketStandardInfo.ojBodyBackMateStkNo}"]);
	 }
});
	
// JACKETの袖裏素材表示
jQuery.ajax({
	 type:"get",
	 url: contextPath + "/order/standardMateSelect",
	 data:{"itemCode":itemCode,"subItemCode":"02","mateChecked":jQuery("#"+data.activeList[1].id+"_display").html(),"orderPattern":"PO","optionCode":data.activeList[1].option},
	 success:function(result){
			 jQuery("#jkInnerSleeveCloth_appear").html("${orderForm.optionJacketStandardInfo.ojCuffBackMateMap[orderForm.optionJacketStandardInfo.ojCuffBackMate]}"   + '\xa0\xa0' +  result["${orderForm.optionJacketStandardInfo.ojCuffBackMateStkNo}"]);
	 }
});

// JACKETの釦素材表示
jQuery.ajax({
	 type:"get",
	 url: contextPath + "/order/standardMateSelect",
	 data:{"itemCode":itemCode,"subItemCode":"02","mateChecked":jQuery("#"+data.activeList[2].id+"_display").html(),"orderPattern":"PO","optionCode":data.activeList[2].option},
	 success:function(result){
		 var e = JSON.stringify(result);
		 jQuery("#jkBtnMaterial_appear").html("${orderForm.optionJacketStandardInfo.ojBtnMateMap[orderForm.optionJacketStandardInfo.ojBtnMate]}"   + '\xa0\xa0' +  result["${orderForm.optionJacketStandardInfo.ojBtnMateStkNo}"]);
				  
	 }
});

//GILETの背裏地素材表示
jQuery.ajax({
	 type:"get",
	 url: contextPath + "/order/standardMateSelect",
	 data:{"itemCode":itemCode,"subItemCode":"04","mateChecked":jQuery("#"+data.activeList[3].id+"_display").html(),"orderPattern":"PO","optionCode":data.activeList[3].option},
	 success:function(result){
		 jQuery("#glBackCloth_appear").html("${orderForm.optionGiletStandardInfo.ogBackLiningMateMap[orderForm.optionGiletStandardInfo.ogBackLiningMate]}"   + '\xa0\xa0' +  result["${orderForm.optionGiletStandardInfo.ogBackLiningMateStkNo}"]);
				  
	 }
});

//GILETの内側裏地素材表示
jQuery.ajax({
	 type:"get",
	 url: contextPath + "/order/standardMateSelect",
	 data:{"itemCode":itemCode,"subItemCode":"04","mateChecked":jQuery("#"+data.activeList[4].id+"_display").html(),"orderPattern":"PO","optionCode":data.activeList[4].option},
	 success:function(result){
		 jQuery("#glInnnerCloth_appear").html("${orderForm.optionGiletStandardInfo.ogInsideLiningMateMap[orderForm.optionGiletStandardInfo.ogInsideLiningMate]}"   + '\xa0\xa0' +  result["${orderForm.optionGiletStandardInfo.ogInsideLiningMateStkNo}"]);
				  
	 }
});

//GILETのフロント釦表示
jQuery.ajax({
	 type:"get",
	 url: contextPath + "/order/standardMateSelect",
	 data:{"itemCode":itemCode,"subItemCode":"04","mateChecked":jQuery("#"+data.activeList[5].id+"_display").html(),"orderPattern":"PO","optionCode":data.activeList[5].option},
	 success:function(result){
		 jQuery("#glFrtBtn_appear").html("${orderForm.optionGiletStandardInfo.ogFrontBtnMateMap[orderForm.optionGiletStandardInfo.ogFrontBtnMate]}"   + '\xa0\xa0' +  result["${orderForm.optionGiletStandardInfo.ogFrontBtnMateStkNo}"]);
				  
	 }
});

//PANTSの釦素材表示
jQuery.ajax({
	 type:"get",
	 url: contextPath + "/order/standardMateSelect",
	 data:{"itemCode":itemCode,"subItemCode":"03","mateChecked":jQuery("#"+data.activeList[6].id+"_display").html(),"orderPattern":"PO","optionCode":data.activeList[6].option},
	 success:function(result){
		 jQuery("#ptBtnMaterial_appear").html("${orderForm.optionPantsStandardInfo.opButtonMap[orderForm.optionPantsStandardInfo.opButton]}"   + '\xa0\xa0' +  result["${orderForm.optionPantsStandardInfo.opBtnMateStkNo}"]);
				  
	 }
});

//PANTS（2本目）の釦素材表示
jQuery.ajax({
	 type:"get",
	 url: contextPath + "/order/standardMateSelect",
	 data:{"itemCode":itemCode,"subItemCode":"07","mateChecked":jQuery("#"+data.activeList[7].id+"_display").html(),"orderPattern":"PO","optionCode":data.activeList[7].option},
	 success:function(result){
		 jQuery("#pt2BtnMaterial_appear").html("${orderForm.optionPants2StandardInfo.op2ButtonMap[orderForm.optionPants2StandardInfo.op2Button]}"   + '\xa0\xa0' +  result["${orderForm.optionPants2StandardInfo.op2BtnMateStkNo}"]);
				  
	 }
})

//ITEM_コード
var subItemCode = {SUIT:"01",JACKET:"02",PANTS:"03",GILET:"04",PANTS2:"07"};

/*
jkOptionCodeListの値:
	option_code: 00001,option_name: フロント釦数
	option_code: 00002,option_name: ラペルデザイン
	option_code: 00005,option_name: 台場
	option_code: 00004,option_name: 裏仕様
	option_code: 00012,option_name: 腰ポケット
	option_code: 00013,option_name: チェンジポケット
	option_code: 00014,option_name: スランテッドポケット
	option_code: 00019,option_name: 袖口
	option_code: 00023,option_name: AMFステッチ
	option_code: 00037,option_name: ベント
	option_code: 00038,option_name: 胴裏素材
	option_code: 00040,option_name: 袖裏素材
	option_code: 00042,option_name: 釦素材
*/
var jkOptionCodeList = ["00001","00002","00005","00004","00012","00013","00014","00019","00023","00037","00038","00040","00042"];
/*	
gtOptionCodeListの値:
	option_code: 00001,option_name: 胸ポケット
	option_code: 00005,option_name: AMFステッチ
	option_code: 00017,option_name: 背裏地素材
	option_code: 00019,option_name: 内側裏地素材
	option_code: 00021,option_name: 釦素材
*/
var gtOptionCodeList = ["00001","00005","00017","00019","00021"];
/*
ptOptionCodeListの値:
	option_code: 00001,option_name: タック
	option_code: 00006,option_name: アジャスター仕様
	option_code: 00017,option_name: 裾上げ
	option_code: 00018,option_name: ダブル幅
	option_code: 00019,option_name: AMFステッチ
	option_code: 00033,option_name: 釦素材
	option_code: 00036,option_name: エイト（滑り止め）
	option_code: 00041,option_name: シック大（股補強）
	option_code: 00037,option_name: 形状記憶
	option_code: 00038,option_name: 靴ずれ
*/
var ptOptionCodeList = ["00001","00006","00017","00018","00019","00033","00036","00041","00037","00038"];
/*
pt2OptionCodeListの値:
	option_code: 00001,option_name: タック
	option_code: 00006,option_name: アジャスター仕様
	option_code: 00017,option_name: 裾上げ
	option_code: 00018,option_name: ダブル幅
	option_code: 00019,option_name: AMFステッチ
	option_code: 00033,option_name: 釦素材
	option_code: 00036,option_name: エイト（滑り止め）
	option_code: 00041,option_name: シック大（股補強）
	option_code: 00037,option_name: 形状記憶
	option_code: 00038,option_name: 靴ずれ
*/
var pt2OptionCodeList = ["00001","00006","00017","00018","00019","00033","00036","00041","00037","00038"];

/* 
jkDetailOptionCodeListの値:
	option_code: 00038,option_name: 胴裏素材
	option_code: 00040,option_name: 袖裏素材
	option_code: 00042,option_name: 釦素材
*/
var jkDetailOptionCodeList = ["00038","00040","00042"];
/* 
gtDetailOptionCodeListの値:
	option_code: 00017,option_name: 背裏地素材
	option_code: 00019,option_name: 内側裏地素材
	option_code: 00021,option_name: 釦素材
*/
var gtDetailOptionCodeList = ["00017","00019","00021"];
/* 
ptDetailOptionCodeListの値:
	option_code: 00033,option_name: 釦素材
*/
var ptDetailOptionCodeList = ["00033"];
/* 
ptDetail2OptionCodeListの値:
	option_code: 00033,option_name: 釦素材
*/
var ptDetail2OptionCodeList = ["00033"];

var OptionBranchCodeList = {
	jacketOptionBranchCode:[
		"${orderForm.optionJacketStandardInfo.ojFrontBtnCnt}",
		"${orderForm.optionJacketStandardInfo.ojLapelDesign}",
		"${orderForm.optionJacketStandardInfo.ojFort}",
		"${orderForm.optionJacketStandardInfo.ojGackSpec}",
		"${orderForm.optionJacketStandardInfo.ojWaistPkt}",
		"${orderForm.optionJacketStandardInfo.ojChangePkt}",
		"${orderForm.optionJacketStandardInfo.ojSlantedPkt}",
		"${orderForm.optionJacketStandardInfo.ojCuffSpec}",
		"${orderForm.optionJacketStandardInfo.ojStitch}",
		"${orderForm.optionJacketStandardInfo.ojVentSpec}",
		"${orderForm.optionJacketStandardInfo.ojBodyBackMate}",
		"${orderForm.optionJacketStandardInfo.ojCuffBackMate}",
		"${orderForm.optionJacketStandardInfo.ojBtnMate}"
		],
	giletOptionBranchCode:[
		"${orderForm.optionGiletStandardInfo.ogBreastPkt}",
		"${orderForm.optionGiletStandardInfo.ogStitch}",
		"${orderForm.optionGiletStandardInfo.ogBackLiningMate}",
		"${orderForm.optionGiletStandardInfo.ogInsideLiningMate}",
		"${orderForm.optionGiletStandardInfo.ogFrontBtnMate}"
		],
	pantsOptionBranchCode:[
		"${orderForm.optionPantsStandardInfo.opTack}",
		"${orderForm.optionPantsStandardInfo.opAdjuster}",
		"${orderForm.optionPantsStandardInfo.opHemUp}",
		"${orderForm.optionPantsStandardInfo.opDoubleWide}",
		"${orderForm.optionPantsStandardInfo.opStitch}",
		"${orderForm.optionPantsStandardInfo.opButton }",
		"${orderForm.optionPantsStandardInfo.opEight}",
		"${orderForm.optionPantsStandardInfo.opThick}",
		"${orderForm.optionPantsStandardInfo.opShapeMemory}",
		"${orderForm.optionPantsStandardInfo.opBlister}"
		],
	pants2OptionBranchCode:[
		"${orderForm.optionPants2StandardInfo.op2Tack}",
		"${orderForm.optionPants2StandardInfo.op2Adjuster}",
		"${orderForm.optionPants2StandardInfo.op2HemUp}",
		"${orderForm.optionPants2StandardInfo.op2DoubleWide}",
		"${orderForm.optionPants2StandardInfo.op2Stitch}",
		"${orderForm.optionPants2StandardInfo.op2Button }",
		"${orderForm.optionPants2StandardInfo.op2Eight}",
		"${orderForm.optionPants2StandardInfo.op2Thick}",
		"${orderForm.optionPants2StandardInfo.op2ShapeMemory}",
		"${orderForm.optionPants2StandardInfo.op2Blister}"
		]
}

var OptionDetailBranchCodeList = {
		jacketDetailOptionBranchCode:[
			"${orderForm.optionJacketStandardInfo.ojBodyBackMate}",
			"${orderForm.optionJacketStandardInfo.ojCuffBackMate}",
			"${orderForm.optionJacketStandardInfo.ojBtnMate}"
			],
		giletDetailOptionBranchCode:[
			"${orderForm.optionGiletStandardInfo.ogBackLiningMate}",
			"${orderForm.optionGiletStandardInfo.ogInsideLiningMate}",
			"${orderForm.optionGiletStandardInfo.ogFrontBtnMate}"
			],
		pantsDetailOptionBranchCode:[
			"${orderForm.optionPantsStandardInfo.opButton }"
			],
		pants2DetailOptionBranchCode:[
			"${orderForm.optionPants2StandardInfo.op2Button }"
			]
	}

var OptionBranchDetailCodeList = {
		jacketOptionBranchDetailCode:[
			"${orderForm.optionJacketStandardInfo.ojBodyBackMateStkNo}",
			"${orderForm.optionJacketStandardInfo.ojCuffBackMateStkNo}",
			"${orderForm.optionJacketStandardInfo.ojBtnMateStkNo}"
			],
		giletOptionBranchDetailCode:[
			"${orderForm.optionGiletStandardInfo.ogBackLiningMateStkNo}",
			"${orderForm.optionGiletStandardInfo.ogInsideLiningMateStkNo}",
			"${orderForm.optionGiletStandardInfo.ogFrontBtnMateStkNo}"
			],
		pantsOptionBranchDetailCode:[
			"${orderForm.optionPantsStandardInfo.opBtnMateStkNo}"
			],
		pants2OptionBranchDetailCode:[
			"${orderForm.optionPants2StandardInfo.op2BtnMateStkNo}"
			]
		
}

var jacketId = ["ojFrontBtnCnt","ojLapelDesign","ojFort","ojGackSpec","ojWaistPkt","ojChangePkt","ojSlantedPkt","ojCuffSpec","ojStitch","ojVentSpec","ojBodyBackMate","ojCuffBackMate","ojBtnMate"];
var giletId = ["ogBreastPkt","ogStitch","ogBackLiningMate","ogInsideLiningMate","ogFrontBtnMate"];
var pantsId = ["opTack","opAdjuster","opHemUp","opDoubleWide","opStitch","opButton","opEight","opThick","opShapeMemory","opBlister"];
var pants2Id = ["op2Tack","op2Adjuster","op2HemUp","op2DoubleWide","op2Stitch","op2Button","op2Eight","op2Thick","op2ShapeMemory","op2Blister"];

var detailJacketId = ["ojBodyBackMate","ojCuffBackMate","ojBtnMate"];
var detailGiletId = ["ogBackLiningMate","ogInsideLiningMate","ogFrontBtnMate"];
var detailPantsId = ["opButton"];
var detailPants2Id = ["op2Button"];

//JACKETのsub_item_code + model_code + option_code + option_branch_code + option_btanch_detail_code
for(var j in detailJacketId){
	var subItemCodeJ = subItemCode.JACKET;
	var optionCode = jkDetailOptionCodeList[j];
	var optionBranchCode = OptionDetailBranchCodeList.jacketDetailOptionBranchCode[j];
	var optionBtanchDetailCode = OptionBranchDetailCodeList.jacketOptionBranchDetailCode[j];
	
	jQuery("#" + detailJacketId[j] + "_app" ).html(itemCode + subItemCodeJ + "${orderForm.optionJacketStandardInfo.ojJacketModel}" + optionCode + optionBranchCode + optionBtanchDetailCode);
}

//GILETのsub_item_code + model_code + option_code + option_branch_code + option_btanch_detail_code
for(var g in detailGiletId){
	var subItemCodeG = subItemCode.GILET;
	var optionCode = gtDetailOptionCodeList[g];
	var optionBranchCode = OptionDetailBranchCodeList.giletDetailOptionBranchCode[g];
	var optionBtanchDetailCode = OptionBranchDetailCodeList.giletOptionBranchDetailCode[g];

	jQuery("#" + detailGiletId[g] + "_app" ).html(itemCode + subItemCodeG + "${orderForm.optionGiletStandardInfo.ogGiletModel}" + optionCode + optionBranchCode + optionBtanchDetailCode);
}

//PANTSのsub_item_code + model_code + option_code + option_branch_code + option_btanch_detail_code
for(var p in detailPantsId){
	var subItemCodeP = subItemCode.PANTS;
	var optionCode = ptDetailOptionCodeList[p];
	var optionBranchCode = OptionDetailBranchCodeList.pantsDetailOptionBranchCode[p];
	var optionBtanchDetailCode = OptionBranchDetailCodeList.pantsOptionBranchDetailCode[p];

	jQuery("#" + detailPantsId[p] + "_app" ).html(itemCode + subItemCodeP + "${orderForm.optionPantsStandardInfo.opPantsModel}" + optionCode + optionBranchCode + optionBtanchDetailCode);
}

//PANTS2のsub_item_code + model_code + option_code + option_branch_code + option_btanch_detail_code
for(var p2 in detailPants2Id){
	var subItemCodeP2 = subItemCode.PANTS2;
	var optionCode = ptDetail2OptionCodeList[p2];
	var optionBranchCode = OptionDetailBranchCodeList.pants2DetailOptionBranchCode[p2];
	var optionBtanchDetailCode = OptionBranchDetailCodeList.pants2OptionBranchDetailCode[p2];

	jQuery("#" + detailPants2Id[p2] + "_app").html(itemCode + subItemCodeP2 + "${orderForm.optionPants2StandardInfo.op2PantsModel}" + optionCode + optionBranchCode + optionBtanchDetailCode);
}

//JACKETのsub_item_code + model_code + option_code + option_branch_code
for(var j in jacketId){
	var subItemCodeJ = subItemCode.JACKET;
	var optionCode = jkOptionCodeList[j];
	var optionBranchCode = OptionBranchCodeList.jacketOptionBranchCode[j];
	
	jQuery("#" + jacketId[j] ).html(itemCode + subItemCodeJ + "${orderForm.optionJacketStandardInfo.ojJacketModel}" + optionCode + optionBranchCode);
}

//GILETのsub_item_code + model_code + option_code + option_branch_code
for(var g in giletId){
	var subItemCodeG = subItemCode.GILET;
	var optionCode = gtOptionCodeList[g];
	var optionBranchCode = OptionBranchCodeList.giletOptionBranchCode[g];

	jQuery("#" + giletId[g] ).html(itemCode + subItemCodeG + "${orderForm.optionGiletStandardInfo.ogGiletModel}" + optionCode + optionBranchCode);
}

//PANTSのsub_item_code + model_code + option_code + option_branch_code
for(var p in pantsId){
	var subItemCodeP = subItemCode.PANTS;
	var optionCode = ptOptionCodeList[p];
	var optionBranchCode = OptionBranchCodeList.pantsOptionBranchCode[p];

	jQuery("#" + pantsId[p] ).html(itemCode + subItemCodeP + "${orderForm.optionPantsStandardInfo.opPantsModel}" + optionCode + optionBranchCode);
}

//PANTS2のsub_item_code + model_code + option_code + option_branch_code
for(var p2 in pants2Id){
	var subItemCodeP2 = subItemCode.PANTS2;
	var optionCode = pt2OptionCodeList[p2];
	var optionBranchCode = OptionBranchCodeList.pants2OptionBranchCode[p2];

	jQuery("#" + pants2Id[p2] ).html(itemCode + subItemCodeP2 + "${orderForm.optionPants2StandardInfo.op2PantsModel}" + optionCode + optionBranchCode);
}

//オプション金額の表示
jQuery.ajax({
	 type:"get",
	 url: contextPath + "/order/getBranchPrice",
	 data:{"orderPattern":"PO"},
	 dataType:"json",
	 contentType:"application/json",
	 success:function(result){
		 jQuery("label[style='display:none']").each(function(){
			 var labelHtml= jQuery(this).html();
			 var labelAppHtml= jQuery("#" + this.id + "_app").html();
			 for(var i of result){
				 if((i.orderKeyCode).substring(2,4) == "02"){
					 if("${orderForm.optionJacketStandardInfo.ojFrontBtnCntMap[orderForm.optionJacketStandardInfo.ojFrontBtnCnt]}" == "ダブル6つボタン"){
						 if(i.orderKeyCode == labelHtml && i.orderDetailKeyCode == null){
								if(i.orderBranchDoublePrice != 0){
									jQuery("#" + this.id +"_appear").html(formatMoney(i.orderBranchDoublePrice,0,"￥"));
									}
								else if(i.orderBranchDoublePrice == 0){
									jQuery("#" + this.id +"_appear").html("無料");
									}
							}
						 else if(i.orderKeyCode == labelHtml && i.orderDetailKeyCode == labelAppHtml){
								if(i.orderBranchDoublePrice == 0 && i.orderBranchDetailDoublePrice == 0){
									jQuery("#" + this.id +"_app_appear").html("無料");
									}
								else if(i.orderBranchDoublePrice != 0 || i.orderBranchDetailDoublePrice != 0){
									var orderBranchDoublePrice = Number(i.orderBranchDoublePrice);
									var orderBranchDetailDoublePrice = Number(i.orderBranchDetailDoublePrice);
									jQuery("#" + this.id +"_app_appear").html(formatMoney((orderBranchDoublePrice + orderBranchDetailDoublePrice),0,"￥"));
									}
								}
						 }
					 else if("${orderForm.optionJacketStandardInfo.ojFrontBtnCntMap[orderForm.optionJacketStandardInfo.ojFrontBtnCnt]}" == "1つボタン" || "${orderForm.optionJacketStandardInfo.ojFrontBtnCntMap[orderForm.optionJacketStandardInfo.ojFrontBtnCnt]}" == "2つボタン"){
						 if(i.orderKeyCode == labelHtml && i.orderDetailKeyCode == null){
								if(i.orderBranchPrice != 0){
									jQuery("#" + this.id +"_appear").html(formatMoney(i.orderBranchPrice,0,"￥"));
									}
								else if(i.orderBranchPrice == 0){
									jQuery("#" + this.id +"_appear").html("無料");
									}
							}
							else if(i.orderKeyCode == labelHtml && i.orderDetailKeyCode == labelAppHtml){
								if(i.orderBranchPrice == 0 && i.orderBranchDetailPrice ==0){
									jQuery("#" + this.id +"_app_appear").html("無料");
									}
								else if(i.orderBranchPrice != 0 || i.orderBranchDetailPrice !=0){
									var orderBranchPrice = Number(i.orderBranchPrice);
									var orderBranchDetailPrice = Number(i.orderBranchDetailPrice);
									jQuery("#" + this.id +"_app_appear").html(formatMoney((orderBranchPrice + orderBranchDetailPrice),0,"￥"));
									}
								}
						 }	
					 }
				 	else{
					 	if(i.orderKeyCode == labelHtml && i.orderDetailKeyCode == null){
							if(i.orderBranchPrice != 0){
								jQuery("#" + this.id +"_appear").html(formatMoney(i.orderBranchPrice,0,"￥"));
								}
							else if(i.orderBranchPrice == 0){
								jQuery("#" + this.id +"_appear").html("無料");
								}
						}
						else if(i.orderKeyCode == labelHtml && i.orderDetailKeyCode == labelAppHtml){
							if(i.orderBranchPrice == 0 && i.orderBranchDetailPrice ==0){
								jQuery("#" + this.id +"_app_appear").html("無料");
							}
							else if(i.orderBranchPrice != 0 || i.orderBranchDetailPrice !=0){
								var orderBranchPrice = Number(i.orderBranchPrice);
								var orderBranchDetailPrice = Number(i.orderBranchDetailPrice);
								jQuery("#" + this.id +"_app_appear").html(formatMoney((orderBranchPrice + orderBranchDetailPrice),0,"￥"));
								}
							}
					 }
					 }
			 var labelAppearHtml= jQuery("#" + this.id + "_appear").html();
			 var labelAppAppearHtml= jQuery("#" + this.id + "_app_appear").html();
			 if(labelAppearHtml == ""){
				 jQuery("#" + this.id +"_appear").html("無料");
				 }
			 if(labelAppAppearHtml == ""){
				 jQuery("#" + this.id +"_app_appear").html("無料");
				 }
				});
			 }
	 });

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

var statusList = {T0:"一時保存",T1:"取り置き",T2:"登録済",T3:"会計済",T4:"商品部承認済",T5:"メーカー承認済",T6:"仕入済",T7:"お渡し済"};
jQuery("#status_appear").html(statusList["${orderForm.status}"]);

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

//pants股下初期値表示
if("${orderForm.adjustPantsStandardInfo.corPtLeftinseamGross }" == '' && "${orderForm.adjustPantsStandardInfo.corPtRightinseamGross }" == ''){
	jQuery("#pantsCorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右 000.0');
	}
else if("${orderForm.adjustPantsStandardInfo.corPtLeftinseamGross }" == '' && "${orderForm.adjustPantsStandardInfo.corPtRightinseamGross }" != ''){
	jQuery("#pantsCorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右 ' + "${orderForm.adjustPantsStandardInfo.corPtRightinseamGross }");
}
else if("${orderForm.adjustPantsStandardInfo.corPtLeftinseamGross }" != '' && "${orderForm.adjustPantsStandardInfo.corPtRightinseamGross }" == ''){
	jQuery("#pantsCorinseamGross" ).html('左 ' +"${orderForm.adjustPantsStandardInfo.corPtLeftinseamGross }" + 'cm &nbsp &nbsp &nbsp  右 000.0');
}
else{
	jQuery("#pantsCorinseamGross" ).html('左 ' +"${orderForm.adjustPantsStandardInfo.corPtLeftinseamGross }" + 'cm &nbsp &nbsp &nbsp 右 ' + "${orderForm.adjustPantsStandardInfo.corPtRightinseamGross }");
	}

//pants2股下初期値表示
if("${orderForm.adjustPants2StandardInfo.corPt2LeftinseamGross }" == '' && "${orderForm.adjustPants2StandardInfo.corPt2RightinseamGross }" == ''){
	jQuery("#pants2CorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右000.0');
	}
else if("${orderForm.adjustPants2StandardInfo.corPt2LeftinseamGross }" == '' && "${orderForm.adjustPants2StandardInfo.corPt2RightinseamGross }" != ''){
	jQuery("#pants2CorinseamGross" ).html('左 000.0cm &nbsp &nbsp &nbsp 右 ' + "${orderForm.adjustPants2StandardInfo.corPt2RightinseamGross }");
}
else if("${orderForm.adjustPants2StandardInfo.corPt2LeftinseamGross }" != '' && "${orderForm.adjustPants2StandardInfo.corPt2RightinseamGross }" == ''){
	jQuery("#pants2CorinseamGross" ).html('左 ' +"${orderForm.adjustPants2StandardInfo.corPt2LeftinseamGross }" + 'cm &nbsp &nbsp &nbsp 右000.0');
}
else{
	jQuery("#pants2CorinseamGross" ).html('左 ' +"${orderForm.adjustPants2StandardInfo.corPt2LeftinseamGross }" + 'cm &nbsp &nbsp &nbsp 右 ' + "${orderForm.adjustPants2StandardInfo.corPt2RightinseamGross }");
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
var custShopDeliveryDate = "${orderForm.customerMessageInfo.custShopDeliveryDate}";
if (custShopDeliveryDate != null) {
	jQuery("#cust_shop_delivery_date").html(
			dateFormat(custShopDeliveryDate))
}

//JACKETモデル
if("${orderForm.productItem}" == "01"){
	jQuery("#ojJacketModel_appear").html(formatMoney("${priceMap.doubleJACKET}",0,"￥"));
}
else if("${orderForm.productItem}" == "02"){
	jQuery("#ojJacketModel_appear").html(formatMoney("${priceMap.singleDoubleJACKET}",0,"￥"));
}

//３Piece
jQuery("#productIs3Piece_appear").html(formatMoney("${priceMap.price3Piece}",0,"￥"));
//スペアパンツ
jQuery("#productSparePantsClass_appear").html(formatMoney("${priceMap.sparePants}",0,"￥"));

function pdfDownload(sign){
	var orderId = "${orderForm.customerMessageInfo.orderId}";
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
			}
	    }
	});

}

//--------------------------------------------
//確認チェック
//--------------------------------------------

function imageCheck(){
	//会員番号
	var custCd = "${orderForm.customerMessageInfo.custCd}";

	if(isEmpty(custCd)){
		appendAlert('errormssage', getMsgByOneArg('msg114', '会員番号'));
		return false;
	}
	else{
		appendAlertDel('errormssage');
	}

	//名簿納期
	var custDeliverDate = "${orderForm.customerMessageInfo.custDeliverDate}"; 

	if(isEmpty(custDeliverDate)){
		appendAlert('errormssage', getMsgByOneArg('msg114', '名簿納期'));
		return false;
	}
	else{
		appendAlertDel('errormssage');
	}

	//お渡し日
	var custShopDeliveryDate = "${orderForm.customerMessageInfo.custShopDeliveryDate}";

	if(isEmpty(custShopDeliveryDate)){
		appendAlert('errormssage', getMsgByOneArg('msg114', 'お渡し日'));
		return false;
	}
	else{
		appendAlertDel('errormssage');
	}

	//スタッフ
	var custStaff = "${orderForm.customerMessageInfo.custStaff}";

	if(isEmpty(custStaff)){
		appendAlert('errormssage', getMsgByOneArg('msg114', 'スタッフ'));
		return false;
	}
	else{
		appendAlertDel('errormssage');
	}

	//出荷先
	var destination = "${orderForm.customerMessageInfo.custShippingDestination}";
	//出荷先_他店舗コード
	var custShippingDestnationOtherstore = "${orderForm.customerMessageInfo.custShippingDestnationOtherstore}";

	if(destination == "05"){
		if(isEmpty(custShippingDestnationOtherstore)){
			appendAlert('errormssage', getMsgByOneArg('msg114', '他店舗'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
	}

	//生地品番
	var productFabricNo = "${orderForm.productFabricNo}";

	if(isEmpty(productFabricNo)){
		appendAlert('errormssage', getMsgByOneArg('msg114', '生地品番'));
		return false;
	}
	else{
		appendAlertDel('errormssage');
	}

	//刺繍ネーム
	var productEmbroideryNm = "${orderForm.productEmbroideryNm}";
	//刺繍入れ
	var productEmbroideryNecessity = "${orderForm.productEmbroideryNecessity}";

	if(productEmbroideryNecessity == 1){
		if(isEmpty(productEmbroideryNm)){
			appendAlert('errormssage', getMsgByOneArg('msg114', '刺繍ネーム'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
	}

	//商品情報_ITEM
	var item = "${orderForm.productItem}";
	//商品情報_３Piece
	var productIs3Piece = "${orderForm.productIs3Piece}";
	//商品情報_スペアパンツ
	var productSparePants = "${orderForm.productSparePantsClass}";
	//３Pieceは有り、スペアパンツは有り
	var productIs3PieceAndSparePantsIsYes = "0009902";
	
	//JACKET_モデル
	var jkModel = "${orderForm.optionJacketStandardInfo.ojJacketModelMap[orderForm.optionJacketStandardInfo.ojJacketModel]}";
	//JACKET_Drop
	var corJkDrop = "${orderForm.adjustJacketStandardInfo.sizeFigure}";
	//JACKET_号数
	var corJkSize = "${orderForm.adjustJacketStandardInfo.sizeNumber}";
	
	//PANTS_モデル
	var ptModel = "${orderForm.optionPantsStandardInfo.opPantsModelMap[orderForm.optionPantsStandardInfo.opPantsModel]}";
	//PANTS_Drop
	var corPtDrop = "${orderForm.adjustPantsStandardInfo.sizeFigure}";
	//PANTS_号数
	var corPtSize = "${orderForm.adjustPantsStandardInfo.sizeNumber}";
	
	//GILET_モデル
	var glModel = "${orderForm.optionGiletStandardInfo.ogGiletModelMap[orderForm.optionGiletStandardInfo.ogGiletModel]}";
	//GILET_Drop
	var corGlDrop = "${orderForm.adjustGiletStandardInfo.sizeFigure}";
	//GILET_号数
	var corGlSize = "${orderForm.adjustGiletStandardInfo.sizeNumber}";
	
	//2PANTS_モデル
	var pt2Model = "${orderForm.optionPants2StandardInfo.op2PantsModelMap[orderForm.optionPants2StandardInfo.op2PantsModel]}";
	//2PANTS_Drop
	var corPt2Drop = "${orderForm.adjustPants2StandardInfo.sizeFigure}";
	//2PANTS_号数
	var corPt2Size = "${orderForm.adjustPants2StandardInfo.sizeNumber}";
	
	
	if(item == "01"){
		//JACKET_モデル
		if(isEmpty(jkModel)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKETモデル'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
		//JACKET_ラペルデザイン
		var jkLapelDesign = "${orderForm.optionJacketStandardInfo.ojLapelDesignMap[orderForm.optionJacketStandardInfo.ojLapelDesign]}";

		if(isEmpty(jkLapelDesign)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'ラペルデザイン'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
		//JACKET_Drop
		if(isEmpty(corJkDrop)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET体型'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
		//JACKET_号数
		if(isEmpty(corJkSize)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET号数'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}


		//PANTS_モデル
		if(isEmpty(ptModel)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTSモデル'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
		
		//PANTS_Drop
		if(isEmpty(corPtDrop)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS体型'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}

		//PANTS_号数
		if(isEmpty(corPtSize)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS号数'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
		
		if(productIs3Piece == productIs3PieceAndSparePantsIsYes && productSparePants == productIs3PieceAndSparePantsIsYes){
			//GILET_モデル
			if(isEmpty(glModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'GILETモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//GILET_Drop
			if(isEmpty(corGlDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

			//GILET_号数
			if(isEmpty(corGlSize)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}


			//2PANTS_モデル
			if(isEmpty(pt2Model)){
				appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTSモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//2PANTS_Drop
			if(isEmpty(corPt2Drop)){
				appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTS体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

			//2PANTS_号数
			if(isEmpty(corPt2Size)){
				appendAlert('errormssage', getMsgByOneArg('msg114', '2PANTS号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
		}
		else if(productIs3Piece == productIs3PieceAndSparePantsIsYes && productSparePants != productIs3PieceAndSparePantsIsYes){
			//GILET_モデル
			if(isEmpty(glModel)){
				appendAlert('errormssage', getMsgByOneArg('msg114', 'GILETモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//GILET_Drop
			if(isEmpty(corGlDrop)){
				appendAlert('errormssage', getMsgByOneArg('msg001', 'GILET体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

			//GILET_号数
			if(isEmpty(corGlSize)){
				appendAlert('errormssage', getMsgByOneArg('msg001', 'GILET号数'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
		}
		else if(productIs3Piece != productIs3PieceAndSparePantsIsYes && productSparePants == productIs3PieceAndSparePantsIsYes){
			//2PANTS_モデル
			if(isEmpty(pt2Model)){
				appendAlert('errormssage', getMsgByOneArg('msg001', '2PANTSモデル'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}
			
			//2PANTS_Drop
			if(isEmpty(corPt2Drop)){
				appendAlert('errormssage', getMsgByOneArg('msg001', '2PANTS体型'));
				return false;
			}
			else{
				appendAlertDel('errormssage');
			}

			//2PANTS_号数
			if(isEmpty(corPt2Size)){
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
		if(isEmpty(jkModel)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKETモデル'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
		//JACKET_ラペルデザイン
		var jkLapelDesign = "${orderForm.optionJacketStandardInfo.ojLapelDesignMap[orderForm.optionJacketStandardInfo.ojLapelDesign]}";

		if(isEmpty(jkLapelDesign)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'ラペルデザイン'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
		//JACKET_Drop
		if(isEmpty(corJkDrop)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET体型'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
		//JACKET_号数
		if(isEmpty(corJkSize)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'JACKET号数'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
	}
	else if(item == "03"){
		//PANTS_モデル
		if(isEmpty(ptModel)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTSモデル'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
		
		//PANTS_Drop
		if(isEmpty(corPtDrop)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS体型'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}

		//PANTS_号数
		if(isEmpty(corPtSize)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'PANTS号数'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}

	}
	else if(item == "04"){
		//GILET_モデル
		if(isEmpty(glModel)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'GILETモデル'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
		
		//GILET_Drop
		if(isEmpty(corGlDrop)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET体型'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}

		//GILET_号数
		if(isEmpty(corGlSize)){
			appendAlert('errormssage', getMsgByOneArg('msg114', 'GILET号数'));
			return false;
		}
		else{
			appendAlertDel('errormssage');
		}
	}
 }
</script>

