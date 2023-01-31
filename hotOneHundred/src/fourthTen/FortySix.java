package fourthTen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * FileName: FourtySix
 * author: gxs
 * Date: 2021/9/18  13:27
 */
public class FortySix {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num :
                nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n,output,res,0);
        return res;
    }
    public void backtrack(int n,List<Integer> output,List<List<Integer>> res,int first) {
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
//            动态维护数组
            Collections.swap(output,first,i);
//            继续递归填下一个数
            backtrack(n,output,res,first + 1);
//            撤销操作
            Collections.swap(output,first,i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        FortySix fortySix = new FortySix();

        List<List<Integer>> input = fortySix.permute(nums);
        System.out.println(input.toString());
    }
}
