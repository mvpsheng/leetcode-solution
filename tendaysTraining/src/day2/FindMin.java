package day2;

/**
 * FileName: FindMin
 * author: gxs
 * Date: 2022/1/28  20:38
 */
public class FindMin {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 0, 1, 2,};
        System.out.println(new FindMin().findMin(nums));
    }
}
