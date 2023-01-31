/**
 * FileName: TwoSum57
 * author: gxs
 * Date: 2022/1/13  13:08
 */
public class TwoSum57 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 1) return new int[]{};
        int r = nums.length - 1;
        int l = 0;
        while (r > l) {
            int sum = nums[r] + nums[l];
            if (sum == target) {
                res[0] = nums[r];
                res[1] = nums[l];
                break;
            }
            else if (sum < target) {
                l++;
            } else
                r--;
        }
        return res;
    }
}
