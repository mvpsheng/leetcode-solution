package Day2;

/**
 * FileName: FindMin
 * author: gxs
 * Date: 2021/8/15  18:57
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

    }
}
