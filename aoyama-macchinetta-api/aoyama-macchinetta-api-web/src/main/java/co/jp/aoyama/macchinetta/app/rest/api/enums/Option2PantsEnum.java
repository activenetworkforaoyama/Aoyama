package co.jp.aoyama.macchinetta.app.rest.api.enums;

public enum Option2PantsEnum {

	// OPTIONJACKE ( DB optionCode, DtbOrder getMethod　,　API optionType　,   API optionCode)
	OPTION2PANTS01("CH14","getPt2ModelCd","S010529","S01052901"),
	OPTION2PANTS02("SAVILEROW","getPt2ModelCd","S010529","S01052902"),
	OPTION2PANTS03("0000101","getPt2TackCd","S010502","S01050201"),
	OPTION2PANTS04("0000102","getPt2TackCd","S010502","S01050202"),
	OPTION2PANTS05("0000104","getPt2TackCd","S010502","S01050203"),
	OPTION2PANTS06("0000604","getPt2AdjusterCd","S010505","S01050501"),
	OPTION2PANTS07("0000601","getPt2AdjusterCd","S010505","S01050502"),
	OPTION2PANTS08("0001701","getPt2HemUpCd","S010510","S01051001"),
	OPTION2PANTS09("0001702","getPt2HemUpCd","S010510","S01051002"),
	OPTION2PANTS10("0001703","getPt2HemUpCd","S010510","S01051003"),
	OPTION2PANTS11("0001704","getPt2HemUpCd","S010510","S01051004"),
	OPTION2PANTS12("2.5","getPt2DblWidthCd","S010511","S01051105"),
	OPTION2PANTS13("3","getPt2DblWidthCd","S010511","S01051106"),
	OPTION2PANTS14("3.5","getPt2DblWidthCd","S010511","S01051107"),
	OPTION2PANTS15("4","getPt2DblWidthCd","S010511","S01051108"),
	OPTION2PANTS16("4.5","getPt2DblWidthCd","S010511","S01051109"),
	OPTION2PANTS17("5","getPt2DblWidthCd","S010511","S01051110"),
	OPTION2PANTS18("5.5","getPt2DblWidthCd","S010511","S01051111"),
	OPTION2PANTS19("6","getPt2DblWidthCd","S010511","S01051112"),
	OPTION2PANTS20("0003801","getPt2ShoeSoreCd","S010512","S01051201"),
	OPTION2PANTS21("0003802","getPt2ShoeSoreCd","S010512","S01051202"),
	OPTION2PANTS22("0004101","getPt2ChicSlipCd","S010513","S01051301"),
	OPTION2PANTS23("0004102","getPt2ChicSlipCd","S010513","S01051302"),
	OPTION2PANTS24("0003702","getPt2ShapeMemoryCd","S010521","S01052101"),
	OPTION2PANTS25("0003701","getPt2ShapeMemoryCd","S010521","S01052102"),
	OPTION2PANTS26("0003602","getPt2NonSlipCd","S010524","S01052401"),
	OPTION2PANTS27("0003601","getPt2NonSlipCd","S010524","S01052402"),
	OPTION2PANTS28("300080001","getPt2BtnMaterialCd","S010526","QSB-001"),
	OPTION2PANTS29("300080002","getPt2BtnMaterialCd","S010526","QSB-002"),
	OPTION2PANTS30("300080003","getPt2BtnMaterialCd","S010526","QSB-003"),
	OPTION2PANTS31("300080004","getPt2BtnMaterialCd","S010526","QSB-004"),
	OPTION2PANTS32("300080005","getPt2BtnMaterialCd","S010526","QSB-005"),
	OPTION2PANTS33("300020001","getPt2BtnMaterialCd","S010526","QSB-006"),
	OPTION2PANTS34("300020002","getPt2BtnMaterialCd","S010526","QSB-007"),
	OPTION2PANTS35("300020003","getPt2BtnMaterialCd","S010526","QSB-008"),
	OPTION2PANTS36("300020004","getPt2BtnMaterialCd","S010526","QSB-009"),
	OPTION2PANTS37("300090001","getPt2BtnMaterialCd","S010526","QSB-010"),
	OPTION2PANTS38("300090002","getPt2BtnMaterialCd","S010526","QSB-011"),
	OPTION2PANTS39("300090003","getPt2BtnMaterialCd","S010526","QSB-012"),
	OPTION2PANTS40("300090004","getPt2BtnMaterialCd","S010526","QSB-013"),
	OPTION2PANTS41("300090005","getPt2BtnMaterialCd","S010526","QSB-014"),
	OPTION2PANTS42("300090006","getPt2BtnMaterialCd","S010526","QSB-015"),
	OPTION2PANTS43("300090007","getPt2BtnMaterialCd","S010526","QSB-016"),
	OPTION2PANTS44("300090008","getPt2BtnMaterialCd","S010526","QSB-017"),
	OPTION2PANTS45("300040001","getPt2BtnMaterialCd","S010526","QSB-018"),
	OPTION2PANTS46("300040002","getPt2BtnMaterialCd","S010526","QSB-019"),
	OPTION2PANTS47("300040003","getPt2BtnMaterialCd","S010526","QSB-020"),
	OPTION2PANTS48("300040004","getPt2BtnMaterialCd","S010526","QSB-021"),
	OPTION2PANTS49("300040005","getPt2BtnMaterialCd","S010526","QSB-022"),
	OPTION2PANTS50("300040006","getPt2BtnMaterialCd","S010526","QSB-023"),
	OPTION2PANTS51("300040007","getPt2BtnMaterialCd","S010526","QSB-024"),
	OPTION2PANTS52("","getPt2DblWidthCd","S010511",""),
	OPTION2PANTS53("","getPt2AmfStitchCd","S010518","S01051802");

	private final String code;
	private final String getCode;
	private final String optionType;
	private final String optionCode;
	
    private Option2PantsEnum(String code, String getCode, String optionType, String optionCode) {
    	this.code = code;
    	this.getCode = getCode;
        this.optionType = optionType;
        this.optionCode = optionCode;
    }  

	public String getCode() {
		return code;
	}

	public String getGetCode() {
		return getCode;
	}

	public String getOptionType() {
		return optionType;
	}

	public String getOptionCode() {
		return optionCode;
	}

	public static Option2PantsEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static Option2PantsEnum get(String str) {
        for (Option2PantsEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
