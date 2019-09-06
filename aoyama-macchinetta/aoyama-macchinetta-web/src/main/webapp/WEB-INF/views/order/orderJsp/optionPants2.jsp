<form:form id="idInfoForm" action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm" method="post" modelAttribute="orderForm" class="form-horizontal">
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
                                <form:select id="op2_pantsModel" path="optionPants2StandardInfo.op2PantsModel" class="form-control-sm form-control">
                               <form:options items="${orderForm.optionPants2StandardInfo.op2PantsModelMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_pantsModelMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                                <form:select id="op2_tack" path="optionPants2StandardInfo.op2Tack" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPants2StandardInfo.op2TackMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_tackMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_kneeBack"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                     <form:radiobuttons id="op2_kneeBack_id" path="optionPants2StandardInfo.op2KneeBack" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2KneeBackMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group" id="op2_kneeBackMate_div">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_kneeBackMate_id" path="optionPants2StandardInfo.op2KneeBackMate" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2KneeBackMateMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント仕様</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_frontSpec"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_frontSpec_id" path="optionPants2StandardInfo.op2FrontSpec" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2FrontSpecMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_pancherina_id" path="optionPants2StandardInfo.op2Pancherina" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2PancherinaMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_pancherinaMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_adjuster_id" path="optionPants2StandardInfo.op2Adjuster" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2AdjusterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_adjusterMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベルトループ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_beltLoop"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_beltLoop_id" path="optionPants2StandardInfo.op2BeltLoop" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2BeltLoopMap}"/>
                                </div>
                                <div class="offset-md-1" id="op2_beltLoopPlace">
                                    <div>
                                        <div class="form-check-inline form-check">
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op2_beltLoopPlace">全選択</button>&nbsp;
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op2_beltLoopPlace">全解除</button>
                                        </div>
                                    </div>
                                    <%-- <div class="form-check-inline form-check">
                                        <form:checkboxes id="op2_beltLoopPlace_id" items="${orderForm.optionPants2StandardInfo.op2BeltLoopPlaceMap }" path="optionPants2StandardInfo.op2BeltLoopPlace" class="form-check-input"/>
                                    </div> --%>
                                     <c:forEach var="op2BeltLoopPlaceMap" items="${orderForm.optionPants2StandardInfo.op2BeltLoopPlaceMap }" varStatus="row">
                                		<div class="form-check-inline form-check" id="op2_beltLoopPlace_id1${row.count}">
                                			<input type="checkbox" id="op2_beltLoopPlace_id${row.count}" name="optionPants2StandardInfo.op2BeltLoopPlace${row.count}" value="${op2BeltLoopPlaceMap.key}" class="form-check-input">${op2BeltLoopPlaceMap.value}
                                		</div>
                                	</c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_beltLoopMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_pinLoop_id" path="optionPants2StandardInfo.op2PinLoop" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2PinLoopMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_pinLoopMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_sidePkt_id" path="optionPants2StandardInfo.op2SidePkt" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2SidePktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_sidePktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_sinobiPkt_id" path="optionPants2StandardInfo.op2SinobiPkt" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2SinobiPktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_sinobiPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コインポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_coinPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op2_coinPkt" class="form-control-sm form-control" path="optionPants2StandardInfo.op2CoinPkt">
                                	<form:options items="${orderForm.optionPants2StandardInfo.op2CoinPktMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_coinPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                   	<form:radiobuttons id="op2_flapCoinPkt_id" path="optionPants2StandardInfo.op2FlapCoinPkt" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2FlapCoinPktMap }"/>　
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_flapCoinPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_pisPktUf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_pisPktUf_id" path="optionPants2StandardInfo.op2PisPktUf" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2PisPktUfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_pisPktUfMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_pisPktDf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_pisPktDf_id" path="optionPants2StandardInfo.op2PisPktDf" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2PisPktDfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_pisPktDfMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">Vカット</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_vCut_id" path="optionPants2StandardInfo.op2VCut" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2VCutMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="op2_vCutMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_hemUp"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op2_hemUp" path="optionPants2StandardInfo.op2HemUp" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPants2StandardInfo.op2HemUpMap }"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group"  id="op2_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                                <form:select id="op2_doubleWide" path="optionPants2StandardInfo.op2DoubleWide" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPantsStandardInfo.opDoubleWideMap }"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_stitch"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_stitch_id" path="optionPants2StandardInfo.op2Stitch" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2StitchMap }"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                            <div class="col-12 col-md-9">
                                 <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_stitchModify_id" path="optionPants2StandardInfo.op2StitchModify" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2StitchModifyMap }"/>
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
                                    <form:checkboxes id="op2_stitchModifyPlace_id" items="${orderForm.optionPants2StandardInfo.op2StitchModifyPlaceMap }" path="optionPants2StandardInfo.op2StitchModifyPlace" class="form-check-input"/>
                                </div> --%>
                                <c:forEach var="op2StitchModifyPlaceMap" items="${orderForm.optionPants2StandardInfo.op2StitchModifyPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="op2_stitchModifyPlace_id${row.count}" name="optionPants2StandardInfo.op2StitchModifyPlace${row.count}" value="${op2StitchModifyPlaceMap.key}" class="form-check-input">${op2StitchModifyPlaceMap.value}
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
                                    <form:radiobuttons id="op2_dStitch_id" path="optionPants2StandardInfo.op2DStitch" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2DStitchMap }"/>
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
                                    <form:checkboxes id="op2_dStitchPlace_id" items="${orderForm.optionPants2StandardInfo.op2DStitchPlaceMap }" path="optionPants2StandardInfo.op2DStitchPlace" class="form-check-input"/>
                                </div> --%>
                                <c:forEach var="op2DStitchPlaceMap" items="${orderForm.optionPants2StandardInfo.op2DStitchPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="op2_dStitchPlace_id${row.count}" name="optionPants2StandardInfo.op2DStitchPlace${row.count}" value="${op2DStitchPlaceMap.key}" class="form-check-input">${op2DStitchPlaceMap.value}                               		
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
                                    <form:radiobuttons id="op2_amfColor_id" path="optionPants2StandardInfo.op2AmfColor" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2AmfColorMap }"/>
                                </div>
                                <div id="op2_amfColor_div" style="display:none;">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="op2_amfColorPlaceAll" path="optionPants2StandardInfo.op2AmfColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPants2StandardInfo.op2AmfColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op2_amfColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op2_amfColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="op2AmfColorPlaceMap" items="${orderForm.optionPants2StandardInfo.op2AmfColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="op2_amfColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="op2_amfColorPlace_${row.count}" name="optionPants2StandardInfo.op2AmfColorPlace${row.count}" value="${op2AmfColorPlaceMap.key }" class="form-check-input">${op2AmfColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="op2_amfColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="op2AmfColorsMap" items="${orderForm.optionPants2StandardInfo.op2AmfColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op2_amfColor" class="form-check-label ">
                                			    <input type="radio" id="op2_amfColor_${op2AmfColorsMap.key}" name="optionPants2StandardInfo.op2AmfColor${row.count}" value="${op2AmfColorsMap.key}" class="form-check-input">${op2AmfColorsMap.value}
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
                                    <form:radiobuttons id="op2_bhColor_id" path="optionPants2StandardInfo.op2BhColor" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2BhColorMap }"/>
                                </div>
                                <div id="op2_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="op2_bhColorPlaceAll" path="optionPants2StandardInfo.op2BhColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPants2StandardInfo.op2BhColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op2_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op2_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="op2BhColorPlaceMap" items="${orderForm.optionPants2StandardInfo.op2BhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="op2_bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="op2_bhColorPlace_${row.count}" name="optionPants2StandardInfo.op2BhColorPlace${row.count}" value="${op2BhColorPlaceMap.key }" class="form-check-input">${op2BhColorPlaceMap.value }                                      
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="op2_bhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="op2BhColorsMap" items="${orderForm.optionPants2StandardInfo.op2BhColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op2_bhColor" class="form-check-label ">
                                			    <input type="radio" id="op2_bhColor_${op2BhColorsMap.key}" name="optionPants2StandardInfo.op2BhColor${row.count}" value="${op2BhColorsMap.key}" class="form-check-input">${op2BhColorsMap.value}                               			                                    			  
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
                                    <form:radiobuttons id="op2_byColor_id" path="optionPants2StandardInfo.op2ByColor" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2ByColorMap }"/>
                                </div>
                                <div id="op2_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="op2_byColorPlaceAll" path="optionPants2StandardInfo.op2ByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPants2StandardInfo.op2ByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_op2_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_op2_byColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="op2ByColorPlaceMap" items="${orderForm.optionPants2StandardInfo.op2ByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="op2_byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="op2_byColorPlace_${row.count}" name="optionPants2StandardInfo.op2ByColorPlace${row.count}" value="${op2ByColorPlaceMap.key }" class="form-check-input">${op2ByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>                   	
                                	<div class="offset-md-2" id="op2_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="op2ByColorsMap" items="${orderForm.optionPants2StandardInfo.op2ByColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op2_byColorPlace" class="form-check-label ">
                                			    <input type="radio" id="op2_byColor_${op2ByColorsMap.key}" name="optionPants2StandardInfo.op2ByColor${row.count}" value="${op2ByColorsMap.key}" class="form-check-input">${op2ByColorsMap.value}                                			  
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
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_op2_button"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="op2_btnMate" class="form-control-sm form-control" path="optionPants2StandardInfo.op2Button">
                                	<form:options items="${orderForm.optionPants2StandardInfo.op2ButtonMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                               <!--  <select name="op2_btnMateStkNo" id="op2_btnMateStkNo" class="form-control-sm form-control">
                                </select> -->
                                <select name="optionPants2StandardInfo.op2BtnMateStkNo" id="op2_btnMateStkNo" class="form-control-sm form-control">
                                </select>                          
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_suspenderBtn_id" path="optionPants2StandardInfo.op2SuspenderBtn" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2SuspenderBtnMap }"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
                            <div class="col-12 col-md-9">
                                 <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_thick_id" path="optionPants2StandardInfo.op2Thick" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2ThickMap }"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_eight_id" path="optionPants2StandardInfo.op2Eight" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2EightMap }"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="op2_shapeMemory_id" path="optionPants2StandardInfo.op2ShapeMemory" class="form-check-input" items="${orderForm.optionPants2StandardInfo.op2ShapeMemoryMap }"/>
                                </div>
                            </div>
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
                            	<form:select id="tp2_pantsModel" path="optionPants2TuxedoInfo.tp2PantsModel" class="form-control-sm form-control">
                                <form:options items="${orderForm.optionPants2TuxedoInfo.tp2PantsModelMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_pantsModelMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tp2_tack" path="optionPants2TuxedoInfo.tp2Tack" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPants2TuxedoInfo.tp2TackMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_tackMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_kneeBack"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                     <form:radiobuttons id="tp2_kneeBack_id" path="optionPants2TuxedoInfo.tp2KneeBack" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2KneeBackMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group" id="tp2_kneeBackMate_div">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_kneeBackMate_id" path="optionPants2TuxedoInfo.tp2KneeBackMate" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2KneeBackMateMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント仕様</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_frontSpec"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_frontSpec_id" path="optionPants2TuxedoInfo.tp2FrontSpec" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2FrontSpecMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_pancherina_id" path="optionPants2TuxedoInfo.tp2Pancherina" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2PancherinaMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_pancherinaMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_adjuster_id" path="optionPants2TuxedoInfo.tp2Adjuster" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2AdjusterMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_adjusterMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベルトループ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_beltLoop"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_beltLoop_id" path="optionPants2TuxedoInfo.tp2BeltLoop" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2BeltLoopMap}"/>
                                </div>
                                <div class="offset-md-1" id="tp2_beltLoopPlace">
                                    <div>
                                        <div class="form-check-inline form-check">
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tp2_beltLoopPlace">全選択</button>&nbsp;
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tp2_beltLoopPlace">全解除</button>
                                        </div>
                                    </div>
                                    <%-- <div class="form-check-inline form-check">
                                    	<form:checkboxes id="tp2_beltLoopPlace_id" items="${orderForm.optionPants2TuxedoInfo.tp2BeltLoopPlaceMap }" path="optionPants2TuxedoInfo.tp2BeltLoopPlace" class="form-check-input"/>
                                    </div> --%>
                                    <c:forEach var="tp2BeltLoopPlaceMap" items="${orderForm.optionPants2TuxedoInfo.tp2BeltLoopPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="tp2_beltLoopPlace_id${row.count}" name="optionPants2TuxedoInfo.tp2BeltLoopPlace${row.count}" value="${tp2BeltLoopPlaceMap.key}" class="form-check-input">${tp2BeltLoopPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_beltLoopMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_pinLoop_id" path="optionPants2TuxedoInfo.tp2PinLoop" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2PinLoopMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_pinLoopMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_sidePkt_id" path="optionPants2TuxedoInfo.tp2SidePkt" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2SidePktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_sidePktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_sinobiPkt_id" path="optionPants2TuxedoInfo.tp2SinobiPkt" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2SinobiPktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_sinobiPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コインポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_coinPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tp2_coinPkt_id" class="form-control-sm form-control" path="optionPants2TuxedoInfo.tp2CoinPkt">
                                	<form:options items="${orderForm.optionPants2TuxedoInfo.tp2CoinPktMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_coinPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
                            <div class="col-12 col-md-9">
                           		<div class="form-check-inline form-check">
                                   	<form:radiobuttons id="tp2_flapCoinPkt_id" path="optionPants2TuxedoInfo.tp2FlapCoinPkt" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2FlapCoinPktMap }"/>　
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_flapCoinPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_pisPktUf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_pisPktUf_id" path="optionPants2TuxedoInfo.tp2PisPktUf" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2PisPktUfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_pisPktUfMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_pisPktDf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_pisPktDf_id" path="optionPants2TuxedoInfo.tp2PisPktDf" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2PisPktDfMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_pisPktDfMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">Vカット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_vCut_id" path="optionPants2TuxedoInfo.tp2VCut" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2VCutMap }"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tp2_vCutMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_hemUp"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tp2_hemUp" path="optionPants2TuxedoInfo.tp2HemUp" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPants2TuxedoInfo.tp2HemUpMap }"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group"  id="tp2_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tp2_doubleWide" path="optionPants2TuxedoInfo.tp2DoubleWide" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionPants2TuxedoInfo.tp2DoubleWideMap }"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_stitch_id" path="optionPants2TuxedoInfo.tp2Stitch" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2StitchMap }"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_bhColor_id" path="optionPants2TuxedoInfo.tp2BhColor" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2BhColorMap }"/>
                                </div>
                                <div id="tp2_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="tp2_bhColorPlaceAll" path="optionPants2TuxedoInfo.tp2BhColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPants2TuxedoInfo.tp2BhColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tp2_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tp2_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="tp2BhColorPlaceMap" items="${orderForm.optionPants2TuxedoInfo.tp2BhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="tp2_bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="tp2_bhColorPlace_${row.count}" name="optionPants2TuxedoInfo.tp2BhColorPlace${row.count}" value="${tp2BhColorPlaceMap.key }" class="form-check-input">${tp2BhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>                        
                                	<div class="offset-md-2" id="tp2_bhColorPlace_${row.count}_div"  style="display:none">
                                		<c:forEach var="tp2BhColorMap" items="${orderForm.optionPants2TuxedoInfo.tp2BhColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="tp2_bhColor" class="form-check-label ">
                                			    <input type="radio" id="tp2_bhColor_${tp2BhColorMap.key}" name="optionPants2TuxedoInfo.tp2BhColor${row.count}" value="${tp2BhColorMap.key}" class="form-check-input">${tp2BhColorMap.value}
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
                                	<form:radiobuttons id="tp2_byColor_id" path="optionPants2TuxedoInfo.tp2ByColor" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2ByColorMap }"/>
                                </div>
                                <div id="tp2_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="tp2_byColorPlaceAll" path="optionPants2TuxedoInfo.tp2ByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPants2TuxedoInfo.tp2ByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tp2_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tp2_byColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="tp2ByColorPlaceMap" items="${orderForm.optionPants2TuxedoInfo.tp2ByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="tp2_byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="tp2_byColorPlace_${row.count}" name="optionPants2TuxedoInfo.tp2ByColorPlace${row.count}" value="${tp2ByColorPlaceMap.key }" class="form-check-input">${tp2ByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="tp2_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="tp2ByColorMap" items="${orderForm.optionPants2TuxedoInfo.tp2ByColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="tp2_byColor" class="form-check-label ">
                                			    <input type="radio" id="tp2_byColor_${tp2ByColorMap.key}" name="optionPants2TuxedoInfo.tp2ByColor${row.count}" value="${tp2ByColorMap.key}" class="form-check-input">${tp2ByColorMap.value}
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
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tp2_button"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tp2_btnMate" class="form-control-sm form-control" path="optionPants2TuxedoInfo.tp2Button">
                                	<form:options items="${orderForm.optionPants2TuxedoInfo.tp2ButtonMap }"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionPants2TuxedoInfo.tp2BtnMateStkNo" id="tp2_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                            <div class="col col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="tp2_sameJacketBtn">JKと同じ</button>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_suspenderBtn_id" path="optionPants2TuxedoInfo.tp2SuspenderBtn" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2SuspenderBtnMap }"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_thick_id" path="optionPants2TuxedoInfo.tp2Thick" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2ThickMap }"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_eight_id" path="optionPants2TuxedoInfo.tp2Eight" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2EightMap }"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_shapeMemory_id" path="optionPants2TuxedoInfo.tp2ShapeMemory" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2ShapeMemoryMap }"/>
                                </div>
                            </div>
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
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_sideStripe_id" path="optionPants2TuxedoInfo.tp2SideStripe" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2SideStripeMap }"/>
                                </div>
                            </div>
                        </div>
                        <div id="tp2_sideStripe_yes_area">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">側章幅</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tp2_sideStripeWidth_id" path="optionPants2TuxedoInfo.tp2SideStripeWidth" class="form-check-input" items="${orderForm.optionPants2TuxedoInfo.tp2SideStripeWidthMap }"/>
                                </div>
                            </div>
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
                            	<form:select id="wp2_pantsModel" path="optionPants2WashableInfo.wp2PantsModel" class="form-control-sm form-control">
									<form:options items="${orderForm.optionPants2WashableInfo.wp2PantsModelMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_pantsModelMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">タック</label></div>
                            <div class="col col-md-3">
                            	<form:select id="wp2_tack_id" path="optionPants2WashableInfo.wp2Tack" class="form-control-sm form-control">
									<form:options items="${orderForm.optionPants2WashableInfo.wp2TackMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_tackMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_kneeBack"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_kneeBack_id" path="optionPants2WashableInfo.wp2KneeBack" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2KneeBackMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group" id="wp2_kneeBackMate_div">
                            <div class="col col-md-3"><label class=" form-control-label">膝裏素材</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_kneeBackMate_id" path="optionPants2WashableInfo.wp2KneeBackMate" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2KneeBackMateMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント仕様</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_frontSpec"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_frontSpec_id" path="optionPants2WashableInfo.wp2FrontSpec" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2FrontSpecMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">パンチェリーナ</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_pancherina_id" path="optionPants2WashableInfo.wp2Pancherina" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2PancherinaMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_pancherinaMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">アジャスター仕様</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_adjuster_id" path="optionPants2WashableInfo.wp2Adjuster" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2AdjusterMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_adjusterMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベルトループ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_beltLoop"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_beltLoop_id" path="optionPants2WashableInfo.wp2BeltLoop" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2BeltLoopMap}"/>
								</div>
                                <div class="offset-md-1" id="wp2_beltLoopPlace">
                                    <div>
                                        <div class="form-check-inline form-check">
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp2_beltLoopPlace">全選択</button>&nbsp;
                                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp2_beltLoopPlace">全解除</button>
                                        </div>
                                    </div>
                                    <%-- <div class="form-check-inline form-check">
										<form:checkboxes id="wp2_beltLoopPlace_id" path="optionPants2WashableInfo.wp2BeltLoopPlace" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2BeltLoopPlaceMap}"/>
									</div> --%>
									 <c:forEach var="wp2BeltLoopPlaceMap" items="${orderForm.optionPants2WashableInfo.wp2BeltLoopPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="wp2_beltLoopPlace_id${row.count}" name="optionPants2WashableInfo.wp2BeltLoopPlace${row.count}" value="${wp2BeltLoopPlaceMap.key}" class="form-check-input">${wp2BeltLoopPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_beltLoopMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ピンループ</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_pinLoop_id" path="optionPants2WashableInfo.wp2PinLoop" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2PinLoopMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_pinLoopMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">脇ポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_sidePkt_id" path="optionPants2WashableInfo.wp2SidePkt" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2SidePktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_sidePktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_sinobiPkt_id" path="optionPants2WashableInfo.wp2SinobiPkt" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2SinobiPktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_sinobiPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">コインポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_coinPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp2_coinPkt_id" path="optionPants2WashableInfo.wp2CoinPkt" class="form-control-sm form-control">
									<form:options items="${orderForm.optionPants2WashableInfo.wp2CoinPktMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_coinPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラップ付コインポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_flapCoinPkt_id" path="optionPants2WashableInfo.wp2FlapCoinPkt" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2FlapCoinPktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_flapCoinPktMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">上前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_pisPktUf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_pisPktUf_id" path="optionPants2WashableInfo.wp2PisPktUf" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2PisPktUfMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_pisPktUfMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前ピスポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_pisPktDf"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_pisPktDf_id" path="optionPants2WashableInfo.wp2PisPktDf" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2PisPktDfMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_pisPktDfMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">Vカット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_vCut_id" path="optionPants2WashableInfo.wp2VCut" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2VCutMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wp2_vCutMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裾上げ</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_hemUp"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp2_hemUp_id" path="optionPants2WashableInfo.wp2HemUp" class="form-control-sm form-control">
									<form:options items="${orderForm.optionPants2WashableInfo.wp2HemUpMap}"/>
								</form:select>
                            </div>
                        </div>
                        <div class="row form-group"  id="wp2_doubleWide_div" style="display:none;">
                            <div class="col col-md-3"><label class=" form-control-label">ダブル幅</label></div>
                            <div class="col col-md-3">
                            	<form:select id="wp2_doubleWide_id" path="optionPants2WashableInfo.wp2DoubleWide" class="form-control-sm form-control">
									<form:options items="${orderForm.optionPants2WashableInfo.wp2DoubleWideMap}"/>
								</form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_stitch_id" path="optionPants2WashableInfo.wp2Stitch" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2StitchMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_stitchModify_id" path="optionPants2WashableInfo.wp2StitchModify" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2StitchModifyMap}"/>
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
									<form:checkboxes id="wp2_stitchModifyPlace_id" path="optionPants2WashableInfo.wp2StitchModifyPlace" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2StitchModifyPlaceMap}"/>
								</div> --%>
								 <c:forEach var="wp2StitchModifyPlaceMap" items="${orderForm.optionPants2WashableInfo.wp2StitchModifyPlaceMap }" varStatus="row">
                                		<div class="form-check-inline form-check">
                                			<input type="checkbox" id="wp2_stitchModifyPlace_id${row.count}" name="optionPants2WashableInfo.wp2StitchModifyPlace${row.count}" value="${wp2StitchModifyPlaceMap.key}" class="form-check-input">${wp2StitchModifyPlaceMap.value}
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
									<form:radiobuttons id="wp2_dStitch_id" path="optionPants2WashableInfo.wp2DStitch" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2DStitchMap}"/>
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
									<form:checkboxes id="wp2_dStitchPlace_id" path="optionPants2WashableInfo.wp2DStitchPlace" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2DStitchPlaceMap}"/>
								</div> --%>
								<c:forEach var="wp2DStitchPlaceMap" items="${orderForm.optionPants2WashableInfo.wp2DStitchPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="wp2_dStitchModifyPlace_id${row.count}" name="optionPantsStandardInfo.wp2DStitchPlace${row.count}" value="${wp2DStitchPlaceMap.key}" class="form-check-input">${wp2DStitchPlaceMap.value}
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
									<form:radiobuttons id="wp2_amfColor_id" path="optionPants2WashableInfo.wp2AmfColor" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2AmfColorMap}"/>
								</div>
                                <div id="wp2_amfColor_div" style="display:none;">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="wp2_amfColorPlaceAll" path="optionPants2WashableInfo.wp2AmfColorPlaceAll" class="form-control-sm form-control">
										<form:options items="${orderForm.optionPants2WashableInfo.wp2AmfColorPlaceAllMap}"/>
									</form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp2_amfColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp2_amfColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wp2AmfColorPlaceMap" items="${orderForm.optionPants2WashableInfo.wp2AmfColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wp2_amfColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wp2_amfColorPlace_${row.count}" name="optionPants2WashableInfo.wp2AmfColorPlace${row.count}" value="${wp2AmfColorPlaceMap.key }" class="form-check-input">${wp2AmfColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>    	
                                 <div class="offset-md-2" id="wp2_amfColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wp2AmfColorsMap" items="${orderForm.optionPants2WashableInfo.wp2AmfColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wp2_amfColor" class="form-check-label ">
                                			    <input type="radio" id="wp2_amfColor_${wp2AmfColorsMap.key}" name="optionPants2WashableInfo.wp2AmfColor${row.count}" value="${wp2AmfColorsMap.key}" class="form-check-input">${wp2AmfColorsMap.value}                    
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
									<form:radiobuttons id="wp2_bhColor_id" path="optionPants2WashableInfo.wp2BhColor" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2BhColorMap}"/>
								</div>
                                <div id="wp2_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="wp2_bhColorPlaceAll" path="optionPants2WashableInfo.wp2BhColorPlaceAll" class="form-control-sm form-control">
										<form:options items="${orderForm.optionPants2WashableInfo.wp2BhColorPlaceAllMap}"/>
									</form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp2_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp2_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wp2BhColorPlaceMap" items="${orderForm.optionPants2WashableInfo.wp2BhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wp2_bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wp2_bhColorPlace_${row.count}" name="optionPants2WashableInfo.wp2BhColorPlace${row.count}" value="${wp2BhColorPlaceMap.key }" class="form-check-input">${wp2BhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>                       
                                	<div class="offset-md-2" id="wp2_bhColorPlace_${row.count}_div" style="display:none">                       
                                		<c:forEach var="wp2BhColorMap" items="${orderForm.optionPants2WashableInfo.wp2BhColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wp2_bhColorPlace" class="form-check-label ">
                                			    <input type="radio" id="wp2_bhColor_${wp2BhColorMap.key}" name="optionPants2WashableInfo.wp2BhColor${row.count}" value="${wp2BhColorMap.key}" class="form-check-input">${wp2BhColorMap.value}                                  			                      			   
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
                                    <form:radiobuttons id="wp2_byColor_id" path="optionPants2WashableInfo.wp2ByColor" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2ByColorMap }"/>
                                </div>
                                <div id="wp2_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="wp2_byColorPlaceAll" path="optionPants2WashableInfo.wp2ByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionPants2WashableInfo.wp2ByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wp2_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wp2_byColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wp2ByColorPlaceMap" items="${orderForm.optionPants2WashableInfo.wp2ByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wp2_byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wp2_byColorPlace_${row.count}" name="optionPants2WashableInfo.wp2ByColorPlace${row.count}" value="${wp2ByColorPlaceMap.key }" class="form-check-input">${wp2ByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>                  
                                	<div class="offset-md-2" id="wp2_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wp2ByColorsMap" items="${orderForm.optionPants2WashableInfo.wp2ByColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wp2_byColorPlace" class="form-check-label ">
                                			    <input type="radio" id="wp2_byColor_${wp2ByColorsMap.key}" name="optionPants2WashableInfo.wp2ByColor${row.count}" value="${wp2ByColorsMap.key}" class="form-check-input">${wp2ByColorsMap.value}
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
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wp2_button"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wp2_btnMate" path="optionPants2WashableInfo.wp2Button" class="form-control-sm form-control">
									<form:options items="${orderForm.optionPants2WashableInfo.wp2ButtonMap}"/>
								</form:select>
                            </div>
                            <div class="col col-md-4">                     
                                <select  name="optionPants2WashableInfo.wp2BtnMateStkNo" id="wp2_btnMateStkNo" class="form-control-sm form-control">
                                </select> 
                                 
                            </div>
                            <div class="col col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="wp2_sameJacketBtn">JKと同じ</button>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">サスペンダー釦</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_suspenderBtn_id" path="optionPants2WashableInfo.wp2SuspenderBtn" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2SuspenderBtnMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">シック大（股補強）</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_thick_id" path="optionPants2WashableInfo.wp2Thick" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2ThickMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">エイト（滑り止め）</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_eight_id" path="optionPants2WashableInfo.wp2Eight" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2EightMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wp2_shapeMemory_id" path="optionPants2WashableInfo.wp2ShapeMemory" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2ShapeMemoryMap}"/>
								</div>
                            </div>
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
            <input type="hidden" id="pants2Flag" name="pants2Flag" value="0"/>
            <input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="0"/>
            <input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="${orderForm.jacketItemFlag }"/>
			<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="${orderForm.giletItemFlag }"/>
			<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="${orderForm.shirtItemFlag }"/>
			<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="${orderForm.coatItemFlag }"/>
			<input type="hidden" id="pantsItemFlag" name="pantsItemFlag" value="${orderForm.pantsItemFlag }"/>
            <input type="hidden" id="pants2AdFlag" name="pants2AdFlag" value="0" />
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
<script src="${pageContext.request.contextPath}/resources/app/self/js/rule.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/config.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/customer.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/tabMenu.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/product.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants2.standard.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants2.tuxedo.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants2.washable.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";
jQuery(function() {

	var pants2AdFlag="${orderForm.pants2AdFlag}";
	if(pants2AdFlag=="1"){
		jQuery("#pants2AdFlag").val("${orderForm.pants2AdFlag}");
		}
	jQuery("#op2_pantsModel,#tp2_pantsModel,wp2_pantsModel").change(function(){
		jQuery("#pants2AdFlag").val("0");
	    }) 
	
	//getModelByItem();
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
	initOptionPants2Standard();

	initOptionPants2Tuxedo();

	initOptionPants2Washable();
	//--------------------------------------------
	// 補正タブ
	//--------------------------------------------
	//initAlter();
	jQuery("#pants2ItemFlag").val("1");
})	

function setPantsModelDisable(productCategory){
	var ptModel = null;
	if(productCategory == "0"){
		ptModel = document.getElementById("op2_pantsModel");
	}else if(productCategory == "2"){
		ptModel = document.getElementById("tp2_pantsModel");
	}else if(productCategory == "1"){
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

jQuery("#op2_pantsModel").change(function(){
	jQuery("#pants2Flag").val('1');
})

jQuery("#tp2_pantsModel").change(function(){
	jQuery("#pants2Flag").val('1');
})

jQuery("#wp2_pantsModel").change(function(){
	jQuery("#pants2Flag").val('1');
})

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
	/* if(item == "01"){
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
		
	} */
	// else 
	if(item=="01"){
		subItemCode = "07";
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
		mateSelect(itemCode,subItemCode,"#op2_btnMate option:checked","00033","#op2_btnMateStkNo",category,orderPattern);
		
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
		mateSelect(itemCode,subItemCode,"#tp2_btnMate option:checked","00033","#tp2_btnMateStkNo",category,orderPattern);
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
		mateSelect(itemCode,subItemCode,"#wp2_btnMate option:checked","00033","#wp2_btnMateStkNo",category,orderPattern);
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

/* function getModelByItem(){
	
	var itemCode = jQuery("#item").val();
	if(itemCode == "01"){

		var pt2Model = document.getElementById("op2_pantsModel");
		pt2Model.options.length=0;
		pt2Model.add(new Option("モデル選択",""));
		
		jQuery.ajax({
	        url: contextPath + "/orderCo/getModel",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
	               if(e.subItemCode == "07"){
	            	   pt2Model.add(new Option(e.modelName,e.modelCode));
	               }
	           });
	        }
	    });


		var allPt2Option = pt2Model.options;
		allPt2Option[0].disabled = true;
	    
	}
} */
//PANTS2本目（1本目と同じ）
jQuery('#btn_op2_samePants').click(function (){
	//PANTSモデル
	jQuery('#op2_pantsModel').val("${orderForm.optionPantsStandardInfo.opPantsModel}");
	//タック
	jQuery('#op2_tack').val("${orderForm.optionPantsStandardInfo.opTack}");	
	//膝裏
	jQuery('input[name="optionPants2StandardInfo.op2KneeBack"]').val(["${orderForm.optionPantsStandardInfo.opKneeBack}"]);
	jQuery('input[name="optionPants2StandardInfo.op2KneeBack"]').change();
	//膝裏素材
	jQuery('input[name="optionPants2StandardInfo.op2KneeBackMate"]').val(["${orderForm.optionPantsStandardInfo.opKneeBackMate}"]);
	jQuery('input[name="optionPants2StandardInfo.op2KneeBackMate"]').change();
	//フロント仕様
	jQuery('input[name="optionPants2StandardInfo.op2FrontSpec"]').val(["${orderForm.optionPantsStandardInfo.opFrontSpec}"]);
	jQuery('input[name="optionPants2StandardInfo.op2FrontSpec"]').change();
	//パンチェリーナ
	jQuery('input[name="optionPants2StandardInfo.op2Pancherina"]').val(["${orderForm.optionPantsStandardInfo.opPancherina}"]);
	jQuery('input[name="optionPants2StandardInfo.op2Pancherina"]').change();
	//アジャスター仕様
	jQuery('input[name="optionPants2StandardInfo.op2Adjuster"]').val(["${orderForm.optionPantsStandardInfo.opAdjuster}"]);
	jQuery('input[name="optionPants2StandardInfo.op2Adjuster"]').change();
	//ベルトループ
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoop"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoop}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoop"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace1"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace2"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace3"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace4"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace4"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace5"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace5}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace5"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace6"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace6}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace6"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace7"]').val(["${orderForm.optionPantsStandardInfo.opBeltLoopPlace7}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace7"]').change();

	//ピンループ
	jQuery('input[name="optionPants2StandardInfo.op2PinLoop"]').val(["${orderForm.optionPantsStandardInfo.opPinLoop}"]);
	jQuery('input[name="optionPants2StandardInfo.op2PinLoop"]').change();
	//脇ポケット
	jQuery('input[name="optionPants2StandardInfo.op2SidePkt"]').val(["${orderForm.optionPantsStandardInfo.opSidePkt}"]);
	jQuery('input[name="optionPants2StandardInfo.op2SidePkt"]').change();
	//忍びポケット
	jQuery('input[name="optionPants2StandardInfo.op2SinobiPkt"]').val(["${orderForm.optionPantsStandardInfo.opSinobiPkt}"]);
	jQuery('input[name="optionPants2StandardInfo.op2SinobiPkt"]').change();
	//コインポケット
	jQuery("#op2_coinPkt").val("${orderForm.optionPantsStandardInfo.opCoinPkt}");
	jQuery("#op2_coinPkt").change();
	//フラップ付コインポケット
	jQuery('input[name="optionPants2StandardInfo.op2FlapCoinPkt"]').val("${orderForm.optionPantsStandardInfo.opFlapCoinPkt}");
	jQuery('input[name="optionPants2StandardInfo.op2FlapCoinPkt"]').change();
	//上前ピスポケット 
	jQuery('input[name="optionPants2StandardInfo.op2PisPktUf"]').val(["${orderForm.optionPantsStandardInfo.opPisPktUf}"]);
	jQuery('input[name="optionPants2StandardInfo.op2PisPktUf"]').change();
	//下前ピスポケット
	jQuery('input[name="optionPants2StandardInfo.op2PisPktDf"]').val(["${orderForm.optionPantsStandardInfo.opPisPktDf}"]);
	jQuery('input[name="optionPants2StandardInfo.op2PisPktDf"]').change();
	//Vカット
	jQuery('input[name="optionPants2StandardInfo.op2VCut"]').val(["${orderForm.optionPantsStandardInfo.opVCut}"]);
	jQuery('input[name="optionPants2StandardInfo.op2VCut"]').change();
	//裾上げ
	jQuery('#op2_hemUp').val("${orderForm.optionPantsStandardInfo.opHemUp}");
	jQuery('#op2_hemUp').change();
	//ステッチ種類
	jQuery('input[name="optionPants2StandardInfo.op2Stitch"]').val(["${orderForm.optionPantsStandardInfo.opStitch}"]);
	jQuery('input[name="optionPants2StandardInfo.op2Stitch"]').change();
	//ステッチ箇所変更
	jQuery('input[name="optionPants2StandardInfo.op2StitchModify"]').val(["${orderForm.optionPantsStandardInfo.opStitchModify}"]);
	jQuery('input[name="optionPants2StandardInfo.op2StitchModify"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace1"]').val(["${orderForm.optionPantsStandardInfo.opStitchModifyPlace1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace2"]').val(["${orderForm.optionPantsStandardInfo.opStitchModifyPlace2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace3"]').val(["${orderForm.optionPantsStandardInfo.opStitchModifyPlace3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace4"]').val(["${orderForm.optionPantsStandardInfo.opStitchModifyPlace4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace4"]').change();

	//ダブルステッチ
	jQuery('input[name="optionPants2StandardInfo.op2DStitch"]').val(["${orderForm.optionPantsStandardInfo.opDStitch}"]);
	jQuery('input[name="optionPants2StandardInfo.op2DStitch"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace1"]').val(["${orderForm.optionPantsStandardInfo.opDStitchPlace1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace2"]').val(["${orderForm.optionPantsStandardInfo.opDStitchPlace2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace3"]').val(["${orderForm.optionPantsStandardInfo.opDStitchPlace3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace4"]').val(["${orderForm.optionPantsStandardInfo.opDStitchPlace4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace4"]').change();	

	//AMF色指定
	jQuery('input[name="optionPants2StandardInfo.op2AmfColor"]').val(["${orderForm.optionPantsStandardInfo.opAmfColor}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColor"]').change();

	jQuery("#op2_amfColorPlaceAll").val("${orderForm.optionPantsStandardInfo.opAmfColorPlaceAll}");
	jQuery("#op2_amfColorPlaceAll").change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace1"]').val(["${orderForm.optionPantsStandardInfo.opAmfColorPlace1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace2"]').val(["${orderForm.optionPantsStandardInfo.opAmfColorPlace2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace3"]').val(["${orderForm.optionPantsStandardInfo.opAmfColorPlace3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace4"]').val(["${orderForm.optionPantsStandardInfo.opAmfColorPlace4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace4"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColor1"]').val(["${orderForm.optionPantsStandardInfo.opAmfColor1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColor1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColor2"]').val(["${orderForm.optionPantsStandardInfo.opAmfColor2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColor2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColor3"]').val(["${orderForm.optionPantsStandardInfo.opAmfColor3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColor3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColor4"]').val(["${orderForm.optionPantsStandardInfo.opAmfColor4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColor4"]').change();

	//ボタンホール色指定
	jQuery('input[name="optionPants2StandardInfo.op2BhColor"]').val(["${orderForm.optionPantsStandardInfo.opBhColor}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColor"]').change();

	jQuery("#op2_bhColorPlaceAll").val("${orderForm.optionPantsStandardInfo.opBhColorPlaceAll}");
	jQuery("#op2_bhColorPlaceAll").change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace1"]').val(["${orderForm.optionPantsStandardInfo.opBhColorPlace1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace2"]').val(["${orderForm.optionPantsStandardInfo.opBhColorPlace2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace3"]').val(["${orderForm.optionPantsStandardInfo.opBhColorPlace3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace4"]').val(["${orderForm.optionPantsStandardInfo.opBhColorPlace4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace4"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColor1"]').val(["${orderForm.optionPantsStandardInfo.opBhColor1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColor1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColor2"]').val(["${orderForm.optionPantsStandardInfo.opBhColor2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColor2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColor3"]').val(["${orderForm.optionPantsStandardInfo.opBhColor3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColor3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColor4"]').val(["${orderForm.optionPantsStandardInfo.opBhColor4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="optionPants2StandardInfo.op2ByColor"]').val(["${orderForm.optionPantsStandardInfo.opByColor}"]);
	jQuery('input[name="optionPants2StandardInfo.op2ByColor"]').change();
	
	jQuery("#op2_byColorPlaceAll").val("${orderForm.optionPants2StandardInfo.op2ByColorPlaceAll}");
	jQuery("#op2_byColorPlaceAll").change();

	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace1"]').val(["${orderForm.optionPantsStandardInfo.opByColorPlace1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace2"]').val(["${orderForm.optionPantsStandardInfo.opByColorPlace2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace3"]').val(["${orderForm.optionPantsStandardInfo.opByColorPlace3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace4"]').val(["${orderForm.optionPantsStandardInfo.opByColorPlace4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace4"]').change();

	//釦素材
	jQuery('#op2_btnMate').val("${orderForm.optionPantsStandardInfo.opButton}");
	jQuery('#op2_btnMate').change();

	jQuery('#op2_btnMateStkNo').val("${orderForm.optionPantsStandardInfo.opBtnMateStkNo}");
	jQuery('#op2_btnMateStkNo').change();

	//サスペンダー釦
	jQuery('input[name="optionPants2StandardInfo.op2SuspenderBtn"]').val(["${orderForm.optionPantsStandardInfo.opSuspenderBtn}"]);
	jQuery('input[name="optionPants2StandardInfo.op2SuspenderBtn"]').change();

	//シック大（股補強）
	jQuery('input[name="optionPants2StandardInfo.op2Thick"]').val(["${orderForm.optionPantsStandardInfo.opThick}"]);
	jQuery('input[name="optionPants2StandardInfo.op2Thick"]').change();

	//エイト（滑り止め）
	jQuery('input[name="optionPants2StandardInfo.op2Eight"]').val(["${orderForm.optionPantsStandardInfo.opEight}"]);
	jQuery('input[name="optionPants2StandardInfo.op2Eight"]').change();

	//形状記憶
	jQuery('input[name="optionPants2StandardInfo.op2ShapeMemory"]').val(["${orderForm.optionPantsStandardInfo.opShapeMemory}"]);
	jQuery('input[name="optionPants2StandardInfo.op2ShapeMemory"]').change();
});


//PANTS2本目（1本目と同じ）
jQuery('#btn_tp2_samePants').click(function (){

	//PANTSモデル
	jQuery('#tp2_pantsModel').val("${orderForm.optionPantsTuxedoInfo.tpPantsModel}");
	//タック
	jQuery('#tp2_tack').val("${orderForm.optionPantsTuxedoInfo.tpTack}");
	//膝裏
	jQuery('input[name="optionPants2TuxedoInfo.tp2KneeBack"]').val(["${orderForm.optionPantsTuxedoInfo.tpKneeBack}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2KneeBack"]').change();
	//膝裏素材
	jQuery('input[name="optionPants2TuxedoInfo.tp2KneeBackMate"]').val(["${orderForm.optionPantsTuxedoInfo.tpKneeBackMate}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2KneeBackMate"]').change();
	//フロント仕様
	jQuery('input[name="optionPants2TuxedoInfo.tp2FrontSpec"]').val(["${orderForm.optionPantsTuxedoInfo.tpFrontSpec}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2FrontSpec"]').change();
	//パンチェリーナ
	jQuery('input[name="optionPants2TuxedoInfo.tp2Pancherina"]').val(["${orderForm.optionPantsTuxedoInfo.tpPancherina}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2Pancherina"]').change();
	//アジャスター仕様
	jQuery('input[name="optionPants2TuxedoInfo.tp2Pancherina"]').val(["${orderForm.optionPantsTuxedoInfo.tpPancherina}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2Pancherina"]').change();
   //ベルトループ 
   jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoop"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoop}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoop"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace1"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace1}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace1"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace2"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace2}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace2"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace3"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace3}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace3"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace4"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace4}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace4"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace5"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace5}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace5"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace6"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace6}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace6"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace7"]').val(["${orderForm.optionPantsTuxedoInfo.tpBeltLoopPlace7}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace7"]').change();

	//ピンループ
   jQuery('input[name="optionPants2TuxedoInfo.tp2PinLoop"]').val(["${orderForm.optionPantsTuxedoInfo.tpPinLoop}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2PinLoop"]').change();
	//脇ポケット
	jQuery('input[name="optionPants2TuxedoInfo.tp2SidePkt"]').val(["${orderForm.optionPantsTuxedoInfo.tpSidePkt}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2SidePkt"]').change();
	//忍びポケット
	jQuery('input[name="optionPants2TuxedoInfo.tp2SinobiPkt"]').val(["${orderForm.optionPantsTuxedoInfo.tpSinobiPkt}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2SinobiPkt"]').change();
	//コインポケット
	jQuery("#tp_coinPkt").val("${orderForm.optionPantsTuxedoInfo.tpCoinPkt}");
	jQuery("#tp_coinPkt").change();
	//フラップ付コインポケット
	jQuery('input[name="optionPants2TuxedoInfo.tp2FlapCoinPkt"]').val(["${orderForm.optionPantsTuxedoInfo.tpFlapCoinPkt}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2FlapCoinPkt"]').change();
	//上前ピスポケット
	jQuery('input[name="optionPants2TuxedoInfo.tp2PisPktUf"]').val(["${orderForm.optionPantsTuxedoInfo.tpPisPktUf}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2PisPktUf"]').change();
	//下前ピスポケット
	jQuery('input[name="optionPants2TuxedoInfo.tp2PisPktDf"]').val(["${orderForm.optionPantsTuxedoInfo.tpPisPktDf}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2PisPktDf"]').change();
	//Vカット
	jQuery('input[name="optionPants2TuxedoInfo.tp2VCut"]').val(["${orderForm.optionPantsTuxedoInfo.tpVCut}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2VCut"]').change();
	//裾上げ
	jQuery("#tp2_hemUp").val("${orderForm.optionPantsTuxedoInfo.tpHemUp}");
	jQuery("#tp2_hemUp").change();
	//ステッチ種類
	jQuery('input[name="optionPants2TuxedoInfo.tp2Stitch"]').val(["${orderForm.optionPantsTuxedoInfo.tpStitch}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2Stitch"]').change();
	//ボタンホール色指定
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColor}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace1"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColorPlace1}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace1"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace2"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColorPlace2}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace2"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace3"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColorPlace3}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace3"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace4"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColorPlace4}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace4"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace5"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColorPlace5}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace5"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor1"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColor1}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor1"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor2"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColor2}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor2"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor3"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColor3}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor3"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor4"]').val(["${orderForm.optionPantsTuxedoInfo.tpBhColor4}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColor}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor"]').change();
	jQuery("#tp2_byColorPlaceAll").val("${orderForm.optionPantsTuxedoInfo.tpByColorPlaceAll}");
	jQuery("#tp2_byColorPlaceAll").change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace1"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColorPlace1}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace1"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace2"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColorPlace2}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace2"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace3"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColorPlace3}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace3"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace4"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColorPlace4}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace4"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor1"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColor1}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor1"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor2"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColor2}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor2"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor3"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColor3}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor3"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor4"]').val(["${orderForm.optionPantsTuxedoInfo.tpByColor4}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor4"]').change();
	
	//釦素材
	jQuery("#tp2_btnMate").val("${orderForm.optionPantsTuxedoInfo.tpButton}");
	jQuery("#tp2_btnMate").change();

	jQuery("#tp2_btnMateStkNo").val("${orderForm.optionPantsStandardInfo.opBtnMateStkNo}");
	jQuery("#tp2_btnMateStkNo").change();
	//サスペンダー釦
	jQuery('input[name="optionPants2TuxedoInfo.tp2SuspenderBtn"]').val(["${orderForm.optionPantsTuxedoInfo.tpSuspenderBtn}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2SuspenderBtn"]').change();
	//シック大（股補強）
	jQuery('input[name="optionPants2TuxedoInfo.tp2Thick"]').val(["${orderForm.optionPantsTuxedoInfo.tpThick}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2Thick"]').change();
	//エイト（滑り止め）
	jQuery('input[name="optionPants2TuxedoInfo.tp2Eight"]').val(["${orderForm.optionPantsTuxedoInfo.tpEight}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2Eight"]').change();
	//形状記憶
	jQuery('input[name="optionPants2TuxedoInfo.tp2ShapeMemory"]').val(["${orderForm.optionPantsTuxedoInfo.tpShapeMemory}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ShapeMemory"]').change();
	//側章
	jQuery('input[name="optionPants2TuxedoInfo.tp2SideStripe"]').val(["${orderForm.optionPantsTuxedoInfo.tpSideStripe}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2SideStripe"]').change();
	//側章幅
	jQuery('input[name="optionPants2TuxedoInfo.tp2SideStripeWidth"]').val(["${orderForm.optionPantsTuxedoInfo.tpSideStripeWidth}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2SideStripeWidth"]').change();

});

//PANTS2本目（1本目と同じ）
jQuery('#btn_wp2_samePants').click(function (){
	//PANTSモデル 
	jQuery('#wp2_pantsModel').val("${orderForm.optionPantsWashableInfo.wpPantsModel}");
	//タック
	jQuery('#wp2_tack_id').val("${orderForm.optionPantsWashableInfo.wpTack}");
	//膝裏
	jQuery('input[name="optionPants2WashableInfo.wp2KneeBack"]').val(["${orderForm.optionPantsWashableInfo.wpKneeBack}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2KneeBack"]').change();
	//膝裏素材
	jQuery('input[name="optionPants2WashableInfo.wp2KneeBackMate"]').val(["${orderForm.optionPantsWashableInfo.wpKneeBackMate}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2KneeBackMate"]').change();
	//フロント仕様
	jQuery('input[name="optionPants2WashableInfo.wp2FrontSpec"]').val(["${orderForm.optionPantsWashableInfo.wpFrontSpec}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2FrontSpec"]').change();
	//パンチェリーナ
	jQuery('input[name="optionPants2WashableInfo.wp2Pancherina"]').val(["${orderForm.optionPantsWashableInfo.wpPancherina}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2Pancherina"]').change();
	//アジャスター仕様
	jQuery('input[name="optionPants2WashableInfo.wp2Adjuster"]').val(["${orderForm.optionPantsWashableInfo.wpAdjuster}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2Adjuster"]').change();
	//ベルトループ
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoop"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoop}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoop"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace1"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace2"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace3"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace4"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace5"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace5}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace5"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace6"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace6}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace6"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace7"]').val(["${orderForm.optionPantsWashableInfo.wpBeltLoopPlace7}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace7"]').change();

	//ピンループ
	jQuery('input[name="optionPants2WashableInfo.wp2PinLoop"]').val(["${orderForm.optionPantsWashableInfo.wpPinLoop}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2PinLoop"]').change();
	//脇ポケット
	jQuery('input[name="optionPants2WashableInfo.wp2SidePkt"]').val(["${orderForm.optionPantsWashableInfo.wpSidePkt}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2SidePkt"]').change();
	//忍びポケット
	jQuery('input[name="optionPants2WashableInfo.wp2SinobiPkt"]').val(["${orderForm.optionPantsWashableInfo.wpSinobiPkt}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2SinobiPkt"]').change();
	//コインポケット 
	jQuery("#wp2_coinPkt_id").val("${orderForm.optionPantsWashableInfo.wpCoinPkt}");
	jQuery("#wp2_coinPkt_id").change();
	//フラップ付コインポケット
	jQuery('input[name="optionPants2WashableInfo.wp2FlapCoinPkt"]').val(["${orderForm.optionPantsWashableInfo.wpFlapCoinPkt}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2FlapCoinPkt"]').change();
	//上前ピスポケット
	jQuery('input[name="optionPants2WashableInfo.wp2PisPktUf"]').val(["${orderForm.optionPantsWashableInfo.wpPisPktUf}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2PisPktUf"]').change();
	//下前ピスポケット
	jQuery('input[name="optionPants2WashableInfo.wp2PisPktDf"]').val(["${orderForm.optionPantsWashableInfo.wpPisPktDf}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2PisPktDf"]').change();
	//Vカット
	jQuery('input[name="optionPants2WashableInfo.wp2VCut"]').val(["${orderForm.optionPantsWashableInfo.wpVCut}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2VCut"]').change();
	//裾上げ
	jQuery("#wp2_hemUp_id").val("${orderForm.optionPantsWashableInfo.wpHemUp}");
	jQuery("#wp2_hemUp_id").change();
	//ステッチ種類
	jQuery('input[name="optionPants2WashableInfo.wp2Stitch"]').val(["${orderForm.optionPantsWashableInfo.wpStitch}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2Stitch"]').change();
	//ステッチ箇所変更
	jQuery('input[name="optionPants2WashableInfo.wp2StitchModify"]').val(["${orderForm.optionPantsWashableInfo.wpStitchModify}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2StitchModify"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace1"]').val(["${orderForm.optionPantsWashableInfo.wpStitchModifyPlace1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace2"]').val(["${orderForm.optionPantsWashableInfo.wpStitchModifyPlace2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace3"]').val(["${orderForm.optionPantsWashableInfo.wpStitchModifyPlace3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpStitchModifyPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace4"]').change();
	
	//ダブルステッチ
	jQuery('input[name="optionPants2WashableInfo.wp2DStitch"]').val(["${orderForm.optionPantsWashableInfo.wpDStitch}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2DStitch"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace1"]').val(["${orderForm.optionPantsWashableInfo.wpDStitchPlace1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace2"]').val(["${orderForm.optionPantsWashableInfo.wpDStitchPlace2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace3"]').val(["${orderForm.optionPantsWashableInfo.wpDStitchPlace3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpDStitchPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace4"]').change();

	//AMF色指定
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColor}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace1"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColorPlace1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace2"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColorPlace2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace3"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColorPlace3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColorPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace4"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor1"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColor1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor2"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColor2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor3"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColor3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor4"]').val(["${orderForm.optionPantsWashableInfo.wpAmfColor4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor4"]').change();


	//ボタンホール色指定
	jQuery('input[name="optionPants2WashableInfo.wp2BhColor"]').val(["${orderForm.optionPantsWashableInfo.wpBhColor}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColor"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace1"]').val(["${orderForm.optionPantsWashableInfo.wpBhColorPlace1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace2"]').val(["${orderForm.optionPantsWashableInfo.wpBhColorPlace2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace3"]').val(["${orderForm.optionPantsWashableInfo.wpBhColorPlace3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpBhColorPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace4"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpBhColorPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace4"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColor1"]').val(["${orderForm.optionPantsWashableInfo.wpBhColor1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColor1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColor2"]').val(["${orderForm.optionPantsWashableInfo.wpBhColor2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColor2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColor3"]').val(["${orderForm.optionPantsWashableInfo.wpBhColor3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColor3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColor4"]').val(["${orderForm.optionPantsWashableInfo.wpBhColor4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="optionPants2WashableInfo.wp2ByColor"]').val(["${orderForm.optionPantsWashableInfo.wpByColor}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColor"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace1"]').val(["${orderForm.optionPantsWashableInfo.wpByColorPlace1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace2"]').val(["${orderForm.optionPantsWashableInfo.wpByColorPlace2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace3"]').val(["${orderForm.optionPantsWashableInfo.wpByColorPlace3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace4"]').val(["${orderForm.optionPantsWashableInfo.wpByColorPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace4"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').val(["${orderForm.optionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').val(["${orderForm.optionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').val(["${orderForm.optionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').val(["${orderForm.optionPantsWashableInfo.wpByColor1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').change();
	
	//釦素材
	jQuery("#wp2_button_id").val("${orderForm.optionPantsWashableInfo.wpButton}");
	jQuery("#wp2_button_id").change();

	jQuery("#wp2_btnMateStkNo").val("${orderForm.optionPantsWashableInfo.wpBtnMateStkNo}");
	jQuery("#wp2_btnMateStkNo").change();
	//サスペンダー釦
	jQuery('input[name="optionPants2WashableInfo.wp2SuspenderBtn"]').val(["${orderForm.optionPantsWashableInfo.wpSuspenderBtn}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2SuspenderBtn"]').change();
	//シック大（股補強）
	jQuery('input[name="optionPants2WashableInfo.wp2Thick"]').val(["${orderForm.optionPantsWashableInfo.wpThick}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2Thick"]').change();
	//エイト（滑り止め）
	jQuery('input[name="optionPants2WashableInfo.wp2Thick"]').val(["${orderForm.optionPantsWashableInfo.wpThick}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2Thick"]').change();
	//形状記憶
	jQuery('input[name="optionPants2WashableInfo.wp2Eight"]').val(["${orderForm.optionPantsWashableInfo.wpEight}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2Eight"]').change();
});
function  op2Session(){

	//コインポケット
	jQuery("#op2_coinPkt").val("${orderForm.optionPants2StandardInfo.op2CoinPkt}");
	jQuery("#op2_coinPkt").change();

	//裾上げ
	jQuery('#op2_hemUp').val("${orderForm.optionPants2StandardInfo.op2HemUp}");
	jQuery('#op2_hemUp').change();
	
	//ベルトループ
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoop"]').val(["${orderForm.optionPants2StandardInfo.op2BeltLoop}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoop"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace1"]').val(["${orderForm.optionPants2StandardInfo.op2BeltLoopPlace1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace2"]').val(["${orderForm.optionPants2StandardInfo.op2BeltLoopPlace2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace3"]').val(["${orderForm.optionPants2StandardInfo.op2BeltLoopPlace3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace4"]').val(["${orderForm.optionPants2StandardInfo.op2BeltLoopPlace4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace4"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace5"]').val(["${orderForm.optionPants2StandardInfo.op2BeltLoopPlace5}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace5"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace6"]').val(["${orderForm.optionPants2StandardInfo.op2BeltLoopPlace6}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace6"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace7"]').val(["${orderForm.optionPants2StandardInfo.op2BeltLoopPlace7}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BeltLoopPlace7"]').change();

	//ステッチ箇所変更
	jQuery('input[name="optionPants2StandardInfo.op2StitchModify"]').val(["${orderForm.optionPants2StandardInfo.op2StitchModify}"]);
	jQuery('input[name="optionPants2StandardInfo.op2StitchModify"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace1"]').val(["${orderForm.optionPants2StandardInfo.op2StitchModifyPlace1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace2"]').val(["${orderForm.optionPants2StandardInfo.op2StitchModifyPlace2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace3"]').val(["${orderForm.optionPants2StandardInfo.op2StitchModifyPlace3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace4"]').val(["${orderForm.optionPants2StandardInfo.op2StitchModifyPlace4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2StitchModifyPlace4"]').change();

	//ダブルステッチ
	jQuery('input[name="optionPants2StandardInfo.op2DStitch"]').val(["${orderForm.optionPants2StandardInfo.op2DStitch}"]);
	jQuery('input[name="optionPants2StandardInfo.op2DStitch"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace1"]').val(["${orderForm.optionPants2StandardInfo.op2DStitchPlace1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace2"]').val(["${orderForm.optionPants2StandardInfo.op2DStitchPlace2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace3"]').val(["${orderForm.optionPants2StandardInfo.op2DStitchPlace3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace4"]').val(["${orderForm.optionPants2StandardInfo.op2DStitchPlace4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2DStitchPlace4"]').change();	

	//AMF色指定
	jQuery('input[name="optionPants2StandardInfo.op2AmfColor"]').val(["${orderForm.optionPants2StandardInfo.op2AmfColor}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColor"]').change();

	jQuery("#op2_amfColorPlaceAll").val("${orderForm.optionPants2StandardInfo.op2AmfColorPlaceAll}");
	jQuery("#op2_amfColorPlaceAll").change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace1"]').val(["${orderForm.optionPants2StandardInfo.op2AmfColorPlace1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace2"]').val(["${orderForm.optionPants2StandardInfo.op2AmfColorPlace2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace3"]').val(["${orderForm.optionPants2StandardInfo.op2AmfColorPlace3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace4"]').val(["${orderForm.optionPants2StandardInfo.op2AmfColorPlace4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColorPlace4"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColor1"]').val(["${orderForm.optionPants2StandardInfo.op2AmfColor1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColor1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColor2"]').val(["${orderForm.optionPants2StandardInfo.op2AmfColor2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColor2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColor3"]').val(["${orderForm.optionPants2StandardInfo.op2AmfColor3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColor3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2AmfColor4"]').val(["${orderForm.optionPants2StandardInfo.op2AmfColor4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2AmfColor4"]').change();

	//ボタンホール色指定
	jQuery('input[name="optionPants2StandardInfo.op2BhColor"]').val(["${orderForm.optionPants2StandardInfo.op2BhColor}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColor"]').change();

	jQuery("#op2_bhColorPlaceAll").val("${orderForm.optionPants2StandardInfo.op2BhColorPlaceAll}");
	jQuery("#op2_bhColorPlaceAll").change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace1"]').val(["${orderForm.optionPants2StandardInfo.op2BhColorPlace1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace2"]').val(["${orderForm.optionPants2StandardInfo.op2BhColorPlace2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace3"]').val(["${orderForm.optionPants2StandardInfo.op2BhColorPlace3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace4"]').val(["${orderForm.optionPants2StandardInfo.op2BhColorPlace4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColorPlace4"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColor1"]').val(["${orderForm.optionPants2StandardInfo.op2BhColor1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColor1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColor2"]').val(["${orderForm.optionPants2StandardInfo.op2BhColor2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColor2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColor3"]').val(["${orderForm.optionPants2StandardInfo.op2BhColor3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColor3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2BhColor4"]').val(["${orderForm.optionPants2StandardInfo.op2BhColor4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2BhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="optionPants2StandardInfo.op2ByColor"]').val(["${orderForm.optionPants2StandardInfo.op2ByColor}"]);
	jQuery('input[name="optionPants2StandardInfo.op2ByColor"]').change();
	
	jQuery("#op2_byColorPlaceAll").val("${orderForm.optionPants2StandardInfo.op2ByColorPlaceAll}");
	jQuery("#op2_byColorPlaceAll").change();

	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace1"]').val(["${orderForm.optionPants2StandardInfo.op2ByColorPlace1}"]);
	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace1"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace2"]').val(["${orderForm.optionPants2StandardInfo.op2ByColorPlace2}"]);
	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace2"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace3"]').val(["${orderForm.optionPants2StandardInfo.op2ByColorPlace3}"]);
	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace3"]').change();

	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace4"]').val(["${orderForm.optionPants2StandardInfo.op2ByColorPlace4}"]);
	jQuery('input[name="optionPants2StandardInfo.op2ByColorPlace4"]').change();

	//釦素材
	jQuery('#op2_btnMate').val("${orderForm.optionPants2StandardInfo.op2Button}");
	jQuery('#op2_btnMate').change();

	jQuery('#op2_btnMateStkNo').val("${orderForm.optionPants2StandardInfo.op2BtnMateStkNo}");
	jQuery('#op2_btnMateStkNo').change();
}

function  tp2Session(){

	//コインポケット
	jQuery("#tp2_coinPkt").val("${orderForm.optionPants2TuxedoInfo.tp2CoinPkt}");
	jQuery("#tp2_coinPkt").change();

	//裾上げ
	jQuery("#tp2_hemUp").val("${orderForm.optionPants2TuxedoInfo.tp2HemUp}");
	jQuery("#tp2_hemUp").change();

   //ベルトループ 
   jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoop"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BeltLoop}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoop"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace1"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BeltLoopPlace1}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace1"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace2"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BeltLoopPlace2}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace2"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace3"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BeltLoopPlace3}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace3"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace4"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BeltLoopPlace4}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace4"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace5"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BeltLoopPlace5}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace5"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace6"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BeltLoopPlace6}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace6"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace7"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BeltLoopPlace7}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BeltLoopPlace7"]').change();

	//ステッチ種類
	jQuery('input[name="optionPants2TuxedoInfo.tp2Stitch"]').val(["${orderForm.optionPants2TuxedoInfo.tp2Stitch}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2Stitch"]').change();
	//ボタンホール色指定
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BhColor}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace1"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BhColorPlace1}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace1"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace2"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BhColorPlace2}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace2"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace3"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BhColorPlace3}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace3"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace4"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BhColorPlace4}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace4"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace5"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BhColorPlace5}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColorPlace5"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor1"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BhColor1}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor1"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor2"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BhColor2}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor2"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor3"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BhColor3}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor3"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor4"]').val(["${orderForm.optionPants2TuxedoInfo.tp2BhColor4}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2BhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor"]').val(["${orderForm.optionPants2TuxedoInfo.tp2ByColor}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor"]').change();
	jQuery("#tp2_byColorPlaceAll").val("${orderForm.optionPants2TuxedoInfo.tp2ByColorPlaceAll}");
	jQuery("#tp2_byColorPlaceAll").change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace1"]').val(["${orderForm.optionPants2TuxedoInfo.tp2ByColorPlace1}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace1"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace2"]').val(["${orderForm.optionPants2TuxedoInfo.tp2ByColorPlace2}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace2"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace3"]').val(["${orderForm.optionPants2TuxedoInfo.tp2ByColorPlace3}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace3"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace4"]').val(["${orderForm.optionPants2TuxedoInfo.tp2ByColorPlace4}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColorPlace4"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor1"]').val(["${orderForm.optionPants2TuxedoInfo.tp2ByColor1}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor1"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor2"]').val(["${orderForm.optionPants2TuxedoInfo.tp2ByColor2}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor2"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor3"]').val(["${orderForm.optionPants2TuxedoInfo.tp2ByColor3}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor3"]').change();

	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor4"]').val(["${orderForm.optionPants2TuxedoInfo.tp2ByColor4}"]);
	jQuery('input[name="optionPants2TuxedoInfo.tp2ByColor4"]').change();
	
}
function  wp2Session(){

	//ベルトループ
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoop"]').val(["${orderForm.optionPants2WashableInfo.wp2BeltLoop}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoop"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace1"]').val(["${orderForm.optionPants2WashableInfo.wp2BeltLoopPlace1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace2"]').val(["${orderForm.optionPants2WashableInfo.wp2BeltLoopPlace2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace3"]').val(["${orderForm.optionPants2WashableInfo.wp2BeltLoopPlace3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace4"]').val(["${orderForm.optionPants2WashableInfo.wp2BeltLoopPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace4"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace5"]').val(["${orderForm.optionPants2WashableInfo.wp2BeltLoopPlace5}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace5"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace6"]').val(["${orderForm.optionPants2WashableInfo.wp2BeltLoopPlace6}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace6"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace7"]').val(["${orderForm.optionPants2WashableInfo.wp2BeltLoopPlace7}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BeltLoopPlace7"]').change();

	//ステッチ種類
	jQuery('input[name="optionPants2WashableInfo.wp2Stitch"]').val(["${orderForm.optionPants2WashableInfo.wp2Stitch}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2Stitch"]').change();
	//ステッチ箇所変更
	jQuery('input[name="optionPants2WashableInfo.wp2StitchModify"]').val(["${orderForm.optionPants2WashableInfo.wp2StitchModify}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2StitchModify"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace1"]').val(["${orderForm.optionPants2WashableInfo.wp2StitchModifyPlace1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace2"]').val(["${orderForm.optionPants2WashableInfo.wp2StitchModifyPlace2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace3"]').val(["${orderForm.optionPants2WashableInfo.wp2StitchModifyPlace3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace4"]').val(["${orderForm.optionPants2WashableInfo.wp2StitchModifyPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2StitchModifyPlace4"]').change();
	
	//ダブルステッチ
	jQuery('input[name="optionPants2WashableInfo.wp2DStitch"]').val(["${orderForm.optionPants2WashableInfo.wp2DStitch}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2DStitch"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace1"]').val(["${orderForm.optionPants2WashableInfo.wp2DStitchPlace1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace2"]').val(["${orderForm.optionPants2WashableInfo.wp2DStitchPlace2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace3"]').val(["${orderForm.optionPants2WashableInfo.wp2DStitchPlace3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace4"]').val(["${orderForm.optionPants2WashableInfo.wp2DStitchPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2DStitchPlace4"]').change();

	//AMF色指定
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor"]').val(["${orderForm.optionPants2WashableInfo.wp2AmfColor}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace1"]').val(["${orderForm.optionPants2WashableInfo.wp2AmfColorPlace1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace2"]').val(["${orderForm.optionPants2WashableInfo.wp2AmfColorPlace2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace3"]').val(["${orderForm.optionPants2WashableInfo.wp2AmfColorPlace3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace4"]').val(["${orderForm.optionPants2WashableInfo.wp2AmfColorPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColorPlace4"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor1"]').val(["${orderForm.optionPants2WashableInfo.wp2AmfColor1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor2"]').val(["${orderForm.optionPants2WashableInfo.wp2AmfColor2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor3"]').val(["${orderForm.optionPants2WashableInfo.wp2AmfColor3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor4"]').val(["${orderForm.optionPants2WashableInfo.wp2AmfColor4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2AmfColor4"]').change();

	//ボタンホール色指定
	jQuery('input[name="optionPants2WashableInfo.wp2BhColor"]').val(["${orderForm.optionPants2WashableInfo.wp2BhColor}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColor"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace1"]').val(["${orderForm.optionPants2WashableInfo.wp2BhColorPlace1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace2"]').val(["${orderForm.optionPants2WashableInfo.wp2BhColorPlace2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace3"]').val(["${orderForm.optionPants2WashableInfo.wp2BhColorPlace3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace4"]').val(["${orderForm.optionPants2WashableInfo.wp2BhColorPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace4"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace4"]').val(["${orderForm.optionPants2WashableInfo.wp2BhColorPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColorPlace4"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColor1"]').val(["${orderForm.optionPants2WashableInfo.wp2BhColor1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColor1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColor2"]').val(["${orderForm.optionPants2WashableInfo.wp2BhColor2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColor2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColor3"]').val(["${orderForm.optionPants2WashableInfo.wp2BhColor3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColor3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2BhColor4"]').val(["${orderForm.optionPants2WashableInfo.wp2BhColor4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2BhColor4"]').change();

	//ボタン付け糸指定
	jQuery('input[name="optionPants2WashableInfo.wp2ByColor"]').val(["${orderForm.optionPants2WashableInfo.wp2ByColor}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColor"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace1"]').val(["${orderForm.optionPants2WashableInfo.wp2ByColorPlace1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace2"]').val(["${orderForm.optionPants2WashableInfo.wp2ByColorPlace2}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace2"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace3"]').val(["${orderForm.optionPants2WashableInfo.wp2ByColorPlace3}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace3"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace4"]').val(["${orderForm.optionPants2WashableInfo.wp2ByColorPlace4}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColorPlace4"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').val(["${orderForm.optionPants2WashableInfo.wp2ByColor1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').val(["${orderForm.optionPants2WashableInfo.wp2ByColor1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').val(["${orderForm.optionPants2WashableInfo.wp2ByColor1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').change();

	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').val(["${orderForm.optionPants2WashableInfo.wp2ByColor1}"]);
	jQuery('input[name="optionPants2WashableInfo.wp2ByColor1"]').change();
}
 
</script>