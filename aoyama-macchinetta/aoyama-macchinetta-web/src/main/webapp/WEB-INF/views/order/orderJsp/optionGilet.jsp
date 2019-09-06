<form:form id="idInfoForm" action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm" method="post" modelAttribute="orderForm" class="form-horizontal">
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
                        <form:select id="giletModel" path="optionGiletStandardInfo.ogGiletModel" class="form-control-sm form-control">
                        	<form:options items="${orderForm.optionGiletStandardInfo.ogGiletModelMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="giletModelMsg"></div>
                    <div class="col-12 col-md-9 offset-md-3" id="giletModelCheck" style="margin-top:8px"></div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_breastPkt_id" path="optionGiletStandardInfo.ogBreastPkt" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogBreastPktMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_breastPkt_Msg">
                       	<%-- <c:if test="${orderForm.optionGiletStandardInfo.glBtnthreadColorRtPrice == '0'}">
                     		無料
                     	</c:if>
                     	<c:if test="${orderForm.optionGiletStandardInfo.glBtnthreadColorRtPrice != '0'}">
                     		${orderForm.optionGiletStandardInfo.glBtnthreadColorRtPrice}
                     	</c:if> --%>
<%-- 						${orderForm.optionGiletStandardInfo.glBreastPktRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
                    <div class="col-12 col-md-6">
                      	<div class="form-check-inline form-check">
                          	<form:radiobuttons id="og_waistPkt_id" path="optionGiletStandardInfo.ogWaistPkt" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogWaistPktMap}"/>
                  		</div>
	                </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_waistPkt_Msg">
<%--                     	${orderForm.optionGiletStandardInfo.glWaistPktRtPrice } --%>
                    </div>
                </div>
                <div id="og_waistPkt_yes_area">
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット形状</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_waistPktSpec_id" path="optionGiletStandardInfo.ogWaistPktSpec" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogWaistPktSpecMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_waistPktSpec_Msg">
<%--                     	${orderForm.optionGiletStandardInfo.glWaistPktShapeRtPrice } --%>
                    </div>
                </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_og_stitch"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_stitch_id" path="optionGiletStandardInfo.ogStitch" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogStitchMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_stitch_Msg">
<%--                     	${orderForm.optionGiletStandardInfo.glAmfStitchRtPrice } --%>
                    </div>
                </div>
                <div id="og_stitch_yes_area">
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_stitchModify_id" path="optionGiletStandardInfo.ogStitchModify" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogStitchModifyMap}"/>
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
                            <form:checkboxes id="og_stitchModifyPlace_id" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogStitchModifyPlaceMap}" path="optionGiletStandardInfo.ogStitchModifyPlace"/>
                        </div> --%>
                        <c:forEach var="ogStitchModifyPlaceMap" items="${orderForm.optionGiletStandardInfo.ogStitchModifyPlaceMap }" varStatus="row">
                      		<div class="form-check-inline form-check">
                      			<input type="checkbox" id="og_stitchModifyPlace_id${row.count}" name="optionGiletStandardInfo.ogStitchModifyPlace${row.count}" value="${ogStitchModifyPlaceMap.key}" class="form-check-input">${ogStitchModifyPlaceMap.value}
                      		</div>
                      	</c:forEach>
                        </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_stitchModify_Msg">
<%--                     	${orderForm.optionGiletStandardInfo.glStitchPlcRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ダブルステッチ</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_dStitchModify_id" path="optionGiletStandardInfo.ogDStitchModify" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogDStitchModifyMap}"/>
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
                            <form:checkboxes id="og_dStitchModifyPlace_id" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogDStitchModifyPlaceMap}" path="optionGiletStandardInfo.ogDStitchModifyPlace"/>
                        </div> --%>
                        <c:forEach var="ogDStitchModifyPlaceMap" items="${orderForm.optionGiletStandardInfo.ogDStitchModifyPlaceMap }" varStatus="row">
                      		<div class="form-check-inline form-check">
                      			<input type="checkbox" id="og_dStitchModifyPlace_id${row.count}" name="optionGiletStandardInfo.ogDStitchModifyPlace${row.count}" value="${ogDStitchModifyPlaceMap.key}" class="form-check-input">${ogDStitchModifyPlaceMap.value}
                      		</div>
                      	</c:forEach>
                        </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_dStitchModify_Msg">
<%--                     	${orderForm.optionGiletStandardInfo.glDblstitchPlcRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_amfColor_id" path="optionGiletStandardInfo.ogAmfColor" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogAmfColorMap}"/>
                        </div>
                        <div id="og_amfColor_div" style="display:none">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <form:select id="og_amfColorPlaceAll" path="optionGiletStandardInfo.ogAmfColorPlaceAll" class="form-control-sm form-control">
                            	<form:options items="${orderForm.optionGiletStandardInfo.ogAmfColorPlaceAllMap}"/>
                        	</form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_og_amfColorPlace">全選択</button>
                        	<button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_og_amfColorPlace">全解除</button>
                        </div>
                        </div>
                        
                        <c:forEach var="ogAmfColorPlaceMap" items="${orderForm.optionGiletStandardInfo.ogAmfColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="og_amfColorPlace" class="form-check-label ">
                                <input type="checkbox" id="og_amfColorPlace_${row.count}" name="optionGiletStandardInfo.ogAmfColorPlace${row.count}" value="${ogAmfColorPlaceMap.key }" class="form-check-input">${ogAmfColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="og_amfColorPlace_${row.count}_div"  style="display:none">
                        		<c:forEach var="ogAmfColorsMap" items="${orderForm.optionGiletStandardInfo.ogAmfColorPlaceAllMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="og_amfColor" class="form-check-label ">
                        			    <input type="radio" id="og_amfColor_${ogAmfColorsMap.key}" name="optionGiletStandardInfo.ogAmfColor${row.count}" value="${ogAmfColorsMap.key}" class="form-check-input">${ogAmfColorsMap.value}
                        		     </label>
                        		  </div>
                        		</c:forEach>
                        	</div>
                        </c:forEach>
                        
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_amfColor_Msg">
<%--                     	${orderForm.optionGiletStandardInfo.glAmfColorRtPrice } --%>
                    </div>
                </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_bhColor_id" path="optionGiletStandardInfo.ogBhColor" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogBhColorMap}"/>
                        </div>
                        <div id="og_bhColor_div" style="display:none">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                        <form:select id="og_bhColorPlaceAll" path="optionGiletStandardInfo.ogBhColorPlaceAll" class="form-control-sm form-control">
                            	<form:options items="${orderForm.optionGiletStandardInfo.ogBhColorPlaceAllMap}"/>
                        </form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_og_bhColorPlace">全選択</button>
                            &nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_og_bhColorPlace">全解除</button>
                        </div>
                        </div>
                        
                        <c:forEach var="ogBhColorPlaceMap" items="${orderForm.optionGiletStandardInfo.ogBhColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="og_bhColorPlace" class="form-check-label ">
                                <input type="checkbox" id="og_bhColorPlace_${row.count}" name="optionGiletStandardInfo.ogBhColorPlace${row.count}" value="${ogBhColorPlaceMap.key }" class="form-check-input">${ogBhColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="og_bhColorPlace_${row.count}_div" style="display:none">
                        		<c:forEach var="ogBhColorsMap" items="${orderForm.optionGiletStandardInfo.ogBhColorsMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="og_bhColor" class="form-check-label ">
                        			    <input type="radio" id="og_bhColor_${ogBhColorsMap.key}" name="optionGiletStandardInfo.ogBhColor${row.count}" value="${ogBhColorsMap.key}" class="form-check-input">${ogBhColorsMap.value}
                        		     </label>
                        		  </div>
                        		</c:forEach>
                        	</div>
                        </c:forEach>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_bhColor_Msg">
<%--                     	${orderForm.optionGiletStandardInfo.glBtnholeColorRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ボタン付け糸指定</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_byColor_id" path="optionGiletStandardInfo.ogByColor" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogByColorMap}"/>
                        </div>
                        <div id="og_byColor_div" style="display:none">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <form:select id="og_byColorPlaceAll" path="optionGiletStandardInfo.ogByColorPlaceAll" class="form-control-sm form-control">
                            	<form:options items="${orderForm.optionGiletStandardInfo.ogByColorPlaceAllMap}"/>
                            </form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_og_byColorPlace">全選択</button>
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_og_byColorPlace">全解除</button>
                        </div>
                        </div>
                        
                        <c:forEach var="ogByColorPlaceMap" items="${orderForm.optionGiletStandardInfo.ogByColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="og_byColorPlace" class="form-check-label ">
                                <input type="checkbox" id="og_byColorPlace_${row.count}" name="optionGiletStandardInfo.ogByColorPlace${row.count}" value="${ogByColorPlaceMap.key }" class="form-check-input">${ogByColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="og_byColorPlace_${row.count}_div" style="display:none">
                        		<c:forEach var="ogByColorsMap" items="${orderForm.optionGiletStandardInfo.ogByColorsMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="og_byColor" class="form-check-label ">
                        			    <input type="radio" id="og_byColor_${ogByColorsMap.key}" name="optionGiletStandardInfo.ogByColor${row.count}" value="${ogByColorsMap.key}" class="form-check-input">${ogByColorsMap.value}
                        		     </label>
                        		  </div>
                        		</c:forEach>
                        	</div>
                        </c:forEach>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_byColor_Msg">
<%--                     	${orderForm.optionGiletStandardInfo.glBtnthreadColorRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">背裏地素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_og_backLiningMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col-12 col-md-3">
                        <form:select id="og_backLiningMate" path="optionGiletStandardInfo.ogBackLiningMate" class="form-control-sm form-control">
                            	<form:options items="${orderForm.optionGiletStandardInfo.ogBackLiningMateMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-3">
                        <select name="optionGiletStandardInfo.ogBackLiningMateStkNo" id="og_backLiningMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_backLiningMate_Msg">
<%--                     	${orderForm.optionGiletStandardInfo.glBackClothRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_og_insideLiningMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col-12 col-md-3">
                        <form:select id="og_insideLiningMate" path="optionGiletStandardInfo.ogInsideLiningMate" class="form-control-sm form-control">
                            	<form:options items="${orderForm.optionGiletStandardInfo.ogInsideLiningMateMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-3">
                        <select name="optionGiletStandardInfo.ogInsideLiningMateStkNo" id="og_insideLiningMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_insideLiningMate_Msg">
<%--                     	${orderForm.optionGiletStandardInfo.glInnnerClothRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_og_frontBtnMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col-12 col-md-3">
                        <form:select id="og_frontBtnMate" path="optionGiletStandardInfo.ogFrontBtnMate" class="form-control-sm form-control">
                            	<form:options items="${orderForm.optionGiletStandardInfo.ogFrontBtnMateMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-3">
                        <select name="optionGiletStandardInfo.ogFrontBtnMateStkNo" id="og_frontBtnMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_frontBtnMate_Msg">
<%--                     	${orderForm.optionGiletStandardInfo.glFrtBtnRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
                    <div class="col-12 col-md-6">
                        <form:select id="og_backBelt" path="optionGiletStandardInfo.ogBackBelt" class="form-control-sm form-control">
                            	<form:options items="${orderForm.optionGiletStandardInfo.ogBackBeltMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_backBelt_Msg">
<%--                     	${orderForm.optionGiletStandardInfo.glBackBeltRtPrice } --%>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ウォッチチェーン</label></div>
                    <div class="col-12 col-md-6">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="og_watchChain_id" path="optionGiletStandardInfo.ogWatchChain" class="form-check-input" items="${orderForm.optionGiletStandardInfo.ogWatchChainMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-3" align="right" name="ogPriceMsg" id="og_watchChain_Msg">
<%--                     	${orderForm.optionGiletStandardInfo.glWatchChainRtPrice } --%>
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
                    	<form:select id="tg_giletModel" path="optionGiletTuxedoInfo.tgGiletModel" class="form-control-sm form-control">
                        	<form:options items="${orderForm.optionGiletTuxedoInfo.tgGiletModelMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="tg_giletModelMsg"></div>
                    <div class="col-12 col-md-9 offset-md-3" id="tg_giletModelCheck" style="margin-top:8px"></div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
                    <div class="col col-md-9">
                    	<div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_breastPkt_id" path="optionGiletTuxedoInfo.tgBreastPkt" class="form-check-input" items="${orderForm.optionGiletTuxedoInfo.tgBreastPktMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="tg_breastPktMsg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
                    <div class="col col-md-3">
                    	<div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_waistPkt_id" path="optionGiletTuxedoInfo.tgWaistPkt" class="form-check-input" items="${orderForm.optionGiletTuxedoInfo.tgWaistPktMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="tg_waistPktMsg">
                    </div>
                </div>
                <div id="tg_waistPkt_yes_area">
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット形状</label></div>
                    <div class="col-12 col-md-9">
                    	<div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_waistPktSpec_id" path="optionGiletTuxedoInfo.tgWaistPktSpec" class="form-check-input" items="${orderForm.optionGiletTuxedoInfo.tgWaistPktSpecMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="tg_waistPktSpecMsg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット素材</label></div>
                    <div class="col-12 col-md-9">
                    	<div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_waistPktMate_id" path="optionGiletTuxedoInfo.tgWaistPktMate" class="form-check-input" items="${orderForm.optionGiletTuxedoInfo.tgWaistPktMateMap}"/>
                        </div>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="tg_waistPktSpecMsg">
                    </div>
                </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
                    <div class="col-12 col-md-9">
                    	<div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_stitch_id" path="optionGiletTuxedoInfo.tgStitch" class="form-check-input" items="${orderForm.optionGiletTuxedoInfo.tgStitchMap}"/>
                        </div>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                    <div class="col-12 col-md-9">
                        <div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_bhColor_id" path="optionGiletTuxedoInfo.tgBhColor" class="form-check-input" items="${orderForm.optionGiletTuxedoInfo.tgBhColorMap}"/>
                        </div>
                        <div id="tg_bhColor_div">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <form:select id="tg_bhColorPlaceAll" path="optionGiletTuxedoInfo.tgBhColorPlaceAll" class="form-control-sm form-control">
                            	<form:options items="${orderForm.optionGiletTuxedoInfo.tgBhColorPlaceAllMap}"/>
                        	</form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tg_bhColorPlace">全選択</button>
                            &nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tg_bhColorPlace">全解除</button>
                        </div>
                        </div>
                        
                        <c:forEach var="tgBhColorPlaceMap" items="${orderForm.optionGiletTuxedoInfo.tgBhColorPlaceMap }" varStatus="row">
                         <div class="offset-md-1">
                             <div class="form-check">
                             <div class="checkbox">
                             <label for="tg_bhColorPlace" class="form-check-label ">
                                 <input type="checkbox" id="tg_bhColorPlace_${row.count}" name="optionGiletTuxedoInfo.tgBhColorPlace" value="${tgBhColorPlaceMap.key }" class="form-check-input">${tgBhColorPlaceMap.value }
                             </label>
                             </div>
                             </div>
                         </div>
                         <div class="offset-md-2" id="tg_bhColorPlace_${row.count}_div" style="display:none">
                         	<c:forEach var="tgBhColorsMap" items="${orderForm.optionGiletTuxedoInfo.tgBhColorsMap}">
                       		  <div class="form-check-inline form-check">
                       		     <label for="tg_bhColor" class="form-check-label ">
                       			    <input type="radio" id="tg_bhColor_${tgBhColorsMap.key}" name="optionGiletTuxedoInfo.tgBhColor${row.count}" value="${tgBhColorsMap.key}" class="form-check-input">${tgBhColorsMap.value}
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
                            <form:radiobuttons id="tg_byColor_id" path="optionGiletTuxedoInfo.tgByColor" class="form-check-input" items="${orderForm.optionGiletTuxedoInfo.tgByColorMap}"/>
                        </div>
                        <div id="tg_byColor_div">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <form:select id="tg_byColorPlaceAll" path="optionGiletTuxedoInfo.tgByColorPlaceAll" class="form-control-sm form-control">
                            	<form:options items="${orderForm.optionGiletTuxedoInfo.tgByColorPlaceAllMap}"/>
                            </form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tg_byColorPlace">全選択</button>
                            &nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tg_byColorPlace">全解除</button>
                        </div>
                        </div>
                        
                        <c:forEach var="tgByColorPlaceMap" items="${orderForm.optionGiletTuxedoInfo.tgByColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="og_byColorPlace" class="form-check-label ">
                                <input type="checkbox" id="tg_byColorPlace_${row.count}" name="optionGiletTuxedoInfo.tgByColorPlace" value="${tgByColorPlaceMap.key }" class="form-check-input">${tgByColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="tg_byColorPlace_${row.count}_div" style="display:none">
                        		<c:forEach var="tgByColorsMap" items="${orderForm.optionGiletTuxedoInfo.tgByColorsMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="tg_byColor" class="form-check-label ">
                        			    <input type="radio" id="tg_byColor_${tgByColorsMap.key}" name="optionGiletTuxedoInfo.tgByColor${row.count}" value="${tgByColorsMap.key}" class="form-check-input">${tgByColorsMap.value}
                        		     </label>
                        		  </div>
                        		</c:forEach>
                        	</div>
                        </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">背裏地素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tg_backLiningMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="tg_backLiningMate" path="optionGiletTuxedoInfo.tgBackLiningMate" class="form-control-sm form-control">
                            	<form:options items="${orderForm.optionGiletTuxedoInfo.tgBackLiningMateMap}"/>
                        </form:select>
                    </div>
                    <div class="col col-md-4">
                        <select name="tg_backLiningMateStkNo" id="tg_backLiningMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tg_insideLiningMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="tg_insideLiningMate" path="optionGiletTuxedoInfo.tgInsideLiningMate" class="form-control-sm form-control">
                            <form:options items="${orderForm.optionGiletTuxedoInfo.tgInsideLiningMateMap}"/>
                        </form:select>
                    </div>
                    <div class="col col-md-4">
                        <select name="tg_insideLiningMateStkNo" id="tg_insideLiningMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                </div>
                
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tg_frontBtnMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="tg_frontBtnMate" path="optionGiletTuxedoInfo.tgFrontBtnMate" class="form-control-sm form-control">
                            <form:options items="${orderForm.optionGiletTuxedoInfo.tgFrontBtnMateMap}"/>
                        </form:select>
                    </div>
                    <div class="col col-md-4">
                        <select name="tg_frontBtnMateStkNo" id="tg_frontBtnMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
                    <div class="col col-md-3">
                    	<form:select id="tg_backBelt" path="optionGiletTuxedoInfo.tgBackBelt" class="form-control-sm form-control">
                            <form:options items="${orderForm.optionGiletTuxedoInfo.tgBackBeltMap}"/>
                        </form:select>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="tg_backBeltMsg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ウォッチチェーン</label></div>
                    <div class="col-12 col-md-9">
                    	<div class="form-check-inline form-check">
                            <form:radiobuttons id="tg_watchChain_id" path="optionGiletTuxedoInfo.tgWatchChain" class="form-check-input" items="${orderForm.optionGiletTuxedoInfo.tgWatchChainMap}"/>
                        </div>
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
                    	<form:select id="wg_giletModel" path="optionGiletWashableInfo.wgGiletModel" class="form-control-sm form-control">
							<form:options items="${orderForm.optionGiletWashableInfo.wgGiletModelMap}"/>
						</form:select>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="wg_giletModelMsg"></div>
                    <div class="col-12 col-md-9 offset-md-3" id="wg_giletModelCheck" style="margin-top:8px"></div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
                    <div class="col col-md-9">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_breastPkt_id" path="optionGiletWashableInfo.wgBreastPkt" class="form-check-input" items="${orderForm.optionGiletWashableInfo.wgBreastPktMap}"/>
						</div>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="wg_breastPktMsg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット</label></div>
                    <div class="col col-md-9">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_waistPkt_id" path="optionGiletWashableInfo.wgWaistPkt" class="form-check-input" items="${orderForm.optionGiletWashableInfo.wgWaistPktMap}"/>
						</div>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="wg_waistPktMsg">
                    </div>
                </div>
                <div id="wg_waistPkt_yes_area">
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">腰ポケット形状</label></div>
                    <div class="col-12 col-md-9">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_waistPktSpec_id" path="optionGiletWashableInfo.wgWaistPktSpec" class="form-check-input" items="${orderForm.optionGiletWashableInfo.wgWaistPktSpecMap}"/>
						</div>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="wg_waistPktSpecMsg">
                    </div>
                </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
                    <div class="col-12 col-md-9">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_stitch_id" path="optionGiletWashableInfo.wgStitch" class="form-check-input" items="${orderForm.optionGiletWashableInfo.wgStitchMap}"/>
						</div>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                    <div class="col-12 col-md-9">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_stitchModify_id" path="optionGiletWashableInfo.wgStitchModify" class="form-check-input" items="${orderForm.optionGiletWashableInfo.wgStitchModifyMap}"/>
						</div>
                        <div id="wg_stitchModifyPlace">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wg_stitchModifyPlace">全選択</button>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wg_stitchModifyPlace">全解除</button>
                        </div>
                        </div>
                        <div class="offset-md-1">
                        <%-- <div class="form-check-inline form-check">
							<form:checkboxes id="wg_stitchModifyPlace_id" path="optionGiletWashableInfo.wgStitchModifyPlace" class="form-check-input" items="${orderForm.optionGiletWashableInfo.wgStitchModifyPlaceMap}"/>
						</div> --%>
						<c:forEach var="wgStitchModifyPlaceMap" items="${orderForm.optionGiletWashableInfo.wgStitchModifyPlaceMap }" varStatus="row">
                      		<div class="form-check-inline form-check">
                      			<input type="checkbox" id="wg_stitchModifyPlace_id${row.count}" name="optionGiletWashableInfo.wgStitchModifyPlace${row.count}" value="${wgStitchModifyPlaceMap.key}" class="form-check-input">${wgStitchModifyPlaceMap.value}
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
							<form:radiobuttons id="wg_dStitchModify_id" path="optionGiletWashableInfo.wgDStitchModify" class="form-check-input" items="${orderForm.optionGiletWashableInfo.wgDStitchModifyMap}"/>
						</div>
                        <div id="wg_dStitchModifyPlace">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wg_dStitchModifyPlace">全選択</button>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wg_dStitchModifyPlace">全解除</button>
                        </div>
                        </div>
                        <div class="offset-md-1">
                        <%-- <div class="form-check-inline form-check">
							<form:checkboxes id="wg_dStitchModifyPlace_id" path="optionGiletWashableInfo.wgDStitchModifyPlace" class="form-check-input" items="${orderForm.optionGiletWashableInfo.wgDStitchModifyPlaceMap}"/>
						</div> --%>
						<c:forEach var="wgDStitchModifyPlaceMap" items="${orderForm.optionGiletWashableInfo.wgDStitchModifyPlaceMap }" varStatus="row">
                      		<div class="form-check-inline form-check">
                      			<input type="checkbox" id="wg_dStitchModifyPlace_id${row.count}" name="optionGiletWashableInfo.wgDStitchModifyPlace${row.count}" value="${wgDStitchModifyPlaceMap.key}" class="form-check-input">${wgDStitchModifyPlaceMap.value}
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
							<form:radiobuttons id="wg_amfColor_id" path="optionGiletWashableInfo.wgAmfColor" class="form-check-input" items="${orderForm.optionGiletWashableInfo.wgAmfColorMap}"/>
						</div>
                        <div id="wg_amfColor_div" style="display:none;">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                         <form:select id="wg_amfColorPlaceAll_id" path="optionGiletWashableInfo.wgAmfColorPlaceAll" class="form-control-sm form-control">
							<form:options items="${orderForm.optionGiletWashableInfo.wgAmfColorPlaceAllMap}"/>
						</form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wg_amfColorPlace">全選択</button>
                            &nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wg_amfColorPlace">全解除</button>
                        </div>
                        </div>
                        <c:forEach var="wgAmfColorPlaceMap" items="${orderForm.optionGiletWashableInfo.wgAmfColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="wg_amfColorPlace" class="form-check-label ">
                                <input type="checkbox" id="wg_amfColorPlace_${row.count}" name="optionGiletWashableInfo.wgAmfColorPlace${row.count}" value="${wgAmfColorPlaceMap.key }" class="form-check-input">${wgAmfColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="wg_amfColorPlace_${row.count}_div" style="display:none">
                        		<c:forEach var="wgAmfColorsMap" items="${orderForm.optionGiletWashableInfo.wgAmfColorPlaceAllMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="wg_amfColor" class="form-check-label ">
                        			    <input type="radio" id="wg_amfColor_${wgAmfColorsMap.key}" name="optionGiletWashableInfo.wgAmfColor${row.count}" value="${wgAmfColorsMap.key}" class="form-check-input">${wgAmfColorsMap.value}
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
							<form:radiobuttons id="wg_bhColor_id" path="optionGiletWashableInfo.wgBhColor" class="form-check-input" items="${orderForm.optionGiletWashableInfo.wgBhColorMap}"/>
						</div>
                        <div id="wg_bhColor_div">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <form:select id="wg_bhColorPlaceAll" path="optionGiletWashableInfo.wgBhColorPlaceAll" class="form-control-sm form-control">
								<form:options items="${orderForm.optionGiletWashableInfo.wgBhColorPlaceAllMap}"/>
							</form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wg_bhColorPlace">全選択</button>
                            &nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wg_bhColorPlace">全解除</button>
                        </div>
                        </div>
                        <c:forEach var="wgBhColorPlaceMap" items="${orderForm.optionGiletWashableInfo.wgBhColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="wg_bhColorPlace" class="form-check-label ">
                                <input type="checkbox" id="wg_bhColorPlace_${row.count}" name="optionGiletWashableInfo.wgBhColorPlace${row.count}" value="${wgBhColorPlaceMap.key }" class="form-check-input">${wgBhColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="wg_bhColorPlace_${row.count}_div" style="display:none">
                        		<c:forEach var="wgBhColorsMap" items="${orderForm.optionGiletWashableInfo.wgBhColorsMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="wg_bhColor" class="form-check-label ">
                        			    <input type="radio" id="wg_byColor_${wgBhColorsMap.key}" name="optionGiletWashableInfo.wgBhColor${row.count}" value="${wgBhColorsMap.key}" class="form-check-input">${wgBhColorsMap.value}
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
							<form:radiobuttons id="wg_byColor_id" path="optionGiletWashableInfo.wgByColor" class="form-check-input" items="${orderForm.optionGiletWashableInfo.wgByColorMap}"/>
						</div>
                        <div id="wg_byColor_div">
                        <div class="offset-md-1">
                        <div class="form-check-inline form-check">
                            <form:select id="wg_byColorPlaceAll" path="optionGiletWashableInfo.wgByColorPlaceAll" class="form-control-sm form-control">
								<form:options items="${orderForm.optionGiletWashableInfo.wgByColorPlaceAllMap}"/>
							</form:select>&nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wg_byColorPlace">全選択</button>
                            &nbsp;
                            <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wg_byColorPlace">全解除</button>
                        </div>
                        </div>
                        <c:forEach var="wgByColorPlaceMap" items="${orderForm.optionGiletWashableInfo.wgByColorPlaceMap }" varStatus="row">
                        	<div class="offset-md-1">
                            <div class="form-check">
                            <div class="checkbox">
                            <label for="wg_byColorPlace" class="form-check-label ">
                                <input type="checkbox" id="wg_byColorPlace_${row.count}" name="optionGiletWashableInfo.wgByColorPlace${row.count}" value="${wgByColorPlaceMap.key }" class="form-check-input">${wgByColorPlaceMap.value }
                            </label>
                            </div>
                            </div>
                        	</div>
                        	<div class="offset-md-2" id="wg_byColorPlace_${row.count}_div" style="display:none">
                        		<c:forEach var="wgByColorsMap" items="${orderForm.optionGiletWashableInfo.wgByColorsMap}">
                        		  <div class="form-check-inline form-check">
                        		     <label for="wg_bhColor" class="form-check-label ">
                        			    <input type="radio" id="wg_byColor_${wgByColorsMap.key}" name="optionGiletWashableInfo.wgByColor${row.count}" value="${wgByColorsMap.key}" class="form-check-input">${wgByColorsMap.value}
                        		     </label>
                        		  </div>
                        		</c:forEach>
                        	</div>
                        </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">背裏地素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wg_backLiningMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="wg_backLiningMate" path="optionGiletWashableInfo.wgBackLiningMate" class="form-control-sm form-control">
							<form:options items="${orderForm.optionGiletWashableInfo.wgBackLiningMateMap}"/>
						</form:select>
                    </div>
                    <div class="col col-md-4">
                        <select name="wg_backLiningMateStkNo" id="wg_backLiningMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col col-md-2">
                        <button type="button" class="btn btn-outline-info btn-sm" id="btn_wg_backLiningMate">上着と同じ</button>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">内側裏地素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wg_insideLiningMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="wg_insideLiningMate" path="optionGiletWashableInfo.wgInsideLiningMate" class="form-control-sm form-control">
							<form:options items="${orderForm.optionGiletWashableInfo.wgInsideLiningMateMap}"/>
						</form:select>
                    </div>
                    <div class="col col-md-4">
                        <select name="wg_insideLiningMateStkNo" id="wg_insideLiningMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">釦素材</label>
                    <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wg_frontBtnMate"><i class="fa fa-question-circle text-danger"></i></button>
                    </div>
                    <div class="col col-md-3">
                    	<form:select id="wg_frontBtnMate" path="optionGiletWashableInfo.wgFrontBtnMate" class="form-control-sm form-control">
							<form:options items="${orderForm.optionGiletWashableInfo.wgFrontBtnMateMap}"/>
						</form:select>
                    </div>
                    <div class="col col-md-4">
                        <select name="wg_frontBtnMateStkNo" id="wg_frontBtnMateStkNo" class="form-control-sm form-control">
                        </select>
                    </div>
                    <div class="col col-md-2">
                        <button type="button" class="btn btn-outline-info btn-sm" id="btn_wg_frontBtnMate">上着と同じ</button>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">バックベルト</label></div>
                    <div class="col col-md-3">
                    	<form:select id="wg_backBelt" path="optionGiletWashableInfo.wgBackBelt" class="form-control-sm form-control">
							<form:options items="${orderForm.optionGiletWashableInfo.wgBackBeltMap}"/>
						</form:select>
                    </div>
                    <div class="col-12 col-md-9 offset-md-3" id="wg_backBeltMsg">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col col-md-3"><label class=" form-control-label">ウォッチチェーン</label></div>
                    <div class="col-12 col-md-9">
                    	<div class="form-check-inline form-check">
							<form:radiobuttons id="wg_watchChain_id" path="optionGiletWashableInfo.wgWatchChain" class="form-check-input" items="${orderForm.optionGiletWashableInfo.wgWatchChainMap}"/>
						</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="${orderForm.jacketItemFlag }"/>
	<input type="hidden" id="pantsItemFlag" name="pantsItemFlag" value="${orderForm.pantsItemFlag }"/>
	<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="0"/>
	<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="${orderForm.shirtItemFlag }"/>
	<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="${orderForm.coatItemFlag }"/>
	<input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="${orderForm.pants2ItemFlag }"/>
    
    <input type="hidden" id="giletFlag" name="giletFlag" value="0"/>
    
    <input type="hidden" id="giletAdFlag"
		name="giletAdFlag" value="0" />	
</form:form>

<!-- 自作js -->
<script src="${pageContext.request.contextPath}/resources/app/self/js/rule.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/config.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/customer.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/tabMenu.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/product.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.gilet.standard.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.gilet.tuxedo.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.gilet.washable.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";

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
	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });
	
	var productCategory = "${orderForm.productCategory}";

	getModelByItem(productCategory);

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
	//initCustomer();

	//--------------------------------------------
	// 商品タブ
	//--------------------------------------------
	initProduct();

	//--------------------------------------------
	// オプションタブ（Jacket）
	//--------------------------------------------
 	if(productCategory == "0"){
 		initOptionGiletStandard();
	}else if(productCategory == "2"){
		initOptionGiletTuxedo();
	}else if(productCategory == "1"){
		initOptionGiletWashable();
	}
 	
	//--------------------------------------------
	// 補正タブ
	//--------------------------------------------
	initAlter();

	mateInit();

	getPrice();
	
	jQuery("#giletItemFlag").val("1");

})	

function getModelByItem(productCategory){
	var glModel = null;
	
	if(productCategory == "0"){
		glModel = document.getElementById("giletModel");
	}else if(productCategory == "2"){
		glModel = document.getElementById("tg_giletModel");
	}else if(productCategory == "1"){
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
		if(category == "0"){
			initSuitStandard(itemCode);
		}else if(category == "2"){
			initSuitTuexdo(itemCode);
		}else if(category == "1"){
			initSuitWashable(itemCode);
		}
	}else if(item=="04"){
		subItemCode = "04";
		itemCode = item;
		if(category=="0"){
			initGlStandard(itemCode,subItemCode);
		}else if(category=="2"){
			initGlTuexdo(itemCode,subItemCode);
		}else if(category=="1"){
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


//--------------------------------------------
//全部のitem金額制御
//--------------------------------------------
function getPrice(){
// 	GILETの料金を表示
	jQuery("#giletModel").change(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});

		var giletModel = jQuery("#giletModel option:selected").val();
		var itemCode = "04";
		var subItemCode = jQuery("#item").val();

		var code = itemCode + subItemCode + giletModel;
		$.ajax({
			type:"get",
			url:contextPath + "/orderCo/getOrderPriceForGiletModel",
			data:{"code":code},
			dataType:"json",
			contentType:"application/json",
			async:false,
			success:function(result){
				var ogPriceMsg = document.getElementsByName("ogPriceMsg");
				for(var i=0; i<ogPriceMsg.length; i++){
					ogPriceMsg[i].innerHTML = result.ogPriceMsg[i];
				}
				getAllPrice(subItemCode, result.optionPrice);
			}
		});
		//document.getElementById("nav2_GILET").click();
	})
	
// 	プルダウンの変更処理
// 	項目：背裏地素材,背裏地品番,内側裏地素材,内側裏地品番,釦素材,釦品番
	jQuery("#og_backLiningMate,#og_backLiningMateStkNo,#og_insideLiningMate,#og_insideLiningMateStkNo,#og_frontBtnMate,#og_frontBtnMateStkNo,#og_backBelt")
	.change(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
	   
		var giletModel = jQuery("#giletModel option:selected").val();
		var itemCode = "04";
		var subItemCode = jQuery("#item").val();
		var idValueName = jQuery(this).attr("id");
		
		if(isNotEmpty(giletModel)){
			var code = itemCode + subItemCode + giletModel;
			jQuery.ajax({
				type:"get",
				url:contextPath + "/orderCo/getOrderPriceForGiletProject",
				data:{"code":code,"idValueName":idValueName},
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
				}
			});
		}

	});
	
// 	ラジオボタンの変更処理
// 	項目：チェンジポケット、スランテッドポケット、ベント、バックベルト、襟吊[id^="og_amfColor_id"],[id^="og_bhColor_id"],[id^="og_byColor_id"]
	jQuery('input[id^="og_breastPkt_id"],[id^="og_waistPkt_id"],[id^="og_waistPktSpec_id"],[id^="og_stitch_id"],[id^="og_stitchModify_id"],[id^="og_dStitchModify_id"],[id^="og_watchChain_id"]')
	.change(function(){
		jQuery.ajax({url:contextPath + "/orderCo/saveOptionData",data: jQuery('#idInfoForm').serialize(),type: "post",async:false});
		   
		var giletModel = jQuery("#giletModel option:selected").val();
		var itemCode = "04";
		var subItemCode = jQuery("#item").val();
		var idValueName = jQuery(this).attr("id");

		//IDの後の番号を削除します
		var findIdPosition = idValueName.indexOf("_id");
		var interceptedIdValueName = idValueName.substr(0, findIdPosition+3);
		 
		if(isNotEmpty(giletModel)){
			var code = itemCode + subItemCode + giletModel;
			jQuery.ajax({
				type:"get",
				url:contextPath + "/orderCo/getOrderPriceForGiletProject",
				data:{"code":code,"idValueName":interceptedIdValueName},
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

jQuery("#giletModel").change(function(){
	jQuery("#giletFlag").val("1");
})
jQuery("#tg_giletModel").change(function(){
	jQuery("#giletFlag").val("1");
})
jQuery("#wg_giletModel").change(function(){
	jQuery("#giletFlag").val("1");
})
</script>