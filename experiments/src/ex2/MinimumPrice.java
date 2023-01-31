package ex2;


/**
 * FileName: MinimumPrice
 * author: gxs
 * Date: 2021/12/17  11:02
 * 工作分配问题，要求价格最低
 *
 */
public class MinimumPrice {
    static int count = 1;
    static int min = Integer.MAX_VALUE;
    public void backtrack(int t, int n, int[] used, int curPrice, int[][] c) {
        if (t == n) {
            count--;
            if (curPrice < min) {
                min = curPrice;
            }
            if (count==0)
                System.out.println(min);
                return;
        }
            for (int i = 0; i < n; i++) {
                if (used[i] == 1) {
                    continue;
                }
                used[i] = 1;
                curPrice += c[t][i];
                backtrack(t + 1, n, used, curPrice, c);
                used[i] = 0;
                curPrice -= c[t][i];
            }
        }

    public static void main(String[] args) {
        int n = 3;
        int[][] c = {{10,2,3},{2,3,4},{3,4,5}};
        int curPrice = 0;
        int[] used = new int[n];
        for (int i = 1; i <= n; i++) {
            count *= i;
        }
        new MinimumPrice().backtrack(0, n, used, curPrice, c);
    }
}
