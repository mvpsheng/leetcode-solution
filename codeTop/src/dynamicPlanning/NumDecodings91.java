package dynamicPlanning;

/**
 * FileName: NumDecodings91
 * author: gxs
 * Date: 2022/3/17  15:24
 */
public class NumDecodings91 {
    public int numDecodings(String s) {
//        目前可优化
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "112";
        System.out.println(new NumDecodings91().numDecodings(s));
    }
}
