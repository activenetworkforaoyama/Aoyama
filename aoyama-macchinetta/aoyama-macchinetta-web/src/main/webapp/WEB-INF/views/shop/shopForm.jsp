<style>
.slick-cell.selected {
	background-color: #FBB;
}
.cell-del-type {
	text-align: center;
}
.red{ 
    background-color: #FA8072;
}
.gray{ 
    background-color: #A0A0A0;
} 
.yellow{ 
    background-color: #FFFFE0;
}  
.test_input{
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
    width:800px;
}
.alert-success {
	color: #155724;
	background-color: #d4edda;
	border-color: #c3e6cb;
	width:800px;
}

.btn_off {
	cursor:pointer;
	vertical-align: middle;
	background: #85786A;
	border: 1px solid #85786A;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	color: #fff;
	width: 142px;
	height: 35px;
	padding: 0;
	font-size: 16px;
	vertical-align: middle;
	font-weight: bold;
	position: relative;
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.3);
	border: 1px solid #E25A00;
	border: 1px solid #85786A;
}
.btn_blue {
	background: #007bff;
	border: 1px solid #007bff;
	margin-left: 62px;
}
.btn_red {
	background: #dc3545;
	border: 1px solid #dc3545;
}
</style>

<div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>店舗管理</h1>
                    </div>
                </div>
            </div>
</div>

<div class="content mt-3">
	<div class="alert alert-error" id="errorMessage" style="display:none"></div>
	<div class="alert alert-success" id="successMessage" style="display:none"></div>
	<div class="animated fadeIn">
	
		<div class="card" id="nav1_custom_div">
			<div class="card-body">
				<!-- 検索条件部分Start -->
					<div class="row">
						<!-- 左側項目 -->
						<div class="col col-lg-6">
							<div class="row form-group">
								<div class="col col-md-4"><label class=" form-control-label">店舗コード</label></div>
								<div class="col-12 col-md-8">
									<input type="text" name="shopCode" id="shopCode" class="input-sm form-control-sm form-control" maxlength = "4">
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-4"><label class=" form-control-label">店舗名</label></div>
								<div class="col-12 col-md-8">
									<input type="text" name="shopName" id="shopName" class="input-sm form-control-sm form-control">
								</div>
							</div><div class="row form-group">
								<div class="col col-md-4"><label class=" form-control-label">業態</label></div>
								<div class="col-12 col-md-8">
									<select id="storeBrandCode" class="form-control-sm form-control">
											<option value="">全て</option>
											<option value="01">AO(01)</option>
											<option value="03">TSC(03)</option>
											<option value="12">UL(12)</option>
											<option value="21">ULM(21)</option>
									</select>
								</div>
							</div>
						</div>
						<!-- 右側項目 -->
						<div class="col col-lg-6">
							<div class="row form-group">
								
							</div>
							<div class="row form-group">
								
							</div>
							<div class="row form-group">
								
							</div>
						</div>
					</div>
					<!-- 検索条件部分 End -->
					<div class="row"><div class="col">　</div></div>
					<!-- 制御ボタン部分 Start -->
					<div class="row">
					
						<!-- 左側項目 -->
						<div class="col col-lg-6">
							<div class="row form-group">
								<div class="col col-md-6">
	    							<button id="clear_button" type="button" class="btn btn-danger btn-block"><i class="fa fa-trash-o"></i>&nbsp;クリア</button>
								</div>
								<div class="col col-md-6">
									<button type="button" id="select_button" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i>&nbsp;検索</button>
								</div>
							</div>
						</div>
						<!-- 右側項目 -->
						<div class="col col-lg-6">
							<div class="row form-group">
								
							</div>
						</div>
					</div>
					<!-- 制御ボタン部分 End -->

			</div><!-- card body -->
		</div><!-- card -->
	</div><!-- .animated -->
	
</div><!-- .content -->
	
	<div id="shopListDiv" style="display:none;">
	
	<div class="content container" style="float: left">
		<div class="row">
			<div class="col-9">
				<div id="gridContainer">
					<!-- SlickGridテーブルの表示領域となる要素 -->
					<div id="myGrid" style="width: 100%;"></div>
				</div>
			</div>
			<div class="col-3">
			</div>
		</div>
	</div>
		
	<div class="content">
		<div class="card-body">
		<br>
		<div id="doKoShin">
			<div class="row">
						
				<!-- 左側項目 -->
				<div class="col col-lg-6">
					<div class="row form-group">
						<div class="col col-md-6">
   							<button id="cancel_button" type="button" class="btn btn-danger btn-block"><i class="fa fa-trash-o"></i>&nbsp;キャンセル</button>
						</div>
						<div class="col col-md-6">
							<button id="update_button" type="button" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i>&nbsp;更新</button>
						</div>
					</div>
				</div>
				<!-- 右側項目 -->
				<div class="col col-lg-6">
					<div class="row form-group">
						
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
		
	</div>	


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
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>

<script>
var dataView;
var grid;
var sortcol = "shop_code";
var sortdir = 1;
var contextPath = $("meta[name='contextPath']").attr("content");
//データ変更の行号
var changeRowNum = new Array();
//一意制約の行号
var errorRowNum = new Array();
//データ変更の行号：灰色
var changeRowNumGray = new Array();
var cRNum = 0;
var eRNum = 0;
var eRNumG = 0;
var updateSuccessFlag = 0;

//選択したセルの情報。「１」：行。「２」：列。
var activeCellChangedArr = [-1,-1];
//アクティブなセルのargsを保存します
var argsOuter;
//アクティブなセルの行を保存します
var rowOuter = 0;
//アクティブなセルの列を保存します
var cellOuter = 0;

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

//入力の店舗コードのチェック
function requiredShopCodeValidator(value) {
	var sendData = JSON.stringify(dataView.getItems());
	var obj = eval('('+ sendData +')');
	var checkMap = new Map();
	var activeRow =grid.getSelectedRows();
	for(var i = 0; i < obj.length; i++){
		checkMap.set((obj[i].shopCode),i);
	}
	var contains = checkMap.has(value);
	if(contains){
		appendAlertDel('errorMessage');
		appendAlertDel('successMessage');
		appendAlert('errorMessage', getMsg('msg060'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
		return {valid: false};
	}
	//半角数字チェック
	else if (isNumeric(value)) {
		appendAlertDel('errorMessage');
		appendAlertDel('successMessage');
		appendAlert('errorMessage', getMsgByTwoArgs('msg012', '店舗コード', '半角数字'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
	    return {valid: false};
	  }
	
	//4桁数字チェック
	else if (value == "" || value.length != 4) {
		appendAlertDel('errorMessage');
		appendAlertDel('successMessage');
		appendAlert('errorMessage', getMsgByTwoArgs('msg011', '店舗コード', '4'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
	    return {valid: false};
	}
	else {
	  return {valid: true};
	}

}

//入力の店舗名のチェック
function requiredShopNameValidator(value) {
	if (value == "" || value.length > 20 || charactersCheck(value)) {
		appendAlertDel('errorMessage');
		appendAlertDel('successMessage');
		appendAlert('errorMessage', getMsgByTwoArgs('msg097', '店舗名', '20'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
		return {valid: false};
	}
	else {
		return {valid: true};
	}
}

//入力の業態のチェック
function requiredStoreBrandCodeValidator(value) {
	//半角数字チェック
	if (isNumeric(value)) {
		appendAlertDel('errorMessage');
		appendAlertDel('successMessage');
		appendAlert('errorMessage', getMsgByTwoArgs('msg012', '業態', '半角数字'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
	    return {valid: false};
	  }
	
	//2桁数字チェック
	else if (value == "" || value.length != 2) {
		appendAlertDel('errorMessage');
		appendAlertDel('successMessage');
		appendAlert('errorMessage', getMsgByTwoArgs('msg011', '業態', '2'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
	    return {valid: false};
	}//01,03,12,21 チェック
	else if (value != "01" && value != "03" && value != "12" && value != "21") {
		appendAlertDel('errorMessage');
		appendAlertDel('successMessage');
		appendAlert('errorMessage', getMsgByTwoArgs('msg083', value, '業態'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
	    return {valid: false};
	}
	else {
	  return {valid: true};
	}
}

function comparer(a, b) {
	  var x = a[sortcol], y = b[sortcol];
	  return (x == y ? 0 : (x > y ? 1 : -1));
}

function mineFormatter ( row, cell, value, columnDef, dataContext ) {
    return value;
}

function requiredFieldValidator(value) {
	  if (value == "" || !value.length) {
	    return {valid: false, msg: "This is a required field"};
	  }
	  else {
	    return {valid: true, msg: null};
	  }
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
	//データ変更の場合：灰色
	if (changeRowNumGray.includes(dataContext.num)) {
		rtn.addClasses = "gray";
	}
	return rtn;
}

$(document).ready(function() {

  $("#shopListDiv").hide();	
	//(1) SlickGridのカラム定義
	//6つのカラムのそれぞれにつき ID・表示名・マッピングするデータ を定義している。
	var columns = [
	 {id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection", width: 40, resizable: false, selectable: false},
	 {id: 'shop_code', name: '店舗コード', field: 'shopCode', maxWidth: 120,formatter: colorFormatter, editor: Slick.Editors.DisabledText, sortable: true,validator: requiredShopCodeValidator},
	 {id: 'shop_name', name: '店舗名', field: 'shopName', maxWidth: 440, formatter: colorFormatter, editor: Slick.Editors.Text, sortable: true,validator: requiredShopNameValidator},
	 {id: 'store_brand_code', name: '業態', field: 'storeBrandCode', maxWidth: 120, formatter: colorFormatter, editor: Slick.Editors.Text, sortable: true,validator: requiredStoreBrandCodeValidator},
	 {id: "del_type", name: "削除", maxWidth: 80, cssClass: "cell-del-type", field: "delType", formatter: Slick.Formatters.Checkbox, editor: Slick.Editors.Checkbox, cannotTriggerInsert: true}
	];
	
	//(2) SlickGridの動作オプション
	var options = {
	editable: true,
	enableAddRow: true,
	enableCellNavigation: true,
	asyncEditorLoading: false,
	forceFitColumns: true,
	topPanelHeight: 25
	};
    //検索
	$("#select_button").click(function(){
		　  appendAlertDel('errorMessage');
		  appendAlertDel('successMessage');

		  if(activeCellChangedArr[0] != -1 && activeCellChangedArr[1] != -1){
		  	  //その他のセルをアクティブにします
		  	  argsOuter.grid.setActiveCell(0, 0);
		  }
		  
		  //配列をクリア
		  changeRowNum.length = 0;
		  cRNum = 0;
		  errorRowNum.length = 0;
		  eRNum = 0;
		  changeRowNumGray.length = 0;
		  cRNumG = 0;
		  $("#shopListDiv").show();
		  var shopCode = $("#shopCode").val();
		  var shopName = $("#shopName").val();
		  var storeBrandCode = $("#storeBrandCode").val();
		  var data = [];
			$.ajax({url : contextPath + "/shop/fuzzyQuery",
					type : 'get',
					data:{"shopCode": shopCode, "shopName":shopName, "storeBrandCode": storeBrandCode}
			}).then(function(result) {
					appendAlertDel('errorMessage');
					appendAlertDel('successMessage');
					//検索結果が0件の場合、
					if(Object.keys(result).length  == 0){
						//更新、キャンセルはできません
						$("#doKoShin").hide();
						appendAlert("errorMessage",getMsgByOneArg('msg031'));;
					}else{
						$("#doKoShin").show();
					}
					for(var i = 0; i < result.length; i++) {
						var d = (data[i] = {});
						d["id"] = "id_" + i;
						d["num"] = i + 1;
						d["shopCode"] = result[i].shopCode;
						d["shopName"] = result[i].shopName;
						d["storeBrandCode"] = result[i].storeBrandCode;
						d["delType"] = false;
						d["optionType"] = "1";
						d["isNewData"] = "0";
						d["displayIdentify"] = true;
					}

					// (4) SlickGridテーブルを作成
					dataView = new Slick.Data.DataView();
					
					grid = new Slick.Grid("#myGrid", dataView, columns, options);
					grid.setSelectionModel(new Slick.RowSelectionModel());
					grid.onAddNewRow.subscribe(function (e, args) {
						var item = {"num": data.length+1, "id": "new_" + (Math.round(Math.random() * 10000)), "shopCode": "","shopName":"","storeBrandCode":"", "delType": false, "optionType": "2", "isNewData": "1","displayIdentify":false};
					    $.extend(item, args.item);
					    dataView.addItem(item);
					});
					grid.init();

					//var pager = new Slick.Controls.Pager(dataView, grid, $("#pager"));
					
					grid.onCellChange.subscribe(function(e, args) {
						if(args.item.delType == true){
							//削除の場合、行号を記録する
							cRNumG = args.item.num;
							changeRowNumGray[cRNumG-1] = args.item.num;
						}else{
							//削除しない、行号を記録する
							cRNumG = args.item.num;
							changeRowNumGray[cRNumG-1] = null;
							//データ変更の場合、行号を記録する
							changeRowNum[cRNum] = args.item.num;
							cRNum++;
						}
						dataView.updateItem(args.item.id, args.item);
					});
                    
					grid.onActiveCellChanged.subscribe(function(e, args) {

						//アクティブなセルのargsを保存します
						argsOuter = args;
						//選択したセルの行と列を取得します
						activeCellChangedArr[0] = args.grid.getActiveCell().row;
						activeCellChangedArr[1] = args.grid.getActiveCell().cell;

						$("#doKoShin").show();
						var item = args.grid.getDataItem(args.row);
						if (item != null && item.isNewData == 0){
							if(item.isNewData == 0){
		 						appendAlertDel('errorMessage');
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
 						appendAlertDel('errorMessage');
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
			});//$.ajax
		});//selectButton

	$("#clear_button").click(function(){
		$("#shopCode").val("");
		$("#shopName").val("");
		$("#storeBrandCode").val("");
		appendAlertDel('errorMessage');
		appendAlertDel('successMessage');
	});

	// 店舗を更新ボタン
	$("#update_button").click(function(){
		// 確認メッセージ
		swal({
			  title: "確認",
			  text: getMsgByOneArg('msg025','店舗情報'),
			  icon: "info",
			  buttons: true,
			  dangerMode: true,
			  closeOnEsc: false,
			})
			.then((isConfirm) => {
			  if (isConfirm) {
				  	// 更新します
				  	appendAlertDel('errorMessage');
					appendAlertDel('successMessage');
				  	
					grid.gotoCell(1, 1, true);
					changeRowNum.length = 0;
					cRNum = 0;
					errorRowNum.length = 0;
					eRNum = 0;
					var sendData = JSON.stringify(dataView.getItems());
					var obj = eval("("+ sendData +")");

					//表示されたデータをすべてループします
					for(var i = 0; i < obj.length; i++ ){
						if(obj[i].displayIdentify != true && obj[i].delType == true){
							//このデータが検索で表示されていない場合、削除をチェックします
							//このデータをセットから削除します。セット長-1
							obj.splice(i,1);
							i--;
						}
					}
					//変更可能なデータをＪＳＯＮデータに変換します
					sendData = JSON.stringify(obj);
					
					/*var obj = eval("("+ sendData +")");
					var checkStatus = 0;
					for(var i =0 ; i < obj.length; i++ ){
						if(!obj[i].shopCode){
							checkStatus += 1;
							appendAlert('errorMessage', getMsgByOneArg('msg009', '店舗コード'));
							grid.gotoCell(i, 1, true);
							var activeRow = grid.getSelectedRows();
							}
						}*/
					if($("#errorMessage").html().length == 0){ 
						var data = [];	
						$.ajax({
						    type:"post",
						    url: contextPath + "/shop/update",
						    data:sendData,
						    dataType:"json",
						    contentType:"application/json",
						    success:function(result){
								updateSuccessFlag = 0;
								for(var i = 0; i < result.length; i++) {
									if (result[i].updateFlag == 1){
										//更新失敗(その他)
										updateSuccessFlag = 1;
									}
									if (result[i].updateFlag == 2){
										//一意制約の場合、行号を記録する
										errorRowNum[eRNum] = result[i].num;
										eRNum++;
										//更新失敗(一意制約) 
										updateSuccessFlag = 2;
									}
									if (result[i].updateFlag == 3){
										//nullの場合、行号を記録する
										errorRowNum[eRNum] = result[i].num;
										eRNum++;
										//更新失敗(一意制約) 
										updateSuccessFlag = 3;
									}
								}
								//更新成功
							    if(updateSuccessFlag == 0){
							    	appendAlert("successMessage",getMsgByOneArg('msg044', '店舗情報'));
								}
								//更新失敗(その他)
							    if(updateSuccessFlag == 1){
							    	appendAlert("errorMessage",getMsg('msg064'));
								}
								//更新失敗(一意制約) 
							    if(updateSuccessFlag == 2){
							    	appendAlert("errorMessage",getMsg('msg060'));
								}
								//更新失敗(null) 
							    if(updateSuccessFlag == 3){
							    	appendAlert("errorMessage",getMsgByThreeArgs('msg081', '店舗コード', '店舗名', '業態'));
								}

							    for(var i = 0; i < result.length; i++) {
									var d = (data[i] = {});
									d["id"] = "id_" + i;
									d["num"] = result[i].num;
									d["shopCode"] = result[i].shopCode;
									d["shopName"] = result[i].shopName;
									d["storeBrandCode"] = result[i].storeBrandCode;
									d["delType"] = result[i].delType;
									if (updateSuccessFlag == 0){
										//更新成功
								        d["optionType"] = 1;
									}else{
										//更新失敗
										d["optionType"] = result[i].optionType;
									}
									d["isNewData"] = result[i].isNewData;
									d["displayIdentify"] = result[i].displayIdentify;
								}

								// (4) SlickGridテーブルを作成
								dataView = new Slick.Data.DataView();
								
								grid = new Slick.Grid("#myGrid", dataView, columns, options);
								grid.setSelectionModel(new Slick.RowSelectionModel());
								grid.onAddNewRow.subscribe(function (e, args) {
									var item = {"num": data.length+1, "id": "new_" + (Math.round(Math.random() * 10000)), "shopCode": "","shopName":"","storeBrandCode":"", "delType": false, "optionType": "2", "isNewData": "1","displayIdentify":false};
								    $.extend(item, args.item);
								    dataView.addItem(item);
								});
								grid.init();

								//var pager = new Slick.Controls.Pager(dataView, grid, $("#pager"));
								
								grid.onCellChange.subscribe(function(e, args) {
									if(args.item.delType == true){
										//削除の場合、行号を記録する
										cRNumG = args.item.num;
										changeRowNumGray[cRNumG-1] = args.item.num;
									}else{
										//削除しない、行号を記録する
										cRNumG = args.item.num;
										changeRowNumGray[cRNumG-1] = null;
										//データ変更の場合、行号を記録する
										changeRowNum[cRNum] = args.item.num;
										cRNum++;
									}
									dataView.updateItem(args.item.id, args.item);
								});

								grid.onActiveCellChanged.subscribe(function(e, args) {
									$("#doKoShin").show();
									var item = args.grid.getDataItem(args.row);
									if (item != null && item.isNewData == 0){
										if(item.isNewData == 0){
					 						appendAlertDel('errorMessage');
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
									appendAlertDel('errorMessage');
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
						    }
						}); 
						}
			  }
			});
	});
	
	// キャンセルボタン
	$("#cancel_button").click(function(){
		// 確認メッセージ
		swal({
			  title: "確認",
			  text: getMsgByOneArg('msg017','編集内容'),
			  icon: "info",
			  buttons: true,
			  dangerMode: true,
			  closeOnEsc: false,
			})
			.then((isConfirm) => {
			  if (isConfirm) {
				  // 検索します
				appendAlertDel('errorMessage');
				appendAlertDel('successMessage');
				$("#select_button").click();
			  }
			});


		
	});
});

</script>
