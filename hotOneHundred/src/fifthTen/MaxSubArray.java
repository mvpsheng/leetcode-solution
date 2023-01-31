package fifthTen;

/**
 * FileName: MaxSubArray
 * author: gxs
 * Date: 2021/9/26  12:19
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
//        int sum = 0;
//        int max = Integer.MIN_VALUE;
//        for(int num: nums){
//            if(sum <= 0){
//                sum = num;
//            }else{
//                sum += num;
//            }
//            max = Math.max(sum,max);
//        }
//        return max;

//          解法一：动态规划  时间复杂度O（N）,空间复杂度O(1)
        int sum = 0,maxAns = nums[0];
        for (int x : nums) {
            sum = Math.max(sum + x, x);
            maxAns = Math.max(maxAns,sum);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(nums));
    }
}
