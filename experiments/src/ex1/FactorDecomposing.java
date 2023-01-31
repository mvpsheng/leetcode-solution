package ex1;

/**
 * FileName: FactorDecomposing
 * author: gxs
 * Date: 2021/10/8  20:09
 */

import java.util.*;

/**
 * 整数因子分解问题
 * 给定一个整数，求所有分解式个数
 * */
public class FactorDecomposing {
    private int factors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 2) {
            return 0;
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                res.add(i);
            }
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, res, path, ans);
        return ans.size();
    }
    private void dfs(int n, List<Integer> res,
                     Deque<Integer> path, List<List<Integer>> ans) {
        int one = 1;
        for (int num : path) {
            one *= num;
        }
        if (one == n) {
            ans.add(new ArrayList<>(path));
            return;
        } else if (one > n) {
            return;
        }
        for (int i = 0; i < res.size(); i++) {

            path.addLast(res.get(i));
            dfs(n, res, path, ans);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        System.out.println(new FactorDecomposing().factors(12));
    }
}
