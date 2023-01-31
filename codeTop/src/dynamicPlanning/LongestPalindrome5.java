package dynamicPlanning;

import org.junit.Test;

/**
 * FileName: LongestPalindrome5
 * author: gxs
 * Date: 2022/3/17  9:34
 */
public class LongestPalindrome5 {
    public String longestPalindrome(String s) {
        int start = 0, max = 1;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                boolean b = s.charAt(i) == s.charAt(j);
                if (j - i < 2) {
                    dp[i][j] = b;
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && b;
                }
                if (dp[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        String s = "abbc";
        System.out.println(new LongestPalindrome5().longestPalindrome(s));
    }
}

