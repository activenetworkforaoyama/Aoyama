<spring:eval var="sessionContent" expression="@sessionContent" />
<style type="text/css">
span {
	margin-right: 16px;
}
select.hidedown {
	-webkit-appearance:none;
	-moz-appearance:none;
	appearance:none;
}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/chosen.css" type="text/css">
<div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>オーダー</h1>
                    </div>
                </div>
            </div>
        </div>
        <form:form id="formId" action="${pageContext.request.contextPath}/order/orderPoReconfirm" method="post" modelAttribute="orderForm" class="form-horizontal">
        <div class="content mt-3">
            <div class="animated fadeIn">
            <div class="row">
            <div class="col-lg-6">
                <div class="row">
                    <div class="col col-md-4"><label class=" form-control-label">お客様名</label></div>
                    <div class="col-12 col-md-4" id="custNmDiv">
						<c:if test="${order.custNm != null}">
                        	${order.custNm}
                        </c:if>	
                    </div>
                </div>
                <div class="row">
                    <div class="col col-md-4"><label class=" form-control-label">ステータス</label></div>
                    <div class="col-12 col-md-8" id="status">
                        <c:if test="${order.tscStatus == 'T2'}">
                        	登録済
                        </c:if>
                        <c:if test="${order.tscStatus == 'T0'}">
                        	一時保存
                        </c:if>
                        <c:if test="${order.tscStatus == 'T1'}">
                        	取り置き
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="row">
                    <div class="col text-right">
                        <strong>ご請求金額：&yen;0(消費税&yen;0)</strong>
                    </div>
                </div>
                <div class="row">
                    <div class="col text-right">
                        商品金額：&yen;0
                    </div>
                </div>
                <div class="row">
                    <div class="col text-right">
                        オプション金額：&yen;0
                    </div>
                </div>
                <div class="row">
                    <div class="col text-right">
                        合計金額：&yen;0
                    </div>
                </div>

            </div>
            </div>
            </div>
			<%-- <form:form action="${pageContext.request.contextPath}/order/orderPoReconfirm" method="post" modelAttribute="orderForm" class="form-horizontal"> --%>
            <div class="animated fadeIn">
            <div class="row">
            <div class="col-lg-6">
                                <ul class="nav nav-tabs nav-justified">
                                    <li class="nav-item">
                                        <a class="nav-link active" href="#" id="nav1_custom">お客様情報</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#" id="nav1_mejer">メジャーリング</a>
                                    </li>
                                </ul>
            </div>
            <div class="col-md-12">
            <div class="card" id="nav1_custom_div">
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-6">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">注文ID</label></div>
                            <div class="col-12 col-md-9">
                                <input type="text" id="orderId" name="customerMessageInfo.orderId" placeholder="自動採番" class="input-sm form-control-sm form-control" value="${orderForm.customerMessageInfo.orderId }" readonly>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">会員番号</label></div>
                            <div class="col-12 col-md-9">
                                <input type="text" id="custCd" name="customerMessageInfo.custCd" placeholder="会員番号" class="input-sm form-control-sm form-control">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">お客様氏名</label></div>
                            <div class="col-12 col-md-9">
                                <input type="text" id="custNm" name="customerMessageInfo.custNm" placeholder="お客様氏名" class="input-sm form-control-sm form-control">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フリガナ</label></div>
                            <div class="col-12 col-md-9">
                                <input type="text" id="custKanaNm" name="customerMessageInfo.custKanaNm" placeholder="フリガナ" class="input-sm form-control-sm form-control">
                            </div>
                        </div>
                         <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">名簿納期</label></div>
                            <div class="col-12 col-md-9">
                                <input type="date" id="custDeliverDate" name="customerMessageInfo.custDeliverDate" placeholder="名簿納期" class="input-sm form-control-sm form-control">
                            </div>
                        </div>
                    </div>
                    <div class="col col-lg-6">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">お渡し日</label></div>
                            <div class="col-12 col-md-9">
                                <input type="date" id="custShopDeliveryDate" name="customerMessageInfo.custShopDeliveryDate" placeholder="お渡し日" class="input-sm form-control-sm form-control">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">スタッフ</label></div>
                            <div class="col-12 col-md-9">
                                <input type="text" id="custStaff" name="customerMessageInfo.custStaff" placeholder="スタッフ" class="input-sm form-control-sm form-control">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">区分</label></div>
                            <div class="col-12 col-md-9">
                                <select name="customerMessageInfo.custType" id="custType" class="form-control-sm form-control">
                                    <option value="01">一般</option>
                                    <option value="02">社着</option>
                                    <option value="03">サンプル</option>
                                    <option value="04">ゲージ</option>
                                    <option value="05">本社内見会</option>
                                    <option value="06">販売会</option>
                                    <option value="07">作り直し</option>
                                </select>
                            </div>
                        </div>

                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">出荷先</label></div>
                            <div class="col-12 col-md-9">
                                <select name="customerMessageInfo.custShippingDestination" id="destination" class="form-control-sm form-control">
                                    <option value="01">店舗</option>
                                    <option value="02">福山本社</option>
                                    <option value="03">TSC事業本部</option>
                                    <option value="04">お客様</option>
                                    <option value="05">他店舗</option>
                                </select>
                            </div>
                            <c:if test="${order.custShippingDestination == 05}">
                            	<div class="col-12 col-md-9 offset-md-3" id="shopNameDiv">
                                <select name="customerMessageInfo.custShippingDestnationOtherstore" id="shopName" data-placeholder="店舗を選択" class="standardSelect" >
                                </select>
                            </div>
                            </c:if>
                            <c:if test="${order.custShippingDestination != 05}">
                            	<div class="col-12 col-md-9 offset-md-3" id="shopNameDiv" style="display:none;">
                                	<select name="customerMessageInfo.custShippingDestnationOtherstore" id="shopName" data-placeholder="店舗を選択" class="standardSelect" >
                                	</select>
                            	</div>
                            </c:if>
                        </div>

                    </div>
                </div>
                <!-- <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-2"><label class=" form-control-label">お客様備考</label></div>
                            <div class="col-12 col-md-10">
                                <textarea name="customerMessageInfo.custRemark" id="custRemark" rows="3" placeholder="お客様備考..." class="form-control"></textarea>
                            </div>
                        </div>
                    </div>
                </div> -->
            </div></div>
            <div class="card" id="nav1_mejer_div">
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-4">
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">フルレングス</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="fullLengthTe" name="fullLengthTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="fullLengthSe" id="fullLengthSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ショルダー</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="shoulderTe" name="shoulderTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="shoulderSe" id="shoulderSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">リーチ（右）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="reachRightTe" name="reachRightTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="reachRightSe" id="reachRightSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">リーチ（左）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="reachLeftTe" name="reachLeftTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="reachLeftSe" id="reachLeftSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col col-lg-4">
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">アウトバスト</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="outBustTe" name="outBustTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="outBustSe" id="outBustSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">バスト</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="bustTe" name="bustTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="bustSe" id="bustSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">JKウエスト</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="jacketWaistTe" name="jacketWaistTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="jacketWaistSe" id="jacketWaistSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">PTウエスト</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="pantsWaistTe" name="pantsWaistTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="pantsWaistSe" id="pantsWaistSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ヒップ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="hipTe" name="hipTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="hipSe" id="hipSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col col-lg-4">
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ワタリ（右）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="spanRightTe" name="spanRightTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="spanRightSe" id="spanRightSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ワタリ（左）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="spanLeftTe" name="spanLeftTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="spanLeftSe" id="spanLeftSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ふくらはぎ（右）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="calfRightTe" name="calfRightTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="calfRightSe" id="calfRightSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ふくらはぎ（左）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="calfLeftTe" name="calfLeftTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="calfLeftSe" id="calfLeftSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-6"><label class=" form-control-label">ネック</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <input type="text" id="neckTe" name="neckTe" placeholder="" class="form-control-sm form-control" style="width:48px" maxlength="3">.
                                <select name="neckSe" id="neckSe" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value=""></option>
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div></div>
            </div>
            </div>

            <div class="row">
            <div class="col-lg-8">
                                <ul class="nav nav-tabs nav-justified">
                                    <li class="nav-item">
                                        <a class="nav-link active" href="#" id="nav2_product">商品</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#" id="nav2_option">オプション</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#" id="nav2_alter">補正</a>
                                    </li>
                                </ul>
            </div>
            <div class="col-md-12">
            <div class="card" id="nav2_product_div">
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ITEM</label></div>
                            <div class="col-12 col-md-3">
                                <form:select id="item" path="productItem" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.productItemMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group" id="threePiece_div">
                            <div class="col col-md-3"><label class=" form-control-label">３Piece</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="threePiece_no" class="form-check-label ">
                                        <input type="radio" id="threePiece_no" name="productIs3Piece" value="0" class="form-check-input" checked>無し
                                    </label>　
                                    <label for="threePiece_yes" class="form-check-label ">
                                        <input type="radio" id="threePiece_yes" name="productIs3Piece" value="1" class="form-check-input">有り
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group" id="sparePants_div">
                            <div class="col col-md-3"><label class=" form-control-label">スペアパンツ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="sparePants_no" class="form-check-label ">
                                        <input type="radio" id="sparePants_no" name="productSparePantsClass" value="0" class="form-check-input" checked>無し
                                    </label>　
                                    <label for="sparePants_2p" class="form-check-label ">
                                        <input type="radio" id="sparePants_2p" name="productSparePantsClass" value="1" class="form-check-input">2パンツ
                                    </label>
                                    <!--　20190410 未確定だが、3パンツを止めるかもしれないため、一旦コメントアウト
                                    <label for="sparePants_3p" class="form-check-label ">
                                        <input type="radio" id="sparePants_3p" name="sparePants" value="3パンツ" class="form-check-input">3パンツ
                                    </label>
                                    -->
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">生地品番</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <input type="text" id="productFabricNo" name="productFabricNo" placeholder="" class="form-control-sm form-control" style="width:128px" maxlength="20">　
                                    <button type="button" class="btn btn-outline-info btn-sm" id="stockCheck">在庫チェック</button>　
                                    <output id="stockMsg" style="display:none;"></output>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">カテゴリ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_1"><i class="fa fa-question-circle"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <select name="productCategory" id="category" class="form-control-sm form-control">
                                        <option value="1">標準</option>
                                        <!-- <option value="ウォッシャブル">ウォッシャブル</option> -->
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group" id="brandName_div">
                            <div class="col col-md-3"><label class=" form-control-label">ブランドネーム</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="brandName_yes" class="form-check-label ">
                                        <input type="radio" id="brandName_yes" name="productBrandType" value="1" class="form-check-input" checked>有り
                                    </label>　
                                    <label for="brandName_no" class="form-check-label ">
                                        <input type="radio" id="brandName_no" name="productBrandType" value="0" class="form-check-input">無し
                                    </label>

                                </div>
                            </div>
                        </div>
                        <div class="row form-group" id="clothName_div">
                            <div class="col col-md-3"><label class=" form-control-label">生地ネーム</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="clothName_yes" class="form-check-label ">
                                        <input type="radio" id="clothName_yes" name="productFabricNmNecessity" value="1" class="form-check-input" checked>有り
                                    </label>　
                                    <label for="clothName_no" class="form-check-label ">
                                        <input type="radio" id="clothName_no" name="productFabricNmNecessity" value="0" class="form-check-input">無し
                                    </label>

                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍入れ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="embroidered_no" class="form-check-label ">
                                        <input type="radio" id="embroidered_no" name="productEmbroideryNecessity" value="0" class="form-check-input" checked>無し
                                    </label>　
                                    <label for="embroidered_yes" class="form-check-label ">
                                        <input type="radio" id="embroidered_yes" name="productEmbroideryNecessity" value="1" class="form-check-input">有り
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div id="embroidered_yes_area">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍ネーム</label></div>
                            <div class="col-12 col-md-6">
                                <input type="text" id="embroideryName" name="productEmbroideryNm" placeholder="刺繍ネーム" class="form-control-sm form-control" maxlength="40">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍書体</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="embroideryFont_14" class="form-check-label ">
                                        <input type="radio" id="embroideryFont_14" name="productEmbroideryFont" value="14" class="form-check-input">14（花文字）
                                    </label>　
                                    <label for="embroideryFont_48" class="form-check-label ">
                                        <input type="radio" id="embroideryFont_48" name="productEmbroideryFont" value="48" class="form-check-input">48（ブロック）
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">刺繍糸色</label></div>
                            <div class="col-12 col-md-3">
                                <select name="productEmbroideryThreadColor" id="embroideryColor" class="form-control-sm form-control">
                                    <option value="110">110（金茶）</option>
                                    <option value="140">140（白）</option>
                                </select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="embroideryColorMsg">
                            </div>
                        </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">生地ブランド</label></div>
                            <div class="col-12 col-md-9">
                                <p id="fabric_brand_nm_p" class="form-control-static"></p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">サービスネーム</label></div>
                            <div class="col-12 col-md-9">
                                <p id="service_nm_p" class="form-control-static"></p>
                            </div>
                        </div>
                        <div class="row form-group" id="composFrtFabric_div">
                            <div class="col col-md-3"><label class=" form-control-label">組成表示　表地</label></div>
                            <div class="col-12 col-md-9">
                                <p id="compos_frt_fabric_p" class="form-control-static"></p>
                            </div>
                        </div>
                        <div class="row form-group" id="composBodyLiner_div">
                            <div class="col col-md-3"><label class=" form-control-label">組成表示　胴裏地</label></div>
                            <div class="col-12 col-md-9">
                                <p id ="compos_body_liner_p" class="form-control-static"></p>
                            </div>
                        </div>
                        <div class="row form-group" id="composSleeveLiner_div">
                            <div class="col col-md-3"><label class=" form-control-label">組成表示　袖裏地</label></div>
                            <div class="col-12 col-md-9">
                                <p id ="compos_sleeve_liner_p" class="form-control-static"></p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">取扱注意</label></div>
                            <div class="col-12 col-md-9">
                                <p id="notice" class="form-control-static"></p>
                            </div>
                        </div>
                    </div>
                </div>

            </div></div>
            <div class="card" id="nav2_option_div">
            <div id="op_jacket_div">
            <div class="card-header">
                <strong class="card-title">JACKET</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">JACKETモデル</label>
                            </div>
                            <div class="col col-md-3">
                                
                                <form:select id="jacketModel" path="optionJacketStandardInfo.ojJacketModel" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketStandardInfo.ojJacketModelMap}"/>
                                </form:select>
                                
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="jacketModelMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント釦数</label>
                            </div>
                            <div class="col-12 col-md-3">
                                <form:select id="oj_frontBtnCnt" path="optionJacketStandardInfo.ojFrontBtnCnt" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionJacketStandardInfo.ojFrontBtnCntMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" id="oj_frontBtnCnt_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label>
                            </div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <div class="form-check-inline form-check">
                                    <form:radiobuttons id="lapelDesign_id" path="optionJacketStandardInfo.ojLapelDesign" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojLapelDesignMap}"/>
                                </div>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="lapelDesign_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">台場</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="fort_id" path="optionJacketStandardInfo.ojFort" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojFortMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="fort_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裏仕様</label>
                            </div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="backSpec_id" path="optionJacketStandardInfo.ojGackSpec" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojGackSpecMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="backSpec_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">腰ポケット</label>
                            </div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="waistPkt_id" path="optionJacketStandardInfo.ojWaistPkt" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojWaistPktMap}"/>
                            </div>
                            </div>
                            <div class="col-12 col-md-6" id="waistPkt_Msg" align="right">
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="waistPktMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label>
                            </div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="changePkt_id" path="optionJacketStandardInfo.ojChangePkt" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojChangePktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="changePkt_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="slantedPkt_id" path="optionJacketStandardInfo.ojSlantedPkt" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojSlantedPktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="slantedPkt_Msg" align="right">
                            </div>
                        </div>
                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="cuffSpec_id" path="optionJacketStandardInfo.ojCuffSpec" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojCuffSpecMap}"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-6" id="cuffSpec_Msg" align="right">
                        	</div>
                        </div>
                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMFステッチ</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="stitch_id" path="optionJacketStandardInfo.ojStitch" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojStitchMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="stitch_Msg" align="right">
                        	</div>
                        </div>
                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="ventSpec_id" path="optionJacketStandardInfo.ojVentSpec" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojVentSpecMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="ventSpec_Msg" align="right">
                        	</div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
                            <div class="col col-md-3">
                                <form:select id="bodyBackMate" path="optionJacketStandardInfo.ojBodyBackMate" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketStandardInfo.ojBodyBackMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionJacketStandardInfo.ojBodyBackMateStkNo" id="bodyBackMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2" id="bodyBackMate_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
                            <div class="col col-md-3">
                                <form:select id="cuffBackMate" path="optionJacketStandardInfo.ojCuffBackMate" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketStandardInfo.ojCuffBackMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-3">
                                <select name="optionJacketStandardInfo.ojCuffBackMateStkNo" id="cuffBackMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="btn_ojCuffBackMate">胴裏と同じ</button>
                            </div>
                            <div class="col col-md-1" id="cuffBackMate_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
                            <div class="col col-md-3">
                                <form:select id="btnMate" path="optionJacketStandardInfo.ojBtnMate" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketStandardInfo.ojBtnMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionJacketStandardInfo.ojBtnMateStkNo" id="btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2" id="btnMate_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="shapeMemory_id" path="optionJacketStandardInfo.ojShapeMemory" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojShapeMemoryMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="shapeMemory_Msg" align="right">
                        	</div>
                        </div>
                    </div>
                </div>

            </div></div>
            <div id="op_gilet_div">
            <div class="card-header">
                <strong class="card-title">GILET</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">GILETモデル</label>
                            </div>
                            <div class="col col-md-3">
                                
                                <form:select id="giletModel" path="optionGiletStandardInfo.ogGiletModel" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionGiletStandardInfo.ogGiletModelMap}"/>
                                </form:select>
                                
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="giletModelMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMFステッチ</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="og_stitch_id" path="optionGiletStandardInfo.ogStitch" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogStitchMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="og_stitch_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">背裏地素材</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="og_backLiningMate" path="optionGiletStandardInfo.ogBackLiningMate" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionGiletStandardInfo.ogBackLiningMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-3">
                                <select name="optionGiletStandardInfo.ogBackLiningMateStkNo" id="og_backLiningMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="btn_og_backLiningMate">上着と同じ</button>
                            </div>
                            <div class="col col-md-1" id="og_backLiningMate_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="og_insideLiningMate" path="optionGiletStandardInfo.ogInsideLiningMate" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionGiletStandardInfo.ogInsideLiningMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-3">
                                <select name="optionGiletStandardInfo.ogInsideLiningMateStkNo" id="og_insideLiningMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="btn_og_insideLiningMate">背裏地と同じ</button>
                            </div>
                            <div class="col col-md-1" id="og_insideLiningMate_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント釦</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="og_frontBtnMate" path="optionGiletStandardInfo.ogFrontBtnMate" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionGiletStandardInfo.ogFrontBtnMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-3">
                                <select name="optionGiletStandardInfo.ogFrontBtnMateStkNo" id="og_frontBtnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="btn_og_frontBtnMate">上着と同じ</button>
                            </div>
                            <div class="col col-md-1" id="og_frontBtnMate_Msg" align="right"></div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            <div id="op_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSモデル</label>
                            </div>
                            <div class="col col-md-3">
                                
                                <form:select id="op_pantsModel" path="optionPantsStandardInfo.opPantsModel" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPantsStandardInfo.opPantsModelMap}"/>
                                </form:select>
                                
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_pantsModelMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                                <form:select id="op_tack" path="optionPantsStandardInfo.opTack" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opTackMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-6" id="op_tack_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_adjuster_id" path="optionPantsStandardInfo.opAdjuster" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opAdjusterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="op_adjuster_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op_hemUp" path="optionPantsStandardInfo.opHemUp" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opHemUpMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-6" id="op_hemUp_Msg" align="right"></div>
                        </div>
                        <div class="row form-group"  id="op_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                                <form:select id="op_doubleWide" path="optionPantsStandardInfo.opDoubleWide" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opDoubleWideMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-6" id="op_doubleWide_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMFステッチ</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_stitch_id" path="optionPantsStandardInfo.opStitch" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opStitchMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="op_stitch_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op_btnMate" class="form-control-sm form-control" path="optionPantsStandardInfo.opButton">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opButtonMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-3">
                                <select name="optionPantsStandardInfo.opBtnMateStkNo" id="op_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="op_sameJacketBtn">JKと同じ</button>
                            </div>
                            <div class="col col-md-1" id="op_btnMate_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_eight_id" path="optionPantsStandardInfo.opEight" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opEightMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="op_eight_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_thick_id" path="optionPantsStandardInfo.opThick" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opThickMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="op_thick_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_shapeMemory_id" path="optionPantsStandardInfo.opShapeMemory" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opShapeMemoryMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="op_shapeMemory_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">靴ずれ</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_blister_id" path="optionPantsStandardInfo.opBlister" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opBlisterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="op_blister_Msg" align="right"></div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            <div id="op2_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS（2本目）</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSモデル</label>
                            </div>
                            <div class="col col-md-3">
                                
                                <form:select id="op2_pantsModel" path="optionPants2StandardInfo.op2PantsModel" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPants2StandardInfo.op2PantsModelMap}"/>
                                </form:select>
                                
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_pantsModel_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                                <form:select id="op2_tack" path="optionPants2StandardInfo.op2Tack" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPants2StandardInfo.op2TackMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" id="op2_tack_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_adjuster_id" path="optionPants2StandardInfo.op2Adjuster" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2AdjusterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="op2_adjuster_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op2_hemUp" path="optionPants2StandardInfo.op2HemUp" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPants2StandardInfo.op2HemUpMap }"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" id="op2_hemUp_Msg" align="right"></div>
                        </div>
                        <div class="row form-group"  id="op2_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                                <form:select id="op2_doubleWide" path="optionPants2StandardInfo.op2DoubleWide" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPants2StandardInfo.op2DoubleWideMap }"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" id="op2_doubleWide_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMFステッチ</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_stitch_id" path="optionPants2StandardInfo.op2Stitch" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2StitchMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="op2_stitch_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op2_btnMate" class="form-control-sm form-control" path="optionPants2StandardInfo.op2Button">
                                	<form:options items="${orderForm.optionPants2StandardInfo.op2ButtonMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-3">
                                <select name="optionPants2StandardInfo.op2BtnMateStkNo" id="op2_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="op_sameJacketBtn">JKと同じ</button>
                            </div>
                            <div class="col col-md-1" id="op2_btnMate_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_eight_id" path="optionPants2StandardInfo.op2Eight" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2EightMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="op2_eight_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_thick_id" path="optionPants2StandardInfo.op2Thick" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2ThickMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="op2_thick_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_shapeMemory_id" path="optionPants2StandardInfo.op2ShapeMemory" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2ShapeMemoryMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="op2_shapeMemory_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">靴ずれ</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_blister_id" path="optionPants2StandardInfo.op2Blister" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2BlisterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-6" id="op2_blister_Msg" align="right"></div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            <div id="op3_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS（3本目）</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSモデル</label>
                            </div>
                            <div class="col col-md-3">
                                <select name="op3_pantsModel" id="op3_pantsModel" class="form-control-sm form-control">
                                    <option value="選択">選択</option>
                                    <option value="CH14">CH14</option>
                                    <option value="SAVILEROW">SAVILEROW</option>
                                    <!-- <option value="NZ01">NZ01</option> -->
                                </select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op3_pantsModelMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                                <select name="op3_tack" id="op3_tack" class="form-control-sm form-control">
                                    <option value="ノータック">ノータック</option>
                                    <option value="1アウトタック">1アウトタック</option>
                                    <option value="2アウトタック">2アウトタック</option>
                                </select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op3_tackMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="op3_adjuster_no" class="form-check-label ">
                                        <input type="radio" id="op3_adjuster_no" name="op3_adjuster" value="無し" class="form-check-input" checked>無し
                                    </label>　
                                    <label for="op3_adjuster_nomal" class="form-check-label ">
                                        <input type="radio" id="op3_adjuster_nomal" name="op3_adjuster" value="アジャスター" class="form-check-input" disabled>アジャスター
                                    </label>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op3_adjusterMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            </div>
                            <div class="col col-md-3">
                                <select name="op3_hemUp" id="op3_hemUp" class="form-control-sm form-control">
                                    <option value="シングル">シングル</option>
                                    <option value="ダブル糸">ダブル糸</option>
                                    <option value="ダブルスナップ">ダブルスナップ</option>
                                    <option value="モーニングカット">モーニングカット</option>
                                </select>
                            </div>
                        </div>
                        <div class="row form-group"  id="op3_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                                <select name="op3_doubleWide" id="op3_doubleWide" class="form-control-sm form-control">
                                    <option value="無し">無し</option>
                                    <option value="2">2</option>
                                    <option value="2.5">2.5</option>
                                    <option value="3">3</option>
                                    <option value="3.5">3.5</option>
                                    <option value="4">4</option>
                                    <option value="4.5">4.5</option>
                                    <option value="5">5</option>
                                    <option value="5.5">5.5</option>
                                    <option value="6">6</option>
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMFステッチ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="op3_stitch_no" class="form-check-label ">
                                        <input type="radio" id="op3_stitch_no" name="op3_stitch" value="無し" class="form-check-input" checked>無し
                                    </label>　
                                    <label for="op3_stitch_yes" class="form-check-label ">
                                        <input type="radio" id="op3_stitch_yes" name="op3_stitch" value="有り" class="form-check-input">有り
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            </div>
                            <div class="col col-md-3">
                                <select name="op3_button" id="op3_button" class="form-control-sm form-control">
                                    <option value="ポリエステル">ポリエステル</option>
                                    <option value="本水牛">本水牛</option>
                                    <option value="ナット">ナット</option>
                                    <option value="メタル">メタル</option>
                                </select>
                            </div>
                            <div class="col col-md-4">
                                <select name="op3_btnMateStkNo" id="op3_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="op3_sameJacketBtn">JKと同じ</button>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="op3_shapeMemory_no" class="form-check-label ">
                                        <input type="radio" id="op3_shapeMemory_no" name="op3_shapeMemory" value="無し" class="form-check-input" checked>無し
                                    </label>　
                                    <label for="op3_shapeMemory_yes" class="form-check-label ">
                                        <input type="radio" id="op3_shapeMemory_yes" name="op3_shapeMemory" value="有り" class="form-check-input">有り
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">靴ずれ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="op3_shoeSlip_yes" class="form-check-label ">
                                        <input type="radio" id="op3_shoeSlip_yes" name="op3_shoeSlip" value="有り" class="form-check-input" checked>有り
                                    </label>　
                                    <label for="op3_shoeSlip_no" class="form-check-label ">
                                        <input type="radio" id="op3_shoeSlip_no" name="op3_shoeSlip" value="無し" class="form-check-input">無し
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            </div>
            <div class="card" id="nav2_alter_div">
            <div id="al_jacket_div">
            <div class="card-header">
                <strong class="card-title">JACKET</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">JACKETサイズ</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                <form:select id="selectJacketFigure" path="adjustJacketStandardInfo.sizeFigure" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustJacketStandardInfo.sizeFigureMap}"/>
                                </form:select>
                                <form:select id="selectJacketNumber" path="adjustJacketStandardInfo.sizeNumber" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustJacketStandardInfo.sizeNumberMap}"/>
                                </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">JACKET補正</label></div>
                            <div class="col-12 col-md-3">
                                <label class=" form-control-label">着丈修正</label>
                            </div>
                            <c:forEach var="corJkBodyMap" items="${orderForm.adjustJacketStandardInfo.corJkBodyMap}">
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkBodyRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkBodyRange" name="adjustJacketStandardInfo.corJkBodyCorrect" value="0" min="${corJkBodyMap.key}" max="${corJkBodyMap.value}" step="0.5">&nbsp;
                                <a href="#" id="corJkBodyRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkBodyRange_out" name="">0</output>cm
                                </div>
                            </div>
                            </c:forEach>
                            
                            <div class="col-12 col-md-2" id="corJkBody_div">
                            	<%-- <c:if test="${orderForm.adjustJacketStandardInfo.corJkBodyGross !=null }">
                            		<output>${orderForm.adjustJacketStandardInfo.corJkBodyGross}</output>cm
                            	</c:if>
                            	<c:if test="${orderForm.adjustJacketStandardInfo.corJkBodyGross ==null }">
                            		<output>000.0</output>cm
                            	</c:if> --%>
                                <!-- <output>000.0</output>cm -->
                                <label id="corJkBody_div_html">000.0cm</label>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">ウエスト修正</label>
                            </div>
                            <c:forEach var="corJkWaistMap" items="${orderForm.adjustJacketStandardInfo.corJkWaistMap}">
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkWaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkWaistRange" name="adjustJacketStandardInfo.corJkWaistCorrect" value="0" min="${corJkWaistMap.key }" max="${corJkWaistMap.value}" step="0.5">&nbsp;
                                <a href="#" id="corJkWaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkWaistRange_out">0</output>cm
                                </div>
                            </div>
                            </c:forEach>
                            <div class="col-12 col-md-2" id="corJkWaist_div">
                                <!-- <output>000.0</output>cm -->
                                <label id="corJkWaist_div_html">000.0cm</label>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">袖丈右修正</label>
                            </div>
                            <c:forEach var="corJkRightsleeveMap" items="${orderForm.adjustJacketStandardInfo.corJkRightsleeveMap}">
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkRightsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkRightsleeveRange" name="adjustJacketStandardInfo.corJkRightsleeveCorrect" value="0" min="${corJkRightsleeveMap.key}" max="${corJkRightsleeveMap.value}" step="0.5">&nbsp;
                                <a href="#" id="corJkRightsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkRightsleeveRange_out">0</output>cm
                                </div>
                            </div>
                            </c:forEach>
                            <div class="col-12 col-md-2" id="corJkRightsleeve_div">
                               <!--  <output>000.0</output>cm -->
                               <label id="corJkRightsleeve_div_html">000.0cm</label>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">袖丈左修正</label>
                            </div>
                            <c:forEach var="corJkLeftsleeveMap" items="${orderForm.adjustJacketStandardInfo.corJkLeftsleeveMap}">
								<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkLeftsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkLeftsleeveRange" name="adjustJacketStandardInfo.corJkLeftsleeveCorrect" value="0" min="${corJkLeftsleeveMap.key}" max="${corJkLeftsleeveMap.value}" step="0.5">&nbsp;
                                <a href="#" id="corJkLeftsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkLeftsleeveRange_out">0</output>cm
                                </div>
                            </div>                            
                            </c:forEach>
                            <div class="col-12 col-md-2" id="corJkLeftsleeve_div">
                            <label id="corJkLeftsleeve_div_html">000.0cm</label>
                                <!-- <output>000.0</output>cm -->
                            </div>
                        </div>
                    </div>
                </div>
            </div></div>
            <div id="al_gilet_div">
            <div class="card-header">
                <strong class="card-title">GILET</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">GILETサイズ</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                <form:select id="selectGiletFigure" path="adjustGiletStandardInfo.sizeFigure" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustGiletStandardInfo.sizeFigureMap}"/>
                                </form:select>
                                <form:select id="selectGiletNumber" path="adjustGiletStandardInfo.sizeNumber" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustGiletStandardInfo.sizeNumberMap}"/>
                                </form:select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div></div>
            <div id="al_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSサイズ</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                <form:select id="selectPantsFigure" path="adjustPantsStandardInfo.sizeFigure" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustPantsStandardInfo.sizeFigureMap}"/>
                                </form:select>
                                <form:select id="selectPantsNumber" path="adjustPantsStandardInfo.sizeNumber" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustPantsStandardInfo.sizeNumberMap}"/>
                                </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTS補正</label></div>
                            <div class="col-12 col-md-3">
                                <label class=" form-control-label">ウエスト修正</label>
                            </div>
                            <c:forEach var="corPtWaistMap" items="${orderForm.adjustPantsStandardInfo.corPtWaistMap }">
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtWaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtWaistRange" name="adjustPantsStandardInfo.corPtWaistCorrect" value="0" min="${corPtWaistMap.key}" max="${corPtWaistMap.value}" step="0.5">&nbsp;
                                <a href="#" id="corPtWaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtWaistRange_out">0</output>cm
                                </div>
                            </div>
                            </c:forEach>
                            <div class="col-12 col-md-2" id="corPtWaist_div">
                            	<label id="corPtWaist_div_html">000.0cm</label>
                                <!-- <output>000.0</output>cm -->
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">ワタリ修正</label>
                            </div>
                            <c:forEach var="corPtThighMap" items="${orderForm.adjustPantsStandardInfo.corPtThighMap}">
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtThighRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtThighRange" name="adjustPantsStandardInfo.corPtThighCorrect" value="0" min="${corPtThighMap.key }" max="${corPtThighMap.value }" step="0.5">&nbsp;
                                <a href="#" id="corPtThighRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtThighRange_out">0</output>cm
                                </div>
                            </div>
                            </c:forEach>
                            <div class="col-12 col-md-2" id="corPtThigh_div">
                            	<label id="corPtThigh_div_html">000.0cm</label>
                                <!-- <output>000.0</output>cm -->
                            </div>
                            <div class="col-12 col-md-2 offset-md-3">
                                <label class=" form-control-label">裾幅</label>
                            </div>
                            <div class="col-12 col-md-1">
                                <label for="ap_hemWidth_relative" class="form-check-label ">
                                    <input type="radio" id="corPtHemwidthType" name="adjustPantsStandardInfo.corPtHemwidthType" value="1" class="form-check-input">修正
                                </label>
                            </div>
                            <c:forEach var="corPtHemwidthMap" items="${orderForm.adjustPantsStandardInfo.corPtHemwidthMap}">
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtHemwidthRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtHemwidthRange" name="adjustPantsStandardInfo.corPtHemwidthCorrect" value="0" min="${corPtHemwidthMap.key}" max="${corPtHemwidthMap.value}" step="0.5">&nbsp;
                                <a href="#" id="corPtHemwidthRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtHemwidthRange_out">0</output>cm
                                </div>
                            </div>
                            </c:forEach>
                            <div class="col-12 col-md-2" id="corPtHemwidth_div" style="display:none">
                                <label id="corPtHemwidth_div_html">000.0cm</label>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">股下</label>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                左&nbsp;
                                <select name="ap_inseamLeft100" id="ap_inseamLeft100" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                </select>
                                <select name="ap_inseamLeft10" id="ap_inseamLeft10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>
                                <select name="ap_inseamLeft1" id="ap_inseamLeft1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>.
                                <select name="ap_inseamLeftM1" id="ap_inseamLeftM1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                <div class="col-12 col-md-2" id="corPtLeftinseam_div" style="display:none">
                                
                            	</div>
                                　　右&nbsp;
                                <select name="ap_inseamRight100" id="ap_inseamRight100" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                </select>
                                <select name="ap_inseamRight10" id="ap_inseamRight10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>
                                <select name="ap_inseamRight1" id="ap_inseamRight1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>.
                                <select name="ap_inseamRightM1" id="ap_inseamRightM1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                <div class="col-12 col-md-2" id="corPtRightinseam_div" style="display:none">
                                	
                            	</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div></div>
            <div id="al2_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS（2本目）</strong>　　<button type="button" class="btn btn-outline-info btn-sm" id="btn_ap2_samePants">1本目と同じ</button>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSサイズ</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                <form:select id="selectPants2Figure" path="adjustPants2StandardInfo.sizeFigure" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustPants2StandardInfo.sizeFigureMap}"/>
                                </form:select>
                                <form:select id="selectPants2Number" path="adjustPants2StandardInfo.sizeNumber" class="form-control-sm form-control hidedown">
                                    	<form:options items="${orderForm.adjustPants2StandardInfo.sizeNumberMap}"/>
                                </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTS補正</label></div>
                            <div class="col-12 col-md-3">
                                <label class=" form-control-label">ウエスト修正</label>
                            </div>
                            <c:forEach var="corPt2WaistMap" items="${orderForm.adjustPants2StandardInfo.corPt2WaistMap }">
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPt2WaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPt2WaistRange" name="adjustPants2StandardInfo.corPt2WaistCorrect" value="0" min="${corPt2WaistMap.key}" max="${corPt2WaistMap.value}" step="0.5">&nbsp;
                                <a href="#" id="corPt2WaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPt2WaistRange_out">0</output>cm
                                </div>
                            </div>
                            </c:forEach>
                            <div class="col-12 col-md-2" id="corPt2Waist_div">
                            	<label id="corPt2Waist_div_html">000.0cm</label>
                                <!-- <output>000.0</output>cm -->
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">ワタリ修正</label>
                            </div>
                            <c:forEach var="corPt2ThighMap" items="${orderForm.adjustPants2StandardInfo.corPt2ThighMap}">
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPt2ThighRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPt2ThighRange" name="adjustPants2StandardInfo.corPt2ThighCorrect" value="0" min="${corPt2ThighMap.key }" max="${corPt2ThighMap.value }" step="0.5">&nbsp;
                                <a href="#" id="corPt2ThighRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPt2ThighRange_out">0</output>cm
                                </div>
                            </div>
                            </c:forEach>
                            <div class="col-12 col-md-2" id="corPt2Thigh_div">
                            	<label id="corPt2Thigh_div_html">000.0cm</label>
                                <!-- <output>000.0</output>cm -->
                            </div>
                            <div class="col-12 col-md-2 offset-md-3">
                                <label class=" form-control-label">裾幅</label>
                            </div>
                            <div class="col-12 col-md-1">
                                <label for="ap_hemWidth_relative" class="form-check-label ">
                                    <input type="radio" id="corPt2HemwidthType" name="adjustPants2StandardInfo.corPt2HemwidthType" value="1" class="form-check-input">修正
                                </label>
                            </div>
                            <c:forEach var="corPt2HemwidthMap" items="${orderForm.adjustPants2StandardInfo.corPt2HemwidthMap}">
                            	<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPt2HemwidthRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPt2HemwidthRange" name="adjustPants2StandardInfo.corPt2HemwidthCorrect" value="0" min="${corPt2HemwidthMap.key}" max="${corPt2HemwidthMap.value}" step="0.5">&nbsp;
                                <a href="#" id="corPt2HemwidthRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPt2HemwidthRange_out">0</output>cm
                                </div>
                            </div>
                            </c:forEach>
                            <div class="col-12 col-md-2" id="corPt2Hemwidth_div" style="display:none">
                                <label id="corPt2Hemwidth_div_html">000.0cm</label>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">股下</label>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                左&nbsp;
                                <select name="ap2_inseamLeft100" id="ap2_inseamLeft100" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                </select>
                                <select name="ap2_inseamLeft10" id="ap2_inseamLeft10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>
                                <select name="ap2_inseamLeft1" id="ap2_inseamLeft1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>.
                                <select name="ap2_inseamLeftM1" id="ap2_inseamLeftM1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                <div class="col-12 col-md-2" id="corPt2Leftinseam_div" style="display:none">
                                
                            	</div>
                                　　右&nbsp;
                                <select name="ap2_inseamRight100" id="ap2_inseamRight100" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                </select>
                                <select name="ap2_inseamRight10" id="ap2_inseamRight10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>
                                <select name="ap2_inseamRight1" id="ap2_inseamRight1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>.
                                <select name="ap2_inseamRightM1" id="ap2_inseamRightM1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                <div class="col-12 col-md-2" id="corPt2Rightinseam_div" style="display:none">
                                	
                            	</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div></div>
            <div id="al3_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS（3本目）</strong>　　<button type="button" class="btn btn-outline-info btn-sm" id="btn_ap3_samePants">1本目と同じ</button>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSサイズ</label></div>
                            <div class="col-12 col-md-3">
                                <div class="form-check-inline form-check">
                                <select name="ap3_pantsSizeA" id="ap3_pantsSizeA" class="form-control-sm form-control hidedown">
                                    <option value="">選択</option>
                                    <option value="YA">YA</option>
                                    <option value="A">A</option>
                                    <option value="AB">AB</option>
                                    <option value="BE">BE</option>
                                    <option value="E">E</option>
                                    <option value="K">K</option>
                                </select>
                                <select name="ap3_pantsSizeN" id="ap3_pantsSizeN" class="form-control-sm form-control hidedown">
                                    <option value="">選択</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                </select>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTS補正</label></div>
                            <div class="col-12 col-md-3">
                                <label class=" form-control-label">ウエスト修正</label>
                            </div>
                            <div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="ap3_waist_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="ap3_waist" name="ap3_waist" value="0" min="-5" max="5" step="0.5">&nbsp;
                                <a href="#" id="ap3_waist_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="ap3_waist_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-2">
                                <output>000.0</output>cm
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">ワタリ修正</label>
                            </div>
                            <div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="ap3_watari_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="ap3_watari" name="ap3_watari" value="0" min="-2" max="2" step="0.5">&nbsp;
                                <a href="#" id="ap3_watari_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="ap3_watari_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-2">
                                <output>000.0</output>cm
                            </div>
                            <div class="col-12 col-md-2 offset-md-3">
                                <label class=" form-control-label">裾幅</label>
                            </div>
                            <div class="col-12 col-md-1">
                                <label for="ap3_hemWidth_relative" class="form-check-label ">
                                    <input type="radio" id="ap3_hemWidth_relative" name="ap3_hemWidth" value="修正" class="form-check-input">修正
                                </label>
                            </div>
                            <div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="ap3_hemWidthRel_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="ap3_hemWidthRel" name="ap3_hemWidthRel" value="0" min="-5" max="7" step="0.5">&nbsp;
                                <a href="#" id="ap3_hemWidthRel_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="ap3_hemWidthRel_out">0</output>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-1 offset-md-5">
                                <label for="ap3_hemWidth_absolute" class="form-check-label ">
                                    <input type="radio" id="ap3_hemWidth_absolute" name="ap3_hemWidth" value="指定" class="form-check-input">指定
                                </label>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <select name="ap3_hemWidthAbs10" id="ap3_hemWidthAbs10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">1</option>
                                    <option value="2">2</option>
                                </select>
                                <select name="ap3_hemWidthAbs1" id="ap3_hemWidthAbs1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>cm
                                </div>
                            </div>
                            <div class="col-12 col-md-3 offset-md-3">
                                <label class=" form-control-label">股下</label>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                左&nbsp;
                                <select name="ap3_inseamLeft100" id="ap3_inseamLeft100" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                </select>
                                <select name="ap3_inseamLeft10" id="ap3_inseamLeft10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>
                                <select name="ap3_inseamLeft1" id="ap3_inseamLeft1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>.
                                <select name="ap3_inseamLeftM1" id="ap3_inseamLeftM1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                　　右&nbsp;
                                <select name="ap3_inseamRight100" id="ap3_inseamRight100" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                </select>
                                <select name="ap3_inseamRight10" id="ap3_inseamRight10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>
                                <select name="ap3_inseamRight1" id="ap3_inseamRight1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                </select>.
                                <select name="ap3_inseamRightM1" id="ap3_inseamRightM1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div></div>
            <!-- 一旦コメントアウト
            <div class="card-header">
                <strong class="card-title">店舗補正</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col-12 col-md-3">
                                <label class=" form-control-label">店舗補正入力欄</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <textarea name="textarea-input" id="textarea-input" rows="3" placeholder="再補正コメント" class="form-control"></textarea>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            -->
            </div>
            </div>
            </div>
            </div>

            <div class="row">
            <div class="col-md-12">
            <div class="card">
            
            <div class="card-body" id="normalBtnType_div">
                <div class="row">
                    <div class="col">
                <button type="button" id="temporarySave" class="btn btn-info btn-block"><i class="fa fa-save"></i> 一時保存</button>
                    </div>
                    <div class="col">
                <button type="button" id="temporarySave2" class="btn btn-warning btn-block"><i class="fa fa-save"></i> 取り置き</button>
                
                    </div>
                    <div class="col">
                <button id = "submit" type="submit" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i> 内容確認</button>
                    </div>
                    <div class="col">
                <button type="button" class="btn btn-danger btn-block"><i class="fa fa-trash-o"></i> 削除</button>
                    </div>
                </div>
            </div>
            
            <div class="card-body" id="linkBtnType_div" style="display:none;">
                <div class="row">
                    <div class="col">
                    </div>
                    <div class="col col-md-3">
                <button id="confirmButton" type="submit" class="btn btn-primary btn-block"><i class="fa fa-check-circle"></i> 内容確認</button>
                    </div>
                    <div class="col col-md-3">
                <button id="cancelButton" type="button" class="btn btn-danger btn-block"><i class="fa fa-trash-o"></i> 注文取消</button>
                    </div>
                    <div class="col">
                    </div>
                </div>
            </div>
            
            </div>
            </div>
            </div>
            <!-- JACKET -->
            <input type="hidden" id="corJkBody_div_Size"  name="adjustJacketStandardInfo.corJkBodySize"   value="" />
            <input type="hidden" id="corJkBody_div_Gross" name="adjustJacketStandardInfo.corJkBodyGross"  value="" />
            <input type="hidden" id="corJkWaist_div_Size"  name="adjustJacketStandardInfo.corJkWaistSize"   value="" />
            <input type="hidden" id="corJkWaist_div_Gross" name="adjustJacketStandardInfo.corJkWaistGross"  value="" />
			<input type="hidden" id="corJkRightsleeve_div_Size"  name="adjustJacketStandardInfo.corJkRightsleeveSize"   value="" />
            <input type="hidden" id="corJkRightsleeve_div_Gross" name="adjustJacketStandardInfo.corJkRightsleeveGross"  value="" />
			<input type="hidden" id="corJkLeftsleeve_div_Size"  name="adjustJacketStandardInfo.corJkLeftsleeveSize"   value="" />
            <input type="hidden" id="corJkLeftsleeve_div_Gross" name="adjustJacketStandardInfo.corJkLeftsleeveGross"  value="" />
            <!-- PANTS1 -->
            <input type="hidden" id="corPtWaist_div_Size"  name="adjustPantsStandardInfo.corPtWaistSize"  value="" />
            <input type="hidden" id="corPtWaist_div_Gross" name="adjustPantsStandardInfo.corPtWaistGross"  value="" />
            
            <input type="hidden" id="corPtThigh_div_Size"  name="adjustPantsStandardInfo.corPtThighSize"  value="" />
            <input type="hidden" id="corPtThigh_div_Gross" name="adjustPantsStandardInfo.corPtThighGross"  value="" />
            
            <input type="hidden" id="corPtHemwidth_div_Size" name="adjustPantsStandardInfo.corPtHemwidthSize"  value="" />
            <input type="hidden" id="corPtHemwidth_div_Gross" name="adjustPantsStandardInfo.corPtHemwidthGross"  value="" />
            
            <input type="hidden" id="corPtRightinseam_div_Size"  name="adjustPantsStandardInfo.corPtRightinseamSize"  value="" />
            <input type="hidden" id="corPtRightinseamGross" name="adjustPantsStandardInfo.corPtRightinseamGross"  value="" />
            
            
            <input type="hidden" id="corPtLeftinseam_div_Size" name="adjustPantsStandardInfo.corPtLeftinseamSize"  value="" />
            <input type="hidden" id="corPtLeftinseamGross" name="adjustPantsStandardInfo.corPtLeftinseamGross"  value="" />
            
            <!-- PANTS2 -->
			<input type="hidden" id="corPt2Waist_div_Size"  name="adjustPants2StandardInfo.corPt2WaistSize"  value="" />
            <input type="hidden" id="corPt2Waist_div_Gross" name="adjustPants2StandardInfo.corPt2WaistGross"  value="" />
            
            <input type="hidden" id="corPt2Thigh_div_Size"  name="adjustPants2StandardInfo.corPt2ThighSize"  value="" />
            <input type="hidden" id="corPt2Thigh_div_Gross" name="adjustPants2StandardInfo.corPt2ThighGross"  value="" />
            
            <input type="hidden" id="corPt2Hemwidth_div_Size" name="adjustPants2StandardInfo.corPt2HemwidthSize"  value="" />
            <input type="hidden" id="corPt2Hemwidth_div_Gross" name="adjustPants2StandardInfo.corPt2HemwidthGross"  value="" />
            
            <input type="hidden" id="corPt2Rightinseam_div_Size"  name="adjustPants2StandardInfo.corPt2RightinseamSize"  value="" />
            <input type="hidden" id="corPt2RightinseamGross" name="adjustPants2StandardInfo.corPt2RightinseamGross"  value="" />
            
            
            <input type="hidden" id="corPt2Leftinseam_div_Size" name="adjustPants2StandardInfo.corPt2LeftinseamSize"  value="" />
            <input type="hidden" id="corPt2LeftinseamGross" name="adjustPants2StandardInfo.corPt2LeftinseamGross"  value="" />    
            
            <!-- メジャーリング -->   
            
            <input type="hidden" id="fullLength" name="MeasuringInfo.fullLength"  value="" />
            <input type="hidden" id="shoulder" name="MeasuringInfo.shoulder"  value="" />
            <input type="hidden" id="reachRight" name="MeasuringInfo.reachRight"  value="" />
            <input type="hidden" id="reachLeft" name="MeasuringInfo.reachLeft"  value="" />
            <input type="hidden" id="outBust" name="MeasuringInfo.outBust"  value="" />
            <input type="hidden" id="bust" name="MeasuringInfo.bust"  value="" />
            <input type="hidden" id="jacketWaist" name="MeasuringInfo.jacketWaist"  value="" />
            <input type="hidden" id="pantsWaist" name="MeasuringInfo.pantsWaist"  value="" />
            <input type="hidden" id="hip" name="MeasuringInfo.hip"  value="" />
            <input type="hidden" id="spanRight" name="MeasuringInfo.spanRight"  value="" />
            <input type="hidden" id="spanLeft" name="MeasuringInfo.spanLeft"  value="" />
            <input type="hidden" id="calfRight" name="MeasuringInfo.calfRight"  value="" />
            <input type="hidden" id="calfLeft" name="MeasuringInfo.calfLeft"  value="" />
            <input type="hidden" id="neck" name="MeasuringInfo.neck"  value="" />
                
			<input type="hidden" id="statusInput" name="status"  value="" />
			
			<!-- 商品 -->
			<!-- 生地ブランド  -->
			<input type="hidden" id="productFabricBrandNm"  name="productFabricBrandNm"   value="" />
			<!-- サービスネーム -->
			<input type="hidden" id="productServiceNm"  name="productServiceNm"   value="" />
			<!-- 組成表示_胴裏地 -->
			<input type="hidden" id="productComposBodyLiner"  name="productComposBodyLiner"   value="" />
			<!-- 組成表示_袖裏地 -->
			<input type="hidden" id="productComposSleeveLiner"  name="productComposSleeveLiner"   value="" />
			<!-- 組成表示_表地 -->
			<input type="hidden" id="productComposFrtFabric"  name="productComposFrtFabric"   value="" />
			<!-- 取扱注意 -->
			<input type="hidden" id="productNotice"  name="productNotice"   value="" />
			
			<input type="hidden" id="shopCode"  name="shopCode"   value="${sessionContent.belongCode}" />
			
			<input type="hidden" id="storeBrandCode"  name="storeBrandCode"   value="${sessionContent.storeBrandCode}" />
			
	</div>
</form:form>
<!-- 説明テキスト -->
<div class="modal fade" id="infotext_1" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
<div class="modal-dialog modal-lg" role="document">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title" id="mediumModalLabel">カテゴリ</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body">
<p>
カテゴリの説明<br />
カテゴリの説明<br />
カテゴリの説明<br />
カテゴリの説明<br />
カテゴリの説明
</p>
</div>
<div class="modal-footer">
<button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
</div>
</div>
</div>
</div>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.validate.unobtrusive.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/main.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/chosen.jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.timers-1.2.js"></script>
<script>
/************************************************
 * ルールMAP
 ************************************************/
var selectIdList = {
		"op_tack":"00001",
		"op_hemUp":"00017",
		"oj_frontBtnCnt":"00001",
 		"op_doubleWide":"00018",
 		"op2_tack":	"00001",
 		"op2_hemUp":"00017",
 		"op2_doubleWide":"00018",
	 	"lapelDesign":"00002",
	 	"fort":"00005",
	 	"backSpec":"00004",
	 	"waistPkt":"00012",
	 	"changePkt":"00013",
	 	"slantedPkt":"00014",
	 	"cuffSpec":"00019",
	 	"stitch":"00023",
	 	"ventSpec":"00037",
	 	"shapeMemory":"00044",
	 	"op2_adjuster":"00006",
	 	"op2_stitch":"00019",
	 	"op2_eight":"00036",
	 	"op2_thick":"00041",
	 	"op2_shapeMemory":"00037",
	 	"op2_blister":"00038",
	 	"op_adjuster":"00006",
		"op_stitch":"00019",
		"op_eight":"00036",
		"op_thick":"00041",
		"op_shapeMemory":"00037",
		"op_blister":"00038",
		"og_stitch":"00005",
		"bodyBackMate":"00038",
		"cuffBackMate":"00040",
		"btnMate":"00042",
		"op_btnMate":"00033",
		"op2_btnMate":"00033",
		"og_backLiningMate":"00017",
		"og_insideLiningMate":"00019",
		"og_frontBtnMate":"00021",
				
};

var subList = {
		"op_tack":"03",
		"op_hemUp":"03",
		"oj_frontBtnCnt":"02",
		"op_doubleWide":"03",
		"op2_tack":"07",
		"op2_hemUp":"07",
		"op2_doubleWide":"07",
		"lapelDesign":"02",
	 	"fort":"02",
	 	"backSpec":"02",
	 	"waistPkt":"02",
	 	"changePkt":"02",
	 	"slantedPkt":"02",
	 	"cuffSpec":"02",
	 	"stitch":"02",
	 	"ventSpec":"02",
	 	"shapeMemory":"02",
	 	"op2_adjuster":"07",
	 	"op2_stitch":"07",
	 	"op2_eight":"07",
	 	"op2_thick":"07",
	 	"op2_shapeMemory":"07",
	 	"op2_blister":"07",
	 	"op_adjuster":"03",
	 	"op_stitch":"03",
	 	"op_eight":"03",
	 	"op_thick":"03",
	 	"op_shapeMemory":"03",
	 	"op_blister":"03",
	 	"og_stitch":"04",
	 	"bodyBackMate":"02",
		"cuffBackMate":"02",
		"btnMate":"02",
		"op_btnMate":"03",
		"op2_btnMate":"07",
		"og_backLiningMate":"04",
		"og_insideLiningMate":"04",
		"og_frontBtnMate":"04",
};
var jacketDefaultList = {
  activeList : [{id:"oj_frontBtnCnt",dVal:"0000102",type:"2"},
				{id:"optionJacketStandardInfo.ojFort",dVal:"0000504",type:"1"},
				{id:"optionJacketStandardInfo.ojGackSpec",dVal:"0000401",type:"1"},
				{id:"optionJacketStandardInfo.ojWaistPkt",dVal:"0001201",type:"1"},
				{id:"optionJacketStandardInfo.ojChangePkt",dVal:"0001301",type:"1"},
				{id:"optionJacketStandardInfo.ojSlantedPkt",dVal:"0001401",type:"1"},
				{id:"optionJacketStandardInfo.ojCuffSpec",dVal:"0001902",type:"1"},
				{id:"optionJacketStandardInfo.ojStitch",dVal:"0002302",type:"1"},
				{id:"bodyBackMate",dVal:"1000100",type:"2"},
				{id:"cuffBackMate",dVal:"2000100",type:"2"},
				{id:"btnMate",dVal:"3000800",type:"2"},
				{id:"optionJacketStandardInfo.ojShapeMemory",dVal:"0004401",type:"1"}
			]
}
var pantsDefaultList = {
		  activeList : [{id:"op_tack",dVal:"0000101",type:"2"},
						{id:"optionPantsStandardInfo.opAdjuster",dVal:"0000601",type:"1"},
						{id:"op_hemUp",dVal:"0001701",type:"2"},
						{id:"op_doubleWide",dVal:"4",type:"2"},
						{id:"optionPantsStandardInfo.opStitch",dVal:"0001903",type:"1"},
						{id:"op_btnMate",dVal:"3000800",type:"2"},
						{id:"optionPantsStandardInfo.opEight",dVal:"0003601",type:"1"},
						{id:"optionPantsStandardInfo.opThick",dVal:"0004101",type:"1"},
						{id:"optionPantsStandardInfo.opShapeMemory",dVal:"0003701",type:"1"},
						{id:"optionPantsStandardInfo.opBlister",dVal:"0003801",type:"1"},
						{id:"adjustPantsStandardInfo.corPtHemwidthType",dVal:"1",type:"1"}
					]
}
var pants2DefaultList = {
		  activeList : [{id:"op2_tack",dVal:"0000101",type:"2"},
						{id:"optionPants2StandardInfo.op2Adjuster",dVal:"0000601",type:"1"},
						{id:"op2_hemUp",dVal:"0001701",type:"2"},
						{id:"op2_doubleWide",dVal:"4",type:"2"},
						{id:"optionPants2StandardInfo.op2Stitch",dVal:"0001903",type:"1"},
						{id:"op2_btnMate",dVal:"3000800",type:"2"},
						{id:"optionPants2StandardInfo.op2Eight",dVal:"0003601",type:"1"},
						{id:"optionPants2StandardInfo.op2Thick",dVal:"0004101",type:"1"},
						{id:"optionPants2StandardInfo.op2ShapeMemory",dVal:"0003701",type:"1"},
						{id:"optionPants2StandardInfo.op2Blister",dVal:"0003801",type:"1"},
						{id:"adjustPants2StandardInfo.corPt2HemwidthType",dVal:"1",type:"1"}
					]
}
var giletDefaultList = {
		  activeList : [{id:"optionGiletStandardInfo.ogStitch",dVal:"0000503",type:"1"},
						{id:"og_backLiningMate",dVal:"1000100",type:"2"},
						{id:"og_insideLiningMate",dVal:"1000100",type:"2"},
						{id:"og_frontBtnMate",dVal:"3000800",type:"2"}
					]
}		


//オプション金額の表示
var jkPriceList = [
	{id:"jacketModel",type:"2"},
	{id:"oj_frontBtnCnt",type:"2"},
	{id:"lapelDesign",idVal:"optionJacketStandardInfo.ojLapelDesign",type:"1"},
	{id:"fort",idVal:"optionJacketStandardInfo.ojFort",type:"1"},
	{id:"backSpec",idVal:"optionJacketStandardInfo.ojGackSpec",type:"1"},
	{id:"waistPkt",idVal:"optionJacketStandardInfo.ojWaistPkt",type:"1"},
	{id:"changePkt",idVal:"optionJacketStandardInfo.ojChangePkt",type:"1"},
	{id:"slantedPkt",idVal:"optionJacketStandardInfo.ojSlantedPkt",type:"1"},
	{id:"cuffSpec",idVal:"optionJacketStandardInfo.ojCuffSpec",type:"1"},
	{id:"stitch",idVal:"optionJacketStandardInfo.ojStitch",type:"1"},
	{id:"ventSpec",idVal:"optionJacketStandardInfo.ojVentSpec",type:"1"},
	{id:"bodyBackMate",type:"2"},
	{id:"bodyBackMateStkNo",type:"2"},
	{id:"cuffBackMate",type:"2"},
	{id:"cuffBackMateStkNo",type:"2"},
	{id:"btnMate",type:"2"},
	{id:"btnMateStkNo",type:"2"},
	{id:"shapeMemory",idVal:"optionJacketStandardInfo.ojShapeMemory",type:"1"},
]
var ptPriceList = [
	{id:"op_pantsModel",type:"2"},
	{id:"op_tack",type:"2"},
	{id:"op_adjuster",idVal:"optionPantsStandardInfo.opAdjuster",type:"1"},
	{id:"op_hemUp",type:"2"},
	{id:"op_doubleWide",type:"2"},
	{id:"op_stitch",idVal:"optionPantsStandardInfo.opStitch",type:"1"},
	{id:"op_btnMate",type:"2"},
	{id:"op_btnMateStkNo",type:"2"},
	{id:"op_eight",idVal:"optionPantsStandardInfo.opEight",type:"1"},
	{id:"op_thick",idVal:"optionPantsStandardInfo.opThick",type:"1"},
	{id:"op_shapeMemory",idVal:"optionPantsStandardInfo.opShapeMemory",type:"1"},
	{id:"op_blister",idVal:"optionPantsStandardInfo.opBlister",type:"1"},
]

var pt2PriceList = [
	{id:"op2_pantsModel",type:"2"},
	{id:"op2_tack",type:"2"},
	{id:"op2_adjuster",idVal:"optionPants2StandardInfo.op2Adjuster",type:"1"},
	{id:"op2_hemUp",type:"2"},
	{id:"op2_doubleWide",type:"2"},
	{id:"op2_stitch",idVal:"optionPants2StandardInfo.op2Stitch",type:"1"},
	{id:"op2_btnMate",type:"2"},
	{id:"op2_btnMateStkNo",type:"2"},
	{id:"op2_eight",idVal:"optionPants2StandardInfo.op2Eight",type:"1"},
	{id:"op2_thick",idVal:"optionPants2StandardInfo.op2Thick",type:"1"},
	{id:"op2_shapeMemory",idVal:"optionPants2StandardInfo.op2ShapeMemory",type:"1"},
	{id:"op2_blister",idVal:"optionPants2StandardInfo.op2Blister",type:"1"},
]

var glPriceList = [
	{id:"giletModel",type:"2"},
	{id:"og_stitch",idVal:"optionGiletStandardInfo.ogStitch",type:"1"},
	{id:"og_backLiningMate",type:"2"},
	{id:"og_backLiningMateStkNo",type:"2"},
	{id:"og_insideLiningMate",type:"2"},
	{id:"og_insideLiningMateStkNo",type:"2"},
	{id:"og_frontBtnMate",type:"2"},
	{id:"og_frontBtnMateStkNo",type:"2"}
]



/************************************************
 * 選択モデル一時保存変数
 ************************************************/
// JACKET 標準
var tmpJacketModel = '選択';
// JACKET タキシード
var tmpTjJacketModel = '選択';
// JACKET ウォッシャブル
var tmpWjJacketModel = '選択';

// GILET 標準
var tmpGiletModel = '選択';
// GILET タキシード
var tmpTgGiletModel = '選択';
// GILET ウォッシャブル
var tmpWgGiletModel = '選択';

// PANTS 標準
var tmpOpPantsModel = '選択';
// PANTS2本目 標準
var tmpOp2PantsModel = '選択';
// PANTS3本目 標準
var tmpOp3PantsModel = '選択';
// PANTS タキシード
var tmpTpPantsModel = '選択';
// PANTS2本目 タキシード
var tmpTp2PantsModel = '選択';
// PANTS3本目 タキシード
var tmpTp3PantsModel = '選択';
// PANTS ウォッシャブル
var tmpWpPantsModel = '選択';
// PANTS2本目 ウォッシャブル
var tmpWp2PantsModel = '選択';
// PANTS3本目 ウォッシャブル
var tmpWp3PantsModel = '選択';
// 項目 id option list
var data = {
		"oj_frontBtnCnt":"00001",
		"lapelDesign_id":"00002",
		"fort_id":"00005",
		"backSpec_id":"00004",
		"waistPkt_id":"00012",
		"changePkt_id":"00013",
		"slantedPkt_id":"00014",
		"cuffSpec_id":"00019",
		"stitch_id":"00023",
		"ventSpec_id":"00037",
		"bodyBackMate":"00038",
		"cuffBackMate":"00040",
		"btnMate":"00042",
		"shapeMemory_id":"00044",
		"og_stitch_id":"00005",
		"og_backLiningMate":"00017",
		"og_insideLiningMate":"00019",
		"og_frontBtnMate":"00021",
		"op_btnMate":"00033",
		"op2_btnMate":"00033"
};


/************************************************
 * 読み込み時イベント設定
 ************************************************/
 var contextPath = jQuery("meta[name='contextPath']").attr("content");
 var orderPattern = "PO"
 jQuery(document).ready(function() {
		var flag = localStorage.getItem("key");
		//内容確認画面戻るとき
		if(flag =='poReconfirm'){

			var showNameCode = localStorage.getItem("showNameCode");
			jQuery("#shopName").val(showNameCode);
			jQuery("#shopName").trigger("chosen:updated");
			
			//メジャーリングの値を設定
			var list = ["fullLength","shoulder","reachRight","reachLeft","outBust",
				        "bust","jacketWaist","pantsWaist","hip","spanRight","spanLeft",
				        "calfRight","calfLeft","neck"
				       ]
			for(var i in list){
				jQuery("#"+list[i]).val(jQuery("#"+list[i]+"Te").val()+"."+jQuery("#"+list[i]+"Se").val());
			}
			
			//PANTS、2PANTS股下左と股下右の値を設定
			var ap_inseamLeft100 = jQuery("#ap_inseamLeft100").val();
			var ap_inseamLeft10 = jQuery("#ap_inseamLeft10").val();
			var ap_inseamLeft1 = jQuery("#ap_inseamLeft1").val();
			var ap_inseamLeftM1 = jQuery("#ap_inseamLeftM1").val();
			var corPtLeftinseamGross = ap_inseamLeft100+ap_inseamLeft10+ap_inseamLeft1+"."+ap_inseamLeftM1;
			jQuery("#corPtLeftinseamGross").val(corPtLeftinseamGross);
			
			var ap_inseamRight100 = jQuery("#ap_inseamRight100").val();
			var ap_inseamRight10 = jQuery("#ap_inseamRight10").val();
			var ap_inseamRight1 = jQuery("#ap_inseamRight1").val();
			var ap_inseamRightM1 = jQuery("#ap_inseamRightM1").val();
			var corPtRightinseamGross = ap_inseamRight100+ap_inseamRight10+ap_inseamRight1+"."+ap_inseamRightM1;
			jQuery("#corPtRightinseamGross").val(corPtRightinseamGross);
			
			
			var ap2_inseamLeft100 = jQuery("#ap2_inseamLeft100").val();
			var ap2_inseamLeft10 = jQuery("#ap2_inseamLeft10").val();
			var ap2_inseamLeft1 = jQuery("#ap2_inseamLeft1").val();
			var ap2_inseamLeftM1 = jQuery("#ap2_inseamLeftM1").val();
			var corPt2LeftinseamGross = ap2_inseamLeft100+ap2_inseamLeft10+ap2_inseamLeft1+"."+ap2_inseamLeftM1;
			jQuery("#corPt2LeftinseamGross").val(corPt2LeftinseamGross);
			
			var ap2_inseamRight100 = jQuery("#ap2_inseamRight100").val();
			var ap2_inseamRight10 = jQuery("#ap2_inseamRight10").val();
			var ap2_inseamRight1 = jQuery("#ap2_inseamRight1").val();
			var ap2_inseamRightM1 = jQuery("#ap2_inseamRightM1").val();
			var corPt2RightinseamGross = ap2_inseamRight100+ap2_inseamRight10+ap2_inseamRight1+"."+ap2_inseamRightM1;
			jQuery("#corPt2RightinseamGross").val(corPt2RightinseamGross);

			//補正　補正値
			var corJkBodyCorrect = localStorage.getItem("corJkBodyCorrect", corJkBodyCorrect);
			jQuery("#corJkBodyRange").val(corJkBodyCorrect);
			var corJkWaistCorrect = localStorage.getItem("corJkWaistCorrect", corJkWaistCorrect);
			jQuery("#corJkWaistRange").val(corJkWaistCorrect);
			var corJkRightsleeveCorrect = localStorage.getItem("corJkRightsleeveCorrect", corJkRightsleeveCorrect);
			jQuery("#corJkRightsleeveRange").val(corJkRightsleeveCorrect);
			var corJkLeftsleeveCorrect = localStorage.getItem("corJkLeftsleeveCorrect", corJkLeftsleeveCorrect);
			jQuery("#corJkLeftsleeveRange").val(corJkLeftsleeveCorrect);
			var corPtWaistCorrect = localStorage.getItem("corPtWaistCorrect", corPtWaistCorrect);
			jQuery("#corPtWaistRange").val(corPtWaistCorrect);
			var corPtThighCorrect = localStorage.getItem("corPtThighCorrect", corPtThighCorrect);
			jQuery("#corPtThighRange").val(corPtThighCorrect);
			var corPtHemwidthCorrect = localStorage.getItem("corPtHemwidthCorrect", corPtHemwidthCorrect);
			jQuery("#corPtHemwidthRange").val(corPtHemwidthCorrect);
			var corPt2HemwidthCorrect = localStorage.getItem("corPt2HemwidthCorrect", corPt2HemwidthCorrect);
			jQuery("#corPt2HemwidthRange").val(corPt2HemwidthCorrect);
			var corPt2ThighCorrect = localStorage.getItem("corPt2ThighCorrect", corPt2ThighCorrect);
			jQuery("#corPt2ThighRange").val(corPt2ThighCorrect);
			var corPt2WaistCorrect = localStorage.getItem("corPt2WaistCorrect",corPt2WaistCorrect);
			jQuery("#corPt2WaistRange").val(corPt2WaistCorrect);
			
			
			//補正　グロス値
			var corJkBodyGross = localStorage.getItem("corJkBodyGross");
			jQuery("#corJkBody_div_Gross").val(corJkBodyGross);
			var corJkWaistGross = localStorage.getItem("corJkWaistGross");
			jQuery("#corJkWaist_div_Gross").val(corJkWaistGross);
			var corJkRightsleeveGross = localStorage.getItem("corJkRightsleeveGross");
			jQuery("#corJkRightsleeve_div_Gross").val(corJkRightsleeveGross);
			var corJkLeftsleeveGross = localStorage.getItem("corJkLeftsleeveGross");
			jQuery("#corJkLeftsleeve_div_Gross").val(corJkLeftsleeveGross);
			var corPtWaistGross = localStorage.getItem("corPtWaistGross");
			jQuery("#corPtWaist_div_Gross").val(corPtWaistGross);
			var corPtThighGross = localStorage.getItem("corPtThighGross");
			jQuery("#corPtThigh_div_Gross").val(corPtThighGross);
			var corPtHemwidthGross = localStorage.getItem("corPtHemwidthGross");
			jQuery("#corPtHemwidth_div_Gross").val(corPtHemwidthGross);
			var corPt2WaistGross = localStorage.getItem("corPt2WaistGross");
			jQuery("#corPt2Waist_div_Gross").val(corPt2WaistGross);
			var corPt2ThighGross = localStorage.getItem("corPt2ThighGross");
			jQuery("#corPt2Thigh_div_Gross").val(corPt2ThighGross);
			var corPt2HemwidthGross = localStorage.getItem("corPt2HemwidthGross");
			jQuery("#corPt2Hemwidth_div_Gross").val(corPt2HemwidthGross);
			
			//補正　型サイズ
			var corJkBodySize = localStorage.getItem("corJkBodySize");
			jQuery("#corJkBody_div_Size").val(corJkBodySize);
			var corJkWaistSize = localStorage.getItem("corJkWaistSize");
			jQuery("#corJkWaist_div_Size").val(corJkWaistSize);
			var corJkRightsleeveSize = localStorage.getItem("corJkRightsleeveSize");
			jQuery("#corJkRightsleeve_div_Size").val(corJkRightsleeveSize);
			var corJkLeftsleeveSize = localStorage.getItem("corJkLeftsleeveSize");
			jQuery("#corJkLeftsleeve_div_Size").val(corJkLeftsleeveSize);
			var corPtWaistSize = localStorage.getItem("corPtWaistSize");
			jQuery("#corPtWaist_div_Size").val(corPtWaistSize);
			var corPtThighSize = localStorage.getItem("corPtThighSize");
			jQuery("#corPtThigh_div_Size").val(corPtThighSize);
			var corPtHemwidthSize = localStorage.getItem("corPtHemwidthSize");
			jQuery("#corPtHemwidth_div_Size").val(corPtHemwidthSize);
			var corPt2WaistSize = localStorage.getItem("corPt2WaistSize");
			jQuery("#corPt2Waist_div_Size").val(corPt2WaistSize);
			var corPt2ThighSize = localStorage.getItem("corPt2ThighSize");
			jQuery("#corPt2Thigh_div_Size").val(corPt2ThighSize);
			var corPt2HemwidthSize = localStorage.getItem("corPt2HemwidthSize");
			jQuery("#corPt2Hemwidth_div_Size").val(corPt2HemwidthSize);

			//補正値の表示
			jQuery("#corJkBody_div_html").html(corJkBodyGross+"cm");
			jQuery("#corJkWaist_div_html").html(corJkWaistGross+"cm");
			jQuery("#corJkRightsleeve_div_html").html(corJkRightsleeveGross+"cm");
			jQuery("#corJkLeftsleeve_div_html").html(corJkLeftsleeveGross+"cm");
			jQuery("#corPtWaist_div_html").html(corPtWaistGross+"cm");
			jQuery("#corPtThigh_div_html").html(corPtThighGross+"cm");
			jQuery("#corPtHemwidth_div_html").html(corPtHemwidthGross+"cm");
			jQuery("#corPt2Waist_div_html").html(corPt2WaistGross+"cm");
			jQuery("#corPt2Thigh_div_html").html(corPt2ThighGross+"cm");
			jQuery("#corPt2Hemwidth_div_html").html(corPt2HemwidthGross+"cm");

			//品番値を設定
			mateInit();
			
			//品番のデフォルト値を設定
			var ojBodyBackMateStkNo = localStorage.getItem("ojBodyBackMateStkNo");
			jQuery("#bodyBackMateStkNo option[value='"+ojBodyBackMateStkNo+"']").attr("selected", true);
				
			var ojCuffBackMateStkNo = localStorage.getItem("ojCuffBackMateStkNo");
			jQuery("#cuffBackMateStkNo option[value='"+ojCuffBackMateStkNo+"']").attr("selected", true);
				
			var ojBtnMateStkNo = localStorage.getItem("ojBtnMateStkNo");
			jQuery("#btnMateStkNo option[value='"+ojBtnMateStkNo+"']").attr("selected", true);
				
			var opBtnMateStkNo = localStorage.getItem("opBtnMateStkNo");
			jQuery("#op_btnMateStkNo option[value='"+opBtnMateStkNo+"']").attr("selected", true);
				
			var op2BtnMateStkNo = localStorage.getItem("op2BtnMateStkNo");
			jQuery("#op2_btnMateStkNo option[value='"+op2BtnMateStkNo+"']").attr("selected", true);
				
			var ogBackLiningMateStkNo = localStorage.getItem("ogBackLiningMateStkNo");
			jQuery("#og_backLiningMateStkNo option[value='"+ogBackLiningMateStkNo+"']").attr("selected", true);
				
			var ogInsideLiningMateStkNo = localStorage.getItem("ogInsideLiningMateStkNo");
			jQuery("#og_insideLiningMateStkNo option[value='"+ogInsideLiningMateStkNo+"']").attr("selected", true);
				
			var ogFrontBtnMateStkNo = localStorage.getItem("ogFrontBtnMateStkNo");
			jQuery("#og_frontBtnMateStkNo option[value='"+ogFrontBtnMateStkNo+"']").attr("selected", true);
				
			//他店舗のとき　出荷先_他店舗コード値を設定
			initCustomer();

			getPrice();
			
			localStorage.clear();
			
		}else if(flag == "orderLink"){
			var status = "${order.tscStatus}"
			if(status=='T2'){
				jQuery("#normalBtnType_div").hide();
				jQuery("#linkBtnType_div").show();
			}
			
			//注文ID
			var orderId = "${order.orderId}";
			jQuery("#orderId").val(orderId);
			//会員番号
			var custCd = "${order.custCd}";
			jQuery("#custCd").val(custCd)
			//お客様氏名
			var custNm = "${order.custNm}";
			jQuery("#custNm").val(custNm);
			//フリガナ
			var custKanaNm = "${order.custKanaNm}";
			jQuery("#custKanaNm").val(custKanaNm);
			//スタッフ
			var custStaff = "${order.custStaff}";
			jQuery("#custStaff").val(custStaff);
			//区分
			var custType = "${order.custType}"
			jQuery("#custType").val(custType);
			//名簿納期
			var custDeliverDate = "${order.custDeliverDate}";
			if(custDeliverDate!=null){
				custDeliverDate = dateFormat(custDeliverDate);
				jQuery("#custDeliverDate").val(custDeliverDate)
			}
			//お渡し日
			var custShopDeliveryDate = "${order.custShopDeliveryDate}"
			if(custShopDeliveryDate!=null){
				custShopDeliveryDate = dateFormat(custShopDeliveryDate);
				jQuery("#custShopDeliveryDate").val(custShopDeliveryDate);
			}
			//出荷先
			var destination = "${order.custShippingDestination}"
			jQuery("#destination").val(destination);
			initCustomer();
			//出荷先_他店舗コード
			var shopNameCode = "${order.custShippingDestnationOtherstore}"
			//jQuery("#shopName").val(shopNameCode);
			//jQuery("#shopName" + " option[value='" + shopNameCode + "']").attr('selected', 'selected');
			jQuery("#shopName").val(shopNameCode);
			jQuery("#shopName").trigger("chosen:updated");

			//メジャーリング
			measuring();

			//商品
			//ITEM
			var item = "${order.productItem}"
			jQuery("#item").val(item);
			//３Piece
			var threePiece = "${order.productIs3piece}" 
			jQuery("input[name='productIs3Piece'][value='" + threePiece + "']").prop("checked", true);
			//スペアパンツ
			var productSparePantsClass = "${order.productSparePantsClass}"
			jQuery("input[name='productSparePantsClass'][value='" + threePiece + "']").prop("checked", true);
			//生地品番
			var productFabricNo = "${order.productFabricNo}"
			jQuery("#productFabricNo").val(productFabricNo);
			jQuery.ajax({
				 type:"post",
				 url: contextPath + "/order/findStock",
				 data:{"item":item,"fabricNo":productFabricNo},
				 async:false,
				 success:function(result){
					 if(null != result && "" != result){
						 jQuery("#stockMsg").html("-" + result.color + result.pattern + "在庫 " + result.theoreticalStock + "m");
						 jQuery("#fabric_brand_nm_p").html(result.brandName);
						 jQuery("#productFabricBrandNm").val(result.brandName);
						 jQuery("#service_nm_p").html(result.brandName+" "+result.materialName);
						 jQuery("#productServiceNm").val(result.brandName+" "+result.materialName);
						 if(result.compositionLabel.indexOf("/") != -1 ){
							 jQuery("#compos_frt_fabric_p").empty();
							 var labelArray = new Array();
							 labelArray = result.compositionLabel.split("/");
							 for (i=0; i<labelArray.length; i++ ){
								 jQuery("#compos_frt_fabric_p").append(labelArray[i]+"%").append("<Br>");
							 }
						 }else{
							 jQuery("#compos_frt_fabric_p").html(result.compositionLabel+"%");
						 }
						 jQuery("#productComposFrtFabric").val(result.compositionLabel);
						 jQuery("#notice").html(result.handlingCaution);
						 jQuery("#productNotice").val(result.handlingCaution);
				     }else{
				    	 jQuery("#notice").empty();
				    	 jQuery("#fabric_brand_nm_p").empty();
				    	 jQuery("#service_nm_p").empty();
						 jQuery("#compos_frt_fabric_p").empty();
				    	 appendAlert('stockMsg', "生地品番、およびITEMに関連する生地が存在しません");
					 }
				 }
			});
			jQuery('#stockMsg').show();

			//生地ネーム
			var productFabricNmNecessity = "${order.productFabricNmNecessity}"
			jQuery("input[name='productFabricNmNecessity'][value='" + productFabricNmNecessity + "']").prop("checked", true);
			//刺繍入れ
			var productEmbroideryNecessity = "${order.productEmbroideryNecessity}"
			jQuery("input[name='productEmbroideryNecessity'][value='" + productEmbroideryNecessity + "']").prop("checked", true);
			//刺繍ネーム
			var embroideryName = "${order.productEmbroideryNm}"
			jQuery("#embroideryName").val(embroideryName);
			//刺繍書体
			var productEmbroideryFont = "${order.productEmbroideryFont}"
			jQuery("input[name='productEmbroideryFont'][value='" + productEmbroideryFont + "']").prop("checked", true);	
			//刺繍糸色
			var embroideryColor = "${order.productEmbroideryThreadColor}"
			jQuery("#embroideryColor").val(embroideryColor);
			//組成表示　胴裏地
			var bodyText = "${order.productComposBodyLiner}"
			jQuery("#compos_body_liner_p").html(bodyText);
			jQuery("#productComposBodyLiner").val(bodyText);
			//組成表示　袖裏地
			var sleeveText = "${order.productComposSleeveLiner}"
			jQuery("#compos_sleeve_liner_p").html(sleeveText);
			jQuery("#productComposSleeveLiner").val(sleeveText);

			
			//オプション
			var jacketDefaultOrderList = {
					  activeList : [
						  			{id:"jacketModel",dVal:"${order.jkModelCd}",type:"2"},
						  			{id:"oj_frontBtnCnt",dVal:"${order.jkFrtBtnCd}",type:"2"},
									{id:"optionJacketStandardInfo.ojLapelDesign",dVal:"${order.jkLapelDesignCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojFort",dVal:"${order.jkDaibaCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojGackSpec",dVal:"${order.jkInnerClothCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojWaistPkt",dVal:"${order.jkWaistPktCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojChangePkt",dVal:"${order.jkChgPktCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojSlantedPkt",dVal:"${order.jkSlantedPktCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojCuffSpec",dVal:"${order.jkCuffCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojStitch",dVal:"${order.jkStitchTypeCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojVentSpec",dVal:"${order.jkVentCd}",type:"1"},
									{id:"bodyBackMate",dVal:"${order.jkInnerBodyClothType}",type:"2"},
									{id:"cuffBackMate",dVal:"${order.jkInnerSleeveClothType}",type:"2"},
									{id:"btnMate",dVal:"${order.jkBtnMaterialType}",type:"2"},
									{id:"optionJacketStandardInfo.ojShapeMemory",dVal:"${order.jkShapeMemoryCd}",type:"1"}
								]
			}
			var pantsDefaultOrderList = {
					activeList : [
								{id:"op_pantsModel",dVal:"${order.ptModelCd}",type:"2"},
								{id:"op_tack",dVal:"${order.ptTackCd}",type:"2"},
								{id:"optionPantsStandardInfo.opAdjuster",dVal:"${order.ptAdjusterCd}",type:"1"},
								{id:"op_hemUp",dVal:"${order.ptHemUpCd}",type:"2"},
								{id:"op_doubleWide",dVal:"${order.ptDblWidthCd}",type:"2"},
								{id:"optionPantsStandardInfo.opStitch",dVal:"${order.ptAmfStitchCd}",type:"1"},
								{id:"op_btnMate",dVal:"${order.ptBtnMaterialType}",type:"2"},
								{id:"optionPantsStandardInfo.opEight",dVal:"${order.ptNonSlipCd}",type:"1"},
								{id:"optionPantsStandardInfo.opThick",dVal:"${order.ptChicSlipCd}",type:"1"},
								{id:"optionPantsStandardInfo.opShapeMemory",dVal:"${order.ptShapeMemoryCd}",type:"1"},
								{id:"optionPantsStandardInfo.opBlister",dVal:"${order.ptShoeSoreCd}",type:"1"},
								{id:"adjustPantsStandardInfo.corPtHemwidthType",dVal:"${order.corPtHemwidthType}",type:"1"}
							]
			}
			 var pants2DefaultOrderList = {
					activeList : [
								{id:"op2_pantsModel",dVal:"${order.pt2ModelCd}",type:"2"},
								{id:"op2_tack",dVal:"${order.pt2TackCd}",type:"2"},
								{id:"optionPants2StandardInfo.op2Adjuster",dVal:"${order.pt2AdjusterCd}",type:"1"},
								{id:"op2_hemUp",dVal:"${order.pt2HemUpCd}",type:"2"},
								{id:"op2_doubleWide",dVal:"${order.pt2DblWidthCd}",type:"2"},
								{id:"optionPants2StandardInfo.op2Stitch",dVal:"${order.pt2AmfStitchCd}",type:"1"},
								{id:"op2_btnMate",dVal:"${order.pt2BtnMaterialType}",type:"2"},
								{id:"optionPants2StandardInfo.op2Eight",dVal:"${order.pt2NonSlipCd}",type:"1"},
								{id:"optionPants2StandardInfo.op2Thick",dVal:"${order.pt2ChicSlipCd}",type:"1"},
								{id:"optionPants2StandardInfo.op2ShapeMemory",dVal:"${order.pt2ShapeMemoryCd}",type:"1"},
								{id:"optionPants2StandardInfo.op2Blister",dVal:"${order.pt2ShoeSoreCd}",type:"1"},
								{id:"adjustPants2StandardInfo.corPt2HemwidthType",dVal:"${order.corPt2HemwidthType}",type:"1"}
							]
			}
			var giletDefaultOrderList = {
				   activeList : [
					   			{id:"giletModel",dVal:"${order.glModelCd}",type:"2"},
					   			{id:"optionGiletStandardInfo.ogStitch",dVal:"${order.glAmfStitchCd}",type:"1"},
								{id:"og_backLiningMate",dVal:"${order.glBackClothType}",type:"2"},
								{id:"og_insideLiningMate",dVal:"${order.glInnnerClothType}",type:"2"},
								{id:"og_frontBtnMate",dVal:"${order.glFrtBtnType}",type:"2"}
							]
			} 
			//オプションのデフォルト値を設定
			var i = null;
			for (i of jacketDefaultOrderList.activeList) {
				if(i.type == "2"){
					jQuery("#"+i.id+" option[value="+i.dVal+"]").prop("selected", true);
				}else if(i.type == "1"){
					jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
				}
			}

			for (i of pantsDefaultOrderList.activeList) {
				if(i.type == "2"){
					jQuery("#"+i.id+" option[value="+i.dVal+"]").prop("selected", true);
				}else if(i.type == "1"){
					jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
				}
			}
			
			
			for (i of giletDefaultOrderList.activeList) {
				if(i.type == "2"){
					jQuery("#"+i.id+" option[value="+i.dVal+"]").prop("selected", true);
				}else if(i.type == "1"){
					jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
				}
			}

			for (i of pants2DefaultOrderList.activeList) {
				if(i.type == "2"){
					jQuery("#"+i.id+" option[value="+i.dVal+"]").prop("selected", true);
				}else if(i.type == "1"){
					jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
				}
			}
			
			//品番値を設定
			mateInit();
			
			//品番のデフォルト値を設定
			var ptBtnMaterialCd = "${order.ptBtnMaterialCd}";
			if(ptBtnMaterialCd!=""){
				jQuery("#op_btnMateStkNo option[value='"+ptBtnMaterialCd+"']").attr("selected", true);
			}
			var pt2BtnMaterialCd = "${order.pt2BtnMaterialCd}"
			if(pt2BtnMaterialCd!=""){
				jQuery("#op2_btnMateStkNo option[value='"+pt2BtnMaterialCd+"']").attr("selected", true);
			}


			var jkInnerBodyClothCd = "${order.jkInnerBodyClothCd}"
			if(jkInnerBodyClothCd!=""){
				jQuery("#bodyBackMateStkNo option[value='"+jkInnerBodyClothCd+"']").attr("selected", true);
			}
			var jkInnerSleeveClothCd = "${order.jkInnerSleeveClothCd}";
			if(jkInnerSleeveClothCd!=""){
				jQuery("#cuffBackMateStkNo option[value='"+jkInnerSleeveClothCd+"']").attr("selected", true);
			}
			var jkBtnMaterialCd = "${order.jkBtnMaterialCd}"
			if(jkBtnMaterialCd!=""){
				jQuery("#btnMateStkNo option[value='"+jkBtnMaterialCd+"']").attr("selected", true);
			}
			

			var glBackClothCd = "${order.glBackClothCd}"
			if(glBackClothCd!=""){
				jQuery("#og_backLiningMateStkNo option[value='"+glBackClothCd+"']").attr("selected", true);
			}
			var glInnnerClothCd = "${order.glInnnerClothCd}"
			if(glInnnerClothCd!=""){
				jQuery("#og_insideLiningMateStkNo option[value='"+glInnnerClothCd+"']").attr("selected", true);
			}
			var glFrtBtnCd = "${order.glFrtBtnCd}";
			if(glFrtBtnCd!=""){
				jQuery("#og_frontBtnMateStkNo option[value='"+glFrtBtnCd+"']").attr("selected", true);
			}
			//補正の値を設定
			adjustInit();

			
			
			jQuery.ajax({url : contextPath + "/order/getBranchPrice", 
				data:{"orderPattern":orderPattern},
				type : 'get'}).then(function(result) {
				var i = null;
				var jkModelCode = jQuery("#jacketModel").val()
				jacketChangePrice(result,jkModelCode);

				jQuery("#oj_frontBtnCnt").change(function(){
					jacketChangePrice(result,jkModelCode);
				})
				
				
				jQuery("#jacketModel").change(function(){
					jkModelCode = jQuery("#jacketModel").val();
					jacketChangePrice(result,jkModelCode);
				})
				
				jQuery("#oj_frontBtnCnt,#bodyBackMate,#bodyBackMateStkNo,#cuffBackMate,#cuffBackMateStkNo,#btnMate,#btnMateStkNo")
				.change(function(){
					
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					frontBtnCntVal = jQuery("#oj_frontBtnCnt").val();
					if(frontBtnCntVal=="0000105"||frontBtnCntVal=="0000106"){
						dealWithDoublePice(idValue,thisVal,result,jkModelCode);
					}else{
						dealWithPice(idValue,thisVal,result,jkModelCode);
					}
				})
				//
				jQuery('input[id^="lapelDesign_"],[id^="fort_"],[id^="backSpec_"],[id^="waistPkt_"],[id^="changePkt_"],[id^="slantedPkt_"],[id^="cuffSpec_"],[id^="stitch_"],[id^="ventSpec_"],[id^="shapeMemory_"]')
				.click(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					frontBtnCntVal = jQuery("#oj_frontBtnCnt").val();
					//ダブル6つボタン : 0000105    ダブル4つボタン:0000106
					if(frontBtnCntVal=="0000105"||frontBtnCntVal=="0000106"){
						dealWithDoublePice(idValue,thisVal,result,jkModelCode);
					}else{
						dealWithPice(idValue,thisVal,result,jkModelCode);
					}

				});
				
				var pantsModel = jQuery("#op_pantsModel").val()
				for(i of ptPriceList){
					if(i.type == "2"){
						var idValue = i.id;
						var thisVal = jQuery("#"+idValue).val();
						dealWithPice(idValue,thisVal,result,pantsModel);
					}else if(i.type == "1"){
						var idValue = i.id;
						var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
						dealWithPice(idValue,thisVal,result,pantsModel);
					}
				}
				
				jQuery("#op_pantsModel").change(function(){
					pantsModel = jQuery("#op_pantsModel").val()
					for(i of ptPriceList){
						if(i.type == "2"){
							var idValue = i.id;
							var thisVal = jQuery("#"+idValue).val();
							dealWithPice(idValue,thisVal,result,pantsModel);
						}else if(i.type == "1"){
							var idValue = i.id;
							var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
							dealWithPice(idValue,thisVal,result,pantsModel);
						}
					}
				})
				
				
				jQuery('input[id^="op_adjuster_"],[id^="op_stitch_"],[id^="op_eight_"],[id^="op_thick_"],[id^="op_shapeMemory_"],[id^="op_blister_"]').click(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,pantsModel);
				});
					
				jQuery("#op_hemUp,#op_tack,#op_doubleWide,#op_btnMate,#op_btnMateStkNo").change(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,pantsModel);
				})
				
				
				var pants2Model = jQuery("#op2_pantsModel").val()
				for(i of pt2PriceList){
					if(i.type == "2"){
						var idValue = i.id;
						var thisVal = jQuery("#"+idValue).val();
						dealWithPice(idValue,thisVal,result,pants2Model);
					}else if(i.type == "1"){
						var idValue = i.id;
						var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
						dealWithPice(idValue,thisVal,result,pants2Model);
					}
				}

				jQuery("#op2_pantsModel").change(function(){
					pants2Model = jQuery("#op2_pantsModel").val();
					for(i of pt2PriceList){
						if(i.type == "2"){
							var idValue = i.id;
							var thisVal = jQuery("#"+idValue).val();
							dealWithPice(idValue,thisVal,result,pants2Model);
						}else if(i.type == "1"){
							var idValue = i.id;
							var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
							dealWithPice(idValue,thisVal,result,pants2Model);
						}
					}
				})

				jQuery('input[id^="op2_adjuster_"],[id^="op2_stitch_"],[id^="op2_eight_"],[id^="op2_thick_"],[id^="op2_shapeMemory_"],[id^="op2_blister_"]').click(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,pants2Model);
				});
				jQuery("#op2_hemUp,#op2_tack,#op2_doubleWide,#op2_btnMate,#op2_btnMateStkNo").change(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,pants2Model);
				})

				
				
				var giletModel = jQuery("#giletModel").val();
				for(i of glPriceList){
					if(i.type == "2"){
						var idValue = i.id;
						var thisVal = jQuery("#"+idValue).val();
						dealWithPice(idValue,thisVal,result,giletModel);
					}else if(i.type == "1"){
						var idValue = i.id;
						var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
						dealWithPice(idValue,thisVal,result,giletModel);
					}
				}

				jQuery("#giletModel").change(function(){
					giletModel = jQuery("#giletModel").val();
					for(i of glPriceList){
						if(i.type == "2"){
							var idValue = i.id;
							var thisVal = jQuery("#"+idValue).val();
							dealWithPice(idValue,thisVal,result,giletModel);
						}else if(i.type == "1"){
							var idValue = i.id;
							var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
							dealWithPice(idValue,thisVal,result,giletModel);
						}
					}
				})

				jQuery('input[id^="og_stitch_"]').click(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,giletModel);
				})
	
				
				jQuery("#og_backLiningMate,#og_backLiningMateStkNo,#og_insideLiningMate,#og_insideLiningMateStkNo,#og_frontBtnMate,#og_frontBtnMateStkNo")
				.change(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,giletModel);
				})

			});

			function dateFormat(time){
				var date = new Date(time);
				var year = date.getFullYear();  
				var month = date.getMonth() + 1
				if(month<=9){
					month = "0" + month;
				}
				var day = date.getDate();
				if(day<=9){
					day = "0" + day;
				}
				return year+"-"+month+"-"+day;
			}
			localStorage.clear();
		}else if(flag == "orderDivert"){

			//注文ID
			var orderId = "${order.orderId}";
			jQuery("#orderId").val(orderId);
			//会員番号
			var custCd = "${order.custCd}";
			jQuery("#custCd").val(custCd)
			//お客様氏名
			var custNm = "${order.custNm}";
			jQuery("#custNm").val(custNm);
			//フリガナ
			var custKanaNm = "${order.custKanaNm}";
			jQuery("#custKanaNm").val(custKanaNm);
			//スタッフ
			var custStaff = "${order.custStaff}";
			jQuery("#custStaff").val(custStaff);
			//区分
			var custType = "${order.custType}"
			jQuery("#custType").val(custType);
			//名簿納期
			var custDeliverDate = "${order.custDeliverDate}";
			if(custDeliverDate!=null){
				custDeliverDate = dateFormat(custDeliverDate);
				jQuery("#custDeliverDate").val(custDeliverDate)
			}
			//お渡し日
			var custShopDeliveryDate = "${order.custShopDeliveryDate}"
			if(custShopDeliveryDate!=null){
				custShopDeliveryDate = dateFormat(custShopDeliveryDate);
				jQuery("#custShopDeliveryDate").val(custShopDeliveryDate);
			}
			//出荷先
			var destination = "${order.custShippingDestination}"
			jQuery("#destination").val(destination);
			initCustomer();
			//出荷先_他店舗コード
			var shopNameCode = "${order.custShippingDestnationOtherstore}"
			//jQuery("#shopName").val(shopNameCode);
			//jQuery("#shopName" + " option[value='" + shopNameCode + "']").attr('selected', 'selected');
			jQuery("#shopName").val(shopNameCode);
			jQuery("#shopName").trigger("chosen:updated");

			//メジャーリング
			measuring();

			//商品
			//ITEM
			var item = "${order.productItem}"
			jQuery("#item").val(item);
			//３Piece
			var threePiece = "${order.productIs3piece}" 
			jQuery("input[name='productIs3Piece'][value='" + threePiece + "']").prop("checked", true);
			//スペアパンツ
			var productSparePantsClass = "${order.productSparePantsClass}"
			jQuery("input[name='productSparePantsClass'][value='" + threePiece + "']").prop("checked", true);
			//生地品番
			var productFabricNo = "${order.productFabricNo}"
			jQuery("#productFabricNo").val(productFabricNo);
			jQuery.ajax({
				 type:"post",
				 url: contextPath + "/order/findStock",
				 data:{"item":item,"fabricNo":productFabricNo},
				 async:false,
				 success:function(result){
					 if(null != result && "" != result){
						 jQuery("#stockMsg").html("-" + result.color + result.pattern + "在庫 " + result.theoreticalStock + "m");
						 jQuery("#fabric_brand_nm_p").html(result.brandName);
						 jQuery("#productFabricBrandNm").val(result.brandName);
						 jQuery("#service_nm_p").html(result.brandName+" "+result.materialName);
						 jQuery("#productServiceNm").val(result.brandName+" "+result.materialName);
						 if(result.compositionLabel.indexOf("/") != -1 ){
							 jQuery("#compos_frt_fabric_p").empty();
							 var labelArray = new Array();
							 labelArray = result.compositionLabel.split("/");
							 for (i=0; i<labelArray.length; i++ ){
								 jQuery("#compos_frt_fabric_p").append(labelArray[i]+"%").append("<Br>");
							 }
						 }else{
							 jQuery("#compos_frt_fabric_p").html(result.compositionLabel+"%");
						 }
						 jQuery("#productComposFrtFabric").val(result.compositionLabel);
						 jQuery("#notice").html(result.handlingCaution);
						 jQuery("#productNotice").val(result.handlingCaution);
				     }else{
				    	 jQuery("#notice").empty();
				    	 jQuery("#fabric_brand_nm_p").empty();
				    	 jQuery("#service_nm_p").empty();
						 jQuery("#compos_frt_fabric_p").empty();
				    	 appendAlert('stockMsg', "生地品番、およびITEMに関連する生地が存在しません");
					 }
				 }
			});
			jQuery('#stockMsg').show();

			//生地ネーム
			var productFabricNmNecessity = "${order.productFabricNmNecessity}"
			jQuery("input[name='productFabricNmNecessity'][value='" + productFabricNmNecessity + "']").prop("checked", true);
			//刺繍入れ
			var productEmbroideryNecessity = "${order.productEmbroideryNecessity}"
			jQuery("input[name='productEmbroideryNecessity'][value='" + productEmbroideryNecessity + "']").prop("checked", true);
			//刺繍ネーム
			var embroideryName = "${order.productEmbroideryNm}"
			jQuery("#embroideryName").val(embroideryName);
			//刺繍書体
			var productEmbroideryFont = "${order.productEmbroideryFont}"
			jQuery("input[name='productEmbroideryFont'][value='" + productEmbroideryFont + "']").prop("checked", true);	
			//刺繍糸色
			var embroideryColor = "${order.productEmbroideryThreadColor}"
			jQuery("#embroideryColor").val(embroideryColor);
			//組成表示　胴裏地
			var bodyText = "${order.productComposBodyLiner}"
			jQuery("#compos_body_liner_p").html(bodyText);
			jQuery("#productComposBodyLiner").val(bodyText);
			//組成表示　袖裏地
			var sleeveText = "${order.productComposSleeveLiner}"
			jQuery("#compos_sleeve_liner_p").html(sleeveText);
			jQuery("#productComposSleeveLiner").val(sleeveText);

			
			//オプション
			var jacketDefaultOrderList = {
					  activeList : [
						  			{id:"jacketModel",dVal:"${order.jkModelCd}",type:"2"},
						  			{id:"oj_frontBtnCnt",dVal:"${order.jkFrtBtnCd}",type:"2"},
									{id:"optionJacketStandardInfo.ojLapelDesign",dVal:"${order.jkLapelDesignCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojFort",dVal:"${order.jkDaibaCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojGackSpec",dVal:"${order.jkInnerClothCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojWaistPkt",dVal:"${order.jkWaistPktCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojChangePkt",dVal:"${order.jkChgPktCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojSlantedPkt",dVal:"${order.jkSlantedPktCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojCuffSpec",dVal:"${order.jkCuffCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojStitch",dVal:"${order.jkStitchTypeCd}",type:"1"},
									{id:"optionJacketStandardInfo.ojVentSpec",dVal:"${order.jkVentCd}",type:"1"},
									{id:"bodyBackMate",dVal:"${order.jkInnerBodyClothType}",type:"2"},
									{id:"cuffBackMate",dVal:"${order.jkInnerSleeveClothType}",type:"2"},
									{id:"btnMate",dVal:"${order.jkBtnMaterialType}",type:"2"},
									{id:"optionJacketStandardInfo.ojShapeMemory",dVal:"${order.jkShapeMemoryCd}",type:"1"}
								]
			}
			var pantsDefaultOrderList = {
					activeList : [
								{id:"op_pantsModel",dVal:"${order.ptModelCd}",type:"2"},
								{id:"op_tack",dVal:"${order.ptTackCd}",type:"2"},
								{id:"optionPantsStandardInfo.opAdjuster",dVal:"${order.ptAdjusterCd}",type:"1"},
								{id:"op_hemUp",dVal:"${order.ptHemUpCd}",type:"2"},
								{id:"op_doubleWide",dVal:"${order.ptDblWidthCd}",type:"2"},
								{id:"optionPantsStandardInfo.opStitch",dVal:"${order.ptAmfStitchCd}",type:"1"},
								{id:"op_btnMate",dVal:"${order.ptBtnMaterialType}",type:"2"},
								{id:"optionPantsStandardInfo.opEight",dVal:"${order.ptNonSlipCd}",type:"1"},
								{id:"optionPantsStandardInfo.opThick",dVal:"${order.ptChicSlipCd}",type:"1"},
								{id:"optionPantsStandardInfo.opShapeMemory",dVal:"${order.ptShapeMemoryCd}",type:"1"},
								{id:"optionPantsStandardInfo.opBlister",dVal:"${order.ptShoeSoreCd}",type:"1"},
								{id:"adjustPantsStandardInfo.corPtHemwidthType",dVal:"${order.corPtHemwidthType}",type:"1"}
							]
			}
			 var pants2DefaultOrderList = {
					activeList : [
								{id:"op2_pantsModel",dVal:"${order.pt2ModelCd}",type:"2"},
								{id:"op2_tack",dVal:"${order.pt2TackCd}",type:"2"},
								{id:"optionPants2StandardInfo.op2Adjuster",dVal:"${order.pt2AdjusterCd}",type:"1"},
								{id:"op2_hemUp",dVal:"${order.pt2HemUpCd}",type:"2"},
								{id:"op2_doubleWide",dVal:"${order.pt2DblWidthCd}",type:"2"},
								{id:"optionPants2StandardInfo.op2Stitch",dVal:"${order.pt2AmfStitchCd}",type:"1"},
								{id:"op2_btnMate",dVal:"${order.pt2BtnMaterialType}",type:"2"},
								{id:"optionPants2StandardInfo.op2Eight",dVal:"${order.pt2NonSlipCd}",type:"1"},
								{id:"optionPants2StandardInfo.op2Thick",dVal:"${order.pt2ChicSlipCd}",type:"1"},
								{id:"optionPants2StandardInfo.op2ShapeMemory",dVal:"${order.pt2ShapeMemoryCd}",type:"1"},
								{id:"optionPants2StandardInfo.op2Blister",dVal:"${order.pt2ShoeSoreCd}",type:"1"},
								{id:"adjustPants2StandardInfo.corPt2HemwidthType",dVal:"${order.corPt2HemwidthType}",type:"1"}
							]
			}
			var giletDefaultOrderList = {
				   activeList : [
					   			{id:"giletModel",dVal:"${order.glModelCd}",type:"2"},
					   			{id:"optionGiletStandardInfo.ogStitch",dVal:"${order.glAmfStitchCd}",type:"1"},
								{id:"og_backLiningMate",dVal:"${order.glBackClothType}",type:"2"},
								{id:"og_insideLiningMate",dVal:"${order.glInnnerClothType}",type:"2"},
								{id:"og_frontBtnMate",dVal:"${order.glFrtBtnType}",type:"2"}
							]
			} 
			//オプションのデフォルト値を設定
			var i = null;
			for (i of jacketDefaultOrderList.activeList) {
				if(i.type == "2"){
					jQuery("#"+i.id+" option[value="+i.dVal+"]").prop("selected", true);
				}else if(i.type == "1"){
					jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
				}
			}

			for (i of pantsDefaultOrderList.activeList) {
				if(i.type == "2"){
					jQuery("#"+i.id+" option[value="+i.dVal+"]").prop("selected", true);
				}else if(i.type == "1"){
					jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
				}
			}
			
			
			for (i of giletDefaultOrderList.activeList) {
				if(i.type == "2"){
					jQuery("#"+i.id+" option[value="+i.dVal+"]").prop("selected", true);
				}else if(i.type == "1"){
					jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
				}
			}

			for (i of pants2DefaultOrderList.activeList) {
				if(i.type == "2"){
					jQuery("#"+i.id+" option[value="+i.dVal+"]").prop("selected", true);
				}else if(i.type == "1"){
					jQuery(":radio[name='" + i.id + "'][value='" + i.dVal + "']").prop("checked", true);
				}
			}
			
			//品番値を設定
			mateInit();
			
			//品番のデフォルト値を設定
			var ptBtnMaterialCd = "${order.ptBtnMaterialCd}";
			if(ptBtnMaterialCd!=""){
				jQuery("#op_btnMateStkNo option[value='"+ptBtnMaterialCd+"']").attr("selected", true);
			}
			var pt2BtnMaterialCd = "${order.pt2BtnMaterialCd}"
			if(pt2BtnMaterialCd!=""){
				jQuery("#op2_btnMateStkNo option[value='"+pt2BtnMaterialCd+"']").attr("selected", true);
			}


			var jkInnerBodyClothCd = "${order.jkInnerBodyClothCd}"
			if(jkInnerBodyClothCd!=""){
				jQuery("#bodyBackMateStkNo option[value='"+jkInnerBodyClothCd+"']").attr("selected", true);
			}
			var jkInnerSleeveClothCd = "${order.jkInnerSleeveClothCd}";
			if(jkInnerSleeveClothCd!=""){
				jQuery("#cuffBackMateStkNo option[value='"+jkInnerSleeveClothCd+"']").attr("selected", true);
			}
			var jkBtnMaterialCd = "${order.jkBtnMaterialCd}"
			if(jkBtnMaterialCd!=""){
				jQuery("#btnMateStkNo option[value='"+jkBtnMaterialCd+"']").attr("selected", true);
			}
			

			var glBackClothCd = "${order.glBackClothCd}"
			if(glBackClothCd!=""){
				jQuery("#og_backLiningMateStkNo option[value='"+glBackClothCd+"']").attr("selected", true);
			}
			var glInnnerClothCd = "${order.glInnnerClothCd}"
			if(glInnnerClothCd!=""){
				jQuery("#og_insideLiningMateStkNo option[value='"+glInnnerClothCd+"']").attr("selected", true);
			}
			var glFrtBtnCd = "${order.glFrtBtnCd}";
			if(glFrtBtnCd!=""){
				jQuery("#og_frontBtnMateStkNo option[value='"+glFrtBtnCd+"']").attr("selected", true);
			}
			//補正の値を設定
			adjustInit();


			
			var priceDbList = [
					 {priceId:"oj_frontBtnCnt_Msg",price:"${order.jkFrtBtnRtPrice}"},
					 {priceId:"lapelDesign_Msg",price:"${order.jkLapelDesignRtPrice}"},
					 {priceId:"fort_Msg",price:"${order.jkDaibaRtPrice}"},
					 {priceId:"backSpec_Msg",price:"${order.jkInnerClothRtPrice}"},
					 {priceId:"waistPkt_Msg",price:"${order.jkWaistPktRtPrice}"},
					 {priceId:"changePkt_Msg",price:"${order.jkChgPktRtPrice}"},
					 {priceId:"slantedPkt_Msg",price:"${order.jkSlantedPktRtPrice}"},
					 {priceId:"cuffSpec_Msg",price:"${order.jkCuffRtPrice}"},
					 {priceId:"stitch_Msg",price:"${order.jkStitchTypeRtPrice}"},
					 {priceId:"ventSpec_Msg",price:"${order.jkVentRtPrice}"},
					 {priceId:"bodyBackMate_Msg",price:"${order.jkInnerBodyClothRtPrice}"},
					 {priceId:"cuffBackMate_Msg",price:"${order.jkInnerSleeveClothRtPrice}"},
					 {priceId:"btnMate_Msg",price:"${order.jkBtnMaterialRtPrice}"},
					 {priceId:"shapeMemory_Msg",price:"${order.jkShapeMemoryRtPrice}"},

					 {priceId:"op_tack_Msg",price:"${order.ptTackRtPrice}"},
					 {priceId:"op_adjuster_Msg",price:"${order.ptAdjusterRtPrice}"},
					 {priceId:"op_hemUp_Msg",price:"${order.ptHemUpRtPrice}"},
					 {priceId:"op_doubleWide_Msg",price:"${order.ptDblWidthRtPrice}"},
					 {priceId:"op_stitch_Msg",price:"${order.ptAmfStitchRtPrice}"},
					 {priceId:"op_btnMate_Msg",price:"${order.ptBtnMaterialRtPrice}"},
					 {priceId:"op_eight_Msg",price:"${order.ptNonSlipRtPrice}"},
					 {priceId:"op_thick_Msg",price:"${order.ptChicSlipRtPrice}"},
					 {priceId:"op_shapeMemory_Msg",price:"${order.ptShapeMemoryRtPrice}"},
					 {priceId:"op_blister_Msg",price:"${order.ptShoeSoreRtPrice}"},

					 {priceId:"op2_tack_Msg",price:"${order.pt2TackRtPrice}"},
					 {priceId:"op2_adjuster_Msg",price:"${order.pt2AdjusterRtPrice}"},
					 {priceId:"op2_hemUp_Msg",price:"${order.pt2HemUpRtPrice}"},
					 {priceId:"op2_doubleWide_Msg",price:"${order.pt2DblWidthRtPrice}"},
					 {priceId:"op2_stitch_Msg",price:"${order.pt2AmfStitchRtPrice}"},
					 {priceId:"op2_btnMate_Msg",price:"${order.pt2BtnMaterialRtPrice}"},
					 {priceId:"op2_eight_Msg",price:"${order.pt2NonSlipRtPrice}"},
					 {priceId:"op2_thick_Msg",price:"${order.pt2ChicSlipRtPrice}"},
					 {priceId:"op2_shapeMemory_Msg",price:"${order.pt2ShapeMemoryRtPrice}"},
					 {priceId:"op2_blister_Msg",price:"${order.pt2ShoeSoreRtPrice}"},


					 {priceId:"og_stitch_Msg",price:"${order.glAmfStitchRtPrice}"},
					 {priceId:"og_backLiningMate_Msg",price:"${order.glBackClothRtPrice}"},
					 {priceId:"og_insideLiningMate_Msg",price:"${order.glInnnerClothRtPrice}"},
					 {priceId:"og_frontBtnMate_Msg",price:"${order.glFrtBtnRtPrice}"},
			]
			
			
			//DBからの上代
			var pd = null;
			for(pd of priceDbList){
				if(pd.price == '0'||pd.price == ''){
					jQuery("#"+pd.priceId).html("無料");
				}else{
					var format = formatMoney(pd.price,0,"￥");
					jQuery("#"+pd.priceId).html(format)
				}
			}
			
			
			
			jQuery.ajax({url : contextPath + "/order/getBranchPrice", 
				data:{"orderPattern":orderPattern},
				type : 'get'}).then(function(result) {
				var i = null;
				var jkModelCode = jQuery("#jacketModel").val()
				/* 
				jacketChangePrice(result,jkModelCode); */

				jQuery("#oj_frontBtnCnt").change(function(){
					jacketChangePrice(result,jkModelCode);
				})
				
				
				jQuery("#jacketModel").change(function(){
					jkModelCode = jQuery("#jacketModel").val();
					jacketChangePrice(result,jkModelCode);
				})
				
				jQuery("#oj_frontBtnCnt,#bodyBackMate,#bodyBackMateStkNo,#cuffBackMate,#cuffBackMateStkNo,#btnMate,#btnMateStkNo")
				.change(function(){
					
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					frontBtnCntVal = jQuery("#oj_frontBtnCnt").val();
					if(frontBtnCntVal=="0000105"||frontBtnCntVal=="0000106"){
						dealWithDoublePice(idValue,thisVal,result,jkModelCode);
					}else{
						dealWithPice(idValue,thisVal,result,jkModelCode);
					}
				})
				//
				jQuery('input[id^="lapelDesign_"],[id^="fort_"],[id^="backSpec_"],[id^="waistPkt_"],[id^="changePkt_"],[id^="slantedPkt_"],[id^="cuffSpec_"],[id^="stitch_"],[id^="ventSpec_"],[id^="shapeMemory_"]')
				.click(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					frontBtnCntVal = jQuery("#oj_frontBtnCnt").val();
					//ダブル6つボタン : 0000105    ダブル4つボタン:0000106
					if(frontBtnCntVal=="0000105"||frontBtnCntVal=="0000106"){
						dealWithDoublePice(idValue,thisVal,result,jkModelCode);
					}else{
						dealWithPice(idValue,thisVal,result,jkModelCode);
					}

				});
				
				var pantsModel = jQuery("#op_pantsModel").val()
				/* for(i of ptPriceList){
					if(i.type == "2"){
						var idValue = i.id;
						var thisVal = jQuery("#"+idValue).val();
						dealWithPice(idValue,thisVal,result,pantsModel);
					}else if(i.type == "1"){
						var idValue = i.id;
						var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
						dealWithPice(idValue,thisVal,result,pantsModel);
					}
				} */
				
				jQuery("#op_pantsModel").change(function(){
					pantsModel = jQuery("#op_pantsModel").val()
					for(i of ptList){
						if(i.type == "2"){
							var idValue = i.id;
							var thisVal = jQuery("#"+idValue).val();
							dealWithPice(idValue,thisVal,result,pantsModel);
						}else if(i.type == "1"){
							var idValue = i.id;
							var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
							dealWithPice(idValue,thisVal,result,pantsModel);
						}
					}
				})
				
				
				jQuery('input[id^="op_adjuster_"],[id^="op_stitch_"],[id^="op_eight_"],[id^="op_thick_"],[id^="op_shapeMemory_"],[id^="op_blister_"]').click(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,pantsModel);
				});
					
				jQuery("#op_hemUp,#op_tack,#op_doubleWide,#op_btnMate,#op_btnMateStkNo").change(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,pantsModel);
				})
				
				
				var pants2Model = jQuery("#op2_pantsModel").val()
				/* for(i of pt2PriceList){
					if(i.type == "2"){
						var idValue = i.id;
						var thisVal = jQuery("#"+idValue).val();
						dealWithPice(idValue,thisVal,result,pants2Model);
					}else if(i.type == "1"){
						var idValue = i.id;
						var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
						dealWithPice(idValue,thisVal,result,pants2Model);
					}
				} */

				jQuery("#op2_pantsModel").change(function(){
					pants2Model = jQuery("#op2_pantsModel").val();
					for(i of pt2PriceList){
						if(i.type == "2"){
							var idValue = i.id;
							var thisVal = jQuery("#"+idValue).val();
							dealWithPice(idValue,thisVal,result,pants2Model);
						}else if(i.type == "1"){
							var idValue = i.id;
							var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
							dealWithPice(idValue,thisVal,result,pants2Model);
						}
					}
				})

				jQuery('input[id^="op2_adjuster_"],[id^="op2_stitch_"],[id^="op2_eight_"],[id^="op2_thick_"],[id^="op2_shapeMemory_"],[id^="op2_blister_"]').click(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,pants2Model);
				});
				jQuery("#op2_hemUp,#op2_tack,#op2_doubleWide,#op2_btnMate,#op2_btnMateStkNo").change(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,pants2Model);
				})

				
				
				var giletModel = jQuery("#giletModel").val();
				/* for(i of glPriceList){
					if(i.type == "2"){
						var idValue = i.id;
						var thisVal = jQuery("#"+idValue).val();
						dealWithPice(idValue,thisVal,result,giletModel);
					}else if(i.type == "1"){
						var idValue = i.id;
						var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
						dealWithPice(idValue,thisVal,result,giletModel);
					}
				} */

				jQuery("#giletModel").change(function(){
					giletModel = jQuery("#giletModel").val();
					for(i of glPriceList){
						if(i.type == "2"){
							var idValue = i.id;
							var thisVal = jQuery("#"+idValue).val();
							dealWithPice(idValue,thisVal,result,giletModel);
						}else if(i.type == "1"){
							var idValue = i.id;
							var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
							dealWithPice(idValue,thisVal,result,giletModel);
						}
					}
				})

				jQuery('input[id^="og_stitch_"]').click(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,giletModel);
				})
	
				
				jQuery("#og_backLiningMate,#og_backLiningMateStkNo,#og_insideLiningMate,#og_insideLiningMateStkNo,#og_frontBtnMate,#og_frontBtnMateStkNo")
				.change(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,giletModel);
				})

			});

			function dateFormat(time){
				var date = new Date(time);
				var year = date.getFullYear();  
				var month = date.getMonth() + 1
				if(month<=9){
					month = "0" + month;
				}
				var day = date.getDate();
				if(day<=9){
					day = "0" + day;
				}
				return year+"-"+month+"-"+day;
			}
			localStorage.clear();
			
		}else{
			
			initCustomer();
			
			var j = null;
			var p = null;
			var g = null;
			var j2 = null;
			for (j of jacketDefaultList.activeList) {
				if(j.type == "2"){
					jQuery("#"+j.id+" option[value="+j.dVal+"]").prop("selected", true);
				}else if(j.type == "1"){
					jQuery(":radio[name='" + j.id + "'][value='" + j.dVal + "']").prop("checked", true);
				}
			}

			for (j of pantsDefaultList.activeList) {
				if(j.type == "2"){
					jQuery("#"+j.id+" option[value="+j.dVal+"]").prop("selected", true);
				}else if(j.type == "1"){
					jQuery(":radio[name='" + j.id + "'][value='" + j.dVal + "']").prop("checked", true);
				}
			}

			for (g of giletDefaultList.activeList) {
				if(g.type == "2"){
					jQuery("#"+g.id+" option[value="+g.dVal+"]").prop("selected", true);
				}else if(g.type == "1"){
					jQuery(":radio[name='" + g.id + "'][value='" + g.dVal + "']").prop("checked", true);
				}
			}

			for (j2 of pants2DefaultList.activeList) {
				if(j2.type == "2"){
					jQuery("#"+j2.id+" option[value="+j2.dVal+"]").prop("selected", true);
				}else if(j2.type == "1"){
					jQuery(":radio[name='" + j2.id + "'][value='" + j2.dVal + "']").prop("checked", true);
				}
			}

			mateInit();
			
			localStorage.clear();
		}	

	});
		
 jQuery(document).ready(function(){

	var bodyText = "";
	bodyText = jQuery("#bodyBackMate").find("option:selected").text();
	jQuery("#bodyBackMate").change(function(){
		 bodyText = jQuery("#bodyBackMate").find("option:selected").text();
		 jQuery("#compos_body_liner_p").html(bodyText);
		 jQuery("productComposBodyLiner").val(bodyText);
	})
	jQuery("#compos_body_liner_p").html(bodyText);
	jQuery("#productComposBodyLiner").val(bodyText);

	
	var sleeveText = "";
	sleeveText = jQuery("#cuffBackMate").find("option:selected").text();
	jQuery("#cuffBackMate").change(function(){
		sleeveText = jQuery("#cuffBackMate").find("option:selected").text();
		 jQuery("#compos_sleeve_liner_p").html(sleeveText);
		 jQuery("#productComposSleeveLiner").val(sleeveText);
	})
	jQuery("#compos_sleeve_liner_p").html(sleeveText);
	jQuery("#productComposSleeveLiner").val(sleeveText);
	 
	getPrice();
		
});

 
jQuery(function() {

	var contextPath = jQuery("meta[name='contextPath']").attr("content");
	/* jQuery('body').everyTime('100s',function(){
		jQuery.ajax({url : contextPath + "/order/orderPoTemporarySave",
		      type: "get",
		      dataType: "json",
	          data: jQuery('#formId').serialize(),
			  }).then(function(result) {

		})
	}); */
	jQuery("#temporarySave").click(function(){
		var status = jQuery("#status");
		status.empty();
		status.html("一時保存");
		jQuery("#statusInput").val("T0");

		jQuery.ajax({url : contextPath + "/order/orderPoTemporarySave",
		      type: "get",
		      dataType: "json",
	          data: jQuery('#formId').serialize(),
	          }).then(function(result) {

			  })
		
	})
	
	jQuery("#temporarySave2").click(function(){
		var status = jQuery("#status");
		status.empty();
		status.html("取り置き");
		jQuery("#statusInput").val("T1");
	})
	
	
	// 注文取消しボタンクリック
	jQuery('#cancelButton').on('click', function() {
		// 確認ダイアログ表示
		swal({
			text:"該当注文を取り消してよろしいでしょうか？",
			icon:"warning",
			buttons:true
		}).then((willDelete) => {
			if (willDelete) {
				// OK押下時は注文一覧へ
				location.href = "./index_po_result_del.html";
			} else {
				// Cancel押下時は何もしない
			}
		});
	});
	
	
	var orderPattern = "PO"
		
	var jk = null;
	var jkList = [
		{type:"01",id:"corJkBody_div"},
		{type:"02",id:"corJkWaist_div"},
		{type:"03",id:"corJkRightsleeve_div"},
		{type:"04",id:"corJkLeftsleeve_div"}
	];
	var jacketFigure;
	var jacketNumber;
	var	jacketModel;
	jQuery("#selectJacketFigure,#selectJacketNumber,#jacketModel").change(function(){

		jQuery("#corJkBodyRange").val(0);
		jQuery("#corJkWaistRange").val(0);
		jQuery("#corJkRightsleeveRange").val(0);
		jQuery("#corJkLeftsleeveRange").val(0);

		jQuery("#corJkBodyRange_out").val(0);
		jQuery("#corJkWaistRange_out").val(0);
		jQuery("#corJkRightsleeveRange_out").val(0);
		jQuery("#corJkLeftsleeveRange_out").val(0);
		
		var subItemCode = "02";
		jacketModel = jQuery("#jacketModel").val();
		jacketFigure = jQuery("#selectJacketFigure").val();
		jacketNumber = jQuery("#selectJacketNumber").val();
		if(jacketFigure!=""&&jacketModel!="0"&&jacketNumber!=""){
			for (jk of jkList) {
				var jkFN = orderPattern+subItemCode+jacketModel+jacketFigure+jacketNumber+jk.type;
				getFigureNumber(jk.id,orderPattern,jkFN,"");
			}
		}
	})
	/* var ptList = [
		{type:"06",id:"corPtWaist_div"},
		{type:"07",id:"corPtThigh_div"}
	]; */
	var pt = null;
	var ptt = null;
	var ptList = [
		{type:"07",id:"corPtThigh_div"},
		{type:"08",id:"corPtHemwidth_div"}
	];
	
	var ptTackList = [
		{type:"06",id:"corPtWaist_div"}
	];
	var	pantsModel;
	var pantsFigure;
	var pantsNumber;
	var opTack;
	jQuery("#selectPantsFigure,#selectPantsNumber,#op_pantsModel,#op_tack").change(function(){
		var subItemCode = "03";
		pantsModel = jQuery("#op_pantsModel").val();
		pantsFigure = jQuery("#selectPantsFigure").val();
		pantsNumber = jQuery("#selectPantsNumber").val();
		opTack = jQuery("#op_tack").val();

		jQuery("#corPtWaistRange").val(0);
		jQuery("#corPtThighRange").val(0);
		jQuery("#corPtHemwidthRange").val(0);

		jQuery("#corPtWaistRange_out").html('0');
		jQuery("#corPtThighRange_out").html('0');
		jQuery("#corPtHemwidthRange_out").html('0');
		
		if(pantsFigure!=""&&pantsModel!="0"&&pantsNumber!=""){
			//ノータック:0000101  1アウトタック:0000102  2アウトタック:0000104
			if(opTack=="0000102"){
				for (ptt of ptTackList) {
					var pttFN = orderPattern+subItemCode+pantsModel+pantsFigure+pantsNumber+ptt.type;
					getFigureNumber(ptt.id,orderPattern,pttFN,opTack);
				}
				for (pt of ptList) {
					var ptFN = orderPattern+subItemCode+pantsModel+pantsFigure+pantsNumber+pt.type;
					getFigureNumber(pt.id,orderPattern,ptFN,"");
				}
			}else if(opTack=="0000104"){
				for (ptt of ptTackList) {
					var pttFN = orderPattern+subItemCode+pantsModel+pantsFigure+pantsNumber+ptt.type;
					getFigureNumber(ptt.id,orderPattern,pttFN,opTack);
				}
				for (pt of ptList) {
					var ptFN = orderPattern+subItemCode+pantsModel+pantsFigure+pantsNumber+pt.type;
					getFigureNumber(pt.id,orderPattern,ptFN,"");
				}
			}else{
				for (ptt of ptTackList) {
					var pttFN = orderPattern+subItemCode+pantsModel+pantsFigure+pantsNumber+ptt.type;
					getFigureNumber(ptt.id,orderPattern,pttFN,"");
				}
				for (pt of ptList) {
					var ptFN = orderPattern+subItemCode+pantsModel+pantsFigure+pantsNumber+pt.type;
					getFigureNumber(pt.id,orderPattern,ptFN,"");
				}
			}
			
		}
	})
	
	
	var pt2 = null;
	var ptt2 = null;
	var pt2List = [
		{type:"07",id:"corPt2Thigh_div"},
		{type:"08",id:"corPt2Hemwidth_div"}
	];
	
	var pt2TackList = [
		{type:"06",id:"corPt2Waist_div"}
	];
	var	pants2Model;
	var pants2Figure;
	var pants2Number;
	var op2Tack;
	jQuery("#selectPants2Figure,#selectPants2Number,#op2_pantsModel,#op2_tack").change(function(){
		
		var subItemCode = "07";
		pants2Model = jQuery("#op2_pantsModel").val();
		pants2Figure = jQuery("#selectPants2Figure").val();
		pants2Number = jQuery("#selectPants2Number").val();
		op2Tack = jQuery("#op2_tack").val();

		jQuery("#corPt2WaistRange").val(0);
		jQuery("#corPt2ThighRange").val(0);
		jQuery("#corPt2HemwidthRange").val(0);

		jQuery("#corPt2WaistRange_out").html('0');
		jQuery("#corPt2ThighRange_out").html('0');
		jQuery("#corPt2HemwidthRange_out").html('0');
		
		if(pants2Figure!=""&&pants2Model!="0"&&pants2Number!=""){
			//ノータック:0000101  1アウトタック:0000102  2アウトタック:0000104
			if(op2Tack=="0000102"){
				for (ptt2 of pt2TackList) {
					var ptt2FN = orderPattern+subItemCode+pants2Model+pants2Figure+pants2Number+ptt2.type;
					getFigureNumber(ptt2.id,orderPattern,ptt2FN,op2Tack);
				}
				for (pt2 of pt2List) {
					var ptFN2 = orderPattern+subItemCode+pants2Model+pants2Figure+pants2Number+pt2.type;
					getFigureNumber(pt2.id,orderPattern,ptFN2,"");
				}
			}else if(op2Tack=="0000104"){
				for (ptt2 of pt2TackList) {
					var ptt2FN = orderPattern+subItemCode+pants2Model+pants2Figure+pants2Number+ptt2.type;
					getFigureNumber(ptt2.id,orderPattern,ptt2FN,op2Tack);
				}
				for (pt2 of pt2List) {
					var ptFN2 = orderPattern+subItemCode+pants2Model+pants2Figure+pants2Number+pt2.type;
					getFigureNumber(pt2.id,orderPattern,ptFN2,"");
				}
			}else{
				for (ptt2 of pt2TackList) {
					var ptt2FN = orderPattern+subItemCode+pants2Model+pants2Figure+pants2Number+ptt2.type;
					getFigureNumber(ptt2.id,orderPattern,ptt2FN,"");
				}
				for (pt2 of pt2List) {
					var ptFN2 = orderPattern+subItemCode+pants2Model+pants2Figure+pants2Number+pt2.type;
					getFigureNumber(pt2.id,orderPattern,ptFN2,"");
				}
			}
			
		}
	})
	
	function getFigureNumber(id,orderPattern,FN,tack){
		var correspondId = jQuery("#"+id);
		jQuery.ajax({
            url: contextPath + "/order/getPoTypeSize",
            data:{"orderPattern":orderPattern},
            type: 'post',
            success: function(data){
            	for(var i=0; i<data.length; i++){
                	if(FN == data[i].key&&tack=="0000102"){
                		//correspondId.empty();
                		//var alertElem = jQuery('<label id = "'+ id + '_html" value="'+data[i].outTack1Value+'">'+ data[i].outTack1Value + 'cm' + '</label>');
                		//alertElem.appendTo(correspondId);
                		jQuery("#"+id+"_html").html(data[i].outTack1Value + 'cm');
                		jQuery("#"+id+"_Size").val(data[i].outTack1Value);
                		jQuery("#"+id+"_Gross").val(data[i].outTack1Value);
                    }else if(FN == data[i].key&&tack=="0000104"){
                    	//correspondId.empty();
                    	//var alertElem = jQuery('<label id = "'+ id + '_html" value="'+data[i].outTack2Value+'">'+ data[i].outTack2Value + 'cm' + '</label>');
                		//alertElem.appendTo(correspondId);
                		jQuery("#"+id+"_html").html(data[i].outTack2Value + 'cm');
                		jQuery("#"+id+"_Size").val(data[i].outTack2Value);
                		jQuery("#"+id+"_Gross").val(data[i].outTack2Value);
                    }else if(FN == data[i].key&&tack==""){
                    	//correspondId.empty();
                		//var alertElem = jQuery('<label id = "'+ id + '_html" value="'+data[i].value+'">'+ data[i].value + 'cm' + '</label>');
                		//alertElem.appendTo(correspondId);
                		jQuery("#"+id+"_html").html(data[i].value + 'cm');
                		jQuery("#"+id+"_Size").val(data[i].value);
                		jQuery("#"+id+"_Gross").val(data[i].value);
                    }
                }
            }
        });
	}
	
	jQuery("#ap_inseamLeft100,#ap_inseamLeft10,#ap_inseamLeft1,#ap_inseamLeftM1").change(function(){
		var ap_inseamLeft100 = jQuery("#ap_inseamLeft100").val();
		var ap_inseamLeft10 = jQuery("#ap_inseamLeft10").val();
		var ap_inseamLeft1 = jQuery("#ap_inseamLeft1").val();
		var ap_inseamLeftM1 = jQuery("#ap_inseamLeftM1").val();
		var corPtLeftinseamGross = ap_inseamLeft100+ap_inseamLeft10+ap_inseamLeft1+"."+ap_inseamLeftM1;
		jQuery("#corPtLeftinseamGross").val(corPtLeftinseamGross);
	})
	
	jQuery("#ap_inseamRight100,#ap_inseamRight10,#ap_inseamRight1,#ap_inseamRightM1").change(function(){
		var ap_inseamRight100 = jQuery("#ap_inseamRight100").val();
		var ap_inseamRight10 = jQuery("#ap_inseamRight10").val();
		var ap_inseamRight1 = jQuery("#ap_inseamRight1").val();
		var ap_inseamRightM1 = jQuery("#ap_inseamRightM1").val();
		var corPtRightinseamGross = ap_inseamRight100+ap_inseamRight10+ap_inseamRight1+"."+ap_inseamRightM1;
		jQuery("#corPtRightinseamGross").val(corPtRightinseamGross);
	})
	
	
	jQuery("#ap2_inseamLeft100,#ap2_inseamLeft10,#ap2_inseamLeft1,#ap2_inseamLeftM1").change(function(){
		var ap2_inseamLeft100 = jQuery("#ap2_inseamLeft100").val();
		var ap2_inseamLeft10 = jQuery("#ap2_inseamLeft10").val();
		var ap2_inseamLeft1 = jQuery("#ap2_inseamLeft1").val();
		var ap2_inseamLeftM1 = jQuery("#ap2_inseamLeftM1").val();
		var corPt2LeftinseamGross = ap2_inseamLeft100+ap2_inseamLeft10+ap2_inseamLeft1+"."+ap2_inseamLeftM1;
		jQuery("#corPt2LeftinseamGross").val(corPt2LeftinseamGross);
	})
	
	
	jQuery("#ap2_inseamRight100,#ap2_inseamRight10,#ap2_inseamRight1,#ap2_inseamRightM1").change(function(){
		var ap2_inseamRight100 = jQuery("#ap2_inseamRight100").val();
		var ap2_inseamRight10 = jQuery("#ap2_inseamRight10").val();
		var ap2_inseamRight1 = jQuery("#ap2_inseamRight1").val();
		var ap2_inseamRightM1 = jQuery("#ap2_inseamRightM1").val();
		var corPt2RightinseamGross = ap2_inseamRight100+ap2_inseamRight10+ap2_inseamRight1+"."+ap2_inseamRightM1;
		jQuery("#corPt2RightinseamGross").val(corPt2RightinseamGross);
	})
	
	var fullLengthText="";
	var fullLengthSelect="";
	jQuery("#fullLengthTe").on('input', function(){
		fullLengthText = jQuery("#fullLengthTe").val();
		var makeUpVal = fullLengthText+".0";
		jQuery("#fullLength").val(makeUpVal);
	})
	jQuery("#fullLengthSe").change(function(){
		fullLengthSelect = jQuery("#fullLengthSe").val();
		var makeUpVal = fullLengthText+"."+fullLengthSelect;
		jQuery("#fullLength").val(makeUpVal);
	})
	
	var shoulderText="";
	var shoulderSelect="";
	jQuery("#shoulderTe").on('input', function(){
		shoulderText = jQuery("#shoulderTe").val();
		var makeUpVal = shoulderText+".0";
		jQuery("#shoulder").val(makeUpVal);
	})
	jQuery("#shoulderSe").change(function(){
		shoulderSelect = jQuery("#shoulderSe").val();
		var makeUpVal = shoulderText+"."+shoulderSelect;
		jQuery("#shoulder").val(makeUpVal);
	})
	
	var reachRightText="";
	var reachRightSelect="";
	jQuery("#reachRightTe").on('input', function(){
		reachRightText = jQuery("#reachRightTe").val();
		var makeUpVal = reachRightText+".0";
		jQuery("#reachRight").val(makeUpVal);
	})
	jQuery("#reachRightSe").change(function(){
		reachRightSelect = jQuery("#reachRightSe").val();
		var makeUpVal = reachRightText+"."+reachRightSelect;
		jQuery("#reachRight").val(makeUpVal);
	})
	
	var reachLeftText="";
	var reachLeftSelect="";
	jQuery("#reachLeftTe").on('input', function(){
		reachLeftText = jQuery("#reachLeftTe").val();
		var makeUpVal = reachLeftText+".0";
		jQuery("#reachLeft").val(makeUpVal);
	})
	jQuery("#reachLeftSe").change(function(){
		reachLeftSelect = jQuery("#reachLeftSe").val();
		var makeUpVal = reachLeftText+"."+reachLeftSelect;
		jQuery("#reachLeft").val(makeUpVal);
	})
	
	var outBustText="";
	var outBustSelect="";
	jQuery("#outBustTe").on('input', function(){
		outBustText = jQuery("#outBustTe").val();
		var makeUpVal = outBustText+".0";
		jQuery("#outBust").val(makeUpVal);
	})
	jQuery("#outBustSe").change(function(){
		outBustSelect = jQuery("#outBustSe").val();
		var makeUpVal = outBustText+"."+outBustSelect;
		jQuery("#outBust").val(makeUpVal);
	})
	
	var bustText="";
	var bustSelect="";
	jQuery("#bustTe").on('input', function(){
		bustText = jQuery("#bustTe").val();
		var makeUpVal = bustText+".0";
		jQuery("#bust").val(makeUpVal);
	})
	jQuery("#bustSe").change(function(){
		bustSelect = jQuery("#bustSe").val();
		var makeUpVal = bustText+"."+bustSelect;
		jQuery("#bust").val(makeUpVal);
	})
	
	var jacketWaistText="";
	var jacketWaistSelect="";
	jQuery("#jacketWaistTe").on('input', function(){
		jacketWaistText = jQuery("#jacketWaistTe").val();
		var makeUpVal = jacketWaistText+".0";
		jQuery("#jacketWaist").val(makeUpVal);
	})
	jQuery("#jacketWaistSe").change(function(){
		jacketWaistSelect = jQuery("#jacketWaistSe").val();
		var makeUpVal = jacketWaistText+"."+jacketWaistSelect;
		jQuery("#jacketWaist").val(makeUpVal);
	})
	
	var pantsWaistText="";
	var pantsWaistSelect="";
	jQuery("#pantsWaistTe").on('input', function(){
		pantsWaistText = jQuery("#pantsWaistTe").val();
		var makeUpVal = pantsWaistText+".0";
		jQuery("#pantsWaist").val(makeUpVal);
	})
	jQuery("#pantsWaistSe").change(function(){
		pantsWaistSelect = jQuery("#pantsWaistSe").val();
		var makeUpVal = pantsWaistText+"."+pantsWaistSelect;
		jQuery("#pantsWaist").val(makeUpVal);
	})
	
	var hipText="";
	var hipSelect="";
	jQuery("#hipTe").on('input', function(){
		hipText = jQuery("#hipTe").val();
		var makeUpVal = hipText+".0";
		jQuery("#hip").val(makeUpVal);
	})
	jQuery("#hipSe").change(function(){
		hipSelect = jQuery("#hipSe").val();
		var makeUpVal = hipText+"."+hipSelect;
		jQuery("#hip").val(makeUpVal);
	})
	
	var spanRightText="";
	var spanRightSelect="";
	jQuery("#spanRightTe").on('input', function(){
		spanRightText = jQuery("#spanRightTe").val();
		var makeUpVal = spanRightText+".0";
		jQuery("#spanRight").val(makeUpVal);
	})
	jQuery("#spanRightSe").change(function(){
		spanRightSelect = jQuery("#spanRightSe").val();
		var makeUpVal = spanRightText+"."+spanRightSelect;
		jQuery("#spanRight").val(makeUpVal);
	})
	
	var spanLeftText="";
	var spanLeftSelect="";
	jQuery("#spanLeftTe").on('input', function(){
		spanLeftText = jQuery("#spanLeftTe").val();
		var makeUpVal = spanLeftText+".0";
		jQuery("#spanLeft").val(makeUpVal);
	})
	jQuery("#spanLeftSe").change(function(){
		spanLeftSelect = jQuery("#spanLeftSe").val();
		var makeUpVal = spanLeftText+"."+spanLeftSelect;
		jQuery("#spanLeft").val(makeUpVal);
	})
	
	var calfRightText="";
	var calfRightSelect="";
	jQuery("#calfRightTe").on('input', function(){
		calfRightText = jQuery("#calfRightTe").val();
		var makeUpVal = calfRightText+".0";
		jQuery("#calfRight").val(makeUpVal);
	})
	jQuery("#calfRightSe").change(function(){
		calfRightSelect = jQuery("#calfRightSe").val();
		var makeUpVal = calfRightText+"."+calfRightSelect;
		jQuery("#calfRight").val(makeUpVal);
	})
	
	var calfLeftText="";
	var calfLeftSelect="";
	jQuery("#calfLeftTe").on('input', function(){
		calfLeftText = jQuery("#calfLeftTe").val();
		var makeUpVal = calfLeftText+".0";
		jQuery("#calfLeft").val(makeUpVal);
	})
	jQuery("#calfLeftSe").change(function(){
		calfLeftSelect = jQuery("#calfLeftSe").val();
		var makeUpVal = calfLeftText+"."+calfLeftSelect;
		jQuery("#calfLeft").val(makeUpVal);
	})
	
	var neckText="";
	var neckSelect="";
	jQuery("#neckTe").on('input', function(){
		neckText = jQuery("#neckTe").val();
		var makeUpVal = neckText+".0";
		jQuery("#neck").val(makeUpVal);
	})
	jQuery("#neckSe").change(function(){
		neckSelect = jQuery("#neckSe").val();
		var makeUpVal = neckText+"."+neckSelect;
		jQuery("#neck").val(makeUpVal);
	})
	
	//--------------------------------------------
	// 共通
	//--------------------------------------------
	// 全選択ボタン
	jQuery('button[id^="btn_as_"]').each(function() {
		jQuery(this).click(function(){
			var targetId = this.id.substring(7);
			jQuery('input[id^="'+targetId+'"]').each(function() {
				if (!jQuery(this).prop("disabled")) {
					jQuery(this).prop("checked", true);
					jQuery(this).change();
				}
			});
		});
	});

	// 全解除ボタン
	jQuery('button[id^="btn_ar_"]').each(function() {
		jQuery(this).click(function(){
			var targetId = this.id.substring(7);
			jQuery('input[id^="'+targetId+'"]').each(function() {
				if (!jQuery(this).prop("disabled")) {
					jQuery(this).prop("checked", false);
					jQuery(this).change();
				}
			});
		});
	});


	jQuery("#custNm").on('input', function(){
		var custNm = jQuery("#custNm").val();
		jQuery("#custNmDiv").html(custNm+" 様");
	})
	
	//--------------------------------------------
	// タブメニュー
	//--------------------------------------------
	jQuery('a[id^="nav1_"]').each(function() {
		jQuery(this).click(function(){
			if (jQuery(this).hasClass('active')) {
				return false;
			}
			var id = this.id;
			jQuery('a[id^="nav1_"]').each(function(index, element) {
				if (element.id == id) {
					jQuery(element).addClass("active");
				} else {
					jQuery(element).removeClass("active");
					jQuery('#'+element.id+'_div').hide();
				}
			});
			jQuery('#'+id+'_div').fadeIn(200);
			return false;
		});

		if (!jQuery(this).hasClass('active')) {
			jQuery('#'+this.id+'_div').hide();
		}
	});
	jQuery('a[id^="nav2_"]').each(function() {
		jQuery(this).click(function(){
			if (jQuery(this).hasClass('acrive')) {
				return false;
			}
			var id = this.id;
			jQuery('a[id^="nav2_"]').each(function(index, element) {
				if (element.id == id) {
					jQuery(element).addClass("active");
				} else {
					jQuery(element).removeClass("active");
					jQuery('#'+element.id+'_div').hide();
				}
			});
			jQuery('#'+id+'_div').fadeIn(200);
			return false;
		});

		if (!jQuery(this).hasClass('active')) {
			jQuery('#'+this.id+'_div').hide();
		}
	});

	//--------------------------------------------
	// 商品タブ
	//--------------------------------------------
	// アイテム
	jQuery('#item').change(function(){
		// 選択されたITEMを取得
		var item = jQuery(this).val();
		// ３Piece、スペアパンツ
		if (item == "01") {
			jQuery('#threePiece_div').show();
			jQuery('#sparePants_div').show();
			jQuery('#composBodyLiner_div').show();
			jQuery('#composSleeveLiner_div').show();
		}else if(item=='02'){
			jQuery('#composBodyLiner_div').show();
			jQuery('#composSleeveLiner_div').show();
			jQuery('#threePiece_div').hide();
			jQuery('#sparePants_div').hide();
		} else {
			jQuery('#threePiece_div').hide();
			jQuery('#sparePants_div').hide();
			jQuery('#composBodyLiner_div').hide();
			jQuery('#composSleeveLiner_div').hide();
			jQuery('#composBodyLiner').empty();
			jQuery('#productComposBodyLiner').val("");
			jQuery('#composSleeveLiner').empty();
			jQuery('#productComposSleeveLiner').val("");
		}
		
		// 生地品番 在庫チェック
		jQuery('#stockCheck').click(function() {
			var productFabricNo = jQuery("#productFabricNo").val();
			var item = jQuery("#item").val();
			jQuery.ajax({
				 type:"post",
				 url: contextPath + "/order/findStock",
				 data:{"item":item,"fabricNo":productFabricNo},
				 success:function(result){
					 if(null != result && "" != result){
						 jQuery("#stockMsg").html("-" + result.color + result.pattern + "在庫 " + result.theoreticalStock + "m");
						 jQuery("#fabric_brand_nm_p").html(result.brandName);
						 jQuery("#productFabricBrandNm").val(result.brandName);
						 jQuery("#service_nm_p").html(result.brandName+" "+result.materialName);
						 jQuery("#productServiceNm").val(result.brandName+" "+result.materialName);
						 if(result.compositionLabel.indexOf("/") != -1 ){
							 jQuery("#compos_frt_fabric_p").empty();
							 var labelArray = new Array();
							 labelArray = result.compositionLabel.split("/");
							 for (i=0; i<labelArray.length; i++ ){
								 jQuery("#compos_frt_fabric_p").append(labelArray[i]+"%").append("<Br>");
							 }
						 }else{
							 jQuery("#compos_frt_fabric_p").html(result.compositionLabel+"%");
						 }
						 jQuery("#productComposFrtFabric").val(result.compositionLabel);
						 jQuery("#notice").html(result.handlingCaution);
						 jQuery("#productNotice").val(result.handlingCaution);
				     }else{
				    	 jQuery("#notice").empty();
				    	 jQuery("#fabric_brand_nm_p").empty();
				    	 jQuery("#service_nm_p").empty();
						 jQuery("#compos_frt_fabric_p").empty();
				    	 appendAlert('stockMsg', "生地品番、およびITEMに関連する生地が存在しません");
					 }
				 }
			});
			jQuery('#stockMsg').show();
			return false;
		});

		// 刺繍入れ
		if (item == "01" || item == "02") {
			jQuery('input[id="embroidered_yes"]').prop("disabled",false);
		} else {
			jQuery('input[id="embroidered_yes"]').prop("disabled",true);
			jQuery('input[id="embroidered_no"]').prop("checked",true);
		}
		jQuery('input[name="productEmbroideryNecessity"]').change();

		// 刺繍糸色
		/* var embroideryColorElem = jQuery('#embroideryColor');
		var selectedEmbroideryColor = embroideryColorElem.val();
		embroideryColorElem.empty();
		var embroideryColorList = null;
		if (item == "02"||item == "01") {
			embroideryColorList = [
				{value:"110", text:"110（金茶）"},
				{value:"403", text:"403（白）"},
				{value:"402", text:"402（黒）"},
				{value:"760", text:"760（ネイビー）"},
				{value:"145", text:"145（水色）"},
				{value:"75", text:"75（ブルー）"},
				{value:"9", text:"9（赤）"},
				{value:"56", text:"56（グリーン）"},
				{value:"89", text:"89（ライトブラウン）"},
				{value:"94", text:"94（ブラウン）"},
				{value:"152", text:"152（ボルドー）"},
				{value:"169", text:"169（パープル）"},
				{value:"343", text:"343（ベージュ）"},
				{value:"701", text:"701（モカ）"},
			];
		} else {
			embroideryColorList = [
				{value:"110", text:"110（金茶）"},
				{value:"403", text:"403（白）"}
			];
		}
		var isExistSelectedEmbroideryColor = false;
		for (var i = 0; i < embroideryColorList.length; i++) {
			embroideryColorElem.append(jQuery('<option />').val(embroideryColorList[i].value).text(embroideryColorList[i].text));
			if (embroideryColorList[i].value == selectedEmbroideryColor) isExistSelectedEmbroideryColor = true;
		}
		if (isExistSelectedEmbroideryColor) {
			embroideryColorElem.val(selectedEmbroideryColor);
		} else {

			appendAlert('embroideryColorMsg', "デフォルトに変更しました。");

		} */

		// オプションタグ内の表示制御
		changeViewArea();
	});
	jQuery('#item').change();

	// ３Piece
	jQuery('input[name="productIs3Piece"]').each(function() {
		jQuery(this).change(changeViewArea);
	});

	// スペアパンツ
	jQuery('input[name="productSparePantsClass"]').each(function() {
		jQuery(this).change(changeViewArea);
	});

	// カテゴリ
	jQuery('input[name="productCategory"]').each(function() {
		jQuery(this).change(changeViewArea);
	});

	// 刺繍入れ
	jQuery('input[name="productEmbroideryNecessity"]').each(function() {
		jQuery(this).change(function(){
			// 選択中の刺繍入れ
			var productEmbroideryNecessity = jQuery('input[name=productEmbroideryNecessity]:checked').val();

			// 刺繍入れが有りの場合は刺繍関連項目を表示する
			if (productEmbroideryNecessity == '1') {
				jQuery('#embroidered_yes_area').show();
			} else {
				jQuery('#embroidered_yes_area').hide();
			}
		});
	});
	jQuery('#embroidered_no').change();

	//--------------------------------------------
	// オプションタブ（Jacket）
	//--------------------------------------------
	// フロント釦数
	jQuery('#oj_frontBtnCnt').change(function (){
		var frontBtnCnt = jQuery(this).val();
		if (frontBtnCnt == "ダブル６つボタン" || frontBtnCnt == "ダブル４つボタン") {
			jQuery('#lapelDesign_notch').prop('disabled', true);
			jQuery('#lapelDesign_notch').prop('checked', false);
			jQuery('#lapelDesign_peaked').prop('checked', true);
		} else {
			jQuery('#lapelDesign_notch').prop('disabled', false);
			jQuery('#lapelDesign_notch').prop('checked', true);
			jQuery('#lapelDesign_peaked').prop('checked', false);
		}
	});

	// 腰ポケット
	jQuery('input[id^="waistPkt_"]').each(function() {
		jQuery(this).change(function(){
			var waistPkt = jQuery(this).val();
			//0001203  パッチ
			if (waistPkt == "0001203") {
				appendAlert('waistPktMsg', "※2パッチ仕様になります。");
			}
		});
	});


	// 背裏地素材（上着と同じ）
	jQuery('#btn_og_backLiningMate').click(function() {
		// JACKET胴裏素材
		var bodyBackMate = jQuery('#bodyBackMate').val();
		// JACKET胴裏品番
		var bodyBackMateStkNo = jQuery('#bodyBackMateStkNo').val();

		// 背裏地素材への反映
		jQuery('#og_backLiningMate').val(bodyBackMate);
		jQuery('#og_backLiningMate').change();
		jQuery('#og_backLiningMateStkNo').val(bodyBackMateStkNo);
	});

	/* jQuery("#jacketModel").data("last",jQuery("#jacketModel").val()).change(function(){
		

	    var newvalue = jQuery("#jacketModel").val();
	    if(newvalue=='0'){
			return false;
		}
		var oldvalue = jQuery("#jacketModel").data("last");
		if(oldvalue=='0'){
			return false;
		}
		jQuery("#jacketModel").data("last", jQuery("#jacketModel").val()); 
		
	    if(newvalue == '0'&&oldvalue!='0'){
	    	newvalue = oldvalue;
		}
		
	    if(newvalue!='0'){
	    	jQuery("#jacketModel").val(newvalue)
		}
	}) */

	
	//袖裏素材（胴裏と同じ）
	jQuery('#btn_ojCuffBackMate').click(function(){
		//胴裏素材
		var bodyBackMate = jQuery("#bodyBackMate").val();
		//胴裏素材品番
		var bodyBackMateStkNo = jQuery("#bodyBackMateStkNo").val();
		
		//胴裏素材への反映
		jQuery("#cuffBackMate").val(bodyBackMate);
		jQuery("#cuffBackMate").change();
		jQuery("#cuffBackMateStkNo").val(bodyBackMateStkNo);
	});
	
	// 内側裏地素材（背裏地と同じ）
	jQuery('#btn_og_insideLiningMate').click(function() {
		// 背裏地素材
		var backLiningMate = jQuery('#og_backLiningMate').val();
		// 背裏地品番
		var backLiningMateStkNo = jQuery('#og_backLiningMateStkNo').val();

		// 背裏地素材への反映
		jQuery('#og_insideLiningMate').val(backLiningMate);
		jQuery('#og_insideLiningMate').change();
		jQuery('#og_insideLiningMateStkNo').val(backLiningMateStkNo);
	});

	// フロント釦（上着と同じ）
	jQuery('#btn_og_frontBtnMate').click(function() {
		// JACKET釦素材
		var btnMate = jQuery('#btnMate').val();
		// JACKET釦品番
		var btnMateStkNo = jQuery('#btnMateStkNo').val();

		// フロント釦への反映
		jQuery('#og_frontBtnMate').val(btnMate);
		jQuery('#og_frontBtnMate').change();
		jQuery('#og_frontBtnMateStkNo').val(btnMateStkNo);
	});

	// 裾上げ
	var hemUp = jQuery("#op_hemUp").val();
	if (hemUp == "0001702" || hemUp == "0001703") {
		jQuery('#op_doubleWide_div').show();
	}else{
		jQuery('#op_doubleWide').val("");
		jQuery('#op_doubleWide_div').hide();
	}
	//ダブル糸: 0001702 ,ダブルスナップ  :0001703
	jQuery('#op_hemUp').change(function (){
		var hemUp = jQuery(this).val();
		if (hemUp == "0001702" || hemUp == "0001703") {
			jQuery('#op_doubleWide_div').show();
			jQuery('#op_doubleWide').val("4");
		} else {
			jQuery('#op_doubleWide').val("");
			jQuery('#op_doubleWide_div').hide();
		}
	});

	//2Pants 裾上げ
	var hemUp2 = jQuery("#op2_hemUp").val();
	if (hemUp == "0001702" || hemUp2 == "0001703") {
		jQuery('#op2_doubleWide_div').show();
	}else{
		jQuery('#op2_doubleWide').val("");
		jQuery('#op2_doubleWide_div').hide();
	}
	//ダブル糸: 0001702 ,ダブルスナップ  :0001703
	jQuery('#op2_hemUp').change(function (){
		var hemUp2 = jQuery(this).val();
		if (hemUp2 == "0001702" || hemUp2 == "0001703") {
			jQuery('#op2_doubleWide_div').show();
		} else {
			jQuery('#op2_doubleWide_div').hide();
		}
	});
	

	// JKと同じボタン
	jQuery('#op_sameJacketBtn').click(function(){

		// JACKETの釦素材を取得
		var jacketBtnMateVal = jQuery("#btnMate").find("option:selected").val();
		//var jacketBtnMateText = jQuery("#btnMate").find("option:selected").text();
		//var jacketBtnMateVal = jQuery('#btnMate').val();
		//var jacketBtnMateText = jQuery('#btnMate').text();
		// JACKETの釦素材をPANTSの釦素材にコピー
		
		jQuery('#op_btnMate').val(jacketBtnMateVal);
		
		// 釦素材変更処理
		jQuery('#op_btnMate').change();

		// JACKETの釦品番を取得
		var jacketBtnMateStkNo = jQuery('#btnMateStkNo').val();
		// JACKETの釦品番をPANTSの釦品番にコピー
		jQuery('#op_btnMateStkNo').val(jacketBtnMateStkNo);

	});


	// JKと同じボタン
	jQuery('#op2_sameJacketBtn').click(function(){

		// JACKETの釦素材を取得
		var jacketBtnMate = jQuery('#btnMate').val();
		// JACKETの釦素材をPANTSの釦素材にコピー
		jQuery('#op2_btnMate').val(jacketBtnMate);
		// 釦素材変更処理
		jQuery('#op2_btnMate').change();

		// JACKETの釦品番を取得
		var jacketBtnMateStkNo = jQuery('#btnMateStkNo').val();
		// JACKETの釦品番をPANTSの釦品番にコピー
		jQuery('#op2_btnMateStkNo').val(jacketBtnMateStkNo);
	});


	// JKと同じボタン
	jQuery('#op3_sameJacketBtn').click(function(){

		// JACKETの釦素材を取得
		var jacketBtnMate = jQuery('#btnMate').val();
		// JACKETの釦素材をPANTSの釦素材にコピー
		jQuery('#op3_button').val(jacketBtnMate);
		// 釦素材変更処理
		jQuery('#op3_button').change();

		// JACKETの釦品番を取得
		var jacketBtnMateStkNo = jQuery('#btnMateStkNo').val();
		// JACKETの釦品番をPANTSの釦品番にコピー
		jQuery('#op3_btnMateStkNo').val(jacketBtnMateStkNo);
	});

	//--------------------------------------------
	// 補正タブ 
	//--------------------------------------------
	
	jQuery('input[type="range"]').each(function() {
		var elem = jQuery(this);
		var id = elem.prop('id');
		var step = elem.prop('step') - 0;
		elem.on('input', function(){
			
			jQuery('#'+id+'_out').val(this.value);
			var idRe = id.replace('Range','_div');
			var sizeVal = jQuery("#"+idRe+"_Size").val();
			var labelVaUplCm = jQuery('#'+idRe+'_html').html()
			var labelValUp = labelVaUplCm.replace('cm','');
			var thisVal = this.value;
			
			var val = (parseFloat(sizeVal)+parseFloat(this.value)).toFixed(1);
			//var idRejQ = jQuery('#'+idRe);
			//idRejQ.empty();
			//var alertElem = jQuery('<label id = "'+ idRe + '_html" value="'+val+'">'+ val + 'cm' + '</label>');
			//alertElem.appendTo(idRejQ);
			jQuery("#"+idRe+"_html").html(val+"cm");
			jQuery('#'+idRe+'_Gross').val(val);
			setFont(id);
		});
		jQuery('#'+id+'_p').click(function(){
			elem.val(elem.val()-0+step);
			jQuery('#'+id+'_out').val(elem.val());
			var max = document.getElementById(id).max;
			var idRe = id.replace('Range','_div');
			//ajax setlabel value
			var sizeVal = jQuery("#"+idRe+"_Size").val();
			var labelVaUplCm = jQuery('#'+idRe+'_html').html();
			if(typeof(labelVaUplCm)!="undefined"&&labelVaUplCm!=null){
				var idRejQ = jQuery('#'+idRe);
				
				var labelValUp = labelVaUplCm.replace('cm','');
				
				var maxVal = (parseFloat(max)+parseFloat(sizeVal)).toFixed(1);
				
				var val = (parseFloat(labelValUp)+parseFloat(step)).toFixed(1);

				if(val<=maxVal){
					//idRejQ.empty();
					//var alertElem = jQuery('<label id = "'+ idRe + '_html" value="'+val+'">'+ val + 'cm' + '</label>');
					//alertElem.appendTo(idRejQ);
					jQuery("#"+idRe+"_html").html(val+"cm");
					jQuery('#'+idRe+'_Gross').val(val);
				}else{
					return false;
				}
			}
			setFont(id);
			return false;
		});
		jQuery('#'+id+'_m').click(function(){
			elem.val(elem.val()-0-step);
			jQuery('#'+id+'_out').val(elem.val());
			var min = document.getElementById(id).min;
			var idRe = id.replace('Range','_div');
			//ajax setlabel value
			var sizeVal = jQuery("#"+idRe+"_Size").val();
			var labelValDoCm = jQuery('#'+idRe+'_html').html();
			if(typeof(labelValDoCm)!="undefined"&&labelValDoCm!=null){
				
				var idRejQ = jQuery('#'+idRe);

				var labelValDo = labelValDoCm.replace('cm','');

				var minVal = (parseFloat(min)+parseFloat(sizeVal)).toFixed(1);
				
				var val = (parseFloat(labelValDo)-parseFloat(step)).toFixed(1);
				if(val=>minVal){
					//idRejQ.empty();
					//var alertElem = jQuery('<label id = "'+ idRe + '_html" value="'+val+'">'+ val + 'cm' + '</label>');
					//alertElem.appendTo(idRejQ);
					
					jQuery("#"+idRe+"_html").html(val+"cm");
					jQuery('#'+idRe+'_Gross').val(val);
				}else{
					return false;
				}
			}
			setFont(id);
			return false;
		});
	});

	// PANTS2本目（1本目と同じ）
	jQuery('#btn_ap2_samePants').click(function (){
		jQuery('#selectPants2Figure').val(jQuery('#selectPantsFigure').val());
		jQuery('#selectPants2Number').val(jQuery('#selectPantsNumber').val());
		jQuery('#corPt2WaistRange').val(jQuery('#corPtWaistRange').val());
		jQuery('#corPt2WaistRange_out').val(jQuery('#corPt2WaistRange').val());
		setFont('corPt2WaistRange');
		
		jQuery('#corPt2ThighRange').val(jQuery('#corPtThighRange').val());
		jQuery('#corPt2ThighRange_out').val(jQuery('#corPt2ThighRange').val());
		setFont('corPt2ThighRange');
		
		jQuery('#corPt2HemwidthType').prop('checked', jQuery('#corPtHemwidthType').prop('checked'));
		jQuery('#corPt2HemwidthRange').val(jQuery('#corPtHemwidthRange').val());
		jQuery('#corPt2HemwidthRange_out').val(jQuery('#corPt2HemwidthRange').val());
		setFont('corPt2HemwidthRange');
		
		jQuery('#ap2_hemWidth_absolute').prop('checked', jQuery('#ap_hemWidth_absolute').prop('checked'));
		jQuery('#ap2_inseamLeft100').val(jQuery('#ap_inseamLeft100').val());
		jQuery('#ap2_inseamLeft10').val(jQuery('#ap_inseamLeft10').val());
		jQuery('#ap2_inseamLeft1').val(jQuery('#ap_inseamLeft1').val());
		jQuery('#ap2_inseamLeftM1').val(jQuery('#ap_inseamLeftM1').val());
		jQuery('#ap2_inseamRight100').val(jQuery('#ap_inseamRight100').val());
		jQuery('#ap2_inseamRight10').val(jQuery('#ap_inseamRight10').val());
		jQuery('#ap2_inseamRight1').val(jQuery('#ap_inseamRight1').val());
		jQuery('#ap2_inseamRightM1').val(jQuery('#ap_inseamRightM1').val());

		var ap2_inseamLeft100 = jQuery("#ap2_inseamLeft100").val();
		var ap2_inseamLeft10 = jQuery("#ap2_inseamLeft10").val();
		var ap2_inseamLeft1 = jQuery("#ap2_inseamLeft1").val();
		var ap2_inseamLeftM1 = jQuery("#ap2_inseamLeftM1").val();
		var corPt2LeftinseamGross = ap2_inseamLeft100+ap2_inseamLeft10+ap2_inseamLeft1+"."+ap2_inseamLeftM1;
		jQuery("#corPt2LeftinseamGross").val(corPt2LeftinseamGross);
		
		var ap2_inseamRight100 = jQuery("#ap2_inseamRight100").val();
		var ap2_inseamRight10 = jQuery("#ap2_inseamRight10").val();
		var ap2_inseamRight1 = jQuery("#ap2_inseamRight1").val();
		var ap2_inseamRightM1 = jQuery("#ap2_inseamRightM1").val();
		var corPt2RightinseamGross = ap2_inseamRight100+ap2_inseamRight10+ap2_inseamRight1+"."+ap2_inseamRightM1;
		jQuery("#corPt2RightinseamGross").val(corPt2RightinseamGross);

		
		jQuery("#corPt2Waist_div_html").html(jQuery("#corPtWaist_div_html").html());
		jQuery("#corPt2Waist_div_Size").val(jQuery("#corPtWaist_div_Size").val());
		jQuery("#corPt2Waist_div_Gross").val(jQuery("#corPtWaist_div_Gross").val());

		jQuery("#corPt2Thigh_div_html").html(jQuery("#corPtThigh_div_html").html());
		jQuery("#corPt2Thigh_div_Size").val(jQuery("#corPtThigh_div_Size").val());
		jQuery("#corPt2Thigh_div_Gross").val(jQuery("#corPtThigh_div_Gross").val());

		jQuery("#corPt2Hemwidth_div_html").html(jQuery("#corPtHemwidth_div_html").html());
		jQuery("#corPt2Hemwidth_div_Size").val(jQuery("#corPtHemwidth_div_Size").val());
		jQuery("#corPt2Hemwidth_div_Gross").val(jQuery("#corPtHemwidth_div_Gross").val());
		
	});

	// PANTS3本目（1本目と同じ）
	jQuery('#btn_ap3_samePants').click(function (){
		jQuery('#ap3_pantsSizeA').val(jQuery('#ap_pantsSizeA').val());
		jQuery('#ap3_pantsSizeN').val(jQuery('#ap_pantsSizeN').val());
		jQuery('#ap3_waist').val(jQuery('#ap_waist').val());
		jQuery('#ap3_waist_out').val(jQuery('#ap3_waist').val());
		setFont('ap3_waist');
		jQuery('#ap3_watari').val(jQuery('#ap_watari').val());
		jQuery('#ap3_watari_out').val(jQuery('#ap2_watari').val());
		setFont('ap3_watari');
		jQuery('#ap3_hemWidth_relative').prop('checked', jQuery('#ap_hemWidth_relative').prop('checked'));
		jQuery('#ap3_hemWidthRel').val(jQuery('#ap_hemWidthRel').val());
		jQuery('#ap3_hemWidthRel_out').val(jQuery('#ap2_hemWidthRel').val());
		setFont('ap3_hemWidthRel');
		jQuery('#ap3_hemWidth_absolute').prop('checked', jQuery('#ap_hemWidth_absolute').prop('checked'));
		jQuery('#ap3_hemWidthAbs10').val(jQuery('#ap_hemWidthAbs10').val());
		jQuery('#ap3_hemWidthAbs1').val(jQuery('#ap_hemWidthAbs1').val());
		jQuery('#ap3_inseamLeft100').val(jQuery('#ap_inseamLeft100').val());
		jQuery('#ap3_inseamLeft10').val(jQuery('#ap_inseamLeft10').val());
		jQuery('#ap3_inseamLeft1').val(jQuery('#ap_inseamLeft1').val());
		jQuery('#ap3_inseamLeftM1').val(jQuery('#ap_inseamLeftM1').val());
		jQuery('#ap3_inseamRight100').val(jQuery('#ap_inseamRight100').val());
		jQuery('#ap3_inseamRight10').val(jQuery('#ap_inseamRight10').val());
		jQuery('#ap3_inseamRight1').val(jQuery('#ap_inseamRight1').val());
		jQuery('#ap3_inseamRightM1').val(jQuery('#ap_inseamRightM1').val());
	});
});



/************************************************
 * 部品メソッド
 ************************************************/
//--------------------------------------------
// 共通
//--------------------------------------------
// 指定したIDの要素にアラートを挿入する
function appendAlert(id, message) {
	jQuery('#'+id).empty();
	var alertElem = jQuery(
		'<div class="alert alert-warning alert-dismissible" role="alert" style="display:none;">' +
		'<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
//		'<strong><i class="fa fa-exclamation-triangle"></i></strong> ' + message +
		'<i class="fa fa-exclamation-triangle"></i> ' + message +
		'</div>');
	alertElem.appendTo('#'+id);
	alertElem.fadeIn(500);
}

//--------------------------------------------
//商品タブ用
//--------------------------------------------
function changeViewArea() {
	// 選択中のITEM
	var item = jQuery('#item').val();
	// 選択中の３Piece
	var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
	// 選択中のスペアパンツ
	var sparePants = jQuery('input[name="productSparePantsClass"]:checked').val();

	if (item == "01") {
		jQuery('#op_jacket_div').show();
		jQuery('#al_jacket_div').show();
		if (threePiece == "1") {
			jQuery('#op_gilet_div').show();
			jQuery('#btn_og_backLiningMate').show();
			jQuery('#btn_og_frontBtnMate').show();
			jQuery('#al_gilet_div').show();
		} else {
			jQuery('#op_gilet_div').hide();
			jQuery('#al_gilet_div').hide();
		}
		jQuery('#op_pants_div').show();
		jQuery('#al_pants_div').show();
		if (sparePants == "1" || sparePants == "3パンツ") {
			jQuery('#op2_pants_div').show();
			jQuery('#al2_pants_div').show();
		} else {
			jQuery('#op2_pants_div').hide();
			jQuery('#al2_pants_div').hide();
		}
		if (sparePants == "3パンツ") {
			jQuery('#op3_pants_div').show();
			jQuery('#al3_pants_div').show();
		} else {
			jQuery('#op3_pants_div').hide();
			jQuery('#al3_pants_div').hide();
		}
		jQuery('#op_sameJacketBtn').show();
	} else if (item == "02") {
		jQuery('#op_jacket_div').show();
		jQuery('#al_jacket_div').show();
		jQuery('#op_gilet_div').hide();
		jQuery('#al_gilet_div').hide();
		jQuery('#op_pants_div').hide();
		jQuery('#al_pants_div').hide();
		jQuery('#op2_pants_div').hide();
		jQuery('#al2_pants_div').hide();
		jQuery('#op3_pants_div').hide();
		jQuery('#al3_pants_div').hide();
		jQuery('#op_sameJacketBtn').hide();
	} else if (item == "03") {
		jQuery('#op_jacket_div').hide();
		jQuery('#al_jacket_div').hide();
		jQuery('#op_gilet_div').hide();
		jQuery('#al_gilet_div').hide();
		jQuery('#op_pants_div').show();
		jQuery('#al_pants_div').show();
		jQuery('#op2_pants_div').hide();
		jQuery('#al2_pants_div').hide();
		jQuery('#op3_pants_div').hide();
		jQuery('#al3_pants_div').hide();
		jQuery('#op_sameJacketBtn').hide();
	} else if (item == "04") {
		jQuery('#op_jacket_div').hide();
		jQuery('#al_jacket_div').hide();
		jQuery('#op_gilet_div').show();
		jQuery('#al_gilet_div').show();
		jQuery('#op_pants_div').hide();
		jQuery('#al_pants_div').hide();
		jQuery('#op2_pants_div').hide();
		jQuery('#al2_pants_div').hide();
		jQuery('#op3_pants_div').hide();
		jQuery('#al3_pants_div').hide();
		jQuery('#btn_og_backLiningMate').hide();
		jQuery('#btn_og_frontBtnMate').hide();
		jQuery('#op_sameJacketBtn').hide();
	} 
}



//--------------------------------------------
// オプションタブ用(Jacket)
//--------------------------------------------

//--------------------------------------------
// オプションタブ用(Jilet)
//--------------------------------------------

//--------------------------------------------
// オプションタブ用(Pants)
//--------------------------------------------
// 裾上げ変更時処理
/* function changeOpHemUp() {
	var hemUp = jQuery('#op_hemUp').val();
	//ダブル糸:0001702   ダブルスナップ:0001703
	if (hemUp == "0001702" || hemUp == "0001703") {
		jQuery('#op_doubleWide').show();
	} else {
		jQuery('#op_doubleWide').hide();
	}
} */

//--------------------------------------------
//オプションタブ用(Pants2本目)
//--------------------------------------------
/* function changeOp2HemUp() {
	var hemUp2 = jQuery('#op2_hemUp').val();
	//ダブル糸:0001702   ダブルスナップ:0001703
	if (hemUp2 == "0001702" || hemUp2 == "0001703") {
		jQuery('#op2_doubleWide').show();
	} else {
		jQuery('#op2_doubleWide').hide();
	}
} */
//--------------------------------------------
//オプションタブ用(Pants3本目)
//--------------------------------------------

//--------------------------------------------
// 補正タブ用
//--------------------------------------------
function setFont(id) {
	var color = "black";
	var value = jQuery('#'+id).val() - 0;
	if (value < 0) {
		color = "red";
	} else if (value > 0) {
		color = "blue";
	}
	jQuery('#'+id).parent().css("color", color);
}

//--------------------------------------------
// 読み込み時
//--------------------------------------------


//--------------------------------------------
//メジャーリングの初期化
//--------------------------------------------
function measuring(){
	
	var measuringList = [
		{type:"fullLength",size:"${measuring.fullLength}"},
		{type:"shoulder",size:"${measuring.shoulder}"},
		{type:"reachRight",size:"${measuring.reachRight}"},
		{type:"reachLeft",size:"${measuring.reachLeft}"},
		{type:"outBust",size:"${measuring.outBust}"},
		{type:"bust",size:"${measuring.bust}"},
		{type:"jacketWaist",size:"${measuring.jacketWaist}"},
		{type:"pantsWaist",size:"${measuring.pantsWaist}"},
		{type:"hip",size:"${measuring.hip}"},
		{type:"spanRight",size:"${measuring.spanRight}"},
		{type:"spanLeft",size:"${measuring.spanLeft}"},
		{type:"calfRight",size:"${measuring.calfRight}"},
		{type:"calfLeft",size:"${measuring.calfLeft}"},
		{type:"neck",size:"${measuring.neck}"}
		]
	
	var i = null;
	for(i of measuringList){
		var measuring = i.size;
		measuring = measuring.split(".");
		jQuery("#"+i.type+"Te").val(measuring[0]);
		jQuery("#"+i.type+"Se").val(measuring[1]);
		jQuery("#"+i.type).val(i.size)
	}
	

}


//--------------------------------------------
//補正の初期化
//--------------------------------------------
function adjustInit(){
	//補正
	//JKサイズを設定
	var selectJacketFigure = "${order.corJkDrop}";
	var selectJacketNumber = "${order.corJkSize}";
	jQuery("#selectJacketFigure").val(selectJacketFigure);
	jQuery("#selectJacketNumber").val(selectJacketNumber);
	
	//JK 型サイズ値、補正値とグロス値を設定
	var corJkBodySize = "${order.corJkBodylengthSize}"
	jQuery("#corJkBody_div_Size").val(corJkBodySize);
	var corJkBodyGross = "${order.corJkBodylengthGross}"
	jQuery("#corJkBody_div_Gross").val(corJkBodyGross);
	jQuery("#corJkBody_div_html").html(corJkBodyGross+"cm");
	var corJkBodyCorrect = (Number(corJkBodyGross)-Number(corJkBodySize));
	jQuery("#corJkBodyRange_out").html(corJkBodyCorrect);
	jQuery("#corJkBodyRange").val(corJkBodyCorrect);
	
	var corJkWaistSize = "${order.corJkWaistSize}"
	jQuery("#corJkWaist_div_Size").val(corJkWaistSize);
	var corJkWaistGross = "${order.corJkWaistGross}"
	jQuery("#corJkWaist_div_Gross").val(corJkWaistGross);
	jQuery("#corJkWaist_div_html").html(corJkWaistGross+"cm");
	var corJkWaistCorrect = (Number(corJkWaistGross)-Number(corJkWaistSize));
	jQuery("#corJkWaistRange_out").html(corJkWaistCorrect);
	jQuery("#corJkWaistRange").val(corJkWaistCorrect);

	var corJkRightsleeveSize = "${order.corJkRightsleeveSize}"
	jQuery("#corJkRightsleeve_div_Size").val(corJkRightsleeveSize);
	var corJkRightsleeveGross = "${order.corJkRightsleeveGross}"
	jQuery("#corJkRightsleeve_div_Gross").val(corJkRightsleeveGross);
	jQuery("#corJkRightsleeve_div_html").html(corJkRightsleeveGross+"cm");
	var corJkRightsleeveCorrect = (Number(corJkRightsleeveGross)-Number(corJkRightsleeveSize));
	jQuery("#corJkRightsleeveRange_out").html(corJkRightsleeveCorrect);
	jQuery("#corJkRightsleeveRange").val(corJkRightsleeveCorrect);

	var corJkLeftsleeveSize = "${order.corJkLeftsleeveSize}"
	jQuery("#corJkLeftsleeve_div_Size").val(corJkLeftsleeveSize);
	var corJkLeftsleeveGross = "${order.corJkLeftsleeveGross}"
	jQuery("#corJkLeftsleeve_div_Gross").val(corJkLeftsleeveGross);
	jQuery("#corJkLeftsleeve_div_html").html(corJkLeftsleeveGross+"cm");
	var corJkLeftsleeveCorrect = (Number(corJkLeftsleeveGross)-Number(corJkLeftsleeveSize));
	jQuery("#corJkLeftsleeveRange_out").html(corJkLeftsleeveCorrect);
	jQuery("#corJkLeftsleeveRange").val(corJkLeftsleeveCorrect);
	
	//PTサイズを設定
	var selectPantsFigure = "${order.corPtDrop}"
	var selectPantsNumber = "${order.corPtSize}"
	jQuery("#selectPantsFigure").val(selectPantsFigure);
	jQuery("#selectPantsNumber").val(selectPantsNumber);
	
	//PT　型サイズ値、補正値とグロス値を設定
	var corPtWaistSize = "${order.corPtWaistSize}"
	jQuery("#corPtWaist_div_Size").val(corPtWaistSize);
	var corPtWaistGross = "${order.corPtWaistGross}";
	jQuery("#corPtWaist_div_Gross").val(corPtWaistGross);
	jQuery("#corPtWaist_div_html").html(corPtWaistGross+"cm");
	var corPtWaistCorrect = (Number(corPtWaistGross)-Number(corPtWaistSize));
	jQuery("#corPtWaistRange_out").html(corPtWaistCorrect);
	jQuery("#corPtWaistRange").val(corPtWaistCorrect);
	
	var corPtThighSize = "${order.corPtThighwidthSize}"
	jQuery("#corPtThigh_div_Size").val(corPtThighSize);
	var corPtThighGross = "${order.corPtThighwidthGross}";
	jQuery("#corPtThigh_div_Gross").val(corPtThighGross);
	jQuery("#corPtThigh_div_html").html(corPtThighGross+"cm");
	var corPtThighCorrect = (Number(corPtThighGross)-Number(corPtThighSize));
	jQuery("#corPtThighRange_out").html(corPtThighCorrect);
	jQuery("#corPtThighRange").val(corPtThighCorrect);

	var corPtHemwidthSize = "${order.corPtHemwidthSize}"
	jQuery("#corPtHemwidth_div_Size").val(corPtHemwidthSize);
	var corPtHemwidthGross = "${order.corPtHemwidthGross}";
	jQuery("#corPtHemwidth_div_Gross").val(corPtHemwidthGross);
	jQuery("#corPtHemwidth_div_html").html(corPtThighGross+"cm");
	var corPtHemwidthCorrect = (Number(corPtHemwidthGross)-Number(corPtHemwidthSize));
	jQuery("#corPtHemwidthRange_out").html(corPtHemwidthCorrect);
	jQuery("#corPtHemwidthRange").val(corPtHemwidthCorrect);

	var corPtRightinseamGross = "${order.corPtRightinseamGross}"
	jQuery("#corPtRightinseamGross").val(corPtRightinseamGross);	
	corPtRightinseamGross = corPtRightinseamGross.split(".");
	jQuery("#ap_inseamRightM1").val(corPtRightinseamGross[1])
	var str = corPtRightinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var right1 = str[2]
		var right10 = str[1]
		var right100 = str[0]
		jQuery("#ap_inseamRight100").val(right100)
		jQuery("#ap_inseamRight10").val(right10)
		jQuery("#ap_inseamRight1").val(right1)
	}else if(str.length == 2){
		str = str.split("");
		var right1 = str[1]
		var right10 = str[0]
		jQuery("#ap_inseamRight100").val("0")
		jQuery("#ap_inseamRight10").val(right10)
		jQuery("#ap_inseamRight1").val(right1)
	}else if(str.length == 1){
		str = str.split("");
		var right1 = str[0]
		jQuery("#ap_inseamRight100").val("0")
		jQuery("#ap_inseamRight10").val("0")
		jQuery("#ap_inseamRight1").val(right1)
	}
	
	var corPtLeftinseamGross = "${order.corPtLeftinseamGross}"
	jQuery("#corPtLeftinseamGross").val(corPtLeftinseamGross);
	corPtLeftinseamGross = corPtLeftinseamGross.split(".");
	jQuery("#ap_inseamLeftM1").val(corPtLeftinseamGross[1])
	var str = corPtLeftinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var left1 = str[2]
		var left10 = str[1]
		var left100 = str[0]
		jQuery("#ap_inseamLeft100").val(left100)
		jQuery("#ap_inseamLeft10").val(left10)
		jQuery("#ap_inseamLeft1").val(left1)
	}else if(str.length == 2){
		str = str.split("");
		var left1 = str[1]
		var left10 = str[0]
		jQuery("#ap_inseamLeft100").val("0")
		jQuery("#ap_inseamLeft10").val(left10)
		jQuery("#ap_inseamLeft1").val(left1)
	}else if(str.length == 1){
		str = str.split("");
		var left1 = str[0]
		jQuery("#ap_inseamLeft100").val("0")
		jQuery("#ap_inseamLeft10").val("0")
		jQuery("#ap_inseamLeft1").val(left1)
	}
	
	
	//2PTサイズを設定
	var selectPants2Figure = "${order.corPt2Drop}"
	var selectPants2Number = "${order.corPt2Size}"
	jQuery("#selectPants2Figure").val(selectPants2Figure);
	jQuery("#selectPants2Number").val(selectPants2Number);
	
	//2PT　型サイズ値、補正値とグロス値を設定
	var corPt2WaistSize = "${order.corPt2WaistSize}"
	jQuery("#corPt2Waist_div_Size").val(corPt2WaistSize);
	var corPt2WaistGross = "${order.corPt2WaistGross}";
	jQuery("#corPt2Waist_div_Gross").val(corPt2WaistGross);
	jQuery("#corPt2Waist_div_html").html(corPt2WaistGross+"cm");
	var corPt2WaistCorrect = (Number(corPt2WaistGross)-Number(corPt2WaistSize));
	jQuery("#corPt2WaistRange_out").html(corPt2WaistCorrect);
	jQuery("#corPt2WaistRange").val(corPt2WaistCorrect);
	
	var corPt2ThighSize = "${order.corPt2ThighwidthSize}"
	jQuery("#corPt2Thigh_div_Size").val(corPt2ThighSize);
	var corPt2ThighGross = "${order.corPt2ThighwidthGross}";
	jQuery("#corPt2Thigh_div_Gross").val(corPt2ThighGross);
	jQuery("#corPt2Thigh_div_html").html(corPt2ThighGross+"cm");
	var corPt2ThighCorrect = (Number(corPt2ThighGross)-Number(corPt2ThighSize));
	jQuery("#corPt2ThighRange_out").html(corPt2ThighCorrect);
	jQuery("#corPt2ThighRange").val(corPt2ThighCorrect);

	var corPt2HemwidthSize = "${order.corPt2HemwidthSize}"
	jQuery("#corPt2Hemwidth_div_Size").val(corPt2HemwidthSize);
	var corPt2HemwidthGross = "${order.corPt2HemwidthGross}";
	jQuery("#corPt2Hemwidth_div_Gross").val(corPt2HemwidthGross);
	jQuery("#corPt2Hemwidth_div_html").html(corPt2ThighGross+"cm");
	var corPt2HemwidthCorrect = (Number(corPt2HemwidthGross)-Number(corPt2HemwidthSize));
	jQuery("#corPt2HemwidthRange_out").html(corPt2HemwidthCorrect);
	jQuery("#corPt2HemwidthRange").val(corPt2HemwidthCorrect);

	var corPt2RightinseamGross = "${order.corPt2RightinseamGross}"
	jQuery("#corPt2RightinseamGross").val(corPt2RightinseamGross);
	corPt2RightinseamGross = corPt2RightinseamGross.split(".");
	jQuery("#ap2_inseamRightM1").val(corPt2RightinseamGross[1])
	var str = corPt2RightinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var right1 = str[2]
		var right10 = str[1]
		var right100 = str[0]
		jQuery("#ap2_inseamRight100").val(right100)
		jQuery("#ap2_inseamRight10").val(right10)
		jQuery("#ap2_inseamRight1").val(right1)
	}else if(str.length == 2){
		str = str.split("");
		var right1 = str[1]
		var right10 = str[0]
		jQuery("#ap2_inseamRight100").val("0")
		jQuery("#ap2_inseamRight10").val(right10)
		jQuery("#ap2_inseamRight1").val(right1)
	}else if(str.length == 1){
		str = str.split("");
		var right1 = str[0]
		jQuery("#ap2_inseamRight100").val("0")
		jQuery("#ap2_inseamRight10").val("0")
		jQuery("#ap2_inseamRight1").val(right1)
	}
	
	
	var corPt2LeftinseamGross = "${order.corPt2LeftinseamGross}"
	jQuery("#corPt2LeftinseamGross").val(corPt2LeftinseamGross);
	corPt2LeftinseamGross = corPt2LeftinseamGross.split(".");
	jQuery("#ap2_inseamLeftM1").val(corPt2LeftinseamGross[1])
	var str = corPt2LeftinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var left1 = str[2]
		var left10 = str[1]
		var left100 = str[0]
		jQuery("#ap2_inseamLeft100").val(left100)
		jQuery("#ap2_inseamLeft10").val(left10)
		jQuery("#ap2_inseamLeft1").val(left1)
	}else if(str.length == 2){
		str = str.split("");
		var left1 = str[1]
		var left10 = str[0]
		jQuery("#ap2_inseamLeft100").val("0")
		jQuery("#ap2_inseamLeft10").val(left10)
		jQuery("#ap2_inseamLeft1").val(left1)
	}else if(str.length == 1){
		str = str.split("");
		var left1 = str[0]
		jQuery("#ap2_inseamLeft100").val("0")
		jQuery("#ap2_inseamLeft10").val("0")
		jQuery("#ap2_inseamLeft1").val(left1)
	}
	
	
	//GLサイズを設定
	var selectGiletFigure = "${order.corGlDrop}";
	var selectGiletNumber = "${order.corGlSize}";
	jQuery("#selectGiletFigure").val(selectJacketFigure);
	jQuery("#selectGiletNumber").val(selectJacketNumber);
}

//--------------------------------------------
//素材品番の初期化
//--------------------------------------------
function mateInit(){
	var subItemCode;
	var category;
	var StkNo;
	var mateChecked;
	var orderPattern = "PO";
	var optionCode;
	// 標準の場合　Jacket 胴裏素材と袖裏素材と釦素材のid List
	var jkStandardMateList = ["bodyBackMate","cuffBackMate","btnMate"];
	// 標準の場合　Gilet 背裏地素材と内側裏地素材とフロント釦のid List
	var glStandardMateList = ["og_backLiningMate","og_insideLiningMate","og_frontBtnMate"];
	var item = jQuery("#item option:first").val();
	if(item == "01"){
		initSuitStandard()
	}
		jQuery("#item").change(function(){
			jQuery("#category option:first").prop("selected",true);
			var item = jQuery("#item").val();
			if(item=="02"){
				subItemCode = "02";
				category = jQuery("#category").val();
				if(category=="01"){
					initJkStandard(subItemCode);
				}
				jQuery("#category").change(function(){
					initJkStandard(subItemCode);
			    });
			}else if(item=="03"){
				subItemCode = "03";
				category = jQuery("#category").val();
				if(category=="1"){
					initPtStandard(subItemCode);
					initPt2Standard(subItemCode);
				}
				jQuery("#category").change(function(){
					initPtStandard(subItemCode);
					initPt2Standard(subItemCode);
			    });
			}else if(item=="04"){
				subItemCode = "04";
				category = jQuery("#category").val();
				if(category=="1"){
					initGlStandard(subItemCode);
				}
				jQuery("#category").change(function(){
					category = jQuery("#category").val();
					initGlStandard(subItemCode);
			    });
			}
			
		})
	
		function initSuitStandard(){
			subItemCode = "02";
			initJkStandard(subItemCode);
			subItemCode = "03";
			initPtStandard(subItemCode);
			initPt2Standard(subItemCode);
			subItemCode = "04";
			initGlStandard(subItemCode);
		}
			
		function initGlStandard(subItemCode){
			for(var i in glStandardMateList){
				optionCode = data[glStandardMateList[i]];
				mateChecked = jQuery("#"+glStandardMateList[i]+" option:checked").val();
				StkNo = "#"+glStandardMateList[i]+"StkNo";
				mateSelect(subItemCode,mateChecked,optionCode,StkNo,0,orderPattern);
			}
			jQuery("#og_backLiningMate,#og_insideLiningMate,#og_frontBtnMate").change(function(){
				var idValue = jQuery(this).prop("id");
				optionCode = data[idValue];
				mateChecked = jQuery("#"+idValue+" option:checked").val();
				StkNo = "#"+idValue+"StkNo";
				mateSelect(subItemCode,mateChecked,optionCode,StkNo,0,orderPattern);
			})	
		}
		function initPtStandard(subItemCode) {
			mateChecked = jQuery("#op_btnMate option:checked").val();
			optionCode = data["op_btnMate"];
			StkNo = "#op_btnMateStkNo";
			mateSelect(subItemCode, mateChecked,optionCode,StkNo,0,orderPattern);
			jQuery("#op_btnMate").change(function() {
				optionCode = data["op_btnMate"];
				mateChecked = jQuery("#op_btnMate option:checked").val();
				StkNo = "#op_btnMateStkNo";
				mateSelect(subItemCode, mateChecked,optionCode,StkNo,0,orderPattern);
			})
		}
		function initPt2Standard(subItemCode) {
			mateChecked = jQuery("#op2_btnMate option:checked").val();
			optionCode = data["op2_btnMate"];
			StkNo = "#op2_btnMateStkNo";
			mateSelect(subItemCode, mateChecked,optionCode,StkNo,0,orderPattern);
			jQuery("#op2_btnMate").change(function() {
				optionCode = data["op2_btnMate"];
				mateChecked = jQuery("#op2_btnMate option:checked").val();
				StkNo = "#op2_btnMateStkNo";
				mateSelect(subItemCode, mateChecked,optionCode,StkNo,0,orderPattern);
			})
		}
		function initJkStandard(subItemCode){
			for(var i in jkStandardMateList){
				optionCode = data[jkStandardMateList[i]];
				mateChecked = jQuery("#"+jkStandardMateList[i]+" option:checked").val();
				StkNo = "#"+jkStandardMateList[i]+"StkNo";
				mateSelect(subItemCode,mateChecked,optionCode,StkNo,0,orderPattern);
			}
			jQuery("#bodyBackMate,#cuffBackMate,#btnMate").change(function(){
				var idValue = jQuery(this).prop("id");
				optionCode = data[idValue];
				mateChecked = jQuery("#"+idValue+" option:checked").val();
				StkNo = "#"+idValue+"StkNo";
				mateSelect(subItemCode,mateChecked,optionCode,StkNo,0,orderPattern);
			})	
		}
		
		function mateSelect(subItemCode,mateChecked,optionCode,StkNo,type,orderPattern){
			var StkNoSelect = jQuery(StkNo);
			var url;
			if (type == 0){
				url = "/order/standardMateSelect";
			}else if(type == 1){
				url = "/order/tuxdoMateSelect";
			}else if(type == 2){
				url = "/order/washabiMateSelect";
			}
			jQuery.ajax({
				 type:"post",
				 url: contextPath + url,
				 async: false,
				 data:{"itemCode":subItemCode,"mateChecked":mateChecked,"orderPattern":orderPattern,"optionCode":optionCode},
				 success:function(result){
					 StkNoSelect.empty();
					 if(Object.keys(result).length==0){
						 StkNoSelect.prop("disabled",true);
					 }else{
						 StkNoSelect.removeAttr("disabled");
						 for (var key in result) {
							 StkNoSelect.append(jQuery('<option />').val(key).text(result[key]));
						 }
					 }
					 
				 }
			});
		}
}

//--------------------------------------------
//日期フォーマット
//--------------------------------------------
function dateFormat(time){
	var date = new Date(custDeliverDate);
	var year = date.getFullYear();  
	var month = date.getMonth() + 1
	if(month<=9){
		month = "0" + month;
	}
	var day = date.getDate();
	if(day<=9){
		day = "0" + day;
	}
	return year+"-"+month+"-"+day;
}

//--------------------------------------------
//jacket 金額変更制御
//--------------------------------------------
function jacketChangePrice(result,jkModelCode){
	var frontBtnCntVal = jQuery("#oj_frontBtnCnt").val();
	for(i of jkPriceList){
		if(frontBtnCntVal=="0000105"||frontBtnCntVal=="0000106"){
			if(i.type == "2"){
				var idValue = i.id;
				var thisVal = jQuery("#"+idValue).val();
				dealWithDoublePice(idValue,thisVal,result,jkModelCode);
			}else if(i.type == "1"){
				var idValue = i.id;
				var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
				dealWithDoublePice(idValue,thisVal,result,jkModelCode);
			}
		}else{
			if(i.type == "2"){
				var idValue = i.id;
				var thisVal = jQuery("#"+idValue).val();
				dealWithPice(idValue,thisVal,result,jkModelCode);
			}else if(i.type == "1"){
				var idValue = i.id;
				var thisVal = jQuery(":radio[name='" + i.idVal + "']:checked").val();
				dealWithPice(idValue,thisVal,result,jkModelCode);
			}
		}
		
	}
}

//--------------------------------------------
//全部のitem金額制御
//--------------------------------------------
function getPrice(){
	 var optionCode=""
	 var subItemCode = "";
	 var modelCode = "";
	 var orderPattern = "PO";
	 
		jQuery.ajax({url : contextPath + "/order/getBranchPrice", 
			data:{"orderPattern":orderPattern},
			type : 'get'}).then(function(result) {

			jQuery("#op_pantsModel").change(function(){
				modelCode = jQuery("#op_pantsModel").val();
				jQuery('input[id^="op_adjuster_"],[id^="op_stitch_"],[id^="op_eight_"],[id^="op_thick_"],[id^="op_shapeMemory_"],[id^="op_blister_"]').click(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,modelCode);
				});
				jQuery("#op_hemUp,#op_tack,#op_doubleWide,#op_btnMate,#op_btnMateStkNo").change(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,modelCode);
				})
			})
			
			jQuery("#op2_pantsModel").change(function(){
				modelCode = jQuery("#op2_pantsModel").val();
				jQuery('input[id^="op2_adjuster_"],[id^="op2_stitch_"],[id^="op2_eight_"],[id^="op2_thick_"],[id^="op2_shapeMemory_"],[id^="op2_blister_"]').click(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,modelCode);
				});
				jQuery("#op2_hemUp,#op2_tack,#op2_doubleWide,#op2_btnMate,#op2_btnMateStkNo").change(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,modelCode);
				})
			})
			
			jQuery("#jacketModel").change(function(){
				modelCode = jQuery("#jacketModel").val();
				var frontBtnCntVal = "";
				jQuery("#oj_frontBtnCnt,#bodyBackMate,#bodyBackMateStkNo,#cuffBackMate,#cuffBackMateStkNo,#btnMate,#btnMateStkNo")
				.change(function(){
					
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					frontBtnCntVal = jQuery("#oj_frontBtnCnt").val();
					if(frontBtnCntVal=="0000105"||frontBtnCntVal=="0000106"){
						dealWithDoublePice(idValue,thisVal,result,modelCode);
					}else{
						dealWithPice(idValue,thisVal,result,modelCode);
					}
					return frontBtnCntVal;
				})
				//
				jQuery('input[id^="lapelDesign_"],[id^="fort_"],[id^="backSpec_"],[id^="waistPkt_"],[id^="changePkt_"],[id^="slantedPkt_"],[id^="cuffSpec_"],[id^="stitch_"],[id^="ventSpec_"],[id^="shapeMemory_"]').click(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					frontBtnCntVal = jQuery("#oj_frontBtnCnt").val();
					//ダブル6つボタン : 0000105    ダブル4つボタン:0000106
					if(frontBtnCntVal=="0000105"||frontBtnCntVal=="0000106"){
						dealWithDoublePice(idValue,thisVal,result,modelCode);
					}else{
						dealWithPice(idValue,thisVal,result,modelCode);
					}

				});
				
			})
			
			jQuery("#giletModel").change(function(){
				modelCode = jQuery("#giletModel").val();
				jQuery('input[id^="og_stitch_"]').click(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,modelCode);
				})
	
				
				jQuery("#og_backLiningMate,#og_backLiningMateStkNo,#og_insideLiningMate,#og_insideLiningMateStkNo,#og_frontBtnMate,#og_frontBtnMateStkNo")
				.change(function(){
					var idValue = jQuery(this).attr("id");
					var thisVal = jQuery(this).val();
					dealWithPice(idValue,thisVal,result,modelCode);
				})
			})
			
		});
	
}

//--------------------------------------------
//シングル金額制御
//--------------------------------------------
function dealWithPice(idValue,thisVal,result,modelCode){
	if(idValue.indexOf("_id")!=-1){
		idValue = idValue.substr(0, idValue.length - 1);
		idValue = idValue.replace("_id","");
	}
	optionCode = selectIdList[idValue];
	subItemCode = subList[idValue];
	var code = subItemCode + modelCode + optionCode  + thisVal;
	if(idValue=="op_btnMate"||idValue=="op2_btnMate"||idValue=="og_backLiningMate"||idValue=="og_insideLiningMate"||idValue=="og_frontBtnMate"
		|| idValue=="bodyBackMate"||idValue=="cuffBackMate"||idValue=="btnMate"){
		var stkNo = idValue+"StkNo";
		var stkNoVal = jQuery("#"+stkNo).val();
		var codeDetail = subItemCode + modelCode + optionCode + thisVal + stkNoVal;
		for(var i = 0; i < result.length; i++) { 
			if(code == result[i].orderKeyCode&&codeDetail == result[i].orderDetailKeyCode){
				if(result[i].orderBranchPrice==0&&result[i].orderBranchDetailPrice==0){
					jQuery("#"+idValue+"_Msg").html("無料");
				}else{
					var format = formatMoney((Number(result[i].orderBranchPrice)+Number(result[i].orderBranchDetailPrice)),0,"￥");
					jQuery("#"+idValue+"_Msg").html(format);
				}
			} 
		}
		return false;
	}else if(idValue=="bodyBackMateStkNo"||idValue=="cuffBackMateStkNo"||idValue=="btnMateStkNo"||
			idValue == "op_btnMateStkNo"||idValue=="op2_btnMateStkNo"||idValue=="og_backLiningMateStkNo"||
			idValue=="og_insideLiningMateStkNo"||idValue=="og_frontBtnMateStkNo"){
		idValue = idValue.substr(0, idValue.length - 5);
		subItemCode = subList[idValue];
		optionCode = selectIdList[idValue];
		var val1 = jQuery("#"+idValue).val();
		var code = subItemCode + modelCode + optionCode  + val1;
		var codeDetail = subItemCode + modelCode + optionCode + val1 + thisVal;
		for(var i = 0; i < result.length; i++) { 
			if(code == result[i].orderKeyCode&&codeDetail == result[i].orderDetailKeyCode){
				if(result[i].orderBranchPrice==0&&result[i].orderBranchDetailPrice==0){
					jQuery("#"+idValue+"_Msg").html("無料");
				}else if (result[i].orderBranchPrice.length>=3||result[i].orderBranchDetailPrice.length>=3) {
					var format = formatMoney((Number(result[i].orderBranchPrice)+Number(result[i].orderBranchDetailPrice)),0,"￥");
					jQuery("#"+idValue+"_Msg").html(format);
				}
			}
		}
		
		return false;
	}else{
		for(var i = 0; i < result.length; i++) {
			if(code == result[i].orderKeyCode){
				if(result[i].orderBranchPrice==0){
					jQuery("#"+idValue+"_Msg").html("無料");
				}else if (result[i].orderBranchPrice.length>=3) {
					var format = formatMoney(result[i].orderBranchPrice,0,"￥");
					jQuery("#"+idValue+"_Msg").html(format);
				}else{
					jQuery("#"+idValue+"_Msg").html("￥"+result[i].orderBranchPrice);
				}
			} 
		}
		return false;
	}
	
}

//--------------------------------------------
//ダブル金額制御
//--------------------------------------------
function dealWithDoublePice(idValue,thisVal,result,modelCode){
	if(idValue.indexOf("_id")!=-1){
		idValue = idValue.substr(0, idValue.length - 1);
		idValue = idValue.replace("_id","");
	}
	optionCode = selectIdList[idValue];
	subItemCode = subList[idValue];
	var code = subItemCode + modelCode + optionCode  + thisVal;
	if(idValue=="bodyBackMate"||idValue=="cuffBackMate"||idValue=="btnMate"){
		var stkNo = idValue+"StkNo";
		var stkNoVal = jQuery("#"+stkNo).val();
		var codeDetail = subItemCode + modelCode + optionCode + thisVal + stkNoVal;
		for(var i = 0; i < result.length; i++) { 
			if(code == result[i].orderKeyCode&&codeDetail == result[i].orderDetailKeyCode){
				if(result[i].orderBranchDoublePrice==0&&result[i].orderBranchDetailDoublePrice==0){
					jQuery("#"+idValue+"_Msg").html("無料");
				}else{
					var format = formatMoney((Number(result[i].orderBranchDoublePrice)+Number(result[i].orderBranchDetailDoublePrice)),0,"￥");
					jQuery("#"+idValue+"_Msg").html(format);
				}
			} 
		}
		return false;
	}else if(idValue=="bodyBackMateStkNo"||idValue=="cuffBackMateStkNo"||idValue=="btnMateStkNo"){
		idValue = idValue.substr(0, idValue.length - 5);
		subItemCode = subList[idValue];
		optionCode = selectIdList[idValue];
		var val1 = jQuery("#"+idValue).val();
		var code = subItemCode + modelCode + optionCode  + val1;
		var codeDetail = subItemCode + modelCode + optionCode + val1 + thisVal;
		for(var i = 0; i < result.length; i++) { 
			if(code == result[i].orderKeyCode&&codeDetail == result[i].orderDetailKeyCode){
				if(result[i].orderBranchDoublePrice==0&&result[i].orderBranchDetailDoublePrice==0){
					jQuery("#"+idValue+"_Msg").html("無料");
				}else if (result[i].orderBranchPrice.length>=3||result[i].orderBranchDetailDoublePrice.length>=3) {
					var format = formatMoney((Number(result[i].orderBranchDoublePrice)+Number(result[i].orderBranchDetailDoublePrice)),0,"￥");
					jQuery("#"+idValue+"_Msg").html(format);
				}
			}
		}
		
		return false;
	}else{
		for(var i = 0; i < result.length; i++) { 
			if(code == result[i].orderKeyCode){
				if(result[i].orderBranchDoublePrice==0){
					jQuery("#"+idValue+"_Msg").html("無料");
				}else if (result[i].orderBranchPrice.length>=3) {
					var format = formatMoney(result[i].orderBranchDoublePrice,0,"￥");
					jQuery("#"+idValue+"_Msg").html(format);
				}else{
					jQuery("#"+idValue+"_Msg").html("￥"+result[i].orderBranchDoublePrice);
				}
			} 
		}
	}
	
}

//--------------------------------------------
//金額フォーマット
//--------------------------------------------
function formatMoney(number, places, symbol, thousand, decimal) {
    number = number || 0;
    places = !isNaN(places = Math.abs(places)) ? places : 2;
    symbol = symbol !== undefined ? symbol : "$";
    thousand = thousand || ",";
    decimal = decimal || ".";
    var negative = number < 0 ? "-" : "",
        i = parseInt(number = Math.abs(+number || 0).toFixed(places), 10) + "",
        j = (a = i.length) > 3 ? a % 3 : 0;
    return symbol + negative + (j ? i.substr(0, j) + thousand : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, (symbol+"1") + thousand) + (places ? decimal + Math.abs(number - i).toFixed(places).slice(2) : "");
}


//--------------------------------------------
//他店舗のとき　店舗を検索した
//--------------------------------------------
function initCustomer() {
	var allShop = jQuery("#shopName");
	jQuery('#destination').change(function(){
		var destination = jQuery('#destination').val();
		//他店舗コード　　05
		if (destination == "05") {
				 var obj = document.getElementById("shopName");
				 obj.options.length=0;
				 obj.add(new Option("",""));
			        jQuery.ajax({
			            url: contextPath + "/order/selectAllShop",
			            type: 'post',
			            async:false,
			            success: function(data){
			               jQuery.each(data, function (index, e) {
			                   obj.add(new Option(e.shopName,e.shopCode));
			               });
			               jQuery("#shopName").trigger("chosen:updated");
			               jQuery("#shopName").chosen({
			           	   disable_search_threshold: 10,
			           	   no_results_text: "この店舗が見つかりませんでした。!:",
			           	   width: "100%"
			           	   }); 
			            }
			        });
			jQuery('#shopNameDiv').show();
		} else {
			jQuery('#shopNameDiv').hide();
		}
	});
	jQuery('#destination').change();
}


</script>
