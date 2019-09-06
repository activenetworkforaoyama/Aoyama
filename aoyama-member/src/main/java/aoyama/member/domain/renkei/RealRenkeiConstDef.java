package aoyama.member.domain.renkei;

import java.util.HashMap;

/**
 * 連携処理用の定数クラスです.
 */
public class RealRenkeiConstDef {

    /** 更新社員No */
    //public static final String UPD_EMPLOYEE_NO = "031266";
    /** ZERO */
    public static final String ZERO = "0";
    /** 半角スペース */
    public static final String SPACE = " ";

    /** 結果コード：正常 */
    public static final String RET_CD_OK = "0";

    /** 一度に連携可能なデータ件数(デフォルト) */
    public static final String MAX_DATACNT_DEFAULT = "200";
    
    /** リアル連携 リカバリフラグ：通常データ */
    public static final String RENKEI_RECOVERYFLG_NORMAL   = "0";
    /** リアル連携 リカバリフラグ：リカバリデータ */
    public static final String RENKEI_RECOVERYFLG_RECOVERY = "1";
    
    /** 更新区分：顧客更新 */
    public static final String UPD_KBN_MEM_UPD = "20";
    
    /** 顧客データ状態区分：顧客更新、または、WEB退会 */
    public static final String JYOUTAI_KBN_UPD_OR_LEAVE = "11";
    
    /** 会員種別(カード種別) */
    public static final HashMap<String, String> CARD_TYPE_MAP = new HashMap<String, String>();
    static {
        CARD_TYPE_MAP.put("1", "学生");
        CARD_TYPE_MAP.put("2", "一般");
        CARD_TYPE_MAP.put("3", "カード会員");
        CARD_TYPE_MAP.put("4", "学生AC");
        CARD_TYPE_MAP.put("5", "企業提携AC");
        CARD_TYPE_MAP.put("6", "学生提携");
        CARD_TYPE_MAP.put("7", "組合・教職員");
        CARD_TYPE_MAP.put("8", "組合・教職員AC");
        CARD_TYPE_MAP.put("11", "レディスアカデミー");
        CARD_TYPE_MAP.put("12", "レディスCC");
        CARD_TYPE_MAP.put("13", "レディスAC");
        CARD_TYPE_MAP.put("14", "レディスアカデミーAC");
        CARD_TYPE_MAP.put("17", "レディスタイアップ");
        CARD_TYPE_MAP.put("18", "レディスタイアップAC");
    }
    public static final int MEM_CLASS_STUDENT      = 1; // 学生
    public static final int MEM_CLASS_GENERAL      = 2; // 一般
    public static final int MEM_CLASS_TSC_CARD     = 3;  // カード会員
    public static final int MEM_CLASS_STUDENT_AC   = 4;  // 学生AC会員
    public static final int MEM_CLASS_COMPANY_AC   = 5;  // 企業提携AC
    public static final int MEM_CLASS_COMPANY      = 6;  // 学生提携会員
    public static final int MEM_CLASS_EDUCATION    = 7;  // 組合・教職員会員
    public static final int MEM_CLASS_EDUCATION_AC = 8;  // 組合・教職員AC
    public static final int MEM_CLASS_LDY_STUDENT  = 11; // レディスアカデミー
    public static final int MEM_CLASS_LDY_CC       = 12; // レディスCC
    public static final int MEM_CLASS_LDY_AC       = 13; // レディスAC
    public static final int MEM_CLASS_LDY_STUDENT_AC  = 14; // レディスアカデミーAC
    public static final int MEM_CLASS_LDY_COMPANY  = 17; // レディスタイアップ
    public static final int MEM_CLASS_LDY_COMPANY_AC  = 18; // レディスタイアップAC
}
