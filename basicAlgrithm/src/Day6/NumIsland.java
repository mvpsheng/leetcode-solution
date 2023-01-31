package Day6;

/**
 * FileName: NumIsland
 * author: gxs
 * Date: 2021/8/18  15:50
 */
public class NumIsland {
    /**
     *  public int numIslands(char[][] grid) {
     *         if (grid == null || grid.length == 0) {
     *             return 0;
     *         }
     *
     *         int nr = grid.length;
     *         int nc = grid[0].length;
     *         int num_islands = 0;
     *
     *         for (int r = 0; r < nr; ++r) {
     *             for (int c = 0; c < nc; ++c) {
     *                 if (grid[r][c] == '1') {
     *                     ++num_islands;
     *                     grid[r][c] = '0';
     *                     Queue<Integer> neighbors = new LinkedList<>();
     *                     neighbors.add(r * nc + c);
     *                     while (!neighbors.isEmpty()) {
     *                         int id = neighbors.remove();
     *                         int row = id / nc;
     *                         int col = id % nc;
     *                         if (row - 1 >= 0 && grid[row-1][col] == '1') {
     *                             neighbors.add((row-1) * nc + col);
     *                             grid[row-1][col] = '0';
     *                         }
     *                         if (row + 1 < nr && grid[row+1][col] == '1') {
     *                             neighbors.add((row+1) * nc + col);
     *                             grid[row+1][col] = '0';
     *                         }
     *                         if (col - 1 >= 0 && grid[row][col-1] == '1') {
     *                             neighbors.add(row * nc + col-1);
     *                             grid[row][col-1] = '0';
     *                         }
     *                         if (col + 1 < nc && grid[row][col+1] == '1') {
     *                             neighbors.add(row * nc + col+1);
     *                             grid[row][col+1] = '0';
     *                         }
     *                     }
     *                 }
     *             }
     *         }
     *
     *         return num_islands;
     *     }
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * */
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}
