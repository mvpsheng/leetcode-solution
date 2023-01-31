package day1;

/**
 * FileName: TwoSum
 * author: gxs
 * Date: 2022/1/27  12:33
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
 *
 * */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();
       int len = nums.length;
       map.put(nums[0], 0);
        for (int i = 1; i < len; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{i, map.get(x)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int tar = 6;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, tar)));
    }
}
