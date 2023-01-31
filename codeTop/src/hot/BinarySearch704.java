package hot;

/**
 * FileName: BinarySearch704
 * author: gxs
 * Date: 2021/10/16  18:01
 */
public class BinarySearch704 {
    public int search(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target? 0 : -1;
        }
        int left = 0,right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
