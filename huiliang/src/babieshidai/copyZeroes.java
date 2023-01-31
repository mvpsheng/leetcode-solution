package babieshidai;

/**
 * FileName: copyZeroes
 * author: gxs
 * Date: 2021/9/10  18:34
 */
public class copyZeroes {
    //1,0,2,3,0,4,5,0
    //复写数组中出现的0，其他元素右移
    public static int[] copyZero(int[] nums){

        if (nums.length == 0){
            return new int[]{};
        }
        for (int i = 0; i < nums.length - 1;i++) {
            if (nums[i] == 0){
                for (int j = nums.length - 1; j > i ; j--) {
                    nums[j] = nums[j - 1];
                }
                i++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,3,0,4,5,0};
        int[] s1 = copyZero(nums);
        for (int num : s1 ) {
            System.out.print(" "+num);
        }
    }

}
