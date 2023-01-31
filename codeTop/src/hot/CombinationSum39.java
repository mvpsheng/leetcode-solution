package hot;

import java.util.*;

/**
 * FileName: CombinationSum39
 * author: gxs
 * Date: 2021/11/22  18:03
 */
public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (len == 0){
            return res;
        }
//        排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<Integer>();
        dfs(candidates, 0, len, target, res, path);
        return res;
    }
/**
 * @param candidates 候选数组
 * @param begin      搜索起点
 * @param len        荣誉变量
 * @param target     每减去一个变量，目标值变小
 * @param path       从根节点到叶子节点的路径
 * @param res        结果集列表
 * */
    private void dfs(int[] candidates, int begin, int len, int target, List<List<Integer>> res, Deque<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
//        从begin开始搜索
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
//            每个元素可以重复使用，所以下一轮的搜索依然从i开始
            dfs(candidates, i, len, target - candidates[i], res, path);
//            状态重置
            path.removeLast();
        }
    }
}
