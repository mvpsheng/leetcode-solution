/**
 * FileName: MaxValue47
 * author: gxs
 * Date: 2022/1/15  17:51
 */
public class MaxValue47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0 && i > 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else if (i > 0){
                    grid[i][j] = grid[i][j] + Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
