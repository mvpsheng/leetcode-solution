package aboveOneHundred;

import javax.swing.*;

/**
 * FileName: ReversePairs493
 * author: gxs
 * Date: 2023/1/30  17:39
 */
public class ReversePairs493 {
    /**
     * 1. 分析约束条件
     *      nums的长度不超过50000
     *      数组元素大小都是32位之内
     * 2. 数据结构和算法
     *      用归并排序中的归并过程来统计符合条件的数对
     * 3. 算法复杂度
     *      时间复杂度：因为过了一遍归并排序，所以时间复杂度为O(NLogN);
     *      空间复杂度：用到了一个n大小的辅助数组，所以空间复杂度为O(N)。
     * 4. 核心代码
     *      用两个指针来统计两个数组中符合条件的数对
     *
     * 5. 测试
     *      [
     * */
    private int count;
    public int reversePairs(int[] nums) {
        sort(nums);
        return count;
    }

//    辅助数组
    private int[] temp;

    private void sort(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo == hi) return;

        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        if (hi + 1 - lo >= 0)
            System.arraycopy(nums, lo, temp, lo, hi + 1 - lo);

        int end = mid + 1;
        for (int i = lo; i <= mid; i++) {
            while (end <= hi && (long)nums[i] > (long)2 * nums[end]) {
                end++;
            }
            count += end - (mid + 1);
        }

        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[][] testNums = {
                {1, 3, 1},
                {1, 1},
                {1, 2, 3, 4, 1, 2}
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println(new ReversePairs493().reversePairs(testNums[i]));
        }
    }
}
