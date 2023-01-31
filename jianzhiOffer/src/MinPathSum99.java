/**
 * FileName: MinPathSum99
 * author: gxs
 * Date: 2021/12/21  15:00
 */
public class MinPathSum99 {
/**
 * 矩阵中最小路径和
 *
 * */
    public int minPathSum(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                   dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1],dp[i - 1][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
    public int search(int[] coins) {
        int l = 0;
        int r = coins.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            int weight1 = 0;
            int weight2 = 0;
            for (int i = l; i < mid; i++) {
                weight1 += coins[i];
            }
            for (int i = mid; i < r; i++) {
                weight2 += coins[i];
            }
            if (weight1 > weight2) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
//        1,3,1],[1,5,1],[4,2,1
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
       // System.out.println(new MinPathSum99().minPathSum(nums));
        int[] num1 = {1,2,2,2,2,2};
        System.out.println(new MinPathSum99().search(num1));
    }
}
