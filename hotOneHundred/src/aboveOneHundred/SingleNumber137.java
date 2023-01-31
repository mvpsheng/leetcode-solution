package aboveOneHundred;

/**
 * FileName: SingleNumber137
 * author: gxs
 * Date: 2021/9/22  20:57
 */
public class SingleNumber137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber137 singleNumber137 = new SingleNumber137();
        System.out.println(singleNumber137.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
