<div>
	<input type="button" value="①注文内容確認書(SUIT)_工場向" onclick="pdfDownload(1)">&nbsp;&nbsp;
	<input type="button" value="②注文内容確認書(SUIT)_お客様向" onclick="pdfDownload(2)">&nbsp;&nbsp;
	<input type="button" value="③工場指示書(SUIT)" onclick="pdfDownload(3)">
</div>

<div>
	<input type="button" value="text" onclick="textOne()">
	<input type="text" value="${textOne }" style="width:500px">
</div>

<div>
	<input type="button" value="confirmationBookSuit-Factory" onclick="pdfDownload(1,'suit')">&nbsp;&nbsp;
	<input type="button" value="confirmationBookSuit-Guest" onclick="pdfDownload(2,'suit')">&nbsp;&nbsp;
	<input type="button" value="factoryInstructionsSuit" onclick="pdfDownload(3,'suit')">
	<br>
	<input type="button" value="confirmationBookCoat-Factory" onclick="pdfDownload(4,'coat')">&nbsp;&nbsp;
	<input type="button" value="confirmationBookCoat-Guest" onclick="pdfDownload(5,'coat')">&nbsp;&nbsp;
	<input type="button" value="factoryInstructionsCoat" onclick="pdfDownload(6,'coat')">
	<br>
	<input type="button" value="confirmationBookShirt-Factory" onclick="pdfDownload(7,'shirt')">&nbsp;&nbsp;
	<input type="button" value="confirmationBookShirt-Guest" onclick="pdfDownload(8,'shirt')">&nbsp;&nbsp;
	<input type="button" value="factoryInstructionsShirt" onclick="pdfDownload(9,'shirt')">
</div>

<!-- 依存ライブラリの読み込み -->
<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/firebugx.js"></script>
<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery-ui-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/slickGrid-2.4.3/lib/jquery.event.drag-2.3.0.js"></script>

<script type="text/javascript">

var contextPath = $("meta[name='contextPath']").attr("content");

function pdfDownload(sign,productItem){
	window.location.href = contextPath + "/pdfFile/coPdfFileDownload?sign="+sign+"&orderId=376710000010&productItem=SUIT(3P2PP)";
}

function textOne(){
	window.location.href = contextPath + "/pdfFile/textOne";
}

</script>
