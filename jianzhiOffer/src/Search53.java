/**
 * FileName: Search53
 * author: gxs
 * Date: 2022/1/13  9:04
 */
public class Search53 {
    public int search(int[] nums, int target) {
        int number = 0;
        if (nums != null && nums.length > 0) {
            int first = getFirstK(nums, nums.length, target, 0, nums.length - 1);
            int last = getLastK(nums, nums.length, target, 0, nums.length - 1);
            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }
        return number;
//        return findIndex(nums, target) - findIndex(nums, target - 1);
    }
//    解法一：找到该数字的右边界
//    int findIndex(int[] nums, int target) {
//        int i = 0, j = nums.length - 1;
//        while (i <= j) {
//            int m = (i + j) / 2;
//            if (nums[m] <= target)
//                i = m + 1;
//            else
//                j = m - 1;
//        }
//        return i;
//    }
    int getFirstK(int[] data, int length, int k, int start, int end) {
        if (start > end) {
            return - 1;
        }
        int middleIndex = (start + end) / 2;
        int middleData = data[middleIndex];
        if (middleData == k) {
            if (middleIndex > 0 && data[middleIndex - 1] != k
            || middleIndex == 0) {
                return middleIndex;
            } else
                end = middleIndex - 1;
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else
            start = middleIndex + 1;
            return getFirstK(data, length, k, start, end);
    }
    int getLastK(int[] data, int length, int k, int start, int end) {
        if (start > end) {
            return - 1;
        }
        int middleIndex = (start + end) / 2;
        int middleData = data[middleIndex];
        if (middleData == k) {
            if (middleIndex < length - 1 && data[middleIndex + 1] != k
                    || middleIndex == length - 1) {
                return middleIndex;
            } else
                start = middleIndex + 1;
        } else if (middleData < k) {
            start = middleIndex + 1;
        } else
            end = middleIndex - 1;
        return getLastK(data, length, k, start, end);
    }

}
