package hot;

import java.util.Arrays;

/**
 * FileName: Rob213
 * author: gxs
 * Date: 2021/11/28  10:00
 */
public class Rob213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob1(Arrays.copyOfRange(nums,1,nums.length)),
                rob1(Arrays.copyOfRange(nums,0,nums.length - 1)));
    }
    private int rob1(int[] nums) {
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
