package hot;

/**
 * FileName: FindKthLargest215
 * author: gxs
 * Date: 2021/9/30  10:02
 */
public class FindKthLargest215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length - 1,k);
    }
    int quickSelect (int[] nums,int low,int high,int k) {
        int pivot = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums,pivot++,j);
            }
        }
        swap(nums,pivot,high);
        int count = high - pivot + 1;
        if (count == k) return nums[pivot];
        if (count > k) return quickSelect(nums,pivot + 1,high,k);
        return quickSelect(nums,low,pivot - 1,k - count);
    }
    void swap(int[] nums,int index1,int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        FindKthLargest215 findKthLargest215 = new FindKthLargest215();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest215.findKthLargest(nums, k));
    }
}
