<style>

.red{ 
    background-color: #FA8072;
}

.gray{ 
    background-color: #BDBDBD;
}

.yellow{
	background-color: #FF9224;
} 

.cell-del-type {
	text-align: center;
    line-height:40px
}

.cell-money {
  text-align: right;
  line-height:45px
}
.cell-other {
  text-align: left;
  line-height:45px
}
.col-grid {
	position: relative;
	width: 100%;
	min-height: 1px;
	padding-right: 15px;
	padding-left: 15px;
	-ms-flex: 0 0 99%;
	flex: 0 0 99%;
	max-width: 99%
}
.btn_off {
	cursor:pointer;
	vertical-align: bottom;
	background: #996600;
	border: 1px solid #85786A;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	color: #fff;
	width: 70px;
	height: 30px;
	padding: 10 10 20 10;
	font-size: 11px;
	font-weight: bold;
	position: relative;
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.3);
	border: 0px solid #E25A00;
	border: 0px solid #85786A
}

.btn_brown {
	background: #996600;
	border: 0px solid #996600;
}

.open_close {
	font-size:18px;
	color:#6B6B6B;
	line-height:40px;
	font-weight:800;
	text-align:center
}
.alert-error {
    background: #fff1f0;
    color: #d85030;
    border-color: rgba(216, 80, 48, 0.3);
    width:770px;
}
.slick-cell.selected {
	background-color: #FBB;
}
</style>
<spring:eval var="sessionContent" expression="@sessionContent" />

<div class="breadcrumbs">
	<div class="col-sm-4">
	    <div class="page-header float-left">
	        <div class="page-title">
	            <h1>オーダー一覧</h1>
	        </div>
	    </div>
	</div>
</div>

<div class="content mt-3">
    <!-- エラーメッセージのdiv -->
	<div class="alert alert-error" id="errorMessage" style="display:none"></div>
	<!-- 検索条件のdiv -->
	<div id = "conditionDiv">
		<div class="animated fadeIn">
		<div class="card" id="nav1_custom_div">
        <div class="card-body">
			<!-- 検索条件部分 start -->
			<form:form id ="conditionForm" method="post" modelAttribute="orderListForm" enctype="multipart/form-data" class="form-horizontal">
				<div class="row">
					<!-- 左側項目start -->
					<div class="col col-lg-6">
						<!-- 注文ID -->
						<div class="row form-group">
							<div class="col col-md-4">
								<label class=" form-control-label">注文ID</label>
							</div>
							<div class="col-12 col-md-8">
								<form:input path="orderId" type="text" id="orderId"
									placeholder=""
									class="input-sm form-control-sm form-control"
									/>
							</div>
						</div>
						<!-- ステータス -->
						<div class="row form-group">
							<div class="col col-md-4">
								<label class=" form-control-label">ステータス</label>
							</div>
							<div class="col-12 col-md-8">

								<c:choose>
									<c:when test="${sessionContent.authority == '01' or sessionContent.authority == '02'}">

										<form:select path="tscStatus" id="tscStatus"
											class="form-control-sm form-control">
											<form:option id="" value=""></form:option>
											<form:option value="T0">一時保存</form:option>
											<form:option value="T1">取り置き</form:option>
											<form:option value="T2">登録済</form:option>
											<form:option value="T3">会計済</form:option>
											<form:option value="T4">商品部承認済</form:option>
											<form:option value="T5">メーカー承認済</form:option>
											<form:option value="F1">生産開始</form:option>
											<form:option value="F2">生産終了</form:option>
											<form:option value="T6">仕入済</form:option>
											<form:option value="T7">お渡し済</form:option>
										</form:select>
									</c:when>
									<c:when test="${sessionContent.authority == '03'}">

										<form:select path="tscStatus" id="tscStatus"
											class="form-control-sm form-control">
											<form:option id="" value=""></form:option>
											<form:option value="T2">登録済</form:option>
											<form:option value="T3">会計済</form:option>
											<form:option value="T4">商品部承認済</form:option>
											<form:option value="T5">メーカー承認済</form:option>
											<form:option value="F1">生産開始</form:option>
											<form:option value="F2">生産終了</form:option>
											<form:option value="T6">仕入済</form:option>
											<form:option value="T7">お渡し済</form:option>
										</form:select>
									</c:when>
									<c:when test="${sessionContent.authority == '04' or sessionContent.authority == '05'}">

										<form:select path="tscStatus" id="tscStatus"
											class="form-control-sm form-control">
											<form:option id="" value=""></form:option>
											<form:option value="F1">生産開始</form:option>
											<form:option value="F2">生産終了</form:option>
											<form:option value="T6">仕入済</form:option>
											<form:option value="T7">お渡し済</form:option>
										</form:select>
									</c:when>
								</c:choose>
							</div>
						</div>

						<!-- ITEM -->
						<div class="row form-group">
							<c:choose>
								<c:when test="${sessionContent.category == 'CO'}">
									<!-- ITEM(CO) -->
									<div class="col col-md-4">
										<label class=" form-control-label">ITEM(CO)</label>
									</div>
									<div class="col-12 col-md-8">
										<form:select path="productItem" id="productItem"
											class="form-control-sm form-control">
											<form:option value=""></form:option>
											<form:option value="01">SUIT(ALL)</form:option>
											<form:option value="21">SUIT(2P)</form:option>
											<form:option value="22">SUIT(2PP)</form:option>
											<form:option value="31">SUIT(3P)</form:option>
											<form:option value="32">SUIT(3P2PP)</form:option>
											<form:option value="02">JACKET</form:option>
											<form:option value="03">PANTS</form:option>
											<form:option value="04">GILET</form:option>
											<form:option value="06">COAT</form:option>
											<form:option value="05">SHIRT</form:option>
										</form:select>
									</div>
								</c:when>
								<c:when test="${sessionContent.category == 'PO'}">
									<!-- ITEM(PO) -->
									<div class="col col-md-4">
										<label class=" form-control-label">ITEM(PO)</label>
									</div>
									<div class="col-12 col-md-8">
										<form:select path="productItem" id="productItem"
											class="form-control-sm form-control">
											<form:option value=""></form:option>
											<form:option value="01">SUIT(ALL)</form:option>
											<form:option value="21">SUIT(2P)</form:option>
											<form:option value="22">SUIT(2PP)</form:option>
											<form:option value="31">SUIT(3P)</form:option>
											<form:option value="32">SUIT(3P2PP)</form:option>
											<form:option value="02">JACKET</form:option>
											<form:option value="03">PANTS</form:option>
											<form:option value="04">GILET</form:option>
										</form:select>
									</div>
								</c:when>
							</c:choose>
						</div>
						<!-- black -->
						<c:choose>
							<c:when
								test="${sessionContent.authority == '01' or sessionContent.authority == '02' or sessionContent.authority == '03'}">
								<div class="row form-group">
									<div class="col col-md-4">
										<label class=" form-control-label">　</label>
									</div>
									<div class="col-12 col-md-8"></div>
								</div>
							</c:when>
						</c:choose>
						<!-- 承り日 -->
						<div class="row form-group">
							<div class="col col-md-4">
								<label class=" form-control-label">承り日</label>
							</div>
							<div class="col-12 col-md-8">
								<div class="form-check-inline form-check">
									<form:input path="productOrderdDateFrom"
										id="productOrderdDateFrom" type="text" placeholder="年/月/日"
										class="input-sm form-control-sm form-control col-md-5" />
									&nbsp;〜&nbsp;
									<form:input path="productOrderdDateTo"
										id="productOrderdDateTo" type="text" placeholder="年/月/日"
										class="input-sm form-control-sm form-control col-md-5" />
								</div>
							</div>
						</div>
						<c:choose>
							<c:when
								test="${sessionContent.authority == '01' or sessionContent.authority == '02' or sessionContent.authority == '03'}">
								<!-- 店舗、 商品部、メーカー　登録の場合　 　　「名簿納期」を表示する-->
								<div class="row form-group">
									<div class="col col-md-4">
										<label class=" form-control-label">名簿納期</label>
									</div>
									<div class="col-12 col-md-8">
										<div class="form-check-inline form-check">
											<form:input path="custDeliverDateFrom"
												id="custDeliverDateFrom" type="text" placeholder="年/月/日"
												class="input-sm form-control-sm form-control col-md-5" />
											&nbsp;〜&nbsp;
											<form:input path="custDeliverDateTo" id="custDeliverDateTo"
												type="text" placeholder="年/月/日"
												class="input-sm form-control-sm form-control col-md-5" />
										</div>
									</div>
								</div>
							</c:when>
							<c:when
								test="${sessionContent.authority == '04' or sessionContent.authority == '05'}">
								<!-- 工場、倉庫　登録の場合　 　　「取消の注文を含む」を表示する-->
								<div class="row form-group">
									<div class="col col-md-4">
										<label class=" form-control-label">　</label>
									</div>
									<div class="col-12 col-md-8">
										<div class="form-check-inline form-check">
											<label for="isCancelled" class="form-check-label">
												<form:checkbox path="isCancelled" id="isCancelled"
													onclick="checkboxOnclick(this)" class="form-check-input" />
												取消の注文を含む
											</label>
										</div>
									</div>
								</div>
							</c:when>
						</c:choose>

						<c:choose>
							<c:when
								test="${sessionContent.authority == '01' or sessionContent.authority == '02' or sessionContent.authority == '03'}">
								<!-- 店舗、 商品部、メーカー　登録の場合　 　　「取消の注文を含む」を表示する-->
								<div class="row form-group">
									<div class="col col-md-4">
										<label class=" form-control-label">　</label>
									</div>
									<div class="col-12 col-md-8">
										<div class="form-check-inline form-check">
											<label for="isCancelled" class="form-check-label">
												<form:checkbox path="isCancelled" id="isCancelled"
													onclick="checkboxOnclick(this)" class="form-check-input" />
												取消の注文を含む
											</label>
										</div>
									</div>
								</div>
							</c:when>
						</c:choose>

						<c:choose>
							<c:when
								test="${sessionContent.authority == '01' or sessionContent.authority == '02'}">
								<!-- 店舗、 商品部　登録の場合　 　　「工場自動連携失敗のみ」を表示する-->
								<div class="row form-group">
									<div class="col col-md-4">
										<label class=" form-control-label">　</label>
									</div>
									<div class="col-12 col-md-6">
										<div class="form-check-inline form-check">
											<label for="isSendFailure" class="form-check-label">
												<form:checkbox path="isSendFailure" id="isSendFailure"
													onclick="checkboxOnclick(this)" class="form-check-input" />
												工場自動連携失敗のみ
											</label>
										</div>
									</div>
								</div>
							</c:when>
						</c:choose>
					</div>
					<!-- 左側項目   end -->

					<!-- 右側項目 start -->
					<div class="col col-lg-6">
						<!-- 会員番号 -->
						<div class="row form-group">
							<div class="col col-md-4">
								<label class=" form-control-label">会員番号</label>
							</div>
							<div class="col-12 col-md-8">
								<form:input path="custCd" type="text" id="custCd"
									placeholder=""
									class="input-sm form-control-sm form-control"
									/>
							</div>
						</div>
						<!-- 営業担当者 -->
						<div class="row form-group">
							<div class="col col-md-4">
								<label class=" form-control-label">営業担当者</label>
							</div>
							<div class="col-12 col-md-8">
								<form:input path="storeStaffNm" id="storeStaffNm" type="text"
									placeholder=""
									class="input-sm form-control-sm form-control"
									/>
							</div>
						</div>
						<!-- 生地品番 -->
						<div class="row form-group">
							<div class="col col-md-4">
								<label class=" form-control-label">生地品番</label>
							</div>
							<div class="col-12 col-md-8">
								<form:input path="productFabricNo" id="productFabricNo"
									type="text" placeholder=""
									class="input-sm form-control-sm form-control"
									/>
							</div>
						</div>

						<c:choose>
							<c:when
								test="${sessionContent.authority == '01' or sessionContent.authority == '02' or sessionContent.authority == '03'}">
								<!-- 店舗、 商品部、メーカー　登録の場合　 　　「生地インポーター」を表示する-->
								<div class="row form-group">
									<div class="col col-md-4">
										<label class=" form-control-label">生地インポーター</label>
									</div>
									<div class="col-12 col-md-8">
										<form:select path="fablicImporter" id="fablicImporter"
											class="form-control-sm form-control">
											<form:option value=""></form:option>
											<form:option value="01">服良</form:option>
											<form:option value="02">蝶理</form:option>
											<form:option value="03">鷹岡</form:option>
											<form:option value="04">SCABAL</form:option>
											<form:option value="05">DORMEUL</form:option>
											<form:option value="06">御幸毛織</form:option>
											<form:option value="07">マルキシ</form:option>
										</form:select>
									</div>
								</div>
							</c:when>
						</c:choose>
						<!-- お渡し日-->
						<div class="row form-group">
							<div class="col col-md-4">
								<label class=" form-control-label">お渡し日</label>
							</div>
							<div class="col-12 col-md-8">
								<div class="form-check-inline form-check">
									<form:input path="custShopDeliveryDateFrom"
										id="custShopDeliveryDateFrom" type="text" placeholder="年/月/日"
										class="input-sm form-control-sm form-control col-md-5" />
									&nbsp;〜&nbsp;
									<form:input path="custShopDeliveryDateTo"
										id="custShopDeliveryDateTo" type="text" placeholder="年/月/日"
										class="input-sm form-control-sm form-control col-md-5" />
								</div>
							</div>
						</div>
						<!-- 更新日-->
						<div class="row form-group">
							<div class="col col-md-4">
								<label class=" form-control-label">更新日</label>
							</div>
							<div class="col-12 col-md-8">
								<div class="form-check-inline form-check">
									<form:input path="updatedAtFrom" id="updatedAtFrom"
										type="text" placeholder="年/月/日"
										class="input-sm form-control-sm form-control col-md-5" />
									&nbsp;〜&nbsp;
									<form:input path="updatedAtTo" id="updatedAtTo" type="text"
										placeholder="年/月/日"
										class="input-sm form-control-sm form-control col-md-5" />
								</div>
							</div>
						</div>

						<c:choose>
							<c:when
								test="${sessionContent.authority == '01' or sessionContent.authority == '02' or sessionContent.authority == '03'}">
								<!-- 店舗、 商品部、メーカー　登録の場合　 　　「未会計のみ」或いは「未承認のみ」を表示する-->
								<div class="row form-group">
									<div class="col-12 col-md-8">
										<div class="form-check-inline form-check">
											<c:choose>
												<c:when
													test="${sessionContent.authority == '01' or sessionContent.authority == '02'}">
													<!-- 店舗、 商品部　登録の場合　 　　「未会計のみ」を表示する-->
													<label for="isAccount" class="form-check-label">
														<form:checkbox path="isAccount" id="isAccount"
															onclick="checkboxOnclick(this)" placeholder=""
															class="form-check-input" />
														未会計のみ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													</label>
												</c:when>
												<%-- <c:when test="${sessionContent.authority == '03'}">
													<label for="chkViewYetOrder" class="form-check-label">
													</label>
												</c:when> --%>
											</c:choose>
											<c:choose>
												<c:when
													test="${sessionContent.authority == '02' or sessionContent.authority == '03'}">
													<!-- 商品部、メーカー　登録の場合　 　　「未承認のみ」を表示する-->
													<label for="isConfirm" class="form-check-label">
														<form:checkbox path="isConfirm" id="isConfirm"
															onclick="checkboxOnclick(this)" placeholder=""
															class="form-check-input" /> 未承認のみ
													</label>
												</c:when>
												<%-- <c:when test="${sessionContent.authority == '01'}">
													<label for="chkViewYetCheck" class="form-check-label">
													</label>
												</c:when> --%>
											</c:choose>
										</div>
									</div>
									<div class="col col-md-4">
										<label class=" form-control-label">　</label>
									</div>
								</div>
							</c:when>
						</c:choose>

						<div class="row form-group">
							<c:choose>
								<c:when test="${sessionContent.authority == '01'}">
									<!-- 店舗 登録の場合　 　　「他店舗の注文を含む（参照のみ）」を表示する-->
									<div class="col-12 col-md-8">
										<div class="form-check-inline form-check">
											<label for="isOtherShop" class="form-check-label">
												<form:checkbox path="isOtherShop" id="isOtherShop"
													onclick="checkboxOnclick(this)" placeholder=""
													class="form-check-input" /> 他店舗の注文を含む（参照のみ）
											</label>
										</div>
									</div>
									<div class="col col-md-4">
										<label class=" form-control-label">　</label>
									</div>

								</c:when>
								<c:when test="${sessionContent.authority != '01'}">
									<!-- 店舗 登録の場合　 　　「他店舗の注文を含む（参照のみ）」を表示する-->
									<div class="col-12 col-md-8"></div>
									<div class="col col-md-4">
										<label class=" form-control-label">　</label>
									</div>

								</c:when>
							</c:choose>
						</div>
					</div>
					<!-- 右側項目 end --> 

				</div>
			</form:form>
			<!-- 検索条件部分 End -->
		</div><!-- card body -->
        </div><!-- card -->
        </div><!-- animated -->

        <!-- 制御ボタン部分 Start -->
        <div class="row">
            <div class="col">　</div>
            <div class="col col-md-4">
                <button onclick="reset();" id="clear_button" class="btn btn-danger btn-block"><i class="fa fa-trash-alt"></i>&nbsp;クリア</button>
            </div>
            <div class="col col-md-4">
                <button id="searchButton" onclick="searchOrder();" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i>&nbsp;検索</button>
            </div>
            <div class="col">　</div>
        </div>
        <!-- 制御ボタン部分 End -->

	</div><!-- conditionDiv -->	

    <!-- 表示変更部 Start -->
    <div class="row">
        <div class="col">　</div>
        <div class="col col-md-12">
            <button type="button" id="toggleButton" class="btn btn-sm btn-warning btn-block">検索メニューを閉じる <i class="fa fa-caret-up"></i></button>
        </div>
    </div>
    <!-- 表示変更部 End -->
    
	<!-- 検索結果のdiv -->
	<div id="orderListDiv" style="display:none;">
		<div id="AccountOrConfirm" style="visibility:hidden;">
			<div class="row form-group"></div>
			<div class="row form-group">
				<c:choose>
					<c:when test="${sessionContent.authority == '02' or sessionContent.authority == '03'}">
						<!-- 商品部、メーカー　登録の場合　 　　「一括承認」を表示する-->
						<div id="ConfirmDiv" style="display:none" class="col col-md-3">
							<button onclick="gotoConfirmCheck();" class="btn btn-primary btn-block">一括承認 </button>
						</div>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${sessionContent.authority == '01' or sessionContent.authority == '02'}">
						<!-- 店舗、 商品部　登録の場合　 　　「会計を纏める」を表示する-->
						<div id="AccountDiv" style="display:none" class="col col-md-3">
							<button onclick="gotoAccountCheck();" class="btn btn-primary btn-block">会計を纏める</button>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
		
		<div class="row">
			<div class="col-grid">
				<div id="gridContainer">
					<div id="myGrid" style="width: 100%"></div>
					<div id="pager" style="width: 100%"></div>
				</div>
			</div>
		</div>
	
		<div class="row form-group"></div>
		<div class="row form-group">
		    <c:choose>
		       <c:when test="${sessionContent.authority == '02' or sessionContent.authority == '03'}">
		   	 	<!-- 商品部、メーカー　登録の場合　 　　「注文情報ダウンロード」を表示する-->
			<div class="col col-md-3">
		              <button id="orderExport" onclick="csvDownload();" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i>&nbsp;注文情報ダウンロード</button>
		    </div>
		       </c:when>
			</c:choose>
		
		</div>

	</div><!-- 検索結果のdiv　End -->
</div>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/bootstrap-datepicker3.css" type="text/css">
    <!-- 依存ライブラリの読み込み -->
    <script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/firebugx.js"></script>

	<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-1.11.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-ui-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery.event.drag-2.3.0.js"></script>

    <!-- SlickGridモジュールの読み込み -->
    <script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.core.js"></script>
    <script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.formatters.js"></script>
    <script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.editors.js"></script>
    <script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/plugins/slick.rowdetailview.js"></script>
    <script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/plugins/slick.rowselectionmodel.js"></script>
    <script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.grid.js"></script>
    <script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.dataview.js"></script>
    <script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/controls/slick.pager.js"></script>
    <script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/controls/slick.columnpicker.js"></script>

    <script src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
    <!-- 実装したJavaScriptファイルの読み込み -->
    <!--<script src="${pageContext.request.contextPath}/resources/app/js/default.js"></script>-->
    <script src="${pageContext.request.contextPath}/resources/app/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/app/js/bootstrap-datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/resources/app/js/jquery.blockUI.js"></script>

<script>
var dataView;
var grid;
var sortcol = "title";
var sortdir = 1;
var contextPath = $("meta[name='contextPath']").attr("content");
var searchNum = 0;

//TSCステータスのMap
var tscStatusMap = new Map();
tscStatusMap.set("T0","一時保存");
tscStatusMap.set("T1","取り置き");
tscStatusMap.set("T2","登録済");
tscStatusMap.set("T3","会計済");
tscStatusMap.set("T4","商品部承認済");
tscStatusMap.set("T5","メーカー承認済");
tscStatusMap.set("T6","仕入済");
tscStatusMap.set("T7","お渡し済");

//工場ステータスのMap
var makerFactoryStatusMap = new Map();
makerFactoryStatusMap.set("F0","生産開始前");
makerFactoryStatusMap.set("F1","生産開始");
makerFactoryStatusMap.set("F2","生産終了");

//工場自動連携ステータスのMap
var send2factoryStatusMap = new Map();
send2factoryStatusMap.set("0","送信前");
send2factoryStatusMap.set("1","送信済");
send2factoryStatusMap.set("2","再送信要");
send2factoryStatusMap.set("3","送信失敗");
send2factoryStatusMap.set("4","送信失敗");
send2factoryStatusMap.set("5","送信失敗");


var itemMap = new Map();
itemMap.set("01","SUIT(ALL)");
itemMap.set("21","SUIT(2P)");
itemMap.set("22","SUIT(2PP)");
itemMap.set("31","SUIT(3P)");
itemMap.set("32","SUIT(3P2PP)");
itemMap.set("02","JACKET");
itemMap.set("03","PANTS");
itemMap.set("04","GILET");
itemMap.set("05","SHIRT");
itemMap.set("06","COAT");

//登録権限を取得
var authority = "${sessionContent.authority}";
//co/poを取得
var orderPattern = "${sessionContent.category}";
//店舗コードを取得
var shopCode = "none";
if (authority == '01'){
	shopCode = "${sessionContent.belongCode}";
}

//サイズを調整する前に、最小の高さ/幅/塗りつぶしを定義します。
var DATAGRID_MIN_HEIGHT = 180;
var DATAGRID_MIN_WIDTH = 200;
var DATAGRID_BOTTOM_PADDING = 20;

//カレンダー表示の設定
jQuery('#productOrderdDateTo,#productOrderdDateFrom,#custDeliverDateFrom,#custDeliverDateTo,#custShopDeliveryDateFrom,#custShopDeliveryDateTo,#updatedAtFrom,#updatedAtTo').datepicker({
	   format: 'yyyy/mm/dd',
	    clearBtn: true,
	    language: 'ja',
	    todayBtn: "linked",
	    orientation: 'buttom auto',
	    todayHighlight: true,
	    autoclose: true
});

//データグリッドに自動的にサイズを調整するトリガーを追加します。有効にすると、自分でサイズを利用可能な空間に調整します。
function attachAutoResizeDataGrid(grid, gridId, gridContainerId) {
	var gridDomElm = $('#' + gridId);
	if (!gridDomElm || typeof gridDomElm.offset() === "undefined") {
		return null;
	}
	resizeToFitBrowserWindow(grid, gridId, gridContainerId);
	$(window).resize(function(){
		resizeToFitBrowserWindow(grid, gridId, gridContainerId);
		resizeToFitBrowserWindow(grid, gridId, gridContainerId);
	});
}

//利用可能な空間からdatagridの新しい高さと幅を計算します。
function calculateGridNewDimensions(gridId, gridContainerId) {
	var availableHeight = $(window).height() - $('#' + gridId).offset().top - DATAGRID_BOTTOM_PADDING;
	var availableWidth = $('#' + gridContainerId).width();
	var newHeight = availableHeight;
	var newWidth = availableWidth;
	if (newHeight < DATAGRID_MIN_HEIGHT) {
		newHeight = DATAGRID_MIN_HEIGHT;
	}
	if (newWidth < DATAGRID_MIN_WIDTH) {
		newWidth = DATAGRID_MIN_WIDTH;
	}
	return {
		height: 500,
		width: newWidth
	};
}

//データグリッドのサイズを調整して、ブラウザの高さと幅に合わせます。
function resizeToFitBrowserWindow(grid, gridId, gridContainerId) {
	var newSizes = calculateGridNewDimensions(gridId, gridContainerId);
	if (newSizes) {
		$('#' + gridId).height(newSizes.height);
		$('#' + gridId).width(newSizes.width);
		if (new RegExp('MSIE [6-8]').exec(navigator.userAgent) === null && grid) {
			grid.resizeCanvas();
		}
	}
    $("#pager").width($("#myGrid").width() + 2);
}

$(document).ready(function () {
	closeAlert('errorMessage', 'msg_oneShop');
	closeAlert('errorMessage', 'msg_noAccount');
	closeAlert('errorMessage', 'msg_download');
	closeAlert('errorMessage', 'msg_noResult');
	closeAlert('errorMessage', 'msg_noConfirm');
	closeAlert('errorMessage', 'msg_dataError');
	var initFlag = "${initFlag}";

	if (initFlag == "1"){
		searchOrder();
	}
	if (initFlag == "0"){
		//初期化のとき、検索結果Divを表示しない
		$("#orderListDiv").hide();
	}
	if (initFlag == "2"){
		searchOrder();
		//addAlert('errorMessage', 'msg_dataError', "data_error");
	}
	
}); 

function comparer(a, b) {
	  var x = a[sortcol], y = b[sortcol];
	  return (x == y ? 0 : (x > y ? 1 : -1));
	}

function mineFormatter ( row, cell, value, columnDef, dataContext ) {
  return value;
}

//検索条件をリアルする
function reset(){
    $("#orderId").val("");
	$("#custCd").val("");
	$("#tscStatus").val("");
	$("#storeStaffNm").val("");
	$("#productItem").val("");
	$("#fablicImporter").val("");
	$("#productFabricNo").val(""); 
	
	$("#productOrderdDateFrom").val("");
	$("#productOrderdDateTo").val("");
	$("#custShopDeliveryDateFrom").val("");
	$("#custShopDeliveryDateTo").val("");
	$("#custDeliverDateFrom").val("");
	$("#custDeliverDateTo").val("");
	$("#updatedAtFrom").val(""); 
	$("#updatedAtTo").val("");
	
	$("#isCancelled").attr("checked",false);
	$("#isAccount").attr("checked",false);
	$("#isConfirm").attr("checked",false);
	$("#isOtherShop").attr("checked",false);
	$("#isSendFailure").attr("checked",false);
	$("#errorMessage").hide();
	$("#searchButton").attr('disabled',false);  

	closeAlert('errorMessage', 'msg_oneShop');
	closeAlert('errorMessage', 'msg_noAccount');
	closeAlert('errorMessage', 'msg_download');
	closeAlert('errorMessage', 'msg_noResult');
	closeAlert('errorMessage', 'msg_noConfirm');
	closeAlert('errorMessage', 'msg_dataError');
  }

//検索
function searchOrder(){
	$('#orderListDiv').hide();
	$.blockUI({ message: '<div class="content mt-3"><img src="${pageContext.request.contextPath}/resources/app/images/loading.gif" .></div>' });
	var winWidth = 0;
	if (window.innerWidth){
		winWidth = window.innerWidth;
	}
	$("#orderListDiv").width(winWidth - 290);
	
		/* if(!$('#isAccount').prop('checked')) {
			columns.splice(0,1);
		}else{
			columns.splice(11,1);
		} */
		closeAlert('errorMessage', 'msg_oneShop');
		closeAlert('errorMessage', 'msg_noAccount');
		closeAlert('errorMessage', 'msg_download');
		closeAlert('errorMessage', 'msg_noResult');
		closeAlert('errorMessage', 'msg_noConfirm');
		closeAlert('errorMessage', 'msg_dataError');
		//$("#orderListDiv").show();
		//authority      店舗 : 1       商品部 : 2      メーカー : 3      工場 : 4      倉庫 : 5
		switch(authority){
			//店舗
			case "01":
				//「未会計のみ」を選択する
	    		if($('#isAccount').prop('checked')) {
			        var columns = [
			    	    {id: "account_kubun", name: "会計",minWidth: 50, maxWidth: 50, cssClass: "cell-del-type", field: "account_kubun", formatter: Slick.Formatters.Checkbox, editor: Slick.Editors.Checkbox, cannotTriggerInsert: true},
						{id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection cell-money",minWidth: 50, maxWidth: 50, resizable: false, selectable: false },
					    {id: 'order_id', name: '注文ID', field: 'order_id', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'product_item', name: 'ITEM', field: 'product_item', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'product_fabric_no', name: '生地品番', field: "product_fabric_no", formatter: mineFormatter, sortable: true,minWidth: 150, cssClass: "cell-other"},
					    {id: 'cust_cd', name: '会員番号', field: "cust_cd", formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'store_staff_nm', name: '営業担当者', field: "store_staff_nm", formatter: mineFormatter, sortable: true,minWidth: 150, cssClass: "cell-other"},
					    {id: 'tsc_status', name: 'ステータス', field: "tsc_status", formatter: mineFormatter, sortable: true, minWidth: 200},
					    {id: 'product_orderd_date', name: '承り日', field: 'product_orderd_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
					    {id: 'cust_shop_delivery_date', name: 'お渡し日', field: 'cust_shop_delivery_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
					    {id: 'cust_deliver_date', name: '名簿納期', field: 'cust_deliver_date', sortable: true, minWidth: 120, cssClass: "cell-other"}
				    ];
	    		}
	    		//選択しない
	    		else{
			        var columns = [
						{id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection cell-money",minWidth: 50, maxWidth: 50, resizable: false, selectable: false },
					    {id: 'order_id', name: '注文ID', field: 'order_id', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'product_item', name: 'ITEM', field: 'product_item', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'product_fabric_no', name: '生地品番', field: "product_fabric_no", formatter: mineFormatter, sortable: true,minWidth: 150, cssClass: "cell-other"},
					    {id: 'cust_cd', name: '会員番号', field: "cust_cd", formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'store_staff_nm', name: '営業担当者', field: "store_staff_nm", formatter: mineFormatter, sortable: true,minWidth: 150, cssClass: "cell-other"},
					    {id: 'tsc_status', name: 'ステータス', field: "tsc_status", formatter: mineFormatter, sortable: true, minWidth: 200},
					    {id: 'product_orderd_date', name: '承り日', field: 'product_orderd_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
					    {id: 'cust_shop_delivery_date', name: 'お渡し日', field: 'cust_shop_delivery_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
					    {id: 'cust_deliver_date', name: '名簿納期', field: 'cust_deliver_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
					    {id: 'goto_order', name: 'オーダー', field: 'goto_order', minWidth: 80, formatter: mineFormatter}
				    ];
	    		}
			break;
			//商品部
			case "02":
				//「未承認のみ」を選択する
	    		if($('#isConfirm').prop('checked')) {
			        var columns = [
			    	    {id: "confirm_kubun", name: "承認",minWidth: 50, maxWidth: 50, cssClass: "cell-del-type", field: "confirm_kubun", formatter: Slick.Formatters.Checkbox, editor: Slick.Editors.Checkbox, cannotTriggerInsert: true},
						{id: "sel", name: "No", field: "num", behavior: "select",minWidth: 40, maxWidth: 50, cssClass: "cell-selection cell-money", resizable: false, selectable: false},
					    {id: 'order_id', name: '注文ID', field: 'order_id', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'product_item', name: 'ITEM', field: 'product_item', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'product_fabric_no', name: '生地品番', field: "product_fabric_no", formatter: mineFormatter, sortable: true,minWidth: 150, cssClass: "cell-other"},
					    {id: 'ws_price', name: '下代', field: "ws_price", cssClass: "cell-money", formatter: mineFormatter, sortable: true,minWidth: 110, cssClass: "cell-money"},
					    {id: 'cust_cd', name: '店舗名', field: "cust_cd", formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'store_staff_nm', name: '営業担当者', field: "store_staff_nm", formatter: mineFormatter, sortable: true,minWidth: 150, cssClass: "cell-other"},
					    {id: 'tsc_status', name: 'ステータス', field: "tsc_status", formatter: mineFormatter, sortable: true, minWidth: 200},
					    {id: 'product_orderd_date', name: '承り日', field: 'product_orderd_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
					    {id: 'cust_shop_delivery_date', name: 'お渡し日', field: 'cust_shop_delivery_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
					    {id: 'cust_deliver_date', name: '名簿納期', field: 'cust_deliver_date', sortable: true, minWidth: 120, cssClass: "cell-other"}
				    ];
				    
	    		}
	    		//「未会計のみ」を選択する
	    		else if($('#isAccount').prop('checked')){
			        var columns = [
			    	    {id: "account_kubun", name: "会計",minWidth: 50, maxWidth: 50, cssClass: "cell-del-type", field: "account_kubun", formatter: Slick.Formatters.Checkbox, editor: Slick.Editors.Checkbox, cannotTriggerInsert: true},			        
						{id: "sel", name: "No", field: "num", behavior: "select",minWidth: 40, maxWidth: 50, cssClass: "cell-selection cell-money", resizable: false, selectable: false },
					    {id: 'order_id', name: '注文ID', field: 'order_id', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'product_item', name: 'ITEM', field: 'product_item', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'product_fabric_no', name: '生地品番', field: "product_fabric_no", formatter: mineFormatter, sortable: true,minWidth: 150, cssClass: "cell-other"},
					    {id: 'ws_price', name: '下代', field: "ws_price", cssClass: "cell-money", formatter: mineFormatter, sortable: true, minWidth: 110, cssClass: "cell-money"},
					    {id: 'cust_cd', name: '店舗名', field: "cust_cd", formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'store_staff_nm', name: '営業担当者', field: "store_staff_nm", formatter: mineFormatter, sortable: true,minWidth: 150, cssClass: "cell-other"},
					    {id: 'tsc_status', name: 'ステータス', field: "tsc_status", formatter: mineFormatter, sortable: true, minWidth: 200},
					    {id: 'product_orderd_date', name: '承り日', field: 'product_orderd_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
					    {id: 'cust_shop_delivery_date', name: 'お渡し日', field: 'cust_shop_delivery_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
					    {id: 'cust_deliver_date', name: '名簿納期', field: 'cust_deliver_date', sortable: true, minWidth: 120, cssClass: "cell-other"}
				    ];
	    		}
	    		//選択しない
	    		else{
			        var columns = [
						{id: "sel", name: "No", field: "num",minWidth: 50, maxWidth: 50, behavior: "select", cssClass: "cell-selection cell-money", resizable: false, selectable: false},
						{id: 'order_id', name: '注文ID', field: 'order_id', minWidth: 160, formatter: mineFormatter, sortable: true, cssClass: "cell-other "},
					    {id: 'product_item', name: 'ITEM', field: 'product_item', minWidth: 160, formatter: mineFormatter, sortable: true, cssClass: "cell-other"},
					    {id: 'product_fabric_no', name: '生地品番', field: "product_fabric_no", minWidth: 150, formatter: mineFormatter, sortable: true, cssClass: "cell-other"},
					    {id: 'ws_price', name: '下代', field: "ws_price", minWidth: 110, cssClass: "cell-money", formatter: mineFormatter, sortable: true, cssClass: "cell-money"},
					    {id: 'cust_cd', name: '店舗名', field: "cust_cd", minWidth: 160, formatter: mineFormatter, sortable: true, cssClass: "cell-other"},
					    {id: 'store_staff_nm', name: '営業担当者', field: "store_staff_nm", minWidth: 150, formatter: mineFormatter, sortable: true, cssClass: "cell-other"},
					    {id: 'tsc_status', name: 'ステータス', field: "tsc_status", minWidth: 200, formatter: mineFormatter, sortable: true},
					    {id: 'product_orderd_date', name: '承り日', field: 'product_orderd_date', minWidth: 120, sortable: true, cssClass: "cell-other"},
					    {id: 'cust_shop_delivery_date', name: 'お渡し日', field: 'cust_shop_delivery_date', minWidth: 120, sortable: true, cssClass: "cell-other"},
					    {id: 'cust_deliver_date', name: '名簿納期', field: 'cust_deliver_date', minWidth: 120, sortable: true, cssClass: "cell-other"}
				    ];
	        	}
			break;
			//工場
	        case "03":
	        	//「未承認のみ」を選択する
	    		if($('#isConfirm').prop('checked')) {
			        var columns = [
			    	    {id: "confirm_kubun", name: "承認",minWidth: 50, maxWidth: 50, cssClass: "cell-del-type", field: "confirm_kubun", formatter: Slick.Formatters.Checkbox, editor: Slick.Editors.Checkbox, cannotTriggerInsert: true},
						{id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection cell-money",minWidth: 50, maxWidth: 50, resizable: false, selectable: false },
					    {id: 'order_id', name: '注文ID', field: 'order_id', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'product_item', name: 'ITEM', field: 'product_item', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'product_fabric_no', name: '生地品番', field: "product_fabric_no", formatter: mineFormatter, sortable: true,minWidth: 150, cssClass: "cell-other"},
					    {id: 'ws_price', name: '下代', field: "ws_price", cssClass: "cell-money", formatter: mineFormatter, sortable: true, minWidth: 110, cssClass: "cell-money"},
					    {id: 'tsc_status', name: 'ステータス', field: "tsc_status", formatter: mineFormatter, sortable: true, minWidth: 150},
					    {id: 'product_orderd_date', name: '承り日', field: 'product_orderd_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
					    {id: 'cust_shop_delivery_date', name: 'お渡し日', field: 'cust_shop_delivery_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
					    {id: 'cust_deliver_date', name: '名簿納期', field: 'cust_deliver_date', sortable: true, minWidth: 120, cssClass: "cell-other"}
				    ];
	    		}
	    		//選択しない
	    		else{
			        var columns = [
						{id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection cell-money",minWidth: 50, maxWidth: 50, resizable: false, selectable: false},
					    {id: 'order_id', name: '注文ID', field: 'order_id', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'product_item', name: 'ITEM', field: 'product_item', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
					    {id: 'product_fabric_no', name: '生地品番', field: "product_fabric_no", formatter: mineFormatter, sortable: true,minWidth: 150, cssClass: "cell-other"},
					    {id: 'ws_price', name: '下代', field: "ws_price", cssClass: "cell-money", formatter: mineFormatter, sortable: true, minWidth: 110, cssClass: "cell-money"},
					    {id: 'tsc_status', name: 'ステータス', field: "tsc_status", formatter: mineFormatter, sortable: true, minWidth: 150},
					    {id: 'product_orderd_date', name: '承り日', field: 'product_orderd_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
					    {id: 'cust_shop_delivery_date', name: 'お渡し日', field: 'cust_shop_delivery_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
					    {id: 'cust_deliver_date', name: '名簿納期', field: 'cust_deliver_date', sortable: true, minWidth: 120, cssClass: "cell-other"}
				    ];

	            }
	    		
			break;
			//工場 、倉庫
	        default:
		        var columns = [
					{id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection cell-money",minWidth: 50, maxWidth: 50, resizable: false, selectable: false},
				    {id: 'order_id', name: '注文ID', field: 'order_id', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
				    {id: 'product_item', name: 'ITEM', field: 'product_item', formatter: mineFormatter, sortable: true,minWidth: 160, cssClass: "cell-other"},
				    {id: 'product_fabric_no', name: '生地品番', field: "product_fabric_no", formatter: mineFormatter, sortable: true,minWidth: 150, cssClass: "cell-other"},
				    {id: 'tsc_status', name: 'ステータス', field: "tsc_status", formatter: mineFormatter, sortable: true, minWidth: 150},
				    {id: 'product_orderd_date', name: '承り日', field: 'product_orderd_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
				    {id: 'cust_shop_delivery_date', name: 'お渡し日', field: 'cust_shop_delivery_date', sortable: true, minWidth: 120, cssClass: "cell-other"},
				    {id: 'updated_at', name: '更新日時', field: 'updated_at', sortable: true, minWidth: 180, cssClass: "cell-other"}
			    ];
			break;
		}

	  // (2) SlickGridの動作オプション
		var options = {
		  columnPicker: {
		    columnTitle: "Columns",
		    hideForceFitButton: false,
		    hideSyncResizeButton: false, 
		    forceFitTitle: "Force fit columns",
		    syncResizeTitle: "Synchronous resize", 
		  },
		  editable: true,
		  enableAddRow: false,
		  enableCellNavigation: true,
		  asyncEditorLoading: true,
		  forceFitColumns: true,
		  topPanelHeight: 25,
		  rowHeight: 45,
		  frozenColumn: 1
		};

	  var contextPath = $("meta[name='contextPath']").attr("content");
	  var data = [];
	  $.ajax({url : contextPath + "/orderlist/FindAllOrderByCondition",
		      type: "get",
		      dataType: "json",
		      data: $('#conditionForm').serialize(),
			      }).
		      then(function(result) {
		    	 $.unblockUI(); 
			    if($('#orderListDiv').is(":hidden")){

				}else{
				    grid.gotoCell(0, 0,true);
				}
				if (result.length == 0){
					searchNum = 0;
					addAlert('errorMessage', 'msg_noResult', getMsg('msg031'));
					$("#orderListDiv").hide();
				} else{
					searchNum = result.length;
					closeAlert('errorMessage', 'msg_oneShop');
					closeAlert('errorMessage', 'msg_noAccount');
					closeAlert('errorMessage', 'msg_download');
					closeAlert('errorMessage', 'msg_noResult');
					closeAlert('errorMessage', 'msg_noConfirm');
					closeAlert('errorMessage', 'msg_dataError');
					$("#orderListDiv").show();
				}
				//authority      店舗 : 1       商品部 : 2      メーカー : 3      工場 : 4      倉庫 : 5
				switch(authority){
				  //店舗
			      case "01": 
					  //「未会計のみ」を選択する				      
					  if($('#isAccount').prop('checked')) {
						   for (var i = 0; i < result.length; i++) {
							    var d = (data[i] = {});
								d["account_kubun"] = false;
							    d["id"] = "id_" + i;
								d["num"] = i + 1;
							    d["order_id"] = "<a href='javascript:void(0);' onclick='gotoOrderLink(\"" + result[i].orderId + "\")' ><font size='3'>" + result[i].orderId + "</font></a>";
							    if (result[i].productItem == "01"){
									d["product_item"] = itemMap.get(result[i].productItemDisplaycode);
								}else{
									d["product_item"] = itemMap.get(result[i].productItem);
								}
							    var productFabricNo = result[i].productFabricNo == "" || result[i].productFabricNo == null ? "" : result[i].productFabricNo + "-";
							    var fabricColor = result[i].fabricColor == null ? "" : result[i].fabricColor;
							    var fabricPattern = result[i].fabricPattern == null ? "" : result[i].fabricPattern;
							    d["product_fabric_no"] = productFabricNo + "" + fabricColor + "" + fabricPattern;
							    d["cust_cd"] = result[i].custCd;
							    d["store_staff_nm"] = result[i].custStaff;
							    var tscStatus = tscStatusMap.get(result[i].tscStatus) == null ? "" : tscStatusMap.get(result[i].tscStatus);
							    var makerFactoryStatus = makerFactoryStatusMap.get(result[i].makerFactoryStatus) == null ? "" : makerFactoryStatusMap.get(result[i].makerFactoryStatus);
							    var send2factoryStatus = send2factoryStatusMap.get(result[i].send2factoryStatus) == null ? "" : send2factoryStatusMap.get(result[i].send2factoryStatus);
							    if(result[i].makerFactoryStatus == "F0"){
							    	d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus + "("+ send2factoryStatus +")";
								 }else{
									d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus;
								}
							    d["product_orderd_date"] = result[i].productOrderdDate == null || tscStatus == "取り置き" || tscStatus == "" || tscStatus == "一時保存" ? "" : ChangeTimeFormatYMD(result[i].productOrderdDate);
							    d["cust_shop_delivery_date"] = result[i].custShopDeliveryDate == null ? "" : ChangeTimeFormatYMD(result[i].custShopDeliveryDate);
							    d["cust_deliver_date"] = result[i].custDeliverDate == null ? "" : ChangeTimeFormatYMD(result[i].custDeliverDate);
								d["send2factory_status"] = result[i].send2factoryStatus;
								d["is_cancelled"] = result[i].isCancelled;    
								d["shop_code"] = result[i].shopCode;    
						   }
						   //結果があるの場合、
						   if (result.length != 0){
							   //「会計を纏める」ボタンを表示する
							   document.getElementById("AccountOrConfirm").style.visibility="visible";
						       $("#AccountDiv").show();
						   }
						  
					  }
					  //「未会計のみ」を選択しない
					  else{
						  for (var i = 0; i < result.length; i++) {
							  var d = (data[i] = {});
							    d["id"] = "id_" + i;
								d["num"] = i + 1;
							    d["order_id"] = "<a href='javascript:void(0);' onclick='gotoOrderLink(\"" + result[i].orderId + "\")' ><font size='3'>" + result[i].orderId + "</font></a>";
							    if (result[i].productItem == "01"){
									d["product_item"] = itemMap.get(result[i].productItemDisplaycode);
								}else{
									d["product_item"] = itemMap.get(result[i].productItem);
								}
							    var productFabricNo = result[i].productFabricNo == "" || result[i].productFabricNo == null ? "" : result[i].productFabricNo + "-";
							    var fabricColor = result[i].fabricColor == null ? "" : result[i].fabricColor;
							    var fabricPattern = result[i].fabricPattern == null ? "" : result[i].fabricPattern;
							    d["product_fabric_no"] = productFabricNo + "" + fabricColor + "" + fabricPattern;
							    d["cust_cd"] = result[i].custCd;
							    d["store_staff_nm"] = result[i].custStaff;
							    var tscStatus = tscStatusMap.get(result[i].tscStatus) == null ? "" : tscStatusMap.get(result[i].tscStatus);
							    var makerFactoryStatus = makerFactoryStatusMap.get(result[i].makerFactoryStatus) == null ? "" : makerFactoryStatusMap.get(result[i].makerFactoryStatus);
							    var send2factoryStatus = send2factoryStatusMap.get(result[i].send2factoryStatus) == null ? "" : send2factoryStatusMap.get(result[i].send2factoryStatus);
							    if(result[i].makerFactoryStatus == "F0"){
							    	d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus + "("+ send2factoryStatus +")";
								 }else{
									d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus;
								}
							    d["product_orderd_date"] = result[i].productOrderdDate == null || tscStatus == "取り置き" || tscStatus == "" || tscStatus == "一時保存" ? "" : ChangeTimeFormatYMD(result[i].productOrderdDate);
							    d["cust_shop_delivery_date"] = result[i].custShopDeliveryDate == null ? "" : ChangeTimeFormatYMD(result[i].custShopDeliveryDate);
							    d["cust_deliver_date"] = result[i].custDeliverDate == null ? "" : ChangeTimeFormatYMD(result[i].custDeliverDate);
								d["goto_order"] = tscStatus == "取り置き" || tscStatus == "" || tscStatus == "一時保存" ? "" :  "<button id='goto_order' class='btn_off btn_brown' onclick='gotoOrderDivert(\"" + result[i].orderId + "\")' ><font size='3'>流用</font> </button>";	    
								d["send2factory_status"] = result[i].send2factoryStatus;
								d["is_cancelled"] = result[i].isCancelled;   
								d["shop_code"] = result[i].shopCode;    
					      }
						   //「会計を纏める」ボタンを表示しない
						  document.getElementById("AccountOrConfirm").style.visibility="hidden";
						  $("#AccountDiv").hide();
					  }
                  break;
                  //商品部
		          case "02":
		        	  //「未承認のみ」を選択する
		    		  if($('#isConfirm').prop('checked')) {
						   for (var i = 0; i < result.length; i++) {
							    var d = (data[i] = {});
								d["confirm_kubun"] = false;
							    d["id"] = "id_" + i;
								d["num"] = i + 1;
							    d["order_id"] = "<a href='javascript:void(0);' onclick='gotoOrderLink(\"" + result[i].orderId + "\")' ><font size='3'>" + result[i].orderId + "</font></a>";
							    if (result[i].productItem == "01"){
									d["product_item"] = itemMap.get(result[i].productItemDisplaycode);
								}else{
									d["product_item"] = itemMap.get(result[i].productItem);
								}
							    var productFabricNo = result[i].productFabricNo == "" || result[i].productFabricNo == null ? "" : result[i].productFabricNo + "-";
							    var fabricColor = result[i].fabricColor == null ? "" : result[i].fabricColor;
							    var fabricPattern = result[i].fabricPattern == null ? "" : result[i].fabricPattern;
							    d["product_fabric_no"] = productFabricNo + "" + fabricColor + "" + fabricPattern;
							    if (result[i].wsPrice == null){
							    	d["ws_price"] = "￥0";
								}else{
									d["ws_price"] = formatMoney(result[i].wsPrice, 0, "￥");
								}
							    d["cust_cd"] = result[i].storeNm;
							    d["store_staff_nm"] = result[i].custStaff;
							    var tscStatus = tscStatusMap.get(result[i].tscStatus) == null ? "" : tscStatusMap.get(result[i].tscStatus);
							    var makerFactoryStatus = makerFactoryStatusMap.get(result[i].makerFactoryStatus) == null ? "" : makerFactoryStatusMap.get(result[i].makerFactoryStatus);
							    var send2factoryStatus = send2factoryStatusMap.get(result[i].send2factoryStatus) == null ? "" : send2factoryStatusMap.get(result[i].send2factoryStatus);
							    if(result[i].makerFactoryStatus == "F0"){
							    	d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus + "("+ send2factoryStatus +")";
								 }else{
									d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus;
								}
							    d["product_orderd_date"] = result[i].productOrderdDate == null || tscStatus == "取り置き" || tscStatus == "" || tscStatus == "一時保存" ? "" : ChangeTimeFormatYMD(result[i].productOrderdDate);
							    d["cust_shop_delivery_date"] = result[i].custShopDeliveryDate == null ? "" : ChangeTimeFormatYMD(result[i].custShopDeliveryDate);
							    d["cust_deliver_date"] = result[i].custDeliverDate == null ? "" : ChangeTimeFormatYMD(result[i].custDeliverDate);
								d["send2factory_status"] = result[i].send2factoryStatus;
								d["is_cancelled"] = result[i].isCancelled;   
								d["shop_code"] = result[i].shopCode;    
						   }
					       //結果があるの場合、
						   if (result.length != 0){
							   //「一括承認」ボタンを表示し、「会計を纏める」ボタンを表示しない
							   document.getElementById("AccountOrConfirm").style.visibility="visible";
						       $("#ConfirmDiv").show();
						       $("#AccountDiv").hide();
						   }
			    	 }
		    		 //「未会計のみ」を選択する
				     else if($('#isAccount').prop('checked')){
						   for (var i = 0; i < result.length; i++) {
							    var d = (data[i] = {});
								d["account_kubun"] = false;
							    d["id"] = "id_" + i;
								d["num"] = i + 1;
							    d["order_id"] = "<a href='javascript:void(0);' onclick='gotoOrderLink(\"" + result[i].orderId + "\")' ><font size='3'>" + result[i].orderId + "</font></a>";
							    if (result[i].productItem == "01"){
									d["product_item"] = itemMap.get(result[i].productItemDisplaycode);
								}else{
									d["product_item"] = itemMap.get(result[i].productItem);
								}
							    var productFabricNo = result[i].productFabricNo == "" || result[i].productFabricNo == null ? "" : result[i].productFabricNo + "-";
							    var fabricColor = result[i].fabricColor == null ? "" : result[i].fabricColor;
							    var fabricPattern = result[i].fabricPattern == null ? "" : result[i].fabricPattern;
							    d["product_fabric_no"] = productFabricNo + "" + fabricColor + "" + fabricPattern;
							    if (result[i].wsPrice == null){
							    	d["ws_price"] = "￥0";
								}else{
									d["ws_price"] = formatMoney(result[i].wsPrice, 0, "￥");
								}
							    d["cust_cd"] = result[i].storeNm;
							    d["store_staff_nm"] = result[i].custStaff;
							    var tscStatus = tscStatusMap.get(result[i].tscStatus) == null ? "" : tscStatusMap.get(result[i].tscStatus);
							    var makerFactoryStatus = makerFactoryStatusMap.get(result[i].makerFactoryStatus) == null ? "" : makerFactoryStatusMap.get(result[i].makerFactoryStatus);
							    var send2factoryStatus = send2factoryStatusMap.get(result[i].send2factoryStatus) == null ? "" : send2factoryStatusMap.get(result[i].send2factoryStatus);
							    if(result[i].makerFactoryStatus == "F0"){
							    	d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus + "("+ send2factoryStatus +")";
								 }else{
									d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus;
								}
							    d["product_orderd_date"] = result[i].productOrderdDate == null || tscStatus == "取り置き" || tscStatus == "" || tscStatus == "一時保存" ? "" : ChangeTimeFormatYMD(result[i].productOrderdDate);
							    d["cust_shop_delivery_date"] = result[i].custShopDeliveryDate == null ? "" : ChangeTimeFormatYMD(result[i].custShopDeliveryDate);
							    d["cust_deliver_date"] = result[i].custDeliverDate == null ? "" : ChangeTimeFormatYMD(result[i].custDeliverDate);
								d["send2factory_status"] = result[i].send2factoryStatus;
								d["is_cancelled"] = result[i].isCancelled;   
								d["shop_code"] = result[i].shopCode;    
						   }
						   //結果があるの場合、
						   if (result.length != 0){
							   //「会計を纏める」ボタンを表示し、「一括承認」ボタンを表示しない
							   document.getElementById("AccountOrConfirm").style.visibility="visible";
						       $("#AccountDiv").show();
						       $("#ConfirmDiv").hide();
						   }
			    	  }
					  //選択しない
			    	  else{						  
				    	  for (var i = 0; i < result.length; i++) {
							  var d = (data[i] = {});
							    d["id"] = "id_" + i;
								d["num"] = i + 1;
							    d["order_id"] = "<a href='javascript:void(0);' onclick='gotoOrderLink(\"" + result[i].orderId + "\")' ><font size='3'>" + result[i].orderId + "</font></a>";
							    if (result[i].productItem == "01"){
									d["product_item"] = itemMap.get(result[i].productItemDisplaycode);
								}else{
									d["product_item"] = itemMap.get(result[i].productItem);
								}
							    var productFabricNo = result[i].productFabricNo == "" || result[i].productFabricNo == null ? "" : result[i].productFabricNo + "-";
							    var fabricColor = result[i].fabricColor == null ? "" : result[i].fabricColor;
							    var fabricPattern = result[i].fabricPattern == null ? "" : result[i].fabricPattern;
							    d["product_fabric_no"] = productFabricNo + "" + fabricColor + "" + fabricPattern;
							    if (result[i].wsPrice == null){
							    	d["ws_price"] = "￥0";
								}else{
									d["ws_price"] = formatMoney(result[i].wsPrice, 0, "￥");
								}
							    d["cust_cd"] = result[i].storeNm;
							    d["store_staff_nm"] = result[i].custStaff;
							    var tscStatus = tscStatusMap.get(result[i].tscStatus) == null ? "" : tscStatusMap.get(result[i].tscStatus);
							    var makerFactoryStatus = makerFactoryStatusMap.get(result[i].makerFactoryStatus) == null ? "" : makerFactoryStatusMap.get(result[i].makerFactoryStatus);
							    var send2factoryStatus = send2factoryStatusMap.get(result[i].send2factoryStatus) == null ? "" : send2factoryStatusMap.get(result[i].send2factoryStatus);
							    if(result[i].makerFactoryStatus == "F0"){
							    	d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus + "("+ send2factoryStatus +")";
								 }else{
									d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus;
								}
							    d["product_orderd_date"] = result[i].productOrderdDate == null || tscStatus == "取り置き" || tscStatus == "" || tscStatus == "一時保存" ? "" : ChangeTimeFormatYMD(result[i].productOrderdDate);
							    d["cust_shop_delivery_date"] = result[i].custShopDeliveryDate == null ? "" : ChangeTimeFormatYMD(result[i].custShopDeliveryDate);
							    d["cust_deliver_date"] = result[i].custDeliverDate == null ? "" : ChangeTimeFormatYMD(result[i].custDeliverDate);
								d["send2factory_status"] = result[i].send2factoryStatus;	    
								d["is_cancelled"] = result[i].isCancelled;   
								d["shop_code"] = result[i].shopCode;    
				          }
				    	    //「会計を纏める」ボタン、「一括承認」ボタンを表示しない
						    document.getElementById("AccountOrConfirm").style.visibility="hidden";
					        $("#AccountDiv").hide();
					        $("#ConfirmDiv").hide();
				      }
                  break;
                  //工場
			      case "03": 
			    	  //「未承認のみ」を選択する
					  if($('#isConfirm').prop('checked')) {
						   for (var i = 0; i < result.length; i++) {
							    var d = (data[i] = {});
								d["confirm_kubun"] = false;
							    d["id"] = "id_" + i;
								d["num"] = i + 1;
							    d["order_id"] = "<a href='javascript:void(0);' onclick='gotoOrderLink(\"" + result[i].orderId + "\")' ><font size='3'>" + result[i].orderId + "</font></a>";
							    if (result[i].productItem == "01"){
									d["product_item"] = itemMap.get(result[i].productItemDisplaycode);
								}else{
									d["product_item"] = itemMap.get(result[i].productItem);
								}
							    var productFabricNo = result[i].productFabricNo == "" || result[i].productFabricNo == null ? "" : result[i].productFabricNo + "-";
							    var fabricColor = result[i].fabricColor == null ? "" : result[i].fabricColor;
							    var fabricPattern = result[i].fabricPattern == null ? "" : result[i].fabricPattern;
							    d["product_fabric_no"] = productFabricNo + "" + fabricColor + "" + fabricPattern;
							    if (result[i].wsPrice == null){
							    	d["ws_price"] = "￥0";
								}else{
									d["ws_price"] = formatMoney(result[i].wsPrice, 0, "￥");
								}
							    d["cust_cd"] = result[i].custCd;
							    d["store_staff_nm"] = result[i].custStaff;
							    var tscStatus = tscStatusMap.get(result[i].tscStatus) == null ? "" : tscStatusMap.get(result[i].tscStatus);
							    var makerFactoryStatus = makerFactoryStatusMap.get(result[i].makerFactoryStatus) == null ? "" : makerFactoryStatusMap.get(result[i].makerFactoryStatus);
							    var send2factoryStatus = send2factoryStatusMap.get(result[i].send2factoryStatus) == null ? "" : send2factoryStatusMap.get(result[i].send2factoryStatus);
							    if(result[i].makerFactoryStatus == "F0"){
							    	d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus + "("+ send2factoryStatus +")";
								 }else{
									d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus;
								}
							    d["product_orderd_date"] = result[i].productOrderdDate == null || tscStatus == "取り置き" || tscStatus == "" || tscStatus == "一時保存" ? "" : ChangeTimeFormatYMD(result[i].productOrderdDate);
							    d["cust_shop_delivery_date"] = result[i].custShopDeliveryDate == null ? "" : ChangeTimeFormatYMD(result[i].custShopDeliveryDate);
							    d["cust_deliver_date"] = result[i].custDeliverDate == null ? "" : ChangeTimeFormatYMD(result[i].custDeliverDate);
								d["send2factory_status"] = result[i].send2factoryStatus;
								d["is_cancelled"] = result[i].isCancelled;   
								d["shop_code"] = result[i].shopCode;    
						   }
						   //結果があるの場合、
						   if (result.length != 0){
							　　 //「一括承認」ボタンを表示します
							   document.getElementById("AccountOrConfirm").style.visibility="visible";
						       $("#ConfirmDiv").show();
						   }
						  
					  }
					  //選択しない
					  else{
						  for (var i = 0; i < result.length; i++) {
							  var d = (data[i] = {});
							    d["id"] = "id_" + i;
								d["num"] = i + 1;
							    d["order_id"] = "<a href='javascript:void(0);' onclick='gotoOrderLink(\"" + result[i].orderId + "\")' ><font size='3'>" + result[i].orderId + "</font></a>";
							    if (result[i].productItem == "01"){
									d["product_item"] = itemMap.get(result[i].productItemDisplaycode);
								}else{
									d["product_item"] = itemMap.get(result[i].productItem);
								}
							    var productFabricNo = result[i].productFabricNo == "" || result[i].productFabricNo == null ? "" : result[i].productFabricNo + "-";
							    var fabricColor = result[i].fabricColor == null ? "" : result[i].fabricColor;
							    var fabricPattern = result[i].fabricPattern == null ? "" : result[i].fabricPattern;
							    d["product_fabric_no"] = productFabricNo + "" + fabricColor + "" + fabricPattern;
							    if (result[i].wsPrice == null){
							    	d["ws_price"] = "￥0";
								}else{
									d["ws_price"] = formatMoney(result[i].wsPrice, 0, "￥");
								}
							    d["cust_cd"] = result[i].custCd;
							    d["store_staff_nm"] = result[i].custStaff;
							    var tscStatus = tscStatusMap.get(result[i].tscStatus) == null ? "" : tscStatusMap.get(result[i].tscStatus);
							    var makerFactoryStatus = makerFactoryStatusMap.get(result[i].makerFactoryStatus) == null ? "" : makerFactoryStatusMap.get(result[i].makerFactoryStatus);
							    var send2factoryStatus = send2factoryStatusMap.get(result[i].send2factoryStatus) == null ? "" : send2factoryStatusMap.get(result[i].send2factoryStatus);
							    if(result[i].makerFactoryStatus == "F0"){
							    	d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus + "("+ send2factoryStatus +")";
								 }else{
									d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus;
								}
							    d["product_orderd_date"] = result[i].productOrderdDate == null || tscStatus == "取り置き" || tscStatus == "" || tscStatus == "一時保存" ? "" : ChangeTimeFormatYMD(result[i].productOrderdDate);
							    d["cust_shop_delivery_date"] = result[i].custShopDeliveryDate == null ? "" : ChangeTimeFormatYMD(result[i].custShopDeliveryDate);
							    d["cust_deliver_date"] = result[i].custDeliverDate == null ? "" : ChangeTimeFormatYMD(result[i].custDeliverDate);
								d["send2factory_status"] = result[i].send2factoryStatus;
								d["is_cancelled"] = result[i].isCancelled;   
								d["shop_code"] = result[i].shopCode;    
					      }
						　　//「一括承認」ボタンを表示しない
						  document.getElementById("AccountOrConfirm").style.visibility="hidden";
						  $("#ConfirmDiv").hide();
					  }
                  break;
                  //工場 、倉庫
			      default: 
						for (var i = 0; i < result.length; i++) {
						    var d = (data[i] = {});
						    d["id"] = "id_" + i;
							d["num"] = i + 1;
						    d["order_id"] = "<a href='javascript:void(0);' onclick='gotoOrderLink(\"" + result[i].orderId + "\")' ><font size='3'>" + result[i].orderId + "</font></a>";
						    if (result[i].productItem == "01"){
								d["product_item"] = itemMap.get(result[i].productItemDisplaycode);
							}else{
								d["product_item"] = itemMap.get(result[i].productItem);
							}
						    var productFabricNo = result[i].productFabricNo == "" || result[i].productFabricNo == null ? "" : result[i].productFabricNo + "-";
						    var fabricColor = result[i].fabricColor == null ? "" : result[i].fabricColor;
						    var fabricPattern = result[i].fabricPattern == null ? "" : result[i].fabricPattern;
						    d["product_fabric_no"] = productFabricNo + "" + fabricColor + "" + fabricPattern;
						    d["cust_cd"] = result[i].custCd;
						    d["store_staff_nm"] = result[i].custStaff;
						    var tscStatus = tscStatusMap.get(result[i].tscStatus) == null ? "" : tscStatusMap.get(result[i].tscStatus);
						    var makerFactoryStatus = makerFactoryStatusMap.get(result[i].makerFactoryStatus) == null ? "" : makerFactoryStatusMap.get(result[i].makerFactoryStatus);
						    var send2factoryStatus = send2factoryStatusMap.get(result[i].send2factoryStatus) == null ? "" : send2factoryStatusMap.get(result[i].send2factoryStatus);
						    if(result[i].makerFactoryStatus == "F0"){
						    	d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus + "("+ send2factoryStatus +")";
							 }else{
								d["tsc_status"] = tscStatus + "</br>" + makerFactoryStatus;
							}
						    d["product_orderd_date"] = result[i].productOrderdDate == null || tscStatus == "取り置き" || tscStatus == "" || tscStatus == "一時保存" ? "" : ChangeTimeFormatYMD(result[i].productOrderdDate);
						    d["cust_shop_delivery_date"] = result[i].custShopDeliveryDate == null ? "" : ChangeTimeFormatYMD(result[i].custShopDeliveryDate);
						    d["updated_at"] = result[i].updatedAt == null ? "" : ChangeTimeFormatYMDHM(result[i].updatedAt);
							d["send2factory_status"] = result[i].send2factoryStatus;
							d["is_cancelled"] = result[i].isCancelled;   
							d["shop_code"] = result[i].shopCode;    
					   }			      
				   break;
		      }
    		  
		    // (4) SlickGridテーブルを作成
		    dataView = new Slick.Data.DataView();
		    grid = new Slick.Grid("#myGrid", dataView, columns, options);
		    grid.setSelectionModel(new Slick.RowSelectionModel());
		    grid.init();
		    
		    var pager = new Slick.Controls.Pager(dataView, grid, $("#pager"));

			grid.onCellChange.subscribe(function (e, args) {
			  if(args.length === undefined){
				  
			  }else{
				 dataView.updateItem(args.item.id, args.item);
			  }
			});
			
		    grid.onSort.subscribe(function (e, args) {
		        sortdir = args.sortAsc ? 1 : -1;
		        sortcol = args.sortCol.field;  
		        dataView.sort(comparer, args.sortAsc);
		      });
　　　　　　　　　　//backgroundを変更する
		     grid.onBeforeAppendCell.subscribe(function (e, args) {
		    	  //「未会計のみ」あるいは 「未承認のみ」を選択する時
			      if($('#isAccount').prop('checked') || $('#isConfirm').prop('checked')) {
				      //取消の場合、灰色
			          if (args.dataContext.is_cancelled == 1 && args.cell != 0 && args.cell != 1) {
			              return "gray";
			          }
			          //工場自動連携の場合、赤い色
			          else if(args.dataContext.send2factory_status == 4 && args.cell != 0 && args.cell != 1){
			        	  return "red";
				      }
			          else if(args.dataContext.send2factory_status == 5 && args.cell != 0 && args.cell != 1){
			        	  return "yellow";
				      }
			          else{
			        	  return null;
				      }
			      }else{
			    	　　//取消の場合、灰色
			    	  if (args.dataContext.is_cancelled == 1 && args.cell != 0) {
			              return "gray";
			          }
			    	　　//工場自動連携の場合、赤い色
			          else if(args.dataContext.send2factory_status == 4 && args.cell != 0){
			        	  return "red";
				      }
				      else if(args.dataContext.send2factory_status == 5 && args.cell != 0){
			        	  return "yellow";
				      }
				      else{
			        	  return null;
				      }
				  }
	         });
		   　　　//「未会計のみ」あるいは 「未承認のみ」を選択する時
			if($('#isAccount').prop('checked') || $('#isConfirm').prop('checked')) {
				//固定column : 2
				grid.setOptions({ 'frozenColumn': 2 });
			}else{
				//固定column : 1
				grid.setOptions({ 'frozenColumn': 1 });
			}

		    dataView.onRowCountChanged.subscribe(function (e, args) {
		        grid.updateRowCount();
		        grid.render();
		      });

		    dataView.onRowsChanged.subscribe(function (e, args) {
		        grid.invalidateRows(args.rows);
		        grid.render();
		      });

		    // initialize the model after all the events have been hooked up
		    dataView.beginUpdate();
		    dataView.setItems(data);
			dataView.endUpdate();
			attachAutoResizeDataGrid(grid, "myGrid", "gridContainer");
			//attachAutoResizeDataPager(pager,dataView, "pager", "pagerContainer");
		      });

      //alert($("#myGrid").width());
}

//時間格式を変更
function ChangeTimeFormatYMD(nS)
{
	var timestamp4 = new Date(nS);
	//var aa = timestamp4.toLocaleDateString().replace(/\//g, "-") + " " + timestamp4.toTimeString().substr(0, 8)
  var aa = timestamp4.toLocaleDateString().replace(/\//g, "/")
  return aa;

}

//時間格式を変更
function ChangeTimeFormatYMDHM(nS)
{     
	var timestamp4 = new Date(nS);
	var aa = timestamp4.toLocaleDateString().replace(/\//g, "-") + " " + timestamp4.toTimeString().substr(0, 5);
  //var aa = timestamp4.toLocaleDateString().replace(/\//g, "-")
  return aa;

}

//通用  Link
function gotoOrderLink(orderId){
	if (orderPattern == "CO"){
		window.location.href= contextPath + "/orderlist/gotoOrderCoLink/" + orderId;
	}
	if (orderPattern == "PO"){
		window.location.href= contextPath + "/orderlist/gotoOrderPoLink/" + orderId;
	}
}
//流用 Divert
function gotoOrderDivert(orderId){
	if(orderPattern == "PO"){
	   window.location.href= contextPath + "/orderlist/goToOrderDivert/"+orderId;
	}
	if(orderPattern == "CO"){
	   window.location.href= contextPath + "/orderlist/goToOrderCoDivert/"+orderId;
	}
	
}

/* //チェック
function check(txt, column_name, column_kubun) {
	var a = getMsgByTwoArgs('msg012', column_name, '数字');
	var txtValue = txt.value;
	switch(column_kubun){
	    //1 : 注文ID
		case "1":
			//半角数字チェック
			if (isNumeric(txtValue) && txt.value != ""){
			    addAlert('errorMessage', 'msg_orderId', getMsgByTwoArgs('msg012', column_name, '数字'));
			} else{			    
				closeAlert('errorMessage', 'msg_orderId');
		    }
		  break;
		//2 : 会員番号
		case "2":
			//半角数字チェック
			if (isNumeric(txtValue) && txt.value != ""){
			    addAlert('errorMessage', 'msg_custCd', getMsgByTwoArgs('msg012', column_name, '数字'));
			} else{
				closeAlert('errorMessage', 'msg_custCd');
		    }
		  break;
	    //3 : 営業担当者
		case "3":
			//全角文字チェック
			if (isFullCharacters(txtValue) && txt.value != ""){
				addAlert('errorMessage', 'msg_staffName', getMsgByTwoArgs('msg012', column_name, '漢字'));
			} else{
				closeAlert('errorMessage', 'msg_staffName');
		    }
		  break;
		//4 : 生地品番
		case "4":
			//半角数字チェック
			if (isNumeric(txtValue) && txt.value != ""){
				addAlert('errorMessage', 'msg_fabricNo', getMsgByTwoArgs('msg012', column_name, '数字'));
			} else{
				closeAlert('errorMessage', 'msg_fabricNo');
		    }
		break;
    }
    //エラーがあるの場合、検索できません
    if ($("#errorMessage").html().length == 0){
   	    $("#searchButton").attr('disabled',false);  
    }else {
        $("#searchButton").attr('disabled',true);
    }
} */

//csvをダウンロード
function csvDownload(){

	closeAlert('errorMessage', 'msg_oneShop');
	closeAlert('errorMessage', 'msg_noAccount');
	closeAlert('errorMessage', 'msg_download');
	closeAlert('errorMessage', 'msg_noResult');
	closeAlert('errorMessage', 'msg_noConfirm');
	closeAlert('errorMessage', 'msg_dataError');
	// 確認メッセージ
	if (searchNum != 0){

		swal({
			  text: getMsg('msg032'),
			  icon: "info",
			  buttons: ["キャンセル", true],
			})
			.then((isConfirm) => {
			  if (isConfirm) {
				  window.location.href= contextPath + "/orderlist/orderDataCSVOut";
			  }
			});
	}else{

		addAlert('errorMessage', 'msg_download', getMsg('msg091'));
	}
}
//会計チェック
function gotoAccountCheck(){

	closeAlert('errorMessage', 'msg_oneShop');
	closeAlert('errorMessage', 'msg_noAccount');
	closeAlert('errorMessage', 'msg_download');
	closeAlert('errorMessage', 'msg_noResult');
	closeAlert('errorMessage', 'msg_noConfirm');
	closeAlert('errorMessage', 'msg_dataError');
	grid.gotoCell(0, 1,true);
	var oneShopFlag = true;
	var orderListString = JSON.stringify(dataView.getItems());
	var orderLength = eval('('+ orderListString +')');
	var orderIdArray = new Array();
	var shopCodeArray = new Array();
	for (var i = 0; i < orderLength.length; i++) {
		if(orderLength[i].account_kubun){
			var length = orderLength[i].order_id.length;
			orderIdArray.push(orderLength[i].order_id.substring(length-23, length-11));
			shopCodeArray.push(orderLength[i].shop_code);
		}
	}
	if (shopCodeArray.length != 0){
		for (var i = 1; i < shopCodeArray.length; i++){
			 if (shopCodeArray[i-1] != shopCodeArray[i]){
				 oneShopFlag = false;
			 }
		}
		if (oneShopFlag){
			gotoAccount();
		}else{
			addAlert('errorMessage', 'msg_oneShop', getMsg('msg090'));
		}

	}else{
		addAlert('errorMessage', 'msg_noAccount', getMsg('msg089'));
	}

}

//会計
function gotoAccount(){

	// 確認メッセージ
	swal({
		  text: getMsg('msg088'),
		  icon: "info",
		  buttons: ["キャンセル", true],
		})
		.then((isConfirm) => {
		  if (isConfirm) {
			
			grid.gotoCell(cell.row, cell.cell,true);
			var orderListString = JSON.stringify(dataView.getItems());
			var orderLength = eval('('+ orderListString +')');
			var orderIdArray = new Array();
			for (var i = 0; i < orderLength.length; i++) {
				if(orderLength[i].account_kubun){
					var length = orderLength[i].order_id.length;
					orderIdArray.push(orderLength[i].order_id.substring(length-23, length-11));
					}
				}
			localStorage.setItem("key", "orderButton");
			var orderIdString = orderIdArray.join(',');
			window.location.href= contextPath + "/cash/gotoCash/"+orderIdString;
			
		  }
		});

}
//承認チェック
function gotoConfirmCheck(){

	closeAlert('errorMessage', 'msg_oneShop');
	closeAlert('errorMessage', 'msg_noAccount');
	closeAlert('errorMessage', 'msg_download');
	closeAlert('errorMessage', 'msg_noResult');
	closeAlert('errorMessage', 'msg_noConfirm');
	closeAlert('errorMessage', 'msg_dataError');
	grid.gotoCell(0, 1, true);
	var orderListString = JSON.stringify(dataView.getItems());
	var orderLength = eval('('+ orderListString +')');
	var orderIdArray = new Array();
	for (var i = 0; i < orderLength.length; i++) {
		if(orderLength[i].confirm_kubun){
			var length = orderLength[i].order_id.length;
			orderIdArray.push(orderLength[i].order_id.substring(length-23, length-11));
		}
	}
	if (orderIdArray.length != 0){
		
		gotoConfirm();
			
	}else{
		addAlert('errorMessage', 'msg_noConfirm', getMsg('msg092'));
	}

}

//承認
function gotoConfirm(){

	// 確認メッセージ
	swal({
		  text: getMsg('msg087'),
		  icon: "info",
		  buttons: ["キャンセル", true],
		})
		.then((isConfirm) => {
		  if (isConfirm) {
			
			grid.gotoCell(cell.row, cell.cell,true);
			var orderListString = JSON.stringify(dataView.getItems());
			var orderLength = eval('('+ orderListString +')');
			var orderIdArray = new Array();
			for (var i = 0; i < orderLength.length; i++) {
				if(orderLength[i].confirm_kubun){
					var length = orderLength[i].order_id.length;
					orderIdArray.push(orderLength[i].order_id.substring(length-23, length-11));
					}
				}
			localStorage.setItem("key", "orderButton");
			var orderIdString = orderIdArray.join(',');
			window.location.href= contextPath + "/orderlist/gotoConfirm/" + orderIdString;
		  } 
		});
}

//検索メニューを閉じる
$(function() {
	$('#toggleButton').click(function() {
		if ($('#conditionDiv').is(':hidden')) {
			$('#conditionDiv').slideDown('slow');
			$(this).html('検索メニューを閉じる <i class="fa fa-caret-up"></i>');
		} else {
			$('#conditionDiv').slideUp('slow');
			$(this).html('検索メニューを開く<i class="fa fa-caret-down"></i>');
		}

	});
});

//未承認、未会計、工場自動連携失敗　ボタン同時クリアできません
function checkboxOnclick(checkbox){
		if (checkbox.checked == true && checkbox.id =='isConfirm'){
			$("#isAccount").attr("checked",false); 
			$("#isSendFailure").attr("checked",false); 
			$("#isCancelled").attr("checked",false); 
			$("#isOtherShop").attr("checked",false); 
		}
		if (checkbox.checked == true && checkbox.id =='isAccount'){
			$("#isConfirm").attr("checked",false); 
			$("#isSendFailure").attr("checked",false); 
			$("#isCancelled").attr("checked",false); 
			$("#isOtherShop").attr("checked",false); 
		}
		if (checkbox.checked == true && checkbox.id =='isSendFailure'){
			$("#isAccount").attr("checked",false); 
			$("#isConfirm").attr("checked",false); 
			$("#isCancelled").attr("checked",false); 
			$("#isOtherShop").attr("checked",false); 
		}
		if (checkbox.checked == true && checkbox.id =='isCancelled'){
			$("#isAccount").attr("checked",false); 
			$("#isConfirm").attr("checked",false); 
			$("#isSendFailure").attr("checked",false); 
		}
		if (checkbox.checked == true && checkbox.id =='isOtherShop'){
			$("#isAccount").attr("checked",false); 
			$("#isConfirm").attr("checked",false); 
			$("#isSendFailure").attr("checked",false); 
		}
}

//金額フォーマット
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
</script>
