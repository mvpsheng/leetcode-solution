package everydayOneQuestion;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * FileName: MinimumMoves
 * author: gxs
 * Date: 2023/2/5  19:26
 */
public class MinimumMoves1210 {
    /**
     *  0. 题号
     *      1210. 穿过迷宫的最少移动次数
     *  1. 约束分析
     *      n * n 的单元格， n [2, 100]
     *      单元格的内容是[0, 1]
     *      从左上角(0, 0) 和 (0, 1)到右下角(n-1, n-2) 和 (n-1, n-1)
     *      0表示可以走，1表示障碍
     *      设可以移动 向右，向下， 顺时针旋转，逆时针旋转
     *      求到达目的地，移动最少次数
     *  2. 思路
     *      方法一：
     *      动态规划
     *      判断当前位置可以如何到达，
     *      然后分析各种动作需要的步骤，每一步取最小值
     *
     *      方法二：
     *      广度优先搜索
     *
     *  3. 数据结构与算法选择、复杂度分析
     *      时间： 对二维矩阵进行广度优先搜索，所以是O(N * N)
     *      空间： 需要用到辅助二维数组空间，所以是O(N * N)
     *  4. 核心代码
     *
     *  5. 测试
     * */
    public int minimumMoves(int[][] grid) {
//        方法1： 广度优先搜索
        int n = grid.length;
        int[][][] dist = new int[n][n][2];
        for (int[][] dis : dist) {
            for (int[] di : dis) {
                Arrays.fill(di, -1);
            }
        }
        dist[0][0][0] = 0;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] res = queue.poll();
            int x = res[0], y = res[1], status = res[2];
            if (status == 0) {
//                向右移动一个单元格
                if (y + 2 < n && dist[x][y + 1][0] == -1 && grid[x][y + 2] == 0) {
                    dist[x][y + 1][0] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x, y + 1, 0});
                }
//                向下移动一个单元格
                if (x + 1 < n && dist[x + 1][y][0] == -1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x + 1][y][0] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x + 1, y, 0});
                }
//                顺时针旋转90度
                if (x + 1 < n && y + 1 < n && dist[x][y][1] == -1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y][1] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x, y, 1});
                }
            } else {
//                向右移动一个单元格
                if (y + 1 < n && dist[x][y + 1][1] == -1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y + 1][1] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x, y + 1, 1});
                }
//                向下移动一个单元格
                if (x + 2 < n && dist[x + 1][y][1] == -1 && grid[x + 2][y] == 0) {
                    dist[x + 1][y][1] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x + 1, y, 1});
                }
//                逆时针旋转90度
                if (x + 1 < n && y + 1 < n && dist[x][y][0] == -1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y][0] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x, y, 0});
                }
            }
        }
        return dist[n - 1][n - 2][0];
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0,0,0,0,1,1},
                {1,1,0,0,0,1},
                {1,1,1,0,0,1},
                {1,1,1,0,1,1},
                {1,1,1,0,0,1},
                {1,1,1,0,0,0}
                };
        System.out.println(new MinimumMoves1210().minimumMoves(grid));
    }
}
