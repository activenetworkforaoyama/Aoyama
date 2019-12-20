<form:form id="idInfoForm" action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm" method="post" modelAttribute="orderCoForm" class="form-horizontal">
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
                                <form:select id="op_pantsModel" path="coOptionPantsStandardInfo.opPantsModel" class="form-control-sm form-control">
                                		<form:options items="${orderCoForm.coOptionPantsStandardInfo.opPantsModelMap}"/>
                                </form:select>
                            </div>
                           
                            <div class="col-12 col-md-9 offset-md-3" id="op_pantsModelMsg" style="margin-top:8px"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_pantsModelCheck" style="display:none"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                                <form:select id="op_tack" path="coOptionPantsStandardInfo.opTack" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPantsStandardInfo.opTackMap}"/>
                                </form:select>
                            </div>
                           <!--  <div class="col-12 col-md-9 offset-md-3" id="op_tackMsg"></div> -->
                            <div class="col-12 col-md-6" id="op_tack_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_kneeBack"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                     <form:radiobuttons id="op_kneeBack_id" path="coOptionPantsStandardInfo.opKneeBack" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opKneeBackMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="op_kneeBack_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group" id="op_kneeBackMate_div">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_kneeBackMate_id" path="coOptionPantsStandardInfo.opKneeBackMate" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opKneeBackMateMap}"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="op_kneeBackMate_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント仕様</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_frontSpec"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_frontSpec_id" path="coOptionPantsStandardInfo.opFrontSpec" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opFrontSpecMap}"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="op_frontSpec_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_pancherina_id" path="coOptionPantsStandardInfo.opPancherina" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opPancherinaMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="op_pancherina_Msg" align="right">
                            </div>
                            <!-- <div class="col-12 col-md-9 offset-md-3" id="op_pancherinaMsg"></div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_adjuster_id" path="coOptionPantsStandardInfo.opAdjuster" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opAdjusterMap}"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="op_adjuster_Msg" align="right">
                            </div>
                            <!-- <div class="col-12 col-md-9 offset-md-3" id="op_adjusterMsg"></div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベルトループ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_beltLoop"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_beltLoop_id" path="coOptionPantsStandardInfo.opBeltLoop" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opBeltLoopMap}"/>
                                </div>
                                <div class="offset-md-1" id="op_beltLoopPlace">
                                    <div>
                                        <div class="form-check-inline form-check">
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op_beltLoopPlace">全選択</button>&nbsp;
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op_beltLoopPlace">全解除</button>
                                        </div>
                                    </div>
                                    <%-- <div class="form-check-inline form-check">
                                        <form:checkboxes id="op_beltLoopPlace_id" items="${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlaceMap }" path="coOptionPantsStandardInfo.opBeltLoopPlace" class="form-check-input"/>
                                    </div> --%>
                                    <c:forEach var="opBeltLoopPlaceMap" items="${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlaceMap }" varStatus="row">
                                		<div class="form-check-inline form-check" id="op_beltLoopPlace_id1${row.count}">
                                			<input type="checkbox" id="op_beltLoopPlace_id${row.count}" name="coOptionPantsStandardInfo.opBeltLoopPlace${row.count}" value="${opBeltLoopPlaceMap.key}" class="form-check-input">${opBeltLoopPlaceMap.value}
                                		</div>
                                	</c:forEach>
                                </div>
                            </div>
                           <!--  <div class="col-12 col-md-9 offset-md-3" id="op_beltLoopMsg"></div> -->
                            <div class="col-12 col-md-3" id="op_beltLoop_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_pinLoop_id" path="coOptionPantsStandardInfo.opPinLoop" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opPinLoopMap}"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="op_pinLoop_Msg" align="right">
                            </div>
                           <!--  <div class="col-12 col-md-9 offset-md-3" id="op_pinLoopMsg"></div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_sidePkt_id" path="coOptionPantsStandardInfo.opSidePkt" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opSidePktMap}"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="op_sidePkt_Msg" align="right">
                            </div>
                           <!--  <div class="col-12 col-md-9 offset-md-3" id="op_sidePktMsg"></div>-->
                        </div> 
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_sinobiPkt_id" path="coOptionPantsStandardInfo.opSinobiPkt" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opSinobiPktMap}"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="op_sinobiPkt_Msg" align="right">
                            </div>                      
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コインポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_coinPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op_coinPkt" class="form-control-sm form-control" path="coOptionPantsStandardInfo.opCoinPkt">
                                	<form:options items="${orderCoForm.coOptionPantsStandardInfo.opCoinPktMap}"/>
                                </form:select>
                            </div>
                           <!--  <div class="col-12 col-md-9 offset-md-3" id="op_coinPktMsg"></div> -->
                              <div class="col-12 col-md-6" id="op_coinPkt_Msg" align="right">
                            </div> 
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                   	<form:radiobuttons id="op_flapCoinPkt_id" path="coOptionPantsStandardInfo.opFlapCoinPkt" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opFlapCoinPktMap }"/>　
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="op_flapCoinPkt_Msg" align="right">
                            </div>
                           <!--  <div class="col-12 col-md-9 offset-md-3" id="op_flapCoinPktMsg"></div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_pisPktUf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_pisPktUf_id" path="coOptionPantsStandardInfo.opPisPktUf" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opPisPktUfMap }"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="op_pisPktUf_Msg" align="right">
                            </div>
                           <!--  <div class="col-12 col-md-9 offset-md-3" id="op_pisPktUfMsg"></div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_pisPktDf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_pisPktDf_id" path="coOptionPantsStandardInfo.opPisPktDf" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opPisPktDfMap }"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="op_pisPktDf_Msg" align="right">
                            </div>
                           <!--  <div class="col-12 col-md-9 offset-md-3" id="op_pisPktDfMsg"></div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">Vカット</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_vCut_id" path="coOptionPantsStandardInfo.opVCut" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opVCutMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="op_vCut_Msg" align="right">
                            </div>
                           <!--  <div class="col-12 col-md-9 offset-md-3" id="op_vCutMsg"></div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_hemUp"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op_hemUp" path="coOptionPantsStandardInfo.opHemUp" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPantsStandardInfo.opHemUpMap }"/>
                                </form:select>
                            </div>
                             <div class="col-12 col-md-6" id="op_hemUp_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group"  id="op_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                                <form:select id="op_doubleWide" path="coOptionPantsStandardInfo.opDoubleWide" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPantsStandardInfo.opDoubleWideMap }"/>
                                </form:select>
                            </div>
                              <div class="col-12 col-md-6" id="op_doubleWide_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_stitch"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_stitch_id" path="coOptionPantsStandardInfo.opStitch" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opStitchMap }"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="op_stitch_Msg" align="right">
                            </div>
                        </div>
                        <div id="op_stitch_yes_area">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_stitchModify_id" path="coOptionPantsStandardInfo.opStitchModify" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opStitchModifyMap }"/>
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
                                    <form:checkboxes id="op_stitchModifyPlace_id" items="${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlaceMap }" path="coOptionPantsStandardInfo.opStitchModifyPlace" class="form-check-input"/>
                                </div> --%>
                                <c:forEach var="opStitchModifyPlaceMap" items="${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="op_stitchModifyPlace_id${row.count}" name="coOptionPantsStandardInfo.opStitchModifyPlace${row.count}" value="${opStitchModifyPlaceMap.key}" class="form-check-input">${opStitchModifyPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="op_stitchModify_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ダブルステッチ変更</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_dStitch_id" path="coOptionPantsStandardInfo.opDStitch" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opDStitchMap }"/>
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
                                    <form:checkboxes id="op_dStitchPlace_id" items="${orderCoForm.coOptionPantsStandardInfo.opDStitchPlaceMap }" path="coOptionPantsStandardInfo.opDStitchPlace" class="form-check-input"/>
                                </div> --%>
                                <c:forEach var="opDStitchPlaceMap" items="${orderCoForm.coOptionPantsStandardInfo.opDStitchPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="op_dStitchPlace_id${row.count}" name="coOptionPantsStandardInfo.opDStitchPlace${row.count}" value="${opDStitchPlaceMap.key}" class="form-check-input">${opDStitchPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="op_dStitch_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_amfColor_id" path="coOptionPantsStandardInfo.opAmfColor" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opAmfColorMap }"/>
                                </div>
                                <div id="op_amfColor_div" style="display:none;">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="op_amfColorPlaceAll" path="coOptionPantsStandardInfo.opAmfColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op_amfColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op_amfColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="opAmfColorPlaceMap" items="${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="op_amfColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="op_amfColorPlace_${row.count}" name="coOptionPantsStandardInfo.opAmfColorPlace${row.count}" value="${opAmfColorPlaceMap.key }" class="form-check-input">${opAmfColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="op_amfColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="opAmfColorsMap" items="${orderCoForm.coOptionPantsStandardInfo.opAmfColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op_amfColor" class="form-check-label ">
                                			    <input type="radio" id="op_amfColor_${opAmfColorsMap.key}" name="coOptionPantsStandardInfo.opAmfColor${row.count}" value="${opAmfColorsMap.key}" class="form-check-input">${opAmfColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                         <div class="col-12 col-md-3" id="op_amfColor_Msg" align="right">
                            </div>
                        </div>
                          
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_bhColor_id" path="coOptionPantsStandardInfo.opBhColor" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opBhColorMap }"/>
                                </div>
                                <div id="op_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="op_bhColorPlaceAll" path="coOptionPantsStandardInfo.opBhColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderCoForm.coOptionPantsStandardInfo.opBhColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="opBhColorPlaceMap" items="${orderCoForm.coOptionPantsStandardInfo.opBhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="op_bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="op_bhColorPlace_${row.count}" name="coOptionPantsStandardInfo.opBhColorPlace${row.count}" value="${opBhColorPlaceMap.key }" class="form-check-input">${opBhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="op_bhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="opBhColorsMap" items="${orderCoForm.coOptionPantsStandardInfo.opBhColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op_bhColor" class="form-check-label ">
                                			    <input type="radio" id="op_bhColor_${opBhColorsMap.key}" name="coOptionPantsStandardInfo.opBhColor${row.count}" value="${opBhColorsMap.key}" class="form-check-input">${opBhColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div> 
                            </div>
                             <div class="col-12 col-md-3" id="op_bhColor_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_byColor_id" path="coOptionPantsStandardInfo.opByColor" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opByColorMap }"/>
                                </div>
                                <div id="op_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="op_byColorPlaceAll" path="coOptionPantsStandardInfo.opByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderCoForm.coOptionPantsStandardInfo.opByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op_byColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="opByColorPlaceMap" items="${orderCoForm.coOptionPantsStandardInfo.opByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="op_byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="op_byColorPlace_${row.count}" name="coOptionPantsStandardInfo.opByColorPlace${row.count}" value="${opByColorPlaceMap.key }" class="form-check-input">${opByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="op_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="opByColorsMap" items="${orderCoForm.coOptionPantsStandardInfo.opByColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op_byColorPlace" class="form-check-label ">
                                			    <input type="radio" id="op_byColor_${opByColorsMap.key}" name="coOptionPantsStandardInfo.opByColor${row.count}" value="${opByColorsMap.key}" class="form-check-input">${opByColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="op_byColor_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op_button"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op_btnMate" class="form-control-sm form-control" path="coOptionPantsStandardInfo.opButton">
                                	<form:options items="${orderCoForm.coOptionPantsStandardInfo.opButtonMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="coOptionPantsStandardInfo.opBtnMateStkNo" id="op_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col-12 col-md-2" id="op_btnMate_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_suspenderBtn_id" path="coOptionPantsStandardInfo.opSuspenderBtn" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opSuspenderBtnMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="op_suspenderBtn_Msg" align="right">
                            </div>
                        </div>                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_eight_id" path="coOptionPantsStandardInfo.opEight" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opEightMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="op_eight_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_thick_id" path="coOptionPantsStandardInfo.opThick" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opThickMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="op_thick_Msg"></output>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op_shapeMemory_id" path="coOptionPantsStandardInfo.opShapeMemory" class="form-check-input" items="${orderCoForm.coOptionPantsStandardInfo.opShapeMemoryMap }"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="op_shapeMemory_Msg" align="right">
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
                            	<form:select id="tp_pantsModel" path="coOptionPantsTuxedoInfo.tpPantsModel" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPantsTuxedoInfo.tpPantsModelMap}"/>
                                </form:select>
                            </div>                   
                            <div class="col-12 col-md-9 offset-md-3" id="tp_pantsModelMsg" style="margin-top:8px"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_pantsModelCheck" style="display:none"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tp_tack" path="coOptionPantsTuxedoInfo.tpTack" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPantsTuxedoInfo.tpTackMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" id="tp_tack_Msg" align="right">
                            </div>
                           <!--  <div class="col-12 col-md-9 offset-md-3" id="tp_tackMsg"></div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">拝絹地</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tp_GlossFablic" path="coOptionPantsTuxedoInfo.tpGlossFablic" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPantsTuxedoInfo.tpGlossFablicMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" id="tp_GlossFablic_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_kneeBack"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                     <form:radiobuttons id="tp_kneeBack_id" path="coOptionPantsTuxedoInfo.tpKneeBack" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpKneeBackMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="tp_kneeBack_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group" id="tp_kneeBackMate_div">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_kneeBackMate_id" path="coOptionPantsTuxedoInfo.tpKneeBackMate" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpKneeBackMateMap}"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="tp_kneeBackMate_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント仕様</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_frontSpec"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_frontSpec_id" path="coOptionPantsTuxedoInfo.tpFrontSpec" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpFrontSpecMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="tp_frontSpec_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_pancherina_id" path="coOptionPantsTuxedoInfo.tpPancherina" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpPancherinaMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="tp_pancherina_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_adjuster_id" path="coOptionPantsTuxedoInfo.tpAdjuster" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpAdjusterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="tp_adjuster_Msg" align="right"></div>
                            <!-- <div class="col-12 col-md-9 offset-md-3" id="tp_adjusterMsg"></div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベルトループ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_beltLoop"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_beltLoop_id" path="coOptionPantsTuxedoInfo.tpBeltLoop" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopMap}"/>                    
                                </div>
                                <div class="offset-md-1" id="tp_beltLoopPlace">
                                    <div>
                                        <div class="form-check-inline form-check">
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tp_beltLoopPlace">全選択</button>&nbsp;
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tp_beltLoopPlace">全解除</button>
                                        </div>
                                    </div>
                                   <%--  <div class="form-check-inline form-check">
                                    	<form:checkboxes id="tp_beltLoopPlace_id" items="${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlaceMap }" path="coOptionPantsTuxedoInfo.tpBeltLoopPlace" class="form-check-input"/>
                                    </div> --%>
                                    <c:forEach var="tpBeltLoopPlaceMap" items="${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check" id="tp_beltLoopPlace_id1${row.count}">
                                		<input type="checkbox" id="tp_beltLoopPlace_id${row.count}" name="coOptionPantsTuxedoInfo.tpBeltLoopPlace${row.count}" value="${tpBeltLoopPlaceMap.key}" class="form-check-input">${tpBeltLoopPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="tp_beltLoop_Msg" align="right"></div>
                            <!-- <div class="col-12 col-md-9 offset-md-3" id="tp_beltLoopMsg"></div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_pinLoop_id" path="coOptionPantsTuxedoInfo.tpPinLoop" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpPinLoopMap}"/>
                                </div>
                            </div>
                            <!-- <div class="col-12 col-md-9 offset-md-3" id="tp_pinLoopMsg"></div> -->
                            <div class="col-12 col-md-3" id="tp_pinLoop_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_sidePkt_id" path="coOptionPantsTuxedoInfo.tpSidePkt" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpSidePktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="tp_sidePkt_Msg" align="right"></div>
                           <!--  <div class="col-12 col-md-9 offset-md-3" id="tp_sidePktMsg"></div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_sinobiPkt_id" path="coOptionPantsTuxedoInfo.tpSinobiPkt" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpSinobiPktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="tp_sinobiPkt_Msg" align="right"></div>
                            <!-- <div class="col-12 col-md-9 offset-md-3" id="tp_sinobiPktMsg"></div> -->
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コインポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_coinPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tp_coinPkt" class="form-control-sm form-control" path="coOptionPantsTuxedoInfo.tpCoinPkt">
                                	<form:options items="${orderCoForm.coOptionPantsTuxedoInfo.tpCoinPktMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" id="tp_coinPkt_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                   	<form:radiobuttons id="tp_flapCoinPkt_id" path="coOptionPantsTuxedoInfo.tpFlapCoinPkt" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpFlapCoinPktMap }"/>　
                                </div>
                            </div>
                           <div class="col-12 col-md-3" id="tp_flapCoinPkt_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_pisPktUf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-7">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_pisPktUf_id" path="coOptionPantsTuxedoInfo.tpPisPktUf" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpPisPktUfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-2" id="tp_pisPktUf_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_pisPktDf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-7">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_pisPktDf_id" path="coOptionPantsTuxedoInfo.tpPisPktDf" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpPisPktDfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-2" id="tp_pisPktDf_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">Vカット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_vCut_id" path="coOptionPantsTuxedoInfo.tpVCut" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpVCutMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="tp_vCut_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_hemUp"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tp_hemUp" path="coOptionPantsTuxedoInfo.tpHemUp" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPantsTuxedoInfo.tpHemUpMap }"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" id="tp_hemUp_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group"  id="tp_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tp_doubleWide" path="coOptionPantsTuxedoInfo.tpDoubleWide" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPantsTuxedoInfo.tpDoubleWideMap }"/>
                                </form:select>
                            </div>
                              <div class="col-12 col-md-6" id="tp_doubleWide_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_stitch_id" path="coOptionPantsTuxedoInfo.tpStitch" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpStitchMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="tp_stitch_Msg" align="right"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_bhColor_id" path="coOptionPantsTuxedoInfo.tpBhColor" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorMap }"/>
                                </div>
                                <div id="tp_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                	<form:select id="tp_bhColorPlaceAll" path="coOptionPantsTuxedoInfo.tpBhColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tp_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tp_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="tpBhColorPlaceMap" items="${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="tp_bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="tp_bhColorPlace_${row.count}" name="coOptionPantsTuxedoInfo.tpBhColorPlace${row.count}" value="${tpBhColorPlaceMap.key }" class="form-check-input">${tpBhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="tp_bhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="tpBhColorsMap" items="${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="tp_bhColor" class="form-check-label ">
                                			    <input type="radio" id="tp_bhColor_${tpBhColorsMap.key}" name="coOptionPantsTuxedoInfo.tpBhColor${row.count}" value="${tpBhColorsMap.key}" class="form-check-input">${tpBhColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="tp_bhColor_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <label for="tp_byColor_no" class="form-check-label ">
                                        <form:radiobuttons id="tp_byColor_id" path="coOptionPantsTuxedoInfo.tpByColor" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpByColorMap }"/>
                                	</label>　
                                </div>
                                <div id="tp_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                	<form:select id="tp_byColorPlaceAll" path="coOptionPantsTuxedoInfo.tpByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tp_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tp_byColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="tpByColorPlaceMap" items="${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="tp_byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="tp_byColorPlace_${row.count}" name="coOptionPantsTuxedoInfo.tpByColorPlace${row.count}" value="${tpByColorPlaceMap.key }" class="form-check-input">${tpByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="tp_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="tpByColorsMap" items="${orderCoForm.coOptionPantsTuxedoInfo.tpByColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="tp_byColorPlace" class="form-check-label ">
                                			    <input type="radio" id="tp_byColor_${tpByColorsMap.key}" name="coOptionPantsTuxedoInfo.tpByColor${row.count}" value="${tpByColorsMap.key}" class="form-check-input">${tpByColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="tp_byColor_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp_button"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tp_btnMate" class="form-control-sm form-control" path="coOptionPantsTuxedoInfo.tpButton">
                                	<form:options items="${orderCoForm.coOptionPantsTuxedoInfo.tpButtonMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="coOptionPantsTuxedoInfo.tpBtnMateStkNo" id="tp_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                             <div class="col-12 col-md-2" id="tp_btnMate_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_suspenderBtn_id" path="coOptionPantsTuxedoInfo.tpSuspenderBtn" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpSuspenderBtnMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="tp_suspenderBtn_Msg" align="right">
                            </div>
                        </div>                       
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_eight_id" path="coOptionPantsTuxedoInfo.tpEight" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpEightMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="tp_eight_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
                            <div class="col-12 col-md-6">
                             	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_thick_id" path="coOptionPantsTuxedoInfo.tpThick" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpThickMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right">
                            	<output id="tp_thick_Msg"></output>
                            </div>
                        </div> 
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_shapeMemory_id" path="coOptionPantsTuxedoInfo.tpShapeMemory" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpShapeMemoryMap }"/>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="tp_shapeMemory_Msg" align="right">
                            </div>
                        </div> 
                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">側章</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_sideStripe_id" path="coOptionPantsTuxedoInfo.tpSideStripe" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpSideStripeMap }"/>
                                </div>
                            </div>
                              <div class="col-12 col-md-3" id="tp_sideStripe_Msg" align="right">
                            </div>
                        </div>
                        <div id="tp_sideStripe_yes_area">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">側章幅</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp_sideStripeWidth_id" path="coOptionPantsTuxedoInfo.tpSideStripeWidth" class="form-check-input" items="${orderCoForm.coOptionPantsTuxedoInfo.tpSideStripeWidthMap }"/>
                                </div>
                            </div>
                              <div class="col-12 col-md-3" id="tp_sideStripeWidth_Msg" align="right">
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
                            	<form:select id="wp_pantsModel" path="coOptionPantsWashableInfo.wpPantsModel" class="form-control-sm form-control">
									<form:options items="${orderCoForm.coOptionPantsWashableInfo.wpPantsModelMap}"/>
								</form:select>
                            </div>             
                            <div class="col-12 col-md-9 offset-md-3" id="wp_pantsModelMsg"   style="margin-top:8px"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_pantsModelCheck"  style="display:none"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                            	<form:select id="wp_tack" path="coOptionPantsWashableInfo.wpTack" class="form-control-sm form-control">
									<form:options items="${orderCoForm.coOptionPantsWashableInfo.wpTackMap}"/>
								</form:select>
                            </div>
                           <div class="col-12 col-md-6" id="wp_tack_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_kneeBack"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_kneeBack_id" path="coOptionPantsWashableInfo.wpKneeBack" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpKneeBackMap}"/>
								</div>
                            </div>
                             <div class="col-12 col-md-3" id="wp_kneeBack_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group" id="wp_kneeBackMate_div">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_kneeBackMate_id" path="coOptionPantsWashableInfo.wpKneeBackMate" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpKneeBackMateMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" id="wp_kneeBackMate_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント仕様</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_frontSpec"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_frontSpec_id" path="coOptionPantsWashableInfo.wpFrontSpec" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpFrontSpecMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" id="wp_frontSpec_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_pancherina_id" path="coOptionPantsWashableInfo.wpPancherina" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpPancherinaMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" id="wp_pancherina_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_adjuster_id" path="coOptionPantsWashableInfo.wpAdjuster" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpAdjusterMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" id="wp_adjuster_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベルトループ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_beltLoop"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_beltLoop_id" path="coOptionPantsWashableInfo.wpBeltLoop" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopMap}"/>
								</div>
                                <div class="offset-md-1" id="wp_beltLoopPlace">
                                    <div>
                                        <div class="form-check-inline form-check">
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp_beltLoopPlace">全選択</button>&nbsp;
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp_beltLoopPlace">全解除</button>
                                        </div>
                                    </div>
                                   <%--  <div class="form-check-inline form-check">
										<form:checkboxes id="wp_beltLoopPlace_id" path="coOptionPantsWashableInfo.wpBeltLoopPlace" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlaceMap}"/>
									</div> --%>
									 <c:forEach var="wpBeltLoopPlaceMap" items="${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check" id="wp_beltLoopPlace_id1${row.count}">
                                		<input type="checkbox" id="wp_beltLoopPlace_id${row.count}" name="coOptionPantsWashableInfo.wpBeltLoopPlace${row.count}" value="${wpBeltLoopPlaceMap.key}" class="form-check-input">${wpBeltLoopPlaceMap.value}
                                	</div>
                                </c:forEach>
									
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="wp_beltLoop_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_pinLoop_id" path="coOptionPantsWashableInfo.wpPinLoop" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpPinLoopMap}"/>
								</div>
                            </div>
                           <div class="col-12 col-md-3" id="wp_pinLoop_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_sidePkt_id" path="coOptionPantsWashableInfo.wpSidePkt" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpSidePktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" id="wp_sidePkt_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_sinobiPkt_id" path="coOptionPantsWashableInfo.wpSinobiPkt" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpSinobiPktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" id="wp_sinobiPkt_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コインポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_coinPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp_coinPkt" path="coOptionPantsWashableInfo.wpCoinPkt" class="form-control-sm form-control">
									<form:options items="${orderCoForm.coOptionPantsWashableInfo.wpCoinPktMap}"/>
								</form:select>
                            </div>
                           <div class="col-12 col-md-6" id="wp_coinPkt_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_flapCoinPkt_id" path="coOptionPantsWashableInfo.wpFlapCoinPkt" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpFlapCoinPktMap}"/>
								</div>
                            </div>
                             <div class="col-12 col-md-3" id="wp_flapCoinPkt_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_pisPktUf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_pisPktUf_id" path="coOptionPantsWashableInfo.wpPisPktUf" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpPisPktUfMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" id="wp_pisPktUf_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_pisPktDf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_pisPktDf_id" path="coOptionPantsWashableInfo.wpPisPktDf" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpPisPktDfMap}"/>
								</div>
                            </div>
                           <div class="col-12 col-md-3" id="wp_pisPktDf_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">Vカット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_vCut_id" path="coOptionPantsWashableInfo.wpVCut" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpVCutMap}"/>
								</div>
                            </div>
                             <div class="col-12 col-md-3" id="wp_vCut_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_hemUp"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp_hemUp" path="coOptionPantsWashableInfo.wpHemUp" class="form-control-sm form-control">
									<form:options items="${orderCoForm.coOptionPantsWashableInfo.wpHemUpMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-6" id="wp_hemUp_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group"  id="wp_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                            	<form:select id="wp_doubleWide" path="coOptionPantsWashableInfo.wpDoubleWide" class="form-control-sm form-control">
									<form:options items="${orderCoForm.coOptionPantsWashableInfo.wpDoubleWideMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-6" id="wp_doubleWide_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_stitch_id" path="coOptionPantsWashableInfo.wpStitch" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpStitchMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" id="wp_stitch_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_stitchModify_id" path="coOptionPantsWashableInfo.wpStitchModify" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyMap}"/>
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
									<form:checkboxes id="wp_stitchModifyPlace_id" path="coOptionPantsWashableInfo.wpStitchModifyPlace" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlaceMap}"/>
								</div> --%>
								<c:forEach var="wpStitchModifyPlaceMap" items="${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="wp_stitchModifyPlace_id${row.count}" name="coOptionPantsWashableInfo.wpStitchModifyPlace${row.count}" value="${wpStitchModifyPlaceMap.key}" class="form-check-input">${wpStitchModifyPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                                </div></div>
                                 <div class="col-12 col-md-3" id="wp_stitchModify_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ダブルステッチ変更</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_dStitch_id" path="coOptionPantsWashableInfo.wpDStitch" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpDStitchMap}"/>
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
									<form:checkboxes id="wp_dStitchPlace_id" path="coOptionPantsWashableInfo.wpDStitchPlace" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlaceMap}"/>
								</div> --%>
								<c:forEach var="wpDStitchPlaceMap" items="${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="wp_dStitchPlace_id${row.count}" name="coOptionPantsWashableInfo.wpDStitchPlace${row.count}" value="${wpDStitchPlaceMap.key}" class="form-check-input">${wpDStitchPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="wp_dStitch_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_amfColor_id" path="coOptionPantsWashableInfo.wpAmfColor" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpAmfColorMap}"/>
								</div>
                                <div id="wp_amfColor_div" style="display:none;">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
	                                <form:select id="wp_amfColorPlaceAll" path="coOptionPantsWashableInfo.wpAmfColorPlaceAll" class="form-control-sm form-control">
										<form:options items="${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlaceAllMap}"/>
									</form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp_amfColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp_amfColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wpAmfColorPlaceMap" items="${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wp_amfColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wp_amfColorPlace_${row.count}" name="coOptionPantsWashableInfo.wpAmfColorPlace${row.count}" value="${wpAmfColorPlaceMap.key }" class="form-check-input">${wpAmfColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="wp_amfColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wpAmfColorsMap" items="${orderCoForm.coOptionPantsWashableInfo.wpAmfColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wp_amfColor" class="form-check-label ">
                                			    <input type="radio" id="wp_amfColor_${wpAmfColorsMap.key}" name="coOptionPantsWashableInfo.wpAmfColor${row.count}" value="${wpAmfColorsMap.key}" class="form-check-input">${wpAmfColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="wp_amfColor_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_bhColor_id" path="coOptionPantsWashableInfo.wpBhColor" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpBhColorMap}"/>
								</div>
                                <div id="wp_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="wp_bhColorPlaceAll" path="coOptionPantsWashableInfo.wpBhColorPlaceAll" class="form-control-sm form-control">
										<form:options items="${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlaceAllMap}"/>
									</form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wpBhColorPlaceMap" items="${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wp_bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wp_bhColorPlace_${row.count}" name="coOptionPantsWashableInfo.wpBhColorPlace${row.count}" value="${wpBhColorPlaceMap.key }" class="form-check-input">${wpBhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="wp_bhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wpBhColorsMap" items="${orderCoForm.coOptionPantsWashableInfo.wpBhColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wp_bhColor" class="form-check-label ">
                                			    <input type="radio" id="wp_bhColor_${wpBhColorsMap.key}" name="coOptionPantsWashableInfo.wpBhColor${row.count}" value="${wpBhColorsMap.key}" class="form-check-input">${wpBhColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                             <div class="col-12 col-md-3" id="wp_bhColor_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <label for="wp_byColor_no" class="form-check-label ">
                                        <form:radiobuttons id="wp_byColor_id" path="coOptionPantsWashableInfo.wpByColor" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpByColorMap }"/>
                                	</label>　
                                </div>
                                <div id="wp_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                	<form:select id="wp_byColorPlaceAll" path="coOptionPantsWashableInfo.wpByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderCoForm.coOptionPantsWashableInfo.wpByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp_byColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wpByColorPlaceMap" items="${orderCoForm.coOptionPantsWashableInfo.wpByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wp_byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wp_byColorPlace_${row.count}" name="coOptionPantsWashableInfo.wpByColorPlace${row.count}" value="${wpByColorPlaceMap.key }" class="form-check-input">${wpByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="wp_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wpByColorsMap" items="${orderCoForm.coOptionPantsWashableInfo.wpByColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wp_byColorPlace" class="form-check-label ">
                                			    <input type="radio" id="wp_byColor_${wpByColorsMap.key}" name="coOptionPantsWashableInfo.wpByColor${row.count}" value="${wpByColorsMap.key}" class="form-check-input">${wpByColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" id="wp_byColor_Msg" align="right">
                            </div>
                        </div>          
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp_button"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp_btnMate" path="coOptionPantsWashableInfo.wpButton" class="form-control-sm form-control">
									<form:options items="${orderCoForm.coOptionPantsWashableInfo.wpButtonMap}"/>
								</form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="coOptionPantsWashableInfo.wpBtnMateStkNo" id="wp_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                           <!--  <div class="col col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="wp_sameJacketBtn">JKと同じ</button>
                            </div> -->
                            <div class="col-12 col-md-2" id="wp_btnMate_Msg" align="right">
                            </div> 
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_suspenderBtn_id" path="coOptionPantsWashableInfo.wpSuspenderBtn" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpSuspenderBtnMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" id="wp_suspenderBtn_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_eight_id" path="coOptionPantsWashableInfo.wpEight" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpEightMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" id="wp_eight_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_thick_id" path="coOptionPantsWashableInfo.wpThick" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpThickMap}"/>
								</div>
                            </div>
                             <div class="col-12 col-md-3" id="wp_thick_Msg" align="right">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp_shapeMemory_id" path="coOptionPantsWashableInfo.wpShapeMemory" class="form-check-input" items="${orderCoForm.coOptionPantsWashableInfo.wpShapeMemoryMap}"/>
								</div>
                            </div>
                             <div class="col-12 col-md-3" id="wp_shapeMemory_Msg" align="right">
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
            </div>
            
           <!--  <input type="hidden" id="pantsFlag" name="pantsFlag" value="0"/> -->
            <input type="hidden" id="pantsItemFlag" name="pantsItemFlag" value="0"/>
            <input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="${orderCoForm.jacketItemFlag }"/>
			<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="${orderCoForm.giletItemFlag }"/>
			<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="${orderCoForm.shirtItemFlag }"/>
			<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="${orderCoForm.coatItemFlag }"/>
			<input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="${orderCoForm.pants2ItemFlag }"/>
           <%--  <input type="hidden" id="pantsAdFlag" name="pantsAdFlag" value="${orderCoForm.pantsAdFlag }" />     
            <input type="hidden" id="jacketAdFlag" name="jacketAdFlag" value="${orderCoForm.jacketAdFlag }" />
            <input type="hidden" id="coatAdFlag" name="coatAdFlag" value="${orderCoForm.coatAdFlag }" />
            <input type="hidden" id="giletAdFlag" name="giletAdFlag" value="${orderCoForm.giletAdFlag }" />
            <input type="hidden" id="pants2AdFlag" name="pants2AdFlag" value="${orderCoForm.pants2AdFlag }" />
            <input type="hidden" id="shirtAdFlag" name="shirtAdFlag" value="${orderCoForm.shirtAdFlag }" /> --%>
            <input type="hidden" id="ojBtnMatePtFlag" name="ojBtnMatePtFlag" value="${orderCoForm.ojBtnMatePtFlag }" />
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
<c:if test="${orderCoForm.productCategory == '9000101'}">
	<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants1.standard.js"></script>
</c:if>
<c:if test="${orderCoForm.productCategory == '9000102'}">
	<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants1.tuxedo.js"></script>
</c:if>
<c:if test="${orderCoForm.productCategory == '9000103'}">
	<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants1.washable.js"></script>
</c:if>

<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";
var pantsItemFlag="${orderCoForm.pantsItemFlag}";
var orderFlag = "${orderCoForm.orderFlag}";
var ojBtnMatePtFlag = "${orderCoForm.ojBtnMatePtFlag}";
var ojBtnMate="${orderCoForm.coOptionJacketStandardInfo.ojBtnMate}";
var tjBtnMate="${orderCoForm.coOptionJacketTuxedoInfo.tjBtnMate}";
var wjBtnMate="${orderCoForm.coOptionJacketWashableInfo.wjBtnMate}";
var ojBtnMateStkNo="${orderCoForm.coOptionJacketStandardInfo.ojBtnMateStkNo}";
var tjBtnMateStkNo="${orderCoForm.coOptionJacketTuxedoInfo.tjBtnMateStkNo}";
var wjBtnMateStkNo="${orderCoForm.coOptionJacketWashableInfo.wjBtnMateStkNo}";
var jkBtnMateStkNo="";
var ptBtnMateStkNo="";
var wpButtonMap="${orderCoForm.coOptionPantsWashableInfo.wpButtonMap}";
var opButtonMap="${orderCoForm.coOptionPantsStandardInfo.opButtonMap }";
var tpButtonMap="${orderCoForm.coOptionPantsTuxedoInfo.tpButtonMap }"
var productCategory="${orderCoForm.productCategory}";
jQuery(function() {
	var orderFlag = "${orderCoForm.orderFlag}";
	if("orderCo"==orderFlag){
		if(pantsAdFlag=="1"){
		}else{
			pantsAdFlag="0";	
		}
	}
	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });
	
	
	initCommon();
	//--------------------------------------------
	// タブメニュー
	//--------------------------------------------
	initTabMenu();
	//--------------------------------------------
	// 商品タブ
	//--------------------------------------------
	
	if(productCategory == "9000101"){
		initOptionPants1Standard();
	}else if(productCategory == "9000102"){
		initOptionPants1Tuxedo();
	}else if(productCategory == "9000103"){
		initOptionPants1Washable();
		jQuery("#wp_pantsModel option[value='BS03']").remove();
		jQuery("#wp_pantsModel option[value='RS01']").remove();
		jQuery("#wp_pantsModel option[value='JW21']").remove();
		jQuery("#wp_pantsModel option[value='AY01']").remove();
	}
	
	changeViewArea();
	setPantsModelDisable(productCategory);
	optionPants1ChangeModel(productCategory);
	mateInit();
	if(productCategory == "9000101"){

		opSession();

		var item = jQuery("#item").val();
		if(item == "01"){
			var jacketStitch = "${orderCoForm.coOptionJacketStandardInfo.ojStitch}";
			jQuery('input[name="coOptionPantsStandardInfo.opStitch"]').val([jacketStitch]);
			jQuery('input[name="coOptionPantsStandardInfo.opStitch"]:checked').change();
		}
		
		if(ojBtnMatePtFlag=="1"){
			 jQuery('#op_btnMateStkNo').val("${orderCoForm.coOptionPantsStandardInfo.opBtnMateStkNo}");	
			 jQuery("#ojBtnMatePtFlag").val("0");
		}
				
	}else if(productCategory == "9000102"){
		
		tpSession();

		var item = jQuery("#item").val();
		if(item == "01"){
			var jacketGlossFablic = "${orderCoForm.coOptionJacketTuxedoInfo.tjGlossFablic}";
			jQuery("#tp_GlossFablic").val(jacketGlossFablic);
			jQuery("#tp_GlossFablic").change();

			var jacketStitch = "${orderCoForm.coOptionJacketTuxedoInfo.tjStitch}";
			jQuery('input[name="coOptionPantsTuxedoInfo.tpStitch"]').val([jacketStitch]);
			jQuery('input[name="coOptionPantsTuxedoInfo.tpStitch"]:checked').change();
		}
			
	    if(ojBtnMatePtFlag=="1"){
	    	jQuery("#tp_btnMateStkNo").val("${orderCoForm.coOptionPantsTuxedoInfo.tpBtnMateStkNo}");
	    	jQuery("#ojBtnMatePtFlag").val("0");
		}
	}else if(productCategory == "9000103"){
		
	    wpSession();

	    var item = jQuery("#item").val();
	    if(item == "01"){
			var jacketStitch = "${orderCoForm.coOptionJacketWashableInfo.wjStitch}";
			jQuery('input[name="coOptionPantsWashableInfo.wpStitch"]').val([jacketStitch]);
			jQuery('input[name="coOptionPantsWashableInfo.wpStitch"]:checked').change();
		}

	    if(ojBtnMatePtFlag=="1"){
	    	jQuery("#wp_btnMateStkNo").val("${orderCoForm.coOptionPantsWashableInfo.wpBtnMateStkNo}");
	    	jQuery("#ojBtnMatePtFlag").val("0");
		}
	}
	getPrice();
	showPrice();
	if((orderFlag == "orderLink" || orderFlag == "orderDivert") && pantsTwiceflag == '0'){
		if(productCategory == "9000101"){
			
			var opBeltLoopPlace = "${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace}";
			if(isNotEmpty(opBeltLoopPlace)){
				opBeltLoopPlace = opBeltLoopPlace.split("/");
				for(var i=0;i<opBeltLoopPlace.length;i++){
					if(opBeltLoopPlace[i] == "0000801"){
						jQuery("#op_beltLoopPlace_id1").prop("checked",true);
					}else if(opBeltLoopPlace[i] == "0000802"){
						jQuery("#op_beltLoopPlace_id2").prop("checked",true);
					}else if(opBeltLoopPlace[i] == "0000803"){
						jQuery("#op_beltLoopPlace_id3").prop("checked",true);
					}else if(opBeltLoopPlace[i] == "0000804"){
						jQuery("#op_beltLoopPlace_id4").prop("checked",true);
					}else if(opBeltLoopPlace[i] == "0000805"){
						jQuery("#op_beltLoopPlace_id5").prop("checked",true);
					}else if(opBeltLoopPlace[i] == "0000806"){
						jQuery("#op_beltLoopPlace_id6").prop("checked",true);
					}else if(opBeltLoopPlace[i] == "0000807"){
						jQuery("#op_beltLoopPlace_id7").prop("checked",true);
					}
				}
			}
			// ステッチ箇所変更
			var opStitchModify = "${orderCoForm.coOptionPantsStandardInfo.opStitchModify}";
			var opStitchModifyPlace = "${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace}";
			if(isNotEmpty(opStitchModifyPlace)){
				opStitchModifyPlace = opStitchModifyPlace.split("/");
				for(var i=0;i<opStitchModifyPlace.length;i++){
					if(opStitchModifyPlace[i] == "0002101"){
						jQuery("#op_stitchModifyPlace_id1").prop("checked",true);
					}else if(opStitchModifyPlace[i] == "0002102"){
						jQuery("#op_stitchModifyPlace_id2").prop("checked",true);
					}else if(opStitchModifyPlace[i] == "0002103"){
						jQuery("#op_stitchModifyPlace_id3").prop("checked",true);
					}else if(opStitchModifyPlace[i] == "0002104"){
						jQuery("#op_stitchModifyPlace_id4").prop("checked",true);
					}
				}
			}
			if(opStitchModify == '0002002'){
				jQuery('input[id^="op_stitchModifyPlace_id"]:checked').change();
			}
			
			//ダブルステッチ
			ctrlOpDStitchPlace();
			//AMF色指定
			ctrlOpAmfColor();

			var opDStitchPlace = "${orderCoForm.coOptionPantsStandardInfo.opDStitchPlace}";
			if(isNotEmpty(opDStitchPlace)){
				opDStitchPlace = opDStitchPlace.split("/");
				for(var i=0;i<opDStitchPlace.length;i++){
					if(opDStitchPlace[i] == "0002301"){
						jQuery("#op_dStitchPlace_id1").prop("checked",true);
					}else if(opDStitchPlace[i] == "0002302"){
						jQuery("#op_dStitchPlace_id2").prop("checked",true);
					}else if(opDStitchPlace[i] == "0002304"){
						jQuery("#op_dStitchPlace_id3").prop("checked",true);
					}
				}
			}

			var opAmfColorPlace = "${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace}";
			var opAmfAllColor = "${orderCoForm.coOptionPantsStandardInfo.opAmfAllColor}";
			if(isNotEmpty(opAmfColorPlace)){
				opAmfColorPlace = opAmfColorPlace.split("/");
				opAmfAllColor = opAmfAllColor.split("/");
				for(var i=0;i<opAmfColorPlace.length;i++){
					if(opAmfColorPlace[i] == "0002601"){
						jQuery("#op_amfColorPlace_1").prop("checked",true);
					}else if(opAmfColorPlace[i] == "0002602"){
						jQuery("#op_amfColorPlace_2").prop("checked",true);
					}else if(opAmfColorPlace[i] == "0002603"){
						jQuery("#op_amfColorPlace_3").prop("checked",true);
					}else if(opAmfColorPlace[i] == "0002604"){
						jQuery("#op_amfColorPlace_4").prop("checked",true);
					}
					for(var j=0;j<opAmfAllColor.length;j++){
						if(opAmfColorPlace[j] == "0002601"){
							jQuery(":radio[name='coOptionPantsStandardInfo.opAmfColor1'][value='" + opAmfAllColor[j] + "']").prop("checked", true);
						}else if(opAmfColorPlace[j] == "0002602"){
							jQuery(":radio[name='coOptionPantsStandardInfo.opAmfColor2'][value='" + opAmfAllColor[j] + "']").prop("checked", true);
						}else if(opAmfColorPlace[j] == "0002603"){
							jQuery(":radio[name='coOptionPantsStandardInfo.opAmfColor3'][value='" + opAmfAllColor[j] + "']").prop("checked", true);
						}else if(opAmfColorPlace[j] == "0002604"){
							jQuery(":radio[name='coOptionPantsStandardInfo.opAmfColor4'][value='" + opAmfAllColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="op_amfColorPlace_"]:checked').change();
			}


			var opBhColorPlace = "${orderCoForm.coOptionPantsStandardInfo.opBhColorPlace}";
			var opBhAllColor = "${orderCoForm.coOptionPantsStandardInfo.opBhAllColor}";
			if(isNotEmpty(opBhColorPlace)){
				opBhColorPlace = opBhColorPlace.split("/");
				opBhAllColor = opBhAllColor.split("/");
				for(var i=0;i<opBhColorPlace.length;i++){
					if(opBhColorPlace[i] == "0002901"){
						jQuery("#op_bhColorPlace_1").prop("checked",true);
					}else if(opBhColorPlace[i] == "0002902"){
						jQuery("#op_bhColorPlace_2").prop("checked",true);
					}else if(opBhColorPlace[i] == "0002903"){
						jQuery("#op_bhColorPlace_3").prop("checked",true);
					}else if(opBhColorPlace[i] == "0002904"){
						jQuery("#op_bhColorPlace_4").prop("checked",true);
					}
					for(var j=0;j<opBhAllColor.length;j++){
						if(opBhColorPlace[j] == "0002901"){
							jQuery(":radio[name='coOptionPantsStandardInfo.opBhColor1'][value='" + opBhAllColor[j] + "']").prop("checked", true);
						}else if(opBhColorPlace[j] == "0002902"){
							jQuery(":radio[name='coOptionPantsStandardInfo.opBhColor2'][value='" + opBhAllColor[j] + "']").prop("checked", true);
						}else if(opBhColorPlace[j] == "0002903"){
							jQuery(":radio[name='coOptionPantsStandardInfo.opBhColor3'][value='" + opBhAllColor[j] + "']").prop("checked", true);
						}else if(opBhColorPlace[j] == "0002904"){
							jQuery(":radio[name='coOptionPantsStandardInfo.opBhColor4'][value='" + opBhAllColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="op_bhColorPlace_"]:checked').change();
			} 
			 
			var opByColorPlace = "${orderCoForm.coOptionPantsStandardInfo.opByColorPlace}";
			var opByAllColor = "${orderCoForm.coOptionPantsStandardInfo.opByAllColor}";
			if(isNotEmpty(opByColorPlace)){
				opByColorPlace = opByColorPlace.split("/");
				opByAllColor = opByAllColor.split("/");
				for(var i=0;i<opByColorPlace.length;i++){
					if(opByColorPlace[i] == "0003201"){
						jQuery("#op_byColorPlace_1").prop("checked",true);
					}else if(opByColorPlace[i] == "0003202"){
						jQuery("#op_byColorPlace_2").prop("checked",true);
					}else if(opByColorPlace[i] == "0003203"){
						jQuery("#op_byColorPlace_3").prop("checked",true);
					}else if(opByColorPlace[i] == "0003204"){
						jQuery("#op_byColorPlace_4").prop("checked",true);
					}
					for(var j=0;j<opByAllColor.length;j++){
						if(opByColorPlace[j] == "0003201"){
							jQuery(":radio[name='coOptionPantsStandardInfo.opByColor1'][value='" + opByAllColor[j] + "']").prop("checked", true);
						}else if(opByColorPlace[j] == "0003202"){
							jQuery(":radio[name='coOptionPantsStandardInfo.opByColor2'][value='" + opByAllColor[j] + "']").prop("checked", true);
						}else if(opByColorPlace[j] == "0003203"){
							jQuery(":radio[name='coOptionPantsStandardInfo.opByColor3'][value='" + opByAllColor[j] + "']").prop("checked", true);
						}else if(opByColorPlace[j] == "0003204"){
							jQuery(":radio[name='coOptionPantsStandardInfo.opByColor4'][value='" + opByAllColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="op_byColorPlace_"]:checked').change();
			}  

		}else if(productCategory == "9000102"){
			var tpBeltLoopPlace = "${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace}";
			if(isNotEmpty(tpBeltLoopPlace)){
				tpBeltLoopPlace = tpBeltLoopPlace.split("/");
				for(var i=0;i<tpBeltLoopPlace.length;i++){
					if(tpBeltLoopPlace[i] == "0000801"){
						jQuery("#tp_beltLoopPlace_id1").prop("checked",true);
					}else if(tpBeltLoopPlace[i] == "0000802"){
						jQuery("#tp_beltLoopPlace_id2").prop("checked",true);
					}else if(tpBeltLoopPlace[i] == "0000803"){
						jQuery("#tp_beltLoopPlace_id3").prop("checked",true);
					}else if(tpBeltLoopPlace[i] == "0000804"){
						jQuery("#tp_beltLoopPlace_id4").prop("checked",true);
					}else if(tpBeltLoopPlace[i] == "0000805"){
						jQuery("#tp_beltLoopPlace_id5").prop("checked",true);
					}else if(tpBeltLoopPlace[i] == "0000806"){
						jQuery("#tp_beltLoopPlace_id6").prop("checked",true);
					}else if(tpBeltLoopPlace[i] == "0000807"){
						jQuery("#tp_beltLoopPlace_id7").prop("checked",true);
					}
				}
			}
			var tpBhColorPlace = "${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlace}";
			var tpBhAllColor = "${orderCoForm.coOptionPantsTuxedoInfo.tpBhAllColor}";
			if(isNotEmpty(tpBhColorPlace)){
				tpBhColorPlace = tpBhColorPlace.split("/");
				tpBhAllColor = tpBhAllColor.split("/");
				for(var i=0;i<tpBhColorPlace.length;i++){
					if(tpBhColorPlace[i] == "0002901"){
						jQuery("#tp_bhColorPlace_1").prop("checked",true);
					}else if(tpBhColorPlace[i] == "0002902"){
						jQuery("#tp_bhColorPlace_2").prop("checked",true);
					}else if(tpBhColorPlace[i] == "0002903"){
						jQuery("#tp_bhColorPlace_3").prop("checked",true);
					}else if(tpBhColorPlace[i] == "0002904"){
						jQuery("#tp_bhColorPlace_4").prop("checked",true);
					}
					for(var j=0;j<tpBhAllColor.length;j++){
						if(tpBhColorPlace[j] == "0002901"){
							jQuery(":radio[name='coOptionPantsStandardInfo.tpBhColor1'][value='" + tpBhAllColor[j] + "']").prop("checked", true);
						}else if(tpBhColorPlace[j] == "0002902"){
							jQuery(":radio[name='coOptionPantsStandardInfo.tpBhColor2'][value='" + tpBhAllColor[j] + "']").prop("checked", true);
						}else if(tpBhColorPlace[j] == "0002903"){
							jQuery(":radio[name='coOptionPantsStandardInfo.tpBhColor3'][value='" + tpBhAllColor[j] + "']").prop("checked", true);
						}else if(tpBhColorPlace[j] == "0002904"){
							jQuery(":radio[name='coOptionPantsStandardInfo.tpBhColor4'][value='" + tpBhAllColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="tp_bhColorPlace_"]:checked').change();
			} 

			var tpByColorPlace = "${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlace}";
			var tpByAllColor = "${orderCoForm.coOptionPantsTuxedoInfo.tpByAllColor}";
			if(isNotEmpty(tpByColorPlace)){
				tpByColorPlace = tpByColorPlace.split("/");
				tpByAllColor = tpByAllColor.split("/");
				for(var i=0;i<tpByColorPlace.length;i++){
					if(tpByColorPlace[i] == "0003201"){
						jQuery("#tp_byColorPlace_1").prop("checked",true);
					}else if(tpByColorPlace[i] == "0003202"){
						jQuery("#tp_byColorPlace_2").prop("checked",true);
					}else if(tpByColorPlace[i] == "0003203"){
						jQuery("#tp_byColorPlace_3").prop("checked",true);
					}else if(tpByColorPlace[i] == "0003204"){
						jQuery("#tp_byColorPlace_4").prop("checked",true);
					}
					for(var j=0;j<tpByAllColor.length;j++){
						if(tpByColorPlace[j] == "0003201"){
							jQuery(":radio[name='coOptionPantsTuxedoInfo.tpByColor1'][value='" + tpByAllColor[j] + "']").prop("checked", true);
						}else if(tpByColorPlace[j] == "0003202"){
							jQuery(":radio[name='coOptionPantsTuxedoInfo.tpByColor2'][value='" + tpByAllColor[j] + "']").prop("checked", true);
						}else if(tpByColorPlace[j] == "0003203"){
							jQuery(":radio[name='coOptionPantsTuxedoInfo.tpByColor3'][value='" + tpByAllColor[j] + "']").prop("checked", true);
						}else if(tpByColorPlace[j] == "0003204"){
							jQuery(":radio[name='coOptionPantsTuxedoInfo.tpByColor4'][value='" + tpByAllColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="tp_byColorPlace_"]:checked').change();
			} 
        }else if(productCategory == "9000103"){

        	var wpBeltLoopPlace = "${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace}";
			if(isNotEmpty(wpBeltLoopPlace)){
				wpBeltLoopPlace = wpBeltLoopPlace.split("/");
				for(var i=0;i<wpBeltLoopPlace.length;i++){
					if(wpBeltLoopPlace[i] == "0000801"){
						jQuery("#wp_beltLoopPlace_id1").prop("checked",true);
					}else if(wpBeltLoopPlace[i] == "0000802"){
						jQuery("#wp_beltLoopPlace_id2").prop("checked",true);
					}else if(wpBeltLoopPlace[i] == "0000803"){
						jQuery("#wp_beltLoopPlace_id3").prop("checked",true);
					}else if(wpBeltLoopPlace[i] == "0000804"){
						jQuery("#wp_beltLoopPlace_id4").prop("checked",true);
					}else if(wpBeltLoopPlace[i] == "0000805"){
						jQuery("#wp_beltLoopPlace_id5").prop("checked",true);
					}else if(wpBeltLoopPlace[i] == "0000806"){
						jQuery("#wp_beltLoopPlace_id6").prop("checked",true);
					}else if(wpBeltLoopPlace[i] == "0000807"){
						jQuery("#wp_beltLoopPlace_id7").prop("checked",true);
					}
				}
			}

			var wpStitchModify = "${orderCoForm.coOptionPantsWashableInfo.wpStitchModify}";
			var wpStitchModifyPlace = "${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlace}";
			if(isNotEmpty(wpStitchModifyPlace)){
				wpStitchModifyPlace = wpStitchModifyPlace.split("/");
				for(var i=0;i<wpStitchModifyPlace.length;i++){
					if(wpStitchModifyPlace[i] == "0002101"){
						jQuery("#wp_stitchModifyPlace_id1").prop("checked",true);
					}else if(wpStitchModifyPlace[i] == "0002102"){
						jQuery("#wp_stitchModifyPlace_id2").prop("checked",true);
					}else if(wpStitchModifyPlace[i] == "0002103"){
						jQuery("#wp_stitchModifyPlace_id3").prop("checked",true);
					}else if(wpStitchModifyPlace[i] == "0002104"){
						jQuery("#wp_stitchModifyPlace_id4").prop("checked",true);
					}
				}
			}
			if(wpStitchModify == '0002002'){
				jQuery('input[id^="wp_stitchModifyPlace_id"]:checked').change();
			}
			
			ctrlWpDStitchPlace();
			ctrlWpAmfColor();

			var wpDStitchPlace = "${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlace}";
			if(isNotEmpty(wpDStitchPlace)){
				wpDStitchPlace = wpDStitchPlace.split("/");
				for(var i=0;i<wpDStitchPlace.length;i++){
					if(wpDStitchPlace[i] == "0002301"){
						jQuery("#wp_dStitchPlace_id1").prop("checked",true);
					}else if(wpDStitchPlace[i] == "0002302"){
						jQuery("#wp_dStitchPlace_id2").prop("checked",true);
					}else if(wpDStitchPlace[i] == "0002304"){
						jQuery("#wp_dStitchPlace_id3").prop("checked",true);
					}
				}
			}

			var wpAmfColorPlace = "${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlace}";
			var wpAmfAllColor = "${orderCoForm.coOptionPantsWashableInfo.wpAmfAllColor}";
			if(isNotEmpty(wpAmfColorPlace)&&isNotEmpty(wpAmfAllColor)){
				wpAmfColorPlace = wpAmfColorPlace.split("/");
				wpAmfAllColor = wpAmfAllColor.split("/");
				for(var i=0;i<wpAmfColorPlace.length;i++){
					if(wpAmfColorPlace[i] == "0002601"){
						jQuery("#wp_amfColorPlace_1").prop("checked",true);
					}else if(wpAmfColorPlace[i] == "0002602"){
						jQuery("#wp_amfColorPlace_2").prop("checked",true);
					}else if(wpAmfColorPlace[i] == "0002603"){
						jQuery("#wp_amfColorPlace_3").prop("checked",true);
					}else if(wpAmfColorPlace[i] == "0002604"){
						jQuery("#wp_amfColorPlace_4").prop("checked",true);
					}
					for(var j=0;j<wpAmfAllColor.length;j++){
						if(wpAmfColorPlace[j] == "0002601"){
							jQuery(":radio[name='coOptionPantsWashableInfo.wpAmfColor1'][value='" + wpAmfAllColor[j] + "']").prop("checked", true);
						}else if(wpAmfColorPlace[j] == "0002602"){
							jQuery(":radio[name='coOptionPantsWashableInfo.wpAmfColor2'][value='" + wpAmfAllColor[j] + "']").prop("checked", true);
						}else if(wpAmfColorPlace[j] == "0002603"){
							jQuery(":radio[name='coOptionPantsWashableInfo.wpAmfColor3'][value='" + wpAmfAllColor[j] + "']").prop("checked", true);
						}else if(wpAmfColorPlace[j] == "0002604"){
							jQuery(":radio[name='coOptionPantsWashableInfo.wpAmfColor4'][value='" + wpAmfAllColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="wp_amfColorPlace_"]:checked').change();
			}


			var wpBhColorPlace = "${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace}";
			var wpBhAllColor = "${orderCoForm.coOptionPantsWashableInfo.wpBhAllColor}";
			if(isNotEmpty(wpBhColorPlace)&&isNotEmpty(wpBhColorPlace)){
				wpBhColorPlace = wpBhColorPlace.split("/");
				wpBhAllColor = wpBhAllColor.split("/");
				for(var i=0;i<wpBhColorPlace.length;i++){
					if(wpBhColorPlace[i] == "0002901"){
						jQuery("#wp_bhColorPlace_1").prop("checked",true);
					}else if(wpBhColorPlace[i] == "0002902"){
						jQuery("#wp_bhColorPlace_2").prop("checked",true);
					}else if(wpBhColorPlace[i] == "0002903"){
						jQuery("#wp_bhColorPlace_3").prop("checked",true);
					}else if(wpBhColorPlace[i] == "0002904"){
						jQuery("#wp_bhColorPlace_4").prop("checked",true);
					}
					for(var j=0;j<wpBhAllColor.length;j++){
						if(wpBhColorPlace[j] == "0002901"){
							jQuery(":radio[name='coOptionPantsWashableInfo.wpBhColor1'][value='" + wpBhAllColor[j] + "']").prop("checked", true);
						}else if(wpBhColorPlace[j] == "0002902"){
							jQuery(":radio[name='coOptionPantsWashableInfo.wpBhColor2'][value='" + wpBhAllColor[j] + "']").prop("checked", true);
						}else if(wpBhColorPlace[j] == "0002903"){
							jQuery(":radio[name='coOptionPantsWashableInfo.wpBhColor3'][value='" + wpBhAllColor[j] + "']").prop("checked", true);
						}else if(wpBhColorPlace[j] == "0002904"){
							jQuery(":radio[name='coOptionPantsWashableInfo.wpBhColor4'][value='" + wpBhAllColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="wp_bhColorPlace_"]:checked').change();
			} 

			var wpByColorPlace = "${orderCoForm.coOptionPantsWashableInfo.wpByColorPlace}";
			var wpByAllColor = "${orderCoForm.coOptionPantsWashableInfo.wpByAllColor}";
			if(isNotEmpty(wpByColorPlace)&&isNotEmpty(wpByColorPlace)){
				wpByColorPlace = wpByColorPlace.split("/");
				wpByAllColor = wpByAllColor.split("/");
				for(var i=0;i<wpByColorPlace.length;i++){
					if(wpByColorPlace[i] == "0003201"){
						jQuery("#wp_byColorPlace_1").prop("checked",true);
					}else if(wpByColorPlace[i] == "0003202"){
						jQuery("#wp_byColorPlace_2").prop("checked",true);
					}else if(wpByColorPlace[i] == "0003203"){
						jQuery("#wp_byColorPlace_3").prop("checked",true);
					}else if(wpByColorPlace[i] == "0003204"){
						jQuery("#wp_byColorPlace_4").prop("checked",true);
					}
					for(var j=0;j<wpByAllColor.length;j++){
						if(wpByColorPlace[j] == "0003201"){
							jQuery(":radio[name='coOptionPantsWashableInfo.wpByColor1'][value='" + wpByAllColor[j] + "']").prop("checked", true);
						}else if(wpByColorPlace[j] == "0003202"){
							jQuery(":radio[name='coOptionPantsWashableInfo.wpByColor2'][value='" + wpByAllColor[j] + "']").prop("checked", true);
						}else if(wpByColorPlace[j] == "0003203"){
							jQuery(":radio[name='coOptionPantsWashableInfo.wpByColor3'][value='" + wpByAllColor[j] + "']").prop("checked", true);
						}else if(wpByColorPlace[j] == "0003204"){
							jQuery(":radio[name='coOptionPantsWashableInfo.wpByColor4'][value='" + wpByAllColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="wp_byColorPlace_"]:checked').change();
			}    
         }	
		pantsTwiceflag = '1';
	} 
	jQuery("#pantsItemFlag").val("1");
})	

function setPantsModelDisable(productCategory){
	var ptModel = null;
	if(productCategory == "9000101"){
		ptModel = document.getElementById("op_pantsModel");
	}else if(productCategory == "9000102"){
		ptModel = document.getElementById("tp_pantsModel");
	}else if(productCategory == "9000103"){
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
		if(category == "9000101"){
			initSuitStandard(itemCode,category);
		}
		else if(category == "9000102"){
			initSuitTuxedo(itemCode,category);
		}
		else if(category == "9000103"){
			initSuitWashable(itemCode,category);
		}
		
	}else if(item=="03"){
		subItemCode = "03";
		itemCode = item;
		
		if(category=="9000101"){
			initPtStandard(itemCode,subItemCode,category);
		}
		else if(category=="9000102"){
			initPtTuxedo(itemCode,subItemCode,category);
		}
		else if(category=="9000103"){
			initPtWashable(itemCode,subItemCode,category);
		}
		
		jQuery('input[name="productCategory"]').change(function(){
			category = jQuery('input[name="productCategory"]:checked').val();
			if(category == "9000101"){
				initPtStandard(itemCode,subItemCode,category);
			}
			else if(category == "9000102"){
				initPtTuxedo(itemCode,subItemCode,category);
			}
			else if(category == "9000103"){
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
		mateChecked = jQuery("#op_btnMate option:checked").val();
		mateSelect(itemCode,subItemCode,mateChecked,"00033","#op_btnMateStkNo",category,orderPattern);
		jQuery("#op_btnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			optionCode = "00033";
			mateChecked = jQuery("#"+idValue+" option:checked").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		})	
	}

	function initPtTuxedo(itemCode,subItemCode,category){
		mateChecked = jQuery("#tp_btnMate option:checked").val();
		mateSelect(itemCode,subItemCode,mateChecked,"00033","#tp_btnMateStkNo",category,orderPattern);
		jQuery("#tp_btnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			//optionCode = selectTuxedoIdList[idValue];
			optionCode = "00033";
			mateChecked = jQuery("#"+idValue+" option:checked").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		})	
	}

	function initPtWashable(itemCode,subItemCode,category){
		mateChecked = jQuery("#wp_btnMate option:checked").val();
		mateSelect(itemCode,subItemCode,mateChecked,"00033","#wp_btnMateStkNo",category,orderPattern);
		jQuery("#wp_btnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			//optionCode = selectWashableIdList[idValue];
			optionCode = "00033";
			mateChecked = jQuery("#"+idValue+" option:checked").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		})	
	}

	//素材によって　品番を設定
	function mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,type,orderPattern){
		var StkNoSelect = jQuery(StkNo);
		var url;
		if (type == '9000101'){
			url = "/orderCo/standardMateSelect";
		}else if(type == '9000102'){
			url = "/orderCo/tuxdoMateSelect";
		}else if(type == '9000103'){
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
					 StkNoSelect.append(jQuery('<option />').val("").text(""));
					 StkNoSelect.prop("disabled",true);
				 }else{
					 StkNoSelect.removeAttr("disabled");
					 for (var key in result) {
						 StkNoSelect.append(jQuery('<option />').val(key).text(result[key]));	
					 }
					 jQuery(StkNo).change();	
				 }
			 }
		});
	}
}
function showPrice(){
	var pantsModel = null;
	var category = jQuery('input[name="productCategory"]:checked').val();
	if(category == "9000101"){
		pantsModel = jQuery("#op_pantsModel");
	}else if(category == "9000102"){
		pantsModel = jQuery("#tp_pantsModel");
	}else if(category == "9000103"){
		pantsModel = jQuery("#wp_pantsModel");
	}
	if(isNotEmpty(pantsModel.val())){
		pantsModel.change();
	}
}

//--------------------------------------------
//金額フォーマット
//--------------------------------------------
function getPrice(){
	//PANTSの料金を表示
	var pantsModel = "";
	var priceUrl = "";
	jQuery("#op_pantsModel,#tp_pantsModel,#wp_pantsModel").change(function(){
		var category = jQuery('input[name="productCategory"]:checked').val();
		var item = jQuery('#item').val();
		if(category == "9000101"){
			if(item == '01'){
				jQuery('input[id^="op_stitch_id"]').removeAttr("disabled");
			}
		} else if(category == "9000102"){
			if(item == '01'){
				jQuery('#tp_GlossFablic').removeAttr("disabled");
				jQuery('input[id^="tp_stitch_id"]').removeAttr("disabled");
			}
		} else if(category == "9000103"){
			if(item == '01'){
				jQuery('input[id^="wp_stitch_id"]').removeAttr("disabled");
			}
		}

		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		
		if(category == "9000101"){
			if(item == '01'){
				jQuery('input[id^="op_stitch_id"]').prop("disabled",true);
			}
		} else if(category == "9000102"){
			if(item == '01'){
				jQuery("#tp_GlossFablic").prop("disabled",true);
				jQuery('input[id^="tp_stitch_id"]').prop("disabled",true);
			}
		} else if(category == "9000103"){
			if(item == '01'){
				jQuery('input[id^="wp_stitch_id"]').prop("disabled",true);
			}
		}
		
		var itemCode = jQuery("#item").val();
	    var subItemCode = "03";
	    var category = jQuery('input[name="productCategory"]:checked').val();
	    if(category == "9000101"){
	    	pantsModel = jQuery("#op_pantsModel option:selected").val();
	    	priceUrl = "getOrderPriceForPantsModel";
		}else if(category == "9000102"){
			pantsModel = jQuery("#tp_pantsModel option:selected").val();
			priceUrl = "getOrderPriceForPantsTuModel";
		}else if(category == "9000103"){
			pantsModel = jQuery("#wp_pantsModel option:selected").val();
			priceUrl = "getOrderPriceForPantsWPModel";
		}
		if(isEmpty(pantsModel)){
			return;
		}
	    var code = itemCode + subItemCode + pantsModel;
	    jQuery.ajax({
	    	type:"get",
		    url:contextPath + "/orderCo/" + priceUrl,
		    data:{"code":code},
		    async:false,
		    success:function(result){
		    		var allPriceMap = result.priceMap;
		         	for (var priceMapKey in allPriceMap) {
		            	if(jQuery("#"+priceMapKey+"_Msg").length>0){
		            	jQuery("#"+priceMapKey+"_Msg").html(allPriceMap[priceMapKey]);
		            	}else{
		              	var msgIdValueName = priceMapKey.replace(/_id/,"_Msg");
		              	jQuery("#"+msgIdValueName).html(allPriceMap[priceMapKey]);
		            	}
		         	}
					jQuery("#optionPriceId").val(result.optionPrice);
					jQuery("#optionPrice").html(formatMoney(result.optionPrice,0,""));
					getAllPrice(itemCode, result.optionPrice);
					allOptionPrice();
				}
			});
		});
	    
	var pantsModel = "";
	var priceUrl = "";
	//プルダウンの変更処理
	//項目：タック、コインポケット、裾上げ、ダブル幅、釦素材、釦素材品番
	jQuery("#op_tack,#op_coinPkt,#op_hemUp,#op_doubleWide,#op_btnMate,#op_btnMateStkNo,"+
			"#tp_tack,#tp_coinPkt,#tp_hemUp,#tp_GlossFablic,#tp_doubleWide,#tp_btnMate,#tp_btnMateStkNo,"+
			"#wp_tack,#wp_coinPkt,#wp_hemUp,#wp_doubleWide,#wp_btnMate,#wp_btnMateStkNo") 
	   .change(function(){
	   //jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
	   var category = jQuery('input[name="productCategory"]:checked').val();
	   var valueHemUpId = "";
	   if(category == "9000101"){
		   pantsModel = jQuery("#op_pantsModel option:selected").val();
	    	priceUrl = "getOrderPriceForPantsSProject";
	    	var hemUpId = this.id;
	    	valueHemUpId = jQuery('#op_hemUp').val();
	    	   if(hemUpId == 'op_hemUp'){
	 			jQuery('#op_doubleWide').change();
	 	    }
	   }else if(category == "9000102"){
		   pantsModel = jQuery("#tp_pantsModel option:selected").val();
			priceUrl = "getOrderPriceForPantsSTuProject";
			var hemUpId = this.id;
	    	valueHemUpId = jQuery('#tp_hemUp').val();
	    	   if(hemUpId == 'tp_hemUp'){
	 			jQuery('#tp_doubleWide').change();
	 	    }
	   }else if(category == "9000103"){
		   pantsModel = jQuery("#wp_pantsModel option:selected").val();
			priceUrl = "getOrderPriceForPantsSWPProject";
			var hemUpId = this.id;
	    	valueHemUpId = jQuery('#wp_hemUp').val();
	    	   if(hemUpId == 'wp_hemUp'){
	 			jQuery('#wp_doubleWide').change();
	 	    }
	   }
	   var thisVal = "";
	   var thisValStkNo = "";
	   var itemCode = jQuery("#item").val();
	   var subItemCode = "03"
	   var idValueName = jQuery(this).attr("id");
	   if(idValueName.indexOf("StkNo") == -1){
		   thisVal = jQuery("#" + idValueName).val();
		   thisValStkNo = jQuery("#" + idValueName + "StkNo").val();
	   }else{
		   thisValStkNo = jQuery("#" + idValueName).val();
		   idValueName = idValueName.replace("StkNo","");
		   thisVal = jQuery("#" + idValueName).val();
	   }
	   var price;
	   if(isNotEmpty(pantsModel)){
		   var code = itemCode + subItemCode + pantsModel;
		   jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/" + priceUrl,
			    data:{"code":code,"idValueName":idValueName,"thisVal":thisVal,"thisValStkNo":thisValStkNo,"valueHemUpId":valueHemUpId},
			    dataType:"json",
			    async:false,
			    success:function(result){
			    	if(jQuery("#"+idValueName+"_Msg").length>0){
						jQuery("#"+idValueName+"_Msg").html(result.idValuePrice);
					}else{
						var lengthforLastFive = idValueName.length - 5;
						var idValueTemp = idValueName.substring(0,lengthforLastFive);
						jQuery("#"+idValueTemp+"_Msg").html(result.idValuePrice);
					}
			    	getAllPrice(itemCode, result.optionPrice);
		            allOptionPrice();
			   }
	        });
		}
	});

	var pantsModel = "";
	var priceUrl = "";
	//ラジオボタンの変更処理
	//項目：膝裏、膝裏素材、フロント仕様、パンチェリーナ、アジャスター仕様、ベルトループ、ピンループ、脇ポケット、忍びポケット、フラップ付コインポケット、上前ピスポケット、下前ピスポケット、Vカット、ステッチ種類、ステッチ箇所変更、ダブルステッチ、AMF色指定、ボタンホール色指定、ボタン付け糸指定、サスペンダー釦、エイト（滑り止め）、シック大（股補強）、形状記憶
	jQuery('input[id^="op_kneeBack_id"],[id^="op_kneeBackMate_id"],[id^="op_frontSpec_id"],[id^="op_pancherina_id"],[id^="op_adjuster_id"],[id^="op_beltLoop_id"],[id^="op_pinLoop_id"],[id^="op_sidePkt_id"],[id^="op_sinobiPkt_id"],[id^="op_flapCoinPkt_id"],[id^="op_pisPktUf_id"],[id^="op_pisPktDf_id"],[id^="op_vCut_id"],[id^="op_stitch_id"],[id^="op_dStitch_id"],[id^="op_suspenderBtn_id"],[id^="op_thick_id"],[id^="op_eight_id"],[id^="op_shapeMemory_id"],' + 
		        '[id^="tp_kneeBack_id"],[id^="tp_kneeBackMate_id"],[id^="tp_frontSpec_id"],[id^="tp_pancherina_id"],[id^="tp_adjuster_id"],[id^="tp_beltLoop_id"],[id^="tp_pinLoop_id"],[id^="tp_sidePkt_id"],[id^="tp_sinobiPkt_id"],[id^="tp_flapCoinPkt_id"],[id^="tp_pisPktUf_id"],[id^="tp_pisPktDf_id"],[id^="tp_vCut_id"],[id^="tp_stitch_id"],[id^="tp_suspenderBtn_id"],[id^="tp_thick_id"],[id^="tp_eight_id"],[id^="tp_shapeMemory_id"],[id^="tp_sideStripe_id"],[id^="tp_sideStripeWidth_id"],'+
		        '[id^="wp_kneeBack_id"],[id^="wp_kneeBackMate_id"],[id^="wp_frontSpec_id"],[id^="wp_pancherina_id"],[id^="wp_adjuster_id"],[id^="wp_beltLoop_id"],[id^="wp_pinLoop_id"],[id^="wp_sidePkt_id"],[id^="wp_sinobiPkt_id"],[id^="wp_flapCoinPkt_id"],[id^="wp_pisPktUf_id"],[id^="wp_pisPktDf_id"],[id^="wp_vCut_id"],[id^="wp_stitch_id"],[id^="wp_dStitch_id"],[id^="wp_stitchModify_id"],[id^="wp_dStitch_id"],[id^="wp_suspenderBtn_id"],[id^="wp_eight_id"],[id^="wp_thick_id"],[id^="wp_shapeMemory_id"]')
	.change(function(){
		//jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		var category = jQuery('input[name="productCategory"]:checked').val();
		var valueOpKneeBack = "";
		var valueSideStripe = "";
		   if(category == "9000101"){
			   pantsModel = jQuery("#op_pantsModel option:selected").val();
		    	priceUrl = "getOrderPriceForPantsSProject";
		    	var opKneeBack = this.id;
		    	valueOpKneeBack = jQuery('input[id^="op_kneeBack_id"]:checked').val();
		    	if(opKneeBack == 'op_kneeBack_id1' || opKneeBack == 'op_kneeBack_id2' || opKneeBack == 'op_kneeBack_id3'){
		 			jQuery('input[id^="op_kneeBackMate_id"]:checked').change();
		 	    }
		   }else if(category == "9000102"){
			   pantsModel = jQuery("#tp_pantsModel option:selected").val();
				priceUrl = "getOrderPriceForPantsSTuProject";
				var tpKneeBack = this.id;
				valueOpKneeBack = jQuery('input[id^="tp_kneeBack_id"]:checked').val();
		    	if(tpKneeBack == 'tp_kneeBack_id1' || tpKneeBack == 'tp_kneeBack_id2' || tpKneeBack == 'tp_kneeBack_id3'){
		 			jQuery('input[id^="tp_kneeBackMate_id"]:checked').change();
		 	    }
		    	valueSideStripe = jQuery('input[id^="tp_sideStripe_id"]:checked').val();
		 	    if(tpKneeBack == "tp_sideStripe_id1" || tpKneeBack == "tp_sideStripe_id2"){
					jQuery('input[id^="tp_sideStripeWidth_id"]:checked').change();
			 	}
		   }else if(category == "9000103"){
			   pantsModel = jQuery("#wp_pantsModel option:selected").val();
				priceUrl = "getOrderPriceForPantsSWPProject";
				var wpKneeBack = this.id;
				valueOpKneeBack = jQuery('input[id^="wp_kneeBack_id"]:checked').val();
		    	if(wpKneeBack == 'wp_kneeBack_id1' || wpKneeBack == 'wp_kneeBack_id2' || wpKneeBack == 'wp_kneeBack_id3'){
		 			jQuery('input[id^="wp_kneeBackMate_id"]:checked').change();
		 	    }
		   }
		var thisVal = "";  
		var itemCode = jQuery("#item").val();
	    var subItemCode = "03";
	    var idValueName = jQuery(this).attr("id");
	    thisVal = jQuery("#"+idValueName).val();
	    var price;
	  	//IDの後の番号を削除します
	    var findIdPosition = idValueName.indexOf("_id");
	    var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
		    
		if(isNotEmpty(pantsModel)){
			var code = itemCode + subItemCode + pantsModel;
			jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/" + priceUrl,
			    data:{"code":code,"idValueName":interceptedIdValueName,"thisVal":thisVal,"valueOpKneeBack":valueOpKneeBack,"valueSideStripe":valueSideStripe},
			    async:false,
			    success:function(result){
			    	var msgIdValueName = interceptedIdValueName.replace(/_id/,"_Msg");
			    	jQuery("#"+msgIdValueName).html(result.idValuePrice);
			        jQuery("#optionPrice").html(result.optionPrice);
			        getAllPrice(itemCode, result.optionPrice);
			        allOptionPrice();
			   }
	        });
		}
	});

	// 	ラジオボタンの変更処理
	// 	項目：ベルトループ ,ステッチ箇所変更,ダブルステッチ
	jQuery('input[id^="op_beltLoop_id"],[id^="op_stitchModify_id"],[id^="op_stitchModifyPlace_id"],[id^="tp_beltLoop_id"],[id^="wp_beltLoop_id"],[id^="wp_stitchModify_id"],[id^="wp_stitchModifyPlace_id"]')
	.change(function(){
		//jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		var priceUrl = "";
		var pantsModel = "";
		var category = jQuery('input[name="productCategory"]:checked').val();
		 if(category == "9000101"){
			   pantsModel = jQuery("#op_pantsModel option:selected").val();
		    	priceUrl = "getOrderPriceForPantsSProject";
		   }else if(category == "9000102"){
			   pantsModel = jQuery("#tp_pantsModel option:selected").val();
				priceUrl = "getOrderPriceForPantsSTuProject";
		   }else if(category == "9000103"){
			   pantsModel = jQuery("#wp_pantsModel option:selected").val();
				priceUrl = "getOrderPriceForPantsSWPProject";
		   }
		var itemCode = jQuery("#item").val();
		var subItemCode = "03";
		var idValueName = jQuery(this).attr("id");
		var thisValueTemp = jQuery(this).val();
		var jspOptionCode = "";
	if(category == "9000101"){
		if(thisValueTemp == "0002001"){
			var findIdPosition = idValueName.indexOf("_id");
		    var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
			if(isNotEmpty(pantsModel)){
				jspOptionCode = "00020"
				var code = itemCode + subItemCode + pantsModel + jspOptionCode;
				jQuery.ajax({
					type:"get",
				    url:contextPath + "/orderCo/" + priceUrl,
				    data:{"code":code,"idValueName":interceptedIdValueName,"thisVal":thisValueTemp},
				    async:false,
				    success:function(result){
				    	var msgIdValueName = interceptedIdValueName.replace(/_id/,"_Msg");
				    	jQuery("#"+msgIdValueName).html(result.idValuePrice);
				        jQuery("#optionPrice").html(result.optionPrice);
				        getAllPrice(itemCode, result.optionPrice);
				   }
		        });
			}
		}
		if(thisValueTemp == "0002002"){
			jQuery('input[id^="op_stitchModifyPlace_id"]').change();
		}
	}else if(category == "9000103"){
		if(thisValueTemp == "0002001"){
			var findIdPosition = idValueName.indexOf("_id");
		    var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
			if(isNotEmpty(pantsModel)){
				jspOptionCode = "00020"
				var code = itemCode + subItemCode + pantsModel + jspOptionCode;
				jQuery.ajax({
					type:"get",
				    url:contextPath + "/orderCo/" + priceUrl,
				    data:{"code":code,"idValueName":interceptedIdValueName,"thisVal":thisValueTemp},
				    async:false,
				    success:function(result){
				    	var msgIdValueName = interceptedIdValueName.replace(/_id/,"_Msg");
				    	jQuery("#"+msgIdValueName).html(result.idValuePrice);
				        jQuery("#optionPrice").html(result.optionPrice);
				        getAllPrice(itemCode, result.optionPrice);
				   }
		        });
			}
		}
		if(thisValueTemp == "0002002"){
			jQuery('input[id^="wp_stitchModifyPlace_id"]').change();
		}
	}
// 		if(thisValueTemp == "0002201"){
// 			var findIdPosition = idValueName.indexOf("_id");
// 		    var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
// 			if(isNotEmpty(pantsModel)){
// 				jspOptionCode = "00022"
// 				var code = itemCode + subItemCode + pantsModel + jspOptionCode;
// 				jQuery.ajax({
// 					type:"get",
// 				    url:contextPath + "/orderCo/" + priceUrl,
// 				    data:{"code":code,"idValueName":interceptedIdValueName,"thisVal":thisValueTemp},
// 				    async:false,
// 				    success:function(result){
// 				    	var msgIdValueName = interceptedIdValueName.replace(/_id/,"_Msg");
// 				    	jQuery("#"+msgIdValueName).html(result.idValuePrice);
// 				        jQuery("#optionPrice").html(result.optionPrice);
// 				        getAllPrice(itemCode, result.optionPrice);
// 				   }
// 		        });
// 			}
// 		}
// 		else if(thisValueTemp == "0002202"){
// 			if(category == "9000101"){
// 				jQuery('input[id^="op_dStitchPlace_id"]').change();
// 			}
// 			else if(category == "9000103"){
// 				jQuery('input[id^="wp_dStitchPlace_id"]').change();
// 			}
// 		}
		
		//IDの後の番号を削除します
		var interceptedIdValueName = "";
		
		//複数選択ボックスの数,IDにより決定optionCode
		var ogSomePlace_length = 0;
		var jspOptionCode = "";
		if(idValueName.indexOf("op_stitchModifyPlace_id") >= 0){
			jspOptionCode ="00021";
			ogSomePlace_length = jQuery('input[id^="op_stitchModifyPlace_id"]').length;

		}else if(idValueName.indexOf("wp_stitchModifyPlace_id") >= 0){
			jspOptionCode ="00021";
			ogSomePlace_length = jQuery('input[id^="wp_stitchModifyPlace_id"]').length;
			
		}
// 		else if(idValueName.indexOf("op_dStitchPlace_id") >= 0){
// 			jspOptionCode ="00023";
// 			ogSomePlace_length = jQuery('input[id^="op_dStitchPlace_id"]').length;
			
// 		}
		
// 		else if(idValueName.indexOf("wp_dStitchPlace_id") >= 0){
// 			jspOptionCode ="00023";
// 			ogSomePlace_length = jQuery('input[id^="wp_dStitchPlace_id"]').length;

// 		}

		//チェックボックスのvalueを保存します
		var countArr = "";
		
		//アイテムのID名をクリックして、"Place_id"フィールドを含めます
		var findIdPosition = idValueName.indexOf("Place_id");
		if(findIdPosition != -1){
			//インターセプトID、最初の数字からPlace_idの前まで
			var idValueNameTemp = idValueName.substring(0,findIdPosition);
			interceptedIdValueName = idValueNameTemp + "_id";

			//チェックボックスループ
			for(var i=1; i<=ogSomePlace_length; i++){
				//各チェックボックスのIDをループスプライシング
				//このループの要素を取得します
				var idValueNameComplete = document.getElementById(idValueNameTemp + "Place_id" + i);
				if(idValueNameComplete.checked){
					countArr = countArr + jspOptionCode + idValueNameComplete.value + "/";
				}
			}
		}

		if(isNotEmpty(pantsModel) && findIdPosition != -1){
			var code = itemCode + subItemCode + pantsModel;
			jQuery.ajax({
				type:"get",
				url:contextPath + "/orderCo/" + priceUrl,
				data:{"code":code,"idValueName":interceptedIdValueName,"countArr":countArr},
				dataType:"json",
				contentType:"application/json;charsetset=UTF-8",
				async:false,
				success:function(result){
					var msgIdValueName = interceptedIdValueName.replace(/_id/g,"_Msg");
					jQuery("#"+msgIdValueName).html(result.idValuePrice);
					getAllPrice(itemCode, result.optionPrice);
				}
			});
		}else{
			
		}
		allOptionPrice();
	});
	
	var pantsModel = "";
	var priceUrl = "";
	jQuery('input[id^="op_amfColor_"],[id^="op_bhColor_"],[id^="op_byColor_"],[id^="tp_bhColor_"],[id^="tp_byColor_"],[id^="wp_bhColor_"],[id^="wp_byColor_"],[id^="wp_amfColor_"]').change(function(){
		//jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		
		var category = jQuery('input[name="productCategory"]:checked').val();
		if(category == "9000101"){
			   pantsModel = jQuery("#op_pantsModel option:selected").val();
		    	priceUrl = "getOrderPriceForPantsSProject";
		   }else if(category == "9000102"){
			   pantsModel = jQuery("#tp_pantsModel option:selected").val();
				priceUrl = "getOrderPriceForPantsSTuProject";
		   }else if(category == "9000103"){
			   pantsModel = jQuery("#wp_pantsModel option:selected").val();
				priceUrl = "getOrderPriceForPantsSWPProject";
		   }
		if (pantsModel == '' || pantsModel == null) {
			// 未選択時は何もしない
			return;
		}
		var itemCode = jQuery("#item").val();
	    var subItemCode = "03";
	    var idValueName = jQuery(this).attr("id");
	    var thisValueTemp = jQuery(this).val();
	    //IDの後の番号を削除します
		var interceptedIdValueName = "";
		//複数選択ボックスの数
		var jkSomePlace_length = 0;
		var jspOptionCodeAndBranchCode = "";
		if(idValueName.indexOf("op_amfColor_") >= 0){
			jspOptionCodeAndBranchCode ="00025" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="op_amfColorPlace_"]').length;
		}else if(idValueName.indexOf("op_bhColor_") >= 0){
			jspOptionCodeAndBranchCode ="00028" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="op_bhColorPlace_"]').length;
			
		}else if(idValueName.indexOf("op_byColor_") >= 0){
			jspOptionCodeAndBranchCode ="00031" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="op_byColorPlace_"]').length;
			
		}else if(idValueName.indexOf("tp_bhColor_") >= 0){
			jspOptionCodeAndBranchCode ="00028" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="tp_bhColorPlace_"]').length;
			
		}else if(idValueName.indexOf("tp_byColor_") >= 0){
			jspOptionCodeAndBranchCode ="00031" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="tp_byColorPlace_"]').length;
			
		}else if(idValueName.indexOf("wp_bhColor_") >= 0){
			jspOptionCodeAndBranchCode ="00028" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="wp_bhColorPlace_"]').length;
			
		}else if(idValueName.indexOf("wp_byColor_") >= 0){
			jspOptionCodeAndBranchCode ="00031" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="wp_byColorPlace_"]').length;
			
		}else if(idValueName.indexOf("wp_amfColor_") >= 0){
			jspOptionCodeAndBranchCode ="00025" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="wp_amfColorPlace_"]').length;
			
		}
		//選択した異なる色のvalueを保存する
		var countArr = new Array();
		//選択したさまざまな色の数を保存する
		var colorCount = 0;

		//アイテムのID名をクリックして、"ID"フィールドを含めます
		var findIdPosition = idValueName.indexOf("_id");
		if(findIdPosition == -1){
			interceptedIdValueName = idValueName.replace(new RegExp(thisValueTemp,"g"),"id");
			//ラジオの色を変更する
			//チェックボックスループ
			for(var i=1; i<=jkSomePlace_length; i++){
				//各チェックボックスのIDをループスプライシング
				//選択したチェックボックスの数を取得する
				var idValueNameAll = "";
				if(idValueName.indexOf("op_amfColor_") >= 0){
					
					idValueNameAll = "coOptionPantsStandardInfo.opAmfColor" + i;
			
				}else if(idValueName.indexOf("op_bhColor_") >= 0){
					
					idValueNameAll = "coOptionPantsStandardInfo.opBhColor" + i;
				}else if(idValueName.indexOf("op_byColor_") >= 0){
					
					idValueNameAll = "coOptionPantsStandardInfo.opByColor" + i;
				}else if(idValueName.indexOf("tp_bhColor_") >= 0){
					
					idValueNameAll = "coOptionPantsTuxedoInfo.tpBhColor" + i;
				}else if(idValueName.indexOf("tp_byColor_") >= 0){
					
					idValueNameAll = "coOptionPantsTuxedoInfo.tpByColor" + i;
				}else if(idValueName.indexOf("wp_amfColor_") >= 0){
					
					idValueNameAll = "coOptionPantsWashableInfo.wpAmfColor" + i;
				}else if(idValueName.indexOf("wp_byColor_") >= 0){
					
					idValueNameAll = "coOptionPantsWashableInfo.wpByColor" + i;
				}else if(idValueName.indexOf("wp_bhColor_") >= 0){
					
					idValueNameAll = "coOptionPantsWashableInfo.wpBhColor" + i;
				}

				var idValueNameJs = document.getElementsByName(idValueNameAll);
				//colorループ
				for(var j=0; j<idValueNameJs.length; j++){
					if(idValueNameJs[j].checked){
						//選択した色
						var arrTemp = false;
						//配列ループ
						for(var k=0; k<countArr.length; k++){
							if(countArr[k] == idValueNameJs[j].value){
								//選択した色は既に配列に存在します
								arrTemp = true;
								break;
							}
						}
						if(arrTemp == false){
							countArr.push(idValueNameJs[j].value);
							colorCount++;
						}
					}
				}
			}
		}else{
			if(idValueName.indexOf("op_amfColor_") >= 0){
				jspOptionCodeAndBranchCode ="00024" + thisValueTemp;
			}else if(idValueName.indexOf("op_bhColor_") >= 0){
				jspOptionCodeAndBranchCode ="00027" + thisValueTemp;
			}else if(idValueName.indexOf("op_byColor_") >= 0){
				jspOptionCodeAndBranchCode ="00030" + thisValueTemp;
			}else if(idValueName.indexOf("tp_bhColor_") >= 0){
				jspOptionCodeAndBranchCode ="00027" + thisValueTemp;
			}else if(idValueName.indexOf("tp_byColor_") >= 0){
				jspOptionCodeAndBranchCode ="00030" + thisValueTemp;
			}else if(idValueName.indexOf("wp_bhColor_") >= 0){
				jspOptionCodeAndBranchCode ="00027" + thisValueTemp;
			}else if(idValueName.indexOf("wp_byColor_") >= 0){
				jspOptionCodeAndBranchCode ="00030" + thisValueTemp;
			}else if(idValueName.indexOf("wp_amfColor_") >= 0){
				jspOptionCodeAndBranchCode ="00024" + thisValueTemp;
			}
			interceptedIdValueName = idValueName.substring(0, findIdPosition+3);
			colorCount = -1;
		}
		var desiredItemFlag = false;
		if(interceptedIdValueName == "op_amfColor_id" || interceptedIdValueName == "op_bhColor_id" || interceptedIdValueName == "op_byColor_id" 
				|| interceptedIdValueName == "tp_byColor_id" || interceptedIdValueName == "tp_bhColor_id"
				|| interceptedIdValueName == "wp_amfColor_id" || interceptedIdValueName == "wp_bhColor_id" || interceptedIdValueName == "wp_byColor_id"){
			desiredItemFlag = true;
		}
		if(isNotEmpty(pantsModel) && desiredItemFlag == true){
			var code = itemCode + subItemCode + pantsModel;
			jQuery.ajax({
				type:"get",
				url:contextPath + "/orderCo/" + priceUrl,
				data:{"code":code,"idValueName":interceptedIdValueName,"jspOptionCodeAndBranchCode":jspOptionCodeAndBranchCode,"colorCount":colorCount},
				dataType:"json",
				contentType:"application/json;charsetset=UTF-8",
				async:false,
				success:function(result){
					var msgIdValueName = interceptedIdValueName.replace(/_id/g,"_Msg");
					jQuery("#"+msgIdValueName).html(result.idValuePrice);
					getAllPrice(subItemCode, result.optionPrice);
				}
			});
		}else{
			interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
			var msgIdValueName = interceptedIdValueName.replace(/_id/g,"_Msg");
			jQuery("#"+msgIdValueName).html("無料");
		}
		allOptionPrice();
	})
	//項目：AMF色指定、ボタンホール色指定、ボタン付け糸指定の全選択、全解除
	jQuery('[id^="btn_as_op_amfColorPlace"],[id^="btn_ar_op_amfColorPlace"],[id^="btn_as_op_bhColorPlace"],'+
			'[id^="btn_ar_op_bhColorPlace"],[id^="btn_as_op_byColorPlace"],[id^="btn_ar_op_byColorPlace"],' +
			'[id^="btn_as_tp_bhColorPlace"],[id^="btn_ar_tp_bhColorPlace"],[id^="btn_as_tp_byColorPlace"],' + 
			'[id^="btn_ar_tp_byColorPlace"],[id^="btn_as_wp_amfColorPlace"],[id^="btn_ar_wp_amfColorPlace"],' + 
			'[id^="btn_as_wp_bhColorPlace"],[id^="btn_ar_wp_bhColorPlace"],[id^="btn_as_wp_byColorPlace"],' + 
			'[id^="btn_ar_wp_byColorPlace"]').click(function(){

		var productCategory = jQuery('input[name="productCategory"]:checked').val();
		var ajaxUrl = "";
		var pantsModel = "";
		var idValueNameTemp = "";
		var thisValueTemp = "";
		if(productCategory == "9000101"){
			idValueNameTemp = "op_";
			ajaxUrl = "getOrderPriceForPantsSProject";
			pantsModel = jQuery("#op_pantsModel option:selected").val();
		}else if(productCategory == "9000102"){
			idValueNameTemp = "tp_";
			ajaxUrl = "getOrderPriceForPantsSTuProject";
			pantsModel = jQuery("#tp_pantsModel option:selected").val();
		}else if(productCategory == "9000103"){
			idValueNameTemp = "wp_";
			ajaxUrl = "getOrderPriceForPantsSWPProject";
			pantsModel = jQuery("#wp_pantsModel option:selected").val();
		}

		var itemCode = jQuery("#item").val();
		var subItemCode = "03";
		var idValueName = jQuery(this).attr("id");
		

		var findIdAmf = idValueName.indexOf("_amfColorPlace");
		var findIdBh = idValueName.indexOf("_bhColorPlace");
		var findIdBy = idValueName.indexOf("_byColorPlace");
		if(findIdAmf != -1){
			idValueNameTemp = idValueNameTemp + "amfColor_id";
			if(productCategory == "9000101"){
				var clickFlag = false;
				jQuery('#op_amfColor_div input[type="checkbox"]').each(function(index, elem){
					elem = jQuery(elem);
					if (!elem.prop("disabled")) {
						clickFlag = true;
					}
				});
				if(!clickFlag){
					return;
				}
				thisValueTemp = "00025" + jQuery("#op_amfColorPlaceAll").val();
			}else if(productCategory == "9000103"){
				var clickFlag = false;
				jQuery('#wp_amfColor_div input[type="checkbox"]').each(function(index, elem){
					elem = jQuery(elem);
					if (!elem.prop("disabled")) {
						clickFlag = true;
					}
				});
				if(!clickFlag){
					return;
				}
				thisValueTemp = "00025" + jQuery("#wp_amfColorPlaceAll").val();
			}
		}else if(findIdBh != -1){
			idValueNameTemp = idValueNameTemp + "bhColor_id";
			if(productCategory == "9000101"){
				thisValueTemp = "00028" + jQuery("#op_bhColorPlaceAll").val();
			}else if(productCategory == "9000102"){
				thisValueTemp = "00028" + jQuery("#tp_bhColorPlaceAll").val();
			}else if(productCategory == "9000103"){
				thisValueTemp = "00028" + jQuery("#wp_bhColorPlaceAll").val();
			}
		}else if(findIdBy != -1){
			idValueNameTemp = idValueNameTemp + "byColor_id";
			if(productCategory == "9000101"){
				thisValueTemp = "00031" + jQuery("#wp_byColorPlaceAll").val();
			}else if(productCategory == "9000102"){
				thisValueTemp = "00031" + jQuery("#tp_byColorPlaceAll").val();
			}else if(productCategory == "9000103"){
				thisValueTemp = "00031" + jQuery("#wp_byColorPlaceAll").val();
			}
		}

		//選択された異なる色の数
		var colorCount = 0;
		var findIdAs = idValueName.indexOf("btn_as_");
		var findIdAr = idValueName.indexOf("btn_ar_");
		if(findIdAs != -1){
			colorCount = 1;
		}else if(findIdAr != -1){
			colorCount = 0;
		}
		
		if(isNotEmpty(pantsModel)){
			var code = itemCode + subItemCode + pantsModel;
			jQuery.ajax({
				type:"get",
				url:contextPath + "/orderCo/" + ajaxUrl,
				data:{"code":code,"idValueName":idValueNameTemp,"jspOptionCodeAndBranchCode":thisValueTemp,"colorCount":colorCount},
				dataType:"json",
				contentType:"application/json;charsetset=UTF-8",
				async:false,
				success:function(result){
					var msgIdValueName = idValueName.substring(7);
					msgIdValueName = msgIdValueName.replace(/Place/g,"_Msg");
					jQuery("#"+msgIdValueName).html(result.idValuePrice);
					getAllPrice(subItemCode, result.optionPrice);
				}
			});
		}
		allOptionPrice();
	});
}

function formatMoney(number, places, symbol, thousand, decimal) {
number = number || 0;
places = !isNaN(places = Math.abs(places)) ? places : 2;
symbol = symbol !== undefined ? symbol : "$";
thousand = thousand || ",";
decimal = decimal || ".";
var negative = number < 0 ? "-" : "",
    i = parseInt(number = Math.abs(+number || 0).toFixed(places), 10) + "",
    j = (a = i.length) > 3 ? a % 3 : 0;
return symbol + negative + (j ? i.substr(0, j) + thousand : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + thousand) + (places ? decimal + Math.abs(number - i).toFixed(places).slice(2) : "");
}

function getAllPrice(subItemCode, optionPrice){
	jQuery("#ptOptionPriceId").val(optionPrice);
    var jkOptionPriceId = optionPrice;
    var ptOptionPriceId = jQuery("#ptOptionPriceId").val();
    var pt2OptionPriceId = jQuery("#pt2OptionPriceId").val();
    var glOptionPriceId = jQuery("#glOptionPriceId").val();
    var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
    var twoPants = jQuery('input[name="productSparePantsClass"]:checked').val();
    var allPrice = 0;
    if(subItemCode == "01"){
        if(threePiece == "0009901" && twoPants == "0009901"){
        	allPrice = Number(jkOptionPriceId) + Number(ptOptionPriceId);
        }
        else if(threePiece == "0009902" && twoPants == "0009901"){
        	allPrice = Number(jkOptionPriceId) + Number(ptOptionPriceId) + Number(glOptionPriceId);
        }
        else if(threePiece == "0009901" && twoPants == "0009902"){
        	allPrice = Number(jkOptionPriceId) + Number(ptOptionPriceId) + Number(pt2OptionPriceId);
        }else{
        	allPrice = Number(jkOptionPriceId) + Number(ptOptionPriceId) + Number(pt2OptionPriceId) + Number(glOptionPriceId);
        }
    }else{
    	allPrice = Number(jkOptionPriceId);
    }
    jQuery("#optionPriceId").val(allPrice);
    jQuery("#optionPrice").html(formatMoney(allPrice,0,""));
}

function  opSession(){
	var pantsModel ="${orderCoForm.coOptionPantsStandardInfo.opPantsModel}";
	if(!isEmpty(pantsModel)){
		var tackElem = jQuery('#op_tack');
		tackElem.empty();
		var tmpTack = null;
		for (tmpTack of tackList[pantsModel].activeList) {
			tackElem.append(jQuery('<option />').val(tmpTack.val).text(tmpTack.text));
		}
		// デフォルトを選択
		var tackVal ="${orderCoForm.coOptionPantsStandardInfo.opTack}";
		tackElem.val(tackVal);
		
		jQuery('input[id^="op_adjuster_"]').each(function() {
			var tmpopAdjusterElem = jQuery(this);
			var value = tmpopAdjusterElem.val();

			if (adjusterList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なアジャスター仕様の場合、有効化
				tmpopAdjusterElem.prop("disabled", false);
			} else {
				// 有効なアジャスター仕様ではない場合、無効化
				tmpopAdjusterElem.prop("disabled", true);
			}
		});

		// ベルトループの選択肢制御
		jQuery('input[id^="op_beltLoop_"]').each(function() {
			var tmpopBeltLoopElem = jQuery(this);
			var value = tmpopBeltLoopElem.val();

			if (beltLoopList[pantsModel].activeList.indexOf(value) != -1) {
				// 有効なベルトループの場合、有効化
				tmpopBeltLoopElem.prop("disabled", false);
			} else {
				// 有効なベルトループではない場合、無効化
				tmpopBeltLoopElem.prop("disabled", true);
			}
		});

		// フラシループ設定
		var frsAreaElem = jQuery('#op_beltLoopPlace_id17');
		if (pantsModel == 'NZ01') {
			// 表示
			frsAreaElem.show();
		} else {
			// 非表示
			frsAreaElem.hide();
		}
	}

	//膝裏
	jQuery('input[name="coOptionPantsStandardInfo.opKneeBack"]').val(["${orderCoForm.coOptionPantsStandardInfo.opKneeBack}"]);
	var selectedKneeBack = "${orderCoForm.coOptionPantsStandardInfo.opKneeBack}";
	if (selectedKneeBack == '0000202') {
		jQuery('#op_kneeBackMate_div').hide();
	} else {
		jQuery('#op_kneeBackMate_div').show();
	}
	
	//膝裏素材
	jQuery('input[name="coOptionPantsStandardInfo.opKneeBackMate"]').val(["${orderCoForm.coOptionPantsStandardInfo.opKneeBackMate}"]);

	//フロント仕様
	jQuery('input[name="coOptionPantsStandardInfo.opFrontSpec"]').val(["${orderCoForm.coOptionPantsStandardInfo.opFrontSpec}"]);

	// 特定のモデル以外はパンチェリーナ選択不可
 	if (pantsModel != 'TR02'
			&& pantsModel != 'CH14'
			&& pantsModel != 'NZ01'
			&& pantsModel != 'JW21'
			&& pantsModel != 'AY01') {
		jQuery('#op_pancherina_id1').prop("disabled", false);

	} else {

		// 後続処理のために一旦パンチェリーナの選択肢を活性化させる
		jQuery('#op_pancherina_id1').prop("disabled", false);
		jQuery('#op_pancherina_id2').prop("disabled", false);

		// 現在のフロント仕様を取得
		var selectedFrontSpec = jQuery('input[name="coOptionPantsStandardInfo.opFrontSpec"]:checked').val();

		// フロント仕様がホック留めの場合はパンチェリーナは無し固定
		if (selectedFrontSpec == '0000402') {
			jQuery('#op_pancherina_id2').prop('disabled', true);
			jQuery('#op_pancherina_id1').prop('disabled', false);
		}
	}
	
	//アジャスター仕様
	jQuery('input[name="coOptionPantsStandardInfo.opAdjuster"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAdjuster}"]);

	//ベルトループ
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoop"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoop}"]);
	var selectedopBeltLoop = "${orderCoForm.coOptionPantsStandardInfo.opBeltLoop}";
	if (selectedopBeltLoop == '0000701') {
		// 表示
		jQuery('#op_beltLoopPlace').show();
	} else {
		// 非表示
		jQuery('#op_beltLoopPlace').hide();
	}
	jQuery('input[id^="op_beltLoop_id"]:checked').change();
	
	//ピンループ
	jQuery('input[name="coOptionPantsStandardInfo.opPinLoop"]').val(["${orderCoForm.coOptionPantsStandardInfo.opPinLoop}"]);
	jQuery('input[id^="op_pinLoop_id"]:checked').change();
	
	//脇ポケット	
	jQuery('input[name="coOptionPantsStandardInfo.opSidePkt"]').val(["${orderCoForm.coOptionPantsStandardInfo.opSidePkt}"]);
	
	//忍びポケット
	jQuery('input[name="coOptionPantsStandardInfo.opSinobiPkt"]').val(["${orderCoForm.coOptionPantsStandardInfo.opSinobiPkt}"]);

	//フラップ付コインポケット
	jQuery('input[name="coOptionPantsStandardInfo.opFlapCoinPkt"]').val(["${orderCoForm.coOptionPantsStandardInfo.opFlapCoinPkt}"]);

	//上前ピスポケット
	jQuery('input[name="coOptionPantsStandardInfo.opPisPktUf"]').val(["${orderCoForm.coOptionPantsStandardInfo.opPisPktUf}"]);

	//下前ピスポケット 
	jQuery('input[name="coOptionPantsStandardInfo.opPisPktDf"]').val(["${orderCoForm.coOptionPantsStandardInfo.opPisPktDf}"]);

	//Vカット
	jQuery('input[name="coOptionPantsStandardInfo.opVCut"]').val(["${orderCoForm.coOptionPantsStandardInfo.opVCut}"]);

	//ステッチ種類 
	jQuery('input[name="coOptionPantsStandardInfo.opStitch"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitch}"]);
	jQuery('input[id^="op_stitch_id"]:checked').change();
	
	//コインポケット
	jQuery("#op_coinPkt").val("${orderCoForm.coOptionPantsStandardInfo.opCoinPkt}");

	//裾上げ
	jQuery('#op_hemUp').val("${orderCoForm.coOptionPantsStandardInfo.opHemUp}");
	var opHemUp = "${orderCoForm.coOptionPantsStandardInfo.opHemUp}";
	if(opHemUp == '0001702' || opHemUp == '0001703'){
		jQuery('#op_doubleWide_div').show();
	}
	else {
		// ダブル幅
		var opDoubleWide = "${orderCoForm.coOptionPantsStandardInfo.opDoubleWide}";
		if(opDoubleWide == null || opDoubleWide == ""){
			jQuery('select[name="coOptionPantsStandardInfo.opDoubleWide"]').find('option[value="4"]').prop("selected",true);
		}
	}
	
	//ベルトループ
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoop"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoop}"]);
	jQuery('input[id^="op_beltLoop_id"]:checked').change();
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace4}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace5"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace5}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace6"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace6}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace7"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace7}"]);
	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="coOptionPantsStandardInfo.opBeltLoop"]:checked').val();
	if (selectedBeltLoop == '0000701') {
		// 表示
		jQuery('#op_beltLoopPlace').show();
	} else {
		// 非表示
		jQuery('#op_beltLoopPlace').hide();
	}
	
	//ピンループ
	jQuery('input[name="coOptionPantsStandardInfo.opPinLoop"]').val(["${orderCoForm.coOptionPantsStandardInfo.opPinLoop}"]);
	jQuery('input[id^="op_pinLoop_id"]:checked').change();
	
	//ステッチ箇所変更
	jQuery('input[name="coOptionPantsStandardInfo.opStitchModify"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModify}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace4}"]);

	//ダブルステッチ
	ctrlOpDStitchPlace();
	//AMF色指定
	ctrlOpAmfColor();
	
	jQuery('input[name="coOptionPantsStandardInfo.opDStitchPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opDStitchPlace1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opDStitchPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opDStitchPlace2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opDStitchPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opDStitchPlace3}"]);

	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColorPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColorPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColorPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColorPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace4}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor4}"]);
	if("${orderCoForm.coOptionPantsStandardInfo.opAmfColor}" == '0002401'){
		jQuery('input[id^="op_amfColor_id"]:checked').change();
	}
	else {
		jQuery('input[id^="op_amfColor_"]:checked').change();
	}
	
	//ボタンホール色指定
	jQuery('input[name="coOptionPantsStandardInfo.opBhColor"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColorPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColorPlace1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColorPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColorPlace2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColorPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColorPlace3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColorPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColorPlace4}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColor1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColor2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColor3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColor4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor4}"]);
	jQuery('input[id^="op_bhColorPlace_"]:checked').change();
	
	//ボタン付け糸指定
	jQuery('input[name="coOptionPantsStandardInfo.opByColor"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColorPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColorPlace1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColorPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColorPlace2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColorPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColorPlace3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColorPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColorPlace4}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColor1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColor2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColor3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColor4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor4}"]);
	jQuery('input[id^="op_byColorPlace_"]:checked').change();
	
	//釦素材
   if(isNotEmpty("${orderCoForm.coOptionPantsStandardInfo.opBtnMateStkNo}")){
	  jQuery('#op_btnMateStkNo').val("${orderCoForm.coOptionPantsStandardInfo.opBtnMateStkNo}");
	   jQuery('#op_btnMateStkNo').change();
	   if(ojBtnMatePtFlag=="1"){
		 jQuery("#ojBtnMatePtFlag").val("0");
		}
   }
	
}

function  tpSession(){

	var pantstModel ="${orderCoForm.coOptionPantsTuxedoInfo.tpPantsModel}";
	if(!isEmpty(pantstModel)){
		var tackElem = jQuery('#tp_tack');
    	tackElem.empty();
    	var tmpTack = null;
    	for (tmpTack of tackList[pantstModel].activeList) {
    		tackElem.append(jQuery('<option />').val(tmpTack.val).text(tmpTack.text));
    	}
    	// デフォルトを選択
    	var tackVal ="${orderCoForm.coOptionPantsTuxedoInfo.tpTack}";
    	tackElem.val(tackVal);
    	
		jQuery('input[id^="tp_adjuster_"]').each(function() {
			var tmpOp2AdjusterElem = jQuery(this);
			var value = tmpOp2AdjusterElem.val();

			if (adjusterList[pantstModel].activeList.indexOf(value) != -1) {
				// 有効なアジャスター仕様の場合、有効化
				tmpOp2AdjusterElem.prop("disabled", false);
			} else {
				// 有効なアジャスター仕様ではない場合、無効化
				tmpOp2AdjusterElem.prop("disabled", true);
			}
		});

		// ベルトループの選択肢制御
		jQuery('input[id^="tp_beltLoop_"]').each(function() {
			var tmptpBeltLoopElem = jQuery(this);
			var value = tmptpBeltLoopElem.val();

			if (beltLoopList[pantstModel].activeList.indexOf(value) != -1) {
				// 有効なベルトループの場合、有効化
				tmptpBeltLoopElem.prop("disabled", false);
			} else {
				// 有効なベルトループではない場合、無効化
				tmptpBeltLoopElem.prop("disabled", true);
			}
		});

		// フラシループ設定
		var frsAreaElem = jQuery('#tp_beltLoopPlace_id17');
		if (pantstModel == 'NZ01') {
			// 表示
			frsAreaElem.show();
		} else {
			// 非表示
			frsAreaElem.hide();
		}
	}
	
	//膝裏
	jQuery('input[name="coOptionPantsTuxedoInfo.tpKneeBack"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpKneeBack}"]);
	var selectedtpKneeBack = "${orderCoForm.coOptionPantsTuxedoInfo.tpKneeBack}";
	if (selectedtpKneeBack == '0000202') {
		jQuery('#tp_kneeBackMate_div').hide();
	} else {
		jQuery('#tp_kneeBackMate_div').show();
	}

	//膝裏素材
	jQuery('input[name="coOptionPantsTuxedoInfo.tpKneeBackMate"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpKneeBackMate}"]);

	//フロント仕様
	jQuery('input[name="coOptionPantsTuxedoInfo.tpFrontSpec"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpFrontSpec}"]);

	// 特定のモデル以外はパンチェリーナ選択不可
 	if (pantstModel != 'TR02'
			&& pantstModel != 'CH14'
			&& pantstModel != 'NZ01'
			&& pantstModel != 'JW21'
			&& pantstModel != 'AY01') {
		jQuery('#tp_pancherina_id1').prop("disabled", false);

	} else {

		// 後続処理のために一旦パンチェリーナの選択肢を活性化させる
		jQuery('#tp_pancherina_id1').prop("disabled", false);
		jQuery('#tp_pancherina_id2').prop("disabled", false);

		// 現在のフロント仕様を取得
		var selectedFrontSpec = jQuery('input[name="coOptionPantsTuxedoInfo.tpFrontSpec"]:checked').val();

		// フロント仕様がホック留めの場合はパンチェリーナは無し固定
		if (selectedFrontSpec == '0000402') {
			jQuery('#tp_pancherina_id2').prop('disabled', true);
			jQuery('#tp_pancherina_id1').prop('disabled', false);
		}
	}

	//パンチェリーナ
	jQuery('input[name="coOptionPantsTuxedoInfo.tpPancherina"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPancherina}"]);
	
	//アジャスター仕様
	jQuery('input[name="coOptionPantsTuxedoInfo.tpAdjuster"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpAdjuster}"]);

	//ベルトループ 
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoop"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoop}"]);
	var selectedtpBeltLoop = "${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoop}";
	if (selectedtpBeltLoop == '0000701') {
		// 表示
		jQuery('#tp_beltLoopPlace').show();
	} else {
		// 非表示
		jQuery('#tp_beltLoopPlace').hide();
	}
	jQuery('input[id^="tp_beltLoop_id"]:checked').change();
	
	//ピンループ
	jQuery('input[name="coOptionPantsTuxedoInfo.tpPinLoop"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPinLoop}"]);
	jQuery('input[id^="tp_pinLoop_id"]:checked').change();
	
	//脇ポケット
	jQuery('input[name="coOptionPantsTuxedoInfo.tpSidePkt"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpSidePkt}"]);
	
	//忍びポケット
	jQuery('input[name="coOptionPantsTuxedoInfo.tpSinobiPkt"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpSinobiPkt}"]);

	//フラップ付コインポケット
	jQuery('input[name="coOptionPantsTuxedoInfo.tpFlapCoinPkt"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpFlapCoinPkt}"]);

	//上前ピスポケット
	jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktUf"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPisPktUf}"]);

	//下前ピスポケット
	jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktDf"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPisPktDf}"]);

	//Vカット
	jQuery('input[name="coOptionPantsTuxedoInfo.tpVCut"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpVCut}"]);
	
	//コインポケット
	jQuery("#tp_coinPkt").val("${orderCoForm.coOptionPantsTuxedoInfo.tpCoinPkt}");

	//裾上げ
	jQuery("#tp_hemUp").val("${orderCoForm.coOptionPantsTuxedoInfo.tpHemUp}");
	var tpHemUp ="${orderCoForm.coOptionPantsTuxedoInfo.tpHemUp}";
	if(tpHemUp == '0001702' || tpHemUp == '0001703'){
		jQuery('#tp_doubleWide_div').show();
	}
	else {
		// ダブル幅
		var tpDoubleWide = "${orderCoForm.coOptionPantsTuxedoInfo.tpDoubleWide}";
		if(tpDoubleWide == null || tpDoubleWide == ""){
			jQuery('select[name="coOptionPantsTuxedoInfo.tpDoubleWide"]').find('option[value="4"]').prop("selected",true);
		}
	}
	
   //ベルトループ 
    jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoop"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoop}"]);
    jQuery('input[id^="tp_beltLoop_id"]:checked').change();
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace1}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace2}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace3}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace4}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace5"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace5}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace6"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace6}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace7"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace7}"]);
	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoop"]:checked').val();
	if (selectedBeltLoop == '0000701') {
		// 表示
		jQuery('#tp_beltLoopPlace').show();
	} else {
		// 非表示
		jQuery('#tp_beltLoopPlace').hide();
	}
	
	//ピンループ
	jQuery('input[name="coOptionPantsTuxedoInfo.tpPinLoop"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPinLoop}"]);
	jQuery('input[id^="tp_pinLoop_id"]:checked').change();
	
	//ステッチ種類
	jQuery('input[name="coOptionPantsTuxedoInfo.tpStitch"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpStitch}"]);
	
	//ボタンホール色指定
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColorPlace1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlace1}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColorPlace2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlace2}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColorPlace3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlace3}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColorPlace4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlace4}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor1}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor2}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor3}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor4}"]);
	jQuery('input[id^="tp_bhColor_"]:checked').change();
	
	//ボタン付け糸指定
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColorPlace1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlace1}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColorPlace2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlace2}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColorPlace3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlace3}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColorPlace4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlace4}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor1}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor2}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor3}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor4}"]);
	jQuery('input[id^="tp_byColor_"]:checked').change();
	
	if(isNotEmpty("${orderCoForm.coOptionPantsTuxedoInfo.tpBtnMateStkNo}")){
		jQuery("#tp_btnMateStkNo").val("${orderCoForm.coOptionPantsTuxedoInfo.tpBtnMateStkNo}");
		jQuery("#tp_btnMateStkNo").change();
		if(ojBtnMatePtFlag=="1"){
			 jQuery("#ojBtnMatePtFlag").val("0");
			}
	  }
}
function  wpSession(){

	var pantswModel ="${orderCoForm.coOptionPantsWashableInfo.wpPantsModel}";
	if(!isEmpty(pantswModel)){
		var tackElem = jQuery('#wp_tack_id');
    	tackElem.empty();
    	var tmpTack = null;
    	for (tmpTack of tackList[pantswModel].activeList) {
    		tackElem.append(jQuery('<option />').val(tmpTack.val).text(tmpTack.text));
    	}
    	// デフォルトを選択
    	var tackVal ="${orderCoForm.coOptionPantsWashableInfo.wpTack}";
    	tackElem.val(tackVal);
    	
		//アジャスター仕様
		jQuery('input[id^="wp_adjuster_"]').each(function() {
			var tmpOp2AdjusterElem = jQuery(this);
			var value = tmpOp2AdjusterElem.val();

			if (adjusterList[pantswModel].activeList.indexOf(value) != -1) {
				// 有効なアジャスター仕様の場合、有効化
				tmpOp2AdjusterElem.prop("disabled", false);
			} else {
				// 有効なアジャスター仕様ではない場合、無効化
				tmpOp2AdjusterElem.prop("disabled", true);
			}
		});

		// ベルトループの選択肢制御
		jQuery('input[id^="wp_beltLoop_"]').each(function() {
			var tmpwpBeltLoopElem = jQuery(this);
			var value = tmpwpBeltLoopElem.val();

			if (beltLoopList[pantswModel].activeList.indexOf(value) != -1) {
				// 有効なベルトループの場合、有効化
				tmpwpBeltLoopElem.prop("disabled", false);
			} else {
				// 有効なベルトループではない場合、無効化
				tmpwpBeltLoopElem.prop("disabled", true);
			}
		});

		// フラシループ設定
		var frsAreaElem = jQuery('#wp_beltLoopPlace_id17');
		if (pantswModel == 'NZ01') {
			// 表示
			frsAreaElem.show();
		} else {
			// 非表示
			frsAreaElem.hide();
		}
	}

	//膝裏
	jQuery('input[name="coOptionPantsWashableInfo.wpKneeBack"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpKneeBack}"]);
	var selectedWpKneeBack = "${orderCoForm.coOptionPantsWashableInfo.wpKneeBack}";
	if (selectedWpKneeBack == '0000202') {
		jQuery('#wp_kneeBackMate_div').hide();
	} else {
		jQuery('#wp_kneeBackMate_div').show();
	}

	//膝裏素材
	jQuery('input[name="coOptionPantsWashableInfo.wpKneeBackMate"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpKneeBackMate}"]);

	//フロント仕様
	jQuery('input[name="coOptionPantsWashableInfo.wpFrontSpec"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpFrontSpec}"]);

	// 特定のモデル以外はパンチェリーナ選択不可
 	if (pantswModel != 'TR02'
			&& pantswModel != 'CH14'
			&& pantswModel != 'NZ01'
			&& pantswModel != 'JW21'
			&& pantswModel != 'AY01') {
		jQuery('#wp_pancherina_id1').prop("disabled", false);

	} else {

		// 後続処理のために一旦パンチェリーナの選択肢を活性化させる
		jQuery('#wp_pancherina_id1').prop("disabled", false);
		jQuery('#wp_pancherina_id2').prop("disabled", false);

		// 現在のフロント仕様を取得
		var selectedFrontSpec = jQuery('input[name="coOptionPantsWashableInfo.wpFrontSpec"]:checked').val();

		// フロント仕様がホック留めの場合はパンチェリーナは無し固定
		if (selectedFrontSpec == '0000402') {
			jQuery('#wp_pancherina_id2').prop('disabled', true);
			jQuery('#wp_pancherina_id1').prop('disabled', false);
		}
	}
	
	//パンチェリーナ
	jQuery('input[name="coOptionPantsWashableInfo.wpPancherina"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpPancherina}"]);
	
	//アジャスター仕様
	jQuery('input[name="coOptionPantsWashableInfo.wpAdjuster"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAdjuster}"]);

	//ベルトループ
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoop"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoop}"]);
	var selectedwpBeltLoop = "${orderCoForm.coOptionPantsWashableInfo.wpBeltLoop}";
	if (selectedwpBeltLoop == '0000701') {
		// 表示
		jQuery('#wp_beltLoopPlace').show();
	} else {
		// 非表示
		jQuery('#wp_beltLoopPlace').hide();
	}
	jQuery('input[id^="wp_beltLoop_id"]:checked').change();
	
	//ピンループ
	jQuery('input[name="coOptionPantsWashableInfo.wpPinLoop"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpPinLoop}"]);
	jQuery('input[id^="wp_pinLoop_id"]:checked').change();
	
	//脇ポケット
	jQuery('input[name="coOptionPantsWashableInfo.wpSidePkt"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpSidePkt}"]);

	//忍びポケット
	jQuery('input[name="coOptionPantsWashableInfo.wpSinobiPkt"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpSinobiPkt}"]);

	//フラップ付コインポケット
	jQuery('input[name="coOptionPantsWashableInfo.wpFlapCoinPkt"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpFlapCoinPkt}"]);

	//上前ピスポケット
	jQuery('input[name="coOptionPantsWashableInfo.wpPisPktUf"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpPisPktUf}"]);

	//下前ピスポケット 
	jQuery('input[name="coOptionPantsWashableInfo.wpPisPktDf"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpPisPktDf}"]);

	//Vカット
	jQuery('input[name="coOptionPantsWashableInfo.wpVCut"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpVCut}"]);

	//コインポケット
	jQuery("#wp_coinPkt_id").val("${orderCoForm.coOptionPantsWashableInfo.wpCoinPkt}");
	
	jQuery("#wp_hemUp").val("${orderCoForm.coOptionPantsWashableInfo.wpHemUp}");
	var wpHemUp = "${orderCoForm.coOptionPantsWashableInfo.wpHemUp}";
	if(wpHemUp == '0001702' || wpHemUp == '0001703'){
		jQuery('#wp_doubleWide_div').show();
	}
	else {
		// ダブル幅
		var wpDoubleWide = "${orderCoForm.coOptionPantsWashableInfo.wpDoubleWide}";
		if(wpDoubleWide == null || wpDoubleWide == ""){
			jQuery('select[name="coOptionPantsWashableInfo.wpDoubleWide"]').find('option[value="4"]').prop("selected",true);
		}
	}
	
	//ベルトループ
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoop"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoop}"]);
	jQuery('input[id^="wp_beltLoop_id"]:checked').change();
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace5"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace5}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace6"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace6}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace7"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace7}"]);
	// 選択中のベルトループ
	var selectedBeltLoop = jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoop"]:checked').val();
	//0000701(有り)
	if (selectedBeltLoop == '0000701') {
		// 表示
		jQuery('#wp_beltLoopPlace').show();
	} else {
		// 非表示
		jQuery('#wp_beltLoopPlace').hide();
	}
	
	//ピンループ
	jQuery('input[name="coOptionPantsWashableInfo.wpPinLoop"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpPinLoop}"]);
	jQuery('input[id^="wp_pinLoop_id"]:checked').change();
	
	//ステッチ箇所変更
	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModify"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModify}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlace1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlace2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlace3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlace4}"]);

	//ダブルステッチ
	ctrlWpDStitchPlace();
	//AMF色指定
	ctrlWpAmfColor();
	
	//ダブルステッチ
	jQuery('input[name="coOptionPantsWashableInfo.wpDStitch"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitch}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpDStitchPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlace1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpDStitchPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlace2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpDStitchPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlace3}"]);
	
	//AMF色指定
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColorPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlace1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColorPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlace2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColorPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlace3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColorPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlace4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor4}"]);
	jQuery('input[id^="wp_amfColorPlace_"]:checked').change();
	jQuery('input[id^="wp_amfColor_"]:checked').change();
	
	//ボタンホール色指定
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor4}"]);
	jQuery('input[id^="wp_bhColorPlace_"]:checked').change();
	
	//ボタン付け糸指定
	jQuery('input[name="coOptionPantsWashableInfo.wpByColor"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColorPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColorPlace1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColorPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColorPlace2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColorPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColorPlace3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColorPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColorPlace4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColor2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColor3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColor4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor4}"]);
	jQuery('input[id^="wp_byColorPlace_"]:checked').change();

	if(isNotEmpty("${orderCoForm.coOptionPantsWashableInfo.wpBtnMateStkNo}")){
		jQuery("#wp_btnMateStkNo").val("${orderCoForm.coOptionPantsWashableInfo.wpBtnMateStkNo}");
		jQuery("#wp_btnMateStkNo").change();
		if(ojBtnMatePtFlag=="1"){
			 jQuery("#ojBtnMatePtFlag").val("0");
		}
	}
	
}
function optionPants1ChangeModel(productCategory){
	var pantsFlag = jQuery("#pantsFlag").val();
	 if(pantsFlag == "1"){
		if(productCategory == "9000101"){
			var opPantsModel = jQuery("#op_pantsModel").val();
			if(isEmpty(opPantsModel)){
				return;
			}
				//タック
				var tackElem = jQuery('#op_tack');

				// タックの選択肢更新
				tackElem.empty();
				var tmpTack = null;
				for (tmpTack of tackList[opPantsModel].activeList) {
					tackElem.append(jQuery('<option />').val(tmpTack.val).text(tmpTack.text));
				}

				var opTack = "${orderCoForm.coOptionPantsStandardInfo.opTack}";
				tackElem.val(opTack);
				tackElem.change();

				//膝裏
				jQuery('input[name="coOptionPantsStandardInfo.opKneeBack"]').val(["${orderCoForm.coOptionPantsStandardInfo.opKneeBack}"]);

				var opKneeBack = "${orderCoForm.coOptionPantsStandardInfo.opKneeBack}";
				if(opKneeBack != '0000202'){
					//膝裏素材
					jQuery('input[name="coOptionPantsStandardInfo.opKneeBackMate"]').val(["${orderCoForm.coOptionPantsStandardInfo.opKneeBackMate}"]);
				}
				else {
					jQuery('#op_kneeBackMate_div').hide();
				}

				//フロント仕様
				jQuery('input[name="coOptionPantsStandardInfo.opFrontSpec"]').val(["${orderCoForm.coOptionPantsStandardInfo.opFrontSpec}"]);
				
				//アジャスター仕様
				var selectedAdjuster = jQuery('input[name="coOptionPantsStandardInfo.opAdjuster"]:checked').val();
				// アジャスター仕様の選択肢制御
				var beforeAdjuster = false;
				jQuery('input[id^="op_adjuster_"]').each(function() {
					var tmpOpAdjusterElem = jQuery(this);
					var value = tmpOpAdjusterElem.val();
		
					if (adjusterList[opPantsModel].activeList.indexOf(value) != -1) {
						// 有効なアジャスター仕様の場合、有効化
						tmpOpAdjusterElem.prop("disabled", false);
						if (selectedAdjuster == value) {
							beforeAdjuster = true;	
						}
					} else {
						// 有効なアジャスター仕様ではない場合、無効化
						tmpOpAdjusterElem.prop("disabled", true);
					}
				});

				//アジャスター仕様
				jQuery('input[name="coOptionPantsStandardInfo.opAdjuster"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAdjuster}"]);

				//ベルトループ
				jQuery('input[name="coOptionPantsStandardInfo.opBeltLoop"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoop}"]);
				jQuery('input[id^="op_beltLoop_id"]:checked').change();
				
				//ピンループ
				jQuery('input[name="coOptionPantsStandardInfo.opPinLoop"]').val(["${orderCoForm.coOptionPantsStandardInfo.opPinLoop}"]);
				jQuery('input[id^="op_pinLoop_id"]:checked').change();
								
				//脇ポケット	
				jQuery('input[name="coOptionPantsStandardInfo.opSidePkt"]').val(["${orderCoForm.coOptionPantsStandardInfo.opSidePkt}"]);
				
				//忍びポケット
				jQuery('input[name="coOptionPantsStandardInfo.opSinobiPkt"]').val(["${orderCoForm.coOptionPantsStandardInfo.opSinobiPkt}"]);

				//フラップ付コインポケット
				jQuery('input[name="coOptionPantsStandardInfo.opFlapCoinPkt"]').val(["${orderCoForm.coOptionPantsStandardInfo.opFlapCoinPkt}"]);

				//上前ピスポケット
				jQuery('input[name="coOptionPantsStandardInfo.opPisPktUf"]').val(["${orderCoForm.coOptionPantsStandardInfo.opPisPktUf}"]);

				//下前ピスポケット 
				jQuery('input[name="coOptionPantsStandardInfo.opPisPktDf"]').val(["${orderCoForm.coOptionPantsStandardInfo.opPisPktDf}"]);

				//Vカット
	            jQuery('input[name="coOptionPantsStandardInfo.opVCut"]').val(["${orderCoForm.coOptionPantsStandardInfo.opVCut}"]);

				//ステッチ種類 
				jQuery('input[name="coOptionPantsStandardInfo.opStitch"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitch}"]);
				jQuery('input[id^="op_stitch_id"]:checked').change();
				
				
		}else if(productCategory == "9000102"){
			var tpPantsModel = jQuery("#tp_pantsModel").val();
			if(isEmpty(tpPantsModel)){
               return;
			}
			// 選択中のフロント釦数
			var tackElem = jQuery('#tp_tack');

			// タックの選択肢更新
			tackElem.empty();
			var tmpTack = null;
			for (tmpTack of tackList[tpPantsModel].activeList) {
				tackElem.append(jQuery('<option />').val(tmpTack.val).text(tmpTack.text));
			}

			var tjTack = "${orderCoForm.coOptionPantsTuxedoInfo.tpTack}";
			tackElem.val(tjTack);
			tackElem.change();

			//膝裏
			jQuery('input[name="coOptionPantsTuxedoInfo.tpKneeBack"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpKneeBack}"]);

			var tpKneeBack = "${orderCoForm.coOptionPantsTuxedoInfo.tpKneeBack}";
			if(tpKneeBack != '0000202'){
				//膝裏素材
				jQuery('input[name="coOptionPantsTuxedoInfo.tpKneeBackMate"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpKneeBackMate}"]);
			}
			else {
				jQuery('#tp_kneeBackMate_div').hide();
			}
			//フロント仕様
			jQuery('input[name="coOptionPantsTuxedoInfo.tpFrontSpec"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpFrontSpec}"]);

			//パンチェリーナ
			jQuery('input[name="coOptionPantsTuxedoInfo.tpPancherina"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPancherina}"]);

			// 選択中のアジャスター仕様
			var selectedAdjuster = jQuery('input[name="coOptionPantsTuxedoInfo.tpAdjuster"]:checked').val();

			// アジャスター仕様の選択肢制御
			jQuery('input[id^="tp_adjuster_"]').each(function() {
				var tmpTpAdjusterElem = jQuery(this);
				var value = tmpTpAdjusterElem.val();

				if (adjusterList[tpPantsModel].activeList.indexOf(value) != -1) {
					// 有効なアジャスター仕様の場合、有効化
					tmpTpAdjusterElem.prop("disabled", false);
				} else {
					// 有効なアジャスター仕様ではない場合、無効化
					tmpTpAdjusterElem.prop("disabled", true);
				}
			});
			//アジャスター仕様
			jQuery('input[name="coOptionPantsTuxedoInfo.tpAdjuster"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpAdjuster}"]);

			//ベルトループ
			jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoop"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoop}"]);
			jQuery('input[id^="tp_beltLoop_id"]:checked').change();
			
			//ピンループ
			jQuery('input[name="coOptionPantsTuxedoInfo.tpPinLoop"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPinLoop}"]);
			jQuery('input[id^="tp_pinLoop_id"]:checked').change();
			
			//脇ポケット
			jQuery('input[name="coOptionPantsTuxedoInfo.tpSidePkt"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpSidePkt}"]);

			//忍びポケット
			jQuery('input[name="coOptionPantsTuxedoInfo.tpSinobiPkt"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpSinobiPkt}"]);

			//フラップ付コインポケット
			jQuery('input[name="coOptionPantsTuxedoInfo.tpFlapCoinPkt"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpFlapCoinPkt}"]);

			//上前ピスポケット
			jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktUf"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPisPktUf}"]);

			//下前ピスポケット
			jQuery('input[name="coOptionPantsTuxedoInfo.tpPisPktDf"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPisPktDf}"]);

			//Vカット
			jQuery('input[name="coOptionPantsTuxedoInfo.tpVCut"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpVCut}"]);

			// 側章
			var tpSideStripe = "${orderCoForm.coOptionPantsTuxedoInfo.tpSideStripe}";
			if(tpSideStripe == "0003901"){
				jQuery('#tp_sideStripe_yes_area').hide();
			}
			var tpSideStripeWidth = "${orderCoForm.coOptionPantsTuxedoInfo.tpSideStripeWidth}";
			if(tpSideStripeWidth == "" || tpSideStripeWidth == null){
				jQuery('input[name="coOptionPantsTuxedoInfo.tpSideStripeWidth"]').val(["0004001"]);
			}
			
		}else if(productCategory == "9000103"){
			var wpPantsModel = jQuery("#wp_pantsModel").val();
			if(isEmpty(wpPantsModel)){
               return; 
			}
			// 選択中のタック
			var tackElem = jQuery('#wp_tack');

			// タックの選択肢更新
			tackElem.empty();
			var tmpTack = null;
			for (tmpTack of tackList[wpPantsModel].activeList) {
				tackElem.append(jQuery('<option />').val(tmpTack.val).text(tmpTack.text));
			}
			
			var wjTack = "${orderCoForm.coOptionPantsWashableInfo.wpTack}";
			tackElem.val(wjTack);
			tackElem.change();

			//膝裏
			jQuery('input[name="coOptionPantsWashableInfo.wpKneeBack"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpKneeBack}"]);

			var wpKneeBack = "${orderCoForm.coOptionPantsWashableInfo.wpKneeBack}";
			if(wpKneeBack != '0000202'){
				//膝裏素材
				jQuery('input[name="coOptionPantsWashableInfo.wpKneeBackMate"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpKneeBackMate}"]);
			}
			else {
				jQuery('#wp_kneeBackMate_div').hide();
			}
			
			//フロント仕様
			jQuery('input[name="coOptionPantsWashableInfo.wpFrontSpec"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpFrontSpec}"]);
			
			//パンチェリーナ
			jQuery('input[name="coOptionPantsWashableInfo.wpPancherina"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpPancherina}"]);

			// 選択中のアジャスター仕様
			var selectedAdjuster = jQuery('input[name="coOptionPantsWashableInfo.wpAdjuster"]:checked').val();

			// アジャスター仕様の選択肢制御
			jQuery('input[id^="wp_adjuster_"]').each(function() {
				var tmpWpAdjusterElem = jQuery(this);
				var value = tmpWpAdjusterElem.val();

				if (adjusterList[wpPantsModel].activeList.indexOf(value) != -1) {
					// 有効なアジャスター仕様の場合、有効化
					tmpWpAdjusterElem.prop("disabled", false);
				} else {
					// 有効なアジャスター仕様ではない場合、無効化
					tmpWpAdjusterElem.prop("disabled", true);
				}
			});
			//アジャスター仕様
			jQuery('input[name="coOptionPantsWashableInfo.wpAdjuster"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAdjuster}"]);

			//ベルトループ
			jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoop"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoop}"]);
			jQuery('input[id^="wp_beltLoop_id"]:checked').change();
			
			//ピンループ
			jQuery('input[name="coOptionPantsWashableInfo.wpPinLoop"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpPinLoop}"]);
			jQuery('input[id^="wp_pinLoop_id"]:checked').change();
			
			//脇ポケット
			jQuery('input[name="coOptionPantsWashableInfo.wpSidePkt"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpSidePkt}"]);

			//忍びポケット
			jQuery('input[name="coOptionPantsWashableInfo.wpSinobiPkt"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpSinobiPkt}"]);

			//フラップ付コインポケット
			jQuery('input[name="coOptionPantsWashableInfo.wpFlapCoinPkt"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpFlapCoinPkt}"]);

			//上前ピスポケット
			jQuery('input[name="coOptionPantsWashableInfo.wpPisPktUf"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpPisPktUf}"]);

			//下前ピスポケット 
			jQuery('input[name="coOptionPantsWashableInfo.wpPisPktDf"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpPisPktDf}"]);

			//Vカット
			jQuery('input[name="coOptionPantsWashableInfo.wpVCut"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpVCut}"]);

			//ステッチ種類
			jQuery('input[name="coOptionPantsWashableInfo.wpStitch"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitch}"]);

		}
	} 
}
jQuery("#op_pantsModel,#tp_pantsModel,#wp_pantsModel,#op_tack,#tp_tack,#wp_tack").change(function(){
	if("orderCo"==orderFlag){
		pantsAdFlag="0";	
	}else if("1"==jQuery("#pantsItemFlag").val()){
		if("orderCo"!=orderFlag ){
			pantsAdFlag="0";
		}
	}
})
if (document.readyState=="complete")  
{  
        $.unblockUI();
}  
else  
{  
        document.onreadystatechange = function()  
        {  
             
                if (document.readyState == "complete")  
                {  
                        $.unblockUI();   
                }  
        }  
}
</script>