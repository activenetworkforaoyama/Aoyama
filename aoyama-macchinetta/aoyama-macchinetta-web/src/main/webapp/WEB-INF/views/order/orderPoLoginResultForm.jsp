<style>
.alert {
    margin-bottom: 15px;
    padding: 10px;
    border: 1px solid;
    border-radius: 4px;
    text-shadow: 0 1px 0 #ffffff;
}
.alert-error {
    background: #fff1f0;
    color: #d85030;
    border-color: rgba(216, 80, 48, 0.3);
    width:800px;
}
</style>
<div class="breadcrumbs">
	<div class="col-sm-4">
		<div class="page-header float-left">
			<div class="page-title">
				<h1>オーダー登録結果</h1>
			</div>
		</div>
	</div>
</div>
<div class="content mt-3">
<t:messagesPanel  messagesAttributeName="messages"/>
            <div class="animated fadeIn">
				<div class="card">
					<div class="card-body">
							<c:if test="${isLogin == '8'}">
							<div class="row">
								<div class="col col-md-12">
									<strong><output>オーダー登録を受け付けました。</output></strong>
								</div>
							</div>
							</c:if>
							<c:if test="${orderFormIsUpdate == '9' || isUpdate == '1'}">
							<div class="row">
								<div class="col col-md-12">
									<strong><output>オーダー更新を受け付けました。</output></strong>
								</div>
							</div>
							</c:if>
							<c:if test="${isUpdate == '2'}">
							<div class="row">
								<div class="col col-md-12">
									<strong><output>注文削除を受け付けました。</output></strong>
								</div>
							</div>
							</c:if>
							<c:if test="${isUpdate == '3'}">
							<div class="row">
								<div class="col col-md-12">
									<strong><output>注文取消を受け付けました。</output></strong>
								</div>
							</div>
							</c:if>
							<c:if test="${isFailure == '1'}">
							<div class="row">
								<div class="col col-md-12">
									<strong><output>オーダー登録が失敗しました。</output></strong>
								</div>
							</div>
							</c:if>
							<c:if test="${isFailure == '2'}">
							<div class="row">
								<div class="col col-md-12">
									<strong><output>オーダー更新が失敗しました。</output></strong>
								</div>
							</div>
							</c:if>
							<c:if test="${isUpdate == '6'}">
							<div class="row">
								<div class="col col-md-12">
									<strong><output>注文情報が変更されています。もう一度、オーダー一覧へ戻って最新の注文情報を選んでください。</output></strong>
								</div>
							</div>
							</c:if>
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
</script>


