package hot;

import java.util.Arrays;

/**
 * FileName: NextPermutation31
 * author: gxs
 * Date: 2021/11/27  16:50
 */
public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, len);
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        new NextPermutation31().nextPermutation(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
