<style>
.red{ 
    background-color: #FA8072;
}
.yellow{ 
    background-color: #FFFFE0;
} 
.gray{ 
    background-color: #A0A0A0;
} 
.alert-error {
    background: #fff1f0;
    color: #d85030;
    border-color: rgba(216, 80, 48, 0.3);
    width:800px;
}
.alert-success {
    background: #d4edda;
    color: #155724;
    border-color: #c3e6cb;
    width:800px;
}
.slick-cell.selected {
	background-color: #FBB;
}
.cell-del-type {
	text-align: center;
}
.cell-deliveryOn-type {
	BACKGROUND-COLOR: transparent;
	text-align: center;
}
</style>

<div class="breadcrumbs">
    <div class="col-sm-4">
        <div class="page-header float-left">
            <div class="page-title">
                <h1>納期管理</h1>
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
			
				<div class="row">
					<div class="col col-lg-6">
						<div class="row form-group">
							<div class="col col-md-4">
								<label class=" form-control-label">承り日</label>
							</div>
							<div class="col-12 col-md-8">
								<input type="date" name="orderOnStartDateInput" id="orderOnStartDateInput" max= "9999-12-31" 
									class="input-sm form-control-sm form-control" style="display:inline-block;width:200px;">
								～<input type="date" name="orderOnEndDateInput" id="orderOnEndDateInput" max= "9999-12-31" 
									class="input-sm form-control-sm form-control" style="display:inline-block;width:200px;">
							</div>
						</div>
						<div class="row form-group">
							<div class="col col-md-4">
								<label class=" form-control-label">店着納期区分</label>
							</div>
							<div class="col-12 col-md-8">
								<select name="shopDeliveryClassInput" id="shopDeliveryClassInput" 
									class="input-sm form-control-sm form-control" style="display:inline-block;width:200px;">
									<option value="全区分">全区分</option>
									<c:forEach items="${generalCodeList }" var="i" varStatus="generalCode">
										<c:set var="current" value="${generalCode.current }"/>
										<option value="${current.codeValue }">${current.codeName }</option>
									</c:forEach>
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
					</div>
				</div>
				
				<div class="row"><div class="col">　</div></div>
				<div class="row">
					<div class="col col-lg-6">
						<div class="row form-group">
							<div class="col col-md-4">
								<button type="button" id="clearButton" class="btn btn-danger btn-block">
									<i class="fa fa-trash-o"></i>&nbsp;クリア</button>
							</div>
							<div class="col col-md-4">
								<button type="button" id="selectButton" class="btn btn-primary btn-block">
									<i class="fa fa-check-circle"></i>&nbsp;検索</button>
							</div>
							<div class="col col-md-4">
								<button type="button" id="addButton" class="btn btn-primary btn-block">
									<i class="fa fa-check-circle"></i>&nbsp;新規登録</button>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
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
				<div id="doKoShin">
					<div class="row">
						<!-- 左側項目 -->
						<div class="col col-lg-6">
							<div class="row form-group">
								<div class="col col-md-6">
									<button id="cancelButton" type="button" class="btn btn-danger btn-block">
										<i class="fa fa-trash-o"></i> キャンセル</button>
								</div>
								<div class="col col-md-6">
									<button id="updateButton" type="button" class="btn btn-primary btn-block">
										<i class="fa fa-check-circle"></i> 更新</button>
								</div>
							</div>
						</div>
						<!-- 右側項目 -->
						<div class="col col-lg-6">
							<div class="row form-group"></div>
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
<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/controls/slick.columnpicker.js"></script>

<script src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script type="text/javascript">
	var dataView;
	var grid;
	var sortcol = "factoryCode";
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
	var updateFlag = true;

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

	function comparer(a, b) {
	  var x = a[sortcol], y = b[sortcol];
	  return (x == y ? 0 : (x > y ? 1 : -1));
	}
	
	function mineFormatter ( row, cell, value, columnDef, dataContext ) {
	    return value;
	}

	//店着日を検査する
	function requiredShopDeliveryOnValidator(value){
		var delTypeItem = argsOuter.grid.getDataItem(argsOuter.row).delType;
		if(delTypeItem == true){
			return {valid: true};
		}
		if (value == "" || value == null || value == undefined || !(/\d{4}\/\d{2}\/\d{2}$/.test(value))) {
			//msg012 = {0}は{1}で入力してください。
			appendAlert("errorMessage", getMsgByTwoArgs('msg012', '店着日', '半角数字をYYYY/MM/DDフォーマット'));
			$("#clearButton").attr("disabled",true);
			$("#selectButton").attr("disabled",true);
			$("#addButton").attr("disabled",true);
			$("#updateButton").attr("disabled",true);
		    return {valid: false};
		}else {
			//文字列を分割
			var valueArr = value.split("/");
			//ページで入力したデータを使って日付オブジェクトを設定します
			var dateD = new Date(valueArr[0], parseInt(valueArr[1])-1, valueArr[2]);
			//日付オブジェクトの値と入力の元の値が等しいかどうかを判断し、等しい場合は日付が有効です
	        var dateInputStr = (dateD.getFullYear() == valueArr[0] 
	        	&& (dateD.getMonth()+1) == valueArr[1] && dateD.getDate() == valueArr[2]);
			if(dateInputStr == false){
				//msg012 = {0}は{1}で入力してください。
				appendAlert("errorMessage", getMsgByTwoArgs('msg012', '店着日', '半角数字をYYYY/MM/DDフォーマット'));
				$("#clearButton").attr("disabled",true);
				$("#selectButton").attr("disabled",true);
				$("#addButton").attr("disabled",true);
				$("#updateButton").attr("disabled",true);
			    return {valid: false};
			}else {
				return {valid: true};
			}
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

	$(function () {
	    var headerName = $("meta[name='_csrf_header']").attr("content");
	    var tokenValue = $("meta[name='_csrf']").attr("content");
	    $(document).ajaxSend(function(e, xhr, options) {
	        xhr.setRequestHeader(headerName, tokenValue);
	    });
	});

	$(document).ready(function() {
	
		$("#shopListDiv").hide();	
		// (1) SlickGridのカラム定義
		var columns = [
			{id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection", width: 40, resizable: false, selectable: false },
	   		{id: 'shop_delivery_class', name: '店着納期区分', field: 'shopDeliveryClass', formatter: colorFormatter, editor: Slick.Editors.DisabledText, sortable: true },
		   	{id: 'order_on_start_date', name: '承り日FROM', field: 'orderOnStartDateStr', formatter: colorFormatter, editor: Slick.Editors.DisabledText, sortable: true },
		   	{id: 'order_on_end_date', name: '承り日TO', field: 'orderOnEndDateStr', formatter: colorFormatter, editor: Slick.Editors.DisabledText, sortable: true },
		   	{id: 'shop_delivery_on', name: '店着日', field: 'shopDeliveryOnStr', formatter: colorFormatter, editor: Slick.Editors.Text, sortable: true, validator: requiredShopDeliveryOnValidator},
		   	{id: "del_type", name: "削除", width: 50, minWidth: 50, maxWidth: 60, cssClass: "cell-del-type", field: "delType", formatter: Slick.Formatters.Checkbox, editor: Slick.Editors.Checkbox, cannotTriggerInsert: true }
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

		$("#clearButton").click(function(){
			$("#orderOnStartDateInput").val("");
			$("#orderOnEndDateInput").val("");
			$("#shopDeliveryClassInput").val("全区分");
			appendAlertDel('errorMessage');
			appendAlertDel('successMessage');
		})

		// キャンセルボタン
		jQuery("#cancelButton").click(function(){
			// 確認メッセージ
			swal({
				text: getMsg('msg082'),
				icon: "info",
				buttons: ["キャンセル", true],
				dangerMode: true,
				closeOnEsc: false,
			})
			.then((isConfirm) => {
				if (isConfirm) {
					// 更新します
					appendAlertDel('errorMessage');
					appendAlertDel('successMessage');
					$("#selectButton").click();
				}
			});
			return false;
		})
		
		//検索ボタン
		$("#selectButton").click(function() {
			appendAlertDel('errorMessage');
			appendAlertDel('successMessage');

			if(activeCellChangedArr[0] != -1 && activeCellChangedArr[1] != -1){
				//その他のセルをアクティブにします
				argsOuter.grid.setActiveCell(0, 0);
			}
			
			changeRowNum.length = 0;
			cRNum = 0;
			errorRowNum.length = 0;
			eRNum = 0;
			changeRowNumGray.length = 0;
			cRNumG = 0;
			
			var shopDeliveryClassInput = $("#shopDeliveryClassInput").val();
			var orderOnStartDateInput = $("#orderOnStartDateInput").val();
			var orderOnEndDateInput = $("#orderOnEndDateInput").val();
			//日付フォーマットの変換
			var startArr = orderOnStartDateInput.toString().split("-");
			var endArr = orderOnEndDateInput.toString().split("-");
			var startDateD = startArr[0]+"/"+startArr[1]+"/"+startArr[2];
			var endDateD = endArr[0]+"/"+endArr[1]+"/"+endArr[2];
			//日付変数に変換
			var startCompare = new Date(orderOnStartDateInput);
			var endCompare = new Date(orderOnEndDateInput);
			
			//日付フォーマットの変換
			if(orderOnStartDateInput == null || orderOnStartDateInput == ""){
				var startDateD = null;
			}else{
				var startArr = orderOnStartDateInput.toString().split("-");
				var startDateD = startArr[0]+"/"+startArr[1]+"/"+startArr[2];
			}
			if(orderOnEndDateInput == null || orderOnEndDateInput == ""){
				var endDateD = null;
			}else{
				var endArr = orderOnEndDateInput.toString().split("-");
				var endDateD = endArr[0]+"/"+endArr[1]+"/"+endArr[2];
			}

			if(!(orderOnStartDateInput == "" || orderOnStartDateInput == null || orderOnStartDateInput == undefined) 
					&& !(orderOnEndDateInput == "" || orderOnEndDateInput == null || orderOnEndDateInput == undefined) 
					&& !(startCompare <= endCompare)){
				//承り日FROMが承り日TOより小さくない
				//msg068 = {0}は{1}以降の日付を入力してください。
				appendAlert('errorMessage', getMsgByTwoArgs('msg068', '承り日TO', '承り日FROM'));
				
				var data = [];
				// (4) SlickGridテーブルを作成
				dataView = new Slick.Data.DataView();
				grid = new Slick.Grid("#myGrid", dataView,columns, options);
				grid.setSelectionModel(new Slick.RowSelectionModel());
				grid.init();
				// initialize the model after all the events have been hooked up
				dataView.beginUpdate();
				dataView.setItems(data);
				dataView.endUpdate();
				attachAutoResizeDataGrid(grid, "myGrid", "gridContainer");
			}else{
				var data = [];
				$.ajax({
					url : contextPath + "/delivery/shopDeliveryQueryFuzzy",
					type : 'get',
					data : {"shopDeliveryClass" : shopDeliveryClassInput,"orderOnStartDateStr" : startDateD,
						"orderOnEndDateStr" : endDateD}
				}).then(function(result) {
					appendAlertDel('errorMessage');
					appendAlertDel('successMessage');
					if(Object.keys(result).length  == 0){
						$("#doKoShin").hide();
						$("#shopListDiv").hide();
						appendAlert("errorMessage",getMsg('msg031'));
					}else{
						$("#doKoShin").show();
						$("#shopListDiv").show();
					}

					for (var i = 0; i < result.length; i++) {
						var d = (data[i] = {});
						d["id"] = "id_" + i;
						d["num"] = i + 1;
						d["shopDeliveryClass"] = result[i].codeName;
						d["orderOnStartDateStr"] = result[i].orderOnStartDateStr;
						d["orderOnEndDateStr"] = result[i].orderOnEndDateStr;
						d["shopDeliveryOnStr"] = result[i].shopDeliveryOnStr;
						d["version"] = result[i].version;
						d["createdUserId"] = result[i].createdUserId;
						d["shippingError"] = result[i].createdAt;
						d["updatedUserId"] = result[i].updatedUserId;
						d["updatedAt"] = result[i].updatedAt;
						d["delType"] = false;
						d["optionType"] = "1";
						d["isNewData"] = "0";
					}
				
					// (4) SlickGridテーブルを作成
					dataView = new Slick.Data.DataView();
					
					grid = new Slick.Grid("#myGrid", dataView,columns, options);
					grid.setActiveCell(0, 0);
					
					grid.setSelectionModel(new Slick.RowSelectionModel());
					
					grid.init();
					
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

						//アクティブなセルのargsを保存します
						argsOuter = args;
						//選択したセルの行と列を取得します
						activeCellChangedArr[0] = args.grid.getActiveCell().row;
						activeCellChangedArr[1] = args.grid.getActiveCell().cell;
						
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
						$("#clearButton").removeAttr("disabled");
						$("#selectButton").removeAttr("disabled");
						$("#addButton").removeAttr("disabled");
						$("#updateButton").removeAttr("disabled");
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
				});//.then(function(result)
			}//if(!(startCompare < endCompare)) else
		})//$("#selectButton").click(function()

		// 納期を更新ボタン
		$("#updateButton").click(function(){
			// 確認メッセージ
			swal({
				text: getMsgByOneArg('msg025', "納期情報"),
				icon: "info",
				buttons: ["キャンセル", true],
				dangerMode: true,
				closeOnEsc: false,
			})
			.then((isConfirm) => {
				if (isConfirm) {
					appendAlertDel('errorMessage');
					appendAlertDel('successMessage');

					grid.gotoCell(0, 0, true);
					changeRowNum.length = 0;
					cRNum = 0;
					errorRowNum.length = 0;
					eRNum = 0;
					var sendData = JSON.stringify(dataView.getItems());
					var obj = eval("("+ sendData +")");
					var checkStatus = 0;
					
					//すべてのデータをループ、空のデータがあるかどうか調べます
					for(var i = 0; i < obj.length; i++ ){
						var onCompare = new Date(obj[i].shopDeliveryOnStr);
						var endCompare = new Date(obj[i].orderOnEndDateStr);
						if((obj[i].shopDeliveryOnStr == "" || obj[i].shopDeliveryOnStr == null || 
								obj[i].shopDeliveryOnStr == undefined) && obj[i].delType == false){
							//店着日が空いている場合
							checkStatus += 1;
							//msg001 = {0}を入力して下さい。
							appendAlert('errorMessage', getMsgByOneArg('msg001', '店着日'));
						}else if(!(endCompare <= onCompare) && obj[i].delType == false){
							//日付変数に変換
							//承り日TOが店着日より小さくない
							checkStatus += 1;
							//msg068 = {0}は{1}以降の日付を入力してください。
							appendAlert('errorMessage', getMsgByTwoArgs('msg068', '店着日', '承り日TO'));
						}
					}

					if(checkStatus == 0 && $("#errorMessage").text() == ""){
						var data = [];
						$.ajax({
						    type:"post",
						    url:contextPath + "/delivery/shopDeliveryUpdate",
						    data:sendData,
						    dataType:"json",
						    contentType:"application/json",
						    success:function(result){
						    	updateFlag = true;
						    	for(var i = result.length-1; i >= 0; i--) {
									if ("-1" == result[i].updateFailure){
										//新規のエラーが存在する場合
										errorRowNum[eRNum] = result[i].num;
										eRNum++;
										updateFlag = false;
										//{0}の更新ができませんでした。
										appendAlert("errorMessage",getMsgByTwoArgs('msg109', "納期情報"));
									}else if("-2" == result[i].updateFailure){
										//修正のエラーが存在する場合
										errorRowNum[eRNum] = result[i].num;
										eRNum++;
										updateFlag = false;
										//msg108 = 別の端末で{0}が変更されています。最新の{0}を検索し直してください。
										appendAlert("errorMessage",getMsgByTwoArgs('msg108', "納期情報"));
									}else if("-3" == result[i].updateFailure){
										//削除のエラーが存在する場合
										errorRowNum[eRNum] = result[i].num;
										eRNum++;
										updateFlag = false;
										//msg108 = 別の端末で{0}が変更されています。最新の{0}を検索し直してください。
										appendAlert("errorMessage",getMsgByTwoArgs('msg108', "納期情報"));
									}else if("-4" == result[i].updateFailure){
										//バージョン番号が不正です
										errorRowNum[eRNum] = result[i].num;
										eRNum++;
										updateFlag = false;
										//msg108 = 別の端末で{0}が変更されています。最新の{0}を検索し直してください。
										appendAlert("errorMessage",getMsgByTwoArgs('msg108', "納期情報"));
									}
								}
								
							    /* if(updateFlag == false){
							    	appendAlert("errorMessage",getMsg('msg060'));
								} */

								var dSuccessTemp = true;
						    	for(var i = 0; i < result.length; i++) {
									var d = (data[i] = {});
									d["id"] = "id_" + i;
									d["num"] = result[i].num;
									d["shopDeliveryClass"] = result[i].codeName;
									d["orderOnStartDateStr"] = result[i].orderOnStartDateStr;
									d["orderOnEndDateStr"] = result[i].orderOnEndDateStr;
									d["shopDeliveryOnStr"] = result[i].shopDeliveryOnStr;
									d["version"] = result[i].version;
									d["createdUserId"] = result[i].createdUserId;
									d["shippingError"] = result[i].createdAt;
									d["updatedUserId"] = result[i].updatedUserId;
									d["updatedAt"] = result[i].updatedAt;
									d["delType"] = result[i].delType;
									if (updateFlag == true){
										//更新成功
										d["optionType"] = 1;
									}else{
										//更新失敗
										d["optionType"] = result[i].optionType;
										dSuccessTemp = false;
									}
									d["isNewData"] = result[i].isNewData;
								}
						    	
								if(dSuccessTemp == true && $("#errorMessage").text() == ""){
									// msg026 = {0}を更新しました。
									appendAlert("successMessage",getMsgByOneArg('msg026', "納期情報"));
								}

						    	// (4) SlickGridテーブルを作成
								dataView = new Slick.Data.DataView();
								grid = new Slick.Grid("#myGrid", dataView, columns, options);
								grid.setSelectionModel(new Slick.RowSelectionModel());
								
								grid.onAddNewRow.subscribe(function (e, args) {
								    $.extend(item, args.item);
								    dataView.addItem(item);
								});
								
						    	grid.init();
								
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

									//アクティブなセルのargsを保存します
									argsOuter = args;
									//選択したセルの行と列を取得します
									activeCellChangedArr[0] = args.grid.getActiveCell().row;
									activeCellChangedArr[1] = args.grid.getActiveCell().cell;
									
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
									$("#clearButton").removeAttr("disabled");
									$("#selectButton").removeAttr("disabled");
									$("#addButton").removeAttr("disabled");
									$("#updateButton").removeAttr("disabled");
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
						    }//success:function(result)
						});//$.ajax
					}//if(checkStatus == 0){
				}//if (isConfirm)
			});//.then((isConfirm) =>
			return false;
		});//$("#updateButton").click

		//新規ボタン
		$("#addButton").click(function(){
			// 確認メッセージ
			swal({
				text: getMsg('msg067'),
				icon: "info",
				buttons: ["キャンセル", true],
				dangerMode: true,
				closeOnEsc: false,
			})
			.then((isConfirm) => {
				if (isConfirm) {
					appendAlertDel('errorMessage');
					appendAlertDel('successMessage');

					if(activeCellChangedArr[0] != -1 && activeCellChangedArr[1] != -1){
						//その他のセルをアクティブにします
						argsOuter.grid.setActiveCell(0, 0);
					}

					changeRowNum.length = 0;
					cRNum = 0;
					errorRowNum.length = 0;
					eRNum = 0;
					changeRowNumGray.length = 0;
					cRNumG = 0;

					var data = [];
					
					var shopDeliveryClassInput = $("#shopDeliveryClassInput").val();
					var orderOnStartDateInput = $("#orderOnStartDateInput").val();
					var orderOnEndDateInput = $("#orderOnEndDateInput").val();
					//日付フォーマットの変換
					var startArr = orderOnStartDateInput.toString().split("-");
					var endArr = orderOnEndDateInput.toString().split("-");
					var startDateD = startArr[0]+"/"+startArr[1]+"/"+startArr[2];
					var endDateD = endArr[0]+"/"+endArr[1]+"/"+endArr[2];

					//日付変数に変換
					var startCompare = new Date(orderOnStartDateInput);
					var endCompare = new Date(orderOnEndDateInput);

					if(orderOnStartDateInput == "" || orderOnStartDateInput == null 
							|| orderOnStartDateInput == undefined){
						//msg001 = {0}を入力して下さい。
						appendAlert('errorMessage', getMsgByOneArg('msg001', '承り日FROM'));
					}else if(orderOnEndDateInput == "" || orderOnEndDateInput == null 
							|| orderOnEndDateInput == undefined){
						//msg001 = {0}を入力して下さい。
						appendAlert('errorMessage', getMsgByOneArg('msg001', '承り日TO'));
					}else if(shopDeliveryClassInput == "" || shopDeliveryClassInput == null 
							|| shopDeliveryClassInput == undefined){
						//msg001 = {0}を入力して下さい。
						appendAlert('errorMessage', getMsgByOneArg('msg001', '店着納期区分'));
					}else if(!(startCompare <= endCompare)){
						//承り日FROMが承り日TOより小さくない
						//msg068 = {0}は{1}以降の日付を入力してください。
						appendAlert('errorMessage', getMsgByTwoArgs('msg068', '承り日TO', '承り日FROM'));
					}else{
						$.ajax({
						    url:contextPath + "/delivery/shopDeliveryQueryIntersection",
						    type:"get",
						    data:{"shopDeliveryClass" : shopDeliveryClassInput,"orderOnStartDateStr" : startDateD,
								"orderOnEndDateStr" : endDateD},
						    contentType:"application/json",
						    success:function(result){
						    	appendAlertDel('errorMessage');
								appendAlertDel('successMessage');
								if(Object.keys(result).length  == 0){
									$("#doKoShin").hide();
									$("#shopListDiv").hide();
									appendAlert("errorMessage",getMsg('msg031'));
								}else{
									$("#doKoShin").show();
									$("#shopListDiv").show();
								}
								
							    var isQueryIntersection = false;
						    	for(var i = 0; i < result.length; i++) {
									if (result[i].errorIdentification == "-1"){
										//新しい日付と既存のデータが交差します、テーブルを空にする
										
										// (4) SlickGridテーブルを作成
										dataView = new Slick.Data.DataView();
										grid = new Slick.Grid("#myGrid", dataView,columns, options);
										grid.setSelectionModel(new Slick.RowSelectionModel());
										grid.init();
										// initialize the model after all the events have been hooked up
										dataView.beginUpdate();
										dataView.setItems(data);
										dataView.endUpdate();
										attachAutoResizeDataGrid(grid, "myGrid", "gridContainer");
										
										//errorIdentification="-1"：エラーが存在する場合
										//msg069 = 店着納期区分{0}に既に同じ承り日{1}が登録されました。
										appendAlert('errorMessage', getMsgByOneArg('msg069', result[i].codeName));
										isQueryIntersection = true;
										break;
									}
						    	}

						    	if(isQueryIntersection == false){
							    	//データは規定に適合しています
									$("#shopListDiv").show();
									
									if(!(shopDeliveryClassInput == "全区分")){
										//店着納期区分は全区分ではありません
										var d = (data[0] = {});
										d["id"] = "id_" + 0;
										d["num"] = 0 + 1;
										d["shopDeliveryClass"] = result[0].codeName;
										d["orderOnStartDateStr"] = startDateD;
										d["orderOnEndDateStr"] = endDateD;
										d["shopDeliveryOnStr"] = "";
										d["delType"] = false;
										d["optionType"] = "2";
										d["isNewData"] = "0";
									}else{
										//店着納期区分は全区分です、ループして、すべての店着納期区分のデータを設定します
										for (var i = 0; i < result.length; i++) {
											var d = (data[i] = {});
											d["id"] = "id_" + i;
											d["num"] = i + 1;
											d["shopDeliveryClass"] = result[i].codeName;
											d["orderOnStartDateStr"] = startDateD;
											d["orderOnEndDateStr"] = endDateD;
											d["shopDeliveryOnStr"] = "";
											d["delType"] = false;
											d["optionType"] = "2";
											d["isNewData"] = "0";
										}
									}
								
									// (4) SlickGridテーブルを作成
									dataView = new Slick.Data.DataView();
									grid = new Slick.Grid("#myGrid", dataView,columns, options);
									grid.setActiveCell(0, 0);
									
									grid.setSelectionModel(new Slick.RowSelectionModel());
									
									grid.onAddNewRow.subscribe(function (e, args) {
									    $.extend(item, args.item);
									    dataView.addItem(item);
									});
									
									grid.init();
									
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

										//アクティブなセルのargsを保存します
										argsOuter = args;
										//選択したセルの行と列を取得します
										activeCellChangedArr[0] = args.grid.getActiveCell().row;
										activeCellChangedArr[1] = args.grid.getActiveCell().cell;
										
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
										$("#clearButton").removeAttr("disabled");
										$("#selectButton").removeAttr("disabled");
										$("#addButton").removeAttr("disabled");
										$("#updateButton").removeAttr("disabled");
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

									//表示する文字列
									var htmlTempAll = "";
									for(var i = 0; i < result.length; i++) {
										var htmlTempStart = "";
										var htmlTempEnd = "";
										if(result[i].blankIntervalStart != null && result[i].blankIntervalStart != "null" 
											&& result[i].blankIntervalStart != "" && result[i].blankIntervalStart != undefined){
											//日付を入力する前に空白の区間があります
											//日付を入力する前の最近の日付を１日間追加します
											var blankIntervalStartTemp = new Date(result[i].blankIntervalStart + 86400000);
											//入力の承り日FROMを１日間減らす
											var orderOnStartDateTemp = new Date(result[i].orderOnStartDate - 86400000);

											//Date型をStr型に変換
											var blankStartArr = (blankIntervalStartTemp.getFullYear()) + "/" 
											+ (blankIntervalStartTemp.getMonth() + 1) + "/" + (blankIntervalStartTemp.getDate()); 
											var startArr = (orderOnStartDateTemp.getFullYear()) + "/" 
											+ (orderOnStartDateTemp.getMonth() + 1) + "/" + (orderOnStartDateTemp.getDate()); 

											if(blankStartArr != startArr){
												//日付が等しくない
												//区間の起点、終点が違います
												htmlTempStart = blankStartArr + "~" + startArr;
											}else{
												//日付は同じです
												//区間の起点、終点は同じです
												htmlTempStart = startArr;
											}
										}
										if(result[i].blankIntervalEnd != null && result[i].blankIntervalEnd != "null" 
											&& result[i].blankIntervalEnd != "" && result[i].blankIntervalEnd != undefined){
											//日付を入力してから空白の区間があります
											//日付を入力した後の最近の日付を１日間減らす
											var blankIntervalEndTemp = new Date(result[i].blankIntervalEnd - 86400000);
											//入力の承り日TOを１日間追加します
											var orderOnEndDateTemp = new Date(result[i].orderOnEndDate + 86400000);

											//Date型をStr型に変換
											var blankEndArr = (blankIntervalEndTemp.getFullYear()) + "/" 
											+ (blankIntervalEndTemp.getMonth() + 1) + "/" + (blankIntervalEndTemp.getDate()); 
											var endArr = (orderOnEndDateTemp.getFullYear()) + "/" 
											+ (orderOnEndDateTemp.getMonth() + 1) + "/" + (orderOnEndDateTemp.getDate()); 

											if(blankEndArr != endArr){
												//日付が等しくない
												//区間の起点、終点が違います
												htmlTempEnd = endArr + "~" + blankEndArr;
											}else{
												//日付は同じです
												//区間の起点、終点は同じです
												htmlTempEnd = endArr;
											}
										}
										
										if(htmlTempStart != "" && htmlTempEnd != ""){
											//前の空白区間、後の空白区間は全部空いていません
											//中央に句読点を追加します
											htmlTempStart = htmlTempStart + "、";
										}
										
										if(htmlTempStart != "" || htmlTempEnd != ""){
											//前の空白区間、後の空白区間は少なくとも一つが空いていません。この店着納期区分は空白の区間を示します
											//msg084 = 店着納期区分{0}は、{1}{2}店着日の値がありません。
											htmlTempAll = htmlTempAll+getMsgByThreeArgs('msg084', result[i].codeName, htmlTempStart, htmlTempEnd);
											htmlTempAll = htmlTempAll + " \n ";
										}
									}

									if(htmlTempAll != "" && htmlTempAll != null && htmlTempAll != undefined){
										htmlTempAll = getMsg('msg100') + " \n " + htmlTempAll;
										// 確認メッセージ
										swal({
											text: htmlTempAll,
											icon: "info",
											dangerMode: true,
											closeOnEsc: false,
										})
										.then((isConfirm) => {
											if (isConfirm) {
											}
									    });
									}
									    
							    }//if(isQueryIntersection == false)
							}//success:function(result)
						});//$.ajax
					}//if(!(startCompare < endCompare)) else
				}//if (isConfirm)
			});//.then((isConfirm) =>
		})//$("#addButton").click

	});//$(document).ready(function)
</script>