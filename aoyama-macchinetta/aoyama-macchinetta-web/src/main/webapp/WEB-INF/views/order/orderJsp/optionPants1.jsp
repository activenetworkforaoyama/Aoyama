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
                            <div class="col-12 col-md-6" align="right">
                            	<output id="op_pantsModel_Msg" ></output>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_pantsModelMsg"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="op_pantsModelCheck" style="margin-top:8px"></div>
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
                            <div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
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
                            <div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
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
                            <div class="col-12 col-md-9 offset-md-3" id="tp_pantsModelMsg"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp_pantsModelCheck" style="margin-top:8px"></div>
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
                            <div class="col-12 col-md-2" id="tp_flapCoinPkt_Msg" align="right"></div>
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
                            <div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
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
                             <div class="col-12 col-md-6" align="right">
                            	<output id="wp_pantsModel_Msg" ></output>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_pantsModelMsg"   style="margin-top:8px"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp_pantsModelCheck" style="margin-top:8px"></div>
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
                            <div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
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
                            <div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
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
            
            <input type="hidden" id="pantsFlag" name="pantsFlag" value="0"/>
            <input type="hidden" id="pantsItemFlag" name="pantsItemFlag" value="0"/>
            <input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="${orderCoForm.jacketItemFlag }"/>
			<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="${orderCoForm.giletItemFlag }"/>
			<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="${orderCoForm.shirtItemFlag }"/>
			<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="${orderCoForm.coatItemFlag }"/>
			<input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="${orderCoForm.pants2ItemFlag }"/>
            <input type="hidden" id="pantsAdFlag" name="pantsAdFlag" value="${orderCoForm.pantsAdFlag }" />     
            <input type="hidden" id="jacketAdFlag" name="jacketAdFlag" value="${orderCoForm.jacketAdFlag }" />
            <input type="hidden" id="coatAdFlag" name="coatAdFlag" value="${orderCoForm.coatAdFlag }" />
            <input type="hidden" id="giletAdFlag" name="giletAdFlag" value="${orderCoForm.giletAdFlag }" />
            <input type="hidden" id="pants2AdFlag" name="pants2AdFlag" value="${orderCoForm.pants2AdFlag }" />
            <input type="hidden" id="shirtAdFlag" name="shirtAdFlag" value="${orderCoForm.shirtAdFlag }" />
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
<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";

jQuery(function() {
	var pantsAdFlag="${orderCoForm.pantsAdFlag}";
	if(pantsAdFlag=="1"){		
	}else{
		jQuery("#pantsAdFlag").val("0");
	}
	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });
	var productCategory="${orderCoForm.productCategory}";
	mateInit();
	setPantsModelDisable(productCategory);
	initCommon();
	initTabMenu();
	initCustomer();
	initProduct();
		if(productCategory=="9000101"){
			initOptionPants1Standard();
			if("${orderCoForm.pantsItemFlag }"=="1"){
				opSession();
				}
			 getPrice();
			 showPrice();
		}else if(productCategory=="9000102"){
			initOptionPants1Tuxedo();
			if("${orderCoForm.pantsItemFlag }"=="1"){
				tpSession();
				}
			
			 getTuPrice();
			 showPrice();
		}else if(productCategory=="9000103"){
			initOptionPants1Washable();
			if("${orderCoForm.pantsItemFlag }"=="1"){
				wpSession();
				}
			 getWaPrice();
			 showPrice();
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
			optionCode = selectStandardIdList[idValue];
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
			optionCode = selectTuxedoIdList[idValue];
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




function showPrice(){
	var opPantsModel = jQuery("#op_pantsModel option:selected").val();
	if(isNotEmpty(opPantsModel)){
		jQuery("#op_pantsModel").change();
	}
}
//--------------------------------------------
//全部のitem金額制御
//--------------------------------------------
function getPrice(){
	//opPantsModelの料金を表示
	var opPantsModel = "";
	jQuery("#op_pantsModel,#op_tack").change(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		opPantsModel = jQuery("#op_pantsModel option:selected").val();
	    var itemCode = jQuery("#item").val();
	    var subItemCode = "03";
	    var code = itemCode + subItemCode + opPantsModel;
	    jQuery.ajax({
	    	type:"get",
		    url:contextPath + "/orderCo/getOrderPriceForPantsModel",
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
	    
	var opPantsModel = "";
	//プルダウンの変更処理
	//項目：タック、コインポケット、裾上げ、釦素材、釦素材品番
	jQuery("#op_tack,#op_coinPkt,#op_hemUp,#op_btnMate,#op_btnMateStkNo")
	   .change(function(){
	   jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
	   opPantsModel = jQuery("#op_pantsModel option:selected").val();
	   var itemCode = jQuery("#item").val();
	   var subItemCode = "03"
	   var idValueName = jQuery(this).attr("id");
	   var price;
	   if(isNotEmpty(opPantsModel)){
		   var code = itemCode + subItemCode + opPantsModel;
		   jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/getOrderPriceForPantsSProject",
			    data:{"code":code,"idValue":idValueName},
			    dataType:"json",
			    async:false,
			    success:function(result){
			    	if(jQuery("#"+idValueName+"_Msg").length>0){
			    		if(result.idValuePrice == "0"){
							price = "無料"
				         }else{
				        	price = formatMoney(result.idValuePrice,0,"￥");
					     }
			             jQuery("#"+idValueName+"_Msg").html(price);
			             jQuery("#optionPrice").html(result.optionPrice);
			        }else{
			             var lengthforLastFive = idValueName.length - 5;
			             var idValueTemp = idValueName.substring(0,lengthforLastFive);
			             if(result.idValuePrice == "0"){
							price = "無料"
				         }else{
				        	price = formatMoney(result.idValuePrice,0,"￥");
					     }
			             jQuery("#"+idValueTemp+"_Msg").html(price);
			             jQuery("#optionPrice").html(result.optionPrice);
			             getAllPrice(itemCode, result.optionPrice);
			             allOptionPrice();
			        }		    
			   }
	        });
		}
	});
	//ラジオボタンの変更処理
	//項目：膝裏、膝裏素材、フロント仕様、パンチェリーナ、アジャスター仕様、ベルトループ、ピンループ、脇ポケット、忍びポケット、フラップ付コインポケット、上前ピスポケット、下前ピスポケット、Vカット、ステッチ種類、ステッチ箇所変更、ダブルステッチ、AMF色指定、ボタンホール色指定、ボタン付け糸指定.サスペンダー釦.シック大（股補強）,エイト（滑り止め）,形状記憶
	jQuery('input[id^="op_kneeBack_id"],[id^="op_kneeBackMate_id"],[id^="op_frontSpec_id"],[id^="chainHange_id"],[id^="op_pancherina_id"],[id^="op_adjuster_id"],[id^="op_beltLoop_id"],[id^="op_pinLoop_id"],[id^="op_sidePkt_id"],[id^="op_sinobiPkt_id"],[id^="op_flapCoinPkt_id"],[id^="op_pisPktUf_id"],[id^="op_pisPktDf_id"],[id^="op_vCut_id"],[id^="op_stitch_id"],[id^="op_stitchModify_id"],[id^="op_amfColor_id"],[id^="op_bhColor_id"],[id^="op_byColor_id"],[id^="op_suspenderBtn_id"],[id^="op_thick_id"],[id^="op_eight_id"],[id^="op_shapeMemory_id"]')
	.change(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		opPantsModel = jQuery("#op_pantsModel option:selected").val();
		var itemCode = jQuery("#item").val();
	    var subItemCode = "03";
	    var idValueName = jQuery(this).attr("id");
	    var price;
	  	//IDの後の番号を削除します
	    var findIdPosition = idValueName.indexOf("_id");
	    var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
		    
		if(isNotEmpty(opPantsModel)){
			var code = itemCode + subItemCode + opPantsModel;
			jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/getOrderPriceForPantsSProject",
			    data:{"code":code,"idValue":interceptedIdValueName},
			    async:false,
			    success:function(result){
			    	var msgIdValueName = interceptedIdValueName.replace(/_id/,"_Msg");
			    	if(result.idValuePrice == "0"){
						price = "無料"
			         }else{
			        	price = formatMoney(result.idValuePrice,0,"￥");
				     }
			        jQuery("#"+msgIdValueName).html(price);
			        jQuery("#optionPrice").html(result.optionPrice);
			        getAllPrice(itemCode, result.optionPrice);
			        allOptionPrice();
			   }
	        });
		}
	});
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
  return symbol + negative + (j ? i.substr(0, j) + thousand : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + thousand) + (places ? decimal + Math.abs(number - i).toFixed(places).slice(2) : "");
}

function getAllPrice(subItemCode, optionPrice){
	jQuery("#jkOptionPriceId").val(optionPrice);
    var jkOptionPriceId = optionPrice;
    var ptOptionPriceId = jQuery("#ptOptionPriceId").val();
    var pt2OptionPriceId = jQuery("#pt2OptionPriceId").val();
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

function getTuPrice(){
	//opPantsModelの料金を表示
	var opPantsModel = "";
	jQuery("#tp_pantsModel,#tp_tack").change(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		opPantsModel = jQuery("#tp_pantsModel option:selected").val();
	    var itemCode = jQuery("#item").val();
	    var subItemCode = "03";
	    var code = itemCode + subItemCode + opPantsModel;
	    jQuery.ajax({
	    	type:"get",
		    url:contextPath + "/orderCo/getOrderPriceForPantsTuModel",
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
	    
	var tpPantsModel = "";
	//プルダウンの変更処理
	//項目：タック、コインポケット、裾上げ、釦素材、釦素材品番
	jQuery("#tp_tack,#tp_coinPkt,#tp_hemUp,#tp_btnMate,#tp_btnMateStkNo")
	   .change(function(){
	   jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
	   tpPantsModel = jQuery("#tp_pantsModel option:selected").val();
	   var itemCode = jQuery("#item").val();
	   var subItemCode = "03"
	   var idValueName = jQuery(this).attr("id");
	   var price;
	   if(isNotEmpty(tpPantsModel)){
		   var code = itemCode + subItemCode + tpPantsModel;
		   jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/getOrderPriceForPantsSTuProject",
			    data:{"code":code,"idValue":idValueName},
			    dataType:"json",
			    async:false,
			    success:function(result){
			    	if(jQuery("#"+idValueName+"_Msg").length>0){
			    		if(result.idValuePrice == "0"){
							price = "無料"
				         }else{
				        	price = formatMoney(result.idValuePrice,0,"￥");
					     }
			             jQuery("#"+idValueName+"_Msg").html(price);
			             jQuery("#optionPrice").html(result.optionPrice);
			        }else{
			             var lengthforLastFive = idValueName.length - 5;
			             var idValueTemp = idValueName.substring(0,lengthforLastFive);
			             if(result.idValuePrice == "0"){
							price = "無料"
				         }else{
				        	price = formatMoney(result.idValuePrice,0,"￥");
					     }
			             jQuery("#"+idValueTemp+"_Msg").html(price);
			             jQuery("#optionPrice").html(result.optionPrice);
			             getAllPrice(itemCode, result.optionPrice);
			             allOptionPrice();
			        }		    
			   }
	        });
		}
	});
	//ラジオボタンの変更処理
	//項目：膝裏、膝裏素材、フロント仕様、パンチェリーナ、アジャスター仕様、ベルトループ、ピンループ、脇ポケット、忍びポケット、コインポケット，フラップ付コインポケット、上前ピスポケット、下前ピスポケット、Vカット、ステッチ種類，ボタンホール色指定、ボタン付け糸指定.サスペンダー釦.シック大（股補強）,エイト（滑り止め）,形状記憶，側章，側章幅
	jQuery('input[id^="tp_kneeBack_id"],[id^="tp_kneeBackMate_id"],[id^="tp_frontSpec_id"],[id^="tp_pancherina_id"],[id^="tp_adjuster_id"],[id^="tp_beltLoop_id"],[id^="tp_pinLoop_id"],[id^="tp_sidePkt_id"],[id^="tp_sinobiPkt_id"],[id^="tp_flapCoinPkt_id"],[id^="tp_pisPktUf_id"],[id^="tp_pisPktDf_id"],[id^="tp_vCut_id"],[id^="tp_stitch_id"],[id^="tp_bhColor_id"],[id^="tp_byColor_id"],[id^="tp_suspenderBtn_id"],[id^="tp_thick_id"],[id^="tp_eight_id"],[id^="tp_shapeMemory_id"],[id^="tp_sideStripe_id"],[id^="tp_sideStripeWidth_id"]')
	.change(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		opPantsModel = jQuery("#tp_pantsModel option:selected").val();
		var itemCode = jQuery("#item").val();
	    var subItemCode = "03";
	    var idValueName = jQuery(this).attr("id");
	    var price;
	  	//IDの後の番号を削除します
	    var findIdPosition = idValueName.indexOf("_id");
	    var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
		    
		if(isNotEmpty(opPantsModel)){
			var code = itemCode + subItemCode + opPantsModel;
			jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/getOrderPriceForPantsSTuProject",
			    data:{"code":code,"idValue":interceptedIdValueName},
			    async:false,
			    success:function(result){
			    	var msgIdValueName = interceptedIdValueName.replace(/_id/,"_Msg");
			    	if(result.idValuePrice == "0"){
						price = "無料"
			         }else{
			        	price = formatMoney(result.idValuePrice,0,"￥");
				     }
			        jQuery("#"+msgIdValueName).html(price);
			        jQuery("#optionPrice").html(result.optionPrice);
			        getAllPrice(itemCode, result.optionPrice);
			        allOptionPrice();
			   }
	        });
		}
	});
}




function getWaPrice(){
	//opPantsModelの料金を表示
	var wpPantsModel = "";
	jQuery("#wp_pantsModel,#wp_tack").change(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		opPantsModel = jQuery("#wp_pantsModel option:selected").val();
	    var itemCode = jQuery("#item").val();
	    var subItemCode = "03";
	    var code = itemCode + subItemCode + wpPantsModel;
	    jQuery.ajax({
	    	type:"get",
		    url:contextPath + "/orderCo/getOrderPriceForPantsWPModel",
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
	    
	var wpPantsModel = "";
	//プルダウンの変更処理
	//項目：タック、コインポケット、裾上げ、釦素材、釦素材品番
	jQuery("#wp_tack,#wp_coinPkt,#wp_hemUp,#wp_btnMate,#wp_btnMateStkNo")
	   .change(function(){
	   jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
	   tpPantsModel = jQuery("#wp_pantsModel option:selected").val();
	   var itemCode = jQuery("#item").val();
	   var subItemCode = "03"
	   var idValueName = jQuery(this).attr("id");
	   var price;
	   if(isNotEmpty(tpPantsModel)){
		   var code = itemCode + subItemCode + tpPantsModel;
		   jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/getOrderPriceForPantsSWPProject",
			    data:{"code":code,"idValue":idValueName},
			    dataType:"json",
			    async:false,
			    success:function(result){
			    	if(jQuery("#"+idValueName+"_Msg").length>0){
			    		if(result.idValuePrice == "0"){
							price = "無料"
				         }else{
				        	price = formatMoney(result.idValuePrice,0,"￥");
					     }
			             jQuery("#"+idValueName+"_Msg").html(price);
			             jQuery("#optionPrice").html(result.optionPrice);
			        }else{
			             var lengthforLastFive = idValueName.length - 5;
			             var idValueTemp = idValueName.substring(0,lengthforLastFive);
			             if(result.idValuePrice == "0"){
							price = "無料"
				         }else{
				        	price = formatMoney(result.idValuePrice,0,"￥");
					     }
			             jQuery("#"+idValueTemp+"_Msg").html(price);
			             jQuery("#optionPrice").html(result.optionPrice);
			             getAllPrice(itemCode, result.optionPrice);
			             allOptionPrice();
			        }		    
			   }
	        });
		}
	});
	//ラジオボタンの変更処理
	//項目：膝裏、膝裏素材、フロント仕様、パンチェリーナ、アジャスター仕様、ベルトループ、ピンループ、脇ポケット、忍びポケット、コインポケット，フラップ付コインポケット、上前ピスポケット、下前ピスポケット、Vカット、ステッチ種類，ステッチ箇所変更,ダブルステッチ,AMF色指定,ボタンホール色指定、ボタン付け糸指定..,サスペンダー釦.エイト（滑り止め）,シック大（股補強）,形状記憶
	jQuery('input[id^="wp_kneeBack_id"],[id^="wp_kneeBackMate_id"],[id^="wp_frontSpec_id"],[id^="wp_pancherina_id"],[id^="wp_adjuster_id"],[id^="wp_beltLoop_id"],[id^="wp_pinLoop_id"],[id^="wp_sidePkt_id"],[id^="wp_sinobiPkt_id"],[id^="wp_flapCoinPkt_id"],[id^="wp_pisPktUf_id"],[id^="wp_pisPktDf_id"],[id^="wp_vCut_id"],[id^="wp_stitch_id"],[id^="wp_stitchModify_id"],[id^="wp_dStitch_id"],[id^="wp_amfColor_id"],[id^="wp_bhColor_id"],[id^="wp_byColor_id"],[id^="wp_suspenderBtn_id"],[id^="wp_eight_id"],[id^="wp_thick_id"],[id^="wp_shapeMemory_id"]')
	.change(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		wpPantsModel = jQuery("#wp_pantsModel option:selected").val();
		var itemCode = jQuery("#item").val();
	    var subItemCode = "03";
	    var idValueName = jQuery(this).attr("id");
	    var price;
	  	//IDの後の番号を削除します
	    var findIdPosition = idValueName.indexOf("_id");
	    var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
		    
		if(isNotEmpty(opPantsModel)){
			var code = itemCode + subItemCode + wpPantsModel;
			jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/getOrderPriceForPantsSWPProject",
			    data:{"code":code,"idValue":interceptedIdValueName},
			    async:false,
			    success:function(result){
			    	var msgIdValueName = interceptedIdValueName.replace(/_id/,"_Msg");
			    	if(result.idValuePrice == "0"){
						price = "無料"
			         }else{
			        	price = formatMoney(result.idValuePrice,0,"￥");
				     }
			        jQuery("#"+msgIdValueName).html(price);
			        jQuery("#optionPrice").html(result.optionPrice);
			        getAllPrice(itemCode, result.optionPrice);
			        allOptionPrice();
			   }
	        });
		}
	});
}




function  opSession(){

	//コインポケット
	jQuery("#op_coinPkt").val("${orderCoForm.coOptionPantsStandardInfo.opCoinPkt}");
	jQuery("#op_coinPkt").change();

	//裾上げ
	jQuery('#op_hemUp').val("${orderCoForm.coOptionPantsStandardInfo.opHemUp}");
	jQuery('#op_hemUp').change();
	
	//ベルトループ
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoop"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoop}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoop"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace1"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace2"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace3"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace4}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace4"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace5"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace5}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace5"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace6"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace6}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace6"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace7"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace7}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBeltLoopPlace7"]').change();

	//ステッチ箇所変更
	jQuery('input[name="coOptionPantsStandardInfo.opStitchModify"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModify}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opStitchModify"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace1"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace2"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace3"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace4}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opStitchModifyPlace4"]').change();

	//ダブルステッチ
	jQuery('input[name="coOptionPantsStandardInfo.op2DStitch"]').val(["${orderCoForm.coOptionPantsStandardInfo.opDStitch}"]);
	jQuery('input[name="coOptionPantsStandardInfo.op2DStitch"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.op2DStitchPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opDStitchPlace1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.op2DStitchPlace1"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opDStitchPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opDStitchPlace2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opDStitchPlace2"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opDStitchPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opDStitchPlace3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opDStitchPlace3"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opDStitchPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opDStitchPlace4}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opDStitchPlace4"]').change();	

	//AMF色指定
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor"]').change();

	jQuery("#op_amfColorPlaceAll").val("${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlaceAll}");
	jQuery("#op_amfColorPlaceAll").change();

	jQuery('input[name="coOptionPantsStandardInfo.opAmfColorPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColorPlace1"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opAmfColorPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColorPlace2"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opAmfColorPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColorPlace3"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opAmfColorPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace4}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColorPlace4"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor1"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor2"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor3"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor4}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opAmfColor4"]').change();

	//ボタンホール色指定
	jQuery('input[name="coOptionPantsStandardInfo.opBhColor"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColor"]').change();

	jQuery("#op_bhColorPlaceAll").val("${orderCoForm.coOptionPantsStandardInfo.opBhColorPlaceAll}");
	jQuery("#op_bhColorPlaceAll").change();

	jQuery('input[name="coOptionPantsStandardInfo.opBhColorPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColorPlace1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColorPlace1"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBhColorPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColorPlace2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColorPlace2"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBhColorPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColorPlace3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColorPlace3"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBhColorPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColorPlace4}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColorPlace4"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBhColor1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColor1"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBhColor2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColor2"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBhColor3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColor3"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opBhColor4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor4}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opBhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="coOptionPantsStandardInfo.opByColor"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColor"]').change();
	
	jQuery("#op_byColorPlaceAll").val("${orderCoForm.coOptionPantsStandardInfo.opByColorPlaceAll}");
	jQuery("#op_byColorPlaceAll").change();

	jQuery('input[name="coOptionPantsStandardInfo.opByColorPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColorPlace1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColorPlace1"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opByColorPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColorPlace2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColorPlace2"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opByColorPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColorPlace3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColorPlace3"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opByColorPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColorPlace4}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColorPlace4"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opByColor1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor1}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColor1"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opByColor2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor2}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColor2"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opByColor3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor3}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColor3"]').change();

	jQuery('input[name="coOptionPantsStandardInfo.opByColor4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor4}"]);
	jQuery('input[name="coOptionPantsStandardInfo.opByColor4"]').change();

	//釦素材
	//jQuery('#op_btnMate').val("${orderCoForm.coOptionPantsStandardInfo.opButton}");
	//jQuery('#op_btnMate').change();
   if(isNotEmpty("${orderCoForm.coOptionPantsStandardInfo.opBtnMateStkNo}")){
	  jQuery('#op_btnMateStkNo').val("${orderCoForm.coOptionPantsStandardInfo.opBtnMateStkNo}");
	   jQuery('#op_btnMateStkNo').change();
   }
	
}

function  tpSession(){

	//コインポケット
	jQuery("#tp_coinPkt").val("${orderCoForm.coOptionPantsTuxedoInfo.tpCoinPkt}");
	jQuery("#tp_coinPkt").change();

	//裾上げ
	jQuery("#tp_hemUp").val("${orderCoForm.coOptionPantsTuxedoInfo.tpHemUp}");
	jQuery("#tp_hemUp").change();

   //ベルトループ 
    jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoop"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoop}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoop"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace1}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace1"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace2}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace2"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace3}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace3"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace4}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace4"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace5"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace5}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace5"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace6"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace6}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace6"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace7"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace7}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBeltLoopPlace7"]').change();

	//ステッチ種類
	jQuery('input[name="coOptionPantsTuxedoInfo.tpStitch"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpStitch}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpStitch"]').change();
	//ボタンホール色指定
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColorPlace1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlace1}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColorPlace1"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColorPlace2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlace2}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColorPlace2"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColorPlace3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlace3}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColorPlace3"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColorPlace4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlace4}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColorPlace4"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor1}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor1"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor2}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor2"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor3}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor3"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor4}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpBhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor"]').change();
	jQuery("#tp_byColorPlaceAll").val("${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlaceAll}");
	jQuery("#tp_byColorPlaceAll").change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColorPlace1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlace1}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColorPlace1"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColorPlace2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlace2}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColorPlace2"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColorPlace3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlace3}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColorPlace3"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColorPlace4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlace4}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColorPlace4"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor1}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor1"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor2}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor2"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor3}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor3"]').change();

	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor4}"]);
	jQuery('input[name="coOptionPantsTuxedoInfo.tpByColor4"]').change();
	if(isNotEmpty("${orderCoForm.coOptionPantsTuxedoInfo.tpBtnMateStkNo}")){
		jQuery("#tp_btnMateStkNo").val("${orderCoForm.coOptionPantsTuxedoInfo.tpBtnMateStkNo}");
		jQuery("#tp_btnMateStkNo").change();
		}
}
function  wpSession(){

	//ベルトループ
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoop"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoop}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoop"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace1"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace2"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace3"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace4"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace5"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace5}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace5"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace6"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace6}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace6"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace7"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace7}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBeltLoopPlace7"]').change();

	//ステッチ種類
	jQuery('input[name="coOptionPantsWashableInfo.wpStitch"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitch}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpStitch"]').change();
	//ステッチ箇所変更
	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModify"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModify}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModify"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlace1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace1"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlace2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace2"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlace3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace3"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlace4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpStitchModifyPlace4"]').change();
	
	//ダブルステッチ
	jQuery('input[name="coOptionPantsWashableInfo.wpDStitch"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitch}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpDStitch"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpDStitchPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlace1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpDStitchPlace1"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpDStitchPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlace2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpDStitchPlace2"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpDStitchPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlace3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpDStitchPlace3"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpDStitchPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlace4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpDStitchPlace4"]').change();

	//AMF色指定
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColorPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlace1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColorPlace1"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColorPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlace2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColorPlace2"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColorPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlace3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColorPlace3"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColorPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlace4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColorPlace4"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor1"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor2"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor3"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpAmfColor4"]').change();

	//ボタンホール色指定
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace1"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace2"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace3"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace4"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColorPlace4"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor1"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor2"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor3"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpBhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="coOptionPantsWashableInfo.wpByColor"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColor"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpByColorPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColorPlace1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColorPlace1"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpByColorPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColorPlace2}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColorPlace2"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpByColorPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColorPlace3}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColorPlace3"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpByColorPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColorPlace4}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColorPlace4"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpByColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColor1"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpByColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColor1"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpByColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColor1"]').change();

	jQuery('input[name="coOptionPantsWashableInfo.wpByColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="coOptionPantsWashableInfo.wpByColor1"]').change();

	if(isNotEmpty("${orderCoForm.coOptionPantsWashableInfo.wpBtnMateStkNo}")){
		jQuery("#wp_btnMateStkNo").val("${orderCoForm.coOptionPantsWashableInfo.wpBtnMateStkNo}");
		jQuery("#wp_btnMateStkNo").change();
	}
	
}
jQuery("#op_pantsModel,#tp_pantsModel,wp_pantsModel").change(function(){
	jQuery("#pantsAdFlag").val("0");
})   
</script>