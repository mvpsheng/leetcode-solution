package tencent;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * FileName: LargestRectangleArea
 * author: gxs
 * Date: 2021/12/3  11:10
 */
public class LargestRectangleArea84 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        return res;
    }
}
