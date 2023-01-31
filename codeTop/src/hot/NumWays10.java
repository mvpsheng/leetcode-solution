package hot;

/**
 * FileName: NumWays10
 * author: gxs
 * Date: 2022/3/16  10:04
 */
public class NumWays10 {
    public int numWays(int n) {
//        1.递归
//        if (n == 0) return 1;
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//        return (int) ((numWays(n - 1) + numWays(n - 2)) % 1e9+7);
//        2.数组循环
//        int[] nums = new int[n + 1];
//        nums[1] = 1;
//        nums[0] = 1;
//        for (int i = 2; i < n + 1; i++) {
//            nums[i] = nums[n - 1] + nums[n - 2];
//        }
//        return nums[n];
//        3.数组循环 优化，用变量来替换数组
        int a = 1, b = 1, c;
        for (int i = 0; i < n; i++) {
           c = (int) ((a + b) % 1e9+7);
           a = b;
           b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new NumWays10().numWays(3));
    }
}
