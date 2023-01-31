package hot;

import java.util.*;

/**
 * FileName: Permute46
 * author: gxs
 * Date: 2021/10/16  22:31
 */
public class Permute46 {
    public List<List<Integer>> permute(int[] nums) {
//        int len = nums.length;
////        使用一个动态数组保存所有可能的全排列
//        List<List<Integer>> res = new ArrayList<>();
//        if (len == 0) {
//            return res;
//        }
//        boolean[] used = new boolean[len];
//        Deque<Integer> path = new ArrayDeque<>(len);
//        dfs(nums, len, 0, path, used, res);
//        return res;
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;

    }
    private void dfs(int[] nums,int len, int depth, Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                dfs(nums,len,depth + 1, path, used, res);
                used[i] = false;
                path.removeLast();
            }
        }
    }
    private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
//        所有数都填完了
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
//            动态维护数组
            Collections.swap(output, first, i);
//            继续递归填下一个数
            backtrack(n, output, res, first + 1);
            //            撤销操作
            Collections.swap(output, first, i);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Permute46().permute(nums).toString());
    }
}
