package aboveOneHundred;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * FileName: DailyTemperatures
 * author: gxs
 * Date: 2021/9/27  0:08
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
//        用数组元素下标来压栈和计算差值
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
    public void call() {
        int[] ans = {73,74,75,71,69,72,76,73};
        dailyTemperatures(ans);
    }
    public static void main(String[] args) {
        int[] ans = {73,74,75,71,69,72,76,73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures(ans)));
    }
}
