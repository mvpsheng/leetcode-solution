package aboveOneHundred;

/**
 * FileName: MoveZero
 * author: gxs
 * Date: 2021/9/17  22:38
 */
public class MoveZero {
    public void moveZeroes(int[] nums) {
            int index = 0;
            for (int num : nums) {
                if (num != 0) {
                    nums[index++] = num;
                }
            }
          while (index < nums.length) {
              nums[index++] = 0;
          }
    }

    public static void main(String[] args) {
        MoveZero moveZero = new MoveZero();
        int[] nums = {0,1,0,3,12};
        moveZero.moveZeroes(nums);
        for (int num: nums)
            System.out.print(" "+num);
    }
}
