/**
 * FileName: NumWays
 * author: gxs
 * Date: 2021/11/13  20:27
 */
public class NumWays10 {
    public int numWays(int n) {
//        解法二：动态规划，空间优化，因为每次计算时是需要用到前两个，所以用两个变量来保存之前的结果就可以了。
//        int a = 1, b = 1, sum;
//        for (int i = 0; i < n; i++) {
//            sum = (int) ((a + b) % (1e9 + 7));
//            a = b;
//            b = sum;
//        }
//        return a;

//        解法一：动态规划，用数组来存储每一个n的步数
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            nums[i] = (int) ((nums[i - 1] + nums[i - 2]) % (1e9+7));
        }
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumWays10().numWays(100));
    }
}
