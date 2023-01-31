package micro.NC;

import java.util.*;

/**
 * FileName: LIS91
 * author: gxs
 * Date: 2022/4/12  18:02
 */
public class LIS91 {
    static Integer[] res;
    public int[] LIS (int[] arr) {
        // write code here
        Deque<Integer> stack = new LinkedList<Integer>();
        if (arr.length == 0) {
            return new int[]{};
        }
        int maxLen = 1;

        for (int j : arr) {
            while (!stack.isEmpty() && j < stack.peek()) {
                stack.pop();
            }
            stack.push(j);
            if (maxLen <= stack.size()) {
                maxLen = stack.size();
                res = stack.toArray(new Integer[stack.size()]);
            }
        }
        int[] ans = new int[res.length];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[ans.length - 1 - i] = res[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,8,6,4};
        LIS91 tes = new LIS91();
        System.out.println(Arrays.toString(new LIS91().LIS(nums)));
//        Deque<Integer> stack = new LinkedList<Integer>();
//        Deque<Integer> maxStack = new LinkedList<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        res = stack.toArray(new Integer[stack.size()]);
//        System.out.println(Arrays.toString(res) + " res ");
//        stack.pop();
//        System.out.println(maxStack);
    }
}
