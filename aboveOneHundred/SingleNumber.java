package aboveOneHundred;

/**
 * FileName: SingleNumber
 * author: gxs
 * Date: 2021/9/17  22:50
 */
public class SingleNumber {
//    数组中只出现一次的数字
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num :
                nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {1,2,3,4,4,3,2,1,5};
        System.out.println(singleNumber.singleNumber(nums));
    }
}
