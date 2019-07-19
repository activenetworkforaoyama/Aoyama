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

.yellow{ 
    background-color: #FFFFE0;
} 

.gray{
	background-color: #A0A0A0;
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
				<h1>メーカー管理</h1>
			</div>
		</div>
	</div>
</div>

<div class="content mt-3">
<div class="alert alert-error" id="errorMassageIno" style="display:none"></div>
<div class="alert alert-success" id="successMessage" style="display:none"></div>
<div class="animated fadeIn">
	
		<div class="card" id="nav1_custom_div">
			<div class="card-body">
				<!-- 検索条件部分Start -->
					<div class="row">
						<!-- 左側項目 -->
						<div class="col col-lg-6">
							<div class="row form-group">
								<div class="col col-md-5"><label class=" form-control-label">メーカーコード</label></div>
								<div class="col-12 col-md-7">
									<input type="text" name="makerCode" id="makerCode" class="input-sm form-control-sm form-control" maxlength = "6">
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-5"><label class=" form-control-label">メーカー名</label></div>
								<div class="col-12 col-md-7">
									<input type="text" name="makerName" id="makerName" class="input-sm form-control-sm form-control" maxlength = "20">
								</div>
							</div>
						</div>
						<!-- 右側項目 -->
						<div class="col col-lg-6">
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
	</div>
	
	<div id="makerListDiv" style="display:none;">
		<!-- SlickGridテーブルの表示領域となる要素 -->
		<div class="content container" style="float: left">
			<div class="row">
				<div class="col-9">
					<div id="gridContainer">
						<!-- SlickGridテーブルの表示領域となる要素 -->
						<div id="myGrid" style="width: 100%"></div>
					</div>
				</div>
				<div class="col-3">
				
				</div>
			</div>
		</div>
	<div class="content">
		<div class="card-body">
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
<script	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/firebugx.js"></script>
<script	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-1.11.2.min.js"></script>
<script	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-ui-1.11.3.min.js"></script>
<script	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery.event.drag-2.3.0.js"></script>

<!-- SlickGridモジュールの読み込み -->
<script	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.core.js"></script>
<script	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.formatters.js"></script>
<script	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.editors.js"></script>
<script	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/plugins/slick.rowdetailview.js"></script>
<script	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/plugins/slick.rowselectionmodel.js"></script>
<script	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.grid.js"></script>
<script	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/slick.dataview.js"></script>
<script	src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/controls/slick.pager.js"></script>
<script	src="${pageContext.request.contextPath}/resources/app/js/bootstrap.min.js"></script>
<script	src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>

<script>
var dataView;
var grid;
var sortcol = "maker_code";
var sortdir = 1;
var contextPath = $("meta[name='contextPath']").attr("content");
//データ変更の行号
var changeRowNum = new Array();
//一意制約の行号
var errorRowNum = new Array();
var cRNum = 0;
var eRNum = 0;
//データ削除の行号
var deleteRowNum = new Array();
var dRNum = 0;
var updateSuccessFlag = 0;

//選択したセルの情報。「１」：行。「２」：列。
var activeCellChangedArr = [-1,-1];
//アクティブなセルのargsを保存します
var argsOuter;

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

//入力のメーカーコードの判定
function requiredMakerCodeValidator(value) {
	var sendData = JSON.stringify(dataView.getItems());
	var obj = eval('('+ sendData +')');
	var checkMap = new Map();
	var activeRow =grid.getSelectedRows();
	for(var i = 0; i < obj.length; i++){
		checkMap.set((obj[i].makerCode),i);
	}
	var contains = checkMap.has(value);
	if(contains){
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');
		appendAlert('errorMassageIno', getMsgByOneArg('msg104', 'メーカーコード'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
		return {valid: false};
		}
	//nullチェック
	if(value == ""){
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');
		appendAlert('errorMassageIno', getMsgByOneArg('msg001', 'メーカーコード'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
	    return {valid: false};
		}
	//半角英数字チェック
	else if (isAlphabetNumeric(value)) {
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');
		appendAlert('errorMassageIno', getMsgByTwoArgs('msg012', 'メーカーコード', '半角英数字'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
	    return {valid: false};
	  }
	//6桁数字チェック
	else if (value.length != 6 ) {
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');
		appendAlert('errorMassageIno',getMsgByTwoArgs('msg011', 'メーカーコード','6'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
	    return {valid: false};
	  }
	else {
	    return {valid: true};
	  }
	}

//入力のメーカー名の判定
function requiredMakerNameValidator(value) {
	if (value == "" || value.length > 20 || charactersCheck(value)) {
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');
		appendAlert('errorMassageIno', getMsgByTwoArgs('msg097', 'メーカー名','20'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
		   return {valid: false};
	}
	else {
		return {valid: true};		
	}
}

//入力のメーカーIDの判定
function requiredMakerIdValidator(value) {

	//nullチェック
	if(value == ""){
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');
		appendAlert('errorMassageIno', getMsgByOneArg('msg001', 'メーカーID'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
	    return {valid: false};
		}
	//半角数字チェック
	if (isNumeric(value)) {
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');
		appendAlert('errorMassageIno', getMsgByTwoArgs('msg012', 'メーカーID', '半角数字'));
		$("#select_button").attr("disabled",true);
		$("#clear_button").attr("disabled",true);
		$("#update_button").attr("disabled",true);
	    return {valid: false};
	  }
	  //3桁数字チェック
	 else if (value.length != 3 ) {
		  appendAlert('errorMassageIno', getMsgByTwoArgs('msg011', 'メーカーID','3'));
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

//色の変更
function colorFormatter(row, cell, value, columnDef, dataContext) {
	var rtn = { text: value, removeClasses: 'red yellow gray' };
	//一意制約の場合
	if (errorRowNum.includes(dataContext.num)) {
		    rtn.addClasses = "red";
	}
	//データ変更の場合
	if (changeRowNum.includes(dataContext.num)) {
	    rtn.addClasses = "yellow";
    }
	if(deleteRowNum.includes(dataContext.num)){
    	rtn.addClasses = "gray";
        }
	return rtn;
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
	
  $("#makerListDiv").hide();	
  // (1) SlickGridのカラム定義
  //     6つのカラムのそれぞれにつき ID・表示名・マッピングするデータ を定義している。
  var columns = [
	  	{id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection", width: 40, resizable: false, selectable: false,sortable: false},
	    {id: 'maker_code', name: 'メーカーコード', field: 'makerCode', minWidth: 20, maxWidth:150, formatter: colorFormatter, editor: Slick.Editors.DisabledText, sortable: true,validator: requiredMakerCodeValidator},
	    {id: 'maker_name', name: 'メーカー名', field: 'makerName', formatter: colorFormatter,  editor: Slick.Editors.Text, sortable: true,validator: requiredMakerNameValidator},
	    {id: 'maker_id', name: 'メーカーID', field: 'makerId',minWidth: 20, maxWidth: 150,formatter: colorFormatter,  editor: Slick.Editors.Text, sortable: true,validator: requiredMakerIdValidator},
		{id: "del_type", name: "削除", width: 80, minWidth: 20, maxWidth: 80, cssClass: "cell-del-type", field: "delType", formatter: Slick.Formatters.Checkbox, editor: Slick.Editors.Checkbox, cannotTriggerInsert: true, sortable: false}
 ];
  // (2) SlickGridの動作オプション
	var options = {
	  editable: true,
	  enableAddRow: true,
	  enableCellNavigation: true,
	  asyncEditorLoading: false,
	  forceFitColumns: true,
	  topPanelHeight: 25
	};

	$("#select_button").click(function(){
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');

		if(activeCellChangedArr[0] != -1 && activeCellChangedArr[1] != -1){
		  	  //その他のセルをアクティブにします
		  	  argsOuter.grid.setActiveCell(0, 0);
		  }
		  
		  changeRowNum.length = 0;
		  cRNum = 0;
		  errorRowNum.length = 0;
		  eRNum = 0;
		  deleteRowNum.length = 0;
		  dRNum = 0;
		  var makerCode = $("#makerCode").val();
		  var makerName = $("#makerName").val();
		  var data = [];
			$.ajax({url : contextPath + "/maker/fuzzyQuery",
					type : 'get',
					data:{"makerCode":makerCode,"makerName":makerName}
			}).then(function(result) {
					appendAlertDel('errorMassageIno');
					appendAlertDel('successMessage');
					if(Object.keys(result).length  == 0){
						$("#doKoShin").hide();
						$("#makerListDiv").hide();
						appendAlert("errorMassageIno",getMsgByOneArg('msg031'));
					}else{
						$("#doKoShin").show();
						$("#makerListDiv").show();
					}
						for(var i = 0; i < result.length; i++) {
							var d = (data[i] = {});
							d["id"] = "id_" + i;
							d["num"] = i + 1;
							d["makerCode"] = result[i].makerCode;
							d["makerName"] = result[i].makerName;
							d["makerId"] = result[i].makerId;
							d["version"] = result[i].version;
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
							var item = {"num": data.length+1, "id": "new_" + (Math.round(Math.random() * 10000)), "makerCode": "","makerName":"","makerId":"","version":"1", "delType": false, "optionType": "2", "isNewData": "1","displayIdentify":false};
						    $.extend(item, args.item);
						    dataView.addItem(item);
						});
						grid.init();
						
						grid.onCellChange.subscribe(function(e, args) {
							if(args.item.delType){
								//データ削除の場合、行号を記録する
								deleteRowNum[dRNum] = args.item.num;
								dRNum++;
								}
							else{
								deleteRowNum.length = 0;
								//データ変更の場合、行号を記録する
								changeRowNum[cRNum] = args.item.num;
								cRNum++;
								}
							dataView.updateItem(args.item.id, args.item);
						});

						grid.onSort.subscribe(function(e, args) {
							sortdir = args.sortAsc ? 1 : -1;
							sortcol = args.sortCol.field;

							dataView.sort(comparer, args.sortAsc);
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
		})
	$("#update_button").click(function(){
		// 確認メッセージ
		swal({
			  text: getMsgByOneArg('msg025', 'メーカー情報'),
			  icon: "info",
			  buttons: ["キャンセル", true],
			  dangerMode: true,
			  closeOnEsc: false,
			}).then((isConfirm) => {
			  if (isConfirm) {
					appendAlertDel('errorMassageIno');
					appendAlertDel('successMessage');
					
					grid.gotoCell(0, 0,true);
					changeRowNum.length = 0;
					cRNum = 0;
					errorRowNum.length = 0;
					eRNum = 0;
					deleteRowNum.length = 0;
					dRNum = 0;
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
					
					/* var obj = JSON.parse(sendData);
					var checkStatus = 0;
					for(var i = 0; i <obj.length; i ++){
						if(!obj[i].makerCode){
							checkStatus += 1;
							appendAlert('errorMassageIno', getMsgByOneArg('msg009', 'メーカーコード'));
							}
						} */
					if($("#errorMassageIno").html().length == 0){
						var data = [];	
						$.ajax({
						    type:"post",
						    url: contextPath + "/maker/update",
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
										//更新失敗(null) 
										updateSuccessFlag = 3;
									}
									if (result[i].updateFlag == 4){
										//nullの場合、行号を記録する
										errorRowNum[eRNum] = result[i].num;
										eRNum++;
										//更新失敗(null) 
										updateSuccessFlag = 4;
									}
									if (result[i].updateFlag == 5){
										//nullの場合、行号を記録する
										errorRowNum[eRNum] = result[i].num;
										eRNum++;
										//更新失敗(null) 
										updateSuccessFlag = 5;
									}
									if (result[i].updateFlag == 6){
										//nullの場合、行号を記録する
										errorRowNum[eRNum] = result[i].num;
										eRNum++;
										//更新失敗(バージョン不正) 
										updateSuccessFlag = 6;
									}
								}
						    	//更新成功
							    if(updateSuccessFlag == 0){
							    	appendAlert("successMessage",getMsgByOneArg('msg044', 'メーカー情報'));
								}
								//更新失敗(その他)
							    if(updateSuccessFlag == 1){
							    	appendAlert("errorMassageIno",getMsg('msg106'));
								}
								//更新失敗(一意制約) 
							    if(updateSuccessFlag == 2){
							    	appendAlert("errorMassageIno",getMsg('msg060'));
								}
								//更新失敗(null) 
							    if(updateSuccessFlag == 3){
							    	appendAlert("errorMassageIno",getMsgByOneArg('msg001','メーカーコード'));
								}
							 	//更新失敗(null) 
							    if(updateSuccessFlag == 4){
							    	appendAlert("errorMassageIno",getMsgByTwoArgs('msg097', 'メーカー名','20'));
								}
							  	//更新失敗(null) 
							    if(updateSuccessFlag == 5){
							    	appendAlert("errorMassageIno",getMsgByOneArg('msg001','メーカーID'));
								}
							  //更新失敗(バージョン不正) 
							    if(updateSuccessFlag == 6){
							    	appendAlert("errorMassageIno",getMsg('msg106'));
								}

							    for(var i = 0; i < result.length; i++) {
									var d = (data[i] = {});
									d["id"] = "id_" + i;
									d["num"] = result[i].num;
									d["makerCode"] = result[i].makerCode;
									d["makerName"] = result[i].makerName;
									d["makerId"] = result[i].makerId;
									d["version"] = result[i].version;
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
									var item = {"num": data.length+1, "id": "new_" + (Math.round(Math.random() * 10000)), "makerCode": "","makerName":"","makerId":"","version":"1", "delType": false, "optionType": "2", "isNewData": "1","displayIdentify":false};
								    $.extend(item, args.item);
								    dataView.addItem(item);
								});
								grid.init();

								grid.onCellChange.subscribe(function(e, args) {
									if(args.item.delType){
										//データ削除の場合、行号を記録する
										dRNum = args.item.num;
										deleteRowNum[dRNum - 1] = args.item.num;
										}
									else{
										//データ変更の場合、行号を記録する
										dRNum = args.item.num;
										deleteRowNum[dRNum-1] = null;
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
						    }
						}); 
					}
				  }
			});
	});
	$("#clear_button").click(function(){
		appendAlertDel('errorMassageIno');
		appendAlertDel('successMessage');
		$("#makerCode").val("");
		$("#makerName").val("");
	})

	// キャンセルボタン
	$("#cancel_button").click(function(){
		// 確認メッセージ
		swal({
			  text: getMsgByOneArg('msg017','編集内容'),
			  icon: "info",
			  buttons: ["キャンセル", true],
			  dangerMode: true,
			  closeOnEsc: false,
			})
			.then((isConfirm) => {
			  if (isConfirm) {
				  // 検索します
				appendAlertDel('errorMassageIno');
				appendAlertDel('successMessage');
				$("#select_button").click();
			  }
			});
	});
	
});

</script>
