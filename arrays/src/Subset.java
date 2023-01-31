import java.util.ArrayList;
import java.util.List;

/**
 * @auther gxs
 * @create 2020-11-26-22:04
 */


class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result =  subsets(nums);
        System.out.println(result);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    public static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
