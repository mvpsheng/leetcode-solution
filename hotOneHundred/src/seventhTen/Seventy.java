package seventhTen;

/**
 * FileName: Seventy
 * author: gxs
 * Date: 2021/9/17  23:24
 */
public class Seventy {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3;i < n + 1;i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    public static void main(String[] args) {
        Seventy seventy = new Seventy();
        System.out.println(seventy.climbStairs(4));
    }
}
