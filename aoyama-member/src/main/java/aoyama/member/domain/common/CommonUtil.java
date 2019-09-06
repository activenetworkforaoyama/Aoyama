package aoyama.member.domain.common;

public class CommonUtil {
    
    /**
     * 引数の文字列がnullか空文字の場合はtrueを返す
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        
        if (str == null || "".equals(str)) {
            
            return true;
        } else {
            
            return false;
        }
    }
}
