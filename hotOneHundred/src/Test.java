import java.util.Arrays;
import java.util.LinkedList;

/**
 * FileName: Test
 * author: gxs
 * Date: 2021/9/14  22:26
 */
public class Test {
    private static int[] ways(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[nums.length];
        stack.add(0);
        int i = 1;
        while (i < nums.length){
            while (!stack.isEmpty() && nums[i] > nums[stack.getFirst()]) {
                res[stack.getFirst()] = i - stack.getFirst();
                stack.pop();
            }
                stack.push(i);
            i++;
            }
        for (int j = 0; j < res.length; j++) {
            if (res[j] == 0) {
                res[j] = -1;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] input = {7,6,5};
        System.out.println(Arrays.toString(ways(input)));
    }
}
