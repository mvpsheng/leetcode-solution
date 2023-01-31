package hot;

import java.util.Arrays;

/**
 * FileName: GetPermutation60
 * author: gxs
 * Date: 2021/11/17  10:42
 */
public class GetPermutation60 {
/**
 * 记录数字是否使用过
 * */
    private boolean[] used;

/**
 * 阶乘数组
 * */
    private int[] factorial;

    private int n;
    private int k;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        calculateFactorial(n);

//        查找全排列需要的布尔数组
        used = new boolean[n + 1];
        Arrays.fill(used,false);

        StringBuilder path = new StringBuilder();
        dfs(0,path);
        return path.toString();
    }
/**
 * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
 * @param path
 * */
    private void dfs(int index, StringBuilder path) {
        if (index == n) {
            return;
        }
//        计算还未确定的数字的全排列的个数，第1次进入的时候是 n - 1
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(index + 1, path);
//          直接return 因为一遍就求出结果了，不需要回溯
        }
    }
/**
 * 计算阶乘数组
 *
 * @param n
 * */
    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    public static void main(String[] args) {
        System.out.println(new GetPermutation60().getPermutation(4, 9));
    }
}
