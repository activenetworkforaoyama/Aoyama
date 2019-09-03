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
                                    <div class="form-check-inline form-check">
                                        <form:checkboxes id="op2_beltLoopPlace_id" items="${orderForm.optionPants2StandardInfo.op2BeltLoopPlaceMap }" path="optionPants2StandardInfo.op2BeltLoopPlace" class="form-check-input"/>
                                    </div>
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
                                <div class="form-check-inline form-check">
                                    <form:checkboxes id="op2_stitchModifyPlace_id" items="${orderForm.optionPants2StandardInfo.op2StitchModifyPlaceMap }" path="optionPants2StandardInfo.op2StitchModifyPlace" class="form-check-input"/>
                                </div>
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
                                <div class="form-check-inline form-check">
                                    <form:checkboxes id="op2_dStitchPlace_id" items="${orderForm.optionPants2StandardInfo.op2DStitchPlaceMap }" path="optionPants2StandardInfo.op2DStitchPlace" class="form-check-input"/>
                                </div>
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
                                        <input type="checkbox" id="op2_amfColorPlace_${row.count}" name="optionPants2StandardInfo.op2AmfColorPlace" value="${op2AmfColorPlaceMap.key }" class="form-check-input">${op2AmfColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="optionPants2StandardInfo.op2AmfColorPlace_${row.count}_div" style="display:none">
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
                                        <input type="checkbox" id="op2_bhColorPlace_${row.count}" name="optionPants2StandardInfo.op2BhColorPlace" value="${op2BhColorPlaceMap.key }" class="form-check-input">${op2BhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="optionPants2StandardInfo.op2BhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="op2BhColorsMap" items="${orderForm.optionPants2StandardInfo.op2BhColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op2_bhColor" class="form-check-label ">
                                			    <input type="radio" id="op2_bhColor_${op2BhColorsMap.key}" name="optionPants2StandardInfo.op2BhColor${row.count}" value="${op2BhColorsMap.key}" class="form-check-input">${opBh2ColorsMap.value}
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
                                        <input type="checkbox" id="op2_byColorPlace_${row.count}" name="optionPants2StandardInfo.op2ByColorPlace" value="${op2ByColorPlaceMap.key }" class="form-check-input">${op2ByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="optionPants2StandardInfo.op2ByColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="op2ByColorsMap" items="${orderForm.optionPants2StandardInfo.op2ByColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="op2_byColorPlace" class="form-check-label ">
                                			    <input type="radio" id="op2_byColor_${op2ByColorsMap.key}" name="optionPants2StandardInfo.op2ByColor${row.count}" value="${opByColorsMap.key}" class="form-check-input">${op2ByColorsMap.value}
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
                                <select name="op2_btnMateStkNo" id="op2_btnMateStkNo" class="form-control-sm form-control">
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
                                    <div class="form-check-inline form-check">
                                    	<form:checkboxes id="tp2_beltLoopPlace_id" items="${orderForm.optionPants2TuxedoInfo.tp2BeltLoopPlaceMap }" path="optionPants2TuxedoInfo.tp2BeltLoopPlace" class="form-check-input"/>
                                    </div>
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
                                        <input type="checkbox" id="tp2_bhColorPlace_${row.count}" name="optionPants2TuxedoInfo.tp2BhColorPlace" value="${tp2BhColorPlaceMap.key }" class="form-check-input">${tp2BhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="optionPants2TuxedoInfo.tp2BhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="tp2BhColorsMap" items="${orderForm.optionPants2TuxedoInfo.tp2BhColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="tp2_bhColor" class="form-check-label ">
                                			    <input type="radio" id="tp2_bhColor_${tp2BhColorsMap.key}" name="optionPants2TuxedoInfo.tp2BhColor${row.count}" value="${tp2BhColorsMap.key}" class="form-check-input">${tp2BhColorsMap.value}
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
                                        <input type="checkbox" id="tp2_byColorPlace_${row.count}" name="optionPants2TuxedoInfo.tp2ByColorPlace" value="${tp2ByColorPlaceMap.key }" class="form-check-input">${tp2ByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="optionPants2TuxedoInfo.tp2ByColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="tp2ByColorsMap" items="${orderForm.optionPants2TuxedoInfo.tp2ByColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="tp2_byColorPlace" class="form-check-label ">
                                			    <input type="radio" id="tp2_byColor_${tp2ByColorsMap.key}" name="optionPants2TuxedoInfo.tp2ByColor${row.count}" value="${tp2ByColorsMap.key}" class="form-check-input">${tp2ByColorsMap.value}
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
                                <select name="tp2_btnMateStkNo" id="tp2_btnMateStkNo" class="form-control-sm form-control">
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
                                    <div class="form-check-inline form-check">
										<form:checkboxes id="wp2_beltLoopPlace_id" path="optionPants2WashableInfo.wp2BeltLoopPlace" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2BeltLoopPlaceMap}"/>
									</div>
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
                                <div class="form-check-inline form-check">
									<form:checkboxes id="wp2_stitchModifyPlace_id" path="optionPants2WashableInfo.wp2StitchModifyPlace" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2StitchModifyPlaceMap}"/>
								</div>
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
                                <div class="form-check-inline form-check">
									<form:checkboxes id="wp2_dStitchPlace_id" path="optionPants2WashableInfo.wp2DStitchPlace" class="form-check-input" items="${orderForm.optionPants2WashableInfo.wp2DStitchPlaceMap}"/>
								</div>
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
                                    <form:select id="wp2_amfColorPlaceAll_id" path="optionPants2WashableInfo.wp2AmfColorPlaceAll" class="form-control-sm form-control">
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
                                        <input type="checkbox" id="wp2_amfColorPlace_${row.count}" name="optionPants2WashableInfo.wp2AmfColorPlace" value="${wp2AmfColorPlaceMap.key }" class="form-check-input">${wp2AmfColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="wp2_amfColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wp2AmfColorsMap" items="${orderForm.optionPants2WashableInfo.wp2AmfColorsMap}">
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
                                    <form:select id="wp2_bhColorPlaceAll_id" path="optionPants2WashableInfo.wp2BhColorPlaceAll" class="form-control-sm form-control">
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
                                        <input type="checkbox" id="wp2_bhColorPlace_${row.count}" name="optionPants2WashableInfo.wp2BhColorPlace" value="${wp2BhColorPlaceMap.key }" class="form-check-input">${wp2BhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="wp2_bhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wp2BhColorsMap" items="${orderForm.optionPants2WashableInfo.wp2BhColorsMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wp2_bhColor" class="form-check-label ">
                                			    <input type="radio" id="wp2_bhColor_${wp2BhColorsMap.key}" name="optionPants2WashableInfo.wp2BhColor${row.count}" value="${wp2BhColorsMap.key}" class="form-check-input">${wp2BhColorsMap.value}
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
                                        <input type="checkbox" id="wp2_byColorPlace_${row.count}" name="optionPants2WashableInfo.wp2ByColorPlace" value="${wp2ByColorPlaceMap.key }" class="form-check-input">${wp2ByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="optionPants2WashableInfo.wp2ByColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wp2ByColorsMap" items="${orderForm.optionPants2WashableInfo.wp2ByColorsMap}">
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
                            	<form:select id="wp2_button_id" path="optionPants2WashableInfo.wp2Button" class="form-control-sm form-control">
									<form:options items="${orderForm.optionPants2WashableInfo.wp2ButtonMap}"/>
								</form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="wp2_btnMateStkNo" id="wp2_btnMateStkNo" class="form-control-sm form-control">
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
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/jquery.i18n.properties.js"></script> 
<script src="${pageContext.request.contextPath}/resources/app/js/chosen.jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/js/bootstrap-datepicker.js"></script>


<!-- 自作js -->
<script src="${pageContext.request.contextPath}/resources/app/self/js/rule.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/config.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants2.standard.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants2.tuxedo.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.pants2.washable.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";
jQuery(function() {
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
	initOptionPants2Standard();

	initOptionPants2Tuxedo();

	initOptionPants2Washable();
	//--------------------------------------------
	// 補正タブ
	//--------------------------------------------
	//initAlter();
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
	var ptStandardMateList = ["op2_btnMate"];
	// タキシードの場合　pants ptTuxedoMateListのid List
	var ptTuxedoMateList = ["tp2_btnMate"];
	// ウォッシャブルの場合　pants ptWashableMateListのid List
	var ptWashableMateList = ["wp2_btnMate"];
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
		for(var i in ptStandardMateList){
			optionCode = selectStandardIdList[ptStandardMateList[i]];
			mateChecked = jQuery("#"+ptStandardMateList[i]+" option:checked").val();
			StkNo = "#"+ptStandardMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		}
		jQuery("#op2_btnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			optionCode = selectStandardIdList[idValue];
			mateChecked = jQuery("#"+idValue+" option:checked").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		})	
	}

	function initPtTuxedo(itemCode,subItemCode,category){
		for(var i in ptTuxedoMateList){
			optionCode = selectTuxedoIdList[ptTuxedoMateList[i]];
			mateChecked = jQuery("#"+ptTuxedoMateList[i]+" option:checked").val();
			StkNo = "#"+ptTuxedoMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		}
		jQuery("#tp2_btnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			optionCode = selectTuxedoIdList[idValue];
			mateChecked = jQuery("#"+idValue+" option:checked").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		})	
	}

	function initPtWashable(itemCode,subItemCode,category){
		for(var i in ptWashableMateList){
			optionCode = selectWashableIdList[ptWashableMateList[i]];
			mateChecked = jQuery("#"+ptWashableMateList[i]+" option:checked").val();
			StkNo = "#"+ptWashableMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,category,orderPattern);
		}
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
</script>