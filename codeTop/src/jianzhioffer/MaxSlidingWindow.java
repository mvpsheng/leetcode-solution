package jianzhioffer;

import java.util.LinkedList;

/**
 * FileName: MaxSlidingWindow
 * author: gxs
 * Date: 2021/11/4  17:02
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];

        int left = 0,right = left + 2;
        while (right < nums.length) {
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                max = Math.max(max,nums[i]);
            }
           res[left] = max;
            right++;
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {};//1,3,-1,-3,5,3,6,7
        int[] ans = new MaxSlidingWindow().maxSlidingWindow(nums,0);
        if (ans != null) {
            for (int num : ans) {
                System.out.print(num + " ");
            }
        }

    }
}
