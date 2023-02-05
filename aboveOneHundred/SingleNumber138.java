package aboveOneHundred;

import java.util.Arrays;

/**
 * FileName: SingleNumber138
 * author: gxs
 * Date: 2021/9/22  21:11
 */
public class SingleNumber138 {
    public int[] singleNumber(int[] nums) {
//        int ret = 0;
//        for (int n : nums) {
//            ret ^= n;
//        }
//        int div = 1;
//        while ((div & ret) == 0) {
//            div <<= 1;
//        }
//        int a = 0, b = 0;
//        for (int n : nums) {
//            if ((div & n) != 0) {
//                a ^= n;
//            } else {
//                b ^= n;
//            }
//        }
//        return new int[]{a, b};
        int ans = 0;
        for (int num :
                nums) {
            ans ^= num;
        }
        int div = 1;
        while ((ans & div) == 0) {
            div <<= 1;
        }
        int a = 0,b = 0;
        for (int num : nums) {
            if ((div & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        SingleNumber138 singleNumber138 = new SingleNumber138();
        System.out.println(Arrays.toString(singleNumber138.singleNumber(new int[]{0, 1, 0, 1, 99, 3, 99, 5})));
    }
}
