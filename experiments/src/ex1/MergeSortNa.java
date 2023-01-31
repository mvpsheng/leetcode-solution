package ex1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * FileName: MergeSortNa
 * author: gxs
 * Date: 2021/11/1  10:56
 */
public class MergeSortNa {
//    用一次线性扫描找出已经排好序的子数组段。
    public int[] mergeSortNa(int[] nums) {
        int n = nums.length;
        int[] index = new int[n];
        int j = partition(nums,index);
        while (j != 2) {
            for (int i = 0; i < j - 2; i += 2) {
                merge(nums,index[i],index[i + 1] - 1,index[i + 2] - 1);
            }
            j = partition(nums,index);
        }

        return nums;
    }
    private int partition(int[] nums,int[] index) {
        Arrays.fill(index, 0);
        int j = 0;
        index[j++] = 0;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= cur) {
                index[j++] = i;
            }
            cur = nums[i];
        }
        index[j++] = nums.length;
        return j;
    }
    private void merge(int[] nums, int left, int mid, int right) {
        int i = left,j = mid + 1,k = left;
        int t;
        int[] res = new int[nums.length];
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                res[k++] = nums[i++];
            } else {
                res[k++] = nums[j++];
            }
        }
        if (i != mid + 1) {
            for (t = i; t <= mid; t++) {
                res[k++] = nums[t];
            }
        }
        if (j != right + 1) {
            for (t = j; t <= right; t++) {
                res[k++] = nums[t];
            }
        }
        System.arraycopy(res,left,nums,left,right - left + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 6, 7, 8, 2};
        System.out.println(Arrays.toString(new MergeSortNa().mergeSortNa(nums)));
    }
}
