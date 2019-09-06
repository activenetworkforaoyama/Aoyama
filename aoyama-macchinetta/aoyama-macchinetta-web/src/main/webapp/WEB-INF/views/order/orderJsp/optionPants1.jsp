<form:form id="idInfoForm" action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm" method="post" modelAttribute="orderForm" class="form-horizontal">
<div id="op_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSモデル</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_pantsModel"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op_pantsModel" path="optionPantsStandardInfo.opPantsModel" class="form-control-sm form-control">
                                		<form:options items="${orderForm.optionPantsStandardInfo.opPantsModelMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_pantsModelMsg"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_pantsModelCheck" style="margin-top:8px"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                                <form:select id="op_tack" path="optionPantsStandardInfo.opTack" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opTackMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_tackMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_kneeBack"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                     <form:radiobuttons id="op_kneeBack_id" path="optionPantsStandardInfo.opKneeBack" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opKneeBackMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group" id="op_kneeBackMate_div">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_kneeBackMate_id" path="optionPantsStandardInfo.opKneeBackMate" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opKneeBackMateMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント仕様</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_frontSpec"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_frontSpec_id" path="optionPantsStandardInfo.opFrontSpec" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opFrontSpecMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_pancherina_id" path="optionPantsStandardInfo.opPancherina" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opPancherinaMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_pancherinaMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_adjuster_id" path="optionPantsStandardInfo.opAdjuster" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opAdjusterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_adjusterMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベルトループ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_beltLoop"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_beltLoop_id" path="optionPantsStandardInfo.opBeltLoop" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opBeltLoopMap}"/>
                                </div>
                                <div class="offset-md-1" id="op_beltLoopPlace">
                                    <div>
                                        <div class="form-check-inline form-check">
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op_beltLoopPlace">全選択</button>&nbsp;
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op_beltLoopPlace">全解除</button>
                                        </div>
                                    </div>
                                    <%-- <div class="form-check-inline form-check">
                                        <form:checkboxes id="op_beltLoopPlace_id" items="${orderForm.optionPantsStandardInfo.opBeltLoopPlaceMap }" path="optionPantsStandardInfo.opBeltLoopPlace" class="form-check-input"/>
                                    </div> --%>
                                    <c:forEach var="opBeltLoopPlaceMap" items="${orderForm.optionPantsStandardInfo.opBeltLoopPlaceMap }" varStatus="row">
                                		<div class="form-check-inline form-check" id="op_beltLoopPlace_id1${row.count}">
                                			<input type="checkbox" id="op_beltLoopPlace_id${row.count}" name="optionPantsStandardInfo.opBeltLoopPlace${row.count}" value="${opBeltLoopPlaceMap.key}" class="form-check-input">${opBeltLoopPlaceMap.value}
                                		</div>
                                	</c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_beltLoopMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_pinLoop_id" path="optionPantsStandardInfo.opPinLoop" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opPinLoopMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_pinLoopMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_sidePkt_id" path="optionPantsStandardInfo.opSidePkt" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opSidePktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_sidePktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_sinobiPkt_id" path="optionPantsStandardInfo.opSinobiPkt" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opSinobiPktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_sinobiPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コインポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_coinPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op_coinPkt" class="form-control-sm form-control" path="optionPantsStandardInfo.opCoinPkt">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opCoinPktMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_coinPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                   	<form:radiobuttons id="op_flapCoinPkt_id" path="optionPantsStandardInfo.opFlapCoinPkt" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opFlapCoinPktMap }"/>　
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_flapCoinPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_pisPktUf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_pisPktUf_id" path="optionPantsStandardInfo.opPisPktUf" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opPisPktUfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_pisPktUfMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_pisPktDf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_pisPktDf_id" path="optionPantsStandardInfo.opPisPktDf" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opPisPktDfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_pisPktDfMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">Vカット</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_vCut_id" path="optionPantsStandardInfo.opVCut" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opVCutMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_vCutMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_hemUp"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op_hemUp" path="optionPantsStandardInfo.opHemUp" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opHemUpMap }"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group"  id="op_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                                <form:select id="op_doubleWide" path="optionPantsStandardInfo.opDoubleWide" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opDoubleWideMap }"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_stitch"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_stitch_id" path="optionPantsStandardInfo.opStitch" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opStitchMap }"/>
                                </div>
                            </div>
                        </div>
                        <div id="op_stitch_yes_area">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_stitchModify_id" path="optionPantsStandardInfo.opStitchModify" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opStitchModifyMap }"/>
                                </div>
                                <div id="op_stitchModify_yes_area">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op_stitchModifyPlace">全選択</button>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op_stitchModifyPlace">全解除</button>
                                </div>
                                </div>
                                <div class="offset-md-1" id="op_stitchModifyPlace">
                                <%-- <div class="form-check-inline form-check">
                                    <form:checkboxes id="op_stitchModifyPlace_id" items="${orderForm.optionPantsStandardInfo.opStitchModifyPlaceMap }" path="optionPantsStandardInfo.opStitchModifyPlace" class="form-check-input"/>
                                </div> --%>
                                <c:forEach var="opStitchModifyPlaceMap" items="${orderForm.optionPantsStandardInfo.opStitchModifyPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="op_stitchModifyPlace_id${row.count}" name="optionPantsStandardInfo.opStitchModifyPlace${row.count}" value="${opStitchModifyPlaceMap.key}" class="form-check-input">${opStitchModifyPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_dStitch_id" path="optionPantsStandardInfo.opDStitch" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opDStitchMap }"/>
                                </div>
                                <div id="op_dStitch_yes_area">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op_dStitchPlace">全選択</button>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op_dStitchPlace">全解除</button>
                                </div>
                                </div>
                                <div class="offset-md-1" id="op_dStitchPlace">
                                <%-- <div class="form-check-inline form-check">
                                    <form:checkboxes id="op_dStitchPlace_id" items="${orderForm.optionPantsStandardInfo.opDStitchPlaceMap }" path="optionPantsStandardInfo.opDStitchPlace" class="form-check-input"/>
                                </div> --%>
                                <c:forEach var="opDStitchPlaceMap" items="${orderForm.optionPantsStandardInfo.opDStitchPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="op_dStitchPlace_id${row.count}" name="optionPantsStandardInfo.opDStitchPlace${row.count}" value="${opDStitchPlaceMap.key}" class="form-check-input">${opDStitchPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_amfColor_id" path="optionPantsStandardInfo.opAmfColor" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opAmfColorMap }"/>
                                </div>
                                <div id="op_amfColor_div" style="display:none;">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="op_amfColorPlaceAll" path="optionPantsStandardInfo.opAmfColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPantsStandardInfo.opAmfColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op_amfColorPlace">全選択</button>
                                </div>
                                </div>
                                <c:forEach var="opAmfColorPlaceMap" items="${orderForm.optionPantsStandardInfo.opAmfColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="op_amfColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="op_amfColorPlace_${row.count}" name="optionPantsStandardInfo.opAmfColorPlace${row.count}" value="${opAmfColorPlaceMap.key }" class="form-check-input">${opAmfColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="op_amfColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="opAmfColorsMap" items="${orderForm.optionPantsStandardInfo.opAmfColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op_amfColor" class="form-check-label ">
                                			    <input type="radio" id="op_amfColor_${opAmfColorsMap.key}" name="optionPantsStandardInfo.opAmfColor${row.count}" value="${opAmfColorsMap.key}" class="form-check-input">${opAmfColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_bhColor_id" path="optionPantsStandardInfo.opBhColor" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opBhColorMap }"/>
                                </div>
                                <div id="op_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="op_bhColorPlaceAll" path="optionPantsStandardInfo.opBhColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPantsStandardInfo.opBhColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op_bhColorPlace">全選択</button>
                                </div>
                                </div>
                                <c:forEach var="opBhColorPlaceMap" items="${orderForm.optionPantsStandardInfo.opBhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="op_bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="op_bhColorPlace_${row.count}" name="optionPantsStandardInfo.opBhColorPlace${row.count}" value="${opBhColorPlaceMap.key }" class="form-check-input">${opBhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="op_bhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="opBhColorsMap" items="${orderForm.optionPantsStandardInfo.opBhColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op_bhColor" class="form-check-label ">
                                			    <input type="radio" id="op_bhColor_${opBhColorsMap.key}" name="optionPantsStandardInfo.opBhColor${row.count}" value="${opBhColorsMap.key}" class="form-check-input">${opBhColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div> 
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_byColor_id" path="optionPantsStandardInfo.opByColor" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opByColorMap }"/>
                                </div>
                                <div id="op_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="op_byColorPlaceAll" path="optionPantsStandardInfo.opByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPantsStandardInfo.opByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op_byColorPlace">全選択</button>
                                </div>
                                </div>
                                <c:forEach var="opByColorPlaceMap" items="${orderForm.optionPantsStandardInfo.opByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="op_byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="op_byColorPlace_${row.count}" name="optionPantsStandardInfo.opByColorPlace${row.count}" value="${opByColorPlaceMap.key }" class="form-check-input">${opByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="op_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="opByColorsMap" items="${orderForm.optionPantsStandardInfo.opByColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op_byColorPlace" class="form-check-label ">
                                			    <input type="radio" id="op_byColor_${opByColorsMap.key}" name="optionPantsStandardInfo.opByColor${row.count}" value="${opByColorsMap.key}" class="form-check-input">${opByColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_button"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op_btnMate" class="form-control-sm form-control" path="optionPantsStandardInfo.opButton">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opButtonMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionPantsStandardInfo.opBtnMateStkNo" id="op_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_suspenderBtn_id" path="optionPantsStandardInfo.opSuspenderBtn" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opSuspenderBtnMap }"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_thick_id" path="optionPantsStandardInfo.opThick" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opThickMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="op_thick_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_eight_id" path="optionPantsStandardInfo.opEight" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opEightMap }"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_shapeMemory_id" path="optionPantsStandardInfo.opShapeMemory" class="form-check-input" items="${orderForm.optionPantsStandardInfo.opShapeMemoryMap }"/>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            </div>
            
            <!-- タキシード PANTS -->
            <div id="tu_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSモデル</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_pantsModel"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tp_pantsModel" path="optionPantsTuxedoInfo.tpPantsModel" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsTuxedoInfo.tpPantsModelMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_pantsModelMsg"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_pantsModelCheck" style="margin-top:8px"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tp_tack" path="optionPantsTuxedoInfo.tpTack" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsTuxedoInfo.tpTackMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_tackMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_kneeBack"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                     <form:radiobuttons id="tp_kneeBack_id" path="optionPantsTuxedoInfo.tpKneeBack" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpKneeBackMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group" id="tp_kneeBackMate_div">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_kneeBackMate_id" path="optionPantsTuxedoInfo.tpKneeBackMate" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpKneeBackMateMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント仕様</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_frontSpec"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_frontSpec_id" path="optionPantsTuxedoInfo.tpFrontSpec" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpFrontSpecMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_pancherina_id" path="optionPantsTuxedoInfo.tpPancherina" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpPancherinaMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_pancherinaMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_adjuster_id" path="optionPantsTuxedoInfo.tpAdjuster" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpAdjusterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_adjusterMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベルトループ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_beltLoop"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_beltLoop_id" path="optionPantsTuxedoInfo.tpBeltLoop" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpBeltLoopMap}"/>                    
                                </div>
                                <div class="offset-md-1" id="tp_beltLoopPlace">
                                    <div>
                                        <div class="form-check-inline form-check">
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tp_beltLoopPlace">全選択</button>&nbsp;
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tp_beltLoopPlace">全解除</button>
                                        </div>
                                    </div>
                                   <%--  <div class="form-check-inline form-check">
                                    	<form:checkboxes id="tp_beltLoopPlace_id" items="${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlaceMap }" path="optionPantsTuxedoInfo.tpBeltLoopPlace" class="form-check-input"/>
                                    </div> --%>
                                    <c:forEach var="tpBeltLoopPlaceMap" items="${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="tp_beltLoopPlace_id${row.count}" name="optionPantsTuxedoInfo.tpBeltLoopPlace${row.count}" value="${tpBeltLoopPlaceMap.key}" class="form-check-input">${tpBeltLoopPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_beltLoopMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_pinLoop_id" path="optionPantsTuxedoInfo.tpPinLoop" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpPinLoopMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_pinLoopMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_sidePkt_id" path="optionPantsTuxedoInfo.tpSidePkt" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpSidePktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_sidePktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_sinobiPkt_id" path="optionPantsTuxedoInfo.tpSinobiPkt" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpSinobiPktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_sinobiPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コインポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_coinPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tp_coinPkt" class="form-control-sm form-control" path="optionPantsTuxedoInfo.tpCoinPkt">
                                	<form:options items="${orderForm.optionPantsTuxedoInfo.tpCoinPktMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_coinPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                   	<form:radiobuttons id="tp_flapCoinPkt_id" path="optionPantsTuxedoInfo.tpFlapCoinPkt" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpFlapCoinPktMap }"/>　
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_flapCoinPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_pisPktUf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_pisPktUf_id" path="optionPantsTuxedoInfo.tpPisPktUf" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpPisPktUfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_pisPktUfMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_pisPktDf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_pisPktDf_id" path="optionPantsTuxedoInfo.tpPisPktDf" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpPisPktDfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_pisPktDfMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">Vカット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_vCut_id" path="optionPantsTuxedoInfo.tpVCut" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpVCutMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_vCutMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_hemUp"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tp_hemUp" path="optionPantsTuxedoInfo.tpHemUp" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsTuxedoInfo.tpHemUpMap }"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group"  id="tp_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tp_doubleWide" path="optionPantsTuxedoInfo.tpDoubleWide" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsTuxedoInfo.tpDoubleWideMap }"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_stitch_id" path="optionPantsTuxedoInfo.tpStitch" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpStitchMap }"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_bhColor_id" path="optionPantsTuxedoInfo.tpBhColor" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpBhColorMap }"/>
                                </div>
                                <div id="tp_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                	<form:select id="tp_bhColorPlaceAll" path="optionPantsTuxedoInfo.tpBhColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPantsTuxedoInfo.tpBhColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tp_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tp_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="tpBhColorPlaceMap" items="${orderForm.optionPantsTuxedoInfo.tpBhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="tp_bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="tp_bhColorPlace_${row.count}" name="optionPantsTuxedoInfo.tpBhColorPlace" value="${tpBhColorPlaceMap.key }" class="form-check-input">${tpBhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="tp_bhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="tpBhColorsMap" items="${orderForm.optionPantsTuxedoInfo.tpBhColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="tp_bhColor" class="form-check-label ">
                                			    <input type="radio" id="tp_bhColor_${tpBhColorsMap.key}" name="optionPantsTuxedoInfo.tpBhColor${row.count}" value="${tpBhColorsMap.key}" class="form-check-input">${tpBhColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="tp_byColor_no" class="form-check-label ">
                                        <form:radiobuttons id="tp_byColor_id" path="optionPantsTuxedoInfo.tpByColor" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpByColorMap }"/>
                                	</label>　
                                </div>
                                <div id="tp_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                	<form:select id="tp_byColorPlaceAll" path="optionPantsTuxedoInfo.tpByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPantsTuxedoInfo.tpByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tp_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tp_byColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="tpByColorPlaceMap" items="${orderForm.optionPantsTuxedoInfo.tpByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="tp_byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="tp_byColorPlace_${row.count}" name="optionPantsTuxedoInfo.tpByColorPlace" value="${tpByColorPlaceMap.key }" class="form-check-input">${tpByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="tp_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="tpByColorsMap" items="${orderForm.optionPantsTuxedoInfo.tpByColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="tp_byColorPlace" class="form-check-label ">
                                			    <input type="radio" id="tp_byColor_${tpByColorsMap.key}" name="optionPantsTuxedoInfo.tpByColor${row.count}" value="${tpByColorsMap.key}" class="form-check-input">${tpByColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_button"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tp_btnMate" class="form-control-sm form-control" path="optionPantsTuxedoInfo.tpButton">
                                	<form:options items="${orderForm.optionPantsTuxedoInfo.tpButtonMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionPantsTuxedoInfo.tpBtnMateStkNo" id="tp_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_suspenderBtn_id" path="optionPantsTuxedoInfo.tpSuspenderBtn" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpSuspenderBtnMap }"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
                            <div class="col-12 col-md-9">
                             	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_thick_id" path="optionPantsTuxedoInfo.tpThick" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpThickMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<%-- <output id="tp_thick_Msg"></output> --%>
                            </div>
                        </div> 
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_eight_id" path="optionPantsTuxedoInfo.tpEight" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpEightMap }"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_shapeMemory_id" path="optionPantsTuxedoInfo.tpShapeMemory" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpShapeMemoryMap }"/>
                                </div>
                            </div>
                        </div> 
                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">側章</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_sideStripe_id" path="optionPantsTuxedoInfo.tpSideStripe" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpSideStripeMap }"/>
                                </div>
                            </div>
                        </div>
                        <div id="tp_sideStripe_yes_area">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">側章幅</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_sideStripeWidth_id" path="optionPantsTuxedoInfo.tpSideStripeWidth" class="form-check-input" items="${orderForm.optionPantsTuxedoInfo.tpSideStripeWidthMap }"/>
                                </div>
                            </div>
                        </div>
                        </div> 
                    </div>
                </div>
            </div>
            </div>
            
            <!-- ウォッシャブル PANTS -->
            <div id="wa_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSモデル</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_pantsModel"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp_pantsModel" path="optionPantsWashableInfo.wpPantsModel" class="form-control-sm form-control">
									<form:options items="${orderForm.optionPantsWashableInfo.wpPantsModelMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_pantsModelMsg"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_pantsModelCheck" style="margin-top:8px"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                            	<form:select id="wp_tack" path="optionPantsWashableInfo.wpTack" class="form-control-sm form-control">
									<form:options items="${orderForm.optionPantsWashableInfo.wpTackMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_tackMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_kneeBack"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_kneeBack_id" path="optionPantsWashableInfo.wpKneeBack" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpKneeBackMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group" id="wp_kneeBackMate_div">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_kneeBackMate_id" path="optionPantsWashableInfo.wpKneeBackMate" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpKneeBackMateMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント仕様</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_frontSpec"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_frontSpec_id" path="optionPantsWashableInfo.wpFrontSpec" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpFrontSpecMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_pancherina_id" path="optionPantsWashableInfo.wpPancherina" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpPancherinaMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_pancherinaMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_adjuster_id" path="optionPantsWashableInfo.wpAdjuster" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpAdjusterMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_adjusterMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベルトループ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_beltLoop"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_beltLoop_id" path="optionPantsWashableInfo.wpBeltLoop" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpBeltLoopMap}"/>
								</div>
                                <div class="offset-md-1" id="wp_beltLoopPlace">
                                    <div>
                                        <div class="form-check-inline form-check">
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp_beltLoopPlace">全選択</button>&nbsp;
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp_beltLoopPlace">全解除</button>
                                        </div>
                                    </div>
                                   <%--  <div class="form-check-inline form-check">
										<form:checkboxes id="wp_beltLoopPlace_id" path="optionPantsWashableInfo.wpBeltLoopPlace" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpBeltLoopPlaceMap}"/>
									</div> --%>
									 <c:forEach var="wpBeltLoopPlaceMap" items="${orderForm.optionPantsWashableInfo.wpBeltLoopPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="wp_beltLoopPlace_id${row.count}" name="optionPantsWashableInfo.wpBeltLoopPlace${row.count}" value="${wpBeltLoopPlaceMap.key}" class="form-check-input">${wpBeltLoopPlaceMap.value}
                                	</div>
                                </c:forEach>
									
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_beltLoopMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_pinLoop_id" path="optionPantsWashableInfo.wpPinLoop" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpPinLoopMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_pinLoopMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_sidePkt_id" path="optionPantsWashableInfo.wpSidePkt" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpSidePktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_sidePktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_sinobiPkt_id" path="optionPantsWashableInfo.wpSinobiPkt" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpSinobiPktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_sinobiPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コインポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_coinPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp_coinPkt" path="optionPantsWashableInfo.wpCoinPkt" class="form-control-sm form-control">
									<form:options items="${orderForm.optionPantsWashableInfo.wpCoinPktMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_coinPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_flapCoinPkt_id" path="optionPantsWashableInfo.wpFlapCoinPkt" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpFlapCoinPktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_flapCoinPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_pisPktUf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_pisPktUf_id" path="optionPantsWashableInfo.wpPisPktUf" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpPisPktUfMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_pisPktUfMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_pisPktDf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_pisPktDf_id" path="optionPantsWashableInfo.wpPisPktDf" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpPisPktDfMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_pisPktDfMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">Vカット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_vCut_id" path="optionPantsWashableInfo.wpVCut" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpVCutMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_vCutMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_hemUp"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp_hemUp" path="optionPantsWashableInfo.wpHemUp" class="form-control-sm form-control">
									<form:options items="${orderForm.optionPantsWashableInfo.wpHemUpMap}"/>
								</form:select>
                            </div>
                        </div>
                        <div class="row form-group"  id="wp_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                            	<form:select id="wp_doubleWide" path="optionPantsWashableInfo.wpDoubleWide" class="form-control-sm form-control">
									<form:options items="${orderForm.optionPantsWashableInfo.wpDoubleWideMap}"/>
								</form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_stitch_id" path="optionPantsWashableInfo.wpStitch" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpStitchMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_stitchModify_id" path="optionPantsWashableInfo.wpStitchModify" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpStitchModifyMap}"/>
								</div>
                                <div id="wp_stitchModify_yes_area">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp_stitchModifyPlace">全選択</button>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp_stitchModifyPlace">全解除</button>
                                </div>
                                </div>
                                <div class="offset-md-1" id="wp_stitchModifyPlace">
                                <%-- <div class="form-check-inline form-check">
									<form:checkboxes id="wp_stitchModifyPlace_id" path="optionPantsWashableInfo.wpStitchModifyPlace" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpStitchModifyPlaceMap}"/>
								</div> --%>
								<c:forEach var="wpStitchModifyPlaceMap" items="${orderForm.optionPantsWashableInfo.wpStitchModifyPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="wp_stitchModifyPlace_id${row.count}" name="optionPantsWashableInfo.wpStitchModifyPlace${row.count}" value="${wpStitchModifyPlaceMap.key}" class="form-check-input">${wpStitchModifyPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_dStitch_id" path="optionPantsWashableInfo.wpDStitch" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpDStitchMap}"/>
								</div>
                                <div id="wp_dStitch_yes_area">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp_dStitchPlace">全選択</button>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp_dStitchPlace">全解除</button>
                                </div>
                                </div>
                                <div class="offset-md-1" id="wp_dStitchPlace">
                                <%-- <div class="form-check-inline form-check">
									<form:checkboxes id="wp_dStitchPlace_id" path="optionPantsWashableInfo.wpDStitchPlace" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpDStitchPlaceMap}"/>
								</div> --%>
								<c:forEach var="wpDStitchPlaceMap" items="${orderForm.optionPantsWashableInfo.wpDStitchPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="wp_dStitchPlace_id${row.count}" name="optionPantsWashableInfo.wpDStitchPlace${row.count}" value="${wpDStitchPlaceMap.key}" class="form-check-input">${wpDStitchPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_amfColor_id" path="optionPantsWashableInfo.wpAmfColor" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpAmfColorMap}"/>
								</div>
                                <div id="wp_amfColor_div" style="display:none;">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
	                                <form:select id="wp_amfColorPlaceAll" path="optionPantsWashableInfo.wpAmfColorPlaceAll" class="form-control-sm form-control">
										<form:options items="${orderForm.optionPantsWashableInfo.wpAmfColorPlaceAllMap}"/>
									</form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp_amfColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp_amfColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wpAmfColorPlaceMap" items="${orderForm.optionPantsWashableInfo.wpAmfColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wp_amfColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wp_amfColorPlace_${row.count}" name="optionPantsWashableInfo.wpAmfColorPlace" value="${wpAmfColorPlaceMap.key }" class="form-check-input">${wpAmfColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="wp_amfColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wpAmfColorsMap" items="${orderForm.optionPantsWashableInfo.wpAmfColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wp_amfColor" class="form-check-label ">
                                			    <input type="radio" id="wp_amfColor_${wpAmfColorsMap.key}" name="optionPantsWashableInfo.wpAmfColor${row.count}" value="${wpAmfColorsMap.key}" class="form-check-input">${wpAmfColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_bhColor_id" path="optionPantsWashableInfo.wpBhColor" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpBhColorMap}"/>
								</div>
                                <div id="wp_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="wp_bhColorPlaceAll" path="optionPantsWashableInfo.wpBhColorPlaceAll" class="form-control-sm form-control">
										<form:options items="${orderForm.optionPantsWashableInfo.wpBhColorPlaceAllMap}"/>
									</form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wpBhColorPlaceMap" items="${orderForm.optionPantsWashableInfo.wpBhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wp_bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wp_bhColorPlace_${row.count}" name="optionPantsWashableInfo.wpBhColorPlace" value="${wpBhColorPlaceMap.key }" class="form-check-input">${wpBhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="wp_bhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wpBhColorsMap" items="${orderForm.optionPantsWashableInfo.wpBhColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wp_bhColor" class="form-check-label ">
                                			    <input type="radio" id="wp_bhColor_${wpBhColorsMap.key}" name="optionPantsWashableInfo.wpBhColor${row.count}" value="${wpBhColorsMap.key}" class="form-check-input">${wpBhColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="wp_byColor_no" class="form-check-label ">
                                        <form:radiobuttons id="wp_byColor_id" path="optionPantsWashableInfo.wpByColor" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpByColorMap }"/>
                                	</label>　
                                </div>
                                <div id="wp_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                	<form:select id="wp_byColorPlaceAll" path="optionPantsWashableInfo.wpByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPantsWashableInfo.wpByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp_byColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wpByColorPlaceMap" items="${orderForm.optionPantsWashableInfo.wpByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wp_byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wp_byColorPlace_${row.count}" name="optionPantsWashableInfo.wpByColorPlace" value="${wpByColorPlaceMap.key }" class="form-check-input">${wpByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="wp_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wpByColorsMap" items="${orderForm.optionPantsWashableInfo.wpByColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wp_byColorPlace" class="form-check-label ">
                                			    <input type="radio" id="wp_byColor_${wpByColorsMap.key}" name="optionPantsWashableInfo.wpByColor${row.count}" value="${wpByColorsMap.key}" class="form-check-input">${wpByColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_button"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp_btnMate" path="optionPantsWashableInfo.wpButton" class="form-control-sm form-control">
									<form:options items="${orderForm.optionPantsWashableInfo.wpButtonMap}"/>
								</form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionPantsWashableInfo.wpBtnMateStkNo" id="wp_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="wp_sameJacketBtn">JKと同じ</button>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_suspenderBtn_id" path="optionPantsWashableInfo.wpSuspenderBtn" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpSuspenderBtnMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_eight_id" path="optionPantsWashableInfo.wpEight" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpEightMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_thick_id" path="optionPantsWashableInfo.wpThick" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpThickMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_shapeMemory_id" path="optionPantsWashableInfo.wpShapeMemory" class="form-check-input" items="${orderForm.optionPantsWashableInfo.wpShapeMemoryMap}"/>
								</div>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
            </div>
            
            <input type="hidden" id="pantsFlag" name="pantsFlag" value="0"/>
            <input type="hidden" id="pantsItemFlag" name="pantsItemFlag" value="0"/>
            <input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="${orderForm.jacketItemFlag }"/>
			<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="${orderForm.giletItemFlag }"/>
			<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="${orderForm.shirtItemFlag }"/>
			<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="${orderForm.coatItemFlag }"/>
			<input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="${orderForm.pants2ItemFlag }"/>
            <input type="hidden" id="pantsAdFlag" name="pantsAdFlag" value="0" />
</form:form>
<!-- 標準 PANTS PANTSモデル-->
<div class="modal fade" id="infotext_op_pantsModel" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">PANTSモデル</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                PANTSモデル選択時に連動して変更される可能性がある項目<br />
                ・タック<br />
                ・パンチェリーナ<br />
                ・アジャスター仕様<br />
                ・ベルトループ<br />
                ・ピンループ<br />
                ・脇ポケット<br />
                ・忍びポケット<br />
                ・コインポケット<br />
                ・上前ピスポケット<br />
                ・下前ピスポケット<br />
                ・Vカット<br />
                ・ステッチ箇所変更<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 膝裏-->
<div class="modal fade" id="infotext_op_kneeBack" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">膝裏</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                膝裏選択時に連動して変更される可能性がある項目<br />
                ・膝裏素材
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS フロント仕様-->
<div class="modal fade" id="infotext_op_frontSpec" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フロント仕様</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フロント仕様選択時に連動して変更される可能性がある項目<br />
                ・パンチェリーナ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS ベルトループ-->
<div class="modal fade" id="infotext_op_beltLoop" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ベルトループ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ベルトループ選択時に連動して変更される可能性がある項目<br />
                ・ピンループ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS コインポケット-->
<div class="modal fade" id="infotext_op_coinPkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">コインポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                コインポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 上前ピスポケット-->
<div class="modal fade" id="infotext_op_pisPktUf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">上前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                上前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 下前ピスポケット-->
<div class="modal fade" id="infotext_op_pisPktDf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">下前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                下前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 裾上げ-->
<div class="modal fade" id="infotext_op_hemUp" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">裾上げ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                裾上げ選択時に連動して変更される可能性がある項目<br />
                ・ダブル幅
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS AMFステッチ-->
<div class="modal fade" id="infotext_op_stitch" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ステッチ種類</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ステッチ種類選択時に連動して変更される可能性がある項目<br />
                ・ステッチ箇所変更<br />
                ・ダブルステッチ<br />
                ・AMF色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 釦素材-->
<div class="modal fade" id="infotext_op_button" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">釦素材</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                釦素材選択時に連動して変更される可能性がある項目<br />
                ・釦品番
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS PANTSモデル-->
<div class="modal fade" id="infotext_op2_pantsModel" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">PANTSモデル</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                PANTSモデル選択時に連動して変更される可能性がある項目<br />
                ・タック<br />
                ・パンチェリーナ<br />
                ・アジャスター仕様<br />
                ・ベルトループ<br />
                ・ピンループ<br />
                ・脇ポケット<br />
                ・忍びポケット<br />
                ・コインポケット<br />
                ・上前ピスポケット<br />
                ・下前ピスポケット<br />
                ・Vカット<br />
                ・ステッチ箇所変更<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 膝裏-->
<div class="modal fade" id="infotext_op2_kneeBack" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">膝裏</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                膝裏選択時に連動して変更される可能性がある項目<br />
                ・膝裏素材
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS フロント仕様-->
<div class="modal fade" id="infotext_op2_frontSpec" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フロント仕様</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フロント仕様選択時に連動して変更される可能性がある項目<br />
                ・パンチェリーナ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS ベルトループ-->
<div class="modal fade" id="infotext_op2_beltLoop" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ベルトループ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ベルトループ選択時に連動して変更される可能性がある項目<br />
                ・ピンループ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS コインポケット-->
<div class="modal fade" id="infotext_op2_coinPkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">コインポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                コインポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 上前ピスポケット-->
<div class="modal fade" id="infotext_op2_pisPktUf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">上前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                上前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 下前ピスポケット-->
<div class="modal fade" id="infotext_op2_pisPktDf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">下前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                下前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 裾上げ-->
<div class="modal fade" id="infotext_op2_hemUp" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">裾上げ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                裾上げ選択時に連動して変更される可能性がある項目<br />
                ・ダブル幅
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS AMFステッチ-->
<div class="modal fade" id="infotext_op2_stitch" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ステッチ種類</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ステッチ種類選択時に連動して変更される可能性がある項目<br />
                ・ステッチ箇所変更<br />
                ・ダブルステッチ<br />
                ・AMF色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 釦素材-->
<div class="modal fade" id="infotext_op2_button" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">釦素材</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                釦素材選択時に連動して変更される可能性がある項目<br />
                ・釦品番
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS PANTSモデル-->
<div class="modal fade" id="infotext_op3_pantsModel" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">PANTSモデル</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                PANTSモデル選択時に連動して変更される可能性がある項目<br />
                ・タック<br />
                ・パンチェリーナ<br />
                ・アジャスター仕様<br />
                ・ベルトループ<br />
                ・ピンループ<br />
                ・脇ポケット<br />
                ・忍びポケット<br />
                ・コインポケット<br />
                ・上前ピスポケット<br />
                ・下前ピスポケット<br />
                ・Vカット<br />
                ・ステッチ箇所変更<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 膝裏-->
<div class="modal fade" id="infotext_op3_kneeBack" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">膝裏</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                膝裏選択時に連動して変更される可能性がある項目<br />
                ・膝裏素材
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS フロント仕様-->
<div class="modal fade" id="infotext_op3_frontSpec" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フロント仕様</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フロント仕様選択時に連動して変更される可能性がある項目<br />
                ・パンチェリーナ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS ベルトループ-->
<div class="modal fade" id="infotext_op3_beltLoop" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ベルトループ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ベルトループ選択時に連動して変更される可能性がある項目<br />
                ・ピンループ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS コインポケット-->
<div class="modal fade" id="infotext_op3_coinPkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">コインポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                コインポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 上前ピスポケット-->
<div class="modal fade" id="infotext_op3_pisPktUf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">上前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                上前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 下前ピスポケット-->
<div class="modal fade" id="infotext_op3_pisPktDf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">下前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                下前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 裾上げ-->
<div class="modal fade" id="infotext_op3_hemUp" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">裾上げ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                裾上げ選択時に連動して変更される可能性がある項目<br />
                ・ダブル幅
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS AMFステッチ-->
<div class="modal fade" id="infotext_op3_stitch" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ステッチ種類</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ステッチ種類選択時に連動して変更される可能性がある項目<br />
                ・ステッチ箇所変更<br />
                ・ダブルステッチ<br />
                ・AMF色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 PANTS 釦素材-->
<div class="modal fade" id="infotext_op3_button" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">釦素材</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                釦素材選択時に連動して変更される可能性がある項目<br />
                ・釦品番
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS PANTSモデル-->
<div class="modal fade" id="infotext_tp_pantsModel" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">PANTSモデル</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                PANTSモデル選択時に連動して変更される可能性がある項目<br />
                ・タック<br />
                ・パンチェリーナ<br />
                ・アジャスター仕様<br />
                ・ベルトループ<br />
                ・ピンループ<br />
                ・脇ポケット<br />
                ・忍びポケット<br />
                ・コインポケット<br />
                ・上前ピスポケット<br />
                ・下前ピスポケット<br />
                ・Vカット<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 膝裏-->
<div class="modal fade" id="infotext_tp_kneeBack" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">膝裏</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                膝裏選択時に連動して変更される可能性がある項目<br />
                ・膝裏素材
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS フロント仕様-->
<div class="modal fade" id="infotext_tp_frontSpec" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フロント仕様</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フロント仕様選択時に連動して変更される可能性がある項目<br />
                ・パンチェリーナ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS ベルトループ-->
<div class="modal fade" id="infotext_tp_beltLoop" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ベルトループ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ベルトループ選択時に連動して変更される可能性がある項目<br />
                ・ピンループ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS コインポケット-->
<div class="modal fade" id="infotext_tp_coinPkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">コインポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                コインポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 上前ピスポケット-->
<div class="modal fade" id="infotext_tp_pisPktUf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">上前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                上前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 下前ピスポケット-->
<div class="modal fade" id="infotext_tp_pisPktDf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">下前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                下前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 裾上げ-->
<div class="modal fade" id="infotext_tp_hemUp" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">裾上げ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                裾上げ選択時に連動して変更される可能性がある項目<br />
                ・ダブル幅
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 釦素材-->
<div class="modal fade" id="infotext_tp_button" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">釦素材</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                釦素材選択時に連動して変更される可能性がある項目<br />
                ・釦品番
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS PANTSモデル-->
<div class="modal fade" id="infotext_tp2_pantsModel" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">PANTSモデル</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                PANTSモデル選択時に連動して変更される可能性がある項目<br />
                ・タック<br />
                ・パンチェリーナ<br />
                ・アジャスター仕様<br />
                ・ベルトループ<br />
                ・ピンループ<br />
                ・脇ポケット<br />
                ・忍びポケット<br />
                ・コインポケット<br />
                ・上前ピスポケット<br />
                ・下前ピスポケット<br />
                ・Vカット<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 膝裏-->
<div class="modal fade" id="infotext_tp2_kneeBack" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">膝裏</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                膝裏選択時に連動して変更される可能性がある項目<br />
                ・膝裏素材
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS フロント仕様-->
<div class="modal fade" id="infotext_tp2_frontSpec" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フロント仕様</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フロント仕様選択時に連動して変更される可能性がある項目<br />
                ・パンチェリーナ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS ベルトループ-->
<div class="modal fade" id="infotext_tp2_beltLoop" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ベルトループ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ベルトループ選択時に連動して変更される可能性がある項目<br />
                ・ピンループ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS コインポケット-->
<div class="modal fade" id="infotext_tp2_coinPkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">コインポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                コインポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 上前ピスポケット-->
<div class="modal fade" id="infotext_tp2_pisPktUf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">上前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                上前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 下前ピスポケット-->
<div class="modal fade" id="infotext_tp2_pisPktDf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">下前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                下前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 裾上げ-->
<div class="modal fade" id="infotext_tp2_hemUp" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">裾上げ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                裾上げ選択時に連動して変更される可能性がある項目<br />
                ・ダブル幅
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 釦素材-->
<div class="modal fade" id="infotext_tp2_button" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">釦素材</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                釦素材選択時に連動して変更される可能性がある項目<br />
                ・釦品番
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS PANTSモデル-->
<div class="modal fade" id="infotext_tp3_pantsModel" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">PANTSモデル</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                PANTSモデル選択時に連動して変更される可能性がある項目<br />
                ・タック<br />
                ・パンチェリーナ<br />
                ・アジャスター仕様<br />
                ・ベルトループ<br />
                ・ピンループ<br />
                ・脇ポケット<br />
                ・忍びポケット<br />
                ・コインポケット<br />
                ・上前ピスポケット<br />
                ・下前ピスポケット<br />
                ・Vカット<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 膝裏-->
<div class="modal fade" id="infotext_tp3_kneeBack" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">膝裏</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                膝裏選択時に連動して変更される可能性がある項目<br />
                ・膝裏素材
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS フロント仕様-->
<div class="modal fade" id="infotext_tp3_frontSpec" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フロント仕様</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フロント仕様選択時に連動して変更される可能性がある項目<br />
                ・パンチェリーナ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS ベルトループ-->
<div class="modal fade" id="infotext_tp3_beltLoop" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ベルトループ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ベルトループ選択時に連動して変更される可能性がある項目<br />
                ・ピンループ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS コインポケット-->
<div class="modal fade" id="infotext_tp3_coinPkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">コインポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                コインポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 上前ピスポケット-->
<div class="modal fade" id="infotext_tp3_pisPktUf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">上前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                上前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 下前ピスポケット-->
<div class="modal fade" id="infotext_tp3_pisPktDf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">下前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                下前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 裾上げ-->
<div class="modal fade" id="infotext_tp3_hemUp" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">裾上げ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                裾上げ選択時に連動して変更される可能性がある項目<br />
                ・ダブル幅
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード PANTS 釦素材-->
<div class="modal fade" id="infotext_tp3_button" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">釦素材</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                釦素材選択時に連動して変更される可能性がある項目<br />
                ・釦品番
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS PANTSモデル-->
<div class="modal fade" id="infotext_wp_pantsModel" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">PANTSモデル</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                PANTSモデル選択時に連動して変更される可能性がある項目<br />
                ・タック<br />
                ・パンチェリーナ<br />
                ・アジャスター仕様<br />
                ・ベルトループ<br />
                ・ピンループ<br />
                ・脇ポケット<br />
                ・忍びポケット<br />
                ・コインポケット<br />
                ・上前ピスポケット<br />
                ・下前ピスポケット<br />
                ・Vカット<br />
                ・ステッチ箇所変更<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 膝裏-->
<div class="modal fade" id="infotext_wp_kneeBack" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">膝裏</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                膝裏選択時に連動して変更される可能性がある項目<br />
                ・膝裏素材
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS フロント仕様-->
<div class="modal fade" id="infotext_wp_frontSpec" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フロント仕様</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フロント仕様選択時に連動して変更される可能性がある項目<br />
                ・パンチェリーナ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS ベルトループ-->
<div class="modal fade" id="infotext_wp_beltLoop" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ベルトループ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ベルトループ選択時に連動して変更される可能性がある項目<br />
                ・ピンループ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS コインポケット-->
<div class="modal fade" id="infotext_wp_coinPkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">コインポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                コインポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 上前ピスポケット-->
<div class="modal fade" id="infotext_wp_pisPktUf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">上前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                上前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 下前ピスポケット-->
<div class="modal fade" id="infotext_wp_pisPktDf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">下前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                下前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 裾上げ-->
<div class="modal fade" id="infotext_wp_hemUp" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">裾上げ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                裾上げ選択時に連動して変更される可能性がある項目<br />
                ・ダブル幅
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 釦素材-->
<div class="modal fade" id="infotext_wp_button" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">釦素材</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                釦素材選択時に連動して変更される可能性がある項目<br />
                ・釦品番
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS PANTSモデル-->
<div class="modal fade" id="infotext_wp2_pantsModel" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">PANTSモデル</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                PANTSモデル選択時に連動して変更される可能性がある項目<br />
                ・タック<br />
                ・パンチェリーナ<br />
                ・アジャスター仕様<br />
                ・ベルトループ<br />
                ・ピンループ<br />
                ・脇ポケット<br />
                ・忍びポケット<br />
                ・コインポケット<br />
                ・上前ピスポケット<br />
                ・下前ピスポケット<br />
                ・Vカット<br />
                ・ステッチ箇所変更<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 膝裏-->
<div class="modal fade" id="infotext_wp2_kneeBack" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">膝裏</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                膝裏選択時に連動して変更される可能性がある項目<br />
                ・膝裏素材
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS フロント仕様-->
<div class="modal fade" id="infotext_wp2_frontSpec" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フロント仕様</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フロント仕様選択時に連動して変更される可能性がある項目<br />
                ・パンチェリーナ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS ベルトループ-->
<div class="modal fade" id="infotext_wp2_beltLoop" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ベルトループ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ベルトループ選択時に連動して変更される可能性がある項目<br />
                ・ピンループ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS コインポケット-->
<div class="modal fade" id="infotext_wp2_coinPkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">コインポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                コインポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 上前ピスポケット-->
<div class="modal fade" id="infotext_wp2_pisPktUf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">上前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                上前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 下前ピスポケット-->
<div class="modal fade" id="infotext_wp2_pisPktDf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">下前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                下前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 裾上げ-->
<div class="modal fade" id="infotext_wp2_hemUp" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">裾上げ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                裾上げ選択時に連動して変更される可能性がある項目<br />
                ・ダブル幅
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 釦素材-->
<div class="modal fade" id="infotext_wp2_button" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">釦素材</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                釦素材選択時に連動して変更される可能性がある項目<br />
                ・釦品番
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS PANTSモデル-->
<div class="modal fade" id="infotext_wp3_pantsModel" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">PANTSモデル</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                PANTSモデル選択時に連動して変更される可能性がある項目<br />
                ・タック<br />
                ・パンチェリーナ<br />
                ・アジャスター仕様<br />
                ・ベルトループ<br />
                ・ピンループ<br />
                ・脇ポケット<br />
                ・忍びポケット<br />
                ・コインポケット<br />
                ・上前ピスポケット<br />
                ・下前ピスポケット<br />
                ・Vカット<br />
                ・ステッチ箇所変更<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 膝裏-->
<div class="modal fade" id="infotext_wp3_kneeBack" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">膝裏</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                膝裏選択時に連動して変更される可能性がある項目<br />
                ・膝裏素材
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS フロント仕様-->
<div class="modal fade" id="infotext_wp3_frontSpec" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フロント仕様</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フロント仕様選択時に連動して変更される可能性がある項目<br />
                ・パンチェリーナ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS ベルトループ-->
<div class="modal fade" id="infotext_wp3_beltLoop" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ベルトループ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ベルトループ選択時に連動して変更される可能性がある項目<br />
                ・ピンループ
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS コインポケット-->
<div class="modal fade" id="infotext_wp3_coinPkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">コインポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                コインポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 上前ピスポケット-->
<div class="modal fade" id="infotext_wp3_pisPktUf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">上前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                上前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 下前ピスポケット-->
<div class="modal fade" id="infotext_wp3_pisPktDf" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">下前ピスポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                下前ピスポケット選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 裾上げ-->
<div class="modal fade" id="infotext_wp3_hemUp" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">裾上げ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                裾上げ選択時に連動して変更される可能性がある項目<br />
                ・ダブル幅
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS 釦素材-->
<div class="modal fade" id="infotext_wp3_button" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">釦素材</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                釦素材選択時に連動して変更される可能性がある項目<br />
                ・釦品番
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル PANTS ポケット位置-->
<div class="modal fade" id="infotext_pocketPos" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ポケット位置</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ポケット位置の説明文
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>
<!-- ウォッシャブル PANTS 釦素材-->
<div class="modal fade" id="infotext_vents" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ベント修正（高さ）</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ベント修正（高さ）の説明文
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>
<!-- 自作js -->
<script src="${pageContext.request.contextPath}/resources/app/self/js/rule.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/config.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/customer.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/tabMenu.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/product.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants1.standard.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants1.tuxedo.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants1.washable.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";

jQuery(function() {
	var pantsAdFlag="${orderForm.pantsAdFlag}";
	if(pantsAdFlag=="1"){
		jQuery("#pantsAdFlag").val("${orderForm.pantsAdFlag}");
		}
	jQuery("#op_pantsModel,#tp_pantsModel,wp_pantsModel").change(function(){
		jQuery("#pantsAdFlag").val("0");
	    })   

	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });

	var productCategory = "${orderForm.productCategory}";
	
	mateInit();

	setPantsModelDisable(productCategory);
	
	//--------------------------------------------
	// 共通
	//--------------------------------------------
	initCommon();

	//--------------------------------------------
	// タブメニュー
	//--------------------------------------------
	initTabMenu();

	//--------------------------------------------
	// お客様情報
	//--------------------------------------------
	initCustomer();

	//--------------------------------------------
	// 商品タブ
	//--------------------------------------------
	initProduct();

	//--------------------------------------------
	// オプションタブ（Jacket）
	//--------------------------------------------
		initOptionPants1Standard();

		initOptionPants1Tuxedo();

		initOptionPants1Washable();
	
	//--------------------------------------------
	// 補正タブ
	//--------------------------------------------
	initAlter();
	
	jQuery("#pantsItemFlag").val("1");
})	

function setPantsModelDisable(productCategory){
	var ptModel = null;
	if(productCategory == "0"){
		ptModel = document.getElementById("op_pantsModel");
	}else if(productCategory == "2"){
		ptModel = document.getElementById("tp_pantsModel");
	}else if(productCategory == "1"){
		ptModel = document.getElementById("wp_pantsModel");
	}
	var allJkOption = ptModel.options;
	allJkOption[0].disabled = true;
}

var opPantsModel = jQuery("#op_pantsModel").val();
if(opPantsModel == '' || opPantsModel == null){
	jQuery('#op_adjuster_id2').attr("disabled",true);
	jQuery('#op_adjuster_id4').attr("disabled",true);
}

var tpPantsModel = jQuery("#tp_pantsModel").val();
if(tpPantsModel == '' || tpPantsModel == null){
	jQuery('#tp_adjuster_id2').attr("disabled",true);
	jQuery('#tp_adjuster_id4').attr("disabled",true);
}

var wpPantsModel = jQuery("#wp_pantsModel").val();
if(wpPantsModel == '' || wpPantsModel == null){
	jQuery('#wp_adjuster_id2').attr("disabled",true);
	jQuery('#wp_adjuster_id4').attr("disabled",true);
}

jQuery("#op_pantsModel").change(function(){
	jQuery("#pantsFlag").val('1');
})

jQuery("#tp_pantsModel").change(function(){
	jQuery("#pantsFlag").val('1');
})

jQuery("#wp_pantsModel").change(function(){
	jQuery("#pantsFlag").val('1');
})

var selectStandardIdList = {
		"op_btnMate":"00033"
}
var selectTuxedoIdList = {
		"tp_btnMate":"00033"
}
var selectWashableIdList = {
		"wp_btnMate":"00033"
}

//--------------------------------------------
//素材品番の初期化
//--------------------------------------------
function mateInit(){
	var itemCode;
	var subItemCode;
	var category;
	var StkNo;
	var mateChecked;
	var optionCode;
	// 標準の場合　pants ptStandardMateListのid List
	//var ptStandardMateList = ["op_btnMate"];
	// タキシードの場合　pants ptTuxedoMateListのid List
	//var ptTuxedoMateList = ["tp_btnMate"];
	// ウォッシャブルの場合　pants ptWashableMateListのid List
	//var ptWashableMateList = ["wp_btnMate"];
	//var item = jQuery("#item option:selected").val();
	var item = jQuery("#item").val();
	//jQuery("#category option:first").prop("selected",true);
	category = jQuery('input[name="productCategory"]:checked').val();
	if(item == "01"){
		itemCode = item;
		//SUITの場合　素材品番を設定
		if(category == "0"){
			initSuitStandard(itemCode,category);
		}
		else if(category == "2"){
			initSuitTuxedo(itemCode,category);
		}
		else if(category == "1"){
			initSuitWashable(itemCode,category);
		}
		
	}else if(item=="03"){
		subItemCode = "03";
		itemCode = item;
		
		if(category=="0"){
			initPtStandard(itemCode,subItemCode,category);
		}
		else if(category=="2"){
			initPtTuxedo(itemCode,subItemCode,category);
		}
		else if(category=="1"){
			initPtWashable(itemCode,subItemCode,category);
		}
		
		jQuery('input[name="productCategory"]').change(function(){
			category = jQuery('input[name="productCategory"]:checked').val();
			if(category == "0"){
				initPtStandard(itemCode,subItemCode,category);
			}
			else if(category == "2"){
				initPtTuxedo(itemCode,subItemCode,category);
			}
			else if(category == "1"){
				initPtWashable(itemCode,subItemCode,category);
			}
		});
	}
	
	function initSuitStandard(itemCode,category){
		subItemCode = "03";
		initPtStandard(itemCode,subItemCode,category);
	}

	function initSuitTuxedo(itemCode,category){
		subItemCode = "03";
		initPtTuxedo(itemCode,subItemCode,category);
	}

	function initSuitWashable(itemCode,category){
		subItemCode = "03";
		initPtWashable(itemCode,subItemCode,category);
	}
			
	function initPtStandard(itemCode,subItemCode,category){
		/* for(var i in ptStandardMateList){
			optionCode = selectStandardIdList[ptStandardMateList[i]];
			mateChecked = jQuery("#"+ptStandardMateList[i]+" option:checked").val();
			StkNo = "#"+ptStandardMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		} */
		mateSelect(itemCode,subItemCode,"#op_btnMate option:checked","00033","#op_btnMateStkNo",category,orderPattern);
		jQuery("#op_btnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			optionCode = selectStandardIdList[idValue];
			mateChecked = jQuery("#"+idValue+" option:checked").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		})	
	}

	function initPtTuxedo(itemCode,subItemCode,category){
		/* for(var i in ptTuxedoMateList){
			optionCode = selectTuxedoIdList[ptTuxedoMateList[i]];
			mateChecked = jQuery("#"+ptTuxedoMateList[i]+" option:checked").val();
			StkNo = "#"+ptTuxedoMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		} */
		mateSelect(itemCode,subItemCode,"#tp_btnMate option:checked","00033","#tp_btnMateStkNo",category,orderPattern);
		jQuery("#tp_btnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			optionCode = selectTuxedoIdList[idValue];
			mateChecked = jQuery("#"+idValue+" option:checked").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		})	
	}

	function initPtWashable(itemCode,subItemCode,category){
		/* for(var i in ptWashableMateList){
			optionCode = selectWashableIdList[ptWashableMateList[i]];
			mateChecked = jQuery("#"+ptWashableMateList[i]+" option:checked").val();
			StkNo = "#"+ptWashableMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		} */
		mateSelect(itemCode,subItemCode,"#wp_btnMate option:checked","00033","#wp_btnMateStkNo",category,orderPattern);
		jQuery("#wp_btnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			optionCode = selectWashableIdList[idValue];
			mateChecked = jQuery("#"+idValue+" option:checked").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		})	
	}

	//素材によって　品番を設定
	function mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,type,orderPattern){
		var StkNoSelect = jQuery(StkNo);
		var url;
		if (type == 0){
			url = "/orderCo/standardMateSelect";
		}else if(type == 2){
			url = "/orderCo/tuxdoMateSelect";
		}else if(type == 1){
			url = "/orderCo/washabiMateSelect";
		}
		jQuery.ajax({
			 type:"get",
			 url: contextPath + url,
			 async: false,
			 data:{"itemCode":itemCode,"subItemCode":subItemCode,"mateChecked":mateChecked,"orderPattern":orderPattern,"optionCode":optionCode},
			 success:function(result){
				 StkNoSelect.empty();
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
function  opSession(){

	//コインポケット
	jQuery("#op_coinPkt").val("${orderForm.optionPantsStandardInfo.opCoinPkt}");
	jQuery("#op_coinPkt").change();

	//裾上げ
	jQuery('#op_hemUp').val("${orderForm.optionPantsStandardInfo.opHemUp}");
	jQuery('#op_hemUp').change();
	
	//ベルトループ
	jQuery('input[name="optionPantsStandardInfo.opBeltLoop"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoop}"]);
	jQuery('input[name="optionPantsStandardInfo.opBeltLoop"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace1"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace1}"]);
	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace1"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace2"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace2}"]);
	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace2"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace3"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace3}"]);
	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace3"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace4"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace4}"]);
	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace4"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace5"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace5}"]);
	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace5"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace6"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace6}"]);
	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace6"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace7"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace7}"]);
	jQuery('input[name="optionPantsStandardInfo.opBeltLoopPlace7"]').change();

	//ステッチ箇所変更
	jQuery('input[name="optionPantsStandardInfo.opStitchModify"]').val(["${orderForm.optionPantsStandardInfo.opStitchModify}"]);
	jQuery('input[name="optionPantsStandardInfo.opStitchModify"]').change();

	jQuery('input[name="optionPantsStandardInfo.opStitchModifyPlace1"]').val(["${orderForm.optionPantsStandardInfo.opStitchModifyPlace1}"]);
	jQuery('input[name="optionPantsStandardInfo.opStitchModifyPlace1"]').change();

	jQuery('input[name="optionPantsStandardInfo.opStitchModifyPlace2"]').val(["${orderForm.optionPantsStandardInfo.opStitchModifyPlace2}"]);
	jQuery('input[name="optionPantsStandardInfo.opStitchModifyPlace2"]').change();

	jQuery('input[name="optionPantsStandardInfo.opStitchModifyPlace3"]').val(["${orderForm.optionPantsStandardInfo.opStitchModifyPlace3}"]);
	jQuery('input[name="optionPantsStandardInfo.opStitchModifyPlace3"]').change();

	jQuery('input[name="optionPantsStandardInfo.opStitchModifyPlace4"]').val(["${orderForm.optionPantsStandardInfo.opStitchModifyPlace4}"]);
	jQuery('input[name="optionPantsStandardInfo.opStitchModifyPlace4"]').change();

	//ダブルステッチ
	jQuery('input[name="optionPantsStandardInfo.op2DStitch"]').val(["${orderForm.optionPantsStandardInfo.opDStitch}"]);
	jQuery('input[name="optionPantsStandardInfo.op2DStitch"]').change();

	jQuery('input[name="optionPantsStandardInfo.op2DStitchPlace1"]').val(["${orderForm.optionPantsStandardInfo.opDStitchPlace1}"]);
	jQuery('input[name="optionPantsStandardInfo.op2DStitchPlace1"]').change();

	jQuery('input[name="optionPantsStandardInfo.opDStitchPlace2"]').val(["${orderForm.optionPantsStandardInfo.opDStitchPlace2}"]);
	jQuery('input[name="optionPantsStandardInfo.opDStitchPlace2"]').change();

	jQuery('input[name="optionPantsStandardInfo.opDStitchPlace3"]').val(["${orderForm.optionPantsStandardInfo.opDStitchPlace3}"]);
	jQuery('input[name="optionPantsStandardInfo.opDStitchPlace3"]').change();

	jQuery('input[name="optionPantsStandardInfo.opDStitchPlace4"]').val(["${orderForm.optionPantsStandardInfo.opDStitchPlace4}"]);
	jQuery('input[name="optionPantsStandardInfo.opDStitchPlace4"]').change();	

	//AMF色指定
	jQuery('input[name="optionPantsStandardInfo.opAmfColor"]').val(["${orderForm.optionPantsStandardInfo.opAmfColor}"]);
	jQuery('input[name="optionPantsStandardInfo.opAmfColor"]').change();

	jQuery("#op_amfColorPlaceAll").val("${orderForm.optionPantsStandardInfo.opAmfColorPlaceAll}");
	jQuery("#op_amfColorPlaceAll").change();

	jQuery('input[name="optionPantsStandardInfo.opAmfColorPlace1"]').val(["${orderForm.optionPantsStandardInfo.opAmfColorPlace1}"]);
	jQuery('input[name="optionPantsStandardInfo.opAmfColorPlace1"]').change();

	jQuery('input[name="optionPantsStandardInfo.opAmfColorPlace2"]').val(["${orderForm.optionPantsStandardInfo.opAmfColorPlace2}"]);
	jQuery('input[name="optionPantsStandardInfo.opAmfColorPlace2"]').change();

	jQuery('input[name="optionPantsStandardInfo.opAmfColorPlace3"]').val(["${orderForm.optionPantsStandardInfo.opAmfColorPlace3}"]);
	jQuery('input[name="optionPantsStandardInfo.opAmfColorPlace3"]').change();

	jQuery('input[name="optionPantsStandardInfo.opAmfColorPlace4"]').val(["${orderForm.optionPantsStandardInfo.opAmfColorPlace4}"]);
	jQuery('input[name="optionPantsStandardInfo.opAmfColorPlace4"]').change();

	jQuery('input[name="optionPantsStandardInfo.opAmfColor1"]').val(["${orderForm.optionPantsStandardInfo.opAmfColor1}"]);
	jQuery('input[name="optionPantsStandardInfo.opAmfColor1"]').change();

	jQuery('input[name="optionPantsStandardInfo.opAmfColor2"]').val(["${orderForm.optionPantsStandardInfo.opAmfColor2}"]);
	jQuery('input[name="optionPantsStandardInfo.opAmfColor2"]').change();

	jQuery('input[name="optionPantsStandardInfo.opAmfColor3"]').val(["${orderForm.optionPantsStandardInfo.opAmfColor3}"]);
	jQuery('input[name="optionPantsStandardInfo.opAmfColor3"]').change();

	jQuery('input[name="optionPantsStandardInfo.opAmfColor4"]').val(["${orderForm.optionPantsStandardInfo.opAmfColor4}"]);
	jQuery('input[name="optionPantsStandardInfo.opAmfColor4"]').change();

	//ボタンホール色指定
	jQuery('input[name="optionPantsStandardInfo.opBhColor"]').val(["${orderForm.optionPantsStandardInfo.opBhColor}"]);
	jQuery('input[name="optionPantsStandardInfo.opBhColor"]').change();

	jQuery("#op_bhColorPlaceAll").val("${orderForm.optionPantsStandardInfo.opBhColorPlaceAll}");
	jQuery("#op_bhColorPlaceAll").change();

	jQuery('input[name="optionPantsStandardInfo.opBhColorPlace1"]').val(["${orderForm.optionPantsStandardInfo.opBhColorPlace1}"]);
	jQuery('input[name="optionPantsStandardInfo.opBhColorPlace1"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBhColorPlace2"]').val(["${orderForm.optionPantsStandardInfo.opBhColorPlace2}"]);
	jQuery('input[name="optionPantsStandardInfo.opBhColorPlace2"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBhColorPlace3"]').val(["${orderForm.optionPantsStandardInfo.opBhColorPlace3}"]);
	jQuery('input[name="optionPantsStandardInfo.opBhColorPlace3"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBhColorPlace4"]').val(["${orderForm.optionPantsStandardInfo.opBhColorPlace4}"]);
	jQuery('input[name="optionPantsStandardInfo.opBhColorPlace4"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBhColor1"]').val(["${orderForm.optionPantsStandardInfo.opBhColor1}"]);
	jQuery('input[name="optionPantsStandardInfo.opBhColor1"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBhColor2"]').val(["${orderForm.optionPantsStandardInfo.opBhColor2}"]);
	jQuery('input[name="optionPantsStandardInfo.opBhColor2"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBhColor3"]').val(["${orderForm.optionPantsStandardInfo.opBhColor3}"]);
	jQuery('input[name="optionPantsStandardInfo.opBhColor3"]').change();

	jQuery('input[name="optionPantsStandardInfo.opBhColor4"]').val(["${orderForm.optionPantsStandardInfo.opBhColor4}"]);
	jQuery('input[name="optionPantsStandardInfo.opBhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="optionPantsStandardInfo.opByColor"]').val(["${orderForm.optionPantsStandardInfo.opByColor}"]);
	jQuery('input[name="optionPantsStandardInfo.opByColor"]').change();
	
	jQuery("#op_byColorPlaceAll").val("${orderForm.optionPantsStandardInfo.opByColorPlaceAll}");
	jQuery("#op_byColorPlaceAll").change();

	jQuery('input[name="optionPantsStandardInfo.opByColorPlace1"]').val(["${orderForm.optionPantsStandardInfo.opByColorPlace1}"]);
	jQuery('input[name="optionPantsStandardInfo.opByColorPlace1"]').change();

	jQuery('input[name="optionPantsStandardInfo.op2ByColorPlace2"]').val(["${orderForm.optionPantsStandardInfo.opByColorPlace2}"]);
	jQuery('input[name="optionPantsStandardInfo.op2ByColorPlace2"]').change();

	jQuery('input[name="optionPantsStandardInfo.opByColorPlace3"]').val(["${orderForm.optionPantsStandardInfo.opByColorPlace3}"]);
	jQuery('input[name="optionPantsStandardInfo.opByColorPlace3"]').change();

	jQuery('input[name="optionPantsStandardInfo.op2ByColorPlace4"]').val(["${orderForm.optionPantsStandardInfo.opByColorPlace4}"]);
	jQuery('input[name="optionPantsStandardInfo.op2ByColorPlace4"]').change();

	//釦素材
	jQuery('#op_btnMate').val("${orderForm.optionPantsStandardInfo.opButton}");
	jQuery('#op_btnMate').change();

	jQuery('#op_btnMateStkNo').val("${orderForm.optionPantsStandardInfo.opBtnMateStkNo}");
	jQuery('#op_btnMateStkNo').change();
}

function  tp2Session(){

	//コインポケット
	jQuery("#tp_coinPkt").val("${orderForm.optionPantsTuxedoInfo.tpCoinPkt}");
	jQuery("#tp_coinPkt").change();

	//裾上げ
	jQuery("#tp_hemUp").val("${orderForm.optionPantsTuxedoInfo.tpHemUp}");
	jQuery("#tp_hemUp").change();

   //ベルトループ 
    jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoop"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoop}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoop"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace1"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace1}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace1"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace2"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace2}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace2"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace3"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace3}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace3"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace4"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace4}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace4"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace5"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace5}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace5"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace6"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace6}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace6"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace7"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace7}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBeltLoopPlace7"]').change();

	//ステッチ種類
	jQuery('input[name="optionPantsTuxedoInfo.tpStitch"]').val(["${orderForm.optionPantsTuxedoInfo.tpStitch}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpStitch"]').change();
	//ボタンホール色指定
	jQuery('input[name="optionPantsTuxedoInfo.tpBhColor"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColor}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBhColor"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBhColorPlace1"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColorPlace1}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBhColorPlace1"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBhColorPlace2"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColorPlace2}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBhColorPlace2"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBhColorPlace3"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColorPlace3}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBhColorPlace3"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBhColorPlace4"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColorPlace4}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBhColorPlace4"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBhColorPlace5"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColorPlace5}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBhColorPlace5"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBhColor1"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColor1}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBhColor1"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBhColor2"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColor2}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBhColor2"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBhColor3"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColor3}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBhColor3"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpBhColor4"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColor4}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpBhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="optionPantsTuxedoInfo.tpByColor"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColor}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpByColor"]').change();
	jQuery("#tp_byColorPlaceAll").val("${orderForm.optionPantsTuxedoInfo.tpByColorPlaceAll}");
	jQuery("#tp_byColorPlaceAll").change();

	jQuery('input[name="optionPantsTuxedoInfo.tpByColorPlace1"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColorPlace1}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpByColorPlace1"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpByColorPlace2"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColorPlace2}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpByColorPlace2"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpByColorPlace3"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColorPlace3}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpByColorPlace3"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpByColorPlace4"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColorPlace4}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpByColorPlace4"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpByColor1"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColor1}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpByColor1"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpByColor2"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColor2}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpByColor2"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpByColor3"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColor3}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpByColor3"]').change();

	jQuery('input[name="optionPantsTuxedoInfo.tpByColor4"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColor4}"]);
	jQuery('input[name="optionPantsTuxedoInfo.tpByColor4"]').change();
	
}
function  wp2Session(){

	//ベルトループ
	jQuery('input[name="optionPantsWashableInfo.wpBeltLoop"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoop}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBeltLoop"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace1"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace1}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace1"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace2"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace2}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace2"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace3"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace3}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace3"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace4}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace4"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace5"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace5}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace5"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace6"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace6}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace6"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace7"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace7}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBeltLoopPlace7"]').change();

	//ステッチ種類
	jQuery('input[name="optionPantsWashableInfo.wpStitch"]').val(["${orderForm.optionPantsWashableInfo.wpStitch}"]);
	jQuery('input[name="optionPantsWashableInfo.wpStitch"]').change();
	//ステッチ箇所変更
	jQuery('input[name="optionPantsWashableInfo.wpStitchModify"]').val(["${orderForm.optionPantsWashableInfo.wpStitchModify}"]);
	jQuery('input[name="optionPantsWashableInfo.wpStitchModify"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpStitchModifyPlace1"]').val(["${orderForm.optionPantsWashableInfo.wpStitchModifyPlace1}"]);
	jQuery('input[name="optionPantsWashableInfo.wpStitchModifyPlace1"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpStitchModifyPlace2"]').val(["${orderForm.optionPantsWashableInfo.wpStitchModifyPlace2}"]);
	jQuery('input[name="optionPantsWashableInfo.wpStitchModifyPlace2"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpStitchModifyPlace3"]').val(["${orderForm.optionPantsWashableInfo.wpStitchModifyPlace3}"]);
	jQuery('input[name="optionPantsWashableInfo.wpStitchModifyPlace3"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpStitchModifyPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpStitchModifyPlace4}"]);
	jQuery('input[name="optionPantsWashableInfo.wpStitchModifyPlace4"]').change();
	
	//ダブルステッチ
	jQuery('input[name="optionPantsWashableInfo.wpDStitch"]').val(["${orderForm.optionPantsWashableInfo.wpDStitch}"]);
	jQuery('input[name="optionPantsWashableInfo.wpDStitch"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpDStitchPlace1"]').val(["${orderForm.optionPantsWashableInfo.wpDStitchPlace1}"]);
	jQuery('input[name="optionPantsWashableInfo.wpDStitchPlace1"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpDStitchPlace2"]').val(["${orderForm.optionPantsWashableInfo.wpDStitchPlace2}"]);
	jQuery('input[name="optionPantsWashableInfo.wpDStitchPlace2"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpDStitchPlace3"]').val(["${orderForm.optionPantsWashableInfo.wpDStitchPlace3}"]);
	jQuery('input[name="optionPantsWashableInfo.wpDStitchPlace3"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpDStitchPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpDStitchPlace4}"]);
	jQuery('input[name="optionPantsWashableInfo.wpDStitchPlace4"]').change();

	//AMF色指定
	jQuery('input[name="optionPantsWashableInfo.wpAmfColor"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColor}"]);
	jQuery('input[name="optionPantsWashableInfo.wpAmfColor"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpAmfColorPlace1"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColorPlace1}"]);
	jQuery('input[name="optionPantsWashableInfo.wpAmfColorPlace1"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpAmfColorPlace2"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColorPlace2}"]);
	jQuery('input[name="optionPantsWashableInfo.wpAmfColorPlace2"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpAmfColorPlace3"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColorPlace3}"]);
	jQuery('input[name="optionPantsWashableInfo.wpAmfColorPlace3"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpAmfColorPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColorPlace4}"]);
	jQuery('input[name="optionPantsWashableInfo.wpAmfColorPlace4"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpAmfColor1"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColor1}"]);
	jQuery('input[name="optionPantsWashableInfo.wpAmfColor1"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpAmfColor2"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColor2}"]);
	jQuery('input[name="optionPantsWashableInfo.wpAmfColor2"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpAmfColor3"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColor3}"]);
	jQuery('input[name="optionPantsWashableInfo.wpAmfColor3"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpAmfColor4"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColor4}"]);
	jQuery('input[name="optionPantsWashableInfo.wpAmfColor4"]').change();

	//ボタンホール色指定
	jQuery('input[name="optionPantsWashableInfo.wpBhColor"]').val(["${orderForm.optionPantsWashableInfo.wpBhColor}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBhColor"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBhColorPlace1"]').val(["${orderForm.optionPantsWashableInfo.wpBhColorPlace1}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBhColorPlace1"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBhColorPlace2"]').val(["${orderForm.optionPantsWashableInfo.wpBhColorPlace2}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBhColorPlace2"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBhColorPlace3"]').val(["${orderForm.optionPantsWashableInfo.wpBhColorPlace3}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBhColorPlace3"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBhColorPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpBhColorPlace4}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBhColorPlace4"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBhColorPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpBhColorPlace4}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBhColorPlace4"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBhColor1"]').val(["${orderForm.optionPantsWashableInfo.wpBhColor1}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBhColor1"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBhColor2"]').val(["${orderForm.optionPantsWashableInfo.wpBhColor2}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBhColor2"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBhColor3"]').val(["${orderForm.optionPantsWashableInfo.wpBhColor3}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBhColor3"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpBhColor4"]').val(["${orderForm.optionPantsWashableInfo.wpBhColor4}"]);
	jQuery('input[name="optionPantsWashableInfo.wpBhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="optionPantsWashableInfo.wpByColor"]').val(["${orderForm.optionPantsWashableInfo.wpByColor}"]);
	jQuery('input[name="optionPantsWashableInfo.wpByColor"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpByColorPlace1"]').val(["${orderForm.optionPantsWashableInfo.wpByColorPlace1}"]);
	jQuery('input[name="optionPantsWashableInfo.wpByColorPlace1"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpByColorPlace2"]').val(["${orderForm.optionPantsWashableInfo.wpByColorPlace2}"]);
	jQuery('input[name="optionPantsWashableInfo.wpByColorPlace2"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpByColorPlace3"]').val(["${orderForm.optionPantsWashableInfo.wpByColorPlace3}"]);
	jQuery('input[name="optionPantsWashableInfo.wpByColorPlace3"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpByColorPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpByColorPlace4}"]);
	jQuery('input[name="optionPantsWashableInfo.wpByColorPlace4"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpByColor1"]').val(["${orderForm.optionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="optionPantsWashableInfo.wpByColor1"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpByColor1"]').val(["${orderForm.optionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="optionPantsWashableInfo.wpByColor1"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpByColor1"]').val(["${orderForm.optionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="optionPantsWashableInfo.wpByColor1"]').change();

	jQuery('input[name="optionPantsWashableInfo.wpByColor1"]').val(["${orderForm.optionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="optionPantsWashableInfo.wpByColor1"]').change();
}

</script>