package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * FileName: Merge56
 * author: gxs
 * Date: 2021/11/15  15:39
 */
public class Merge56 {
    public int[][] merge(int[][] intervals) {
       if (intervals.length == 0) {
           return new int[0][2];
       }
       Arrays.sort(intervals, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               return o1[0] - o2[0];
           }
       });
       List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L,R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(R,merged.get(merged.size() - 1)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] test = {{1,4},{0,2},{4,5}};
        System.out.println(Arrays.deepToString(new Merge56().merge(test)));
    }
}
