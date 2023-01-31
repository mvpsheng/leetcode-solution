package babieshidai;

import java.util.Arrays;

/**
 * FileName: Solution
 * author: gxs
 * Date: 2021/9/10  18:30
 */
class DistributeK {

    public static boolean distributeKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        if (nums[len - 1] > target) {
            return false;
        }

        int size = 1 << len;
        boolean[] dp = new boolean[size];
        dp[0] = true;
        int[] currentSum = new int[size];
        for (int i = 0; i < size; i++) {
            if (!dp[i]) {
                continue;
            }

            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    continue;
                }
                int next = i | (1 << j);
                if (dp[next]) {
                    continue;
                }
                if ((currentSum[i] % target) + nums[j] <= target) {
                    currentSum[next] = currentSum[i] + nums[j];
                    dp[next] = true;
                } else {
                    break;
                }
            }
        }
        return dp[size - 1];
    }

    public static void main(String[] args) {
        int[] nums ={4, 3, 2, 3, 5, 2, 1};
        System.out.println(distributeKSubsets(nums, 4));
    }
}
