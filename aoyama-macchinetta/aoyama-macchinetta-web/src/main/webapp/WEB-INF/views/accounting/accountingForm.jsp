<style>
a:link{color:blue;}

.slick-cell.selected {
	background-color: #FBB;
}

.alert-error {
	background: #fff1f0;
	color: #d85030;
	border-color: rgba(216, 80, 48, 0.3);
}
.red{ 
    background-color:red;
}

.cell-money {
  text-align: right;
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
</style>
<spring:eval var="sessionContent" expression="@sessionContent" />
<div class="breadcrumbs">
	<div class="col-sm-4">
		<div class="page-header float-left">
			<div class="page-title">
				<h1>会計一覧</h1>
			</div>
		</div>
	</div>
</div>

<div class="content mt-3">
<div class="alert alert-error" id="errorMassageIno" style="display:none"></div>
	<div class="animated fadeIn">

		<div class="card" id="nav1_custom_div">
			<div class="card-body">
				<!-- 検索条件部分 End -->
				<form:form id ="conditionForm" method="post" modelAttribute="accountingForm" enctype="multipart/form-data" class="form-horizontal">
					<div class="row">
						<!-- 左側項目 -->
						<div class="col col-lg-6">
							<div class="row form-group">
								<div class="col col-md-4">
									<label class=" form-control-label">会員番号</label>
								</div>
								<div class="col-12 col-md-8">
									<form:input path="custCd" type="text" id="custCd" name="text-input" oninput="this.value=this.value.replace(/[^\d]/g,'')" maxlength="13"
										placeholder="" class="input-sm form-control-sm form-control"/>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-4">
									<label class=" form-control-label">営業担当者</label>
								</div>
								<div class="col-12 col-md-8">
									<form:input path="storeStaffNm" type="text" id="storeStaffNm" name="text-input" maxlength="50"
										placeholder="" class="input-sm form-control-sm form-control"/>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-4">
									<label class=" form-control-label">承り日</label>
								</div>
								<div class="col-12 col-md-8">
									<div class="form-check-inline form-check">
										<form:input path="productOrderdDateFromStr" type="text" id="productOrderdDateFromStr" name="text-input"
											placeholder="年/月/日" max= "9999-12-31"
											class="input-sm form-control-sm form-control col-md-6"/>
										&nbsp;～&nbsp; <form:input path="productOrderdDateToStr" type="text" id="productOrderdDateToStr"
											name="text-input" placeholder="年/月/日" max= "9999-12-31"
											class="input-sm form-control-sm form-control col-md-6"/>
									</div>
								</div>
							</div>
							<br/>
							<div class="row form-group">
								<div class="col-12 col-md-8">
									<div class="form-check-inline form-check">
										<label for="isAccount" class="form-check-label"> <form:checkbox path="isAccount"
											 id="isAccount" name="text-checkbox" value=""
											placeholder="" class="form-check-input"/> 再確認要の会計のみ
										</label>
									</div>
								</div>
								<div class="col col-md-4">
									<label class=" form-control-label"> </label>
								</div>
							</div>
							<br/>
						</div>
						<!-- 右側項目 -->
						<c:choose>
						<c:when test="${sessionContent.authority == '01'}">
						<div class="col col-lg-6">
							<div class="row form-group">
								<div class="col col-md-4">
									<label class=" form-control-label">業態</label>
								</div>
								<div class="col-12 col-md-8">
									<select  class="input-sm form-control-sm form-control" id="storeBrandCode_1" name="storeBrandCode" disabled >
										<option value=""></option>
										<option value="01">AO</option>
										<option value="03">TSC</option>
										<option value="12">UL</option>
										<option value="21">ULM</option>
									</select>	
								</div>
							</div>
							<div class="row form-group">	
								<div class="col col-md-4">
									<label class=" form-control-label">店舗</label>
								</div>
								<div class="col-12 col-md-8">
									<select class="input-sm form-control-sm form-control" id="shopCode_1" name="shopName" data-placeholder="店舗を選択" disabled></select>
								</div>
							</div>
						</div>
						</c:when>
						<c:when test="${sessionContent.authority == '02'}">
						<div class="col col-lg-6">
							<div class="row form-group">
								<div class="col col-md-4">
									<label class=" form-control-label">業態</label>
								</div>
								<div class="col-12 col-md-8">
									<form:select path="storeBrandCode" class="input-sm form-control-sm form-control" id="storeBrandCode" name="storeBrandCode">
										<form:option value=""></form:option>
										<form:option value="01">AO</form:option>
										<form:option value="03">TSC</form:option>
										<form:option value="12">UL</form:option>
										<form:option value="21">ULM</form:option>
									</form:select>	
								</div>
							</div>
							<div class="row form-group">	
								<div class="col col-md-4">
									<label class=" form-control-label">店舗</label>
								</div>
								<div class="col-12 col-md-8">
									<form:select path="shopCode"  class="input-sm form-control-sm form-control" data-placeholder="店舗を選択"></form:select>
								</div>
							</div>
						</div>
						</c:when>
        				</c:choose> 
					</div>
				</form:form>
					<!-- 検索条件部分 End -->

					<!-- 制御ボタン部分 Start -->
					<div class="row">
						<div class="col"></div>
						<div class="col col-md-4">
							<button type="button" id="clear_button"
								class="btn btn-danger btn-block">
								<i class="fa fa-trash-o"></i> クリア
							</button>
						</div>
						<div class="col col-md-4">
							<button onclick="searchOrder();" type="button" id="select_button"
								class="btn btn-primary btn-block">
								<i class="fa fa-check-circle"></i> 検索
							</button>
						</div>
						<div class="col"></div>
					</div>
					<br/>
					<!-- 制御ボタン部分 End -->

			</div>
			<!-- card body -->
		</div>
		<!-- card -->

	</div>
	<br/>
	<!-- .animated -->

	<div class="card" id="areaResult" style="display:none;">
		<div class="card-body">
			<div class="row">
				<div class="col col-md-6 text-right"></div>
				<div class="col col-md-6 text-right">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="text-center">合計件数</th>
								<th class="text-center">合計点数</th>
								<th class="text-center">合計金額</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-right"><output id="sumAccount"></output></td>
								<td class="text-right"><output id="sumPoint"></output></td>
								<td class="text-right"><output id="sumAmount"></output></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- SlickGridテーブルの表示領域となる要素 -->
		<div class="row">
			<div class="col-grid">
				<div id="gridContainer">
					<div id="myGrid" style="width: 100%; height: 500px;"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 依存ライブラリの読み込み -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/bootstrap-datepicker3.css" type="text/css">
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
<script 
	src="${pageContext.request.contextPath}/resources/app/js/chosen.jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/app/js/bootstrap-datepicker.js"></script>

<script type="text/javascript">
var dataView;
var grid;
var sortcol = "cashId";
var sortdir = 1;
var contextPath = $("meta[name='contextPath']").attr("content");
var Row;

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

// カレンダー表示の設定
$('#productOrderdDateFromStr').datepicker({
	   format: 'yyyy/mm/dd',
	    clearBtn: true,
	    language: 'ja',
	    todayBtn: "linked",
	    orientation: 'buttom auto',
	    todayHighlight: true,
	    autoclose: true
});
// カレンダー表示の設定
$('#productOrderdDateToStr').datepicker({
	   format: 'yyyy/mm/dd',
	    clearBtn: true,
	    language: 'ja',
	    todayBtn: "linked",
	    orientation: 'buttom auto',
	    todayHighlight: true,
	    autoclose: true
});

function  addmulMonth(dtstr,n){   // n个月后 
	   var s=dtstr.split("-");
	   var yy=parseInt(s[0]); 
	   var mm=parseInt(s[1])-1;
	   var dd=parseInt(s[2]);
	   var dt=new Date(yy,mm,dd);
	   dt.setMonth(dt.getMonth()+n);
	   if( (dt.getYear()*12+dt.getMonth()) > (yy*12+mm + n) ){
		   dt=new Date(dt.getYear(),dt.getMonth(),0);
		   }
	   return format(dt);
	}
function format(date) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    var minute = date.getMinutes();
    minute = minute < 10 ? ('0' + minute) : minute;
    return y + '-' + m + '-' + d;
}

//日付フォーマット
function dateFormat(time){
	var date = new Date(time);
	var year = date.getFullYear();  
	var month = date.getMonth() + 1
	if(month<=9){
		month = "0" + month;
	}
	var day = date.getDate();
	if(day<=9){
		day = "0" + day;
	}
	return year+"-"+month+"-"+day;
}

function comparer(a, b) {
	  var x = a[sortcol], y = b[sortcol];
	  return (x == y ? 0 : (x > y ? 1 : -1));
}
function mineFormatter ( row, cell, value, columnDef, dataContext ) {
  return value;
}

function gotoAccount(cashId){
	localStorage.setItem("key", "cashLink");
	window.location.href= contextPath + "/cash/goToAccountingLink/"+cashId;
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
//--------------------------------------------
//他店舗のとき　店舗を検索した
//--------------------------------------------
function initCustomer() {
	var authority = '${sessionContent.authority}';
 	if(authority == "02"){
		var obj = document.getElementById("shopCode");
		obj.options.length=0;
		obj.add(new Option("",""));
		jQuery.ajax({
	        url: contextPath + "/accounting/selectShop",
	        type: 'get',
	        async:false,
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	        	   obj.add(new Option(e.shopName,e.shopCode));
	           });
	           jQuery("#shopCode").trigger("chosen:updated");
	           jQuery("#shopCode").chosen({
	           allow_single_deselect:true,
	       	   disable_search_threshold: 10,
	       	   no_results_text: "この店舗が見つかりませんでした。!:",
	       	   width: "100%"
	       	   }); 
	        }
	    });
	}
	
	if(authority == "01"){
		var obj = document.getElementById("shopCode_1");
		obj.options.length=0;
		obj.add(new Option("",""));
		jQuery.ajax({
	        url: contextPath + "/accounting/selectShop",
	        type: 'get',
	        async:false,
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	               obj.add(new Option(e.shopName,e.shopCode_1));
	           });
	           jQuery("#shopCode_1").trigger("chosen:updated");
	           jQuery("#shopCode_1").chosen({
	       	   disable_search_threshold: 10,
	       	   no_results_text: "この店舗が見つかりませんでした。!:",
	       	   width: "100%"
	       	   }); 
	        }
	    });
	}
	jQuery("#storeBrandCode").change(function(){
		var storeBrandCode = jQuery("#storeBrandCode").val();
		$.ajax({
			type:"get",
			data:{"storeBrandCode":storeBrandCode},
		    url:contextPath + "/accounting/findShopByStoreBrandCode"}).then(function(data){
		    	//$("#shopCode").empty();
		    	var obj = document.getElementById("shopCode");
				obj.options.length=0;
				obj.add(new Option("",""));
		    	jQuery.each(data, function (index, e) {
		               obj.add(new Option(e.shopName,e.shopCode));
		           });
		           jQuery("#shopCode").trigger("chosen:updated");
		           jQuery("#shopCode").chosen({
		           allow_single_deselect:true,
		       	   disable_search_threshold: 10,
		       	   no_results_text: "この店舗が見つかりませんでした。!:",
		       	   width: "100%"
		       	   }); 
		    	 
			});	
		});
}
$(document).ready(function() {
	//$("#areaResult").hide();	
  // (1) SlickGridのカラム定義
  //     6つのカラムのそれぞれにつき ID・表示名・マッピングするデータ を定義している。
  var columns = [
	  	{id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection", width: 40, resizable: false, selectable: false,sortable: false },
	  	{id: 'shop_name', name: '店舗名', field: 'shopName', formatter: mineFormatter, sortable: true},
	    {id: 'cash_id', name: '会計NO.', field: 'cashId', formatter: mineFormatter, sortable: true},
	    {id: 'product_orderd_date', name: '承り日', field: 'productOrderdDate', formatter: mineFormatter, sortable: true},
	    {id: 'order_amount', name: '点数', field: 'orderAmount', formatter: mineFormatter, cssClass: "cell-money", sortable: true},
	    {id: 'cash_except_tax_price', name: '商品金額', field: 'cashExceptTaxPrice', formatter: mineFormatter, cssClass: "cell-money", sortable: true},
	    {id: 'store_staff_nm', name: '営業担当者', field: 'storeStaffNm', formatter: mineFormatter, sortable: true}
 ];
  // (2) SlickGridの動作オプション
	var options = {
	  editable: true,
	  enableAddRow: false,
	  enableCellNavigation: true,
	  asyncEditorLoading: false,
	  forceFitColumns: true,
	  topPanelHeight: 25
	};
	
	var initFlag = "${initFlag}";
	if (initFlag == "0"){
		initCustomer();
		//初期化のとき、検索結果Divを表示しない
		$("#areaResult").hide();
	}
	if (initFlag == "1"){
		jQuery("#storeBrandCode").change();
		initCustomer();
		var shopCode = "${accountingForm.shopCode}";
		jQuery("#shopCode").val(shopCode);
		jQuery("#shopCode").trigger("chosen:updated");
		searchOrder();
	}

	$("#clear_button").click(function(){
		$("#custCd").val("");
		$("#storeStaffNm").val("");
		$("#productOrderdDateFromStr").val("");
		$("#productOrderdDateToStr").val("");
		$("#isAccount").attr("checked",false);
		$("#storeBrandCode").val("");
		$("#shopCode").val("");
		$("#shopCode").trigger("chosen:updated");
		var authority = '${sessionContent.authority}';
		if(authority == "02"){
			var obj = document.getElementById("shopCode");
			obj.options.length=0;
			obj.add(new Option("",""));
			jQuery.ajax({
		        url: contextPath + "/accounting/selectShop",
		        type: 'get',
		        async:false,
		        success: function(data){
		           jQuery.each(data, function (index, e) {
		               obj.add(new Option(e.shopName,e.shopCode));
		           });
		           jQuery("#shopCode").trigger("chosen:updated");
		           jQuery("#shopCode").chosen({
		       	   disable_search_threshold: 10,
		       	   no_results_text: "この店舗が見つかりませんでした。!:",
		       	   width: "100%"
		       	   }); 
		        }
		    });
		}
		appendAlertDel('errorMassageIno');
	});

});
function searchOrder(){
	var winWidth = 0;
	if (window.innerWidth){
		winWidth = window.innerWidth;
	}
	$("#areaResult").width(winWidth - 290);

	  var columns = [
		  	{id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection", width: 40, resizable: false, selectable: false,sortable: false },
		  	{id: 'shop_name', name: '店舗名', field: 'shopName', formatter: mineFormatter, sortable: true},
		    {id: 'cash_id', name: '会計NO.', field: 'cashId', formatter: mineFormatter, sortable: true},
		    {id: 'product_orderd_date', name: '承り日', field: 'productOrderdDate', formatter: mineFormatter, sortable: true},
		    {id: 'order_amount', name: '点数', field: 'orderAmount', formatter: mineFormatter, cssClass: "cell-money", sortable: true},
		    {id: 'cash_except_tax_price', name: '商品金額', field: 'cashExceptTaxPrice', formatter: mineFormatter, cssClass: "cell-money", sortable: true},
		    {id: 'store_staff_nm', name: '営業担当者', field: 'storeStaffNm', formatter: mineFormatter, sortable: true}
	 ];
	  // (2) SlickGridの動作オプション
		var options = {
		  editable: true,
		  enableAddRow: false,
		  enableCellNavigation: true,
		  asyncEditorLoading: false,
		  forceFitColumns: true,
		  topPanelHeight: 25
		};
		var sumAccount = 0;
		var sumPoint = 0;
		var sumAmount = 0;
		appendAlertDel('errorMassageIno');
		  
		  var custCd = $("#custCd").val();
		  var storeStaffNm = $("#storeStaffNm").val();
		  var productOrderdDateFromStr = $("#productOrderdDateFromStr").val();
		  if(isNotEmpty(productOrderdDateFromStr)){
			  productOrderdDateFromStr = dateFormat(productOrderdDateFromStr);
			  jQuery("#productOrderdDateFromStr").datepicker("update", productOrderdDateFromStr);
			  }
		  var productOrderdDateToStr = $("#productOrderdDateToStr").val();
		  if(isNotEmpty(productOrderdDateToStr)){
			  productOrderdDateToStr = dateFormat(productOrderdDateToStr);
			  jQuery("#productOrderdDateToStr").datepicker("update", productOrderdDateToStr);
			  }
/* 		  var cashStatus = $("#cashStatus").val();
		  var storeBrandCode = $("#storeBrandCode").val();
		  if('${sessionContent.authority}' == "01"){
			  var shopCode = '${sessionContent.belongCode}';
			  jQuery("#shopCode_1").val(shopCode);
			  }
		  else{
			   var shopCode = $("#shopCode").val();
			} */
		  
		  var data = [];
		  if(productOrderdDateFromStr == null || productOrderdDateFromStr == ""){
				productOrderdDateFromStr = null;
			}
		  if(productOrderdDateToStr == null || productOrderdDateToStr == ""){
			  productOrderdDateToStr = null;
			}
		  if(!(productOrderdDateFromStr == "" || productOrderdDateFromStr == null || productOrderdDateFromStr == undefined)
				  && (productOrderdDateToStr == "" || productOrderdDateToStr == null || productOrderdDateToStr == undefined)){
			  productOrderdDateToStr = addmulMonth(productOrderdDateFromStr,12);
			  jQuery("#productOrderdDateToStr").datepicker("update", productOrderdDateToStr);
			  }
		  if((productOrderdDateFromStr == "" || productOrderdDateFromStr == null || productOrderdDateFromStr == undefined)
				  && !(productOrderdDateToStr == "" || productOrderdDateToStr == null || productOrderdDateToStr == undefined)){
			  productOrderdDateFromStr = addmulMonth(productOrderdDateToStr,-12);
			  jQuery("#productOrderdDateFromStr").datepicker("update", productOrderdDateFromStr);
			  }
		//日付変数に変換
		  var startCompare = Date.parse(new Date(productOrderdDateFromStr));
		  var endCompare = Date.parse(new Date(productOrderdDateToStr));
		  var time = (Math.abs(parseInt((endCompare - startCompare) / 1000 / 3600 / 24)));
		  if(!(productOrderdDateFromStr == "" || productOrderdDateFromStr == null || productOrderdDateFromStr == undefined) 
					&& !(productOrderdDateToStr == "" || productOrderdDateToStr == null || productOrderdDateToStr == undefined) 
					&& !(startCompare <= endCompare)){
				//承り日fromが承り日toより小さくない
				//msg068 = {0}は{1}以降の日付を入力してください。
				appendAlert('errorMassageIno', getMsgByTwoArgs('msg068', '承り日TO', '承り日FROM'));
				$("#areaResult").hide();
				// (4) SlickGridテーブルを作成
				dataView = new Slick.Data.DataView();
				grid = new Slick.Grid("#myGrid", dataView,columns, options);
				grid.setSelectionModel(new Slick.RowSelectionModel());
				grid.init();
				// initialize the model after all the events have been hooked up
				dataView.beginUpdate();
				dataView.setItems(data);
				dataView.endUpdate();
				
			}
		  else if(!(productOrderdDateFromStr == "" || productOrderdDateFromStr == null || productOrderdDateFromStr == undefined) 
					&& !(productOrderdDateToStr == "" || productOrderdDateToStr == null || productOrderdDateToStr == undefined) 
					&& time > 366){
				appendAlert('errorMassageIno', getMsgByOneArg('msg096'));
				$("#areaResult").hide();
				// (4) SlickGridテーブルを作成
				dataView = new Slick.Data.DataView();
				grid = new Slick.Grid("#myGrid", dataView,columns, options);
				grid.setSelectionModel(new Slick.RowSelectionModel());
				grid.init();
				// initialize the model after all the events have been hooked up
				dataView.beginUpdate();
				dataView.setItems(data);
				dataView.endUpdate();
			}
			else{
				$.ajax({url : contextPath + "/accounting/fuzzyQuery",
					type : 'get',
					dataType: "json",
					data: $('#conditionForm').serialize(),
					/* data:{"custCd":custCd,"storeStaffNm":storeStaffNm,"productOrderdDateFromStr":productOrderdDateFromStr,"productOrderdDateToStr":productOrderdDateToStr,
						  "cashStatus":cashStatus,"storeBrandCode":storeBrandCode,"shopCode":shopCode} */
			}).then(function(result) {
					if(Object.keys(result).length  == 0){
						$("#areaResult").hide();
						//alert("検索結果が0件でした。条件を変更して再検索してください。");
						appendAlert("errorMassageIno",getMsgByOneArg('msg031'));
					}else{
						$("#doKoShin").show();
						$("#areaResult").show();
					}
						for(var i = 0; i < result.length; i++) {
							var d = (data[i] = {});
							d["id"] = "id_" + i;
							d["num"] = i + 1;
							d["shopName"] =result[i].shopName;
							d["cashId"] = "<a href='javascript:void(0);' onclick='gotoAccount(\"" + result[i].cashId + "\")' >" + result[i].cashId + "</a>";
							d["productOrderdDate"] = result[i].productOrderdDate == null ? "" : ChangeTimeFormatYMD(result[i].productOrderdDate);
							d["orderAmount"] = result[i].orderAmount;
							//d["cashExceptTaxPrice"] = result[i].cashExceptTaxPrice;
							if (result[i].cashExceptTaxPrice == null){
						    	d["cashExceptTaxPrice"] = "￥0";
							}else{
								d["cashExceptTaxPrice"] = formatMoney(result[i].cashExceptTaxPrice, 0, "￥");
							}
							d["storeStaffNm"] = result[i].storeStaffNm;
							d["cashStatus"] = result[i].cashStatus;
							sumAccount = i + 1;
							sumPoint += result[i].orderAmount;
							sumAmount += result[i].cashExceptTaxPrice;
						}
						jQuery("#sumAccount").val(sumAccount);
						jQuery("#sumPoint").val(sumPoint);
						jQuery("#sumAmount").val(formatMoney(sumAmount, 0, ""));
						// (4) SlickGridテーブルを作成
						dataView = new Slick.Data.DataView();
						
						grid = new Slick.Grid("#myGrid", dataView, columns, options);
						grid.setSelectionModel(new Slick.RowSelectionModel());
						grid.onAddNewRow.subscribe(function (e, args) {
							var item = {"num": data.length+1, "id": "new_" + (Math.round(Math.random() * 10000)),"shopName": "", "cashId": "","productOrderdDate":"", "orderAmount": "","cashExceptTaxPrice":"", "storeStaffNm": ""};
						    $.extend(item, args.item);
						    dataView.addItem(item);
						});
						grid.init();
						
						grid.onCellChange.subscribe(function(e, args) {
							dataView.updateItem(args.item.id, args.item);
						});

						grid.onActiveCellChanged.subscribe(function(e, args) {
							if(cell.row < result.length){
		 						appendAlertDel('errorMassageIno');
								}
							else{
								$(".editor-text").removeAttr("disabled");
								grid.getCellEditor().focus();
								}
							$("#select_button").removeAttr("disabled");
							$("#clear_button").removeAttr("disabled");
							$("#update_button").removeAttr("disabled");
							appendAlertDel('errorMassageIno');
						});

						grid.onSort.subscribe(function(e, args) {
							sortdir = args.sortAsc ? 1 : -1;
							sortcol = args.sortCol.field;

							dataView.sort(comparer, args.sortAsc);
						});
						//backgroundを変更する
					     grid.onBeforeAppendCell.subscribe(function (e, args) {
					    	  //再確認要の会計をのみ
					    	 if(args.dataContext.cashStatus == "03" && args.cell != 0){
					        	  return "red";
						      }else{
					        	  return null;
						      }
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
//時間格式を変更
function ChangeTimeFormatYMD(nS)
{
	var timestamp4 = new Date(nS);
	//var aa = timestamp4.toLocaleDateString().replace(/\//g, "-") + " " + timestamp4.toTimeString().substr(0, 8)
  var aa = timestamp4.toLocaleDateString().replace(/\//g, "/")
  return aa;

}
</script>

