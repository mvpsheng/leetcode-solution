package hot;

/**
 * FileName: LongestPalindrome5
 * author: gxs
 * Date: 2022/3/2  11:45
 */
public class LongestPalindrome5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
public static void main(String[] args) {
    String a = "babaabaa";
    LongestPalindrome5 d = new LongestPalindrome5();
    System.out.println(d.longestPalindrome(a));
}
    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
    private boolean isPalindrome(String str) {
        int len = str.length() - 1;
        while (len > 0) {
            if (str.charAt(len) != str.charAt(str.length() - (len + 1))) {
                return false;
            }
            len--;
        }
        return true;
    }
}
