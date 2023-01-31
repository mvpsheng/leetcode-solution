package rong360;

/**
 * FileName: MoveZeroes
 * author: gxs
 * Date: 2021/9/8  13:58
 */
public class MoveZeroes {
    private static int[] moveZeroes(int[] nums) {
        int n = nums.length;
        int low = 0;
        for (int fast : nums) {

            if (fast != 0) {
                nums[low] = fast;
                low++;
            }
        }
        while (low < n) {
            nums[low++] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] res = moveZeroes(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
