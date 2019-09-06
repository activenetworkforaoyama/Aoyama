package aoyama.member.domain.model;

import java.io.Serializable;
import java.util.HashMap;

public class MemberName implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /** 顧客番号 */
    private long kokNo = 0;
    /** 業態 */
    private int gyotaiCd = 0;
    /** 名前 姓 */
    private String lastName = "";
    /** 名前 名 */
    private String firstName = "";
    /** フリガナ セイ */
    private String lastNameKana = "";
    /** フリガナ メイ */
    private String firstNameKana = "";

    /**
     * インスタンスをWEB-API連携用の平文に変換します。
     * @param bean インスタンス
     * @return WEB-API連携用の平文
     */
    public static String toPlainText(MemberName bean) {
        if (bean == null) {
            return null;
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append("kokNo").append("\t").append(escapeValue(String.valueOf(bean.getKokNo()))).append("\r\n");
        sb.append("gyotaiCd").append("\t").append(escapeValue(String.valueOf(bean.getGyotaiCd()))).append("\r\n");
        sb.append("lastName").append("\t").append(escapeValue(bean.getLastName())).append("\r\n");
        sb.append("firstName").append("\t").append(escapeValue(bean.getFirstName())).append("\r\n");
        sb.append("lastNameKana").append("\t").append(escapeValue(bean.getLastNameKana())).append("\r\n");
        sb.append("firstNameKana").append("\t").append(escapeValue(bean.getFirstNameKana())).append("\r\n");
        
        return sb.toString();
    }
    
    /**
     * WEB-API連携用の平文からインスタンスを生成します。
     * @param plainText WEB-API連携用の平文
     * @return インスタンス
     */
    public static MemberName loadFromPlainText(String plainText) {
        MemberName bean = new MemberName();
        
        // String→Mapに変換
        HashMap<String, String> map = new HashMap<String, String>();
        if (null != plainText) {
            String[] lines = plainText.split("\r\n");
            for (String line : lines) {
                String[] s = line.split("\t");
                if ((null != s) && (2 <= s.length)) {
                    map.put(s[0], s[1]);
                }
            }
        }
        
        // Map→MemberNameに変換
        try {
            long v = Long.parseLong(map.get("kokNo"));
            bean.setKokNo(v);
        } catch (NumberFormatException e) {
        }
        try {
            int v = Integer.parseInt(map.get("gyotaiCd"));
            bean.setGyotaiCd(v);
        } catch (NumberFormatException e) {
        }
        bean.setLastName(map.get("lastName"));
        bean.setFirstName(map.get("firstName"));
        bean.setLastNameKana(map.get("lastNameKana"));
        bean.setFirstNameKana(map.get("firstNameKana"));
        
        return bean;
    }

    /**
     * 平文用に値をエスケープします。
     * @param value
     * @return
     */
    private static String escapeValue(String value) {
        if (value == null) {
            return "";
        }
        return value.replaceAll("\t", "").replaceAll("\r", "").replaceAll("\n", "");
    }

    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNameKana() {
        return lastNameKana;
    }

    public void setLastNameKana(String lastNameKana) {
        this.lastNameKana = lastNameKana;
    }

    public String getFirstNameKana() {
        return firstNameKana;
    }

    public void setFirstNameKana(String firstNameKana) {
        this.firstNameKana = firstNameKana;
    }

    public long getKokNo() {
        return kokNo;
    }

    public void setKokNo(long kokNo) {
        this.kokNo = kokNo;
    }

    public int getGyotaiCd() {
        return gyotaiCd;
    }

    public void setGyotaiCd(int gyotaiCd) {
        this.gyotaiCd = gyotaiCd;
    }
}
