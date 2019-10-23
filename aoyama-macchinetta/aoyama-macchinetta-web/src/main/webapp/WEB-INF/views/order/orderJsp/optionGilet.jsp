<form:form id="idInfoForm" action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm" method="post" modelAttribute="orderCoForm" class="form-horizontal">
<div id="op_gilet_div">
    <div class="card-header">
        <strong class="card-title">GILET</strong>
    </div>
    <div class="card-body">
        <div class="row">
            <div class="col col-lg-12">
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">GILETモデル</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_giletModel"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                        <form:select id="giletModel" path="coOptionGiletStandardInfo.ogGiletModel" class="form-control-sm form-control">
                        	<form:options items="${orderCoForm.coOptionGiletStandardInfo.ogGiletModelMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-6" align="right" id="giletModel_Msg"></div>
                    <div class="col-12 col-md-9 offset-md-3" id="giletModelMsg" style="margin-top:8px"></div>
                    <div class="col-12 col-md-9 offset-md-3" id="giletModelCheck" style="display:none"></div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_breastPkt_id" path="coOptionGiletStandardInfo.ogBreastPkt" class="form-check-input" items="${orderCoForm.coOptionGiletStandardInfo.ogBreastPktMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="og_breastPkt_Msg">
                       	<%-- <c:if test="${orderCoForm.coOptionGiletStandardInfo.glBtnthreadColorRtPrice == '0'}">
                     		無料
                     	</c:if>
                     	<c:if test="${orderCoForm.coOptionGiletStandardInfo.glBtnthreadColorRtPrice != '0'}">
                     		${orderCoForm.coOptionGiletStandardInfo.glBtnthreadColorRtPrice}
                     	</c:if> --%>
<%-- 						${orderCoForm.coOptionGiletStandardInfo.glBreastPktRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
                    <div class="col-12 col-md-6">
                      	<div class="form-check-inline form-check">
                          	<form:radiobuttons id="og_waistPkt_id" path="coOptionGiletStandardInfo.ogWaistPkt" class="form-check-input" items="${orderCoForm.coOptionGiletStandardInfo.ogWaistPktMap}"/>
                  		</div>
	                </div>
                    <div class="col-12 col-md-3" align="right" id="og_waistPkt_Msg">
<%--                     	${orderCoForm.coOptionGiletStandardInfo.glWaistPktRtPrice } --%>
                    </div>
                </div>
                <div id="og_waistPkt_yes_area">
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット形状</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_waistPktSpec_id" path="coOptionGiletStandardInfo.ogWaistPktSpec" class="form-check-input" items="${orderCoForm.coOptionGiletStandardInfo.ogWaistPktSpecMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="og_waistPktSpec_Msg">
<%--                     	${orderCoForm.coOptionGiletStandardInfo.glWaistPktShapeRtPrice } --%>
                    </div>
                </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_og_stitch"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_stitch_id" path="coOptionGiletStandardInfo.ogStitch" class="form-check-input" items="${orderCoForm.coOptionGiletStandardInfo.ogStitchMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="og_stitch_Msg">
<%--                     	${orderCoForm.coOptionGiletStandardInfo.glAmfStitchRtPrice } --%>
                    </div>
                </div>
                <div id="og_stitch_yes_area">
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_stitchModify_id" path="coOptionGiletStandardInfo.ogStitchModify" class="form-check-input" items="${orderCoForm.coOptionGiletStandardInfo.ogStitchModifyMap}"/>
                        </div>
                        <div id="og_stitchModifyPlace" style="display:none">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_og_stitchModifyPlace">全選択</button>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_og_stitchModifyPlace">全解除</button>
                        </div>
                        </div>
                        <div class="offset-md-1">
                        <%-- <div class="form-check-inline form-check">
                            <form:checkboxes id="og_stitchModifyPlace_id" class="form-check-input" items="${orderCoForm.coOptionGiletStandardInfo.ogStitchModifyPlaceMap}" path="coOptionGiletStandardInfo.ogStitchModifyPlace"/>
                        </div> --%>
                        <c:forEach var="ogStitchModifyPlaceMap" items="${orderCoForm.coOptionGiletStandardInfo.ogStitchModifyPlaceMap }" varStatus="row">
                      		<div class="form-check-inline form-check">
                      			<input type="checkbox" id="og_stitchModifyPlace_id${row.count}" name="coOptionGiletStandardInfo.ogStitchModifyPlace${row.count}" value="${ogStitchModifyPlaceMap.key}" class="form-check-input">${ogStitchModifyPlaceMap.value}
                      		</div>
                      	</c:forEach>
                        </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="og_stitchModify_Msg">
<%--                     	${orderCoForm.coOptionGiletStandardInfo.glStitchPlcRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_dStitchModify_id" path="coOptionGiletStandardInfo.ogDStitchModify" class="form-check-input" items="${orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyMap}"/>
                        </div>
                        <div id="og_dStitchModifyPlace" style="display:none">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_og_dStitchModifyPlace">全選択</button>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_og_dStitchModifyPlace">全解除</button>
                        </div>
                        </div>
                        <div class="offset-md-1">
                        <%-- <div class="form-check-inline form-check">
                            <form:checkboxes id="og_dStitchModifyPlace_id" class="form-check-input" items="${orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyPlaceMap}" path="coOptionGiletStandardInfo.ogDStitchModifyPlace"/>
                        </div> --%>
                        <c:forEach var="ogDStitchModifyPlaceMap" items="${orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyPlaceMap }" varStatus="row">
                      		<div class="form-check-inline form-check">
                      			<input type="checkbox" id="og_dStitchModifyPlace_id${row.count}" name="coOptionGiletStandardInfo.ogDStitchModifyPlace${row.count}" value="${ogDStitchModifyPlaceMap.key}" class="form-check-input">${ogDStitchModifyPlaceMap.value}
                      		</div>
                      	</c:forEach>
                        </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="og_dStitchModify_Msg">
<%--                     	${orderCoForm.coOptionGiletStandardInfo.glDblstitchPlcRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_amfColor_id" path="coOptionGiletStandardInfo.ogAmfColor" class="form-check-input" items="${orderCoForm.coOptionGiletStandardInfo.ogAmfColorMap}"/>
                        </div>
                        <div id="og_amfColor_div" style="display:none">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <form:select id="og_amfColorPlaceAll" path="coOptionGiletStandardInfo.ogAmfColorPlaceAll" class="form-control-sm form-control">
                            	<form:options items="${orderCoForm.coOptionGiletStandardInfo.ogAmfColorPlaceAllMap}"/>
                        	</form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_og_amfColorPlace">全選択</button>
                        	&nbsp;
                        	<button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_og_amfColorPlace">全解除</button>
                        </div>
                        </div>
                        
                        <c:forEach var="ogAmfColorPlaceMap" items="${orderCoForm.coOptionGiletStandardInfo.ogAmfColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="og_amfColorPlace" class="form-check-label ">
                                <input type="checkbox" id="og_amfColorPlace_${row.count}" name="coOptionGiletStandardInfo.ogAmfColorPlace${row.count}" value="${ogAmfColorPlaceMap.key }" class="form-check-input">${ogAmfColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="og_amfColorPlace_${row.count}_div"  style="display:none">
                        		<c:forEach var="ogAmfColorsMap" items="${orderCoForm.coOptionGiletStandardInfo.ogAmfColorPlaceAllMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="og_amfColor" class="form-check-label ">
                        			    <input type="radio" id="og_amfColor_${ogAmfColorsMap.key}" name="coOptionGiletStandardInfo.ogAmfColor${row.count}" value="${ogAmfColorsMap.key}" class="form-check-input">${ogAmfColorsMap.value}
                        		     </label>
                        		  </div>
                        		</c:forEach>
                        	</div>
                        </c:forEach>
                        
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="og_amfColor_Msg">
<%--                     	${orderCoForm.coOptionGiletStandardInfo.glAmfColorRtPrice } --%>
                    </div>
                </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_bhColor_id" path="coOptionGiletStandardInfo.ogBhColor" class="form-check-input" items="${orderCoForm.coOptionGiletStandardInfo.ogBhColorMap}"/>
                        </div>
                        <div id="og_bhColor_div" style="display:none">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                        <form:select id="og_bhColorPlaceAll" path="coOptionGiletStandardInfo.ogBhColorPlaceAll" class="form-control-sm form-control">
                            	<form:options items="${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlaceAllMap}"/>
                        </form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_og_bhColorPlace">全選択</button>
                            &nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_og_bhColorPlace">全解除</button>
                        </div>
                        </div>
                        
                        <c:forEach var="ogBhColorPlaceMap" items="${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="og_bhColorPlace" class="form-check-label ">
                                <input type="checkbox" id="og_bhColorPlace_${row.count}" name="coOptionGiletStandardInfo.ogBhColorPlace${row.count}" value="${ogBhColorPlaceMap.key }" class="form-check-input">${ogBhColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="og_bhColorPlace_${row.count}_div" style="display:none">
                        		<c:forEach var="ogBhColorsMap" items="${orderCoForm.coOptionGiletStandardInfo.ogBhColorsMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="og_bhColor" class="form-check-label ">
                        			    <input type="radio" id="og_bhColor_${ogBhColorsMap.key}" name="coOptionGiletStandardInfo.ogBhColor${row.count}" value="${ogBhColorsMap.key}" class="form-check-input">${ogBhColorsMap.value}
                        		     </label>
                        		  </div>
                        		</c:forEach>
                        	</div>
                        </c:forEach>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="og_bhColor_Msg">
<%--                     	${orderCoForm.coOptionGiletStandardInfo.glBtnholeColorRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_byColor_id" path="coOptionGiletStandardInfo.ogByColor" class="form-check-input" items="${orderCoForm.coOptionGiletStandardInfo.ogByColorMap}"/>
                        </div>
                        <div id="og_byColor_div" style="display:none">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <form:select id="og_byColorPlaceAll" path="coOptionGiletStandardInfo.ogByColorPlaceAll" class="form-control-sm form-control">
                            	<form:options items="${orderCoForm.coOptionGiletStandardInfo.ogByColorPlaceAllMap}"/>
                            </form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_og_byColorPlace">全選択</button>
                            &nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_og_byColorPlace">全解除</button>
                        </div>
                        </div>
                        
                        <c:forEach var="ogByColorPlaceMap" items="${orderCoForm.coOptionGiletStandardInfo.ogByColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="og_byColorPlace" class="form-check-label ">
                                <input type="checkbox" id="og_byColorPlace_${row.count}" name="coOptionGiletStandardInfo.ogByColorPlace${row.count}" value="${ogByColorPlaceMap.key }" class="form-check-input">${ogByColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="og_byColorPlace_${row.count}_div" style="display:none">
                        		<c:forEach var="ogByColorsMap" items="${orderCoForm.coOptionGiletStandardInfo.ogByColorsMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="og_byColor" class="form-check-label ">
                        			    <input type="radio" id="og_byColor_${ogByColorsMap.key}" name="coOptionGiletStandardInfo.ogByColor${row.count}" value="${ogByColorsMap.key}" class="form-check-input">${ogByColorsMap.value}
                        		     </label>
                        		  </div>
                        		</c:forEach>
                        	</div>
                        </c:forEach>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="og_byColor_Msg">
<%--                     	${orderCoForm.coOptionGiletStandardInfo.glBtnthreadColorRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">背裏地素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_og_backLiningMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col-12 col-md-3">
                        <form:select id="og_backLiningMate" path="coOptionGiletStandardInfo.ogBackLiningMate" class="form-control-sm form-control">
                            	<form:options items="${orderCoForm.coOptionGiletStandardInfo.ogBackLiningMateMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-4">
                        <select name="coOptionGiletStandardInfo.ogBackLiningMateStkNo" id="og_backLiningMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col col-md-1">
                        <button type="button" class="btn btn-outline-info btn-sm" id="btn_og_backLiningMate">上着と同じ</button>
                    </div>
                    <div class="col-12 col-md-1" align="right" id="og_backLiningMate_Msg">
<%--                     	${orderCoForm.coOptionGiletStandardInfo.glBackClothRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_og_insideLiningMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col-12 col-md-3">
                        <form:select id="og_insideLiningMate" path="coOptionGiletStandardInfo.ogInsideLiningMate" class="form-control-sm form-control">
                            	<form:options items="${orderCoForm.coOptionGiletStandardInfo.ogInsideLiningMateMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-4">
                        <select name="coOptionGiletStandardInfo.ogInsideLiningMateStkNo" id="og_insideLiningMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col-12 col-md-2" align="right" id="og_insideLiningMate_Msg">
<%--                     	${orderCoForm.coOptionGiletStandardInfo.glInnnerClothRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_og_frontBtnMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col-12 col-md-3">
                        <form:select id="og_frontBtnMate" path="coOptionGiletStandardInfo.ogFrontBtnMate" class="form-control-sm form-control">
                            	<form:options items="${orderCoForm.coOptionGiletStandardInfo.ogFrontBtnMateMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-4">
                        <select name="coOptionGiletStandardInfo.ogFrontBtnMateStkNo" id="og_frontBtnMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col col-md-1">
                        <button type="button" class="btn btn-outline-info btn-sm" id="btn_og_frontBtnMate">上着と同じ</button>
                    </div>
                    <div class="col-12 col-md-1" align="right" id="og_frontBtnMate_Msg">
<%--                     	${orderCoForm.coOptionGiletStandardInfo.glFrtBtnRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
                    <div class="col-12 col-md-3">
                        <form:select id="og_backBelt" path="coOptionGiletStandardInfo.ogBackBelt" class="form-control-sm form-control">
                            	<form:options items="${orderCoForm.coOptionGiletStandardInfo.ogBackBeltMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-6" align="right" id="og_backBelt_Msg">
<%--                     	${orderCoForm.coOptionGiletStandardInfo.glBackBeltRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ウォッチチェーン</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_watchChain_id" path="coOptionGiletStandardInfo.ogWatchChain" class="form-check-input" items="${orderCoForm.coOptionGiletStandardInfo.ogWatchChainMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="og_watchChain_Msg">
<%--                     	${orderCoForm.coOptionGiletStandardInfo.glWatchChainRtPrice } --%>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    
    
    <!-- タキシード GILET -->
    <div id="tu_gilet_div">
    <div class="card-header">
        <strong class="card-title">GILET</strong>
    </div>
    <div class="card-body">
        <div class="row">
            <div class="col col-lg-12">
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">GILETモデル</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tg_giletModel"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="tg_giletModel" path="coOptionGiletTuxedoInfo.tgGiletModel" class="form-control-sm form-control">
                        	<form:options items="${orderCoForm.coOptionGiletTuxedoInfo.tgGiletModelMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="giletModel_Msg"></div>
                    <div class="col-12 col-md-9 offset-md-3" id="tg_giletModelMsg" style="margin-top:8px"></div>
                    <div class="col-12 col-md-9 offset-md-3" id="tg_giletModelCheck" style="display:none"></div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
                    <div class="col col-md-6">
                    	<div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_breastPkt_id" path="coOptionGiletTuxedoInfo.tgBreastPkt" class="form-check-input" items="${orderCoForm.coOptionGiletTuxedoInfo.tgBreastPktMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="tg_breastPkt_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
                    <div class="col col-md-6">
                    	<div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_waistPkt_id" path="coOptionGiletTuxedoInfo.tgWaistPkt" class="form-check-input" items="${orderCoForm.coOptionGiletTuxedoInfo.tgWaistPktMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="tg_waistPkt_Msg">
                    </div>
                </div>
                <div id="tg_waistPkt_yes_area">
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット形状</label></div>
                    <div class="col-12 col-md-6">
                    	<div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_waistPktSpec_id" path="coOptionGiletTuxedoInfo.tgWaistPktSpec" class="form-check-input" items="${orderCoForm.coOptionGiletTuxedoInfo.tgWaistPktSpecMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="tg_waistPktSpec_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット素材</label></div>
                    <div class="col-12 col-md-6">
                    	<div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_waistPktMate_id" path="coOptionGiletTuxedoInfo.tgWaistPktMate" class="form-check-input" items="${orderCoForm.coOptionGiletTuxedoInfo.tgWaistPktMateMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="tg_waistPktMate_Msg">
                    </div>
                </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
                    <div class="col-12 col-md-6">
                    	<div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_stitch_id" path="coOptionGiletTuxedoInfo.tgStitch" class="form-check-input" items="${orderCoForm.coOptionGiletTuxedoInfo.tgStitchMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="tg_stitch_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_bhColor_id" path="coOptionGiletTuxedoInfo.tgBhColor" class="form-check-input" items="${orderCoForm.coOptionGiletTuxedoInfo.tgBhColorMap}"/>
                        </div>
                        <div id="tg_bhColor_div">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <form:select id="tg_bhColorPlaceAll" path="coOptionGiletTuxedoInfo.tgBhColorPlaceAll" class="form-control-sm form-control">
                            	<form:options items="${orderCoForm.coOptionGiletTuxedoInfo.tgBhColorPlaceAllMap}"/>
                        	</form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tg_bhColorPlace">全選択</button>
                            &nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tg_bhColorPlace">全解除</button>
                        </div>
                        </div>
                        
                        <c:forEach var="tgBhColorPlaceMap" items="${orderCoForm.coOptionGiletTuxedoInfo.tgBhColorPlaceMap }" varStatus="row">
                         <div class="offset-md-1">
                             <div class="form-check">
                             <div class="checkbox">
                             <label for="tg_bhColorPlace" class="form-check-label ">
                                 <input type="checkbox" id="tg_bhColorPlace_${row.count}" name="coOptionGiletTuxedoInfo.tgBhColorPlace${row.count}" value="${tgBhColorPlaceMap.key }" class="form-check-input">${tgBhColorPlaceMap.value }
                             </label>
                             </div>
                             </div>
                         </div>
                         <div class="offset-md-2" id="tg_bhColorPlace_${row.count}_div" style="display:none">
                         	<c:forEach var="tgBhColorsMap" items="${orderCoForm.coOptionGiletTuxedoInfo.tgBhColorsMap}">
                       		  <div class="form-check-inline form-check">
                       		     <label for="tg_bhColor" class="form-check-label ">
                       			    <input type="radio" id="tg_bhColor_${tgBhColorsMap.key}" name="coOptionGiletTuxedoInfo.tgBhColor${row.count}" value="${tgBhColorsMap.key}" class="form-check-input">${tgBhColorsMap.value}
                       		     </label>
                       		  </div>
                       		</c:forEach>
                         </div>
                     </c:forEach>
                     </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="tg_bhColor_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_byColor_id" path="coOptionGiletTuxedoInfo.tgByColor" class="form-check-input" items="${orderCoForm.coOptionGiletTuxedoInfo.tgByColorMap}"/>
                        </div>
                        <div id="tg_byColor_div">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <form:select id="tg_byColorPlaceAll" path="coOptionGiletTuxedoInfo.tgByColorPlaceAll" class="form-control-sm form-control">
                            	<form:options items="${orderCoForm.coOptionGiletTuxedoInfo.tgByColorPlaceAllMap}"/>
                            </form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tg_byColorPlace">全選択</button>
                            &nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tg_byColorPlace">全解除</button>
                        </div>
                        </div>
                        
                        <c:forEach var="tgByColorPlaceMap" items="${orderCoForm.coOptionGiletTuxedoInfo.tgByColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="og_byColorPlace" class="form-check-label ">
                                <input type="checkbox" id="tg_byColorPlace_${row.count}" name="coOptionGiletTuxedoInfo.tgByColorPlace${row.count}" value="${tgByColorPlaceMap.key }" class="form-check-input">${tgByColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="tg_byColorPlace_${row.count}_div" style="display:none">
                        		<c:forEach var="tgByColorsMap" items="${orderCoForm.coOptionGiletTuxedoInfo.tgByColorsMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="tg_byColor" class="form-check-label ">
                        			    <input type="radio" id="tg_byColor_${tgByColorsMap.key}" name="coOptionGiletTuxedoInfo.tgByColor${row.count}" value="${tgByColorsMap.key}" class="form-check-input">${tgByColorsMap.value}
                        		     </label>
                        		  </div>
                        		</c:forEach>
                        	</div>
                        </c:forEach>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="tg_byColor_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">背裏地素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tg_backLiningMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="tg_backLiningMate" path="coOptionGiletTuxedoInfo.tgBackLiningMate" class="form-control-sm form-control">
                            	<form:options items="${orderCoForm.coOptionGiletTuxedoInfo.tgBackLiningMateMap}"/>
                        </form:select>
                    </div>
                    <div class="col col-md-4">
                        <select name="coOptionGiletTuxedoInfo.tgBackLiningMateStkNo" id="tg_backLiningMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col col-md-1">
                        <button type="button" class="btn btn-outline-info btn-sm" id="btn_tg_backLiningMate">上着と同じ</button>
                    </div>
                    <div class="col-12 col-md-1" align="right" id="tg_backLiningMate_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tg_insideLiningMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="tg_insideLiningMate" path="coOptionGiletTuxedoInfo.tgInsideLiningMate" class="form-control-sm form-control">
                            <form:options items="${orderCoForm.coOptionGiletTuxedoInfo.tgInsideLiningMateMap}"/>
                        </form:select>
                    </div>
                    <div class="col col-md-4">
                        <select name="coOptionGiletTuxedoInfo.tgInsideLiningMateStkNo" id="tg_insideLiningMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col-12 col-md-2" align="right" id="tg_insideLiningMate_Msg">
                    </div>
                </div>
                
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tg_frontBtnMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="tg_frontBtnMate" path="coOptionGiletTuxedoInfo.tgFrontBtnMate" class="form-control-sm form-control">
                            <form:options items="${orderCoForm.coOptionGiletTuxedoInfo.tgFrontBtnMateMap}"/>
                        </form:select>
                    </div>
                    <div class="col col-md-4">
                        <select name="coOptionGiletTuxedoInfo.tgFrontBtnMateStkNo" id="tg_frontBtnMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col col-md-1">
                        <button type="button" class="btn btn-outline-info btn-sm" id="btn_tg_frontBtnMate">上着と同じ</button>
                    </div>
                    <div class="col-12 col-md-1" align="right" id="tg_frontBtnMate_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
                    <div class="col col-md-3">
                    	<form:select id="tg_backBelt" path="coOptionGiletTuxedoInfo.tgBackBelt" class="form-control-sm form-control">
                            <form:options items="${orderCoForm.coOptionGiletTuxedoInfo.tgBackBeltMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-6" align="right" id="tg_backBelt_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ウォッチチェーン</label></div>
                    <div class="col-12 col-md-6">
                    	<div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_watchChain_id" path="coOptionGiletTuxedoInfo.tgWatchChain" class="form-check-input" items="${orderCoForm.coOptionGiletTuxedoInfo.tgWatchChainMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="tg_watchChain_Msg">
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    
    <!-- ウォッシャブル GILET -->
    <div id="wa_gilet_div">
    <div class="card-header">
        <strong class="card-title">GILET</strong>
    </div>
    <div class="card-body">
        <div class="row">
            <div class="col col-lg-12">
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">GILETモデル</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wg_giletModel"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="wg_giletModel" path="coOptionGiletWashableInfo.wgGiletModel" class="form-control-sm form-control">
							<form:options items="${orderCoForm.coOptionGiletWashableInfo.wgGiletModelMap}"/>
						</form:select>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="giletModel_Msg"></div>
                    <div class="col-12 col-md-9 offset-md-3" id="wg_giletModelMsg" style="margin-top:8px"></div>
                    <div class="col-12 col-md-9 offset-md-3" id="wg_giletModelCheck" style="display:none"></div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
                    <div class="col col-md-6">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_breastPkt_id" path="coOptionGiletWashableInfo.wgBreastPkt" class="form-check-input" items="${orderCoForm.coOptionGiletWashableInfo.wgBreastPktMap}"/>
						</div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="wg_breastPkt_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
                    <div class="col col-md-6">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_waistPkt_id" path="coOptionGiletWashableInfo.wgWaistPkt" class="form-check-input" items="${orderCoForm.coOptionGiletWashableInfo.wgWaistPktMap}"/>
						</div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="wg_waistPkt_Msg">
                    </div>
                </div>
                <div id="wg_waistPkt_yes_area">
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット形状</label></div>
                    <div class="col-12 col-md-6">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_waistPktSpec_id" path="coOptionGiletWashableInfo.wgWaistPktSpec" class="form-check-input" items="${orderCoForm.coOptionGiletWashableInfo.wgWaistPktSpecMap}"/>
						</div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="wg_waistPktSpec_Msg">
                    </div>
                </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
                    <div class="col-12 col-md-6">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_stitch_id" path="coOptionGiletWashableInfo.wgStitch" class="form-check-input" items="${orderCoForm.coOptionGiletWashableInfo.wgStitchMap}"/>
						</div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="wg_stitch_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                    <div class="col-12 col-md-6">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_stitchModify_id" path="coOptionGiletWashableInfo.wgStitchModify" class="form-check-input" items="${orderCoForm.coOptionGiletWashableInfo.wgStitchModifyMap}"/>
						</div>
                        <div id="wg_stitchModifyPlace"  style="display:none">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wg_stitchModifyPlace">全選択</button>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wg_stitchModifyPlace">全解除</button>
                        </div>
                        </div>
                        <div class="offset-md-1">
                        <%-- <div class="form-check-inline form-check">
							<form:checkboxes id="wg_stitchModifyPlace_id" path="coOptionGiletWashableInfo.wgStitchModifyPlace" class="form-check-input" items="${orderCoForm.coOptionGiletWashableInfo.wgStitchModifyPlaceMap}"/>
						</div> --%>
						<c:forEach var="wgStitchModifyPlaceMap" items="${orderCoForm.coOptionGiletWashableInfo.wgStitchModifyPlaceMap }" varStatus="row">
                      		<div class="form-check-inline form-check">
                      			<input type="checkbox" id="wg_stitchModifyPlace_id${row.count}" name="coOptionGiletWashableInfo.wgStitchModifyPlace${row.count}" value="${wgStitchModifyPlaceMap.key}" class="form-check-input">${wgStitchModifyPlaceMap.value}
                      		</div>
                      	</c:forEach>
                        </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="wg_stitchModify_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
                    <div class="col-12 col-md-6">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_dStitchModify_id" path="coOptionGiletWashableInfo.wgDStitchModify" class="form-check-input" items="${orderCoForm.coOptionGiletWashableInfo.wgDStitchModifyMap}"/>
						</div>
                        <div id="wg_dStitchModifyPlace"  style="display:none">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wg_dStitchModifyPlace">全選択</button>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wg_dStitchModifyPlace">全解除</button>
                        </div>
                        </div>
                        <div class="offset-md-1">
                        <%-- <div class="form-check-inline form-check">
							<form:checkboxes id="wg_dStitchModifyPlace_id" path="coOptionGiletWashableInfo.wgDStitchModifyPlace" class="form-check-input" items="${orderCoForm.coOptionGiletWashableInfo.wgDStitchModifyPlaceMap}"/>
						</div> --%>
						<c:forEach var="wgDStitchModifyPlaceMap" items="${orderCoForm.coOptionGiletWashableInfo.wgDStitchModifyPlaceMap }" varStatus="row">
                      		<div class="form-check-inline form-check">
                      			<input type="checkbox" id="wg_dStitchModifyPlace_id${row.count}" name="coOptionGiletWashableInfo.wgDStitchModifyPlace${row.count}" value="${wgDStitchModifyPlaceMap.key}" class="form-check-input">${wgDStitchModifyPlaceMap.value}
                      		</div>
                      	</c:forEach>
                        </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="wg_dStitchModify_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
                    <div class="col-12 col-md-6">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_amfColor_id" path="coOptionGiletWashableInfo.wgAmfColor" class="form-check-input" items="${orderCoForm.coOptionGiletWashableInfo.wgAmfColorMap}"/>
						</div>
                        <div id="wg_amfColor_div" style="display:none;">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                         <form:select id="wg_amfColorPlaceAll" path="coOptionGiletWashableInfo.wgAmfColorPlaceAll" class="form-control-sm form-control">
							<form:options items="${orderCoForm.coOptionGiletWashableInfo.wgAmfColorPlaceAllMap}"/>
						</form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wg_amfColorPlace">全選択</button>
                            &nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wg_amfColorPlace">全解除</button>
                        </div>
                        </div>
                        <c:forEach var="wgAmfColorPlaceMap" items="${orderCoForm.coOptionGiletWashableInfo.wgAmfColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="wg_amfColorPlace" class="form-check-label ">
                                <input type="checkbox" id="wg_amfColorPlace_${row.count}" name="coOptionGiletWashableInfo.wgAmfColorPlace${row.count}" value="${wgAmfColorPlaceMap.key }" class="form-check-input">${wgAmfColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="wg_amfColorPlace_${row.count}_div" style="display:none">
                        		<c:forEach var="wgAmfColorsMap" items="${orderCoForm.coOptionGiletWashableInfo.wgAmfColorPlaceAllMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="wg_amfColor" class="form-check-label ">
                        			    <input type="radio" id="wg_amfColor_${wgAmfColorsMap.key}" name="coOptionGiletWashableInfo.wgAmfColor${row.count}" value="${wgAmfColorsMap.key}" class="form-check-input">${wgAmfColorsMap.value}
                        		     </label>
                        		  </div>
                        		</c:forEach>
                        	</div>
                        </c:forEach>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="wg_amfColor_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                    <div class="col-12 col-md-6">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_bhColor_id" path="coOptionGiletWashableInfo.wgBhColor" class="form-check-input" items="${orderCoForm.coOptionGiletWashableInfo.wgBhColorMap}"/>
						</div>
                        <div id="wg_bhColor_div">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <form:select id="wg_bhColorPlaceAll" path="coOptionGiletWashableInfo.wgBhColorPlaceAll" class="form-control-sm form-control">
								<form:options items="${orderCoForm.coOptionGiletWashableInfo.wgBhColorPlaceAllMap}"/>
							</form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wg_bhColorPlace">全選択</button>
                            &nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wg_bhColorPlace">全解除</button>
                        </div>
                        </div>
                        <c:forEach var="wgBhColorPlaceMap" items="${orderCoForm.coOptionGiletWashableInfo.wgBhColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="wg_bhColorPlace" class="form-check-label ">
                                <input type="checkbox" id="wg_bhColorPlace_${row.count}" name="coOptionGiletWashableInfo.wgBhColorPlace${row.count}" value="${wgBhColorPlaceMap.key }" class="form-check-input">${wgBhColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="wg_bhColorPlace_${row.count}_div" style="display:none">
                        		<c:forEach var="wgBhColorsMap" items="${orderCoForm.coOptionGiletWashableInfo.wgBhColorsMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="wg_bhColor" class="form-check-label ">
                        			    <input type="radio" id="wg_bhColor_${wgBhColorsMap.key}" name="coOptionGiletWashableInfo.wgBhColor${row.count}" value="${wgBhColorsMap.key}" class="form-check-input">${wgBhColorsMap.value}
                        		     </label>
                        		  </div>
                        		</c:forEach>
                        	</div>
                        </c:forEach>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="wg_bhColor_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
                    <div class="col-12 col-md-6">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_byColor_id" path="coOptionGiletWashableInfo.wgByColor" class="form-check-input" items="${orderCoForm.coOptionGiletWashableInfo.wgByColorMap}"/>
						</div>
                        <div id="wg_byColor_div">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <form:select id="wg_byColorPlaceAll" path="coOptionGiletWashableInfo.wgByColorPlaceAll" class="form-control-sm form-control">
								<form:options items="${orderCoForm.coOptionGiletWashableInfo.wgByColorPlaceAllMap}"/>
							</form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wg_byColorPlace">全選択</button>
                            &nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wg_byColorPlace">全解除</button>
                        </div>
                        </div>
                        <c:forEach var="wgByColorPlaceMap" items="${orderCoForm.coOptionGiletWashableInfo.wgByColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="wg_byColorPlace" class="form-check-label ">
                                <input type="checkbox" id="wg_byColorPlace_${row.count}" name="coOptionGiletWashableInfo.wgByColorPlace${row.count}" value="${wgByColorPlaceMap.key }" class="form-check-input">${wgByColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="wg_byColorPlace_${row.count}_div" style="display:none">
                        		<c:forEach var="wgByColorsMap" items="${orderCoForm.coOptionGiletWashableInfo.wgByColorsMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="wg_bhColor" class="form-check-label ">
                        			    <input type="radio" id="wg_byColor_${wgByColorsMap.key}" name="coOptionGiletWashableInfo.wgByColor${row.count}" value="${wgByColorsMap.key}" class="form-check-input">${wgByColorsMap.value}
                        		     </label>
                        		  </div>
                        		</c:forEach>
                        	</div>
                        </c:forEach>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="wg_byColor_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">背裏地素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wg_backLiningMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="wg_backLiningMate" path="coOptionGiletWashableInfo.wgBackLiningMate" class="form-control-sm form-control">
							<form:options items="${orderCoForm.coOptionGiletWashableInfo.wgBackLiningMateMap}"/>
						</form:select>
                    </div>
                    <div class="col col-md-4">
                        <select name="coOptionGiletWashableInfo.wgBackLiningMateStkNo" id="wg_backLiningMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col col-md-1">
                        <button type="button" class="btn btn-outline-info btn-sm" id="btn_wg_backLiningMate">上着と同じ</button>
                    </div>
                    <div class="col-12 col-md-1" align="right" id="wg_backLiningMate_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wg_insideLiningMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="wg_insideLiningMate" path="coOptionGiletWashableInfo.wgInsideLiningMate" class="form-control-sm form-control">
							<form:options items="${orderCoForm.coOptionGiletWashableInfo.wgInsideLiningMateMap}"/>
						</form:select>
                    </div>
                    <div class="col col-md-4">
                        <select name="coOptionGiletWashableInfo.wgInsideLiningMateStkNo" id="wg_insideLiningMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col-12 col-md-2" align="right" id="wg_insideLiningMate_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wg_frontBtnMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="wg_frontBtnMate" path="coOptionGiletWashableInfo.wgFrontBtnMate" class="form-control-sm form-control">
							<form:options items="${orderCoForm.coOptionGiletWashableInfo.wgFrontBtnMateMap}"/>
						</form:select>
                    </div>
                    <div class="col col-md-4">
                        <select name="coOptionGiletWashableInfo.wgFrontBtnMateStkNo" id="wg_frontBtnMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col col-md-1">
                        <button type="button" class="btn btn-outline-info btn-sm" id="btn_wg_frontBtnMate">上着と同じ</button>
                    </div>
                    <div class="col-12 col-md-1" align="right" id="wg_frontBtnMate_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
                    <div class="col col-md-3">
                    	<form:select id="wg_backBelt" path="coOptionGiletWashableInfo.wgBackBelt" class="form-control-sm form-control">
							<form:options items="${orderCoForm.coOptionGiletWashableInfo.wgBackBeltMap}"/>
						</form:select>
                    </div>
                    <div class="col-12 col-md-6" align="right" id="wg_backBelt_Msg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ウォッチチェーン</label></div>
                    <div class="col-12 col-md-6">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_watchChain_id" path="coOptionGiletWashableInfo.wgWatchChain" class="form-check-input" items="${orderCoForm.coOptionGiletWashableInfo.wgWatchChainMap}"/>
						</div>
                    </div>
                    <div class="col-12 col-md-3" align="right" id="wg_watchChain_Msg">
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="${orderCoForm.jacketItemFlag }"/>
	<input type="hidden" id="pantsItemFlag" name="pantsItemFlag" value="${orderCoForm.pantsItemFlag }"/>
	<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="0"/>
	<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="${orderCoForm.shirtItemFlag }"/>
	<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="${orderCoForm.coatItemFlag }"/>
	<input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="${orderCoForm.pants2ItemFlag }"/>
    
	<input type="hidden" id="giletAdFlag" name="giletAdFlag" value="${orderCoForm.giletAdFlag }" />	
	<input type="hidden" id="jacketAdFlag" name="jacketAdFlag" value="${orderCoForm.jacketAdFlag }" />
	<input type="hidden" id="coatAdFlag" name="coatAdFlag" value="${orderCoForm.coatAdFlag }" />
	<input type="hidden" id="pantsAdFlag" name="pantsAdFlag" value="${orderCoForm.pantsAdFlag }" />
	<input type="hidden" id="pants2AdFlag" name="pants2AdFlag" value="${orderCoForm.pants2AdFlag }" />
	<input type="hidden" id="shirtAdFlag" name="shirtAdFlag" value="${orderCoForm.shirtAdFlag }" />
	<input type="hidden" id="jacketBtnMateGlFlag" name="jacketBtnMateGlFlag" value="${orderCoForm.jacketBtnMateGlFlag }" />
</form:form>

<!-- 自作js -->
<%-- <script src="${pageContext.request.contextPath}/resources/app/self/js/rule.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/config.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/customer.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/tabMenu.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/product.js"></script> --%>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.gilet.standard.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.gilet.tuxedo.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.gilet.washable.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";
var orderFlag = "${orderCoForm.orderFlag}";
var jacketBtnMateGlFlag = "${orderCoForm.jacketBtnMateGlFlag}";
var ojBtnMateStkNo="${orderCoForm.coOptionJacketStandardInfo.ojBtnMateStkNo}";
var tjBtnMateStkNo="${orderCoForm.coOptionJacketTuxedoInfo.tjBtnMateStkNo}";
var wjBtnMateStkNo="${orderCoForm.coOptionJacketWashableInfo.wjBtnMateStkNo}";
var selectIdList = {
	"og_backLiningMate":"00017",
	"og_insideLiningMate":"00019",
	"og_frontBtnMate":"00021",
	"tg_backLiningMate":"00017",
	"tg_insideLiningMate":"00019",
	"tg_frontBtnMate":"00021",
	"wg_backLiningMate":"00017",
	"wg_insideLiningMate":"00019",
	"wg_frontBtnMate":"00021"
};

jQuery(function() {
// 	var productCategory="${orderCoForm.productCategory}";
	var productCategory=jQuery('input[name="productCategory"]:checked').val();

	var giletAdFlag="${orderCoForm.giletAdFlag}";
	if("orderCo"==orderFlag){
		if(giletAdFlag=="1"){
		}else{
			jQuery("#giletAdFlag").val("0");
		}
	}else if("0"==jQuery("#giletItemFlag").val() && "orderCo"!=orderFlag){
		    jQuery("#giletAdFlag").val("1");
	}

	if(jacketBtnMateGlFlag=="1"){
		if(productCategory == "9000101"){
			var ojBtnMate="${orderCoForm.coOptionJacketStandardInfo.ojBtnMate}";
			if(ojBtnMate!="3000800" && ojBtnMate!="3000200" && ojBtnMate!="3000300" && ojBtnMate!="3000400" &&
			   ojBtnMate!="3000500" && ojBtnMate!="3000600" && ojBtnMate!="3000900"){
				jQuery('#og_frontBtnMate').val("3000800");
				jQuery('#og_frontBtnMate').change();
			}else{
				jQuery('#og_frontBtnMate').val(ojBtnMate);
				jQuery('#og_frontBtnMate').change();
			}
		}else if(productCategory == "9000102"){
			var tjBtnMate="${orderCoForm.coOptionJacketTuxedoInfo.tjBtnMate}";
			if(tjBtnMate!="3000800" && tjBtnMate!="3000200" && tjBtnMate!="3000300" && tjBtnMate!="3000400" &&
			   tjBtnMate!="3000500" && tjBtnMate!="3000600" && tjBtnMate!="3000700" && tjBtnMate!="3000900"){
				jQuery('#tg_frontBtnMate').val("3000800");
				jQuery('#tg_frontBtnMate').change();
			}else{
				jQuery('#tg_frontBtnMate').val(tjBtnMate);
				jQuery('#tg_frontBtnMate').change();
			}
		}else if(productCategory == "9000103"){
			var wjBtnMate="${orderCoForm.coOptionJacketWashableInfo.wjBtnMate}";
			if(wjBtnMate!="3000800" && wjBtnMate!="3000600" && wjBtnMate!="3000900"){
				jQuery('#wg_frontBtnMate').val("3000800");
				jQuery('#wg_frontBtnMate').change();
			}else{
				jQuery('#wg_frontBtnMate').val(wjBtnMate);
				jQuery('#wg_frontBtnMate').change();
			}
		}
	}
	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });

    setGiletModelDisable(productCategory);

	//--------------------------------------------
	// 共通
	//--------------------------------------------
	initCommon();

	// オプションタブ（Gilet）
	//--------------------------------------------
 	if(productCategory == "9000101"){
 		initOptionGiletStandard();

 	// 背裏地素材（上着と同じ）
		jQuery('#btn_og_backLiningMate').click(function() {
			// JACKET胴裏素材
			var ojBodyBackMateSameBtn="${orderCoForm.coOptionJacketStandardInfo.ojBodyBackMate}";
			// JACKET胴裏品番
			var ojBodyBackMateStkNoSameBtn="${orderCoForm.coOptionJacketStandardInfo.ojBodyBackMateStkNo}";
			// 背裏地素材への反映
			if(ojBodyBackMateSameBtn=="1000100" || ojBodyBackMateSameBtn=="1000200" 
				|| ojBodyBackMateSameBtn=="1000300"){
				jQuery('#og_backLiningMate').val(ojBodyBackMateSameBtn);
				jQuery('#og_backLiningMate').change();
				jQuery('#og_backLiningMateStkNo').val(ojBodyBackMateStkNoSameBtn);
				jQuery('#og_backLiningMateStkNo').change();
			}else if(ojBodyBackMateSameBtn=="1000400"){
				//現在、そのような状況はありません
			}else{
				jQuery('#og_backLiningMate').val("1000100");
				jQuery('#og_backLiningMate').change();
				jQuery('#og_backLiningMateStkNo').val("100010001");
				jQuery('#og_backLiningMateStkNo').change();
			}
		});

	 	// フロント釦（上着と同じ）
	 	jQuery('#btn_og_frontBtnMate').click(function() {
	 		// JACKET釦素材
	 		var ojBtnMateSameBtn = "${orderCoForm.coOptionJacketStandardInfo.ojBtnMate}";
	 		// JACKET釦品番
	 		var ojBtnMateStkNoSameBtn = "${orderCoForm.coOptionJacketStandardInfo.ojBtnMateStkNo}";
			// 背裏地素材への反映
			if(ojBtnMateSameBtn=="3000800" || ojBtnMateSameBtn=="3000200" 
				|| ojBtnMateSameBtn=="3000300" || ojBtnMateSameBtn=="3000400" 
				|| ojBtnMateSameBtn=="3000500" || ojBtnMateSameBtn=="3000600" 
				|| ojBtnMateSameBtn=="3000900"){
				jQuery('#og_frontBtnMate').val(ojBtnMateSameBtn);
				jQuery('#og_frontBtnMate').change();
				jQuery('#og_frontBtnMateStkNo').val(ojBtnMateStkNoSameBtn);
				jQuery('#og_frontBtnMateStkNo').change();
			}else{
				jQuery('#og_frontBtnMate').val("3000800");
				jQuery('#og_frontBtnMate').change();
				jQuery('#og_frontBtnMateStkNo').val("300080001");
				jQuery('#og_frontBtnMateStkNo').change();
			}
	 	});

	}else if(productCategory == "9000102"){
		initOptionGiletTuxedo();

		// 背裏地素材（上着と同じ）
		jQuery('#btn_tg_backLiningMate').click(function() {
			// JACKET胴裏素材
			var tjBodyBackMateSameBtn="${orderCoForm.coOptionJacketTuxedoInfo.tjBodyBackMate}";
			// JACKET胴裏品番
			var tjBodyBackMateStkNoSameBtn="${orderCoForm.coOptionJacketTuxedoInfo.tjBodyBackMateStkNo}";
			// 背裏地素材への反映
			if(tjBodyBackMateSameBtn=="1000100" || tjBodyBackMateSameBtn=="1000200" 
				|| tjBodyBackMateSameBtn=="1000300"){
				jQuery('#tg_backLiningMate').val(tjBodyBackMateSameBtn);
				jQuery('#tg_backLiningMate').change();
				jQuery('#tg_backLiningMateStkNo').val(tjBodyBackMateStkNoSameBtn);
				jQuery('#tg_backLiningMateStkNo').change();
			}else if(tjBodyBackMateSameBtn=="1000400"){
				//現在、そのような状況はありません
			}else{
				jQuery('#tg_backLiningMate').val("1000100");
				jQuery('#tg_backLiningMate').change();
				jQuery('#tg_backLiningMateStkNo').val("100010001");
				jQuery('#tg_backLiningMateStkNo').change();
			}
		});

	 	// フロント釦（上着と同じ）
	 	jQuery('#btn_tg_frontBtnMate').click(function() {
	 		// JACKET釦素材
	 		var tjBtnMateSameBtn = "${orderCoForm.coOptionJacketTuxedoInfo.tjBtnMate}";
	 		// JACKET釦品番
	 		var tjBtnMateStkNoSameBtn = "${orderCoForm.coOptionJacketTuxedoInfo.tjBtnMateStkNo}";
			// 背裏地素材への反映
			if(tjBtnMateSameBtn=="3000800" || tjBtnMateSameBtn=="3000200" 
				|| tjBtnMateSameBtn=="3000300" || tjBtnMateSameBtn=="3000400" 
				|| tjBtnMateSameBtn=="3000500" || tjBtnMateSameBtn=="3000600" 
				|| tjBtnMateSameBtn=="3000900" || tjBtnMateSameBtn=="3000700"){
				jQuery('#tg_frontBtnMate').val(tjBtnMateSameBtn);
				jQuery('#tg_frontBtnMate').change();
				jQuery('#tg_frontBtnMateStkNo').val(tjBtnMateStkNoSameBtn);
				jQuery('#tg_frontBtnMateStkNo').change();
			}else{
				jQuery('#tg_frontBtnMate').val("3000800");
				jQuery('#tg_frontBtnMate').change();
				jQuery('#tg_frontBtnMateStkNo').val("300080001");
				jQuery('#tg_frontBtnMateStkNo').change();
			}
	 	});

	}else if(productCategory == "9000103"){
		initOptionGiletWashable();

		// 背裏地素材（上着と同じ）
		jQuery('#btn_wg_backLiningMate').click(function() {
			// JACKET胴裏素材
			var wjBodyBackMateSameBtn="${orderCoForm.coOptionJacketWashableInfo.wjBodyBackMate}";
			// JACKET胴裏品番
			var wjBodyBackMateStkNoSameBtn="${orderCoForm.coOptionJacketWashableInfo.wjBodyBackMateStkNo}";
			// 背裏地素材への反映
			if(wjBodyBackMateSameBtn=="1000100"){
				jQuery('#wg_backLiningMate').val(wjBodyBackMateSameBtn);
				jQuery('#wg_backLiningMate').change();
				if(wjBodyBackMateStkNoSameBtn!="100010001" && wjBodyBackMateStkNoSameBtn!="100010002" 
					&& wjBodyBackMateStkNoSameBtn!="100010003" && wjBodyBackMateStkNoSameBtn!="100010004" 
					&& wjBodyBackMateStkNoSameBtn!="100010005" && wjBodyBackMateStkNoSameBtn!="100010006"){
					jQuery('#wg_backLiningMateStkNo').val("100010001");
					jQuery('#tg_backLiningMateStkNo').change();
				}else{
					jQuery('#wg_backLiningMateStkNo').val(wjBodyBackMateStkNoSameBtn);
					jQuery('#tg_backLiningMateStkNo').change();
				}
			}else if(wjBodyBackMateSameBtn=="1000400"){
				//現在、そのような状況はありません
			}else{
				jQuery('#wg_backLiningMate').val("1000100");
				jQuery('#wg_backLiningMate').change();
				jQuery('#wg_backLiningMateStkNo').val("100010001");
				jQuery('#wg_backLiningMateStkNo').change();
			}
		});

	 	// フロント釦（上着と同じ）
	 	jQuery('#btn_wg_frontBtnMate').click(function() {
	 		// JACKET釦素材
	 		var wjBtnMateSameBtn = "${orderCoForm.coOptionJacketWashableInfo.wjBtnMate}";
	 		// JACKET釦品番
	 		var wjBtnMateStkNoSameBtn = "${orderCoForm.coOptionJacketWashableInfo.wjBtnMateStkNo}";
			// 背裏地素材への反映
			if(wjBtnMateSameBtn=="3000800" || wjBtnMateSameBtn=="3000600" 
				|| wjBtnMateSameBtn=="3000900"){
				jQuery('#wg_frontBtnMate').val(wjBtnMateSameBtn);
				jQuery('#wg_frontBtnMate').change();
				jQuery('#wg_frontBtnMateStkNo').val(wjBtnMateStkNoSameBtn);
				jQuery('#wg_frontBtnMateStkNo').change();
			}else{
				jQuery('#wg_frontBtnMate').val("3000800");
				jQuery('#wg_frontBtnMate').change();
				jQuery('#wg_frontBtnMateStkNo').val("300080001");
				jQuery('#wg_frontBtnMateStkNo').change();
			}
	 	});
		
	}

//  	setBtnMateAndBtnMateStkNo(productCategory);
 	
	//--------------------------------------------
	// 補正タブ
	//--------------------------------------------
	initAlter();
	//--------------------------------------------
	// タブメニュー
	//--------------------------------------------
	initTabMenu();
	//--------------------------------------------
	// 商品タブ
	//--------------------------------------------
	changeViewArea();

	mateInit();

	mateStkNoReInit(productCategory);

	getPrice();

	showPrice();

	var orderFlag = "${orderCoForm.orderFlag}";
	if(orderFlag == "orderCo"){
	}else if(orderFlag == "orderLink" || orderFlag == "orderDivert"){
		var productCategory = jQuery('input[name="productCategory"]:checked').val();
		if(productCategory == "9000101"){

			var ogStitchModifyPlace = "${orderCoForm.coOptionGiletStandardInfo.ogStitchModifyPlace}";
			if(isNotEmpty(ogStitchModifyPlace)){
				var ogStitchModifyPlaceStr = ogStitchModifyPlace.split("/");
				for(var i=0;i<ogStitchModifyPlaceStr.length;i++){
					if(ogStitchModifyPlaceStr[i] == "0000701"){
						jQuery("#og_stitchModifyPlace_id1").prop("checked",true);
					}else if(ogStitchModifyPlaceStr[i] == "0000704"){
						jQuery("#og_stitchModifyPlace_id2").prop("checked",true);
					}else if(ogStitchModifyPlaceStr[i] == "0000705"){
						jQuery("#og_stitchModifyPlace_id3").prop("checked",true);
					}
				}
			}
			// 選択中のダブルステッチ変更
			ctrlOgDStitchPlace();
			// AMF色指定の有効/無効を制御
			ctrlOgAmfColor();

			var ogDStitchModifyPlace = "${orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyPlace}";
			if(isNotEmpty(ogDStitchModifyPlace)){
				var ogDStitchModifyPlaceStr = ogDStitchModifyPlace.split("/");
				for(var i=0;i<ogDStitchModifyPlaceStr.length;i++){
					if(ogDStitchModifyPlaceStr[i] == "0002701"){
						jQuery("#og_dStitchModifyPlace_id1").prop("checked",true);
					}else if(ogDStitchModifyPlaceStr[i] == "0002702"){
						jQuery("#og_dStitchModifyPlace_id2").prop("checked",true);
					}else if(ogDStitchModifyPlaceStr[i] == "0002703"){
						jQuery("#og_dStitchModifyPlace_id3").prop("checked",true);
					}
				}
			}
			
			var ogAmfColorPlace = "${orderCoForm.coOptionGiletStandardInfo.ogAmfColorPlace}";
			var ogAmfAllColor = "${orderCoForm.coOptionGiletStandardInfo.ogAmfAllColor}";
// 			if(isNotEmpty(ogAmfColorPlace)&&isNotEmpty(ogAmfAllColor)){
			if(isNotEmpty(ogAmfColorPlace)){
				var ogAmfColorPlaceStr = ogAmfColorPlace.split("/");
				var ogAmfAllColorStr = ogAmfAllColor.split("/");
				for(var i=0;i<ogAmfColorPlaceStr.length;i++){
					if(ogAmfColorPlaceStr[i] == "0000901"){
						jQuery("#og_amfColorPlace_1").prop("checked",true);
//						jQuery(":radio[name='coOptionGiletStandardInfo.ogAmfColor1'][value='" + ogAmfAllColor[i] + "']").prop("checked", true);
					}else if(ogAmfColorPlaceStr[i] == "0000902"){
						jQuery("#og_amfColorPlace_2").prop("checked",true);
//						jQuery(":radio[name='coOptionGiletStandardInfo.ogAmfColor2'][value='" + ogAmfAllColor[i] + "']").prop("checked", true);
					}else if(ogAmfColorPlaceStr[i] == "0000903"){
						jQuery("#og_amfColorPlace_3").prop("checked",true);
//						jQuery(":radio[name='coOptionGiletStandardInfo.ogAmfColor3'][value='" + ogAmfAllColor[i] + "']").prop("checked", true);
					}
					
					for(var j=0;j<ogAmfAllColorStr.length;j++){
						if(ogAmfColorPlaceStr[i] == "0000901"){
// 							jQuery("#og_amfColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionGiletStandardInfo.ogAmfColor1'][value='" + ogAmfAllColor[j] + "']").prop("checked", true);
						}else if(ogAmfColorPlaceStr[i] == "0000902"){
// 							jQuery("#og_amfColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionGiletStandardInfo.ogAmfColor2'][value='" + ogAmfAllColor[j] + "']").prop("checked", true);
						}else if(ogAmfColorPlaceStr[i] == "0000903"){
// 							jQuery("#og_amfColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionGiletStandardInfo.ogAmfColor3'][value='" + ogAmfAllColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="og_amfColorPlace_"]').change();
			}
			

			var ogBhColorPlace = "${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlace}";
			var ogBhAllColor = "${orderCoForm.coOptionGiletStandardInfo.ogBhAllColor}";
// 			if(isNotEmpty(ogBhColorPlace)&&isNotEmpty(ogBhAllColor)){
			if(isNotEmpty(ogBhColorPlace)){
				var ogBhColorPlaceStr = ogBhAllColor.split("/");
				var ogBhAllColorStr = ogBhColorPlace.split("/");
				for(var i=0;i<ogBhColorPlaceStr.length;i++){
					if(ogBhColorPlaceStr[i] == "0001201"){
						jQuery("#og_bhColorPlace_1").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogBhColor1'][value='" + ogBhAllColor[i] + "']").prop("checked", true);
					}else if(ogBhColorPlaceStr[i] == "0001202"){
						jQuery("#og_bhColorPlace_2").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogBhColor2'][value='" + ogBhAllColor[i] + "']").prop("checked", true);
					}else if(ogBhColorPlaceStr[i] == "0001203"){
						jQuery("#og_bhColorPlace_3").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogBhColor3'][value='" + ogBhAllColor[i] + "']").prop("checked", true);
					}else if(ogBhColorPlaceStr[i] == "0001204"){
						jQuery("#og_bhColorPlace_4").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogBhColor4'][value='" + ogBhAllColor[i] + "']").prop("checked", true);
					}else if(ogBhColorPlaceStr[i] == "0001205"){
						jQuery("#og_bhColorPlace_5").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogBhColor5'][value='" + ogBhAllColor[i] + "']").prop("checked", true);
					}else if(ogBhColorPlaceStr[i] == "0001206"){
						jQuery("#og_bhColorPlace_6").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogBhColor6'][value='" + ogBhAllColor[i] + "']").prop("checked", true);
					}
					
					for(var j=0;j<ogBhAllColorStr.length;i++){
						if(ogBhColorPlaceStr[i] == "0001201"){
// 							jQuery("#og_bhColorPlace_1").prop("checked",true);
	 						jQuery(":radio[name='coOptionGiletStandardInfo.ogBhColor1'][value='" + ogBhAllColor[j] + "']").prop("checked", true);
						}else if(ogBhColorPlaceStr[i] == "0001202"){
// 							jQuery("#og_bhColorPlace_2").prop("checked",true);
	 						jQuery(":radio[name='coOptionGiletStandardInfo.ogBhColor2'][value='" + ogBhAllColor[j] + "']").prop("checked", true);
						}else if(ogBhColorPlaceStr[i] == "0001203"){
// 							jQuery("#og_bhColorPlace_3").prop("checked",true);
	 						jQuery(":radio[name='coOptionGiletStandardInfo.ogBhColor3'][value='" + ogBhAllColor[j] + "']").prop("checked", true);
						}else if(ogBhColorPlaceStr[i] == "0001204"){
// 							jQuery("#og_bhColorPlace_4").prop("checked",true);
	 						jQuery(":radio[name='coOptionGiletStandardInfo.ogBhColor4'][value='" + ogBhAllColor[j] + "']").prop("checked", true);
						}else if(ogBhColorPlaceStr[i] == "0001205"){
// 							jQuery("#og_bhColorPlace_5").prop("checked",true);
	 						jQuery(":radio[name='coOptionGiletStandardInfo.ogBhColor5'][value='" + ogBhAllColor[j] + "']").prop("checked", true);
						}else if(ogBhColorPlaceStr[i] == "0001206"){
// 							jQuery("#og_bhColorPlace_6").prop("checked",true);
	 						jQuery(":radio[name='coOptionGiletStandardInfo.ogBhColor6'][value='" + ogBhAllColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="og_bhColorPlace_"]').change();
			}
			
			var ogByColorPlace = "${orderCoForm.coOptionGiletStandardInfo.ogByColorPlace}";
			var ogByAllColor = "${orderCoForm.coOptionGiletStandardInfo.ogByAllColor}";
// 			if(isNotEmpty(ogByAllColor)&&isNotEmpty(ogByColorPlace)){
			if(isNotEmpty(ogByAllColor)){
				var ogByColorPlaceStr = ogByColorPlace.split("/");
				var ogByAllColorStr = ogByAllColor.split("/");
				for(var i=0;i<ogByColorPlaceStr.length;i++){
					if(ogByColorPlaceStr[i] == "0001501"){
						jQuery("#og_byColorPlace_1").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor1'][value='" + ogByAllColor[i] + "']").prop("checked", true);
					}else if(ogByColorPlaceStr[i] == "0001502"){
						jQuery("#og_byColorPlace_2").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor2'][value='" + ogByAllColor[i] + "']").prop("checked", true);
					}else if(ogByColorPlaceStr[i] == "0001503"){
						jQuery("#og_byColorPlace_3").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor3'][value='" + ogByAllColor[i] + "']").prop("checked", true);
					}else if(ogByColorPlaceStr[i] == "0001504"){
						jQuery("#og_byColorPlace_4").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor4'][value='" + ogByAllColor[i] + "']").prop("checked", true);
					}else if(ogByColorPlaceStr[i] == "0001505"){
						jQuery("#og_byColorPlace_5").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor5'][value='" + ogByAllColor[i] + "']").prop("checked", true);
					}else if(ogByColorPlaceStr[i] == "0001506"){
						jQuery("#og_byColorPlace_6").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor6'][value='" + ogByAllColor[i] + "']").prop("checked", true);
					}else if(ogByColorPlaceStr[i] == "0001507"){
						jQuery("#og_byColorPlace_7").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor7'][value='" + ogByAllColor[i] + "']").prop("checked", true);
					}else if(ogByColorPlaceStr[i] == "0001508"){
						jQuery("#og_byColorPlace_8").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor8'][value='" + ogByAllColor[i] + "']").prop("checked", true);
					}else if(ogByColorPlaceStr[i] == "0001509"){
						jQuery("#og_byColorPlace_9").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor9'][value='" + ogByAllColor[i] + "']").prop("checked", true);
					}else if(ogByColorPlaceStr[i] == "0001510"){
						jQuery("#og_byColorPlace_10").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor10'][value='" + ogByAllColor[i] + "']").prop("checked", true);
					}
					
					for(var j=0;j<ogByAllColorStr.length;j++){
						if(ogByColorPlaceStr[i] == "0001501"){
// 							jQuery("#og_byColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor1'][value='" + ogByAllColor[j] + "']").prop("checked", true);
						}else if(ogByColorPlaceStr[i] == "0001502"){
// 							jQuery("#og_byColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor2'][value='" + ogByAllColor[j] + "']").prop("checked", true);
						}else if(ogByColorPlaceStr[i] == "0001503"){
// 							jQuery("#og_byColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor3'][value='" + ogByAllColor[j] + "']").prop("checked", true);
						}else if(ogByColorPlaceStr[i] == "0001504"){
// 							jQuery("#og_byColorPlace_4").prop("checked",true);
							jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor4'][value='" + ogByAllColor[j] + "']").prop("checked", true);
						}else if(ogByColorPlaceStr[i] == "0001505"){
// 							jQuery("#og_byColorPlace_5").prop("checked",true);
							jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor5'][value='" + ogByAllColor[j] + "']").prop("checked", true);
						}else if(ogByColorPlaceStr[i] == "0001506"){
// 							jQuery("#og_byColorPlace_6").prop("checked",true);
							jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor6'][value='" + ogByAllColor[j] + "']").prop("checked", true);
						}else if(ogByColorPlaceStr[i] == "0001507"){
// 							jQuery("#og_byColorPlace_7").prop("checked",true);
							jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor7'][value='" + ogByAllColor[j] + "']").prop("checked", true);
						}else if(ogByColorPlaceStr[i] == "0001508"){
// 							jQuery("#og_byColorPlace_8").prop("checked",true);
							jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor8'][value='" + ogByAllColor[j] + "']").prop("checked", true);
						}else if(ogByColorPlaceStr[i] == "0001509"){
// 							jQuery("#og_byColorPlace_9").prop("checked",true);
							jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor9'][value='" + ogByAllColor[j] + "']").prop("checked", true);
						}else if(ogByColorPlaceStr[i] == "0001510"){
// 							jQuery("#og_byColorPlace_10").prop("checked",true);
							jQuery(":radio[name='coOptionGiletStandardInfo.ogByColor10'][value='" + ogByAllColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="og_byColorPlace_"]').change();
			}
			
		}else if(productCategory == "9000102"){
			var tgAllBhColor = "${orderCoForm.coOptionGiletTuxedoInfo.tgBhAllColor}";
			var tgBhColorPlace = "${orderCoForm.coOptionGiletTuxedoInfo.tgBhColorPlace}";
// 			if(isNotEmpty(tgAllBhColor)&&isNotEmpty(tgBhColorPlace)){
			if(isNotEmpty(tgAllBhColor)){
				var tgBhColorPlaceStr = tgBhColorPlace.split("/");
				var tgAllBhColorStr = tgAllBhColor.split("/");
				for(var i=0;i<tgBhColorPlaceStr.length;i++){
					if(tgBhColorPlaceStr[i] == "0001201"){
						jQuery("#tg_bhColorPlace_1").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgBhColor1'][value='" + tgAllBhColor[i] + "']").prop("checked", true);
					}else if(tgBhColorPlaceStr[i] == "0001202"){
						jQuery("#tg_bhColorPlace_2").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgBhColor2'][value='" + tgAllBhColor[i] + "']").prop("checked", true);
					}else if(tgBhColorPlaceStr[i] == "0001203"){
						jQuery("#tg_bhColorPlace_3").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgBhColor3'][value='" + tgAllBhColor[i] + "']").prop("checked", true);
					}else if(tgBhColorPlaceStr[i] == "0001204"){
						jQuery("#tg_bhColorPlace_4").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgBhColor4'][value='" + tgAllBhColor[i] + "']").prop("checked", true);
					}else if(tgBhColorPlaceStr[i] == "0001205"){
						jQuery("#tg_bhColorPlace_5").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgBhColor5'][value='" + tgAllBhColor[i] + "']").prop("checked", true);
					}else if(tgBhColorPlaceStr[i] == "0001206"){
						jQuery("#tg_bhColorPlace_6").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgBhColor6'][value='" + tgAllBhColor[i] + "']").prop("checked", true);
					}
					
					for(var j=0;j<tgAllBhColorStr.length;j++){
						if(tgBhColorPlaceStr[i] == "0001201"){
// 							jQuery("#tg_bhColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgBhColor1'][value='" + tgAllBhColor[j] + "']").prop("checked", true);
						}else if(tgBhColorPlaceStr[i] == "0001202"){
// 							jQuery("#tg_bhColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgBhColor2'][value='" + tgAllBhColor[j] + "']").prop("checked", true);
						}else if(tgBhColorPlaceStr[i] == "0001203"){
// 							jQuery("#tg_bhColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgBhColor3'][value='" + tgAllBhColor[j] + "']").prop("checked", true);
						}else if(tgBhColorPlaceStr[i] == "0001204"){
// 							jQuery("#tg_bhColorPlace_4").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgBhColor4'][value='" + tgAllBhColor[j] + "']").prop("checked", true);
						}else if(tgBhColorPlaceStr[i] == "0001205"){
// 							jQuery("#tg_bhColorPlace_5").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgBhColor5'][value='" + tgAllBhColor[j] + "']").prop("checked", true);
						}else if(tgBhColorPlaceStr[i] == "0001206"){
// 							jQuery("#tg_bhColorPlace_6").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgBhColor6'][value='" + tgAllBhColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="tg_bhColorPlace_"]').change();
			}
			
			var tgByColorPlace = "${orderCoForm.coOptionGiletTuxedoInfo.tgByColorPlace}";
			var tgAllByColor = "${orderCoForm.coOptionGiletTuxedoInfo.tgByAllColor}";
// 			if(isNotEmpty(tgAllByColor)&&isNotEmpty(tgByColorPlace)){
			if(isNotEmpty(tgAllByColor)){
				var tgByColorPlaceStr = tgByColorPlace.split("/");
				var tgAllByColorStr = tgAllByColor.split("/");
				for(var i=0;i<tgByColorPlaceStr.length;i++){
					if(tgByColorPlaceStr[i] == "0001501"){
						jQuery("#tg_byColorPlace_1").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor1'][value='" + tgAllByColor[i] + "']").prop("checked", true);
					}else if(tgByColorPlaceStr[i] == "0001502"){
						jQuery("#tg_byColorPlace_2").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor2'][value='" + tgAllByColor[i] + "']").prop("checked", true);
					}else if(tgByColorPlaceStr[i] == "0001503"){
						jQuery("#tg_byColorPlace_3").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor3'][value='" + tgAllByColor[i] + "']").prop("checked", true);
					}else if(tgByColorPlaceStr[i] == "0001504"){
						jQuery("#tg_byColorPlace_4").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor4'][value='" + tgAllByColor[i] + "']").prop("checked", true);
					}else if(tgByColorPlaceStr[i] == "0001505"){
						jQuery("#tg_byColorPlace_5").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor5'][value='" + tgAllByColor[i] + "']").prop("checked", true);
					}else if(tgByColorPlaceStr[i] == "0001506"){
						jQuery("#tg_byColorPlace_6").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor6'][value='" + tgAllByColor[i] + "']").prop("checked", true);
					}else if(tgByColorPlaceStr[i] == "0001507"){
						jQuery("#tg_byColorPlace_7").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor7'][value='" + tgAllByColor[i] + "']").prop("checked", true);
					}else if(tgByColorPlaceStr[i] == "0001508"){
						jQuery("#tg_byColorPlace_8").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor8'][value='" + tgAllByColor[i] + "']").prop("checked", true);
					}else if(tgByColorPlaceStr[i] == "0001509"){
						jQuery("#tg_byColorPlace_9").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor9'][value='" + tgAllByColor[i] + "']").prop("checked", true);
					}else if(tgByColorPlaceStr[i] == "0001510"){
						jQuery("#tg_byColorPlace_10").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor10'][value='" + tgAllByColor[i] + "']").prop("checked", true);
					}
					
					for(var j=0;j<tgAllByColorStr.length;j++){
						if(tgByColorPlaceStr[i] == "0001501"){
// 							jQuery("#tg_byColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor1'][value='" + tgAllByColor[j] + "']").prop("checked", true);
						}else if(tgByColorPlaceStr[i] == "0001502"){
// 							jQuery("#tg_byColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor2'][value='" + tgAllByColor[j] + "']").prop("checked", true);
						}else if(tgByColorPlaceStr[i] == "0001503"){
// 							jQuery("#tg_byColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor3'][value='" + tgAllByColor[j] + "']").prop("checked", true);
						}else if(tgByColorPlaceStr[i] == "0001504"){
// 							jQuery("#tg_byColorPlace_4").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor4'][value='" + tgAllByColor[j] + "']").prop("checked", true);
						}else if(tgByColorPlaceStr[i] == "0001505"){
// 							jQuery("#tg_byColorPlace_5").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor5'][value='" + tgAllByColor[j] + "']").prop("checked", true);
						}else if(tgByColorPlaceStr[i] == "0001506"){
// 							jQuery("#tg_byColorPlace_6").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor6'][value='" + tgAllByColor[j] + "']").prop("checked", true);
						}else if(tgByColorPlaceStr[i] == "0001507"){
// 							jQuery("#tg_byColorPlace_7").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor7'][value='" + tgAllByColor[j] + "']").prop("checked", true);
						}else if(tgByColorPlaceStr[i] == "0001508"){
// 							jQuery("#tg_byColorPlace_8").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor8'][value='" + tgAllByColor[j] + "']").prop("checked", true);
						}else if(tgByColorPlaceStr[i] == "0001509"){
// 							jQuery("#tg_byColorPlace_9").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor9'][value='" + tgAllByColor[j] + "']").prop("checked", true);
						}else if(tgByColorPlaceStr[i] == "0001510"){
// 							jQuery("#tg_byColorPlace_10").prop("checked",true);
							jQuery(":radio[name='coOptionGiletTuxedoInfo.tgByColor10'][value='" + tgAllByColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="tg_byColorPlace_"]').change();
			}
			
		}else if(productCategory == "9000103"){
			var wgStitchModifyPlace = "${orderCoForm.coOptionGiletWashableInfo.wgStitchModifyPlace}";
			if(isNotEmpty(wgStitchModifyPlace)){
				var wgStitchModifyPlaceStr = wgStitchModifyPlace.split("/");
				for(var i=0;i<wgStitchModifyPlaceStr.length;i++){
					if(wgStitchModifyPlaceStr[i] == "0000701"){
						jQuery("#wg_stitchModifyPlace_id1").prop("checked",true);
					}else if(wgStitchModifyPlaceStr[i] == "0000704"){
						jQuery("#wg_stitchModifyPlace_id2").prop("checked",true);
					}else if(wgStitchModifyPlaceStr[i] == "0000705"){
						jQuery("#wg_stitchModifyPlace_id3").prop("checked",true);
					}
				}
			}
			
			// 選択中のダブルステッチ変更
			ctrlWgDStitchPlace();
			// AMF色指定の有効/無効を制御
			ctrlWgAmfColor();

			var wgDStitchModifyPlace = "${orderCoForm.coOptionGiletWashableInfo.wgDStitchModifyPlace}";
			if(isNotEmpty(wgDStitchModifyPlace)){
				var wgDStitchModifyPlaceStr = wgDStitchModifyPlace.split("/");
				for(var i=0;i<wgDStitchModifyPlaceStr.length;i++){
					if(wgDStitchModifyPlaceStr[i] == "0002701"){
						jQuery("#wg_dStitchModifyPlace_id1").prop("checked",true);
					}else if(wgDStitchModifyPlaceStr[i] == "0002702"){
						jQuery("#wg_dStitchModifyPlace_id2").prop("checked",true);
					}else if(wgDStitchModifyPlaceStr[i] == "0002703"){
						jQuery("#wg_dStitchModifyPlace_id3").prop("checked",true);
					}
				}
			}
			
			var wgAmfColorPlace = "${orderCoForm.coOptionGiletWashableInfo.wgAmfColorPlace}";
			var wgAmfAllColor = "${orderCoForm.coOptionGiletWashableInfo.wgAmfAllColor}";
// 			if(isNotEmpty(wgAmfAllColor)&&isNotEmpty(wgAmfColorPlace)){
			if(isNotEmpty(wgAmfAllColor)){
				var wgAmfColorPlaceStr = wgAmfColorPlace.split("/");
				var wgAmfAllColorStr = wgAmfAllColor.split("/");
				for(var i=0;i<wgAmfColorPlaceStr.length;i++){
					if(wgAmfColorPlaceStr[i] == "0000901"){
						jQuery("#wg_amfColorPlace_1").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgAmfColor1'][value='" + wgAmfAllColor[i] + "']").prop("checked", true);
					}else if(wgAmfColorPlaceStr[i] == "0000902"){
						jQuery("#wg_amfColorPlace_2").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgAmfColor2'][value='" + wgAmfAllColor[i] + "']").prop("checked", true);
					}else if(wgAmfColorPlaceStr[i] == "0000903"){
						jQuery("#wg_amfColorPlace_3").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgAmfColor3'][value='" + wgAmfAllColor[i] + "']").prop("checked", true);
					}

					for(var j=0;j<wgAmfAllColorStr.length;j++){
						if(wgAmfColorPlaceStr[i] == "0000901"){
// 							jQuery("#wg_amfColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgAmfColor1'][value='" + wgAmfAllColor[j] + "']").prop("checked", true);
						}else if(wgAmfColorPlaceStr[i] == "0000902"){
// 							jQuery("#wg_amfColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgAmfColor2'][value='" + wgAmfAllColor[j] + "']").prop("checked", true);
						}else if(wgAmfColorPlaceStr[i] == "0000903"){
// 							jQuery("#wg_amfColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgAmfColor3'][value='" + wgAmfAllColor[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="wg_amfColorPlace_"]').change();
			}
			
			var wgBhColorPlace = "${orderCoForm.coOptionGiletWashableInfo.wgBhColorPlace}";
			var wgBhAllColor = "${orderCoForm.coOptionGiletWashableInfo.wgBhAllColor}";
// 			if(isNotEmpty(wgBhAllColor)&&isNotEmpty(wgBhColorPlace)){
			if(isNotEmpty(wgBhColorPlace)){
				var wgBhColorPlaceStr = wgBhColorPlace.split("/");
				var wgBhAllColorStr = wgBhAllColor.split("/");
				for(var i=0;i<wgBhColorPlaceStr.length;i++){
					if(wgBhColorPlaceStr[i] == "0001201"){
						jQuery("#wg_bhColorPlace_1").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgBhColor1'][value='" + wgBhAllColor[i] + "']").prop("checked", true);
					}else if(wgBhColorPlaceStr[i] == "0001202"){
						jQuery("#wg_bhColorPlace_2").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgBhColor2'][value='" + wgBhAllColor[i] + "']").prop("checked", true);
					}else if(wgBhColorPlaceStr[i] == "0001203"){
						jQuery("#wg_bhColorPlace_3").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgBhColor3'][value='" + wgBhAllColor[i] + "']").prop("checked", true);
					}else if(wgBhColorPlaceStr[i] == "0001204"){
						jQuery("#wg_bhColorPlace_4").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgBhColor4'][value='" + wgBhAllColor[i] + "']").prop("checked", true);
					}else if(wgBhColorPlaceStr[i] == "0001205"){
						jQuery("#wg_bhColorPlace_5").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgBhColor5'][value='" + wgBhAllColor[i] + "']").prop("checked", true);
					}else if(wgBhColorPlaceStr[i] == "0001206"){
						jQuery("#wg_bhColorPlace_6").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgBhColor6'][value='" + wgBhAllColor[i] + "']").prop("checked", true);
					}

					for(var j=0;j<wgBhAllColorStr.length;j++){
						if(wgBhColorPlaceStr[i] == "0001201"){
// 							jQuery("#wg_bhColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgBhColor1'][value='" + wgBhAllColorStr[j] + "']").prop("checked", true);
						}else if(wgBhColorPlaceStr[i] == "0001202"){
// 							jQuery("#wg_bhColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgBhColor2'][value='" + wgBhAllColorStr[j] + "']").prop("checked", true);
						}else if(wgBhColorPlaceStr[i] == "0001203"){
// 							jQuery("#wg_bhColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgBhColor3'][value='" + wgBhAllColorStr[j] + "']").prop("checked", true);
						}else if(wgBhColorPlaceStr[i] == "0001204"){
// 							jQuery("#wg_bhColorPlace_4").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgBhColor4'][value='" + wgBhAllColorStr[j] + "']").prop("checked", true);
						}else if(wgBhColorPlaceStr[i] == "0001205"){
// 							jQuery("#wg_bhColorPlace_5").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgBhColor5'][value='" + wgBhAllColorStr[j] + "']").prop("checked", true);
						}else if(wgBhColorPlaceStr[i] == "0001206"){
// 							jQuery("#wg_bhColorPlace_6").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgBhColor6'][value='" + wgBhAllColorStr[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="wg_bhColorPlace_"]').change();
			}
			
			var wgByColorPlace = "${orderCoForm.coOptionGiletWashableInfo.wgByColorPlace}";
			var wgByAllColor = "${orderCoForm.coOptionGiletWashableInfo.wgByAllColor}";
// 			if(isNotEmpty(wgByColorPlace)&&isNotEmpty(wgByAllColor)){
			if(isNotEmpty(wgByColorPlace)){
				var wgByColorPlaceStr = wgByColorPlace.split("/");
				var wgAllByColorStr = wgByAllColor.split("/");
				for(var i=0;i<wgByColorPlaceStr.length;i++){
					if(wgByColorPlaceStr[i] == "0001501"){
						jQuery("#wg_byColorPlace_1").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor1'][value='" + wgByAllColor[i] + "']").prop("checked", true);
					}else if(wgByColorPlaceStr[i] == "0001502"){
						jQuery("#wg_byColorPlace_2").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor2'][value='" + wgByAllColor[i] + "']").prop("checked", true);
					}else if(wgByColorPlaceStr[i] == "0001503"){
						jQuery("#wg_byColorPlace_3").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor3'][value='" + wgByAllColor[i] + "']").prop("checked", true);
					}else if(wgByColorPlaceStr[i] == "0001504"){
						jQuery("#wg_byColorPlace_4").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor4'][value='" + wgByAllColor[i] + "']").prop("checked", true);
					}else if(wgByColorPlaceStr[i] == "0001505"){
						jQuery("#wg_byColorPlace_5").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor5'][value='" + wgByAllColor[i] + "']").prop("checked", true);
					}else if(wgByColorPlaceStr[i] == "0001506"){
						jQuery("#wg_byColorPlace_6").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor6'][value='" + wgByAllColor[i] + "']").prop("checked", true);
					}else if(wgByColorPlaceStr[i] == "0001507"){
						jQuery("#wg_byColorPlace_7").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor7'][value='" + wgByAllColor[i] + "']").prop("checked", true);
					}else if(wgByColorPlaceStr[i] == "0001508"){
						jQuery("#wg_byColorPlace_8").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor8'][value='" + wgByAllColor[i] + "']").prop("checked", true);
					}else if(wgByColorPlaceStr[i] == "0001509"){
						jQuery("#wg_byColorPlace_9").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor9'][value='" + wgByAllColor[i] + "']").prop("checked", true);
					}else if(wgByColorPlaceStr[i] == "0001510"){
						jQuery("#wg_byColorPlace_10").prop("checked",true);
// 						jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor10'][value='" + wgByAllColor[i] + "']").prop("checked", true);
					}

					for(var j=0;j<wgAllByColorStr.length;j++){
						if(wgByColorPlaceStr[i] == "0001501"){
// 							jQuery("#wg_byColorPlace_1").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor1'][value='" + wgAllByColorStr[j] + "']").prop("checked", true);
						}else if(wgByColorPlaceStr[i] == "0001502"){
// 							jQuery("#wg_byColorPlace_2").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor2'][value='" + wgAllByColorStr[j] + "']").prop("checked", true);
						}else if(wgByColorPlaceStr[i] == "0001503"){
// 							jQuery("#wg_byColorPlace_3").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor3'][value='" + wgAllByColorStr[j] + "']").prop("checked", true);
						}else if(wgByColorPlaceStr[i] == "0001504"){
// 							jQuery("#wg_byColorPlace_4").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor4'][value='" + wgAllByColorStr[j] + "']").prop("checked", true);
						}else if(wgByColorPlaceStr[i] == "0001505"){
// 							jQuery("#wg_byColorPlace_5").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor5'][value='" + wgAllByColorStr[j] + "']").prop("checked", true);
						}else if(wgByColorPlaceStr[i] == "0001506"){
// 							jQuery("#wg_byColorPlace_6").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor6'][value='" + wgAllByColorStr[j] + "']").prop("checked", true);
						}else if(wgByColorPlaceStr[i] == "0001507"){
// 							jQuery("#wg_byColorPlace_7").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor7'][value='" + wgAllByColorStr[j] + "']").prop("checked", true);
						}else if(wgByColorPlaceStr[i] == "0001508"){
// 							jQuery("#wg_byColorPlace_8").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor8'][value='" + wgAllByColorStr[j] + "']").prop("checked", true);
						}else if(wgByColorPlaceStr[i] == "0001509"){
// 							jQuery("#wg_byColorPlace_9").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor9'][value='" + wgAllByColorStr[j] + "']").prop("checked", true);
						}else if(wgByColorPlaceStr[i] == "0001510"){
// 							jQuery("#wg_byColorPlace_10").prop("checked",true);
							jQuery(":radio[name='coOptionGiletWashableInfo.wgByColor10'][value='" + wgAllByColorStr[j] + "']").prop("checked", true);
						}
					}
				}
				jQuery('input[id^="wg_byColorPlace_"]').change();
			}
		}
	}else if(orderFlag == "orderCheck"){
	}

	if(productCategory == "9000101"){
		if(jacketBtnMateGlFlag=="1"){
			 jQuery('#og_frontBtnMateStkNo').val("${orderCoForm.coOptionGiletStandardInfo.ogFrontBtnMateStkNo}");	
			 jQuery("#jacketBtnMateGlFlag").val("0");
		}

	}else if(productCategory == "9000102"){
		if(jacketBtnMateGlFlag=="1"){
			 jQuery('#tg_frontBtnMateStkNo').val("${orderCoForm.coOptionGiletTuxedoInfo.tgFrontBtnMateStkNo}");	
			 jQuery("#jacketBtnMateGlFlag").val("0");
		}

	}else if(productCategory == "9000103"){
		if(jacketBtnMateGlFlag=="1"){
			 jQuery('#wg_frontBtnMateStkNo').val("${orderCoForm.coOptionGiletWashableInfo.wgFrontBtnMateStkNo}");	
			 jQuery("#jacketBtnMateGlFlag").val("0");
		}
		
	}

	optionGiletChangeModel(productCategory);
// 	alert("${orderCoForm.coOptionGiletStandardInfo.ogStitchModifyPlace1}");
	
	optionColorReSave(productCategory);

	doubleOptionModelPrice();

	jQuery("#giletItemFlag").val("1");

})	

function setGiletModelDisable(productCategory){
	var glModel = null;
	
	if(productCategory == "9000101"){
		glModel = document.getElementById("giletModel");
	}else if(productCategory == "9000102"){
		glModel = document.getElementById("tg_giletModel");
	}else if(productCategory == "9000103"){
		glModel = document.getElementById("wg_giletModel");
	}

	var allGlOption = glModel.options;
	allGlOption[0].disabled = true;
	
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
	// 標準の場合　Gilet 背裏地素材と内側裏地素材と釦素材のid List
	var glStandardMateList = ["og_backLiningMate","og_insideLiningMate","og_frontBtnMate"];
	// タキシードの場合　Gilet 背裏地素材と内側裏地素材と釦素材のid List
	var glTuexdoMateList = ["tg_backLiningMate","tg_insideLiningMate","tg_frontBtnMate"];
	// ウォッシャブルの場合　Gilet 背裏地素材と内側裏地素材と釦素材のid List
	var glWashableMateList = ["wg_backLiningMate","wg_insideLiningMate","wg_frontBtnMate"];
	//var item = jQuery("#item option:selected").val();
	var item = jQuery("#item").val();
	category = jQuery('input[name="productCategory"]:checked').val();
	//SUITの場合　素材品番を設定
	if(item == "01"){
		itemCode = item;
		if(category == "9000101"){
			initSuitStandard(itemCode);
		}else if(category == "9000102"){
			initSuitTuexdo(itemCode);
		}else if(category == "9000103"){
			initSuitWashable(itemCode);
		}
	}else if(item=="04"){
		subItemCode = "04";
		itemCode = item;
		if(category=="9000101"){
			initGlStandard(itemCode,subItemCode);
		}else if(category=="9000102"){
			initGlTuexdo(itemCode,subItemCode);
		}else if(category=="9000103"){
			initGlWashable(itemCode,subItemCode);
		}
	}
	
	function initSuitStandard(itemCode){
		subItemCode = "04";
		initGlStandard(itemCode,subItemCode);
	}

	function initSuitTuexdo(itemCode){
		subItemCode = "04";
		initGlTuexdo(itemCode,subItemCode);
	}

	function initSuitWashable(itemCode){
		subItemCode = "04";
		initGlWashable(itemCode,subItemCode);
	}
			
	function initGlStandard(itemCode,subItemCode){
		for(var i in glStandardMateList){
			optionCode = selectIdList[glStandardMateList[i]];
			mateChecked = jQuery("#"+glStandardMateList[i]+" option:selected").val();
			StkNo = "#"+glStandardMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,0,orderPattern);
		}
		jQuery("#og_backLiningMate,#og_insideLiningMate,#og_frontBtnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			optionCode = selectIdList[idValue];
			mateChecked = jQuery("#"+idValue+" option:selected").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,0,orderPattern);
		})	
	}

	function initGlTuexdo(itemCode,subItemCode){
		for(var i in glTuexdoMateList){
			optionCode = selectIdList[glTuexdoMateList[i]];
			mateChecked = jQuery("#"+glTuexdoMateList[i]+" option:selected").val();
			StkNo = "#"+glTuexdoMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,2,orderPattern);
		}
		jQuery("#tg_backLiningMate,#tg_insideLiningMate,#tg_frontBtnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			optionCode = selectIdList[idValue];
			mateChecked = jQuery("#"+idValue+" option:selected").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,2,orderPattern);
		})	
	}

	function initGlWashable(itemCode,subItemCode){
		for(var i in glWashableMateList){
			optionCode = selectIdList[glWashableMateList[i]];
			mateChecked = jQuery("#"+glWashableMateList[i]+" option:selected").val();
			StkNo = "#"+glWashableMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,1,orderPattern);
		}
		jQuery("#wg_backLiningMate,#wg_insideLiningMate,#wg_frontBtnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			optionCode = selectIdList[idValue];
			mateChecked = jQuery("#"+idValue+" option:selected").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,1,orderPattern);
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
					 StkNoSelect.append(jQuery('<option />').val("").text(""));
					 StkNoSelect.prop("disabled",true);
				 }else{
					 StkNoSelect.removeAttr("disabled");
					 StkNoSelect.removeAttr("disabled");
					 for (var key in result) {
						 StkNoSelect.append(jQuery('<option />').val(key).text(result[key]));	
					 }
				 }
			 }
		});
	}
}

function getAllPrice(subItemCode, optionPrice){
	jQuery("#glOptionPriceId").val(optionPrice);
    var jkOptionPriceId = jQuery("#jkOptionPriceId").val();
    var ptOptionPriceId = jQuery("#ptOptionPriceId").val();
    var pt2OptionPriceId = jQuery("#pt2OptionPriceId").val();
    var glOptionPriceId = optionPrice;
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
    	allPrice = Number(glOptionPriceId);
    }
    jQuery("#optionPriceId").val(allPrice);
    jQuery("#optionPrice").html(formatMoney(allPrice,0,""));
}

function showPrice(){
	var giletModel = null;
	var category = jQuery('input[name="productCategory"]:checked').val();
	if(category == "9000101"){
		giletModel = jQuery("#giletModel");
	}else if(category == "9000102"){
		giletModel = jQuery("#tg_giletModel");
	}else if(category == "9000103"){
		giletModel = jQuery("#wg_giletModel");
	}
	if(isNotEmpty(giletModel.val())){
		giletModel.change();
	}
}

function doubleOptionModelPrice(){
	var modelDoublePrice = null;
	jQuery("#giletModel_Msg").empty();
	var productCategory = jQuery('input[name="productCategory"]:checked').val();

	if(productCategory == "9000101"){
		modelDoublePrice = jQuery("#giletModel");
	}else if(productCategory == "9000102"){
		modelDoublePrice = jQuery("#tg_giletModel");
	}else if(productCategory == "9000103"){
		modelDoublePrice = jQuery("#wg_giletModel");
	}

	var modelDoublePriceVal = modelDoublePrice.val();
	
	var productFabricNo = jQuery("#productFabricNo").val();
	var item = jQuery("#item").val();
	var subItem = "04";

	//生地チェクフラッグ
	var fabricCheckValue = jQuery("#fabricFlag").val();
	//fabricCheckValue[0]:0 or 1 or 2 
	//fabricCheckValue[1]:エラーメッセージ 
	fabricCheckValue = fabricCheckValue.split("*");
	//生地チェク成功の場合
	if((fabricCheckValue[0]=="0")&&isNotEmpty(productFabricNo)){
		jQuery.ajax({
			 type:"get",
			 url: contextPath + "/orderCo/findStockModelDoublePrice",
			 data:{"fabricNo":productFabricNo,"orderPattern":orderPattern,"doubleCheck":modelDoublePriceVal,"item":item,"subItem":subItem},
			 async:false,
			 success:function(result){
				if(isNotEmpty(result)){
					if(result.glDoublePrice == "0" || result.glDoublePrice == 0){
						jQuery("#glDoubleModelPrice").val(result.glDoublePrice);
						jQuery("#giletModel_Msg").html("無料");
						allOptionPrice();
					}else{
						jQuery("#glDoubleModelPrice").val(result.glDoublePrice);
						jQuery("#giletModel_Msg").html(formatMoney(result.glDoublePrice,0,"￥"));
						allOptionPrice();
					}
				}else{
					jQuery("#glDoubleModelPrice").val("0");
					jQuery("#giletModel_Msg").html("無料");
					allOptionPrice();
				}
		     }
		});
	}

	jQuery('#giletModel,#tg_giletModel,#wg_giletModel').change(function(){
		var modelDoublePrice = jQuery(this).val();
		//生地チェクフラッグ
		var fabricCheckValue = jQuery("#fabricFlag").val();
		//fabricCheckValue[0]:0 or 1 or 2 
		//fabricCheckValue[1]:エラーメッセージ 
		fabricCheckValue = fabricCheckValue.split("*");
		//生地チェク成功の場合
		if((fabricCheckValue[0]=="0")&&isNotEmpty(productFabricNo)){
			jQuery.ajax({
				 type:"get",
				 url: contextPath + "/orderCo/findStockModelDoublePrice",
				 data:{"fabricNo":productFabricNo,"orderPattern":orderPattern,"doubleCheck":modelDoublePrice,"item":item,"subItem":subItem},
				 async:false,
				 success:function(result){
					if(isNotEmpty(result)){
						if(result.glDoublePrice == "0" || result.glDoublePrice == 0){
							jQuery("#glDoubleModelPrice").val(result.glDoublePrice);
							jQuery("#giletModel_Msg").html("無料");
							allOptionPrice();
						}else{
							jQuery("#glDoubleModelPrice").val(result.glDoublePrice);
							jQuery("#giletModel_Msg").html(formatMoney(result.glDoublePrice,0,"￥"));
							allOptionPrice();
						}
					}else{
						jQuery("#glDoubleModelPrice").val("0");
						jQuery("#giletModel_Msg").html("無料");
						allOptionPrice();
					}
			     }
			});
		}
	})
	
}

//--------------------------------------------
//全部のitem金額制御
//--------------------------------------------
function getPrice(){
// 	GILETの料金を表示
	jQuery("#giletModel,#tg_giletModel,#wg_giletModel").change(function(){
		var productCategory = jQuery('input[name="productCategory"]:checked').val();
		var giletModel = "";
		var itemCode = jQuery("#item").val();
		var subItemCode = "04";
		var backBeltElem;

		var ajaxUrl = "";
		if(productCategory == "9000101"){
			giletModel = jQuery("#giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletStandardModel";
			backBeltElem = jQuery('#og_backBelt');
			
		}else if(productCategory == "9000102"){
			giletModel = jQuery("#tg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletTuxedoModel";
			backBeltElem = jQuery('#tg_backBelt');
			
		}else if(productCategory == "9000103"){
			giletModel = jQuery("#wg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletWashableModel";
			backBeltElem = jQuery('#wg_backBelt');
			
		}

		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').ghostsf_serialize(),type: "post",async:false});

		if(isEmpty(giletModel)){
			return;
		}

		var code = itemCode + subItemCode + giletModel;
		
		$.ajax({
			type:"get",
			url:contextPath + "/orderCo/" + ajaxUrl,
			data:{"code":code},
			dataType:"json",
			contentType:"application/json",
			async:false,
			success:function(result){
				var allPriceMap = result.priceMap;
				for (var priceMapKey in allPriceMap) {
					if(jQuery("#"+priceMapKey+"_Msg").length>0){
						jQuery("#"+priceMapKey+"_Msg").html(allPriceMap[priceMapKey]);
					}else{
						var msgIdValueName = priceMapKey.replace(/_id/g,"_Msg");
						jQuery("#"+msgIdValueName).html(allPriceMap[priceMapKey]);
					}
				}

				var selectedBackBelt = backBeltElem.val();
				if (selectedBackBelt == "" || selectedBackBelt == null) {
					backBeltElem.val("0002302");
					backBeltElem.change();
				}
				
// 				document.getElementById("nav2_GILET").click(); 
				getAllPrice(subItemCode, result.optionPrice);
			}
		});
		
	})
	
// 	プルダウンの変更処理
// 	項目：背裏地素材,背裏地品番,内側裏地素材,内側裏地品番,釦素材,釦品番,バックベルト
	jQuery("#og_backLiningMate,#og_backLiningMateStkNo,#og_insideLiningMate,#og_insideLiningMateStkNo,"+
			"#og_frontBtnMate,#og_frontBtnMateStkNo,#og_backBelt,"+
			"#tg_backLiningMate,#tg_backLiningMateStkNo,#tg_insideLiningMate,#tg_insideLiningMateStkNo,"+
			"#tg_frontBtnMate,#tg_frontBtnMateStkNo,#tg_backBelt,"+
			"#wg_backLiningMate,#wg_backLiningMateStkNo,#wg_insideLiningMate,#wg_insideLiningMateStkNo,"+
			"#wg_frontBtnMate,#wg_frontBtnMateStkNo,#wg_backBelt")
	.change(function(){
// 		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
	   
		var productCategory = jQuery('input[name="productCategory"]:checked').val();
		var giletModel = "";
		var itemCode = jQuery("#item").val();
		var subItemCode = "04";
		var idValueName = jQuery(this).attr("id");

		var ajaxUrl = "";
		if(productCategory == "9000101"){
			giletModel = jQuery("#giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletStandardProject";
		}else if(productCategory == "9000102"){
			giletModel = jQuery("#tg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletTuxedoProject";
		}else if(productCategory == "9000103"){
			giletModel = jQuery("#wg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletWashableProject";
		}

		var thisVal = "";
	    var thisValStkNo = "";
	    if(idValueName.indexOf("StkNo") == -1){
		    thisVal = jQuery("#" + idValueName).val();
		    thisValStkNo = jQuery("#" + idValueName + "StkNo").val();
	    }else{
		    thisValStkNo = jQuery("#" + idValueName).val();
		    idValueName = idValueName.replace("StkNo","");
		    thisVal = jQuery("#" + idValueName).val();
	    }

	    if(isNotEmpty(giletModel)){
			var code = itemCode + subItemCode + giletModel;
			jQuery.ajax({
				type:"get",
				url:contextPath + "/orderCo/" + ajaxUrl,
				data:{"code":code,"idValueName":idValueName,"thisVal":thisVal,"thisValStkNo":thisValStkNo},
				dataType:"json",
				contentType:"application/json",
				async:false,
				success:function(result){
					if(jQuery("#"+idValueName+"_Msg").length>0){
						jQuery("#"+idValueName+"_Msg").html(result.idValuePrice);
					}else{
						var lengthforLastFive = idValueName.length - 5;
						var idValueTemp = idValueName.substring(0,lengthforLastFive);
						jQuery("#"+idValueTemp+"_Msg").html(result.idValuePrice);
					}
					getAllPrice(subItemCode, result.optionPrice);
					allOptionPrice();
				}
			});
		}

	});
	
// 	ラジオボタンの変更処理
// 	項目：胸ポケット、腰ポケット形状、ウォッチチェーン、腰ポケット素材
	jQuery('input[id^="og_breastPkt_id"],[id^="og_waistPktSpec_id"],[id^="og_watchChain_id"],'+
			'[id^="tg_breastPkt_id"],[id^="tg_waistPktSpec_id"],[id^="tg_waistPktMate_id"],[id^="tg_watchChain_id"],'+
			'[id^="wg_breastPkt_id"],[id^="wg_waistPktSpec_id"],[id^="wg_watchChain_id"]')
	.change(function(){
// 		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});

		var productCategory = jQuery('input[name="productCategory"]:checked').val();
		var giletModel = "";
		var itemCode = jQuery("#item").val();
		var subItemCode = "04";
		var idValueName = jQuery(this).attr("id");
		var thisValueTemp = jQuery(this).val();

		var ajaxUrl = "";
		if(productCategory == "9000101"){
			giletModel = jQuery("#giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletStandardProject";
		}else if(productCategory == "9000102"){
			giletModel = jQuery("#tg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletTuxedoProject";
		}else if(productCategory == "9000103"){
			giletModel = jQuery("#wg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletWashableProject";
		}
		
		var jspOptionCodeAndBranchCode = "";
		if(idValueName.indexOf("_breastPkt_id") != -1){
			//胸ポケット
			jspOptionCodeAndBranchCode = "00001" + thisValueTemp;
		}else if(idValueName.indexOf("_waistPktSpec_id") != -1){
			//腰ポケット形状
			jspOptionCodeAndBranchCode = "00003" + thisValueTemp;
		}else if(idValueName.indexOf("_watchChain_id") != -1){
			//ウォッチチェーン
			jspOptionCodeAndBranchCode = "00024" + thisValueTemp;
		}else if(idValueName.indexOf("_waistPktMate_id") != -1){
			//腰ポケット素材
			jspOptionCodeAndBranchCode = "00004" + thisValueTemp;
		}

		//IDの後の番号を削除します
		var findIdPosition = idValueName.indexOf("_id");
		var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
		 
		if(isNotEmpty(giletModel)){
			var code = itemCode + subItemCode + giletModel;
			jQuery.ajax({
				type:"get",
				url:contextPath + "/orderCo/" + ajaxUrl,
				data:{"code":code,"idValueName":interceptedIdValueName,"jspOptionCodeAndBranchCode":jspOptionCodeAndBranchCode},
				dataType:"json",
				contentType:"application/json",
				async:false,
				success:function(result){
					var msgIdValueName = interceptedIdValueName.replace(/_id/g,"_Msg");
					jQuery("#"+msgIdValueName).html(result.idValuePrice);
					getAllPrice(subItemCode, result.optionPrice);
				}
			});
		}
	});

// 	ラジオボタンの変更処理
// 	項目：腰ポケット
	jQuery('input[id^="og_waistPkt_id"],[id^="tg_waistPkt_id"],[id^="wg_waistPkt_id"]')
	.change(function(){
// 		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});

		var productCategory = jQuery('input[name="productCategory"]:checked').val();
		var giletModel = "";
		var itemCode = jQuery("#item").val();
		var subItemCode = "04";
		var idValueName = jQuery(this).attr("id");
		var thisValueTemp = jQuery(this).val();

		var waistPktValue = "";
		var ajaxUrl = "";
		if(productCategory == "9000101"){
			giletModel = jQuery("#giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletStandardProject";
			
			waistPktValue = jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]:checked').val();
			if (waistPktValue == "0000201") {
				//腰ポケットは有りです
				//腰ポケット形状の設定
				jQuery('input[name="coOptionGiletStandardInfo.ogWaistPktSpec"]').val([giletModelDefaultList[giletModel]["og_waistPktSpec"]]);
				jQuery('input[name="coOptionGiletStandardInfo.ogWaistPktSpec"]:checked').change();
			}else if (waistPktValue == "0000202") {
				//腰ポケットは無しです
				//腰ポケット形状の設定
				for(var i=0; i<jQuery('input[name="coOptionGiletStandardInfo.ogWaistPktSpec"]').length; i++){
					jQuery('input[name="coOptionGiletStandardInfo.ogWaistPktSpec"]').get(i).checked = false;
				}
			}
			
		}else if(productCategory == "9000102"){
			giletModel = jQuery("#tg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletTuxedoProject";

			waistPktValue = jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPkt"]:checked').val();
			if (waistPktValue == "0000201") {
				//腰ポケットは有りです
				//腰ポケット形状の設定
				jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPktSpec"]').val([giletModelDefaultList[giletModel]["tg_waistPktSpec"]]);
				jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPktSpec"]:checked').change();
				//腰ポケット素材の設定
				jQuery('#tg_waistPktMate_id1').prop("checked", true);
				jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPktMate"]:checked').change();
			}else if (waistPktValue == "0000202") {
				//腰ポケットは無しです
				//腰ポケット形状の設定
				for(var i=0; i<jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPktSpec"]').length; i++){
					jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPktSpec"]').get(i).checked = false;
				}
				//腰ポケット素材の設定
				for(var i=0; i<jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPktMate"]').length; i++){
					jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPktMate"]').get(i).checked = false;
				}
			}
			
		}else if(productCategory == "9000103"){
			giletModel = jQuery("#wg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletWashableProject";
			
			waistPktValue = jQuery('input[name="coOptionGiletWashableInfo.wgWaistPkt"]:checked').val();
			if (waistPktValue == "0000201") {
				//腰ポケットは有りです
				//腰ポケット形状の設定
				jQuery('input[name="coOptionGiletWashableInfo.wgWaistPktSpec"]').val([giletModelDefaultList[giletModel]["wg_waistPktSpec"]]);
				jQuery('input[name="coOptionGiletWashableInfo.wgWaistPktSpec"]:checked').change();
			}else if (waistPktValue == "0000202") {
				//腰ポケットは無しです
				//腰ポケット形状の設定
				for(var i=0; i<jQuery('input[name="coOptionGiletWashableInfo.wgWaistPktSpec"]').length; i++){
					jQuery('input[name="coOptionGiletWashableInfo.wgWaistPktSpec"]').get(i).checked = false;
				}
			}
		}

		var jspOptionCodeAndBranchCode = "";
		if(idValueName.indexOf("_waistPkt_id") != -1){
			//胸ポケット
			jspOptionCodeAndBranchCode = "00002" + thisValueTemp;
		}

		//IDの後の番号を削除します
		var findIdPosition = idValueName.indexOf("_id");
		var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
		 
		if(isNotEmpty(giletModel)){
			var code = itemCode + subItemCode + giletModel;
			jQuery.ajax({
				type:"get",
				url:contextPath + "/orderCo/" + ajaxUrl,
				data:{"code":code,"idValueName":interceptedIdValueName,"jspOptionCodeAndBranchCode":jspOptionCodeAndBranchCode},
				dataType:"json",
				contentType:"application/json",
				async:false,
				success:function(result){
					var msgIdValueName = interceptedIdValueName.replace(/_id/g,"_Msg");
					jQuery("#"+msgIdValueName).html(result.idValuePrice);
					getAllPrice(subItemCode, result.optionPrice);
				}
			});
		}
	});
	
	// 	ラジオボタンの変更処理
// 	項目：ステッチ種類
	jQuery('input[id^="og_stitch_id"],[id^="wg_stitch_id"],[id^="tg_stitch_id"]')
	.change(function(){
// 		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});

		var productCategory = jQuery('input[name="productCategory"]:checked').val();
		var giletModel = "";
		var itemCode = jQuery("#item").val();
		var subItemCode = "04";
		var idValueName = jQuery(this).attr("id");
		var thisValueTemp = jQuery(this).val();

		var ajaxUrl = "";
		if(productCategory == "9000101"){
			giletModel = jQuery("#giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletStandardProject";

			if(thisValueTemp == "0000503"){
				//ステッチ種類は無しです
				jQuery('#og_stitchModify_id1').prop("checked", true);
				jQuery('#og_stitchModify_id1').prop("disabled", true);
				jQuery('#og_stitchModify_id2').prop("checked", false);
				jQuery('#og_stitchModify_id2').prop("disabled", true);
				jQuery('input[name="coOptionGiletStandardInfo.ogStitchModify"]:checked').change();
			}else if(thisValueTemp == "0000504"){
				//ステッチ種類はAMFステッチです
				jQuery('#og_stitchModify_id1').prop("disabled", false);
				jQuery('#og_stitchModify_id2').prop("disabled", false);
				jQuery('#og_dStitchModify_id2').prop("disabled", false);
			}else if(thisValueTemp != "0000503" && thisValueTemp != "0000504"){
				//ステッチ種類はその他です
				jQuery('#og_stitchModify_id1').prop("disabled", false);
				jQuery('#og_stitchModify_id2').prop("disabled", false);
				jQuery('#og_dStitchModify_id1').prop("checked", true);
				jQuery('#og_dStitchModify_id2').prop("checked", false);
				jQuery('#og_dStitchModify_id2').prop("disabled", true);
				jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]:checked').change();
			}
			
		}else if(productCategory == "9000102"){
			giletModel = jQuery("#tg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletTuxedoProject";
			
		}else if(productCategory == "9000103"){
			giletModel = jQuery("#wg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletWashableProject";

			if(thisValueTemp == "0000503"){
				//ステッチ種類は無しです
				jQuery('#wg_stitchModify_id1').prop("checked", true);
				jQuery('#wg_stitchModify_id1').prop("disabled", true);
				jQuery('#wg_stitchModify_id2').prop("checked", false);
				jQuery('#wg_stitchModify_id2').prop("disabled", true);
				jQuery('input[name="coOptionGiletWashableInfo.wgStitchModify"]:checked').change();
			}else if(thisValueTemp == "0000504"){
				//ステッチ種類はAMFステッチです
				jQuery('#wg_stitchModify_id1').prop("disabled", false);
				jQuery('#wg_stitchModify_id2').prop("disabled", false);
				jQuery('#wg_dStitchModify_id2').prop("disabled", false);
			}else if(thisValueTemp != "0000503" && thisValueTemp != "0000504"){
				//ステッチ種類はその他です
				jQuery('#wg_stitchModify_id1').prop("disabled", false);
				jQuery('#wg_stitchModify_id2').prop("disabled", false);
				jQuery('#wg_dStitchModify_id1').prop("checked", true);
				jQuery('#wg_dStitchModify_id2').prop("checked", false);
				jQuery('#wg_dStitchModify_id2').prop("disabled", true);
				jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]:checked').change();
			}
			
		}

		var jspOptionCodeAndBranchCode = "";
		if(idValueName.indexOf("_stitch_id") != -1){
			//ステッチ種類
			jspOptionCodeAndBranchCode = "00005" + thisValueTemp;
		}

		//IDの後の番号を削除します
		var findIdPosition = idValueName.indexOf("_id");
		var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
		
		if(isNotEmpty(giletModel)){
			var code = itemCode + subItemCode + giletModel;
			jQuery.ajax({
				type:"get",
				url:contextPath + "/orderCo/" + ajaxUrl,
				data:{"code":code,"idValueName":interceptedIdValueName,"jspOptionCodeAndBranchCode":jspOptionCodeAndBranchCode},
				dataType:"json",
				contentType:"application/json;charsetset=UTF-8",
				async:false,
				success:function(result){
					var msgIdValueName = interceptedIdValueName.replace(/_id/g,"_Msg");
					jQuery("#"+msgIdValueName).html(result.idValuePrice);
					getAllPrice(subItemCode, result.optionPrice);
				}
			});
		}
		
	});
	
// 	ラジオボタンの変更処理
// 	項目：ステッチ箇所変更,ダブルステッチ
	jQuery('input[id^="og_stitchModify_id"],[id^="og_stitchModifyPlace_id"],[id^="og_dStitchModify_id"],'+
			'[id^="og_dStitchModifyPlace_id"],'+
			'[id^="wg_stitchModify_id"],[id^="wg_stitchModifyPlace_id"],[id^="wg_dStitchModify_id"],'+
			'[id^="wg_dStitchModifyPlace_id"]')
	.change(function(){
// 		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});

		var productCategory = jQuery('input[name="productCategory"]:checked').val();
		var giletModel = "";
		var itemCode = jQuery("#item").val();
		var subItemCode = "04";
		var idValueName = jQuery(this).attr("id");
		var thisValueTemp = jQuery(this).val();

		var ajaxUrl = "";
		if(productCategory == "9000101"){
			giletModel = jQuery("#giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletStandardProject";

			if(thisValueTemp == "0000601"){
				//ステッチ箇所変更は無しです
				var i = 1;
				jQuery('input[id^="og_stitchModifyPlace_id"]').each(function() {
					jQuery('#og_stitchModifyPlace_id' + i).removeAttr("checked");
					i++;
				});
				jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]:checked').change();
				jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor"]:checked').change();
			}else if(thisValueTemp == "0000602"){
				//ステッチ箇所変更は有りです
				//ラペル・フロントと腰ポケット、デフォルト選択
				if(isNotEmpty(giletModel)){
					for(var i=0; i<ogStitchModifyList[giletModel].length; i++){
						var j = 1;
						jQuery('input[id^="og_stitchModifyPlace_id"]').each(function() {
							if(jQuery('#og_stitchModifyPlace_id' + j).val() == ogStitchModifyList[giletModel][i]){
								jQuery('#og_stitchModifyPlace_id' + j).prop("checked", true);
							}
							j++;
						});
					}
					jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModify"]:checked').change();
					jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor"]:checked').change();
				}
			}
			if(thisValueTemp == "0002601"){
				//ダブルステッチは無しです
				var i = 1;
				jQuery('input[id^="og_dStitchModifyPlace_id"]').each(function() {
					jQuery('#og_dStitchModifyPlace_id' + i).removeAttr("checked");
					i++;
				});
			}else if(thisValueTemp == "0002602"){
				//ダブルステッチは有りです
				var ogStitchModifyValue = jQuery('input[name="coOptionGiletStandardInfo.ogStitchModify"]:checked').val();
				if(ogStitchModifyValue == "0000601"){
					//ステッチ箇所変更は無しです
					if(isNotEmpty(giletModel)){
						for(var i=0; i<ogDStitchModifyList[giletModel].length; i++){
							var j = 1;
							jQuery('input[id^="og_dStitchModifyPlace_id"]').each(function() {
								if(jQuery('#og_dStitchModifyPlace_id' + j).val() == ogDStitchModifyList[giletModel][i]){
									jQuery('#og_dStitchModifyPlace_id' + j).prop("checked", true);
									jQuery('#og_dStitchModifyPlace_id' + j).prop("disabled", false);
								}
								j++;
							});
						}
					}
				}
			}
			
		}else if(productCategory == "9000103"){
			giletModel = jQuery("#wg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletWashableProject";

			if(thisValueTemp == "0000601"){
				//ステッチ箇所変更は無しです
				var i = 1;
				jQuery('input[id^="wg_stitchModifyPlace_id"]').each(function() {
					jQuery('#wg_stitchModifyPlace_id' + i).removeAttr("checked");
					i++;
				});
				jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]:checked').change();
				jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor"]:checked').change();
			}else if(thisValueTemp == "0000602"){
				//ステッチ箇所変更は有りです
				//ラペル・フロントと腰ポケット、デフォルト選択
				if(isNotEmpty(giletModel)){
					for(var i=0; i<ogStitchModifyList[giletModel].length; i++){
						var j = 1;
						jQuery('input[id^="wg_stitchModifyPlace_id"]').each(function() {
							if(jQuery('#wg_stitchModifyPlace_id' + j).val() == ogStitchModifyList[giletModel][i]){
								jQuery('#wg_stitchModifyPlace_id' + j).prop("checked", true);
							}
							j++;
						});
					}
					jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModify"]:checked').change();
					jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor"]:checked').change();
				}
			}
			if(thisValueTemp == "0002601"){
				//ダブルステッチは無しです
				var i = 1;
				jQuery('input[id^="wg_dStitchModifyPlace_id"]').each(function() {
					jQuery('#wg_dStitchModifyPlace_id' + i).removeAttr("checked");
					i++;
				});
			}else if(thisValueTemp == "0002602"){
				//ダブルステッチは有りです
				var wgStitchModifyValue = jQuery('input[name="coOptionGiletWashableInfo.wgStitchModify"]:checked').val();
				if(wgStitchModifyValue == "0000601"){
					//ステッチ箇所変更は無しです
					if(isNotEmpty(giletModel)){
						for(var i=0; i<ogDStitchModifyList[giletModel].length; i++){
							var j = 1;
							jQuery('input[id^="wg_dStitchModifyPlace_id"]').each(function() {
								if(jQuery('#wg_dStitchModifyPlace_id' + j).val() == ogDStitchModifyList[giletModel][i]){
									jQuery('#wg_dStitchModifyPlace_id' + j).prop("checked", true);
									jQuery('#wg_dStitchModifyPlace_id' + j).prop("disabled", false);
								}
								j++;
							});
						}
					}
				}
			}
			
		}

		//複数選択ボックスの数,IDにより決定optionCode
		var ogSomePlace_length = 0;
		var jspOptionCodeUp = "";
		var jspOptionCode = "";
		if(idValueName.indexOf("og_stitchModify") >= 0){
			jspOptionCodeUp ="00006";
			jspOptionCode ="00007";
			ogSomePlace_length = jQuery('input[id^="og_stitchModifyPlace_id"]').length;

		}else if(idValueName.indexOf("og_dStitchModify") >= 0){
			jspOptionCodeUp ="00026";
			jspOptionCode ="00027";
			ogSomePlace_length = jQuery('input[id^="og_dStitchModifyPlace_id"]').length;
			
		}else if(idValueName.indexOf("wg_stitchModify") >= 0){
			jspOptionCodeUp ="00006";
			jspOptionCode ="00007";
			ogSomePlace_length = jQuery('input[id^="wg_stitchModifyPlace_id"]').length;
			
		}else if(idValueName.indexOf("wg_dStitchModify") >= 0){
			jspOptionCodeUp ="00026";
			jspOptionCode ="00027";
			ogSomePlace_length = jQuery('input[id^="wg_dStitchModifyPlace_id"]').length;

		}

		//チェックボックスのvalueを保存します
		var countArr = "";
		
		//アイテムのID名をクリックして、"Place_id"フィールドを含めます
		var findIdPosition = idValueName.indexOf("Place_id");
		//IDの後の番号を削除します
		var interceptedIdValueName = "";
		var idValueNameTemp;
		if(findIdPosition != -1){
			//インターセプトID、最初の数字からPlace_idの前まで
			idValueNameTemp = idValueName.substring(0,findIdPosition);
			interceptedIdValueName = idValueNameTemp + "_id";
		}else{
			//インターセプトID、最初の数字から_idの前まで
			var findIdPositionNotPlace = idValueName.indexOf("_id");
			idValueNameTemp = idValueName.substring(0,findIdPositionNotPlace);
			interceptedIdValueName = idValueNameTemp + "_id";
		}
		
		//チェックボックスループ
		for(var i=1; i<=ogSomePlace_length; i++){
			//各チェックボックスのIDをループスプライシング
			//このループの要素を取得します
			var idValueNameComplete = document.getElementById(idValueNameTemp + "Place_id" + i);
			if(idValueNameComplete.checked){
				countArr = countArr + jspOptionCode + idValueNameComplete.value + "/";
			}
		}
		if(findIdPosition == -1){
			countArr = countArr + jspOptionCodeUp + thisValueTemp + "/";
		}
		
		if(isNotEmpty(giletModel)){
			var code = itemCode + subItemCode + giletModel;
			jQuery.ajax({
				type:"get",
				url:contextPath + "/orderCo/" + ajaxUrl,
				data:{"code":code,"idValueName":interceptedIdValueName,"countArr":countArr},
				dataType:"json",
				contentType:"application/json;charsetset=UTF-8",
				async:false,
				success:function(result){
					var msgIdValueName = interceptedIdValueName.replace(/_id/g,"_Msg");
					jQuery("#"+msgIdValueName).html(result.idValuePrice);
					getAllPrice(subItemCode, result.optionPrice);
				}
			});
		}
		
	});

// 	ラジオボタンの変更処理
// 	項目：AMF色指定、ボタンホール色指定、ボタン付け糸指定
	jQuery('input[id^="og_amfColor_"],[id^="og_bhColor_"],[id^="og_byColor_"],'+
			'[id^="tg_bhColor_"],[id^="tg_byColor_"],'+
			'[id^="wg_amfColor_"],[id^="wg_bhColor_"],[id^="wg_byColor_"]').change(function(){
// 		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});

		var productCategory = jQuery('input[name="productCategory"]:checked').val();
		var giletModel = "";
		var itemCode = jQuery("#item").val();
		var subItemCode = "04";
		var idValueName = jQuery(this).attr("id");
		var thisValueTemp = jQuery(this).val();

		var ajaxUrl = "";
		if(productCategory == "9000101"){
			giletModel = jQuery("#giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletStandardProject";

			if(thisValueTemp == "0000801"){
				//AMF色指定は無しです
				var i = 1;
				jQuery('input[id^="og_amfColorPlace_"]').each(function() {
					var valueNameAll = "coOptionGiletStandardInfo.ogAmfColor" + i;
					var valueNameOne = document.getElementsByName(valueNameAll);
					var $valueNameOneJq = $(valueNameOne);
					for(var j=0; j<valueNameOne.length; j++){
						jQuery($valueNameOneJq).get(j).checked = false;
					}
					i++;
				});
			}else if(thisValueTemp == "0000802"){
				//AMF色指定は有りです
				var ogStitchModifyValue = jQuery('input[name="coOptionGiletStandardInfo.ogStitchModify"]:checked').val();
				if(ogStitchModifyValue == "0000601"){
					//ステッチ箇所変更は無しです
					if(isNotEmpty(giletModel)){
						var amfColorPlaceLength = jQuery('input[id^="og_amfColorPlace_"]').length;
						for(var i=1; i<=amfColorPlaceLength; i++){
							jQuery('#og_amfColorPlace_' + i).prop("disabled", true);
						}
						for(var i=0; i<ogAmfColorList[giletModel].length; i++){
							var j = 1;
							jQuery('input[id^="og_amfColorPlace_"]').each(function() {
								if(jQuery('#og_amfColorPlace_' + j).val() == ogAmfColorList[giletModel][i]){
									jQuery('#og_amfColorPlace_' + j).prop("disabled", false);
								}
								j++;
							});
						}
					}
				}
			}
			if(thisValueTemp == "0001101"){
				//ボタンホール色指定は無しです
				var i = 1;
				jQuery('input[id^="og_bhColorPlace_"]').each(function() {
					var valueNameAll = "coOptionGiletStandardInfo.ogBhColor" + i;
					var valueNameOne = document.getElementsByName(valueNameAll);
					var $valueNameOneJq = $(valueNameOne);
					for(var j=0; j<valueNameOne.length; j++){
						jQuery($valueNameOneJq).get(j).checked = false;
					}
					i++;
				});
			}
			if(thisValueTemp == "0001401"){
				//ボタン付け糸指定は無しです
				var i = 1;
				jQuery('input[id^="og_byColorPlace_"]').each(function() {
					var valueNameAll = "coOptionGiletStandardInfo.ogByColor" + i;
					var valueNameOne = document.getElementsByName(valueNameAll);
					var $valueNameOneJq = $(valueNameOne);
					for(var j=0; j<valueNameOne.length; j++){
						jQuery($valueNameOneJq).get(j).checked = false;
					}
					i++;
				});
			}
			
		}else if(productCategory == "9000102"){
			giletModel = jQuery("#tg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletTuxedoProject";

			if(thisValueTemp == "0001101"){
				//ボタンホール色指定は無しです
				var i = 1;
				jQuery('input[id^="tg_bhColorPlace_"]').each(function() {
					var valueNameAll = "coOptionGiletTuxedoInfo.tgBhColor" + i;
					var valueNameOne = document.getElementsByName(valueNameAll);
					var $valueNameOneJq = $(valueNameOne);
					for(var j=0; j<valueNameOne.length; j++){
						jQuery($valueNameOneJq).get(j).checked = false;
					}
					i++;
				});
			}
			if(thisValueTemp == "0001401"){
				//ボタン付け糸指定は無しです
				var i = 1;
				jQuery('input[id^="tg_byColorPlace_"]').each(function() {
					var valueNameAll = "coOptionGiletTuxedoInfo.tgByColor" + i;
					var valueNameOne = document.getElementsByName(valueNameAll);
					var $valueNameOneJq = $(valueNameOne);
					for(var j=0; j<valueNameOne.length; j++){
						jQuery($valueNameOneJq).get(j).checked = false;
					}
					i++;
				});
			}
			
		}else if(productCategory == "9000103"){
			giletModel = jQuery("#wg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletWashableProject";

			if(thisValueTemp == "0000801"){
				//AMF色指定は無しです
				var i = 1;
				jQuery('input[id^="wg_amfColorPlace_"]').each(function() {
					var valueNameAll = "coOptionGiletWashableInfo.wgAmfColor" + i;
					var valueNameOne = document.getElementsByName(valueNameAll);
					var $valueNameOneJq = $(valueNameOne);
					for(var j=0; j<valueNameOne.length; j++){
						jQuery($valueNameOneJq).get(j).checked = false;
					}
					i++;
				});
			}else if(thisValueTemp == "0000802"){
				//AMF色指定は有りです
				var wgStitchModifyValue = jQuery('input[name="coOptionGiletWashableInfo.wgStitchModify"]:checked').val();
				if(wgStitchModifyValue == "0000601"){
					//ステッチ箇所変更は無しです
					if(isNotEmpty(giletModel)){
						var amfColorPlaceLength = jQuery('input[id^="og_amfColorPlace_"]').length;
						for(var i=1; i<=amfColorPlaceLength; i++){
							jQuery('#og_amfColorPlace_' + i).prop("disabled", true);
						}
						for(var i=0; i<ogAmfColorList[giletModel].length; i++){
							var j = 1;
							jQuery('input[id^="wg_amfColorPlace_"]').each(function() {
								if(jQuery('#wg_amfColorPlace_' + j).val() == ogAmfColorList[giletModel][i]){
									jQuery('#wg_amfColorPlace_' + j).prop("disabled", false);
								}
								j++;
							});
						}
					}
				}
			}
			if(thisValueTemp == "0001101"){
				//ボタンホール色指定は無しです
				var i = 1;
				jQuery('input[id^="wg_bhColorPlace_"]').each(function() {
					var valueNameAll = "coOptionGiletWashableInfo.wgBhColor" + i;
					var valueNameOne = document.getElementsByName(valueNameAll);
					var $valueNameOneJq = $(valueNameOne);
					for(var j=0; j<valueNameOne.length; j++){
						jQuery($valueNameOneJq).get(j).checked = false;
					}
					i++;
				});
			}
			if(thisValueTemp == "0001401"){
				//ボタン付け糸指定は無しです
				var i = 1;
				jQuery('input[id^="wg_byColorPlace_"]').each(function() {
					var valueNameAll = "coOptionGiletWashableInfo.wgByColor" + i;
					var valueNameOne = document.getElementsByName(valueNameAll);
					var $valueNameOneJq = $(valueNameOne);
					for(var j=0; j<valueNameOne.length; j++){
						jQuery($valueNameOneJq).get(j).checked = false;
					}
					i++;
				});
			}
			
		}

		//IDの後の番号を削除します
		var interceptedIdValueName = "";
		
		//複数選択ボックスの数,IDにより決定optionCode
		var ogSomePlace_length = 0;
		var jspOptionCodeAndBranchCode = "";
		if(idValueName.indexOf("og_amfColor_") >= 0){
			jspOptionCodeAndBranchCode ="00010" + thisValueTemp;
			ogSomePlace_length = jQuery('input[id^="og_amfColorPlace_"]').length;

		}else if(idValueName.indexOf("og_bhColor_") >= 0){
			jspOptionCodeAndBranchCode ="00013" + thisValueTemp;
			ogSomePlace_length = jQuery('input[id^="og_bhColorPlace_"]').length;
			
		}else if(idValueName.indexOf("og_byColor_") >= 0){
			jspOptionCodeAndBranchCode ="00016" + thisValueTemp;
			ogSomePlace_length = jQuery('input[id^="og_byColorPlace_"]').length;
			
		}else if(idValueName.indexOf("tg_bhColor_") >= 0){
			jspOptionCodeAndBranchCode ="00013" + thisValueTemp;
			ogSomePlace_length = jQuery('input[id^="tg_bhColorPlace_"]').length;
			
		}else if(idValueName.indexOf("tg_byColor_") >= 0){
			jspOptionCodeAndBranchCode ="00016" + thisValueTemp;
			ogSomePlace_length = jQuery('input[id^="tg_byColorPlace_"]').length;
			
		}else if(idValueName.indexOf("wg_amfColor_") >= 0){
			jspOptionCodeAndBranchCode ="00010" + thisValueTemp;
			ogSomePlace_length = jQuery('input[id^="wg_amfColorPlace_"]').length;
			
		}else if(idValueName.indexOf("wg_bhColor_") >= 0){
			jspOptionCodeAndBranchCode ="00013" + thisValueTemp;
			ogSomePlace_length = jQuery('input[id^="wg_bhColorPlace_"]').length;
			
		}else if(idValueName.indexOf("wg_byColor_") >= 0){
			jspOptionCodeAndBranchCode ="00016" + thisValueTemp;
			ogSomePlace_length = jQuery('input[id^="wg_byColorPlace_"]').length;
			
		}
		//選択した異なる色のvalueを保存する
		var countArr = new Array();
		var colorCount = 0;
		
		//アイテムのID名をクリックして、"ID"フィールドを含めます
		var findIdPosition = idValueName.indexOf("_id");
		if(findIdPosition == -1){
			interceptedIdValueName = idValueName.replace(new RegExp(thisValueTemp,"g"),"id");
			//ラジオの色を変更する
			//チェックボックスループ
			for(var i=1; i<=ogSomePlace_length; i++){
				//各チェックボックスのIDをループスプライシング
				//選択したチェックボックスの数を取得する
				var idValueNameAll = "";
				if(idValueName.indexOf("og_amfColor_") >= 0){
					idValueNameAll = "coOptionGiletStandardInfo.ogAmfColor" + i;
				}else if(idValueName.indexOf("og_bhColor_") >= 0){
					idValueNameAll = "coOptionGiletStandardInfo.ogBhColor" + i;
				}else if(idValueName.indexOf("og_byColor_") >= 0){
					idValueNameAll = "coOptionGiletStandardInfo.ogByColor" + i;
				}else if(idValueName.indexOf("tg_bhColor_") >= 0){
					idValueNameAll = "coOptionGiletTuxedoInfo.tgBhColor" + i;
				}else if(idValueName.indexOf("tg_byColor_") >= 0){
					idValueNameAll = "coOptionGiletTuxedoInfo.tgByColor" + i;
				}else if(idValueName.indexOf("wg_amfColor_") >= 0){
					idValueNameAll = "coOptionGiletWashableInfo.wgAmfColor" + i;
				}else if(idValueName.indexOf("wg_bhColor_") >= 0){
					idValueNameAll = "coOptionGiletWashableInfo.wgBhColor" + i;
				}else if(idValueName.indexOf("wg_byColor_") >= 0){
					idValueNameAll = "coOptionGiletWashableInfo.wgByColor" + i;
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
			if(idValueName.indexOf("amfColor_") >= 0){
				jspOptionCodeAndBranchCode ="00008" + thisValueTemp;
			}else if(idValueName.indexOf("bhColor_") >= 0){
				jspOptionCodeAndBranchCode ="00011" + thisValueTemp;
			}else if(idValueName.indexOf("byColor_") >= 0){
				jspOptionCodeAndBranchCode ="00014" + thisValueTemp;
			}
			interceptedIdValueName = idValueName.substring(0, findIdPosition+3);
			colorCount = -1;
		}
		
		var desiredItemFlag = false;
		if(interceptedIdValueName == "og_amfColor_id" || interceptedIdValueName == "og_bhColor_id" || interceptedIdValueName == "og_byColor_id" 
				|| interceptedIdValueName == "tg_bhColor_id" || interceptedIdValueName == "tg_byColor_id" 
				|| interceptedIdValueName == "wg_amfColor_id" || interceptedIdValueName == "wg_bhColor_id" || interceptedIdValueName == "wg_byColor_id"){
			desiredItemFlag = true;
		}

		if(isNotEmpty(giletModel) && desiredItemFlag == true){
			var code = itemCode + subItemCode + giletModel;
			jQuery.ajax({
				type:"get",
				url:contextPath + "/orderCo/" + ajaxUrl,
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
		}
		
	});

// 	項目：AMF色指定、ボタンホール色指定、ボタン付け糸指定の全選択、全解除
	jQuery('[id^="btn_as_og_amfColorPlace"],[id^="btn_ar_og_amfColorPlace"],'+
			'[id^="btn_as_og_bhColorPlace"],[id^="btn_ar_og_bhColorPlace"],'+
			'[id^="btn_as_og_byColorPlace"],[id^="btn_ar_og_byColorPlace"],'+
			'[id^="btn_as_tg_bhColorPlace"],[id^="btn_ar_tg_bhColorPlace"],'+
			'[id^="btn_as_tg_byColorPlace"],[id^="btn_ar_tg_byColorPlace"],'+
			'[id^="btn_as_wg_amfColorPlace"],[id^="btn_ar_wg_amfColorPlace"],'+
			'[id^="btn_as_wg_bhColorPlace"],[id^="btn_ar_wg_bhColorPlace"],'+
			'[id^="btn_as_wg_byColorPlace"],[id^="btn_ar_wg_byColorPlace"]').click(function(){
// 		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});

		var productCategory = jQuery('input[name="productCategory"]:checked').val();
		var giletModel = "";
		var itemCode = jQuery("#item").val();
		var subItemCode = "04";
		var idValueName = jQuery(this).attr("id");
		var idValueNameTemp = "";
		var thisValueTemp = "";

		var findIdAmf = idValueName.indexOf("_amfColorPlace");
		var findIdBh = idValueName.indexOf("_bhColorPlace");
		var findIdBy = idValueName.indexOf("_byColorPlace");
		
		var ajaxUrl = "";
		if(productCategory == "9000101"){
			giletModel = jQuery("#giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletStandardProject";

			if(findIdAmf != -1){
				idValueNameTemp = "og_amfColor_id";
				thisValueTemp = "00010" + jQuery("#og_amfColorPlaceAll").val();
			}else if(findIdBh != -1){
				idValueNameTemp = "og_bhColor_id";
				thisValueTemp = "00013" + jQuery("#og_bhColorPlaceAll").val();
			}else if(findIdBy != -1){
				idValueNameTemp = "og_byColor_id";
				thisValueTemp = "00016" + jQuery("#og_byColorPlaceAll").val();
			}
			
		}else if(productCategory == "9000102"){
			giletModel = jQuery("#tg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletTuxedoProject";

			if(findIdBh != -1){
				idValueNameTemp = "tg_bhColor_id";
				thisValueTemp = "00013" + jQuery("#tg_bhColorPlaceAll").val();
			}else if(findIdBy != -1){
				idValueNameTemp = "tg_byColor_id";
				thisValueTemp = "00016" + jQuery("#tg_byColorPlaceAll").val();
			}
			
		}else if(productCategory == "9000103"){
			giletModel = jQuery("#wg_giletModel option:selected").val();
			ajaxUrl = "getOrderPriceForGiletWashableProject";

			if(findIdAmf != -1){
				idValueNameTemp = "wg_amfColor_id";
				thisValueTemp = "00010" + jQuery("#wg_amfColorPlaceAll").val();
			}else if(findIdBh != -1){
				idValueNameTemp = "wg_bhColor_id";
				thisValueTemp = "00013" + jQuery("#wg_bhColorPlaceAll").val();
			}else if(findIdBy != -1){
				idValueNameTemp = "wg_byColor_id";
				thisValueTemp = "00016" + jQuery("#wg_byColorPlaceAll").val();
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
		
		if(isNotEmpty(giletModel)){
			var code = itemCode + subItemCode + giletModel;
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

function ogSession(){
	jQuery('input[name="coOptionGiletStandardInfo.ogStitchModifyPlace1"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogStitchModifyPlace1}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogStitchModifyPlace2"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogStitchModifyPlace2}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogStitchModifyPlace3"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogStitchModifyPlace3}"]);

	// 選択中のダブルステッチ変更
	ctrlOgDStitchPlace();
 	// AMF色指定の有効/無効を制御
	ctrlOgAmfColor();
	
	jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModifyPlace1"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyPlace1}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModifyPlace2"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyPlace2}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogDStitchModifyPlace3"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogDStitchModifyPlace3}"]);

	jQuery('input[name="coOptionGiletStandardInfo.ogAmfColorPlace1"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogAmfColorPlace1}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogAmfColorPlace2"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogAmfColorPlace2}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogAmfColorPlace3"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogAmfColorPlace3}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor1"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogAmfColor1}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor2"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogAmfColor2}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogAmfColor3"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogAmfColor3}"]);
	jQuery('input[id^="og_amfColorPlace_"]').change();
	
	jQuery('input[name="coOptionGiletStandardInfo.ogBhColorPlace1"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlace1}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogBhColorPlace2"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlace2}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogBhColorPlace3"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlace3}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogBhColorPlace4"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlace4}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogBhColorPlace5"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlace5}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogBhColorPlace6"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogBhColorPlace6}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogBhColor1"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogBhColor1}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogBhColor2"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogBhColor2}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogBhColor3"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogBhColor3}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogBhColor4"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogBhColor4}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogBhColor5"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogBhColor5}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogBhColor6"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogBhColor6}"]);
	jQuery('input[id^="og_bhColorPlace_"]').change();
	
	jQuery('input[name="coOptionGiletStandardInfo.ogByColorPlace1"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColorPlace1}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColorPlace2"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColorPlace2}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColorPlace3"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColorPlace3}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColorPlace4"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColorPlace4}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColorPlace5"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColorPlace5}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColorPlace6"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColorPlace6}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColorPlace7"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColorPlace7}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColorPlace8"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColorPlace8}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColorPlace9"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColorPlace9}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColorPlace10"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColorPlace10}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColor1"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColor1}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColor2"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColor2}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColor3"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColor3}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColor4"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColor4}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColor5"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColor5}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColor6"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColor6}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColor7"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColor7}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColor8"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColor8}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColor9"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColor9}"]);
	jQuery('input[name="coOptionGiletStandardInfo.ogByColor10"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogByColor10}"]);
	jQuery('input[id^="og_byColorPlace_"]').change();

}

function tgSession(){
	jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColorPlace1"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgBhColorPlace1}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColorPlace2"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgBhColorPlace2}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColorPlace3"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgBhColorPlace3}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColorPlace4"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgBhColorPlace4}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColorPlace5"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgBhColorPlace5}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColorPlace6"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgBhColorPlace6}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColor1"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgBhColor1}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColor2"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgBhColor2}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColor3"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgBhColor3}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColor4"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgBhColor4}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColor5"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgBhColor5}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgBhColor6"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgBhColor6}"]);
	jQuery('input[id^="tg_bhColorPlace_"]').change();
	
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColorPlace1"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColorPlace1}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColorPlace2"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColorPlace2}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColorPlace3"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColorPlace3}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColorPlace4"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColorPlace4}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColorPlace5"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColorPlace5}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColorPlace6"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColorPlace6}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColorPlace7"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColorPlace7}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColorPlace8"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColorPlace8}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColorPlace9"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColorPlace9}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColorPlace10"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColorPlace10}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor1"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColor1}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor2"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColor2}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor3"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColor3}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor4"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColor4}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor5"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColor5}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor6"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColor6}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor7"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColor7}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor8"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColor8}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor9"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColor9}"]);
	jQuery('input[name="coOptionGiletTuxedoInfo.tgByColor10"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgByColor10}"]);
	jQuery('input[id^="tg_byColorPlace_"]').change();
	
}

function wgSession(){
	jQuery('input[name="coOptionGiletWashableInfo.wgStitchModifyPlace1"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgStitchModifyPlace1}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgStitchModifyPlace2"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgStitchModifyPlace2}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgStitchModifyPlace3"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgStitchModifyPlace3}"]);

	jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModifyPlace1"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgDStitchModifyPlace1}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModifyPlace2"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgDStitchModifyPlace2}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgDStitchModifyPlace3"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgDStitchModifyPlace3}"]);

	jQuery('input[name="coOptionGiletWashableInfo.wgAmfColorPlace1"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgAmfColorPlace1}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgAmfColorPlace2"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgAmfColorPlace2}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgAmfColorPlace3"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgAmfColorPlace3}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor1"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgAmfColor1}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor2"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgAmfColor2}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgAmfColor3"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgAmfColor3}"]);
	jQuery('input[id^="wg_amfColorPlace_"]').change();
	
	jQuery('input[name="coOptionGiletWashableInfo.wgBhColorPlace1"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgBhColorPlace1}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgBhColorPlace2"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgBhColorPlace2}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgBhColorPlace3"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgBhColorPlace3}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgBhColorPlace4"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgBhColorPlace4}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgBhColorPlace5"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgBhColorPlace5}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgBhColorPlace6"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgBhColorPlace6}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgBhColor1"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgBhColor1}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgBhColor2"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgBhColor2}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgBhColor3"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgBhColor3}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgBhColor4"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgBhColor4}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgBhColor5"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgBhColor5}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgBhColor6"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgBhColor6}"]);
	jQuery('input[id^="og_bhColorPlace_"]').change();
	
	jQuery('input[name="coOptionGiletWashableInfo.wgByColorPlace1"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColorPlace1}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColorPlace2"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColorPlace2}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColorPlace3"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColorPlace3}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColorPlace4"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColorPlace4}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColorPlace5"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColorPlace5}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColorPlace6"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColorPlace6}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColorPlace7"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColorPlace7}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColorPlace8"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColorPlace8}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColorPlace9"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColorPlace9}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColorPlace10"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColorPlace10}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColor1"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColor1}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColor2"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColor2}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColor3"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColor3}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColor4"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColor4}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColor5"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColor5}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColor6"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColor6}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColor7"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColor7}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColor8"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColor8}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColor9"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColor9}"]);
	jQuery('input[name="coOptionGiletWashableInfo.wgByColor10"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgByColor10}"]);
	jQuery('input[id^="wg_byColorPlace_"]').change();

 	// 選択中のダブルステッチ変更
	ctrlWgDStitchPlace();
 	// AMF色指定の有効/無効を制御
	ctrlWgAmfColor();
}

function mateStkNoReInit(productCategory){
	if(productCategory == "9000101"){
		var ogBackLiningMateStkNo = "${orderCoForm.coOptionGiletStandardInfo.ogBackLiningMateStkNo}";
		if(isNotEmpty(ogBackLiningMateStkNo)){
			jQuery("#og_backLiningMateStkNo option[value='"+ogBackLiningMateStkNo+"']").attr("selected", true);
		}
		var ogInsideLiningMateStkNo = "${orderCoForm.coOptionGiletStandardInfo.ogInsideLiningMateStkNo}";
		if(isNotEmpty(ogInsideLiningMateStkNo)){
			jQuery("#og_insideLiningMateStkNo option[value='"+ogInsideLiningMateStkNo+"']").attr("selected", true);
		}
		var ogFrontBtnMateStkNo = "${orderCoForm.coOptionGiletStandardInfo.ogFrontBtnMateStkNo}";
		if(isNotEmpty(ogFrontBtnMateStkNo)){
			jQuery("#og_frontBtnMateStkNo option[value='"+ogFrontBtnMateStkNo+"']").attr("selected", true);
			if(jacketBtnMateGlFlag=="1"){
				jQuery("#jacketBtnMateGlFlag").val("0");
			}
		}

	}else if(productCategory == "9000102"){
		var tgBackLiningMateStkNo = "${orderCoForm.coOptionGiletTuxedoInfo.tgBackLiningMateStkNo}";
		if(isNotEmpty(tgBackLiningMateStkNo)){
			jQuery("#tg_backLiningMateStkNo option[value='"+tgBackLiningMateStkNo+"']").attr("selected", true);
		}
		var tgInsideLiningMateStkNo = "${orderCoForm.coOptionGiletTuxedoInfo.tgInsideLiningMateStkNo}";
		if(isNotEmpty(tgInsideLiningMateStkNo)){
			jQuery("#tg_insideLiningMateStkNo option[value='"+tgInsideLiningMateStkNo+"']").attr("selected", true);
		}
		var tgFrontBtnMateStkNo = "${orderCoForm.coOptionGiletTuxedoInfo.tgFrontBtnMateStkNo}";
		if(isNotEmpty(tgFrontBtnMateStkNo)){
			jQuery("#tg_frontBtnMateStkNo option[value='"+tgFrontBtnMateStkNo+"']").attr("selected", true);
			if(jacketBtnMateGlFlag=="1"){
				jQuery("#jacketBtnMateGlFlag").val("0");
			}
		}
		
	}else if(productCategory == "9000103"){
		var wgBackLiningMateStkNo = "${orderCoForm.coOptionGiletWashableInfo.wgBackLiningMateStkNo}";
		if(isNotEmpty(wgBackLiningMateStkNo)){
			jQuery("#wg_backLiningMateStkNo option[value='"+wgBackLiningMateStkNo+"']").attr("selected", true);
		}
		var wgInsideLiningMateStkNo = "${orderCoForm.coOptionGiletWashableInfo.wgInsideLiningMateStkNo}";
		if(isNotEmpty(wgInsideLiningMateStkNo)){
			jQuery("#wg_insideLiningMateStkNo option[value='"+wgInsideLiningMateStkNo+"']").attr("selected", true);
		}
		var wgFrontBtnMateStkNo = "${orderCoForm.coOptionGiletWashableInfo.wgFrontBtnMateStkNo}";
		if(isNotEmpty(wgFrontBtnMateStkNo)){
			jQuery("#wg_frontBtnMateStkNo option[value='"+wgFrontBtnMateStkNo+"']").attr("selected", true);
			if(jacketBtnMateGlFlag=="1"){
				jQuery("#jacketBtnMateGlFlag").val("0");
			}
		}
		
	}
}

function optionGiletChangeModel(productCategory){
	var giletFlag = jQuery("#giletFlag").val();
	if(giletFlag == "1"){
		if(productCategory == "9000101"){
			var giletModel = jQuery("#giletModel").val();

			if(isEmpty(giletModel)){
				return;
			}

			//胸ポケット
			jQuery('input[name="coOptionGiletStandardInfo.ogBreastPkt"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogBreastPkt}"]);
			jQuery('input[name="coOptionGiletStandardInfo.ogBreastPkt"]:checked').change();

			//腰ポケット
			jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogWaistPkt}"]);
			jQuery('input[name="coOptionGiletStandardInfo.ogWaistPkt"]:checked').change();
			
			//腰ポケット形状
			jQuery('input[name="coOptionGiletStandardInfo.ogWaistPktSpec"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogWaistPktSpec}"]);
			jQuery('input[name="coOptionGiletStandardInfo.ogWaistPktSpec"]:checked').change();

			//ステッチ種類
			jQuery('input[name="coOptionGiletStandardInfo.ogStitch"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogStitch}"]);
			jQuery('input[name="coOptionGiletStandardInfo.ogStitch"]:checked').change();

			//バックベルト
			jQuery('#og_backBelt').val("${orderCoForm.coOptionGiletStandardInfo.ogBackBelt}");
			jQuery('#og_backBelt').change();

			//ウォッチチェーン
			jQuery('input[name="coOptionGiletStandardInfo.ogWatchChain"]').val(["${orderCoForm.coOptionGiletStandardInfo.ogWatchChain}"]);
			jQuery('input[name="coOptionGiletStandardInfo.ogWatchChain"]:checked').change();
	
		}else if(productCategory == "9000102"){
			var giletModel = jQuery("#tg_giletModel").val();

			if(isEmpty(giletModel)){
				return;
			}

			//胸ポケット
			jQuery('input[name="coOptionGiletTuxedoInfo.tgBreastPkt"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgBreastPkt}"]);
			jQuery('input[name="coOptionGiletTuxedoInfo.tgBreastPkt"]:checked').change();

			//腰ポケット形状
			jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPktSpec"]').val(["${orderCoForm.coOptionGiletTuxedoInfo.tgWaistPktSpec}"]);
			jQuery('input[name="coOptionGiletTuxedoInfo.tgWaistPktSpec"]:checked').change();

		}else if(productCategory == "9000103"){
			var giletModel = jQuery("#wg_giletModel").val();

			if(isEmpty(giletModel)){
				return;
			}

			//胸ポケット
			jQuery('input[name="coOptionGiletWashableInfo.wgBreastPkt"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgBreastPkt}"]);
			jQuery('input[name="coOptionGiletWashableInfo.wgBreastPkt"]:checked').change();

			//腰ポケット形状
			jQuery('input[name="coOptionGiletWashableInfo.wgWaistPktSpec"]').val(["${orderCoForm.coOptionGiletWashableInfo.wgWaistPktSpec}"]);
			jQuery('input[name="coOptionGiletWashableInfo.wgWaistPktSpec"]:checked').change();
			
		}
	}
}

function optionColorReSave(productCategory){
	if(productCategory == "9000101"){
		ogSession();
	}else if(productCategory == "9000102"){
		tgSession();
	}else if(productCategory == "9000103"){
		wgSession();
	}
}
jQuery("#giletModel,#tg_giletModel,#wg_giletModel").change(function(){
	if("orderCo"==orderFlag){
		jQuery("#giletAdFlag").val("0");	
	}else if("1"==jQuery("#giletItemFlag").val()){
		if("orderCo"!=orderFlag ){
			jQuery("#giletAdFlag").val("0");
		}
	}	
})
if (document.readyState=="complete")  {  
	$.unblockUI();
}else{  
	document.onreadystatechange = function(){  
		if (document.readyState == "complete"){
			$.unblockUI();   
		}  
	}  
}
</script>