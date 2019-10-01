<form:form id="idInfoForm" action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm" method="post" modelAttribute="orderCoForm" class="form-horizontal">
<div id="op2_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS（2本目）</strong>　　<button type="button" class="btn btn-outline-info btn-sm" id="btn_op2_samePants">1本目と同じ</button>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSモデル</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_pantsModel"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op2_pantsModel" path="coOptionPants2StandardInfo.op2PantsModel" class="form-control-sm form-control">
                               <form:options items="${orderCoForm.coOptionPants2StandardInfo.op2PantsModelMap}"/>
                                </form:select>
                            </div>
                         
                             <div class="col-12 col-md-9 offset-md-3" id="op2_pantsModelMsg" style="margin-top:8px"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_pantsModelCheck" style="display:none"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                                <form:select id="op2_tack" path="coOptionPants2StandardInfo.op2Tack" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPants2StandardInfo.op2TackMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="op2_tack_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_kneeBack"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                     <form:radiobuttons id="op2_kneeBack_id" path="coOptionPants2StandardInfo.op2KneeBack" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2KneeBackMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="op2_kneeBack_Msg">
                            </div>
                        </div>
                        <div class="row form-group" id="op2_kneeBackMate_div">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_kneeBackMate_id" path="coOptionPants2StandardInfo.op2KneeBackMate" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2KneeBackMateMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="op2_kneeBackMate_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント仕様</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_frontSpec"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_frontSpec_id" path="coOptionPants2StandardInfo.op2FrontSpec" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2FrontSpecMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="op2_frontSpec_Msg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_pancherina_id" path="coOptionPants2StandardInfo.op2Pancherina" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2PancherinaMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="op2_pancherina_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_adjuster_id" path="coOptionPants2StandardInfo.op2Adjuster" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2AdjusterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_adjuster_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベルトループ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_beltLoop"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_beltLoop_id" path="coOptionPants2StandardInfo.op2BeltLoop" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopMap}"/>
                                </div>
                                <div class="offset-md-1" id="op2_beltLoopPlace">
                                    <div>
                                        <div class="form-check-inline form-check">
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op2_beltLoopPlace">全選択</button>&nbsp;
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op2_beltLoopPlace">全解除</button>
                                        </div>
                                    </div>
                                    <%-- <div class="form-check-inline form-check">
                                        <form:checkboxes id="op2_beltLoopPlace_id" items="${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlaceMap }" path="coOptionPants2StandardInfo.op2BeltLoopPlace" class="form-check-input"/>
                                    </div> --%>
                                     <c:forEach var="op2BeltLoopPlaceMap" items="${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlaceMap }" varStatus="row">
                                		<div class="form-check-inline form-check" id="op2_beltLoopPlace_id1${row.count}">
                                			<input type="checkbox" id="op2_beltLoopPlace_id${row.count}" name="coOptionPants2StandardInfo.op2BeltLoopPlace${row.count}" value="${op2BeltLoopPlaceMap.key}" class="form-check-input">${op2BeltLoopPlaceMap.value}
                                		</div>
                                	</c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_beltLoop_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_pinLoop_id" path="coOptionPants2StandardInfo.op2PinLoop" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2PinLoopMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_pinLoop_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_sidePkt_id" path="coOptionPants2StandardInfo.op2SidePkt" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2SidePktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_sidePkt_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_sinobiPkt_id" path="coOptionPants2StandardInfo.op2SinobiPkt" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2SinobiPktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_sinobiPkt_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コインポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_coinPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op2_coinPkt" class="form-control-sm form-control" path="coOptionPants2StandardInfo.op2CoinPkt">
                                	<form:options items="${orderCoForm.coOptionPants2StandardInfo.op2CoinPktMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6"  align="right" id="op2_coinPkt_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                   	<form:radiobuttons id="op2_flapCoinPkt_id" path="coOptionPants2StandardInfo.op2FlapCoinPkt" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2FlapCoinPktMap }"/>　
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_flapCoinPkt_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_pisPktUf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_pisPktUf_id" path="coOptionPants2StandardInfo.op2PisPktUf" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2PisPktUfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_pisPktUf_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_pisPktDf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_pisPktDf_id" path="coOptionPants2StandardInfo.op2PisPktDf" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2PisPktDfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_pisPktDf_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">Vカット</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_vCut_id" path="coOptionPants2StandardInfo.op2VCut" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2VCutMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_vCut_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_hemUp"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op2_hemUp" path="coOptionPants2StandardInfo.op2HemUp" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPants2StandardInfo.op2HemUpMap }"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right"  id="op2_hemUp_Msg"></div>
                        </div>
                        <div class="row form-group"  id="op2_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                                <form:select id="op2_doubleWide" path="coOptionPants2StandardInfo.op2DoubleWide" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPantsStandardInfo.opDoubleWideMap }"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right"  id="op2_doubleWide_Msg"></div>
                        </div>              
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_stitch"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_stitch_id" path="coOptionPants2StandardInfo.op2Stitch" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2StitchMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_stitch_Msg"></div>
                        </div>
                         <div id="op2_stitch_yes_area">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                            <div class="col-12 col-md-6">
                                 <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_stitchModify_id" path="coOptionPants2StandardInfo.op2StitchModify" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2StitchModifyMap }"/>
                                </div>
                                <div id="op2_stitchModifyPlace">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op2_stitchModifyPlace">全選択</button>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op2_stitchModifyPlace">全解除</button>
                                </div>
                                </div>
                                <div class="offset-md-1">
                               <%--  <div class="form-check-inline form-check">
                                    <form:checkboxes id="op2_stitchModifyPlace_id" items="${orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlaceMap }" path="coOptionPants2StandardInfo.op2StitchModifyPlace" class="form-check-input"/>
                                </div> --%>
                                <c:forEach var="op2StitchModifyPlaceMap" items="${orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="op2_stitchModifyPlace_id${row.count}" name="coOptionPants2StandardInfo.op2StitchModifyPlace${row.count}" value="${op2StitchModifyPlaceMap.key}" class="form-check-input">${op2StitchModifyPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_stitchModify_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_dStitch_id" path="coOptionPants2StandardInfo.op2DStitch" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2DStitchMap }"/>
                                </div>
                                <div id="op2_dStitch_yes_area">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op2_dStitchPlace">全選択</button>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op2_dStitchPlace">全解除</button>
                                </div>
                                </div>
                                <div class="offset-md-1" id="op2_dStitchPlace">
                                <%-- <div class="form-check-inline form-check">
                                    <form:checkboxes id="op2_dStitchPlace_id" items="${orderCoForm.coOptionPants2StandardInfo.op2DStitchPlaceMap }" path="coOptionPants2StandardInfo.op2DStitchPlace" class="form-check-input"/>
                                </div> --%>
                                <c:forEach var="op2DStitchPlaceMap" items="${orderCoForm.coOptionPants2StandardInfo.op2DStitchPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="op2_dStitchPlace_id${row.count}" name="coOptionPants2StandardInfo.op2DStitchPlace${row.count}" value="${op2DStitchPlaceMap.key}" class="form-check-input">${op2DStitchPlaceMap.value}                               		
                                	</div>
                                </c:forEach>
                                </div>                             
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_dStitch_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_amfColor_id" path="coOptionPants2StandardInfo.op2AmfColor" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2AmfColorMap }"/>
                                </div>
                                <div id="op2_amfColor_div" style="display:none;">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="op2_amfColorPlaceAll" path="coOptionPants2StandardInfo.op2AmfColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op2_amfColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op2_amfColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="op2AmfColorPlaceMap" items="${orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="op2_amfColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="op2_amfColorPlace_${row.count}" name="coOptionPants2StandardInfo.op2AmfColorPlace${row.count}" value="${op2AmfColorPlaceMap.key }" class="form-check-input">${op2AmfColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="op2_amfColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="op2AmfColorsMap" items="${orderCoForm.coOptionPants2StandardInfo.op2AmfColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op2_amfColor" class="form-check-label ">
                                			    <input type="radio" id="op2_amfColor_${op2AmfColorsMap.key}" name="coOptionPants2StandardInfo.op2AmfColor${row.count}" value="${op2AmfColorsMap.key}" class="form-check-input">${op2AmfColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_amfColor_Msg"></div>
                        </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_bhColor_id" path="coOptionPants2StandardInfo.op2BhColor" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2BhColorMap }"/>
                                </div>
                                <div id="op2_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="op2_bhColorPlaceAll" path="coOptionPants2StandardInfo.op2BhColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderCoForm.coOptionPants2StandardInfo.op2BhColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op2_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op2_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="op2BhColorPlaceMap" items="${orderCoForm.coOptionPants2StandardInfo.op2BhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="op2_bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="op2_bhColorPlace_${row.count}" name="coOptionPants2StandardInfo.op2BhColorPlace${row.count}" value="${op2BhColorPlaceMap.key }" class="form-check-input">${op2BhColorPlaceMap.value }                                      
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="op2_bhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="op2BhColorsMap" items="${orderCoForm.coOptionPants2StandardInfo.op2BhColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op2_bhColor" class="form-check-label ">
                                			    <input type="radio" id="op2_bhColor_${op2BhColorsMap.key}" name="coOptionPants2StandardInfo.op2BhColor${row.count}" value="${op2BhColorsMap.key}" class="form-check-input">${op2BhColorsMap.value}                               			                                    			  
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_bhColor_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_byColor_id" path="coOptionPants2StandardInfo.op2ByColor" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2ByColorMap }"/>
                                </div>
                                <div id="op2_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="op2_byColorPlaceAll" path="coOptionPants2StandardInfo.op2ByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderCoForm.coOptionPants2StandardInfo.op2ByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op2_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op2_byColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="op2ByColorPlaceMap" items="${orderCoForm.coOptionPants2StandardInfo.op2ByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="op2_byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="op2_byColorPlace_${row.count}" name="coOptionPants2StandardInfo.op2ByColorPlace${row.count}" value="${op2ByColorPlaceMap.key }" class="form-check-input">${op2ByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>                   	
                                	<div class="offset-md-2" id="op2_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="op2ByColorsMap" items="${orderCoForm.coOptionPants2StandardInfo.op2ByColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op2_byColorPlace" class="form-check-label ">
                                			    <input type="radio" id="op2_byColor_${op2ByColorsMap.key}" name="coOptionPants2StandardInfo.op2ByColor${row.count}" value="${op2ByColorsMap.key}" class="form-check-input">${op2ByColorsMap.value}                                			  
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_byColor_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_button"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-3">
                                <form:select id="op2_btnMate" class="form-control-sm form-control" path="coOptionPants2StandardInfo.op2Button">
                                	<form:options items="${orderCoForm.coOptionPants2StandardInfo.op2ButtonMap }"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-3">
                               <!--  <select name="op2_btnMateStkNo" id="op2_btnMateStkNo" class="form-control-sm form-control">
                                </select> -->
                                <select name="coOptionPants2StandardInfo.op2BtnMateStkNo" id="op2_btnMateStkNo" class="form-control-sm form-control">
                                </select>                          
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_btnMate_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_suspenderBtn_id" path="coOptionPants2StandardInfo.op2SuspenderBtn" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2SuspenderBtnMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_suspenderBtn_Msg"></div>
                        </div>                 
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_eight_id" path="coOptionPants2StandardInfo.op2Eight" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2EightMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_eight_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
                            <div class="col-12 col-md-6">
                                 <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_thick_id" path="coOptionPants2StandardInfo.op2Thick" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2ThickMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_thick_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_shapeMemory_id" path="coOptionPants2StandardInfo.op2ShapeMemory" class="form-check-input" items="${orderCoForm.coOptionPants2StandardInfo.op2ShapeMemoryMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right"  id="op2_shapeMemory_Msg"></div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            
            <!-- タキシード PANTS -->
            <div id="tu2_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS（2本目）</strong>　　<button type="button" class="btn btn-outline-info btn-sm" id="btn_tp2_samePants">1本目と同じ</button>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSモデル</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_pantsModel"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tp2_pantsModel" path="coOptionPants2TuxedoInfo.tp2PantsModel" class="form-control-sm form-control">
                                <form:options items="${orderCoForm.coOptionPants2TuxedoInfo.tp2PantsModelMap}"/>
                                </form:select>
                            </div>
                             <div class="col-12 col-md-9 offset-md-3" id="tp2_pantsModelMsg" style="margin-top:8px"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_pantsModelCheck" style="display:none"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col-12 col-md-3">
                            	<form:select id="tp2_tack" path="coOptionPants2TuxedoInfo.tp2Tack" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPants2TuxedoInfo.tp2TackMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="tp2_tack_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_kneeBack"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                     <form:radiobuttons id="tp2_kneeBack_id" path="coOptionPants2TuxedoInfo.tp2KneeBack" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2KneeBackMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_kneeBack_Msg"></div>
                        </div>
                        <div class="row form-group" id="tp2_kneeBackMate_div">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_kneeBackMate_id" path="coOptionPants2TuxedoInfo.tp2KneeBackMate" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2KneeBackMateMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_kneeBackMate_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント仕様</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_frontSpec"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_frontSpec_id" path="coOptionPants2TuxedoInfo.tp2FrontSpec" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2FrontSpecMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_frontSpec_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_pancherina_id" path="coOptionPants2TuxedoInfo.tp2Pancherina" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2PancherinaMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_pancherina_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_adjuster_id" path="coOptionPants2TuxedoInfo.tp2Adjuster" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2AdjusterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_adjuster_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベルトループ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_beltLoop"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_beltLoop_id" path="coOptionPants2TuxedoInfo.tp2BeltLoop" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2BeltLoopMap}"/>
                                </div>
                                <div class="offset-md-1" id="tp2_beltLoopPlace">
                                    <div>
                                        <div class="form-check-inline form-check">
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tp2_beltLoopPlace">全選択</button>&nbsp;
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tp2_beltLoopPlace">全解除</button>
                                        </div>
                                    </div>
                                    <%-- <div class="form-check-inline form-check">
                                    	<form:checkboxes id="tp2_beltLoopPlace_id" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2BeltLoopPlaceMap }" path="coOptionPants2TuxedoInfo.tp2BeltLoopPlace" class="form-check-input"/>
                                    </div> --%>
                                    <c:forEach var="tp2BeltLoopPlaceMap" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2BeltLoopPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check" id="tp2_beltLoopPlace_id1${row.count}">
                                		<input type="checkbox" id="tp2_beltLoopPlace_id${row.count}" name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace${row.count}" value="${tp2BeltLoopPlaceMap.key}" class="form-check-input">${tp2BeltLoopPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_beltLoop_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_pinLoop_id" path="coOptionPants2TuxedoInfo.tp2PinLoop" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2PinLoopMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_pinLoop_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_sidePkt_id" path="coOptionPants2TuxedoInfo.tp2SidePkt" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2SidePktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_sidePkt_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_sinobiPkt_id" path="coOptionPants2TuxedoInfo.tp2SinobiPkt" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2SinobiPktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_sinobiPkt_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コインポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_coinPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tp2_coinPkt_id" class="form-control-sm form-control" path="coOptionPants2TuxedoInfo.tp2CoinPkt">
                                	<form:options items="${orderCoForm.coOptionPants2TuxedoInfo.tp2CoinPktMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="tp2_coinPkt_id_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
                            <div class="col-12 col-md-6">
                           		<div class="form-check-inline form-check">
                                   	<form:radiobuttons id="tp2_flapCoinPkt_id" path="coOptionPants2TuxedoInfo.tp2FlapCoinPkt" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2FlapCoinPktMap }"/>　
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_flapCoinPkt_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_pisPktUf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-7">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_pisPktUf_id" path="coOptionPants2TuxedoInfo.tp2PisPktUf" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2PisPktUfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-2" align="right" id="tp2_pisPktUf_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_pisPktDf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-7">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_pisPktDf_id" path="coOptionPants2TuxedoInfo.tp2PisPktDf" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2PisPktDfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-2" align="right" id="tp2_pisPktDf_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">Vカット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_vCut_id" path="coOptionPants2TuxedoInfo.tp2VCut" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2VCutMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_vCut_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_hemUp"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tp2_hemUp" path="coOptionPants2TuxedoInfo.tp2HemUp" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPants2TuxedoInfo.tp2HemUpMap }"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="tp2_hemUp_Msg"></div>
                        </div>
                        <div class="row form-group"  id="tp2_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tp2_doubleWide" path="coOptionPants2TuxedoInfo.tp2DoubleWide" class="form-control-sm form-control">
                                	<form:options items="${orderCoForm.coOptionPants2TuxedoInfo.tp2DoubleWideMap }"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="tp2_doubleWide_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_stitch_id" path="coOptionPants2TuxedoInfo.tp2Stitch" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2StitchMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_stitch_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_bhColor_id" path="coOptionPants2TuxedoInfo.tp2BhColor" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColorMap }"/>
                                </div>
                                <div id="tp2_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="tp2_bhColorPlaceAll" path="coOptionPants2TuxedoInfo.tp2BhColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tp2_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tp2_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="tp2BhColorPlaceMap" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="tp2_bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="tp2_bhColorPlace_${row.count}" name="coOptionPants2TuxedoInfo.tp2BhColorPlace${row.count}" value="${tp2BhColorPlaceMap.key }" class="form-check-input">${tp2BhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>                        
                                	<div class="offset-md-2" id="tp2_bhColorPlace_${row.count}_div"  style="display:none">
                                		<c:forEach var="tp2BhColorMap" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="tp2_bhColor" class="form-check-label ">
                                			    <input type="radio" id="tp2_bhColor_${tp2BhColorMap.key}" name="coOptionPants2TuxedoInfo.tp2BhColor${row.count}" value="${tp2BhColorMap.key}" class="form-check-input">${tp2BhColorMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_bhColor_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                	<form:radiobuttons id="tp2_byColor_id" path="coOptionPants2TuxedoInfo.tp2ByColor" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColorMap }"/>
                                </div>
                                <div id="tp2_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="tp2_byColorPlaceAll" path="coOptionPants2TuxedoInfo.tp2ByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tp2_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tp2_byColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="tp2ByColorPlaceMap" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="tp2_byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="tp2_byColorPlace_${row.count}" name="coOptionPants2TuxedoInfo.tp2ByColorPlace${row.count}" value="${tp2ByColorPlaceMap.key }" class="form-check-input">${tp2ByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="tp2_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="tp2ByColorMap" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="tp2_byColor" class="form-check-label ">
                                			    <input type="radio" id="tp2_byColor_${tp2ByColorMap.key}" name="coOptionPants2TuxedoInfo.tp2ByColor${row.count}" value="${tp2ByColorMap.key}" class="form-check-input">${tp2ByColorMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_byColor_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_button"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-3">
                            	<form:select id="tp2_btnMate" class="form-control-sm form-control" path="coOptionPants2TuxedoInfo.tp2Button">
                                	<form:options items="${orderCoForm.coOptionPants2TuxedoInfo.tp2ButtonMap }"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-3">
                                <select name="coOptionPants2TuxedoInfo.tp2BtnMateStkNo" id="tp2_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col-12 col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="tp2_sameJacketBtn">JKと同じ</button>
                            </div>
                            <div class="col-12 col-md-1" align="right" id="tp2_btnMate_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_suspenderBtn_id" path="coOptionPants2TuxedoInfo.tp2SuspenderBtn" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2SuspenderBtnMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_suspenderBtn_Msg"></div>
                        </div>                       
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_eight_id" path="coOptionPants2TuxedoInfo.tp2Eight" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2EightMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_eight_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_thick_id" path="coOptionPants2TuxedoInfo.tp2Thick" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2ThickMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_thick_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_shapeMemory_id" path="coOptionPants2TuxedoInfo.tp2ShapeMemory" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2ShapeMemoryMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_shapeMemory_Msg"></div>
                        </div>
<!--
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">靴ずれ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="tp2_blister_yes" class="form-check-label ">
                                        <input type="radio" id="tp2_blister_yes" name="tp2_blister" value="有り" class="form-check-input" checked>有り
                                    </label>　
                                    <label for="tp2_blister_no" class="form-check-label ">
                                        <input type="radio" id="tp2_blister_no" name="tp2_blister" value="無し" class="form-check-input">無し
                                    </label>
                                </div>
                            </div>
                        </div>
-->
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">側章</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_sideStripe_id" path="coOptionPants2TuxedoInfo.tp2SideStripe" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2SideStripeMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_sideStripe_Msg"></div>
                        </div>
                        <div id="tp2_sideStripe_yes_area">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">側章幅</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_sideStripeWidth_id" path="coOptionPants2TuxedoInfo.tp2SideStripeWidth" class="form-check-input" items="${orderCoForm.coOptionPants2TuxedoInfo.tp2SideStripeWidthMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="tp2_sideStripeWidth_Msg"></div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            
            <!-- ウォッシャブル PANTS -->
            <div id="wa2_pants_div">
            <div class="card-header">
                <strong class="card-title">PANTS（2本目）</strong>　　<button type="button" class="btn btn-outline-info btn-sm" id="btn_wp2_samePants">1本目と同じ</button>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">PANTSモデル</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_pantsModel"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp2_pantsModel" path="coOptionPants2WashableInfo.wp2PantsModel" class="form-control-sm form-control">
									<form:options items="${orderCoForm.coOptionPants2WashableInfo.wp2PantsModelMap}"/>
								</form:select>
                            </div>
                             <div class="col-12 col-md-9 offset-md-3" id="wp2_pantsModelMsg"   style="margin-top:8px"></div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_pantsModelCheck"  style="display:none"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                            	<form:select id="wp2_tack_id" path="coOptionPants2WashableInfo.wp2Tack" class="form-control-sm form-control">
									<form:options items="${orderCoForm.coOptionPants2WashableInfo.wp2TackMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="wp2_tack_id_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_kneeBack"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_kneeBack_id" path="coOptionPants2WashableInfo.wp2KneeBack" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2KneeBackMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_kneeBack_Msg"></div>
                        </div>
                        <div class="row form-group" id="wp2_kneeBackMate_div">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_kneeBackMate_id" path="coOptionPants2WashableInfo.wp2KneeBackMate" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2KneeBackMateMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_kneeBackMate_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント仕様</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_frontSpec"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_frontSpec_id" path="coOptionPants2WashableInfo.wp2FrontSpec" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2FrontSpecMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_frontSpec_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_pancherina_id" path="coOptionPants2WashableInfo.wp2Pancherina" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2PancherinaMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_pancherina_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_adjuster_id" path="coOptionPants2WashableInfo.wp2Adjuster" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2AdjusterMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_adjuster_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベルトループ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_beltLoop"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_beltLoop_id" path="coOptionPants2WashableInfo.wp2BeltLoop" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2BeltLoopMap}"/>
								</div>
                                <div class="offset-md-1" id="wp2_beltLoopPlace">
                                    <div>
                                        <div class="form-check-inline form-check">
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp2_beltLoopPlace">全選択</button>&nbsp;
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp2_beltLoopPlace">全解除</button>
                                        </div>
                                    </div>
                                    <%-- <div class="form-check-inline form-check">
										<form:checkboxes id="wp2_beltLoopPlace_id" path="coOptionPants2WashableInfo.wp2BeltLoopPlace" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2BeltLoopPlaceMap}"/>
									</div> --%>
									 <c:forEach var="wp2BeltLoopPlaceMap" items="${orderCoForm.coOptionPants2WashableInfo.wp2BeltLoopPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check" id="wp2_beltLoopPlace_id1${row.count}">
                                		<input type="checkbox" id="wp2_beltLoopPlace_id${row.count}" name="coOptionPants2WashableInfo.wp2BeltLoopPlace${row.count}" value="${wp2BeltLoopPlaceMap.key}" class="form-check-input">${wp2BeltLoopPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_beltLoop_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_pinLoop_id" path="coOptionPants2WashableInfo.wp2PinLoop" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2PinLoopMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_pinLoop_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_sidePkt_id" path="coOptionPants2WashableInfo.wp2SidePkt" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2SidePktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_sidePkt_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_sinobiPkt_id" path="coOptionPants2WashableInfo.wp2SinobiPkt" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2SinobiPktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_sinobiPkt_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コインポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_coinPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp2_coinPkt_id" path="coOptionPants2WashableInfo.wp2CoinPkt" class="form-control-sm form-control">
									<form:options items="${orderCoForm.coOptionPants2WashableInfo.wp2CoinPktMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="wp2_coinPkt_id_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_flapCoinPkt_id" path="coOptionPants2WashableInfo.wp2FlapCoinPkt" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2FlapCoinPktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_flapCoinPkt_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_pisPktUf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_pisPktUf_id" path="coOptionPants2WashableInfo.wp2PisPktUf" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2PisPktUfMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_pisPktUf_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_pisPktDf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_pisPktDf_id" path="coOptionPants2WashableInfo.wp2PisPktDf" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2PisPktDfMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_pisPktDf_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">Vカット</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_vCut_id" path="coOptionPants2WashableInfo.wp2VCut" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2VCutMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_vCut_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_hemUp"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp2_hemUp" path="coOptionPants2WashableInfo.wp2HemUp" class="form-control-sm form-control">
									<form:options items="${orderCoForm.coOptionPants2WashableInfo.wp2HemUpMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="wp2_hemUp_Msg"></div>
                        </div>
                        <div class="row form-group"  id="wp2_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                            	<form:select id="wp2_doubleWide" path="coOptionPants2WashableInfo.wp2DoubleWide" class="form-control-sm form-control">
									<form:options items="${orderCoForm.coOptionPants2WashableInfo.wp2DoubleWideMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-6" align="right" id="wp2_doubleWide_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label>
                            </div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_stitch_id" path="coOptionPants2WashableInfo.wp2Stitch" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2StitchMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_stitch_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_stitchModify_id" path="coOptionPants2WashableInfo.wp2StitchModify" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2StitchModifyMap}"/>
								</div>
                                <div id="wp2_stitchModify_yes_area">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp2_stitchModifyPlace">全選択</button>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp2_stitchModifyPlace">全解除</button>
                                </div>
                                </div>
                                <div class="offset-md-1" id="wp2_stitchModifyPlace">
                                <%-- <div class="form-check-inline form-check">
									<form:checkboxes id="wp2_stitchModifyPlace_id" path="coOptionPants2WashableInfo.wp2StitchModifyPlace" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2StitchModifyPlaceMap}"/>
								</div> --%>
								 <c:forEach var="wp2StitchModifyPlaceMap" items="${orderCoForm.coOptionPants2WashableInfo.wp2StitchModifyPlaceMap }" varStatus="row">
                                		<div class="form-check-inline form-check">
                                			<input type="checkbox" id="wp2_stitchModifyPlace_id${row.count}" name="coOptionPants2WashableInfo.wp2StitchModifyPlace${row.count}" value="${wp2StitchModifyPlaceMap.key}" class="form-check-input">${wp2StitchModifyPlaceMap.value}
                                		</div>
                                	</c:forEach>
                                </div>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_stitchModify_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_dStitch_id" path="coOptionPants2WashableInfo.wp2DStitch" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2DStitchMap}"/>
								</div>
                                <div id="wp2_dStitchModify_yes_area">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp2_dStitchModifyPlace">全選択</button>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp2_dStitchModifyPlace">全解除</button>
                                </div>
                                </div>
                                <div class="offset-md-1" id="wp2_dStitchModifyPlace">
                                <%-- <div class="form-check-inline form-check">
									<form:checkboxes id="wp2_dStitchPlace_id" path="coOptionPants2WashableInfo.wp2DStitchPlace" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2DStitchPlaceMap}"/>
								</div> --%>
								<c:forEach var="wp2DStitchPlaceMap" items="${orderCoForm.coOptionPants2WashableInfo.wp2DStitchPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="wp2_dStitchModifyPlace_id${row.count}" name="coOptionPants2WashableInfo.wp2DStitchPlace${row.count}" value="${wp2DStitchPlaceMap.key}" class="form-check-input">${wp2DStitchPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                                </div>
                                </div>
                                <div class="col-12 col-md-3" align="right" id="wp2_dStitch_Msg"></div>
                            </div>
                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_amfColor_id" path="coOptionPants2WashableInfo.wp2AmfColor" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2AmfColorMap}"/>
								</div>
                                <div id="wp2_amfColor_div" style="display:none;">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="wp2_amfColorPlaceAll" path="coOptionPants2WashableInfo.wp2AmfColorPlaceAll" class="form-control-sm form-control">
										<form:options items="${orderCoForm.coOptionPants2WashableInfo.wp2AmfColorPlaceAllMap}"/>
									</form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp2_amfColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp2_amfColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wp2AmfColorPlaceMap" items="${orderCoForm.coOptionPants2WashableInfo.wp2AmfColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wp2_amfColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wp2_amfColorPlace_${row.count}" name="coOptionPants2WashableInfo.wp2AmfColorPlace${row.count}" value="${wp2AmfColorPlaceMap.key }" class="form-check-input">${wp2AmfColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>    	
                                 <div class="offset-md-2" id="wp2_amfColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wp2AmfColorsMap" items="${orderCoForm.coOptionPants2WashableInfo.wp2AmfColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wp2_amfColor" class="form-check-label ">
                                			    <input type="radio" id="wp2_amfColor_${wp2AmfColorsMap.key}" name="coOptionPants2WashableInfo.wp2AmfColor${row.count}" value="${wp2AmfColorsMap.key}" class="form-check-input">${wp2AmfColorsMap.value}                    
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div> 
                                	
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_amfColor_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_bhColor_id" path="coOptionPants2WashableInfo.wp2BhColor" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2BhColorMap}"/>
								</div>
                                <div id="wp2_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="wp2_bhColorPlaceAll" path="coOptionPants2WashableInfo.wp2BhColorPlaceAll" class="form-control-sm form-control">
										<form:options items="${orderCoForm.coOptionPants2WashableInfo.wp2BhColorPlaceAllMap}"/>
									</form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp2_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp2_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wp2BhColorPlaceMap" items="${orderCoForm.coOptionPants2WashableInfo.wp2BhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wp2_bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wp2_bhColorPlace_${row.count}" name="coOptionPants2WashableInfo.wp2BhColorPlace${row.count}" value="${wp2BhColorPlaceMap.key }" class="form-check-input">${wp2BhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>                       
                                	<div class="offset-md-2" id="wp2_bhColorPlace_${row.count}_div" style="display:none">                       
                                		<c:forEach var="wp2BhColorMap" items="${orderCoForm.coOptionPants2WashableInfo.wp2BhColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wp2_bhColorPlace" class="form-check-label ">
                                			    <input type="radio" id="wp2_bhColor_${wp2BhColorMap.key}" name="coOptionPants2WashableInfo.wp2BhColor${row.count}" value="${wp2BhColorMap.key}" class="form-check-input">${wp2BhColorMap.value}                                  			                      			   
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>                
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_bhColor_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="wp2_byColor_id" path="coOptionPants2WashableInfo.wp2ByColor" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2ByColorMap }"/>
                                </div>
                                <div id="wp2_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="wp2_byColorPlaceAll" path="coOptionPants2WashableInfo.wp2ByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderCoForm.coOptionPants2WashableInfo.wp2ByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp2_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp2_byColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wp2ByColorPlaceMap" items="${orderCoForm.coOptionPants2WashableInfo.wp2ByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wp2_byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wp2_byColorPlace_${row.count}" name="coOptionPants2WashableInfo.wp2ByColorPlace${row.count}" value="${wp2ByColorPlaceMap.key }" class="form-check-input">${wp2ByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>                  
                                	<div class="offset-md-2" id="wp2_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wp2ByColorsMap" items="${orderCoForm.coOptionPants2WashableInfo.wp2ByColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wp2_byColorPlace" class="form-check-label ">
                                			    <input type="radio" id="wp2_byColor_${wp2ByColorsMap.key}" name="coOptionPants2WashableInfo.wp2ByColor${row.count}" value="${wp2ByColorsMap.key}" class="form-check-input">${wp2ByColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_byColor_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_button"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp2_btnMate" path="coOptionPants2WashableInfo.wp2Button" class="form-control-sm form-control">
									<form:options items="${orderCoForm.coOptionPants2WashableInfo.wp2ButtonMap}"/>
								</form:select>
                            </div>
                            <div class="col col-md-3">                     
                                <select  name="coOptionPants2WashableInfo.wp2BtnMateStkNo" id="wp2_btnMateStkNo" class="form-control-sm form-control">
                                </select> 
                                 
                            </div>
                            <div class="col col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="wp2_sameJacketBtn">JKと同じ</button>
                            </div>
                            <div class="col-12 col-md-1" align="right" id="wp2_btnMate_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_suspenderBtn_id" path="coOptionPants2WashableInfo.wp2SuspenderBtn" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2SuspenderBtnMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_suspenderBtn_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_eight_id" path="coOptionPants2WashableInfo.wp2Eight" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2EightMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_eight_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック（股補強）</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_thick_id" path="coOptionPants2WashableInfo.wp2Thick" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2ThickMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_thick_Msg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-6">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_shapeMemory_id" path="coOptionPants2WashableInfo.wp2ShapeMemory" class="form-check-input" items="${orderCoForm.coOptionPants2WashableInfo.wp2ShapeMemoryMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-3" align="right" id="wp2_shapeMemory_Msg"></div>
                        </div>
<!--
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">靴ずれ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <label for="wp2_blister_yes" class="form-check-label ">
                                        <input type="radio" id="wp2_blister_yes" name="wp2_blister" value="有り" class="form-check-input" checked>有り
                                    </label>　
                                    <label for="wp2_blister_no" class="form-check-label ">
                                        <input type="radio" id="wp2_blister_no" name="wp2_blister" value="無し" class="form-check-input">無し
                                    </label>
                                </div>
                            </div>
                        </div>
--></div>
                    </div>
                </div>
            </div>
            <!-- <input type="hidden" id="pants2Flag" name="pants2Flag" value="0"/> -->
            <input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="0"/>
            <input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="${orderCoForm.jacketItemFlag }"/>
			<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="${orderCoForm.giletItemFlag }"/>
			<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="${orderCoForm.shirtItemFlag }"/>
			<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="${orderCoForm.coatItemFlag }"/>
			<input type="hidden" id="pantsItemFlag" name="pantsItemFlag" value="${orderCoForm.pantsItemFlag }"/>
            <input type="hidden" id="pants2AdFlag" name="pants2AdFlag" value="${orderCoForm.pants2AdFlag }" />
            <input type="hidden" id="jacketAdFlag" name="jacketAdFlag" value="${orderCoForm.jacketAdFlag }" />
            <input type="hidden" id="coatAdFlag" name="coatAdFlag" value="${orderCoForm.coatAdFlag }" />
             <input type="hidden" id="giletAdFlag" name="giletAdFlag" value="${orderCoForm.giletAdFlag }" />
             <input type="hidden" id="pantsAdFlag" name="pantsAdFlag" value="${orderCoForm.pantsAdFlag }" />
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
<%-- <script src="${pageContext.request.contextPath}/resources/app/self/js/rule.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/config.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/customer.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/tabMenu.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/product.js"></script> --%>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants2.standard.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants2.tuxedo.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants2.washable.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";
var orderFlag = "${orderCoForm.orderFlag}";
jQuery(function() {

	var pants2AdFlag="${orderCoForm.pants2AdFlag}";
if(orderFlag=="orderCo"){
	if(pants2AdFlag=="1"){
	}else{
		jQuery("#pants2AdFlag").val("0");
	}
}
    var productCategory = "${orderCoForm.productCategory}";

    if(orderFlag=="orderBack"){
		if(productCategory == "9000101"){
			var sessionPt2Model = "${orderCoForm.coOptionPants2StandardInfo.op2PantsModel}";
			jQuery("#op2_pantsModel").click(function(){
				var op2_pantsModel = jQuery("#op2_pantsModel").val();
				sessionPantsAdFlag(sessionPt2Model,op2_pantsModel);
			});
		}else if(productCategory == "9000102"){
			var sessionTp2PtModel = "${orderCoForm.coOptionPants2TuxedoInfo.tp2PantsModel}";
			jQuery("#tp2_pantsModel").click(function(){
				var tp2_pantsModel = jQuery("#tp2_pantsModel").val();
				sessionPantsAdFlag(sessionTp2PtModel,tp2_pantsModel);
			});
		}else if(productCategory == "9000103"){
			var sessionWp2PtModel = "${orderCoForm.coOptionPants2WashableInfo.wp2PantsModel}";
			jQuery("#wp2_pantsModel").click(function(){
				var wp2_pantsModel = jQuery("#wp2_pantsModel").val();
				sessionPantsAdFlag(sessionWp2PtModel,wp2_pantsModel);
			});
		}
	}
	//getModelByItem();
    var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });

	mateInit();
	//--------------------------------------------
	// タブメニュー
	//--------------------------------------------
	initTabMenu();
	//--------------------------------------------
	// 商品タブ
	//--------------------------------------------
	changeViewArea();
	
	setPantsModelDisable(productCategory);

	initOptionPants2Standard();

	initOptionPants2Tuxedo();

	initOptionPants2Washable();
	initCommon();
	getPrice();
	showPrice();
	optionPants2ChangeModel(productCategory);
	jQuery("#pants2ItemFlag").val("1");

	if(orderFlag == "orderLink"){
		if(productCategory == "9000101"){
			var op2BeltLoopPlace = "${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace}";
			if(isNotEmpty(op2BeltLoopPlace)){
				op2BeltLoopPlace = op2BeltLoopPlace.split(",");
				for(var i=0;i<op2BeltLoopPlace.length;i++){
					if(op2BeltLoopPlace[i] == "0000801"){
						jQuery("#op2_beltLoopPlace_id1").prop("checked",true);
					}else if(op2BeltLoopPlace[i] == "0000802"){
						jQuery("#op2_beltLoopPlace_id2").prop("checked",true);
					}else if(op2BeltLoopPlace[i] == "0000803"){
						jQuery("#op2_beltLoopPlace_id3").prop("checked",true);
					}else if(op2BeltLoopPlace[i] == "0000804"){
						jQuery("#op2_beltLoopPlace_id4").prop("checked",true);
					}else if(op2BeltLoopPlace[i] == "0000805"){
						jQuery("#op2_beltLoopPlace_id5").prop("checked",true);
					}else if(op2BeltLoopPlace[i] == "0000806"){
						jQuery("#op2_beltLoopPlace_id6").prop("checked",true);
					}else if(op2BeltLoopPlace[i] == "0000807"){
						jQuery("#op2_beltLoopPlace_id7").prop("checked",true);
					}
				}
			}

			var op2StitchModifyPlace = "${orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlace}";
			if(isNotEmpty(op2StitchModifyPlace)){
				op2StitchModifyPlace = op2StitchModifyPlace.split(",");
				for(var i=0;i<op2StitchModifyPlace.length;i++){
					if(op2StitchModifyPlace[i] == "0002101"){
						jQuery("#op2_stitchModifyPlace_id1").prop("checked",true);
					}else if(op2StitchModifyPlace[i] == "0002102"){
						jQuery("#op2_stitchModifyPlace_id2").prop("checked",true);
					}else if(op2StitchModifyPlace[i] == "0002103"){
						jQuery("#op2_stitchModifyPlace_id3").prop("checked",true);
					}else if(op2StitchModifyPlace[i] == "0002104"){
						jQuery("#op2_stitchModifyPlace_id4").prop("checked",true);
					}
				}
			}

		
			ctrlOp2DStitchPlace();
			ctrlOp2AmfColor();

			var op2DStitchPlace = "${orderCoForm.coOptionPants2StandardInfo.op2DStitchPlace}";
			if(isNotEmpty(op2DStitchPlace)){
				op2DStitchPlace = op2DStitchPlace.split(",");
				for(var i=0;i<op2DStitchPlace.length;i++){
					if(op2DStitchPlace[i] == "0002301"){
						jQuery("#op2_dStitchPlace_id1").prop("checked",true);
					}else if(op2DStitchPlace[i] == "0002302"){
						jQuery("#op2_dStitchPlace_id2").prop("checked",true);
					}else if(op2DStitchPlace[i] == "0002303"){
						jQuery("#op2_dStitchPlace_id3").prop("checked",true);
					}else if(op2DStitchPlace[i] == "0002304"){
						jQuery("#op2_dStitchPlace_id4").prop("checked",true);
					}
				}
			}

			var op2AmfColorPlace = "${orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlace}";
			var op2AmfAllColor = "${orderCoForm.coOptionPants2StandardInfo.op2AmfAllColor}";
			if(isNotEmpty(op2AmfColorPlace)&&isNotEmpty(op2AmfAllColor)){
				op2AmfColorPlace = op2AmfColorPlace.split(",");
				op2AmfAllColor = op2AmfAllColor.split(",");
				for(var i=0;i<op2AmfColorPlace.length;i++){
					for(var i=0;i<op2AmfAllColor.length;i++){
						if(op2AmfColorPlace[i] == "0002601"){
							jQuery("#op2_amfColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.op2AmfColor1'][value='" + op2AmfAllColor[i] + "']").prop("checked", true);
						}else if(op2AmfColorPlace[i] == "0002602"){
							jQuery("#op2_amfColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.op2AmfColor2'][value='" + op2AmfAllColor[i] + "']").prop("checked", true);
						}else if(op2AmfColorPlace[i] == "0002603"){
							jQuery("#op2_amfColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.op2AmfColor3'][value='" + op2AmfAllColor[i] + "']").prop("checked", true);
						}else if(op2AmfColorPlace[i] == "0002604"){
							jQuery("#op2_amfColorPlace_4").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.op2AmfColor4'][value='" + op2AmfAllColor[i] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="op2_amfColorPlace_"]').change();
			}


			var op2BhColorPlace = "${orderCoForm.coOptionPants2StandardInfo.op2BhColorPlace}";
			var op2BhAllColor = "${orderCoForm.coOptionPants2StandardInfo.op2BhColor}";
			if(isNotEmpty(op2BhColorPlace)&&isNotEmpty(op2BhColorPlace)){
				op2BhColorPlace = op2BhColorPlace.split(",");
				op2BhAllColor = op2BhAllColor.split(",");
				for(var i=0;i<op2BhColorPlace.length;i++){
					for(var i=0;i<op2BhAllColor.length;i++){
						if(op2BhColorPlace[i] == "0002901"){
							jQuery("#op2_bhColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.op2BhColorPlace1'][value='" + op2BhAllColor[i] + "']").prop("checked", true);
						}else if(op2BhColorPlace[i] == "0002902"){
							jQuery("#op2_bhColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.op2BhColorPlace2'][value='" + op2BhAllColor[i] + "']").prop("checked", true);
						}else if(op2BhColorPlace[i] == "0002903"){
							jQuery("#op2_bhColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.op2BhColorPlace3'][value='" + op2BhAllColor[i] + "']").prop("checked", true);
						}else if(op2BhColorPlace[i] == "0002904"){
							jQuery("#op2_bhColorPlace_4").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.op2BhColorPlace4'][value='" + op2BhAllColor[i] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="op2_bhColorPlace_"]').change();
			} 

			var op2ByColorPlace = "${orderCoForm.coOptionPants2StandardInfo.op2ByColorPlace}";
			var op2ByAllColor = "${orderCoForm.coOptionPants2StandardInfo.op2ByColor}";
			if(isNotEmpty(op2ByColorPlace)&&isNotEmpty(op2ByColorPlace)){
				op2ByColorPlace = op2ByColorPlace.split(",");
				op2ByAllColor = op2ByAllColor.split(",");
				for(var i=0;i<op2ByColorPlace.length;i++){
					for(var i=0;i<op2ByAllColor.length;i++){
						if(op2ByColorPlace[i] == "0003201"){
							jQuery("#op2_byColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.op2ByColorPlace1'][value='" + op2ByAllColor[i] + "']").prop("checked", true);
						}else if(op2ByColorPlace[i] == "0003202"){
							jQuery("#op2_byColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.op2ByColorPlace2'][value='" + op2ByAllColor[i] + "']").prop("checked", true);
						}else if(op2ByColorPlace[i] == "0003203"){
							jQuery("#op2_byColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.op2ByColorPlace3'][value='" + op2ByAllColor[i] + "']").prop("checked", true);
						}else if(op2ByColorPlace[i] == "0003204"){
							jQuery("#op2_byColorPlace_4").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.op2ByColorPlace4'][value='" + op2ByAllColor[i] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="op2_bhColorPlace_"]').change();
			} 

		}else if(productCategory == "9000102"){
			var tp2BeltLoopPlace = "${orderCoForm.coOptionPants2TuxedoInfo.tp2BeltLoopPlace}";
			if(isNotEmpty(tp2BeltLoopPlace)){
				tp2BeltLoopPlace = tp2BeltLoopPlace.split(",");
				for(var i=0;i<tp2BeltLoopPlace.length;i++){
					if(tp2BeltLoopPlace[i] == "0000801"){
						jQuery("#tp2_beltLoopPlace_id1").prop("checked",true);
					}else if(tp2BeltLoopPlace[i] == "0000802"){
						jQuery("#tp2_beltLoopPlace_id2").prop("checked",true);
					}else if(tp2BeltLoopPlace[i] == "0000803"){
						jQuery("#tp2_beltLoopPlace_id3").prop("checked",true);
					}else if(tp2BeltLoopPlace[i] == "0000804"){
						jQuery("#tp2_beltLoopPlace_id4").prop("checked",true);
					}else if(tp2BeltLoopPlace[i] == "0000805"){
						jQuery("#tp2_beltLoopPlace_id5").prop("checked",true);
					}else if(tp2BeltLoopPlace[i] == "0000806"){
						jQuery("#tp2_beltLoopPlace_id6").prop("checked",true);
					}else if(tp2BeltLoopPlace[i] == "0000807"){
						jQuery("#tp2_beltLoopPlace_id7").prop("checked",true);
					}
				}
			}
			var tp2BhColorPlace = "${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColorPlace}";
			var tp2BhAllColor = "${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColor}";
			if(isNotEmpty(tp2BhColorPlace)&&isNotEmpty(tp2BhColorPlace)){
				tp2BhColorPlace = tp2BhColorPlace.split(",");
				tp2BhAllColor = tp2BhAllColor.split(",");
				for(var i=0;i<tp2BhColorPlace.length;i++){
					for(var i=0;i<tp2BhAllColor.length;i++){
						if(tp2BhColorPlace[i] == "0002901"){
							jQuery("#tp2_bhColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.tp2BhColorPlace1'][value='" + tp2BhAllColor[i] + "']").prop("checked", true);
						}else if(tp2BhColorPlace[i] == "0002902"){
							jQuery("#tp2_bhColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.tp2BhColorPlace2'][value='" + tp2BhAllColor[i] + "']").prop("checked", true);
						}else if(tp2BhColorPlace[i] == "0002903"){
							jQuery("#tp2_bhColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.tp2BhColorPlace3'][value='" + tp2BhAllColor[i] + "']").prop("checked", true);
						}else if(tp2BhColorPlace[i] == "0002904"){
							jQuery("#tp2_bhColorPlace_4").prop("checked",true);
							jQuery(":radio[name='coOptionPants2StandardInfo.tp2BhColorPlace4'][value='" + tp2BhAllColor[i] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="tp2_bhColorPlace_"]').change();
			} 

			var tp2ByColorPlace = "${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColorPlace}";
			var tp2ByAllColor = "${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColor}";
			if(isNotEmpty(tp2ByColorPlace)&&isNotEmpty(tp2ByColorPlace)){
				tp2ByColorPlace = tp2ByColorPlace.split(",");
				tp2ByAllColor = tp2ByAllColor.split(",");
				for(var i=0;i<tp2ByColorPlace.length;i++){
					for(var i=0;i<tp2ByAllColor.length;i++){
						if(tp2ByColorPlace[i] == "0003201"){
							jQuery("#tp2_byColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionPants2TuxedoInfo.tp2ByColorPlace1'][value='" + tp2ByAllColor[i] + "']").prop("checked", true);
						}else if(tp2ByColorPlace[i] == "0003202"){
							jQuery("#tp2_byColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionPants2TuxedoInfo.tp2ByColorPlace2'][value='" + tp2ByAllColor[i] + "']").prop("checked", true);
						}else if(tp2ByColorPlace[i] == "0003203"){
							jQuery("#tp2_byColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionPants2TuxedoInfo.tp2ByColorPlace3'][value='" + tp2ByAllColor[i] + "']").prop("checked", true);
						}else if(tp2ByColorPlace[i] == "0003204"){
							jQuery("#tp2_byColorPlace_4").prop("checked",true);
							jQuery(":radio[name='coOptionPants2TuxedoInfo.tp2ByColorPlace4'][value='" + tp2ByAllColor[i] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="tp2_bhColorPlace_"]').change();
			} 
        }else if(productCategory == "9000103"){

        	var wp2BeltLoopPlace = "${orderCoForm.coOptionPants2WashableInfo.wp2BeltLoopPlace}";
			if(isNotEmpty(wp2BeltLoopPlace)){
				wp2BeltLoopPlace = wp2BeltLoopPlace.split(",");
				for(var i=0;i<wp2BeltLoopPlace.length;i++){
					if(wp2BeltLoopPlace[i] == "0000801"){
						jQuery("#wp2_beltLoopPlace_id1").prop("checked",true);
					}else if(wp2BeltLoopPlace[i] == "0000802"){
						jQuery("#wp2_beltLoopPlace_id2").prop("checked",true);
					}else if(wp2BeltLoopPlace[i] == "0000803"){
						jQuery("#wp2_beltLoopPlace_id3").prop("checked",true);
					}else if(wp2BeltLoopPlace[i] == "0000804"){
						jQuery("#wp2_beltLoopPlace_id4").prop("checked",true);
					}else if(wp2BeltLoopPlace[i] == "0000805"){
						jQuery("#wp2_beltLoopPlace_id5").prop("checked",true);
					}else if(wp2BeltLoopPlace[i] == "0000806"){
						jQuery("#wp2_beltLoopPlace_id6").prop("checked",true);
					}else if(wp2BeltLoopPlace[i] == "0000807"){
						jQuery("#wp2_beltLoopPlace_id7").prop("checked",true);
					}
				}
			}

			var wp2StitchModifyPlace = "${orderCoForm.coOptionPants2WashableInfo.wp2StitchModifyPlace}";
			if(isNotEmpty(wp2StitchModifyPlace)){
				wp2StitchModifyPlace = wp2StitchModifyPlace.split(",");
				for(var i=0;i<wp2StitchModifyPlace.length;i++){
					if(wp2StitchModifyPlace[i] == "0002101"){
						jQuery("#wp2_stitchModifyPlace_id1").prop("checked",true);
					}else if(wp2StitchModifyPlace[i] == "0002102"){
						jQuery("#wp2_stitchModifyPlace_id2").prop("checked",true);
					}else if(wp2StitchModifyPlace[i] == "0002103"){
						jQuery("#wp2_stitchModifyPlace_id3").prop("checked",true);
					}else if(wp2StitchModifyPlace[i] == "0002104"){
						jQuery("#wp2_stitchModifyPlace_id4").prop("checked",true);
					}
				}
			}

		
			ctrlWp2DStitchPlace();
			ctrlWp2AmfColor();

			var wp2DStitchPlace = "${orderCoForm.coOptionPants2WashableInfo.wp2DStitchPlace}";
			if(isNotEmpty(wp2DStitchPlace)){
				wp2DStitchPlace = wp2DStitchPlace.split(",");
				for(var i=0;i<wp2DStitchPlace.length;i++){
					if(wp2DStitchPlace[i] == "0002301"){
						jQuery("#wp2_dStitchPlace_id1").prop("checked",true);
					}else if(wp2DStitchPlace[i] == "0002302"){
						jQuery("#wp2_dStitchPlace_id2").prop("checked",true);
					}else if(wp2DStitchPlace[i] == "0002303"){
						jQuery("#wp2_dStitchPlace_id3").prop("checked",true);
					}else if(wp2DStitchPlace[i] == "0002304"){
						jQuery("#wp2_dStitchPlace_id4").prop("checked",true);
					}
				}
			}

			var wp2AmfColorPlace = "${orderCoForm.coOptionPants2WashableInfo.wp2AmfColorPlace}";
			var wp2AmfAllColor = "${orderCoForm.coOptionPants2WashableInfo.wp2AmfAllColor}";
			if(isNotEmpty(wp2AmfColorPlace)&&isNotEmpty(wp2AmfAllColor)){
				wp2AmfColorPlace = wp2AmfColorPlace.split(",");
				wp2AmfAllColor = wp2AmfAllColor.split(",");
				for(var i=0;i<wp2AmfColorPlace.length;i++){
					for(var i=0;i<wp2AmfAllColor.length;i++){
						if(wp2AmfColorPlace[i] == "0002601"){
							jQuery("#wp2_amfColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionPants2WashableInfo.wp2AmfColor1'][value='" + wp2AmfAllColor[i] + "']").prop("checked", true);
						}else if(wp2AmfColorPlace[i] == "0002602"){
							jQuery("#wp2_amfColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionPants2WashableInfo.wp2AmfColor2'][value='" + wp2AmfAllColor[i] + "']").prop("checked", true);
						}else if(wp2AmfColorPlace[i] == "0002603"){
							jQuery("#wp2_amfColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionPants2WashableInfo.wp2AmfColor3'][value='" + wp2AmfAllColor[i] + "']").prop("checked", true);
						}else if(wp2AmfColorPlace[i] == "0002604"){
							jQuery("#wp2_amfColorPlace_4").prop("checked",true);
							jQuery(":radio[name='coOptionPants2WashableInfo.wp2AmfColor4'][value='" + wp2AmfAllColor[i] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="wp2_amfColorPlace_"]').change();
			}


			var wp2BhColorPlace = "${orderCoForm.coOptionPants2WashableInfo.wp2BhColorPlace}";
			var wp2BhAllColor = "${orderCoForm.coOptionPants2WashableInfo.wp2BhColor}";
			if(isNotEmpty(wp2BhColorPlace)&&isNotEmpty(wp2BhColorPlace)){
				wp2BhColorPlace = wp2BhColorPlace.split(",");
				wp2BhAllColor = wp2BhAllColor.split(",");
				for(var i=0;i<wp2BhColorPlace.length;i++){
					for(var i=0;i<wp2BhAllColor.length;i++){
						if(wp2BhColorPlace[i] == "0002901"){
							jQuery("#wp2_bhColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionPants2WashableInfo.wp2BhColorPlace1'][value='" + wp2BhAllColor[i] + "']").prop("checked", true);
						}else if(wp2BhColorPlace[i] == "0002902"){
							jQuery("#wp2_bhColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionPants2WashableInfo.wp2BhColorPlace2'][value='" + wp2BhAllColor[i] + "']").prop("checked", true);
						}else if(wp2BhColorPlace[i] == "0002903"){
							jQuery("#wp2_bhColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionPants2WashableInfo.wp2BhColorPlace3'][value='" + wp2BhAllColor[i] + "']").prop("checked", true);
						}else if(wp2BhColorPlace[i] == "0002904"){
							jQuery("#wp2_bhColorPlace_4").prop("checked",true);
							jQuery(":radio[name='coOptionPants2WashableInfo.wp2BhColorPlace4'][value='" + wp2BhAllColor[i] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="wp2_bhColorPlace_"]').change();
			} 

			var wp2ByColorPlace = "${orderCoForm.coOptionPants2WashableInfo.wp2ByColorPlace}";
			var wp2ByAllColor = "${orderCoForm.coOptionPants2WashableInfo.wp2ByColor}";
			if(isNotEmpty(wp2ByColorPlace)&&isNotEmpty(wp2ByColorPlace)){
				wp2ByColorPlace = wp2ByColorPlace.split(",");
				wp2ByAllColor = wp2ByAllColor.split(",");
				for(var i=0;i<wp2ByColorPlace.length;i++){
					for(var i=0;i<wp2ByAllColor.length;i++){
						if(wp2ByColorPlace[i] == "0003201"){
							jQuery("#wp2_byColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionPants2WashableInfo.wp2ByColorPlace1'][value='" + wp2ByAllColor[i] + "']").prop("checked", true);
						}else if(wp2ByColorPlace[i] == "0003202"){
							jQuery("#wp2_byColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionPants2WashableInfo.wp2ByColorPlace2'][value='" + wp2ByAllColor[i] + "']").prop("checked", true);
						}else if(wp2ByColorPlace[i] == "0003203"){
							jQuery("#wp2_byColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionPants2WashableInfo.wp2ByColorPlace3'][value='" + wp2ByAllColor[i] + "']").prop("checked", true);
						}else if(wp2ByColorPlace[i] == "0003204"){
							jQuery("#wp2_byColorPlace_4").prop("checked",true);
							jQuery(":radio[name='coOptionPants2WashableInfo.wp2ByColorPlace4'][value='" + wp2ByAllColor[i] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="wp2_bhColorPlace_"]').change();
			}    
         }	
	}
})	

function setPantsModelDisable(productCategory){
	var ptModel = null;
	if(productCategory == "9000101"){
		ptModel = document.getElementById("op2_pantsModel");
	}else if(productCategory == "9000102"){
		ptModel = document.getElementById("tp2_pantsModel");
	}else if(productCategory == "9000103"){
		ptModel = document.getElementById("wp2_pantsModel");
	}
	var allJkOption = ptModel.options;
	allJkOption[0].disabled = true;
}

var opPantsModel = jQuery("#op2_pantsModel").val();
if(opPantsModel == '' || opPantsModel == null){
	jQuery('#op2_adjuster_id2').attr("disabled",true);
	jQuery('#op2_adjuster_id4').attr("disabled",true);
}

var tpPantsModel = jQuery("#tp2_pantsModel").val();
if(tpPantsModel == '' || tpPantsModel == null){
	jQuery('#tp2_adjuster_id2').attr("disabled",true);
	jQuery('#tp2_adjuster_id4').attr("disabled",true);
}

var wpPantsModel = jQuery("#wp2_pantsModel").val();
if(wpPantsModel == '' || wpPantsModel == null){
	jQuery('#wp2_adjuster_id2').attr("disabled",true);
	jQuery('#wp2_adjuster_id4').attr("disabled",true);
}

var selectStandardIdList = {
		"op2_btnMate":"00033"
}
var selectTuxedoIdList = {
		"tp2_btnMate":"00033"
}
var selectWashableIdList = {
		"wp2_btnMate":"00033"
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
	//var ptStandardMateList = ["op2_btnMate"];
	// タキシードの場合　pants ptTuxedoMateListのid List
	//var ptTuxedoMateList = ["tp2_btnMate"];
	// ウォッシャブルの場合　pants ptWashableMateListのid List
	//var ptWashableMateList = ["wp2_btnMate"];
	//var item = jQuery("#item option:selected").val();
	var item = jQuery("#item").val();
	//jQuery("#category option:first").prop("selected",true);
	category = jQuery('input[name="productCategory"]:checked').val();
	if(item=="01"){
		subItemCode = "07";
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
		subItemCode = "07";
		initPtStandard(itemCode,subItemCode,category);
	}

	function initSuitTuxedo(itemCode,category){
		subItemCode = "07";
		initPtStandard(itemCode,subItemCode,category);
	}

	function initSuitWashable(itemCode,category){
		subItemCode = "07";
		initPtStandard(itemCode,subItemCode,category);
	}
			
	function initPtStandard(itemCode,subItemCode,category){
		/* for(var i in ptStandardMateList){
			optionCode = selectStandardIdList[ptStandardMateList[i]];
			mateChecked = jQuery("#"+ptStandardMateList[i]+" option:checked").val();
			StkNo = "#"+ptStandardMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		} */
		mateChecked = jQuery("#op2_btnMate option:checked").val();
		mateSelect(itemCode,subItemCode,mateChecked,"00033","#op2_btnMateStkNo",category,orderPattern);
		jQuery('#op2_btnMateStkNo').change();
		jQuery("#op2_btnMate").change(function(){
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
		mateChecked = jQuery("#tp2_btnMate option:checked").val();
		mateSelect(itemCode,subItemCode,mateChecked,"00033","#tp2_btnMateStkNo",category,orderPattern);
		jQuery('#tp2_btnMateStkNo').change();
		jQuery("#tp2_btnMate").change(function(){
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
		mateChecked = jQuery("#wp2_btnMate option:checked").val();
		mateSelect(itemCode,subItemCode,mateChecked,"00033","#wp2_btnMateStkNo",category,orderPattern);
		jQuery("#wp2_btnMate").change(function(){
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
		if (type == 9000101){
			url = "/orderCo/standardMateSelect";
		}else if(type == 9000102){
			url = "/orderCo/tuxdoMateSelect";
		}else if(type == 9000103){
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
//--------------------------------------------
//金額フォーマット
//--------------------------------------------
function getPrice(){
	//PANTSの料金を表示
	var pants2Model = "";
	var priceUrl = "";
	jQuery("#op2_pantsModel,#op2_tack,#tp2_pantsModel,#tp2_tack,#wp2_pantsModel,#wp2_tack").change(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		var itemCode = jQuery("#item").val();
	    var subItemCode = "07";
	    var category = jQuery('input[name="productCategory"]:checked').val();
	    if(category == "9000101"){
	    	pants2Model = jQuery("#op2_pantsModel option:selected").val();
	    	priceUrl = "getOrderPriceForPants2Model";
		}else if(category == "9000102"){
			pants2Model = jQuery("#tp2_pantsModel option:selected").val();
			priceUrl = "getOrderPriceForPants2tModel";
		}else if(category == "9000103"){
			pants2Model = jQuery("#wp2_pantsModel option:selected").val();
			priceUrl = "getOrderPriceForPants2wModel";
		}
		if(isEmpty(pants2Model)){
			return;
		}
	    var code = itemCode + subItemCode + pants2Model;
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
	    
	var pants2Model = "";
	var priceUrl = "";
	//プルダウンの変更処理
	//項目：タック、コインポケット、裾上げ、釦素材、釦素材品番
	jQuery("#op2_tack,#op2_coinPkt,#op2_hemUp,#op2_btnMate,#op2_btnMateStkNo,"+
			"#tp2_tack,#tp2_coinPkt,#tp2_hemUp,#tp2_btnMate,#tp2_btnMateStkNo,"+
			"#wp2_tack,#wp2_coinPkt,#wp2_hemUp,#wp2_btnMate,#wp2_btnMateStkNo") 
	   .change(function(){
	   //jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
	   var category = jQuery('input[name="productCategory"]:checked').val();
	   if(category == "9000101"){
		   pants2Model = jQuery("#op2_pantsModel option:selected").val();
	    	priceUrl = "getOrderPriceForPants2Project";
	   }else if(category == "9000102"){
		   pants2Model = jQuery("#tp2_pantsModel option:selected").val();
			priceUrl = "getOrderPriceForPants2tProject";
	   }else if(category == "9000103"){
		   pants2Model = jQuery("#wp2_pantsModel option:selected").val();
			priceUrl = "getOrderPriceForPants2wProject";
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
	   if(isNotEmpty(pants2Model)){
		   var code = itemCode + subItemCode + pants2Model;
		   jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/" + priceUrl,
			    data:{"code":code,"idValueName":idValueName,"thisVal":thisVal,"thisValStkNo":thisValStkNo},
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

	var pants2Model = "";
	var priceUrl = "";
	//ラジオボタンの変更処理
	//項目：膝裏、膝裏素材、フロント仕様、パンチェリーナ、アジャスター仕様、ベルトループ、ピンループ、脇ポケット、忍びポケット、フラップ付コインポケット、上前ピスポケット、下前ピスポケット、Vカット、ステッチ種類、ステッチ箇所変更、ダブルステッチ、AMF色指定、ボタンホール色指定、ボタン付け糸指定、サスペンダー釦、エイト（滑り止め）、シック大（股補強）、形状記憶
	jQuery('input[id^="op2_kneeBack_id"],[id^="op2_kneeBackMate_id"],[id^="op2_frontSpec_id"],[id^="op2_pancherina_id"],[id^="op2_adjuster_id"],[id^="op2_beltLoop_id"],[id^="op2_pinLoop_id"],[id^="op2_sidePkt_id"],[id^="op2_sinobiPkt_id"],[id^="op2_flapCoinPkt_id"],[id^="op2_pisPktUf_id"],[id^="op2_pisPktDf_id"],[id^="op2_vCut_id"],[id^="op2_stitch_id"],[id^="op2_stitchModify_id"],[id^="op2_suspenderBtn_id"],[id^="op2_thick_id"],[id^="op2_eight_id"],[id^="op2_shapeMemory_id"],' + 
		        '[id^="tp2_kneeBack_id"],[id^="tp2_kneeBackMate_id"],[id^="tp2_frontSpec_id"],[id^="tp2_pancherina_id"],[id^="tp2_adjuster_id"],[id^="tp2_beltLoop_id"],[id^="tp2_pinLoop_id"],[id^="tp2_sidePkt_id"],[id^="tp2_sinobiPkt_id"],[id^="tp2_flapCoinPkt_id"],[id^="tp2_pisPktUf_id"],[id^="tp2_pisPktDf_id"],[id^="tp2_vCut_id"],[id^="tp2_stitch_id"],[id^="tp2_suspenderBtn_id"],[id^="tp2_thick_id"],[id^="tp2_eight_id"],[id^="tp2_shapeMemory_id"],[id^="tp2_sideStripe_id"],[id^="tp2_sideStripeWidth_id"],'+
		        '[id^="wp2_kneeBack_id"],[id^="wp2_kneeBackMate_id"],[id^="wp2_frontSpec_id"],[id^="wp2_pancherina_id"],[id^="wp2_adjuster_id"],[id^="wp2_beltLoop_id"],[id^="wp2_pinLoop_id"],[id^="wp2_sidePkt_id"],[id^="wp2_sinobiPkt_id"],[id^="wp2_flapCoinPkt_id"],[id^="wp2_pisPktUf_id"],[id^="wp2_pisPktDf_id"],[id^="wp2_vCut_id"],[id^="wp2_stitch_id"],[id^="wp2_stitchModify_id"],[id^="wp2_dStitch_id"],[id^="wp2_suspenderBtn_id"],[id^="wp2_eight_id"],[id^="wp2_thick_id"],[id^="wp2_shapeMemory_id"]')
	.change(function(){
		//jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		var category = jQuery('input[name="productCategory"]:checked').val();
		 if(category == "9000101"){
			   pants2Model = jQuery("#op2_pantsModel option:selected").val();
		    	priceUrl = "getOrderPriceForPants2Project";
		   }else if(category == "9000102"){
			   pants2Model = jQuery("#tp2_pantsModel option:selected").val();
				priceUrl = "getOrderPriceForPants2tProject";
		   }else if(category == "9000103"){
			   pants2Model = jQuery("#wp2_pantsModel option:selected").val();
				priceUrl = "getOrderPriceForPants2wProject";
		   }
		var thisVal = "";  
		var itemCode = jQuery("#item").val();
	    var subItemCode = "07";
	    var idValueName = jQuery(this).attr("id");
	    thisVal = jQuery("#"+idValueName).val();
	    var price;
	  	//IDの後の番号を削除します
	    var findIdPosition = idValueName.indexOf("_id");
	    var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
		    
		if(isNotEmpty(pants2Model)){
			var code = itemCode + subItemCode + pants2Model;
			jQuery.ajax({
				type:"get",
			    url:contextPath + "/orderCo/" + priceUrl,
			    data:{"code":code,"idValueName":interceptedIdValueName,"thisVal":thisVal},
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

	var pants2Model = "";
	var priceUrl = "";
	// 	ラジオボタンの変更処理
	// 	項目：ベルトループ ,ステッチ箇所変更,ダブルステッチ
	jQuery('input[id^="op2_beltLoop_id"],[id^="op2_beltLoopPlace_id"],[id^="op2_stitchModify_id"],[id^="op2_stitchModifyPlace_id"],[id^="op2_dStitch_id"],[id^="op2_dStitchPlace_id"],[id^="tp2_beltLoop_id"],[id^="tp2_beltLoopPlace_id"],[id^="wp2_beltLoop_id"],[id^="wp2_beltLoopPlace_id"],[id^="wp2_stitchModify_id"],[id^="wp2_stitchModifyPlace_id"],[id^="wp2_dStitch_id"],[id^="wp2_dStitchPlace_id"]')
	.change(function(){
		//jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		var category = jQuery('input[name="productCategory"]:checked').val();
		 if(category == "9000101"){
			   pants2Model = jQuery("#op2_pantsModel option:selected").val();
		    	priceUrl = "getOrderPriceForPants2Project";
		   }else if(category == "9000102"){
			   pants2Model = jQuery("#tp2_pantsModel option:selected").val();
				priceUrl = "getOrderPriceForPants2tProject";
		   }else if(category == "9000103"){
			   pants2Model = jQuery("#wp2_pantsModel option:selected").val();
				priceUrl = "getOrderPriceForPants2wProject";
		   }
		var itemCode = jQuery("#item").val();
		var subItemCode = "07";
		var idValueName = jQuery(this).attr("id");
		var thisValueTemp = jQuery(this).val();
		var jspOptionCode = "";

		if(category == "9000101"){
		if(thisValueTemp == "0002001"){
			//ステッチ箇所変更は無しです
			var i = 1;
			jQuery('input[id^="op2_stitchModifyPlace_id"]').each(function() {
				jQuery('#op2_stitchModifyPlace_id' + i).removeAttr("checked");
				i++;
			});
			jQuery('#op2_dStitch_id1').prop("checked", true);
			jQuery('#op2_dStitch_id2').prop("disabled", true);
			jQuery('#op2_amfColor_id1').prop("checked", true);
			jQuery('#op2_amfColor_id2').prop("disabled", true);
			var findIdPosition = idValueName.indexOf("_id");
		    var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
			if(isNotEmpty(pants2Model)){
				jspOptionCode = "00020"
				var code = itemCode + subItemCode + pants2Model + jspOptionCode;
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
			jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]:checked').change();
			jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor"]:checked').change();
		}
		if(thisValueTemp == "0002002"){
			//ステッチ箇所変更は有りです
			jQuery('#op2_dStitch_id2').prop("disabled", false);
			jQuery('#op2_amfColor_id2').prop("disabled", false);
		}
		}else if(category == "9000103"){
			if(thisValueTemp == "0002001"){
				//ステッチ箇所変更は無しです
				var i = 1;
				jQuery('input[id^="wp2_stitchModifyPlace_id"]').each(function() {
					jQuery('#wp2_stitchModifyPlace_id' + i).removeAttr("checked");
					i++;
				});
				jQuery('#wp2_dStitch_id1').prop("checked", true);
				jQuery('#wp2_dStitch_id2').prop("disabled", true);
				jQuery('#wp2_amfColor_id1').prop("checked", true);
				jQuery('#wp2_amfColor_id2').prop("disabled", true);
				var findIdPosition = idValueName.indexOf("_id");
			    var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
				if(isNotEmpty(pants2Model)){
					jspOptionCode = "00020"
					var code = itemCode + subItemCode + pants2Model + jspOptionCode;
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
				jQuery('input[name="coOptionPants2WashableInfo.wp2DStitch"]:checked').change();
				jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor"]:checked').change();
			}
			if(thisValueTemp == "0002002"){
				//ステッチ箇所変更は有りです
				jQuery('#wp2_dStitch_id2').prop("disabled", false);
				jQuery('#wp2_amfColor_id2').prop("disabled", false);
			}
		}
		if(thisValueTemp == "0002201"){
			//ダブルステッチは無しです
			var i = 1;
			jQuery('input[id^="op2_dStitchPlace_id"]').each(function() {
				jQuery('#op2_dStitchPlace_id1' + i).removeAttr("checked");
				i++;
			});
		}
		
		//IDの後の番号を削除します
		var interceptedIdValueName = "";
		
		//複数選択ボックスの数,IDにより決定optionCode
		var ogSomePlace_length = 0;
		var jspOptionCode = "";
		if(idValueName.indexOf("op2_stitchModifyPlace_id") >= 0){
			jspOptionCode ="00021";
			ogSomePlace_length = jQuery('input[id^="op2_stitchModifyPlace_id"]').length;

		}else if(idValueName.indexOf("op2_dStitchPlace_id") >= 0){
			jspOptionCode ="00023";
			ogSomePlace_length = jQuery('input[id^="op2_dStitchPlace_id"]').length;
			
		}else if(idValueName.indexOf("wp2_stitchModifyPlace_id") >= 0){
			jspOptionCode ="00021";
			ogSomePlace_length = jQuery('input[id^="wp2_stitchModifyPlace_id"]').length;
			
		}else if(idValueName.indexOf("wp2_dStitchPlace_id") >= 0){
			jspOptionCode ="00023";
			ogSomePlace_length = jQuery('input[id^="wp2_dStitchPlace_id"]').length;

		}

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
					countArr = countArr + jspOptionCode + idValueNameComplete.value + ",";
				}
			}
		}

		if(isNotEmpty(pants2Model) && findIdPosition != -1){
			var code = itemCode + subItemCode + pants2Model;
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
	
	var pants2Model = "";
	var priceUrl = "";
	jQuery('input[id^="op2_amfColor_"],[id^="op2_bhColor_"],[id^="op2_byColor_"],[id^="tp2_bhColor_"],[id^="tp2_byColor_"],[id^="wp2_bhColor_"],[id^="wp2_byColor_"],[id^="wp2_amfColor_"]').change(function(){
		//jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		var category = jQuery('input[name="productCategory"]:checked').val();
		if(category == "9000101"){
			   pants2Model = jQuery("#op2_pantsModel option:selected").val();
		    	priceUrl = "getOrderPriceForPants2Project";
		   }else if(category == "9000102"){
			   pants2Model = jQuery("#tp2_pantsModel option:selected").val();
				priceUrl = "getOrderPriceForPants2tProject";
		   }else if(category == "9000103"){
			   pants2Model = jQuery("#wp2_pantsModel option:selected").val();
				priceUrl = "getOrderPriceForPants2wProject";
		   }
		var itemCode = jQuery("#item").val();
	    var subItemCode = "07";
	    var idValueName = jQuery(this).attr("id");
	    var thisValueTemp = jQuery(this).val();
	    //IDの後の番号を削除します
		var interceptedIdValueName = "";
		//複数選択ボックスの数
		var jkSomePlace_length = 0;
		var jspOptionCodeAndBranchCode = "";
		if(idValueName.indexOf("op2_amfColor_") >= 0){
			jspOptionCodeAndBranchCode ="00026" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="op2_amfColorPlace_"]').length;
			
		}else if(idValueName.indexOf("op2_bhColor_") >= 0){
			jspOptionCodeAndBranchCode ="00029" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="op2_bhColorPlace_"]').length;
			
		}else if(idValueName.indexOf("op2_byColor_") >= 0){
			jspOptionCodeAndBranchCode ="00032" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="op2_byColorPlace_"]').length;
			
		}else if(idValueName.indexOf("tp2_bhColor_") >= 0){
			jspOptionCodeAndBranchCode ="00029" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="tp2_bhColorPlace_"]').length;
			
		}else if(idValueName.indexOf("tp2_byColor_") >= 0){
			jspOptionCodeAndBranchCode ="00032" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="tp2_byColorPlace_"]').length;
			
		}else if(idValueName.indexOf("wp2_bhColor_") >= 0){
			jspOptionCodeAndBranchCode ="00029" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="wp2_bhColorPlace_"]').length;
			
		}else if(idValueName.indexOf("wp2_byColor_") >= 0){
			jspOptionCodeAndBranchCode ="00032" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="wp2_byColorPlace_"]').length;
			
		}else if(idValueName.indexOf("wp2_amfColor_") >= 0){
			jspOptionCodeAndBranchCode ="00026" + thisValueTemp;
			jkSomePlace_length = jQuery('input[id^="wp2_amfColorPlace_"]').length;
			
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
				if(idValueName.indexOf("op2_amfColor_") >= 0){
					
					idValueNameAll = "coOptionPants2StandardInfo.op2AmfColor" + i;
				}else if(idValueName.indexOf("op2_bhColor_") >= 0){
					
					idValueNameAll = "coOptionPants2StandardInfo.op2BhColor" + i;
				}else if(idValueName.indexOf("op2_byColor_") >= 0){
					
					idValueNameAll = "coOptionPants2StandardInfo.op2ByColor" + i;
				}else if(idValueName.indexOf("tp2_bhColor_") >= 0){
					
					idValueNameAll = "coOptionPants2TuxedoInfo.tp2BhColor" + i;
				}else if(idValueName.indexOf("tp2_byColor_") >= 0){
					
					idValueNameAll = "coOptionPants2TuxedoInfo.tp2ByColor" + i;
				}else if(idValueName.indexOf("wp2_amfColor_") >= 0){
					
					idValueNameAll = "coOptionPants2WashableInfo.wp2AmfColor" + i;
				}else if(idValueName.indexOf("wp2_byColor_") >= 0){
					
					idValueNameAll = "coOptionPants2WashableInfo.wp2AmfColor" + i;
				}else if(idValueName.indexOf("wp2_bhColor_") >= 0){
					
					idValueNameAll = "coOptionPants2WashableInfo.wp2BhColor" + i;
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
		}
		var desiredItemFlag = false;
		if(interceptedIdValueName == "op2_amfColor_id" || interceptedIdValueName == "op2_bhColor_id" || interceptedIdValueName == "op2_byColor_id" 
				|| interceptedIdValueName == "op2_bhColor_id" || interceptedIdValueName == "tp2_byColor_id" 
				|| interceptedIdValueName == "wp2_amfColor_id" || interceptedIdValueName == "wp2_bhColor_id" || interceptedIdValueName == "wp2_byColor_id"){
			desiredItemFlag = true;
		}

		if(isNotEmpty(pants2Model) && desiredItemFlag == true){
			var code = itemCode + subItemCode + pants2Model;
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
	jQuery('[id^="btn_as_op2_amfColorPlace"],[id^="btn_ar_op2_amfColorPlace"],[id^="btn_as_op2_bhColorPlace"],'+
			'[id^="btn_ar_op2_bhColorPlace"],[id^="btn_as_op2_byColorPlace"],[id^="btn_ar_op2_byColorPlace"],' +
			'[id^="btn_as_tp2_bhColorPlace"],[id^="btn_ar_tp2_bhColorPlace"],[id^="btn_as_tp2_byColorPlace"],' + 
			'[id^="btn_ar_tp2_byColorPlace"],[id^="btn_as_wp2_amfColorPlace"],[id^="btn_ar_wp2_amfColorPlace"],' + 
			'[id^="btn_as_wp2_bhColorPlace"],[id^="btn_ar_wp2_bhColorPlace"],[id^="btn_as_wp2_byColorPlace"],' + 
			'[id^="btn_ar_wp2_byColorPlace"]').click(function(){

		var productCategory = jQuery('input[name="productCategory"]:checked').val();
		var ajaxUrl = "";
		var pants2Model = "";
		var idValueNameTemp = "";
		var thisValueTemp = "";
		if(productCategory == "9000101"){
			idValueNameTemp = "op2_";
			ajaxUrl = "getOrderPriceForPants2Project";
			pants2Model = jQuery("#op2_pantsModel option:selected").val();
		}else if(productCategory == "9000102"){
			idValueNameTemp = "tp2_";
			ajaxUrl = "getOrderPriceForPants2tProject";
			pants2Model = jQuery("#tp2_pantsModel option:selected").val();
		}else if(productCategory == "9000103"){
			idValueNameTemp = "wp2_";
			ajaxUrl = "getOrderPriceForPants2wProject";
			pants2Model = jQuery("#wp2_pantsModel option:selected").val();
		}

		var itemCode = jQuery("#item").val();
		var subItemCode = "07";
		var idValueName = jQuery(this).attr("id");
		

		var findIdAmf = idValueName.indexOf("_amfColorPlace");
		var findIdBh = idValueName.indexOf("_bhColorPlace");
		var findIdBy = idValueName.indexOf("_byColorPlace");
		if(findIdAmf != -1){
			idValueNameTemp = idValueNameTemp + "amfColor_id";
			if(productCategory == "9000101"){
				thisValueTemp = "00025" + jQuery("#op2_amfColorPlaceAll").val();
			}else if(productCategory == "9000103"){
				thisValueTemp = "00025" + jQuery("#wp2_amfColorPlaceAll").val();
			}
		}else if(findIdBh != -1){
			idValueNameTemp = idValueNameTemp + "bhColor_id";
			if(productCategory == "9000101"){
				thisValueTemp = "00028" + jQuery("#op2_bhColorPlaceAll").val();
			}else if(productCategory == "9000102"){
				thisValueTemp = "00028" + jQuery("#tp2_bhColorPlaceAll").val();
			}else if(productCategory == "9000103"){
				thisValueTemp = "00028" + jQuery("#wp2_bhColorPlaceAll").val();
			}
		}else if(findIdBy != -1){
			idValueNameTemp = idValueNameTemp + "byColor_id";
			if(productCategory == "9000101"){
				thisValueTemp = "00031" + jQuery("#wp2_byColorPlaceAll").val();
			}else if(productCategory == "9000102"){
				thisValueTemp = "00031" + jQuery("#tp2_byColorPlaceAll").val();
			}else if(productCategory == "9000103"){
				thisValueTemp = "00031" + jQuery("#wp2_byColorPlaceAll").val();
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
		
		if(isNotEmpty(pants2Model)){
			var code = itemCode + subItemCode + pants2Model;
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
	jQuery("#pt2OptionPriceId").val(optionPrice);
    var jkOptionPriceId = optionPrice;
    var ptOptionPriceId = jQuery("#ptOptionPriceId").val();
    var pt2OptionPriceId = jQuery("#pt2OptionPriceId").val();
    var glOptionPriceId = jQuery("#glOptionPriceId").val();
    var threePiece = jQuery('input[name="productIs3Piece"]:checked').val();
    var twoPants = jQuery('input[name="productSparePantsClass"]:checked').val();
    var allPrice = 0;
    if(subItemCode == "01"){
        if(threePiece == "0009901" && twoPants == "0009902"){
        	allPrice = Number(jkOptionPriceId) + Number(ptOptionPriceId) + Number(pt2OptionPriceId);
        }else{
        	allPrice = Number(jkOptionPriceId) + Number(ptOptionPriceId) + Number(pt2OptionPriceId) + Number(glOptionPriceId);
        }
    }
    jQuery("#optionPriceId").val(allPrice);
    jQuery("#optionPrice").html(formatMoney(allPrice,0,""));
}

//PANTS2本目（1本目と同じ）
jQuery('#btn_op2_samePants').click(function (){
	//PANTSモデル
	jQuery('#op2_pantsModel').val("${orderCoForm.coOptionPantsStandardInfo.opPantsModel}");
	//タック
	jQuery('#op2_tack').val("${orderCoForm.coOptionPantsStandardInfo.opTack}");	
	jQuery('#op2_tack').change();
	//膝裏
	jQuery('input[name="coOptionPants2StandardInfo.op2KneeBack"]').val(["${orderCoForm.coOptionPantsStandardInfo.opKneeBack}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2KneeBack"]').change();
	//膝裏素材
	jQuery('input[name="coOptionPants2StandardInfo.op2KneeBackMate"]').val(["${orderCoForm.coOptionPantsStandardInfo.opKneeBackMate}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2KneeBackMate"]').change();
	//フロント仕様
	jQuery('input[name="coOptionPants2StandardInfo.op2FrontSpec"]').val(["${orderCoForm.coOptionPantsStandardInfo.opFrontSpec}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2FrontSpec"]').change();
	//パンチェリーナ
	jQuery('input[name="coOptionPants2StandardInfo.op2Pancherina"]').val(["${orderCoForm.coOptionPantsStandardInfo.opPancherina}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2Pancherina"]').change();
	//アジャスター仕様
	jQuery('input[name="coOptionPants2StandardInfo.op2Adjuster"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAdjuster}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2Adjuster"]').change();
	//ベルトループ
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoop"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoop}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoop"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace4"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace5"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace5}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace5"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace6"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace6}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace6"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace7"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBeltLoopPlace7}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace7"]').change();

	//ピンループ
	jQuery('input[name="coOptionPants2StandardInfo.op2PinLoop"]').val(["${orderCoForm.coOptionPantsStandardInfo.opPinLoop}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2PinLoop"]').change();
	//脇ポケット
	jQuery('input[name="coOptionPants2StandardInfo.op2SidePkt"]').val(["${orderCoForm.coOptionPantsStandardInfo.opSidePkt}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2SidePkt"]').change();
	//忍びポケット
	jQuery('input[name="coOptionPants2StandardInfo.op2SinobiPkt"]').val(["${orderCoForm.coOptionPantsStandardInfo.opSinobiPkt}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2SinobiPkt"]').change();
	//コインポケット
	jQuery("#op2_coinPkt").val("${orderCoForm.coOptionPantsStandardInfo.opCoinPkt}");
	jQuery("#op2_coinPkt").change();
	//フラップ付コインポケット
	jQuery('input[name="coOptionPants2StandardInfo.op2FlapCoinPkt"]').val("${orderCoForm.coOptionPantsStandardInfo.opFlapCoinPkt}");
	jQuery('input[name="coOptionPants2StandardInfo.op2FlapCoinPkt"]').change();
	//上前ピスポケット 
	jQuery('input[name="coOptionPants2StandardInfo.op2PisPktUf"]').val(["${orderCoForm.coOptionPantsStandardInfo.opPisPktUf}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2PisPktUf"]').change();
	//下前ピスポケット
	jQuery('input[name="coOptionPants2StandardInfo.op2PisPktDf"]').val(["${orderCoForm.coOptionPantsStandardInfo.opPisPktDf}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2PisPktDf"]').change();
	//Vカット
	jQuery('input[name="coOptionPants2StandardInfo.op2VCut"]').val(["${orderCoForm.coOptionPantsStandardInfo.opVCut}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2VCut"]').change();
	//裾上げ
	jQuery('#op2_hemUp').val("${orderCoForm.coOptionPantsStandardInfo.opHemUp}");
	jQuery('#op2_hemUp').change();

	jQuery('#op2_doubleWide').val("${orderCoForm.coOptionPantsStandardInfo.opDoubleWide}");
	jQuery('#op2_doubleWide').change();
	//ステッチ種類
	jQuery('input[name="coOptionPants2StandardInfo.op2Stitch"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitch}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2Stitch"]').change();
	//ステッチ箇所変更
	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModify"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModify}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModify"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opStitchModifyPlace4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace4"]').change();

	//ダブルステッチ
	jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]').val(["${orderCoForm.coOptionPantsStandardInfo.opDStitch}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opDStitchPlace1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opDStitchPlace2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opDStitchPlace3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opDStitchPlace4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace4"]').change();	

	//AMF色指定
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor"]').change();

	jQuery("#op2_amfColorPlaceAll").val("${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlaceAll}");
	jQuery("#op2_amfColorPlaceAll").change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColorPlace4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace4"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opAmfColor4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor4"]').change();

	//ボタンホール色指定
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor"]').change();

	jQuery("#op2_bhColorPlaceAll").val("${orderCoForm.coOptionPantsStandardInfo.opBhColorPlaceAll}");
	jQuery("#op2_bhColorPlaceAll").change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColorPlace1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColorPlace2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColorPlace3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColorPlace4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace4"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opBhColor4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor"]').change();
	
	jQuery("#op2_byColorPlaceAll").val("${orderCoForm.coOptionPantsStandardInfo.opByColorPlaceAll}");
	jQuery("#op2_byColorPlaceAll").change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColorPlace1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColorPlace2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColorPlace3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColorPlace4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace4"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor4"]').change();
	

	//釦素材
	jQuery('#op2_btnMate').val("${orderCoForm.coOptionPantsStandardInfo.opButton}");
	jQuery('#op2_btnMate').change();

	jQuery('#op2_btnMateStkNo').val("${orderCoForm.coOptionPantsStandardInfo.opBtnMateStkNo}");
	jQuery('#op2_btnMateStkNo').change();

	//サスペンダー釦
	jQuery('input[name="coOptionPants2StandardInfo.op2SuspenderBtn"]').val(["${orderCoForm.coOptionPantsStandardInfo.opSuspenderBtn}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2SuspenderBtn"]').change();

	//シック大（股補強）
	jQuery('input[name="coOptionPants2StandardInfo.op2Thick"]').val(["${orderCoForm.coOptionPantsStandardInfo.opThick}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2Thick"]').change();

	//エイト（滑り止め）
	jQuery('input[name="coOptionPants2StandardInfo.op2Eight"]').val(["${orderCoForm.coOptionPantsStandardInfo.opEight}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2Eight"]').change();

	//形状記憶
	jQuery('input[name="coOptionPants2StandardInfo.op2ShapeMemory"]').val(["${orderCoForm.coOptionPantsStandardInfo.opShapeMemory}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ShapeMemory"]').change();
});


//PANTS2本目（1本目と同じ）
jQuery('#btn_tp2_samePants').click(function (){

	//PANTSモデル
	jQuery('#tp2_pantsModel').val("${orderCoForm.coOptionPantsTuxedoInfo.tpPantsModel}");
	//タック
	jQuery('#tp2_tack').val("${orderCoForm.coOptionPantsTuxedoInfo.tpTack}");
	jQuery('#tp2_tack').change();
	//膝裏
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2KneeBack"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpKneeBack}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2KneeBack"]').change();
	//膝裏素材
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2KneeBackMate"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpKneeBackMate}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2KneeBackMate"]').change();
	//フロント仕様
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2FrontSpec"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpFrontSpec}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2FrontSpec"]').change();
	//パンチェリーナ
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2Pancherina"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPancherina}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2Pancherina"]').change();
	//アジャスター仕様
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2Pancherina"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPancherina}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2Pancherina"]').change();
   //ベルトループ 
   jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoop"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoop}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoop"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace1}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace1"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace2}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace2"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace3}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace3"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace4}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace4"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace5"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace5}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace5"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace6"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace6}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace6"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace7"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBeltLoopPlace7}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace7"]').change();

	//ピンループ
   jQuery('input[name="coOptionPants2TuxedoInfo.tp2PinLoop"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPinLoop}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2PinLoop"]').change();
	//脇ポケット
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2SidePkt"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpSidePkt}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2SidePkt"]').change();
	//忍びポケット
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2SinobiPkt"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpSinobiPkt}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2SinobiPkt"]').change();
	//コインポケット
	jQuery("#tp_coinPkt").val("${orderCoForm.coOptionPantsTuxedoInfo.tpCoinPkt}");
	jQuery("#tp_coinPkt").change();
	//フラップ付コインポケット
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2FlapCoinPkt"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpFlapCoinPkt}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2FlapCoinPkt"]').change();
	//上前ピスポケット
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2PisPktUf"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPisPktUf}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2PisPktUf"]').change();
	//下前ピスポケット
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2PisPktDf"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpPisPktDf}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2PisPktDf"]').change();
	//Vカット
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2VCut"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpVCut}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2VCut"]').change();
	//裾上げ
	jQuery("#tp2_hemUp").val("${orderCoForm.coOptionPantsTuxedoInfo.tpHemUp}");
	jQuery("#tp2_hemUp").change();

	jQuery("#tp2_doubleWide").val("${orderCoForm.coOptionPantsTuxedoInfo.tpDoubleWide}");
	jQuery("#tp2_doubleWide").change();
	//ステッチ種類
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2Stitch"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpStitch}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2Stitch"]').change();
	//ボタンホール色指定
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlace1}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace1"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlace2}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace2"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlace3}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace3"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColorPlace4}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace4"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor1}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor1"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor2}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor2"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor3}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor3"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpBhColor4}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor"]').change();
	jQuery("#tp2_byColorPlaceAll").val("${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlaceAll}");
	jQuery("#tp2_byColorPlaceAll").change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlace1}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace1"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlace2}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace2"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlace3}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace3"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColorPlace4}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace4"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor1"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor1}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor1"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor2"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor2}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor2"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor3"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor3}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor3"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor4"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpByColor4}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor4"]').change();
	
	//釦素材
	jQuery("#tp2_btnMate").val("${orderCoForm.coOptionPantsTuxedoInfo.tpButton}");
	jQuery("#tp2_btnMate").change();

	jQuery("#tp2_btnMateStkNo").val("${orderCoForm.coOptionPantsStandardInfo.opBtnMateStkNo}");
	jQuery("#tp2_btnMateStkNo").change();
	//サスペンダー釦
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2SuspenderBtn"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpSuspenderBtn}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2SuspenderBtn"]').change();
	//シック大（股補強）
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2Thick"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpThick}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2Thick"]').change();
	//エイト（滑り止め）
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2Eight"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpEight}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2Eight"]').change();
	//形状記憶
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ShapeMemory"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpShapeMemory}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ShapeMemory"]').change();
	//側章
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2SideStripe"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpSideStripe}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2SideStripe"]').change();
	//側章幅
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2SideStripeWidth"]').val(["${orderCoForm.coOptionPantsTuxedoInfo.tpSideStripeWidth}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2SideStripeWidth"]').change();

});

//PANTS2本目（1本目と同じ）
jQuery('#btn_wp2_samePants').click(function (){
	//PANTSモデル 
	jQuery('#wp2_pantsModel').val("${orderCoForm.coOptionPantsWashableInfo.wpPantsModel}");
	//タック
	jQuery('#wp2_tack_id').val("${orderCoForm.coOptionPantsWashableInfo.wpTack}");
	jQuery('#wp2_tack_id').change();
	//膝裏
	jQuery('input[name="coOptionPants2WashableInfo.wp2KneeBack"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpKneeBack}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2KneeBack"]').change();
	//膝裏素材
	jQuery('input[name="coOptionPants2WashableInfo.wp2KneeBackMate"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpKneeBackMate}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2KneeBackMate"]').change();
	//フロント仕様
	jQuery('input[name="coOptionPants2WashableInfo.wp2FrontSpec"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpFrontSpec}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2FrontSpec"]').change();
	//パンチェリーナ
	jQuery('input[name="coOptionPants2WashableInfo.wp2Pancherina"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpPancherina}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2Pancherina"]').change();
	//アジャスター仕様
	jQuery('input[name="coOptionPants2WashableInfo.wp2Adjuster"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAdjuster}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2Adjuster"]').change();
	//ベルトループ
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoop}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace4"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace5"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace5}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace5"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace6"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace6}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace6"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace7"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBeltLoopPlace7}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace7"]').change();

	//ピンループ
	jQuery('input[name="coOptionPants2WashableInfo.wp2PinLoop"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpPinLoop}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2PinLoop"]').change();
	//脇ポケット
	jQuery('input[name="coOptionPants2WashableInfo.wp2SidePkt"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpSidePkt}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2SidePkt"]').change();
	//忍びポケット
	jQuery('input[name="coOptionPants2WashableInfo.wp2SinobiPkt"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpSinobiPkt}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2SinobiPkt"]').change();
	//コインポケット 
	jQuery("#wp2_coinPkt_id").val("${orderCoForm.coOptionPantsWashableInfo.wpCoinPkt}");
	jQuery("#wp2_coinPkt_id").change();
	//フラップ付コインポケット
	jQuery('input[name="coOptionPants2WashableInfo.wp2FlapCoinPkt"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpFlapCoinPkt}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2FlapCoinPkt"]').change();
	//上前ピスポケット
	jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktUf"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpPisPktUf}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktUf"]').change();
	//下前ピスポケット
	jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktDf"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpPisPktDf}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktDf"]').change();
	//Vカット
	jQuery('input[name="coOptionPants2WashableInfo.wp2VCut"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpVCut}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2VCut"]').change();
	//裾上げ
	jQuery("#wp2_hemUp").val("${orderCoForm.coOptionPantsWashableInfo.wpHemUp}");
	jQuery("#wp2_hemUp").change();

	jQuery("#wp2_doubleWide").val("${orderCoForm.coOptionPantsWashableInfo.wpDoubleWide}");
	jQuery("#wp2_doubleWide").change();
	//ステッチ種類
	jQuery('input[name="coOptionPants2WashableInfo.wp2Stitch"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitch}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2Stitch"]').change();
	//ステッチ箇所変更
	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModify"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModify}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModify"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlace1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlace2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlace3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpStitchModifyPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace4"]').change();
	
	//ダブルステッチ
	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitch"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitch}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitch"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlace1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlace2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlace3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpDStitchPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace4"]').change();

	//AMF色指定
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlace1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlace2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlace3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColorPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace4"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpAmfColor4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor4"]').change();


	//ボタンホール色指定
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace4"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColorPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace4"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpBhColor4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColorPlace1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace2"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColorPlace2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace3"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColorPlace3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace4"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColorPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace4"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').change();
	
	//釦素材
	jQuery("#wp2_btnMate").val("${orderCoForm.coOptionPantsWashableInfo.wpButton}");
	jQuery("#wp2_btnMate").change();

	jQuery("#wp2_btnMateStkNo").val("${orderCoForm.coOptionPantsWashableInfo.wpBtnMateStkNo}");
	jQuery("#wp2_btnMateStkNo").change();
	//サスペンダー釦
	jQuery('input[name="coOptionPants2WashableInfo.wp2SuspenderBtn"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpSuspenderBtn}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2SuspenderBtn"]').change();
	//シック大（股補強）
	jQuery('input[name="coOptionPants2WashableInfo.wp2Thick"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpThick}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2Thick"]').change();
	//エイト（滑り止め）
	jQuery('input[name="coOptionPants2WashableInfo.wp2Thick"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpThick}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2Thick"]').change();
	//形状記憶
	jQuery('input[name="coOptionPants2WashableInfo.wp2Eight"]').val(["${orderCoForm.coOptionPantsWashableInfo.wpEight}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2Eight"]').change();
});
function  op2Session(){

	//コインポケット
	jQuery("#op2_coinPkt").val("${orderCoForm.coOptionPants2StandardInfo.op2CoinPkt}");
	jQuery("#op2_coinPkt").change();

	//裾上げ
	jQuery('#op2_hemUp').val("${orderCoForm.coOptionPants2StandardInfo.op2HemUp}");
	jQuery('#op2_hemUp').change();
	
	
	//ベルトループ
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoop"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BeltLoop}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoop"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace1"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace2"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace3"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace4"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace4"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace5"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace5}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace5"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace6"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace6}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace6"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace7"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BeltLoopPlace7}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BeltLoopPlace7"]').change();

	//ステッチ箇所変更
	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModify"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2StitchModify}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModify"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace1"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlace1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace2"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlace2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace3"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlace3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace4"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2StitchModifyPlace4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2StitchModifyPlace4"]').change();

	//ダブルステッチ
	jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2DStitch}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace1"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2DStitchPlace1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace2"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2DStitchPlace2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace3"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2DStitchPlace3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace4"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2DStitchPlace4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2DStitchPlace4"]').change();	

	//AMF色指定
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2AmfColor}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor"]').change();

	jQuery("#op2_amfColorPlaceAll").val("${orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlaceAll}");
	jQuery("#op2_amfColorPlaceAll").change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace1"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlace1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace2"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlace2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace3"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlace3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace4"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2AmfColorPlace4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColorPlace4"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor1"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2AmfColor1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor2"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2AmfColor2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor3"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2AmfColor3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor4"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2AmfColor4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor4"]').change();

	//ボタンホール色指定
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BhColor}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor"]').change();

	jQuery("#op2_bhColorPlaceAll").val("${orderCoForm.coOptionPants2StandardInfo.op2BhColorPlaceAll}");
	jQuery("#op2_bhColorPlaceAll").change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace1"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BhColorPlace1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace2"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BhColorPlace2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace3"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BhColorPlace3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace4"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BhColorPlace4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColorPlace4"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor1"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BhColor1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor2"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BhColor2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor3"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BhColor3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor4"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2BhColor4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2BhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2ByColor}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor"]').change();
	
	jQuery("#op2_byColorPlaceAll").val("${orderCoForm.coOptionPants2StandardInfo.op2ByColorPlaceAll}");
	jQuery("#op2_byColorPlaceAll").change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace1"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2ByColorPlace1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace2"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2ByColorPlace2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace3"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2ByColorPlace3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace4"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2ByColorPlace4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColorPlace4"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor1"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor1}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor1"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor2"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor2}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor2"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor3"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor3}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor3"]').change();

	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor4"]').val(["${orderCoForm.coOptionPantsStandardInfo.opByColor4}"]);
	jQuery('input[name="coOptionPants2StandardInfo.op2ByColor4"]').change();
	
	//釦素材
    if(isNotEmpty("${orderCoForm.coOptionPants2StandardInfo.op2BtnMateStkNo}")){
    	jQuery('#op2_btnMateStkNo').val("${orderCoForm.coOptionPants2StandardInfo.op2BtnMateStkNo}");
    	jQuery('#op2_btnMateStkNo').change();
       }
	
}

function  tp2Session(){

	//コインポケット
	jQuery("#tp2_coinPkt").val("${orderCoForm.coOptionPants2TuxedoInfo.tp2CoinPkt}");
	jQuery("#tp2_coinPkt").change();

	//裾上げ
	jQuery("#tp2_hemUp").val("${orderCoForm.coOptionPants2TuxedoInfo.tp2HemUp}");
	jQuery("#tp2_hemUp").change();

   //ベルトループ 
   jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoop"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BeltLoop}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoop"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace1"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BeltLoopPlace1}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace1"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace2"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BeltLoopPlace2}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace2"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace3"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BeltLoopPlace3}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace3"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace4"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BeltLoopPlace4}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace4"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace5"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BeltLoopPlace5}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace5"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace6"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BeltLoopPlace6}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace6"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace7"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BeltLoopPlace7}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoopPlace7"]').change();

	//ステッチ種類
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2Stitch"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2Stitch}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2Stitch"]').change();
	//ボタンホール色指定
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColor}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace1"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColorPlace1}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace1"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace2"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColorPlace2}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace2"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace3"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColorPlace3}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace3"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace4"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColorPlace4}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColorPlace4"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor1"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColor1}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor1"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor2"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColor2}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor2"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor3"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColor3}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor3"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor4"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BhColor4}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2BhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColor}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor"]').change();
	jQuery("#tp2_byColorPlaceAll").val("${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColorPlaceAll}");
	jQuery("#tp2_byColorPlaceAll").change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace1"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColorPlace1}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace1"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace2"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColorPlace2}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace2"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace3"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColorPlace3}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace3"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace4"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColorPlace4}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColorPlace4"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor1"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColor1}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor1"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor2"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColor2}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor2"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor3"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColor3}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor3"]').change();

	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor4"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2ByColor4}"]);
	jQuery('input[name="coOptionPants2TuxedoInfo.tp2ByColor4"]').change();

	if(isNotEmpty("${orderCoForm.coOptionPants2TuxedoInfo.tp2BtnMateStkNo}")){
		jQuery("#tp2_btnMateStkNo").val("${orderCoForm.coOptionPants2TuxedoInfo.tp2BtnMateStkNo}");
		jQuery("#tp2_btnMateStkNo").change();
		}
	
}
function  wp2Session(){

	//ベルトループ
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BeltLoop}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace1"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BeltLoopPlace1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace2"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BeltLoopPlace2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace3"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BeltLoopPlace3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace4"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BeltLoopPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace4"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace5"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BeltLoopPlace5}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace5"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace6"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BeltLoopPlace6}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace6"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace7"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BeltLoopPlace7}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoopPlace7"]').change();

	//ステッチ種類
	jQuery('input[name="coOptionPants2WashableInfo.wp2Stitch"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2Stitch}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2Stitch"]').change();
	//ステッチ箇所変更
	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModify"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2StitchModify}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModify"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace1"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2StitchModifyPlace1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace2"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2StitchModifyPlace2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace3"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2StitchModifyPlace3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace4"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2StitchModifyPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2StitchModifyPlace4"]').change();
	
	//ダブルステッチ
	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitch"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2DStitch}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitch"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace1"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2DStitchPlace1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace2"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2DStitchPlace2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace3"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2DStitchPlace3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace4"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2DStitchPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2DStitchPlace4"]').change();

	//AMF色指定
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2AmfColor}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace1"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2AmfColorPlace1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace2"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2AmfColorPlace2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace3"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2AmfColorPlace3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace4"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2AmfColorPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColorPlace4"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor1"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2AmfColor1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor2"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2AmfColor2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor3"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2AmfColor3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor4"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2AmfColor4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2AmfColor4"]').change();

	//ボタンホール色指定
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BhColor}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace1"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BhColorPlace1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace2"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BhColorPlace2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace3"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BhColorPlace3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace4"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BhColorPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace4"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace4"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BhColorPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColorPlace4"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor1"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BhColor1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor2"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BhColor2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor3"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BhColor3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor4"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BhColor4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2BhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2ByColor}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace1"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2ByColorPlace1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace2"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2ByColorPlace2}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace2"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace3"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2ByColorPlace3}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace3"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace4"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2ByColorPlace4}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColorPlace4"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2ByColor1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2ByColor1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2ByColor1}"]);
	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').change();

	jQuery('input[name="coOptionPants2WashableInfo.wp2ByColor1"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2ByColor1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').change();

	if(isNotEmpty("${orderCoForm.coOptionPants2WashableInfo.wp2BtnMateStkNo}")){
		jQuery("#wp2_btnMateStkNo").val("${orderCoForm.coOptionPants2WashableInfo.wp2BtnMateStkNo}");
		jQuery("#wp2_btnMateStkNo").change();
	}
}


function optionPants2ChangeModel(productCategory){
	var pants2Flag = jQuery("#pants2Flag").val();
	 if(pants2Flag == "1"){
		if(productCategory == "9000101"){
			var op2PantsModel = jQuery("#op2_pantsModel").val();
			if(isEmpty(op2PantsModel)){
	               return; 
			}
			//タック
			var frontBtnCntElem = jQuery('#op2_tack');
			var selectedFrontBtnCnt = frontBtnCntElem.val();

			// フロント釦数の選択肢更新
			frontBtnCntElem.empty();
			var tmpFrontBtnCnt = null;
			var isExistBefore = false;
			for (tmpFrontBtnCnt of lapelDesignImageMap[op2PantsModel].activeList) {
				frontBtnCntElem.append(jQuery('<option />').val(tmpFrontBtnCnt.val).text(tmpFrontBtnCnt.text));
				if (tmpFrontBtnCnt == selectedFrontBtnCnt) isExistBefore = true;
			}

			var op2Tack = "${orderCoForm.coOptionPants2StandardInfo.op2Tack}";
			frontBtnCntElem.val(op2Tack);
			frontBtnCntElem.change();

			jQuery('input[name="coOptionPants2StandardInfo.op2KneeBack"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2KneeBack}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2KneeBack"]:checked').change();

			//膝裏素材
			jQuery('input[name="coOptionPants2StandardInfo.op2KneeBackMate"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2KneeBackMate}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2KneeBackMate"]:checked').change();

			//フロント仕様
			jQuery('input[name="coOptionPants2StandardInfo.op2FrontSpec"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2FrontSpec}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2FrontSpec"]:checked').change();
			
			//アジャスター仕様
			jQuery('input[name="coOptionPants2StandardInfo.op2Adjuster"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2Adjuster}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2Adjuster"]:checked').change();

			//ピンループ
			jQuery('input[name="coOptionPants2StandardInfo.op2PinLoop"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2PinLoop}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2PinLoop"]:checked').change();

			//脇ポケット	
			jQuery('input[name="coOptionPants2StandardInfo.op2SidePkt"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2SidePkt}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2SidePkt"]:checked').change();
			
			//忍びポケット
			jQuery('input[name="coOptionPants2StandardInfo.op2SinobiPkt"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2SinobiPkt}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2SinobiPkt"]:checked').change();

			//フラップ付コインポケット
			jQuery('input[name="coOptionPants2StandardInfo.op2FlapCoinPkt"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2FlapCoinPkt}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2FlapCoinPkt"]:checked').change();

			//上前ピスポケット
			jQuery('input[name="coOptionPants2StandardInfo.op2PisPktUf"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2PisPktUf}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2PisPktUf"]:checked').change();

			//下前ピスポケット 
			jQuery('input[name="coOptionPants2StandardInfo.op2PisPktDf"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2PisPktDf}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2PisPktDf"]:checked').change();

			//Vカット
            jQuery('input[name="coOptionPants2StandardInfo.op2VCut"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2VCut}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2VCut"]:checked').change();

			//ステッチ種類 
			jQuery('input[name="coOptionPants2StandardInfo.op2Stitch"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2Stitch}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2Stitch"]:checked').change();

			//ステッチ箇所変更
            jQuery('input[name="coOptionPants2StandardInfo.op2StitchModify"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2StitchModify}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2StitchModify"]:checked').change();

			//ダブルステッチ
			jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2DStitch}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2DStitch"]:checked').change();

			//AMF色指定
			jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor"]').val(["${orderCoForm.coOptionPants2StandardInfo.op2AmfColor}"]);
			jQuery('input[name="coOptionPants2StandardInfo.op2AmfColor"]:checked').change();

		}else if(productCategory == "9000102"){
			var tp2PantsModel = jQuery("#tp2_pantsModel").val();
			if(isEmpty(tp2PantsModel)){
	               return; 
			}
			// 選択中のフロント釦数
			var frontBtnCntElem = jQuery('#tp2_tack');
			var selectedFrontBtnCnt = frontBtnCntElem.val();

			// フロント釦数の選択肢更新
			frontBtnCntElem.empty();
			var tmpFrontBtnCnt = null;
			for (tmpFrontBtnCnt of lapelDesignTuxedoImageMap[tp2PantsModel].activeList) {
				frontBtnCntElem.append(jQuery('<option />').val(tmpFrontBtnCnt.val).text(tmpFrontBtnCnt.text));
			}

			var tjFrontBtnCnt = "${orderCoForm.coOptionPants2TuxedoInfo.tp2Tack}";
			frontBtnCntElem.val(tjFrontBtnCnt);
			frontBtnCntElem.change();

			//膝裏
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2KneeBack"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2KneeBack}"]);
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2KneeBack"]:checked').change();

			//膝裏素材
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2KneeBackMate"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2KneeBackMate}"]);
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2KneeBackMate"]:checked').change();

			//フロント仕様
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2FrontSpec"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2FrontSpec}"]);
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2FrontSpec"]:checked').change();

			//パンチェリーナ
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2Pancherina"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2Pancherina}"]);
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2Pancherina"]:checked').change();

			//アジャスター仕様
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2Adjuster"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2Adjuster}"]);
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2Adjuster"]:checked').change();

			//ベルトループ
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoop"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2BeltLoop}"]);
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2BeltLoop"]:checked').change();

			//ピンループ
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2PinLoop"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2PinLoop}"]);
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2PinLoop"]:checked').change();

			//脇ポケット
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2SidePkt"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2SidePkt}"]);
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2SidePkt"]:checked').change();

			//忍びポケット
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2SinobiPkt"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2SinobiPkt}"]);
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2SinobiPkt"]:checked').change();

			//フラップ付コインポケット
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2FlapCoinPkt"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2FlapCoinPkt}"]);
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2FlapCoinPkt"]:checked').change();

			//上前ピスポケット
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2PisPktUf"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2PisPktUf}"]);
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2PisPktUf"]:checked').change();

			//下前ピスポケット
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2PisPktDf"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2PisPktDf}"]);
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2PisPktDf"]:checked').change();

			//Vカット
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2VCut"]').val(["${orderCoForm.coOptionPants2TuxedoInfo.tp2VCut}"]);
			jQuery('input[name="coOptionPants2TuxedoInfo.tp2VCut"]:checked').change();

			//裾上げ
			jQuery("#tp2_hemUp").val("${orderCoForm.coOptionPants2TuxedoInfo.tp2HemUp}");
		    jQuery("#tp2_hemUp").change();

		    //ダブル幅
			jQuery("#tp2_doubleWide").val("${orderCoForm.coOptionPants2TuxedoInfo.tp2DoubleWide}");
		    jQuery("#tp2_doubleWide").change();
			
		}else if(productCategory == "9000103"){
			var wp2PantsModel = jQuery("#wp2_pantsModel").val();
			if(isEmpty(wp2PantsModel)){
	               return; 
			}
			// 選択中のフロント釦数
			var frontBtnCntElem = jQuery('#wp2_tack');
			var selectedFrontBtnCnt = frontBtnCntElem.val();

			// フロント釦数の選択肢更新
			frontBtnCntElem.empty();
			var tmpFrontBtnCnt = null;
			for (tmpFrontBtnCnt of lapelDesignImageMap[wp2PantsModel].activeList) {
				frontBtnCntElem.append(jQuery('<option />').val(tmpFrontBtnCnt.val).text(tmpFrontBtnCnt.text));
			}
			
			var wjFrontBtnCnt = "${orderCoForm.coOptionPants2WashableInfo.wp2Tack}";
			frontBtnCntElem.val(wjFrontBtnCnt);
			frontBtnCntElem.change();

			//膝裏
			jQuery('input[name="coOptionPants2WashableInfo.wp2KneeBack"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2KneeBack}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2KneeBack"]:checked').change();

			//膝裏素材
			jQuery('input[name="coOptionPants2WashableInfo.wp2KneeBackMate"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2KneeBackMate}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2KneeBackMate"]:checked').change();

			//フロント仕様
			jQuery('input[name="coOptionPants2WashableInfo.wp2FrontSpec"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2FrontSpec}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2FrontSpec"]:checked').change();
			
			//パンチェリーナ
			jQuery('input[name="coOptionPants2WashableInfo.wp2Pancherina"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2Pancherina}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2Pancherina"]:checked').change();

			//アジャスター仕様
			jQuery('input[name="coOptionPants2WashableInfo.wp2Adjuster"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2Adjuster}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2Adjuster"]:checked').change();

			//ベルトループ
			jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2BeltLoop}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2BeltLoop"]:checked').change();

			//ピンループ
			jQuery('input[name="coOptionPants2WashableInfo.wp2PinLoop"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2PinLoop}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2PinLoop"]:checked').change();
			
			//脇ポケット
			jQuery('input[name="coOptionPants2WashableInfo.wp2SidePkt"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2SidePkt}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2SidePkt"]:checked').change();

			//忍びポケット
			jQuery('input[name="coOptionPants2WashableInfo.wp2SinobiPkt"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2SinobiPkt}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2SinobiPkt"]:checked').change();

			//フラップ付コインポケット
			jQuery('input[name="coOptionPants2WashableInfo.wp2FlapCoinPkt"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2FlapCoinPkt}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2FlapCoinPkt"]:checked').change();

			//上前ピスポケット
			jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktUf"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2PisPktUf}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktUf"]:checked').change();

			//下前ピスポケット 
			jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktDf"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2PisPktDf}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2PisPktDf"]:checked').change();

			//Vカット
			jQuery('input[name="coOptionPants2WashableInfo.wp2VCut"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2VCut}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2VCut"]:checked').change();

			//ステッチ種類
			jQuery('input[name="coOptionPants2WashableInfo.wp2Stitch"]').val(["${orderCoForm.coOptionPants2WashableInfo.wp2Stitch}"]);
			jQuery('input[name="coOptionPants2WashableInfo.wp2Stitch"]:checked').change();		
		}
	} 
}
function  sessionPantsAdFlag(oldModel,newModel){
	if(oldModel != newModel){
		if(orderFlag == "orderBack" || orderFlag == "orderLink"){
			 jQuery("#pants2AdFlag").val("0");
		}
	}
}
jQuery("#op2_pantsModel,#tp2_pantsModel,wp2_pantsModel").change(function(){
	if(orderFlag == "orderCo"){
		jQuery("#pants2AdFlag").val("0");
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