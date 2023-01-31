package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FileName: MinimumTotal120
 * author: gxs
 * Date: 2021/10/30  9:53
 */
public class MinimumTotal120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
//        动态规划方法
////        dp[i][j]表示从点（i，j）到底边的最小路径和。
//        int[][] dp = new int[n + 1][n + 1];
////        从三角型的最后一行开始递推
//        for (int i = n - 1; i >= 0 ; i--) {
//            for (int j = 0; j <= i; j++) {
//                dp[i][j] = Math.min(dp[i + 1][j],dp[i + 1][j + 1])
//                        + triangle.get(i).get(j);
//            }
//        }
//        return dp[0][0];


//        空间优化版本
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
//[2],[3,4],[6,5,7],[4,1,8,3][[-1],[2,3],[1,-1,-3]]
    public static void main(String[] args) {
        List<Integer> x1 = Arrays.asList(-1);
        List<Integer> x2 = Arrays.asList(2,3);
        List<Integer> x3 = Arrays.asList(1,-1,-3);
    //    List<Integer> x4 = Arrays.asList(4,1,8,3);
        List<List<Integer>> res =Arrays.asList(x1,x2,x3);// {{2},{3,4},{6,5,7}};
        System.out.println(new MinimumTotal120().minimumTotal(res));
    }
}
