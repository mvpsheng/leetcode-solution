package hot;

/**
 * FileName: LengthOfLIS300
 * author: gxs
 * Date: 2021/11/14  11:03
 */
public class LengthOfLIS300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1) ;
                }
            }
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        System.out.println(new LengthOfLIS300().lengthOfLIS(nums));
    }
}
