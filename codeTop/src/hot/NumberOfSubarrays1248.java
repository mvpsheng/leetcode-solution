package hot;

/**
 * FileName: NumberOfSubarrays1248
 * author: gxs
 * Date: 2021/11/27  18:10
 */
public class NumberOfSubarrays1248 {
    public int numberOfSubarrays(int[] nums, int k) {
/**
 * 前缀和方法
 * */
//    数组prefixCnt的下标是前缀和（当前奇数的个数），值是当前前缀和的个数。
//        int[] prefixCnt = new int[nums.length + 1];
//        prefixCnt[0] = 1;
////        遍历原数组，计算当前的前缀和，统计到prefixCnt数组中，
////        并且在res中累加上与当前前缀和差值为k的前缀和的个数
//        int res = 0, sum = 0;
//        for (int num : nums) {
//            sum += num & 1;
//        prefixCnt[sum]++;
//        if (sum >= k) {
//            res += prefixCnt[sum - k];
//        }
//        }
//        return res;
/**
 * 滑动窗口方法
 * */
    int left = 0, right = 0, oddCnt = 0, res = 0;
    while (right < nums.length) {
//        右指针先走，每遇到一个奇数 odd+1
        if ((nums[right++] & 1) == 1) {
            oddCnt++;
        }

//        若当前滑动窗口[left,right)中有k个奇数，进入此分支
//        统计当前滑动窗口中优美子数组个数
        if (oddCnt == k) {
//            先将滑动窗口的右边界向右扩展，知道遇到下一个奇数（或出界）
//            rightEventCnt即为第k个奇数右边的偶数的个数
            int tmp = right;
            while (right < nums.length && (nums[right] & 1) == 0) {
                right++;
            }
            int rightEvenCnt = right - tmp;
//            leftEvenCnt即为第1个奇数左边的偶数个数
            int leftEvenCnt = 0;
            while ((nums[left] & 1) == 0) {
                leftEvenCnt++;
                left++;
            }
            res += (leftEvenCnt + 1) * (rightEvenCnt + 1);
            left++;
            oddCnt--;
        }
    }
    return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(new NumberOfSubarrays1248().numberOfSubarrays(nums, k));
    }
}
