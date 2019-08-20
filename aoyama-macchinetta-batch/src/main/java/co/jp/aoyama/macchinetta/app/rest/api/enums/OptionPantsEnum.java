package co.jp.aoyama.macchinetta.app.rest.api.enums;

public enum OptionPantsEnum {

	// OPTIONJACKE ( DB optionCode, DtbOrder getMethod　,　API optionType　,   API optionCode)
	OPTIONPANTS01("CH14","getPtModelCd","S010529","S01052901"),
	OPTIONPANTS02("SAVILEROW","getPtModelCd","S010529","S01052902"),
	OPTIONPANTS03("0000101","getPtTackCd","S010502","S01050201"),
	OPTIONPANTS04("0000102","getPtTackCd","S010502","S01050202"),
	OPTIONPANTS05("0000104","getPtTackCd","S010502","S01050203"),
	OPTIONPANTS06("0000604","getPtAdjusterCd","S010505","S01050501"),
	OPTIONPANTS07("0000601","getPtAdjusterCd","S010505","S01050502"),
	OPTIONPANTS08("0001701","getPtHemUpCd","S010510","S01051001"),
	OPTIONPANTS09("0001702","getPtHemUpCd","S010510","S01051002"),
	OPTIONPANTS10("0001703","getPtHemUpCd","S010510","S01051003"),
	OPTIONPANTS11("0001704","getPtHemUpCd","S010510","S01051004"),
	OPTIONPANTS12("2.5","getPtDblWidthCd","S010511","S01051105"),
	OPTIONPANTS13("3","getPtDblWidthCd","S010511","S01051106"),
	OPTIONPANTS14("3.5","getPtDblWidthCd","S010511","S01051107"),
	OPTIONPANTS15("4","getPtDblWidthCd","S010511","S01051108"),
	OPTIONPANTS16("4.5","getPtDblWidthCd","S010511","S01051109"),
	OPTIONPANTS17("5","getPtDblWidthCd","S010511","S01051110"),
	OPTIONPANTS18("5.5","getPtDblWidthCd","S010511","S01051111"),
	OPTIONPANTS19("6","getPtDblWidthCd","S010511","S01051112"),
	OPTIONPANTS20("0003801","getPtShoeSoreCd","S010512","S01051201"),
	OPTIONPANTS21("0003802","getPtShoeSoreCd","S010512","S01051202"),
	OPTIONPANTS22("0004101","getPtChicSlipCd","S010513","S01051301"),
	OPTIONPANTS23("0004102","getPtChicSlipCd","S010513","S01051302"),
	OPTIONPANTS24("0003702","getPtShapeMemoryCd","S010521","S01052101"),
	OPTIONPANTS25("0003701","getPtShapeMemoryCd","S010521","S01052102"),
	OPTIONPANTS26("0003602","getPtNonSlipCd","S010524","S01052401"),
	OPTIONPANTS27("0003601","getPtNonSlipCd","S010524","S01052402"),
	OPTIONPANTS28("300080001","getPtBtnMaterialCd","S010526","QSB-001"),
	OPTIONPANTS29("300080002","getPtBtnMaterialCd","S010526","QSB-002"),
	OPTIONPANTS30("300080003","getPtBtnMaterialCd","S010526","QSB-003"),
	OPTIONPANTS31("300080004","getPtBtnMaterialCd","S010526","QSB-004"),
	OPTIONPANTS32("300080005","getPtBtnMaterialCd","S010526","QSB-005"),
	OPTIONPANTS33("300020001","getPtBtnMaterialCd","S010526","QSB-006"),
	OPTIONPANTS34("300020002","getPtBtnMaterialCd","S010526","QSB-007"),
	OPTIONPANTS35("300020003","getPtBtnMaterialCd","S010526","QSB-008"),
	OPTIONPANTS36("300020004","getPtBtnMaterialCd","S010526","QSB-009"),
	OPTIONPANTS37("300090001","getPtBtnMaterialCd","S010526","QSB-010"),
	OPTIONPANTS38("300090002","getPtBtnMaterialCd","S010526","QSB-011"),
	OPTIONPANTS39("300090003","getPtBtnMaterialCd","S010526","QSB-012"),
	OPTIONPANTS40("300090004","getPtBtnMaterialCd","S010526","QSB-013"),
	OPTIONPANTS41("300090005","getPtBtnMaterialCd","S010526","QSB-014"),
	OPTIONPANTS42("300090006","getPtBtnMaterialCd","S010526","QSB-015"),
	OPTIONPANTS43("300090007","getPtBtnMaterialCd","S010526","QSB-016"),
	OPTIONPANTS44("300090008","getPtBtnMaterialCd","S010526","QSB-017"),
	OPTIONPANTS45("300040001","getPtBtnMaterialCd","S010526","QSB-018"),
	OPTIONPANTS46("300040002","getPtBtnMaterialCd","S010526","QSB-019"),
	OPTIONPANTS47("300040003","getPtBtnMaterialCd","S010526","QSB-020"),
	OPTIONPANTS48("300040004","getPtBtnMaterialCd","S010526","QSB-021"),
	OPTIONPANTS49("300040005","getPtBtnMaterialCd","S010526","QSB-022"),
	OPTIONPANTS50("300040006","getPtBtnMaterialCd","S010526","QSB-023"),
	OPTIONPANTS51("300040007","getPtBtnMaterialCd","S010526","QSB-024"),
	OPTIONPANTS52("","getPtDblWidthCd","S010511",""),
	OPTIONPANTS53("","getPtAmfStitchCd","S010518","S01051802");

	private final String code;
	private final String getCode;
	private final String optionType;
	private final String optionCode;
	
    private OptionPantsEnum(String code, String getCode, String optionType, String optionCode) {
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

	public static OptionPantsEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }
  
    public static OptionPantsEnum get(String str) {
        for (OptionPantsEnum e : values()) {
            if(e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

}
