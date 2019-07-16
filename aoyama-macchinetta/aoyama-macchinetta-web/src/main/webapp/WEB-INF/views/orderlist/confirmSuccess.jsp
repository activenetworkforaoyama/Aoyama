<script src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script>
<div class="breadcrumbs">
     <div class="col-sm-4">
         <div class="page-header float-left">
             <div class="page-title">
                 <h1>承認結果</h1>
             </div>
         </div>
     </div>
</div>
<br>

<div class="content mt-3">
    <div class="animated fadeIn">
          
	<div class="card">
		<div class="card-body">
				<div class="row">
					<div class="col col-md-12">
						<label class=" form-control-label-value" id="msg"></label>
					</div>
				</div>
			</div>
		</div><!-- card body -->
	</div><!-- card -->
	<div class="card">
		<div class="card-body">
				<div class="row">
					<div class="col">　</div>
					<div class="col"><button id="backButton" type="button" class="btn btn-success btn-block"><i class="fa fa-arrow-left"></i> 一覧へ戻る</button></div>
					<div class="col">　</div>
				</div>
			</div>
		</div>
	</div>
<script>

//戻るボタンクリック
var contextPath = jQuery("meta[name='contextPath']").attr("content");
jQuery('#backButton').on('click', function() {
	window.location.href= contextPath + "/orderlist/gotoOrderlist";
});
if ("${updateFlag}" == "false") {

	jQuery("#msg").html(getMsg('msg094'));
}
if ("${updateFlag}" == "true") {

	jQuery("#msg").html(getMsg('msg093'));
}
</script>
