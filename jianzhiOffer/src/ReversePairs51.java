/**
 * FileName: ReversePairs51
 * author: gxs
 * Date: 2022/1/10  12:46
 */
public class ReversePairs51 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);
        int count = reversePairsCore(nums, copy, 0,  n - 1);
        return count;
    }
    private int reversePairsCore(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = nums[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = reversePairsCore(copy, nums, start, start + length);
        int right = reversePairsCore(copy, nums, start + length + 1, end);
        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (nums[i] > nums[j]) {
                copy[indexCopy--] = nums[i--];
                count += j - start - length;
            } else {
                copy[indexCopy--] = nums[j--];
            }
        }
        for (; i >= start; --i) {
            copy[indexCopy--] = nums[i];
        }
        for (; j >= start + length + 1; --j) {
            copy[indexCopy--] = nums[j];
        }
        return left + right + count;
    }
}
