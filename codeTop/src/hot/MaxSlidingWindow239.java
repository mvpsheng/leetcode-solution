package hot;

import jianzhioffer.MaxSlidingWindow;

import java.util.Arrays;

/**
 * FileName: MaxSlidingWindow239
 * author: gxs
 * Date: 2021/11/15  16:32
 */
public class MaxSlidingWindow239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int L = 0;
        int R = L + k;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        while (R < n) {
            for (int i = R; i > L; i--) {
                res[index] = Math.max(nums[i],nums[i - 1]);
            }
            L++;
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(nums, k)));
    }
}
