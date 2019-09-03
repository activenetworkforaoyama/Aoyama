<form:form id="idAdjustForm"
	action="${pageContext.request.contextPath}/orderCo/orderCoReconfirm"
	method="post" modelAttribute="orderForm" class="form-horizontal">


<div id="al3_pants_div">
						<div class="card-header">
							<strong class="card-title">PANTS（3本目）</strong>
							<button type="button" class="btn btn-outline-info btn-sm"
								id="btn_ap3_samePants">1本目と同じ</button>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col col-lg-12">
									<div class="row form-group">
										<div class="col col-md-3">
											<label class=" form-control-label">PANTSサイズ</label>
										</div>
										<div class="col-12 col-md-6">
											<div class="form-check-inline form-check">
												体型 <select name="ap3_pantsSizeA" id="ap3_pantsSizeA"
													class="form-control-sm form-control hidedown">
													<option value="">選択</option>
													<option value="JY">JY</option>
													<option value="YA">YA</option>
													<option value="A">A</option>
													<option value="AB">AB</option>
													<option value="BE">BE</option>
													<option value="E">E</option>
												</select> 号数 <select name="ap3_pantsSizeN" id="ap3_pantsSizeN"
													class="form-control-sm form-control hidedown">
													<option value="">選択</option>
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
													<option value="6">6</option>
													<option value="7">7</option>
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
												</select>
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
												<a href="#" id="ap3_waist_m"><i
													class="fa fa-minus-square" style="font-size: 32px"></i></a>&nbsp;
												<input type="range" id="ap3_waist" name="ap3_waist"
													value="0" min="-4" max="4" step="0.5">&nbsp; <a
													href="#" id="ap3_waist_p"><i class="fa fa-plus-square"
													style="font-size: 32px"></i></a>
												<output id="ap3_waist_out">0</output>
												cm
											</div>
										</div>
										<div class="col-12 col-md-2">
											<output>000.0</output>
											cm
										</div>
										<div class="col-12 col-md-3 offset-md-3">
											<label class=" form-control-label">ヒップ修正</label>
										</div>
										<div class="col-12 col-md-4">
											<div class="form-check-inline form-check">
												<a href="#" id="ap3_hip_m"><i class="fa fa-minus-square"
													style="font-size: 32px"></i></a>&nbsp; <input type="range"
													id="ap3_hip" name="ap3_hip" value="0" min="-2" max="2"
													step="0.5">&nbsp; <a href="#" id="ap3_hip_p"><i
													class="fa fa-plus-square" style="font-size: 32px"></i></a>
												<output id="ap3_hip_out">0</output>
												cm
											</div>
										</div>
										<div class="col-12 col-md-2">
											<output>000.0</output>
											cm
										</div>
										<div class="col-12 col-md-3 offset-md-3">
											<label class=" form-control-label">ワタリ修正</label>
										</div>
										<div class="col-12 col-md-4">
											<div class="form-check-inline form-check"">
												<a href="#" id="ap3_watari_m"><i
													class="fa fa-minus-square" style="font-size: 32px"></i></a>&nbsp;
												<input type="range" id="ap3_watari" name="ap3_watari"
													value="0" min="-1" max="1" step="0.5">&nbsp; <a
													href="#" id="ap3_watari_p"><i class="fa fa-plus-square"
													style="font-size: 32px"></i></a>
												<output id="ap3_watari_out">0</output>
												cm
											</div>
										</div>
										<div class="col-12 col-md-2">
											<output>000.0</output>
											cm
										</div>
										<div class="col-12 col-md-2 offset-md-3">
											<label class=" form-control-label">裾幅</label>
										</div>
										<div class="col-12 col-md-1">
											<label for="ap3_hemWidth_relative" class="form-check-label ">
												<input type="radio" id="ap3_hemWidth_relative"
												name="ap3_hemWidth" value="修正" class="form-check-input"
												checked>修正
											</label>
										</div>
										<div class="col-12 col-md-4">
											<div class="form-check-inline form-check">
												<a href="#" id="ap3_hemWidthRel_m"><i
													class="fa fa-minus-square" style="font-size: 32px"></i></a>&nbsp;
												<input type="range" id="ap3_hemWidthRel"
													name="ap3_hemWidthRel" value="0" min="-1.5" max="1.5"
													step="0.5">&nbsp; <a href="#"
													id="ap3_hemWidthRel_p"><i class="fa fa-plus-square"
													style="font-size: 32px"></i></a>
												<output id="ap3_hemWidthRel_out">0</output>
												cm
											</div>
										</div>
										<div class="col-12 col-md-1 offset-md-5">
											<label for="ap3_hemWidth_absolute" class="form-check-label ">
												<input type="radio" id="ap3_hemWidth_absolute"
												name="ap3_hemWidth" value="指定" class="form-check-input">指定
											</label>
										</div>
										<div class="col-12 col-md-6">
											<div class="form-check-inline form-check">
												<select name="ap3_hemWidthAbs10" id="ap3_hemWidthAbs10"
													class="form-control-sm form-control hidedown"
													style="width: 32px">
													<option value="0">1</option>
													<option value="2">2</option>
												</select> <select name="ap3_hemWidthAbs1" id="ap3_hemWidthAbs1"
													class="form-control-sm form-control hidedown"
													style="width: 32px">
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
												</select>. <select name="ap3_hemWidthAbsM1" id="ap3_inseamLeftM1"
													class="form-control-sm form-control hidedown"
													style="width: 32px">
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
												左&nbsp; <select name="ap3_inseamLeft100"
													id="ap3_inseamLeft100"
													class="form-control-sm form-control hidedown"
													style="width: 32px">
													<option value="0">0</option>
													<option value="1">1</option>
												</select> <select name="ap3_inseamLeft10" id="ap3_inseamLeft10"
													class="form-control-sm form-control hidedown"
													style="width: 32px">
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
												</select> <select name="ap3_inseamLeft1" id="ap3_inseamLeft1"
													class="form-control-sm form-control hidedown"
													style="width: 32px">
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
												</select>. <select name="ap3_inseamLeftM1" id="ap3_inseamLeftM1"
													class="form-control-sm form-control hidedown"
													style="width: 32px">
													<option value="0">0</option>
													<option value="5">5</option>
												</select>cm 右&nbsp; <select name="ap3_inseamRight100"
													id="ap3_inseamRight100"
													class="form-control-sm form-control hidedown"
													style="width: 32px">
													<option value="0">0</option>
													<option value="1">1</option>
												</select> <select name="ap3_inseamRight10" id="ap3_inseamRight10"
													class="form-control-sm form-control hidedown"
													style="width: 32px">
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
												</select> <select name="ap3_inseamRight1" id="ap3_inseamRight1"
													class="form-control-sm form-control hidedown"
													style="width: 32px">
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
												</select>. <select name="ap3_inseamRightM1" id="ap3_inseamRightM1"
													class="form-control-sm form-control hidedown"
													style="width: 32px">
													<option value="0">0</option>
													<option value="5">5</option>
												</select>cm
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div></form:form>