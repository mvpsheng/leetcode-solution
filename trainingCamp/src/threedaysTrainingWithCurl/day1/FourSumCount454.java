package threedaysTrainingWithCurl.day1;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: FourSumCount454
 * author: gxs
 * Date: 2023/2/2  15:41
 */
public class FourSumCount454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for (int k : nums1) {
            for (int e : nums2) {
                sum = k + e;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                sum = i + j;
                if (map.containsKey(-sum)) {
                    res += map.get(-sum);
                }
            }
        }
        return res;
    }
}
