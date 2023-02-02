package threedaysTrainingWithCurl.day1;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: TwoSum1
 * author: gxs
 * Date: 2023/2/2  15:30
 */
public class TwoSum1 {
/**
 *  1. 约束分析
 *      数组长度大于等于2
 *      数值有正有负
 *      target一样
 *  2. 数据结构与算法选择
 *      选择哈希表，一个用来存储下标，一个用来存储下标对应的值。
 *  3. 复杂度分析
 *      时间： O(N)因为数组要过一遍
 *      空间；O(N) 哈希表存储数组中的元素
 *  4. 核心代码
 *
 *  5. 测试
 * */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
