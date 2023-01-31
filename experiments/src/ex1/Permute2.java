package ex1;

/**
 * FileName: Permute2
 * author: gxs
 * Date: 2021/10/8  20:06
 */

import java.util.*;

/**
 * 有重复元素的全排列问题
 * */
public class Permute2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
//        排序，排序是剪枝的前提
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
//        Deque是官方Stack的建议类
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, res);
        return res;
    }
    private void dfs(int[] nums, int len, int depth, boolean[] used,
                     Deque<Integer> path, List<List<Integer>> res) {
//        如果堆栈满了就加入结果
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

//      剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
//      写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
            continue;
        }
        path.addLast(nums[i]);
        used[i] = true;

        dfs(nums, len, depth + 1, used, path, res);
//        回溯部分的代码，和dfs之前的代码是对称的
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(new Permute2().permuteUnique(nums).toString());
    }
}
