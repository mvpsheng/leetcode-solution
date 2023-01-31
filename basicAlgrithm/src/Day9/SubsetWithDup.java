package Day9;

import java.util.*;

/**
 * FileName: SubsetWithDup
 * author: gxs
 * Date: 2021/8/21  20:29
 */
public class SubsetWithDup {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur, ans);
        return new ArrayList<>(ans);
    }

    /**
     * @param nums 原输入数组
     * @param u 当前决策到原输入数组中的哪一位
     * @param cur 当前方案
     * @param ans 最终结果集
     */
     static void dfs(int[] nums, int u, List<Integer> cur, Set<List<Integer>> ans) {
        // 所有位置都决策完成，将当前方案放入结果集
        if (nums.length == u) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        // 选择当前位置的元素，往下决策
        cur.add(nums[u]);
        dfs(nums, u + 1, cur, ans);

        // 不选当前位置的元素（回溯），往下决策
        cur.remove(cur.size() - 1);
        dfs(nums, u + 1, cur, ans);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums).toString());
        System.out.println(subsetsWithDup(nums).size());
    }
}
