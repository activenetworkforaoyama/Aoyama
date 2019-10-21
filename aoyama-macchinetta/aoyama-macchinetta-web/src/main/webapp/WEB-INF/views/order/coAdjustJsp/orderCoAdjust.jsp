<form:form id="idAdjustForm"
	action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm"
	method="post" modelAttribute="orderCoForm" class="form-horizontal">

	<div id="al_jacket_div"  style="display:none">
		<div class="card-header">
			<strong class="card-title">JACKET</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">JACKETサイズ</label>
						</div>
						<div class="col-12 col-md-6">
							体型
							<div class="form-check-inline form-check">
								<form:select id="selectJacketFigure"
									path="coAdjustJacketStandardInfo.sizeFigure"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderCoForm.coAdjustJacketStandardInfo.sizeFigureMap}" />
								</form:select>							
							</div>
							号数
							<div class="form-check-inline form-check">
								<form:select id="selectJacketNumber"
									path="coAdjustJacketStandardInfo.sizeNumber"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderCoForm.coAdjustJacketStandardInfo.sizeNumberMap}" />
								</form:select>								
							</div>
						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">JACKET補正</label>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
						<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkBodyRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkBodyRange" name="coAdjustJacketStandardInfo.corJkBodyCorrect" value="0" min="" max="" step="0.5" alert-min="-4.5" alert-max="4.5">&nbsp;
                                <a href="#" id="corJkBodyRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkBodyRange_out" name="">0</output>cm
                                </div>
                            </div>
						<div class="col-12 col-md-2" id="corJkBody_div">
							<output id="corJkBody_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corJkBodyRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkWaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkWaistRange" name="coAdjustJacketStandardInfo.corJkWaistCorrect" value="0" min="" max="" step="0.5"alert-min="-3.5" alert-max="3.5">&nbsp;
                                <a href="#" id="corJkWaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkWaistRange_out">0</output>cm
							</div>
						</div>
						<div class="col-12 col-md-2" id="corJkWaist_div">
							<output id="corJkWaist_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corJkWaistRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈右修正</label>
						</div>
						<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkRightsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkRightsleeveRange" name="coAdjustJacketStandardInfo.corJkRightsleeveCorrect" value="0" min="" max="" step="0.5" alert-min="-4.5" alert-max="4.5">&nbsp;
                                <a href="#" id="corJkRightsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkRightsleeveRange_out">0</output>cm
                                </div>
						</div>

						<div class="col-12 col-md-2" id="corJkRightsleeve_div">
							<!--  <output>000.0</output>cm -->
							<output id="corJkRightsleeve_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corJkRightsleeveRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈左修正</label>
						</div>
						<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corJkLeftsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corJkLeftsleeveRange" name="coAdjustJacketStandardInfo.corJkLeftsleeveCorrect" value="0" min="" max="" step="0.5" alert-min="-4.5" alert-max="4.5">&nbsp;
                                <a href="#" id="corJkLeftsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corJkLeftsleeveRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corJkLeftsleeve_div">
							<output id="corJkLeftsleeve_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corJkLeftsleeveRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">肩パット</label>
						</div>
						 <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">                                
                                    <form:radiobuttons id="oj_shoulderPat_id" path="coAdjustJacketStandardInfo.corJkShoulderPadCd" class="form-check-input" items="${orderCoForm.coOptionJacketStandardInfo.corJkShoulderPadMap}"/>
                                </div>
                            </div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">体型補正</label>
						</div>
						 <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">                                  
                                    <form:radiobuttons id="oj_figureAlter_id" path="coAdjustJacketStandardInfo.corJkFigureCorrectCd" class="form-check-input" items="${orderCoForm.coOptionJacketStandardInfo.corJkFigureCorrectMap}"/>
                                </div>
                            </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="al_gilet_div"  style="display:none">
		<div class="card-header">
			<strong class="card-title">GILET</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">GILETサイズ</label>
						</div>
						<div class="col-12 col-md-6">
							体型
							<div class="form-check-inline form-check">
								<form:select id="selectGiletFigure"
									path="coAdjustGiletStandardInfo.sizeFigure"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderCoForm.coAdjustGiletStandardInfo.sizeFigureMap}" />
								</form:select>								
							</div>
							号数
							<div class="form-check-inline form-check">
								<form:select id="selectGiletNumber"
									path="coAdjustGiletStandardInfo.sizeNumber"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderCoForm.coAdjustGiletStandardInfo.sizeNumberMap}" />
								</form:select>							
							</div>
						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">GILET補正</label>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corGlBodyRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corGlBodyRange" name="coAdjustGiletStandardInfo.corGlBodyCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corGlBodyRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corGlBodyRange_out">0</output>cm
                                </div>
							
						</div>
						<div class="col-12 col-md-2" id="corGlBody_div">
							<output id="corGlBody_div_html">000.0cm</output>

						</div>
						<div class="col-12 col-md-9 offset-md-3" id="range_5_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">バスト修正</label>
						</div>
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corGlBustRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corGlBustRange" name="coAdjustGiletStandardInfo.corGlBustCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corGlBustRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corGlBustRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corGlBust_div">
							<output id="corGlBust_div_html">000.0cm</output>

						</div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
												
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corGlWaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corGlWaistRange" name="coAdjustGiletStandardInfo.corGlWaistCorrect" value="0" min="" max="" step="0.5">&nbsp;
                                <a href="#" id="corGlWaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corGlWaistRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corGlWaist_div">
							<output id="corGlWaist_div_html">000.0cm</output>

						</div>
						<div class="col-12 col-md-9 offset-md-3" id="range_6_alert"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="al_pants_div"  style="display:none">
		<div class="card-header">
			<strong class="card-title">PANTS</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">PANTSサイズ</label>
						</div>
						<div class="col-12 col-md-6">
							体型
							<div class="form-check-inline form-check">
								<form:select id="selectPantsFigure"
									path="coAdjustPantsStandardInfo.sizeFigure"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderCoForm.coAdjustPantsStandardInfo.sizeFigureMap}" />
								</form:select>								
							</div>
							号数
							<div class="form-check-inline form-check">
								<form:select id="selectPantsNumber"
									path="coAdjustPantsStandardInfo.sizeNumber"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderCoForm.coAdjustPantsStandardInfo.sizeNumberMap}" />
								</form:select>								
							</div>
						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">PANTS補正</label>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
						<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtWaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtWaistRange" name="coAdjustPantsStandardInfo.corPtWaistCorrect" value="0" min="" max="" step="0.5" alert-min="-3.5" alert-max="3.5">&nbsp;
                                <a href="#" id="corPtWaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtWaistRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPtWaist_div">
							<output id="corPtWaist_div_html">000.0cm</output>
						</div>						
						<div class="col-12 col-md-9 offset-md-3" id="corPtWaistRange_alert"></div>
						<div class="col-12 col-md-9 offset-md-3" id="corPtWaistRange2_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ヒップ修正</label>
						</div>
                                <div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtHipRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtHipRange" name="coAdjustPantsStandardInfo.corPtHipCorrect" value="0" min="" max="" step="0.5" alert-min="-1.5" alert-max="1.5">&nbsp;
                                <a href="#" id="corPtHipRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtHipRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPtHip_div">
							<output id="corPtHip_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corPtHipRange_alert"></div>
						<div class="col-12 col-md-9 offset-md-3" id="corPtHipRange2_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ワタリ幅修正</label>
						</div>
						<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtThighRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtThighRange" name="coAdjustPantsStandardInfo.corPtThighCorrect" value="0" min="" max="" step="0.5" alert-min="-0.5" alert-max="0.5">&nbsp;
                                <a href="#" id="corPtThighRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtThighRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPtThigh_div">
							<output id="corPtThigh_div_html">000.0cm</output>						
						</div>
			<div class="col-12 col-md-9 offset-md-3" id="corPtThighRange_alert"></div>
						<div class="col-12 col-md-2 offset-md-3">
							<label class=" form-control-label">裾幅</label>
						</div>
						<div class="col-12 col-md-1">
							<label for="ap_hemWidth_relative" class="form-check-label ">
								<input type="radio" id="pt_hemWidth_relative" name="coAdjustPantsStandardInfo.corPtHemwidthType"
								value="1" class="form-check-input" checked>修正
							</label>
						</div>
						<div class="col-12 col-md-4" id="corPtHemwidthRangeId">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPtHemwidthRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPtHemwidthRange" name="coAdjustPantsStandardInfo.corPtHemwidthCorrect" value="0" min="" max="" step="0.5" alert-min="-1" alert-max="1">&nbsp;
                                <a href="#" id="corPtHemwidthRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPtHemwidthRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPtHemwidth_div"
							style="display: none">
							<output id="corPtHemwidth_div_html">000.0cm</output>
						</div>						
						<div class="col-12 col-md-9 offset-md-3" id="corPtHemwidthRange_alert"></div>
						<div class="col-12 col-md-1 offset-md-5">
							<label for="ap_hemWidth_absolute" class="form-check-label ">
								<input type="radio" id="pt_hemWidth_absolute" name="coAdjustPantsStandardInfo.corPtHemwidthType"
								value="2" class="form-check-input">指定
							</label>
						</div>
					<div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <select name="ap_hemWidthAbs10" id="ap_hemWidthAbs10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                </select>
                                <select name="ap_hemWidthAbs1" id="ap_hemWidthAbs1" class="form-control-sm form-control hidedown" style="width:32px">
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
                                <select name="ap_hemWidthAbsM1" id="ap_hemWidthAbsM1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
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
                                </div>
                            </div>									
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="al2_pants_div"  style="display:none">
		<div class="card-header">
			<strong class="card-title">PANTS（2本目）</strong>
			<button type="button" class="btn btn-outline-info btn-sm"
				id="btn_ap2_samePants">1本目と同じ</button>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">PANTSサイズ</label>
						</div>
						<div class="col-12 col-md-6">
							体型
							<div class="form-check-inline form-check">
							
								<form:select id="selectPants2Figure"
									path="coAdjustPants2StandardInfo.sizeFigure"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderCoForm.coAdjustPants2StandardInfo.sizeFigureMap}" />
								</form:select>
							</div>
							号数
							<div class="form-check-inline form-check">
								<form:select id="selectPants2Number"
									path="coAdjustPants2StandardInfo.sizeNumber"
									class="form-control-sm form-control hidedown">
									<form:options
										items="${orderCoForm.coAdjustPants2StandardInfo.sizeNumberMap}" />
								</form:select>
							</div>
						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">PANTS補正</label>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPt2WaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPt2WaistRange" name="coAdjustPants2StandardInfo.corPt2WaistCorrect" value="0" min="" max="" step="0.5" alert-min="-3.5" alert-max="3.5">&nbsp;
                                <a href="#" id="corPt2WaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPt2WaistRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPt2Waist_div">
							<output id="corPt2Waist_div_html">000.0cm</output>

						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corPt2WaistRange_alert"></div>
						<div class="col-12 col-md-9 offset-md-3" id="corPt2WaistRange2_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ヒップ修正</label>
						</div>					
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPt2HipRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPt2HipRange" name="coAdjustPants2StandardInfo.corPt2HipCorrect" value="0" min="" max="" step="0.5" alert-min="-1.5" alert-max="1.5">&nbsp;
                                <a href="#" id="corPt2HipRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPt2HipRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPt2Hip_div">
							<output id="corPt2Hip_div_html">000.0cm</output>
						</div>					
						<div class="col-12 col-md-9 offset-md-3" id="corPt2HipRange_alert"></div>
						<div class="col-12 col-md-9 offset-md-3" id="corPt2HipRange2_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ワタリ修正</label>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPt2ThighRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPt2ThighRange" name="coAdjustPants2StandardInfo.corPt2ThighCorrect" value="0" min="" max="" step="0.5" alert-min="-0.5" alert-max="0.5">&nbsp;
                                <a href="#" id="corPt2ThighRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPt2ThighRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPt2Thigh_div">
							<output id="corPt2Thigh_div_html">000.0cm</output>
							
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corPt2ThighRange_alert"></div>
						<div class="col-12 col-md-2 offset-md-3">
							<label class=" form-control-label">裾幅</label>
						</div>
						<div class="col-12 col-md-1">
							<label for="ap2_hemWidth_relative" class="form-check-label ">
								<input type="radio" id="pt2_hemWidth_relative"
								name="coAdjustPants2StandardInfo.corPt2HemwidthType" value="1" class="form-check-input" checked>修正
							</label>
						</div>
							<div class="col-12 col-md-4" id="corPt2HemwidthRangeId">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corPt2HemwidthRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corPt2HemwidthRange" name="coAdjustPants2StandardInfo.corPt2HemwidthCorrect" value="0" min="" max="" step="0.5" alert-min="-1.0" alert-max="1.0">&nbsp;
                                <a href="#" id="corPt2HemwidthRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corPt2HemwidthRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corPt2Hemwidth_div"
							style="display: none">
							<output id="corPt2Hemwidth_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3"
							id="corPt2HemwidthRange_alert"></div>
						<div class="col-12 col-md-1 offset-md-5">
							<label for="ap2_hemWidth_absolute" class="form-check-label ">
								<input type="radio" id="pt2_hemWidth_absolute"
								name="coAdjustPants2StandardInfo.corPt2HemwidthType" value="2" class="form-check-input">指定
							</label>
						</div>
						 <div class="col-12 col-md-6">
                                <div class="form-check-inline form-check">
                                <select name="ap2_hemWidthAbs10" id="ap2_hemWidthAbs10" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                </select>
                                <select name="ap2_hemWidthAbs1" id="ap2_hemWidthAbs1" class="form-control-sm form-control hidedown" style="width:32px">
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
                                <select name="ap2_hemWidthAbsM1" id="ap2_hemWidthAbsM1" class="form-control-sm form-control hidedown" style="width:32px">
                                    <option value="0">0</option>
                                    <option value="5">5</option>
                                </select>cm
                                </div>
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
                                	<label id="corPt2Leftinseam_div_html"></label>
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
                                	<label id="corPt2Rightinseam_div_html"></label>
                            	</div>
                                </div>
                            </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="al_shirt_div"  style="display:none">
		<div class="card-header">
			<strong class="card-title">SHIRT</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">SHIRTサイズ</label>
						</div>
						<div class="col-12 col-md-3">
							<form:select id="selectCorStSize"
								path="coAdjustShirtStandardInfo.corStSize"
								class="form-control-sm form-control hidedown">
								<form:options
									items="${orderCoForm.coAdjustShirtStandardInfo.corStSizeMap}" />
							</form:select>				
						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">SHIRT補正</label>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">ネック</label>
						</div>
						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStNeckRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStNeckRange" name="coAdjustShirtStandardInfo.corStNeckCorrect" value="0" min="" max="" step="0.5" alert-min="-2.5" alert-max="2.5">&nbsp;
                                <a href="#" id="corStNeckRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStNeckRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStNeck_div">
							<output id="corStNeck_div_html">000.0cm</output>							
						</div>

						<div class="col-12 col-md-9 offset-md-3" id="corStNeckRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStBodylengthRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStBodylengthRange" name="coAdjustShirtStandardInfo.corStBodylengthCorrect" value="0" min="" max="" step="0.5" alert-min="-4.5" alert-max="4.5">&nbsp;
                                <a href="#" id="corStBodylengthRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStBodylengthRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStBodylength_div">
							<output id="corStBodylength_div_html">000.0cm</output>
						</div>						
						<div class="col-12 col-md-9 offset-md-3" id="corStBodylengthRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈右修正</label>
						</div>
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStRightsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStRightsleeveRange" name="coAdjustShirtStandardInfo.corStRightsleeveCorrect" value="0" min="" max="" step="0.5" alert-min="-4.5" alert-max="4.5">&nbsp;
                                <a href="#" id="corStRightsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStRightsleeveRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStRightsleeve_div">
							<output id="corStRightsleeve_div_html">000.0cm</output>						
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corStRightsleeveRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈左修正</label>
						</div>
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStLeftsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStLeftsleeveRange" name="coAdjustShirtStandardInfo.corStLeftsleeveCorrect" value="0" min="" max="" step="0.5" alert-min="-5.5" alert-max="5.5">&nbsp;
                                <a href="#" id="corStLeftsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStLeftsleeveRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStLeftsleeve_div">
							<output id="corStLeftsleeve_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corStLeftsleeveRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">背ダーツ詰め</label>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStBackdartsPackRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStBackdartsPackRange" name="coAdjustShirtStandardInfo.corStBackdartsPackCorrect" value="0" min="-5" max="0" step="0.5" alert-min="-1.5">&nbsp;
                                <a href="#" id="corStBackdartsPackRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStBackdartsPackRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStBackdartsPack_div"
							style="display: none">
							<output id="corStBackdartsPack_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3"
							id="corStBackdartsPackRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">背ダーツ出し</label>
						</div>
						<div class="col-12 col-md-4">						
							<div class="form-check-inline form-check">
								<form:radiobuttons id="shirt_shoulderPat_id" path="coAdjustShirtStandardInfo.corStBackdartsUnpackCd" class="form-check-input" items="${orderCoForm.coOptionShirtStandardInfo.corStBackdartsUnpackCorrectMap}"/>
							</div>
						</div>
						<div class="col-12 col-md-9 offset-md-3"
							id="shirt_shoulderPat_id_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">カフス周り右</label>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStRightcuffsSurroundingRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStRightcuffsSurroundingRange" name="coAdjustShirtStandardInfo.corStRightcuffsSurroundingCorrect" value="0" min="" max="" step="0.5" alert-min="-1.5" alert-max="1.5">&nbsp;
                                <a href="#" id="corStRightcuffsSurroundingRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStRightcuffsSurroundingRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStRightcuffsSurrounding_div"
							>
							<output id="corStRightcuffsSurrounding_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3"
							id="corStRightcuffsSurroundingRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">カフス周り左</label>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corStLeftcuffsSurroundingRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corStLeftcuffsSurroundingRange" name="coAdjustShirtStandardInfo.corStLeftcuffsSurroundingCorrect" value="0" min="" max="" step="0.5" alert-min="-1.5" alert-max="1.5">&nbsp;
                                <a href="#" id="corStLeftcuffsSurroundingRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corStLeftcuffsSurroundingRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corStLeftcuffsSurrounding_div"
							>
							<output id="corStLeftcuffsSurrounding_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3"
							id="corStLeftcuffsSurroundingRange_alert"></div>					
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="al_coat_div"  style="display:none">
		<div class="card-header">
			<strong class="card-title">COAT</strong>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col col-lg-12">
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">COATサイズ</label>
						</div>
						<div class="col-12 col-md-3">
							<form:select id="selectCorCtSize"
								path="coAdjustCoatStandardInfo.corCtSize"
								class="form-control-sm form-control hidedown">
								<form:options
									items="${orderCoForm.coAdjustCoatStandardInfo.corCtSizeMap}" />
							</form:select>							
						</div>
					</div>
					<div class="row form-group">
						<div class="col col-md-3">
							<label class=" form-control-label">COAT補正</label>
						</div>
						<div class="col-12 col-md-3">
							<label class=" form-control-label">着丈修正</label>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corCtBodylengthRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corCtBodylengthRange" name="coAdjustCoatStandardInfo.corCtBodylengthCorrect" value="0" min="" max="" step="0.5" alert-min="-4.5" alert-max="4.5">&nbsp;
                                <a href="#" id="corCtBodylengthRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corCtBodylengthRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corCtBodylength_div">
							<output id="corCtBodylength_div_html">000.0cm</output>

						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corCtBodylengthRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ウエスト修正</label>
						</div>					
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corCtWaistRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corCtWaistRange" name="coAdjustCoatStandardInfo.corCtWaistCorrect" value="0" min="" max="" step="0.5" alert-min="-3.5" alert-max="3.5">&nbsp;
                                <a href="#" id="corCtWaistRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corCtWaistRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corCtWaist_div">
							<output id="corCtWaist_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corCtWaistRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈右修正</label>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corCtRightsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corCtRightsleeveRange" name="coAdjustCoatStandardInfo.corCtRightsleeveCorrect" value="0" min="" max="" step="0.5" alert-min="-4.5" alert-max="4.5">&nbsp;
                                <a href="#" id="corCtRightsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corCtRightsleeveRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corCtRightsleeve_div">
							<output id="corCtRightsleeve_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corCtRightsleeveRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">袖丈左修正</label>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corCtLeftsleeveRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corCtLeftsleeveRange" name="coAdjustCoatStandardInfo.corCtLeftsleeveCorrect" value="0" min="" max="" step="0.5" alert-min="-4.5" alert-max="4.5">&nbsp;
                                <a href="#" id="corCtLeftsleeveRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corCtLeftsleeveRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corCtLeftsleeve_div">
							<output id="corCtLeftsleeve_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corCtLeftsleeveRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ベント修正（高さ）</label>
							<button type="button" class="btn btn-link btn-sm"
								data-toggle="modal" data-target="#infotext_vents">
								<i class="fa fa-question-circle text-danger"></i>
							</button>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corCtVenthightRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corCtVenthightRange" name="coAdjustCoatStandardInfo.corCtVenthightCorrect" value="0" min="" max="" step="0.5" alert-min="-4.5" alert-max="4.5">&nbsp;
                                <a href="#" id="corCtVenthightRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corCtVenthightRange_out">0</output>cm
                                </div>
						</div>

						<div class="col-12 col-md-2" id="corCtVenthight_div"
							style="display: none">
							<output id="corCtVenthight_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corCtVenthightRange_alert"></div>
						<div class="col-12 col-md-3 offset-md-3">
							<label class=" form-control-label">ポケット位置</label>
							<button type="button" class="btn btn-link btn-sm"
								data-toggle="modal" data-target="#infotext_pocketPos">
								<i class="fa fa-question-circle text-danger"></i>
							</button>
						</div>						
							<div class="col-12 col-md-4">
                                <div class="form-check-inline form-check">
                                <a href="#" id="corCtPktposRange_m"><i class="fa fa-minus-square" style="font-size:32px"></i></a>&nbsp;
                                <input type="range" id="corCtPktposRange" name="coAdjustCoatStandardInfo.corCtPktposCorrect" value="0" min="" max="" step="0.5" alert-min="-0.5" alert-max="0.5">&nbsp;
                                <a href="#" id="corCtPktposRange_p"><i class="fa fa-plus-square" style="font-size:32px"></i></a>
                                　<output id="corCtPktposRange_out">0</output>cm
                                </div>
						</div>
						<div class="col-12 col-md-2" id="corCtPktpos_div"
							style="display: none">
							<output id="corCtPktpos_div_html">000.0cm</output>
						</div>
						<div class="col-12 col-md-9 offset-md-3" id="corCtPktposRange_alert"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
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
                                <form:textarea path="corStoreCorrectionMemo" id="corStoreCorrectionMemo" rows="3" placeholder="再補正コメント" class="form-control"></form:textarea>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
         
	<!-- JACKET -->
	<input type="hidden" id="corJkBody_div_Size"
		name="coAdjustJacketStandardInfo.corJkBodySize" value="" />
	<input type="hidden" id="corJkBody_div_Gross"
		name="coAdjustJacketStandardInfo.corJkBodyGross" value="" />
	<input type="hidden" id="corJkWaist_div_Size"
		name="coAdjustJacketStandardInfo.corJkWaistSize" value="" />
	<input type="hidden" id="corJkWaist_div_Gross"
		name="coAdjustJacketStandardInfo.corJkWaistGross" value="" />
	<input type="hidden" id="corJkRightsleeve_div_Size"
		name="coAdjustJacketStandardInfo.corJkRightsleeveSize" value="" />
	<input type="hidden" id="corJkRightsleeve_div_Gross"
		name="coAdjustJacketStandardInfo.corJkRightsleeveGross" value="" />
	<input type="hidden" id="corJkLeftsleeve_div_Size"
		name="coAdjustJacketStandardInfo.corJkLeftsleeveSize" value="" />
	<input type="hidden" id="corJkLeftsleeve_div_Gross"
		name="coAdjustJacketStandardInfo.corJkLeftsleeveGross" value="" />
		
	<!-- PANTS1 -->
	<input type="hidden" id="corPtWaist_div_Size"
		name="coAdjustPantsStandardInfo.corPtWaistSize" value="" />
	<input type="hidden" id="corPtWaist_div_Gross"
		name="coAdjustPantsStandardInfo.corPtWaistGross" value="" />
    <!-- ヒップ修正            -->
    <input type="hidden" id="corPtHip_div_Size"
		name="coAdjustPantsStandardInfo.corPtHipSize" value="" />
	<input type="hidden" id="corPtHip_div_Gross"
		name="coAdjustPantsStandardInfo.corPtHipGross" value="" />

	<input type="hidden" id="corPtThigh_div_Size"
		name="coAdjustPantsStandardInfo.corPtThighSize" value="" />
	<input type="hidden" id="corPtThigh_div_Gross"
		name="coAdjustPantsStandardInfo.corPtThighGross" value="" />

	<input type="hidden" id="corPtHemwidth_div_Size"
		name="coAdjustPantsStandardInfo.corPtHemwidthSize" value="" />
	<input type="hidden" id="corPtHemwidth_div_Gross"
		name="coAdjustPantsStandardInfo.corPtHemwidthGross" value="" />
		
	<input type="hidden" id="corPtHemwidthDegignate"
		name="coAdjustPantsStandardInfo.corPtHemwidthDegignate" value="" />

	<input type="hidden" id="corPtRightinseam_div_Size"
		name="coAdjustPantsStandardInfo.corPtRightinseamSize" value="" />
	<input type="hidden" id="corPtRightinseamGross"
		name="coAdjustPantsStandardInfo.corPtRightinseamGross" value="" />

	<input type="hidden" id="corPtLeftinseam_div_Size"
		name="coAdjustPantsStandardInfo.corPtLeftinseamSize" value="" />
	<input type="hidden" id="corPtLeftinseamGross"
		name="coAdjustPantsStandardInfo.corPtLeftinseamGross" value="" />
		
	<!-- GILET -->
   <input type="hidden" id="corGlBody_div_Size"
		name="coAdjustGiletStandardInfo.corGlBodySize" value="" />
    <input type="hidden" id="corGlBody_div_Gross"
		name="coAdjustGiletStandardInfo.corGlBodyGross" value="" />
		
	<input type="hidden" id="corGlBust_div_Size"
		name="coAdjustGiletStandardInfo.corGlBustSize" value="" />
	<input type="hidden" id="corGlBust_div_Gross"
		name="coAdjustGiletStandardInfo.corGlBustGross" value="" />
		
	<input type="hidden" id="corGlWaist_div_Size"
		name="coAdjustGiletStandardInfo.corGlWaistSize" value="" />
	<input type="hidden" id="corGlWaist_div_Gross"
		name="coAdjustGiletStandardInfo.corGlWaistGross" value="" />
		
	        <!-- PANTS2 -->
			<input type="hidden" id="corPt2Waist_div_Size"  name="coAdjustPants2StandardInfo.corPt2WaistSize"  value="" />
            <input type="hidden" id="corPt2Waist_div_Gross" name="coAdjustPants2StandardInfo.corPt2WaistGross"  value="" />
            
            <input type="hidden" id="corPt2Thigh_div_Size"  name="coAdjustPants2StandardInfo.corPt2ThighSize"  value="" />
            <input type="hidden" id="corPt2Thigh_div_Gross" name="coAdjustPants2StandardInfo.corPt2ThighGross"  value="" />
            
            <input type="hidden" id="corPt2Hemwidth_div_Size" name="coAdjustPants2StandardInfo.corPt2HemwidthSize"  value="" />
            <input type="hidden" id="corPt2Hemwidth_div_Gross" name="coAdjustPants2StandardInfo.corPt2HemwidthGross"  value="" />
            
            <input type="hidden" id="corPt2HemwidthDegignate"
		                         name="coAdjustPants2StandardInfo.corPt2HemwidthDegignate" value="" />
		
            <input type="hidden" id="corPt2Rightinseam_div_Size"  name="coAdjustPants2StandardInfo.corPt2RightinseamSize"  value="" />
            <input type="hidden" id="corPt2RightinseamGross" name="coAdjustPants2StandardInfo.corPt2RightinseamGross"  value="" />
            
             <input type="hidden" id="corPt2Hip_div_Size"  name="coAdjustPants2StandardInfo.corPt2HipSize"  value="" />
            <input type="hidden" id="corPt2Hip_div_Gross" name="coAdjustPants2StandardInfo.corPt2HipGross"  value="" />
            
            
            <input type="hidden" id="corPt2Leftinseam_div_Size" name="coAdjustPants2StandardInfo.corPt2LeftinseamSize"  value="" />
            <input type="hidden" id="corPt2LeftinseamGross" name="coAdjustPants2StandardInfo.corPt2LeftinseamGross"  value="" />    
		
		<!-- Shirt -->
   <input type="hidden" id="corStNeck_div_Size"
		name="coAdjustShirtStandardInfo.corStNeckSize" value="" />
	<input type="hidden" id="corStNeck_div_Gross"
		name="coAdjustShirtStandardInfo.corStNeckGross" value="" />
		
		<input type="hidden" id="corStBodylength_div_Size"
		name="coAdjustShirtStandardInfo.corStBodylengthSize" value="" />
	<input type="hidden" id="corStBodylength_div_Gross"
		name="coAdjustShirtStandardInfo.corStBodylengthGross" value="" />
		
		<input type="hidden" id="corStRightsleeve_div_Size"
		name="coAdjustShirtStandardInfo.corStRightsleeveSize" value="" />
	<input type="hidden" id="corStRightsleeve_div_Gross"
		name="coAdjustShirtStandardInfo.corStRightsleeveGross" value="" />
		
		<input type="hidden" id="corStLeftsleeve_div_Size"
		name="coAdjustShirtStandardInfo.corStLeftsleeveSize" value="" />
	<input type="hidden" id="corStLeftsleeve_div_Gross"
		name="coAdjustShirtStandardInfo.corStLeftsleeveGross" value="" />
		
		<input type="hidden" id="corStBackdartsPack_div_Size"
		name="coAdjustShirtStandardInfo.corStBackdartsPackSize" value="" />
	<input type="hidden" id="corStBackdartsPack_div_Gross"
		name="coAdjustShirtStandardInfo.corStBackdartsPackGross" value="" />
		
		<input type="hidden" id="corStRightcuffsSurrounding_div_Size"
		name="coAdjustShirtStandardInfo.corStRightcuffsSurroundingSize" value="" />
	<input type="hidden" id="corStRightcuffsSurrounding_div_Gross"
		name="coAdjustShirtStandardInfo.corStRightcuffsSurroundingGross" value="" />
		
		<input type="hidden" id="corStLeftcuffsSurrounding_div_Size"
		name="coAdjustShirtStandardInfo.corStLeftcuffsSurroundingSize" value="" />
	<input type="hidden" id="corStLeftcuffsSurrounding_div_Gross"
		name="coAdjustShirtStandardInfo.corStLeftcuffsSurroundingGross" value="" />
		
		<!-- COAT -->
   <input type="hidden" id="corCtBodylength_div_Size"
		name="coAdjustCoatStandardInfo.corCtBodylengthSize" value="" />
	<input type="hidden" id="corCtBodylength_div_Gross"
		name="coAdjustCoatStandardInfo.corCtBodylengthGross" value="" />
		
	<input type="hidden" id="corCtWaist_div_Size"
		name="coAdjustCoatStandardInfo.corCtWaistSize" value="" />
	<input type="hidden" id="corCtWaist_div_Gross"
		name="coAdjustCoatStandardInfo.corCtWaistGross" value="" />
		
	<input type="hidden" id="corCtRightsleeve_div_Size"
		name="coAdjustCoatStandardInfo.corCtRightsleeveSize" value="" />
	<input type="hidden" id="corCtRightsleeve_div_Gross"
		name="coAdjustCoatStandardInfo.corCtRightsleeveGross" value="" />
			
	<input type="hidden" id="corCtLeftsleeve_div_Size"
		name="coAdjustCoatStandardInfo.corCtLeftsleeveSize" value="" />
	<input type="hidden" id="corCtLeftsleeve_div_Gross"
		name="coAdjustCoatStandardInfo.corCtLeftsleeveGross" value="" />
		
	<input type="hidden" id="corCtVenthight_div_Size"
		name="coAdjustCoatStandardInfo.corCtVenthightSize" value="" />
	<input type="hidden" id="corCtVenthight_div_Gross"
		name="coAdjustCoatStandardInfo.corCtVenthightGross" value="" />
		
	<input type="hidden" id="corCtPktpos_div_Size"
		name="coAdjustCoatStandardInfo.corCtPktposSize" value="" />
	<input type="hidden" id="corCtPktpos_div_Gross"
		name="coAdjustCoatStandardInfo.corCtPktposGross" value="" />
		
	<input type="hidden" id="jacketAdFlag" name="jacketAdFlag" value="${orderCoForm.jacketAdFlag }" />
	<input type="hidden" id="coatAdFlag" name="coatAdFlag" value="${orderCoForm.coatAdFlag }" />
    <input type="hidden" id="giletAdFlag" name="giletAdFlag" value="${orderCoForm.giletAdFlag }" />
    <input type="hidden" id="pantsAdFlag" name="pantsAdFlag" value="${orderCoForm.pantsAdFlag }" />
    <input type="hidden" id="pants2AdFlag" name="pants2AdFlag" value="${orderCoForm.pants2AdFlag }" />
    <input type="hidden" id="shirtAdFlag" name="shirtAdFlag" value="${orderCoForm.shirtAdFlag }" />	
    <input type="hidden" id="osCasHemLineIdFlag" name="osCasHemLineIdFlag" value="${orderCoForm.osCasHemLineIdFlag }" />
    <input type="hidden" id="itemCoChangeFlag" name="itemCoChangeFlag" value="${orderCoForm.itemCoChangeFlag }"/>
</form:form>

<script
	src="${pageContext.request.contextPath}/resources/app/self/js/alter.js"></script>
<script>
var contextPath = jQuery("meta[name='contextPath']").attr("content");
var orderPattern = "CO";
var itemCode ="${orderCoForm.productItem}";
var orderFlag = "${orderCoForm.orderFlag}";
var productCategory="${orderCoForm.productCategory}";
var threePiece ="${orderCoForm.productIs3Piece}";
var sparePants ="${orderCoForm.productSparePantsClass}";

var jkModel="";
var jacketAdFlag="${orderCoForm.jacketAdFlag}";
var jacketModel = "${orderCoForm.coOptionJacketStandardInfo.ojJacketModel}";
var tjJacketModel = "${orderCoForm.coOptionJacketTuxedoInfo.tjJacketModel}";
var wjJacketModel = "${orderCoForm.coOptionJacketWashableInfo.wjJacketModel}";
//01:着丈修正、02：ウエスト修正、03：袖丈右修正、04：袖丈左修正
var jkAdjustList = [
	{type:"01",id:"corJkBody_div"},
	{type:"02",id:"corJkWaist_div"},
	{type:"03",id:"corJkRightsleeve_div"},
	{type:"04",id:"corJkLeftsleeve_div"}
];
<!-- PANTS1 -->
var pantsAdFlag="${orderCoForm.pantsAdFlag}";
var ptModel="";
var opModel = "${orderCoForm.coOptionPantsStandardInfo.opPantsModel}";
var tpModel = "${orderCoForm.coOptionPantsTuxedoInfo.tpPantsModel}";
var wpModel = "${orderCoForm.coOptionPantsWashableInfo.wpPantsModel}";
var opTack = "${orderCoForm.coOptionPantsStandardInfo.opTack}";
var ptAdjustList = [
	{type:"05",id:"corPtHip_div"},
	{type:"06",id:"corPtWaist_div"},
	{type:"08",id:"corPtHemwidth_div"}
];
//06：ウエスト修正
var ptTackList = [
	{type:"07",id:"corPtThigh_div"}	
];
<!-- gile -->
var giletAdFlag="${orderCoForm.giletAdFlag}";
var glModel="";
var ogModel = "${orderCoForm.coOptionGiletStandardInfo.ogGiletModel}";
var tgModel = "${orderCoForm.coOptionGiletTuxedoInfo.tgGiletModel}";
var wgModel = "${orderCoForm.coOptionGiletWashableInfo.wgGiletModel}";
var giletAdjustList = [
	{type:"01",id:"corGlBody_div"},
	{type:"14",id:"corGlBust_div"},
	{type:"02",id:"corGlWaist_div"}
];
<!-- PANTS2 -->
var pants2AdFlag="${orderCoForm.pants2AdFlag}";
var pt2Model="";
var op2Model = "${orderCoForm.coOptionPants2StandardInfo.op2PantsModel}";
var tp2Model = "${orderCoForm.coOptionPants2TuxedoInfo.tp2PantsModel}";
var wp2Model = "${orderCoForm.coOptionPants2WashableInfo.wp2PantsModel}";
var op2Tack = "${orderCoForm.coOptionPants2StandardInfo.op2Tack}";
var pants2AdjustList = [
	{type:"05",id:"corPt2Hip_div"},
	{type:"06",id:"corPt2Waist_div"},
	{type:"07",id:"corPt2Thigh_div"},
	{type:"08",id:"corPt2Hemwidth_div"}
];
<!-- shirt -->
var shirtAdFlag="${orderCoForm.shirtAdFlag}";
var osCasHemLine = "${orderCoForm.coOptionShirtStandardInfo.osCasHemLine}";
var shirtModel = "${orderCoForm.coOptionShirtStandardInfo.osShirtModel}";
var shirtAdjustList = [
	{type:"01",id:"corStBodylength_div"},
	{type:"03",id:"corStRightsleeve_div"},
	{type:"04",id:"corStLeftsleeve_div"},
	{type:"11",id:"corStNeck_div"},
	{type:"19",id:"corStBackdartsPack_div"},
	{type:"12",id:"corStRightcuffsSurrounding_div"},
	{type:"13",id:"corStLeftcuffsSurrounding_div"}
];
<!-- coat -->
var coatAdFlag="${orderCoForm.coatAdFlag}";
var coatModel = "${orderCoForm.coOptionCoatStandardInfo.coatModel}";
var coatAdjustList = [
	{type:"01",id:"corCtBodylength_div"},
	{type:"02",id:"corCtWaist_div"},
	{type:"03",id:"corCtRightsleeve_div"},
	{type:"04",id:"corCtLeftsleeve_div"},
	{type:"17",id:"corCtVenthight_div"},
	{type:"18",id:"corCtPktpos_div"}
];
jQuery(document).ready(function() {
	var headerName = $("meta[name='_csrf_header']").attr("content"); // (1)
    var tokenValue = $("meta[name='_csrf']").attr("content"); // (2)
    jQuery(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(headerName, tokenValue); // (3)
    });
    var jk="";
    var pt="";
    var pt2="";
    var gl="";
    var shirt="";
    var coat="";
    if(itemCode=="01"){
    	jQuery('#al_jacket_div').show();
    	jQuery('#al_pants_div').show();   	
    	jkModel= modelChoose(jkModel,jacketModel,tjJacketModel,wjJacketModel);
    	ptModel=modelChoose(ptModel,opModel,tpModel,wpModel);
        jk="1";
        pt="1";
        if(threePiece=="0009902"){
        	jQuery('#al_gilet_div').show();
        	glModel=modelChoose(glModel,ogModel,tgModel,wgModel);
        	gl="1";
         }
        if(sparePants=="0009902"){
        	jQuery('#al2_pants_div').show();
        	pt2Model=modelChoose(pt2Model,op2Model,tp2Model,wp2Model);
        	pt2="1";
         }
    }else if(itemCode=="02"){
    	jQuery('#al_jacket_div').show();
    	jkModel= modelChoose(jkModel,jacketModel,tjJacketModel,wjJacketModel);
    	 jk="1";
    }else if(itemCode=="03"){
    	jQuery('#al_pants_div').show();
    	ptModel=modelChoose(ptModel,opModel,tpModel,wpModel);
    	 pt="1";
    }else if(itemCode=="04"){
    	jQuery('#al_gilet_div').show();
    	glModel=modelChoose(glModel,ogModel,tgModel,wgModel);
    	 gl="1";
    }else if(itemCode=="05"){
    	jQuery('#al_shirt_div').show();
    	shirt="1";
    }else if(itemCode=="06"){
    	jQuery('#al_coat_div').show();
    	coat="1";
    }
    
	
	 getFigureAndNumberByItem(); 
	 getAdjustByItem(jk,pt,pt2,gl,shirt,coat);
     if("1"==jQuery('#itemCoChangeFlag').val() && orderFlag != "orderCo"){
		 jacketAdFlag="0";
		 adjustJkReInit();
		 pantsAdFlag="0";
		 adjustPtReInit();
		 giletAdFlag="0";
		 adjustGlReInit();
		 pants2AdFlag="0";
		 adjustPt2ReInit();
		 shirtAdFlag="0";
		 adjustShirtReInit();
		 coatAdFlag="0";
		 adjustCoatReInit();
		 jQuery('#itemCoChangeFlag').val("0");
		 }
		if(itemCode=="01" || itemCode=="02"){
			if(jkModel!="TR02"){
	    		jQuery('#oj_figureAlter_id3').prop("disabled", true);
	    		jQuery('#oj_figureAlter_id2').prop("disabled", true);
	    		jQuery('#oj_shoulderPat_id3').prop("disabled", true);
	    		jQuery('#oj_shoulderPat_id2').prop("disabled", true);
	    		jQuery("#oj_shoulderPat_id1").prop("checked", true);
	    	    jQuery("#oj_figureAlter_id1").prop("checked", true);
	    	}
			  jQuery("#oj_shoulderPat_id1").prop("checked", true);
			  jQuery("#oj_figureAlter_id1").prop("checked", true);
	    	if(orderFlag == "orderCo"){		    	
	    		if(jacketAdFlag==""){
	    			 adjustJkReInit();	  		   				   
				}else if(jacketAdFlag=="0"){
					adjustJkReInit();		
					getFigureAndNumberByJkItem();					
				}else if(jacketAdFlag=="1"){
					adjustJkSession();
				}
		    }
	    	if(orderFlag == "orderLink"||orderFlag == "orderCheck"||orderFlag == "orderBack" || orderFlag == "orderDivert"){
			     if(jacketAdFlag=="0"){
			    	 adjustJkReInit();
			    	 getFigureAndNumberByJkItem();
			    }else if(jacketAdFlag=="1"){
					adjustJkSession();
				}else if(jacketAdFlag==""){
					 adjustJkSession();
				}
			 }
	       jQuery("#jacketAdFlag").val("1");
	      
		}
		 if(itemCode=="01" || itemCode=="03"){
			if(orderFlag == "orderCo"){
			    if(pantsAdFlag==""){
			    	adjustPtReInit();
				}else if(pantsAdFlag=="0"){
					adjustPtReInit();
					getFigureAndNumberByPtItem();
				}else if(pantsAdFlag=="1"){
					adjustPtSession();
				}
			 }
			 if(orderFlag == "orderLink"||orderFlag == "orderCheck"||orderFlag == "orderBack" || orderFlag == "orderDivert"){
			     if(pantsAdFlag=="0"){
					adjustPtReInit();
					getFigureAndNumberByPtItem();
			    }else if(pantsAdFlag=="1"){
					adjustPtSession();
				}else if(pantsAdFlag==""){
					 adjustPtSession();
				}
			 }
			 jQuery("#pantsAdFlag").val("1");		
		}
		 if((itemCode=="01" &&threePiece=="0009902") || itemCode=="04"){
				 if(orderFlag == "orderCo"){
						if(giletAdFlag==""){
							adjustGlReInit();
						}else if(giletAdFlag=="0"){
							adjustGlReInit();
							getFigureAndNumberByGlItem();
						}else if(giletAdFlag=="1"){
							adjustGlSession();
						}
				}
				if(orderFlag == "orderLink"||orderFlag == "orderCheck"||orderFlag == "orderBack" || orderFlag == "orderDivert"){
					    if(giletAdFlag=="0"){
					    	 adjustGlReInit();
					    	 getFigureAndNumberByGlItem();
					    }else if(giletAdFlag=="1"){
							adjustGlSession();
						}else if(giletAdFlag==""){
							 adjustGlSession();
						}
				}
			    jQuery("#giletAdFlag").val("1");  
	    }
		if(itemCode=="01"){
	    	if(sparePants=="0009902"){
	    		if(orderFlag == "orderCo"){
	    			if(pants2AdFlag==""){
	    				adjustPt2ReInit();
	    			}else if(pants2AdFlag=="0"){
	    				adjustPt2ReInit();
	    				getFigureAndNumberByPt2Item();
	    			}else if(pants2AdFlag=="1"){
	    				adjustPt2Session();
	    			}
	    		}
	    		if(orderFlag == "orderLink"||orderFlag == "orderCheck"||orderFlag == "orderBack" || orderFlag == "orderDivert"){
	    			 if(pants2AdFlag=="0"){
	    				 adjustPt2ReInit();
	    				 getFigureAndNumberByPt2Item();
	    			}else if(pants2AdFlag=="1"){
	    				adjustPt2Session();
	    			}else if(pants2AdFlag==""){
	    				 adjustPt2Session();
	    			}
	    		}
	    		jQuery("#pants2AdFlag").val("1");
	    	}
		}
	 if(itemCode=="05"){
			if(orderFlag == "orderCo"){
			    if(shirtAdFlag==""){
			    	adjustShirtReInit();
			    	jQuery("#shirt_shoulderPat_id1").prop("checked", true);	     
				}else if(shirtAdFlag=="0"){
					jQuery("#shirt_shoulderPat_id1").prop("checked", true);
					adjustShirtReInit();
					getFigureAndNumberByShirtItem();
				}else if(shirtAdFlag=="1"){
					adjustShirtSession();
				}
			}
			if(orderFlag == "orderLink"||orderFlag == "orderCheck"||orderFlag == "orderBack" || orderFlag == "orderDivert"){
				if(shirtModel!=""){
					if(shirtAdFlag=="0"){
						jQuery("#shirt_shoulderPat_id1").prop("checked", true);
						adjustShirtReInit();						
						getFigureAndNumberByShirtItem();
					}else if(shirtAdFlag=="1"){
						jQuery("#shirt_shoulderPat_id1").prop("checked", true);
						adjustShirtSession();
					}else if(shirtAdFlag==""){
						jQuery("#shirt_shoulderPat_id1").prop("checked", true);
						adjustShirtSession();
					}
				}else{
					adjustShirtReInit();
					jQuery("#shirt_shoulderPat_id1").prop("checked", true);
					}
			}
			jQuery("#shirtAdFlag").val("1");
		}
	    if(itemCode=="06"){
			 if(orderFlag == "orderCo"){
			    	if(coatAdFlag==""){
			    		adjustCoatReInit();
			    	}else if(coatAdFlag=="0"){
			    		adjustCoatReInit();
			    		getFigureAndNumberByCoatItem();
			    	}else if(coatAdFlag=="1"){
			    		adjustCoatSession();
			    	}
			    }
			   if(orderFlag == "orderLink"||orderFlag == "orderCheck"||orderFlag == "orderBack" || orderFlag == "orderDivert"){
					if(coatAdFlag=="0"){
						adjustCoatReInit();
			    		getFigureAndNumberByCoatItem();
			    	}else if(coatAdFlag=="1"){
			    		adjustCoatSession();
			    	}else if(coatAdFlag==""){
			    		adjustCoatSession();
			    	}
			    }
			   jQuery("#coatAdFlag").val("1"); 
		}
	   
	    initAlter();
	
    jQuery("#selectJacketFigure,#selectJacketNumber").change(function(){	
		jkAdjust();
	}) 
	jQuery("#selectPantsFigure,#selectPantsNumber").change(function(){
	    ptAdjust();		
    })
    jQuery("#selectGiletFigure,#selectGiletNumber").change(function(){
	   giletAdjust();
    })   
    jQuery("#selectPants2Figure,#selectPants2Number").change(function(){
       pt2Adjust();
    }) 
    jQuery("#selectCorCtSize").change(function(){
    	coatAdjust();
   })  
    
    jQuery("#selectCorStSize").change(function(){
		shirtAdjust();
		if(osCasHemLine=="0002002"){
			//jQuery("#corStBodylength_div_Size").val("000.0");
			//jQuery("#corStBodylength_div_Gross").val("000.0");
			jQuery("#corStBodylength_div_html").html("000.0cm");
			jQuery("#corStBodylengthRange").val("0");
			jQuery("#corStBodylengthRange_out").html("0");
			setFont("corStBodylengthRange");
			 setRangeDisable('corStBodylengthRange',true);
			 $("#corStBodylengthRange_m").unbind("click");
			 $("#corStBodylengthRange_p").unbind("click");
			}
	})
	if(jQuery("#osCasHemLineIdFlag").val()=="1"){
		jQuery("#corStBodylengthRange").val("0");
		setFont("corStBodylengthRange");
		jQuery("#corStBodylengthRange_out").html("0");
		shirtAdjust2();
		jQuery("#osCasHemLineIdFlag").val("0")
		}
	if(osCasHemLine=="0002002"){
		//jQuery("#corStBodylength_div_Size").val("000.0");
		//jQuery("#corStBodylength_div_Gross").val("000.0");
		jQuery("#corStBodylength_div_html").html("000.0cm");
		jQuery("#corStBodylengthRange").val("0");
		jQuery("#corStBodylengthRange_out").html("0");
		setFont("corStBodylengthRange");
		setRangeDisable('corStBodylengthRange',true);
		 $("#corStBodylengthRange_m").unbind("click");
		 $("#corStBodylengthRange_p").unbind("click");
	}
	 //PANTS裾幅 指定
    jQuery("#pt_hemWidth_absolute").click(function(){
    	jQuery("#corPtHemwidthRangeId").hide();
    	jQuery("#corPtHemwidth_div_Gross").val("0");
    	jQuery("#corPtHemwidthRange_out").html("0.0");
    	jQuery("#corPtHemwidthRange").val("0");
    	setFont("corPtHemwidthRange");
    	jQuery("#corPtHemwidthDegignate").val("10.0");
    });
    jQuery("#pt_hemWidth_relative").click(function(){
    	jQuery("#corPtHemwidth_div_Gross").val("0");
    	jQuery("#corPtHemwidthRange_out").html("0.0");
    	jQuery("#corPtHemwidthRange").val("0");
	    jQuery("#corPtHemwidthRangeId").show();
	    setFont("corPtHemwidthRange");
    });
    	jQuery("#ap_hemWidthAbs10,#ap_hemWidthAbs1,#ap_hemWidthAbsM1").change(function(){
    		var ap_hemWidthAbs10 = jQuery("#ap_hemWidthAbs10").val();
    		var ap_hemWidthAbs1 = jQuery("#ap_hemWidthAbs1").val();
    		var ap_hemWidthAbsM1 = jQuery("#ap_hemWidthAbsM1").val();
    		var corPtHemwidthDegignate = ap_hemWidthAbs10+ap_hemWidthAbs1+"."+ap_hemWidthAbsM1;
    		jQuery("#corPtHemwidthDegignate").val(corPtHemwidthDegignate);
    	})
       
        
    //PANTS股下左
	jQuery("#ap_inseamLeft100,#ap_inseamLeft10,#ap_inseamLeft1,#ap_inseamLeftM1").change(function(){
		var ap_inseamLeft100 = jQuery("#ap_inseamLeft100").val();
		var ap_inseamLeft10 = jQuery("#ap_inseamLeft10").val();
		var ap_inseamLeft1 = jQuery("#ap_inseamLeft1").val();
		var ap_inseamLeftM1 = jQuery("#ap_inseamLeftM1").val();
		var corPtLeftinseamGross = ap_inseamLeft100+ap_inseamLeft10+ap_inseamLeft1+"."+ap_inseamLeftM1;
		jQuery("#corPtLeftinseamGross").val(corPtLeftinseamGross);
	})
	
	//PANTS股下右
	jQuery("#ap_inseamRight100,#ap_inseamRight10,#ap_inseamRight1,#ap_inseamRightM1").change(function(){
		var ap_inseamRight100 = jQuery("#ap_inseamRight100").val();
		var ap_inseamRight10 = jQuery("#ap_inseamRight10").val();
		var ap_inseamRight1 = jQuery("#ap_inseamRight1").val();
		var ap_inseamRightM1 = jQuery("#ap_inseamRightM1").val();
		var corPtRightinseamGross = ap_inseamRight100+ap_inseamRight10+ap_inseamRight1+"."+ap_inseamRightM1;
		jQuery("#corPtRightinseamGross").val(corPtRightinseamGross);
	})


	//PANTS裾幅 指定
    jQuery("#pt2_hemWidth_absolute").click(function(){
    	jQuery("#corPt2HemwidthRangeId").hide();
    	jQuery("#corPt2Hemwidth_div_Gross").val("0");
    	jQuery("#corPt2HemwidthRange_out").val("0.0");
    	jQuery("#corPt2HemwidthRange").val("0");
    	setFont("corPt2HemwidthRange");
    	jQuery("#corPt2HemwidthDegignate").val("10.0");
    });
    jQuery("#pt2_hemWidth_relative").click(function(){
    	jQuery("#corPt2Hemwidth_div_Gross").val("0");
    	jQuery("#corPt2HemwidthRange_out").val("0.0");
    	jQuery("#corPt2HemwidthRange").val("0");
	    jQuery("#corPt2HemwidthRangeId").show();
	    setFont("corPt2HemwidthRange");
	  
    });
    	jQuery("#ap2_hemWidthAbs10,#ap2_hemWidthAbs1,#ap2_hemWidthAbsM1").change(function(){
    		var ap2_hemWidthAbs10 = jQuery("#ap2_hemWidthAbs10").val();
    		var ap2_hemWidthAbs1 = jQuery("#ap2_hemWidthAbs1").val();
    		var ap2_hemWidthAbsM1 = jQuery("#ap2_hemWidthAbsM1").val();
    		var corPt2HemwidthDegignate = ap2_hemWidthAbs10+ap2_hemWidthAbs1+"."+ap2_hemWidthAbsM1;
    		jQuery("#corPt2HemwidthDegignate").val(corPt2HemwidthDegignate);
    	})

    //2PANTS股下左
	jQuery("#ap2_inseamLeft100,#ap2_inseamLeft10,#ap2_inseamLeft1,#ap2_inseamLeftM1").change(function(){
		var ap2_inseamLeft100 = jQuery("#ap2_inseamLeft100").val();
		var ap2_inseamLeft10 = jQuery("#ap2_inseamLeft10").val();
		var ap2_inseamLeft1 = jQuery("#ap2_inseamLeft1").val();
		var ap2_inseamLeftM1 = jQuery("#ap2_inseamLeftM1").val();
		var corPt2LeftinseamGross = ap2_inseamLeft100+ap2_inseamLeft10+ap2_inseamLeft1+"."+ap2_inseamLeftM1;
		jQuery("#corPt2LeftinseamGross").val(corPt2LeftinseamGross);
	})
	
	//2PANTS股下右
	jQuery("#ap2_inseamRight100,#ap2_inseamRight10,#ap2_inseamRight1,#ap2_inseamRightM1").change(function(){
		var ap2_inseamRight100 = jQuery("#ap2_inseamRight100").val();
		var ap2_inseamRight10 = jQuery("#ap2_inseamRight10").val();
		var ap2_inseamRight1 = jQuery("#ap2_inseamRight1").val();
		var ap2_inseamRightM1 = jQuery("#ap2_inseamRightM1").val();
		var corPt2RightinseamGross = ap2_inseamRight100+ap2_inseamRight10+ap2_inseamRight1+"."+ap2_inseamRightM1;
		jQuery("#corPt2RightinseamGross").val(corPt2RightinseamGross);
	})
	
	});
jQuery("#shirt_shoulderPat_id2").click(function(){
	setAlert("shirt_shoulderPat_id_alert", "値が規定値を超えています。");
})
jQuery("#corPtWaistRange,#corPtWaistRange_m,#corPtWaistRange_p,"+
	   "#corPt2WaistRange,#corPt2WaistRange_m,#corPt2WaistRange_p,"+
	   "#corPtHipRange,#corPtHipRange_m,#corPtHipRange_p,"+
	   "#corPt2HipRange,#corPt2HipRange_m,#corPt2HipRange_p").click(function(){
	var elem = jQuery(this);
	var id = elem.prop('id');
	if(id=="corPtWaistRange" || id=="corPtWaistRange_m" || id=="corPtWaistRange_p"){
			var corPtWaistRange=jQuery("#corPtWaistRange").val()-0;
			var setValue=jQuery('#corPtHipRange').val();
			if(keepFloatPrecision(setValue)<0 && keepFloatPrecision(corPtWaistRange)>0){
				jQuery("#corPtWaistRange2_alert").show();
				setAlert("corPtWaistRange2_alert", "補正値に矛盾があります。工場にて修正を加える場合があります。");
			}else{
				jQuery("#corPtWaistRange2_alert").hide();
				jQuery("#corPtHipRange2_alert").hide();
			}
	}
	if(id=="corPtHipRange"  || id=="corPtHipRange_m"  || id=="corPtHipRange_p"){
		var corPtWaistRange=jQuery("#corPtWaistRange").val()-0;
		var setValue=jQuery('#corPtHipRange').val();
		if(keepFloatPrecision(setValue)<0 && keepFloatPrecision(corPtWaistRange)>0){
			jQuery("#corPtHipRange2_alert").show();
			setAlert("corPtHipRange2_alert", "補正値に矛盾があります。工場にて修正を加える場合があります。");
		}else{
			jQuery("#corPtWaistRange2_alert").hide();
			jQuery("#corPtHipRange2_alert").hide();
		}
	}
		if(id=="corPt2WaistRange" || id=="corPt2WaistRange_m" || id=="corPt2WaistRange_p"){
			var corPt2WaistRange=jQuery("#corPt2WaistRange").val()-0;
			var setValue=jQuery('#corPt2HipRange').val();
			if(keepFloatPrecision(setValue)<0 && keepFloatPrecision(corPt2WaistRange)>0){
				jQuery("#corPt2WaistRange2_alert").show();
				setAlert("corPt2WaistRange2_alert", "補正値に矛盾があります。工場にて修正を加える場合があります。");
			}else{
				jQuery("#corPt2WaistRange2_alert").hide();
				jQuery("#corPt2HipRange2_alert").hide()
			}
		}
		if(id=="corPt2HipRange" || id=="corPt2HipRange_m"  || id=="corPt2HipRange_p"){
			var corPt2WaistRange=jQuery("#corPt2WaistRange").val()-0;
			var setValue=jQuery('#corPt2HipRange').val();
			if(keepFloatPrecision(setValue)<0 && keepFloatPrecision(corPt2WaistRange)>0){
				jQuery("#corPt2HipRange2_alert").show();
				setAlert("corPt2HipRange2_alert", "補正値に矛盾があります。工場にて修正を加える場合があります。");
			}else{
				jQuery("#corPt2WaistRange2_alert").hide();
				jQuery("#corPt2HipRange2_alert").hide();			
			}
		}
})
function getAdjustByItem(jk,pt,pt2,gl,shirt,coat){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getAdjustByItem",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"itemCode":itemCode},
	        success: function(data){
	           jQuery.each(data, function (index, e) {
		       if(jk=="1"){     
	        	   if(e.subItemCode == "02"){
						if(e.adjusteClass == "01"){
							document.getElementById("corJkBodyRange").max = e.adjusteMax;
							document.getElementById("corJkBodyRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "02"){
							document.getElementById("corJkWaistRange").max = e.adjusteMax;
							document.getElementById("corJkWaistRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "03"){
							document.getElementById("corJkRightsleeveRange").max = e.adjusteMax;
							document.getElementById("corJkRightsleeveRange").min = e.adjusteMin;
						}
						if(e.adjusteClass == "04"){
							document.getElementById("corJkLeftsleeveRange").max = e.adjusteMax;
							document.getElementById("corJkLeftsleeveRange").min = e.adjusteMin;
						}
		           }
		          }
		          if(pt=="1"){
		        	  if(e.subItemCode == "03"){
		        		   if(e.adjusteClass == "05"){
			            		document.getElementById("corPtHipRange").max = e.adjusteMax;
								document.getElementById("corPtHipRange").min = e.adjusteMin;
							}
			        	   if(e.adjusteClass == "06"){
								document.getElementById("corPtWaistRange").max = e.adjusteMax;
								document.getElementById("corPtWaistRange").min = e.adjusteMin;
							}
							if(e.adjusteClass == "07"){
								document.getElementById("corPtThighRange").max = e.adjusteMax;
								document.getElementById("corPtThighRange").min = e.adjusteMin;
							}
							if(e.adjusteClass == "08"){
								document.getElementById("corPtHemwidthRange").max = e.adjusteMax;
								document.getElementById("corPtHemwidthRange").min = e.adjusteMin;
							}
				       }
			        }
			        if(pt2=="1"){
			        	 if(e.subItemCode == "07"){
				               if(e.adjusteClass == "05"){
					            	document.getElementById("corPt2HipRange").max = e.adjusteMax;
									document.getElementById("corPt2HipRange").min = e.adjusteMin;
							    }
				        	   if(e.adjusteClass == "06"){
									document.getElementById("corPt2WaistRange").max = e.adjusteMax;
									document.getElementById("corPt2WaistRange").min = e.adjusteMin;
								}
								if(e.adjusteClass == "07"){
									document.getElementById("corPt2ThighRange").max = e.adjusteMax;
									document.getElementById("corPt2ThighRange").min = e.adjusteMin;
								}
								if(e.adjusteClass == "08"){
									document.getElementById("corPt2HemwidthRange").max = e.adjusteMax;
									document.getElementById("corPt2HemwidthRange").min = e.adjusteMin;
								}
					       } 
				       }
				       if(gl=="1"){
				    	   if(e.subItemCode == "04"){
			        		   if(e.adjusteClass == "01"){
				            		document.getElementById("corGlBodyRange").max = e.adjusteMax;
									document.getElementById("corGlBodyRange").min = e.adjusteMin;
								}
				        	   if(e.adjusteClass == "14"){
									document.getElementById("corGlBustRange").max = e.adjusteMax;
									document.getElementById("corGlBustRange").min = e.adjusteMin;
								}
								if(e.adjusteClass == "02"){
									document.getElementById("corGlWaistRange").max = e.adjusteMax;
									document.getElementById("corGlWaistRange").min = e.adjusteMin;
								}
					       }
					     }
					     if(shirt=="1"){
					    	 if(e.subItemCode == "05"){
				        		   if(e.adjusteClass == "11"){
										document.getElementById("corStNeckRange").max = e.adjusteMax;
										document.getElementById("corStNeckRange").min = e.adjusteMin;
									}
					        	   if(e.adjusteClass == "01"){
										document.getElementById("corStBodylengthRange").max = e.adjusteMax;
										document.getElementById("corStBodylengthRange").min = e.adjusteMin;
									}
									if(e.adjusteClass == "03"){
										document.getElementById("corStRightsleeveRange").max = e.adjusteMax;
										document.getElementById("corStRightsleeveRange").min = e.adjusteMin;
									}
									if(e.adjusteClass == "04"){
										document.getElementById("corStLeftsleeveRange").max = e.adjusteMax;
										document.getElementById("corStLeftsleeveRange").min = e.adjusteMin;
									}
								    if(e.adjusteClass == "19"){
										document.getElementById("corStBackdartsPackRange").max = e.adjusteMax;				
										document.getElementById("corStBackdartsPackRange").min = e.adjusteMin;
									} 
									if(e.adjusteClass == "12"){
										document.getElementById("corStRightcuffsSurroundingRange").max = e.adjusteMax;
										document.getElementById("corStRightcuffsSurroundingRange").min = e.adjusteMin;
									}
									if(e.adjusteClass == "13"){
										document.getElementById("corStLeftcuffsSurroundingRange").max = e.adjusteMax;
										document.getElementById("corStLeftcuffsSurroundingRange").min = e.adjusteMin;
									} 
						       }
						    }
						    if(coat=="1"){
						    	if(e.subItemCode == "06"){
						        	   if(e.adjusteClass == "01"){
											document.getElementById("corCtBodylengthRange").max = e.adjusteMax;
											document.getElementById("corCtBodylengthRange").min = e.adjusteMin;
										}
										if(e.adjusteClass == "03"){
											document.getElementById("corCtRightsleeveRange").max = e.adjusteMax;
											document.getElementById("corCtRightsleeveRange").min = e.adjusteMin;
										}
										if(e.adjusteClass == "04"){
											document.getElementById("corCtLeftsleeveRange").max = e.adjusteMax;
											document.getElementById("corCtLeftsleeveRange").min = e.adjusteMin;
										}
										if(e.adjusteClass == "02"){
											document.getElementById("corCtWaistRange").max = e.adjusteMax;
											document.getElementById("corCtWaistRange").min = e.adjusteMin;
										}
										if(e.adjusteClass == "17"){
											document.getElementById("corCtVenthightRange").max = e.adjusteMax;
											document.getElementById("corCtVenthightRange").min = e.adjusteMin;
										}
										if(e.adjusteClass == "18"){
											document.getElementById("corCtPktposRange").max = e.adjusteMax;
											document.getElementById("corCtPktposRange").min = e.adjusteMin;
										} 
							       }
							    }		      		  
	           });
	        }
	    });
}
function jkAdjust(){
	if(jkModel==""||jkModel==null){

	}else{
		jQuery("#corJkBodyRange").val(0);
		setFont("corJkBodyRange");
		jQuery("#corJkWaistRange").val(0);
		setFont("corJkWaistRange");
		jQuery("#corJkRightsleeveRange").val(0);
		setFont("corJkRightsleeveRange");
		jQuery("#corJkLeftsleeveRange").val(0);
		setFont("corJkLeftsleeveRange");

		jQuery("#corJkBodyRange_out").val("0");
		jQuery("#corJkWaistRange_out").val("0");
		jQuery("#corJkRightsleeveRange_out").val("0");
		jQuery("#corJkLeftsleeveRange_out").val("0");
	}
	var subItemCode = "02";
	
	jacketFigure = jQuery("#selectJacketFigure").val();
	jacketNumber = jQuery("#selectJacketNumber").val();
	
if(isNotEmpty(jacketNumber)){

	jQuery.ajax({
        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
        type: 'get',
        async:false,
        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":jkModel,"figure":jacketFigure,"number":jacketNumber},
        success: function(data){
        	for(var i=0; i<data.length; i++){
        		if(data[i].adjustClass == "01"){
					jQuery("#corJkBody_div_html")[0].innerHTML=data[i].typeSize + 'cm';
            		jQuery("#corJkBody_div_Size").val(data[i].typeSize);
            		jQuery("#corJkBody_div_Gross").val(data[i].typeSize);
				}else if(data[i].adjustClass == "02"){
					jQuery("#corJkWaist_div_html")[0].innerHTML=data[i].typeSize + 'cm';
            		jQuery("#corJkWaist_div_Size").val(data[i].typeSize);
            		jQuery("#corJkWaist_div_Gross").val(data[i].typeSize);
				}else if(data[i].adjustClass == "03"){
					jQuery("#corJkRightsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
            		jQuery("#corJkRightsleeve_div_Size").val(data[i].typeSize);
            		jQuery("#corJkRightsleeve_div_Gross").val(data[i].typeSize);
				}else if(data[i].adjustClass == "04"){
					jQuery("#corJkLeftsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
            		jQuery("#corJkLeftsleeve_div_Size").val(data[i].typeSize);
            		jQuery("#corJkLeftsleeve_div_Gross").val(data[i].typeSize);
				}
            }
            if(data==""){
            	for (jk of jkAdjustList) {
        			jQuery("#"+jk.id+"_html")[0].innerHTML = '000.0cm';
            		jQuery("#"+jk.id+"_Size").val("0");
            		jQuery("#"+jk.id+"_Gross").val("0");
        		}
             }
        }
    })

	}else{
		for (jk of jkAdjustList) {
			jQuery("#"+jk.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+jk.id+"_Size").val("0");
    		jQuery("#"+jk.id+"_Gross").val("0");
		}
	} 
}

function ptAdjust(){
	var pantsModel = ptModel;
	if(pantsModel==""||pantsModel==null){
		
	}else{
		jQuery("#corPtWaistRange").val(0);
		setFont("corPtWaistRange");
		jQuery("#corPtThighRange").val(0);
		setFont("corPtThighRange");
		jQuery("#corPtHipRange").val(0);
		setFont("corPtHipRange");
		jQuery("#corPtHemwidthRange").val(0);
		setFont("corPtHemwidthRange");

		jQuery("#corPtWaistRange_out").html('0');
		jQuery("#corPtThighRange_out").html('0');
		jQuery("#corPtHipRange_out").html('0');
		jQuery("#corPtHemwidthRange_out").html('0');
	}
	var subItemCode = "03";
	pantsFigure = jQuery("#selectPantsFigure").val();
	pantsNumber = jQuery("#selectPantsNumber").val();
	//var opTack = "${orderCoForm.coOptionPantsStandardInfo.opTack}";

	//ノータック:0000101  1アウトタック:0000102  2アウトタック:0000104
	if(isNotEmpty(pantsNumber)){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":pantsModel,"figure":pantsFigure,"number":pantsNumber},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "09"){
	            		jQuery("#corPtRightinseam_div_Size").val(data[i].typeSize);
					}else if(data[i].adjustClass == "10"){
	            		jQuery("#corPtLeftinseam_div_Size").val(data[i].typeSize);
					}else if(data[i].adjustClass == "06"){
						jQuery("#corPtWaist_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPtWaist_div_Size").val(data[i].typeSize);
	            		jQuery("#corPtWaist_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "05"){
						jQuery("#corPtHip_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPtHip_div_Size").val(data[i].typeSize);
	            		jQuery("#corPtHip_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "08"){
						jQuery("#corPtHemwidth_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPtHemwidth_div_Size").val(data[i].typeSize);
	            		jQuery("#corPtHemwidth_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "07"){
						if(opTack=="0000101"){
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize);		     
						}else if(opTack=="0000102"){
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize1Outtack + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize1Outtack);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize1Outtack);
						}else if(opTack=="0000103"){
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize1Intack + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize1Intack);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize1Intack);
						}else if(opTack=="0000104"){
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize2Outtack + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize2Outtack);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize2Outtack);
						}else if(opTack=="0000105"){
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize2Intack + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize2Intack);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize2Intack);
						}else{
							jQuery("#corPtThigh_div_html")[0].innerHTML=data[i].typeSize + 'cm';
		            		jQuery("#corPtThigh_div_Size").val(data[i].typeSize);
		            		jQuery("#corPtThigh_div_Gross").val(data[i].typeSize);
						}
					}
		        }
		        if(data==""){
		        	for (ptt of ptTackList) {
		    			jQuery("#"+ptt.id+"_html")[0].innerHTML = '000.0cm';
		        		jQuery("#"+ptt.id+"_Size").val("0");
		        		jQuery("#"+ptt.id+"_Gross").val("0");
		    		}
		    		for (pt of ptAdjustList) {
		    			jQuery("#"+pt.id+"_html")[0].innerHTML = '000.0cm';
		        		jQuery("#"+pt.id+"_Size").val("0");
		        		jQuery("#"+pt.id+"_Gross").val("0");
		    		}
			    }
		    }
		})
	}else{
		for (ptt of ptTackList) {
			jQuery("#"+ptt.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+ptt.id+"_Size").val("0");
    		jQuery("#"+ptt.id+"_Gross").val("0");
		}
		for (pt of ptAdjustList) {
			jQuery("#"+pt.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+pt.id+"_Size").val("0");
    		jQuery("#"+pt.id+"_Gross").val("0");
		}
	}
}
function giletAdjust(){
	if(glModel==""||glModel==null){
		
	}else{
		jQuery("#corGlBodyRange").val(0);
		setFont("corGlBodyRange");
		jQuery("#corGlBustRange").val(0);
		setFont("corGlBustRange");
		jQuery("#corGlWaistRange").val(0);
		setFont("corGlWaistRange");

		jQuery("#corGlBodyRange_out").html('0');
		jQuery("#corGlBustRange_out").html('0');
		jQuery("#corGlWaistRange_out").html('0');
	}
	var subItemCode = "04";
	giletFigure = jQuery("#selectGiletFigure").val();
	giletNumber = jQuery("#selectGiletNumber").val();
	
	if(isNotEmpty(giletNumber)){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":glModel,"figure":giletFigure,"number":giletNumber},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "01"){
						jQuery("#corGlBody_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corGlBody_div_Size").val(data[i].typeSize);
	            		jQuery("#corGlBody_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "14"){
						jQuery("#corGlBust_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corGlBust_div_Size").val(data[i].typeSize);
	            		jQuery("#corGlBust_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "02"){
						jQuery("#corGlWaist_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corGlWaist_div_Size").val(data[i].typeSize);
	            		jQuery("#corGlWaist_div_Gross").val(data[i].typeSize);
					}
		        }
		        if(data==""){
		        	for (gilet of giletAdjustList) {
		    			jQuery("#"+gilet.id+"_html")[0].innerHTML = '000.0cm';
		        		jQuery("#"+gilet.id+"_Size").val("0");
		        		jQuery("#"+gilet.id+"_Gross").val("0");
		    		}
			     }
		    }
		})
	}else{
		for (gilet of giletAdjustList) {
			jQuery("#"+gilet.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+gilet.id+"_Size").val("0");
    		jQuery("#"+gilet.id+"_Gross").val("0");
		}
	}	
}
function pt2Adjust(){
	if(pt2Model==""||pt2Model==null){
		
	}else{
		jQuery("#corPt2WaistRange").val(0);
		setFont("corPt2WaistRange");
		jQuery("#corPt2HipRange").val(0);
		setFont("corPt2HipRange");
		jQuery("#corPt2ThighRange").val(0);
		setFont("corPt2ThighRange");
		jQuery("#corPt2HemwidthRange").val(0);
		setFont("corPt2HemwidthRange");

		jQuery("#corPt2WaistRange_out").html('0');
		jQuery("#corPt2HipRange_out").html('0');
		jQuery("#corPt2ThighRange_out").html('0');
		jQuery("#corPt2HemwidthRange_out").html('0');
	}
	var subItemCode = "07";
	pants2Figure = jQuery("#selectPants2Figure").val();
	pants2Number = jQuery("#selectPants2Number").val();
	if(isNotEmpty(pants2Number)){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":pt2Model,"figure":pants2Figure,"number":pants2Number},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "05"){
						jQuery("#corPt2Hip_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPt2Hip_div_Size").val(data[i].typeSize);
	            		jQuery("#corPt2Hip_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "06"){
						jQuery("#corPt2Waist_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPt2Waist_div_Size").val(data[i].typeSize);
	            		jQuery("#corPt2Waist_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "07"){
						if(op2Tack=="0000101"){
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize);
						}else if(op2Tack=="0000102"){
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize1Outtack + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize1Outtack);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize1Outtack);
						}else if(op2Tack=="0000103"){
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize1Intack + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize1Intack);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize1Intack);
						}else if(op2Tack=="0000104"){
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize2Outtack + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize2Outtack);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize2Outtack);
						}else if(op2Tack=="0000105"){
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize2Intack + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize2Intack);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize2Intack);
						}else{
							jQuery("#corPt2Thigh_div_html")[0].innerHTML=data[i].typeSize + 'cm';
		            		jQuery("#corPt2Thigh_div_Size").val(data[i].typeSize);
		            		jQuery("#corPt2Thigh_div_Gross").val(data[i].typeSize);
						}
					}else if(data[i].adjustClass == "08"){
						jQuery("#corPt2Hemwidth_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corPt2Hemwidth_div_Size").val(data[i].typeSize);
	            		jQuery("#corPt2Hemwidth_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "09"){
	            		jQuery("#corPt2Rightinseam_div_Size").val(data[i].typeSize);
					}else if(data[i].adjustClass == "10"){						
	            		jQuery("#corPt2Leftinseam_div_Size").val(data[i].typeSize);	            		
					}
		        }
		        if(data==""){
		        	for (pants2 of pants2AdjustList) {
		    			jQuery("#"+pants2.id+"_html")[0].innerHTML = '000.0cm';
		        		jQuery("#"+pants2.id+"_Size").val("0");
		        		jQuery("#"+pants2.id+"_Gross").val("0");
		    		}
			    }
		    }
		})
	}else{
		for (pants2 of pants2AdjustList) {
			jQuery("#"+pants2.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+pants2.id+"_Size").val("0");
    		jQuery("#"+pants2.id+"_Gross").val("0");
		}
	}	
}
function shirtAdjust2(){
	var subItemCode = "05";
	shirtFigure = "";
	shirtNumber = jQuery("#selectCorStSize").val();
	//ノータック:0000101  1アウトタック:0000102  2アウトタック:0000104
	if(isNotEmpty(shirtNumber)){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":shirtModel,"figure":shirtFigure,"number":shirtNumber},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "01"){
						jQuery("#corStBodylength_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStBodylength_div_Size").val(data[i].typeSize);
	            		jQuery("#corStBodylength_div_Gross").val(data[i].typeSize);
					}
		        }
	        	if(data==""){
			    	jQuery("#corStBodylength_div_html")[0].innerHTML='000.0cm';
	        		jQuery("#corStBodylength_div_Size").val("0");
	        		jQuery("#corStBodylength_div_Gross").val("0");
				}
		    }		    
		})
	}
}
function shirtAdjust(){
	if(shirtModel==""||shirtModel==null){
		
	}else{
		jQuery("#corStNeckRange").val(0);
		setFont("corStNeckRange");
		jQuery("#corStBodylengthRange").val(0);
		setFont("corStBodylengthRange");
		jQuery("#corStRightsleeveRange").val(0);
		setFont("corStRightsleeveRange");
		jQuery("#corStLeftsleeveRange").val(0);
		setFont("corStLeftsleeveRange");
		jQuery("#corStBackdartsPackRange").val(0);
		setFont("corStBackdartsPackRange");
		jQuery("#corStRightcuffsSurroundingRange").val(0);
		setFont("corStRightcuffsSurroundingRange");
		jQuery("#corStLeftcuffsSurroundingRange").val(0);
		setFont("corStLeftcuffsSurroundingRange");
		

		jQuery("#corStNeckRange_out").html('0');
		jQuery("#corStBodylengthRange_out").html('0');
		jQuery("#corStRightsleeveRange_out").html('0');
		jQuery("#corStLeftsleeveRange_out").html('0');
		jQuery("#corStBackdartsPackRange_out").html('0');
		jQuery("#corStRightcuffsSurroundingRange_out").html('0');
		jQuery("#corStLeftcuffsSurroundingRange_out").html('0');
	}
	var subItemCode = "05";
	shirtFigure = "";
	shirtNumber = jQuery("#selectCorStSize").val();
	//ノータック:0000101  1アウトタック:0000102  2アウトタック:0000104
	if(isNotEmpty(shirtNumber)){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":shirtModel,"figure":shirtFigure,"number":shirtNumber},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "01"){
						jQuery("#corStBodylength_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStBodylength_div_Size").val(data[i].typeSize);
	            		jQuery("#corStBodylength_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "03"){
						jQuery("#corStRightsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStRightsleeve_div_Size").val(data[i].typeSize);
	            		jQuery("#corStRightsleeve_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "04"){
						jQuery("#corStLeftsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStLeftsleeve_div_Size").val(data[i].typeSize);
	            		jQuery("#corStLeftsleeve_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "11"){
						jQuery("#corStNeck_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStNeck_div_Size").val(data[i].typeSize);
	            		jQuery("#corStNeck_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "12"){
						jQuery("#corStRightcuffsSurrounding_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStRightcuffsSurrounding_div_Size").val(data[i].typeSize);
	            		jQuery("#corStRightcuffsSurrounding_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "13"){
						jQuery("#corStLeftcuffsSurrounding_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStLeftcuffsSurrounding_div_Size").val(data[i].typeSize);
	            		jQuery("#corStLeftcuffsSurrounding_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "19"){
						jQuery("#corStBackdartsPack_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corStBackdartsPack_div_Size").val(data[i].typeSize);
	            		jQuery("#corStBackdartsPack_div_Gross").val(data[i].typeSize);
					}
		        }
	        	if(data==""){
			    	for (shirt of shirtAdjustList) {
						jQuery("#"+shirt.id+"_html")[0].innerHTML = '000.0cm';
			    		jQuery("#"+shirt.id+"_Size").val("0");
			    		jQuery("#"+shirt.id+"_Gross").val("0");
					}
				 }
		    }		    
		})
	}else{
		for (shirt of shirtAdjustList) {
			jQuery("#"+shirt.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+shirt.id+"_Size").val("0");
    		jQuery("#"+shirt.id+"_Gross").val("0");
		}
	}}
function coatAdjust(){
	if(coatModel==""||coatModel==null){
		
	}else{
		jQuery("#corCtBodylengthRange").val(0);
		setFont("corCtBodylengthRange");
		jQuery("#corCtWaistRange").val(0);
		setFont("corCtWaistRange");
		jQuery("#corCtRightsleeveRange").val(0);
		setFont("corCtRightsleeveRange");
		jQuery("#corCtLeftsleeveRange").val(0);
		setFont("corCtLeftsleeveRange");
		jQuery("#corCtVenthightRange").val(0);
		setFont("corCtVenthightRange");
		jQuery("#corCtPktposRange").val(0);
		setFont("corCtPktposRange");
		
		jQuery("#corCtBodylengthRange_out").html('0');
		jQuery("#corCtWaistRange_out").html('0');
		jQuery("#corCtRightsleeveRange_out").html('0');
		jQuery("#corCtLeftsleeveRange_out").html('0');
		jQuery("#corCtVenthightRange_out").html('0');
		jQuery("#corCtPktposRange_out").html('0');
	}
	var subItemCode = "06";
	corCtFigure = "";
	corCtNumber = jQuery("#selectCorCtSize").val();
	if(isNotEmpty(corCtNumber)){
		jQuery.ajax({
	        url: contextPath + "/orderCo/getCoTypeSizeOptimization",
	        type: 'get',
	        async:false,
	        data:{"orderPattern":orderPattern,"subItemCode":subItemCode,"modelCode":coatModel,"figure":corCtFigure,"number":corCtNumber},
	        success: function(data){
	        	for(var i=0; i<data.length; i++){
					if(data[i].adjustClass == "01"){
						jQuery("#corCtBodylength_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corCtBodylength_div_Size").val(data[i].typeSize);
	            		jQuery("#corCtBodylength_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "02"){
						jQuery("#corCtWaist_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corCtWaist_div_Size").val(data[i].typeSize);
	            		jQuery("#corCtWaist_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "04"){
						jQuery("#corCtLeftsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corCtLeftsleeve_div_Size").val(data[i].typeSize);
	            		jQuery("#corCtLeftsleeve_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "03"){
						jQuery("#corCtRightsleeve_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corCtRightsleeve_div_Size").val(data[i].typeSize);
	            		jQuery("#corCtRightsleeve_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "17"){
						jQuery("#corCtVenthight_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corCtVenthight_div_Size").val(data[i].typeSize);
	            		jQuery("#corCtVenthight_div_Gross").val(data[i].typeSize);
					}else if(data[i].adjustClass == "18"){
						jQuery("#corCtPktpos_div_html")[0].innerHTML=data[i].typeSize + 'cm';
	            		jQuery("#corCtPktpos_div_Size").val(data[i].typeSize);
	            		jQuery("#corCtPktpos_div_Gross").val(data[i].typeSize);
					}
		        }
	        	if(data==""){
			    	for (coat of coatAdjustList) {
						jQuery("#"+coat.id+"_html")[0].innerHTML = '000.0cm';
			    		jQuery("#"+coat.id+"_Size").val("0");
			    		jQuery("#"+coat.id+"_Gross").val("0");
					}
				}
		    }	    
		})
	}else{
		for (coat of coatAdjustList) {
			jQuery("#"+coat.id+"_html")[0].innerHTML = '000.0cm';
    		jQuery("#"+coat.id+"_Size").val("0");
    		jQuery("#"+coat.id+"_Gross").val("0");
		}
	}	
}
function getFigureAndNumberByJkItem(){
	var subItemCode = "";
	if(isNotEmpty(jkModel)){
		subItemCode = "02";
		var jkFigure = document.getElementById("selectJacketFigure");
 	    getSizeFigure(itemCode,subItemCode,jkModel,jkFigure);
 	    
		var jkNumber = document.getElementById("selectJacketNumber");
		getSizeNumber(itemCode,subItemCode,jkModel,jkNumber);
	}
}
function getFigureAndNumberByPtItem(){
	var subItemCode = "";
	if(isNotEmpty(ptModel)){
		subItemCode = "03";
		var ptFigure = document.getElementById("selectPantsFigure");
 	    getSizeFigure(itemCode,subItemCode,ptModel,ptFigure);
 	    

		var ptNumber = document.getElementById("selectPantsNumber");
		getSizeNumber(itemCode,subItemCode,ptModel,ptNumber);
	}
}
function getFigureAndNumberByGlItem(){
	var subItemCode = "";
	if(isNotEmpty(glModel)){
		subItemCode = "04";
		var glFigure = document.getElementById("selectGiletFigure");
 	    getSizeFigure(itemCode,subItemCode,glModel,glFigure);
 	 
		var glNumber = document.getElementById("selectGiletNumber");
		getSizeNumber(itemCode,subItemCode,glModel,glNumber);
	}
}
function getFigureAndNumberByPt2Item(){
	var subItemCode = "";
	if(isNotEmpty(pt2Model)){
		subItemCode = "07";
		var pt2Figure = document.getElementById("selectPants2Figure");
 	    getSizeFigure(itemCode,subItemCode,pt2Model,pt2Figure);
		var pt2Number = document.getElementById("selectPants2Number");
		getSizeNumber(itemCode,subItemCode,pt2Model,pt2Number);
   }
}
function getFigureAndNumberByShirtItem(){
	var subItemCode = "";
	if(isNotEmpty(shirtModel)){
		subItemCode = itemCode;
		var selectCorStSize = document.getElementById("selectCorStSize");
		getSizeNumber(itemCode,subItemCode,shirtModel,selectCorStSize);
	}
}
function getFigureAndNumberByCoatItem(){
	var subItemCode = "";
	if(isNotEmpty(coatModel)){
		 subItemCode = itemCode;
		 var selectCorCtSize = document.getElementById("selectCorCtSize");
		 getSizeNumber(itemCode,subItemCode,coatModel,selectCorCtSize);
	  }
}
function getFigureAndNumberByItem(){
	var subItemCode = "";
	if(itemCode == "01"){
		if(isNotEmpty(jkModel)){
			subItemCode = "02";
			var jkFigure = document.getElementById("selectJacketFigure");
     	    getSizeFigure(itemCode,subItemCode,jkModel,jkFigure);
     	    
			var jkNumber = document.getElementById("selectJacketNumber");
			getSizeNumber(itemCode,subItemCode,jkModel,jkNumber);
		}
		if(isNotEmpty(ptModel)){
			subItemCode = "03";
			var ptFigure = document.getElementById("selectPantsFigure");
     	    getSizeFigure(itemCode,subItemCode,ptModel,ptFigure);
     	    

			var ptNumber = document.getElementById("selectPantsNumber");
			getSizeNumber(itemCode,subItemCode,ptModel,ptNumber);
		}
		if(isNotEmpty(glModel)){
			subItemCode = "04";
			var glFigure = document.getElementById("selectGiletFigure");
	 	    getSizeFigure(itemCode,subItemCode,glModel,glFigure);
	 	 
			var glNumber = document.getElementById("selectGiletNumber");
			getSizeNumber(itemCode,subItemCode,glModel,glNumber);
		}
		 if(isNotEmpty(pt2Model)){
				subItemCode = "07";
				var pt2Figure = document.getElementById("selectPants2Figure");
	     	    getSizeFigure(itemCode,subItemCode,pt2Model,pt2Figure);
				var pt2Number = document.getElementById("selectPants2Number");
				getSizeNumber(itemCode,subItemCode,pt2Model,pt2Number);
		 }
	}else if(itemCode == "02"){
		if(isNotEmpty(jkModel)){
		 subItemCode = itemCode;
		 var jkFigure = document.getElementById("selectJacketFigure");
 	     getSizeFigure(itemCode,subItemCode,jkModel,jkFigure);
 	    
		 var jkNumber = document.getElementById("selectJacketNumber");
		 getSizeNumber(itemCode,subItemCode,jkModel,jkNumber);
		}
	}else
	if(itemCode == "03"){
		if(isNotEmpty(ptModel)){
		 subItemCode = itemCode;
		 var ptFigure = document.getElementById("selectPantsFigure");
 	     getSizeFigure(itemCode,subItemCode,ptModel,ptFigure);
 	    
		 var ptNumber = document.getElementById("selectPantsNumber");
		 getSizeNumber(itemCode,subItemCode,ptModel,ptNumber);
		}
	}else
	if(itemCode == "04"){
		if(isNotEmpty(glModel)){
		 subItemCode = itemCode;
		 var glFigure = document.getElementById("selectGiletFigure");
 	     getSizeFigure(itemCode,subItemCode,glModel,glFigure);
 	    
		 var glNumber = document.getElementById("selectGiletNumber");
		 getSizeNumber(itemCode,subItemCode,glModel,glNumber);
		}
	}else
	if(itemCode == "05"){
		if(isNotEmpty(shirtModel)){
			subItemCode = itemCode;
			var selectCorStSize = document.getElementById("selectCorStSize");
			getSizeNumber(itemCode,subItemCode,shirtModel,selectCorStSize);
		}
    }else
	if(itemCode == "06"){
		if(isNotEmpty(coatModel)){
		 subItemCode = itemCode;
		 var selectCorCtSize = document.getElementById("selectCorCtSize");
		 getSizeNumber(itemCode,subItemCode,coatModel,selectCorCtSize);
		}
	}
}

function getSizeFigure(itemCode,subItemCode,modelCode,figure){
	figure.options.length=0;
	figure.add(new Option("選択　　　",""));
	jQuery.ajax({
        url: contextPath + "/orderCo/getSizeFigureByItem",
        type: 'get',
        async:false,
        data:{"orderPattern":"CO","itemCode":itemCode,"subItemCode":subItemCode,"modelCode":modelCode},
        success: function(data){
           jQuery.each(data, function (index, e) {
        	 
        	   figure.add(new Option(e.figure,e.figure));
           });
        }
    });
}

function getSizeNumber(itemCode,subItemCode,modelCode,number){
	number.options.length=0;
	number.add(new Option("選択　　　",""));
	jQuery.ajax({
        url: contextPath + "/orderCo/getSizeNumberByItem",
        type: 'get',
        async:false,
        data:{"orderPattern":"CO","itemCode":itemCode,"subItemCode":subItemCode,"modelCode":modelCode},
        success: function(data){
           jQuery.each(data, function (index, e) {
        	   number.add(new Option(e.sizeNumber,e.sizeNumber));
           });
        }
    });
}
 function adjustJkReInit(){
	
	var jkFigure = document.getElementById("selectJacketFigure");
	jkFigure.options.length=0;
	jkFigure.add(new Option("選択　　　",""));
	var jkNumber = document.getElementById("selectJacketNumber");
	jkNumber.options.length=0;
	jkNumber.add(new Option("選択　　　",""));
	
	jQuery("#corJkBody_div_Size").val("");
	jQuery("#corJkBody_div_Gross").val("");
	jQuery("#corJkBody_div_html").html("000.0cm");
	jQuery("#corJkBodyRange_out").html("0");
	jQuery("#corJkBodyRange").val("0");
	setFont("corJkBodyRange");
	
	jQuery("#corJkWaist_div_Size").val("");
	jQuery("#corJkWaist_div_Gross").val("");
	jQuery("#corJkWaist_div_html").html("000.0cm");
	jQuery("#corJkWaistRange_out").html("0");
	jQuery("#corJkWaistRange").val("0");
	setFont("corJkWaistRange");

	jQuery("#corJkRightsleeve_div_Size").val("");
	jQuery("#corJkRightsleeve_div_Gross").val("");
	jQuery("#corJkRightsleeve_div_html").html("000.0cm");
	jQuery("#corJkRightsleeveRange_out").html("0");
	jQuery("#corJkRightsleeveRange").val("0");
	setFont("corJkRightsleeveRange");

	jQuery("#corJkLeftsleeve_div_Size").val("");
	jQuery("#corJkLeftsleeve_div_Gross").val("");
	jQuery("#corJkLeftsleeve_div_html").html("000.0cm");
	jQuery("#corJkLeftsleeveRange_out").html("0");
	jQuery("#corJkLeftsleeveRange").val("0");
	setFont("corJkLeftsleeveRange");	
} 
 function adjustJkSession(){
	 if(isEmpty(jkModel)){
		 var jkFigure = document.getElementById("selectJacketFigure");
			jkFigure.options.length=0;
			jkFigure.add(new Option("選択　　　",""));
			var jkNumber = document.getElementById("selectJacketNumber");
			jkNumber.options.length=0;
			jkNumber.add(new Option("選択　　　",""));
		 }else{
			 jQuery("#selectJacketFigure").val("${orderCoForm.coAdjustJacketStandardInfo.sizeFigure}");
			 jQuery("#selectJacketNumber").val("${orderCoForm.coAdjustJacketStandardInfo.sizeNumber}");
		 }
		jQuery("#corJkBody_div_Size").val("${orderCoForm.coAdjustJacketStandardInfo.corJkBodySize}");
		jQuery("#corJkBody_div_Gross").val("${orderCoForm.coAdjustJacketStandardInfo.corJkBodyGross}");
		jQuery("#corJkBody_div_html").html("${orderCoForm.coAdjustJacketStandardInfo.corJkBodyGross}"+"cm");
		if("${orderCoForm.coAdjustJacketStandardInfo.corJkBodyGross}"=="" || "${orderCoForm.coAdjustJacketStandardInfo.corJkBodyGross}"=="0"){
			jQuery("#corJkBody_div_html").html("000.0cm");
			}
		jQuery("#corJkBodyRange_out").html("${orderCoForm.coAdjustJacketStandardInfo.corJkBodyCorrect}");
		if("${orderCoForm.coAdjustJacketStandardInfo.corJkBodyCorrect}"==""){
			jQuery("#corJkBodyRange_out").html("0");
		}
		jQuery("#corJkBodyRange").val("${orderCoForm.coAdjustJacketStandardInfo.corJkBodyCorrect}");
		setFont("corJkBodyRange");
		
		jQuery("#corJkWaist_div_Size").val("${orderCoForm.coAdjustJacketStandardInfo.corJkWaistSize}");
		jQuery("#corJkWaist_div_Gross").val("${orderCoForm.coAdjustJacketStandardInfo.corJkWaistGross}");
		jQuery("#corJkWaist_div_html").html("${orderCoForm.coAdjustJacketStandardInfo.corJkWaistGross}"+"cm");
		if("${orderCoForm.coAdjustJacketStandardInfo.corJkWaistGross}"=="" || "${orderCoForm.coAdjustJacketStandardInfo.corJkWaistGross}"=="0"){
			jQuery("#corJkWaist_div_html").html("000.0cm");
			}
		jQuery("#corJkWaistRange_out").html("${orderCoForm.coAdjustJacketStandardInfo.corJkWaistCorrect}");
        if("${orderCoForm.coAdjustJacketStandardInfo.corJkWaistCorrect}"==""){
        	jQuery("#corJkWaistRange_out").html("0");
            }
		jQuery("#corJkWaistRange").val("${orderCoForm.coAdjustJacketStandardInfo.corJkWaistCorrect}");
		setFont("corJkWaistRange");

		jQuery("#corJkRightsleeve_div_Size").val("${orderCoForm.coAdjustJacketStandardInfo.corJkRightsleeveSize}");
		jQuery("#corJkRightsleeve_div_Gross").val("${orderCoForm.coAdjustJacketStandardInfo.corJkRightsleeveGross}");
		jQuery("#corJkRightsleeve_div_html").html("${orderCoForm.coAdjustJacketStandardInfo.corJkRightsleeveGross}"+"cm");
		if("${orderCoForm.coAdjustJacketStandardInfo.corJkRightsleeveGross}"=="" || "${orderCoForm.coAdjustJacketStandardInfo.corJkRightsleeveGross}"=="0"){
			jQuery("#corJkRightsleeve_div_html").html("000.0cm");
			}
		jQuery("#corJkRightsleeveRange_out").html("${orderCoForm.coAdjustJacketStandardInfo.corJkRightsleeveCorrect}");
        if("${orderCoForm.coAdjustJacketStandardInfo.corJkRightsleeveCorrect}"==""){
        	jQuery("#corJkRightsleeveRange_out").html("0");
            }
		jQuery("#corJkRightsleeveRange").val("${orderCoForm.coAdjustJacketStandardInfo.corJkRightsleeveCorrect}");
		setFont("corJkRightsleeveRange");

		jQuery("#corJkLeftsleeve_div_Size").val("${orderCoForm.coAdjustJacketStandardInfo.corJkLeftsleeveSize}");
		jQuery("#corJkLeftsleeve_div_Gross").val("${orderCoForm.coAdjustJacketStandardInfo.corJkLeftsleeveGross}");
		jQuery("#corJkLeftsleeve_div_html").html("${orderCoForm.coAdjustJacketStandardInfo.corJkLeftsleeveGross}"+"cm");
		if("${orderCoForm.coAdjustJacketStandardInfo.corJkLeftsleeveGross}"=="" || "${orderCoForm.coAdjustJacketStandardInfo.corJkLeftsleeveGross}"=="0"){
			jQuery("#corJkLeftsleeve_div_html").html("000.0cm");
			}
		jQuery("#corJkLeftsleeveRange_out").html("${orderCoForm.coAdjustJacketStandardInfo.corJkLeftsleeveCorrect}");
        if("${orderCoForm.coAdjustJacketStandardInfo.corJkLeftsleeveCorrect}"==""){
        	jQuery("#corJkLeftsleeveRange_out").html("0");
            }
		jQuery("#corJkLeftsleeveRange").val("${orderCoForm.coAdjustJacketStandardInfo.corJkLeftsleeveCorrect}");
		setFont("corJkLeftsleeveRange");
		
		var corJkShoulderPadValue="${orderCoForm.coAdjustJacketStandardInfo.corJkShoulderPadCd}";
		var corJkFigureCorrectValue="${orderCoForm.coAdjustJacketStandardInfo.corJkFigureCorrectCd}"; 
		if(corJkShoulderPadValue=="0004501"){
			jQuery("#oj_shoulderPat_id1").prop("checked", true);
		}else if(corJkShoulderPadValue=="0004502"){
			jQuery("#oj_shoulderPat_id2").prop("checked", true);
		}else if(corJkShoulderPadValue=="0004503"){
			jQuery("#oj_shoulderPat_id3").prop("checked", true);
		}
		if(corJkFigureCorrectValue=="0004601"){
			jQuery("#oj_figureAlter_id1").prop("checked", true);
		}else if(corJkFigureCorrectValue=="0004602"){
			jQuery("#oj_figureAlter_id2").prop("checked", true);
		}else if(corJkFigureCorrectValue=="0004603"){
			jQuery("#oj_figureAlter_id3").prop("checked", true);
		}
	}
function  modelChoose(Model,oModel,tModel,wModel){
	if(productCategory=="9000101"){
		Model = oModel;
		return Model;
	}else if(productCategory=="9000102"){
		Model = tModel;
		return Model;
	}else if(productCategory=="9000103"){
		Model = wModel;
		return Model;
	}	
}

function adjustPtReInit(){
	
	//PTサイズを設定
	var ptFigure = document.getElementById("selectPantsFigure");
	ptFigure.options.length=0;
	ptFigure.add(new Option("選択　　　",""));
	var ptNumber = document.getElementById("selectPantsNumber");
	ptNumber.options.length=0;
	ptNumber.add(new Option("選択　　　",""));
	
	//PT　型サイズ値、補正値とグロス値を設定
	jQuery("#corPtWaist_div_Size").val("");
	jQuery("#corPtWaist_div_Gross").val("");
	jQuery("#corPtWaist_div_html").html("000.0cm");
	jQuery("#corPtWaistRange_out").html("0");
	jQuery("#corPtWaistRange").val("0");
	setFont("corPtWaistRange");

	jQuery("#corPtHip_div_Size").val("");
	jQuery("#corPtHip_div_Gross").val("");
	jQuery("#corPtHip_div_html").html("000.0cm");
	jQuery("#corPtHipRange_out").html("0");
	jQuery("#corPtHipRange").val("0");
	setFont("corPtHipRange");
	
	jQuery("#corPtThigh_div_Size").val("");
	jQuery("#corPtThigh_div_Gross").val("");
	jQuery("#corPtThigh_div_html").html("000.0cm");
	jQuery("#corPtThighRange_out").html("0");
	jQuery("#corPtThighRange").val("0");
	setFont("corPtThighRange");

	jQuery("#corPtHemwidth_div_Size").val("");
	jQuery("#corPtHemwidth_div_Gross").val("");
	jQuery("#corPtHemwidth_div_html").html("000.0cm");
	jQuery("#corPtHemwidthRange_out").html("0");
	jQuery("#corPtHemwidthRange").val("0");
	setFont("corPtHemwidthRange");

	jQuery("#corPtRightinseam_div_Size").val("");
	jQuery("#corPtLeftinseam_div_Size").val("");

	jQuery("#corPtRightinseamGross").val("");	
	jQuery("#ap_inseamRightM1").val("0");
	jQuery("#ap_inseamRight100").val("0");
	jQuery("#ap_inseamRight10").val("0");
	jQuery("#ap_inseamRight1").val("0");
	
	jQuery("#corPtLeftinseamGross").val("");
	jQuery("#ap_inseamLeftM1").val("0");
	jQuery("#ap_inseamLeft100").val("0");
	jQuery("#ap_inseamLeft10").val("0");
	jQuery("#ap_inseamLeft1").val("0");

	
	jQuery("#corPtHemwidthDegignate").val("");
	jQuery("#ap_hemWidthAbs10").val("1");
	jQuery("#ap_hemWidthAbs1").val("0");
	jQuery("#ap_hemWidthAbsM1").val("0");

} 
function adjustGlReInit(){
	//GLサイズを設定
	var glFigure = document.getElementById("selectGiletFigure");
	glFigure.options.length=0;
	glFigure.add(new Option("選択　　　",""));
	var glNumber = document.getElementById("selectGiletNumber");
	glNumber.options.length=0;
	glNumber.add(new Option("選択　　　",""));

	jQuery("#corGlBody_div_Size").val("");
	jQuery("#corGlBody_div_Gross").val("");
	jQuery("#corGlBody_div_html").html("000.0cm");
	jQuery("#corGlBodyRange_out").html("0");
	jQuery("#corGlBodyRange").val("0");
	setFont("corGlBodyRange");
	
	jQuery("#corGlBust_div_Size").val("");
	jQuery("#corGlBust_div_Gross").val("");
	jQuery("#corGlBust_div_html").html("000.0cm");
	jQuery("#corGlBust_out").html("0");
	jQuery("#corGlBustRange").val("0");
	setFont("corGlBustRange");

	jQuery("#corGlWaist_div_Size").val("");
	jQuery("#corGlWaist_div_Gross").val("");
	jQuery("#corGlWaist_div_html").html("000.0cm");
	jQuery("#corGlWaist_out").html("0");
	jQuery("#corGlWaistRange").val("0");
	setFont("corGlWaistRange");
} 
function adjustPt2ReInit(){
	
	 //2PTサイズを設定
	var pt2Figure = document.getElementById("selectPants2Figure");
	pt2Figure.options.length=0;
	pt2Figure.add(new Option("選択　　　",""));
	var pt2Number = document.getElementById("selectPants2Number");
	pt2Number.options.length=0;
	pt2Number.add(new Option("選択　　　",""));
	
	//2PT　型サイズ値、補正値とグロス値を設定
	jQuery("#corPt2Waist_div_Size").val("");
	jQuery("#corPt2Waist_div_Gross").val("");
	jQuery("#corPt2Waist_div_html").html("000.0cm");
	jQuery("#corPt2WaistRange_out").html("0");
	jQuery("#corPt2WaistRange").val("0");
	setFont("corPt2WaistRange");

	jQuery("#corPt2Hip_div_Size").val("");
	jQuery("#corPt2Hip_div_Gross").val("");
	jQuery("#corPt2Hip_div_html").html("000.0cm");
	jQuery("#corPt2HipRange_out").html("0");
	jQuery("#corPt2HipRange").val("0");
	setFont("corPt2HipRange");
	
	jQuery("#corPt2Thigh_div_Size").val("");
	jQuery("#corPt2Thigh_div_Gross").val("");
	jQuery("#corPt2Thigh_div_html").html("000.0cm");
	jQuery("#corPt2ThighRange_out").html("0");
	jQuery("#corPt2ThighRange").val("0");
	setFont("corPt2ThighRange");

	jQuery("#corPt2Hemwidth_div_Size").val("");
	jQuery("#corPt2Hemwidth_div_Gross").val("");
	jQuery("#corPt2Hemwidth_div_html").html("000.0cm");
	jQuery("#corPt2HemwidthRange_out").html("0");
	jQuery("#corPt2HemwidthRange").val("0");
	setFont("corPt2HemwidthRange");

	jQuery("#corPt2Rightinseam_div_Size").val("");
	jQuery("#corPt2Leftinseam_div_Size").val("");

	jQuery("#corPt2RightinseamGross").val("");
	jQuery("#ap2_inseamRightM1").val("0");
	jQuery("#ap2_inseamRight100").val("0");
	jQuery("#ap2_inseamRight10").val("0");
	jQuery("#ap2_inseamRight1").val("0");
	
	
	jQuery("#corPt2LeftinseamGross").val("");
	jQuery("#ap2_inseamLeftM1").val("0");
	jQuery("#ap2_inseamLeft100").val("0");
	jQuery("#ap2_inseamLeft10").val("0");
	jQuery("#ap2_inseamLeft1").val("0");

	jQuery("#corPt2HemwidthDegignate").val("");
	jQuery("#ap2_hemWidthAbs10").val("1");
	jQuery("#ap2_hemWidthAbs1").val("0");
	jQuery("#ap2_hemWidthAbsM1").val("0");
} 

function adjustCoatReInit(){
	// COAT
	var corCtSize = document.getElementById("selectCorCtSize");
	corCtSize.options.length=0;
	corCtSize.add(new Option("選択　　　",""));

	jQuery("#corCtBodylength_div_Size").val("");
	jQuery("#corCtBodylength_div_Gross").val("");
	jQuery("#corCtBodylength_div_html").html("000.0cm");
	jQuery("#corCtBodylengthRange_out").html("0");
	jQuery("#corCtBodylengthRange").val("0");
	setFont("corCtBodylengthRange");

	jQuery("#corCtWaist_div_Size").val("");
	jQuery("#corCtWaist_div_Gross").val("");
	jQuery("#corCtWaist_div_html").html("000.0cm");
	jQuery("#corCtWaistRange_out").html("0");
	jQuery("#corCtWaistRange").val("0");
	setFont("corCtWaistRange");

	jQuery("#corCtRightsleeve_div_Size").val("");
	jQuery("#corCtRightsleeve_div_Gross").val("");
	jQuery("#corCtRightsleeve_div_html").html("000.0cm");
	jQuery("#corRightsleeveRange_out").html("0");
	jQuery("#corCtRightsleeveRange").val("0");
	setFont("corCtRightsleeveRange");

	jQuery("#corCtLeftsleeve_div_Size").val("");
	jQuery("#corCtLeftsleeve_div_Gross").val("");
	jQuery("#corCtLeftsleeve_div_html").html("000.0cm");
	jQuery("#corCtLeftsleeve_out").html("0");
	jQuery("#corCtLeftsleeveRange").val("0");
	setFont("corCtLeftsleeveRange");

	jQuery("#corCtVenthight_div_Size").val("");
	jQuery("#corCtVenthight_div_Gross").val("");
	jQuery("#corCtVenthight_div_html").html("000.0cm");
	jQuery("#corCtVenthightRange_out").html("0");
	jQuery("#corCtVenthightRange").val("0");
	setFont("corCtVenthightRange");

	jQuery("#corCtPktpos_div_Size").val("");
	jQuery("#corCtPktpos_div_Gross").val("");
	jQuery("#corCtPktpos_div_html").html("000.0cm");
	jQuery("#corCtPktposRange_out").html("0");
	jQuery("#corCtPktposRange").val("0");
	setFont("corCtPktposRange");
	
} 
function adjustShirtReInit(){
	//SHIRT
	var corStSize = document.getElementById("selectCorStSize");
	corStSize.options.length=0;
	corStSize.add(new Option("選択　　　",""));

	jQuery("#corStNeck_div_Size").val("");
	jQuery("#corStNeck_div_Gross").val("");
	jQuery("#corStNeck_div_html").html("000.0cm");
	jQuery("#corStNeckRange_out").html("0");
	jQuery("#corStNeckRange").val("0");
	setFont("corStNeckRange");
	
	jQuery("#corStBodylength_div_Size").val("");
	jQuery("#corStBodylength_div_Gross").val("");
	jQuery("#corStBodylength_div_html").html("000.0cm");
	jQuery("#corStBodylength_out").html("0");
	jQuery("#corStBodylengthRange").val("0");
	setFont("corStBodylengthRange");

	jQuery("#corStRightsleeve_div_Size").val("");
	jQuery("#corStRightsleeve_div_Gross").val("");
	jQuery("#corStRightsleeve_div_html").html("000.0cm");
	jQuery("#corStRightsleeve_out").html("0");
	jQuery("#corStRightsleeveRange").val("0");
	setFont("corStRightsleeveRange");

	jQuery("#corStLeftsleeve_div_Size").val("");
	jQuery("#corStLeftsleeve_div_Gross").val("");
	jQuery("#corStLeftsleeve_div_html").html("000.0cm");
	jQuery("#corStLeftsleeveRange_out").html("0");
	jQuery("#corStLeftsleeveRange").val("0");
	setFont("corStLeftsleeveRange");

	jQuery("#corStBackdartsPack_div_Size").val("");
	jQuery("#corStBackdartsPack_div_Gross").val("");
	jQuery("#corStBackdartsPack_div_html").html("000.0cm");
	jQuery("#corStBackdartsPackRange_out").html("0");
	jQuery("#corStBackdartsPackRange").val("0");
	setFont("corStBackdartsPackRange");

	jQuery("#corStRightcuffsSurrounding_div_Size").val("");
	jQuery("#corStRightcuffsSurrounding_div_Gross").val("");
	jQuery("#corStRightcuffsSurrounding_div_html").html("000.0cm");
	jQuery("#corStRightcuffsSurroundingRange_out").html("0");
	jQuery("#corStRightcuffsSurroundingRange").val("0");
	setFont("corStRightcuffsSurroundingRange");

	jQuery("#corStLeftcuffsSurrounding_div_Size").val("");
	jQuery("#corStLeftcuffsSurrounding_div_Gross").val("");
	jQuery("#corStLeftcuffsSurrounding_div_html").html("000.0cm");
	jQuery("#corStLeftcuffsSurroundingRange_out").html("0");
	jQuery("#corStLeftcuffsSurroundingRange").val("0");
	setFont("corStLeftcuffsSurroundingRange");
} 
function adjustPtSession(){
	if(isEmpty(ptModel)){
		//PTサイズを設定
		var ptFigure = document.getElementById("selectPantsFigure");
		ptFigure.options.length=0;
		ptFigure.add(new Option("選択　　　",""));
		var ptNumber = document.getElementById("selectPantsNumber");
		ptNumber.options.length=0;
		ptNumber.add(new Option("選択　　　",""));
	}else{
		jQuery("#selectPantsFigure").val("${orderCoForm.coAdjustPantsStandardInfo.sizeFigure}");
		jQuery("#selectPantsNumber").val("${orderCoForm.coAdjustPantsStandardInfo.sizeNumber}");
	}
	//PT　型サイズ値、補正値とグロス値を設定
	jQuery("#corPtWaist_div_Size").val("${orderCoForm.coAdjustPantsStandardInfo.corPtWaistSize}");
	jQuery("#corPtWaist_div_Gross").val("${orderCoForm.coAdjustPantsStandardInfo.corPtWaistGross}");
	jQuery("#corPtWaist_div_html").html("${orderCoForm.coAdjustPantsStandardInfo.corPtWaistGross}"+"cm");
	if("${orderCoForm.coAdjustPantsStandardInfo.corPtWaistGross}"=="" || "${orderCoForm.coAdjustPantsStandardInfo.corPtWaistGross}"=="0"){
		jQuery("#corPtWaist_div_html").html("000.0cm");
		}
	jQuery("#corPtWaistRange_out").html("${orderCoForm.coAdjustPantsStandardInfo.corPtWaistCorrect}");
    if("${orderCoForm.coAdjustPantsStandardInfo.corPtWaistCorrect}"==""){
    	jQuery("#corPtWaistRange_out").html("0");
        }
	jQuery("#corPtWaistRange").val("${orderCoForm.coAdjustPantsStandardInfo.corPtWaistCorrect}");
	setFont("corPtWaistRange");

	jQuery("#corPtHip_div_Size").val("${orderCoForm.coAdjustPantsStandardInfo.corPtHipSize}");
	jQuery("#corPtHip_div_Gross").val("${orderCoForm.coAdjustPantsStandardInfo.corPtHipGross}");
	jQuery("#corPtHip_div_html").html("${orderCoForm.coAdjustPantsStandardInfo.corPtHipGross}"+"cm");
	if("${orderCoForm.coAdjustPantsStandardInfo.corPtHipGross}"=="" || "${orderCoForm.coAdjustPantsStandardInfo.corPtHipGross}"=="0"){
		jQuery("#corPtHip_div_html").html("000.0cm");
		}
	jQuery("#corPtHipRange_out").html("${orderCoForm.coAdjustPantsStandardInfo.corPtHipCorrect}");
	if("${orderCoForm.coAdjustPantsStandardInfo.corPtHipCorrect}"==""){
		jQuery("#corPtHipRange_out").html("0");
		}
	jQuery("#corPtHipRange").val("${orderCoForm.coAdjustPantsStandardInfo.corPtHipCorrect}");
	setFont("corPtHipRange");
	
	jQuery("#corPtThigh_div_Size").val("${orderCoForm.coAdjustPantsStandardInfo.corPtThighSize}");
	jQuery("#corPtThigh_div_Gross").val("${orderCoForm.coAdjustPantsStandardInfo.corPtThighGross}");
	jQuery("#corPtThigh_div_html").html("${orderCoForm.coAdjustPantsStandardInfo.corPtThighGross}"+"cm");
	if("${orderCoForm.coAdjustPantsStandardInfo.corPtThighGross}"=="" || "${orderCoForm.coAdjustPantsStandardInfo.corPtThighGross}"=="0"){
		jQuery("#corPtThigh_div_html").html("000.0cm");
		}
	jQuery("#corPtThighRange_out").html("${orderCoForm.coAdjustPantsStandardInfo.corPtThighCorrect}");
    if("${orderCoForm.coAdjustPantsStandardInfo.corPtThighCorrect}"==""){
    	jQuery("#corPtThighRange_out").html("0");
        }
	jQuery("#corPtThighRange").val("${orderCoForm.coAdjustPantsStandardInfo.corPtThighCorrect}");
	setFont("corPtThighRange");

	var corPtRightinseamSize = "${orderCoForm.coAdjustPantsStandardInfo.corPtRightinseamSize}";
	jQuery("#corPtRightinseam_div_Size").val(corPtRightinseamSize);	
	
	var corPtRightinseamGross = "${orderCoForm.coAdjustPantsStandardInfo.corPtRightinseamGross}";
	jQuery("#corPtRightinseamGross").val(corPtRightinseamGross);	
	corPtRightinseamGross = corPtRightinseamGross.split(".");
	if(isNotEmpty(corPtRightinseamGross[1])){
		jQuery("#ap_inseamRightM1").val(corPtRightinseamGross[1]);
	}
	var str = corPtRightinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var right1 = str[2];
		var right10 = str[1];
		var right100 = str[0];
		jQuery("#ap_inseamRight100").val(right100);
		jQuery("#ap_inseamRight10").val(right10);
		jQuery("#ap_inseamRight1").val(right1);
	}else if(str.length == 2){
		str = str.split("");
		var right1 = str[1];
		var right10 = str[0];
		jQuery("#ap_inseamRight100").val("0");
		jQuery("#ap_inseamRight10").val(right10);
		jQuery("#ap_inseamRight1").val(right1);
	}else if(str.length == 1){
		str = str.split("");
		var right1 = str[0];
		jQuery("#ap_inseamRight100").val("0");
		jQuery("#ap_inseamRight10").val("0");
		jQuery("#ap_inseamRight1").val(right1);
	}

	var corPtLeftinseamSize = "${orderCoForm.coAdjustPantsStandardInfo.corPtLeftinseamSize}";
	jQuery("#corPtLeftinseam_div_Size").val(corPtLeftinseamSize);
	var corPtLeftinseamGross = "${orderCoForm.coAdjustPantsStandardInfo.corPtLeftinseamGross}";
	jQuery("#corPtLeftinseamGross").val(corPtLeftinseamGross);
	corPtLeftinseamGross = corPtLeftinseamGross.split(".");
	if(isNotEmpty(corPtLeftinseamGross[1])){
		jQuery("#ap_inseamLeftM1").val(corPtLeftinseamGross[1]);
	}
	var str = corPtLeftinseamGross[0];
	if(str.length == 3){
		str = str.split("");
		var left1 = str[2];
		var left10 = str[1];
		var left100 = str[0];
		jQuery("#ap_inseamLeft100").val(left100);
		jQuery("#ap_inseamLeft10").val(left10);
		jQuery("#ap_inseamLeft1").val(left1);
	}else if(str.length == 2){
		str = str.split("");
		var left1 = str[1];
		var left10 = str[0];
		jQuery("#ap_inseamLeft100").val("0");
		jQuery("#ap_inseamLeft10").val(left10);
		jQuery("#ap_inseamLeft1").val(left1);
	}else if(str.length == 1){
		str = str.split("");
		var left1 = str[0];
		jQuery("#ap_inseamLeft100").val("0");
		jQuery("#ap_inseamLeft10").val("0");
		jQuery("#ap_inseamLeft1").val(left1);
	}

	var corPtHemwidthTypeValue="${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthType}";
	if(corPtHemwidthTypeValue=="1"){
		jQuery("#pt_hemWidth_relative").prop("checked", true);
		jQuery("#pt_hemWidth_relative").click();
		jQuery("#corPtHemwidth_div_Size").val("${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthSize}");
		jQuery("#corPtHemwidth_div_Gross").val("${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthGross}");
		jQuery("#corPtHemwidth_div_html").html("${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthGross}"+"cm");
		if("${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthGross}"=="" || "${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthGross}"=="0"){
			jQuery("#corPtHemwidth_div_html").html("000.0cm");
			}
		jQuery("#corPtHemwidthRange_out").html("${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthCorrect}");
         if("${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthCorrect}"==""){
        	 jQuery("#corPtHemwidthRange_out").html("0");
             }
		jQuery("#corPtHemwidthRange").val("${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthCorrect}");
		setFont("corPtHemwidthRange");
	 }else if(corPtHemwidthTypeValue=="2"){
		 jQuery("#pt_hemWidth_absolute").prop("checked", true);
		 jQuery("#corPtHemwidthRangeId").hide();
		 jQuery("#pt_hemWidth_absolute").click();
			var corPtHemwidthDegignate = "${orderCoForm.coAdjustPantsStandardInfo.corPtHemwidthDegignate}";
			jQuery("#corPtHemwidthDegignate").val(corPtHemwidthDegignate);
			corPtHemwidthDegignate = corPtHemwidthDegignate.split(".");
			if(isNotEmpty(corPtHemwidthDegignate[1])){
				jQuery("#ap_hemWidthAbsM1").val(corPtHemwidthDegignate[1]);
			}
			var str = corPtHemwidthDegignate[0];
			if(str.length == 2){
				str = str.split("");
				var left1 = str[1];
				var left10 = str[0];
				if(left10=="1"){
					jQuery("#ap_hemWidthAbs10").val("1");
				}else if(left10=="2"){
					jQuery("#ap_hemWidthAbs10").val("2");
				}
				jQuery("#ap_hemWidthAbs1").val(left1);
			}
    }
}
	function adjustGlSession(){
		 if(isEmpty(glModel)){
			//GLサイズを設定
			var glFigure = document.getElementById("selectGiletFigure");
			glFigure.options.length=0;
			glFigure.add(new Option("選択　　　",""));
			var glNumber = document.getElementById("selectGiletNumber");
			glNumber.options.length=0;
			glNumber.add(new Option("選択　　　",""));
		 }else{
			 jQuery("#selectGiletFigure").val("${orderCoForm.coAdjustGiletStandardInfo.sizeFigure}");
			 jQuery("#selectGiletNumber").val("${orderCoForm.coAdjustGiletStandardInfo.sizeNumber}");
		 }
		jQuery("#selectGiletFigure").val("${orderCoForm.coAdjustGiletStandardInfo.sizeFigure}");
		jQuery("#selectGiletNumber").val("${orderCoForm.coAdjustGiletStandardInfo.sizeNumber}");

		jQuery("#corGlBody_div_Size").val("${orderCoForm.coAdjustGiletStandardInfo.corGlBodySize}");
		jQuery("#corGlBody_div_Gross").val("${orderCoForm.coAdjustGiletStandardInfo.corGlBodyGross}");
		jQuery("#corGlBody_div_html").html("${orderCoForm.coAdjustGiletStandardInfo.corGlBodyGross}"+"cm");
		if("${orderCoForm.coAdjustGiletStandardInfo.corGlBodyGross}"=="" || "${orderCoForm.coAdjustGiletStandardInfo.corGlBodyGross}"=="0"){
			jQuery("#corGlBody_div_html").html("000.0cm");
			}
		jQuery("#corGlBodyRange_out").html("${orderCoForm.coAdjustGiletStandardInfo.corGlBodyCorrect}");
        if("${orderCoForm.coAdjustGiletStandardInfo.corGlBodyCorrect}"==""){
        	jQuery("#corGlBodyRange_out").html("0");
            }
		jQuery("#corGlBodyRange").val("${orderCoForm.coAdjustGiletStandardInfo.corGlBodyCorrect}");
		setFont("corGlBodyRange");
		
		jQuery("#corGlBust_div_Size").val("${orderCoForm.coAdjustGiletStandardInfo.corGlBustSize}");
		jQuery("#corGlBust_div_Gross").val("${orderCoForm.coAdjustGiletStandardInfo.corGlBustGross}");
		jQuery("#corGlBust_div_html").html("${orderCoForm.coAdjustGiletStandardInfo.corGlBustGross}"+"cm");
		if("${orderCoForm.coAdjustGiletStandardInfo.corGlBustGross}"=="" || "${orderCoForm.coAdjustGiletStandardInfo.corGlBustGross}"=="0"){
			jQuery("#corGlBust_div_html").html("000.0cm");
			}
		jQuery("#corGlBustRange_out").html("${orderCoForm.coAdjustGiletStandardInfo.corGlBustCorrect}");
        if("${orderCoForm.coAdjustGiletStandardInfo.corGlBustCorrect}"==""){
        	jQuery("#corGlBustRange_out").html("0");
            }
		jQuery("#corGlBustRange").val("${orderCoForm.coAdjustGiletStandardInfo.corGlBustCorrect}");
		setFont("corGlBustRange");

		jQuery("#corGlWaist_div_Size").val("${orderCoForm.coAdjustGiletStandardInfo.corGlWaistSize}");
		jQuery("#corGlWaist_div_Gross").val("${orderCoForm.coAdjustGiletStandardInfo.corGlWaistGross}");
		jQuery("#corGlWaist_div_html").html("${orderCoForm.coAdjustGiletStandardInfo.corGlWaistGross}"+"cm");
		if("${orderCoForm.coAdjustGiletStandardInfo.corGlWaistGross}"=="" || "${orderCoForm.coAdjustGiletStandardInfo.corGlWaistGross}"=="0"){
			jQuery("#corGlWaist_div_html").html("000.0cm");
			}
		jQuery("#corGlWaistRange_out").html("${orderCoForm.coAdjustGiletStandardInfo.corGlWaistCorrect}");
        if("${orderCoForm.coAdjustGiletStandardInfo.corGlWaistCorrect}"==""){
        	jQuery("#corGlWaistRange_out").html("0");
            }
		jQuery("#corGlWaistRange").val("${orderCoForm.coAdjustGiletStandardInfo.corGlWaistCorrect}");
		setFont("corGlWaistRange");
	}
	function adjustPt2Session(){
		if(isEmpty(pt2Model)){
			//2PTサイズを設定
			var pt2Figure = document.getElementById("selectPants2Figure");
			pt2Figure.options.length=0;
			pt2Figure.add(new Option("選択　　　",""));
			var pt2Number = document.getElementById("selectPants2Number");
			pt2Number.options.length=0;
			pt2Number.add(new Option("選択　　　",""));
		}else{
			jQuery("#selectPants2Figure").val("${orderCoForm.coAdjustPants2StandardInfo.sizeFigure}");
			jQuery("#selectPants2Number").val("${orderCoForm.coAdjustPants2StandardInfo.sizeNumber}");	
		}
		//2PT　型サイズ値、補正値とグロス値を設定
		jQuery("#corPt2Waist_div_Size").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2WaistSize}");
		jQuery("#corPt2Waist_div_Gross").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2WaistGross}");
		jQuery("#corPt2Waist_div_html").html("${orderCoForm.coAdjustPants2StandardInfo.corPt2WaistGross}"+"cm");
		if("${orderCoForm.coAdjustPants2StandardInfo.corPt2WaistGross}"=="" || "${orderCoForm.coAdjustPants2StandardInfo.corPt2WaistGross}"=="0"){
			jQuery("#corPt2Waist_div_html").html("000.0cm");
			}
		jQuery("#corPt2WaistRange_out").html("${orderCoForm.coAdjustPants2StandardInfo.corPt2WaistCorrect}");
        if("${orderCoForm.coAdjustPants2StandardInfo.corPt2WaistCorrect}"==""){
        	jQuery("#corPt2WaistRange_out").html("0");
            }
		jQuery("#corPt2WaistRange").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2WaistCorrect}");
		setFont("corPt2WaistRange");

		jQuery("#corPt2Hip_div_Size").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2HipSize}");
		jQuery("#corPt2Hip_div_Gross").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2HipGross}");
		jQuery("#corPt2Hip_div_html").html("${orderCoForm.coAdjustPants2StandardInfo.corPt2HipGross}"+"cm");
		if("${orderCoForm.coAdjustPants2StandardInfo.corPt2HipGross}"=="" || "${orderCoForm.coAdjustPants2StandardInfo.corPt2HipGross}"=="0"){
			jQuery("#corPt2Hip_div_html").html("000.0cm");
			}
		jQuery("#corPt2HipRange_out").html("${orderCoForm.coAdjustPants2StandardInfo.corPt2HipCorrect}");
        if("${orderCoForm.coAdjustPants2StandardInfo.corPt2HipCorrect}"==""){
        	jQuery("#corPt2HipRange_out").html("0"); 
            }
		jQuery("#corPt2HipRange").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2HipCorrect}");
		setFont("corPt2HipRange");
		
		jQuery("#corPt2Thigh_div_Size").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2ThighSize}");
		jQuery("#corPt2Thigh_div_Gross").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2ThighGross}");
		jQuery("#corPt2Thigh_div_html").html("${orderCoForm.coAdjustPants2StandardInfo.corPt2ThighGross}"+"cm");
		if("${orderCoForm.coAdjustPants2StandardInfo.corPt2ThighGross}"=="" || "${orderCoForm.coAdjustPants2StandardInfo.corPt2ThighGross}"=="0"){
			jQuery("#corPt2Thigh_div_html").html("000.0cm");
			}
		jQuery("#corPt2ThighRange_out").html("${orderCoForm.coAdjustPants2StandardInfo.corPt2ThighCorrect}");
        if("${orderCoForm.coAdjustPants2StandardInfo.corPt2ThighCorrect}"==""){
        	jQuery("#corPt2ThighRange_out").html("0"); 
            }
		jQuery("#corPt2ThighRange").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2ThighCorrect}");
		setFont("corPt2ThighRange");

		jQuery("#corPt2Hemwidth_div_Size").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthSize}");
		jQuery("#corPt2Hemwidth_div_Gross").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthGross}");
		jQuery("#corPt2Hemwidth_div_html").html("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthGross}"+"cm");
		if("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthGross}"=="" || "${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthGross}"=="0"){
			jQuery("#corPt2Hemwidth_div_html").html("000.0cm");
			}
		jQuery("#corPt2HemwidthRange_out").html("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthCorrect}");
        if("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthCorrect}"==""){
        	jQuery("#corPt2HemwidthRange_out").html("0");
            }
		jQuery("#corPt2HemwidthRange").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthCorrect}");
		setFont("corPt2HemwidthRange");

		var corPt2RightinseamSize = "${orderCoForm.coAdjustPants2StandardInfo.corPt2RightinseamSize}";
		jQuery("#corPt2Rightinseam_div_Size").val(corPt2RightinseamSize);


		var corPt2RightinseamGross = "${orderCoForm.coAdjustPants2StandardInfo.corPt2RightinseamGross}";
		jQuery("#corPt2RightinseamGross").val(corPt2RightinseamGross);
		corPt2RightinseamGross = corPt2RightinseamGross.split(".");
		if(isNotEmpty(corPt2RightinseamGross[1])){
			jQuery("#ap2_inseamRightM1").val(corPt2RightinseamGross[1]);
		}else{
			jQuery("#ap2_inseamRightM1").val("0");
		}
		var str = corPt2RightinseamGross[0];
		if(str.length == 3){
			str = str.split("");
			var right1 = str[2];
			var right10 = str[1];
			var right100 = str[0];
			jQuery("#ap2_inseamRight100").val(right100);
			jQuery("#ap2_inseamRight10").val(right10);
			jQuery("#ap2_inseamRight1").val(right1);
		}else if(str.length == 2){
			str = str.split("");
			var right1 = str[1];
			var right10 = str[0];
			jQuery("#ap2_inseamRight100").val("0");
			jQuery("#ap2_inseamRight10").val(right10);
			jQuery("#ap2_inseamRight1").val(right1);
		}else if(str.length == 1){
			str = str.split("");
			var right1 = str[0];
			jQuery("#ap2_inseamRight100").val("0");
			jQuery("#ap2_inseamRight10").val("0");
			jQuery("#ap2_inseamRight1").val(right1);
		}
		
		var corPt2LeftinseamSize = "${orderCoForm.coAdjustPants2StandardInfo.corPt2LeftinseamSize}";
		jQuery("#corPt2Leftinseam_div_Size").val(corPt2LeftinseamSize);
		
		var corPt2LeftinseamGross = "${orderCoForm.coAdjustPants2StandardInfo.corPt2LeftinseamGross}";
		jQuery("#corPt2LeftinseamGross").val(corPt2LeftinseamGross);
		corPt2LeftinseamGross = corPt2LeftinseamGross.split(".");
		if(isNotEmpty(corPt2LeftinseamGross[1])){
			jQuery("#ap2_inseamLeftM1").val(corPt2LeftinseamGross[1])
		}
		var str = corPt2LeftinseamGross[0];
		if(str.length == 3){
			str = str.split("");
			var left1 = str[2];
			var left10 = str[1];
			var left100 = str[0];
			jQuery("#ap2_inseamLeft100").val(left100);
			jQuery("#ap2_inseamLeft10").val(left10);
			jQuery("#ap2_inseamLeft1").val(left1);
		}else if(str.length == 2){
			str = str.split("");
			var left1 = str[1];
			var left10 = str[0];
			jQuery("#ap2_inseamLeft100").val("0");
			jQuery("#ap2_inseamLeft10").val(left10);
			jQuery("#ap2_inseamLeft1").val(left1);
		}else if(str.length == 1){
			str = str.split("");
			var left1 = str[0];
			jQuery("#ap2_inseamLeft100").val("0");
			jQuery("#ap2_inseamLeft10").val("0");
			jQuery("#ap2_inseamLeft1").val(left1);
		}
		var corPt2HemwidthTypeValue="${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthType}";
		if(corPt2HemwidthTypeValue=="1"){
			jQuery("#pt2_hemWidth_relative").prop("checked", true);
			jQuery("#pt2_hemWidth_relative").click();
			jQuery("#corPt2Hemwidth_div_Size").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthSize}");
			jQuery("#corPt2Hemwidth_div_Gross").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthGross}");
			jQuery("#corPt2Hemwidth_div_html").html("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthGross}"+"cm");
			if("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthGross}"=="" || "${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthGross}"=="0"){
				jQuery("#corPt2Hemwidth_div_html").html("000.0cm");
				}
			jQuery("#corPt2HemwidthRange_out").html("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthCorrect}");
            if("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthCorrect}"==""){
            	jQuery("#corPt2HemwidthRange_out").html("0");
                 }
			jQuery("#corPt2HemwidthRange").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthCorrect}");
			setFont("corPt2HemwidthRange");
		 }else if(corPt2HemwidthTypeValue=="2"){
			 jQuery("#pt2_hemWidth_absolute").prop("checked", true);
			 jQuery("#corPt2HemwidthRangeId").hide();
			 jQuery("#pt2_hemWidth_absolute").click();
				var corPt2HemwidthDegignate = "${orderCoForm.coAdjustPants2StandardInfo.corPt2HemwidthDegignate}";
				jQuery("#corPt2HemwidthDegignate").val(corPt2HemwidthDegignate);
				corPt2HemwidthDegignate = corPt2HemwidthDegignate.split(".");
				if(isNotEmpty(corPt2HemwidthDegignate[1])){
					jQuery("#ap2_hemWidthAbsM1").val(corPt2HemwidthDegignate[1]);
				}
				var str = corPt2HemwidthDegignate[0];
				if(str.length == 2){
					str = str.split("");
					var left1 = str[1];
					var left10 = str[0];
					if(left10=="1"){
						jQuery("#ap2_hemWidthAbs10").val("1");
					}else if(left10=="2"){
						jQuery("#ap2_hemWidthAbs10").val("2");
					}
					jQuery("#ap2_hemWidthAbs1").val(left1);
				}


	    }
		jQuery("#corPt2StoreCorrectionMemo").val("${orderCoForm.coAdjustPants2StandardInfo.corPt2StoreCorrectionMemo}");
		
	} 
	 jQuery('#btn_ap2_samePants').click(function (){
		if(isEmpty(pt2Model)){
			 swal({
					text:getMsgByOneArg('msg066', 'PANTS（2本目） モデル'),
					icon:"info"
			});		
		}else{
			jQuery("#selectPants2Figure").val(jQuery("#selectPantsFigure").val());
			jQuery("#selectPants2Number").val(jQuery("#selectPantsNumber").val());
		}
		//2PT　型サイズ値、補正値とグロス値を設定
		jQuery("#corPt2Waist_div_Size").val(jQuery("#corPtWaist_div_Size").val());
		jQuery("#corPt2Waist_div_Gross").val(jQuery("#corPtWaist_div_Gross").val());
		jQuery("#corPt2Waist_div_html").html(jQuery("#corPtWaist_div_html").val());
		if(jQuery("#corPtWaist_div_html").val()==""){
			jQuery("#corPt2Waist_div_html").html("000.0cm");
			}
		jQuery("#corPt2WaistRange_out").html(jQuery("#corPtWaistRange_out").val());
		jQuery("#corPt2WaistRange").val(jQuery("#corPtWaistRange_out").val());
		setFont("corPt2WaistRange");
		jQuery("#corPt2WaistRange").click();
		
		jQuery("#corPt2Hip_div_Size").val(jQuery("#corPtHip_div_Size").val());
		jQuery("#corPt2Hip_div_Gross").val(jQuery("#corPtHip_div_Gross").val());
		jQuery("#corPt2Hip_div_html").html(jQuery("#corPtHip_div_html").val());
		if(jQuery("#corPtHip_div_html").val()==""){
			jQuery("#corPt2Hip_div_html").html("000.0cm");
			}
		jQuery("#corPt2HipRange_out").html(jQuery("#corPtHipRange_out").val());
		jQuery("#corPt2HipRange").val(jQuery("#corPtHipRange_out").val());
		setFont("corPt2HipRange");
		jQuery("#corPt2HipRange").click();
		
		jQuery("#corPt2Thigh_div_Size").val(jQuery("#corPtThigh_div_Size").val());
		jQuery("#corPt2Thigh_div_Gross").val(jQuery("#corPtThigh_div_Gross").val());
		jQuery("#corPt2Thigh_div_html").html(jQuery("#corPtThigh_div_html").val());
		if(jQuery("#corPt2Thigh_div_html").val()==""){
			jQuery("#corPt2Thigh_div_html").html("000.0cm");
			}
		jQuery("#corPt2ThighRange_out").html(jQuery("#corPtThighRange_out").val());
		jQuery("#corPt2ThighRange").val(jQuery("#corPtThighRange_out").val());
		setFont("corPt2ThighRange");
		jQuery("#corPt2ThighRange").click();
		
		/* jQuery("#corPt2Hemwidth_div_Size").val(jQuery("#corPtHemwidth_div_Size").val());
		jQuery("#corPt2Hemwidth_div_Gross").val(jQuery("#corPtHemwidth_div_Gross").val());
		jQuery("#corPt2Hemwidth_div_html").html(jQuery("#corPtHemwidth_div_html").val()+"cm");
		if(jQuery("#corPtHemwidth_div_html").val()==""){
			jQuery("#corPt2Hemwidth_div_html").html("000.0cm");
			}
		jQuery("#corPt2HemwidthRange_out").html(jQuery("#corPtHemwidthRange_out").val());
		jQuery("#corPt2HemwidthRange").val(jQuery("#corPtHemwidthRange").val());
		setFont("corPt2HemwidthRange");
		jQuery("#corPt2HemwidthRange").click(); */

		var corPt2RightinseamSize = jQuery("#corPtRightinseam_div_Size").val();
		jQuery("#corPt2Rightinseam_div_Size").val(corPt2RightinseamSize);

		var corPt2RightinseamGross = jQuery("#corPtRightinseamGross").val();
		if(corPt2RightinseamGross==""){
			jQuery("#ap2_inseamRight100").val("0");
			jQuery("#ap2_inseamRight10").val("0");
			jQuery("#ap2_inseamRight1").val("0");
			jQuery("#ap2_inseamRightM1").val("0");
		}else{
		jQuery("#corPt2RightinseamGross").val(corPt2RightinseamGross);
		corPt2RightinseamGross = corPt2RightinseamGross.split(".");
		if(isNotEmpty(corPt2RightinseamGross[1])){
			jQuery("#ap2_inseamRightM1").val(corPt2RightinseamGross[1]);
		}
		var str = corPt2RightinseamGross[0];
		if(str.length == 3){
			str = str.split("");
			var right1 = str[2];
			var right10 = str[1];
			var right100 = str[0];
			jQuery("#ap2_inseamRight100").val(right100);
			jQuery("#ap2_inseamRight10").val(right10);
			jQuery("#ap2_inseamRight1").val(right1);
		}else if(str.length == 2){
			str = str.split("");
			var right1 = str[1];
			var right10 = str[0];
			jQuery("#ap2_inseamRight100").val("0");
			jQuery("#ap2_inseamRight10").val(right10);
			jQuery("#ap2_inseamRight1").val(right1);
		}else if(str.length == 1){
			str = str.split("");
			var right1 = str[0];
			jQuery("#ap2_inseamRight100").val("0");
			jQuery("#ap2_inseamRight10").val("0");
			jQuery("#ap2_inseamRight1").val(right1);
		}}
		
		var corPt2LeftinseamSize = jQuery("#corPtLeftinseam_div_Size").val();
		jQuery("#corPt2Leftinseam_div_Size").val(corPt2LeftinseamSize);
		
		var corPt2LeftinseamGross = jQuery("#corPtLeftinseamGross").val();
		if(corPt2LeftinseamGross==""){
			jQuery("#ap2_inseamLeft100").val("0");
			jQuery("#ap2_inseamLeft10").val("0");
			jQuery("#ap2_inseamLeft1").val("0");
			jQuery("#ap2_inseamLeftM1").val("0")
			}else{
		jQuery("#corPt2LeftinseamGross").val(corPt2LeftinseamGross);
		corPt2LeftinseamGross = corPt2LeftinseamGross.split(".");
		if(isNotEmpty(corPt2LeftinseamGross[1])){
			jQuery("#ap2_inseamLeftM1").val(corPt2LeftinseamGross[1])
		}
		var str = corPt2LeftinseamGross[0];
		if(str.length == 3){
			str = str.split("");
			var left1 = str[2];
			var left10 = str[1];
			var left100 = str[0];
			jQuery("#ap2_inseamLeft100").val(left100);
			jQuery("#ap2_inseamLeft10").val(left10);
			jQuery("#ap2_inseamLeft1").val(left1);
		}else if(str.length == 2){
			str = str.split("");
			var left1 = str[1];
			var left10 = str[0];
			jQuery("#ap2_inseamLeft100").val("0");
			jQuery("#ap2_inseamLeft10").val(left10);
			jQuery("#ap2_inseamLeft1").val(left1);
		}else if(str.length == 1){
			str = str.split("");
			var left1 = str[0];
			jQuery("#ap2_inseamLeft100").val("0");
			jQuery("#ap2_inseamLeft10").val("0");
			jQuery("#ap2_inseamLeft1").val(left1);
		}}
		var corPt2HemwidthTypeValue=jQuery('input[name="coAdjustPantsStandardInfo.corPtHemwidthType"]:checked').val();
		if(corPt2HemwidthTypeValue=="1"){
			jQuery("#pt2_hemWidth_relative").prop("checked", true);
			jQuery("#pt2_hemWidth_relative").click();
			jQuery("#corPt2Hemwidth_div_Size").val(jQuery("#corPtHemwidth_div_Size").val());
			jQuery("#corPt2Hemwidth_div_Gross").val(jQuery("#corPtHemwidth_div_Gross").val());
			jQuery("#corPt2Hemwidth_div_html").html(jQuery("#corPtHemwidth_div_html").val());
			if(jQuery("#corPtHemwidth_div_html").val()==""){
				jQuery("#corPt2Hemwidth_div_html").html("000.0cm");
				}
			jQuery("#corPt2HemwidthRange_out").html(jQuery("#corPtHemwidthRange_out").val());
			jQuery("#corPt2HemwidthRange").val(jQuery("#corPtHemwidthRange").val());
			setFont("corPt2HemwidthRange");
			jQuery("#corPt2HemwidthRange").click();
			jQuery("#ap2_hemWidthAbs10").val("1");
			jQuery("#ap2_hemWidthAbs1").val("0");
			jQuery("#ap2_hemWidthAbsM1").val("0");
		 }else if(corPt2HemwidthTypeValue=="2"){
			 jQuery("#pt2_hemWidth_absolute").prop("checked", true);
			 jQuery("#pt2_hemWidth_absolute").click();
				var corPt2HemwidthDegignate = jQuery("#corPtHemwidthDegignate").val();
				jQuery("#corPt2HemwidthDegignate").val(corPt2HemwidthDegignate);
				corPt2HemwidthDegignate = corPt2HemwidthDegignate.split(".");
				if(isNotEmpty(corPt2HemwidthDegignate[1])){
					jQuery("#ap2_hemWidthAbsM1").val(corPt2HemwidthDegignate[1]);
				}
				var str = corPt2HemwidthDegignate[0];
				if(str.length == 2){
					str = str.split("");
					var left1 = str[1];
					var left10 = str[0];
					if(left10=="1"){
						jQuery("#ap2_hemWidthAbs10").val("1");
					}else if(left10=="2"){
						jQuery("#ap2_hemWidthAbs10").val("2");
					}
					jQuery("#ap2_hemWidthAbs1").val(left1);
				}
	    }
		
}) 

 function adjustShirtSession(){
		 
		 if(isEmpty(shirtModel)){
			//SHIRT
			var corStSize = document.getElementById("selectCorStSize");
			corStSize.options.length=0;
			corStSize.add(new Option("選択　　　",""));
		 }else{
			 jQuery("#selectCorStSize").val("${orderCoForm.coAdjustShirtStandardInfo.corStSize}");
		}
		jQuery("#corStNeck_div_Size").val("${orderCoForm.coAdjustShirtStandardInfo.corStNeckSize}");
		jQuery("#corStNeck_div_Gross").val("${orderCoForm.coAdjustShirtStandardInfo.corStNeckGross}");
		jQuery("#corStNeck_div_html").html("${orderCoForm.coAdjustShirtStandardInfo.corStNeckGross}"+"cm");
		if("${orderCoForm.coAdjustShirtStandardInfo.corStNeckGross}"=="" || "${orderCoForm.coAdjustShirtStandardInfo.corStNeckGross}"=="0"){
			jQuery("#corStNeck_div_html").html("000.0cm");
			}
		jQuery("#corStNeckRange_out").html("${orderCoForm.coAdjustShirtStandardInfo.corStNeckCorrect}");
		if("${orderCoForm.coAdjustShirtStandardInfo.corStNeckCorrect}"==""){
			jQuery("#corStNeckRange_out").html("0");
		}
		jQuery("#corStNeckRange").val("${orderCoForm.coAdjustShirtStandardInfo.corStNeckCorrect}");
		setFont("corStNeckRange");
		
		jQuery("#corStBodylength_div_Size").val("${orderCoForm.coAdjustShirtStandardInfo.corStBodylengthSize}");
		jQuery("#corStBodylength_div_Gross").val("${orderCoForm.coAdjustShirtStandardInfo.corStBodylengthGross}");
		jQuery("#corStBodylength_div_html").html("${orderCoForm.coAdjustShirtStandardInfo.corStBodylengthGross}"+"cm");
		if("${orderCoForm.coAdjustShirtStandardInfo.corStBodylengthGross}"=="" || "${orderCoForm.coAdjustShirtStandardInfo.corStBodylengthGross}"=="0"){
			jQuery("#corStBodylength_div_html").html("000.0cm");
		}
		jQuery("#corStBodylengthRange_out").html("${orderCoForm.coAdjustShirtStandardInfo.corStBodylengthCorrect}");
		if("${orderCoForm.coAdjustShirtStandardInfo.corStBodylengthCorrect}"==""){
			jQuery("#corStBodylengthRange_out").html("0");
		}
		jQuery("#corStBodylengthRange").val("${orderCoForm.coAdjustShirtStandardInfo.corStBodylengthCorrect}");
		setFont("corStBodylengthRange");

		jQuery("#corStRightsleeve_div_Size").val("${orderCoForm.coAdjustShirtStandardInfo.corStRightsleeveSize}");
		jQuery("#corStRightsleeve_div_Gross").val("${orderCoForm.coAdjustShirtStandardInfo.corStRightsleeveGross}");
		jQuery("#corStRightsleeve_div_html").html("${orderCoForm.coAdjustShirtStandardInfo.corStRightsleeveGross}"+"cm");
		if("${orderCoForm.coAdjustShirtStandardInfo.corStRightsleeveGross}"=="" || "${orderCoForm.coAdjustShirtStandardInfo.corStRightsleeveGross}"=="0"){
			jQuery("#corStRightsleeve_div_html").html("000.0cm");
			}
		jQuery("#corStRightsleeveRange_out").html("${orderCoForm.coAdjustShirtStandardInfo.corStRightsleeveCorrect}");
        if("${orderCoForm.coAdjustShirtStandardInfo.corStRightsleeveCorrect}"==""){
        	jQuery("#corStRightsleeveRange_out").html("0");
            }
		jQuery("#corStRightsleeveRange").val("${orderCoForm.coAdjustShirtStandardInfo.corStRightsleeveCorrect}");
		setFont("corStRightsleeveRange");

		jQuery("#corStLeftsleeve_div_Size").val("${orderCoForm.coAdjustShirtStandardInfo.corStLeftsleeveSize}");
		jQuery("#corStLeftsleeve_div_Gross").val("${orderCoForm.coAdjustShirtStandardInfo.corStLeftsleeveGross}");
		jQuery("#corStLeftsleeve_div_html").html("${orderCoForm.coAdjustShirtStandardInfo.corStLeftsleeveGross}"+"cm");
		if("${orderCoForm.coAdjustShirtStandardInfo.corStLeftsleeveGross}"=="" || "${orderCoForm.coAdjustShirtStandardInfo.corStLeftsleeveGross}"=="0"){
			jQuery("#corStLeftsleeve_div_html").html("000.0cm");
			}
		jQuery("#corStLeftsleeveRange_out").html("${orderCoForm.coAdjustShirtStandardInfo.corStLeftsleeveCorrect}");
        if("${orderCoForm.coAdjustShirtStandardInfo.corStLeftsleeveCorrect}"==""){
        	jQuery("#corStLeftsleeveRange_out").html("0");
            }
		jQuery("#corStLeftsleeveRange").val("${orderCoForm.coAdjustShirtStandardInfo.corStLeftsleeveCorrect}");
		setFont("corStLeftsleeveRange");

		jQuery("#corStBackdartsPack_div_Size").val("${orderCoForm.coAdjustShirtStandardInfo.corStBackdartsPackSize}");
		jQuery("#corStBackdartsPack_div_Gross").val("${orderCoForm.coAdjustShirtStandardInfo.corStBackdartsPackGross}");
		jQuery("#corStBackdartsPack_div_html").html("${orderCoForm.coAdjustShirtStandardInfo.corStBackdartsPackGross}"+"cm");
		if("${orderCoForm.coAdjustShirtStandardInfo.corStBackdartsPackGross}"=="" || "${orderCoForm.coAdjustShirtStandardInfo.corStBackdartsPackGross}"=="0"){
			jQuery("#corStBackdartsPack_div_html").html("000.0cm");
			}
		jQuery("#corStBackdartsPackRange_out").html("${orderCoForm.coAdjustShirtStandardInfo.corStBackdartsPackCorrect}");
		jQuery("#corStBackdartsPackRange").val("${orderCoForm.coAdjustShirtStandardInfo.corStBackdartsPackCorrect}");
        if("${orderCoForm.coAdjustShirtStandardInfo.corStBackdartsPackCorrect}"==""){
        	jQuery("#corStBackdartsPackRange_out").html("0"); 
        	jQuery("#corStBackdartsPackRange").val("0");
            }
		setFont("corStBackdartsPackRange");

		jQuery("#corStRightcuffsSurrounding_div_Size").val("${orderCoForm.coAdjustShirtStandardInfo.corStRightcuffsSurroundingSize}");
		jQuery("#corStRightcuffsSurrounding_div_Gross").val("${orderCoForm.coAdjustShirtStandardInfo.corStRightcuffsSurroundingGross}");
		jQuery("#corStRightcuffsSurrounding_div_html").html("${orderCoForm.coAdjustShirtStandardInfo.corStRightcuffsSurroundingGross}"+"cm");
		if("${orderCoForm.coAdjustShirtStandardInfo.corStRightcuffsSurroundingGross}"=="" || "${orderCoForm.coAdjustShirtStandardInfo.corStRightcuffsSurroundingGross}"=="0"){
			jQuery("#corStRightcuffsSurrounding_div_html").html("000.0cm");
			}
		jQuery("#corStRightcuffsSurroundingRange_out").html("${orderCoForm.coAdjustShirtStandardInfo.corStRightcuffsSurroundingCorrect}");
        if("${orderCoForm.coAdjustShirtStandardInfo.corStRightcuffsSurroundingCorrect}"==""){
        	jQuery("#corStRightcuffsSurroundingRange_out").html("0");
            }
		jQuery("#corStRightcuffsSurroundingRange").val("${orderCoForm.coAdjustShirtStandardInfo.corStRightcuffsSurroundingCorrect}");
		setFont("corStRightcuffsSurroundingRange");

		jQuery("#corStLeftcuffsSurrounding_div_Size").val("${orderCoForm.coAdjustShirtStandardInfo.corStLeftcuffsSurroundingSize}");
		jQuery("#corStLeftcuffsSurrounding_div_Gross").val("${orderCoForm.coAdjustShirtStandardInfo.corStLeftcuffsSurroundingGross}");
		jQuery("#corStLeftcuffsSurrounding_div_html").html("${orderCoForm.coAdjustShirtStandardInfo.corStLeftcuffsSurroundingGross}"+"cm");
		if("${orderCoForm.coAdjustShirtStandardInfo.corStLeftcuffsSurroundingGross}"=="" || "${orderCoForm.coAdjustShirtStandardInfo.corStLeftcuffsSurroundingGross}"=="0"){
			jQuery("#corStLeftcuffsSurrounding_div_html").html("000.0cm");
			}
		jQuery("#corStLeftcuffsSurroundingRange_out").html("${orderCoForm.coAdjustShirtStandardInfo.corStLeftcuffsSurroundingCorrect}");
        if("${orderCoForm.coAdjustShirtStandardInfo.corStLeftcuffsSurroundingCorrect}"==""){
        	jQuery("#corStLeftcuffsSurroundingRange_out").html("0");
            }
		jQuery("#corStLeftcuffsSurroundingRange").val("${orderCoForm.coAdjustShirtStandardInfo.corStLeftcuffsSurroundingCorrect}");
		setFont("corStLeftcuffsSurroundingRange");
		var corStBackdartsUnpackCorrect="${orderCoForm.coAdjustShirtStandardInfo.corStBackdartsUnpackCd}";
		if(corStBackdartsUnpackCorrect=="0002501"){
		    jQuery("#shirt_shoulderPat_id1").prop("checked", true);
		}else if(corStBackdartsUnpackCorrect=="0002502"){
			jQuery("#shirt_shoulderPat_id2").prop("checked", true);
			}
	} 

	 function adjustCoatSession(){

		 if(isEmpty(coatModel)){
			// COAT
			var corCtSize = document.getElementById("selectCorCtSize");
			corCtSize.options.length=0;
			corCtSize.add(new Option("選択　　　",""));
		 }else{
			jQuery("#selectCorCtSize").val("${orderCoForm.coAdjustCoatStandardInfo.corCtSize}");
		 }
		jQuery("#corCtBodylength_div_Size").val("${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthSize}");
		jQuery("#corCtBodylength_div_Gross").val("${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthGross}");
		jQuery("#corCtBodylength_div_html").html("${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthGross}"+"cm");
		if("${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthGross}"=="" || "${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthGross}"=="0"){
			jQuery("#corCtBodylength_div_html").html("000.0cm");
			}
		jQuery("#corCtBodylengthRange_out").html("${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthCorrect}");
        if("${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthCorrect}"==""){
        	jQuery("#corCtBodylengthRange_out").html("0");
            }
		jQuery("#corCtBodylengthRange").val("${orderCoForm.coAdjustCoatStandardInfo.corCtBodylengthCorrect}");
		setFont("corCtBodylengthRange");

		jQuery("#corCtWaist_div_Size").val("${orderCoForm.coAdjustCoatStandardInfo.corCtWaistSize}");
		jQuery("#corCtWaist_div_Gross").val("${orderCoForm.coAdjustCoatStandardInfo.corCtWaistGross}");
		jQuery("#corCtWaist_div_html").html("${orderCoForm.coAdjustCoatStandardInfo.corCtWaistGross}"+"cm");
		if("${orderCoForm.coAdjustCoatStandardInfo.corCtWaistGross}"=="" || "${orderCoForm.coAdjustCoatStandardInfo.corCtWaistGross}"=="0"){
			jQuery("#corCtWaist_div_html").html("000.0cm");
			}
		jQuery("#corCtWaistRange_out").html("${orderCoForm.coAdjustCoatStandardInfo.corCtWaistCorrect}");
        if("${orderCoForm.coAdjustCoatStandardInfo.corCtWaistCorrect}"==""){
        	jQuery("#corCtWaistRange_out").html("0");
            }
		jQuery("#corCtWaistRange").val("${orderCoForm.coAdjustCoatStandardInfo.corCtWaistCorrect}");
		setFont("corCtWaistRange");

		jQuery("#corCtRightsleeve_div_Size").val("${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveSize}");
		jQuery("#corCtRightsleeve_div_Gross").val("${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveGross}");
		jQuery("#corCtRightsleeve_div_html").html("${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveGross}"+"cm");
		if("${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveGross}"=="" || "${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveGross}"=="0"){
			jQuery("#corCtRightsleeve_div_html").html("000.0cm");
			}
		jQuery("#corCtRightsleeveRange_out").html("${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveCorrect}");
        if("${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveCorrect}"==""){
        	jQuery("#corCtRightsleeveRange_out").html("0");
             }
		jQuery("#corCtRightsleeveRange").val("${orderCoForm.coAdjustCoatStandardInfo.corCtRightsleeveCorrect}");
		setFont("corCtRightsleeveRange");

		jQuery("#corCtLeftsleeve_div_Size").val("${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveSize}");
		jQuery("#corCtLeftsleeve_div_Gross").val("${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveGross}");
		jQuery("#corCtLeftsleeve_div_html").html("${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveGross}"+"cm");
		if("${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveGross}"=="" || "${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveGross}"=="0"){
			jQuery("#corCtLeftsleeve_div_html").html("000.0cm");
			}
		jQuery("#corCtLeftsleeveRange_out").html("${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveCorrect}");
        if("${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveCorrect}"==""){
        	jQuery("#corCtLeftsleeveRange_out").html("0");
            }
		jQuery("#corCtLeftsleeveRange").val("${orderCoForm.coAdjustCoatStandardInfo.corCtLeftsleeveCorrect}");
		setFont("corCtLeftsleeveRange");

		jQuery("#corCtVenthight_div_Size").val("${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightSize}");
		jQuery("#corCtVenthight_div_Gross").val("${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightGross}");
		jQuery("#corCtVenthight_div_html").html("${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightGross}"+"cm");
		if("${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightGross}"=="" || "${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightGross}"=="0"){
			jQuery("#corCtVenthight_div_html").html("000.0cm");
			}
		jQuery("#corCtVenthightRange_out").html("${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightCorrect}");
        if("${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightCorrect}"==""){
        	jQuery("#corCtVenthightRange_out").html("0");   
            }
		jQuery("#corCtVenthightRange").val("${orderCoForm.coAdjustCoatStandardInfo.corCtVenthightCorrect}");
		setFont("corCtVenthightRange");

		jQuery("#corCtPktpos_div_Size").val("${orderCoForm.coAdjustCoatStandardInfo.corCtPktposSize}");
		jQuery("#corCtPktpos_div_Gross").val("${orderCoForm.coAdjustCoatStandardInfo.corCtPktposGross}");
		jQuery("#corCtPktpos_div_html").html("${orderCoForm.coAdjustCoatStandardInfo.corCtPktposGross}"+"cm");
		if("${orderCoForm.coAdjustCoatStandardInfo.corCtPktposGross}"=="" || "${orderCoForm.coAdjustCoatStandardInfo.corCtPktposGross}"=="0"){
			jQuery("#corCtPktpos_div_html").html("000.0cm");
			}
		jQuery("#corCtPktposRange_out").html("${orderCoForm.coAdjustCoatStandardInfo.corCtPktposCorrect}");
        if("${orderCoForm.coAdjustCoatStandardInfo.corCtPktposCorrect}"==""){
        	jQuery("#corCtPktposRange_out").html("0");
            }
		jQuery("#corCtPktposRange").val("${orderCoForm.coAdjustCoatStandardInfo.corCtPktposCorrect}");
		setFont("corCtPktposRange");
	}  
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