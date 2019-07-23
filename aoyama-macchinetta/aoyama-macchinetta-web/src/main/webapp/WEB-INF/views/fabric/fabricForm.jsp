<style>
.alert-error {
    background: #fff1f0;
    color: #d85030;
    border-color: rgba(216, 80, 48, 0.3);
    width:800px;
}
.input_area_clothMngUpload{
	background: #fff;
	border: 1px solid #fff;
	text-align: left;
}
.input_area_clothMngDownload{
	background: #fff;
	border: 1px solid #fff;
	text-align: left;
}
.fileinput-button {
    position: relative;
    display: inline-block;
    overflow: hidden;
}
.fileinput-button input{
    position: absolute;
    left: 0px;
    top: 0px;
    opacity: 0;
    -ms-filter: 'alpha(opacity=0)';
}
th {padding-left: 1cm;}
</style>

<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-ui-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery.event.drag-2.3.0.js"></script>

<script src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script type="text/javascript">
/**
 * ｊｓｐページのロードが完了したときの実行
 */
$(document).ready(function(){
 	var contextPath = $("meta[name='contextPath']").attr("content");
 	//ダウンロードのボタンのクリック
	$("#fabricDownload").click(function(){
	    window.location.href= contextPath + "/fabric/fabricDownload";
	}); 

	// 更新のボタンのクリック
	jQuery("#confirmUpload").click(function(){
		// 確認メッセージ
		swal({
			  text: getMsgByOneArg('msg025', "生地情報"),
			  icon: "info",
			  buttons: ["キャンセル", true],
			  dangerMode: true,
			  closeOnEsc: false,
			})
			.then((isConfirm) => {
			  if (isConfirm) {
				  // 画面のチェック処理を実行
				  updateFabric();
			  }
			});
		return false;
	});
	
})

/**
 * 更新時、OKのボタンのクリック
 */
function updateFabric(){
	$("#messagesPanel").attr("style","display:none");
	var suffixType = checkFileTxt();

	if(suffixType == 1){
		//CSVです
		$("#updateFabricForm").attr("action","${pageContext.request.contextPath}/fabric/fabricUpload");
		$("#updateFabricForm").submit();

	}else if(suffixType == -1){
		//CSVではない
		appendAlert("errorMessage", getMsg('msg036'));
	}else if(suffixType == 0){
		//ファイルがない
		appendAlert("errorMessage", getMsg('msg037'));
	}
}

/**
 * ファイルの形式を検査する
 * return：　１：CSVです　０：ファイルがない　－１：CSVではない
 */
function checkFileTxt(){
	var file = $("#file").val();
	if(file == null || file == undefined || file == ""){
		//ファイルがない
		return 0;
	}
	var pos = file.lastIndexOf("\.");
	var fileName = file.substring(pos + 1);  
	 if("csv" == fileName){
		//CSVです
		return 1;
	}else{
		//CSVではない
		return -1;
	}
}
</script>

<div class="breadcrumbs">
    <div class="col-sm-4">
        <div class="page-header float-left">
            <div class="page-title">
                <h1>生地管理</h1>
            </div>
        </div>
    </div>
</div>

<div class="content mt-3">
	<div class="alert alert-error" id="errorMessage" style="display:none"></div>
	
	<div id="messagesPanel">
		<t:messagesPanel messagesAttributeName="resultMessages"/>
	</div>
	
	<form id="updateFabricForm" action="#" method="post" enctype="multipart/form-data">
	<sec:csrfInput />
	
	<div class="card">
	<div class="card-body">
		<div>
			<br>
			<div class="col col-md-2" style="font-weight:bold;">CSVアップロード</div>
			<div class="col-12 col-md-9">
				<input class="float-left col-md-9" id="file" name="file" type="file">
				<!-- <span class="btn btn-success fileinput-button">
			        <span>ファイルを選択</span>
					<input class=" float-left" id="file" name="file" type="file">
		        </span> -->
			</div>
			<br><br>
			<div class="col col-md-2"></div>
			<div class="col-12 col-md-3">
				<button id="confirmUpload" class="btn btn-danger btn-block"><i class="fa fa-check-circle"></i>生地情報を更新する</button>
			</div>
			<br><br>
		</div>
	</div>
	</div>
	<br>
	
	<div class="card">
	<div class="card-body">
		<div class=""><br>
			<div class="col col-md-2"></div>
			<div class="col col-md-4">
				<button id="fabricDownload" type="button" class="btn btn-primary btn-block" ><i class="fa fa-check-circle"></i>生地情報をダウンロードする</button>
			</div>
			<br><br>
		</div>
	</div>
	</div>
	<br><br>
	 
	</form>
</div>