/************************************************
 * ルールMAP
 ************************************************/
/*
 * ルール１
 * モデル・フロント釦数毎の有効なラペルデザインを保持するマップ
 * lapelDesignMap
 *   JACKETモデル:オブジェクト
 *     activeList:オブジェクト
 *       フロント釦数:オブジェクト
 *          activeList:有効なラペルデザインの配列
 *          defaultValue:デフォルトのラペルデザイン
 *     defaultValue:デフォルトのフロント釦数
 *     notch:0000201,peaked:0000202,shawl:0000203
 */
var lapelDesignImageMap = {
		'TR02':{
			activeList:[{val:"0000101",text:"段返り3つボタン"},
				{val:"0000102",text:"2つボタン"},
				{val:"0000103",text:"1つボタン"},
				{val:"0000105",text:"ダブル６つボタン"},
				{val:"0000106",text:"ダブル４つボタン"}],
			defaultValue:'0000101'
		},
		'CH14':{
			activeList:[
				{val:"0000102",text:"2つボタン"},
				{val:"0000103",text:"1つボタン"},
				{val:"0000105",text:"ダブル６つボタン"},
				{val:"0000106",text:"ダブル４つボタン"}],
			defaultValue:'0000102'
		},
		'NR05':{
			activeList:[
				{val:"0000102",text:"2つボタン"},
				{val:"0000103",text:"1つボタン"},
				],
			defaultValue:'0000102'
		},
		'NZ01':{
			activeList:[
				{val:"0000102",text:"2つボタン"},
				{val:"0000103",text:"1つボタン"},
				],
			defaultValue:'0000102'
		},
		'BS05':{
			activeList:[
				{val:"0000102",text:"2つボタン"},
				{val:"0000103",text:"1つボタン"},
				],
			defaultValue:'0000102'
		},
}
var lapelDesignTuxedoImageMap = {
		'TR02':{
			activeList:[{val:"0000101",text:"段返り3つボタン"},
				{val:"0000102",text:"2つボタン"},
				{val:"0000103",text:"1つボタン"},
				{val:"0000104",text:"拝み1つボタン"},
				{val:"0000105",text:"ダブル６つボタン"},
				{val:"0000106",text:"ダブル４つボタン"}],
			defaultValue:'0000101'
		},
		'CH14':{
			activeList:[
				{val:"0000102",text:"2つボタン"},
				{val:"0000103",text:"1つボタン"},
				{val:"0000104",text:"拝み1つボタン"},
				{val:"0000105",text:"ダブル６つボタン"},
				{val:"0000106",text:"ダブル４つボタン"}],
			defaultValue:'0000102'
		},
		'NR05':{
			activeList:[
				{val:"0000102",text:"2つボタン"},
				{val:"0000103",text:"1つボタン"},
				{val:"0000104",text:"拝み1つボタン"},
				],
			defaultValue:'0000102'
		},
		'NZ01':{
			activeList:[
				{val:"0000102",text:"2つボタン"},
				{val:"0000103",text:"1つボタン"},
				{val:"0000104",text:"拝み1つボタン"},
				],
			defaultValue:'0000102'
		},
		'BS05':{
			activeList:[
				{val:"0000102",text:"2つボタン"},
				{val:"0000103",text:"1つボタン"},
				{val:"0000104",text:"拝み1つボタン"},
				],
			defaultValue:'0000102'
		},
}
var lapelDesignMap = {
	'TR02':{
		activeList:{
			//段返り3つボタン
			'0000101':{
				activeList:['0000201','0000202','0000203'],
				defaultValue:'0000201'
			},
			//2つボタン
			'0000102':{
				activeList:['0000201','0000202','0000203'],
				defaultValue:'0000201'
			},
			//1つボタン
			'0000103':{
				activeList:['0000201','0000202','0000203'],
				defaultValue:'0000201'
			},
			//ダブル６つボタン
			'0000105':{
				activeList:['0000202'],
				defaultValue:'0000202'
			},
			//ダブル４つボタン
			'0000106':{
				activeList:['0000202'],
				defaultValue:'0000202'
			},
			'0000104':{
				activeList:['0000201','0000202','0000203'],
				defaultValue:'0000201'
			}
		},
		defaultValue:'0000101'
	},
	'CH14':{
		activeList:{
			'0000102':{
				activeList:['0000201'],
				defaultValue:'0000201'
			},
			'0000103':{
				activeList:['0000201'],
				defaultValue:'0000201'
			},
			'0000105':{
				activeList:['0000202'],
				defaultValue:'0000202'
			},
			'0000106':{
				activeList:['0000202'],
				defaultValue:'0000202'
			}
		},
		defaultValue:'0000102'
	},
	'NR05':{
		activeList:{
			'0000102':{
				activeList:['0000201','0000202'],
				defaultValue:'0000201'
			},
			'0000103':{
				activeList:['0000201','0000202'],
				defaultValue:'0000201'
			}
		},
		defaultValue:'0000102'
	},
	'NZ01':{
		activeList:{
			'0000102':{
				activeList:['0000201'],
				defaultValue:'0000201'
			},
			'0000103':{
				activeList:['0000201'],
				defaultValue:'0000201'
			}
		},
		defaultValue:'0000102'
	},
	'BS05':{
		activeList:{
			'0000102':{
				activeList:['0000201','0000202','0000203'],
				defaultValue:'0000201'
			},
			'0000103':{
				activeList:['0000201','0000202','0000203'],
				defaultValue:'0000201'
			},
/*
			'ダブル６つボタン':{
				activeList:['peaked'],
				defaultValue:'peaked'
			},
			'ダブル４つボタン':{
				activeList:['peaked'],
				defaultValue:'peaked'
			}
*/
		},
		defaultValue:'0000102'
	}
};

/*
 * ルール２
 * グレード毎の有効な裏仕様を保持するマップ
 * グレード
 *   └オブジェクト
 *       activeList:有効な裏仕様の配列
 *       defaultValue:デフォルト値
 */
var backSpeckList = {
	"フル毛芯" : {
		activeList : ["総裏","背抜き"],
		defaultValue : "総裏"
	},
	"ハーフ毛芯" : {
		activeList : ["総裏","背抜き","半裏","超軽量"],
		defaultValue : "総裏"
	},
	"接着芯" : {
		activeList : ["総裏","背抜き","半裏","超軽量"],
		defaultValue : "総裏"
	}
};

var fortImageList = {
		'0000302':{
			activeList:[{val:"0000401",text:"総裏"},{val:"0000402",text:"背抜き"},{val:"0000403",text:"半裏"}],
			defaultValue:'0000401'
		},
		'0000301':{
			activeList:[{val:"0000401",text:"総裏"},{val:"0000402",text:"背抜き"},{val:"0000403",text:"半裏"},{val:"0000404",text:"シャツ仕様"}],
			defaultValue:'0000401'
		},
		'0000303':{
			activeList:[{val:"0000401",text:"総裏"},{val:"0000402",text:"背抜き"},{val:"0000403",text:"半裏"},{val:"0000404",text:"シャツ仕様"}],
			defaultValue:'0000401'
		},
}

/*
 * ルール２
 * グレードと裏仕様の組み合わせ毎の有効な台場を保持するマップ
 * fortList
 *     グレード:オブジェクト
 *         activeList:有効な裏仕様の連想配列
 *             裏仕様:オブジェクト
 *                 activeList:有効な台場の配列
 *                 defaultValue:デフォルト値
 *         defaultValue:デフォルト値
 */
var fortList = {
	//フル毛芯:0000302
	"0000302" : {
		activeList : {
			//総裏:0000401
			"0000401" : {
				//本台場:0000501
				activeList : [{val:"0000501",text:"本台場"}],
				defaultValue : "0000501"
			},
			//背抜き:0000402
			"0000402" : {
				//本台場:0000501
				activeList : [{val:"0000501",text:"本台場"}],
				defaultValue : "0000501"
			},
			//半裏:0000403
			"0000403" : {
				//本台場:0000501
				activeList : [{val:"0000502",text:"切台場"}],
				defaultValue : "0000502"
			}
		},
		defaultValue : "0000401"
	},
	//ハーフ毛芯:0000301
	"0000301" : {
		activeList : {
			//総裏:0000401
			"0000401" : {
				//本台場:0000501,切台場:0000502
				activeList : [{val:"0000501",text:"本台場"}, {val:"0000502",text:"切台場"}],
				defaultValue : "0000501"
			},
			//背抜き:0000402
			"0000402" : {
				activeList : [{val:"0000501",text:"本台場"}, {val:"0000502",text:"切台場"}],
				defaultValue : "0000501"
			},
			//半裏:0000403
			"0000403" : {
				activeList : [{val:"0000502",text:"切台場"}],
				defaultValue : "0000502"
			},
			//シャツ仕様:0000404
			"0000404" : {
				activeList : [{val:"0000502",text:"切台場"}],
				defaultValue : "0000502"
			}
		},
		defaultValue : "0000401"
	},
	//接着芯:0000303
	"0000303" : {
		activeList : {
			//総裏:0000401
			"0000401" : {
				//本台場:0000501,切台場:0000502
				activeList : [{val:"0000501",text:"本台場"}, {val:"0000502",text:"切台場"}],
				defaultValue : "0000501"
			},
			//背抜き:0000402
			"0000402" : {
				activeList : [{val:"0000501",text:"本台場"}, {val:"0000502",text:"切台場"}],
				defaultValue : "0000501"
			},
			//半裏:0000403
			"0000403" : {
				activeList : [{val:"0000502",text:"切台場"}],
				defaultValue : "0000502"
			},
			//シャツ仕様:0000404
			"0000404" : {
				activeList : [{val:"0000502",text:"切台場"}],
				defaultValue : "0000502"
			}
		},
		defaultValue : "0000401"
	}
};

/*
 * ルール３
 * ステッチ箇所変更の設定（ジャケット）
 * stitchModifyList
 *     JACKETモデル:有効なラペルデザインの連想配列
 *         ラペルデザイン:ステッチ箇所変更の連想配列
 *             ステッチ箇所変更:オブジェクト
 *                 disabled:有効(true)/無効(false)
 *                 default:デフォルト選択状態(trueで選択)
 */
var stitchModifyList = {
	"TR02" : {
		//ノッチ notch
		"0000201" : {
			//lapel
			"id1"			: { disabled:false, default:true},
			//breastPk
			"id2"		    : { disabled:false, default:true},
			//hipPk
			"id3"			: { disabled:false, default:true},
			//darts
			"id4"			: { disabled:true, default:false},
			//shoulderLine
			"id5"			: { disabled:true, default:false},
			//sleeveCap
			//"sleeveCap"		: { disabled:true, default:false},
			//outsideSleeve
			"id6"			: { disabled:true, default:false},
			//sleeveOpen
			"id7"			: { disabled:true, default:false},
			//backSeam
			"id8"			: { disabled:true, default:false},
			//anderarm
			//"anderarm"		: { disabled:true, default:false},
			//vent
			"id9"			: { disabled:true, default:false}
		},
		//ピークド peaked
		"0000202" : {
			//lapel
			"id1"			: { disabled:false, default:true},
			//breastPk
			"id2"			: { disabled:false, default:true},
			//hipPk
			"id3"			: { disabled:false, default:true},
			//darts
			"id4"			: { disabled:true, default:false},
			//shoulderLine
			"id5"			: { disabled:true, default:false},
			//sleeveCap
			//"sleeveCap"		: { disabled:true, default:false},
			//outsideSleeve
			"id6"			: { disabled:true, default:false},
			//sleeveOpen
			"id7"			: { disabled:true, default:false},
			//backSeam
			"id8"			: { disabled:true, default:false},
			//anderarm
			//"anderarm"		: { disabled:true, default:false},
			//vent
			"id9"			: { disabled:true, default:false}
		},
		"double" : {
			"lapel"			: { disabled:false, default:true},
			"breastPk"		: { disabled:false, default:true},
			"hipPk"			: { disabled:false, default:true},
			"darts"			: { disabled:true, default:false},
			"shoulderLine"	: { disabled:true, default:false},
			"sleeveCap"		: { disabled:true, default:false},
			"outsideSleeve"	: { disabled:true, default:false},
			"sleeveOpen"	: { disabled:true, default:false},
			"backSeam"		: { disabled:true, default:false},
			"anderarm"		: { disabled:true, default:false},
			"vent"			: { disabled:true, default:false}
		},
		//ショール shawl
		"0000203" : {
			//lapel
			"id1"			: { disabled:false, default:true},
			//breastPk
			"id2"			: { disabled:false, default:true},
			//hipPk
			"id3"			: { disabled:false, default:true},
			//darts
			"id4"			: { disabled:true, default:false},
			//shoulderLine
			"id5"			: { disabled:true, default:false},
			//sleeveCap
		//	"sleeveCap"		: { disabled:true, default:false},
			//outsideSleeve
			"id6"			: { disabled:true, default:false},
			//sleeveOpen
			"id7"			: { disabled:true, default:false},
			//backSeam
			"id8"			: { disabled:true, default:false},
			//anderarm
			//"anderarm"		: { disabled:true, default:false},
			//vent
			"id9"			: { disabled:true, default:false}
		}
	},
	"CH14" : {
		"0000201" : {
			"id1"			: { disabled:false, default:true},
			"id2"			: { disabled:false, default:true},
			"id3"			: { disabled:false, default:true},
			"id4"			: { disabled:true, default:true},
			"id5"			: { disabled:false, default:true},
			//"sleeveCap"		: { disabled:true, default:true},
			"id6"			: { disabled:false, default:true},
			"id7"			: { disabled:false, default:true},
			"id8"			: { disabled:false, default:true},
			//"anderarm"		: { disabled:true, default:false},
			"id9"			: { disabled:false, default:true}
		},
		"0000202" : {
		},
		"double" : {
			"lapel"			: { disabled:false, default:true},
			"breastPk"		: { disabled:false, default:true},
			"hipPk"			: { disabled:false, default:true},
			"darts"			: { disabled:true, default:true},
			"shoulderLine"	: { disabled:false, default:true},
			"sleeveCap"		: { disabled:true, default:true},
			"outsideSleeve"	: { disabled:false, default:true},
			"sleeveOpen"	: { disabled:false, default:true},
			"backSeam"		: { disabled:false, default:true},
			"anderarm"		: { disabled:true, default:false},
			"vent"			: { disabled:false, default:true}
		},
		"0000203" : {
		}
	},
	"NR05" : {
		"0000201" : {
			"id1"			: { disabled:false, default:true},
			"id2"			: { disabled:false, default:true},
			"id3"			: { disabled:false, default:true},
			"id4"			: { disabled:true, default:true},
			"id5"			: { disabled:true, default:false},
			//"sleeveCap"		: { disabled:true, default:false},
			"id6"			: { disabled:true, default:false},
			"id7"			: { disabled:false, default:true},
			"id8"			: { disabled:true, default:false},
			//"anderarm"		: { disabled:true, default:false},
			"id9"			: { disabled:false, default:true}
		},
		"0000202" : {
			"id1"			: { disabled:false, default:true},
			"id2"			: { disabled:false, default:true},
			"id3"			: { disabled:false, default:true},
			"id4"			: { disabled:true, default:true},
			"id5"			: { disabled:true, default:false},
			//"sleeveCap"		: { disabled:true, default:false},
			"id6"			: { disabled:true, default:false},
			"id7"			: { disabled:false, default:true},
			"id8"			: { disabled:true, default:false},
			//"anderarm"		: { disabled:true, default:false},
			"id9"			: { disabled:false, default:true}
		},
		"double" : {
		},
		"0000203" : {
		}
	},
	"NZ01" : {
		"0000201" : {
			"id1"			: { disabled:false, default:true},
			"id2"			: { disabled:false, default:true},
			"id3"			: { disabled:false, default:true},
			"id4"			: { disabled:true, default:true},
			"id5"			: { disabled:true, default:false},
			//"sleeveCap"		: { disabled:true, default:false},
			"id6"			: { disabled:true, default:false},
			"id7"			: { disabled:true, default:false},
			"id8"			: { disabled:true, default:false},
			//"anderarm"		: { disabled:true, default:false},
			"id9"			: { disabled:false, default:true}
		},
		"0000202" : {
		},
		"double" : {
		},
		"0000203" : {
		}
	},
	"BS05" : {
		"0000201" : {
			"id1"			: { disabled:false, default:true},
			"id2"			: { disabled:false, default:true},
			"id3"			: { disabled:false, default:true},
			"id4"			: { disabled:true, default:false},
			"id5"			: { disabled:true, default:false},
			//"sleeveCap"		: { disabled:true, default:false},
			"id6"			: { disabled:true, default:false},
			"id7"			: { disabled:true, default:false},
			"id8"			: { disabled:true, default:false},
			//"anderarm"		: { disabled:true, default:false},
			"id9"			: { disabled:true, default:false}
		},
		"0000202" : {
			"id1"			: { disabled:false, default:true},
			"id2"			: { disabled:false, default:true},
			"id3"			: { disabled:false, default:true},
			"id4"			: { disabled:true, default:false},
			"id5"			: { disabled:true, default:false},
			//"sleeveCap"		: { disabled:true, default:false},
			"id6"			: { disabled:true, default:false},
			"id7"			: { disabled:true, default:false},
			"id8"			: { disabled:true, default:false},
			//"anderarm"		: { disabled:true, default:false},
			"id9"			: { disabled:true, default:false}
		},
		"double" : {
		},
		"0000203" : {
			"id1"			: { disabled:false, default:true},
			"id2"				: { disabled:false, default:true},
			"id3"			: { disabled:false, default:true},
			"id4"			: { disabled:true, default:false},
			"id5"			: { disabled:true, default:false},
			//"sleeveCap"		: { disabled:true, default:false},
			"id6"			: { disabled:true, default:false},
			"id7"			: { disabled:true, default:false},
			"id8"			: { disabled:true, default:false},
			//"anderarm"		: { disabled:true, default:false},
			"id9"			: { disabled:true, default:false}
		}
	}
};

/*
 * ルール３
 * PANTSモデルに基づくステッチ箇所変更のデフォルト値を保持するマップ
 * opPantsModifyList
 *     PANTSモデル:ステッチ箇所変更のデフォルト値配列
 */
var opStitchModifyList = {
	"TR02":{
		"id1":{default:true},
		"id2":{default:false},
		"id3":{default:false},
		"id4":{default:false}
	},
	"NR04":{
		"id1":{default:true},
		"id2":{default:false},
		"id3":{default:false},
		"id4":{default:true}
	},
	"CH14":{
		"id1":{default:true},
		"id2":{default:true},
		"id3":{default:false},
		"id4":{default:false}
	},
	"BS03":{
		"id1":{default:true},
		"id2":{default:false},
		"id3":{default:false},
		"id4":{default:false}
	},
	"NZ01":{
		"id1":{default:true},
		"id2":{default:true},
		"id3":{default:true},
		"id4":{default:false}
	},
	"RS01":{
		"id1":{default:true},
		"id2":{default:false},
		"id3":{default:false},
		"id4":{default:false}
	},
	"JW21":{
		"id1":{default:true},
		"id2":{default:false},
		"id3":{default:false},
		"id4":{default:false}
	},
	"AY01":{
		"id1":{default:true},
		"id2":{default:false},
		"id3":{default:false},
		"id4":{default:false}
	}
};

/*
 * ルール３－１
 * PANTSモデルに基づくステッチ箇所変更のデフォルト値を保持するマップ
 * opPantsModifyList
 *     PANTSモデル:ステッチ箇所変更のデフォルト値配列
 */
var opAmfColorList = {
	"TR02":{
		"1":{default:true},
		"2":{default:false},
		"3":{default:false},
		"4":{default:false}
	},
	"NR04":{
		"1":{default:true},
		"2":{default:false},
		"3":{default:false},
		"4":{default:true}
	},
	"CH14":{
		"1":{default:true},
		"2":{default:true},
		"3":{default:false},
		"4":{default:false}
	},
	"BS03":{
		"1":{default:true},
		"2":{default:false},
		"3":{default:false},
		"4":{default:false}
	},
	"NZ01":{
		"1":{default:true},
		"2":{default:true},
		"3":{default:true},
		"4":{default:false}
	},
	"RS01":{
		"1":{default:true},
		"2":{default:false},
		"3":{default:false},
		"4":{default:false}
	},
	"JW21":{
		"1":{default:true},
		"2":{default:false},
		"3":{default:false},
		"4":{default:false}
	},
	"AY01":{
		"1":{default:true},
		"2":{default:false},
		"3":{default:false},
		"4":{default:false}
	}
};

/*
 * ルール４
 * 腰ポケットとチェンジポケットの組み合わせ毎の有効なスランテッドポケットを保持するマップ
 * slantedPktList
 *     腰ポケット:オブジェクト
 *         activeList:有効なチェンジポケットの連想配列
 *             チェンジポケット:オブジェクト
 *                 activeList:有効なスランテッドポケットの配列
 *                 defaultValue:デフォルト値
 *         defaultValue:デフォルト値
 */
var slantedPktList = {
	//フラップ通常:0001201
	"0001201" : {
		activeList:{
			//無し:0001301
			"0001301":{
				//無し:0001401,有り:0001402
				activeList:["0001401", "0001402"],
				defaultValue:"0001401"
			},
			//有り（フラップ有）:0001302
			"0001302":{
				activeList:["0001401", "0001402"],
				defaultValue:"0001401"
			},
			//有り（フラップ無し両玉縁）:0001303
			"0001303":{
				activeList:["0001401", "0001402"],
				defaultValue:"0001401"
			}
		},
		//無し:0001301
		defaultValue:"0001301"
	},
	//フラップなし（両玉縁）:0001202
	"0001202" : {
		activeList:{
			"0001301":{
				activeList:["0001401", "0001402"],
				defaultValue:"0001401"
			},
			"0001303":{
				activeList:["0001401", "0001402"],
				defaultValue:"0001401"
			}
		},
		defaultValue:"0001301"
	},
	//パッチ:0001203
	"0001203" : {
		activeList:{
			"0001301":{
				activeList:["0001401"],
				defaultValue:"0001401"
			}
		},
		defaultValue:"0001301"
	},
	//パッチ＆フラップ:0001204
	"0001204" : {
		activeList:{
			"0001301":{
				activeList:["0001401"],
				defaultValue:"0001401"
			}
		},
		defaultValue:"0001301"
	},
};

var slantedPktTuexdoList = {
		//フラップなし（両玉縁　表地）:0001205
		"0001205" : {
			activeList:{
				//無し:0001301
				"0001301":{
					//無し:0001401,有り:0001402
					activeList:["0001401", "0001402"],
					defaultValue:"0001401"
				},
				//フラップ無し両玉縁　表地:0001306
				"0001306":{
					activeList:["0001401", "0001402"],
					defaultValue:"0001401"
				},
			},
			//無し:0001301
			defaultValue:"0001306"
		},
		//フラップ（表地）:0001206
		"0001206" : {
			activeList:{
				//フラップ有　表地:0001304
				"0001304":{
					activeList:["0001401", "0001402"],
					defaultValue:"0001401"
				},
				//フラップ無し両玉縁　表地:0001306
				"0001306":{
					activeList:["0001401", "0001402"],
					defaultValue:"0001401"
				},
				//無し:0001301
				"0001301":{
					activeList:["0001401", "0001402"],
					defaultValue:"0001401"
				}
			},
			defaultValue:"0001304"
		},
		//フラップ（拝見地）:0001207
		"0001207" : {
			activeList:{
				//フラップ有　拝見地:0001305
				"0001305":{
					//無し:0001401,有り:0001402
					activeList:["0001401", "0001402"],
					defaultValue:"0001401"
				},
				//フラップ無し両玉縁　拝見地:0001307
				"0001307":{
					//無し:0001401,有り:0001402
					activeList:["0001401", "0001402"],
					defaultValue:"0001401"
				},
				//無し:0001301
				"0001301":{
					//無し:0001401,有り:0001402
					activeList:["0001401", "0001402"],
					defaultValue:"0001401"
				}
			},
			defaultValue:"0001305"
		},
		//フラップなし（両玉縁　拝見地）:0001208
		"0001208" : {
			activeList:{
				//無し:0001301
				"0001301":{
					//無し:0001401,有り:0001402
					activeList:["0001401", "0001402"],
					defaultValue:"0001401"
				},
				//フラップ無し両玉縁　拝見地:0001307
				"0001307":{
					//無し:0001401,有り:0001402
					activeList:["0001401", "0001402"],
					defaultValue:"0001401"
				}
			},
			defaultValue:"0001307"
		},
	};

/*
 * ルール５
 * モデルに基づく袖釦のデフォルトを保持するマップ
 * sleeveBtnTypeList
 *     モデル:デフォルトの袖釦
 */
var sleeveBtnTypeList = {
	//重ね:0001801,並び:0001802
	'TR02':"0001801",
	'CH14':"0001801",
	'NR05':"0001801",
	'NZ01':"0001801",
	'BS05':"0001802"
};

/*
 * ルール５
 * モデルに基づくベントのデフォルトを保持するマップ
 * ventSpecList
 *     モデル:デフォルトのベント
 */
var ventSpecList = {
	//サイド:0003702,センター:0003701
	'TR02':"0003702",
	'CH14':"0003702",
	'NR05':"0003701",
	'NZ01':"0003702",
	'BS05':"0003702"
};

/*
 * ルール７
 * 胴裏素材に基づく胴裏品番のリストを保持するマップ
 * bodyBackMateStkNoList
 *     胴裏素材:胴裏品番の配列
 */
var bodyBackMateStkNoList = {
/*
	"ポリエステル" : ["PL 無地 Z(1185) BK","PL 無地 M(1185) A5","PL 無地 D(1185) 123","PL 無地 G(1185) A4","PL 無地 E(1185) A3","PL 無地 J(1185) A1"],
	"キュプラ" : ["CU J(AK1600) 7","CU N(AK1600) 14","CU D.J(AK1600) 29","CU D(AK1600) 45","CU M(AK1600) 47","CU G(AK1600) 53","CU X(AK1600) 54","CU Z(AK1600) 56","CU A(AK1600) 76",
		"CU ジャカード D.J(AK821) 4","CU ジャカード P(AK821) 8","CU ジャカード M(AK821) 10","CU ジャカード G(AK821) 12","CU ジャカード オリーブ(AK821) 26","CU ジャカード J(KL354) 7 ","CU ジャカード D.J(KL354) 30","CU ジャカード M(KL354) 45","CU ジャカード G(KL354) 500",
		"CU ドット L.J(AK807) 3","CU ドット Q(AK807) 7","CU ドット P(AK807) 9","CU ドット D(AK807) 10","CU ドット E(AK807) 12","CU ドット G(AK807) 13","CU ドット オリーブ(AK807)15",
		"CU PA A(AK809) 1","CU PA J(AK809) 5","CU PA D.J(AK809) 6","CU PA E(AK809) 11","CU PA G(AK809) 12","CU PA X(AK809) 13","CU PA M(AK809) 14",
		"CU/CO PA K(KL325) 2","CU/CO PA G.J(KL325)6","CU/CO PA D.J(KL325)7","CU/CO PA G(KL325) 10","CU/CO PA X(KL325) 11","CU/CO PA M(KL325) 16","CU/CO PA D(KL325) 26"],
	"ポリエステルレーヨン" : ["PL ジャガード G(4000B) 5","PL ジャガード M(4000B) 11","PL PA シルバー(J781) 1","PL PA M(J781) 4","PL PA X(J781) 5","PL PA Z(J781) 6","PL カモ M(SJM01) 1","PL カモ J(SJM01) 7"]
*/
	"ポリエステル" : [
		"黒　無地(5001WY)10Y","ネイビー　無地(5001WY)130Y","ブルー　無地(5001WY)F202Y","グレー　無地(5001WY)3Y","ライトグレー　無地(5001WY)F32Y","ベージュ　無地(5001WY)F22Y","グレー　ジャガード(T4000B)5","ネイビー　ジャガード(T4000B)11","シルバー　ペイズリー(J781)1","ブルー　ペイズリー(J781)4","グレー　ペイズリー(J781)5","ネイビー　ペイズリー(J781)4","ネイビー　カモフラ(SJM01)1","ブラウン　カモフラ(SJM01)7"
	],
	"ポリエステルレーヨン" : [
		"黒　無地(9014)SBK","ネイビー　無地(9014)137","ブルー　無地(9014)136","チャコールグレー　無地(9014)143","グレー　無地(9014)115","ライトグレー　無地(9014)126","ブラウン　無地(9014)111","玉虫　無地(9014)120","白　無地(9014)101" 
	],
	"キュプラ" : [
		"ブラウン　無地(AK1600)7","赤　無地(AK1600)14","ダークブラウン　無地(AK1600)29","ブルー　無地(AK1600)45","ネイビー　無地(AK1600)47","グレー　無地(AK1600)53","チャコールグレー　無地(AK1600)54","黒　無地(AK1600)56","白　無地(AK1600)76",
		"ダークブラウン　花柄(AK821)4","ボルドー　花柄(AK821)8","ネイビー　花柄(AK821)10","グレー　花柄(AK821)12","オリーブ　花柄(AK821)26",
		"ブラウン　ペイズリー(KL354)7","ダークブラウン　ペイズリー(KL354)30","ネイビー　ペイズリー(KL354)45","グレー　ペイズリー(KL354)500",
		"ライトブラウン　ドット(AK807)3","カーキ　ドット(AK807)7","ボルドー　ドット(AK807)9","ブルー　ドット(AK807)10","ライトグレー　ドット(AK807)12","グレー　ドット(AK807)13","ベージュ　ドット(AK807)15",
		"白　ペイズリー(AK809)1","ライトブラウン　ペイズリー(AK809)5","ブラウン　ペイズリー(AK809)6","ライトグレー　ペイズリー(AK809)11","グレー　ペイズリー(AK809)12","チャコールグレー　ペイズリー(AK809)13","ネイビー　ペイズリー(AK809)14",
		"ベージュ　ペイズリー CU/CO(KL325)2","グレー　ペイズリー CU/CO(KL325)6","ブラウン　ペイズリー CU/CO(KL325)7","ライトグレー　ペイズリー CU/CO(KL325)10","チャコールグレー　ペイズリー CU/CO(KL325)11","ネイビー　ペイズリー CU/CO(KL325)16","ブルー　ペイズリー CU/CO(KL325)26"
	],
};

/*
 * ルール７
 * ジレ内側裏地に基づく内側裏地のリストを保持するマップ
 * bodyBackMateStkNoList
 *     内側裏地素材:内側裏地品番の配列
 */
var giletInsideLiningMateStkNoList = {
	"ポリエステル" : [
		"黒　無地(5001WY)10Y","ネイビー　無地(5001WY)130Y","ブルー　無地(5001WY)F202Y","グレー　無地(5001WY)3Y","ライトグレー　無地(5001WY)F32Y","ベージュ　無地(5001WY)F22Y"
	],
	"ポリエステルレーヨン" : [
		"黒　無地(9014)SBK","ネイビー　無地(9014)137","ブルー　無地(9014)136","チャコールグレー　無地(9014)143","グレー　無地(9014)115","ライトグレー　無地(9014)126","ブラウン　無地(9014)111","玉虫　無地(9014)120","白　無地(9014)101"
	],
	"キュプラ" : [
		"ブラウン　無地(AK1600)7","赤　無地(AK1600)14","ダークブラウン　無地(AK1600)29","ブルー　無地(AK1600)45","ネイビー　無地(AK1600)47","グレー　無地(AK1600)53","チャコールグレー　無地(AK1600)54","黒　無地(AK1600)56","白　無地(AK1600)76"
	],
};

/*
 * ルール７
 * 袖裏素材に基づく袖裏品番のリストを保持するマップ
 * cuffBackMateStkNoList
 *     袖裏素材:袖裏品番の配列
 */
var cuffBackMateStkNoList = {
/*
	"ポリエステル" : ["PL Sスト Z(TS1212) BK","PL Sスト D(TS1213) 5","PL Sスト G(TS1214) 4","PL Sスト E(TS1215) 3","PL Sスト K(TS1216) 2"],
	"キュプラ" : ["CU スト Z(AK8800) 063","CU スト M(AK8800) 065","CU スト G(AK8800) 066","CU 無地 Z(AK8800) 091","CU 無地 G(AK8800) 092","CU 無地 M(AK8800) 093","CU スト M(S2001) 110","CU スト D(S2001) 113","CU スト J(S2001) 114",
		"CU J(AK1600) 7","CU N(AK1600) 14","CU D.J(AK1600) 29","CU D(AK1600) 45","CU M(AK1600) 47","CU G(AK1600) 53","CU X(AK1600) 54","CU Z(AK1600) 56","CU A(AK1600) 76"]
*/
	"ポリエステル" : [
		"黒　ストライプ(S1890)BK","ブルー　ストライプ(CS3253)18","グレー　ストライプ(CS3253)892","ライトグレー　ストライプ(CS3253)11","ベージュ　ストライプ(CS3253)3"
	],
	"キュプラ" : [
		"黒　ストライプ(AK8800)063","ネイビー　ストライプ(AK8800)065","グレー　ストライプ(AK8800)066","黒　無地(AK8800)091","グレー　無地(AK8800)092","ネイビー　無地(AK8800)093","ネイビー　ストライプ(S2001)110","ブルー　ストライプ(S2001)113","ブラウン　ストライプ(S2001)114","ブラウン　無地(AK1600)7","赤　無地(AK1600)14","ダークブラウン　無地(AK1600)29","ブルー　無地(AK1600)45","ネイビー　無地(AK1600)47","グレー　無地(AK1600)53","チャコールグレー　無地(AK1600)54","黒　無地(AK1600)56","白　無地(AK1600)76"
	],
};

/*
 * ルール７
 * 釦素材に基づく釦品番のリストを保持するマップ
 * btnMateStkNoList
 *     釦素材:釦品番の配列
 */
var btnMateStkNoList = {
	"ユリア" : [
		"グレー(DS10)8","黒(DS10)9","ベージュ(DS10)42","ブラウン(DS10)45","ネイビー(DS10)59"
	],
	"本水牛" : [
		"アイボリー(BMTS5)3A","マーブル(BMTS5)4B","無地(BMTS5)6","マーブル(MTS1)4B","無地(MTS1)6"
	],
	"ナット" : [
		"白(B33)1","黒(B33)09","グレー(B33)69","キャメル(B33)403","ライトブラウン(B33)404","ブラウン(B33)406","ダークブラウン(B33)408","ネイビー(B33)508","ブラウン(B33BC)403","赤(B33BC)404","ブルー(B33BC)507","白(B33BC)N"
	],
	"メタル" : [
		"シルバー(SE600)SMP","アンティークシルバー(SE600)SMP","ゴールド(SE600)GB","シルバー(MAZ0192)KN","アンティークシルバー(MAZ0192)KAP","ゴールド(MAZ0192)KG","アンティークゴールド(MAZ0192)KAG"
	],
	"貝" : [
		"白(TS1704)T","黒(TS1704)B","茶(TS1704)C"
	],
	"特殊ユリア" : [
		"ネイビー(A COR7)9","ベージュ(A COR7)43","ブラウン(A COR7)45","ブルー(A COR7)48","ネイビー(BG-COR D1)8","アイボリー(BG-COR D1)42","ブラウン(BG-COR D1)46","ネイビー(BG-COR D1)48","白(PRV16)1","黒マーブル(PRV16)35","ベージュ(PRV16)40","ベージュマーブル(PRV16)44","ブラウンマーブル(PRV16)46"
	],
	"特殊ポリ" : [
		"白(VT-84)1","ボルドー(VT-84)21","ベージュ(VT-84)41","ブラウン(VT-84)43","黒(VT-84)48","ブルー(VT-84)56","白(VT-128)1","ネイビー(VT-128)8","ダークブラウン(VT-128)48","ブラウン（VT-128）61"
	]
};

/*
 * ルール７
 * コート胴裏素材に基づく品番のリストを保持するマップ
 */
var coatBodyBackMateStkNoList = 
{
	"ポリエステル" : [
		"グレー　ジャガード(T4000B)5","ネイビー　ジャガード(T4000B)11","シルバー　ペイズリー(J781)1","ブルー　ペイズリー(J781)4","グレー　ペイズリー(J781)5","ネイビー　ペイズリー(J781)4","ネイビー　カモフラ(SJM01)1","ブラウン　カモフラ(SJM01)7"
	],
	"キュプラ" : [
		"黒　無地(AK1700)8","ネイビー　無地(AK1700)13","赤　無地(AK1700)17","ブラウン　無地(AK1700)24","ダークブラウン　無地(AK1700)29","グレー　無地(AK1700)40","チャコールグレー　無地(AK1700)53","白　無地(AK1700)103","ベージュ　無地(AK1700)156",
		"ブラウン　無地(AK1600)7","赤　無地(AK1600)14","ダークブラウン　無地(AK1600)29","ブルー　無地(AK1600)45","ネイビー　無地(AK1600)47","グレー　無地(AK1600)53","チャコールグレー　無地(AK1600)54","黒　無地(AK1600)56","白　無地(AK1600)76",
		"ダークブラウン　花柄(AK821)4","ボルドー　花柄(AK821)8","ネイビー　花柄(AK821)10","グレー　花柄(AK821)12","オリーブ　花柄(AK821)26",
		"ブラウン　ペイズリー(KL354)7","ダークブラウン　ペイズリー(KL354)30","ネイビー　ペイズリー(KL354)45","グレー　ペイズリー(KL354)500",
		"ライトブラウン　ドット(AK807)3","カーキ　ドット(AK807)7","ボルドー　ドット(AK807)9","ブルー　ドット(AK807)10","ライトグレー　ドット(AK807)12","グレー　ドット(AK807)13","ベージュ　ドット(AK807)15",
		"白　ペイズリー(AK809)1","ライトブラウン　ペイズリー(AK809)5","ブラウン　ペイズリー(AK809)6","ライトグレー　ペイズリー(AK809)11","グレー　ペイズリー(AK809)12","チャコールグレー　ペイズリー(AK809)13","ネイビー　ペイズリー(AK809)14",
		"ベージュ　ペイズリー CU/CO(KL325)2","グレー　ペイズリー CU/CO(KL325)6","ブラウン　ペイズリー CU/CO(KL325)7","ライトグレー　ペイズリー CU/CO(KL325)10","チャコールグレー　ペイズリー CU/CO(KL325)11","ネイビー　ペイズリー CU/CO(KL325)16","ブルー　ペイズリー CU/CO(KL325)26"
	]
};

/*
 * ルール７
 * コート袖裏素材に基づく品番のリストを保持するマップ
 */
var coatCuffBackMateStkNoList = 
{
	"キュプラ" : [
		"黒　無地(AK1700)8","ネイビー　無地(AK1700)13","赤　無地(AK1700)17","ブラウン　無地(AK1700)24","ダークブラウン　無地(AK1700)29","グレー　無地(AK1700)40","チャコールグレー　無地(AK1700)53","白　無地(AK1700)103","ベージュ　無地(AK1700)156","黒　ストライプ(AK8800)063","ネイビー　ストライプ(AK8800)065","グレー　ストライプ(AK8800)066","黒　無地(AK8800)091","グレー　無地(AK8800)092","ネイビー　無地(AK8800)093","ネイビー　ストライプ(S2001)110","ブルー　ストライプ(S2001)113","ブラウン　ストライプ(S2001)114","ブラウン　無地(AK1600)7","赤　無地(AK1600)14","ダークブラウン　無地(AK1600)29","ブルー　無地(AK1600)45","ネイビー　無地(AK1600)47","グレー　無地(AK1600)53","チャコールグレー　無地(AK1600)54","黒　無地(AK1600)56","白　無地(AK1600)76"
	]
};

/*
 * ルール７
 * コート釦素材に基づく品番のリストを保持するマップ
 */
var coatFrontBtnMatStkNoList = 
{
	"本水牛" : [
		"マーブル(MTS1)4B","無地(MTS1)6"
	],
	"特殊ユリア" : [
		"ネイビー(BG-COR D1)8","アイボリー(BG-COR D1)42","ブラウン(BG-COR D1)46","ネイビー(BG-COR D1)48"
	],
	"特殊ポリ" : [
		"白(VT-84)1","ボルドー(VT-84)21","ベージュ(VT-84)41","ブラウン(VT-84)43","黒(VT-84)48","ブルー(VT-84)56","白(VT-128)1","ネイビー(VT-128)8","ダークブラウン(VT-128)48","ブラウン（VT-128）61"
	]
};

/*
 * ルール８
 * モデルに基づく有効なタックを保持するマップ
 * tackList
 *     モデル:オブジェクト
 *         activeList:有効なタックの連想配列
 *         defaultValue:デフォルト値
 */
var tackList = {
	"TR02" : {
		activeList : [{val:"0000101",text:"ノータック"},
		{val:"0000102",text:"1アウトタック"}],
		defaultValue : "0000101"
	},
	"CH14" : {
		activeList : [{val:"0000101",text:"ノータック"}],
		defaultValue : "0000101"
	},
	"NR04" : {
		activeList : [{val:"0000101",text:"ノータック"}],
		defaultValue : "0000101"
	},
	"NZ01" : {
		activeList : [{val:"0000101",text:"ノータック"},
			{val:"0000102",text:"1アウトタック"},
			{val:"0000103",text:"1インタック"},
			{val:"0000104",text:"2アウトタック"}],
		defaultValue : "0000101"
	},
	"BS03" : {
		activeList : [{val:"0000101",text:"ノータック"}],
		defaultValue : "0000101"
	},
	"RS01" : {
		activeList : [{val:"0000101",text:"ノータック"}],
		defaultValue : "0000101"
	},
	"JW21" : {
		activeList : [{val:"0000102",text:"1アウトタック"},
			{val:"0000104",text:"2アウトタック"}],
		defaultValue : "0000104"
	},
	"AY01" : {
		activeList : [{val:"0000101",text:"ノータック"},
			{val:"0000104",text:"2アウトタック"},
			{val:"0000105",text:"2インタック"}],
		defaultValue : "0000101"
	}
}

/*
 * ルール９
 * モデルに基づく有効なアジャスター仕様を保持するマップ
 * adjusterList
 *     モデル:オブジェクト
 *         activeList:有効なアジャスター仕様の連想配列
 *         defaultValue:デフォルト値
 */
var adjusterList = {
	"TR02" : {
		activeList : ["0000601","0000603"],
		defaultValue : "0000601"
	},
	"CH14" : {
		activeList : ["0000601","0000603"],
		defaultValue : "0000601"
	},
	"NR04" : {
		activeList : ["0000601","0000603"],
		defaultValue : "0000601"
	},
	"NZ01" : {
		activeList : ["0000601","0000603","0000604"],
		defaultValue : "0000601"
	},
	"BS03" : {
		activeList : ["0000601","0000603"],
		defaultValue : "0000601"
	},
	"RS01" : {
		activeList : ["0000601","0000603"],
		defaultValue : "0000601"
	},
	"JW21" : {
		activeList : ["0000601","0000603"],
		defaultValue : "0000601"
	},
	"AY01" : {
		activeList : ["0000601","0000602","0000603"],
		defaultValue : "0000601"
	}
}

/*
 * ルール９
 * モデルに基づく有効なベルトループを保持するマップ
 * beltLoopList
 *     モデル:オブジェクト
 *         activeList:有効なベルトループの連想配列
 *         defaultValue:デフォルト値
 */
var beltLoopList = {
	"TR02" : {
		activeList : ["0000701","0000702"],
		defaultValue : "0000701"
	},
	"CH14" : {
		activeList : ["0000701","0000702"],
		defaultValue : "0000701"
	},
	"NR04" : {
		activeList : ["0000701","0000702"],
		defaultValue : "0000701"
	},
	"NZ01" : {
		activeList : ["0000701","0000702"],
		defaultValue : "0000701"
	},
	"BS03" : {
		activeList : ["0000701","0000702"],
		defaultValue : "0000701"
	},
	"RS01" : {
		activeList : ["0000701","0000702"],
		defaultValue : "0000701"
	},
	"JW21" : {
		activeList : ["0000701","0000702"],
		defaultValue : "0000701"
	},
	"AY01" : {
		activeList : ["0000702"],
		defaultValue : "0000702"
	}
}

/*
 * ルール１０,１１
 * PANTSモデルに基づく各項目のデフォルト値を保持するマップ
 * pantsModelDefaultList
 *     PANTSモデル:オブジェクト
 *         op_sidePkt:脇ポケットのデフォルト値
 *         op_sinobiPkt:忍びポケットのデフォルト値
 *         op_coinPkt:コインポケットのデフォルト値
 *         op_vCut:Vカットのデフォルト値
 *         op_pisPktUf:上前ピスポケットのデフォルト値
 *         op_pisPktDf:下前ピスポケットのデフォルト値
 */
var pantsModelDefaultList = {
	"TR02":{
		"op_sidePkt":"0001001",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001203",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001501"
	},
	"CH14":{
		"op_sidePkt":"0001002",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001202",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001502"
	},
	"NR04":{
		"op_sidePkt":"0001001",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001202",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001403",
		"op_pisPktDf":"0001502"
	},
	"BS03":{
		"op_sidePkt":"0001002",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001203",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001501"
	},
	"NZ01":{
		"op_sidePkt":"0001002",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001201",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001502"
	},
	"RS01":{
		"op_sidePkt":"0001002",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001201",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001502"
	},
	"JW21":{
		"op_sidePkt":"0001002",
		"op_sinobiPkt":"0001104",
		"op_coinPkt":"0001201",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001501"
	},
	"AY01":{
		"op_sidePkt":"0001002",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001201",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001502"
	}
};

/*
 * ルール１０,１１
 * PANTSモデルに基づく各項目のデフォルト値を保持するマップ
 * pantsTuxedoModelDefaultList
 *     PANTSモデル:オブジェクト
 *         op_sidePkt:脇ポケットのデフォルト値
 *         op_sinobiPkt:忍びポケットのデフォルト値
 *         op_coinPkt:コインポケットのデフォルト値
 *         op_vCut:Vカットのデフォルト値
 *         op_pisPktUf:上前ピスポケットのデフォルト値
 *         op_pisPktDf:下前ピスポケットのデフォルト値
 */
var pantsTuxedoModelDefaultList = {
	"TR02":{
		"op_sidePkt":"0001001",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001203",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001501"
	},
	"CH14":{
		"op_sidePkt":"0001002",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001202",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001506"
	},
	"NR04":{
		"op_sidePkt":"0001001",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001202",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001403",
		"op_pisPktDf":"0001506"
	},
	"BS03":{
		"op_sidePkt":"0001002",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001203",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001501"
	},
	"NZ01":{
		"op_sidePkt":"0001002",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001201",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001506"
	},
	"RS01":{
		"op_sidePkt":"0001002",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001201",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001506"
	},
	"JW21":{
		"op_sidePkt":"0001002",
		"op_sinobiPkt":"0001104",
		"op_coinPkt":"0001201",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001501"
	},
	"AY01":{
		"op_sidePkt":"0001002",
		"op_sinobiPkt":"0001102",
		"op_coinPkt":"0001201",
		"op_vCut":"0001602",
		"op_pisPktUf":"0001401",
		"op_pisPktDf":"0001506"
	}
};


/*
 * ルール１２
 * GILETモデルに基づく各項目のデフォルト値を保持するマップ
 * giletModelDefaultList
 *     GILETモデル:オブジェクト
 *         og_breastPkt:胸ポケットのデフォルト値
 *         og_waistPkt:腰ポケットのデフォルト値
 *         oj_waistPktSpec:腰ポケット形状のデフォルト値
 */
var giletModelDefaultList = {
	"TR02":{
		"og_breastPkt":"0000101",
		"og_waistPkt":"0000201",
		"og_waistPktSpec":"0000301",
		"og_backBelt":"0002302"
	},
	"CH14":{
		"og_breastPkt":"0000103",
		"og_waistPkt":"0000201",
		"og_waistPktSpec":"0000301",
		"og_backBelt":"0002301"
	},
	"NR04":{
		"og_breastPkt":"0000102",
		"og_waistPkt":"0000201",
		"og_waistPktSpec":"0000301",
		"og_backBelt":"0002302"
	},
	"BS01":{
		"og_breastPkt":"0000102",
		"og_waistPkt":"0000201",
		"og_waistPktSpec":"0000303",
		"og_backBelt":"0002301"
	},
	"BS03":{
		"og_breastPkt":"0000102",
		"og_waistPkt":"0000201",
		"og_waistPktSpec":"0000303",
		"og_backBelt":"0002301"
	},
	"BS01-D":{
		"og_breastPkt":"0000103",
		"og_waistPkt":"0000201",
		"og_waistPktSpec":"0000301",
		"og_backBelt":"0002301"
	},
	"ET15-D":{
		"og_breastPkt":"0000101",
		"og_waistPkt":"0000201",
		"og_waistPktSpec":"0000301",
		"og_backBelt":"0002302"
	}
};

/*
 * ルール１２
 * GILETモデルに基づくステッチ箇所変更のデフォルト値を保持するマップ
 * ogStitchModifyList
 *     GILETモデル:ステッチ箇所変更のデフォルト値配列
 */
var ogStitchModifyList = {
	"TR02":["0000701","0000705"],
	"CH14":["0000701","0000704","0000705"],
	"NR04":["0000701","0000704","0000705"],
	"BS01":["0000701","0000704","0000705"],
	"BS03":["0000701","0000704","0000705"],
	"BS01-D":["0000701","0000704","0000705"],
	"ET15-D":["0000701","0000705"]
};
var ogDStitchModifyList = {
	"TR02":["0002701","0002703"],
	"CH14":["0002701","0002702","0002703"],
	"NR04":["0002701","0002702","0002703"],
	"BS01":["0002701","0002702","0002703"],
	"BS03":["0002701","0002702","0002703"],
	"BS01-D":["0002701","0002702","0002703"],
	"ET15-D":["0002701","0002703"]
};
var ogAmfColorList = {
	"TR02":["0000901","0000903"],
	"CH14":["0000901","0000902","0000903"],
	"NR04":["0000901","0000902","0000903"],
	"BS01":["0000901","0000902","0000903"],
	"BS03":["0000901","0000902","0000903"],
	"BS01-D":["0000901","0000902","0000903"],
	"ET15-D":["0000901","0000903"]
};


/*
 * ルール１２
 * GILETモデルに基づくボタンの有無を保持するマップ（暫定データ）
 * giletModelBtnMap
 *     GILETモデル:オブジェクト
 *         bh:オブジェクト
 *             ボタンホール箇所:有無（true:有り、false:無し）
 *         by:オブジェクト
 *             ボタン付け糸箇所：有無（true:有り、false:無し）
 */
var giletModelBtnMap = {
	"TR02":{	// シングル5釦/腰Ｐ
		bh:{
			"0001201":true,
			"0001202":true,
			"0001203":true,
			"0001204":true,
			"0001205":true,
			"0001206":false
		},
		by:{
			"0001501":true,
			"0001502":true,
			"0001503":true,
			"0001504":true,
			"0001505":true,
			"0001506":false,
			"0001507":false,
			"0001508":false,
			"0001509":false,
			"0001510":false
		}
	},
	"CH14":{	// シングル5釦/腰Ｐ+胸Ｐ(両前)
		bh:{
			"0001201":true,
			"0001202":true,
			"0001203":true,
			"0001204":true,
			"0001205":true,
			"0001206":false
		},
		by:{
			"0001501":true,
			"0001502":true,
			"0001503":true,
			"0001504":true,
			"0001505":true,
			"0001506":false,
			"0001507":false,
			"0001508":false,
			"0001509":false,
			"0001510":false
		}
	},
	"NR04":{	// シングル6釦/腰Ｐ+胸Ｐ(上前)
		bh:{
			"0001201":true,
			"0001202":true,
			"0001203":true,
			"0001204":true,
			"0001205":true,
			"0001206":true
		},
		by:{
			"0001501":true,
			"0001502":true,
			"0001503":true,
			"0001504":true,
			"0001505":true,
			"0001506":true,
			"0001507":false,
			"0001508":false,
			"0001509":false,
			"0001510":false
		}
	},
	"BS01":{	// シングル5釦/腰フラップ+胸Ｐ(上前)
		bh:{
			"0001201":true,
			"0001202":true,
			"0001203":true,
			"0001204":true,
			"0001205":true,
			"0001206":false
		},
		by:{
			"0001501":true,
			"0001502":true,
			"0001503":true,
			"0001504":true,
			"0001505":true,
			"0001506":false,
			"0001507":false,
			"0001508":false,
			"0001509":false,
			"0001510":false
		}
	},
	"BS03":{	// シングル5釦衿付き/腰フラップ+胸P(両前)
		bh:{
			"0001201":true,
			"0001202":true,
			"0001203":true,
			"0001204":true,
			"0001205":true,
			"0001206":false
		},
		by:{
			"0001501":true,
			"0001502":true,
			"0001503":true,
			"0001504":true,
			"0001505":true,
			"0001506":false,
			"0001507":false,
			"0001508":false,
			"0001509":false,
			"0001510":false
		}
	},
	"BS01-D":{	// ダブル6釦衿付き/腰Ｐ+胸Ｐ(両前)
		bh:{
			"0001201":true,
			"0001202":true,
			"0001203":true,
			"0001204":false,
			"0001205":false,
			"0001206":false
		},
		by:{
			"0001501":true,
			"0001502":true,
			"0001503":true,
			"0001504":false,
			"0001505":false,
			"0001506":false,
			"0001507":true,
			"0001508":true,
			"0001509":true,
			"0001510":false
		}
	},
	"ET15-D":{	// ダブル8釦/腰Ｐ
		bh:{
			"0001201":true,
			"0001202":true,
			"0001203":true,
			"0001204":true,
			"0001205":false,
			"0001206":false
		},
		by:{
			"0001501":true,
			"0001502":true,
			"0001503":true,
			"0001504":true,
			"0001505":false,
			"0001506":false,
			"0001507":true,
			"0001508":true,
			"0001509":true,
			"0001510":true
		}
	}
};

var defaultFrontSpec = {
	"TR02":"0000402",
	"CH14":"0000401",
	"NR04":"0000401",
	"NZ01":"0000402",
	"BS03":"0000402",
	"RS01":"0000401",
	"JW21":"0000402",
	"AY01":"0000402"
};