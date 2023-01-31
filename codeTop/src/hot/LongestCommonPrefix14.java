package hot;

/**
 * FileName: LongestCommonPrefix14
 * author: gxs
 * Date: 2021/11/6  19:00
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (;j < ans.length() && j < strs[i].length();j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                ans = ans.substring(0,j + 1);
                if (ans.equals("")) {
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix14().longestCommonPrefix(strings));
    }
}
