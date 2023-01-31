import java.util.HashMap;
import java.util.Map;

/**
 * FileName: subArraySum
 * author: gxs
 * Date: 2021/8/14  13:13
 */
public class subArraySum {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> presum_cnt = new HashMap<>();
        presum_cnt.put(0, 1);

        int res = 0;
        int pre = 0;
        for (int y : nums)
        {
            pre += y;
            int x = pre - k;
            res += presum_cnt.getOrDefault(x, 0);
            presum_cnt.put(pre, presum_cnt.getOrDefault(pre, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        int k = 12;
        int res = subarraySum(nums,k);
        System.out.println(res);
    }
}
