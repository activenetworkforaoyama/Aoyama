<div class="breadcrumbs">
	<div class="col-sm-4">
		<div class="page-header float-left">
			<div class="page-title">
				<h1>会計結果</h1>
			</div>
		</div>
	</div>
</div>

<div class="content mt-3">
	<div class="animated fadeIn">

		<div class="card">
			<div class="card-body">
			<c:choose>
				<c:when test="${status == 'fromAccounting' || status == 'fromOrderList'}">
				<div class="row">
					<div class="col col-md-12">
						<strong><output>会計登録を受け付けました。</output></strong>
					</div>
				</div>
				</c:when>
				<c:when test="${status == '02'}">
				<div class="row">
					<div class="col col-md-12">
						<strong><output>会計取消を受け付けました。</output></strong>
					</div>
				</div>
				</c:when>
			</c:choose>
			</div>
		</div>
		<!-- card body -->
	</div>
	<!-- card -->
	<div class="card">
		<div class="card-body">
			<div class="row">
				<div class="col"></div>
				<div class="col">
					<button id="backButton" type="button"
						class="btn btn-success btn-block">
						<i class="fa fa-arrow-left"></i> 一覧へ戻る
					</button>
				</div>
				<div class="col"></div>
			</div>
		</div>
	</div>
	<!-- card body -->
</div>
<!-- card -->
<script type="text/javascript">
var contextPath = jQuery("meta[name='contextPath']").attr("content");
jQuery('#backButton').on('click', function() {
	if("${status}" == '02' || "${status}" == 'fromAccounting'){
		window.location.href= contextPath + "/accounting/init";
		}
	else if ("${status}" == 'fromOrderList'){
		window.location.href= contextPath + "/orderlist/init";
		}
});
</script>
