/**
 * FileName: Exchange21
 * author: gxs
 * Date: 2022/1/8  18:55
 */
public class Exchange21 {
    public int[] exchange(int[] nums) {
        if (nums.length == 0) return new int[]{};
        int l,r;
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            while (l < r && !isEven(nums[l])) {
                l++;
            }
            while (l < r && isEven(nums[r])) {
                r--;
            }
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            }
        }
        return nums;
    }
    boolean isEven(int x) {
//        判断这个数字是不是偶数
        return (x & 0x1) == 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] ans = new Exchange21().exchange(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(" " + ans[i]);
        }
    }
}
