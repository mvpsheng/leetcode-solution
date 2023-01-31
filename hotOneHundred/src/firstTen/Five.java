package firstTen;

/**
 * FileName: Five
 * author: gxs
 * Date: 2021/9/12  21:37
 */
public class Five {
    public String longestPalindrome(String s) {
/**
 *  最长的回文子串
 *  1.完全对称的回文
 *  2.中心对称的回文
 *
 * */
    if (s == null) {
        return null;
    }
    if (s.length() == 1) {
         return s;
    }
    StringBuffer sb = new StringBuffer(s.charAt(0));
    String maxString = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == sb.charAt(sb.length() - 1)) {

            }
        }
        return s;
    }
}
