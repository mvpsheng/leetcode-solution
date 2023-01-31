

/**
 * FileName: MergeSort
 * author: gxs
 * Date: 2021/9/25  17:25
 */
/**
 * nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * */
public class MergeSort {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }
    public void heapSort(int[] nums) {
        int len = nums.length - 1;
        buildMaxHeap(nums,len);
    }
    public void buildMaxHeap(int[] nums,int len) {
        for (int i = len / 2; i >= 0; --i) {
            maxHeapify(nums,i,len);
        }
    }
    public void maxHeapify(int[] nums,int i,int len) {
        for (;(i << 1) + 1 <= len;) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
        }
    }

    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
