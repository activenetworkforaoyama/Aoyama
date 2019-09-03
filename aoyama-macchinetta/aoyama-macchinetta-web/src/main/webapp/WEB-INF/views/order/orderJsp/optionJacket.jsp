<form:form id="idInfoForm" action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm" method="post" modelAttribute="orderForm" class="form-horizontal">
<div id="op_jacket_div">
            <div class="card-header">
                <strong class="card-title">JACKET</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">JACKETモデル</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_jacketModel"><i class="fa fa-question-circle text-danger"></i></button>
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
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_oj_frontBtnCnt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-3">
                                <form:select id="oj_frontBtnCnt" path="optionJacketStandardInfo.ojFrontBtnCnt" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionJacketStandardInfo.ojFrontBtnCntMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="oj_frontBtnCntMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_lapelDesign"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="lapelDesign_id" path="optionJacketStandardInfo.ojLapelDesign" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojLapelDesignMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="lapelDesignMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">グレード</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_grade"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="grade_id" path="optionJacketStandardInfo.ojGrade" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojGradeMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裏仕様</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_backSpec"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="backSpec" path="optionJacketStandardInfo.ojGackSpec" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionJacketStandardInfo.ojGackSpecMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="backSpecMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">台場</label></div>
                            <div class="col col-md-3">
                                <form:select id="fort" path="optionJacketStandardInfo.ojFort" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionJacketStandardInfo.ojFortMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="fortMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">襟裏（ヒゲ）</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="backCollar_id" path="optionJacketStandardInfo.ojBackCollar" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojBackCollarMap}"/>　
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="backCollarMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="chainHange_id" path="optionJacketStandardInfo.ojChainHange" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojChainHangeMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ラペル幅</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                   	<form:radiobuttons id="lapelWidth_id" path="optionJacketStandardInfo.ojLapelWidth" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojLapelWidthMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="lapelWidthMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラワーホール</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_flowerHole"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                                <form:select id="flowerHole" path="optionJacketStandardInfo.ojFlowerHole" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionJacketStandardInfo.ojFlowerHoleMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">胸ポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_breastPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="breastPkt_id" path="optionJacketStandardInfo.ojBreastPkt" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojBreastPktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="breastPktMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">腰ポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_waistPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-4">
                                <form:select id="waistPkt" path="optionJacketStandardInfo.ojWaistPkt" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionJacketStandardInfo.ojWaistPktMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_changePkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="changePkt_id" path="optionJacketStandardInfo.ojChangePkt" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojChangePktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="changePktMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="slantedPkt_id" path="optionJacketStandardInfo.ojSlantedPkt" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojSlantedPktMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="slantedPktMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col col-md-3">
                                <form:select id="coinPkt" path="optionJacketStandardInfo.ojCoinPkt" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionJacketStandardInfo.ojCoinPktMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <div class="form-check-inline form-check">
                                    	<form:radiobuttons id="sleeveSpec_id" path="optionJacketStandardInfo.ojSleeveSpec" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojSleeveSpecMap}"/>
                                	</div>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">マニカ</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="manica_id" path="optionJacketStandardInfo.ojManica" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojManicaMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖釦</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_sleeveBtnType"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="sleeveBtnType_id" path="optionJacketStandardInfo.ojSleeveBtnType" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojSleeveBtnTypeMap}"/>
                                    	　　袖釦数
                                    <a href="#" id="sleeveBtnCnt_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                    <!-- <input type="text" id="sleeveBtnCnt" name="optionJacketStandardInfo.ojSleeveBtnCnt" class="form-control-sm form-control" readonly style="width:36px">&nbsp; -->
                                    <form:input id="sleeveBtnCnt" path="optionJacketStandardInfo.ojSleeveBtnCnt" class="form-control-sm form-control" readonly = "true" style="width:36px"/>&nbsp;
                                    <a href="#" id="sleeveBtnCnt_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="sleeveBtnCntMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="cuffSpec_id" path="optionJacketStandardInfo.ojCuffSpec" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojCuffSpecMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">内ポケット変更</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="insidePktChange_id" path="optionJacketStandardInfo.ojInsidePktChange" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojInsidePktChangeMap}"/>
                                </div>
                                <div id="insidePktChange_yes_area">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_insidePktPlace">全選択</button>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_insidePktPlace">全解除</button>
                                </div>
                                </div>
                                <div id="inline-radio122_1" class="offset-md-1">
                                
                                    <%-- <form:checkboxes id="insidePktPlace_id" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojInsidePktPlaceMap}" path="optionJacketStandardInfo.ojInsidePktPlace"/> --%>
                                    <c:forEach var="ojInsidePktPlaceMap" items="${orderForm.optionJacketStandardInfo.ojInsidePktPlaceMap }" varStatus="row">
                                		<div class="form-check-inline form-check">
                                			<input type="checkbox" id="insidePktPlace_id${row.count}" name="optionJacketStandardInfo.ojInsidePktPlace${row.count}" value="${ojInsidePktPlaceMap.key}" class="form-check-input">${ojInsidePktPlaceMap.value}
                                		</div>
                                	</c:forEach>
                                
                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前胸内ポケット仕様</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="breastInnerPkt_id" path="optionJacketStandardInfo.ojBreastInnerPkt" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojBreastInnerPktMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_stitch"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="stitch_id" path="optionJacketStandardInfo.ojStitch" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojStitchMap}"/>
                                </div>
                            </div>
                        </div>
                        <div id="stitch_yes_area">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="stitchModify_id" path="optionJacketStandardInfo.ojStitchModify" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojStitchModifyMap}"/>
                                </div>
                                <div id="stitchModify_yes_area">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_stitchModifyPlace">全選択</button>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_stitchModifyPlace">全解除</button>
                                </div>
                                </div>
                                <div class="offset-md-1">
                                	<c:forEach var="ojStitchModifyPlaceMap" items="${orderForm.optionJacketStandardInfo.ojStitchModifyPlaceMap }" varStatus="row">
                                		<div class="form-check-inline form-check">
                                			<input type="checkbox" id="stitchModifyPlace_id${row.count}" name="optionJacketStandardInfo.ojStitchModifyPlace${row.count}" value="${ojStitchModifyPlaceMap.key}" class="form-check-input">${ojStitchModifyPlaceMap.value}
                                		</div>
                                	</c:forEach>
                                <%-- <div class="form-check-inline form-check">
                                	<form:checkboxes id="stitchModifyPlace_id" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojStitchModifyPlaceMap}" path="optionJacketStandardInfo.ojStitchModifyPlace"/>
                                </div> --%>
                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ダブルステッチ変更</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="dStitchModify_id" path="optionJacketStandardInfo.ojDStitchModify" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojDStitchModifyMap}"/>
                                </div>
                                <div id="dStitchModifyPlace">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_dStitchModifyPlace">全選択</button>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_dStitchModifyPlace">全解除</button>
                                </div>
                                </div>
                                <div class="offset-md-1">
                                <c:forEach var="ojDStitchModifyPlaceMap" items="${orderForm.optionJacketStandardInfo.ojDStitchModifyPlaceMap }" varStatus="row">
                                		<div class="form-check-inline form-check">
                                			<input type="checkbox" id="dStitchModifyPlace_id${row.count}" name="optionJacketStandardInfo.ojDStitchModifyPlace${row.count}" value="${ojDStitchModifyPlaceMap.key}" class="form-check-input">${ojDStitchModifyPlaceMap.value}
                                		</div>
                                </c:forEach>
                                <%-- <div class="form-check-inline form-check">
                                	<form:checkboxes id="dStitchModifyPlace_id" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojDStitchModifyPlaceMap}" path="optionJacketStandardInfo.ojDStitchModifyPlace"/>
                                </div> --%>
                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="amfColor_id" path="optionJacketStandardInfo.ojAmfColor" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojAmfColorMap}"/>
                                </div>
                                <div id="amfColor_div" style="display:none;">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="amfColorPlaceAll" path="optionJacketStandardInfo.ojAmfColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketStandardInfo.ojAmfColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_amfColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_amfColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="ojAmfColorPlaceMap" items="${orderForm.optionJacketStandardInfo.ojAmfColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="amfColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="amfColorPlace_${row.count}" name="optionJacketStandardInfo.ojAmfColorPlace${row.count}" value="${ojAmfColorPlaceMap.key }" class="form-check-input">${ojAmfColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="amfColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="ojAmfColorsMap" items="${orderForm.optionJacketStandardInfo.ojAmfColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="amfColor" class="form-check-label ">
                                			    <input type="radio" id="amfColor_${ojAmfColorsMap.key}" name="optionJacketStandardInfo.ojAmfColor${row.count}" value="${ojAmfColorsMap.key}" class="form-check-input">${ojAmfColorsMap.value}
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
                                    <form:radiobuttons id="bhColor_id" path="optionJacketStandardInfo.ojBhColor" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojBhColorMap}"/>
                                </div>
                                <div id="bhColor_div" style="display:none;">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="bhColorPlaceAll" path="optionJacketStandardInfo.ojBhColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketStandardInfo.ojBhColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="ojBhColorPlaceMap" items="${orderForm.optionJacketStandardInfo.ojBhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="bhColorPlace_${row.count}" name="optionJacketStandardInfo.ojBhColorPlace${row.count}" value="${ojBhColorPlaceMap.key }" class="form-check-input">${ojBhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="bhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="ojpBhColorsMap" items="${orderForm.optionJacketStandardInfo.ojBhColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="bhColor" class="form-check-label ">
                                			    <input type="radio" id="bhColor_${opAmfColorsMap.key}" name="optionJacketStandardInfo.ojBhColor${row.count}" value="${ojpBhColorsMap.key}" class="form-check-input">${ojpBhColorsMap.value}
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
                                    <form:radiobuttons id="byColor_id" path="optionJacketStandardInfo.ojByColor" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojByColorMap}"/>
                                </div>
                                <div id="byColor_div" style="display:none;">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="byColorPlaceAll" path="optionJacketStandardInfo.ojByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketStandardInfo.ojByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_byColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="ojByColorPlaceMap" items="${orderForm.optionJacketStandardInfo.ojByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="byColorPlace_${row.count}" name="optionJacketStandardInfo.ojByColorPlace${row.count}" value="${ojByColorPlaceMap.key }" class="form-check-input">${ojByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="ojByColorsMap" items="${orderForm.optionJacketStandardInfo.ojByColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="byColor" class="form-check-label ">
                                			    <input type="radio" id="byColor_${ojByColorsMap.key}" name="optionJacketStandardInfo.ojByColor${row.count}" value="${ojByColorsMap.key}" class="form-check-input">${ojByColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="ventSpec_id" path="optionJacketStandardInfo.ojVentSpec" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojVentSpecMap}"/>
                                </div>
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
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
                            <div class="col col-md-3">
                                <form:select id="cuffBackMate" path="optionJacketStandardInfo.ojCuffBackMate" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketStandardInfo.ojCuffBackMateMap}"/>
                                </form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionJacketStandardInfo.ojCuffBackMateStkNo" id="cuffBackMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
<!--
                            <div class="col col-md-2">
                                <button type="button" class="btn btn-outline-info btn-sm" id="btn_cuffBackMate">胴裏と同じ</button>
                            </div>
-->
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
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                    <form:radiobuttons id="shapeMemory_id" path="optionJacketStandardInfo.ojShapeMemory" class="form-check-input" items="${orderForm.optionJacketStandardInfo.ojShapeMemoryMap}"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div></div>
            
            <div id="tu_jacket_div">
            <div class="card-header">
                <strong class="card-title">JACKET</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">JACKETモデル</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tj_jacketModel"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="tj_jacketModel" path="optionJacketTuxedoInfo.tjJacketModel" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionJacketTuxedoInfo.tjJacketModelMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tj_jacketModelMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント釦数</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tj_frontBtnCnt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-3">
                            	<form:select id="tj_frontBtnCnt" path="optionJacketTuxedoInfo.tjFrontBtnCnt" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionJacketTuxedoInfo.tjFrontBtnCntMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tj_frontBtnCntMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tj_lapelDesign"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                                <div class="form-check-inline form-check">
                                     <form:radiobuttons id="tp_lapelDesign_id" path="optionJacketTuxedoInfo.tjLapelDesign" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjLapelDesignMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tj_lapelDesignMsg">
                            </div>
                        </div>
                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">グレード</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tj_grade"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                     <form:radiobuttons id="tj_grade_id" path="optionJacketTuxedoInfo.tjGrade" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjGradeMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裏仕様</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tj_backSpec" path="optionJacketTuxedoInfo.tjBackSpec" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionJacketTuxedoInfo.tjBackSpecMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tj_backSpecMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">台場</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tj_fort" path="optionJacketTuxedoInfo.tjFort" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionJacketTuxedoInfo.tjFortMap}"/>
                                </form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tj_fortMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">拝絹地</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tj_GlossFablic" path="optionJacketTuxedoInfo.tjGlossFablic" class="form-control-sm form-control">
                                	<form:options items="${orderForm.optionJacketTuxedoInfo.tjGlossFablicMap}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">襟裏（ヒゲ）</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                     <form:radiobuttons id="tj_backCollar_id" path="optionJacketTuxedoInfo.tjBackCollar" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjBackCollarMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tj_backCollarMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                     <form:radiobuttons id="tj_chainHange_id" path="optionJacketTuxedoInfo.tjChainHange" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjChainHangeMap}"/>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ラペル幅</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                     <form:radiobuttons id="tj_lapelWidth_id" path="optionJacketTuxedoInfo.tjLapelWidth" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjLapelWidthMap}"/>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tj_lapelWidthMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラワーホール</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tj_flowerHole"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
	                            <form:select id="tj_flowerHole" path="optionJacketTuxedoInfo.tjFlowerHole" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketTuxedoInfo.tjFlowerHoleMap}"/>
								</form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="tj_breastPkt_id" path="optionJacketTuxedoInfo.tjBreastPkt" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjBreastPktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tj_breastPktMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">腰ポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tj_waistPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-4">
                            	<form:select id="tj_waistPkt" path="optionJacketTuxedoInfo.tjWaistPkt" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketTuxedoInfo.tjWaistPktMap}"/>
								</form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tj_changePkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="tj_changePkt_id" path="optionJacketTuxedoInfo.tjChangePkt" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjChangePktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tj_changePktMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="tj_slantedPkt_id" path="optionJacketTuxedoInfo.tjSlantedPkt" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjSlantedPktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tj_slantedPktMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tj_coinPkt" path="optionJacketTuxedoInfo.tjCoinPkt" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketTuxedoInfo.tjCoinPktMap}"/>
								</form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="tj_sleeveSpec_id" path="optionJacketTuxedoInfo.tjSleeveSpec" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjSleeveSpecMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">マニカ</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="tj_manica_id" path="optionJacketTuxedoInfo.tjManica" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjManicaMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖釦</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_tj_sleeveBtnType"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="tj_sleeveBtnType_id" path="optionJacketTuxedoInfo.tjSleeveBtnType" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjSleeveBtnTypeMap}"/>
									袖釦数
									<a href="#" id="tj_sleeveBtnCnt_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                    <!-- <input type="text" id="tj_sleeveBtnCnt" name="optionJacketTuxedoInfo.tjSleeveBtnCnt" value="4" class="form-control-sm form-control" readonly style="width:36px">&nbsp; -->
                                    <form:input id="tj_sleeveBtnCnt" path="optionJacketTuxedoInfo.tjSleeveBtnCnt" class="form-control-sm form-control" readonly = "true" style="width:36px"/>&nbsp;
                                    <a href="#" id="tj_sleeveBtnCnt_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="tj_sleeveBtnCntMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="tj_cuffSpec_id" path="optionJacketTuxedoInfo.tjCuffSpec" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjCuffSpecMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">内ポケット変更</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="tj_insidePktChange_id" path="optionJacketTuxedoInfo.tjInsidePktChange" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjInsidePktChangeMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前胸内ポケット仕様</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="tj_breastInnerPkt_id" path="optionJacketTuxedoInfo.tjBreastInnerPkt" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjBreastInnerPktMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="tj_stitch_id" path="optionJacketTuxedoInfo.tjStitch" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjStitchMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ボタンホール色指定</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
                                    <form:radiobuttons id="tj_bhColor_id" path="optionJacketTuxedoInfo.tjBhColor" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjBhColorMap}"/>
                                </div>
                                <div id="tj_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="tj_bhColorPlaceAll" path="optionJacketTuxedoInfo.tjBhColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketTuxedoInfo.tjBhColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tj_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tj_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="tjBhColorPlaceMap" items="${orderForm.optionJacketTuxedoInfo.tjBhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="tj_bhColorPlace_${row.count}" class="form-check-label ">
                                        <input type="checkbox" id="tj_bhColorPlace_${row.count}" name="optionJacketTuxedoInfo.tjBhColorPlace${row.count}" value="${tjBhColorPlaceMap.key }" class="form-check-input">${tjBhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="tj_bhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="tjBhColorsMap" items="${orderForm.optionJacketTuxedoInfo.tjBhColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="bhColor" class="form-check-label ">
                                			    <input type="radio" id="bhColor_${tjBhColorsMap.key}" name="optionJacketTuxedoInfo.tjBhColor${row.count}" value="${tjBhColorsMap.key}" class="form-check-input">${tjBhColorsMap.value}
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
                                    <form:radiobuttons id="tj_byColor_id" path="optionJacketTuxedoInfo.tjByColor" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjByColorMap}"/>
                                </div>
                                <div id="tj_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="tj_byColorPlaceAll" path="optionJacketTuxedoInfo.tjByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketTuxedoInfo.tjByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_tj_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_tj_byColorPlace">全解除</button>
                                </div>
                                </div>
                                 <c:forEach var="tjByColorPlaceMap" items="${orderForm.optionJacketTuxedoInfo.tjByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="tj_byColorPlace_${row.count}" class="form-check-label ">
                                        <input type="checkbox" id="tj_byColorPlace_${row.count}" name="optionJacketTuxedoInfo.tjByColorPlace${row.count}" value="${tjByColorPlaceMap.key }" class="form-check-input">${tjByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="tj_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="tjByColorsMap" items="${orderForm.optionJacketTuxedoInfo.tjByColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="byColor" class="form-check-label ">
                                			    <input type="radio" id="byColor_${tjByColorsMap.key}" name="optionJacketTuxedoInfo.tjByColor${row.count}" value="${tjByColorsMap.key}" class="form-check-input">${tjByColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="tj_ventSpec_id" path="optionJacketTuxedoInfo.tjVentSpec" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjVentSpecMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tj_bodyBackMate" path="optionJacketTuxedoInfo.tjBodyBackMate" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketTuxedoInfo.tjBodyBackMateMap}"/>
								</form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionJacketTuxedoInfo.tjBodyBackMateStkNo" id="tj_bodyBackMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tj_cuffBackMate" path="optionJacketTuxedoInfo.tjCuffBackMate" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketTuxedoInfo.tjCuffBackMateMap}"/>
								</form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionJacketTuxedoInfo.tjCuffBackMateStkNo" id="tj_cuffBackMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
                            <div class="col col-md-3">
                            	<form:select id="tj_btnMate" path="optionJacketTuxedoInfo.tjBtnMate" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketTuxedoInfo.tjBtnMateMap}"/>
								</form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionJacketTuxedoInfo.tjBtnMateStkNo" id="tj_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="tj_shapeMemory_id" path="optionJacketTuxedoInfo.tjShapeMemory" class="form-check-input" items="${orderForm.optionJacketTuxedoInfo.tjShapeMemoryMap}"/>
								</div>
                            </div>
                        </div>
                    </div>
                </div>

            </div></div>
            
            <div id="wa_jacket_div">
            <div class="card-header">
                <strong class="card-title">JACKET</strong>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col col-lg-12">
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">JACKETモデル</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wj_jacketModel"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wj_jacketModel" path="optionJacketWashableInfo.wjJacketModel" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketWashableInfo.wjJacketModelMap}"/>
								</form:select>
							</div>
                            <div class="col-12 col-md-9 offset-md-3" id="wj_jacketModelMsg"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フロント釦数</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wj_frontBtnCnt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-3">
                            	<form:select id="wj_frontBtnCnt" path="optionJacketWashableInfo.wjFrontBtnCnt" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketWashableInfo.wjFrontBtnCntMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wj_frontBtnCntMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ラペルデザイン</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wj_lapelDesign"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="tj_lapelDesign_id" path="optionJacketWashableInfo.wjLapelDesign" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjLapelDesignMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wj_lapelDesignMsg">
                            </div>
                        </div>
                        <!-- 一旦は非表示
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ラペルモデル</label></div>
                            <div class="col col-md-3">
                                <select name="wj_lapelModel" id="wj_lapelModel" class="form-control-sm form-control">
                                    <option value="TR02">TR02</option>
                                    <option value="CH14">CH14</option>
                                    <option value="NR05">NR05</option>
                                    <option value="NZ01">NZ01</option>
                                    <option value="BS05">BS05</option>
                                </select>
                            </div>
                        </div>
                        -->
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">グレード</label>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_grade_id" path="optionJacketWashableInfo.wjGrade" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjGradeMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">裏仕様</label>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wj_backSpec" path="optionJacketWashableInfo.wjBackSpec" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketWashableInfo.wjBackSpecMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wj_backSpecMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">台場</label></div>
                            <div class="col col-md-3">
                            	<form:select id="wj_fort" path="optionJacketWashableInfo.wjFort" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketWashableInfo.wjFortMap}"/>
								</form:select>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wj_fortMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">襟裏（ヒゲ）</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_backCollar_id" path="optionJacketWashableInfo.wjBackCollar" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjBackCollarMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wj_backCollarMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">襟吊</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_chainHange_id" path="optionJacketWashableInfo.wjChainHange" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjChainHangeMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ラペル幅</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_lapelWidth_id" path="optionJacketWashableInfo.wjLapelWidth" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjLapelWidthMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wj_lapelWidthMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">フラワーホール</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wj_flowerHole"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-3">
                            	<form:select id="wj_flowerHole" path="optionJacketWashableInfo.wjFlowerHole" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketWashableInfo.wjFlowerHoleMap}"/>
								</form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">胸ポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_breastPkt_id" path="optionJacketWashableInfo.wjBreastPkt" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjBreastPktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wj_breastPktMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">腰ポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wj_waistPkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col col-md-4">
                            	<form:select id="wj_waistPkt" path="optionJacketWashableInfo.wjWaistPkt" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketWashableInfo.wjWaistPktMap}"/>
								</form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">チェンジポケット</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wj_changePkt"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_changePkt_id" path="optionJacketWashableInfo.wjChangePkt" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjChangePktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wj_changePktMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">スランテッドポケット</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_slantedPkt_id" path="optionJacketWashableInfo.wjSlantedPkt" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjSlantedPktMap}"/>
								</div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wj_slantedPktMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">忍びポケット</label></div>
                            <div class="col col-md-3">
                            	<form:select id="wj_coinPkt" path="optionJacketWashableInfo.wjCoinPkt" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketWashableInfo.wjCoinPktMap}"/>
								</form:select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖仕様</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_sleeveSpec_id" path="optionJacketWashableInfo.wjSleeveSpec" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjSleeveSpecMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">マニカ</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_manica_id" path="optionJacketWashableInfo.wjManica" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjManicaMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖釦</label>
                            <button type="button" class="btn btn-link btn-sm" data-toggle="modal" data-target="#infotext_wj_sleeveBtnType"><i class="fa fa-question-circle text-danger"></i></button>
                            </div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_sleeveBtnTypeKasane_id" path="optionJacketWashableInfo.wjSleeveBtnType" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjSleeveBtnTypeMap}"/>
									袖釦数　
                                    <a href="#" id="wj_sleeveBtnCnt_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                    <!-- <input type="text" id="wj_sleeveBtnCnt" name="optionJacketWashableInfo.wjSleeveBtnCnt" value="4" class="form-control-sm form-control" readonly style="width:36px">&nbsp; -->
                                    <form:input id="wj_sleeveBtnCnt" path="optionJacketWashableInfo.wjSleeveBtnCnt" class="form-control-sm form-control" readonly = "true" style="width:36px"/>&nbsp;
                                    <a href="#" id="wj_sleeveBtnCnt_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                </div>
                            </div>
                            <div class="col-12 col-md-9 offset-md-3" id="wj_sleeveBtnCntMsg">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖口</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_cuffSpec_id" path="optionJacketWashableInfo.wjCuffSpec" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjCuffSpecMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">内ポケット変更</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_insidePktChange_id" path="optionJacketWashableInfo.wjInsidePktChange" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjInsidePktChangeMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">下前胸内ポケット仕様</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_breastInnerPkt_id" path="optionJacketWashableInfo.wjBreastInnerPkt" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjBreastInnerPktMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ種類</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_stitch_id" path="optionJacketWashableInfo.wjStitch" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjStitchMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ステッチ箇所変更</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_stitchModify_id" path="optionJacketWashableInfo.wjStitchModify" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjStitchModifyMap}"/>
								</div>
                                <div id="wj_stitchModifyPlace">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wj_stitchModifyPlace">全選択</button>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wj_stitchModifyPlace">全解除</button>
                                </div>
                                </div>
                                <div class="offset-md-1">
                                <%-- <div class="form-check-inline form-check">
                                	<form:checkboxes id="wj_stitchModifyPlace_id" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjStitchModifyPlaceMap}" path="optionJacketWashableInfo.wjStitchModifyPlace"/>
                                </div> --%>
                                <c:forEach var="wjStitchModifyPlaceMap" items="${orderForm.optionJacketWashableInfo.wjStitchModifyPlaceMap }" varStatus="row">
                                	<div class="form-check-inline form-check">
                                		<input type="checkbox" id="wj_stitchModifyPlace_id${row.count}" name="optionJacketWashableInfo.wjStitchModifyPlace${row.count}" value="${wjStitchModifyPlaceMap.key}" class="form-check-input">${wjStitchModifyPlaceMap.value}
                                	</div>
                                </c:forEach>
                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ダブルステッチ変更</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_dStitch_id" path="optionJacketWashableInfo.wjDStitchModify" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjDStitchModifyMap}"/>
								</div>
                                <div id="wj_dStitchPlace">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wj_dStitchPlace">全選択</button>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wj_dStitchPlace">全解除</button>
                                </div>
                                </div>
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                	<%-- <form:checkboxes id="wj_dStitchPlace_id" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjDStitchModifyPlaceMap}" path="optionJacketWashableInfo.wjDStitchModifyPlace"/> --%>
                                	<c:forEach var="wjDStitchModifyPlaceMap" items="${orderForm.optionJacketWashableInfo.wjDStitchModifyPlaceMap}" varStatus="row">
                                		<div class="form-check-inline form-check">
                                			<input type="checkbox" id="wj_dStitchPlace_id${row.count}" name="optionJacketWashableInfo.wjDStitchModifyPlace${row.count}" value="${wjDStitchModifyPlaceMap.key}" class="form-check-input">${wjDStitchModifyPlaceMap.value}
                                		</div>
                                	</c:forEach>
                                </div>
                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">AMF色指定</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_amfColor_id" path="optionJacketWashableInfo.wjAmfColor" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjAmfColorMap}"/>
								</div>
                                <div id="wj_amfColor_div" style="display:none;">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="wj_amfColorPlaceAll" path="optionJacketWashableInfo.wjAmfColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketWashableInfo.wjAmfColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wj_amfColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wj_amfColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wjAmfColorPlaceMap" items="${orderForm.optionJacketWashableInfo.wjAmfColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wj_amfColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wj_amfColorPlace_${row.count}" name="optionJacketWashableInfo.wjAmfColorPlace${row.count}" value="${wjAmfColorPlaceMap.key }" class="form-check-input">${wjAmfColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="wj_amfColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wjAmfColorsMap" items="${orderForm.optionJacketWashableInfo.wjAmfColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wj_amfColor" class="form-check-label ">
                                			    <input type="radio" id="wj_amfColor_${wjAmfColorsMap.key}" name="optionJacketWashableInfo.wjAmfColor${row.count}" value="${wjAmfColorsMap.key}" class="form-check-input">${wjAmfColorsMap.value}
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
									<form:radiobuttons id="wj_bhColor_id" path="optionJacketWashableInfo.wjBhColor" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjBhColorMap}"/>
								</div>
                                <div id="wj_bhColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="wj_bhColorPlaceAll" path="optionJacketWashableInfo.wjBhColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketWashableInfo.wjBhColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wj_bhColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wj_bhColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wjBhColorPlaceMap" items="${orderForm.optionJacketWashableInfo.wjBhColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wj_bhColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wj_bhColorPlace_${row.count}" name="optionJacketWashableInfo.wjBhColorPlace${row.count}" value="${wjBhColorPlaceMap.key }" class="form-check-input">${wjBhColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="wj_bhColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wjBhColorsMap" items="${orderForm.optionJacketWashableInfo.wjBhColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wj_bhColor" class="form-check-label ">
                                			    <input type="radio" id="wj_bhColor_${wjBhColorsMap.key}" name="optionJacketWashableInfo.wjBhColor${row.count}" value="${wjBhColorsMap.key}" class="form-check-input">${wjBhColorsMap.value}
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
									<form:radiobuttons id="wj_byColor_id" path="optionJacketWashableInfo.wjByColor" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjByColorMap}"/>
								</div>
                                <div id="wj_byColor_div">
                                <div class="offset-md-1">
                                <div class="form-check-inline form-check">
                                    <form:select id="wj_byColorPlaceAll" path="optionJacketWashableInfo.wjByColorPlaceAll" class="form-control-sm form-control">
                                    	<form:options items="${orderForm.optionJacketWashableInfo.wjByColorPlaceAllMap}"/>
                                    </form:select>&nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_as_wj_byColorPlace">全選択</button>
                                    &nbsp;
                                    <button type="button" class="btn btn-outline-info btn-sm" id="btn_ar_wj_byColorPlace">全解除</button>
                                </div>
                                </div>
                                <c:forEach var="wjByColorPlaceMap" items="${orderForm.optionJacketWashableInfo.wjByColorPlaceMap }" varStatus="row">
                                	<div class="offset-md-1">
                                    <div class="form-check">
                                    <div class="checkbox">
                                    <label for="wj_byColorPlace" class="form-check-label ">
                                        <input type="checkbox" id="wj_byColorPlace_${row.count}" name="optionJacketWashableInfo.wjByColorPlace${row.count}" value="${wjByColorPlaceMap.key }" class="form-check-input">${wjByColorPlaceMap.value }
                                    </label>
                                    </div>
                                    </div>
                                	</div>
                                	<div class="offset-md-2" id="wj_byColorPlace_${row.count}_div" style="display:none">
                                		<c:forEach var="wjByColorsMap" items="${orderForm.optionJacketWashableInfo.wjByColorPlaceAllMap}">
                                		  <div class="form-check-inline form-check">
                                		     <label for="wj_byColor" class="form-check-label ">
                                			    <input type="radio" id="wj_byColor_${wjByColorsMap.key}" name="optionJacketWashableInfo.wjByColor${row.count}" value="${wjByColorsMap.key}" class="form-check-input">${wjByColorsMap.value}
                                		     </label>
                                		  </div>
                                		</c:forEach>
                                	</div>
                                </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">ベント</label></div>
                            <div class="col-12 col-md-9">
                            	<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_ventSpec_id" path="optionJacketWashableInfo.wjVentSpec" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjVentSpecMap}"/>
								</div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">胴裏素材</label></div>
                            <div class="col col-md-3">
                            	<form:select id="wj_bodyBackMate" path="optionJacketWashableInfo.wjBodyBackMate" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketWashableInfo.wjBodyBackMateMap}"/>
								</form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionJacketWashableInfo.wjBodyBackMateStkNo" id="wj_bodyBackMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">袖裏素材</label></div>
                            <div class="col col-md-3">
                            	<form:select id="wj_cuffBackMate" path="optionJacketWashableInfo.wjCuffBackMate" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketWashableInfo.wjCuffBackMateMap}"/>
								</form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionJacketWashableInfo.wjCuffBackMateStkNo" id="wj_cuffBackMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">釦素材</label></div>
                            <div class="col col-md-3">
                            	<form:select id="wj_btnMate" path="optionJacketWashableInfo.wjBtnMate" class="form-control-sm form-control">
									<form:options items="${orderForm.optionJacketWashableInfo.wjBtnMateMap}"/>
								</form:select>
                            </div>
                            <div class="col col-md-4">
                                <select name="optionJacketWashableInfo.wjBtnMateStkNo" id="wj_btnMateStkNo" class="form-control-sm form-control">
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label class=" form-control-label">形状記憶</label></div>
                            <div class="col-12 col-md-9">
                           		<div class="form-check-inline form-check">
									<form:radiobuttons id="wj_shapeMemory_id" path="optionJacketWashableInfo.wjShapeMemory" class="form-check-input" items="${orderForm.optionJacketWashableInfo.wjShapeMemoryMap}"/>
								</div>
                            </div>
                        </div>
                    </div>
                </div>

            </div></div>
            <input type="hidden" id="jacketItemFlag" name="jacketItemFlag" value="0"/>
			<input type="hidden" id="pantsItemFlag" name="pantsItemFlag" value="${orderForm.pantsItemFlag }"/>
			<input type="hidden" id="giletItemFlag" name="giletItemFlag" value="${orderForm.giletItemFlag }"/>
			<input type="hidden" id="shirtItemFlag" name="shirtItemFlag" value="${orderForm.shirtItemFlag }"/>
			<input type="hidden" id="coatItemFlag" name="coatItemFlag" value="${orderForm.coatItemFlag }"/>
			<input type="hidden" id="pants2ItemFlag" name="pants2ItemFlag" value="${orderForm.pants2ItemFlag }"/>
			
            <input type="hidden" id="jacketFlag" name="jacketFlag" value="0"/>
            
</form:form>
<!-- 標準 JACKET JACKETモデル -->
<div class="modal fade" id="infotext_jacketModel" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">JACKETモデル</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                JACKETモデル選択時に連動して変更される可能性がある項目<br />
                ・フロント釦数<br />
                ・ラペルデザイン<br />
                ・襟裏（ヒゲ）<br />
                ・ラペル幅<br />
                ・胸ポケット<br />
                ・袖釦<br />
                ・袖釦数<br />
                ・ステッチ箇所変更<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定<br />
                ・ベント
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 JACKET フロント釦数 -->
<div class="modal fade" id="infotext_oj_frontBtnCnt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フロント釦数</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フロント釦数選択時に連動して変更される可能性がある項目<br />
                ・ラペルデザイン<br />
                ・襟裏（ヒゲ）<br />
                ・ラペル幅<br />
                ・胸ポケット<br />
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

<!-- 標準 JACKET ラペルデザイン-->
<div class="modal fade" id="infotext_lapelDesign" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ラペルデザイン</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ラペルデザイン選択時に連動して変更される可能性がある項目<br />
                ・襟裏（ヒゲ）<br />
                ・ラペル幅<br />
                ・ステッチ箇所変更
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 JACKET グレード-->
<div class="modal fade" id="infotext_grade" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">グレード</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                グレード選択時に連動して変更される可能性がある項目<br />
                ・裏仕様<br />
                ・台場
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 JACKET 裏仕様-->
<div class="modal fade" id="infotext_backSpec" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">裏仕様</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                裏仕様選択時に連動して変更される可能性がある項目<br />
                ・台場
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 JACKET フラワーホール-->
<div class="modal fade" id="infotext_flowerHole" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フラワーホール</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フラワーホール選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 JACKET 胸ポケット-->
<div class="modal fade" id="infotext_breastPkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">胸ポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                胸ポケット選択時に連動して変更される可能性がある項目<br />
                ・ダブルステッチ変更
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 JACKET 腰ポケット-->
<div class="modal fade" id="infotext_waistPkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">腰ポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                腰ポケット選択時に連動して変更される可能性がある項目<br />
                ・チェンジポケット<br />
                ・スランテッドポケット<br />
                ・ダブルステッチ変更
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 JACKET チェンジポケット-->
<div class="modal fade" id="infotext_changePkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">チェンジポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                チェンジポケット選択時に連動して変更される可能性がある項目<br />
                ・スランテッドポケット
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 JACKET 袖釦-->
<div class="modal fade" id="infotext_sleeveBtnType" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">袖釦</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                袖釦選択時に連動して変更される可能性がある項目<br />
                ・袖釦数
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- 標準 JACKET AMFステッチ-->
<div class="modal fade" id="infotext_stitch" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
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
                ・ダブルステッチ変更<br />
                ・AMF色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>
<!-- タキシード JACKET JACKETモデル -->
<div class="modal fade" id="infotext_tj_jacketModel" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">JACKETモデル</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                JACKETモデル選択時に連動して変更される可能性がある項目<br />
                ・フロント釦数<br />
                ・ラペルデザイン<br />
                ・襟裏（ヒゲ）<br />
                ・ラペル幅<br />
                ・胸ポケット<br />
                ・袖釦<br />
                ・袖釦数<br />
                ・ボタンホール色指定<br />
                ・ベント
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード JACKET フロント釦数 -->
<div class="modal fade" id="infotext_tj_frontBtnCnt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フロント釦数</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フロント釦数選択時に連動して変更される可能性がある項目<br />
                ・ラペルデザイン<br />
                ・襟裏（ヒゲ）<br />
                ・ラペル幅<br />
                ・胸ポケット<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード JACKET ラペルデザイン-->
<div class="modal fade" id="infotext_tj_lapelDesign" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ラペルデザイン</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ラペルデザイン選択時に連動して変更される可能性がある項目<br />
                ・襟裏（ヒゲ）<br />
                ・ラペル幅
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード JACKET グレード-->
<div class="modal fade" id="infotext_tj_grade" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">グレード</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                グレード選択時に連動して変更される可能性がある項目<br />
                ・裏仕様
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード JACKET フラワーホール-->
<div class="modal fade" id="infotext_tj_flowerHole" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フラワーホール</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フラワーホール選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード JACKET 腰ポケット-->
<div class="modal fade" id="infotext_tj_waistPkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">腰ポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                腰ポケット選択時に連動して変更される可能性がある項目<br />
                ・チェンジポケット<br />
                ・スランテッドポケット
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード JACKET チェンジポケット-->
<div class="modal fade" id="infotext_tj_changePkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">チェンジポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                チェンジポケット選択時に連動して変更される可能性がある項目<br />
                ・スランテッドポケット
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- タキシード JACKET 袖釦-->
<div class="modal fade" id="infotext_tj_sleeveBtnType" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">袖釦</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                袖釦選択時に連動して変更される可能性がある項目<br />
                ・袖釦数
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル JACKET JACKETモデル -->
<div class="modal fade" id="infotext_wj_jacketModel" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">JACKETモデル</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                JACKETモデル選択時に連動して変更される可能性がある項目<br />
                ・フロント釦数<br />
                ・ラペルデザイン<br />
                ・襟裏（ヒゲ）<br />
                ・ラペル幅<br />
                ・胸ポケット<br />
                ・袖釦<br />
                ・袖釦数<br />
                ・ステッチ箇所変更<br />
                ・ボタンホール色指定<br />
                ・ボタン付け糸指定<br />
                ・ベント
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル JACKET フロント釦数 -->
<div class="modal fade" id="infotext_wj_frontBtnCnt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フロント釦数</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フロント釦数選択時に連動して変更される可能性がある項目<br />
                ・ラペルデザイン<br />
                ・襟裏（ヒゲ）<br />
                ・ラペル幅<br />
                ・胸ポケット<br />
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

<!-- ウォッシャブル JACKET ラペルデザイン-->
<div class="modal fade" id="infotext_wj_lapelDesign" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">ラペルデザイン</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                ラペルデザイン選択時に連動して変更される可能性がある項目<br />
                ・襟裏（ヒゲ）<br />
                ・ラペル幅<br />
                ・ステッチ箇所変更
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル JACKET フラワーホール-->
<div class="modal fade" id="infotext_wj_flowerHole" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">フラワーホール</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                フラワーホール選択時に連動して変更される可能性がある項目<br />
                ・ボタンホール色指定
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル JACKET 腰ポケット-->
<div class="modal fade" id="infotext_wj_waistPkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">腰ポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                腰ポケット選択時に連動して変更される可能性がある項目<br />
                ・チェンジポケット<br />
                ・スランテッドポケット
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル JACKET チェンジポケット-->
<div class="modal fade" id="infotext_wj_changePkt" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">チェンジポケット</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                チェンジポケット選択時に連動して変更される可能性がある項目<br />
                ・スランテッドポケット
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
            </div>
        </div>
    </div>
</div>

<!-- ウォッシャブル JACKET 袖釦-->
<div class="modal fade" id="infotext_wj_sleeveBtnType" tabindex="-1" role="dialog" aria-labelledby="mediumModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mediumModalLabel">袖釦</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>
                <br />
                袖釦選択時に連動して変更される可能性がある項目<br />
                ・袖釦数
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
<script src="${pageContext.request.contextPath}/resources/app/self/js/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/product.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.jacket.standard.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.jacket.tuxedo.js"></script>
<script src="${pageContext.request.contextPath}/resources/app/self/js/option.jacket.washable.js"></script>
<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";

var selectIdList = {
	"bodyBackMate":"00038",
	"cuffBackMate":"00040",
	"btnMate":"00042",
	"tj_bodyBackMate":"00038",
	"tj_cuffBackMate":"00040",
	"tj_btnMate":"00042",
	"wj_bodyBackMate":"00038",
	"wj_cuffBackMate":"00040",
	"wj_btnMate":"00042"
};

jQuery(function() {

	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });

	var productCategory = jQuery('input[name="productCategory"]:checked').val();

	setJacketModelDisable(productCategory);
	
	//--------------------------------------------
	// 共通
	//--------------------------------------------
	initCommon();

	//--------------------------------------------
	// タブメニュー
	//--------------------------------------------
	initTabMenu();

	//--------------------------------------------
	// 商品タブ
	//--------------------------------------------
	initProduct();

	//--------------------------------------------
	// オプションタブ（Jacket）
	//--------------------------------------------
	if(productCategory == "0"){
		initOptionJacketStandard();
	}else if(productCategory == "2"){
		initOptionJacketTuxedo();
	}else if(productCategory == "1"){
		initOptionJacketWashable();
	}
	
	mateInit();
	
	jQuery("#jacketItemFlag").val("1");

})	

function setJacketModelDisable(productCategory){
	var jkModel = null;
	if(productCategory == "0"){
		jkModel = document.getElementById("jacketModel");
	}else if(productCategory == "2"){
		jkModel = document.getElementById("tj_jacketModel");
	}else if(productCategory == "1"){
		jkModel = document.getElementById("wj_jacketModel");
	}
	var allJkOption = jkModel.options;
	allJkOption[0].disabled = true;
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
	// 標準の場合　Jacket 胴裏素材と袖裏素材と釦素材のid List
	var jkStandardMateList = ["bodyBackMate","cuffBackMate","btnMate"];
	// タキシードの場合　Jacket 胴裏素材と袖裏素材と釦素材のid List
	var jkTuexdoMateList = ["tj_bodyBackMate","tj_cuffBackMate","tj_btnMate"];
	// ウォッシャブルの場合　Jacket 胴裏素材と袖裏素材と釦素材のid List
	var jkWashableMateList = ["wj_bodyBackMate","wj_cuffBackMate","wj_btnMate"];
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
	}else if(item=="02"){
		subItemCode = "02";
		itemCode = item;
		if(category=="0"){
			initJkStandard(itemCode,subItemCode);
		}else if(category=="2"){
			initJkTuexdo(itemCode,subItemCode);
		}else if(category=="1"){
			initJkWashable(itemCode,subItemCode);
		}
	}
	
	function initSuitStandard(itemCode){
		subItemCode = "02";
		initJkStandard(itemCode,subItemCode);
	}

	function initSuitTuexdo(itemCode){
		subItemCode = "02";
		initJkTuexdo(itemCode,subItemCode);
	}

	function initSuitWashable(itemCode){
		subItemCode = "02";
		initJkWashable(itemCode,subItemCode);
	}
			
	function initJkStandard(itemCode,subItemCode){
		for(var i in jkStandardMateList){
			optionCode = selectIdList[jkStandardMateList[i]];
			mateChecked = jQuery("#"+jkStandardMateList[i]+" option:selected").val();
			StkNo = "#"+jkStandardMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,0,orderPattern);
		}
		jQuery("#bodyBackMate,#cuffBackMate,#btnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			optionCode = selectIdList[idValue];
			mateChecked = jQuery("#"+idValue+" option:selected").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,0,orderPattern);
		})	
	}

	function initJkTuexdo(itemCode,subItemCode){
		for(var i in jkTuexdoMateList){
			optionCode = selectIdList[jkTuexdoMateList[i]];
			mateChecked = jQuery("#"+jkTuexdoMateList[i]+" option:selected").val();
			StkNo = "#"+jkTuexdoMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,2,orderPattern);
		}
		jQuery("#tj_bodyBackMate,#tj_cuffBackMate,#tj_btnMate").change(function(){
			var idValue = jQuery(this).prop("id");
			optionCode = selectIdList[idValue];
			mateChecked = jQuery("#"+idValue+" option:selected").val();
			StkNo = "#"+idValue+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,2,orderPattern);
		})	
	}

	function initJkWashable(itemCode,subItemCode){
		for(var i in jkWashableMateList){
			optionCode = selectIdList[jkWashableMateList[i]];
			mateChecked = jQuery("#"+jkWashableMateList[i]+" option:selected").val();
			StkNo = "#"+jkWashableMateList[i]+"StkNo";
			mateSelect(itemCode,subItemCode,mateChecked,optionCode,StkNo,1,orderPattern);
		}
		jQuery("#wj_bodyBackMate,#wj_cuffBackMate,#wj_btnMate").change(function(){
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

jQuery("#jacketModel").change(function(){
	jQuery("#jacketFlag").val("1");
})
jQuery("#tj_jacketModel").change(function(){
	jQuery("#jacketFlag").val("1");
})
jQuery("#wj_jacketModel").change(function(){
	jQuery("#jacketFlag").val("1");
})
</script>