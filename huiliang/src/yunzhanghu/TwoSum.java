package yunzhanghu;

/**
 * FileName: TwoSum
 * author: gxs
 * Date: 2021/9/19  16:13
 */
public class TwoSum {
    public int[] twoSum (int[] nums, int target) {
        // write code here
//        if
        int[] res =null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res = new int[]{i,j};
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        for (int num :
                twoSum.twoSum(nums,target)) {
            System.out.print(num + " ");
        }
    }
}
