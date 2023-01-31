package Day5;

/**
 * FileName: NumSubArrayProductLessThanK
 * author: gxs
 * Date: 2021/8/17  14:04
 */
public class NumSubArrayProductLessThanK {
    /***
     * public int numSubarrayProductLessThanK(int[] nums, int k) {
     *         if (k <= 1) return 0;
     *         int prod = 1, ans = 0, left = 0;
     *         for (int right = 0; right < nums.length; right++) {
     *             prod *= nums[right];
     *             while (prod >= k) prod /= nums[left++];
     *             ans += right - left + 1;
     *         }
     *         return ans;
     *     }
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k/solution/cheng-ji-xiao-yu-kde-zi-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        double logk = Math.log(k);
        double[] prefix = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i+1] = prefix[i] + Math.log(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < prefix.length; i++) {
            int lo = i + 1, hi = prefix.length;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (prefix[mi] < prefix[i] + logk - 1e-9) lo = mi + 1;
                else hi = mi;
            }
            ans += lo - i - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
