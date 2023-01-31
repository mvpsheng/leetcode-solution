package netease;

/**
 * FileName: BitCounts
 * author: gxs
 * Date: 2021/9/18  19:21
 */
public class BitCounts {
    public int bits(int num) {
        //找出这个数的所有因子，然后对比因子和每一位并计数
        String str = String.valueOf(num);
        int count = 0;
        for (int i = 0; i < str.length();i++) {
            if (str.charAt(i) - '0' == 0) {
                continue;
            }
            if (num  % (str.charAt(i) - '0') == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BitCounts bitCounts = new BitCounts();
        System.out.println(bitCounts.bits(125));
    }
}
