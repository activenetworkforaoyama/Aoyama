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
			  title: "確認",
			  text: getMsgByOneArg('msg025', "生地情報"),
			  icon: "info",
			  buttons: true,
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

	//var file = $("#file").val();
	/* var file = document.getElementById('file').files[0];
	var fileOriginalName = file.name;
	var fileOriginalURL = getObjectURL(file);
	var presentFile = fileOriginalURL+"/"+fileOriginalName; */

	/* var file_upl = document.getElementById('file');
	file_upl.select();
	var realpath = document.selection.createRange().text; */

	/* var file_upl = document.getElementById('file');
	alert(file_upl);
	file_upl.select();
	alert(file_upl.select());
	var realpath = document.selection.createRange().text;
	alert(realpath); */

	//window.location.href = contextPath + "/fabric/checkFileExist?presentFile="+presentFile;
	/* $("#updateFabricForm").attr("action","${pageContext.request.contextPath}/fabric/checkFileExist?presentFile="+presentFile);
	$("#updateFabricForm").submit(); */

	/* var fso,s = fileOriginalURL;
	//fso = new ActiveXObject("Scripting.FileSystemObject");
	if (fso.FileExists(fileOriginalURL+"/"+fileOriginalName)){
		s += " exists.";
	}else{
		s += " doesn't exist.";
	}
	alert(s); */
	
	//$('#imgContainer').html("<img src='" + objURL + "' alt='Alternate Text' width='640px' height='350px' id='target' />"); 
    
	if(suffixType == 1){
		//ｔｘｔです
		$("#updateFabricForm").attr("action","${pageContext.request.contextPath}/fabric/fabricUpload");
		$("#updateFabricForm").submit();
	}else if(suffixType == -1){
		//ｔｘｔではない
		appendAlert("errorMessage", getMsg('msg036'));
	}else if(suffixType == 0){
		//ファイルがない
		appendAlert("errorMessage", getMsg('msg037'));
	}
}

/* function getObjectURL(file) { 
    var url = null; 
    if(window.createObjcectURL != undefined) { 
        url = window.createOjcectURL(file); 
        //alert("createObjcectURL-"+url);
    }else if(window.URL != undefined) { 
        url = window.URL.createObjectURL(file); 
        //alert("URL--------------"+url);
    }else if(window.webkitURL != undefined) { 
    	//alert("webkitURL--------"+url);
        url = window.webkitURL.createObjectURL(file); 
    } 
    return url; 
} */

/**
 * ファイルの形式を検査する
 * return：　１：ｔｘｔです　０：ファイルがない　－１：ｔｘｔではない
 */
function checkFileTxt(){
	var file = $("#file").val();
	if(file == null || file == undefined || file == ""){
		//ファイルがない
		return 0;
	}
	var pos = file.lastIndexOf("\.");
	var fileName = file.substring(pos + 1);  
	 if("txt" == fileName){
		//ｔｘｔです
		return 1;
	}else{
		//ｔｘｔではない
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
	
	<div id="inputAreaClothUpload" class="">
		<br>
		<div class="col col-md-2" style="background:#fcf8e3">CSVアップロード</div>
		<div class="col-12 col-md-9">
			<input class=" float-left" id="file" name="file" type="file">
			<!-- <span class="btn btn-success fileinput-button">
		        <span>ファイルを選択</span>
				<input class=" float-left" id="file" name="file" type="file">
	        </span> -->
		</div>
		<br><br>
		<div class="col col-md-3">
			<button id="confirmUpload" class="btn btn-danger btn-block"><i class="fa fa-check-circle"></i>生地情報を更新する</button>
		</div>
		<br><br>
	</div>
	<br>
	
	<div class=""><br>
		<div class="col col-md-4">
			<button id="fabricDownload" type="button" class="btn btn-primary btn-block" ><i class="fa fa-check-circle"></i>生地情報をダウンロードする</button>
		</div>
		<br><br>
	</div>
	<br><br>
	 
	</form>
</div>