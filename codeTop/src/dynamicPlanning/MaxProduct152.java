package dynamicPlanning;

/**
 * FileName: MaxProduct152
 * author: gxs
 * Date: 2022/3/17  17:58
 */
public class MaxProduct152 {
    public int maxProduct(int[] nums) {
        int max = nums[0],  min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int m = max, n = min;
            max = Math.max(nums[i], Math.max(m * nums[i], n * nums[i]));
            min = Math.min(nums[i], Math.min(m * nums[i], n * nums[i]));
                res = Math.max(res, max);
            }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, -1, -3};
        System.out.println(new MaxProduct152().maxProduct(nums));
    }
}
