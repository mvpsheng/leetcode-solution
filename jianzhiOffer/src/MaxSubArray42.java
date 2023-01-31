/**
 * FileName: MaxSubArray42
 * author: gxs
 * Date: 2022/1/16  18:45
 */
public class MaxSubArray42 {
    public int maxSubArray(int[] nums) {
//        动态规划分析规律
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
