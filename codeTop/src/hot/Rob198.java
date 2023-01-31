package hot;

/**
 * FileName: Rob198
 * author: gxs
 * Date: 2021/11/28  9:31
 */
public class Rob198 {
    public int rob(int[] nums) {
/**
 * 数组保存当前rob的最大金额，动态规划来解决
 * */
//        if (nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
////        f(k) = max{rob(k - 1),nums[k - 1] + rob(k - 2)};
//        int n = nums.length;
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//        for (int i = 2; i <= n; i++) {
//            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
//        }
//        return dp[n];
/**
 * 对数组空间进行优化，只需要之前的两个rob结果即可
 *
 * */
    int prev = 0;
    int curr = 0;
//    循环计算当前为止的最大金额
        for (int i :
                nums) {
//            循环开始，curr 表示dp[k - 1],prev 表示dp[k - 2]
//            f(k) = max{rob(k - 1),nums[k - 1] + rob(k - 2)};
            int tmp = Math.max(curr,prev + i);
            prev = curr;
            curr = tmp;
        }
        return curr;
    }
}
