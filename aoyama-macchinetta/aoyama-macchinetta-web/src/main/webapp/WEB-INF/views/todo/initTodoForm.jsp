<style>

a:link{text-decoration: underline; color:blue; font-size: 12px;}
a:visited{ color:green;}
a:hover{text-decoration: underline; color:#09f; font-size: 13px;}
a:active{text-decoration: blink; color: yellow;}

	.slick-cell.selected {
	    background-color: #FBB;

</style>

<spring:eval var="sessionContent" expression="@sessionContent" />
<div>
	 <p  id="Search">Todo Data Search </p>
	 <p  id="authority">authority: ${sessionContent.authority}</p>
     <p  id="customize">category: ${sessionContent.category}</p>

	<!-- SlickGridテーブルの表示領域となる要素 -->
	<div id="myGrid" style="width:800px;height:500px;"></div>
	
	<!-- SlickGridページネーションコントロールの表示領域となる要素 -->
	<div id="pager" style="width:800px;height:20px;"></div>

    <button onclick="undo()"> Undo</button>
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
    
    <!-- 実装したJavaScriptファイルの読み込み -->
    <!--<script src="${pageContext.request.contextPath}/resources/app/js/default.js"></script>-->
</div>
<script>

var dataView;
var grid;
var sortcol = "title";
var sortdir = 1;

function comparer(a, b) {
	  var x = a[sortcol], y = b[sortcol];
	  return (x == y ? 0 : (x > y ? 1 : -1));
	}

function mineFormatter ( row, cell, value, columnDef, dataContext ) {
    return value;
}

function requiredFieldValidator(value) {
	  if (value == null || value == undefined || !value.length) {
	    return {valid: false, msg: "This is a required field"};
	  }
	  else {
	    return {valid: true, msg: null};
	  }
	}

function copyData(){
    alert("copy");
    }

var commandQueue = [];
function queueAndExecuteCommand(item, column, editCommand) {
  commandQueue.push(editCommand);
  editCommand.execute();
}
function undo() {
  var command = commandQueue.pop();
  if (command && Slick.GlobalEditorLock.cancelCurrentEdit()) {
    command.undo();
    grid.gotoCell(command.row, command.cell, false);
  }
}


$(function () {

  // (1) SlickGridのカラム定義
  //     6つのカラムのそれぞれにつき ID・表示名・マッピングするデータ を定義している。
  var columns = [
	{id: "sel", name: "#", field: "num", behavior: "select", cssClass: "cell-selection", width: 40, resizable: false, selectable: false },
    {id: 'title', name: 'Title', field: 'title', formatter: mineFormatter, sortable: true},
    {id: 'duration', name: 'Duration', field: 'duration', editor: Slick.Editors.Text, sortable: true},
    {id: '%', name: '% Complete', field: 'percentComplete', sortable: true},
    {id: 'start', name: 'Start', field: 'start', minWidth: 60, editor: Slick.Editors.Date, sortable: true},
    {id: 'finish', name: 'Finish', field: 'finish', editor: Slick.Editors.Date, sortable: true},
    {id: 'effort-driven', name: 'Effort Driven', field: 'effortDriven', width: 80, minWidth: 20, maxWidth: 80, formatter: mineFormatter}
  ];

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
	  forceFitColumns: false,
	  autoEdit: true,
	  editCommandHandler: queueAndExecuteCommand,
	  topPanelHeight: 25
	};


  var contextPath = $("meta[name='contextPath']").attr("content");
  // (3) 1000件のサンプルデータ作成
  var data = [];

  for (var i = 0; i < 1000; i++) {
	    var d = (data[i] = {});
	    
	    d["id"] = "id_" + i;
	    d["num"] = i;
	    d["title"] = "<a href='"+ contextPath+ "/user/create?form" +"' >Task</a> " + i;
	    d["duration"] = "5 days";
	    d["percentComplete"] = Math.round(Math.random() * 100);
	    d["start"] = "01/01/2009";
	    d["finish"] = "01/05/2009";
	    d["effortDriven"] = "<button id='confirm' class='button button-primary button-square button-small' onclick='copyData()'>修正</button>";
	}


    // (4) SlickGridテーブルを作成
    dataView = new Slick.Data.DataView();
    grid = new Slick.Grid("#myGrid", dataView, columns, options);
    grid.setSelectionModel(new Slick.RowSelectionModel());
    grid.init();
    
    var pager = new Slick.Controls.Pager(dataView, grid, $("#pager"));
    var columnpicker = new Slick.Controls.ColumnPicker(columns, grid, options);

	grid.onCellChange.subscribe(function (e, args) {
	  dataView.updateItem(args.item.id, args.item);
	});
	
    grid.onSort.subscribe(function (e, args) {
        sortdir = args.sortAsc ? 1 : -1;
        sortcol = args.sortCol.field;

        dataView.sort(comparer, args.sortAsc);
      });


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
	
    //dataView.syncGridSelection(grid, true);

    //$("#gridContainer").resizable();

});

</script>


