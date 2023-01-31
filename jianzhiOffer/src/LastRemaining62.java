import java.util.HashMap;
import java.util.Map;

/**
 * FileName: LastRemaining62
 * author: gxs
 * Date: 2022/1/17  9:40
 */
public class LastRemaining62 {
    public int lastRemaining(int n, int m) {
        int index = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
//        for (int i = 2; i <= n; i++) {
//
//        }
        for (int i = n; i > 1; i--) {
            index = (index + m - 1) % i;
            System.out.println(index + " num:" + nums[index] + " i:" + i);
        }
        return index;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        System.out.println(new LastRemaining62().lastRemaining(n, m));
    }
}
