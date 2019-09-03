<style>

.col-grid {
	position: relative;
	width: 100%;
	min-height: 1px;
	padding-left: 15px;
	-ms-flex: 0 0 99%;
	flex: 0 0 99%;
	max-width: 99%
}

.slick-cell.selected {
	background-color: #FBB;
}

.cell-del-type {
	text-align: center;
}

.cell-money {
  text-align: right;
}

.red {
	background-color: #FA8072;
}

.yellow {
	background-color: #FFFFE0;
}

.test_input {
	width: 100%;
	height: 100%;
	border: 0;
	margin: 0;
	background: transparent;
	outline: 0;
	padding: 0;
	disabled: true;
}

.alert-error {
	background: #fff1f0;
	color: #d85030;
	border-color: rgba(216, 80, 48, 0.3);
	width: 800px;
}

.alert-success {
	color: #155724;
	background-color: #d4edda;
	border-color: #c3e6cb;
	width:800px;
}

.btn_off {
	cursor: pointer;
	vertical-align: bottom;
	background: #996600;
	border: 1px solid #85786A;
	color: #fff;
	width: 60px;
	height: 25px;
	padding: 10 10 20 10;
	font-size: 11px;
	font-weight: bold;
	position: relative;
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.3);
	border: 0px solid #E25A00;
	border: 0px solid #85786A
}

.btn_blue {
	background: #007bff;
	border: 1px solid #007bff;
}
</style>

<spring:eval var="sessionContent" expression="@sessionContent" />
<div class="breadcrumbs">
	<div class="col-sm-4">
		<div class="page-header float-left">
			<c:choose>
				<c:when test="${sessionContent.authority == '01'}">
					<div class="page-title">
						<h1>在庫確認</h1>
					</div>
				</c:when>
				<c:when test="${sessionContent.authority == '02'}">
					<div class="page-title">
						<h1>在庫管理</h1>
					</div>
				</c:when>
				<c:when test="${sessionContent.authority == '03'}">
					<div class="page-title">
						<h1>在庫管理</h1>
					</div>
				</c:when>
			</c:choose>
		</div>
	</div>
</div>

<div class="content mt-3">
	<div class="alert alert-error" id="errorMassageIno" style="display: none"></div>
	<div class="alert alert-success" id="successMessage" style="display:none"></div>
	<div class="animated fadeIn">
		<div class="card" id="nav1_custom_div">
			<div class="card-body">
				<!-- 検索条件部分 End -->
					<div class="row">
						<!-- 左側項目 -->
						<div class="col col-lg-6">
							<div class="row form-group">
								<div class="col col-md-4">
									<label class=" form-control-label">生地品番</label>
								</div>
								<div class="col-12 col-md-8">
									<div class="form-check-inline form-check">
										<input type="text" id="fabricNo" name="fabricNo" placeholder="" maxlength="20" class="input-sm form-control-sm form-control col-md-4">
										&nbsp;－&nbsp; 
										<input type="text" id="color" name="color" placeholder="" maxlength="1" class="input-sm form-control-sm form-control col-md-2">
										&nbsp; 
										<input type="text" id="pattern" name="pattern" placeholder="" maxlength="1" class="input-sm form-control-sm form-control col-md-2">
									</div>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-4">
									<label class=" form-control-label">生地ブランド名</label>
								</div>
								<div class="col-12 col-md-8">
									<select name="brandName" id="brandName" class="form-control-sm form-control">
										<option value=""></option>
									</select>
								</div>
							</div>
							<c:choose>
							<c:when test="${sessionContent.authority == '01' || sessionContent.authority == '02'}">
							<div class="row form-group">
								<div class="col col-md-4">
									<label class=" form-control-label">メーカー</label>
								</div>
								<div class="col-12 col-md-8">
									<select id="makerName" name="makerName" class="form-control-sm form-control">
										<option value=""></option>
									</select>
								</div>
							</div>
							</c:when>
							<c:when test="${sessionContent.authority == '03'}">
							<div class="row form-group">
								<div class="col col-md-4">
									<label class=" form-control-label">メーカー</label>
								</div>
								<div class="col-12 col-md-8">
									<select id="makerName" name="makerName" class="form-control-sm form-control" disabled>
									</select>
								</div>
							</div>
							</c:when>
        					</c:choose> 
						</div>
						<!-- 右側項目 -->
						<div class="col col-lg-6">
							<div class="row form-group">
								<div class="col col-md-4">
									<label class=" form-control-label">　</label>
								</div>
								<div class="col-12 col-md-8">　</div>
							</div>
							<c:choose>
								<c:when test="${sessionContent.authority != '03'}">
									<div class="row form-group">
										<div class="col col-md-4">
											<label class=" form-control-label">上代</label>
										</div>
										<div class="col-12 col-md-8">
											<div class="form-check-inline form-check">
												<input type="text" id="retailPrice" name="retailPrice" placeholder="" class="input-sm form-control-sm form-control col-md-5" maxlength = "9" oninput="this.value=this.value.replace(/[^\d]/g,'')">
												&nbsp;～&nbsp; 
												<input type="text" id="retailPriceTo" name="retailPriceTo" placeholder="" class="input-sm form-control-sm form-control col-md-5" maxlength = "9" oninput="this.value=this.value.replace(/[^\d]/g,'')">
											</div>
										</div>
									</div>
								</c:when>
							</c:choose>
							<div class="row form-group">
								<div class="col col-md-4">
									<label class=" form-control-label">工場</label>
								</div>
								<div class="col-12 col-md-8">
									<select id="factoryName" name="factoryName"
										class="form-control-sm form-control">
										<option value=""></option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<!-- 検索条件部分 End -->

					<!-- 制御ボタン部分 Start -->
					<div class="row">
						<div class="col"></div>
						<div class="col col-md-4">
							<button type="button" id="clear_button" class="btn btn-danger btn-block">
								<i class="fa fa-trash-alt"></i> クリア
							</button>
						</div>
						<div class="col col-md-4">
							<button type="button" id="select_button" onclick='judge(e)' class="btn btn-primary btn-block">
								<i class="fa fa-check-circle"></i> 検索
							</button>
						</div>
						<div class="col"></div>
					</div>
					<!-- 制御ボタン部分 End -->
			</div>
			<!-- card body -->
		</div>
		<!-- card -->
	</div>
	<div id="slick" style="display: none">
		<div class="row">
			<div class="col-grid">
				<div id="gridContainer">
					<div id="myGrid" style="width: 100%"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- .animated -->
	<!-- <div id="slick" style="display: none">
	
		<div class="content container" style="float: left">
			<div class="row">
				<div class="col-12">
					<div id="gridContainer">
						SlickGridテーブルの表示領域となる要素
						<div id="myGrid" style="width: 100%;"></div>
					</div>
				</div>
				<div class="col-3">
				</div>
			</div>
		</div>
	</div> -->


<!-- 依存ライブラリの読み込み -->
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/firebugx.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-1.11.2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-ui-1.11.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery.event.drag-2.3.0.js"></script>

<!-- SlickGridモジュールの読み込み -->
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.core.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.formatters.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.editors.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/plugins/slick.rowdetailview.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/plugins/slick.rowselectionmodel.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.grid.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.dataview.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/controls/slick.pager.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/controls/slick.columnpicker.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/app/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>

<script type="text/javascript">
var dataView;
var grid;
var sortcol = "fabricNo";
var sortdir = 1;
var contextPath = $("meta[name='contextPath']").attr("content");
var Row;
//データ変更の行号
var changeRowNum = new Array();
//一意制約の行号
var errorRowNum = new Array();
var cRNum = 0;
var eRNum = 0;
var updateFlag = true;
var retailPriceTo=0;
var e;

//サイズを調整する前に、最小の高さ/幅/塗りつぶしを定義します。
var DATAGRID_MIN_HEIGHT = 180;
var DATAGRID_MIN_WIDTH = 200;
var DATAGRID_BOTTOM_PADDING = 20;

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
		height: newHeight,
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
}

function comparer(a, b) {
	  var x = a[sortcol], y = b[sortcol];
	  return (x == y ? 0 : (x > y ? 1 : -1));
	}

function mineFormatter ( row, cell, value, columnDef, dataContext ) {
    return value;
}

//色の変更
function colorFormatter(row, cell, value, columnDef, dataContext) {
	var rtn = { text: value, removeClasses: 'red yellow' };
	//一意制約の場合
	if (errorRowNum.includes(dataContext.num)) {
		    rtn.addClasses = "red";
	}
	//データ変更の場合
	if (changeRowNum.includes(dataContext.num)) {
	    rtn.addClasses = "yellow";
    }
	return rtn;
}

//入力の理論在庫の判定
function requiredtheoreticalStock(value) {
	if (value == "" || value == null) {
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');
		appendAlert('errorMassageIno', getMsgByOneArg('msg001', '理論在庫'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
 		//$("#update").attr("disabled",true);
		return {valid: false};
	}else if (!(/^\d{1,3}$|^\d{1,3}\.\d{1,2}$/.test(value))){
		//(/^\d{0,3}(\.\d{0,2})?$/.test(value))
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');
		appendAlert('errorMassageIno', getMsgByOneArg('msg098', '理論在庫'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		return {valid: false};
		}
	else {
		return {valid: true};		
	}
}

//入力の実在庫の判定
function requiredactualStock(value) {
	if (value == "" || value == null) {
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');
		appendAlert('errorMassageIno', getMsgByOneArg('msg001', '実在庫'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
 		//$("#update").attr("disabled",true);
		return {valid: false};
	}else if(!(/^\d{1,3}$|^\d{1,3}\.\d{1,2}$/.test(value))){
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');
		appendAlert('errorMassageIno', getMsgByOneArg('msg098', '実在庫'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
 		//$("#update").attr("disabled",true);
		return {valid: false};
		}
	else {
		return {valid: true};		
	}
}

function judge(e){
	if(e && e.target==e.currentTarget){
	}else {
		appendAlertDel('successMessage');
	}
}

function update_button(j){
	swal({
		  text: getMsgByOneArg('msg025', '在庫情報'),
		  icon: "info",
		  buttons: ["キャンセル", true],
		  }).then((isConfirm) => {
			  if(isConfirm){
				  appendAlertDel('errorMassageIno');
				  appendAlertDel('successMessage');
				  	var updData;
					var updData1;
					//grid.setActiveCell(0,0);
					grid.gotoCell(cell.row, cell.cell,true);
					var sendData = JSON.stringify(dataView.getItems());
					var obj = eval('('+ sendData +')');
					var status = true;
					var checkStatus = 0;
					for(var i=0;i<obj.length;i++){
						if(j==obj[i].num){
							obj[i].retailPrice=obj[i].retailPrice.replace(",","");
							updData = obj[i];
						}
					}
					updData1 = "[" + JSON.stringify(updData) + "]";
					if($("#errorMassageIno").text() == ""){
						$.ajax({
						    type:"post",
						    url: contextPath + "/stock/update",
						    data:updData1,
						    dataType:"json",
						    contentType:"application/json",
						    success:function(result){
							if(result == "1"){
								appendAlert("errorMassageIno",getMsg('msg033'));
								}
							else if(result == "0"){
								appendAlert("errorMassageIno",getMsgByTwoArgs('msg108',"在庫情報","在庫情報"));
								}
							else{
								if($("#errorMassageIno").text() == ""){
									appendAlert("successMessage",getMsgByOneArg('msg044', "在庫情報"));
									}
								
								
								e = document.createEvent("MouseEvents");
								
								e.initEvent("click", true, true);
								e.eventType = 'message';

								document.getElementById("select_button").dispatchEvent(e);														
								}  
						    }
						});
					}
					
				  }
			});
		
} 
//CSRF令牌
$(function () {
	// CSRFトークン値を連携するためのリクエストヘッダ名を取得する
    var headerName = $("meta[name='_csrf_header']").attr("content");
    // CSRFトークン値を取得する
    var tokenValue = $("meta[name='_csrf']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        // リクエストヘッダにCSRFトークン値を設定する
        xhr.setRequestHeader(headerName, tokenValue);
    });
});
$(document).ready(function() {
	$.ajax({
		type:"get",
	    url:contextPath + "/stock/selectBrandName"}).then(function(result){
	    	$("#brandName").empty();
	    	$("#brandName").append(jQuery('<option />').val("").text(""));
	    	for (var key in result) {
	    		$("#brandName").append(jQuery('<option />').val(result[key].fablicBrandNo).text(result[key].brandName));
			 }
		});
	$.ajax({
		type:"get",
	    url:contextPath + "/stock/selectMaker",async:false}).then(function(result){
	    	$("#makerName").empty();
	    	$("#makerName").append(jQuery('<option />').val("").text(""));
	    	for (var key in result) {
	    		$("#makerName").append(jQuery('<option />').val(result[key].makerCode).text(result[key].makerName));
			 }
		});
	$.ajax({
		type:"get",
	    url:contextPath + "/stock/selectfactoryName",async:false}).then(function(result){
	    	$("#factoryName").empty();
	    	$("#factoryName").append(jQuery('<option />').val("").text(""));
	    	for (var key in result) {
	    		$("#factoryName").append(jQuery('<option />').val(result[key].factoryCode).text(result[key].factoryName));
			 }
		});
	jQuery("#makerName").change(function(){
		var makerName = jQuery("#makerName").val();
		$.ajax({
			type:"get",
		    url:contextPath + "/stock/selectfactoryName"}).then(function(result){
		    	$("#factoryName").empty();
		    	$("#factoryName").append(jQuery('<option />').val("").text(""));
		    	for (var key in result) {
			    	if(makerName == result[key].makerCode){
			    		$("#factoryName").append(jQuery('<option />').val(result[key].factoryCode).text(result[key].factoryName));
				    }
				    if(makerName == ""){
				    	$("#factoryName").append(jQuery('<option />').val(result[key].factoryCode).text(result[key].factoryName));
					}
				 }
			});	
		});
	

	var authority = '${sessionContent.authority}';
	if(authority == "03"){
		var makerName = '${sessionContent.belongCode}';
		jQuery("#makerName").val(makerName);
		jQuery("#makerName").change();
	}else{
		var makerName = $("#makerName").val();
	}

	$("#clear_button").click(function(){
		$("#fabricNo").val("");
		$("#color").val("");
		$("#pattern").val("");
		$("#brandName").val("");
		//$("#makerName").val("");
		$("#factoryName").val("");
		$("#retailPrice").val("");
		$("#retailPriceTo").val("");
		if(authority != "03"){
			$("#makerName").val("");
			$.ajax({
				type:"get",
			    url:contextPath + "/stock/selectfactoryName"}).then(function(result){
			    	$("#factoryName").empty();
			    	$("#factoryName").append(jQuery('<option />').val("").text(""));
			    	for (var key in result) {
			    		$("#factoryName").append(jQuery('<option />').val(result[key].factoryCode).text(result[key].factoryName));
					 }
				});	
			}
		
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');
	});
});

$(document).ready(function() {
	$("#slick").hide();	
  // (1) SlickGridのカラム定義
  var columns;
  // '01'店舗
  if(${sessionContent.authority == '01'}){
	  columns = [
			{id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection", width: 40, resizable: false, selectable: false,sortable: false },
		    {id: 'fabric_no', name: '生地品番', field: 'fabricNoCP',formatter: colorFormatter, width: 171, sortable: true},
		    {id: 'brand_name', name: '生地ブランド名', field: 'brandName',formatter: colorFormatter, width: 171, sortable: true},
		    {id: 'factory_name', name: '工場', field: 'factoryName',formatter: colorFormatter, sortable: true},
		    {id: 'retail_price', name: '上代', field: 'retailPrice',formatter: colorFormatter, sortable: true, cssClass: "cell-money"},
		    {id: 'reservation_stock', name: '予約生地量', field: 'reservationStock',formatter: colorFormatter, sortable: true, cssClass: "cell-money"},
		    {id: 'theoretical_stock', name: '理論在庫', field: 'theoretical',formatter: colorFormatter, sortable: true, cssClass: "cell-money"},
		  ];
	  }
  //'02'商品
  if(${sessionContent.authority == '02'}){
	  columns = [
			{id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection", width: 40, resizable: false, selectable: false,sortable: false },
		    {id: 'fabric_no', name: '生地品番', field: 'fabricNoCP',formatter: colorFormatter, width: 141, sortable: true},
		    {id: 'brand_name', name: '生地ブランド名', field: 'brandName',formatter: colorFormatter, width: 141, sortable: true},
		    {id: 'factory_name', name: '工場', field: 'factoryName',formatter: colorFormatter, sortable: true},
		    {id: 'retail_price', name: '上代', field: 'retailPrice',formatter: colorFormatter, sortable: true, cssClass: "cell-money"},
		    {id: 'reservation_stock', name: '予約生地量', field: 'reservationStock',formatter: colorFormatter, sortable: true, cssClass: "cell-money"},
		    {id: 'theoretical_stock', name: '理論在庫', field: 'theoretical',formatter: colorFormatter, editor: Slick.Editors.Text, sortable: true, validator: requiredtheoreticalStock, cssClass: "cell-money"},
		    {id: 'actual_stock', name: '実在庫', field: 'actualStock',formatter: colorFormatter, editor: Slick.Editors.Text, sortable: true, validator: requiredactualStock, cssClass: "cell-money"},
		    {id: "updType", name: "", height:30,width: 70, minWidth: 60, maxWidth: 70, cssClass: "cell-upd-type", field: "updType", formatter: mineFormatter, cannotTriggerInsert: true, sortable: false}
		  ];
	  }
//'03'メーカー
  if(${sessionContent.authority == '03'}){
	  columns = [
			{id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection", width: 40, resizable: false, selectable: false,sortable: false },
		    {id: 'fabric_no', name: '生地品番', field: 'fabricNoCP',formatter: colorFormatter, width: 141, sortable: true},
		    {id: 'brand_name', name: '生地ブランド名', field: 'brandName',formatter: colorFormatter, width: 141, sortable: true},
		    {id: 'factory_name', name: '工場', field: 'factoryName',formatter: colorFormatter, sortable: true},
		    {id: 'reservation_stock', name: '予約生地量', field: 'reservationStock',formatter: colorFormatter, sortable: true, cssClass: "cell-money"},
		    {id: 'theoretical_stock', name: '理論在庫', field: 'theoretical',formatter: colorFormatter, sortable: true, cssClass: "cell-money"},
		    {id: 'actual_stock', name: '実在庫', field: 'actualStock',formatter: colorFormatter, editor: Slick.Editors.Text, sortable: true, validator: requiredactualStock, cssClass: "cell-money"},
		    {id: "updType", name: "", height:30, width: 70, minWidth: 60, maxWidth: 70, cssClass: "cell-upd-type", field: "updType", formatter: mineFormatter, cannotTriggerInsert: true, sortable: false}
		  ];
	  }

  // (2) SlickGridの動作オプション
	 var options = {
	  editable: true,
	  enableAddRow: false,
	  enableCellNavigation: true,
	  asyncEditorLoading: true,
	  forceFitColumns: true,
	  topPanelHeight: 25,
	  rowHeight: 30
	};

	$("#select_button").click(function() {
		var winWidth = 0;
		if (window.innerWidth){
			winWidth = window.innerWidth;
		}
		$("#slick").width(winWidth - 290);
		
		changeRowNum.length = 0;
		cRNum = 0;
		errorRowNum.length = 0;
		eRNum = 0;
		var orderPattern = '${sessionContent.category}';
		var fabricNo = $("#fabricNo").val();
		var color = $("#color").val();
		var pattern = $("#pattern").val();
		var brandName = $("#brandName").val();
		var retailPrice = $("#retailPrice").val();
		var retailPriceTo = $("#retailPriceTo").val();
		var makerName = $("#makerName").val();
		var factoryName = $("#factoryName").val();
		var data = [];
		$.ajax({
			url : contextPath + "/stock/fuzzyQuery",
			type : 'get',
			data : {"orderPattern" : orderPattern,"fabricNo" : fabricNo,"color" : color,"pattern" : pattern,"brandName" : brandName,"retailPrice" : retailPrice,"retailPriceTo" : retailPriceTo,"makerName" : makerName,"factoryName" : factoryName}
		}).then(function(result) {
			appendAlertDel('errorMassageIno');
			if(Object.keys(result).length  == 0){
				$("#slick").hide();
				//alert("検索結果が0件でした。条件を変更して再検索してください。");
				appendAlert("errorMassageIno",getMsgByOneArg('msg031'));
				appendAlertDel('successMessage');
			}else{
				$("#slick").show();
			}
				for(var i = 0; i < result.length; i++) {
					var d = (data[i] = {});
					d["id"] = "id_" + i;
					d["num"] = i + 1;
					d["orderPattern"] = result[i].orderPattern;
					d["fabricNo"] = result[i].fabricNo;
					d["fabricNoCP"] = result[i].fabricNo+ "-" + result[i].color + result[i].pattern;
					d["brandName"] = result[i].brandName;
					d["factoryName"] = result[i].factoryName;
					/* d["retailPrice"] = result[i].retailPrice; */
					if (result[i].retailPrice == null){
				    	d["retailPrice"] = "0";
					}else{
						d["retailPrice"] = formatMoney(result[i].retailPrice, 0, "");
					}
					d["reservationStock"] = result[i].reservationStock;
					d["theoretical"] = result[i].theoretical;
					d["theoreticalStock"] = result[i].theoreticalStock;
					d["actualStock"] = result[i].actualStock;
					d["version"] = result[i].version;
					d["createdAt"] = result[i].createdAt;
					d["updatedAt"] = result[i].updatedAt;
					d["updType"] = "<button id='update' class='btn_off btn_blue' onclick='update_button("+(i+1)+")'><font size='3'>更新</font></button>";
					d["optionType"] = "1";
					d["isNewData"] = "0";
				}

					// SlickGridテーブルを作成
					dataView = new Slick.Data.DataView();

					grid = new Slick.Grid("#myGrid", dataView,columns, options);
					grid.setActiveCell(0,0);
					grid.setSelectionModel(new Slick.RowSelectionModel());
 					grid.onAddNewRow.subscribe(function(e,args) {
						var item = {"num": data.length, "id": "new_" + (Math.round(Math.random() * 10000)),"fabric_no" : "","brand_name" : "","factory_name" : "","retail_price" : "","reservation_stock" : "","theoretical_stock" : "","actual_stock" : "", "updType": "","optionType": "2", "isNewData": "1"};
						$.extend(item,args.item);
 						dataView.addItem(item);						
					});
					grid.init();
						
					grid.onCellChange.subscribe(function(e, args) {
						//データ変更の場合、行号を記録する
						changeRowNum[cRNum] = args.item.num;
						cRNum++;
						dataView.updateItem(args.item.id, args.item);
					});
					
					grid.onActiveCellChanged.subscribe(function(e, args) {
						var item = args.grid.getDataItem(args.row);
						if (item != null && item.isNewData == 0){
							if(item.isNewData == 0){
		 						appendAlertDel('errorMassageIno');
		 						appendAlertDel('successMessage');
							}else{
								$(".editor-text").removeAttr("disabled");
								grid.getCellEditor().focus();
							}
						}else{
							$(".editor-text").removeAttr("disabled");
							grid.getCellEditor().focus();
						}
						$("#select_button").removeAttr("disabled");
						$("#clear_button").removeAttr("disabled");
						$("#update_button").removeAttr("disabled");
 						appendAlertDel('errorMassageIno');
 						appendAlertDel('successMessage');
					});
					
					grid.onSort.subscribe(function(e, args) {
						sortdir = args.sortAsc ? 1 : -1;
						sortcol = args.sortCol.field;

						dataView.sort(comparer, args.sortAsc);
					});
						

					dataView.onRowCountChanged.subscribe(function(e, args) {
						grid.updateRowCount();
						grid.render();
					});

					dataView.onRowsChanged.subscribe(function(e, args) {
						grid.invalidateRows(args.rows);
						grid.render();
					});

					// initialize the model after all the events have been hooked up
					dataView.beginUpdate();
					dataView.setItems(data);
					dataView.endUpdate();
					attachAutoResizeDataGrid(grid, "myGrid", "gridContainer");
		});
	});
$("#fabricNo,#color,#pattern,#brandName,#makerName,#retailPrice,#retailPriceTo,#factoryName").click(function(){
	appendAlertDel('errorMassageIno');
	appendAlertDel('successMessage');
		});

});
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