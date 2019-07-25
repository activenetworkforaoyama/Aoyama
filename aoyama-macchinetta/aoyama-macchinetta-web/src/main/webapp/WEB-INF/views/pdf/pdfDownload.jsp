<div>
	<input type="button" value="①注文内容確認書(SUIT)_工場向" onclick="pdfDownload(1)">&nbsp;&nbsp;
	<input type="button" value="②注文内容確認書(SUIT)_お客様向" onclick="pdfDownload(2)">&nbsp;&nbsp;
	<input type="button" value="③工場指示書(SUIT)" onclick="pdfDownload(3)">
</div>

<div>
	<input type="button" value="text" onclick="textOne()">&nbsp;&nbsp;
	<input type="text" value="${textOne }">
</div>

<!-- 依存ライブラリの読み込み -->
<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/firebugx.js"></script>
<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-ui-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery.event.drag-2.3.0.js"></script>

<script type="text/javascript">

var contextPath = $("meta[name='contextPath']").attr("content");

function pdfDownload(sign){
	window.location.href = contextPath + "/pdfFile/poPdfFileDownload?sign="+sign+"&orderId=077190125940";
}

function textOne(){
	window.location.href = contextPath + "/pdfFile/textOne";
}

</script>
