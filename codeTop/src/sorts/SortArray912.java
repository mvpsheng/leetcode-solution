

import java.util.Arrays;
import java.util.Random;

/**
 * FileName: SortArray
 * author: gxs
 * Date: 2021/9/29  17:05
 */
public class SortArray912 {
    private static final int INSERTION_SORT_THRESHOLD = 7;
    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        if (len > 1) {
        quickSort(nums,0,len - 1);
        } else {
            return nums;
        }
        return nums;
    }
    private void quickSort(int[] nums,int left,int right) {
//        小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums,left,right);
            return;
        }
        int pIndex = partition(nums,left,right);
        quickSort(nums,left,pIndex - 1);
        quickSort(nums,pIndex + 1,right);
    }
    private void insertionSort(int[] nums,int left,int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }
    private int partition(int[] nums,int left,int right) {
        int randomIndex = 0;
        if (right - left + 1 > 0) {
            randomIndex = RANDOM.nextInt(right - left + 1) + left;
        }

        swap(nums,left,randomIndex);
//        基准值
        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i <= right ; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums,i,lt);
            }
        }
        swap(nums,left,lt);
        return lt;
    }
    private void swap(int[] nums,int index1,int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        SortArray912 sortArray912 = new SortArray912();
        System.out.println(Arrays.toString(sortArray912.sortArray(nums)));
    }
}
