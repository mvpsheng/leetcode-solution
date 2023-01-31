package Day1;

/**
 * FileName: FindFirstAndLast
 * author: gxs
 * Date: 2021/8/14  13:29
 */
public class FindFirstAndLast {
    public static int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] ans = searchRange(nums,8);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+ " ");
        }
    }
}
