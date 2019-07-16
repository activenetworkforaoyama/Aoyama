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
.cell-money {
  text-align: right;
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
</style>

<div class="breadcrumbs">
    <div class="col-sm-4">
        <div class="page-header float-left">
            <div class="page-title">
                <h1>下代価格管理</h1>
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
								<label class=" form-control-label">工場コード</label>
							</div>
							<div class="col-12 col-md-8">
								<input type="text" name="factoryCodeInput" id="factoryCodeInput"  maxlength="6" 
									class="input-sm form-control-sm form-control" style="display:inline-block;"
									onKeyUp="value=value.replace(/[\W]/g,'')">
							</div>
						</div>
						<div class="row form-group">
							<div class="col col-md-4">
								<label class=" form-control-label">アイテムコード</label>
							</div>
							<div class="col-12 col-md-8">
								<input type="text" name="itemCodeInput" id="itemCodeInput"  maxlength="2" 
									class="input-sm form-control-sm form-control" style="display:inline-block;"
									onKeyUp="value=value.replace(/[\W]/g,'')">
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
							<div class="col col-md-6">
								<button type="button" id="clearButton" class="btn btn-danger btn-block">
									<i class="fa fa-trash-o"></i>&nbsp;クリア</button>
							</div>
							<div class="col col-md-6">
								<button type="button" id="selectButton" class="btn btn-primary btn-block">
									<i class="fa fa-check-circle"></i>&nbsp;検索</button>
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
	
	<div id="shopListDiv" style="display:none;">
	
		<div class="content container" style="float: left">
			<div class="row">
				<div class="col-11">
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
	var Row;

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

	//工場コードを検査する
	function requiredFactoryCodeValidator(value){
		if (value == "" || value == null || value == undefined || !(/^[A-Za-z0-9]{1,6}$/.test(value))) {
			appendAlert("errorMessage", getMsgByThreeArgs('msg075', '工場コード', "6", "英字"));
			$("#clearButton").attr("disabled",true);
			$("#selectButton").attr("disabled",true);
			$("#updateButton").attr("disabled",true);
		    return {valid: false};
		}else {
			return {valid: true};
		}
	}

	//アイテムコードを検査する
	function requiredItemCodeValidator(value){
		if (value == "" || value == null || value == undefined || !(/^[0-9]{2}$/.test(value))) {
			appendAlert("errorMessage", getMsgByThreeArgs('msg010', 'アイテムコード', "2", "整数"));
			$("#clearButton").attr("disabled",true);
			$("#selectButton").attr("disabled",true);
			$("#updateButton").attr("disabled",true);
		    return {valid: false};
		}else {
			return {valid: true};
		}
	}
	
	//ドル為替を検査する
	function requiredDollarExchangeValidator(value){
		if (value == "" || value == null || value == undefined || !(/^\d{1,3}$|^\d{1,3}\.\d{1}$/.test(value))) {
			appendAlert("errorMessage", getMsgByOneArg('msg034', 'ドル為替（円）'));
			$("#clearButton").attr("disabled",true);
			$("#selectButton").attr("disabled",true);
			$("#updateButton").attr("disabled",true);
		    return {valid: false};
		}else {
			return {valid: true};
		}
	}

	//製品関税を検査する
	function requiredProductTariffValidator(value){
		if (value == "" || value == null || value == undefined || !(/^\d{1,3}$|^\d{1,3}\.\d{1}$/.test(value))) {
			appendAlert("errorMessage", getMsgByOneArg('msg034', '製品関税（％）'));
			$("#clearButton").attr("disabled",true);
			$("#selectButton").attr("disabled",true);
			$("#updateButton").attr("disabled",true);
		    return {valid: false};
		}else {
			return {valid: true};
		}
	}

	//製品運賃を検査する
	function requiredProductShippingValidator(value){
		var integerCheck = Number(value);
		if (value == "" || value == null || value == undefined || !(Math.floor(integerCheck)===integerCheck && 0<=integerCheck)) {
			appendAlert("errorMessage", getMsgByThreeArgs('msg012', '製品運賃（円）', "負でない整数"));
			$("#clearButton").attr("disabled",true);
			$("#selectButton").attr("disabled",true);
			$("#updateButton").attr("disabled",true);
		    return {valid: false};
		}else {
			return {valid: true};
		}
	}

	//運賃誤差を検査する
	function requiredShippingErrorValidator(value){
		var integerCheck = Number(value);
		if (value == "" || value == null || value == undefined || !(Math.floor(integerCheck)===integerCheck && 0<=integerCheck)) {
			appendAlert("errorMessage", getMsgByThreeArgs('msg012', '運賃誤差（円）', "負でない整数"));
			$("#clearButton").attr("disabled",true);
			$("#selectButton").attr("disabled",true);
			$("#updateButton").attr("disabled",true);
		    return {valid: false};
		}else {
			return {valid: true};
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
		// (1) SlickGridのカラム定義
		var columns = [
			{id: "sel", name: "No", field: "num", behavior: "select", cssClass: "cell-selection", width: 40, resizable: false, selectable: false },
	   		{id: 'factory_code', name: '工場コード', field: 'factoryCode', formatter: colorFormatter, editor: Slick.Editors.DisabledText, sortable: true, validator: requiredFactoryCodeValidator},
		   	{id: 'item_code', name: 'アイテムコード', field: 'itemCode', formatter: colorFormatter, editor: Slick.Editors.DisabledText, sortable: true, validator: requiredItemCodeValidator},
		   	{id: 'dollar_exchange', name: 'ドル為替（円）', cssClass: "cell-money", field: 'dollarExchange', formatter: colorFormatter, editor: Slick.Editors.Text, sortable: true, validator: requiredDollarExchangeValidator},
		   	{id: 'product_tariff', name: '製品関税（％）', field: 'productTariff', formatter: colorFormatter, editor: Slick.Editors.Text, sortable: true, validator: requiredProductTariffValidator},
		   	{id: 'product_shipping', name: '製品運賃（円）', cssClass: "cell-money", field: 'productShipping', formatter: colorFormatter, editor: Slick.Editors.Text, sortable: true, validator: requiredProductShippingValidator},
		   	{id: 'shipping_error', name: '運賃誤差（円）', cssClass: "cell-money", field: 'shippingError', formatter: colorFormatter, editor: Slick.Editors.Text, sortable: true, validator: requiredShippingErrorValidator},
		   	{id: "del_type", name: "削除", width: 50, minWidth: 50, maxWidth: 60, cssClass: "cell-del-type", field: "delType", formatter: Slick.Formatters.Checkbox, editor: Slick.Editors.Checkbox, cannotTriggerInsert: true }
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

		$("#clearButton").click(function(){
			$("#factoryCodeInput").val("");
			$("#itemCodeInput").val("");
			appendAlertDel('errorMessage');
			appendAlertDel('successMessage');
		})

		// キャンセルボタン
		jQuery("#cancelButton").click(function(){
			// 確認メッセージ
			swal({
				title: "確認",
				text: getMsgByOneArg('msg023', "下代価格"),
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
					$("#selectButton").click();
				}
			});
			return false;
		})
	
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
			$("#shopListDiv").show();
			var factoryCodeInput = $("#factoryCodeInput").val();
			var itemCodeInput = $("#itemCodeInput").val();
			
			var data = [];
			$.ajax({
				url : contextPath + "/piece/pieceQueryFuzzy",
				type : 'get',
				data : {"factoryCode" : factoryCodeInput,"itemCode" : itemCodeInput}
			}).then(function(result) {
				appendAlertDel('errorMessage');
				appendAlertDel('successMessage');
				if(Object.keys(result).length  == 0){
					$("#doKoShin").hide();
					appendAlert("errorMessage",getMsgByOneArg('msg031'));
				}else{
					$("#doKoShin").show();
				}
				
				for (var i = 0; i < result.length; i++) {
					var d = (data[i] = {});
					d["id"] = "id_" + i;
					d["num"] = i + 1;
					d["factoryCode"] = result[i].factoryCode;
					d["itemCode"] = result[i].itemCode;
					d["dollarExchange"] = result[i].dollarExchange;
					d["productTariff"] = result[i].productTariff;
					d["productShipping"] = result[i].productShipping;
					d["shippingError"] = result[i].shippingError;
					d["createdUserId"] = result[i].createdUserId;
					d["updatedUserId"] = result[i].updatedUserId;
					d["delType"] = false;
					d["optionType"] = "1";
					d["isNewData"] = "0";
					d["displayIdentify"] = true;
				}
			
				// (4) SlickGridテーブルを作成
				dataView = new Slick.Data.DataView();
				
				grid = new Slick.Grid("#myGrid", dataView,columns, options);
				grid.setSelectionModel(new Slick.RowSelectionModel());
				
				grid.onAddNewRow.subscribe(function(e,args) {
					var item = {"num": data.length+1, "id": "new_" + (Math.round(Math.random() * 10000)),"factoryCode" : "","itemCode" : "","dollarExchange" : "","productTariff" : "","productShipping" : "","shippingError" : "", "delType": false, "optionType": "2", "isNewData": "1"};
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
					//アクティブなセルのargsを保存します
					argsOuter = args;
					//選択したセルの行と列を取得します
					activeCellChangedArr[0] = args.grid.getActiveCell().row;
					activeCellChangedArr[1] = args.grid.getActiveCell().cell;
					
					var item = args.grid.getDataItem(args.row);
					$("#doKoShin").show();
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
			});//$.ajax
		})//$("#selectButton").click(function()

		// 下代価格を更新ボタン
		$("#updateButton").click(function(){
			// 確認メッセージ
			swal({
				title: "確認",
				text: getMsgByOneArg('msg025', "下代価格"),
				icon: "info",
				buttons: true,
				dangerMode: true,
				closeOnEsc: false,
			})
			.then((isConfirm) => {
				if (isConfirm) {
					appendAlertDel('errorMessage');
					appendAlertDel('successMessage');

					grid.gotoCell(1, 1, true);
					changeRowNum.length = 0;
					cRNum = 0;
					errorRowNum.length = 0;
					eRNum = 0;
					var sendData = JSON.stringify(dataView.getItems());
					var obj = eval("("+ sendData +")");
					//エラー変数
					var checkStatus = 0;

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

					//各データが空かどうかを確認します、空の場合はエラーメッセージを提示し、エラー変数を＋１します
					for(var i = 0; i < obj.length; i++ ){
						if((obj[i].factoryCode == "" || obj[i].factoryCode == null || 
								obj[i].factoryCode == undefined) && obj[i].factoryCode != "0"){
							checkStatus += 1;
							appendAlert('errorMessage', getMsgByOneArg('msg001', '工場コード'));
						}else if((obj[i].itemCode == "" || obj[i].itemCode == null || 
								obj[i].itemCode == undefined) && obj[i].itemCode != "0"){
							checkStatus += 1;
							appendAlert('errorMessage', getMsgByOneArg('msg001', 'アイテムコード'));
						}else if((obj[i].dollarExchange == "" || obj[i].dollarExchange == null || 
								obj[i].dollarExchange == undefined) && obj[i].dollarExchange != "0"){
							checkStatus += 1;
							appendAlert('errorMessage', getMsgByOneArg('msg001', 'ドル為替（円）'));
						}else if((obj[i].productTariff == "" || obj[i].productTariff == null || 
								obj[i].productTariff == undefined) && obj[i].productTariff != "0"){
							checkStatus += 1;
							appendAlert('errorMessage', getMsgByOneArg('msg001', '製品関税（％）'));
						}else if((obj[i].productShipping == "" || obj[i].productShipping == null || 
								obj[i].productShipping == undefined) && obj[i].productShipping != "0"){
							checkStatus += 1;
							appendAlert('errorMessage', getMsgByOneArg('msg001', '製品運賃（円）'));
						}else if((obj[i].shippingError == "" || obj[i].shippingError == null || 
								obj[i].shippingError == undefined) && obj[i].shippingError != "0"){
							checkStatus += 1;
							appendAlert('errorMessage', getMsgByOneArg('msg001', '運賃誤差（円）'));
						}
					}
					
					if(checkStatus == 0 && $("#errorMessage").text() == ""){
						var data = [];
						$.ajax({
						    type:"post",
						    url:contextPath + "/piece/pieceUpdate",
						    data:sendData,
						    dataType:"json",
						    contentType:"application/json",
						    success:function(result){
						    	updateFlag = true;
								for(var i = result.length-1; i >= 0; i--) {
									if ("-1" == result[i].updateFailure){
										//下代価格の主キーはすでに存在している、行号を記録する
										errorRowNum[eRNum] = result[i].num;
										eRNum++;
										updateFlag = false;
							    		appendAlert("errorMessage",getMsgByOneArg('msg061', '下代価格の主キー'));
									}else if("-2" == result[i].updateFailure){
										//工場コードは工場マスタに存在しません、行号を記録する
										errorRowNum[eRNum] = result[i].num;
										eRNum++;
										updateFlag = false;
							    		appendAlert("errorMessage",getMsgByTwoArgs('msg062', "工場コード", "工場マスタ"));
									}else if("-3" == result[i].updateFailure){
										//アイテムコードはアイテムマスタに存在しません、行号を記録する
										errorRowNum[eRNum] = result[i].num;
										eRNum++;
										updateFlag = false;
							    		appendAlert("errorMessage",getMsgByTwoArgs('msg062', "アイテムコード", "アイテムマスタ"));
									}else if("-4" == result[i].updateFailure){
										//下代価格の主キーはすでに存在しません
										//このような状況は修正時に発生します。
										//現在のすべての変更されたデータは、すべてデータベースから呼び出しされますので、下代価格の主キーが存在しない場合はありません。
									}
								}

								for(var i = 0; i < result.length; i++) {
									if (result[i].updateFailure == true){
										//一意制約の場合、行号を記録する
										errorRowNum[eRNum] = result[i].num;
										eRNum++;
										updateFlag = false;
									}
								}
								/* if(!updateFlag){
							    	appendAlert("errorMassageIno",getMsg('msg033'));
								} */

								var dSuccessTemp = true;
						    	for(var i = 0; i < result.length; i++) {
						    		var d = (data[i] = {});
									d["id"] = "id_" + i;
									d["num"] = result[i].num;
									d["factoryCode"] = result[i].factoryCode;
									d["itemCode"] = result[i].itemCode;
									d["dollarExchange"] = result[i].dollarExchange;
									d["productTariff"] = result[i].productTariff;
									d["productShipping"] = result[i].productShipping;
									d["shippingError"] = result[i].shippingError;
									d["createdUserId"] = result[i].createdUserId;
									d["updatedUserId"] = result[i].updatedUserId;
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
									d["displayIdentify"] = result[i].displayIdentify;
								}

						    	if(dSuccessTemp == true && $("#errorMessage").text() == ""){
									// 更新します
							    	appendAlert("successMessage",getMsgByOneArg('msg044', "下代価額情報"));
								}
							    
						    	// (4) SlickGridテーブルを作成
								dataView = new Slick.Data.DataView();
								
								grid = new Slick.Grid("#myGrid", dataView, columns, options);
								grid.setSelectionModel(new Slick.RowSelectionModel());
								grid.onAddNewRow.subscribe(function (e, args) {
									var item = {"num": data.length+1, "id": "new_" + (Math.round(Math.random() * 10000)),"factoryCode" : "","itemCode" : "","dollarExchange" : "","productTariff" : "","productShipping" : "","shippingError" : "", "delType": false, "optionType": "2", "isNewData": "1"};
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
		});//$("#updateButton").click(function()
	});//$(document).ready(function)
</script>