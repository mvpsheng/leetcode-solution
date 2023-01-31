package ex1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * FileName: Permute1
 * author: gxs
 * Date: 2021/10/8  20:12
 */
//无重复元素的全排列
public class Permute1 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
//        使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, path, used, res);
        return res;
    }
    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used,
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

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Permute1().permute(nums).toString());
    }
}
